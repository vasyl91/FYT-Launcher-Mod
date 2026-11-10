package com.syu.carinfo.honda;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class RZCHondaAHDActi extends BaseActivity implements View.OnTouchListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.RZCHondaAHDActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 320:
                    ((TextView) RZCHondaAHDActi.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(value).toString());
                    break;
                case 321:
                    switch (value) {
                        case 1:
                            ((TextView) RZCHondaAHDActi.this.findViewById(R.id.tv_text14)).setText(R.string.str_centered);
                            break;
                        case 2:
                            ((TextView) RZCHondaAHDActi.this.findViewById(R.id.tv_text14)).setText(R.string.str_full_screen);
                            break;
                    }
                    break;
                case 322:
                    switch (value) {
                        case 6:
                            ((TextView) RZCHondaAHDActi.this.findViewById(R.id.tv_text15)).setText("1280x720@30Hz");
                            break;
                        case 7:
                            ((TextView) RZCHondaAHDActi.this.findViewById(R.id.tv_text15)).setText("1280x720@25Hz");
                            break;
                    }
                    break;
                case 323:
                    if ((value & 128) != 0) {
                        ((TextView) RZCHondaAHDActi.this.findViewById(R.id.tv_text16)).setText("-" + (256 - value));
                    } else {
                        ((TextView) RZCHondaAHDActi.this.findViewById(R.id.tv_text16)).setText("+" + value);
                    }
                    break;
                case 324:
                    if ((value & 128) != 0) {
                        ((TextView) RZCHondaAHDActi.this.findViewById(R.id.tv_text17)).setText("-" + (256 - value));
                    } else {
                        ((TextView) RZCHondaAHDActi.this.findViewById(R.id.tv_text17)).setText("+" + value);
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
                case R.id.btn_plus13 /* 2131427437 */:
                    int d2 = DataCanbus.DATA[320];
                    int d3 = DataCanbus.DATA[321];
                    int d4 = DataCanbus.DATA[322];
                    if (d2 < 5) {
                        d2++;
                    }
                    setCarInfo1(0, d2, d3, d4, 0, 0);
                    break;
                case R.id.btn_plus14 /* 2131427438 */:
                    int d5 = DataCanbus.DATA[320];
                    int d6 = DataCanbus.DATA[321];
                    int d7 = DataCanbus.DATA[322];
                    int d8 = d6 + 1;
                    if (d8 > 2) {
                        d8 = 1;
                    }
                    setCarInfo1(0, d5, d8, d7, 0, 0);
                    break;
                case R.id.btn_plus15 /* 2131427439 */:
                    int d9 = DataCanbus.DATA[320];
                    int d10 = DataCanbus.DATA[321];
                    int d11 = DataCanbus.DATA[322];
                    int d12 = d11 + 1;
                    if (d12 > 7) {
                        d12 = 6;
                    }
                    setCarInfo1(0, d9, d10, d12, 0, 0);
                    break;
                case R.id.btn_plus16 /* 2131427440 */:
                    int d13 = DataCanbus.DATA[320];
                    int d14 = DataCanbus.DATA[321];
                    int d15 = DataCanbus.DATA[322];
                    setCarInfo1(0, d13, d14, d15, 2, 0);
                    break;
                case R.id.btn_minus13 /* 2131427490 */:
                    int d16 = DataCanbus.DATA[320];
                    int d17 = DataCanbus.DATA[321];
                    int d18 = DataCanbus.DATA[322];
                    if (d16 > 0) {
                        d16--;
                    }
                    setCarInfo1(0, d16, d17, d18, 0, 0);
                    break;
                case R.id.btn_minus14 /* 2131427492 */:
                    int d19 = DataCanbus.DATA[320];
                    int d20 = DataCanbus.DATA[321];
                    int d21 = DataCanbus.DATA[322];
                    int d22 = d20 - 1;
                    if (d22 < 1) {
                        d22 = 2;
                    }
                    setCarInfo1(0, d19, d22, d21, 0, 0);
                    break;
                case R.id.btn_minus15 /* 2131427494 */:
                    int d23 = DataCanbus.DATA[320];
                    int d24 = DataCanbus.DATA[321];
                    int d25 = DataCanbus.DATA[322];
                    int d26 = d25 - 1;
                    if (d26 < 6) {
                        d26 = 7;
                    }
                    setCarInfo1(0, d23, d24, d26, 0, 0);
                    break;
                case R.id.btn_minus16 /* 2131427496 */:
                    int d27 = DataCanbus.DATA[320];
                    int d28 = DataCanbus.DATA[321];
                    int d29 = DataCanbus.DATA[322];
                    setCarInfo1(0, d27, d28, d29, 1, 0);
                    break;
                case R.id.btn_minus17 /* 2131427498 */:
                    int d30 = DataCanbus.DATA[320];
                    int d31 = DataCanbus.DATA[321];
                    int d32 = DataCanbus.DATA[322];
                    setCarInfo1(0, d30, d31, d32, 0, 1);
                    break;
                case R.id.btn_plus17 /* 2131427500 */:
                    int d33 = DataCanbus.DATA[320];
                    int d34 = DataCanbus.DATA[321];
                    int d35 = DataCanbus.DATA[322];
                    setCarInfo1(0, d33, d34, d35, 0, 2);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.btn_plus16 /* 2131427440 */:
                case R.id.btn_minus16 /* 2131427496 */:
                case R.id.btn_minus17 /* 2131427498 */:
                case R.id.btn_plus17 /* 2131427500 */:
                    int d36 = DataCanbus.DATA[320];
                    int d37 = DataCanbus.DATA[321];
                    int d38 = DataCanbus.DATA[322];
                    setCarInfo1(0, d36, d37, d38, 0, 0);
                default:
                    return false;
            }
        }
        return false;
    }

    public void setCarInfo1(int value1, int value2, int value3, int value4, int value5, int value6) {
        DataCanbus.PROXY.cmd(111, new int[]{value1, value2, value3, value4, value5, value6}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(97, new int[]{125, 240}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[320].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[321].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[322].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[323].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[324].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[320].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[321].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[322].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[323].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[324].removeNotify(this.mNotifyCanbus);
    }
}
