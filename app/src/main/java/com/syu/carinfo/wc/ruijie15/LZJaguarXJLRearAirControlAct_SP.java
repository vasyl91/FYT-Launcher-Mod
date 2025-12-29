package com.syu.carinfo.wc.ruijie15;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.SystemProperties;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class LZJaguarXJLRearAirControlAct_SP extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    int TempUnit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                    if (DataCanbus.DATA[1000] != 12779972 && DataCanbus.DATA[1000] != 13238724) {
                        LZJaguarXJLRearAirControlAct_SP.this.mUpdatePowerOn();
                        break;
                    }
                case 16:
                    LZJaguarXJLRearAirControlAct_SP.this.mUpdateRearDefrost();
                    break;
                case 21:
                    if (DataCanbus.DATA[1000] != 12779972 && DataCanbus.DATA[1000] != 13238724) {
                        LZJaguarXJLRearAirControlAct_SP.this.mUpdaterAirWindLevelLeft();
                        break;
                    }
                case 42:
                    if (DataCanbus.DATA[1000] == 12779972 || DataCanbus.DATA[1000] == 13238724) {
                        LZJaguarXJLRearAirControlAct_SP.this.mUpdatePowerOn();
                        break;
                    }
                case 44:
                    if (DataCanbus.DATA[1000] == 12779972 || DataCanbus.DATA[1000] == 13238724) {
                        LZJaguarXJLRearAirControlAct_SP.this.mUpdaterAirWindLevelLeft();
                        break;
                    }
                case 65:
                    LZJaguarXJLRearAirControlAct_SP.this.mUpdateFrontDefrost();
                    break;
                case 128:
                    LZJaguarXJLRearAirControlAct_SP.this.mUpdaterSeatHeatLeft();
                    break;
                case 129:
                    LZJaguarXJLRearAirControlAct_SP.this.mUpdaterSeatHeatRight();
                    break;
                case 130:
                    LZJaguarXJLRearAirControlAct_SP.this.findViewById(R.id.air_xts_rearlock).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rearlock_n : R.drawable.ic_xts_rearlock_p);
                    break;
                case 131:
                    LZJaguarXJLRearAirControlAct_SP.this.mUpdaterBlowBodyLeftOn();
                    break;
                case 132:
                    LZJaguarXJLRearAirControlAct_SP.this.mUpdaterBlowFootLeftOn();
                    break;
                case 134:
                    LZJaguarXJLRearAirControlAct_SP.this.mUpdaterBlowBodyRightOn();
                    break;
                case 135:
                    LZJaguarXJLRearAirControlAct_SP.this.mUpdaterBlowFootRightOn();
                    break;
                case 137:
                    LZJaguarXJLRearAirControlAct_SP.this.mUpdateAirTempLeft();
                    break;
                case 138:
                    LZJaguarXJLRearAirControlAct_SP.this.mUpdateAirTempRight();
                    break;
                case 142:
                    LZJaguarXJLRearAirControlAct_SP.this.findViewById(R.id.air_xts_blowbody_rear).setBackgroundResource(value == 0 ? R.drawable.ic_xts_blowbody_rear_n : R.drawable.ic_xts_blowbody_rear_p);
                    break;
            }
        }
    };

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(0, new int[]{data0, data1}, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String platform = SystemProperties.get("ro.fyt.platform", "");
        if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform) || "6318".equals(platform)) {
            //setContentView(R.layout.layout_0452_lz_jaguar_air_rear_control_9853);
        } else {
            //setContentView(R.layout.layout_0452_lz_jaguar_air_rear_control_7731);
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

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addUpdater();
        AirHelper.disableAirWindowLocal(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeUpdater();
    }

    @Override
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
            case R.id.air_xts_rear /* 2131427560 */:
                data0 = 13;
                break;
            case R.id.air_xts_mode_body_right /* 2131428577 */:
                data0 = 38;
                break;
            case R.id.air_xts_mode_foot_right /* 2131428578 */:
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
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterSeatHeatRight() {
        int value = DataCanbus.DATA[129];
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

    
    public void mUpdaterSeatHeatLeft() {
        int value = DataCanbus.DATA[128];
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
        int power = DataCanbus.DATA[17];
        findViewById(R.id.air_xts_front_hot).setBackgroundResource(power == 0 ? R.drawable.ic_xts_fronthot_n : R.drawable.ic_xts_fronthot_p);
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[137];
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

    
    public void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[138];
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

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[10];
        if (DataCanbus.DATA[1000] == 12779972 || DataCanbus.DATA[1000] == 13238724) {
            power = DataCanbus.DATA[42];
        }
        findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[65];
        findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[16];
        findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[21];
        if (DataCanbus.DATA[1000] == 12779972 || DataCanbus.DATA[1000] == 13238724) {
            leave = DataCanbus.DATA[44];
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

    
    public void mUpdaterBlowBodyLeftOn() {
        int acOn = DataCanbus.DATA[131];
        findViewById(R.id.air_xts_mode_body).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
    }

    
    public void mUpdaterBlowFootLeftOn() {
        int acOn = DataCanbus.DATA[132];
        findViewById(R.id.air_xts_mode_foot).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
    }

    
    public void mUpdaterBlowBodyRightOn() {
        int acOn = DataCanbus.DATA[134];
        findViewById(R.id.air_xts_mode_body_right).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
    }

    
    public void mUpdaterBlowFootRightOn() {
        int acOn = DataCanbus.DATA[135];
        findViewById(R.id.air_xts_mode_foot_right).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
    }
}
