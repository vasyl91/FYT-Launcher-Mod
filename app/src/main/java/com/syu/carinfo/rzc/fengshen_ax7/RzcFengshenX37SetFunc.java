package com.syu.carinfo.rzc.fengshen_ax7;

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
public class RzcFengshenX37SetFunc extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 140:
                    if (((TextView) RzcFengshenX37SetFunc.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RzcFengshenX37SetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.str_technology_blue);
                                break;
                            case 1:
                                ((TextView) RzcFengshenX37SetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.str_bright_gold);
                                break;
                            case 2:
                                ((TextView) RzcFengshenX37SetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_1);
                                break;
                        }
                    }
                    break;
                case 141:
                    if (((TextView) RzcFengshenX37SetFunc.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) RzcFengshenX37SetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.rzc_others_language_setting_1);
                                break;
                            case 2:
                                ((TextView) RzcFengshenX37SetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.rzc_others_language_setting_0);
                                break;
                            case 3:
                                ((TextView) RzcFengshenX37SetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.rzc_others_language_setting_31);
                                break;
                            case 4:
                                ((TextView) RzcFengshenX37SetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.rzc_others_language_setting_3);
                                break;
                            default:
                                ((TextView) RzcFengshenX37SetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.rzc_others_language_setting_1);
                                break;
                        }
                    }
                    break;
                case 142:
                    if (((TextView) RzcFengshenX37SetFunc.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 2:
                                ((TextView) RzcFengshenX37SetFunc.this.findViewById(R.id.tv_text2)).setText("Purple gold");
                                break;
                            default:
                                ((TextView) RzcFengshenX37SetFunc.this.findViewById(R.id.tv_text2)).setText("Disk");
                                break;
                        }
                    }
                    break;
                case 146:
                    RzcFengshenX37SetFunc.this.setCheck((CheckedTextView) RzcFengshenX37SetFunc.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_fengshen_x37_setfunc);
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
                int value = (DataCanbus.DATA[140] + 1) - 1;
                if (value < 1) {
                    value = 3;
                }
                setCarInfo(35, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[140] + 1 + 1;
                if (value2 > 3) {
                    value2 = 1;
                }
                setCarInfo(35, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[142] - 1;
                if (value3 < 1) {
                    value3 = 2;
                }
                setCarInfo(38, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[142] + 1;
                if (value4 > 2) {
                    value4 = 1;
                }
                setCarInfo(38, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[141] - 1;
                if (value5 < 1) {
                    value5 = 4;
                }
                setCarInfo(37, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[141] + 1;
                if (value6 > 4) {
                    value6 = 1;
                }
                setCarInfo(37, value6);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value7 = DataCanbus.DATA[146];
                if (value7 == 0) {
                    value7 = 1;
                } else if (value7 == 1) {
                    value7 = 0;
                }
                setCarInfo(36, value7);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
    }
}
