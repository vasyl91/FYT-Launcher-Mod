package com.syu.carinfo.saiou3;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActFuel_GM_SiBo extends BaseActivity {
    int[] resids = {144, 145, 146, 147};
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 144:
                    ActFuel_GM_SiBo.this.uAverageFuel(val);
                    break;
                case 145:
                    ActFuel_GM_SiBo.this.uInstantFuel(val);
                    break;
                case 146:
                    ActFuel_GM_SiBo.this.uFuelMiles(val);
                    break;
                case 147:
                    ActFuel_GM_SiBo.this.uTotalMiles(val);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_sb_gm_oil_trip_info);
    }

    @Override
    public void addNotify() {
        for (int i : this.resids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.notifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        for (int i : this.resids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.notifyCanbus);
        }
    }

    protected void uAverageFuel(int val) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(val * 0.1f) + "L/H");
        }
    }

    protected void uInstantFuel(int val) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(val * 0.1f) + "L/H");
        }
    }

    protected void uTotalMiles(int val) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(val) + "Km");
        }
    }

    protected void uFuelMiles(int val) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(val) + "Km");
        }
    }
}
