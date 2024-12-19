package com.syu.carinfo.hava;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.text.DecimalFormat;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityHavaRZCH2SCarInfo extends Activity {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.hava.ActivityHavaRZCH2SCarInfo.1
        int b1;
        int b2;
        int value;

        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 87:
                    if (((TextView) ActivityHavaRZCH2SCarInfo.this.findViewById(R.id.tv_havah2s_battery_voltage)) != null) {
                        DecimalFormat df = new DecimalFormat("#.#");
                        this.b1 = this.value * 25;
                        if ((this.value * 25) % 10 >= 5) {
                            this.b1 += 5;
                        }
                        ((TextView) ActivityHavaRZCH2SCarInfo.this.findViewById(R.id.tv_havah2s_battery_voltage)).setText(String.valueOf(df.format(this.b1 / 100.0f)) + "V");
                        break;
                    }
                case 88:
                    if (((TextView) ActivityHavaRZCH2SCarInfo.this.findViewById(R.id.tv_havah2s_coolant_temp)) != null) {
                        DecimalFormat df2 = new DecimalFormat("#.#");
                        this.b2 = this.value * 75;
                        if ((this.value * 75) % 10 >= 5) {
                            if ((this.value * 0.75d) - 48.0d > 0.0d) {
                                this.b2 += 5;
                            } else {
                                this.b2 -= 5;
                            }
                        }
                        ((TextView) ActivityHavaRZCH2SCarInfo.this.findViewById(R.id.tv_havah2s_coolant_temp)).setText(String.valueOf(df2.format((this.b2 / 100.0f) - 48.0f)) + "℃");
                        break;
                    }
                case 89:
                    if (((TextView) ActivityHavaRZCH2SCarInfo.this.findViewById(R.id.tv_havah2s_trans_oil_temp)) != null) {
                        if (this.value == 0) {
                            ((TextView) ActivityHavaRZCH2SCarInfo.this.findViewById(R.id.tv_havah2s_trans_oil_temp)).setText("--.- ℃");
                            break;
                        } else {
                            ((TextView) ActivityHavaRZCH2SCarInfo.this.findViewById(R.id.tv_havah2s_trans_oil_temp)).setText(String.valueOf(this.value - 40) + " ℃");
                            break;
                        }
                    }
                    break;
                case 147:
                    if (((TextView) ActivityHavaRZCH2SCarInfo.this.findViewById(R.id.tv_text1)) != null) {
                        this.value *= 59;
                        ((TextView) ActivityHavaRZCH2SCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(this.value / 100) + "." + ((this.value % 100) / 10) + "Kpa");
                        break;
                    }
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_244_havah2s_info);
        if (1376500 != DataCanbus.DATA[1000] && 1507572 != DataCanbus.DATA[1000] && 2228468 != DataCanbus.DATA[1000] && 1310964 != DataCanbus.DATA[1000] && 1638644 != DataCanbus.DATA[1000] && 1704180 != DataCanbus.DATA[1000] && 1769716 != DataCanbus.DATA[1000] && 2097396 != DataCanbus.DATA[1000] && 2162932 != DataCanbus.DATA[1000]) {
            findViewById(R.id.layout_view1).setVisibility(8);
        } else {
            findViewById(R.id.layout_view1).setVisibility(0);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
    }
}
