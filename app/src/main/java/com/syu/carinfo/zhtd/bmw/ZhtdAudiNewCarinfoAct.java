package com.syu.carinfo.zhtd.bmw;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ZhtdAudiNewCarinfoAct extends Activity {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdAudiNewCarinfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = R.drawable.ic_dashboard_car_null;
            int i2 = R.drawable.ic_bmw_dashboard_car_null;
            switch (updateCode) {
                case 1:
                    int value = DataCanbus.DATA[1];
                    ((ImageView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.image_car_door_fl)).setImageDrawable(ZhtdAudiNewCarinfoAct.this.getResources().getDrawable(value == 1 ? R.drawable.ic_audi_dashboard_car_door_fl : 2130839229));
                    break;
                case 2:
                    int value2 = DataCanbus.DATA[2];
                    ImageView imageView = (ImageView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.image_car_door_fr);
                    Resources resources = ZhtdAudiNewCarinfoAct.this.getResources();
                    if (value2 == 1) {
                        i2 = R.drawable.ic_audi_dashboard_car_door_fr;
                    }
                    imageView.setImageDrawable(resources.getDrawable(i2));
                    break;
                case 3:
                    int value3 = DataCanbus.DATA[3];
                    ImageView imageView2 = (ImageView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.image_car_door_rl);
                    Resources resources2 = ZhtdAudiNewCarinfoAct.this.getResources();
                    if (value3 == 1) {
                        i2 = R.drawable.ic_audi_dashboard_car_door_rl;
                    }
                    imageView2.setImageDrawable(resources2.getDrawable(i2));
                    break;
                case 4:
                    int value4 = DataCanbus.DATA[4];
                    ImageView imageView3 = (ImageView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.image_car_door_rr);
                    Resources resources3 = ZhtdAudiNewCarinfoAct.this.getResources();
                    if (value4 == 1) {
                        i2 = R.drawable.ic_audi_dashboard_car_door_rr;
                    }
                    imageView3.setImageDrawable(resources3.getDrawable(i2));
                    break;
                case 7:
                case 8:
                    int value5 = DataCanbus.DATA[7];
                    int value1 = DataCanbus.DATA[8];
                    if (value1 == 1) {
                        ((ImageView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.image_car_light_near_top)).setImageDrawable(ZhtdAudiNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_benz_dashboard_top_light_far));
                        break;
                    } else if (value5 == 1) {
                        ((ImageView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.image_car_light_near_top)).setImageDrawable(ZhtdAudiNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_benz_dashboard_top_light_near));
                        break;
                    } else {
                        ((ImageView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.image_car_light_near_top)).setImageDrawable(ZhtdAudiNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_dashboard_car_null));
                        break;
                    }
                case 9:
                    ZhtdAudiNewCarinfoAct.this.mUpdaterTurnleftLight(DataCanbus.DATA[9]);
                    break;
                case 10:
                    ZhtdAudiNewCarinfoAct.this.mUpdaterTurnrightLight(DataCanbus.DATA[10]);
                    break;
                case 11:
                    int value6 = DataCanbus.DATA[11];
                    ImageView imageView4 = (ImageView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.image_car_belt);
                    Resources resources4 = ZhtdAudiNewCarinfoAct.this.getResources();
                    if (value6 == 0) {
                        i = R.drawable.ic_bmwnew_dashboard_car_belt;
                    }
                    imageView4.setImageDrawable(resources4.getDrawable(i));
                    break;
                case 12:
                    int value7 = DataCanbus.DATA[12];
                    ImageView imageView5 = (ImageView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.image_car_footbrake);
                    Resources resources5 = ZhtdAudiNewCarinfoAct.this.getResources();
                    if (value7 == 1) {
                        i = R.drawable.ic_bmwnew_dashboard_car_footbrake;
                    }
                    imageView5.setImageDrawable(resources5.getDrawable(i));
                    break;
                case 13:
                    int value8 = DataCanbus.DATA[13];
                    ImageView imageView6 = (ImageView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.image_car_handbrake);
                    Resources resources6 = ZhtdAudiNewCarinfoAct.this.getResources();
                    if (value8 == 1) {
                        i = R.drawable.ic_bmw_dashboard_car_handbrake_p;
                    }
                    imageView6.setImageDrawable(resources6.getDrawable(i));
                    break;
                case 14:
                    ZhtdAudiNewCarinfoAct.this.updateSpeed();
                    break;
                case 15:
                    int value9 = DataCanbus.DATA[15];
                    ((TextView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.txt_car_oil)).setText(String.format("%d L", Integer.valueOf(value9)));
                    break;
                case 16:
                    int value10 = DataCanbus.DATA[16];
                    ((InfoAudiViewEngineSpeed) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.infoView_enginespeed)).setSpeed((value10 * 240) / 8000);
                    break;
                case 17:
                    int value11 = DataCanbus.DATA[17];
                    ((TextView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.txt_car_total_mileage)).setText(String.valueOf(value11) + " km");
                    break;
                case 62:
                    int value12 = DataCanbus.DATA[62];
                    switch (value12) {
                        case 0:
                            ((ImageView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.image_car_gear)).setImageDrawable(ZhtdAudiNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_cargear_p));
                            break;
                        case 1:
                            ((ImageView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.image_car_gear)).setImageDrawable(ZhtdAudiNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_cargear_r));
                            break;
                        case 2:
                            ((ImageView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.image_car_gear)).setImageDrawable(ZhtdAudiNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_cargear_n));
                            break;
                        case 4:
                            ((ImageView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.image_car_gear)).setImageDrawable(ZhtdAudiNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_cargear_d));
                            break;
                        case 5:
                            ((ImageView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.image_car_gear)).setImageDrawable(ZhtdAudiNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_cargear_s));
                            break;
                        case 6:
                            ((ImageView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.image_car_gear)).setImageDrawable(ZhtdAudiNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_cargear_m));
                            break;
                    }
            }
        }
    };
    int num = 0;
    Runnable mShowTurnLeftLight = new Runnable() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdAudiNewCarinfoAct.2
        @Override // java.lang.Runnable
        public void run() {
            ZhtdAudiNewCarinfoAct.this.num++;
            if (ZhtdAudiNewCarinfoAct.this.num > 1) {
                ZhtdAudiNewCarinfoAct.this.num = 0;
            }
            ((ImageView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.image_car_turnl_top)).setImageDrawable(ZhtdAudiNewCarinfoAct.this.getResources().getDrawable(ZhtdAudiNewCarinfoAct.this.num == 1 ? R.drawable.ic_dashboard_car_turnltop : R.drawable.ic_dashboard_car_null));
            HandlerUI.getInstance().removeCallbacks(ZhtdAudiNewCarinfoAct.this.mShowTurnLeftLight);
            HandlerUI.getInstance().postDelayed(ZhtdAudiNewCarinfoAct.this.mShowTurnLeftLight, 500L);
        }
    };
    int num1 = 0;
    Runnable mShowTurnRightLight = new Runnable() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdAudiNewCarinfoAct.3
        @Override // java.lang.Runnable
        public void run() {
            ZhtdAudiNewCarinfoAct.this.num1++;
            if (ZhtdAudiNewCarinfoAct.this.num1 > 1) {
                ZhtdAudiNewCarinfoAct.this.num1 = 0;
            }
            ((ImageView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.image_car_turnr_top)).setImageDrawable(ZhtdAudiNewCarinfoAct.this.getResources().getDrawable(ZhtdAudiNewCarinfoAct.this.num1 == 1 ? R.drawable.ic_dashboard_car_turnrtop : R.drawable.ic_dashboard_car_null));
            HandlerUI.getInstance().removeCallbacks(ZhtdAudiNewCarinfoAct.this.mShowTurnRightLight);
            HandlerUI.getInstance().postDelayed(ZhtdAudiNewCarinfoAct.this.mShowTurnRightLight, 500L);
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.layout_zhtd_audinew_dashboard);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(0, new int[]{1, 1}, null, null);
        DoorHelper.disableDoorWindowLocal(true);
        mIsFront = true;
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
        mIsFront = false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpeed() {
        int speed = DataCanbus.DATA[14];
        ((InfoAudiViewSpeed) findViewById(R.id.infoView_speed)).setSpeed(speed);
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
