package com.syu.carinfo.xp.suburu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RZCSuburuCarEQInfo extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 107:
                    RZCSuburuCarEQInfo.this.updateText1();
                    RZCSuburuCarEQInfo.this.updateText2();
                    RZCSuburuCarEQInfo.this.updateText3();
                    RZCSuburuCarEQInfo.this.updateText4();
                    RZCSuburuCarEQInfo.this.updateText5();
                    RZCSuburuCarEQInfo.this.updateText6();
                    break;
                case 108:
                    if (((CheckedTextView) RZCSuburuCarEQInfo.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) RZCSuburuCarEQInfo.this.findViewById(R.id.ctv_checkedtext1)).setChecked(val == 1);
                        break;
                    }
                case 109:
                    RZCSuburuCarEQInfo.this.updateText1();
                    break;
                case 110:
                    RZCSuburuCarEQInfo.this.updateText2();
                    break;
                case 111:
                    RZCSuburuCarEQInfo.this.updateText3();
                    break;
                case 112:
                    RZCSuburuCarEQInfo.this.updateText4();
                    break;
                case 113:
                    RZCSuburuCarEQInfo.this.updateText5();
                    break;
                case 114:
                    RZCSuburuCarEQInfo.this.updateText6();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0454_rzc_suburu_eq_settings);
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
                if (DataCanbus.DATA[107] != 0) {
                    int value2 = DataCanbus.DATA[109];
                    if (value2 > 0) {
                        value2--;
                    }
                    setCarInfo(2, value2);
                    break;
                }
            case R.id.btn_plus1 /* 2131427457 */:
                if (DataCanbus.DATA[107] != 0) {
                    int value3 = DataCanbus.DATA[109];
                    if (value3 < 63) {
                        value3++;
                    }
                    setCarInfo(2, value3);
                    break;
                }
            case R.id.btn_minus2 /* 2131427458 */:
                if (DataCanbus.DATA[107] != 0) {
                    int value4 = DataCanbus.DATA[110];
                    if (value4 > 1) {
                        value4--;
                    }
                    setCarInfo(3, value4);
                    break;
                }
            case R.id.btn_plus2 /* 2131427460 */:
                if (DataCanbus.DATA[107] != 0) {
                    int value5 = DataCanbus.DATA[110];
                    if (value5 < 19) {
                        value5++;
                    }
                    setCarInfo(3, value5);
                    break;
                }
            case R.id.btn_minus3 /* 2131427461 */:
                if (DataCanbus.DATA[107] != 0) {
                    int value6 = DataCanbus.DATA[111];
                    if (value6 > 1) {
                        value6--;
                    }
                    setCarInfo(4, value6);
                    break;
                }
            case R.id.btn_plus3 /* 2131427463 */:
                if (DataCanbus.DATA[107] != 0) {
                    int value7 = DataCanbus.DATA[111];
                    if (value7 < 19) {
                        value7++;
                    }
                    setCarInfo(4, value7);
                    break;
                }
            case R.id.btn_minus4 /* 2131427464 */:
                if (DataCanbus.DATA[107] != 0) {
                    int value8 = DataCanbus.DATA[112];
                    if (value8 > 1) {
                        value8--;
                    }
                    setCarInfo(5, value8);
                    break;
                }
            case R.id.btn_plus4 /* 2131427466 */:
                if (DataCanbus.DATA[107] != 0) {
                    int value9 = DataCanbus.DATA[112];
                    if (value9 < 19) {
                        value9++;
                    }
                    setCarInfo(5, value9);
                    break;
                }
            case R.id.btn_minus5 /* 2131427467 */:
                if (DataCanbus.DATA[107] != 0) {
                    int value10 = DataCanbus.DATA[113];
                    if (value10 > 1) {
                        value10--;
                    }
                    setCarInfo(7, value10);
                    break;
                }
            case R.id.btn_plus5 /* 2131427469 */:
                if (DataCanbus.DATA[107] != 0) {
                    int value11 = DataCanbus.DATA[113];
                    if (value11 < 19) {
                        value11++;
                    }
                    setCarInfo(7, value11);
                    break;
                }
            case R.id.btn_minus6 /* 2131427470 */:
                if (DataCanbus.DATA[107] != 0) {
                    int value12 = DataCanbus.DATA[114];
                    if (value12 > 1) {
                        value12--;
                    }
                    setCarInfo(6, value12);
                    break;
                }
            case R.id.btn_plus6 /* 2131427472 */:
                if (DataCanbus.DATA[107] != 0) {
                    int value13 = DataCanbus.DATA[114];
                    if (value13 < 19) {
                        value13++;
                    }
                    setCarInfo(6, value13);
                    break;
                }
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (DataCanbus.DATA[108] == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                setCarInfo(1, value);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateText6() {
        int value = DataCanbus.DATA[114];
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            if (DataCanbus.DATA[107] == 1) {
                if (value > 10) {
                    ((TextView) findViewById(R.id.tv_text6)).setText("+" + (value - 10));
                    return;
                } else {
                    if (value < 10) {
                        ((TextView) findViewById(R.id.tv_text6)).setText("-" + (10 - value));
                        return;
                    }
                    ((TextView) findViewById(R.id.tv_text6)).setText("0");
                    return;
                }
            }
            ((TextView) findViewById(R.id.tv_text6)).setText("----");
        }
    }

    
    public void updateText5() {
        int value = DataCanbus.DATA[113];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if (DataCanbus.DATA[107] == 1) {
                if (value > 10) {
                    ((TextView) findViewById(R.id.tv_text5)).setText("+" + (value - 10));
                    return;
                } else {
                    if (value < 10) {
                        ((TextView) findViewById(R.id.tv_text5)).setText("-" + (10 - value));
                        return;
                    }
                    ((TextView) findViewById(R.id.tv_text5)).setText("0");
                    return;
                }
            }
            ((TextView) findViewById(R.id.tv_text5)).setText("----");
        }
    }

    
    public void updateText4() {
        int value = DataCanbus.DATA[112];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (DataCanbus.DATA[107] == 1) {
                if (value > 10) {
                    ((TextView) findViewById(R.id.tv_text4)).setText("+" + (value - 10));
                    return;
                } else {
                    if (value < 10) {
                        ((TextView) findViewById(R.id.tv_text4)).setText("-" + (10 - value));
                        return;
                    }
                    ((TextView) findViewById(R.id.tv_text4)).setText("0");
                    return;
                }
            }
            ((TextView) findViewById(R.id.tv_text4)).setText("----");
        }
    }

    
    public void updateText3() {
        int value = DataCanbus.DATA[111];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (DataCanbus.DATA[107] == 1) {
                if (value > 10) {
                    ((TextView) findViewById(R.id.tv_text3)).setText("R" + (value - 10));
                    return;
                } else {
                    if (value < 10) {
                        ((TextView) findViewById(R.id.tv_text3)).setText("L" + (10 - value));
                        return;
                    }
                    ((TextView) findViewById(R.id.tv_text3)).setText("0");
                    return;
                }
            }
            ((TextView) findViewById(R.id.tv_text3)).setText("----");
        }
    }

    
    public void updateText2() {
        int value = DataCanbus.DATA[110];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (DataCanbus.DATA[107] == 1) {
                if (value > 10) {
                    ((TextView) findViewById(R.id.tv_text2)).setText("R" + (value - 10));
                    return;
                } else {
                    if (value < 10) {
                        ((TextView) findViewById(R.id.tv_text2)).setText("F" + (10 - value));
                        return;
                    }
                    ((TextView) findViewById(R.id.tv_text2)).setText("0");
                    return;
                }
            }
            ((TextView) findViewById(R.id.tv_text2)).setText("----");
        }
    }

    
    public void updateText1() {
        int value = DataCanbus.DATA[109];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (DataCanbus.DATA[107] == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText("----");
            }
        }
    }
}
