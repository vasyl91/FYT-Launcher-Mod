package com.syu.carinfo.od.mazdall;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WCTataTripBCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.mazdall.WCTataTripBCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 122:
                    if (value % 10 == 0) {
                        ((TextView) WCTataTripBCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "/5");
                    } else {
                        ((TextView) WCTataTripBCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + "/5");
                    }
                    break;
                case 123:
                    if (value % 10 == 0) {
                        ((TextView) WCTataTripBCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "/5");
                    } else {
                        ((TextView) WCTataTripBCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + "/5");
                    }
                    break;
                case 124:
                    if (value % 10 == 0) {
                        ((TextView) WCTataTripBCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "/5");
                    } else {
                        ((TextView) WCTataTripBCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + "/5");
                    }
                    break;
                case 125:
                    if (value % 10 == 0) {
                        ((TextView) WCTataTripBCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "/5");
                    } else {
                        ((TextView) WCTataTripBCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + "/5");
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_tata_cur_carinfo);
        ((TextView) findViewById(R.id.tv_text5)).setText("Trip B");
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
    }
}
