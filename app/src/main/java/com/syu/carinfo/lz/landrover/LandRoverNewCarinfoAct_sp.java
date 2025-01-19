package com.syu.carinfo.lz.landrover;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

public class LandRoverNewCarinfoAct_sp extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    int bkNum = 0;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 19:
                    switch (value) {
                        case 0:
                            ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image4)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_null));
                            break;
                        case 1:
                            ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image4)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_hdc));
                            break;
                    }
                case 20:
                    switch (value) {
                        case 0:
                            ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image2)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_null));
                            break;
                        case 1:
                            ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image2)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_low));
                            break;
                        case 2:
                            ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image2)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_high));
                            break;
                    }
                case 22:
                    ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image5)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_mode0_p));
                    ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image6)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_mode1));
                    ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image7)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_mode2));
                    ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image8)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_mode3));
                    ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image9)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_mode4));
                    switch (value) {
                        case 0:
                            ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image5)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_mode0));
                            ((TextView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.tv_text1)).setText("Special program off");
                            break;
                        case 1:
                            ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image6)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_mode1_p));
                            ((TextView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.tv_text1)).setText("Grass gravel snow");
                            break;
                        case 2:
                            ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image7)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_mode2_p));
                            ((TextView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.tv_text1)).setText("Mud-ruts");
                            break;
                        case 3:
                            ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image8)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_mode3_p));
                            ((TextView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.tv_text1)).setText("Sand");
                            break;
                        case 4:
                            ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image9)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_mode4_p));
                            ((TextView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.tv_text1)).setText("Rock crawl");
                            break;
                    }
                case 23:
                    switch (value) {
                        case 0:
                            ((TextView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.tv_text1)).setText("Standard");
                            break;
                        case 1:
                            ((TextView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.tv_text1)).setText("Off road");
                            break;
                        case 2:
                            ((TextView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.tv_text1)).setText("Access");
                            break;
                    }
                case 24:
                case 25:
                    LandRoverNewCarinfoAct_sp.this.updateTire1Distance();
                    LandRoverNewCarinfoAct_sp.this.updateTire2Distance();
                    LandRoverNewCarinfoAct_sp.this.updateGanFDistance();
                    break;
                case 26:
                case 27:
                    LandRoverNewCarinfoAct_sp.this.updateTire3Distance();
                    LandRoverNewCarinfoAct_sp.this.updateTire4Distance();
                    LandRoverNewCarinfoAct_sp.this.updateGanRDistance();
                    break;
                case 28:
                    switch (value) {
                        case 0:
                            ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image1)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_p));
                            break;
                        case 1:
                            ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image1)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_1));
                            break;
                        case 2:
                            ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image1)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_2));
                            break;
                        case 3:
                            ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image1)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_3));
                            break;
                        case 4:
                            ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image1)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_4));
                            break;
                        case 5:
                            ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image1)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_5));
                            break;
                        case 6:
                            ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image1)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_6));
                            break;
                        case 7:
                            ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image1)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_r));
                            break;
                        case 8:
                            ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image1)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_d));
                            break;
                        case 9:
                            ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image1)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_m));
                            break;
                        case 10:
                            ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image1)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_n));
                            break;
                    }
                case 29:
                    int flag = value & 65536;
                    int value2 = ((value & 65535) * 30) / Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D1_B10;
                    if (flag != 0) {
                        value2 = -value2;
                    }
                    ((InfoLZLandroverLeftView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.infoView_speed)).setSpeed(value2);
                    ((InfoLZLandroverLeftView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.infoView_enginespeed)).setSpeed(value2);
                    break;
                case 30:
                case 31:
                    int onoff = DataCanbus.DATA[30];
                    int lev = DataCanbus.DATA[31];
                    if (onoff == 1) {
                        switch (lev) {
                            case 0:
                                ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image3)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_r0));
                                break;
                            case 1:
                                ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image3)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_r1));
                                break;
                            case 2:
                                ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image3)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_r2));
                                break;
                            case 3:
                                ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image3)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_r3));
                                break;
                        }
                    } else {
                        switch (lev) {
                            case 0:
                                ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image3)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_g0));
                                break;
                            case 1:
                                ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image3)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_g1));
                                break;
                            case 2:
                                ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image3)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_g2));
                                break;
                            case 3:
                                ((ImageView) LandRoverNewCarinfoAct_sp.this.findViewById(R.id.id_image3)).setImageDrawable(LandRoverNewCarinfoAct_sp.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_g3));
                                break;
                        }
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_lz_landrover_44info);
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
        Log.v("zed", " LauncherApplication.getScreenWidth() == " + LauncherApplication.getScreenWidth() + "  LauncherApplication.getScreenHeight() = " + LauncherApplication.getScreenHeight());
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
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
    }

    private void updateTireDistance_delay() {
        HandlerUI.getInstance().postDelayed(new Runnable() { 
            @Override
            public void run() {
                LandRoverNewCarinfoAct_sp.this.updateTire1Distance();
                LandRoverNewCarinfoAct_sp.this.updateTire2Distance();
                LandRoverNewCarinfoAct_sp.this.updateGanFDistance();
                LandRoverNewCarinfoAct_sp.this.updateTire3Distance();
                LandRoverNewCarinfoAct_sp.this.updateTire4Distance();
                LandRoverNewCarinfoAct_sp.this.updateGanRDistance();
            }
        }, 50L);
    }

    
    public void updateTire1Distance() {
        int value = DataCanbus.DATA[24];
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
        int value = DataCanbus.DATA[25];
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
        int value = DataCanbus.DATA[26];
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
        int value = DataCanbus.DATA[27];
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
        int value1 = DataCanbus.DATA[24];
        int value2 = DataCanbus.DATA[25];
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
        int value1 = DataCanbus.DATA[26];
        int value2 = DataCanbus.DATA[27];
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
