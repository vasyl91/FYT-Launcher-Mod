package com.syu.carinfo.rzc.biaozhi408;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZC_BZ408EVMilePage4Acti extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408EVMilePage4Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 297:
                    RZC_BZ408EVMilePage4Acti.this.setCheck((CheckedTextView) RZC_BZ408EVMilePage4Acti.this.findViewById(R.id.ctv_checkedtext1), ((value >> 7) & 1) == 1);
                    switch (value & 3) {
                        case 0:
                            ((TextView) RZC_BZ408EVMilePage4Acti.this.findViewById(R.id.tv_text1)).setText("10km");
                            break;
                        case 1:
                            ((TextView) RZC_BZ408EVMilePage4Acti.this.findViewById(R.id.tv_text1)).setText("20km");
                            break;
                        case 2:
                            ((TextView) RZC_BZ408EVMilePage4Acti.this.findViewById(R.id.tv_text1)).setText("MAX");
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0339_rzc_psa_ev4_carinfo);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int bit7 = (DataCanbus.DATA[297] >> 7) & 1;
                int bit10 = (DataCanbus.DATA[297] & 3) - 1;
                if (bit10 < 0) {
                    bit10 = 2;
                }
                DataCanbus.PROXY.cmd(100, new int[]{2, bit7, bit10}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int bit8 = (DataCanbus.DATA[297] >> 7) & 1;
                int bit11 = (DataCanbus.DATA[297] & 3) + 1;
                if (bit11 > 2) {
                    bit11 = 0;
                }
                DataCanbus.PROXY.cmd(100, new int[]{2, bit8, bit11}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int bit9 = (DataCanbus.DATA[297] >> 7) & 1;
                int bit12 = DataCanbus.DATA[297] & 3;
                if (bit9 == 1) {
                    bit9 = 0;
                } else if (bit9 == 0) {
                    bit9 = 1;
                }
                DataCanbus.PROXY.cmd(100, new int[]{2, bit9, bit12}, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(70, new int[]{83}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[297].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[297].removeNotify(this.mNotifyCanbus);
    }
}
