package com.syu.carinfo.rzc.sanlin;

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
public class ODCHuangWeiET5CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    if (((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value == 1) {
                            ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                            break;
                        } else {
                            ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                            break;
                        }
                    }
                    break;
                case 114:
                    if (((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "%");
                        break;
                    }
                case 115:
                    ODCHuangWeiET5CarSet.this.setCheck((CheckedTextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 116:
                    ODCHuangWeiET5CarSet.this.setCheck((CheckedTextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 117:
                    ODCHuangWeiET5CarSet.this.setCheck((CheckedTextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 118:
                    ODCHuangWeiET5CarSet.this.setCheck((CheckedTextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 119:
                    if (((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text3)).setText("60 KM/h");
                                break;
                            case 2:
                                ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text3)).setText("70 KM/h");
                                break;
                            case 3:
                                ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text3)).setText("80 KM/h");
                                break;
                            case 4:
                                ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text3)).setText("90 KM/h");
                                break;
                            case 5:
                                ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text3)).setText("100 KM/h");
                                break;
                            case 6:
                                ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text3)).setText("110 KM/h");
                                break;
                            case 7:
                                ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text3)).setText("120 KM/h");
                                break;
                            case 8:
                                ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text3)).setText("130 KM/h");
                                break;
                            case 9:
                                ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text3)).setText("140 KM/h");
                                break;
                        }
                    }
                    break;
                case 120:
                    ODCHuangWeiET5CarSet.this.setCheck((CheckedTextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 121:
                    ODCHuangWeiET5CarSet.this.setCheck((CheckedTextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 122:
                    ODCHuangWeiET5CarSet.this.setCheck((CheckedTextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 123:
                    ODCHuangWeiET5CarSet.this.setCheck((CheckedTextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 124:
                    ODCHuangWeiET5CarSet.this.setCheck((CheckedTextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 125:
                    if (((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) ODCHuangWeiET5CarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_od_chuangwei_et5_settings);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
            case R.id.btn_plus1 /* 2131427457 */:
                int value = DataCanbus.DATA[98];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value2 = DataCanbus.DATA[114];
                if (value2 > 20) {
                    value2--;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value3 = DataCanbus.DATA[114];
                if (value3 < 100) {
                    value3++;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value4 = DataCanbus.DATA[119];
                if (value4 > 0) {
                    value4--;
                }
                setCarInfo(7, value4);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value5 = DataCanbus.DATA[119];
                if (value5 < 9) {
                    value5++;
                }
                setCarInfo(7, value5);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value6 = DataCanbus.DATA[125];
                if (value6 > 0) {
                    value6--;
                }
                setCarInfo(13, value6);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value7 = DataCanbus.DATA[125];
                if (value7 < 3) {
                    value7++;
                }
                setCarInfo(13, value7);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value8 = DataCanbus.DATA[115];
                if (value8 == 1) {
                    value8 = 0;
                } else if (value8 == 0) {
                    value8 = 1;
                }
                setCarInfo(3, value8);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value9 = DataCanbus.DATA[116];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(4, value9);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value10 = DataCanbus.DATA[117];
                if (value10 == 1) {
                    value10 = 0;
                } else if (value10 == 0) {
                    value10 = 1;
                }
                setCarInfo(5, value10);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value11 = DataCanbus.DATA[118];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(6, value11);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value12 = DataCanbus.DATA[120];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                setCarInfo(8, value12);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value13 = DataCanbus.DATA[121];
                if (value13 == 1) {
                    value13 = 0;
                } else if (value13 == 0) {
                    value13 = 1;
                }
                setCarInfo(9, value13);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value14 = DataCanbus.DATA[122];
                if (value14 == 1) {
                    value14 = 0;
                } else if (value14 == 0) {
                    value14 = 1;
                }
                setCarInfo(10, value14);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value15 = DataCanbus.DATA[123];
                if (value15 == 1) {
                    value15 = 0;
                } else if (value15 == 0) {
                    value15 = 1;
                }
                setCarInfo(11, value15);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value16 = DataCanbus.DATA[124];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(12, value16);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
    }
}
