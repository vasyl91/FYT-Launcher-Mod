package com.syu.carinfo.rzc.xima;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.rzc.sanlin.LZGmAllCarSet;
import com.syu.carinfo.rzc.sanlin.LZGmAllOnstar;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class OD_NissanXimaIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_od_nissan_indexact);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_453_LZ_GM_Camaro_17 /* 2163141 */:
            case FinalCanbus.CAR_453_LZ_GM_GMC_TERRAIN_17 /* 2228677 */:
            case FinalCanbus.CAR_453_LZ_GM_Equinox_17 /* 2294213 */:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_anjixing_str);
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_jianianhua_settings_title);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.app_name);
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_guandao_amp);
                break;
        }
        findViewById(R.id.jeep_car_info).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xima.OD_NissanXimaIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_453_LZ_GM_Camaro_17 /* 2163141 */:
                        case FinalCanbus.CAR_453_LZ_GM_GMC_TERRAIN_17 /* 2228677 */:
                        case FinalCanbus.CAR_453_LZ_GM_Equinox_17 /* 2294213 */:
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
        findViewById(R.id.jeep_car_settings).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xima.OD_NissanXimaIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_453_LZ_GM_Camaro_17 /* 2163141 */:
                        case FinalCanbus.CAR_453_LZ_GM_GMC_TERRAIN_17 /* 2228677 */:
                        case FinalCanbus.CAR_453_LZ_GM_Equinox_17 /* 2294213 */:
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
