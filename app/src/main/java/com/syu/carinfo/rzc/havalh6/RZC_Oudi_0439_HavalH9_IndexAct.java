package com.syu.carinfo.rzc.havalh6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.hava.BNRActivityHavaH6SetAct;
import com.syu.carinfo.hava.BNRActivityHavaH8EQSetAct;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RZC_Oudi_0439_HavalH9_IndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_oudi_havalh9_index);
        init();
    }

    @Override
    public void init() {
        if (DataCanbus.DATA[1000] != 16318903 && DataCanbus.DATA[1000] != 16384439) {
            findViewById(R.id.layout_view1).setVisibility(8);
        }
        this.mClick = new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Class<?> cls = null;
                switch (v.getId()) {
                    case R.id.ctv_checkedtext1 /* 2131427525 */:
                        if (DataCanbus.DATA[1000] == 7078327 || DataCanbus.DATA[1000] == 7143863 || DataCanbus.DATA[1000] == 11272631 || DataCanbus.DATA[1000] == 7602615) {
                            cls = Activity439Hava18H6SetAct.class;
                            break;
                        } else if (DataCanbus.DATA[1000] == 16318903 || DataCanbus.DATA[1000] == 16384439) {
                            cls = BNRActivityHavaH6SetAct.class;
                            break;
                        } else if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 2556343 || DataCanbus.DATA[1000] == 8651204 || DataCanbus.DATA[1000] == 11796934 || DataCanbus.DATA[1000] == 11862470) {
                            cls = Rzc_0439_HavalH9SetAct.class;
                            break;
                        } else {
                            cls = Oudi_0439_HavalH9SetAct.class;
                            break;
                        }
                    case R.id.ctv_checkedtext2 /* 2131427541 */:
                        cls = BNRActivityHavaH8EQSetAct.class;
                        break;
                    case R.id.ctv_checkedtext3 /* 2131427542 */:
                        if (DataCanbus.DATA[1000] == 7078327 || DataCanbus.DATA[1000] == 7143863 || DataCanbus.DATA[1000] == 7143863) {
                            cls = ActivityHavaRZCH2SCarInfo2.class;
                            break;
                        } else if (DataCanbus.DATA[1000] == 16318903 || DataCanbus.DATA[1000] == 16384439) {
                            cls = BNR_Oudi_0439_HavalH9CarinfoAct.class;
                            break;
                        } else {
                            cls = Rzc_Oudi_0439_HavalH9CarinfoAct.class;
                            break;
                        }
                }
                if (cls != null) {
                    try {
                        Intent ii = new Intent();
                        ii.setClass(RZC_Oudi_0439_HavalH9_IndexAct.this, cls);
                        RZC_Oudi_0439_HavalH9_IndexAct.this.startActivity(ii);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        View v = findViewById(R.id.ctv_checkedtext1);
        setClick(v);
        View v2 = findViewById(R.id.ctv_checkedtext3);
        setClick(v2);
        View v3 = findViewById(R.id.ctv_checkedtext2);
        setClick(v3);
    }
}
