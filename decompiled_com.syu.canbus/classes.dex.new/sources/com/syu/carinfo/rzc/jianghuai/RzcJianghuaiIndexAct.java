package com.syu.carinfo.rzc.jianghuai;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RzcJianghuaiIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_jianghuai_indexact);
        if (DataCanbus.DATA[1000] != 2621879 && DataCanbus.DATA[1000] != 11338167 && DataCanbus.DATA[1000] != 11403703 && DataCanbus.DATA[1000] != 10879428 && DataCanbus.DATA[1000] != 10944964 && DataCanbus.DATA[1000] != 6029765 && DataCanbus.DATA[1000] != 6095301 && DataCanbus.DATA[1000] != 8389063) {
            findViewById(R.id.rzc_jianghuai_carinfo_view).setVisibility(8);
        } else {
            findViewById(R.id.rzc_jianghuai_carinfo_view).setVisibility(0);
        }
        if (DataCanbus.DATA[1000] == 6029765 || DataCanbus.DATA[1000] == 6095301 || DataCanbus.DATA[1000] == 8389063) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_guandao_amp);
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.app_name);
        }
        ((Button) findViewById(R.id.rzc_jianghuai_car_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RzcJianghuaiIndexAct.this, RzcJianghuaiSetFunc.class);
                    RzcJianghuaiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.rzc_jianghuai_carinfo)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 6029765 || DataCanbus.DATA[1000] == 6095301 || DataCanbus.DATA[1000] == 8389063) {
                        intent.setClass(RzcJianghuaiIndexAct.this, RzcJianghuaiAmpSetFunc.class);
                    } else {
                        intent.setClass(RzcJianghuaiIndexAct.this, RzcJianghuaiCarinfoAct.class);
                    }
                    RzcJianghuaiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.rzc_jianghuai_car_tire)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RzcJianghuaiIndexAct.this, RzcJianghuaiTireAct.class);
                    RzcJianghuaiIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
