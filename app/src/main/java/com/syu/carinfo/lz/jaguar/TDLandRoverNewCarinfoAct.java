package com.syu.carinfo.lz.jaguar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

public class TDLandRoverNewCarinfoAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    int bkNum = 0;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 143:
                    switch (value) {
                        case 0:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image4)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_null));
                            break;
                        case 1:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image4)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_hdc));
                            break;
                    }
                case 144:
                    switch (value) {
                        case 0:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image2)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_null));
                            break;
                        case 1:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image2)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_low));
                            break;
                        case 2:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image2)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_high));
                            break;
                    }
                case 153:
                    ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image5)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode0_p));
                    ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image6)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode1));
                    ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image7)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode2));
                    ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image8)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode3));
                    ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image9)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode4));
                    switch (value) {
                        case 0:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image5)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode0));
                            ((TextView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText("Special program off");
                            break;
                        case 1:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image6)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode1_p));
                            ((TextView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText("Grass gravel snow");
                            break;
                        case 2:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image7)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode2_p));
                            ((TextView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText("Mud-ruts");
                            break;
                        case 3:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image8)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode3_p));
                            ((TextView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText("Sand");
                            break;
                        case 4:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image9)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode4_p));
                            ((TextView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText("Rock crawl");
                            break;
                    }
                case 154:
                    switch (value) {
                        case 0:
                            ((TextView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text2)).setText("Standard");
                            break;
                        case 1:
                            ((TextView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text2)).setText("Off road");
                            break;
                        case 2:
                            ((TextView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text2)).setText("Access");
                            break;
                    }
                case 155:
                    switch (value) {
                        case 0:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_p));
                            break;
                        case 1:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_1));
                            break;
                        case 2:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_2));
                            break;
                        case 3:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_3));
                            break;
                        case 4:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_4));
                            break;
                        case 5:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_5));
                            break;
                        case 6:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_6));
                            break;
                        case 7:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_r));
                            break;
                        case 8:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_d));
                            break;
                        case 9:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_m));
                            break;
                        case 10:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_s));
                            break;
                        case 11:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_n));
                            break;
                    }
                case 156:
                    TDLandRoverNewCarinfoAct.this.updateTire1Distance();
                    TDLandRoverNewCarinfoAct.this.updateGanFDistance();
                    break;
                case 157:
                    TDLandRoverNewCarinfoAct.this.updateTire2Distance();
                    TDLandRoverNewCarinfoAct.this.updateGanFDistance();
                    break;
                case 158:
                    TDLandRoverNewCarinfoAct.this.updateTire3Distance();
                    TDLandRoverNewCarinfoAct.this.updateGanRDistance();
                    break;
                case 159:
                    TDLandRoverNewCarinfoAct.this.updateTire4Distance();
                    TDLandRoverNewCarinfoAct.this.updateGanRDistance();
                    break;
                case 162:
                    switch (value) {
                        case 0:
                            ((TextView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text3)).setText("");
                            break;
                        case 1:
                            ((TextView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text3)).setText("ESP OFF");
                            break;
                    }
                case 163:
                    switch (value) {
                        case 0:
                            ((TextView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text4)).setText("");
                            break;
                        case 1:
                            ((TextView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text4)).setText("ASL");
                            break;
                    }
                case 164:
                    switch (value) {
                        case 0:
                            ((TextView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text5)).setText("");
                            break;
                        case 1:
                            ((TextView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text5)).setText("ATPC");
                            break;
                    }
                case 167:
                    int lev = DataCanbus.DATA[167];
                    switch (lev) {
                        case 0:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image3)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_g0));
                            break;
                        case 1:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image3)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_r1));
                            break;
                        case 2:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image3)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_r2));
                            break;
                        case 3:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image3)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_r3));
                            break;
                    }
                case 168:
                    int lev2 = DataCanbus.DATA[168];
                    switch (lev2) {
                        case 0:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image16)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_g0));
                            break;
                        case 1:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image16)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_r1));
                            break;
                        case 2:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image16)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_r2));
                            break;
                        case 3:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image16)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_r3));
                            break;
                    }
                case 169:
                    switch (value) {
                        case 0:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image17)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_null));
                            break;
                        case 1:
                            ((ImageView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.id_image17)).setImageDrawable(TDLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_autopark));
                            break;
                    }
                case 307:
                    int flag = 0;
                    if ((65536 & value) != 0) {
                        flag = 1;
                    }
                    int value2 = ((value & 65535) * 30) / Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D1_B10;
                    if (flag == 1) {
                        value2 = -value2;
                    }
                    ((InfoJaguarLeftView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.infoView_speed)).setSpeed(value2);
                    ((InfoJaguarLeftView) TDLandRoverNewCarinfoAct.this.findViewById(R.id.infoView_enginespeed)).setSpeed(value2);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_td_landrover_44info);
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
        DataCanbus.PROXY.cmd(0, new int[]{56}, null, null);
        DataCanbus.NOTIFY_EVENTS[307].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[307].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
    }

    private void updateTireDistance_delay() {
        HandlerUI.getInstance().postDelayed(new Runnable() { 
            @Override
            public void run() {
                TDLandRoverNewCarinfoAct.this.updateTire1Distance();
                TDLandRoverNewCarinfoAct.this.updateTire2Distance();
                TDLandRoverNewCarinfoAct.this.updateGanFDistance();
                TDLandRoverNewCarinfoAct.this.updateTire3Distance();
                TDLandRoverNewCarinfoAct.this.updateTire4Distance();
                TDLandRoverNewCarinfoAct.this.updateGanRDistance();
            }
        }, 50L);
    }

    
    public void updateTire1Distance() {
        int value = DataCanbus.DATA[156];
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire1 = findViewById(R.id.id_image10);
        if (mIvIconTire1 != null) {
            if (value <= 20) {
                mIvIconTire1.layout(1133, (((value - 7) * 20) / 13) + 133, 1227, (((value - 7) * 20) / 13) + 133 + 180);
            } else {
                mIvIconTire1.layout(1133, (((value - 20) * 24) / 10) + 153, 1227, (((value - 20) * 24) / 10) + 153 + 180);
            }
            mIvIconTire1.setImageDrawable(getResources().getDrawable(R.drawable.ic_jaguar_lf_tire));
        }
    }

    
    public void updateTire2Distance() {
        int value = DataCanbus.DATA[157];
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire1 = findViewById(R.id.id_image12);
        if (mIvIconTire1 != null) {
            if (value <= 20) {
                mIvIconTire1.layout(1469, (((value - 7) * 20) / 13) + 133, 1563, (((value - 7) * 20) / 13) + 133 + 180);
            } else {
                mIvIconTire1.layout(1469, (((value - 20) * 24) / 10) + 153, 1563, (((value - 20) * 24) / 10) + 153 + 180);
            }
            mIvIconTire1.setImageDrawable(getResources().getDrawable(R.drawable.ic_jaguar_rf_tire));
        }
    }

    
    public void updateTire3Distance() {
        int value = DataCanbus.DATA[158];
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire1 = findViewById(R.id.id_image13);
        if (mIvIconTire1 != null) {
            if (value <= 20) {
                mIvIconTire1.layout(1038, (((value - 7) * 22) / 13) + 184, 1160, (((value - 7) * 22) / 13) + 184 + 213);
            } else {
                mIvIconTire1.layout(1038, (((value - 20) * 24) / 10) + 204, 1160, (((value - 20) * 24) / 10) + 204 + 213);
            }
            mIvIconTire1.setImageDrawable(getResources().getDrawable(R.drawable.ic_jaguar_lr_tire));
        }
    }

    
    public void updateTire4Distance() {
        int value = DataCanbus.DATA[159];
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire1 = findViewById(R.id.id_image15);
        if (mIvIconTire1 != null) {
            if (value <= 20) {
                mIvIconTire1.layout(1539, (((value - 7) * 22) / 13) + 184, 1661, (((value - 7) * 22) / 13) + 184 + 213);
            } else {
                mIvIconTire1.layout(1539, (((value - 20) * 24) / 10) + 204, 1661, (((value - 20) * 24) / 10) + 204 + 213);
            }
            mIvIconTire1.setImageDrawable(getResources().getDrawable(R.drawable.ic_jaguar_rr_tire));
        }
    }

    
    public void updateGanFDistance() {
        int value1 = DataCanbus.DATA[156];
        int value2 = DataCanbus.DATA[157];
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
                mIvIconTire1.layout(1242, (((value - 7) * 20) / 13) + 215, 1459, (((value - 7) * 20) / 13) + 215 + 14);
            } else {
                mIvIconTire1.layout(1242, (((value - 20) * 24) / 10) + 235, 1459, (((value - 20) * 24) / 10) + 235 + 14);
            }
            mIvIconTire1.setImageDrawable(getResources().getDrawable(R.drawable.ic_jaguar_f_gan));
        }
    }

    
    public void updateGanRDistance() {
        int value1 = DataCanbus.DATA[158];
        int value2 = DataCanbus.DATA[159];
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
                mIvIconTire1.layout(1170, (((value - 7) * 22) / 13) + 283, 1514, (((value - 7) * 22) / 13) + 283 + 24);
            } else {
                mIvIconTire1.layout(1170, (((value - 20) * 24) / 10) + 303, 1514, (((value - 20) * 24) / 10) + 303 + 24);
            }
            mIvIconTire1.setImageDrawable(getResources().getDrawable(R.drawable.ic_jaguar_r_gan));
        }
    }
}
