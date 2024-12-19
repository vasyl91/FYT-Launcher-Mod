package com.syu.carinfo.qirui;

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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityRuiHu7 extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.qirui.ActivityRuiHu7.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 23:
                    ActivityRuiHu7.this.updateAirPower(value);
                    break;
                case 24:
                    ActivityRuiHu7.this.updateACmax(value);
                    break;
                case 25:
                    ActivityRuiHu7.this.updateAirAuto(value);
                    break;
                case 27:
                    ActivityRuiHu7.this.updateAirAC(value);
                    break;
                case 28:
                    ActivityRuiHu7.this.updateAirCycle(value);
                    break;
                case 30:
                    ActivityRuiHu7.this.updateAirFront(value);
                    break;
                case 39:
                    ActivityRuiHu7.this.updateAirWind(value);
                    break;
                case 40:
                    ActivityRuiHu7.this.updateAirTempLeft(value);
                    break;
                case 68:
                    ActivityRuiHu7.this.updateAirTempRight(value);
                    break;
                case 69:
                    ActivityRuiHu7.this.updateAirBlowMode(value);
                    break;
                case 72:
                    ActivityRuiHu7.this.updateAirDual(value);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_395_air_ruihu7);
        findViewById(R.id.air_xts_maxac).setVisibility(0);
        findViewById(R.id.air_cycle_outer).setVisibility(8);
        setListener();
    }

    private void setListener() {
        ((Button) findViewById(R.id.air_xts_power)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_left_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_left_minus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_right_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_air_temp_right_minus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setOnTouchListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_cycle_inter)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_maxac)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_front)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_ac)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_auto)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_dual)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode_body)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode_footbody)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode_footwin)).setOnTouchListener(this);
        ((Button) findViewById(R.id.air_xts_mode_foot)).setOnTouchListener(this);
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

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int cmd = 0;
        int touchState = -1;
        if (event.getAction() == 0) {
            touchState = 1;
        } else if (event.getAction() == 1) {
            touchState = 0;
        }
        switch (v.getId()) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                if (touchState == 1) {
                    ((Button) findViewById(R.id.btn_air_temp_left_plus)).setBackgroundResource(R.drawable.ic_xts_temp_plus_p);
                } else if (touchState == 0) {
                    ((Button) findViewById(R.id.btn_air_temp_left_plus)).setBackgroundResource(R.drawable.ic_xts_temp_plus_n);
                }
                cmd = 13;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                if (touchState == 1) {
                    ((Button) findViewById(R.id.btn_air_temp_left_minus)).setBackgroundResource(R.drawable.ic_xts_temp_munits_p);
                } else if (touchState == 0) {
                    ((Button) findViewById(R.id.btn_air_temp_left_minus)).setBackgroundResource(R.drawable.ic_xts_temp_munits_n);
                }
                cmd = 14;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                cmd = 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                if (touchState == 1) {
                    ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setBackgroundResource(R.drawable.ic_xts_win_munits_p);
                } else if (touchState == 0) {
                    ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setBackgroundResource(R.drawable.ic_xts_win_munits_n);
                }
                cmd = 12;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                if (touchState == 1) {
                    ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setBackgroundResource(R.drawable.ic_xts_win_plus_p);
                } else if (touchState == 0) {
                    ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setBackgroundResource(R.drawable.ic_xts_win_plus_n);
                }
                cmd = 11;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                cmd = 4;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                cmd = 5;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                cmd = 2;
                break;
            case R.id.air_xts_maxac /* 2131427440 */:
                cmd = 30;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                cmd = 28;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                cmd = 25;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                if (touchState == 1) {
                    ((Button) findViewById(R.id.btn_air_temp_right_plus)).setBackgroundResource(R.drawable.ic_xts_temp_plus_p);
                } else if (touchState == 0) {
                    ((Button) findViewById(R.id.btn_air_temp_right_plus)).setBackgroundResource(R.drawable.ic_xts_temp_plus_n);
                }
                cmd = 15;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                if (touchState == 1) {
                    ((Button) findViewById(R.id.btn_air_temp_right_minus)).setBackgroundResource(R.drawable.ic_xts_temp_munits_p);
                } else if (touchState == 0) {
                    ((Button) findViewById(R.id.btn_air_temp_right_minus)).setBackgroundResource(R.drawable.ic_xts_temp_munits_n);
                }
                cmd = 16;
                break;
            case R.id.air_xts_dual /* 2131427460 */:
                cmd = 3;
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                cmd = 26;
                break;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                cmd = 27;
                break;
            case R.id.air_cycle_outer /* 2131427557 */:
                if (DataCanbus.DATA[28] == 1) {
                    cmd = 7;
                    break;
                }
            case R.id.air_cycle_inter /* 2131427558 */:
                cmd = 7;
                break;
        }
        if (cmd != 0) {
            setAirControl(cmd, touchState);
        }
        return true;
    }

    private void setAirControl(int cmd, int value) {
        DataCanbus.PROXY.cmd(0, cmd, value);
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mCanbusNotify);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateACmax(int value) {
        if (((Button) findViewById(R.id.air_xts_maxac)) != null) {
            ((Button) findViewById(R.id.air_xts_maxac)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_maxac_n : R.drawable.ic_xts_maxac_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAirPower(int value) {
        if (((Button) findViewById(R.id.air_xts_power)) != null) {
            ((Button) findViewById(R.id.air_xts_power)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAirAC(int value) {
        if (((Button) findViewById(R.id.air_xts_ac)) != null) {
            ((Button) findViewById(R.id.air_xts_ac)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAirAuto(int value) {
        if (((Button) findViewById(R.id.air_xts_auto)) != null) {
            ((Button) findViewById(R.id.air_xts_auto)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAirFront(int value) {
        if (((Button) findViewById(R.id.air_xts_front)) != null) {
            ((Button) findViewById(R.id.air_xts_front)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAirDual(int value) {
        if (((Button) findViewById(R.id.air_xts_dual)) != null) {
            ((Button) findViewById(R.id.air_xts_dual)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_dual_n : R.drawable.ic_xts_dual_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAirBlowMode(int value) {
        ((Button) findViewById(R.id.air_xts_mode_body)).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
        ((Button) findViewById(R.id.air_xts_mode_footbody)).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
        ((Button) findViewById(R.id.air_xts_mode_footwin)).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
        ((Button) findViewById(R.id.air_xts_mode_foot)).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
        switch (value) {
            case 3:
                ((Button) findViewById(R.id.air_xts_mode_foot)).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
                break;
            case 5:
                ((Button) findViewById(R.id.air_xts_mode_footbody)).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
                break;
            case 6:
                ((Button) findViewById(R.id.air_xts_mode_body)).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
                break;
            case 12:
                ((Button) findViewById(R.id.air_xts_mode_footwin)).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
                break;
            case 14:
                ((Button) findViewById(R.id.air_xts_mode_body)).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
                ((Button) findViewById(R.id.air_xts_mode_footwin)).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAirTempLeft(int value) {
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (value == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (value == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HIGHT");
            } else if (value == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("NONE");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(value / 10.0f) + "℃");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAirTempRight(int value) {
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (value == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (value == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HIGHT");
            } else if (value == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("NONE");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(value / 10.0f) + "℃");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAirWind(int value) {
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAirCycle(int value) {
        if (((Button) findViewById(R.id.air_cycle_inter)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_cycle_inter)).setBackgroundResource(R.drawable.ic_cycle_all_n);
            } else {
                ((Button) findViewById(R.id.air_cycle_inter)).setBackgroundResource(R.drawable.ic_cycle_all_p);
            }
        }
    }
}
