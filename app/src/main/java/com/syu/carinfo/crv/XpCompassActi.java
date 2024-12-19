package com.syu.carinfo.crv;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XpCompassActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.crv.XpCompassActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 8:
                    XpCompassActi.this.compassArea();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_crv_compass);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.xp_crv_compass_calibration)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.crv.XpCompassActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(2);
            }
        });
        ((Button) findViewById(R.id.xp_crv_btn_compass_area_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.crv.XpCompassActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[8];
                if (value > 1) {
                    value--;
                }
                DataCanbus.PROXY.cmd(1, value);
            }
        });
        ((Button) findViewById(R.id.xp_crv_btn_compass_area_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.crv.XpCompassActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[8];
                if (value < 15) {
                    value++;
                }
                DataCanbus.PROXY.cmd(1, value);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void compassArea() {
        int value = DataCanbus.DATA[8];
        ((TextView) findViewById(R.id.xp_crv_tv_compass_area_plus)).setText(new StringBuilder().append(value).toString());
    }
}
