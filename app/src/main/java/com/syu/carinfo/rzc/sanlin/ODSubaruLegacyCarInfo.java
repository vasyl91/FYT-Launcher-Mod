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

@SuppressWarnings({"deprecation", "unchecked"})
public class ODSubaruLegacyCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 117:
                    if (value == 1) {
                        ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text1)).setText(R.string.rzc_c4l_open);
                        break;
                    } else {
                        ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text1)).setText(R.string.rzc_c4l_close);
                        break;
                    }
                case 118:
                    if (value >= 90) {
                        ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value - 90) + "°");
                        break;
                    } else {
                        ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text2)).setText("-" + (90 - value) + "°");
                        break;
                    }
                case 119:
                    if (value >= 40) {
                        ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value - 40) + "℃");
                        break;
                    } else {
                        ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text3)).setText("-" + (40 - value) + "℃");
                        break;
                    }
                case 120:
                    ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "%");
                    break;
                case 121:
                    ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + "L/100KM");
                    break;
                case 122:
                    ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + "L/100KM");
                    break;
                case 123:
                    switch (value) {
                        case 0:
                            ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text7)).setText("10s");
                            break;
                        case 2:
                            ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text7)).setText("20s");
                            break;
                        case 3:
                            ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text7)).setText("30s");
                            break;
                    }
                case 124:
                    switch (value) {
                        case 0:
                            ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text8)).setText("20s");
                            break;
                        case 2:
                            ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text8)).setText("30s");
                            break;
                        case 3:
                            ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text8)).setText("40s");
                            break;
                        case 4:
                            ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text8)).setText("50s");
                            break;
                        case 5:
                            ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text8)).setText("60s");
                            break;
                    }
                case 125:
                    ODSubaruLegacyCarInfo.this.setCheck((CheckedTextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 126:
                    switch (value) {
                        case 0:
                            ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text9)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text9)).setText("车速");
                            break;
                        case 2:
                            ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text9)).setText("切至驻车或其他档位");
                            break;
                    }
                case 127:
                    switch (value) {
                        case 0:
                            ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text10)).setText("切至驻车或其他档位");
                            break;
                        case 2:
                            ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text10)).setText("点火开关关闭");
                            break;
                        case 3:
                            ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text10)).setText("驾驶员门打开");
                            break;
                    }
                case 128:
                    switch (value) {
                        case 0:
                            ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text11)).setText("15分钟");
                            break;
                        case 1:
                            ((TextView) ODSubaruLegacyCarInfo.this.findViewById(R.id.tv_text11)).setText("持续");
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0272_od_subaru_legacy_carinfo);
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

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[123] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(7, new int[]{1, value}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[123] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(7, new int[]{1, value2}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[124] - 1;
                if (value3 < 0) {
                    value3 = 5;
                }
                DataCanbus.PROXY.cmd(7, new int[]{2, value3}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[124] + 1;
                if (value4 > 5) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(7, new int[]{2, value4}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[126] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                DataCanbus.PROXY.cmd(7, new int[]{4, value5}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[126] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                DataCanbus.PROXY.cmd(7, new int[]{4, value6}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[127] - 1;
                if (value7 < 0) {
                    value7 = 3;
                }
                DataCanbus.PROXY.cmd(7, new int[]{5, value7}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[127] + 1;
                if (value8 > 3) {
                    value8 = 0;
                }
                DataCanbus.PROXY.cmd(7, new int[]{5, value8}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[128] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                DataCanbus.PROXY.cmd(7, new int[]{6, value9}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[128] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                DataCanbus.PROXY.cmd(7, new int[]{6, value10}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value11 = DataCanbus.DATA[125];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                DataCanbus.PROXY.cmd(7, new int[]{3, value11}, null, null);
                break;
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
    }
}
