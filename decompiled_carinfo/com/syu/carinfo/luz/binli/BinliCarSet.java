package com.syu.carinfo.luz.binli;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class BinliCarSet extends BaseActivity implements View.OnClickListener {
    public static BinliCarSet mInstance;
    public static boolean mIsFront = false;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    BinliCarSet.this.setCheck((CheckedTextView) BinliCarSet.this.findViewById(R.id.ctv_checkedtext5), val != 0);
                    break;
                case 100:
                    BinliCarSet.this.updateParkMode(val);
                    break;
                case 101:
                    BinliCarSet.this.setCheck((CheckedTextView) BinliCarSet.this.findViewById(R.id.ctv_checkedtext2), val != 0);
                    break;
                case 102:
                    BinliCarSet.this.updateTireUnit(val);
                    break;
                case 103:
                    BinliCarSet.this.updateTireSpeedType(val);
                    break;
                case 104:
                    BinliCarSet.this.updateTireType(val);
                    break;
                case 105:
                    BinliCarSet.this.setCheck((CheckedTextView) BinliCarSet.this.findViewById(R.id.ctv_checkedtext1), val != 0);
                    break;
                case 114:
                    BinliCarSet.this.updateHangLev(val);
                    break;
                case 115:
                    BinliCarSet.this.updateCarLev(val);
                    break;
                case 122:
                    BinliCarSet.this.updateTempUnit(val);
                    break;
                case 132:
                    BinliCarSet.this.updateTripUnit(val);
                    break;
                case 149:
                    BinliCarSet.this.updateLightDelay(val);
                    break;
                case 150:
                    BinliCarSet.this.setCheck((CheckedTextView) BinliCarSet.this.findViewById(R.id.ctv_checkedtext3), val != 0);
                    break;
                case 151:
                    BinliCarSet.this.setCheck((CheckedTextView) BinliCarSet.this.findViewById(R.id.ctv_checkedtext4), val != 0);
                    break;
                case 152:
                    if (((TextView) BinliCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) BinliCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.str_no_ventilation);
                                break;
                            case 1:
                                ((TextView) BinliCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.str_with_ventilation);
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
        //setContentView(R.layout.layout_0439_luz_binli_settings);
        init();
        mInstance = this;
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
    }

    @Override
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        int value6;
        int value7;
        int value8;
        int value9;
        int value10;
        int value11;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value12 = DataCanbus.DATA[104] - 1;
                if (value12 < 0) {
                    value12 = 3;
                }
                setCarInfo(6, value12);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value13 = DataCanbus.DATA[104] + 1;
                if (value13 > 3) {
                    value13 = 0;
                }
                setCarInfo(6, value13);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value14 = DataCanbus.DATA[103] - 1;
                if (value14 < 0) {
                    value14 = 2;
                }
                setCarInfo(5, value14);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value15 = DataCanbus.DATA[103] + 1;
                if (value15 > 2) {
                    value15 = 0;
                }
                setCarInfo(5, value15);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value16 = DataCanbus.DATA[122] - 1;
                if (value16 < 0) {
                    value16 = 1;
                }
                setCarInfo(13, value16);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value17 = DataCanbus.DATA[122] + 1;
                if (value17 > 1) {
                    value17 = 0;
                }
                setCarInfo(13, value17);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value18 = DataCanbus.DATA[102] - 1;
                if (value18 < 0) {
                    value18 = 2;
                }
                setCarInfo(14, value18);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value19 = DataCanbus.DATA[102] + 1;
                if (value19 > 2) {
                    value19 = 0;
                }
                setCarInfo(14, value19);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value20 = (DataCanbus.DATA[132] >> 5) & 3;
                if (value20 == 0) {
                    value20 = 2;
                } else if (value20 == 1) {
                    value20 = 1;
                } else if (value20 == 2) {
                    value20 = 0;
                }
                setCarInfo(15, value20);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value21 = (DataCanbus.DATA[132] >> 5) & 3;
                if (value21 == 0) {
                    value21 = 0;
                } else if (value21 == 1) {
                    value21 = 2;
                } else if (value21 == 2) {
                    value21 = 1;
                }
                setCarInfo(15, value21);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value22 = DataCanbus.DATA[149] - 1;
                if (value22 < 0) {
                    value22 = 6;
                }
                setCarInfo(16, value22);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value23 = DataCanbus.DATA[149] + 1;
                if (value23 > 6) {
                    value23 = 0;
                }
                setCarInfo(16, value23);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                if (DataCanbus.DATA[100] == 0) {
                    value10 = 1;
                } else {
                    value10 = 0;
                }
                setCarInfo(4, value10);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                if (DataCanbus.DATA[115] == 0) {
                    value9 = 1;
                } else {
                    value9 = 0;
                }
                setCarInfo(4, value9);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value24 = DataCanbus.DATA[114] - 1;
                if (value24 < 0) {
                    value24 = 3;
                }
                setCarInfo(1, value24);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value25 = DataCanbus.DATA[114] + 1;
                if (value25 > 3) {
                    value25 = 0;
                }
                setCarInfo(1, value25);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                if (DataCanbus.DATA[115] == 0) {
                    value8 = 1;
                } else {
                    value8 = 0;
                }
                setCarInfo(2, value8);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                if (DataCanbus.DATA[115] == 1) {
                    value7 = 0;
                } else {
                    value7 = 1;
                }
                setCarInfo(2, value7);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                if (DataCanbus.DATA[152] == 0) {
                    value6 = 1;
                } else {
                    value6 = 0;
                }
                setCarInfo(20, value6);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                if (DataCanbus.DATA[152] == 1) {
                    value5 = 0;
                } else {
                    value5 = 1;
                }
                setCarInfo(20, value5);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (DataCanbus.DATA[105] == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                setCarInfo(10, value4);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                if (DataCanbus.DATA[101] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                setCarInfo(0, value3);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                if (DataCanbus.DATA[150] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                setCarInfo(17, value2);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                if (DataCanbus.DATA[151] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(18, value);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                if (DataCanbus.DATA[99] == 0) {
                    value11 = 1;
                } else {
                    value11 = 0;
                }
                setCarInfo(3, value11);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                setCarInfo(11, 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, BinliCarTire.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, BinliCarAmpSet.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        DataCanbus.PROXY.cmd(3, new int[]{55}, null, null);
        DataCanbus.PROXY.cmd(3, new int[]{56}, null, null);
        DataCanbus.PROXY.cmd(3, new int[]{57}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateLightDelay(int value) {
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text6)).setText(R.string.off);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text6)).setText("30s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text6)).setText("60s");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text6)).setText("90s");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text6)).setText("120s");
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text6)).setText("150s");
                    break;
                case 6:
                    ((TextView) findViewById(R.id.tv_text6)).setText("180s");
                    break;
            }
        }
    }

    
    public void updateTripUnit(int value) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            switch ((value >> 5) & 3) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text5)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text5)).setText(CamryData.OIL_EXPEND_UNIT_KM_PER_L);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text5)).setText("mpg");
                    break;
            }
        }
    }

    
    public void updateTempUnit(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text3)).setText("℃");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text3)).setText("℉");
                    break;
            }
        }
    }

    
    public void updateTireUnit(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text4)).setText("bar");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText("psi");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text4)).setText("kpa");
                    break;
            }
        }
    }

    
    public void updateTireSpeedType(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.xp_accord9_car_screen_display_normal);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.lingdu_air_con_profile_2);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.MAX);
                    break;
            }
        }
    }

    
    public void updateTireType(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText("20");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText("21");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text1)).setText("20 Winter");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text1)).setText("Winter(275/40R20)");
                    break;
            }
        }
    }

    
    public void updateCarLev(int value) {
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.rzc_klc_nomal);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_advanced_set);
                    break;
            }
        }
    }

    
    public void updateHangLev(int value) {
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_driving_comfort);
                    break;
                case 1:
                case 2:
                default:
                    ((TextView) findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.driver_system_sports);
                    break;
            }
        }
    }

    
    public void updateParkMode(int value) {
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.str_vertical_parking);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.str_horizontal_parking);
                    break;
            }
        }
    }
}
