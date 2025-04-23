package com.syu.carinfo.rzc.andra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.opel.OPELCarKeyActivity;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class GmAndraIndexActi extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0061_rzc_gm_andra_index);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_453_LZ_Nissan_Teana_03 /* 2687429 */:
            case FinalCanbus.CAR_453_LZ_Nissan_Teana_03_H /* 2752965 */:
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(8);
                findViewById(R.id.layout_view4).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_ALL_GM_08_10AstraH /* 3866685 */:
            case FinalCanbus.CAR_RZC_ALL_GM_11CorsaD /* 3932221 */:
            case FinalCanbus.CAR_RZC_ALL_GM_08Combo /* 3997757 */:
            case FinalCanbus.CAR_RZC_ALL_GM_Antara /* 4718653 */:
            case FinalCanbus.CAR_RZC_ALL_GM_04_Tigra /* 5701693 */:
            case FinalCanbus.CAR_RZC_ALL_GM_06_Astra /* 5832765 */:
            case FinalCanbus.CAR_RZC_ALL_GM_08_Zafira /* 5898301 */:
            case FinalCanbus.CAR_RZC_ALL_GM_05_Vectra /* 5963837 */:
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(8);
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.wc_psa_all_orinal_car_fuc);
                break;
            case FinalCanbus.CAR_454_LZ_Nissan_05_Cima /* 9044422 */:
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.wc_jianianhua_main_settings_title);
                break;
            default:
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(8);
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.wc_psa_all_orinal_car_fuc);
                break;
        }
        ((Button) findViewById(R.id.wc_geshitu_btn_trip)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_453_LZ_Nissan_Teana_03 /* 2687429 */:
                        case FinalCanbus.CAR_453_LZ_Nissan_Teana_03_H /* 2752965 */:
                            intent.setClass(GmAndraIndexActi.this, LzNissan03TeanaCd.class);
                            break;
                        default:
                            intent.setClass(GmAndraIndexActi.this, GmAndraActivityCarCD.class);
                            break;
                    }
                    GmAndraIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.wc_geshitu_btn_setting)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_453_LZ_Nissan_Teana_03 /* 2687429 */:
                        case FinalCanbus.CAR_453_LZ_Nissan_Teana_03_H /* 2752965 */:
                            intent.setClass(GmAndraIndexActi.this, LzNissan03TeanaCarSet.class);
                            break;
                        case FinalCanbus.CAR_454_LZ_Nissan_05_Cima /* 9044422 */:
                            intent.setClass(GmAndraIndexActi.this, LzNissan05CimaCarInfo.class);
                            break;
                        default:
                            intent.setClass(GmAndraIndexActi.this, GmAndraCarinfoIndexAct.class);
                            break;
                    }
                    GmAndraIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_454_LZ_Nissan_05_Cima /* 9044422 */:
                            intent.setClass(GmAndraIndexActi.this, LzNissan05CimaCarSet.class);
                            break;
                        default:
                            intent.setClass(GmAndraIndexActi.this, OPELCarKeyActivity.class);
                            break;
                    }
                    GmAndraIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_454_LZ_Nissan_05_Cima /* 9044422 */:
                            intent.setClass(GmAndraIndexActi.this, LzNissan05CimaTireAct.class);
                            break;
                        default:
                            intent.setClass(GmAndraIndexActi.this, LzNissan03TeanaTireAct.class);
                            break;
                    }
                    GmAndraIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
