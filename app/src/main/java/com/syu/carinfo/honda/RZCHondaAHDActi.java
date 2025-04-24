package com.syu.carinfo.honda;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RZCHondaAHDActi extends BaseActivity implements View.OnTouchListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
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
                case 322:
                    switch (value) {
                        case 6:
                            ((TextView) RZCHondaAHDActi.this.findViewById(R.id.tv_text15)).setText("1280x720@30Hz");
                            break;
                        case 7:
                            ((TextView) RZCHondaAHDActi.this.findViewById(R.id.tv_text15)).setText("1280x720@25Hz");
                            break;
                    }
                case 323:
                    if ((value & 128) != 0) {
                        ((TextView) RZCHondaAHDActi.this.findViewById(R.id.tv_text16)).setText("-" + (256 - value));
                        break;
                    } else {
                        ((TextView) RZCHondaAHDActi.this.findViewById(R.id.tv_text16)).setText("+" + value);
                        break;
                    }
                case 324:
                    if ((value & 128) != 0) {
                        ((TextView) RZCHondaAHDActi.this.findViewById(R.id.tv_text17)).setText("-" + (256 - value));
                        break;
                    } else {
                        ((TextView) RZCHondaAHDActi.this.findViewById(R.id.tv_text17)).setText("+" + value);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_jeep_rzc_ahd_settings);
        init();
    }

    @Override
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
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.btn_minus13 /* 2131427491 */:
                    int d2 = DataCanbus.DATA[320];
                    int d3 = DataCanbus.DATA[321];
                    int d4 = DataCanbus.DATA[322];
                    if (d2 > 0) {
                        d2--;
                    }
                    setCarInfo1(0, d2, d3, d4, 0, 0);
                case R.id.btn_plus13 /* 2131427493 */:
                    int d22 = DataCanbus.DATA[320];
                    int d32 = DataCanbus.DATA[321];
                    int d42 = DataCanbus.DATA[322];
                    if (d22 < 5) {
                        d22++;
                    }
                    setCarInfo1(0, d22, d32, d42, 0, 0);
                case R.id.btn_minus14 /* 2131427494 */:
                    int d23 = DataCanbus.DATA[320];
                    int d33 = DataCanbus.DATA[321];
                    int d43 = DataCanbus.DATA[322];
                    int d34 = d33 - 1;
                    if (d34 < 1) {
                        d34 = 2;
                    }
                    setCarInfo1(0, d23, d34, d43, 0, 0);
                case R.id.btn_plus14 /* 2131427496 */:
                    int d24 = DataCanbus.DATA[320];
                    int d35 = DataCanbus.DATA[321];
                    int d44 = DataCanbus.DATA[322];
                    int d36 = d35 + 1;
                    if (d36 > 2) {
                        d36 = 1;
                    }
                    setCarInfo1(0, d24, d36, d44, 0, 0);
                case R.id.btn_minus15 /* 2131427515 */:
                    int d25 = DataCanbus.DATA[320];
                    int d37 = DataCanbus.DATA[321];
                    int d45 = DataCanbus.DATA[322];
                    int d46 = d45 - 1;
                    if (d46 < 6) {
                        d46 = 7;
                    }
                    setCarInfo1(0, d25, d37, d46, 0, 0);
                case R.id.btn_plus15 /* 2131427517 */:
                    int d26 = DataCanbus.DATA[320];
                    int d38 = DataCanbus.DATA[321];
                    int d47 = DataCanbus.DATA[322];
                    int d48 = d47 + 1;
                    if (d48 > 7) {
                        d48 = 6;
                    }
                    setCarInfo1(0, d26, d38, d48, 0, 0);
                case R.id.btn_minus16 /* 2131427518 */:
                    int d27 = DataCanbus.DATA[320];
                    int d39 = DataCanbus.DATA[321];
                    int d49 = DataCanbus.DATA[322];
                    setCarInfo1(0, d27, d39, d49, 1, 0);
                case R.id.btn_plus16 /* 2131427520 */:
                    int d28 = DataCanbus.DATA[320];
                    int d310 = DataCanbus.DATA[321];
                    int d410 = DataCanbus.DATA[322];
                    setCarInfo1(0, d28, d310, d410, 2, 0);
                case R.id.btn_minus17 /* 2131427521 */:
                    int d29 = DataCanbus.DATA[320];
                    int d311 = DataCanbus.DATA[321];
                    int d411 = DataCanbus.DATA[322];
                    setCarInfo1(0, d29, d311, d411, 0, 1);
                case R.id.btn_plus17 /* 2131427523 */:
                    int d210 = DataCanbus.DATA[320];
                    int d312 = DataCanbus.DATA[321];
                    int d412 = DataCanbus.DATA[322];
                    setCarInfo1(0, d210, d312, d412, 0, 2);
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.btn_minus16 /* 2131427518 */:
                case R.id.btn_plus16 /* 2131427520 */:
                case R.id.btn_minus17 /* 2131427521 */:
                case R.id.btn_plus17 /* 2131427523 */:
                    int d211 = DataCanbus.DATA[320];
                    int d313 = DataCanbus.DATA[321];
                    int d413 = DataCanbus.DATA[322];
                    setCarInfo1(0, d211, d313, d413, 0, 0);
                case R.id.tv_text16 /* 2131427519 */:
                case R.id.tv_text17 /* 2131427522 */:
                default:
                    return false;
            }
        }
        return false;
    }

    public void setCarInfo1(int value1, int value2, int value3, int value4, int value5, int value6) {
        DataCanbus.PROXY.cmd(111, new int[]{value1, value2, value3, value4, value5, value6}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[320].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[321].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[322].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[323].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[324].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[320].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[321].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[322].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[323].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[324].removeNotify(this.mNotifyCanbus);
    }
}
