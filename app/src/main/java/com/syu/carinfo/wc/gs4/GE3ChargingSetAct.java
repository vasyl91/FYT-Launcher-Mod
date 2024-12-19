package com.syu.carinfo.wc.gs4;

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
public class GE3ChargingSetAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
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
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.gs4.GE3ChargingSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 57:
                    GE3ChargingSetAct.this.updaterEnergyCharge(value);
                    break;
                case 58:
                case 59:
                case 60:
                case 61:
                    GE3ChargingSetAct.this.updaterReserveTime();
                    break;
                case 62:
                    GE3ChargingSetAct.this.updaterCycleMode(value);
                    break;
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                    GE3ChargingSetAct.this.updaterCycleDate();
                    break;
                case 70:
                    GE3ChargingSetAct.this.updaterEnergyBack(value);
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
                energy_cmd2();
                break;
            case R.id.energy_back2 /* 2131428699 */:
                this.mEnergyBack = 1;
                energy_cmd2();
                break;
            case R.id.energy_back3 /* 2131428700 */:
                this.mEnergyBack = 2;
                energy_cmd2();
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
                ((TimePicker) findViewById(R.id.timePicker0)).setCurrentHour(Integer.valueOf(this.ReserveStarH));
                ((TimePicker) findViewById(R.id.timePicker0)).setCurrentMinute(Integer.valueOf(this.ReserveStarM));
                ((TimePicker) findViewById(R.id.timePicker1)).setCurrentHour(Integer.valueOf(this.ReserveEndH));
                ((TimePicker) findViewById(R.id.timePicker1)).setCurrentMinute(Integer.valueOf(this.ReserveEndM));
                setViewVisible(findViewById(R.id.timePicker_view), true);
                break;
            case R.id.energy_cycle_date1 /* 2131428707 */:
                this.mWeek1 = this.mWeek1 == 0 ? 1 : 0;
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
                this.ReserveStarH = ((TimePicker) findViewById(R.id.timePicker0)).getCurrentHour().intValue();
                this.ReserveStarM = ((TimePicker) findViewById(R.id.timePicker0)).getCurrentMinute().intValue();
                this.ReserveEndH = ((TimePicker) findViewById(R.id.timePicker1)).getCurrentHour().intValue();
                this.ReserveEndM = ((TimePicker) findViewById(R.id.timePicker1)).getCurrentMinute().intValue();
                energy_cmd();
                setViewVisible(findViewById(R.id.timePicker_view), false);
                break;
            case R.id.timePicker_cancel /* 2131428718 */:
                setViewVisible(findViewById(R.id.timePicker_view), false);
                break;
        }
    }

    public void energy_cmd() {
        int[] date = {this.mCharge & 1, this.ReserveStarH & 255, this.ReserveStarM & 255, this.ReserveEndH & 255, this.ReserveEndM & 255, ((this.mWeek7 & 1) << 6) | ((this.mWeek6 & 1) << 5) | ((this.mWeek5 & 1) << 4) | ((this.mWeek4 & 1) << 3) | ((this.mWeek2 & 3) << 2) | ((this.mWeek2 & 1) << 1) | ((this.mWeek1 & 1) << 0) | ((this.CycleMode & 1) << 7)};
        DataCanbus.PROXY.cmd(5, new int[]{date[0], date[1], date[2], date[3], date[4], date[5]}, null, null);
    }

    public void energy_cmd2() {
        DataCanbus.PROXY.cmd(6, new int[]{1, this.mEnergyBack}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
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
    public void updaterReserveTime() {
        this.ReserveStarH = DataCanbus.DATA[58];
        this.ReserveStarM = DataCanbus.DATA[59];
        this.ReserveEndH = DataCanbus.DATA[60];
        this.ReserveEndM = DataCanbus.DATA[61];
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
    public void updaterCycleDate() {
        int i = R.drawable.ge3_btn3;
        this.mWeek7 = DataCanbus.DATA[69];
        this.mWeek6 = DataCanbus.DATA[68];
        this.mWeek5 = DataCanbus.DATA[67];
        this.mWeek4 = DataCanbus.DATA[66];
        this.mWeek3 = DataCanbus.DATA[65];
        this.mWeek2 = DataCanbus.DATA[64];
        this.mWeek1 = DataCanbus.DATA[63];
        ((Button) findViewById(R.id.energy_cycle_date1)).setBackgroundResource(this.mWeek1 == 0 ? 2130838694 : 2130838695);
        ((Button) findViewById(R.id.energy_cycle_date2)).setBackgroundResource(this.mWeek2 == 0 ? 2130838694 : 2130838695);
        ((Button) findViewById(R.id.energy_cycle_date3)).setBackgroundResource(this.mWeek3 == 0 ? 2130838694 : 2130838695);
        ((Button) findViewById(R.id.energy_cycle_date4)).setBackgroundResource(this.mWeek4 == 0 ? 2130838694 : 2130838695);
        ((Button) findViewById(R.id.energy_cycle_date5)).setBackgroundResource(this.mWeek5 == 0 ? 2130838694 : 2130838695);
        ((Button) findViewById(R.id.energy_cycle_date6)).setBackgroundResource(this.mWeek6 == 0 ? 2130838694 : 2130838695);
        Button button = (Button) findViewById(R.id.energy_cycle_date7);
        if (this.mWeek7 != 0) {
            i = 2130838695;
        }
        button.setBackgroundResource(i);
    }
}
