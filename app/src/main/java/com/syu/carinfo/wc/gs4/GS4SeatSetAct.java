package com.syu.carinfo.wc.gs4;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class GS4SeatSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_289_wc_gs4_seat_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.wc_gs4_seat_set_drive_seat_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.wc_gs4_air_set_the_pilot_drive_seat_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.wc_ga6_seatwelcome_set)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.wc_ga6_smartkeyidentification_set)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.wc_gs4_seat_set_drive_seat_check /* 2131429030 */:
                int mDriverSeat = DataCanbus.DATA[102];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 5;
                iArr[1] = mDriverSeat == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
                break;
            case R.id.wc_gs4_air_set_the_pilot_drive_seat_check /* 2131429031 */:
                int mSecDriverSeat = DataCanbus.DATA[103];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 6;
                iArr2[1] = mSecDriverSeat == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(2, iArr2, null, null);
                break;
            case R.id.wc_ga6_seatwelcome_set /* 2131429118 */:
                int mSeatwelcome = DataCanbus.DATA[104];
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 23;
                iArr3[1] = mSeatwelcome == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(2, iArr3, null, null);
                break;
            case R.id.wc_ga6_smartkeyidentification_set /* 2131429120 */:
                int mSmartKeyIdentification = DataCanbus.DATA[105];
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[2];
                iArr4[0] = 24;
                iArr4[1] = mSmartKeyIdentification == 0 ? 1 : 0;
                remoteModuleProxy4.cmd(2, iArr4, null, null);
                break;
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterSmartKeyIdentification() {
        int mSmartKeyIdentification = DataCanbus.DATA[105];
        ((CheckedTextView) findViewById(R.id.wc_ga6_smartkeyidentification_set)).setChecked(mSmartKeyIdentification != 0);
    }

    
    public void updaterSeatWelcome() {
        int mSeatwelcome = DataCanbus.DATA[104];
        ((CheckedTextView) findViewById(R.id.wc_ga6_seatwelcome_set)).setChecked(mSeatwelcome != 0);
    }

    
    public void updaterDriverSeatHot() {
        int mDriverSeat = DataCanbus.DATA[102];
        ((CheckedTextView) findViewById(R.id.wc_gs4_seat_set_drive_seat_check)).setChecked(mDriverSeat != 0);
    }

    
    public void updaterSecDriverSeatHot() {
        int mSecDriverSeat = DataCanbus.DATA[103];
        ((CheckedTextView) findViewById(R.id.wc_gs4_air_set_the_pilot_drive_seat_check)).setChecked(mSecDriverSeat != 0);
    }
}
