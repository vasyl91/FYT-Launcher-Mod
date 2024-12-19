package com.syu.carinfo.xc.lexus;

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
public class XCLexusAudio extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xc.lexus.XCLexusAudio.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 35:
                    if (((TextView) XCLexusAudio.this.findViewById(R.id.tv_text6)) != null) {
                        if (value > 7) {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text6)).setText("+" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text6)).setText("-" + (7 - value));
                            break;
                        } else {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text6)).setText("0");
                            break;
                        }
                    }
                    break;
                case 36:
                    if (((TextView) XCLexusAudio.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 7) {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text5)).setText("+" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text5)).setText("-" + (7 - value));
                            break;
                        } else {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text5)).setText("0");
                            break;
                        }
                    }
                    break;
                case 37:
                    if (((TextView) XCLexusAudio.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 5) {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text2)).setText("+" + (value - 5));
                            break;
                        } else if (value < 5) {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text2)).setText("-" + (5 - value));
                            break;
                        } else {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text2)).setText("0");
                            break;
                        }
                    }
                    break;
                case 38:
                    if (((TextView) XCLexusAudio.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 5) {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text4)).setText("+" + (value - 5));
                            break;
                        } else if (value < 5) {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text4)).setText("-" + (5 - value));
                            break;
                        } else {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        }
                    }
                    break;
                case 39:
                    if (((TextView) XCLexusAudio.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 5) {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text3)).setText("+" + (value - 5));
                            break;
                        } else if (value < 5) {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text3)).setText("-" + (5 - value));
                            break;
                        } else {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text3)).setText("0");
                            break;
                        }
                    }
                    break;
                case 40:
                    XCLexusAudio.this.setCheck((CheckedTextView) XCLexusAudio.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 41:
                case 42:
                    if (((TextView) XCLexusAudio.this.findViewById(R.id.tv_text1)) != null) {
                        if (DataCanbus.DATA[41] == 1) {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text1)).setText("0");
                            break;
                        } else {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(DataCanbus.DATA[42]).toString());
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
        setContentView(R.layout.layout_0452_xincheng_lexus_settings);
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
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[40];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setDCarInfo(7, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                setDCarInfo(1, 49);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                setDCarInfo(1, 33);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                setDCarInfo(2, 49);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                setDCarInfo(2, 33);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                setDCarInfo(6, 49);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                setDCarInfo(6, 33);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                setDCarInfo(3, 49);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                setDCarInfo(3, 33);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                setDCarInfo(4, 49);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                setDCarInfo(4, 33);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                setDCarInfo(5, 49);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                setDCarInfo(5, 33);
                break;
        }
    }

    void setDCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
    }
}
