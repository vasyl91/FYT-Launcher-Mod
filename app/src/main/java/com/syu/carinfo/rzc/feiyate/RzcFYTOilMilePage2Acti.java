package com.syu.carinfo.rzc.feiyate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RzcFYTOilMilePage2Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 100:
                case 118:
                    RzcFYTOilMilePage2Acti.this.mUpdaterValue1();
                    RzcFYTOilMilePage2Acti.this.mUpdaterValue2();
                    RzcFYTOilMilePage2Acti.this.mUpdaterValue3();
                    RzcFYTOilMilePage2Acti.this.mUpdaterValue4();
                    RzcFYTOilMilePage2Acti.this.mUpdaterValue3();
                    RzcFYTOilMilePage2Acti.this.mUpdaterValue4();
                    break;
                case 101:
                    RzcFYTOilMilePage2Acti.this.mUpdaterValue3();
                    RzcFYTOilMilePage2Acti.this.mUpdaterValue4();
                    break;
                case 119:
                    RzcFYTOilMilePage2Acti.this.mUpdaterValue4();
                    RzcFYTOilMilePage2Acti.this.mUpdaterValue3();
                    RzcFYTOilMilePage2Acti.this.mUpdaterValue4();
                    break;
                case 120:
                    RzcFYTOilMilePage2Acti.this.mUpdaterValue3();
                    RzcFYTOilMilePage2Acti.this.mUpdaterValue4();
                    RzcFYTOilMilePage2Acti.this.mUpdaterValue3();
                    RzcFYTOilMilePage2Acti.this.mUpdaterValue4();
                    break;
                case 121:
                    RzcFYTOilMilePage2Acti.this.mUpdaterValue2();
                    RzcFYTOilMilePage2Acti.this.mUpdaterValue3();
                    RzcFYTOilMilePage2Acti.this.mUpdaterValue4();
                    RzcFYTOilMilePage2Acti.this.mUpdaterValue3();
                    RzcFYTOilMilePage2Acti.this.mUpdaterValue4();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_fyt_all_oil_page2);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.psa_all_btn_oil_page2_btn)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{241, 1}, null, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{80, 1}, null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[118];
        int value1 = DataCanbus.DATA[100] & 255;
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv1)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv1)).setText("--.--");
            }
            switch (value1) {
                case 0:
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "km/l");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "L/100KM");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "mpg(uk)");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "mpg(us)");
                    break;
            }
        }
    }

    
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[121];
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv2)) != null) {
            if (value == 16777215) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv2)).setText("----");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv2)).setText(String.valueOf((value >> 8) & 65535) + "H " + (value & 255) + "M");
            }
        }
    }

    
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[120];
        int unit = DataCanbus.DATA[101] & 255;
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv3)) != null) {
            if (value == 16777215) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv3)).setText("----");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv3)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " KM");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv3)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " Mil");
            }
        }
    }

    
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[119];
        int unit = DataCanbus.DATA[101] & 255;
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv4)) != null) {
            if (value == 255) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv4)).setText("----");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv4)).setText(String.valueOf(value) + " KM/H");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv4)).setText(String.valueOf(value) + " Mil/H");
            }
        }
    }
}
