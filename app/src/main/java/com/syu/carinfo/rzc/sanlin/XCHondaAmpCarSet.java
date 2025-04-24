package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class XCHondaAmpCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    if (((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 99:
                    if (((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 100:
                    if (((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 101:
                    if (((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 102:
                    if (((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 104:
                    if (((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 105:
                    if (((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 106:
                    if (((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_xc_honda_amp_settings);
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
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                setCarInfo(33, 49);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                setCarInfo(33, 33);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                setCarInfo(34, 49);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                setCarInfo(34, 33);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                setCarInfo(35, 49);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                setCarInfo(35, 33);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                setCarInfo(36, 49);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                setCarInfo(36, 33);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                setCarInfo(37, 49);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                setCarInfo(37, 33);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                setCarInfo(38, 49);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                setCarInfo(38, 33);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                setCarInfo(48, 49);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                setCarInfo(48, 33);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                setCarInfo(49, 49);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                setCarInfo(49, 33);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{115}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
    }
}
