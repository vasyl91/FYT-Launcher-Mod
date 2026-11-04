package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class WCHavalAllScreenCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.WCHavalAllScreenCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 193:
                    if (((TextView) WCHavalAllScreenCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value == 1) {
                            ((TextView) WCHavalAllScreenCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_video_box_upgrade);
                        } else {
                            ((TextView) WCHavalAllScreenCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_protocol_box_upgrade);
                        }
                    }
                    break;
                case 194:
                    if (((TextView) WCHavalAllScreenCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value == 1) {
                            ((TextView) WCHavalAllScreenCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_244_als2);
                        } else {
                            ((TextView) WCHavalAllScreenCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_244_als1);
                        }
                    }
                    break;
                case 195:
                    if (((TextView) WCHavalAllScreenCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) WCHavalAllScreenCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
                case 196:
                    if (((TextView) WCHavalAllScreenCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) WCHavalAllScreenCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value - 100)).toString());
                    }
                    break;
                case 197:
                    if (((TextView) WCHavalAllScreenCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) WCHavalAllScreenCarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value - 100)).toString());
                    }
                    break;
                case 198:
                    WCHavalAllScreenCarSet.this.setCheck((CheckedTextView) WCHavalAllScreenCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0320_wc2_haval_sceen_settings);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
                int value = DataCanbus.DATA[193] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(1, value, 255, 255);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value2 = DataCanbus.DATA[193] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(1, value2, 255, 255);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value3 = DataCanbus.DATA[194] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(40, value3, 255, 255);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value4 = DataCanbus.DATA[194] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(40, value4, 255, 255);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value5 = DataCanbus.DATA[195];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(41, value5, 255, 255);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value6 = DataCanbus.DATA[195];
                if (value6 < 36) {
                    value6++;
                }
                setCarInfo(41, value6, 255, 255);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int value7 = DataCanbus.DATA[196];
                if (value7 < 200) {
                    value7++;
                }
                setCarAHDInfo(3, value7, 255, 255);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                int value8 = DataCanbus.DATA[197];
                if (value8 < 200) {
                    value8++;
                }
                setCarAHDInfo(4, value8, 255, 255);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                int value9 = DataCanbus.DATA[196];
                if (value9 > 0) {
                    value9--;
                }
                setCarAHDInfo(3, value9, 255, 255);
                break;
            case R.id.btn_minus5 /* 2131427474 */:
                int value10 = DataCanbus.DATA[197];
                if (value10 > 0) {
                    value10--;
                }
                setCarAHDInfo(4, value10, 255, 255);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                int value11 = DataCanbus.DATA[198];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 9;
                iArr[1] = value11 != 1 ? 1 : 0;
                remoteModuleProxy.cmd(14, iArr, null, null);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(7, new int[]{value0, value1, value2, value3}, null, null);
    }

    public void setCarAHDInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(13, new int[]{value0, value1, value2, value3}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
    }
}
