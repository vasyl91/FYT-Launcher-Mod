package com.syu.carinfo.dj.havalh8;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Dj_0439_HavalH8AmpSetAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 142:
                    if (Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text7) != null) {
                        ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value));
                        break;
                    }
                case 143:
                    if (Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text3) != null) {
                        if (value > 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text3)).setText("+" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text3)).setText("-" + (10 - value));
                            break;
                        } else {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text3)).setText("0");
                            break;
                        }
                    }
                    break;
                case 144:
                    if (Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text2) != null) {
                        if (value > 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text2)).setText("+" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text2)).setText("-" + (10 - value));
                            break;
                        } else {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text2)).setText("0");
                            break;
                        }
                    }
                    break;
                case 145:
                    if (Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text1) != null) {
                        if (value > 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text1)).setText("+" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text1)).setText("-" + (10 - value));
                            break;
                        } else {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text1)).setText("0");
                            break;
                        }
                    }
                    break;
                case 146:
                    if (Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text4) != null) {
                        if (value > 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text4)).setText("R" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text4)).setText("L" + (10 - value));
                            break;
                        } else {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        }
                    }
                    break;
                case 147:
                    if (Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text5) != null) {
                        if (value > 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text5)).setText("R" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text5)).setText("F" + (10 - value));
                            break;
                        } else {
                            ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text5)).setText("0");
                            break;
                        }
                    }
                    break;
                case 148:
                    if (Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text6) != null) {
                        ((TextView) Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value));
                        break;
                    }
                case 149:
                    Dj_0439_HavalH8AmpSetAct.this.setCheck(Dj_0439_HavalH8AmpSetAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_dj_h8_amp_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick(findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick(findViewById(R.id.btn_minus1), this);
        setSelfClick(findViewById(R.id.btn_plus1), this);
        setSelfClick(findViewById(R.id.btn_minus2), this);
        setSelfClick(findViewById(R.id.btn_plus2), this);
        setSelfClick(findViewById(R.id.btn_minus3), this);
        setSelfClick(findViewById(R.id.btn_plus3), this);
        setSelfClick(findViewById(R.id.btn_minus4), this);
        setSelfClick(findViewById(R.id.btn_plus4), this);
        setSelfClick(findViewById(R.id.btn_minus5), this);
        setSelfClick(findViewById(R.id.btn_plus5), this);
        setSelfClick(findViewById(R.id.btn_minus6), this);
        setSelfClick(findViewById(R.id.btn_plus6), this);
        setSelfClick(findViewById(R.id.btn_minus7), this);
        setSelfClick(findViewById(R.id.btn_plus7), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int bass = DataCanbus.DATA[145];
                if (bass > 0) {
                    bass--;
                }
                setCarInfo(5, bass);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int bass2 = DataCanbus.DATA[145];
                if (bass2 < 20) {
                    bass2++;
                }
                setCarInfo(5, bass2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int mid = DataCanbus.DATA[144];
                if (mid > 0) {
                    mid--;
                }
                setCarInfo(4, mid);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int mid2 = DataCanbus.DATA[144];
                if (mid2 < 20) {
                    mid2++;
                }
                setCarInfo(4, mid2);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int treb = DataCanbus.DATA[143];
                if (treb > 0) {
                    treb--;
                }
                setCarInfo(3, treb);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int treb2 = DataCanbus.DATA[143];
                if (treb2 < 20) {
                    treb2++;
                }
                setCarInfo(3, treb2);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int bal = DataCanbus.DATA[146];
                if (bal > 0) {
                    bal--;
                }
                setCarInfo(2, bal);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int bal2 = DataCanbus.DATA[146];
                if (bal2 < 20) {
                    bal2++;
                }
                setCarInfo(2, bal2);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int fad = DataCanbus.DATA[147];
                if (fad > 0) {
                    fad--;
                }
                setCarInfo(1, fad);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int fad2 = DataCanbus.DATA[147];
                if (fad2 < 20) {
                    fad2++;
                }
                setCarInfo(1, fad2);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value = DataCanbus.DATA[148];
                if (value > 0) {
                    value--;
                }
                setCarInfo(6, value);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value2 = DataCanbus.DATA[148];
                if (value2 < 3) {
                    value2++;
                }
                setCarInfo(6, value2);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value3 = DataCanbus.DATA[142];
                if (value3 > 0) {
                    int i = value3 - 1;
                    break;
                }
            case R.id.btn_plus7 /* 2131427475 */:
                int value4 = DataCanbus.DATA[142];
                if (value4 < 40) {
                    int i2 = value4 + 1;
                    break;
                }
            case R.id.ctv_checkedtext1 /* 2131427525 */:
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

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(7, new int[]{49}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
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

    @Override
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
