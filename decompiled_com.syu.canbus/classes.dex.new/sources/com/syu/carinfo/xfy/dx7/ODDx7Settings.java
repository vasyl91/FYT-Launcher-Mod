package com.syu.carinfo.xfy.dx7;

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
public class ODDx7Settings extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xfy.dx7.ODDx7Settings.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 113:
                    ODDx7Settings.this.setCheck((CheckedTextView) ODDx7Settings.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 114:
                    ODDx7Settings.this.setCheck((CheckedTextView) ODDx7Settings.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 115:
                    ODDx7Settings.this.setCheck((CheckedTextView) ODDx7Settings.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 116:
                    ODDx7Settings.this.setCheck((CheckedTextView) ODDx7Settings.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 117:
                    ODDx7Settings.this.setCheck((CheckedTextView) ODDx7Settings.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 118:
                    ODDx7Settings.this.setCheck((CheckedTextView) ODDx7Settings.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 119:
                    ODDx7Settings.this.setCheck((CheckedTextView) ODDx7Settings.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 120:
                    ODDx7Settings.this.setCheck((CheckedTextView) ODDx7Settings.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 125:
                    switch (val) {
                        case 1:
                            ((TextView) ODDx7Settings.this.findViewById(R.id.tv_text1)).setText(R.string.carema_type_7);
                            break;
                        case 2:
                            ((TextView) ODDx7Settings.this.findViewById(R.id.tv_text1)).setText(R.string.carema_type_6);
                            break;
                        default:
                            ((TextView) ODDx7Settings.this.findViewById(R.id.tv_text1)).setText(R.string.carema_type_4);
                            break;
                    }
                    break;
                case 126:
                    switch (val) {
                        case 1:
                            ((TextView) ODDx7Settings.this.findViewById(R.id.tv_text2)).setText("LDWS（车辆偏离预警）");
                            break;
                        default:
                            ((TextView) ODDx7Settings.this.findViewById(R.id.tv_text2)).setText("LKA(车道保持)");
                            break;
                    }
                    break;
                case 128:
                    ODDx7Settings.this.setCheck((CheckedTextView) ODDx7Settings.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0329_od_dongnanx7_settings);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_CZH_OD_DongNanDX7_18_20_H /* 721225 */:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(8);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[125] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(9, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[125] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(9, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[126] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(10, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[126] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(10, value4);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value5 = DataCanbus.DATA[113];
                if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                setCarInfo(1, value5);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value6 = DataCanbus.DATA[116];
                if (value6 == 1) {
                    value6 = 0;
                } else if (value6 == 0) {
                    value6 = 1;
                }
                setCarInfo(4, value6);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value7 = DataCanbus.DATA[117];
                if (value7 == 1) {
                    value7 = 0;
                } else if (value7 == 0) {
                    value7 = 1;
                }
                setCarInfo(5, value7);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value8 = DataCanbus.DATA[114];
                if (value8 == 1) {
                    value8 = 0;
                } else if (value8 == 0) {
                    value8 = 1;
                }
                setCarInfo(2, value8);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value9 = DataCanbus.DATA[115];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(3, value9);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int value10 = DataCanbus.DATA[118];
                if (value10 == 1) {
                    value10 = 0;
                } else if (value10 == 0) {
                    value10 = 1;
                }
                setCarInfo(6, value10);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int value11 = DataCanbus.DATA[119];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(7, value11);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int value12 = DataCanbus.DATA[120];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                setCarInfo(8, value12);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                int value13 = DataCanbus.DATA[128];
                if (value13 == 1) {
                    value13 = 0;
                } else if (value13 == 0) {
                    value13 = 1;
                }
                DataCanbus.PROXY.cmd(8, new int[]{value13}, null, null);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(6, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{52}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
    }
}
