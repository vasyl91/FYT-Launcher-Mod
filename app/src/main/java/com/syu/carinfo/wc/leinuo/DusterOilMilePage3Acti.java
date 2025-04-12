package com.syu.carinfo.wc.leinuo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class DusterOilMilePage3Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 104:
                case 105:
                    DusterOilMilePage3Acti.this.mUpdaterValue1();
                case 106:
                    DusterOilMilePage3Acti.this.mUpdaterValue2();
                case 107:
                    DusterOilMilePage3Acti.this.mUpdaterValue3();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_duster_all_oil_page3);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.psa_all_btn_oil_page3_btn)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{1}, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[104];
        int value1 = DataCanbus.DATA[105];
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv1)) != null) {
            if (value == 255 || value1 == 65535) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv1)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv1)).setText(String.valueOf(value1) + " H " + value + " M");
            }
        }
    }

    
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[106];
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv2)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv2)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv2)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " L");
            }
        }
    }

    
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[107];
        if (((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv3)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv3)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.psa_all_tv_oil_page3_tv3)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " KM");
            }
        }
    }
}
