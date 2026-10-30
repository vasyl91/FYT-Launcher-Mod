package com.syu.carinfo.rzc.biaozhi408;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZC_BZ408AlarmRecordActi extends BaseActivity {
    public static RZC_BZ408AlarmRecordActi mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408AlarmRecordActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 114:
                    RZC_BZ408AlarmRecordActi.this.mUpdaterValue1();
                    break;
                case 145:
                    RZC_BZ408AlarmRecordActi.this.mUpdaterValue2();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_biaozhi408_alarm_record);
        mInstance = this;
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[114];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_0);
                break;
            case 1:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_3);
                break;
            case 4:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_4);
                break;
            case 5:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_5);
                break;
            case 6:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_6);
                break;
            case 7:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_7);
                break;
            case 8:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_8);
                break;
            case 9:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_9);
                break;
            case 10:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_a);
                break;
            case 11:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_b);
                break;
            case 12:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_c);
                break;
            case 13:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_d);
                break;
            case 14:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_e);
                break;
            case 15:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_f);
                break;
            case 16:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_10);
                break;
            case 17:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_11);
                break;
            case 18:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_12);
                break;
            case 19:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_13);
                break;
            case 20:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_14);
                break;
            case 21:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_15);
                break;
            case 22:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_16);
                break;
            case 23:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_17);
                break;
            case 24:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_18);
                break;
            case 25:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_19);
                break;
            case 26:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_1a);
                break;
            case 27:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_1b);
                break;
            case 28:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_1c);
                break;
            case 29:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_1d);
                break;
            case 30:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_1e);
                break;
            case 31:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_1f);
                break;
            case 32:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_20);
                break;
            case 33:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_21);
                break;
            case 34:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_22);
                break;
            case 35:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_23);
                break;
            case 36:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_24);
                break;
            case 37:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_25);
                break;
            case 38:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_26);
                break;
            case 39:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_27);
                break;
            case 40:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_28);
                break;
            case 41:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_29);
                break;
            case 42:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_2a);
                break;
            case 43:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_2b);
                break;
            case 44:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_2c);
                break;
            case 45:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_2d);
                break;
            case 46:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_2e);
                break;
            case 47:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_2f);
                break;
            case 48:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_30);
                break;
            case 49:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_31);
                break;
            case 50:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_32);
                break;
            case 51:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_33);
                break;
            case 52:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_34);
                break;
            case 53:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_35);
                break;
            case 54:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_36);
                break;
            case 55:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_37);
                break;
            case 56:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_38);
                break;
            case 57:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_39);
                break;
            case 58:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_3a);
                break;
            case 59:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_3b);
                break;
            case 60:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_3c);
                break;
            case 61:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_3d);
                break;
            case 62:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_3e);
                break;
            case 63:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_3f);
                break;
            case 64:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_40);
                break;
            case 65:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_41);
                break;
            case 66:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_42);
                break;
            case 67:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_43);
                break;
            case 68:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_44);
                break;
            case 69:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_45);
                break;
            case 70:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_46);
                break;
            case 71:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_47);
                break;
            case 72:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_48);
                break;
            case 73:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_49);
                break;
            case 74:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_4a);
                break;
            case 75:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_4b);
                break;
            case 76:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_4c);
                break;
            case 77:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_4d);
                break;
            case 78:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_4e);
                break;
            case 79:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_4f);
                break;
            case 80:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_50);
                break;
            case 81:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_51);
                break;
            case 82:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_52);
                break;
            case 240:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_f0);
                break;
            case 255:
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setText(R.string.rzc_bz408_warning_ff);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[145];
        if (((TextView) findViewById(R.id.rzc_bz408_tv_alarm)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setVisibility(8);
            } else {
                ((TextView) findViewById(R.id.rzc_bz408_tv_alarm)).setVisibility(0);
            }
        }
    }
}
