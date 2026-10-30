package com.syu.carinfo.rzc.keleijia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class KeLeiJiaIndex2 extends BaseActivity {
    View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJiaIndex2.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            Class<?> cls = null;
            switch (v.getId()) {
                case R.id.ctv_checkedtext1 /* 2131427554 */:
                    cls = KeLeiJia_Set_SeatSet.class;
                    break;
                case R.id.ctv_checkedtext4 /* 2131427561 */:
                    cls = KeLeiJia_Set_Park.class;
                    break;
                case R.id.ctv_checkedtext5 /* 2131427562 */:
                    cls = KeLeiJia_Set_Drive.class;
                    break;
                case R.id.ctv_checkedtext2 /* 2131427576 */:
                    cls = KeLeiJia_Set_HandupSet.class;
                    break;
                case R.id.ctv_checkedtext3 /* 2131427577 */:
                    cls = KeLeiJia_Set_Reset.class;
                    break;
                case R.id.ctv_checkedtext6 /* 2131427581 */:
                    cls = KeLeiJia_Set_Fengweideng.class;
                    break;
                case R.id.ctv_checkedtext7 /* 2131427582 */:
                    cls = KeLeiJia_Set_UserSet.class;
                    break;
                case R.id.ctv_checkedtext8 /* 2131427633 */:
                    cls = KeLeiJia_Set_MULTISet.class;
                    break;
                case R.id.ctv_checkedtext9 /* 2131427634 */:
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
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this.mClickListener);
        if (DataCanbus.DATA[1000] == 1769874 || DataCanbus.DATA[1000] == 1704338 || DataCanbus.DATA[1000] == 1048978 || DataCanbus.DATA[1000] == 2163090 || DataCanbus.DATA[1000] == 3473810 || DataCanbus.DATA[1000] == 1376658 || DataCanbus.DATA[1000] == 8978834 || DataCanbus.DATA[1000] == 786834 || DataCanbus.DATA[1000] == 6554002 || DataCanbus.DATA[1000] == 6488466 || DataCanbus.DATA[1000] == 6816146 || DataCanbus.DATA[1000] == 7012754 || DataCanbus.DATA[1000] == 7078290 || DataCanbus.DATA[1000] == 7143826 || DataCanbus.DATA[1000] == 8389010 || DataCanbus.DATA[1000] == 8454546 || DataCanbus.DATA[1000] == 8520082 || DataCanbus.DATA[1000] == 8585618 || DataCanbus.DATA[1000] == 8651154 || DataCanbus.DATA[1000] == 8716690 || DataCanbus.DATA[1000] == 7209362 || DataCanbus.DATA[1000] == 7274898 || DataCanbus.DATA[1000] == 7340434 || DataCanbus.DATA[1000] == 7405970 || DataCanbus.DATA[1000] == 7471506 || DataCanbus.DATA[1000] == 7537042 || DataCanbus.DATA[1000] == 7602578 || DataCanbus.DATA[1000] == 7668114 || DataCanbus.DATA[1000] == 7733650 || DataCanbus.DATA[1000] == 7799186 || DataCanbus.DATA[1000] == 7864722 || DataCanbus.DATA[1000] == 7930258 || DataCanbus.DATA[1000] == 7995794 || DataCanbus.DATA[1000] == 8061330 || DataCanbus.DATA[1000] == 8126866 || DataCanbus.DATA[1000] == 8192402 || DataCanbus.DATA[1000] == 8257938 || DataCanbus.DATA[1000] == 8323474) {
            findViewById(R.id.layout_view2).setVisibility(0);
        } else {
            findViewById(R.id.layout_view2).setVisibility(8);
        }
    }
}
