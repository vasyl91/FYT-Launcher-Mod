package com.syu.carinfo.psa;

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
public class Psa2008settingActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.psa.Psa2008settingActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    Psa2008settingActi.this.mUpdaterValue3();
                    break;
                case 13:
                    Psa2008settingActi.this.mUpdaterValue2();
                    break;
                case 15:
                    Psa2008settingActi.this.mUpdaterValue4();
                    break;
                case 16:
                    Psa2008settingActi.this.mUpdaterValue5();
                    break;
                case 20:
                    Psa2008settingActi.this.mUpdaterValue1();
                    break;
                case 21:
                    Psa2008settingActi.this.mUpdaterValue6();
                    break;
                case 22:
                    Psa2008settingActi.this.mUpdaterValue7();
                    break;
                case 33:
                    Psa2008settingActi.this.mUpdaterTemp();
                    break;
                case 34:
                    Psa2008settingActi.this.mUpdaterOil();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_psa2008_setting);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.psa2008_radar_switch)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008settingActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[20];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_welcome_light_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008settingActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[13] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(7, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_welcome_light_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008settingActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[13] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(7, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_oil_unit_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008settingActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[34] & 3;
                if (value == 0) {
                    value = 3;
                }
                if ((DataCanbus.DATA[34] >> 7) == 1 && Psa2008settingActi.this.findViewById(R.id.view_psa2008_oil_unit) != null) {
                    Psa2008settingActi.this.findViewById(R.id.view_psa2008_oil_unit).setVisibility(0);
                }
                DataCanbus.PROXY.cmd(51, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_oil_unit_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008settingActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[34] & 3;
                if (value2 < 2) {
                    value = value2 + 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(51, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_temp_unit_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008settingActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[33] & 3;
                if (value2 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(53, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_temp_unit_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008settingActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[33] & 3;
                if (value2 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(53, new int[]{value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.psa2008_amblance_lighting)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008settingActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value1 = DataCanbus.DATA[21];
                int value12 = value1 == 0 ? 1 : 0;
                int value2 = DataCanbus.DATA[22];
                int value = ((value12 << 7) | value2) & 255;
                DataCanbus.PROXY.cmd(8, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_amblance_lighting_value_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008settingActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value1 = DataCanbus.DATA[21];
                int value2 = DataCanbus.DATA[22] - 1;
                if (value2 < 0) {
                    value2 = 0;
                } else if (value2 > 6) {
                    value2 = 6;
                }
                int value = ((value1 << 7) | value2) & 255;
                DataCanbus.PROXY.cmd(8, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_amblance_lighting_value_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008settingActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value1 = DataCanbus.DATA[21];
                int value2 = DataCanbus.DATA[22] + 1;
                if (value2 < 0) {
                    value2 = 0;
                } else if (value2 > 6) {
                    value2 = 6;
                }
                int value = ((value1 << 7) | value2) & 255;
                DataCanbus.PROXY.cmd(8, new int[]{value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.psa2008_rear_window_wiping)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008settingActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[10];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(0, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.psa2008_daytime_running_lights)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008settingActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[15];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(4, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_with_me_home_lighting_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008settingActi.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[16] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(5, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_with_me_home_lighting_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa2008settingActi.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[16] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(5, new int[]{value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[20];
        if (((CheckedTextView) findViewById(R.id.psa2008_radar_switch)) != null) {
            ((CheckedTextView) findViewById(R.id.psa2008_radar_switch)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[13];
        if (((TextView) findViewById(R.id.psa2008_welcome_light)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.psa2008_welcome_light)).setText("15s");
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.psa2008_welcome_light)).setText("30s");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.psa2008_welcome_light)).setText("60s");
            } else {
                ((TextView) findViewById(R.id.psa2008_welcome_light)).setText(R.string.off);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[10];
        if (((CheckedTextView) findViewById(R.id.psa2008_rear_window_wiping)) != null) {
            ((CheckedTextView) findViewById(R.id.psa2008_rear_window_wiping)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[15];
        if (((CheckedTextView) findViewById(R.id.psa2008_daytime_running_lights)) != null) {
            ((CheckedTextView) findViewById(R.id.psa2008_daytime_running_lights)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue5() {
        int value = DataCanbus.DATA[16];
        if (((TextView) findViewById(R.id.psa2008_with_me_home_lighting)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.psa2008_with_me_home_lighting)).setText("15s");
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.psa2008_with_me_home_lighting)).setText("30s");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.psa2008_with_me_home_lighting)).setText("60s");
            } else {
                ((TextView) findViewById(R.id.psa2008_with_me_home_lighting)).setText(R.string.off);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue6() {
        int value = DataCanbus.DATA[21];
        if (((CheckedTextView) findViewById(R.id.psa2008_amblance_lighting)) != null) {
            ((CheckedTextView) findViewById(R.id.psa2008_amblance_lighting)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue7() {
        int value = DataCanbus.DATA[22];
        if (((TextView) findViewById(R.id.psa2008_amblance_lighting_value)) != null) {
            ((TextView) findViewById(R.id.psa2008_amblance_lighting_value)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOil() {
        if ((DataCanbus.DATA[34] >> 7) == 1 && findViewById(R.id.view_psa2008_oil_unit) != null) {
            findViewById(R.id.view_psa2008_oil_unit).setVisibility(0);
        } else {
            findViewById(R.id.view_psa2008_oil_unit).setVisibility(8);
        }
        int value = DataCanbus.DATA[34] & 3;
        if (((TextView) findViewById(R.id.psa2008_oil_unit)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.psa2008_oil_unit)).setText("MPG");
            } else if (value == 0) {
                ((TextView) findViewById(R.id.psa2008_oil_unit)).setText("L/100KM-KM");
            } else {
                ((TextView) findViewById(R.id.psa2008_oil_unit)).setText("KM/L-KM");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTemp() {
        if ((DataCanbus.DATA[33] >> 7) == 1 && findViewById(R.id.view_psa2008_temp_unit) != null) {
            findViewById(R.id.view_psa2008_temp_unit).setVisibility(0);
        } else {
            findViewById(R.id.view_psa2008_temp_unit).setVisibility(8);
        }
        int value = DataCanbus.DATA[33] & 3;
        if (((TextView) findViewById(R.id.psa2008_temp_unit)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.psa2008_temp_unit)).setText("℃");
            } else {
                ((TextView) findViewById(R.id.psa2008_temp_unit)).setText("℉");
            }
        }
    }
}
