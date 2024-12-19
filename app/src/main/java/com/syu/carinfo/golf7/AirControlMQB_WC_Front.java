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
public class AirControlMQB_WC_Front extends Activity implements View.OnClickListener {
    public static AirControlMQB_WC_Front mInstance;
    public static boolean mIsFront = false;
    int cmdId = 0;
    int value = -1;
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.golf7.AirControlMQB_WC_Front.1
        int value = 0;

        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 87:
                    AirControlMQB_WC_Front.this.updatePower(this.value);
                    break;
                case 88:
                    AirControlMQB_WC_Front.this.updateMaxAC(this.value);
                    break;
                case 89:
                    AirControlMQB_WC_Front.this.updateAuto(this.value);
                    break;
                case 90:
                    AirControlMQB_WC_Front.this.updateSync(this.value);
                    break;
                case 91:
                    AirControlMQB_WC_Front.this.updateAC(this.value);
                    break;
                case 92:
                    AirControlMQB_WC_Front.this.updateSeatHotLeft(this.value);
                    break;
                case 93:
                    AirControlMQB_WC_Front.this.updateSeatHotRight(this.value);
                    break;
                case 95:
                    AirControlMQB_WC_Front.this.updateBlowBody(this.value);
                    break;
                case 96:
                    AirControlMQB_WC_Front.this.updateBlowFoot(this.value);
                    break;
                case 97:
                    AirControlMQB_WC_Front.this.mUpdaterAirWindLevelLeft(this.value);
                    break;
                case 98:
                    AirControlMQB_WC_Front.this.updateTempLeft(this.value);
                    break;
                case 99:
                    AirControlMQB_WC_Front.this.updateTempRight(this.value);
                    break;
                case 101:
                    AirControlMQB_WC_Front.this.updateSteerHot(this.value);
                    break;
                case 151:
                    AirControlMQB_WC_Front.this.updateRearLock(this.value);
                    break;
                case 152:
                    AirControlMQB_WC_Front.this.updateFront(this.value);
                    break;
                case 153:
                    AirControlMQB_WC_Front.this.updateBlowWin(this.value);
                    break;
                case 155:
                    this.value = DataCanbus.DATA[updateCode] & 255;
                    AirControlMQB_WC_Front.this.updateWindMode(this.value);
                    break;
                case 157:
                    AirControlMQB_WC_Front.this.updateCycle(this.value);
                    break;
                case 190:
                    AirControlMQB_WC_Front.this.updateClearAir(this.value);
                    break;
                case 191:
                    AirControlMQB_WC_Front.this.updateSeatBlowRight(this.value);
                    break;
                case 192:
                    AirControlMQB_WC_Front.this.updateSeatBlowLeft(this.value);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0017_wc_mqb_all_air_control);
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
        ((Button) findViewById(R.id.air_xts_maxac)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_front)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_sync)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_rearlock)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_ac)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_auto)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_winlev)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_mode_win)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_mode_body)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_mode_foot)).setOnClickListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_seathot_left)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_seathot_right)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_seatwin_left)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_seatwin_right)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_clearair)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_steer_hot)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_rearpage)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        this.value = 0;
        this.cmdId = 0;
        switch (v.getId()) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                this.cmdId = 20;
                this.value = DataCanbus.DATA[98] & 255;
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
                this.cmdId = 20;
                this.value = DataCanbus.DATA[98] & 255;
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
                this.cmdId = 2;
                this.value = DataCanbus.DATA[87] != 0 ? 0 : 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                this.cmdId = 23;
                this.value = DataCanbus.DATA[97] - 1;
                if (this.value <= 0) {
                    this.value = 0;
                    break;
                }
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                this.cmdId = 23;
                this.value = DataCanbus.DATA[97] + 1;
                if (this.value >= 7) {
                    this.value = 7;
                    break;
                }
            case R.id.air_xts_seathot_left /* 2131427433 */:
                this.cmdId = 33;
                this.value = DataCanbus.DATA[92] + 1;
                if (this.value > 3) {
                    this.value = 0;
                    break;
                }
            case R.id.air_xts_seathot_right /* 2131427435 */:
                this.cmdId = 34;
                this.value = DataCanbus.DATA[93] + 1;
                if (this.value > 3) {
                    this.value = 0;
                    break;
                }
            case R.id.air_xts_auto /* 2131427436 */:
                this.cmdId = 129;
                if (DataCanbus.DATA[89] == 0) {
                    this.value = 0;
                    break;
                } else {
                    this.value = 3;
                    break;
                }
            case R.id.air_xts_cycle /* 2131427437 */:
                this.cmdId = 19;
                this.value = DataCanbus.DATA[157] != 0 ? 0 : 1;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                this.cmdId = 129;
                this.value = 2;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                this.cmdId = 15;
                this.value = DataCanbus.DATA[91] != 0 ? 0 : 1;
                break;
            case R.id.air_xts_maxac /* 2131427440 */:
                this.cmdId = 129;
                this.value = 1;
                break;
            case R.id.air_xts_sync /* 2131427441 */:
                this.cmdId = 17;
                this.value = DataCanbus.DATA[90] != 0 ? 0 : 1;
                break;
            case R.id.air_xts_winlev /* 2131427442 */:
                this.cmdId = 1;
                this.value = (DataCanbus.DATA[155] + 1) % 3;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                this.cmdId = 25;
                this.value = DataCanbus.DATA[96] != 0 ? 0 : 1;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                this.cmdId = 24;
                this.value = DataCanbus.DATA[95] != 0 ? 0 : 1;
                break;
            case R.id.air_xts_mode_win /* 2131427445 */:
                this.cmdId = 26;
                this.value = DataCanbus.DATA[153] != 0 ? 0 : 1;
                break;
            case R.id.air_xts_rearlock /* 2131427446 */:
                this.cmdId = 18;
                this.value = DataCanbus.DATA[151] != 0 ? 0 : 1;
                break;
            case R.id.air_xts_clearair /* 2131427447 */:
                this.cmdId = 32;
                this.value = DataCanbus.DATA[190] != 0 ? 0 : 1;
                break;
            case R.id.air_xts_rearpage /* 2131427448 */:
                try {
                    startActivity(new Intent(this, (Class<?>) AirControlMQB_WC_Rear.class));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                this.cmdId = 21;
                this.value = DataCanbus.DATA[99] & 255;
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
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                this.cmdId = 21;
                this.value = DataCanbus.DATA[99] & 255;
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
            case R.id.air_xts_seatwin_left /* 2131427452 */:
                this.cmdId = 37;
                this.value = DataCanbus.DATA[192] + 1;
                if (this.value > 3) {
                    this.value = 0;
                    break;
                }
            case R.id.air_xts_steer_hot /* 2131427453 */:
                this.cmdId = 35;
                this.value = DataCanbus.DATA[101] != 0 ? 0 : 1;
                break;
            case R.id.air_xts_seatwin_right /* 2131427454 */:
                this.cmdId = 38;
                this.value = DataCanbus.DATA[191] + 1;
                if (this.value > 3) {
                    this.value = 0;
                    break;
                }
        }
        if (this.value >= 0 && this.cmdId > 0) {
            setAirCmd(this.cmdId, this.value);
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
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mCanbusNotify);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempLeft(int value) {
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            switch (value) {
                case 254:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                    break;
                case 255:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HIGHT");
                    break;
                default:
                    if (DataCanbus.DATA[156] == 0) {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText((value / 2.0f) + "℃");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText((value / 2.0f) + "℉");
                        break;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempRight(int value) {
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            switch (value) {
                case 254:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                    break;
                case 255:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HIGHT");
                    break;
                default:
                    if (DataCanbus.DATA[156] == 0) {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText((value / 2.0f) + "℃");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText((value / 2.0f) + "℉");
                        break;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSeatBlowLeft(int value) {
        if (((Button) findViewById(R.id.air_xts_seatwin_left)) != null) {
            switch (value) {
                case 0:
                    ((Button) findViewById(R.id.air_xts_seatwin_left)).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level0);
                    break;
                case 1:
                    ((Button) findViewById(R.id.air_xts_seatwin_left)).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level1);
                    break;
                case 2:
                    ((Button) findViewById(R.id.air_xts_seatwin_left)).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level2);
                    break;
                case 3:
                    ((Button) findViewById(R.id.air_xts_seatwin_left)).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level3);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSeatBlowRight(int value) {
        if (((Button) findViewById(R.id.air_xts_seatwin_right)) != null) {
            switch (value) {
                case 0:
                    ((Button) findViewById(R.id.air_xts_seatwin_right)).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level0);
                    break;
                case 1:
                    ((Button) findViewById(R.id.air_xts_seatwin_right)).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level1);
                    break;
                case 2:
                    ((Button) findViewById(R.id.air_xts_seatwin_right)).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level2);
                    break;
                case 3:
                    ((Button) findViewById(R.id.air_xts_seatwin_right)).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level3);
                    break;
            }
        }
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
    public void updateSteerHot(int value) {
        if (((Button) findViewById(R.id.air_xts_steer_hot)) != null) {
            ((Button) findViewById(R.id.air_xts_steer_hot)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_steer_hot_n : R.drawable.ic_xts_steer_hot_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateClearAir(int value) {
        if (((Button) findViewById(R.id.air_xts_clearair)) != null) {
            ((Button) findViewById(R.id.air_xts_clearair)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_clearair_n : R.drawable.ic_xts_clearair_p);
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
    public void updateCycle(int value) {
        if (((Button) findViewById(R.id.air_xts_cycle)) != null) {
            ((Button) findViewById(R.id.air_xts_cycle)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_cycle_n : R.drawable.ic_xts_cycle_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFront(int value) {
        if (((Button) findViewById(R.id.air_xts_front)) != null) {
            ((Button) findViewById(R.id.air_xts_front)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_maxfront_n : R.drawable.ic_xts_maxfront_p);
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
    public void updateAuto(int value) {
        if (((Button) findViewById(R.id.air_xts_auto)) != null) {
            ((Button) findViewById(R.id.air_xts_auto)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
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
