package com.syu.carinfo.lz.jaguar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class JaguarNewCarinfoAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    int bkNum = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.jaguar.JaguarNewCarinfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 81:
                    switch (value) {
                        case 0:
                            ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image4)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_null));
                            break;
                        case 1:
                            ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image4)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_hdc));
                            break;
                    }
                case 82:
                    switch (value) {
                        case 0:
                            ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image2)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_null));
                            break;
                        case 1:
                            ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image2)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_low));
                            break;
                        case 2:
                            ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image2)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_high));
                            break;
                    }
                case 84:
                    switch (value) {
                        case 0:
                            ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_p));
                            break;
                        case 1:
                            ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_1));
                            break;
                        case 2:
                            ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_2));
                            break;
                        case 3:
                            ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_3));
                            break;
                        case 4:
                            ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_4));
                            break;
                        case 5:
                            ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_5));
                            break;
                        case 6:
                            ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_6));
                            break;
                        case 7:
                            ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_r));
                            break;
                        case 8:
                            ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_d));
                            break;
                        case 9:
                            ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_m));
                            break;
                        case 10:
                            ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_n));
                            break;
                    }
                case 85:
                    ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image5)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode0_p));
                    ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image6)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode1));
                    ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image7)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode2));
                    ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image8)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode3));
                    ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image9)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode4));
                    switch (value) {
                        case 0:
                            ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image5)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode0));
                            ((TextView) JaguarNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText("Special program off");
                            break;
                        case 1:
                            ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image6)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode1_p));
                            ((TextView) JaguarNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText("Grass gravel snow");
                            break;
                        case 2:
                            ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image7)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode2_p));
                            ((TextView) JaguarNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText("Mud-ruts");
                            break;
                        case 3:
                            ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image8)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode3_p));
                            ((TextView) JaguarNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText("Sand");
                            break;
                        case 4:
                            ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image9)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode4_p));
                            ((TextView) JaguarNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText("Rock crawl");
                            break;
                    }
                case 86:
                    switch (value) {
                        case 0:
                            ((TextView) JaguarNewCarinfoAct.this.findViewById(R.id.tv_text2)).setText("Standard");
                            break;
                        case 1:
                            ((TextView) JaguarNewCarinfoAct.this.findViewById(R.id.tv_text2)).setText("Off road");
                            break;
                        case 2:
                            ((TextView) JaguarNewCarinfoAct.this.findViewById(R.id.tv_text2)).setText("Access");
                            break;
                    }
                case 87:
                case 88:
                    JaguarNewCarinfoAct.this.updateTire1Distance();
                    JaguarNewCarinfoAct.this.updateTire2Distance();
                    JaguarNewCarinfoAct.this.updateGanFDistance();
                    break;
                case 89:
                case 90:
                    JaguarNewCarinfoAct.this.updateTire3Distance();
                    JaguarNewCarinfoAct.this.updateTire4Distance();
                    JaguarNewCarinfoAct.this.updateGanRDistance();
                    break;
                case 123:
                case 124:
                    int onoff = DataCanbus.DATA[123];
                    int lev = DataCanbus.DATA[124];
                    if (onoff == 1) {
                        switch (lev) {
                            case 0:
                                ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image3)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_r0));
                                break;
                            case 1:
                                ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image3)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_r1));
                                break;
                            case 2:
                                ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image3)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_r2));
                                break;
                            case 3:
                                ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image3)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_r3));
                                break;
                        }
                    } else {
                        switch (lev) {
                            case 0:
                                ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image3)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_g0));
                                break;
                            case 1:
                                ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image3)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_g1));
                                break;
                            case 2:
                                ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image3)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_g2));
                                break;
                            case 3:
                                ((ImageView) JaguarNewCarinfoAct.this.findViewById(R.id.id_image3)).setImageDrawable(JaguarNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_g3));
                                break;
                        }
                    }
                case 130:
                    int flag = 0;
                    if ((32768 & value) != 0) {
                        value = 65536 - value;
                        flag = 1;
                    }
                    int value2 = (value * 30) / 10752;
                    if (flag == 1) {
                        value2 = 0 - value2;
                    }
                    ((InfoJaguarLeftView) JaguarNewCarinfoAct.this.findViewById(R.id.infoView_speed)).setSpeed(value2);
                    ((InfoJaguarLeftView) JaguarNewCarinfoAct.this.findViewById(R.id.infoView_enginespeed)).setSpeed(value2);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lz_jaguar_44info);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_plus1 /* 2131427482 */:
                this.bkNum = 1;
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.id_image10).setVisibility(8);
                findViewById(R.id.id_image11).setVisibility(8);
                findViewById(R.id.id_image12).setVisibility(8);
                findViewById(R.id.id_image13).setVisibility(8);
                findViewById(R.id.id_image14).setVisibility(8);
                findViewById(R.id.id_image15).setVisibility(8);
                findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_jaguar_drivemode_p);
                findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_jaguar_sup);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                this.bkNum = 0;
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.id_image10).setVisibility(0);
                findViewById(R.id.id_image11).setVisibility(0);
                findViewById(R.id.id_image12).setVisibility(0);
                findViewById(R.id.id_image13).setVisibility(0);
                findViewById(R.id.id_image14).setVisibility(0);
                findViewById(R.id.id_image15).setVisibility(0);
                findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_jaguar_drivemode);
                findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_jaguar_sup_p);
                updateTireDistance_delay();
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        updateTireDistance_delay();
        switch (this.bkNum) {
            case 0:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.id_image10).setVisibility(0);
                findViewById(R.id.id_image11).setVisibility(0);
                findViewById(R.id.id_image12).setVisibility(0);
                findViewById(R.id.id_image13).setVisibility(0);
                findViewById(R.id.id_image14).setVisibility(0);
                findViewById(R.id.id_image15).setVisibility(0);
                findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_jaguar_drivemode);
                findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_jaguar_sup_p);
                break;
            case 1:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.id_image10).setVisibility(8);
                findViewById(R.id.id_image11).setVisibility(8);
                findViewById(R.id.id_image12).setVisibility(8);
                findViewById(R.id.id_image13).setVisibility(8);
                findViewById(R.id.id_image14).setVisibility(8);
                findViewById(R.id.id_image15).setVisibility(8);
                findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_jaguar_drivemode_p);
                findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_jaguar_sup);
                break;
        }
        addNotify();
        mIsFront = true;
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[84].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[82].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[81].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[85].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[84].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[85].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
    }

    private void updateTireDistance_delay() {
        HandlerUI.getInstance().postDelayed(new Runnable() { // from class: com.syu.carinfo.lz.jaguar.JaguarNewCarinfoAct.2
            @Override // java.lang.Runnable
            public void run() {
                JaguarNewCarinfoAct.this.updateTire1Distance();
                JaguarNewCarinfoAct.this.updateTire2Distance();
                JaguarNewCarinfoAct.this.updateGanFDistance();
                JaguarNewCarinfoAct.this.updateTire3Distance();
                JaguarNewCarinfoAct.this.updateTire4Distance();
                JaguarNewCarinfoAct.this.updateGanRDistance();
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTire1Distance() {
        int value = DataCanbus.DATA[87];
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire1 = (ImageView) findViewById(R.id.id_image10);
        if (mIvIconTire1 != null) {
            if (value <= 20) {
                mIvIconTire1.layout(1133, (((value - 7) * 20) / 13) + 133, 1227, (((value - 7) * 20) / 13) + 133 + 180);
            } else {
                mIvIconTire1.layout(1133, (((value - 20) * 24) / 10) + 153, 1227, (((value - 20) * 24) / 10) + 153 + 180);
            }
            mIvIconTire1.setImageDrawable(getResources().getDrawable(R.drawable.ic_jaguar_lf_tire));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTire2Distance() {
        int value = DataCanbus.DATA[88];
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire1 = (ImageView) findViewById(R.id.id_image12);
        if (mIvIconTire1 != null) {
            if (value <= 20) {
                mIvIconTire1.layout(1469, (((value - 7) * 20) / 13) + 133, 1563, (((value - 7) * 20) / 13) + 133 + 180);
            } else {
                mIvIconTire1.layout(1469, (((value - 20) * 24) / 10) + 153, 1563, (((value - 20) * 24) / 10) + 153 + 180);
            }
            mIvIconTire1.setImageDrawable(getResources().getDrawable(R.drawable.ic_jaguar_rf_tire));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTire3Distance() {
        int value = DataCanbus.DATA[89];
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire1 = (ImageView) findViewById(R.id.id_image13);
        if (mIvIconTire1 != null) {
            if (value <= 20) {
                mIvIconTire1.layout(1038, (((value - 7) * 22) / 13) + 184, 1160, (((value - 7) * 22) / 13) + 184 + 213);
            } else {
                mIvIconTire1.layout(1038, (((value - 20) * 24) / 10) + 204, 1160, (((value - 20) * 24) / 10) + 204 + 213);
            }
            mIvIconTire1.setImageDrawable(getResources().getDrawable(R.drawable.ic_jaguar_lr_tire));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTire4Distance() {
        int value = DataCanbus.DATA[90];
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire1 = (ImageView) findViewById(R.id.id_image15);
        if (mIvIconTire1 != null) {
            if (value <= 20) {
                mIvIconTire1.layout(1539, (((value - 7) * 22) / 13) + 184, 1661, (((value - 7) * 22) / 13) + 184 + 213);
            } else {
                mIvIconTire1.layout(1539, (((value - 20) * 24) / 10) + 204, 1661, (((value - 20) * 24) / 10) + 204 + 213);
            }
            mIvIconTire1.setImageDrawable(getResources().getDrawable(R.drawable.ic_jaguar_rr_tire));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGanFDistance() {
        int value1 = DataCanbus.DATA[87];
        int value2 = DataCanbus.DATA[88];
        int value = (value1 + value2) / 2;
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire1 = (ImageView) findViewById(R.id.id_image11);
        if (mIvIconTire1 != null) {
            if (value <= 20) {
                mIvIconTire1.layout(1242, (((value - 7) * 20) / 13) + 215, 1459, (((value - 7) * 20) / 13) + 215 + 14);
            } else {
                mIvIconTire1.layout(1242, (((value - 20) * 24) / 10) + 235, 1459, (((value - 20) * 24) / 10) + 235 + 14);
            }
            mIvIconTire1.setImageDrawable(getResources().getDrawable(R.drawable.ic_jaguar_f_gan));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGanRDistance() {
        int value1 = DataCanbus.DATA[89];
        int value2 = DataCanbus.DATA[90];
        int value = (value1 + value2) / 2;
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire1 = (ImageView) findViewById(R.id.id_image14);
        if (mIvIconTire1 != null) {
            if (value <= 20) {
                mIvIconTire1.layout(1170, (((value - 7) * 22) / 13) + 283, 1514, (((value - 7) * 22) / 13) + 283 + 24);
            } else {
                mIvIconTire1.layout(1170, (((value - 20) * 24) / 10) + 303, 1514, (((value - 20) * 24) / 10) + 303 + 24);
            }
            mIvIconTire1.setImageDrawable(getResources().getDrawable(R.drawable.ic_jaguar_r_gan));
        }
    }
}
