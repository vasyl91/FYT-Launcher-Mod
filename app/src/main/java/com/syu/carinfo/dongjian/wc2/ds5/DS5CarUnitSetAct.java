package com.syu.carinfo.dongjian.wc2.ds5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class DS5CarUnitSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dongjian.wc2.ds5.DS5CarUnitSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 33:
                    DS5CarUnitSetAct.this.updaterdistance();
                    break;
                case 34:
                    DS5CarUnitSetAct.this.updaterSpeed();
                    break;
                case 35:
                    DS5CarUnitSetAct.this.updaterTemp();
                    break;
                case 36:
                    DS5CarUnitSetAct.this.updaterVolme();
                    break;
                case 37:
                    DS5CarUnitSetAct.this.updaterOil();
                    break;
                case 38:
                    DS5CarUnitSetAct.this.updaterTirePress();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_302_dongjian_wc2_ds5_car_unit_set);
        init();
        setUI();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    public void setUI() {
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_distance_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_speed_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_temp_check)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_Volume_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_Volume_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_oil_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_oil_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_tire_press_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_tire_press_next)).setOnClickListener(this);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdistance() {
        int distanceValue = DataCanbus.DATA[33] & 255;
        if (distanceValue == 0) {
            ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_distance_check)).setChecked(false);
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_distance_tv)).setText("m");
        } else if (distanceValue == 1) {
            ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_distance_check)).setChecked(true);
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_distance_tv)).setText("Km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSpeed() {
        int SpeedValue = DataCanbus.DATA[34] & 255;
        if (SpeedValue == 0) {
            ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_speed_check)).setChecked(false);
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_speed_tv)).setText("m/h");
        } else if (SpeedValue == 1) {
            ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_speed_check)).setChecked(true);
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_speed_tv)).setText("Km/h");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTemp() {
        int tempValue = DataCanbus.DATA[35] & 255;
        if (tempValue == 0) {
            ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_temp_check)).setChecked(false);
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_temp_tv)).setText("F");
        } else if (tempValue == 1) {
            ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_temp_check)).setChecked(true);
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_temp_tv)).setText("DegC");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterVolme() {
        int volmeValue = DataCanbus.DATA[36] & 255;
        if (volmeValue == 0) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_Volume_tv)).setText("L");
        } else if (volmeValue == 1) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_Volume_tv)).setText("gal(US)");
        } else if (volmeValue == 2) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_Volume_tv)).setText("gal(UK)");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterOil() {
        int OilValue = DataCanbus.DATA[37] & 255;
        if (OilValue == 0) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_oil_tv)).setText("L/100Km");
            return;
        }
        if (OilValue == 1) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_oil_tv)).setText("Km/L");
        } else if (OilValue == 2) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_oil_tv)).setText("mpg(US)");
        } else if (OilValue == 3) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_oil_tv)).setText("mpg(UK)");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTirePress() {
        int TirePressValue = DataCanbus.DATA[38] & 255;
        if (TirePressValue == 0) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_tire_press_tv)).setText("Kpa");
        } else if (TirePressValue == 1) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_tire_press_tv)).setText("Bar");
        } else if (TirePressValue == 2) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_tire_press_tv)).setText("psi");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dongjian_wc2_ds5_distance_check /* 2131429239 */:
                DS5Func.C_UNIT_SET(1, (DataCanbus.DATA[33] & 255) == 0 ? 1 : 2);
                break;
            case R.id.dongjian_wc2_ds5_speed_check /* 2131429242 */:
                DS5Func.C_UNIT_SET(2, (DataCanbus.DATA[34] & 255) != 0 ? 2 : 1);
                break;
            case R.id.dongjian_wc2_ds5_temp_check /* 2131429245 */:
                DS5Func.C_UNIT_SET(3, (DataCanbus.DATA[35] & 255) != 0 ? 2 : 1);
                break;
            case R.id.dongjian_wc2_ds5_Volume_pre /* 2131429248 */:
                if ((DataCanbus.DATA[36] & 255) == 0) {
                    DS5Func.C_UNIT_SET(4, 3);
                    break;
                } else if ((DataCanbus.DATA[36] & 255) == 1) {
                    DS5Func.C_UNIT_SET(4, 1);
                    break;
                } else if ((DataCanbus.DATA[36] & 255) == 2) {
                    DS5Func.C_UNIT_SET(4, 2);
                    break;
                }
            case R.id.dongjian_wc2_ds5_Volume_next /* 2131429250 */:
                if ((DataCanbus.DATA[36] & 255) == 0) {
                    DS5Func.C_UNIT_SET(4, 2);
                    break;
                } else if ((DataCanbus.DATA[36] & 255) == 1) {
                    DS5Func.C_UNIT_SET(4, 3);
                    break;
                } else if ((DataCanbus.DATA[36] & 255) == 2) {
                    DS5Func.C_UNIT_SET(4, 1);
                    break;
                }
            case R.id.dongjian_wc2_ds5_oil_pre /* 2131429252 */:
                if ((DataCanbus.DATA[37] & 255) == 0) {
                    DS5Func.C_UNIT_SET(5, 4);
                    break;
                } else if ((DataCanbus.DATA[37] & 255) == 1) {
                    DS5Func.C_UNIT_SET(5, 1);
                    break;
                } else if ((DataCanbus.DATA[37] & 255) == 2) {
                    DS5Func.C_UNIT_SET(5, 2);
                    break;
                } else if ((DataCanbus.DATA[37] & 255) == 3) {
                    DS5Func.C_UNIT_SET(5, 3);
                    break;
                }
            case R.id.dongjian_wc2_ds5_oil_next /* 2131429254 */:
                if ((DataCanbus.DATA[37] & 255) == 0) {
                    DS5Func.C_UNIT_SET(5, 2);
                    break;
                } else if ((DataCanbus.DATA[37] & 255) == 1) {
                    DS5Func.C_UNIT_SET(5, 3);
                    break;
                } else if ((DataCanbus.DATA[37] & 255) == 2) {
                    DS5Func.C_UNIT_SET(5, 4);
                    break;
                } else if ((DataCanbus.DATA[37] & 255) == 3) {
                    DS5Func.C_UNIT_SET(5, 1);
                    break;
                }
            case R.id.dongjian_wc2_ds5_tire_press_pre /* 2131429256 */:
                if ((DataCanbus.DATA[38] & 255) == 0) {
                    DS5Func.C_UNIT_SET(6, 3);
                    break;
                } else if ((DataCanbus.DATA[38] & 255) == 1) {
                    DS5Func.C_UNIT_SET(6, 1);
                    break;
                } else if ((DataCanbus.DATA[38] & 255) == 2) {
                    DS5Func.C_UNIT_SET(6, 2);
                    break;
                }
            case R.id.dongjian_wc2_ds5_tire_press_next /* 2131429258 */:
                if ((DataCanbus.DATA[38] & 255) == 0) {
                    DS5Func.C_UNIT_SET(6, 2);
                    break;
                } else if ((DataCanbus.DATA[38] & 255) == 1) {
                    DS5Func.C_UNIT_SET(6, 3);
                    break;
                } else if ((DataCanbus.DATA[38] & 255) == 2) {
                    DS5Func.C_UNIT_SET(6, 1);
                    break;
                }
        }
    }
}