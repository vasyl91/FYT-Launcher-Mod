package com.syu.carinfo.dj.huangguan;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.carinfo.camry2012.xp.VerticalProgressbar;
import com.syu.carinfo.wccamry.ConstWcToyota;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XCLexusHistoryAct extends BaseActivity {
    public static XCLexusHistoryAct mInit;
    private TextView[] mTvHisOil = new TextView[4];
    private VerticalProgressbar[] mProgressbarHis = new VerticalProgressbar[5];
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dj.huangguan.XCLexusHistoryAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 85:
                    XCLexusHistoryAct.this.mUpdaterDrivingTime();
                    break;
                case 87:
                    XCLexusHistoryAct.this.mUpdaterAverageOilExpend();
                    break;
                case 88:
                    XCLexusHistoryAct.this.mUpdaterCurTripOilExpend();
                    break;
                case 89:
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_camry_history);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        mInit = this;
        this.mTvHisOil[0] = (TextView) findViewById(R.id.camry_tv_his_oil_0);
        this.mTvHisOil[1] = (TextView) findViewById(R.id.camry_tv_his_oil_1);
        this.mTvHisOil[2] = (TextView) findViewById(R.id.camry_tv_his_oil_2);
        this.mTvHisOil[3] = (TextView) findViewById(R.id.camry_tv_his_oil_3);
        this.mProgressbarHis[0] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_trip_0);
        this.mProgressbarHis[1] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_trip_1);
        this.mProgressbarHis[2] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_trip_2);
        this.mProgressbarHis[3] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_trip_3);
        this.mProgressbarHis[4] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_trip_4);
        findViewById(R.id.camry_btn_update).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.huangguan.XCLexusHistoryAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(5, new int[]{8}, null, null);
            }
        });
        findViewById(R.id.camry_btn_delete).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.huangguan.XCLexusHistoryAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(5, new int[]{9}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[85].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[85].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingTime() {
        int time = DataCanbus.DATA[85];
        if (time > -1) {
            int hour = time / 60;
            int minute = time % 60;
            StringBuffer sb = new StringBuffer();
            if (hour == 1) {
                sb.append(String.valueOf(String.format("%02d", Integer.valueOf(hour))) + LauncherApplication.getInstance().getResources().getString(R.string.time_hour));
            } else {
                sb.append(String.valueOf(String.format("%02d", Integer.valueOf(hour))) + LauncherApplication.getInstance().getResources().getString(R.string.time_hours));
            }
            if (minute == 1) {
                sb.append(String.valueOf(String.format("%02d", Integer.valueOf(minute))) + LauncherApplication.getInstance().getResources().getString(R.string.time_minute));
            } else {
                sb.append(String.valueOf(String.format("%02d", Integer.valueOf(minute))) + LauncherApplication.getInstance().getResources().getString(R.string.time_minutes));
            }
            if (((TextView) findViewById(R.id.camry_tv_driving_time)) != null) {
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11 /* 5177797 */:
                    case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_18 /* 5243333 */:
                    case FinalCanbus.CAR_LUZ_Toyato_All /* 7274935 */:
                    case FinalCanbus.CAR_LUZ_Toyato_All_H /* 7340471 */:
                    case FinalCanbus.CAR_LUZ_Toyato_20All /* 8126903 */:
                    case FinalCanbus.CAR_LUZ_Toyato_30All /* 8192439 */:
                    case FinalCanbus.CAR_452_LZ_Toyato_RX450 /* 12648900 */:
                    case FinalCanbus.CAR_452_LZ_Toyato_RX270 /* 12714436 */:
                        ((TextView) findViewById(R.id.camry_tv_driving_time)).setText("--.--");
                        break;
                    default:
                        ((TextView) findViewById(R.id.camry_tv_driving_time)).setText(sb.toString());
                        break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAverageOilExpend() {
        int value = DataCanbus.DATA[87];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        String str = "";
        if (num != 65535) {
            if (unit == 0) {
                str = String.valueOf(String.format("%02d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10))) + " MPG";
            } else if (unit == 1) {
                str = String.valueOf(String.format("%02d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10))) + " km/L";
            } else if (unit == 2) {
                str = String.valueOf(String.format("%02d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10))) + " L/100km";
            }
            if (((TextView) findViewById(R.id.camry_tv_average_oil)) != null) {
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11 /* 5177797 */:
                    case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_18 /* 5243333 */:
                    case FinalCanbus.CAR_LUZ_Toyato_All /* 7274935 */:
                    case FinalCanbus.CAR_LUZ_Toyato_All_H /* 7340471 */:
                    case FinalCanbus.CAR_LUZ_Toyato_20All /* 8126903 */:
                    case FinalCanbus.CAR_LUZ_Toyato_30All /* 8192439 */:
                    case FinalCanbus.CAR_452_LZ_Toyato_RX450 /* 12648900 */:
                    case FinalCanbus.CAR_452_LZ_Toyato_RX270 /* 12714436 */:
                        ((TextView) findViewById(R.id.camry_tv_average_oil)).setText("--.--");
                        break;
                    default:
                        ((TextView) findViewById(R.id.camry_tv_average_oil)).setText(str);
                        break;
                }
                return;
            }
            return;
        }
        ((TextView) findViewById(R.id.camry_tv_average_oil)).setText("--.--");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCurTripOilExpend() {
        int value = DataCanbus.DATA[88];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        int numMax = 30;
        if (num != 65535) {
            if (unit == 0) {
                numMax = 60;
                if (((TextView) findViewById(R.id.camry_tv_trip_unit)) != null) {
                    ((TextView) findViewById(R.id.camry_tv_trip_unit)).setText("MPG");
                }
                for (int i = 0; i < 4; i++) {
                    if (this.mTvHisOil != null) {
                        this.mTvHisOil[i].setText(new StringBuilder().append(CamryData.mOilNum1[i]).toString());
                    }
                }
            } else if (unit == 1) {
                numMax = 30;
                if (((TextView) findViewById(R.id.camry_tv_trip_unit)) != null) {
                    ((TextView) findViewById(R.id.camry_tv_trip_unit)).setText("km/L");
                }
                for (int i2 = 0; i2 < 4; i2++) {
                    if (this.mTvHisOil[i2] != null) {
                        this.mTvHisOil[i2].setText(new StringBuilder().append(CamryData.mOilNum0[i2]).toString());
                    }
                }
            } else if (unit == 2) {
                numMax = 30;
                if (((TextView) findViewById(R.id.camry_tv_trip_unit)) != null) {
                    ((TextView) findViewById(R.id.camry_tv_trip_unit)).setText("L/100km");
                }
                for (int i3 = 0; i3 < 4; i3++) {
                    if (mInit.mTvHisOil[i3] != null) {
                        this.mTvHisOil[i3].setText(new StringBuilder().append(CamryData.mOilNum0[i3]).toString());
                    }
                }
            }
            if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_trip_current)) != null) {
                ((VerticalProgressbar) findViewById(R.id.camry_progressbar_trip_current)).setMax(numMax * 10);
                if (num < 0) {
                    num = 0;
                } else if (num > numMax * 10) {
                    num = numMax * 10;
                }
                ((VerticalProgressbar) findViewById(R.id.camry_progressbar_trip_current)).setProgress(num);
                ((VerticalProgressbar) findViewById(R.id.camry_progressbar_trip_current)).invalidate();
                return;
            }
            return;
        }
        ((VerticalProgressbar) findViewById(R.id.camry_progressbar_trip_current)).setProgress(0);
        ((VerticalProgressbar) findViewById(R.id.camry_progressbar_trip_current)).invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
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
