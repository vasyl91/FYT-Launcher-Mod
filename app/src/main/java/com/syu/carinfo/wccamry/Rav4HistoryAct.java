package com.syu.carinfo.wccamry;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Rav4HistoryAct extends BaseActivity {
    private VerticalProgressbar mProgressbarHisCur;
    private TextView[] mTvHisOil = new TextView[4];
    private VerticalProgressbar[] mProgressbarHis = new VerticalProgressbar[5];
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 115:
                    Rav4HistoryAct.this.mUpdaterCurTripOilExpend();
                    Rav4HistoryAct.this.mUpdaterAverageOilExpend();
                    break;
                case 116:
                    if (ints == null) {
                        for (int i = 0; i < 5; i++) {
                            int[] ints2 = ConstWcToyota.mTripoilexpend[i];
                            if (ints2 == null) {
                                ints2 = new int[]{i};
                            }
                            Rav4HistoryAct.this.mUpdaterTripOilValue(ints2);
                        }
                        break;
                    } else {
                        Rav4HistoryAct.this.mUpdaterTripOilValue(ints);
                        break;
                    }
                case 118:
                    Rav4HistoryAct.this.mUpdaterOptimalOilExpend();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rav4_history);
        init();
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
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            try {
                Intent intent = new Intent();
                intent.setClass(this, Rav4TripAct.class);
                startActivity(intent);
                finish();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
        return true;
    }

    @Override
    public void init() {
        this.mTvHisOil[0] = (TextView) findViewById(R.id.rav4_tv_his_oil_0);
        this.mTvHisOil[1] = (TextView) findViewById(R.id.rav4_tv_his_oil_1);
        this.mTvHisOil[2] = (TextView) findViewById(R.id.rav4_tv_his_oil_2);
        this.mTvHisOil[3] = (TextView) findViewById(R.id.rav4_tv_his_oil_3);
        this.mProgressbarHis[0] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_trip_0);
        this.mProgressbarHis[1] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_trip_1);
        this.mProgressbarHis[2] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_trip_2);
        this.mProgressbarHis[3] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_trip_3);
        this.mProgressbarHis[4] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_trip_4);
        this.mProgressbarHisCur = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_trip_current);
        ((Button) findViewById(R.id.rav4_btn_go2_minute_oil)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Rav4HistoryAct.this, Rav4TripAct.class);
                    Rav4HistoryAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(29, new int[]{4, 4, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.rav4_btn_update)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(15, null, null, null);
            }
        });
        ((Button) findViewById(R.id.rav4_btn_delete)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, null, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterOptimalOilExpend() {
        int value = DataCanbus.DATA[118];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        String str = "";
        if (num != 65535) {
            if (unit == 0) {
                str = String.valueOf(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10))) + " " + CamryData.OIL_EXPEND_UNIT_MPG;
            } else if (unit == 1) {
                str = String.valueOf(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10))) + " " + CamryData.OIL_EXPEND_UNIT_KM_PER_L;
            } else if (unit == 2) {
                str = String.valueOf(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10))) + " " + CamryData.OIL_EXPEND_UNIT_L_PER_100KM;
            }
            if (((TextView) findViewById(R.id.rav4_tv_best_oil)) != null) {
                ((TextView) findViewById(R.id.rav4_tv_best_oil)).setText(str);
                return;
            }
            return;
        }
        if (((TextView) findViewById(R.id.rav4_tv_best_oil)) != null) {
            ((TextView) findViewById(R.id.rav4_tv_best_oil)).setText("--.--");
        }
    }

    
    public void mUpdaterAverageOilExpend() {
        int value = DataCanbus.DATA[115];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        String str = "";
        if (unit == 0) {
            str = String.valueOf(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10))) + " MPG-US";
        } else if (unit == 1) {
            str = String.valueOf(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10))) + " " + CamryData.OIL_EXPEND_UNIT_KM_PER_L;
        } else if (unit == 2) {
            str = String.valueOf(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10))) + " " + CamryData.OIL_EXPEND_UNIT_L_PER_100KM;
        } else if (unit == 3) {
            str = String.valueOf(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10))) + " MPG-UK";
        }
        if (((TextView) findViewById(R.id.rav4_tv_average_oil)) != null) {
            ((TextView) findViewById(R.id.rav4_tv_average_oil)).setText(str);
        }
    }

    
    public void mUpdaterCurTripOilExpend() {
        int value = DataCanbus.DATA[115];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        int numMax = 30;
        if (num != 65535) {
            if (unit == 0) {
                numMax = 60;
                if (((TextView) findViewById(R.id.rav4_tv_trip_unit)) != null) {
                    ((TextView) findViewById(R.id.rav4_tv_trip_unit)).setText("MPG-US");
                }
                for (int i = 0; i < 4; i++) {
                    if (this.mTvHisOil != null) {
                        this.mTvHisOil[i].setText(new StringBuilder().append(Rav4Data.mOilNum1[i]).toString());
                    }
                }
            } else if (unit == 1) {
                numMax = 30;
                if (((TextView) findViewById(R.id.rav4_tv_trip_unit)) != null) {
                    ((TextView) findViewById(R.id.rav4_tv_trip_unit)).setText(CamryData.OIL_EXPEND_UNIT_KM_PER_L);
                }
                for (int i2 = 0; i2 < 4; i2++) {
                    if (this.mTvHisOil[i2] != null) {
                        this.mTvHisOil[i2].setText(new StringBuilder().append(Rav4Data.mOilNum0[i2]).toString());
                    }
                }
            } else if (unit == 2) {
                numMax = 30;
                if (((TextView) findViewById(R.id.rav4_tv_trip_unit)) != null) {
                    ((TextView) findViewById(R.id.rav4_tv_trip_unit)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                }
                for (int i3 = 0; i3 < 4; i3++) {
                    if (this.mTvHisOil[i3] != null) {
                        this.mTvHisOil[i3].setText(new StringBuilder().append(Rav4Data.mOilNum0[i3]).toString());
                    }
                }
            } else if (unit == 3) {
                numMax = 60;
                if (((TextView) findViewById(R.id.rav4_tv_trip_unit)) != null) {
                    ((TextView) findViewById(R.id.rav4_tv_trip_unit)).setText("MPG-UK");
                }
                for (int i4 = 0; i4 < 4; i4++) {
                    if (this.mTvHisOil != null) {
                        this.mTvHisOil[i4].setText(new StringBuilder().append(Rav4Data.mOilNum1[i4]).toString());
                    }
                }
            }
            if (this.mProgressbarHisCur != null) {
                this.mProgressbarHisCur.setMax(numMax * 10);
                if (num < 0) {
                    num = 0;
                } else if (num > numMax * 10) {
                    num = numMax * 10;
                }
                this.mProgressbarHisCur.setProgress(num);
                this.mProgressbarHisCur.invalidate();
                return;
            }
            return;
        }
        this.mProgressbarHisCur.setProgress(0);
        this.mProgressbarHisCur.invalidate();
    }

    
    public void mUpdaterTripOilValue(int[] ints) {
        if (ints == null || ints.length < 2 || ints[0] < 0 || ints[0] >= 5) {
            this.mProgressbarHis[0].setProgress(0);
            this.mProgressbarHis[0].invalidate();
            return;
        }
        int index = ints[0];
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
            if (this.mProgressbarHis[index] != null) {
                this.mProgressbarHis[index].setMax(numMax * 10);
                if (num < 0) {
                    num = 0;
                } else if (num > numMax * 10) {
                    num = numMax * 10;
                }
                this.mProgressbarHis[index].setProgress(num);
                this.mProgressbarHis[index].invalidate();
            }
        }
    }
}
