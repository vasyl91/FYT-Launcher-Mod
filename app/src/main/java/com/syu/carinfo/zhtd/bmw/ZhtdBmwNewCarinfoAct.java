package com.syu.carinfo.zhtd.bmw;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ZhtdBmwNewCarinfoAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    int bkNum = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdBmwNewCarinfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = R.drawable.ic_dashboard_car_null;
            switch (updateCode) {
                case 9:
                    ZhtdBmwNewCarinfoAct.this.mUpdaterTurnleftLight(DataCanbus.DATA[9]);
                    break;
                case 10:
                    ZhtdBmwNewCarinfoAct.this.mUpdaterTurnrightLight(DataCanbus.DATA[10]);
                    break;
                case 11:
                    int value = DataCanbus.DATA[11];
                    ImageView imageView = (ImageView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.image_car_belt);
                    Resources resources = ZhtdBmwNewCarinfoAct.this.getResources();
                    if (value == 0) {
                        i = R.drawable.ic_bmwnew_dashboard_car_belt;
                    }
                    imageView.setImageDrawable(resources.getDrawable(i));
                    break;
                case 12:
                    int value2 = DataCanbus.DATA[12];
                    ImageView imageView2 = (ImageView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.image_car_footbrake);
                    Resources resources2 = ZhtdBmwNewCarinfoAct.this.getResources();
                    if (value2 == 1) {
                        i = R.drawable.ic_bmwnew_dashboard_car_footbrake;
                    }
                    imageView2.setImageDrawable(resources2.getDrawable(i));
                    break;
                case 13:
                    int value3 = DataCanbus.DATA[13];
                    ImageView imageView3 = (ImageView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.image_car_handbrake);
                    Resources resources3 = ZhtdBmwNewCarinfoAct.this.getResources();
                    if (value3 == 1) {
                        i = R.drawable.ic_bmw_dashboard_car_handbrake_p;
                    }
                    imageView3.setImageDrawable(resources3.getDrawable(i));
                    break;
                case 14:
                    int speed = DataCanbus.DATA[14];
                    ((InfoBmwViewSpeedNew1) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.infoView_speed)).setSpeed(speed);
                    break;
                case 15:
                    int value4 = DataCanbus.DATA[15];
                    ((TextView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.txt_car_oil)).setText(String.format("%d L", Integer.valueOf(value4)));
                    break;
                case 16:
                    int value5 = DataCanbus.DATA[16];
                    ((InfoBmwViewEngineSpeedNew1) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.infoView_enginespeed)).setSpeed(((8000 - value5) * 240) / 8000);
                    break;
                case 17:
                    int value6 = DataCanbus.DATA[17];
                    ((TextView) ZhtdBmwNewCarinfoAct.this.findViewById(R.id.txt_car_total_mileage)).setText(String.valueOf(value6) + " km");
                    break;
                case 62:
                    if (DataCanbus.DATA[1000] != 5112261) {
                        int value7 = DataCanbus.DATA[62];
                        switch (value7) {
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
    Runnable mShowTurnLeftLight = new Runnable() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdBmwNewCarinfoAct.2
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
    Runnable mShowTurnRightLight = new Runnable() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdBmwNewCarinfoAct.3
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.layout_zhtd_bmwnew_dashboard);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_plus1 /* 2131427482 */:
                this.bkNum++;
                if (this.bkNum >= 7) {
                    this.bkNum = 0;
                }
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
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(0, new int[]{1, 1}, null, null);
        mIsFront = true;
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
        int[] iArr = new int[4];
        iArr[0] = 1;
        remoteModuleProxy.cmd(0, iArr, null, null);
        mIsFront = false;
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        if (DataCanbus.DATA[1000] != 5112261) {
            DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        if (DataCanbus.DATA[1000] != 5112261) {
            DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        }
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
