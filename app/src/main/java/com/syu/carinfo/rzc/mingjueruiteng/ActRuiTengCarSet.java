package com.syu.carinfo.rzc.mingjueruiteng;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActRuiTengCarSet extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.mingjueruiteng.ActRuiTengCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 26:
                    ActRuiTengCarSet.this.mUpdaterValue0();
                    break;
                case 27:
                    ActRuiTengCarSet.this.mUpdaterValue1();
                    break;
                case 28:
                    ActRuiTengCarSet.this.mUpdaterValue2();
                    break;
                case 29:
                    ActRuiTengCarSet.this.mUpdaterValue3();
                    break;
                case 30:
                    ActRuiTengCarSet.this.mUpdaterValue4();
                    break;
                case 31:
                    ActRuiTengCarSet.this.mUpdaterValue5();
                    break;
                case 32:
                    ActRuiTengCarSet.this.mUpdaterValue6();
                    break;
                case 33:
                    ActRuiTengCarSet.this.mUpdaterValue7();
                    break;
                case 34:
                    ActRuiTengCarSet.this.mUpdaterValue8();
                    break;
                case 35:
                    ActRuiTengCarSet.this.mUpdaterValue9();
                    break;
                case 36:
                    ActRuiTengCarSet.this.mUpdaterValue10();
                    break;
                case 37:
                    ActRuiTengCarSet.this.mUpdaterValue11();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_rzc_ruiteng_car_set);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_speed_lock)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_auto_unlock)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_unlock_mode)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_unlock_nearcar)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_home_light_backcar)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_home_light_backlight)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_home_light_back_foglight)).setOnClickListener(this);
        ((Button) findViewById(R.id.rzc_ruiteng_home_light_time_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.rzc_ruiteng_home_light_time_next)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_find_light_backcar)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_find_light_back_light)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_find_light_back_fog_light)).setOnClickListener(this);
        ((Button) findViewById(R.id.rzc_ruiteng_find_light_time_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.rzc_ruiteng_find_light_time_next)).setOnClickListener(this);
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
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rzc_ruiteng_speed_lock /* 2131429037 */:
                int[] iArr = new int[3];
                iArr[0] = 1;
                iArr[1] = 1;
                iArr[2] = DataCanbus.DATA[26] != 0 ? 0 : 1;
                FunRuiTeng.C_CARINFO_SET(iArr);
                break;
            case R.id.rzc_ruiteng_auto_unlock /* 2131429038 */:
                int[] iArr2 = new int[3];
                iArr2[0] = 1;
                iArr2[1] = 2;
                iArr2[2] = DataCanbus.DATA[27] != 0 ? 0 : 1;
                FunRuiTeng.C_CARINFO_SET(iArr2);
                break;
            case R.id.rzc_ruiteng_unlock_mode /* 2131429040 */:
                int[] iArr3 = new int[3];
                iArr3[0] = 1;
                iArr3[1] = 3;
                iArr3[2] = DataCanbus.DATA[28] != 0 ? 0 : 1;
                FunRuiTeng.C_CARINFO_SET(iArr3);
                break;
            case R.id.rzc_ruiteng_unlock_nearcar /* 2131429042 */:
                int[] iArr4 = new int[3];
                iArr4[0] = 1;
                iArr4[1] = 4;
                iArr4[2] = DataCanbus.DATA[29] != 0 ? 0 : 1;
                FunRuiTeng.C_CARINFO_SET(iArr4);
                break;
            case R.id.rzc_ruiteng_home_light_backcar /* 2131429051 */:
                int[] iArr5 = new int[4];
                iArr5[0] = 2;
                iArr5[1] = 1;
                iArr5[2] = 1;
                iArr5[3] = DataCanbus.DATA[30] != 0 ? 0 : 1;
                FunRuiTeng.C_CARINFO_SET(iArr5);
                break;
            case R.id.rzc_ruiteng_home_light_backlight /* 2131432811 */:
                int[] iArr6 = new int[4];
                iArr6[0] = 2;
                iArr6[1] = 1;
                iArr6[2] = 2;
                iArr6[3] = DataCanbus.DATA[31] != 0 ? 0 : 1;
                FunRuiTeng.C_CARINFO_SET(iArr6);
                break;
            case R.id.rzc_ruiteng_home_light_back_foglight /* 2131432812 */:
                int[] iArr7 = new int[4];
                iArr7[0] = 2;
                iArr7[1] = 1;
                iArr7[2] = 3;
                iArr7[3] = DataCanbus.DATA[32] != 0 ? 0 : 1;
                FunRuiTeng.C_CARINFO_SET(iArr7);
                break;
            case R.id.rzc_ruiteng_home_light_time_pre /* 2131432813 */:
                int value = DataCanbus.DATA[33] - 1;
                FunRuiTeng.C_CARINFO_SET(2, 2, value);
                break;
            case R.id.rzc_ruiteng_home_light_time_next /* 2131432815 */:
                int value2 = DataCanbus.DATA[33] + 1;
                FunRuiTeng.C_CARINFO_SET(2, 2, value2);
                break;
            case R.id.rzc_ruiteng_find_light_backcar /* 2131432816 */:
                int[] iArr8 = new int[4];
                iArr8[0] = 2;
                iArr8[1] = 3;
                iArr8[2] = 1;
                iArr8[3] = DataCanbus.DATA[34] != 0 ? 0 : 1;
                FunRuiTeng.C_CARINFO_SET(iArr8);
                break;
            case R.id.rzc_ruiteng_find_light_back_light /* 2131432817 */:
                int[] iArr9 = new int[4];
                iArr9[0] = 2;
                iArr9[1] = 3;
                iArr9[2] = 2;
                iArr9[3] = DataCanbus.DATA[35] != 0 ? 0 : 1;
                FunRuiTeng.C_CARINFO_SET(iArr9);
                break;
            case R.id.rzc_ruiteng_find_light_back_fog_light /* 2131432818 */:
                int[] iArr10 = new int[4];
                iArr10[0] = 2;
                iArr10[1] = 3;
                iArr10[2] = 3;
                iArr10[3] = DataCanbus.DATA[36] != 0 ? 0 : 1;
                FunRuiTeng.C_CARINFO_SET(iArr10);
                break;
            case R.id.rzc_ruiteng_find_light_time_pre /* 2131432819 */:
                int value3 = DataCanbus.DATA[37] - 1;
                FunRuiTeng.C_CARINFO_SET(2, 4, value3);
                break;
            case R.id.rzc_ruiteng_find_light_time_next /* 2131432821 */:
                int value4 = DataCanbus.DATA[37] + 1;
                FunRuiTeng.C_CARINFO_SET(2, 4, value4);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue0() {
        int value = DataCanbus.DATA[26];
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_speed_lock)).setChecked(value == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[27];
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_auto_unlock)).setChecked(value == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[28];
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_unlock_mode)).setChecked(value == 1);
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_unlock_mode_tv)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_unlock_mode_tv)).setText(getResources().getString(R.string.wc_ruiteng_string_unlock_mode_1));
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_unlock_mode_tv)).setText(getResources().getString(R.string.wc_ruiteng_string_unlock_mode_0));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[29];
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_unlock_nearcar)).setChecked(value == 1);
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_intelligent_unlock_tv)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_intelligent_unlock_tv)).setText(getResources().getString(R.string.wc_ruiteng_string_unlock_mode_1));
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_intelligent_unlock_tv)).setText(getResources().getString(R.string.wc_ruiteng_string_unlock_mode_0));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[30];
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_home_light_backcar)).setChecked(value == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue5() {
        int value = DataCanbus.DATA[31];
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_home_light_backlight)).setChecked(value == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue6() {
        int value = DataCanbus.DATA[32];
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_home_light_back_foglight)).setChecked(value == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue7() {
        int value = DataCanbus.DATA[33];
        ((TextView) findViewById(R.id.rzc_ruiteng_home_light_time)).setText(getTimeString(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[34];
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_find_light_backcar)).setChecked(value == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue9() {
        int value = DataCanbus.DATA[35];
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_find_light_back_light)).setChecked(value == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue10() {
        int value = DataCanbus.DATA[36];
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_find_light_back_fog_light)).setChecked(value == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue11() {
        int value = DataCanbus.DATA[37];
        ((TextView) findViewById(R.id.rzc_ruiteng_find_light_time)).setText(getTimeString(value));
    }

    public String getTimeString(int value) {
        switch (value) {
            case 0:
                String str = getString(R.string.wc_ruiteng_string_time_0);
                return str;
            case 1:
                String str2 = getString(R.string.wc_ruiteng_string_time_1);
                return str2;
            case 2:
                String str3 = getString(R.string.wc_ruiteng_string_time_2);
                return str3;
            case 3:
                String str4 = getString(R.string.wc_ruiteng_string_time_3);
                return str4;
            case 4:
                String str5 = getString(R.string.wc_ruiteng_string_time_4);
                return str5;
            case 5:
                String str6 = getString(R.string.wc_ruiteng_string_time_5);
                return str6;
            case 6:
                String str7 = getString(R.string.wc_ruiteng_string_time_6);
                return str7;
            case 7:
                String str8 = getString(R.string.wc_ruiteng_string_time_7);
                return str8;
            case 8:
                String str9 = getString(R.string.wc_ruiteng_string_time_8);
                return str9;
            case 9:
                String str10 = getString(R.string.wc_ruiteng_string_time_9);
                return str10;
            default:
                return "";
        }
    }
}
