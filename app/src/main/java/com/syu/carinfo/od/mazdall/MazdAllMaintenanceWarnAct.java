package com.syu.carinfo.od.mazdall;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class MazdAllMaintenanceWarnAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.mazdall.MazdAllMaintenanceWarnAct.1
        @Override // com.syu.module.IUiNotify
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_mzdall_maintenance_info);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mTvChangeTire = (TextView) findViewById(R.id.tx_od_mazdall_changtire);
        this.mTvReservation = (TextView) findViewById(R.id.tx_od_mazdall_reservation);
        this.mTvChangeOil = (TextView) findViewById(R.id.tx_od_mazdall_changoil);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        v.getId();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
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
