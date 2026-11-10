package com.syu.carinfo.camry.zh;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class CamrySettingsAct_ZH extends BaseActivity {
    public static CamrySettingsAct_ZH mInit;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 117:
                    CamrySettingsAct_ZH.this.mUpdaterHeadLampsOnSensitivity();
                    break;
                case 118:
                    CamrySettingsAct_ZH.this.mUpdaterInteriorLightOffTime();
                    break;
                case 123:
                    CamrySettingsAct_ZH.this.mUpdaterRemote2PressUnlock();
                    break;
                case 127:
                    CamrySettingsAct_ZH.this.mUpdaterKeySystemWithElecKey();
                    break;
                case 128:
                    CamrySettingsAct_ZH.this.mUpdaterSmartLockAndOneKeyBoot();
                    break;
                case 129:
                    CamrySettingsAct_ZH.this.mUpdaterLockUnLockFeedbackByLights();
                    break;
                case 131:
                    CamrySettingsAct_ZH.this.mUpdaterAirByAutoKey();
                    break;
                case 132:
                    CamrySettingsAct_ZH.this.mUpdaterInOutAirByAutoKey();
                    break;
                case 188:
                    if (((CheckedTextView) CamrySettingsAct_ZH.this.findViewById(R.id.ctv_checkedtext2)) != null) {
                        ((CheckedTextView) CamrySettingsAct_ZH.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 8);
                    }
                    if (value == 8) {
                        ((TextView) CamrySettingsAct_ZH.this.findViewById(R.id.tv_text6)).setText(R.string.rzc_c4l_open);
                        break;
                    } else {
                        ((TextView) CamrySettingsAct_ZH.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                        break;
                    }
                case 198:
                    if (((TextView) CamrySettingsAct_ZH.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) CamrySettingsAct_ZH.this.findViewById(R.id.tv_text7)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                                break;
                            default:
                                ((TextView) CamrySettingsAct_ZH.this.findViewById(R.id.tv_text7)).setText("Km/L");
                                break;
                        }
                    }
                    break;
            }
        }
    };
    String[] mStrInteriorLightOffTime = {"OFF", "7.5s", "15s", "30s"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_camry_settings_zh);
        init();
    }

    @Override
    public void init() {
        mInit = this;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[123];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(4, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[127];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(14, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(14, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[128];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(15, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(15, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[129];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(16, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(16, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[131];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(17, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(17, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[132];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(18, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(18, new int[1], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[117];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[117];
                if (value < 4) {
                    DataCanbus.PROXY.cmd(0, new int[]{value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[118];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(11, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[118];
                if (value < 3) {
                    DataCanbus.PROXY.cmd(11, new int[]{value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[198] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(40, new int[]{25, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[198] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{25, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[188];
                if (value == 8) {
                    DataCanbus.PROXY.cmd(24, new int[]{3, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(24, new int[]{3, 8}, null, null);
                }
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterRemote2PressUnlock() {
        int value = DataCanbus.DATA[123];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.rzc_c4l_open);
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.off);
        }
    }

    
    public void mUpdaterKeySystemWithElecKey() {
        int value = DataCanbus.DATA[127];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            ((TextView) findViewById(R.id.tv_text8)).setText(value != 0 ? R.string.lock_set_unlock_intelligent_door_driver : R.string.lock_set_unlock_intelligent_door_all);
        }
    }

    
    public void mUpdaterSmartLockAndOneKeyBoot() {
        int value = DataCanbus.DATA[128];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.rzc_c4l_open);
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.off);
        }
    }

    
    public void mUpdaterLockUnLockFeedbackByLights() {
        int value = DataCanbus.DATA[129];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.rzc_c4l_open);
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.off);
        }
    }

    
    public void mUpdaterAirByAutoKey() {
        int value = DataCanbus.DATA[131];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.rzc_c4l_open);
        } else {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.off);
        }
    }

    
    public void mUpdaterInOutAirByAutoKey() {
        int value = DataCanbus.DATA[132];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.rzc_c4l_open);
        } else {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.off);
        }
    }

    
    public void mUpdaterHeadLampsOnSensitivity() {
        int value = DataCanbus.DATA[117];
        if (((TextView) findViewById(R.id.tv_text9)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.tv_text9)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    
    public void mUpdaterInteriorLightOffTime() {
        int value = DataCanbus.DATA[118];
        if (((TextView) findViewById(R.id.tv_text10)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.tv_text10)).setText(this.mStrInteriorLightOffTime[value]);
        }
    }
}
