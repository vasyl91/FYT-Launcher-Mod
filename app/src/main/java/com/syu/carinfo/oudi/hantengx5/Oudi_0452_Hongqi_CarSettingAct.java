package com.syu.carinfo.oudi.hantengx5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Oudi_0452_Hongqi_CarSettingAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0452_Hongqi_CarSettingAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 38:
                    Oudi_0452_Hongqi_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 39:
                    if (((TextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "km/h");
                        break;
                    }
                case 40:
                    if (((TextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.tv_text2)).setText("开启四门");
                                break;
                            case 1:
                                ((TextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.tv_text2)).setText("开启司机门");
                                break;
                        }
                    }
                    break;
                case 41:
                    Oudi_0452_Hongqi_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 42:
                    Oudi_0452_Hongqi_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 43:
                    Oudi_0452_Hongqi_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 44:
                    if (((TextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.tv_text3)).setText("驾驶门");
                                break;
                            case 1:
                                ((TextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.tv_text3)).setText("所有车门");
                                break;
                        }
                    }
                    break;
                case 45:
                    Oudi_0452_Hongqi_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 46:
                    Oudi_0452_Hongqi_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 47:
                    Oudi_0452_Hongqi_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 48:
                    Oudi_0452_Hongqi_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 49:
                    Oudi_0452_Hongqi_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 50:
                    Oudi_0452_Hongqi_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 51:
                    Oudi_0452_Hongqi_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 52:
                    Oudi_0452_Hongqi_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 53:
                    Oudi_0452_Hongqi_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_od_hongqi_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
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
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[38];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(146, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[39] - 10;
                if (value2 < 30) {
                    value2 = 220;
                }
                setCarInfo(147, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[39] + 10;
                if (value3 > 220) {
                    value3 = 30;
                }
                setCarInfo(147, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[40];
                if (value4 == 1) {
                    value4 = 0;
                } else if (value4 == 0) {
                    value4 = 1;
                }
                setCarInfo(148, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[40];
                if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                setCarInfo(148, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[44];
                if (value6 == 1) {
                    value6 = 0;
                } else if (value6 == 0) {
                    value6 = 1;
                }
                setCarInfo(152, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[44];
                if (value7 == 1) {
                    value7 = 0;
                } else if (value7 == 0) {
                    value7 = 1;
                }
                setCarInfo(152, value7);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value8 = DataCanbus.DATA[41];
                if (value8 == 1) {
                    value8 = 0;
                } else if (value8 == 0) {
                    value8 = 1;
                }
                setCarInfo(149, value8);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value9 = DataCanbus.DATA[42];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(150, value9);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value10 = DataCanbus.DATA[43];
                if (value10 == 1) {
                    value10 = 0;
                } else if (value10 == 0) {
                    value10 = 1;
                }
                setCarInfo(151, value10);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value11 = DataCanbus.DATA[45];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(153, value11);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value12 = DataCanbus.DATA[46];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                setCarInfo(154, value12);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value13 = DataCanbus.DATA[47];
                if (value13 == 1) {
                    value13 = 0;
                } else if (value13 == 0) {
                    value13 = 1;
                }
                setCarInfo(155, value13);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value14 = DataCanbus.DATA[48];
                if (value14 == 1) {
                    value14 = 0;
                } else if (value14 == 0) {
                    value14 = 1;
                }
                setCarInfo(156, value14);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value15 = DataCanbus.DATA[49];
                if (value15 == 1) {
                    value15 = 0;
                } else if (value15 == 0) {
                    value15 = 1;
                }
                setCarInfo(157, value15);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value16 = DataCanbus.DATA[50];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(158, value16);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value17 = DataCanbus.DATA[51];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(159, value17);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int value18 = DataCanbus.DATA[52];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(160, value18);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                int value19 = DataCanbus.DATA[53];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(161, value19);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{65}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
    }
}
