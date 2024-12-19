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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZC_BZ408FuncLightActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncLightActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 99:
                    RZC_BZ408FuncLightActi.this.mUpdaterValue1();
                    break;
                case 102:
                    RZC_BZ408FuncLightActi.this.mUpdaterValue4();
                    break;
                case 107:
                    RZC_BZ408FuncLightActi.this.mUpdaterValue2();
                    break;
                case 108:
                    RZC_BZ408FuncLightActi.this.mUpdaterValue3();
                    break;
                case 155:
                    RZC_BZ408FuncLightActi.this.mUpdaterValue5();
                    break;
                case 177:
                    RZC_BZ408FuncLightActi.this.mUpdaterBackLight(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_biaozhi408_func_light);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.rzc_bz408_func_btn_light_daytime_light)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncLightActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[99];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(9, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.rzc_bz408_func_btn_biglight_sleep_value_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncLightActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[107] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(10, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.rzc_bz408_func_btn_biglight_sleep_value_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncLightActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[107] + 1;
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
        ((Button) findViewById(R.id.rzc_bz408_btn_light_amblance_lighting_value_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncLightActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[108] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 7) {
                    value = 7;
                }
                DataCanbus.PROXY.cmd(11, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.rzc_bz408_btn_light_amblance_lighting_value_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncLightActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[108] + 1;
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
        ((Button) findViewById(R.id.rzc_bz408_btn_light_with_me_home_lighting_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncLightActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[102] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(12, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.rzc_bz408_btn_light_with_me_home_lighting_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncLightActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[102] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(12, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.rzc_bz408_btn_light_welcome_light_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncLightActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[155] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(14, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.rzc_bz408_btn_light_welcome_light_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncLightActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[155] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(14, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.rzc_bz408_btn_light_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncLightActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[177] - 1;
                if (value < 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(83, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.rzc_bz408_btn_light_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408FuncLightActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[177] + 1;
                if (value > 15) {
                    value = 15;
                }
                DataCanbus.PROXY.cmd(83, new int[]{value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[99];
        if (((CheckedTextView) findViewById(R.id.rzc_bz408_func_btn_light_daytime_light)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_bz408_func_btn_light_daytime_light)).setChecked(value != 0);
        }
    }

    protected void mUpdaterBackLight(int data) {
        if (data > -1 && data < 16 && ((TextView) findViewById(R.id.rzc_bz408_btn_light_set_text)) != null) {
            ((TextView) findViewById(R.id.rzc_bz408_btn_light_set_text)).setText(new StringBuilder().append(data).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[107];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[108];
        if (((TextView) findViewById(R.id.rzc_bz408_tv_light_amblance_lighting_value_show)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.rzc_bz408_tv_light_amblance_lighting_value_show)).setText(R.string.off);
            } else {
                ((TextView) findViewById(R.id.rzc_bz408_tv_light_amblance_lighting_value_show)).setText(new StringBuilder(String.valueOf(value - 1)).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[102];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue5() {
        int value = DataCanbus.DATA[155];
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
