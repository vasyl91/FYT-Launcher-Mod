package com.syu.carinfo.saiou3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.carinfo.xfl.chuangku.XflCkFunc;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class SO3CarBody2Act extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.saiou3.SO3CarBody2Act.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 21:
                    SO3CarBody2Act.this.mUpdaterValue0();
                    break;
                case 22:
                    SO3CarBody2Act.this.mUpdaterValue1();
                    break;
                case 23:
                    SO3CarBody2Act.this.mUpdaterValue2();
                    break;
                case 24:
                    SO3CarBody2Act.this.mUpdaterValue3();
                    break;
                case 25:
                    SO3CarBody2Act.this.mUpdaterValue4();
                    break;
                case 26:
                    SO3CarBody2Act.this.mUpdaterValue5();
                    break;
                case 27:
                    SO3CarBody2Act.this.mUpdaterValue6();
                    break;
                case 28:
                    SO3CarBody2Act.this.mUpdaterValue7();
                    break;
                case 29:
                    SO3CarBody2Act.this.mUpdaterValue8();
                    break;
                case 30:
                    SO3CarBody2Act.this.mUpdaterValue9();
                    break;
                case 31:
                    SO3CarBody2Act.this.mUpdaterRearLock();
                    break;
                case 32:
                    SO3CarBody2Act.this.mUpdaterFRLock();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_sb_so3_car_body_set2);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                XflCkFunc.CAR_COMM_CONTROL(20, DataCanbus.DATA[21] != 0 ? 0 : 1);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int mLeaveAutoLuck = DataCanbus.DATA[28];
                if (mLeaveAutoLuck == 0) {
                    XflCkFunc.CAR_COMM_CONTROL(27, 2);
                    break;
                } else if (mLeaveAutoLuck == 1) {
                    XflCkFunc.CAR_COMM_CONTROL(27, 0);
                    break;
                } else if (mLeaveAutoLuck == 2) {
                    XflCkFunc.CAR_COMM_CONTROL(27, 1);
                    break;
                }
            case R.id.btn_plus1 /* 2131427482 */:
                int mLeaveAutoLuck2 = DataCanbus.DATA[28];
                if (mLeaveAutoLuck2 == 0) {
                    XflCkFunc.CAR_COMM_CONTROL(27, 2);
                    break;
                } else if (mLeaveAutoLuck2 == 1) {
                    XflCkFunc.CAR_COMM_CONTROL(27, 0);
                    break;
                } else if (mLeaveAutoLuck2 == 2) {
                    XflCkFunc.CAR_COMM_CONTROL(27, 1);
                    break;
                }
            case R.id.btn_minus2 /* 2131427484 */:
                int mAutoUser = DataCanbus.DATA[32];
                if (mAutoUser == 0) {
                    XflCkFunc.CAR_COMM_CONTROL(31, 2);
                    break;
                } else if (mAutoUser == 1) {
                    XflCkFunc.CAR_COMM_CONTROL(31, 0);
                    break;
                } else if (mAutoUser == 2) {
                    XflCkFunc.CAR_COMM_CONTROL(31, 1);
                    break;
                }
            case R.id.btn_plus2 /* 2131427486 */:
                int mAutoUser2 = DataCanbus.DATA[32];
                if (mAutoUser2 == 0) {
                    XflCkFunc.CAR_COMM_CONTROL(31, 2);
                    break;
                } else if (mAutoUser2 == 1) {
                    XflCkFunc.CAR_COMM_CONTROL(31, 0);
                    break;
                } else if (mAutoUser2 == 2) {
                    XflCkFunc.CAR_COMM_CONTROL(31, 1);
                    break;
                }
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                XflCkFunc.CAR_COMM_CONTROL(19, DataCanbus.DATA[22] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                XflCkFunc.CAR_COMM_CONTROL(21, DataCanbus.DATA[23] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                XflCkFunc.CAR_COMM_CONTROL(22, DataCanbus.DATA[24] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                XflCkFunc.CAR_COMM_CONTROL(23, DataCanbus.DATA[25] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                XflCkFunc.CAR_COMM_CONTROL(24, DataCanbus.DATA[26] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                XflCkFunc.CAR_COMM_CONTROL(25, DataCanbus.DATA[27] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                XflCkFunc.CAR_COMM_CONTROL(28, DataCanbus.DATA[29] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                XflCkFunc.CAR_COMM_CONTROL(29, DataCanbus.DATA[30] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                XflCkFunc.CAR_COMM_CONTROL(30, DataCanbus.DATA[31] != 0 ? 0 : 1);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdate();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdate();
    }

    private void addUpdate() {
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdate() {
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue0() {
        int mChangeWallWarn = DataCanbus.DATA[21];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(mChangeWallWarn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int mBackCarAccossWarm = DataCanbus.DATA[22];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(mBackCarAccossWarm == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int mRemeberStation = DataCanbus.DATA[23];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(mRemeberStation == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int mDriverGoDown = DataCanbus.DATA[24];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(mDriverGoDown == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue4() {
        int mBackCarAutoTilt = DataCanbus.DATA[25];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(mBackCarAutoTilt == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue5() {
        int mBackCameraFold = DataCanbus.DATA[26];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(mBackCameraFold == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue6() {
        int mAutoWiper = DataCanbus.DATA[27];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(mAutoWiper == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue7() {
        int mLeaveAutoLuck = DataCanbus.DATA[28];
        switch (mLeaveAutoLuck) {
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.xp_yinglang_car_set_Second_str9);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_sb_saiou3_str19);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.off);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue8() {
        int mRunWheel = DataCanbus.DATA[29];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(mRunWheel == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue9() {
        int mRunSuspension = DataCanbus.DATA[30];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(mRunSuspension == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRearLock() {
        int mFoureWheelDrive = DataCanbus.DATA[31];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(mFoureWheelDrive == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterFRLock() {
        int mAutoUser = DataCanbus.DATA[32];
        switch (mAutoUser) {
            case 1:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_sb_saiou3_str25);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_sb_saiou3_str26);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_sb_saiou3_str24);
                break;
        }
    }
}
