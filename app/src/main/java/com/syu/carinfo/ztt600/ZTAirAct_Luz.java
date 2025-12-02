package com.syu.carinfo.ztt600;

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
public class ZTAirAct_Luz extends BaseActivity {
    public static boolean mIsFront = false;
    int val;
    int touchState = -1;
    int cmd = 0;
    private int[] ids = {10, 11, 12, 21, 28, 65, 16, 27, 13, 14, 77, 53, 33, 37};
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            ZTAirAct_Luz.this.val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                    ZTAirAct_Luz.this.uPower(ZTAirAct_Luz.this.val);
                    break;
                case 11:
                    ZTAirAct_Luz.this.uAc(ZTAirAct_Luz.this.val);
                    break;
                case 12:
                    ZTAirAct_Luz.this.uCycle(ZTAirAct_Luz.this.val);
                    break;
                case 13:
                    ZTAirAct_Luz.this.uAuto(ZTAirAct_Luz.this.val);
                    break;
                case 14:
                    ZTAirAct_Luz.this.uDual(ZTAirAct_Luz.this.val);
                    break;
                case 16:
                    ZTAirAct_Luz.this.uRearFrog(ZTAirAct_Luz.this.val);
                    break;
                case 21:
                    ZTAirAct_Luz.this.uWindLevel(ZTAirAct_Luz.this.val);
                    break;
                case 27:
                    ZTAirAct_Luz.this.uTempLeft(ZTAirAct_Luz.this.val);
                    break;
                case 28:
                    ZTAirAct_Luz.this.uTempRight(ZTAirAct_Luz.this.val);
                    break;
                case 33:
                    ZTAirAct_Luz.this.uBlowFace(ZTAirAct_Luz.this.val);
                    break;
                case 37:
                    ZTAirAct_Luz.this.uTempUnit(ZTAirAct_Luz.this.val);
                    break;
                case 53:
                    ZTAirAct_Luz.this.uAcMax(ZTAirAct_Luz.this.val);
                    break;
                case 65:
                    ZTAirAct_Luz.this.uFrontFrog(ZTAirAct_Luz.this.val);
                    break;
                case 77:
                    ZTAirAct_Luz.this.uMode(ZTAirAct_Luz.this.val);
                    break;
            }
        }
    };
    String str = "";
    private int unit = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_265_luz_t600_air_control);
        init();
    }

    @Override
    public void init() {
        initListener();
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
                int val = 0;
                switch (v.getId()) {
                    case R.id.btn_air_temp_left_plus /* 2131427425 */:
                        cmd = 12;
                        val = 1;
                        break;
                    case R.id.btn_air_temp_left_minus /* 2131427427 */:
                        cmd = 12;
                        val = 0;
                        break;
                    case R.id.air_xts_power /* 2131427428 */:
                        cmd = 1;
                        break;
                    case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                        cmd = 11;
                        val = 0;
                        break;
                    case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                        cmd = 11;
                        val = 1;
                        break;
                    case R.id.air_xts_mode /* 2131427434 */:
                        cmd = 10;
                        break;
                    case R.id.air_xts_auto /* 2131427436 */:
                        cmd = 4;
                        break;
                    case R.id.air_xts_cycle /* 2131427437 */:
                        cmd = 7;
                        break;
                    case R.id.air_xts_front /* 2131427438 */:
                        cmd = 5;
                        break;
                    case R.id.air_xts_ac /* 2131427439 */:
                        cmd = 2;
                        break;
                    case R.id.air_xts_maxac /* 2131427440 */:
                        cmd = 3;
                        break;
                    case R.id.btn_air_temp_right_plus /* 2131427449 */:
                        cmd = 13;
                        val = 1;
                        break;
                    case R.id.btn_air_temp_right_minus /* 2131427451 */:
                        cmd = 13;
                        val = 0;
                        break;
                    case R.id.air_xts_rear /* 2131427560 */:
                        cmd = 6;
                        break;
                    case R.id.air_xts_dual /* 2131427566 */:
                        cmd = 8;
                        break;
                    case R.id.air_xts_clear /* 2131427569 */:
                        cmd = 9;
                        break;
                }
                ZTAirAct_Luz.this.setAirControl(cmd, val);
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

    
    public void setAirControl(int cmd, int value) {
        DataCanbus.PROXY.cmd(0, cmd, value);
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
        if (((Button) bindView(R.id.air_xts_power)) != null) {
            ((Button) bindView(R.id.air_xts_power)).setBackgroundResource(val == 1 ? R.drawable.ic_xts_power_p : R.drawable.ic_xts_power_n);
        }
    }

    void uAc(int val) {
        View btn = (Button) bindView(R.id.air_xts_ac);
        if (btn != null) {
            btn.setBackgroundResource(val == 1 ? R.drawable.ic_xts_ac_p : R.drawable.ic_xts_ac_n);
        }
    }

    void uCycle(int val) {
        View btn = (Button) bindView(R.id.air_xts_cycle);
        if (btn != null) {
            btn.setBackgroundResource(val == 1 ? R.drawable.ic_xts_cycle_p : R.drawable.ic_xts_cycle_n);
        }
    }

    void uWindLevel(int val) {
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder(String.valueOf(val)).toString());
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
            } else if (this.unit == 0) {
                this.str = String.valueOf(val / 10) + "." + (val % 10) + " ℃";
            } else {
                int val_f = ((val * 18) / 10) + 320;
                this.str = String.valueOf(val_f / 10) + "." + (val_f % 10) + " ℉";
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
            } else if (this.unit == 0) {
                this.str = String.valueOf(val / 10) + "." + (val % 10) + " ℃";
            } else {
                int val_f = ((val * 18) / 10) + 320;
                this.str = String.valueOf(val_f / 10) + "." + (val_f % 10) + " ℉";
            }
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText(this.str);
        }
    }

    void uMode(int val) {
        int resid = R.drawable.ic_xts_mode_null;
        switch (val) {
            case 1:
                resid = R.drawable.ic_xts_mode_foot;
                break;
            case 2:
                resid = R.drawable.ic_xts_mode_body;
                break;
            case 3:
                resid = R.drawable.ic_xts_mode_foot_body;
                break;
            case 4:
                resid = R.drawable.ic_xts_mode_win;
                break;
            case 5:
                resid = R.drawable.ic_xts_mode_foot_win;
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
        View btn = (Button) bindView(R.id.air_xts_front);
        if (btn != null) {
            btn.setBackgroundResource(val == 1 ? R.drawable.ic_xts_front_p : R.drawable.ic_xts_front_n);
        }
    }

    void uRearFrog(int val) {
        View btn = (Button) bindView(R.id.air_xts_rear);
        if (btn != null) {
            btn.setBackgroundResource(val == 1 ? R.drawable.ic_xts_rear_p : R.drawable.ic_xts_rear_n);
        }
    }

    void uAuto(int val) {
        View btn = (Button) bindView(R.id.air_xts_auto);
        if (btn != null) {
            btn.setBackgroundResource(val == 1 ? R.drawable.ic_xts_auto_p : R.drawable.ic_xts_auto_n);
        }
    }

    void uDual(int val) {
        View btn = (Button) bindView(R.id.air_xts_dual);
        if (btn != null) {
            btn.setBackgroundResource(val == 1 ? R.drawable.ic_xts_dual_p : R.drawable.ic_xts_dual_n);
        }
    }

    void uAcMax(int val) {
        View btn = (Button) bindView(R.id.air_xts_maxac);
        if (btn != null) {
            btn.setBackgroundResource(val == 1 ? R.drawable.ic_xts_maxac_p : R.drawable.ic_xts_maxac_n);
        }
    }

    void uBlowFace(int val) {
        View btn = (Button) bindView(R.id.air_xts_clear);
        if (btn != null) {
            btn.setBackgroundResource(val == 1 ? R.drawable.ic_xts_clear_air_p : R.drawable.ic_xts_clear_air_n);
        }
    }

    void uTempUnit(int val) {
        this.unit = val;
    }
}
