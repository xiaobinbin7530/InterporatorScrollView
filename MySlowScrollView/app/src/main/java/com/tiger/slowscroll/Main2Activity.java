package com.tiger.slowscroll;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends Activity implements View.OnClickListener {

    private Button bt_jump_first;
    private Button bt_jump_second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        bt_jump_first = (Button) findViewById(R.id.bt_jump_first);
        bt_jump_second = (Button) findViewById(R.id.bt_jump_second);

        bt_jump_first.setOnClickListener(this);
        bt_jump_second.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_jump_first:
                startActivity(new Intent(Main2Activity.this, MainActivity.class));
                break;
            case R.id.bt_jump_second:
                startActivity(new Intent(Main2Activity.this, InterpolatorActivity.class));
                break;
        }
    }
}
