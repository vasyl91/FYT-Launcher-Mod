package com.syu.carinfo.dasauto;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class TuRui_OilActi extends BaseActivity {
    public static TuRui_OilActi mInstance;
    public static boolean mIsFront = false;
    private int[] eventIds = {183, 184, 185, 186, 187, 188, 189};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dasauto.TuRui_OilActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 183:
                    TuRui_OilActi.this.uOilVolume(DataCanbus.DATA[updateCode]);
                    break;
                case 184:
                    TuRui_OilActi.this.uMilesUnit(DataCanbus.DATA[updateCode]);
                    break;
                case 185:
                    TuRui_OilActi.this.uCheckMiles(DataCanbus.DATA[updateCode]);
                    break;
                case 186:
                    TuRui_OilActi.this.uCheckDate(DataCanbus.DATA[updateCode]);
                    break;
                case 187:
                    TuRui_OilActi.this.uCheckPeriodMiles(DataCanbus.DATA[updateCode]);
                    break;
                case 188:
                    TuRui_OilActi.this.uCheckPeriodDate(DataCanbus.DATA[updateCode]);
                    break;
                case 189:
                    TuRui_OilActi.this.uRainBrush(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };
    String mileUnit = "Km";

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_turui_miantenance);
        init();
        mInstance = this;
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (((CheckBox) findViewById(R.id.turui_rainbrush)) != null) {
            ((CheckBox) findViewById(R.id.turui_rainbrush)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_OilActi.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[189];
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[3];
                    iArr[0] = 204;
                    iArr[1] = 2;
                    iArr[2] = i != 1 ? 1 : 0;
                    remoteModuleProxy.cmd(23, iArr, null, null);
                }
            });
        }
        if (findViewById(R.id.turui_reset) != null) {
            findViewById(R.id.turui_reset).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.TuRui_OilActi.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(23, new int[]{204, 1, 1}, null, null);
                }
            });
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].removeNotify(this.mNotifyCanbus);
        }
    }

    protected void uOilVolume(int i) {
        if (((TextView) findViewById(R.id.golf7_tv_maintenance_maximum_consumption_scale)) != null) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_maximum_consumption_scale)).setText(new StringBuilder().append(i).toString());
            ((ProgressBar) findViewById(R.id.tvOilVolume_id_progress)).setProgress(i + 1);
        }
    }

    protected void uMilesUnit(int i) {
        String str = i == 1 ? "Mile" : "Km";
        if (((TextView) findViewById(R.id.golf7_tv_maintenance_consumption_unit)) != null) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_consumption_unit)).setText(str);
        }
        this.mileUnit = str;
    }

    protected void uCheckMiles(int i) {
        int i2 = i * 100;
        if (((TextView) findViewById(R.id.golf7_tv_maintenance_check_mileage)) != null) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_check_mileage)).setText(i2 + this.mileUnit);
        }
    }

    protected void uCheckDate(int i) {
        if (((TextView) findViewById(R.id.golf7_tv_maintenance_check_days)) != null) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_check_days)).setText(i + getResources().getString(R.string.day));
        }
    }

    protected void uCheckPeriodDate(int i) {
        if (((TextView) findViewById(R.id.golf7_tv_maintenance_oil_maintenance_days)) != null) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_oil_maintenance_days)).setText(i + getResources().getString(R.string.day));
        }
    }

    protected void uCheckPeriodMiles(int i) {
        if (((TextView) findViewById(R.id.golf7_tv_maintenance_oil_maintenance_mileage)) != null) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_oil_maintenance_mileage)).setText(i + this.mileUnit);
        }
    }

    protected void uRainBrush(int i) {
        if (((CheckBox) findViewById(R.id.turui_rainbrush)) != null) {
            ((CheckBox) findViewById(R.id.turui_rainbrush)).setChecked(i == 1);
            ((CheckBox) findViewById(R.id.turui_rainbrush)).setText(i == 1 ? R.string.str_turui_str18 : R.string.str_turui_str19);
        }
    }
}
