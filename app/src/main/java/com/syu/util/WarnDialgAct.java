package com.syu.util;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

public class WarnDialgAct extends BaseActivity {
    private ImageView close;
    private TextView info;
    private final Runnable r = new Runnable() { 
        @Override
        public void run() {
            WarnDialgAct.this.finish();
        }
    };
    private TextView title;
    public static String TITLE = "TITLE";
    public static String INFO = "INFO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.warn_dlg);
        this.title = findViewById(R.id.tv_title);
        this.info = findViewById(R.id.tv_info1);
        handlerIntent(getIntent());
        this.close = bindViewOnClick(R.id.btn_close, new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                WarnDialgAct.this.finish();
            }
        });
        HandlerRemove.getInstance().postDelayed(this.r, 10000L);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handlerIntent(intent);
    }

    void handlerIntent(Intent intent) {
        String strtitle = intent.getStringExtra(TITLE);
        String strinfo = intent.getStringExtra(INFO);
        this.title.setText(strtitle);
        this.info.setText(strinfo);
    }
}
