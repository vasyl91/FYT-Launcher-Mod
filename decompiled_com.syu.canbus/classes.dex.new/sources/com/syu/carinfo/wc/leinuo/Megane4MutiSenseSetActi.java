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
public class Megane4MutiSenseSetActi extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.leinuo.Megane4MutiSenseSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 115:
                    if (((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text3)).setText("Sport");
                                break;
                            case 1:
                                ((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text3)).setText("Comfort");
                                break;
                            case 2:
                                ((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text3)).setText("Neutral");
                                break;
                            case 3:
                                ((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text3)).setText("Eco");
                                break;
                            case 4:
                                ((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text3)).setText("Perso");
                                break;
                        }
                    }
                    break;
                case 116:
                    if (((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text4)).setText("Style1");
                                break;
                            case 1:
                                ((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text4)).setText("Style2");
                                break;
                            case 2:
                                ((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text4)).setText("Style3");
                                break;
                            case 3:
                                ((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text4)).setText("Style4");
                                break;
                        }
                    }
                    break;
                case 117:
                    if (((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text5)).setText("Sport");
                                break;
                            case 1:
                                ((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text5)).setText("Comfort");
                                break;
                            case 2:
                                ((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text5)).setText("Neutral");
                                break;
                        }
                    }
                    break;
                case 118:
                    if (((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text6)).setText("Sport");
                                break;
                            case 2:
                                ((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text6)).setText("Neutral");
                                break;
                            case 3:
                                ((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text6)).setText("Eco");
                                break;
                        }
                    }
                    break;
                case 119:
                    if (((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text7)).setText("Neutral");
                                break;
                            case 3:
                                ((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text7)).setText("Eco");
                                break;
                        }
                    }
                    break;
                case 166:
                    if (((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text21)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text21)).setText("Comfort");
                                break;
                            case 2:
                                ((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text21)).setText("Neutral");
                                break;
                            default:
                                ((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text21)).setText("Sport");
                                break;
                        }
                    }
                    break;
                case 167:
                    if (((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text22)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text22)).setText("Comfort");
                                break;
                            case 2:
                                ((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text22)).setText("Neutral");
                                break;
                            default:
                                ((TextView) Megane4MutiSenseSetActi.this.findViewById(R.id.tv_text22)).setText("Sport");
                                break;
                        }
                    }
                    break;
                case 173:
                    int on = (value >> 1) & 1;
                    Megane4MutiSenseSetActi.this.setCheck((CheckedTextView) Megane4MutiSenseSetActi.this.findViewById(R.id.ctv_checkedtext1), on == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0352_wc_magane_mutisense_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus21), this);
        setSelfClick((Button) findViewById(R.id.btn_plus21), this);
        setSelfClick((Button) findViewById(R.id.btn_minus22), this);
        setSelfClick((Button) findViewById(R.id.btn_plus22), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        switch (v.getId()) {
            case R.id.btn_minus3 /* 2131427462 */:
                int value3 = DataCanbus.DATA[115] - 1;
                if (value3 < 0) {
                    value3 = 4;
                }
                setCarInfo(7, value3, 0, 0);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value4 = DataCanbus.DATA[115] + 1;
                if (value4 > 4) {
                    value4 = 0;
                }
                setCarInfo(7, value4, 0, 0);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value5 = DataCanbus.DATA[116] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(8, value5, 0, 0);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value6 = DataCanbus.DATA[116] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(8, value6, 0, 0);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value7 = DataCanbus.DATA[117] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(9, value7, 0, 0);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value8 = DataCanbus.DATA[117] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(9, value8, 0, 0);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value9 = DataCanbus.DATA[118];
                if (value9 == 0) {
                    value9 = 3;
                } else if (value9 == 3) {
                    value9 = 2;
                } else if (value9 == 2) {
                    value9 = 0;
                }
                setCarInfo(10, value9, 0, 0);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value10 = DataCanbus.DATA[118];
                if (value10 == 0) {
                    value10 = 2;
                } else if (value10 == 2) {
                    value10 = 3;
                } else if (value10 == 3) {
                    value10 = 0;
                }
                setCarInfo(10, value10, 0, 0);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                if (DataCanbus.DATA[119] == 3) {
                    value2 = 2;
                } else {
                    value2 = 3;
                }
                setCarInfo(11, value2, 0, 0);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                if (DataCanbus.DATA[119] == 2) {
                    value = 3;
                } else {
                    value = 2;
                }
                setCarInfo(11, value, 0, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value11 = (DataCanbus.DATA[173] >> 1) & 1;
                if (value11 == 0) {
                    value11 = 1;
                } else if (value11 == 1) {
                    value11 = 0;
                }
                setCarInfo(92, value11, 0, 0);
                break;
            case R.id.btn_minus21 /* 2131427600 */:
                int value12 = DataCanbus.DATA[166] - 1;
                if (value12 < 0) {
                    value12 = 2;
                }
                setCarInfo(74, value12, 0, 0);
                break;
            case R.id.btn_plus21 /* 2131427602 */:
                int value13 = DataCanbus.DATA[166] + 1;
                if (value13 > 2) {
                    value13 = 0;
                }
                setCarInfo(74, value13, 0, 0);
                break;
            case R.id.btn_minus22 /* 2131427603 */:
                int value14 = DataCanbus.DATA[167] - 1;
                if (value14 < 0) {
                    value14 = 2;
                }
                setCarInfo(75, value14, 0, 0);
                break;
            case R.id.btn_plus22 /* 2131427605 */:
                int value15 = DataCanbus.DATA[167] + 1;
                if (value15 > 2) {
                    value15 = 0;
                }
                setCarInfo(75, value15, 0, 0);
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
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
    }
}
