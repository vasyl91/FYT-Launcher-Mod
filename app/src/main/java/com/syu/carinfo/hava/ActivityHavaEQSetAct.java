package com.syu.carinfo.hava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ActivityHavaEQSetAct extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { 
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427455 */:
                    int value = DataCanbus.DATA[137];
                    if (value > 0) {
                        value--;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(2, value);
                    break;
                case R.id.btn_plus1 /* 2131427457 */:
                    int value2 = DataCanbus.DATA[137];
                    if (value2 < 20) {
                        value2++;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(2, value2);
                    break;
                case R.id.btn_minus2 /* 2131427458 */:
                    int value3 = DataCanbus.DATA[138];
                    if (value3 > 0) {
                        value3--;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(3, value3);
                    break;
                case R.id.btn_plus2 /* 2131427460 */:
                    int value4 = DataCanbus.DATA[138];
                    if (value4 < 20) {
                        value4++;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(3, value4);
                    break;
                case R.id.btn_minus3 /* 2131427461 */:
                    int value5 = DataCanbus.DATA[139];
                    if (value5 > 0) {
                        value5--;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(4, value5);
                    break;
                case R.id.btn_plus3 /* 2131427463 */:
                    int value6 = DataCanbus.DATA[139];
                    if (value6 < 20) {
                        value6++;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(4, value6);
                    break;
                case R.id.btn_minus4 /* 2131427464 */:
                    int value7 = DataCanbus.DATA[140];
                    if (value7 > 0) {
                        value7--;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(5, value7);
                    break;
                case R.id.btn_plus4 /* 2131427466 */:
                    int value8 = DataCanbus.DATA[140];
                    if (value8 < 20) {
                        value8++;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(5, value8);
                    break;
                case R.id.btn_minus5 /* 2131427467 */:
                    int value9 = DataCanbus.DATA[141];
                    if (value9 > 0) {
                        value9--;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(6, value9);
                    break;
                case R.id.btn_plus5 /* 2131427469 */:
                    int value10 = DataCanbus.DATA[141];
                    if (value10 < 20) {
                        value10++;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(6, value10);
                    break;
                case R.id.btn_minus6 /* 2131427470 */:
                    int value11 = DataCanbus.DATA[143];
                    if (value11 > 0) {
                        value11--;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(8, value11);
                    break;
                case R.id.btn_plus6 /* 2131427472 */:
                    int value12 = DataCanbus.DATA[143];
                    if (value12 < 4) {
                        value12++;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(8, value12);
                    break;
                case R.id.btn_minus7 /* 2131427473 */:
                    int value13 = DataCanbus.DATA[136];
                    if (value13 > 0) {
                        value13--;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(1, value13);
                    break;
                case R.id.btn_plus7 /* 2131427475 */:
                    int value14 = DataCanbus.DATA[136];
                    if (value14 < 40) {
                        value14++;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(1, value14);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 136:
                    ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    break;
                case 137:
                    if (value > 10) {
                        ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text1)).setText("+" + (value - 10));
                        break;
                    } else if (value == 10) {
                        ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text1)).setText("0");
                        break;
                    } else if (value < 10) {
                        ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text1)).setText("-" + (10 - value));
                        break;
                    }
                case 138:
                    if (value > 10) {
                        ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text2)).setText("+" + (value - 10));
                        break;
                    } else if (value == 10) {
                        ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text2)).setText("0");
                        break;
                    } else if (value < 10) {
                        ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text2)).setText("-" + (10 - value));
                        break;
                    }
                case 139:
                    if (value > 10) {
                        ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text3)).setText("+" + (value - 10));
                        break;
                    } else if (value == 10) {
                        ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text3)).setText("0");
                        break;
                    } else if (value < 10) {
                        ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text3)).setText("-" + (10 - value));
                        break;
                    }
                case 140:
                    if (value > 10) {
                        ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text4)).setText("R" + (value - 10));
                        break;
                    } else if (value == 10) {
                        ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text4)).setText("0");
                        break;
                    } else if (value < 10) {
                        ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text4)).setText("L" + (10 - value));
                        break;
                    }
                case 141:
                    if (value > 10) {
                        ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text5)).setText("R" + (value - 10));
                        break;
                    } else if (value == 10) {
                        ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text5)).setText("0");
                        break;
                    } else if (value < 10) {
                        ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text5)).setText("F" + (10 - value));
                        break;
                    }
                case 142:
                    if (((CheckedTextView) ActivityHavaEQSetAct.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) ActivityHavaEQSetAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 2);
                    }
                    if (value == 2) {
                        ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text10)).setText(R.string.jeep_surroundsound);
                        break;
                    } else {
                        ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text10)).setText(R.string.haval_volspeed1);
                        break;
                    }
                case 143:
                    switch (value) {
                        case 0:
                            ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.klc_Parking_with_trailer_ON);
                            break;
                        case 2:
                            ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_low);
                            break;
                        case 3:
                            ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_middle);
                            break;
                        case 4:
                            ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_high);
                            break;
                    }
                case 144:
                    if (value == 255) {
                        ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text8)).setText("----");
                        break;
                    } else {
                        int value2 = (value * 10) / 4;
                        ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + " V");
                        break;
                    }
                case 145:
                    if (value == 255) {
                        ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text9)).setText("----");
                        break;
                    } else if (value >= 40) {
                        ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value - 40) + " ℃");
                        break;
                    } else if (value < 40) {
                        ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text9)).setText("-" + (40 - value) + " ℃");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0244_rzc_havalh_eq_set);
        init();
    }

    @Override
    public void init() {
        setonClick((Button) findViewById(R.id.btn_plus1));
        setonClick((Button) findViewById(R.id.btn_minus1));
        setonClick((Button) findViewById(R.id.btn_plus2));
        setonClick((Button) findViewById(R.id.btn_minus2));
        setonClick((Button) findViewById(R.id.btn_plus3));
        setonClick((Button) findViewById(R.id.btn_minus3));
        setonClick((Button) findViewById(R.id.btn_plus4));
        setonClick((Button) findViewById(R.id.btn_minus4));
        setonClick((Button) findViewById(R.id.btn_plus5));
        setonClick((Button) findViewById(R.id.btn_minus5));
        setonClick((Button) findViewById(R.id.btn_plus6));
        setonClick((Button) findViewById(R.id.btn_minus6));
        setonClick((Button) findViewById(R.id.btn_plus7));
        setonClick((Button) findViewById(R.id.btn_minus7));
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[142] & 255;
                    if (value == 2) {
                        DataCanbus.PROXY.cmd(8, new int[]{7, 1}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(8, new int[]{7, 2}, null, null);
                    }
                }
            });
        }
    }

    
    public void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(8, new int[]{cmd, val}, null, null);
    }

    private void setonClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
        }
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
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
    }
}
