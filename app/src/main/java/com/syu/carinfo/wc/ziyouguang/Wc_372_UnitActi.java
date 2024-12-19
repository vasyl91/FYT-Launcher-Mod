package com.syu.carinfo.wc.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Wc_372_UnitActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_UnitActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 34:
                    Wc_372_UnitActi.this.mc1d3();
                    break;
                case 44:
                    Wc_372_UnitActi.this.mc1d0();
                    break;
                case 73:
                    Wc_372_UnitActi.this.mtemp();
                    break;
                case 93:
                    Wc_372_UnitActi.this.moil();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_372_zyg_unit);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.wc_372_unit_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_UnitActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[34] & 255;
                if (value2 == 2) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(4, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_unit_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_UnitActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[34] & 255;
                if (value2 == 2) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(4, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_pressure_unit_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_UnitActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[44] & 255;
                if (value2 == 0) {
                    value = 2;
                } else if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_pressure_unit_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_UnitActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[44] & 255;
                if (value2 == 0) {
                    value = 1;
                } else if (value2 == 1) {
                    value = 2;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_temp_unit_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_UnitActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[73] & 255;
                if (value2 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_temp_unit_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_UnitActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[73] & 255;
                if (value2 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_oil_unit_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_UnitActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[93] & 255;
                if (value2 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_oil_unit_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_UnitActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[93] & 255;
                if (value2 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{5, value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        if (DataCanbus.DATA[1000] == 196980) {
            findViewById(R.id.wc_372_view_pressure_unit).setVisibility(0);
        } else {
            findViewById(R.id.wc_372_view_pressure_unit).setVisibility(8);
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mtemp() {
        int value = DataCanbus.DATA[73] & 255;
        if (((TextView) findViewById(R.id.wc_372_temp_unit_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_temp_unit_set_show)).setText("℃");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_temp_unit_set_show)).setText("℉");
            } else {
                ((TextView) findViewById(R.id.wc_372_temp_unit_set_show)).setText("℃");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moil() {
        int temp = DataCanbus.DATA[93] & 65535;
        int value = temp & 255;
        if (((TextView) findViewById(R.id.wc_372_oil_unit_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_oil_unit_set_show)).setText("L/100KM");
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_oil_unit_set_show)).setText("KM/L");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.wc_372_oil_unit_set_show)).setText("MPG");
            } else {
                ((TextView) findViewById(R.id.wc_372_oil_unit_set_show)).setText("L/100KM");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mc1d3() {
        int temp = DataCanbus.DATA[34] & 65535;
        int value = temp & 255;
        findViewById(R.id.wc_372_view_unit).setVisibility(0);
        if (((TextView) findViewById(R.id.wc_372_unit_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_unit_set_show)).setText(R.string.jeep_format_set1);
            } else if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_unit_set_show)).setText(R.string.jeep_format_set0);
            } else {
                ((TextView) findViewById(R.id.wc_372_unit_set_show)).setText(R.string.jeep_format_set1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mc1d0() {
        int temp = DataCanbus.DATA[44] & 65535;
        int value = temp & 255;
        findViewById(R.id.wc_372_view_pressure_unit).setVisibility(0);
        if (((TextView) findViewById(R.id.wc_372_pressure_unit_set_show)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.wc_372_pressure_unit_set_show)).setText("psi");
                return;
            }
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_pressure_unit_set_show)).setText("kpa");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_pressure_unit_set_show)).setText("bar");
            } else {
                ((TextView) findViewById(R.id.wc_372_pressure_unit_set_show)).setText("kpa");
            }
        }
    }
}
