package com.syu.carinfo.honda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Wc_16Civic_AHDSetActi extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.Wc_16Civic_AHDSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 247:
                    if (((TextView) Wc_16Civic_AHDSetActi.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Wc_16Civic_AHDSetActi.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) Wc_16Civic_AHDSetActi.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) Wc_16Civic_AHDSetActi.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 248:
                    if (((TextView) Wc_16Civic_AHDSetActi.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Wc_16Civic_AHDSetActi.this.findViewById(R.id.tv_text2)).setText("1280x720@25Hz");
                                break;
                            case 1:
                                ((TextView) Wc_16Civic_AHDSetActi.this.findViewById(R.id.tv_text2)).setText("1280x720@30Hz");
                                break;
                        }
                    }
                    break;
                case 249:
                    if (((TextView) Wc_16Civic_AHDSetActi.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) Wc_16Civic_AHDSetActi.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(val - 100).toString());
                    }
                    break;
                case 250:
                    if (((TextView) Wc_16Civic_AHDSetActi.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) Wc_16Civic_AHDSetActi.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(val - 100).toString());
                    }
                    break;
                case 251:
                    if (((TextView) Wc_16Civic_AHDSetActi.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Wc_16Civic_AHDSetActi.this.findViewById(R.id.tv_text5)).setText("协议盒");
                                break;
                            case 1:
                                ((TextView) Wc_16Civic_AHDSetActi.this.findViewById(R.id.tv_text5)).setText("视频盒");
                                break;
                            case 2:
                                ((TextView) Wc_16Civic_AHDSetActi.this.findViewById(R.id.tv_text5)).setText("功放盒");
                                break;
                            case 3:
                                ((TextView) Wc_16Civic_AHDSetActi.this.findViewById(R.id.tv_text5)).setText("语音盒");
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
        setContentView(R.layout.layout_321_civic_ahd_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
                int value = DataCanbus.DATA[247] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(114, new int[]{1, value, 255, 255}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value2 = DataCanbus.DATA[247] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(114, new int[]{1, value2, 255, 255}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value3 = DataCanbus.DATA[248] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                DataCanbus.PROXY.cmd(114, new int[]{2, value3, 255, 255}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value4 = DataCanbus.DATA[248] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(114, new int[]{2, value4, 255, 255}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value5 = DataCanbus.DATA[249] - 1;
                if (value5 < 0) {
                    value5 = 200;
                }
                DataCanbus.PROXY.cmd(114, new int[]{3, value5, 255, 255}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value6 = DataCanbus.DATA[249] + 1;
                if (value6 > 200) {
                    value6 = 0;
                }
                DataCanbus.PROXY.cmd(114, new int[]{3, value6, 255, 255}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int value7 = DataCanbus.DATA[250] + 1;
                if (value7 > 200) {
                    value7 = 0;
                }
                DataCanbus.PROXY.cmd(114, new int[]{4, value7, 255, 255}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                int value8 = DataCanbus.DATA[251] + 1;
                if (value8 > 3) {
                    value8 = 0;
                }
                DataCanbus.PROXY.cmd(114, new int[]{5, value8, 255, 255}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                int value9 = DataCanbus.DATA[250] - 1;
                if (value9 < 0) {
                    value9 = 200;
                }
                DataCanbus.PROXY.cmd(114, new int[]{4, value9, 255, 255}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427474 */:
                int value10 = DataCanbus.DATA[251] - 1;
                if (value10 < 0) {
                    value10 = 3;
                }
                DataCanbus.PROXY.cmd(114, new int[]{5, value10, 255, 255}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[247].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[248].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[249].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[250].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[251].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[247].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[248].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[249].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[250].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[251].removeNotify(this.mNotifyCanbus);
    }
}
