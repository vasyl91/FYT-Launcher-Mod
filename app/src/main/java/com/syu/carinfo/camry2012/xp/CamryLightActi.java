package com.syu.carinfo.camry2012.xp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class CamryLightActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.camry2012.xp.CamryLightActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 38:
                    CamryLightActi.this.mUpdaterValue0();
                    break;
                case 39:
                    CamryLightActi.this.mUpdaterValue1();
                    break;
                case 40:
                    CamryLightActi.this.mUpdaterValue2();
                    break;
                case 41:
                    CamryLightActi.this.mUpdaterValue3();
                    break;
                case 42:
                    CamryLightActi.this.mUpdaterValue4();
                    break;
                case 43:
                    CamryLightActi.this.mUpdaterValue5();
                    break;
                case 44:
                    CamryLightActi.this.mUpdaterValue6();
                    break;
                case 45:
                    CamryLightActi.this.mUpdaterValue7();
                    break;
                case 46:
                    CamryLightActi.this.mUpdaterValue8();
                    break;
                case 47:
                    CamryLightActi.this.mUpdaterValue9();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_camry_light);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
    }

    private void setBackground(TextView btn, int ResId) {
        if (btn != null) {
            btn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, getResources().getDrawable(ResId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue0() {
        int value = DataCanbus.DATA[38];
        setBackground((TextView) findViewById(R.id.camry_near_light), value == 0 ? R.drawable.wc_ruiteng_near_light_0 : R.drawable.wc_ruiteng_near_light_1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[39];
        setBackground((TextView) findViewById(R.id.camry_away_light), value == 0 ? R.drawable.wc_ruiteng_away_light_0 : R.drawable.wc_ruiteng_away_light_1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[40];
        setBackground((TextView) findViewById(R.id.camry_width_light), value == 0 ? R.drawable.wc_ruiteng_width_light_0 : R.drawable.wc_ruiteng_width_light_1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[41];
        setBackground((TextView) findViewById(R.id.camry_back_car_light), value == 0 ? R.drawable.wc_ruiteng_back_car_light_0 : R.drawable.wc_ruiteng_back_car_light_1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[42];
        setBackground((TextView) findViewById(R.id.camry_brake_car_light), value == 0 ? R.drawable.wc_ruiteng_brake_car_light_0 : R.drawable.wc_ruiteng_brake_car_light_1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue5() {
        int value = DataCanbus.DATA[43];
        setBackground((TextView) findViewById(R.id.camry_right_turn_light), value == 0 ? R.drawable.wc_ruiteng_right_turn_light_0 : R.drawable.wc_ruiteng_right_turn_light_1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue6() {
        int value = DataCanbus.DATA[44];
        setBackground((TextView) findViewById(R.id.camry_left_turn_light), value == 0 ? R.drawable.wc_ruiteng_left_turn_light_0 : R.drawable.wc_ruiteng_left_turn_light_1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue7() {
        int value = DataCanbus.DATA[45];
        setBackground((TextView) findViewById(R.id.camry_both_turn_light), value == 0 ? R.drawable.wc_ruiteng_both_turn_light_0 : R.drawable.wc_ruiteng_both_turn_light_1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[46];
        setBackground((TextView) findViewById(R.id.camry_rear_fog_light), value == 0 ? R.drawable.wc_ruiteng_front_fog_light_0 : R.drawable.wc_ruiteng_front_fog_light_1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue9() {
        int value = DataCanbus.DATA[47];
        setBackground((TextView) findViewById(R.id.camry_front_fog_light), value == 0 ? R.drawable.wc_ruiteng_rear_fog_light_0 : R.drawable.wc_ruiteng_rear_fog_light_1);
    }
}
