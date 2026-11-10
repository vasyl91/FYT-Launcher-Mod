package com.syu.carinfo.od.mazdall;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WCSuzukiCurrentCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.mazdall.WCSuzukiCurrentCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    if (value == 65535) {
                        ((TextView) WCSuzukiCurrentCarInfo.this.findViewById(R.id.tv_text1)).setText("----");
                    } else {
                        ((TextView) WCSuzukiCurrentCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/L");
                    }
                    break;
                case 100:
                    if (value == 65535) {
                        ((TextView) WCSuzukiCurrentCarInfo.this.findViewById(R.id.tv_text2)).setText("----");
                    } else {
                        ((TextView) WCSuzukiCurrentCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/L");
                    }
                    break;
                case 101:
                    if (value == 65535) {
                        ((TextView) WCSuzukiCurrentCarInfo.this.findViewById(R.id.tv_text3)).setText("----");
                    } else {
                        ((TextView) WCSuzukiCurrentCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/h");
                    }
                    break;
                case 102:
                    if (value == 65535) {
                        ((TextView) WCSuzukiCurrentCarInfo.this.findViewById(R.id.tv_text4)).setText("----");
                    } else {
                        ((TextView) WCSuzukiCurrentCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km");
                    }
                    break;
                case 103:
                    if (value == 16777215) {
                        ((TextView) WCSuzukiCurrentCarInfo.this.findViewById(R.id.tv_text5)).setText("----");
                    } else {
                        ((TextView) WCSuzukiCurrentCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km");
                    }
                    break;
                case 104:
                    int hour = (value >> 8) & 65535;
                    int min = value & 255;
                    if (value == 16777215) {
                        ((TextView) WCSuzukiCurrentCarInfo.this.findViewById(R.id.tv_text6)).setText("----");
                    } else {
                        ((TextView) WCSuzukiCurrentCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(hour / 10) + "H" + min + "M");
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_suzuki_cur_carinfo);
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
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
    }
}
