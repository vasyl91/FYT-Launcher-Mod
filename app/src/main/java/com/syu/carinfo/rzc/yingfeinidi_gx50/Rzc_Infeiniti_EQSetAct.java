package com.syu.carinfo.rzc.yingfeinidi_gx50;

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
public class Rzc_Infeiniti_EQSetAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 123:
                    if (((TextView) Rzc_Infeiniti_EQSetAct.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) Rzc_Infeiniti_EQSetAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 124:
                    if (((TextView) Rzc_Infeiniti_EQSetAct.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) Rzc_Infeiniti_EQSetAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 125:
                    if (((TextView) Rzc_Infeiniti_EQSetAct.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) Rzc_Infeiniti_EQSetAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 126:
                    if (((TextView) Rzc_Infeiniti_EQSetAct.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) Rzc_Infeiniti_EQSetAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 127:
                    if (((TextView) Rzc_Infeiniti_EQSetAct.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) Rzc_Infeiniti_EQSetAct.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 128:
                    if (((TextView) Rzc_Infeiniti_EQSetAct.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) Rzc_Infeiniti_EQSetAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 129:
                    Rzc_Infeiniti_EQSetAct.this.setCheck((CheckedTextView) Rzc_Infeiniti_EQSetAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 130:
                    if (((TextView) Rzc_Infeiniti_EQSetAct.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) Rzc_Infeiniti_EQSetAct.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 131:
                    Rzc_Infeiniti_EQSetAct.this.setCheck((CheckedTextView) Rzc_Infeiniti_EQSetAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 132:
                    Rzc_Infeiniti_EQSetAct.this.setCheck((CheckedTextView) Rzc_Infeiniti_EQSetAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 133:
                    if (((TextView) Rzc_Infeiniti_EQSetAct.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) Rzc_Infeiniti_EQSetAct.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_rzc_infiniti_eq_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
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
                setCarInfo(40, 49);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                setCarInfo(40, 33);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                setCarInfo(43, 49);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                setCarInfo(43, 33);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value = DataCanbus.DATA[129];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(39, value);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value2 = DataCanbus.DATA[131];
                if (value2 == 1) {
                    value2 = 0;
                } else if (value2 == 0) {
                    value2 = 1;
                }
                setCarInfo(41, value2);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value3 = DataCanbus.DATA[132];
                if (value3 == 1) {
                    value3 = 0;
                } else if (value3 == 0) {
                    value3 = 1;
                }
                setCarInfo(42, value3);
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
        DataCanbus.PROXY.cmd(2, new int[]{147}, null, null);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
    }
}
