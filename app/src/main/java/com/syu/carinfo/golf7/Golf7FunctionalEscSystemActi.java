package com.syu.carinfo.golf7;

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
public class Golf7FunctionalEscSystemActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 46:
                    Golf7FunctionalEscSystemActi.this.mUpdaterInstrument();
                    break;
                case 65:
                    Golf7FunctionalEscSystemActi.this.mUpdaterEscSystem();
                    break;
                case 83:
                    Golf7FunctionalEscSystemActi.this.mUpdaterDistance();
                    break;
                case 107:
                    Golf7FunctionalEscSystemActi.this.mUpdaterAir();
                    break;
                case 396:
                    Golf7FunctionalEscSystemActi.this.setCheck((CheckedTextView) Golf7FunctionalEscSystemActi.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_functional_state_esc_system);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[396] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 17;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(160, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_esc_system_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[65] & 255;
                if (switchOn == 2) {
                    DataCanbus.PROXY.cmd(86, new int[]{1}, null, null);
                } else if (switchOn == 1) {
                    DataCanbus.PROXY.cmd(86, new int[1], null, null);
                } else {
                    DataCanbus.PROXY.cmd(86, new int[]{2}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.glf7_btn_esc_system_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[65] & 255;
                if (switchOn == 0) {
                    DataCanbus.PROXY.cmd(86, new int[]{1}, null, null);
                } else if (switchOn == 1) {
                    DataCanbus.PROXY.cmd(86, new int[]{2}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(86, new int[1], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.glf7_btn_air_con_profile_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[107] & 255;
                if (switchOn == 2) {
                    DataCanbus.PROXY.cmd(101, new int[]{1}, null, null);
                } else if (switchOn == 1) {
                    DataCanbus.PROXY.cmd(101, new int[1], null, null);
                } else {
                    DataCanbus.PROXY.cmd(101, new int[]{2}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.glf7_btn_air_con_profile_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[107] & 255;
                if (switchOn == 0) {
                    DataCanbus.PROXY.cmd(101, new int[]{1}, null, null);
                } else if (switchOn == 1) {
                    DataCanbus.PROXY.cmd(101, new int[]{2}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(101, new int[]{3}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.lindu_btn_functional_light_instrument_switch_lighting_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[46] & 255) - 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(62, new int[]{switchOn}, null, null);
            }
        });
        ((Button) findViewById(R.id.lindu_btn_functional_light_instrument_switch_lighting_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[46] & 255) + 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(62, new int[]{switchOn}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_functional_unit_distance_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[83] & 255;
                if (DataCanbus.DATA[1000] == 270) {
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value == 0 ? 0 : 1;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.glf7_btn_functional_unit_distance_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[83] & 255;
                if (DataCanbus.DATA[1000] == 270) {
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value == 0 ? 0 : 1;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] == 279) {
            setViewVisible(findViewById(R.id.glf7_view_air_con_profile), true);
            setViewVisible(findViewById(R.id.lindu_view_functional_light_instrument_switch_lighting), true);
            setViewVisible(findViewById(R.id.glf7_view_functional_unit_distance), false);
        } else {
            if (DataCanbus.DATA[1000] == 270) {
                setViewVisible(findViewById(R.id.glf7_view_functional_unit_distance), true);
            } else {
                setViewVisible(findViewById(R.id.glf7_view_functional_unit_distance), false);
            }
            setViewVisible(findViewById(R.id.glf7_view_air_con_profile), false);
            setViewVisible(findViewById(R.id.lindu_view_functional_light_instrument_switch_lighting), false);
        }
        if (ConstGolf.isRZCGolf()) {
            setViewVisible(findViewById(R.id.layout_view1), true);
        } else {
            setViewVisible(findViewById(R.id.layout_view1), false);
        }
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[83].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[396].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[83].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[396].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterEscSystem() {
        int value = DataCanbus.DATA[65];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            if (enable == 0) {
                setViewVisible(findViewById(R.id.glf7_view_functional_esc_system), false);
                return;
            }
            if (switchOn == 2) {
                ((TextView) findViewById(R.id.glf7_tv_esc_system_minus)).setText(R.string.Eesc_sport);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.glf7_tv_esc_system_minus)).setText(R.string.ESC_act);
            } else {
                ((TextView) findViewById(R.id.glf7_tv_esc_system_minus)).setText(R.string.ESC_asr);
            }
            setViewVisible(findViewById(R.id.glf7_view_functional_esc_system), true);
            return;
        }
        if (switchOn == 2) {
            ((TextView) findViewById(R.id.glf7_tv_esc_system_minus)).setText(R.string.Eesc_sport);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.glf7_tv_esc_system_minus)).setText(R.string.ESC_act);
        } else {
            ((TextView) findViewById(R.id.glf7_tv_esc_system_minus)).setText(R.string.ESC_asr);
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_esc_system), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAir() {
        int value = DataCanbus.DATA[107];
        if (((TextView) findViewById(R.id.glf7_tv_air_con_profile_minus)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.glf7_tv_air_con_profile_minus)).setText(R.string.lingdu_air_con_profile_2);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.glf7_tv_air_con_profile_minus)).setText(R.string.lingdu_air_con_profile_1);
            } else {
                ((TextView) findViewById(R.id.glf7_tv_air_con_profile_minus)).setText(R.string.lingdu_air_con_profile_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterInstrument() {
        int value = DataCanbus.DATA[46];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.lindu_view_functional_light_instrument_switch_lighting), enable != 0);
            if (switchOn > -1 && switchOn < 101) {
                if (switchOn == 0) {
                    ((TextView) findViewById(R.id.lindu_tv_functional_light_instrument_switch_lighting)).setText(R.string.least);
                    return;
                } else {
                    ((TextView) findViewById(R.id.lindu_tv_functional_light_instrument_switch_lighting)).setText(String.valueOf(switchOn) + "%");
                    return;
                }
            }
            return;
        }
        if (DataCanbus.DATA[1000] != 437) {
            setViewVisible(findViewById(R.id.lindu_view_functional_light_instrument_switch_lighting), true);
            if (value > -1 && value < 101) {
                if (value == 0) {
                    ((TextView) findViewById(R.id.lindu_tv_functional_light_instrument_switch_lighting)).setText(R.string.least);
                } else {
                    ((TextView) findViewById(R.id.lindu_tv_functional_light_instrument_switch_lighting)).setText(String.valueOf(value) + "%");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDistance() {
        int value = DataCanbus.DATA[83];
        if (DataCanbus.DATA[1000] == 270) {
            setViewVisible(findViewById(R.id.glf7_view_functional_unit_distance), true);
            if (value == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_unit_distance)).setText(Golf7Data.mDistanceUnitXp[1]);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.glf7_tv_functional_unit_distance)).setText(Golf7Data.mDistanceUnitXp[0]);
            }
        }
    }
}