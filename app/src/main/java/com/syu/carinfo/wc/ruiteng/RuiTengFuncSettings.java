package com.syu.carinfo.wc.ruiteng;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RuiTengFuncSettings extends BaseActivity {
    public static RuiTengFuncSettings mInstFuncIndexActi;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengFuncSettings.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 26:
                    RuiTengFuncSettings.this.mUpdaterValue30();
                    break;
                case 27:
                    RuiTengFuncSettings.this.mUpdaterValue31();
                    break;
                case 28:
                    RuiTengFuncSettings.this.mUpdaterValue32();
                    break;
                case 29:
                    RuiTengFuncSettings.this.mUpdaterValue1();
                    break;
                case 30:
                    RuiTengFuncSettings.this.mUpdaterValue2();
                    break;
                case 31:
                    RuiTengFuncSettings.this.mUpdaterValue3();
                    break;
                case 32:
                    RuiTengFuncSettings.this.mUpdaterValue33();
                    break;
                case 33:
                    RuiTengFuncSettings.this.mUpdaterValue4();
                    break;
                case 34:
                    RuiTengFuncSettings.this.mUpdaterValue34();
                    break;
                case 35:
                    RuiTengFuncSettings.this.mUpdaterValue35();
                    break;
                case 36:
                    RuiTengFuncSettings.this.mUpdaterValue36();
                    break;
                case 37:
                    RuiTengFuncSettings.this.mUpdaterValue37();
                    break;
                case 38:
                    RuiTengFuncSettings.this.mUpdaterValue38();
                    break;
                case 39:
                    RuiTengFuncSettings.this.mUpdaterValue39();
                    break;
                case 40:
                    RuiTengFuncSettings.this.mUpdaterValue5();
                    break;
                case 41:
                    RuiTengFuncSettings.this.mUpdaterValue6();
                    break;
                case 42:
                    RuiTengFuncSettings.this.mUpdaterValue7();
                    break;
                case 43:
                    RuiTengFuncSettings.this.mUpdaterValue8();
                    break;
                case 44:
                    RuiTengFuncSettings.this.mUpdaterValue9();
                    break;
                case 45:
                    RuiTengFuncSettings.this.mUpdaterValue10();
                    break;
                case 46:
                    RuiTengFuncSettings.this.mUpdaterValue40();
                    break;
                case 47:
                    RuiTengFuncSettings.this.mUpdaterValue41();
                    break;
                case 48:
                    RuiTengFuncSettings.this.mUpdaterValue11();
                    break;
                case 49:
                    RuiTengFuncSettings.this.mUpdaterValue12();
                    break;
                case 55:
                    RuiTengFuncSettings.this.mUpdaterValue13();
                    break;
                case 56:
                    RuiTengFuncSettings.this.mUpdaterValue14();
                    break;
                case 57:
                    RuiTengFuncSettings.this.mUpdaterValue15();
                    break;
                case 58:
                    RuiTengFuncSettings.this.mUpdaterValue16();
                    break;
                case 74:
                    RuiTengFuncSettings.this.mUpdaterValue42();
                    break;
                case 95:
                    RuiTengFuncSettings.this.mSerarchCarIndication();
                    break;
                case 96:
                    RuiTengFuncSettings.this.mComeHomeWithMe();
                    break;
                case 101:
                    RuiTengFuncSettings.this.mSerarchCarView();
                    break;
                case 102:
                    RuiTengFuncSettings.this.mComeHomeWithMeView();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_ruiteng_func_set);
        mInstFuncIndexActi = this;
        registerListener();
    }

    public void registerListener() {
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_auto_lock)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengFuncSettings.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[29];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(10, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_auto_unlock)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengFuncSettings.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[30];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(11, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_unlock_mode)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengFuncSettings.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[31];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(12, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_intelligent_unlock)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengFuncSettings.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[33];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(13, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_with_home_back_light)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengFuncSettings.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[40];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(14, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_with_home_near_light)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengFuncSettings.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[41];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(15, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_with_home_fog_light)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengFuncSettings.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[42];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(16, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_find_car_back_light)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengFuncSettings.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[43];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(17, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_find_car_near_light)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengFuncSettings.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[44];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(18, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_find_car_fog_light)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengFuncSettings.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[45];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(19, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_ruiteng_btn_with_home_time_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengFuncSettings.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[48] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 9) {
                    value = 9;
                }
                DataCanbus.PROXY.cmd(20, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_ruiteng_btn_with_home_time_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengFuncSettings.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[48] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 9) {
                    value = 9;
                }
                DataCanbus.PROXY.cmd(20, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_ruiteng_btn_find_car_time_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengFuncSettings.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[49] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 9) {
                    value = 9;
                }
                DataCanbus.PROXY.cmd(21, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_ruiteng_btn_with_find_car_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengFuncSettings.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[49] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 9) {
                    value = 9;
                }
                DataCanbus.PROXY.cmd(21, new int[]{value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_gohome_with_me)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengFuncSettings.16
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[96];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(23, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_ruiteng_srarche_car_ind_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengFuncSettings.17
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[95];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(24, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_ruiteng_srarche_car_ind_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengFuncSettings.18
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[95];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(24, iArr, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSerarchCarView() {
        int value = DataCanbus.DATA[101];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_srarche_car_ind_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_srarche_car_ind_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_srarche_car_ind_view)).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSerarchCarIndication() {
        int value = DataCanbus.DATA[95];
        if (((TextView) findViewById(R.id.wc_ruiteng_srarche_car_ind_value)) != null) {
            ((TextView) findViewById(R.id.wc_ruiteng_srarche_car_ind_value)).setText(value == 1 ? R.string.klc_remote_Remote_control_latch_light_Speaker : R.string.klc_remote_Remote_control_latch_only_light);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mComeHomeWithMeView() {
        int value = DataCanbus.DATA[102];
        if (((RelativeLayout) findViewById(R.id.wc_gohome_with_me_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_gohome_with_me_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_gohome_with_me_view)).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mComeHomeWithMe() {
        int value = DataCanbus.DATA[96];
        if (((CheckedTextView) findViewById(R.id.wc_gohome_with_me)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_gohome_with_me)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[29];
        if (((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_auto_lock)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_auto_lock)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[30];
        if (((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_auto_unlock)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_auto_unlock)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[31];
        if (((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_unlock_mode)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_unlock_mode)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_unlock_mode_tv)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_unlock_mode_tv)).setText(getResources().getString(R.string.wc_ruiteng_string_unlock_mode_1));
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_unlock_mode_tv)).setText(getResources().getString(R.string.wc_ruiteng_string_unlock_mode_0));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[33];
        if (((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_intelligent_unlock)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_intelligent_unlock)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_intelligent_unlock_tv)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_intelligent_unlock_tv)).setText(getResources().getString(R.string.wc_ruiteng_string_intelligent_unlocke_1));
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_intelligent_unlock_tv)).setText(getResources().getString(R.string.wc_ruiteng_string_intelligent_unlocke_0));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue5() {
        int value = DataCanbus.DATA[40];
        if (((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_with_home_back_light)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_with_home_back_light)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue6() {
        int value = DataCanbus.DATA[41];
        if (((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_with_home_near_light)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_with_home_near_light)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue7() {
        int value = DataCanbus.DATA[42];
        if (((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_with_home_fog_light)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_with_home_fog_light)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[43];
        if (((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_find_car_back_light)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_find_car_back_light)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue9() {
        int value = DataCanbus.DATA[44];
        if (((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_find_car_near_light)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_find_car_near_light)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue10() {
        int value = DataCanbus.DATA[45];
        if (((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_find_car_fog_light)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_find_car_fog_light)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue11() {
        int value = DataCanbus.DATA[48];
        if (((TextView) findViewById(R.id.wc_ruiteng_tv_with_home_time)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_with_home_time)).setText(getResources().getString(R.string.wc_ruiteng_string_time_0));
                    break;
                case 1:
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_with_home_time)).setText(getResources().getString(R.string.wc_ruiteng_string_time_1));
                    break;
                case 2:
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_with_home_time)).setText(getResources().getString(R.string.wc_ruiteng_string_time_2));
                    break;
                case 3:
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_with_home_time)).setText(getResources().getString(R.string.wc_ruiteng_string_time_3));
                    break;
                case 4:
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_with_home_time)).setText(getResources().getString(R.string.wc_ruiteng_string_time_4));
                    break;
                case 5:
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_with_home_time)).setText(getResources().getString(R.string.wc_ruiteng_string_time_5));
                    break;
                case 6:
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_with_home_time)).setText(getResources().getString(R.string.wc_ruiteng_string_time_6));
                    break;
                case 7:
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_with_home_time)).setText(getResources().getString(R.string.wc_ruiteng_string_time_7));
                    break;
                case 8:
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_with_home_time)).setText(getResources().getString(R.string.wc_ruiteng_string_time_8));
                    break;
                case 9:
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_with_home_time)).setText(getResources().getString(R.string.wc_ruiteng_string_time_9));
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue12() {
        int value = DataCanbus.DATA[49];
        if (((TextView) findViewById(R.id.wc_ruiteng_tv_find_car_time)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_find_car_time)).setText(getResources().getString(R.string.wc_ruiteng_string_time_0));
                    break;
                case 1:
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_find_car_time)).setText(getResources().getString(R.string.wc_ruiteng_string_time_1));
                    break;
                case 2:
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_find_car_time)).setText(getResources().getString(R.string.wc_ruiteng_string_time_2));
                    break;
                case 3:
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_find_car_time)).setText(getResources().getString(R.string.wc_ruiteng_string_time_3));
                    break;
                case 4:
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_find_car_time)).setText(getResources().getString(R.string.wc_ruiteng_string_time_4));
                    break;
                case 5:
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_find_car_time)).setText(getResources().getString(R.string.wc_ruiteng_string_time_5));
                    break;
                case 6:
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_find_car_time)).setText(getResources().getString(R.string.wc_ruiteng_string_time_6));
                    break;
                case 7:
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_find_car_time)).setText(getResources().getString(R.string.wc_ruiteng_string_time_7));
                    break;
                case 8:
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_find_car_time)).setText(getResources().getString(R.string.wc_ruiteng_string_time_8));
                    break;
                case 9:
                    ((TextView) findViewById(R.id.wc_ruiteng_tv_find_car_time)).setText(getResources().getString(R.string.wc_ruiteng_string_time_9));
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue13() {
        int value = DataCanbus.DATA[55];
        if (((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_left_front_door)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_left_front_door)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue14() {
        int value = DataCanbus.DATA[56];
        if (((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_right_front_door)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_right_front_door)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue15() {
        int value = DataCanbus.DATA[57];
        if (((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_left_rear_door)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_left_rear_door)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue16() {
        int value = DataCanbus.DATA[58];
        if (((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_right_rear_door)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_right_rear_door)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue30() {
        int value = DataCanbus.DATA[26];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_auto_lock_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_auto_lock_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_auto_lock_view)).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue31() {
        int value = DataCanbus.DATA[27];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_auto_unlock_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_auto_unlock_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_auto_unlock_view)).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue32() {
        int value = DataCanbus.DATA[28];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_unlock_mode_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_unlock_mode_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_unlock_mode_view)).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue33() {
        int value = DataCanbus.DATA[32];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_intelligent_unlock_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_intelligent_unlock_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_intelligent_unlock_view)).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue34() {
        int value = DataCanbus.DATA[34];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_with_home_back_light_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_with_home_back_light_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_with_home_back_light_view)).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue35() {
        int value = DataCanbus.DATA[35];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_with_home_near_light_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_with_home_near_light_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_with_home_near_light_view)).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue36() {
        int value = DataCanbus.DATA[36];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_with_home_fog_light_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_with_home_fog_light_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_with_home_fog_light_view)).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue37() {
        int value = DataCanbus.DATA[37];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_find_car_back_light_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_find_car_back_light_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_find_car_back_light_view)).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue38() {
        int value = DataCanbus.DATA[38];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_find_car_near_light_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_find_car_near_light_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_find_car_near_light_view)).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue39() {
        int value = DataCanbus.DATA[39];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_find_car_fog_light_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_find_car_fog_light_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_find_car_fog_light_view)).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue40() {
        int value = DataCanbus.DATA[46];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_btn_with_home_time_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_btn_with_home_time_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_btn_with_home_time_view)).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue41() {
        int value = DataCanbus.DATA[47];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_btn_find_car_time_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_btn_find_car_time_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_btn_find_car_time_view)).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue42() {
        int value = DataCanbus.DATA[74];
        if (((LinearLayout) findViewById(R.id.wc_ruiteng_func_btn_door_view)) != null) {
            if (value == 1) {
                ((LinearLayout) findViewById(R.id.wc_ruiteng_func_btn_door_view)).setVisibility(0);
            } else {
                ((LinearLayout) findViewById(R.id.wc_ruiteng_func_btn_door_view)).setVisibility(8);
            }
        }
    }
}
