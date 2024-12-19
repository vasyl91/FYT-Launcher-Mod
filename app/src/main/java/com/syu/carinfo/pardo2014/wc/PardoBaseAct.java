package com.syu.carinfo.pardo2014.wc;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.widget.DoorContentView;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.CallbackCanbusBase;
import com.syu.module.canbus.Callback_0121_WC2_14Prado;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.ModuleCallbackCanbusProxy;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PardoBaseAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.pardo2014.wc.PardoBaseAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 1:
                    PardoBaseAct.this.mUpdaterDrivingMileaged();
                    break;
                case 3:
                    PardoBaseAct.this.mUpdaterDrivingTimed();
                    break;
                case 20:
                    PardoBaseAct.this.mUpdaterCurrentSpeed();
                    break;
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    PardoBaseAct.this.updaterDoor();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pardo_base);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        CallbackCanbusBase callback = ModuleCallbackCanbusProxy.getInstance().getCallbackCanbus();
        if (!(callback instanceof Callback_0121_WC2_14Prado)) {
            finish();
        } else {
            addNotify();
        }
        DataCanbus.PROXY.cmd(14, new int[]{1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        DataCanbus.PROXY.cmd(14, new int[1], null, null);
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCurrentSpeed() {
        int value = DataCanbus.DATA[20];
        int num = value & 16777215;
        if (((TextView) findViewById(R.id.pardo_tv_curr_velocity)) != null) {
            ((TextView) findViewById(R.id.pardo_tv_curr_velocity)).setText(String.valueOf(num) + " Km/h");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileaged() {
        int value = DataCanbus.DATA[1];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        String str = "";
        if (unit == 0) {
            str = String.valueOf(num) + " km";
        } else if (unit == 1) {
            str = String.valueOf(num) + " mile";
        } else if (unit == 2) {
            str = String.valueOf(num) + " ";
        }
        if (((TextView) findViewById(R.id.pardo_tv_driving_mileage)) != null) {
            ((TextView) findViewById(R.id.pardo_tv_driving_mileage)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingTimed() {
        int time = DataCanbus.DATA[3];
        if (time > -1) {
            int hour = time / 60;
            int minute = time % 60;
            StringBuffer sb = new StringBuffer();
            if (hour == 1) {
                sb.append(String.valueOf(String.format("%02d", Integer.valueOf(hour))) + LauncherApplication.getInstance().getResources().getString(R.string.time_hour));
            } else {
                sb.append(String.valueOf(String.format("%02d", Integer.valueOf(hour))) + LauncherApplication.getInstance().getResources().getString(R.string.time_hours));
            }
            if (minute == 1) {
                sb.append(String.valueOf(String.format("%02d", Integer.valueOf(minute))) + LauncherApplication.getInstance().getResources().getString(R.string.time_minute));
            } else {
                sb.append(String.valueOf(String.format("%02d", Integer.valueOf(minute))) + LauncherApplication.getInstance().getResources().getString(R.string.time_minutes));
            }
            if (((TextView) findViewById(R.id.pardo_tv_driving_time)) != null) {
                ((TextView) findViewById(R.id.pardo_tv_driving_time)).setText(sb.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDoor() {
        if (((DoorContentView) findViewById(R.id.pardo_door_wc)) != null) {
            ((DoorContentView) findViewById(R.id.pardo_door_wc)).invalidate();
        }
    }
}
