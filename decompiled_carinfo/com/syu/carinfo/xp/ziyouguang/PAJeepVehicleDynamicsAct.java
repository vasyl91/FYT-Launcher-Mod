package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class PAJeepVehicleDynamicsAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 227:
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
                case 228:
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
                case 229:
                    PAJeepVehicleDynamicsAct.this.findViewById(R.id.id_image2).setBackgroundResource(R.drawable.ic_pa_jeep_front_locker);
                    switch (value) {
                        case 0:
                            ((TextView) PAJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text5)).setText("unlocked");
                            break;
                        case 1:
                            ((TextView) PAJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text5)).setText("engaged");
                            break;
                    }
                case 230:
                    PAJeepVehicleDynamicsAct.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.ic_pa_jeep_front_locker);
                    switch (value) {
                        case 0:
                            ((TextView) PAJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text4)).setText("unlocked");
                            break;
                        case 1:
                            ((TextView) PAJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text4)).setText("engaged");
                            break;
                    }
                case 231:
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0374_pa_jeep_vehicle_dynamics);
        init();
    }

    @Override
    public void init() {
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(4, new int[]{82}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[227].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[228].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[229].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[230].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[231].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[227].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[228].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[229].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[230].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[231].removeNotify(this.mNotifyCanbus);
    }
}
