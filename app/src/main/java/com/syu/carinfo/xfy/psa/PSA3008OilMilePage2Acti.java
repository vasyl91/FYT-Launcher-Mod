package com.syu.carinfo.xfy.psa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class PSA3008OilMilePage2Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 113:
                    PSA3008OilMilePage2Acti.this.mUpdaterValue1();
                case 114:
                    PSA3008OilMilePage2Acti.this.mUpdaterValue2();
                case 115:
                    PSA3008OilMilePage2Acti.this.mUpdaterValue3();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_psa_all_oil_page2);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.psa_all_btn_oil_page2_btn)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{65}, null, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, 81);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[113];
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv1)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv1)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "L/100KM");
            }
        }
    }

    
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[114];
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv2)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv2)).setText("----");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv2)).setText(String.valueOf(value) + CamryData.SPEED_UNIT_KM);
            }
        }
    }

    
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[115];
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv3)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv3)).setText("----");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page2_tv3)).setText(String.valueOf(value) + " KM");
            }
        }
    }
}
