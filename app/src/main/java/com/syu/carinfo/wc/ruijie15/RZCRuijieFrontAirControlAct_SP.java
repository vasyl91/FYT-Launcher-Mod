package com.syu.carinfo.wc.ruijie15;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZCRuijieFrontAirControlAct_SP extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ruijie15.RZCRuijieFrontAirControlAct_SP.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 15:
                    RZCRuijieFrontAirControlAct_SP.this.mUpdatePowerOn();
                    break;
                case 16:
                    RZCRuijieFrontAirControlAct_SP.this.mUpdateAcOn();
                    break;
                case 17:
                    RZCRuijieFrontAirControlAct_SP.this.mUpdateMaxFrontOn();
                    break;
                case 18:
                    RZCRuijieFrontAirControlAct_SP.this.mUpdateCycle();
                    break;
                case 19:
                    RZCRuijieFrontAirControlAct_SP.this.mUpdateAutoOn();
                    break;
                case 20:
                    RZCRuijieFrontAirControlAct_SP.this.updateBtnSource();
                    if (DataCanbus.DATA[1000] != 3014990) {
                        RZCRuijieFrontAirControlAct_SP.this.mUpdaterBlowWindow();
                        break;
                    }
                case 21:
                    RZCRuijieFrontAirControlAct_SP.this.updateBtnSource();
                    if (DataCanbus.DATA[1000] != 3014990) {
                        RZCRuijieFrontAirControlAct_SP.this.mUpdaterBlowBodyLeftOn();
                        break;
                    }
                case 22:
                    RZCRuijieFrontAirControlAct_SP.this.updateBtnSource();
                    if (DataCanbus.DATA[1000] != 3014990) {
                        RZCRuijieFrontAirControlAct_SP.this.mUpdaterBlowFootLeftOn();
                        break;
                    }
                case 23:
                    RZCRuijieFrontAirControlAct_SP.this.mUpdaterAirWindLevelLeft();
                    break;
                case 24:
                    RZCRuijieFrontAirControlAct_SP.this.mUpdateAirTempLeft();
                    break;
                case 25:
                    RZCRuijieFrontAirControlAct_SP.this.mUpdateAirTempRight();
                    break;
                case 26:
                    RZCRuijieFrontAirControlAct_SP.this.mUpdateDualOn();
                    break;
                case 27:
                    RZCRuijieFrontAirControlAct_SP.this.mUpdateMaxAcOn();
                    break;
                case 28:
                    RZCRuijieFrontAirControlAct_SP.this.mUpdateAirTempLeft();
                    RZCRuijieFrontAirControlAct_SP.this.mUpdateAirTempRight();
                    break;
                case 48:
                    RZCRuijieFrontAirControlAct_SP.this.mUpdateRearDefrost();
                    break;
                case 56:
                    RZCRuijieFrontAirControlAct_SP.this.mUpdateFrontDefrost();
                    break;
                case 112:
                    RZCRuijieFrontAirControlAct_SP.this.mUpdateSteerHot();
                    break;
            }
        }
    };

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(1, new int[]{data0, data1}, null, null);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String platform = SystemProperties.get("ro.fyt.platform", "");
        if ("6521".equals(platform) || "6315".equals(platform) || "6312".equals(platform) || "6316".equals(platform)) {
            if (DataCanbus.DATA[1000] == 1704270) {
                setContentView(R.layout.layout_0443_wc_ranger_air_control_9853);
            } else if (DataCanbus.DATA[1000] == 1638734) {
                setContentView(R.layout.layout_0443_wc_pickup_low_air_control_9853);
            } else if (DataCanbus.DATA[1000] == 1507662 || DataCanbus.DATA[1000] == 1573198) {
                setContentView(R.layout.layout_0443_wc_suv_air_control_9853);
            } else if (DataCanbus.DATA[1000] == 3014990) {
                setContentView(R.layout.layout_0334_rzc_13explorer_air_control_9853);
            } else {
                setContentView(R.layout.layout_0334_rzc_18everest_air_control_9853);
            }
        } else if (DataCanbus.DATA[1000] == 3014990) {
            setContentView(R.layout.layout_0334_rzc_13explorer_air_control_7731);
        } else {
            setContentView(R.layout.layout_0334_rzc_18everest_air_control);
        }
        init();
    }

    private void init() {
        if (findViewById(R.id.air_xts_mode_foot) != null) {
            findViewById(R.id.air_xts_mode_foot).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_mode_body) != null) {
            findViewById(R.id.air_xts_mode_body).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_mode_win) != null) {
            findViewById(R.id.air_xts_mode_win).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_mode_footbody) != null) {
            findViewById(R.id.air_xts_mode_footbody).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_mode_footwin) != null) {
            findViewById(R.id.air_xts_mode_footwin).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_rearpage) != null) {
            findViewById(R.id.air_xts_rearpage).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_dual) != null) {
            findViewById(R.id.air_xts_dual).setOnTouchListener(this);
        }
        if (findViewById(R.id.btn_air_temp_left_plus) != null) {
            findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        }
        if (findViewById(R.id.btn_air_temp_left_minus) != null) {
            findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_front) != null) {
            findViewById(R.id.air_xts_front).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_power) != null) {
            findViewById(R.id.air_xts_power).setOnTouchListener(this);
        }
        if (findViewById(R.id.dj_xts_air_win_minuts_btn) != null) {
            findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        }
        if (findViewById(R.id.dj_xts_air_win_plus_btn) != null) {
            findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        }
        if (findViewById(R.id.btn_air_temp_right_plus) != null) {
            findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        }
        if (findViewById(R.id.btn_air_temp_right_minus) != null) {
            findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_rear) != null) {
            findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_auto) != null) {
            findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_cycle) != null) {
            findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_ac) != null) {
            findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_maxac) != null) {
            findViewById(R.id.air_xts_maxac).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_front_max) != null) {
            findViewById(R.id.air_xts_front_max).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_xts_steer_hot) != null) {
            findViewById(R.id.air_xts_steer_hot).setOnTouchListener(this);
        }
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
                data0 = 26;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 27;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 31;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 30;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 23;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 3;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 5;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 2;
                break;
            case R.id.air_xts_maxac /* 2131427440 */:
                data0 = 4;
                break;
            case R.id.air_xts_mode_foot /* 2131427443 */:
                if (DataCanbus.DATA[1000] == 3014990) {
                    data0 = 36;
                    break;
                } else {
                    data0 = 34;
                    break;
                }
            case R.id.air_xts_mode_body /* 2131427444 */:
                if (DataCanbus.DATA[1000] == 3014990) {
                    data0 = 38;
                    break;
                } else {
                    data0 = 33;
                    break;
                }
            case R.id.air_xts_mode_win /* 2131427445 */:
                data0 = 32;
                break;
            case R.id.air_xts_rearpage /* 2131427448 */:
                flag = true;
                try {
                    if (DataCanbus.DATA[1000] == 1442126 || DataCanbus.DATA[1000] == 1507662) {
                        startActivity(new Intent(this, (Class<?>) RZCEverestRearAirControlAct_FLB_H.class));
                    } else if (DataCanbus.DATA[1000] == 1376590 || DataCanbus.DATA[1000] == 1573198) {
                        startActivity(new Intent(this, (Class<?>) RZCEverestRearAirControlAct_SP.class));
                    } else {
                        startActivity(new Intent(this, (Class<?>) RZCRuijieRearAirControlAct_SP.class));
                    }
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 28;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 29;
                break;
            case R.id.air_xts_steer_hot /* 2131427453 */:
                data0 = 11;
                break;
            case R.id.air_xts_dual /* 2131427460 */:
                data0 = 24;
                break;
            case R.id.air_xts_mode_footbody /* 2131427461 */:
                data0 = 37;
                break;
            case R.id.air_xts_mode_footwin /* 2131427462 */:
                data0 = 35;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                data0 = 6;
                break;
            case R.id.air_xts_front_max /* 2131427753 */:
                data0 = 25;
                break;
        }
        if (!flag) {
            if (event.getAction() == 0) {
                sendCmd(172, data0);
            } else if (event.getAction() == 1) {
                sendCmd(172, 0);
            }
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSteerHot() {
        int power = DataCanbus.DATA[112];
        if (findViewById(R.id.air_xts_steer_hot) != null) {
            findViewById(R.id.air_xts_steer_hot).setBackgroundResource(power == 0 ? R.drawable.ic_xts_steer_hot_n : R.drawable.ic_xts_steer_hot_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateMaxFrontOn() {
        int power = DataCanbus.DATA[17];
        if (findViewById(R.id.air_xts_front_max) != null) {
            findViewById(R.id.air_xts_front_max).setBackgroundResource(power == 0 ? R.drawable.ic_xts_maxfront_n : R.drawable.ic_xts_maxfront_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateMaxAcOn() {
        int power = DataCanbus.DATA[27];
        if (findViewById(R.id.air_xts_maxac) != null) {
            findViewById(R.id.air_xts_maxac).setBackgroundResource(power == 0 ? R.drawable.ic_xts_maxac_n : R.drawable.ic_xts_maxac_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int unit = DataCanbus.DATA[28];
        int temp = DataCanbus.DATA[24];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == 1048576) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == 1048577) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("High");
                return;
            }
            if (temp == 1048578) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("None");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp * 0.1f) + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 10) + "℉");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempRight() {
        int unit = DataCanbus.DATA[28];
        int temp = DataCanbus.DATA[25];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == 1048576) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == 1048577) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("High");
                return;
            }
            if (temp == 1048578) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("None");
            } else if (unit == 0) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp * 0.1f) + "℃");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 10) + "℉");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[19];
        if (findViewById(R.id.air_xts_auto) != null) {
            findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateDualOn() {
        int acOn = DataCanbus.DATA[26];
        if (findViewById(R.id.air_xts_dual) != null) {
            findViewById(R.id.air_xts_dual).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_dual_n : R.drawable.ic_xts_dual_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[16];
        if (findViewById(R.id.air_xts_ac) != null) {
            findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[15];
        if (findViewById(R.id.air_xts_power) != null) {
            findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[18];
        if (findViewById(R.id.air_xts_cycle) != null) {
            if (cycle == 0) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_n);
            } else if (cycle == 1) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycle_p);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[56];
        if (findViewById(R.id.air_xts_front) != null) {
            findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[48];
        if (findViewById(R.id.air_xts_rear) != null) {
            findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[23];
        if (leave < 0) {
            leave = 0;
        }
        if (leave > 8) {
            leave = 8;
        }
        String str = " " + leave + " ";
        if (findViewById(R.id.dj_xts_air_winlevel) != null) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowBodyLeftOn() {
        int acOn = DataCanbus.DATA[21];
        if (findViewById(R.id.air_xts_mode_body) != null) {
            findViewById(R.id.air_xts_mode_body).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowFootLeftOn() {
        int acOn = DataCanbus.DATA[22];
        if (findViewById(R.id.air_xts_mode_foot) != null) {
            findViewById(R.id.air_xts_mode_foot).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowWindow() {
        int acOn = DataCanbus.DATA[20];
        if (findViewById(R.id.air_xts_mode_win) != null) {
            findViewById(R.id.air_xts_mode_win).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_mode_win_n : R.drawable.ic_xts_mode_win_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBtnSource() {
        int window = DataCanbus.DATA[20];
        int foot = DataCanbus.DATA[22];
        int body = DataCanbus.DATA[21];
        if (findViewById(R.id.air_xts_mode_footbody) != null && findViewById(R.id.air_xts_mode_foot) != null && findViewById(R.id.air_xts_mode_body) != null && findViewById(R.id.air_xts_mode_footwin) != null) {
            findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_n);
            findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_n);
            findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_n);
            findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_n);
            if (window == 0 && body == 1 && foot == 1) {
                findViewById(R.id.air_xts_mode_footbody).setBackgroundResource(R.drawable.ic_xts_mode_footbody_p);
                return;
            }
            if (window == 1 && body == 0 && foot == 1) {
                findViewById(R.id.air_xts_mode_footwin).setBackgroundResource(R.drawable.ic_xts_mode_footwin_p);
                return;
            }
            if (window == 0 && body == 1 && foot == 0) {
                findViewById(R.id.air_xts_mode_body).setBackgroundResource(R.drawable.ic_xts_mode_body_p);
            } else if (window == 0 && body == 0 && foot == 1) {
                findViewById(R.id.air_xts_mode_foot).setBackgroundResource(R.drawable.ic_xts_mode_foot_p);
            }
        }
    }
}