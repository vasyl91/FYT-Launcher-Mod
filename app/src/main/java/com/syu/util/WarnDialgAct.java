package com.syu.util;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WarnDialgAct extends BaseActivity {
    private ImageView close;
    private TextView info;
    private Runnable r = new Runnable() { // from class: com.syu.util.WarnDialgAct.1
        @Override // java.lang.Runnable
        public void run() {
            WarnDialgAct.this.finish();
        }
    };
    private TextView title;
    public static String TITLE = "TITLE";
    public static String INFO = "INFO";

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.warn_dlg);
        this.title = (TextView) findViewById(R.id.tv_title);
        this.info = (TextView) findViewById(R.id.tv_info1);
        handlerIntent(getIntent());
        this.close = (ImageView) bindViewOnClick(R.id.btn_close, new View.OnClickListener() { // from class: com.syu.util.WarnDialgAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                WarnDialgAct.this.finish();
            }
        });
        HandlerRemove.getInstance().postDelayed(this.r, 10000L);
    }

    @Override // android.app.Activity
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
