package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class RZCJeepVehicleDynamicsAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.RZCJeepVehicleDynamicsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 256:
                    switch (value) {
                        case 0:
                            ((TextView) RZCJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text2)).setText("---");
                            break;
                        case 1:
                            ((TextView) RZCJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text2)).setText("4L");
                            break;
                        case 2:
                            ((TextView) RZCJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text2)).setText("4H");
                            break;
                        case 3:
                            ((TextView) RZCJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text2)).setText("2H");
                            break;
                        case 4:
                            ((TextView) RZCJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text2)).setText("N");
                            break;
                        case 5:
                            ((TextView) RZCJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text2)).setText("4H AUTO");
                            break;
                        case 6:
                            ((TextView) RZCJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text2)).setText("4H PART TIME");
                            break;
                    }
                    RZCJeepVehicleDynamicsAct.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_pa_jeep_front_locker);
                    break;
                case 257:
                    switch (value) {
                        case 0:
                            ((TextView) RZCJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text3)).setText(R.string.str_unconnected);
                            break;
                        case 1:
                            ((TextView) RZCJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text3)).setText(R.string.str_connected);
                            break;
                    }
                    break;
                case 258:
                    RZCJeepVehicleDynamicsAct.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.ic_pa_jeep_front_locker);
                    switch (value) {
                        case 0:
                            ((TextView) RZCJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text4)).setText(R.string.str_unlocked);
                            break;
                        case 1:
                            ((TextView) RZCJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text4)).setText(R.string.str_locked);
                            break;
                    }
                    break;
                case 259:
                    RZCJeepVehicleDynamicsAct.this.findViewById(R.id.id_image2).setBackgroundResource(R.drawable.ic_pa_jeep_front_locker);
                    switch (value) {
                        case 0:
                            ((TextView) RZCJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text5)).setText(R.string.str_unlocked);
                            break;
                        case 1:
                            ((TextView) RZCJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text5)).setText(R.string.str_locked);
                            break;
                    }
                    break;
                case 260:
                    if (((TextView) RZCJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text1)) != null) {
                        if ((value & 128) == 0) {
                            int value2 = value & 127;
                            if (value2 == 0) {
                                ((TextView) RZCJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value2) + "°");
                                RZCJeepVehicleDynamicsAct.this.findViewById(R.id.id_image4).setBackgroundResource(R.drawable.ic_pa_jeep_suspension_new);
                            } else {
                                ((TextView) RZCJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text1)).setText("L:" + value2 + "°");
                                RZCJeepVehicleDynamicsAct.this.findViewById(R.id.id_image4).setBackgroundResource(R.drawable.ic_pa_jeep_suspension_new_left);
                            }
                        } else {
                            int value3 = value & 127;
                            if (value3 == 0) {
                                ((TextView) RZCJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value3) + "°");
                                RZCJeepVehicleDynamicsAct.this.findViewById(R.id.id_image4).setBackgroundResource(R.drawable.ic_pa_jeep_suspension_new);
                            } else {
                                ((TextView) RZCJeepVehicleDynamicsAct.this.findViewById(R.id.tv_text1)).setText("R:" + value3 + "°");
                                RZCJeepVehicleDynamicsAct.this.findViewById(R.id.id_image4).setBackgroundResource(R.drawable.ic_pa_jeep_suspension_new_right);
                            }
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0373_rzc_jeep_vehicle_dynamics);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(9, new int[]{52}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[256].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[257].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[258].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[259].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[260].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[256].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[257].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[258].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[259].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[260].removeNotify(this.mNotifyCanbus);
    }
}
