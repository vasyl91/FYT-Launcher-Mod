package com.syu.carinfo.bnr.guanzhi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.oudi.hantengx5.Oudi_0453_JMC_EV3_CarSettingAct;
import com.syu.carinfo.oudi.hantengx5.Oudi_0453_JMC_YZHI_EV3_TireAct;
import com.syu.module.canbus.DataCanbus;

public class BnrGuanzhiIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_bnrguanzhi_indexact);
        if (DataCanbus.DATA[1000] != 8454596 && DataCanbus.DATA[1000] != 9241028 && DataCanbus.DATA[1000] != 8389061 && DataCanbus.DATA[1000] != 1769925 && DataCanbus.DATA[1000] != 1835461 && DataCanbus.DATA[1000] != 14483910 && DataCanbus.DATA[1000] != 7930309 && DataCanbus.DATA[1000] != 12648901) {
            findViewById(R.id.layout_view1).setVisibility(8);
        } else {
            findViewById(R.id.layout_view1).setVisibility(0);
        }
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 7930309) {
                        intent.setClass(BnrGuanzhiIndexAct.this, LZRomeoCarInfo.class);
                    } else if (DataCanbus.DATA[1000] == 12648901) {
                        intent.setClass(BnrGuanzhiIndexAct.this, ODJMCEV3CarInfo.class);
                    } else {
                        intent.setClass(BnrGuanzhiIndexAct.this, ODFordProCarInfo.class);
                    }
                    BnrGuanzhiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.odchangan_car_settings).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 8454596 || DataCanbus.DATA[1000] == 9241028 || DataCanbus.DATA[1000] == 8389061 || DataCanbus.DATA[1000] == 1769925 || DataCanbus.DATA[1000] == 1835461 || DataCanbus.DATA[1000] == 14483910) {
                        intent.setClass(BnrGuanzhiIndexAct.this, ODFordProCarSet.class);
                    } else if (DataCanbus.DATA[1000] == 11272644) {
                        intent.setClass(BnrGuanzhiIndexAct.this, DJ_Guanzhi_CarSetAct.class);
                    } else if (DataCanbus.DATA[1000] == 7930309) {
                        intent.setClass(BnrGuanzhiIndexAct.this, LZRomeoCarSet.class);
                    } else if (DataCanbus.DATA[1000] == 12648901) {
                        intent.setClass(BnrGuanzhiIndexAct.this, Oudi_0453_JMC_EV3_CarSettingAct.class);
                    } else {
                        intent.setClass(BnrGuanzhiIndexAct.this, BnrGuanzhiSetFunc.class);
                    }
                    BnrGuanzhiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.odchangan_car_tire).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 8454596 || DataCanbus.DATA[1000] == 9241028 || DataCanbus.DATA[1000] == 8389061 || DataCanbus.DATA[1000] == 1769925 || DataCanbus.DATA[1000] == 1835461 || DataCanbus.DATA[1000] == 14483910) {
                        intent.setClass(BnrGuanzhiIndexAct.this, ODFordProTireAct.class);
                    } else if (DataCanbus.DATA[1000] == 11272644) {
                        intent.setClass(BnrGuanzhiIndexAct.this, DJ_Guanzhi_TireAct.class);
                    } else if (DataCanbus.DATA[1000] == 7930309) {
                        intent.setClass(BnrGuanzhiIndexAct.this, LZRomeoTireAct.class);
                    } else if (DataCanbus.DATA[1000] == 12648901) {
                        intent.setClass(BnrGuanzhiIndexAct.this, Oudi_0453_JMC_YZHI_EV3_TireAct.class);
                    } else {
                        intent.setClass(BnrGuanzhiIndexAct.this, BnrGuanzhiTireAct.class);
                    }
                    BnrGuanzhiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
