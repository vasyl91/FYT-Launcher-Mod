package com.syu.carinfo.daojun.lexus;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class djLexusAirControlAct extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.daojun.lexus.djLexusAirControlAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 1:
                    djLexusAirControlAct.this.mUpdateBlowAutoOn();
                    break;
                case 2:
                    djLexusAirControlAct.this.mUpdateAcOn();
                    break;
                case 3:
                    djLexusAirControlAct.this.mUpdateCycle();
                    break;
                case 4:
                    djLexusAirControlAct.this.mUpdateAutoOn();
                    break;
                case 5:
                    djLexusAirControlAct.this.mUpdateDualOn();
                    break;
                case 8:
                    djLexusAirControlAct.this.mUpdateFrontDefrost();
                    break;
                case 9:
                    djLexusAirControlAct.this.mUpdateRearDefrost();
                    break;
                case 11:
                case 12:
                case 13:
                    djLexusAirControlAct.this.updateBtnSource();
                    break;
                case 14:
                    djLexusAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 15:
                    djLexusAirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 16:
                    djLexusAirControlAct.this.mUpdateAirTempRight();
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
        setContentView(R.layout.layout_0439_od_lexus_air_control);
        init();
    }

    private void init() {
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_munits).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_plus).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_dual).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
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
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data0 = 12;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 13;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 10;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 7;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 6;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 1;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 3;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 4;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 8;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 14;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 15;
                break;
            case R.id.air_xts_mode_munits /* 2131427455 */:
                data0 = 17;
                break;
            case R.id.air_xts_mode_plus /* 2131427456 */:
                data0 = 16;
                break;
            case R.id.air_xts_dual /* 2131427460 */:
                data0 = 2;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                data0 = 5;
                break;
        }
        if (event.getAction() == 0) {
            sendCmd(data0, 1);
        } else if (event.getAction() == 1) {
            sendCmd(data0, 0);
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[15];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
            } else if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((((temp + 36) - 1) * 0.5f) + "℃");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[16];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
            } else if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((((temp + 36) - 1) * 0.5f) + "℃");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[4];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateDualOn() {
        int acOn = DataCanbus.DATA[5];
        findViewById(R.id.air_xts_dual).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_dual_n : R.drawable.ic_xts_dual_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[2];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBlowAutoOn() {
        int power = DataCanbus.DATA[1];
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[3];
        if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        } else if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[8];
        findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[9];
        findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[14];
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(leave).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBtnSource() {
        int window = DataCanbus.DATA[11];
        int foot = DataCanbus.DATA[13];
        int body = DataCanbus.DATA[12];
        int mode = 0;
        if (foot == 1) {
            mode = 0 | 1;
        } else if (foot == 0) {
            mode = 0 & 254;
        }
        if (body == 1) {
            mode |= 2;
        } else if (body == 0) {
            mode &= 253;
        }
        if (window == 1) {
            mode |= 4;
        } else if (window == 0) {
            mode &= 251;
        }
        switch (mode) {
            case 0:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
                break;
            case 1:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot);
                break;
            case 2:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body);
                break;
            case 3:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body);
                break;
            case 4:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_win);
                break;
            case 5:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_win);
                break;
            case 6:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body_win);
                break;
            case 7:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body_win);
                break;
            default:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
                break;
        }
    }
}
