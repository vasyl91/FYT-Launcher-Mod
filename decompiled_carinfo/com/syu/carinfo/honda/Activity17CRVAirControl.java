package com.syu.carinfo.honda;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class Activity17CRVAirControl extends Activity implements View.OnTouchListener {
    public static Activity17CRVAirControl mInstance;
    public static boolean mIsFront = false;
    IUiNotify mCanbusNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                    Activity17CRVAirControl.this.updateAirOff(value);
                    break;
                case 11:
                    Activity17CRVAirControl.this.updateAirAC(value);
                    break;
                case 12:
                    Activity17CRVAirControl.this.updateAirCycle(value);
                    break;
                case 13:
                    Activity17CRVAirControl.this.updateAirAuto(value);
                    break;
                case 16:
                    Activity17CRVAirControl.this.updateAirRear(value);
                    break;
                case 21:
                    Activity17CRVAirControl.this.updateAirWind(value);
                    break;
                case 27:
                    Activity17CRVAirControl.this.updateAirTempLeft(value);
                    break;
                case 28:
                    Activity17CRVAirControl.this.updateAirTempRight(value);
                    break;
                case 62:
                    Activity17CRVAirControl.this.updateAirSync(value);
                    break;
                case 65:
                    Activity17CRVAirControl.this.updateAirFront(value);
                    break;
                case 77:
                    Activity17CRVAirControl.this.updateAirBlowMode(value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_321_17crv_air_control);
        mInstance = this;
        setListener();
    }

    private void setListener() {
        ((Button) findViewById(R.id.btn_air_temp_left_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_left_minus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_front)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_rear)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_cycle)).setOnTouchListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setOnTouchListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_right_minus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_right_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_power)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_sync)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_ac)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_auto)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode_body)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode_foot)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode_footbody)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode_footwin)).setOnTouchListener(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:10:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001a A[ADDED_TO_REGION] */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r10, android.view.MotionEvent r11) {
        /*
            r9 = this;
            r8 = 25
            r7 = 21
            r6 = -1
            r3 = 1
            r4 = 0
            r0 = -1
            r1 = -1
            r2 = 0
            int r5 = r10.getId()
            switch(r5) {
                case 2131427425: goto L20;
                case 2131427427: goto L1d;
                case 2131427428: goto L2f;
                case 2131427429: goto L57;
                case 2131427431: goto L6a;
                case 2131427436: goto L3f;
                case 2131427437: goto L2d;
                case 2131427438: goto L29;
                case 2131427439: goto L41;
                case 2131427441: goto L31;
                case 2131427443: goto L36;
                case 2131427444: goto L33;
                case 2131427449: goto L26;
                case 2131427451: goto L23;
                case 2131427502: goto L39;
                case 2131427560: goto L2b;
                case 2131427632: goto L3c;
                default: goto L11;
            }
        L11:
            int r3 = r11.getAction()
            switch(r3) {
                case 0: goto L7e;
                case 1: goto L80;
                default: goto L18;
            }
        L18:
            if (r0 == r6) goto L1c
            if (r1 != r6) goto L82
        L1c:
            return r4
        L1d:
            r0 = 14
            goto L11
        L20:
            r0 = 13
            goto L11
        L23:
            r0 = 16
            goto L11
        L26:
            r0 = 15
            goto L11
        L29:
            r0 = 5
            goto L11
        L2b:
            r0 = 6
            goto L11
        L2d:
            r0 = 7
            goto L11
        L2f:
            r0 = 1
            goto L11
        L31:
            r0 = 3
            goto L11
        L33:
            r0 = 9
            goto L11
        L36:
            r0 = 10
            goto L11
        L39:
            r0 = 24
            goto L11
        L3c:
            r0 = 23
            goto L11
        L3f:
            r0 = 4
            goto L11
        L41:
            int[] r5 = com.syu.module.canbus.DataCanbus.DATA
            r6 = 11
            r5 = r5[r6]
            if (r5 != 0) goto L55
            r2 = r3
        L4a:
            int r5 = r11.getAction()
            if (r5 != r3) goto L1c
            r3 = 2
            r9.setAirControl(r3, r2)
            goto L1c
        L55:
            r2 = r4
            goto L4a
        L57:
            int[] r5 = com.syu.module.canbus.DataCanbus.DATA
            r2 = r5[r7]
            int r2 = r2 + (-1)
            if (r2 >= 0) goto L60
            r2 = 0
        L60:
            int r5 = r11.getAction()
            if (r5 != r3) goto L1c
            r9.setAirControl(r8, r2)
            goto L1c
        L6a:
            int[] r5 = com.syu.module.canbus.DataCanbus.DATA
            r2 = r5[r7]
            int r2 = r2 + 1
            r5 = 7
            if (r2 <= r5) goto L74
            r2 = 7
        L74:
            int r5 = r11.getAction()
            if (r5 != r3) goto L1c
            r9.setAirControl(r8, r2)
            goto L1c
        L7e:
            r1 = 1
            goto L18
        L80:
            r1 = 0
            goto L18
        L82:
            r9.setAirControl(r0, r1)
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.honda.Activity17CRVAirControl.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private void setAirControl(int cmdId, int touchState) {
        DataCanbus.PROXY.cmd(107, cmdId, touchState);
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
        removeNotify();
        AirHelper.disableAirWindowLocal(false);
        mIsFront = false;
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mCanbusNotify);
    }

    protected void updateAirRear(int value) {
        if (((Button) findViewById(R.id.air_xts_rear)) != null) {
            ((Button) findViewById(R.id.air_xts_rear)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
        }
    }

    protected void updateAirSync(int value) {
        if (((Button) findViewById(R.id.air_xts_sync)) != null) {
            ((Button) findViewById(R.id.air_xts_sync)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_sync_n : R.drawable.ic_xts_sync_p);
        }
    }

    protected void updateAirFront(int value) {
        if (((Button) findViewById(R.id.air_xts_front)) != null) {
            ((Button) findViewById(R.id.air_xts_front)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
        }
    }

    protected void updateAirBlowMode(int value) {
        ((Button) findViewById(R.id.air_xts_mode_body)).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
        ((Button) findViewById(R.id.air_xts_mode_footwin)).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
        ((Button) findViewById(R.id.air_xts_mode_footbody)).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
        ((Button) findViewById(R.id.air_xts_mode_foot)).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
        if (DataCanbus.DATA[77] == 4) {
            ((Button) findViewById(R.id.air_xts_mode_footwin)).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
            return;
        }
        if (DataCanbus.DATA[77] == 5) {
            ((Button) findViewById(R.id.air_xts_mode_footbody)).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
        } else if (DataCanbus.DATA[77] == 3) {
            ((Button) findViewById(R.id.air_xts_mode_foot)).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
        } else if (DataCanbus.DATA[77] == 6) {
            ((Button) findViewById(R.id.air_xts_mode_body)).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
        }
    }

    protected void updateAirWind(int value) {
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(value).toString());
        }
    }

    protected void updateAirOff(int value) {
        if (((Button) findViewById(R.id.air_xts_power)) != null) {
            ((Button) findViewById(R.id.air_xts_power)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        }
    }

    protected void updateAirTempRight(int value) {
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (value == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
            } else if (value == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(value / 10) + "." + (value % 10) + "℃");
            }
        }
    }

    protected void updateAirTempLeft(int value) {
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (value == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
            } else if (value == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(value / 10) + "." + (value % 10) + "℃");
            }
        }
    }

    protected void updateAirCycle(int value) {
        if (((Button) findViewById(R.id.air_xts_cycle)) != null) {
            ((Button) findViewById(R.id.air_xts_cycle)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_cycle_n : R.drawable.ic_xts_cycle_p);
        }
    }

    protected void updateAirAC(int value) {
        if (((Button) findViewById(R.id.air_xts_ac)) != null) {
            ((Button) findViewById(R.id.air_xts_ac)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    protected void updateAirAuto(int value) {
        if (((Button) findViewById(R.id.air_xts_auto)) != null) {
            ((Button) findViewById(R.id.air_xts_auto)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
        }
    }
}
