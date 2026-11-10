package com.syu.carinfo.honda;

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
public class Acrivity_WC_Honda_FenweiLightSettings extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.Acrivity_WC_Honda_FenweiLightSettings.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 231:
                    switch (value) {
                        case 0:
                            ((TextView) Acrivity_WC_Honda_FenweiLightSettings.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                            break;
                        default:
                            ((TextView) Acrivity_WC_Honda_FenweiLightSettings.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
                            break;
                    }
                    break;
                case 232:
                    switch (value) {
                        case 0:
                            ((TextView) Acrivity_WC_Honda_FenweiLightSettings.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                            break;
                        default:
                            ((TextView) Acrivity_WC_Honda_FenweiLightSettings.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                            break;
                    }
                    break;
                case 233:
                    switch (value) {
                        case 1:
                            ((TextView) Acrivity_WC_Honda_FenweiLightSettings.this.findViewById(R.id.tv_text3)).setText("热炎绚红");
                            break;
                        case 2:
                            ((TextView) Acrivity_WC_Honda_FenweiLightSettings.this.findViewById(R.id.tv_text3)).setText("绽放暖橙");
                            break;
                        case 3:
                            ((TextView) Acrivity_WC_Honda_FenweiLightSettings.this.findViewById(R.id.tv_text3)).setText("明媚日光");
                            break;
                        case 4:
                            ((TextView) Acrivity_WC_Honda_FenweiLightSettings.this.findViewById(R.id.tv_text3)).setText("山间空气");
                            break;
                        case 5:
                            ((TextView) Acrivity_WC_Honda_FenweiLightSettings.this.findViewById(R.id.tv_text3)).setText("北极海洋");
                            break;
                        case 6:
                            ((TextView) Acrivity_WC_Honda_FenweiLightSettings.this.findViewById(R.id.tv_text3)).setText("静夜蔚蓝");
                            break;
                        case 7:
                            ((TextView) Acrivity_WC_Honda_FenweiLightSettings.this.findViewById(R.id.tv_text3)).setText("静夜淡紫");
                            break;
                        case 8:
                            ((TextView) Acrivity_WC_Honda_FenweiLightSettings.this.findViewById(R.id.tv_text3)).setText("乳白迷雾");
                            break;
                        case 9:
                            ((TextView) Acrivity_WC_Honda_FenweiLightSettings.this.findViewById(R.id.tv_text3)).setText("纯净靓白");
                            break;
                        case 10:
                            ((TextView) Acrivity_WC_Honda_FenweiLightSettings.this.findViewById(R.id.tv_text3)).setText("静谧月光");
                            break;
                    }
                    break;
                case 234:
                    Acrivity_WC_Honda_FenweiLightSettings.this.setCheck((CheckedTextView) Acrivity_WC_Honda_FenweiLightSettings.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 235:
                    Acrivity_WC_Honda_FenweiLightSettings.this.setCheck((CheckedTextView) Acrivity_WC_Honda_FenweiLightSettings.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 236:
                    Acrivity_WC_Honda_FenweiLightSettings.this.setCheck((CheckedTextView) Acrivity_WC_Honda_FenweiLightSettings.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 237:
                    Acrivity_WC_Honda_FenweiLightSettings.this.setCheck((CheckedTextView) Acrivity_WC_Honda_FenweiLightSettings.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 238:
                    Acrivity_WC_Honda_FenweiLightSettings.this.setCheck((CheckedTextView) Acrivity_WC_Honda_FenweiLightSettings.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 239:
                    Acrivity_WC_Honda_FenweiLightSettings.this.setCheck((CheckedTextView) Acrivity_WC_Honda_FenweiLightSettings.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 240:
                    Acrivity_WC_Honda_FenweiLightSettings.this.setCheck((CheckedTextView) Acrivity_WC_Honda_FenweiLightSettings.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 241:
                    Acrivity_WC_Honda_FenweiLightSettings.this.setCheck((CheckedTextView) Acrivity_WC_Honda_FenweiLightSettings.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 242:
                    Acrivity_WC_Honda_FenweiLightSettings.this.setCheck((CheckedTextView) Acrivity_WC_Honda_FenweiLightSettings.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 243:
                    Acrivity_WC_Honda_FenweiLightSettings.this.setCheck((CheckedTextView) Acrivity_WC_Honda_FenweiLightSettings.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 244:
                    Acrivity_WC_Honda_FenweiLightSettings.this.setCheck((CheckedTextView) Acrivity_WC_Honda_FenweiLightSettings.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0321_wc_honda_fenweisettings);
        setListener();
    }

    private void setListener() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
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
        int value2;
        int value3;
        int value4;
        int value5;
        int value6;
        int value7;
        int value8;
        int value9;
        int value10;
        int value11;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
                int value12 = DataCanbus.DATA[231] - 1;
                if (value12 < 0) {
                    value12 = 10;
                }
                DataCanbus.PROXY.cmd(106, new int[]{76, value12}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value13 = DataCanbus.DATA[231] + 1;
                if (value13 > 10) {
                    value13 = 0;
                }
                DataCanbus.PROXY.cmd(106, new int[]{76, value13}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value14 = DataCanbus.DATA[232] - 1;
                if (value14 < 0) {
                    value14 = 10;
                }
                DataCanbus.PROXY.cmd(106, new int[]{77, value14}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value15 = DataCanbus.DATA[232] + 1;
                if (value15 > 10) {
                    value15 = 0;
                }
                DataCanbus.PROXY.cmd(106, new int[]{77, value15}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value16 = DataCanbus.DATA[233] - 1;
                if (value16 < 1) {
                    value16 = 10;
                }
                DataCanbus.PROXY.cmd(106, new int[]{64, value16}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value17 = DataCanbus.DATA[233] + 1;
                if (value17 > 10) {
                    value17 = 1;
                }
                DataCanbus.PROXY.cmd(106, new int[]{64, value17}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                if (DataCanbus.DATA[234] == 1) {
                    value11 = 0;
                } else {
                    value11 = 1;
                }
                DataCanbus.PROXY.cmd(106, new int[]{75, value11}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427552 */:
                if (DataCanbus.DATA[237] == 1) {
                    value8 = 0;
                } else {
                    value8 = 1;
                }
                DataCanbus.PROXY.cmd(106, new int[]{67, value8}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427553 */:
                if (DataCanbus.DATA[238] == 1) {
                    value7 = 0;
                } else {
                    value7 = 1;
                }
                DataCanbus.PROXY.cmd(106, new int[]{68, value7}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                if (DataCanbus.DATA[235] == 1) {
                    value10 = 0;
                } else {
                    value10 = 1;
                }
                DataCanbus.PROXY.cmd(106, new int[]{65, value10}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                if (DataCanbus.DATA[236] == 1) {
                    value9 = 0;
                } else {
                    value9 = 1;
                }
                DataCanbus.PROXY.cmd(106, new int[]{66, value9}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427563 */:
                if (DataCanbus.DATA[239] == 1) {
                    value6 = 0;
                } else {
                    value6 = 1;
                }
                DataCanbus.PROXY.cmd(106, new int[]{69, value6}, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427564 */:
                if (DataCanbus.DATA[240] == 1) {
                    value5 = 0;
                } else {
                    value5 = 1;
                }
                DataCanbus.PROXY.cmd(106, new int[]{70, value5}, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427615 */:
                if (DataCanbus.DATA[241] == 1) {
                    value4 = 0;
                } else {
                    value4 = 1;
                }
                DataCanbus.PROXY.cmd(106, new int[]{71, value4}, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427616 */:
                if (DataCanbus.DATA[242] == 1) {
                    value3 = 0;
                } else {
                    value3 = 1;
                }
                DataCanbus.PROXY.cmd(106, new int[]{72, value3}, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427617 */:
                if (DataCanbus.DATA[243] == 1) {
                    value2 = 0;
                } else {
                    value2 = 1;
                }
                DataCanbus.PROXY.cmd(106, new int[]{73, value2}, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427618 */:
                if (DataCanbus.DATA[244] == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(106, new int[]{74, value}, null, null);
                break;
        }
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
        DataCanbus.NOTIFY_EVENTS[231].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[232].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[233].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[234].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[235].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[236].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[237].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[238].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[239].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[240].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[241].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[242].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[243].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[244].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[245].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[246].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[231].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[232].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[233].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[234].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[235].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[236].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[237].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[238].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[239].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[240].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[241].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[242].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[243].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[244].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[245].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[246].removeNotify(this.mNotifyCanbus);
    }
}
