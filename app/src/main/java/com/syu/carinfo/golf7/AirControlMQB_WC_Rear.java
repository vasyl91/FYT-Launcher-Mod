package com.syu.carinfo.golf7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class AirControlMQB_WC_Rear extends Activity implements View.OnClickListener {
    public static boolean mIsFront = false;
    int cmdId = 0;
    int value = -1;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.AirControlMQB_WC_Rear.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 123:
                    AirControlMQB_WC_Rear.this.mUpdatePowerOn();
                    break;
                case 154:
                    AirControlMQB_WC_Rear.this.mUpdateAirTempLeft();
                    break;
                case 205:
                    AirControlMQB_WC_Rear.this.mUpdaterAirWindLevelLeft();
                    break;
                case 207:
                    AirControlMQB_WC_Rear.this.mUpdateAutoOn();
                    break;
                case 220:
                    AirControlMQB_WC_Rear.this.updateSeatHotLeft(DataCanbus.DATA[updateCode]);
                    break;
                case 221:
                    AirControlMQB_WC_Rear.this.updateSeatHotRight(DataCanbus.DATA[updateCode]);
                    break;
                case 222:
                    AirControlMQB_WC_Rear.this.updateBlowMode();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0017_wc_mqb_air_rear_control);
        init();
    }

    private void init() {
        findViewById(R.id.btn_air_temp_left_plus).setOnClickListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnClickListener(this);
        findViewById(R.id.air_xts_power).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnClickListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnClickListener(this);
        findViewById(R.id.air_xts_frontpage).setOnClickListener(this);
        findViewById(R.id.air_xts_seathot_left).setOnClickListener(this);
        findViewById(R.id.air_xts_mode).setOnClickListener(this);
        findViewById(R.id.air_xts_seathot_right).setOnClickListener(this);
        findViewById(R.id.air_xts_auto).setOnClickListener(this);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        this.value = 0;
        this.cmdId = 0;
        switch (v.getId()) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                this.cmdId = 22;
                this.value = DataCanbus.DATA[154] & 255;
                if (DataCanbus.DATA[156] == 0) {
                    if (this.value == 254 || this.value < 32) {
                        this.value = 32;
                        break;
                    } else if (this.value == 255 || this.value >= 59) {
                        this.value = 255;
                        break;
                    } else {
                        this.value++;
                        break;
                    }
                } else if (this.value == 254 || this.value < 120) {
                    this.value = 120;
                    break;
                } else if (this.value == 255 || this.value > 172) {
                    this.value = 255;
                    break;
                } else {
                    this.value += 2;
                    break;
                }
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                this.cmdId = 22;
                this.value = DataCanbus.DATA[154] & 255;
                if (DataCanbus.DATA[156] == 0) {
                    if (this.value == 254 || this.value <= 32) {
                        this.value = 254;
                        break;
                    } else if (this.value == 255) {
                        this.value = 59;
                        break;
                    } else {
                        this.value--;
                        break;
                    }
                } else if (this.value == 254 || this.value <= 120) {
                    this.value = 254;
                    break;
                } else if (this.value == 255) {
                    this.value = 172;
                    break;
                } else {
                    this.value -= 2;
                    break;
                }
            case R.id.air_xts_power /* 2131427428 */:
                this.cmdId = 39;
                this.value = DataCanbus.DATA[123] != 0 ? 0 : 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                this.cmdId = 41;
                this.value = DataCanbus.DATA[205] - 1;
                if (this.value <= 0) {
                    this.value = 0;
                    break;
                }
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                this.cmdId = 41;
                this.value = DataCanbus.DATA[205] + 1;
                if (this.value >= 7) {
                    this.value = 7;
                    break;
                }
            case R.id.air_xts_frontpage /* 2131427432 */:
                try {
                    startActivity(new Intent(this, (Class<?>) AirControlMQB_WC_Front.class));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case R.id.air_xts_seathot_left /* 2131427433 */:
                this.cmdId = 43;
                this.value = DataCanbus.DATA[220] + 1;
                if (this.value > 3) {
                    this.value = 0;
                    break;
                }
            case R.id.air_xts_mode /* 2131427434 */:
                this.cmdId = 42;
                this.value = DataCanbus.DATA[222];
                if (this.value == 0) {
                    this.value = 1;
                    break;
                } else if (this.value == 3) {
                    this.value = 2;
                    break;
                } else if (this.value == 5) {
                    this.value = 1;
                    break;
                } else if (this.value == 6) {
                    this.value = 3;
                    break;
                }
            case R.id.air_xts_seathot_right /* 2131427435 */:
                this.cmdId = 44;
                this.value = DataCanbus.DATA[221] + 1;
                if (this.value > 3) {
                    this.value = 0;
                    break;
                }
            case R.id.air_xts_auto /* 2131427436 */:
                this.cmdId = 40;
                this.value = 1;
                break;
        }
        if (this.value >= 0 && this.cmdId > 0) {
            setAirCmd(this.cmdId, this.value);
        }
    }

    private void setAirCmd(int cmdCode, int value) {
        DataCanbus.PROXY.cmd(107, new int[]{cmdCode, value}, null, null);
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[207].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[222].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[220].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[221].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[207].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[222].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[220].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[221].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSeatHotRight(int value) {
        if (((Button) findViewById(R.id.air_xts_seathot_right)) != null) {
            switch (value) {
                case 0:
                    ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level0);
                    break;
                case 1:
                    ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level1);
                    break;
                case 2:
                    ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level2);
                    break;
                case 3:
                    ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level3);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSeatHotLeft(int value) {
        if (((Button) findViewById(R.id.air_xts_seathot_left)) != null) {
            switch (value) {
                case 0:
                    ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level0);
                    break;
                case 1:
                    ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level1);
                    break;
                case 2:
                    ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level2);
                    break;
                case 3:
                    ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level3);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowMode() {
        int value = DataCanbus.DATA[222];
        if (((Button) findViewById(R.id.air_xts_mode)) != null) {
            switch (value) {
                case 0:
                    ((Button) findViewById(R.id.air_xts_mode)).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
                    break;
                case 3:
                    ((Button) findViewById(R.id.air_xts_mode)).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
                    break;
                case 5:
                    ((Button) findViewById(R.id.air_xts_mode)).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
                    break;
                case 6:
                    ((Button) findViewById(R.id.air_xts_mode)).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAutoOn() {
        int power = DataCanbus.DATA[207];
        findViewById(R.id.air_xts_auto).setBackgroundResource(power == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[154];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            switch (temp) {
                case 254:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                    break;
                case 255:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HIGHT");
                    break;
                default:
                    if (DataCanbus.DATA[156] == 0) {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 2.0f) + "℃");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 2.0f) + "℉");
                        break;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[123];
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[205];
        if (leave < 0) {
            leave = 0;
        }
        if (leave > 8) {
            leave = 8;
        }
        String str = " " + leave + " ";
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
    }
}