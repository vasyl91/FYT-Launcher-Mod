package com.syu.carinfo.saiou3;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActFuel_GM_SiBo extends BaseActivity {
    int[] resids = {85, 86, 87, 88};
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.saiou3.ActFuel_GM_SiBo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 85:
                    ActFuel_GM_SiBo.this.uAverageFuel(val);
                    break;
                case 86:
                    ActFuel_GM_SiBo.this.uInstantFuel(val);
                    break;
                case 87:
                    ActFuel_GM_SiBo.this.uFuelMiles(val);
                    break;
                case 88:
                    ActFuel_GM_SiBo.this.uTotalMiles(val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sb_gm_oil_trip_info);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        for (int i : this.resids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.notifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
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
