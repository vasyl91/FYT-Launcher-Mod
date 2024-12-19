package com.syu.carinfo.wccamry;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.camry2012.xp.CamryicPetrolElectricActi;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Rav4TripAct extends BaseActivity {
    private VerticalProgressbar mProgressbarCur;
    private VerticalProgressbar[] mProgressbar = new VerticalProgressbar[30];
    private TextView[] mOilTv = new TextView[4];
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wccamry.Rav4TripAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    Rav4TripAct.this.mUpdaterOilExpend();
                    break;
                case 1:
                    Rav4TripAct.this.mUpdaterDrivingMileage();
                    break;
                case 2:
                    Rav4TripAct.this.mUpdaterAveragVelocity();
                    break;
                case 3:
                    Rav4TripAct.this.mUpdaterDrivingTime();
                    break;
                case 19:
                    if (ints == null) {
                        for (int i = 0; i < 30; i++) {
                            int[] ints2 = ConstWcToyota.mMinuteoilexpend[i];
                            if (ints2 == null) {
                                ints2 = new int[]{i};
                            }
                            Rav4TripAct.this.mUpdaterOilValue(ints2);
                        }
                        break;
                    } else {
                        Rav4TripAct.this.mUpdaterOilValue(ints);
                        break;
                    }
                case 30:
                    Rav4TripAct.this.mUpdaterPeenable();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rav4_trip);
        init();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] == 33) {
            if (findViewById(R.id.rav4_view_driving_time) != null) {
                findViewById(R.id.rav4_view_driving_time).setVisibility(8);
            }
            if (((TextView) findViewById(R.id.rav4_tv_average_velocity_text)) != null) {
                ((TextView) findViewById(R.id.rav4_tv_average_velocity_text)).setText(R.string.curr_velocity);
            }
        } else if (DataCanbus.DATA[1000] == 1442086) {
            if (findViewById(R.id.camry_btn_tire) != null) {
                findViewById(R.id.camry_btn_tire).setVisibility(8);
            }
            if (findViewById(R.id.rav4_view_driving_time) != null) {
                findViewById(R.id.rav4_view_driving_time).setVisibility(0);
            }
            if (((TextView) findViewById(R.id.rav4_tv_average_velocity_text)) != null) {
                ((TextView) findViewById(R.id.rav4_tv_average_velocity_text)).setText(R.string.average_velocity);
            }
        } else {
            if (findViewById(R.id.rav4_view_driving_time) != null) {
                findViewById(R.id.rav4_view_driving_time).setVisibility(0);
            }
            if (((TextView) findViewById(R.id.rav4_tv_average_velocity_text)) != null) {
                ((TextView) findViewById(R.id.rav4_tv_average_velocity_text)).setText(R.string.average_velocity);
            }
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
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mProgressbar[0] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_0);
        this.mProgressbar[1] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_1);
        this.mProgressbar[2] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_2);
        this.mProgressbar[3] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_3);
        this.mProgressbar[4] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_4);
        this.mProgressbar[5] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_5);
        this.mProgressbar[6] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_6);
        this.mProgressbar[7] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_7);
        this.mProgressbar[8] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_8);
        this.mProgressbar[9] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_9);
        this.mProgressbar[10] = (VerticalProgressbar) findViewById(R.id.progressbar_1rav4_0);
        this.mProgressbar[11] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_11);
        this.mProgressbar[12] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_12);
        this.mProgressbar[13] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_13);
        this.mProgressbar[14] = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_14);
        this.mProgressbarCur = (VerticalProgressbar) findViewById(R.id.rav4_progressbar_cur);
        this.mOilTv[0] = (TextView) findViewById(R.id.rav4_tv_oil_0);
        this.mOilTv[1] = (TextView) findViewById(R.id.rav4_tv_oil_1);
        this.mOilTv[2] = (TextView) findViewById(R.id.rav4_tv_oil_2);
        this.mOilTv[3] = (TextView) findViewById(R.id.rav4_tv_oil_3);
        ((Button) findViewById(R.id.rav4_btn_car_pe)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4TripAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Rav4TripAct.this, CamryicPetrolElectricActi.class);
                    Rav4TripAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_tire)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4TripAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Rav4TripAct.this, CamryTireActWC.class);
                    Rav4TripAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.rav4_btn_iol_expend)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4TripAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Rav4TripAct.this, Rav4HistoryAct.class);
                    Rav4TripAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.rav4_btn_clear)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4TripAct.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(14, null, null, null);
            }
        });
        ((Button) findViewById(R.id.rav4_btn_setting)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4TripAct.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[1000] == 33) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(Rav4TripAct.this, ReizSettingsAct.class);
                        Rav4TripAct.this.startActivity(intent);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                if ((DataCanbus.DATA[1000] & 65535) == 294) {
                    try {
                        Intent intent2 = new Intent();
                        intent2.setClass(Rav4TripAct.this, Rav4SettingsAct.class);
                        Rav4TripAct.this.startActivity(intent2);
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                if (DataCanbus.DATA[1000] == 1966374 || DataCanbus.DATA[1000] == 2097446 || DataCanbus.DATA[1000] == 2228518 || DataCanbus.DATA[1000] == 2162982) {
                    try {
                        Intent intent3 = new Intent();
                        intent3.setClass(Rav4TripAct.this, PradoSettingsAct.class);
                        Rav4TripAct.this.startActivity(intent3);
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                try {
                    Intent intent4 = new Intent();
                    intent4.setClass(Rav4TripAct.this, CorollaSettingsAct.class);
                    Rav4TripAct.this.startActivity(intent4);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterPeenable() {
        if (is_wc_canbus()) {
            int value = DataCanbus.DATA[30];
            if (((Button) findViewById(R.id.rav4_btn_car_pe)) != null) {
                ((Button) findViewById(R.id.rav4_btn_car_pe)).setVisibility(value == 0 ? 4 : 0);
                return;
            }
            return;
        }
        if (((Button) findViewById(R.id.rav4_btn_car_pe)) != null) {
            ((Button) findViewById(R.id.rav4_btn_car_pe)).setVisibility(0 == 0 ? 8 : 0);
        }
    }

    private boolean is_wc_canbus() {
        int id = DataCanbus.DATA[1000];
        return (65535 & id) == 294;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilExpend() {
        int value = DataCanbus.DATA[0];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        int numMax = 30;
        if (num != 65535) {
            if (unit == 0) {
                numMax = 60;
                if (((TextView) findViewById(R.id.rav4_tv_oil_unit)) != null) {
                    ((TextView) findViewById(R.id.rav4_tv_oil_unit)).setText("MPG");
                }
                for (int i = 0; i < 4; i++) {
                    if (this.mOilTv[i] != null) {
                        this.mOilTv[i].setText(new StringBuilder().append(Rav4Data.mOilNum1[i]).toString());
                    }
                }
            } else if (unit == 1) {
                numMax = 30;
                if (((TextView) findViewById(R.id.rav4_tv_oil_unit)) != null) {
                    ((TextView) findViewById(R.id.rav4_tv_oil_unit)).setText("km/L");
                }
                for (int i2 = 0; i2 < 4; i2++) {
                    if (this.mOilTv[i2] != null) {
                        this.mOilTv[i2].setText(new StringBuilder().append(Rav4Data.mOilNum0[i2]).toString());
                    }
                }
            } else if (unit == 2) {
                numMax = 30;
                if (((TextView) findViewById(R.id.rav4_tv_oil_unit)) != null) {
                    ((TextView) findViewById(R.id.rav4_tv_oil_unit)).setText("L/100km");
                }
                for (int i3 = 0; i3 < 4; i3++) {
                    if (this.mOilTv[i3] != null) {
                        this.mOilTv[i3].setText(new StringBuilder().append(Rav4Data.mOilNum0[i3]).toString());
                    }
                }
            }
            if (this.mProgressbarCur != null) {
                this.mProgressbarCur.setMax(numMax * 10);
                if (num < 0) {
                    num = 0;
                } else if (num > numMax * 10) {
                    num = numMax * 10;
                }
                this.mProgressbarCur.setProgress(num);
                this.mProgressbarCur.invalidate();
                return;
            }
            return;
        }
        this.mProgressbarCur.setProgress(0);
        this.mProgressbarCur.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[1];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        String str = "";
        if (unit == 0) {
            if (DataCanbus.DATA[1000] == 109 || DataCanbus.DATA[1000] == 33 || DataCanbus.DATA[1000] == 46 || DataCanbus.DATA[1000] == 110 || DataCanbus.DATA[1000] == 262438 || DataCanbus.DATA[1000] == 327974 || DataCanbus.DATA[1000] == 294 || DataCanbus.DATA[1000] == 196902 || DataCanbus.DATA[1000] == 2031910 || DataCanbus.DATA[1000] == 1704230 || DataCanbus.DATA[1000] == 2294054 || DataCanbus.DATA[1000] == 2359590 || DataCanbus.DATA[1000] == 2425126 || DataCanbus.DATA[1000] == 2490662 || DataCanbus.DATA[1000] == 2556198 || DataCanbus.DATA[1000] == 2621734 || DataCanbus.DATA[1000] == 2687270 || DataCanbus.DATA[1000] == 2752806 || DataCanbus.DATA[1000] == 2818342 || DataCanbus.DATA[1000] == 65830 || DataCanbus.DATA[1000] == 131366 || DataCanbus.DATA[1000] == 459046 || DataCanbus.DATA[1000] == 524582) {
                str = String.valueOf(num) + " km";
            } else {
                str = String.valueOf(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10))) + " km";
            }
        } else if (unit == 1) {
            if (DataCanbus.DATA[1000] == 109 || DataCanbus.DATA[1000] == 33 || DataCanbus.DATA[1000] == 46 || DataCanbus.DATA[1000] == 110 || DataCanbus.DATA[1000] == 262438 || DataCanbus.DATA[1000] == 327974 || DataCanbus.DATA[1000] == 294 || DataCanbus.DATA[1000] == 196902 || DataCanbus.DATA[1000] == 2031910 || DataCanbus.DATA[1000] == 1704230 || DataCanbus.DATA[1000] == 2294054 || DataCanbus.DATA[1000] == 2359590 || DataCanbus.DATA[1000] == 2425126 || DataCanbus.DATA[1000] == 2490662 || DataCanbus.DATA[1000] == 2556198 || DataCanbus.DATA[1000] == 2621734 || DataCanbus.DATA[1000] == 2687270 || DataCanbus.DATA[1000] == 2752806 || DataCanbus.DATA[1000] == 2818342 || DataCanbus.DATA[1000] == 65830 || DataCanbus.DATA[1000] == 131366) {
                str = String.valueOf(num) + " mile";
            } else {
                str = String.valueOf(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10))) + " mile";
            }
        }
        if (((TextView) findViewById(R.id.rav4_tv_driving_mileage)) != null) {
            ((TextView) findViewById(R.id.rav4_tv_driving_mileage)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAveragVelocity() {
        if (((TextView) findViewById(R.id.rav4_tv_average_velocity)) != null) {
            int value = DataCanbus.DATA[2] & 16777215;
            ((TextView) findViewById(R.id.rav4_tv_average_velocity)).setText(String.valueOf(value) + " km/h");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingTime() {
        int time = DataCanbus.DATA[3];
        if (time > -1) {
            int hour = time / 60;
            int minute = time % 60;
            StringBuffer sb = new StringBuffer();
            if (hour == 1) {
                sb.append(String.valueOf(String.format("%02d", Integer.valueOf(hour))) + LauncherApplication.getInstance().getResources().getString(R.string.time_hour));
            } else {
                sb.append(String.valueOf(String.format("%02d", Integer.valueOf(hour))) + LauncherApplication.getInstance().getResources().getString(R.string.time_hours));
            }
            if (minute == 1) {
                sb.append(String.valueOf(String.format("%02d", Integer.valueOf(minute))) + LauncherApplication.getInstance().getResources().getString(R.string.time_minute));
            } else {
                sb.append(String.valueOf(String.format("%02d", Integer.valueOf(minute))) + LauncherApplication.getInstance().getResources().getString(R.string.time_minutes));
            }
            if (((TextView) findViewById(R.id.rav4_tv_driving_time)) != null) {
                ((TextView) findViewById(R.id.rav4_tv_driving_time)).setText(sb.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilValue(int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 30) {
            int index = ints[0];
            int value = ints[1];
            int unit = (value >> 24) & 255;
            int num = value & 16777215;
            int numMax = 30;
            if (num != 65535) {
                if (unit == 0) {
                    numMax = 60;
                    if (((TextView) findViewById(R.id.rav4_tv_oil_unit)) != null) {
                        ((TextView) findViewById(R.id.rav4_tv_oil_unit)).setText("MPG");
                    }
                    for (int i = 0; i < 4; i++) {
                        if (this.mOilTv[i] != null) {
                            this.mOilTv[i].setText(new StringBuilder().append(Rav4Data.mOilNum1[i]).toString());
                        }
                    }
                } else if (unit == 1) {
                    numMax = 30;
                    if (((TextView) findViewById(R.id.rav4_tv_oil_unit)) != null) {
                        ((TextView) findViewById(R.id.rav4_tv_oil_unit)).setText("km/L");
                    }
                    for (int i2 = 0; i2 < 4; i2++) {
                        if (this.mOilTv[i2] != null) {
                            this.mOilTv[i2].setText(new StringBuilder().append(Rav4Data.mOilNum0[i2]).toString());
                        }
                    }
                } else if (unit == 2) {
                    numMax = 30;
                    if (((TextView) findViewById(R.id.rav4_tv_oil_unit)) != null) {
                        ((TextView) findViewById(R.id.rav4_tv_oil_unit)).setText("L/100km");
                    }
                    for (int i3 = 0; i3 < 4; i3++) {
                        if (this.mOilTv[i3] != null) {
                            this.mOilTv[i3].setText(new StringBuilder().append(Rav4Data.mOilNum0[i3]).toString());
                        }
                    }
                }
                if (this.mProgressbar[index] != null) {
                    this.mProgressbar[index].setMax(numMax * 10);
                    if (num < 0) {
                        num = 0;
                    } else if (num > numMax * 10) {
                        num = numMax * 10;
                    }
                    this.mProgressbar[index].setProgress(num);
                    this.mProgressbar[index].invalidate();
                    return;
                }
                return;
            }
            this.mProgressbar[index].setProgress(0);
            this.mProgressbar[index].invalidate();
        }
    }
}
