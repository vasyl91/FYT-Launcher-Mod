package com.syu.carinfo.ztt600;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ZTTireAct_Luz extends BaseActivity {
    String str;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ztt600.ZTTireAct_Luz.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 138:
                    ZTTireAct_Luz.this.uSystem(val);
                    break;
                case 139:
                    ZTTireAct_Luz.this.uWarnRL(val);
                    break;
                case 140:
                    ZTTireAct_Luz.this.uWarnRR(val);
                    break;
                case 141:
                    ZTTireAct_Luz.this.uWarnFL(val);
                    break;
                case 142:
                    ZTTireAct_Luz.this.uWarnFR(val);
                    break;
                case 143:
                    ZTTireAct_Luz.this.uRL(val);
                    break;
                case 144:
                    ZTTireAct_Luz.this.uRR(val);
                    break;
                case 145:
                    ZTTireAct_Luz.this.uFR(val);
                    break;
                case 146:
                    ZTTireAct_Luz.this.uFL(val);
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
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    protected void uSystem(int val) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(val == 0 ? "" : getResources().getString(R.string.zt_t600_car_system_band));
        }
    }

    protected void uFL(int val) {
        TextView vTire = (TextView) findViewById(R.id.tv_text3);
        TextView vTemp = (TextView) findViewById(R.id.tv_text2);
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
        TextView vTire = (TextView) findViewById(R.id.tv_text9);
        TextView vTemp = (TextView) findViewById(R.id.tv_text8);
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
        TextView vTire = (TextView) findViewById(R.id.tv_text6);
        TextView vTemp = (TextView) findViewById(R.id.tv_text5);
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
        TextView vTire = (TextView) findViewById(R.id.tv_text12);
        TextView vTemp = (TextView) findViewById(R.id.tv_text11);
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
        TextView v = (TextView) findViewById(R.id.tv_text4);
        TextView vTemp = (TextView) findViewById(R.id.tv_text2);
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
        TextView v = (TextView) findViewById(R.id.tv_text10);
        TextView vTemp = (TextView) findViewById(R.id.tv_text8);
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
        TextView v = (TextView) findViewById(R.id.tv_text7);
        TextView vTemp = (TextView) findViewById(R.id.tv_text5);
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
        TextView v = (TextView) findViewById(R.id.tv_text13);
        TextView vTemp = (TextView) findViewById(R.id.tv_text11);
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
