package com.syu.carinfo.xc.gongjue;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class XCTianLaiGjAirControlAct extends BaseActivity implements View.OnTouchListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xc.gongjue.XCTianLaiGjAirControlAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 11:
                    XCTianLaiGjAirControlAct.this.updateAirAC();
                    break;
                case 12:
                    XCTianLaiGjAirControlAct.this.updateAirCycle();
                    break;
                case 13:
                    XCTianLaiGjAirControlAct.this.updateAirAuto();
                    break;
                case 14:
                    XCTianLaiGjAirControlAct.this.updateAirDual();
                    break;
                case 16:
                    XCTianLaiGjAirControlAct.this.updateRearDefrost();
                    break;
                case 21:
                    XCTianLaiGjAirControlAct.this.updateWindValue();
                    break;
                case 27:
                    XCTianLaiGjAirControlAct.this.updateLeftTempValue();
                    break;
                case 28:
                    XCTianLaiGjAirControlAct.this.updateRightTempValue();
                    break;
                case 65:
                    XCTianLaiGjAirControlAct.this.updateFrontDefrost();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_rzc_tianlai_airsetting);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfTouch(R.id.air_xts_front, this);
        setSelfTouch(R.id.air_xts_rear, this);
        setSelfTouch(R.id.air_xts_auto, this);
        setSelfTouch(R.id.air_xts_mode, this);
        setSelfTouch(R.id.air_xts_dual, this);
        setSelfTouch(R.id.air_xts_cycle, this);
        setSelfTouch(R.id.btn_air_temp_left_plus, this);
        setSelfTouch(R.id.btn_air_temp_left_minus, this);
        setSelfTouch(R.id.btn_air_temp_right_plus, this);
        setSelfTouch(R.id.btn_air_temp_right_minus, this);
        setSelfTouch(R.id.dj_xts_air_win_plus_btn, this);
        setSelfTouch(R.id.dj_xts_air_win_minuts_btn, this);
        setSelfTouch(R.id.air_xts_ac, this);
    }

    private void setSelfTouch(int rsid, View.OnTouchListener l) {
        View v = findViewById(rsid);
        if (v != null && l != null) {
            v.setOnTouchListener(l);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int value = 0;
        switch (v.getId()) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                value = 12;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                value = 13;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                value = 9;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                value = 10;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                value = 4;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                value = 2;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                value = 5;
                break;
            case R.id.air_xts_ac /* 2131427440 */:
                value = 1;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427450 */:
                value = 13;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427452 */:
                value = 14;
                break;
            case R.id.air_xts_rear /* 2131427643 */:
                value = 6;
                break;
            case R.id.air_xts_dual /* 2131427644 */:
                value = 7;
                break;
        }
        if (event.getAction() == 0) {
            cmd(value, 1);
        } else if (event.getAction() == 1) {
            cmd(value, 0);
        }
        return false;
    }

    private void cmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(1, new int[]{data0, data1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        AirHelper.disableAirWindowLocal(true);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLeftTempValue() {
        float value = DataCanbus.DATA[27];
        if (value == 0.0f) {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText("----");
        } else {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(17.5d + ((double) (value / 2.0f))) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRightTempValue() {
        float value = DataCanbus.DATA[28];
        if (value == 0.0f) {
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText("----");
        } else {
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(17.5d + ((double) (value / 2.0f))) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWindValue() {
        int value = DataCanbus.DATA[21];
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder(String.valueOf(value)).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAirAC() {
        int value = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_ac).setSelected(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAirDual() {
        int value = DataCanbus.DATA[14];
        findViewById(R.id.air_xts_dual).setSelected(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAirAuto() {
        int value = DataCanbus.DATA[13];
        findViewById(R.id.air_xts_auto).setSelected(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAirCycle() {
        int value = DataCanbus.DATA[12];
        findViewById(R.id.air_xts_cycle).setSelected(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFrontDefrost() {
        int value = DataCanbus.DATA[65];
        findViewById(R.id.air_xts_front).setSelected(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRearDefrost() {
        int value = DataCanbus.DATA[16];
        findViewById(R.id.air_xts_rear).setSelected(value != 0);
    }
}
