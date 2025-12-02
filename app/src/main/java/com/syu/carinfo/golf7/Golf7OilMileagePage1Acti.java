package com.syu.carinfo.golf7;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7OilMileagePage1Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 97:
                case 165:
                    Golf7OilMileagePage1Acti.this.mUpdaterAverageOil();
                    break;
                case 98:
                case 231:
                    Golf7OilMileagePage1Acti.this.mUpdaterDrivingMileage();
                    break;
                case 99:
                    Golf7OilMileagePage1Acti.this.mUpdaterRunningMileage();
                    break;
                case 100:
                    Golf7OilMileagePage1Acti.this.mUpdaterDrivingTime();
                    break;
                case 101:
                case 178:
                    Golf7OilMileagePage1Acti.this.mUpdaterAverageSpeed();
                    break;
                case 278:
                    if (((ImageView) Golf7OilMileagePage1Acti.this.findViewById(R.id.golf7_icon_car)) != null) {
                        Golf7OilMileagePage1Acti.this.mUpdaterRemainingOil();
                        break;
                    }
                case 381:
                case 382:
                    Golf7OilMileagePage1Acti.this.mUpdaterAverageDian();
                    break;
            }
        }
    };
    private int move_start = 0;
    private int move_end = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            //setContentView(R.layout.layout_golf7_oil_page1_od);
        } else {
            //setContentView(R.layout.layout_golf7_oil_page1);
        }
        init();
    }

    @Override
    public void init() {
        this.move_end = (50 - DataCanbus.DATA[278]) * 10;
        this.move_start = this.move_end;
        if (DataCanbus.DATA[1000] != 655520 && DataCanbus.DATA[1000] != 3801248 && DataCanbus.DATA[1000] != 393233 && DataCanbus.DATA[1000] != 458769) {
            findViewById(R.id.tv_text1).setVisibility(8);
            findViewById(R.id.layout_view1).setVisibility(8);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (((ImageView) findViewById(R.id.golf7_icon_car)) != null) {
            ((ImageView) findViewById(R.id.golf7_icon_car)).setImageDrawable(getResources().getDrawable(R.drawable.icon_car_null));
            HandlerUI.getInstance().postDelayed(new Runnable() { 
                @Override
                public void run() {
                    Golf7OilMileagePage1Acti.this.move_end = (50 - DataCanbus.DATA[278]) * 10;
                    Golf7OilMileagePage1Acti.this.move_start = Golf7OilMileagePage1Acti.this.move_end;
                    ((ImageView) Golf7OilMileagePage1Acti.this.findViewById(R.id.golf7_icon_car)).layout(Golf7OilMileagePage1Acti.this.move_end, 190, Golf7OilMileagePage1Acti.this.move_end + ((ImageView) Golf7OilMileagePage1Acti.this.findViewById(R.id.golf7_icon_car)).getWidth(), ((ImageView) Golf7OilMileagePage1Acti.this.findViewById(R.id.golf7_icon_car)).getHeight() + 190);
                    switch (DataCanbus.DATA[183]) {
                        case 1:
                            ((ImageView) Golf7OilMileagePage1Acti.this.findViewById(R.id.golf7_icon_car)).setImageDrawable(Golf7OilMileagePage1Acti.this.getResources().getDrawable(R.drawable.icon_car2));
                            break;
                        case 2:
                            ((ImageView) Golf7OilMileagePage1Acti.this.findViewById(R.id.golf7_icon_car)).setImageDrawable(Golf7OilMileagePage1Acti.this.getResources().getDrawable(R.drawable.icon_car));
                            break;
                        case 3:
                            ((ImageView) Golf7OilMileagePage1Acti.this.findViewById(R.id.golf7_icon_car)).setImageDrawable(Golf7OilMileagePage1Acti.this.getResources().getDrawable(R.drawable.icon_car3));
                            break;
                        case 4:
                            ((ImageView) Golf7OilMileagePage1Acti.this.findViewById(R.id.golf7_icon_car)).setImageDrawable(Golf7OilMileagePage1Acti.this.getResources().getDrawable(R.drawable.icon_car4));
                            break;
                        default:
                            ((ImageView) Golf7OilMileagePage1Acti.this.findViewById(R.id.golf7_icon_car)).setImageDrawable(Golf7OilMileagePage1Acti.this.getResources().getDrawable(R.drawable.icon_car2));
                            break;
                    }
                }
            }, 300L);
        }
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[278].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[231].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[381].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[382].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[278].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[231].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[381].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[382].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterAverageDian() {
        int value = DataCanbus.DATA[382] & 65535;
        int unit = DataCanbus.DATA[381] & 1;
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (unit == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km/kwh");
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + "kwh/100km");
            }
        }
    }

    
    public void mUpdaterAverageOil() {
        int value = DataCanbus.DATA[97];
        int unit_wc = DataCanbus.DATA[165] & 255;
        if (((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_oil)) != null) {
            if (ConstGolf.isWcGolf()) {
                if (value != 65535) {
                    ((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_oil)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + Golf7Data.mOilUnitXp1[unit_wc]);
                    return;
                } else {
                    ((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_oil)).setText("--.--");
                    return;
                }
            }
            int unit = ((-536870912) & value) >> 29;
            int mValue = value & 65535;
            if (mValue != 65535 && unit > -1 && unit < 4) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_oil)).setText(String.valueOf(mValue * 0.1f) + Golf7Data.mOilUnitXp1[unit]);
            } else if (unit > -1 && unit < 4) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_oil)).setText("--.--" + Golf7Data.mOilUnitXp1[unit]);
            }
        }
    }

    
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[98];
        int unit_wc = DataCanbus.DATA[231] & 255;
        if (((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_mileage)) != null) {
            if (ConstGolf.isWcGolf()) {
                if (value != 65535) {
                    ((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_mileage)).setText(String.valueOf(String.format("%d", Integer.valueOf(value))) + Golf7Data.mDistanceUnitWc[unit_wc]);
                    return;
                } else {
                    ((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_mileage)).setText("--");
                    return;
                }
            }
            int unit = (536870912 & value) >> 29;
            int mValue = value & 65535;
            if (unit > -1 && unit < 2) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_mileage)).setText(String.valueOf(mValue) + Golf7Data.mDistanceUnitXp[unit]);
            }
        }
    }

    
    public void mUpdaterRunningMileage() {
        int value = DataCanbus.DATA[99];
        int unit_wc = DataCanbus.DATA[231] & 255;
        if (((TextView) findViewById(R.id.golf7_tv_oil_since_start_running_mileage)) != null) {
            if (ConstGolf.isWcGolf()) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_running_mileage)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + Golf7Data.mDistanceUnitWc[unit_wc]);
                return;
            }
            int unit = (536870912 & value) >> 29;
            int mValue = value & 536870911;
            if (unit > -1 && unit < 2) {
                if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256) {
                    if (mValue < 500) {
                        ((TextView) findViewById(R.id.golf7_tv_oil_since_start_running_mileage)).setText(String.valueOf(mValue) + Golf7Data.mDistanceUnitXp[unit]);
                        return;
                    }
                    return;
                }
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_running_mileage)).setText(String.valueOf(mValue) + Golf7Data.mDistanceUnitXp[unit]);
            }
        }
    }

    
    public void mUpdaterDrivingTime() {
        int value = DataCanbus.DATA[100];
        if (((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_time)) != null) {
            if (ConstGolf.isWcGolf()) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_time)).setText(String.valueOf(value / 60) + " " + getResources().getString(R.string.time_hour) + " " + (value % 60) + " " + getResources().getString(R.string.time_minute));
            } else {
                int value2 = value & 16777215;
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_time)).setText(String.valueOf(value2 / 60) + " " + getResources().getString(R.string.time_hour) + " " + (value2 % 60) + " " + getResources().getString(R.string.time_minute));
            }
        }
    }

    
    public void mUpdaterAverageSpeed() {
        int value = DataCanbus.DATA[101];
        int unit_wc = DataCanbus.DATA[178] & 255;
        if (((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_velocity)) != null) {
            if (ConstGolf.isWcGolf()) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_velocity)).setText(String.valueOf(value) + Golf7Data.mSpeedUnitWc[unit_wc]);
                return;
            }
            int unit = (536870912 & value) >> 29;
            int mValue = value & 65535;
            if (unit > -1 && unit < 2) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_velocity)).setText(String.valueOf(mValue) + Golf7Data.mSpeedUnitXp[unit]);
            }
        }
    }

    private void car_move() {
        if (this.move_end != this.move_start) {
            TranslateAnimation car_moving = new TranslateAnimation(0.0f, this.move_end - this.move_start, 0.0f, 0.0f);
            car_moving.setDuration(3000L);
            ((ImageView) findViewById(R.id.golf7_icon_car)).startAnimation(car_moving);
            car_moving.setAnimationListener(new Animation.AnimationListener() { 
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    ((ImageView) Golf7OilMileagePage1Acti.this.findViewById(R.id.golf7_icon_car)).clearAnimation();
                    ((ImageView) Golf7OilMileagePage1Acti.this.findViewById(R.id.golf7_icon_car)).layout(Golf7OilMileagePage1Acti.this.move_end, ((ImageView) Golf7OilMileagePage1Acti.this.findViewById(R.id.golf7_icon_car)).getTop(), Golf7OilMileagePage1Acti.this.move_end + ((ImageView) Golf7OilMileagePage1Acti.this.findViewById(R.id.golf7_icon_car)).getWidth(), ((ImageView) Golf7OilMileagePage1Acti.this.findViewById(R.id.golf7_icon_car)).getHeight() + ((ImageView) Golf7OilMileagePage1Acti.this.findViewById(R.id.golf7_icon_car)).getTop());
                }
            });
        }
    }

    
    public void mUpdaterRemainingOil() {
        this.move_start = this.move_end;
        if (DataCanbus.DATA[278] < 50) {
            this.move_end = (50 - DataCanbus.DATA[278]) * 10;
        } else {
            this.move_end = 0;
        }
        car_move();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.setFlags(268435456);
                intent.addCategory("android.intent.category.HOME");
                startActivity(intent);
            } else {
                finish();
            }
        }
        return true;
    }
}
