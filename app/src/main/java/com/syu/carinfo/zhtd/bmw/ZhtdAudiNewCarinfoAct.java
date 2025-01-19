package com.syu.carinfo.zhtd.bmw;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerUI;

public class ZhtdAudiNewCarinfoAct extends Activity {
    public static boolean mIsFront = false;
    int touchnum = 0;
    int mileunit = 0;
    Runnable mCalTime = new Runnable() { 
        @Override
        public void run() {
            ZhtdAudiNewCarinfoAct.this.touchnum++;
            if (ZhtdAudiNewCarinfoAct.this.touchnum == 3) {
                if (SystemProperties.getInt("persist.fyt.mileunit", 0) == 1) {
                    SystemProperties.set("persist.fyt.mileunit", "0");
                    ZhtdAudiNewCarinfoAct.this.mileunit = 0;
                    ((TextView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.txt_car_total_mileage)).setText(String.valueOf(DataCanbus.DATA[108]) + " km");
                    ((TextView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText("km/h");
                    ZhtdAudiNewCarinfoAct.this.updateSpeed();
                } else {
                    SystemProperties.set("persist.fyt.mileunit", "1");
                    ZhtdAudiNewCarinfoAct.this.mileunit = 1;
                    int value = (DataCanbus.DATA[108] * 10) / 16;
                    ((TextView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.txt_car_total_mileage)).setText(String.valueOf(value) + " miles");
                    ((TextView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText(CamryData.SPEED_UNIT_MILE);
                    ZhtdAudiNewCarinfoAct.this.updateSpeed();
                }
            }
            HandlerUI.getInstance().removeCallbacks(ZhtdAudiNewCarinfoAct.this.mCalTime);
            HandlerUI.getInstance().postDelayed(ZhtdAudiNewCarinfoAct.this.mCalTime, 1000L);
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = R.drawable.ic_dashboard_car_null;
            int i2 = R.drawable.ic_bmw_dashboard_car_null;
            switch (updateCode) {
                case 1:
                    int value = DataCanbus.DATA[1];
                    ((ImageView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.image_car_door_fl)).setImageDrawable(ZhtdAudiNewCarinfoAct.this.getResources().getDrawable(value == 1 ? R.drawable.ic_audi_dashboard_car_door_fl : 2130839697));
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
                case 98:
                case 99:
                    int value5 = DataCanbus.DATA[98];
                    int value1 = DataCanbus.DATA[99];
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
                case 100:
                    ZhtdAudiNewCarinfoAct.this.mUpdaterTurnleftLight(DataCanbus.DATA[100]);
                    break;
                case 101:
                    ZhtdAudiNewCarinfoAct.this.mUpdaterTurnrightLight(DataCanbus.DATA[101]);
                    break;
                case 102:
                    int value6 = DataCanbus.DATA[102];
                    ImageView imageView4 = (ImageView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.image_car_belt);
                    Resources resources4 = ZhtdAudiNewCarinfoAct.this.getResources();
                    if (value6 == 0) {
                        i = R.drawable.ic_bmwnew_dashboard_car_belt;
                    }
                    imageView4.setImageDrawable(resources4.getDrawable(i));
                    break;
                case 103:
                    int value7 = DataCanbus.DATA[103];
                    ImageView imageView5 = (ImageView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.image_car_footbrake);
                    Resources resources5 = ZhtdAudiNewCarinfoAct.this.getResources();
                    if (value7 == 1) {
                        i = R.drawable.ic_bmwnew_dashboard_car_footbrake;
                    }
                    imageView5.setImageDrawable(resources5.getDrawable(i));
                    break;
                case 104:
                    int value8 = DataCanbus.DATA[104];
                    ImageView imageView6 = (ImageView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.image_car_handbrake);
                    Resources resources6 = ZhtdAudiNewCarinfoAct.this.getResources();
                    if (value8 == 1) {
                        i = R.drawable.ic_bmw_dashboard_car_handbrake_p;
                    }
                    imageView6.setImageDrawable(resources6.getDrawable(i));
                    break;
                case 105:
                    ZhtdAudiNewCarinfoAct.this.updateSpeed();
                    break;
                case 106:
                    int value9 = DataCanbus.DATA[106];
                    ((TextView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.txt_car_oil)).setText(String.format("%d L", Integer.valueOf(value9)));
                    break;
                case 107:
                    int value10 = DataCanbus.DATA[107];
                    ((InfoAudiViewEngineSpeed) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.infoView_enginespeed)).setSpeed((value10 * 240) / 8000);
                    break;
                case 108:
                    int value11 = DataCanbus.DATA[108];
                    if (ZhtdAudiNewCarinfoAct.this.mileunit == 1) {
                        ((TextView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.txt_car_total_mileage)).setText(String.valueOf((value11 * 10) / 16) + " miles");
                        break;
                    } else {
                        ((TextView) ZhtdAudiNewCarinfoAct.this.findViewById(R.id.txt_car_total_mileage)).setText(String.valueOf(value11) + " km");
                        break;
                    }
                case 131:
                    int value12 = DataCanbus.DATA[131];
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
    Runnable mShowTurnLeftLight = new Runnable() { 
        @Override
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
    Runnable mShowTurnRightLight = new Runnable() { 
        @Override
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        //setContentView(R.layout.layout_zhtd_audinew_dashboard);
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
                    com.syu.carinfo.zhtd.bmw.ZhtdAudiNewCarinfoAct r0 = com.syu.carinfo.zhtd.bmw.ZhtdAudiNewCarinfoAct.this
                    com.syu.carinfo.zhtd.bmw.ZhtdAudiNewCarinfoAct.access$3(r0, r1)
                    com.syu.carinfo.zhtd.bmw.ZhtdAudiNewCarinfoAct r0 = com.syu.carinfo.zhtd.bmw.ZhtdAudiNewCarinfoAct.this
                    r0.touchnum = r1
                    goto L9
                L14:
                    com.syu.carinfo.zhtd.bmw.ZhtdAudiNewCarinfoAct r0 = com.syu.carinfo.zhtd.bmw.ZhtdAudiNewCarinfoAct.this
                    r0.touchnum = r1
                    com.syu.carinfo.zhtd.bmw.ZhtdAudiNewCarinfoAct r0 = com.syu.carinfo.zhtd.bmw.ZhtdAudiNewCarinfoAct.this
                    com.syu.carinfo.zhtd.bmw.ZhtdAudiNewCarinfoAct.access$3(r0, r2)
                    goto L9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.zhtd.bmw.ZhtdAudiNewCarinfoAct.AnonymousClass5.onTouch(android.view.View, android.view.MotionEvent):boolean");
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
        DoorHelper.disableDoorWindowLocal(true);
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
        DoorHelper.disableDoorWindowLocal(false);
        mIsFront = false;
    }

    public void addNotify() {
        this.mileunit = SystemProperties.getInt("persist.fyt.mileunit", 0);
        if (this.mileunit == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(CamryData.SPEED_UNIT_MILE);
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText("km/h");
        }
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateSpeed() {
        int speed = DataCanbus.DATA[105];
        if (this.mileunit == 1) {
            speed = (speed * 10) / 16;
        }
        ((InfoAudiViewSpeed) findViewById(R.id.infoView_speed)).setSpeed(speed);
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
