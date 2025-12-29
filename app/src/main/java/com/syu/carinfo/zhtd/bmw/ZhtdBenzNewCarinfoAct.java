package com.syu.carinfo.zhtd.bmw;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.SystemProperties;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

@SuppressWarnings({"deprecation", "unchecked"})
public class ZhtdBenzNewCarinfoAct extends Activity {
    public static boolean mIsFront = false;
    int touchnum = 0;
    int mileunit = 0;
    Runnable mCalTime = new Runnable() { 
        @Override
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
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = R.drawable.ic_dashboard_car_null;
            switch (updateCode) {
                case 98:
                case 99:
                    int value = DataCanbus.DATA[98];
                    int value1 = DataCanbus.DATA[99];
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
                case 100:
                    ZhtdBenzNewCarinfoAct.this.mUpdaterTurnleftLight(DataCanbus.DATA[100]);
                    break;
                case 101:
                    ZhtdBenzNewCarinfoAct.this.mUpdaterTurnrightLight(DataCanbus.DATA[101]);
                    break;
                case 102:
                    int value2 = DataCanbus.DATA[102];
                    ImageView imageView = (ImageView) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.image_car_belt);
                    Resources resources = ZhtdBenzNewCarinfoAct.this.getResources();
                    if (value2 == 0) {
                        i = R.drawable.ic_bmwnew_dashboard_car_belt;
                    }
                    imageView.setImageDrawable(resources.getDrawable(i));
                    break;
                case 104:
                    int value3 = DataCanbus.DATA[104];
                    ImageView imageView2 = (ImageView) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.image_car_handbrake);
                    Resources resources2 = ZhtdBenzNewCarinfoAct.this.getResources();
                    if (value3 == 1) {
                        i = R.drawable.ic_bmw_dashboard_car_handbrake_p;
                    }
                    imageView2.setImageDrawable(resources2.getDrawable(i));
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
                        break;
                    } else {
                        ((TextView) ZhtdBenzNewCarinfoAct.this.findViewById(R.id.txt_car_total_mileage)).setText(String.valueOf(value5) + " km");
                        break;
                    }
            }
        }
    };
    int num = 0;
    Runnable mShowTurnLeftLight = new Runnable() { 
        @Override
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
    Runnable mShowTurnRightLight = new Runnable() { 
        @Override
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        //setContentView(R.layout.layout_zhtd_benznew_dashboard);
        initUI();
    }

    
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
        if (DataCanbus.DATA[1000] == 7668155 || DataCanbus.DATA[1000] == 2818492 || DataCanbus.DATA[1000] == 655804) {
            findViewById(R.id.txt_car_total_mileage).setVisibility(8);
        } else {
            findViewById(R.id.txt_car_total_mileage).setVisibility(0);
        }
        findViewById(R.id.infoView_speed).setOnTouchListener(new View.OnTouchListener() { 
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:3:0x0009, code lost:
            
                return true;
             */
            @Override
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean onTouch(android.view.View r4, android.view.MotionEvent r5) {
                /*
                    r3 = this;
                    r2 = 1
                    r1 = 0
                    int r0 = r5.getAction()
                    switch(r0) {
                        case 0: goto L14;
                        case 1: goto La;
                        default: goto L9;
                    }
                L9:
                    return r2
                La:
                    com.syu.carinfo.zhtd.bmw.ZhtdBenzNewCarinfoAct r0 = com.syu.carinfo.zhtd.bmw.ZhtdBenzNewCarinfoAct.this
                    com.syu.carinfo.zhtd.bmw.ZhtdBenzNewCarinfoAct.access$3(r0, r1)
                    com.syu.carinfo.zhtd.bmw.ZhtdBenzNewCarinfoAct r0 = com.syu.carinfo.zhtd.bmw.ZhtdBenzNewCarinfoAct.this
                    r0.touchnum = r1
                    goto L9
                L14:
                    com.syu.carinfo.zhtd.bmw.ZhtdBenzNewCarinfoAct r0 = com.syu.carinfo.zhtd.bmw.ZhtdBenzNewCarinfoAct.this
                    r0.touchnum = r1
                    com.syu.carinfo.zhtd.bmw.ZhtdBenzNewCarinfoAct r0 = com.syu.carinfo.zhtd.bmw.ZhtdBenzNewCarinfoAct.this
                    com.syu.carinfo.zhtd.bmw.ZhtdBenzNewCarinfoAct.access$3(r0, r2)
                    goto L9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.zhtd.bmw.ZhtdBenzNewCarinfoAct.AnonymousClass5.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
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
        mIsFront = true;
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

    
    public void updateSpeed() {
        int speed = DataCanbus.DATA[105];
        if (this.mileunit == 1) {
            speed = (speed * 10) / 16;
        }
        ((InfoBenzViewSpeed) findViewById(R.id.infoView_speed)).setSpeed(speed);
        ((TextView) findViewById(R.id.txt_car_speed)).setText(new StringBuilder(String.valueOf(speed)).toString());
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
