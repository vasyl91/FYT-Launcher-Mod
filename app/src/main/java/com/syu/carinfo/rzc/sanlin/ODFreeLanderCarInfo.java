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
public class ODFreeLanderCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODFreeLanderCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 87:
                    if (value == 65535) {
                        ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text1)).setText("----");
                        break;
                    } else {
                        ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10.0f) + " L/100KM");
                        break;
                    }
                case 88:
                    if (value == 0) {
                        ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text2)).setText("----");
                        break;
                    } else {
                        ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "%");
                        break;
                    }
                case 89:
                    if (value == 65535) {
                        ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text3)).setText("----");
                        break;
                    } else {
                        ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10.0f) + " L/100KM");
                        break;
                    }
                case 90:
                    if (value == 0) {
                        ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text4)).setText("----");
                        break;
                    } else {
                        ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "%");
                        break;
                    }
                case 91:
                    if (value == 65535) {
                        ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text5)).setText("----");
                        break;
                    } else {
                        ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10.0f) + " L/100KM");
                        break;
                    }
                case 92:
                    if (value == 0) {
                        ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text6)).setText("----");
                        break;
                    } else {
                        ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "%");
                        break;
                    }
                case 93:
                    ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text7)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 94:
                    ODFreeLanderCarInfo.this.setCheck((CheckedTextView) ODFreeLanderCarInfo.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 95:
                    switch (value) {
                        case 0:
                            ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_low);
                            break;
                        case 2:
                            ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_middle);
                            break;
                        case 3:
                            ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_high);
                            break;
                    }
                case 96:
                    switch (value) {
                        case 0:
                            ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text9)).setText(R.string.klc_air_low);
                            break;
                        case 1:
                            ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text9)).setText(R.string.klc_air_middle);
                            break;
                        case 2:
                            ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text9)).setText(R.string.klc_air_high);
                            break;
                    }
                case 97:
                    ODFreeLanderCarInfo.this.setCheck((CheckedTextView) ODFreeLanderCarInfo.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_od_freelander_carinfo);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{65}, null, null);
        DataCanbus.PROXY.cmd(1, new int[]{66}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[94];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                DataCanbus.PROXY.cmd(0, new int[]{52}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                DataCanbus.PROXY.cmd(0, new int[]{51}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value2 = DataCanbus.DATA[95] - 1;
                if (value2 < 0) {
                    value2 = 3;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value3 = DataCanbus.DATA[95] + 1;
                if (value3 > 3) {
                    value3 = 0;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value4 = DataCanbus.DATA[96] - 1;
                if (value4 < 0) {
                    value4 = 2;
                }
                setCarInfo(3, value4);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value5 = DataCanbus.DATA[96] + 1;
                if (value5 > 2) {
                    value5 = 0;
                }
                setCarInfo(3, value5);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value6 = DataCanbus.DATA[97];
                if (value6 == 1) {
                    value6 = 0;
                } else if (value6 == 0) {
                    value6 = 1;
                }
                setCarInfo(4, value6);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
    }
}
