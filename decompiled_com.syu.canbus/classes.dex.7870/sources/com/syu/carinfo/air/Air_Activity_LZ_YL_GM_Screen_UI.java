package com.syu.carinfo.air;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.ui.air.AirHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Air_Activity_LZ_YL_GM_Screen_UI extends Activity implements View.OnTouchListener {
    public static Air_Activity_LZ_YL_GM_Screen_UI mInstance;
    public static boolean mIsFront = false;
    int pagenum = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.air.Air_Activity_LZ_YL_GM_Screen_UI.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 112) {
                Air_Activity_LZ_YL_GM_Screen_UI.this.mUpdateDayNight();
            }
            if (updateCode == 11) {
                Air_Activity_LZ_YL_GM_Screen_UI.this.mUpdateAcOn();
            }
            if (updateCode == 12) {
                Air_Activity_LZ_YL_GM_Screen_UI.this.mUpdateCycle();
            }
            if (updateCode == 13) {
                Air_Activity_LZ_YL_GM_Screen_UI.this.mUpdateAuto();
            }
            if (updateCode == 62) {
                Air_Activity_LZ_YL_GM_Screen_UI.this.mUpdateSync();
            }
            if (updateCode == 16) {
                Air_Activity_LZ_YL_GM_Screen_UI.this.mUpdateRearDefrost();
            }
            if (updateCode == 65) {
                Air_Activity_LZ_YL_GM_Screen_UI.this.mUpdateFrontDefrost();
            }
            if (updateCode == 10) {
                Air_Activity_LZ_YL_GM_Screen_UI.this.mUpdatePower();
            }
            if (updateCode == 21) {
                Air_Activity_LZ_YL_GM_Screen_UI.this.mUpdaterAirWindLevelLeft();
            }
            if (updateCode == 27) {
                Air_Activity_LZ_YL_GM_Screen_UI.this.mUpdateAirTempLeft();
            }
            if (updateCode == 28) {
                Air_Activity_LZ_YL_GM_Screen_UI.this.mUpdateTempRight();
            }
            if (updateCode == 42) {
                Air_Activity_LZ_YL_GM_Screen_UI.this.mUpdateRearPower();
            }
            if (updateCode == 40) {
                Air_Activity_LZ_YL_GM_Screen_UI.this.mUpdateRearTemp();
            }
            if (updateCode == 37) {
                Air_Activity_LZ_YL_GM_Screen_UI.this.mUpdateAirTempLeft();
                Air_Activity_LZ_YL_GM_Screen_UI.this.mUpdateTempRight();
                Air_Activity_LZ_YL_GM_Screen_UI.this.mUpdateRearTemp();
            }
            if (updateCode == 44) {
                Air_Activity_LZ_YL_GM_Screen_UI.this.mUpdaterAirWindLevelRear();
            }
            if (updateCode == 29) {
                Air_Activity_LZ_YL_GM_Screen_UI.this.mUpdateHeatLeft();
            }
            if (updateCode == 30) {
                Air_Activity_LZ_YL_GM_Screen_UI.this.mUpdateHeatRight();
            }
            if (updateCode == 93) {
                Air_Activity_LZ_YL_GM_Screen_UI.this.mUpdateMassageLeft();
            }
            if (updateCode == 94) {
                Air_Activity_LZ_YL_GM_Screen_UI.this.mUpdateMassageRight();
            }
            if (updateCode == 43) {
                Air_Activity_LZ_YL_GM_Screen_UI.this.mUpdateBackAuto();
            }
            if (updateCode == 67) {
                Air_Activity_LZ_YL_GM_Screen_UI.this.mUpdateRearLock();
            }
            if (updateCode == 86) {
                Air_Activity_LZ_YL_GM_Screen_UI.this.mUpdateRearSync();
            }
            if (updateCode == 18 || updateCode == 19 || updateCode == 20) {
                Air_Activity_LZ_YL_GM_Screen_UI.this.updateBlowModeLeft();
            }
            if (updateCode != 46 && updateCode != 47) {
                return;
            }
            Air_Activity_LZ_YL_GM_Screen_UI.this.updateBlowBackMode();
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_456_LZ_YL_Silverado_14_Hand_7Screen /* 5308872 */:
            case FinalCanbus.CAR_456_LZ_YL_Elynx_Silverado_14_Hand_4Screen /* 14287304 */:
            case FinalCanbus.CAR_456_LZ_YL_Elynx_Sierra_14_Hand_4Screen /* 14352840 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_4Screen /* 15729095 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_8Screen /* 15860167 */:
                setContentView(R.layout.layout_0455_air_lz_yl_14gm_screen_handui);
                break;
            case FinalCanbus.CAR_456_LZ_YL_Silverado_14_Auto_7Screen /* 5374408 */:
            case FinalCanbus.CAR_456_LZ_YL_Elynx_Silverado_14_Auto_8Screen /* 14418376 */:
            case FinalCanbus.CAR_456_LZ_YL_Elynx_Sierra_14_Auto_8Screen /* 14483912 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_4Screen /* 15794631 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_8Screen /* 15925703 */:
                setContentView(R.layout.layout_0455_air_lz_yl_14gm_screen_autoui);
                break;
            default:
                setContentView(R.layout.layout_0455_air_lz_yl_gm_screen_ui);
                break;
        }
        init();
        mInstance = this;
    }

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(0, new int[]{data0, data1}, null, null);
    }

    private void init() {
        if (findViewById(R.id.tv_sp_rear) != null) {
            findViewById(R.id.tv_sp_rear).setOnTouchListener(this);
        }
        if (findViewById(R.id.tv_sp_front) != null) {
            findViewById(R.id.tv_sp_front).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_temp_left_plus) != null) {
            findViewById(R.id.air_sp_temp_left_plus).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_temp_left_munits) != null) {
            findViewById(R.id.air_sp_temp_left_munits).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_blow_body_foot) != null) {
            findViewById(R.id.air_sp_blow_body_foot).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_blow_foot) != null) {
            findViewById(R.id.air_sp_blow_foot).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_blow_body) != null) {
            findViewById(R.id.air_sp_blow_body).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_blow_foot_win) != null) {
            findViewById(R.id.air_sp_blow_foot_win).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_blow_win) != null) {
            findViewById(R.id.air_sp_blow_win).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_temp_right_plus) != null) {
            findViewById(R.id.air_sp_temp_right_plus).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_temp_right_munits) != null) {
            findViewById(R.id.air_sp_temp_right_munits).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_wind_minuts) != null) {
            findViewById(R.id.air_sp_wind_minuts).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_wind_plus) != null) {
            findViewById(R.id.air_sp_wind_plus).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_power) != null) {
            findViewById(R.id.air_sp_power).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_seatwind_left) != null) {
            findViewById(R.id.air_sp_seatwind_left).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_seatmassage_left) != null) {
            findViewById(R.id.air_sp_seatmassage_left).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_seatheat_left) != null) {
            findViewById(R.id.air_sp_seatheat_left).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_seatheat_right) != null) {
            findViewById(R.id.air_sp_seatheat_right).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_seatwind_right) != null) {
            findViewById(R.id.air_sp_seatwind_right).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_seatmassage_right) != null) {
            findViewById(R.id.air_sp_seatmassage_right).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_sync) != null) {
            findViewById(R.id.air_sp_sync).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_front) != null) {
            findViewById(R.id.air_sp_front).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_auto) != null) {
            findViewById(R.id.air_sp_auto).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_ac) != null) {
            findViewById(R.id.air_sp_ac).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_rear) != null) {
            findViewById(R.id.air_sp_rear).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_cycle) != null) {
            findViewById(R.id.air_sp_cycle).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_temp_rearleft_plus) != null) {
            findViewById(R.id.air_sp_temp_rearleft_plus).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_tempunit_rearleft) != null) {
            findViewById(R.id.air_sp_tempunit_rearleft).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_rear_blow_body_foot) != null) {
            findViewById(R.id.air_sp_rear_blow_body_foot).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_rear_blow_foot) != null) {
            findViewById(R.id.air_sp_rear_blow_foot).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_rear_blow_body) != null) {
            findViewById(R.id.air_sp_rear_blow_body).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_rear_wind_minuts) != null) {
            findViewById(R.id.air_sp_rear_wind_minuts).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_rear_wind_plus) != null) {
            findViewById(R.id.air_sp_rear_wind_plus).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_temp_rearright_plus) != null) {
            findViewById(R.id.air_sp_temp_rearright_plus).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_temp_rearright_minus) != null) {
            findViewById(R.id.air_sp_temp_rearright_minus).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_sync_rear) != null) {
            findViewById(R.id.air_sp_sync_rear).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_rearlock_rear) != null) {
            findViewById(R.id.air_sp_rearlock_rear).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_power_rear) != null) {
            findViewById(R.id.air_sp_power_rear).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_auto_rear) != null) {
            findViewById(R.id.air_sp_auto_rear).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_ac_rear) != null) {
            findViewById(R.id.air_sp_ac_rear).setOnTouchListener(this);
        }
        if (findViewById(R.id.tv_sp_rear_night) != null) {
            findViewById(R.id.tv_sp_rear_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.tv_sp_front_night) != null) {
            findViewById(R.id.tv_sp_front_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_temp_left_plus_night) != null) {
            findViewById(R.id.air_sp_temp_left_plus_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_temp_left_munits_night) != null) {
            findViewById(R.id.air_sp_temp_left_munits_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_blow_body_foot) != null) {
            findViewById(R.id.air_sp_blow_body_foot).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_blow_foot_night) != null) {
            findViewById(R.id.air_sp_blow_foot_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_blow_body_night) != null) {
            findViewById(R.id.air_sp_blow_body_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_blow_foot_win) != null) {
            findViewById(R.id.air_sp_blow_foot_win).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_blow_win_night) != null) {
            findViewById(R.id.air_sp_blow_win_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_temp_right_plus_night) != null) {
            findViewById(R.id.air_sp_temp_right_plus_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_temp_right_munits_night) != null) {
            findViewById(R.id.air_sp_temp_right_munits_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_wind_minuts_night) != null) {
            findViewById(R.id.air_sp_wind_minuts_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_wind_plus_night) != null) {
            findViewById(R.id.air_sp_wind_plus_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_power_night) != null) {
            findViewById(R.id.air_sp_power_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_seatwind_left_night) != null) {
            findViewById(R.id.air_sp_seatwind_left_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_seatmassage_left_night) != null) {
            findViewById(R.id.air_sp_seatmassage_left_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_seatheat_left_night) != null) {
            findViewById(R.id.air_sp_seatheat_left_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_seatheat_right_night) != null) {
            findViewById(R.id.air_sp_seatheat_right_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_seatwind_right_night) != null) {
            findViewById(R.id.air_sp_seatwind_right_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_seatmassage_right_night) != null) {
            findViewById(R.id.air_sp_seatmassage_right_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_sync_night) != null) {
            findViewById(R.id.air_sp_sync_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_front_night) != null) {
            findViewById(R.id.air_sp_front_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_auto_night) != null) {
            findViewById(R.id.air_sp_auto_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_ac_night) != null) {
            findViewById(R.id.air_sp_ac_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_rear_night) != null) {
            findViewById(R.id.air_sp_rear_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_cycle_night) != null) {
            findViewById(R.id.air_sp_cycle_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_temp_rearleft_plus_night) != null) {
            findViewById(R.id.air_sp_temp_rearleft_plus_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_tempunit_rearleft_night) != null) {
            findViewById(R.id.air_sp_tempunit_rearleft_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_rear_blow_body_foot_night) != null) {
            findViewById(R.id.air_sp_rear_blow_body_foot_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_rear_blow_foot_night) != null) {
            findViewById(R.id.air_sp_rear_blow_foot_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_rear_blow_body_night) != null) {
            findViewById(R.id.air_sp_rear_blow_body_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_rear_wind_minuts_night) != null) {
            findViewById(R.id.air_sp_rear_wind_minuts_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_rear_wind_plus_night) != null) {
            findViewById(R.id.air_sp_rear_wind_plus_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_temp_rearright_plus_night) != null) {
            findViewById(R.id.air_sp_temp_rearright_plus_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_temp_rearright_minus_night) != null) {
            findViewById(R.id.air_sp_temp_rearright_minus_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_sync_rear_night) != null) {
            findViewById(R.id.air_sp_sync_rear_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_rearlock_rear_night) != null) {
            findViewById(R.id.air_sp_rearlock_rear_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_power_rear_night) != null) {
            findViewById(R.id.air_sp_power_rear_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_auto_rear_night) != null) {
            findViewById(R.id.air_sp_auto_rear_night).setOnTouchListener(this);
        }
        if (findViewById(R.id.air_sp_ac_rear_night) != null) {
            findViewById(R.id.air_sp_ac_rear_night).setOnTouchListener(this);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addUpdater();
        AirHelper.disableAirWindowLocal(true);
        if (this.pagenum == 1) {
            if (DataCanbus.DATA[112] == 0) {
                findViewById(R.id.veiw_air_front).setVisibility(8);
                findViewById(R.id.veiw_air_rear).setVisibility(0);
                findViewById(R.id.tv_sp_front).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_front_n);
                findViewById(R.id.tv_sp_rear).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_rear_p);
            } else {
                findViewById(R.id.veiw_air_front_night).setVisibility(8);
                findViewById(R.id.veiw_air_rear_night).setVisibility(0);
                findViewById(R.id.tv_sp_front_night).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_front_night_n);
                findViewById(R.id.tv_sp_rear_night).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_rear_night_p);
            }
        } else if (DataCanbus.DATA[112] == 0) {
            findViewById(R.id.veiw_air_front).setVisibility(0);
            findViewById(R.id.veiw_air_rear).setVisibility(8);
            findViewById(R.id.tv_sp_front).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_front_p);
            findViewById(R.id.tv_sp_rear).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_rear_n);
        } else {
            findViewById(R.id.veiw_air_front_night).setVisibility(0);
            findViewById(R.id.veiw_air_rear_night).setVisibility(8);
            findViewById(R.id.tv_sp_front_night).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_front_night_p);
            findViewById(R.id.tv_sp_rear_night).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_rear_night_n);
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_456_LZ_YL_Silverado_14_Hand_7Screen /* 5308872 */:
            case FinalCanbus.CAR_456_LZ_YL_Silverado_14_Auto_7Screen /* 5374408 */:
            case FinalCanbus.CAR_456_LZ_YL_Elynx_Silverado_14_Hand_4Screen /* 14287304 */:
            case FinalCanbus.CAR_456_LZ_YL_Elynx_Sierra_14_Hand_4Screen /* 14352840 */:
            case FinalCanbus.CAR_456_LZ_YL_Elynx_Silverado_14_Auto_8Screen /* 14418376 */:
            case FinalCanbus.CAR_456_LZ_YL_Elynx_Sierra_14_Auto_8Screen /* 14483912 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_4Screen /* 15729095 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_4Screen /* 15794631 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_8Screen /* 15860167 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_8Screen /* 15925703 */:
                findViewById(R.id.layout_dayview).setBackgroundResource(R.drawable.bk_air_lzyl_gmc_silverado);
                findViewById(R.id.layout_nightview).setBackgroundResource(R.drawable.bk_air_lzyl_gmc_silverado_night);
                break;
            case FinalCanbus.CAR_456_6606_LZ_GMC_Tahoe_Screen /* 9961928 */:
            case FinalCanbus.CAR_456_6606_LZ_GMC_Tahoe_Screen2 /* 10027464 */:
            case FinalCanbus.CAR_456_6606_LZ_GMC_Suburban_Screen /* 10093000 */:
            case FinalCanbus.CAR_456_6606_LZ_GMC_Suburban_Screen2 /* 10158536 */:
            case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Tahoe_Screen /* 11403720 */:
            case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Suburban_Screen /* 11469256 */:
            case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Tahoe_Screen2 /* 11534792 */:
            case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Suburban_Screen2 /* 11600328 */:
            case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Yukon_Screen2 /* 11665864 */:
            case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
            case FinalCanbus.CAR_456_LZ_GMC_Tahoe_Screen /* 12255688 */:
            case FinalCanbus.CAR_456_LZ_GMC_Tahoe_Screen2 /* 12321224 */:
                findViewById(R.id.layout_dayview).setBackgroundResource(R.drawable.bk_air_lzyl_gmc2);
                findViewById(R.id.layout_nightview).setBackgroundResource(R.drawable.bk_air_lzyl_gmc2_night);
                break;
            default:
                findViewById(R.id.layout_dayview).setBackgroundResource(R.drawable.bk_air_lzyl_gmc);
                findViewById(R.id.layout_nightview).setBackgroundResource(R.drawable.bk_air_lzyl_gmc_night);
                break;
        }
        if (DataCanbus.DATA[112] == 1) {
            findViewById(R.id.layout_dayview).setVisibility(8);
            findViewById(R.id.layout_nightview).setVisibility(0);
        } else {
            findViewById(R.id.layout_dayview).setVisibility(0);
            findViewById(R.id.layout_nightview).setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeUpdater();
        ConstAllAirDara.JumpNewAir = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateDayNight() {
        int acOn = DataCanbus.DATA[112];
        if (acOn == 1) {
            if (this.pagenum == 1) {
                if (DataCanbus.DATA[112] == 0) {
                    findViewById(R.id.veiw_air_front).setVisibility(8);
                    findViewById(R.id.veiw_air_rear).setVisibility(0);
                    findViewById(R.id.tv_sp_front).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_front_n);
                    findViewById(R.id.tv_sp_rear).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_rear_p);
                } else {
                    findViewById(R.id.veiw_air_front_night).setVisibility(8);
                    findViewById(R.id.veiw_air_rear_night).setVisibility(0);
                    findViewById(R.id.tv_sp_front_night).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_front_night_n);
                    findViewById(R.id.tv_sp_rear_night).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_rear_night_p);
                }
            } else if (DataCanbus.DATA[112] == 0) {
                findViewById(R.id.veiw_air_front).setVisibility(0);
                findViewById(R.id.veiw_air_rear).setVisibility(8);
                findViewById(R.id.tv_sp_front).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_front_p);
                findViewById(R.id.tv_sp_rear).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_rear_n);
            } else {
                findViewById(R.id.veiw_air_front_night).setVisibility(0);
                findViewById(R.id.veiw_air_rear_night).setVisibility(8);
                findViewById(R.id.tv_sp_front_night).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_front_night_p);
                findViewById(R.id.tv_sp_rear_night).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_rear_night_n);
            }
            findViewById(R.id.layout_dayview).setVisibility(8);
            findViewById(R.id.layout_nightview).setVisibility(0);
            return;
        }
        if (this.pagenum == 1) {
            if (DataCanbus.DATA[112] == 0) {
                findViewById(R.id.veiw_air_front).setVisibility(8);
                findViewById(R.id.veiw_air_rear).setVisibility(0);
                findViewById(R.id.tv_sp_front).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_front_n);
                findViewById(R.id.tv_sp_rear).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_rear_p);
            } else {
                findViewById(R.id.veiw_air_front_night).setVisibility(8);
                findViewById(R.id.veiw_air_rear_night).setVisibility(0);
                findViewById(R.id.tv_sp_front_night).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_front_night_n);
                findViewById(R.id.tv_sp_rear_night).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_rear_night_p);
            }
        } else if (DataCanbus.DATA[112] == 0) {
            findViewById(R.id.veiw_air_front).setVisibility(0);
            findViewById(R.id.veiw_air_rear).setVisibility(8);
            findViewById(R.id.tv_sp_front).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_front_p);
            findViewById(R.id.tv_sp_rear).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_rear_n);
        } else {
            findViewById(R.id.veiw_air_front_night).setVisibility(0);
            findViewById(R.id.veiw_air_rear_night).setVisibility(8);
            findViewById(R.id.tv_sp_front_night).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_front_night_p);
            findViewById(R.id.tv_sp_rear_night).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_rear_night_n);
        }
        findViewById(R.id.layout_dayview).setVisibility(0);
        findViewById(R.id.layout_nightview).setVisibility(8);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 255;
        switch (id) {
            case R.id.tv_sp_front /* 2131427507 */:
                this.pagenum = 0;
                findViewById(R.id.veiw_air_front).setVisibility(0);
                findViewById(R.id.veiw_air_rear).setVisibility(8);
                findViewById(R.id.tv_sp_front).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_front_p);
                findViewById(R.id.tv_sp_rear).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_rear_n);
                break;
            case R.id.tv_sp_rear /* 2131427508 */:
                this.pagenum = 1;
                findViewById(R.id.veiw_air_front).setVisibility(8);
                findViewById(R.id.veiw_air_rear).setVisibility(0);
                findViewById(R.id.tv_sp_front).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_front_n);
                findViewById(R.id.tv_sp_rear).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_rear_p);
                break;
            case R.id.air_sp_temp_left_plus /* 2131427510 */:
            case R.id.air_sp_temp_left_plus_night /* 2131428705 */:
                data0 = 1;
                break;
            case R.id.air_sp_temp_left_munits /* 2131427511 */:
            case R.id.air_sp_temp_left_munits_night /* 2131428707 */:
                data0 = 2;
                break;
            case R.id.air_sp_wind_minuts /* 2131427514 */:
            case R.id.air_sp_wind_minuts_night /* 2131428712 */:
                data0 = 6;
                break;
            case R.id.air_sp_wind_plus /* 2131427516 */:
            case R.id.air_sp_wind_plus_night /* 2131428714 */:
                data0 = 5;
                break;
            case R.id.air_sp_temp_right_plus /* 2131427517 */:
            case R.id.air_sp_temp_right_plus_night /* 2131428715 */:
                data0 = 3;
                break;
            case R.id.air_sp_temp_right_munits /* 2131427518 */:
            case R.id.air_sp_temp_right_munits_night /* 2131428717 */:
                data0 = 4;
                break;
            case R.id.air_sp_seatheat_left /* 2131427519 */:
            case R.id.air_sp_seatheat_left_night /* 2131428746 */:
                data0 = 30;
                break;
            case R.id.air_sp_seatwind_left /* 2131427520 */:
            case R.id.air_sp_seatwind_left_night /* 2131428748 */:
                data0 = 31;
                break;
            case R.id.air_sp_power /* 2131427522 */:
            case R.id.air_sp_power_night /* 2131428718 */:
                data0 = 7;
                break;
            case R.id.air_sp_seatwind_right /* 2131427524 */:
            case R.id.air_sp_seatwind_right_night /* 2131428749 */:
                data0 = 34;
                break;
            case R.id.air_sp_seatheat_right /* 2131427525 */:
            case R.id.air_sp_seatheat_right_night /* 2131428751 */:
                data0 = 33;
                break;
            case R.id.air_sp_front /* 2131427527 */:
            case R.id.air_sp_front_night /* 2131428720 */:
                data0 = 12;
                break;
            case R.id.air_sp_auto /* 2131427528 */:
            case R.id.air_sp_auto_night /* 2131428721 */:
                data0 = 11;
                break;
            case R.id.air_sp_ac /* 2131427529 */:
            case R.id.air_sp_ac_rear /* 2131428700 */:
            case R.id.air_sp_ac_night /* 2131428722 */:
            case R.id.air_sp_ac_rear_night /* 2131428742 */:
                data0 = 9;
                break;
            case R.id.air_sp_rear /* 2131427530 */:
            case R.id.air_sp_rear_night /* 2131428723 */:
                data0 = 13;
                break;
            case R.id.air_sp_cycle /* 2131427531 */:
            case R.id.air_sp_cycle_night /* 2131428724 */:
                data0 = 10;
                break;
            case R.id.air_sp_temp_rearleft_plus /* 2131427533 */:
            case R.id.air_sp_temp_rearleft_plus_night /* 2131428726 */:
                data0 = 19;
                break;
            case R.id.air_sp_tempunit_rearleft /* 2131427535 */:
            case R.id.air_sp_tempunit_rearleft_night /* 2131428728 */:
                data0 = 20;
                break;
            case R.id.air_sp_rear_wind_minuts /* 2131427537 */:
            case R.id.air_sp_rear_wind_minuts_night /* 2131428732 */:
                data0 = 22;
                break;
            case R.id.air_sp_rear_wind_plus /* 2131427539 */:
            case R.id.air_sp_rear_wind_plus_night /* 2131428734 */:
                data0 = 21;
                break;
            case R.id.air_sp_temp_rearright_plus /* 2131427540 */:
            case R.id.air_sp_temp_rearright_plus_night /* 2131428735 */:
                data0 = 19;
                break;
            case R.id.air_sp_temp_rearright_minus /* 2131427542 */:
            case R.id.air_sp_temp_rearright_minus_night /* 2131428737 */:
                data0 = 20;
                break;
            case R.id.air_sp_rearlock_rear /* 2131427543 */:
            case R.id.air_sp_rearlock_rear_night /* 2131428739 */:
                data0 = 29;
                break;
            case R.id.air_sp_power_rear /* 2131427544 */:
            case R.id.air_sp_power_rear_night /* 2131428740 */:
                data0 = 26;
                break;
            case R.id.air_sp_auto_rear /* 2131427545 */:
            case R.id.air_sp_auto_rear_night /* 2131428741 */:
                data0 = 28;
                break;
            case R.id.air_sp_blow_foot /* 2131428070 */:
            case R.id.air_sp_blow_foot_night /* 2131428709 */:
                data0 = 15;
                break;
            case R.id.air_sp_blow_body /* 2131428071 */:
            case R.id.air_sp_blow_body_night /* 2131428710 */:
                data0 = 14;
                break;
            case R.id.air_sp_blow_body_foot /* 2131428072 */:
                data0 = 17;
                break;
            case R.id.air_sp_blow_foot_win /* 2131428073 */:
                data0 = 18;
                break;
            case R.id.air_sp_sync /* 2131428076 */:
            case R.id.air_sp_sync_night /* 2131428719 */:
                data0 = 8;
                break;
            case R.id.air_sp_rear_blow_body_foot /* 2131428077 */:
            case R.id.air_sp_rear_blow_body_foot_night /* 2131428731 */:
                data0 = 25;
                break;
            case R.id.air_sp_rear_blow_foot /* 2131428078 */:
            case R.id.air_sp_rear_blow_foot_night /* 2131428729 */:
                data0 = 24;
                break;
            case R.id.air_sp_rear_blow_body /* 2131428079 */:
            case R.id.air_sp_rear_blow_body_night /* 2131428730 */:
                data0 = 23;
                break;
            case R.id.air_sp_sync_rear /* 2131428080 */:
            case R.id.air_sp_sync_rear_night /* 2131428738 */:
                data0 = 27;
                break;
            case R.id.air_sp_blow_win /* 2131428563 */:
            case R.id.air_sp_blow_win_night /* 2131428745 */:
                data0 = 16;
                break;
            case R.id.tv_sp_front_night /* 2131428702 */:
                this.pagenum = 0;
                findViewById(R.id.veiw_air_front_night).setVisibility(0);
                findViewById(R.id.veiw_air_rear_night).setVisibility(8);
                findViewById(R.id.tv_sp_front_night).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_front_night_p);
                findViewById(R.id.tv_sp_rear_night).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_rear_night_n);
                break;
            case R.id.tv_sp_rear_night /* 2131428703 */:
                this.pagenum = 1;
                findViewById(R.id.veiw_air_front_night).setVisibility(8);
                findViewById(R.id.veiw_air_rear_night).setVisibility(0);
                findViewById(R.id.tv_sp_front_night).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_front_night_n);
                findViewById(R.id.tv_sp_rear_night).setBackgroundResource(R.drawable.ic_lzyl_gmcscreen_rear_night_p);
                break;
            case R.id.air_sp_seatmassage_left /* 2131428743 */:
            case R.id.air_sp_seatmassage_left_night /* 2131428747 */:
                data0 = 32;
                break;
            case R.id.air_sp_seatmassage_right /* 2131428744 */:
            case R.id.air_sp_seatmassage_right_night /* 2131428750 */:
                data0 = 35;
                break;
        }
        if (data0 != 255) {
            if (event.getAction() == 0) {
                sendCmd(1, data0);
            } else if (event.getAction() == 1) {
                sendCmd(1, 0);
            }
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int temp;
        int temp2 = DataCanbus.DATA[27];
        int unit = DataCanbus.DATA[37];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            switch (temp2) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                    ((TextView) findViewById(R.id.tv_air_temp_left_night)).setText("HI");
                    break;
                case -2:
                case 0:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LO");
                    ((TextView) findViewById(R.id.tv_air_temp_left_night)).setText("LO");
                    break;
                case -1:
                default:
                    if (temp2 >= 1 && temp2 <= 16) {
                        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                            temp = ((temp2 + 15) * 18) + 320;
                        } else {
                            temp = (temp2 * 10) + 150;
                        }
                    } else if (unit == 0 && SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp2 * 9) + 320;
                    } else {
                        temp = temp2 * 5;
                    }
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1 || unit == 1) {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText(new StringBuilder(String.valueOf(temp / 10)).toString());
                        ((TextView) findViewById(R.id.tv_air_temp_left_night)).setText(new StringBuilder(String.valueOf(temp / 10)).toString());
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText(String.valueOf(temp / 10) + "." + (temp % 10));
                        ((TextView) findViewById(R.id.tv_air_temp_left_night)).setText(String.valueOf(temp / 10) + "." + (temp % 10));
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTempRight() {
        int temp;
        int temp2 = DataCanbus.DATA[28];
        int unit = DataCanbus.DATA[37];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            switch (temp2) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                    ((TextView) findViewById(R.id.tv_air_temp_right_night)).setText("HI");
                    break;
                case -2:
                case 0:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LO");
                    ((TextView) findViewById(R.id.tv_air_temp_right_night)).setText("LO");
                    break;
                case -1:
                default:
                    if (temp2 >= 1 && temp2 <= 16) {
                        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                            temp = ((temp2 + 15) * 18) + 320;
                        } else {
                            temp = (temp2 * 10) + 150;
                        }
                    } else if (unit == 0 && SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp2 * 9) + 320;
                    } else {
                        temp = temp2 * 5;
                    }
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1 || unit == 1) {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText(new StringBuilder(String.valueOf(temp / 10)).toString());
                        ((TextView) findViewById(R.id.tv_air_temp_right_night)).setText(new StringBuilder(String.valueOf(temp / 10)).toString());
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText(String.valueOf(temp / 10) + "." + (temp % 10));
                        ((TextView) findViewById(R.id.tv_air_temp_right_night)).setText(String.valueOf(temp / 10) + "." + (temp % 10));
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearTemp() {
        int temp;
        int temp2 = DataCanbus.DATA[40];
        int unit = DataCanbus.DATA[37];
        if (((TextView) findViewById(R.id.air_sp_tempvalue_rearleft)) != null) {
            switch (temp2) {
                case -3:
                    ((TextView) findViewById(R.id.air_sp_tempvalue_rearleft)).setText("HI");
                    ((TextView) findViewById(R.id.air_sp_tempvalue_rearright)).setText("HI");
                    ((TextView) findViewById(R.id.air_sp_tempvalue_rearleft_night)).setText("HI");
                    ((TextView) findViewById(R.id.air_sp_tempvalue_rearright_night)).setText("HI");
                    break;
                case -2:
                case 0:
                    ((TextView) findViewById(R.id.air_sp_tempvalue_rearleft)).setText("LO");
                    ((TextView) findViewById(R.id.air_sp_tempvalue_rearright)).setText("LO");
                    ((TextView) findViewById(R.id.air_sp_tempvalue_rearleft_night)).setText("LO");
                    ((TextView) findViewById(R.id.air_sp_tempvalue_rearright_night)).setText("LO");
                    break;
                case -1:
                default:
                    if (temp2 >= 1 && temp2 <= 16) {
                        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                            temp = ((temp2 + 15) * 18) + 320;
                        } else {
                            temp = (temp2 * 10) + 150;
                        }
                    } else if (unit == 0 && SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp2 * 9) + 320;
                    } else {
                        temp = temp2 * 5;
                    }
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1 || unit == 1) {
                        ((TextView) findViewById(R.id.air_sp_tempvalue_rearleft)).setText(new StringBuilder(String.valueOf(temp / 10)).toString());
                        ((TextView) findViewById(R.id.air_sp_tempvalue_rearright)).setText(new StringBuilder(String.valueOf(temp / 10)).toString());
                        ((TextView) findViewById(R.id.air_sp_tempvalue_rearleft_night)).setText(new StringBuilder(String.valueOf(temp / 10)).toString());
                        ((TextView) findViewById(R.id.air_sp_tempvalue_rearright_night)).setText(new StringBuilder(String.valueOf(temp / 10)).toString());
                    } else {
                        ((TextView) findViewById(R.id.air_sp_tempvalue_rearleft)).setText(String.valueOf(temp / 10) + "." + (temp % 10));
                        ((TextView) findViewById(R.id.air_sp_tempvalue_rearright)).setText(String.valueOf(temp / 10) + "." + (temp % 10));
                        ((TextView) findViewById(R.id.air_sp_tempvalue_rearleft_night)).setText(String.valueOf(temp / 10) + "." + (temp % 10));
                        ((TextView) findViewById(R.id.air_sp_tempvalue_rearright_night)).setText(String.valueOf(temp / 10) + "." + (temp % 10));
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int value = DataCanbus.DATA[21];
        switch (value) {
            case 0:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_0);
                findViewById(R.id.air_sp_wind_lev_night).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_night_0);
                break;
            case 1:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_1);
                findViewById(R.id.air_sp_wind_lev_night).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_night_1);
                break;
            case 2:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_2);
                findViewById(R.id.air_sp_wind_lev_night).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_night_2);
                break;
            case 3:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_3);
                findViewById(R.id.air_sp_wind_lev_night).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_night_3);
                break;
            case 4:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_4);
                findViewById(R.id.air_sp_wind_lev_night).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_night_4);
                break;
            case 5:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_5);
                findViewById(R.id.air_sp_wind_lev_night).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_night_5);
                break;
            case 6:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_6);
                findViewById(R.id.air_sp_wind_lev_night).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_night_6);
                break;
            case 7:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_7);
                findViewById(R.id.air_sp_wind_lev_night).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_night_7);
                break;
            case 8:
                findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_8);
                findViewById(R.id.air_sp_wind_lev_night).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_night_8);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelRear() {
        int value = DataCanbus.DATA[44];
        switch (value) {
            case 0:
                findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_0);
                findViewById(R.id.air_sp_rear_wind_lev_night).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_night_0);
                break;
            case 1:
                findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_1);
                findViewById(R.id.air_sp_rear_wind_lev_night).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_night_1);
                break;
            case 2:
                findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_2);
                findViewById(R.id.air_sp_rear_wind_lev_night).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_night_2);
                break;
            case 3:
                findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_3);
                findViewById(R.id.air_sp_rear_wind_lev_night).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_night_3);
                break;
            case 4:
                findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_4);
                findViewById(R.id.air_sp_rear_wind_lev_night).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_night_4);
                break;
            case 5:
                findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_5);
                findViewById(R.id.air_sp_rear_wind_lev_night).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_night_5);
                break;
            case 6:
                findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_6);
                findViewById(R.id.air_sp_rear_wind_lev_night).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_night_6);
                break;
            case 7:
                findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_7);
                findViewById(R.id.air_sp_rear_wind_lev_night).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_night_7);
                break;
            case 8:
                findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_8);
                findViewById(R.id.air_sp_rear_wind_lev_night).setBackgroundResource(R.drawable.ic_air_lzyl_gmscreen_wind_night_8);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateMassageLeft() {
        int vel = DataCanbus.DATA[93];
        if (findViewById(R.id.air_sp_seatmassage_left) != null) {
            switch (vel) {
                case 0:
                    findViewById(R.id.air_sp_seatmassage_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatmassage_0);
                    findViewById(R.id.air_sp_seatmassage_left_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatmassage_night_0);
                    break;
                case 1:
                    findViewById(R.id.air_sp_seatmassage_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatmassage_1);
                    findViewById(R.id.air_sp_seatmassage_left_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatmassage_night_1);
                    break;
                case 2:
                    findViewById(R.id.air_sp_seatmassage_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatmassage_2);
                    findViewById(R.id.air_sp_seatmassage_left_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatmassage_night_2);
                    break;
                case 3:
                    findViewById(R.id.air_sp_seatmassage_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatmassage_3);
                    findViewById(R.id.air_sp_seatmassage_left_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatmassage_night_3);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateMassageRight() {
        int vel = DataCanbus.DATA[94];
        if (findViewById(R.id.air_sp_seatmassage_right) != null) {
            switch (vel) {
                case 0:
                    findViewById(R.id.air_sp_seatmassage_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatmassage_right0);
                    findViewById(R.id.air_sp_seatmassage_right_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatmassage_night_right0);
                    break;
                case 1:
                    findViewById(R.id.air_sp_seatmassage_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatmassage_right1);
                    findViewById(R.id.air_sp_seatmassage_right_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatmassage_night_right1);
                    break;
                case 2:
                    findViewById(R.id.air_sp_seatmassage_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatmassage_right2);
                    findViewById(R.id.air_sp_seatmassage_right_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatmassage_night_right2);
                    break;
                case 3:
                    findViewById(R.id.air_sp_seatmassage_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatmassage_right3);
                    findViewById(R.id.air_sp_seatmassage_right_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatmassage_night_right3);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateHeatLeft() {
        int vel = DataCanbus.DATA[29];
        if (findViewById(R.id.air_sp_seatheat_left) != null) {
            if ((vel & 8) != 0) {
                int vel2 = 16 - vel;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_456_LZ_YL_Chevrolet_Silverado_19_Screen1 /* 1442248 */:
                    case FinalCanbus.CAR_455_LZ_GMC_Sierra_19_RScreen /* 1507783 */:
                    case FinalCanbus.CAR_456_LZ_YL_Chevrolet_Silverado_19_Screen2 /* 1507784 */:
                    case FinalCanbus.CAR_455_LZ_Chevrolet_Silverado_19_RScreen /* 1573319 */:
                    case FinalCanbus.CAR_456_LZ_YL_Chevrolet_Silverado_19_Screen3 /* 1573320 */:
                    case FinalCanbus.CAR_456_LZ_YL_Chevrolet_Silverado_22_Screen4 /* 1638856 */:
                    case FinalCanbus.CAR_456_LZ_HY_Chevrolet_Silverado_19_Screen1 /* 6291912 */:
                    case FinalCanbus.CAR_456_LZ_HY_Chevrolet_Silverado_19_Screen2 /* 6357448 */:
                    case FinalCanbus.CAR_456_LZ_HY_Chevrolet_Silverado_19_Screen3 /* 6422984 */:
                    case FinalCanbus.CAR_456_LZ_HY_Chevrolet_Silverado_22_Screen4 /* 6488520 */:
                    case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_Screen /* 9437639 */:
                    case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_Screen /* 9503175 */:
                    case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_RScreen /* 9568711 */:
                    case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_RScreen /* 9634247 */:
                    case FinalCanbus.CAR_456_6606_LZ_GMC_Tahoe_Screen /* 9961928 */:
                    case FinalCanbus.CAR_456_6606_LZ_GMC_Tahoe_Screen2 /* 10027464 */:
                    case FinalCanbus.CAR_456_6606_LZ_GMC_Suburban_Screen /* 10093000 */:
                    case FinalCanbus.CAR_456_6606_LZ_GMC_Suburban_Screen2 /* 10158536 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_19_Screen1 /* 10617288 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_19_Screen2 /* 10682824 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_19_Screen3 /* 10748360 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_22_Screen4 /* 10813896 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_19_Screen1 /* 10879432 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_19_Screen2 /* 10944968 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_19_Screen3 /* 11010504 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_22_Screen4 /* 11076040 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_22_Screen5 /* 11141576 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_22_Screen6 /* 11207112 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_22_Screen5 /* 11272648 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_22_Screen6 /* 11338184 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Tahoe_Screen /* 11403720 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Suburban_Screen /* 11469256 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Tahoe_Screen2 /* 11534792 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Suburban_Screen2 /* 11600328 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Yukon_Screen2 /* 11665864 */:
                    case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
                    case FinalCanbus.CAR_454_LZ_Chevrolet_Silverado_19_Screen /* 11993542 */:
                    case FinalCanbus.CAR_456_LZ_GMC_Tahoe_Screen /* 12255688 */:
                    case FinalCanbus.CAR_456_LZ_GMC_Tahoe_Screen2 /* 12321224 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_14_Screen /* 14025160 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_14_Screen1 /* 14090696 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_14_Screen /* 14156232 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_14_Screen1 /* 14221768 */:
                        findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_allseatheat_0);
                        findViewById(R.id.air_sp_seatheat_left_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_allseatheat_night_0);
                        break;
                    default:
                        findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_0);
                        findViewById(R.id.air_sp_seatheat_left_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_night_0);
                        break;
                }
                switch (vel2) {
                    case 1:
                        findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_1);
                        findViewById(R.id.air_sp_seatwind_left_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_night_1);
                        break;
                    case 2:
                        findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_2);
                        findViewById(R.id.air_sp_seatwind_left_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_night_2);
                        break;
                    case 3:
                        findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_3);
                        findViewById(R.id.air_sp_seatwind_left_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_night_3);
                        break;
                }
            }
            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_0);
            findViewById(R.id.air_sp_seatwind_left_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_night_0);
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_456_LZ_YL_Chevrolet_Silverado_19_Screen1 /* 1442248 */:
                case FinalCanbus.CAR_455_LZ_GMC_Sierra_19_RScreen /* 1507783 */:
                case FinalCanbus.CAR_456_LZ_YL_Chevrolet_Silverado_19_Screen2 /* 1507784 */:
                case FinalCanbus.CAR_455_LZ_Chevrolet_Silverado_19_RScreen /* 1573319 */:
                case FinalCanbus.CAR_456_LZ_YL_Chevrolet_Silverado_19_Screen3 /* 1573320 */:
                case FinalCanbus.CAR_456_LZ_YL_Chevrolet_Silverado_22_Screen4 /* 1638856 */:
                case FinalCanbus.CAR_456_LZ_HY_Chevrolet_Silverado_19_Screen1 /* 6291912 */:
                case FinalCanbus.CAR_456_LZ_HY_Chevrolet_Silverado_19_Screen2 /* 6357448 */:
                case FinalCanbus.CAR_456_LZ_HY_Chevrolet_Silverado_19_Screen3 /* 6422984 */:
                case FinalCanbus.CAR_456_LZ_HY_Chevrolet_Silverado_22_Screen4 /* 6488520 */:
                case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_Screen /* 9437639 */:
                case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_Screen /* 9503175 */:
                case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_RScreen /* 9568711 */:
                case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_RScreen /* 9634247 */:
                case FinalCanbus.CAR_456_6606_LZ_GMC_Tahoe_Screen /* 9961928 */:
                case FinalCanbus.CAR_456_6606_LZ_GMC_Tahoe_Screen2 /* 10027464 */:
                case FinalCanbus.CAR_456_6606_LZ_GMC_Suburban_Screen /* 10093000 */:
                case FinalCanbus.CAR_456_6606_LZ_GMC_Suburban_Screen2 /* 10158536 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_19_Screen1 /* 10617288 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_19_Screen2 /* 10682824 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_19_Screen3 /* 10748360 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_22_Screen4 /* 10813896 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_19_Screen1 /* 10879432 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_19_Screen2 /* 10944968 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_19_Screen3 /* 11010504 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_22_Screen4 /* 11076040 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_22_Screen5 /* 11141576 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_22_Screen6 /* 11207112 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_22_Screen5 /* 11272648 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_22_Screen6 /* 11338184 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Tahoe_Screen /* 11403720 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Suburban_Screen /* 11469256 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Tahoe_Screen2 /* 11534792 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Suburban_Screen2 /* 11600328 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Yukon_Screen2 /* 11665864 */:
                case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
                case FinalCanbus.CAR_454_LZ_Chevrolet_Silverado_19_Screen /* 11993542 */:
                case FinalCanbus.CAR_456_LZ_GMC_Tahoe_Screen /* 12255688 */:
                case FinalCanbus.CAR_456_LZ_GMC_Tahoe_Screen2 /* 12321224 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_14_Screen /* 14025160 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_14_Screen1 /* 14090696 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_14_Screen /* 14156232 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_14_Screen1 /* 14221768 */:
                    switch (vel) {
                        case 0:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_allseatheat_0);
                            findViewById(R.id.air_sp_seatheat_left_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_allseatheat_night_0);
                            break;
                        case 1:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_allseatheat_1);
                            findViewById(R.id.air_sp_seatheat_left_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_allseatheat_night_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_allseatheat_2);
                            findViewById(R.id.air_sp_seatheat_left_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_allseatheat_night_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_allseatheat_3);
                            findViewById(R.id.air_sp_seatheat_left_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_allseatheat_night_3);
                            break;
                    }
                    break;
                default:
                    switch (vel) {
                        case 0:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_0);
                            findViewById(R.id.air_sp_seatheat_left_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_night_0);
                            break;
                        case 1:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_1);
                            findViewById(R.id.air_sp_seatheat_left_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_night_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_2);
                            findViewById(R.id.air_sp_seatheat_left_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_night_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_3);
                            findViewById(R.id.air_sp_seatheat_left_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_night_3);
                            break;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateHeatRight() {
        int vel = DataCanbus.DATA[30];
        if (findViewById(R.id.air_sp_seatheat_right) != null) {
            if ((vel & 8) != 0) {
                int vel2 = 16 - vel;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_456_LZ_YL_Chevrolet_Silverado_19_Screen1 /* 1442248 */:
                    case FinalCanbus.CAR_455_LZ_GMC_Sierra_19_RScreen /* 1507783 */:
                    case FinalCanbus.CAR_456_LZ_YL_Chevrolet_Silverado_19_Screen2 /* 1507784 */:
                    case FinalCanbus.CAR_455_LZ_Chevrolet_Silverado_19_RScreen /* 1573319 */:
                    case FinalCanbus.CAR_456_LZ_YL_Chevrolet_Silverado_19_Screen3 /* 1573320 */:
                    case FinalCanbus.CAR_456_LZ_YL_Chevrolet_Silverado_22_Screen4 /* 1638856 */:
                    case FinalCanbus.CAR_456_LZ_HY_Chevrolet_Silverado_19_Screen1 /* 6291912 */:
                    case FinalCanbus.CAR_456_LZ_HY_Chevrolet_Silverado_19_Screen2 /* 6357448 */:
                    case FinalCanbus.CAR_456_LZ_HY_Chevrolet_Silverado_19_Screen3 /* 6422984 */:
                    case FinalCanbus.CAR_456_LZ_HY_Chevrolet_Silverado_22_Screen4 /* 6488520 */:
                    case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_Screen /* 9437639 */:
                    case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_Screen /* 9503175 */:
                    case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_RScreen /* 9568711 */:
                    case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_RScreen /* 9634247 */:
                    case FinalCanbus.CAR_456_6606_LZ_GMC_Tahoe_Screen /* 9961928 */:
                    case FinalCanbus.CAR_456_6606_LZ_GMC_Tahoe_Screen2 /* 10027464 */:
                    case FinalCanbus.CAR_456_6606_LZ_GMC_Suburban_Screen /* 10093000 */:
                    case FinalCanbus.CAR_456_6606_LZ_GMC_Suburban_Screen2 /* 10158536 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_19_Screen1 /* 10617288 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_19_Screen2 /* 10682824 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_19_Screen3 /* 10748360 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_22_Screen4 /* 10813896 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_19_Screen1 /* 10879432 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_19_Screen2 /* 10944968 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_19_Screen3 /* 11010504 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_22_Screen4 /* 11076040 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_22_Screen5 /* 11141576 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_22_Screen6 /* 11207112 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_22_Screen5 /* 11272648 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_22_Screen6 /* 11338184 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Tahoe_Screen /* 11403720 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Suburban_Screen /* 11469256 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Tahoe_Screen2 /* 11534792 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Suburban_Screen2 /* 11600328 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Yukon_Screen2 /* 11665864 */:
                    case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
                    case FinalCanbus.CAR_454_LZ_Chevrolet_Silverado_19_Screen /* 11993542 */:
                    case FinalCanbus.CAR_456_LZ_GMC_Tahoe_Screen /* 12255688 */:
                    case FinalCanbus.CAR_456_LZ_GMC_Tahoe_Screen2 /* 12321224 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_14_Screen /* 14025160 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_14_Screen1 /* 14090696 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_14_Screen /* 14156232 */:
                    case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_14_Screen1 /* 14221768 */:
                        findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_allseatheat_right0);
                        findViewById(R.id.air_sp_seatheat_right_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_allseatheat_night_right0);
                        break;
                    default:
                        findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_right0);
                        findViewById(R.id.air_sp_seatheat_right_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_night_right0);
                        break;
                }
                switch (vel2) {
                    case 1:
                        findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_right1);
                        findViewById(R.id.air_sp_seatwind_right_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_night_right1);
                        break;
                    case 2:
                        findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_right2);
                        findViewById(R.id.air_sp_seatwind_right_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_night_right2);
                        break;
                    case 3:
                        findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_right3);
                        findViewById(R.id.air_sp_seatwind_right_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_night_right3);
                        break;
                }
            }
            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_right0);
            findViewById(R.id.air_sp_seatwind_right_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatwind_night_right0);
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_456_LZ_YL_Chevrolet_Silverado_19_Screen1 /* 1442248 */:
                case FinalCanbus.CAR_455_LZ_GMC_Sierra_19_RScreen /* 1507783 */:
                case FinalCanbus.CAR_456_LZ_YL_Chevrolet_Silverado_19_Screen2 /* 1507784 */:
                case FinalCanbus.CAR_455_LZ_Chevrolet_Silverado_19_RScreen /* 1573319 */:
                case FinalCanbus.CAR_456_LZ_YL_Chevrolet_Silverado_19_Screen3 /* 1573320 */:
                case FinalCanbus.CAR_456_LZ_YL_Chevrolet_Silverado_22_Screen4 /* 1638856 */:
                case FinalCanbus.CAR_456_LZ_HY_Chevrolet_Silverado_19_Screen1 /* 6291912 */:
                case FinalCanbus.CAR_456_LZ_HY_Chevrolet_Silverado_19_Screen2 /* 6357448 */:
                case FinalCanbus.CAR_456_LZ_HY_Chevrolet_Silverado_19_Screen3 /* 6422984 */:
                case FinalCanbus.CAR_456_LZ_HY_Chevrolet_Silverado_22_Screen4 /* 6488520 */:
                case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_Screen /* 9437639 */:
                case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_Screen /* 9503175 */:
                case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_RScreen /* 9568711 */:
                case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_RScreen /* 9634247 */:
                case FinalCanbus.CAR_456_6606_LZ_GMC_Tahoe_Screen /* 9961928 */:
                case FinalCanbus.CAR_456_6606_LZ_GMC_Tahoe_Screen2 /* 10027464 */:
                case FinalCanbus.CAR_456_6606_LZ_GMC_Suburban_Screen /* 10093000 */:
                case FinalCanbus.CAR_456_6606_LZ_GMC_Suburban_Screen2 /* 10158536 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_19_Screen1 /* 10617288 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_19_Screen2 /* 10682824 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_19_Screen3 /* 10748360 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_22_Screen4 /* 10813896 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_19_Screen1 /* 10879432 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_19_Screen2 /* 10944968 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_19_Screen3 /* 11010504 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_22_Screen4 /* 11076040 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_22_Screen5 /* 11141576 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_22_Screen6 /* 11207112 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_22_Screen5 /* 11272648 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_22_Screen6 /* 11338184 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Tahoe_Screen /* 11403720 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Suburban_Screen /* 11469256 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Tahoe_Screen2 /* 11534792 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Suburban_Screen2 /* 11600328 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Yukon_Screen2 /* 11665864 */:
                case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
                case FinalCanbus.CAR_454_LZ_Chevrolet_Silverado_19_Screen /* 11993542 */:
                case FinalCanbus.CAR_456_LZ_GMC_Tahoe_Screen /* 12255688 */:
                case FinalCanbus.CAR_456_LZ_GMC_Tahoe_Screen2 /* 12321224 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_14_Screen /* 14025160 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_Chevrolet_Silverado_14_Screen1 /* 14090696 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_14_Screen /* 14156232 */:
                case FinalCanbus.CAR_456_LZ_YL_Elynx_GMC_Sierra_14_Screen1 /* 14221768 */:
                    switch (vel) {
                        case 0:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_allseatheat_right0);
                            findViewById(R.id.air_sp_seatheat_right_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_allseatheat_night_right0);
                            break;
                        case 1:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_allseatheat_right1);
                            findViewById(R.id.air_sp_seatheat_right_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_allseatheat_night_right1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_allseatheat_right2);
                            findViewById(R.id.air_sp_seatheat_right_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_allseatheat_night_right2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_allseatheat_right3);
                            findViewById(R.id.air_sp_seatheat_right_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_allseatheat_night_right3);
                            break;
                    }
                    break;
                default:
                    switch (vel) {
                        case 0:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_right0);
                            findViewById(R.id.air_sp_seatheat_right_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_night_right0);
                            break;
                        case 1:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_right1);
                            findViewById(R.id.air_sp_seatheat_right_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_night_right1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_right2);
                            findViewById(R.id.air_sp_seatheat_right_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_night_right2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_right3);
                            findViewById(R.id.air_sp_seatheat_right_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_seatheat_night_right3);
                            break;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSync() {
        int vel = DataCanbus.DATA[62];
        if (findViewById(R.id.air_sp_sync) != null) {
            findViewById(R.id.air_sp_sync).setBackgroundResource(vel == 0 ? R.drawable.ic_lzyl_gmscreen_sync_n : R.drawable.ic_lzyl_gmscreen_sync_p);
        }
        if (findViewById(R.id.air_sp_sync_night) != null) {
            findViewById(R.id.air_sp_sync_night).setBackgroundResource(vel == 0 ? R.drawable.ic_lzyl_gmscreen_sync_night_n : R.drawable.ic_lzyl_gmscreen_sync_night_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearSync() {
        int vel = DataCanbus.DATA[86];
        if (findViewById(R.id.air_sp_sync_rear) != null) {
            findViewById(R.id.air_sp_sync_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_lzyl_gmscreen_sync_n : R.drawable.ic_lzyl_gmscreen_sync_p);
        }
        if (findViewById(R.id.air_sp_sync_rear_night) != null) {
            findViewById(R.id.air_sp_sync_rear_night).setBackgroundResource(vel == 0 ? R.drawable.ic_lzyl_gmscreen_sync_night_n : R.drawable.ic_lzyl_gmscreen_sync_night_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBackAuto() {
        int vel = DataCanbus.DATA[43];
        if (findViewById(R.id.air_sp_auto_rear) != null) {
            findViewById(R.id.air_sp_auto_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_lzyl_gmscreen_auto_n : R.drawable.ic_lzyl_gmscreen_auto_p);
        }
        if (findViewById(R.id.air_sp_auto_rear_night) != null) {
            findViewById(R.id.air_sp_auto_rear_night).setBackgroundResource(vel == 0 ? R.drawable.ic_lzyl_gmscreen_auto_night_n : R.drawable.ic_lzyl_gmscreen_auto_night_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAuto() {
        int vel = DataCanbus.DATA[13];
        if (findViewById(R.id.air_sp_auto) != null) {
            findViewById(R.id.air_sp_auto).setBackgroundResource(vel == 0 ? R.drawable.ic_lzyl_gmscreen_auto_n : R.drawable.ic_lzyl_gmscreen_auto_p);
        }
        if (findViewById(R.id.air_sp_auto_night) != null) {
            findViewById(R.id.air_sp_auto_night).setBackgroundResource(vel == 0 ? R.drawable.ic_lzyl_gmscreen_auto_night_n : R.drawable.ic_lzyl_gmscreen_auto_night_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearLock() {
        int acOn = DataCanbus.DATA[67];
        if (findViewById(R.id.air_sp_rearlock_rear) != null) {
            findViewById(R.id.air_sp_rearlock_rear).setBackgroundResource(acOn == 0 ? R.drawable.ic_lzyl_gmscreen_lock_n : R.drawable.ic_lzyl_gmscreen_lock_p);
        }
        if (findViewById(R.id.air_sp_rearlock_rear_night) != null) {
            findViewById(R.id.air_sp_rearlock_rear_night).setBackgroundResource(acOn == 0 ? R.drawable.ic_lzyl_gmscreen_lock_night_n : R.drawable.ic_lzyl_gmscreen_lock_night_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcOn() {
        int i = R.drawable.ic_lzyl_gmscreen_ac_night_n;
        int i2 = R.drawable.ic_lzyl_gmscreen_ac_n;
        int acOn = DataCanbus.DATA[11];
        if (findViewById(R.id.air_sp_ac) != null) {
            findViewById(R.id.air_sp_ac).setBackgroundResource(acOn == 0 ? 2130841516 : 2130841519);
        }
        if (findViewById(R.id.air_sp_ac_rear) != null) {
            View viewFindViewById = findViewById(R.id.air_sp_ac_rear);
            if (acOn != 0) {
                i2 = 2130841519;
            }
            viewFindViewById.setBackgroundResource(i2);
        }
        if (findViewById(R.id.air_sp_ac_night) != null) {
            findViewById(R.id.air_sp_ac_night).setBackgroundResource(acOn == 0 ? 2130841517 : 2130841518);
        }
        if (findViewById(R.id.air_sp_ac_rear_night) != null) {
            View viewFindViewById2 = findViewById(R.id.air_sp_ac_rear_night);
            if (acOn != 0) {
                i = 2130841518;
            }
            viewFindViewById2.setBackgroundResource(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        if (findViewById(R.id.air_sp_cycle) != null) {
            findViewById(R.id.air_sp_cycle).setBackgroundResource(cycle == 0 ? R.drawable.ic_lzyl_gmscreen_cycle_n : R.drawable.ic_lzyl_gmscreen_cycle_p);
        }
        if (findViewById(R.id.air_sp_cycle_night) != null) {
            findViewById(R.id.air_sp_cycle_night).setBackgroundResource(cycle == 0 ? R.drawable.ic_lzyl_gmscreen_cycle_night_n : R.drawable.ic_lzyl_gmscreen_cycle_night_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[16];
        if (findViewById(R.id.air_sp_rear) != null) {
            findViewById(R.id.air_sp_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_lzyl_gmscreen_rear_n : R.drawable.ic_lzyl_gmscreen_rear_p);
        }
        if (findViewById(R.id.air_sp_rear_night) != null) {
            findViewById(R.id.air_sp_rear_night).setBackgroundResource(rear == 0 ? R.drawable.ic_lzyl_gmscreen_rear_night_n : R.drawable.ic_lzyl_gmscreen_rear_night_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFrontDefrost() {
        int rear = DataCanbus.DATA[65];
        if (findViewById(R.id.air_sp_front) != null) {
            findViewById(R.id.air_sp_front).setBackgroundResource(rear == 0 ? R.drawable.ic_lzyl_gmscreen_front_n : R.drawable.ic_lzyl_gmscreen_front_p);
        }
        if (findViewById(R.id.air_sp_front_night) != null) {
            findViewById(R.id.air_sp_front_night).setBackgroundResource(rear == 0 ? R.drawable.ic_lzyl_gmscreen_front_night_n : R.drawable.ic_lzyl_gmscreen_front_night_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearPower() {
        int value = DataCanbus.DATA[42];
        if (findViewById(R.id.air_sp_power_rear) != null) {
            findViewById(R.id.air_sp_power_rear).setBackgroundResource(value == 0 ? R.drawable.ic_lzyl_gmscreen_power_n : R.drawable.ic_lzyl_gmscreen_power_p);
        }
        if (findViewById(R.id.air_sp_power_rear_night) != null) {
            findViewById(R.id.air_sp_power_rear_night).setBackgroundResource(value == 0 ? R.drawable.ic_lzyl_gmscreen_power_night_n : R.drawable.ic_lzyl_gmscreen_power_night_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePower() {
        int value = DataCanbus.DATA[10];
        if (findViewById(R.id.air_sp_power) != null) {
            findViewById(R.id.air_sp_power).setBackgroundResource(value == 0 ? R.drawable.ic_lzyl_gmscreen_power_n : R.drawable.ic_lzyl_gmscreen_power_p);
        }
        if (findViewById(R.id.air_sp_power_night) != null) {
            findViewById(R.id.air_sp_power_night).setBackgroundResource(value == 0 ? R.drawable.ic_lzyl_gmscreen_power_night_n : R.drawable.ic_lzyl_gmscreen_power_night_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowBackMode() {
        int mode;
        int mode2;
        int body = DataCanbus.DATA[46];
        int foot = DataCanbus.DATA[47];
        if (body == 1) {
            mode = 0 | 2;
        } else {
            mode = 0 & 253;
        }
        if (foot == 1) {
            mode2 = mode | 1;
        } else {
            mode2 = mode & 254;
        }
        findViewById(R.id.air_sp_rear_blow_body_foot).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_bodyfoot_n);
        findViewById(R.id.air_sp_rear_blow_body_foot_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_bodyfoot_night_n);
        findViewById(R.id.air_sp_rear_blow_foot).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_foot_n);
        findViewById(R.id.air_sp_rear_blow_foot_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_foot_night_n);
        findViewById(R.id.air_sp_rear_blow_body).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_body_n);
        findViewById(R.id.air_sp_rear_blow_body_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_body_night_n);
        switch (mode2) {
            case 1:
                findViewById(R.id.air_sp_rear_blow_foot).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_foot_p);
                findViewById(R.id.air_sp_rear_blow_foot_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_foot_night_p);
                break;
            case 2:
                findViewById(R.id.air_sp_rear_blow_body).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_body_p);
                findViewById(R.id.air_sp_rear_blow_body_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_body_night_p);
                break;
            case 3:
                findViewById(R.id.air_sp_rear_blow_body_foot).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_bodyfoot_p);
                findViewById(R.id.air_sp_rear_blow_body_foot_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_bodyfoot_night_p);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowModeLeft() {
        int mode;
        int mode2;
        int mode3;
        int win = DataCanbus.DATA[18];
        int body = DataCanbus.DATA[19];
        int foot = DataCanbus.DATA[20];
        if (win == 1) {
            mode = 0 | 4;
        } else {
            mode = 0 & 251;
        }
        if (body == 1) {
            mode2 = mode | 2;
        } else {
            mode2 = mode & 253;
        }
        if (foot == 1) {
            mode3 = mode2 | 1;
        } else {
            mode3 = mode2 & 254;
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_456_LZ_YL_Silverado_14_Hand_7Screen /* 5308872 */:
            case FinalCanbus.CAR_456_LZ_YL_Silverado_14_Auto_7Screen /* 5374408 */:
            case FinalCanbus.CAR_456_LZ_YL_Elynx_Silverado_14_Hand_4Screen /* 14287304 */:
            case FinalCanbus.CAR_456_LZ_YL_Elynx_Sierra_14_Hand_4Screen /* 14352840 */:
            case FinalCanbus.CAR_456_LZ_YL_Elynx_Silverado_14_Auto_8Screen /* 14418376 */:
            case FinalCanbus.CAR_456_LZ_YL_Elynx_Sierra_14_Auto_8Screen /* 14483912 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_4Screen /* 15729095 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_4Screen /* 15794631 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_8Screen /* 15860167 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_8Screen /* 15925703 */:
                findViewById(R.id.air_sp_blow_body_foot).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_bodyfoot_n);
                findViewById(R.id.air_sp_blow_foot).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_foot_n);
                findViewById(R.id.air_sp_blow_body).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_body_n);
                findViewById(R.id.air_sp_blow_foot_win).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_footwin_n);
                findViewById(R.id.air_sp_blow_body_foot_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_bodyfoot_night_n);
                findViewById(R.id.air_sp_blow_foot_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_foot_night_n);
                findViewById(R.id.air_sp_blow_body_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_body_night_n);
                findViewById(R.id.air_sp_blow_foot_win_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_footwin_night_n);
                switch (mode3) {
                    case 1:
                        findViewById(R.id.air_sp_blow_foot).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_foot_p);
                        findViewById(R.id.air_sp_blow_foot_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_foot_night_p);
                        break;
                    case 2:
                        findViewById(R.id.air_sp_blow_body).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_body_p);
                        findViewById(R.id.air_sp_blow_body_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_body_night_p);
                        break;
                    case 3:
                        findViewById(R.id.air_sp_blow_body_foot).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_bodyfoot_p);
                        findViewById(R.id.air_sp_blow_body_foot_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_bodyfoot_night_p);
                        break;
                    case 5:
                        findViewById(R.id.air_sp_blow_foot_win).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_footwin_p);
                        findViewById(R.id.air_sp_blow_foot_win_night).setBackgroundResource(R.drawable.ic_lzyl_gmscreen_mode_footwin_night_p);
                        break;
                }
                break;
            default:
                findViewById(R.id.air_sp_blow_foot).setBackgroundResource(foot == 0 ? R.drawable.ic_lzyl_gmscreen_mode_foot_n : R.drawable.ic_lzyl_gmscreen_mode_foot_p);
                findViewById(R.id.air_sp_blow_foot_night).setBackgroundResource(foot == 0 ? R.drawable.ic_lzyl_gmscreen_mode_foot_night_n : R.drawable.ic_lzyl_gmscreen_mode_foot_night_p);
                findViewById(R.id.air_sp_blow_body).setBackgroundResource(body == 0 ? R.drawable.ic_lzyl_gmscreen_mode_body_n : R.drawable.ic_lzyl_gmscreen_mode_body_p);
                findViewById(R.id.air_sp_blow_body_night).setBackgroundResource(body == 0 ? R.drawable.ic_lzyl_gmscreen_mode_body_night_n : R.drawable.ic_lzyl_gmscreen_mode_body_night_p);
                findViewById(R.id.air_sp_blow_win).setBackgroundResource(win == 0 ? R.drawable.ic_lzyl_gmscreen_mode_win_n : R.drawable.ic_lzyl_gmscreen_mode_win_p);
                findViewById(R.id.air_sp_blow_win_night).setBackgroundResource(win == 0 ? R.drawable.ic_lzyl_gmscreen_mode_win_night_n : R.drawable.ic_lzyl_gmscreen_mode_win_night_p);
                break;
        }
    }
}
