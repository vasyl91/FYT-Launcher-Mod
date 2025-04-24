package com.syu.carinfo.dasauto;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.carinfo.golf7.InfoView3;
import com.syu.carinfo.golf7.InfoView4;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerUI;

@SuppressWarnings({"deprecation", "unchecked"})
public class VwDashBoard_DZSJ extends Activity {
    public static VwDashBoard_DZSJ mInstance;
    public static boolean mIsFront = false;
    public int infonum1 = 0;
    public int infonum2 = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = R.drawable.ic_dashboard_car_null;
            switch (updateCode) {
                case 0:
                    int value = DataCanbus.DATA[0];
                    ImageView imageView = (ImageView) VwDashBoard_DZSJ.this.findViewById(R.id.image_car_door_engine);
                    Resources resources = VwDashBoard_DZSJ.this.getResources();
                    if (value == 1) {
                        i = R.drawable.ic_dashboard_car_door_engine;
                    }
                    imageView.setImageDrawable(resources.getDrawable(i));
                    break;
                case 1:
                    int value2 = DataCanbus.DATA[1];
                    ImageView imageView2 = (ImageView) VwDashBoard_DZSJ.this.findViewById(R.id.image_car_door_fl);
                    Resources resources2 = VwDashBoard_DZSJ.this.getResources();
                    if (value2 == 1) {
                        i = R.drawable.ic_dashboard_car_door_fl;
                    }
                    imageView2.setImageDrawable(resources2.getDrawable(i));
                    break;
                case 2:
                    int value3 = DataCanbus.DATA[2];
                    ImageView imageView3 = (ImageView) VwDashBoard_DZSJ.this.findViewById(R.id.image_car_door_fr);
                    Resources resources3 = VwDashBoard_DZSJ.this.getResources();
                    if (value3 == 1) {
                        i = R.drawable.ic_dashboard_car_door_fr;
                    }
                    imageView3.setImageDrawable(resources3.getDrawable(i));
                    break;
                case 3:
                    int value4 = DataCanbus.DATA[3];
                    ImageView imageView4 = (ImageView) VwDashBoard_DZSJ.this.findViewById(R.id.image_car_door_rl);
                    Resources resources4 = VwDashBoard_DZSJ.this.getResources();
                    if (value4 == 1) {
                        i = R.drawable.ic_dashboard_car_door_rl;
                    }
                    imageView4.setImageDrawable(resources4.getDrawable(i));
                    break;
                case 4:
                    int value5 = DataCanbus.DATA[4];
                    ImageView imageView5 = (ImageView) VwDashBoard_DZSJ.this.findViewById(R.id.image_car_door_rr);
                    Resources resources5 = VwDashBoard_DZSJ.this.getResources();
                    if (value5 == 1) {
                        i = R.drawable.ic_dashboard_car_door_rr;
                    }
                    imageView5.setImageDrawable(resources5.getDrawable(i));
                    break;
                case 5:
                    int value6 = DataCanbus.DATA[5];
                    ImageView imageView6 = (ImageView) VwDashBoard_DZSJ.this.findViewById(R.id.image_car_door_rear);
                    Resources resources6 = VwDashBoard_DZSJ.this.getResources();
                    if (value6 == 1) {
                        i = R.drawable.ic_dashboard_car_door_rear;
                    }
                    imageView6.setImageDrawable(resources6.getDrawable(i));
                    break;
                case 101:
                    VwDashBoard_DZSJ.this.mUpdaterLifeBelt(DataCanbus.DATA[101]);
                    break;
                case 104:
                    VwDashBoard_DZSJ.this.mUpdaterDashBoardinfo1(VwDashBoard_DZSJ.this.infonum1);
                    break;
                case 105:
                    VwDashBoard_DZSJ.this.mUpdaterDashBoardinfo2(VwDashBoard_DZSJ.this.infonum2);
                    break;
                case 109:
                    ((InfoView4) VwDashBoard_DZSJ.this.findViewById(R.id.infoView_dzsj2)).setSpeed(DataCanbus.DATA[109]);
                    VwDashBoard_DZSJ.this.mUpdaterDashBoardinfo2(VwDashBoard_DZSJ.this.infonum2);
                    break;
                case 113:
                    ((InfoView3) VwDashBoard_DZSJ.this.findViewById(R.id.infoView_dzsj1)).setSpeed(DataCanbus.DATA[113]);
                    VwDashBoard_DZSJ.this.mUpdaterDashBoardinfo1(VwDashBoard_DZSJ.this.infonum1);
                    break;
                case 116:
                    VwDashBoard_DZSJ.this.mUpdaterTurnrightLight(DataCanbus.DATA[116]);
                    break;
                case 117:
                    VwDashBoard_DZSJ.this.mUpdaterTurnleftLight(DataCanbus.DATA[117]);
                    break;
                case 121:
                    int value7 = DataCanbus.DATA[121];
                    ((ImageView) VwDashBoard_DZSJ.this.findViewById(R.id.image_car_light)).setImageDrawable(VwDashBoard_DZSJ.this.getResources().getDrawable(value7 == 1 ? R.drawable.ic_dashboard_car_light : 2130840179));
                    ImageView imageView7 = (ImageView) VwDashBoard_DZSJ.this.findViewById(R.id.image_light);
                    Resources resources7 = VwDashBoard_DZSJ.this.getResources();
                    if (value7 == 1) {
                        i = R.drawable.ic_dashboard_top_light;
                    }
                    imageView7.setImageDrawable(resources7.getDrawable(i));
                    break;
                case 122:
                    int value8 = DataCanbus.DATA[122];
                    ImageView imageView8 = (ImageView) VwDashBoard_DZSJ.this.findViewById(R.id.image_handbrak);
                    Resources resources8 = VwDashBoard_DZSJ.this.getResources();
                    if (value8 == 1) {
                        i = R.drawable.ic_dashboard_top_hand;
                    }
                    imageView8.setImageDrawable(resources8.getDrawable(i));
                    break;
            }
        }
    };
    int num2 = 0;
    Runnable mShowLifeBelt = new Runnable() { 
        @Override
        public void run() {
            VwDashBoard_DZSJ.this.num2++;
            if (VwDashBoard_DZSJ.this.num2 > 1) {
                VwDashBoard_DZSJ.this.num2 = 0;
            }
            ((ImageView) VwDashBoard_DZSJ.this.findViewById(R.id.image_car_lifebelt)).setImageDrawable(VwDashBoard_DZSJ.this.getResources().getDrawable(VwDashBoard_DZSJ.this.num2 == 1 ? R.drawable.ic_dashboard_top_lifebelt : R.drawable.ic_dashboard_car_null));
            HandlerUI.getInstance().removeCallbacks(VwDashBoard_DZSJ.this.mShowLifeBelt);
            HandlerUI.getInstance().postDelayed(VwDashBoard_DZSJ.this.mShowLifeBelt, 500L);
        }
    };
    int num = 0;
    Runnable mShowTurnLeftLight = new Runnable() { 
        @Override
        public void run() {
            int i = R.drawable.ic_dashboard_car_null;
            VwDashBoard_DZSJ.this.num++;
            if (VwDashBoard_DZSJ.this.num > 1) {
                VwDashBoard_DZSJ.this.num = 0;
            }
            ((ImageView) VwDashBoard_DZSJ.this.findViewById(R.id.image_car_turnl_light)).setImageDrawable(VwDashBoard_DZSJ.this.getResources().getDrawable(VwDashBoard_DZSJ.this.num == 1 ? R.drawable.ic_dashboard_car_turnl_light : 2130840179));
            ImageView imageView = (ImageView) VwDashBoard_DZSJ.this.findViewById(R.id.image_car_turnl_top);
            Resources resources = VwDashBoard_DZSJ.this.getResources();
            if (VwDashBoard_DZSJ.this.num == 1) {
                i = R.drawable.ic_dashboard_car_turnltop;
            }
            imageView.setImageDrawable(resources.getDrawable(i));
            HandlerUI.getInstance().removeCallbacks(VwDashBoard_DZSJ.this.mShowTurnLeftLight);
            HandlerUI.getInstance().postDelayed(VwDashBoard_DZSJ.this.mShowTurnLeftLight, 500L);
        }
    };
    int num1 = 0;
    Runnable mShowTurnRightLight = new Runnable() { 
        @Override
        public void run() {
            int i = R.drawable.ic_dashboard_car_null;
            VwDashBoard_DZSJ.this.num1++;
            if (VwDashBoard_DZSJ.this.num1 > 1) {
                VwDashBoard_DZSJ.this.num1 = 0;
            }
            ((ImageView) VwDashBoard_DZSJ.this.findViewById(R.id.image_car_turnr_light)).setImageDrawable(VwDashBoard_DZSJ.this.getResources().getDrawable(VwDashBoard_DZSJ.this.num1 == 1 ? R.drawable.ic_dashboard_car_turnr_light : 2130840179));
            ImageView imageView = (ImageView) VwDashBoard_DZSJ.this.findViewById(R.id.image_car_turnr_top);
            Resources resources = VwDashBoard_DZSJ.this.getResources();
            if (VwDashBoard_DZSJ.this.num1 == 1) {
                i = R.drawable.ic_dashboard_car_turnrtop;
            }
            imageView.setImageDrawable(resources.getDrawable(i));
            HandlerUI.getInstance().removeCallbacks(VwDashBoard_DZSJ.this.mShowTurnRightLight);
            HandlerUI.getInstance().postDelayed(VwDashBoard_DZSJ.this.mShowTurnRightLight, 500L);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        //setContentView(R.layout.layout_vw_functional_dashboard_dzsj);
        init();
        mInstance = this;
    }

    public void init() {
        findViewById(R.id.glf7_btn_car_back_od).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                VwDashBoard_DZSJ.this.finish();
            }
        });
        ((Button) findViewById(R.id.glf7_btn_car_infochange_dzsj1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                VwDashBoard_DZSJ.this.infonum1++;
                if (VwDashBoard_DZSJ.this.infonum1 > 1) {
                    VwDashBoard_DZSJ.this.infonum1 = 0;
                }
                VwDashBoard_DZSJ.this.mUpdaterDashBoardinfo1(VwDashBoard_DZSJ.this.infonum1);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_car_infochange_dzsj2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                VwDashBoard_DZSJ.this.infonum2++;
                if (VwDashBoard_DZSJ.this.infonum2 > 1) {
                    VwDashBoard_DZSJ.this.infonum2 = 0;
                }
                VwDashBoard_DZSJ.this.mUpdaterDashBoardinfo2(VwDashBoard_DZSJ.this.infonum2);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
        DoorHelper.disableDoorWindowLocal(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
        DoorHelper.disableDoorWindowLocal(false);
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterDashBoardinfo1(int data) {
        switch (data) {
            case 0:
                int value = DataCanbus.DATA[113];
                ((ImageView) findViewById(R.id.image_car_voltage_inter)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dashboard_car_null));
                ((TextView) findViewById(R.id.golf_dashboard1_info)).setText("");
                ((TextView) findViewById(R.id.golf_dashboard1_info2)).setText(String.format("%d", Integer.valueOf(value)));
                ((TextView) findViewById(R.id.golf_dashboard1_info3)).setText("rpm");
                break;
            case 1:
                int value2 = DataCanbus.DATA[104];
                ((ImageView) findViewById(R.id.image_car_voltage_inter)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dashboard_inter_vol));
                if (value2 > 0) {
                    ((TextView) findViewById(R.id.golf_dashboard1_info2)).setText(String.format("%d.%d", Integer.valueOf((value2 >> 8) & 255), Integer.valueOf(value2 & 255)));
                } else {
                    ((TextView) findViewById(R.id.golf_dashboard1_info2)).setText("--.--");
                }
                ((TextView) findViewById(R.id.golf_dashboard1_info3)).setText("v");
                break;
        }
    }

    
    public void mUpdaterDashBoardinfo2(int data) {
        switch (data) {
            case 0:
                int value = DataCanbus.DATA[109];
                ((ImageView) findViewById(R.id.image_car_road_inter)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dashboard_car_null));
                ((TextView) findViewById(R.id.golf_dashboard2_info)).setText("");
                ((TextView) findViewById(R.id.golf_dashboard2_info2)).setText(String.format("%d", Integer.valueOf(value)));
                ((TextView) findViewById(R.id.golf_dashboard2_info3)).setText("km/h");
                break;
            case 1:
                int value2 = DataCanbus.DATA[105];
                ((ImageView) findViewById(R.id.image_car_road_inter)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dashboard_inter_road));
                ((TextView) findViewById(R.id.golf_dashboard2_info2)).setText(String.format("%d", Integer.valueOf(value2)));
                ((TextView) findViewById(R.id.golf_dashboard2_info3)).setText("km");
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
