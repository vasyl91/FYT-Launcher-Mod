package com.syu.carinfo.wc2.weichai;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WC2WeiChaiAirControlAct extends BaseActivity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc2.weichai.WC2WeiChaiAirControlAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    WC2WeiChaiAirControlAct.this.updateAirPower();
                    break;
                case 4:
                    WC2WeiChaiAirControlAct.this.updateAirCycle();
                    break;
                case 5:
                    WC2WeiChaiAirControlAct.this.updateRearDefrost();
                    break;
                case 6:
                    WC2WeiChaiAirControlAct.this.updateFrontDefrost();
                    break;
                case 11:
                    WC2WeiChaiAirControlAct.this.updateWindMode();
                    break;
                case 12:
                    WC2WeiChaiAirControlAct.this.updateWindValue();
                    break;
                case 13:
                    WC2WeiChaiAirControlAct.this.updateTempValue();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc2_weichai_airsetting);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfTouch(R.id.air_xts_front, this);
        setSelfTouch(R.id.air_xts_rear, this);
        setSelfTouch(R.id.btn_air_temp_left_plus, this);
        setSelfTouch(R.id.btn_air_temp_left_minus, this);
        setSelfTouch(R.id.btn_air_temp_right_plus, this);
        setSelfTouch(R.id.btn_air_temp_right_minus, this);
        setSelfTouch(R.id.dj_xts_air_win_plus_btn, this);
        setSelfTouch(R.id.dj_xts_air_win_minuts_btn, this);
        setSelfTouch(R.id.air_xts_ac, this);
        setSelfTouch(R.id.air_xts_power, this);
        setSelfTouch(R.id.air_cycle_outer, this);
        setSelfTouch(R.id.air_cycle_inter, this);
        setSelfTouch(R.id.air_xts_mode_body, this);
        setSelfTouch(R.id.air_xts_mode_footbody, this);
        setSelfTouch(R.id.air_xts_mode_foot, this);
        setSelfTouch(R.id.air_xts_mode_footwin, this);
    }

    private void setSelfTouch(int rsid, View.OnTouchListener l) {
        View v = findViewById(rsid);
        if (v != null && l != null) {
            v.setOnTouchListener(l);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int value = 0;
        switch (v.getId()) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                value = 13;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                value = 14;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                value = 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                value = 12;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                value = 11;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                value = 5;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                value = 29;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                value = 26;
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                value = 27;
                break;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                value = 28;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                value = 6;
                break;
            case R.id.air_cycle_outer /* 2131427557 */:
                if (DataCanbus.DATA[4] == 1) {
                    value = 7;
                    break;
                }
            case R.id.air_cycle_inter /* 2131427558 */:
                if (DataCanbus.DATA[4] == 0) {
                    value = 7;
                    break;
                }
        }
        if (value != 0) {
            if (event.getAction() == 0) {
                cmd(value, 1);
            } else if (event.getAction() == 1) {
                cmd(value, 0);
            }
        }
        return false;
    }

    private void cmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(1, new int[]{data0, data1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        AirHelper.disableAirWindowLocal(true);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWindMode() {
        boolean body = false;
        boolean footbody = false;
        boolean foot = false;
        boolean footwin = false;
        switch (DataCanbus.DATA[11]) {
            case 3:
                foot = true;
                break;
            case 5:
                footbody = true;
                break;
            case 6:
                body = true;
                break;
            case 12:
                footwin = true;
                break;
        }
        findViewById(R.id.air_xts_mode_foot).setSelected(foot);
        findViewById(R.id.air_xts_mode_body).setSelected(body);
        findViewById(R.id.air_xts_mode_footbody).setSelected(footbody);
        findViewById(R.id.air_xts_mode_footwin).setSelected(footwin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempValue() {
        float value = DataCanbus.DATA[13];
        if (value == 254.0f) {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
        } else if (value == 255.0f) {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HIGH");
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HIGH");
        } else {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(value / 2.0f) + "℃");
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(value / 2.0f) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWindValue() {
        int value = DataCanbus.DATA[12];
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder(String.valueOf(value)).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAirPower() {
        int value = DataCanbus.DATA[0];
        findViewById(R.id.air_xts_power).setSelected(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAirCycle() {
        int value = DataCanbus.DATA[4];
        if (((Button) findViewById(R.id.air_cycle_outer)) != null) {
            ((Button) findViewById(R.id.air_cycle_outer)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_cycle_out_p : R.drawable.ic_xts_cycle_n);
        }
        if (((Button) findViewById(R.id.air_cycle_inter)) != null) {
            ((Button) findViewById(R.id.air_cycle_inter)).setBackgroundResource(value == 1 ? R.drawable.ic_cycle_all_p : R.drawable.ic_cycle_all_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFrontDefrost() {
        int value = DataCanbus.DATA[6];
        findViewById(R.id.air_xts_front).setSelected(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRearDefrost() {
        int value = DataCanbus.DATA[5];
        findViewById(R.id.air_xts_rear).setSelected(value != 0);
    }
}