package com.syu.carinfo.klc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class KlcCrashSetAct extends Activity implements View.OnClickListener {
    Button BtnParkNext;
    Button BtnParkPre;
    TextView TvAlertType;
    TextView TvHillstart;
    TextView TvParkSet;
    CheckedTextView mAlertTypeChecked;
    CheckedTextView mBlindZoneChecked;
    CheckedTextView mBtnHillstart;
    CheckedTextView mCarCruiseCheck;
    CheckedTextView mCarStateCheck;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.klc.KlcCrashSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 15:
                    KlcCrashSetAct.this.updateBoCheHelpSystemSet();
                    break;
                case 16:
                    KlcCrashSetAct.this.updateCeMangWarnSystemset();
                    break;
                case 17:
                    KlcCrashSetAct.this.updateFangzhuangWarnType();
                    break;
                case 18:
                    KlcCrashSetAct.this.updateBoCheSystemSetTuoKa();
                    break;
                case 19:
                    KlcCrashSetAct.this.update24GhzRadarSet();
                    break;
                case 66:
                    KlcCrashSetAct.this.updateAutoFangzhuang();
                    break;
                case 67:
                    KlcCrashSetAct.this.updateCarNotify();
                    break;
                case 111:
                    KlcCrashSetAct.this.updateCarSettingAssist();
                    break;
                case 112:
                    KlcCrashSetAct.this.updateCarCruiseControl();
                    break;
            }
        }
    };
    CheckedTextView mParkChecked;
    CheckedTextView mRaderChecked;
    View viewAlertType;
    View viewAutofangzhuang;
    Button viewAutofangzhuangNext;
    Button viewAutofangzhuangPre;
    TextView viewAutofangzhuangTV;
    View viewBlindZone;
    View viewCarCruise;
    View viewCarState;
    View viewHillstart;
    View viewPark;
    View viewParkTrailer;
    View viewRader;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_klc_crash_set);
        init();
        setUI();
    }

    private void init() {
        this.mParkChecked = (CheckedTextView) findViewById(R.id.klc_btn_Parking_check);
        this.mBlindZoneChecked = (CheckedTextView) findViewById(R.id.klc_btn_Side_blind_zone_alert_check);
        this.mRaderChecked = (CheckedTextView) findViewById(R.id.klc_btn_24GHz_radar_set_check);
        this.mAlertTypeChecked = (CheckedTextView) findViewById(R.id.klc_btn_Collision_Alert_Type_check);
        this.mCarStateCheck = (CheckedTextView) findViewById(R.id.wc_weilang_car_state_check);
        this.mCarCruiseCheck = (CheckedTextView) findViewById(R.id.wc_gm_cruise_check);
        this.mBtnHillstart = (CheckedTextView) findViewById(R.id.klc_btn_hillstart);
        this.TvAlertType = (TextView) findViewById(R.id.klc_Collision_Alert_Type_Tv);
        this.TvParkSet = (TextView) findViewById(R.id.klc_Parking_with_trailer_Tv);
        this.TvHillstart = (TextView) findViewById(R.id.klc_hillstart_Tv);
        this.viewAutofangzhuangTV = (TextView) findViewById(R.id.wc_weilang_auto_fangzhuang_preper_TV);
        this.BtnParkPre = (Button) findViewById(R.id.klc_Parking_with_trailer_btn_pre);
        this.BtnParkNext = (Button) findViewById(R.id.klc_Parking_with_trailer_btn_next);
        this.viewAutofangzhuangPre = (Button) findViewById(R.id.wc_weilang_auto_fangzhuang_preper_pre);
        this.viewAutofangzhuangNext = (Button) findViewById(R.id.wc_weilang_auto_fangzhuang_preper_next);
        this.viewPark = findViewById(R.id.klc_view_Parking);
        this.viewBlindZone = findViewById(R.id.klc_view_Side_blind_zone);
        this.viewAlertType = findViewById(R.id.klc_view_Collision_Alert_Type);
        this.viewRader = findViewById(R.id.klc_view_24GHz_radar_set);
        this.viewParkTrailer = findViewById(R.id.klc_view_Parking_with_trailer);
        this.viewAutofangzhuang = findViewById(R.id.wc_weilang_auto_fangzhuang_preper_view);
        this.viewCarState = findViewById(R.id.wc_weilang_car_state_view);
        this.viewCarCruise = findViewById(R.id.wc_gm_cruise_view);
        this.viewHillstart = findViewById(R.id.klc_view_hillstart);
    }

    private void setUI() {
        this.mParkChecked.setOnClickListener(this);
        this.mBlindZoneChecked.setOnClickListener(this);
        this.mRaderChecked.setOnClickListener(this);
        this.mAlertTypeChecked.setOnClickListener(this);
        this.BtnParkPre.setOnClickListener(this);
        this.BtnParkNext.setOnClickListener(this);
        this.viewAutofangzhuangPre.setOnClickListener(this);
        this.viewAutofangzhuangNext.setOnClickListener(this);
        this.mCarStateCheck.setOnClickListener(this);
        this.mCarCruiseCheck.setOnClickListener(this);
        this.mBtnHillstart.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.klc_btn_Parking_check /* 2131431891 */:
                int valPark = DataCanbus.DATA[15] & 255;
                KlcFunc.C_CAR_CRASH(1, valPark == 0 ? 1 : 0);
                break;
            case R.id.klc_btn_Side_blind_zone_alert_check /* 2131431893 */:
                int valBlind = DataCanbus.DATA[16] & 255;
                KlcFunc.C_CAR_CRASH(2, valBlind == 0 ? 1 : 0);
                break;
            case R.id.klc_btn_Collision_Alert_Type_check /* 2131431895 */:
                int valAlertType = DataCanbus.DATA[17] & 255;
                KlcFunc.C_CAR_CRASH(4, valAlertType == 0 ? 1 : 0);
                break;
            case R.id.klc_Parking_with_trailer_btn_pre /* 2131431898 */:
                int valParkTrailerPre = DataCanbus.DATA[18] & 255;
                if (valParkTrailerPre == 0) {
                    KlcFunc.C_CAR_CRASH(3, 2);
                    break;
                } else if (valParkTrailerPre == 1) {
                    KlcFunc.C_CAR_CRASH(3, 0);
                    break;
                } else if (valParkTrailerPre == 2) {
                    KlcFunc.C_CAR_CRASH(3, 1);
                    break;
                }
            case R.id.klc_Parking_with_trailer_btn_next /* 2131431900 */:
                int valParkTrailerNext = DataCanbus.DATA[18] & 255;
                if (valParkTrailerNext == 0) {
                    KlcFunc.C_CAR_CRASH(3, 1);
                    break;
                } else if (valParkTrailerNext == 1) {
                    KlcFunc.C_CAR_CRASH(3, 2);
                    break;
                } else if (valParkTrailerNext == 2) {
                    KlcFunc.C_CAR_CRASH(3, 0);
                    break;
                }
            case R.id.klc_btn_24GHz_radar_set_check /* 2131431902 */:
                int valRader = DataCanbus.DATA[19] & 255;
                KlcFunc.C_CAR_CRASH(5, valRader == 0 ? 1 : 0);
                break;
            case R.id.wc_weilang_auto_fangzhuang_preper_pre /* 2131431904 */:
                int valuepre = DataCanbus.DATA[66] & 255;
                if (valuepre == 0) {
                    KlcFunc.C_CAR_CRASH(6, 2);
                    break;
                } else if (valuepre == 1) {
                    KlcFunc.C_CAR_CRASH(6, 0);
                    break;
                } else if (valuepre == 2) {
                    KlcFunc.C_CAR_CRASH(6, 1);
                    break;
                }
            case R.id.wc_weilang_auto_fangzhuang_preper_next /* 2131431906 */:
                int valueNext = DataCanbus.DATA[66] & 255;
                if (valueNext == 0) {
                    KlcFunc.C_CAR_CRASH(6, 1);
                    break;
                } else if (valueNext == 1) {
                    KlcFunc.C_CAR_CRASH(6, 2);
                    break;
                } else if (valueNext == 2) {
                    KlcFunc.C_CAR_CRASH(6, 0);
                    break;
                }
            case R.id.wc_weilang_car_state_check /* 2131431908 */:
                int value = DataCanbus.DATA[67] & 255;
                KlcFunc.C_CAR_CRASH(7, value == 0 ? 1 : 0);
                break;
            case R.id.wc_gm_cruise_check /* 2131431910 */:
                int value1 = DataCanbus.DATA[112] & 255;
                KlcFunc.C_CAR_CRASH(9, value1 == 0 ? 1 : 0);
                break;
            case R.id.klc_btn_hillstart /* 2131431912 */:
                int value12 = DataCanbus.DATA[111] & 255;
                KlcFunc.C_CAR_CRASH(8, value12 == 0 ? 1 : 0);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        findViewById(R.id.wc_weilang_auto_fangzhuang_preper_view).setVisibility(0);
        findViewById(R.id.wc_weilang_car_state_view).setVisibility(0);
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBoCheHelpSystemSet() {
        int val = DataCanbus.DATA[15];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (DataCanbus.DATA[1000] == 254) {
            this.mParkChecked.setChecked(switchOn != 0);
            return;
        }
        if (enable == 0) {
            this.viewPark.setVisibility(8);
        } else if (enable == 1) {
            this.viewPark.setVisibility(0);
            this.mParkChecked.setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBoCheSystemSetTuoKa() {
        int val = DataCanbus.DATA[18];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            this.viewParkTrailer.setVisibility(8);
            return;
        }
        if (enable == 1) {
            this.viewParkTrailer.setVisibility(0);
            if (switchOn == 0) {
                this.TvParkSet.setText(R.string.klc_Parking_with_trailer_Off);
            } else if (switchOn == 1) {
                this.TvParkSet.setText(R.string.klc_Parking_with_trailer_ON);
            } else if (switchOn == 2) {
                this.TvParkSet.setText(R.string.klc_Parking_with_trailer_Trailer);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCeMangWarnSystemset() {
        int val = DataCanbus.DATA[16];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            this.viewBlindZone.setVisibility(8);
        } else if (enable == 1) {
            this.viewBlindZone.setVisibility(0);
            this.mBlindZoneChecked.setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFangzhuangWarnType() {
        int val = DataCanbus.DATA[17];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            this.viewAlertType.setVisibility(8);
            return;
        }
        if (enable == 1) {
            this.viewAlertType.setVisibility(0);
            this.mAlertTypeChecked.setChecked(switchOn != 0);
            if (switchOn == 0) {
                this.TvAlertType.setText(R.string.klc_Collision_Alert_Type_Chime_alarm);
            } else if (switchOn == 1) {
                this.TvAlertType.setText(R.string.klc_Collision_Alert_Type_Seat_alarm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update24GhzRadarSet() {
        int val = DataCanbus.DATA[19];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            this.viewRader.setVisibility(8);
        } else if (enable == 1) {
            this.viewRader.setVisibility(0);
            this.mRaderChecked.setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoFangzhuang() {
        int val = DataCanbus.DATA[66];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            this.viewAutofangzhuang.setVisibility(8);
            return;
        }
        if (enable == 1) {
            this.viewAutofangzhuang.setVisibility(0);
            if (switchOn == 0) {
                this.viewAutofangzhuangTV.setText(R.string.off);
            } else if (switchOn == 1) {
                this.viewAutofangzhuangTV.setText(R.string.wc_weilang_auto_fangzhuang_warn);
            } else if (switchOn == 2) {
                this.viewAutofangzhuangTV.setText(R.string.wc_weilang_auto_fangzhuang_warn_and_zhidong);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarNotify() {
        int val = DataCanbus.DATA[67];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            this.viewCarState.setVisibility(8);
        } else if (enable == 1) {
            this.viewCarState.setVisibility(0);
            this.mCarStateCheck.setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarCruiseControl() {
        int val = DataCanbus.DATA[112];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            this.viewCarCruise.setVisibility(8);
        } else if (enable == 1) {
            this.viewCarCruise.setVisibility(0);
            this.mCarCruiseCheck.setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarSettingAssist() {
        int val = DataCanbus.DATA[111];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            this.viewHillstart.setVisibility(8);
            return;
        }
        if (enable == 1) {
            this.viewHillstart.setVisibility(0);
            this.mBtnHillstart.setChecked(switchOn != 0);
            if (switchOn == 0) {
                this.TvHillstart.setText(R.string.str_stand_parking);
            } else if (switchOn == 1) {
                this.TvHillstart.setText(R.string.str_incre_parking);
            }
        }
    }
}
