package com.syu.carinfo.wccamry;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class WcToyotaDashBoardActi extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wccamry.WcToyotaDashBoardActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 230:
                    if (((TextView) WcToyotaDashBoardActi.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WcToyotaDashBoardActi.this.findViewById(R.id.tv_text1)).setText("Type1");
                                break;
                            case 1:
                                ((TextView) WcToyotaDashBoardActi.this.findViewById(R.id.tv_text1)).setText("Type2");
                                break;
                            case 2:
                                ((TextView) WcToyotaDashBoardActi.this.findViewById(R.id.tv_text1)).setText("Type3");
                                break;
                        }
                    }
                    break;
                case 231:
                    if (((TextView) WcToyotaDashBoardActi.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WcToyotaDashBoardActi.this.findViewById(R.id.tv_text2)).setText("自动切换");
                                break;
                            case 1:
                                ((TextView) WcToyotaDashBoardActi.this.findViewById(R.id.tv_text2)).setText("转速表");
                                break;
                            case 2:
                                ((TextView) WcToyotaDashBoardActi.this.findViewById(R.id.tv_text2)).setText("HV仪表");
                                break;
                        }
                    }
                    break;
                case 232:
                    if (((TextView) WcToyotaDashBoardActi.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) WcToyotaDashBoardActi.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value + 1).toString());
                    }
                    break;
                case 233:
                    WcToyotaDashBoardActi.this.setCheck((CheckedTextView) WcToyotaDashBoardActi.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 234:
                    WcToyotaDashBoardActi.this.setCheck((CheckedTextView) WcToyotaDashBoardActi.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 276:
                    WcToyotaDashBoardActi.this.setCheck((CheckedTextView) WcToyotaDashBoardActi.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0294_wc_toyota_dashboard_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
                int value = DataCanbus.DATA[230] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(1, 37, value);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value2 = DataCanbus.DATA[230] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(1, 37, value2);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value3 = DataCanbus.DATA[231] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(1, 38, value3);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value4 = DataCanbus.DATA[231] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(1, 38, value4);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value5 = DataCanbus.DATA[232] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(1, 39, value5);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value6 = DataCanbus.DATA[232] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(1, 39, value6);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                int value7 = DataCanbus.DATA[233];
                if (value7 == 0) {
                    value7 = 1;
                } else if (value7 == 1) {
                    value7 = 0;
                }
                setCarInfo(1, 40, value7);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                int value8 = DataCanbus.DATA[234];
                if (value8 == 0) {
                    value8 = 1;
                } else if (value8 == 1) {
                    value8 = 0;
                }
                setCarInfo(1, 41, value8);
                break;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                int value9 = DataCanbus.DATA[276];
                if (value9 == 0) {
                    value9 = 1;
                } else if (value9 == 1) {
                    value9 = 0;
                }
                setCarInfo(1, 33, value9);
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(29, new int[]{value1, value2, value3}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[230].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[231].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[232].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[233].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[234].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[276].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[230].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[231].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[232].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[233].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[234].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[276].removeNotify(this.mNotifyCanbus);
    }
}
