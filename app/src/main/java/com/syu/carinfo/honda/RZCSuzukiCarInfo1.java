package com.syu.carinfo.honda;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZCSuzukiCarInfo1 extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.RZCSuzukiCarInfo1.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 86:
                case 93:
                    int unit = DataCanbus.DATA[93];
                    int value = DataCanbus.DATA[86];
                    switch (unit) {
                        case 0:
                            ((TextView) RZCSuzukiCarInfo1.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " mpg");
                            break;
                        case 1:
                            ((TextView) RZCSuzukiCarInfo1.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " km/l");
                            break;
                        case 2:
                            ((TextView) RZCSuzukiCarInfo1.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " l/100km");
                            break;
                    }
                case 87:
                case 91:
                    int unit2 = DataCanbus.DATA[91];
                    int value2 = DataCanbus.DATA[87];
                    switch (unit2) {
                        case 0:
                            ((TextView) RZCSuzukiCarInfo1.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + " mpg");
                            break;
                        case 1:
                            ((TextView) RZCSuzukiCarInfo1.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + " km/l");
                            break;
                        case 2:
                            ((TextView) RZCSuzukiCarInfo1.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + " l/100km");
                            break;
                    }
                case 88:
                case 89:
                    int unit3 = DataCanbus.DATA[89];
                    int value3 = DataCanbus.DATA[88];
                    switch (unit3) {
                        case 0:
                            ((TextView) RZCSuzukiCarInfo1.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value3) + " km");
                            break;
                        case 1:
                            ((TextView) RZCSuzukiCarInfo1.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value3) + " mil");
                            break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_rzc_suzuki_carinfo1);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{51, 1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
    }
}
