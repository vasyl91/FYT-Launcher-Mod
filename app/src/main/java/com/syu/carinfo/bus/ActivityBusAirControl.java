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

public class ActivityBusAirControl extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    IUiNotify mCanbusNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                    if (value == 0) {
                        ((Button) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_power)).setBackgroundResource(R.drawable.ic_bus_power_n);
                        break;
                    } else {
                        ((Button) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_power)).setBackgroundResource(R.drawable.ic_bus_power_p);
                        break;
                    }
                case 11:
                    if (value == 0) {
                        ((Button) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_ac)).setBackgroundResource(R.drawable.ic_bus_ac);
                        break;
                    } else {
                        ((Button) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_ac)).setBackgroundResource(R.drawable.ic_bus_ac_p);
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
                case 15:
                    ((TextView) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_wind_defrost_level)).setText(new StringBuilder().append(value).toString());
                    break;
                case 17:
                    if (value == 0) {
                        ((Button) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_cycle_defrost)).setBackgroundResource(R.drawable.ic_bus_cycle_new);
                        break;
                    } else {
                        ((Button) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_cycle_defrost)).setBackgroundResource(R.drawable.ic_bus_cycle_inter);
                        break;
                    }
                case 21:
                    ((TextView) ActivityBusAirControl.this.findViewById(R.id.bus_tv_air_wind)).setText(new StringBuilder().append(value).toString());
                    break;
                case 27:
                    ((TextView) ActivityBusAirControl.this.findViewById(R.id.bus_tv_temp)).setText(new StringBuilder().append(value - 40).toString());
                    break;
                case 55:
                    if (value == 0) {
                        ((Button) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_water_valve)).setBackgroundResource(R.drawable.ic_bus_water);
                        break;
                    } else {
                        ((Button) ActivityBusAirControl.this.findViewById(R.id.bus_btn_air_water_valve)).setBackgroundResource(R.drawable.ic_bus_water_p);
                        break;
                    }
                case 77:
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_408_air_control);
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

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000c, code lost:
    
        return true;
     */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r4, android.view.MotionEvent r5) {
        /*
            r3 = this;
            r2 = 1
            int r0 = r3.getTouchState(r5)
            int r1 = r4.getId()
            switch(r1) {
                case 2131429694: goto L47;
                case 2131429695: goto L42;
                case 2131429696: goto L20;
                case 2131429697: goto L16;
                case 2131429698: goto Ld;
                case 2131429699: goto Lc;
                case 2131429700: goto L11;
                case 2131429701: goto Lc;
                case 2131429702: goto L3d;
                case 2131429703: goto L38;
                case 2131429704: goto L1b;
                case 2131429705: goto L26;
                case 2131429706: goto L32;
                case 2131429707: goto L2c;
                default: goto Lc;
            }
        Lc:
            return r2
        Ld:
            r3.setCmdAir(r2, r0)
            goto Lc
        L11:
            r1 = 2
            r3.setCmdAir(r1, r0)
            goto Lc
        L16:
            r1 = 0
            r3.setCmdAir(r1, r0)
            goto Lc
        L1b:
            r1 = 7
            r3.setCmdAir(r1, r0)
            goto Lc
        L20:
            r1 = 9
            r3.setCmdAir(r1, r0)
            goto Lc
        L26:
            r1 = 8
            r3.setCmdAir(r1, r0)
            goto Lc
        L2c:
            r1 = 10
            r3.setCmdAir(r1, r0)
            goto Lc
        L32:
            r1 = 11
            r3.setCmdAir(r1, r0)
            goto Lc
        L38:
            r1 = 3
            r3.setCmdAir(r1, r0)
            goto Lc
        L3d:
            r1 = 4
            r3.setCmdAir(r1, r0)
            goto Lc
        L42:
            r1 = 5
            r3.setCmdAir(r1, r0)
            goto Lc
        L47:
            r1 = 6
            r3.setCmdAir(r1, r0)
            goto Lc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.bus.ActivityBusAirControl.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mCanbusNotify);
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
