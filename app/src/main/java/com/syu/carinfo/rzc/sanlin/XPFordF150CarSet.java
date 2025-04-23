package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class XPFordF150CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    if (((TextView) XPFordF150CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) XPFordF150CarSet.this.findViewById(R.id.tv_text6)).setText("Metrice");
                                break;
                            case 1:
                                ((TextView) XPFordF150CarSet.this.findViewById(R.id.tv_text6)).setText("English");
                                break;
                        }
                    }
                    break;
                case 101:
                    if (((TextView) XPFordF150CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) XPFordF150CarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 102:
                    if (((TextView) XPFordF150CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value > 9) {
                            ((TextView) XPFordF150CarSet.this.findViewById(R.id.tv_text1)).setText("R" + (value - 9));
                            break;
                        } else if (value < 9) {
                            ((TextView) XPFordF150CarSet.this.findViewById(R.id.tv_text1)).setText("F" + (9 - value));
                            break;
                        } else if (value == 9) {
                            ((TextView) XPFordF150CarSet.this.findViewById(R.id.tv_text1)).setText("0");
                            break;
                        }
                    }
                    break;
                case 103:
                    if (((TextView) XPFordF150CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 9) {
                            ((TextView) XPFordF150CarSet.this.findViewById(R.id.tv_text2)).setText("R" + (value - 9));
                            break;
                        } else if (value < 9) {
                            ((TextView) XPFordF150CarSet.this.findViewById(R.id.tv_text2)).setText("L" + (9 - value));
                            break;
                        } else if (value == 9) {
                            ((TextView) XPFordF150CarSet.this.findViewById(R.id.tv_text2)).setText("0");
                            break;
                        }
                    }
                    break;
                case 104:
                    if (((TextView) XPFordF150CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 9) {
                            ((TextView) XPFordF150CarSet.this.findViewById(R.id.tv_text3)).setText("+" + (value - 9));
                            break;
                        } else if (value < 9) {
                            ((TextView) XPFordF150CarSet.this.findViewById(R.id.tv_text3)).setText("-" + (9 - value));
                            break;
                        } else if (value == 9) {
                            ((TextView) XPFordF150CarSet.this.findViewById(R.id.tv_text3)).setText("0");
                            break;
                        }
                    }
                    break;
                case 105:
                    if (((TextView) XPFordF150CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 9) {
                            ((TextView) XPFordF150CarSet.this.findViewById(R.id.tv_text4)).setText("+" + (value - 9));
                            break;
                        } else if (value < 9) {
                            ((TextView) XPFordF150CarSet.this.findViewById(R.id.tv_text4)).setText("-" + (9 - value));
                            break;
                        } else if (value == 9) {
                            ((TextView) XPFordF150CarSet.this.findViewById(R.id.tv_text4)).setText("0");
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
        //setContentView(R.layout.layout_0455_xp_ford_f150_settings);
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
                int value = DataCanbus.DATA[102];
                if (value > 0) {
                    value--;
                }
                setCarInfo(181, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[102];
                if (value2 < 19) {
                    value2++;
                }
                setCarInfo(181, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[103];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(180, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[103];
                if (value4 < 19) {
                    value4++;
                }
                setCarInfo(180, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[104];
                if (value5 > 3) {
                    value5--;
                }
                setCarInfo(179, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[104];
                if (value6 < 17) {
                    value6++;
                }
                setCarInfo(179, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[105];
                if (value7 > 3) {
                    value7--;
                }
                setCarInfo(177, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[105];
                if (value8 < 17) {
                    value8++;
                }
                setCarInfo(177, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[101];
                if (value9 > 0) {
                    value9--;
                }
                setCarInfo(182, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[101];
                if (value10 < 7) {
                    value10++;
                }
                setCarInfo(182, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
            case R.id.btn_plus6 /* 2131427472 */:
                setCarInfo(160, DataCanbus.DATA[99] == 0 ? 1 : 0);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{23}, null, null);
        DataCanbus.PROXY.cmd(1, new int[]{37}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
    }
}
