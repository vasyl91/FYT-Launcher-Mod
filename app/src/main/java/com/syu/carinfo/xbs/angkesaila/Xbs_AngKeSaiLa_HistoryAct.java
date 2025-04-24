package com.syu.carinfo.xbs.angkesaila;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.carinfo.wccamry.ConstWcToyota;
import com.syu.carinfo.wccamry.Rav4Data;
import com.syu.carinfo.wccamry.VerticalProgressbar;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
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
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 41:
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
                case 42:
                    Xbs_AngKeSaiLa_HistoryAct.this.mUpdaterAverageOilExpend();
                    break;
                case 43:
                    Xbs_AngKeSaiLa_HistoryAct.this.mUpdaterCurTripOilExpend();
                    break;
                case 44:
                    Xbs_AngKeSaiLa_HistoryAct.this.mUpdaterIeloopOilExpend();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xbs_angkesaila_history);
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

    @Override
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
        this.mBtnGo2Minute.setOnClickListener(new View.OnClickListener() { 
            @Override
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
        this.mBtnUpdate.setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
            }
        });
        this.mBtnDelete.setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterIeloopOilExpend() {
        int value = DataCanbus.DATA[44];
        int num = value & 16777215;
        if (num != 65535) {
            String str = String.valueOf(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10))) + " " + CamryData.OIL_EXPEND_UNIT_L_PER_100KM;
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

    
    public void mUpdaterAverageOilExpend() {
        int value = DataCanbus.DATA[42];
        int num = value & 16777215;
        String str = String.valueOf(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10))) + " " + CamryData.OIL_EXPEND_UNIT_L_PER_100KM;
        if (this.mTvAverageOil != null) {
            this.mTvAverageOil.setText(str);
        }
    }

    
    public void mUpdaterCurTripOilExpend() {
        int value = DataCanbus.DATA[43];
        int num = value & 16777215;
        if (num != 65535) {
            if (this.mTvUnit != null) {
                this.mTvUnit.setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
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
