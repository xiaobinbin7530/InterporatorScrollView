package com.tiger.mylibrary;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ScrollView;
import android.widget.Scroller;

import com.tiger.mylibrary.interpolator.Ease;
import com.tiger.mylibrary.interpolator.EasingInterpolator;

import java.lang.reflect.Field;


public class InterpolatorScrollView extends ScrollView {
	private View inner;
	private static final String TAG = "SlowScrollView";
	private OnScrollListener onScrollListener;

	private boolean keyScrollDown;
	private boolean keyScrollUp;

	private Scroller mScroller;
	Interpolator easingInterpolator = new EasingInterpolator(Ease.CUBIC_IN_OUT);
	private Context context;
	public InterpolatorScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		mScroller = new Scroller(context,easingInterpolator);//, new DecelerateInterpolator(2));//
	}

	public InterpolatorScrollView(Context context) {
		super(context);
		this.context = context;
		mScroller =  new Scroller(context,easingInterpolator);//, new DecelerateInterpolator(2));
	}

	public InterpolatorScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.context = context;
		mScroller = new Scroller(context,easingInterpolator);//, new DecelerateInterpolator(2));
	}


	@Override
	protected void onFinishInflate() {
		if (getChildCount() > 0) {
			inner = getChildAt(0);
		}
	}
	// 调用此方法滚动到目标位置 duration滚动时间
	public void smoothScrollToSlow(int fx, int fy, int duration) {
		int dx = fx - getScrollX();// mScroller.getFinalX(); 普通view使用这种方法
		int dy = fy - getScrollY(); // mScroller.getFinalY();
		smoothScrollBySlow(dx, dy, duration);
	}

	// 调用此方法设置滚动的相对偏移
	public void smoothScrollBySlow(int dx, int dy, int duration) {
		// 设置mScroller的滚动偏移量
		mScroller.startScroll(getScrollX(), getScrollY(), dx, dy, duration);// scrollView使用的方法（因为可以触摸拖动）
		// mScroller.startScroll(mScroller.getFinalX(), mScroller.getFinalY(),
		// dx, dy, duration); //普通view使用的方法
		invalidate();// 这里必须调用invalidate()才能保证computeScroll()会被调用，否则不一定会刷新界面，看不到滚动效果
	}

	@Override
	public void computeScroll() {

		// 先判断mScroller滚动是否完成
		if (mScroller.computeScrollOffset()) {
			// 这里调用View的scrollTo()完成实际的滚动
			scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
			// 必须调用该方法，否则不一定能看到滚动效果
			postInvalidate();
		}
		// super.computeScroll();
	}


	/**
	 * 
	 * 滚动的回调接口
	 * 
	 * @author xiaanming
	 * 
	 */
	public interface OnScrollListener {
		/**
		 * 回调方法， 返回MyScrollView滑动的Y方向距离
		 * 
		 * @param scrollY
		 *            、
		 */
		public void onScroll(int scrollY);
	}

	/**
	 * 设置滚动接口
	 * 
	 * @param onScrollListener
	 */
	public void setOnScrollListener(OnScrollListener onScrollListener) {
		this.onScrollListener = onScrollListener;
	}

	@Override
	public int computeVerticalScrollRange() {
		return super.computeVerticalScrollRange();
	}
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		if (onScrollListener != null) {
			onScrollListener.onScroll(t);
		}
	}
	@Override
	protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
		super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
			return false;
		} else if (keyCode == KeyEvent.KEYCODE_DPAD_UP) {
			return false;
		}
		return super.onKeyDown(keyCode, event);
	}

	public boolean isKeyScrollDown() {
		return keyScrollDown;
	}

	public void setKeyScrollDown(boolean keyScrollDown) {
		this.keyScrollDown = keyScrollDown;
	}

	public boolean isKeyScrollUp() {
		return keyScrollUp;
	}

	public void setKeyScrollUp(boolean keyScrollUp) {
		this.keyScrollUp = keyScrollUp;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void requestChildFocus(View child, View focused) {
		try {
			Class<ScrollView> clazz = (Class<ScrollView>) getClass().getSuperclass();
			Field mIsLayoutDirtyField = clazz.getDeclaredField("mIsLayoutDirty");
			mIsLayoutDirtyField.setAccessible(true);
			mIsLayoutDirtyField.set(this, true);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		super.requestChildFocus(child, focused);
	}
	
	public boolean isFinishScroll()
	{
		return mScroller.isFinished();
	}
	@Override
	public boolean executeKeyEvent(KeyEvent event) {
		if (event.getAction() == KeyEvent.ACTION_DOWN && InterpolatorScrollView.this.hasFocus()) {
			switch (event.getKeyCode()) {
				case KeyEvent.KEYCODE_DPAD_UP:

//					SoundEffect.getInstance(context).playSystemSound(SoundEffectConstants.NAVIGATION_UP);
					break;
				case KeyEvent.KEYCODE_DPAD_DOWN:
//					SoundEffect.getInstance(context).playSystemSound(SoundEffectConstants.NAVIGATION_DOWN);
					break;
			}
		}
		return super.executeKeyEvent(event);
	}

}