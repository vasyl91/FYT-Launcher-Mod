package com.syu.carinfo.mengdiou;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class MDOAirControlActi extends BaseActivity {
    public static MDOAirControlActi mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.mengdiou.MDOAirControlActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 1:
                    MDOAirControlActi.this.mUpdataAirAuto();
                    break;
                case 2:
                    MDOAirControlActi.this.mUpdataRecycle();
                    break;
                case 3:
                    MDOAirControlActi.this.mUpdataFrontDeforst();
                    break;
                case 4:
                    MDOAirControlActi.this.mUpdataRearDeforst();
                    break;
                case 5:
                    MDOAirControlActi.this.mUpdataAc();
                    break;
                case 6:
                    MDOAirControlActi.this.mUpataTempLeft();
                    break;
                case 7:
                    MDOAirControlActi.this.mUpdataWinBody();
                    break;
                case 8:
                    MDOAirControlActi.this.mUpdataFoot();
                    break;
                case 9:
                    MDOAirControlActi.this.mUpdataWinUp();
                    break;
                case 10:
                    MDOAirControlActi.this.mUpdataAcMax();
                    break;
                case 11:
                    MDOAirControlActi.this.mUpdataWindLevel();
                    break;
                case 12:
                    MDOAirControlActi.this.mUpdataDual();
                    break;
                case 13:
                    MDOAirControlActi.this.mUpataTempRight();
                    break;
                case 14:
                    MDOAirControlActi.this.mUpdaterPower();
                    break;
                case 26:
                    MDOAirControlActi.this.mUpdateSeatRight();
                    break;
                case 27:
                    MDOAirControlActi.this.mUpdateSeatLeft();
                    break;
                case 35:
                    int value = DataCanbus.DATA[35];
                    if (((Button) MDOAirControlActi.this.findViewById(R.id.air_xts_steer_hot)) != null) {
                        ((Button) MDOAirControlActi.this.findViewById(R.id.air_xts_steer_hot)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_steer_hot_n : R.drawable.ic_xts_steer_hot_p);
                        break;
                    }
                case 36:
                    int value2 = DataCanbus.DATA[36];
                    if (((Button) MDOAirControlActi.this.findViewById(R.id.air_xts_seatwin_right)) != null) {
                        switch (value2) {
                            case 0:
                                ((Button) MDOAirControlActi.this.findViewById(R.id.air_xts_seatwin_right)).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level0);
                                break;
                            case 1:
                                ((Button) MDOAirControlActi.this.findViewById(R.id.air_xts_seatwin_right)).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level1);
                                break;
                            case 2:
                                ((Button) MDOAirControlActi.this.findViewById(R.id.air_xts_seatwin_right)).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level2);
                                break;
                            case 3:
                                ((Button) MDOAirControlActi.this.findViewById(R.id.air_xts_seatwin_right)).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level3);
                                break;
                        }
                    }
                    break;
                case 37:
                    int value3 = DataCanbus.DATA[37];
                    if (((Button) MDOAirControlActi.this.findViewById(R.id.air_xts_seatwin_left)) != null) {
                        switch (value3) {
                            case 0:
                                ((Button) MDOAirControlActi.this.findViewById(R.id.air_xts_seatwin_left)).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level0);
                                break;
                            case 1:
                                ((Button) MDOAirControlActi.this.findViewById(R.id.air_xts_seatwin_left)).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level1);
                                break;
                            case 2:
                                ((Button) MDOAirControlActi.this.findViewById(R.id.air_xts_seatwin_left)).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level2);
                                break;
                            case 3:
                                ((Button) MDOAirControlActi.this.findViewById(R.id.air_xts_seatwin_left)).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level3);
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WC2_MengDiOuZS2018 /* 458773 */:
            case FinalCanbus.CAR_WC2_MengDiOuZS2021 /* 524309 */:
                setContentView(R.layout.layout_021_wc_18mengdo_air);
                break;
            default:
                setContentView(R.layout.layout_021_wc_mengdo_air);
                break;
        }
        initView();
        mInstance = this;
    }

    private void initView() {
        if (findViewById(R.id.air_xts_steer_hot) != null) {
            ((Button) findViewById(R.id.air_xts_steer_hot)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.mengdiou.MDOAirControlActi.2
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    DataCanbus.PROXY.cmd(0, new int[]{45}, null, null);
                }
            });
        }
        if (findViewById(R.id.air_xts_seatwin_left) != null) {
            ((Button) findViewById(R.id.air_xts_seatwin_left)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.mengdiou.MDOAirControlActi.3
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    DataCanbus.PROXY.cmd(0, new int[]{23}, null, null);
                }
            });
        }
        if (findViewById(R.id.air_xts_seatwin_right) != null) {
            ((Button) findViewById(R.id.air_xts_seatwin_right)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.mengdiou.MDOAirControlActi.4
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    DataCanbus.PROXY.cmd(0, new int[]{24}, null, null);
                }
            });
        }
        ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.mengdiou.MDOAirControlActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(0, new int[]{12}, null, null);
            }
        });
        ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.mengdiou.MDOAirControlActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(0, new int[]{11}, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_cycle)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.mengdiou.MDOAirControlActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[2];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value == 0 ? 0 : 1;
                remoteModuleProxy.cmd(7, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_power)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.mengdiou.MDOAirControlActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[14];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_auto)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.mengdiou.MDOAirControlActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int value = DataCanbus.DATA[1];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(4, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_ac)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.mengdiou.MDOAirControlActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[5];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_maxac)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.mengdiou.MDOAirControlActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(0, new int[]{26}, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_dual)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.mengdiou.MDOAirControlActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(0, new int[]{3}, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_front)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.mengdiou.MDOAirControlActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[3];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(5, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_rear)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.mengdiou.MDOAirControlActi.14
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[4];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(6, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_air_temp_left_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.mengdiou.MDOAirControlActi.15
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(0, new int[]{13}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_air_temp_left_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.mengdiou.MDOAirControlActi.16
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(0, new int[]{14}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_air_temp_right_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.mengdiou.MDOAirControlActi.17
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(0, new int[]{15}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_air_temp_right_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.mengdiou.MDOAirControlActi.18
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(0, new int[]{16}, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_mode_win)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.mengdiou.MDOAirControlActi.19
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[9];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(8, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_mode_foot)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.mengdiou.MDOAirControlActi.20
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[8];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(10, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_mode_body)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.mengdiou.MDOAirControlActi.21
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[7];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(9, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_seathot_left)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.mengdiou.MDOAirControlActi.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{17}, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_seathot_right)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.mengdiou.MDOAirControlActi.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{18}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
        AirHelper.disableAirWindowLocal(true);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSeatLeft() {
        int value = DataCanbus.DATA[27];
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
    public void mUpdateSeatRight() {
        int value = DataCanbus.DATA[26];
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
    public void mUpdataAirAuto() {
        int value = DataCanbus.DATA[1];
        if (((Button) findViewById(R.id.air_xts_auto)) != null) {
            ((Button) findViewById(R.id.air_xts_auto)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterPower() {
        int value = DataCanbus.DATA[14];
        if (((Button) findViewById(R.id.air_xts_power)) != null) {
            ((Button) findViewById(R.id.air_xts_power)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdataWindLevel() {
        int value = DataCanbus.DATA[11];
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdataDual() {
        int value = DataCanbus.DATA[12];
        if (((Button) findViewById(R.id.air_xts_dual)) != null) {
            ((Button) findViewById(R.id.air_xts_dual)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_dual_n : R.drawable.ic_xts_dual_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdataAcMax() {
        int value = DataCanbus.DATA[10];
        if (((Button) findViewById(R.id.air_xts_maxac)) != null) {
            ((Button) findViewById(R.id.air_xts_maxac)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_maxac_n : R.drawable.ic_xts_maxac_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdataAc() {
        int value = DataCanbus.DATA[5];
        if (((Button) findViewById(R.id.air_xts_ac)) != null) {
            ((Button) findViewById(R.id.air_xts_ac)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdataFrontDeforst() {
        int value = DataCanbus.DATA[3];
        if (((Button) findViewById(R.id.air_xts_front)) != null) {
            ((Button) findViewById(R.id.air_xts_front)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdataRearDeforst() {
        int value = DataCanbus.DATA[4];
        if (((Button) findViewById(R.id.air_xts_rear)) != null) {
            ((Button) findViewById(R.id.air_xts_rear)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdataFoot() {
        int value = DataCanbus.DATA[8];
        if (((Button) findViewById(R.id.air_xts_mode_foot)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_foot)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdataWinBody() {
        int value = DataCanbus.DATA[7];
        if (((Button) findViewById(R.id.air_xts_mode_body)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_body)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdataWinUp() {
        int value = DataCanbus.DATA[9];
        if (((Button) findViewById(R.id.air_xts_mode_win)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_win)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_win_n : R.drawable.ic_xts_mode_win_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpataTempLeft() {
        int temp = DataCanbus.DATA[6];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("NO");
                return;
            }
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                return;
            }
            if (DataCanbus.DATA[1000] == 21) {
                if (0 != 0) {
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText(temp + "℉");
                    return;
                } else {
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 2.0d) + "℃");
                    return;
                }
            }
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 2.0d) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdataRecycle() {
        int value = DataCanbus.DATA[2];
        if (((Button) findViewById(R.id.air_xts_cycle)) != null) {
            ((Button) findViewById(R.id.air_xts_cycle)).setBackgroundResource(value == 1 ? R.drawable.ic_xts_cycle_p : R.drawable.ic_xts_cycle_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpataTempRight() {
        int temp = DataCanbus.DATA[13];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("NO");
                return;
            }
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                return;
            }
            if (DataCanbus.DATA[1000] == 21) {
                if (0 != 0) {
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText(temp + "℉");
                    return;
                } else {
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 2.0d) + "℃");
                    return;
                }
            }
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 2.0d) + "℃");
        }
    }
}
