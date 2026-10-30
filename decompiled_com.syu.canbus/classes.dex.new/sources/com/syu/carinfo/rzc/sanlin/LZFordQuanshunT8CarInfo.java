package com.syu.carinfo.rzc.sanlin;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LZFordQuanshunT8CarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.LZFordQuanshunT8CarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    LZFordQuanshunT8CarInfo.this.updateCarinfo1();
                    LZFordQuanshunT8CarInfo.this.updateCarinfo2();
                    break;
                case 99:
                    LZFordQuanshunT8CarInfo.this.updateCarinfo3();
                    break;
                case 100:
                    LZFordQuanshunT8CarInfo.this.updateCarinfo2();
                    break;
                case 101:
                    LZFordQuanshunT8CarInfo.this.updateCarinfo1();
                    break;
                case 107:
                    ((TextView) LZFordQuanshunT8CarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value - 40) + " ℃");
                    break;
                case 108:
                    ((TextView) LZFordQuanshunT8CarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "%");
                    break;
                case 109:
                    ((TextView) LZFordQuanshunT8CarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + " L");
                    break;
                case 110:
                    ((TextView) LZFordQuanshunT8CarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + " V");
                    break;
                case 111:
                    LZFordQuanshunT8CarInfo.this.updateCarinfo3();
                    break;
                case 112:
                    ((TextView) LZFordQuanshunT8CarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + "%");
                    break;
                case 113:
                    ((TextView) LZFordQuanshunT8CarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                    break;
                case 114:
                    switch (value) {
                        case 1:
                            ((TextView) LZFordQuanshunT8CarInfo.this.findViewById(R.id.tv_text10)).setText("0s");
                            break;
                        case 2:
                            ((TextView) LZFordQuanshunT8CarInfo.this.findViewById(R.id.tv_text10)).setText("30s");
                            break;
                        case 3:
                            ((TextView) LZFordQuanshunT8CarInfo.this.findViewById(R.id.tv_text10)).setText("1min");
                            break;
                        case 4:
                            ((TextView) LZFordQuanshunT8CarInfo.this.findViewById(R.id.tv_text10)).setText("2min");
                            break;
                    }
                    break;
                case 115:
                    switch (value) {
                        case 1:
                            ((TextView) LZFordQuanshunT8CarInfo.this.findViewById(R.id.tv_text11)).setText("5min");
                            break;
                        case 2:
                            ((TextView) LZFordQuanshunT8CarInfo.this.findViewById(R.id.tv_text11)).setText("10min");
                            break;
                        case 3:
                            ((TextView) LZFordQuanshunT8CarInfo.this.findViewById(R.id.tv_text11)).setText("15min");
                            break;
                    }
                    break;
                case 116:
                    LZFordQuanshunT8CarInfo.this.setCheck((CheckedTextView) LZFordQuanshunT8CarInfo.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 117:
                    LZFordQuanshunT8CarInfo.this.setCheck((CheckedTextView) LZFordQuanshunT8CarInfo.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 118:
                    LZFordQuanshunT8CarInfo.this.setCheck((CheckedTextView) LZFordQuanshunT8CarInfo.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 119:
                    LZFordQuanshunT8CarInfo.this.setCheck((CheckedTextView) LZFordQuanshunT8CarInfo.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 120:
                    LZFordQuanshunT8CarInfo.this.setCheck((CheckedTextView) LZFordQuanshunT8CarInfo.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 121:
                    LZFordQuanshunT8CarInfo.this.setCheck((CheckedTextView) LZFordQuanshunT8CarInfo.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 122:
                    LZFordQuanshunT8CarInfo.this.setCheck((CheckedTextView) LZFordQuanshunT8CarInfo.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 123:
                    LZFordQuanshunT8CarInfo.this.setCheck((CheckedTextView) LZFordQuanshunT8CarInfo.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 124:
                    LZFordQuanshunT8CarInfo.this.setCheck((CheckedTextView) LZFordQuanshunT8CarInfo.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 125:
                    LZFordQuanshunT8CarInfo.this.setCheck((CheckedTextView) LZFordQuanshunT8CarInfo.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 126:
                    switch (value) {
                        case 1:
                            ((TextView) LZFordQuanshunT8CarInfo.this.findViewById(R.id.tv_text12)).setText("5min");
                            break;
                        case 2:
                            ((TextView) LZFordQuanshunT8CarInfo.this.findViewById(R.id.tv_text12)).setText("10min");
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0455_lz_quanshunt8_carinfo);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[114] - 1;
                if (value < 1) {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[114] + 1;
                if (value2 > 4) {
                    value2 = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value2}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[115] - 1;
                if (value3 < 1) {
                    value3 = 3;
                }
                DataCanbus.PROXY.cmd(0, new int[]{2, value3}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[115] + 1;
                if (value4 > 3) {
                    value4 = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{2, value4}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[126] - 1;
                if (value5 < 1) {
                    value5 = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{4, value5}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[126] + 1;
                if (value6 > 2) {
                    value6 = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{4, value6}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                DataCanbus.PROXY.cmd(0, new int[]{3, 1}, null, null);
                SystemClock.sleep(100L);
                DataCanbus.PROXY.cmd(0, new int[]{3, 0}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                DataCanbus.PROXY.cmd(0, new int[]{3, 4}, null, null);
                SystemClock.sleep(100L);
                DataCanbus.PROXY.cmd(0, new int[]{3, 0}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                DataCanbus.PROXY.cmd(0, new int[]{3, 6}, null, null);
                SystemClock.sleep(100L);
                DataCanbus.PROXY.cmd(0, new int[]{3, 0}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                DataCanbus.PROXY.cmd(0, new int[]{3, 2}, null, null);
                SystemClock.sleep(100L);
                DataCanbus.PROXY.cmd(0, new int[]{3, 0}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                DataCanbus.PROXY.cmd(0, new int[]{3, 3}, null, null);
                SystemClock.sleep(100L);
                DataCanbus.PROXY.cmd(0, new int[]{3, 0}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                DataCanbus.PROXY.cmd(0, new int[]{3, 7}, null, null);
                SystemClock.sleep(100L);
                DataCanbus.PROXY.cmd(0, new int[]{3, 0}, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                DataCanbus.PROXY.cmd(0, new int[]{3, 5}, null, null);
                SystemClock.sleep(100L);
                DataCanbus.PROXY.cmd(0, new int[]{3, 0}, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                DataCanbus.PROXY.cmd(0, new int[]{3, 8}, null, null);
                SystemClock.sleep(100L);
                DataCanbus.PROXY.cmd(0, new int[]{3, 0}, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                DataCanbus.PROXY.cmd(0, new int[]{3, 9}, null, null);
                SystemClock.sleep(100L);
                DataCanbus.PROXY.cmd(0, new int[]{3, 0}, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                DataCanbus.PROXY.cmd(0, new int[]{3, 10}, null, null);
                SystemClock.sleep(100L);
                DataCanbus.PROXY.cmd(0, new int[]{3, 0}, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, LuzFordQuanshunT8TireAct.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo3() {
        int value = DataCanbus.DATA[111];
        int unit = DataCanbus.DATA[99];
        if (value == 255) {
            ((TextView) findViewById(R.id.tv_text7)).setText("----");
        } else if (unit == 0) {
            ((TextView) findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " km/h");
        } else {
            ((TextView) findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " MPH");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo2() {
        int value = DataCanbus.DATA[100];
        int unit = DataCanbus.DATA[98];
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text2)).setText("----");
        } else if (unit == 0) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " Km");
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " Mil");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo1() {
        int value = DataCanbus.DATA[101];
        int unit = DataCanbus.DATA[98];
        if (value == 16777215) {
            ((TextView) findViewById(R.id.tv_text1)).setText("----");
        } else if (unit == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " Km");
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " Mil");
        }
    }
}
