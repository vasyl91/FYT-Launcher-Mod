package com.syu.carinfo.bus;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityBusAirControl extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.bus.ActivityBusAirControl.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 11:
                    if (value == 0) {
                        ((Button) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_power)).setBackgroundResource(R.drawable.ic_bus_power_n);
                        break;
                    } else {
                        ((Button) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_power)).setBackgroundResource(R.drawable.ic_bus_power_p);
                        break;
                    }
                case 12:
                    if (value == 0) {
                        ((Button) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_cycle)).setBackgroundResource(R.drawable.ic_bus_cycle_out);
                        break;
                    } else if (value == 1) {
                        ((Button) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_cycle)).setBackgroundResource(R.drawable.ic_bus_cycle_inter);
                        break;
                    } else {
                        ((Button) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_cycle)).setBackgroundResource(R.drawable.ic_bus_cycle_new);
                        break;
                    }
                case 13:
                    if (value == 0) {
                        ((Button) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_ac)).setBackgroundResource(R.drawable.ic_bus_ac);
                        break;
                    } else {
                        ((Button) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_ac)).setBackgroundResource(R.drawable.ic_bus_ac_p);
                        break;
                    }
                case 14:
                    if (value == 0) {
                        ((Button) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_water_valve)).setBackgroundResource(R.drawable.ic_bus_water);
                        break;
                    } else {
                        ((Button) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_water_valve)).setBackgroundResource(R.drawable.ic_bus_water_p);
                        break;
                    }
                case 15:
                    ((TextView) ActivityBusAirControl.this.findViewById(R.id.bus_tv_air_wind)).setText(new StringBuilder().append(value).toString());
                    break;
                case 16:
                    ((TextView) ActivityBusAirControl.this.findViewById(R.id.bus_tv_temp)).setText(new StringBuilder().append(value - 40).toString());
                    break;
                case 17:
                    if (value == 0) {
                        ((Button) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_cycle_defrost)).setBackgroundResource(R.drawable.ic_bus_cycle_new);
                        break;
                    } else {
                        ((Button) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_cycle_defrost)).setBackgroundResource(R.drawable.ic_bus_cycle_inter);
                        break;
                    }
                case 18:
                    ((TextView) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_wind_defrost_level)).setText(new StringBuilder().append(value).toString());
                    break;
                case 23:
                    ((Button) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_mode)).setBackgroundResource(R.drawable.ic_bus_blow_none);
                    switch (value) {
                        case 1:
                            ((Button) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_mode)).setBackgroundResource(R.drawable.ic_bus_blow_up);
                            break;
                        case 2:
                            ((Button) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_mode)).setBackgroundResource(R.drawable.ic_bus_blow_up_foot);
                            break;
                        case 3:
                            ((Button) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_mode)).setBackgroundResource(R.drawable.ic_bus_blow_foot);
                            break;
                        case 4:
                            ((Button) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_mode)).setBackgroundResource(R.drawable.ic_bus_blow_win_foot);
                            break;
                        case 5:
                            ((Button) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_mode)).setBackgroundResource(R.drawable.ic_bus_blow_win);
                            break;
                        default:
                            ((Button) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_mode)).setBackgroundResource(R.drawable.ic_bus_blow_none);
                            break;
                    }
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_408_air_control);
        initUi();
    }

    private void initUi() {
        ((Button) findViewById(R.id.bus_btn_air_temp_minus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.bus_btn_air_temp_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.bus_btn_air_wind_defrost_minute)).setOnTouchListener(this);
        ((Button) findViewById(R.id.bus_btn_air_wind_defrost_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.bus_btn_air_wind_mimus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.bus_btn_air_wind_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.bus_btn_air_power)).setOnTouchListener(this);
        ((Button) findViewById(R.id.bus_btn_air_cycle)).setOnTouchListener(this);
        ((Button) findViewById(R.id.bus_btn_air_cycle_defrost)).setOnTouchListener(this);
        ((Button) findViewById(R.id.bus_btn_air_mode)).setOnTouchListener(this);
        ((Button) findViewById(R.id.bus_btn_air_ac)).setOnTouchListener(this);
        ((Button) findViewById(R.id.bus_btn_air_water_valve)).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000c, code lost:
    
        return true;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(View v, MotionEvent event) {
        int touchState = getTouchState(event);
        switch (v.getId()) {
            case R.id.bus_btn_air_wind_defrost_plus /* 2131429742 */:
                setCmdAir(6, touchState);
                break;
            case R.id.bus_btn_air_wind_defrost_minute /* 2131429743 */:
                setCmdAir(5, touchState);
                break;
            case R.id.bus_btn_air_cycle_defrost /* 2131429744 */:
                setCmdAir(9, touchState);
                break;
            case R.id.bus_btn_air_power /* 2131429745 */:
                setCmdAir(0, touchState);
                break;
            case R.id.bus_btn_air_temp_minus /* 2131429746 */:
                setCmdAir(1, touchState);
                break;
            case R.id.bus_btn_air_temp_plus /* 2131429748 */:
                setCmdAir(2, touchState);
                break;
            case R.id.bus_btn_air_wind_plus /* 2131429750 */:
                setCmdAir(4, touchState);
                break;
            case R.id.bus_btn_air_wind_mimus /* 2131429751 */:
                setCmdAir(3, touchState);
                break;
            case R.id.bus_btn_air_cycle /* 2131429752 */:
                setCmdAir(7, touchState);
                break;
            case R.id.bus_btn_air_mode /* 2131429753 */:
                setCmdAir(8, touchState);
                break;
            case R.id.bus_btn_air_water_valve /* 2131429754 */:
                setCmdAir(11, touchState);
                break;
            case R.id.bus_btn_air_ac /* 2131429755 */:
                setCmdAir(10, touchState);
                break;
        }
        return false;
    }


    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mCanbusNotify);
    }

    private int getTouchState(MotionEvent event) {
        if (event.getAction() == 0) {
            return 1;
        }
        if (event.getAction() == 1) {
            return 0;
        }
        return -1;
    }

    private void setCmdAir(int cmd, int touchstate) {
        DataCanbus.PROXY.cmd(0, cmd, touchstate);
    }
}
