package com.syu.carinfo.dongjian.ga6;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class GA6SeatSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 102:
                    GA6SeatSetAct.this.updaterSecDriverSeatHot();
                    break;
                case 105:
                    GA6SeatSetAct.this.updaterDriverSeatHot();
                    break;
                case 111:
                    GA6SeatSetAct.this.mUpdaterValue1();
                    break;
                case 112:
                    GA6SeatSetAct.this.mUpdaterValue2();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_257_dongjian_ga6_seat_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                GA6Func.C_CAR_CARINFO_CMD(2, 3, DataCanbus.DATA[105] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                GA6Func.C_CAR_CARINFO_CMD(2, 4, DataCanbus.DATA[102] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                GA6Func.C_CAR_CARINFO_CMD(2, 1, DataCanbus.DATA[111] == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                GA6Func.C_CAR_CARINFO_CMD(2, 2, DataCanbus.DATA[112] != 0 ? 0 : 1);
                break;
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int mValue1 = DataCanbus.DATA[111];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(mValue1 != 0);
    }

    
    public void mUpdaterValue2() {
        int mValue2 = DataCanbus.DATA[112];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(mValue2 != 0);
    }

    
    public void updaterDriverSeatHot() {
        int mDriverSeat = DataCanbus.DATA[105];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(mDriverSeat != 0);
    }

    
    public void updaterSecDriverSeatHot() {
        int mSecDriverSeat = DataCanbus.DATA[102];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(mSecDriverSeat != 0);
    }
}
