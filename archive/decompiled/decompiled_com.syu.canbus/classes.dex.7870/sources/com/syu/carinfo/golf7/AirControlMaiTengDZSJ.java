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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
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
                case 10:
                    AirControlMaiTengDZSJ.this.updatePower(this.value);
                    if (ConstGolf.isWcGolf()) {
                        AirControlMaiTengDZSJ.this.updateBlowWin(DataCanbus.DATA[18]);
                    } else {
                        AirControlMaiTengDZSJ.this.updateBlowWin(DataCanbus.DATA[18]);
                    }
                    break;
                case 11:
                    AirControlMaiTengDZSJ.this.updateAC(this.value);
                    break;
                case 12:
                    if (!ConstGolf.isWcGolf()) {
                        AirControlMaiTengDZSJ.this.updateCycle(this.value);
                    } else {
                        AirControlMaiTengDZSJ.this.updateCycle(this.value);
                    }
                    break;
                case 13:
                case 53:
                    AirControlMaiTengDZSJ.this.updateAuto();
                    break;
                case 14:
                    if (!ConstGolf.isWcGolf()) {
                        AirControlMaiTengDZSJ.this.updateSync(this.value);
                    }
                    break;
                case 18:
                    if (ConstGolf.isWcGolf()) {
                        AirControlMaiTengDZSJ.this.updateBlowWin(this.value);
                        AirControlMaiTengDZSJ.this.updateAuto();
                    } else {
                        AirControlMaiTengDZSJ.this.updateBlowWin(this.value);
                    }
                    break;
                case 19:
                    AirControlMaiTengDZSJ.this.updateBlowBody(this.value);
                    AirControlMaiTengDZSJ.this.updateAuto();
                    break;
                case 20:
                    AirControlMaiTengDZSJ.this.updateBlowFoot(this.value);
                    AirControlMaiTengDZSJ.this.updateAuto();
                    break;
                case 21:
                    AirControlMaiTengDZSJ.this.mUpdaterAirWindLevelLeft(this.value);
                    break;
                case 27:
                    AirControlMaiTengDZSJ.this.updateTempLeft(this.value);
                    break;
                case 28:
                    AirControlMaiTengDZSJ.this.updateTempRight(this.value);
                    break;
                case 29:
                case 31:
                    AirControlMaiTengDZSJ.this.updateSeatHotBlow_FL();
                    break;
                case 30:
                case 32:
                    AirControlMaiTengDZSJ.this.updateSeatHotBlow_FR();
                    break;
                case 40:
                    AirControlMaiTengDZSJ.this.updateTempBack(this.value);
                    break;
                case 55:
                    if (((ImageView) AirControlMaiTengDZSJ.this.findViewById(R.id.layout_view12)) != null) {
                        switch (this.value) {
                            case 0:
                                ((ImageView) AirControlMaiTengDZSJ.this.findViewById(R.id.layout_view12)).setBackgroundResource(R.drawable.air_maiteng_dzsj_null);
                                break;
                            case 1:
                                ((ImageView) AirControlMaiTengDZSJ.this.findViewById(R.id.layout_view12)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_r0);
                                break;
                            case 2:
                                ((ImageView) AirControlMaiTengDZSJ.this.findViewById(R.id.layout_view12)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_r1);
                                break;
                            case 3:
                                ((ImageView) AirControlMaiTengDZSJ.this.findViewById(R.id.layout_view12)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_r2);
                                break;
                        }
                    }
                    break;
                case 62:
                    if (ConstGolf.isWcGolf()) {
                        AirControlMaiTengDZSJ.this.updateSync(this.value);
                    }
                    break;
                case 66:
                    AirControlMaiTengDZSJ.this.uRearSteerHeat(this.value);
                    break;
                case 67:
                    AirControlMaiTengDZSJ.this.updateRearLock(this.value);
                    break;
                case 69:
                    this.value = DataCanbus.DATA[updateCode] & 255;
                    AirControlMaiTengDZSJ.this.updateWindMode(this.value);
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
        findViewById(R.id.layout_view1).setOnClickListener(this);
        findViewById(R.id.view_dzsj_left_list).setOnClickListener(this);
        findViewById(R.id.view_dzsj_right_list).setOnClickListener(this);
        findViewById(R.id.view_dzsj_air_hide).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_clearair)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_dzsj_set)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_steerheat)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_dzsj_power)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_cycle)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_maxac)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_front)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_dzsj_sync)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_dzsj_rear_lock)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_ac)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_auto)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_manually)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
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
            case R.id.btn_dzsj_power /* 2131427356 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 2;
                } else {
                    cmdId = 178;
                }
                value = DataCanbus.DATA[10] != 0 ? 0 : 1;
                break;
            case R.id.btn_dzsj_sync /* 2131427357 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 17;
                    value = DataCanbus.DATA[62] != 0 ? 0 : 1;
                } else {
                    cmdId = 179;
                    value = DataCanbus.DATA[14] != 0 ? 0 : 1;
                }
                break;
            case R.id.btn_dzsj_rear_lock /* 2131427358 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 18;
                } else {
                    cmdId = 188;
                }
                value = DataCanbus.DATA[67] != 0 ? 0 : 1;
                break;
            case R.id.btn_air_clearair /* 2131427359 */:
                if (DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(this, AirControl_DZSJ_ClearAir.class);
                        startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    cmdId = 32;
                    value = DataCanbus.DATA[76] != 1 ? 1 : 0;
                }
                break;
            case R.id.btn_air_steerheat /* 2131427360 */:
                cmdId = 35;
                value = (DataCanbus.DATA[66] + 1) % 2;
                break;
            case R.id.btn_dzsj_set /* 2131427361 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, Golf7FunctionalAirConditionerActi.class);
                    startActivity(intent2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                break;
            case R.id.btn_dzsj_left /* 2131427362 */:
                this.Msgbox_Num = 1;
                show_msgbox();
                break;
            case R.id.btn_dzsj_right /* 2131427364 */:
                this.Msgbox_Num = 2;
                show_msgbox();
                break;
            case R.id.btn_dzsj_show /* 2131427366 */:
                this.Msgbox_Num = 3;
                show_msgbox();
                break;
            case R.id.btn_air_auto /* 2131427370 */:
                cmdId = 129;
                value = 0;
                break;
            case R.id.btn_air_maxac /* 2131427372 */:
                cmdId = 129;
                value = 1;
                break;
            case R.id.btn_air_front /* 2131427374 */:
                cmdId = 129;
                value = 2;
                break;
            case R.id.btn_air_manually /* 2131427376 */:
                cmdId = 129;
                value = 3;
                break;
            case R.id.btn_air_wind0 /* 2131427379 */:
                cmdId = 1;
                value = 0;
                break;
            case R.id.btn_air_wind1 /* 2131427381 */:
                cmdId = 1;
                value = 1;
                break;
            case R.id.btn_air_wind2 /* 2131427383 */:
                cmdId = 1;
                value = 2;
                break;
            case R.id.klc_air_control_window_munits_btn /* 2131427385 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 23;
                } else {
                    cmdId = 183;
                }
                value = DataCanbus.DATA[21] - 1;
                if (value <= 0) {
                    value = 0;
                }
                break;
            case R.id.klc_air_control_window_plus_btn /* 2131427388 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 23;
                } else {
                    cmdId = 183;
                }
                value = DataCanbus.DATA[21] + 1;
                if (value >= 7) {
                    value = 7;
                }
                break;
            case R.id.btn_air_ac /* 2131427389 */:
                cmdId = 15;
                value = DataCanbus.DATA[11] != 0 ? 0 : 1;
                break;
            case R.id.btn_air_mode_win /* 2131427390 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 26;
                    value = DataCanbus.DATA[18] != 0 ? 0 : 1;
                } else {
                    cmdId = 182;
                    value = DataCanbus.DATA[18] != 0 ? 0 : 1;
                }
                break;
            case R.id.btn_air_mode_body /* 2131427391 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 24;
                } else {
                    cmdId = 180;
                }
                value = DataCanbus.DATA[19] != 0 ? 0 : 1;
                break;
            case R.id.btn_air_mode_foot /* 2131427392 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 25;
                } else {
                    cmdId = 181;
                }
                value = DataCanbus.DATA[20] != 0 ? 0 : 1;
                break;
            case R.id.btn_air_cycle /* 2131427393 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 19;
                    value = DataCanbus.DATA[12] != 0 ? 0 : 1;
                } else {
                    cmdId = 176;
                    value = DataCanbus.DATA[12] != 0 ? 0 : 1;
                }
                break;
            case R.id.layout_view1 /* 2131427404 */:
                this.Msgbox_Num = 0;
                if (this.Msgbox_Num_p != 0) {
                    show_msgbox();
                }
                break;
            case R.id.btn_minus1 /* 2131427417 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 20;
                    int value2 = DataCanbus.DATA[27] & 255;
                    if (DataCanbus.DATA[37] == 0) {
                        if (value2 == 254 || value2 <= 32) {
                            value = 254;
                        } else if (value2 == 255) {
                            value = 59;
                        } else {
                            value = value2 - 1;
                        }
                    } else if (value2 == 254 || value2 <= 120) {
                        value = 254;
                    } else if (value2 == 255) {
                        value = 172;
                    } else {
                        value = value2 - 2;
                    }
                } else {
                    cmdId = 184;
                    value = 0;
                }
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 20;
                    int value3 = DataCanbus.DATA[27] & 255;
                    if (DataCanbus.DATA[37] == 0) {
                        if (value3 == 254 || value3 < 32) {
                            value = 32;
                        } else {
                            value = (value3 == 255 || value3 >= 59) ? 255 : value3 + 1;
                        }
                    } else if (value3 == 254 || value3 < 120) {
                        value = 120;
                    } else {
                        value = (value3 == 255 || value3 > 172) ? 255 : value3 + 2;
                    }
                } else {
                    cmdId = 184;
                    value = 1;
                }
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 21;
                    int value4 = DataCanbus.DATA[28] & 255;
                    if (DataCanbus.DATA[37] == 0) {
                        if (value4 == 254 || value4 <= 32) {
                            value = 254;
                        } else if (value4 == 255) {
                            value = 59;
                        } else {
                            value = value4 - 1;
                        }
                    } else if (value4 == 254 || value4 <= 120) {
                        value = 254;
                    } else if (value4 == 255) {
                        value = 172;
                    } else {
                        value = value4 - 2;
                    }
                } else {
                    cmdId = 185;
                    value = 0;
                }
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 21;
                    int value5 = DataCanbus.DATA[28] & 255;
                    if (DataCanbus.DATA[37] == 0) {
                        if (value5 == 254 || value5 < 32) {
                            value = 32;
                        } else {
                            value = (value5 == 255 || value5 >= 59) ? 255 : value5 + 1;
                        }
                    } else if (value5 == 254 || value5 < 120) {
                        value = 120;
                    } else {
                        value = (value5 == 255 || value5 > 172) ? 255 : value5 + 2;
                    }
                } else {
                    cmdId = 185;
                    value = 1;
                }
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 22;
                    int value6 = DataCanbus.DATA[40] & 255;
                    if (DataCanbus.DATA[37] == 0) {
                        if (value6 == 254 || value6 <= 32) {
                            value = 254;
                        } else if (value6 == 255) {
                            value = 59;
                        } else {
                            value = value6 - 1;
                        }
                    } else if (value6 == 254 || value6 <= 120) {
                        value = 254;
                    } else if (value6 == 255) {
                        value = 172;
                    } else {
                        value = value6 - 2;
                    }
                } else {
                    cmdId = 186;
                    value = 0;
                }
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                if (ConstGolf.isWcGolf()) {
                    cmdId = 22;
                    int value7 = DataCanbus.DATA[40] & 255;
                    if (DataCanbus.DATA[37] == 0) {
                        if (value7 == 254 || value7 < 32) {
                            value = 32;
                        } else {
                            value = (value7 == 255 || value7 >= 59) ? 255 : value7 + 1;
                        }
                    } else if (value7 == 254 || value7 < 120) {
                        value = 120;
                    } else {
                        value = (value7 == 255 || value7 > 172) ? 255 : value7 + 2;
                    }
                } else {
                    cmdId = 186;
                    value = 1;
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
            setViewVisible(findViewById(R.id.layout_view15), false);
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
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mCanbusNotify);
    }

    protected void updateSeatHotBlow_FR() {
        if (((ImageView) findViewById(R.id.layout_view11)) != null) {
            int value1 = DataCanbus.DATA[32];
            int value2 = DataCanbus.DATA[30];
            if (value1 == 0) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.layout_view11)).setBackgroundResource(R.drawable.air_maiteng_dzsj_null);
                        break;
                    case 1:
                        ((ImageView) findViewById(R.id.layout_view11)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fr0);
                        break;
                    case 2:
                        ((ImageView) findViewById(R.id.layout_view11)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fr1);
                        break;
                    case 3:
                        ((ImageView) findViewById(R.id.layout_view11)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fr2);
                        break;
                }
            }
            if (value1 == 1) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.layout_view11)).setBackgroundResource(R.drawable.air_maiteng_dzsj_blow_fr0);
                        break;
                }
            } else if (value1 == 2) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.layout_view11)).setBackgroundResource(R.drawable.air_maiteng_dzsj_blow_fr1);
                        break;
                }
            } else if (value1 == 3) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.layout_view11)).setBackgroundResource(R.drawable.air_maiteng_dzsj_blow_fr2);
                        break;
                }
            }
        }
    }

    protected void updateSeatHotBlow_FL() {
        if (((ImageView) findViewById(R.id.layout_view10)) != null) {
            int value1 = DataCanbus.DATA[31];
            int value2 = DataCanbus.DATA[29];
            if (value1 == 0) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.layout_view10)).setBackgroundResource(R.drawable.air_maiteng_dzsj_null);
                        break;
                    case 1:
                        ((ImageView) findViewById(R.id.layout_view10)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fl0);
                        break;
                    case 2:
                        ((ImageView) findViewById(R.id.layout_view10)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fl1);
                        break;
                    case 3:
                        ((ImageView) findViewById(R.id.layout_view10)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fl2);
                        break;
                }
            }
            if (value1 == 1) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.layout_view10)).setBackgroundResource(R.drawable.air_maiteng_dzsj_blow_fl0);
                        break;
                }
            } else if (value1 == 2) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.layout_view10)).setBackgroundResource(R.drawable.air_maiteng_dzsj_blow_fl1);
                        break;
                }
            } else if (value1 == 3) {
                switch (value2) {
                    case 0:
                        ((ImageView) findViewById(R.id.layout_view10)).setBackgroundResource(R.drawable.air_maiteng_dzsj_blow_fl2);
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
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (ConstGolf.isWcGolf()) {
                switch (value) {
                    case 254:
                        ((TextView) findViewById(R.id.tv_text1)).setText("LO");
                        break;
                    case 255:
                        ((TextView) findViewById(R.id.tv_text1)).setText("HI");
                        isHot = true;
                        break;
                    default:
                        if (DataCanbus.DATA[37] == 0) {
                            ((TextView) findViewById(R.id.tv_text1)).setText((value / 2.0f) + "℃");
                            if (value >= 46) {
                                isHot = true;
                            }
                        } else {
                            ((TextView) findViewById(R.id.tv_text1)).setText((value / 2.0f) + "℉");
                            if (value >= 147) {
                                isHot = true;
                            }
                        }
                        break;
                }
            } else {
                switch (value) {
                    case 0:
                        ((TextView) findViewById(R.id.tv_text1)).setText("LO");
                        break;
                    case 31:
                        ((TextView) findViewById(R.id.tv_text1)).setText("HI");
                        isHot = true;
                        break;
                    default:
                        if (DataCanbus.DATA[37] == 0) {
                            int value2 = (value * 5) + 155;
                            ((TextView) findViewById(R.id.tv_text1)).setText((value2 / 10.0f) + "℃");
                            if (value2 >= 230) {
                                isHot = true;
                            }
                        } else {
                            ((TextView) findViewById(R.id.tv_text1)).setText((value / 2.0f) + "℉");
                            if (value + 59 >= 147) {
                                isHot = true;
                            }
                        }
                        break;
                }
            }
        }
        if (((ImageView) findViewById(R.id.layout_view2)) != null) {
            ((ImageView) findViewById(R.id.layout_view2)).setBackgroundResource(isHot.booleanValue() ? R.drawable.air_maiteng_dzsj_up_p : R.drawable.air_maiteng_dzsj_up);
        }
        if (((ImageView) findViewById(R.id.layout_view4)) != null) {
            ((ImageView) findViewById(R.id.layout_view4)).setBackgroundResource(isHot.booleanValue() ? R.drawable.air_maiteng_dzsj_body_p : R.drawable.air_maiteng_dzsj_body);
        }
        if (((ImageView) findViewById(R.id.layout_view6)) != null) {
            ((ImageView) findViewById(R.id.layout_view6)).setBackgroundResource(isHot.booleanValue() ? R.drawable.air_maiteng_dzsj_foot_p : R.drawable.air_maiteng_dzsj_foot);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempRight(int value) {
        Boolean isHot = false;
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (ConstGolf.isWcGolf()) {
                switch (value) {
                    case 254:
                        ((TextView) findViewById(R.id.tv_text2)).setText("LO");
                        break;
                    case 255:
                        ((TextView) findViewById(R.id.tv_text2)).setText("HI");
                        isHot = true;
                        break;
                    default:
                        if (DataCanbus.DATA[37] == 0) {
                            ((TextView) findViewById(R.id.tv_text2)).setText((value / 2.0f) + "℃");
                            if (value >= 46) {
                                isHot = true;
                            }
                        } else {
                            ((TextView) findViewById(R.id.tv_text2)).setText((value / 2.0f) + "℉");
                            if (value >= 147) {
                                isHot = true;
                            }
                        }
                        break;
                }
            } else {
                switch (value) {
                    case 0:
                        ((TextView) findViewById(R.id.tv_text2)).setText("LO");
                        break;
                    case 31:
                        ((TextView) findViewById(R.id.tv_text2)).setText("HI");
                        isHot = true;
                        break;
                    default:
                        if (DataCanbus.DATA[37] == 0) {
                            int value2 = (value * 5) + 155;
                            ((TextView) findViewById(R.id.tv_text2)).setText((value2 / 10.0f) + "℃");
                            if (value2 >= 230) {
                                isHot = true;
                            }
                        } else {
                            ((TextView) findViewById(R.id.tv_text2)).setText((value / 2.0f) + "℉");
                            if (value + 59 >= 147) {
                                isHot = true;
                            }
                        }
                        break;
                }
            }
        }
        if (((ImageView) findViewById(R.id.layout_view3)) != null) {
            ((ImageView) findViewById(R.id.layout_view3)).setBackgroundResource(isHot.booleanValue() ? R.drawable.air_maiteng_dzsj_up_r_p : R.drawable.air_maiteng_dzsj_up_r);
        }
        if (((ImageView) findViewById(R.id.layout_view5)) != null) {
            ((ImageView) findViewById(R.id.layout_view5)).setBackgroundResource(isHot.booleanValue() ? R.drawable.air_maiteng_dzsj_body_r_p : R.drawable.air_maiteng_dzsj_body_r);
        }
        if (((ImageView) findViewById(R.id.layout_view7)) != null) {
            ((ImageView) findViewById(R.id.layout_view7)).setBackgroundResource(isHot.booleanValue() ? R.drawable.air_maiteng_dzsj_foot_r_p : R.drawable.air_maiteng_dzsj_foot_r);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempBack(int value) {
        Boolean isHot = false;
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (ConstGolf.isWcGolf()) {
                switch (value) {
                    case 254:
                        ((TextView) findViewById(R.id.tv_text3)).setText("LO");
                        break;
                    case 255:
                        ((TextView) findViewById(R.id.tv_text3)).setText("HI");
                        isHot = true;
                        break;
                    default:
                        if (DataCanbus.DATA[37] == 0) {
                            ((TextView) findViewById(R.id.tv_text3)).setText((value / 2.0f) + "℃");
                            if (value >= 46) {
                                isHot = true;
                            }
                        } else {
                            ((TextView) findViewById(R.id.tv_text3)).setText((value / 2.0f) + "℉");
                            if (value >= 147) {
                                isHot = true;
                            }
                        }
                        break;
                }
            } else {
                switch (value) {
                    case 0:
                        ((TextView) findViewById(R.id.tv_text3)).setText("LO");
                        break;
                    case 31:
                        ((TextView) findViewById(R.id.tv_text3)).setText("HI");
                        isHot = true;
                        break;
                    default:
                        if (DataCanbus.DATA[37] == 0) {
                            int value2 = (value * 5) + 155;
                            ((TextView) findViewById(R.id.tv_text3)).setText((value2 / 10.0f) + "℃");
                            if (value2 >= 230) {
                                isHot = true;
                            }
                        } else {
                            ((TextView) findViewById(R.id.tv_text3)).setText((value / 2.0f) + "℉");
                            if (value + 59 >= 147) {
                                isHot = true;
                            }
                        }
                        break;
                }
            }
        }
        if (((ImageView) findViewById(R.id.layout_view8)) != null) {
            ((ImageView) findViewById(R.id.layout_view8)).setBackgroundResource(isHot.booleanValue() ? R.drawable.air_maiteng_dzsj_rear_body_p : R.drawable.air_maiteng_dzsj_rear_body);
        }
        if (((ImageView) findViewById(R.id.layout_view9)) != null) {
            ((ImageView) findViewById(R.id.layout_view9)).setBackgroundResource(isHot.booleanValue() ? R.drawable.air_maiteng_dzsj_rear_foot_p : R.drawable.air_maiteng_dzsj_rear_foot);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePower(int value) {
        if (((Button) findViewById(R.id.btn_dzsj_power)) != null) {
            ((Button) findViewById(R.id.btn_dzsj_power)).setBackgroundResource(value == 0 ? R.drawable.ic_dzsj_dz_power_p : R.drawable.ic_dzsj_dz_power);
        }
        if (value == 0) {
            setViewVisible((ImageView) findViewById(R.id.layout_view2), false);
            setViewVisible((ImageView) findViewById(R.id.layout_view4), false);
            setViewVisible((ImageView) findViewById(R.id.layout_view6), false);
            setViewVisible((ImageView) findViewById(R.id.layout_view3), false);
            setViewVisible((ImageView) findViewById(R.id.layout_view5), false);
            setViewVisible((ImageView) findViewById(R.id.layout_view7), false);
            setViewVisible((ImageView) findViewById(R.id.layout_view8), false);
            setViewVisible((ImageView) findViewById(R.id.layout_view9), false);
            setViewVisible((ImageView) findViewById(R.id.layout_view9), false);
            setViewVisible(findViewById(R.id.layout_view14), false);
            setViewVisible(findViewById(R.id.layout_view13), false);
            setViewVisible(findViewById(R.id.layout_view15), false);
            setViewVisible(findViewById(R.id.view_dzsj_air_hide), false);
            setViewVisible((Button) findViewById(R.id.btn_dzsj_show), false);
            if (((ProgressBar) findViewById(R.id.pb_wind_progress)) != null) {
                ((ProgressBar) findViewById(R.id.pb_wind_progress)).setProgress(0);
                return;
            }
            return;
        }
        setViewVisible(findViewById(R.id.layout_view14), true);
        setViewVisible(findViewById(R.id.layout_view13), true);
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.layout_view15), true);
        }
        setViewVisible((Button) findViewById(R.id.btn_dzsj_show), true);
        if (((ProgressBar) findViewById(R.id.pb_wind_progress)) != null) {
            ((ProgressBar) findViewById(R.id.pb_wind_progress)).setProgress(DataCanbus.DATA[21]);
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
            ((ImageView) findViewById(R.id.iv_air_wind0)).setImageDrawable(getResources().getDrawable(value == 0 ? 2130840576 : 2130840575));
        }
        if (((ImageView) findViewById(R.id.iv_air_wind1)) != null) {
            ((ImageView) findViewById(R.id.iv_air_wind1)).setImageDrawable(getResources().getDrawable(value == 1 ? 2130840576 : 2130840575));
        }
        if (((ImageView) findViewById(R.id.iv_air_wind2)) != null) {
            ImageView imageView = (ImageView) findViewById(R.id.iv_air_wind2);
            Resources resources = getResources();
            if (value != 2) {
                i = 2130840575;
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
        if (((ImageView) findViewById(R.id.layout_view2)) != null) {
            ((ImageView) findViewById(R.id.layout_view2)).setVisibility((value == 0 || DataCanbus.DATA[10] == 0) ? 8 : 0);
        }
        if (((ImageView) findViewById(R.id.layout_view3)) != null) {
            ((ImageView) findViewById(R.id.layout_view3)).setVisibility((value == 0 || DataCanbus.DATA[10] == 0) ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowBody(int value) {
        if (((Button) findViewById(R.id.btn_air_mode_body)) != null) {
            ((Button) findViewById(R.id.btn_air_mode_body)).setBackgroundResource(value == 0 ? R.drawable.ic_dzsj_dz_body : R.drawable.ic_dzsj_dz_body_p);
        }
        if (((ImageView) findViewById(R.id.layout_view4)) != null) {
            ((ImageView) findViewById(R.id.layout_view4)).setVisibility((value == 0 || DataCanbus.DATA[10] == 0) ? 8 : 0);
        }
        if (((ImageView) findViewById(R.id.layout_view5)) != null) {
            ((ImageView) findViewById(R.id.layout_view5)).setVisibility((value == 0 || DataCanbus.DATA[10] == 0) ? 8 : 0);
        }
        if (((ImageView) findViewById(R.id.layout_view8)) != null) {
            if (ConstGolf.isWcGolf()) {
                ((ImageView) findViewById(R.id.layout_view8)).setVisibility((value == 0 || DataCanbus.DATA[10] == 0) ? 8 : 0);
            } else {
                ((ImageView) findViewById(R.id.layout_view8)).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowFoot(int value) {
        if (((Button) findViewById(R.id.btn_air_mode_foot)) != null) {
            ((Button) findViewById(R.id.btn_air_mode_foot)).setBackgroundResource(value == 0 ? R.drawable.ic_dzsj_dz_foot : R.drawable.ic_dzsj_dz_foot_p);
        }
        if (((ImageView) findViewById(R.id.layout_view6)) != null) {
            ((ImageView) findViewById(R.id.layout_view6)).setVisibility((value == 0 || DataCanbus.DATA[10] == 0) ? 8 : 0);
        }
        if (((ImageView) findViewById(R.id.layout_view7)) != null) {
            ((ImageView) findViewById(R.id.layout_view7)).setVisibility((value == 0 || DataCanbus.DATA[10] == 0) ? 8 : 0);
        }
        if (((ImageView) findViewById(R.id.layout_view9)) != null) {
            if (ConstGolf.isWcGolf()) {
                ((ImageView) findViewById(R.id.layout_view9)).setVisibility((value == 0 || DataCanbus.DATA[10] == 0) ? 8 : 0);
            } else {
                ((ImageView) findViewById(R.id.layout_view9)).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAuto() {
        int LeftList_Num = 3;
        if (DataCanbus.DATA[53] == 1) {
            LeftList_Num = 1;
        }
        if (DataCanbus.DATA[18] == 1 && DataCanbus.DATA[19] == 0 && DataCanbus.DATA[20] == 0) {
            LeftList_Num = 2;
        }
        if (DataCanbus.DATA[13] == 1) {
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
            ((ImageView) findViewById(R.id.iv_air_maxac)).setImageDrawable(getResources().getDrawable(LeftList_Num == 1 ? 2130840576 : 2130840575));
        }
        if (((ImageView) findViewById(R.id.iv_air_front)) != null) {
            ((ImageView) findViewById(R.id.iv_air_front)).setImageDrawable(getResources().getDrawable(LeftList_Num == 2 ? 2130840576 : 2130840575));
        }
        if (((ImageView) findViewById(R.id.iv_air_auto)) != null) {
            ((ImageView) findViewById(R.id.iv_air_auto)).setImageDrawable(getResources().getDrawable(LeftList_Num == 0 ? 2130840576 : 2130840575));
        }
        if (((ImageView) findViewById(R.id.iv_air_manually)) != null) {
            ImageView imageView = (ImageView) findViewById(R.id.iv_air_manually);
            Resources resources = getResources();
            if (LeftList_Num != 3) {
                i = 2130840575;
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
        if (DataCanbus.DATA[10] == 0) {
            value = 0;
        }
        if (((ProgressBar) findViewById(R.id.pb_wind_progress)) != null) {
            ((ProgressBar) findViewById(R.id.pb_wind_progress)).setProgress(value);
        }
    }
}
