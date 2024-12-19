package com.syu.carinfo.havah6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WcHaval17and18H6Acti extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WcHaval17and18H6Acti.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            Intent intent = new Intent();
            int id = v.getId();
            switch (id) {
                case R.id.ctv_checkedtext1 /* 2131427478 */:
                    intent.setClass(WcHaval17and18H6Acti.this, WC_0320_HavalH9AmpCarSet.class);
                    WcHaval17and18H6Acti.this.startActivity(intent);
                    break;
                case R.id.ctv_checkedtext2 /* 2131427531 */:
                    intent.setClass(WcHaval17and18H6Acti.this, Wc_320_CarSetlAct_newH6.class);
                    WcHaval17and18H6Acti.this.startActivity(intent);
                    break;
                case R.id.ctv_checkedtext3 /* 2131427532 */:
                    intent.setClass(WcHaval17and18H6Acti.this, ActivityNewH6CarInfo.class);
                    WcHaval17and18H6Acti.this.startActivity(intent);
                    break;
                case R.id.ctv_checkedtext4 /* 2131427533 */:
                    intent.setClass(WcHaval17and18H6Acti.this, WcHavalH6Acti.class);
                    WcHaval17and18H6Acti.this.startActivity(intent);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_320_wc_haval_newh6);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setClick((Button) findViewById(R.id.ctv_checkedtext2));
        setClick((Button) findViewById(R.id.ctv_checkedtext3));
        setClick((Button) findViewById(R.id.ctv_checkedtext4));
        setClick((Button) findViewById(R.id.ctv_checkedtext1));
        ((Button) findViewById(R.id.ctv_checkedtext1)).setVisibility(8);
        if (DataCanbus.DATA[1000] == 131392 || DataCanbus.DATA[1000] == 917824 || DataCanbus.DATA[1000] == 1179968 || DataCanbus.DATA[1000] == 983360 || DataCanbus.DATA[1000] == 1048896) {
            ((Button) findViewById(R.id.ctv_checkedtext2)).setVisibility(0);
            return;
        }
        if (DataCanbus.DATA[1000] == 196928 || DataCanbus.DATA[1000] == 262464 || DataCanbus.DATA[1000] == 524608) {
            ((Button) findViewById(R.id.ctv_checkedtext2)).setVisibility(8);
        } else if (DataCanbus.DATA[1000] == 1245504 || DataCanbus.DATA[1000] == 1311040) {
            ((Button) findViewById(R.id.ctv_checkedtext2)).setVisibility(0);
            ((Button) findViewById(R.id.ctv_checkedtext1)).setVisibility(0);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void setClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
        }
    }
}
