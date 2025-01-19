package com.syu.carinfo.rzc.gs4;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class Rzc_Gs3_AirControlAct extends Activity {
    public static boolean mIsFront = false;
    protected Handler mHandler;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    Rzc_Gs3_AirControlAct.this.mUpdaterAirPower();
                    break;
                case 11:
                    Rzc_Gs3_AirControlAct.this.mUpdaterAirAC();
                    break;
                case 12:
                    Rzc_Gs3_AirControlAct.this.mUpdateAirCycle();
                    break;
                case 13:
                    Rzc_Gs3_AirControlAct.this.UAuto(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 14:
                    Rzc_Gs3_AirControlAct.this.U3Zone(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 16:
                    Rzc_Gs3_AirControlAct.this.mUpdateAirRearDefrost();
                    break;
                case 18:
                    Rzc_Gs3_AirControlAct.this.UBlowUp(DataCanbus.DATA[updateCode]);
                    break;
                case 20:
                    Rzc_Gs3_AirControlAct.this.UBlowFoot(DataCanbus.DATA[updateCode]);
                    break;
                case 21:
                    Rzc_Gs3_AirControlAct.this.mUpdaterAirWindLevel();
                    break;
                case 27:
                    Rzc_Gs3_AirControlAct.this.UTempLeft(DataCanbus.DATA[updateCode]);
                    break;
                case 28:
                    Rzc_Gs3_AirControlAct.this.UTempRight(DataCanbus.DATA[updateCode]);
                    break;
                case 38:
                    Rzc_Gs3_AirControlAct.this.URearPower(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 58:
                    Rzc_Gs3_AirControlAct.this.UIon(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 65:
                    Rzc_Gs3_AirControlAct.this.mUpdateAirFrontDefrost(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };
    int bFoot = 0;
    int bBody = 0;
    int bWin = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 1311000) {
            //setContentView(R.layout.layout_rzc_gm6_air_control_set);
        } else {
            //setContentView(R.layout.layout_rzc_gs3_air_control_set);
        }
        this.mHandler = new Handler(Looper.getMainLooper());
        init();
    }

    private void init() {
        sendClick((Button) findViewById(R.id.btn_air_temp_left_plus), 13);
        sendClick((Button) findViewById(R.id.btn_air_temp_left_minus), 14);
        sendClick((Button) findViewById(R.id.btn_air_temp_right_plus), 15);
        sendClick((Button) findViewById(R.id.btn_air_temp_right_minus), 16);
        sendClick((Button) findViewById(R.id.air_xts_auto), 2);
        sendClick((Button) findViewById(R.id.air_xts_cycle), 21);
        sendClick((Button) findViewById(R.id.air_xts_dual), 3);
        sendClick((Button) findViewById(R.id.air_xts_mode), 17);
        sendClick((Button) findViewById(R.id.air_xts_power), 0);
        sendClick((Button) findViewById(R.id.air_xts_ac), 1);
        sendClick((Button) findViewById(R.id.air_xts_ion), 30);
        sendClick((Button) findViewById(R.id.air_xts_front), 6);
        sendClick((Button) findViewById(R.id.air_xts_rear), 23);
        sendClick((Button) findViewById(R.id.dj_xts_air_win_minuts_btn), 12);
        sendClick((Button) findViewById(R.id.dj_xts_air_win_plus_btn), 11);
        if (DataCanbus.DATA[1000] == 1311000) {
            sendClick((Button) findViewById(R.id.air_xts_rearpower), 27);
            findViewById(R.id.air_xts_rearpower).setVisibility(0);
        }
    }

    private void sendClick(View v, final int cmd) {
        if (v != null) {
            v.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v2) {
                    Rzc_Gs3_AirControlAct.this.sendCmd(cmd);
                }
            });
        }
    }

    
    public void sendCmd(final int cmd) {
        DataCanbus.PROXY.cmd(1, new int[]{cmd, 1}, null, null);
        this.mHandler.postDelayed(new Runnable() { 
            @Override
            public void run() {
                DataCanbus.PROXY.cmd(1, new int[]{cmd}, null, null);
            }
        }, 200L);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AirHelper.disableAirWindowLocal(true);
        mIsFront = true;
        addUpdater();
    }

    @Override
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        mIsFront = false;
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
    }

    
    public void URearPower(boolean b) {
        if (((Button) findViewById(R.id.air_xts_rearpower)) != null) {
            ((Button) findViewById(R.id.air_xts_rearpower)).setBackgroundResource(b ? R.drawable.ic_xts_rear_light_p : R.drawable.ic_xts_rear_light_n);
        }
    }

    
    public void UAuto(boolean b) {
        if (((Button) findViewById(R.id.air_xts_auto)) != null) {
            ((Button) findViewById(R.id.air_xts_auto)).setBackgroundResource(b ? R.drawable.ic_xts_auto_p : R.drawable.ic_xts_auto_n);
        }
    }

    
    public void U3Zone(boolean b) {
        if (((Button) findViewById(R.id.air_xts_dual)) != null) {
            ((Button) findViewById(R.id.air_xts_dual)).setBackgroundResource(b ? R.drawable.ic_xts_dual_p : R.drawable.ic_xts_dual_n);
        }
    }

    
    public void UIon(boolean b) {
        if (((Button) findViewById(R.id.air_xts_ion)) != null) {
            ((Button) findViewById(R.id.air_xts_ion)).setBackgroundResource(b ? R.drawable.ic_xts_ion_p : R.drawable.ic_xts_ion_n);
        }
    }

    
    public void UTempLeft(int data) {
        String str;
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            switch (data) {
                case -3:
                    str = "HI";
                    break;
                case -2:
                    str = "LOW";
                    break;
                case -1:
                default:
                    str = (data / 100.0f) + "℃";
                    break;
                case 0:
                    str = "NO";
                    break;
            }
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText(str);
        }
    }

    
    public void UTempRight(int data) {
        String str;
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            switch (data) {
                case -3:
                    str = "HI";
                    break;
                case -2:
                    str = "LOW";
                    break;
                case -1:
                default:
                    str = (data / 100.0f) + "℃";
                    break;
                case 0:
                    str = "NO";
                    break;
            }
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText(str);
        }
    }

    
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[21];
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
        }
        if (((Button) findViewById(R.id.air_xts_power)) != null) {
            ((Button) findViewById(R.id.air_xts_power)).setBackgroundResource(level == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        }
    }

    
    public void mUpdateAirCycle() {
        int value = DataCanbus.DATA[12];
        if (((Button) findViewById(R.id.air_xts_cycle)) != null) {
            ((Button) findViewById(R.id.air_xts_cycle)).setBackgroundResource(value == 1 ? R.drawable.ic_xts_cycle_n : R.drawable.ic_xts_cycle_p);
        }
    }

    
    public void mUpdaterAirAC() {
        int value = DataCanbus.DATA[11];
        if (((Button) findViewById(R.id.air_xts_ac)) != null) {
            ((Button) findViewById(R.id.air_xts_ac)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    
    public void mUpdateAirFrontDefrost(int data) {
        this.bWin = data;
        int value = DataCanbus.DATA[65];
        if (((Button) findViewById(R.id.air_xts_front)) != null) {
            ((Button) findViewById(R.id.air_xts_front)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
        }
        UBlowMode();
    }

    
    public void mUpdateAirRearDefrost() {
        int value = DataCanbus.DATA[16];
        if (((Button) findViewById(R.id.air_xts_rear)) != null) {
            ((Button) findViewById(R.id.air_xts_rear)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
        }
    }

    
    public void mUpdaterAirPower() {
    }

    
    public void UBlowFoot(int data) {
        this.bFoot = data;
        UBlowMode();
    }

    
    public void UBlowUp(int i) {
        this.bBody = i;
        UBlowMode();
    }

    private void UBlowMode() {
        int mode = 0;
        if (this.bFoot == 1) {
            mode = 0 | 1;
        } else if (this.bFoot == 0) {
            mode = 0 & 254;
        }
        if (this.bBody == 1) {
            mode |= 2;
        } else if (this.bBody == 0) {
            mode &= 253;
        }
        if (this.bWin == 1) {
            mode |= 4;
        } else if (this.bWin == 0) {
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
}
