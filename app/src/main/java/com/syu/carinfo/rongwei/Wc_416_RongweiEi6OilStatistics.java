package com.syu.carinfo.rongwei;

import android.app.Activity;
import android.os.Bundle;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.VerticalProgressbar;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0416_WC2_RongWeiRX5;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Wc_416_RongweiEi6OilStatistics extends Activity {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rongwei.Wc_416_RongweiEi6OilStatistics.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 156:
                    Wc_416_RongweiEi6OilStatistics.this.updateEnergyCurStatistics();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_273_rongwei_ei6_oil_statistics);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEnergyCurStatistics() {
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_0)) != null) {
            int vaule = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[0] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_0)).setProgress(vaule);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_0)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_1)) != null) {
            int vaule2 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[1] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_1)).setProgress(vaule2);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_1)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_2)) != null) {
            int vaule3 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[2] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_2)).setProgress(vaule3);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_2)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_3)) != null) {
            int vaule4 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[3] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_3)).setProgress(vaule4);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_3)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_4)) != null) {
            int vaule5 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[4] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_4)).setProgress(vaule5);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_4)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_5)) != null) {
            int vaule6 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[5] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_5)).setProgress(vaule6);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_5)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_6)) != null) {
            int vaule7 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[6] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_6)).setProgress(vaule7);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_6)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_7)) != null) {
            int vaule8 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[7] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_7)).setProgress(vaule8);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_7)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_8)) != null) {
            int vaule9 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[8] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_8)).setProgress(vaule9);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_8)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_9)) != null) {
            int vaule10 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[9] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_9)).setProgress(vaule10);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_9)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_10)) != null) {
            int vaule11 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[10] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_10)).setProgress(vaule11);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_10)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_11)) != null) {
            int vaule12 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[11] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_11)).setProgress(vaule12);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_11)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_12)) != null) {
            int vaule13 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[12] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_12)).setProgress(vaule13);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_12)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_13)) != null) {
            int vaule14 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[13] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_13)).setProgress(vaule14);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_13)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_14)) != null) {
            int vaule15 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[14] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_14)).setProgress(vaule15);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_14)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_15)) != null) {
            int vaule16 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[15] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_15)).setProgress(vaule16);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_15)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_16)) != null) {
            int vaule17 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[16] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_16)).setProgress(vaule17);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_16)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_17)) != null) {
            int vaule18 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[17] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_17)).setProgress(vaule18);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_17)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_18)) != null) {
            int vaule19 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[18] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_18)).setProgress(vaule19);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_18)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_19)) != null) {
            int vaule20 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[19] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_19)).setProgress(vaule20);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_19)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_20)) != null) {
            int vaule21 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[20] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_20)).setProgress(vaule21);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_20)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_21)) != null) {
            int vaule22 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[21] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_21)).setProgress(vaule22);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_21)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_22)) != null) {
            int vaule23 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[22] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_22)).setProgress(vaule23);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_22)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_23)) != null) {
            int vaule24 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[23] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_23)).setProgress(vaule24);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_23)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_24)) != null) {
            int vaule25 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[24] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_24)).setProgress(vaule25);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_24)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_25)) != null) {
            int vaule26 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[25] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_25)).setProgress(vaule26);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_25)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_26)) != null) {
            int vaule27 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[27] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_26)).setProgress(vaule27);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_26)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_27)) != null) {
            int vaule28 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[27] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_27)).setProgress(vaule28);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_27)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_28)) != null) {
            int vaule29 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[28] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_28)).setProgress(vaule29);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_28)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_29)) != null) {
            int vaule30 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[29] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_29)).setProgress(vaule30);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_29)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_30)) != null) {
            int vaule31 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[30] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_30)).setProgress(vaule31);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_30)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_31)) != null) {
            int vaule32 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[31] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_31)).setProgress(vaule32);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_31)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_32)) != null) {
            int vaule33 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[32] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_32)).setProgress(vaule33);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_32)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_33)) != null) {
            int vaule34 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[33] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_33)).setProgress(vaule34);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_33)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_34)) != null) {
            int vaule35 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[34] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_34)).setProgress(vaule35);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_34)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_35)) != null) {
            int vaule36 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[35] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_35)).setProgress(vaule36);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_35)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_36)) != null) {
            int vaule37 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[36] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_36)).setProgress(vaule37);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_36)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_37)) != null) {
            int vaule38 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[37] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_37)).setProgress(vaule38);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_37)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_38)) != null) {
            int vaule39 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[38] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_38)).setProgress(vaule39);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_38)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_39)) != null) {
            int vaule40 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[39] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_39)).setProgress(vaule40);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_39)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_40)) != null) {
            int vaule41 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[40] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_40)).setProgress(vaule41);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_40)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_41)) != null) {
            int vaule42 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[41] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_41)).setProgress(vaule42);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_41)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_42)) != null) {
            int vaule43 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[42] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_42)).setProgress(vaule43);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_42)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_43)) != null) {
            int vaule44 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[43] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_43)).setProgress(vaule44);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_43)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_44)) != null) {
            int vaule45 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[44] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_44)).setProgress(vaule45);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_44)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_45)) != null) {
            int vaule46 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[45] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_45)).setProgress(vaule46);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_45)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_46)) != null) {
            int vaule47 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[46] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_46)).setProgress(vaule47);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_46)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_47)) != null) {
            int vaule48 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[47] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_47)).setProgress(vaule48);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_47)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_48)) != null) {
            int vaule49 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[48] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_48)).setProgress(vaule49);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_48)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_49)) != null) {
            int vaule50 = (Callback_0416_WC2_RongWeiRX5.U_CARINFO_OIL_LIST[49] * 30) / 20;
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_49)).setProgress(vaule50);
            ((VerticalProgressbar) findViewById(R.id.camry_progressbar_49)).invalidate();
        }
    }
}
