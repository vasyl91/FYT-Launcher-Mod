package com.syu.carinfo.rzc.keleijia;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class KeLeiJia_Set_Reset extends BaseActivity {
    private int type = 0;
    private int[] iResetString = {R.string.bsd_klj_str13, R.string.bsd_klj_str14, R.string.bsd_klj_str15, R.string.bsd_klj_str16, R.string.bsd_klj_str17, R.string.str_seat_massage, R.string.str_head_up_display};
    View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJia_Set_Reset.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            KeLeiJia_Set_Reset.this.type = 0;
            switch (v.getId()) {
                case R.id.ctv_checkedtext1 /* 2131427554 */:
                    KeLeiJia_Set_Reset.this.type = 6;
                    KeLeiJia_Set_Reset.this.postConfirmDialog(KeLeiJia_Set_Reset.this.type);
                    break;
                case R.id.ctv_checkedtext4 /* 2131427561 */:
                    KeLeiJia_Set_Reset.this.type = 2;
                    KeLeiJia_Set_Reset.this.postConfirmDialog(KeLeiJia_Set_Reset.this.type);
                    break;
                case R.id.ctv_checkedtext5 /* 2131427562 */:
                    KeLeiJia_Set_Reset.this.type = 3;
                    KeLeiJia_Set_Reset.this.postConfirmDialog(KeLeiJia_Set_Reset.this.type);
                    break;
                case R.id.ctv_checkedtext2 /* 2131427576 */:
                    KeLeiJia_Set_Reset.this.type = 7;
                    KeLeiJia_Set_Reset.this.postConfirmDialog(KeLeiJia_Set_Reset.this.type);
                    break;
                case R.id.ctv_checkedtext3 /* 2131427577 */:
                    KeLeiJia_Set_Reset.this.type = 1;
                    KeLeiJia_Set_Reset.this.postConfirmDialog(KeLeiJia_Set_Reset.this.type);
                    break;
                case R.id.ctv_checkedtext6 /* 2131427581 */:
                    KeLeiJia_Set_Reset.this.type = 4;
                    KeLeiJia_Set_Reset.this.postConfirmDialog(KeLeiJia_Set_Reset.this.type);
                    break;
                case R.id.ctv_checkedtext7 /* 2131427582 */:
                    KeLeiJia_Set_Reset.this.type = 5;
                    KeLeiJia_Set_Reset.this.postConfirmDialog(KeLeiJia_Set_Reset.this.type);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bsd_keleijia_set_reset);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this.mClickListener);
        if (DataCanbus.DATA[1000] == 1048978 || DataCanbus.DATA[1000] == 1376658 || DataCanbus.DATA[1000] == 8978834 || DataCanbus.DATA[1000] == 1769874 || DataCanbus.DATA[1000] == 1704338 || DataCanbus.DATA[1000] == 1966482 || DataCanbus.DATA[1000] == 2032018 || DataCanbus.DATA[1000] == 6029714 || DataCanbus.DATA[1000] == 2097554 || DataCanbus.DATA[1000] == 2163090 || DataCanbus.DATA[1000] == 786834 || DataCanbus.DATA[1000] == 6554002 || DataCanbus.DATA[1000] == 6488466 || DataCanbus.DATA[1000] == 6816146 || DataCanbus.DATA[1000] == 7012754 || DataCanbus.DATA[1000] == 7078290 || DataCanbus.DATA[1000] == 7143826 || DataCanbus.DATA[1000] == 8389010 || DataCanbus.DATA[1000] == 8454546 || DataCanbus.DATA[1000] == 8520082 || DataCanbus.DATA[1000] == 8585618 || DataCanbus.DATA[1000] == 8651154 || DataCanbus.DATA[1000] == 8716690 || DataCanbus.DATA[1000] == 7209362 || DataCanbus.DATA[1000] == 7274898 || DataCanbus.DATA[1000] == 7340434 || DataCanbus.DATA[1000] == 7405970 || DataCanbus.DATA[1000] == 7471506 || DataCanbus.DATA[1000] == 7537042 || DataCanbus.DATA[1000] == 7602578 || DataCanbus.DATA[1000] == 7668114 || DataCanbus.DATA[1000] == 7733650 || DataCanbus.DATA[1000] == 7799186 || DataCanbus.DATA[1000] == 7864722 || DataCanbus.DATA[1000] == 7930258 || DataCanbus.DATA[1000] == 7995794 || DataCanbus.DATA[1000] == 8061330 || DataCanbus.DATA[1000] == 8126866 || DataCanbus.DATA[1000] == 8192402 || DataCanbus.DATA[1000] == 8257938 || DataCanbus.DATA[1000] == 8323474) {
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
            builder.setTitle(this.iResetString[type - 1]).setPositiveButton(R.string.wc_psa_all_confirm, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJia_Set_Reset.2
                @Override // android.content.DialogInterface.OnClickListener
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
