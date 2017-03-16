package com.tyh.activityanim;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView main_btn;
    private Button main_start;
    private Button main_stop;
    private ImageView main_iv;


    private AnimationDrawable anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        main_btn = (TextView) findViewById(R.id.main_btn);
        main_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NewActivity.class));
                //设置activity的切换动画 下一个页面的进入动画 和当前页面的滑出动画
                overridePendingTransition(R.anim.anim_activity_in, R.anim.anim_activity_out);
            }
        });

        main_start = (Button) findViewById(R.id.main_start);
        main_stop = (Button) findViewById(R.id.main_stop);
        main_iv = (ImageView) findViewById(R.id.main_iv);
        //获取动画
        anim = (AnimationDrawable) main_iv.getDrawable();
        //设置是否播放一次
        anim.setOneShot(false);

        main_start.setOnClickListener(this);
        main_stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_start:
                //动画开始
                anim.start();
                break;
            case R.id.main_stop:
                //动画停止
                anim.stop();
                break;
        }
    }
}
