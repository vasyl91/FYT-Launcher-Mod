package com.syu.carinfo.dongjian.ga6;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class GA6AirSeatControlAct extends BaseActivity {
    public static boolean mIsFront = false;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 29:
                    GA6AirSeatControlAct.this.updaterLeftSeatHeat();
                    break;
                case 30:
                    GA6AirSeatControlAct.this.updaterRightSeatHeat();
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
                if (id == 2131427457) {
                    GA6Func.C_AIR_SEAT_CMD(1, 1);
                } else if (id == 2131427460) {
                    GA6Func.C_AIR_SEAT_CMD(2, 1);
                }
            } else if (action == 1) {
                if (id == 2131427457) {
                    GA6Func.C_AIR_SEAT_CMD(0, 0);
                } else if (id == 2131427460) {
                    GA6Func.C_AIR_SEAT_CMD(0, 0);
                }
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_257_dongjian_ga6_air_seat_heat_control);
        setUI();
    }

    @Override
    public void init() {
    }

    private void setUI() {
        findViewById(R.id.btn_plus1).setOnTouchListener(this.onTouchListener);
        findViewById(R.id.btn_plus2).setOnTouchListener(this.onTouchListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        AirHelper.disableAirWindowLocal(true);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.notifyCanbus);
    }

    
    public void updaterLeftSeatHeat() {
        int leftvalue = DataCanbus.DATA[29];
        ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder().append(leftvalue).toString());
    }

    
    public void updaterRightSeatHeat() {
        int rightvalue = DataCanbus.DATA[30];
        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(rightvalue).toString());
    }
}
