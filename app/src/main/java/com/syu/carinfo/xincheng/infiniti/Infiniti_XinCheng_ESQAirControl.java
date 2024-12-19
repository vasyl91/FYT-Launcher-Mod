package com.syu.carinfo.xincheng.infiniti;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Infiniti_XinCheng_ESQAirControl extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xincheng.infiniti.Infiniti_XinCheng_ESQAirControl.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 8:
                    Infiniti_XinCheng_ESQAirControl.this.mUpdateAcOn();
                    break;
                case 9:
                case 14:
                    Infiniti_XinCheng_ESQAirControl.this.mUpdateCycle();
                    break;
                case 10:
                    Infiniti_XinCheng_ESQAirControl.this.mUpdateRearDefrost();
                    break;
                case 11:
                    Infiniti_XinCheng_ESQAirControl.this.mUpdateAutoOn();
                    break;
                case 12:
                    Infiniti_XinCheng_ESQAirControl.this.mUpdateDualOn();
                    break;
                case 13:
                    Infiniti_XinCheng_ESQAirControl.this.mUpdateFrontDefrost();
                    break;
                case 15:
                case 16:
                case 17:
                    Infiniti_XinCheng_ESQAirControl.this.updateBtnSource();
                    break;
                case 18:
                    Infiniti_XinCheng_ESQAirControl.this.mUpdatePowerOn();
                    Infiniti_XinCheng_ESQAirControl.this.mUpdaterAirWindLevelLeft();
                    break;
                case 19:
                    Infiniti_XinCheng_ESQAirControl.this.mUpdateAirTempLeft();
                    break;
                case 20:
                    Infiniti_XinCheng_ESQAirControl.this.mUpdateAirTempRight();
                    break;
                case 110:
                    Infiniti_XinCheng_ESQAirControl.this.mUpdateBlowUPOn();
                    break;
                case 111:
                    Infiniti_XinCheng_ESQAirControl.this.mUpdateForestOn();
                    break;
                case 112:
                    Infiniti_XinCheng_ESQAirControl.this.mUpdaterBlowRightWindow();
                    break;
                case 113:
                    Infiniti_XinCheng_ESQAirControl.this.mUpdaterBlowBodyRightOn();
                    break;
                case 114:
                    Infiniti_XinCheng_ESQAirControl.this.mUpdaterBlowFootRightOn();
                    break;
            }
        }
    };
    int body_right = 0;
    int foot_right = 0;
    int window_right = 0;
    int mode_right = 0;
    private Handler mHandler_right = new Handler(LauncherApplication.getInstance().getMainLooper());
    private Runnable mrun_right = new Runnable() { // from class: com.syu.carinfo.xincheng.infiniti.Infiniti_XinCheng_ESQAirControl.2
        @Override // java.lang.Runnable
        public void run() {
            Infiniti_XinCheng_ESQAirControl.this.updateBtnSource_right();
        }
    };

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(3, new int[]{data0, data1}, null, null);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 1573316) {
            setContentView(R.layout.layout_0452_xinc_infinidi_esq_air_control);
        } else if (DataCanbus.DATA[1000] == 2032068) {
            setContentView(R.layout.layout_0452_xinc_infinidi_q70l_air_control);
        } else if (DataCanbus.DATA[1000] == 1900996) {
            setContentView(R.layout.layout_0452_xinc_infinidi_qx60_air_control);
        } else {
            setContentView(R.layout.layout_0452_xinc_infinidi_fx_other_air_control);
        }
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        if (DataCanbus.DATA[1000] == 1573316) {
            findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
            findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
            findViewById(R.id.air_xts_mode_footbody).setOnTouchListener(this);
            findViewById(R.id.air_xts_mode_footwin).setOnTouchListener(this);
            return;
        }
        if (DataCanbus.DATA[1000] == 2032068) {
            findViewById(R.id.air_xts_mode).setOnTouchListener(this);
            findViewById(R.id.air_xts_mode_right).setOnTouchListener(this);
            findViewById(R.id.air_xts_forest).setOnTouchListener(this);
            findViewById(R.id.air_xts_blowup).setOnTouchListener(this);
            findViewById(R.id.air_xts_dual).setOnTouchListener(this);
            return;
        }
        if (DataCanbus.DATA[1000] == 1900996) {
            findViewById(R.id.air_xts_mode).setOnTouchListener(this);
            findViewById(R.id.air_xts_dual).setOnTouchListener(this);
            findViewById(R.id.air_xts_rearpage).setOnTouchListener(this);
            return;
        }
        findViewById(R.id.air_xts_mode).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addUpdater();
        AirHelper.disableAirWindowLocal(true);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeUpdater();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        boolean flag = false;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data0 = 3;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 2;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 9;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 10;
                break;
            case R.id.air_xts_mode /* 2131427434 */:
                data0 = 36;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 21;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                if (DataCanbus.DATA[1000] == 1573316 || DataCanbus.DATA[1000] == 2032068) {
                    if (DataCanbus.DATA[9] == 1) {
                        data0 = 35;
                        break;
                    } else {
                        data0 = 34;
                        break;
                    }
                } else {
                    data0 = 25;
                    break;
                }
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 18;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 23;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                data0 = 8;
                break;
            case R.id.air_xts_mode_body /* 2131427444 */:
                data0 = 7;
                break;
            case R.id.air_xts_rearpage /* 2131427448 */:
                flag = true;
                try {
                    startActivity(new Intent(this, (Class<?>) Infiniti_Qx60RearAirControlAct.class));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 5;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 4;
                break;
            case R.id.air_xts_dual /* 2131427460 */:
                data0 = 16;
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                data0 = 33;
                break;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                data0 = 32;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                data0 = 20;
                break;
            case R.id.air_xts_mode_right /* 2131427724 */:
                data0 = 66;
                break;
            case R.id.air_xts_blowup /* 2131428550 */:
                data0 = 22;
                break;
            case R.id.air_xts_forest /* 2131428551 */:
                data0 = 67;
                break;
        }
        if (!flag) {
            if (event.getAction() == 0) {
                sendCmd(data0, 1);
            } else if (event.getAction() == 1) {
                sendCmd(data0, 0);
            }
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBlowUPOn() {
        int acOn = DataCanbus.DATA[110];
        if (findViewById(R.id.air_xts_blowup) != null) {
            findViewById(R.id.air_xts_blowup).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_blowup_n : R.drawable.ic_xts_blowup_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateForestOn() {
        int acOn = DataCanbus.DATA[111];
        if (findViewById(R.id.air_xts_forest) != null) {
            findViewById(R.id.air_xts_forest).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_forest_n : R.drawable.ic_xts_forest_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[19];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
            } else if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp * 5 * 0.1f) + "°C");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempRight() {
        int temp = DataCanbus.DATA[20];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
            } else if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp * 5 * 0.1f) + "°C");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateDualOn() {
        int acOn = DataCanbus.DATA[12];
        if (findViewById(R.id.air_xts_dual) != null) {
            findViewById(R.id.air_xts_dual).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_dual_n : R.drawable.ic_xts_dual_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[8];
        if (findViewById(R.id.air_xts_ac) != null) {
            findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[18];
        if (findViewById(R.id.air_xts_power) != null) {
            findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[9];
        int cycle_auto = DataCanbus.DATA[14];
        if (findViewById(R.id.air_xts_cycle) != null) {
            if (DataCanbus.DATA[1000] == 1573316 || DataCanbus.DATA[1000] == 1900996 || DataCanbus.DATA[1000] == 2032068) {
                if (cycle == 0) {
                    findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
                    return;
                } else {
                    if (cycle == 1) {
                        findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
                        return;
                    }
                    return;
                }
            }
            if (cycle == 0 && cycle_auto == 0) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycleauto_0);
                return;
            }
            if (cycle == 1 && cycle_auto == 0) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycleauto_1);
            } else if (cycle == 1 && cycle_auto == 1) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycleauto_2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[13];
        if (findViewById(R.id.air_xts_front) != null) {
            findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[10];
        if (findViewById(R.id.air_xts_rear) != null) {
            findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[18];
        if (leave < 0) {
            leave = 0;
        }
        String str = " " + leave + " ";
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBtnSource() {
        int window = DataCanbus.DATA[15];
        int body = DataCanbus.DATA[16];
        int foot = DataCanbus.DATA[17];
        int mode = 0;
        if (foot == 1) {
            mode = 0 | 1;
        } else if (foot == 0) {
            mode = 0 & 254;
        }
        if (body == 1) {
            mode |= 2;
        } else if (body == 0) {
            mode &= 253;
        }
        if (window == 1) {
            mode |= 4;
        } else if (window == 0) {
            mode &= 251;
        }
        if (DataCanbus.DATA[1000] == 1573316) {
            findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
            findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
            findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
            findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
            switch (mode) {
                case 1:
                    findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
                    break;
                case 2:
                    findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
                    break;
                case 3:
                    findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
                    break;
                case 5:
                    findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
                    break;
            }
        }
        if (DataCanbus.DATA[1000] == 2032068) {
            switch (mode) {
                case 0:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
                    break;
                case 1:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot);
                    break;
                case 2:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body);
                    break;
                case 3:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body);
                    break;
                case 4:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_win);
                    break;
                case 5:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_win);
                    break;
                case 6:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body_win);
                    break;
                case 7:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body_win);
                    break;
                default:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
                    break;
            }
        }
        switch (mode) {
            case 0:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
                break;
            case 1:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot);
                break;
            case 2:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body);
                break;
            case 3:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body);
                break;
            case 4:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_win);
                break;
            case 5:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_win);
                break;
            case 6:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_body_win);
                break;
            case 7:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_foot_body_win);
                break;
            default:
                findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_null);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowBodyRightOn() {
        this.body_right = DataCanbus.DATA[113];
        this.mHandler_right.removeCallbacks(this.mrun_right);
        this.mHandler_right.postDelayed(this.mrun_right, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowFootRightOn() {
        this.foot_right = DataCanbus.DATA[114];
        this.mHandler_right.removeCallbacks(this.mrun_right);
        this.mHandler_right.postDelayed(this.mrun_right, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowRightWindow() {
        this.window_right = DataCanbus.DATA[112];
        this.mHandler_right.removeCallbacks(this.mrun_right);
        this.mHandler_right.postDelayed(this.mrun_right, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBtnSource_right() {
        if (this.foot_right == 1) {
            this.mode_right |= 1;
        } else if (this.foot_right == 0) {
            this.mode_right &= 254;
        }
        if (this.body_right == 1) {
            this.mode_right |= 2;
        } else if (this.body_right == 0) {
            this.mode_right &= 253;
        }
        if (this.window_right == 1) {
            this.mode_right |= 4;
        } else if (this.window_right == 0) {
            this.mode_right &= 251;
        }
        if (DataCanbus.DATA[1000] == 2032068) {
            switch (this.mode_right) {
                case 0:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_xts_mode_null);
                    break;
                case 1:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_xts_mode_foot);
                    break;
                case 2:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_xts_mode_body);
                    break;
                case 3:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_xts_mode_foot_body);
                    break;
                case 4:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_xts_mode_win);
                    break;
                case 5:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_xts_mode_foot_win);
                    break;
                case 6:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_xts_mode_body_win);
                    break;
                case 7:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_xts_mode_foot_body_win);
                    break;
                default:
                    findViewById(R.id.air_xts_mode_right).setBackgroundResource(R.drawable.ic_xts_mode_null);
                    break;
            }
        }
    }
}
