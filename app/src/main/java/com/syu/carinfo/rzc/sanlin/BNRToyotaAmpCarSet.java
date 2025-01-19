package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class BNRToyotaAmpCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 153:
                    if (((TextView) BNRToyotaAmpCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value > 7) {
                            ((TextView) BNRToyotaAmpCarSet.this.findViewById(R.id.tv_text1)).setText("R" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) BNRToyotaAmpCarSet.this.findViewById(R.id.tv_text1)).setText("F" + (7 - value));
                            break;
                        } else if (value == 7) {
                            ((TextView) BNRToyotaAmpCarSet.this.findViewById(R.id.tv_text1)).setText("0");
                            break;
                        }
                    }
                    break;
                case 154:
                    if (((TextView) BNRToyotaAmpCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 7) {
                            ((TextView) BNRToyotaAmpCarSet.this.findViewById(R.id.tv_text2)).setText("R" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) BNRToyotaAmpCarSet.this.findViewById(R.id.tv_text2)).setText("L" + (7 - value));
                            break;
                        } else if (value == 7) {
                            ((TextView) BNRToyotaAmpCarSet.this.findViewById(R.id.tv_text2)).setText("0");
                            break;
                        }
                    }
                    break;
                case 155:
                    if (((TextView) BNRToyotaAmpCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 7) {
                            ((TextView) BNRToyotaAmpCarSet.this.findViewById(R.id.tv_text3)).setText("+" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) BNRToyotaAmpCarSet.this.findViewById(R.id.tv_text3)).setText("-" + (7 - value));
                            break;
                        } else if (value == 7) {
                            ((TextView) BNRToyotaAmpCarSet.this.findViewById(R.id.tv_text3)).setText("0");
                            break;
                        }
                    }
                    break;
                case 156:
                    if (((TextView) BNRToyotaAmpCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 7) {
                            ((TextView) BNRToyotaAmpCarSet.this.findViewById(R.id.tv_text5)).setText("+" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) BNRToyotaAmpCarSet.this.findViewById(R.id.tv_text5)).setText("-" + (7 - value));
                            break;
                        } else if (value == 7) {
                            ((TextView) BNRToyotaAmpCarSet.this.findViewById(R.id.tv_text5)).setText("0");
                            break;
                        }
                    }
                    break;
                case 157:
                    if (((TextView) BNRToyotaAmpCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 7) {
                            ((TextView) BNRToyotaAmpCarSet.this.findViewById(R.id.tv_text4)).setText("+" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) BNRToyotaAmpCarSet.this.findViewById(R.id.tv_text4)).setText("-" + (7 - value));
                            break;
                        } else if (value == 7) {
                            ((TextView) BNRToyotaAmpCarSet.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        }
                    }
                    break;
                case 158:
                    BNRToyotaAmpCarSet.this.setCheck((CheckedTextView) BNRToyotaAmpCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 159:
                    if (((TextView) BNRToyotaAmpCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) BNRToyotaAmpCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 160:
                    BNRToyotaAmpCarSet.this.setCheck((CheckedTextView) BNRToyotaAmpCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_bnr_toyota_amp_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[153];
                if (value > 0) {
                    value--;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[153];
                if (value2 < 12) {
                    value2++;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[154];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[154];
                if (value4 < 12) {
                    value4++;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[155];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(4, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[155];
                if (value6 < 12) {
                    value6++;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[157];
                if (value7 > 0) {
                    value7--;
                }
                setCarInfo(6, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[157];
                if (value8 < 12) {
                    value8++;
                }
                setCarInfo(6, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[156];
                if (value9 > 0) {
                    value9--;
                }
                setCarInfo(5, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[156];
                if (value10 < 12) {
                    value10++;
                }
                setCarInfo(5, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[159];
                if (value11 > 0) {
                    value11--;
                }
                setCarInfo(7, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[159];
                if (value12 < 63) {
                    value12++;
                }
                setCarInfo(7, value12);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value13 = DataCanbus.DATA[158];
                if (value13 == 1) {
                    value13 = 8;
                } else if (value13 == 8) {
                    value13 = 1;
                }
                setCarInfo(3, value13);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value14 = DataCanbus.DATA[160];
                if (value14 == 1) {
                    value14 = 0;
                } else if (value14 == 0) {
                    value14 = 1;
                }
                setCarInfo(9, value14);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{49}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
    }
}
