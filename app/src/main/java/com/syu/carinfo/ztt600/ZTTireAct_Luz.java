package com.syu.carinfo.ztt600;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.text.DecimalFormat;

@SuppressWarnings({"deprecation", "unchecked"})
public class ZTTireAct_Luz extends BaseActivity {
    String str;
    int val;
    private int[] ids = {138, 139, 140, 141, 142, 143, 144, 145, 146};
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            ZTTireAct_Luz.this.val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 138:
                    ZTTireAct_Luz.this.uSystem(ZTTireAct_Luz.this.val);
                    break;
                case 139:
                    ZTTireAct_Luz.this.uWarnRL(ZTTireAct_Luz.this.val);
                    break;
                case 140:
                    ZTTireAct_Luz.this.uWarnRR(ZTTireAct_Luz.this.val);
                    break;
                case 141:
                    ZTTireAct_Luz.this.uWarnFL(ZTTireAct_Luz.this.val);
                    break;
                case 142:
                    ZTTireAct_Luz.this.uWarnFR(ZTTireAct_Luz.this.val);
                    break;
                case 143:
                    ZTTireAct_Luz.this.uRL(ZTTireAct_Luz.this.val);
                    break;
                case 144:
                    ZTTireAct_Luz.this.uRR(ZTTireAct_Luz.this.val);
                    break;
                case 145:
                    ZTTireAct_Luz.this.uFR(ZTTireAct_Luz.this.val);
                    break;
                case 146:
                    ZTTireAct_Luz.this.uFL(ZTTireAct_Luz.this.val);
                    break;
            }
        }
    };
    private String[] strsWarn = {"No Warning", "High Pressure Warning", "Low Pressure Warning", "Quik Leakage", "Lost Sensor", "Sensor Battery Low", "Sensor Failure"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_265_luz_t600_tire);
        init();
    }

    @Override
    public void addNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.notifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.notifyCanbus);
        }
    }

    @Override
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
