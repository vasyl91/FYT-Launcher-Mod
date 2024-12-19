package com.syu.carinfo.hc.oubao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.hc.tianlai.ActivityTianLaiCarCD;
import com.syu.carinfo.hc.tianlai.ActivityTianLaiCarInfo;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class IndexAct_Hc_14Oubao extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_hc_14oubao_index);
        if (((Button) findViewById(R.id.jeep_car_cd)) != null) {
            ((Button) findViewById(R.id.jeep_car_cd)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.oubao.IndexAct_Hc_14Oubao.1
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(IndexAct_Hc_14Oubao.this, ActivityTianLaiCarCD.class);
                        IndexAct_Hc_14Oubao.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        if (((Button) findViewById(R.id.jeep_car_radio)) != null) {
            ((Button) findViewById(R.id.jeep_car_radio)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hc.oubao.IndexAct_Hc_14Oubao.2
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(IndexAct_Hc_14Oubao.this, ActivityTianLaiCarInfo.class);
                        IndexAct_Hc_14Oubao.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
