package com.syu.carinfo.rzc.keleijia;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class KeLeiJia_Set_Reset extends BaseActivity {
    private int type = 0;
    private int[] iResetString = {R.string.bsd_klj_str13, R.string.bsd_klj_str14, R.string.bsd_klj_str15, R.string.bsd_klj_str16, R.string.bsd_klj_str17, R.string.str_seat_massage, R.string.str_head_up_display};
    View.OnClickListener mClickListener = new View.OnClickListener() { 
        @Override
        public void onClick(View v) {
            KeLeiJia_Set_Reset.this.type = 0;
            switch (v.getId()) {
                case R.id.ctv_checkedtext1 /* 2131427525 */:
                    KeLeiJia_Set_Reset.this.type = 6;
                    KeLeiJia_Set_Reset.this.postConfirmDialog(KeLeiJia_Set_Reset.this.type);
                    break;
                case R.id.ctv_checkedtext2 /* 2131427541 */:
                    KeLeiJia_Set_Reset.this.type = 7;
                    KeLeiJia_Set_Reset.this.postConfirmDialog(KeLeiJia_Set_Reset.this.type);
                    break;
                case R.id.ctv_checkedtext3 /* 2131427542 */:
                    KeLeiJia_Set_Reset.this.type = 1;
                    KeLeiJia_Set_Reset.this.postConfirmDialog(KeLeiJia_Set_Reset.this.type);
                    break;
                case R.id.ctv_checkedtext4 /* 2131427544 */:
                    KeLeiJia_Set_Reset.this.type = 2;
                    KeLeiJia_Set_Reset.this.postConfirmDialog(KeLeiJia_Set_Reset.this.type);
                    break;
                case R.id.ctv_checkedtext5 /* 2131427547 */:
                    KeLeiJia_Set_Reset.this.type = 3;
                    KeLeiJia_Set_Reset.this.postConfirmDialog(KeLeiJia_Set_Reset.this.type);
                    break;
                case R.id.ctv_checkedtext6 /* 2131427548 */:
                    KeLeiJia_Set_Reset.this.type = 4;
                    KeLeiJia_Set_Reset.this.postConfirmDialog(KeLeiJia_Set_Reset.this.type);
                    break;
                case R.id.ctv_checkedtext7 /* 2131427549 */:
                    KeLeiJia_Set_Reset.this.type = 5;
                    KeLeiJia_Set_Reset.this.postConfirmDialog(KeLeiJia_Set_Reset.this.type);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_bsd_keleijia_set_reset);
        init();
    }

    @Override
    public void init() {
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this.mClickListener);
        if (DataCanbus.DATA[1000] == 1048978 || DataCanbus.DATA[1000] == 1376658 || DataCanbus.DATA[1000] == 1769874 || DataCanbus.DATA[1000] == 1704338 || DataCanbus.DATA[1000] == 1966482 || DataCanbus.DATA[1000] == 2032018 || DataCanbus.DATA[1000] == 6029714 || DataCanbus.DATA[1000] == 2097554 || DataCanbus.DATA[1000] == 2163090 || DataCanbus.DATA[1000] == 786834 || DataCanbus.DATA[1000] == 6554002 || DataCanbus.DATA[1000] == 6488466 || DataCanbus.DATA[1000] == 6816146) {
            findViewById(R.id.layout_view1).setVisibility(0);
            findViewById(R.id.layout_view2).setVisibility(0);
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
        }
    }

    void checkAndSetListener(View v, View.OnClickListener clickListener) {
        if (v != null) {
            v.setOnClickListener(clickListener);
        }
    }

    protected void postConfirmDialog(final int type) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(this.iResetString[type - 1]).setPositiveButton(R.string.wc_psa_all_confirm, new DialogInterface.OnClickListener() { 
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    int value = type;
                    if (value > 0) {
                        DataCanbus.PROXY.cmd(1, new int[]{128, value}, null, null);
                    }
                }
            }).setNegativeButton(R.string.wc_psa_all_cancel, (DialogInterface.OnClickListener) null);
            builder.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
