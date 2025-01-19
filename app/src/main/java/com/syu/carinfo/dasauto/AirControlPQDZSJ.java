package com.syu.carinfo.dasauto;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class AirControlPQDZSJ extends Activity implements View.OnClickListener {
    public static AirControlPQDZSJ mInstance;
    public static boolean mIsFront = false;
    int cmdId = 0;
    int value = -1;
    int Msgbox_Num = 0;
    int Msgbox_Num_p = 0;
    IUiNotify mCanbusNotify = new IUiNotify() { 
        int value = 0;

        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 10:
                    AirControlPQDZSJ.this.updatePower(this.value);
                    break;
                case 11:
                    AirControlPQDZSJ.this.updateAC(this.value);
                    break;
                case 12:
                    AirControlPQDZSJ.this.updateCycle(this.value);
                    break;
                case 13:
                case 53:
                case 65:
                    AirControlPQDZSJ.this.updateAuto();
                    break;
                case 14:
                    AirControlPQDZSJ.this.updateSync(this.value);
                    break;
                case 18:
                    AirControlPQDZSJ.this.updateBlowWinLeft(this.value);
                    break;
                case 19:
                    AirControlPQDZSJ.this.updateBlowBodyLeft(this.value);
                    break;
                case 20:
                    AirControlPQDZSJ.this.updateBlowFootLeft(this.value);
                    break;
                case 21:
                    AirControlPQDZSJ.this.mUpdaterAirWindLevelLeft(this.value);
                    break;
                case 22:
                    AirControlPQDZSJ.this.updateBlowWinRight(this.value);
                    break;
                case 23:
                    AirControlPQDZSJ.this.updateBlowBodyRight(this.value);
                    break;
                case 24:
                    AirControlPQDZSJ.this.updateBlowFootRight(this.value);
                    break;
                case 25:
                    AirControlPQDZSJ.this.mUpdaterAirWindLevelRight(this.value);
                    break;
                case 27:
                    AirControlPQDZSJ.this.updateTempLeft(this.value);
                    break;
                case 28:
                    AirControlPQDZSJ.this.updateTempRight(this.value);
                    break;
                case 29:
                    if (((ImageView) AirControlPQDZSJ.this.findViewById(R.id.image_FLHeatDriver)) != null) {
                        switch (this.value) {
                            case 0:
                                ((ImageView) AirControlPQDZSJ.this.findViewById(R.id.image_FLHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_null);
                                break;
                            case 1:
                                ((ImageView) AirControlPQDZSJ.this.findViewById(R.id.image_FLHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fl0);
                                break;
                            case 2:
                                ((ImageView) AirControlPQDZSJ.this.findViewById(R.id.image_FLHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fl1);
                                break;
                            case 3:
                                ((ImageView) AirControlPQDZSJ.this.findViewById(R.id.image_FLHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fl2);
                                break;
                        }
                    }
                    break;
                case 30:
                    if (((ImageView) AirControlPQDZSJ.this.findViewById(R.id.image_FRHeatDriver)) != null) {
                        switch (this.value) {
                            case 0:
                                ((ImageView) AirControlPQDZSJ.this.findViewById(R.id.image_FRHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_null);
                                break;
                            case 1:
                                ((ImageView) AirControlPQDZSJ.this.findViewById(R.id.image_FRHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fr0);
                                break;
                            case 2:
                                ((ImageView) AirControlPQDZSJ.this.findViewById(R.id.image_FRHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fr1);
                                break;
                            case 3:
                                ((ImageView) AirControlPQDZSJ.this.findViewById(R.id.image_FRHeatDriver)).setBackgroundResource(R.drawable.air_maiteng_dzsj_heat_fr2);
                                break;
                        }
                    }
                    break;
                case 67:
                    AirControlPQDZSJ.this.updateRearLock(this.value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0001_pq_air_dzsj);
        setListener();
        mInstance = this;
    }

    private void setListener() {
        findViewById(R.id.fill_view).setOnClickListener(this);
        findViewById(R.id.view_dzsj_left_list).setOnClickListener(this);
        findViewById(R.id.view_dzsj_right_list).setOnClickListener(this);
        findViewById(R.id.view_dzsj_air_hide).setOnClickListener(this);
        findViewById(R.id.view_dzsj_air_hide_right).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_clearair)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_dzsj_set)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_steerheat)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_dzsj_power)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_templeft_munits)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_templeft_plus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_cycle)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_cycle_right)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_tempright_munits)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_tempright_plus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_maxac)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_front)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_dzsj_sync)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_dzsj_rear_lock)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_ac)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_ac_right)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_auto)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_manually)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_tempback_munits)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_tempback_plus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_wind0)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_wind1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_wind2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_mode_win)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_mode_win_right)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_mode_body)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_mode_body_right)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_mode_foot)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_air_mode_foot_right)).setOnClickListener(this);
        ((Button) findViewById(R.id.klc_air_control_window_munits_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.klc_air_control_window_plus_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_dzsj_left)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_dzsj_right)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_dzsj_show)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_dzsj_show_right)).setOnClickListener(this);
    }

    public void show_msgbox() {
        this.Msgbox_Num_p = this.Msgbox_Num;
        setViewVisible(findViewById(R.id.view_dzsj_left_list), this.Msgbox_Num_p == 1);
        setViewVisible(findViewById(R.id.view_dzsj_right_list), this.Msgbox_Num_p == 2);
        setViewVisible(findViewById(R.id.view_dzsj_air_hide), this.Msgbox_Num_p == 3);
        setViewVisible(findViewById(R.id.view_dzsj_air_hide_right), this.Msgbox_Num_p == 4);
    }

    private void setViewVisible(View v, boolean b) {
        if (v != null) {
            v.setVisibility(b ? 0 : 8);
        }
    }

    @Override
    public void onClick(View v) {
        this.value = 0;
        this.cmdId = 0;
        switch (v.getId()) {
            case R.id.fill_view /* 2131427333 */:
                this.Msgbox_Num = 0;
                if (this.Msgbox_Num_p != 0) {
                    show_msgbox();
                    break;
                }
            case R.id.btn_dzsj_left /* 2131427363 */:
                this.Msgbox_Num = 1;
                show_msgbox();
                break;
            case R.id.btn_dzsj_right /* 2131427365 */:
                this.Msgbox_Num = 2;
                show_msgbox();
                break;
            case R.id.btn_dzsj_show /* 2131427367 */:
                this.Msgbox_Num = 3;
                show_msgbox();
                break;
            case R.id.btn_dzsj_show_right /* 2131427368 */:
                this.Msgbox_Num = 4;
                show_msgbox();
                break;
        }
        if (this.value >= 0 && this.cmdId > 0) {
            setAirCmd(this.cmdId, this.value);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setViewVisible((Button) findViewById(R.id.btn_air_clearair), false);
        setViewVisible(findViewById(R.id.view_air_tempback), false);
        setViewVisible((Button) findViewById(R.id.btn_air_steerheat), false);
        setViewVisible((Button) findViewById(R.id.btn_dzsj_set), false);
        setViewVisible((Button) findViewById(R.id.btn_dzsj_right), false);
        setViewVisible((ImageView) findViewById(R.id.iv_dzsj_right), false);
        addNotify();
        AirHelper.disableAirWindowLocal(true);
        mIsFront = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        AirHelper.disableAirWindowLocal(false);
        mIsFront = false;
    }

    private void setAirCmd(int cmdCode, int value) {
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mCanbusNotify);
    }

    
    public void updateTempLeft(int value) {
        Boolean isHot = false;
        if (((TextView) findViewById(R.id.tv_air_templeft)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_air_templeft)).setText("LO");
                    break;
                case 255:
                    ((TextView) findViewById(R.id.tv_air_templeft)).setText("HI");
                    isHot = true;
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_air_templeft)).setText((value / 1.0f) + "℃");
                    if (value > 23) {
                        isHot = true;
                        break;
                    }
            }
        }
        if (((ImageView) findViewById(R.id.image_air_mode_win)) != null) {
            ((ImageView) findViewById(R.id.image_air_mode_win)).setBackgroundResource(isHot.booleanValue() ? R.drawable.air_maiteng_dzsj_up_p : R.drawable.air_maiteng_dzsj_up);
        }
        if (((ImageView) findViewById(R.id.image_air_mode_body)) != null) {
            ((ImageView) findViewById(R.id.image_air_mode_body)).setBackgroundResource(isHot.booleanValue() ? R.drawable.air_maiteng_dzsj_body_p : R.drawable.air_maiteng_dzsj_body);
        }
        if (((ImageView) findViewById(R.id.image_air_mode_foot)) != null) {
            ((ImageView) findViewById(R.id.image_air_mode_foot)).setBackgroundResource(isHot.booleanValue() ? R.drawable.air_maiteng_dzsj_foot_p : R.drawable.air_maiteng_dzsj_foot);
        }
    }

    
    public void updateTempRight(int value) {
        Boolean isHot = false;
        if (((TextView) findViewById(R.id.tv_air_tempright)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_air_tempright)).setText("LO");
                    break;
                case 255:
                    ((TextView) findViewById(R.id.tv_air_tempright)).setText("HI");
                    isHot = true;
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_air_tempright)).setText((value / 1.0f) + "℃");
                    if (value > 23) {
                        isHot = true;
                        break;
                    }
            }
        }
        if (((ImageView) findViewById(R.id.image_air_mode_win_r)) != null) {
            ((ImageView) findViewById(R.id.image_air_mode_win_r)).setBackgroundResource(isHot.booleanValue() ? R.drawable.air_maiteng_dzsj_up_r_p : R.drawable.air_maiteng_dzsj_up_r);
        }
        if (((ImageView) findViewById(R.id.image_air_mode_body_r)) != null) {
            ((ImageView) findViewById(R.id.image_air_mode_body_r)).setBackgroundResource(isHot.booleanValue() ? R.drawable.air_maiteng_dzsj_body_r_p : R.drawable.air_maiteng_dzsj_body_r);
        }
        if (((ImageView) findViewById(R.id.image_air_mode_foot_r)) != null) {
            ((ImageView) findViewById(R.id.image_air_mode_foot_r)).setBackgroundResource(isHot.booleanValue() ? R.drawable.air_maiteng_dzsj_foot_r_p : R.drawable.air_maiteng_dzsj_foot_r);
        }
    }

    
    public void updatePower(int value) {
        if (((Button) findViewById(R.id.btn_dzsj_power)) != null) {
            ((Button) findViewById(R.id.btn_dzsj_power)).setBackgroundResource(value == 0 ? R.drawable.ic_dzsj_dz_power_p : R.drawable.ic_dzsj_dz_power);
        }
        if (value == 0) {
            setViewVisible((ImageView) findViewById(R.id.image_air_mode_win), false);
            setViewVisible((ImageView) findViewById(R.id.image_air_mode_body), false);
            setViewVisible((ImageView) findViewById(R.id.image_air_mode_foot), false);
            setViewVisible((ImageView) findViewById(R.id.image_air_mode_win_r), false);
            setViewVisible((ImageView) findViewById(R.id.image_air_mode_body_r), false);
            setViewVisible((ImageView) findViewById(R.id.image_air_mode_foot_r), false);
            setViewVisible(findViewById(R.id.view_air_tempright), false);
            setViewVisible(findViewById(R.id.view_air_templeft), false);
            setViewVisible(findViewById(R.id.view_dzsj_air_hide), false);
            setViewVisible(findViewById(R.id.view_dzsj_air_hide_right), false);
            setViewVisible((Button) findViewById(R.id.btn_dzsj_show), false);
            setViewVisible((Button) findViewById(R.id.btn_dzsj_show_right), false);
            if (((ProgressBar) findViewById(R.id.pb_wind_progress)) != null) {
                ((ProgressBar) findViewById(R.id.pb_wind_progress)).setProgress(0);
            }
            if (((ProgressBar) findViewById(R.id.pb_wind_progress_right)) != null) {
                ((ProgressBar) findViewById(R.id.pb_wind_progress_right)).setProgress(0);
                return;
            }
            return;
        }
        setViewVisible(findViewById(R.id.view_air_tempright), true);
        setViewVisible(findViewById(R.id.view_air_templeft), true);
        setViewVisible((Button) findViewById(R.id.btn_dzsj_show), true);
        setViewVisible((Button) findViewById(R.id.btn_dzsj_show_right), true);
        if (((ProgressBar) findViewById(R.id.pb_wind_progress)) != null) {
            ((ProgressBar) findViewById(R.id.pb_wind_progress)).setProgress(DataCanbus.DATA[21]);
        }
        if (((ProgressBar) findViewById(R.id.pb_wind_progress_right)) != null) {
            ((ProgressBar) findViewById(R.id.pb_wind_progress_right)).setProgress(DataCanbus.DATA[25]);
        }
    }

    
    public void updateAC(int value) {
        int i = R.drawable.ic_dzsj_dz_ac;
        if (((Button) findViewById(R.id.btn_air_ac)) != null) {
            ((Button) findViewById(R.id.btn_air_ac)).setBackgroundResource(value == 0 ? 2130840213 : 2130840214);
        }
        if (((Button) findViewById(R.id.btn_air_ac_right)) != null) {
            Button button = (Button) findViewById(R.id.btn_air_ac_right);
            if (value != 0) {
                i = 2130840214;
            }
            button.setBackgroundResource(i);
        }
    }

    
    public void updateCycle(int value) {
        int i = R.drawable.ic_dzsj_dz_cycle;
        if (((Button) findViewById(R.id.btn_air_cycle)) != null) {
            ((Button) findViewById(R.id.btn_air_cycle)).setBackgroundResource(value == 0 ? 2130840221 : 2130840222);
        }
        if (((Button) findViewById(R.id.btn_air_cycle_right)) != null) {
            Button button = (Button) findViewById(R.id.btn_air_cycle_right);
            if (value != 0) {
                i = 2130840222;
            }
            button.setBackgroundResource(i);
        }
    }

    private void updateWindMode(int value) {
        int i = R.drawable.ic_dzsj_dz_list_bingo_p;
        if (((ImageView) findViewById(R.id.iv_dzsj_right)) != null) {
            switch (value) {
                case 0:
                    ((ImageView) findViewById(R.id.iv_dzsj_right)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dzsj_dz_wind_right0));
                    break;
                case 1:
                    ((ImageView) findViewById(R.id.iv_dzsj_right)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dzsj_dz_wind_right1));
                    break;
                case 2:
                    ((ImageView) findViewById(R.id.iv_dzsj_right)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dzsj_dz_wind_right2));
                    break;
            }
        }
        if (((ImageView) findViewById(R.id.iv_air_wind0)) != null) {
            ((ImageView) findViewById(R.id.iv_air_wind0)).setImageDrawable(getResources().getDrawable(value == 0 ? 2130840226 : 2130840225));
        }
        if (((ImageView) findViewById(R.id.iv_air_wind1)) != null) {
            ((ImageView) findViewById(R.id.iv_air_wind1)).setImageDrawable(getResources().getDrawable(value == 1 ? 2130840226 : 2130840225));
        }
        if (((ImageView) findViewById(R.id.iv_air_wind2)) != null) {
            ImageView imageView = (ImageView) findViewById(R.id.iv_air_wind2);
            Resources resources = getResources();
            if (value != 2) {
                i = 2130840225;
            }
            imageView.setImageDrawable(resources.getDrawable(i));
        }
    }

    
    public void updateRearLock(int value) {
        if (((Button) findViewById(R.id.btn_dzsj_rear_lock)) != null) {
            ((Button) findViewById(R.id.btn_dzsj_rear_lock)).setBackgroundResource(value == 0 ? R.drawable.ic_dzsj_dz_rear : R.drawable.ic_dzsj_dz_rear_p);
        }
    }

    
    public void updateBlowWinLeft(int value) {
        if (((Button) findViewById(R.id.btn_air_mode_win)) != null) {
            ((Button) findViewById(R.id.btn_air_mode_win)).setBackgroundResource(value == 0 ? R.drawable.ic_dzsj_dz_up : R.drawable.ic_dzsj_dz_up_p);
        }
        if (((ImageView) findViewById(R.id.image_air_mode_win)) != null) {
            ((ImageView) findViewById(R.id.image_air_mode_win)).setVisibility(value == 0 ? 8 : 0);
        }
    }

    
    public void updateBlowWinRight(int value) {
        if (((Button) findViewById(R.id.btn_air_mode_win_right)) != null) {
            ((Button) findViewById(R.id.btn_air_mode_win_right)).setBackgroundResource(value == 0 ? R.drawable.ic_dzsj_dz_up : R.drawable.ic_dzsj_dz_up_p);
        }
        if (((ImageView) findViewById(R.id.image_air_mode_win_r)) != null) {
            ((ImageView) findViewById(R.id.image_air_mode_win_r)).setVisibility(value == 0 ? 8 : 0);
        }
    }

    
    public void updateBlowBodyLeft(int value) {
        if (((Button) findViewById(R.id.btn_air_mode_body)) != null) {
            ((Button) findViewById(R.id.btn_air_mode_body)).setBackgroundResource(value == 0 ? R.drawable.ic_dzsj_dz_body : R.drawable.ic_dzsj_dz_body_p);
        }
        if (((ImageView) findViewById(R.id.image_air_mode_body)) != null) {
            ((ImageView) findViewById(R.id.image_air_mode_body)).setVisibility(value == 0 ? 8 : 0);
        }
    }

    
    public void updateBlowBodyRight(int value) {
        if (((Button) findViewById(R.id.btn_air_mode_body_right)) != null) {
            ((Button) findViewById(R.id.btn_air_mode_body_right)).setBackgroundResource(value == 0 ? R.drawable.ic_dzsj_dz_body : R.drawable.ic_dzsj_dz_body_p);
        }
        if (((ImageView) findViewById(R.id.image_air_mode_body_r)) != null) {
            ((ImageView) findViewById(R.id.image_air_mode_body_r)).setVisibility(value == 0 ? 8 : 0);
        }
    }

    
    public void updateBlowFootLeft(int value) {
        if (((Button) findViewById(R.id.btn_air_mode_foot)) != null) {
            ((Button) findViewById(R.id.btn_air_mode_foot)).setBackgroundResource(value == 0 ? R.drawable.ic_dzsj_dz_foot : R.drawable.ic_dzsj_dz_foot_p);
        }
        if (((ImageView) findViewById(R.id.image_air_mode_foot)) != null) {
            ((ImageView) findViewById(R.id.image_air_mode_foot)).setVisibility(value == 0 ? 8 : 0);
        }
    }

    
    public void updateBlowFootRight(int value) {
        if (((Button) findViewById(R.id.btn_air_mode_foot_right)) != null) {
            ((Button) findViewById(R.id.btn_air_mode_foot_right)).setBackgroundResource(value == 0 ? R.drawable.ic_dzsj_dz_foot : R.drawable.ic_dzsj_dz_foot_p);
        }
        if (((ImageView) findViewById(R.id.image_air_mode_foot_r)) != null) {
            ((ImageView) findViewById(R.id.image_air_mode_foot_r)).setVisibility(value == 0 ? 8 : 0);
        }
    }

    
    public void updateAuto() {
        int LeftList_Num = 3;
        if (DataCanbus.DATA[53] == 1 && DataCanbus.DATA[21] == 7) {
            LeftList_Num = 1;
        } else if (DataCanbus.DATA[65] == 1 && DataCanbus.DATA[21] == 7) {
            LeftList_Num = 2;
        } else if (DataCanbus.DATA[13] == 1) {
            LeftList_Num = 0;
        }
        show_left(LeftList_Num);
    }

    void show_left(int LeftList_Num) {
        int i = R.drawable.ic_dzsj_dz_list_bingo_p;
        if (((ImageView) findViewById(R.id.iv_dzsj_left)) != null) {
            switch (LeftList_Num) {
                case 0:
                    ((ImageView) findViewById(R.id.iv_dzsj_left)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dzsj_dz_auto));
                    break;
                case 1:
                    ((ImageView) findViewById(R.id.iv_dzsj_left)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dzsj_dz_maxac));
                    break;
                case 2:
                    ((ImageView) findViewById(R.id.iv_dzsj_left)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dzsj_dz_max));
                    break;
                case 3:
                    ((ImageView) findViewById(R.id.iv_dzsj_left)).setImageDrawable(getResources().getDrawable(R.drawable.ic_dzsj_dz_manual));
                    break;
            }
        }
        if (((ImageView) findViewById(R.id.iv_air_maxac)) != null) {
            ((ImageView) findViewById(R.id.iv_air_maxac)).setImageDrawable(getResources().getDrawable(LeftList_Num == 1 ? 2130840226 : 2130840225));
        }
        if (((ImageView) findViewById(R.id.iv_air_front)) != null) {
            ((ImageView) findViewById(R.id.iv_air_front)).setImageDrawable(getResources().getDrawable(LeftList_Num == 2 ? 2130840226 : 2130840225));
        }
        if (((ImageView) findViewById(R.id.iv_air_auto)) != null) {
            ((ImageView) findViewById(R.id.iv_air_auto)).setImageDrawable(getResources().getDrawable(LeftList_Num == 0 ? 2130840226 : 2130840225));
        }
        if (((ImageView) findViewById(R.id.iv_air_manually)) != null) {
            ImageView imageView = (ImageView) findViewById(R.id.iv_air_manually);
            Resources resources = getResources();
            if (LeftList_Num != 3) {
                i = 2130840225;
            }
            imageView.setImageDrawable(resources.getDrawable(i));
        }
    }

    
    public void updateSync(int value) {
        if (((Button) findViewById(R.id.btn_dzsj_sync)) != null) {
            ((Button) findViewById(R.id.btn_dzsj_sync)).setBackgroundResource(value == 0 ? R.drawable.ic_dzsj_dz_sync : R.drawable.ic_dzsj_dz_sync_p);
        }
    }

    void mUpdaterAirWindLevelLeft(int value) {
        if (((ProgressBar) findViewById(R.id.pb_wind_progress)) != null) {
            ((ProgressBar) findViewById(R.id.pb_wind_progress)).setProgress(value);
        }
    }

    void mUpdaterAirWindLevelRight(int value) {
        if (((ProgressBar) findViewById(R.id.pb_wind_progress_right)) != null) {
            ((ProgressBar) findViewById(R.id.pb_wind_progress_right)).setProgress(value);
        }
    }
}
