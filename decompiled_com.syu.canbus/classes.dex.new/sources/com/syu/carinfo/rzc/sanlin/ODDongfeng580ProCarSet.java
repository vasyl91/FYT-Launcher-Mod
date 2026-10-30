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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ODDongfeng580ProCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODDongfeng580ProCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 178:
                    ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 179:
                    ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 180:
                    if (((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text1)).setText("标准");
                                break;
                            case 2:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text1)).setText("舒适");
                                break;
                            case 3:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text1)).setText("运动");
                                break;
                            default:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text1)).setText("--");
                                break;
                        }
                    }
                    break;
                case 181:
                    ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 182:
                    ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext4), false);
                    ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext5), false);
                    ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext6), false);
                    if (((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext4), true);
                                break;
                            case 1:
                                ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext5), true);
                                break;
                            case 2:
                                ODDongfeng580ProCarSet.this.setCheck((CheckedTextView) ODDongfeng580ProCarSet.this.findViewById(R.id.ctv_checkedtext6), true);
                                break;
                        }
                    }
                    break;
                case 183:
                    if (((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text2)).setText("同步开");
                                break;
                            case 2:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text2)).setText("同步关");
                                break;
                            case 3:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text2)).setText("同步开关");
                                break;
                            default:
                                ((TextView) ODDongfeng580ProCarSet.this.findViewById(R.id.tv_text2)).setText("不同步");
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0314_od_fengguang580pro_carset);
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
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[180] - 1;
                if (value < 1) {
                    value = 3;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[180] + 1;
                if (value2 > 3) {
                    value2 = 1;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[183] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(5, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[183] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(5, value4);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(2, DataCanbus.DATA[178] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCarInfo(4, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCarInfo(4, 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfo(3, DataCanbus.DATA[179] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfo(6, DataCanbus.DATA[181] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                setCarInfo(4, 2);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(5, new int[]{value1, value2}, null, null);
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
        DataCanbus.PROXY.cmd(3, new int[]{64}, null, null);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
    }
}
