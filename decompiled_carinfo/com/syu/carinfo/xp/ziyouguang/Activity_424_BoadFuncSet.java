package com.syu.carinfo.xp.ziyouguang;

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
public class Activity_424_BoadFuncSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 162:
                    if (((TextView) Activity_424_BoadFuncSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Activity_424_BoadFuncSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_5);
                                break;
                            case 2:
                                ((TextView) Activity_424_BoadFuncSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_4);
                                break;
                            case 3:
                                ((TextView) Activity_424_BoadFuncSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_3);
                                break;
                            case 4:
                                ((TextView) Activity_424_BoadFuncSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_6);
                                break;
                            case 6:
                                ((TextView) Activity_424_BoadFuncSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_7);
                                break;
                        }
                    }
                    break;
                case 163:
                    if (((TextView) Activity_424_BoadFuncSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Activity_424_BoadFuncSet.this.findViewById(R.id.tv_text2)).setText("Style1");
                                break;
                            case 2:
                                ((TextView) Activity_424_BoadFuncSet.this.findViewById(R.id.tv_text2)).setText("Style2");
                                break;
                            case 3:
                                ((TextView) Activity_424_BoadFuncSet.this.findViewById(R.id.tv_text2)).setText("Style3");
                                break;
                            case 4:
                                ((TextView) Activity_424_BoadFuncSet.this.findViewById(R.id.tv_text2)).setText("Style4");
                                break;
                        }
                    }
                    break;
                case 164:
                    if (((TextView) Activity_424_BoadFuncSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) Activity_424_BoadFuncSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 165:
                    Activity_424_BoadFuncSet.this.setCheck((CheckedTextView) Activity_424_BoadFuncSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0424_xp_dashboard_settings);
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
                int value = DataCanbus.DATA[162];
                if (value == 1) {
                    value = 6;
                } else if (value == 2) {
                    value = 1;
                } else if (value == 3) {
                    value = 2;
                } else if (value == 4) {
                    value = 3;
                } else if (value == 6) {
                    value = 4;
                }
                setCarInfo(112, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[162];
                if (value2 == 1) {
                    value2 = 2;
                } else if (value2 == 2) {
                    value2 = 3;
                } else if (value2 == 3) {
                    value2 = 4;
                } else if (value2 == 4) {
                    value2 = 6;
                } else if (value2 == 6) {
                    value2 = 1;
                }
                setCarInfo(112, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[163] - 1;
                if (value3 < 1) {
                    value3 = 4;
                }
                setCarInfo(113, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[163] + 1;
                if (value4 > 4) {
                    value4 = 1;
                }
                setCarInfo(113, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[164] - 5;
                if (value5 < 0) {
                    value5 = 0;
                }
                setCarInfo(114, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[164] + 5;
                if (value6 > 100) {
                    value6 = 100;
                }
                setCarInfo(114, value6);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value7 = DataCanbus.DATA[165];
                if (value7 == 0) {
                    value7 = 1;
                } else if (value7 == 1) {
                    value7 = 0;
                }
                setCarInfo(115, value7);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{97}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
    }
}
