package com.syu.carinfo.rzc.addcan;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZCAddCanDashBoard extends Activity {
    public static boolean mIsFront = false;
    int unit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.addcan.RZCAddCanDashBoard.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = R.drawable.ic_dashboard_car_light;
            int i2 = R.drawable.ic_dashboard_car_null;
            switch (updateCode) {
                case ConstRzcAddData.U_CAR_FRAME_NUM /* 501 */:
                    ((TextView) RZCAddCanDashBoard.this.findViewById(R.id.car_frame_num_info)).setText(String.valueOf(RZCAddCanDashBoard.this.getString(R.string.str_car_frame_num)) + ConstRzcAddData.CarFrameNum);
                    break;
                case ConstRzcAddData.U_CAR_LIGHT_WIDTH /* 502 */:
                    int value = DataCanbus.DATA[502];
                    ImageView imageView = (ImageView) RZCAddCanDashBoard.this.findViewById(R.id.image_car_light);
                    Resources resources = RZCAddCanDashBoard.this.getResources();
                    if (value != 1) {
                        i = 2130839521;
                    }
                    imageView.setImageDrawable(resources.getDrawable(i));
                    ImageView imageView2 = (ImageView) RZCAddCanDashBoard.this.findViewById(R.id.image_car_light_width_top);
                    Resources resources2 = RZCAddCanDashBoard.this.getResources();
                    if (value == 1) {
                        i2 = R.drawable.ic_dashboard_top_light_width;
                    }
                    imageView2.setImageDrawable(resources2.getDrawable(i2));
                    break;
                case ConstRzcAddData.U_CAR_LIGHT_NEAR /* 503 */:
                    int value2 = DataCanbus.DATA[503];
                    ImageView imageView3 = (ImageView) RZCAddCanDashBoard.this.findViewById(R.id.image_car_light);
                    Resources resources3 = RZCAddCanDashBoard.this.getResources();
                    if (value2 != 1) {
                        i = 2130839521;
                    }
                    imageView3.setImageDrawable(resources3.getDrawable(i));
                    ImageView imageView4 = (ImageView) RZCAddCanDashBoard.this.findViewById(R.id.image_car_light_near_top);
                    Resources resources4 = RZCAddCanDashBoard.this.getResources();
                    if (value2 == 1) {
                        i2 = R.drawable.ic_dashboard_top_light_near;
                    }
                    imageView4.setImageDrawable(resources4.getDrawable(i2));
                    break;
                case ConstRzcAddData.U_CAR_LIGHT_FAR /* 504 */:
                    int value3 = DataCanbus.DATA[504];
                    ImageView imageView5 = (ImageView) RZCAddCanDashBoard.this.findViewById(R.id.image_car_light);
                    Resources resources5 = RZCAddCanDashBoard.this.getResources();
                    if (value3 != 1) {
                        i = 2130839521;
                    }
                    imageView5.setImageDrawable(resources5.getDrawable(i));
                    ImageView imageView6 = (ImageView) RZCAddCanDashBoard.this.findViewById(R.id.image_car_light_far_top);
                    Resources resources6 = RZCAddCanDashBoard.this.getResources();
                    if (value3 == 1) {
                        i2 = R.drawable.ic_dashboard_top_light_far;
                    }
                    imageView6.setImageDrawable(resources6.getDrawable(i2));
                    break;
                case ConstRzcAddData.U_CAR_LIGHT_LEFT /* 505 */:
                    RZCAddCanDashBoard.this.mUpdaterTurnleftLight(DataCanbus.DATA[505]);
                    break;
                case ConstRzcAddData.U_CAR_LIGHT_RIGHT /* 506 */:
                    RZCAddCanDashBoard.this.mUpdaterTurnrightLight(DataCanbus.DATA[506]);
                    break;
                case ConstRzcAddData.U_CAR_LIGHT_FRONT /* 507 */:
                    int value4 = DataCanbus.DATA[507];
                    ImageView imageView7 = (ImageView) RZCAddCanDashBoard.this.findViewById(R.id.image_car_light);
                    Resources resources7 = RZCAddCanDashBoard.this.getResources();
                    if (value4 != 1) {
                        i = 2130839521;
                    }
                    imageView7.setImageDrawable(resources7.getDrawable(i));
                    ImageView imageView8 = (ImageView) RZCAddCanDashBoard.this.findViewById(R.id.image_car_light_front_top);
                    Resources resources8 = RZCAddCanDashBoard.this.getResources();
                    if (value4 == 1) {
                        i2 = R.drawable.ic_dashboard_top_light_front;
                    }
                    imageView8.setImageDrawable(resources8.getDrawable(i2));
                    break;
                case ConstRzcAddData.U_CAR_LIGHT_REAR /* 508 */:
                    int value5 = DataCanbus.DATA[508];
                    ImageView imageView9 = (ImageView) RZCAddCanDashBoard.this.findViewById(R.id.image_car_light_rear_top);
                    Resources resources9 = RZCAddCanDashBoard.this.getResources();
                    if (value5 == 1) {
                        i2 = R.drawable.ic_dashboard_top_light_rear;
                    }
                    imageView9.setImageDrawable(resources9.getDrawable(i2));
                    break;
                case ConstRzcAddData.U_CAR_WIPER_LEV /* 509 */:
                    int value6 = DataCanbus.DATA[509];
                    ((TextView) RZCAddCanDashBoard.this.findViewById(R.id.txt_car_wiper_lev)).setText(String.format("%d", Integer.valueOf(value6)));
                    break;
                case ConstRzcAddData.U_CAR_CUR_SPEED /* 510 */:
                    RZCAddCanDashBoard.this.updateSpeed();
                    break;
                case ConstRzcAddData.U_CAR_TOTAL_MILEAGE /* 512 */:
                    RZCAddCanDashBoard.this.updateTotalMile();
                    break;
                case ConstRzcAddData.U_CAR_DRIVENABLE_MILEAGE /* 513 */:
                    RZCAddCanDashBoard.this.updateDrivenableMile();
                    break;
                case ConstRzcAddData.U_CAR_SEAT_BELT_LEFT /* 514 */:
                    RZCAddCanDashBoard.this.mUpdaterLifeBeltLeft(DataCanbus.DATA[514]);
                    break;
                case ConstRzcAddData.U_CAR_SEAT_BELT_RIGHT /* 515 */:
                    RZCAddCanDashBoard.this.mUpdaterLifeBeltRight(DataCanbus.DATA[515]);
                    break;
                case ConstRzcAddData.U_CAR_HANDBRAKE /* 519 */:
                    int value7 = DataCanbus.DATA[519];
                    ImageView imageView10 = (ImageView) RZCAddCanDashBoard.this.findViewById(R.id.image_handbrak);
                    Resources resources10 = RZCAddCanDashBoard.this.getResources();
                    if (value7 == 1) {
                        i2 = R.drawable.ic_dashboard_top_hand;
                    }
                    imageView10.setImageDrawable(resources10.getDrawable(i2));
                    break;
                case ConstRzcAddData.U_CAR_CUR_FUEL /* 520 */:
                    int value8 = DataCanbus.DATA[520];
                    ((TextView) RZCAddCanDashBoard.this.findViewById(R.id.txt_car_curfuel)).setText(String.valueOf(value8 / 10) + "." + (value8 % 10) + "L/100km");
                    break;
                case ConstRzcAddData.U_CAR_AVG_FUEL /* 521 */:
                    int value9 = DataCanbus.DATA[521];
                    ((TextView) RZCAddCanDashBoard.this.findViewById(R.id.txt_car_avgfuel)).setText(String.valueOf(value9 / 10) + "." + (value9 % 10) + "L/100km");
                    break;
                case ConstRzcAddData.U_CAR_TEMP_WATER /* 522 */:
                    int value10 = DataCanbus.DATA[522];
                    ((TextView) RZCAddCanDashBoard.this.findViewById(R.id.txt_car_water_temp)).setText(String.format("%d ℃", Integer.valueOf(value10 - 40)));
                    break;
                case ConstRzcAddData.U_CAR_TEMP_MOTOR_OIL /* 523 */:
                    int value11 = DataCanbus.DATA[523];
                    ((TextView) RZCAddCanDashBoard.this.findViewById(R.id.txt_car_oil_temp)).setText(String.format("%d ℃", Integer.valueOf(value11 - 40)));
                    break;
                case ConstRzcAddData.U_CAR_ENGINE_SPEED /* 524 */:
                    int value12 = DataCanbus.DATA[524];
                    ((TextView) RZCAddCanDashBoard.this.findViewById(R.id.txt_car_engine_speed)).setText(new StringBuilder().append(value12 / 4).toString());
                    ((InfoView) RZCAddCanDashBoard.this.findViewById(R.id.infoView_enginespeed)).setSpeed(value12 / 4);
                    break;
                case ConstRzcAddData.U_CAR_VOLTAGE /* 525 */:
                    int value13 = DataCanbus.DATA[525];
                    ((TextView) RZCAddCanDashBoard.this.findViewById(R.id.txt_car_voltage)).setText(String.valueOf(value13 / 1000) + "." + ((value13 % 1000) / 100) + "V");
                    break;
                case ConstRzcAddData.U_DOOR_ENGINE_ADD /* 553 */:
                    int value14 = DataCanbus.DATA[553];
                    ImageView imageView11 = (ImageView) RZCAddCanDashBoard.this.findViewById(R.id.image_car_door_engine);
                    Resources resources11 = RZCAddCanDashBoard.this.getResources();
                    if (value14 == 1) {
                        i2 = R.drawable.ic_dashboard_car_door_engine;
                    }
                    imageView11.setImageDrawable(resources11.getDrawable(i2));
                    break;
                case ConstRzcAddData.U_DOOR_FL_ADD /* 554 */:
                    int value15 = DataCanbus.DATA[554];
                    ImageView imageView12 = (ImageView) RZCAddCanDashBoard.this.findViewById(R.id.image_car_door_fl);
                    Resources resources12 = RZCAddCanDashBoard.this.getResources();
                    if (value15 == 1) {
                        i2 = R.drawable.ic_dashboard_car_door_fl;
                    }
                    imageView12.setImageDrawable(resources12.getDrawable(i2));
                    break;
                case ConstRzcAddData.U_DOOR_FR_ADD /* 555 */:
                    int value16 = DataCanbus.DATA[555];
                    ImageView imageView13 = (ImageView) RZCAddCanDashBoard.this.findViewById(R.id.image_car_door_fr);
                    Resources resources13 = RZCAddCanDashBoard.this.getResources();
                    if (value16 == 1) {
                        i2 = R.drawable.ic_dashboard_car_door_fr;
                    }
                    imageView13.setImageDrawable(resources13.getDrawable(i2));
                    break;
                case ConstRzcAddData.U_DOOR_RL_ADD /* 556 */:
                    int value17 = DataCanbus.DATA[556];
                    ImageView imageView14 = (ImageView) RZCAddCanDashBoard.this.findViewById(R.id.image_car_door_rl);
                    Resources resources14 = RZCAddCanDashBoard.this.getResources();
                    if (value17 == 1) {
                        i2 = R.drawable.ic_dashboard_car_door_rl;
                    }
                    imageView14.setImageDrawable(resources14.getDrawable(i2));
                    break;
                case ConstRzcAddData.U_DOOR_RR_ADD /* 557 */:
                    int value18 = DataCanbus.DATA[557];
                    ImageView imageView15 = (ImageView) RZCAddCanDashBoard.this.findViewById(R.id.image_car_door_rr);
                    Resources resources15 = RZCAddCanDashBoard.this.getResources();
                    if (value18 == 1) {
                        i2 = R.drawable.ic_dashboard_car_door_rr;
                    }
                    imageView15.setImageDrawable(resources15.getDrawable(i2));
                    break;
                case ConstRzcAddData.U_DOOR_BACK_ADD /* 558 */:
                    int value19 = DataCanbus.DATA[558];
                    ImageView imageView16 = (ImageView) RZCAddCanDashBoard.this.findViewById(R.id.image_car_door_rear);
                    Resources resources16 = RZCAddCanDashBoard.this.getResources();
                    if (value19 == 1) {
                        i2 = R.drawable.ic_dashboard_car_door_rear;
                    }
                    imageView16.setImageDrawable(resources16.getDrawable(i2));
                    break;
                case ConstRzcAddData.U_SPEED_UNIT /* 559 */:
                    RZCAddCanDashBoard.this.unit = DataCanbus.DATA[559];
                    if (RZCAddCanDashBoard.this.unit == 0) {
                        ((TextView) RZCAddCanDashBoard.this.findViewById(R.id.txt_car_speed_unit)).setText("km/h");
                    } else {
                        ((TextView) RZCAddCanDashBoard.this.findViewById(R.id.txt_car_speed_unit)).setText("mp/h");
                    }
                    RZCAddCanDashBoard.this.updateSpeed();
                    RZCAddCanDashBoard.this.updateTotalMile();
                    RZCAddCanDashBoard.this.updateDrivenableMile();
                    break;
            }
        }
    };
    int num = 0;
    Runnable mShowTurnLeftLight = new Runnable() { // from class: com.syu.carinfo.rzc.addcan.RZCAddCanDashBoard.2
        @Override // java.lang.Runnable
        public void run() {
            int i = R.drawable.ic_dashboard_car_null;
            RZCAddCanDashBoard.this.num++;
            if (RZCAddCanDashBoard.this.num > 1) {
                RZCAddCanDashBoard.this.num = 0;
            }
            ((ImageView) RZCAddCanDashBoard.this.findViewById(R.id.image_car_turnl_light)).setImageDrawable(RZCAddCanDashBoard.this.getResources().getDrawable(RZCAddCanDashBoard.this.num == 1 ? R.drawable.ic_dashboard_car_turnl_light : 2130839521));
            ImageView imageView = (ImageView) RZCAddCanDashBoard.this.findViewById(R.id.image_car_turnl_top);
            Resources resources = RZCAddCanDashBoard.this.getResources();
            if (RZCAddCanDashBoard.this.num == 1) {
                i = R.drawable.ic_dashboard_car_turnltop;
            }
            imageView.setImageDrawable(resources.getDrawable(i));
            HandlerUI.getInstance().removeCallbacks(RZCAddCanDashBoard.this.mShowTurnLeftLight);
            HandlerUI.getInstance().postDelayed(RZCAddCanDashBoard.this.mShowTurnLeftLight, 500L);
        }
    };
    int num1 = 0;
    Runnable mShowTurnRightLight = new Runnable() { // from class: com.syu.carinfo.rzc.addcan.RZCAddCanDashBoard.3
        @Override // java.lang.Runnable
        public void run() {
            int i = R.drawable.ic_dashboard_car_null;
            RZCAddCanDashBoard.this.num1++;
            if (RZCAddCanDashBoard.this.num1 > 1) {
                RZCAddCanDashBoard.this.num1 = 0;
            }
            ((ImageView) RZCAddCanDashBoard.this.findViewById(R.id.image_car_turnr_light)).setImageDrawable(RZCAddCanDashBoard.this.getResources().getDrawable(RZCAddCanDashBoard.this.num1 == 1 ? R.drawable.ic_dashboard_car_turnr_light : 2130839521));
            ImageView imageView = (ImageView) RZCAddCanDashBoard.this.findViewById(R.id.image_car_turnr_top);
            Resources resources = RZCAddCanDashBoard.this.getResources();
            if (RZCAddCanDashBoard.this.num1 == 1) {
                i = R.drawable.ic_dashboard_car_turnrtop;
            }
            imageView.setImageDrawable(resources.getDrawable(i));
            HandlerUI.getInstance().removeCallbacks(RZCAddCanDashBoard.this.mShowTurnRightLight);
            HandlerUI.getInstance().postDelayed(RZCAddCanDashBoard.this.mShowTurnRightLight, 500L);
        }
    };
    int num2 = 0;
    Runnable mShowLifeBelt_left = new Runnable() { // from class: com.syu.carinfo.rzc.addcan.RZCAddCanDashBoard.4
        @Override // java.lang.Runnable
        public void run() {
            RZCAddCanDashBoard.this.num2++;
            if (RZCAddCanDashBoard.this.num2 > 1) {
                RZCAddCanDashBoard.this.num2 = 0;
            }
            ((ImageView) RZCAddCanDashBoard.this.findViewById(R.id.image_car_lifebelt_left)).setImageDrawable(RZCAddCanDashBoard.this.getResources().getDrawable(RZCAddCanDashBoard.this.num2 == 1 ? R.drawable.ic_dashboard_top_lifebelt : R.drawable.ic_dashboard_car_null));
            HandlerUI.getInstance().removeCallbacks(RZCAddCanDashBoard.this.mShowLifeBelt_left);
            HandlerUI.getInstance().postDelayed(RZCAddCanDashBoard.this.mShowLifeBelt_left, 500L);
        }
    };
    int num3 = 0;
    Runnable mShowLifeBelt_right = new Runnable() { // from class: com.syu.carinfo.rzc.addcan.RZCAddCanDashBoard.5
        @Override // java.lang.Runnable
        public void run() {
            RZCAddCanDashBoard.this.num3++;
            if (RZCAddCanDashBoard.this.num3 > 1) {
                RZCAddCanDashBoard.this.num3 = 0;
            }
            ((ImageView) RZCAddCanDashBoard.this.findViewById(R.id.image_car_lifebelt_right)).setImageDrawable(RZCAddCanDashBoard.this.getResources().getDrawable(RZCAddCanDashBoard.this.num2 == 1 ? R.drawable.ic_dashboard_top_lifebelt : R.drawable.ic_dashboard_car_null));
            HandlerUI.getInstance().removeCallbacks(RZCAddCanDashBoard.this.mShowLifeBelt_right);
            HandlerUI.getInstance().postDelayed(RZCAddCanDashBoard.this.mShowLifeBelt_right, 500L);
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String platform = SystemProperties.get("ro.fyt.platform", "");
        if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform)) {
            setContentView(R.layout.layout_rzc_addcan_dashboard_9853);
        } else {
            setContentView(R.layout.layout_rzc_addcan_dashboard);
        }
        init();
    }

    public void init() {
        ((Button) findViewById(R.id.btn_speed_unit_change)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.addcan.RZCAddCanDashBoard.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[559];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(101, iArr, null, null);
            }
        });
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        DoorHelper.disableDoorWindowLocal(true);
        DataCanbus.PROXY.cmd(100, new int[]{1}, null, null);
        mIsFront = true;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        DoorHelper.disableDoorWindowLocal(false);
        DataCanbus.PROXY.cmd(100, new int[1], null, null);
        mIsFront = false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[553].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[554].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[555].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[556].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[557].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[558].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[501].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[502].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[503].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[504].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[505].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[506].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[507].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[508].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[509].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[510].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[511].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[512].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[513].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[514].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[515].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[516].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[517].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[518].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[519].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[520].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[521].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[522].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[523].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[524].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[525].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[559].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[553].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[554].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[555].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[556].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[557].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[558].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[501].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[502].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[503].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[504].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[505].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[506].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[507].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[508].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[509].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[510].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[511].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[512].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[513].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[514].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[515].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[516].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[517].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[518].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[519].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[520].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[521].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[522].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[523].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[524].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[525].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[559].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpeed() {
        int speed = DataCanbus.DATA[510];
        switch (this.unit) {
            case 0:
                ((InfoView2) findViewById(R.id.infoView_speed)).setSpeed(speed / 100);
                ((TextView) findViewById(R.id.txt_car_speed)).setText(String.valueOf(speed / 100) + "." + ((speed % 100) / 10));
                break;
            case 1:
                int speed2 = speed / 16;
                ((InfoView2) findViewById(R.id.infoView_speed)).setSpeed(speed2 / 10);
                ((TextView) findViewById(R.id.txt_car_speed)).setText(String.valueOf(speed2 / 10) + "." + (speed2 % 10));
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTotalMile() {
        int value = DataCanbus.DATA[512];
        if (this.unit == 0) {
            ((TextView) findViewById(R.id.txt_car_total_mileage)).setText(String.format("%dkm", Integer.valueOf(value)));
        } else {
            ((TextView) findViewById(R.id.txt_car_total_mileage)).setText(String.format("%dmil", Integer.valueOf((value * 10) / 16)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDrivenableMile() {
        int value = DataCanbus.DATA[513];
        if (this.unit == 0) {
            ((TextView) findViewById(R.id.txt_car_mileage)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km");
        } else {
            int value2 = (value * 10) / 16;
            ((TextView) findViewById(R.id.txt_car_mileage)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "mil");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTurnleftLight(int value) {
        if (value == 1) {
            HandlerUI.getInstance().removeCallbacks(this.mShowTurnLeftLight);
            HandlerUI.getInstance().postDelayed(this.mShowTurnLeftLight, 500L);
        } else {
            HandlerUI.getInstance().removeCallbacks(this.mShowTurnLeftLight);
            ((ImageView) findViewById(R.id.image_car_turnl_light)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dashboard_car_null));
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
            ((ImageView) findViewById(R.id.image_car_turnr_light)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dashboard_car_null));
            ((ImageView) findViewById(R.id.image_car_turnr_top)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dashboard_car_null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLifeBeltLeft(int value) {
        if (value == 1) {
            HandlerUI.getInstance().removeCallbacks(this.mShowLifeBelt_left);
            HandlerUI.getInstance().postDelayed(this.mShowLifeBelt_left, 500L);
        } else {
            HandlerUI.getInstance().removeCallbacks(this.mShowLifeBelt_left);
            ((ImageView) findViewById(R.id.image_car_lifebelt_left)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dashboard_car_null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLifeBeltRight(int value) {
        if (value == 1) {
            HandlerUI.getInstance().removeCallbacks(this.mShowLifeBelt_right);
            HandlerUI.getInstance().postDelayed(this.mShowLifeBelt_right, 500L);
        } else {
            HandlerUI.getInstance().removeCallbacks(this.mShowLifeBelt_right);
            ((ImageView) findViewById(R.id.image_car_lifebelt_right)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dashboard_car_null));
        }
    }
}
