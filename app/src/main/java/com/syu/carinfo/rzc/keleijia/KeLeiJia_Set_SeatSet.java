package com.syu.carinfo.rzc.keleijia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class KeLeiJia_Set_SeatSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 164:
                    KeLeiJia_Set_SeatSet.this.setCheck((CheckedTextView) KeLeiJia_Set_SeatSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 165:
                    KeLeiJia_Set_SeatSet.this.updateText1(val);
                    break;
                case 166:
                    KeLeiJia_Set_SeatSet.this.updateText2(val);
                    break;
                case 167:
                    KeLeiJia_Set_SeatSet.this.updateText3(val);
                    break;
                case 196:
                    KeLeiJia_Set_SeatSet.this.setCheck((CheckedTextView) KeLeiJia_Set_SeatSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 197:
                    if (((TextView) KeLeiJia_Set_SeatSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) KeLeiJia_Set_SeatSet.this.findViewById(R.id.tv_text4)).setText("Tonic");
                                break;
                            case 2:
                                ((TextView) KeLeiJia_Set_SeatSet.this.findViewById(R.id.tv_text4)).setText("Relaxing");
                                break;
                            case 3:
                                ((TextView) KeLeiJia_Set_SeatSet.this.findViewById(R.id.tv_text4)).setText("Lumbar");
                                break;
                        }
                    }
                    break;
                case 198:
                    if (((TextView) KeLeiJia_Set_SeatSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) KeLeiJia_Set_SeatSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 199:
                    if (((TextView) KeLeiJia_Set_SeatSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) KeLeiJia_Set_SeatSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 200:
                    if (((TextView) KeLeiJia_Set_SeatSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) KeLeiJia_Set_SeatSet.this.findViewById(R.id.tv_text7)).setText("Default");
                                break;
                            case 1:
                                ((TextView) KeLeiJia_Set_SeatSet.this.findViewById(R.id.tv_text7)).setText("Save");
                                break;
                            case 2:
                                ((TextView) KeLeiJia_Set_SeatSet.this.findViewById(R.id.tv_text7)).setText("Mobilize");
                                break;
                        }
                    }
                    break;
                case 201:
                    KeLeiJia_Set_SeatSet.this.setCheck((CheckedTextView) KeLeiJia_Set_SeatSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 202:
                    KeLeiJia_Set_SeatSet.this.setCheck((CheckedTextView) KeLeiJia_Set_SeatSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 203:
                    KeLeiJia_Set_SeatSet.this.setCheck((CheckedTextView) KeLeiJia_Set_SeatSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0402_rzc_meganeh_seat_settings);
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
                int value = DataCanbus.DATA[165] - 1;
                if (value < 1) {
                    value = 3;
                }
                setCarInfo(145, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[165] + 1;
                if (value2 > 3) {
                    value2 = 1;
                }
                setCarInfo(145, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[166] - 1;
                if (value3 < 1) {
                    value3 = 5;
                }
                setCarInfo(146, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[166] + 1;
                if (value4 > 5) {
                    value4 = 1;
                }
                setCarInfo(146, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[167] - 1;
                if (value5 < 1) {
                    value5 = 5;
                }
                setCarInfo(147, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[167] + 1;
                if (value6 > 5) {
                    value6 = 1;
                }
                setCarInfo(147, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[197] - 1;
                if (value7 < 1) {
                    value7 = 3;
                }
                setCarInfo(149, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[197] + 1;
                if (value8 > 3) {
                    value8 = 1;
                }
                setCarInfo(149, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[198] - 1;
                if (value9 < 1) {
                    value9 = 5;
                }
                setCarInfo(150, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[198] + 1;
                if (value10 > 5) {
                    value10 = 1;
                }
                setCarInfo(150, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[199] - 1;
                if (value11 < 1) {
                    value11 = 5;
                }
                setCarInfo(151, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[199] + 1;
                if (value12 > 5) {
                    value12 = 1;
                }
                setCarInfo(151, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[200] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                setCarInfo(152, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[200] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                setCarInfo(152, value14);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value15 = DataCanbus.DATA[164];
                if (value15 == 1) {
                    value15 = 0;
                } else if (value15 == 0) {
                    value15 = 1;
                }
                setCarInfo(144, value15);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCarInfo(128, 6);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value16 = DataCanbus.DATA[196];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(148, value16);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value17 = DataCanbus.DATA[201];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(153, value17);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value18 = DataCanbus.DATA[202];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(154, value18);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value19 = DataCanbus.DATA[203];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(155, value19);
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
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateText3(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void updateText2(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void updateText1(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText("Tonic");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text1)).setText("Relaxing");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text1)).setText("Lumbar");
                    break;
            }
        }
    }
}
