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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Wc_16Civic_SaftyActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.Wc_16Civic_SaftyActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 61:
                    Wc_16Civic_SaftyActi.this.m68D14();
                    break;
                case 62:
                    Wc_16Civic_SaftyActi.this.m68D13();
                    break;
                case 63:
                    Wc_16Civic_SaftyActi.this.m68D12();
                    break;
                case 64:
                    Wc_16Civic_SaftyActi.this.m68D10();
                    break;
                case 93:
                    Wc_16Civic_SaftyActi.this.m_lane_watch_light(val);
                    break;
                case 94:
                    Wc_16Civic_SaftyActi.this.m_lane_watche_durtion(val);
                    break;
                case 95:
                    Wc_16Civic_SaftyActi.this.m_rear_view_reminder(val);
                    break;
                case 96:
                    Wc_16Civic_SaftyActi.this.m_rise_warning(val);
                    break;
                case 97:
                    Wc_16Civic_SaftyActi.this.m_rise_driver(val);
                    break;
                case 98:
                    Wc_16Civic_SaftyActi.this.m_memory_position_seat(val);
                    break;
                case 99:
                    Wc_16Civic_SaftyActi.this.m_seat_belt_mode_set(val);
                    break;
                case 100:
                    Wc_16Civic_SaftyActi.this.m_switch_lock(val);
                    break;
                case 101:
                    Wc_16Civic_SaftyActi.this.m_laneoffset_show(val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_321_civic_safety);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_SaftyActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[93] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 12;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(110, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_SaftyActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[95] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 14;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(110, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_SaftyActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[96] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 8;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(105, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_SaftyActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[98] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 11;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_SaftyActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[99] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 12;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_SaftyActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[100] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 10;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_SaftyActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[97] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(105, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_SaftyActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[97];
                DataCanbus.PROXY.cmd(105, new int[]{7, (value + 1) % 3}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_SaftyActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[94];
                if (value2 == 0) {
                    value = 5;
                } else {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(110, new int[]{12, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_SaftyActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[94];
                if (value2 == 0) {
                    value = 5;
                } else {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(110, new int[]{12, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_SaftyActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[62] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 3;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(105, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_SaftyActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[63] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 2;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(105, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_SaftyActi.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[61] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(105, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_SaftyActi.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[61] & 255;
                if (value2 < 3) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(105, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_SaftyActi.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[64] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(105, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_SaftyActi.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[64] & 255;
                if (value2 < 3) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(105, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_SaftyActi.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[101] & 255) - 1;
                if (value < 1) {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(105, new int[]{9, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_SaftyActi.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[101] & 255) + 1;
                if (value > 4) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(105, new int[]{9, value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
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
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m_lane_watche_durtion(int val) {
        switch (val) {
            case 0:
                ((TextView) findViewById(R.id.tv_text9)).setText("0s");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text9)).setText("2s");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
    public void m_lane_watch_light(int val) {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(val == 1);
        if (val == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_right_camera_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m_rear_view_reminder(int val) {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(val == 1);
        if (val == 1) {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_right_camera_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m_rise_warning(int val) {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(val == 1);
        if (val == 1) {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_right_camera_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m_memory_position_seat(int val) {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(val == 1);
        if (val == 1) {
            ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_right_camera_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m_seat_belt_mode_set(int val) {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(val == 1);
        if (val == 1) {
            ((TextView) findViewById(R.id.tv_text7)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.tv_text7)).setText(R.string.str_right_camera_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m_switch_lock(int val) {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(val == 1);
        if (val == 1) {
            ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_right_camera_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m68D14() {
        int temp = DataCanbus.DATA[61] & 65535;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void m68D13() {
        int temp = DataCanbus.DATA[62] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn == 1);
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_right_camera_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m68D12() {
        int temp = DataCanbus.DATA[63] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn == 1);
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_right_camera_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m68D10() {
        int temp = DataCanbus.DATA[64] & 65535;
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
