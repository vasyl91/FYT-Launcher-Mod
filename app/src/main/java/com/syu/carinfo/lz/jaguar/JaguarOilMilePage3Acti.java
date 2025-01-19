package com.syu.carinfo.lz.jaguar;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class JaguarOilMilePage3Acti extends BaseActivity {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 117:
                    JaguarOilMilePage3Acti.this.mUpdaterValue1();
                    JaguarOilMilePage3Acti.this.mUpdaterValue2();
                    JaguarOilMilePage3Acti.this.mUpdaterValue3();
                    JaguarOilMilePage3Acti.this.mUpdaterValue1();
                    JaguarOilMilePage3Acti.this.mUpdaterValue2();
                    JaguarOilMilePage3Acti.this.mUpdaterValue3();
                    break;
                case 118:
                    JaguarOilMilePage3Acti.this.mUpdaterValue2();
                    JaguarOilMilePage3Acti.this.mUpdaterValue3();
                    JaguarOilMilePage3Acti.this.mUpdaterValue1();
                    JaguarOilMilePage3Acti.this.mUpdaterValue2();
                    JaguarOilMilePage3Acti.this.mUpdaterValue3();
                    break;
                case 119:
                    JaguarOilMilePage3Acti.this.mUpdaterValue3();
                    JaguarOilMilePage3Acti.this.mUpdaterValue1();
                    JaguarOilMilePage3Acti.this.mUpdaterValue2();
                    JaguarOilMilePage3Acti.this.mUpdaterValue3();
                    break;
                case 121:
                    JaguarOilMilePage3Acti.this.mUpdaterValue1();
                    JaguarOilMilePage3Acti.this.mUpdaterValue2();
                    JaguarOilMilePage3Acti.this.mUpdaterValue3();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_lz_jaguar_page3);
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(0, new int[]{13, 2}, null, null);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[117];
        int value1 = DataCanbus.DATA[121] & 255;
        if (findViewById(R.id.tv_text1) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.tv_text1)).setText("--.--");
            }
            switch (value1) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + "L/100KM");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)) + "mpg");
                    break;
            }
        }
    }

    
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[118];
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

    
    public void mUpdaterValue3() {
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
