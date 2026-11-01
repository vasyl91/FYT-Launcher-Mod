package com.syu.carinfo.oudi;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZC_Jeep_PanelButton extends BaseActivity implements View.OnTouchListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.oudi.RZC_Jeep_PanelButton.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 170:
                    RZC_Jeep_PanelButton.this.findViewById(R.id.btn_plus1).setBackgroundResource(value == 1 ? R.drawable.ic_rzc_jeep_button1_p : R.drawable.ic_rzc_jeep_button1_n);
                    break;
                case 171:
                    RZC_Jeep_PanelButton.this.findViewById(R.id.btn_plus2).setBackgroundResource(value == 1 ? R.drawable.ic_rzc_jeep_button2_p : R.drawable.ic_rzc_jeep_button2_n);
                    break;
                case 172:
                    RZC_Jeep_PanelButton.this.findViewById(R.id.btn_plus3).setBackgroundResource(value == 1 ? R.drawable.ic_rzc_jeep_button3_p : R.drawable.ic_rzc_jeep_button3_n);
                    break;
                case 173:
                    RZC_Jeep_PanelButton.this.findViewById(R.id.btn_plus4).setBackgroundResource(value == 1 ? R.drawable.ic_rzc_jeep_button4_p : R.drawable.ic_rzc_jeep_button4_n);
                    break;
                case 174:
                    RZC_Jeep_PanelButton.this.findViewById(R.id.btn_plus5).setBackgroundResource(value == 1 ? R.drawable.ic_rzc_jeep_button5_p : R.drawable.ic_rzc_jeep_button5_n);
                    break;
                case 175:
                    RZC_Jeep_PanelButton.this.findViewById(R.id.btn_plus6).setBackgroundResource(value == 1 ? R.drawable.ic_rzc_jeep_button6_p : R.drawable.ic_rzc_jeep_button6_n);
                    break;
                case 176:
                    RZC_Jeep_PanelButton.this.findViewById(R.id.btn_plus7).setBackgroundResource(value == 1 ? R.drawable.ic_rzc_jeep_button7_p : R.drawable.ic_rzc_jeep_button7_n);
                    break;
                case 177:
                    RZC_Jeep_PanelButton.this.findViewById(R.id.btn_plus8).setBackgroundResource(value == 1 ? R.drawable.ic_rzc_jeep_button8_p : R.drawable.ic_rzc_jeep_button8_n);
                    break;
                case 226:
                    RZC_Jeep_PanelButton.this.findViewById(R.id.btn_plus9).setBackgroundResource(value == 1 ? R.drawable.ic_rzc_jeep_button9_p : R.drawable.ic_rzc_jeep_button9_n);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0373_rzc_jeep_panelbutton);
        findViewById(R.id.btn_plus1).setOnTouchListener(this);
        findViewById(R.id.btn_plus2).setOnTouchListener(this);
        findViewById(R.id.btn_plus3).setOnTouchListener(this);
        findViewById(R.id.btn_plus4).setOnTouchListener(this);
        findViewById(R.id.btn_plus5).setOnTouchListener(this);
        findViewById(R.id.btn_plus6).setOnTouchListener(this);
        findViewById(R.id.btn_plus7).setOnTouchListener(this);
        findViewById(R.id.btn_plus8).setOnTouchListener(this);
        findViewById(R.id.btn_plus9).setOnTouchListener(this);
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

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int cmd = 0;
        switch (id) {
            case R.id.btn_plus1 /* 2131427458 */:
                cmd = 8;
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                cmd = 7;
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                cmd = 6;
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                cmd = 5;
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                cmd = 4;
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                cmd = 3;
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                cmd = 2;
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                cmd = 1;
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                cmd = 9;
                break;
        }
        if (event.getAction() == 0) {
            DataCanbus.PROXY.cmd(5, new int[]{cmd, 1}, null, null);
        } else if (event.getAction() == 1) {
            DataCanbus.PROXY.cmd(5, new int[]{cmd, 0}, null, null);
        }
        return false;
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[226].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[226].removeNotify(this.mNotifyCanbus);
    }
}
