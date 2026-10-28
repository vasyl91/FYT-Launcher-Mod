package com.syu.carinfo.wccamry;

import android.os.Bundle;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

import java.util.Locale;

/* renamed from: com.syu.carinfo.wccamry.CamryTireActWC_备份, reason: invalid class name */
@SuppressWarnings({"deprecation", "unchecked"})
public class CamryTireActWC_ extends BaseActivity {
    public static CamryTireActWC_ mInit;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 71:
                    CamryTireActWC_.this.mUpdaterTireWarn();
                    break;
                case 72:
                    CamryTireActWC_.this.mUpdaterTireFL();
                    break;
                case 73:
                    CamryTireActWC_.this.mUpdaterTireFR();
                    break;
                case 74:
                    CamryTireActWC_.this.mUpdaterTireRL();
                    break;
                case 75:
                    CamryTireActWC_.this.mUpdaterTireRR();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_camry_tire_wc);
        init();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
    }

    @Override
    public void init() {
        mInit = this;
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[72];
        if (value == 254) {
            ((TextView) findViewById(R.id.camry_tv_car_tire_0)).setText("---");
            return;
        }
        int temp = (value / 256) + (value % 256);
        Locale locale = LauncherApplication.getInstance().getResources().getConfiguration().locale;
        String language = locale.getCountry();
        if (language.endsWith("TW")) {
            int temp2 = (temp * 145) / 100;
            ((TextView) findViewById(R.id.camry_tv_car_tire_0)).setText(String.valueOf(temp2 / 10) + "." + (temp2 % 10) + "Psi");
        } else {
            ((TextView) findViewById(R.id.camry_tv_car_tire_0)).setText(String.valueOf(temp) + "kPa");
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[73];
        if (value == 254) {
            ((TextView) findViewById(R.id.camry_tv_car_tire_1)).setText("---");
            return;
        }
        int temp = (value / 256) + (value % 256);
        Locale locale = LauncherApplication.getInstance().getResources().getConfiguration().locale;
        String language = locale.getCountry();
        if (language.endsWith("TW")) {
            int temp2 = (temp * 145) / 100;
            ((TextView) findViewById(R.id.camry_tv_car_tire_1)).setText(String.valueOf(temp2 / 10) + "." + (temp2 % 10) + "Psi");
        } else {
            ((TextView) findViewById(R.id.camry_tv_car_tire_1)).setText(String.valueOf(temp) + "kPa");
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[74];
        if (value == 254) {
            ((TextView) findViewById(R.id.camry_tv_car_tire_2)).setText("---");
            return;
        }
        int temp = (value / 256) + (value % 256);
        Locale locale = LauncherApplication.getInstance().getResources().getConfiguration().locale;
        String language = locale.getCountry();
        if (language.endsWith("TW")) {
            int temp2 = (temp * 145) / 100;
            ((TextView) findViewById(R.id.camry_tv_car_tire_2)).setText(String.valueOf(temp2 / 10) + "." + (temp2 % 10) + "Psi");
        } else {
            ((TextView) findViewById(R.id.camry_tv_car_tire_2)).setText(String.valueOf(temp) + "kPa");
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[75];
        if (value == 254) {
            ((TextView) findViewById(R.id.camry_tv_car_tire_3)).setText("---");
            return;
        }
        int temp = (value / 256) + (value % 256);
        Locale locale = LauncherApplication.getInstance().getResources().getConfiguration().locale;
        String language = locale.getCountry();
        if (language.endsWith("TW")) {
            int temp2 = (temp * 145) / 100;
            ((TextView) findViewById(R.id.camry_tv_car_tire_3)).setText(String.valueOf(temp2 / 10) + "." + (temp2 % 10) + "Psi");
        } else {
            ((TextView) findViewById(R.id.camry_tv_car_tire_3)).setText(String.valueOf(temp) + "kPa");
        }
    }

    
    public void mUpdaterTireWarn() {
        int value = DataCanbus.DATA[71];
        if (value == 1) {
            ((TextView) findViewById(R.id.camry_tv_car_tire_warn)).setText(R.string.tireflalarm);
        } else {
            ((TextView) findViewById(R.id.camry_tv_car_tire_warn)).setText(R.string.tirefrnormal);
        }
    }
}
