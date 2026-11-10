package com.syu.carinfo.lz.lexusis;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LuzLexusLSClockSetAct extends BaseActivity {
    private final int delay = 200;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mazida);
        ((Button) findViewById(R.id.mzd_btn_set)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.lz.lexusis.LuzLexusLSClockSetAct.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{81, 0}, null, null);
                }
                return false;
            }
        });
        ((Button) findViewById(R.id.mzd_btn_hour)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.lz.lexusis.LuzLexusLSClockSetAct.2
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
        ((Button) findViewById(R.id.mzd_btn_min)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.lz.lexusis.LuzLexusLSClockSetAct.3
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
        ((Button) findViewById(R.id.mzd_btn_set)).setText("HOUR");
        ((Button) findViewById(R.id.mzd_btn_hour)).setText("MIN");
        ((Button) findViewById(R.id.mzd_btn_min)).setText(":00");
        ((Button) findViewById(R.id.mzd_btn_min)).setVisibility(0);
    }
}
