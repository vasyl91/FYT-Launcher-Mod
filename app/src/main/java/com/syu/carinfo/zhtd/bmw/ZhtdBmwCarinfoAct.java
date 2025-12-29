package com.syu.carinfo.zhtd.bmw;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.SystemProperties;
import android.widget.ImageView;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerUI;

@SuppressWarnings({"deprecation", "unchecked"})
public class ZhtdBmwCarinfoAct extends Activity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
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
                    ((ImageView) ZhtdBmwCarinfoAct.this.findViewById(R.id.image_car_door_fl)).setImageDrawable(ZhtdBmwCarinfoAct.this.getResources().getDrawable(DataCanbus.DATA[1] == 1 ? R.drawable.ic_bmw_dashboard_car_door_fl : 2130839697));
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
                case 98:
                    int value6 = DataCanbus.DATA[98];
                    ImageView imageView6 = (ImageView) ZhtdBmwCarinfoAct.this.findViewById(R.id.image_car_light_near_top);
                    Resources resources6 = ZhtdBmwCarinfoAct.this.getResources();
                    if (value6 == 1) {
                        i = R.drawable.ic_dashboard_top_light_near;
                    }
                    imageView6.setImageDrawable(resources6.getDrawable(i));
                    break;
                case 99:
                    int value7 = DataCanbus.DATA[99];
                    ImageView imageView7 = (ImageView) ZhtdBmwCarinfoAct.this.findViewById(R.id.image_car_light_far_top);
                    Resources resources7 = ZhtdBmwCarinfoAct.this.getResources();
                    if (value7 == 1) {
                        i = R.drawable.ic_dashboard_top_light_far;
                    }
                    imageView7.setImageDrawable(resources7.getDrawable(i));
                    break;
                case 100:
                    ZhtdBmwCarinfoAct.this.mUpdaterTurnleftLight(DataCanbus.DATA[100]);
                    break;
                case 101:
                    ZhtdBmwCarinfoAct.this.mUpdaterTurnrightLight(DataCanbus.DATA[101]);
                    break;
                case 102:
                    int value8 = DataCanbus.DATA[102];
                    if (value8 == 1) {
                        ((TextView) ZhtdBmwCarinfoAct.this.findViewById(R.id.txt_car_belt_state)).setText(R.string.str_seat_belt_tied);
                    } else {
                        ((TextView) ZhtdBmwCarinfoAct.this.findViewById(R.id.txt_car_belt_state)).setText(R.string.str_seat_belt_not_tied);
                    }
                    ((ImageView) ZhtdBmwCarinfoAct.this.findViewById(R.id.image_car_belt)).setImageDrawable(ZhtdBmwCarinfoAct.this.getResources().getDrawable(value8 == 0 ? R.drawable.ic_bmw_dashboard_car_belt_p : R.drawable.ic_bmw_dashboard_car_belt));
                    break;
                case 104:
                    int value9 = DataCanbus.DATA[104];
                    if (value9 == 1) {
                        ((TextView) ZhtdBmwCarinfoAct.this.findViewById(R.id.txt_car_handbrake_state)).setText(R.string.str_handbrake_pulled_up);
                    } else {
                        ((TextView) ZhtdBmwCarinfoAct.this.findViewById(R.id.txt_car_handbrake_state)).setText(R.string.str_handbrake_pulled_down);
                    }
                    ((ImageView) ZhtdBmwCarinfoAct.this.findViewById(R.id.image_car_handbrake)).setImageDrawable(ZhtdBmwCarinfoAct.this.getResources().getDrawable(value9 == 1 ? R.drawable.ic_bmw_dashboard_car_handbrake_p : R.drawable.ic_bmw_dashboard_car_handbrake));
                    break;
                case 105:
                    ZhtdBmwCarinfoAct.this.updateSpeed();
                    break;
                case 106:
                    ((TextView) ZhtdBmwCarinfoAct.this.findViewById(R.id.txt_car_oil)).setText(String.format("%d L", Integer.valueOf(DataCanbus.DATA[106])));
                    break;
                case 107:
                    int value10 = DataCanbus.DATA[107];
                    ((TextView) ZhtdBmwCarinfoAct.this.findViewById(R.id.txt_car_engine_speed)).setText(String.valueOf(value10) + " rpm");
                    ((InfoView) ZhtdBmwCarinfoAct.this.findViewById(R.id.infoView_enginespeed)).setSpeed((value10 * 240) / 8000);
                    break;
                case 108:
                    ((TextView) ZhtdBmwCarinfoAct.this.findViewById(R.id.txt_car_total_mileage)).setText(String.valueOf(DataCanbus.DATA[108]) + " km");
                    break;
                case 123:
                    int value11 = DataCanbus.DATA[123];
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
    Runnable mShowTurnLeftLight = new Runnable() { 
        @Override
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
    Runnable mShowTurnRightLight = new Runnable() { 
        @Override
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_zhtd_bmw_dashboard);
        if (DataCanbus.DATA[1000] == 7668155 || DataCanbus.DATA[1000] == 2818492 || DataCanbus.DATA[1000] == 655804) {
            findViewById(R.id.txt_car_total_mileage).setVisibility(8);
        } else {
            findViewById(R.id.txt_car_total_mileage).setVisibility(0);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        if (DataCanbus.DATA[1000] == 7668155 || DataCanbus.DATA[1000] == 2818492 || DataCanbus.DATA[1000] == 655804) {
            DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
        } else {
            DataCanbus.PROXY.cmd(0, new int[]{1, 1}, null, null);
        }
        DoorHelper.disableDoorWindowLocal(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        if (DataCanbus.DATA[1000] == 7668155 || DataCanbus.DATA[1000] == 2818492 || DataCanbus.DATA[1000] == 655804) {
            DataCanbus.PROXY.cmd(6, new int[1], null, null);
        } else {
            RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
            int[] iArr = new int[4];
            iArr[0] = 1;
            remoteModuleProxy.cmd(0, iArr, null, null);
        }
        DoorHelper.disableDoorWindowLocal(false);
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateSpeed() {
        int speed = DataCanbus.DATA[105];
        ((InfoView2) findViewById(R.id.infoView_speed)).setSpeed(speed);
        ((TextView) findViewById(R.id.txt_car_speed)).setText(String.valueOf(speed) + " km/h");
    }

    
    public void mUpdaterTurnleftLight(int value) {
        if (value == 1) {
            HandlerUI.getInstance().removeCallbacks(this.mShowTurnLeftLight);
            HandlerUI.getInstance().postDelayed(this.mShowTurnLeftLight, 500L);
        } else {
            HandlerUI.getInstance().removeCallbacks(this.mShowTurnLeftLight);
            ((ImageView) findViewById(R.id.image_car_turnl_top)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dashboard_car_null));
        }
    }

    
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
