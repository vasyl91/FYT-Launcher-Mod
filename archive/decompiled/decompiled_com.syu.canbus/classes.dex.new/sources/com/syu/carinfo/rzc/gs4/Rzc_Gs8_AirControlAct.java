package com.syu.carinfo.rzc.gs4;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Rzc_Gs8_AirControlAct extends Activity {
    public static boolean mIsFront = false;
    protected Handler mHandler;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.gs4.Rzc_Gs8_AirControlAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 11:
                    Rzc_Gs8_AirControlAct.this.mUpdaterAirAC();
                    break;
                case 12:
                    Rzc_Gs8_AirControlAct.this.mUpdateAirCycle();
                    break;
                case 13:
                case 43:
                    Rzc_Gs8_AirControlAct.this.UAuto();
                    break;
                case 16:
                    Rzc_Gs8_AirControlAct.this.mUpdateAirRearDefrost();
                    break;
                case 18:
                case 20:
                case 46:
                case 47:
                    Rzc_Gs8_AirControlAct.this.UBlowMode();
                    break;
                case 21:
                case 44:
                    Rzc_Gs8_AirControlAct.this.mUpdaterAirWindLevel();
                    break;
                case 27:
                    if (DataCanbus.DATA[38] == 0) {
                        Rzc_Gs8_AirControlAct.this.UTempLeft(DataCanbus.DATA[updateCode]);
                    }
                    break;
                case 28:
                    if (DataCanbus.DATA[38] == 0) {
                        Rzc_Gs8_AirControlAct.this.UTempRight(DataCanbus.DATA[updateCode]);
                    }
                    break;
                case 38:
                    Rzc_Gs8_AirControlAct.this.UAuto();
                    Rzc_Gs8_AirControlAct.this.mUpdaterAirWindLevel();
                    Rzc_Gs8_AirControlAct.this.UBlowMode();
                    Rzc_Gs8_AirControlAct.this.URearAuto(DataCanbus.DATA[updateCode] == 1);
                    if (DataCanbus.DATA[updateCode] == 1) {
                        Rzc_Gs8_AirControlAct.this.UTempLeft(DataCanbus.DATA[40]);
                        Rzc_Gs8_AirControlAct.this.UTempRight(DataCanbus.DATA[40]);
                    } else {
                        Rzc_Gs8_AirControlAct.this.UTempLeft(DataCanbus.DATA[27]);
                        Rzc_Gs8_AirControlAct.this.UTempRight(DataCanbus.DATA[28]);
                    }
                    break;
                case 40:
                    if (DataCanbus.DATA[38] == 1) {
                        Rzc_Gs8_AirControlAct.this.UTempLeft(DataCanbus.DATA[updateCode]);
                        Rzc_Gs8_AirControlAct.this.UTempRight(DataCanbus.DATA[updateCode]);
                    }
                    break;
                case 57:
                    Rzc_Gs8_AirControlAct.this.U3Zone(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 65:
                    Rzc_Gs8_AirControlAct.this.mUpdateAirFrontDefrost(DataCanbus.DATA[updateCode]);
                    Rzc_Gs8_AirControlAct.this.UBlowMode();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mHandler = new Handler(Looper.getMainLooper());
        Configuration config = getResources().getConfiguration();
        int smallestScreenWidth = config.smallestScreenWidthDp;
        Log.v("zed", " 111 TheApp.getScreenWidth() == " + TheApp.getScreenWidth() + "  TheApp.getScreenHeight() = " + TheApp.getScreenHeight() + "  smallestScreenWidth = " + smallestScreenWidth);
        if (TheApp.getScreenWidth() == 2000 && TheApp.getScreenHeight() == 1084 && smallestScreenWidth == 1200) {
            setContentView(R.layout.layout_rzc_gs8_air_control_set_txz);
        } else {
            setContentView(R.layout.layout_rzc_gs8_air_control_set);
        }
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
                    if (cmd != 255) {
                        if (DataCanbus.DATA[38] == 1) {
                            switch (cmd) {
                                case 13:
                                    Rzc_Gs8_AirControlAct.this.sendCmd(28);
                                    break;
                                case 14:
                                    Rzc_Gs8_AirControlAct.this.sendCmd(29);
                                    break;
                                case 15:
                                    Rzc_Gs8_AirControlAct.this.sendCmd(28);
                                    break;
                                case 16:
                                    Rzc_Gs8_AirControlAct.this.sendCmd(29);
                                    break;
                                default:
                                    Rzc_Gs8_AirControlAct.this.sendCmd(cmd);
                                    break;
                            }
                            return;
                        }
                        Rzc_Gs8_AirControlAct.this.sendCmd(cmd);
                    }
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
                DataCanbus.PROXY.cmd(1, new int[]{cmd, 0}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void URearAuto(boolean b) {
        if (((Button) findViewById(R.id.air_xts_rear_light)) != null) {
            ((Button) findViewById(R.id.air_xts_rear_light)).setBackgroundResource(b ? R.drawable.ic_xts_rear_light_p : R.drawable.ic_xts_rear_light_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[21];
        if (DataCanbus.DATA[38] == 1) {
            int level2 = DataCanbus.DATA[44];
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
        int bBody = DataCanbus.DATA[18];
        int bFoot = DataCanbus.DATA[20];
        int bWin = DataCanbus.DATA[65];
        if (DataCanbus.DATA[38] == 1) {
            bWin = 0;
            bBody = DataCanbus.DATA[46];
            bFoot = DataCanbus.DATA[47];
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
        if (DataCanbus.DATA[38] == 1) {
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
        int auto = DataCanbus.DATA[13];
        if (DataCanbus.DATA[38] == 1) {
            int auto2 = DataCanbus.DATA[43];
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
                    str = "--";
                    break;
                case 0:
                    str = "NO";
                    break;
                default:
                    str = (data / 100.0f) + "℃";
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
                    str = "--";
                    break;
                case 0:
                    str = "NO";
                    break;
                default:
                    str = (data / 100.0f) + "℃";
                    break;
            }
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirCycle() {
        int value = DataCanbus.DATA[12];
        if (((Button) findViewById(R.id.air_xts_cycle)) != null) {
            ((Button) findViewById(R.id.air_xts_cycle)).setBackgroundResource(value == 1 ? R.drawable.ic_xts_cycle_n : R.drawable.ic_xts_cycle_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirAC() {
        int value = DataCanbus.DATA[11];
        if (((Button) findViewById(R.id.air_xts_ac)) != null) {
            ((Button) findViewById(R.id.air_xts_ac)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirFrontDefrost(int data) {
        int value = DataCanbus.DATA[65];
        if (((Button) findViewById(R.id.air_xts_front)) != null) {
            ((Button) findViewById(R.id.air_xts_front)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirRearDefrost() {
        int value = DataCanbus.DATA[16];
        if (((Button) findViewById(R.id.air_xts_rear)) != null) {
            ((Button) findViewById(R.id.air_xts_rear)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
        }
    }
}
