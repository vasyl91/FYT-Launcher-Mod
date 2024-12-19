package com.syu.carinfo.ford;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LZSubaruCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ford.LZSubaruCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 28:
                    LZSubaruCarInfo.this.updateCarinfo1();
                    break;
                case 29:
                    LZSubaruCarInfo.this.updateCarinfo4();
                    break;
                case 30:
                    LZSubaruCarInfo.this.updateCarinfo6();
                    break;
                case 31:
                    LZSubaruCarInfo.this.updateCarinfo2();
                    break;
                case 32:
                    LZSubaruCarInfo.this.updateCarinfo5();
                    break;
                case 33:
                    LZSubaruCarInfo.this.updateCarinfo7();
                    break;
                case 34:
                    ((TextView) LZSubaruCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "%");
                    break;
                case 61:
                    switch (value) {
                        case 0:
                            ((TextView) LZSubaruCarInfo.this.findViewById(R.id.tv_text8)).setText("km");
                            break;
                        case 1:
                            ((TextView) LZSubaruCarInfo.this.findViewById(R.id.tv_text8)).setText("mile");
                            break;
                    }
                    LZSubaruCarInfo.this.updateCarinfo2();
                    LZSubaruCarInfo.this.updateCarinfo5();
                    LZSubaruCarInfo.this.updateCarinfo7();
                    break;
                case 62:
                    switch (value) {
                        case 0:
                            ((TextView) LZSubaruCarInfo.this.findViewById(R.id.tv_text9)).setText("L/100km");
                            break;
                        case 1:
                            ((TextView) LZSubaruCarInfo.this.findViewById(R.id.tv_text9)).setText("mpg");
                            break;
                        case 2:
                            ((TextView) LZSubaruCarInfo.this.findViewById(R.id.tv_text9)).setText("km/L");
                            break;
                    }
                    LZSubaruCarInfo.this.updateCarinfo1();
                    LZSubaruCarInfo.this.updateCarinfo4();
                    LZSubaruCarInfo.this.updateCarinfo6();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_lz_subaru_carinfo);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{53}, null, null);
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
            case R.id.btn_minus1 /* 2131427480 */:
                int value = DataCanbus.DATA[61] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value2 = DataCanbus.DATA[61] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value3 = DataCanbus.DATA[62] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value4 = DataCanbus.DATA[62] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(2, value4);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(3, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo7() {
        int value = DataCanbus.DATA[33];
        int unit = DataCanbus.DATA[61];
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " miles");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo6() {
        int value = DataCanbus.DATA[30];
        int unit = DataCanbus.DATA[62];
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10.0f) + " L/100km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10.0f) + " mpg");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10.0f) + " km/L");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo5() {
        int value = DataCanbus.DATA[32];
        int unit = DataCanbus.DATA[61];
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf(value) + " km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf(value) + " miles");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo4() {
        int value = DataCanbus.DATA[29];
        int unit = DataCanbus.DATA[62];
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10.0f) + " L/100km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10.0f) + " mpg");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10.0f) + " km/L");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarinfo2() {
        int value = DataCanbus.DATA[31];
        int unit = DataCanbus.DATA[61];
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
        int value = DataCanbus.DATA[28];
        int unit = DataCanbus.DATA[62];
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10.0f) + " L/100km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10.0f) + " mpg");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10.0f) + " km/L");
                break;
        }
    }
}
