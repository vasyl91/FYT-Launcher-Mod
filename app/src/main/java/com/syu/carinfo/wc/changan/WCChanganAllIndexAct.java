package com.syu.carinfo.wc.changan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class WCChanganAllIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_changan_indexact);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 393344) {
                        intent.setClass(WCChanganAllIndexAct.this, ActivityChangAnOuShangX70A.class);
                    } else {
                        intent.setClass(WCChanganAllIndexAct.this, ActivityChangAn17CS75.class);
                    }
                    WCChanganAllIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    if (DataCanbus.DATA[1000] == 393344) {
                        intent.setClass(WCChanganAllIndexAct.this, WCChanganOushangX70ATireAct.class);
                    } else {
                        intent.setClass(WCChanganAllIndexAct.this, WCChanganAllTireAct.class);
                    }
                    WCChanganAllIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
