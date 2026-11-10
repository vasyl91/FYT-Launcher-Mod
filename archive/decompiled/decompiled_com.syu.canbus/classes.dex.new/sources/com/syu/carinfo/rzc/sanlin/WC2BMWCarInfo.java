package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WC2BMWCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.WC2BMWCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    WC2BMWCarInfo.this.updateCarinfo1();
                    break;
                case 99:
                    WC2BMWCarInfo.this.updateCarinfo2();
                    break;
                case 100:
                    WC2BMWCarInfo.this.updateCarinfo3();
                    break;
                case 101:
                    WC2BMWCarInfo.this.updateCarinfo4();
                    break;
                case 102:
                    WC2BMWCarInfo.this.updateCarinfo8();
                    WC2BMWCarInfo.this.updateCarinfo7();
                    WC2BMWCarInfo.this.updateCarinfo4();
                    WC2BMWCarInfo.this.updateCarinfo3();
                    WC2BMWCarInfo.this.updateCarinfo2();
                    WC2BMWCarInfo.this.updateCarinfo1();
                    break;
                case 103:
                    WC2BMWCarInfo.this.updateCarinfo5();
                    break;
                case 104:
                    WC2BMWCarInfo.this.updateCarinfo6();
                    break;
                case 105:
                    WC2BMWCarInfo.this.updateCarinfo7();
                    break;
                case 106:
                    WC2BMWCarInfo.this.updateCarinfo8();
                    break;
                case 107:
                    ((TextView) WC2BMWCarInfo.this.findViewById(R.id.tv_text9)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 108:
                    if (value < 10) {
                        ((TextView) WC2BMWCarInfo.this.findViewById(R.id.tv_text10)).setText("L" + (10 - value));
                    } else if (value > 10) {
                        ((TextView) WC2BMWCarInfo.this.findViewById(R.id.tv_text10)).setText("R" + (value - 10));
                    } else {
                        ((TextView) WC2BMWCarInfo.this.findViewById(R.id.tv_text10)).setText("0");
                    }
                    break;
                case 109:
                    if (value < 10) {
                        ((TextView) WC2BMWCarInfo.this.findViewById(R.id.tv_text11)).setText("F" + (10 - value));
                    } else if (value > 10) {
                        ((TextView) WC2BMWCarInfo.this.findViewById(R.id.tv_text11)).setText("R" + (value - 10));
                    } else {
                        ((TextView) WC2BMWCarInfo.this.findViewById(R.id.tv_text11)).setText("0");
                    }
                    break;
                case 110:
                    if (value < 6) {
                        ((TextView) WC2BMWCarInfo.this.findViewById(R.id.tv_text12)).setText("-" + (6 - value));
                    } else if (value > 6) {
                        ((TextView) WC2BMWCarInfo.this.findViewById(R.id.tv_text12)).setText("+" + (value - 6));
                    } else {
                        ((TextView) WC2BMWCarInfo.this.findViewById(R.id.tv_text12)).setText("0");
                    }
                    break;
                case 111:
                    if (value < 6) {
                        ((TextView) WC2BMWCarInfo.this.findViewById(R.id.tv_text13)).setText("-" + (6 - value));
                    } else if (value > 6) {
                        ((TextView) WC2BMWCarInfo.this.findViewById(R.id.tv_text13)).setText("+" + (value - 6));
                    } else {
                        ((TextView) WC2BMWCarInfo.this.findViewById(R.id.tv_text13)).setText("0");
                    }
                    break;
                case 112:
                    if (value < 6) {
                        ((TextView) WC2BMWCarInfo.this.findViewById(R.id.tv_text14)).setText("-" + (6 - value));
                    } else if (value > 6) {
                        ((TextView) WC2BMWCarInfo.this.findViewById(R.id.tv_text14)).setText("+" + (value - 6));
                    } else {
                        ((TextView) WC2BMWCarInfo.this.findViewById(R.id.tv_text14)).setText("0");
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0444_wc_bmw_carinfo);
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
                DataCanbus.PROXY.cmd(3, new int[]{1, 255}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                DataCanbus.PROXY.cmd(3, new int[]{1, 1}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value = DataCanbus.DATA[108];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{2, value}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value2 = DataCanbus.DATA[108];
                if (value2 < 20) {
                    value2++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{2, value2}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value3 = DataCanbus.DATA[109];
                if (value3 > 0) {
                    value3--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{3, value3}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value4 = DataCanbus.DATA[109];
                if (value4 < 20) {
                    value4++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{3, value4}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value5 = DataCanbus.DATA[110];
                if (value5 > 0) {
                    value5--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{4, value5}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value6 = DataCanbus.DATA[110];
                if (value6 < 12) {
                    value6++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{4, value6}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value7 = DataCanbus.DATA[111];
                if (value7 > 0) {
                    value7--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{5, value7}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value8 = DataCanbus.DATA[111];
                if (value8 < 12) {
                    value8++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{5, value8}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value9 = DataCanbus.DATA[112];
                if (value9 > 0) {
                    value9--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{6, value9}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value10 = DataCanbus.DATA[112];
                if (value10 < 12) {
                    value10++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{6, value10}, null, null);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo8() {
        int value = DataCanbus.DATA[106];
        int unit = (DataCanbus.DATA[102] >> 6) & 1;
        if (value == 16777215) {
            ((TextView) findViewById(R.id.tv_text8)).setText("----");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text8)).setText(String.valueOf(value) + " km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text8)).setText(String.valueOf(value) + " miles");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo7() {
        int value = DataCanbus.DATA[105];
        int unit = (DataCanbus.DATA[102] >> 7) & 1;
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text7)).setText("----");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " ℃");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " ℉");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo6() {
        int value = DataCanbus.DATA[104];
        if (value == 255) {
            ((TextView) findViewById(R.id.tv_text6)).setText("----");
        } else {
            ((TextView) findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " L");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo5() {
        int value = DataCanbus.DATA[103];
        if (value == 255) {
            ((TextView) findViewById(R.id.tv_text5)).setText("----");
        } else {
            ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " V");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo4() {
        int value = DataCanbus.DATA[101];
        int unit = (DataCanbus.DATA[102] >> 5) & 1;
        if (value == 255) {
            ((TextView) findViewById(R.id.tv_text4)).setText("----");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " km/h");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " mph");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo3() {
        int value = DataCanbus.DATA[100];
        int unit = (DataCanbus.DATA[102] >> 2) & 3;
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text3)).setText("----");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " Km/L");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100Km");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo2() {
        int value = DataCanbus.DATA[99];
        int unit = (DataCanbus.DATA[102] >> 6) & 1;
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text2)).setText("----");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " miles");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo1() {
        int value = DataCanbus.DATA[98];
        int unit = (DataCanbus.DATA[102] >> 2) & 3;
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text1)).setText("----");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " Km/L");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100Km");
                break;
        }
    }
}
