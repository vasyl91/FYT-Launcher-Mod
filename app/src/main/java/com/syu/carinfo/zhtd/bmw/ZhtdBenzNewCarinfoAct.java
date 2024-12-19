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
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ZhtdBenzNewCarinfoAct extends Activity {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdBenzNewCarinfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = R.drawable.ic_dashboard_car_null;
            switch (updateCode) {
                case 7:
                case 8:
                    int value = DataCanbus.DATA[7];
                    int value1 = DataCanbus.DATA[8];
                    if (value1 == 1) {
                        ((ImageView) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.image_car_light_near_top)).setImageDrawable(ZhtdBenzNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_benz_dashboard_top_light_far));
                        break;
                    } else if (value == 1) {
                        ((ImageView) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.image_car_light_near_top)).setImageDrawable(ZhtdBenzNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_benz_dashboard_top_light_near));
                        break;
                    } else {
                        ((ImageView) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.image_car_light_near_top)).setImageDrawable(ZhtdBenzNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_dashboard_car_null));
                        break;
                    }
                case 9:
                    ZhtdBenzNewCarinfoAct.this.mUpdaterTurnleftLight(DataCanbus.DATA[9]);
                    break;
                case 10:
                    ZhtdBenzNewCarinfoAct.this.mUpdaterTurnrightLight(DataCanbus.DATA[10]);
                    break;
                case 11:
                    int value2 = DataCanbus.DATA[11];
                    ImageView imageView = (ImageView) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.image_car_belt);
                    Resources resources = ZhtdBenzNewCarinfoAct.this.getResources();
                    if (value2 == 0) {
                        i = R.drawable.ic_bmwnew_dashboard_car_belt;
                    }
                    imageView.setImageDrawable(resources.getDrawable(i));
                    break;
                case 13:
                    int value3 = DataCanbus.DATA[13];
                    ImageView imageView2 = (ImageView) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.image_car_handbrake);
                    Resources resources2 = ZhtdBenzNewCarinfoAct.this.getResources();
                    if (value3 == 1) {
                        i = R.drawable.ic_bmw_dashboard_car_handbrake_p;
                    }
                    imageView2.setImageDrawable(resources2.getDrawable(i));
                    break;
                case 14:
                    ZhtdBenzNewCarinfoAct.this.updateSpeed();
                    break;
                case 16:
                    int value4 = DataCanbus.DATA[16];
                    ((InfoBenzViewEngineSpeed) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.infoView_enginespeed)).setSpeed((value4 * 240) / 8000);
                    break;
                case 17:
                    int value5 = DataCanbus.DATA[17];
                    ((TextView) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.txt_car_total_mileage)).setText(String.valueOf(value5) + " km");
                    break;
            }
        }
    };
    int num = 0;
    Runnable mShowTurnLeftLight = new Runnable() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdBenzNewCarinfoAct.2
        @Override // java.lang.Runnable
        public void run() {
            ZhtdBenzNewCarinfoAct.this.num++;
            if (ZhtdBenzNewCarinfoAct.this.num > 1) {
                ZhtdBenzNewCarinfoAct.this.num = 0;
            }
            ((ImageView) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.image_car_turnl_top)).setImageDrawable(ZhtdBenzNewCarinfoAct.this.getResources().getDrawable(ZhtdBenzNewCarinfoAct.this.num == 1 ? R.drawable.ic_dashboard_car_turnltop : R.drawable.ic_dashboard_car_null));
            HandlerUI.getInstance().removeCallbacks(ZhtdBenzNewCarinfoAct.this.mShowTurnLeftLight);
            HandlerUI.getInstance().postDelayed(ZhtdBenzNewCarinfoAct.this.mShowTurnLeftLight, 500L);
        }
    };
    int num1 = 0;
    Runnable mShowTurnRightLight = new Runnable() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdBenzNewCarinfoAct.3
        @Override // java.lang.Runnable
        public void run() {
            ZhtdBenzNewCarinfoAct.this.num1++;
            if (ZhtdBenzNewCarinfoAct.this.num1 > 1) {
                ZhtdBenzNewCarinfoAct.this.num1 = 0;
            }
            ((ImageView) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.image_car_turnr_top)).setImageDrawable(ZhtdBenzNewCarinfoAct.this.getResources().getDrawable(ZhtdBenzNewCarinfoAct.this.num1 == 1 ? R.drawable.ic_dashboard_car_turnrtop : R.drawable.ic_dashboard_car_null));
            HandlerUI.getInstance().removeCallbacks(ZhtdBenzNewCarinfoAct.this.mShowTurnRightLight);
            HandlerUI.getInstance().postDelayed(ZhtdBenzNewCarinfoAct.this.mShowTurnRightLight, 500L);
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.layout_zhtd_benznew_dashboard);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(0, new int[]{1, 1}, null, null);
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
        mIsFront = false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpeed() {
        int speed = DataCanbus.DATA[14];
        ((InfoBenzViewSpeed) findViewById(R.id.infoView_speed)).setSpeed(speed);
        ((TextView) findViewById(R.id.txt_car_speed)).setText(new StringBuilder(String.valueOf(speed)).toString());
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
