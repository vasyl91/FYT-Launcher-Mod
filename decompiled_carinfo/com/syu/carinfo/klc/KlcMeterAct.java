package com.syu.carinfo.klc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class KlcMeterAct extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 142:
                    KlcMeterAct.this.updateECOZhishiSet();
                    break;
                case 143:
                    KlcMeterAct.this.updateYiBiaoInfoSet();
                    break;
                case 144:
                    KlcMeterAct.this.updateSpeedModeSet();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_klc_meter_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.klc_btn_eco_Instructio_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_btn_Instrument_navigation_information_display_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_meter_Speed_Range_Tips_check)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.klc_btn_eco_Instructio_check /* 2131431901 */:
                int valEcoIns = DataCanbus.DATA[142] & 255;
                KlcFunc.C_CAR_METER(1, valEcoIns == 0 ? 1 : 0);
                break;
            case R.id.klc_btn_Instrument_navigation_information_display_check /* 2131431903 */:
                int valInsInfo = DataCanbus.DATA[143] & 255;
                KlcFunc.C_CAR_METER(2, valInsInfo != 0 ? 0 : 1);
                break;
            case R.id.klc_meter_Speed_Range_Tips_check /* 2131431905 */:
                int valSpeed = DataCanbus.DATA[144] & 255;
                KlcFunc.C_CAR_METER(3, valSpeed != 0 ? 0 : 1);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addUpdater();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateECOZhishiSet() {
        int val = DataCanbus.DATA[142];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (DataCanbus.DATA[1000] == 254) {
            enable = 1;
        }
        if (enable == 0) {
            findViewById(R.id.klc_btn_eco_Instructio_View).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.klc_btn_eco_Instructio_View).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.klc_btn_eco_Instructio_check)).setChecked(switchOn != 0);
        }
    }

    
    public void updateYiBiaoInfoSet() {
        int val = DataCanbus.DATA[143];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (DataCanbus.DATA[1000] == 254) {
            enable = 1;
        }
        if (enable == 0) {
            findViewById(R.id.klc_btn_Instrument_navigation_information_display_View).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.klc_btn_Instrument_navigation_information_display_View).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.klc_btn_Instrument_navigation_information_display_check)).setChecked(switchOn != 0);
        }
    }

    
    public void updateSpeedModeSet() {
        int val = DataCanbus.DATA[144];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (DataCanbus.DATA[1000] == 254) {
            enable = 1;
        }
        if (enable == 0) {
            findViewById(R.id.klc_meter_Speed_Range_Tips_view).setVisibility(8);
            return;
        }
        if (enable == 1) {
            findViewById(R.id.klc_meter_Speed_Range_Tips_view).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.klc_meter_Speed_Range_Tips_check)).setChecked(switchOn != 0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.klc_meter_Speed_Range_Tips_Tv)).setText(R.string.klc_meter_Speed_Range_Tips_all);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.klc_meter_Speed_Range_Tips_Tv)).setText(R.string.klc_meter_Speed_Range_Tips_little);
            }
        }
    }
}
