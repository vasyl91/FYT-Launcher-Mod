package com.syu.carinfo.xp.suburu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class RZCSuburuCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.suburu.RZCSuburuCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 37:
                    if (((TextView) RZCSuburuCarSet.this.findViewById(R.id.tv_text13)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) RZCSuburuCarSet.this.findViewById(R.id.tv_text13)).setText("℉");
                                break;
                            default:
                                ((TextView) RZCSuburuCarSet.this.findViewById(R.id.tv_text13)).setText("℃");
                                break;
                        }
                    }
                    break;
                case 99:
                    RZCSuburuCarSet.this.updateText1(val);
                    break;
                case 100:
                    RZCSuburuCarSet.this.updateText2(val);
                    break;
                case 101:
                    RZCSuburuCarSet.this.updateText3(val);
                    break;
                case 102:
                    RZCSuburuCarSet.this.updateText4(val);
                    break;
                case 103:
                    RZCSuburuCarSet.this.updateText5(val);
                    break;
                case 104:
                    RZCSuburuCarSet.this.updateText6(val);
                    break;
                case 105:
                    RZCSuburuCarSet.this.updateText7(val);
                    break;
                case 106:
                    RZCSuburuCarSet.this.updateText8(val);
                    break;
                case 107:
                    if (val == 0) {
                        RZCSuburuCarSet.this.findViewById(R.id.layout_view1).setVisibility(8);
                    } else {
                        RZCSuburuCarSet.this.findViewById(R.id.layout_view1).setVisibility(0);
                    }
                    break;
                case 117:
                    if (((CheckedTextView) RZCSuburuCarSet.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) RZCSuburuCarSet.this.findViewById(R.id.ctv_checkedtext1)).setChecked(val == 1);
                    }
                    break;
                case 118:
                    if (((CheckedTextView) RZCSuburuCarSet.this.findViewById(R.id.ctv_checkedtext2)) != null) {
                        ((CheckedTextView) RZCSuburuCarSet.this.findViewById(R.id.ctv_checkedtext2)).setChecked(val == 1);
                    }
                    break;
                case 119:
                    if (((CheckedTextView) RZCSuburuCarSet.this.findViewById(R.id.ctv_checkedtext4)) != null) {
                        ((CheckedTextView) RZCSuburuCarSet.this.findViewById(R.id.ctv_checkedtext4)).setChecked(val == 1);
                    }
                    break;
                case 120:
                    if (((TextView) RZCSuburuCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) RZCSuburuCarSet.this.findViewById(R.id.tv_text9)).setText("Driver Door");
                                break;
                            default:
                                ((TextView) RZCSuburuCarSet.this.findViewById(R.id.tv_text9)).setText("All");
                                break;
                        }
                    }
                    break;
                case 121:
                    if (((TextView) RZCSuburuCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) RZCSuburuCarSet.this.findViewById(R.id.tv_text10)).setText("30s");
                                break;
                            case 2:
                                ((TextView) RZCSuburuCarSet.this.findViewById(R.id.tv_text10)).setText("60s");
                                break;
                            case 3:
                                ((TextView) RZCSuburuCarSet.this.findViewById(R.id.tv_text10)).setText("90s");
                                break;
                            default:
                                ((TextView) RZCSuburuCarSet.this.findViewById(R.id.tv_text10)).setText("OFF");
                                break;
                        }
                    }
                    break;
                case 122:
                    if (((TextView) RZCSuburuCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) RZCSuburuCarSet.this.findViewById(R.id.tv_text11)).setText("30s");
                                break;
                            case 2:
                                ((TextView) RZCSuburuCarSet.this.findViewById(R.id.tv_text11)).setText("60s");
                                break;
                            case 3:
                                ((TextView) RZCSuburuCarSet.this.findViewById(R.id.tv_text11)).setText("90s");
                                break;
                            default:
                                ((TextView) RZCSuburuCarSet.this.findViewById(R.id.tv_text11)).setText("OFF");
                                break;
                        }
                    }
                    break;
                case 123:
                    if (((TextView) RZCSuburuCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) RZCSuburuCarSet.this.findViewById(R.id.tv_text12)).setText("Low");
                                break;
                            case 2:
                                ((TextView) RZCSuburuCarSet.this.findViewById(R.id.tv_text12)).setText("Mid");
                                break;
                            case 3:
                                ((TextView) RZCSuburuCarSet.this.findViewById(R.id.tv_text12)).setText("Max");
                                break;
                            default:
                                ((TextView) RZCSuburuCarSet.this.findViewById(R.id.tv_text12)).setText("Min");
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0454_rzc_suburu_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus13), this);
        setSelfClick((Button) findViewById(R.id.btn_plus13), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        int value6;
        int value7;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
                int value8 = DataCanbus.DATA[99] - 1;
                if (value8 < 0) {
                    value8 = 3;
                }
                setCarInfo(3, value8);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value9 = DataCanbus.DATA[99] + 1;
                if (value9 > 3) {
                    value9 = 0;
                }
                setCarInfo(3, value9);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value10 = DataCanbus.DATA[100] - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarInfo(4, value10);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value11 = DataCanbus.DATA[100] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo(4, value11);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                if (DataCanbus.DATA[101] == 1) {
                    value4 = 0;
                } else {
                    value4 = 1;
                }
                setCarInfo(5, value4);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                if (DataCanbus.DATA[101] == 1) {
                    value3 = 0;
                } else {
                    value3 = 1;
                }
                setCarInfo(5, value3);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                if (DataCanbus.DATA[102] == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                setCarInfo(6, value);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                int value12 = DataCanbus.DATA[103] + 1;
                if (value12 > 5) {
                    value12 = 0;
                }
                setCarInfo(7, value12);
                break;
            case R.id.btn_plus6 /* 2131427430 */:
                int value13 = DataCanbus.DATA[104] + 1;
                if (value13 > 2) {
                    value13 = 0;
                }
                setCarInfo(8, value13);
                break;
            case R.id.btn_plus7 /* 2131427431 */:
                int value14 = DataCanbus.DATA[105] + 1;
                if (value14 > 3) {
                    value14 = 0;
                }
                setCarInfo(9, value14);
                break;
            case R.id.btn_plus8 /* 2131427432 */:
                int value15 = DataCanbus.DATA[106] + 1;
                if (value15 > 1) {
                    value15 = 0;
                }
                setCarInfo(10, value15);
                break;
            case R.id.btn_plus9 /* 2131427433 */:
                int value16 = DataCanbus.DATA[120] + 1;
                if (value16 > 1) {
                    value16 = 0;
                }
                setCarInfo(12, value16);
                break;
            case R.id.btn_plus10 /* 2131427434 */:
                int value17 = DataCanbus.DATA[121] + 1;
                if (value17 > 3) {
                    value17 = 0;
                }
                setCarInfo(13, value17);
                break;
            case R.id.btn_plus11 /* 2131427435 */:
                int value18 = DataCanbus.DATA[122] + 1;
                if (value18 > 3) {
                    value18 = 0;
                }
                setCarInfo(14, value18);
                break;
            case R.id.btn_plus12 /* 2131427436 */:
                int value19 = DataCanbus.DATA[123] + 1;
                if (value19 > 3) {
                    value19 = 0;
                }
                setCarInfo(15, value19);
                break;
            case R.id.btn_plus13 /* 2131427437 */:
                int value20 = DataCanbus.DATA[37] + 1;
                if (value20 > 1) {
                    value20 = 0;
                }
                setCarInfo(128, value20);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                if (DataCanbus.DATA[102] == 1) {
                    value2 = 0;
                } else {
                    value2 = 1;
                }
                setCarInfo(6, value2);
                break;
            case R.id.btn_minus5 /* 2131427474 */:
                int value21 = DataCanbus.DATA[103] - 1;
                if (value21 < 0) {
                    value21 = 5;
                }
                setCarInfo(7, value21);
                break;
            case R.id.btn_minus6 /* 2131427476 */:
                int value22 = DataCanbus.DATA[104] - 1;
                if (value22 < 0) {
                    value22 = 2;
                }
                setCarInfo(8, value22);
                break;
            case R.id.btn_minus7 /* 2131427478 */:
                int value23 = DataCanbus.DATA[105] - 1;
                if (value23 < 0) {
                    value23 = 3;
                }
                setCarInfo(9, value23);
                break;
            case R.id.btn_minus8 /* 2131427480 */:
                int value24 = DataCanbus.DATA[106] - 1;
                if (value24 < 0) {
                    value24 = 1;
                }
                setCarInfo(10, value24);
                break;
            case R.id.btn_minus9 /* 2131427482 */:
                int value25 = DataCanbus.DATA[120] - 1;
                if (value25 < 0) {
                    value25 = 1;
                }
                setCarInfo(12, value25);
                break;
            case R.id.btn_minus10 /* 2131427484 */:
                int value26 = DataCanbus.DATA[121] - 1;
                if (value26 < 0) {
                    value26 = 3;
                }
                setCarInfo(13, value26);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value27 = DataCanbus.DATA[122] - 1;
                if (value27 < 0) {
                    value27 = 3;
                }
                setCarInfo(14, value27);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value28 = DataCanbus.DATA[123] - 1;
                if (value28 < 0) {
                    value28 = 3;
                }
                setCarInfo(15, value28);
                break;
            case R.id.btn_minus13 /* 2131427490 */:
                int value29 = DataCanbus.DATA[37] - 1;
                if (value29 < 0) {
                    value29 = 1;
                }
                setCarInfo(128, value29);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                if (DataCanbus.DATA[117] == 1) {
                    value7 = 0;
                } else {
                    value7 = 1;
                }
                setCarInfo(1, value7);
                break;
            case R.id.ctv_checkedtext4 /* 2131427552 */:
                if (DataCanbus.DATA[119] == 1) {
                    value5 = 0;
                } else {
                    value5 = 1;
                }
                setCarInfo(11, value5);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                if (DataCanbus.DATA[118] == 1) {
                    value6 = 0;
                } else {
                    value6 = 1;
                }
                setCarInfo(2, value6);
                break;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, RZCSuburuCarEQInfo.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{64, 0}, null, null);
        DataCanbus.PROXY.cmd(1, new int[]{49, 0}, null, null);
        DataCanbus.PROXY.cmd(1, new int[]{37, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText8(int value) {
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text8)).setText("Type2");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text8)).setText("Type1");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText7(int value) {
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text7)).setText("Shift into or out of PARK");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text7)).setText("Ignition off");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text7)).setText("Driver door open");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text7)).setText("Off");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText6(int value) {
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text6)).setText("Vehicle Speed");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text6)).setText("Shift into or out of PARK");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text6)).setText("Off");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText5(int value) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text5)).setText("20s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text5)).setText("30s");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text5)).setText("40s");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text5)).setText("50s");
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text5)).setText("60s");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text5)).setText("Off");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText4(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText("On");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text4)).setText("Off");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText3(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text3)).setText("On");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text3)).setText("Off");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText2(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text2)).setText("15 Minutes");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Continuously");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText1(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText("Off");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText("10s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text1)).setText("20s");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text1)).setText("30s");
                    break;
            }
        }
    }
}
