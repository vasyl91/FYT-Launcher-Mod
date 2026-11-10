package com.syu.carinfo.rzc.xp.cs75;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class BnrChanganCX70IndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_odchangan_indexact);
        findViewById(R.id.odchangan_car_air_view).setVisibility(8);
        ((Button) findViewById(R.id.odchangan_car_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.BnrChanganCX70IndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_BNR_CX70 /* 262214 */:
                        case FinalCanbus.CAR_BNR_19COS /* 917574 */:
                        case FinalCanbus.CAR_BNR_17CX70 /* 983110 */:
                        case FinalCanbus.CAR_BNR_17CX70_M /* 1048646 */:
                        case FinalCanbus.CAR_BNR_17CX70_H /* 1114182 */:
                            intent.setClass(BnrChanganCX70IndexAct.this, ChangAnBNRCS75Act.class);
                            break;
                        default:
                            intent.setClass(BnrChanganCX70IndexAct.this, ChangAnCS75Act.class);
                            break;
                    }
                    BnrChanganCX70IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.odchangan_car_tire)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.BnrChanganCX70IndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(BnrChanganCX70IndexAct.this, BnrChanganCX70TireAct.class);
                    BnrChanganCX70IndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
