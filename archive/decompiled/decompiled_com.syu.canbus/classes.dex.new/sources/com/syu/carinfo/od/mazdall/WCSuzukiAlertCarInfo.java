package com.syu.carinfo.od.mazdall;

import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WCSuzukiAlertCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.mazdall.WCSuzukiAlertCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 151:
                    WCSuzukiAlertCarInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(value == 1 ? R.drawable.ic_suzuki_alert1_p : R.drawable.ic_suzuki_alert1_n);
                    break;
                case 152:
                    WCSuzukiAlertCarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(value == 1 ? R.drawable.ic_suzuki_alert2_p : R.drawable.ic_suzuki_alert2_n);
                    break;
                case 153:
                    WCSuzukiAlertCarInfo.this.findViewById(R.id.layout_view3).setBackgroundResource(value == 1 ? R.drawable.ic_suzuki_alert3_p : R.drawable.ic_suzuki_alert3_n);
                    break;
                case 154:
                    WCSuzukiAlertCarInfo.this.findViewById(R.id.layout_view4).setBackgroundResource(value == 1 ? R.drawable.ic_suzuki_alert4_p : R.drawable.ic_suzuki_alert4_n);
                    break;
                case 155:
                    WCSuzukiAlertCarInfo.this.findViewById(R.id.layout_view5).setBackgroundResource(value == 1 ? R.drawable.ic_suzuki_alert5_p : R.drawable.ic_suzuki_alert5_n);
                    break;
                case 156:
                    WCSuzukiAlertCarInfo.this.findViewById(R.id.layout_view6).setBackgroundResource(value == 1 ? R.drawable.ic_suzuki_alert6_p : R.drawable.ic_suzuki_alert6_n);
                    break;
                case 157:
                    WCSuzukiAlertCarInfo.this.findViewById(R.id.layout_view7).setBackgroundResource(value == 1 ? R.drawable.ic_suzuki_alert7_p : R.drawable.ic_suzuki_alert7_n);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_suzuki_alert_carinfo);
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
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
    }
}
