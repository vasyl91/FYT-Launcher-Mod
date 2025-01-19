package com.syu.carinfo.lz.lexusis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class KYCLexusFrontAirControlAct_beifen extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 11:
                    KYCLexusFrontAirControlAct_beifen.this.mUpdateAcOn();
                    break;
                case 12:
                case 54:
                    KYCLexusFrontAirControlAct_beifen.this.mUpdateCycle();
                    break;
                case 13:
                    KYCLexusFrontAirControlAct_beifen.this.mUpdateAutoOn();
                    break;
                case 16:
                    KYCLexusFrontAirControlAct_beifen.this.mUpdateRearDefrost();
                    break;
                case 17:
                    KYCLexusFrontAirControlAct_beifen.this.mUpdateFrontHotOn();
                    break;
                case 18:
                case 19:
                case 20:
                    KYCLexusFrontAirControlAct_beifen.this.updateBtnSource();
                    break;
                case 21:
                    KYCLexusFrontAirControlAct_beifen.this.mUpdatePowerOn();
                    KYCLexusFrontAirControlAct_beifen.this.mUpdaterAirWindLevelLeft();
                    break;
                case 22:
                case 23:
                case 24:
                    KYCLexusFrontAirControlAct_beifen.this.updateBtnSourceRight();
                    break;
                case 27:
                    KYCLexusFrontAirControlAct_beifen.this.mUpdateAirTempLeft();
                    break;
                case 28:
                    KYCLexusFrontAirControlAct_beifen.this.mUpdateAirTempRight();
                    break;
                case 33:
                    KYCLexusFrontAirControlAct_beifen.this.mUpdateClearOn();
                    break;
                case 37:
                    KYCLexusFrontAirControlAct_beifen.this.mUpdateAirTempLeft();
                    KYCLexusFrontAirControlAct_beifen.this.mUpdateAirTempRight();
                    break;
                case 62:
                    KYCLexusFrontAirControlAct_beifen.this.mUpdateDualOn();
                    break;
                case 65:
                    KYCLexusFrontAirControlAct_beifen.this.mUpdateFrontDefrost();
                    break;
                case 67:
                    KYCLexusFrontAirControlAct_beifen.this.mUpdateRearLockOn();
                    break;
            }
        }
    };

    private void sendCmd(int data0) {
        DataCanbus.PROXY.cmd(3, new int[]{data0}, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_lz_lexus_ls_air_control);
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_front_hot).setOnTouchListener(this);
        findViewById(R.id.air_xts_clear).setOnTouchListener(this);
        findViewById(R.id.air_xts_front_blow_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_rearlock).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_rearpage).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode).setOnTouchListener(this);
        findViewById(R.id.air_xts_front).setOnTouchListener(this);
        findViewById(R.id.air_xts_rear).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_dual).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addUpdater();
        AirHelper.disableAirWindowLocal(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeUpdater();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        boolean flag = false;
        switch (id) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                data0 = 9;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                data0 = 10;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                data0 = 1;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                data0 = 21;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                data0 = 20;
                break;
            case R.id.air_xts_mode /* 2131427434 */:
                data0 = 17;
                break;
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 2;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 35;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                data0 = 38;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                data0 = 16;
                break;
            case R.id.air_xts_rearlock /* 2131427446 */:
                data0 = 37;
                break;
            case R.id.air_xts_rearpage /* 2131427448 */:
                flag = true;
                try {
                    startActivity(new Intent(this, KYCLexusRearAirControlAct.class));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                data0 = 11;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                data0 = 12;
                break;
            case R.id.air_xts_dual /* 2131427460 */:
                data0 = 8;
                break;
            case R.id.air_xts_clear /* 2131427465 */:
                data0 = 15;
                break;
            case R.id.air_xts_front_hot /* 2131427466 */:
                data0 = 50;
                break;
            case R.id.air_xts_rear /* 2131427534 */:
                data0 = 4;
                break;
            case R.id.air_xts_mode_right /* 2131427724 */:
                data0 = 42;
                break;
        }
        if (!flag && event.getAction() == 0) {
            sendCmd(data0);
            return false;
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateAirTempLeft() {
        int unit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[27];
        if (findViewById(R.id.tv_air_temp_left) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else {
                if (unit == 0) {
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp * 5 * 0.1f) + "℃");
                    return;
                }
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp + 31) + "℉");
            }
        }
    }

    
    public void mUpdateAirTempRight() {
        int unit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[28];
        if (findViewById(R.id.tv_air_temp_right) != null) {
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else {
                if (unit == 0) {
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp * 5 * 0.1f) + "℃");
                    return;
                }
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp + 31) + "℉");
            }
        }
    }

    
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[13];
        if (findViewById(R.id.air_xts_auto) != null) {
            findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
        }
    }

    
    public void mUpdateDualOn() {
        int acOn = DataCanbus.DATA[62];
        if (findViewById(R.id.air_xts_dual) != null) {
            findViewById(R.id.air_xts_dual).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_sync_n : R.drawable.ic_xts_sync_p);
        }
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        if (findViewById(R.id.air_xts_ac) != null) {
            findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    
    public void mUpdateClearOn() {
        if (findViewById(R.id.air_xts_clear) != null) {
            int power = DataCanbus.DATA[33];
            findViewById(R.id.air_xts_clear).setBackgroundResource(power == 0 ? R.drawable.ic_xts_clear_air_n : R.drawable.ic_xts_clear_air_p);
        }
    }

    
    public void mUpdateFrontHotOn() {
        int power = DataCanbus.DATA[17];
        if (findViewById(R.id.air_xts_front_hot) != null) {
            findViewById(R.id.air_xts_front_hot).setBackgroundResource(power == 0 ? R.drawable.ic_xts_fronthot_n : R.drawable.ic_xts_fronthot_p);
        }
    }

    
    public void mUpdateRearLockOn() {
        int power = DataCanbus.DATA[67];
        if (findViewById(R.id.air_xts_rearlock) != null) {
            findViewById(R.id.air_xts_rearlock).setBackgroundResource(power == 0 ? R.drawable.ic_xts_rearlock_n : R.drawable.ic_xts_rearlock_p);
        }
    }

    
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[21];
        if (findViewById(R.id.air_xts_power) != null) {
            findViewById(R.id.air_xts_power).setBackgroundResource(power == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        }
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        int auto = DataCanbus.DATA[54];
        if (auto == 1) {
            if (cycle == 0) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycleauto_3);
                return;
            } else {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycleauto_2);
                return;
            }
        }
        if (cycle == 0) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycleauto_0);
        } else if (cycle == 1) {
            findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycleauto_1);
        }
    }

    
    public void mUpdateFrontDefrost() {
        int front = DataCanbus.DATA[65];
        if (findViewById(R.id.air_xts_front) != null) {
            findViewById(R.id.air_xts_front).setBackgroundResource(front == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
        }
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[16];
        if (findViewById(R.id.air_xts_rear) != null) {
            findViewById(R.id.air_xts_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
        }
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[21];
        if (leave < 0) {
            leave = 0;
        }
        if (leave > 8) {
            leave = 8;
        }
        String str = " " + leave + " ";
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(str);
    }

    
    public void updateBtnSource() {
        int window = DataCanbus.DATA[18];
        int foot = DataCanbus.DATA[20];
        int body = DataCanbus.DATA[19];
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

    
    public void updateBtnSourceRight() {
        int body_right = DataCanbus.DATA[23];
        int foot_right = DataCanbus.DATA[24];
        int window_right = DataCanbus.DATA[22];
        int mode_right = 0;
        if (foot_right == 1) {
            mode_right = 0 | 1;
        } else if (foot_right == 0) {
            mode_right = 0 & 254;
        }
        if (body_right == 1) {
            mode_right |= 2;
        } else if (body_right == 0) {
            mode_right &= 253;
        }
        if (window_right == 1) {
            mode_right |= 4;
        } else if (window_right == 0) {
            mode_right &= 251;
        }
        if (findViewById(R.id.air_xts_mode_right) != null) {
            switch (mode_right) {
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
