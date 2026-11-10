package com.syu.carinfo.rzc.klc;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZCGMAHDActi extends BaseActivity implements View.OnTouchListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.klc.RZCGMAHDActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 322:
                    ((TextView) RZCGMAHDActi.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(value).toString());
                    break;
                case 323:
                    switch (value) {
                        case 1:
                            ((TextView) RZCGMAHDActi.this.findViewById(R.id.tv_text14)).setText(R.string.str_centered);
                            break;
                        case 2:
                            ((TextView) RZCGMAHDActi.this.findViewById(R.id.tv_text14)).setText(R.string.str_full_screen);
                            break;
                    }
                    break;
                case 324:
                    switch (value) {
                        case 6:
                            ((TextView) RZCGMAHDActi.this.findViewById(R.id.tv_text15)).setText("1280x720@30Hz");
                            break;
                        case 7:
                            ((TextView) RZCGMAHDActi.this.findViewById(R.id.tv_text15)).setText("1280x720@25Hz");
                            break;
                    }
                    break;
                case 325:
                    if ((value & 128) != 0) {
                        ((TextView) RZCGMAHDActi.this.findViewById(R.id.tv_text16)).setText("-" + (256 - value));
                    } else {
                        ((TextView) RZCGMAHDActi.this.findViewById(R.id.tv_text16)).setText("+" + value);
                    }
                    break;
                case 326:
                    if ((value & 128) != 0) {
                        ((TextView) RZCGMAHDActi.this.findViewById(R.id.tv_text17)).setText("-" + (256 - value));
                    } else {
                        ((TextView) RZCGMAHDActi.this.findViewById(R.id.tv_text17)).setText("+" + value);
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_jeep_rzc_ahd_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.btn_minus13).setOnTouchListener(this);
        findViewById(R.id.btn_plus13).setOnTouchListener(this);
        findViewById(R.id.btn_minus14).setOnTouchListener(this);
        findViewById(R.id.btn_plus14).setOnTouchListener(this);
        findViewById(R.id.btn_minus15).setOnTouchListener(this);
        findViewById(R.id.btn_plus15).setOnTouchListener(this);
        findViewById(R.id.btn_minus16).setOnTouchListener(this);
        findViewById(R.id.btn_plus16).setOnTouchListener(this);
        findViewById(R.id.btn_minus17).setOnTouchListener(this);
        findViewById(R.id.btn_plus17).setOnTouchListener(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.btn_minus13 /* 2131427492 */:
                    int d2 = DataCanbus.DATA[322];
                    int d3 = DataCanbus.DATA[323];
                    int d4 = DataCanbus.DATA[324];
                    if (d2 > 0) {
                        d2--;
                    }
                    setCarInfo1(0, d2, d3, d4, 0, 0);
                    break;
                case R.id.btn_plus13 /* 2131427494 */:
                    int d5 = DataCanbus.DATA[322];
                    int d6 = DataCanbus.DATA[323];
                    int d7 = DataCanbus.DATA[324];
                    if (d5 < 10) {
                        d5++;
                    }
                    setCarInfo1(0, d5, d6, d7, 0, 0);
                    break;
                case R.id.btn_minus14 /* 2131427495 */:
                    int d8 = DataCanbus.DATA[322];
                    int d9 = DataCanbus.DATA[323];
                    int d10 = DataCanbus.DATA[324];
                    int d11 = d9 - 1;
                    if (d11 < 1) {
                        d11 = 2;
                    }
                    setCarInfo1(0, d8, d11, d10, 0, 0);
                    break;
                case R.id.btn_plus14 /* 2131427497 */:
                    int d12 = DataCanbus.DATA[322];
                    int d13 = DataCanbus.DATA[323];
                    int d14 = DataCanbus.DATA[324];
                    int d15 = d13 + 1;
                    if (d15 > 2) {
                        d15 = 1;
                    }
                    setCarInfo1(0, d12, d15, d14, 0, 0);
                    break;
                case R.id.btn_minus15 /* 2131427498 */:
                    int d16 = DataCanbus.DATA[322];
                    int d17 = DataCanbus.DATA[323];
                    int d18 = DataCanbus.DATA[324];
                    int d19 = d18 - 1;
                    if (d19 < 6) {
                        d19 = 7;
                    }
                    setCarInfo1(0, d16, d17, d19, 0, 0);
                    break;
                case R.id.btn_plus15 /* 2131427500 */:
                    int d20 = DataCanbus.DATA[322];
                    int d21 = DataCanbus.DATA[323];
                    int d22 = DataCanbus.DATA[324];
                    int d23 = d22 + 1;
                    if (d23 > 7) {
                        d23 = 6;
                    }
                    setCarInfo1(0, d20, d21, d23, 0, 0);
                    break;
                case R.id.btn_minus16 /* 2131427501 */:
                    int d24 = DataCanbus.DATA[322];
                    int d25 = DataCanbus.DATA[323];
                    int d26 = DataCanbus.DATA[324];
                    setCarInfo1(0, d24, d25, d26, 1, 0);
                    break;
                case R.id.btn_plus16 /* 2131427503 */:
                    int d27 = DataCanbus.DATA[322];
                    int d28 = DataCanbus.DATA[323];
                    int d29 = DataCanbus.DATA[324];
                    setCarInfo1(0, d27, d28, d29, 2, 0);
                    break;
                case R.id.btn_minus17 /* 2131427504 */:
                    int d30 = DataCanbus.DATA[322];
                    int d31 = DataCanbus.DATA[323];
                    int d32 = DataCanbus.DATA[324];
                    setCarInfo1(0, d30, d31, d32, 0, 1);
                    break;
                case R.id.btn_plus17 /* 2131427506 */:
                    int d33 = DataCanbus.DATA[322];
                    int d34 = DataCanbus.DATA[323];
                    int d35 = DataCanbus.DATA[324];
                    setCarInfo1(0, d33, d34, d35, 0, 2);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.btn_minus16 /* 2131427501 */:
                case R.id.btn_plus16 /* 2131427503 */:
                case R.id.btn_minus17 /* 2131427504 */:
                case R.id.btn_plus17 /* 2131427506 */:
                    int d36 = DataCanbus.DATA[322];
                    int d37 = DataCanbus.DATA[323];
                    int d38 = DataCanbus.DATA[324];
                    setCarInfo1(0, d36, d37, d38, 0, 0);
                case R.id.tv_text16 /* 2131427502 */:
                case R.id.tv_text17 /* 2131427505 */:
                default:
                    return false;
            }
        }
        return false;
    }

    public void setCarInfo1(int value1, int value2, int value3, int value4, int value5, int value6) {
        DataCanbus.PROXY.cmd(49, new int[]{value1, value2, value3, value4, value5, value6}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[322].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[323].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[324].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[325].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[326].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[322].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[323].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[324].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[325].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[326].removeNotify(this.mNotifyCanbus);
    }
}
