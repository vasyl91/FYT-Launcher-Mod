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
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LZJaguarXJLRearAirControlAct_SP extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    int TempUnit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ruijie15.LZJaguarXJLRearAirControlAct_SP.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 7:
                    if (DataCanbus.DATA[1000] != 12779972 && DataCanbus.DATA[1000] != 13238724) {
                        LZJaguarXJLRearAirControlAct_SP.this.mUpdatePowerOn();
                        break;
                    }
                case 12:
                    LZJaguarXJLRearAirControlAct_SP.this.mUpdateFrontDefrost();
                    break;
                case 13:
                    LZJaguarXJLRearAirControlAct_SP.this.mUpdateRearDefrost();
                    break;
                case 18:
                    if (DataCanbus.DATA[1000] != 12779972 && DataCanbus.DATA[1000] != 13238724) {
                        LZJaguarXJLRearAirControlAct_SP.this.mUpdaterAirWindLevelLeft();
                        break;
                    }
                case 66:
                    LZJaguarXJLRearAirControlAct_SP.this.mUpdaterSeatHeatLeft();
                    break;
                case 67:
                    LZJaguarXJLRearAirControlAct_SP.this.mUpdaterSeatHeatRight();
                    break;
                case 68:
                    LZJaguarXJLRearAirControlAct_SP.this.findViewById(R.id.air_xts_rearlock).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rearlock_n : R.drawable.ic_xts_rearlock_p);
                    break;
                case 69:
                    LZJaguarXJLRearAirControlAct_SP.this.mUpdaterBlowBodyLeftOn();
                    break;
                case 70:
                    LZJaguarXJLRearAirControlAct_SP.this.mUpdaterBlowFootLeftOn();
                    break;
                case 72:
                    LZJaguarXJLRearAirControlAct_SP.this.mUpdaterBlowBodyRightOn();
                    break;
                case 73:
                    LZJaguarXJLRearAirControlAct_SP.this.mUpdaterBlowFootRightOn();
                    break;
                case 75:
                    LZJaguarXJLRearAirControlAct_SP.this.mUpdateAirTempLeft();
                    break;
                case 76:
                    LZJaguarXJLRearAirControlAct_SP.this.mUpdateAirTempRight();
                    break;
                case 115:
                    LZJaguarXJLRearAirControlAct_SP.this.findViewById(R.id.air_xts_blowbody_rear).setBackgroundResource(value == 0 ? R.drawable.ic_xts_blowbody_rear_n : R.drawable.ic_xts_blowbody_rear_p);
                    break;
                case 116:
                    if (DataCanbus.DATA[1000] == 12779972 || DataCanbus.DATA[1000] == 13238724) {
                        LZJaguarXJLRearAirControlAct_SP.this.mUpdatePowerOn();
                        break;
                    }
                case 117:
                    if (DataCanbus.DATA[1000] == 12779972 || DataCanbus.DATA[1000] == 13238724) {
                        LZJaguarXJLRearAirControlAct_SP.this.mUpdaterAirWindLevelLeft();
                        break;
                    }
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
        if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform)) {
            setContentView(R.layout.layout_0452_lz_jaguar_air_rear_control_9853);
        } else {
            setContentView(R.layout.layout_0452_lz_jaguar_air_rear_control_7731);
        }
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        findViewById(R.id.air_xts_rearlock).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_foot_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_body_right).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_frontpage).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_blowbody_rear).setOnTouchListener(this);
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
                data0 = 40;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 41;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                if (DataCanbus.DATA[1000] == 12779972 || DataCanbus.DATA[1000] == 13238724) {
                    data0 = 52;
                    break;
                } else {
                    data0 = 11;
                    break;
                }
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                if (DataCanbus.DATA[1000] == 12779972 || DataCanbus.DATA[1000] == 13238724) {
                    data0 = 54;
                    break;
                } else {
                    data0 = 6;
                    break;
                }
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                if (DataCanbus.DATA[1000] == 12779972 || DataCanbus.DATA[1000] == 13238724) {
                    data0 = 53;
                    break;
                } else {
                    data0 = 5;
                    break;
                }
            case R.id.air_xts_frontpage /* 2131427432 */:
                flag = true;
                try {
                    startActivity(new Intent(this, (Class<?>) LZJaguarXJLFrontAirControlAct_SP.class));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case R.id.air_xts_seathot_left /* 2131427433 */:
                data0 = 45;
                break;
            case R.id.air_xts_seathot_right /* 2131427435 */:
                data0 = 46;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 12;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                data0 = 37;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                data0 = 36;
                break;
            case R.id.air_xts_rearlock /* 2131427446 */:
                data0 = 44;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 42;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 43;
                break;
            case R.id.air_xts_seatwin_left /* 2131427452 */:
                data0 = 47;
                break;
            case R.id.air_xts_seatwin_right /* 2131427454 */:
                data0 = 48;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                data0 = 13;
                break;
            case R.id.air_xts_mode_body_right /* 2131428291 */:
                data0 = 38;
                break;
            case R.id.air_xts_mode_foot_right /* 2131428292 */:
                data0 = 39;
                break;
            case R.id.air_xts_blowbody_rear /* 2131428579 */:
                data0 = 55;
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
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSeatHeatRight() {
        int value = DataCanbus.DATA[67];
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
        int value = DataCanbus.DATA[66];
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
        findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level0);
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

    private void mUpdateMaxFrontOn() {
        int power = DataCanbus.DATA[55];
        findViewById(R.id.air_xts_front_hot).setBackgroundResource(power == 0 ? R.drawable.ic_xts_fronthot_n : R.drawable.ic_xts_fronthot_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[75];
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
        int temp = DataCanbus.DATA[76];
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
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[7];
        if (DataCanbus.DATA[1000] == 12779972 || DataCanbus.DATA[1000] == 13238724) {
            power = DataCanbus.DATA[116];
        }
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[12];
        findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[13];
        findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[18];
        if (DataCanbus.DATA[1000] == 12779972 || DataCanbus.DATA[1000] == 13238724) {
            leave = DataCanbus.DATA[117];
        }
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
        int acOn = DataCanbus.DATA[69];
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowFootLeftOn() {
        int acOn = DataCanbus.DATA[70];
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowBodyRightOn() {
        int acOn = DataCanbus.DATA[72];
        findViewById(R.id.air_xts_mode_body_right).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowFootRightOn() {
        int acOn = DataCanbus.DATA[73];
        findViewById(R.id.air_xts_mode_foot_right).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
    }
}
