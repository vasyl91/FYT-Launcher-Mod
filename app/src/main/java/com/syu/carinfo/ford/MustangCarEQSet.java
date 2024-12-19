package com.syu.carinfo.ford;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class MustangCarEQSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ford.MustangCarEQSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 28:
                    if (((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text10)).setText("℃");
                                break;
                            case 1:
                                ((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text10)).setText("℉");
                                break;
                        }
                    }
                    break;
                case 91:
                    if (((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value >= 7) {
                            ((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value - 7).toString());
                            break;
                        } else {
                            ((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text1)).setText("-" + (7 - value));
                            break;
                        }
                    }
                    break;
                case 92:
                    if (((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value >= 7) {
                            ((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value - 7).toString());
                            break;
                        } else {
                            ((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text2)).setText("-" + (7 - value));
                            break;
                        }
                    }
                    break;
                case 93:
                    if (((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value >= 7) {
                            ((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value - 7).toString());
                            break;
                        } else {
                            ((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text3)).setText("-" + (7 - value));
                            break;
                        }
                    }
                    break;
                case 94:
                    if (((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value >= 7) {
                            ((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value - 7).toString());
                            break;
                        } else {
                            ((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text4)).setText("-" + (7 - value));
                            break;
                        }
                    }
                    break;
                case 95:
                    if (((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (value >= 7) {
                            ((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value - 7).toString());
                            break;
                        } else {
                            ((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text5)).setText("-" + (7 - value));
                            break;
                        }
                    }
                    break;
                case 96:
                    if (((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text6)).setText(R.string.wc_372_low);
                                break;
                            case 2:
                                ((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text6)).setText(R.string.wc_372_mid);
                                break;
                            case 3:
                                ((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text6)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 97:
                    if (((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text7)).setText(R.string.haval_volspeed1);
                                break;
                            case 1:
                                ((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text7)).setText(R.string.jeep_surroundsound);
                                break;
                        }
                    }
                    break;
                case 98:
                    if (((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 130:
                    if (((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_252_sound_distribution1);
                                break;
                            case 1:
                                ((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_252_sound_distribution0);
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
        setContentView(R.layout.layout_0334_rzc_mustang_eqsettings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427480 */:
                int value = DataCanbus.DATA[91];
                if (value > 0) {
                    value--;
                }
                setCarInfo(0, value);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value2 = DataCanbus.DATA[91];
                if (value2 < 14) {
                    value2++;
                }
                setCarInfo(0, value2);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value3 = DataCanbus.DATA[92];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(1, value3);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value4 = DataCanbus.DATA[92];
                if (value4 < 14) {
                    value4++;
                }
                setCarInfo(1, value4);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value5 = DataCanbus.DATA[93];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(2, value5);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value6 = DataCanbus.DATA[93];
                if (value6 < 14) {
                    value6++;
                }
                setCarInfo(2, value6);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value7 = DataCanbus.DATA[94];
                if (value7 > 0) {
                    value7--;
                }
                setCarInfo(3, value7);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value8 = DataCanbus.DATA[94];
                if (value8 < 14) {
                    value8++;
                }
                setCarInfo(3, value8);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value9 = DataCanbus.DATA[95];
                if (value9 > 0) {
                    value9--;
                }
                setCarInfo(4, value9);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value10 = DataCanbus.DATA[95];
                if (value10 < 14) {
                    value10++;
                }
                setCarInfo(4, value10);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value11 = DataCanbus.DATA[96];
                if (value11 > 0) {
                    value11--;
                }
                setCarInfo(5, value11);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value12 = DataCanbus.DATA[96];
                if (value12 < 3) {
                    value12++;
                }
                setCarInfo(5, value12);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
            case R.id.btn_plus7 /* 2131427507 */:
                int value13 = DataCanbus.DATA[97];
                if (value13 == 0) {
                    value13 = 1;
                } else if (value13 == 1) {
                    value13 = 0;
                }
                setCarInfo(6, value13);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
            case R.id.btn_plus8 /* 2131427511 */:
                int value14 = DataCanbus.DATA[130];
                if (value14 == 0) {
                    value14 = 1;
                } else if (value14 == 1) {
                    value14 = 0;
                }
                setCarInfo(7, value14);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value15 = DataCanbus.DATA[98];
                if (value15 > 0) {
                    value15--;
                }
                setCarInfo1(value15);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value16 = DataCanbus.DATA[98];
                if (value16 < 30) {
                    value16++;
                }
                setCarInfo1(value16);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
            case R.id.btn_plus10 /* 2131427519 */:
                int value17 = DataCanbus.DATA[28] & 255;
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{255, value17}, null, null);
                break;
        }
    }

    public void setCarInfo1(int value1) {
        DataCanbus.PROXY.cmd(7, new int[]{value1}, null, null);
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(8, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{98}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
    }
}
