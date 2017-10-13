package com.tiger.slowscroll;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.tiger.mylibrary.InterpolatorScrollView;

public class InterpolatorActivity extends Activity implements View.OnClickListener {

    private Button bt_jumpFive;
    private ImageView iv_first;
    private LinearLayout ll_first;
    private ImageView iv_second;
    private LinearLayout ll_second;
    private ImageView iv_three;
    private LinearLayout ll_three;
    private ImageView iv_four;
    private LinearLayout ll_four;
    private ImageView iv_five;
    private LinearLayout ll_five;
    private ImageView iv_six;
    private LinearLayout ll_six;
    private LinearLayout linekong;
    private InterpolatorScrollView lineKongScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolator);
        initView();
    }

    private void initView() {
        bt_jumpFive = (Button) findViewById(R.id.bt_jumpFive);
        iv_first = (ImageView) findViewById(R.id.iv_first);
        ll_first = (LinearLayout) findViewById(R.id.ll_first);
        iv_second = (ImageView) findViewById(R.id.iv_second);
        ll_second = (LinearLayout) findViewById(R.id.ll_second);
        iv_three = (ImageView) findViewById(R.id.iv_three);
        ll_three = (LinearLayout) findViewById(R.id.ll_three);
        iv_four = (ImageView) findViewById(R.id.iv_four);
        ll_four = (LinearLayout) findViewById(R.id.ll_four);
        iv_five = (ImageView) findViewById(R.id.iv_five);
        ll_five = (LinearLayout) findViewById(R.id.ll_five);
        iv_six = (ImageView) findViewById(R.id.iv_six);
        ll_six = (LinearLayout) findViewById(R.id.ll_six);
        linekong = (LinearLayout) findViewById(R.id.linekong);
        lineKongScrollView = (InterpolatorScrollView) findViewById(R.id.lineKongScrollView);

        bt_jumpFive.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_jumpFive:
                lineKongScrollView.smoothScrollToSlow(0, (int) ll_five.getY(), 2000);
                break;
        }
    }
}
