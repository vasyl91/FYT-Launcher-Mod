package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
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
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[193] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(1, value, 255, 255);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[193] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(1, value2, 255, 255);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[194] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(40, value3, 255, 255);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[194] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(40, value4, 255, 255);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[195];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(41, value5, 255, 255);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[195];
                if (value6 < 36) {
                    value6++;
                }
                setCarInfo(41, value6, 255, 255);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(7, new int[]{value0, value1, value2, value3}, null, null);
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
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
    }
}
