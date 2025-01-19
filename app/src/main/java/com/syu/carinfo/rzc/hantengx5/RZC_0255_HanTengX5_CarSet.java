package com.syu.carinfo.rzc.hantengx5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RZC_0255_HanTengX5_CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 140:
                    if (((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 141:
                    if (((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 142:
                    if (((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value == 1) {
                            ((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text3)).setText("℃");
                            break;
                        } else {
                            ((TextView) RZC_0255_HanTengX5_CarSet.this.findViewById(R.id.tv_text3)).setText("℉");
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
        //setContentView(R.layout.layout_0255_rzc_hantengx5_settings);
        init();
    }

    @Override
    public void init() {
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
                int value = DataCanbus.DATA[140];
                if (value > 0) {
                    value--;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[140];
                if (value2 < 15) {
                    value2++;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[141];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(1, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[141];
                if (value4 < 15) {
                    value4++;
                }
                setCarInfo(1, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
            case R.id.btn_plus3 /* 2131427463 */:
                int value5 = DataCanbus.DATA[142];
                if (value5 == 0) {
                    value5 = 1;
                } else if (value5 == 1) {
                    value5 = 0;
                }
                setCarInfo(0, value5);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
    }
}
