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
public class Xbs_AngKeSaiLa_TripAct extends BaseActivity {
    private Button mBtnClear;
    private Button mBtnGo2HisOil;
    private TextView mMileageUnit;
    private VerticalProgressbar mProgressbarCur;
    private VerticalProgressbar[] mProgressbar = new VerticalProgressbar[30];
    private TextView[] mOilTv = new TextView[4];
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 40:
                    if (ints == null) {
                        for (int i = 0; i < 30; i++) {
                            int[] ints2 = ConstWcToyota.mMinuteoilexpend[i];
                            if (ints2 == null) {
                                ints2 = new int[]{i};
                            }
                            Xbs_AngKeSaiLa_TripAct.this.mUpdaterOilValue(ints2);
                        }
                        break;
                    } else {
                        Xbs_AngKeSaiLa_TripAct.this.mUpdaterOilValue(ints);
                        break;
                    }
                case 42:
                    Xbs_AngKeSaiLa_TripAct.this.mUpdaterOilExpend();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xbs_angkesaila_trip);
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
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
    }

    @Override
    public void init() {
        this.mProgressbar[0] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_0);
        this.mProgressbar[1] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_1);
        this.mProgressbar[2] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_2);
        this.mProgressbar[3] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_3);
        this.mProgressbar[4] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_4);
        this.mProgressbar[5] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_5);
        this.mProgressbar[6] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_6);
        this.mProgressbar[7] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_7);
        this.mProgressbar[8] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_8);
        this.mProgressbar[9] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_9);
        this.mProgressbar[10] = (VerticalProgressbar) findViewById(R.id.progressbar_1rav4_0);
        this.mProgressbar[11] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_11);
        this.mProgressbar[12] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_12);
        this.mProgressbar[13] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_13);
        this.mProgressbar[14] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_14);
        this.mProgressbarCur = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_cur);
        this.mMileageUnit = (TextView) findViewById(R.id.rav4_tv_oil_unit);
        this.mOilTv[0] = (TextView) findViewById(R.id.rav4_tv_oil_0);
        this.mOilTv[1] = (TextView) findViewById(R.id.rav4_tv_oil_1);
        this.mOilTv[2] = (TextView) findViewById(R.id.rav4_tv_oil_2);
        this.mOilTv[3] = (TextView) findViewById(R.id.rav4_tv_oil_3);
        this.mBtnGo2HisOil = (Button) findViewById(R.id.rav4_btn_iol_expend);
        this.mBtnClear = (Button) findViewById(R.id.rav4_btn_clear);
        this.mBtnGo2HisOil.setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Xbs_AngKeSaiLa_TripAct.this, Xbs_AngKeSaiLa_HistoryAct.class);
                    Xbs_AngKeSaiLa_TripAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.mBtnClear.setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        try {
            Intent intent = new Intent();
            intent.setClass(this, XBS_AngKeSaiLa_Cx4_IndexAct.class);
            startActivity(intent);
            finish();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    
    public void mUpdaterOilExpend() {
        int value = DataCanbus.DATA[42];
        int num = value & 16777215;
        if (num != 65535) {
            if (this.mMileageUnit != null) {
                this.mMileageUnit.setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
            }
            for (int i = 0; i < 4; i++) {
                if (this.mOilTv[i] != null) {
                    this.mOilTv[i].setText(new StringBuilder().append(Rav4Data.mOilNum0[i]).toString());
                }
            }
            if (this.mProgressbarCur != null) {
                this.mProgressbarCur.setMax(300);
                if (num < 0) {
                    num = 0;
                } else if (num > 300) {
                    num = 30 * 10;
                }
                this.mProgressbarCur.setProgress(num);
                this.mProgressbarCur.invalidate();
                return;
            }
            return;
        }
        this.mProgressbarCur.setProgress(0);
        this.mProgressbarCur.invalidate();
    }

    
    public void mUpdaterOilValue(int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 30) {
            int index = ints[0];
            int value = ints[1];
            int num = value & 16777215;
            if (num != 65535) {
                if (this.mMileageUnit != null) {
                    this.mMileageUnit.setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                }
                for (int i = 0; i < 4; i++) {
                    if (this.mOilTv[i] != null) {
                        this.mOilTv[i].setText(new StringBuilder().append(Rav4Data.mOilNum0[i]).toString());
                    }
                }
                if (this.mProgressbar[index] != null) {
                    this.mProgressbar[index].setMax(300);
                    if (num < 0) {
                        num = 0;
                    } else if (num > 300) {
                        num = 30 * 10;
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
