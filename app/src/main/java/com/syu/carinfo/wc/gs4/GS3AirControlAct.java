package com.syu.carinfo.wc.gs4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;
import com.syu.util.HandlerUI;

public class GS3AirControlAct extends BaseActivity {
    public static GS3AirControlAct mInstance;
    public static boolean mIsFront = false;
    boolean auto;
    boolean body;
    boolean foot;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 26:
                    GS3AirControlAct.this.mUpdaterAirAutoOn();
                    break;
                case 27:
                    GS3AirControlAct.this.mUpdaterAirCycle();
                    break;
                case 28:
                    GS3AirControlAct.this.mUpdaterAirFrontDefrost();
                    break;
                case 29:
                    GS3AirControlAct.this.mUpdaterAirRearDefrost();
                    break;
                case 30:
                    GS3AirControlAct.this.mUpdaterAirHybirdAc();
                    break;
                case 31:
                    GS3AirControlAct.this.mUpdaterAirTempLeft();
                    break;
                case 32:
                    GS3AirControlAct.this.uModeBody(DataCanbus.DATA[updateCode]);
                    break;
                case 33:
                    GS3AirControlAct.this.uModeFoot(DataCanbus.DATA[updateCode]);
                    break;
                case 34:
                    GS3AirControlAct.this.uModeUp(DataCanbus.DATA[updateCode]);
                    break;
                case 35:
                    GS3AirControlAct.this.mUpdaterAirWindLevel();
                    break;
                case 36:
                    GS3AirControlAct.this.mUpdaterAirSeatHeatLeft();
                    break;
                case 37:
                    GS3AirControlAct.this.mUpdaterAirSeatHeatRight();
                    break;
                case 38:
                    GS3AirControlAct.this.mUpdaterAirTempRightL();
                    break;
                case 39:
                    GS3AirControlAct.this.mUpdaterAirPower();
                    break;
                case 40:
                    GS3AirControlAct.this.uModeAuto(DataCanbus.DATA[updateCode]);
                    break;
                case 43:
                    GS3AirControlAct.this.mUpdaterAirCleanFlower();
                    break;
            }
        }
    };
    int mode = 0;
    boolean win;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0289_wc_chuanqi_gs3_air_control);
        mInstance = this;
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.btn_air_temp_left_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{14, 1}, null, null);
                HandlerUI.getInstance().postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(4, new int[]{14}, null, null);
                    }
                }, 100L);
            }
        });
        ((Button) findViewById(R.id.btn_air_temp_left_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{13, 1}, null, null);
                HandlerUI.getInstance().postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(4, new int[]{13}, null, null);
                    }
                }, 100L);
            }
        });
        ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{12, 1}, null, null);
                HandlerUI.getInstance().postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(4, new int[]{12}, null, null);
                    }
                }, 100L);
            }
        });
        ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{11, 1}, null, null);
                HandlerUI.getInstance().postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(4, new int[]{11}, null, null);
                    }
                }, 100L);
            }
        });
        ((Button) findViewById(R.id.btn_air_temp_right_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{16, 1}, null, null);
                HandlerUI.getInstance().postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(4, new int[]{16}, null, null);
                    }
                }, 100L);
            }
        });
        ((Button) findViewById(R.id.btn_air_temp_right_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{15, 1}, null, null);
                HandlerUI.getInstance().postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(4, new int[]{15}, null, null);
                    }
                }, 100L);
            }
        });
        ((Button) findViewById(R.id.air_xts_auto)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{4, 1}, null, null);
                HandlerUI.getInstance().postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(4, new int[]{4}, null, null);
                    }
                }, 100L);
            }
        });
        ((Button) findViewById(R.id.air_xts_ac)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{2, 1}, null, null);
                HandlerUI.getInstance().postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(4, new int[]{2}, null, null);
                    }
                }, 100L);
            }
        });
        ((Button) findViewById(R.id.air_xts_mode)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{21, 1}, null, null);
                HandlerUI.getInstance().postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(4, new int[]{21}, null, null);
                    }
                }, 100L);
            }
        });
        ((Button) findViewById(R.id.air_xts_front)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{5, 1}, null, null);
                HandlerUI.getInstance().postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(4, new int[]{5}, null, null);
                    }
                }, 100L);
            }
        });
        ((Button) findViewById(R.id.air_xts_rear)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{6, 1}, null, null);
                HandlerUI.getInstance().postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(4, new int[]{6}, null, null);
                    }
                }, 100L);
            }
        });
        ((Button) findViewById(R.id.air_xts_clear)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{25, 1}, null, null);
                HandlerUI.getInstance().postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(4, new int[]{25}, null, null);
                    }
                }, 100L);
            }
        });
        ((Button) findViewById(R.id.air_xts_seathot_left)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{17, 1}, null, null);
                HandlerUI.getInstance().postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(4, new int[]{17}, null, null);
                    }
                }, 100L);
            }
        });
        ((Button) findViewById(R.id.air_xts_seathot_right)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{18, 1}, null, null);
                HandlerUI.getInstance().postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(4, new int[]{18}, null, null);
                    }
                }, 100L);
            }
        });
        ((Button) findViewById(R.id.air_xts_power)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{1, 1}, null, null);
                HandlerUI.getInstance().postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                    }
                }, 100L);
            }
        });
        ((Button) findViewById(R.id.air_xts_cycle)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{7, 1}, null, null);
                HandlerUI.getInstance().postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(4, new int[]{7}, null, null);
                    }
                }, 100L);
            }
        });
    }

    
    public void mUpdaterAirTempRightL() {
        int temp = DataCanbus.DATA[38];
        if (temp == -2) {
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
        } else if (temp == -3) {
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
        } else {
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 10.0f) + "℃");
        }
    }

    
    public void mUpdaterAirTempLeft() {
        int temp = DataCanbus.DATA[31];
        if (temp == -2) {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
        } else if (temp == -3) {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
        } else {
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 10.0f) + "℃");
        }
    }

    
    public void mUpdaterAirWindLevel() {
        int temp = DataCanbus.DATA[35];
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(temp).toString());
    }

    
    public void mUpdaterAirAutoOn() {
        int value = DataCanbus.DATA[26];
        if (((Button) findViewById(R.id.air_xts_auto)) != null) {
            ((Button) findViewById(R.id.air_xts_auto)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
        }
    }

    
    public void mUpdaterAirHybirdAc() {
        int value = DataCanbus.DATA[30];
        if (((Button) findViewById(R.id.air_xts_ac)) != null) {
            ((Button) findViewById(R.id.air_xts_ac)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    
    public void mUpdaterAirFrontDefrost() {
        int value = DataCanbus.DATA[28];
        if (((Button) findViewById(R.id.air_xts_front)) != null) {
            ((Button) findViewById(R.id.air_xts_front)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
        }
    }

    
    public void mUpdaterAirRearDefrost() {
        int value = DataCanbus.DATA[29];
        if (((Button) findViewById(R.id.air_xts_rear)) != null) {
            ((Button) findViewById(R.id.air_xts_rear)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_rear_n : R.drawable.ic_xts_rear_p);
        }
    }

    
    public void mUpdaterAirCleanFlower() {
        int value = DataCanbus.DATA[43];
        if (((Button) findViewById(R.id.air_xts_clear)) != null) {
            ((Button) findViewById(R.id.air_xts_clear)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_clear_air_n : R.drawable.ic_xts_clear_air_p);
        }
    }

    
    public void mUpdaterAirSeatHeatLeft() {
        int value = DataCanbus.DATA[36];
        if (((Button) findViewById(R.id.air_xts_seathot_left)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level0);
            }
            if (value == 1) {
                ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level1);
            }
            if (value == 2) {
                ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level2);
            }
            if (value == 3) {
                ((Button) findViewById(R.id.air_xts_seathot_left)).setBackgroundResource(R.drawable.ic_xts_seathot_left_level3);
            }
        }
    }

    
    public void mUpdaterAirSeatHeatRight() {
        int value = DataCanbus.DATA[37];
        if (((Button) findViewById(R.id.air_xts_seathot_right)) != null) {
            if (value == 0) {
                ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level0);
            }
            if (value == 1) {
                ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level1);
            }
            if (value == 2) {
                ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level2);
            }
            if (value == 3) {
                ((Button) findViewById(R.id.air_xts_seathot_right)).setBackgroundResource(R.drawable.ic_xts_seathot_right_level3);
            }
        }
    }

    
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[39];
        if (((Button) findViewById(R.id.air_xts_power)) != null) {
            ((Button) findViewById(R.id.air_xts_power)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        }
    }

    
    public void mUpdaterAirCycle() {
        int value = DataCanbus.DATA[27];
        if (((Button) findViewById(R.id.air_xts_cycle)) != null) {
            ((Button) findViewById(R.id.air_xts_cycle)).setBackgroundResource(value == 1 ? R.drawable.ic_xts_cycle_p : R.drawable.ic_xts_cycle_n);
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
        AirHelper.disableAirWindowLocal(true);
    }

    public int getMode() {
        this.mode = 0;
        this.mode = (this.foot ? 1 : 0) | this.mode;
        this.mode = (this.body ? 2 : 0) | this.mode;
        this.mode |= this.win ? 4 : 0;
        return this.mode;
    }

    public void uMode(int mode) {
        if (((Button) findViewById(R.id.air_xts_mode)) != null) {
            int d = R.drawable.ic_xts_mode_null;
            switch (mode) {
                case 1:
                    d = R.drawable.ic_xts_mode_foot;
                    break;
                case 2:
                    d = R.drawable.ic_xts_mode_body;
                    break;
                case 3:
                    d = R.drawable.ic_xts_mode_foot_body;
                    break;
                case 4:
                    d = R.drawable.ic_xts_mode_win;
                    break;
                case 5:
                    d = R.drawable.ic_xts_mode_foot_win;
                    break;
                case 6:
                    d = R.drawable.ic_xts_mode_body_win;
                    break;
                case 7:
                    d = R.drawable.ic_xts_mode_foot_body_win;
                    break;
            }
            ((Button) findViewById(R.id.air_xts_mode)).setBackgroundResource(d);
        }
    }

    protected void uModeFoot(int i) {
        this.foot = i == 1;
        uMode(getMode());
    }

    protected void uModeUp(int i) {
        this.win = i == 1;
        uMode(getMode());
    }

    protected void uModeBody(int i) {
        this.body = i == 1;
        uMode(getMode());
    }

    protected void uModeAuto(int i) {
        this.auto = i == 1;
        uMode(getMode());
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
        AirHelper.disableAirWindowLocal(false);
    }
}
