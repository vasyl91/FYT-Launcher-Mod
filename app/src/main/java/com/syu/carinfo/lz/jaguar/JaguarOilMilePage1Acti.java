package com.syu.carinfo.lz.jaguar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class JaguarOilMilePage1Acti extends BaseActivity {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 111:
                    JaguarOilMilePage1Acti.this.mUpdaterOilExpend();
                case 112:
                    JaguarOilMilePage1Acti.this.mUpdaterMileage();
                case 113:
                    JaguarOilMilePage1Acti.this.mUpdaterSpeed();
                case 121:
                    JaguarOilMilePage1Acti.this.mUpdaterOilExpend();
                    JaguarOilMilePage1Acti.this.mUpdaterMileage();
                    JaguarOilMilePage1Acti.this.mUpdaterSpeed();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_lz_jaguar_page1);
        findViewById(R.id.psa_all_btn_oil_page1_btn).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{9}, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(0, new int[]{13}, null, null);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterOilExpend() {
        int value = DataCanbus.DATA[111];
        int unit = DataCanbus.DATA[121] & 255;
        if (findViewById(R.id.tv_text1) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.tv_text1)).setText("--.--");
            }
            switch (unit) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + "L/100KM");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + "mpg");
                    break;
            }
        }
    }

    
    public void mUpdaterMileage() {
        int value = DataCanbus.DATA[112];
        int unit = DataCanbus.DATA[121] & 255;
        if (findViewById(R.id.tv_text2) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.tv_text2)).setText("----");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.tv_text2)).setText(String.format("%d", Integer.valueOf(value)) + " km");
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText(String.format("%d", Integer.valueOf(value)) + " miles");
            }
        }
    }

    
    public void mUpdaterSpeed() {
        int value = DataCanbus.DATA[113];
        int unit = DataCanbus.DATA[121];
        if (findViewById(R.id.tv_text3) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.tv_text3)).setText("----");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.tv_text3)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " km/h");
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + " mph");
            }
        }
    }
}
