package com.syu.carinfo.wc.leinuo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Megane4DriveAssitSetActi extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.leinuo.Megane4DriveAssitSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 124:
                    Megane4DriveAssitSetActi.this.setCheck((CheckedTextView) Megane4DriveAssitSetActi.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 138:
                    if (((TextView) Megane4DriveAssitSetActi.this.findViewById(R.id.tv_text15)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Megane4DriveAssitSetActi.this.findViewById(R.id.tv_text15)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) Megane4DriveAssitSetActi.this.findViewById(R.id.tv_text15)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) Megane4DriveAssitSetActi.this.findViewById(R.id.tv_text15)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 139:
                    if (((TextView) Megane4DriveAssitSetActi.this.findViewById(R.id.tv_text16)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Megane4DriveAssitSetActi.this.findViewById(R.id.tv_text16)).setText(R.string.jeep_lanesensewarn_0);
                                break;
                            case 1:
                                ((TextView) Megane4DriveAssitSetActi.this.findViewById(R.id.tv_text16)).setText(R.string.jeep_lanesensewarn_1);
                                break;
                            case 2:
                                ((TextView) Megane4DriveAssitSetActi.this.findViewById(R.id.tv_text16)).setText(R.string.jeep_lanesensewarn_2);
                                break;
                        }
                    }
                    break;
                case 140:
                    Megane4DriveAssitSetActi.this.setCheck((CheckedTextView) Megane4DriveAssitSetActi.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 141:
                    Megane4DriveAssitSetActi.this.setCheck((CheckedTextView) Megane4DriveAssitSetActi.this.findViewById(R.id.ctv_checkedtext18), value == 1);
                    break;
                case 174:
                    Megane4DriveAssitSetActi.this.setCheck((CheckedTextView) Megane4DriveAssitSetActi.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 175:
                    if (((TextView) Megane4DriveAssitSetActi.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Megane4DriveAssitSetActi.this.findViewById(R.id.tv_text6)).setText(R.string.wc_372_mid);
                                break;
                            case 2:
                                ((TextView) Megane4DriveAssitSetActi.this.findViewById(R.id.tv_text6)).setText(R.string.wc_372_high);
                                break;
                            default:
                                ((TextView) Megane4DriveAssitSetActi.this.findViewById(R.id.tv_text6)).setText(R.string.wc_372_low);
                                break;
                        }
                    }
                    break;
                case 176:
                    if (((TextView) Megane4DriveAssitSetActi.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) Megane4DriveAssitSetActi.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 177:
                    Megane4DriveAssitSetActi.this.setCheck((CheckedTextView) Megane4DriveAssitSetActi.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 178:
                    Megane4DriveAssitSetActi.this.setCheck((CheckedTextView) Megane4DriveAssitSetActi.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 179:
                    Megane4DriveAssitSetActi.this.setCheck((CheckedTextView) Megane4DriveAssitSetActi.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 180:
                    Megane4DriveAssitSetActi.this.setCheck((CheckedTextView) Megane4DriveAssitSetActi.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 182:
                    if (((TextView) Megane4DriveAssitSetActi.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Megane4DriveAssitSetActi.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_Manual);
                                break;
                            default:
                                ((TextView) Megane4DriveAssitSetActi.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_auto);
                                break;
                        }
                    }
                    break;
                case 200:
                    Megane4DriveAssitSetActi.this.setCheck((CheckedTextView) Megane4DriveAssitSetActi.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 201:
                    Megane4DriveAssitSetActi.this.setCheck((CheckedTextView) Megane4DriveAssitSetActi.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 202:
                    Megane4DriveAssitSetActi.this.setCheck((CheckedTextView) Megane4DriveAssitSetActi.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 203:
                    Megane4DriveAssitSetActi.this.setCheck((CheckedTextView) Megane4DriveAssitSetActi.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 204:
                    if (((TextView) Megane4DriveAssitSetActi.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Megane4DriveAssitSetActi.this.findViewById(R.id.tv_text10)).setText(R.string.jeep_lanesensewarn_1);
                                break;
                            case 2:
                                ((TextView) Megane4DriveAssitSetActi.this.findViewById(R.id.tv_text10)).setText(R.string.jeep_lanesensewarn_2);
                                break;
                            default:
                                ((TextView) Megane4DriveAssitSetActi.this.findViewById(R.id.tv_text10)).setText(R.string.jeep_lanesensewarn_0);
                                break;
                        }
                    }
                    break;
                case 205:
                    Megane4DriveAssitSetActi.this.setCheck((CheckedTextView) Megane4DriveAssitSetActi.this.findViewById(R.id.ctv_checkedtext22), value == 1);
                    break;
                case 206:
                    Megane4DriveAssitSetActi.this.setCheck((CheckedTextView) Megane4DriveAssitSetActi.this.findViewById(R.id.ctv_checkedtext23), value == 1);
                    break;
                case 207:
                    if (((TextView) Megane4DriveAssitSetActi.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Megane4DriveAssitSetActi.this.findViewById(R.id.tv_text11)).setText("All");
                                break;
                            default:
                                ((TextView) Megane4DriveAssitSetActi.this.findViewById(R.id.tv_text11)).setText("Perso");
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
        setContentView(R.layout.layout_0352_wc_magane_driveassit_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext13), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext14), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext15), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext17), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext18), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext22), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext23), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus15), this);
        setSelfClick((Button) findViewById(R.id.btn_plus15), this);
        setSelfClick((Button) findViewById(R.id.btn_minus16), this);
        setSelfClick((Button) findViewById(R.id.btn_plus16), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus6 /* 2131427471 */:
                int value = DataCanbus.DATA[175] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(65, value, 0, 0);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value2 = DataCanbus.DATA[175] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(65, value2, 0, 0);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value3 = DataCanbus.DATA[176];
                if (value3 > 1) {
                    value3--;
                }
                setCarInfo(66, value3, 0, 0);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value4 = DataCanbus.DATA[176];
                if (value4 < 5) {
                    value4++;
                }
                setCarInfo(66, value4, 0, 0);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value5 = DataCanbus.DATA[182] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(72, value5, 0, 0);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value6 = DataCanbus.DATA[182] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(72, value6, 0, 0);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value7 = DataCanbus.DATA[204] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(98, value7, 0, 0);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value8 = DataCanbus.DATA[204] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(98, value8, 0, 0);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value9 = DataCanbus.DATA[207] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(101, value9, 0, 0);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value10 = DataCanbus.DATA[207] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(101, value10, 0, 0);
                break;
            case R.id.btn_minus15 /* 2131427498 */:
                int value11 = DataCanbus.DATA[138] - 1;
                if (value11 < 0) {
                    value11 = 2;
                }
                setCarInfo(32, value11, 0, 0);
                break;
            case R.id.btn_plus15 /* 2131427500 */:
                int value12 = DataCanbus.DATA[138] + 1;
                if (value12 > 2) {
                    value12 = 0;
                }
                setCarInfo(32, value12, 0, 0);
                break;
            case R.id.btn_minus16 /* 2131427501 */:
                int value13 = DataCanbus.DATA[139] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                setCarInfo(33, value13, 0, 0);
                break;
            case R.id.btn_plus16 /* 2131427503 */:
                int value14 = DataCanbus.DATA[139] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                setCarInfo(33, value14, 0, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value15 = DataCanbus.DATA[200];
                if (value15 == 0) {
                    value15 = 1;
                } else if (value15 == 1) {
                    value15 = 0;
                }
                setCarInfo(94, value15, 0, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value16 = DataCanbus.DATA[203];
                if (value16 == 0) {
                    value16 = 1;
                } else if (value16 == 1) {
                    value16 = 0;
                }
                setCarInfo(97, value16, 0, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value17 = DataCanbus.DATA[201];
                if (value17 == 0) {
                    value17 = 1;
                } else if (value17 == 1) {
                    value17 = 0;
                }
                setCarInfo(95, value17, 0, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value18 = DataCanbus.DATA[202];
                if (value18 == 0) {
                    value18 = 1;
                } else if (value18 == 1) {
                    value18 = 0;
                }
                setCarInfo(96, value18, 0, 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int value19 = DataCanbus.DATA[124];
                if (value19 == 0) {
                    value19 = 1;
                } else if (value19 == 1) {
                    value19 = 0;
                }
                setCarInfo(16, value19, 0, 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                int value20 = DataCanbus.DATA[174];
                if (value20 == 0) {
                    value20 = 1;
                } else if (value20 == 1) {
                    value20 = 0;
                }
                setCarInfo(64, value20, 0, 0);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                int value21 = DataCanbus.DATA[177];
                if (value21 == 0) {
                    value21 = 1;
                } else if (value21 == 1) {
                    value21 = 0;
                }
                setCarInfo(67, value21, 0, 0);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                int value22 = DataCanbus.DATA[178];
                if (value22 == 0) {
                    value22 = 1;
                } else if (value22 == 1) {
                    value22 = 0;
                }
                setCarInfo(68, value22, 0, 0);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                int value23 = DataCanbus.DATA[179];
                if (value23 == 0) {
                    value23 = 1;
                } else if (value23 == 1) {
                    value23 = 0;
                }
                setCarInfo(69, value23, 0, 0);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                int value24 = DataCanbus.DATA[180];
                if (value24 == 0) {
                    value24 = 1;
                } else if (value24 == 1) {
                    value24 = 0;
                }
                setCarInfo(70, value24, 0, 0);
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                int value25 = DataCanbus.DATA[140];
                if (value25 == 0) {
                    value25 = 1;
                } else if (value25 == 1) {
                    value25 = 0;
                }
                setCarInfo(34, value25, 0, 0);
                break;
            case R.id.ctv_checkedtext18 /* 2131427764 */:
                int value26 = DataCanbus.DATA[141];
                if (value26 == 0) {
                    value26 = 1;
                } else if (value26 == 1) {
                    value26 = 0;
                }
                setCarInfo(35, value26, 0, 0);
                break;
            case R.id.ctv_checkedtext22 /* 2131427772 */:
                int value27 = DataCanbus.DATA[205];
                if (value27 == 0) {
                    value27 = 1;
                } else if (value27 == 1) {
                    value27 = 0;
                }
                setCarInfo(99, value27, 0, 0);
                break;
            case R.id.ctv_checkedtext23 /* 2131427775 */:
                int value28 = DataCanbus.DATA[206];
                if (value28 == 0) {
                    value28 = 1;
                } else if (value28 == 1) {
                    value28 = 0;
                }
                setCarInfo(100, value28, 0, 0);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1, value2, value3}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[207].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[207].removeNotify(this.mNotifyCanbus);
    }
}
