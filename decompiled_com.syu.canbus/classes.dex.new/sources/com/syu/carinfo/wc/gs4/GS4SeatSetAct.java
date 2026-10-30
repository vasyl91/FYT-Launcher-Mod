package com.syu.carinfo.wc.gs4;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class GS4SeatSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.gs4.GS4SeatSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 102:
                    GS4SeatSetAct.this.updaterDriverSeatHot();
                    break;
                case 103:
                    GS4SeatSetAct.this.updaterSecDriverSeatHot();
                    break;
                case 104:
                    GS4SeatSetAct.this.updaterSeatWelcome();
                    break;
                case 105:
                    GS4SeatSetAct.this.updaterSmartKeyIdentification();
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
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int mDriverSeat = DataCanbus.DATA[102];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 5;
                iArr[1] = mDriverSeat == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int mSmartKeyIdentification = DataCanbus.DATA[105];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 24;
                iArr2[1] = mSmartKeyIdentification == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(2, iArr2, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int mSecDriverSeat = DataCanbus.DATA[103];
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 6;
                iArr3[1] = mSecDriverSeat == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(2, iArr3, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int mSeatwelcome = DataCanbus.DATA[104];
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[2];
                iArr4[0] = 23;
                iArr4[1] = mSeatwelcome == 0 ? 1 : 0;
                remoteModuleProxy4.cmd(2, iArr4, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSmartKeyIdentification() {
        int mSmartKeyIdentification = DataCanbus.DATA[105];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(mSmartKeyIdentification != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSeatWelcome() {
        int mSeatwelcome = DataCanbus.DATA[104];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(mSeatwelcome != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDriverSeatHot() {
        int mDriverSeat = DataCanbus.DATA[102];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(mDriverSeat != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSecDriverSeatHot() {
        int mSecDriverSeat = DataCanbus.DATA[103];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(mSecDriverSeat != 0);
    }
}
