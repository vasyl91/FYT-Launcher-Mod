package com.syu.carinfo.rzc.xima;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class LZ_NIssanInfinitiIndexAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 125:
                    LZ_NIssanInfinitiIndexAct.this.findViewById(R.id.layout_view1).setVisibility(value == 1 ? 0 : 8);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_lz_nissaninfiniti_indexact);
        findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_454_LZ_Nissan_370Z_L /* 14680518 */:
                        case FinalCanbus.CAR_454_LZ_Nissan_370Z_H /* 14746054 */:
                        case FinalCanbus.CAR_454_LZ_Nissan_370Z_TW /* 14811590 */:
                        case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_L /* 15729094 */:
                        case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H /* 15794630 */:
                        case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_TW /* 15860166 */:
                        case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H_NP /* 15925702 */:
                            intent.setClass(LZ_NIssanInfinitiIndexAct.this, LZ_Nissan370zCarInfoAct.class);
                            break;
                        default:
                            intent.setClass(LZ_NIssanInfinitiIndexAct.this, LZ_NissanInfinitiCarInfoAct.class);
                            break;
                    }
                    LZ_NIssanInfinitiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_454_LZ_Nissan_370Z_L /* 14680518 */:
                        case FinalCanbus.CAR_454_LZ_Nissan_370Z_H /* 14746054 */:
                        case FinalCanbus.CAR_454_LZ_Nissan_370Z_TW /* 14811590 */:
                        case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_L /* 15729094 */:
                        case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H /* 15794630 */:
                        case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_TW /* 15860166 */:
                        case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H_NP /* 15925702 */:
                            intent.setClass(LZ_NIssanInfinitiIndexAct.this, LZ_Nissan370zCarSet.class);
                            break;
                        default:
                            intent.setClass(LZ_NIssanInfinitiIndexAct.this, LZ_NissanInfinitiCarSet.class);
                            break;
                    }
                    LZ_NIssanInfinitiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btn_plus3).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_454_LZ_Nissan_370Z_L /* 14680518 */:
                        case FinalCanbus.CAR_454_LZ_Nissan_370Z_H /* 14746054 */:
                        case FinalCanbus.CAR_454_LZ_Nissan_370Z_TW /* 14811590 */:
                        case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_L /* 15729094 */:
                        case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H /* 15794630 */:
                        case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_TW /* 15860166 */:
                        case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H_NP /* 15925702 */:
                            intent.setClass(LZ_NIssanInfinitiIndexAct.this, LZ_Nissan370zTireAct.class);
                            break;
                        default:
                            intent.setClass(LZ_NIssanInfinitiIndexAct.this, LZ_NissanInfinitiTireAct.class);
                            break;
                    }
                    LZ_NIssanInfinitiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btn_plus4).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(LZ_NIssanInfinitiIndexAct.this, LZ_NissanInfinitiElectricActi.class);
                    LZ_NIssanInfinitiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btn_plus5).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(LZ_NIssanInfinitiIndexAct.this, LZ_NissanInfinitiCdAct.class);
                    LZ_NIssanInfinitiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_LZ_Nissan_370Z_L /* 14680518 */:
            case FinalCanbus.CAR_454_LZ_Nissan_370Z_H /* 14746054 */:
            case FinalCanbus.CAR_454_LZ_Nissan_370Z_TW /* 14811590 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_L /* 15729094 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H /* 15794630 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_TW /* 15860166 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H_NP /* 15925702 */:
                findViewById(R.id.layout_view1).setVisibility(8);
                break;
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_L /* 15729094 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H /* 15794630 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_TW /* 15860166 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H_NP /* 15925702 */:
                findViewById(R.id.layout_view5).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view5).setVisibility(8);
                break;
        }
    }

    @Override
    public void addNotify() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_LZ_Nissan_370Z_L /* 14680518 */:
            case FinalCanbus.CAR_454_LZ_Nissan_370Z_H /* 14746054 */:
            case FinalCanbus.CAR_454_LZ_Nissan_370Z_TW /* 14811590 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_L /* 15729094 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H /* 15794630 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_TW /* 15860166 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H_NP /* 15925702 */:
                break;
            default:
                DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
                break;
        }
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
    }
}
