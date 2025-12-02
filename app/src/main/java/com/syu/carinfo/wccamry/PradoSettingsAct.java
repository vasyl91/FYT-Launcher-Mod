package com.syu.carinfo.wccamry;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckedTextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class PradoSettingsAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 4:
                    PradoSettingsAct.this.mUpdaterInteriorLightOffTime();
                    break;
                case 5:
                    PradoSettingsAct.this.mUpdaterAutolockBySpeed();
                    break;
                case 6:
                    PradoSettingsAct.this.mUpdaterAutolockByShiftFromP();
                    break;
                case 7:
                    PradoSettingsAct.this.mUpdaterAutoUnlockByShiftToP();
                    break;
                case 8:
                    PradoSettingsAct.this.mUpdaterAutoAc();
                    break;
                case 9:
                    PradoSettingsAct.this.mUpdaterValidVentilation();
                    break;
                case 10:
                    PradoSettingsAct.this.mUpdaterRemote2PressUnlock();
                    break;
                case 11:
                    PradoSettingsAct.this.mUpdaterHeadLampsOnSensitivity();
                    break;
                case 12:
                    PradoSettingsAct.this.m2TimesKeyUnLock();
                    break;
                case 13:
                    PradoSettingsAct.this.mUpdaterUnLockByDriversDoorOpen();
                    break;
                case 14:
                    PradoSettingsAct.this.mUpdaterLockUnLockFeedbackByLights();
                    break;
                case 15:
                    PradoSettingsAct.this.mUpdaterKeySystemWithElecKey();
                    break;
                case 16:
                    PradoSettingsAct.this.mUpdaterSmartLockAndOneKeyBoot();
                    break;
                case 21:
                    PradoSettingsAct.this.mUpdaterRadarSwitch();
                    break;
                case 22:
                    PradoSettingsAct.this.mUpdaterRadarAlarmVol();
                    break;
                case 24:
                    PradoSettingsAct.this.mUpdaterRadarfrontRange();
                    break;
                case 25:
                    PradoSettingsAct.this.mUpdaterRadarrearRange();
                    break;
                case 28:
                    PradoSettingsAct.this.mUpdaterDsplinkspeed();
                    break;
                case 29:
                    PradoSettingsAct.this.mUpdaterDspsurround();
                    break;
                case 33:
                    PradoSettingsAct.this.mUpdaterOutLightOffTime();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_18pardo_settings);
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
        ((CheckedTextView) findViewById(R.id.pardo_btn_vol_link_speed)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[28] == 0) {
                    DataCanbus.PROXY.cmd(19, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(19, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.pardo_btn_surround)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[29] == 0) {
                    DataCanbus.PROXY.cmd(20, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(20, new int[1], null, null);
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
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterDsplinkspeed() {
        int value = DataCanbus.DATA[28];
        if (((CheckedTextView) findViewById(R.id.pardo_btn_vol_link_speed)) != null) {
            ((CheckedTextView) findViewById(R.id.pardo_btn_vol_link_speed)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterDspsurround() {
        int value = DataCanbus.DATA[29];
        if (((CheckedTextView) findViewById(R.id.pardo_btn_surround)) != null) {
            ((CheckedTextView) findViewById(R.id.pardo_btn_surround)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterAutolockBySpeed() {
        int value = DataCanbus.DATA[5];
    }

    
    public void mUpdaterKeySystemWithElecKey() {
        int value = DataCanbus.DATA[15];
    }

    
    public void mUpdaterUnLockByDriversDoorOpen() {
        int value = DataCanbus.DATA[13];
    }

    
    public void mUpdaterAutoUnlockByShiftToP() {
        int value = DataCanbus.DATA[7];
    }

    
    public void mUpdaterAutolockByShiftFromP() {
        int value = DataCanbus.DATA[6];
    }

    
    public void mUpdaterLockUnLockFeedbackByLights() {
        int value = DataCanbus.DATA[14];
    }

    
    public void mUpdaterRemote2PressUnlock() {
        int value = DataCanbus.DATA[10];
    }

    
    public void mUpdaterSmartLockAndOneKeyBoot() {
        int value = DataCanbus.DATA[16];
    }

    
    public void m2TimesKeyUnLock() {
        int value = DataCanbus.DATA[12];
    }

    
    public void mUpdaterAutoAc() {
        int value = DataCanbus.DATA[8];
    }

    
    public void mUpdaterValidVentilation() {
        int value = DataCanbus.DATA[9];
    }

    
    public void mUpdaterInteriorLightOffTime() {
        int value = DataCanbus.DATA[4];
    }

    
    public void mUpdaterOutLightOffTime() {
        int value = DataCanbus.DATA[33];
    }

    
    public void mUpdaterHeadLampsOnSensitivity() {
        int value = DataCanbus.DATA[11];
    }

    
    public void mUpdaterRadarSwitch() {
        int value = DataCanbus.DATA[21];
    }

    
    public void mUpdaterRadarAlarmVol() {
        int value = DataCanbus.DATA[22];
    }

    
    public void mUpdaterRadarfrontRange() {
        int mFrontRamge = DataCanbus.DATA[24];
    }

    
    public void mUpdaterRadarrearRange() {
        int mRearRamge = DataCanbus.DATA[25];
    }
}
