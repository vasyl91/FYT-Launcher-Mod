package com.syu.carinfo.xfy.guandao;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.accord9.wc.AccordConfig;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class GuandaoSetting2Act extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 101:
                    GuandaoSetting2Act.this.mD0B04();
                    break;
                case 118:
                    GuandaoSetting2Act.this.mD0B02();
                    break;
                case 119:
                    GuandaoSetting2Act.this.mD0B00();
                    break;
                case 120:
                    GuandaoSetting2Act.this.mD5B06();
                    break;
                case 121:
                    GuandaoSetting2Act.this.mD5B05();
                    break;
                case 122:
                    GuandaoSetting2Act.this.mD5B04();
                    break;
                case 123:
                    GuandaoSetting2Act.this.mD5B03();
                    break;
                case 124:
                    GuandaoSetting2Act.this.mD5B02();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_425_guandao_settingse);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.wc_321_civic_speed)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[123] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 23;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_321_civic_message)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[124] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 24;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_321_save)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[122] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 22;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_321_civic_back)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[121] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 21;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_321_civic_warnvol_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[120] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{20, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_321_civic_warnvol_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[120] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{20, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_321_b_switch_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[119] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_321_b_switch_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[119] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_321_a_switch_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[118] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_321_a_switch_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[118] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_321_temp_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[101] - 1;
                if (value < 0) {
                    value = 10;
                } else if (value > 10) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{0, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_321_temp_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[101] + 1;
                if (value < 0) {
                    value = 10;
                } else if (value > 10) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{0, value}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
    }

    
    public void mD5B03() {
        int temp = DataCanbus.DATA[123] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.wc_321_civic_speed)).setChecked(switchOn == 1);
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.wc_321_civic_speed_state)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.wc_321_civic_speed_state)).setText(R.string.str_right_camera_close);
        }
    }

    
    public void mD5B02() {
        int temp = DataCanbus.DATA[124] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.wc_321_civic_message)).setChecked(switchOn == 1);
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.wc_321_civic_message_state)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.wc_321_civic_message_state)).setText(R.string.str_right_camera_close);
        }
    }

    
    public void mD5B04() {
        int temp = DataCanbus.DATA[122] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.wc_321_save)).setChecked(switchOn == 1);
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.wc_321_save_state)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.wc_321_save_state)).setText(R.string.str_right_camera_close);
        }
    }

    
    public void mD5B05() {
        int temp = DataCanbus.DATA[121] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.wc_321_civic_back)).setChecked(switchOn == 1);
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.wc_321_civic_back_state)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.wc_321_civic_back_state)).setText(R.string.str_right_camera_close);
        }
    }

    
    public void mD5B06() {
        int temp = DataCanbus.DATA[120] & 65535;
        int switchOn = temp & 255;
        if (((TextView) findViewById(R.id.wc_321_civic_warnvol_set_show)) != null) {
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.wc_321_civic_warnvol_set_show)).setText(R.string.xp_accord9_auto_light_1lower);
                return;
            }
            if (switchOn == 1) {
                ((TextView) findViewById(R.id.wc_321_civic_warnvol_set_show)).setText(R.string.xp_accord9_auto_light_2middle);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.wc_321_civic_warnvol_set_show)).setText(R.string.xp_accord9_auto_light_3higher);
            } else {
                ((TextView) findViewById(R.id.wc_321_civic_warnvol_set_show)).setText(R.string.jeep_playstate11);
            }
        }
    }

    
    public void mD0B00() {
        int temp = DataCanbus.DATA[119] & 65535;
        int switchOn = temp & 255;
        if (((TextView) findViewById(R.id.wc_321_b_switch_set_show)) != null) {
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.wc_321_b_switch_set_show)).setText(R.string.xp_accord9_with_refuel);
                return;
            }
            if (switchOn == 1) {
                ((TextView) findViewById(R.id.wc_321_b_switch_set_show)).setText(R.string.xp_accord9_ign_off);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.wc_321_b_switch_set_show)).setText(R.string.klc_air_Manual);
            } else {
                ((TextView) findViewById(R.id.wc_321_b_switch_set_show)).setText(R.string.jeep_playstate11);
            }
        }
    }

    
    public void mD0B02() {
        int temp = DataCanbus.DATA[118] & 65535;
        int switchOn = temp & 255;
        if (((TextView) findViewById(R.id.wc_321_a_switch_set_show)) != null) {
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.wc_321_a_switch_set_show)).setText(R.string.xp_accord9_with_refuel);
                return;
            }
            if (switchOn == 1) {
                ((TextView) findViewById(R.id.wc_321_a_switch_set_show)).setText(R.string.xp_accord9_ign_off);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.wc_321_a_switch_set_show)).setText(R.string.klc_air_Manual);
            } else {
                ((TextView) findViewById(R.id.wc_321_a_switch_set_show)).setText(R.string.jeep_playstate11);
            }
        }
    }

    
    public void mD0B04() {
        int temp = DataCanbus.DATA[101];
        int switchOn = temp & 255;
        if (((TextView) findViewById(R.id.wc_321_temp_set_show)) != null && switchOn >= 0 && switchOn < 11) {
            ((TextView) findViewById(R.id.wc_321_temp_set_show)).setText(AccordConfig.mStrOutSideTemp[switchOn]);
        }
    }
}
