package com.syu.carinfo.b70;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.air.Air_Activity_All_Toyota_prado_HP;

@SuppressWarnings({"deprecation", "unchecked"})
public class BengTeng_RZC_17B70QC_Index extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_14b70qc_index);
        init();
    }

    @Override
    public void init() {
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(BengTeng_RZC_17B70QC_Index.this, BenTeng14B70ClockSet.class);
                    BengTeng_RZC_17B70QC_Index.this.startActivity(intent);
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
                    intent.setClass(BengTeng_RZC_17B70QC_Index.this, Air_Activity_All_Toyota_prado_HP.class);
                    BengTeng_RZC_17B70QC_Index.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
