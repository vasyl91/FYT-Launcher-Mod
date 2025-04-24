package com.syu.carinfo.wc2.ruiqi;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class WCNissanRuiqi6CarInfo extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    ((TextView) WCNissanRuiqi6CarInfo.this.findViewById(R.id.avg_fuel)).setText(String.valueOf(value / 10) + "." + (value % 10) + CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                    break;
                case 100:
                    if (value == 16777215) {
                        ((TextView) WCNissanRuiqi6CarInfo.this.findViewById(R.id.mileage)).setText("----km");
                        break;
                    } else {
                        ((TextView) WCNissanRuiqi6CarInfo.this.findViewById(R.id.mileage)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km");
                        break;
                    }
                case 101:
                    ((TextView) WCNissanRuiqi6CarInfo.this.findViewById(R.id.avg_speed)).setText(String.valueOf(value) + "km/h");
                    break;
                case 102:
                    ((TextView) WCNissanRuiqi6CarInfo.this.findViewById(R.id.voltage)).setText(String.valueOf(value / 10) + "." + (value % 10) + " V");
                    break;
                case 103:
                    ((TextView) WCNissanRuiqi6CarInfo.this.findViewById(R.id.current)).setText(String.valueOf(value / 10) + "." + (value % 10) + " A");
                    break;
                case 104:
                    ((TextView) WCNissanRuiqi6CarInfo.this.findViewById(R.id.soc_value)).setText(String.valueOf(value) + "%");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_ruiqi_carinfo);
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

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
    }
}
