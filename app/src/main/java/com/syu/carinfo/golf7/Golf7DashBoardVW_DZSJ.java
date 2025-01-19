package com.syu.carinfo.golf7;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

public class Golf7DashBoardVW_DZSJ extends Activity {
    public static Golf7DashBoardVW_DZSJ mInstance;
    public static boolean mIsFront = false;
    int unit = 0;
    int infonum1 = 0;
    int infonum2 = 0;
    int curnum = 0;
    int curnum1 = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = R.drawable.ic_dashboard_car_null;
            switch (updateCode) {
                case 0:
                    int value = DataCanbus.DATA[0];
                    ImageView imageView = (ImageView) Golf7DashBoardVW_DZSJ.this.findViewById(R.id.image_car_door_engine);
                    Resources resources = Golf7DashBoardVW_DZSJ.this.getResources();
                    if (value == 1) {
                        i = R.drawable.ic_dashboard_car_door_engine;
                    }
                    imageView.setImageDrawable(resources.getDrawable(i));
                    break;
                case 1:
                    int value2 = DataCanbus.DATA[1];
                    ImageView imageView2 = (ImageView) Golf7DashBoardVW_DZSJ.this.findViewById(R.id.image_car_door_fl);
                    Resources resources2 = Golf7DashBoardVW_DZSJ.this.getResources();
                    if (value2 == 1) {
                        i = R.drawable.ic_dashboard_car_door_fl;
                    }
                    imageView2.setImageDrawable(resources2.getDrawable(i));
                    break;
                case 2:
                    int value3 = DataCanbus.DATA[2];
                    ImageView imageView3 = (ImageView) Golf7DashBoardVW_DZSJ.this.findViewById(R.id.image_car_door_fr);
                    Resources resources3 = Golf7DashBoardVW_DZSJ.this.getResources();
                    if (value3 == 1) {
                        i = R.drawable.ic_dashboard_car_door_fr;
                    }
                    imageView3.setImageDrawable(resources3.getDrawable(i));
                    break;
                case 3:
                    int value4 = DataCanbus.DATA[3];
                    ImageView imageView4 = (ImageView) Golf7DashBoardVW_DZSJ.this.findViewById(R.id.image_car_door_rl);
                    Resources resources4 = Golf7DashBoardVW_DZSJ.this.getResources();
                    if (value4 == 1) {
                        i = R.drawable.ic_dashboard_car_door_rl;
                    }
                    imageView4.setImageDrawable(resources4.getDrawable(i));
                    break;
                case 4:
                    int value5 = DataCanbus.DATA[4];
                    ImageView imageView5 = (ImageView) Golf7DashBoardVW_DZSJ.this.findViewById(R.id.image_car_door_rr);
                    Resources resources5 = Golf7DashBoardVW_DZSJ.this.getResources();
                    if (value5 == 1) {
                        i = R.drawable.ic_dashboard_car_door_rr;
                    }
                    imageView5.setImageDrawable(resources5.getDrawable(i));
                    break;
                case 5:
                    int value6 = DataCanbus.DATA[5];
                    ImageView imageView6 = (ImageView) Golf7DashBoardVW_DZSJ.this.findViewById(R.id.image_car_door_rear);
                    Resources resources6 = Golf7DashBoardVW_DZSJ.this.getResources();
                    if (value6 == 1) {
                        i = R.drawable.ic_dashboard_car_door_rear;
                    }
                    imageView6.setImageDrawable(resources6.getDrawable(i));
                    break;
                case 97:
                case 99:
                case 100:
                case 101:
                case 102:
                case 104:
                case 105:
                case 106:
                    Golf7DashBoardVW_DZSJ.this.mUpdaterDashBoardinfo1(Golf7DashBoardVW_DZSJ.this.infonum1);
                    break;
                case 107:
                case 109:
                case 110:
                case 111:
                    Golf7DashBoardVW_DZSJ.this.mUpdaterDashBoardinfo2(Golf7DashBoardVW_DZSJ.this.infonum2);
                    break;
                case 188:
                    ((InfoView2) Golf7DashBoardVW_DZSJ.this.findViewById(R.id.infoView_dzsj2)).setSpeed(DataCanbus.DATA[188]);
                    Golf7DashBoardVW_DZSJ.this.mUpdaterDashBoardinfo2(Golf7DashBoardVW_DZSJ.this.infonum2);
                    break;
                case 189:
                    ((InfoView) Golf7DashBoardVW_DZSJ.this.findViewById(R.id.infoView_dzsj1)).setSpeed(DataCanbus.DATA[189]);
                    Golf7DashBoardVW_DZSJ.this.mUpdaterDashBoardinfo1(Golf7DashBoardVW_DZSJ.this.infonum1);
                    break;
                case 265:
                    int value7 = DataCanbus.DATA[265] - 40;
                    if (value7 <= 90) {
                        ((InfoView_Small1) Golf7DashBoardVW_DZSJ.this.findViewById(R.id.infoView_dzsj3)).setSpeed(90 - value7);
                        break;
                    } else {
                        ((InfoView_Small1) Golf7DashBoardVW_DZSJ.this.findViewById(R.id.infoView_dzsj3)).setSpeed(1800 - (value7 - 90));
                        break;
                    }
                case 278:
                    int value8 = DataCanbus.DATA[278];
                    int maxoil = 25;
                    int type = 0;
                    switch (DataCanbus.DATA[295]) {
                        case 0:
                            maxoil = 25;
                            type = 0;
                            break;
                        case 1:
                            maxoil = 28;
                            type = 1;
                            break;
                        case 2:
                            maxoil = 29;
                            type = 2;
                            break;
                        case 3:
                            maxoil = 30;
                            type = 3;
                            break;
                        case 4:
                            maxoil = 32;
                            type = 4;
                            break;
                        case 5:
                            maxoil = 33;
                            type = 5;
                            break;
                        case 6:
                            maxoil = 35;
                            type = 6;
                            break;
                    }
                    if (value8 <= maxoil) {
                        ((InfoView_Small2) Golf7DashBoardVW_DZSJ.this.findViewById(R.id.infoView_dzsj4)).setSpeed(maxoil - value8, type);
                        break;
                    } else {
                        ((InfoView_Small2) Golf7DashBoardVW_DZSJ.this.findViewById(R.id.infoView_dzsj4)).setSpeed(((maxoil * 360) / 26) - (value8 - maxoil), type);
                        break;
                    }
                case 288:
                    int value9 = DataCanbus.DATA[288];
                    ((ImageView) Golf7DashBoardVW_DZSJ.this.findViewById(R.id.image_car_light)).setImageDrawable(Golf7DashBoardVW_DZSJ.this.getResources().getDrawable(value9 == 1 ? R.drawable.ic_dashboard_car_light : 2130840179));
                    ImageView imageView7 = (ImageView) Golf7DashBoardVW_DZSJ.this.findViewById(R.id.image_light);
                    Resources resources7 = Golf7DashBoardVW_DZSJ.this.getResources();
                    if (value9 == 1) {
                        i = R.drawable.ic_dashboard_top_light;
                    }
                    imageView7.setImageDrawable(resources7.getDrawable(i));
                    break;
                case 290:
                    Golf7DashBoardVW_DZSJ.this.mUpdaterLifeBelt(DataCanbus.DATA[290]);
                    break;
                case 291:
                    Golf7DashBoardVW_DZSJ.this.mUpdaterTurnleftLight(DataCanbus.DATA[291]);
                    break;
                case 292:
                    Golf7DashBoardVW_DZSJ.this.mUpdaterTurnrightLight(DataCanbus.DATA[292]);
                    break;
            }
        }
    };
    int num2 = 0;
    Runnable mShowLifeBelt = new Runnable() { 
        @Override
        public void run() {
            Golf7DashBoardVW_DZSJ.this.num2++;
            if (Golf7DashBoardVW_DZSJ.this.num2 > 1) {
                Golf7DashBoardVW_DZSJ.this.num2 = 0;
            }
            ((ImageView) Golf7DashBoardVW_DZSJ.this.findViewById(R.id.image_car_lifebelt)).setImageDrawable(Golf7DashBoardVW_DZSJ.this.getResources().getDrawable(Golf7DashBoardVW_DZSJ.this.num2 == 1 ? R.drawable.ic_dashboard_top_lifebelt : R.drawable.ic_dashboard_car_null));
            HandlerUI.getInstance().removeCallbacks(Golf7DashBoardVW_DZSJ.this.mShowLifeBelt);
            HandlerUI.getInstance().postDelayed(Golf7DashBoardVW_DZSJ.this.mShowLifeBelt, 500L);
        }
    };
    int num = 0;
    Runnable mShowTurnLeftLight = new Runnable() { 
        @Override
        public void run() {
            int i = R.drawable.ic_dashboard_car_null;
            Golf7DashBoardVW_DZSJ.this.num++;
            if (Golf7DashBoardVW_DZSJ.this.num > 1) {
                Golf7DashBoardVW_DZSJ.this.num = 0;
            }
            ((ImageView) Golf7DashBoardVW_DZSJ.this.findViewById(R.id.image_car_turnl_light)).setImageDrawable(Golf7DashBoardVW_DZSJ.this.getResources().getDrawable(Golf7DashBoardVW_DZSJ.this.num == 1 ? R.drawable.ic_dashboard_car_turnl_light : 2130840179));
            ImageView imageView = (ImageView) Golf7DashBoardVW_DZSJ.this.findViewById(R.id.image_car_turnl_top);
            Resources resources = Golf7DashBoardVW_DZSJ.this.getResources();
            if (Golf7DashBoardVW_DZSJ.this.num == 1) {
                i = R.drawable.ic_dashboard_car_turnltop;
            }
            imageView.setImageDrawable(resources.getDrawable(i));
            HandlerUI.getInstance().removeCallbacks(Golf7DashBoardVW_DZSJ.this.mShowTurnLeftLight);
            HandlerUI.getInstance().postDelayed(Golf7DashBoardVW_DZSJ.this.mShowTurnLeftLight, 500L);
        }
    };
    int num1 = 0;
    Runnable mShowTurnRightLight = new Runnable() { 
        @Override
        public void run() {
            int i = R.drawable.ic_dashboard_car_null;
            Golf7DashBoardVW_DZSJ.this.num1++;
            if (Golf7DashBoardVW_DZSJ.this.num1 > 1) {
                Golf7DashBoardVW_DZSJ.this.num1 = 0;
            }
            ((ImageView) Golf7DashBoardVW_DZSJ.this.findViewById(R.id.image_car_turnr_light)).setImageDrawable(Golf7DashBoardVW_DZSJ.this.getResources().getDrawable(Golf7DashBoardVW_DZSJ.this.num1 == 1 ? R.drawable.ic_dashboard_car_turnr_light : 2130840179));
            ImageView imageView = (ImageView) Golf7DashBoardVW_DZSJ.this.findViewById(R.id.image_car_turnr_top);
            Resources resources = Golf7DashBoardVW_DZSJ.this.getResources();
            if (Golf7DashBoardVW_DZSJ.this.num1 == 1) {
                i = R.drawable.ic_dashboard_car_turnrtop;
            }
            imageView.setImageDrawable(resources.getDrawable(i));
            HandlerUI.getInstance().removeCallbacks(Golf7DashBoardVW_DZSJ.this.mShowTurnRightLight);
            HandlerUI.getInstance().postDelayed(Golf7DashBoardVW_DZSJ.this.mShowTurnRightLight, 500L);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        //setContentView(R.layout.layout_golf_dashboard_dzsj);
        init();
        mInstance = this;
    }

    public void init() {
        ((Button) findViewById(R.id.glf7_btn_car_back_od)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Golf7DashBoardVW_DZSJ.this.finish();
            }
        });
        ((Button) findViewById(R.id.glf7_btn_car_infochange_dzsj1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Golf7DashBoardVW_DZSJ.this.infonum1++;
                if (Golf7DashBoardVW_DZSJ.this.infonum1 > 8) {
                    Golf7DashBoardVW_DZSJ.this.infonum1 = 0;
                }
                Golf7DashBoardVW_DZSJ.this.mUpdaterDashBoardinfo1(Golf7DashBoardVW_DZSJ.this.infonum1);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_car_infochange_dzsj2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Golf7DashBoardVW_DZSJ.this.infonum2++;
                if (Golf7DashBoardVW_DZSJ.this.infonum2 > 4) {
                    Golf7DashBoardVW_DZSJ.this.infonum2 = 0;
                }
                Golf7DashBoardVW_DZSJ.this.mUpdaterDashBoardinfo2(Golf7DashBoardVW_DZSJ.this.infonum2);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[278].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[265].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[288].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[291].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[292].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[289].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[290].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[295].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[278].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[265].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[288].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[291].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[292].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[289].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[290].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[295].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterDashBoardinfo1(int data) {
        switch (data) {
            case 0:
                int value = DataCanbus.DATA[97];
                ((TextView) findViewById(R.id.golf_dashboard1_info)).setText(R.string.vehicle_detail_status_since_start1);
                if (value != 65535) {
                    ((TextView) findViewById(R.id.golf_dashboard1_info2)).setText(String.valueOf(LauncherApplication.getInstance().getResources().getString(R.string.average1)) + " " + String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                } else {
                    ((TextView) findViewById(R.id.golf_dashboard1_info2)).setText("--.--");
                }
                ((TextView) findViewById(R.id.golf_dashboard1_info3)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                break;
            case 1:
                int value2 = DataCanbus.DATA[101];
                ((TextView) findViewById(R.id.golf_dashboard1_info)).setText(R.string.vehicle_detail_status_since_start1);
                ((TextView) findViewById(R.id.golf_dashboard1_info2)).setText(String.valueOf(LauncherApplication.getInstance().getResources().getString(R.string.average1)) + " " + String.format("%d", Integer.valueOf(value2)));
                ((TextView) findViewById(R.id.golf_dashboard1_info3)).setText("km/H");
                break;
            case 2:
                int value3 = DataCanbus.DATA[99];
                ((TextView) findViewById(R.id.golf_dashboard1_info)).setText(R.string.vehicle_detail_status_since_start1);
                ((TextView) findViewById(R.id.golf_dashboard1_info2)).setText(String.valueOf(LauncherApplication.getInstance().getResources().getString(R.string.str_227_drivered1)) + " " + String.format("%d.%d", Integer.valueOf(value3 / 10), Integer.valueOf(value3 % 10)));
                ((TextView) findViewById(R.id.golf_dashboard1_info3)).setText("km");
                break;
            case 3:
                int value4 = DataCanbus.DATA[100];
                ((TextView) findViewById(R.id.golf_dashboard1_info)).setText(R.string.vehicle_detail_status_since_start1);
                ((TextView) findViewById(R.id.golf_dashboard1_info2)).setText(String.valueOf(LauncherApplication.getInstance().getResources().getString(R.string.str_227_drivered1)) + " " + (value4 / 60) + ":" + (value4 % 60));
                ((TextView) findViewById(R.id.golf_dashboard1_info3)).setText("h");
                break;
            case 4:
                int value5 = DataCanbus.DATA[102];
                ((TextView) findViewById(R.id.golf_dashboard1_info)).setText(R.string.vehicle_detail_status_long_term1);
                if (value5 != 65535) {
                    ((TextView) findViewById(R.id.golf_dashboard1_info2)).setText(String.valueOf(LauncherApplication.getInstance().getResources().getString(R.string.average1)) + " " + String.format("%d.%d", Integer.valueOf(value5 / 10), Integer.valueOf(value5 % 10)));
                } else {
                    ((TextView) findViewById(R.id.golf_dashboard1_info2)).setText("--.--");
                }
                ((TextView) findViewById(R.id.golf_dashboard1_info3)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                break;
            case 5:
                int value6 = DataCanbus.DATA[106];
                ((TextView) findViewById(R.id.golf_dashboard1_info)).setText(R.string.vehicle_detail_status_long_term1);
                ((TextView) findViewById(R.id.golf_dashboard1_info2)).setText(String.valueOf(LauncherApplication.getInstance().getResources().getString(R.string.average1)) + " " + String.format("%d", Integer.valueOf(value6)));
                ((TextView) findViewById(R.id.golf_dashboard1_info3)).setText("km/h");
                break;
            case 6:
                int value7 = DataCanbus.DATA[104];
                ((TextView) findViewById(R.id.golf_dashboard1_info)).setText(R.string.vehicle_detail_status_long_term1);
                ((TextView) findViewById(R.id.golf_dashboard1_info2)).setText(String.valueOf(LauncherApplication.getInstance().getResources().getString(R.string.str_227_drivered1)) + " " + String.format("%d.%d", Integer.valueOf(value7 / 10), Integer.valueOf(value7 % 10)));
                ((TextView) findViewById(R.id.golf_dashboard1_info3)).setText("km");
                break;
            case 7:
                int value8 = DataCanbus.DATA[105];
                ((TextView) findViewById(R.id.golf_dashboard1_info)).setText(R.string.vehicle_detail_status_long_term1);
                ((TextView) findViewById(R.id.golf_dashboard1_info2)).setText(String.valueOf(LauncherApplication.getInstance().getResources().getString(R.string.str_227_drivered1)) + " " + (value8 / 60) + ":" + (value8 % 60));
                ((TextView) findViewById(R.id.golf_dashboard1_info3)).setText("h");
                break;
            case 8:
                int value9 = DataCanbus.DATA[189];
                ((TextView) findViewById(R.id.golf_dashboard1_info)).setText("");
                ((TextView) findViewById(R.id.golf_dashboard1_info2)).setText(String.format("%d", Integer.valueOf(value9)));
                ((TextView) findViewById(R.id.golf_dashboard1_info3)).setText("rpm");
                break;
        }
    }

    
    public void mUpdaterDashBoardinfo2(int data) {
        switch (data) {
            case 0:
                int value = DataCanbus.DATA[188];
                ((TextView) findViewById(R.id.golf_dashboard2_info)).setText("");
                ((TextView) findViewById(R.id.golf_dashboard2_info2)).setText(String.format("%d", Integer.valueOf(value)));
                ((TextView) findViewById(R.id.golf_dashboard2_info3)).setText("km/h");
                break;
            case 1:
                int value2 = DataCanbus.DATA[107];
                ((TextView) findViewById(R.id.golf_dashboard2_info)).setText(R.string.vehicle_detail_status_since_refuelling1);
                if (value2 != 65535) {
                    ((TextView) findViewById(R.id.golf_dashboard2_info2)).setText(String.valueOf(LauncherApplication.getInstance().getResources().getString(R.string.average1)) + " " + String.format("%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10)));
                } else {
                    ((TextView) findViewById(R.id.golf_dashboard2_info2)).setText("--.--");
                }
                ((TextView) findViewById(R.id.golf_dashboard2_info3)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                break;
            case 2:
                int value3 = DataCanbus.DATA[111];
                ((TextView) findViewById(R.id.golf_dashboard2_info)).setText(R.string.vehicle_detail_status_since_refuelling1);
                ((TextView) findViewById(R.id.golf_dashboard2_info2)).setText(String.valueOf(LauncherApplication.getInstance().getResources().getString(R.string.average1)) + " " + String.format("%d", Integer.valueOf(value3)));
                ((TextView) findViewById(R.id.golf_dashboard2_info3)).setText("km/h");
                break;
            case 3:
                int value4 = DataCanbus.DATA[109];
                ((TextView) findViewById(R.id.golf_dashboard2_info)).setText(R.string.vehicle_detail_status_since_refuelling1);
                ((TextView) findViewById(R.id.golf_dashboard2_info2)).setText(String.valueOf(LauncherApplication.getInstance().getResources().getString(R.string.str_227_drivered1)) + " " + String.format("%d.%d", Integer.valueOf(value4 / 10), Integer.valueOf(value4 % 10)));
                ((TextView) findViewById(R.id.golf_dashboard2_info3)).setText("km");
                break;
            case 4:
                int value5 = DataCanbus.DATA[110];
                ((TextView) findViewById(R.id.golf_dashboard2_info)).setText(R.string.vehicle_detail_status_since_refuelling1);
                ((TextView) findViewById(R.id.golf_dashboard2_info2)).setText(String.valueOf(LauncherApplication.getInstance().getResources().getString(R.string.str_227_drivered1)) + " " + (value5 / 60) + ":" + (value5 % 60));
                ((TextView) findViewById(R.id.golf_dashboard2_info3)).setText("h");
                break;
        }
    }

    
    public void mUpdaterLifeBelt(int value) {
        if (value == 1) {
            HandlerUI.getInstance().removeCallbacks(this.mShowLifeBelt);
            HandlerUI.getInstance().postDelayed(this.mShowLifeBelt, 500L);
        } else {
            HandlerUI.getInstance().removeCallbacks(this.mShowLifeBelt);
            ((ImageView) findViewById(R.id.image_car_lifebelt)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dashboard_car_null));
        }
    }

    
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
}
