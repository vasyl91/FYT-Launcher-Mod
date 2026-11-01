package com.syu.carinfo.xp.psa_all;

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
public class XpPsaAllCarEQSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 207:
                    if (((TextView) XpPsaAllCarEQSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 10) {
                            ((TextView) XpPsaAllCarEQSet.this.findViewById(R.id.tv_text2)).setText("+" + (value - 10));
                            break;
                        } else if (value == 10) {
                            ((TextView) XpPsaAllCarEQSet.this.findViewById(R.id.tv_text2)).setText("0");
                            break;
                        } else {
                            ((TextView) XpPsaAllCarEQSet.this.findViewById(R.id.tv_text2)).setText("-" + (10 - value));
                            break;
                        }
                    }
                    break;
                case 208:
                    if (((TextView) XpPsaAllCarEQSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value > 10) {
                            ((TextView) XpPsaAllCarEQSet.this.findViewById(R.id.tv_text1)).setText("+" + (value - 10));
                            break;
                        } else if (value == 10) {
                            ((TextView) XpPsaAllCarEQSet.this.findViewById(R.id.tv_text1)).setText("0");
                            break;
                        } else {
                            ((TextView) XpPsaAllCarEQSet.this.findViewById(R.id.tv_text1)).setText("-" + (10 - value));
                            break;
                        }
                    }
                    break;
                case 209:
                    if (((TextView) XpPsaAllCarEQSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 10) {
                            ((TextView) XpPsaAllCarEQSet.this.findViewById(R.id.tv_text4)).setText("+" + (value - 10));
                            break;
                        } else if (value == 10) {
                            ((TextView) XpPsaAllCarEQSet.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        } else {
                            ((TextView) XpPsaAllCarEQSet.this.findViewById(R.id.tv_text4)).setText("-" + (10 - value));
                            break;
                        }
                    }
                    break;
                case 210:
                    if (((TextView) XpPsaAllCarEQSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 10) {
                            ((TextView) XpPsaAllCarEQSet.this.findViewById(R.id.tv_text3)).setText("+" + (value - 10));
                            break;
                        } else if (value == 10) {
                            ((TextView) XpPsaAllCarEQSet.this.findViewById(R.id.tv_text3)).setText("0");
                            break;
                        } else {
                            ((TextView) XpPsaAllCarEQSet.this.findViewById(R.id.tv_text3)).setText("-" + (10 - value));
                            break;
                        }
                    }
                    break;
                case 211:
                    if (((TextView) XpPsaAllCarEQSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) XpPsaAllCarEQSet.this.findViewById(R.id.tv_text5)).setText("User");
                                break;
                            case 1:
                                ((TextView) XpPsaAllCarEQSet.this.findViewById(R.id.tv_text5)).setText("Rock");
                                break;
                            case 2:
                                ((TextView) XpPsaAllCarEQSet.this.findViewById(R.id.tv_text5)).setText("Classic");
                                break;
                            case 3:
                                ((TextView) XpPsaAllCarEQSet.this.findViewById(R.id.tv_text5)).setText("Electronic");
                                break;
                            case 4:
                                ((TextView) XpPsaAllCarEQSet.this.findViewById(R.id.tv_text5)).setText("Jazz");
                                break;
                            case 5:
                                ((TextView) XpPsaAllCarEQSet.this.findViewById(R.id.tv_text5)).setText("Vocal");
                                break;
                        }
                    }
                    break;
                case 212:
                    XpPsaAllCarEQSet.this.setCheck((CheckedTextView) XpPsaAllCarEQSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 213:
                    if (((TextView) XpPsaAllCarEQSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) XpPsaAllCarEQSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_252_sound_distribution1);
                                break;
                            case 1:
                                ((TextView) XpPsaAllCarEQSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_252_sound_distribution0);
                                break;
                        }
                    }
                    break;
                case 214:
                    XpPsaAllCarEQSet.this.setCheck((CheckedTextView) XpPsaAllCarEQSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0281_xp_psa_eqsettings);
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
        int value;
        int value2;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value3 = DataCanbus.DATA[208];
                if (value3 > 3) {
                    value3--;
                }
                setCarInfo(6, value3);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value4 = DataCanbus.DATA[208];
                if (value4 < 17) {
                    value4++;
                }
                setCarInfo(6, value4);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value5 = DataCanbus.DATA[207];
                if (value5 > 3) {
                    value5--;
                }
                setCarInfo(5, value5);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value6 = DataCanbus.DATA[207];
                if (value6 < 17) {
                    value6++;
                }
                setCarInfo(5, value6);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value7 = DataCanbus.DATA[210];
                if (value7 > 3) {
                    value7--;
                }
                setCarInfo(3, value7);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value8 = DataCanbus.DATA[210];
                if (value8 < 17) {
                    value8++;
                }
                setCarInfo(3, value8);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value9 = DataCanbus.DATA[209];
                if (value9 > 3) {
                    value9--;
                }
                setCarInfo(4, value9);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value10 = DataCanbus.DATA[209];
                if (value10 < 17) {
                    value10++;
                }
                setCarInfo(4, value10);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value11 = DataCanbus.DATA[211];
                if (value11 > 0) {
                    value11--;
                }
                setCarInfo(9, value11);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value12 = DataCanbus.DATA[211];
                if (value12 < 5) {
                    value12++;
                }
                setCarInfo(9, value12);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value13 = DataCanbus.DATA[213];
                if (value13 > 0) {
                    value13--;
                }
                setCarInfo(2, value13);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value14 = DataCanbus.DATA[213];
                if (value14 < 1) {
                    value14++;
                }
                setCarInfo(2, value14);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (DataCanbus.DATA[212] == 1) {
                    value2 = 0;
                } else {
                    value2 = 1;
                }
                setCarInfo(10, value2);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                if (DataCanbus.DATA[214] == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                setCarInfo(1, value);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(64, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(53, new int[]{23}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[208].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[207].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[210].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[209].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[211].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[213].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[212].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[214].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[208].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[207].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[210].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[209].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[211].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[213].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[212].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[214].removeNotify(this.mNotifyCanbus);
    }
}
