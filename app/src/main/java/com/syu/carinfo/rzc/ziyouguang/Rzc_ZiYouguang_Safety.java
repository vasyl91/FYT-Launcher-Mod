package com.syu.carinfo.rzc.ziyouguang;

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

@SuppressWarnings({"deprecation", "unchecked"})
public class Rzc_ZiYouguang_Safety extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    ((CheckedTextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
                case 99:
                    ((CheckedTextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
                case 100:
                    ((CheckedTextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                    break;
                case 109:
                    if (((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text1)) != null) {
                        if (value == 2) {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text1)).setText(R.string.jeep_parksense_1);
                            break;
                        } else if (value == 1) {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text1)).setText(R.string.jeep_parksense_0);
                            break;
                        } else {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text1)).setText(R.string.wc_psa_all_factory_settings_select_models_0);
                            break;
                        }
                    }
                    break;
                case 110:
                    if (((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text2)) != null) {
                        if (value == 3) {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_high);
                            break;
                        } else if (value == 2) {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_middle);
                            break;
                        } else if (value == 1) {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_low);
                            break;
                        } else {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text2)).setText(R.string.crv_source_null);
                            break;
                        }
                    }
                    break;
                case 111:
                    if (((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text3)) != null) {
                        if (value == 3) {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_high);
                            break;
                        } else if (value == 2) {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_middle);
                            break;
                        } else if (value == 1) {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_low);
                            break;
                        } else {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text3)).setText(R.string.crv_source_null);
                            break;
                        }
                    }
                    break;
                case 118:
                    ((CheckedTextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 119:
                    if (((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text5)) != null) {
                        if (value == 1) {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text5)).setText(R.string.str_warning);
                            break;
                        } else if (value == 2) {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text5)).setText(R.string.str_warning_assist);
                            break;
                        } else if (value == 0) {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text5)).setText("OFF");
                            break;
                        }
                    }
                    break;
                case 120:
                    ((CheckedTextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
                    break;
                case 121:
                    ((CheckedTextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
                    break;
                case 123:
                    if (((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text4)) != null) {
                        if (value == 1) {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_forwardcollisionwarn_1);
                            break;
                        } else if (value == 0) {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_forwardcollisionwarn_0);
                            break;
                        }
                    }
                    break;
                case 124:
                    if (((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text6)) != null) {
                        if (value == 0) {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text6)).setText(R.string.jeep_lanesensewarn_0);
                            break;
                        } else if (value == 1) {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text6)).setText(R.string.jeep_lanesensewarn_1);
                            break;
                        } else if (value == 2) {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text6)).setText(R.string.jeep_lanesensewarn_2);
                            break;
                        }
                    }
                    break;
                case 125:
                    if (((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text7)) != null) {
                        if (value == 0) {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text7)).setText(R.string.wc_372_low);
                            break;
                        } else if (value == 1) {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text7)).setText(R.string.wc_372_mid);
                            break;
                        } else if (value == 2) {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text7)).setText(R.string.wc_372_high);
                            break;
                        }
                    }
                    break;
                case 126:
                    if (((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text8)) != null) {
                        if (value == 1) {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_blindwarn_0);
                            break;
                        } else if (value == 2) {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_blindwarn_1);
                            break;
                        } else {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_blindwarn_2);
                            break;
                        }
                    }
                    break;
                case 165:
                    ((CheckedTextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.ctv_checkedtext14)).setChecked(value == 1);
                    break;
                case 203:
                    ((CheckedTextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
                    break;
                case 204:
                    if (((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text9)) != null) {
                        if (value == 2) {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text9)).setText(R.string.jeep_forwardcollisionwarn_1);
                            break;
                        } else if (value == 1) {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text9)).setText(R.string.jeep_lanesensewarn_1);
                            break;
                        } else {
                            ((TextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.tv_text9)).setText(R.string.jeep_forwardcollisionwarn_0);
                            break;
                        }
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_jeep_safety);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[165];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 97;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[109];
                if (value2 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[109];
                if (value2 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[110];
                if (value2 == 3) {
                    value = 1;
                } else if (value2 == 2) {
                    value = 0;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[110];
                if (value2 == 1) {
                    value = 1;
                } else if (value2 == 2) {
                    value = 2;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[111];
                if (value2 == 3) {
                    value = 1;
                } else if (value2 == 2) {
                    value = 0;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[111];
                if (value2 == 1) {
                    value = 1;
                } else if (value2 == 2) {
                    value = 2;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{3, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[98];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{132, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[99];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{7, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[100];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{11, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{10, 1}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[120];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{5, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[121];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{8, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[203];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{131, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[119];
                if (value == 0) {
                    value = 2;
                } else if (value == 2) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{129, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[119];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 2;
                } else if (value == 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{129, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[123];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{16, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[123];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{16, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[124];
                if (value2 == 2) {
                    value = 1;
                } else if (value2 == 1) {
                    value = 0;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{12, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[124];
                if (value2 == 0) {
                    value = 1;
                } else if (value2 == 1) {
                    value = 2;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{12, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[125];
                if (value2 == 2) {
                    value = 1;
                } else if (value2 == 1) {
                    value = 0;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{13, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[125];
                if (value2 == 0) {
                    value = 1;
                } else if (value2 == 1) {
                    value = 2;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{13, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[126] - 1;
                if (value <= 1) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{14, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[126] + 1;
                if (value >= 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{14, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[204] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{130, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[204] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{130, value}, null, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.mNotifyCanbus);
    }
}
