package com.syu.carinfo.xp.ziyouguang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class PAFordAllIndexActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_pa_all_ford_index);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_PA_Ford_Explorer_19 /* 2883958 */:
            case FinalCanbus.CAR_PA_Ford_Fusion_22 /* 2949494 */:
            case FinalCanbus.CAR_PA_Ford_F150_14 /* 3015030 */:
            case FinalCanbus.CAR_PA_Ford_F150_20 /* 3080566 */:
            case FinalCanbus.CAR_PA_Ford_Focus_18 /* 3146102 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_21 /* 3211638 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_17 /* 3277174 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_21 /* 3342710 */:
            case FinalCanbus.CAR_PA_Ford_mustang_15 /* 3932534 */:
            case FinalCanbus.CAR_PA_Ford_Explorer_19_Amp /* 4260214 */:
            case FinalCanbus.CAR_PA_Ford_Fusion_22_Amp /* 4325750 */:
            case FinalCanbus.CAR_PA_Ford_F150_14_Amp /* 4391286 */:
            case FinalCanbus.CAR_PA_Ford_F150_20_Amp /* 4456822 */:
            case FinalCanbus.CAR_PA_Ford_Focus_18_Amp /* 4522358 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_21_Amp /* 4587894 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_17_Amp /* 4653430 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_Amp /* 4718966 */:
            case FinalCanbus.CAR_PA_Ford_mustang_15_Amp /* 4784502 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16 /* 4850038 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_Amp /* 4981110 */:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                break;
            case FinalCanbus.CAR_PA_Ford_Explorer_19_CD /* 3408246 */:
            case FinalCanbus.CAR_PA_Ford_Fusion_22_CD /* 3473782 */:
            case FinalCanbus.CAR_PA_Ford_F150_14_CD /* 3539318 */:
            case FinalCanbus.CAR_PA_Ford_F150_20_CD /* 3604854 */:
            case FinalCanbus.CAR_PA_Ford_Focus_18_CD /* 3670390 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_21_CD /* 3735926 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_17_CD /* 3801462 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_CD /* 3866998 */:
            case FinalCanbus.CAR_PA_Ford_mustang_15_CD /* 3998070 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_CD /* 4915574 */:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(8);
                findViewById(R.id.layout_view4).setVisibility(8);
                findViewById(R.id.layout_view5).setVisibility(8);
                findViewById(R.id.layout_text_view1).setVisibility(8);
                break;
        }
        findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_PA_Ford_Explorer_19 /* 2883958 */:
                        case FinalCanbus.CAR_PA_Ford_Fusion_22 /* 2949494 */:
                        case FinalCanbus.CAR_PA_Ford_F150_14 /* 3015030 */:
                        case FinalCanbus.CAR_PA_Ford_F150_20 /* 3080566 */:
                        case FinalCanbus.CAR_PA_Ford_Focus_18 /* 3146102 */:
                        case FinalCanbus.CAR_PA_Ford_Expedition_21 /* 3211638 */:
                        case FinalCanbus.CAR_PA_Ford_Expedition_17 /* 3277174 */:
                        case FinalCanbus.CAR_PA_Ford_F_Super_duty_21 /* 3342710 */:
                        case FinalCanbus.CAR_PA_Ford_Explorer_19_CD /* 3408246 */:
                        case FinalCanbus.CAR_PA_Ford_Fusion_22_CD /* 3473782 */:
                        case FinalCanbus.CAR_PA_Ford_F150_14_CD /* 3539318 */:
                        case FinalCanbus.CAR_PA_Ford_F150_20_CD /* 3604854 */:
                        case FinalCanbus.CAR_PA_Ford_Focus_18_CD /* 3670390 */:
                        case FinalCanbus.CAR_PA_Ford_Expedition_21_CD /* 3735926 */:
                        case FinalCanbus.CAR_PA_Ford_Expedition_17_CD /* 3801462 */:
                        case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_CD /* 3866998 */:
                        case FinalCanbus.CAR_PA_Ford_mustang_15 /* 3932534 */:
                        case FinalCanbus.CAR_PA_Ford_mustang_15_CD /* 3998070 */:
                        case FinalCanbus.CAR_PA_Ford_Explorer_19_Amp /* 4260214 */:
                        case FinalCanbus.CAR_PA_Ford_Fusion_22_Amp /* 4325750 */:
                        case FinalCanbus.CAR_PA_Ford_F150_14_Amp /* 4391286 */:
                        case FinalCanbus.CAR_PA_Ford_F150_20_Amp /* 4456822 */:
                        case FinalCanbus.CAR_PA_Ford_Focus_18_Amp /* 4522358 */:
                        case FinalCanbus.CAR_PA_Ford_Expedition_21_Amp /* 4587894 */:
                        case FinalCanbus.CAR_PA_Ford_Expedition_17_Amp /* 4653430 */:
                        case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_Amp /* 4718966 */:
                        case FinalCanbus.CAR_PA_Ford_mustang_15_Amp /* 4784502 */:
                        case FinalCanbus.CAR_PA_Ford_F_Super_duty_16 /* 4850038 */:
                        case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_CD /* 4915574 */:
                        case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_Amp /* 4981110 */:
                            intent.setClass(PAFordAllIndexActi.this, Xp_374_FunctionlActi.class);
                            break;
                        default:
                            intent.setClass(PAFordAllIndexActi.this, PAFord_FunctionlActi.class);
                            break;
                    }
                    PAFordAllIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(PAFordAllIndexActi.this, PAFordCarSyncActi.class);
                    PAFordAllIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btn_plus3).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(PAFordAllIndexActi.this, PAFordXMRadioAct.class);
                    PAFordAllIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btn_plus4).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(PAFordAllIndexActi.this, PAFordSeatSetAct.class);
                    PAFordAllIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btn_plus5).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(PAFordAllIndexActi.this, PAFordAmbLightSetAct.class);
                    PAFordAllIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btn_plus6).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(PAFordAllIndexActi.this, PAFordDoornumSetAct.class);
                    PAFordAllIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }
}
