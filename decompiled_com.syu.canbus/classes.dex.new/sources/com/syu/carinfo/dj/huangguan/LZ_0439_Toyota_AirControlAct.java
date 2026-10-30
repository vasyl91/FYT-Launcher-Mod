package com.syu.carinfo.dj.huangguan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.ui.air.AirHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LZ_0439_Toyota_AirControlAct extends Activity implements View.OnTouchListener {
    public static LZ_0439_Toyota_AirControlAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dj.huangguan.LZ_0439_Toyota_AirControlAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                    LZ_0439_Toyota_AirControlAct.this.mUpdaterAirPower();
                    break;
                case 11:
                    LZ_0439_Toyota_AirControlAct.this.mUpdaterAirAC();
                    break;
                case 12:
                    LZ_0439_Toyota_AirControlAct.this.mUpdateAirCycle();
                    break;
                case 13:
                    LZ_0439_Toyota_AirControlAct.this.mUpdateAirAuto();
                    break;
                case 14:
                    LZ_0439_Toyota_AirControlAct.this.mUpdateAirdual();
                    break;
                case 15:
                    LZ_0439_Toyota_AirControlAct.this.mUpdateAirFrontDefrost();
                    break;
                case 16:
                    LZ_0439_Toyota_AirControlAct.this.mUpdateAirRearDefrost();
                    break;
                case 17:
                    LZ_0439_Toyota_AirControlAct.this.mUpdaterAirCleanIce();
                    break;
                case 21:
                    LZ_0439_Toyota_AirControlAct.this.mUpdaterAirWindLevel();
                    break;
                case 27:
                    LZ_0439_Toyota_AirControlAct.this.mUpdaterAirTempLeft();
                    break;
                case 28:
                    LZ_0439_Toyota_AirControlAct.this.mUpdaterAirTempRight();
                    break;
                case 35:
                    LZ_0439_Toyota_AirControlAct.this.mUpdaterAirCleanSwing();
                    break;
                case 37:
                    LZ_0439_Toyota_AirControlAct.this.mUpdaterAirTempLeft();
                    LZ_0439_Toyota_AirControlAct.this.mUpdaterAirTempRight();
                    break;
                case 58:
                    LZ_0439_Toyota_AirControlAct.this.mUpdaterAirCleanFlower();
                    break;
                case 67:
                    LZ_0439_Toyota_AirControlAct.this.findViewById(R.id.air_xts_rear_light).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_light_n : R.drawable.ic_xts_rear_light_p);
                    break;
                case 76:
                    LZ_0439_Toyota_AirControlAct.this.mUpdaterAirClean();
                    break;
                case 77:
                    LZ_0439_Toyota_AirControlAct.this.mUpdateAirBlow();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11 /* 5177797 */:
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_18 /* 5243333 */:
                setContentView(R.layout.layout_0439_luz_toyota_cruiser_carairset);
                break;
            default:
                setContentView(R.layout.layout_0439_luz_toyota_carairset);
                break;
        }
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.air_xts_dual).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.air_xts_clear).setOnTouchListener(this);
        findViewById(R.id.air_xts_ion).setOnTouchListener(this);
        findViewById(R.id.air_xts_front_hot).setOnTouchListener(this);
        findViewById(R.id.air_xts_front_blow_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear_light).setOnTouchListener(this);
        if (TheApp.getConfiguration() == 1) {
            findViewById(R.id.air_xts_mode_left).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_rearpage) != null) {
            findViewById(R.id.air_xts_rearpage).setOnTouchListener(this);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        AirHelper.disableAirWindowLocal(true);
        mIsFront = true;
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        mIsFront = false;
        removeUpdater();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data0 = 3;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 2;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 9;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 10;
                break;
            case R.id.air_xts_mode /* 2131427434 */:
            case R.id.air_xts_mode_left /* 2131428456 */:
                data0 = 36;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 21;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 25;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 18;
                break;
            case R.id.air_xts_front_hot /* 2131427439 */:
                data0 = 26;
                break;
            case R.id.air_xts_ac /* 2131427440 */:
                data0 = 23;
                break;
            case R.id.air_xts_rearpage /* 2131427449 */:
                try {
                    startActivity(new Intent(this, (Class<?>) LZ_0439_Toyota_RearAirControlAct.class));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_air_temp_right_plus /* 2131427450 */:
                data0 = 5;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427452 */:
                data0 = 4;
                break;
            case R.id.air_xts_rear /* 2131427643 */:
                data0 = 20;
                break;
            case R.id.air_xts_dual /* 2131427644 */:
                data0 = 16;
                break;
            case R.id.air_xts_clear /* 2131427673 */:
                data0 = 32;
                break;
            case R.id.air_xts_ion /* 2131427674 */:
                data0 = 28;
                break;
            case R.id.air_xts_front_blow_auto /* 2131427675 */:
                data0 = 29;
                break;
            case R.id.air_xts_rear_light /* 2131427676 */:
                data0 = 42;
                break;
        }
        switch (event.getAction()) {
            case 0:
                DataCanbus.PROXY.cmd(22, new int[]{data0, 1}, null, null);
                return false;
            case 1:
                DataCanbus.PROXY.cmd(22, new int[]{data0, 0}, null, null);
                return false;
            default:
                return false;
        }
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirClean() {
        int value = DataCanbus.DATA[76];
        findViewById(R.id.air_xts_clear).setBackgroundResource(value == 0 ? R.drawable.ic_xts_clear_air_n : R.drawable.ic_xts_clear_air_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirCleanFlower() {
        int value = DataCanbus.DATA[58];
        findViewById(R.id.air_xts_ion).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ion_n : R.drawable.ic_xts_ion_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirCleanIce() {
        int value = DataCanbus.DATA[17];
        findViewById(R.id.air_xts_front_hot).setBackgroundResource(value == 0 ? R.drawable.ic_xts_fronthot_n : R.drawable.ic_xts_fronthot_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirCleanSwing() {
        int value = DataCanbus.DATA[35];
        findViewById(R.id.air_xts_front_blow_auto).setBackgroundResource(value == 0 ? R.drawable.ic_xts_blow_auto_n : R.drawable.ic_xts_blow_auto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirTempLeft() {
        int temp = DataCanbus.DATA[27];
        int unit = DataCanbus.DATA[37];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                    break;
                case -1:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("--");
                    break;
                default:
                    if (unit == 1) {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 10.0f) + "℉");
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 10.0f) + "℃");
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirTempRight() {
        int temp = DataCanbus.DATA[28];
        int unit = DataCanbus.DATA[37];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                    break;
                case -1:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("--");
                    break;
                default:
                    if (unit == 1) {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 10.0f) + "℉");
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 10.0f) + "℃");
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[21];
        if (level >= 0 && level <= 7) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirAuto() {
        int value = DataCanbus.DATA[13];
        findViewById(R.id.air_xts_auto).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirdual() {
        int value = DataCanbus.DATA[14];
        findViewById(R.id.air_xts_dual).setBackgroundResource(value == 0 ? R.drawable.ic_xts_dual_n : R.drawable.ic_xts_dual_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirCycle() {
        int value = DataCanbus.DATA[12];
        if (value == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        } else if (value == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirAC() {
        int value = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_ac).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[10];
        findViewById(R.id.air_xts_power).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirFrontDefrost() {
        int value = DataCanbus.DATA[15];
        findViewById(R.id.air_xts_front).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirRearDefrost() {
        int value = DataCanbus.DATA[16];
        findViewById(R.id.air_xts_rear).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirBlow() {
        int value = DataCanbus.DATA[77];
        if (TheApp.getConfiguration() == 1) {
            if (value == 3) {
                findViewById(R.id.air_xts_mode_left).setBackgroundResource(R.drawable.ic_xts_mode_foot_body);
            } else if (value == 5) {
                findViewById(R.id.air_xts_mode_left).setBackgroundResource(R.drawable.ic_xts_mode_foot_win);
            } else if (value == 2) {
                findViewById(R.id.air_xts_mode_left).setBackgroundResource(R.drawable.ic_xts_mode_body);
            } else if (value == 1) {
                findViewById(R.id.air_xts_mode_left).setBackgroundResource(R.drawable.ic_xts_mode_foot);
            } else if (value == 4) {
                findViewById(R.id.air_xts_mode_left).setBackgroundResource(R.drawable.ic_xts_mode_win);
            } else {
                findViewById(R.id.air_xts_mode_left).setBackgroundResource(R.drawable.ic_xts_mode_null);
            }
            if (value == 3) {
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_foot_body);
                return;
            }
            if (value == 5) {
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_foot_win);
                return;
            }
            if (value == 2) {
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_body);
                return;
            }
            if (value == 1) {
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_foot);
                return;
            } else if (value == 4) {
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_win);
                return;
            } else {
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_null);
                return;
            }
        }
        if (value == 3) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body);
            return;
        }
        if (value == 5) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_win);
            return;
        }
        if (value == 2) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body);
            return;
        }
        if (value == 1) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot);
        } else if (value == 4) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_win);
        } else {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
        }
    }
}
