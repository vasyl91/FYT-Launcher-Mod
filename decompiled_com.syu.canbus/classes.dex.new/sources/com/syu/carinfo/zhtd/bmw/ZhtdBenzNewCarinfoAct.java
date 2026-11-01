package com.syu.carinfo.zhtd.bmw;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ZhtdBenzNewCarinfoAct extends Activity {
    public static boolean mIsFront = false;
    int touchnum = 0;
    int mileunit = 0;
    Runnable mCalTime = new Runnable() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdBenzNewCarinfoAct.1
        @Override // java.lang.Runnable
        public void run() {
            ZhtdBenzNewCarinfoAct.this.touchnum++;
            if (ZhtdBenzNewCarinfoAct.this.touchnum == 3) {
                if (SystemProperties.getInt("persist.fyt.mileunit", 0) == 1) {
                    SystemProperties.set("persist.fyt.mileunit", "0");
                    ZhtdBenzNewCarinfoAct.this.mileunit = 0;
                    ((TextView) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.txt_car_total_mileage)).setText(String.valueOf(DataCanbus.DATA[108]) + " km");
                    ((TextView) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText("km/h");
                    ((TextView) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.tv_text2)).setText("km/h");
                    ZhtdBenzNewCarinfoAct.this.updateSpeed();
                } else {
                    SystemProperties.set("persist.fyt.mileunit", "1");
                    ZhtdBenzNewCarinfoAct.this.mileunit = 1;
                    int value = (DataCanbus.DATA[108] * 10) / 16;
                    ((TextView) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.txt_car_total_mileage)).setText(String.valueOf(value) + " miles");
                    ((TextView) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText(CamryData.SPEED_UNIT_MILE);
                    ((TextView) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.tv_text2)).setText(CamryData.SPEED_UNIT_MILE);
                    ZhtdBenzNewCarinfoAct.this.updateSpeed();
                }
            }
            HandlerUI.getInstance().removeCallbacks(ZhtdBenzNewCarinfoAct.this.mCalTime);
            HandlerUI.getInstance().postDelayed(ZhtdBenzNewCarinfoAct.this.mCalTime, 1000L);
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdBenzNewCarinfoAct.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = R.drawable.ic_dashboard_car_null;
            switch (updateCode) {
                case 98:
                case 99:
                    int value = DataCanbus.DATA[98];
                    int value1 = DataCanbus.DATA[99];
                    if (value1 == 1) {
                        ((ImageView) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.image_car_light_near_top)).setBackgroundResource(R.drawable.ic_benz_dashboard_top_light_far);
                    } else if (value == 1) {
                        ((ImageView) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.image_car_light_near_top)).setBackgroundResource(R.drawable.ic_benz_dashboard_top_light_near);
                    } else {
                        ((ImageView) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.image_car_light_near_top)).setBackgroundResource(R.drawable.ic_dashboard_car_null);
                    }
                    break;
                case 100:
                    ZhtdBenzNewCarinfoAct.this.mUpdaterTurnleftLight(DataCanbus.DATA[100]);
                    break;
                case 101:
                    ZhtdBenzNewCarinfoAct.this.mUpdaterTurnrightLight(DataCanbus.DATA[101]);
                    break;
                case 102:
                    int value2 = DataCanbus.DATA[102];
                    ImageView imageView = (ImageView) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.image_car_belt);
                    if (value2 == 0) {
                        i = R.drawable.ic_bmwnew_dashboard_car_belt;
                    }
                    imageView.setBackgroundResource(i);
                    break;
                case 104:
                    int value3 = DataCanbus.DATA[104];
                    ImageView imageView2 = (ImageView) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.image_car_handbrake);
                    if (value3 == 1) {
                        i = R.drawable.ic_bmw_dashboard_car_handbrake_p;
                    }
                    imageView2.setBackgroundResource(i);
                    break;
                case 105:
                    ZhtdBenzNewCarinfoAct.this.updateSpeed();
                    break;
                case 107:
                    int value4 = DataCanbus.DATA[107];
                    ((InfoBenzViewEngineSpeed) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.infoView_enginespeed)).setSpeed((value4 * 240) / 8000);
                    break;
                case 108:
                    int value5 = DataCanbus.DATA[108];
                    if (ZhtdBenzNewCarinfoAct.this.mileunit == 1) {
                        ((TextView) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.txt_car_total_mileage)).setText(String.valueOf((value5 * 10) / 16) + " miles");
                    } else {
                        ((TextView) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.txt_car_total_mileage)).setText(String.valueOf(value5) + " km");
                    }
                    break;
            }
        }
    };
    int num = 0;
    Runnable mShowTurnLeftLight = new Runnable() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdBenzNewCarinfoAct.3
        @Override // java.lang.Runnable
        public void run() {
            ZhtdBenzNewCarinfoAct.this.num++;
            if (ZhtdBenzNewCarinfoAct.this.num > 1) {
                ZhtdBenzNewCarinfoAct.this.num = 0;
            }
            ((ImageView) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.image_car_turnl_top)).setBackgroundResource(ZhtdBenzNewCarinfoAct.this.num == 1 ? R.drawable.ic_dashboard_car_turnltop : R.drawable.ic_dashboard_car_null);
            HandlerUI.getInstance().removeCallbacks(ZhtdBenzNewCarinfoAct.this.mShowTurnLeftLight);
            HandlerUI.getInstance().postDelayed(ZhtdBenzNewCarinfoAct.this.mShowTurnLeftLight, 500L);
        }
    };
    int num1 = 0;
    Runnable mShowTurnRightLight = new Runnable() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdBenzNewCarinfoAct.4
        @Override // java.lang.Runnable
        public void run() {
            ZhtdBenzNewCarinfoAct.this.num1++;
            if (ZhtdBenzNewCarinfoAct.this.num1 > 1) {
                ZhtdBenzNewCarinfoAct.this.num1 = 0;
            }
            ((ImageView) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.image_car_turnr_top)).setBackgroundResource(ZhtdBenzNewCarinfoAct.this.num1 == 1 ? R.drawable.ic_dashboard_car_turnrtop : R.drawable.ic_dashboard_car_null);
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
        initUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatermCalTime(boolean on) {
        if (on) {
            HandlerUI.getInstance().removeCallbacks(this.mCalTime);
            HandlerUI.getInstance().postDelayed(this.mCalTime, 1000L);
            this.touchnum = 0;
            return;
        }
        HandlerUI.getInstance().removeCallbacks(this.mCalTime);
    }

    private void initUI() {
        if (DataCanbus.DATA[1000] == 7668155 || DataCanbus.DATA[1000] == 1900990 || DataCanbus.DATA[1000] == 2556350 || DataCanbus.DATA[1000] == 2818492 || DataCanbus.DATA[1000] == 1966526 || DataCanbus.DATA[1000] == 6947260 || DataCanbus.DATA[1000] == 2228670 || DataCanbus.DATA[1000] == 7078332 || DataCanbus.DATA[1000] == 2294206 || DataCanbus.DATA[1000] == 7012796 || DataCanbus.DATA[1000] == 983486 || DataCanbus.DATA[1000] == 1049022 || DataCanbus.DATA[1000] == 1114558 || DataCanbus.DATA[1000] == 1442238 || DataCanbus.DATA[1000] == 1507774 || DataCanbus.DATA[1000] == 1573310 || DataCanbus.DATA[1000] == 1638846 || DataCanbus.DATA[1000] == 6488508 || DataCanbus.DATA[1000] == 2163134 || DataCanbus.DATA[1000] == 655804) {
            findViewById(R.id.txt_car_total_mileage).setVisibility(8);
        } else {
            findViewById(R.id.txt_car_total_mileage).setVisibility(0);
        }
        findViewById(R.id.infoView_speed).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdBenzNewCarinfoAct.5
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case 0:
                        ZhtdBenzNewCarinfoAct.this.touchnum = 0;
                        ZhtdBenzNewCarinfoAct.this.mUpdatermCalTime(true);
                        return true;
                    case 1:
                        ZhtdBenzNewCarinfoAct.this.mUpdatermCalTime(false);
                        ZhtdBenzNewCarinfoAct.this.touchnum = 0;
                        return true;
                    default:
                        return true;
                }
            }
        });
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        if (DataCanbus.DATA[1000] == 7668155 || DataCanbus.DATA[1000] == 1900990 || DataCanbus.DATA[1000] == 2556350 || DataCanbus.DATA[1000] == 2818492 || DataCanbus.DATA[1000] == 1966526 || DataCanbus.DATA[1000] == 6947260 || DataCanbus.DATA[1000] == 2228670 || DataCanbus.DATA[1000] == 7078332 || DataCanbus.DATA[1000] == 2294206 || DataCanbus.DATA[1000] == 7012796 || DataCanbus.DATA[1000] == 983486 || DataCanbus.DATA[1000] == 1049022 || DataCanbus.DATA[1000] == 1114558 || DataCanbus.DATA[1000] == 1442238 || DataCanbus.DATA[1000] == 1507774 || DataCanbus.DATA[1000] == 1573310 || DataCanbus.DATA[1000] == 1638846 || DataCanbus.DATA[1000] == 6488508 || DataCanbus.DATA[1000] == 2163134 || DataCanbus.DATA[1000] == 655804) {
            DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
        } else {
            DataCanbus.PROXY.cmd(0, new int[]{1, 1, 0, 0}, null, null);
        }
        mIsFront = true;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        if (DataCanbus.DATA[1000] == 7668155 || DataCanbus.DATA[1000] == 1900990 || DataCanbus.DATA[1000] == 2556350 || DataCanbus.DATA[1000] == 2818492 || DataCanbus.DATA[1000] == 1966526 || DataCanbus.DATA[1000] == 6947260 || DataCanbus.DATA[1000] == 2228670 || DataCanbus.DATA[1000] == 7078332 || DataCanbus.DATA[1000] == 2294206 || DataCanbus.DATA[1000] == 7012796 || DataCanbus.DATA[1000] == 983486 || DataCanbus.DATA[1000] == 1049022 || DataCanbus.DATA[1000] == 1114558 || DataCanbus.DATA[1000] == 1442238 || DataCanbus.DATA[1000] == 1507774 || DataCanbus.DATA[1000] == 1573310 || DataCanbus.DATA[1000] == 1638846 || DataCanbus.DATA[1000] == 6488508 || DataCanbus.DATA[1000] == 2163134 || DataCanbus.DATA[1000] == 655804) {
            DataCanbus.PROXY.cmd(6, new int[1], null, null);
        } else {
            RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
            int[] iArr = new int[4];
            iArr[0] = 1;
            remoteModuleProxy.cmd(0, iArr, null, null);
        }
        mIsFront = false;
    }

    public void addNotify() {
        this.mileunit = SystemProperties.getInt("persist.fyt.mileunit", 0);
        if (this.mileunit == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(CamryData.SPEED_UNIT_MILE);
            ((TextView) findViewById(R.id.tv_text2)).setText(CamryData.SPEED_UNIT_MILE);
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText("km/h");
            ((TextView) findViewById(R.id.tv_text2)).setText("km/h");
        }
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpeed() {
        int speed = DataCanbus.DATA[105];
        if (this.mileunit == 1) {
            speed = (speed * 10) / 16;
        }
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
            ((ImageView) findViewById(R.id.image_car_turnl_top)).setBackgroundResource(R.drawable.ic_dashboard_car_null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTurnrightLight(int value) {
        if (value == 1) {
            HandlerUI.getInstance().removeCallbacks(this.mShowTurnRightLight);
            HandlerUI.getInstance().postDelayed(this.mShowTurnRightLight, 500L);
        } else {
            HandlerUI.getInstance().removeCallbacks(this.mShowTurnRightLight);
            ((ImageView) findViewById(R.id.image_car_turnr_top)).setBackgroundResource(R.drawable.ic_dashboard_car_null);
        }
    }
}
