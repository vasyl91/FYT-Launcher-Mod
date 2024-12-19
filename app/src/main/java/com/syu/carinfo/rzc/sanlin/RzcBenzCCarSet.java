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
public class RzcBenzCCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.RzcBenzCCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 42:
                    RzcBenzCCarSet.this.setCheck((CheckedTextView) RzcBenzCCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 51:
                    if (((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text1)).setText("---");
                                break;
                            case 1:
                                ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text1)).setText("Screen 6.0");
                                break;
                            case 2:
                                ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text1)).setText("Screen 7.0");
                                break;
                            case 3:
                                ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text1)).setText("Screen 10.25");
                                break;
                        }
                    }
                    break;
                case 52:
                    switch (value) {
                        case 1:
                            ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text2)).setText("Normal");
                            break;
                        case 2:
                            ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text2)).setText("Draw");
                            break;
                    }
                case 53:
                    switch (value) {
                        case 6:
                            ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text3)).setText("1280x720@30Hz");
                            break;
                        case 7:
                            ((TextView) RzcBenzCCarSet.this.findViewById(R.id.tv_text3)).setText("1280x720@25Hz");
                            break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_rzc_benz_c_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                if (DataCanbus.DATA[42] == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                setCarInfo(0, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[51] - 1;
                if (value2 < 1) {
                    value2 = 3;
                }
                setCarInfo(3, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[51] + 1;
                if (value3 > 3) {
                    value3 = 1;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[52] - 1;
                if (value4 < 1) {
                    value4 = 2;
                }
                setCarInfo(5, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[52] + 1;
                if (value5 > 2) {
                    value5 = 1;
                }
                setCarInfo(5, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[53] - 1;
                if (value6 < 6) {
                    value6 = 7;
                }
                setCarInfo(6, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[53] + 1;
                if (value7 > 7) {
                    value7 = 6;
                }
                setCarInfo(6, value7);
                break;
        }
    }

    public void setCarInfo(int value, int value1) {
        DataCanbus.PROXY.cmd(1, new int[]{value, value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
    }
}
