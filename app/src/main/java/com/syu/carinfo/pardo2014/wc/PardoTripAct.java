package com.syu.carinfo.pardo2014.wc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.carinfo.widget.VerticalProgressbar;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.CallbackCanbusBase;
import com.syu.module.canbus.Callback_0121_WC2_14Prado;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.ModuleCallbackCanbusProxy;

public class PardoTripAct extends BaseActivity {
    private VerticalProgressbar mProgressbarCur;
    private VerticalProgressbar[] mProgressbar = new VerticalProgressbar[30];
    private TextView[] mOilTv = new TextView[4];
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    PardoTripAct.this.mUpdaterOilExpend();
                    break;
                case 100:
                    PardoTripAct.this.mUpdaterAveragVelocity();
                    break;
                case 109:
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
                case 110:
                    PardoTripAct.this.mUpdaterOptimalOilExpend();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_pardo_trip);
        init();
    }

    @Override
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
        ((Button) findViewById(R.id.pardo_btn_clear)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(13, null, null, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        CallbackCanbusBase callback = ModuleCallbackCanbusProxy.getInstance().getCallbackCanbus();
        if (!(callback instanceof Callback_0121_WC2_14Prado)) {
            finish();
        } else {
            addNotify();
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
    }

    
    public void mUpdaterOilExpend() {
        int value = DataCanbus.DATA[98];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        int numMax = 30;
        if (num != 65535) {
            if (unit == 0) {
                numMax = 60;
                if (((TextView) findViewById(R.id.pardo_tv_oil_unit)) != null) {
                    ((TextView) findViewById(R.id.pardo_tv_oil_unit)).setText(CamryData.OIL_EXPEND_UNIT_MPG);
                }
                for (int i = 0; i < 4; i++) {
                    if (this.mOilTv[i] != null) {
                        this.mOilTv[i].setText(new StringBuilder().append(PardoData.mOilNum1[i]).toString());
                    }
                }
            } else if (unit == 1) {
                numMax = 30;
                if (((TextView) findViewById(R.id.pardo_tv_oil_unit)) != null) {
                    ((TextView) findViewById(R.id.pardo_tv_oil_unit)).setText(CamryData.OIL_EXPEND_UNIT_KM_PER_L);
                }
                for (int i2 = 0; i2 < 4; i2++) {
                    if (this.mOilTv[i2] != null) {
                        this.mOilTv[i2].setText(new StringBuilder().append(PardoData.mOilNum0[i2]).toString());
                    }
                }
            } else if (unit == 2) {
                numMax = 30;
                if (((TextView) findViewById(R.id.pardo_tv_oil_unit)) != null) {
                    ((TextView) findViewById(R.id.pardo_tv_oil_unit)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
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

    
    public void mUpdaterOptimalOilExpend() {
        int value = DataCanbus.DATA[110];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        String str = "";
        if (num != 65535) {
            if (unit == 0) {
                str = String.valueOf(num) + " " + CamryData.OIL_EXPEND_UNIT_MPG;
            } else if (unit == 1) {
                str = String.valueOf(num) + " " + CamryData.OIL_EXPEND_UNIT_KM_PER_L;
            } else if (unit == 2) {
                str = String.valueOf(num) + " " + CamryData.OIL_EXPEND_UNIT_L_PER_100KM;
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

    
    public void mUpdaterAveragVelocity() {
        int value = DataCanbus.DATA[100];
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
                        ((TextView) findViewById(R.id.pardo_tv_oil_unit)).setText(CamryData.OIL_EXPEND_UNIT_MPG);
                    }
                    for (int i = 0; i < 4; i++) {
                        if (this.mOilTv[i] != null) {
                            this.mOilTv[i].setText(new StringBuilder().append(PardoData.mOilNum1[i]).toString());
                        }
                    }
                } else if (unit == 1) {
                    numMax = 30;
                    if (((TextView) findViewById(R.id.pardo_tv_oil_unit)) != null) {
                        ((TextView) findViewById(R.id.pardo_tv_oil_unit)).setText(CamryData.OIL_EXPEND_UNIT_KM_PER_L);
                    }
                    for (int i2 = 0; i2 < 4; i2++) {
                        if (this.mOilTv[i2] != null) {
                            this.mOilTv[i2].setText(new StringBuilder().append(PardoData.mOilNum0[i2]).toString());
                        }
                    }
                } else if (unit == 2) {
                    numMax = 30;
                    if (((TextView) findViewById(R.id.pardo_tv_oil_unit)) != null) {
                        ((TextView) findViewById(R.id.pardo_tv_oil_unit)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
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
