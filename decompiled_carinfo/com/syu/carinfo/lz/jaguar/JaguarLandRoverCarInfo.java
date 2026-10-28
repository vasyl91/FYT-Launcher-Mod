package com.syu.carinfo.lz.jaguar;

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
public class JaguarLandRoverCarInfo extends BaseActivity implements View.OnClickListener {
    int Distance_unit = 0;
    int Oil_unit = 0;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 106:
                    JaguarLandRoverCarInfo.this.Distance_unit = value;
                    JaguarLandRoverCarInfo.this.updateTotalMileage();
                    JaguarLandRoverCarInfo.this.updateTravelableMilegae();
                    break;
                case 109:
                    JaguarLandRoverCarInfo.this.updateTravelableMilegae();
                    break;
                case 110:
                    JaguarLandRoverCarInfo.this.updateEngineSpeed();
                    break;
                case 144:
                    JaguarLandRoverCarInfo.this.updateHdcOnoff();
                    break;
                case 147:
                    JaguarLandRoverCarInfo.this.updateGearinfo();
                    break;
                case 148:
                    JaguarLandRoverCarInfo.this.updateDriveModeinfo();
                    break;
                case 149:
                    JaguarLandRoverCarInfo.this.updateSuspensioninfo();
                    break;
                case 150:
                    JaguarLandRoverCarInfo.this.updateTire1Distance();
                    break;
                case 151:
                    JaguarLandRoverCarInfo.this.updateTire2Distance();
                    break;
                case 152:
                    JaguarLandRoverCarInfo.this.updateTire3Distance();
                    break;
                case 153:
                    JaguarLandRoverCarInfo.this.updateTire4Distance();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_landrover_carinfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateTire1Distance_delay();
        updateTire2Distance_delay();
        updateTire3Distance_delay();
        updateTire4Distance_delay();
        updateFuelCons2();
        updateFuelCons1();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        v.getId();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
    }

    private void updateTire1Distance_delay() {
        if (findViewById(R.id.landrover_tire1) != null) {
            ((ImageView) findViewById(R.id.landrover_tire1)).setImageDrawable(getResources().getDrawable(R.drawable.icon_landrover_tire));
            HandlerUI.getInstance().postDelayed(new Runnable() { 
                @Override
                public void run() {
                    JaguarLandRoverCarInfo.this.updateTire1Distance();
                }
            }, 300L);
        }
    }

    
    public void updateTire1Distance() {
        int value = DataCanbus.DATA[150];
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
                    JaguarLandRoverCarInfo.this.updateTire2Distance();
                }
            }, 300L);
        }
    }

    
    public void updateTire2Distance() {
        int value = DataCanbus.DATA[151];
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
                    JaguarLandRoverCarInfo.this.updateTire3Distance();
                }
            }, 300L);
        }
    }

    
    public void updateTire3Distance() {
        int value = DataCanbus.DATA[152];
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
                    JaguarLandRoverCarInfo.this.updateTire4Distance();
                }
            }, 300L);
        }
    }

    
    public void updateTire4Distance() {
        int value = DataCanbus.DATA[153];
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
        int value = DataCanbus.DATA[149];
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
        int value = DataCanbus.DATA[148];
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
        int value = DataCanbus.DATA[147];
        if (findViewById(R.id.landrover_gearposition) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.landrover_gearposition)).setText("P");
                return;
            }
            if (value >= 1 && value <= 6) {
                ((TextView) findViewById(R.id.landrover_gearposition)).setText(String.valueOf(value));
                return;
            }
            if (value == 7) {
                ((TextView) findViewById(R.id.landrover_gearposition)).setText("R");
            } else if (value == 8) {
                ((TextView) findViewById(R.id.landrover_gearposition)).setText("D");
            } else if (value == 9) {
                ((TextView) findViewById(R.id.landrover_gearposition)).setText("M");
            }
        }
    }

    
    public void updateHdcOnoff() {
        int value = DataCanbus.DATA[144];
        if (findViewById(R.id.landrover_hdc) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.landrover_hdc)).setText(R.string.str_xp_mzd_cx5_auto_door_lock_mode_0);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.landrover_hdc)).setText(R.string.wc_372_surroundstr0);
            }
        }
    }

    private void updateFuelCons2() {
        if (findViewById(R.id.landrover_oil2) != null) {
            ((TextView) findViewById(R.id.landrover_oil2)).setText("----");
        }
    }

    private void updateFuelCons1() {
        if (findViewById(R.id.landrover_oil1) != null) {
            ((TextView) findViewById(R.id.landrover_oil1)).setText("----");
        }
    }

    
    public void updateTotalMileage() {
        if (findViewById(R.id.landrover_travelled) != null) {
            ((TextView) findViewById(R.id.landrover_travelled)).setText("----");
        }
    }

    
    public void updateEngineSpeed() {
        int value = DataCanbus.DATA[110];
        if (findViewById(R.id.landrover_motor_speed) != null) {
            ((TextView) findViewById(R.id.landrover_motor_speed)).setText(value + " rpm");
        }
    }

    
    public void updateTravelableMilegae() {
        int value = DataCanbus.DATA[109];
        if (findViewById(R.id.landrover_driving_mileage) != null) {
            if (this.Distance_unit == 0) {
                ((TextView) findViewById(R.id.landrover_driving_mileage)).setText(value + " km");
            } else if (this.Distance_unit == 1) {
                ((TextView) findViewById(R.id.landrover_driving_mileage)).setText(value + " mil");
            }
        }
    }
}
