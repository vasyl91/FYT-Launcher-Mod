package com.syu.carinfo.lz.spirior;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

public class Lz_425_Spirior_IndexActi extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0425_lz_spirior_index);
        init();
    }

    @Override
    public void init() {
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Lz_425_Spirior_IndexActi.this, Lz_425_Spirior_MeterAct.class);
                    Lz_425_Spirior_IndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.ctv_checkedtext2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Lz_425_Spirior_IndexActi.this, Lz_425_Spirior_LightAct.class);
                    Lz_425_Spirior_IndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
