package com.syu.carinfo.havah6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WC_0320_HavalH9AmpCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.havah6.WC_0320_HavalH9AmpCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 71:
                    if (((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 72:
                    if (((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 10) {
                            ((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text2)).setText("R" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text2)).setText("L" + (10 - value));
                            break;
                        } else if (value == 10) {
                            ((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text2)).setText("0");
                            break;
                        }
                    }
                    break;
                case 73:
                    if (((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value > 10) {
                            ((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text1)).setText("R" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text1)).setText("F" + (10 - value));
                            break;
                        } else if (value == 10) {
                            ((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text1)).setText("0");
                            break;
                        }
                    }
                    break;
                case 74:
                    if (((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 10) {
                            ((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text3)).setText("+" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text3)).setText("-" + (10 - value));
                            break;
                        } else if (value == 10) {
                            ((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text3)).setText("0");
                            break;
                        }
                    }
                    break;
                case 75:
                    if (((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 10) {
                            ((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text4)).setText("+" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text4)).setText("-" + (10 - value));
                            break;
                        } else if (value == 10) {
                            ((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        }
                    }
                    break;
                case 76:
                    if (((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 10) {
                            ((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text5)).setText("+" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text5)).setText("-" + (10 - value));
                            break;
                        } else if (value == 10) {
                            ((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text5)).setText("0");
                            break;
                        }
                    }
                    break;
                case 77:
                    if (((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 78:
                    if (((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_surroundsound);
                                break;
                            case 1:
                                ((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.haval_volspeed1);
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
        setContentView(R.layout.layout_0320_wc_haval_h9_amp_settings);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427480 */:
                int value = DataCanbus.DATA[73];
                if (value > 0) {
                    value--;
                }
                setCarInfo(3, value);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value2 = DataCanbus.DATA[73];
                if (value2 < 20) {
                    value2++;
                }
                setCarInfo(3, value2);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value3 = DataCanbus.DATA[72];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value4 = DataCanbus.DATA[72];
                if (value4 < 20) {
                    value4++;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value5 = DataCanbus.DATA[74];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(4, value5);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value6 = DataCanbus.DATA[74];
                if (value6 < 20) {
                    value6++;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value7 = DataCanbus.DATA[75];
                if (value7 > 0) {
                    value7--;
                }
                setCarInfo(5, value7);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value8 = DataCanbus.DATA[75];
                if (value8 < 20) {
                    value8++;
                }
                setCarInfo(5, value8);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value9 = DataCanbus.DATA[76];
                if (value9 > 0) {
                    value9--;
                }
                setCarInfo(6, value9);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value10 = DataCanbus.DATA[76];
                if (value10 < 20) {
                    value10++;
                }
                setCarInfo(6, value10);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                setCarInfo(1, 255);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                setCarInfo(1, 1);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value11 = DataCanbus.DATA[77] - 1;
                if (value11 < 0) {
                    value11 = 3;
                }
                setCarInfo(7, value11);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value12 = DataCanbus.DATA[77] + 1;
                if (value12 > 3) {
                    value12 = 0;
                }
                setCarInfo(7, value12);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value13 = DataCanbus.DATA[78] - 1;
                if (value13 < 0) {
                    value13 = 1;
                }
                setCarInfo(8, value13);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value14 = DataCanbus.DATA[78] + 1;
                if (value14 > 1) {
                    value14 = 0;
                }
                setCarInfo(8, value14);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(8, new int[]{value0, value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
    }
}
