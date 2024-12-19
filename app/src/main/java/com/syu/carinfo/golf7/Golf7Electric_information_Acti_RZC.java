package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Golf7Electric_information_Acti_RZC extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7Electric_information_Acti_RZC.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 373:
                    ((TextView) Golf7Electric_information_Acti_RZC.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "km");
                    break;
                case 374:
                    ((TextView) Golf7Electric_information_Acti_RZC.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "km");
                    break;
                case 378:
                    ((TextView) Golf7Electric_information_Acti_RZC.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "/100");
                    break;
                case 379:
                    ((TextView) Golf7Electric_information_Acti_RZC.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "km");
                    break;
                case 380:
                    ((TextView) Golf7Electric_information_Acti_RZC.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "km");
                    break;
                case 381:
                    ((TextView) Golf7Electric_information_Acti_RZC.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "%");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0160_rzc_mqb_electric_carinfo);
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
        DataCanbus.NOTIFY_EVENTS[373].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[374].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[375].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[376].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[377].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[378].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[379].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[380].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[381].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[373].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[374].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[375].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[376].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[377].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[378].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[379].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[380].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[381].removeNotify(this.mNotifyCanbus);
    }
}
