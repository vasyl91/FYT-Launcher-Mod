package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Activity_374_PanelButton extends BaseActivity implements View.OnTouchListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_374_PanelButton.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D70_D2_B7 /* 514 */:
                    Activity_374_PanelButton.this.findViewById(R.id.btn_plus7).setBackgroundResource(value == 1 ? R.drawable.ic_rzc_jeep_button7_p : R.drawable.ic_rzc_jeep_button7_n);
                    break;
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D70_D2_B6 /* 515 */:
                    Activity_374_PanelButton.this.findViewById(R.id.btn_plus4).setBackgroundResource(value == 1 ? R.drawable.ic_rzc_jeep_button4_p : R.drawable.ic_rzc_jeep_button4_n);
                    break;
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D70_D2_B5 /* 516 */:
                    Activity_374_PanelButton.this.findViewById(R.id.btn_plus9).setBackgroundResource(value == 1 ? R.drawable.ic_rzc_jeep_button9_p : R.drawable.ic_rzc_jeep_button9_n);
                    break;
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D70_D2_B4 /* 517 */:
                    Activity_374_PanelButton.this.findViewById(R.id.btn_plus8).setBackgroundResource(value == 1 ? R.drawable.ic_rzc_jeep_button8_p : R.drawable.ic_rzc_jeep_button8_n);
                    break;
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D70_D2_B3 /* 518 */:
                    Activity_374_PanelButton.this.findViewById(R.id.btn_plus6).setBackgroundResource(value == 1 ? R.drawable.ic_rzc_jeep_button6_p : R.drawable.ic_rzc_jeep_button6_n);
                    break;
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D70_D2_B2 /* 519 */:
                    Activity_374_PanelButton.this.findViewById(R.id.btn_plus5).setBackgroundResource(value == 1 ? R.drawable.ic_rzc_jeep_button5_p : R.drawable.ic_rzc_jeep_button5_n);
                    break;
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D70_D2_B1 /* 520 */:
                    Activity_374_PanelButton.this.findViewById(R.id.btn_plus1).setBackgroundResource(value == 1 ? R.drawable.ic_rzc_jeep_button1_p : R.drawable.ic_rzc_jeep_button1_n);
                    break;
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D70_D2_B0 /* 521 */:
                    Activity_374_PanelButton.this.findViewById(R.id.btn_plus2).setBackgroundResource(value == 0 ? R.drawable.ic_rzc_jeep_button2_p : R.drawable.ic_rzc_jeep_button2_n);
                    break;
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D70_D3_B7 /* 524 */:
                    Activity_374_PanelButton.this.findViewById(R.id.btn_plus3).setBackgroundResource(value == 1 ? R.drawable.ic_rzc_jeep_button3_p : R.drawable.ic_rzc_jeep_button3_n);
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        if (event.getAction() == 0) {
            switch (id) {
                case R.id.btn_plus1 /* 2131427419 */:
                    if (DataCanbus.DATA[520] == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{120, 0}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{120, 1}, null, null);
                    }
                    break;
                case R.id.btn_plus2 /* 2131427423 */:
                    if (DataCanbus.DATA[521] == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{121, 0}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{121, 1}, null, null);
                    }
                    break;
                case R.id.btn_plus3 /* 2131427427 */:
                    if (DataCanbus.DATA[524] == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{122, 0}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{122, 1}, null, null);
                    }
                    break;
                case R.id.btn_plus4 /* 2131427428 */:
                    if (DataCanbus.DATA[515] == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{115, 0}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{115, 1}, null, null);
                    }
                    break;
                case R.id.btn_plus5 /* 2131427429 */:
                    if (DataCanbus.DATA[519] == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{119, 0}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{119, 1}, null, null);
                    }
                    break;
                case R.id.btn_plus6 /* 2131427430 */:
                    if (DataCanbus.DATA[518] == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{118, 0}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{118, 1}, null, null);
                    }
                    break;
                case R.id.btn_plus7 /* 2131427431 */:
                    if (DataCanbus.DATA[514] == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{114, 0}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{114, 1}, null, null);
                    }
                    break;
                case R.id.btn_plus8 /* 2131427432 */:
                    if (DataCanbus.DATA[517] == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{117, 0}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{117, 1}, null, null);
                    }
                    break;
                case R.id.btn_plus9 /* 2131427433 */:
                    if (DataCanbus.DATA[516] == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{116, 0}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{116, 1}, null, null);
                    }
                    break;
            }
        } else {
            event.getAction();
        }
        return false;
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[520].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[521].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[524].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[515].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[519].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[518].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[514].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[517].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[516].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[520].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[521].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[524].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[515].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[519].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[518].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[514].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[517].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[516].removeNotify(this.mNotifyCanbus);
    }
}
