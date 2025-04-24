package com.syu.carinfo.xincheng.infiniti;

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
public class Infiniti_XinCheng_EQSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 142:
                    if (((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 143:
                    if (((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 144:
                    if (((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 145:
                    if (((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 146:
                    if (((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 147:
                    if (((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 148:
                    Infiniti_XinCheng_EQSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.ctv_checkedtext1), val == 144);
                    break;
                case 149:
                    if (((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 150:
                    Infiniti_XinCheng_EQSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.ctv_checkedtext2), val == 144);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_xincheng_infiniti_eq_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
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
                setCarInfo(40, 49);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                setCarInfo(40, 33);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int val = DataCanbus.DATA[148];
                if (val == 0) {
                    val = 1;
                } else if (val == 1) {
                    val = 0;
                }
                setCarInfo(39, val);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int val2 = DataCanbus.DATA[150];
                if (val2 == 0) {
                    val2 = 1;
                } else if (val2 == 1) {
                    val2 = 0;
                }
                setCarInfo(41, val2);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(4, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{147}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
    }
}
