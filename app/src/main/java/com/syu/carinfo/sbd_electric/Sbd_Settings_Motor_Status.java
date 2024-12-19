package com.syu.carinfo.sbd_electric;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Sbd_Settings_Motor_Status extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.sbd_electric.Sbd_Settings_Motor_Status.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 6:
                    Sbd_Settings_Motor_Status.this.mUpdatersetshow1();
                    break;
                case 7:
                    Sbd_Settings_Motor_Status.this.mUpdatersetshow2();
                    break;
                case 8:
                    Sbd_Settings_Motor_Status.this.mUpdatersetshow3();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_313_electric_motor_status);
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

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow1() {
        int value = DataCanbus.DATA[6];
        if (((TextView) findViewById(R.id.Sbd_313_motor1)) != null) {
            ((TextView) findViewById(R.id.Sbd_313_motor1)).setText(String.format(String.valueOf(getString(R.string.setting_313_tv1str)) + "：   " + (value / 10.0f) + "V", new Object[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow2() {
        int value = DataCanbus.DATA[7];
        if (((TextView) findViewById(R.id.Sbd_313_motor2)) != null) {
            ((TextView) findViewById(R.id.Sbd_313_motor2)).setText(String.format(String.valueOf(getString(R.string.setting_313_motor2bstr)) + "：   " + (value / 10.0f) + "A", new Object[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow3() {
        int value = DataCanbus.DATA[8];
        if (((TextView) findViewById(R.id.Sbd_313_motor3)) != null) {
            ((TextView) findViewById(R.id.Sbd_313_motor3)).setText(String.format(String.valueOf(getString(R.string.setting_313_motor3bstr)) + "：   " + (value / 10.0f) + "℃", new Object[0]));
        }
    }
}
