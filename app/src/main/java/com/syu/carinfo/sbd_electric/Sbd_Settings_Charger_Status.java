package com.syu.carinfo.sbd_electric;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Sbd_Settings_Charger_Status extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.sbd_electric.Sbd_Settings_Charger_Status.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 9:
                    Sbd_Settings_Charger_Status.this.mUpdatersetshow1();
                    break;
                case 10:
                    Sbd_Settings_Charger_Status.this.mUpdatersetshow2();
                    break;
                case 11:
                    Sbd_Settings_Charger_Status.this.mUpdatersetshow3();
                    break;
                case 12:
                    Sbd_Settings_Charger_Status.this.mUpdatersetshow4();
                    break;
                case 13:
                    Sbd_Settings_Charger_Status.this.mUpdatersetshow5();
                    break;
                case 14:
                    Sbd_Settings_Charger_Status.this.mUpdatersetshow6();
                    break;
                case 15:
                    Sbd_Settings_Charger_Status.this.mUpdatersetshow7();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_313_electric_charge);
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
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow1() {
        int value = DataCanbus.DATA[9];
        if (((TextView) findViewById(R.id.Sbd_313_charge1)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_charge1)).setText(String.format(String.valueOf(getString(R.string.setting_313_charge1bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_charge1)).setText(String.format(String.valueOf(getString(R.string.setting_313_charge1bstr)) + getString(R.string.setting_313_charge12bstr), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow2() {
        int value = DataCanbus.DATA[10];
        if (((TextView) findViewById(R.id.Sbd_313_charge2)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_charge2)).setText(String.format(String.valueOf(getString(R.string.setting_313_charge2bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_charge2)).setText(String.format(String.valueOf(getString(R.string.setting_313_charge2bstr)) + getString(R.string.setting_313_charge22bstr), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow3() {
        int value = DataCanbus.DATA[11];
        if (((TextView) findViewById(R.id.Sbd_313_charge3)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_charge3)).setText(String.format(String.valueOf(getString(R.string.setting_313_tv2str)) + "：   " + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_charge3)).setText(String.format(String.valueOf(getString(R.string.setting_313_tv2str)) + "：   " + getString(R.string.setting_313_charge32bstr), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow4() {
        int value = DataCanbus.DATA[12];
        if (((TextView) findViewById(R.id.Sbd_313_charge4)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_charge4)).setText(String.format(String.valueOf(getString(R.string.setting_313_charge4bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_charge4)).setText(String.format(String.valueOf(getString(R.string.setting_313_charge4bstr)) + getString(R.string.setting_313_charge42bstr), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow5() {
        int value = DataCanbus.DATA[13];
        if (((TextView) findViewById(R.id.Sbd_313_charge5)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_charge5)).setText(String.format(String.valueOf(getString(R.string.setting_313_charge5bstr)) + getString(R.string.normal), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_charge5)).setText(String.format(String.valueOf(getString(R.string.setting_313_charge5bstr)) + getString(R.string.setting_313_charge52bstr), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow6() {
        int value = DataCanbus.DATA[14];
        if (((TextView) findViewById(R.id.Sbd_313_charge6)) != null) {
            ((TextView) findViewById(R.id.Sbd_313_charge6)).setText(String.format(String.valueOf(getString(R.string.setting_313_tv3str)) + "：   " + (value / 10.0f) + "V", new Object[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow7() {
        int value = DataCanbus.DATA[15];
        if (((TextView) findViewById(R.id.Sbd_313_charge7)) != null) {
            ((TextView) findViewById(R.id.Sbd_313_charge7)).setText(String.format(String.valueOf(getString(R.string.setting_313_tv4str)) + "：   " + (value / 10.0f) + "A", new Object[0]));
        }
    }
}
