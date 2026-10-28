package com.syu.carinfo.lz.landrover;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

@SuppressWarnings({"deprecation", "unchecked"})
public class LandRoverCarInfo extends BaseActivity implements View.OnClickListener {
    int Distance_unit = 0;
    int Oil_unit = 0;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 7:
                    LandRoverCarInfo.this.updateTravelableMilegae();
                    break;
                case 8:
                    LandRoverCarInfo.this.updateEngineSpeed();
                    break;
                case 9:
                    LandRoverCarInfo.this.updateTotalMileage();
                    break;
                case 10:
                    LandRoverCarInfo.this.updateFuelCons1();
                    break;
                case 11:
                    LandRoverCarInfo.this.updateFuelCons2();
                    break;
                case 17:
                    LandRoverCarInfo.this.Oil_unit = value;
                    LandRoverCarInfo.this.updateFuelCons1();
                    LandRoverCarInfo.this.updateFuelCons2();
                    break;
                case 18:
                    LandRoverCarInfo.this.Distance_unit = value;
                    LandRoverCarInfo.this.updateTotalMileage();
                    LandRoverCarInfo.this.updateTravelableMilegae();
                    break;
                case 19:
                    LandRoverCarInfo.this.updateHdcOnoff();
                    break;
                case 20:
                    LandRoverCarInfo.this.updateGearinfo();
                    break;
                case 22:
                    LandRoverCarInfo.this.updateDriveModeinfo();
                    break;
                case 23:
                    LandRoverCarInfo.this.updateSuspensioninfo();
                    break;
                case 24:
                    LandRoverCarInfo.this.updateTire1Distance();
                    break;
                case 25:
                    LandRoverCarInfo.this.updateTire2Distance();
                    break;
                case 26:
                    LandRoverCarInfo.this.updateTire3Distance();
                    break;
                case 27:
                    LandRoverCarInfo.this.updateTire4Distance();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_landrover_carinfo);
        setListener();
    }

    private void setListener() {
        findViewById(R.id.btn_landrover_oil1_reset).setOnClickListener(this);
        findViewById(R.id.btn_landrover_oil2_reset).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateTire1Distance_delay();
        updateTire2Distance_delay();
        updateTire3Distance_delay();
        updateTire4Distance_delay();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_landrover_oil1_reset /* 2131428225 */:
                setCarInfo(13, 0);
                break;
            case R.id.btn_landrover_oil2_reset /* 2131428226 */:
                setCarInfo(13, 1);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, value1, value2);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
    }

    private void updateTire1Distance_delay() {
        if (findViewById(R.id.landrover_tire1) != null) {
            ((ImageView) findViewById(R.id.landrover_tire1)).setImageDrawable(getResources().getDrawable(R.drawable.icon_landrover_tire));
            HandlerUI.getInstance().postDelayed(new Runnable() { 
                @Override
                public void run() {
                    LandRoverCarInfo.this.updateTire1Distance();
                }
            }, 300L);
        }
    }

    
    public void updateTire1Distance() {
        int value = DataCanbus.DATA[24];
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire1 = findViewById(R.id.landrover_tire1);
        if (mIvIconTire1 != null) {
            if (value <= 20) {
                mIvIconTire1.layout(mIvIconTire1.getLeft(), (mIvIconTire1.getTop() - 40) + ((value - 7) * 3), mIvIconTire1.getLeft() + mIvIconTire1.getWidth(), (mIvIconTire1.getTop() - 40) + ((value - 7) * 3) + mIvIconTire1.getHeight());
            } else {
                mIvIconTire1.layout(mIvIconTire1.getLeft(), mIvIconTire1.getTop() + ((value - 20)), mIvIconTire1.getLeft() + mIvIconTire1.getWidth(), mIvIconTire1.getTop() + ((value - 20)) + mIvIconTire1.getHeight());
            }
            mIvIconTire1.setImageDrawable(getResources().getDrawable(R.drawable.icon_landrover_tire));
        }
    }

    private void updateTire2Distance_delay() {
        ImageView mIvIconTire2 = findViewById(R.id.landrover_tire2);
        if (mIvIconTire2 != null) {
            mIvIconTire2.setImageDrawable(getResources().getDrawable(R.drawable.icon_landrover_tire));
            HandlerUI.getInstance().postDelayed(new Runnable() { 
                @Override
                public void run() {
                    LandRoverCarInfo.this.updateTire2Distance();
                }
            }, 300L);
        }
    }

    
    public void updateTire2Distance() {
        int value = DataCanbus.DATA[25];
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire2 = findViewById(R.id.landrover_tire2);
        if (mIvIconTire2 != null) {
            if (value <= 20) {
                mIvIconTire2.layout(mIvIconTire2.getLeft(), (mIvIconTire2.getTop() - 40) + ((value - 7) * 3), mIvIconTire2.getLeft() + mIvIconTire2.getWidth(), (mIvIconTire2.getTop() - 40) + ((value - 7) * 3) + mIvIconTire2.getHeight());
            } else {
                mIvIconTire2.layout(mIvIconTire2.getLeft(), mIvIconTire2.getTop() + ((value - 20)), mIvIconTire2.getLeft() + mIvIconTire2.getWidth(), mIvIconTire2.getTop() + ((value - 20)) + mIvIconTire2.getHeight());
            }
            mIvIconTire2.setImageDrawable(getResources().getDrawable(R.drawable.icon_landrover_tire));
        }
    }

    private void updateTire3Distance_delay() {
        ImageView mIvIconTire3 = findViewById(R.id.landrover_tire3);
        if (mIvIconTire3 != null) {
            mIvIconTire3.setImageDrawable(getResources().getDrawable(R.drawable.icon_landrover_tire));
            HandlerUI.getInstance().postDelayed(new Runnable() { 
                @Override
                public void run() {
                    LandRoverCarInfo.this.updateTire3Distance();
                }
            }, 300L);
        }
    }

    
    public void updateTire3Distance() {
        int value = DataCanbus.DATA[26];
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire3 = findViewById(R.id.landrover_tire3);
        if (mIvIconTire3 != null) {
            if (value <= 20) {
                mIvIconTire3.layout(mIvIconTire3.getLeft(), (mIvIconTire3.getTop() - 40) + ((value - 7) * 3), mIvIconTire3.getLeft() + mIvIconTire3.getWidth(), (mIvIconTire3.getTop() - 40) + ((value - 7) * 3) + mIvIconTire3.getHeight());
            } else {
                mIvIconTire3.layout(mIvIconTire3.getLeft(), mIvIconTire3.getTop() + ((value - 20)), mIvIconTire3.getLeft() + mIvIconTire3.getWidth(), mIvIconTire3.getTop() + ((value - 20)) + mIvIconTire3.getHeight());
            }
            mIvIconTire3.setImageDrawable(getResources().getDrawable(R.drawable.icon_landrover_tire));
        }
    }

    private void updateTire4Distance_delay() {
        ImageView mIvIconTire4 = findViewById(R.id.landrover_tire4);
        if (mIvIconTire4 != null) {
            mIvIconTire4.setImageDrawable(getResources().getDrawable(R.drawable.icon_landrover_tire));
            HandlerUI.getInstance().postDelayed(new Runnable() { 
                @Override
                public void run() {
                    LandRoverCarInfo.this.updateTire4Distance();
                }
            }, 300L);
        }
    }

    
    public void updateTire4Distance() {
        int value = DataCanbus.DATA[27];
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire4 = findViewById(R.id.landrover_tire4);
        if (mIvIconTire4 != null) {
            if (value <= 20) {
                mIvIconTire4.layout(mIvIconTire4.getLeft(), (mIvIconTire4.getTop() - 40) + ((value - 7) * 3), mIvIconTire4.getLeft() + mIvIconTire4.getWidth(), (mIvIconTire4.getTop() - 40) + ((value - 7) * 3) + mIvIconTire4.getHeight());
            } else {
                mIvIconTire4.layout(mIvIconTire4.getLeft(), mIvIconTire4.getTop() + ((value - 20)), mIvIconTire4.getLeft() + mIvIconTire4.getWidth(), mIvIconTire4.getTop() + ((value - 20)) + mIvIconTire4.getHeight());
            }
            mIvIconTire4.setImageDrawable(getResources().getDrawable(R.drawable.icon_landrover_tire));
        }
    }

    
    public void updateSuspensioninfo() {
        int value = DataCanbus.DATA[23];
        if (findViewById(R.id.landrover_suspension) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.landrover_suspension)).setText(R.string.driver_system_standard);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.landrover_suspension)).setText(R.string.str_17_off_road);
            } else if (value == 2) {
                ((TextView) findViewById(R.id.landrover_suspension)).setText(R.string.klc_air_auto);
            }
        }
    }

    
    public void updateDriveModeinfo() {
        int value = DataCanbus.DATA[22];
        if (findViewById(R.id.landrover_driving_mode) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.landrover_driving_mode)).setText(R.string.str_mode_normal);
                return;
            }
            if (value == 1) {
                ((TextView) findViewById(R.id.landrover_driving_mode)).setText(R.string.str_grass_gravel_snow);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.landrover_driving_mode)).setText(R.string.str_mud_ruts);
            } else if (value == 3) {
                ((TextView) findViewById(R.id.landrover_driving_mode)).setText(R.string.str_sand);
            } else if (value == 4) {
                ((TextView) findViewById(R.id.landrover_driving_mode)).setText(R.string.str_rock_crawl);
            }
        }
    }

    
    public void updateGearinfo() {
        int value = DataCanbus.DATA[20];
        if (findViewById(R.id.landrover_gearposition) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.landrover_gearposition)).setText("---");
            } else if (value == 1) {
                ((TextView) findViewById(R.id.landrover_gearposition)).setText(R.string.setting_313_basic21str);
            } else if (value == 2) {
                ((TextView) findViewById(R.id.landrover_gearposition)).setText(R.string.setting_313_basic22str);
            }
        }
    }

    
    public void updateHdcOnoff() {
        int value = DataCanbus.DATA[19];
        if (findViewById(R.id.landrover_hdc) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.landrover_hdc)).setText(R.string.str_xp_mzd_cx5_auto_door_lock_mode_0);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.landrover_hdc)).setText(R.string.wc_372_surroundstr0);
            }
        }
    }

    
    public void updateFuelCons2() {
        int value = DataCanbus.DATA[11];
        if (findViewById(R.id.landrover_oil2) != null) {
            if (this.Oil_unit == 0) {
                ((TextView) findViewById(R.id.landrover_oil2)).setText(value / 10.0f + " l/100km");
            } else if (this.Oil_unit == 1) {
                ((TextView) findViewById(R.id.landrover_oil2)).setText(value / 10.0f + " mpg");
            } else if (this.Oil_unit == 2) {
                ((TextView) findViewById(R.id.landrover_oil2)).setText(value / 10.0f + " km/l");
            }
        }
    }

    
    public void updateFuelCons1() {
        int value = DataCanbus.DATA[10];
        if (findViewById(R.id.landrover_oil1) != null) {
            if (this.Oil_unit == 0) {
                ((TextView) findViewById(R.id.landrover_oil1)).setText(value / 10.0f + " l/100km");
            } else if (this.Oil_unit == 1) {
                ((TextView) findViewById(R.id.landrover_oil1)).setText(value / 10.0f + " mpg");
            } else if (this.Oil_unit == 2) {
                ((TextView) findViewById(R.id.landrover_oil1)).setText(value / 10.0f + " km/l");
            }
        }
    }

    
    public void updateTotalMileage() {
        int value = DataCanbus.DATA[9];
        if (findViewById(R.id.landrover_travelled) != null) {
            if (this.Distance_unit == 0) {
                ((TextView) findViewById(R.id.landrover_travelled)).setText(value + " km");
            } else if (this.Distance_unit == 1) {
                ((TextView) findViewById(R.id.landrover_travelled)).setText(value + " mil");
            }
        }
    }

    
    public void updateEngineSpeed() {
        int value = DataCanbus.DATA[8];
        if (findViewById(R.id.landrover_motor_speed) != null) {
            ((TextView) findViewById(R.id.landrover_motor_speed)).setText(value + " rpm");
        }
    }

    
    public void updateTravelableMilegae() {
        int value = DataCanbus.DATA[7];
        if (findViewById(R.id.landrover_driving_mileage) != null) {
            if (this.Distance_unit == 0) {
                ((TextView) findViewById(R.id.landrover_driving_mileage)).setText(value + " km");
            } else if (this.Distance_unit == 1) {
                ((TextView) findViewById(R.id.landrover_driving_mileage)).setText(value + " mil");
            }
        }
    }
}
