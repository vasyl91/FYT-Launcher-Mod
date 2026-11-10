package com.syu.carinfo.rzc.klc;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
public class RZCKlcCarSet2 extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 130:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext17), val == 1);
                    break;
                case 144:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 145:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 146:
                    if (((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text1)).setText(R.string.str_379_str_2);
                                break;
                            case 1:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text1)).setText(R.string.str_379_str_3);
                                break;
                        }
                    }
                    break;
                case 147:
                    if (((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text2)).setText(R.string.alarm);
                                break;
                            case 2:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text2)).setText(R.string.wc_weilang_auto_fangzhuang_warn_and_zhidong);
                                break;
                        }
                    }
                    break;
                case 148:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 149:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 150:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 151:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 152:
                    if (((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text3)).setText(R.string.wc_weilang_driver_and_customer);
                                break;
                            case 2:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text3)).setText(R.string.wc_weilang_driver);
                                break;
                            case 3:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text3)).setText(R.string.str_252_sound_distribution1);
                                break;
                        }
                    }
                    break;
                case 153:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 154:
                    if (((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text4)).setText(R.string.str_long_lasting);
                                break;
                            case 1:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text4)).setText(R.string.str_short_acting);
                                break;
                        }
                    }
                    break;
                case 155:
                    if (((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text5)).setText("Left-Hand Traffic");
                                break;
                            case 1:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text5)).setText("Right-Hand Traffic");
                                break;
                        }
                    }
                    break;
                case 156:
                    if (((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text6)).setText("Corner and Bend Lighting");
                                break;
                            case 1:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text6)).setText("Intelligent Distribution");
                                break;
                        }
                    }
                    break;
                case 157:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 158:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 159:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 160:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 161:
                    if (((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text7)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text7)).setText(R.string.str_corner_lighting);
                                break;
                            case 2:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text7)).setText(R.string.str_smart_light_distribution);
                                break;
                        }
                    }
                    break;
                case 165:
                    if (((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text8)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text8)).setText(R.string.MAX);
                                break;
                            case 1:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text8)).setText("6A");
                                break;
                        }
                    }
                    break;
                case 166:
                    if (((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text9)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text9)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text9)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
                                break;
                            case 2:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text9)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
                                break;
                        }
                    }
                    break;
                case 167:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 168:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext13), val == 1);
                    break;
                case 169:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext14), val == 1);
                    break;
                case 170:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext15), val == 1);
                    break;
                case 171:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext16), val == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0062_rzc_gm_settings2);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext13), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext14), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext15), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext16), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext17), this);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[146] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(84, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[146] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(84, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[147] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(85, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[147] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(85, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[152] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(90, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[152] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(90, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[154] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(92, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[154] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(92, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[155] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(16, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[155] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(16, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[156] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCarInfo(17, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[156] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(17, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[161] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                setCarInfo(94, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[161] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                setCarInfo(94, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[165] - 1;
                if (value15 < 0) {
                    value15 = 1;
                }
                setCarInfo(34, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[165] + 1;
                if (value16 > 1) {
                    value16 = 0;
                }
                setCarInfo(34, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[166] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                setCarInfo(12, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[166] + 1;
                if (value18 > 2) {
                    value18 = 0;
                }
                setCarInfo(12, value18);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value19 = DataCanbus.DATA[144];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(26, value19);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value20 = DataCanbus.DATA[145];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(27, value20);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value21 = DataCanbus.DATA[148];
                if (value21 == 1) {
                    value21 = 0;
                } else if (value21 == 0) {
                    value21 = 1;
                }
                setCarInfo(86, value21);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value22 = DataCanbus.DATA[149];
                if (value22 == 1) {
                    value22 = 0;
                } else if (value22 == 0) {
                    value22 = 1;
                }
                setCarInfo(87, value22);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value23 = DataCanbus.DATA[150];
                if (value23 == 1) {
                    value23 = 0;
                } else if (value23 == 0) {
                    value23 = 1;
                }
                setCarInfo(88, value23);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value24 = DataCanbus.DATA[151];
                if (value24 == 1) {
                    value24 = 0;
                } else if (value24 == 0) {
                    value24 = 1;
                }
                setCarInfo(89, value24);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value25 = DataCanbus.DATA[153];
                if (value25 == 1) {
                    value25 = 0;
                } else if (value25 == 0) {
                    value25 = 1;
                }
                setCarInfo(91, value25);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value26 = DataCanbus.DATA[157];
                if (value26 == 1) {
                    value26 = 0;
                } else if (value26 == 0) {
                    value26 = 1;
                }
                setCarInfo(19, value26);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value27 = DataCanbus.DATA[158];
                if (value27 == 1) {
                    value27 = 0;
                } else if (value27 == 0) {
                    value27 = 1;
                }
                setCarInfo(20, value27);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value28 = DataCanbus.DATA[159];
                if (value28 == 1) {
                    value28 = 0;
                } else if (value28 == 0) {
                    value28 = 1;
                }
                setCarInfo(21, value28);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value29 = DataCanbus.DATA[160];
                if (value29 == 1) {
                    value29 = 0;
                } else if (value29 == 0) {
                    value29 = 1;
                }
                setCarInfo(93, value29);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value30 = DataCanbus.DATA[167];
                if (value30 == 1) {
                    value30 = 0;
                } else if (value30 == 0) {
                    value30 = 1;
                }
                setCarInfo(36, value30);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                int value31 = DataCanbus.DATA[168];
                if (value31 == 1) {
                    value31 = 0;
                } else if (value31 == 0) {
                    value31 = 1;
                }
                setCarInfo(35, value31);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                int value32 = DataCanbus.DATA[169];
                if (value32 == 1) {
                    value32 = 0;
                } else if (value32 == 0) {
                    value32 = 1;
                }
                setCarInfo(37, value32);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                int value33 = DataCanbus.DATA[170];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setCarInfo(38, value33);
                break;
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                int value34 = DataCanbus.DATA[171];
                if (value34 == 1) {
                    value34 = 0;
                } else if (value34 == 0) {
                    value34 = 1;
                }
                setCarInfo(39, value34);
                break;
            case R.id.ctv_checkedtext17 /* 2131427559 */:
                int value35 = DataCanbus.DATA[130];
                if (value35 == 1) {
                    value35 = 0;
                } else if (value35 == 0) {
                    value35 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value35}, null, null);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(3, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(8, new int[]{10}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
