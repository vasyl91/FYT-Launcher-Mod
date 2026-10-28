package com.syu.carinfo.wc.gs4;

import android.os.Bundle;
import android.view.View;

import com.syu.canbus.BaseActivity;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class GS4AirControlAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 36:
                    GS4AirControlAct.this.updaterSeatHeatLeft();
                    break;
                case 37:
                    GS4AirControlAct.this.updaterSeatHeatRight();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_289_wc_gs4_air_control_set);
        setUI();
    }

    private void setUI() {
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
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
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterSeatHeatRight() {
        int mSeatRightInt = DataCanbus.DATA[37];
        //((TextView) findViewById(R.id.right_seat_heat_TV)).setText(new StringBuilder().append(mSeatRightInt).toString());
    }

    
    public void updaterSeatHeatLeft() {
        int mSeatLeftInt = DataCanbus.DATA[36];
        //((TextView) findViewById(R.id.left_seat_heat_TV)).setText(new StringBuilder().append(mSeatLeftInt).toString());
    }
}
