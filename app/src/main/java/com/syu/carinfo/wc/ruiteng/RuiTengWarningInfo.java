package com.syu.carinfo.wc.ruiteng;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RuiTengWarningInfo extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengWarningInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 87:
                    RuiTengWarningInfo.this.mUpdaterValue1();
                    break;
                case 88:
                    RuiTengWarningInfo.this.mUpdaterValue2();
                    break;
                case 89:
                    RuiTengWarningInfo.this.mUpdaterValue3();
                    break;
                case 90:
                    RuiTengWarningInfo.this.mUpdaterValue4();
                    break;
                case 91:
                    RuiTengWarningInfo.this.mUpdaterValue5();
                    break;
                case 92:
                    RuiTengWarningInfo.this.mUpdaterValue6();
                    break;
                case 93:
                    RuiTengWarningInfo.this.mUpdaterValue7();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_ruiteng_warning_info);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[87];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_1)).setText(R.string.wc_ruiteng_string_warning_info_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_1)).setText(R.string.wc_ruiteng_string_warning_info_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_1)).setText(R.string.wc_ruiteng_string_warning_info_3);
                break;
            case 4:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_1)).setText(R.string.wc_ruiteng_string_warning_info_4);
                break;
            case 5:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_1)).setText(R.string.wc_ruiteng_string_warning_info_5);
                break;
            case 6:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_1)).setText(R.string.wc_ruiteng_string_warning_info_6);
                break;
            case 7:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_1)).setText(R.string.wc_ruiteng_string_warning_info_7);
                break;
            default:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_1)).setText("");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[88];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_2)).setText(R.string.wc_ruiteng_string_warning_info_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_2)).setText(R.string.wc_ruiteng_string_warning_info_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_2)).setText(R.string.wc_ruiteng_string_warning_info_3);
                break;
            case 4:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_2)).setText(R.string.wc_ruiteng_string_warning_info_4);
                break;
            case 5:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_2)).setText(R.string.wc_ruiteng_string_warning_info_5);
                break;
            case 6:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_2)).setText(R.string.wc_ruiteng_string_warning_info_6);
                break;
            case 7:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_2)).setText(R.string.wc_ruiteng_string_warning_info_7);
                break;
            default:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_2)).setText("");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[89];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_3)).setText(R.string.wc_ruiteng_string_warning_info_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_3)).setText(R.string.wc_ruiteng_string_warning_info_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_3)).setText(R.string.wc_ruiteng_string_warning_info_3);
                break;
            case 4:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_3)).setText(R.string.wc_ruiteng_string_warning_info_4);
                break;
            case 5:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_3)).setText(R.string.wc_ruiteng_string_warning_info_5);
                break;
            case 6:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_3)).setText(R.string.wc_ruiteng_string_warning_info_6);
                break;
            case 7:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_3)).setText(R.string.wc_ruiteng_string_warning_info_7);
                break;
            default:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_3)).setText("");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[90];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_4)).setText(R.string.wc_ruiteng_string_warning_info_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_4)).setText(R.string.wc_ruiteng_string_warning_info_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_4)).setText(R.string.wc_ruiteng_string_warning_info_3);
                break;
            case 4:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_4)).setText(R.string.wc_ruiteng_string_warning_info_4);
                break;
            case 5:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_4)).setText(R.string.wc_ruiteng_string_warning_info_5);
                break;
            case 6:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_4)).setText(R.string.wc_ruiteng_string_warning_info_6);
                break;
            case 7:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_4)).setText(R.string.wc_ruiteng_string_warning_info_7);
                break;
            default:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_4)).setText("");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue5() {
        int value = DataCanbus.DATA[91];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_5)).setText(R.string.wc_ruiteng_string_warning_info_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_5)).setText(R.string.wc_ruiteng_string_warning_info_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_5)).setText(R.string.wc_ruiteng_string_warning_info_3);
                break;
            case 4:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_5)).setText(R.string.wc_ruiteng_string_warning_info_4);
                break;
            case 5:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_5)).setText(R.string.wc_ruiteng_string_warning_info_5);
                break;
            case 6:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_5)).setText(R.string.wc_ruiteng_string_warning_info_6);
                break;
            case 7:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_5)).setText(R.string.wc_ruiteng_string_warning_info_7);
                break;
            default:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_5)).setText("");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue6() {
        int value = DataCanbus.DATA[92];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_6)).setText(R.string.wc_ruiteng_string_warning_info_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_6)).setText(R.string.wc_ruiteng_string_warning_info_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_6)).setText(R.string.wc_ruiteng_string_warning_info_3);
                break;
            case 4:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_6)).setText(R.string.wc_ruiteng_string_warning_info_4);
                break;
            case 5:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_6)).setText(R.string.wc_ruiteng_string_warning_info_5);
                break;
            case 6:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_6)).setText(R.string.wc_ruiteng_string_warning_info_6);
                break;
            case 7:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_6)).setText(R.string.wc_ruiteng_string_warning_info_7);
                break;
            default:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_6)).setText("");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue7() {
        int value = DataCanbus.DATA[93];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_7)).setText(R.string.wc_ruiteng_string_warning_info_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_7)).setText(R.string.wc_ruiteng_string_warning_info_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_7)).setText(R.string.wc_ruiteng_string_warning_info_3);
                break;
            case 4:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_7)).setText(R.string.wc_ruiteng_string_warning_info_4);
                break;
            case 5:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_7)).setText(R.string.wc_ruiteng_string_warning_info_5);
                break;
            case 6:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_7)).setText(R.string.wc_ruiteng_string_warning_info_6);
                break;
            case 7:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_7)).setText(R.string.wc_ruiteng_string_warning_info_7);
                break;
            default:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_7)).setText("");
                break;
        }
    }
}
