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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class VwDashBoard_DZSJ extends Activity {
    public static VwDashBoard_DZSJ mInstance;
    public static boolean mIsFront = false;
    public int infonum1 = 0;
    public int infonum2 = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dasauto.VwDashBoard_DZSJ.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = R.drawable.ic_dashboard_car_null;
            switch (updateCode) {
                case 3:
                    VwDashBoard_DZSJ.this.mUpdaterLifeBelt(DataCanbus.DATA[3]);
                    break;
                case 6:
                    VwDashBoard_DZSJ.this.mUpdaterDashBoardinfo1(VwDashBoard_DZSJ.this.infonum1);
                    break;
                case 7:
                    VwDashBoard_DZSJ.this.mUpdaterDashBoardinfo2(VwDashBoard_DZSJ.this.infonum2);
                    break;
                case 11:
                    ((InfoView4) VwDashBoard_DZSJ.this.findViewById(R.id.infoView_dzsj2)).setSpeed(DataCanbus.DATA[11]);
                    VwDashBoard_DZSJ.this.mUpdaterDashBoardinfo2(VwDashBoard_DZSJ.this.infonum2);
                    break;
                case 15:
                    ((InfoView3) VwDashBoard_DZSJ.this.findViewById(R.id.infoView_dzsj1)).setSpeed(DataCanbus.DATA[15]);
                    VwDashBoard_DZSJ.this.mUpdaterDashBoardinfo1(VwDashBoard_DZSJ.this.infonum1);
                    break;
                case 18:
                    VwDashBoard_DZSJ.this.mUpdaterTurnrightLight(DataCanbus.DATA[18]);
                    break;
                case 19:
                    VwDashBoard_DZSJ.this.mUpdaterTurnleftLight(DataCanbus.DATA[19]);
                    break;
                case 42:
                    int value = DataCanbus.DATA[42];
                    ImageView imageView = (ImageView) VwDashBoard_DZSJ.this.findViewById(R.id.image_car_door_engine);
                    Resources resources = VwDashBoard_DZSJ.this.getResources();
                    if (value == 1) {
                        i = R.drawable.ic_dashboard_car_door_engine;
                    }
                    imageView.setImageDrawable(resources.getDrawable(i));
                    break;
                case 43:
                    int value2 = DataCanbus.DATA[43];
                    ImageView imageView2 = (ImageView) VwDashBoard_DZSJ.this.findViewById(R.id.image_car_door_fl);
                    Resources resources2 = VwDashBoard_DZSJ.this.getResources();
                    if (value2 == 1) {
                        i = R.drawable.ic_dashboard_car_door_fl;
                    }
                    imageView2.setImageDrawable(resources2.getDrawable(i));
                    break;
                case 44:
                    int value3 = DataCanbus.DATA[44];
                    ImageView imageView3 = (ImageView) VwDashBoard_DZSJ.this.findViewById(R.id.image_car_door_fr);
                    Resources resources3 = VwDashBoard_DZSJ.this.getResources();
                    if (value3 == 1) {
                        i = R.drawable.ic_dashboard_car_door_fr;
                    }
                    imageView3.setImageDrawable(resources3.getDrawable(i));
                    break;
                case 45:
                    int value4 = DataCanbus.DATA[45];
                    ImageView imageView4 = (ImageView) VwDashBoard_DZSJ.this.findViewById(R.id.image_car_door_rl);
                    Resources resources4 = VwDashBoard_DZSJ.this.getResources();
                    if (value4 == 1) {
                        i = R.drawable.ic_dashboard_car_door_rl;
                    }
                    imageView4.setImageDrawable(resources4.getDrawable(i));
                    break;
                case 46:
                    int value5 = DataCanbus.DATA[46];
                    ImageView imageView5 = (ImageView) VwDashBoard_DZSJ.this.findViewById(R.id.image_car_door_rr);
                    Resources resources5 = VwDashBoard_DZSJ.this.getResources();
                    if (value5 == 1) {
                        i = R.drawable.ic_dashboard_car_door_rr;
                    }
                    imageView5.setImageDrawable(resources5.getDrawable(i));
                    break;
                case 47:
                    int value6 = DataCanbus.DATA[47];
                    ImageView imageView6 = (ImageView) VwDashBoard_DZSJ.this.findViewById(R.id.image_car_door_rear);
                    Resources resources6 = VwDashBoard_DZSJ.this.getResources();
                    if (value6 == 1) {
                        i = R.drawable.ic_dashboard_car_door_rear;
                    }
                    imageView6.setImageDrawable(resources6.getDrawable(i));
                    break;
                case 50:
                    int value7 = DataCanbus.DATA[50];
                    ((ImageView) VwDashBoard_DZSJ.this.findViewById(R.id.image_car_light)).setImageDrawable(VwDashBoard_DZSJ.this.getResources().getDrawable(value7 == 1 ? R.drawable.ic_dashboard_car_light : 2130839521));
                    ImageView imageView7 = (ImageView) VwDashBoard_DZSJ.this.findViewById(R.id.image_light);
                    Resources resources7 = VwDashBoard_DZSJ.this.getResources();
                    if (value7 == 1) {
                        i = R.drawable.ic_dashboard_top_light;
                    }
                    imageView7.setImageDrawable(resources7.getDrawable(i));
                    break;
                case 51:
                    int value8 = DataCanbus.DATA[51];
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
    Runnable mShowLifeBelt = new Runnable() { // from class: com.syu.carinfo.dasauto.VwDashBoard_DZSJ.2
        @Override // java.lang.Runnable
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
    Runnable mShowTurnLeftLight = new Runnable() { // from class: com.syu.carinfo.dasauto.VwDashBoard_DZSJ.3
        @Override // java.lang.Runnable
        public void run() {
            int i = R.drawable.ic_dashboard_car_null;
            VwDashBoard_DZSJ.this.num++;
            if (VwDashBoard_DZSJ.this.num > 1) {
                VwDashBoard_DZSJ.this.num = 0;
            }
            ((ImageView) VwDashBoard_DZSJ.this.findViewById(R.id.image_car_turnl_light)).setImageDrawable(VwDashBoard_DZSJ.this.getResources().getDrawable(VwDashBoard_DZSJ.this.num == 1 ? R.drawable.ic_dashboard_car_turnl_light : 2130839521));
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
    Runnable mShowTurnRightLight = new Runnable() { // from class: com.syu.carinfo.dasauto.VwDashBoard_DZSJ.4
        @Override // java.lang.Runnable
        public void run() {
            int i = R.drawable.ic_dashboard_car_null;
            VwDashBoard_DZSJ.this.num1++;
            if (VwDashBoard_DZSJ.this.num1 > 1) {
                VwDashBoard_DZSJ.this.num1 = 0;
            }
            ((ImageView) VwDashBoard_DZSJ.this.findViewById(R.id.image_car_turnr_light)).setImageDrawable(VwDashBoard_DZSJ.this.getResources().getDrawable(VwDashBoard_DZSJ.this.num1 == 1 ? R.drawable.ic_dashboard_car_turnr_light : 2130839521));
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

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.layout_vw_functional_dashboard_dzsj);
        init();
        mInstance = this;
    }

    public void init() {
        findViewById(R.id.glf7_btn_car_back_od).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.VwDashBoard_DZSJ.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                VwDashBoard_DZSJ.this.finish();
            }
        });
        ((Button) findViewById(R.id.glf7_btn_car_infochange_dzsj1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.VwDashBoard_DZSJ.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                VwDashBoard_DZSJ.this.infonum1++;
                if (VwDashBoard_DZSJ.this.infonum1 > 1) {
                    VwDashBoard_DZSJ.this.infonum1 = 0;
                }
                VwDashBoard_DZSJ.this.mUpdaterDashBoardinfo1(VwDashBoard_DZSJ.this.infonum1);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_car_infochange_dzsj2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.VwDashBoard_DZSJ.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                VwDashBoard_DZSJ.this.infonum2++;
                if (VwDashBoard_DZSJ.this.infonum2 > 1) {
                    VwDashBoard_DZSJ.this.infonum2 = 0;
                }
                VwDashBoard_DZSJ.this.mUpdaterDashBoardinfo2(VwDashBoard_DZSJ.this.infonum2);
            }
        });
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
        DoorHelper.disableDoorWindowLocal(true);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
        DoorHelper.disableDoorWindowLocal(false);
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDashBoardinfo1(int data) {
        switch (data) {
            case 0:
                int value = DataCanbus.DATA[15];
                ((ImageView) findViewById(R.id.image_car_voltage_inter)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dashboard_car_null));
                ((TextView) findViewById(R.id.golf_dashboard1_info)).setText("");
                ((TextView) findViewById(R.id.golf_dashboard1_info2)).setText(String.format("%d", Integer.valueOf(value)));
                ((TextView) findViewById(R.id.golf_dashboard1_info3)).setText("rpm");
                break;
            case 1:
                int value2 = DataCanbus.DATA[6];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDashBoardinfo2(int data) {
        switch (data) {
            case 0:
                int value = DataCanbus.DATA[11];
                ((ImageView) findViewById(R.id.image_car_road_inter)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dashboard_car_null));
                ((TextView) findViewById(R.id.golf_dashboard2_info)).setText("");
                ((TextView) findViewById(R.id.golf_dashboard2_info2)).setText(String.format("%d", Integer.valueOf(value)));
                ((TextView) findViewById(R.id.golf_dashboard2_info3)).setText("km/h");
                break;
            case 1:
                int value2 = DataCanbus.DATA[7];
                ((ImageView) findViewById(R.id.image_car_road_inter)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dashboard_inter_road));
                ((TextView) findViewById(R.id.golf_dashboard2_info2)).setText(String.format("%d", Integer.valueOf(value2)));
                ((TextView) findViewById(R.id.golf_dashboard2_info3)).setText("km");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLifeBelt(int value) {
        if (value == 1) {
            HandlerUI.getInstance().removeCallbacks(this.mShowLifeBelt);
            HandlerUI.getInstance().postDelayed(this.mShowLifeBelt, 500L);
        } else {
            HandlerUI.getInstance().removeCallbacks(this.mShowLifeBelt);
            ((ImageView) findViewById(R.id.image_car_lifebelt)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dashboard_car_null));
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
}
