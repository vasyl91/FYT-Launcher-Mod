package com.syu.carinfo.xbs.gs3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class GS3EnergySetAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    Button mCancleBtn;
    Button mConfirmBtn;
    Button mCycleAll;
    Button mCycleOne;
    Button mCycleWeek1;
    Button mCycleWeek2;
    Button mCycleWeek3;
    Button mCycleWeek4;
    Button mCycleWeek5;
    Button mCycleWeek6;
    Button mCycleWeek7;
    Button mEnergyBack1;
    Button mEnergyBack2;
    Button mEnergyBack3;
    Button mEnergyReserve0;
    Button mEnergyReserve1;
    Button mEnergyShowBtn;
    TextView mReserveTime;
    TimePicker mTimePicker0;
    TimePicker mTimePicker1;
    View mTimePicker_View;
    Button mTimeSetBtn;
    int mEnergyBack = 0;
    int mCharge = 0;
    int ReserveStarH = 0;
    int ReserveStarM = 0;
    int ReserveEndH = 0;
    int ReserveEndM = 0;
    int CycleMode = 0;
    int mWeek1 = 0;
    int mWeek2 = 0;
    int mWeek3 = 0;
    int mWeek4 = 0;
    int mWeek5 = 0;
    int mWeek6 = 0;
    int mWeek7 = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.gs3.GS3EnergySetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 27:
                    GS3EnergySetAct.this.updaterEnergyBack(value);
                    break;
                case 30:
                    GS3EnergySetAct.this.updaterEnergyCharge(value);
                    break;
                case 31:
                    GS3EnergySetAct.this.updaterReserveTime(value);
                    break;
                case 32:
                    GS3EnergySetAct.this.updaterCycleMode(value);
                    break;
                case 33:
                    GS3EnergySetAct.this.updaterCycleDate(value);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_165_xbs_gs3_energyset);
        setUI();
    }

    private void setUI() {
        this.mTimePicker0 = (TimePicker) findViewById(R.id.timePicker0);
        this.mTimePicker1 = (TimePicker) findViewById(R.id.timePicker1);
        this.mTimePicker0.setIs24HourView(true);
        this.mTimePicker1.setIs24HourView(true);
        this.mTimePicker_View = findViewById(R.id.timePicker_view);
        this.mEnergyShowBtn = (Button) findViewById(R.id.energy_show_btn);
        this.mReserveTime = (TextView) findViewById(R.id.energy_time_show);
        this.mCycleAll = (Button) findViewById(R.id.energy_mode_cycle);
        this.mCycleOne = (Button) findViewById(R.id.energy_mode_one);
        this.mCycleWeek1 = (Button) findViewById(R.id.energy_cycle_date1);
        this.mCycleWeek2 = (Button) findViewById(R.id.energy_cycle_date2);
        this.mCycleWeek3 = (Button) findViewById(R.id.energy_cycle_date3);
        this.mCycleWeek4 = (Button) findViewById(R.id.energy_cycle_date4);
        this.mCycleWeek5 = (Button) findViewById(R.id.energy_cycle_date5);
        this.mCycleWeek6 = (Button) findViewById(R.id.energy_cycle_date6);
        this.mCycleWeek7 = (Button) findViewById(R.id.energy_cycle_date7);
        this.mEnergyBack1 = (Button) findViewById(R.id.energy_back1);
        this.mEnergyBack2 = (Button) findViewById(R.id.energy_back2);
        this.mEnergyBack3 = (Button) findViewById(R.id.energy_back3);
        this.mEnergyReserve0 = (Button) findViewById(R.id.energy_reserve0);
        this.mEnergyReserve1 = (Button) findViewById(R.id.energy_reserve1);
        this.mTimeSetBtn = (Button) findViewById(R.id.energy_time_set);
        this.mConfirmBtn = (Button) findViewById(R.id.timePicker_confirm);
        this.mCancleBtn = (Button) findViewById(R.id.timePicker_cancel);
        setSelfClick(this.mCycleAll, this);
        setSelfClick(this.mCycleOne, this);
        setSelfClick(this.mCycleWeek1, this);
        setSelfClick(this.mCycleWeek2, this);
        setSelfClick(this.mCycleWeek3, this);
        setSelfClick(this.mCycleWeek4, this);
        setSelfClick(this.mCycleWeek5, this);
        setSelfClick(this.mCycleWeek6, this);
        setSelfClick(this.mCycleWeek7, this);
        setSelfClick(this.mEnergyBack1, this);
        setSelfClick(this.mEnergyBack2, this);
        setSelfClick(this.mEnergyBack3, this);
        setSelfClick(this.mEnergyReserve0, this);
        setSelfClick(this.mEnergyReserve1, this);
        setSelfClick(this.mTimeSetBtn, this);
        setSelfClick(this.mConfirmBtn, this);
        setSelfClick(this.mCancleBtn, this);
        setSelfClick(this.mEnergyShowBtn, this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.energy_show_btn /* 2131428697 */:
                try {
                    Intent intent = new Intent(this, (Class<?>) GS3EnergyFlowAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.energy_back1 /* 2131428698 */:
                this.mEnergyBack = 0;
                energy_cmd();
                break;
            case R.id.energy_back2 /* 2131428699 */:
                this.mEnergyBack = 1;
                energy_cmd();
                break;
            case R.id.energy_back3 /* 2131428700 */:
                this.mEnergyBack = 2;
                energy_cmd();
                break;
            case R.id.energy_reserve0 /* 2131428701 */:
                this.mCharge = 0;
                energy_cmd();
                break;
            case R.id.energy_reserve1 /* 2131428702 */:
                this.mCharge = 1;
                energy_cmd();
                break;
            case R.id.energy_mode_cycle /* 2131428703 */:
                this.CycleMode = 1;
                energy_cmd();
                break;
            case R.id.energy_mode_one /* 2131428704 */:
                this.CycleMode = 0;
                energy_cmd();
                break;
            case R.id.energy_time_set /* 2131428706 */:
                this.mTimePicker0.setCurrentHour(Integer.valueOf(this.ReserveStarH));
                this.mTimePicker0.setCurrentMinute(Integer.valueOf(this.ReserveStarM));
                this.mTimePicker1.setCurrentHour(Integer.valueOf(this.ReserveEndH));
                this.mTimePicker1.setCurrentMinute(Integer.valueOf(this.ReserveEndM));
                setViewVisible(this.mTimePicker_View, true);
                break;
            case R.id.energy_cycle_date1 /* 2131428707 */:
                this.mWeek1 = this.mWeek1 != 0 ? 0 : 1;
                energy_cmd();
                break;
            case R.id.energy_cycle_date2 /* 2131428708 */:
                this.mWeek2 = this.mWeek2 != 0 ? 0 : 1;
                energy_cmd();
                break;
            case R.id.energy_cycle_date3 /* 2131428709 */:
                this.mWeek3 = this.mWeek3 != 0 ? 0 : 1;
                energy_cmd();
                break;
            case R.id.energy_cycle_date4 /* 2131428710 */:
                this.mWeek4 = this.mWeek4 != 0 ? 0 : 1;
                energy_cmd();
                break;
            case R.id.energy_cycle_date5 /* 2131428711 */:
                this.mWeek5 = this.mWeek5 != 0 ? 0 : 1;
                energy_cmd();
                break;
            case R.id.energy_cycle_date6 /* 2131428712 */:
                this.mWeek6 = this.mWeek6 != 0 ? 0 : 1;
                energy_cmd();
                break;
            case R.id.energy_cycle_date7 /* 2131428713 */:
                this.mWeek7 = this.mWeek7 != 0 ? 0 : 1;
                energy_cmd();
                break;
            case R.id.timePicker_confirm /* 2131428717 */:
                this.ReserveStarH = this.mTimePicker0.getCurrentHour().intValue();
                this.ReserveStarM = this.mTimePicker0.getCurrentMinute().intValue();
                this.ReserveEndH = this.mTimePicker1.getCurrentHour().intValue();
                this.ReserveEndM = this.mTimePicker1.getCurrentMinute().intValue();
                energy_cmd();
                setViewVisible(this.mTimePicker_View, false);
                updaterReserveTime((this.ReserveStarH << 24) | (this.ReserveStarM << 16) | (this.ReserveEndH << 8) | this.ReserveEndM);
                break;
            case R.id.timePicker_cancel /* 2131428718 */:
                setViewVisible(this.mTimePicker_View, false);
                break;
        }
    }

    public void energy_cmd() {
        int[] date = {(this.mEnergyBack & 3) << 6, this.mCharge & 1, this.ReserveStarH & 255, this.ReserveStarM & 255, this.ReserveEndH & 255, this.ReserveEndM & 255, this.CycleMode & 255, ((this.mWeek7 & 1) << 7) | ((this.mWeek6 & 1) << 6) | ((this.mWeek5 & 1) << 5) | ((this.mWeek4 & 1) << 4) | ((this.mWeek2 & 3) << 3) | ((this.mWeek2 & 1) << 2) | ((this.mWeek1 & 1) << 1)};
        DataCanbus.PROXY.cmd(4, new int[]{date[0], date[1], date[2], date[3], date[4], date[5], date[6], date[7]}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        AirHelper.disableAirWindowLocal(true);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterEnergyBack(int value) {
        this.mEnergyBack = value;
        switch (this.mEnergyBack) {
            case 0:
                this.mEnergyBack1.setBackgroundResource(R.drawable.ge3_btn2_p);
                this.mEnergyBack2.setBackgroundResource(R.drawable.ge3_btn2);
                this.mEnergyBack3.setBackgroundResource(R.drawable.ge3_btn2);
                break;
            case 1:
                this.mEnergyBack1.setBackgroundResource(R.drawable.ge3_btn2);
                this.mEnergyBack2.setBackgroundResource(R.drawable.ge3_btn2_p);
                this.mEnergyBack3.setBackgroundResource(R.drawable.ge3_btn2);
                break;
            case 2:
                this.mEnergyBack1.setBackgroundResource(R.drawable.ge3_btn2);
                this.mEnergyBack2.setBackgroundResource(R.drawable.ge3_btn2);
                this.mEnergyBack3.setBackgroundResource(R.drawable.ge3_btn2_p);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterEnergyCharge(int value) {
        this.mCharge = value;
        switch (this.mCharge) {
            case 0:
                this.mEnergyReserve0.setBackgroundResource(R.drawable.ge3_btn1_p);
                this.mEnergyReserve1.setBackgroundResource(R.drawable.ge3_btn1);
                break;
            case 1:
                this.mEnergyReserve0.setBackgroundResource(R.drawable.ge3_btn1);
                this.mEnergyReserve1.setBackgroundResource(R.drawable.ge3_btn1_p);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterReserveTime(int value) {
        this.ReserveStarH = (value >> 24) & 255;
        this.ReserveStarM = (value >> 16) & 255;
        this.ReserveEndH = (value >> 8) & 255;
        this.ReserveEndM = value & 255;
        String str = String.valueOf(this.ReserveStarH / 10) + (this.ReserveStarH % 10) + ":" + (this.ReserveStarM / 10) + (this.ReserveStarM % 10) + " to " + (this.ReserveEndH / 10) + (this.ReserveEndH % 10) + ":" + (this.ReserveEndM / 10) + (this.ReserveEndM % 10);
        this.mReserveTime.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCycleMode(int value) {
        this.CycleMode = value;
        switch (this.CycleMode) {
            case 0:
                this.mCycleAll.setBackgroundResource(R.drawable.ge3_btn1);
                this.mCycleOne.setBackgroundResource(R.drawable.ge3_btn1_p);
                break;
            case 1:
                this.mCycleOne.setBackgroundResource(R.drawable.ge3_btn1);
                this.mCycleAll.setBackgroundResource(R.drawable.ge3_btn1_p);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCycleDate(int value) {
        int i = R.drawable.ge3_btn3;
        this.mWeek7 = (value >> 7) & 1;
        this.mWeek6 = (value >> 6) & 1;
        this.mWeek5 = (value >> 5) & 1;
        this.mWeek4 = (value >> 4) & 1;
        this.mWeek3 = (value >> 3) & 1;
        this.mWeek2 = (value >> 2) & 1;
        this.mWeek1 = (value >> 1) & 1;
        this.mCycleWeek1.setBackgroundResource(this.mWeek1 == 0 ? 2130838694 : 2130838695);
        this.mCycleWeek2.setBackgroundResource(this.mWeek2 == 0 ? 2130838694 : 2130838695);
        this.mCycleWeek3.setBackgroundResource(this.mWeek3 == 0 ? 2130838694 : 2130838695);
        this.mCycleWeek4.setBackgroundResource(this.mWeek4 == 0 ? 2130838694 : 2130838695);
        this.mCycleWeek5.setBackgroundResource(this.mWeek5 == 0 ? 2130838694 : 2130838695);
        this.mCycleWeek6.setBackgroundResource(this.mWeek6 == 0 ? 2130838694 : 2130838695);
        Button button = this.mCycleWeek7;
        if (this.mWeek7 != 0) {
            i = 2130838695;
        }
        button.setBackgroundResource(i);
    }
}
