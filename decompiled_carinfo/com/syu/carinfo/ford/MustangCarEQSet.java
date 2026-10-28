package com.syu.carinfo.ford;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class MustangCarEQSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 37:
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
                case 159:
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
                case 160:
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
                case 161:
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
                case 162:
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
                case 163:
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
                case 164:
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
                case 165:
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
                case 166:
                    if (((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) MustangCarEQSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 197:
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0334_rzc_mustang_eqsettings);
        init();
    }

    @Override
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[159];
                if (value > 0) {
                    value--;
                }
                setCarInfo(0, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[159];
                if (value2 < 14) {
                    value2++;
                }
                setCarInfo(0, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[160];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(1, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[160];
                if (value4 < 14) {
                    value4++;
                }
                setCarInfo(1, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[161];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(2, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[161];
                if (value6 < 14) {
                    value6++;
                }
                setCarInfo(2, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[162];
                if (value7 > 0) {
                    value7--;
                }
                setCarInfo(3, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[162];
                if (value8 < 14) {
                    value8++;
                }
                setCarInfo(3, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[163];
                if (value9 > 0) {
                    value9--;
                }
                setCarInfo(4, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[163];
                if (value10 < 14) {
                    value10++;
                }
                setCarInfo(4, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[164];
                if (value11 > 0) {
                    value11--;
                }
                setCarInfo(5, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[164];
                if (value12 < 3) {
                    value12++;
                }
                setCarInfo(5, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
            case R.id.btn_plus7 /* 2131427475 */:
                int value13 = DataCanbus.DATA[165];
                if (value13 == 0) {
                    value13 = 1;
                } else if (value13 == 1) {
                    value13 = 0;
                }
                setCarInfo(6, value13);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
            case R.id.btn_plus8 /* 2131427478 */:
                int value14 = DataCanbus.DATA[197];
                if (value14 == 0) {
                    value14 = 1;
                } else if (value14 == 1) {
                    value14 = 0;
                }
                setCarInfo(7, value14);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value15 = DataCanbus.DATA[166];
                if (value15 > 0) {
                    value15--;
                }
                setCarInfo1(value15);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value16 = DataCanbus.DATA[166];
                if (value16 < 30) {
                    value16++;
                }
                setCarInfo1(value16);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
            case R.id.btn_plus10 /* 2131427484 */:
                int value17 = DataCanbus.DATA[37] & 255;
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

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{98}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
    }
}
