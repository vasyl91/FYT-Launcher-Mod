package com.syu.carinfo.rzc.xima;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.rzc.sanlin.LZGmAllCarSet;
import com.syu.carinfo.rzc.sanlin.LZGmAllOnstar;
import com.syu.carinfo.rzc.sanlin.ODNissanTeanaCarSet;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class OD_NissanXimaIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_od_nissan_indexact);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_CZH_OD_NISSAN_22Teana_Top /* 1572944 */:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.app_name);
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_jianianhua_settings_title);
                break;
            case FinalCanbus.CAR_453_LZ_GM_Camaro_17 /* 2163141 */:
            case FinalCanbus.CAR_453_LZ_GM_GMC_TERRAIN_17 /* 2228677 */:
            case FinalCanbus.CAR_453_LZ_GM_Equinox_17 /* 2294213 */:
            case FinalCanbus.CAR_454_LZ_GM_Camaro_17_Auto /* 6947270 */:
            case FinalCanbus.CAR_454_LZ_GM_Equinox_17_Auto /* 7012806 */:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_anjixing_str);
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_jianianhua_settings_title);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.app_name);
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_guandao_amp);
                break;
        }
        findViewById(R.id.jeep_car_info).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_453_LZ_GM_Camaro_17 /* 2163141 */:
                        case FinalCanbus.CAR_453_LZ_GM_GMC_TERRAIN_17 /* 2228677 */:
                        case FinalCanbus.CAR_453_LZ_GM_Equinox_17 /* 2294213 */:
                        case FinalCanbus.CAR_454_LZ_GM_Camaro_17_Auto /* 6947270 */:
                        case FinalCanbus.CAR_454_LZ_GM_Equinox_17_Auto /* 7012806 */:
                            intent.setClass(OD_NissanXimaIndexAct.this, LZGmAllOnstar.class);
                            break;
                        default:
                            intent.setClass(OD_NissanXimaIndexAct.this, OD_NissanXimaCarinfoAct.class);
                            break;
                    }
                    OD_NissanXimaIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.jeep_car_settings).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_CZH_OD_NISSAN_22Teana_Top /* 1572944 */:
                            intent.setClass(OD_NissanXimaIndexAct.this, ODNissanTeanaCarSet.class);
                            break;
                        case FinalCanbus.CAR_453_LZ_GM_Camaro_17 /* 2163141 */:
                        case FinalCanbus.CAR_453_LZ_GM_GMC_TERRAIN_17 /* 2228677 */:
                        case FinalCanbus.CAR_453_LZ_GM_Equinox_17 /* 2294213 */:
                        case FinalCanbus.CAR_454_LZ_GM_Camaro_17_Auto /* 6947270 */:
                        case FinalCanbus.CAR_454_LZ_GM_Equinox_17_Auto /* 7012806 */:
                            intent.setClass(OD_NissanXimaIndexAct.this, LZGmAllCarSet.class);
                            break;
                        default:
                            intent.setClass(OD_NissanXimaIndexAct.this, Rzc_80_DspinfoActi.class);
                            break;
                    }
                    OD_NissanXimaIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
