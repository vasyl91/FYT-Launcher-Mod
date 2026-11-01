package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Golf7FunctionalCarAmpSet extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalCarAmpSet.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427456 */:
                    int data = DataCanbus.DATA[461];
                    if (data > 0) {
                        data--;
                    }
                    DataCanbus.PROXY.cmd(144, new int[]{0, data}, null, null);
                    break;
                case R.id.btn_plus1 /* 2131427458 */:
                    int data2 = DataCanbus.DATA[461];
                    if (data2 < 30) {
                        data2++;
                    }
                    DataCanbus.PROXY.cmd(144, new int[]{0, data2}, null, null);
                    break;
                case R.id.btn_minus2 /* 2131427459 */:
                    int data3 = DataCanbus.DATA[462];
                    if (data3 > 0) {
                        data3--;
                    }
                    DataCanbus.PROXY.cmd(144, new int[]{1, data3}, null, null);
                    break;
                case R.id.btn_plus2 /* 2131427461 */:
                    int data4 = DataCanbus.DATA[462];
                    if (data4 < 18) {
                        data4++;
                    }
                    DataCanbus.PROXY.cmd(144, new int[]{1, data4}, null, null);
                    break;
                case R.id.btn_minus3 /* 2131427462 */:
                    int data5 = DataCanbus.DATA[463];
                    if (data5 > 0) {
                        data5--;
                    }
                    DataCanbus.PROXY.cmd(144, new int[]{2, data5}, null, null);
                    break;
                case R.id.btn_plus3 /* 2131427464 */:
                    int data6 = DataCanbus.DATA[463];
                    if (data6 < 18) {
                        data6++;
                    }
                    DataCanbus.PROXY.cmd(144, new int[]{2, data6}, null, null);
                    break;
                case R.id.btn_minus4 /* 2131427465 */:
                    int data7 = DataCanbus.DATA[464];
                    if (data7 > 0) {
                        data7--;
                    }
                    DataCanbus.PROXY.cmd(144, new int[]{3, data7}, null, null);
                    break;
                case R.id.btn_plus4 /* 2131427467 */:
                    int data8 = DataCanbus.DATA[464];
                    if (data8 < 18) {
                        data8++;
                    }
                    DataCanbus.PROXY.cmd(144, new int[]{3, data8}, null, null);
                    break;
                case R.id.btn_minus5 /* 2131427468 */:
                    int data9 = DataCanbus.DATA[465];
                    if (data9 > 0) {
                        data9--;
                    }
                    DataCanbus.PROXY.cmd(144, new int[]{4, data9}, null, null);
                    break;
                case R.id.btn_plus5 /* 2131427470 */:
                    int data10 = DataCanbus.DATA[465];
                    if (data10 < 18) {
                        data10++;
                    }
                    DataCanbus.PROXY.cmd(144, new int[]{4, data10}, null, null);
                    break;
                case R.id.btn_minus6 /* 2131427471 */:
                    int data11 = DataCanbus.DATA[466];
                    if (data11 > 0) {
                        data11--;
                    }
                    DataCanbus.PROXY.cmd(144, new int[]{5, data11}, null, null);
                    break;
                case R.id.btn_plus6 /* 2131427473 */:
                    int data12 = DataCanbus.DATA[466];
                    if (data12 < 18) {
                        data12++;
                    }
                    DataCanbus.PROXY.cmd(144, new int[]{5, data12}, null, null);
                    break;
                case R.id.btn_minus7 /* 2131427474 */:
                    int data13 = DataCanbus.DATA[467];
                    if (data13 > 0) {
                        data13--;
                    }
                    DataCanbus.PROXY.cmd(144, new int[]{6, data13}, null, null);
                    break;
                case R.id.btn_plus7 /* 2131427476 */:
                    int data14 = DataCanbus.DATA[467];
                    if (data14 < 7) {
                        data14++;
                    }
                    DataCanbus.PROXY.cmd(144, new int[]{6, data14}, null, null);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7FunctionalCarAmpSet.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 461:
                    ((TextView) Golf7FunctionalCarAmpSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(val)).toString());
                    break;
                case 462:
                    if (val > 9) {
                        ((TextView) Golf7FunctionalCarAmpSet.this.findViewById(R.id.tv_text2)).setText("+" + (val - 9));
                    } else if (val < 9) {
                        ((TextView) Golf7FunctionalCarAmpSet.this.findViewById(R.id.tv_text2)).setText("-" + (9 - val));
                    } else {
                        ((TextView) Golf7FunctionalCarAmpSet.this.findViewById(R.id.tv_text2)).setText("0");
                    }
                    break;
                case 463:
                    if (val > 9) {
                        ((TextView) Golf7FunctionalCarAmpSet.this.findViewById(R.id.tv_text3)).setText("+" + (val - 9));
                    } else if (val < 9) {
                        ((TextView) Golf7FunctionalCarAmpSet.this.findViewById(R.id.tv_text3)).setText("-" + (9 - val));
                    } else {
                        ((TextView) Golf7FunctionalCarAmpSet.this.findViewById(R.id.tv_text3)).setText("0");
                    }
                    break;
                case 464:
                    if (val > 9) {
                        ((TextView) Golf7FunctionalCarAmpSet.this.findViewById(R.id.tv_text4)).setText("+" + (val - 9));
                    } else if (val < 9) {
                        ((TextView) Golf7FunctionalCarAmpSet.this.findViewById(R.id.tv_text4)).setText("-" + (9 - val));
                    } else {
                        ((TextView) Golf7FunctionalCarAmpSet.this.findViewById(R.id.tv_text4)).setText("0");
                    }
                    break;
                case 465:
                    if (val > 9) {
                        ((TextView) Golf7FunctionalCarAmpSet.this.findViewById(R.id.tv_text5)).setText("R" + (val - 9));
                    } else if (val < 9) {
                        ((TextView) Golf7FunctionalCarAmpSet.this.findViewById(R.id.tv_text5)).setText("F" + (9 - val));
                    } else {
                        ((TextView) Golf7FunctionalCarAmpSet.this.findViewById(R.id.tv_text5)).setText("0");
                    }
                    break;
                case 466:
                    if (val > 9) {
                        ((TextView) Golf7FunctionalCarAmpSet.this.findViewById(R.id.tv_text6)).setText("R" + (val - 9));
                    } else if (val < 9) {
                        ((TextView) Golf7FunctionalCarAmpSet.this.findViewById(R.id.tv_text6)).setText("L" + (9 - val));
                    } else {
                        ((TextView) Golf7FunctionalCarAmpSet.this.findViewById(R.id.tv_text6)).setText("0");
                    }
                    break;
                case 467:
                    ((TextView) Golf7FunctionalCarAmpSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(val).toString());
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_functional_amp_set);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setonClick((Button) findViewById(R.id.btn_minus1));
        setonClick((Button) findViewById(R.id.btn_plus1));
        setonClick((Button) findViewById(R.id.btn_minus2));
        setonClick((Button) findViewById(R.id.btn_plus2));
        setonClick((Button) findViewById(R.id.btn_minus3));
        setonClick((Button) findViewById(R.id.btn_plus3));
        setonClick((Button) findViewById(R.id.btn_minus4));
        setonClick((Button) findViewById(R.id.btn_plus4));
        setonClick((Button) findViewById(R.id.btn_minus5));
        setonClick((Button) findViewById(R.id.btn_plus5));
        setonClick((Button) findViewById(R.id.btn_minus6));
        setonClick((Button) findViewById(R.id.btn_plus6));
        setonClick((Button) findViewById(R.id.btn_minus7));
        setonClick((Button) findViewById(R.id.btn_plus7));
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
    protected void finalize() throws Throwable {
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[461].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[462].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[463].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[464].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[465].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[466].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[467].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[461].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[462].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[463].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[464].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[465].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[466].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[467].removeNotify(this.mNotifyCanbus);
    }
}
