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
public class Wc_16Civic_LightActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode] & 65535;
            switch (updateCode) {
                case 120:
                    Wc_16Civic_LightActi.this.m67D03();
                    break;
                case 121:
                    Wc_16Civic_LightActi.this.m67D00();
                    break;
                case 122:
                    Wc_16Civic_LightActi.this.m67D14();
                    break;
                case 123:
                    Wc_16Civic_LightActi.this.m67D12();
                    break;
                case 124:
                    Wc_16Civic_LightActi.this.m67D10();
                    break;
                case 182:
                    ((CheckedTextView) Wc_16Civic_LightActi.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_321_civic_light);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[182] & 65535;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 6;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(102, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[120] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(102, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[120] & 255;
                if (value2 < 1) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(102, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[121] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(102, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[121] & 255;
                if (value2 < 4) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(102, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[122] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(102, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[122] & 255;
                if (value2 < 4) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(102, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[123] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(102, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[123] & 255;
                if (value2 < 3) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(102, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[124] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(102, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[124] & 255;
                if (value2 < 3) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(102, new int[]{1, value}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
    }

    
    public void m67D03() {
        int temp = DataCanbus.DATA[120] & 65535;
        int value = temp & 255;
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_right_camera_close);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_right_camera_open);
            }
        }
    }

    
    public void m67D00() {
        int temp = DataCanbus.DATA[121] & 65535;
        int value = temp & 255;
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.xp_accord9_auto_light_0lowest);
                return;
            }
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.xp_accord9_auto_light_1lower);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.xp_accord9_auto_light_2middle);
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.xp_accord9_auto_light_3higher);
            } else if (value == 4) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.xp_accord9_auto_light_4highest);
            }
        }
    }

    
    public void m67D14() {
        int temp = DataCanbus.DATA[122] & 65535;
        int value = temp & 255;
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.xp_accord9_auto_light_0lowest);
                return;
            }
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.xp_accord9_auto_light_1lower);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.xp_accord9_auto_light_2middle);
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.xp_accord9_auto_light_3higher);
            } else if (value == 4) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.xp_accord9_auto_light_4highest);
            }
        }
    }

    
    public void m67D12() {
        int temp = DataCanbus.DATA[123] & 65535;
        int value = temp & 255;
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text4)).setText("0 S");
                return;
            }
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text4)).setText("15 S");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.tv_text4)).setText("30 S");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text4)).setText("60 S");
            }
        }
    }

    
    public void m67D10() {
        int temp = DataCanbus.DATA[124] & 65535;
        int value = temp & 255;
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.jeep_playstate11);
                return;
            }
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text5)).setText("15 S");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.tv_text5)).setText("30 S");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text5)).setText("60 S");
            }
        }
    }
}
