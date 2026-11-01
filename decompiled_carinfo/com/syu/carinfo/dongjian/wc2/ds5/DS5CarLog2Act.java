package com.syu.carinfo.dongjian.wc2.ds5;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class DS5CarLog2Act extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 102:
                    DS5CarLog2Act.this.updaterpingjunOil();
                    break;
                case 103:
                    DS5CarLog2Act.this.updaterpingjunSpeed();
                    break;
                case 104:
                    DS5CarLog2Act.this.updaterleijiLicheng();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_302_dongjian_wc2_ds5_car_log_page2);
        init();
    }

    @Override
    public void init() {
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterpingjunOil() {
        int pingjunOilValue = DataCanbus.DATA[102];
        if (pingjunOilValue < 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_pingjun_oil_page2_tv)).setText(((pingjunOilValue >> 8) & 255) + "." + (pingjunOilValue & 255) + "L/100Km");
        } else if (pingjunOilValue == 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_pingjun_oil_page2_tv)).setText("-- L/100Km");
        }
    }

    
    public void updaterpingjunSpeed() {
        int pingjunSpeedValue = DataCanbus.DATA[103];
        if (pingjunSpeedValue < 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_pingjun_speed_tv)).setText(pingjunSpeedValue + "Km/h");
        } else if (pingjunSpeedValue == 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_pingjun_speed_tv)).setText("-- Km/h");
        }
    }

    
    public void updaterleijiLicheng() {
        int allLichengValue = DataCanbus.DATA[104];
        if (allLichengValue < 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_all_licheng_tv)).setText(allLichengValue + "Km");
        } else if (allLichengValue == 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_all_licheng_tv)).setText("-- Km");
        }
    }
}
