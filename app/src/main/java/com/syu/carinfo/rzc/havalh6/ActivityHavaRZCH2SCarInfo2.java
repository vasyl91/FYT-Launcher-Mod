package com.syu.carinfo.rzc.havalh6;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.text.DecimalFormat;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityHavaRZCH2SCarInfo2 extends Activity {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        int b1;
        int b2;
        int value;

        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 118:
                    if (((TextView) ActivityHavaRZCH2SCarInfo2.this.findViewById(R.id.tv_havah2s_coolant_temp)) != null) {
                        DecimalFormat df = new DecimalFormat("#.#");
                        this.b2 = this.value * 75;
                        if ((this.value * 75) % 10 >= 5) {
                            if ((this.value * 0.75d) - 48.0d > 0.0d) {
                                this.b2 += 5;
                            } else {
                                this.b2 -= 5;
                            }
                        }
                        ((TextView) ActivityHavaRZCH2SCarInfo2.this.findViewById(R.id.tv_havah2s_coolant_temp)).setText(String.valueOf(df.format((this.b2 / 100.0f) - 48.0f)) + "℃");
                        break;
                    }
                case 119:
                    if (((TextView) ActivityHavaRZCH2SCarInfo2.this.findViewById(R.id.tv_havah2s_trans_oil_temp)) != null) {
                        ((TextView) ActivityHavaRZCH2SCarInfo2.this.findViewById(R.id.tv_havah2s_trans_oil_temp)).setText(String.valueOf(this.value - 40) + " ℃");
                        break;
                    }
                case 120:
                    if (((TextView) ActivityHavaRZCH2SCarInfo2.this.findViewById(R.id.tv_havah2s_battery_voltage)) != null) {
                        DecimalFormat df2 = new DecimalFormat("#.#");
                        this.b1 = this.value * 25;
                        if ((this.value * 25) % 10 >= 5) {
                            this.b1 += 5;
                        }
                        ((TextView) ActivityHavaRZCH2SCarInfo2.this.findViewById(R.id.tv_havah2s_battery_voltage)).setText(String.valueOf(df2.format(this.b1 / 100.0f)) + "V");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_244_havah2s_info);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
    }
}
