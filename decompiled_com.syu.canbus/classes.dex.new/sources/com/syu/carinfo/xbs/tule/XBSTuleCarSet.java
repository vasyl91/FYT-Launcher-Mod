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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class XBSTuleCarSet extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    int val = 0;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.tule.XBSTuleCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            XBSTuleCarSet.this.val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 102:
                    XBSTuleCarSet.this.updateCarParkSensor();
                    break;
                case 103:
                    XBSTuleCarSet.this.updateCarCornerSensor();
                    break;
                case 104:
                    XBSTuleCarSet.this.updateCarCentreSensor();
                    break;
                case 105:
                    XBSTuleCarSet.this.updateInterLight();
                    break;
                case 106:
                    XBSTuleCarSet.this.updateSpeedWiper();
                    break;
                case 107:
                    XBSTuleCarSet.this.updateDoorUnlock();
                    break;
                case 108:
                    XBSTuleCarSet.this.updateKeyUnlock();
                    break;
                case 109:
                    XBSTuleCarSet.this.updateLightSensor();
                    break;
                case 110:
                    XBSTuleCarSet.this.updateLightOffDelay();
                    break;
                case 121:
                    XBSTuleCarSet.this.updateSenar();
                    break;
                case 122:
                    XBSTuleCarSet.this.updateFRSenar();
                    break;
                case 123:
                    XBSTuleCarSet.this.updateInterruptDisplay();
                    break;
                case 124:
                    XBSTuleCarSet.this.updateSenarSensitivity();
                    break;
                case 125:
                    XBSTuleCarSet.this.updateSenarVolume();
                    break;
                case 126:
                    XBSTuleCarSet.this.updateDistanceAssit();
                    break;
                case 127:
                    XBSTuleCarSet.this.updateRoadAway();
                    break;
                case 128:
                    XBSTuleCarSet.this.updateBlindSpot();
                    break;
                case 129:
                    XBSTuleCarSet.this.updateCollisionWarn();
                    break;
                case 130:
                    XBSTuleCarSet.this.updateRoadAwatWarn();
                    break;
                case 131:
                    XBSTuleCarSet.this.updateBlindSpotWarn();
                    break;
                case 132:
                    XBSTuleCarSet.this.updateRearViewLeft();
                    break;
                case 133:
                    XBSTuleCarSet.this.updateRearViewRight();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_xbstule_settings);
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
            case R.id.id_reset /* 2131427693 */:
                setCarInfo(53, 9);
                break;
            case R.id.ctv_xbs_tule_parking_sensor /* 2131428595 */:
                setCarInfo(52, 1);
                break;
            case R.id.xbs_tule_btn_cornersensor_minus /* 2131428596 */:
                setCarInfo(52, 2);
                break;
            case R.id.xbs_tule_btn_cornersensor_plus /* 2131428598 */:
                setCarInfo(52, 3);
                break;
            case R.id.xbs_tule_btn_centresensor_minus /* 2131428599 */:
                setCarInfo(52, 4);
                break;
            case R.id.xbs_tule_btn_centresensor_plus /* 2131428601 */:
                setCarInfo(52, 5);
                break;
            case R.id.ctv_xbs_tule_interior_illumination /* 2131428602 */:
                setCarInfo(53, 1);
                break;
            case R.id.ctv_xbs_tule_wipersensor_speed /* 2131428603 */:
                setCarInfo(53, 6);
                break;
            case R.id.ctv_xbs_tule_selective_door_unlock /* 2131428604 */:
                setCarInfo(53, 7);
                break;
            case R.id.ctv_xbs_tule_intelligent_key_lock /* 2131428605 */:
                setCarInfo(53, 8);
                break;
            case R.id.xbs_tule_btn_lightsensitivity_minus /* 2131428606 */:
                setCarInfo(53, 2);
                break;
            case R.id.xbs_tule_btn_lightsensitivity_plus /* 2131428608 */:
                setCarInfo(53, 3);
                break;
            case R.id.xbs_tule_btn_lightoffdelay_minus /* 2131428609 */:
                setCarInfo(53, 4);
                break;
            case R.id.xbs_tule_btn_lightoffdelay_plus /* 2131428611 */:
                setCarInfo(53, 5);
                break;
            case R.id.ctv_xbs_tule_sonar_onoff /* 2131428612 */:
                setCarInfo(54, 1);
                break;
            case R.id.ctv_xbs_tule_frsonar_onoff /* 2131428613 */:
                setCarInfo(54, 2);
                break;
            case R.id.ctv_xbs_tule_interruptdisplay_onoff /* 2131428614 */:
                setCarInfo(54, 3);
                break;
            case R.id.xbs_tule_btn_sonarsensitivity_minus /* 2131428615 */:
                setCarInfo(54, 4);
                break;
            case R.id.xbs_tule_btn_sonarsensitivity_plus /* 2131428617 */:
                setCarInfo(54, 5);
                break;
            case R.id.xbs_tule_btn_sonarvolume_minus /* 2131428618 */:
                setCarInfo(54, 6);
                break;
            case R.id.xbs_tule_btn_sonarvolume_plus /* 2131428620 */:
                setCarInfo(54, 7);
                break;
            case R.id.ctv_xbs_tule_distance_control_assit_onoff /* 2131428621 */:
                setCarInfo(55, 1);
                break;
            case R.id.ctv_xbs_tule_lane_departure_prevention_onoff /* 2131428622 */:
                setCarInfo(55, 2);
                break;
            case R.id.ctv_xbs_tule_blind_spot_intervention_onoff /* 2131428623 */:
                setCarInfo(55, 3);
                break;
            case R.id.ctv_xbs_tule_forward_collision_warning_onoff /* 2131428624 */:
                setCarInfo(55, 4);
                break;
            case R.id.ctv_xbs_tule_lane_departure_warning_onoff /* 2131428625 */:
                setCarInfo(55, 5);
                break;
            case R.id.ctv_xbs_tule_blind_spot_warning_onoff /* 2131428626 */:
                setCarInfo(55, 6);
                break;
            case R.id.ctv_xbs_tule_left_headrest_onoff /* 2131428627 */:
                setCarInfo(56, 1);
                break;
            case R.id.ctv_xbs_tule_right_headrest_onoff /* 2131428628 */:
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
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRearViewRight() {
        int value = DataCanbus.DATA[133];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_right_headrest_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_right_headrest_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRearViewLeft() {
        int value = DataCanbus.DATA[132];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_left_headrest_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_left_headrest_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlindSpotWarn() {
        int value = DataCanbus.DATA[131];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_blind_spot_warning_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_blind_spot_warning_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRoadAwatWarn() {
        int value = DataCanbus.DATA[130];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_lane_departure_warning_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_lane_departure_warning_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCollisionWarn() {
        int value = DataCanbus.DATA[129];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_forward_collision_warning_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_forward_collision_warning_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlindSpot() {
        int value = DataCanbus.DATA[128];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_blind_spot_intervention_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_blind_spot_intervention_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRoadAway() {
        int value = DataCanbus.DATA[127];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_lane_departure_prevention_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_lane_departure_prevention_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDistanceAssit() {
        int value = DataCanbus.DATA[126];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_distance_control_assit_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_distance_control_assit_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSenarVolume() {
        int value = DataCanbus.DATA[125];
        if (((TextView) findViewById(R.id.tv_xbs_tule_sonarvolume_value)) != null) {
            ((TextView) findViewById(R.id.tv_xbs_tule_sonarvolume_value)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSenarSensitivity() {
        int value = DataCanbus.DATA[124];
        if (((TextView) findViewById(R.id.tv_xbs_tule_sonarsensitivity_value)) != null) {
            ((TextView) findViewById(R.id.tv_xbs_tule_sonarsensitivity_value)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInterruptDisplay() {
        int value = DataCanbus.DATA[123];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_interruptdisplay_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_interruptdisplay_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFRSenar() {
        int value = DataCanbus.DATA[122];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_frsonar_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_frsonar_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSenar() {
        int value = DataCanbus.DATA[121];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_sonar_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_sonar_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLightOffDelay() {
        int value = DataCanbus.DATA[110];
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
        int value = DataCanbus.DATA[109];
        if (((TextView) findViewById(R.id.tv_xbs_tule_lightsensitivity_value)) != null) {
            ((TextView) findViewById(R.id.tv_xbs_tule_lightsensitivity_value)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateKeyUnlock() {
        int value = DataCanbus.DATA[108];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_intelligent_key_lock)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_intelligent_key_lock)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDoorUnlock() {
        int value = DataCanbus.DATA[107];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_selective_door_unlock)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_selective_door_unlock)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpeedWiper() {
        int value = DataCanbus.DATA[106];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_wipersensor_speed)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_wipersensor_speed)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInterLight() {
        int value = DataCanbus.DATA[105];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_interior_illumination)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_interior_illumination)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarCentreSensor() {
        int value = DataCanbus.DATA[104];
        if (((TextView) findViewById(R.id.tv_xbs_tule_centresensor_value)) != null) {
            ((TextView) findViewById(R.id.tv_xbs_tule_centresensor_value)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarCornerSensor() {
        int value = DataCanbus.DATA[103];
        if (((TextView) findViewById(R.id.tv_xbs_tule_cornersensor_value)) != null) {
            ((TextView) findViewById(R.id.tv_xbs_tule_cornersensor_value)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarParkSensor() {
        int value = DataCanbus.DATA[102];
        if (((CheckedTextView) findViewById(R.id.ctv_xbs_tule_parking_sensor)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_xbs_tule_parking_sensor)).setChecked(value == 1);
        }
    }
}
