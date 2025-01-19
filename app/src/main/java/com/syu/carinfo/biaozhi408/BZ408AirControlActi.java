package com.syu.carinfo.biaozhi408;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class BZ408AirControlActi extends BaseActivity {
    public static BZ408AirControlActi mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    BZ408AirControlActi.this.mUpdatePowerOn();
                    break;
                case 11:
                    BZ408AirControlActi.this.mUpdaterAirHybirdAc();
                    break;
                case 13:
                    BZ408AirControlActi.this.mUpdaterAirAutoOn();
                    break;
                case 14:
                    BZ408AirControlActi.this.mUpdaterAirDual();
                    break;
                case 18:
                    BZ408AirControlActi.this.mUpdaterBlowUpLeftOn();
                    break;
                case 19:
                    BZ408AirControlActi.this.mUpdaterBlowBodyLeftOn();
                    break;
                case 20:
                    BZ408AirControlActi.this.mUpdaterBlowFootLeftOn();
                    break;
                case 21:
                    BZ408AirControlActi.this.mUpdaterAirWindLevelLeft();
                    break;
                case 27:
                    BZ408AirControlActi.this.mUpdaterAirTempLeft();
                    break;
                case 28:
                    BZ408AirControlActi.this.mUpdaterAirTempRight();
                    break;
                case 52:
                    BZ408AirControlActi.this.mUpdaterAirWindStrong();
                    break;
                case 53:
                    BZ408AirControlActi.this.mUpdaterAirAcMax();
                    break;
                case 55:
                    BZ408AirControlActi.this.mUpdaterAirMono();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_wc_xp_biaozhi_408_air_control);
        AirHelper.disableAirWindowLocal(true);
        mInstance = this;
        init();
    }

    @Override
    public void init() {
        findViewById(R.id.btn_air_temp_left_minus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(266, new int[]{1}, null, null);
            }
        });
        findViewById(R.id.btn_air_temp_left_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(266, new int[1], null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_mode_win)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[18];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(262, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_mode_body)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[19];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(263, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_mode_foot)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[20];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(264, iArr, null, null);
            }
        });
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(265, new int[]{1}, null, null);
            }
        });
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(265, new int[1], null, null);
            }
        });
        findViewById(R.id.btn_air_temp_right_minus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(267, new int[]{1}, null, null);
            }
        });
        findViewById(R.id.btn_air_temp_right_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(267, new int[1], null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_auto)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[13];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(258, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_ac)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[11];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(256, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_maxac)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[53];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(257, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_mono)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[1000] == 118 || DataCanbus.DATA[1000] == 185 || DataCanbus.DATA[1000] == 65817 || DataCanbus.DATA[1000] == 281 || DataCanbus.DATA[1000] == 262425) {
                    int value = DataCanbus.DATA[14];
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value != 0 ? 0 : 1;
                    remoteModuleProxy.cmd(269, iArr, null, null);
                    return;
                }
                int value2 = DataCanbus.DATA[55];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[1];
                iArr2[0] = value2 != 0 ? 0 : 1;
                remoteModuleProxy2.cmd(269, iArr2, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_winlev)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[52];
                if (value == 2) {
                    DataCanbus.PROXY.cmd(268, new int[1], null, null);
                } else if (value == 1) {
                    DataCanbus.PROXY.cmd(268, new int[]{2}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(268, new int[]{1}, null, null);
                }
            }
        });
    }

    
    public void mUpdaterAirTempLeft() {
        int unit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("NO");
                return;
            }
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                return;
            }
            if (DataCanbus.DATA[1000] == 118 || DataCanbus.DATA[1000] == 185 || DataCanbus.DATA[1000] == 65817 || DataCanbus.DATA[1000] == 281 || DataCanbus.DATA[1000] == 262425) {
                if (unit != 0) {
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 5) + "°F");
                    return;
                } else {
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText(((temp - 20) / 10.0f) + "°C");
                    return;
                }
            }
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 10.0f) + "°C");
        }
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[10];
        findViewById(R.id.air_xts_power).setBackgroundResource(power != 0 ? R.drawable.ic_xts_power_p : R.drawable.ic_xts_power_n);
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int level = DataCanbus.DATA[21];
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null) {
            if (level == 0) {
                ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setTextSize(25.0f);
                ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText("Auto");
            } else {
                ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setTextSize(40.0f);
                ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level - 1).toString());
            }
        }
    }

    
    public void mUpdaterBlowUpLeftOn() {
        int value = DataCanbus.DATA[18];
        if (((Button) findViewById(R.id.air_xts_mode_win)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_win)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_win_n : R.drawable.ic_xts_mode_win_p);
        }
    }

    
    public void mUpdaterBlowBodyLeftOn() {
        int value = DataCanbus.DATA[19];
        if (((Button) findViewById(R.id.air_xts_mode_body)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_body)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
        }
    }

    
    public void mUpdaterBlowFootLeftOn() {
        int value = DataCanbus.DATA[20];
        if (((Button) findViewById(R.id.air_xts_mode_foot)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_foot)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
        }
    }

    
    public void mUpdaterAirTempRight() {
        int unit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[28];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("NO");
                return;
            }
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                return;
            }
            if (DataCanbus.DATA[1000] == 118 || DataCanbus.DATA[1000] == 185 || DataCanbus.DATA[1000] == 65817 || DataCanbus.DATA[1000] == 281 || DataCanbus.DATA[1000] == 262425) {
                if (unit != 0) {
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 5) + "°F");
                    return;
                } else {
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText(((temp - 20) / 10.0f) + "°C");
                    return;
                }
            }
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 10.0f) + "°C");
        }
    }

    
    public void mUpdaterAirAutoOn() {
        int value = DataCanbus.DATA[13];
        if (((Button) findViewById(R.id.air_xts_auto)) != null) {
            ((Button) findViewById(R.id.air_xts_auto)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
        }
    }

    
    public void mUpdaterAirHybirdAc() {
        int value = DataCanbus.DATA[11];
        if (((Button) findViewById(R.id.air_xts_ac)) != null) {
            ((Button) findViewById(R.id.air_xts_ac)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    
    public void mUpdaterAirAcMax() {
        int value = DataCanbus.DATA[53];
        if (((Button) findViewById(R.id.air_xts_maxac)) != null) {
            ((Button) findViewById(R.id.air_xts_maxac)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_maxac_n : R.drawable.ic_xts_maxac_p);
        }
    }

    
    public void mUpdaterAirDual() {
        int value = DataCanbus.DATA[14];
        if (((Button) findViewById(R.id.air_xts_mono)) != null) {
            if (DataCanbus.DATA[1000] == 122 || DataCanbus.DATA[1000] == 185 || DataCanbus.DATA[1000] == 65817 || DataCanbus.DATA[1000] == 281 || DataCanbus.DATA[1000] == 262425) {
                ((Button) findViewById(R.id.air_xts_mono)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mono_n : R.drawable.ic_xts_mono_p);
            }
        }
    }

    
    public void mUpdaterAirMono() {
        int value = DataCanbus.DATA[55];
        if (((Button) findViewById(R.id.air_xts_mono)) != null && DataCanbus.DATA[1000] != 118 && DataCanbus.DATA[1000] != 185 && DataCanbus.DATA[1000] != 65817 && DataCanbus.DATA[1000] != 281 && DataCanbus.DATA[1000] != 262425) {
            ((Button) findViewById(R.id.air_xts_mono)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mono_n : R.drawable.ic_xts_mono_p);
        }
    }

    
    public void mUpdaterAirWindStrong() {
        int temp = DataCanbus.DATA[52];
        if (((Button) findViewById(R.id.air_xts_winlev)) != null) {
            if (temp == 1) {
                ((Button) findViewById(R.id.air_xts_winlev)).setBackgroundResource(R.drawable.ic_xts_winlev2);
            } else if (temp == 2) {
                ((Button) findViewById(R.id.air_xts_winlev)).setBackgroundResource(R.drawable.ic_xts_winlev3);
            } else {
                ((Button) findViewById(R.id.air_xts_winlev)).setBackgroundResource(R.drawable.ic_xts_winlev1);
            }
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        if (DataCanbus.DATA[1000] == 122) {
            DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        } else {
            DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        }
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        if (DataCanbus.DATA[1000] == 122) {
            DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        } else {
            DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        }
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
        AirHelper.disableAirWindowLocal(true);
        if (DataCanbus.DATA[1000] == 118 || DataCanbus.DATA[1000] == 185 || DataCanbus.DATA[1000] == 281 || DataCanbus.DATA[1000] == 262425 || DataCanbus.DATA[1000] == 65817) {
            DataCanbus.PROXY.cmd(53, new int[]{33}, null, null);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
        AirHelper.disableAirWindowLocal(false);
    }
}
