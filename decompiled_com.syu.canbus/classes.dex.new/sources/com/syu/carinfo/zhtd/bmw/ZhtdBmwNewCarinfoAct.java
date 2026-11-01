package com.syu.carinfo.zhtd.bmw;

import android.app.Activity;
import android.content.res.Resources;
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
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ZhtdBmwNewCarinfoAct extends Activity {
    public static boolean mIsFront = false;
    int touchnum = 0;
    int mileunit = 0;
    Runnable mCalTime = new Runnable() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdBmwNewCarinfoAct.1
        @Override // java.lang.Runnable
        public void run() {
            ZhtdBmwNewCarinfoAct.this.touchnum++;
            if (ZhtdBmwNewCarinfoAct.this.touchnum == 3) {
                if (SystemProperties.getInt("persist.fyt.mileunit", 0) == 1) {
                    SystemProperties.set("persist.fyt.mileunit", "0");
                    ZhtdBmwNewCarinfoAct.this.mileunit = 0;
                    ((TextView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.txt_car_total_mileage)).setText(String.valueOf(DataCanbus.DATA[108]) + " km");
                    ((TextView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText("km/h");
                    ZhtdBmwNewCarinfoAct.this.updateSpeed();
                } else {
                    SystemProperties.set("persist.fyt.mileunit", "1");
                    ZhtdBmwNewCarinfoAct.this.mileunit = 1;
                    int value = (DataCanbus.DATA[108] * 10) / 16;
                    ((TextView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.txt_car_total_mileage)).setText(String.valueOf(value) + " miles");
                    ((TextView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText(CamryData.SPEED_UNIT_MILE);
                    ZhtdBmwNewCarinfoAct.this.updateSpeed();
                }
            }
            HandlerUI.getInstance().removeCallbacks(ZhtdBmwNewCarinfoAct.this.mCalTime);
            HandlerUI.getInstance().postDelayed(ZhtdBmwNewCarinfoAct.this.mCalTime, 1000L);
        }
    };
    int bkNum = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdBmwNewCarinfoAct.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = R.drawable.ic_dashboard_car_null;
            if (DataCanbus.DATA[1000] == 7668155 || DataCanbus.DATA[1000] == 1900990 || DataCanbus.DATA[1000] == 2556350 || DataCanbus.DATA[1000] == 2818492 || DataCanbus.DATA[1000] == 1966526 || DataCanbus.DATA[1000] == 6947260 || DataCanbus.DATA[1000] == 2228670 || DataCanbus.DATA[1000] == 7078332 || DataCanbus.DATA[1000] == 2294206 || DataCanbus.DATA[1000] == 7012796 || DataCanbus.DATA[1000] == 983486 || DataCanbus.DATA[1000] == 1049022 || DataCanbus.DATA[1000] == 1114558 || DataCanbus.DATA[1000] == 1442238 || DataCanbus.DATA[1000] == 1507774 || DataCanbus.DATA[1000] == 1573310 || DataCanbus.DATA[1000] == 1638846 || DataCanbus.DATA[1000] == 6488508 || DataCanbus.DATA[1000] == 2163134 || DataCanbus.DATA[1000] == 7733691 || DataCanbus.DATA[1000] == 2032062) {
                switch (updateCode) {
                    case 100:
                        ZhtdBmwNewCarinfoAct.this.mUpdaterTurnleftLight(DataCanbus.DATA[100]);
                        break;
                    case 101:
                        ZhtdBmwNewCarinfoAct.this.mUpdaterTurnrightLight(DataCanbus.DATA[101]);
                        break;
                    case 102:
                        int value = DataCanbus.DATA[102];
                        ImageView imageView = (ImageView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.image_car_belt);
                        Resources resources = ZhtdBmwNewCarinfoAct.this.getResources();
                        if (value == 0) {
                            i = R.drawable.ic_bmwnew_dashboard_car_belt;
                        }
                        imageView.setImageDrawable(resources.getDrawable(i));
                        break;
                    case 103:
                        int value2 = DataCanbus.DATA[103];
                        ImageView imageView2 = (ImageView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.image_car_footbrake);
                        Resources resources2 = ZhtdBmwNewCarinfoAct.this.getResources();
                        if (value2 == 1) {
                            i = R.drawable.ic_bmwnew_dashboard_car_footbrake;
                        }
                        imageView2.setImageDrawable(resources2.getDrawable(i));
                        break;
                    case 104:
                        int value3 = DataCanbus.DATA[104];
                        ImageView imageView3 = (ImageView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.image_car_handbrake);
                        Resources resources3 = ZhtdBmwNewCarinfoAct.this.getResources();
                        if (value3 == 1) {
                            i = R.drawable.ic_bmw_dashboard_car_handbrake_p;
                        }
                        imageView3.setImageDrawable(resources3.getDrawable(i));
                        break;
                    case 105:
                        ZhtdBmwNewCarinfoAct.this.updateSpeed();
                        break;
                    case 106:
                        int value4 = DataCanbus.DATA[106];
                        ((TextView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.txt_car_oil)).setText(String.format("%d L", Integer.valueOf(value4)));
                        break;
                    case 107:
                        int value5 = DataCanbus.DATA[107];
                        ((InfoBmwViewEngineSpeedNew1) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.infoView_enginespeed)).setSpeed(((8000 - value5) * 240) / 8000);
                        break;
                    case 108:
                        int value6 = DataCanbus.DATA[108];
                        if (ZhtdBmwNewCarinfoAct.this.mileunit == 1) {
                            ((TextView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.txt_car_total_mileage)).setText(String.valueOf((value6 * 10) / 16) + " miles");
                        } else {
                            ((TextView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.txt_car_total_mileage)).setText(String.valueOf(value6) + " km");
                        }
                        break;
                }
            }
            switch (updateCode) {
                case 100:
                    ZhtdBmwNewCarinfoAct.this.mUpdaterTurnleftLight(DataCanbus.DATA[100]);
                    break;
                case 101:
                    ZhtdBmwNewCarinfoAct.this.mUpdaterTurnrightLight(DataCanbus.DATA[101]);
                    break;
                case 102:
                    int value7 = DataCanbus.DATA[102];
                    ImageView imageView4 = (ImageView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.image_car_belt);
                    Resources resources4 = ZhtdBmwNewCarinfoAct.this.getResources();
                    if (value7 == 0) {
                        i = R.drawable.ic_bmwnew_dashboard_car_belt;
                    }
                    imageView4.setImageDrawable(resources4.getDrawable(i));
                    break;
                case 103:
                    int value8 = DataCanbus.DATA[103];
                    ImageView imageView5 = (ImageView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.image_car_footbrake);
                    Resources resources5 = ZhtdBmwNewCarinfoAct.this.getResources();
                    if (value8 == 1) {
                        i = R.drawable.ic_bmwnew_dashboard_car_footbrake;
                    }
                    imageView5.setImageDrawable(resources5.getDrawable(i));
                    break;
                case 104:
                    int value9 = DataCanbus.DATA[104];
                    ImageView imageView6 = (ImageView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.image_car_handbrake);
                    Resources resources6 = ZhtdBmwNewCarinfoAct.this.getResources();
                    if (value9 == 1) {
                        i = R.drawable.ic_bmw_dashboard_car_handbrake_p;
                    }
                    imageView6.setImageDrawable(resources6.getDrawable(i));
                    break;
                case 105:
                    ZhtdBmwNewCarinfoAct.this.updateSpeed();
                    break;
                case 106:
                    int value10 = DataCanbus.DATA[106];
                    ((TextView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.txt_car_oil)).setText(String.format("%d L", Integer.valueOf(value10)));
                    break;
                case 107:
                    int value11 = DataCanbus.DATA[107];
                    ((InfoBmwViewEngineSpeedNew1) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.infoView_enginespeed)).setSpeed(((8000 - value11) * 240) / 8000);
                    break;
                case 108:
                    int value12 = DataCanbus.DATA[108];
                    if (ZhtdBmwNewCarinfoAct.this.mileunit == 1) {
                        ((TextView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.txt_car_total_mileage)).setText(String.valueOf((value12 * 10) / 16) + " miles");
                    } else {
                        ((TextView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.txt_car_total_mileage)).setText(String.valueOf(value12) + " km");
                    }
                    break;
                case 131:
                    if (DataCanbus.DATA[1000] != 5112261 && DataCanbus.DATA[1000] != 16122310 && DataCanbus.DATA[1000] != 3146183) {
                        int value13 = DataCanbus.DATA[131];
                        switch (value13) {
                            case 0:
                                ((ImageView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.image_car_gear)).setImageDrawable(ZhtdBmwNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_cargear_p));
                                break;
                            case 1:
                                ((ImageView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.image_car_gear)).setImageDrawable(ZhtdBmwNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_cargear_r));
                                break;
                            case 2:
                                ((ImageView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.image_car_gear)).setImageDrawable(ZhtdBmwNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_cargear_n));
                                break;
                            case 4:
                                ((ImageView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.image_car_gear)).setImageDrawable(ZhtdBmwNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_cargear_d));
                                break;
                            case 5:
                                ((ImageView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.image_car_gear)).setImageDrawable(ZhtdBmwNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_cargear_s));
                                break;
                            case 6:
                                ((ImageView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.image_car_gear)).setImageDrawable(ZhtdBmwNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_cargear_m));
                                break;
                        }
                    }
                    break;
            }
        }
    };
    int num = 0;
    Runnable mShowTurnLeftLight = new Runnable() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdBmwNewCarinfoAct.3
        @Override // java.lang.Runnable
        public void run() {
            ZhtdBmwNewCarinfoAct.this.num++;
            if (ZhtdBmwNewCarinfoAct.this.num > 1) {
                ZhtdBmwNewCarinfoAct.this.num = 0;
            }
            ((ImageView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.image_car_turnl_top)).setImageDrawable(ZhtdBmwNewCarinfoAct.this.getResources().getDrawable(ZhtdBmwNewCarinfoAct.this.num == 1 ? R.drawable.ic_dashboard_car_turnltop : R.drawable.ic_dashboard_car_null));
            HandlerUI.getInstance().removeCallbacks(ZhtdBmwNewCarinfoAct.this.mShowTurnLeftLight);
            HandlerUI.getInstance().postDelayed(ZhtdBmwNewCarinfoAct.this.mShowTurnLeftLight, 500L);
        }
    };
    int num1 = 0;
    Runnable mShowTurnRightLight = new Runnable() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdBmwNewCarinfoAct.4
        @Override // java.lang.Runnable
        public void run() {
            ZhtdBmwNewCarinfoAct.this.num1++;
            if (ZhtdBmwNewCarinfoAct.this.num1 > 1) {
                ZhtdBmwNewCarinfoAct.this.num1 = 0;
            }
            ((ImageView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.image_car_turnr_top)).setImageDrawable(ZhtdBmwNewCarinfoAct.this.getResources().getDrawable(ZhtdBmwNewCarinfoAct.this.num1 == 1 ? R.drawable.ic_dashboard_car_turnrtop : R.drawable.ic_dashboard_car_null));
            HandlerUI.getInstance().removeCallbacks(ZhtdBmwNewCarinfoAct.this.mShowTurnRightLight);
            HandlerUI.getInstance().postDelayed(ZhtdBmwNewCarinfoAct.this.mShowTurnRightLight, 500L);
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.layout_zhtd_bmwnew_dashboard);
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
        findViewById(R.id.infoView_speed).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdBmwNewCarinfoAct.5
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case 0:
                        ZhtdBmwNewCarinfoAct.this.touchnum = 0;
                        ZhtdBmwNewCarinfoAct.this.mUpdatermCalTime(true);
                        return true;
                    case 1:
                        ZhtdBmwNewCarinfoAct.this.mUpdatermCalTime(false);
                        ZhtdBmwNewCarinfoAct.this.touchnum = 0;
                        return true;
                    default:
                        return true;
                }
            }
        });
        findViewById(R.id.btn_plus1).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdBmwNewCarinfoAct.6
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case 0:
                        ZhtdBmwNewCarinfoAct.this.bkNum++;
                        if (ZhtdBmwNewCarinfoAct.this.bkNum >= 7) {
                            ZhtdBmwNewCarinfoAct.this.bkNum = 0;
                        }
                        String bknum = String.format(Locale.US, "%d", Integer.valueOf(ZhtdBmwNewCarinfoAct.this.bkNum));
                        SystemProperties.set("persist.fyt.bmwbknum", bknum);
                        switch (ZhtdBmwNewCarinfoAct.this.bkNum) {
                            case 0:
                                ZhtdBmwNewCarinfoAct.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.bk_dashboard_bmwnew1);
                                break;
                            case 1:
                                ZhtdBmwNewCarinfoAct.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.bk_dashboard_bmwnew2);
                                break;
                            case 2:
                                ZhtdBmwNewCarinfoAct.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.bk_dashboard_bmwnew3);
                                break;
                            case 3:
                                ZhtdBmwNewCarinfoAct.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.bk_dashboard_bmwnew4);
                                break;
                            case 4:
                                ZhtdBmwNewCarinfoAct.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.bk_dashboard_bmwnew5);
                                break;
                            case 5:
                                ZhtdBmwNewCarinfoAct.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.bk_dashboard_bmwnew6);
                                break;
                            case 6:
                                ZhtdBmwNewCarinfoAct.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.bk_dashboard_bmwnew7);
                                break;
                        }
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
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText("km/h");
        }
        this.bkNum = SystemProperties.getInt("persist.fyt.bmwbknum", 0);
        switch (this.bkNum) {
            case 0:
                findViewById(R.id.id_image1).setBackgroundResource(R.drawable.bk_dashboard_bmwnew1);
                break;
            case 1:
                findViewById(R.id.id_image1).setBackgroundResource(R.drawable.bk_dashboard_bmwnew2);
                break;
            case 2:
                findViewById(R.id.id_image1).setBackgroundResource(R.drawable.bk_dashboard_bmwnew3);
                break;
            case 3:
                findViewById(R.id.id_image1).setBackgroundResource(R.drawable.bk_dashboard_bmwnew4);
                break;
            case 4:
                findViewById(R.id.id_image1).setBackgroundResource(R.drawable.bk_dashboard_bmwnew5);
                break;
            case 5:
                findViewById(R.id.id_image1).setBackgroundResource(R.drawable.bk_dashboard_bmwnew6);
                break;
            case 6:
                findViewById(R.id.id_image1).setBackgroundResource(R.drawable.bk_dashboard_bmwnew7);
                break;
        }
        if (DataCanbus.DATA[1000] == 7668155 || DataCanbus.DATA[1000] == 1900990 || DataCanbus.DATA[1000] == 2556350 || DataCanbus.DATA[1000] == 2818492 || DataCanbus.DATA[1000] == 1966526 || DataCanbus.DATA[1000] == 6947260 || DataCanbus.DATA[1000] == 2228670 || DataCanbus.DATA[1000] == 7078332 || DataCanbus.DATA[1000] == 2294206 || DataCanbus.DATA[1000] == 7012796 || DataCanbus.DATA[1000] == 983486 || DataCanbus.DATA[1000] == 1049022 || DataCanbus.DATA[1000] == 1114558 || DataCanbus.DATA[1000] == 1442238 || DataCanbus.DATA[1000] == 1507774 || DataCanbus.DATA[1000] == 1573310 || DataCanbus.DATA[1000] == 1638846 || DataCanbus.DATA[1000] == 6488508 || DataCanbus.DATA[1000] == 2163134 || DataCanbus.DATA[1000] == 7733691 || DataCanbus.DATA[1000] == 2032062) {
            DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        if (DataCanbus.DATA[1000] != 5112261 && DataCanbus.DATA[1000] != 3146183 && DataCanbus.DATA[1000] != 16122310) {
            DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        }
    }

    public void removeNotify() {
        if (DataCanbus.DATA[1000] == 7668155 || DataCanbus.DATA[1000] == 1900990 || DataCanbus.DATA[1000] == 2556350 || DataCanbus.DATA[1000] == 2818492 || DataCanbus.DATA[1000] == 1966526 || DataCanbus.DATA[1000] == 6947260 || DataCanbus.DATA[1000] == 2228670 || DataCanbus.DATA[1000] == 7078332 || DataCanbus.DATA[1000] == 2294206 || DataCanbus.DATA[1000] == 7012796 || DataCanbus.DATA[1000] == 983486 || DataCanbus.DATA[1000] == 1049022 || DataCanbus.DATA[1000] == 1114558 || DataCanbus.DATA[1000] == 1442238 || DataCanbus.DATA[1000] == 1507774 || DataCanbus.DATA[1000] == 1573310 || DataCanbus.DATA[1000] == 1638846 || DataCanbus.DATA[1000] == 6488508 || DataCanbus.DATA[1000] == 2163134 || DataCanbus.DATA[1000] == 7733691 || DataCanbus.DATA[1000] == 2032062) {
            DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        if (DataCanbus.DATA[1000] != 5112261 && DataCanbus.DATA[1000] != 16122310 && DataCanbus.DATA[1000] != 3146183) {
            DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpeed() {
        int speed = DataCanbus.DATA[105];
        if (DataCanbus.DATA[1000] == 7668155 || DataCanbus.DATA[1000] == 1900990 || DataCanbus.DATA[1000] == 2556350 || DataCanbus.DATA[1000] == 2818492 || DataCanbus.DATA[1000] == 1966526 || DataCanbus.DATA[1000] == 6947260 || DataCanbus.DATA[1000] == 2228670 || DataCanbus.DATA[1000] == 7078332 || DataCanbus.DATA[1000] == 2294206 || DataCanbus.DATA[1000] == 7012796 || DataCanbus.DATA[1000] == 983486 || DataCanbus.DATA[1000] == 1049022 || DataCanbus.DATA[1000] == 1114558 || DataCanbus.DATA[1000] == 1442238 || DataCanbus.DATA[1000] == 1507774 || DataCanbus.DATA[1000] == 1573310 || DataCanbus.DATA[1000] == 1638846 || DataCanbus.DATA[1000] == 6488508 || DataCanbus.DATA[1000] == 2163134 || DataCanbus.DATA[1000] == 7733691 || DataCanbus.DATA[1000] == 2032062) {
            speed = DataCanbus.DATA[105];
        }
        if (this.mileunit == 1) {
            speed = (speed * 10) / 16;
        }
        ((InfoBmwViewSpeedNew1) findViewById(R.id.infoView_speed)).setSpeed(speed);
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
