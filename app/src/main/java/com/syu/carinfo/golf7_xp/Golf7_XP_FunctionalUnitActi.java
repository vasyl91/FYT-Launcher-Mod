package com.syu.carinfo.golf7_xp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.golf7.Golf7Data;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Golf7_XP_FunctionalUnitActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 163:
                    Golf7_XP_FunctionalUnitActi.this.mUpdaterTemperature();
                    break;
                case 164:
                    Golf7_XP_FunctionalUnitActi.this.mUpdaterVolume();
                    break;
                case 165:
                    Golf7_XP_FunctionalUnitActi.this.mUpdaterConsumption();
                    break;
                case 166:
                    Golf7_XP_FunctionalUnitActi.this.mUpdaterPressure();
                    break;
                case 180:
                    Golf7_XP_FunctionalUnitActi.this.mUpdaterDistance();
                    break;
                case 181:
                    Golf7_XP_FunctionalUnitActi.this.mUpdaterSpeed();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_functional_state_unit_xp);
        init();
    }

    @Override
    public void init() {
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_unit_distance_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[180] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 144;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_unit_distance_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[180] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 144;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_unit_speed_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[181] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 145;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_unit_speed_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[181] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 145;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_unit_temperature_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[163] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 146;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_unit_temperature_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[163] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 146;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_unit_volume_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[164] & 255) - 1;
                if (switchOn < 0) {
                    switchOn = 2;
                }
                DataCanbus.PROXY.cmd(107, new int[]{147, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_unit_volume_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[164] & 255) + 1;
                if (switchOn > 2) {
                    switchOn = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{147, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_unit_consumption_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[165] & 255) - 1;
                if (switchOn < 0) {
                    switchOn = 3;
                }
                DataCanbus.PROXY.cmd(107, new int[]{148, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_unit_consumption_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[165] & 255) + 1;
                if (switchOn > 3) {
                    switchOn = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{148, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_unit_pressure_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[166] & 255) - 1;
                if (switchOn < 0) {
                    switchOn = 2;
                }
                DataCanbus.PROXY.cmd(107, new int[]{149, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_unit_pressure_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[166] & 255) + 1;
                if (switchOn > 2) {
                    switchOn = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{149, switchOn}, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterDistance() {
        int value = DataCanbus.DATA[180];
        if (value > -1 && value < 2) {
            ((TextView) findViewById(R.id.glf7_tv_functional_unit_distance)).setText(Golf7Data.mDistanceUnitXp[value]);
        }
    }

    
    public void mUpdaterSpeed() {
        int value = DataCanbus.DATA[181];
        if (value > -1 && value < 2) {
            ((TextView) findViewById(R.id.glf7_tv_functional_unit_speed)).setText(Golf7Data.mSpeedUnitXp[value]);
        }
    }

    
    public void mUpdaterTemperature() {
        int value = DataCanbus.DATA[163];
        if (value > -1 && value < 2) {
            ((TextView) findViewById(R.id.glf7_tv_functional_unit_temperature)).setText(Golf7Data.mTempUnitXp[value]);
        }
    }

    
    public void mUpdaterVolume() {
        int value = DataCanbus.DATA[164];
        if (value > -1 && value < 3) {
            ((TextView) findViewById(R.id.glf7_tv_functional_unit_volume)).setText(Golf7Data.mVolumeUnitXp[value]);
        }
    }

    
    public void mUpdaterConsumption() {
        int value = DataCanbus.DATA[165];
        if (value > -1 && value < 4) {
            ((TextView) findViewById(R.id.glf7_tv_functional_unit_consumption)).setText(Golf7Data.mOilUnitXp[value]);
        }
    }

    
    public void mUpdaterPressure() {
        int value = DataCanbus.DATA[166];
        if (value > -1 && value < 3) {
            ((TextView) findViewById(R.id.glf7_tv_functional_unit_pressure)).setText(Golf7Data.mPressureUnitXp[value]);
        }
    }
}
