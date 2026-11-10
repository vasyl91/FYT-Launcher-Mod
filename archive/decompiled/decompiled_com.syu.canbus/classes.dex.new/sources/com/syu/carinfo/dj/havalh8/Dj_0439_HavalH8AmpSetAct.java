package com.syu.carinfo.dj.havalh8;

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
public class Dj_0439_HavalH8AmpSetAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dj.havalh8.Dj_0439_HavalH8AmpSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 142:
                    if (((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 143:
                    if (((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text3)).setText("+" + (value - 10));
                        } else if (value < 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text3)).setText("-" + (10 - value));
                        } else {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text3)).setText("0");
                        }
                    }
                    break;
                case 144:
                    if (((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text2)).setText("+" + (value - 10));
                        } else if (value < 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text2)).setText("-" + (10 - value));
                        } else {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text2)).setText("0");
                        }
                    }
                    break;
                case 145:
                    if (((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text1)) != null) {
                        if (value > 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text1)).setText("+" + (value - 10));
                        } else if (value < 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text1)).setText("-" + (10 - value));
                        } else {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text1)).setText("0");
                        }
                    }
                    break;
                case 146:
                    if (((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text4)).setText("R" + (value - 10));
                        } else if (value < 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text4)).setText("L" + (10 - value));
                        } else {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text4)).setText("0");
                        }
                    }
                    break;
                case 147:
                    if (((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text5)).setText("R" + (value - 10));
                        } else if (value < 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text5)).setText("F" + (10 - value));
                        } else {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text5)).setText("0");
                        }
                    }
                    break;
                case 148:
                    if (((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 149:
                    Dj_0439_HavalH8AmpSetAct.this.setCheck((CheckedTextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_dj_h8_amp_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int bass = DataCanbus.DATA[145];
                if (bass > 0) {
                    bass--;
                }
                setCarInfo(5, bass);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int bass2 = DataCanbus.DATA[145];
                if (bass2 < 20) {
                    bass2++;
                }
                setCarInfo(5, bass2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int mid = DataCanbus.DATA[144];
                if (mid > 0) {
                    mid--;
                }
                setCarInfo(4, mid);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int mid2 = DataCanbus.DATA[144];
                if (mid2 < 20) {
                    mid2++;
                }
                setCarInfo(4, mid2);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int treb = DataCanbus.DATA[143];
                if (treb > 0) {
                    treb--;
                }
                setCarInfo(3, treb);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int treb2 = DataCanbus.DATA[143];
                if (treb2 < 20) {
                    treb2++;
                }
                setCarInfo(3, treb2);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int bal = DataCanbus.DATA[146];
                if (bal > 0) {
                    bal--;
                }
                setCarInfo(2, bal);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int bal2 = DataCanbus.DATA[146];
                if (bal2 < 20) {
                    bal2++;
                }
                setCarInfo(2, bal2);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int fad = DataCanbus.DATA[147];
                if (fad > 0) {
                    fad--;
                }
                setCarInfo(1, fad);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int fad2 = DataCanbus.DATA[147];
                if (fad2 < 20) {
                    fad2++;
                }
                setCarInfo(1, fad2);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value = DataCanbus.DATA[148];
                if (value > 0) {
                    value--;
                }
                setCarInfo(6, value);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value2 = DataCanbus.DATA[148];
                if (value2 < 3) {
                    value2++;
                }
                setCarInfo(6, value2);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value3 = DataCanbus.DATA[142];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(8, value3);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value4 = DataCanbus.DATA[142];
                if (value4 < 40) {
                    value4++;
                }
                setCarInfo(8, value4);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value5 = DataCanbus.DATA[149];
                if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                setCarInfo(7, value5);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(6, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(7, new int[]{49}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
    }
}
