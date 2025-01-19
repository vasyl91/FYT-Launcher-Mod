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

public class PardoBaseAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    PardoBaseAct.this.updaterDoor();
                    break;
                case 99:
                    PardoBaseAct.this.mUpdaterDrivingMileaged();
                    break;
                case 101:
                    PardoBaseAct.this.mUpdaterDrivingTimed();
                    break;
                case 118:
                    PardoBaseAct.this.mUpdaterCurrentSpeed();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_pardo_base);
    }

    @Override
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

    @Override
    protected void onPause() {
        super.onPause();
        DataCanbus.PROXY.cmd(14, new int[1], null, null);
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.notifyCanbus);
    }

    
    public void mUpdaterCurrentSpeed() {
        int value = DataCanbus.DATA[118];
        int num = value & 16777215;
        if (((TextView) findViewById(R.id.pardo_tv_curr_velocity)) != null) {
            ((TextView) findViewById(R.id.pardo_tv_curr_velocity)).setText(String.valueOf(num) + " Km/h");
        }
    }

    
    public void mUpdaterDrivingMileaged() {
        int value = DataCanbus.DATA[99];
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

    
    public void mUpdaterDrivingTimed() {
        int time = DataCanbus.DATA[101];
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

    
    public void updaterDoor() {
        if (((DoorContentView) findViewById(R.id.pardo_door_wc)) != null) {
            ((DoorContentView) findViewById(R.id.pardo_door_wc)).invalidate();
        }
    }
}
