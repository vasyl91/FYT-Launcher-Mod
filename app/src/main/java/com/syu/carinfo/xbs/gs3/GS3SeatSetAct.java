package com.syu.carinfo.xbs.gs3;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class GS3SeatSetAct extends BaseActivity implements View.OnClickListener {
    CheckedTextView mAutomaticallyCheck;
    CheckedTextView mDriveSetCheck;
    CheckedTextView mSeat_welcomeCheck;
    CheckedTextView mSecDriverSetCheck;
    private View view_Automatically;
    private View view_Seat_welcome;
    int mDriverSeat = -1;
    int mSecDriverSeat = -1;
    int mSeatWelcom = -1;
    int mAutoMatically = -1;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.gs3.GS3SeatSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 4:
                    GS3SeatSetAct.this.updaterDriverSeatHot();
                    break;
                case 5:
                    GS3SeatSetAct.this.updaterSecDriverSeatHot();
                    break;
                case 6:
                    GS3SeatSetAct.this.updaterSeatWelcome();
                    break;
                case 7:
                    GS3SeatSetAct.this.updaterAutoMatically();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_289_wc_gs4_seat_set);
        setUI();
    }

    private void setUI() {
        DataCanbus.PROXY.cmd(3, new int[]{6}, null, null);
        this.view_Seat_welcome = findViewById(R.id.xbs_gs3_seat_welcome_view);
        this.view_Automatically = findViewById(R.id.xbs_gs3_automatically_view);
        View vSeatWelCome = findViewById(R.id.wc_ga6_seatwelcome_view);
        View vSmartKeyIndentify = findViewById(R.id.wc_ga6_smartkeyidentification_view);
        setViewVisible(vSeatWelCome, false);
        setViewVisible(vSmartKeyIndentify, false);
        if (DataCanbus.DATA[1000] == 196773 || DataCanbus.DATA[1000] == 131237) {
            setViewVisible(this.view_Automatically, true);
            setViewVisible(this.view_Seat_welcome, true);
        }
        this.mDriveSetCheck = (CheckedTextView) findViewById(R.id.wc_gs4_seat_set_drive_seat_check);
        this.mSecDriverSetCheck = (CheckedTextView) findViewById(R.id.wc_gs4_air_set_the_pilot_drive_seat_check);
        this.mSeat_welcomeCheck = (CheckedTextView) findViewById(R.id.xbs_gs3_seat_welcome);
        this.mAutomaticallyCheck = (CheckedTextView) findViewById(R.id.xbs_gs3_seat_key_automatically);
        setSelfClick(this.mDriveSetCheck, this);
        setSelfClick(this.mSecDriverSetCheck, this);
        setSelfClick(this.mSeat_welcomeCheck, this);
        setSelfClick(this.mAutomaticallyCheck, this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.wc_gs4_seat_set_drive_seat_check /* 2131429065 */:
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 19;
                iArr[1] = this.mDriverSeat == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
                break;
            case R.id.wc_gs4_air_set_the_pilot_drive_seat_check /* 2131429066 */:
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 20;
                iArr2[1] = this.mSecDriverSeat == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(2, iArr2, null, null);
                break;
            case R.id.xbs_gs3_seat_welcome /* 2131429162 */:
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 22;
                iArr3[1] = this.mSeatWelcom == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(2, iArr3, null, null);
                break;
            case R.id.xbs_gs3_seat_key_automatically /* 2131429164 */:
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[2];
                iArr4[0] = 23;
                iArr4[1] = this.mAutoMatically == 0 ? 1 : 0;
                remoteModuleProxy4.cmd(2, iArr4, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSeatWelcome() {
        this.mSeatWelcom = DataCanbus.DATA[6];
        this.mSeat_welcomeCheck.setChecked(this.mSeatWelcom != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoMatically() {
        this.mAutoMatically = DataCanbus.DATA[7];
        this.mAutomaticallyCheck.setChecked(this.mAutoMatically != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDriverSeatHot() {
        this.mDriverSeat = DataCanbus.DATA[4];
        this.mDriveSetCheck.setChecked(this.mDriverSeat != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSecDriverSeatHot() {
        this.mSecDriverSeat = DataCanbus.DATA[5];
        this.mSecDriverSetCheck.setChecked(this.mSecDriverSeat != 0);
    }
}
