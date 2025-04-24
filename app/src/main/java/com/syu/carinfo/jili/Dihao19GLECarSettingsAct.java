package com.syu.carinfo.jili;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Dihao19GLECarSettingsAct extends BaseActivity implements View.OnClickListener {
    private int[] eventIds = {158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 215};
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 158:
                    switch (value) {
                        case 0:
                            ((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_5);
                            break;
                        case 1:
                            ((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_3);
                            break;
                        case 2:
                            ((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.guandao_lock2);
                            break;
                        case 3:
                            ((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_7);
                            break;
                    }
                case 159:
                    switch (value) {
                        case 0:
                            ((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                            break;
                        case 1:
                            ((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                            break;
                    }
                case 160:
                    switch (value) {
                        case 0:
                            ((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_low);
                            break;
                        case 1:
                            ((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_middle);
                            break;
                        case 2:
                            ((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_high);
                            break;
                    }
                case 161:
                    Dihao19GLECarSettingsAct.this.setCheckView((CheckedTextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 162:
                    Dihao19GLECarSettingsAct.this.setCheckView((CheckedTextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 163:
                    Dihao19GLECarSettingsAct.this.setCheckView((CheckedTextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 164:
                    Dihao19GLECarSettingsAct.this.setCheckView((CheckedTextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 165:
                    Dihao19GLECarSettingsAct.this.setCheckView((CheckedTextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 166:
                    Dihao19GLECarSettingsAct.this.setCheckView((CheckedTextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 167:
                    Dihao19GLECarSettingsAct.this.setCheckView((CheckedTextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 168:
                    Dihao19GLECarSettingsAct.this.setCheckView((CheckedTextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 169:
                    Dihao19GLECarSettingsAct.this.setCheckView((CheckedTextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    if (((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text4)).setText(value == 1 ? R.string.jeep_forwardcollisionwarn_1 : R.string.jeep_forwardcollisionwarn_0);
                        break;
                    }
                case 170:
                    Dihao19GLECarSettingsAct.this.setCheckView((CheckedTextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 171:
                    ((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "%");
                    break;
                case 215:
                    switch (value) {
                        case 0:
                            ((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_battery_charge);
                            break;
                        case 2:
                            ((TextView) Dihao19GLECarSettingsAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_power_maintain);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_139_rzc_dihao_gle);
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
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[215] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{80, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[215] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{80, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[171] - 5;
                if (value < 20) {
                    value = 20;
                }
                DataCanbus.PROXY.cmd(1, new int[]{37, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[171] + 5;
                if (value > 80) {
                    value = 80;
                }
                DataCanbus.PROXY.cmd(1, new int[]{37, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[158] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{28, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[158] + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{28, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[159] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{17, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[159] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{17, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[160] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{25, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[160] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{25, value}, null, null);
            }
        });
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), 29, 161);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), 30, 162);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), 31, 163);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), 32, 164);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), 20, 165);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), 33, 166);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), 10, 167);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), 34, 168);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), 36, 170);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), 35, 169);
    }

    private void sendClick(View v, final int cmd, final int id) {
        if (v != null) {
            v.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v2) {
                    int value = DataCanbus.DATA[id];
                    Dihao19GLECarSettingsAct.this.sendCmd(cmd, value == 0 ? 1 : 0);
                }
            });
        }
    }

    
    public void setCheckView(CheckedTextView v, boolean b) {
        if (v != null) {
            v.setChecked(b);
        }
    }

    
    public void sendCmd(int cmd, int value) {
        DataCanbus.PROXY.cmd(1, new int[]{cmd, value}, null, null);
    }

    @Override
    public void onClick(View v) {
    }
}
