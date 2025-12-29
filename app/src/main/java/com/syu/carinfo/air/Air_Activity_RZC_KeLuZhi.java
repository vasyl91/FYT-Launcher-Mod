package com.syu.carinfo.air;

import android.app.Activity;
import android.os.Bundle;
import android.SystemProperties;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_Activity_RZC_KeLuZhi extends Activity implements View.OnTouchListener {
    public static Air_Activity_RZC_KeLuZhi mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode != ConstAllAirDara.U_AIR_AC) {
                if (updateCode != ConstAllAirDara.U_AIR_CYCLE) {
                    if (updateCode != ConstAllAirDara.U_AIR_REAR) {
                        if (updateCode != ConstAllAirDara.U_AIR_FRONT) {
                            if (updateCode != ConstAllAirDara.U_AIR_TEMP_LEFT) {
                                if (updateCode != ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT) {
                                    if (updateCode != ConstAllAirDara.U_AIR_BLOW_MODE_LEFT) {
                                        if (updateCode != ConstAllAirDara.U_AIR_BLOW_UP_LEFT) {
                                            if (updateCode != ConstAllAirDara.U_AIR_BLOW_BODY_LEFT) {
                                                if (updateCode != ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT) {
                                                    return;
                                                }
                                                Air_Activity_RZC_KeLuZhi.this.updateBlowModeFoot();
                                                return;
                                            }
                                            Air_Activity_RZC_KeLuZhi.this.updateBlowModeBody();
                                            return;
                                        }
                                        Air_Activity_RZC_KeLuZhi.this.updateBlowModeUp();
                                        return;
                                    }
                                    Air_Activity_RZC_KeLuZhi.this.updateBlowMode();
                                    return;
                                }
                                Air_Activity_RZC_KeLuZhi.this.mUpdaterAirWindLevelLeft();
                                return;
                            }
                            Air_Activity_RZC_KeLuZhi.this.mUpdateAirTempLeft();
                            return;
                        }
                        Air_Activity_RZC_KeLuZhi.this.mUpdateFrontDefrost();
                        return;
                    }
                    Air_Activity_RZC_KeLuZhi.this.mUpdateRearDefrost();
                    return;
                }
                Air_Activity_RZC_KeLuZhi.this.mUpdateCycle();
                return;
            }
            Air_Activity_RZC_KeLuZhi.this.mUpdateAcOn();
        }
    };

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String platform = SystemProperties.get("ro.fyt.platform", "");
        if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform) || "6318".equals(platform) || "823".equals(platform)) {
            //setContentView(R.layout.layout_air_sp_rzc_keluzhi);
            if ("6318".equals(platform) || "823".equals(platform)) {
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.sp_air_bg_7870);
            } else {
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.sp_air_bg);
            }
        } else {
            //setContentView(R.layout.layout_air_sp_rzc_keluzhi_7731);
        }
        initCallbackId();
        init();
        mInstance = this;
    }

    public void initCallbackId() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_ALL_GM_SP_6 /* 393277 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_7 /* 458813 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_8 /* 524349 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_MODE_LEFT = 77;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_MODE_BODY = 7;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 33;
                ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 32;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_CONTRAL = 10;
                break;
        }
    }

    private void init() {
        findViewById(R.id.air_sp_ac).setOnTouchListener(this);
        findViewById(R.id.air_sp_front).setOnTouchListener(this);
        findViewById(R.id.air_sp_rear).setOnTouchListener(this);
        findViewById(R.id.air_sp_cycle).setOnTouchListener(this);
        findViewById(R.id.air_sp_blow_body).setOnTouchListener(this);
        findViewById(R.id.air_sp_blow_body_foot).setOnTouchListener(this);
        findViewById(R.id.air_sp_blow_foot).setOnTouchListener(this);
        findViewById(R.id.air_sp_blow_foot_win).setOnTouchListener(this);
        findViewById(R.id.air_sp_wind_minuts).setOnTouchListener(this);
        findViewById(R.id.air_sp_wind_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_left_munits).setOnTouchListener(this);
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
        switch (id) {
            case R.id.air_sp_temp_left_plus /* 2131430261 */:
                data0 = ConstAllAirDara.C_AIR_TEMP_LEFT_ADD;
                break;
            case R.id.air_sp_temp_left_munits /* 2131430265 */:
                data0 = ConstAllAirDara.C_AIR_TEMP_LEFT_SUB;
                break;
            case R.id.air_sp_ac /* 2131430275 */:
                data0 = ConstAllAirDara.C_AIR_AC;
                break;
            case R.id.air_sp_front /* 2131430277 */:
                data0 = ConstAllAirDara.C_AIR_FRONT_DEFROST;
                break;
            case R.id.air_sp_rear /* 2131430278 */:
                data0 = ConstAllAirDara.C_AIR_REAR_DEFROST;
                break;
            case R.id.air_sp_wind_minuts /* 2131430281 */:
                data0 = ConstAllAirDara.C_AIR_WIND_SUB;
                break;
            case R.id.air_sp_wind_plus /* 2131430283 */:
                data0 = ConstAllAirDara.C_AIR_WIND_ADD;
                break;
            case R.id.air_sp_cycle /* 2131430284 */:
                data0 = ConstAllAirDara.C_AIR_CYCLE;
                break;
            case R.id.air_sp_blow_body_foot /* 2131430379 */:
                data0 = ConstAllAirDara.C_AIR_MODE_BODYFOOT;
                break;
            case R.id.air_sp_blow_foot /* 2131430381 */:
                data0 = ConstAllAirDara.C_AIR_MODE_FOOT;
                break;
            case R.id.air_sp_blow_body /* 2131430383 */:
                data0 = ConstAllAirDara.C_AIR_MODE_BODY;
                break;
            case R.id.air_sp_blow_foot_win /* 2131430385 */:
                data0 = ConstAllAirDara.C_AIR_MODE_UPFOOT;
                break;
        }
        if (event.getAction() == 0) {
            sendCmd(data0, 1);
        } else if (event.getAction() == 1) {
            sendCmd(data0, 0);
        }
        return false;
    }

    private void addUpdater() {
        if (ConstAllAirDara.U_AIR_REAR != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_CYCLE != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_CYCLE].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_AC != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_AC].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_POWER != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_POWER].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BLOW_MODE_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_MODE_LEFT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_FRONT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FRONT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BLOW_BODY_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BLOW_UP_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_UP_LEFT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_TEMP_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_TEMP_LEFT].addNotify(this.mNotifyCanbus, 1);
        }
    }

    private void removeUpdater() {
        if (ConstAllAirDara.U_AIR_REAR != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_POWER != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_POWER].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_AC != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_AC].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_CYCLE != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_CYCLE].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BLOW_MODE_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_MODE_LEFT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_FRONT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FRONT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BLOW_BODY_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BLOW_UP_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_UP_LEFT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_TEMP_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_TEMP_LEFT].removeNotify(this.mNotifyCanbus);
        }
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT];
        if (((TextView) findViewById(R.id.air_sp_temp_left)) != null) {
            if (temp == 0) {
                ((TextView) findViewById(R.id.air_sp_temp_left)).setText("LO");
                ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
            } else if (temp == 30) {
                ((TextView) findViewById(R.id.air_sp_temp_left)).setText("HI");
                ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
            } else if (temp == -1) {
                ((TextView) findViewById(R.id.air_sp_temp_left)).setText("--");
                ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
            } else {
                ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp / 10) + "." + (temp % 10));
                ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
            }
        }
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC];
        findViewById(R.id.air_sp_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_sp_ac_n : R.drawable.ic_sp_ac_p);
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE];
        findViewById(R.id.air_sp_cycle).setBackgroundResource(cycle == 0 ? R.drawable.ic_sp_cylce_out_p : R.drawable.ic_sp_cylce_in_p);
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR];
        findViewById(R.id.air_sp_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_rear_n : R.drawable.ic_sp_rear_p);
    }

    
    public void mUpdateFrontDefrost() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT];
        findViewById(R.id.air_sp_front).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_front_n : R.drawable.ic_sp_front_p);
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
        switch (leave) {
            case 0:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind_0);
                break;
            case 1:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind_1);
                break;
            case 2:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind_2);
                break;
            case 3:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind_3);
                break;
            case 4:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind_4);
                break;
            case 5:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind_5);
                break;
            case 6:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind_6);
                break;
            case 7:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind_7);
                break;
            case 8:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind_8);
                break;
        }
    }

    
    public void updateBlowMode() {
        int mode = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_MODE_LEFT];
        findViewById(R.id.air_sp_blow_body).setBackgroundResource(mode == 5 ? R.drawable.ic_sp_mode_body_p : R.drawable.ic_sp_mode_body_n);
        findViewById(R.id.air_sp_blow_body_foot).setBackgroundResource(mode == 4 ? R.drawable.ic_sp_mode_body_foot_p : R.drawable.ic_sp_mode_body_foot_n);
        findViewById(R.id.air_sp_blow_foot).setBackgroundResource(mode == 3 ? R.drawable.ic_sp_mode_foot_p : R.drawable.ic_sp_mode_foot_n);
        findViewById(R.id.air_sp_blow_foot_win).setBackgroundResource(mode == 8 ? R.drawable.ic_sp_mode_win_foot_p : R.drawable.ic_sp_mode_win_foot_n);
    }

    
    public void updateBlowModeUp() {
        int data = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT];
        findViewById(R.id.air_sp_mode_up).setVisibility(data == 1 ? 0 : 8);
    }

    
    public void updateBlowModeBody() {
        int data = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT];
        findViewById(R.id.air_sp_mode_body).setVisibility(data == 1 ? 0 : 8);
    }

    
    public void updateBlowModeFoot() {
        int data = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT];
        findViewById(R.id.air_sp_mode_foot).setVisibility(data == 1 ? 0 : 8);
    }
}
