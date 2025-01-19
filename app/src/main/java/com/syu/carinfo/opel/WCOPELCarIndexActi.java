package com.syu.carinfo.opel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

public class WCOPELCarIndexActi extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_opel_index);
        init();
    }

    @Override
    public void init() {
        findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(WCOPELCarIndexActi.this, WCOPELCarInfoActivity.class);
                    WCOPELCarIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(WCOPELCarIndexActi.this, WCOPELCarListActivity.class);
                    WCOPELCarIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
