package com.syu.carinfo.klc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class KlcMeterAct extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.klc.KlcMeterAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 45:
                    KlcMeterAct.this.updateECOZhishiSet();
                    break;
                case 46:
                    KlcMeterAct.this.updateYiBiaoInfoSet();
                    break;
                case 47:
                    KlcMeterAct.this.updateSpeedModeSet();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_klc_meter_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.klc_btn_eco_Instructio_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_btn_Instrument_navigation_information_display_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_meter_Speed_Range_Tips_check)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.klc_btn_eco_Instructio_check /* 2131431951 */:
                int valEcoIns = DataCanbus.DATA[45] & 255;
                KlcFunc.C_CAR_METER(1, valEcoIns == 0 ? 1 : 0);
                break;
            case R.id.klc_btn_Instrument_navigation_information_display_check /* 2131431953 */:
                int valInsInfo = DataCanbus.DATA[46] & 255;
                KlcFunc.C_CAR_METER(2, valInsInfo != 0 ? 0 : 1);
                break;
            case R.id.klc_meter_Speed_Range_Tips_check /* 2131431955 */:
                int valSpeed = DataCanbus.DATA[47] & 255;
                KlcFunc.C_CAR_METER(3, valSpeed != 0 ? 0 : 1);
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
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateECOZhishiSet() {
        int val = DataCanbus.DATA[45];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateYiBiaoInfoSet() {
        int val = DataCanbus.DATA[46];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpeedModeSet() {
        int val = DataCanbus.DATA[47];
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
