package com.syu.carinfo.ztt600;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.text.DecimalFormat;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ZTTireAct_Luz extends BaseActivity {
    String str;
    int val;
    private int[] ids = {72, 73, 74, 75, 76, 77, 78, 79, 80};
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ztt600.ZTTireAct_Luz.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            ZTTireAct_Luz.this.val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 72:
                    ZTTireAct_Luz.this.uSystem(ZTTireAct_Luz.this.val);
                    break;
                case 73:
                    ZTTireAct_Luz.this.uWarnRL(ZTTireAct_Luz.this.val);
                    break;
                case 74:
                    ZTTireAct_Luz.this.uWarnRR(ZTTireAct_Luz.this.val);
                    break;
                case 75:
                    ZTTireAct_Luz.this.uWarnFL(ZTTireAct_Luz.this.val);
                    break;
                case 76:
                    ZTTireAct_Luz.this.uWarnFR(ZTTireAct_Luz.this.val);
                    break;
                case 77:
                    ZTTireAct_Luz.this.uRL(ZTTireAct_Luz.this.val);
                    break;
                case 78:
                    ZTTireAct_Luz.this.uRR(ZTTireAct_Luz.this.val);
                    break;
                case 79:
                    ZTTireAct_Luz.this.uFR(ZTTireAct_Luz.this.val);
                    break;
                case 80:
                    ZTTireAct_Luz.this.uFL(ZTTireAct_Luz.this.val);
                    break;
            }
        }
    };
    private String[] strsWarn = {"No Warning", "High Pressure Warning", "Low Pressure Warning", "Quik Leakage", "Lost Sensor", "Sensor Battery Low", "Sensor Failure"};

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_265_luz_t600_tire);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.notifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.notifyCanbus);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    protected void uSystem(int val) {
        if (((TextView) findViewById(R.id.zt_tv_car_tire_state)) != null) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_state)).setText(val == 0 ? "" : getResources().getString(R.string.zt_t600_car_system_band));
        }
    }

    protected void uFL(int val) {
        TextView vTire = (TextView) findViewById(R.id.zt_tv_car_tire_press_0);
        TextView vTemp = (TextView) findViewById(R.id.zt_tv_car_tire_temp_0);
        int tire = val & 255;
        int temp = (val >> 8) & 255;
        if (vTemp != null) {
            this.str = "-- --";
            if (temp != 255) {
                this.str = String.valueOf(temp - 40) + " ℃";
            }
            vTemp.setText(this.str);
        }
        if (vTire != null) {
            this.str = "-- --";
            if (tire != 255) {
                DecimalFormat fnum = new DecimalFormat("##0.000");
                String dd = fnum.format(tire * 1.373f);
                this.str = String.valueOf(dd) + " Kpa";
            }
            vTire.setText(this.str);
        }
    }

    protected void uFR(int val) {
        TextView vTire = (TextView) findViewById(R.id.zt_tv_car_tire_press_1);
        TextView vTemp = (TextView) findViewById(R.id.zt_tv_car_tire_temp_1);
        int tire = val & 255;
        int temp = (val >> 8) & 255;
        if (vTemp != null) {
            this.str = "-- --";
            if (temp != 255) {
                this.str = String.valueOf(temp - 40) + " ℃";
            }
            vTemp.setText(this.str);
        }
        if (vTire != null) {
            this.str = "-- --";
            if (tire != 255) {
                DecimalFormat fnum = new DecimalFormat("##0.000");
                String dd = fnum.format(tire * 1.373f);
                this.str = String.valueOf(dd) + " Kpa";
            }
            vTire.setText(this.str);
        }
    }

    protected void uRL(int val) {
        TextView vTire = (TextView) findViewById(R.id.zt_tv_car_tire_press_2);
        TextView vTemp = (TextView) findViewById(R.id.zt_tv_car_tire_temp_2);
        int tire = val & 255;
        int temp = (val >> 8) & 255;
        if (vTemp != null) {
            this.str = "-- --";
            if (temp != 255) {
                this.str = String.valueOf(temp - 40) + " ℃";
            }
            vTemp.setText(this.str);
        }
        if (vTire != null) {
            this.str = "-- --";
            if (tire != 255) {
                DecimalFormat fnum = new DecimalFormat("##0.000");
                String dd = fnum.format(tire * 1.373f);
                this.str = String.valueOf(dd) + " Kpa";
            }
            vTire.setText(this.str);
        }
    }

    protected void uRR(int val) {
        TextView vTire = (TextView) findViewById(R.id.zt_tv_car_tire_press_3);
        TextView vTemp = (TextView) findViewById(R.id.zt_tv_car_tire_temp_3);
        int tire = val & 255;
        int temp = (val >> 8) & 255;
        if (vTemp != null) {
            this.str = "-- --";
            if (temp != 255) {
                this.str = String.valueOf(temp - 40) + " ℃";
            }
            vTemp.setText(this.str);
        }
        if (vTire != null) {
            this.str = "-- --";
            if (tire != 255) {
                DecimalFormat fnum = new DecimalFormat("##0.000");
                String dd = fnum.format(tire * 1.373f);
                this.str = String.valueOf(dd) + " Kpa";
            }
            vTire.setText(this.str);
        }
    }

    protected void uWarnFL(int val) {
        TextView v = (TextView) findViewById(R.id.zt_tv_car_tire_press_info_0);
        TextView vTemp = (TextView) findViewById(R.id.zt_tv_car_tire_temp_0);
        int tempWarn = (val >> 8) & 1;
        int val2 = val & 255;
        if (vTemp != null) {
            vTemp.setTextColor(getResources().getColor(tempWarn == 1 ? R.color.red : R.color.white));
        }
        if (v != null) {
            if (val2 < this.strsWarn.length) {
                v.setText(this.strsWarn[val2]);
            } else {
                v.setText("");
            }
        }
    }

    protected void uWarnFR(int val) {
        TextView v = (TextView) findViewById(R.id.zt_tv_car_tire_press_info_1);
        TextView vTemp = (TextView) findViewById(R.id.zt_tv_car_tire_temp_1);
        int tempWarn = (val >> 8) & 1;
        int val2 = val & 255;
        if (vTemp != null) {
            vTemp.setTextColor(getResources().getColor(tempWarn == 1 ? R.color.red : R.color.white));
        }
        if (v != null) {
            if (val2 < this.strsWarn.length) {
                v.setText(this.strsWarn[val2]);
            } else {
                v.setText("");
            }
        }
    }

    protected void uWarnRL(int val) {
        TextView v = (TextView) findViewById(R.id.zt_tv_car_tire_press_info_2);
        TextView vTemp = (TextView) findViewById(R.id.zt_tv_car_tire_temp_2);
        int tempWarn = (val >> 8) & 1;
        int val2 = val & 255;
        if (vTemp != null) {
            vTemp.setTextColor(getResources().getColor(tempWarn == 1 ? R.color.red : R.color.white));
        }
        if (v != null) {
            if (val2 < this.strsWarn.length) {
                v.setText(this.strsWarn[val2]);
            } else {
                v.setText("");
            }
        }
    }

    protected void uWarnRR(int val) {
        TextView v = (TextView) findViewById(R.id.zt_tv_car_tire_press_info_3);
        TextView vTemp = (TextView) findViewById(R.id.zt_tv_car_tire_temp_3);
        int tempWarn = (val >> 8) & 1;
        int val2 = val & 255;
        if (vTemp != null) {
            vTemp.setTextColor(getResources().getColor(tempWarn == 1 ? R.color.red : R.color.white));
        }
        if (v != null) {
            if (val2 < this.strsWarn.length) {
                v.setText(this.strsWarn[val2]);
            } else {
                v.setText("");
            }
        }
    }
}