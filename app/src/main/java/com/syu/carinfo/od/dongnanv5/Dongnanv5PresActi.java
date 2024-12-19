package com.syu.carinfo.od.dongnanv5;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Dongnanv5PresActi extends BaseActivity {
    public View mLayoutNone;
    public View mLayoutTrieCar;
    public TextView mTvCarTirePress0;
    public TextView mTvCarTirePress1;
    public TextView mTvCarTirePress2;
    public TextView mTvCarTirePress3;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.dongnanv5.Dongnanv5PresActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 9:
                    Dongnanv5PresActi.this.mTvCarTirePress0.setText(String.format("%d", Integer.valueOf(value)));
                    break;
                case 10:
                    Dongnanv5PresActi.this.mTvCarTirePress1.setText(String.format("%d", Integer.valueOf(value)));
                    break;
                case 11:
                    Dongnanv5PresActi.this.mTvCarTirePress2.setText(String.format("%d", Integer.valueOf(value)));
                    break;
                case 12:
                    Dongnanv5PresActi.this.mTvCarTirePress3.setText(String.format("%d", Integer.valueOf(value)));
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_oudi_dongnanv5_tire);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mLayoutTrieCar = findViewById(R.id.zt_layout_car);
        this.mLayoutNone = findViewById(R.id.zt_layout_none);
        this.mTvCarTirePress0 = (TextView) findViewById(R.id.zt_tv_car_tire_press_0);
        this.mTvCarTirePress1 = (TextView) findViewById(R.id.zt_tv_car_tire_press_1);
        this.mTvCarTirePress2 = (TextView) findViewById(R.id.zt_tv_car_tire_press_2);
        this.mTvCarTirePress3 = (TextView) findViewById(R.id.zt_tv_car_tire_press_3);
    }
}
