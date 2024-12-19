package com.syu.carinfo.dongjian.ga6;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class GA6SeatSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dongjian.ga6.GA6SeatSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 4:
                    GA6SeatSetAct.this.updaterSecDriverSeatHot();
                    break;
                case 7:
                    GA6SeatSetAct.this.updaterDriverSeatHot();
                    break;
                case 13:
                    GA6SeatSetAct.this.mUpdaterValue1();
                    break;
                case 14:
                    GA6SeatSetAct.this.mUpdaterValue2();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_257_dongjian_ga6_seat_set);
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
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                GA6Func.C_CAR_CARINFO_CMD(2, 3, DataCanbus.DATA[7] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                GA6Func.C_CAR_CARINFO_CMD(2, 4, DataCanbus.DATA[4] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                GA6Func.C_CAR_CARINFO_CMD(2, 1, DataCanbus.DATA[13] == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                GA6Func.C_CAR_CARINFO_CMD(2, 2, DataCanbus.DATA[14] != 0 ? 0 : 1);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int mValue1 = DataCanbus.DATA[13];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(mValue1 != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int mValue2 = DataCanbus.DATA[14];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(mValue2 != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDriverSeatHot() {
        int mDriverSeat = DataCanbus.DATA[7];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(mDriverSeat != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSecDriverSeatHot() {
        int mSecDriverSeat = DataCanbus.DATA[4];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(mSecDriverSeat != 0);
    }
}
