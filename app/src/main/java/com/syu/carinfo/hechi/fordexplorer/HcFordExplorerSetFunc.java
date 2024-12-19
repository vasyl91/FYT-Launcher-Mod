package com.syu.carinfo.hechi.fordexplorer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class HcFordExplorerSetFunc extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.hechi.fordexplorer.HcFordExplorerSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 39:
                    HcFordExplorerSetFunc.this.updateText1(val);
                    break;
                case 40:
                    HcFordExplorerSetFunc.this.updateText2(val);
                    break;
                case 41:
                    HcFordExplorerSetFunc.this.updateText3(val);
                    break;
                case 42:
                    HcFordExplorerSetFunc.this.updateText4(val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_hc_ford_explorer_settings);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427480 */:
                int value3 = DataCanbus.DATA[39] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(84, value3);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value4 = DataCanbus.DATA[39] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(84, value4);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value5 = DataCanbus.DATA[40] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(82, value5);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value6 = DataCanbus.DATA[40] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(82, value6);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                if (DataCanbus.DATA[41] == 1) {
                    value2 = 8;
                } else {
                    value2 = 1;
                }
                setCarInfo(83, value2);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                if (DataCanbus.DATA[41] == 8) {
                    value = 1;
                } else {
                    value = 8;
                }
                setCarInfo(83, value);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value7 = DataCanbus.DATA[42] - 1;
                if (value7 < 1) {
                    value7 = 7;
                }
                setCarInfo(97, value7);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value8 = DataCanbus.DATA[42] + 1;
                if (value8 > 7) {
                    value8 = 1;
                }
                setCarInfo(97, value8);
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
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText4(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.color_ice_blue);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.color_orange_str);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_403_ambient_2);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_403_ambient_3);
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_403_ambient_4);
                    break;
                case 6:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_403_ambient_5);
                    break;
                case 7:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_403_ambient_6);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.color_ice_blue);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText3(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.rzc_others_language_setting_0);
                    break;
                case 8:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.rzc_others_language_setting_1);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.rzc_others_language_setting_1);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText2(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Km");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Mi");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText1(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText("℃");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText("℉");
                    break;
            }
        }
    }
}
