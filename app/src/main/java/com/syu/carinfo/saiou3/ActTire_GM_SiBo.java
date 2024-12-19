package com.syu.carinfo.saiou3;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActTire_GM_SiBo extends BaseActivity {
    int[] resId = {81, 82, 83, 84};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.saiou3.ActTire_GM_SiBo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 81:
                    ActTire_GM_SiBo.this.u1(val);
                    break;
                case 82:
                    ActTire_GM_SiBo.this.u2(val);
                    break;
                case 83:
                    ActTire_GM_SiBo.this.u3(val);
                    break;
                case 84:
                    ActTire_GM_SiBo.this.u4(val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf_tire_wc);
    }

    private View bindView(int id) {
        View v = findViewById(id);
        return v;
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        for (int i : this.resId) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        for (int i : this.resId) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1(int val) {
        TextView v = (TextView) bindView(R.id.rzc_golf_tv_car_tire_0);
        if (v != null) {
            v.setText(String.valueOf(val) + "Kpa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u2(int val) {
        TextView v = (TextView) bindView(R.id.rzc_golf_tv_car_tire_1);
        if (v != null) {
            v.setText(String.valueOf(val) + "Kpa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u3(int val) {
        TextView v = (TextView) bindView(R.id.rzc_golf_tv_car_tire_2);
        if (v != null) {
            v.setText(String.valueOf(val) + "Kpa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u4(int val) {
        TextView v = (TextView) bindView(R.id.rzc_golf_tv_car_tire_3);
        if (v != null) {
            v.setText(String.valueOf(val) + "Kpa");
        }
    }
}
