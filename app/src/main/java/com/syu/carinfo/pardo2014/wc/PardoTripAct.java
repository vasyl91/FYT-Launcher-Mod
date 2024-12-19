package com.syu.carinfo.pardo2014.wc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.widget.VerticalProgressbar;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.CallbackCanbusBase;
import com.syu.module.canbus.Callback_0121_WC2_14Prado;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.ModuleCallbackCanbusProxy;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PardoTripAct extends BaseActivity {
    private VerticalProgressbar mProgressbarCur;
    private VerticalProgressbar[] mProgressbar = new VerticalProgressbar[30];
    private TextView[] mOilTv = new TextView[4];
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.pardo2014.wc.PardoTripAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    PardoTripAct.this.mUpdaterOilExpend();
                    break;
                case 2:
                    PardoTripAct.this.mUpdaterAveragVelocity();
                    break;
                case 11:
                    if (ints == null) {
                        for (int i = 0; i < 15; i++) {
                            int[] ints2 = Callback_0121_WC2_14Prado.mMinuteoilexpend[i];
                            if (ints2 == null) {
                                ints2 = new int[]{i};
                            }
                            PardoTripAct.this.mUpdaterOilValue(ints2);
                        }
                        break;
                    } else {
                        PardoTripAct.this.mUpdaterOilValue(ints);
                        break;
                    }
                case 12:
                    PardoTripAct.this.mUpdaterOptimalOilExpend();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pardo_trip);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mProgressbar[0] = (VerticalProgressbar) findViewById(R.id.pardo_progressbar_0);
        this.mProgressbar[1] = (VerticalProgressbar) findViewById(R.id.pardo_progressbar_1);
        this.mProgressbar[2] = (VerticalProgressbar) findViewById(R.id.pardo_progressbar_2);
        this.mProgressbar[3] = (VerticalProgressbar) findViewById(R.id.pardo_progressbar_3);
        this.mProgressbar[4] = (VerticalProgressbar) findViewById(R.id.pardo_progressbar_4);
        this.mProgressbar[5] = (VerticalProgressbar) findViewById(R.id.pardo_progressbar_5);
        this.mProgressbar[6] = (VerticalProgressbar) findViewById(R.id.pardo_progressbar_6);
        this.mProgressbar[7] = (VerticalProgressbar) findViewById(R.id.pardo_progressbar_7);
        this.mProgressbar[8] = (VerticalProgressbar) findViewById(R.id.pardo_progressbar_8);
        this.mProgressbar[9] = (VerticalProgressbar) findViewById(R.id.pardo_progressbar_9);
        this.mProgressbar[10] = (VerticalProgressbar) findViewById(R.id.pardo_progressbar_10);
        this.mProgressbar[11] = (VerticalProgressbar) findViewById(R.id.pardo_progressbar_11);
        this.mProgressbar[12] = (VerticalProgressbar) findViewById(R.id.pardo_progressbar_12);
        this.mProgressbar[13] = (VerticalProgressbar) findViewById(R.id.pardo_progressbar_13);
        this.mProgressbar[14] = (VerticalProgressbar) findViewById(R.id.pardo_progressbar_14);
        this.mProgressbarCur = (VerticalProgressbar) findViewById(R.id.pardo_progressbar_cur);
        this.mOilTv[0] = (TextView) findViewById(R.id.pardo_tv_oil_0);
        this.mOilTv[1] = (TextView) findViewById(R.id.pardo_tv_oil_1);
        this.mOilTv[2] = (TextView) findViewById(R.id.pardo_tv_oil_2);
        this.mOilTv[3] = (TextView) findViewById(R.id.pardo_tv_oil_3);
        ((Button) findViewById(R.id.pardo_btn_clear)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.pardo2014.wc.PardoTripAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(13, null, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        CallbackCanbusBase callback = ModuleCallbackCanbusProxy.getInstance().getCallbackCanbus();
        if (!(callback instanceof Callback_0121_WC2_14Prado)) {
            finish();
        } else {
            addNotify();
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilExpend() {
        int value = DataCanbus.DATA[0];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        int numMax = 30;
        if (num != 65535) {
            if (unit == 0) {
                numMax = 60;
                if (((TextView) findViewById(R.id.pardo_tv_oil_unit)) != null) {
                    ((TextView) findViewById(R.id.pardo_tv_oil_unit)).setText("MPG");
                }
                for (int i = 0; i < 4; i++) {
                    if (this.mOilTv[i] != null) {
                        this.mOilTv[i].setText(new StringBuilder().append(PardoData.mOilNum1[i]).toString());
                    }
                }
            } else if (unit == 1) {
                numMax = 30;
                if (((TextView) findViewById(R.id.pardo_tv_oil_unit)) != null) {
                    ((TextView) findViewById(R.id.pardo_tv_oil_unit)).setText("km/L");
                }
                for (int i2 = 0; i2 < 4; i2++) {
                    if (this.mOilTv[i2] != null) {
                        this.mOilTv[i2].setText(new StringBuilder().append(PardoData.mOilNum0[i2]).toString());
                    }
                }
            } else if (unit == 2) {
                numMax = 30;
                if (((TextView) findViewById(R.id.pardo_tv_oil_unit)) != null) {
                    ((TextView) findViewById(R.id.pardo_tv_oil_unit)).setText("L/100km");
                }
                for (int i3 = 0; i3 < 4; i3++) {
                    if (this.mOilTv[i3] != null) {
                        this.mOilTv[i3].setText(new StringBuilder().append(PardoData.mOilNum0[i3]).toString());
                    }
                }
            }
            if (this.mProgressbarCur != null) {
                this.mProgressbarCur.setMax(numMax * 10);
                if (num < 0) {
                    num = 0;
                } else if (num > numMax * 10) {
                    num = numMax * 10;
                }
                this.mProgressbarCur.setProgress(num);
                this.mProgressbarCur.invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOptimalOilExpend() {
        int value = DataCanbus.DATA[12];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        String str = "";
        if (num != 65535) {
            if (unit == 0) {
                str = String.valueOf(num) + " MPG";
            } else if (unit == 1) {
                str = String.valueOf(num) + " km/L";
            } else if (unit == 2) {
                str = String.valueOf(num) + " L/100km";
            }
            if (((TextView) findViewById(R.id.pardo_tv_optimal_oil_expend)) != null) {
                ((TextView) findViewById(R.id.pardo_tv_optimal_oil_expend)).setText(str);
                return;
            }
            return;
        }
        if (((TextView) findViewById(R.id.pardo_tv_optimal_oil_expend)) != null) {
            ((TextView) findViewById(R.id.pardo_tv_optimal_oil_expend)).setText("--.-");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAveragVelocity() {
        int value = DataCanbus.DATA[2];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        String str = "";
        if (unit == 0) {
            str = String.valueOf(String.format("%d", Integer.valueOf(num))) + " km/h";
        } else if (unit == 1) {
            str = String.valueOf(String.format("%d", Integer.valueOf(num))) + " mile/h";
        } else if (unit == 2) {
            str = String.valueOf(String.format("%d", Integer.valueOf(num))) + " ";
        }
        if (((TextView) findViewById(R.id.pardo_tv_average_velocity)) != null) {
            ((TextView) findViewById(R.id.pardo_tv_average_velocity)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilValue(int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 15) {
            int index = ints[0];
            int value = ints[1];
            int unit = (value >> 24) & 255;
            int num = value & 16777215;
            int numMax = 30;
            if (num != 65535) {
                if (unit == 0) {
                    numMax = 60;
                    if (((TextView) findViewById(R.id.pardo_tv_oil_unit)) != null) {
                        ((TextView) findViewById(R.id.pardo_tv_oil_unit)).setText("MPG");
                    }
                    for (int i = 0; i < 4; i++) {
                        if (this.mOilTv[i] != null) {
                            this.mOilTv[i].setText(new StringBuilder().append(PardoData.mOilNum1[i]).toString());
                        }
                    }
                } else if (unit == 1) {
                    numMax = 30;
                    if (((TextView) findViewById(R.id.pardo_tv_oil_unit)) != null) {
                        ((TextView) findViewById(R.id.pardo_tv_oil_unit)).setText("km/L");
                    }
                    for (int i2 = 0; i2 < 4; i2++) {
                        if (this.mOilTv[i2] != null) {
                            this.mOilTv[i2].setText(new StringBuilder().append(PardoData.mOilNum0[i2]).toString());
                        }
                    }
                } else if (unit == 2) {
                    numMax = 30;
                    if (((TextView) findViewById(R.id.pardo_tv_oil_unit)) != null) {
                        ((TextView) findViewById(R.id.pardo_tv_oil_unit)).setText("L/100km");
                    }
                    for (int i3 = 0; i3 < 4; i3++) {
                        if (this.mOilTv[i3] != null) {
                            this.mOilTv[i3].setText(new StringBuilder().append(PardoData.mOilNum0[i3]).toString());
                        }
                    }
                }
                if (this.mProgressbar[index] != null) {
                    this.mProgressbar[index].setMax(numMax * 10);
                    if (num < 0) {
                        num = 0;
                    } else if (num > numMax * 10) {
                        num = numMax * 10;
                    }
                    this.mProgressbar[index].setProgress(num);
                    this.mProgressbar[index].invalidate();
                    return;
                }
                return;
            }
            this.mProgressbar[index].setProgress(0);
            this.mProgressbar[index].invalidate();
        }
    }
}
