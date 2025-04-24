package com.syu.carinfo.havah6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

@SuppressWarnings({"deprecation", "unchecked"})
public class WC_0320_HavalH9_IndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_oudi_havalh9_index);
        init();
    }

    @Override
    public void init() {
        this.mClick = new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Class<?> cls = null;
                switch (v.getId()) {
                    case R.id.ctv_checkedtext1 /* 2131427525 */:
                        cls = WC_0320_HavalH9SetAct.class;
                        break;
                    case R.id.ctv_checkedtext2 /* 2131427541 */:
                        cls = WC_0320_HavalH9AmpCarSet.class;
                        break;
                    case R.id.ctv_checkedtext3 /* 2131427542 */:
                        cls = WC_0320_HavalH9CarinfoAct.class;
                        break;
                }
                if (cls != null) {
                    try {
                        Intent ii = new Intent();
                        ii.setClass(WC_0320_HavalH9_IndexAct.this, cls);
                        WC_0320_HavalH9_IndexAct.this.startActivity(ii);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        View v = findViewById(R.id.ctv_checkedtext1);
        setClick(v);
        View v2 = findViewById(R.id.ctv_checkedtext2);
        setClick(v2);
        View v3 = findViewById(R.id.ctv_checkedtext3);
        setClick(v3);
    }
}
