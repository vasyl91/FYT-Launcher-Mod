package com.syu.carinfo.psa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class PsaOilMilePage2Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 99:
                    PsaOilMilePage2Acti.this.mUpdaterValue2();
                    break;
                case 100:
                    PsaOilMilePage2Acti.this.mUpdaterValue3();
                    break;
                case 104:
                    PsaOilMilePage2Acti.this.mUpdaterValue1();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_psa_oil_page2);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.psa_btn_oil_page2_btn)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(24, new int[]{2}, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[104];
        if (DataCanbus.DATA[1000] == 12) {
            if (((TextView) findViewById(R.id.psa_tv_oil_page2_tv1)) != null) {
                if (value == 65535) {
                    ((TextView) findViewById(R.id.psa_tv_oil_page2_tv1)).setText("--.--");
                    return;
                } else {
                    ((TextView) findViewById(R.id.psa_tv_oil_page2_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf((value >> 8) & 255), Integer.valueOf(value & 255))) + " L/100KM");
                    return;
                }
            }
            return;
        }
        if (((TextView) findViewById(R.id.psa_tv_oil_page2_tv1)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa_tv_oil_page2_tv1)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.psa_tv_oil_page2_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " L/100KM");
            }
        }
    }

    
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[99];
        if (((TextView) findViewById(R.id.psa_tv_oil_page2_tv2)) != null) {
            if (value == 255) {
                ((TextView) findViewById(R.id.psa_tv_oil_page2_tv2)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.psa_tv_oil_page2_tv2)).setText(String.valueOf(value) + " Km/h");
            }
        }
    }

    
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[100];
        if (((TextView) findViewById(R.id.psa_tv_oil_page2_tv3)) != null) {
            if (value > 9999) {
                value = 9999;
            }
            ((TextView) findViewById(R.id.psa_tv_oil_page2_tv3)).setText(String.valueOf(value) + " KM");
        }
    }
}
