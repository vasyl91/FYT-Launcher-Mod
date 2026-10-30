package com.syu.carinfo.qiya.kx7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ActivityWCTeyesXianDaiE_InfoAct extends BaseActivity implements View.OnClickListener {
    int numcnt = 0;
    Runnable mShowState = new Runnable() { // from class: com.syu.carinfo.qiya.kx7.ActivityWCTeyesXianDaiE_InfoAct.1
        @Override // java.lang.Runnable
        public void run() {
            ActivityWCTeyesXianDaiE_InfoAct.this.numcnt++;
            if (ActivityWCTeyesXianDaiE_InfoAct.this.numcnt > 7) {
                ActivityWCTeyesXianDaiE_InfoAct.this.numcnt = 0;
            }
            if (DataCanbus.DATA[130] == 1) {
                switch (ActivityWCTeyesXianDaiE_InfoAct.this.numcnt) {
                    case 0:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico1_1);
                        break;
                    case 1:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico1_12);
                        break;
                    case 2:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico1_13);
                        break;
                    case 3:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico1_14);
                        break;
                    case 4:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico1_15);
                        break;
                    case 5:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico1_16);
                        break;
                    case 6:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico1_17);
                        break;
                    case 7:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico1_18);
                        break;
                }
            } else if (DataCanbus.DATA[130] == 2) {
                switch (ActivityWCTeyesXianDaiE_InfoAct.this.numcnt) {
                    case 0:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico1_2);
                        break;
                    case 1:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico1_21);
                        break;
                    case 2:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico1_22);
                        break;
                    case 3:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico1_23);
                        break;
                    case 4:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico1_24);
                        break;
                    case 5:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico1_25);
                        break;
                    case 6:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico1_26);
                        break;
                    case 7:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico1_27);
                        break;
                }
            } else {
                ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_dashboard_car_null);
            }
            if (DataCanbus.DATA[129] == 1) {
                switch (ActivityWCTeyesXianDaiE_InfoAct.this.numcnt) {
                    case 0:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico2_1);
                        break;
                    case 1:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico2_12);
                        break;
                    case 2:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico2_13);
                        break;
                    case 3:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico2_14);
                        break;
                    case 4:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico2_15);
                        break;
                    case 5:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico2_16);
                        break;
                    case 6:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico2_17);
                        break;
                    case 7:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico2_18);
                        break;
                }
            } else if (DataCanbus.DATA[129] == 2) {
                switch (ActivityWCTeyesXianDaiE_InfoAct.this.numcnt) {
                    case 0:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico2_2);
                        break;
                    case 1:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico2_22);
                        break;
                    case 2:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico2_23);
                        break;
                    case 3:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico2_24);
                        break;
                    case 4:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico2_25);
                        break;
                    case 5:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico2_26);
                        break;
                    case 6:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico2_27);
                        break;
                    case 7:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico2_28);
                        break;
                }
            } else if (DataCanbus.DATA[129] == 3) {
                switch (ActivityWCTeyesXianDaiE_InfoAct.this.numcnt) {
                    case 0:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico2_3);
                        break;
                    case 1:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico2_32);
                        break;
                    case 2:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico2_33);
                        break;
                    case 3:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico2_34);
                        break;
                    case 4:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico2_35);
                        break;
                    case 5:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico2_36);
                        break;
                    case 6:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico2_37);
                        break;
                    case 7:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico2_38);
                        break;
                }
            } else {
                ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_dashboard_car_null);
            }
            if (DataCanbus.DATA[128] == 1) {
                switch (ActivityWCTeyesXianDaiE_InfoAct.this.numcnt) {
                    case 0:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico4_1);
                        break;
                    case 1:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico4_12);
                        break;
                    case 2:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico4_13);
                        break;
                    case 3:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico4_14);
                        break;
                    case 4:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico4_15);
                        break;
                    case 5:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico4_16);
                        break;
                    case 6:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico4_17);
                        break;
                    case 7:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico4_18);
                        break;
                }
            } else if (DataCanbus.DATA[128] == 2) {
                switch (ActivityWCTeyesXianDaiE_InfoAct.this.numcnt) {
                    case 0:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico4_2);
                        break;
                    case 1:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico4_22);
                        break;
                    case 2:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico4_23);
                        break;
                    case 3:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico4_24);
                        break;
                    case 4:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico4_25);
                        break;
                    case 5:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico4_26);
                        break;
                    case 6:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico4_27);
                        break;
                    case 7:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico4_28);
                        break;
                }
            } else {
                ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_dashboard_car_null);
            }
            if (DataCanbus.DATA[127] == 1) {
                switch (ActivityWCTeyesXianDaiE_InfoAct.this.numcnt) {
                    case 0:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico3_1);
                        break;
                    case 1:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico3_12);
                        break;
                    case 2:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico3_13);
                        break;
                    case 3:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico3_14);
                        break;
                    case 4:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico3_15);
                        break;
                    case 5:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico3_16);
                        break;
                    case 6:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico3_17);
                        break;
                    case 7:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico3_18);
                        break;
                }
            } else if (DataCanbus.DATA[127] == 2) {
                switch (ActivityWCTeyesXianDaiE_InfoAct.this.numcnt) {
                    case 0:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico3_2);
                        break;
                    case 1:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico3_22);
                        break;
                    case 2:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico3_23);
                        break;
                    case 3:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico3_24);
                        break;
                    case 4:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico3_25);
                        break;
                    case 5:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico3_26);
                        break;
                    case 6:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico3_27);
                        break;
                    case 7:
                        ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_ico3_28);
                        break;
                }
            } else {
                ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_dashboard_car_null);
            }
            HandlerUI.getInstance().removeCallbacks(ActivityWCTeyesXianDaiE_InfoAct.this.mShowState);
            HandlerUI.getInstance().postDelayed(ActivityWCTeyesXianDaiE_InfoAct.this.mShowState, 200L);
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.qiya.kx7.ActivityWCTeyesXianDaiE_InfoAct.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 123:
                    if (value == 65535) {
                        ((TextView) ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.tv_text3)).setText("--.- ");
                    } else {
                        ((TextView) ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    }
                    break;
                case 124:
                    if (value == 65535) {
                        ((TextView) ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.tv_text1)).setText("--.-");
                    } else {
                        ((TextView) ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    }
                    break;
                case 125:
                    switch (value) {
                        case 2:
                            ((TextView) ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.tv_text2)).setText("MPG(US)");
                            break;
                        case 3:
                            ((TextView) ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.tv_text2)).setText("MPG(UK)");
                            break;
                        case 4:
                            ((TextView) ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.tv_text2)).setText(CamryData.OIL_EXPEND_UNIT_KM_PER_L);
                            break;
                        default:
                            ((TextView) ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.tv_text2)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                            break;
                    }
                    break;
                case 126:
                    ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view6).setBackgroundResource(R.drawable.ic_dashboard_car_null);
                    switch (value) {
                        case 1:
                            ((TextView) ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.tv_text5)).setText("Idle Mode");
                            break;
                        case 2:
                            ((TextView) ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.tv_text5)).setText("Electric Mode");
                            break;
                        case 3:
                            ((TextView) ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.tv_text5)).setText("Hybrid Mode");
                            break;
                        case 4:
                            ((TextView) ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.tv_text5)).setText("Engine Mode");
                            break;
                        case 5:
                            ((TextView) ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.tv_text5)).setText("Charging");
                            ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view6).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_charge);
                            break;
                        case 6:
                            ((TextView) ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.tv_text5)).setText("Engine Braking");
                            break;
                        default:
                            ((TextView) ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.tv_text5)).setText("");
                            break;
                    }
                    break;
                case 127:
                case 128:
                case 129:
                case 130:
                    ActivityWCTeyesXianDaiE_InfoAct.this.mUpdaterState();
                    break;
                case 131:
                    switch (value) {
                        case 1:
                            ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_lev1);
                            break;
                        case 2:
                            ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_lev2);
                            break;
                        case 3:
                            ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_lev3);
                            break;
                        case 4:
                            ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_lev4);
                            break;
                        case 5:
                            ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_lev5);
                            break;
                        case 6:
                            ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_lev6);
                            break;
                        case 7:
                            ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_lev7);
                            break;
                        case 8:
                            ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_lev8);
                            break;
                        default:
                            ActivityWCTeyesXianDaiE_InfoAct.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_teyes_elantra_ev_lev0);
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0444_wc_teyes_xiandai_e_info);
        findViewById(R.id.tv_text1).setOnClickListener(this);
        findViewById(R.id.tv_text3).setOnClickListener(this);
        findViewById(R.id.btn_plus1).setOnClickListener(this);
        findViewById(R.id.btn_plus2).setOnClickListener(this);
        findViewById(R.id.layout_view4).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_text1 /* 2131427457 */:
            case R.id.tv_text3 /* 2131427463 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, ActivityWCTeyesXianDaiE45min_InfoAct.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                finish();
                break;
            case R.id.layout_view4 /* 2131427564 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, ActivityWCTeyesXianDaiE_InfoAct2.class);
                    startActivity(intent2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterState() {
        if (DataCanbus.DATA[130] != 0 || DataCanbus.DATA[129] != 0 || DataCanbus.DATA[128] != 0 || DataCanbus.DATA[127] != 0) {
            HandlerUI.getInstance().removeCallbacks(this.mShowState);
            HandlerUI.getInstance().postDelayed(this.mShowState, 50L);
            return;
        }
        HandlerUI.getInstance().removeCallbacks(this.mShowState);
        findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_dashboard_car_null);
        findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_dashboard_car_null);
        findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_dashboard_car_null);
        findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_dashboard_car_null);
    }
}
