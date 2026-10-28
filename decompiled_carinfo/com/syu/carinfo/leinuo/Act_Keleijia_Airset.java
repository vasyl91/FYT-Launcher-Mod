package com.syu.carinfo.leinuo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class Act_Keleijia_Airset extends Activity implements View.OnClickListener {
    public static boolean mIsFront = false;
    int body;
    int foot;
    int up;
    private int[] eventIds = {13, 12, 16, 11, 27, 19, 20, 18, 21, 28, 10, 37, 62, 36, 15};
    IUiNotify mCanbusNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                    Act_Keleijia_Airset.this.uPower(value);
                    break;
                case 11:
                    Act_Keleijia_Airset.this.uAC(value);
                    break;
                case 12:
                    Act_Keleijia_Airset.this.uCycle(value);
                    break;
                case 15:
                    Act_Keleijia_Airset.this.uMaxFront(value);
                    break;
                case 16:
                    Act_Keleijia_Airset.this.uRearFrog(value);
                    break;
                case 18:
                    Act_Keleijia_Airset.this.uModeUp(value);
                    break;
                case 19:
                    Act_Keleijia_Airset.this.uModeBody(value);
                    break;
                case 20:
                    Act_Keleijia_Airset.this.uModeFoot(value);
                    break;
                case 21:
                    Act_Keleijia_Airset.this.uWindLevel(value);
                    break;
                case 27:
                    Act_Keleijia_Airset.this.uTempLeft(value);
                    break;
                case 28:
                    Act_Keleijia_Airset.this.uTempRight(value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_keleiao_air);
        initUI();
    }

    private void initUI() {
        ((Button) findViewById(R.id.btn_air_temp_left_minus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_temp_left_plus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_temp_right_minus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_temp_right_plus)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_mode)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_ac)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_cycle_outer)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_cycle_inter)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_front)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_rear)).setOnClickListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_minuts_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.dj_xts_air_win_plus_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.air_xts_power)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int cmd = 0;
        switch (v.getId()) {
            case R.id.btn_air_temp_left_plus /* 2131427425 */:
                cmd = 31;
                break;
            case R.id.btn_air_temp_left_minus /* 2131427427 */:
                cmd = 30;
                break;
            case R.id.air_xts_power /* 2131427428 */:
                cmd = 16;
                break;
            case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                cmd = 28;
                break;
            case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                cmd = 29;
                break;
            case R.id.air_xts_mode /* 2131427434 */:
                cmd = 25;
                break;
            case R.id.air_xts_front /* 2131427438 */:
                cmd = 21;
                break;
            case R.id.air_xts_ac /* 2131427439 */:
                cmd = 17;
                break;
            case R.id.btn_air_temp_right_plus /* 2131427449 */:
                cmd = 33;
                break;
            case R.id.btn_air_temp_right_minus /* 2131427451 */:
                cmd = 32;
                break;
            case R.id.air_xts_rear /* 2131427560 */:
                cmd = 22;
                break;
            case R.id.air_cycle_outer /* 2131428106 */:
                if (DataCanbus.DATA[12] == 1) {
                    cmd = 19;
                    break;
                }
            case R.id.air_cycle_inter /* 2131428107 */:
                if (DataCanbus.DATA[12] == 0) {
                    cmd = 19;
                    break;
                }
        }
        if (cmd != 0) {
            setCmd(cmd);
        }
    }

    protected void setCmd(int cmd) {
        DataCanbus.PROXY.cmd(1, new int[]{cmd}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AirHelper.disableAirWindowLocal(true);
        addNotify();
        mIsFront = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        removeNotify();
        mIsFront = false;
    }

    public void addNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].addNotify(this.mCanbusNotify, 1);
        }
    }

    public void removeNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].removeNotify(this.mCanbusNotify);
        }
    }

    private void setViewSelected(View v, boolean on) {
        if (v != null) {
            v.setSelected(on);
        }
    }

    protected void uCycle(int value) {
        if (((Button) findViewById(R.id.air_cycle_outer)) != null) {
            ((Button) findViewById(R.id.air_cycle_outer)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_cycle_out_p : R.drawable.ic_xts_cycle_n);
        }
        if (((Button) findViewById(R.id.air_cycle_inter)) != null) {
            ((Button) findViewById(R.id.air_cycle_inter)).setBackgroundResource(value == 1 ? R.drawable.ic_cycle_all_p : R.drawable.ic_cycle_all_n);
        }
    }

    protected void uMaxFront(int value) {
        setViewSelected((Button) findViewById(R.id.air_xts_front), value == 1);
    }

    protected void uPower(int value) {
        setViewSelected((Button) findViewById(R.id.air_xts_power), value == 1);
    }

    protected void uTempRight(int value) {
        String str;
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (value == -2) {
                str = "LO";
            } else {
                str = value == -3 ? "HI" : String.valueOf(value * 0.5f) + "℃";
            }
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText(str);
        }
    }

    protected void uTempLeft(int value) {
        String str;
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (value == -2) {
                str = "LO";
            } else {
                str = value == -3 ? "HI" : String.valueOf(value * 0.5f) + "℃";
            }
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText(str);
        }
    }

    protected void uWindLevel(int value) {
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null) {
            if (value > 8) {
                value = 8;
            }
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(value).toString());
        }
    }

    protected void uModeUp(int value) {
        this.up = value;
        uMode();
    }

    protected void uModeBody(int value) {
        this.body = value;
        uMode();
    }

    protected void uModeFoot(int value) {
        this.foot = value;
        uMode();
    }

    protected void uMode() {
        int mode = 0;
        if (this.foot == 1) {
            mode = 0 | 1;
        } else if (this.foot == 0) {
            mode = 0 & 254;
        }
        if (this.body == 1) {
            mode |= 2;
        } else if (this.body == 0) {
            mode &= 253;
        }
        if (this.up == 1) {
            mode |= 4;
        } else if (this.up == 0) {
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

    protected void uAC(int value) {
        setViewSelected((Button) findViewById(R.id.air_xts_ac), value == 1);
    }

    protected void uRearFrog(int value) {
        setViewSelected((Button) findViewById(R.id.air_xts_rear), value == 1);
    }
}
