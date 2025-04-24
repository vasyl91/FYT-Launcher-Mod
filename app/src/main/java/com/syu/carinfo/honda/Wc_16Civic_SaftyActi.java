package com.syu.carinfo.honda;

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
public class Wc_16Civic_SaftyActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 132:
                    Wc_16Civic_SaftyActi.this.m68D14();
                    break;
                case 133:
                    Wc_16Civic_SaftyActi.this.m68D13();
                    break;
                case 134:
                    Wc_16Civic_SaftyActi.this.m68D12();
                    break;
                case 135:
                    Wc_16Civic_SaftyActi.this.m68D10();
                    break;
                case 157:
                    Wc_16Civic_SaftyActi.this.m_rise_warning(val);
                    break;
                case 158:
                    Wc_16Civic_SaftyActi.this.m_rise_driver(val);
                    break;
                case 162:
                    Wc_16Civic_SaftyActi.this.m_laneoffset_show(val);
                    break;
                case 186:
                    if (((TextView) Wc_16Civic_SaftyActi.this.findViewById(R.id.tv_text14)) != null) {
                        if (val == 0) {
                            ((TextView) Wc_16Civic_SaftyActi.this.findViewById(R.id.tv_text14)).setText(R.string.str_298_visual_warning_);
                            break;
                        } else if (val == 1) {
                            ((TextView) Wc_16Civic_SaftyActi.this.findViewById(R.id.tv_text14)).setText(R.string.str_298_tactile_and_visual_warnings);
                            break;
                        }
                    }
                    break;
                case 187:
                    if (((TextView) Wc_16Civic_SaftyActi.this.findViewById(R.id.tv_text15)) != null) {
                        if (val == 0) {
                            ((TextView) Wc_16Civic_SaftyActi.this.findViewById(R.id.tv_text15)).setText("巡航控制时激活");
                            break;
                        } else if (val == 1) {
                            ((TextView) Wc_16Civic_SaftyActi.this.findViewById(R.id.tv_text15)).setText("在特定速度范围内激活");
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
        //setContentView(R.layout.layout_321_civic_safety);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[133] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 3;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(105, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[134] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 2;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(105, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[157] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 8;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(105, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[158] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(105, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[158];
                DataCanbus.PROXY.cmd(105, new int[]{7, (value + 1) % 3}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[132] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(105, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[132] & 255;
                if (value2 < 3) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(105, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[135] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(105, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[135] & 255;
                if (value2 < 3) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(105, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = (DataCanbus.DATA[162] & 255) - 1;
                if (value < 1) {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(105, new int[]{9, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = (DataCanbus.DATA[162] & 255) + 1;
                if (value > 4) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(105, new int[]{9, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = (DataCanbus.DATA[186] & 255) - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(105, new int[]{11, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = (DataCanbus.DATA[186] & 255) + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(105, new int[]{11, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = (DataCanbus.DATA[187] & 255) - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(105, new int[]{10, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = (DataCanbus.DATA[187] & 255) + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(105, new int[]{10, value}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
    }

    
    public void m_laneoffset_show(int val) {
        switch (val) {
            case 1:
                ((TextView) findViewById(R.id.tv_text13)).setText(R.string.carema_type_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text13)).setText(R.string.carema_type_4);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text13)).setText(R.string.carema_type_5);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text13)).setText(R.string.carema_type_6);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text13)).setText(R.string.carema_type_1);
                break;
        }
    }

    
    public void m_rise_driver(int val) {
        switch (val) {
            case 1:
                ((TextView) findViewById(R.id.tv_text10)).setText(R.string.str_298_visual_warning_);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text10)).setText(R.string.str_298_tactile_and_visual_warnings);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text10)).setText(R.string.off);
                break;
        }
    }

    
    public void m_rise_warning(int val) {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(val == 1);
        if (val == 1) {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_right_camera_close);
        }
    }

    
    public void m68D14() {
        int temp = DataCanbus.DATA[132] & 65535;
        int switchOn = temp & 255;
        if (((TextView) findViewById(R.id.tv_text11)) != null) {
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text11)).setText(R.string.jeep_playstate11);
                return;
            }
            if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text11)).setText(R.string.jeep_lanesensewarn_1);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_text11)).setText(R.string.wc_321_warning_lan_str);
            } else if (switchOn == 3) {
                ((TextView) findViewById(R.id.tv_text11)).setText(R.string.wc_321_warning_wan_str);
            }
        }
    }

    
    public void m68D13() {
        int temp = DataCanbus.DATA[133] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn == 1);
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_right_camera_close);
        }
    }

    
    public void m68D12() {
        int temp = DataCanbus.DATA[134] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn == 1);
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_right_camera_close);
        }
    }

    
    public void m68D10() {
        int temp = DataCanbus.DATA[135] & 65535;
        int switchOn = temp & 255;
        if (((TextView) findViewById(R.id.tv_text12)) != null) {
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text12)).setText(R.string.jeep_playstate11);
                return;
            }
            if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text12)).setText(R.string.jeep_forwardcollisionwarn_1);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_text12)).setText(R.string.jeep_lanesensewarn_1);
            } else if (switchOn == 3) {
                ((TextView) findViewById(R.id.tv_text12)).setText(R.string.jeep_forwardcollisionwarn_0);
            }
        }
    }
}
