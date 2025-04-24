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

@SuppressWarnings({"deprecation", "unchecked"})
public class RuiTengFuncSettings extends BaseActivity {
    public static RuiTengFuncSettings mInstFuncIndexActi;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 99:
                    RuiTengFuncSettings.this.mUpdaterValue30();
                    break;
                case 100:
                    RuiTengFuncSettings.this.mUpdaterValue31();
                    break;
                case 101:
                    RuiTengFuncSettings.this.mUpdaterValue32();
                    break;
                case 102:
                    RuiTengFuncSettings.this.mUpdaterValue1();
                    break;
                case 103:
                    RuiTengFuncSettings.this.mUpdaterValue2();
                    break;
                case 104:
                    RuiTengFuncSettings.this.mUpdaterValue3();
                    break;
                case 105:
                    RuiTengFuncSettings.this.mUpdaterValue33();
                    break;
                case 106:
                    RuiTengFuncSettings.this.mUpdaterValue4();
                    break;
                case 107:
                    RuiTengFuncSettings.this.mUpdaterValue34();
                    break;
                case 108:
                    RuiTengFuncSettings.this.mUpdaterValue35();
                    break;
                case 109:
                    RuiTengFuncSettings.this.mUpdaterValue36();
                    break;
                case 110:
                    RuiTengFuncSettings.this.mUpdaterValue37();
                    break;
                case 111:
                    RuiTengFuncSettings.this.mUpdaterValue38();
                    break;
                case 112:
                    RuiTengFuncSettings.this.mUpdaterValue39();
                    break;
                case 113:
                    RuiTengFuncSettings.this.mUpdaterValue5();
                    break;
                case 114:
                    RuiTengFuncSettings.this.mUpdaterValue6();
                    break;
                case 115:
                    RuiTengFuncSettings.this.mUpdaterValue7();
                    break;
                case 116:
                    RuiTengFuncSettings.this.mUpdaterValue8();
                    break;
                case 117:
                    RuiTengFuncSettings.this.mUpdaterValue9();
                    break;
                case 118:
                    RuiTengFuncSettings.this.mUpdaterValue10();
                    break;
                case 119:
                    RuiTengFuncSettings.this.mUpdaterValue40();
                    break;
                case 120:
                    RuiTengFuncSettings.this.mUpdaterValue41();
                    break;
                case 121:
                    RuiTengFuncSettings.this.mUpdaterValue11();
                    break;
                case 122:
                    RuiTengFuncSettings.this.mUpdaterValue12();
                    break;
                case 128:
                    RuiTengFuncSettings.this.mUpdaterValue13();
                    break;
                case 129:
                    RuiTengFuncSettings.this.mUpdaterValue14();
                    break;
                case 130:
                    RuiTengFuncSettings.this.mUpdaterValue15();
                    break;
                case 131:
                    RuiTengFuncSettings.this.mUpdaterValue16();
                    break;
                case 147:
                    RuiTengFuncSettings.this.mUpdaterValue42();
                    break;
                case 168:
                    RuiTengFuncSettings.this.mSerarchCarIndication();
                    break;
                case 169:
                    RuiTengFuncSettings.this.mComeHomeWithMe();
                    break;
                case 173:
                    RuiTengFuncSettings.this.mSerarchCarView();
                    break;
                case 174:
                    RuiTengFuncSettings.this.mComeHomeWithMeView();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_wc_ruiteng_func_set);
        mInstFuncIndexActi = this;
        registerListener();
    }

    public void registerListener() {
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_auto_lock)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[102];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(10, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_auto_unlock)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[103];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(11, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_unlock_mode)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[104];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(12, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_intelligent_unlock)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[106];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(13, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_with_home_back_light)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[113];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(14, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_with_home_near_light)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[114];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(15, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_with_home_fog_light)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[115];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(16, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_find_car_back_light)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[116];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(17, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_find_car_near_light)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[117];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(18, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_find_car_fog_light)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[118];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(19, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_ruiteng_btn_with_home_time_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[121] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 9) {
                    value = 9;
                }
                DataCanbus.PROXY.cmd(20, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_ruiteng_btn_with_home_time_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[121] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 9) {
                    value = 9;
                }
                DataCanbus.PROXY.cmd(20, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_ruiteng_btn_find_car_time_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[122] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 9) {
                    value = 9;
                }
                DataCanbus.PROXY.cmd(21, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_ruiteng_btn_with_find_car_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[122] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 9) {
                    value = 9;
                }
                DataCanbus.PROXY.cmd(21, new int[]{value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_gohome_with_me)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[169];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(23, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_ruiteng_srarche_car_ind_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[168];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(24, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_ruiteng_srarche_car_ind_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[168];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(24, iArr, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
    }

    
    public void mSerarchCarView() {
        int value = DataCanbus.DATA[173];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_srarche_car_ind_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_srarche_car_ind_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_srarche_car_ind_view)).setVisibility(8);
            }
        }
    }

    
    public void mSerarchCarIndication() {
        int value = DataCanbus.DATA[168];
        if (((TextView) findViewById(R.id.wc_ruiteng_srarche_car_ind_value)) != null) {
            ((TextView) findViewById(R.id.wc_ruiteng_srarche_car_ind_value)).setText(value == 1 ? R.string.klc_remote_Remote_control_latch_light_Speaker : R.string.klc_remote_Remote_control_latch_only_light);
        }
    }

    
    public void mComeHomeWithMeView() {
        int value = DataCanbus.DATA[174];
        if (((RelativeLayout) findViewById(R.id.wc_gohome_with_me_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_gohome_with_me_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_gohome_with_me_view)).setVisibility(8);
            }
        }
    }

    
    public void mComeHomeWithMe() {
        int value = DataCanbus.DATA[169];
        if (((CheckedTextView) findViewById(R.id.wc_gohome_with_me)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_gohome_with_me)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[102];
        if (((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_auto_lock)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_auto_lock)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[103];
        if (((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_auto_unlock)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_auto_unlock)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[104];
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

    
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[106];
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

    
    public void mUpdaterValue5() {
        int value = DataCanbus.DATA[113];
        if (((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_with_home_back_light)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_with_home_back_light)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue6() {
        int value = DataCanbus.DATA[114];
        if (((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_with_home_near_light)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_with_home_near_light)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue7() {
        int value = DataCanbus.DATA[115];
        if (((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_with_home_fog_light)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_with_home_fog_light)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[116];
        if (((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_find_car_back_light)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_find_car_back_light)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue9() {
        int value = DataCanbus.DATA[117];
        if (((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_find_car_near_light)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_find_car_near_light)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue10() {
        int value = DataCanbus.DATA[118];
        if (((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_find_car_fog_light)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_find_car_fog_light)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue11() {
        int value = DataCanbus.DATA[121];
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

    
    public void mUpdaterValue12() {
        int value = DataCanbus.DATA[122];
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

    
    public void mUpdaterValue13() {
        int value = DataCanbus.DATA[128];
        if (((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_left_front_door)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_left_front_door)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue14() {
        int value = DataCanbus.DATA[129];
        if (((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_right_front_door)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_right_front_door)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue15() {
        int value = DataCanbus.DATA[130];
        if (((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_left_rear_door)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_left_rear_door)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue16() {
        int value = DataCanbus.DATA[131];
        if (((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_right_rear_door)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_ruiteng_func_btn_right_rear_door)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue30() {
        int value = DataCanbus.DATA[99];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_auto_lock_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_auto_lock_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_auto_lock_view)).setVisibility(8);
            }
        }
    }

    
    public void mUpdaterValue31() {
        int value = DataCanbus.DATA[100];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_auto_unlock_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_auto_unlock_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_auto_unlock_view)).setVisibility(8);
            }
        }
    }

    
    public void mUpdaterValue32() {
        int value = DataCanbus.DATA[101];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_unlock_mode_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_unlock_mode_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_unlock_mode_view)).setVisibility(8);
            }
        }
    }

    
    public void mUpdaterValue33() {
        int value = DataCanbus.DATA[105];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_intelligent_unlock_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_intelligent_unlock_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_intelligent_unlock_view)).setVisibility(8);
            }
        }
    }

    
    public void mUpdaterValue34() {
        int value = DataCanbus.DATA[107];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_with_home_back_light_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_with_home_back_light_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_with_home_back_light_view)).setVisibility(8);
            }
        }
    }

    
    public void mUpdaterValue35() {
        int value = DataCanbus.DATA[108];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_with_home_near_light_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_with_home_near_light_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_with_home_near_light_view)).setVisibility(8);
            }
        }
    }

    
    public void mUpdaterValue36() {
        int value = DataCanbus.DATA[109];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_with_home_fog_light_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_with_home_fog_light_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_with_home_fog_light_view)).setVisibility(8);
            }
        }
    }

    
    public void mUpdaterValue37() {
        int value = DataCanbus.DATA[110];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_find_car_back_light_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_find_car_back_light_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_find_car_back_light_view)).setVisibility(8);
            }
        }
    }

    
    public void mUpdaterValue38() {
        int value = DataCanbus.DATA[111];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_find_car_near_light_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_find_car_near_light_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_find_car_near_light_view)).setVisibility(8);
            }
        }
    }

    
    public void mUpdaterValue39() {
        int value = DataCanbus.DATA[112];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_find_car_fog_light_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_find_car_fog_light_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_func_btn_find_car_fog_light_view)).setVisibility(8);
            }
        }
    }

    
    public void mUpdaterValue40() {
        int value = DataCanbus.DATA[119];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_btn_with_home_time_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_btn_with_home_time_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_btn_with_home_time_view)).setVisibility(8);
            }
        }
    }

    
    public void mUpdaterValue41() {
        int value = DataCanbus.DATA[120];
        if (((RelativeLayout) findViewById(R.id.wc_ruiteng_btn_find_car_time_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_btn_find_car_time_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.wc_ruiteng_btn_find_car_time_view)).setVisibility(8);
            }
        }
    }

    
    public void mUpdaterValue42() {
        int value = DataCanbus.DATA[147];
        if (((LinearLayout) findViewById(R.id.wc_ruiteng_func_btn_door_view)) != null) {
            if (value == 1) {
                ((LinearLayout) findViewById(R.id.wc_ruiteng_func_btn_door_view)).setVisibility(0);
            } else {
                ((LinearLayout) findViewById(R.id.wc_ruiteng_func_btn_door_view)).setVisibility(8);
            }
        }
    }
}
