package com.syu.carinfo.rzc.biaozhi408;

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

public class RZC_BZ408FuncLightActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 110:
                    RZC_BZ408FuncLightActi.this.mUpdaterValue1();
                    break;
                case 113:
                    RZC_BZ408FuncLightActi.this.mUpdaterValue4();
                    break;
                case 118:
                    RZC_BZ408FuncLightActi.this.mUpdaterValue2();
                    break;
                case 119:
                    RZC_BZ408FuncLightActi.this.mUpdaterValue3();
                    break;
                case 166:
                    RZC_BZ408FuncLightActi.this.mUpdaterValue5();
                    break;
                case 188:
                    RZC_BZ408FuncLightActi.this.mUpdaterBackLight(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_biaozhi408_func_light);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.rzc_bz408_func_btn_light_daytime_light)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[110];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(9, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.rzc_bz408_func_btn_biglight_sleep_value_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[118] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(10, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.rzc_bz408_func_btn_biglight_sleep_value_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[118] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(10, new int[]{value}, null, null);
            }
        });
        if (DataCanbus.DATA[1000] == 439 && findViewById(R.id.rzc_bz408_light_amblance_lighting_value_show) != null) {
            findViewById(R.id.rzc_bz408_light_amblance_lighting_value_show).setVisibility(8);
        }
        ((Button) findViewById(R.id.rzc_bz408_btn_light_amblance_lighting_value_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[119] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 7) {
                    value = 7;
                }
                DataCanbus.PROXY.cmd(11, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.rzc_bz408_btn_light_amblance_lighting_value_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[119] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 7) {
                    value = 7;
                }
                DataCanbus.PROXY.cmd(11, new int[]{value}, null, null);
            }
        });
        if (DataCanbus.DATA[1000] == 439 && findViewById(R.id.rzc_bz408_light_with_me_home) != null) {
            findViewById(R.id.rzc_bz408_light_with_me_home).setVisibility(8);
        }
        ((Button) findViewById(R.id.rzc_bz408_btn_light_with_me_home_lighting_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[113] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(12, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.rzc_bz408_btn_light_with_me_home_lighting_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[113] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(12, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.rzc_bz408_btn_light_welcome_light_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[166] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(14, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.rzc_bz408_btn_light_welcome_light_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[166] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(14, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.rzc_bz408_btn_light_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[188] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(83, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.rzc_bz408_btn_light_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[188] + 1;
                if (value > 15) {
                    value = 15;
                }
                DataCanbus.PROXY.cmd(83, new int[]{value}, null, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[110];
        if (((CheckedTextView) findViewById(R.id.rzc_bz408_func_btn_light_daytime_light)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_bz408_func_btn_light_daytime_light)).setChecked(value != 0);
        }
    }

    protected void mUpdaterBackLight(int data) {
        if (data > -1 && data < 16 && ((TextView) findViewById(R.id.rzc_bz408_btn_light_set_text)) != null) {
            ((TextView) findViewById(R.id.rzc_bz408_btn_light_set_text)).setText(new StringBuilder().append(data).toString());
        }
    }

    
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[118];
        if (((TextView) findViewById(R.id.rzc_bz408_func_tv_biglight_sleep_value_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.rzc_bz408_func_tv_biglight_sleep_value_show)).setText("15s");
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.rzc_bz408_func_tv_biglight_sleep_value_show)).setText("30s");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.rzc_bz408_func_tv_biglight_sleep_value_show)).setText("60s");
            } else {
                ((TextView) findViewById(R.id.rzc_bz408_func_tv_biglight_sleep_value_show)).setText(R.string.off);
            }
        }
    }

    
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[119];
        if (((TextView) findViewById(R.id.rzc_bz408_tv_light_amblance_lighting_value_show)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.rzc_bz408_tv_light_amblance_lighting_value_show)).setText(R.string.off);
            } else {
                ((TextView) findViewById(R.id.rzc_bz408_tv_light_amblance_lighting_value_show)).setText(new StringBuilder(String.valueOf(value - 1)).toString());
            }
        }
    }

    
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[113];
        if (((TextView) findViewById(R.id.rzc_bz408_tv_light_with_me_home_lighting_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.rzc_bz408_tv_light_with_me_home_lighting_show)).setText("15s");
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.rzc_bz408_tv_light_with_me_home_lighting_show)).setText("30s");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.rzc_bz408_tv_light_with_me_home_lighting_show)).setText("60s");
            } else {
                ((TextView) findViewById(R.id.rzc_bz408_tv_light_with_me_home_lighting_show)).setText(R.string.off);
            }
        }
    }

    
    public void mUpdaterValue5() {
        int value = DataCanbus.DATA[166];
        if (((TextView) findViewById(R.id.rzc_bz408_tv_light_welcome_light_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.rzc_bz408_tv_light_welcome_light_show)).setText("15s");
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.rzc_bz408_tv_light_welcome_light_show)).setText("30s");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.rzc_bz408_tv_light_welcome_light_show)).setText("60s");
            } else {
                ((TextView) findViewById(R.id.rzc_bz408_tv_light_welcome_light_show)).setText(R.string.off);
            }
        }
    }
}
