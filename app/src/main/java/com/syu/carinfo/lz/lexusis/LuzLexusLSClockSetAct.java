package com.syu.carinfo.lz.lexusis;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LuzLexusLSClockSetAct extends BaseActivity {
    private final int delay = 200;
    private Button mBtnHour;
    private Button mBtnMin;
    private Button mBtnSet;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mazida);
        this.mBtnSet = (Button) findViewById(R.id.mzd_btn_set);
        this.mBtnSet.setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.lz.lexusis.LuzLexusLSClockSetAct.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{81}, null, null);
                }
                return false;
            }
        });
        this.mBtnHour = (Button) findViewById(R.id.mzd_btn_hour);
        this.mBtnHour.setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.lz.lexusis.LuzLexusLSClockSetAct.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{81, 1}, null, null);
                    return false;
                }
                return false;
            }
        });
        this.mBtnMin = (Button) findViewById(R.id.mzd_btn_min);
        this.mBtnMin.setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.lz.lexusis.LuzLexusLSClockSetAct.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{81, 2}, null, null);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mBtnSet.setText("HOUR");
        this.mBtnHour.setText("MIN");
        this.mBtnMin.setText(":00");
        this.mBtnMin.setVisibility(0);
    }
}
