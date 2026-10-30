package com.syu.carinfo.zx6606;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.honda.CZHHondaNewCarinfoAct;
import com.syu.carinfo.honda.HondaIndexActi;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ZX6606HondaIndexActi extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_zx6606_honda_index);
        ((Button) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.zx6606.ZX6606HondaIndexActi.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(ZX6606HondaIndexActi.this, HondaIndexActi.class);
                    ZX6606HondaIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.zx6606.ZX6606HondaIndexActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_CZH_RZC_HONDA_Civic /* 5636394 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_10Yage /* 5701930 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_Haoying /* 5767466 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_CRV /* 5833002 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_XRV /* 7143722 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_Vezel /* 7209258 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_Lingpai /* 7274794 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_CRV_H /* 7340330 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_Fit /* 7405866 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_CRV_21_Hybrid /* 7471402 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_Haoying_21_Hybrid /* 7536938 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_CRV_21_EV /* 7602474 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_Haoying_21_EV /* 7668010 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_Siyu_22 /* 7733546 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_Fit_21 /* 7799082 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_Aodesai_22 /* 7864618 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_ZRV_22 /* 7930154 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_ELYSION_22 /* 7995690 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_CRV_22 /* 8061226 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_Aodesai_15 /* 8126762 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_CRV_21_Hybrid_H /* 8192298 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_Haoying_21_Hybrid_H /* 8257834 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_CRV_21_EV_H /* 8323370 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_Haoying_21_EV_H /* 8388906 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_Siyu_22_H /* 8454442 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_Fit_21_H /* 8519978 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_Aodesai_22_H /* 8585514 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_ZRV_22_H /* 8651050 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_ELYSION_22_H /* 8716586 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_CRV_22_H /* 8782122 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_XRV_H /* 8847658 */:
                        case FinalCanbus.CAR_CZH_RZC_HONDA_Vezel_H /* 8913194 */:
                            intent.setClass(ZX6606HondaIndexActi.this, CZHHondaNewCarinfoAct.class);
                            break;
                        default:
                            intent.setClass(ZX6606HondaIndexActi.this, ZX6606HondaNewCarinfoAct.class);
                            break;
                    }
                    ZX6606HondaIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }
}
