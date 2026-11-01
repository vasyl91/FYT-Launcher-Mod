package com.syu.carinfo.guochan;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityWC20Baojun530Info extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 100:
                    ActivityWC20Baojun530Info.this.setCheck((CheckedTextView) ActivityWC20Baojun530Info.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 101:
                    ActivityWC20Baojun530Info.this.setCheck((CheckedTextView) ActivityWC20Baojun530Info.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 102:
                    ActivityWC20Baojun530Info.this.setCheck((CheckedTextView) ActivityWC20Baojun530Info.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 103:
                    ActivityWC20Baojun530Info.this.setCheck((CheckedTextView) ActivityWC20Baojun530Info.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 104:
                    if (((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text1)).setText("30s");
                                break;
                            case 2:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text1)).setText("50s");
                                break;
                            case 3:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text1)).setText("70s");
                                break;
                        }
                    }
                    break;
                case 105:
                    if (((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text2)).setText("10min");
                                break;
                            case 1:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text2)).setText("20min");
                                break;
                            case 2:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text2)).setText("30min");
                                break;
                        }
                    }
                    break;
                case 106:
                    ActivityWC20Baojun530Info.this.setCheck((CheckedTextView) ActivityWC20Baojun530Info.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 107:
                    ActivityWC20Baojun530Info.this.setCheck((CheckedTextView) ActivityWC20Baojun530Info.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 108:
                    if (((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text3)).setText("闪灯");
                                break;
                            case 1:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text3)).setText("闪灯+鸣笛");
                                break;
                        }
                    }
                    break;
                case 109:
                    ActivityWC20Baojun530Info.this.setCheck((CheckedTextView) ActivityWC20Baojun530Info.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 110:
                    ActivityWC20Baojun530Info.this.setCheck((CheckedTextView) ActivityWC20Baojun530Info.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 111:
                    if (((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text4)).setText("闪灯");
                                break;
                            case 1:
                                ((TextView) ActivityWC20Baojun530Info.this.findViewById(R.id.tv_text4)).setText("闪灯+鸣笛");
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
        //setContentView(R.layout.layout_0246_wc_20baojun530_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[104] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(6, value, 255, 255);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[104] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(6, value2, 255, 255);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[105] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(5, value3, 255, 255);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[105] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(5, value4, 255, 255);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[108] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(2, value5, 255, 255);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[108] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(2, value6, 255, 255);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[111] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(7, value7, 255, 255);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[111] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(7, value8, 255, 255);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCarAirInfo(72);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCarAirInfo(73);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                setCarAirInfo(74);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                setCarAirInfo(75);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                setCarInfo(4, DataCanbus.DATA[106] != 0 ? 0 : 1, 255, 255);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                setCarInfo(3, DataCanbus.DATA[107] != 0 ? 0 : 1, 255, 255);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                setCarInfo(1, DataCanbus.DATA[109] == 0 ? 1 : 0, 255, 255);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                setCarInfo(8, DataCanbus.DATA[110] != 0 ? 0 : 1, 255, 255);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1, value2, value3}, null, null);
    }

    public void setCarAirInfo(int value0) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, 1}, null, null);
        SystemClock.sleep(200L);
        DataCanbus.PROXY.cmd(1, new int[]{value0}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
    }
}
