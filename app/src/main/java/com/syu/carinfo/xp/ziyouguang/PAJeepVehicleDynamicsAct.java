package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PAJeepVehicleDynamicsAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepVehicleDynamicsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 215:
                    if (((TextView) PAJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text1)) != null) {
                        if ((32768 & value) != 0) {
                            ((TextView) PAJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text1)).setText("L:" + (65536 - value) + "°");
                            PAJeepVehicleDynamicsAct.this.findViewById(R.id.id_image4).setBackgroundResource(R.drawable.ic_pa_jeep_suspension_new_left);
                            break;
                        } else if (value == 0) {
                            ((TextView) PAJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "°");
                            PAJeepVehicleDynamicsAct.this.findViewById(R.id.id_image4).setBackgroundResource(R.drawable.ic_pa_jeep_suspension_new);
                            break;
                        } else {
                            ((TextView) PAJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text1)).setText("R:" + value + "°");
                            PAJeepVehicleDynamicsAct.this.findViewById(R.id.id_image4).setBackgroundResource(R.drawable.ic_pa_jeep_suspension_new_right);
                            break;
                        }
                    }
                    break;
                case 216:
                    switch (value) {
                        case 0:
                            PAJeepVehicleDynamicsAct.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_dashboard_car_null);
                            ((TextView) PAJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text2)).setText("4H AUTO");
                            break;
                        case 1:
                            PAJeepVehicleDynamicsAct.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_dashboard_car_null);
                            ((TextView) PAJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text2)).setText("2WD");
                            break;
                        case 2:
                            PAJeepVehicleDynamicsAct.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_dashboard_car_null);
                            ((TextView) PAJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text2)).setText("2WD LOW");
                            break;
                        case 3:
                            PAJeepVehicleDynamicsAct.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_dashboard_car_null);
                            ((TextView) PAJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text2)).setText("2WD HI");
                            break;
                        case 4:
                            PAJeepVehicleDynamicsAct.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_dashboard_car_null);
                            ((TextView) PAJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text2)).setText("4H PART TIME");
                            break;
                        case 5:
                            PAJeepVehicleDynamicsAct.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_pa_jeep_front_locker);
                            ((TextView) PAJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text2)).setText("4WD LOW");
                            break;
                        case 6:
                            PAJeepVehicleDynamicsAct.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_dashboard_car_null);
                            ((TextView) PAJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text2)).setText("4WD HI");
                            break;
                        case 7:
                            PAJeepVehicleDynamicsAct.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_dashboard_car_null);
                            ((TextView) PAJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text2)).setText("N");
                            break;
                    }
                    PAJeepVehicleDynamicsAct.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_pa_jeep_front_locker);
                    break;
                case 217:
                    PAJeepVehicleDynamicsAct.this.findViewById(R.id.id_image2).setBackgroundResource(R.drawable.ic_pa_jeep_front_locker);
                    switch (value) {
                        case 0:
                            ((TextView) PAJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text5)).setText("unlocked");
                            break;
                        case 1:
                            ((TextView) PAJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text5)).setText("engaged");
                            break;
                    }
                case 218:
                    PAJeepVehicleDynamicsAct.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.ic_pa_jeep_front_locker);
                    switch (value) {
                        case 0:
                            ((TextView) PAJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text4)).setText("unlocked");
                            break;
                        case 1:
                            ((TextView) PAJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text4)).setText("engaged");
                            break;
                    }
                case 219:
                    switch (value) {
                        case 0:
                            ((TextView) PAJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text3)).setText("disconnected");
                            break;
                        case 1:
                            ((TextView) PAJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text3)).setText("connected");
                            break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_pa_jeep_vehicle_dynamics);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(4, new int[]{82}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[216].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[217].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[218].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[219].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[217].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[218].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[219].removeNotify(this.mNotifyCanbus);
    }
}
