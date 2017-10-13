package com.tiger.slowscroll;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.tiger.mylibrary.SlowScrollView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_first;
    private ImageView iv_second;
    private ImageView iv_three;
    private LinearLayout linekong;
    private SlowScrollView lineKongScrollView;
    private ImageView iv_four;
    private ImageView iv_five;
    private ImageView iv_six;
    private LinearLayout ll_first;
    private LinearLayout ll_second;
    private LinearLayout ll_three;
    private LinearLayout ll_four;
    private LinearLayout ll_five;
    private LinearLayout ll_six;
    private Button bt_jumpFive;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                lineKongScrollView.smoothScrollToSlow(0, (int) ll_five.getY(), 2000);
//            }
//        }, 2000);
    }

    private void initView() {
        iv_first = (ImageView) findViewById(R.id.iv_first);
        iv_second = (ImageView) findViewById(R.id.iv_second);
        iv_three = (ImageView) findViewById(R.id.iv_three);
        linekong = (LinearLayout) findViewById(R.id.linekong);
        lineKongScrollView = (SlowScrollView) findViewById(R.id.lineKongScrollView);
        iv_four = (ImageView) findViewById(R.id.iv_four);
        iv_five = (ImageView) findViewById(R.id.iv_five);
        iv_six = (ImageView) findViewById(R.id.iv_six);


        ll_first = (LinearLayout) findViewById(R.id.ll_first);

        ll_second = (LinearLayout) findViewById(R.id.ll_second);

        ll_three = (LinearLayout) findViewById(R.id.ll_three);

        ll_four = (LinearLayout) findViewById(R.id.ll_four);

        ll_five = (LinearLayout) findViewById(R.id.ll_five);

        ll_six = (LinearLayout) findViewById(R.id.ll_six);

        bt_jumpFive = (Button) findViewById(R.id.bt_jumpFive);
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
