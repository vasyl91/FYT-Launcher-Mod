package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7Electric_management_d1_Acti_RZC extends BaseActivity implements View.OnClickListener {
    int value1_WC = 0;
    int value2_WC = 0;
    int value3_WC = 0;
    int value4_WC = 0;
    int value5_WC = 0;
    int value6_WC = 0;
    int value0 = 0;
    int value1 = 0;
    int value2 = 0;
    int value3 = 0;
    int value4 = 0;
    int value5 = 0;
    int value6 = 0;
    int value7 = 0;
    int value8 = 0;
    int value9 = 0;
    int value_select = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 399:
                    if (((TextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 400:
                    if (((TextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 401:
                    Golf7Electric_management_d1_Acti_RZC.this.setCheck((CheckedTextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 402:
                    Golf7Electric_management_d1_Acti_RZC.this.setCheck((CheckedTextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 403:
                    Golf7Electric_management_d1_Acti_RZC.this.setCheck((CheckedTextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 404:
                    Golf7Electric_management_d1_Acti_RZC.this.setCheck((CheckedTextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 405:
                    if (((TextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.tv_text3)).setText("5A");
                                break;
                            case 1:
                                ((TextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.tv_text3)).setText("10A");
                                break;
                            case 2:
                                ((TextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.tv_text3)).setText("13A");
                                break;
                            case 3:
                                ((TextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.tv_text3)).setText("MAX");
                                break;
                        }
                    }
                    break;
                case 406:
                    Golf7Electric_management_d1_Acti_RZC.this.setCheck((CheckedTextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 407:
                    Golf7Electric_management_d1_Acti_RZC.this.setCheck((CheckedTextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 408:
                    Golf7Electric_management_d1_Acti_RZC.this.setCheck((CheckedTextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 409:
                    Golf7Electric_management_d1_Acti_RZC.this.setCheck((CheckedTextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 410:
                    Golf7Electric_management_d1_Acti_RZC.this.setCheck((CheckedTextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 411:
                    Golf7Electric_management_d1_Acti_RZC.this.setCheck((CheckedTextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 412:
                    Golf7Electric_management_d1_Acti_RZC.this.setCheck((CheckedTextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 413:
                    if (((TextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 414:
                    if (((TextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.tv_text5)) != null) {
                        if (DataCanbus.DATA[1000] == 655377) {
                            if (value == 0) {
                                ((TextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.tv_text5)).setText("0");
                                break;
                            } else {
                                ((TextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.tv_text5)).setText("30");
                                break;
                            }
                        } else {
                            ((TextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value)).toString());
                            break;
                        }
                    }
                    break;
                case 415:
                    if (((TextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 416:
                    if (((TextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.tv_text7)) != null) {
                        if (DataCanbus.DATA[1000] == 655377) {
                            if (value == 0) {
                                ((TextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.tv_text7)).setText("0");
                                break;
                            } else {
                                ((TextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.tv_text7)).setText("30");
                                break;
                            }
                        } else {
                            ((TextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.tv_text7)).setText(new StringBuilder(String.valueOf(value)).toString());
                            break;
                        }
                    }
                    break;
                case 417:
                    if (((TextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) Golf7Electric_management_d1_Acti_RZC.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + "%");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0160_rzc_mqb_electric_management_d1);
        ((TextView) findViewById(R.id.tv_text9)).setText("出发时间1设置");
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
        if (DataCanbus.DATA[1000] == 655377) {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
        } else {
            findViewById(R.id.layout_view1).setVisibility(0);
            findViewById(R.id.layout_view2).setVisibility(0);
        }
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                if (DataCanbus.DATA[1000] == 655377) {
                    getCarInfo_WC();
                    int value = DataCanbus.DATA[399] - 1;
                    if (value < 0) {
                        value = 23;
                    }
                    this.value1_WC = value;
                    setCarInfo_WC();
                    break;
                } else {
                    getCarInfo();
                    int value2 = DataCanbus.DATA[399] - 1;
                    if (value2 < 0) {
                        value2 = 23;
                    }
                    this.value1 = value2;
                    setCarInfo();
                    break;
                }
            case R.id.btn_plus1 /* 2131427457 */:
                if (DataCanbus.DATA[1000] == 655377) {
                    getCarInfo_WC();
                    int value3 = DataCanbus.DATA[399] + 1;
                    if (value3 > 23) {
                        value3 = 0;
                    }
                    this.value1_WC = value3;
                    setCarInfo_WC();
                    break;
                } else {
                    getCarInfo();
                    int value4 = DataCanbus.DATA[399] + 1;
                    if (value4 > 23) {
                        value4 = 0;
                    }
                    this.value1 = value4;
                    setCarInfo();
                    break;
                }
            case R.id.btn_minus2 /* 2131427458 */:
                if (DataCanbus.DATA[1000] == 655377) {
                    getCarInfo_WC();
                    int value5 = DataCanbus.DATA[400] - 5;
                    if (value5 < 0) {
                        value5 = 55;
                    }
                    this.value2_WC = value5;
                    setCarInfo_WC();
                    break;
                } else {
                    getCarInfo();
                    int value6 = DataCanbus.DATA[400] - 5;
                    if (value6 < 0) {
                        value6 = 55;
                    }
                    this.value2 = value6;
                    setCarInfo();
                    break;
                }
            case R.id.btn_plus2 /* 2131427460 */:
                if (DataCanbus.DATA[1000] == 655377) {
                    getCarInfo_WC();
                    int value7 = DataCanbus.DATA[400] + 5;
                    if (value7 > 55) {
                        value7 = 0;
                    }
                    this.value2_WC = value7;
                    setCarInfo_WC();
                    break;
                } else {
                    getCarInfo();
                    int value8 = DataCanbus.DATA[400] + 5;
                    if (value8 > 55) {
                        value8 = 0;
                    }
                    this.value2 = value8;
                    setCarInfo();
                    break;
                }
            case R.id.btn_minus3 /* 2131427461 */:
                getCarInfo();
                int value9 = DataCanbus.DATA[405] - 1;
                if (value9 < 0) {
                    value9 = 3;
                }
                this.value3 = (this.value3 & 252) | (value9 & 3);
                setCarInfo();
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                getCarInfo();
                int value10 = DataCanbus.DATA[405] + 1;
                if (value10 > 3) {
                    value10 = 0;
                }
                this.value3 = (this.value3 & 252) | (value10 & 3);
                setCarInfo();
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                if (DataCanbus.DATA[1000] == 655377) {
                    getCarInfo_WC();
                    int value11 = DataCanbus.DATA[413] - 1;
                    if (value11 < 0) {
                        value11 = 23;
                    }
                    this.value4_WC = ((value11 << 1) & 254) | (this.value4_WC & 1);
                    setCarInfo_WC();
                    break;
                } else {
                    getCarInfo();
                    int value12 = DataCanbus.DATA[413] - 1;
                    if (value12 < 0) {
                        value12 = 23;
                    }
                    this.value5 = value12;
                    setCarInfo();
                    break;
                }
            case R.id.btn_plus4 /* 2131427466 */:
                if (DataCanbus.DATA[1000] == 655377) {
                    getCarInfo_WC();
                    int value13 = DataCanbus.DATA[413] + 1;
                    if (value13 > 23) {
                        value13 = 0;
                    }
                    this.value4_WC = ((value13 << 1) & 254) | (this.value4_WC & 1);
                    setCarInfo_WC();
                    break;
                } else {
                    getCarInfo();
                    int value14 = DataCanbus.DATA[413] + 1;
                    if (value14 > 23) {
                        value14 = 0;
                    }
                    this.value5 = value14;
                    setCarInfo();
                    break;
                }
            case R.id.btn_minus5 /* 2131427467 */:
                if (DataCanbus.DATA[1000] == 655377) {
                    getCarInfo_WC();
                    int value15 = DataCanbus.DATA[414] + 1;
                    if (value15 > 1) {
                        value15 = 0;
                    }
                    this.value4_WC = (value15 & 1) | (this.value4_WC & 254);
                    setCarInfo_WC();
                    break;
                } else {
                    getCarInfo();
                    int value16 = DataCanbus.DATA[414] - 30;
                    if (value16 < 0) {
                        value16 = 30;
                    }
                    this.value6 = value16;
                    setCarInfo();
                    break;
                }
            case R.id.btn_plus5 /* 2131427469 */:
                if (DataCanbus.DATA[1000] == 655377) {
                    getCarInfo_WC();
                    int value17 = DataCanbus.DATA[414] - 1;
                    if (value17 < 0) {
                        value17 = 1;
                    }
                    this.value4_WC = (value17 & 1) | (this.value4_WC & 254);
                    setCarInfo_WC();
                    break;
                } else {
                    getCarInfo();
                    int value18 = DataCanbus.DATA[414] + 30;
                    if (value18 > 30) {
                        value18 = 0;
                    }
                    this.value6 = value18;
                    setCarInfo();
                    break;
                }
            case R.id.btn_minus6 /* 2131427470 */:
                if (DataCanbus.DATA[1000] == 655377) {
                    getCarInfo_WC();
                    int value19 = DataCanbus.DATA[415] - 1;
                    if (value19 < 0) {
                        value19 = 23;
                    }
                    this.value5_WC = ((value19 << 1) & 254) | (this.value5_WC & 1);
                    setCarInfo_WC();
                    break;
                } else {
                    getCarInfo();
                    int value20 = DataCanbus.DATA[415] - 1;
                    if (value20 < 0) {
                        value20 = 23;
                    }
                    this.value7 = value20;
                    setCarInfo();
                    break;
                }
            case R.id.btn_plus6 /* 2131427472 */:
                if (DataCanbus.DATA[1000] == 655377) {
                    getCarInfo_WC();
                    int value21 = DataCanbus.DATA[415] + 1;
                    if (value21 > 23) {
                        value21 = 0;
                    }
                    this.value5_WC = ((value21 << 1) & 254) | (this.value5_WC & 1);
                    setCarInfo_WC();
                    break;
                } else {
                    getCarInfo();
                    int value22 = DataCanbus.DATA[415] + 1;
                    if (value22 > 23) {
                        value22 = 0;
                    }
                    this.value7 = value22;
                    setCarInfo();
                    break;
                }
            case R.id.btn_minus7 /* 2131427473 */:
                if (DataCanbus.DATA[1000] == 655377) {
                    getCarInfo_WC();
                    int value23 = DataCanbus.DATA[416] + 1;
                    if (value23 > 1) {
                        value23 = 0;
                    }
                    this.value5_WC = (value23 & 1) | (this.value5_WC & 254);
                    setCarInfo_WC();
                    break;
                } else {
                    getCarInfo();
                    int value24 = DataCanbus.DATA[416] - 30;
                    if (value24 < 0) {
                        value24 = 30;
                    }
                    this.value8 = value24;
                    setCarInfo();
                    break;
                }
            case R.id.btn_plus7 /* 2131427475 */:
                if (DataCanbus.DATA[1000] == 655377) {
                    getCarInfo_WC();
                    int value25 = DataCanbus.DATA[416] - 1;
                    if (value25 > 1) {
                        value25 = 0;
                    }
                    this.value5_WC = (value25 & 1) | (this.value5_WC & 254);
                    setCarInfo_WC();
                    break;
                } else {
                    getCarInfo();
                    int value26 = DataCanbus.DATA[416] + 30;
                    if (value26 > 30) {
                        value26 = 0;
                    }
                    this.value8 = value26;
                    setCarInfo();
                    break;
                }
            case R.id.btn_minus8 /* 2131427476 */:
                getCarInfo();
                int value27 = DataCanbus.DATA[417];
                if (value27 > 10) {
                    value27--;
                }
                this.value9 = value27;
                setCarInfo();
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                getCarInfo();
                int value28 = DataCanbus.DATA[417];
                if (value28 < 100) {
                    value28++;
                }
                this.value9 = value28;
                setCarInfo();
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (DataCanbus.DATA[1000] == 655377) {
                    getCarInfo_WC();
                    if (DataCanbus.DATA[401] == 1) {
                        this.value6_WC &= 127;
                    } else {
                        this.value6_WC |= 128;
                    }
                    setCarInfo_WC();
                    break;
                } else {
                    getCarInfo();
                    if (DataCanbus.DATA[401] == 1) {
                        this.value3 &= 127;
                    } else {
                        this.value3 |= 128;
                    }
                    setCarInfo();
                    break;
                }
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                if (DataCanbus.DATA[1000] == 655377) {
                    getCarInfo_WC();
                    int value29 = DataCanbus.DATA[412];
                    int flag = DataCanbus.DATA[401];
                    if (flag == 1) {
                        if (value29 == 1) {
                            this.value6_WC &= 254;
                        } else {
                            this.value6_WC |= 1;
                        }
                    } else if (value29 == 1) {
                        this.value6_WC = 0;
                    } else {
                        this.value6_WC = 1;
                    }
                    setCarInfo_WC();
                    break;
                } else {
                    getCarInfo();
                    int value30 = DataCanbus.DATA[412];
                    int flag2 = DataCanbus.DATA[401];
                    if (flag2 == 1) {
                        if (value30 == 1) {
                            this.value4 &= 253;
                        } else {
                            this.value4 |= 2;
                        }
                    } else if (value30 == 1) {
                        this.value4 = 0;
                    } else {
                        this.value4 = 2;
                    }
                    setCarInfo();
                    break;
                }
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                if (DataCanbus.DATA[1000] == 655377) {
                    getCarInfo_WC();
                    int value31 = DataCanbus.DATA[411];
                    int flag3 = DataCanbus.DATA[401];
                    if (flag3 == 1) {
                        if (value31 == 1) {
                            this.value6_WC &= 253;
                        } else {
                            this.value6_WC |= 2;
                        }
                    } else if (value31 == 1) {
                        this.value6_WC = 0;
                    } else {
                        this.value6_WC = 2;
                    }
                    setCarInfo_WC();
                    break;
                } else {
                    getCarInfo();
                    int value32 = DataCanbus.DATA[411];
                    int flag4 = DataCanbus.DATA[401];
                    if (flag4 == 1) {
                        if (value32 == 1) {
                            this.value4 &= 251;
                        } else {
                            this.value4 |= 4;
                        }
                    } else if (value32 == 1) {
                        this.value4 = 0;
                    } else {
                        this.value4 = 4;
                    }
                    setCarInfo();
                    break;
                }
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                if (DataCanbus.DATA[1000] == 655377) {
                    getCarInfo_WC();
                    int value33 = DataCanbus.DATA[410];
                    int flag5 = DataCanbus.DATA[401];
                    if (flag5 == 1) {
                        if (value33 == 1) {
                            this.value6_WC &= 251;
                        } else {
                            this.value6_WC |= 4;
                        }
                    } else if (value33 == 1) {
                        this.value6_WC = 0;
                    } else {
                        this.value6_WC = 4;
                    }
                    setCarInfo_WC();
                    break;
                } else {
                    getCarInfo();
                    int value34 = DataCanbus.DATA[410];
                    int flag6 = DataCanbus.DATA[401];
                    if (flag6 == 1) {
                        if (value34 == 1) {
                            this.value4 &= 247;
                        } else {
                            this.value4 |= 8;
                        }
                    } else if (value34 == 1) {
                        this.value4 = 0;
                    } else {
                        this.value4 = 8;
                    }
                    setCarInfo();
                    break;
                }
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                if (DataCanbus.DATA[1000] == 655377) {
                    getCarInfo_WC();
                    int value35 = DataCanbus.DATA[409];
                    int flag7 = DataCanbus.DATA[401];
                    if (flag7 == 1) {
                        if (value35 == 1) {
                            this.value6_WC &= 247;
                        } else {
                            this.value6_WC |= 8;
                        }
                    } else if (value35 == 1) {
                        this.value6_WC = 0;
                    } else {
                        this.value6_WC = 8;
                    }
                    setCarInfo_WC();
                    break;
                } else {
                    getCarInfo();
                    int value36 = DataCanbus.DATA[409];
                    int flag8 = DataCanbus.DATA[401];
                    if (flag8 == 1) {
                        if (value36 == 1) {
                            this.value4 &= 239;
                        } else {
                            this.value4 |= 16;
                        }
                    } else if (value36 == 1) {
                        this.value4 = 0;
                    } else {
                        this.value4 = 16;
                    }
                    setCarInfo();
                    break;
                }
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                if (DataCanbus.DATA[1000] == 655377) {
                    getCarInfo_WC();
                    int value37 = DataCanbus.DATA[408];
                    int flag9 = DataCanbus.DATA[401];
                    if (flag9 == 1) {
                        if (value37 == 1) {
                            this.value6_WC &= 239;
                        } else {
                            this.value6_WC |= 16;
                        }
                    } else if (value37 == 1) {
                        this.value6_WC = 0;
                    } else {
                        this.value6_WC = 16;
                    }
                    setCarInfo_WC();
                    break;
                } else {
                    getCarInfo();
                    int value38 = DataCanbus.DATA[408];
                    int flag10 = DataCanbus.DATA[401];
                    if (flag10 == 1) {
                        if (value38 == 1) {
                            this.value4 &= 223;
                        } else {
                            this.value4 |= 32;
                        }
                    } else if (value38 == 1) {
                        this.value4 = 0;
                    } else {
                        this.value4 = 32;
                    }
                    setCarInfo();
                    break;
                }
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                if (DataCanbus.DATA[1000] == 655377) {
                    getCarInfo_WC();
                    int value39 = DataCanbus.DATA[407];
                    int flag11 = DataCanbus.DATA[401];
                    if (flag11 == 1) {
                        if (value39 == 1) {
                            this.value6_WC &= 223;
                        } else {
                            this.value6_WC |= 32;
                        }
                    } else if (value39 == 1) {
                        this.value6_WC = 0;
                    } else {
                        this.value6_WC = 32;
                    }
                    setCarInfo_WC();
                    break;
                } else {
                    getCarInfo();
                    int value40 = DataCanbus.DATA[407];
                    int flag12 = DataCanbus.DATA[401];
                    if (flag12 == 1) {
                        if (value40 == 1) {
                            this.value4 &= 191;
                        } else {
                            this.value4 |= 64;
                        }
                    } else if (value40 == 1) {
                        this.value4 = 0;
                    } else {
                        this.value4 = 64;
                    }
                    setCarInfo();
                    break;
                }
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                if (DataCanbus.DATA[1000] == 655377) {
                    getCarInfo_WC();
                    int value41 = DataCanbus.DATA[406];
                    int flag13 = DataCanbus.DATA[401];
                    if (flag13 == 1) {
                        if (value41 == 1) {
                            this.value6_WC &= 191;
                        } else {
                            this.value6_WC |= 64;
                        }
                    } else if (value41 == 1) {
                        this.value6_WC = 0;
                    } else {
                        this.value6_WC = 64;
                    }
                    setCarInfo_WC();
                    break;
                } else {
                    getCarInfo();
                    int value42 = DataCanbus.DATA[406];
                    int flag14 = DataCanbus.DATA[401];
                    if (flag14 == 1) {
                        if (value42 == 1) {
                            this.value4 &= 127;
                        } else {
                            this.value4 |= 128;
                        }
                    } else if (value42 == 1) {
                        this.value4 = 0;
                    } else {
                        this.value4 = 128;
                    }
                    setCarInfo();
                    break;
                }
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                if (DataCanbus.DATA[1000] == 655377) {
                    getCarInfo_WC();
                    int value43 = DataCanbus.DATA[402];
                    int flag15 = DataCanbus.DATA[403];
                    if (flag15 == 1) {
                        if (value43 == 1) {
                            this.value3_WC &= 127;
                        } else {
                            this.value3_WC |= 128;
                        }
                    } else if (value43 != 1) {
                        this.value3_WC = 128;
                    }
                    setCarInfo_WC();
                    break;
                } else {
                    getCarInfo();
                    int value44 = DataCanbus.DATA[402];
                    int flag16 = DataCanbus.DATA[403];
                    if (flag16 == 1) {
                        if (value44 == 1) {
                            this.value3 &= 191;
                        } else {
                            this.value3 |= 64;
                        }
                    } else if (value44 != 1) {
                        this.value3 |= 64;
                    }
                    setCarInfo();
                    break;
                }
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                if (DataCanbus.DATA[1000] == 655377) {
                    getCarInfo_WC();
                    int value45 = DataCanbus.DATA[403];
                    int flag17 = DataCanbus.DATA[402];
                    if (flag17 == 1) {
                        if (value45 == 1) {
                            this.value3_WC &= 191;
                        } else {
                            this.value3_WC |= 64;
                        }
                    } else if (value45 != 1) {
                        this.value3_WC = 64;
                    }
                    setCarInfo_WC();
                    break;
                } else {
                    getCarInfo();
                    int value46 = DataCanbus.DATA[403];
                    int flag18 = DataCanbus.DATA[402];
                    if (flag18 == 1) {
                        if (value46 == 1) {
                            this.value3 &= 223;
                        } else {
                            this.value3 |= 32;
                        }
                    } else if (value46 != 1) {
                        this.value3 |= 32;
                    }
                    setCarInfo();
                    break;
                }
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                if (DataCanbus.DATA[1000] == 655377) {
                    getCarInfo_WC();
                    if (DataCanbus.DATA[404] == 1) {
                        this.value3_WC &= 223;
                    } else {
                        this.value3_WC |= 32;
                    }
                    setCarInfo_WC();
                    break;
                } else {
                    getCarInfo();
                    if (DataCanbus.DATA[404] == 1) {
                        this.value3 &= 239;
                    } else {
                        this.value3 |= 16;
                    }
                    setCarInfo();
                    break;
                }
        }
    }

    public void getCarInfo_WC() {
        this.value1_WC = DataCanbus.DATA[399];
        this.value2_WC = DataCanbus.DATA[400];
        this.value3_WC = ((DataCanbus.DATA[402] << 7) & 128) | ((DataCanbus.DATA[403] << 6) & 64) | ((DataCanbus.DATA[404] << 5) & 32);
        this.value4_WC = ((DataCanbus.DATA[413] << 1) & 254) | (DataCanbus.DATA[414] & 1);
        this.value5_WC = ((DataCanbus.DATA[415] << 1) & 254) | (DataCanbus.DATA[416] & 1);
        this.value6_WC = ((DataCanbus.DATA[406] << 6) & 64) | ((DataCanbus.DATA[407] << 5) & 32) | ((DataCanbus.DATA[408] << 4) & 16) | ((DataCanbus.DATA[409] << 3) & 8) | ((DataCanbus.DATA[410] << 2) & 4) | ((DataCanbus.DATA[411] << 1) & 2) | ((DataCanbus.DATA[412] << 0) & 1) | ((DataCanbus.DATA[401] << 7) & 128);
    }

    public void setCarInfo_WC() {
        this.value_select |= (DataCanbus.DATA[398] << 7) & 128;
        this.value_select |= (DataCanbus.DATA[397] << 6) & 64;
        this.value_select |= (DataCanbus.DATA[396] << 5) & 32;
        this.value_select |= 12;
        RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
        int[] iArr = new int[19];
        iArr[0] = this.value_select;
        iArr[1] = this.value1_WC;
        iArr[2] = this.value2_WC;
        iArr[3] = this.value3_WC;
        iArr[4] = this.value4_WC;
        iArr[5] = this.value5_WC;
        iArr[6] = this.value6_WC;
        remoteModuleProxy.cmd(147, iArr, null, null);
    }

    public void getCarInfo() {
        this.value0 = 1;
        this.value1 = DataCanbus.DATA[399];
        this.value2 = DataCanbus.DATA[400];
        this.value3 = ((DataCanbus.DATA[401] << 7) & 128) | ((DataCanbus.DATA[402] << 6) & 64) | ((DataCanbus.DATA[403] << 5) & 32) | ((DataCanbus.DATA[404] << 4) & 16) | ((DataCanbus.DATA[405] << 0) & 3);
        this.value4 = ((DataCanbus.DATA[406] << 7) & 128) | ((DataCanbus.DATA[407] << 6) & 64) | ((DataCanbus.DATA[408] << 5) & 32) | ((DataCanbus.DATA[409] << 4) & 16) | ((DataCanbus.DATA[410] << 3) & 8) | ((DataCanbus.DATA[411] << 2) & 4) | ((DataCanbus.DATA[412] << 1) & 2);
        this.value5 = DataCanbus.DATA[413];
        this.value6 = DataCanbus.DATA[414];
        this.value7 = DataCanbus.DATA[415];
        this.value8 = DataCanbus.DATA[416];
        this.value9 = DataCanbus.DATA[417];
    }

    public void setCarInfo() {
        DataCanbus.PROXY.cmd(143, new int[]{this.value0, this.value1, this.value2, this.value3, this.value4, this.value5, this.value6, this.value7, this.value8, this.value9}, null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[396].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[397].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[398].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[399].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[400].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[401].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[402].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[403].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[404].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[405].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[406].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[407].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[408].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[409].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[410].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[411].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[412].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[413].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[414].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[415].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[416].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[417].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[396].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[397].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[398].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[399].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[400].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[401].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[402].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[403].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[404].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[405].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[406].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[407].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[408].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[409].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[410].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[411].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[412].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[413].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[414].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[415].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[416].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[417].removeNotify(this.mNotifyCanbus);
    }
}
