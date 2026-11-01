package com.syu.carinfo.hc.tianlai;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityTianLaiCarInfo extends BaseActivity {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 119:
                    ActivityTianLaiCarInfo.this.uSpeed(value);
                    break;
                case 121:
                    ActivityTianLaiCarInfo.this.uMiles(value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_327_hc_tianlai_info);
        setListener();
    }

    private void setListener() {
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
    }

    protected void uSpeed(int value) {
        if (findViewById(R.id.tv_text1) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(value * 0.1f + "Km/h");
        }
    }

    protected void uMiles(int value) {
        if (findViewById(R.id.tv_text2) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(value * 0.1f + "Km");
        }
    }
}
