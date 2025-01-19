package com.syu.carinfo.rzc.ruifengs3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class JhRuiFengS7SetFunc extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 110:
                    JhRuiFengS7SetFunc.this.updateTishiVol(value);
                    break;
                case 111:
                    JhRuiFengS7SetFunc.this.updateOutLightOffTime(value);
                    break;
                case 112:
                    JhRuiFengS7SetFunc.this.updateInterLightOffTime(value);
                    break;
                case 113:
                    JhRuiFengS7SetFunc.this.updateAutoLock(value);
                    break;
                case 114:
                    JhRuiFengS7SetFunc.this.mUpdaterPromptll(value);
                    break;
                case 115:
                    JhRuiFengS7SetFunc.this.mUpdaterLocaLight(value);
                    break;
                case 116:
                    if (((CheckedTextView) JhRuiFengS7SetFunc.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) JhRuiFengS7SetFunc.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                        break;
                    }
                case 117:
                    switch (value) {
                        case 0:
                            ((TextView) JhRuiFengS7SetFunc.this.findViewById(R.id.tv_text1)).setText("15km/h");
                            break;
                        case 1:
                            ((TextView) JhRuiFengS7SetFunc.this.findViewById(R.id.tv_text1)).setText("30km/h");
                            break;
                    }
                case 118:
                    switch (value) {
                        case 0:
                            ((TextView) JhRuiFengS7SetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_low);
                            break;
                        case 1:
                            ((TextView) JhRuiFengS7SetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_middle);
                            break;
                        case 2:
                            ((TextView) JhRuiFengS7SetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_high);
                            break;
                    }
                case 119:
                    if (((CheckedTextView) JhRuiFengS7SetFunc.this.findViewById(R.id.ctv_checkedtext2)) != null) {
                        ((CheckedTextView) JhRuiFengS7SetFunc.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                        break;
                    }
                case 121:
                    if (((CheckedTextView) JhRuiFengS7SetFunc.this.findViewById(R.id.ctv_checkedtext3)) != null) {
                        ((CheckedTextView) JhRuiFengS7SetFunc.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                        break;
                    }
                case 122:
                    if (((CheckedTextView) JhRuiFengS7SetFunc.this.findViewById(R.id.ctv_checkedtext4)) != null) {
                        ((CheckedTextView) JhRuiFengS7SetFunc.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                        break;
                    }
                case 123:
                    if (((CheckedTextView) JhRuiFengS7SetFunc.this.findViewById(R.id.ctv_checkedtext5)) != null) {
                        ((CheckedTextView) JhRuiFengS7SetFunc.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
                        break;
                    }
                case 124:
                    ((TextView) JhRuiFengS7SetFunc.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                    break;
                case 125:
                    ((TextView) JhRuiFengS7SetFunc.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_ruifengs7_setfunc);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[117] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[117] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[118] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{9, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[118] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{9, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[124];
                if (value > 1) {
                    value--;
                }
                DataCanbus.PROXY.cmd(0, new int[]{15, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[124];
                if (value < 5) {
                    value++;
                }
                DataCanbus.PROXY.cmd(0, new int[]{15, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[125];
                if (value > 1) {
                    value--;
                }
                DataCanbus.PROXY.cmd(0, new int[]{16, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[125];
                if (value < 5) {
                    value++;
                }
                DataCanbus.PROXY.cmd(0, new int[]{16, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[110] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[110] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[111] - 1;
                if (value < 0) {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(0, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[111] + 1;
                if (value > 4) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[112] - 1;
                if (value < 0) {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(0, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[112] + 1;
                if (value > 4) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[113] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[113] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{4, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[116];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{7, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[119];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{10, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[121];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{12, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[122];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{13, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[123];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{14, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[114];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{5, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[115];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{6, value}, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{64}, null, null);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
    }

    
    public void updateTishiVol(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_air_low);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_air_middle);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_air_high);
                break;
        }
    }

    
    public void updateOutLightOffTime(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text6)).setText("0");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.wc_ruiteng_string_time_0);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.wc_ruiteng_string_time_1);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.wc_ruiteng_string_time_2);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.wc_ruiteng_string_time_3);
                break;
        }
    }

    
    public void updateInterLightOffTime(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text7)).setText("0");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.wc_ruiteng_string_time_10);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.wc_ruiteng_string_time_0);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.wc_ruiteng_string_time_11);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.wc_ruiteng_string_time_1);
                break;
        }
    }

    
    public void updateAutoLock(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.jeep_comfortsystems_0);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_419_auto_lock_when_15);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_419_auto_lock_when_40);
                break;
        }
    }

    
    public void mUpdaterPromptll(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
        }
    }

    
    public void mUpdaterLocaLight(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
        }
    }
}
