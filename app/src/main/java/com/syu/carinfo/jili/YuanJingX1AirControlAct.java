package com.syu.carinfo.jili;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;
import com.syu.util.HandlerUI;

public class YuanJingX1AirControlAct extends Activity {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                    YuanJingX1AirControlAct.this.mUpdaterAirPower();
                    break;
                case 11:
                    YuanJingX1AirControlAct.this.mUpdaterAirAC();
                    break;
                case 12:
                    YuanJingX1AirControlAct.this.mUpdateAirCycle();
                    break;
                case 13:
                    YuanJingX1AirControlAct.this.mUpdaterAuto();
                    break;
                case 16:
                    YuanJingX1AirControlAct.this.mUpdateAirRearDefrost();
                    break;
                case 21:
                    YuanJingX1AirControlAct.this.mUpdaterAirWindLevel();
                    break;
                case 27:
                    YuanJingX1AirControlAct.this.UTempLeft(DataCanbus.DATA[updateCode]);
                    break;
                case 29:
                    if (((Button) YuanJingX1AirControlAct.this.findViewById(R.id.air_xts_seathot_left)) != null) {
                        int i = R.drawable.ic_xts_seathot_left_level0;
                        if (value == 1) {
                            i = R.drawable.ic_xts_seathot_left_level1;
                        } else if (value == 2) {
                            i = R.drawable.ic_xts_seathot_left_level2;
                        } else if (value == 3) {
                            i = R.drawable.ic_xts_seathot_left_level3;
                        }
                        ((Button) YuanJingX1AirControlAct.this.findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(i);
                        break;
                    }
                case 30:
                    if (((Button) YuanJingX1AirControlAct.this.findViewById(R.id.air_xts_seathot_right)) != null) {
                        int i2 = R.drawable.ic_xts_seathot_right_level0;
                        if (value == 1) {
                            i2 = R.drawable.ic_xts_seathot_right_level1;
                        } else if (value == 2) {
                            i2 = R.drawable.ic_xts_seathot_right_level2;
                        } else if (value == 3) {
                            i2 = R.drawable.ic_xts_seathot_right_level3;
                        }
                        ((Button) YuanJingX1AirControlAct.this.findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(i2);
                        break;
                    }
                case 65:
                    YuanJingX1AirControlAct.this.mUpdateAirFrontDefrost(DataCanbus.DATA[updateCode]);
                    break;
                case 77:
                    YuanJingX1AirControlAct.this.UBlowMode_new(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_139_rzc_yuanjing_suv_air_control_set);
        init();
    }

    private void init() {
        sendClick((Button) findViewById(R.id.air_xts_power), 0);
        sendClick((Button) findViewById(R.id.air_xts_ac), 1);
        sendClick((Button) findViewById(R.id.air_xts_front), 3);
        sendClick((Button) findViewById(R.id.air_xts_rear), 4);
        sendClick((Button) findViewById(R.id.dj_xts_air_win_plus_btn), 5);
        sendClick((Button) findViewById(R.id.dj_xts_air_win_minuts_btn), 6);
        sendClick((Button) findViewById(R.id.btn_air_temp_left_plus), 7);
        sendClick((Button) findViewById(R.id.btn_air_temp_left_minus), 8);
        sendClick((Button) findViewById(R.id.air_xts_mode_munits), 9);
        sendClick((Button) findViewById(R.id.air_xts_mode_plus), 9);
        sendClick((Button) findViewById(R.id.air_xts_cycle), 10);
        sendClick((Button) findViewById(R.id.btn_air_temp_right_plus), 7);
        sendClick((Button) findViewById(R.id.btn_air_temp_right_minus), 8);
        sendClick((Button) findViewById(R.id.air_xts_auto), 13);
        sendClick((Button) findViewById(R.id.air_xts_seathot_left), 15);
        sendClick((Button) findViewById(R.id.air_xts_seathot_right), 19);
    }

    private void sendClick(View v, final int cmd) {
        if (v != null) {
            v.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v2) {
                    YuanJingX1AirControlAct.this.sendCmd(cmd);
                }
            });
        }
    }

    
    public void sendCmd(int cmd) {
        int b0 = 0;
        int b1 = 0;
        int b2 = 0;
        int b3 = 0;
        int b4 = 0;
        int b5 = 0;
        switch (cmd) {
            case 0:
                b0 = 128;
                break;
            case 1:
                b0 = 2;
                break;
            case 2:
                b0 = 1;
                break;
            case 3:
                b0 = 16;
                break;
            case 4:
                b1 = 4;
                break;
            case 5:
                int i = DataCanbus.DATA[21] + 1;
                if (i > 8) {
                    i = 8;
                }
                b1 = i << 4;
                break;
            case 6:
                int j = DataCanbus.DATA[21] - 1;
                if (j < 0) {
                    j = 0;
                }
                b1 = j << 4;
                break;
            case 7:
                b3 = 2;
                break;
            case 8:
                b3 = 1;
                break;
            case 9:
                b0 = 64;
                break;
            case 10:
                b2 = 1;
                break;
            case 11:
                b4 = 2;
                break;
            case 12:
                b4 = 1;
                break;
            case 13:
                b0 = 32;
                break;
            case 14:
                b1 = 8;
                break;
            case 15:
                b5 = 1;
                break;
            case 16:
                b5 = 128;
                break;
            case 17:
                b5 = 64;
                break;
            case 18:
                b5 = 32;
                break;
            case 19:
                b5 = 2;
                break;
        }
        DataCanbus.PROXY.cmd(0, new int[]{b0, b1, b2, b3, b4, b5}, null, null);
        HandlerUI.getInstance().postDelayed(new Runnable() { 
            @Override
            public void run() {
                DataCanbus.PROXY.cmd(0, new int[6], null, null);
            }
        }, 100L);
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
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
    }

    
    public void UTempLeft(int data) {
        int data2;
        String str;
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (data == -2) {
                str = "LOW";
            } else if (data == -3) {
                str = "HI";
            } else {
                if (data >= 32 && data <= 34) {
                    data2 = ((data - 32) * 5) + 160;
                } else {
                    data2 = (data * 5) + 170;
                }
                str = String.valueOf(data2 / 10) + "." + (data2 % 10) + "℃";
            }
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText(str);
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText(str);
        }
    }

    
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[21];
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
        }
    }

    
    public void mUpdateAirCycle() {
        int value = DataCanbus.DATA[12];
        if (((Button) findViewById(R.id.air_xts_cycle)) != null) {
            ((Button) findViewById(R.id.air_xts_cycle)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_cycle_n : R.drawable.ic_xts_cycle_p);
        }
    }

    
    public void mUpdaterAirAC() {
        int value = DataCanbus.DATA[11];
        if (((Button) findViewById(R.id.air_xts_ac)) != null) {
            ((Button) findViewById(R.id.air_xts_ac)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    
    public void mUpdateAirFrontDefrost(int data) {
        int value = DataCanbus.DATA[65];
        if (((Button) findViewById(R.id.air_xts_front)) != null) {
            ((Button) findViewById(R.id.air_xts_front)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
        }
    }

    
    public void mUpdateAirRearDefrost() {
        int value = DataCanbus.DATA[16];
        if (((Button) findViewById(R.id.air_xts_rear)) != null) {
            ((Button) findViewById(R.id.air_xts_rear)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
        }
    }

    
    public void mUpdaterAuto() {
        int value = DataCanbus.DATA[13];
        if (((Button) findViewById(R.id.air_xts_auto)) != null) {
            ((Button) findViewById(R.id.air_xts_auto)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
        }
    }

    
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[10];
        if (((Button) findViewById(R.id.air_xts_power)) != null) {
            ((Button) findViewById(R.id.air_xts_power)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        }
    }

    
    public void UBlowMode_new(int i_mode) {
        if (LauncherApplication.getConfiguration() == 1) {
            switch (i_mode) {
                case 0:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_null);
                    break;
                case 1:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_body);
                    break;
                case 2:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_foot_body);
                    break;
                case 3:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_foot);
                    break;
                case 4:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_foot_win);
                    break;
                case 5:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_win);
                    break;
                case 6:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_body_win);
                    break;
                case 7:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_all);
                    break;
                default:
                    findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_1080_mode_null);
                    break;
            }
            return;
        }
        int idDrawable = R.drawable.ic_xts_mode_null;
        switch (i_mode) {
            case 1:
                idDrawable = R.drawable.ic_xts_mode_body;
                break;
            case 2:
                idDrawable = R.drawable.ic_xts_mode_foot_body;
                break;
            case 3:
                idDrawable = R.drawable.ic_xts_mode_foot;
                break;
            case 4:
                idDrawable = R.drawable.ic_xts_mode_foot_win;
                break;
            case 5:
                idDrawable = R.drawable.ic_xts_mode_win;
                break;
        }
        if (((Button) findViewById(R.id.air_xts_mode)) != null && idDrawable != -1) {
            ((Button) findViewById(R.id.air_xts_mode)).setBackgroundResource(idDrawable);
        }
    }
}
