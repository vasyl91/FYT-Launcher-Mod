package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7FunctionalAirConditionerActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    Golf7FunctionalAirConditionerActi.this.mUpdaterAirConditionerSwitch();
                    break;
                case 55:
                    Golf7FunctionalAirConditionerActi.this.mUpdaterSteerSeatHot(DataCanbus.DATA[updateCode]);
                    break;
                case 72:
                    Golf7FunctionalAirConditionerActi.this.setCheck((CheckedTextView) Golf7FunctionalAirConditionerActi.this.findViewById(R.id.ctv_checkedtext1), DataCanbus.DATA[updateCode] != 0);
                    break;
                case 76:
                    Golf7FunctionalAirConditionerActi.this.uClearAir(DataCanbus.DATA[updateCode]);
                    break;
                case 210:
                    Golf7FunctionalAirConditionerActi.this.mUpdaterAirAuoWind();
                    break;
                case 211:
                    Golf7FunctionalAirConditionerActi.this.mUpdaterAirFrontfrog();
                    break;
                case 212:
                    Golf7FunctionalAirConditionerActi.this.mUpdaterAirAutoCycle();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            //setContentView(R.layout.layout_golf7_functional_state_air_conditioner_od);
        } else {
            //setContentView(R.layout.layout_golf7_functional_state_air_conditioner);
        }
        init();
    }

    @Override
    public void init() {
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            ((Button) findViewById(R.id.glf7_btn_car_back_od)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    try {
                        Golf7FunctionalAirConditionerActi.this.onKeyDown(4, null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        setSelfClick((CheckedTextView) findViewById(R.id.tuguan_streer_seat_hot_check), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[55] & 255;
                if (value != 0) {
                    DataCanbus.PROXY.cmd(136, new int[1], null, null);
                } else {
                    DataCanbus.PROXY.cmd(136, new int[]{1}, null, null);
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_air_conditioner_switch), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[10] & 255;
                if (value != 0) {
                    DataCanbus.PROXY.cmd(38, new int[1], null, null);
                } else {
                    DataCanbus.PROXY.cmd(38, new int[]{1}, null, null);
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_air_auto_frog), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[211] & 255;
                if (value != 0) {
                    DataCanbus.PROXY.cmd(107, new int[]{10}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(107, new int[]{10, 1}, null, null);
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_air_auto_cycle), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[212] & 255;
                if (DataCanbus.DATA[1000] == 437) {
                    DataCanbus.PROXY.cmd(107, new int[]{49, 1}, null, null);
                    HandlerUI.getInstance().postDelayed(new Runnable() { 
                        @Override
                        public void run() {
                            DataCanbus.PROXY.cmd(107, new int[]{49}, null, null);
                        }
                    }, 100L);
                    return;
                }
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 14;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_air_auto_sete_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn;
                int switchOn2 = DataCanbus.DATA[210] & 255;
                if (switchOn2 > 0) {
                    switchOn = switchOn2 - 1;
                } else {
                    switchOn = 3;
                }
                DataCanbus.PROXY.cmd(107, new int[]{1, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_air_auto_sete_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn;
                int switchOn2 = DataCanbus.DATA[210] & 255;
                if (switchOn2 < 3) {
                    switchOn = switchOn2 + 1;
                } else {
                    switchOn = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{1, switchOn}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_view_functional_air_preset_mode_auto), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(107, new int[]{129}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_view_functional_air_preset_mode_acmax), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(107, new int[]{129, 1}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_view_functional_air_preset_mode_maxfront), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(107, new int[]{129, 2}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_view_functional_air_preset_mode_manual), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(107, new int[]{129, 3}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_view_functional_air_clear_air), new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(107, new int[]{80, 1}, null, null);
                HandlerUI.getInstance().postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(107, new int[]{80}, null, null);
                    }
                }, 100L);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[72] & 255;
                if (value != 0) {
                    DataCanbus.PROXY.cmd(107, new int[]{43}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(107, new int[]{43, 1}, null, null);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            setViewVisible(findViewById(R.id.tuguan_streer_seat_hot_view), true);
        } else {
            setViewVisible(findViewById(R.id.tuguan_streer_seat_hot_view), false);
        }
        if (DataCanbus.DATA[1000] == 589841 || DataCanbus.DATA[1000] == 655377 || DataCanbus.DATA[1000] == 720913 || DataCanbus.DATA[1000] == 786449 || DataCanbus.DATA[1000] == 851985 || DataCanbus.DATA[1000] == 917521 || DataCanbus.DATA[1000] == 983057 || DataCanbus.DATA[1000] == 1048593 || DataCanbus.DATA[1000] == 1114129 || DataCanbus.DATA[1000] == 1179665 || DataCanbus.DATA[1000] == 1245201 || DataCanbus.DATA[1000] == 1310737 || DataCanbus.DATA[1000] == 1376273 || DataCanbus.DATA[1000] == 1441809 || DataCanbus.DATA[1000] == 1507345 || DataCanbus.DATA[1000] == 1572881 || DataCanbus.DATA[1000] == 1638417 || DataCanbus.DATA[1000] == 1703953 || DataCanbus.DATA[1000] == 1769489 || DataCanbus.DATA[1000] == 1835025 || DataCanbus.DATA[1000] == 1900561 || DataCanbus.DATA[1000] == 1966097 || DataCanbus.DATA[1000] == 2031633 || DataCanbus.DATA[1000] == 2097169 || DataCanbus.DATA[1000] == 2162705 || DataCanbus.DATA[1000] == 2228241 || DataCanbus.DATA[1000] == 2293777 || DataCanbus.DATA[1000] == 2359313 || DataCanbus.DATA[1000] == 2424849 || DataCanbus.DATA[1000] == 2490385 || DataCanbus.DATA[1000] == 2555921 || DataCanbus.DATA[1000] == 2621457 || DataCanbus.DATA[1000] == 2686993 || DataCanbus.DATA[1000] == 2752529 || DataCanbus.DATA[1000] == 2818065) {
            setViewVisible(findViewById(R.id.glf7_view_functional_air_preset_mode_auto_view), true);
            setViewVisible(findViewById(R.id.glf7_view_functional_air_preset_mode_acmax_view), true);
            setViewVisible(findViewById(R.id.glf7_view_functional_air_preset_mode_maxfront_view), true);
            setViewVisible(findViewById(R.id.glf7_view_functional_air_preset_mode_manual_view), true);
            setViewVisible(findViewById(R.id.layout_view1), false);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_air_preset_mode_auto_view), false);
            setViewVisible(findViewById(R.id.glf7_view_functional_air_preset_mode_acmax_view), false);
            setViewVisible(findViewById(R.id.glf7_view_functional_air_preset_mode_maxfront_view), false);
            setViewVisible(findViewById(R.id.glf7_view_functional_air_preset_mode_manual_view), false);
            setViewVisible(findViewById(R.id.layout_view1), true);
        }
        addNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[210].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[211].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[212].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[210].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[211].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[212].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterSteerSeatHot(int value) {
        setCheck((CheckedTextView) findViewById(R.id.tuguan_streer_seat_hot_check), value != 0);
    }

    
    public void mUpdaterAirConditionerSwitch() {
        int value = DataCanbus.DATA[10];
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_air_conditioner_switch), value != 0);
        if (DataCanbus.DATA[1000] == 437 || ConstGolf.isWcGolf() || DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256) {
            setViewVisible(findViewById(R.id.glf7_btn_functional_air_conditioner_switch_view), false);
        }
    }

    
    public void mUpdaterAirAuoWind() {
        int value = DataCanbus.DATA[210];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_air_auto_set), enable != 0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_air_auto_set)).setText(R.string.klc_air_low);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.glf7_tv_functional_air_auto_set)).setText(R.string.klc_air_middle);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.glf7_tv_functional_air_auto_set)).setText(R.string.klc_air_high);
            }
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_air_auto_set), false);
        }
        if (DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            setViewVisible(findViewById(R.id.glf7_view_functional_air_auto_set), false);
        }
    }

    
    public void mUpdaterAirFrontfrog() {
        int value = DataCanbus.DATA[211];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_air_auto_frog), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_air_auto_frog), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_air_auto_frog), false);
    }

    
    public void mUpdaterAirAutoCycle() {
        int value = DataCanbus.DATA[212];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_air_auto_cycle), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_air_auto_cycle), switchOn != 0);
        } else if (ConstGolf.isRZCGolf() || DataCanbus.DATA[1000] == 437) {
            setViewVisible(findViewById(R.id.glf7_view_functional_air_auto_cycle), true);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_air_auto_cycle), switchOn != 0);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_air_auto_cycle), false);
        }
    }

    protected void uClearAir(int i) {
        if (DataCanbus.DATA[1000] == 437) {
            setViewVisible(findViewById(R.id.glf7_view_functional_air_clear_air_view), true);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_air_clear_air_view), false);
        }
        setCheck((CheckedTextView) findViewById(R.id.glf7_view_functional_air_clear_air), i != 0);
    }
}
