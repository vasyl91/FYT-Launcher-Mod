package com.syu.carinfo.jili;

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
public class YuanJingX1_AirControlAct_DJ extends BaseActivity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    public int cmd_p = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.jili.YuanJingX1_AirControlAct_DJ.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 1:
                    YuanJingX1_AirControlAct_DJ.this.mUpdaterAirPower();
                    break;
                case 2:
                    YuanJingX1_AirControlAct_DJ.this.mUpdateAirCycle();
                    break;
                case 3:
                    YuanJingX1_AirControlAct_DJ.this.mUpdateAirRearDefrost();
                    break;
                case 4:
                    YuanJingX1_AirControlAct_DJ.this.mUpdaterAirAC();
                    break;
                case 5:
                    YuanJingX1_AirControlAct_DJ.this.mUpdaterAirWindLevel();
                    break;
                case 9:
                    YuanJingX1_AirControlAct_DJ.this.UTempLeft(DataCanbus.DATA[updateCode]);
                    break;
                case 10:
                    YuanJingX1_AirControlAct_DJ.this.UBlowMode_new(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_438_dj_yuanjing_air_control_set);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfTouch((Button) findViewById(R.id.btn_air_temp_left_plus), this);
        setSelfTouch((Button) findViewById(R.id.btn_air_temp_left_minus), this);
        setSelfTouch((Button) findViewById(R.id.btn_air_temp_right_plus), this);
        setSelfTouch((Button) findViewById(R.id.btn_air_temp_right_minus), this);
        setSelfTouch((Button) findViewById(R.id.air_xts_cycle), this);
        setSelfTouch((Button) findViewById(R.id.air_xts_mode), this);
        setSelfTouch((Button) findViewById(R.id.air_xts_power), this);
        setSelfTouch((Button) findViewById(R.id.air_xts_ac), this);
        setSelfTouch((Button) findViewById(R.id.air_xts_rear), this);
        setSelfTouch((Button) findViewById(R.id.dj_xts_air_win_minuts_btn), this);
        setSelfTouch((Button) findViewById(R.id.dj_xts_air_win_plus_btn), this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View arg0, MotionEvent arg1) {
        int cmd1 = 0;
        int cmd = 0;
        switch (arg0.getId()) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                cmd = 12;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                cmd = 13;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                cmd = 10;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                cmd = 7;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                cmd = 6;
                break;
            case R.id.air_xts_mode /* 2131427434 */:
                if (arg1.getAction() == 0) {
                    switch (DataCanbus.DATA[10]) {
                        case 2:
                        case 7:
                            cmd = 34;
                            break;
                        case 3:
                            cmd = 18;
                            break;
                        case 4:
                            cmd = 19;
                            break;
                        case 5:
                            cmd = 35;
                            break;
                        case 6:
                        case 8:
                            cmd = 33;
                            break;
                        default:
                            cmd = 33;
                            break;
                    }
                    this.cmd_p = cmd;
                    break;
                } else {
                    cmd = this.cmd_p;
                    break;
                }
            case R.id.air_xts_cycle /* 2131427437 */:
                cmd = 3;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                cmd = 8;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                cmd = 5;
                break;
        }
        if (arg1.getAction() == 0) {
            cmd1 = 1;
        }
        DataCanbus.PROXY.cmd(0, cmd, cmd1);
        return false;
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        AirHelper.disableAirWindowLocal(true);
        mIsFront = true;
        addUpdater();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        mIsFront = false;
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UTempLeft(int data) {
        String str;
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (data < 1) {
                str = "LOW";
            } else if (data >= 30) {
                str = "HI";
            } else {
                int data2 = (data * 5) + 165;
                str = String.valueOf(data2 / 10) + "." + (data2 % 10) + "℃";
            }
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText(str);
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[5];
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirCycle() {
        int value = DataCanbus.DATA[2];
        if (((Button) findViewById(R.id.air_xts_cycle)) != null) {
            ((Button) findViewById(R.id.air_xts_cycle)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_cycle_n : R.drawable.ic_xts_cycle_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirAC() {
        int value = DataCanbus.DATA[4];
        if (((Button) findViewById(R.id.air_xts_ac)) != null) {
            ((Button) findViewById(R.id.air_xts_ac)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirRearDefrost() {
        int value = DataCanbus.DATA[3];
        if (((Button) findViewById(R.id.air_xts_rear)) != null) {
            ((Button) findViewById(R.id.air_xts_rear)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[1];
        if (((Button) findViewById(R.id.air_xts_power)) != null) {
            ((Button) findViewById(R.id.air_xts_power)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UBlowMode_new(int i_mode) {
        int idDrawable = R.drawable.ic_xts_mode_null;
        switch (i_mode) {
            case 2:
            case 7:
                idDrawable = R.drawable.ic_xts_mode_win;
                break;
            case 3:
                idDrawable = R.drawable.ic_xts_mode_foot;
                break;
            case 4:
                idDrawable = R.drawable.ic_xts_mode_foot_body;
                break;
            case 5:
                idDrawable = R.drawable.ic_xts_mode_body;
                break;
            case 6:
            case 8:
                idDrawable = R.drawable.ic_xts_mode_foot_win;
                break;
        }
        if (((Button) findViewById(R.id.air_xts_mode)) != null && idDrawable != -1) {
            ((Button) findViewById(R.id.air_xts_mode)).setBackgroundResource(idDrawable);
        }
    }
}
