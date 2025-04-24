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
public class ODChanganLuminCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    if (((TextView) ODChanganLuminCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODChanganLuminCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODChanganLuminCarSet.this.findViewById(R.id.tv_text1)).setText("30s");
                                break;
                            case 2:
                                ((TextView) ODChanganLuminCarSet.this.findViewById(R.id.tv_text1)).setText("60s");
                                break;
                            case 3:
                                ((TextView) ODChanganLuminCarSet.this.findViewById(R.id.tv_text1)).setText("120s");
                                break;
                        }
                    }
                    break;
                case 99:
                    ODChanganLuminCarSet.this.setCheck((CheckedTextView) ODChanganLuminCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 100:
                    ODChanganLuminCarSet.this.setCheck((CheckedTextView) ODChanganLuminCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 101:
                    ODChanganLuminCarSet.this.setCheck((CheckedTextView) ODChanganLuminCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 102:
                    ODChanganLuminCarSet.this.setCheck((CheckedTextView) ODChanganLuminCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 103:
                    ODChanganLuminCarSet.this.setCheck((CheckedTextView) ODChanganLuminCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 104:
                    ODChanganLuminCarSet.this.setCheck((CheckedTextView) ODChanganLuminCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0454_od_changan_lumin_settings);
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
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[98] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[98] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(1, value2);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value3 = DataCanbus.DATA[99];
                if (value3 == 1) {
                    value3 = 0;
                } else if (value3 == 0) {
                    value3 = 1;
                }
                setCarInfo(2, value3);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value4 = DataCanbus.DATA[100];
                if (value4 == 1) {
                    value4 = 0;
                } else if (value4 == 0) {
                    value4 = 1;
                }
                setCarInfo(3, value4);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value5 = DataCanbus.DATA[101];
                if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                setCarInfo(4, value5);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value6 = DataCanbus.DATA[102];
                if (value6 == 1) {
                    value6 = 0;
                } else if (value6 == 0) {
                    value6 = 1;
                }
                setCarInfo(6, value6);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value7 = DataCanbus.DATA[103];
                if (value7 == 1) {
                    value7 = 0;
                } else if (value7 == 0) {
                    value7 = 1;
                }
                setCarInfo(5, value7);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value8 = DataCanbus.DATA[104];
                if (value8 == 1) {
                    value8 = 0;
                } else if (value8 == 0) {
                    value8 = 1;
                }
                setCarInfo(7, value8);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{102}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
    }
}
