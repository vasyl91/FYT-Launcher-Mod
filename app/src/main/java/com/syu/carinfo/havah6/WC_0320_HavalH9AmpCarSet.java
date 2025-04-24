package com.syu.carinfo.havah6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class WC_0320_HavalH9AmpCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 142:
                    if (((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) WC_0320_HavalH9AmpCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 143:
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
                case 144:
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
                case 145:
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
                case 146:
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
                case 147:
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
                case 148:
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
                case 149:
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0320_wc_haval_h9_amp_settings);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[144];
                if (value > 0) {
                    value--;
                }
                setCarInfo(3, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[144];
                if (value2 < 20) {
                    value2++;
                }
                setCarInfo(3, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[143];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[143];
                if (value4 < 20) {
                    value4++;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[145];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(4, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[145];
                if (value6 < 20) {
                    value6++;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[146];
                if (value7 > 0) {
                    value7--;
                }
                setCarInfo(5, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[146];
                if (value8 < 20) {
                    value8++;
                }
                setCarInfo(5, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[147];
                if (value9 > 0) {
                    value9--;
                }
                setCarInfo(6, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[147];
                if (value10 < 20) {
                    value10++;
                }
                setCarInfo(6, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                setCarInfo(1, 255);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                setCarInfo(1, 1);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value11 = DataCanbus.DATA[148] - 1;
                if (value11 < 0) {
                    value11 = 3;
                }
                setCarInfo(7, value11);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value12 = DataCanbus.DATA[148] + 1;
                if (value12 > 3) {
                    value12 = 0;
                }
                setCarInfo(7, value12);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value13 = DataCanbus.DATA[149] - 1;
                if (value13 < 0) {
                    value13 = 1;
                }
                setCarInfo(8, value13);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value14 = DataCanbus.DATA[149] + 1;
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

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
    }
}
