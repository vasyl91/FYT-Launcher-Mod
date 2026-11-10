package com.syu.carinfo.wccamry;

import android.os.Bundle;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

import java.util.Locale;

@SuppressWarnings({"deprecation", "unchecked"})
public class CamryTireActWC extends BaseActivity {
    public static CamryTireActWC mInit;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 132:
                    CamryTireActWC.this.mUpdaterTireWarn();
                    break;
                case 133:
                    CamryTireActWC.this.mUpdaterTireFL();
                    break;
                case 134:
                    CamryTireActWC.this.mUpdaterTireFR();
                    break;
                case 135:
                    CamryTireActWC.this.mUpdaterTireRL();
                    break;
                case 136:
                    CamryTireActWC.this.mUpdaterTireRR();
                    break;
                case 194:
                    CamryTireActWC.this.mUpdaterTempFL();
                    break;
                case 195:
                    CamryTireActWC.this.mUpdaterTempFR();
                    break;
                case 196:
                    CamryTireActWC.this.mUpdaterTempRL();
                    break;
                case 197:
                    CamryTireActWC.this.mUpdaterTempRR();
                    break;
                case 198:
                    CamryTireActWC.this.updaterTitleState();
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
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        if (DataCanbus.DATA[1000] == 5767462 || DataCanbus.DATA[1000] == 5832998) {
            DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        if (DataCanbus.DATA[1000] == 5767462 || DataCanbus.DATA[1000] == 5832998) {
            DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        }
    }

    @Override
    public void init() {
        mInit = this;
    }

    
    public void updaterTitleState() {
        int value = DataCanbus.DATA[198];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText("----");
            return;
        }
        if (value >= 128) {
            ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(String.valueOf(getResources().getString(R.string.str_forward_tilt)) + ": " + (value - 128));
        } else if (value >= 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(String.valueOf(getResources().getString(R.string.str_backward_tilt)) + ": " + value);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void mUpdaterTempFL() {
        int value = DataCanbus.DATA[194];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire1_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    
    public void mUpdaterTempFR() {
        int value = DataCanbus.DATA[195];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire2_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    
    public void mUpdaterTempRL() {
        int value = DataCanbus.DATA[196];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire3_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    
    public void mUpdaterTempRR() {
        int value = DataCanbus.DATA[197];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire4_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[133];
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
        int value = DataCanbus.DATA[134];
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
        int value = DataCanbus.DATA[135];
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
        int value = DataCanbus.DATA[136];
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
        int value = DataCanbus.DATA[132];
        if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflalarm);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflalarm);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflalarm);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflalarm);
            return;
        }
        ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tirefrnormal);
        ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tirefrnormal);
        ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tirefrnormal);
        ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tirefrnormal);
    }
}
