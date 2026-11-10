package com.syu.carinfo.rzc.lufengxiaoyao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.air.Air_Activity_All_Toyota_prado_HP;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZCLufengXiaoyaoIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_odchangan_indexact);
        ((Button) findViewById(R.id.odchangan_car_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.lufengxiaoyao.RZCLufengXiaoyaoIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RZCLufengXiaoyaoIndexAct.this, RZCLufengXiaoyaoSetFunc.class);
                    RZCLufengXiaoyaoIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.odchangan_car_air)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.lufengxiaoyao.RZCLufengXiaoyaoIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RZCLufengXiaoyaoIndexAct.this, Air_Activity_All_Toyota_prado_HP.class);
                    RZCLufengXiaoyaoIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.odchangan_car_tire)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.lufengxiaoyao.RZCLufengXiaoyaoIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RZCLufengXiaoyaoIndexAct.this, RZCLufengXiaoyaoTireAct.class);
                    RZCLufengXiaoyaoIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
