package com.syu.carinfo.lz.jaguar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

@SuppressWarnings({"deprecation", "unchecked"})
public class JaguarNewCarinfoAct_SP extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    int bkNum = 0;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 144:
                    switch (value) {
                        case 0:
                            ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image4)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_null));
                            break;
                        case 1:
                            ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image4)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_hdc));
                            break;
                    }
                case 145:
                    switch (value) {
                        case 0:
                            ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image2)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_null));
                            break;
                        case 1:
                            ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image2)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_low));
                            break;
                        case 2:
                            ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image2)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_high));
                            break;
                    }
                case 147:
                    switch (value) {
                        case 0:
                            ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image1)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_p));
                            break;
                        case 1:
                            ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image1)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_1));
                            break;
                        case 2:
                            ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image1)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_2));
                            break;
                        case 3:
                            ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image1)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_3));
                            break;
                        case 4:
                            ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image1)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_4));
                            break;
                        case 5:
                            ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image1)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_5));
                            break;
                        case 6:
                            ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image1)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_6));
                            break;
                        case 7:
                            ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image1)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_r));
                            break;
                        case 8:
                            ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image1)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_d));
                            break;
                        case 9:
                            ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image1)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_m));
                            break;
                        case 10:
                            ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image1)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_n));
                            break;
                    }
                case 148:
                    ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image5)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_mode0_p));
                    ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image6)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_mode1));
                    ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image7)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_mode2));
                    ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image8)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_mode3));
                    ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image9)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_mode4));
                    switch (value) {
                        case 0:
                            ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image5)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_mode0));
                            ((TextView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.tv_text1)).setText("Special program off");
                            break;
                        case 1:
                            ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image6)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_mode1_p));
                            ((TextView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.tv_text1)).setText("Grass gravel snow");
                            break;
                        case 2:
                            ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image7)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_mode2_p));
                            ((TextView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.tv_text1)).setText("Mud-ruts");
                            break;
                        case 3:
                            ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image8)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_mode3_p));
                            ((TextView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.tv_text1)).setText("Sand");
                            break;
                        case 4:
                            ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image9)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_mode4_p));
                            ((TextView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.tv_text1)).setText("Rock crawl");
                            break;
                    }
                case 149:
                    switch (value) {
                        case 0:
                            ((TextView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.tv_text1)).setText("Standard");
                            break;
                        case 1:
                            ((TextView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.tv_text1)).setText("Off road");
                            break;
                        case 2:
                            ((TextView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.tv_text1)).setText("Access");
                            break;
                    }
                case 150:
                case 151:
                    JaguarNewCarinfoAct_SP.this.updateTire1Distance();
                    JaguarNewCarinfoAct_SP.this.updateTire2Distance();
                    JaguarNewCarinfoAct_SP.this.updateGanFDistance();
                    break;
                case 152:
                case 153:
                    JaguarNewCarinfoAct_SP.this.updateTire3Distance();
                    JaguarNewCarinfoAct_SP.this.updateTire4Distance();
                    JaguarNewCarinfoAct_SP.this.updateGanRDistance();
                    break;
                case 182:
                case 183:
                    int onoff = DataCanbus.DATA[182];
                    int lev = DataCanbus.DATA[183];
                    if (onoff == 1) {
                        switch (lev) {
                            case 0:
                                ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image3)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_r0));
                                break;
                            case 1:
                                ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image3)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_r1));
                                break;
                            case 2:
                                ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image3)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_r2));
                                break;
                            case 3:
                                ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image3)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_r3));
                                break;
                        }
                    } else {
                        switch (lev) {
                            case 0:
                                ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image3)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_g0));
                                break;
                            case 1:
                                ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image3)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_g1));
                                break;
                            case 2:
                                ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image3)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_g2));
                                break;
                            case 3:
                                ((ImageView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.id_image3)).setImageDrawable(JaguarNewCarinfoAct_SP.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_g3));
                                break;
                        }
                    }
                case 189:
                    int flag = 0;
                    if ((32768 & value) != 0) {
                        value = 65536 - value;
                        flag = 1;
                    }
                    int value2 = (value * 30) / 10752;
                    if (flag == 1) {
                        value2 = -value2;
                    }
                    ((InfoJaguarLeftView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.infoView_speed)).setSpeed(value2);
                    ((InfoJaguarLeftView) JaguarNewCarinfoAct_SP.this.findViewById(R.id.infoView_enginespeed)).setSpeed(value2);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_lz_jaguar_44info);
        setSelfClick(findViewById(R.id.btn_plus1), this);
        setSelfClick(findViewById(R.id.btn_plus2), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_plus1 /* 2131427457 */:
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
            case R.id.btn_plus2 /* 2131427460 */:
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

    @Override
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

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
    }

    private void updateTireDistance_delay() {
        HandlerUI.getInstance().postDelayed(new Runnable() { 
            @Override
            public void run() {
                JaguarNewCarinfoAct_SP.this.updateTire1Distance();
                JaguarNewCarinfoAct_SP.this.updateTire2Distance();
                JaguarNewCarinfoAct_SP.this.updateGanFDistance();
                JaguarNewCarinfoAct_SP.this.updateTire3Distance();
                JaguarNewCarinfoAct_SP.this.updateTire4Distance();
                JaguarNewCarinfoAct_SP.this.updateGanRDistance();
            }
        }, 50L);
    }

    
    public void updateTire1Distance() {
        int value = DataCanbus.DATA[150];
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire1 = findViewById(R.id.id_image10);
        if (mIvIconTire1 != null) {
            if (value <= 20) {
                mIvIconTire1.layout((LauncherApplication.getScreenWidth() * 255) / 800, (((((value - 7) * 20) / 13) + 662) * LauncherApplication.getScreenHeight()) / 1100, (LauncherApplication.getScreenWidth() * 317) / 800, ((((((value - 7) * 20) / 13) + 662) + 180) * LauncherApplication.getScreenHeight()) / 1100);
            } else {
                mIvIconTire1.layout((LauncherApplication.getScreenWidth() * 255) / 800, (((((value - 20) * 24) / 10) + 682) * LauncherApplication.getScreenHeight()) / 1100, (LauncherApplication.getScreenWidth() * 317) / 800, ((((((value - 20) * 24) / 10) + 682) + 180) * LauncherApplication.getScreenHeight()) / 1100);
            }
            mIvIconTire1.setImageDrawable(getResources().getDrawable(R.drawable.ic_jaguar_lf_tire));
        }
    }

    
    public void updateTire2Distance() {
        int value = DataCanbus.DATA[151];
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire1 = findViewById(R.id.id_image12);
        if (mIvIconTire1 != null) {
            if (value <= 20) {
                mIvIconTire1.layout((LauncherApplication.getScreenWidth() * Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D50_D2_B30) / 800, (((((value - 7) * 20) / 13) + 662) * LauncherApplication.getScreenHeight()) / 1100, (LauncherApplication.getScreenWidth() * 541) / 800, ((((((value - 7) * 20) / 13) + 662) + 180) * LauncherApplication.getScreenHeight()) / 1100);
            } else {
                mIvIconTire1.layout((LauncherApplication.getScreenWidth() * Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D50_D2_B30) / 800, (((((value - 20) * 24) / 10) + 682) * LauncherApplication.getScreenHeight()) / 1100, (LauncherApplication.getScreenWidth() * 541) / 800, ((((((value - 20) * 24) / 10) + 682) + 180) * LauncherApplication.getScreenHeight()) / 1100);
            }
            mIvIconTire1.setImageDrawable(getResources().getDrawable(R.drawable.ic_jaguar_rf_tire));
        }
    }

    
    public void updateTire3Distance() {
        int value = DataCanbus.DATA[152];
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire1 = findViewById(R.id.id_image13);
        if (mIvIconTire1 != null) {
            if (value <= 20) {
                mIvIconTire1.layout((LauncherApplication.getScreenWidth() * 192) / 800, (((((value - 7) * 22) / 13) + 688) * LauncherApplication.getScreenHeight()) / 1100, (LauncherApplication.getScreenWidth() * 273) / 800, ((((((value - 7) * 22) / 13) + 688) + 213) * LauncherApplication.getScreenHeight()) / 1100);
            } else {
                mIvIconTire1.layout((LauncherApplication.getScreenWidth() * 192) / 800, (((((value - 20) * 24) / 10) + 708) * LauncherApplication.getScreenHeight()) / 1100, (LauncherApplication.getScreenWidth() * 273) / 800, ((((((value - 20) * 24) / 10) + 708) + 213) * LauncherApplication.getScreenHeight()) / 1100);
            }
            mIvIconTire1.setImageDrawable(getResources().getDrawable(R.drawable.ic_jaguar_lr_tire));
        }
    }

    
    public void updateTire4Distance() {
        int value = DataCanbus.DATA[153];
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire1 = findViewById(R.id.id_image15);
        if (mIvIconTire1 != null) {
            if (value <= 20) {
                mIvIconTire1.layout((LauncherApplication.getScreenWidth() * 526) / 800, (((((value - 7) * 22) / 13) + 688) * LauncherApplication.getScreenHeight()) / 1100, (LauncherApplication.getScreenWidth() * 607) / 800, ((((((value - 7) * 22) / 13) + 688) + 213) * LauncherApplication.getScreenHeight()) / 1100);
            } else {
                mIvIconTire1.layout((LauncherApplication.getScreenWidth() * 526) / 800, (((((value - 20) * 24) / 10) + 708) * LauncherApplication.getScreenHeight()) / 1100, (LauncherApplication.getScreenWidth() * 607) / 800, ((((((value - 20) * 24) / 10) + 708) + 213) * LauncherApplication.getScreenHeight()) / 1100);
            }
            mIvIconTire1.setImageDrawable(getResources().getDrawable(R.drawable.ic_jaguar_rr_tire));
        }
    }

    
    public void updateGanFDistance() {
        int value1 = DataCanbus.DATA[150];
        int value2 = DataCanbus.DATA[151];
        int value = (value1 + value2) / 2;
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire1 = findViewById(R.id.id_image11);
        if (mIvIconTire1 != null) {
            if (value <= 20) {
                mIvIconTire1.layout((LauncherApplication.getScreenWidth() * 328) / 800, (((((value - 7) * 20) / 13) + 742) * LauncherApplication.getScreenHeight()) / 1100, (LauncherApplication.getScreenWidth() * Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D11_D2_B5) / 800, ((((((value - 7) * 20) / 13) + 742) + 14) * LauncherApplication.getScreenHeight()) / 1100);
            } else {
                mIvIconTire1.layout((LauncherApplication.getScreenWidth() * 328) / 800, (((((value - 20) * 24) / 10) + 762) * LauncherApplication.getScreenHeight()) / 1100, (LauncherApplication.getScreenWidth() * Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D11_D2_B5) / 800, ((((((value - 20) * 24) / 10) + 762) + 14) * LauncherApplication.getScreenHeight()) / 1100);
            }
            mIvIconTire1.setImageDrawable(getResources().getDrawable(R.drawable.ic_jaguar_f_gan));
        }
    }

    
    public void updateGanRDistance() {
        int value1 = DataCanbus.DATA[152];
        int value2 = DataCanbus.DATA[153];
        int value = (value1 + value2) / 2;
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire1 = findViewById(R.id.id_image14);
        if (mIvIconTire1 != null) {
            if (value <= 20) {
                mIvIconTire1.layout((LauncherApplication.getScreenWidth() * 280) / 800, (((((value - 7) * 22) / 13) + 782) * LauncherApplication.getScreenHeight()) / 1100, (LauncherApplication.getScreenWidth() * 509) / 800, ((((((value - 7) * 22) / 13) + 782) + 24) * LauncherApplication.getScreenHeight()) / 1100);
            } else {
                mIvIconTire1.layout((LauncherApplication.getScreenWidth() * 280) / 800, (((((value - 20) * 24) / 10) + 802) * LauncherApplication.getScreenHeight()) / 1100, (LauncherApplication.getScreenWidth() * 509) / 800, ((((((value - 20) * 24) / 10) + 802) + 24) * LauncherApplication.getScreenHeight()) / 1100);
            }
            mIvIconTire1.setImageDrawable(getResources().getDrawable(R.drawable.ic_jaguar_r_gan));
        }
    }
}
