package com.syu.carinfo.dongjian.wc2.ds5;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class DS5CarLog3Act extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 105:
                    DS5CarLog3Act.this.updaterpingjunOil3();
                    break;
                case 106:
                    DS5CarLog3Act.this.updaterpingjunSpeed3();
                    break;
                case 107:
                    DS5CarLog3Act.this.updaterleijiLicheng3();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_302_dongjian_wc2_ds5_car_log_page3);
        init();
    }

    @Override
    public void init() {
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterpingjunOil3() {
        int pingjunOil3Value = DataCanbus.DATA[105];
        if (pingjunOil3Value < 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_pingjun_oil_page3_tv)).setText(((pingjunOil3Value >> 8) & 255) + "." + (pingjunOil3Value & 255) + "L/100Km");
        } else if (pingjunOil3Value == 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_pingjun_oil_page3_tv)).setText("-- L/100Km");
        }
    }

    
    public void updaterpingjunSpeed3() {
        int pingjunSpeed3Value = DataCanbus.DATA[106];
        if (pingjunSpeed3Value < 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_pingjun_speed_page3_tv)).setText(pingjunSpeed3Value + "Km/h");
        } else if (pingjunSpeed3Value == 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_pingjun_speed_page3_tv)).setText("-- Km/h");
        }
    }

    
    public void updaterleijiLicheng3() {
        int allLicheng3Value = DataCanbus.DATA[107];
        if (allLicheng3Value < 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_all_licheng_page3_tv)).setText(allLicheng3Value + "Km");
        } else if (allLicheng3Value == 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_all_licheng_page3_tv)).setText("-- Km");
        }
    }
}
