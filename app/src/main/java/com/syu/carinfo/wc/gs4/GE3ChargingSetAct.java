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
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 130:
                    GE3ChargingSetAct.this.updaterEnergyCharge(value);
                    break;
                case 131:
                case 132:
                case 133:
                case 134:
                    GE3ChargingSetAct.this.updaterReserveTime();
                    break;
                case 135:
                    GE3ChargingSetAct.this.updaterCycleMode(value);
                    break;
                case 136:
                case 137:
                case 138:
                case 139:
                case 140:
                case 141:
                case 142:
                    GE3ChargingSetAct.this.updaterCycleDate();
                    break;
                case 143:
                    GE3ChargingSetAct.this.updaterEnergyBack(value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_165_xbs_gs3_energyset);
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

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.energy_show_btn /* 2131428733 */:
                try {
                    Intent intent = new Intent(this, (Class<?>) GS3EnergyFlowAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.energy_back1 /* 2131428734 */:
                this.mEnergyBack = 0;
                energy_cmd2();
                break;
            case R.id.energy_back2 /* 2131428735 */:
                this.mEnergyBack = 1;
                energy_cmd2();
                break;
            case R.id.energy_back3 /* 2131428736 */:
                this.mEnergyBack = 2;
                energy_cmd2();
                break;
            case R.id.energy_reserve0 /* 2131428737 */:
                this.mCharge = 0;
                energy_cmd();
                break;
            case R.id.energy_reserve1 /* 2131428738 */:
                this.mCharge = 1;
                energy_cmd();
                break;
            case R.id.energy_mode_cycle /* 2131428739 */:
                this.CycleMode = 1;
                energy_cmd();
                break;
            case R.id.energy_mode_one /* 2131428740 */:
                this.CycleMode = 0;
                energy_cmd();
                break;
            case R.id.energy_time_set /* 2131428742 */:
                ((TimePicker) findViewById(R.id.timePicker0)).setCurrentHour(Integer.valueOf(this.ReserveStarH));
                ((TimePicker) findViewById(R.id.timePicker0)).setCurrentMinute(Integer.valueOf(this.ReserveStarM));
                ((TimePicker) findViewById(R.id.timePicker1)).setCurrentHour(Integer.valueOf(this.ReserveEndH));
                ((TimePicker) findViewById(R.id.timePicker1)).setCurrentMinute(Integer.valueOf(this.ReserveEndM));
                setViewVisible(findViewById(R.id.timePicker_view), true);
                break;
            case R.id.energy_cycle_date1 /* 2131428743 */:
                this.mWeek1 = this.mWeek1 == 0 ? 1 : 0;
                energy_cmd();
                break;
            case R.id.energy_cycle_date2 /* 2131428744 */:
                this.mWeek2 = this.mWeek2 != 0 ? 0 : 1;
                energy_cmd();
                break;
            case R.id.energy_cycle_date3 /* 2131428745 */:
                this.mWeek3 = this.mWeek3 != 0 ? 0 : 1;
                energy_cmd();
                break;
            case R.id.energy_cycle_date4 /* 2131428746 */:
                this.mWeek4 = this.mWeek4 != 0 ? 0 : 1;
                energy_cmd();
                break;
            case R.id.energy_cycle_date5 /* 2131428747 */:
                this.mWeek5 = this.mWeek5 != 0 ? 0 : 1;
                energy_cmd();
                break;
            case R.id.energy_cycle_date6 /* 2131428748 */:
                this.mWeek6 = this.mWeek6 != 0 ? 0 : 1;
                energy_cmd();
                break;
            case R.id.energy_cycle_date7 /* 2131428749 */:
                this.mWeek7 = this.mWeek7 != 0 ? 0 : 1;
                energy_cmd();
                break;
            case R.id.timePicker_confirm /* 2131428753 */:
                this.ReserveStarH = ((TimePicker) findViewById(R.id.timePicker0)).getCurrentHour().intValue();
                this.ReserveStarM = ((TimePicker) findViewById(R.id.timePicker0)).getCurrentMinute().intValue();
                this.ReserveEndH = ((TimePicker) findViewById(R.id.timePicker1)).getCurrentHour().intValue();
                this.ReserveEndM = ((TimePicker) findViewById(R.id.timePicker1)).getCurrentMinute().intValue();
                energy_cmd();
                setViewVisible(findViewById(R.id.timePicker_view), false);
                break;
            case R.id.timePicker_cancel /* 2131428754 */:
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

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        AirHelper.disableAirWindowLocal(true);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
    }

    
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

    
    public void updaterReserveTime() {
        this.ReserveStarH = DataCanbus.DATA[131];
        this.ReserveStarM = DataCanbus.DATA[132];
        this.ReserveEndH = DataCanbus.DATA[133];
        this.ReserveEndM = DataCanbus.DATA[134];
        String str = String.valueOf(this.ReserveStarH / 10) + (this.ReserveStarH % 10) + ":" + (this.ReserveStarM / 10) + (this.ReserveStarM % 10) + " to " + (this.ReserveEndH / 10) + (this.ReserveEndH % 10) + ":" + (this.ReserveEndM / 10) + (this.ReserveEndM % 10);
        ((TextView) findViewById(R.id.energy_time_show)).setText(str);
    }

    
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

    
    public void updaterCycleDate() {
        int i = R.drawable.ge3_btn3;
        this.mWeek7 = DataCanbus.DATA[142];
        this.mWeek6 = DataCanbus.DATA[141];
        this.mWeek5 = DataCanbus.DATA[140];
        this.mWeek4 = DataCanbus.DATA[139];
        this.mWeek3 = DataCanbus.DATA[138];
        this.mWeek2 = DataCanbus.DATA[137];
        this.mWeek1 = DataCanbus.DATA[136];
        ((Button) findViewById(R.id.energy_cycle_date1)).setBackgroundResource(this.mWeek1 == 0 ? 2130838867 : 2130838868);
        ((Button) findViewById(R.id.energy_cycle_date2)).setBackgroundResource(this.mWeek2 == 0 ? 2130838867 : 2130838868);
        ((Button) findViewById(R.id.energy_cycle_date3)).setBackgroundResource(this.mWeek3 == 0 ? 2130838867 : 2130838868);
        ((Button) findViewById(R.id.energy_cycle_date4)).setBackgroundResource(this.mWeek4 == 0 ? 2130838867 : 2130838868);
        ((Button) findViewById(R.id.energy_cycle_date5)).setBackgroundResource(this.mWeek5 == 0 ? 2130838867 : 2130838868);
        ((Button) findViewById(R.id.energy_cycle_date6)).setBackgroundResource(this.mWeek6 == 0 ? 2130838867 : 2130838868);
        Button button = (Button) findViewById(R.id.energy_cycle_date7);
        if (this.mWeek7 != 0) {
            i = 2130838868;
        }
        button.setBackgroundResource(i);
    }
}
