package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ODWeimaEx5CarSet extends BaseActivity {
    private SeekBar.OnSeekBarChangeListener mseekbarClick = new SeekBar.OnSeekBarChangeListener() { 
        @Override
        public void onStopTrackingTouch(SeekBar v) {
            switch (v.getId()) {
                case R.id.seekbar_checkedtext1 /* 2131428638 */:
                    ODWeimaEx5CarSet.this.setCarInfo(6, v.getProgress() + 40);
                    break;
            }
        }

        @Override
        public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
        }

        @Override
        public void onStartTrackingTouch(SeekBar arg0) {
        }
    };
    private View.OnClickListener mClick = new View.OnClickListener() { 
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427455 */:
                    int value = DataCanbus.DATA[114] - 1;
                    if (value < 0) {
                        value = 1;
                    }
                    ODWeimaEx5CarSet.this.setCarInfo(4, value);
                    break;
                case R.id.btn_plus1 /* 2131427457 */:
                    int value2 = DataCanbus.DATA[114] + 1;
                    if (value2 > 1) {
                        value2 = 0;
                    }
                    ODWeimaEx5CarSet.this.setCarInfo(4, value2);
                    break;
                case R.id.btn_minus2 /* 2131427458 */:
                    int value3 = DataCanbus.DATA[115] - 1;
                    if (value3 < 0) {
                        value3 = 2;
                    }
                    ODWeimaEx5CarSet.this.setCarInfo(5, value3);
                    break;
                case R.id.btn_plus2 /* 2131427460 */:
                    int value4 = DataCanbus.DATA[115] + 1;
                    if (value4 > 2) {
                        value4 = 0;
                    }
                    ODWeimaEx5CarSet.this.setCarInfo(5, value4);
                    break;
                case R.id.btn_minus3 /* 2131427461 */:
                    int value5 = DataCanbus.DATA[126] - 1;
                    if (value5 < 0) {
                        value5 = 2;
                    }
                    ODWeimaEx5CarSet.this.setCarInfo(255, value5);
                    break;
                case R.id.btn_plus3 /* 2131427463 */:
                    int value6 = DataCanbus.DATA[126] + 1;
                    if (value6 > 2) {
                        value6 = 0;
                    }
                    ODWeimaEx5CarSet.this.setCarInfo(255, value6);
                    break;
                case R.id.btn_minus4 /* 2131427464 */:
                    int value7 = DataCanbus.DATA[117] - 1;
                    if (value7 < 0) {
                        value7 = 3;
                    }
                    ODWeimaEx5CarSet.this.setCarInfo(14, value7);
                    break;
                case R.id.btn_plus4 /* 2131427466 */:
                    int value8 = DataCanbus.DATA[117] + 1;
                    if (value8 > 3) {
                        value8 = 0;
                    }
                    ODWeimaEx5CarSet.this.setCarInfo(14, value8);
                    break;
                case R.id.btn_minus5 /* 2131427467 */:
                    int value9 = DataCanbus.DATA[125] - 1;
                    if (value9 < 0) {
                        value9 = 1;
                    }
                    ODWeimaEx5CarSet.this.setCarInfo(15, value9);
                    break;
                case R.id.btn_plus5 /* 2131427469 */:
                    int value10 = DataCanbus.DATA[125] + 1;
                    if (value10 > 1) {
                        value10 = 0;
                    }
                    ODWeimaEx5CarSet.this.setCarInfo(15, value10);
                    break;
                case R.id.ctv_checkedtext1 /* 2131427525 */:
                    int value11 = DataCanbus.DATA[111];
                    if (value11 == 1) {
                        value11 = 0;
                    } else if (value11 == 0) {
                        value11 = 1;
                    }
                    ODWeimaEx5CarSet.this.setCarInfo(1, value11);
                    break;
                case R.id.ctv_checkedtext2 /* 2131427541 */:
                    int value12 = DataCanbus.DATA[112];
                    if (value12 == 1) {
                        value12 = 0;
                    } else if (value12 == 0) {
                        value12 = 1;
                    }
                    ODWeimaEx5CarSet.this.setCarInfo(2, value12);
                    break;
                case R.id.ctv_checkedtext3 /* 2131427542 */:
                    int value13 = DataCanbus.DATA[113];
                    if (value13 == 1) {
                        value13 = 0;
                    } else if (value13 == 0) {
                        value13 = 1;
                    }
                    ODWeimaEx5CarSet.this.setCarInfo(3, value13);
                    break;
                case R.id.ctv_checkedtext4 /* 2131427544 */:
                    int value14 = DataCanbus.DATA[118];
                    if (value14 == 1) {
                        value14 = 0;
                    } else if (value14 == 0) {
                        value14 = 1;
                    }
                    ODWeimaEx5CarSet.this.setCarInfo(8, value14);
                    break;
                case R.id.ctv_checkedtext5 /* 2131427547 */:
                    int value15 = DataCanbus.DATA[119];
                    if (value15 == 1) {
                        value15 = 0;
                    } else if (value15 == 0) {
                        value15 = 1;
                    }
                    ODWeimaEx5CarSet.this.setCarInfo(9, value15);
                    break;
                case R.id.ctv_checkedtext6 /* 2131427548 */:
                    int value16 = DataCanbus.DATA[120];
                    if (value16 == 1) {
                        value16 = 0;
                    } else if (value16 == 0) {
                        value16 = 1;
                    }
                    ODWeimaEx5CarSet.this.setCarInfo(10, value16);
                    break;
                case R.id.ctv_checkedtext7 /* 2131427549 */:
                    int value17 = DataCanbus.DATA[121];
                    if (value17 == 1) {
                        value17 = 0;
                    } else if (value17 == 0) {
                        value17 = 1;
                    }
                    ODWeimaEx5CarSet.this.setCarInfo(11, value17);
                    break;
                case R.id.ctv_checkedtext8 /* 2131427550 */:
                    int value18 = DataCanbus.DATA[122];
                    if (value18 == 1) {
                        value18 = 0;
                    } else if (value18 == 0) {
                        value18 = 1;
                    }
                    ODWeimaEx5CarSet.this.setCarInfo(12, value18);
                    break;
                case R.id.ctv_checkedtext9 /* 2131427551 */:
                    int value19 = DataCanbus.DATA[123];
                    if (value19 == 1) {
                        value19 = 0;
                    } else if (value19 == 0) {
                        value19 = 1;
                    }
                    ODWeimaEx5CarSet.this.setCarInfo(13, value19);
                    break;
                case R.id.ctv_checkedtext10 /* 2131427552 */:
                    int value20 = DataCanbus.DATA[124];
                    if (value20 == 1) {
                        value20 = 0;
                    } else if (value20 == 0) {
                        value20 = 1;
                    }
                    ODWeimaEx5CarSet.this.setCarInfo(7, value20);
                    break;
                case R.id.ctv_checkedtext12 /* 2131427554 */:
                    int value21 = DataCanbus.DATA[127];
                    if (value21 == 1) {
                        value21 = 0;
                    } else if (value21 == 0) {
                        value21 = 1;
                    }
                    ODWeimaEx5CarSet.this.setCarInfo(16, value21);
                    break;
            }
        }
    };
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 111:
                    ODWeimaEx5CarSet.this.setCheck((CheckedTextView) ODWeimaEx5CarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 112:
                    ODWeimaEx5CarSet.this.setCheck((CheckedTextView) ODWeimaEx5CarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 113:
                    ODWeimaEx5CarSet.this.setCheck((CheckedTextView) ODWeimaEx5CarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 114:
                    if (((TextView) ODWeimaEx5CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODWeimaEx5CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.driver_system_standard);
                                break;
                            case 1:
                                ((TextView) ODWeimaEx5CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.driver_system_sports);
                                break;
                        }
                    }
                    break;
                case 115:
                    if (((TextView) ODWeimaEx5CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODWeimaEx5CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODWeimaEx5CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_oil_signal_normal);
                                break;
                            case 2:
                                ((TextView) ODWeimaEx5CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.driver_system_sports);
                                break;
                        }
                    }
                    break;
                case 116:
                    if (((TextView) ODWeimaEx5CarSet.this.findViewById(R.id.seekbar_checkedtext1_rightvalue)) != null) {
                        ((TextView) ODWeimaEx5CarSet.this.findViewById(R.id.seekbar_checkedtext1_rightvalue)).setText(String.valueOf(value) + "%");
                    }
                    if (((SeekBar) ODWeimaEx5CarSet.this.findViewById(R.id.seekbar_checkedtext1)) != null) {
                        ((SeekBar) ODWeimaEx5CarSet.this.findViewById(R.id.seekbar_checkedtext1)).setProgress(value - 40);
                        break;
                    }
                case 117:
                    if (((TextView) ODWeimaEx5CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODWeimaEx5CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODWeimaEx5CarSet.this.findViewById(R.id.tv_text4)).setText("30s");
                                break;
                            case 2:
                                ((TextView) ODWeimaEx5CarSet.this.findViewById(R.id.tv_text4)).setText("60s");
                                break;
                            case 3:
                                ((TextView) ODWeimaEx5CarSet.this.findViewById(R.id.tv_text4)).setText("90s");
                                break;
                        }
                    }
                    break;
                case 118:
                    ODWeimaEx5CarSet.this.setCheck((CheckedTextView) ODWeimaEx5CarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 119:
                    ODWeimaEx5CarSet.this.setCheck((CheckedTextView) ODWeimaEx5CarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 120:
                    ODWeimaEx5CarSet.this.setCheck((CheckedTextView) ODWeimaEx5CarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 121:
                    ODWeimaEx5CarSet.this.setCheck((CheckedTextView) ODWeimaEx5CarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 122:
                    ODWeimaEx5CarSet.this.setCheck((CheckedTextView) ODWeimaEx5CarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 123:
                    ODWeimaEx5CarSet.this.setCheck((CheckedTextView) ODWeimaEx5CarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 124:
                    ODWeimaEx5CarSet.this.setCheck((CheckedTextView) ODWeimaEx5CarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 125:
                    if (((TextView) ODWeimaEx5CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODWeimaEx5CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_unlock);
                                break;
                            case 1:
                                ((TextView) ODWeimaEx5CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_lock);
                                break;
                        }
                    }
                    break;
                case 126:
                    if (((TextView) ODWeimaEx5CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODWeimaEx5CarSet.this.findViewById(R.id.tv_text3)).setText("kPa");
                                break;
                            case 1:
                                ((TextView) ODWeimaEx5CarSet.this.findViewById(R.id.tv_text3)).setText(CamryData.PRESSURE_UNIT_PSI);
                                break;
                            case 2:
                                ((TextView) ODWeimaEx5CarSet.this.findViewById(R.id.tv_text3)).setText("bar");
                                break;
                        }
                    }
                    break;
                case 127:
                    ODWeimaEx5CarSet.this.setCheck((CheckedTextView) ODWeimaEx5CarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_od_weima_ex5_settings);
        init();
    }

    @Override
    public void init() {
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12));
        setonClick((Button) findViewById(R.id.btn_minus1));
        setonClick((Button) findViewById(R.id.btn_plus1));
        setonClick((Button) findViewById(R.id.btn_minus2));
        setonClick((Button) findViewById(R.id.btn_plus2));
        setonClick((Button) findViewById(R.id.btn_minus3));
        setonClick((Button) findViewById(R.id.btn_plus3));
        seekbaronClick((SeekBar) findViewById(R.id.seekbar_checkedtext1));
        setonClick((Button) findViewById(R.id.btn_minus4));
        setonClick((Button) findViewById(R.id.btn_plus4));
        setonClick((Button) findViewById(R.id.btn_minus5));
        setonClick((Button) findViewById(R.id.btn_plus5));
    }

    private void setonClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
        }
    }

    private void seekbaronClick(SeekBar v) {
        if (v != null) {
            v.setOnSeekBarChangeListener(this.mseekbarClick);
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{65}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
    }
}
