package com.syu.carinfo.lz.spirior;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Lz_425_Spirior_MeterAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.spirior.Lz_425_Spirior_MeterAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 7:
                    Lz_425_Spirior_MeterAct.this.updateCurSpeed();
                    break;
                case 8:
                    Lz_425_Spirior_MeterAct.this.updateEngineSpeed();
                    break;
                case 9:
                    Lz_425_Spirior_MeterAct.this.updateTotalMileage();
                    break;
            }
        }
    };
    public TextView tvCurSpeed;
    public TextView tvEngineSpeed;
    public TextView tvTotalMileage;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0425_lz_spirior_meter_info);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.tvEngineSpeed = (TextView) findViewById(R.id.lz_spirior_engine_speed);
        this.tvCurSpeed = (TextView) findViewById(R.id.lz_spirior_curspeed);
        this.tvTotalMileage = (TextView) findViewById(R.id.lz_spirior_total_mileage);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCurSpeed() {
        int curspeed = DataCanbus.DATA[7];
        if (this.tvCurSpeed != null) {
            if (curspeed > 0 && curspeed <= 4000) {
                this.tvCurSpeed.setText(String.valueOf(String.format("%d.%d", Integer.valueOf(curspeed / 10), Integer.valueOf(curspeed % 10))) + " Km/h");
            } else {
                this.tvCurSpeed.setText("---");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEngineSpeed() {
        int enginespeed = DataCanbus.DATA[8];
        if (this.tvEngineSpeed != null) {
            if (enginespeed >= 0 && enginespeed <= 7000) {
                this.tvEngineSpeed.setText(String.valueOf(String.format("%d", Integer.valueOf(enginespeed))) + " Rpm");
            } else {
                this.tvEngineSpeed.setText("---");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTotalMileage() {
        int totalgmileage = DataCanbus.DATA[9];
        if (this.tvTotalMileage != null) {
            if (totalgmileage >= 0 && totalgmileage <= 16777215) {
                this.tvTotalMileage.setText(String.valueOf(String.format("%d", Integer.valueOf(totalgmileage))) + " KM");
            } else {
                this.tvTotalMileage.setText("--.-");
            }
        }
    }
}
