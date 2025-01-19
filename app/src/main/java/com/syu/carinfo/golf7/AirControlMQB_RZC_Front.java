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

public class AirControlMQB_RZC_Front extends Activity implements View.OnClickListener {
    public static AirControlMQB_RZC_Front mInstance;
    public static boolean mIsFront = false;
    IUiNotify mCanbusNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                    AirControlMQB_RZC_Front.this.updatePower(value);
                    break;
                case 11:
                    AirControlMQB_RZC_Front.this.updateAC(value);
                    break;
                case 12:
                    AirControlMQB_RZC_Front.this.updateCycle(value);
                    break;
                case 14:
                    AirControlMQB_RZC_Front.this.updateSync(value);
                    break;
                case 15:
                    AirControlMQB_RZC_Front.this.uFrontMax(value);
                    break;
                case 18:
                    AirControlMQB_RZC_Front.this.updateBlowWin(value);
                    break;
                case 19:
                    AirControlMQB_RZC_Front.this.updateBlowBody(value);
                    break;
                case 20:
                    AirControlMQB_RZC_Front.this.updateBlowFoot(value);
                    break;
                case 21:
                    AirControlMQB_RZC_Front.this.mUpdaterAirWindLevelLeft(value);
                    break;
                case 27:
                    AirControlMQB_RZC_Front.this.updateTempLeft(value);
                    break;
                case 28:
                    AirControlMQB_RZC_Front.this.updateTempRight(value);
                    break;
                case 29:
                    AirControlMQB_RZC_Front.this.uSeatHeatL(value);
                    break;
                case 30:
                    AirControlMQB_RZC_Front.this.uSeatHeatR(value);
                    break;
                case 31:
                    AirControlMQB_RZC_Front.this.uSeatBlowL(value);
                    break;
                case 32:
                    AirControlMQB_RZC_Front.this.uSeatBlowR(value);
                    break;
                case 53:
                    AirControlMQB_RZC_Front.this.updateMaxAC(value);
                    break;
                case 54:
                    AirControlMQB_RZC_Front.this.updateAQS(value);
                    break;
                case 65:
                    AirControlMQB_RZC_Front.this.updateFrontHot(value);
                    break;
                case 66:
                    AirControlMQB_RZC_Front.this.uSteerHeat(value);
                    break;
                case 69:
                    AirControlMQB_RZC_Front.this.updateWindMode(DataCanbus.DATA[updateCode] & 255);
                    break;
                case 76:
                    AirControlMQB_RZC_Front.this.uClearAir(value);
                    break;
                case 358:
                case 359:
                    AirControlMQB_RZC_Front.this.updateSteerSeatHeat();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0160_air_control_tuguanl_rzc);
        setListener();
        mInstance = this;
    }

    private void setListener() {
        ((Button) findViewById(R.id.air_xts_power)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_temp_left_minus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_temp_left_plus)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_cycle)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_temp_right_minus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_temp_right_plus)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_ac)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_front)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_sync)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_maxac)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_mode_win)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_mode_body)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_mode_foot)).setOnClickListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_steer_seat_hot)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_steer_hot)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_seathot_left)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_seathot_right)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_seatwin_left)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_seatwin_right)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_fronthot)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_aqs)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_winlev)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_clearair)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_rearpage)).setOnClickListener(this);
        if (DataCanbus.DATA[1000] == 721056 || DataCanbus.DATA[1000] == 3473568) {
            findViewById(R.id.air_xts_steer_hot).setVisibility(8);
            findViewById(R.id.air_xts_steer_seat_hot).setVisibility(0);
        } else {
            findViewById(R.id.air_xts_steer_hot).setVisibility(0);
            findViewById(R.id.air_xts_steer_seat_hot).setVisibility(8);
        }
    }

    @Override
    public void onClick(View v) {
        int value = 0;
        int cmdId = 0;
        switch (v.getId()) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                cmdId = 184;
                value = 1;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                cmdId = 184;
                value = 0;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                cmdId = 178;
                if (DataCanbus.DATA[10] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                cmdId = 183;
                value = DataCanbus.DATA[21] - 1;
                if (value <= 0) {
                    value = 0;
                    break;
                }
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                cmdId = 183;
                value = DataCanbus.DATA[21] + 1;
                if (DataCanbus.DATA[1000] == 3735712) {
                    if (value >= 12) {
                        value = 12;
                        break;
                    }
                } else if (value >= 7) {
                    value = 7;
                    break;
                }
            case R.id.air_xts_seathot_left /* 2131427433 */:
                cmdId = 173;
                value = (DataCanbus.DATA[29] + 1) % 4;
                break;
            case R.id.air_xts_seathot_right /* 2131427435 */:
                cmdId = 174;
                value = (DataCanbus.DATA[30] + 1) % 4;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                cmdId = 190;
                if (DataCanbus.DATA[12] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.air_xts_front /* 2131427438 */:
                cmdId = 187;
                value = 3;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                cmdId = 189;
                if (DataCanbus.DATA[11] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.air_xts_maxac /* 2131427440 */:
                cmdId = 187;
                value = 2;
                break;
            case R.id.air_xts_sync /* 2131427441 */:
                cmdId = 179;
                if (DataCanbus.DATA[14] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.air_xts_winlev /* 2131427442 */:
                cmdId = 177;
                value = (DataCanbus.DATA[69] + 1) % 3;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                cmdId = 181;
                if (DataCanbus.DATA[20] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.air_xts_mode_body /* 2131427444 */:
                cmdId = 180;
                if (DataCanbus.DATA[19] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.air_xts_mode_win /* 2131427445 */:
                cmdId = 182;
                if (DataCanbus.DATA[18] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.air_xts_clearair /* 2131427447 */:
                cmdId = 175;
                if (DataCanbus.DATA[76] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.air_xts_rearpage /* 2131427448 */:
                try {
                    startActivity(new Intent(this, (Class<?>) AirControlMQB_RZC_Rear.class));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                cmdId = 185;
                value = 1;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                cmdId = 185;
                value = 0;
                break;
            case R.id.air_xts_seatwin_left /* 2131427452 */:
                cmdId = 191;
                value = (DataCanbus.DATA[31] + 1) % 4;
                break;
            case R.id.air_xts_steer_hot /* 2131427453 */:
                cmdId = 172;
                if (DataCanbus.DATA[66] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.air_xts_seatwin_right /* 2131427454 */:
                cmdId = 192;
                value = (DataCanbus.DATA[32] + 1) % 4;
                break;
            case R.id.air_xts_fronthot /* 2131427591 */:
                cmdId = 205;
                if (DataCanbus.DATA[65] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.air_xts_aqs /* 2131427592 */:
                cmdId = 176;
                if (DataCanbus.DATA[54] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.air_xts_steer_seat_hot /* 2131427593 */:
                int lev = DataCanbus.DATA[359];
                int on = DataCanbus.DATA[358];
                if (on == 0) {
                    setAirCmd(42, 0);
                    setAirCmd(41, 1);
                    break;
                } else if (on == 1) {
                    int lev2 = lev + 1;
                    if (lev2 > 2) {
                        cmdId = 41;
                        value = 0;
                        break;
                    } else {
                        cmdId = 42;
                        value = lev2;
                        break;
                    }
                }
                break;
        }
        if (value >= 0 && cmdId > 0) {
            setAirCmd(cmdId, value);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        AirHelper.disableAirWindowLocal(true);
        mIsFront = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        AirHelper.disableAirWindowLocal(false);
        setAirCmd(240, 0);
        mIsFront = false;
    }

    private void setAirCmd(int cmdCode, int value) {
        DataCanbus.PROXY.cmd(107, new int[]{cmdCode, value}, null, null);
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[358].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[359].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[358].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[359].removeNotify(this.mCanbusNotify);
    }

    
    public void uFrontMax(int val) {
        if (((Button) findViewById(R.id.air_xts_front)) != null) {
            ((Button) findViewById(R.id.air_xts_front)).setBackgroundResource(val == 0 ? R.drawable.ic_xts_maxfront_n : R.drawable.ic_xts_maxfront_p);
        }
    }

    
    public void uClearAir(int val) {
        if (((Button) findViewById(R.id.air_xts_clearair)) != null) {
            ((Button) findViewById(R.id.air_xts_clearair)).setBackgroundResource(val == 0 ? R.drawable.ic_xts_clearair_n : R.drawable.ic_xts_clearair_p);
        }
    }

    
    public void uSeatHeatR(int val) {
        if (((Button) findViewById(R.id.air_xts_seathot_right)) != null) {
            int i = R.drawable.ic_xts_seathot_right_level0;
            if (val == 1) {
                i = R.drawable.ic_xts_seathot_right_level1;
            } else if (val == 2) {
                i = R.drawable.ic_xts_seathot_right_level2;
            } else if (val == 3) {
                i = R.drawable.ic_xts_seathot_right_level3;
            }
            ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(i);
        }
    }

    
    public void uSeatBlowL(int val) {
        if (((Button) findViewById(R.id.air_xts_seatwin_left)) != null) {
            int i = R.drawable.ic_xts_seatwin_left_level0;
            if (val == 1) {
                i = R.drawable.ic_xts_seatwin_left_level1;
            } else if (val == 2) {
                i = R.drawable.ic_xts_seatwin_left_level2;
            } else if (val == 3) {
                i = R.drawable.ic_xts_seatwin_left_level3;
            }
            ((Button) findViewById(R.id.air_xts_seatwin_left)).setBackgroundResource(i);
        }
    }

    
    public void uSeatBlowR(int val) {
        if (((Button) findViewById(R.id.air_xts_seatwin_right)) != null) {
            int i = R.drawable.ic_xts_seatwin_right_level0;
            if (val == 1) {
                i = R.drawable.ic_xts_seatwin_right_level1;
            } else if (val == 2) {
                i = R.drawable.ic_xts_seatwin_right_level2;
            } else if (val == 3) {
                i = R.drawable.ic_xts_seatwin_right_level3;
            }
            ((Button) findViewById(R.id.air_xts_seatwin_right)).setBackgroundResource(i);
        }
    }

    
    public void uSeatHeatL(int val) {
        if (((Button) findViewById(R.id.air_xts_seathot_left)) != null) {
            int i = R.drawable.ic_xts_seathot_left_level0;
            if (val == 1) {
                i = R.drawable.ic_xts_seathot_left_level1;
            } else if (val == 2) {
                i = R.drawable.ic_xts_seathot_left_level2;
            } else if (val == 3) {
                i = R.drawable.ic_xts_seathot_left_level3;
            }
            ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(i);
        }
    }

    
    public void uSteerHeat(int val) {
        if (((Button) findViewById(R.id.air_xts_steer_hot)) != null) {
            ((Button) findViewById(R.id.air_xts_steer_hot)).setBackgroundResource(val == 0 ? R.drawable.ic_xts_steer_hot_n : R.drawable.ic_xts_steer_hot_p);
        }
    }

    
    public void updateTempLeft(int value) {
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                    break;
                case 31:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HIGHT");
                    break;
                default:
                    if (DataCanbus.DATA[37] == 0) {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText((((value * 5) + 155) / 10.0f) + "℃");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText((value + 59) + "℉");
                        break;
                    }
            }
        }
    }

    
    public void updateTempRight(int value) {
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                    break;
                case 31:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HIGHT");
                    break;
                default:
                    if (DataCanbus.DATA[37] == 0) {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText((((value * 5) + 155) / 10.0f) + "℃");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText((value + 59) + "℉");
                        break;
                    }
            }
        }
    }

    
    public void updatePower(int value) {
        if (((Button) findViewById(R.id.air_xts_power)) != null) {
            ((Button) findViewById(R.id.air_xts_power)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        }
    }

    
    public void updateAC(int value) {
        if (((Button) findViewById(R.id.air_xts_ac)) != null) {
            ((Button) findViewById(R.id.air_xts_ac)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    
    public void updateAQS(int value) {
        if (((Button) findViewById(R.id.air_xts_aqs)) != null) {
            ((Button) findViewById(R.id.air_xts_aqs)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_aqs_n : R.drawable.ic_xts_aqs_p);
        }
    }

    
    public void updateCycle(int value) {
        if (((Button) findViewById(R.id.air_xts_cycle)) != null) {
            ((Button) findViewById(R.id.air_xts_cycle)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_cycle_n : R.drawable.ic_xts_cycle_p);
        }
    }

    
    public void updateSteerSeatHeat() {
        int value = DataCanbus.DATA[359];
        int on = DataCanbus.DATA[358];
        if (((Button) findViewById(R.id.air_xts_steer_seat_hot)) != null) {
            if (on == 0) {
                ((Button) findViewById(R.id.air_xts_steer_seat_hot)).setBackgroundResource(R.drawable.ic_xts_seat_steer_lev0);
            }
            switch (value) {
                case 0:
                    ((Button) findViewById(R.id.air_xts_steer_seat_hot)).setBackgroundResource(R.drawable.ic_xts_seat_steer_lev1);
                    break;
                case 1:
                    ((Button) findViewById(R.id.air_xts_steer_seat_hot)).setBackgroundResource(R.drawable.ic_xts_seat_steer_lev2);
                    break;
                case 2:
                    ((Button) findViewById(R.id.air_xts_steer_seat_hot)).setBackgroundResource(R.drawable.ic_xts_seat_steer_lev3);
                    break;
            }
        }
    }

    
    public void updateWindMode(int value) {
        if (((Button) findViewById(R.id.air_xts_winlev)) != null) {
            switch (value) {
                case 0:
                    ((Button) findViewById(R.id.air_xts_winlev)).setBackgroundResource(R.drawable.ic_xts_winlev1);
                    break;
                case 1:
                    ((Button) findViewById(R.id.air_xts_winlev)).setBackgroundResource(R.drawable.ic_xts_winlev2);
                    break;
                case 2:
                    ((Button) findViewById(R.id.air_xts_winlev)).setBackgroundResource(R.drawable.ic_xts_winlev3);
                    break;
            }
        }
    }

    
    public void updateMaxAC(int value) {
        if (((Button) findViewById(R.id.air_xts_maxac)) != null) {
            ((Button) findViewById(R.id.air_xts_maxac)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_maxac_n : R.drawable.ic_xts_maxac_p);
        }
    }

    
    public void updateFrontHot(int value) {
        if (((Button) findViewById(R.id.air_xts_fronthot)) != null) {
            ((Button) findViewById(R.id.air_xts_fronthot)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_fronthot_n : R.drawable.ic_xts_fronthot_p);
        }
    }

    
    public void updateBlowWin(int value) {
        if (((Button) findViewById(R.id.air_xts_mode_win)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_win)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_win_n : R.drawable.ic_xts_mode_win_p);
        }
    }

    
    public void updateBlowBody(int value) {
        if (((Button) findViewById(R.id.air_xts_mode_body)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_body)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
        }
    }

    
    public void updateBlowFoot(int value) {
        if (((Button) findViewById(R.id.air_xts_mode_foot)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_foot)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
        }
    }

    
    public void updateSync(int value) {
        if (((Button) findViewById(R.id.air_xts_sync)) != null) {
            ((Button) findViewById(R.id.air_xts_sync)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_sync_n : R.drawable.ic_xts_sync_p);
        }
    }

    void mUpdaterAirWindLevelLeft(int value) {
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(value).toString());
        }
    }
}
