package com.syu.carinfo.camry.zh;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class CamryHistoryAct_ZH extends BaseActivity {
    public static CamryHistoryAct_ZH mInit;
    private TextView[] mTvHisOil = new TextView[4];
    private VerticalProgressbar_ZH[] mProgressbarHis = new VerticalProgressbar_ZH[5];
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 105:
                    CamryHistoryAct_ZH.this.mUpdaterCurTripOilExpend();
                    break;
                case 106:
                    if (ints == null) {
                        for (int i = 0; i < 5; i++) {
                        }
                        break;
                    } else {
                        CamryHistoryAct_ZH.this.mUpdaterTripOilValue(ints);
                        break;
                    }
            }
        }
    };
    int[] mOilNum0 = {0, 10, 20, 30};
    int[] mOilNum1 = {0, 20, 40, 60};
    int[] mTripoilexpend = new int[5];
    int avgtrip = 0;
    int besttrip = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_camry_history_zh);
        init();
    }

    @Override
    public void init() {
        mInit = this;
        this.mTvHisOil[0] = (TextView) findViewById(R.id.camry_tv_his_oil_0);
        this.mTvHisOil[1] = (TextView) findViewById(R.id.camry_tv_his_oil_1);
        this.mTvHisOil[2] = (TextView) findViewById(R.id.camry_tv_his_oil_2);
        this.mTvHisOil[3] = (TextView) findViewById(R.id.camry_tv_his_oil_3);
        this.mProgressbarHis[0] = (VerticalProgressbar_ZH) findViewById(R.id.camry_progressbar_trip_0);
        this.mProgressbarHis[1] = (VerticalProgressbar_ZH) findViewById(R.id.camry_progressbar_trip_1);
        this.mProgressbarHis[2] = (VerticalProgressbar_ZH) findViewById(R.id.camry_progressbar_trip_2);
        this.mProgressbarHis[3] = (VerticalProgressbar_ZH) findViewById(R.id.camry_progressbar_trip_3);
        this.mProgressbarHis[4] = (VerticalProgressbar_ZH) findViewById(R.id.camry_progressbar_trip_4);
        findViewById(R.id.camry_btn_update).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(8, null, null, null);
            }
        });
        findViewById(R.id.camry_btn_delete).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(9, null, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterCurTripOilExpend() {
        int value = DataCanbus.DATA[105];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        int numMax = 30;
        if (num != 65535) {
            if (unit == 0) {
                numMax = 60;
                if (((TextView) findViewById(R.id.camry_tv_trip_unit)) != null) {
                    ((TextView) findViewById(R.id.camry_tv_trip_unit)).setText(CamryData.OIL_EXPEND_UNIT_MPG);
                }
                for (int i = 0; i < 4; i++) {
                    if (this.mTvHisOil != null) {
                        this.mTvHisOil[i].setText(new StringBuilder().append(this.mOilNum1[i]).toString());
                    }
                }
            } else if (unit == 1) {
                numMax = 30;
                if (((TextView) findViewById(R.id.camry_tv_trip_unit)) != null) {
                    ((TextView) findViewById(R.id.camry_tv_trip_unit)).setText(CamryData.OIL_EXPEND_UNIT_KM_PER_L);
                }
                for (int i2 = 0; i2 < 4; i2++) {
                    if (this.mTvHisOil[i2] != null) {
                        this.mTvHisOil[i2].setText(new StringBuilder().append(this.mOilNum0[i2]).toString());
                    }
                }
            } else if (unit == 2) {
                numMax = 30;
                if (((TextView) findViewById(R.id.camry_tv_trip_unit)) != null) {
                    ((TextView) findViewById(R.id.camry_tv_trip_unit)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                }
                for (int i3 = 0; i3 < 4; i3++) {
                    if (mInit.mTvHisOil[i3] != null) {
                        this.mTvHisOil[i3].setText(new StringBuilder().append(this.mOilNum0[i3]).toString());
                    }
                }
            }
            if (((VerticalProgressbar_ZH) findViewById(R.id.camry_progressbar_trip_current)) != null) {
                ((VerticalProgressbar_ZH) findViewById(R.id.camry_progressbar_trip_current)).setMax(numMax * 10);
                if (num < 0) {
                    num = 0;
                } else if (num > numMax * 10) {
                    num = numMax * 10;
                }
                ((VerticalProgressbar_ZH) findViewById(R.id.camry_progressbar_trip_current)).setProgress(num);
                ((VerticalProgressbar_ZH) findViewById(R.id.camry_progressbar_trip_current)).invalidate();
                return;
            }
            return;
        }
        ((VerticalProgressbar_ZH) findViewById(R.id.camry_progressbar_trip_current)).setProgress(0);
        ((VerticalProgressbar_ZH) findViewById(R.id.camry_progressbar_trip_current)).invalidate();
    }

    
    public void mUpdaterTripOilValue(int[] ints) {
        if (ints[0] > -1 && ints[0] < 5) {
            int value = ints[1];
            int unit = (value >> 24) & 255;
            int num = value & 16777215;
            int numMax = 30;
            if (num != 65535) {
                if (unit == 0) {
                    numMax = 60;
                } else if (unit == 1) {
                    numMax = 30;
                } else if (unit == 2) {
                    numMax = 30;
                }
                if (ints[0] == 0) {
                    this.mTripoilexpend[ints[0]] = num;
                } else if (ints[0] == 1) {
                    this.mTripoilexpend[ints[0]] = num;
                } else if (ints[0] == 2) {
                    this.mTripoilexpend[ints[0]] = num;
                } else if (ints[0] == 3) {
                    this.mTripoilexpend[ints[0]] = num;
                } else if (ints[0] == 4) {
                    this.mTripoilexpend[ints[0]] = num;
                }
                this.avgtrip = 0;
                this.besttrip = this.mTripoilexpend[0];
                for (int i = 0; i < 5; i++) {
                    this.avgtrip += this.mTripoilexpend[i];
                    if (this.besttrip >= this.mTripoilexpend[i]) {
                        this.besttrip = this.mTripoilexpend[i];
                    }
                }
                this.avgtrip /= 5;
                ((TextView) findViewById(R.id.tv_text1)).setText(":  " + (this.besttrip / 10.0f));
                ((TextView) findViewById(R.id.camry_tv_average_oil)).setText(":  " + (this.avgtrip / 10.0f));
                if (this.mProgressbarHis[ints[0]] != null) {
                    this.mProgressbarHis[ints[0]].setMax(numMax * 10);
                    if (num < 0) {
                        num = 0;
                    } else if (num > numMax * 10) {
                        num = numMax * 10;
                    }
                    this.mProgressbarHis[ints[0]].setProgress(num);
                    this.mProgressbarHis[ints[0]].invalidate();
                    return;
                }
                return;
            }
            this.mProgressbarHis[ints[0]].setProgress(0);
            this.mProgressbarHis[ints[0]].invalidate();
        }
    }
}
