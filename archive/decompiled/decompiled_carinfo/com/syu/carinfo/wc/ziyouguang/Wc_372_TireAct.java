package com.syu.carinfo.wc.ziyouguang;

import android.os.Bundle;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

import java.util.Locale;

@SuppressWarnings({"deprecation", "unchecked"})
public class Wc_372_TireAct extends BaseActivity {
    public static Wc_372_TireAct mInit;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 212:
                    Wc_372_TireAct.this.mUpdaterTireWarn();
                    break;
                case 213:
                    Wc_372_TireAct.this.mUpdaterTireFL();
                    break;
                case 214:
                    Wc_372_TireAct.this.mUpdaterTireFR();
                    break;
                case 215:
                    Wc_372_TireAct.this.mUpdaterTireRL();
                    break;
                case 216:
                    Wc_372_TireAct.this.mUpdaterTireRR();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_oudi_zt_t600_tire);
        init();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[213].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[214].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[216].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[212].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[213].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[214].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[212].removeNotify(this.mNotifyCanbus);
    }

    @Override
    public void init() {
        mInit = this;
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[213];
        if (value == 254) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("---");
            return;
        }
        int temp = (value / 256) + (value % 256);
        Locale locale = LauncherApplication.getInstance().getResources().getConfiguration().locale;
        String language = locale.getCountry();
        if (language.endsWith("TW")) {
            int temp2 = (temp * 145) / 100;
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(temp2 / 10) + "." + (temp2 % 10) + "Psi");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(temp) + "kPa");
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[214];
        if (value == 254) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("---");
            return;
        }
        int temp = (value / 256) + (value % 256);
        Locale locale = LauncherApplication.getInstance().getResources().getConfiguration().locale;
        String language = locale.getCountry();
        if (language.endsWith("TW")) {
            int temp2 = (temp * 145) / 100;
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(temp2 / 10) + "." + (temp2 % 10) + "Psi");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(temp) + "kPa");
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[215];
        if (value == 254) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("---");
            return;
        }
        int temp = (value / 256) + (value % 256);
        Locale locale = LauncherApplication.getInstance().getResources().getConfiguration().locale;
        String language = locale.getCountry();
        if (language.endsWith("TW")) {
            int temp2 = (temp * 145) / 100;
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(temp2 / 10) + "." + (temp2 % 10) + "Psi");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(temp) + "kPa");
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[216];
        if (value == 254) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("---");
            return;
        }
        int temp = (value / 256) + (value % 256);
        Locale locale = LauncherApplication.getInstance().getResources().getConfiguration().locale;
        String language = locale.getCountry();
        if (language.endsWith("TW")) {
            int temp2 = (temp * 145) / 100;
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(temp2 / 10) + "." + (temp2 % 10) + "Psi");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(temp) + "kPa");
        }
    }

    
    public void mUpdaterTireWarn() {
        int value = DataCanbus.DATA[212];
        if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflalarm);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflalarm);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflalarm);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflalarm);
            return;
        }
        ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tirefrnormal);
        ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tirefrnormal);
        ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tirefrnormal);
        ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tirefrnormal);
    }
}
