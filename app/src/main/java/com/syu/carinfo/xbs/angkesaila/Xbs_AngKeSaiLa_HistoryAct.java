package com.syu.carinfo.xbs.angkesaila;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.wccamry.ConstWcToyota;
import com.syu.carinfo.wccamry.Rav4Data;
import com.syu.carinfo.wccamry.VerticalProgressbar;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Xbs_AngKeSaiLa_HistoryAct extends BaseActivity {
    private Button mBtnDelete;
    private Button mBtnGo2Minute;
    private Button mBtnUpdate;
    private VerticalProgressbar mProgressbarHisCur;
    private TextView mTvAverageOil;
    private TextView mTvOptimalOil;
    private TextView mTvUnit;
    private TextView[] mTvHisOil = new TextView[4];
    private VerticalProgressbar[] mProgressbarHis = new VerticalProgressbar[5];
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_HistoryAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 84:
                    if (ints == null) {
                        for (int i = 0; i < 5; i++) {
                            int[] ints2 = ConstWcToyota.mTripoilexpend[i];
                            if (ints2 == null) {
                                ints2 = new int[]{i};
                            }
                            Xbs_AngKeSaiLa_HistoryAct.this.mUpdaterTripOilValue(ints2);
                        }
                        break;
                    } else {
                        Xbs_AngKeSaiLa_HistoryAct.this.mUpdaterTripOilValue(ints);
                        break;
                    }
                case 85:
                    Xbs_AngKeSaiLa_HistoryAct.this.mUpdaterAverageOilExpend();
                    break;
                case 86:
                    Xbs_AngKeSaiLa_HistoryAct.this.mUpdaterCurTripOilExpend();
                    break;
                case 87:
                    Xbs_AngKeSaiLa_HistoryAct.this.mUpdaterIeloopOilExpend();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xbs_angkesaila_history);
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
                intent.setClass(this, Xbs_AngKeSaiLa_TripAct.class);
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
        this.mBtnGo2Minute.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_HistoryAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Xbs_AngKeSaiLa_HistoryAct.this, Xbs_AngKeSaiLa_TripAct.class);
                    Xbs_AngKeSaiLa_HistoryAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.mBtnUpdate.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_HistoryAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
            }
        });
        this.mBtnDelete.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.angkesaila.Xbs_AngKeSaiLa_HistoryAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[85].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[84].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[85].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[84].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterIeloopOilExpend() {
        int value = DataCanbus.DATA[87];
        int num = value & 16777215;
        if (num != 65535) {
            String str = String.valueOf(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10))) + " L/100km";
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
        int value = DataCanbus.DATA[85];
        int num = value & 16777215;
        String str = String.valueOf(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10))) + " L/100km";
        if (this.mTvAverageOil != null) {
            this.mTvAverageOil.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCurTripOilExpend() {
        int value = DataCanbus.DATA[86];
        int num = value & 16777215;
        if (num != 65535) {
            if (this.mTvUnit != null) {
                this.mTvUnit.setText("L/100km");
            }
            for (int i = 0; i < 4; i++) {
                if (this.mTvHisOil[i] != null) {
                    this.mTvHisOil[i].setText(new StringBuilder().append(Rav4Data.mOilNum0[i]).toString());
                }
            }
            if (this.mProgressbarHisCur != null) {
                this.mProgressbarHisCur.setMax(300);
                if (num < 0) {
                    num = 0;
                } else if (num > 300) {
                    num = 30 * 10;
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
        int num = value & 16777215;
        if (num != 65535 && this.mProgressbarHis[index] != null) {
            this.mProgressbarHis[index].setMax(300);
            if (num < 0) {
                num = 0;
            } else if (num > 300) {
                num = 30 * 10;
            }
            this.mProgressbarHis[index].setProgress(num);
            this.mProgressbarHis[index].invalidate();
        }
    }
}
