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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityHavaEQSetAct extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { // from class: com.syu.carinfo.hava.ActivityHavaEQSetAct.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427480 */:
                    int value = DataCanbus.DATA[125];
                    if (value > 0) {
                        value--;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(2, value);
                    break;
                case R.id.btn_plus1 /* 2131427482 */:
                    int value2 = DataCanbus.DATA[125];
                    if (value2 < 20) {
                        value2++;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(2, value2);
                    break;
                case R.id.btn_minus2 /* 2131427484 */:
                    int value3 = DataCanbus.DATA[126];
                    if (value3 > 0) {
                        value3--;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(3, value3);
                    break;
                case R.id.btn_plus2 /* 2131427486 */:
                    int value4 = DataCanbus.DATA[126];
                    if (value4 < 20) {
                        value4++;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(3, value4);
                    break;
                case R.id.btn_minus3 /* 2131427488 */:
                    int value5 = DataCanbus.DATA[127];
                    if (value5 > 0) {
                        value5--;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(4, value5);
                    break;
                case R.id.btn_plus3 /* 2131427490 */:
                    int value6 = DataCanbus.DATA[127];
                    if (value6 < 20) {
                        value6++;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(4, value6);
                    break;
                case R.id.btn_minus4 /* 2131427492 */:
                    int value7 = DataCanbus.DATA[128];
                    if (value7 > 0) {
                        value7--;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(5, value7);
                    break;
                case R.id.btn_plus4 /* 2131427494 */:
                    int value8 = DataCanbus.DATA[128];
                    if (value8 < 20) {
                        value8++;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(5, value8);
                    break;
                case R.id.btn_minus5 /* 2131427496 */:
                    int value9 = DataCanbus.DATA[129];
                    if (value9 > 0) {
                        value9--;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(6, value9);
                    break;
                case R.id.btn_plus5 /* 2131427498 */:
                    int value10 = DataCanbus.DATA[129];
                    if (value10 < 20) {
                        value10++;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(6, value10);
                    break;
                case R.id.btn_minus6 /* 2131427501 */:
                    int value11 = DataCanbus.DATA[131];
                    if (value11 > 0) {
                        value11--;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(8, value11);
                    break;
                case R.id.btn_plus6 /* 2131427503 */:
                    int value12 = DataCanbus.DATA[131];
                    if (value12 < 4) {
                        value12++;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(8, value12);
                    break;
                case R.id.btn_minus7 /* 2131427505 */:
                    int value13 = DataCanbus.DATA[124];
                    if (value13 > 0) {
                        value13--;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(1, value13);
                    break;
                case R.id.btn_plus7 /* 2131427507 */:
                    int value14 = DataCanbus.DATA[124];
                    if (value14 < 40) {
                        value14++;
                    }
                    ActivityHavaEQSetAct.this.sendCMD(1, value14);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.hava.ActivityHavaEQSetAct.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 124:
                    ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    break;
                case 125:
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
                case 126:
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
                case 127:
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
                case 128:
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
                case 129:
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
                case 130:
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
                case 131:
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
                case 132:
                    if (value == 255) {
                        ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text8)).setText("----");
                        break;
                    } else {
                        int value2 = (value * 10) / 4;
                        ((TextView) ActivityHavaEQSetAct.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + " V");
                        break;
                    }
                case 133:
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0244_rzc_havalh_eq_set);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
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
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hava.ActivityHavaEQSetAct.3
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[130] & 255;
                    if (value == 2) {
                        DataCanbus.PROXY.cmd(8, new int[]{7, 1}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(8, new int[]{7, 2}, null, null);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(8, new int[]{cmd, val}, null, null);
    }

    private void setonClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
    }
}
