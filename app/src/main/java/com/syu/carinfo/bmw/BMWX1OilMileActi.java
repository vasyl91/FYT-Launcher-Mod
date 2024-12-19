package com.syu.carinfo.bmw;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class BMWX1OilMileActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bmw.BMWX1OilMileActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    BMWX1OilMileActi.this.mUpdaterOilExpend();
                    break;
                case 1:
                    BMWX1OilMileActi.this.mUpdaterDrivingMileage();
                    break;
                case 2:
                    BMWX1OilMileActi.this.mUpdaterAverageSpeed();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bmwx1_oilmile);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.bmwx1_btn_cleanspeed)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bmw.BMWX1OilMileActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{1}, null, null);
            }
        });
        ((Button) findViewById(R.id.bmwx1_btn_cleanoil)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bmw.BMWX1OilMileActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilExpend() {
        int value = DataCanbus.DATA[0];
        if (((TextView) findViewById(R.id.bmwx1_text_oil)) != null) {
            if (value > 0 && value < 4000) {
                ((TextView) findViewById(R.id.bmwx1_text_oil)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
            } else {
                ((TextView) findViewById(R.id.bmwx1_text_oil)).setText("--.-");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[1];
        if (((TextView) findViewById(R.id.bmwx1_text_mileage)) != null) {
            if (value > 0 && value < 4000) {
                ((TextView) findViewById(R.id.bmwx1_text_mileage)).setText(String.format("%d", Integer.valueOf(value)));
            } else {
                ((TextView) findViewById(R.id.bmwx1_text_mileage)).setText("----");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAverageSpeed() {
        int value = DataCanbus.DATA[2];
        if (((TextView) findViewById(R.id.bmwx1_text_velocity)) != null) {
            if (value > 0 && value < 4000) {
                ((TextView) findViewById(R.id.bmwx1_text_velocity)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
            } else {
                ((TextView) findViewById(R.id.bmwx1_text_velocity)).setText("--.-");
            }
        }
    }
}
