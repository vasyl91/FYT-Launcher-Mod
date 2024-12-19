package com.syu.carinfo.od.bmw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ODBMWMiniIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_huiteng_indexact);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_453_LZ_BMW_E39 /* 262597 */:
            case FinalCanbus.CAR_453_LZ_BMW_E53 /* 328133 */:
            case FinalCanbus.CAR_453_LZ_BMW_E39_H /* 393669 */:
            case FinalCanbus.CAR_453_LZ_BMW_E53_H /* 459205 */:
            case FinalCanbus.CAR_452_OD_BMW_120 /* 4194756 */:
            case FinalCanbus.CAR_452_OD_BMW_130 /* 4260292 */:
            case FinalCanbus.CAR_452_OD_BMW_318 /* 4325828 */:
            case FinalCanbus.CAR_452_OD_BMW_320 /* 4391364 */:
            case FinalCanbus.CAR_452_OD_BMW_325 /* 4456900 */:
            case FinalCanbus.CAR_452_OD_BMW_X1 /* 4522436 */:
            case FinalCanbus.CAR_452_OD_BMW_E90 /* 4587972 */:
            case FinalCanbus.CAR_452_OD_BMW_E60 /* 4653508 */:
            case FinalCanbus.CAR_452_LZ_BMW_E46_H /* 13828548 */:
            case FinalCanbus.CAR_439_LZ_BMW_E46 /* 16187831 */:
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                break;
        }
        findViewById(R.id.jeep_car_info).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.od.bmw.ODBMWMiniIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_453_LZ_BMW_E39 /* 262597 */:
                        case FinalCanbus.CAR_453_LZ_BMW_E53 /* 328133 */:
                        case FinalCanbus.CAR_453_LZ_BMW_E39_H /* 393669 */:
                        case FinalCanbus.CAR_453_LZ_BMW_E53_H /* 459205 */:
                        case FinalCanbus.CAR_452_LZ_BMW_E46_H /* 13828548 */:
                        case FinalCanbus.CAR_439_LZ_BMW_E46 /* 16187831 */:
                            intent.setClass(ODBMWMiniIndexAct.this, LZBMWE46CarInfo.class);
                            break;
                        case FinalCanbus.CAR_452_OD_BMW_120 /* 4194756 */:
                        case FinalCanbus.CAR_452_OD_BMW_130 /* 4260292 */:
                        case FinalCanbus.CAR_452_OD_BMW_318 /* 4325828 */:
                        case FinalCanbus.CAR_452_OD_BMW_320 /* 4391364 */:
                        case FinalCanbus.CAR_452_OD_BMW_325 /* 4456900 */:
                        case FinalCanbus.CAR_452_OD_BMW_X1 /* 4522436 */:
                        case FinalCanbus.CAR_452_OD_BMW_E90 /* 4587972 */:
                        case FinalCanbus.CAR_452_OD_BMW_E60 /* 4653508 */:
                            intent.setClass(ODBMWMiniIndexAct.this, ODBMWX1CarInfo.class);
                            break;
                        default:
                            intent.setClass(ODBMWMiniIndexAct.this, ODBMWMiniCarInfo.class);
                            break;
                    }
                    ODBMWMiniIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.jeep_car_settings).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.od.bmw.ODBMWMiniIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_453_LZ_BMW_E39 /* 262597 */:
                        case FinalCanbus.CAR_453_LZ_BMW_E53 /* 328133 */:
                        case FinalCanbus.CAR_453_LZ_BMW_E39_H /* 393669 */:
                        case FinalCanbus.CAR_453_LZ_BMW_E53_H /* 459205 */:
                        case FinalCanbus.CAR_452_LZ_BMW_E46_H /* 13828548 */:
                        case FinalCanbus.CAR_439_LZ_BMW_E46 /* 16187831 */:
                            intent.setClass(ODBMWMiniIndexAct.this, LZBMWE46CarSet.class);
                            break;
                        case FinalCanbus.CAR_452_OD_BMW_120 /* 4194756 */:
                        case FinalCanbus.CAR_452_OD_BMW_130 /* 4260292 */:
                        case FinalCanbus.CAR_452_OD_BMW_318 /* 4325828 */:
                        case FinalCanbus.CAR_452_OD_BMW_320 /* 4391364 */:
                        case FinalCanbus.CAR_452_OD_BMW_325 /* 4456900 */:
                        case FinalCanbus.CAR_452_OD_BMW_X1 /* 4522436 */:
                        case FinalCanbus.CAR_452_OD_BMW_E90 /* 4587972 */:
                        case FinalCanbus.CAR_452_OD_BMW_E60 /* 4653508 */:
                            intent.setClass(ODBMWMiniIndexAct.this, ODBMWX1CarSet.class);
                            break;
                        default:
                            intent.setClass(ODBMWMiniIndexAct.this, ODBMWMiniCarSet.class);
                            break;
                    }
                    ODBMWMiniIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.jeep_car_cd).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.od.bmw.ODBMWMiniIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_453_LZ_BMW_E39 /* 262597 */:
                        case FinalCanbus.CAR_453_LZ_BMW_E53 /* 328133 */:
                        case FinalCanbus.CAR_452_LZ_BMW_E46_H /* 13828548 */:
                        case FinalCanbus.CAR_439_LZ_BMW_E46 /* 16187831 */:
                            intent.setClass(ODBMWMiniIndexAct.this, LZBMWE46CarCd.class);
                            break;
                        case FinalCanbus.CAR_452_OD_BMW_120 /* 4194756 */:
                        case FinalCanbus.CAR_452_OD_BMW_130 /* 4260292 */:
                        case FinalCanbus.CAR_452_OD_BMW_318 /* 4325828 */:
                        case FinalCanbus.CAR_452_OD_BMW_320 /* 4391364 */:
                        case FinalCanbus.CAR_452_OD_BMW_325 /* 4456900 */:
                        case FinalCanbus.CAR_452_OD_BMW_X1 /* 4522436 */:
                        case FinalCanbus.CAR_452_OD_BMW_E90 /* 4587972 */:
                        case FinalCanbus.CAR_452_OD_BMW_E60 /* 4653508 */:
                            intent.setClass(ODBMWMiniIndexAct.this, ODBMWX1CarCd.class);
                            break;
                    }
                    ODBMWMiniIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
