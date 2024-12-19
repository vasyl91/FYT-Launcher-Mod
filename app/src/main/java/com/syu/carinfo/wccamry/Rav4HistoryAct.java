package com.syu.carinfo.wccamry;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Rav4HistoryAct extends BaseActivity {
    private Button mBtnDelete;
    private Button mBtnGo2Minute;
    private Button mBtnUpdate;
    private VerticalProgressbar mProgressbarHisCur;
    private TextView mTvAverageOil;
    private TextView mTvOptimalOil;
    private TextView mTvUnit;
    private TextView[] mTvHisOil = new TextView[4];
    private VerticalProgressbar[] mProgressbarHis = new VerticalProgressbar[5];
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wccamry.Rav4HistoryAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    Rav4HistoryAct.this.mUpdaterAverageOilExpend();
                    break;
                case 17:
                    Rav4HistoryAct.this.mUpdaterCurTripOilExpend();
                    break;
                case 18:
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
                case 20:
                    Rav4HistoryAct.this.mUpdaterOptimalOilExpend();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rav4_history);
        init();
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

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
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

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mTvOptimalOil = (TextView) findViewById(R.id.rav4_tv_best_oil);
        this.mTvAverageOil = (TextView) findViewById(R.id.rav4_tv_average_oil);
        this.mTvUnit = (TextView) findViewById(R.id.rav4_tv_trip_unit);
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
        this.mBtnGo2Minute = (Button) findViewById(R.id.rav4_btn_go2_minute_oil);
        this.mBtnUpdate = (Button) findViewById(R.id.rav4_btn_update);
        this.mBtnDelete = (Button) findViewById(R.id.rav4_btn_delete);
        this.mBtnGo2Minute.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4HistoryAct.2
            @Override // android.view.View.OnClickListener
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
        this.mBtnUpdate.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4HistoryAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(15, null, null, null);
            }
        });
        this.mBtnDelete.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4HistoryAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, null, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOptimalOilExpend() {
        int value = DataCanbus.DATA[20];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        String str = "";
        if (num != 65535) {
            if (unit == 0) {
                str = String.valueOf(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10))) + " MPG";
            } else if (unit == 1) {
                str = String.valueOf(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10))) + " km/L";
            } else if (unit == 2) {
                str = String.valueOf(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10))) + " L/100km";
            }
            if (this.mTvOptimalOil != null) {
                this.mTvOptimalOil.setText(str);
                return;
            }
            return;
        }
        if (this.mTvOptimalOil != null) {
            this.mTvOptimalOil.setText("--.--");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAverageOilExpend() {
        int value = DataCanbus.DATA[0];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        String str = "";
        if (unit == 0) {
            str = String.valueOf(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10))) + " MPG";
        } else if (unit == 1) {
            str = String.valueOf(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10))) + " km/L";
        } else if (unit == 2) {
            str = String.valueOf(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10))) + " L/100km";
        }
        if (this.mTvAverageOil != null) {
            this.mTvAverageOil.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCurTripOilExpend() {
        int value = DataCanbus.DATA[17];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        int numMax = 30;
        if (num != 65535) {
            if (unit == 0) {
                numMax = 60;
                if (this.mTvUnit != null) {
                    this.mTvUnit.setText("MPG");
                }
                for (int i = 0; i < 4; i++) {
                    if (this.mTvHisOil != null) {
                        this.mTvHisOil[i].setText(new StringBuilder().append(Rav4Data.mOilNum1[i]).toString());
                    }
                }
            } else if (unit == 1) {
                numMax = 30;
                if (this.mTvUnit != null) {
                    this.mTvUnit.setText("km/L");
                }
                for (int i2 = 0; i2 < 4; i2++) {
                    if (this.mTvHisOil[i2] != null) {
                        this.mTvHisOil[i2].setText(new StringBuilder().append(Rav4Data.mOilNum0[i2]).toString());
                    }
                }
            } else if (unit == 2) {
                numMax = 30;
                if (this.mTvUnit != null) {
                    this.mTvUnit.setText("L/100km");
                }
                for (int i3 = 0; i3 < 4; i3++) {
                    if (this.mTvHisOil[i3] != null) {
                        this.mTvHisOil[i3].setText(new StringBuilder().append(Rav4Data.mOilNum0[i3]).toString());
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

    /* JADX INFO: Access modifiers changed from: private */
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
