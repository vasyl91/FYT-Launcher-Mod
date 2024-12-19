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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Rzc_Gs8_AirControlAct extends Activity {
    public static boolean mIsFront = false;
    protected Handler mHandler;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.gs4.Rzc_Gs8_AirControlAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 2:
                case 35:
                    Rzc_Gs8_AirControlAct.this.UAuto();
                    break;
                case 3:
                    Rzc_Gs8_AirControlAct.this.mUpdateAirCycle();
                    break;
                case 4:
                    Rzc_Gs8_AirControlAct.this.mUpdateAirFrontDefrost(DataCanbus.DATA[updateCode]);
                    Rzc_Gs8_AirControlAct.this.UBlowMode();
                    break;
                case 5:
                    Rzc_Gs8_AirControlAct.this.mUpdateAirRearDefrost();
                    break;
                case 6:
                    Rzc_Gs8_AirControlAct.this.mUpdaterAirAC();
                    break;
                case 7:
                    Rzc_Gs8_AirControlAct.this.UTempLeft(DataCanbus.DATA[updateCode]);
                    break;
                case 9:
                case 10:
                case 33:
                case 34:
                    Rzc_Gs8_AirControlAct.this.UBlowMode();
                    break;
                case 12:
                case 36:
                    Rzc_Gs8_AirControlAct.this.mUpdaterAirWindLevel();
                    break;
                case 15:
                    Rzc_Gs8_AirControlAct.this.UTempRight(DataCanbus.DATA[updateCode]);
                    break;
                case 31:
                    Rzc_Gs8_AirControlAct.this.U3Zone(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 32:
                    Rzc_Gs8_AirControlAct.this.UAuto();
                    Rzc_Gs8_AirControlAct.this.mUpdaterAirWindLevel();
                    Rzc_Gs8_AirControlAct.this.UBlowMode();
                    Rzc_Gs8_AirControlAct.this.URearAuto(DataCanbus.DATA[updateCode] == 1);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_gs8_air_control_set);
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
        sendClick((Button) findViewById(R.id.air_xts_zone), 31);
        sendClick((Button) findViewById(R.id.air_xts_mode), 17);
        sendClick((Button) findViewById(R.id.air_xts_power), 0);
        sendClick((Button) findViewById(R.id.air_xts_ac), 1);
        sendClick((Button) findViewById(R.id.air_xts_front), 6);
        sendClick((Button) findViewById(R.id.air_xts_rear), 23);
        sendClick((Button) findViewById(R.id.dj_xts_air_win_minuts_btn), 12);
        sendClick((Button) findViewById(R.id.dj_xts_air_win_plus_btn), 11);
        sendClick((Button) findViewById(R.id.air_xts_rear_light), 27);
    }

    private void sendClick(View v, final int cmd) {
        if (v != null) {
            v.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.gs4.Rzc_Gs8_AirControlAct.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v2) {
                    if (cmd == 255) {
                        return;
                    }
                    Rzc_Gs8_AirControlAct.this.sendCmd(cmd);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCmd(final int cmd) {
        DataCanbus.PROXY.cmd(1, new int[]{cmd, 1}, null, null);
        this.mHandler.postDelayed(new Runnable() { // from class: com.syu.carinfo.rzc.gs4.Rzc_Gs8_AirControlAct.3
            @Override // java.lang.Runnable
            public void run() {
                DataCanbus.PROXY.cmd(1, new int[]{cmd}, null, null);
            }
        }, 200L);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        AirHelper.disableAirWindowLocal(true);
        mIsFront = true;
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        mIsFront = false;
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void URearAuto(boolean b) {
        if (((Button) findViewById(R.id.air_xts_rear_light)) != null) {
            ((Button) findViewById(R.id.air_xts_rear_light)).setBackgroundResource(b ? R.drawable.ic_xts_rear_light_p : R.drawable.ic_xts_rear_light_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[12];
        if (DataCanbus.DATA[32] == 1) {
            int level2 = DataCanbus.DATA[36];
            if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null) {
                ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level2).toString());
                ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setTextColor(-256);
            }
            if (((Button) findViewById(R.id.air_xts_power)) != null) {
                ((Button) findViewById(R.id.air_xts_power)).setBackgroundResource(level2 == 0 ? R.drawable.ic_xts_rearpower_n : R.drawable.ic_xts_rearpower_p);
                return;
            }
            return;
        }
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setTextColor(-1);
        }
        if (((Button) findViewById(R.id.air_xts_power)) != null) {
            ((Button) findViewById(R.id.air_xts_power)).setBackgroundResource(level == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UBlowMode() {
        int bBody = DataCanbus.DATA[10];
        int bFoot = DataCanbus.DATA[9];
        int bWin = DataCanbus.DATA[4];
        if (DataCanbus.DATA[32] == 1) {
            bWin = 0;
            bBody = DataCanbus.DATA[34];
            bFoot = DataCanbus.DATA[33];
        }
        int mode = 0;
        if (bFoot == 1) {
            mode = 0 | 1;
        } else if (bFoot == 0) {
            mode = 0 & 254;
        }
        if (bBody == 1) {
            mode |= 2;
        } else if (bBody == 0) {
            mode &= 253;
        }
        if (bWin == 1) {
            mode |= 4;
        } else if (bWin == 0) {
            mode &= 251;
        }
        if (DataCanbus.DATA[32] == 1) {
            switch (mode) {
                case 0:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_rearmode_null);
                    break;
                case 1:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_rearmode_foot);
                    break;
                case 2:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_rearmode_body);
                    break;
                case 3:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_rearmode_foot_body);
                    break;
                default:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_rearmode_null);
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
    public void UAuto() {
        int auto = DataCanbus.DATA[2];
        if (DataCanbus.DATA[32] == 1) {
            int auto2 = DataCanbus.DATA[35];
            ((Button) findViewById(R.id.air_xts_auto)).setBackgroundResource(auto2 == 1 ? R.drawable.ic_xts_rearauto_p : R.drawable.ic_xts_rearauto_n);
        } else {
            ((Button) findViewById(R.id.air_xts_auto)).setBackgroundResource(auto == 1 ? R.drawable.ic_xts_auto_p : R.drawable.ic_xts_auto_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U3Zone(boolean b) {
        if (((Button) findViewById(R.id.air_xts_zone)) != null) {
            ((Button) findViewById(R.id.air_xts_zone)).setBackgroundResource(b ? R.drawable.ic_xts_zone_p : R.drawable.ic_xts_zone_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirCycle() {
        int value = DataCanbus.DATA[3];
        if (((Button) findViewById(R.id.air_xts_cycle)) != null) {
            ((Button) findViewById(R.id.air_xts_cycle)).setBackgroundResource(value == 1 ? R.drawable.ic_xts_cycle_n : R.drawable.ic_xts_cycle_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirAC() {
        int value = DataCanbus.DATA[6];
        if (((Button) findViewById(R.id.air_xts_ac)) != null) {
            ((Button) findViewById(R.id.air_xts_ac)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirFrontDefrost(int data) {
        int value = DataCanbus.DATA[4];
        if (((Button) findViewById(R.id.air_xts_front)) != null) {
            ((Button) findViewById(R.id.air_xts_front)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirRearDefrost() {
        int value = DataCanbus.DATA[5];
        if (((Button) findViewById(R.id.air_xts_rear)) != null) {
            ((Button) findViewById(R.id.air_xts_rear)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
        }
    }
}
