package com.syu.carinfo.mengdiou;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class V11MDOAirControlActi extends BaseActivity {
    public static V11MDOAirControlActi mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 1:
                    V11MDOAirControlActi.this.mUpdataAirAuto();
                    break;
                case 2:
                    V11MDOAirControlActi.this.mUpdataRecycle();
                    break;
                case 3:
                    V11MDOAirControlActi.this.mUpdataFrontDeforst();
                    break;
                case 4:
                    V11MDOAirControlActi.this.mUpdataAc();
                    break;
                case 5:
                    V11MDOAirControlActi.this.mUpataTempLeft();
                    break;
                case 6:
                    V11MDOAirControlActi.this.mUpdataWinBody();
                    break;
                case 7:
                    V11MDOAirControlActi.this.mUpdataFoot();
                    break;
                case 8:
                    V11MDOAirControlActi.this.mUpdataWinUp();
                    break;
                case 9:
                    V11MDOAirControlActi.this.mUpdataWindLevel();
                    break;
                case 10:
                    V11MDOAirControlActi.this.mUpdataDual();
                    break;
                case 11:
                    V11MDOAirControlActi.this.mUpataTempRight();
                    break;
                case 12:
                    V11MDOAirControlActi.this.mUpdaterPower();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ////setContentView(R.layout.layout_0223_wc_mdo_2011_control);
        initView();
        mInstance = this;
    }

    private void initView() {
        ((Button) findViewById(R.id.air_xts_auto)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View view) {
                DataCanbus.PROXY.cmd(13, null, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_front)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(1, null, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_air_temp_left_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(2, null, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_air_temp_left_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(3, null, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_air_temp_right_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(11, null, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_air_temp_right_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(12, null, null, null);
            }
        });
        ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(5, null, null, null);
            }
        });
        ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(4, null, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_cycle)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(6, null, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_power)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(7, null, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_ac)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(14, null, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_dual)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(15, null, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_mode_win)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(10, null, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_mode_foot)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(8, null, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_mode_body)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(9, null, null, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
        AirHelper.disableAirWindowLocal(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdataAirAuto() {
        int value = DataCanbus.DATA[1];
        if (((Button) findViewById(R.id.air_xts_auto)) != null) {
            ((Button) findViewById(R.id.air_xts_auto)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
        }
    }

    
    public void mUpdataFrontDeforst() {
        int value = DataCanbus.DATA[3];
        if (((Button) findViewById(R.id.air_xts_front)) != null) {
            ((Button) findViewById(R.id.air_xts_front)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_front_n : R.drawable.ic_xts_front_p);
        }
    }

    
    public void mUpataTempLeft() {
        int temp = DataCanbus.DATA[5];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("NO");
                return;
            }
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
            } else if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf((temp / 2.0f) - 40.0f) + "℃");
            }
        }
    }

    
    public void mUpdataWinUp() {
        int value = DataCanbus.DATA[8];
        if (((Button) findViewById(R.id.air_xts_mode_win)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_win)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_win_n : R.drawable.ic_xts_mode_win_p);
        }
    }

    
    public void mUpdataWinBody() {
        int value = DataCanbus.DATA[6];
        if (((Button) findViewById(R.id.air_xts_mode_body)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_body)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
        }
    }

    
    public void mUpdataFoot() {
        int value = DataCanbus.DATA[7];
        if (((Button) findViewById(R.id.air_xts_mode_foot)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_foot)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
        }
    }

    
    public void mUpdaterPower() {
        int value = DataCanbus.DATA[12];
        if (((Button) findViewById(R.id.air_xts_power)) != null) {
            ((Button) findViewById(R.id.air_xts_power)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
        }
    }

    
    public void mUpdataRecycle() {
        int value = DataCanbus.DATA[2];
        if (((Button) findViewById(R.id.air_xts_cycle)) != null) {
            ((Button) findViewById(R.id.air_xts_cycle)).setBackgroundResource(value != 0 ? R.drawable.ic_xts_cycle_p : R.drawable.ic_xts_cycle_n);
        }
    }

    
    public void mUpdataAc() {
        int value = DataCanbus.DATA[4];
        if (((Button) findViewById(R.id.air_xts_ac)) != null) {
            ((Button) findViewById(R.id.air_xts_ac)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    
    public void mUpdataDual() {
        int value = DataCanbus.DATA[10];
        if (((Button) findViewById(R.id.air_xts_dual)) != null) {
            ((Button) findViewById(R.id.air_xts_dual)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_dual_n : R.drawable.ic_xts_dual_p);
        }
    }

    
    public void mUpdataWindLevel() {
        int value = DataCanbus.DATA[9];
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void mUpataTempRight() {
        int temp = DataCanbus.DATA[11];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("NO");
                return;
            }
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
            } else if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
            } else {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf((temp / 2.0f) - 40.0f) + "℃");
            }
        }
    }
}
