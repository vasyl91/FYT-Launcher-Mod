package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Activity_424_AmpFuncSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_424_AmpFuncSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 166:
                    if ((value & 128) != 0) {
                        ((TextView) Activity_424_AmpFuncSet.this.findViewById(R.id.tv_text5)).setText("-" + (256 - value));
                    } else if ((value & 128) == 0 && value != 0) {
                        ((TextView) Activity_424_AmpFuncSet.this.findViewById(R.id.tv_text5)).setText("+" + value);
                    } else {
                        ((TextView) Activity_424_AmpFuncSet.this.findViewById(R.id.tv_text5)).setText("0");
                    }
                    break;
                case 167:
                    if ((value & 128) != 0) {
                        ((TextView) Activity_424_AmpFuncSet.this.findViewById(R.id.tv_text4)).setText("-" + (256 - value));
                    } else if ((value & 128) == 0 && value != 0) {
                        ((TextView) Activity_424_AmpFuncSet.this.findViewById(R.id.tv_text4)).setText("+" + value);
                    } else {
                        ((TextView) Activity_424_AmpFuncSet.this.findViewById(R.id.tv_text4)).setText("0");
                    }
                    break;
                case 168:
                    if ((value & 128) != 0) {
                        ((TextView) Activity_424_AmpFuncSet.this.findViewById(R.id.tv_text2)).setText("F" + (256 - value));
                    } else if ((value & 128) == 0 && value != 0) {
                        ((TextView) Activity_424_AmpFuncSet.this.findViewById(R.id.tv_text2)).setText("R" + value);
                    } else {
                        ((TextView) Activity_424_AmpFuncSet.this.findViewById(R.id.tv_text2)).setText("0");
                    }
                    break;
                case 169:
                    if ((value & 128) != 0) {
                        ((TextView) Activity_424_AmpFuncSet.this.findViewById(R.id.tv_text3)).setText("L" + (256 - value));
                    } else if ((value & 128) == 0 && value != 0) {
                        ((TextView) Activity_424_AmpFuncSet.this.findViewById(R.id.tv_text3)).setText("R" + value);
                    } else {
                        ((TextView) Activity_424_AmpFuncSet.this.findViewById(R.id.tv_text3)).setText("0");
                    }
                    break;
                case 170:
                    switch (value) {
                        case 0:
                            ((TextView) Activity_424_AmpFuncSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_centered);
                            break;
                        case 1:
                            ((TextView) Activity_424_AmpFuncSet.this.findViewById(R.id.tv_text6)).setText(R.string.front_volumn);
                            break;
                        case 2:
                            ((TextView) Activity_424_AmpFuncSet.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_Manual);
                            break;
                    }
                    break;
                case 171:
                    ((TextView) Activity_424_AmpFuncSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0424_xp_renault_amp_settings);
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
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
                setCarAmpInfo(198, 0);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                setCarAmpInfo(198, 1);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                setCarAmpInfo(195, 0);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                setCarAmpInfo(195, 1);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                setCarAmpInfo(196, 0);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                setCarAmpInfo(196, 1);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                setCarAmpInfo(194, 1);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                setCarAmpInfo(192, 1);
                break;
            case R.id.btn_plus6 /* 2131427430 */:
                int value = DataCanbus.DATA[170] + 1;
                if (value > 2) {
                    value = 0;
                }
                setCarAmpInfo(197, value);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                setCarAmpInfo(194, 0);
                break;
            case R.id.btn_minus5 /* 2131427474 */:
                setCarAmpInfo(192, 0);
                break;
            case R.id.btn_minus6 /* 2131427476 */:
                int value2 = DataCanbus.DATA[170] - 1;
                if (value2 < 0) {
                    value2 = 2;
                }
                setCarAmpInfo(197, value2);
                break;
        }
    }

    void setCarAmpInfo(int value0, int value1) {
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
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
    }
}
