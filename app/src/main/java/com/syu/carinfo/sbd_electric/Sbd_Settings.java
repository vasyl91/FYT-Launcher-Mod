package com.syu.carinfo.sbd_electric;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Sbd_Settings extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.sbd_electric.Sbd_Settings.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 4:
                    Sbd_Settings.this.mUpdaterDistance();
                    break;
                case 6:
                    Sbd_Settings.this.mUpdatersetshow1();
                    break;
                case 11:
                    Sbd_Settings.this.mUpdatersetshow2();
                    break;
                case 14:
                    Sbd_Settings.this.mUpdatersetshow3();
                    break;
                case 15:
                    Sbd_Settings.this.mUpdatersetshow4();
                    break;
                case 20:
                    Sbd_Settings.this.mUpdatersetshow6();
                    break;
                case 21:
                    Sbd_Settings.this.mUpdatersetshow7();
                    break;
                case 22:
                    Sbd_Settings.this.mUpdatersetshow8();
                    break;
                case 23:
                    Sbd_Settings.this.mUpdatersetshow9();
                    break;
                case 30:
                    Sbd_Settings.this.mUpdatersetshow5();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_313_carsetting);
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
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow1() {
        int value = DataCanbus.DATA[6];
        if (((TextView) findViewById(R.id.setting_313_tv1)) != null) {
            ((TextView) findViewById(R.id.setting_313_tv1)).setText((value / 10) + "." + (value % 10) + "V");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow2() {
        int value = DataCanbus.DATA[11];
        if (((TextView) findViewById(R.id.setting_313_tv2)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.setting_313_tv2)).setText(R.string.normal);
            } else {
                ((TextView) findViewById(R.id.setting_313_tv2)).setText(R.string.setting_313_tv51str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow3() {
        int value = DataCanbus.DATA[14];
        if (((TextView) findViewById(R.id.setting_313_tv3)) != null) {
            ((TextView) findViewById(R.id.setting_313_tv3)).setText((value / 10) + "." + (value % 10) + "V");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow4() {
        int value = DataCanbus.DATA[15];
        if (((TextView) findViewById(R.id.setting_313_tv4)) != null) {
            ((TextView) findViewById(R.id.setting_313_tv4)).setText((value / 10) + "." + (value % 10) + "A");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow5() {
        int value = DataCanbus.DATA[30];
        if (((TextView) findViewById(R.id.setting_313_tv5)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.setting_313_tv5)).setText(R.string.normal);
            } else {
                ((TextView) findViewById(R.id.setting_313_tv5)).setText(R.string.setting_313_tv51str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow6() {
        int value = DataCanbus.DATA[20];
        if (((TextView) findViewById(R.id.setting_313_tv6)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.setting_313_tv6)).setText(R.string.setting_313_tv61str);
            } else {
                ((TextView) findViewById(R.id.setting_313_tv6)).setText(R.string.setting_313_tv62str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow7() {
        int value = DataCanbus.DATA[21];
        if (((TextView) findViewById(R.id.setting_313_tv7)) != null) {
            ((TextView) findViewById(R.id.setting_313_tv7)).setText((value / 10) + "." + (value % 10) + "V");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow8() {
        int value = DataCanbus.DATA[22];
        if (((TextView) findViewById(R.id.setting_313_tv8)) != null) {
            ((TextView) findViewById(R.id.setting_313_tv8)).setText((value / 10) + "." + (value % 10) + "A");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow9() {
        int value = DataCanbus.DATA[23];
        if (((TextView) findViewById(R.id.setting_313_tv9)) != null) {
            ((TextView) findViewById(R.id.setting_313_tv9)).setText(value + "%");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDistance() {
        int value = DataCanbus.DATA[4];
        if (((TextView) findViewById(R.id.setting_313_tv10)) != null) {
            ((TextView) findViewById(R.id.setting_313_tv10)).setText(String.format(String.valueOf(getString(R.string.setting_313_tv10str)) + value + " KM", new Object[0]));
        }
    }
}
