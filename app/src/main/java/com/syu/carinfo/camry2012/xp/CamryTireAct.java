package com.syu.carinfo.camry2012.xp;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class CamryTireAct extends BaseActivity {
    public static CamryTireAct mInit;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 106:
                    CamryTireAct.this.mUpdaterExistTpms();
                    break;
                case 108:
                    CamryTireAct.this.mUpdaterShowTireBackup();
                    break;
                case 109:
                    CamryTireAct.this.mUpdaterExistTpms();
                    break;
                case 110:
                    CamryTireAct.this.mUpdaterTireFL();
                    break;
                case 111:
                    CamryTireAct.this.mUpdaterTireFR();
                    break;
                case 112:
                    CamryTireAct.this.mUpdaterTireRL();
                    break;
                case 113:
                    CamryTireAct.this.mUpdaterTireRR();
                    break;
                case 114:
                    CamryTireAct.this.mUpdaterTireBackup();
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
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
    }

    @Override
    public void init() {
        mInit = this;
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[110];
        int unit = (value >> 24) & 255;
        float num = 16777215 & value;
        if (((TextView) findViewById(R.id.camry_tv_car_tire_0)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_0)) != null && ((TextView) findViewById(R.id.camry_tv_car_tire_unit)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_unit)) != null) {
            if (unit == 0) {
                int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
                if (TireUnit == 0) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                    if (num != 1.6777215E7f) {
                        float num2 = num * 100.0f;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_0)).setText(String.format("%d", Integer.valueOf((int) (num2 / 10.0f))));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_0)).setText(String.format("%d", Integer.valueOf((int) (num2 / 10.0f))));
                        return;
                    }
                    return;
                }
                if (TireUnit == 1) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                    if (num != 1.6777215E7f) {
                        float num3 = (1000.0f * (num * 100.0f)) / 6895.0f;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_0)).setText(String.format("%d.%d", Integer.valueOf((int) (num3 / 10.0f)), Integer.valueOf((int) (num3 % 10.0f))));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_0)).setText(String.format("%d.%d", Integer.valueOf((int) (num3 / 10.0f)), Integer.valueOf((int) (num3 % 10.0f))));
                        return;
                    }
                    return;
                }
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                if (num != 1.6777215E7f) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_0)).setText(String.format("%d.%d", Integer.valueOf((int) (num / 10.0f)), Integer.valueOf((int) (num % 10.0f))));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_0)).setText(String.format("%d.%d", Integer.valueOf((int) (num / 10.0f)), Integer.valueOf((int) (num % 10.0f))));
                    return;
                }
                return;
            }
            if (unit == 1) {
                int TireUnit2 = SystemProperties.getInt("persist.syu.reversetaiya", 0);
                if (TireUnit2 == 0) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                    if (num != 1.6777215E7f) {
                        float num4 = (6895.0f * num) / 1000.0f;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_0)).setText(String.format("%d", Integer.valueOf((int) num4)));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_0)).setText(String.format("%d", Integer.valueOf((int) num4)));
                        return;
                    }
                    return;
                }
                if (TireUnit2 == 2) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                    if (num != 1.6777215E7f) {
                        float num5 = (6895.0f * num) / 10000.0f;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_0)).setText(String.format("%d.%d", Integer.valueOf((int) (num5 / 10.0f)), Integer.valueOf((int) (num5 % 10.0f))));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_0)).setText(String.format("%d.%d", Integer.valueOf((int) (num5 / 10.0f)), Integer.valueOf((int) (num5 % 10.0f))));
                        return;
                    }
                    return;
                }
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                if (num != 1.6777215E7f) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_0)).setText(String.format("%d", Integer.valueOf((int) num)));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_0)).setText(String.format("%d", Integer.valueOf((int) num)));
                    return;
                }
                return;
            }
            if (unit == 2) {
                int TireUnit3 = SystemProperties.getInt("persist.syu.reversetaiya", 0);
                if (TireUnit3 == 1) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                    if (num != 1.6777215E7f) {
                        float num6 = ((25.0f * num) * 1000.0f) / 68950.0f;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_0)).setText(String.format("%d", Integer.valueOf((int) num6)));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_0)).setText(String.format("%d", Integer.valueOf((int) num6)));
                        return;
                    }
                    return;
                }
                if (TireUnit3 == 2) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                    if (num != 1.6777215E7f) {
                        float num7 = (25.0f * num) / 100.0f;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_0)).setText(String.format("%d.%d", Integer.valueOf((int) (num7 / 10.0f)), Integer.valueOf((int) (num7 % 10.0f))));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_0)).setText(String.format("%d.%d", Integer.valueOf((int) (num7 / 10.0f)), Integer.valueOf((int) (num7 % 10.0f))));
                        return;
                    }
                    return;
                }
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                if (num != 1.6777215E7f) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_0)).setText(String.format("%d.%d", Integer.valueOf((int) ((25.0f * num) / 10.0f)), Integer.valueOf((int) ((25.0f * num) % 10.0f))));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_0)).setText(String.format("%d.%d", Integer.valueOf((int) ((25.0f * num) / 10.0f)), Integer.valueOf((int) ((25.0f * num) % 10.0f))));
                }
            }
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[111];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        if (((TextView) findViewById(R.id.camry_tv_car_tire_1)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_1)) != null && ((TextView) findViewById(R.id.camry_tv_car_tire_unit)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_unit)) != null) {
            if (unit == 0) {
                int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
                if (TireUnit == 0) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                    if (num != 16777215) {
                        int num2 = num * 100;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_1)).setText(String.format("%d", Integer.valueOf(num2 / 10)));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_1)).setText(String.format("%d", Integer.valueOf(num2 / 10)));
                        return;
                    }
                    return;
                }
                if (TireUnit == 1) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                    if (num != 16777215) {
                        int num3 = ((num * 100) * 1000) / 6895;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_1)).setText(String.format("%d.%d", Integer.valueOf(num3 / 10), Integer.valueOf(num3 % 10)));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_1)).setText(String.format("%d.%d", Integer.valueOf(num3 / 10), Integer.valueOf(num3 % 10)));
                        return;
                    }
                    return;
                }
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                if (num != 16777215) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_1)).setText(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10)));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_1)).setText(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10)));
                    return;
                }
                return;
            }
            if (unit == 1) {
                int TireUnit2 = SystemProperties.getInt("persist.syu.reversetaiya", 0);
                if (TireUnit2 == 0) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                    if (num != 16777215) {
                        int num4 = (num * 6895) / 1000;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_1)).setText(String.format("%d", Integer.valueOf(num4)));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_1)).setText(String.format("%d", Integer.valueOf(num4)));
                        return;
                    }
                    return;
                }
                if (TireUnit2 == 2) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                    if (num != 16777215) {
                        int num5 = (num * 6895) / 10000;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_1)).setText(String.format("%d.%d", Integer.valueOf(num5 / 10), Integer.valueOf(num5 % 10)));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_1)).setText(String.format("%d.%d", Integer.valueOf(num5 / 10), Integer.valueOf(num5 % 10)));
                        return;
                    }
                    return;
                }
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                if (num != 16777215) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_1)).setText(String.format("%d", Integer.valueOf(num)));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_1)).setText(String.format("%d", Integer.valueOf(num)));
                    return;
                }
                return;
            }
            if (unit == 2) {
                int TireUnit3 = SystemProperties.getInt("persist.syu.reversetaiya", 0);
                if (TireUnit3 == 1) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                    if (num != 16777215) {
                        int num6 = ((num * 25) * 1000) / 68950;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_1)).setText(String.format("%d", Integer.valueOf(num6)));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_1)).setText(String.format("%d", Integer.valueOf(num6)));
                        return;
                    }
                    return;
                }
                if (TireUnit3 == 2) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                    if (num != 16777215) {
                        int num7 = (num * 25) / 100;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_1)).setText(String.format("%d.%d", Integer.valueOf(num7 / 10), Integer.valueOf(num7 % 10)));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_1)).setText(String.format("%d.%d", Integer.valueOf(num7 / 10), Integer.valueOf(num7 % 10)));
                        return;
                    }
                    return;
                }
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                if (num != 16777215) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_1)).setText(String.format("%d.%d", Integer.valueOf((num * 25) / 10), Integer.valueOf((num * 25) % 10)));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_1)).setText(String.format("%d.%d", Integer.valueOf((num * 25) / 10), Integer.valueOf((num * 25) % 10)));
                }
            }
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[112];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        if (((TextView) findViewById(R.id.camry_tv_car_tire_2)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_2)) != null && ((TextView) findViewById(R.id.camry_tv_car_tire_unit)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_unit)) != null) {
            if (unit == 0) {
                int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
                if (TireUnit == 0) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                    if (num != 16777215) {
                        int num2 = num * 100;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_2)).setText(String.format("%d", Integer.valueOf(num2 / 10)));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_2)).setText(String.format("%d", Integer.valueOf(num2 / 10)));
                        return;
                    }
                    return;
                }
                if (TireUnit == 1) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                    if (num != 16777215) {
                        int num3 = ((num * 100) * 1000) / 6895;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_2)).setText(String.format("%d.%d", Integer.valueOf(num3 / 10), Integer.valueOf(num3 % 10)));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_2)).setText(String.format("%d.%d", Integer.valueOf(num3 / 10), Integer.valueOf(num3 % 10)));
                        return;
                    }
                    return;
                }
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                if (num != 16777215) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_2)).setText(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10)));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_2)).setText(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10)));
                    return;
                }
                return;
            }
            if (unit == 1) {
                int TireUnit2 = SystemProperties.getInt("persist.syu.reversetaiya", 0);
                if (TireUnit2 == 0) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                    if (num != 16777215) {
                        int num4 = (num * 6895) / 1000;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_2)).setText(String.format("%d", Integer.valueOf(num4)));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_2)).setText(String.format("%d", Integer.valueOf(num4)));
                        return;
                    }
                    return;
                }
                if (TireUnit2 == 2) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                    if (num != 16777215) {
                        int num5 = (num * 6895) / 10000;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_2)).setText(String.format("%d.%d", Integer.valueOf(num5 / 10), Integer.valueOf(num5 % 10)));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_2)).setText(String.format("%d.%d", Integer.valueOf(num5 / 10), Integer.valueOf(num5 % 10)));
                        return;
                    }
                    return;
                }
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                if (num != 16777215) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_2)).setText(String.format("%d", Integer.valueOf(num)));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_2)).setText(String.format("%d", Integer.valueOf(num)));
                    return;
                }
                return;
            }
            if (unit == 2) {
                int TireUnit3 = SystemProperties.getInt("persist.syu.reversetaiya", 0);
                if (TireUnit3 == 1) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                    if (num != 16777215) {
                        int num6 = ((num * 25) * 1000) / 68950;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_2)).setText(String.format("%d", Integer.valueOf(num6)));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_2)).setText(String.format("%d", Integer.valueOf(num6)));
                        return;
                    }
                    return;
                }
                if (TireUnit3 == 2) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                    if (num != 16777215) {
                        int num7 = (num * 25) / 100;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_2)).setText(String.format("%d.%d", Integer.valueOf(num7 / 10), Integer.valueOf(num7 % 10)));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_2)).setText(String.format("%d.%d", Integer.valueOf(num7 / 10), Integer.valueOf(num7 % 10)));
                        return;
                    }
                    return;
                }
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                if (num != 16777215) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_2)).setText(String.format("%d.%d", Integer.valueOf((num * 25) / 10), Integer.valueOf((num * 25) % 10)));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_2)).setText(String.format("%d.%d", Integer.valueOf((num * 25) / 10), Integer.valueOf((num * 25) % 10)));
                }
            }
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[113];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        if (((TextView) findViewById(R.id.camry_tv_car_tire_3)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_3)) != null && ((TextView) findViewById(R.id.camry_tv_car_tire_unit)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_unit)) != null) {
            if (unit == 0) {
                int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
                if (TireUnit == 0) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                    if (num != 16777215) {
                        int num2 = num * 100;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_3)).setText(String.format("%d", Integer.valueOf(num2 / 10)));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_3)).setText(String.format("%d", Integer.valueOf(num2 / 10)));
                        return;
                    }
                    return;
                }
                if (TireUnit == 1) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                    if (num != 16777215) {
                        int num3 = ((num * 100) * 1000) / 6895;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_3)).setText(String.format("%d.%d", Integer.valueOf(num3 / 10), Integer.valueOf(num3 % 10)));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_3)).setText(String.format("%d.%d", Integer.valueOf(num3 / 10), Integer.valueOf(num3 % 10)));
                        return;
                    }
                    return;
                }
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                if (num != 16777215) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_3)).setText(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10)));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_3)).setText(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10)));
                    return;
                }
                return;
            }
            if (unit == 1) {
                int TireUnit2 = SystemProperties.getInt("persist.syu.reversetaiya", 0);
                if (TireUnit2 == 0) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                    if (num != 16777215) {
                        int num4 = (num * 6895) / 1000;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_3)).setText(String.format("%d", Integer.valueOf(num4)));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_3)).setText(String.format("%d", Integer.valueOf(num4)));
                        return;
                    }
                    return;
                }
                if (TireUnit2 == 2) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                    if (num != 16777215) {
                        int num5 = (num * 6895) / 10000;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_3)).setText(String.format("%d.%d", Integer.valueOf(num5 / 10), Integer.valueOf(num5 % 10)));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_3)).setText(String.format("%d.%d", Integer.valueOf(num5 / 10), Integer.valueOf(num5 % 10)));
                        return;
                    }
                    return;
                }
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                if (num != 16777215) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_3)).setText(String.format("%d", Integer.valueOf(num)));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_3)).setText(String.format("%d", Integer.valueOf(num)));
                    return;
                }
                return;
            }
            if (unit == 2) {
                int TireUnit3 = SystemProperties.getInt("persist.syu.reversetaiya", 0);
                if (TireUnit3 == 1) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                    if (num != 16777215) {
                        int num6 = ((num * 25) * 1000) / 68950;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_3)).setText(String.format("%d", Integer.valueOf(num6)));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_3)).setText(String.format("%d", Integer.valueOf(num6)));
                        return;
                    }
                    return;
                }
                if (TireUnit3 == 2) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                    if (num != 16777215) {
                        int num7 = (num * 25) / 100;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_3)).setText(String.format("%d.%d", Integer.valueOf(num7 / 10), Integer.valueOf(num7 % 10)));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_3)).setText(String.format("%d.%d", Integer.valueOf(num7 / 10), Integer.valueOf(num7 % 10)));
                        return;
                    }
                    return;
                }
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                if (num != 16777215) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_3)).setText(String.format("%d.%d", Integer.valueOf((num * 25) / 10), Integer.valueOf((num * 25) % 10)));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_3)).setText(String.format("%d.%d", Integer.valueOf((num * 25) / 10), Integer.valueOf((num * 25) % 10)));
                }
            }
        }
    }

    
    public void mUpdaterTireBackup() {
        int value = DataCanbus.DATA[114];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        if (((TextView) findViewById(R.id.camry_tv_car_tire_4)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_4)) != null && ((TextView) findViewById(R.id.camry_tv_car_tire_unit)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_unit)) != null) {
            if (unit == 0) {
                int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
                if (TireUnit == 0) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                    if (num != 16777215) {
                        int num2 = num * 100;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_4)).setText(String.format("%d", Integer.valueOf(num2 / 10)));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_4)).setText(String.format("%d", Integer.valueOf(num2 / 10)));
                        return;
                    }
                    return;
                }
                if (TireUnit == 1) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                    if (num != 16777215) {
                        int num3 = ((num * 100) * 1000) / 6895;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_4)).setText(String.format("%d.%d", Integer.valueOf(num3 / 10), Integer.valueOf(num3 % 10)));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_4)).setText(String.format("%d.%d", Integer.valueOf(num3 / 10), Integer.valueOf(num3 % 10)));
                        return;
                    }
                    return;
                }
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                if (num != 16777215) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_4)).setText(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10)));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_4)).setText(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10)));
                    return;
                }
                return;
            }
            if (unit == 1) {
                int TireUnit2 = SystemProperties.getInt("persist.syu.reversetaiya", 0);
                if (TireUnit2 == 0) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                    if (num != 16777215) {
                        int num4 = (num * 6895) / 1000;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_4)).setText(String.format("%d", Integer.valueOf(num4)));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_4)).setText(String.format("%d", Integer.valueOf(num4)));
                        return;
                    }
                    return;
                }
                if (TireUnit2 == 2) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                    if (num != 16777215) {
                        int num5 = (num * 6895) / 10000;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_4)).setText(String.format("%d.%d", Integer.valueOf(num5 / 10), Integer.valueOf(num5 % 10)));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_4)).setText(String.format("%d.%d", Integer.valueOf(num5 / 10), Integer.valueOf(num5 % 10)));
                        return;
                    }
                    return;
                }
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                if (num != 16777215) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_4)).setText(String.format("%d", Integer.valueOf(num)));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_4)).setText(String.format("%d", Integer.valueOf(num)));
                    return;
                }
                return;
            }
            if (unit == 2) {
                int TireUnit3 = SystemProperties.getInt("persist.syu.reversetaiya", 0);
                if (TireUnit3 == 1) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_PSI);
                    if (num != 16777215) {
                        int num6 = ((num * 25) * 1000) / 68950;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_4)).setText(String.format("%d", Integer.valueOf(num6)));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_4)).setText(String.format("%d", Integer.valueOf(num6)));
                        return;
                    }
                    return;
                }
                if (TireUnit3 == 2) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                    ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_BAR);
                    if (num != 16777215) {
                        int num7 = (num * 25) / 100;
                        ((TextView) findViewById(R.id.camry_tv_car_tire_4)).setText(String.format("%d.%d", Integer.valueOf(num7 / 10), Integer.valueOf(num7 % 10)));
                        ((TextView) findViewById(R.id.camry_tv_line_tire_4)).setText(String.format("%d.%d", Integer.valueOf(num7 / 10), Integer.valueOf(num7 % 10)));
                        return;
                    }
                    return;
                }
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                if (num != 16777215) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_4)).setText(String.format("%d.%d", Integer.valueOf((num * 25) / 10), Integer.valueOf((num * 25) % 10)));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_4)).setText(String.format("%d.%d", Integer.valueOf((num * 25) / 10), Integer.valueOf((num * 25) % 10)));
                }
            }
        }
    }

    
    public void mUpdaterExistTpms() {
        int existTpms = DataCanbus.DATA[106];
        int type = DataCanbus.DATA[109];
        if (findViewById(R.id.camry_layout_car) != null && findViewById(R.id.camry_layout_line) != null && findViewById(R.id.camry_layout_none) != null) {
            if (existTpms == 0) {
                findViewById(R.id.camry_layout_car).setVisibility(8);
                findViewById(R.id.camry_layout_line).setVisibility(8);
                findViewById(R.id.camry_layout_none).setVisibility(0);
            } else if (existTpms == 1) {
                if (type == 0) {
                    findViewById(R.id.camry_layout_car).setVisibility(8);
                    findViewById(R.id.camry_layout_line).setVisibility(0);
                    findViewById(R.id.camry_layout_none).setVisibility(8);
                } else if (type == 1) {
                    findViewById(R.id.camry_layout_car).setVisibility(0);
                    findViewById(R.id.camry_layout_line).setVisibility(8);
                    findViewById(R.id.camry_layout_none).setVisibility(8);
                }
            }
        }
    }

    
    public void mUpdaterShowTireBackup() {
        int value = DataCanbus.DATA[108];
        if (((TextView) findViewById(R.id.camry_tv_car_tire_4)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_4)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.camry_tv_car_tire_4)).setVisibility(8);
                ((TextView) findViewById(R.id.camry_tv_line_tire_4)).setVisibility(8);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.camry_tv_car_tire_4)).setVisibility(0);
                ((TextView) findViewById(R.id.camry_tv_line_tire_4)).setVisibility(0);
            }
        }
    }
}
