package com.syu.carinfo.psa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Psa2008settingActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 107:
                    Psa2008settingActi.this.mUpdaterValue3();
                    break;
                case 110:
                    Psa2008settingActi.this.mUpdaterValue2();
                    break;
                case 112:
                    Psa2008settingActi.this.mUpdaterValue4();
                    break;
                case 113:
                    Psa2008settingActi.this.mUpdaterValue5();
                    break;
                case 117:
                    Psa2008settingActi.this.mUpdaterValue1();
                    break;
                case 118:
                    Psa2008settingActi.this.mUpdaterValue6();
                    break;
                case 119:
                    Psa2008settingActi.this.mUpdaterValue7();
                    break;
                case 130:
                    Psa2008settingActi.this.mUpdaterTemp();
                    break;
                case 131:
                    Psa2008settingActi.this.mUpdaterOil();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_psa2008_setting);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.psa2008_radar_switch)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[117];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_welcome_light_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[110] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(7, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_welcome_light_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[110] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(7, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_oil_unit_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[131] & 3;
                if (value == 0) {
                    value = 3;
                }
                if ((DataCanbus.DATA[131] >> 7) == 1 && Psa2008settingActi.this.findViewById(R.id.view_psa2008_oil_unit) != null) {
                    Psa2008settingActi.this.findViewById(R.id.view_psa2008_oil_unit).setVisibility(0);
                }
                DataCanbus.PROXY.cmd(51, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_oil_unit_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[131] & 3;
                if (value2 < 2) {
                    value = value2 + 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(51, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_temp_unit_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[130] & 3;
                if (value2 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(53, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_temp_unit_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[130] & 3;
                if (value2 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(53, new int[]{value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.psa2008_amblance_lighting)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value1 = DataCanbus.DATA[118];
                int value12 = value1 == 0 ? 1 : 0;
                int value2 = DataCanbus.DATA[119];
                int value = ((value12 << 7) | value2) & 255;
                DataCanbus.PROXY.cmd(8, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_amblance_lighting_value_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value1 = DataCanbus.DATA[118];
                int value2 = DataCanbus.DATA[119] - 1;
                if (value2 < 0) {
                    value2 = 0;
                } else if (value2 > 6) {
                    value2 = 6;
                }
                int value = ((value1 << 7) | value2) & 255;
                DataCanbus.PROXY.cmd(8, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_amblance_lighting_value_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value1 = DataCanbus.DATA[118];
                int value2 = DataCanbus.DATA[119] + 1;
                if (value2 < 0) {
                    value2 = 0;
                } else if (value2 > 6) {
                    value2 = 6;
                }
                int value = ((value1 << 7) | value2) & 255;
                DataCanbus.PROXY.cmd(8, new int[]{value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.psa2008_rear_window_wiping)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[107];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(0, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.psa2008_daytime_running_lights)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[112];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(4, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_with_me_home_lighting_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[113] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(5, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa2008_with_me_home_lighting_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[113] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(5, new int[]{value}, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[117];
        if (((CheckedTextView) findViewById(R.id.psa2008_radar_switch)) != null) {
            ((CheckedTextView) findViewById(R.id.psa2008_radar_switch)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[110];
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

    
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[107];
        if (((CheckedTextView) findViewById(R.id.psa2008_rear_window_wiping)) != null) {
            ((CheckedTextView) findViewById(R.id.psa2008_rear_window_wiping)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[112];
        if (((CheckedTextView) findViewById(R.id.psa2008_daytime_running_lights)) != null) {
            ((CheckedTextView) findViewById(R.id.psa2008_daytime_running_lights)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue5() {
        int value = DataCanbus.DATA[113];
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

    
    public void mUpdaterValue6() {
        int value = DataCanbus.DATA[118];
        if (((CheckedTextView) findViewById(R.id.psa2008_amblance_lighting)) != null) {
            ((CheckedTextView) findViewById(R.id.psa2008_amblance_lighting)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue7() {
        int value = DataCanbus.DATA[119];
        if (((TextView) findViewById(R.id.psa2008_amblance_lighting_value)) != null) {
            ((TextView) findViewById(R.id.psa2008_amblance_lighting_value)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    
    public void mUpdaterOil() {
        if ((DataCanbus.DATA[131] >> 7) == 1 && findViewById(R.id.view_psa2008_oil_unit) != null) {
            findViewById(R.id.view_psa2008_oil_unit).setVisibility(0);
        } else {
            findViewById(R.id.view_psa2008_oil_unit).setVisibility(8);
        }
        int value = DataCanbus.DATA[131] & 3;
        if (((TextView) findViewById(R.id.psa2008_oil_unit)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.psa2008_oil_unit)).setText(CamryData.OIL_EXPEND_UNIT_MPG);
            } else if (value == 0) {
                ((TextView) findViewById(R.id.psa2008_oil_unit)).setText("L/100KM-KM");
            } else {
                ((TextView) findViewById(R.id.psa2008_oil_unit)).setText("KM/L-KM");
            }
        }
    }

    
    public void mUpdaterTemp() {
        if ((DataCanbus.DATA[130] >> 7) == 1 && findViewById(R.id.view_psa2008_temp_unit) != null) {
            findViewById(R.id.view_psa2008_temp_unit).setVisibility(0);
        } else {
            findViewById(R.id.view_psa2008_temp_unit).setVisibility(8);
        }
        int value = DataCanbus.DATA[130] & 3;
        if (((TextView) findViewById(R.id.psa2008_temp_unit)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.psa2008_temp_unit)).setText("℃");
            } else {
                ((TextView) findViewById(R.id.psa2008_temp_unit)).setText("℉");
            }
        }
    }
}
