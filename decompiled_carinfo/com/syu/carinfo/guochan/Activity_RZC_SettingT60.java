package com.syu.carinfo.guochan;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Activity_RZC_SettingT60 extends BaseActivity {
    private int[] eventIds = {158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 171, 172};
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 158:
                    Activity_RZC_SettingT60.this.setCheckView((CheckedTextView) Activity_RZC_SettingT60.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 159:
                    Activity_RZC_SettingT60.this.uSeekCar(value);
                    break;
                case 160:
                    Activity_RZC_SettingT60.this.uLightOn(value);
                    break;
                case 161:
                    Activity_RZC_SettingT60.this.setCheckView((CheckedTextView) Activity_RZC_SettingT60.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 162:
                    Activity_RZC_SettingT60.this.setCheckView((CheckedTextView) Activity_RZC_SettingT60.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 163:
                    Activity_RZC_SettingT60.this.uLockFeedBack(value);
                    break;
                case 164:
                    Activity_RZC_SettingT60.this.uNokeyUnlock(value);
                    break;
                case 165:
                    Activity_RZC_SettingT60.this.ukeyUnlock(value);
                    break;
                case 166:
                    Activity_RZC_SettingT60.this.setCheckView((CheckedTextView) Activity_RZC_SettingT60.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 167:
                    Activity_RZC_SettingT60.this.setCheckView((CheckedTextView) Activity_RZC_SettingT60.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 168:
                    Activity_RZC_SettingT60.this.uSpeedWarnValue(value);
                    break;
                case 169:
                    Activity_RZC_SettingT60.this.setCheckView((CheckedTextView) Activity_RZC_SettingT60.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 170:
                    Activity_RZC_SettingT60.this.uFrontWarnMode(value);
                    break;
                case 171:
                    Activity_RZC_SettingT60.this.uFrontWarnSense(value);
                    break;
                case 172:
                    Activity_RZC_SettingT60.this.setCheckView((CheckedTextView) Activity_RZC_SettingT60.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0265_rzc_datong);
        init();
    }

    @Override
    public void addNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].removeNotify(this.mNotifyCanbus);
        }
    }

    @Override
    public void init() {
        findViewById(R.id.view_reset_flag).setVisibility(4);
        Button btn = (Button) findViewById(R.id.btn_minus2);
        if (btn != null) {
            btn.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int val = DataCanbus.DATA[160] - 1;
                    if (val < 0) {
                        val = 2;
                    }
                    Activity_RZC_SettingT60.this.sendCmd(1, val);
                }
            });
        }
        Button btn2 = (Button) findViewById(R.id.btn_plus2);
        if (btn2 != null) {
            btn2.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int val = DataCanbus.DATA[160] + 1;
                    Activity_RZC_SettingT60.this.sendCmd(1, val % 3);
                }
            });
        }
        Button btn3 = (Button) findViewById(R.id.btn_minus3);
        if (btn3 != null) {
            btn3.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int val = DataCanbus.DATA[163] - 1;
                    if (val < 0) {
                        val = 2;
                    }
                    Activity_RZC_SettingT60.this.sendCmd(2, val);
                }
            });
        }
        Button btn4 = (Button) findViewById(R.id.btn_plus3);
        if (btn4 != null) {
            btn4.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int val = DataCanbus.DATA[163] + 1;
                    Activity_RZC_SettingT60.this.sendCmd(2, val % 3);
                }
            });
        }
        Button btn5 = (Button) findViewById(R.id.btn_minus1);
        if (btn5 != null) {
            btn5.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int val = DataCanbus.DATA[168] - 10;
                    if (val < 30) {
                        val = 30;
                    }
                    Activity_RZC_SettingT60.this.sendCmd(9, val);
                }
            });
        }
        Button btn6 = (Button) findViewById(R.id.btn_plus1);
        if (btn6 != null) {
            btn6.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int val = DataCanbus.DATA[168] + 10;
                    if (val > 220) {
                        val = 220;
                    }
                    Activity_RZC_SettingT60.this.sendCmd(9, val);
                }
            });
        }
        Button btn7 = (Button) findViewById(R.id.btn_minus4);
        if (btn7 != null) {
            btn7.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int val = DataCanbus.DATA[170] - 1;
                    if (val < 0) {
                        val = 1;
                    }
                    Activity_RZC_SettingT60.this.sendCmd(12, val);
                }
            });
        }
        Button btn8 = (Button) findViewById(R.id.btn_plus4);
        if (btn8 != null) {
            btn8.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int val = DataCanbus.DATA[170] + 1;
                    if (val > 1) {
                        val = 0;
                    }
                    Activity_RZC_SettingT60.this.sendCmd(12, val);
                }
            });
        }
        Button btn9 = (Button) findViewById(R.id.btn_minus5);
        if (btn9 != null) {
            btn9.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int val = DataCanbus.DATA[171] - 1;
                    if (val < 0) {
                        val = 2;
                    }
                    Activity_RZC_SettingT60.this.sendCmd(13, val);
                }
            });
        }
        Button btn10 = (Button) findViewById(R.id.btn_plus5);
        if (btn10 != null) {
            btn10.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int val = DataCanbus.DATA[171] + 1;
                    if (val > 2) {
                        val = 0;
                    }
                    Activity_RZC_SettingT60.this.sendCmd(13, val);
                }
            });
        }
        Button btn11 = (Button) findViewById(R.id.btn_minus6);
        if (btn11 != null) {
            btn11.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int val = DataCanbus.DATA[159] - 1;
                    if (val < 0) {
                        val = 1;
                    }
                    Activity_RZC_SettingT60.this.sendCmd(5, val);
                }
            });
        }
        Button btn12 = (Button) findViewById(R.id.btn_plus6);
        if (btn12 != null) {
            btn12.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int val = DataCanbus.DATA[159] + 1;
                    if (val > 1) {
                        val = 0;
                    }
                    Activity_RZC_SettingT60.this.sendCmd(5, val);
                }
            });
        }
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), 7, 165);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), 10, 166);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), 8, 167);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), 0, 158);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), 14, 172);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), 3, 161);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), 4, 162);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), 6, 164);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), 11, 169);
    }

    protected void uFrontWarnSense(int value) {
        TextView txt = (TextView) findViewById(R.id.tv_text8);
        if (txt != null) {
            int id = R.string.klc_air_low;
            if (value == 1) {
                id = R.string.klc_air_middle;
            } else if (value == 2) {
                id = R.string.klc_air_high;
            }
            txt.setText(id);
        }
    }

    protected void uFrontWarnMode(int value) {
        TextView txt = (TextView) findViewById(R.id.tv_text7);
        if (txt != null) {
            int id = R.string.str_warning;
            if (value == 1) {
                id = R.string.str_warning_assist;
            }
            txt.setText(id);
        }
    }

    private void sendClick(View v, final int type, final int id) {
        if (v != null) {
            v.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v2) {
                    int value = DataCanbus.DATA[id];
                    Activity_RZC_SettingT60.this.sendCmd(type, value == 0 ? 1 : 0);
                }
            });
        }
    }

    protected void uLockFeedBack(int value) {
        TextView txt = (TextView) findViewById(R.id.tv_text6);
        if (txt != null) {
            int id = R.string.klc_remote_Remote_control_latch_speaker;
            if (value == 1) {
                id = R.string.klc_remote_Remote_control_latch_light_Speaker;
            } else if (value == 2) {
                id = R.string.klc_remote_Remote_control_latch_only_light;
            }
            txt.setText(id);
        }
    }

    protected void uLightOn(int value) {
        TextView txt = (TextView) findViewById(R.id.tv_text4);
        if (txt != null) {
            String str = "30s";
            if (value == 1) {
                str = "60s";
            } else if (value == 2) {
                str = "90s";
            }
            txt.setText(str);
        }
    }

    protected void uSpeedWarnValue(int value) {
        TextView txt = (TextView) findViewById(R.id.tv_text2);
        if (txt != null) {
            txt.setText(new StringBuilder().append(value).toString());
        }
    }

    protected void uSeekCar(int value) {
        TextView txt = (TextView) findViewById(R.id.tv_text3);
        if (txt != null) {
            int id = R.string.klc_remote_Remote_control_latch_only_light;
            if (value == 1) {
                id = R.string.klc_remote_Remote_control_latch_light_Speaker;
            }
            txt.setText(id);
        }
        setCheckView((CheckedTextView) findViewById(R.id.ctv_checkedtext5), value == 1);
    }

    protected void uNokeyUnlock(int value) {
        TextView txt = (TextView) findViewById(R.id.tv_text5);
        if (txt != null) {
            int id = R.string.wc_ruiteng_string_intelligent_unlocke_1;
            if (value == 1) {
                id = R.string.wc_ruiteng_string_intelligent_unlocke_0;
            }
            txt.setText(id);
        }
        setCheckView((CheckedTextView) findViewById(R.id.ctv_checkedtext8), value == 1);
    }

    protected void ukeyUnlock(int value) {
        TextView txt = (TextView) findViewById(R.id.tv_text1);
        if (txt != null) {
            int id = R.string.wc_ruiteng_string_intelligent_unlocke_1;
            if (value == 1) {
                id = R.string.wc_ruiteng_string_intelligent_unlocke_0;
            }
            txt.setText(id);
        }
        setCheckView((CheckedTextView) findViewById(R.id.ctv_checkedtext1), value == 1);
    }

    
    public void setCheckView(CheckedTextView v, boolean b) {
        if (v != null) {
            v.setChecked(b);
        }
    }

    
    public void sendCmd(int type, int i) {
        DataCanbus.PROXY.cmd(3, new int[]{type, i}, null, null);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }
}
