package com.syu.carinfo.psa_all;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class PSAOilMilePage3Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 103:
                case 172:
                    PSAOilMilePage3Acti.this.mUpdaterValue1();
                    break;
                case 105:
                    PSAOilMilePage3Acti.this.mUpdaterValue2();
                    break;
                case 106:
                    PSAOilMilePage3Acti.this.mUpdaterValue3();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_psa_all_oil_page3);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.psa_all_btn_oil_page3_btn)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(90, new int[]{3}, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[103];
        int value1 = DataCanbus.DATA[172];
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv1)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv1)).setText("--.--");
            }
            switch (value1) {
                case 2:
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "km/l");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "mpg");
                    break;
                default:
                    ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "L/100KM");
                    break;
            }
        }
    }

    
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[105];
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv2)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv2)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv2)).setText(String.valueOf(value) + " KM");
            }
        }
    }

    
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[106];
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv3)) != null) {
            if (value == 255) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv3)).setText("--.--");
                return;
            }
            if (value < 0) {
                value = 0;
            } else if (value > 9999) {
                value = 9999;
            }
            ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv3)).setText(String.valueOf(value) + " KM");
        }
    }
}
