package com.syu.carinfo.rzc.haima;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ODJianglingSetFunc extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 103:
                    ODJianglingSetFunc.this.setCheck((CheckedTextView) ODJianglingSetFunc.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 104:
                    if (((TextView) ODJianglingSetFunc.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODJianglingSetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.klc_Parking_with_trailer_Off);
                                break;
                            case 1:
                                ((TextView) ODJianglingSetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.klc_Parking_with_trailer_ON);
                                break;
                            case 2:
                                ((TextView) ODJianglingSetFunc.this.findViewById(R.id.tv_text1)).setText("随小灯关闭");
                                break;
                        }
                    }
                    break;
                case 105:
                    if (((TextView) ODJianglingSetFunc.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODJianglingSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODJianglingSetFunc.this.findViewById(R.id.tv_text2)).setText("30s");
                                break;
                            case 2:
                                ((TextView) ODJianglingSetFunc.this.findViewById(R.id.tv_text2)).setText("60s");
                                break;
                            case 3:
                                ((TextView) ODJianglingSetFunc.this.findViewById(R.id.tv_text2)).setText("90s");
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
        //setContentView(R.layout.layout_0422_od_jiangling_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[104] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(151, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[104] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(151, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[105] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(152, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[105] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(152, value4);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value5 = DataCanbus.DATA[103];
                if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                setCarInfo(150, value5);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(3, new int[]{65}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
    }
}
