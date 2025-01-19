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

public class BmwSeatHeatAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 20:
                    BmwSeatHeatAct.this.updaterLeftSeatHeat();
                    break;
                case 21:
                    BmwSeatHeatAct.this.updaterRightSeatHeat();
                    break;
                case 22:
                    BmwSeatHeatAct.this.updaterRadarSwitch();
                    break;
            }
        }
    };
    private View.OnTouchListener onTouchListener = new View.OnTouchListener() { 
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            int id = v.getId();
            if (action == 0) {
                if (id == 2131431663) {
                    BmwFunc.CAR_CONTROL_SET(1, 1);
                    ((Button) BmwSeatHeatAct.this.findViewById(R.id.bogoo_bmw_left_seat_heat_btn)).setBackground(BmwSeatHeatAct.this.getResources().getDrawable(R.drawable.ic_factory_password_confirm_p));
                } else if (id == 2131431665) {
                    BmwFunc.CAR_CONTROL_SET(2, 1);
                    ((Button) BmwSeatHeatAct.this.findViewById(R.id.bogoo_bmw_right_seat_heat_btn)).setBackground(BmwSeatHeatAct.this.getResources().getDrawable(R.drawable.ic_factory_password_confirm_p));
                } else if (id == 2131431667) {
                    BmwFunc.CAR_CONTROL_SET(3, 1);
                    ((Button) BmwSeatHeatAct.this.findViewById(R.id.bogoo_bmw_radar_switch_btn)).setBackground(BmwSeatHeatAct.this.getResources().getDrawable(R.drawable.ic_factory_password_confirm_p));
                } else if (id == 2131431669) {
                    BmwFunc.CAR_CONTROL_SET(4, 1);
                    ((Button) BmwSeatHeatAct.this.findViewById(R.id.bogoo_bmw_window_switch_btn)).setBackground(BmwSeatHeatAct.this.getResources().getDrawable(R.drawable.ic_factory_password_confirm_p));
                }
            } else if (action == 1) {
                if (id == 2131431663) {
                    BmwFunc.CAR_CONTROL_SET(1, 0);
                    ((Button) BmwSeatHeatAct.this.findViewById(R.id.bogoo_bmw_left_seat_heat_btn)).setBackground(BmwSeatHeatAct.this.getResources().getDrawable(R.drawable.ic_factory_password_confirm_n));
                } else if (id == 2131431665) {
                    BmwFunc.CAR_CONTROL_SET(2, 0);
                    ((Button) BmwSeatHeatAct.this.findViewById(R.id.bogoo_bmw_right_seat_heat_btn)).setBackground(BmwSeatHeatAct.this.getResources().getDrawable(R.drawable.ic_factory_password_confirm_n));
                } else if (id == 2131431667) {
                    BmwFunc.CAR_CONTROL_SET(3, 0);
                    ((Button) BmwSeatHeatAct.this.findViewById(R.id.bogoo_bmw_radar_switch_btn)).setBackground(BmwSeatHeatAct.this.getResources().getDrawable(R.drawable.ic_factory_password_confirm_n));
                } else if (id == 2131431669) {
                    BmwFunc.CAR_CONTROL_SET(4, 0);
                    ((Button) BmwSeatHeatAct.this.findViewById(R.id.bogoo_bmw_window_switch_btn)).setBackground(BmwSeatHeatAct.this.getResources().getDrawable(R.drawable.ic_factory_password_confirm_n));
                }
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_haozheng_bmw_seat_heat);
        init();
        setUI();
    }

    @Override
    public void init() {
    }

    private void setUI() {
        ((Button) findViewById(R.id.bogoo_bmw_left_seat_heat_btn)).setOnTouchListener(this.onTouchListener);
        ((Button) findViewById(R.id.bogoo_bmw_right_seat_heat_btn)).setOnTouchListener(this.onTouchListener);
        ((Button) findViewById(R.id.bogoo_bmw_radar_switch_btn)).setOnTouchListener(this.onTouchListener);
        ((Button) findViewById(R.id.bogoo_bmw_window_switch_btn)).setOnTouchListener(this.onTouchListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterLeftSeatHeat() {
        int leftvalue = DataCanbus.DATA[20];
        ((TextView) findViewById(R.id.bogoo_bmw_left_seat_heat_tv)).setText(new StringBuilder().append(leftvalue).toString());
    }

    
    public void updaterRightSeatHeat() {
        int rightvalue = DataCanbus.DATA[21];
        ((TextView) findViewById(R.id.bogoo_bmw_right_seat_heat_tv)).setText(new StringBuilder().append(rightvalue).toString());
    }

    
    public void updaterRadarSwitch() {
        int radarvalue = DataCanbus.DATA[22];
        if (radarvalue == 1) {
            ((TextView) findViewById(R.id.bogoo_bmw_radar_switch_tv)).setText(R.string.klc_Parking_with_trailer_ON);
        } else if (radarvalue == 0) {
            ((TextView) findViewById(R.id.bogoo_bmw_radar_switch_tv)).setText(R.string.klc_Parking_with_trailer_Off);
        }
    }
}
