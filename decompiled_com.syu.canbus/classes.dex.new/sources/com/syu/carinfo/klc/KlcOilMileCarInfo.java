package com.syu.carinfo.klc;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class KlcOilMileCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.klc.KlcOilMileCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 106:
                    KlcOilMileCarInfo.this.updateCarinfo1();
                    break;
                case 196:
                    KlcOilMileCarInfo.this.updateCarinfo3();
                    break;
                case 202:
                    KlcOilMileCarInfo.this.updateCarinfo2();
                    break;
                case 203:
                    KlcOilMileCarInfo.this.updateCarinfo4();
                    break;
                case 231:
                    KlcOilMileCarInfo.this.updateCarinfo5();
                    break;
                case 232:
                    KlcOilMileCarInfo.this.updateCarinfo6();
                    break;
                case 233:
                    KlcOilMileCarInfo.this.updateCarinfo7();
                    break;
                case 234:
                    KlcOilMileCarInfo.this.updateCarinfo8();
                    break;
                case 235:
                    KlcOilMileCarInfo.this.updateCarinfo9();
                    break;
                case 236:
                    KlcOilMileCarInfo.this.updateCarinfo2();
                    KlcOilMileCarInfo.this.updateCarinfo3();
                    KlcOilMileCarInfo.this.updateCarinfo5();
                    KlcOilMileCarInfo.this.updateCarinfo7();
                    KlcOilMileCarInfo.this.updateCarinfo9();
                    break;
                case 237:
                    KlcOilMileCarInfo.this.updateCarinfo1();
                    KlcOilMileCarInfo.this.updateCarinfo4();
                    KlcOilMileCarInfo.this.updateCarinfo6();
                    KlcOilMileCarInfo.this.updateCarinfo8();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0036_wc_gm_carinfo);
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
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[231].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[232].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[233].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[234].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[235].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[236].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[237].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[231].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[232].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[233].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[234].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[235].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[236].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[237].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo9() {
        int value = DataCanbus.DATA[235];
        int unit = DataCanbus.DATA[236];
        if (value == 16777215) {
            ((TextView) findViewById(R.id.tv_text9)).setText("----");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mile");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo8() {
        int value = DataCanbus.DATA[234];
        int unit = DataCanbus.DATA[237];
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text8)).setText("----");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/L");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/H");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo7() {
        int value = DataCanbus.DATA[233];
        int unit = DataCanbus.DATA[236];
        if (value == 16777215) {
            ((TextView) findViewById(R.id.tv_text7)).setText("----");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mile");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo6() {
        int value = DataCanbus.DATA[232];
        int unit = DataCanbus.DATA[237];
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text6)).setText("----");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/L");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/H");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo5() {
        int value = DataCanbus.DATA[231];
        int unit = DataCanbus.DATA[236];
        if (value == 16777215) {
            ((TextView) findViewById(R.id.tv_text5)).setText("----");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mile");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo4() {
        int value = DataCanbus.DATA[203];
        int unit = DataCanbus.DATA[237];
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text4)).setText("----");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/L");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/H");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo3() {
        int value = DataCanbus.DATA[196];
        int unit = DataCanbus.DATA[236];
        if (value == 16777215) {
            ((TextView) findViewById(R.id.tv_text3)).setText("----");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mile");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo2() {
        int value = DataCanbus.DATA[202];
        int unit = DataCanbus.DATA[236];
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text2)).setText("----");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " mile");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo1() {
        int value = DataCanbus.DATA[106];
        int unit = DataCanbus.DATA[237];
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text1)).setText("----");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/L");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/H");
                break;
        }
    }
}
