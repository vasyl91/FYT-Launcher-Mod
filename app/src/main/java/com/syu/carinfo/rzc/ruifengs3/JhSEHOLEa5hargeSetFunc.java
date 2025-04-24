package com.syu.carinfo.rzc.ruifengs3;

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
public class JhSEHOLEa5hargeSetFunc extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 133:
                    if (((TextView) JhSEHOLEa5hargeSetFunc.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) JhSEHOLEa5hargeSetFunc.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "%");
                        break;
                    }
                case 134:
                    if (((TextView) JhSEHOLEa5hargeSetFunc.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) JhSEHOLEa5hargeSetFunc.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
                        break;
                    }
                case 135:
                    if (((TextView) JhSEHOLEa5hargeSetFunc.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) JhSEHOLEa5hargeSetFunc.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "%");
                        break;
                    }
                case 136:
                    JhSEHOLEa5hargeSetFunc.this.setCheck((CheckedTextView) JhSEHOLEa5hargeSetFunc.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 137:
                    if (((TextView) JhSEHOLEa5hargeSetFunc.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) JhSEHOLEa5hargeSetFunc.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 138:
                    if (((TextView) JhSEHOLEa5hargeSetFunc.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) JhSEHOLEa5hargeSetFunc.this.findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0454_od_sehol_ea5_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[135] - 10;
                if (value < 50) {
                    value = 50;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[135] + 10;
                if (value2 > 100) {
                    value2 = 100;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[137] - 1;
                if (value3 < 0) {
                    value3 = 23;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[137] + 1;
                if (value4 > 23) {
                    value4 = 0;
                }
                setCarInfo(3, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[138] - 5;
                if (value5 < 0) {
                    value5 = 55;
                }
                setCarInfo(4, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[138] + 5;
                if (value6 > 55) {
                    value6 = 0;
                }
                setCarInfo(4, value6);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value7 = DataCanbus.DATA[136];
                if (value7 == 1) {
                    value7 = 0;
                } else if (value7 == 0) {
                    value7 = 1;
                }
                setCarInfo(2, value7);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(4, new int[]{value0, value1}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(3, new int[]{67}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
    }
}
