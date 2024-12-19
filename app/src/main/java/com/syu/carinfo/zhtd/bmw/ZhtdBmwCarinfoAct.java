package com.syu.carinfo.zhtd.bmw;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ZhtdBmwCarinfoAct extends Activity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdBmwCarinfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = R.drawable.ic_dashboard_car_null;
            int i2 = R.drawable.ic_bmw_dashboard_car_null;
            switch (updateCode) {
                case 0:
                    int value = DataCanbus.DATA[0];
                    ImageView imageView = (ImageView) ZhtdBmwCarinfoAct.this.findViewById(R.id.image_car_door_engine);
                    Resources resources = ZhtdBmwCarinfoAct.this.getResources();
                    if (value == 1) {
                        i2 = R.drawable.ic_bmw_dashboard_car_door_front;
                    }
                    imageView.setImageDrawable(resources.getDrawable(i2));
                    break;
                case 1:
                    ((ImageView) ZhtdBmwCarinfoAct.this.findViewById(R.id.image_car_door_fl)).setImageDrawable(ZhtdBmwCarinfoAct.this.getResources().getDrawable(DataCanbus.DATA[1] == 1 ? R.drawable.ic_bmw_dashboard_car_door_fl : 2130839229));
                    break;
                case 2:
                    int value2 = DataCanbus.DATA[2];
                    ImageView imageView2 = (ImageView) ZhtdBmwCarinfoAct.this.findViewById(R.id.image_car_door_fr);
                    Resources resources2 = ZhtdBmwCarinfoAct.this.getResources();
                    if (value2 == 1) {
                        i2 = R.drawable.ic_bmw_dashboard_car_door_fr;
                    }
                    imageView2.setImageDrawable(resources2.getDrawable(i2));
                    break;
                case 3:
                    int value3 = DataCanbus.DATA[3];
                    ImageView imageView3 = (ImageView) ZhtdBmwCarinfoAct.this.findViewById(R.id.image_car_door_rl);
                    Resources resources3 = ZhtdBmwCarinfoAct.this.getResources();
                    if (value3 == 1) {
                        i2 = R.drawable.ic_bmw_dashboard_car_door_rl;
                    }
                    imageView3.setImageDrawable(resources3.getDrawable(i2));
                    break;
                case 4:
                    int value4 = DataCanbus.DATA[4];
                    ImageView imageView4 = (ImageView) ZhtdBmwCarinfoAct.this.findViewById(R.id.image_car_door_rr);
                    Resources resources4 = ZhtdBmwCarinfoAct.this.getResources();
                    if (value4 == 1) {
                        i2 = R.drawable.ic_bmw_dashboard_car_door_rr;
                    }
                    imageView4.setImageDrawable(resources4.getDrawable(i2));
                    break;
                case 5:
                    int value5 = DataCanbus.DATA[5];
                    ImageView imageView5 = (ImageView) ZhtdBmwCarinfoAct.this.findViewById(R.id.image_car_door_rear);
                    Resources resources5 = ZhtdBmwCarinfoAct.this.getResources();
                    if (value5 == 1) {
                        i2 = R.drawable.ic_bmw_dashboard_car_door_back;
                    }
                    imageView5.setImageDrawable(resources5.getDrawable(i2));
                    break;
                case 7:
                    int value6 = DataCanbus.DATA[7];
                    ImageView imageView6 = (ImageView) ZhtdBmwCarinfoAct.this.findViewById(R.id.image_car_light_near_top);
                    Resources resources6 = ZhtdBmwCarinfoAct.this.getResources();
                    if (value6 == 1) {
                        i = R.drawable.ic_dashboard_top_light_near;
                    }
                    imageView6.setImageDrawable(resources6.getDrawable(i));
                    break;
                case 8:
                    int value7 = DataCanbus.DATA[8];
                    ImageView imageView7 = (ImageView) ZhtdBmwCarinfoAct.this.findViewById(R.id.image_car_light_far_top);
                    Resources resources7 = ZhtdBmwCarinfoAct.this.getResources();
                    if (value7 == 1) {
                        i = R.drawable.ic_dashboard_top_light_far;
                    }
                    imageView7.setImageDrawable(resources7.getDrawable(i));
                    break;
                case 9:
                    ZhtdBmwCarinfoAct.this.mUpdaterTurnleftLight(DataCanbus.DATA[9]);
                    break;
                case 10:
                    ZhtdBmwCarinfoAct.this.mUpdaterTurnrightLight(DataCanbus.DATA[10]);
                    break;
                case 11:
                    int value8 = DataCanbus.DATA[11];
                    if (value8 == 1) {
                        ((TextView) ZhtdBmwCarinfoAct.this.findViewById(R.id.txt_car_belt_state)).setText(R.string.str_seat_belt_tied);
                    } else {
                        ((TextView) ZhtdBmwCarinfoAct.this.findViewById(R.id.txt_car_belt_state)).setText(R.string.str_seat_belt_not_tied);
                    }
                    ((ImageView) ZhtdBmwCarinfoAct.this.findViewById(R.id.image_car_belt)).setImageDrawable(ZhtdBmwCarinfoAct.this.getResources().getDrawable(value8 == 0 ? R.drawable.ic_bmw_dashboard_car_belt_p : R.drawable.ic_bmw_dashboard_car_belt));
                    break;
                case 13:
                    int value9 = DataCanbus.DATA[13];
                    if (value9 == 1) {
                        ((TextView) ZhtdBmwCarinfoAct.this.findViewById(R.id.txt_car_handbrake_state)).setText(R.string.str_handbrake_pulled_up);
                    } else {
                        ((TextView) ZhtdBmwCarinfoAct.this.findViewById(R.id.txt_car_handbrake_state)).setText(R.string.str_handbrake_pulled_down);
                    }
                    ((ImageView) ZhtdBmwCarinfoAct.this.findViewById(R.id.image_car_handbrake)).setImageDrawable(ZhtdBmwCarinfoAct.this.getResources().getDrawable(value9 == 1 ? R.drawable.ic_bmw_dashboard_car_handbrake_p : R.drawable.ic_bmw_dashboard_car_handbrake));
                    break;
                case 14:
                    ZhtdBmwCarinfoAct.this.updateSpeed();
                    break;
                case 15:
                    ((TextView) ZhtdBmwCarinfoAct.this.findViewById(R.id.txt_car_oil)).setText(String.format("%d L", Integer.valueOf(DataCanbus.DATA[15])));
                    break;
                case 16:
                    int value10 = DataCanbus.DATA[16];
                    ((TextView) ZhtdBmwCarinfoAct.this.findViewById(R.id.txt_car_engine_speed)).setText(String.valueOf(value10) + " rpm");
                    ((InfoView) ZhtdBmwCarinfoAct.this.findViewById(R.id.infoView_enginespeed)).setSpeed((value10 * 240) / 8000);
                    break;
                case 17:
                    ((TextView) ZhtdBmwCarinfoAct.this.findViewById(R.id.txt_car_total_mileage)).setText(String.valueOf(DataCanbus.DATA[17]) + " km");
                    break;
                case 54:
                    int value11 = DataCanbus.DATA[54];
                    int tempunit = SystemProperties.getInt("persist.fyt.temperature", 0);
                    if (value11 == 0) {
                        ((TextView) ZhtdBmwCarinfoAct.this.findViewById(R.id.txt_car_outside_temp)).setText("--.--");
                        break;
                    } else if (tempunit == 1) {
                        ((TextView) ZhtdBmwCarinfoAct.this.findViewById(R.id.txt_car_outside_temp)).setText(String.valueOf(((value11 * 9) - 400) / 10.0f) + "℉");
                        break;
                    } else if (value11 >= 80) {
                        int value12 = (value11 * 5) - 400;
                        ((TextView) ZhtdBmwCarinfoAct.this.findViewById(R.id.txt_car_outside_temp)).setText(String.valueOf(value12 / 10) + "." + (value12 % 10) + "℃");
                        break;
                    } else {
                        int value13 = 400 - (value11 * 5);
                        ((TextView) ZhtdBmwCarinfoAct.this.findViewById(R.id.txt_car_outside_temp)).setText("-" + (value13 / 10) + "." + (value13 % 10) + "℃");
                        break;
                    }
            }
        }
    };
    int num = 0;
    Runnable mShowTurnLeftLight = new Runnable() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdBmwCarinfoAct.2
        @Override // java.lang.Runnable
        public void run() {
            ZhtdBmwCarinfoAct.this.num++;
            if (ZhtdBmwCarinfoAct.this.num > 1) {
                ZhtdBmwCarinfoAct.this.num = 0;
            }
            ((ImageView) ZhtdBmwCarinfoAct.this.findViewById(R.id.image_car_turnl_top)).setImageDrawable(ZhtdBmwCarinfoAct.this.getResources().getDrawable(ZhtdBmwCarinfoAct.this.num == 1 ? R.drawable.ic_dashboard_car_turnltop : R.drawable.ic_dashboard_car_null));
            HandlerUI.getInstance().removeCallbacks(ZhtdBmwCarinfoAct.this.mShowTurnLeftLight);
            HandlerUI.getInstance().postDelayed(ZhtdBmwCarinfoAct.this.mShowTurnLeftLight, 500L);
        }
    };
    int num1 = 0;
    Runnable mShowTurnRightLight = new Runnable() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdBmwCarinfoAct.3
        @Override // java.lang.Runnable
        public void run() {
            ZhtdBmwCarinfoAct.this.num1++;
            if (ZhtdBmwCarinfoAct.this.num1 > 1) {
                ZhtdBmwCarinfoAct.this.num1 = 0;
            }
            ((ImageView) ZhtdBmwCarinfoAct.this.findViewById(R.id.image_car_turnr_top)).setImageDrawable(ZhtdBmwCarinfoAct.this.getResources().getDrawable(ZhtdBmwCarinfoAct.this.num1 == 1 ? R.drawable.ic_dashboard_car_turnrtop : R.drawable.ic_dashboard_car_null));
            HandlerUI.getInstance().removeCallbacks(ZhtdBmwCarinfoAct.this.mShowTurnRightLight);
            HandlerUI.getInstance().postDelayed(ZhtdBmwCarinfoAct.this.mShowTurnRightLight, 500L);
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_zhtd_bmw_dashboard);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(0, new int[]{1, 1}, null, null);
        DoorHelper.disableDoorWindowLocal(true);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
        int[] iArr = new int[4];
        iArr[0] = 1;
        remoteModuleProxy.cmd(0, iArr, null, null);
        DoorHelper.disableDoorWindowLocal(false);
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpeed() {
        int speed = DataCanbus.DATA[14];
        ((InfoView2) findViewById(R.id.infoView_speed)).setSpeed(speed);
        ((TextView) findViewById(R.id.txt_car_speed)).setText(String.valueOf(speed) + " km/h");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTurnleftLight(int value) {
        if (value == 1) {
            HandlerUI.getInstance().removeCallbacks(this.mShowTurnLeftLight);
            HandlerUI.getInstance().postDelayed(this.mShowTurnLeftLight, 500L);
        } else {
            HandlerUI.getInstance().removeCallbacks(this.mShowTurnLeftLight);
            ((ImageView) findViewById(R.id.image_car_turnl_top)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dashboard_car_null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTurnrightLight(int value) {
        if (value == 1) {
            HandlerUI.getInstance().removeCallbacks(this.mShowTurnRightLight);
            HandlerUI.getInstance().postDelayed(this.mShowTurnRightLight, 500L);
        } else {
            HandlerUI.getInstance().removeCallbacks(this.mShowTurnRightLight);
            ((ImageView) findViewById(R.id.image_car_turnr_top)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dashboard_car_null));
        }
    }
}
