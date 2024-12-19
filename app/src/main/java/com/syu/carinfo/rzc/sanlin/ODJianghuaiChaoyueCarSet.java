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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ODJianghuaiChaoyueCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODJianghuaiChaoyueCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 86:
                    ODJianghuaiChaoyueCarSet.this.setCheck((CheckedTextView) ODJianghuaiChaoyueCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 87:
                    ODJianghuaiChaoyueCarSet.this.setCheck((CheckedTextView) ODJianghuaiChaoyueCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 88:
                    if (((TextView) ODJianghuaiChaoyueCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 2:
                                ((TextView) ODJianghuaiChaoyueCarSet.this.findViewById(R.id.tv_text1)).setText("小");
                                break;
                            case 3:
                                ((TextView) ODJianghuaiChaoyueCarSet.this.findViewById(R.id.tv_text1)).setText("中等");
                                break;
                            case 4:
                                ((TextView) ODJianghuaiChaoyueCarSet.this.findViewById(R.id.tv_text1)).setText("大");
                                break;
                            case 5:
                                ((TextView) ODJianghuaiChaoyueCarSet.this.findViewById(R.id.tv_text1)).setText("最大");
                                break;
                            default:
                                ((TextView) ODJianghuaiChaoyueCarSet.this.findViewById(R.id.tv_text1)).setText("最小");
                                break;
                        }
                    }
                    break;
                case 89:
                    ODJianghuaiChaoyueCarSet.this.setCheck((CheckedTextView) ODJianghuaiChaoyueCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_od_jianghuai_chaoyue_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[86];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[87] - 1;
                if (value2 < 1) {
                    value2 = 5;
                }
                setCarInfo(3, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[87] + 1;
                if (value3 > 5) {
                    value3 = 1;
                }
                setCarInfo(3, value3);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value4 = DataCanbus.DATA[87];
                if (value4 == 1) {
                    value4 = 0;
                } else if (value4 == 0) {
                    value4 = 1;
                }
                setCarInfo(2, value4);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value5 = DataCanbus.DATA[87];
                if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                setCarInfo(4, value5);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
    }
}
