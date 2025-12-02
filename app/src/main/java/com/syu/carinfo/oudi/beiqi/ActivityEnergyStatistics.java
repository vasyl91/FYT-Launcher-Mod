package com.syu.carinfo.oudi.beiqi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityEnergyStatistics extends Activity {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 102:
                    ActivityEnergyStatistics.this.updateEnergyCurStatistics();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_227_energy_statistics);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    protected void onPause() {
        super.onPause();
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateEnergyCurStatistics() {
    }

    private void updateEnergyStatistics(int value) {
        if (((TextView) findViewById(R.id.tv_227_energy_statistics)) != null) {
            ((TextView) findViewById(R.id.tv_227_energy_statistics)).setText(String.valueOf(value) + "   W");
        }
    }
}
