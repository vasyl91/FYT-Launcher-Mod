package com.syu.carinfo.saiou3;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActTire_GM_SiBo extends BaseActivity {
    int[] resId = {140, 141, 142, 143};
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 140:
                    ActTire_GM_SiBo.this.u1(val);
                    break;
                case 141:
                    ActTire_GM_SiBo.this.u2(val);
                    break;
                case 142:
                    ActTire_GM_SiBo.this.u3(val);
                    break;
                case 143:
                    ActTire_GM_SiBo.this.u4(val);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf_tire_wc);
    }

    private View bindView(int id) {
        View v = findViewById(id);
        return v;
    }

    @Override
    public void addNotify() {
        for (int i : this.resId) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        for (int i : this.resId) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }

    
    public void u1(int val) {
        TextView v = (TextView) bindView(R.id.rzc_golf_tv_car_tire_0);
        if (v != null) {
            v.setText(String.valueOf(val) + "Kpa");
        }
    }

    
    public void u2(int val) {
        TextView v = (TextView) bindView(R.id.rzc_golf_tv_car_tire_1);
        if (v != null) {
            v.setText(String.valueOf(val) + "Kpa");
        }
    }

    
    public void u3(int val) {
        TextView v = (TextView) bindView(R.id.rzc_golf_tv_car_tire_2);
        if (v != null) {
            v.setText(String.valueOf(val) + "Kpa");
        }
    }

    
    public void u4(int val) {
        TextView v = (TextView) bindView(R.id.rzc_golf_tv_car_tire_3);
        if (v != null) {
            v.setText(String.valueOf(val) + "Kpa");
        }
    }
}
