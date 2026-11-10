package com.syu.carinfo.mzd.cx5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityHaiMaV70Index extends Activity {
    CheckedTextView mCtvAirControl;
    CheckedTextView mCtvInfo;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_237_index);
        this.mCtvInfo = (CheckedTextView) findViewById(R.id.haima_car_settings);
        this.mCtvAirControl = (CheckedTextView) findViewById(R.id.haima_air_control);
        this.mCtvInfo.setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.cx5.ActivityHaiMaV70Index.1
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case 0:
                        DataCanbus.PROXY.cmd(0, 176, 1);
                        return true;
                    case 1:
                        DataCanbus.PROXY.cmd(0, 176, 0);
                        return true;
                    default:
                        return true;
                }
            }
        });
        this.mCtvAirControl.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.mzd.cx5.ActivityHaiMaV70Index.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intent intent = new Intent(ActivityHaiMaV70Index.this, (Class<?>) HaiMaV70AirControl.class);
                ActivityHaiMaV70Index.this.startActivity(intent);
            }
        });
    }
}
