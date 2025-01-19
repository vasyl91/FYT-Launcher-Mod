package com.syu.carinfo.dasauto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class TuRui_AirActi extends BaseActivity {
    public static TuRui_AirActi mInstance;
    public static boolean mIsFront = false;
    private View.OnClickListener mClick = new View.OnClickListener() { 
        @Override
        public void onClick(View v) {
            //
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    TuRui_AirActi.this.uPower(DataCanbus.DATA[updateCode]);
                    break;
                case 13:
                case 49:
                    TuRui_AirActi.this.uAuto();
                    break;
                case 17:
                    TuRui_AirActi.this.uFrontHot(DataCanbus.DATA[updateCode]);
                    break;
                case 18:
                    TuRui_AirActi.this.uBlowWin(DataCanbus.DATA[updateCode]);
                    break;
                case 19:
                    TuRui_AirActi.this.uBlowBody(DataCanbus.DATA[updateCode]);
                    break;
                case 20:
                    TuRui_AirActi.this.uBlowFoot(DataCanbus.DATA[updateCode]);
                    break;
                case 21:
                    TuRui_AirActi.this.uWindLevel(DataCanbus.DATA[updateCode]);
                    break;
                case 27:
                    TuRui_AirActi.this.uLTemp(DataCanbus.DATA[updateCode] & 255);
                    break;
                case 28:
                    TuRui_AirActi.this.uRTemp(DataCanbus.DATA[updateCode] & 255);
                    break;
                case 36:
                    TuRui_AirActi.this.uCycleAuto(DataCanbus.DATA[updateCode]);
                    break;
                case 66:
                    TuRui_AirActi.this.uSteerHot(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0270_wc_turui_air_control);
        init();
        AirHelper.disableAirWindowLocal(true);
        mInstance = this;
    }

    @Override
    public void init() {
        setOnClick((Button) findViewById(R.id.btn_air_temp_left_plus));
        setOnClick((Button) findViewById(R.id.btn_air_temp_left_minus));
        setOnClick((Button) findViewById(R.id.btn_air_temp_right_minus));
        setOnClick((Button) findViewById(R.id.btn_air_temp_right_plus));
        setOnClick((Button) findViewById(R.id.dj_xts_air_win_minuts_btn));
        setOnClick((Button) findViewById(R.id.dj_xts_air_win_plus_btn));
        setOnClick((Button) findViewById(R.id.air_xts_cycle));
        setOnClick((Button) findViewById(R.id.air_xts_mode_win));
        setOnClick((Button) findViewById(R.id.air_xts_mode_body));
        setOnClick((Button) findViewById(R.id.air_xts_mode_foot));
        setOnClick((Button) findViewById(R.id.air_xts_power));
        setOnClick((Button) findViewById(R.id.air_xts_auto));
        setOnClick((Button) findViewById(R.id.air_xts_steer_hot));
        setOnClick((Button) findViewById(R.id.air_xts_front_hot));
    }

    private void setOnClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
        }
    }

    
    public void setCMD(int cmd, int para) {
        DataCanbus.PROXY.cmd(22, cmd, para);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        AirHelper.disableAirWindowLocal(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
    }

    protected void uFrontHot(int i) {
        if (((Button) findViewById(R.id.air_xts_front_hot)) != null) {
            ((Button) findViewById(R.id.air_xts_front_hot)).setBackgroundResource(i == 1 ? R.drawable.ic_xts_fronthot_p : R.drawable.ic_xts_fronthot_n);
        }
    }

    protected void uSteerHot(int i) {
        if (((Button) findViewById(R.id.air_xts_steer_hot)) != null) {
            ((Button) findViewById(R.id.air_xts_steer_hot)).setBackgroundResource(i == 1 ? R.drawable.ic_xts_steer_hot_p : R.drawable.ic_xts_steer_hot_n);
        }
    }

    protected void uAuto() {
        int auto = DataCanbus.DATA[49];
        int autolev = DataCanbus.DATA[13];
        if (((Button) findViewById(R.id.air_xts_auto)) != null) {
            int resid = R.drawable.ic_turui_auto;
            if (auto != 0) {
                if (autolev == 1) {
                    resid = R.drawable.ic_turui_auto_mid;
                } else if (autolev == 2) {
                    resid = R.drawable.ic_turui_auto_high;
                } else if (autolev == 0) {
                    resid = R.drawable.ic_turui_auto_low;
                }
            } else if (autolev == 1) {
                resid = R.drawable.ic_turui_auto_off_mid;
            } else if (autolev == 2) {
                resid = R.drawable.ic_turui_auto_off_high;
            } else if (autolev == 0) {
                resid = R.drawable.ic_turui_auto_off_low;
            }
            ((Button) findViewById(R.id.air_xts_auto)).setBackgroundResource(resid);
        }
    }

    protected void uWindLevel(int i) {
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(i).toString());
        }
    }

    protected void uCycleAuto(int i) {
        if (((Button) findViewById(R.id.air_xts_cycle)) != null) {
            if (i == 0) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycleauto_0);
            } else if (i == 1) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_xts_cycleauto_2);
            }
        }
    }

    protected void uBlowWin(int i) {
        if (((Button) findViewById(R.id.air_xts_mode_win)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_win)).setBackgroundResource(i == 1 ? R.drawable.ic_xts_mode_win_p : R.drawable.ic_xts_mode_win_n);
        }
    }

    protected void uBlowFoot(int i) {
        if (((Button) findViewById(R.id.air_xts_mode_foot)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_foot)).setBackgroundResource(i == 1 ? R.drawable.ic_xts_mode_foot_p : R.drawable.ic_xts_mode_foot_n);
        }
    }

    protected void uLTemp(int i) {
        String str;
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (i == 254) {
                str = "LOW";
            } else if (i == 255) {
                str = "HI";
            } else if (DataCanbus.DATA[1000] == 196878) {
                if ((DataCanbus.DATA[233] & 255) == 1) {
                    str = String.valueOf(i * 0.5f) + "℃";
                } else {
                    str = String.valueOf(i - 60) + "℉";
                }
            } else {
                str = String.valueOf(i * 0.5f) + "℃";
            }
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText(str);
        }
    }

    protected void uBlowBody(int i) {
        if (((Button) findViewById(R.id.air_xts_mode_body)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_body)).setBackgroundResource(i == 1 ? R.drawable.ic_xts_mode_body_p : R.drawable.ic_xts_mode_body_n);
        }
    }

    protected void uRTemp(int i) {
        String str;
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (i == 254) {
                str = "LOW";
            } else if (i == 255) {
                str = "HI";
            } else if (DataCanbus.DATA[1000] == 196878) {
                if ((DataCanbus.DATA[233] & 255) == 1) {
                    str = String.valueOf(i * 0.5f) + "℃";
                } else {
                    str = String.valueOf(i - 60) + "℉";
                }
            } else {
                str = String.valueOf(i * 0.5f) + "℃";
            }
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText(str);
        }
    }

    protected void uPower(int i) {
        if (((Button) findViewById(R.id.air_xts_power)) != null) {
            ((Button) findViewById(R.id.air_xts_power)).setBackgroundResource(i == 1 ? R.drawable.ic_xts_power_p : R.drawable.ic_xts_power_n);
        }
    }
}
