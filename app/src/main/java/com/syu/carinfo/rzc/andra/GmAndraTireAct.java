package com.syu.carinfo.rzc.andra;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class GmAndraTireAct extends BaseActivity {
    public static GmAndraTireAct mInit;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 173:
                    GmAndraTireAct.this.mUpdaterTireFL();
                    GmAndraTireAct.this.mUpdaterTireFR();
                    GmAndraTireAct.this.mUpdaterTireRL();
                    GmAndraTireAct.this.mUpdaterTireRR();
                    break;
                case 174:
                    GmAndraTireAct.this.mUpdaterTireFL();
                    break;
                case 175:
                    GmAndraTireAct.this.mUpdaterTireFR();
                    break;
                case 176:
                    GmAndraTireAct.this.mUpdaterTireRL();
                    break;
                case 177:
                    GmAndraTireAct.this.mUpdaterTireRR();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_camry_tire);
        init();
    }

    @Override
    public void init() {
        mInit = this;
        findViewById(R.id.camry_layout_car).setVisibility(0);
        findViewById(R.id.camry_layout_line).setVisibility(8);
        findViewById(R.id.camry_layout_none).setVisibility(8);
        findViewById(R.id.camry_tv_car_tire_4).setVisibility(8);
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(11, new int[]{74, 1}, null, null);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
    }

    void mUpdaterTireRR() {
        int value = DataCanbus.DATA[177];
        int unit = DataCanbus.DATA[173];
        if (unit == 1) {
            int value2 = ((value * 4) * 10000) / 6895;
            ((TextView) findViewById(R.id.camry_tv_car_tire_3)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10));
            ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
        } else {
            ((TextView) findViewById(R.id.camry_tv_car_tire_3)).setText(new StringBuilder().append(value * 4).toString());
            ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
        }
    }

    void mUpdaterTireRL() {
        int value = DataCanbus.DATA[176];
        int unit = DataCanbus.DATA[173];
        if (unit == 1) {
            int value2 = ((value * 4) * 10000) / 6895;
            ((TextView) findViewById(R.id.camry_tv_car_tire_2)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10));
            ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
        } else {
            ((TextView) findViewById(R.id.camry_tv_car_tire_2)).setText(new StringBuilder().append(value * 4).toString());
            ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
        }
    }

    void mUpdaterTireFR() {
        int value = DataCanbus.DATA[175];
        int unit = DataCanbus.DATA[173];
        if (unit == 1) {
            int value2 = ((value * 4) * 10000) / 6895;
            ((TextView) findViewById(R.id.camry_tv_car_tire_1)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10));
            ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
        } else {
            ((TextView) findViewById(R.id.camry_tv_car_tire_1)).setText(new StringBuilder().append(value * 4).toString());
            ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
        }
    }

    void mUpdaterTireFL() {
        int value = DataCanbus.DATA[174];
        int unit = DataCanbus.DATA[173];
        if (unit == 1) {
            int value2 = ((value * 4) * 10000) / 6895;
            ((TextView) findViewById(R.id.camry_tv_car_tire_1)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10));
            ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
        } else {
            ((TextView) findViewById(R.id.camry_tv_car_tire_0)).setText(new StringBuilder().append(value * 4).toString());
            ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
        }
    }
}
