package com.syu.carinfo.wc.leinuo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class DusterOilMilePage2Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.leinuo.DusterOilMilePage2Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 101:
                    DusterOilMilePage2Acti.this.mUpdaterValue1();
                case 102:
                    DusterOilMilePage2Acti.this.mUpdaterValue2();
                case 103:
                    DusterOilMilePage2Acti.this.mUpdaterValue3();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_duster_all_oil_page2);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.psa_all_btn_oil_page2_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.leinuo.DusterOilMilePage2Acti.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{1}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[101];
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv1)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv1)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "L/100KM");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[102];
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv2)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv2)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv2)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " KM/H");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[103];
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv3)) != null) {
            if (value == 16777215) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv3)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv3)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " KM");
            }
        }
    }
}
