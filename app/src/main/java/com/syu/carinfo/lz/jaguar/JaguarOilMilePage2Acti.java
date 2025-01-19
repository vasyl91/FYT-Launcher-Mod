package com.syu.carinfo.lz.jaguar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class JaguarOilMilePage2Acti extends BaseActivity {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 114:
                    JaguarOilMilePage2Acti.this.mUpdaterValue1();
                    JaguarOilMilePage2Acti.this.mUpdaterValue2();
                    JaguarOilMilePage2Acti.this.mUpdaterValue3();
                    JaguarOilMilePage2Acti.this.mUpdaterValue1();
                    JaguarOilMilePage2Acti.this.mUpdaterValue2();
                    JaguarOilMilePage2Acti.this.mUpdaterValue3();
                    break;
                case 115:
                    JaguarOilMilePage2Acti.this.mUpdaterValue2();
                    JaguarOilMilePage2Acti.this.mUpdaterValue3();
                    JaguarOilMilePage2Acti.this.mUpdaterValue1();
                    JaguarOilMilePage2Acti.this.mUpdaterValue2();
                    JaguarOilMilePage2Acti.this.mUpdaterValue3();
                    break;
                case 116:
                    JaguarOilMilePage2Acti.this.mUpdaterValue3();
                    JaguarOilMilePage2Acti.this.mUpdaterValue1();
                    JaguarOilMilePage2Acti.this.mUpdaterValue2();
                    JaguarOilMilePage2Acti.this.mUpdaterValue3();
                    break;
                case 121:
                    JaguarOilMilePage2Acti.this.mUpdaterValue1();
                    JaguarOilMilePage2Acti.this.mUpdaterValue2();
                    JaguarOilMilePage2Acti.this.mUpdaterValue3();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_lz_jaguar_page2);
        init();
    }

    @Override
    public void init() {
        findViewById(R.id.psa_all_btn_oil_page2_btn).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{9, 1}, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(0, new int[]{13, 1}, null, null);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[114];
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
        int value = DataCanbus.DATA[115];
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
        int value = DataCanbus.DATA[116];
        int unit = DataCanbus.DATA[121] & 255;
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
