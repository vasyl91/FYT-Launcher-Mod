package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LZFiatInfCarSet extends BaseActivity implements View.OnClickListener {
    int tripunit = 0;
    int tripoilunit = 0;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.LZFiatInfCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 7:
                    LZFiatInfCarSet.this.updateMile();
                    break;
                case 8:
                    LZFiatInfCarSet.this.updateTotalMile();
                    break;
                case 9:
                    LZFiatInfCarSet.this.updateTotalMile();
                    LZFiatInfCarSet.this.updateMile();
                    break;
                case 10:
                case 11:
                    int hour = DataCanbus.DATA[10];
                    int min = DataCanbus.DATA[11];
                    ((TextView) LZFiatInfCarSet.this.findViewById(R.id.tv_text3)).setText(String.valueOf(hour) + " : " + (min / 10) + (min % 10));
                    break;
                case 12:
                    if (LZFiatInfCarSet.this.tripunit == 1) {
                        ((TextView) LZFiatInfCarSet.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " mph");
                    } else {
                        ((TextView) LZFiatInfCarSet.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " km/h");
                    }
                    break;
                case 13:
                    if (LZFiatInfCarSet.this.tripunit == 1) {
                        ((TextView) LZFiatInfCarSet.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + " miles");
                    } else {
                        ((TextView) LZFiatInfCarSet.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + " km");
                    }
                    break;
                case 14:
                    if (LZFiatInfCarSet.this.tripoilunit == 1) {
                        ((TextView) LZFiatInfCarSet.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg(uk)");
                    } else if (LZFiatInfCarSet.this.tripoilunit == 2) {
                        ((TextView) LZFiatInfCarSet.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/l");
                    } else if (LZFiatInfCarSet.this.tripoilunit == 3) {
                        ((TextView) LZFiatInfCarSet.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg(us)");
                    } else {
                        ((TextView) LZFiatInfCarSet.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + " l/100km");
                    }
                    break;
                case 15:
                case 16:
                    int hour2 = DataCanbus.DATA[15];
                    int min2 = DataCanbus.DATA[16];
                    ((TextView) LZFiatInfCarSet.this.findViewById(R.id.tv_text7)).setText(String.valueOf(hour2) + " : " + (min2 / 10) + (min2 % 10));
                    break;
                case 17:
                    if (LZFiatInfCarSet.this.tripunit == 1) {
                        ((TextView) LZFiatInfCarSet.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + " mph");
                    } else {
                        ((TextView) LZFiatInfCarSet.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + " km/h");
                    }
                    break;
                case 18:
                    if (LZFiatInfCarSet.this.tripunit == 1) {
                        ((TextView) LZFiatInfCarSet.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value) + " miles");
                    } else {
                        ((TextView) LZFiatInfCarSet.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value) + " km");
                    }
                    break;
                case 19:
                    if (LZFiatInfCarSet.this.tripoilunit == 1) {
                        ((TextView) LZFiatInfCarSet.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg(uk)");
                    } else if (LZFiatInfCarSet.this.tripoilunit == 2) {
                        ((TextView) LZFiatInfCarSet.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/l");
                    } else if (LZFiatInfCarSet.this.tripoilunit == 3) {
                        ((TextView) LZFiatInfCarSet.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg(us)");
                    } else {
                        ((TextView) LZFiatInfCarSet.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value / 10) + "." + (value % 10) + " l/100km");
                    }
                    break;
                case 20:
                    LZFiatInfCarSet.this.tripunit = value;
                    break;
                case 21:
                    LZFiatInfCarSet.this.tripoilunit = value;
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0455_lz_fiat_carinfo);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{53}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{55}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
    }

    void updateTotalMile() {
        int unit = DataCanbus.DATA[9];
        int data = DataCanbus.DATA[8];
        if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(data) + " miles");
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(data) + " km");
        }
    }

    void updateMile() {
        int unit = DataCanbus.DATA[9];
        int data = DataCanbus.DATA[7];
        if (unit == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(data) + " miles");
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(data) + " km");
        }
    }
}
