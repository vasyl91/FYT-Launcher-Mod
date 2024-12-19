package com.syu.carinfo.xbs.tule;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XBSTuleHistoryActDZSJ extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.tule.XBSTuleHistoryActDZSJ.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 29:
                    if (value >= 32768) {
                        ((TextView) XBSTuleHistoryActDZSJ.this.findViewById(R.id.xbs_tule_distamce_empty_tv)).setText(R.string.str_oil_signal_low);
                        break;
                    } else {
                        ((TextView) XBSTuleHistoryActDZSJ.this.findViewById(R.id.xbs_tule_distamce_empty_tv)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 30:
                    if (value == 65535) {
                        ((TextView) XBSTuleHistoryActDZSJ.this.findViewById(R.id.xbs_tule_oil_tv)).setText("----");
                        break;
                    } else {
                        ((TextView) XBSTuleHistoryActDZSJ.this.findViewById(R.id.xbs_tule_oil_tv)).setText(String.valueOf(value / 10) + "." + (value % 10));
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xbs_tule_dzsj_history);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
    }
}
