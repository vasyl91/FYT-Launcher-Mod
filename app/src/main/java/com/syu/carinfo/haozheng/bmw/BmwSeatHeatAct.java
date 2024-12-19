package com.syu.carinfo.haozheng.bmw;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class BmwSeatHeatAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.haozheng.bmw.BmwSeatHeatAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 13:
                    BmwSeatHeatAct.this.updaterLeftSeatHeat();
                    break;
                case 14:
                    BmwSeatHeatAct.this.updaterRightSeatHeat();
                    break;
                case 15:
                    BmwSeatHeatAct.this.updaterRadarSwitch();
                    break;
            }
        }
    };
    private View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.syu.carinfo.haozheng.bmw.BmwSeatHeatAct.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            int id = v.getId();
            if (action == 0) {
                if (id == 2131431686) {
                    BmwFunc.CAR_CONTROL_SET(1, 1);
                    ((Button) BmwSeatHeatAct.this.findViewById(R.id.bogoo_bmw_left_seat_heat_btn)).setBackground(BmwSeatHeatAct.this.getResources().getDrawable(R.drawable.ic_factory_password_confirm_p));
                } else if (id == 2131431688) {
                    BmwFunc.CAR_CONTROL_SET(2, 1);
                    ((Button) BmwSeatHeatAct.this.findViewById(R.id.bogoo_bmw_right_seat_heat_btn)).setBackground(BmwSeatHeatAct.this.getResources().getDrawable(R.drawable.ic_factory_password_confirm_p));
                } else if (id == 2131431690) {
                    BmwFunc.CAR_CONTROL_SET(3, 1);
                    ((Button) BmwSeatHeatAct.this.findViewById(R.id.bogoo_bmw_radar_switch_btn)).setBackground(BmwSeatHeatAct.this.getResources().getDrawable(R.drawable.ic_factory_password_confirm_p));
                } else if (id == 2131431692) {
                    BmwFunc.CAR_CONTROL_SET(4, 1);
                    ((Button) BmwSeatHeatAct.this.findViewById(R.id.bogoo_bmw_window_switch_btn)).setBackground(BmwSeatHeatAct.this.getResources().getDrawable(R.drawable.ic_factory_password_confirm_p));
                }
            } else if (action == 1) {
                if (id == 2131431686) {
                    BmwFunc.CAR_CONTROL_SET(1, 0);
                    ((Button) BmwSeatHeatAct.this.findViewById(R.id.bogoo_bmw_left_seat_heat_btn)).setBackground(BmwSeatHeatAct.this.getResources().getDrawable(R.drawable.ic_factory_password_confirm_n));
                } else if (id == 2131431688) {
                    BmwFunc.CAR_CONTROL_SET(2, 0);
                    ((Button) BmwSeatHeatAct.this.findViewById(R.id.bogoo_bmw_right_seat_heat_btn)).setBackground(BmwSeatHeatAct.this.getResources().getDrawable(R.drawable.ic_factory_password_confirm_n));
                } else if (id == 2131431690) {
                    BmwFunc.CAR_CONTROL_SET(3, 0);
                    ((Button) BmwSeatHeatAct.this.findViewById(R.id.bogoo_bmw_radar_switch_btn)).setBackground(BmwSeatHeatAct.this.getResources().getDrawable(R.drawable.ic_factory_password_confirm_n));
                } else if (id == 2131431692) {
                    BmwFunc.CAR_CONTROL_SET(4, 0);
                    ((Button) BmwSeatHeatAct.this.findViewById(R.id.bogoo_bmw_window_switch_btn)).setBackground(BmwSeatHeatAct.this.getResources().getDrawable(R.drawable.ic_factory_password_confirm_n));
                }
            }
            return true;
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_haozheng_bmw_seat_heat);
        init();
        setUI();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    private void setUI() {
        ((Button) findViewById(R.id.bogoo_bmw_left_seat_heat_btn)).setOnTouchListener(this.onTouchListener);
        ((Button) findViewById(R.id.bogoo_bmw_right_seat_heat_btn)).setOnTouchListener(this.onTouchListener);
        ((Button) findViewById(R.id.bogoo_bmw_radar_switch_btn)).setOnTouchListener(this.onTouchListener);
        ((Button) findViewById(R.id.bogoo_bmw_window_switch_btn)).setOnTouchListener(this.onTouchListener);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterLeftSeatHeat() {
        int leftvalue = DataCanbus.DATA[13];
        ((TextView) findViewById(R.id.bogoo_bmw_left_seat_heat_tv)).setText(new StringBuilder().append(leftvalue).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRightSeatHeat() {
        int rightvalue = DataCanbus.DATA[14];
        ((TextView) findViewById(R.id.bogoo_bmw_right_seat_heat_tv)).setText(new StringBuilder().append(rightvalue).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadarSwitch() {
        int radarvalue = DataCanbus.DATA[15];
        if (radarvalue == 1) {
            ((TextView) findViewById(R.id.bogoo_bmw_radar_switch_tv)).setText(R.string.klc_Parking_with_trailer_ON);
        } else if (radarvalue == 0) {
            ((TextView) findViewById(R.id.bogoo_bmw_radar_switch_tv)).setText(R.string.klc_Parking_with_trailer_Off);
        }
    }
}
