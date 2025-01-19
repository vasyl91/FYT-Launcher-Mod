package com.syu.carinfo.saiou3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.xfl.chuangku.XflCkFunc;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ActCarSet2_GM_SiBo extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 118:
                    ActCarSet2_GM_SiBo.this.mUpdaterValue0();
                    break;
                case 119:
                    ActCarSet2_GM_SiBo.this.mUpdaterValue1();
                    break;
                case 120:
                    ActCarSet2_GM_SiBo.this.mUpdaterValue2();
                    break;
                case 121:
                    ActCarSet2_GM_SiBo.this.mUpdaterValue3();
                    break;
                case 122:
                    ActCarSet2_GM_SiBo.this.mUpdaterValue4();
                    break;
                case 123:
                    ActCarSet2_GM_SiBo.this.mUpdaterValue5();
                    break;
                case 124:
                    ActCarSet2_GM_SiBo.this.mUpdaterValue6();
                    break;
                case 125:
                    ActCarSet2_GM_SiBo.this.mUpdaterValue7();
                    break;
                case 126:
                    ActCarSet2_GM_SiBo.this.mUpdaterValue8();
                    break;
                case 127:
                    ActCarSet2_GM_SiBo.this.mUpdaterValue9();
                    break;
                case 128:
                    ActCarSet2_GM_SiBo.this.mUpdaterRearLock();
                    break;
                case 129:
                    ActCarSet2_GM_SiBo.this.mUpdaterFRLock();
                    break;
                case 138:
                    ActCarSet2_GM_SiBo.this.uAutoAcc();
                    break;
                case 139:
                    ActCarSet2_GM_SiBo.this.uAntiCrash();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_sb_gm_car_set2);
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
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int mLeaveAutoLuck = DataCanbus.DATA[125];
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
            case R.id.btn_plus1 /* 2131427457 */:
                int mLeaveAutoLuck2 = DataCanbus.DATA[125];
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
            case R.id.btn_minus2 /* 2131427458 */:
                int mFangzhuang = DataCanbus.DATA[139] - 1;
                if (mFangzhuang < 0) {
                    mFangzhuang = 2;
                }
                XflCkFunc.CAR_COMM_CONTROL(17, mFangzhuang);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int mFangzhuang2 = DataCanbus.DATA[139] + 1;
                if (mFangzhuang2 > 2) {
                    mFangzhuang2 = 0;
                }
                XflCkFunc.CAR_COMM_CONTROL(17, mFangzhuang2);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int mAutoUser = DataCanbus.DATA[129];
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
            case R.id.btn_plus3 /* 2131427463 */:
                int mAutoUser2 = DataCanbus.DATA[129];
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
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                XflCkFunc.CAR_COMM_CONTROL(20, DataCanbus.DATA[118] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                XflCkFunc.CAR_COMM_CONTROL(19, DataCanbus.DATA[119] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                XflCkFunc.CAR_COMM_CONTROL(21, DataCanbus.DATA[120] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                XflCkFunc.CAR_COMM_CONTROL(22, DataCanbus.DATA[121] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                XflCkFunc.CAR_COMM_CONTROL(23, DataCanbus.DATA[122] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                XflCkFunc.CAR_COMM_CONTROL(24, DataCanbus.DATA[123] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                XflCkFunc.CAR_COMM_CONTROL(25, DataCanbus.DATA[124] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                XflCkFunc.CAR_COMM_CONTROL(28, DataCanbus.DATA[126] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                XflCkFunc.CAR_COMM_CONTROL(29, DataCanbus.DATA[127] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                XflCkFunc.CAR_COMM_CONTROL(30, DataCanbus.DATA[128] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                XflCkFunc.CAR_COMM_CONTROL(34, DataCanbus.DATA[138] != 0 ? 0 : 1);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addUpdate();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeUpdate();
    }

    private void addUpdate() {
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdate() {
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue0() {
        int mChangeWallWarn = DataCanbus.DATA[118];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(mChangeWallWarn == 1);
    }

    protected void uAntiCrash() {
        int mFangzhuang = DataCanbus.DATA[139];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            int d = R.string.off;
            if (mFangzhuang == 1) {
                d = R.string.wc_weilang_auto_fangzhuang_warn;
            } else if (mFangzhuang == 2) {
                d = R.string.wc_weilang_auto_fangzhuang_warn_and_zhidong;
            }
            ((TextView) findViewById(R.id.tv_text2)).setText(d);
        }
    }

    protected void uAutoAcc() {
        int mAcc = DataCanbus.DATA[138];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext11), mAcc == 1);
    }

    
    public void mUpdaterValue1() {
        int mBackCarAccossWarm = DataCanbus.DATA[119];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(mBackCarAccossWarm == 1);
    }

    
    public void mUpdaterValue2() {
        int mRemeberStation = DataCanbus.DATA[120];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(mRemeberStation == 1);
    }

    
    public void mUpdaterValue3() {
        int mDriverGoDown = DataCanbus.DATA[121];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(mDriverGoDown == 1);
    }

    
    public void mUpdaterValue4() {
        int mBackCarAutoTilt = DataCanbus.DATA[122];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(mBackCarAutoTilt == 1);
    }

    
    public void mUpdaterValue5() {
        int mBackCameraFold = DataCanbus.DATA[123];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(mBackCameraFold == 1);
    }

    
    public void mUpdaterValue6() {
        int mAutoWiper = DataCanbus.DATA[124];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(mAutoWiper == 1);
    }

    
    public void mUpdaterValue7() {
        int mLeaveAutoLuck = DataCanbus.DATA[125];
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

    
    public void mUpdaterValue8() {
        int mRunWheel = DataCanbus.DATA[126];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(mRunWheel == 1);
    }

    
    public void mUpdaterValue9() {
        int mRunSuspension = DataCanbus.DATA[127];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(mRunSuspension == 1);
    }

    
    public void mUpdaterRearLock() {
        int mFoureWheelDrive = DataCanbus.DATA[128];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(mFoureWheelDrive == 1);
    }

    
    public void mUpdaterFRLock() {
        int mAutoUser = DataCanbus.DATA[129];
        switch (mAutoUser) {
            case 1:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_sb_saiou3_str25);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_sb_saiou3_str26);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_sb_saiou3_str24);
                break;
        }
    }
}
