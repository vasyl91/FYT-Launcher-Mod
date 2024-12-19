package com.syu.carinfo.wc.ruiteng;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RuiTengLight extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengLight.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 59:
                    RuiTengLight.this.mUpdaterValue17();
                    break;
                case 60:
                    RuiTengLight.this.mUpdaterValue18();
                    break;
                case 61:
                    RuiTengLight.this.mUpdaterValue19();
                    break;
                case 62:
                    RuiTengLight.this.mUpdaterValue20();
                    break;
                case 63:
                    RuiTengLight.this.mUpdaterValue21();
                    break;
                case 64:
                    RuiTengLight.this.mUpdaterValue22();
                    break;
                case 65:
                    RuiTengLight.this.mUpdaterValue23();
                    break;
                case 66:
                    RuiTengLight.this.mUpdaterValue24();
                    break;
                case 67:
                    RuiTengLight.this.mUpdaterValue25();
                    break;
                case 68:
                    RuiTengLight.this.mUpdaterValue26();
                    break;
                case 69:
                    RuiTengLight.this.mUpdaterValue27();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_ruiteng_light);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue17() {
        int value = DataCanbus.DATA[59];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_near_light)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_near_light)).setBackgroundResource(R.drawable.wc_ruiteng_near_light_1);
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_near_light)).setBackgroundResource(R.drawable.wc_ruiteng_near_light_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue18() {
        int value = DataCanbus.DATA[60];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_away_light)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_away_light)).setBackgroundResource(R.drawable.wc_ruiteng_away_light_1);
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_away_light)).setBackgroundResource(R.drawable.wc_ruiteng_away_light_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue19() {
        int value = DataCanbus.DATA[61];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_width_light)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_width_light)).setBackgroundResource(R.drawable.wc_ruiteng_width_light_1);
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_width_light)).setBackgroundResource(R.drawable.wc_ruiteng_width_light_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue20() {
        int value = DataCanbus.DATA[62];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_front_fog_light)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_front_fog_light)).setBackgroundResource(R.drawable.wc_ruiteng_front_fog_light_1);
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_front_fog_light)).setBackgroundResource(R.drawable.wc_ruiteng_front_fog_light_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue21() {
        int value = DataCanbus.DATA[63];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_rear_fog_light)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_rear_fog_light)).setBackgroundResource(R.drawable.wc_ruiteng_rear_fog_light_1);
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_rear_fog_light)).setBackgroundResource(R.drawable.wc_ruiteng_rear_fog_light_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue22() {
        int value = DataCanbus.DATA[64];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_brake_car_light)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_brake_car_light)).setBackgroundResource(R.drawable.wc_ruiteng_brake_car_light_1);
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_brake_car_light)).setBackgroundResource(R.drawable.wc_ruiteng_brake_car_light_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue23() {
        int value = DataCanbus.DATA[65];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_back_car_light)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_back_car_light)).setBackgroundResource(R.drawable.wc_ruiteng_back_car_light_1);
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_back_car_light)).setBackgroundResource(R.drawable.wc_ruiteng_back_car_light_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue24() {
        int value = DataCanbus.DATA[66];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_day_light)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_day_light)).setBackgroundResource(R.drawable.wc_ruiteng_day_light_1);
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_day_light)).setBackgroundResource(R.drawable.wc_ruiteng_day_light_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue25() {
        int value = DataCanbus.DATA[67];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_right_turn_light)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_right_turn_light)).setBackgroundResource(R.drawable.wc_ruiteng_right_turn_light_1);
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_right_turn_light)).setBackgroundResource(R.drawable.wc_ruiteng_right_turn_light_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue26() {
        int value = DataCanbus.DATA[68];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_left_turn_light)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_left_turn_light)).setBackgroundResource(R.drawable.wc_ruiteng_left_turn_light_1);
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_left_turn_light)).setBackgroundResource(R.drawable.wc_ruiteng_left_turn_light_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue27() {
        int value = DataCanbus.DATA[69];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_both_turn_light)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_both_turn_light)).setBackgroundResource(R.drawable.wc_ruiteng_both_turn_light_1);
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_both_turn_light)).setBackgroundResource(R.drawable.wc_ruiteng_both_turn_light_0);
            }
        }
    }
}
