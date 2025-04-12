package com.syu.carinfo.dj.huangguan;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.carinfo.camry2012.xp.VerticalProgressbar;
import com.syu.carinfo.wccamry.ConstWcToyota;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class XCLexusHistoryAct extends BaseActivity {
    public static XCLexusHistoryAct mInit;
    private final TextView[] mTvHisOil = new TextView[4];
    private final VerticalProgressbar[] mProgressbarHis = new VerticalProgressbar[5];
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 126:
                    XCLexusHistoryAct.this.mUpdaterDrivingTime();
                    break;
                case 128:
                    XCLexusHistoryAct.this.mUpdaterAverageOilExpend();
                    break;
                case 129:
                    XCLexusHistoryAct.this.mUpdaterCurTripOilExpend();
                    break;
                case 130:
                    if (ints == null) {
                        for (int i = 0; i < 5; i++) {
                            int[] ints2 = ConstWcToyota.mTripoilexpend[i];
                            if (ints2 == null) {
                                ints2 = new int[]{i};
                            }
                            XCLexusHistoryAct.this.mUpdaterTripOilValue(ints2);
                        }
                        break;
                    } else {
                        XCLexusHistoryAct.this.mUpdaterTripOilValue(ints);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_camry_history);
        init();
    }

    @Override
    public void init() {
        mInit = this;
        this.mTvHisOil[0] = findViewById(R.id.camry_tv_his_oil_0);
        this.mTvHisOil[1] = findViewById(R.id.camry_tv_his_oil_1);
        this.mTvHisOil[2] = findViewById(R.id.camry_tv_his_oil_2);
        this.mTvHisOil[3] = findViewById(R.id.camry_tv_his_oil_3);
        this.mProgressbarHis[0] = findViewById(R.id.camry_progressbar_trip_0);
        this.mProgressbarHis[1] = findViewById(R.id.camry_progressbar_trip_1);
        this.mProgressbarHis[2] = findViewById(R.id.camry_progressbar_trip_2);
        this.mProgressbarHis[3] = findViewById(R.id.camry_progressbar_trip_3);
        this.mProgressbarHis[4] = findViewById(R.id.camry_progressbar_trip_4);
        findViewById(R.id.camry_btn_update).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(5, new int[]{8}, null, null);
            }
        });
        findViewById(R.id.camry_btn_delete).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(5, new int[]{9}, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterDrivingTime() {
        int time = DataCanbus.DATA[126];
        if (time > -1) {
            int hour = time / 60;
            int minute = time % 60;
            StringBuffer sb = new StringBuffer();
            if (hour == 1) {
                sb.append(String.format("%02d", Integer.valueOf(hour)) + LauncherApplication.getInstance().getResources().getString(R.string.time_hour));
            } else {
                sb.append(String.format("%02d", Integer.valueOf(hour)) + LauncherApplication.getInstance().getResources().getString(R.string.time_hours));
            }
            if (minute == 1) {
                sb.append(String.format("%02d", Integer.valueOf(minute)) + LauncherApplication.getInstance().getResources().getString(R.string.time_minute));
            } else {
                sb.append(String.format("%02d", Integer.valueOf(minute)) + LauncherApplication.getInstance().getResources().getString(R.string.time_minutes));
            }
            if (findViewById(R.id.camry_tv_driving_time) != null) {
                ((TextView) findViewById(R.id.camry_tv_driving_time)).setText(sb.toString());
            }
        }
    }

    
    public void mUpdaterAverageOilExpend() {
        int value = DataCanbus.DATA[128];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        String str = "";
        if (num != 65535) {
            if (unit == 0) {
                str = String.format("%02d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10)) + " MPG";
            } else if (unit == 1) {
                str = String.format("%02d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10)) + " km/L";
            } else if (unit == 2) {
                str = String.format("%02d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10)) + " L/100km";
            }
            if (findViewById(R.id.camry_tv_average_oil) != null) {
                ((TextView) findViewById(R.id.camry_tv_average_oil)).setText(str);
                return;
            }
            return;
        }
        ((TextView) findViewById(R.id.camry_tv_average_oil)).setText("--.--");
    }

    
    public void mUpdaterCurTripOilExpend() {
        int value = DataCanbus.DATA[129];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        int numMax = 30;
        if (num != 65535) {
            if (unit == 0) {
                numMax = 60;
                if (findViewById(R.id.camry_tv_trip_unit) != null) {
                    ((TextView) findViewById(R.id.camry_tv_trip_unit)).setText(CamryData.OIL_EXPEND_UNIT_MPG);
                }
                for (int i = 0; i < 4; i++) {
                    if (this.mTvHisOil != null) {
                        this.mTvHisOil[i].setText(String.valueOf(CamryData.mOilNum1[i]));
                    }
                }
            } else if (unit == 1) {
                numMax = 30;
                if (findViewById(R.id.camry_tv_trip_unit) != null) {
                    ((TextView) findViewById(R.id.camry_tv_trip_unit)).setText(CamryData.OIL_EXPEND_UNIT_KM_PER_L);
                }
                for (int i2 = 0; i2 < 4; i2++) {
                    if (this.mTvHisOil[i2] != null) {
                        this.mTvHisOil[i2].setText(String.valueOf(CamryData.mOilNum0[i2]));
                    }
                }
            } else if (unit == 2) {
                numMax = 30;
                if (findViewById(R.id.camry_tv_trip_unit) != null) {
                    ((TextView) findViewById(R.id.camry_tv_trip_unit)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                }
                for (int i3 = 0; i3 < 4; i3++) {
                    if (mInit.mTvHisOil[i3] != null) {
                        this.mTvHisOil[i3].setText(String.valueOf(CamryData.mOilNum0[i3]));
                    }
                }
            }
            if (findViewById(R.id.camry_progressbar_trip_current) != null) {
                ((VerticalProgressbar) findViewById(R.id.camry_progressbar_trip_current)).setMax(numMax * 10);
                if (num < 0) {
                    num = 0;
                } else if (num > numMax * 10) {
                    num = numMax * 10;
                }
                ((VerticalProgressbar) findViewById(R.id.camry_progressbar_trip_current)).setProgress(num);
                findViewById(R.id.camry_progressbar_trip_current).invalidate();
                return;
            }
            return;
        }
        ((VerticalProgressbar) findViewById(R.id.camry_progressbar_trip_current)).setProgress(0);
        findViewById(R.id.camry_progressbar_trip_current).invalidate();
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
