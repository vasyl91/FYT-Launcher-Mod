package com.syu.carinfo.golf7;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class AirControlMaiTengDZSJ extends Activity implements View.OnClickListener {
    public static AirControlMaiTengDZSJ mInstance;
    public static boolean mIsFront = false;
    int Msgbox_Num = 0;
    int Msgbox_Num_p = 0;
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.golf7.AirControlMaiTengDZSJ.1
        int value = 0;

        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 87:
                    AirControlMaiTengDZSJ.this.updatePower(this.value);
                    if (ConstGolf.isWcGolf()) {
                        AirControlMaiTengDZSJ.this.updateBlowWin(DataCanbus.DATA[153]);
                        break;
                    } else {
                        AirControlMaiTengDZSJ.this.updateBlowWin(DataCanbus.DATA[94]);
                        break;
                    }
                case 88:
                case 89:
                    AirControlMaiTengDZSJ.this.updateAuto();
                    break;
                case 90:
                    if (ConstGolf.isWcGolf()) {
                        AirControlMaiTengDZSJ.this.updateSync(this.value);
                        break;
                    }
                case 91:
                    AirControlMaiTengDZSJ.this.updateAC(this.value);
                    break;
                case 92:
                case 192:
                    AirControlMaiTengDZSJ.this.updateSeatHotBlow_FL();
                    break;
                case 93:
                case 191:
                    AirControlMaiTengDZSJ.this.updateSeatHotBlow_FR();
                    break;
                case 94:
                    if (!ConstGolf.isWcGolf()) {
                        AirControlMaiTengDZSJ.this.updateBlowWin(this.value);
                        break;
                    }
                case 95:
                    AirControlMaiTengDZSJ.this.updateBlowBody(this.value);
                    AirControlMaiTengDZSJ.this.updateAuto();
                    break;
                case 96:
                    AirControlMaiTengDZSJ.this.updateBlowFoot(this.value);
                    AirControlMaiTengDZSJ.this.updateAuto();
                    break;
                case 97:
                    AirControlMaiTengDZSJ.this.mUpdaterAirWindLevelLeft(this.value);
                    break;
                case 98:
                    AirControlMaiTengDZSJ.this.updateTempLeft(this.value);
                    break;
                case 99:
                    AirControlMaiTengDZSJ.this.updateTempRight(this.value);
                    break;
                case 100:
                    if (!ConstGolf.isWcGolf()) {
                        AirControlMaiTengDZSJ.this.updateSync(this.value);
                        break;
                    }
                case 101:
                    AirControlMaiTengDZSJ.this.uRearSteerHeat(this.value);
                    break;
                case 122:
                    if (!ConstGolf.isWcGolf()) {
                        AirControlMaiTengDZSJ.this.updateCycle(this.value);
                        break;
                    }
                case 151:
                    AirControlMaiTengDZSJ.this.updateRearLock(this.value);
                    break;
                case 153:
                    if (ConstGolf.isWcGolf()) {
                        AirControlMaiTengDZSJ.this.updateBlowWin(this.value);
                        AirControlMaiTengDZSJ.this.updateAuto();
                        break;
                    }
                case 154:
                    AirControlMaiTengDZSJ.this.updateTempBack(this.value);
                    break;
                case 155:
                    this.value = DataCanbus.DATA[updateCode] & 255;
                    AirControlMaiTengDZSJ.this.updateWindMode(this.value);
                    break;
                case 157:
                    if (ConstGolf.isWcGolf()) {
                        AirControlMaiTengDZSJ.this.updateCycle(this.value);
                        break;
                    }
                case 221:
                    if (((ImageView) AirControlMaiTengDZSJ.this.findViewById(R.id.image_RHeatDriver)) != null) {
                        switch (this.value) {
                            case 0:
                                ((ImageView) AirControlMaiTengDZSJ.this.findViewById(R.id.image_RHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_null);
                                break;
                            case 1:
                                ((ImageView) AirControlMaiTengDZSJ.this.findViewById(R.id.image_RHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_r0);
                                break;
                            case 2:
                                ((ImageView) AirControlMaiTengDZSJ.this.findViewById(R.id.image_RHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_r1);
                                break;
                            case 3:
                                ((ImageView) AirControlMaiTengDZSJ.this.findViewById(R.id.image_RHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_r2);
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0017_maiteng_air_dzsj);
        setListener();
        mInstance = this;
    }

    private void setListener() {
        findViewById(R.id.fill_view).setOnClickListener(this);
        findViewById(R.id.view_dzsj_left_list).setOnClickListener(this);
        findViewById(R.id.view_dzsj_right_list).setOnClickListener(this);
        findViewById(R.id.view_dzsj_air_hide).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_clearair)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_dzsj_set)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_steerheat)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_dzsj_power)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_templeft_munits)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_templeft_plus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_cycle)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_tempright_munits)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_tempright_plus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_maxac)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_front)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_dzsj_sync)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_dzsj_rear_lock)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_ac)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_auto)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_manually)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_tempback_munits)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_tempback_plus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_wind0)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_wind1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_wind2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_mode_win)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_mode_body)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_mode_foot)).setOnClickListener(this);
        ((Button) findViewById(R.id.klc_air_control_window_munits_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.klc_air_control_window_plus_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_dzsj_left)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_dzsj_right)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_dzsj_show)).setOnClickListener(this);
    }

    public void show_msgbox() {
        this.Msgbox_Num_p = this.Msgbox_Num;
        setViewVisible(findViewById(R.id.view_dzsj_left_list), this.Msgbox_Num_p == 1);
        setViewVisible(findViewById(R.id.view_dzsj_right_list), this.Msgbox_Num_p == 2);
        setViewVisible(findViewById(R.id.view_dzsj_air_hide), this.Msgbox_Num_p == 3);
    }

    private void setViewVisible(View v, boolean b) {
        if (v != null) {
            v.setVisibility(b ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value = 0;
        int cmdId = 0;
        switch (v.getId()) {
            case R.id.fill_view /* 2131427333 */:
                this.Msgbox_Num = 0;
                if (this.Msgbox_Num_p != 0) {
                    show_msgbox();
                    break;
                }
            case R.id.btn_air_templeft_munits /* 2131427346 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 20;
                    int value2 = DataCanbus.DATA[98] & 255;
                    if (DataCanbus.DATA[156] == 0) {
                        if (value2 == 254 || value2 <= 32) {
                            value = 254;
                            break;
                        } else if (value2 == 255) {
                            value = 59;
                            break;
                        } else {
                            value = value2 - 1;
                            break;
                        }
                    } else if (value2 == 254 || value2 <= 120) {
                        value = 254;
                        break;
                    } else if (value2 == 255) {
                        value = 172;
                        break;
                    } else {
                        value = value2 - 2;
                        break;
                    }
                } else {
                    cmdId = 184;
                    value = 0;
                    break;
                }
            case R.id.btn_air_templeft_plus /* 2131427348 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 20;
                    int value3 = DataCanbus.DATA[98] & 255;
                    if (DataCanbus.DATA[156] == 0) {
                        if (value3 != 254 && value3 >= 32) {
                            if (value3 == 255 || value3 >= 59) {
                                value = 255;
                                break;
                            } else {
                                value = value3 + 1;
                                break;
                            }
                        } else {
                            value = 32;
                            break;
                        }
                    } else if (value3 != 254 && value3 >= 120) {
                        if (value3 == 255 || value3 > 172) {
                            value = 255;
                            break;
                        } else {
                            value = value3 + 2;
                            break;
                        }
                    } else {
                        value = 120;
                        break;
                    }
                } else {
                    cmdId = 184;
                    value = 1;
                    break;
                }
            case R.id.btn_air_tempright_munits /* 2131427350 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 21;
                    int value4 = DataCanbus.DATA[99] & 255;
                    if (DataCanbus.DATA[156] == 0) {
                        if (value4 == 254 || value4 <= 32) {
                            value = 254;
                            break;
                        } else if (value4 == 255) {
                            value = 59;
                            break;
                        } else {
                            value = value4 - 1;
                            break;
                        }
                    } else if (value4 == 254 || value4 <= 120) {
                        value = 254;
                        break;
                    } else if (value4 == 255) {
                        value = 172;
                        break;
                    } else {
                        value = value4 - 2;
                        break;
                    }
                } else {
                    cmdId = 185;
                    value = 0;
                    break;
                }
            case R.id.btn_air_tempright_plus /* 2131427352 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 21;
                    int value5 = DataCanbus.DATA[99] & 255;
                    if (DataCanbus.DATA[156] == 0) {
                        if (value5 != 254 && value5 >= 32) {
                            if (value5 == 255 || value5 >= 59) {
                                value = 255;
                                break;
                            } else {
                                value = value5 + 1;
                                break;
                            }
                        } else {
                            value = 32;
                            break;
                        }
                    } else if (value5 != 254 && value5 >= 120) {
                        if (value5 == 255 || value5 > 172) {
                            value = 255;
                            break;
                        } else {
                            value = value5 + 2;
                            break;
                        }
                    } else {
                        value = 120;
                        break;
                    }
                } else {
                    cmdId = 185;
                    value = 1;
                    break;
                }
            case R.id.btn_air_tempback_munits /* 2131427354 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 22;
                    int value6 = DataCanbus.DATA[154] & 255;
                    if (DataCanbus.DATA[156] == 0) {
                        if (value6 == 254 || value6 <= 32) {
                            value = 254;
                            break;
                        } else if (value6 == 255) {
                            value = 59;
                            break;
                        } else {
                            value = value6 - 1;
                            break;
                        }
                    } else if (value6 == 254 || value6 <= 120) {
                        value = 254;
                        break;
                    } else if (value6 == 255) {
                        value = 172;
                        break;
                    } else {
                        value = value6 - 2;
                        break;
                    }
                } else {
                    cmdId = 186;
                    value = 0;
                    break;
                }
            case R.id.btn_air_tempback_plus /* 2131427356 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 22;
                    int value7 = DataCanbus.DATA[154] & 255;
                    if (DataCanbus.DATA[156] == 0) {
                        if (value7 != 254 && value7 >= 32) {
                            if (value7 == 255 || value7 >= 59) {
                                value = 255;
                                break;
                            } else {
                                value = value7 + 1;
                                break;
                            }
                        } else {
                            value = 32;
                            break;
                        }
                    } else if (value7 != 254 && value7 >= 120) {
                        if (value7 == 255 || value7 > 172) {
                            value = 255;
                            break;
                        } else {
                            value = value7 + 2;
                            break;
                        }
                    } else {
                        value = 120;
                        break;
                    }
                } else {
                    cmdId = 186;
                    value = 1;
                    break;
                }
            case R.id.btn_dzsj_power /* 2131427357 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 2;
                } else {
                    cmdId = 178;
                }
                if (DataCanbus.DATA[87] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.btn_dzsj_sync /* 2131427358 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 17;
                    if (DataCanbus.DATA[90] != 0) {
                        value = 0;
                        break;
                    } else {
                        value = 1;
                        break;
                    }
                } else {
                    cmdId = 179;
                    if (DataCanbus.DATA[100] != 0) {
                        value = 0;
                        break;
                    } else {
                        value = 1;
                        break;
                    }
                }
            case R.id.btn_dzsj_rear_lock /* 2131427359 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 18;
                } else {
                    cmdId = 188;
                }
                if (DataCanbus.DATA[151] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.btn_air_clearair /* 2131427360 */:
                if (DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(this, AirControl_DZSJ_ClearAir.class);
                        startActivity(intent);
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                } else {
                    cmdId = 32;
                    if (DataCanbus.DATA[190] != 1) {
                        value = 1;
                        break;
                    } else {
                        value = 0;
                        break;
                    }
                }
            case R.id.btn_air_steerheat /* 2131427361 */:
                cmdId = 35;
                value = (DataCanbus.DATA[101] + 1) % 2;
                break;
            case R.id.btn_dzsj_set /* 2131427362 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, Golf7FunctionalAirConditionerActi.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    break;
                }
            case R.id.btn_dzsj_left /* 2131427363 */:
                this.Msgbox_Num = 1;
                show_msgbox();
                break;
            case R.id.btn_dzsj_right /* 2131427365 */:
                this.Msgbox_Num = 2;
                show_msgbox();
                break;
            case R.id.btn_dzsj_show /* 2131427367 */:
                this.Msgbox_Num = 3;
                show_msgbox();
                break;
            case R.id.btn_air_auto /* 2131427371 */:
                cmdId = 129;
                value = 0;
                break;
            case R.id.btn_air_maxac /* 2131427373 */:
                cmdId = 129;
                value = 1;
                break;
            case R.id.btn_air_front /* 2131427375 */:
                cmdId = 129;
                value = 2;
                break;
            case R.id.btn_air_manually /* 2131427377 */:
                cmdId = 129;
                value = 3;
                break;
            case R.id.btn_air_wind0 /* 2131427380 */:
                cmdId = 1;
                value = 0;
                break;
            case R.id.btn_air_wind1 /* 2131427382 */:
                cmdId = 1;
                value = 1;
                break;
            case R.id.btn_air_wind2 /* 2131427384 */:
                cmdId = 1;
                value = 2;
                break;
            case R.id.klc_air_control_window_munits_btn /* 2131427386 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 23;
                } else {
                    cmdId = 183;
                }
                value = DataCanbus.DATA[97] - 1;
                if (value <= 0) {
                    value = 0;
                    break;
                }
            case R.id.klc_air_control_window_plus_btn /* 2131427389 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 23;
                } else {
                    cmdId = 183;
                }
                value = DataCanbus.DATA[97] + 1;
                if (value >= 7) {
                    value = 7;
                    break;
                }
            case R.id.btn_air_ac /* 2131427390 */:
                cmdId = 15;
                if (DataCanbus.DATA[91] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.btn_air_mode_win /* 2131427391 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 26;
                    if (DataCanbus.DATA[153] != 0) {
                        value = 0;
                        break;
                    } else {
                        value = 1;
                        break;
                    }
                } else {
                    cmdId = 182;
                    if (DataCanbus.DATA[94] != 0) {
                        value = 0;
                        break;
                    } else {
                        value = 1;
                        break;
                    }
                }
            case R.id.btn_air_mode_body /* 2131427392 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 24;
                } else {
                    cmdId = 180;
                }
                if (DataCanbus.DATA[95] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.btn_air_mode_foot /* 2131427393 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 25;
                } else {
                    cmdId = 181;
                }
                if (DataCanbus.DATA[96] != 0) {
                    value = 0;
                    break;
                } else {
                    value = 1;
                    break;
                }
            case R.id.btn_air_cycle /* 2131427394 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 19;
                    if (DataCanbus.DATA[157] != 0) {
                        value = 0;
                        break;
                    } else {
                        value = 1;
                        break;
                    }
                } else {
                    cmdId = 176;
                    if (DataCanbus.DATA[122] != 0) {
                        value = 0;
                        break;
                    } else {
                        value = 1;
                        break;
                    }
                }
        }
        if (value >= 0 && cmdId > 0) {
            setAirCmd(cmdId, value);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (!ConstGolf.isWcGolf()) {
            setViewVisible((Button) findViewById(R.id.btn_dzsj_left), false);
            setViewVisible((Button) findViewById(R.id.btn_dzsj_right), false);
            setViewVisible((Button) findViewById(R.id.btn_air_clearair), false);
            setViewVisible((Button) findViewById(R.id.btn_air_ac), false);
            setViewVisible((ImageView) findViewById(R.id.iv_dzsj_left), false);
            setViewVisible((ImageView) findViewById(R.id.iv_dzsj_right), false);
            setViewVisible((Button) findViewById(R.id.btn_air_cycle), false);
            setViewVisible((Button) findViewById(R.id.btn_air_steerheat), false);
            setViewVisible((Button) findViewById(R.id.btn_dzsj_set), false);
            setViewVisible((Button) findViewById(R.id.btn_dzsj_rear_lock), false);
            setViewVisible(findViewById(R.id.view_air_tempback), false);
        }
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
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[221].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mCanbusNotify, 1);
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
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[221].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mCanbusNotify);
    }

    protected void updateSeatHotBlow_FR() {
        if (((ImageView) findViewById(R.id.image_FRHeatDriver)) != null) {
            int value1 = DataCanbus.DATA[191];
            int value2 = DataCanbus.DATA[93];
            if (value1 == 0) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.image_FRHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_null);
                        break;
                    case 1:
                        ((ImageView) findViewById(R.id.image_FRHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fr0);
                        break;
                    case 2:
                        ((ImageView) findViewById(R.id.image_FRHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fr1);
                        break;
                    case 3:
                        ((ImageView) findViewById(R.id.image_FRHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fr2);
                        break;
                }
            }
            if (value1 == 1) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.image_FRHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_blow_fr0);
                        break;
                }
            } else if (value1 == 2) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.image_FRHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_blow_fr1);
                        break;
                }
            } else if (value1 == 3) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.image_FRHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_blow_fr2);
                        break;
                }
            }
        }
    }

    protected void updateSeatHotBlow_FL() {
        if (((ImageView) findViewById(R.id.image_FLHeatDriver)) != null) {
            int value1 = DataCanbus.DATA[192];
            int value2 = DataCanbus.DATA[92];
            if (value1 == 0) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.image_FLHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_null);
                        break;
                    case 1:
                        ((ImageView) findViewById(R.id.image_FLHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fl0);
                        break;
                    case 2:
                        ((ImageView) findViewById(R.id.image_FLHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fl1);
                        break;
                    case 3:
                        ((ImageView) findViewById(R.id.image_FLHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fl2);
                        break;
                }
            }
            if (value1 == 1) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.image_FLHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_blow_fl0);
                        break;
                }
            } else if (value1 == 2) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.image_FLHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_blow_fl1);
                        break;
                }
            } else if (value1 == 3) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.image_FLHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_blow_fl2);
                        break;
                }
            }
        }
    }

    protected void uRearSteerHeat(int val) {
        if (((Button) findViewById(R.id.btn_air_steerheat)) != null) {
            ((Button) findViewById(R.id.btn_air_steerheat)).setBackgroundResource(val == 0 ? R.drawable.ic_dzsj_dz_steer_hot : R.drawable.ic_dzsj_dz_steer_hot_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempLeft(int value) {
        Boolean isHot = false;
        if (((TextView) findViewById(R.id.tv_air_templeft)) != null) {
            if (ConstGolf.isWcGolf()) {
                switch (value) {
                    case 254:
                        ((TextView) findViewById(R.id.tv_air_templeft)).setText("LO");
                        break;
                    case 255:
                        ((TextView) findViewById(R.id.tv_air_templeft)).setText("HI");
                        isHot = true;
                        break;
                    default:
                        if (DataCanbus.DATA[156] == 0) {
                            ((TextView) findViewById(R.id.tv_air_templeft)).setText((value / 2.0f) + "℃");
                            if (value >= 46) {
                                isHot = true;
                                break;
                            }
                        } else {
                            ((TextView) findViewById(R.id.tv_air_templeft)).setText((value / 2.0f) + "℉");
                            if (value >= 147) {
                                isHot = true;
                                break;
                            }
                        }
                        break;
                }
            } else {
                switch (value) {
                    case 0:
                        ((TextView) findViewById(R.id.tv_air_templeft)).setText("LO");
                        break;
                    case 31:
                        ((TextView) findViewById(R.id.tv_air_templeft)).setText("HI");
                        isHot = true;
                        break;
                    default:
                        if (DataCanbus.DATA[156] == 0) {
                            int value2 = (value * 5) + 155;
                            ((TextView) findViewById(R.id.tv_air_templeft)).setText((value2 / 10.0f) + "℃");
                            if (value2 >= 230) {
                                isHot = true;
                                break;
                            }
                        } else {
                            ((TextView) findViewById(R.id.tv_air_templeft)).setText((value / 2.0f) + "℉");
                            if (value + 59 >= 147) {
                                isHot = true;
                                break;
                            }
                        }
                        break;
                }
            }
        }
        if (((ImageView) findViewById(R.id.image_air_mode_win)) != null) {
            ((ImageView) findViewById(R.id.image_air_mode_win)).setBackgroundResource(isHot.booleanValue() ? R.drawable.air_maiteng_dzsj_up_p : R.drawable.air_maiteng_dzsj_up);
        }
        if (((ImageView) findViewById(R.id.image_air_mode_body)) != null) {
            ((ImageView) findViewById(R.id.image_air_mode_body)).setBackgroundResource(isHot.booleanValue() ? R.drawable.air_maiteng_dzsj_body_p : R.drawable.air_maiteng_dzsj_body);
        }
        if (((ImageView) findViewById(R.id.image_air_mode_foot)) != null) {
            ((ImageView) findViewById(R.id.image_air_mode_foot)).setBackgroundResource(isHot.booleanValue() ? R.drawable.air_maiteng_dzsj_foot_p : R.drawable.air_maiteng_dzsj_foot);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempRight(int value) {
        Boolean isHot = false;
        if (((TextView) findViewById(R.id.tv_air_tempright)) != null) {
            if (ConstGolf.isWcGolf()) {
                switch (value) {
                    case 254:
                        ((TextView) findViewById(R.id.tv_air_tempright)).setText("LO");
                        break;
                    case 255:
                        ((TextView) findViewById(R.id.tv_air_tempright)).setText("HI");
                        isHot = true;
                        break;
                    default:
                        if (DataCanbus.DATA[156] == 0) {
                            ((TextView) findViewById(R.id.tv_air_tempright)).setText((value / 2.0f) + "℃");
                            if (value >= 46) {
                                isHot = true;
                                break;
                            }
                        } else {
                            ((TextView) findViewById(R.id.tv_air_tempright)).setText((value / 2.0f) + "℉");
                            if (value >= 147) {
                                isHot = true;
                                break;
                            }
                        }
                        break;
                }
            } else {
                switch (value) {
                    case 0:
                        ((TextView) findViewById(R.id.tv_air_tempright)).setText("LO");
                        break;
                    case 31:
                        ((TextView) findViewById(R.id.tv_air_tempright)).setText("HI");
                        isHot = true;
                        break;
                    default:
                        if (DataCanbus.DATA[156] == 0) {
                            int value2 = (value * 5) + 155;
                            ((TextView) findViewById(R.id.tv_air_tempright)).setText((value2 / 10.0f) + "℃");
                            if (value2 >= 230) {
                                isHot = true;
                                break;
                            }
                        } else {
                            ((TextView) findViewById(R.id.tv_air_tempright)).setText((value / 2.0f) + "℉");
                            if (value + 59 >= 147) {
                                isHot = true;
                                break;
                            }
                        }
                        break;
                }
            }
        }
        if (((ImageView) findViewById(R.id.image_air_mode_win_r)) != null) {
            ((ImageView) findViewById(R.id.image_air_mode_win_r)).setBackgroundResource(isHot.booleanValue() ? R.drawable.air_maiteng_dzsj_up_r_p : R.drawable.air_maiteng_dzsj_up_r);
        }
        if (((ImageView) findViewById(R.id.image_air_mode_body_r)) != null) {
            ((ImageView) findViewById(R.id.image_air_mode_body_r)).setBackgroundResource(isHot.booleanValue() ? R.drawable.air_maiteng_dzsj_body_r_p : R.drawable.air_maiteng_dzsj_body_r);
        }
        if (((ImageView) findViewById(R.id.image_air_mode_foot_r)) != null) {
            ((ImageView) findViewById(R.id.image_air_mode_foot_r)).setBackgroundResource(isHot.booleanValue() ? R.drawable.air_maiteng_dzsj_foot_r_p : R.drawable.air_maiteng_dzsj_foot_r);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempBack(int value) {
        Boolean isHot = false;
        if (((TextView) findViewById(R.id.tv_air_tempback)) != null) {
            if (ConstGolf.isWcGolf()) {
                switch (value) {
                    case 254:
                        ((TextView) findViewById(R.id.tv_air_tempback)).setText("LO");
                        break;
                    case 255:
                        ((TextView) findViewById(R.id.tv_air_tempback)).setText("HI");
                        isHot = true;
                        break;
                    default:
                        if (DataCanbus.DATA[156] == 0) {
                            ((TextView) findViewById(R.id.tv_air_tempback)).setText((value / 2.0f) + "℃");
                            if (value >= 46) {
                                isHot = true;
                                break;
                            }
                        } else {
                            ((TextView) findViewById(R.id.tv_air_tempback)).setText((value / 2.0f) + "℉");
                            if (value >= 147) {
                                isHot = true;
                                break;
                            }
                        }
                        break;
                }
            } else {
                switch (value) {
                    case 0:
                        ((TextView) findViewById(R.id.tv_air_tempback)).setText("LO");
                        break;
                    case 31:
                        ((TextView) findViewById(R.id.tv_air_tempback)).setText("HI");
                        isHot = true;
                        break;
                    default:
                        if (DataCanbus.DATA[156] == 0) {
                            int value2 = (value * 5) + 155;
                            ((TextView) findViewById(R.id.tv_air_tempback)).setText((value2 / 10.0f) + "℃");
                            if (value2 >= 230) {
                                isHot = true;
                                break;
                            }
                        } else {
                            ((TextView) findViewById(R.id.tv_air_tempback)).setText((value / 2.0f) + "℉");
                            if (value + 59 >= 147) {
                                isHot = true;
                                break;
                            }
                        }
                        break;
                }
            }
        }
        if (((ImageView) findViewById(R.id.image_air_mode_rear_body)) != null) {
            ((ImageView) findViewById(R.id.image_air_mode_rear_body)).setBackgroundResource(isHot.booleanValue() ? R.drawable.air_maiteng_dzsj_rear_body_p : R.drawable.air_maiteng_dzsj_rear_body);
        }
        if (((ImageView) findViewById(R.id.image_air_mode_rear_foot)) != null) {
            ((ImageView) findViewById(R.id.image_air_mode_rear_foot)).setBackgroundResource(isHot.booleanValue() ? R.drawable.air_maiteng_dzsj_rear_foot_p : R.drawable.air_maiteng_dzsj_rear_foot);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePower(int value) {
        if (((Button) findViewById(R.id.btn_dzsj_power)) != null) {
            ((Button) findViewById(R.id.btn_dzsj_power)).setBackgroundResource(value == 0 ? R.drawable.ic_dzsj_dz_power_p : R.drawable.ic_dzsj_dz_power);
        }
        if (value == 0) {
            setViewVisible((ImageView) findViewById(R.id.image_air_mode_win), false);
            setViewVisible((ImageView) findViewById(R.id.image_air_mode_body), false);
            setViewVisible((ImageView) findViewById(R.id.image_air_mode_foot), false);
            setViewVisible((ImageView) findViewById(R.id.image_air_mode_win_r), false);
            setViewVisible((ImageView) findViewById(R.id.image_air_mode_body_r), false);
            setViewVisible((ImageView) findViewById(R.id.image_air_mode_foot_r), false);
            setViewVisible((ImageView) findViewById(R.id.image_air_mode_rear_body), false);
            setViewVisible((ImageView) findViewById(R.id.image_air_mode_rear_foot), false);
            setViewVisible((ImageView) findViewById(R.id.image_air_mode_rear_foot), false);
            setViewVisible(findViewById(R.id.view_air_tempright), false);
            setViewVisible(findViewById(R.id.view_air_templeft), false);
            setViewVisible(findViewById(R.id.view_air_tempback), false);
            setViewVisible(findViewById(R.id.view_dzsj_air_hide), false);
            setViewVisible((Button) findViewById(R.id.btn_dzsj_show), false);
            if (((ProgressBar) findViewById(R.id.pb_wind_progress)) != null) {
                ((ProgressBar) findViewById(R.id.pb_wind_progress)).setProgress(0);
                return;
            }
            return;
        }
        setViewVisible(findViewById(R.id.view_air_tempright), true);
        setViewVisible(findViewById(R.id.view_air_templeft), true);
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.view_air_tempback), true);
        }
        setViewVisible((Button) findViewById(R.id.btn_dzsj_show), true);
        if (((ProgressBar) findViewById(R.id.pb_wind_progress)) != null) {
            ((ProgressBar) findViewById(R.id.pb_wind_progress)).setProgress(DataCanbus.DATA[97]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAC(int value) {
        if (((Button) findViewById(R.id.btn_air_ac)) != null) {
            ((Button) findViewById(R.id.btn_air_ac)).setBackgroundResource(value == 0 ? R.drawable.ic_dzsj_dz_ac : R.drawable.ic_dzsj_dz_ac_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCycle(int value) {
        if (((Button) findViewById(R.id.btn_air_cycle)) != null) {
            ((Button) findViewById(R.id.btn_air_cycle)).setBackgroundResource(value == 0 ? R.drawable.ic_dzsj_dz_cycle : R.drawable.ic_dzsj_dz_cycle_p);
        }
    }

    protected void uClearAir(int value2) {
        if (((Button) findViewById(R.id.btn_air_clearair)) != null) {
            ((Button) findViewById(R.id.btn_air_clearair)).setBackgroundResource(value2 == 0 ? R.drawable.ic_dzsj_dz_clean_air : R.drawable.ic_dzsj_dz_clean_air_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWindMode(int value) {
        int i = R.drawable.ic_dzsj_dz_list_bingo_p;
        if (((ImageView) findViewById(R.id.iv_dzsj_right)) != null) {
            switch (value) {
                case 0:
                    ((ImageView) findViewById(R.id.iv_dzsj_right)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dzsj_dz_wind_right0));
                    break;
                case 1:
                    ((ImageView) findViewById(R.id.iv_dzsj_right)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dzsj_dz_wind_right1));
                    break;
                case 2:
                    ((ImageView) findViewById(R.id.iv_dzsj_right)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dzsj_dz_wind_right2));
                    break;
            }
        }
        if (((ImageView) findViewById(R.id.iv_air_wind0)) != null) {
            ((ImageView) findViewById(R.id.iv_air_wind0)).setImageDrawable(getResources().getDrawable(value == 0 ? 2130839578 : 2130839577));
        }
        if (((ImageView) findViewById(R.id.iv_air_wind1)) != null) {
            ((ImageView) findViewById(R.id.iv_air_wind1)).setImageDrawable(getResources().getDrawable(value == 1 ? 2130839578 : 2130839577));
        }
        if (((ImageView) findViewById(R.id.iv_air_wind2)) != null) {
            ImageView imageView = (ImageView) findViewById(R.id.iv_air_wind2);
            Resources resources = getResources();
            if (value != 2) {
                i = 2130839577;
            }
            imageView.setImageDrawable(resources.getDrawable(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRearLock(int value) {
        if (((Button) findViewById(R.id.btn_dzsj_rear_lock)) != null) {
            ((Button) findViewById(R.id.btn_dzsj_rear_lock)).setBackgroundResource(value == 0 ? R.drawable.ic_dzsj_dz_rear : R.drawable.ic_dzsj_dz_rear_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowWin(int value) {
        if (((Button) findViewById(R.id.btn_air_mode_win)) != null) {
            ((Button) findViewById(R.id.btn_air_mode_win)).setBackgroundResource(value == 0 ? R.drawable.ic_dzsj_dz_up : R.drawable.ic_dzsj_dz_up_p);
        }
        if (((ImageView) findViewById(R.id.image_air_mode_win)) != null) {
            ((ImageView) findViewById(R.id.image_air_mode_win)).setVisibility((value == 0 || DataCanbus.DATA[87] == 0) ? 8 : 0);
        }
        if (((ImageView) findViewById(R.id.image_air_mode_win_r)) != null) {
            ((ImageView) findViewById(R.id.image_air_mode_win_r)).setVisibility((value == 0 || DataCanbus.DATA[87] == 0) ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowBody(int value) {
        if (((Button) findViewById(R.id.btn_air_mode_body)) != null) {
            ((Button) findViewById(R.id.btn_air_mode_body)).setBackgroundResource(value == 0 ? R.drawable.ic_dzsj_dz_body : R.drawable.ic_dzsj_dz_body_p);
        }
        if (((ImageView) findViewById(R.id.image_air_mode_body)) != null) {
            ((ImageView) findViewById(R.id.image_air_mode_body)).setVisibility((value == 0 || DataCanbus.DATA[87] == 0) ? 8 : 0);
        }
        if (((ImageView) findViewById(R.id.image_air_mode_body_r)) != null) {
            ((ImageView) findViewById(R.id.image_air_mode_body_r)).setVisibility((value == 0 || DataCanbus.DATA[87] == 0) ? 8 : 0);
        }
        if (((ImageView) findViewById(R.id.image_air_mode_rear_body)) != null) {
            if (ConstGolf.isWcGolf()) {
                ((ImageView) findViewById(R.id.image_air_mode_rear_body)).setVisibility((value == 0 || DataCanbus.DATA[87] == 0) ? 8 : 0);
            } else {
                ((ImageView) findViewById(R.id.image_air_mode_rear_body)).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowFoot(int value) {
        if (((Button) findViewById(R.id.btn_air_mode_foot)) != null) {
            ((Button) findViewById(R.id.btn_air_mode_foot)).setBackgroundResource(value == 0 ? R.drawable.ic_dzsj_dz_foot : R.drawable.ic_dzsj_dz_foot_p);
        }
        if (((ImageView) findViewById(R.id.image_air_mode_foot)) != null) {
            ((ImageView) findViewById(R.id.image_air_mode_foot)).setVisibility((value == 0 || DataCanbus.DATA[87] == 0) ? 8 : 0);
        }
        if (((ImageView) findViewById(R.id.image_air_mode_foot_r)) != null) {
            ((ImageView) findViewById(R.id.image_air_mode_foot_r)).setVisibility((value == 0 || DataCanbus.DATA[87] == 0) ? 8 : 0);
        }
        if (((ImageView) findViewById(R.id.image_air_mode_rear_foot)) != null) {
            if (ConstGolf.isWcGolf()) {
                ((ImageView) findViewById(R.id.image_air_mode_rear_foot)).setVisibility((value == 0 || DataCanbus.DATA[87] == 0) ? 8 : 0);
            } else {
                ((ImageView) findViewById(R.id.image_air_mode_rear_foot)).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAuto() {
        int LeftList_Num = 3;
        if (DataCanbus.DATA[88] == 1) {
            LeftList_Num = 1;
        }
        if (DataCanbus.DATA[153] == 1 && DataCanbus.DATA[95] == 0 && DataCanbus.DATA[96] == 0) {
            LeftList_Num = 2;
        }
        if (DataCanbus.DATA[89] == 1) {
            LeftList_Num = 0;
        }
        show_left(LeftList_Num);
    }

    void show_left(int LeftList_Num) {
        int i = R.drawable.ic_dzsj_dz_list_bingo_p;
        if (((ImageView) findViewById(R.id.iv_dzsj_left)) != null) {
            switch (LeftList_Num) {
                case 0:
                    ((ImageView) findViewById(R.id.iv_dzsj_left)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dzsj_dz_auto));
                    break;
                case 1:
                    ((ImageView) findViewById(R.id.iv_dzsj_left)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dzsj_dz_maxac));
                    break;
                case 2:
                    ((ImageView) findViewById(R.id.iv_dzsj_left)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dzsj_dz_max));
                    break;
                case 3:
                    ((ImageView) findViewById(R.id.iv_dzsj_left)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dzsj_dz_manual));
                    break;
            }
        }
        if (((ImageView) findViewById(R.id.iv_air_maxac)) != null) {
            ((ImageView) findViewById(R.id.iv_air_maxac)).setImageDrawable(getResources().getDrawable(LeftList_Num == 1 ? 2130839578 : 2130839577));
        }
        if (((ImageView) findViewById(R.id.iv_air_front)) != null) {
            ((ImageView) findViewById(R.id.iv_air_front)).setImageDrawable(getResources().getDrawable(LeftList_Num == 2 ? 2130839578 : 2130839577));
        }
        if (((ImageView) findViewById(R.id.iv_air_auto)) != null) {
            ((ImageView) findViewById(R.id.iv_air_auto)).setImageDrawable(getResources().getDrawable(LeftList_Num == 0 ? 2130839578 : 2130839577));
        }
        if (((ImageView) findViewById(R.id.iv_air_manually)) != null) {
            ImageView imageView = (ImageView) findViewById(R.id.iv_air_manually);
            Resources resources = getResources();
            if (LeftList_Num != 3) {
                i = 2130839577;
            }
            imageView.setImageDrawable(resources.getDrawable(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSync(int value) {
        if (((Button) findViewById(R.id.btn_dzsj_sync)) != null) {
            ((Button) findViewById(R.id.btn_dzsj_sync)).setBackgroundResource(value == 0 ? R.drawable.ic_dzsj_dz_sync : R.drawable.ic_dzsj_dz_sync_p);
        }
    }

    void mUpdaterAirWindLevelLeft(int value) {
        if (DataCanbus.DATA[87] == 0) {
            value = 0;
        }
        if (((ProgressBar) findViewById(R.id.pb_wind_progress)) != null) {
            ((ProgressBar) findViewById(R.id.pb_wind_progress)).setProgress(value);
        }
    }
}