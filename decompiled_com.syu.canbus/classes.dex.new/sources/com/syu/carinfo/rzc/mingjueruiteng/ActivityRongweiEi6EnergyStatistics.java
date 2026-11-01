package com.syu.carinfo.rzc.mingjueruiteng;

import android.app.Activity;
import android.os.Bundle;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.VerticalProgressbar;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0273_RZC_XP1_MingJueRuiTeng;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ActivityRongweiEi6EnergyStatistics extends Activity {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.mingjueruiteng.ActivityRongweiEi6EnergyStatistics.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 188:
                    ActivityRongweiEi6EnergyStatistics.this.updateEnergyCurStatistics();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_273_rongwei_ei6_energy_statistics);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEnergyCurStatistics() {
        if (((VerticalProgressbar) findViewById(R.id.layout_view1)) != null) {
            int vaule = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[0] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view1)).setProgress(vaule);
            ((VerticalProgressbar) findViewById(R.id.layout_view1)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view2)) != null) {
            int vaule2 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[1] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view2)).setProgress(vaule2);
            ((VerticalProgressbar) findViewById(R.id.layout_view2)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view3)) != null) {
            int vaule3 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[2] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view3)).setProgress(vaule3);
            ((VerticalProgressbar) findViewById(R.id.layout_view3)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view4)) != null) {
            int vaule4 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[3] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view4)).setProgress(vaule4);
            ((VerticalProgressbar) findViewById(R.id.layout_view4)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view5)) != null) {
            int vaule5 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[4] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view5)).setProgress(vaule5);
            ((VerticalProgressbar) findViewById(R.id.layout_view5)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view6)) != null) {
            int vaule6 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[5] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view6)).setProgress(vaule6);
            ((VerticalProgressbar) findViewById(R.id.layout_view6)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view7)) != null) {
            int vaule7 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[6] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view7)).setProgress(vaule7);
            ((VerticalProgressbar) findViewById(R.id.layout_view7)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view8)) != null) {
            int vaule8 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[7] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view8)).setProgress(vaule8);
            ((VerticalProgressbar) findViewById(R.id.layout_view8)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view9)) != null) {
            int vaule9 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[8] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view9)).setProgress(vaule9);
            ((VerticalProgressbar) findViewById(R.id.layout_view9)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view10)) != null) {
            int vaule10 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[9] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view10)).setProgress(vaule10);
            ((VerticalProgressbar) findViewById(R.id.layout_view10)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view11)) != null) {
            int vaule11 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[10] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view11)).setProgress(vaule11);
            ((VerticalProgressbar) findViewById(R.id.layout_view11)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view12)) != null) {
            int vaule12 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[11] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view12)).setProgress(vaule12);
            ((VerticalProgressbar) findViewById(R.id.layout_view12)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view13)) != null) {
            int vaule13 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[12] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view13)).setProgress(vaule13);
            ((VerticalProgressbar) findViewById(R.id.layout_view13)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view14)) != null) {
            int vaule14 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[13] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view14)).setProgress(vaule14);
            ((VerticalProgressbar) findViewById(R.id.layout_view14)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view15)) != null) {
            int vaule15 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[14] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view15)).setProgress(vaule15);
            ((VerticalProgressbar) findViewById(R.id.layout_view15)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view16)) != null) {
            int vaule16 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[15] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view16)).setProgress(vaule16);
            ((VerticalProgressbar) findViewById(R.id.layout_view16)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view17)) != null) {
            int vaule17 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[16] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view17)).setProgress(vaule17);
            ((VerticalProgressbar) findViewById(R.id.layout_view17)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view18)) != null) {
            int vaule18 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[17] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view18)).setProgress(vaule18);
            ((VerticalProgressbar) findViewById(R.id.layout_view18)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view19)) != null) {
            int vaule19 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[18] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view19)).setProgress(vaule19);
            ((VerticalProgressbar) findViewById(R.id.layout_view19)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view20)) != null) {
            int vaule20 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[19] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view20)).setProgress(vaule20);
            ((VerticalProgressbar) findViewById(R.id.layout_view20)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view21)) != null) {
            int vaule21 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[20] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view21)).setProgress(vaule21);
            ((VerticalProgressbar) findViewById(R.id.layout_view21)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view22)) != null) {
            int vaule22 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[21] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view22)).setProgress(vaule22);
            ((VerticalProgressbar) findViewById(R.id.layout_view22)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view23)) != null) {
            int vaule23 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[22] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view23)).setProgress(vaule23);
            ((VerticalProgressbar) findViewById(R.id.layout_view23)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view24)) != null) {
            int vaule24 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[23] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view24)).setProgress(vaule24);
            ((VerticalProgressbar) findViewById(R.id.layout_view24)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view25)) != null) {
            int vaule25 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[24] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view25)).setProgress(vaule25);
            ((VerticalProgressbar) findViewById(R.id.layout_view25)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view26)) != null) {
            int vaule26 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[25] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view26)).setProgress(vaule26);
            ((VerticalProgressbar) findViewById(R.id.layout_view26)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view27)) != null) {
            int vaule27 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[27] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view27)).setProgress(vaule27);
            ((VerticalProgressbar) findViewById(R.id.layout_view27)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view28)) != null) {
            int vaule28 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[27] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view28)).setProgress(vaule28);
            ((VerticalProgressbar) findViewById(R.id.layout_view28)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view29)) != null) {
            int vaule29 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[28] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view29)).setProgress(vaule29);
            ((VerticalProgressbar) findViewById(R.id.layout_view29)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view30)) != null) {
            int vaule30 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[29] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view30)).setProgress(vaule30);
            ((VerticalProgressbar) findViewById(R.id.layout_view30)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view31)) != null) {
            int vaule31 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[30] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view31)).setProgress(vaule31);
            ((VerticalProgressbar) findViewById(R.id.layout_view31)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view32)) != null) {
            int vaule32 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[31] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view32)).setProgress(vaule32);
            ((VerticalProgressbar) findViewById(R.id.layout_view32)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view33)) != null) {
            int vaule33 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[32] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view33)).setProgress(vaule33);
            ((VerticalProgressbar) findViewById(R.id.layout_view33)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view34)) != null) {
            int vaule34 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[33] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view34)).setProgress(vaule34);
            ((VerticalProgressbar) findViewById(R.id.layout_view34)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view35)) != null) {
            int vaule35 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[34] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view35)).setProgress(vaule35);
            ((VerticalProgressbar) findViewById(R.id.layout_view35)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view36)) != null) {
            int vaule36 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[35] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view36)).setProgress(vaule36);
            ((VerticalProgressbar) findViewById(R.id.layout_view36)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view37)) != null) {
            int vaule37 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[36] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view37)).setProgress(vaule37);
            ((VerticalProgressbar) findViewById(R.id.layout_view37)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view38)) != null) {
            int vaule38 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[37] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view38)).setProgress(vaule38);
            ((VerticalProgressbar) findViewById(R.id.layout_view38)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view39)) != null) {
            int vaule39 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[38] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view39)).setProgress(vaule39);
            ((VerticalProgressbar) findViewById(R.id.layout_view39)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view40)) != null) {
            int vaule40 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[39] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view40)).setProgress(vaule40);
            ((VerticalProgressbar) findViewById(R.id.layout_view40)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view41)) != null) {
            int vaule41 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[40] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view41)).setProgress(vaule41);
            ((VerticalProgressbar) findViewById(R.id.layout_view41)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view42)) != null) {
            int vaule42 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[41] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view42)).setProgress(vaule42);
            ((VerticalProgressbar) findViewById(R.id.layout_view42)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view43)) != null) {
            int vaule43 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[42] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view43)).setProgress(vaule43);
            ((VerticalProgressbar) findViewById(R.id.layout_view43)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view44)) != null) {
            int vaule44 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[43] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view44)).setProgress(vaule44);
            ((VerticalProgressbar) findViewById(R.id.layout_view44)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view45)) != null) {
            int vaule45 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[44] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view45)).setProgress(vaule45);
            ((VerticalProgressbar) findViewById(R.id.layout_view45)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view46)) != null) {
            int vaule46 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[45] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view46)).setProgress(vaule46);
            ((VerticalProgressbar) findViewById(R.id.layout_view46)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view47)) != null) {
            int vaule47 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[46] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view47)).setProgress(vaule47);
            ((VerticalProgressbar) findViewById(R.id.layout_view47)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view48)) != null) {
            int vaule48 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[47] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view48)).setProgress(vaule48);
            ((VerticalProgressbar) findViewById(R.id.layout_view48)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view49)) != null) {
            int vaule49 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[48] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view49)).setProgress(vaule49);
            ((VerticalProgressbar) findViewById(R.id.layout_view49)).invalidate();
        }
        if (((VerticalProgressbar) findViewById(R.id.layout_view50)) != null) {
            int vaule50 = (Callback_0273_RZC_XP1_MingJueRuiTeng.U_CARINFO_ENERGEY_LIST[49] * 30) / 125;
            ((VerticalProgressbar) findViewById(R.id.layout_view50)).setProgress(vaule50);
            ((VerticalProgressbar) findViewById(R.id.layout_view50)).invalidate();
        }
    }
}
