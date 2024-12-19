package com.syu.carinfo.wccamry;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
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
public class CorollaSettingsAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wccamry.CorollaSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 4:
                    CorollaSettingsAct.this.mUpdaterInteriorLightOffTime();
                    break;
                case 8:
                    CorollaSettingsAct.this.mUpdaterAutoAc();
                    break;
                case 9:
                    CorollaSettingsAct.this.mUpdaterValidVentilation();
                    break;
                case 11:
                    CorollaSettingsAct.this.mUpdaterHeadLampsOnSensitivity();
                    break;
                case 26:
                    CorollaSettingsAct.this.mUpdaterKeySystemWithElecKey();
                    break;
                case 27:
                    CorollaSettingsAct.this.mUpdaterLockUnLockFeedbackByLights();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_corolla_settings);
        init();
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
    public void init() {
        ((CheckedTextView) findViewById(R.id.corolla_btn_system_key_with_ekey_enabled)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.CorollaSettingsAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[26];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(17, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.corolla_btn_feedback_lamp)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.CorollaSettingsAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[27];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(18, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.corolla_btn_auto_ac_enabled)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.CorollaSettingsAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[8] == 0) {
                    DataCanbus.PROXY.cmd(9, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(9, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.corolla_btn_valid_ventilation_enabled)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.CorollaSettingsAct.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[9] == 0) {
                    DataCanbus.PROXY.cmd(10, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(10, new int[1], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.corolla_btn_sens_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.CorollaSettingsAct.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = 0;
                int value2 = DataCanbus.DATA[11];
                if (value2 > 0 && value2 - 1 > -1 && value < 5) {
                    DataCanbus.PROXY.cmd(11, new int[]{value}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.corolla_btn_sens_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.CorollaSettingsAct.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[11];
                if (value2 < 4 && (value = value2 + 1) > -1 && value < 5) {
                    DataCanbus.PROXY.cmd(11, new int[]{value}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.corolla_btn_interior_lighting_off_time_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.CorollaSettingsAct.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[4];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(12, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.corolla_btn_interior_lighting_off_time_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.CorollaSettingsAct.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[4];
                if (value < 3) {
                    DataCanbus.PROXY.cmd(12, new int[]{value + 1}, null, null);
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            try {
                Intent intent = new Intent();
                intent.setClass(this, Rav4TripAct.class);
                startActivity(intent);
                finish();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
        return true;
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterKeySystemWithElecKey() {
        int value = DataCanbus.DATA[26];
        if (((CheckedTextView) findViewById(R.id.corolla_btn_system_key_with_ekey_enabled)) != null) {
            ((CheckedTextView) findViewById(R.id.corolla_btn_system_key_with_ekey_enabled)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLockUnLockFeedbackByLights() {
        int value = DataCanbus.DATA[27];
        if (((CheckedTextView) findViewById(R.id.corolla_btn_feedback_lamp)) != null) {
            ((CheckedTextView) findViewById(R.id.corolla_btn_feedback_lamp)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoAc() {
        int value = DataCanbus.DATA[8];
        if (((CheckedTextView) findViewById(R.id.corolla_btn_auto_ac_enabled)) != null) {
            ((CheckedTextView) findViewById(R.id.corolla_btn_auto_ac_enabled)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValidVentilation() {
        int value = DataCanbus.DATA[9];
        if (((CheckedTextView) findViewById(R.id.corolla_btn_valid_ventilation_enabled)) != null) {
            ((CheckedTextView) findViewById(R.id.corolla_btn_valid_ventilation_enabled)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterInteriorLightOffTime() {
        int value = DataCanbus.DATA[4];
        if (((TextView) findViewById(R.id.corolla_tv_interior_lighting_off_time)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.corolla_tv_interior_lighting_off_time)).setText(ConstWcToyota.mStrInteriorLightOffTime[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterHeadLampsOnSensitivity() {
        int value = DataCanbus.DATA[11];
        if (((TextView) findViewById(R.id.corolla_tv_sens_cur)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.corolla_tv_sens_cur)).setBackgroundResource(Rav4Data.mSensDrawableId[value]);
        }
    }
}
