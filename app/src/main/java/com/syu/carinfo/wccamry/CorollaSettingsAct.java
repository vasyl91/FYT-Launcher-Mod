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

public class CorollaSettingsAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 102:
                    CorollaSettingsAct.this.mUpdaterInteriorLightOffTime();
                    break;
                case 106:
                    CorollaSettingsAct.this.mUpdaterAutoAc();
                    break;
                case 107:
                    CorollaSettingsAct.this.mUpdaterValidVentilation();
                    break;
                case 109:
                    CorollaSettingsAct.this.mUpdaterHeadLampsOnSensitivity();
                    break;
                case 124:
                    CorollaSettingsAct.this.mUpdaterKeySystemWithElecKey();
                    break;
                case 125:
                    CorollaSettingsAct.this.mUpdaterLockUnLockFeedbackByLights();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_corolla_settings);
        init();
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
    public void init() {
        ((CheckedTextView) findViewById(R.id.corolla_btn_system_key_with_ekey_enabled)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[124];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(17, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.corolla_btn_feedback_lamp)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[125];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(18, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.corolla_btn_auto_ac_enabled)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[106] == 0) {
                    DataCanbus.PROXY.cmd(9, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(9, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.corolla_btn_valid_ventilation_enabled)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[107] == 0) {
                    DataCanbus.PROXY.cmd(10, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(10, new int[1], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.corolla_btn_sens_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                //
            }
        });
        ((Button) findViewById(R.id.corolla_btn_sens_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[109];
                if (value2 < 4 && (value = value2 + 1) > -1 && value < 5) {
                    DataCanbus.PROXY.cmd(11, new int[]{value}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.corolla_btn_interior_lighting_off_time_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[102];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(12, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.corolla_btn_interior_lighting_off_time_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[102];
                if (value < 3) {
                    DataCanbus.PROXY.cmd(12, new int[]{value + 1}, null, null);
                }
            }
        });
    }

    @Override
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

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterKeySystemWithElecKey() {
        int value = DataCanbus.DATA[124];
        if (((CheckedTextView) findViewById(R.id.corolla_btn_system_key_with_ekey_enabled)) != null) {
            ((CheckedTextView) findViewById(R.id.corolla_btn_system_key_with_ekey_enabled)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterLockUnLockFeedbackByLights() {
        int value = DataCanbus.DATA[125];
        if (((CheckedTextView) findViewById(R.id.corolla_btn_feedback_lamp)) != null) {
            ((CheckedTextView) findViewById(R.id.corolla_btn_feedback_lamp)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterAutoAc() {
        int value = DataCanbus.DATA[106];
        if (((CheckedTextView) findViewById(R.id.corolla_btn_auto_ac_enabled)) != null) {
            ((CheckedTextView) findViewById(R.id.corolla_btn_auto_ac_enabled)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValidVentilation() {
        int value = DataCanbus.DATA[107];
        if (((CheckedTextView) findViewById(R.id.corolla_btn_valid_ventilation_enabled)) != null) {
            ((CheckedTextView) findViewById(R.id.corolla_btn_valid_ventilation_enabled)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterInteriorLightOffTime() {
        int value = DataCanbus.DATA[102];
        if (((TextView) findViewById(R.id.corolla_tv_interior_lighting_off_time)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.corolla_tv_interior_lighting_off_time)).setText(ConstWcToyota.mStrInteriorLightOffTime[value]);
        }
    }

    
    public void mUpdaterHeadLampsOnSensitivity() {
        int value = DataCanbus.DATA[109];
        if (((TextView) findViewById(R.id.corolla_tv_sens_cur)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.corolla_tv_sens_cur)).setBackgroundResource(Rav4Data.mSensDrawableId[value]);
        }
    }
}
