package com.syu.carinfo.oudi.hantengx5;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Oudi_0452_Hongqi_AirControlAct extends Activity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0452_Hongqi_AirControlAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 1:
                    Oudi_0452_Hongqi_AirControlAct.this.mUpdatePowerOn();
                    break;
                case 2:
                    Oudi_0452_Hongqi_AirControlAct.this.mUpdateAcOn();
                    break;
                case 4:
                    Oudi_0452_Hongqi_AirControlAct.this.mUpdateEcoOn();
                    break;
                case 5:
                    Oudi_0452_Hongqi_AirControlAct.this.mUpdateCycle();
                    break;
                case 6:
                    Oudi_0452_Hongqi_AirControlAct.this.mUpdateDualOn();
                    break;
                case 8:
                    Oudi_0452_Hongqi_AirControlAct.this.mUpdateColdHotOn();
                    break;
                case 9:
                case 10:
                case 11:
                    Oudi_0452_Hongqi_AirControlAct.this.updateBtnSource();
                    break;
                case 12:
                    Oudi_0452_Hongqi_AirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 13:
                    Oudi_0452_Hongqi_AirControlAct.this.mUpdateAirTempLeft();
                    break;
                case 14:
                    Oudi_0452_Hongqi_AirControlAct.this.mUpdateAirTempRight();
                    break;
            }
        }
    };

    private void sendCmd(int data0, int data1, int data2, int data3, int data4, int data5) {
        DataCanbus.PROXY.cmd(0, new int[]{data0, data1, data2, data3, data4, data5}, null, null);
        HandlerUI.getInstance().postDelayed(new Runnable() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0452_Hongqi_AirControlAct.2
            @Override // java.lang.Runnable
            public void run() {
                DataCanbus.PROXY.cmd(0, new int[6], null, null);
            }
        }, 100L);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_oudi_hongqi_air_control);
        init();
    }

    private void init() {
        findViewById(R.id.btn_air_temp_left_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnClickListener(this);
        findViewById(R.id.air_xts_ac).setOnClickListener(this);
        findViewById(R.id.air_xts_auto).setOnClickListener(this);
        findViewById(R.id.air_xts_econ).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnClickListener(this);
        findViewById(R.id.air_xts_power).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_body).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_footbody).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_footwin).setOnClickListener(this);
        findViewById(R.id.air_xts_mode_win).setOnClickListener(this);
        findViewById(R.id.air_xts_dual).setOnClickListener(this);
        findViewById(R.id.air_xts_cold_hot).setOnClickListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        DataCanbus.PROXY.cmd(2, new int[]{36}, null, null);
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

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        int data0 = 0;
        int data1 = 0;
        int data2 = 0;
        switch (id) {
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                int value = DataCanbus.DATA[12];
                if (value > 0) {
                    value--;
                }
                data1 = (value << 4) & 240;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                int value2 = DataCanbus.DATA[12];
                if (value2 < 7) {
                    value2++;
                }
                data1 = (value2 << 4) & 240;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 32;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 2;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                data2 = 96;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                data2 = 32;
                break;
            case R.id.air_xts_mode_win /* 2131427445 */:
                data2 = 160;
                break;
            case R.id.air_xts_dual /* 2131427460 */:
                data1 = 8;
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                data2 = 64;
                break;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                data2 = 128;
                break;
            case R.id.air_xts_econ /* 2131427561 */:
                data0 = 1;
                break;
            case R.id.air_xts_cold_hot /* 2131428596 */:
                data0 = 4;
                break;
        }
        sendCmd(data0, data1, data2, 0, 0, 0);
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateColdHotOn() {
        int acOn = DataCanbus.DATA[8];
        findViewById(R.id.air_xts_cold_hot).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_cold_hot_n : R.drawable.ic_xts_cold_hot_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateDualOn() {
        int acOn = DataCanbus.DATA[6];
        findViewById(R.id.air_xts_dual).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_dual_p : R.drawable.ic_xts_dual_n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[14];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
            } else if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((((temp * 5) + 175) / 10.0f) + "℃");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[13];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
            } else if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((((temp * 5) + 175) / 10.0f) + "℃");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateEcoOn() {
        int acOn = DataCanbus.DATA[4];
        findViewById(R.id.air_xts_econ).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_econ_n : R.drawable.ic_xts_econ_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[2];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[1];
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCycle() {
        int auto = DataCanbus.DATA[5];
        if (auto == 0) {
            findViewById(R.id.air_xts_auto).setBackgroundResource(R.drawable.ic_xts_auto_n);
        } else if (auto == 1) {
            findViewById(R.id.air_xts_auto).setBackgroundResource(R.drawable.ic_xts_auto_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        String str;
        int leave = DataCanbus.DATA[12];
        if (leave > 8) {
            str = "A";
        } else {
            str = " " + leave;
        }
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBtnSource() {
        int window = DataCanbus.DATA[9];
        int foot = DataCanbus.DATA[11];
        int body = DataCanbus.DATA[10];
        if (window == 0 && body == 1 && foot == 1) {
            findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
        } else {
            findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
        }
        if (window == 0 && body == 0 && foot == 1) {
            findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
        } else {
            findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
        }
        if (window == 0 && body == 1 && foot == 0) {
            findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
        } else {
            findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
        }
        if (window == 1 && body == 0 && foot == 1) {
            findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
        } else {
            findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
        }
        if (window == 1 && body == 0 && foot == 0) {
            findViewById(R.id.air_xts_mode_win).setBackgroundResource(R.drawable.ic_xts_mode_win_p);
        } else {
            findViewById(R.id.air_xts_mode_win).setBackgroundResource(R.drawable.ic_xts_mode_win_n);
        }
    }
}