package com.syu.carinfo.dongjian.wc2.ds5;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class DS5CarLog2Act extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dongjian.wc2.ds5.DS5CarLog2Act.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 5:
                    DS5CarLog2Act.this.updaterpingjunOil();
                    break;
                case 6:
                    DS5CarLog2Act.this.updaterpingjunSpeed();
                    break;
                case 7:
                    DS5CarLog2Act.this.updaterleijiLicheng();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_302_dongjian_wc2_ds5_car_log_page2);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterpingjunOil() {
        int pingjunOilValue = DataCanbus.DATA[5];
        if (pingjunOilValue < 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_pingjun_oil_page2_tv)).setText(((pingjunOilValue >> 8) & 255) + "." + (pingjunOilValue & 255) + "L/100Km");
        } else if (pingjunOilValue == 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_pingjun_oil_page2_tv)).setText("-- L/100Km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterpingjunSpeed() {
        int pingjunSpeedValue = DataCanbus.DATA[6];
        if (pingjunSpeedValue < 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_pingjun_speed_tv)).setText(pingjunSpeedValue + "Km/h");
        } else if (pingjunSpeedValue == 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_pingjun_speed_tv)).setText("-- Km/h");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterleijiLicheng() {
        int allLichengValue = DataCanbus.DATA[7];
        if (allLichengValue < 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_all_licheng_tv)).setText(allLichengValue + "Km");
        } else if (allLichengValue == 65535) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_all_licheng_tv)).setText("-- Km");
        }
    }
}
