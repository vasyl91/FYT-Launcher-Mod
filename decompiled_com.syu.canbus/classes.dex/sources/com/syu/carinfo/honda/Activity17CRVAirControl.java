package com.syu.carinfo.honda;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Activity17CRVAirControl extends Activity implements View.OnTouchListener {
    public static Activity17CRVAirControl mInstance;
    public static boolean mIsFront = false;
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.honda.Activity17CRVAirControl.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 26:
                    Activity17CRVAirControl.this.updateAirAuto(value);
                    break;
                case 27:
                    Activity17CRVAirControl.this.updateAirCycle(value);
                    break;
                case 28:
                    Activity17CRVAirControl.this.updateAirFront(value);
                    break;
                case 29:
                    Activity17CRVAirControl.this.updateAirRear(value);
                    break;
                case 30:
                    Activity17CRVAirControl.this.updateAirAC(value);
                    break;
                case 31:
                    Activity17CRVAirControl.this.updateAirTempLeft(value);
                    break;
                case 35:
                    Activity17CRVAirControl.this.updateAirWind(value);
                    break;
                case 37:
                    Activity17CRVAirControl.this.updateAirTempRight(value);
                    break;
                case 38:
                    Activity17CRVAirControl.this.updateAirOff(value);
                    break;
                case 39:
                    Activity17CRVAirControl.this.updateAirSync(value);
                    break;
                case 73:
                    Activity17CRVAirControl.this.updateAirBlowMode(value);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_321_17crv_air_control);
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
    /* JADX WARN: Code duplicated, block: B:42:0x007e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0080  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a A[ADDED_TO_REGION] */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int cmdId = -1;
        int touchState = -1;
        switch (v.getId()) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                cmdId = 13;
                switch (event.getAction()) {
                    case 0:
                        touchState = 1;
                        break;
                    case 1:
                        touchState = 0;
                        break;
                }
                if (cmdId != -1 && touchState != -1) {
                    setAirControl(cmdId, touchState);
                }
                return false;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                cmdId = 14;
                switch (event.getAction()) {
                    case 0:
                        touchState = 1;
                        break;
                    case 1:
                        touchState = 0;
                        break;
                }
                if (cmdId != -1) {
                    setAirControl(cmdId, touchState);
                }
                return false;
            case R.id.air_xts_power /* 2131427428 */:
                cmdId = 1;
                switch (event.getAction()) {
                    case 0:
                        touchState = 1;
                        break;
                    case 1:
                        touchState = 0;
                        break;
                }
                if (cmdId != -1) {
                    setAirControl(cmdId, touchState);
                }
                return false;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                int value = DataCanbus.DATA[35] - 1;
                if (value < 0) {
                    value = 0;
                }
                if (event.getAction() == 1) {
                    setAirControl(25, value);
                }
                return false;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                int value2 = DataCanbus.DATA[35] + 1;
                if (value2 > 7) {
                    value2 = 7;
                }
                if (event.getAction() == 1) {
                    setAirControl(25, value2);
                }
                return false;
            case R.id.air_xts_auto /* 2131427436 */:
                cmdId = 4;
                switch (event.getAction()) {
                    case 0:
                        touchState = 1;
                        break;
                    case 1:
                        touchState = 0;
                        break;
                }
                if (cmdId != -1) {
                    setAirControl(cmdId, touchState);
                }
                return false;
            case R.id.air_xts_cycle /* 2131427437 */:
                cmdId = 7;
                switch (event.getAction()) {
                    case 0:
                        touchState = 1;
                        break;
                    case 1:
                        touchState = 0;
                        break;
                }
                if (cmdId != -1) {
                    setAirControl(cmdId, touchState);
                }
                return false;
            case R.id.air_xts_front /* 2131427438 */:
                cmdId = 5;
                switch (event.getAction()) {
                    case 0:
                        touchState = 1;
                        break;
                    case 1:
                        touchState = 0;
                        break;
                }
                if (cmdId != -1) {
                    setAirControl(cmdId, touchState);
                }
                return false;
            case R.id.air_xts_ac /* 2131427439 */:
                int value3 = DataCanbus.DATA[30] == 0 ? 1 : 0;
                if (event.getAction() == 1) {
                    setAirControl(2, value3);
                }
                return false;
            case R.id.air_xts_sync /* 2131427441 */:
                cmdId = 3;
                switch (event.getAction()) {
                    case 0:
                        touchState = 1;
                        break;
                    case 1:
                        touchState = 0;
                        break;
                }
                if (cmdId != -1) {
                    setAirControl(cmdId, touchState);
                }
                return false;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                cmdId = 10;
                switch (event.getAction()) {
                    case 0:
                        touchState = 1;
                        break;
                    case 1:
                        touchState = 0;
                        break;
                }
                if (cmdId != -1) {
                    setAirControl(cmdId, touchState);
                }
                return false;
            case R.id.air_xts_mode_body /* 2131427444 */:
                cmdId = 9;
                switch (event.getAction()) {
                    case 0:
                        touchState = 1;
                        break;
                    case 1:
                        touchState = 0;
                        break;
                }
                if (cmdId != -1) {
                    setAirControl(cmdId, touchState);
                }
                return false;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                cmdId = 15;
                switch (event.getAction()) {
                    case 0:
                        touchState = 1;
                        break;
                    case 1:
                        touchState = 0;
                        break;
                }
                if (cmdId != -1) {
                    setAirControl(cmdId, touchState);
                }
                return false;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                cmdId = 16;
                switch (event.getAction()) {
                    case 0:
                        touchState = 1;
                        break;
                    case 1:
                        touchState = 0;
                        break;
                }
                if (cmdId != -1) {
                    setAirControl(cmdId, touchState);
                }
                return false;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                cmdId = 24;
                switch (event.getAction()) {
                    case 0:
                        touchState = 1;
                        break;
                    case 1:
                        touchState = 0;
                        break;
                }
                if (cmdId != -1) {
                    setAirControl(cmdId, touchState);
                }
                return false;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                cmdId = 23;
                switch (event.getAction()) {
                    case 0:
                        touchState = 1;
                        break;
                    case 1:
                        touchState = 0;
                        break;
                }
                if (cmdId != -1) {
                    setAirControl(cmdId, touchState);
                }
                return false;
            case R.id.air_xts_rear /* 2131427534 */:
                cmdId = 6;
                switch (event.getAction()) {
                    case 0:
                        touchState = 1;
                        break;
                    case 1:
                        touchState = 0;
                        break;
                }
                if (cmdId != -1) {
                    setAirControl(cmdId, touchState);
                }
                return false;
            default:
                switch (event.getAction()) {
                    case 0:
                        touchState = 1;
                        break;
                    case 1:
                        touchState = 0;
                        break;
                }
                if (cmdId != -1) {
                    setAirControl(cmdId, touchState);
                }
                return false;
        }
    }

    private void setAirControl(int cmdId, int touchState) {
        DataCanbus.PROXY.cmd(107, cmdId, touchState);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        AirHelper.disableAirWindowLocal(true);
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        AirHelper.disableAirWindowLocal(false);
        mIsFront = false;
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mCanbusNotify);
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
        if (DataCanbus.DATA[73] == 4) {
            ((Button) findViewById(R.id.air_xts_mode_footwin)).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
            return;
        }
        if (DataCanbus.DATA[73] == 5) {
            ((Button) findViewById(R.id.air_xts_mode_footbody)).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
        } else if (DataCanbus.DATA[73] == 3) {
            ((Button) findViewById(R.id.air_xts_mode_foot)).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
        } else if (DataCanbus.DATA[73] == 6) {
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
