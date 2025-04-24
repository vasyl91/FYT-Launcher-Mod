package com.syu.carinfo.rzc.keleijia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class KeLeiJiaIndex2 extends BaseActivity {
    View.OnClickListener mClickListener = new View.OnClickListener() { 
        @Override
        public void onClick(View v) {
            Class<?> cls = null;
            switch (v.getId()) {
                case R.id.ctv_checkedtext1 /* 2131427525 */:
                    cls = KeLeiJia_Set_SeatSet.class;
                    break;
                case R.id.ctv_checkedtext2 /* 2131427541 */:
                    cls = KeLeiJia_Set_HandupSet.class;
                    break;
                case R.id.ctv_checkedtext3 /* 2131427542 */:
                    cls = KeLeiJia_Set_Reset.class;
                    break;
                case R.id.ctv_checkedtext4 /* 2131427544 */:
                    cls = KeLeiJia_Set_Park.class;
                    break;
                case R.id.ctv_checkedtext5 /* 2131427547 */:
                    cls = KeLeiJia_Set_Drive.class;
                    break;
                case R.id.ctv_checkedtext6 /* 2131427548 */:
                    cls = KeLeiJia_Set_Fengweideng.class;
                    break;
                case R.id.ctv_checkedtext7 /* 2131427549 */:
                    cls = KeLeiJia_Set_UserSet.class;
                    break;
                case R.id.ctv_checkedtext8 /* 2131427550 */:
                    cls = KeLeiJia_Set_MULTISet.class;
                    break;
                case R.id.ctv_checkedtext9 /* 2131427551 */:
                    cls = KeLeiJia_Set_AMPSet.class;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_bsd_keleijia_index2);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this.mClickListener);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this.mClickListener);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this.mClickListener);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this.mClickListener);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this.mClickListener);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this.mClickListener);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this.mClickListener);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this.mClickListener);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this.mClickListener);
        if (DataCanbus.DATA[1000] == 1769874 || DataCanbus.DATA[1000] == 1704338 || DataCanbus.DATA[1000] == 1048978 || DataCanbus.DATA[1000] == 2163090 || DataCanbus.DATA[1000] == 3473810 || DataCanbus.DATA[1000] == 1376658 || DataCanbus.DATA[1000] == 786834 || DataCanbus.DATA[1000] == 6554002 || DataCanbus.DATA[1000] == 6488466 || DataCanbus.DATA[1000] == 6816146) {
            findViewById(R.id.layout_view2).setVisibility(0);
        } else {
            findViewById(R.id.layout_view2).setVisibility(8);
        }
    }
}
