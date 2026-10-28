package com.syu.carinfo.xc.lexus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

@SuppressWarnings({"deprecation", "unchecked"})
public class XCLexusIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_xc_lexus_indexact);
        ((Button) findViewById(R.id.lexus_car_radio)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XCLexusIndexAct.this, XCLexusRadio.class);
                    XCLexusIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.lexus_car_air)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XCLexusIndexAct.this, XCLexusCarUSB.class);
                    XCLexusIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.lexus_car_cd)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XCLexusIndexAct.this, XCLexusCd.class);
                    XCLexusIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
