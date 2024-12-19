package com.syu.carinfo.oudi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class OD_Lamborghini_PanelButton extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.oudi.OD_Lamborghini_PanelButton.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 87:
                    OD_Lamborghini_PanelButton.this.findViewById(R.id.Button10).setBackgroundResource(value == 1 ? R.drawable.ic_lamborghini_big_light_p : R.drawable.ic_lamborghini_big_light_n);
                    break;
                case 88:
                    OD_Lamborghini_PanelButton.this.findViewById(R.id.Button11).setBackgroundResource(value == 1 ? R.drawable.ic_lamborghini_wulight_p : R.drawable.ic_lamborghini_wulight_n);
                    break;
                case 89:
                    OD_Lamborghini_PanelButton.this.findViewById(R.id.Button9).setBackgroundResource(value == 1 ? R.drawable.ic_lamborghini_esp_off_p : R.drawable.ic_lamborghini_esp_off_n);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_od_lamborghini_carinfo);
        setSelfClick((Button) findViewById(R.id.Button1), this);
        setSelfClick((Button) findViewById(R.id.Button2), this);
        setSelfClick((Button) findViewById(R.id.Button3), this);
        setSelfClick((Button) findViewById(R.id.Button4), this);
        setSelfClick((Button) findViewById(R.id.Button5), this);
        setSelfClick((Button) findViewById(R.id.Button6), this);
        setSelfClick((Button) findViewById(R.id.Button7), this);
        setSelfClick((Button) findViewById(R.id.Button8), this);
        setSelfClick((Button) findViewById(R.id.Button9), this);
        setSelfClick((Button) findViewById(R.id.Button10), this);
        setSelfClick((Button) findViewById(R.id.Button11), this);
        setSelfClick((Button) findViewById(R.id.Button12), this);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        int cmd = 0;
        switch (id) {
            case R.id.Button1 /* 2131427898 */:
                cmd = 65;
                break;
            case R.id.Button2 /* 2131427899 */:
                cmd = 64;
                break;
            case R.id.Button3 /* 2131427900 */:
                cmd = 63;
                break;
            case R.id.Button4 /* 2131427901 */:
                cmd = 62;
                break;
            case R.id.Button9 /* 2131427902 */:
                cmd = 58;
                break;
            case R.id.Button5 /* 2131427903 */:
                cmd = 69;
                break;
            case R.id.Button6 /* 2131427904 */:
                cmd = 68;
                break;
            case R.id.Button7 /* 2131427905 */:
                cmd = 67;
                break;
            case R.id.Button8 /* 2131427906 */:
                cmd = 66;
                break;
            case R.id.Button10 /* 2131428592 */:
                cmd = 70;
                break;
            case R.id.Button11 /* 2131428593 */:
                cmd = 71;
                break;
            case R.id.Button12 /* 2131428594 */:
                cmd = 72;
                break;
        }
        if (cmd != 0) {
            DataCanbus.PROXY.cmd(1, new int[]{cmd}, null, null);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
    }
}
