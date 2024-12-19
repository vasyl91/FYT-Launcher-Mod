package com.syu.carinfo.wc.leinuo;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class DusterOilMilePage1Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.leinuo.DusterOilMilePage1Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 87:
                    DusterOilMilePage1Acti.this.mUpdaterOilExpend();
                    break;
                case 88:
                    break;
                default:
                    return;
            }
            DusterOilMilePage1Acti.this.mUpdaterDrivingMileage();
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_duster_all_oil_page1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilExpend() {
        int value = DataCanbus.DATA[87];
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)) != null) {
            if (value == 255) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)).setText("--.--");
            } else {
                if ((value & 128) != 0) {
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)).setText("L-title-" + (value - 128));
                    return;
                }
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv1)).setText("R-title-" + value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[88];
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv2)) != null) {
            if (value == 255) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv2)).setText("--.--");
                return;
            }
            if (((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv2)) != null) {
                if (value == 255) {
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv2)).setText("--.--");
                } else {
                    if ((value & 128) != 0) {
                        ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv2)).setText("F-title-" + (value - 128));
                        return;
                    }
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page1_tv2)).setText("R-title-" + value);
                }
            }
        }
    }
}
