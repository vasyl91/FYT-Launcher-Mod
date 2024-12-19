package com.syu.carinfo.xfy.dx7;

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
public class XfyZhV3CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xfy.dx7.XfyZhV3CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 34:
                    XfyZhV3CarSet.this.setCheck((CheckedTextView) XfyZhV3CarSet.this.findViewById(R.id.ctv_checkedtext1), val != 0);
                    break;
                case 35:
                    XfyZhV3CarSet.this.updateDoorUnlock(val);
                    break;
                case 36:
                    XfyZhV3CarSet.this.setCheck((CheckedTextView) XfyZhV3CarSet.this.findViewById(R.id.ctv_checkedtext2), val != 0);
                    break;
                case 37:
                    XfyZhV3CarSet.this.setCheck((CheckedTextView) XfyZhV3CarSet.this.findViewById(R.id.ctv_checkedtext3), val != 0);
                    break;
                case 38:
                    XfyZhV3CarSet.this.setCheck((CheckedTextView) XfyZhV3CarSet.this.findViewById(R.id.ctv_checkedtext4), val != 0);
                    break;
                case 39:
                    XfyZhV3CarSet.this.setCheck((CheckedTextView) XfyZhV3CarSet.this.findViewById(R.id.ctv_checkedtext5), val != 0);
                    break;
                case 40:
                    XfyZhV3CarSet.this.updateBacklightMeter(val);
                    break;
                case 41:
                    XfyZhV3CarSet.this.updateTimeFormat(val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0326_xfy_zhonghuav3_settings);
        setListener();
    }

    private void setListener() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
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
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                if (DataCanbus.DATA[34] == 0) {
                    value5 = 1;
                } else {
                    value5 = 0;
                }
                setCarInfo(1, value5);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value6 = DataCanbus.DATA[35] - 1;
                if (value6 < 0) {
                    value6 = 1;
                }
                setCarInfo(2, value6);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value7 = DataCanbus.DATA[35] + 1;
                if (value7 > 1) {
                    value7 = 0;
                }
                setCarInfo(2, value7);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value8 = DataCanbus.DATA[40] - 1;
                if (value8 < 0) {
                    value8 = 8;
                }
                setCarInfo(7, value8);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value9 = DataCanbus.DATA[40] + 1;
                if (value9 > 8) {
                    value9 = 0;
                }
                setCarInfo(7, value9);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value10 = DataCanbus.DATA[41] - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarInfo(9, value10);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value11 = DataCanbus.DATA[41] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo(9, value11);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                if (DataCanbus.DATA[36] == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                setCarInfo(3, value4);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                if (DataCanbus.DATA[37] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                setCarInfo(4, value3);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                if (DataCanbus.DATA[38] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                setCarInfo(5, value2);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                if (DataCanbus.DATA[39] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(6, value);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDoorUnlock(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBacklightMeter(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTimeFormat(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_bogoo_bmw_time_format_1);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_bogoo_bmw_time_format_0);
                    break;
            }
        }
    }
}
