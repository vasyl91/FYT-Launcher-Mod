package com.syu.carinfo.toyota.tangdu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ToyotaTangduEQActi extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 139:
                    if (((TextView) ToyotaTangduEQActi.this.findViewById(R.id.tv_text1)) != null) {
                        if (value > 7) {
                            ((TextView) ToyotaTangduEQActi.this.findViewById(R.id.tv_text1)).setText("R" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) ToyotaTangduEQActi.this.findViewById(R.id.tv_text1)).setText("F" + (7 - value));
                            break;
                        } else {
                            ((TextView) ToyotaTangduEQActi.this.findViewById(R.id.tv_text1)).setText("0");
                            break;
                        }
                    }
                    break;
                case 140:
                    if (((TextView) ToyotaTangduEQActi.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 7) {
                            ((TextView) ToyotaTangduEQActi.this.findViewById(R.id.tv_text2)).setText("R" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) ToyotaTangduEQActi.this.findViewById(R.id.tv_text2)).setText("L" + (7 - value));
                            break;
                        } else {
                            ((TextView) ToyotaTangduEQActi.this.findViewById(R.id.tv_text2)).setText("0");
                            break;
                        }
                    }
                    break;
                case 141:
                    if (((TextView) ToyotaTangduEQActi.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 7) {
                            ((TextView) ToyotaTangduEQActi.this.findViewById(R.id.tv_text3)).setText("+" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) ToyotaTangduEQActi.this.findViewById(R.id.tv_text3)).setText("-" + (7 - value));
                            break;
                        } else {
                            ((TextView) ToyotaTangduEQActi.this.findViewById(R.id.tv_text3)).setText("0");
                            break;
                        }
                    }
                    break;
                case 142:
                    if (((TextView) ToyotaTangduEQActi.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 7) {
                            ((TextView) ToyotaTangduEQActi.this.findViewById(R.id.tv_text5)).setText("+" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) ToyotaTangduEQActi.this.findViewById(R.id.tv_text5)).setText("-" + (7 - value));
                            break;
                        } else {
                            ((TextView) ToyotaTangduEQActi.this.findViewById(R.id.tv_text5)).setText("0");
                            break;
                        }
                    }
                    break;
                case 143:
                    if (((TextView) ToyotaTangduEQActi.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 7) {
                            ((TextView) ToyotaTangduEQActi.this.findViewById(R.id.tv_text4)).setText("+" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) ToyotaTangduEQActi.this.findViewById(R.id.tv_text4)).setText("-" + (7 - value));
                            break;
                        } else {
                            ((TextView) ToyotaTangduEQActi.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        }
                    }
                    break;
                case 144:
                    ToyotaTangduEQActi.this.setCheck((CheckedTextView) ToyotaTangduEQActi.this.findViewById(R.id.ctv_checkedtext1), value == 8);
                    break;
                case 145:
                    if (((TextView) ToyotaTangduEQActi.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) ToyotaTangduEQActi.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_tangdu_toyota_eq_settings);
        init();
    }

    @Override
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
    }

    @Override
    public void onClick(View v) {
        int value;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value2 = DataCanbus.DATA[139];
                if (value2 > 0) {
                    value2--;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value3 = DataCanbus.DATA[139];
                if (value3 < 14) {
                    value3++;
                }
                setCarInfo(1, value3);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value4 = DataCanbus.DATA[140];
                if (value4 > 0) {
                    value4--;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value5 = DataCanbus.DATA[140];
                if (value5 < 14) {
                    value5++;
                }
                setCarInfo(2, value5);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value6 = DataCanbus.DATA[141];
                if (value6 > 2) {
                    value6--;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value7 = DataCanbus.DATA[141];
                if (value7 < 12) {
                    value7++;
                }
                setCarInfo(4, value7);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value8 = DataCanbus.DATA[143];
                if (value8 > 2) {
                    value8--;
                }
                setCarInfo(6, value8);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value9 = DataCanbus.DATA[143];
                if (value9 < 12) {
                    value9++;
                }
                setCarInfo(6, value9);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value10 = DataCanbus.DATA[142];
                if (value10 > 2) {
                    value10--;
                }
                setCarInfo(5, value10);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value11 = DataCanbus.DATA[142];
                if (value11 < 12) {
                    value11++;
                }
                setCarInfo(5, value11);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value12 = DataCanbus.DATA[145];
                if (value12 > 0) {
                    value12--;
                }
                setCarInfo(7, value12);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value13 = DataCanbus.DATA[145];
                if (value13 < 63) {
                    value13++;
                }
                setCarInfo(7, value13);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (DataCanbus.DATA[144] == 8) {
                    value = 1;
                } else {
                    value = 8;
                }
                setCarInfo(3, value);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
    }
}
