package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ODChanganLuminCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODChanganLuminCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    if (((TextView) ODChanganLuminCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODChanganLuminCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODChanganLuminCarSet.this.findViewById(R.id.tv_text1)).setText("30s");
                                break;
                            case 2:
                                ((TextView) ODChanganLuminCarSet.this.findViewById(R.id.tv_text1)).setText("60s");
                                break;
                            case 3:
                                ((TextView) ODChanganLuminCarSet.this.findViewById(R.id.tv_text1)).setText("120s");
                                break;
                        }
                    }
                    break;
                case 99:
                    ODChanganLuminCarSet.this.setCheck((CheckedTextView) ODChanganLuminCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 100:
                    ODChanganLuminCarSet.this.setCheck((CheckedTextView) ODChanganLuminCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 101:
                    ODChanganLuminCarSet.this.setCheck((CheckedTextView) ODChanganLuminCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 102:
                    ODChanganLuminCarSet.this.setCheck((CheckedTextView) ODChanganLuminCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 103:
                    ODChanganLuminCarSet.this.setCheck((CheckedTextView) ODChanganLuminCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 104:
                    ODChanganLuminCarSet.this.setCheck((CheckedTextView) ODChanganLuminCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 105:
                    ODChanganLuminCarSet.this.setCheck((CheckedTextView) ODChanganLuminCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 106:
                    ODChanganLuminCarSet.this.setCheck((CheckedTextView) ODChanganLuminCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 107:
                    if (((TextView) ODChanganLuminCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) ODChanganLuminCarSet.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "%");
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0454_od_changan_lumin_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_OD_Changan_Lumin /* 2687430 */:
                findViewById(R.id.layout_view8).setVisibility(8);
                findViewById(R.id.layout_view9).setVisibility(8);
                findViewById(R.id.layout_view10).setVisibility(8);
                break;
            case FinalCanbus.CAR_455_OD_Changan_Lumin_26 /* 15204807 */:
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[98] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[98] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[107] - 5;
                if (value3 < 40) {
                    value3 = 40;
                }
                setCarInfo(10, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[107] + 5;
                if (value4 > 100) {
                    value4 = 100;
                }
                setCarInfo(10, value4);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value5 = DataCanbus.DATA[99];
                if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                setCarInfo(2, value5);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value6 = DataCanbus.DATA[102];
                if (value6 == 1) {
                    value6 = 0;
                } else if (value6 == 0) {
                    value6 = 1;
                }
                setCarInfo(6, value6);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value7 = DataCanbus.DATA[103];
                if (value7 == 1) {
                    value7 = 0;
                } else if (value7 == 0) {
                    value7 = 1;
                }
                setCarInfo(5, value7);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value8 = DataCanbus.DATA[100];
                if (value8 == 1) {
                    value8 = 0;
                } else if (value8 == 0) {
                    value8 = 1;
                }
                setCarInfo(3, value8);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value9 = DataCanbus.DATA[101];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(4, value9);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int value10 = DataCanbus.DATA[104];
                if (value10 == 1) {
                    value10 = 0;
                } else if (value10 == 0) {
                    value10 = 1;
                }
                setCarInfo(7, value10);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int value11 = DataCanbus.DATA[105];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(8, value11);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int value12 = DataCanbus.DATA[106];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                setCarInfo(9, value12);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{102, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
    }
}
