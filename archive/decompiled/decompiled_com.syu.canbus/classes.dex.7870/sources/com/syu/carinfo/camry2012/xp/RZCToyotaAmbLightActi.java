package com.syu.carinfo.camry2012.xp;

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
public class RZCToyotaAmbLightActi extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.camry2012.xp.RZCToyotaAmbLightActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 294:
                    switch (value) {
                        case 1:
                            ((TextView) RZCToyotaAmbLightActi.this.findViewById(R.id.tv_text1)).setText("全局");
                            break;
                        case 2:
                            ((TextView) RZCToyotaAmbLightActi.this.findViewById(R.id.tv_text1)).setText("区域");
                            break;
                        default:
                            ((TextView) RZCToyotaAmbLightActi.this.findViewById(R.id.tv_text1)).setText("--");
                            break;
                    }
                    break;
                case 295:
                    ((TextView) RZCToyotaAmbLightActi.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                    break;
                case 296:
                    ((TextView) RZCToyotaAmbLightActi.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                    break;
                case 297:
                    ((TextView) RZCToyotaAmbLightActi.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                    break;
                case 298:
                    RZCToyotaAmbLightActi.this.setCheck((CheckedTextView) RZCToyotaAmbLightActi.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 299:
                    RZCToyotaAmbLightActi.this.setCheck((CheckedTextView) RZCToyotaAmbLightActi.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 300:
                    RZCToyotaAmbLightActi.this.setCheck((CheckedTextView) RZCToyotaAmbLightActi.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 301:
                    RZCToyotaAmbLightActi.this.setCheck((CheckedTextView) RZCToyotaAmbLightActi.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 302:
                    RZCToyotaAmbLightActi.this.setCheck((CheckedTextView) RZCToyotaAmbLightActi.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 303:
                    RZCToyotaAmbLightActi.this.setCheck((CheckedTextView) RZCToyotaAmbLightActi.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 304:
                    switch (value) {
                        case 1:
                            ((TextView) RZCToyotaAmbLightActi.this.findViewById(R.id.tv_text5)).setText("1");
                            break;
                        case 2:
                            ((TextView) RZCToyotaAmbLightActi.this.findViewById(R.id.tv_text5)).setText("2");
                            break;
                        case 3:
                            ((TextView) RZCToyotaAmbLightActi.this.findViewById(R.id.tv_text5)).setText("3");
                            break;
                        default:
                            ((TextView) RZCToyotaAmbLightActi.this.findViewById(R.id.tv_text5)).setText("--");
                            break;
                    }
                    break;
                case 305:
                    switch (value) {
                        case 1:
                            ((TextView) RZCToyotaAmbLightActi.this.findViewById(R.id.tv_text6)).setText("舒缓");
                            break;
                        case 2:
                            ((TextView) RZCToyotaAmbLightActi.this.findViewById(R.id.tv_text6)).setText("普通");
                            break;
                        case 3:
                            ((TextView) RZCToyotaAmbLightActi.this.findViewById(R.id.tv_text6)).setText("动感");
                            break;
                        default:
                            ((TextView) RZCToyotaAmbLightActi.this.findViewById(R.id.tv_text6)).setText("--");
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0112_rzc_toyota_amblight_settings);
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
        int bit2;
        int bit3;
        int bit4;
        int bit5;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
                int value = DataCanbus.DATA[294] - 1;
                if (value < 1) {
                    value = 2;
                }
                setCarInfo(131, value);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value2 = DataCanbus.DATA[294] + 1;
                if (value2 > 2) {
                    value2 = 1;
                }
                setCarInfo(131, value2);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value3 = DataCanbus.DATA[295] - 1;
                if (value3 < 1) {
                    value3 = 9;
                }
                setCarInfo(134, value3);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value4 = DataCanbus.DATA[295] + 1;
                if (value4 > 9) {
                    value4 = 1;
                }
                setCarInfo(134, value4);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value5 = DataCanbus.DATA[296] - 1;
                if (value5 < 1) {
                    value5 = 9;
                }
                setCarInfo(132, value5);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value6 = DataCanbus.DATA[296] + 1;
                if (value6 > 9) {
                    value6 = 1;
                }
                setCarInfo(132, value6);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int value7 = DataCanbus.DATA[297] + 1;
                if (value7 > 9) {
                    value7 = 1;
                }
                setCarInfo(133, value7);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                int value8 = DataCanbus.DATA[304] + 1;
                if (value8 > 3) {
                    value8 = 1;
                }
                setCarInfo(138, value8);
                break;
            case R.id.btn_plus6 /* 2131427430 */:
                int value9 = DataCanbus.DATA[305] + 1;
                if (value9 > 3) {
                    value9 = 1;
                }
                setCarInfo(137, value9);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                int value10 = DataCanbus.DATA[297] - 1;
                if (value10 < 1) {
                    value10 = 9;
                }
                setCarInfo(133, value10);
                break;
            case R.id.btn_minus5 /* 2131427474 */:
                int value11 = DataCanbus.DATA[304] - 1;
                if (value11 < 1) {
                    value11 = 3;
                }
                setCarInfo(138, value11);
                break;
            case R.id.btn_minus6 /* 2131427476 */:
                int value12 = DataCanbus.DATA[305] - 1;
                if (value12 < 1) {
                    value12 = 3;
                }
                setCarInfo(137, value12);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                int bit6 = DataCanbus.DATA[298];
                int bit7 = DataCanbus.DATA[299];
                int bit8 = DataCanbus.DATA[300];
                int bit9 = DataCanbus.DATA[301];
                if (bit6 == 0) {
                    bit5 = 1;
                } else {
                    bit5 = 0;
                }
                setCarInfo(139, ((bit5 << 3) & 8) | ((bit7 << 2) & 4) | ((bit8 << 1) & 2) | ((bit9 << 0) & 1));
                break;
            case R.id.ctv_checkedtext4 /* 2131427552 */:
                int bit10 = DataCanbus.DATA[298];
                int bit11 = DataCanbus.DATA[299];
                int bit12 = DataCanbus.DATA[300];
                int bit13 = DataCanbus.DATA[301];
                if (bit13 == 0) {
                    bit2 = 1;
                } else {
                    bit2 = 0;
                }
                setCarInfo(139, ((bit10 << 3) & 8) | ((bit11 << 2) & 4) | ((bit12 << 1) & 2) | ((bit2 << 0) & 1));
                break;
            case R.id.ctv_checkedtext5 /* 2131427553 */:
                int value13 = DataCanbus.DATA[302];
                if (value13 == 0) {
                    value13 = 1;
                } else if (value13 == 1) {
                    value13 = 0;
                }
                setCarInfo(135, value13);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                int bit14 = DataCanbus.DATA[298];
                int bit15 = DataCanbus.DATA[299];
                int bit16 = DataCanbus.DATA[300];
                int bit17 = DataCanbus.DATA[301];
                if (bit15 == 0) {
                    bit4 = 1;
                } else {
                    bit4 = 0;
                }
                setCarInfo(139, ((bit14 << 3) & 8) | ((bit4 << 2) & 4) | ((bit16 << 1) & 2) | ((bit17 << 0) & 1));
                break;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                int bit18 = DataCanbus.DATA[298];
                int bit19 = DataCanbus.DATA[299];
                int bit20 = DataCanbus.DATA[300];
                int bit21 = DataCanbus.DATA[301];
                if (bit20 == 0) {
                    bit3 = 1;
                } else {
                    bit3 = 0;
                }
                setCarInfo(139, ((bit18 << 3) & 8) | ((bit19 << 2) & 4) | ((bit3 << 1) & 2) | ((bit21 << 0) & 1));
                break;
            case R.id.ctv_checkedtext6 /* 2131427563 */:
                int value14 = DataCanbus.DATA[303];
                if (value14 == 0) {
                    value14 = 1;
                } else if (value14 == 1) {
                    value14 = 0;
                }
                setCarInfo(136, value14);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(40, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(43, new int[]{80, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[294].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[295].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[296].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[297].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[298].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[299].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[300].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[301].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[302].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[303].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[304].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[305].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[294].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[295].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[296].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[297].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[298].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[299].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[300].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[301].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[302].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[303].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[304].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[305].removeNotify(this.mNotifyCanbus);
    }
}
