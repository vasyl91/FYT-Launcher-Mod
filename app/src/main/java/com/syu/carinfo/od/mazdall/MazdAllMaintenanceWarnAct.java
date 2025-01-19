package com.syu.carinfo.od.mazdall;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class MazdAllMaintenanceWarnAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 52:
                case 53:
                    MazdAllMaintenanceWarnAct.this.updateReservation();
                    break;
            }
        }
    };
    private TextView mTvChangeOil;
    private TextView mTvChangeTire;
    private TextView mTvReservation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_mzdall_maintenance_info);
        init();
    }

    @Override
    public void init() {
        this.mTvChangeTire = findViewById(R.id.tx_od_mazdall_changtire);
        this.mTvReservation = findViewById(R.id.tx_od_mazdall_reservation);
        this.mTvChangeOil = findViewById(R.id.tx_od_mazdall_changoil);
    }

    @Override
    public void onClick(View v) {
        v.getId();
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateReservation() {
        int value = DataCanbus.DATA[52];
        int value1 = DataCanbus.DATA[53];
        if (this.mTvChangeTire != null) {
            if ((value & 2) == 2) {
                this.mTvChangeTire.setText("设定里程已满,请更换轮胎");
            } else {
                this.mTvChangeTire.setText("正常");
            }
        }
        if (this.mTvChangeOil != null) {
            if ((value & 4) == 4) {
                this.mTvChangeOil.setText("设定里程已满,请更换机油");
            } else {
                this.mTvChangeOil.setText("正常");
            }
        }
        if (this.mTvReservation != null) {
            if ((value & 1) == 1) {
                this.mTvReservation.setText("设定保养里程已满,请保养车辆");
            } else if (value1 == 1) {
                this.mTvReservation.setText("设定保养时间已满,请保养车辆");
            } else {
                this.mTvReservation.setText("正常");
            }
        }
    }
}
