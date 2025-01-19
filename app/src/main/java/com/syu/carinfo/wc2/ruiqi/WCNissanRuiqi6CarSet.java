package com.syu.carinfo.wc2.ruiqi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class WCNissanRuiqi6CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 116:
                    ((CheckedTextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
                case 117:
                    ((CheckedTextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
                case 118:
                    ((CheckedTextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 119:
                    ((CheckedTextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                    break;
                case 125:
                    ((CheckedTextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
                    break;
                case 126:
                    if (((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_out_sync);
                                break;
                            case 1:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_sync_open);
                                break;
                            case 2:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_sync_close);
                                break;
                            case 3:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_sync_all);
                                break;
                        }
                    }
                    break;
                case 127:
                    if (((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_golf_normal);
                                break;
                            case 1:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_golf_comfort);
                                break;
                            case 2:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_driving_sport);
                                break;
                            case 3:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.jeep_playstate11);
                                break;
                        }
                    }
                    break;
                case 128:
                    if (((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text3)).setText("30s");
                                break;
                            case 2:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text3)).setText("1min");
                                break;
                            case 3:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text3)).setText("2min");
                                break;
                            case 4:
                                ((TextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.tv_text3)).setText("5min");
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_nissan_ruiqi_settings);
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
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
        findViewById(R.id.layout_view5).setVisibility(8);
        findViewById(R.id.layout_view6).setVisibility(8);
        findViewById(R.id.layout_view7).setVisibility(8);
        findViewById(R.id.layout_view8).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_443_WC2_Nissan_Ruiqi /* 1704379 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                break;
            case FinalCanbus.CAR_444_WC2_Dongfeng_Xiaokang_Ix5 /* 1835452 */:
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                break;
            case FinalCanbus.CAR_443_WC2_Nissan_Ruiqi7 /* 7799227 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[126] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(0, new int[]{26, value}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[126] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{26, value2}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[127] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value3}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[127] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value4}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[128] - 1;
                if (value5 < 0) {
                    value5 = 4;
                }
                DataCanbus.PROXY.cmd(0, new int[]{27, value5}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[128] + 1;
                if (value6 > 4) {
                    value6 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{27, value6}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value7 = DataCanbus.DATA[116];
                if (value7 == 0) {
                    value7 = 1;
                } else if (value7 == 1) {
                    value7 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value7}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value8 = DataCanbus.DATA[117];
                if (value8 == 0) {
                    value8 = 1;
                } else if (value8 == 1) {
                    value8 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{2, value8}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value9 = DataCanbus.DATA[118];
                if (value9 == 0) {
                    value9 = 1;
                } else if (value9 == 1) {
                    value9 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{3, value9}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value10 = DataCanbus.DATA[119];
                if (value10 == 0) {
                    value10 = 1;
                } else if (value10 == 1) {
                    value10 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{4, value10}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value11 = DataCanbus.DATA[125];
                if (value11 == 0) {
                    value11 = 1;
                } else if (value11 == 1) {
                    value11 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{5, value11}, null, null);
                break;
        }
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
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
    }
}
