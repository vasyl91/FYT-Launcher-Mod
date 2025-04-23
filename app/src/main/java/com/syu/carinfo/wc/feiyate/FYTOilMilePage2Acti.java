package com.syu.carinfo.wc.feiyate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class FYTOilMilePage2Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 102:
                case 113:
                    FYTOilMilePage2Acti.this.mUpdaterValue1();
                case 105:
                    FYTOilMilePage2Acti.this.mUpdaterValue2();
                case 104:
                    FYTOilMilePage2Acti.this.mUpdaterValue3();
                case 103:
                    FYTOilMilePage2Acti.this.mUpdaterValue4();
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
                DataCanbus.PROXY.cmd(2, new int[]{2}, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[102];
        int value1 = DataCanbus.DATA[113] & 255;
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv1)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv1)).setText("--.--");
            }
            switch (value1) {
                case 0:
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "L/100KM");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "km/l");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "mpg(us)");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "mpg(uk)");
                    break;
            }
        }
    }

    
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[105];
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv2)) != null) {
            if (value == 16777215) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv2)).setText("----");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv2)).setText(String.valueOf((value >> 8) & 65535) + "H " + (value & 255) + "M");
            }
        }
    }

    
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[104];
        int unit = DataCanbus.DATA[112] & 255;
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv3)) != null) {
            if (value == 16777215) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv3)).setText("----");
            } else if (unit == 1) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv3)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " KM");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv3)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " Mil");
            }
        }
    }

    
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[103];
        int unit = DataCanbus.DATA[112] & 255;
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv4)) != null) {
            if (value == 255) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv4)).setText("----");
            } else if (unit == 1) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv4)).setText(String.valueOf(value) + " KM/H");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv4)).setText(String.valueOf(value) + " Mil/H");
            }
        }
    }
}
