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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class GS3EnergySetAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    int CycleMode;
    int ReserveEndH;
    int ReserveEndM;
    int ReserveStarH;
    int ReserveStarM;
    int mCharge;
    int mEnergyBack;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.gs3.GS3EnergySetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 125:
                    GS3EnergySetAct.this.updaterEnergyBack(value);
                    break;
                case 128:
                    GS3EnergySetAct.this.updaterEnergyCharge(value);
                    break;
                case 129:
                    GS3EnergySetAct.this.updaterReserveTime(value);
                    break;
                case 130:
                    GS3EnergySetAct.this.updaterCycleMode(value);
                    break;
                case 131:
                    GS3EnergySetAct.this.updaterCycleDate(value);
                    break;
            }
        }
    };
    int mWeek1;
    int mWeek2;
    int mWeek3;
    int mWeek4;
    int mWeek5;
    int mWeek6;
    int mWeek7;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_165_xbs_gs3_energyset);
        setUI();
    }

    private void setUI() {
        ((TimePicker) findViewById(R.id.timePicker0)).setIs24HourView(true);
        ((TimePicker) findViewById(R.id.timePicker1)).setIs24HourView(true);
        setSelfClick((Button) findViewById(R.id.energy_mode_cycle), this);
        setSelfClick((Button) findViewById(R.id.energy_mode_one), this);
        setSelfClick((Button) findViewById(R.id.energy_cycle_date1), this);
        setSelfClick((Button) findViewById(R.id.energy_cycle_date2), this);
        setSelfClick((Button) findViewById(R.id.energy_cycle_date3), this);
        setSelfClick((Button) findViewById(R.id.energy_cycle_date4), this);
        setSelfClick((Button) findViewById(R.id.energy_cycle_date5), this);
        setSelfClick((Button) findViewById(R.id.energy_cycle_date6), this);
        setSelfClick((Button) findViewById(R.id.energy_cycle_date7), this);
        setSelfClick((Button) findViewById(R.id.energy_back1), this);
        setSelfClick((Button) findViewById(R.id.energy_back2), this);
        setSelfClick((Button) findViewById(R.id.energy_back3), this);
        setSelfClick((Button) findViewById(R.id.energy_reserve0), this);
        setSelfClick((Button) findViewById(R.id.energy_reserve1), this);
        setSelfClick((Button) findViewById(R.id.energy_time_set), this);
        setSelfClick((Button) findViewById(R.id.timePicker_confirm), this);
        setSelfClick((Button) findViewById(R.id.timePicker_cancel), this);
        setSelfClick((Button) findViewById(R.id.energy_show_btn), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.energy_show_btn /* 2131428908 */:
                try {
                    Intent intent = new Intent(this, (Class<?>) GS3EnergyFlowAct.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.energy_back1 /* 2131428909 */:
                this.mEnergyBack = 0;
                energy_cmd();
                break;
            case R.id.energy_back2 /* 2131428910 */:
                this.mEnergyBack = 1;
                energy_cmd();
                break;
            case R.id.energy_back3 /* 2131428911 */:
                this.mEnergyBack = 2;
                energy_cmd();
                break;
            case R.id.energy_reserve0 /* 2131428912 */:
                this.mCharge = 0;
                energy_cmd();
                break;
            case R.id.energy_reserve1 /* 2131428913 */:
                this.mCharge = 1;
                energy_cmd();
                break;
            case R.id.energy_mode_cycle /* 2131428914 */:
                this.CycleMode = 1;
                energy_cmd();
                break;
            case R.id.energy_mode_one /* 2131428915 */:
                this.CycleMode = 0;
                energy_cmd();
                break;
            case R.id.energy_time_set /* 2131428917 */:
                ((TimePicker) findViewById(R.id.timePicker0)).setCurrentHour(Integer.valueOf(this.ReserveStarH));
                ((TimePicker) findViewById(R.id.timePicker0)).setCurrentMinute(Integer.valueOf(this.ReserveStarM));
                ((TimePicker) findViewById(R.id.timePicker1)).setCurrentHour(Integer.valueOf(this.ReserveEndH));
                ((TimePicker) findViewById(R.id.timePicker1)).setCurrentMinute(Integer.valueOf(this.ReserveEndM));
                setViewVisible(findViewById(R.id.timePicker_view), true);
                break;
            case R.id.energy_cycle_date1 /* 2131428918 */:
                this.mWeek1 = this.mWeek1 == 0 ? 1 : 0;
                energy_cmd();
                break;
            case R.id.energy_cycle_date2 /* 2131428919 */:
                this.mWeek2 = this.mWeek2 != 0 ? 0 : 1;
                energy_cmd();
                break;
            case R.id.energy_cycle_date3 /* 2131428920 */:
                this.mWeek3 = this.mWeek3 != 0 ? 0 : 1;
                energy_cmd();
                break;
            case R.id.energy_cycle_date4 /* 2131428921 */:
                this.mWeek4 = this.mWeek4 != 0 ? 0 : 1;
                energy_cmd();
                break;
            case R.id.energy_cycle_date5 /* 2131428922 */:
                this.mWeek5 = this.mWeek5 != 0 ? 0 : 1;
                energy_cmd();
                break;
            case R.id.energy_cycle_date6 /* 2131428923 */:
                this.mWeek6 = this.mWeek6 != 0 ? 0 : 1;
                energy_cmd();
                break;
            case R.id.energy_cycle_date7 /* 2131428924 */:
                this.mWeek7 = this.mWeek7 != 0 ? 0 : 1;
                energy_cmd();
                break;
            case R.id.timePicker_confirm /* 2131428928 */:
                this.ReserveStarH = ((TimePicker) findViewById(R.id.timePicker0)).getCurrentHour().intValue();
                this.ReserveStarM = ((TimePicker) findViewById(R.id.timePicker0)).getCurrentMinute().intValue();
                this.ReserveEndH = ((TimePicker) findViewById(R.id.timePicker1)).getCurrentHour().intValue();
                this.ReserveEndM = ((TimePicker) findViewById(R.id.timePicker1)).getCurrentMinute().intValue();
                energy_cmd();
                setViewVisible(findViewById(R.id.timePicker_view), false);
                updaterReserveTime((this.ReserveStarH << 24) | (this.ReserveStarM << 16) | (this.ReserveEndH << 8) | this.ReserveEndM);
                break;
            case R.id.timePicker_cancel /* 2131428929 */:
                setViewVisible(findViewById(R.id.timePicker_view), false);
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
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterEnergyBack(int value) {
        this.mEnergyBack = value;
        switch (this.mEnergyBack) {
            case 0:
                ((Button) findViewById(R.id.energy_back1)).setBackgroundResource(R.drawable.ge3_btn2_p);
                ((Button) findViewById(R.id.energy_back2)).setBackgroundResource(R.drawable.ge3_btn2);
                ((Button) findViewById(R.id.energy_back3)).setBackgroundResource(R.drawable.ge3_btn2);
                break;
            case 1:
                ((Button) findViewById(R.id.energy_back1)).setBackgroundResource(R.drawable.ge3_btn2);
                ((Button) findViewById(R.id.energy_back2)).setBackgroundResource(R.drawable.ge3_btn2_p);
                ((Button) findViewById(R.id.energy_back3)).setBackgroundResource(R.drawable.ge3_btn2);
                break;
            case 2:
                ((Button) findViewById(R.id.energy_back1)).setBackgroundResource(R.drawable.ge3_btn2);
                ((Button) findViewById(R.id.energy_back2)).setBackgroundResource(R.drawable.ge3_btn2);
                ((Button) findViewById(R.id.energy_back3)).setBackgroundResource(R.drawable.ge3_btn2_p);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterEnergyCharge(int value) {
        this.mCharge = value;
        switch (this.mCharge) {
            case 0:
                ((Button) findViewById(R.id.energy_reserve0)).setBackgroundResource(R.drawable.ge3_btn1_p);
                ((Button) findViewById(R.id.energy_reserve1)).setBackgroundResource(R.drawable.ge3_btn1);
                break;
            case 1:
                ((Button) findViewById(R.id.energy_reserve0)).setBackgroundResource(R.drawable.ge3_btn1);
                ((Button) findViewById(R.id.energy_reserve1)).setBackgroundResource(R.drawable.ge3_btn1_p);
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
        ((TextView) findViewById(R.id.energy_time_show)).setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCycleMode(int value) {
        this.CycleMode = value;
        switch (this.CycleMode) {
            case 0:
                ((Button) findViewById(R.id.energy_mode_cycle)).setBackgroundResource(R.drawable.ge3_btn1);
                ((Button) findViewById(R.id.energy_mode_one)).setBackgroundResource(R.drawable.ge3_btn1_p);
                break;
            case 1:
                ((Button) findViewById(R.id.energy_mode_one)).setBackgroundResource(R.drawable.ge3_btn1);
                ((Button) findViewById(R.id.energy_mode_cycle)).setBackgroundResource(R.drawable.ge3_btn1_p);
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
        ((Button) findViewById(R.id.energy_cycle_date1)).setBackgroundResource(this.mWeek1 == 0 ? 2130838955 : 2130838956);
        ((Button) findViewById(R.id.energy_cycle_date2)).setBackgroundResource(this.mWeek2 == 0 ? 2130838955 : 2130838956);
        ((Button) findViewById(R.id.energy_cycle_date3)).setBackgroundResource(this.mWeek3 == 0 ? 2130838955 : 2130838956);
        ((Button) findViewById(R.id.energy_cycle_date4)).setBackgroundResource(this.mWeek4 == 0 ? 2130838955 : 2130838956);
        ((Button) findViewById(R.id.energy_cycle_date5)).setBackgroundResource(this.mWeek5 == 0 ? 2130838955 : 2130838956);
        ((Button) findViewById(R.id.energy_cycle_date6)).setBackgroundResource(this.mWeek6 == 0 ? 2130838955 : 2130838956);
        Button button = (Button) findViewById(R.id.energy_cycle_date7);
        if (this.mWeek7 != 0) {
            i = 2130838956;
        }
        button.setBackgroundResource(i);
    }
}
