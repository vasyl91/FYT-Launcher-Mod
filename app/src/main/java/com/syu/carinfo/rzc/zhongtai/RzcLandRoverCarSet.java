package com.syu.carinfo.rzc.zhongtai;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RzcLandRoverCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 189:
                    RzcLandRoverCarSet.this.setCheck((CheckedTextView) RzcLandRoverCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 190:
                    if (((TextView) RzcLandRoverCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) RzcLandRoverCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 191:
                    if (((TextView) RzcLandRoverCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) RzcLandRoverCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_5);
                                break;
                            case 2:
                                ((TextView) RzcLandRoverCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_2);
                                break;
                            case 3:
                                ((TextView) RzcLandRoverCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.color_white_str);
                                break;
                            case 4:
                                ((TextView) RzcLandRoverCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_8);
                                break;
                            case 5:
                                ((TextView) RzcLandRoverCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_3);
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
        //setContentView(R.layout.layout_0452_rzc_landerover_settings);
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
                int value = DataCanbus.DATA[190];
                if (value > 1) {
                    value--;
                }
                setCarInfo(154, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[190];
                if (value2 < 4) {
                    value2++;
                }
                setCarInfo(154, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[191] - 1;
                if (value3 < 1) {
                    value3 = 5;
                }
                setCarInfo(155, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[191] + 1;
                if (value4 > 5) {
                    value4 = 1;
                }
                setCarInfo(155, value4);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value5 = DataCanbus.DATA[189];
                if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                setCarInfo(153, value5);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
    }
}
