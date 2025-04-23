package com.syu.carinfo.cyt.yage7;

import android.os.Bundle;
import android.os.SystemProperties;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class Yage7AirAct_Cyt extends BaseActivity {
    public static boolean mIsFront = false;
    int cmd = 0;
    private int[] ids = {15, 12, 19, 21, 13, 14, 20, 11, 22, 29};
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Yage7AirAct_Cyt.this.val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 11:
                    Yage7AirAct_Cyt.this.uAuto(Yage7AirAct_Cyt.this.val);
                    break;
                case 12:
                    Yage7AirAct_Cyt.this.uCycle(Yage7AirAct_Cyt.this.val);
                    break;
                case 13:
                    Yage7AirAct_Cyt.this.uFrontFrog(Yage7AirAct_Cyt.this.val);
                    break;
                case 14:
                    Yage7AirAct_Cyt.this.uRearFrog(Yage7AirAct_Cyt.this.val);
                    break;
                case 15:
                    Yage7AirAct_Cyt.this.uAc(Yage7AirAct_Cyt.this.val);
                    break;
                case 19:
                    Yage7AirAct_Cyt.this.uPower(Yage7AirAct_Cyt.this.val);
                    Yage7AirAct_Cyt.this.uWindLevel(Yage7AirAct_Cyt.this.val);
                    break;
                case 20:
                    Yage7AirAct_Cyt.this.uTempLeft(Yage7AirAct_Cyt.this.val);
                    break;
                case 21:
                    Yage7AirAct_Cyt.this.uTempRight(Yage7AirAct_Cyt.this.val);
                    break;
                case 22:
                    Yage7AirAct_Cyt.this.uDual(Yage7AirAct_Cyt.this.val);
                    break;
                case 29:
                    Yage7AirAct_Cyt.this.uMode(Yage7AirAct_Cyt.this.val);
                    break;
            }
        }
    };
    String str = "";
    int val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ////setContentView(R.layout.layout_417_cyt_yage7_air_control);
        init();
    }

    @Override
    public void init() {
        initListener();
        setClick((Button) findViewById(R.id.air_xts_power));
        setClick((Button) findViewById(R.id.air_xts_rear));
        setClick((Button) findViewById(R.id.air_xts_front));
        setClick((Button) findViewById(R.id.air_xts_mode));
        setClick((Button) findViewById(R.id.air_xts_cycle));
        setClick((Button) findViewById(R.id.air_xts_ac));
        setClick((Button) findViewById(R.id.air_xts_auto));
        setClick((Button) findViewById(R.id.air_xts_dual));
        bindView(R.id.btn_air_temp_left_plus);
        bindView(R.id.btn_air_temp_left_minus);
        bindView(R.id.btn_air_temp_right_minus);
        bindView(R.id.btn_air_temp_right_plus);
        bindView(R.id.dj_xts_air_win_minuts_btn);
        bindView(R.id.dj_xts_air_win_plus_btn);
    }

    private void initListener() {
        this.mClick = new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int cmd = 0;
                switch (v.getId()) {
                    case R.id.btn_air_temp_left_plus /* 2131427425 */:
                        cmd = 9;
                        break;
                    case R.id.btn_air_temp_left_minus /* 2131427427 */:
                        cmd = 10;
                        break;
                    case R.id.air_xts_power /* 2131427428 */:
                        cmd = 1;
                        break;
                    case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                        cmd = 21;
                        break;
                    case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                        cmd = 20;
                        break;
                    case R.id.air_xts_mode /* 2131427434 */:
                        cmd = 17;
                        break;
                    case R.id.air_xts_auto /* 2131427436 */:
                        cmd = 2;
                        break;
                    case R.id.air_xts_cycle /* 2131427437 */:
                        cmd = 35;
                        break;
                    case R.id.air_xts_front /* 2131427438 */:
                        cmd = 3;
                        break;
                    case R.id.air_xts_ac /* 2131427439 */:
                        cmd = 16;
                        break;
                    case R.id.btn_air_temp_right_plus /* 2131427449 */:
                        cmd = 11;
                        break;
                    case R.id.btn_air_temp_right_minus /* 2131427451 */:
                        cmd = 12;
                        break;
                    case R.id.air_xts_dual /* 2131427460 */:
                        cmd = 8;
                        break;
                    case R.id.air_xts_rear /* 2131427534 */:
                        cmd = 4;
                        break;
                }
                Yage7AirAct_Cyt.this.setAirControl(cmd);
            }
        };
    }

    private View bindView(int resId) {
        View v = findViewById(resId);
        if (v != null) {
            setClick(v);
        }
        return v;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        AirHelper.disableAirWindowLocal(true);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        removeNotify();
        mIsFront = false;
    }

    
    public void setAirControl(int cmd) {
        DataCanbus.PROXY.cmd(22, cmd, 1);
    }

    @Override
    public void addNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.notifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.notifyCanbus);
        }
    }

    void uPower(int val) {
        if (((Button) findViewById(R.id.air_xts_power)) != null) {
            ((Button) findViewById(R.id.air_xts_power)).setBackgroundResource(val >= 1 ? R.drawable.ic_xts_power_p : R.drawable.ic_xts_power_n);
        }
    }

    void uAc(int val) {
        View btn = (Button) findViewById(R.id.air_xts_ac);
        if (btn != null) {
            btn.setBackgroundResource(val == 1 ? R.drawable.ic_xts_ac_p : R.drawable.ic_xts_ac_n);
        }
    }

    void uCycle(int val) {
        View btn = (Button) findViewById(R.id.air_xts_cycle);
        if (btn != null) {
            btn.setBackgroundResource(val == 1 ? R.drawable.ic_xts_cycle_p : R.drawable.ic_xts_cycle_n);
        }
    }

    void uWindLevel(int val) {
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(val).toString());
    }

    void uTempLeft(int val) {
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            this.str = "";
            if (val == -1) {
                this.str = "--";
            } else if (val == -2) {
                this.str = "LOW";
            } else if (val == -3) {
                this.str = "HIGH";
            } else {
                int tempunit = SystemProperties.getInt("persist.fyt.temperature", 0);
                if (tempunit == 1) {
                    this.str = String.valueOf(((val * 9) + 320) / 10.0f) + " ℉";
                } else {
                    this.str = String.valueOf(val / 2.0f) + " ℃";
                }
            }
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText(this.str);
        }
    }

    void uTempRight(int val) {
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            this.str = "";
            if (val == -1) {
                this.str = "--";
            } else if (val == -2) {
                this.str = "LOW";
            } else if (val == -3) {
                this.str = "HIGH";
            } else {
                int tempunit = SystemProperties.getInt("persist.fyt.temperature", 0);
                if (tempunit == 1) {
                    this.str = String.valueOf(((val * 9) + 320) / 10.0f) + " ℉";
                } else {
                    this.str = String.valueOf(val / 2.0f) + " ℃";
                }
            }
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText(this.str);
        }
    }

    void uMode(int val) {
        int resid = R.drawable.ic_xts_mode_null;
        switch (val) {
            case 1:
                resid = R.drawable.ic_xts_mode_body;
                break;
            case 2:
                resid = R.drawable.ic_xts_mode_foot_body;
                break;
            case 3:
                resid = R.drawable.ic_xts_mode_foot;
                break;
            case 4:
                resid = R.drawable.ic_xts_mode_foot_win;
                break;
            case 6:
                resid = R.drawable.ic_xts_mode_win;
                break;
            case 7:
                resid = R.drawable.ic_xts_mode_foot_body_win;
                break;
        }
        if (((Button) bindView(R.id.air_xts_mode)) != null) {
            ((Button) bindView(R.id.air_xts_mode)).setBackgroundResource(resid);
        }
    }

    void uFrontFrog(int val) {
        View btn = (Button) findViewById(R.id.air_xts_front);
        if (btn != null) {
            btn.setBackgroundResource(val == 1 ? R.drawable.ic_xts_front_p : R.drawable.ic_xts_front_n);
        }
    }

    void uRearFrog(int val) {
        View btn = (Button) findViewById(R.id.air_xts_rear);
        if (btn != null) {
            btn.setBackgroundResource(val == 1 ? R.drawable.ic_xts_rear_p : R.drawable.ic_xts_rear_n);
        }
    }

    void uAuto(int val) {
        View btn = (Button) findViewById(R.id.air_xts_auto);
        if (btn != null) {
            btn.setBackgroundResource(val == 1 ? R.drawable.ic_xts_auto_p : R.drawable.ic_xts_auto_n);
        }
    }

    void uDual(int val) {
        View btn = (Button) findViewById(R.id.air_xts_dual);
        if (btn != null) {
            btn.setBackgroundResource(val == 1 ? R.drawable.ic_xts_dual_p : R.drawable.ic_xts_dual_n);
        }
    }
}
