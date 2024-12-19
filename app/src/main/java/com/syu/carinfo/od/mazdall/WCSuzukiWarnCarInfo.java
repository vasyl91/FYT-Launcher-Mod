package com.syu.carinfo.od.mazdall;

import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WCSuzukiWarnCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.mazdall.WCSuzukiWarnCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 146:
                    WCSuzukiWarnCarInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(value == 1 ? R.drawable.ic_suzuki_warn1_p : R.drawable.ic_suzuki_warn1_n);
                    break;
                case 147:
                    WCSuzukiWarnCarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(value == 1 ? R.drawable.ic_suzuki_warn2_p : R.drawable.ic_suzuki_warn2_n);
                    break;
                case 148:
                    WCSuzukiWarnCarInfo.this.findViewById(R.id.layout_view3).setBackgroundResource(value == 1 ? R.drawable.ic_suzuki_warn3_p : R.drawable.ic_suzuki_warn3_n);
                    break;
                case 149:
                    WCSuzukiWarnCarInfo.this.findViewById(R.id.layout_view4).setBackgroundResource(value == 1 ? R.drawable.ic_suzuki_warn4_p : R.drawable.ic_suzuki_warn4_n);
                    break;
                case 150:
                    WCSuzukiWarnCarInfo.this.findViewById(R.id.layout_view5).setBackgroundResource(value == 1 ? R.drawable.ic_suzuki_warn5_p : R.drawable.ic_suzuki_warn5_n);
                    break;
                case 151:
                    WCSuzukiWarnCarInfo.this.findViewById(R.id.layout_view6).setBackgroundResource(value == 1 ? R.drawable.ic_suzuki_warn6_p : R.drawable.ic_suzuki_warn6_n);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_suzuki_warn_carinfo);
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
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
    }
}
