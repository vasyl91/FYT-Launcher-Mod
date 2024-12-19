package com.syu.carinfo.od.mazdall;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class MazdAllMaintenanceAct extends BaseActivity implements View.OnClickListener {
    private Button mBtnOilChangeMinus;
    private Button mBtnOilChangePlus;
    private Button mBtnReservationMileMinus;
    private Button mBtnReservationMilePlus;
    private Button mBtnReservationTimeMinus;
    private Button mBtnReservationTimePlus;
    private Button mBtnTireChangeMinus;
    private Button mBtnTireChangePlus;
    private CheckedTextView mCtvReservationOnoff;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.mazdall.MazdAllMaintenanceAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 46:
                    if (MazdAllMaintenanceAct.this.mCtvReservationOnoff != null) {
                        MazdAllMaintenanceAct.this.mCtvReservationOnoff.setChecked(value == 1);
                        break;
                    }
                case 47:
                    if (MazdAllMaintenanceAct.this.mTextReservationTime != null) {
                        MazdAllMaintenanceAct.this.mTextReservationTime.setText(String.valueOf(String.format("%d", Integer.valueOf(value + 6))) + LauncherApplication.getInstance().getResources().getString(R.string.str_months));
                        break;
                    }
                case 48:
                    if (MazdAllMaintenanceAct.this.mTextReservationMile != null) {
                        MazdAllMaintenanceAct.this.mTextReservationMile.setText(String.valueOf(String.format("%d", Integer.valueOf((value + 10) * 1000))) + LauncherApplication.getInstance().getResources().getString(R.string.wc_jianianhua_show__metric_unit_0));
                        break;
                    }
                case 49:
                    if (MazdAllMaintenanceAct.this.mTextTireChange != null) {
                        MazdAllMaintenanceAct.this.mTextTireChange.setText(String.valueOf(String.format("%d", Integer.valueOf((value + 10) * 1000))) + LauncherApplication.getInstance().getResources().getString(R.string.wc_jianianhua_show__metric_unit_0));
                        break;
                    }
                case 50:
                    if (MazdAllMaintenanceAct.this.mTextOilChange != null) {
                        MazdAllMaintenanceAct.this.mTextOilChange.setText(String.valueOf(String.format("%d", Integer.valueOf((value + 10) * 1000))) + LauncherApplication.getInstance().getResources().getString(R.string.wc_jianianhua_show__metric_unit_0));
                        break;
                    }
            }
        }
    };
    private TextView mTextOilChange;
    private TextView mTextReservationMile;
    private TextView mTextReservationTime;
    private TextView mTextTireChange;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_mzdall_maintenance_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mCtvReservationOnoff = (CheckedTextView) findViewById(R.id.ctv_od_mazdall_reservation_onoff);
        setSelfClick(this.mCtvReservationOnoff, this);
        this.mBtnReservationTimeMinus = (Button) findViewById(R.id.od_mazdall_btn_reservetime_minus);
        this.mBtnReservationTimePlus = (Button) findViewById(R.id.od_mazdall_btn_reservetime_plus);
        this.mTextReservationTime = (TextView) findViewById(R.id.tv_od_mazdall_reservetime);
        setSelfClick(this.mBtnReservationTimeMinus, this);
        setSelfClick(this.mBtnReservationTimePlus, this);
        this.mBtnReservationMileMinus = (Button) findViewById(R.id.od_mazdall_btn_reservemile_minus);
        this.mBtnReservationMilePlus = (Button) findViewById(R.id.od_mazdall_btn_reservemile_plus);
        this.mTextReservationMile = (TextView) findViewById(R.id.tv_od_mazdall_reservemile);
        setSelfClick(this.mBtnReservationMileMinus, this);
        setSelfClick(this.mBtnReservationMilePlus, this);
        this.mBtnTireChangeMinus = (Button) findViewById(R.id.od_mazdall_btn_tirechange_minus);
        this.mBtnTireChangePlus = (Button) findViewById(R.id.od_mazdall_btn_tirechange_plus);
        this.mTextTireChange = (TextView) findViewById(R.id.tv_od_mazdall_tirechange);
        setSelfClick(this.mBtnTireChangeMinus, this);
        setSelfClick(this.mBtnTireChangePlus, this);
        this.mBtnOilChangeMinus = (Button) findViewById(R.id.od_mazdall_btn_motoroil_minus);
        this.mBtnOilChangePlus = (Button) findViewById(R.id.od_mazdall_btn_motoroil_plus);
        this.mTextOilChange = (TextView) findViewById(R.id.tv_od_mazdall_motoroil);
        setSelfClick(this.mBtnOilChangeMinus, this);
        setSelfClick(this.mBtnOilChangePlus, this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_od_mazdall_reservation_onoff /* 2131428299 */:
                int value = DataCanbus.DATA[46];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{1, value}, null, null);
                break;
            case R.id.od_mazdall_btn_reservetime_minus /* 2131428300 */:
                int value2 = DataCanbus.DATA[47] - 1;
                if (value2 < 0) {
                    value2 = 18;
                }
                DataCanbus.PROXY.cmd(2, new int[]{2, value2}, null, null);
                break;
            case R.id.od_mazdall_btn_reservetime_plus /* 2131428302 */:
                int value3 = DataCanbus.DATA[47] + 1;
                if (value3 > 18) {
                    value3 = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{2, value3}, null, null);
                break;
            case R.id.od_mazdall_btn_reservemile_minus /* 2131428303 */:
                int value4 = DataCanbus.DATA[48];
                if (value4 > 0) {
                    value4--;
                }
                DataCanbus.PROXY.cmd(2, new int[]{3, value4}, null, null);
                break;
            case R.id.od_mazdall_btn_reservemile_plus /* 2131428305 */:
                DataCanbus.PROXY.cmd(2, new int[]{3, DataCanbus.DATA[48] + 1}, null, null);
                break;
            case R.id.od_mazdall_btn_tirechange_minus /* 2131428306 */:
                int value5 = DataCanbus.DATA[49];
                if (value5 > 0) {
                    value5--;
                }
                DataCanbus.PROXY.cmd(2, new int[]{4, value5}, null, null);
                break;
            case R.id.od_mazdall_btn_tirechange_plus /* 2131428308 */:
                DataCanbus.PROXY.cmd(2, new int[]{4, DataCanbus.DATA[49] + 1}, null, null);
                break;
            case R.id.od_mazdall_btn_motoroil_minus /* 2131428309 */:
                int value6 = DataCanbus.DATA[50];
                if (value6 > 0) {
                    value6--;
                }
                DataCanbus.PROXY.cmd(2, new int[]{5, value6}, null, null);
                break;
            case R.id.od_mazdall_btn_motoroil_plus /* 2131428311 */:
                DataCanbus.PROXY.cmd(2, new int[]{5, DataCanbus.DATA[50] + 1}, null, null);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, value1, value2);
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

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
    }
}
