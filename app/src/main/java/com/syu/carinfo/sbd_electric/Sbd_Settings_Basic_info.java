package com.syu.carinfo.sbd_electric;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Sbd_Settings_Basic_info extends BaseActivity {
    private static int[] WarID = {R.string.crv_source_null, R.string.setting_313_basic61str, R.string.setting_313_basic62str, R.string.setting_313_basic63str, R.string.setting_313_basic64str, R.string.setting_313_basic65str, R.string.setting_313_basic66str, R.string.crv_source_null, R.string.setting_313_basic67str, R.string.setting_313_basic68str, R.string.setting_313_basic69str, R.string.setting_313_basic6astr, R.string.crv_source_null, R.string.setting_313_basic6bstr};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.sbd_electric.Sbd_Settings_Basic_info.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    Sbd_Settings_Basic_info.this.mUpdatersetshow1();
                    break;
                case 2:
                    Sbd_Settings_Basic_info.this.mUpdatersetshow3();
                    break;
                case 3:
                    Sbd_Settings_Basic_info.this.mUpdatersetshow4();
                    break;
                case 4:
                    Sbd_Settings_Basic_info.this.mUpdatersetshow5();
                    break;
                case 5:
                    Sbd_Settings_Basic_info.this.mUpdatersetshow6();
                    break;
                case 39:
                    Sbd_Settings_Basic_info.this.mUpdatersetshow2();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_313_electric_basic_info);
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
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow1() {
        int value = DataCanbus.DATA[0];
        if (((TextView) findViewById(R.id.Sbd_313_bsaic1)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_bsaic1)).setText(String.format(String.valueOf(getString(R.string.setting_313_basic1str)) + getString(R.string.setting_313_basic11str), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_bsaic1)).setText(String.format(String.valueOf(getString(R.string.setting_313_basic1str)) + getString(R.string.setting_313_basic12str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow2() {
        int value = DataCanbus.DATA[39];
        if (((TextView) findViewById(R.id.Sbd_313_bsaic2)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.Sbd_313_bsaic2)).setText(String.format(String.valueOf(getString(R.string.setting_313_basic2str)) + getString(R.string.setting_313_basic21str), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_bsaic2)).setText(String.format(String.valueOf(getString(R.string.setting_313_basic2str)) + getString(R.string.setting_313_basic22str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow3() {
        int value = DataCanbus.DATA[2];
        if (((TextView) findViewById(R.id.Sbd_313_bsaic3)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.Sbd_313_bsaic3)).setText(String.format(String.valueOf(getString(R.string.setting_313_basic3str)) + getString(R.string.setting_313_basic32str), new Object[0]));
            } else if (value == 2) {
                ((TextView) findViewById(R.id.Sbd_313_bsaic3)).setText(String.format(String.valueOf(getString(R.string.setting_313_basic3str)) + getString(R.string.setting_313_basic33str), new Object[0]));
            } else {
                ((TextView) findViewById(R.id.Sbd_313_bsaic3)).setText(String.format(String.valueOf(getString(R.string.setting_313_basic3str)) + getString(R.string.setting_313_basic31str), new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow4() {
        int value = DataCanbus.DATA[3];
        if (((TextView) findViewById(R.id.Sbd_313_bsaic4)) != null) {
            ((TextView) findViewById(R.id.Sbd_313_bsaic4)).setText(String.format(String.valueOf(getString(R.string.setting_313_basic4str)) + value + " RPM", new Object[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow5() {
        int value = DataCanbus.DATA[4];
        if (((TextView) findViewById(R.id.Sbd_313_bsaic5)) != null) {
            ((TextView) findViewById(R.id.Sbd_313_bsaic5)).setText(String.format(String.valueOf(getString(R.string.setting_313_tv10str)) + value + " KM", new Object[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatersetshow6() {
        int value = DataCanbus.DATA[5];
        if (((TextView) findViewById(R.id.Sbd_313_bsaic6)) != null && value <= 13) {
            ((TextView) findViewById(R.id.Sbd_313_bsaic6)).setText(String.format(String.valueOf(getString(R.string.setting_313_basic6str)) + getString(WarID[value]), new Object[0]));
        }
    }
}
