package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class WCOldJeepAmpSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 100:
                    if (((TextView) WCOldJeepAmpSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) WCOldJeepAmpSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 101:
                    if (((TextView) WCOldJeepAmpSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value > 10) {
                            ((TextView) WCOldJeepAmpSet.this.findViewById(R.id.tv_text1)).setText("R" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) WCOldJeepAmpSet.this.findViewById(R.id.tv_text1)).setText("L" + (10 - value));
                            break;
                        } else if (value == 10) {
                            ((TextView) WCOldJeepAmpSet.this.findViewById(R.id.tv_text1)).setText("0");
                            break;
                        }
                    }
                    break;
                case 102:
                    if (((TextView) WCOldJeepAmpSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 10) {
                            ((TextView) WCOldJeepAmpSet.this.findViewById(R.id.tv_text2)).setText("R" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) WCOldJeepAmpSet.this.findViewById(R.id.tv_text2)).setText("F" + (10 - value));
                            break;
                        } else if (value == 10) {
                            ((TextView) WCOldJeepAmpSet.this.findViewById(R.id.tv_text2)).setText("0");
                            break;
                        }
                    }
                    break;
                case 103:
                    if (((TextView) WCOldJeepAmpSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 10) {
                            ((TextView) WCOldJeepAmpSet.this.findViewById(R.id.tv_text3)).setText("+" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) WCOldJeepAmpSet.this.findViewById(R.id.tv_text3)).setText("-" + (10 - value));
                            break;
                        } else if (value == 10) {
                            ((TextView) WCOldJeepAmpSet.this.findViewById(R.id.tv_text3)).setText("0");
                            break;
                        }
                    }
                    break;
                case 104:
                    if (((TextView) WCOldJeepAmpSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 10) {
                            ((TextView) WCOldJeepAmpSet.this.findViewById(R.id.tv_text4)).setText("+" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) WCOldJeepAmpSet.this.findViewById(R.id.tv_text4)).setText("-" + (10 - value));
                            break;
                        } else if (value == 10) {
                            ((TextView) WCOldJeepAmpSet.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        }
                    }
                    break;
                case 105:
                    if (((TextView) WCOldJeepAmpSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 10) {
                            ((TextView) WCOldJeepAmpSet.this.findViewById(R.id.tv_text5)).setText("+" + (value - 10));
                            break;
                        } else if (value < 10) {
                            ((TextView) WCOldJeepAmpSet.this.findViewById(R.id.tv_text5)).setText("-" + (10 - value));
                            break;
                        } else if (value == 10) {
                            ((TextView) WCOldJeepAmpSet.this.findViewById(R.id.tv_text5)).setText("0");
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
        //setContentView(R.layout.layout_0145_wc_jeep_amp_settings);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[101];
                if (value > 1) {
                    value--;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[101];
                if (value2 < 19) {
                    value2++;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[102];
                if (value3 > 1) {
                    value3--;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[102];
                if (value4 < 19) {
                    value4++;
                }
                setCarInfo(3, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[103];
                if (value5 > 1) {
                    value5--;
                }
                setCarInfo(4, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[103];
                if (value6 < 19) {
                    value6++;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[104];
                if (value7 > 1) {
                    value7--;
                }
                setCarInfo(5, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[104];
                if (value8 < 19) {
                    value8++;
                }
                setCarInfo(5, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[105];
                if (value9 > 1) {
                    value9--;
                }
                setCarInfo(6, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[105];
                if (value10 < 19) {
                    value10++;
                }
                setCarInfo(6, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[100];
                if (value11 > 0) {
                    value11--;
                }
                setCarInfo(1, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[100];
                if (value12 < 38) {
                    value12++;
                }
                setCarInfo(1, value12);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
    }
}
