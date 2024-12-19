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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Rzc_ZiYouguang_Safety extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 0:
                    ((CheckedTextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
                case 1:
                    ((CheckedTextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
                case 2:
                    ((CheckedTextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                    break;
                case 11:
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
                case 12:
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
                case 13:
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
                case 20:
                    ((CheckedTextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 21:
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
                case 22:
                    ((CheckedTextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
                    break;
                case 23:
                    ((CheckedTextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
                    break;
                case 25:
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
                case 26:
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
                case 27:
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
                case 28:
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
                case 98:
                    ((CheckedTextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.ctv_checkedtext14)).setChecked(value == 1);
                    break;
                case 147:
                    ((CheckedTextView) Rzc_ZiYouguang_Safety.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
                    break;
                case 148:
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_jeep_safety);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[98];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 97;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[11];
                if (value2 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[11];
                if (value2 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[12];
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
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[12];
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
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[13];
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
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[13];
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
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[0];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{132, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[1];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{7, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[2];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{11, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{10, 1}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[22];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{5, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[23];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{8, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[147];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{131, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[21];
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
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[21];
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
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[25];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{16, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[25];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{16, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[26];
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
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[26];
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
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[27];
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
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[27];
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
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[28] - 1;
                if (value <= 1) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{14, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[28] + 1;
                if (value >= 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{14, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.26
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[148] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{130, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Safety.27
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[148] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{130, value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
    }
}
