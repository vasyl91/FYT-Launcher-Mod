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
public class AirControlMQB_RZC_Front extends Activity implements View.OnClickListener {
    public static AirControlMQB_RZC_Front mInstance;
    public static boolean mIsFront = false;
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.golf7.AirControlMQB_RZC_Front.1
        int value = 0;

        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 87:
                    AirControlMQB_RZC_Front.this.updatePower(this.value);
                    break;
                case 88:
                    AirControlMQB_RZC_Front.this.updateMaxAC(this.value);
                    break;
                case 91:
                    AirControlMQB_RZC_Front.this.updateAC(this.value);
                    break;
                case 92:
                    AirControlMQB_RZC_Front.this.uSeatHeatL(this.value);
                    break;
                case 93:
                    AirControlMQB_RZC_Front.this.uSeatHeatR(this.value);
                    break;
                case 94:
                    AirControlMQB_RZC_Front.this.updateBlowWin(this.value);
                    break;
                case 95:
                    AirControlMQB_RZC_Front.this.updateBlowBody(this.value);
                    break;
                case 96:
                    AirControlMQB_RZC_Front.this.updateBlowFoot(this.value);
                    break;
                case 97:
                    AirControlMQB_RZC_Front.this.mUpdaterAirWindLevelLeft(this.value);
                    break;
                case 98:
                    AirControlMQB_RZC_Front.this.updateTempLeft(this.value);
                    break;
                case 99:
                    AirControlMQB_RZC_Front.this.updateTempRight(this.value);
                    break;
                case 100:
                    AirControlMQB_RZC_Front.this.updateSync(this.value);
                    break;
                case 101:
                    AirControlMQB_RZC_Front.this.uSteerHeat(this.value);
                    break;
                case 102:
                    AirControlMQB_RZC_Front.this.updateAQS(this.value);
                    break;
                case 106:
                    AirControlMQB_RZC_Front.this.uFrontMax(this.value);
                    break;
                case 122:
                    AirControlMQB_RZC_Front.this.updateCycle(this.value);
                    break;
                case 151:
                    AirControlMQB_RZC_Front.this.updateRearLock(this.value);
                    break;
                case 155:
                    this.value = DataCanbus.DATA[updateCode] & 255;
                    AirControlMQB_RZC_Front.this.updateWindMode(this.value);
                    break;
                case 190:
                    AirControlMQB_RZC_Front.this.uClearAir(this.value);
                    break;
                case 191:
                    AirControlMQB_RZC_Front.this.uSeatBlowR(this.value);
                    break;
                case 192:
                    AirControlMQB_RZC_Front.this.uSeatBlowL(this.value);
                    break;
                case 366:
                case 367:
                    AirControlMQB_RZC_Front.this.updateSteerSeatHeat();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0160_air_control_tuguanl_rzc);
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
        ((Button) findViewById(R.id.air_xts_rearlock)).setOnClickListener(this);
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

    @Override // android.view.View.OnClickListener
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
                if (DataCanbus.DATA[87] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                cmdId = 183;
                value = DataCanbus.DATA[97] - 1;
                if (value <= 0) {
                    value = 0;
                    break;
                }
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                cmdId = 183;
                value = DataCanbus.DATA[97] + 1;
                if (value >= 7) {
                    value = 7;
                    break;
                }
            case R.id.air_xts_seathot_left /* 2131427433 */:
                cmdId = 173;
                value = (DataCanbus.DATA[92] + 1) % 4;
                break;
            case R.id.air_xts_seathot_right /* 2131427435 */:
                cmdId = 174;
                value = (DataCanbus.DATA[93] + 1) % 4;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                cmdId = 190;
                if (DataCanbus.DATA[122] != 0) {
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
                if (DataCanbus.DATA[91] != 0) {
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
                if (DataCanbus.DATA[100] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.air_xts_winlev /* 2131427442 */:
                cmdId = 177;
                value = (DataCanbus.DATA[155] + 1) % 3;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                cmdId = 181;
                if (DataCanbus.DATA[96] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.air_xts_mode_body /* 2131427444 */:
                cmdId = 180;
                if (DataCanbus.DATA[95] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.air_xts_mode_win /* 2131427445 */:
                cmdId = 182;
                if (DataCanbus.DATA[94] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.air_xts_rearlock /* 2131427446 */:
                cmdId = 188;
                if (DataCanbus.DATA[151] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.air_xts_clearair /* 2131427447 */:
                cmdId = 175;
                if (DataCanbus.DATA[190] != 0) {
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
                value = (DataCanbus.DATA[192] + 1) % 4;
                break;
            case R.id.air_xts_steer_hot /* 2131427453 */:
                cmdId = 172;
                if (DataCanbus.DATA[101] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.air_xts_seatwin_right /* 2131427454 */:
                cmdId = 192;
                value = (DataCanbus.DATA[191] + 1) % 4;
                break;
            case R.id.air_xts_aqs /* 2131427467 */:
                cmdId = 176;
                if (DataCanbus.DATA[102] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.air_xts_steer_seat_hot /* 2131427581 */:
                int lev = DataCanbus.DATA[367];
                int on = DataCanbus.DATA[366];
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

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        AirHelper.disableAirWindowLocal(true);
        mIsFront = true;
    }

    @Override // android.app.Activity
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
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[366].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[367].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[366].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[367].removeNotify(this.mCanbusNotify);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uFrontMax(int val) {
        if (((Button) findViewById(R.id.air_xts_front)) != null) {
            ((Button) findViewById(R.id.air_xts_front)).setBackgroundResource(val == 0 ? R.drawable.ic_xts_maxfront_n : R.drawable.ic_xts_maxfront_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uClearAir(int val) {
        if (((Button) findViewById(R.id.air_xts_clearair)) != null) {
            ((Button) findViewById(R.id.air_xts_clearair)).setBackgroundResource(val == 0 ? R.drawable.ic_xts_clearair_n : R.drawable.ic_xts_clearair_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
    public void uSteerHeat(int val) {
        if (((Button) findViewById(R.id.air_xts_steer_hot)) != null) {
            ((Button) findViewById(R.id.air_xts_steer_hot)).setBackgroundResource(val == 0 ? R.drawable.ic_xts_steer_hot_n : R.drawable.ic_xts_steer_hot_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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
                    if (DataCanbus.DATA[103] == 0) {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText((((value * 5) + 155) / 10.0f) + "℃");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText((value + 59) + "℉");
                        break;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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
                    if (DataCanbus.DATA[103] == 0) {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText((((value * 5) + 155) / 10.0f) + "℃");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText((value + 59) + "℉");
                        break;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePower(int value) {
        if (((Button) findViewById(R.id.air_xts_power)) != null) {
            ((Button) findViewById(R.id.air_xts_power)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAC(int value) {
        if (((Button) findViewById(R.id.air_xts_ac)) != null) {
            ((Button) findViewById(R.id.air_xts_ac)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAQS(int value) {
        if (((Button) findViewById(R.id.air_xts_aqs)) != null) {
            ((Button) findViewById(R.id.air_xts_aqs)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_aqs_n : R.drawable.ic_xts_aqs_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCycle(int value) {
        if (((Button) findViewById(R.id.air_xts_cycle)) != null) {
            ((Button) findViewById(R.id.air_xts_cycle)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_cycle_n : R.drawable.ic_xts_cycle_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSteerSeatHeat() {
        int value = DataCanbus.DATA[367];
        int on = DataCanbus.DATA[366];
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMaxAC(int value) {
        if (((Button) findViewById(R.id.air_xts_maxac)) != null) {
            ((Button) findViewById(R.id.air_xts_maxac)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_maxac_n : R.drawable.ic_xts_maxac_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRearLock(int value) {
        if (((Button) findViewById(R.id.air_xts_rearlock)) != null) {
            ((Button) findViewById(R.id.air_xts_rearlock)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rearlock_n : R.drawable.ic_xts_rearlock_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowWin(int value) {
        if (((Button) findViewById(R.id.air_xts_mode_win)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_win)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_win_n : R.drawable.ic_xts_mode_win_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowBody(int value) {
        if (((Button) findViewById(R.id.air_xts_mode_body)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_body)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowFoot(int value) {
        if (((Button) findViewById(R.id.air_xts_mode_foot)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_foot)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSync(int value) {
        if (((Button) findViewById(R.id.air_xts_sync)) != null) {
            ((Button) findViewById(R.id.air_xts_sync)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_sync_n : R.drawable.ic_xts_sync_p);
        }
    }

    void mUpdaterAirWindLevelLeft(int value) {
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null && value > -1 && value < 9) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(value).toString());
        }
    }
}
