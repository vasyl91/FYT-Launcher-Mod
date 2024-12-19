package com.syu.carinfo.lz.lexusis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LuzLexusLSRearAirControlAct extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.lexusis.LuzLexusLSRearAirControlAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 76:
                    LuzLexusLSRearAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 77:
                    LuzLexusLSRearAirControlAct.this.mUpdateAirTempRight();
                    break;
                case 78:
                    LuzLexusLSRearAirControlAct.this.mUpdateManual();
                    break;
                case 79:
                    LuzLexusLSRearAirControlAct.this.mUpdateAutoOn();
                    break;
                case 80:
                    LuzLexusLSRearAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 81:
                    LuzLexusLSRearAirControlAct.this.mUpdateBlowOn();
                    break;
            }
        }
    };

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(0, new int[]{data0, data1}, null, null);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_lz_lexus_ls_rear_aircontrol);
        init();
    }

    private void init() {
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.air_xts_frontpage).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_manual).setOnTouchListener(this);
        findViewById(R.id.air_xts_blow).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addUpdater();
        AirHelper.disableAirWindowLocal(true);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeUpdater();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        boolean flag = false;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data0 = 42;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 41;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 61;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 48;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 49;
                break;
            case R.id.air_xts_frontpage /* 2131427432 */:
                flag = true;
                try {
                    startActivity(new Intent(this, (Class<?>) LuzLexusLSFrontAirControlAct.class));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 52;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 51;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 50;
                break;
            case R.id.air_xts_manual /* 2131427562 */:
                data0 = 59;
                break;
            case R.id.air_xts_blow /* 2131428582 */:
                data0 = 60;
                break;
        }
        if (!flag) {
            if (event.getAction() == 0) {
                sendCmd(data0, 1);
            } else if (event.getAction() == 1) {
                sendCmd(data0, 0);
            }
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[81].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[82].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBlowOn() {
        int acOn = DataCanbus.DATA[81];
        findViewById(R.id.air_xts_blow).setBackgroundResource(acOn == 0 ? R.drawable.ic_lexus_ls_blow_n : R.drawable.ic_lexus_ls_blow_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateManual() {
        int acOn = DataCanbus.DATA[78];
        switch (acOn) {
            case 0:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_0);
                break;
            case 1:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_1);
                break;
            case 2:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_2);
                break;
            case 3:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_3);
                break;
            case 4:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_4);
                break;
            case 5:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_5);
                break;
            case 6:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_6);
                break;
            case 7:
                findViewById(R.id.air_xts_manual).setBackgroundResource(R.drawable.ic_lexus_ls_manual_7);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[79];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int unit = DataCanbus.DATA[16];
        int temp = DataCanbus.DATA[76];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(((temp * 5) + 175) * 0.1f) + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(((((temp * 5) + 175) * 9) / 50) + 32) + "℉");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempRight() {
        int unit = DataCanbus.DATA[16];
        int temp = DataCanbus.DATA[77];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(((temp * 5) + 175) * 0.1f) + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(((((temp * 5) + 175) * 9) / 50) + 32) + "℉");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[80];
        if (leave < 0) {
            leave = 0;
        }
        if (leave > 8) {
            leave = 8;
        }
        String str = " " + leave + " ";
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
        findViewById(R.id.air_xts_power).setBackgroundResource(leave == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }
}
