package com.syu.carinfo.dongjian.wc2.ds5;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class DS5CarLog1Act extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 100:
                    DS5CarLog1Act.this.updaterpingjunOil();
                    break;
                case 101:
                    DS5CarLog1Act.this.updaterlastoilLicheng();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_302_dongjian_wc2_ds5_car_log_page1);
        init();
    }

    @Override
    public void init() {
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterpingjunOil() {
        int pingjunOilValue = DataCanbus.DATA[100];
        if (pingjunOilValue < 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_pingjun_oil_tv)).setText(((pingjunOilValue >> 8) & 255) + "." + (pingjunOilValue & 255) + "L/100Km");
        } else if (pingjunOilValue == 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_pingjun_oil_tv)).setText("-- L/100Km");
        }
    }

    
    public void updaterlastoilLicheng() {
        int lastOilLichengValue = DataCanbus.DATA[101];
        if (lastOilLichengValue < 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_last_oil_licheng_tv)).setText(lastOilLichengValue + "Km");
        } else if (lastOilLichengValue == 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_last_oil_licheng_tv)).setText("-- Km");
        }
    }
}
