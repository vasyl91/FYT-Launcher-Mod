package com.syu.carinfo.xbs.tule;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XBSTuleSettingDZSJ extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    int val = 0;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.tule.XBSTuleSettingDZSJ.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            XBSTuleSettingDZSJ.this.val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 31:
                    XBSTuleSettingDZSJ.this.updateCarParkSensor();
                    break;
                case 32:
                    XBSTuleSettingDZSJ.this.updateCarCornerSensor();
                    break;
                case 33:
                    XBSTuleSettingDZSJ.this.updateCarCentreSensor();
                    break;
                case 34:
                    XBSTuleSettingDZSJ.this.updateInterLight();
                    break;
                case 35:
                    XBSTuleSettingDZSJ.this.updateSpeedWiper();
                    break;
                case 36:
                    XBSTuleSettingDZSJ.this.updateDoorUnlock();
                    break;
                case 37:
                    XBSTuleSettingDZSJ.this.updateKeyUnlock();
                    break;
                case 38:
                    XBSTuleSettingDZSJ.this.updateLightSensor();
                    break;
                case 39:
                    XBSTuleSettingDZSJ.this.updateLightOffDelay();
                    break;
                case 50:
                    XBSTuleSettingDZSJ.this.updateSenar();
                    break;
                case 51:
                    XBSTuleSettingDZSJ.this.updateFRSenar();
                    break;
                case 52:
                    XBSTuleSettingDZSJ.this.updateInterruptDisplay();
                    break;
                case 53:
                    XBSTuleSettingDZSJ.this.updateSenarSensitivity();
                    break;
                case 54:
                    XBSTuleSettingDZSJ.this.updateSenarVolume();
                    break;
                case 55:
                    XBSTuleSettingDZSJ.this.updateDistanceAssit();
                    break;
                case 56:
                    XBSTuleSettingDZSJ.this.updateRoadAway();
                    break;
                case 57:
                    XBSTuleSettingDZSJ.this.updateBlindSpot();
                    break;
                case 58:
                    XBSTuleSettingDZSJ.this.updateCollisionWarn();
                    break;
                case 59:
                    XBSTuleSettingDZSJ.this.updateRoadAwatWarn();
                    break;
                case 60:
                    XBSTuleSettingDZSJ.this.updateBlindSpotWarn();
                    break;
                case 61:
                    XBSTuleSettingDZSJ.this.updateRearViewLeft();
                    break;
                case 62:
                    XBSTuleSettingDZSJ.this.updateRearViewRight();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_xbstule_settings_dzsj);
        setListener();
    }

    private void setListener() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_xbs_tule_parking_sensor), this);
        setSelfClick((Button) findViewById(R.id.xbs_tule_btn_cornersensor_minus), this);
        setSelfClick((Button) findViewById(R.id.xbs_tule_btn_cornersensor_plus), this);
        setSelfClick((CheckedTextView) findViewById(R.id.id_reset), this);
        setSelfClick((Button) findViewById(R.id.xbs_tule_btn_centresensor_minus), this);
        setSelfClick((Button) findViewById(R.id.xbs_tule_btn_centresensor_plus), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_xbs_tule_interior_illumination), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_xbs_tule_wipersensor_speed), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_xbs_tule_selective_door_unlock), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_xbs_tule_intelligent_key_lock), this);
        setSelfClick((Button) findViewById(R.id.xbs_tule_btn_lightsensitivity_minus), this);
        setSelfClick((Button) findViewById(R.id.xbs_tule_btn_lightsensitivity_plus), this);
        setSelfClick((Button) findViewById(R.id.xbs_tule_btn_lightoffdelay_minus), this);
        setSelfClick((Button) findViewById(R.id.xbs_tule_btn_lightoffdelay_plus), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_xbs_tule_sonar_onoff), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_xbs_tule_frsonar_onoff), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_xbs_tule_interruptdisplay_onoff), this);
        setSelfClick((Button) findViewById(R.id.xbs_tule_btn_sonarsensitivity_minus), this);
        setSelfClick((Button) findViewById(R.id.xbs_tule_btn_sonarsensitivity_plus), this);
        setSelfClick((Button) findViewById(R.id.xbs_tule_btn_sonarvolume_minus), this);
        setSelfClick((Button) findViewById(R.id.xbs_tule_btn_sonarvolume_plus), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_xbs_tule_blind_spot_warning_onoff), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_xbs_tule_distance_control_assit_onoff), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_xbs_tule_lane_departure_prevention_onoff), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_xbs_tule_blind_spot_intervention_onoff), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_xbs_tule_forward_collision_warning_onoff), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_xbs_tule_lane_departure_warning_onoff), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_xbs_tule_left_headrest_onoff), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_xbs_tule_right_headrest_onoff), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_reset /* 2131427580 */:
                setCarInfo(53, 9);
                break;
            case R.id.ctv_xbs_tule_parking_sensor /* 2131428475 */:
                setCarInfo(52, 1);
                break;
            case R.id.xbs_tule_btn_cornersensor_minus /* 2131428476 */:
                setCarInfo(52, 2);
                break;
            case R.id.xbs_tule_btn_cornersensor_plus /* 2131428478 */:
                setCarInfo(52, 3);
                break;
            case R.id.xbs_tule_btn_centresensor_minus /* 2131428479 */:
                setCarInfo(52, 4);
                break;
            case R.id.xbs_tule_btn_centresensor_plus /* 2131428481 */:
                setCarInfo(52, 5);
                break;
            case R.id.ctv_xbs_tule_interior_illumination /* 2131428482 */:
                setCarInfo(53, 1);
                break;
            case R.id.ctv_xbs_tule_wipersensor_speed /* 2131428483 */:
                setCarInfo(53, 6);
                break;
            case R.id.ctv_xbs_tule_selective_door_unlock /* 2131428484 */:
                setCarInfo(53, 7);
                break;
            case R.id.ctv_xbs_tule_intelligent_key_lock /* 2131428485 */:
                setCarInfo(53, 8);
                break;
            case R.id.xbs_tule_btn_lightsensitivity_minus /* 2131428486 */:
                setCarInfo(53, 2);
                break;
            case R.id.xbs_tule_btn_lightsensitivity_plus /* 2131428488 */:
                setCarInfo(53, 3);
                break;
            case R.id.xbs_tule_btn_lightoffdelay_minus /* 2131428489 */:
                setCarInfo(53, 4);
                break;
            case R.id.xbs_tule_btn_lightoffdelay_plus /* 2131428491 */:
                setCarInfo(53, 5);
                break;
            case R.id.ctv_xbs_tule_sonar_onoff /* 2131428492 */:
                setCarInfo(54, 1);
                break;
            case R.id.ctv_xbs_tule_frsonar_onoff /* 2131428493 */:
                setCarInfo(54, 2);
                break;
            case R.id.ctv_xbs_tule_interruptdisplay_onoff /* 2131428494 */:
                setCarInfo(54, 3);
                break;
            case R.id.xbs_tule_btn_sonarsensitivity_minus /* 2131428495 */:
                setCarInfo(54, 4);
                break;
            case R.id.xbs_tule_btn_sonarsensitivity_plus /* 2131428497 */:
                setCarInfo(54, 5);
                break;
            case R.id.xbs_tule_btn_sonarvolume_minus /* 2131428498 */:
                setCarInfo(54, 6);
                break;
            case R.id.xbs_tule_btn_sonarvolume_plus /* 2131428500 */:
                setCarInfo(54, 7);
                break;
            case R.id.ctv_xbs_tule_distance_control_assit_onoff /* 2131428501 */:
                setCarInfo(55, 1);
                break;
            case R.id.ctv_xbs_tule_lane_departure_prevention_onoff /* 2131428502 */:
                setCarInfo(55, 2);
                break;
            case R.id.ctv_xbs_tule_blind_spot_intervention_onoff /* 2131428503 */:
                setCarInfo(55, 3);
                break;
            case R.id.ctv_xbs_tule_forward_collision_warning_onoff /* 2131428504 */:
                setCarInfo(55, 4);
                break;
            case R.id.ctv_xbs_tule_lane_departure_warning_onoff /* 2131428505 */:
                setCarInfo(55, 5);
                break;
            case R.id.ctv_xbs_tule_blind_spot_warning_onoff /* 2131428506 */:
                setCarInfo(55, 6);
                break;
            case R.id.ctv_xbs_tule_left_headrest_onoff /* 2131428507 */:
                setCarInfo(56, 1);
                break;
            case R.id.ctv_xbs_tule_right_headrest_onoff /* 2131428508 */:
                setCarInfo(56, 2);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRearViewRight() {
        int value = DataCanbus.DATA[62];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_right_headrest_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_right_headrest_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRearViewLeft() {
        int value = DataCanbus.DATA[61];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_left_headrest_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_left_headrest_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlindSpotWarn() {
        int value = DataCanbus.DATA[60];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_blind_spot_warning_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_blind_spot_warning_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRoadAwatWarn() {
        int value = DataCanbus.DATA[59];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_lane_departure_warning_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_lane_departure_warning_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCollisionWarn() {
        int value = DataCanbus.DATA[58];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_forward_collision_warning_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_forward_collision_warning_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlindSpot() {
        int value = DataCanbus.DATA[57];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_blind_spot_intervention_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_blind_spot_intervention_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRoadAway() {
        int value = DataCanbus.DATA[56];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_lane_departure_prevention_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_lane_departure_prevention_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDistanceAssit() {
        int value = DataCanbus.DATA[55];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_distance_control_assit_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_distance_control_assit_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSenarVolume() {
        int value = DataCanbus.DATA[54];
        if (((TextView) findViewById(R.id.tv_xbs_tule_sonarvolume_value)) != null) {
            ((TextView) findViewById(R.id.tv_xbs_tule_sonarvolume_value)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSenarSensitivity() {
        int value = DataCanbus.DATA[53];
        if (((TextView) findViewById(R.id.tv_xbs_tule_sonarsensitivity_value)) != null) {
            ((TextView) findViewById(R.id.tv_xbs_tule_sonarsensitivity_value)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInterruptDisplay() {
        int value = DataCanbus.DATA[52];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_interruptdisplay_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_interruptdisplay_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFRSenar() {
        int value = DataCanbus.DATA[51];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_frsonar_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_frsonar_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSenar() {
        int value = DataCanbus.DATA[50];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_sonar_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_sonar_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLightOffDelay() {
        int value = DataCanbus.DATA[39];
        if (((TextView) findViewById(R.id.tv_xbs_tule_lightoffdelay_value)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_xbs_tule_lightoffdelay_value)).setText("0s");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_xbs_tule_lightoffdelay_value)).setText("15s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_xbs_tule_lightoffdelay_value)).setText("30s");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_xbs_tule_lightoffdelay_value)).setText("45s");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_xbs_tule_lightoffdelay_value)).setText("60s");
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_xbs_tule_lightoffdelay_value)).setText("90s");
                    break;
                case 6:
                    ((TextView) findViewById(R.id.tv_xbs_tule_lightoffdelay_value)).setText("120s");
                    break;
                case 7:
                    ((TextView) findViewById(R.id.tv_xbs_tule_lightoffdelay_value)).setText("150s");
                    break;
                case 8:
                    ((TextView) findViewById(R.id.tv_xbs_tule_lightoffdelay_value)).setText("180s");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLightSensor() {
        int value = DataCanbus.DATA[38];
        if (((TextView) findViewById(R.id.tv_xbs_tule_lightsensitivity_value)) != null) {
            ((TextView) findViewById(R.id.tv_xbs_tule_lightsensitivity_value)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateKeyUnlock() {
        int value = DataCanbus.DATA[37];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_intelligent_key_lock)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_intelligent_key_lock)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDoorUnlock() {
        int value = DataCanbus.DATA[36];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_selective_door_unlock)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_selective_door_unlock)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpeedWiper() {
        int value = DataCanbus.DATA[35];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_wipersensor_speed)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_wipersensor_speed)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInterLight() {
        int value = DataCanbus.DATA[34];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_interior_illumination)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_interior_illumination)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarCentreSensor() {
        int value = DataCanbus.DATA[33];
        if (((TextView) findViewById(R.id.tv_xbs_tule_centresensor_value)) != null) {
            ((TextView) findViewById(R.id.tv_xbs_tule_centresensor_value)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarCornerSensor() {
        int value = DataCanbus.DATA[32];
        if (((TextView) findViewById(R.id.tv_xbs_tule_cornersensor_value)) != null) {
            ((TextView) findViewById(R.id.tv_xbs_tule_cornersensor_value)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarParkSensor() {
        int value = DataCanbus.DATA[31];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_parking_sensor)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_parking_sensor)).setChecked(value == 1);
        }
    }
}
