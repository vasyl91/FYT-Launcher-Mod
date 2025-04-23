package com.syu.carinfo.rzc.klc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RZCKlcCarAmpSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 314:
                    if (((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 315:
                    if (((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (val > 16) {
                            ((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text2)).setText("+" + (val - 16));
                            break;
                        } else if (val < 16) {
                            ((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text2)).setText("-" + (16 - val));
                            break;
                        } else {
                            ((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text2)).setText("0");
                            break;
                        }
                    }
                    break;
                case 316:
                    if (((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (val > 16) {
                            ((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text3)).setText("+" + (val - 16));
                            break;
                        } else if (val < 16) {
                            ((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text3)).setText("-" + (16 - val));
                            break;
                        } else {
                            ((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text3)).setText("0");
                            break;
                        }
                    }
                    break;
                case 317:
                    if (((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (val > 16) {
                            ((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text4)).setText("+" + (val - 16));
                            break;
                        } else if (val < 16) {
                            ((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text4)).setText("-" + (16 - val));
                            break;
                        } else {
                            ((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        }
                    }
                    break;
                case 318:
                    if (((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (val > 16) {
                            ((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text5)).setText("R" + (val - 16));
                            break;
                        } else if (val < 16) {
                            ((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text5)).setText("L" + (16 - val));
                            break;
                        } else {
                            ((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text5)).setText("0");
                            break;
                        }
                    }
                    break;
                case 319:
                    if (((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text6)) != null) {
                        if (val > 16) {
                            ((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text6)).setText("R" + (val - 16));
                            break;
                        } else if (val < 16) {
                            ((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text6)).setText("F" + (16 - val));
                            break;
                        } else {
                            ((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text6)).setText("0");
                            break;
                        }
                    }
                    break;
                case 320:
                    if (((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text7)).setText("--");
                                break;
                            case 1:
                                ((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text7)).setText("Normal");
                                break;
                            case 2:
                                ((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text7)).setText("Surround");
                                break;
                            case 3:
                                ((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text7)).setText("Rear");
                                break;
                            case 4:
                                ((TextView) RZCKlcCarAmpSet.this.findViewById(R.id.tv_text7)).setText("Driver");
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
        //setContentView(R.layout.layout_0061_rzc_gm_ampsettings);
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
                int value = DataCanbus.DATA[314];
                if (value > 0) {
                    value--;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[314];
                if (value2 < 48) {
                    value2++;
                }
                setCarInfo(84, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[315];
                if (value3 > 9) {
                    value3--;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[315];
                if (value4 < 23) {
                    value4++;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[316];
                if (value5 > 9) {
                    value5--;
                }
                setCarInfo(3, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[316];
                if (value6 < 23) {
                    value6++;
                }
                setCarInfo(3, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[317];
                if (value7 > 9) {
                    value7--;
                }
                setCarInfo(4, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[317];
                if (value8 < 23) {
                    value8++;
                }
                setCarInfo(4, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[318];
                if (value9 > 9) {
                    value9--;
                }
                setCarInfo(5, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[318];
                if (value10 < 23) {
                    value10++;
                }
                setCarInfo(5, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[319];
                if (value11 > 9) {
                    value11--;
                }
                setCarInfo(6, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[319];
                if (value12 < 23) {
                    value12++;
                }
                setCarInfo(6, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[320] - 1;
                if (value13 < 1) {
                    value13 = 4;
                }
                setCarInfo(10, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[320] + 1;
                if (value14 > 4) {
                    value14 = 1;
                }
                setCarInfo(10, value14);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(13, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(8, new int[]{40}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[314].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[315].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[316].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[317].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[318].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[319].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[320].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[314].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[315].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[316].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[317].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[318].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[319].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[320].removeNotify(this.mNotifyCanbus);
    }
}
