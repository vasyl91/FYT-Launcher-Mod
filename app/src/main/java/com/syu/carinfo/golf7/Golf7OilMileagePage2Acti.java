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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Golf7OilMileagePage2Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7OilMileagePage2Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 5:
                case 68:
                    Golf7OilMileagePage2Acti.this.mUpdaterAverageOil();
                    break;
                case 6:
                case 177:
                    Golf7OilMileagePage2Acti.this.mUpdaterDrivingMileage();
                    break;
                case 7:
                    Golf7OilMileagePage2Acti.this.mUpdaterRunningMileage();
                    break;
                case 8:
                    Golf7OilMileagePage2Acti.this.mUpdaterDrivingTime();
                    break;
                case 9:
                case 81:
                    Golf7OilMileagePage2Acti.this.mUpdaterAverageSpeed();
                    break;
                case 236:
                    if (((ImageView) Golf7OilMileagePage2Acti.this.findViewById(R.id.golf7_icon_car)) != null) {
                        Golf7OilMileagePage2Acti.this.mUpdaterRemainingOil();
                        break;
                    }
                case 391:
                case 392:
                    Golf7OilMileagePage2Acti.this.mUpdaterAverageDian();
                    break;
            }
        }
    };
    private int move_start = 0;
    private int move_end = 0;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            setContentView(R.layout.layout_golf7_oil_page2_od);
        } else {
            setContentView(R.layout.layout_golf7_oil_page2);
        }
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.move_end = (50 - DataCanbus.DATA[236]) * 10;
        this.move_start = this.move_end;
        if (DataCanbus.DATA[1000] != 655520 && DataCanbus.DATA[1000] != 393233 && DataCanbus.DATA[1000] != 458769) {
            findViewById(R.id.tv_text1).setVisibility(8);
            findViewById(R.id.layout_view1).setVisibility(8);
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (((ImageView) findViewById(R.id.golf7_icon_car)) != null) {
            ((ImageView) findViewById(R.id.golf7_icon_car)).setImageDrawable(getResources().getDrawable(R.drawable.icon_car_null));
            HandlerUI.getInstance().postDelayed(new Runnable() { // from class: com.syu.carinfo.golf7.Golf7OilMileagePage2Acti.2
                @Override // java.lang.Runnable
                public void run() {
                    Golf7OilMileagePage2Acti.this.move_end = (50 - DataCanbus.DATA[236]) * 10;
                    Golf7OilMileagePage2Acti.this.move_start = Golf7OilMileagePage2Acti.this.move_end;
                    ((ImageView) Golf7OilMileagePage2Acti.this.findViewById(R.id.golf7_icon_car)).layout(Golf7OilMileagePage2Acti.this.move_end, 190, Golf7OilMileagePage2Acti.this.move_end + ((ImageView) Golf7OilMileagePage2Acti.this.findViewById(R.id.golf7_icon_car)).getWidth(), ((ImageView) Golf7OilMileagePage2Acti.this.findViewById(R.id.golf7_icon_car)).getHeight() + 190);
                    switch (DataCanbus.DATA[86]) {
                        case 1:
                            ((ImageView) Golf7OilMileagePage2Acti.this.findViewById(R.id.golf7_icon_car)).setImageDrawable(Golf7OilMileagePage2Acti.this.getResources().getDrawable(R.drawable.icon_car2));
                            break;
                        case 2:
                            ((ImageView) Golf7OilMileagePage2Acti.this.findViewById(R.id.golf7_icon_car)).setImageDrawable(Golf7OilMileagePage2Acti.this.getResources().getDrawable(R.drawable.icon_car));
                            break;
                        case 3:
                            ((ImageView) Golf7OilMileagePage2Acti.this.findViewById(R.id.golf7_icon_car)).setImageDrawable(Golf7OilMileagePage2Acti.this.getResources().getDrawable(R.drawable.icon_car3));
                            break;
                        case 4:
                            ((ImageView) Golf7OilMileagePage2Acti.this.findViewById(R.id.golf7_icon_car)).setImageDrawable(Golf7OilMileagePage2Acti.this.getResources().getDrawable(R.drawable.icon_car4));
                            break;
                        default:
                            ((ImageView) Golf7OilMileagePage2Acti.this.findViewById(R.id.golf7_icon_car)).setImageDrawable(Golf7OilMileagePage2Acti.this.getResources().getDrawable(R.drawable.icon_car2));
                            break;
                    }
                }
            }, 300L);
        }
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[236].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[81].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[391].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[392].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[236].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[391].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[392].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAverageDian() {
        int value = DataCanbus.DATA[392] & 65535;
        int unit = DataCanbus.DATA[391] & 1;
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (unit == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km/kwh");
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + "kwh/100km");
            }
        }
    }

    private void car_move() {
        if (this.move_end != this.move_start) {
            TranslateAnimation car_moving = new TranslateAnimation(0.0f, this.move_end - this.move_start, 0.0f, 0.0f);
            car_moving.setDuration(3000L);
            ((ImageView) findViewById(R.id.golf7_icon_car)).startAnimation(car_moving);
            car_moving.setAnimationListener(new Animation.AnimationListener() { // from class: com.syu.carinfo.golf7.Golf7OilMileagePage2Acti.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ((ImageView) Golf7OilMileagePage2Acti.this.findViewById(R.id.golf7_icon_car)).clearAnimation();
                    ((ImageView) Golf7OilMileagePage2Acti.this.findViewById(R.id.golf7_icon_car)).layout(Golf7OilMileagePage2Acti.this.move_end, ((ImageView) Golf7OilMileagePage2Acti.this.findViewById(R.id.golf7_icon_car)).getTop(), Golf7OilMileagePage2Acti.this.move_end + ((ImageView) Golf7OilMileagePage2Acti.this.findViewById(R.id.golf7_icon_car)).getWidth(), ((ImageView) Golf7OilMileagePage2Acti.this.findViewById(R.id.golf7_icon_car)).getHeight() + ((ImageView) Golf7OilMileagePage2Acti.this.findViewById(R.id.golf7_icon_car)).getTop());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRemainingOil() {
        this.move_start = this.move_end;
        if (DataCanbus.DATA[236] < 50) {
            this.move_end = (50 - DataCanbus.DATA[236]) * 10;
        } else {
            this.move_end = 0;
        }
        car_move();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAverageOil() {
        int value = DataCanbus.DATA[5];
        int unit_wc = DataCanbus.DATA[68] & 255;
        if (((TextView) findViewById(R.id.golf7_tv_oil_long_term_oil)) != null) {
            if (ConstGolf.isWcGolf()) {
                if (value != 65535) {
                    ((TextView) findViewById(R.id.golf7_tv_oil_long_term_oil)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + Golf7Data.mOilUnitXp1[unit_wc]);
                    return;
                } else {
                    ((TextView) findViewById(R.id.golf7_tv_oil_long_term_oil)).setText("--.--");
                    return;
                }
            }
            int unit = ((-536870912) & value) >> 29;
            int mValue = value & 65535;
            if (mValue != 65535 && unit > -1 && unit < 4) {
                ((TextView) findViewById(R.id.golf7_tv_oil_long_term_oil)).setText(String.valueOf(mValue * 0.1f) + Golf7Data.mOilUnitXp1[unit]);
            } else if (unit > -1 && unit < 4) {
                ((TextView) findViewById(R.id.golf7_tv_oil_long_term_oil)).setText("--.--" + Golf7Data.mOilUnitXp1[unit]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[6];
        int unit_wc = DataCanbus.DATA[177] & 255;
        if (((TextView) findViewById(R.id.golf7_tv_oil_long_term_driving_mileage)) != null) {
            if (ConstGolf.isWcGolf()) {
                if (value != 65535) {
                    ((TextView) findViewById(R.id.golf7_tv_oil_long_term_driving_mileage)).setText(String.valueOf(String.format("%d", Integer.valueOf(value))) + Golf7Data.mDistanceUnitWc[unit_wc]);
                    return;
                } else {
                    ((TextView) findViewById(R.id.golf7_tv_oil_long_term_driving_mileage)).setText("--");
                    return;
                }
            }
            int unit = (536870912 & value) >> 29;
            int mValue = value & 65535;
            if (unit > -1 && unit < 2) {
                ((TextView) findViewById(R.id.golf7_tv_oil_long_term_driving_mileage)).setText(String.valueOf(mValue) + Golf7Data.mDistanceUnitXp[unit]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRunningMileage() {
        int value = DataCanbus.DATA[7];
        int unit_wc = DataCanbus.DATA[177] & 255;
        if (((TextView) findViewById(R.id.golf7_tv_oil_long_term_running_mileage)) != null) {
            if (ConstGolf.isWcGolf()) {
                ((TextView) findViewById(R.id.golf7_tv_oil_long_term_running_mileage)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + Golf7Data.mDistanceUnitWc[unit_wc]);
                return;
            }
            int unit = (536870912 & value) >> 29;
            int mValue = value & 536870911;
            if (unit > -1 && unit < 2) {
                ((TextView) findViewById(R.id.golf7_tv_oil_long_term_running_mileage)).setText(String.valueOf(mValue) + Golf7Data.mDistanceUnitXp[unit]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingTime() {
        int value = DataCanbus.DATA[8];
        if (((TextView) findViewById(R.id.golf7_tv_oil_long_term_driving_time)) != null) {
            if (ConstGolf.isWcGolf()) {
                ((TextView) findViewById(R.id.golf7_tv_oil_long_term_driving_time)).setText(String.valueOf(value / 60) + " " + getResources().getString(R.string.time_hour) + " " + (value % 60) + " " + getResources().getString(R.string.time_minute));
            } else {
                int value2 = value & 16777215;
                ((TextView) findViewById(R.id.golf7_tv_oil_long_term_driving_time)).setText(String.valueOf(value2 / 60) + " " + getResources().getString(R.string.time_hour) + " " + (value2 % 60) + " " + getResources().getString(R.string.time_minute));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAverageSpeed() {
        int value = DataCanbus.DATA[9];
        int unit_wc = DataCanbus.DATA[81] & 255;
        if (((TextView) findViewById(R.id.golf7_tv_oil_long_term_term_velocity)) != null) {
            if (ConstGolf.isWcGolf()) {
                ((TextView) findViewById(R.id.golf7_tv_oil_long_term_term_velocity)).setText(String.valueOf(value) + Golf7Data.mSpeedUnitWc[unit_wc]);
                return;
            }
            int unit = (536870912 & value) >> 29;
            int mValue = value & 65535;
            if (unit > -1 && unit < 2) {
                ((TextView) findViewById(R.id.golf7_tv_oil_long_term_term_velocity)).setText(String.valueOf(mValue) + Golf7Data.mSpeedUnitXp[unit]);
            }
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
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
