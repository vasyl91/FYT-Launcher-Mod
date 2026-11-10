package com.syu.carinfo.rzc.biaozhi408;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZC_BZ408EVMilePage1Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408EVMilePage1Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 278:
                    switch (value) {
                        case 0:
                            ((TextView) RZC_BZ408EVMilePage1Acti.this.findViewById(R.id.tv_text1)).setText(R.string.driver_system_standard);
                            break;
                        case 1:
                            ((TextView) RZC_BZ408EVMilePage1Acti.this.findViewById(R.id.tv_text1)).setText(R.string.driver_system_sports);
                            break;
                        case 2:
                            ((TextView) RZC_BZ408EVMilePage1Acti.this.findViewById(R.id.tv_text1)).setText(R.string.wc_golf_comfort);
                            break;
                        case 3:
                            ((TextView) RZC_BZ408EVMilePage1Acti.this.findViewById(R.id.tv_text1)).setText(R.string.str_driving_eco);
                            break;
                        case 4:
                            ((TextView) RZC_BZ408EVMilePage1Acti.this.findViewById(R.id.tv_text1)).setText(R.string.str_sand);
                            break;
                        case 5:
                            ((TextView) RZC_BZ408EVMilePage1Acti.this.findViewById(R.id.tv_text1)).setText(R.string.str_mud_ruts);
                            break;
                        case 6:
                            ((TextView) RZC_BZ408EVMilePage1Acti.this.findViewById(R.id.tv_text1)).setText(R.string.str_grass_gravel_snow);
                            break;
                        case 7:
                            ((TextView) RZC_BZ408EVMilePage1Acti.this.findViewById(R.id.tv_text1)).setText("电动");
                            break;
                        case 8:
                            ((TextView) RZC_BZ408EVMilePage1Acti.this.findViewById(R.id.tv_text1)).setText("四驱");
                            break;
                        case 9:
                            ((TextView) RZC_BZ408EVMilePage1Acti.this.findViewById(R.id.tv_text1)).setText(R.string.str_e_hybird);
                            break;
                    }
                    break;
                case 279:
                    if (((value >> 7) & 1) == 1) {
                        ((TextView) RZC_BZ408EVMilePage1Acti.this.findViewById(R.id.tv_text2)).setText(R.string.klc_Parking_with_trailer_ON);
                    } else {
                        ((TextView) RZC_BZ408EVMilePage1Acti.this.findViewById(R.id.tv_text2)).setText(R.string.klc_Parking_with_trailer_Off);
                    }
                    if (((value >> 6) & 1) == 1) {
                        ((TextView) RZC_BZ408EVMilePage1Acti.this.findViewById(R.id.tv_text3)).setText(R.string.wc_psa_all_confirm);
                    } else {
                        ((TextView) RZC_BZ408EVMilePage1Acti.this.findViewById(R.id.tv_text3)).setText(R.string.wc_psa_all_cancel);
                    }
                    if (((value >> 5) & 1) == 1) {
                        ((TextView) RZC_BZ408EVMilePage1Acti.this.findViewById(R.id.tv_text4)).setText(R.string.wc_psa_all_confirm);
                    } else {
                        ((TextView) RZC_BZ408EVMilePage1Acti.this.findViewById(R.id.tv_text4)).setText(R.string.wc_psa_all_cancel);
                    }
                    if (((value >> 4) & 1) == 1) {
                        ((TextView) RZC_BZ408EVMilePage1Acti.this.findViewById(R.id.tv_text5)).setText(R.string.wc_psa_all_confirm);
                    } else {
                        ((TextView) RZC_BZ408EVMilePage1Acti.this.findViewById(R.id.tv_text5)).setText(R.string.wc_psa_all_cancel);
                    }
                    if (((value >> 3) & 1) == 1) {
                        ((TextView) RZC_BZ408EVMilePage1Acti.this.findViewById(R.id.tv_text6)).setText(R.string.wc_psa_all_confirm);
                    } else {
                        ((TextView) RZC_BZ408EVMilePage1Acti.this.findViewById(R.id.tv_text6)).setText(R.string.wc_psa_all_cancel);
                    }
                    if (((value >> 2) & 1) == 1) {
                        ((TextView) RZC_BZ408EVMilePage1Acti.this.findViewById(R.id.tv_text7)).setText(R.string.wc_psa_all_confirm);
                    } else {
                        ((TextView) RZC_BZ408EVMilePage1Acti.this.findViewById(R.id.tv_text7)).setText(R.string.wc_psa_all_cancel);
                    }
                    if (((value >> 1) & 1) == 1) {
                        ((TextView) RZC_BZ408EVMilePage1Acti.this.findViewById(R.id.tv_text8)).setText(R.string.wc_psa_all_confirm);
                    } else {
                        ((TextView) RZC_BZ408EVMilePage1Acti.this.findViewById(R.id.tv_text8)).setText(R.string.wc_psa_all_cancel);
                    }
                    if (((value >> 0) & 1) == 1) {
                        ((TextView) RZC_BZ408EVMilePage1Acti.this.findViewById(R.id.tv_text9)).setText(R.string.wc_psa_all_confirm);
                    } else {
                        ((TextView) RZC_BZ408EVMilePage1Acti.this.findViewById(R.id.tv_text9)).setText(R.string.wc_psa_all_cancel);
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0339_rzc_psa_ev1_carinfo);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(70, new int[]{80}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[278].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[279].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[278].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[279].removeNotify(this.mNotifyCanbus);
    }
}
