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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ZTAirAct_Bnr extends BaseActivity {
    public static boolean mIsFront = false;
    int itempl;
    int itempr;
    int val;
    int touchState = -1;
    int cmd = 0;
    private int[] ids = {31, 32, 33, 37, 39, 40, 41, 42, 44, 45, 46, 47, 65, 48, 38, 85, 68, 69};
    int cycle = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ztt600.ZTAirAct_Bnr.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            ZTAirAct_Bnr.this.val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 31:
                    ZTAirAct_Bnr.this.uPower(ZTAirAct_Bnr.this.val);
                    break;
                case 32:
                    ZTAirAct_Bnr.this.uAc(ZTAirAct_Bnr.this.val);
                    break;
                case 33:
                    ZTAirAct_Bnr.this.uCycle(ZTAirAct_Bnr.this.val);
                    break;
                case 37:
                    ZTAirAct_Bnr.this.uWindLevel(ZTAirAct_Bnr.this.val);
                    break;
                case 38:
                    ZTAirAct_Bnr.this.uTempUnit(ZTAirAct_Bnr.this.val);
                    break;
                case 39:
                    ZTAirAct_Bnr.this.uTempRight(ZTAirAct_Bnr.this.val);
                    break;
                case 40:
                    ZTAirAct_Bnr.this.uFrontFrog(ZTAirAct_Bnr.this.val);
                    break;
                case 41:
                    ZTAirAct_Bnr.this.uRearFrog(ZTAirAct_Bnr.this.val);
                    break;
                case 42:
                    ZTAirAct_Bnr.this.uTempLeft(ZTAirAct_Bnr.this.val);
                    break;
                case 44:
                    ZTAirAct_Bnr.this.uAuto(ZTAirAct_Bnr.this.val);
                    break;
                case 45:
                    ZTAirAct_Bnr.this.uDual(ZTAirAct_Bnr.this.val);
                    break;
                case 46:
                    ZTAirAct_Bnr.this.uMode(ZTAirAct_Bnr.this.val);
                    break;
                case 47:
                    ZTAirAct_Bnr.this.uAcMax(ZTAirAct_Bnr.this.val);
                    break;
                case 48:
                    ZTAirAct_Bnr.this.uBlowFace(ZTAirAct_Bnr.this.val);
                    break;
                case 68:
                    ZTAirAct_Bnr.this.uSeatLeft(ZTAirAct_Bnr.this.val);
                    break;
                case 69:
                    ZTAirAct_Bnr.this.uSeatRight(ZTAirAct_Bnr.this.val);
                    break;
                case 85:
                    ZTAirAct_Bnr.this.uAirType(ZTAirAct_Bnr.this.val);
                    break;
            }
        }
    };
    int airtype = 0;
    String str = "";
    private int unit = 0;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[85] == 2) {
            setContentView(R.layout.layout_265_bnr_t600_air_control_zidong);
        } else {
            setContentView(R.layout.layout_265_bnr_t600_air_control_shoudong);
        }
        init();
    }

    @Override // com.syu.canbus.BaseActivity
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
        this.mClick = new View.OnClickListener() { // from class: com.syu.carinfo.ztt600.ZTAirAct_Bnr.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int cmd = 0;
                switch (v.getId()) {
                    case R.id.btn_air_temp_left_plus /* 2131427425 */:
                        cmd = 3;
                        break;
                    case R.id.btn_air_temp_left_minus /* 2131427427 */:
                        cmd = 2;
                        break;
                    case R.id.air_xts_power /* 2131427428 */:
                        cmd = 1;
                        break;
                    case R.id.dj_xts_air_win_minuts_btn /* 2131427429 */:
                        cmd = 9;
                        break;
                    case R.id.dj_xts_air_win_plus_btn /* 2131427431 */:
                        cmd = 10;
                        break;
                    case R.id.air_xts_seathot_left /* 2131427433 */:
                        cmd = 11;
                        break;
                    case R.id.air_xts_mode /* 2131427434 */:
                        cmd = 36;
                        break;
                    case R.id.air_xts_seathot_right /* 2131427435 */:
                        cmd = 13;
                        break;
                    case R.id.air_xts_auto /* 2131427436 */:
                        cmd = 21;
                        break;
                    case R.id.air_xts_front /* 2131427438 */:
                        cmd = 19;
                        break;
                    case R.id.air_xts_ac /* 2131427439 */:
                        cmd = 23;
                        break;
                    case R.id.air_xts_maxac /* 2131427440 */:
                        cmd = 24;
                        break;
                    case R.id.air_xts_mode_foot /* 2131427443 */:
                        cmd = 8;
                        break;
                    case R.id.air_xts_mode_body /* 2131427444 */:
                        cmd = 7;
                        break;
                    case R.id.btn_air_temp_right_plus /* 2131427449 */:
                        cmd = 5;
                        break;
                    case R.id.btn_air_temp_right_minus /* 2131427451 */:
                        cmd = 4;
                        break;
                    case R.id.air_xts_dual /* 2131427460 */:
                        cmd = 16;
                        break;
                    case R.id.air_xts_mode_footbody /* 2131427461 */:
                        cmd = 33;
                        break;
                    case R.id.air_xts_mode_footwin /* 2131427462 */:
                        cmd = 32;
                        break;
                    case R.id.air_xts_clear /* 2131427465 */:
                        cmd = 37;
                        break;
                    case R.id.air_xts_rear /* 2131427534 */:
                        cmd = 20;
                        break;
                    case R.id.air_cycle_outer /* 2131427557 */:
                        if (ZTAirAct_Bnr.this.cycle == 1) {
                            cmd = 25;
                            break;
                        }
                    case R.id.air_cycle_inter /* 2131427558 */:
                        if (ZTAirAct_Bnr.this.cycle == 0) {
                            cmd = 25;
                            break;
                        }
                }
                ZTAirAct_Bnr.this.setAirControl(cmd, 0);
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        AirHelper.disableAirWindowLocal(true);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        removeNotify();
        mIsFront = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAirControl(int cmd, int value) {
        DataCanbus.PROXY.cmd(0, cmd, value);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.notifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
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

    protected void uSeatRight(int val) {
        int ids = R.drawable.ic_xts_seathot_left_level0;
        if (val == 1) {
            ids = R.drawable.ic_xts_seathot_left_level1;
        } else if (val == 2) {
            ids = R.drawable.ic_xts_seathot_left_level3;
        }
        if (((Button) bindView(R.id.air_xts_seathot_left)) != null) {
            ((Button) bindView(R.id.air_xts_seathot_left)).setBackgroundResource(ids);
        }
    }

    protected void uSeatLeft(int val) {
        int ids = R.drawable.ic_xts_seathot_right_level0;
        if (val == 1) {
            ids = R.drawable.ic_xts_seathot_right_level1;
        } else if (val == 2) {
            ids = R.drawable.ic_xts_seathot_right_level3;
        }
        if (((Button) bindView(R.id.air_xts_seathot_right)) != null) {
            ((Button) bindView(R.id.air_xts_seathot_right)).setBackgroundResource(ids);
        }
    }

    void uAc(int val) {
        View btn = (Button) bindView(R.id.air_xts_ac);
        if (btn != null) {
            btn.setBackgroundResource(val == 1 ? R.drawable.ic_xts_ac_p : R.drawable.ic_xts_ac_n);
        }
    }

    void uCycle(int val) {
        this.cycle = val;
        if (((Button) bindView(R.id.air_cycle_outer)) != null) {
            ((Button) bindView(R.id.air_cycle_outer)).setBackgroundResource(val == 0 ? R.drawable.ic_xts_cycle_out_p : R.drawable.ic_xts_cycle_n);
        }
        if (((Button) bindView(R.id.air_cycle_inter)) != null) {
            ((Button) bindView(R.id.air_cycle_inter)).setBackgroundResource(val == 1 ? R.drawable.ic_cycle_all_p : R.drawable.ic_cycle_all_n);
        }
    }

    void uWindLevel(int val) {
        ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder(String.valueOf(val)).toString());
    }

    protected void uAirType(int val) {
        this.airtype = val;
    }

    void uTempLeft(int val) {
        uAirType(DataCanbus.DATA[85]);
        this.itempl = val;
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            this.str = "";
            if (this.airtype != 2) {
                if (val == 0) {
                    this.str = "NONE";
                } else if (val > 0 && val < 16) {
                    this.str = "Lv " + val;
                }
            } else {
                switch (val) {
                    case 1:
                        this.str = "LO";
                        break;
                    case 57:
                        this.str = "HI";
                        break;
                    default:
                        if (val < 56 && val > 2) {
                            float m = 18.0f + (((val - 1) / 2) * 0.5f);
                            if (this.unit == 1) {
                                this.str = String.valueOf(((val - 3) / 2) + 65) + " ℉";
                                break;
                            } else {
                                this.str = String.valueOf(m) + " ℃";
                                break;
                            }
                        } else {
                            this.str = "NONE";
                            break;
                        }
                }
            }
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText(this.str);
        }
    }

    void uTempRight(int val) {
        uAirType(DataCanbus.DATA[85]);
        this.itempr = val;
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            this.str = "";
            if (this.airtype != 2) {
                if (val == 0) {
                    this.str = "NONE";
                } else if (val > 0 && val < 16) {
                    this.str = "Lv " + val;
                }
            } else {
                switch (val) {
                    case 1:
                        this.str = "LO";
                        break;
                    case 57:
                        this.str = "HI";
                        break;
                    default:
                        if (val < 56 && val > 2) {
                            float m = 18.0f + (((val - 1) / 2) * 0.5f);
                            if (this.unit == 1) {
                                this.str = String.valueOf(((val - 3) / 2) + 65) + " ℉";
                                break;
                            } else {
                                this.str = String.valueOf(m) + " ℃";
                                break;
                            }
                        } else {
                            this.str = "NONE";
                            break;
                        }
                }
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
        if (((Button) bindView(R.id.air_xts_mode_body)) != null) {
            ((Button) bindView(R.id.air_xts_mode_body)).setBackgroundResource(val == 4 ? R.drawable.ic_xts_mode_body_p : R.drawable.ic_xts_mode_body_n);
        }
        if (((Button) bindView(R.id.air_xts_mode_footbody)) != null) {
            ((Button) bindView(R.id.air_xts_mode_footbody)).setBackgroundResource(val == 6 ? R.drawable.ic_xts_mode_footbody_p : R.drawable.ic_xts_mode_footbody_n);
        }
        if (((Button) bindView(R.id.air_xts_mode_footwin)) != null) {
            ((Button) bindView(R.id.air_xts_mode_footwin)).setBackgroundResource(val == 3 ? R.drawable.ic_xts_mode_footwin_p : R.drawable.ic_xts_mode_footwin_n);
        }
        if (((Button) bindView(R.id.air_xts_mode_foot)) != null) {
            ((Button) bindView(R.id.air_xts_mode_foot)).setBackgroundResource(val == 2 ? R.drawable.ic_xts_mode_foot_p : R.drawable.ic_xts_mode_foot_n);
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
        uTempLeft(this.itempl);
        uTempRight(this.itempr);
    }
}
