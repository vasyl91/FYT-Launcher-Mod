package com.syu.carinfo.toyota.tangdu;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ToyotaTangduTireAct extends BaseActivity {
    public static ToyotaTangduTireAct mInit;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 111:
                    ToyotaTangduTireAct.this.mUpdaterExistTpms();
                    break;
                case 113:
                    ToyotaTangduTireAct.this.mUpdaterShowTireBackup();
                    break;
                case 114:
                    ToyotaTangduTireAct.this.mUpdaterExistTpms();
                    break;
                case 115:
                    ToyotaTangduTireAct.this.mUpdaterTireFL();
                    break;
                case 116:
                    ToyotaTangduTireAct.this.mUpdaterTireFR();
                    break;
                case 117:
                    ToyotaTangduTireAct.this.mUpdaterTireRL();
                    break;
                case 118:
                    ToyotaTangduTireAct.this.mUpdaterTireRR();
                    break;
                case 119:
                    ToyotaTangduTireAct.this.mUpdaterTireBackup();
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
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
    }

    @Override
    public void init() {
        mInit = this;
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[115];
        int unit = (value >> 24) & 255;
        float num = 16777215 & value;
        if (((TextView) findViewById(R.id.camry_tv_car_tire_0)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_0)) != null && ((TextView) findViewById(R.id.camry_tv_car_tire_unit)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_unit)) != null) {
            if (unit == 0) {
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
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText(CamryData.PRESSURE_UNIT_KPA);
                if (num != 1.6777215E7f) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_0)).setText(String.format("%d.%d", Integer.valueOf((int) ((num * 25.0f) / 10.0f)), Integer.valueOf((int) ((num * 25.0f) % 10.0f))));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_0)).setText(String.format("%d.%d", Integer.valueOf((int) ((num * 25.0f) / 10.0f)), Integer.valueOf((int) ((num * 25.0f) % 10.0f))));
                }
            }
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[116];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        if (((TextView) findViewById(R.id.camry_tv_car_tire_1)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_1)) != null && ((TextView) findViewById(R.id.camry_tv_car_tire_unit)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_unit)) != null) {
            if (unit == 0) {
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
        int value = DataCanbus.DATA[117];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        if (((TextView) findViewById(R.id.camry_tv_car_tire_2)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_2)) != null && ((TextView) findViewById(R.id.camry_tv_car_tire_unit)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_unit)) != null) {
            if (unit == 0) {
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
        int value = DataCanbus.DATA[118];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        if (((TextView) findViewById(R.id.camry_tv_car_tire_3)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_3)) != null && ((TextView) findViewById(R.id.camry_tv_car_tire_unit)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_unit)) != null) {
            if (unit == 0) {
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
        int value = DataCanbus.DATA[119];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        if (((TextView) findViewById(R.id.camry_tv_car_tire_4)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_4)) != null && ((TextView) findViewById(R.id.camry_tv_car_tire_unit)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_unit)) != null) {
            if (unit == 0) {
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
        int existTpms = DataCanbus.DATA[111];
        int type = DataCanbus.DATA[114];
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
        int value = DataCanbus.DATA[113];
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
