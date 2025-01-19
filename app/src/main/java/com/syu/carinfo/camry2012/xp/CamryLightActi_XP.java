package com.syu.carinfo.camry2012.xp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class CamryLightActi_XP extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 136:
                    CamryLightActi_XP.this.mUpdaterValue0();
                    break;
                case 137:
                    CamryLightActi_XP.this.mUpdaterValue1();
                    break;
                case 138:
                    CamryLightActi_XP.this.mUpdaterValue2();
                    break;
                case 139:
                    CamryLightActi_XP.this.mUpdaterValue3();
                    break;
                case 140:
                    CamryLightActi_XP.this.mUpdaterValue4();
                    break;
                case 141:
                    CamryLightActi_XP.this.mUpdaterValue5();
                    break;
                case 142:
                    CamryLightActi_XP.this.mUpdaterValue6();
                    break;
                case 143:
                    CamryLightActi_XP.this.mUpdaterValue7();
                    break;
                case 144:
                    CamryLightActi_XP.this.mUpdaterValue8();
                    break;
                case 145:
                    CamryLightActi_XP.this.mUpdaterValue9();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xp_camry_light);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
    }

    private void setBackground(TextView btn, int ResId) {
        if (btn != null) {
            btn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, getResources().getDrawable(ResId));
        }
    }

    
    public void mUpdaterValue0() {
        int value = DataCanbus.DATA[136];
        setBackground((TextView) findViewById(R.id.camry_near_light), value == 0 ? R.drawable.wc_ruiteng_near_light_0 : R.drawable.wc_ruiteng_near_light_1);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[137];
        setBackground((TextView) findViewById(R.id.camry_away_light), value == 0 ? R.drawable.wc_ruiteng_away_light_0 : R.drawable.wc_ruiteng_away_light_1);
    }

    
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[138];
        setBackground((TextView) findViewById(R.id.camry_width_light), value == 0 ? R.drawable.wc_ruiteng_width_light_0 : R.drawable.wc_ruiteng_width_light_1);
    }

    
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[139];
        setBackground((TextView) findViewById(R.id.camry_back_car_light), value == 0 ? R.drawable.wc_ruiteng_back_car_light_0 : R.drawable.wc_ruiteng_back_car_light_1);
    }

    
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[140];
        setBackground((TextView) findViewById(R.id.camry_brake_car_light), value == 0 ? R.drawable.wc_ruiteng_brake_car_light_0 : R.drawable.wc_ruiteng_brake_car_light_1);
    }

    
    public void mUpdaterValue5() {
        int value = DataCanbus.DATA[141];
        setBackground((TextView) findViewById(R.id.camry_right_turn_light), value == 0 ? R.drawable.wc_ruiteng_right_turn_light_0 : R.drawable.wc_ruiteng_right_turn_light_1);
    }

    
    public void mUpdaterValue6() {
        int value = DataCanbus.DATA[142];
        setBackground((TextView) findViewById(R.id.camry_left_turn_light), value == 0 ? R.drawable.wc_ruiteng_left_turn_light_0 : R.drawable.wc_ruiteng_left_turn_light_1);
    }

    
    public void mUpdaterValue7() {
        int value = DataCanbus.DATA[143];
        setBackground((TextView) findViewById(R.id.camry_both_turn_light), value == 0 ? R.drawable.wc_ruiteng_both_turn_light_0 : R.drawable.wc_ruiteng_both_turn_light_1);
    }

    
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[144];
        setBackground((TextView) findViewById(R.id.camry_rear_fog_light), value == 0 ? R.drawable.wc_ruiteng_front_fog_light_0 : R.drawable.wc_ruiteng_front_fog_light_1);
    }

    
    public void mUpdaterValue9() {
        int value = DataCanbus.DATA[145];
        setBackground((TextView) findViewById(R.id.camry_front_fog_light), value == 0 ? R.drawable.wc_ruiteng_rear_fog_light_0 : R.drawable.wc_ruiteng_rear_fog_light_1);
    }
}
