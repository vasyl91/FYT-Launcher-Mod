package com.syu.carinfo.lz.spirior;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Lz_425_Spirior_LightAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.spirior.Lz_425_Spirior_LightAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    Lz_425_Spirior_LightAct.this.updateHighBeam();
                    break;
                case 11:
                    Lz_425_Spirior_LightAct.this.updateLowBeam();
                    break;
                case 12:
                    Lz_425_Spirior_LightAct.this.updateFogLights();
                    break;
                case 13:
                    Lz_425_Spirior_LightAct.this.updateFogLamps();
                    break;
                case 14:
                    Lz_425_Spirior_LightAct.this.updateBrakeLight();
                    break;
                case 15:
                    Lz_425_Spirior_LightAct.this.updateTurnLeftLight();
                    break;
                case 16:
                    Lz_425_Spirior_LightAct.this.updateTurnRightLight();
                    break;
            }
        }
    };
    public TextView tvBrakeLight;
    public TextView tvFogLamps;
    public TextView tvFogLights;
    public TextView tvHighBeam;
    public TextView tvLowBeam;
    public TextView tvTurnLeft;
    public TextView tvTurnRight;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0425_lz_spirior_light);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.tvHighBeam = (TextView) findViewById(R.id.lz_spirior_highbeam_img);
        this.tvLowBeam = (TextView) findViewById(R.id.lz_spirior_lowbeam_img);
        this.tvFogLights = (TextView) findViewById(R.id.lz_spirior_foglights_img);
        this.tvFogLamps = (TextView) findViewById(R.id.lz_spirior_foglamps_img);
        this.tvBrakeLight = (TextView) findViewById(R.id.lz_spirior_brakelight_img);
        this.tvTurnLeft = (TextView) findViewById(R.id.lz_spirior_turnleft_img);
        this.tvTurnRight = (TextView) findViewById(R.id.lz_spirior_turnright_img);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHighBeam() {
        int highbeam = DataCanbus.DATA[10];
        if (this.tvHighBeam != null) {
            if (highbeam == 1) {
                this.tvHighBeam.setBackgroundResource(R.drawable.wc_ruiteng_away_light_1);
            } else {
                this.tvHighBeam.setBackgroundResource(R.drawable.wc_ruiteng_away_light_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLowBeam() {
        int lowbeam = DataCanbus.DATA[11];
        if (this.tvLowBeam != null) {
            if (lowbeam == 1) {
                this.tvLowBeam.setBackgroundResource(R.drawable.wc_ruiteng_near_light_1);
            } else {
                this.tvLowBeam.setBackgroundResource(R.drawable.wc_ruiteng_near_light_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFogLights() {
        int foglights = DataCanbus.DATA[12];
        if (this.tvFogLights != null) {
            if (foglights == 1) {
                this.tvFogLights.setBackgroundResource(R.drawable.wc_ruiteng_front_fog_light_1);
            } else {
                this.tvFogLights.setBackgroundResource(R.drawable.wc_ruiteng_front_fog_light_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFogLamps() {
        int foglamps = DataCanbus.DATA[13];
        if (this.tvFogLamps != null) {
            if (foglamps == 1) {
                this.tvFogLamps.setBackgroundResource(R.drawable.wc_ruiteng_rear_fog_light_1);
            } else {
                this.tvFogLamps.setBackgroundResource(R.drawable.wc_ruiteng_rear_fog_light_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBrakeLight() {
        int brakelight = DataCanbus.DATA[14];
        if (this.tvBrakeLight != null) {
            if (brakelight == 1) {
                this.tvBrakeLight.setBackgroundResource(R.drawable.wc_ruiteng_brake_car_light_1);
            } else {
                this.tvBrakeLight.setBackgroundResource(R.drawable.wc_ruiteng_brake_car_light_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTurnLeftLight() {
        int turnleftlight = DataCanbus.DATA[15];
        if (this.tvTurnLeft != null) {
            if (turnleftlight == 1) {
                this.tvTurnLeft.setBackgroundResource(R.drawable.wc_ruiteng_left_turn_light_1);
            } else {
                this.tvTurnLeft.setBackgroundResource(R.drawable.wc_ruiteng_left_turn_light_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTurnRightLight() {
        int turnrightlight = DataCanbus.DATA[16];
        if (this.tvTurnRight != null) {
            if (turnrightlight == 1) {
                this.tvTurnRight.setBackgroundResource(R.drawable.wc_ruiteng_right_turn_light_1);
            } else {
                this.tvTurnRight.setBackgroundResource(R.drawable.wc_ruiteng_right_turn_light_0);
            }
        }
    }
}
