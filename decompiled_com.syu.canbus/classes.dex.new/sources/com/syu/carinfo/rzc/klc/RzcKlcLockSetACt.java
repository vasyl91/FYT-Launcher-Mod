package com.syu.carinfo.rzc.klc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RzcKlcLockSetACt extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.klc.RzcKlcLockSetACt.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 107:
                    RzcKlcLockSetACt.this.updatePreventAutoLatch();
                    break;
                case 108:
                    RzcKlcLockSetACt.this.updateAutoLatch();
                    break;
                case 109:
                    RzcKlcLockSetACt.this.updateParkingAutoUnLock();
                    break;
                case 110:
                    RzcKlcLockSetACt.this.updateDelayLatch();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_klc_lock_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int ParkingAutoUnlockState = DataCanbus.DATA[109];
                if (ParkingAutoUnlockState == 0) {
                    RzcKlcFunc.CAR_COMM_CONTROL(4, 2);
                } else if (ParkingAutoUnlockState == 1) {
                    RzcKlcFunc.CAR_COMM_CONTROL(4, 0);
                } else if (ParkingAutoUnlockState == 2) {
                    RzcKlcFunc.CAR_COMM_CONTROL(4, 1);
                }
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int ParkingAutoUnlockState2 = DataCanbus.DATA[109];
                if (ParkingAutoUnlockState2 == 0) {
                    RzcKlcFunc.CAR_COMM_CONTROL(4, 1);
                } else if (ParkingAutoUnlockState2 == 1) {
                    RzcKlcFunc.CAR_COMM_CONTROL(4, 2);
                } else if (ParkingAutoUnlockState2 == 2) {
                    RzcKlcFunc.CAR_COMM_CONTROL(4, 0);
                }
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int AutoLatchState = DataCanbus.DATA[108];
                RzcKlcFunc.CAR_COMM_CONTROL(3, AutoLatchState != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int PreventAutoLatchState = DataCanbus.DATA[107];
                RzcKlcFunc.CAR_COMM_CONTROL(2, PreventAutoLatchState != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int DelayLatchState = DataCanbus.DATA[110];
                RzcKlcFunc.CAR_COMM_CONTROL(5, DelayLatchState != 0 ? 0 : 1);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateParkingAutoUnLock() {
        int ParkingAutoUnlockState = DataCanbus.DATA[109];
        if (ParkingAutoUnlockState == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_Parking_with_trailer_Off);
        } else if (ParkingAutoUnlockState == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        } else if (ParkingAutoUnlockState == 2) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoLatch() {
        int AutoLatchState = DataCanbus.DATA[108];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(AutoLatchState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePreventAutoLatch() {
        int PreventAutoLatchState = DataCanbus.DATA[107];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(PreventAutoLatchState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDelayLatch() {
        int DelayLatchState = DataCanbus.DATA[110];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(DelayLatchState != 0);
    }
}
