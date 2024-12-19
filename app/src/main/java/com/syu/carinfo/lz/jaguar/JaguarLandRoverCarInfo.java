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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class JaguarLandRoverCarInfo extends BaseActivity implements View.OnClickListener {
    int Distance_unit = 0;
    int Oil_unit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.jaguar.JaguarLandRoverCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 35:
                    JaguarLandRoverCarInfo.this.Distance_unit = value;
                    JaguarLandRoverCarInfo.this.updateTotalMileage();
                    JaguarLandRoverCarInfo.this.updateTravelableMilegae();
                    break;
                case 38:
                    JaguarLandRoverCarInfo.this.updateTravelableMilegae();
                    break;
                case 39:
                    JaguarLandRoverCarInfo.this.updateEngineSpeed();
                    break;
                case 81:
                    JaguarLandRoverCarInfo.this.updateHdcOnoff();
                    break;
                case 84:
                    JaguarLandRoverCarInfo.this.updateGearinfo();
                    break;
                case 85:
                    JaguarLandRoverCarInfo.this.updateDriveModeinfo();
                    break;
                case 86:
                    JaguarLandRoverCarInfo.this.updateSuspensioninfo();
                    break;
                case 87:
                    JaguarLandRoverCarInfo.this.updateTire1Distance();
                    break;
                case 88:
                    JaguarLandRoverCarInfo.this.updateTire2Distance();
                    break;
                case 89:
                    JaguarLandRoverCarInfo.this.updateTire3Distance();
                    break;
                case 90:
                    JaguarLandRoverCarInfo.this.updateTire4Distance();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_landrover_carinfo);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        updateTire1Distance_delay();
        updateTire2Distance_delay();
        updateTire3Distance_delay();
        updateTire4Distance_delay();
        updateFuelCons2();
        updateFuelCons1();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        v.getId();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[84].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[85].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[81].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[84].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[85].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
    }

    private void updateTire1Distance_delay() {
        if (((ImageView) findViewById(R.id.landrover_tire1)) != null) {
            ((ImageView) findViewById(R.id.landrover_tire1)).setImageDrawable(getResources().getDrawable(R.drawable.icon_landrover_tire));
            HandlerUI.getInstance().postDelayed(new Runnable() { // from class: com.syu.carinfo.lz.jaguar.JaguarLandRoverCarInfo.2
                @Override // java.lang.Runnable
                public void run() {
                    JaguarLandRoverCarInfo.this.updateTire1Distance();
                }
            }, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTire1Distance() {
        int value = DataCanbus.DATA[87];
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire1 = (ImageView) findViewById(R.id.landrover_tire1);
        if (mIvIconTire1 != null) {
            if (value <= 20) {
                mIvIconTire1.layout(mIvIconTire1.getLeft(), (mIvIconTire1.getTop() - 40) + ((value - 7) * 3), mIvIconTire1.getLeft() + mIvIconTire1.getWidth(), (mIvIconTire1.getTop() - 40) + ((value - 7) * 3) + mIvIconTire1.getHeight());
            } else {
                mIvIconTire1.layout(mIvIconTire1.getLeft(), mIvIconTire1.getTop() + ((value - 20) * 1), mIvIconTire1.getLeft() + mIvIconTire1.getWidth(), mIvIconTire1.getTop() + ((value - 20) * 1) + mIvIconTire1.getHeight());
            }
            mIvIconTire1.setImageDrawable(getResources().getDrawable(R.drawable.icon_landrover_tire));
        }
    }

    private void updateTire2Distance_delay() {
        ImageView mIvIconTire2 = (ImageView) findViewById(R.id.landrover_tire2);
        if (mIvIconTire2 != null) {
            mIvIconTire2.setImageDrawable(getResources().getDrawable(R.drawable.icon_landrover_tire));
            HandlerUI.getInstance().postDelayed(new Runnable() { // from class: com.syu.carinfo.lz.jaguar.JaguarLandRoverCarInfo.3
                @Override // java.lang.Runnable
                public void run() {
                    JaguarLandRoverCarInfo.this.updateTire2Distance();
                }
            }, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTire2Distance() {
        int value = DataCanbus.DATA[88];
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire2 = (ImageView) findViewById(R.id.landrover_tire2);
        if (mIvIconTire2 != null) {
            if (value <= 20) {
                mIvIconTire2.layout(mIvIconTire2.getLeft(), (mIvIconTire2.getTop() - 40) + ((value - 7) * 3), mIvIconTire2.getLeft() + mIvIconTire2.getWidth(), (mIvIconTire2.getTop() - 40) + ((value - 7) * 3) + mIvIconTire2.getHeight());
            } else {
                mIvIconTire2.layout(mIvIconTire2.getLeft(), mIvIconTire2.getTop() + ((value - 20) * 1), mIvIconTire2.getLeft() + mIvIconTire2.getWidth(), mIvIconTire2.getTop() + ((value - 20) * 1) + mIvIconTire2.getHeight());
            }
            mIvIconTire2.setImageDrawable(getResources().getDrawable(R.drawable.icon_landrover_tire));
        }
    }

    private void updateTire3Distance_delay() {
        ImageView mIvIconTire3 = (ImageView) findViewById(R.id.landrover_tire3);
        if (mIvIconTire3 != null) {
            mIvIconTire3.setImageDrawable(getResources().getDrawable(R.drawable.icon_landrover_tire));
            HandlerUI.getInstance().postDelayed(new Runnable() { // from class: com.syu.carinfo.lz.jaguar.JaguarLandRoverCarInfo.4
                @Override // java.lang.Runnable
                public void run() {
                    JaguarLandRoverCarInfo.this.updateTire3Distance();
                }
            }, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTire3Distance() {
        int value = DataCanbus.DATA[89];
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire3 = (ImageView) findViewById(R.id.landrover_tire3);
        if (mIvIconTire3 != null) {
            if (value <= 20) {
                mIvIconTire3.layout(mIvIconTire3.getLeft(), (mIvIconTire3.getTop() - 40) + ((value - 7) * 3), mIvIconTire3.getLeft() + mIvIconTire3.getWidth(), (mIvIconTire3.getTop() - 40) + ((value - 7) * 3) + mIvIconTire3.getHeight());
            } else {
                mIvIconTire3.layout(mIvIconTire3.getLeft(), mIvIconTire3.getTop() + ((value - 20) * 1), mIvIconTire3.getLeft() + mIvIconTire3.getWidth(), mIvIconTire3.getTop() + ((value - 20) * 1) + mIvIconTire3.getHeight());
            }
            mIvIconTire3.setImageDrawable(getResources().getDrawable(R.drawable.icon_landrover_tire));
        }
    }

    private void updateTire4Distance_delay() {
        ImageView mIvIconTire4 = (ImageView) findViewById(R.id.landrover_tire4);
        if (mIvIconTire4 != null) {
            mIvIconTire4.setImageDrawable(getResources().getDrawable(R.drawable.icon_landrover_tire));
            HandlerUI.getInstance().postDelayed(new Runnable() { // from class: com.syu.carinfo.lz.jaguar.JaguarLandRoverCarInfo.5
                @Override // java.lang.Runnable
                public void run() {
                    JaguarLandRoverCarInfo.this.updateTire4Distance();
                }
            }, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTire4Distance() {
        int value = DataCanbus.DATA[90];
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire4 = (ImageView) findViewById(R.id.landrover_tire4);
        if (mIvIconTire4 != null) {
            if (value <= 20) {
                mIvIconTire4.layout(mIvIconTire4.getLeft(), (mIvIconTire4.getTop() - 40) + ((value - 7) * 3), mIvIconTire4.getLeft() + mIvIconTire4.getWidth(), (mIvIconTire4.getTop() - 40) + ((value - 7) * 3) + mIvIconTire4.getHeight());
            } else {
                mIvIconTire4.layout(mIvIconTire4.getLeft(), mIvIconTire4.getTop() + ((value - 20) * 1), mIvIconTire4.getLeft() + mIvIconTire4.getWidth(), mIvIconTire4.getTop() + ((value - 20) * 1) + mIvIconTire4.getHeight());
            }
            mIvIconTire4.setImageDrawable(getResources().getDrawable(R.drawable.icon_landrover_tire));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSuspensioninfo() {
        int value = DataCanbus.DATA[86];
        if (((TextView) findViewById(R.id.landrover_suspension)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.landrover_suspension)).setText(R.string.driver_system_standard);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.landrover_suspension)).setText(R.string.str_17_off_road);
            } else if (value == 2) {
                ((TextView) findViewById(R.id.landrover_suspension)).setText(R.string.klc_air_auto);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDriveModeinfo() {
        int value = DataCanbus.DATA[85];
        if (((TextView) findViewById(R.id.landrover_driving_mode)) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGearinfo() {
        int value = DataCanbus.DATA[84];
        if (((TextView) findViewById(R.id.landrover_gearposition)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.landrover_gearposition)).setText("P");
                return;
            }
            if (value >= 1 && value <= 6) {
                ((TextView) findViewById(R.id.landrover_gearposition)).setText(new StringBuilder().append(value).toString());
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHdcOnoff() {
        int value = DataCanbus.DATA[81];
        if (((TextView) findViewById(R.id.landrover_hdc)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.landrover_hdc)).setText(R.string.str_xp_mzd_cx5_auto_door_lock_mode_0);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.landrover_hdc)).setText(R.string.wc_372_surroundstr0);
            }
        }
    }

    private void updateFuelCons2() {
        if (((TextView) findViewById(R.id.landrover_oil2)) != null) {
            ((TextView) findViewById(R.id.landrover_oil2)).setText("----");
        }
    }

    private void updateFuelCons1() {
        if (((TextView) findViewById(R.id.landrover_oil1)) != null) {
            ((TextView) findViewById(R.id.landrover_oil1)).setText("----");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTotalMileage() {
        if (((TextView) findViewById(R.id.landrover_travelled)) != null) {
            ((TextView) findViewById(R.id.landrover_travelled)).setText("----");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEngineSpeed() {
        int value = DataCanbus.DATA[39];
        if (((TextView) findViewById(R.id.landrover_motor_speed)) != null) {
            ((TextView) findViewById(R.id.landrover_motor_speed)).setText(String.valueOf(value) + " rpm");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTravelableMilegae() {
        int value = DataCanbus.DATA[38];
        if (((TextView) findViewById(R.id.landrover_driving_mileage)) != null) {
            if (this.Distance_unit == 0) {
                ((TextView) findViewById(R.id.landrover_driving_mileage)).setText(String.valueOf(value) + " km");
            } else if (this.Distance_unit == 1) {
                ((TextView) findViewById(R.id.landrover_driving_mileage)).setText(String.valueOf(value) + " mil");
            }
        }
    }
}
