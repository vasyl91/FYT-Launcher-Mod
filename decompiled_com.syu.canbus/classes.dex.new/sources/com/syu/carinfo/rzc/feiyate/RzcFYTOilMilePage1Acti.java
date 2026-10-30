package com.syu.carinfo.rzc.feiyate;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RzcFYTOilMilePage1Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.feiyate.RzcFYTOilMilePage1Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 100:
                case 117:
                    RzcFYTOilMilePage1Acti.this.mUpdaterOilExpend();
                    break;
                case 101:
                case 116:
                    RzcFYTOilMilePage1Acti.this.mUpdaterDivedMile();
                    break;
                case 148:
                    switch (value) {
                        case 0:
                            ((TextView) RzcFYTOilMilePage1Acti.this.findViewById(R.id.tv_text4)).setText(R.string.str_oil_driven);
                            break;
                        case 1:
                            ((TextView) RzcFYTOilMilePage1Acti.this.findViewById(R.id.tv_text4)).setText(R.string.str_electric_driven);
                            break;
                        case 2:
                            ((TextView) RzcFYTOilMilePage1Acti.this.findViewById(R.id.tv_text4)).setText(R.string.charging);
                            break;
                        case 3:
                            ((TextView) RzcFYTOilMilePage1Acti.this.findViewById(R.id.tv_text4)).setText(R.string.str_oil_electric_hybrid);
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_fyt_all_oil_page);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZCexc_Feiyate_PANDAEV_L /* 3342375 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_PANDAEV_M /* 3407911 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_PANDAEV_H /* 3473447 */:
                findViewById(R.id.tv_text4).setVisibility(0);
                break;
            default:
                findViewById(R.id.tv_text4).setVisibility(8);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{80, 0}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilExpend() {
        int value = DataCanbus.DATA[117];
        int value1 = DataCanbus.DATA[100] & 255;
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.tv_text1)).setText("--.--");
            }
            switch (value1) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "km/l");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "L/100KM");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "mpg(uk)");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "mpg(us)");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDivedMile() {
        int value = DataCanbus.DATA[116];
        int unit = DataCanbus.DATA[101];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.tv_text2)).setText("----");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " KM");
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " Mil");
            }
        }
    }
}
