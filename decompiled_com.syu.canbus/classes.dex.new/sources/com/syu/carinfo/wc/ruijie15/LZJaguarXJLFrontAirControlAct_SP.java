package com.syu.carinfo.wc.ruijie15;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.ui.air.AirHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LZJaguarXJLFrontAirControlAct_SP extends Activity implements View.OnTouchListener {
    public static LZJaguarXJLFrontAirControlAct_SP mInstance;
    public static boolean mIsFront = false;
    int TempUnit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ruijie15.LZJaguarXJLFrontAirControlAct_SP.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                    LZJaguarXJLFrontAirControlAct_SP.this.mUpdatePowerOn();
                    break;
                case 11:
                    LZJaguarXJLFrontAirControlAct_SP.this.mUpdateAcOn();
                    break;
                case 12:
                    LZJaguarXJLFrontAirControlAct_SP.this.mUpdateCycle();
                    break;
                case 13:
                    LZJaguarXJLFrontAirControlAct_SP.this.mUpdateAutoOn();
                    break;
                case 16:
                    LZJaguarXJLFrontAirControlAct_SP.this.mUpdateRearDefrost();
                    break;
                case 17:
                    LZJaguarXJLFrontAirControlAct_SP.this.mUpdateMaxFrontOn();
                    break;
                case 18:
                case 19:
                case 20:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_455_LZ_Jaguar_S_TYPE_Low /* 16122311 */:
                        case FinalCanbus.CAR_455_LZ_Jaguar_X_TYPE_Low /* 16187847 */:
                            LZJaguarXJLFrontAirControlAct_SP.this.mUpdaterBlowMode();
                            break;
                        default:
                            LZJaguarXJLFrontAirControlAct_SP.this.mUpdaterBlowWindow();
                            LZJaguarXJLFrontAirControlAct_SP.this.mUpdaterBlowBodyLeftOn();
                            LZJaguarXJLFrontAirControlAct_SP.this.mUpdaterBlowFootLeftOn();
                            break;
                    }
                    break;
                case 21:
                    LZJaguarXJLFrontAirControlAct_SP.this.mUpdaterAirWindLevelLeft();
                    break;
                case 22:
                    LZJaguarXJLFrontAirControlAct_SP.this.mUpdaterBlowWindowRight();
                    break;
                case 23:
                    LZJaguarXJLFrontAirControlAct_SP.this.mUpdaterBlowBodyRightOn();
                    break;
                case 24:
                    LZJaguarXJLFrontAirControlAct_SP.this.mUpdaterBlowFootRightOn();
                    break;
                case 27:
                    LZJaguarXJLFrontAirControlAct_SP.this.mUpdateAirTempLeft();
                    break;
                case 28:
                    LZJaguarXJLFrontAirControlAct_SP.this.mUpdateAirTempRight();
                    break;
                case 29:
                    LZJaguarXJLFrontAirControlAct_SP.this.mUpdaterSeatHeatLeft();
                    break;
                case 30:
                    LZJaguarXJLFrontAirControlAct_SP.this.mUpdaterSeatHeatRight();
                    break;
                case 34:
                    LZJaguarXJLFrontAirControlAct_SP.this.findViewById(R.id.air_xts_nanoe).setBackgroundResource(value == 0 ? R.drawable.ic_xts_nanoe_n : R.drawable.ic_xts_nanoe_p);
                    break;
                case 53:
                    LZJaguarXJLFrontAirControlAct_SP.this.findViewById(R.id.air_xts_maxac).setBackgroundResource(value == 0 ? R.drawable.ic_xts_maxac_n : R.drawable.ic_xts_maxac_p);
                    break;
                case 62:
                    LZJaguarXJLFrontAirControlAct_SP.this.mUpdateDualOn();
                    break;
                case 65:
                    LZJaguarXJLFrontAirControlAct_SP.this.mUpdateFrontDefrost();
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
        String platform = SystemProperties.get("ro.fyt.platform", "");
        if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform) || "6318".equals(platform) || "6319".equals(platform) || "6321".equals(platform) || "890A".equals(platform)) {
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_455_LZ_Jaguar_S_TYPE_Low /* 16122311 */:
                    setContentView(R.layout.layout_0452_lz_jaguar_stype_air_control_9853);
                    break;
                case FinalCanbus.CAR_455_LZ_Jaguar_X_TYPE_Low /* 16187847 */:
                    setContentView(R.layout.layout_0452_lz_jaguar_xtype_air_control_9853);
                    break;
                default:
                    setContentView(R.layout.layout_0452_lz_jaguar_air_control_9853);
                    break;
            }
        } else {
            setContentView(R.layout.layout_0452_lz_jaguar_air_control_7731);
        }
        init();
        mInstance = this;
    }

    private void init() {
        if (findViewById(R.id.air_xts_mode_body) != null) {
            findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_mode_win) != null) {
            findViewById(R.id.air_xts_mode_win).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_mode_win_right) != null) {
            findViewById(R.id.air_xts_mode_win_right).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_mode_body_right) != null) {
            findViewById(R.id.air_xts_mode_body_right).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_mode_foot_right) != null) {
            findViewById(R.id.air_xts_mode_foot_right).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_mode_foot) != null) {
            findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_mode) != null) {
            findViewById(R.id.air_xts_mode).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_mode_footbody) != null) {
            findViewById(R.id.air_xts_mode_footbody).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_mode_footwin) != null) {
            findViewById(R.id.air_xts_mode_footwin).setOnTouchListener(this);
        }
        findViewById(R.id.air_xts_sync).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_maxac).setOnTouchListener(this);
        findViewById(R.id.air_xts_front_hot).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_rearpage).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_nanoe).setOnTouchListener(this);
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
                data0 = 1;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 2;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 11;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 6;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 5;
                break;
            case R.id.air_xts_seathot_left /* 2131427433 */:
                data0 = 19;
                break;
            case R.id.air_xts_mode /* 2131427434 */:
                data0 = 16;
                break;
            case R.id.air_xts_seathot_right /* 2131427435 */:
                data0 = 20;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 10;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 9;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 12;
                break;
            case R.id.air_xts_front_hot /* 2131427439 */:
                data0 = 29;
                break;
            case R.id.air_xts_ac /* 2131427440 */:
                data0 = 8;
                break;
            case R.id.air_xts_maxac /* 2131427441 */:
                data0 = 51;
                break;
            case R.id.air_xts_sync /* 2131427442 */:
                data0 = 7;
                break;
            case R.id.air_xts_mode_foot /* 2131427444 */:
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_455_LZ_Jaguar_X_TYPE_Low /* 16187847 */:
                        data0 = 16;
                        break;
                    default:
                        data0 = 25;
                        break;
                }
                break;
            case R.id.air_xts_mode_body /* 2131427445 */:
                data0 = 14;
                break;
            case R.id.air_xts_mode_win /* 2131427446 */:
                data0 = 27;
                break;
            case R.id.air_xts_rearpage /* 2131427449 */:
                flag = true;
                try {
                    startActivity(new Intent(this, (Class<?>) LZJaguarXJLRearAirControlAct_SP.class));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_air_temp_right_plus /* 2131427450 */:
                data0 = 3;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427452 */:
                data0 = 4;
                break;
            case R.id.air_xts_seatwin_left /* 2131427453 */:
                data0 = 30;
                break;
            case R.id.air_xts_seatwin_right /* 2131427455 */:
                data0 = 31;
                break;
            case R.id.air_xts_mode_footbody /* 2131427555 */:
                data0 = 15;
                break;
            case R.id.air_xts_rear /* 2131427643 */:
                data0 = 13;
                break;
            case R.id.air_xts_mode_footwin /* 2131427735 */:
                data0 = 17;
                break;
            case R.id.air_xts_nanoe /* 2131428727 */:
                data0 = 56;
                break;
            case R.id.air_xts_mode_win_right /* 2131428736 */:
                data0 = 28;
                break;
            case R.id.air_xts_mode_body_right /* 2131428737 */:
                data0 = 24;
                break;
            case R.id.air_xts_mode_foot_right /* 2131428738 */:
                data0 = 26;
                break;
        }
        if (!flag) {
            if (event.getAction() == 0) {
                sendCmd(8, data0);
            } else if (event.getAction() == 1) {
                sendCmd(8, 0);
            }
        }
        return false;
    }

    private void addUpdater() {
        this.TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSeatHeatRight() {
        int value = DataCanbus.DATA[30];
        if ((value & 8) != 0) {
            int value2 = 16 - value;
            findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level0);
            switch (value2) {
                case 0:
                    findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level0);
                    break;
                case 1:
                    findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level1);
                    break;
                case 2:
                    findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level2);
                    break;
                case 3:
                    findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level3);
                    break;
            }
        }
        findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level0);
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level0);
                break;
            case 1:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level1);
                break;
            case 2:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level2);
                break;
            case 3:
                findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSeatHeatLeft() {
        int value = DataCanbus.DATA[29];
        if ((value & 8) != 0) {
            int value2 = 16 - value;
            findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level0);
            switch (value2) {
                case 0:
                    findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level0);
                    break;
                case 1:
                    findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level1);
                    break;
                case 2:
                    findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level2);
                    break;
                case 3:
                    findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level3);
                    break;
            }
        }
        findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level0);
        switch (value) {
            case 0:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level0);
                break;
            case 1:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level1);
                break;
            case 2:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level2);
                break;
            case 3:
                findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateMaxFrontOn() {
        int power = DataCanbus.DATA[17];
        findViewById(R.id.air_xts_front_hot).setBackgroundResource(power == 0 ? R.drawable.ic_xts_fronthot_n : R.drawable.ic_xts_fronthot_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("High");
                return;
            }
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("None");
            } else if (this.TempUnit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp * 0.5f) + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((((temp * 9) + 320) / 10.0f) + "℉");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[28];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("High");
                return;
            }
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("None");
            } else if (this.TempUnit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp * 0.5f) + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((((temp * 9) + 320) / 10.0f) + "℉");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[13];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateDualOn() {
        int acOn = DataCanbus.DATA[62];
        findViewById(R.id.air_xts_sync).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_sync_n : R.drawable.ic_xts_sync_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[10];
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
        } else if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[65];
        findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[16];
        findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[21];
        if (leave < 0) {
            leave = 0;
        }
        if (leave > 8) {
            leave = 8;
        }
        String str = " " + leave + " ";
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowBodyLeftOn() {
        int acOn = DataCanbus.DATA[19];
        if (findViewById(R.id.air_xts_mode_body) != null) {
            findViewById(R.id.air_xts_mode_body).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowFootLeftOn() {
        int acOn = DataCanbus.DATA[20];
        if (findViewById(R.id.air_xts_mode_foot) != null) {
            findViewById(R.id.air_xts_mode_foot).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowWindow() {
        int acOn = DataCanbus.DATA[18];
        if (findViewById(R.id.air_xts_mode_win) != null) {
            findViewById(R.id.air_xts_mode_win).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_win_n : R.drawable.ic_xts_mode_win_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowMode() {
        int up = DataCanbus.DATA[18];
        int body = DataCanbus.DATA[19];
        int foot = DataCanbus.DATA[20];
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
        if (up == 1) {
            mode |= 4;
        } else if (up == 0) {
            mode &= 251;
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_LZ_Jaguar_S_TYPE_Low /* 16122311 */:
                if (findViewById(R.id.air_xts_mode) != null) {
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
                break;
            case FinalCanbus.CAR_455_LZ_Jaguar_X_TYPE_Low /* 16187847 */:
                if (findViewById(R.id.air_xts_mode_body) != null) {
                    findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
                }
                if (findViewById(R.id.air_xts_mode_foot) != null) {
                    findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
                }
                if (findViewById(R.id.air_xts_mode_footbody) != null) {
                    findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
                }
                if (findViewById(R.id.air_xts_mode_footwin) != null) {
                    findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
                }
                switch (mode) {
                    case 1:
                        if (findViewById(R.id.air_xts_mode_foot) != null) {
                            findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
                        }
                        break;
                    case 2:
                        if (findViewById(R.id.air_xts_mode_body) != null) {
                            findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
                        }
                        break;
                    case 3:
                        if (findViewById(R.id.air_xts_mode_footbody) != null) {
                            findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
                        }
                        break;
                    case 5:
                        if (findViewById(R.id.air_xts_mode_footwin) != null) {
                            findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
                        }
                        break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowBodyRightOn() {
        int acOn = DataCanbus.DATA[23];
        if (findViewById(R.id.air_xts_mode_body_right) != null) {
            findViewById(R.id.air_xts_mode_body_right).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowFootRightOn() {
        int acOn = DataCanbus.DATA[24];
        if (findViewById(R.id.air_xts_mode_foot_right) != null) {
            findViewById(R.id.air_xts_mode_foot_right).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowWindowRight() {
        int acOn = DataCanbus.DATA[22];
        if (findViewById(R.id.air_xts_mode_win_right) != null) {
            findViewById(R.id.air_xts_mode_win_right).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_win_n : R.drawable.ic_xts_mode_win_p);
        }
    }
}
