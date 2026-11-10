package com.syu.carinfo.wc.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Wc_372_UnitActi extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_UnitActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 37:
                    if (((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text5)) != null) {
                        if (value == 1) {
                            ((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text5)).setText("℃");
                        } else if (value == 2) {
                            ((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text5)).setText("℉");
                        } else {
                            ((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text5)).setText("℃");
                        }
                    }
                    break;
                case 131:
                    if (((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text1)) != null) {
                        if (value == 1) {
                            ((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_unit_metric);
                        } else if (value == 2) {
                            ((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_unit_us_imperial);
                        } else if (value == 3) {
                            ((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text1)).setText(R.string.wc_17zhinanzhe_str1);
                        } else {
                            ((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_unit_metric);
                        }
                    }
                    break;
                case 141:
                    if (((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text4)) != null) {
                        if (value == 0) {
                            ((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text4)).setText("psi");
                        } else if (value == 1) {
                            ((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text4)).setText("kpa");
                        } else if (value == 2) {
                            ((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text4)).setText("bar");
                        } else {
                            ((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text4)).setText("psi");
                        }
                    }
                    break;
                case 161:
                    if (((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text6)) != null) {
                        if (value == 1) {
                            ((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text6)).setText("L/100KM");
                        } else if (value == 2) {
                            ((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text6)).setText("KM/L");
                        } else if (value == 3) {
                            ((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text6)).setText("MPG(UK)");
                        } else if (value == 4) {
                            ((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text6)).setText("MPG(US)");
                        } else {
                            ((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text6)).setText("L/100KM");
                        }
                    }
                    break;
                case 164:
                    if (((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text3)) != null) {
                        if (value == 1) {
                            ((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text3)).setText("km");
                        } else if (value == 2) {
                            ((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text3)).setText("mile");
                        } else {
                            ((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text3)).setText("km");
                        }
                    }
                    break;
                case 217:
                    if (((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text2)) != null) {
                        if (value == 0) {
                            ((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text2)).setText("mph");
                        } else if (value == 1) {
                            ((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text2)).setText("km/h");
                        } else {
                            ((TextView) Wc_372_UnitActi.this.findViewById(R.id.tv_text2)).setText("mph");
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_372_zyg_unit);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[131] - 1;
                if (value < 1) {
                    value = 3;
                }
                setCarInfo(7, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[131] + 1;
                if (value2 > 3) {
                    value2 = 1;
                }
                setCarInfo(7, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[217] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[217] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[164] - 1;
                if (value5 < 1) {
                    value5 = 2;
                }
                setCarInfo(1, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[164] + 1;
                if (value6 > 2) {
                    value6 = 1;
                }
                setCarInfo(1, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[141] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(6, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[141] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(6, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[37] - 1;
                if (value9 < 1) {
                    value9 = 2;
                }
                setCarInfo(3, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[37] + 1;
                if (value10 > 2) {
                    value10 = 1;
                }
                setCarInfo(3, value10);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[161] - 1;
                if (value11 < 1) {
                    value11 = 4;
                }
                setCarInfo(5, value11);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[161] + 1;
                if (value12 > 4) {
                    value12 = 1;
                }
                setCarInfo(5, value12);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(4, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[217].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[217].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
    }
}
