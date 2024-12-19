package com.syu.carinfo.rzc.keleijia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class KeLeiJiaIndex2 extends BaseActivity {
    View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJiaIndex2.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            Class<?> cls = null;
            switch (v.getId()) {
                case R.id.ctv_checkedtext1 /* 2131427478 */:
                    cls = KeLeiJia_Set_SeatSet.class;
                    break;
                case R.id.ctv_checkedtext2 /* 2131427531 */:
                    cls = KeLeiJia_Set_HandupSet.class;
                    break;
                case R.id.ctv_checkedtext3 /* 2131427532 */:
                    cls = KeLeiJia_Set_Reset.class;
                    break;
                case R.id.ctv_checkedtext4 /* 2131427533 */:
                    cls = KeLeiJia_Set_Park.class;
                    break;
                case R.id.ctv_checkedtext5 /* 2131427537 */:
                    cls = KeLeiJia_Set_Drive.class;
                    break;
                case R.id.ctv_checkedtext6 /* 2131427538 */:
                    cls = KeLeiJia_Set_Fengweideng.class;
                    break;
                case R.id.ctv_checkedtext7 /* 2131427539 */:
                    cls = KeLeiJia_Set_UserSet.class;
                    break;
                case R.id.ctv_checkedtext8 /* 2131427540 */:
                    cls = KeLeiJia_Set_MULTISet.class;
                    break;
            }
            if (cls != null) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(KeLeiJiaIndex2.this, cls);
                    KeLeiJiaIndex2.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bsd_keleijia_index2);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this.mClickListener);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this.mClickListener);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this.mClickListener);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this.mClickListener);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this.mClickListener);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this.mClickListener);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this.mClickListener);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this.mClickListener);
        if (DataCanbus.DATA[1000] == 1769874 || DataCanbus.DATA[1000] == 1704338 || DataCanbus.DATA[1000] == 1048978 || DataCanbus.DATA[1000] == 2163090 || DataCanbus.DATA[1000] == 3473810 || DataCanbus.DATA[1000] == 1376658 || DataCanbus.DATA[1000] == 786834) {
            findViewById(R.id.layout_view1).setVisibility(0);
            findViewById(R.id.layout_view2).setVisibility(0);
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
        }
    }
}
