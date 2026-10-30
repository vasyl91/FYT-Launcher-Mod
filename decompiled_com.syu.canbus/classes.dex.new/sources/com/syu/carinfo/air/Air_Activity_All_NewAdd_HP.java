package com.syu.carinfo.air;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.ui.air.AirHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Air_Activity_All_NewAdd_HP extends Activity implements View.OnTouchListener {
    public static Air_Activity_All_NewAdd_HP mInstance;
    public static boolean mIsFront = false;
    int pagenum = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.air.Air_Activity_All_NewAdd_HP.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == ConstAllAirDara.U_AIR_AC) {
                Air_Activity_All_NewAdd_HP.this.mUpdateAcOn();
            }
            if (updateCode == ConstAllAirDara.U_AIR_CYCLE) {
                Air_Activity_All_NewAdd_HP.this.mUpdateCycle();
            }
            if (updateCode == ConstAllAirDara.U_AIR_CYCLE_AUTO) {
                Air_Activity_All_NewAdd_HP.this.mUpdateCycle();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR) {
                Air_Activity_All_NewAdd_HP.this.mUpdateRearDefrost();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SWING) {
                Air_Activity_All_NewAdd_HP.this.mUpdateAirSwing();
            }
            if (updateCode == ConstAllAirDara.U_AIR_ECO) {
                Air_Activity_All_NewAdd_HP.this.mUpdateECO();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FLOWER_BLOW) {
                Air_Activity_All_NewAdd_HP.this.mUpdateFlowerBlow();
            }
            if (updateCode == ConstAllAirDara.U_AIR_PARK) {
                Air_Activity_All_NewAdd_HP.this.mUpdateAirPark();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REST) {
                Air_Activity_All_NewAdd_HP.this.mUpdateAirRest();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FRONT_ONLY) {
                Air_Activity_All_NewAdd_HP.this.mUpdateAirOnlyFront();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FRONT_ONLY_F) {
                Air_Activity_All_NewAdd_HP.this.mUpdateAirOnlyFront_F();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR_MANUAL) {
                Air_Activity_All_NewAdd_HP.this.mUpdateAirRearManual();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR_COOL) {
                Air_Activity_All_NewAdd_HP.this.mUpdateAirRearCool();
            }
            if (updateCode == ConstAllAirDara.U_AIR_NANOE) {
                Air_Activity_All_NewAdd_HP.this.mUpdateNanoe();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FRONT) {
                Air_Activity_All_NewAdd_HP.this.mUpdateFrontDefrost();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FRONT_HOT) {
                Air_Activity_All_NewAdd_HP.this.mUpdateFrontHot();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FRONTMAX) {
                Air_Activity_All_NewAdd_HP.this.mUpdateMaxFrontDefrost();
            }
            if (updateCode == ConstAllAirDara.U_AIR_POWER) {
                Air_Activity_All_NewAdd_HP.this.mUpdatePower();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_POWER) {
                Air_Activity_All_NewAdd_HP.this.mUpdatePower();
            }
            if (updateCode == ConstAllAirDara.U_AIR_TEMP_LEFT) {
                Air_Activity_All_NewAdd_HP.this.mUpdateAirTempLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT) {
                Air_Activity_All_NewAdd_HP.this.mUpdaterAirWindLevelLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_AUTO) {
                Air_Activity_All_NewAdd_HP.this.mUpdateAuto();
            }
            if (updateCode == ConstAllAirDara.U_AIR_AUTO_RIGHT) {
                Air_Activity_All_NewAdd_HP.this.mUpdateAutoRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_DUAL) {
                Air_Activity_All_NewAdd_HP.this.mUpdateDual();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SYNC) {
                Air_Activity_All_NewAdd_HP.this.mUpdateSYNC();
            }
            if (updateCode == ConstAllAirDara.U_AIR_ZONE) {
                Air_Activity_All_NewAdd_HP.this.mUpdateZONE();
            }
            if (updateCode == ConstAllAirDara.U_AIR_WAISTHEAT_LEFT) {
                Air_Activity_All_NewAdd_HP.this.mUpdateWaistHeatLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_WAISTHEAT_RIGHT) {
                Air_Activity_All_NewAdd_HP.this.mUpdateWaistHeatRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATHEAT_LEFT || updateCode == ConstAllAirDara.U_AIR_SEATWIND_LEFT) {
                Air_Activity_All_NewAdd_HP.this.mUpdateHeatLeft();
                Air_Activity_All_NewAdd_HP.this.mUpdateWindLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATHEAT_RIGHT || updateCode == ConstAllAirDara.U_AIR_SEATWIND_RIGHT) {
                Air_Activity_All_NewAdd_HP.this.mUpdateHeatRight();
                Air_Activity_All_NewAdd_HP.this.mUpdateWindRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATHEAT_LEFT_REAR) {
                Air_Activity_All_NewAdd_HP.this.mUpdateHeatLeftRear();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATHEAT_RIGHT_REAR) {
                Air_Activity_All_NewAdd_HP.this.mUpdateHeatRightRear();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATWIND_LEFT_REAR) {
                Air_Activity_All_NewAdd_HP.this.mUpdateWindLeftRear();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATWIND_RIGHT_REAR) {
                Air_Activity_All_NewAdd_HP.this.mUpdateWindRightRear();
            }
            if (updateCode == ConstAllAirDara.U_AIR_TEMP_RIGHT) {
                Air_Activity_All_NewAdd_HP.this.mUpdateTempRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_TEMP_UNIT) {
                Air_Activity_All_NewAdd_HP.this.mUpdateTempUNIT();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_TEMP) {
                Air_Activity_All_NewAdd_HP.this.mUpdateBackTemp();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT) {
                Air_Activity_All_NewAdd_HP.this.mUpdateBackTempRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_BLOW_AUTO) {
                Air_Activity_All_NewAdd_HP.this.mUpdateBackAuto();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_AUTO_RIGHT) {
                Air_Activity_All_NewAdd_HP.this.mUpdateBackAutoRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR_LOCK) {
                Air_Activity_All_NewAdd_HP.this.mUpdateBackRearLock();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR_SYNC) {
                Air_Activity_All_NewAdd_HP.this.mUpdateBackRearSync();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR_AC) {
                Air_Activity_All_NewAdd_HP.this.mUpdateBackRearAC();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR_CTRL) {
                Air_Activity_All_NewAdd_HP.this.mUpdateBackRearCtrl();
            }
            if (updateCode == ConstAllAirDara.U_AIR_AQS) {
                Air_Activity_All_NewAdd_HP.this.mUpdateAirAQS();
            }
            if (updateCode == ConstAllAirDara.U_AIR_AC_MAX) {
                Air_Activity_All_NewAdd_HP.this.mUpdateAcMax();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SOFT) {
                Air_Activity_All_NewAdd_HP.this.mUpdateAirSoft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FAST) {
                Air_Activity_All_NewAdd_HP.this.mUpdateAirFast();
            }
            if (updateCode == ConstAllAirDara.U_AIR_NORMAL) {
                Air_Activity_All_NewAdd_HP.this.mUpdateAirNormal();
            }
            if (updateCode == ConstAllAirDara.U_AIR_ION) {
                Air_Activity_All_NewAdd_HP.this.mUpdateIon();
            }
            if (updateCode == ConstAllAirDara.U_AIR_CLEAN) {
                Air_Activity_All_NewAdd_HP.this.mUpdateClean();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOWTOP) {
                Air_Activity_All_NewAdd_HP.this.mUpdateBlowTop();
            }
            if (updateCode == ConstAllAirDara.U_AIR_STEER) {
                Air_Activity_All_NewAdd_HP.this.mUpdateSteerHot();
            }
            if (updateCode == ConstAllAirDara.U_AIR_WINLEV) {
                Air_Activity_All_NewAdd_HP.this.mUpdateAirWinlev();
            }
            if (updateCode == ConstAllAirDara.U_AIR_HEAT) {
                Air_Activity_All_NewAdd_HP.this.mUpdateAirHeat();
            }
            if (updateCode == ConstAllAirDara.U_AIR_PTC) {
                Air_Activity_All_NewAdd_HP.this.mUpdateAirPTC();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_BLOW_WIND) {
                Air_Activity_All_NewAdd_HP.this.mUpdateBackWind();
            }
            if (updateCode == ConstAllAirDara.U_AIR_EM) {
                Air_Activity_All_NewAdd_HP.this.mUpdateAirEm();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_UP_LEFT || updateCode == ConstAllAirDara.U_AIR_BLOW_BODY_LEFT || updateCode == ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT || updateCode == ConstAllAirDara.U_AIR_BLOW_AUTO_LEFT) {
                Air_Activity_All_NewAdd_HP.this.updateBlowModeLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_UP_RIGHT || updateCode == ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT || updateCode == ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT || updateCode == ConstAllAirDara.U_AIR_BLOW_AUTO_RIGHT) {
                Air_Activity_All_NewAdd_HP.this.updateBlowModeRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_BLOW_UP || updateCode == ConstAllAirDara.U_AIR_BACK_BLOW_BODY || updateCode == ConstAllAirDara.U_AIR_BACK_BLOW_FOOT) {
                Air_Activity_All_NewAdd_HP.this.updateBlowBackMode();
            }
            if (updateCode != ConstAllAirDara.U_AIR_BACK_BLOW_UP_RIGHT && updateCode != ConstAllAirDara.U_AIR_BACK_BLOW_BODY_RIGHT && updateCode != ConstAllAirDara.U_AIR_BACK_BLOW_FOOT_RIGHT) {
                return;
            }
            Air_Activity_All_NewAdd_HP.this.updateBlowBackModeRight();
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_LZ_CG_Toyota_4Runner_Auto /* 65991 */:
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen /* 1114567 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen_3 /* 1180103 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_Proda_18 /* 3604935 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_Proda_23 /* 4194759 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha_3_156inch /* 4784583 */:
            case FinalCanbus.CAR_WC2_CG_Honda_16Civic_H /* 5570881 */:
            case FinalCanbus.CAR_455_LZ_Daohang_Toyota_Proda_18 /* 10092999 */:
            case FinalCanbus.CAR_455_LZ_Daohang_Toyota_Proda_23 /* 10158535 */:
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH /* 10420679 */:
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH_H /* 10486215 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300 /* 15008198 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_4Runner /* 15073734 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER /* 15139270 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha /* 15204806 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER_H /* 15532486 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300_H /* 15598022 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha_3 /* 16187846 */:
                setContentView(R.layout.layout_air_hp_all_prado_cg7870);
                break;
            default:
                int toobarheigt = SystemProperties.getInt("persist.launcher.toobar_height", 0);
                int statusbarheigt = SystemProperties.getInt("sys.lsec.status_bar_height", 0);
                Configuration config = getResources().getConfiguration();
                int smallestScreenWidth = config.smallestScreenWidthDp;
                Log.v("zed", " 111 TheApp.getScreenWidth() == " + TheApp.getScreenWidth() + "  TheApp.getScreenHeight() = " + TheApp.getScreenHeight() + "  smallestScreenWidth = " + smallestScreenWidth + "  toobarheigt = " + toobarheigt);
                if (toobarheigt >= 100 || statusbarheigt >= 100) {
                    setContentView(R.layout.layout_air_hp_all_prado_small);
                } else {
                    setContentView(R.layout.layout_air_hp_all_prado);
                }
                break;
        }
        initCallbackId();
        init();
        mInstance = this;
    }

    private void sendCmd(int data0, int data1) {
        int data2;
        int data3;
        switch (DataCanbus.DATA[1000]) {
            case 25:
            case 26:
            case 253:
            case 263:
            case 309:
            case FinalCanbus.CAR_XP1_GM_H1 /* 65561 */:
            case FinalCanbus.CAR_RZC_FLB_SaiOu3 /* 65799 */:
            case FinalCanbus.CAR_XP1_GM_H2 /* 131097 */:
            case FinalCanbus.CAR_XP1_GM_H3 /* 196633 */:
            case FinalCanbus.CAR_XP1_GM_Camaro_10 /* 262169 */:
            case FinalCanbus.CAR_RZC_17Gl8 /* 262407 */:
            case FinalCanbus.CAR_RZC_ALL_GM_11_15GL8 /* 327943 */:
            case FinalCanbus.CAR_RZC_17_18GL8_ES_28T /* 393479 */:
            case FinalCanbus.CAR_XP1_GM_Silverado_14_Hand /* 458777 */:
            case FinalCanbus.CAR_RZC_18_19Excelle_GT /* 459015 */:
            case FinalCanbus.CAR_XP1_GM_Silverado_14_Auto /* 524313 */:
            case FinalCanbus.CAR_RZC_20GL8_652T /* 524551 */:
            case FinalCanbus.CAR_RZC_20GL8_652T_H /* 590087 */:
            case FinalCanbus.CAR_RZC_15GL8_24_H /* 655623 */:
            case FinalCanbus.CAR_RZC_21YingLang_CD /* 721159 */:
            case FinalCanbus.CAR_RZC_21YingLang /* 786695 */:
            case FinalCanbus.CAR_XP1_GM_AJcd600 /* 2228249 */:
            case FinalCanbus.CAR_DJ_GM_ALL /* 2424857 */:
            case FinalCanbus.CAR_XP1_GM_AJcd650 /* 2490393 */:
            case FinalCanbus.CAR_XP1_GM_Opel_Meriva /* 2621465 */:
            case FinalCanbus.CAR_DJ_GM_Kopach /* 2687001 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{7, data0}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{7, 0}, null, null);
                }
                break;
            case 36:
            case 345:
            case FinalCanbus.CAR_WC2_ShuPingJW /* 65881 */:
            case FinalCanbus.CAR_WC2_ShuPingKeLuZi /* 131417 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao /* 196953 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS /* 262489 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS_S /* 328025 */:
            case FinalCanbus.CAR_WC2_GM_GL8 /* 393252 */:
            case FinalCanbus.CAR_WC2_GM_GL6 /* 458788 */:
            case FinalCanbus.CAR_WC2_ShuPing10JunYue /* 459097 */:
            case FinalCanbus.CAR_WC2_GM_WLD /* 524324 */:
            case FinalCanbus.CAR_WC2_ShuPingKeLuZi_Auto /* 524633 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao_L /* 590169 */:
            case FinalCanbus.CAR_WC2_GM_EXCELLE_19 /* 655396 */:
            case FinalCanbus.CAR_WC2_GM_EXCELLE_18 /* 720932 */:
            case FinalCanbus.CAR_WC2_GM_GL8_10_13 /* 786468 */:
            case FinalCanbus.CAR_WC2_GM_GL8_14_16 /* 852004 */:
            case FinalCanbus.CAR_WC2_GM_Encore_12_15 /* 917540 */:
            case FinalCanbus.CAR_WC2_GM_Encore_16_19 /* 983076 */:
            case FinalCanbus.CAR_WC2_GM_Regal_09_13 /* 1048612 */:
            case FinalCanbus.CAR_WC2_GM_Lacrosse_10_13 /* 1114148 */:
            case FinalCanbus.CAR_WC2_GM_Lacrosse_18 /* 1179684 */:
            case FinalCanbus.CAR_WC2_GM_Excelle_XT /* 1245220 */:
            case FinalCanbus.CAR_WC2_GM_Excelle_GT /* 1310756 */:
            case FinalCanbus.CAR_WC2_GM_AVEO_11 /* 1376292 */:
            case FinalCanbus.CAR_WC2_GM_Orlando_11 /* 1441828 */:
            case FinalCanbus.CAR_WC2_GM_Trax_13_18 /* 1507364 */:
            case FinalCanbus.CAR_WC2_GM_Cruze_08_14 /* 1572900 */:
            case FinalCanbus.CAR_WC2_GM_Cruze_15 /* 1638436 */:
            case FinalCanbus.CAR_WC2_GM_Malibu_13 /* 1703972 */:
            case FinalCanbus.CAR_WC2_GM_Spin_13 /* 1769508 */:
            case FinalCanbus.CAR_WC2_GM_Astra_09_14 /* 1835044 */:
            case FinalCanbus.CAR_WC2_GM_Astra_15 /* 1900580 */:
            case FinalCanbus.CAR_WC2_GM_Mokka_12_16 /* 1966116 */:
            case FinalCanbus.CAR_WC2_GM_MokkaX_17 /* 2031652 */:
            case FinalCanbus.CAR_WC2_GM_Insignia_08_12 /* 2097188 */:
            case FinalCanbus.CAR_WC2_GM_Insignia_13_16 /* 2162724 */:
            case FinalCanbus.CAR_WC2_GM_Regal_14 /* 2228260 */:
            case FinalCanbus.CAR_WC2_GM_ENVISION_14 /* 2293796 */:
            case FinalCanbus.CAR_WC2_GM_Lacrosse_14 /* 2359332 */:
            case FinalCanbus.CAR_WC2_GM_Verano_15 /* 2424868 */:
            case FinalCanbus.CAR_WC2_GM_Verano_GS_16 /* 2490404 */:
            case FinalCanbus.CAR_WC2_GM_MalibuXL_16_18 /* 2555940 */:
            case FinalCanbus.CAR_WC2_GM_MalibuXL_19 /* 2621476 */:
            case FinalCanbus.CAR_WC2_GM_Equinox_17 /* 2687012 */:
            case FinalCanbus.CAR_WC2_GM_Sail3_15 /* 2752548 */:
            case FinalCanbus.CAR_WC2_GM_Onix_16 /* 2818084 */:
            case FinalCanbus.CAR_WC2_GM_LOVA_16_18 /* 2883620 */:
            case FinalCanbus.CAR_WC2_GM_Excelle_15_18 /* 2949156 */:
            case FinalCanbus.CAR_WC2_GM_Monza_19 /* 3014692 */:
            case FinalCanbus.CAR_WC2_GM_GL8_28T_ES /* 3080228 */:
            case FinalCanbus.CAR_WC2_GM_GL8_20 /* 3145764 */:
            case FinalCanbus.CAR_WC2_GM_Trax_19 /* 3211300 */:
            case FinalCanbus.CAR_WC2_GM_Trailblazer_20 /* 3276836 */:
            case FinalCanbus.CAR_WC2_GM_S10_12 /* 3342372 */:
            case FinalCanbus.CAR_WC2_GM_Karl_15 /* 3407908 */:
            case FinalCanbus.CAR_WC2_GM_Encore_GX_20 /* 3473444 */:
            case FinalCanbus.CAR_WC2_GM_Encore_20 /* 3538980 */:
            case FinalCanbus.CAR_WC2_GM_CorsaE_14_19 /* 3604516 */:
            case FinalCanbus.CAR_WC2_GM_Adam_13_19 /* 3670052 */:
            case FinalCanbus.CAR_WC2_GM_Insignia_17 /* 3735588 */:
            case FinalCanbus.CAR_WC2_GM_Sierra_14_18 /* 3801124 */:
            case FinalCanbus.CAR_WC2_GM_Trailblazer_14_18 /* 3866660 */:
            case FinalCanbus.CAR_WC2_GM_Suburban_15 /* 3932196 */:
            case FinalCanbus.CAR_WC2_GM_Tahoe_16_18 /* 3997732 */:
            case FinalCanbus.CAR_WC2_GM_Colorado_18 /* 4063268 */:
            case FinalCanbus.CAR_WC2_GM_Kopach_12 /* 4128804 */:
            case FinalCanbus.CAR_WC2_OPEL_Meriva_10 /* 4194340 */:
            case FinalCanbus.CAR_WC2_GM_Onix_14 /* 4259876 */:
            case FinalCanbus.CAR_WC2_GM_Onix_19 /* 4325412 */:
            case FinalCanbus.CAR_WC2_GM_Montana_23 /* 4390948 */:
            case FinalCanbus.CAR_WC2_GM_Tracker_19 /* 4456484 */:
            case FinalCanbus.CAR_WC2_GM_Spin_Brazil_13 /* 4522020 */:
            case FinalCanbus.CAR_WC2_GM_S10_Brazil_10 /* 4587556 */:
            case FinalCanbus.CAR_WC2_GM_EQUINOX_22 /* 4653092 */:
            case FinalCanbus.CAR_WC2_GM_EQUINOX_22_H /* 4718628 */:
            case FinalCanbus.CAR_WC2_GM_Colorado_14 /* 4784164 */:
            case FinalCanbus.CAR_WC2_GM_Colorado_14_H /* 4849700 */:
            case FinalCanbus.CAR_WC2_GM_Silverado_07 /* 4915236 */:
            case FinalCanbus.CAR_WC2_GM_Silverado_14 /* 4980772 */:
            case FinalCanbus.CAR_WC2_GM_Silverado_14_H /* 5046308 */:
            case FinalCanbus.CAR_WC2_GM_Canyon_14 /* 5111844 */:
            case FinalCanbus.CAR_WC2_GM_Canyon_14_H /* 5177380 */:
            case FinalCanbus.CAR_WC2_GMC_Acadia_07 /* 5242916 */:
            case FinalCanbus.CAR_WC2_GMC_Yukon_07 /* 5308452 */:
            case FinalCanbus.CAR_WC2_GMC_Savana_08 /* 5373988 */:
            case FinalCanbus.CAR_WC2_GMC_Sierra_07 /* 5439524 */:
            case FinalCanbus.CAR_WC2_GMC_Sierra_14 /* 5505060 */:
            case FinalCanbus.CAR_WC2_GMC_Sierra_14_H /* 5570596 */:
            case FinalCanbus.CAR_WC2_GM_ExpressVan_08 /* 5636132 */:
            case FinalCanbus.CAR_WC2_GM_Impala_06 /* 5701668 */:
            case FinalCanbus.CAR_WC2_GM_Avalanch_07 /* 5767204 */:
            case FinalCanbus.CAR_WC2_GM_Escalade_07_Auto /* 5963812 */:
            case FinalCanbus.CAR_WC2_GM_XinJunWei2013 /* 6029348 */:
            case FinalCanbus.CAR_WC2_GM_SAIL3 /* 6094884 */:
            case FinalCanbus.CAR_WC2_GM_Excelle_19 /* 6160420 */:
            case FinalCanbus.CAR_WC2_GM_Excelle_21 /* 6225956 */:
            case FinalCanbus.CAR_WC2_GM_ExcelleGX_18 /* 6291492 */:
            case FinalCanbus.CAR_WC2_GM_Camaro_10 /* 6815780 */:
            case FinalCanbus.CAR_WC2_GMC_Yukon_14 /* 7143460 */:
            case FinalCanbus.CAR_WC2_GMC_Yukon_14_H /* 7208996 */:
            case FinalCanbus.CAR_WC2_GMC_Terrain_10 /* 7274532 */:
            case FinalCanbus.CAR_WC2_GM_EQUINOX_17 /* 7405604 */:
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_POWER) {
                        RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                        int i = ConstAllAirDara.C_CONTRAL;
                        int[] iArr = new int[2];
                        iArr[0] = data0;
                        iArr[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_POWER] == 1 ? 0 : 1;
                        remoteModuleProxy.cmd(i, iArr, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_AC) {
                        RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                        int i2 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr2 = new int[2];
                        iArr2[0] = data0;
                        iArr2[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 1 ? 0 : 1;
                        remoteModuleProxy2.cmd(i2, iArr2, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_AUTO) {
                        RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                        int i3 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr3 = new int[2];
                        iArr3[0] = data0;
                        iArr3[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 1 ? 0 : 1;
                        remoteModuleProxy3.cmd(i3, iArr3, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        if (DataCanbus.DATA[1000] == 393252) {
                            if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 0) {
                                DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, 1}, null, null);
                            } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                                DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, 2}, null, null);
                            } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE_AUTO] == 1) {
                                DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, 0}, null, null);
                            }
                        } else {
                            RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                            int i4 = ConstAllAirDara.C_CONTRAL;
                            int[] iArr4 = new int[2];
                            iArr4[0] = data0;
                            iArr4[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1 ? 1 : 0;
                            remoteModuleProxy4.cmd(i4, iArr4, null, null);
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_SYNC) {
                        RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                        int i5 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr5 = new int[2];
                        iArr5[0] = data0;
                        iArr5[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_SYNC] == 1 ? 0 : 1;
                        remoteModuleProxy5.cmd(i5, iArr5, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{11, 1}, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{11, 2}, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{12, 1}, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{12, 2}, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{13, 1}, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{13, 2}, null, null);
                    } else if (data0 == ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN || data0 == ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{22, 2}, null, null);
                    } else if (data0 == ConstAllAirDara.C_REAR_LEFT_TEMP_UP || data0 == ConstAllAirDara.C_REAR_RIGHT_TEMP_UP) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{22, 1}, null, null);
                    } else if (data0 == ConstAllAirDara.C_REAR_WIND_UP) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{21, 1}, null, null);
                    } else if (data0 == ConstAllAirDara.C_REAR_WIND_DOWN) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{21, 2}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, 255}, null, null);
                    }
                }
                break;
            case 40:
            case FinalCanbus.CAR_XP1_17MaiTeng /* 262184 */:
            case FinalCanbus.CAR_XP_MQB_Lamando /* 458792 */:
            case FinalCanbus.CAR_XP_MQB_Polo /* 524328 */:
            case FinalCanbus.CAR_XP_MQB_Passat_B8 /* 589864 */:
            case FinalCanbus.CAR_XP_MQB_Sportsvan /* 655400 */:
            case FinalCanbus.CAR_XP_MQB_TouranL /* 720936 */:
            case FinalCanbus.CAR_XP_MQB_Tiguan /* 786472 */:
            case FinalCanbus.CAR_XP_MQB_Terament /* 852008 */:
            case FinalCanbus.CAR_XP_MQB_Skoda_Octavia /* 917544 */:
            case FinalCanbus.CAR_XP_MQB_Skoda_Fabia /* 983080 */:
            case FinalCanbus.CAR_XP_MQB_Skoda_Superb /* 1048616 */:
            case FinalCanbus.CAR_XP_MQB_Skoda_Kodiaq /* 1114152 */:
            case FinalCanbus.CAR_XP_MQB_Seat_LeonFR /* 1179688 */:
            case FinalCanbus.CAR_XP_MQB_Seat_Ateca /* 1245224 */:
            case FinalCanbus.CAR_XP_TuGuan_L_20_H /* 1376296 */:
                if (data1 == 1) {
                    int ints0 = 0;
                    int ints1 = 0;
                    if (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT) {
                        ints0 = 173;
                        int ints2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT];
                        ints1 = ints2 + 1;
                        if (ints1 > 3) {
                            ints1 = 0;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT) {
                        ints0 = 174;
                        int ints3 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT];
                        ints1 = ints3 + 1;
                        if (ints1 > 3) {
                            ints1 = 0;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODY) {
                        ints0 = 180;
                        ints1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT] == 0 ? 1 : 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_UP) {
                        ints0 = 182;
                        ints1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT] == 0 ? 1 : 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_FOOT) {
                        ints0 = 181;
                        ints1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT] == 0 ? 1 : 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD) {
                        ints0 = 184;
                        ints1 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                        ints0 = 184;
                        ints1 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        ints0 = 185;
                        ints1 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        ints0 = 185;
                        ints1 = 0;
                    } else if (data0 == ConstAllAirDara.C_REAR_CTRL) {
                        ints0 = 188;
                        ints1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_CTRL] == 0 ? 1 : 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_POWER) {
                        ints0 = 178;
                        ints1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_POWER] == 0 ? 1 : 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        ints0 = 183;
                        ints1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                        if (ints1 < 7) {
                            ints1++;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        ints0 = 183;
                        ints1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                        if (ints1 > 0) {
                            ints1--;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_FRONT_HOT) {
                        ints0 = 170;
                        ints1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT_HOT] == 0 ? 1 : 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_AC) {
                        ints0 = 190;
                        ints1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 0 ? 1 : 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        ints0 = 191;
                        ints1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 0 ? 1 : 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_AQS) {
                        ints0 = 176;
                        ints1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_AQS] == 0 ? 1 : 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_SYNC) {
                        ints0 = 179;
                        ints1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SYNC] == 0 ? 1 : 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_STEER) {
                        ints0 = 172;
                        ints1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_STEER] == 0 ? 1 : 0;
                    } else if (data0 == ConstAllAirDara.C_CLEAN) {
                        ints0 = 175;
                        ints1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_CLEAN] == 0 ? 1 : 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST) {
                        ints0 = 187;
                        ints1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 0 ? 3 : 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_AUTO) {
                        ints0 = 187;
                        ints1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 0 ? 1 : 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_AC_MAX) {
                        ints0 = 187;
                        ints1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC_MAX] == 0 ? 2 : 0;
                    }
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints0, ints1}, null, null);
                }
                break;
            case 160:
            case FinalCanbus.CAR2_RZC_XP1_DaZhong_GaoErFu7_H /* 131232 */:
            case FinalCanbus.CAR_RZC_XP1_MaiTeng /* 196768 */:
            case FinalCanbus.CAR_RZC_TuGuan_L /* 262304 */:
            case FinalCanbus.CAR_RZC_TuAng /* 327840 */:
            case FinalCanbus.CAR2_RZC_DaZhong_Tange /* 589984 */:
            case FinalCanbus.CAR2_RZC_DaZhong_MQB_E /* 655520 */:
            case FinalCanbus.CAR_RZC_TuGuan_L_20 /* 721056 */:
            case FinalCanbus.CAR_RZC_MQB_18_19Lavida_plus /* 786592 */:
            case FinalCanbus.CAR_RZC_MQB_11_18Sagitar /* 852128 */:
            case FinalCanbus.CAR_RZC_MQB_19Sagitar /* 917664 */:
            case FinalCanbus.CAR_RZC_MQB_11_17Passat /* 983200 */:
            case FinalCanbus.CAR_RZC_MQB_19Passat /* 1048736 */:
            case FinalCanbus.CAR_RZC_MQB_19Tharu /* 1179808 */:
            case FinalCanbus.CAR_RZC_MQB_14_19Golf7 /* 1310880 */:
            case FinalCanbus.CAR_RZC_MQB_19Bora /* 1376416 */:
            case FinalCanbus.CAR_RZC_MQB_14_19Lamando /* 1441952 */:
            case FinalCanbus.CAR_RZC_MQB_19Polo /* 1507488 */:
            case FinalCanbus.CAR_RZC_MQB_19CC /* 1573024 */:
            case FinalCanbus.CAR_RZC_MQB_19T_Cross /* 1638560 */:
            case FinalCanbus.CAR_RZC_MQB_16_18TouranL /* 1704096 */:
            case FinalCanbus.CAR_RZC_MQB_17_18C_Trek /* 1769632 */:
            case FinalCanbus.CAR_RZC_MQB_16_19Golf_jialv /* 1835168 */:
            case FinalCanbus.CAR_RZC_MQB_19T_ROC /* 1900704 */:
            case FinalCanbus.CAR_RZC_MQB_19Tayron /* 1966240 */:
            case FinalCanbus.CAR_RZC_MQB_13_14Octavia /* 2031776 */:
            case FinalCanbus.CAR_RZC_MQB_15_19Octavia /* 2097312 */:
            case FinalCanbus.CAR_RZC_MQB_13_15Superb /* 2162848 */:
            case FinalCanbus.CAR_RZC_MQB_16_18Superb /* 2228384 */:
            case FinalCanbus.CAR_RZC_MQB_18Kamiq /* 2293920 */:
            case FinalCanbus.CAR_RZC_MQB_18_19Karoq /* 2359456 */:
            case FinalCanbus.CAR_RZC_MQB_17_19Kodiaq /* 2424992 */:
            case FinalCanbus.CAR_RZC_MQB_14_18Caravan /* 2490528 */:
            case FinalCanbus.CAR_RZC_MQB_19Jetta_VS5 /* 2556064 */:
            case FinalCanbus.CAR_RZC_MQB_11_17Touareg /* 2621600 */:
            case FinalCanbus.CAR_RZC_MQB_09_19Multivan /* 2687136 */:
            case FinalCanbus.CAR_RZC_MQB_Jetta_Brazil /* 2752672 */:
            case FinalCanbus.CAR_RZC_MQB_SUPERB_Turkey /* 2818208 */:
            case FinalCanbus.CAR_RZC_MQB_Huiang_21 /* 3080352 */:
            case FinalCanbus.CAR_RZC_MQB_20Tayron_GTE /* 3145888 */:
            case FinalCanbus.CAR_RZC_MQB_20Jetta_VS7 /* 3211424 */:
            case FinalCanbus.CAR_RZC_MQB_20Viloran /* 3276960 */:
            case FinalCanbus.CAR_RZC_MQB_21Golf8 /* 3342496 */:
            case FinalCanbus.CAR_RZC_MQB_16_18Weilan /* 3408032 */:
            case FinalCanbus.CAR_RZC_TuGuan_L_20_H /* 3473568 */:
            case FinalCanbus.CAR_6606_MQB_Lavida_23 /* 3539104 */:
            case FinalCanbus.CAR_RZC_MQB_17Passat_B8 /* 3604640 */:
            case FinalCanbus.CAR_RZC_MQB_All_360 /* 3670176 */:
            case FinalCanbus.CAR_RZC_MQB_Caddy_22 /* 3735712 */:
            case FinalCanbus.CAR_RZC_MaiTeng_20_H_EC /* 3801248 */:
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_REAR_OFF) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_POWER] != 0) {
                            data1 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_POWER] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_REAR_AUTO) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_AUTO] != 0) {
                            data1 = 1;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_AUTO] == 0) {
                            data1 = 0;
                        }
                    } else if (data0 == ConstAllAirDara.C_REAR_MODE_BODY) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_BODY] != 0) {
                            data1 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_BODY] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_REAR_MODE_FOOT) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_FOOT] != 0) {
                            data1 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_FOOT] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_REAR_WIND_DOWN) {
                        data0 = 40;
                        data1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_WIND];
                        if (data1 > 0) {
                            data1--;
                        }
                    } else if (data0 == ConstAllAirDara.C_REAR_WIND_UP) {
                        data0 = 40;
                        data1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_WIND];
                        if (data1 < 7) {
                            data1++;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_STEER) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_STEER] != 0) {
                            data1 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_STEER] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT) {
                        data1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT] + 1;
                        if (data1 > 3) {
                            data1 = 0;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT) {
                        data1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT] + 1;
                        if (data1 > 3) {
                            data1 = 0;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_WINLEV) {
                        data1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WINLEV] + 1;
                        if (data1 > 2) {
                            data1 = 0;
                        }
                    } else if (data0 == ConstAllAirDara.C_CLEAN) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CLEAN] != 0) {
                            data1 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CLEAN] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_AQS) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AQS] != 0) {
                            data1 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AQS] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_POWER) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_POWER] != 0) {
                            data1 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_POWER] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_SYNC) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_SYNC] != 0) {
                            data1 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_SYNC] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_UP) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT] != 0) {
                            data1 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODY) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT] != 0) {
                            data1 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_FOOT) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT] != 0) {
                            data1 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        data0 = 183;
                        data1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                        if (data1 < 12) {
                            data1++;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        data0 = 183;
                        data1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                        if (data1 > 0) {
                            data1--;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD) {
                        data0 = 184;
                        data1 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                        data0 = 184;
                        data1 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        data0 = 185;
                        data1 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        data0 = 185;
                        data1 = 0;
                    } else if (data0 == ConstAllAirDara.C_REAR_LEFT_TEMP_UP) {
                        data0 = 186;
                        data1 = 1;
                    } else if (data0 == ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN) {
                        data0 = 186;
                        data1 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_AC_MAX) {
                        data0 = 187;
                        data1 = 2;
                    } else if (data0 == ConstAllAirDara.C_AIR_AUTO) {
                        data0 = 187;
                        data1 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST) {
                        data0 = 187;
                        data1 = 3;
                    } else if (data0 == ConstAllAirDara.C_AIR_AC) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] != 0) {
                            data1 = 2;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] != 0) {
                            data1 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_REAR_LOCK) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_LOCK] != 0) {
                            data1 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_LOCK] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] != 0) {
                            data1 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_LEFT_COLD) {
                        data1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_LEFT] + 1;
                        if (data1 > 3) {
                            data1 = 0;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_RIGHT_COLD) {
                        data1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_RIGHT] + 1;
                        if (data1 > 3) {
                            data1 = 0;
                        }
                    }
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                }
                break;
            case 282:
            case FinalCanbus.CAR_WC2_17MingJueRuiTeng /* 131354 */:
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_POWER || data0 == ConstAllAirDara.C_AIR_MODE_CHANGER) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, 255}, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_AC) {
                        RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                        int i6 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr6 = new int[2];
                        iArr6[0] = data0;
                        iArr6[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 1 ? 0 : 1;
                        remoteModuleProxy6.cmd(i6, iArr6, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_AUTO) {
                        RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                        int i7 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr7 = new int[2];
                        iArr7[0] = data0;
                        iArr7[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 1 ? 0 : 1;
                        remoteModuleProxy7.cmd(i7, iArr7, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST) {
                        RemoteModuleProxy remoteModuleProxy8 = DataCanbus.PROXY;
                        int i8 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr8 = new int[2];
                        iArr8[0] = data0;
                        iArr8[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 1 ? 0 : 1;
                        remoteModuleProxy8.cmd(i8, iArr8, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST) {
                        RemoteModuleProxy remoteModuleProxy9 = DataCanbus.PROXY;
                        int i9 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr9 = new int[2];
                        iArr9[0] = data0;
                        iArr9[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 1 ? 0 : 1;
                        remoteModuleProxy9.cmd(i9, iArr9, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        RemoteModuleProxy remoteModuleProxy10 = DataCanbus.PROXY;
                        int i10 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr10 = new int[2];
                        iArr10[0] = data0;
                        iArr10[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1 ? 1 : 0;
                        remoteModuleProxy10.cmd(i10, iArr10, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{11, 1}, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{11, 2}, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD || data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{12, 1}, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB || data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{12, 2}, null, null);
                    }
                }
                break;
            case 289:
            case FinalCanbus.CAR_WC2_ChuanQiGS4_M /* 65825 */:
            case FinalCanbus.CAR_WC2_ChuanQiGS4_H /* 131361 */:
            case FinalCanbus.CAR_WC2_17ChuanQiGS4 /* 196897 */:
            case FinalCanbus.CAR_WC2_17ChuanQiGS3 /* 262433 */:
            case FinalCanbus.CAR_WC2_ChuanQiG_GS4_20 /* 590113 */:
            case FinalCanbus.CAR_WC2_ChuanQiG_AION_19 /* 655649 */:
            case FinalCanbus.CAR_WC2_ChuanQiG_GS8_17 /* 721185 */:
            case FinalCanbus.CAR_WC2_ChuanQiG_AION_22 /* 786721 */:
            case FinalCanbus.CAR_WC2_ChuanQiG_AION_YPLUS_23 /* 852257 */:
            case FinalCanbus.CAR_WC2_ChuanQiG_AION_SPLUS_25 /* 917793 */:
            case FinalCanbus.CAR_WC2_ChuanQiG_GS4_PLUS /* 983329 */:
            case FinalCanbus.CAR_WC2_ChuanQiG_GM8_21 /* 1048865 */:
                if (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT) {
                    if (data1 == 1) {
                        int value = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT] + 1;
                        if (value > 3) {
                            value = 0;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{15, value}, null, null);
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT) {
                    if (data1 == 1) {
                        int value2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT] + 1;
                        if (value2 > 3) {
                            value2 = 0;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{16, value2}, null, null);
                    }
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                }
                break;
            case 373:
            case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_H /* 65909 */:
            case FinalCanbus.CAR_RZC_XP1_ZiYouXia /* 131445 */:
            case FinalCanbus.CAR_RZC_XP1_GrdCherokee /* 196981 */:
            case FinalCanbus.CAR_RZC_17ZhiNanZhe /* 262517 */:
            case FinalCanbus.CAR_RZC_17ZhiNanZhe_H /* 328053 */:
            case FinalCanbus.CAR_RZC_18MuMaRen /* 393589 */:
            case FinalCanbus.CAR_RZC_XP1_GrdCherokee_H /* 459125 */:
            case FinalCanbus.CAR_RZC_18MuMaRen_H /* 524661 */:
            case FinalCanbus.CAR_RZC_19Tiaozhanzhe /* 590197 */:
            case FinalCanbus.CAR_RZC_19Tiaozhanzhe_H /* 721269 */:
            case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19 /* 852341 */:
            case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19_H /* 917877 */:
            case FinalCanbus.CAR_RZC_Chrysler_300C_16 /* 1245557 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM /* 1311093 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_H /* 1376629 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_M /* 1835381 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_HY /* 1900917 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_HY_M /* 1966453 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_HY_H /* 2031989 */:
            case FinalCanbus.CAR_RZC_XP1_ZiYouXia_H /* 2163061 */:
            case FinalCanbus.CAR_RZC_Jeep_22Gladiator /* 2949493 */:
            case FinalCanbus.CAR_RZC_Jeep_22Gladiator_H /* 3015029 */:
            case FinalCanbus.CAR_RZC_Jeep_18GrdCherokee /* 3080565 */:
            case FinalCanbus.CAR_RZC_Jeep_18GrdCherokee_H /* 3146101 */:
                if (data0 == ConstAllAirDara.C_AIR_POWER) {
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_POWER] == 1) {
                        data3 = 16;
                    } else {
                        data3 = 9;
                    }
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data3, data1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                }
                break;
            case FinalCanbus.CAR_RZC_XP1_BeiQiM50F /* 65932 */:
            case FinalCanbus.CAR_CYT_YaGe7_38400 /* 262561 */:
            case FinalCanbus.CAR_RCW_BYD_10_11F6 /* 328097 */:
            case FinalCanbus.CAR_RCW_BYD_10_13G6 /* 393633 */:
            case FinalCanbus.CAR_RCW_YaGe7_38400 /* 459169 */:
            case FinalCanbus.CAR_WC_YaGe7_38400 /* 524705 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                }
                break;
            case FinalCanbus.CAR_456_OD_Hongqi_H5 /* 65992 */:
            case FinalCanbus.CAR_455_CZH_OD_Hongqi_EQM5_Huandian /* 7274951 */:
            case FinalCanbus.CAR_454_CZH_OD_Hongqi_EQM5 /* 16515526 */:
                int ints4 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints5 = ints4 | (data0 == ConstAllAirDara.C_AIR_HEAT ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 8 : 0);
                int ints6 = 0 | (data0 == ConstAllAirDara.C_AIR_SYNC ? 8 : 0);
                int ints7 = ints6 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0);
                if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                    int winlev = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                    if (winlev < 7) {
                        winlev++;
                    }
                    ints7 = (winlev << 4) & 240;
                } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                    int winlev2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                    if (winlev2 > 0) {
                        winlev2--;
                    }
                    ints7 = (winlev2 << 4) & 240;
                }
                int ints8 = 0 | (data0 == ConstAllAirDara.C_AIR_MODE_BODY ? 32 : 0);
                int ints9 = ints8 | (data0 == ConstAllAirDara.C_AIR_MODE_FOOT ? 96 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT ? 128 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UP ? 160 : 0);
                int ints10 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints11 = ints10 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints12 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                int ints13 = ints12 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                int ints14 = 0 | (data0 == ConstAllAirDara.C_AIR_PARK ? 4 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints5, ints7, ints9, ints11, ints13, ints14}, null, null);
                }
                break;
            case FinalCanbus.CAR_RZCexc_Feiyate_TORO /* 131111 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_TORO_M /* 1441831 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_TORO_H /* 1507367 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[2], null, null);
                }
                break;
            case FinalCanbus.CAR_RZC_XP1_16HAIMAMV70 /* 131309 */:
            case FinalCanbus.CAR_RZC_XP1_HAIMA_F5 /* 262381 */:
                if (data1 == 1) {
                    int ints15 = 0;
                    int ints16 = 0;
                    if (data0 == ConstAllAirDara.C_AIR_POWER) {
                        ints15 = 168;
                        ints16 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        ints15 = 160;
                        ints16 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        ints15 = 160;
                        ints16 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD) {
                        ints15 = 161;
                        ints16 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                        ints15 = 161;
                        ints16 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        ints15 = 162;
                        ints16 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        ints15 = 162;
                        ints16 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODY) {
                        ints15 = 163;
                        ints16 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT) {
                        ints15 = 163;
                        ints16 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT) {
                        ints15 = 163;
                        ints16 = 2;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_FOOT) {
                        ints15 = 163;
                        ints16 = 3;
                    } else if (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST) {
                        ints15 = 163;
                        ints16 = 4;
                    } else if (data0 == ConstAllAirDara.C_AIR_AC) {
                        ints15 = 164;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 1) {
                            ints16 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 0) {
                            ints16 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        ints15 = 165;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            ints16 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 0) {
                            ints16 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST) {
                        ints15 = 167;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 1) {
                            ints16 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 0) {
                            ints16 = 1;
                        }
                    }
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints15, ints16}, null, null);
                }
                break;
            case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6 /* 131379 */:
            case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6_H /* 196915 */:
                int ints17 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints18 = ints17 | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_AC_MAX ? 1 : 0);
                int ints19 = 0 | (data0 == ConstAllAirDara.C_AIR_DUAL ? 8 : 0);
                int ints20 = ints19 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints21 = 0 | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 160 : 0);
                int ints22 = ints21 | (data0 == ConstAllAirDara.C_AIR_MODE_BODY ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_FOOT ? 96 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT ? 128 : 0) | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 1 : 0);
                int ints23 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints24 = ints23 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints25 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                int ints26 = ints25 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints18, ints20, ints22, ints24, ints26, 0}, null, null);
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                }
                break;
            case FinalCanbus.CAR_RZC_SeMar_NoAmp /* 196688 */:
            case FinalCanbus.CAR_RZC_SwMar_Amp /* 262224 */:
            case FinalCanbus.CAR_RZC_SwMar_17 /* 1441872 */:
            case FinalCanbus.CAR_RZC_SwMar_Amp_17 /* 1507408 */:
                int ints27 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints28 = ints27 | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0);
                if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                        ints28 = 8;
                    } else {
                        ints28 = 4;
                    }
                }
                int ints29 = 0 | (data0 == ConstAllAirDara.C_AIR_DUAL ? 8 : 0);
                int ints30 = ints29 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints31 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints32 = ints31 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints33 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                int ints34 = ints33 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints28, ints30, 0, ints32, ints34, 0}, null, null);
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                }
                break;
            case FinalCanbus.CAR_RZC_HanTeng_H /* 196863 */:
            case FinalCanbus.CAR_Oudi_HanTeng_X5 /* 393471 */:
            case FinalCanbus.CAR_Oudi_XiaoYao /* 459007 */:
            case FinalCanbus.CAR_RZC_HanTeng_X5 /* 524543 */:
            case FinalCanbus.CAR_439_OuDi_ZTT500 /* 721335 */:
            case FinalCanbus.CAR_RZC_FengShen19_20AX7 /* 917759 */:
            case FinalCanbus.CAR_439_OuDi_DMX7 /* 917943 */:
            case FinalCanbus.CAR_RZC_FengShen19_20AX7_H /* 983295 */:
            case FinalCanbus.CAR_439_OuDi_Z560 /* 983479 */:
            case FinalCanbus.CAR_RZC_FengShen_X37_21 /* 1442047 */:
            case FinalCanbus.CAR_RZC_FengShen15AX7 /* 1638655 */:
            case FinalCanbus.CAR_RZC_FengShen19AX7_Hand /* 1704191 */:
            case FinalCanbus.CAR_RZC_FengShen15AX7_View /* 1769727 */:
            case FinalCanbus.CAR_455_OD_Dongfeng_Racing_EC75_23H /* 2294215 */:
            case FinalCanbus.CAR_452_RZC_Subaru /* 7209412 */:
            case FinalCanbus.CAR_454_RZC_Suburu_OUTBACK_18 /* 8323526 */:
            case FinalCanbus.CAR_454_OD_Dongfeng_Racing_EC75_23 /* 8454598 */:
            case FinalCanbus.CAR_455_RZC_Subaru_15 /* 8978887 */:
                int ints35 = 0;
                int ints36 = 0;
                int ints37 = 0;
                int ints38 = 0;
                int ints39 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints40 = ints39 | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0);
                if (DataCanbus.DATA[1000] == 2294215) {
                    ints35 = 0 | (data0 == ConstAllAirDara.C_AIR_AC_MAX ? 8 : 0);
                } else {
                    ints40 |= data0 == ConstAllAirDara.C_AIR_AC_MAX ? 1 : 0;
                }
                if (data0 == ConstAllAirDara.C_AIR_MODE_BODY) {
                    ints36 = 32;
                } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT) {
                    ints36 = 64;
                } else if (data0 == ConstAllAirDara.C_AIR_MODE_FOOT) {
                    ints36 = 96;
                } else if (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT) {
                    ints36 = 128;
                } else if (data0 == ConstAllAirDara.C_AIR_MODE_UP) {
                    ints36 = 160;
                }
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_HanTeng_H /* 196863 */:
                    case FinalCanbus.CAR_RZC_HanTeng_X5 /* 524543 */:
                    case FinalCanbus.CAR_RZC_FengShen19_20AX7 /* 917759 */:
                    case FinalCanbus.CAR_RZC_FengShen19_20AX7_H /* 983295 */:
                    case FinalCanbus.CAR_RZC_FengShen_X37_21 /* 1442047 */:
                    case FinalCanbus.CAR_RZC_FengShen15AX7 /* 1638655 */:
                    case FinalCanbus.CAR_RZC_FengShen19AX7_Hand /* 1704191 */:
                    case FinalCanbus.CAR_RZC_FengShen15AX7_View /* 1769727 */:
                        ints35 = ints35 | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                        if (data0 != ConstAllAirDara.C_AIR_CYCLE) {
                            if (data0 == ConstAllAirDara.C_AIR_MODE_BODY) {
                                ints36 = 2;
                            } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT) {
                                ints36 = 4;
                            } else if (data0 == ConstAllAirDara.C_AIR_MODE_FOOT) {
                                ints36 = 8;
                            } else if (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT) {
                                ints36 = 16;
                            }
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            ints40 = 8;
                        } else {
                            ints40 = 4;
                        }
                        break;
                    case FinalCanbus.CAR_Oudi_HanTeng_X5 /* 393471 */:
                    case FinalCanbus.CAR_Oudi_XiaoYao /* 459007 */:
                        if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                            int value3 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] + 1;
                            if (value3 > 7) {
                                value3 = 7;
                            }
                            ints35 = value3 << 4;
                        } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                            int value4 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] - 1;
                            if (value4 < 0) {
                                value4 = 0;
                            }
                            ints35 = value4 << 4;
                        } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                            if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                                ints40 = 8;
                            } else {
                                ints40 = 4;
                            }
                        }
                        break;
                    case FinalCanbus.CAR_439_OuDi_ZTT500 /* 721335 */:
                    case FinalCanbus.CAR_439_OuDi_DMX7 /* 917943 */:
                    case FinalCanbus.CAR_439_OuDi_Z560 /* 983479 */:
                        ints35 = ints35 | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0) | (data0 == ConstAllAirDara.C_AIR_DUAL ? 8 : 0);
                        if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                            if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                                ints40 = 8;
                            } else {
                                ints40 = 4;
                            }
                        }
                        break;
                    case FinalCanbus.CAR_455_OD_Dongfeng_Racing_EC75_23H /* 2294215 */:
                    case FinalCanbus.CAR_454_OD_Dongfeng_Racing_EC75_23 /* 8454598 */:
                        ints40 |= data0 == ConstAllAirDara.C_AIR_CYCLE ? 4 : 0;
                        ints35 = ints35 | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0) | (data0 == ConstAllAirDara.C_AIR_HEAT ? 4 : 0);
                        break;
                    case FinalCanbus.CAR_452_RZC_Subaru /* 7209412 */:
                    case FinalCanbus.CAR_454_RZC_Suburu_OUTBACK_18 /* 8323526 */:
                    case FinalCanbus.CAR_455_RZC_Subaru_15 /* 8978887 */:
                        if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                            int value5 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] + 1;
                            if (value5 > 7) {
                                value5 = 7;
                            }
                            ints35 = value5 << 4;
                        } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                            int value6 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] - 1;
                            if (value6 < 0) {
                                value6 = 0;
                            }
                            ints35 = value6 << 4;
                        } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                            ints36 = 1;
                        } else if (data0 == ConstAllAirDara.C_AIR_SYNC) {
                            ints35 = 8;
                        } else if (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST) {
                            ints35 = 4;
                        }
                        break;
                }
                int ints41 = ints35 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0);
                int ints42 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints43 = ints42 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_439_OuDi_ZTT500 /* 721335 */:
                    case FinalCanbus.CAR_439_OuDi_DMX7 /* 917943 */:
                    case FinalCanbus.CAR_439_OuDi_Z560 /* 983479 */:
                    case FinalCanbus.CAR_452_RZC_Subaru /* 7209412 */:
                    case FinalCanbus.CAR_454_RZC_Suburu_OUTBACK_18 /* 8323526 */:
                    case FinalCanbus.CAR_455_RZC_Subaru_15 /* 8978887 */:
                        int ints44 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                        ints37 = ints44 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                        int ints45 = 0 | (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT ? 2 : 0);
                        ints38 = ints45 | (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT ? 1 : 0);
                        break;
                    default:
                        ints43 = ints43 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                        break;
                }
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints40, ints41, ints36, ints43, ints37, ints38}, null, null);
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                }
                break;
            case FinalCanbus.CAR_OD_Jiangxi_Wushiling_Mux /* 393638 */:
            case FinalCanbus.CAR_OD_Jiangxi_Lingtuo /* 459174 */:
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        data1 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        data0 = ConstAllAirDara.C_AIR_WIND_ADD;
                        data1 = 2;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD) {
                        data1 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                        data0 = ConstAllAirDara.C_AIR_TEMP_LEFT_ADD;
                        data1 = 2;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        data1 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        data0 = ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD;
                        data1 = 2;
                    } else if (data0 == ConstAllAirDara.C_AIR_AC) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 1) {
                            data1 = 2;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 0) {
                            data1 = 2;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 1) {
                            data1 = 2;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 1) {
                            data1 = 2;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_AUTO) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 1) {
                            data1 = 2;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 0) {
                            data1 = 1;
                        }
                    }
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                }
                break;
            case FinalCanbus.CAR_RZC_20BaoJunRS3 /* 459062 */:
            case FinalCanbus.CAR_OD_RZC_20BaoJunRS3 /* 590134 */:
            case FinalCanbus.CAR_OD_RZC_Wuling_Xingchen /* 655670 */:
            case FinalCanbus.CAR_RZC_Wuling_Xingchen /* 721206 */:
            case FinalCanbus.CAR_RZC_Wuling_Kaijie /* 786742 */:
            case FinalCanbus.CAR_RZC_Wuling_Jiachen /* 852278 */:
            case FinalCanbus.CAR_RZC_20BaoJunRS3_Auto /* 917814 */:
            case FinalCanbus.CAR_RZC_Wuling_Xingchen_Auto /* 983350 */:
            case FinalCanbus.CAR_RZC_Wuling_Kaijie_Auto /* 1048886 */:
            case FinalCanbus.CAR_RZC_Wuling_Jiachen_Auto /* 1114422 */:
            case FinalCanbus.CAR_RZC_Wuling_Xingchi /* 1179958 */:
            case FinalCanbus.CAR_RZC_Wuling_Xingchi_Auto /* 1245494 */:
            case FinalCanbus.CAR_OD_RZC_Wuling_23XingGuang /* 1311030 */:
                if (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT) {
                    if (data1 == 1) {
                        int value7 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT] + 1;
                        if (value7 > 3) {
                            value7 = 0;
                        }
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, value7}, null, null);
                    }
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                }
                break;
            case FinalCanbus.CAR_RZC_Explorer /* 590158 */:
            case FinalCanbus.CAR_RZC_13_20Mengdiou /* 852302 */:
            case FinalCanbus.CAR_455_XP_Ford_F150_2012 /* 852423 */:
            case FinalCanbus.CAR_455_XP_Ford_F150_2012_Auto /* 917959 */:
            case FinalCanbus.CAR_RZC_Mustang /* 1048910 */:
            case FinalCanbus.CAR_RZC_Ford_F150_12 /* 2294094 */:
            case FinalCanbus.CAR_RZC_Mustang_NO_CD /* 2359630 */:
            case FinalCanbus.CAR_RZC_Mustang_15_NO_CD /* 2621774 */:
            case FinalCanbus.CAR_RZC_Explorer_13 /* 3014990 */:
            case FinalCanbus.CAR_RZC_Ford_F150 /* 3080526 */:
            case FinalCanbus.CAR_RZC_Ford_Puma_22 /* 3670350 */:
            case FinalCanbus.CAR_RZC_Mustang_M /* 5374286 */:
            case FinalCanbus.CAR_RZC_Mustang_H /* 5439822 */:
            case FinalCanbus.CAR_RZC_Mustang_NOCD_M /* 5505358 */:
            case FinalCanbus.CAR_RZC_Mustang_NOCD_H /* 5570894 */:
            case FinalCanbus.CAR_RZC_Ford_Puma_22_M /* 5636430 */:
            case FinalCanbus.CAR_RZC_Ford_Puma_22_H /* 5701966 */:
            case FinalCanbus.CAR_RZC_Ford_BRONCO_22 /* 5767502 */:
            case FinalCanbus.CAR_RZC_Ford_BRONCO_22_M /* 5833038 */:
            case FinalCanbus.CAR_RZC_Ford_BRONCO_22_H /* 5898574 */:
            case FinalCanbus.CAR_RZC_Ford_MAVERICK_24 /* 5964110 */:
            case FinalCanbus.CAR_RZC_Ford_MAVERICK_24_M /* 6029646 */:
            case FinalCanbus.CAR_RZC_Ford_MAVERICK_24_H /* 6095182 */:
            case FinalCanbus.CAR_RZC_Ford_Explorer_24 /* 6160718 */:
            case FinalCanbus.CAR_RZC_Ford_Explorer_24_M /* 6226254 */:
            case FinalCanbus.CAR_RZC_Ford_Explorer_24_H /* 6291790 */:
            case FinalCanbus.CAR_RZC_Ford_RANGER_24 /* 6357326 */:
            case FinalCanbus.CAR_RZC_Ford_RANGER_24_M /* 6422862 */:
            case FinalCanbus.CAR_RZC_Ford_RANGER_24_H /* 6488398 */:
            case FinalCanbus.CAR_RZC_Ford_F250_09 /* 6553934 */:
            case FinalCanbus.CAR_RZC_Ford_Expedition_07 /* 6619470 */:
            case FinalCanbus.CAR_RZC_Ford_Expedition_15 /* 6685006 */:
            case FinalCanbus.CAR_RZC_Ford_Flex_13 /* 6750542 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{172, data0}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{172, 0}, null, null);
                }
                break;
            case FinalCanbus.CAR_LZ_Dodge_RAM1500_09 /* 655647 */:
            case FinalCanbus.CAR_LZ_Dodge_RAM2500_09 /* 721183 */:
            case FinalCanbus.CAR_LZ_Dodge_RAM3500_09 /* 786719 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[1], null, null);
                }
                break;
            case FinalCanbus.CAR_RZC_18Zhihuiguan /* 655733 */:
            case FinalCanbus.CAR_RZC_18Zhihuiguan_H /* 786805 */:
            case FinalCanbus.CAR_RZC_20Zhihuiguan_EV /* 983413 */:
            case FinalCanbus.CAR_RZC_Dodge_JCUV /* 1114485 */:
            case FinalCanbus.CAR_RZC_Dodge_JCUV_H /* 2359669 */:
            case FinalCanbus.CAR_RZC_CHRYSLER_21PACIFICA /* 2556277 */:
            case FinalCanbus.CAR_RZC_CHRYSLER_21PACIFICA_H /* 2621813 */:
            case FinalCanbus.CAR_RZC_Dodge_15CHARGER /* 2687349 */:
            case FinalCanbus.CAR_RZC_Dodge_15CHARGER_H /* 2752885 */:
            case FinalCanbus.CAR_RZC_Dodge_17DURANGO /* 2818421 */:
            case FinalCanbus.CAR_RZC_Dodge_17DURANGO_H /* 2883957 */:
            case FinalCanbus.CAR_RZC_CHRYSLER_19PACIFICA_H /* 3211637 */:
            case FinalCanbus.CAR_RZC_Dodge_20RAM /* 3277173 */:
                if (this.pagenum == 0) {
                    if (data0 == ConstAllAirDara.C_AIR_POWER) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_POWER] == 1) {
                            data2 = 16;
                        } else {
                            data2 = 9;
                        }
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data2, data1}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                    }
                } else if (this.pagenum == 1) {
                    DataCanbus.PROXY.cmd(10, new int[]{data0, data1}, null, null);
                }
                break;
            case FinalCanbus.CAR_RZC_Nissan_Tianlai_20 /* 721086 */:
            case FinalCanbus.CAR_RZC_Nissan_Tianlai_20_H /* 786622 */:
            case FinalCanbus.CAR_RZC_Nissan_Qijun_H /* 983230 */:
            case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_14 /* 1966270 */:
            case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_11 /* 2031806 */:
            case FinalCanbus.CAR_RZC_Nissan_PATROL_13 /* 2097342 */:
            case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_14_H /* 2228414 */:
            case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_11_H /* 2293950 */:
            case FinalCanbus.CAR_RZC_Nissan_PATROL_13_H /* 2359486 */:
            case FinalCanbus.CAR_RZC_Nissan_Xtrail_Import_22 /* 2425022 */:
            case FinalCanbus.CAR_RZC_Nissan_Xtrail_Import_22_H /* 2490558 */:
            case FinalCanbus.CAR_RZC_Nissan_Tuda_18 /* 2556094 */:
            case FinalCanbus.CAR_RZC_Nissan_Tuda_18_H /* 2621630 */:
            case FinalCanbus.CAR_RZC_Nissan_NAVANA_16 /* 2687166 */:
            case FinalCanbus.CAR_RZC_Nissan_NAVANA_16_H /* 2752702 */:
            case FinalCanbus.CAR_RZC_Nissan_SENTRA_18_Import /* 2818238 */:
            case FinalCanbus.CAR_RZC_Nissan_SENTRA_18_Import_H /* 2883774 */:
            case FinalCanbus.CAR_RZC_Nissan_TITAN_19_Import /* 2949310 */:
            case FinalCanbus.CAR_RZC_Nissan_TITAN_19_Import_H /* 3014846 */:
            case FinalCanbus.CAR_RZC_Nissan_SENTRA_13_Import /* 3080382 */:
            case FinalCanbus.CAR_RZC_Nissan_SENTRA_13_Import_H /* 3145918 */:
            case FinalCanbus.CAR_RZC_Sanlin_OULANDE_24Overseas /* 3276990 */:
            case FinalCanbus.CAR_RZC_Sanlin_OULANDE_24Overseas_H /* 3342526 */:
            case FinalCanbus.CAR_RZC_Sanlin_Triton_25Overseas /* 3539134 */:
            case FinalCanbus.CAR_RZC_Sanlin_Triton_25Overseas_H /* 3604670 */:
            case FinalCanbus.CAR_RZC_Nissan_Rogue_14Overseas /* 3670206 */:
            case FinalCanbus.CAR_RZC_Nissan_Rogue_14Overseas_H /* 3735742 */:
            case FinalCanbus.CAR_RZC_Nissan_Rogue_21Overseas /* 3801278 */:
            case FinalCanbus.CAR_RZC_Nissan_Rogue_21Overseas_H /* 3866814 */:
            case FinalCanbus.CAR_RZC_Nissan_Altima_19Overseas /* 3932350 */:
            case FinalCanbus.CAR_RZC_Nissan_Altima_19Overseas_H /* 3997886 */:
            case FinalCanbus.CAR_RZC_Nissan_Pathfinder_22Overseas /* 4063422 */:
            case FinalCanbus.CAR_RZC_Nissan_Pathfinder_22Overseas_H /* 4128958 */:
            case FinalCanbus.CAR_RZC_Nissan_Pathfinder_20Overseas /* 4653246 */:
            case FinalCanbus.CAR_RZC_Nissan_Pathfinder_20Overseas_H /* 4718782 */:
            case FinalCanbus.CAR_439_RZC_Nissan_19Qida /* 8585655 */:
            case FinalCanbus.CAR_439_RZC_Nissan_19Qida_H /* 8651191 */:
                int ints46 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints47 = ints46 | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0);
                if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                        ints47 = 8;
                    } else {
                        ints47 = 4;
                    }
                }
                int ints48 = 0 | (data0 == ConstAllAirDara.C_AIR_DUAL ? 8 : 0);
                int ints49 = ints48 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints50 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints51 = ints50 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints52 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                int ints53 = ints52 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                int ints54 = 0 | (data0 == ConstAllAirDara.C_REAR_CTRL ? 4 : 0);
                int ints55 = ints54 | (data0 == ConstAllAirDara.C_AIR_BLOWTOP ? 2 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints47, ints49, 0, ints51, ints53, ints55}, null, null);
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                }
                break;
            case FinalCanbus.CAR_RZC_19MingjueHS /* 852241 */:
            case FinalCanbus.CAR_RZC_19RongWei_I5 /* 917777 */:
            case FinalCanbus.CAR_RZC_19RongWei_I6 /* 983313 */:
            case FinalCanbus.CAR_RZC_19MingjueHS_H /* 1048849 */:
            case FinalCanbus.CAR_RZC_19RongWei_I5_H /* 1114385 */:
            case FinalCanbus.CAR_RZC_19RongWei_RX8 /* 1310993 */:
            case FinalCanbus.CAR_RZC_Mingjue_20ZS /* 1376529 */:
            case FinalCanbus.CAR_RZC_Mingjue_20ZS_H /* 1442065 */:
            case FinalCanbus.CAR_RZC_19Mingjue_MG6 /* 1507601 */:
            case FinalCanbus.CAR_RZC_18RongWei_RX8 /* 1638673 */:
            case FinalCanbus.CAR_RZC_20RongWei_RX5 /* 1704209 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_21 /* 1835281 */:
            case FinalCanbus.CAR_RZC_21RongWei_I5 /* 1900817 */:
            case FinalCanbus.CAR_RZC_21RongWei_I5_H /* 1966353 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_21_L /* 2031889 */:
            case FinalCanbus.CAR_CZH_RZC_19Mingjue_MG6 /* 2097425 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_22_Top /* 2162961 */:
            case FinalCanbus.CAR_RZC_23MingjueHS /* 2228497 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_25 /* 2294033 */:
            case FinalCanbus.CAR_RZC_23RongWei_I5 /* 2425105 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_21_Top /* 2490641 */:
            case FinalCanbus.CAR_RZC_MingJue_MG6_21_Pro /* 2556177 */:
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD) {
                        data0 = 1;
                        data1 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                        data0 = 1;
                        data1 = 2;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        data0 = 21;
                        data1 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        data0 = 21;
                        data1 = 2;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        data0 = 4;
                        data1 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        data0 = 4;
                        data1 = 2;
                    } else if (data0 == ConstAllAirDara.C_REAR_LEFT_TEMP_UP || data0 == ConstAllAirDara.C_REAR_RIGHT_TEMP_UP) {
                        data0 = 24;
                        data1 = 1;
                    } else if (data0 == ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN || data0 == ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN) {
                        data0 = 24;
                        data1 = 2;
                    } else if (data0 == ConstAllAirDara.C_REAR_WIND_UP) {
                        data0 = 20;
                        data1 = 1;
                    } else if (data0 == ConstAllAirDara.C_REAR_WIND_DOWN) {
                        data0 = 20;
                        data1 = 2;
                    } else if (data0 == ConstAllAirDara.C_REAR_MODE_BODY) {
                        data0 = 25;
                        data1 = 1;
                    } else if (data0 == ConstAllAirDara.C_REAR_MODE_FOOT) {
                        data0 = 25;
                        data1 = 3;
                    } else if (data0 == ConstAllAirDara.C_REAR_MODE_BODY_FOOT) {
                        data0 = 25;
                        data1 = 2;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODY) {
                        data0 = 16;
                        data1 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT) {
                        data0 = 16;
                        data1 = 2;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_FOOT) {
                        data0 = 16;
                        data1 = 3;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT) {
                        data0 = 16;
                        data1 = 4;
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD || data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                    data0 = 1;
                } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD || data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                    data0 = 21;
                } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD || data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                    data0 = 4;
                } else if (data0 == ConstAllAirDara.C_REAR_LEFT_TEMP_UP || data0 == ConstAllAirDara.C_REAR_RIGHT_TEMP_UP || data0 == ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN || data0 == ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN) {
                    data0 = 24;
                } else if (data0 == ConstAllAirDara.C_REAR_WIND_UP || data0 == ConstAllAirDara.C_REAR_WIND_DOWN) {
                    data0 = 20;
                } else if (data0 == ConstAllAirDara.C_REAR_MODE_BODY || data0 == ConstAllAirDara.C_REAR_MODE_FOOT || data0 == ConstAllAirDara.C_REAR_MODE_BODY_FOOT) {
                    data0 = 25;
                } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODY || data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT || data0 == ConstAllAirDara.C_AIR_MODE_FOOT || data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT) {
                    data0 = 16;
                }
                DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                break;
            case FinalCanbus.CAR_446_WY_HCX_BBA_Screen /* 983486 */:
            case FinalCanbus.CAR_446_WY_HCX_BYD_TANG_Screen /* 1049022 */:
            case FinalCanbus.CAR_446_WY_HCX_BYD_QIN_Screen /* 1114558 */:
            case FinalCanbus.CAR_446_WY_HCX_WAY_VV7 /* 1442238 */:
            case FinalCanbus.CAR_446_WY_HCX_WAY_P8 /* 1507774 */:
            case FinalCanbus.CAR_446_WY_HCX_WAY_VV5 /* 1573310 */:
            case FinalCanbus.CAR_446_WY_HCX_WAY_VV6 /* 1638846 */:
            case FinalCanbus.CAR_444_WY_HCX_Chuanqi_21GS8_Screen /* 7012796 */:
                Log.v("zed", " data0) == " + data0 + " data1) == " + data1);
                int ints56 = 0;
                int flag = 0;
                if (data0 == ConstAllAirDara.C_AIR_POWER) {
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_POWER] != 0) {
                        ints56 = 2;
                    } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_POWER] == 0) {
                        ints56 = 1;
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_AC) {
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 1) {
                        ints56 = 4;
                    } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 0) {
                        ints56 = 3;
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                        ints56 = 19;
                    } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 0) {
                        ints56 = 20;
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST) {
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 1) {
                        ints56 = 16;
                    } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 0) {
                        ints56 = 15;
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST) {
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 1) {
                        ints56 = 18;
                    } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 0) {
                        ints56 = 17;
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_SYNC) {
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_SYNC] == 0) {
                        ints56 = 28;
                    } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_SYNC] == 1) {
                        ints56 = 29;
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_SYNC) {
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_SYNC] == 1) {
                        ints56 = 28;
                    } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_SYNC] == 0) {
                        ints56 = 29;
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_BLOWTOP) {
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOWTOP] == 1) {
                        ints56 = 31;
                    } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOWTOP] == 0) {
                        ints56 = 30;
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_446_WY_HCX_WAY_VV7 /* 1442238 */:
                        case FinalCanbus.CAR_446_WY_HCX_WAY_P8 /* 1507774 */:
                        case FinalCanbus.CAR_446_WY_HCX_WAY_VV5 /* 1573310 */:
                        case FinalCanbus.CAR_446_WY_HCX_WAY_VV6 /* 1638846 */:
                            ints56 = data0;
                            break;
                        default:
                            flag = 1;
                            int value8 = (DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] / 2) + 1;
                            if (value8 > 7) {
                                value8 = 7;
                            }
                            if (data1 == 1) {
                                DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{162, 0, value8}, null, null);
                            }
                            break;
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_446_WY_HCX_WAY_VV7 /* 1442238 */:
                        case FinalCanbus.CAR_446_WY_HCX_WAY_P8 /* 1507774 */:
                        case FinalCanbus.CAR_446_WY_HCX_WAY_VV5 /* 1573310 */:
                        case FinalCanbus.CAR_446_WY_HCX_WAY_VV6 /* 1638846 */:
                            ints56 = data0;
                            break;
                        default:
                            flag = 1;
                            int value9 = (DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] / 2) - 1;
                            if (value9 < 0) {
                                value9 = 0;
                            }
                            if (data1 == 1) {
                                DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{162, 0, value9}, null, null);
                            }
                            break;
                    }
                } else {
                    ints56 = data0;
                }
                Log.v("zed", " ints0) == " + ints56 + " flag) == " + flag);
                if (flag == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints56, data1, 0}, null, null);
                }
                break;
            case FinalCanbus.CAR_RZC_XP1_BeiQiBJ40_21_H /* 1048972 */:
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{3, data1}, null, null);
                        } else {
                            DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{4, data1}, null, null);
                        }
                    } else {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                    }
                }
                break;
            case FinalCanbus.CAR_DJ_XC_TOYOTA_LEXUS /* 1049005 */:
                if (this.pagenum == 0) {
                    DataCanbus.PROXY.cmd(3, new int[]{data0, data1}, null, null);
                } else if (this.pagenum == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_REAR_MANUAL) {
                        DataCanbus.PROXY.cmd(3, new int[]{64, data1}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(6, new int[]{data0, data1}, null, null);
                    }
                }
                break;
            case FinalCanbus.CAR_455_LZ_GMC_Sierra_19_RScreen /* 1507783 */:
            case FinalCanbus.CAR_455_LZ_Chevrolet_Silverado_19_RScreen /* 1573319 */:
            case FinalCanbus.CAR_455_LZ_GM_Cadillac_CT5_Screen /* 5439943 */:
            case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_Screen /* 9437639 */:
            case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_Screen /* 9503175 */:
            case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_RScreen /* 9568711 */:
            case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_RScreen /* 9634247 */:
            case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
            case FinalCanbus.CAR_454_LZ_Chevrolet_Silverado_19_Screen /* 11993542 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_4Screen /* 15729095 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_4Screen /* 15794631 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_8Screen /* 15860167 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_8Screen /* 15925703 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{1, data0}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{1, 0}, null, null);
                }
                break;
            case FinalCanbus.CAR_CZH_OD_NISSAN_22Teana_Top /* 1572944 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_22Teana_Top_360View /* 1638480 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_16Trail /* 1704016 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_16Trail_H /* 1769552 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_16Xiaoke /* 1835088 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_16Xiaoke_H /* 1900624 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Xima_L /* 1966160 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Xima_H /* 2031696 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Loulan_L /* 2097232 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Loulan_H /* 2162768 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Tianlai_L /* 2228304 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Tianlai_H /* 2293840 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Xuanyi_L /* 2359376 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Xuanyi_H /* 2424912 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Lanniao_L /* 2490448 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Lannia_H /* 2555984 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Qida_L /* 2621520 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Qida_H /* 2687056 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Jinke_L /* 2752592 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Jinke_H /* 2818128 */:
            case FinalCanbus.CAR_455_OD_RZC_DongFeng_Fengxing_16CM7 /* 11469255 */:
            case FinalCanbus.CAR_455_OD_YDT_DongFeng_Fengxing_18T5 /* 11534791 */:
                if (data1 == 1) {
                    int ints57 = 0;
                    int ints58 = 0;
                    if (data0 == ConstAllAirDara.C_AIR_POWER) {
                        ints57 = 168;
                        ints58 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        ints57 = 160;
                        ints58 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        ints57 = 160;
                        ints58 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD) {
                        ints57 = 161;
                        ints58 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                        ints57 = 161;
                        ints58 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        ints57 = 162;
                        ints58 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        ints57 = 162;
                        ints58 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODY) {
                        ints57 = 163;
                        ints58 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT) {
                        ints57 = 163;
                        ints58 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT) {
                        ints57 = 163;
                        ints58 = 2;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_FOOT) {
                        ints57 = 163;
                        ints58 = 3;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_UP) {
                        ints57 = 163;
                        ints58 = 4;
                    } else if (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST) {
                        ints57 = 166;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 1) {
                            ints58 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 0) {
                            ints58 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_AC) {
                        ints57 = 164;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 1) {
                            ints58 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 0) {
                            ints58 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        ints57 = 165;
                        if (DataCanbus.DATA[1000] == 11469255 || DataCanbus.DATA[1000] == 11534791) {
                            if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                                ints58 = 1;
                            } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 0) {
                                ints58 = 0;
                            }
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            ints58 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 0) {
                            ints58 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST) {
                        ints57 = 167;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 1) {
                            ints58 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 0) {
                            ints58 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_AUTO) {
                        ints57 = 169;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 1) {
                            ints58 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 0) {
                            ints58 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_AC_MAX) {
                        ints57 = 170;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC_MAX] == 1) {
                            ints58 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC_MAX] == 0) {
                            ints58 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_SYNC) {
                        ints57 = 171;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_SYNC] == 1) {
                            ints58 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_SYNC] == 0) {
                            ints58 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_AQS) {
                        ints57 = 175;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AQS] == 1) {
                            ints58 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AQS] == 0) {
                            ints58 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_ION) {
                        ints57 = 174;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_ION] == 1) {
                            ints58 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_ION] == 0) {
                            ints58 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_STEER) {
                        ints57 = 182;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_STEER] == 1) {
                            ints58 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_STEER] == 0) {
                            ints58 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT) {
                        ints57 = 172;
                        int ints59 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT];
                        ints58 = ints59 + 1;
                        if (ints58 > 2) {
                            ints58 = 0;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT) {
                        ints57 = 173;
                        int ints60 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT];
                        ints58 = ints60 + 1;
                        if (ints58 > 2) {
                            ints58 = 0;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_LEFT_COLD) {
                        ints57 = 174;
                        int ints61 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_LEFT];
                        ints58 = ints61 + 1;
                        if (ints58 > 3) {
                            ints58 = 0;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_RIGHT_COLD) {
                        ints57 = 175;
                        int ints62 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_RIGHT];
                        ints58 = ints62 + 1;
                        if (ints58 > 3) {
                            ints58 = 0;
                        }
                    }
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints57, ints58}, null, null);
                }
                break;
            case FinalCanbus.CAR_446_Xiaolin_WY_LEXUS_Screen /* 2097598 */:
            case FinalCanbus.CAR_446_Xiaolin_WY_LEXUS_Screen_H /* 2163134 */:
            case FinalCanbus.CAR_444_WY_LEXUS_Screen /* 6095292 */:
            case FinalCanbus.CAR_444_WY_LEXUS_Screen_H /* 6488508 */:
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_POWER) {
                        RemoteModuleProxy remoteModuleProxy11 = DataCanbus.PROXY;
                        int i11 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr11 = new int[2];
                        iArr11[0] = data0;
                        iArr11[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_POWER] == 1 ? 0 : 1;
                        remoteModuleProxy11.cmd(i11, iArr11, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_AC) {
                        RemoteModuleProxy remoteModuleProxy12 = DataCanbus.PROXY;
                        int i12 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr12 = new int[2];
                        iArr12[0] = data0;
                        iArr12[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 1 ? 0 : 1;
                        remoteModuleProxy12.cmd(i12, iArr12, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST) {
                        RemoteModuleProxy remoteModuleProxy13 = DataCanbus.PROXY;
                        int i13 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr13 = new int[2];
                        iArr13[0] = data0;
                        iArr13[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 1 ? 0 : 1;
                        remoteModuleProxy13.cmd(i13, iArr13, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST) {
                        RemoteModuleProxy remoteModuleProxy14 = DataCanbus.PROXY;
                        int i14 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr14 = new int[2];
                        iArr14[0] = data0;
                        iArr14[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 1 ? 0 : 1;
                        remoteModuleProxy14.cmd(i14, iArr14, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        RemoteModuleProxy remoteModuleProxy15 = DataCanbus.PROXY;
                        int i15 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr15 = new int[2];
                        iArr15[0] = data0;
                        iArr15[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1 ? 1 : 0;
                        remoteModuleProxy15.cmd(i15, iArr15, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_AUTO) {
                        RemoteModuleProxy remoteModuleProxy16 = DataCanbus.PROXY;
                        int i16 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr16 = new int[2];
                        iArr16[0] = data0;
                        iArr16[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 1 ? 0 : 1;
                        remoteModuleProxy16.cmd(i16, iArr16, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_DUAL) {
                        RemoteModuleProxy remoteModuleProxy17 = DataCanbus.PROXY;
                        int i17 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr17 = new int[2];
                        iArr17[0] = data0;
                        iArr17[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_DUAL] == 1 ? 0 : 1;
                        remoteModuleProxy17.cmd(i17, iArr17, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{17, 1}, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{17, 0}, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{7, 1}, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{7, 0}, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{8, 1}, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{8, 0}, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_ADD) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{12, 1}, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_SUB) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{12, 0}, null, null);
                    }
                }
                break;
            case FinalCanbus.CAR_453_LZ_GM_Camaro_17 /* 2163141 */:
            case FinalCanbus.CAR_453_LZ_GM_GMC_TERRAIN_17 /* 2228677 */:
            case FinalCanbus.CAR_453_LZ_GM_Equinox_17 /* 2294213 */:
            case FinalCanbus.CAR_454_LZ_GM_Camaro_17_Auto /* 6947270 */:
            case FinalCanbus.CAR_454_LZ_GM_Equinox_17_Auto /* 7012806 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{39, data0}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{39, 0}, null, null);
                }
                break;
            case FinalCanbus.CAR_444_WC2_Hongqi_H7 /* 3604924 */:
            case FinalCanbus.CAR_444_WC2_Hongqi_21EQM5 /* 5702076 */:
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        data1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] + 1;
                    }
                    if (data1 > 7) {
                        data1 = 7;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        data0 = ConstAllAirDara.C_AIR_WIND_ADD;
                        data1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] - 1;
                        if (data1 < 1) {
                            data1 = 1;
                        }
                    }
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                    break;
                } else if (data0 != ConstAllAirDara.C_AIR_WIND_ADD && data0 != ConstAllAirDara.C_AIR_WIND_SUB) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                    break;
                }
                break;
            case FinalCanbus.CAR_452_DJ_Dodge_JCUV /* 4981188 */:
            case FinalCanbus.CAR_455_DJ_Dodge_JCUV_SCREEN /* 15991239 */:
                if (this.pagenum == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{data0, data1}, null, null);
                } else if (this.pagenum == 1) {
                    DataCanbus.PROXY.cmd(1, new int[]{data0, data1}, null, null);
                }
                break;
            case FinalCanbus.CAR_WC2_CG_Honda_16Civic_H /* 5570881 */:
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_AC) {
                        RemoteModuleProxy remoteModuleProxy18 = DataCanbus.PROXY;
                        int i18 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr18 = new int[2];
                        iArr18[0] = data0;
                        iArr18[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 1 ? 0 : 1;
                        remoteModuleProxy18.cmd(i18, iArr18, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        int winlev3 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] + 1;
                        if (winlev3 > 7) {
                            winlev3 = 7;
                        }
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{25, winlev3}, null, null);
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        int winlev4 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] - 1;
                        if (winlev4 < 1) {
                            winlev4 = 1;
                        }
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{25, winlev4}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, 1}, null, null);
                    }
                    break;
                } else if (data0 != ConstAllAirDara.C_AIR_AC && data0 != ConstAllAirDara.C_AIR_WIND_ADD && data0 != ConstAllAirDara.C_AIR_WIND_SUB) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, 0}, null, null);
                    break;
                }
                break;
            case FinalCanbus.CAR_452_LZ_TATA_ALL /* 5898692 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{13, data0}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{13, 0}, null, null);
                }
                break;
            case FinalCanbus.CAR_453_RZC_LandRover_Discovery_19 /* 6160837 */:
            case FinalCanbus.CAR_454_RZC_LandRover_Discovery_04 /* 9765318 */:
            case FinalCanbus.CAR_452_KYC_Zhonghua_All /* 10617284 */:
            case FinalCanbus.CAR_452_KYC_Zhonghua_All_H /* 10682820 */:
            case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7 /* 10748356 */:
            case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7_H /* 10813892 */:
            case FinalCanbus.CAR_454_KYC_Ford_Mustang_07_H /* 13631942 */:
            case FinalCanbus.CAR_454_KYC_Ford_Mustang_07_L /* 13697478 */:
            case FinalCanbus.CAR_455_RZC_LandRover_Ranger_11 /* 13959623 */:
            case FinalCanbus.CAR_455_RZC_LandRover_Ranger_10 /* 14025159 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0}, null, null);
                }
                break;
            case FinalCanbus.CAR_455_RZC_Benz_Vito_24 /* 6291911 */:
            case FinalCanbus.CAR_455_RZC_Benz_Vito_24_H /* 6488519 */:
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        data1 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        data0 = ConstAllAirDara.C_AIR_WIND_ADD;
                        data1 = 2;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD) {
                        data1 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                        data0 = ConstAllAirDara.C_AIR_TEMP_LEFT_ADD;
                        data1 = 2;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        data1 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        data0 = ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD;
                        data1 = 2;
                    } else if (data0 == ConstAllAirDara.C_REAR_WIND_UP) {
                        data1 = 1;
                    } else if (data0 == ConstAllAirDara.C_REAR_WIND_DOWN) {
                        data0 = ConstAllAirDara.C_REAR_WIND_UP;
                        data1 = 2;
                    } else if (data0 == ConstAllAirDara.C_REAR_LEFT_TEMP_UP) {
                        data1 = 1;
                    } else if (data0 == ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN) {
                        data0 = ConstAllAirDara.C_REAR_LEFT_TEMP_UP;
                        data1 = 2;
                    } else if (data0 == ConstAllAirDara.C_REAR_RIGHT_TEMP_UP) {
                        data1 = 1;
                    } else if (data0 == ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN) {
                        data0 = ConstAllAirDara.C_REAR_RIGHT_TEMP_UP;
                        data1 = 2;
                    }
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                } else {
                    if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        data0 = ConstAllAirDara.C_AIR_WIND_ADD;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                        data0 = ConstAllAirDara.C_AIR_TEMP_LEFT_ADD;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        data0 = ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD;
                    } else if (data0 == ConstAllAirDara.C_REAR_WIND_DOWN) {
                        data0 = ConstAllAirDara.C_REAR_WIND_UP;
                    } else if (data0 == ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN) {
                        data0 = ConstAllAirDara.C_REAR_LEFT_TEMP_UP;
                    } else if (data0 == ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN) {
                        data0 = ConstAllAirDara.C_REAR_RIGHT_TEMP_UP;
                    }
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                }
                break;
            case FinalCanbus.CAR_455_LZ_Dodge_RAM1500 /* 6357447 */:
            case FinalCanbus.CAR_455_LZ_Dodge_RAM1500_H /* 6422983 */:
            case FinalCanbus.CAR_455_6606_LZ_Dodge_RAM1500 /* 14877127 */:
            case FinalCanbus.CAR_455_6606_LZ_Dodge_RAM1500_H /* 14942663 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{24, data0}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{24, 0}, null, null);
                }
                break;
            case FinalCanbus.CAR_452_XC_Ford_Escape_13_17 /* 6422980 */:
            case FinalCanbus.CAR_452_XC_Ford_edge_11_13 /* 6488516 */:
            case FinalCanbus.CAR_452_XC_Ford_Raptor_F150_09_14 /* 6554052 */:
            case FinalCanbus.CAR_452_XC_Ford_edge_15_17 /* 6619588 */:
            case FinalCanbus.CAR_452_XC_Ford_Mondeo_13_18 /* 6685124 */:
            case FinalCanbus.CAR_439_HC_Ford_Explorer /* 15335863 */:
                if (this.pagenum == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{data0, data1}, null, null);
                } else if (this.pagenum == 1) {
                    DataCanbus.PROXY.cmd(5, new int[]{data0, data1}, null, null);
                }
                break;
            case FinalCanbus.CAR_452_OD_Zotye_T700 /* 6816196 */:
                int ints63 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints64 = ints63 | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_AC_MAX ? 1 : 0);
                if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                        ints64 = 8;
                    } else {
                        ints64 = 4;
                    }
                }
                int ints65 = 0 | (data0 == ConstAllAirDara.C_AIR_DUAL ? 8 : 0);
                int ints66 = ints65 | (data0 == ConstAllAirDara.C_REAR_CTRL ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints67 = 0 | (data0 == ConstAllAirDara.C_AIR_MODE_UP ? 160 : 0);
                int ints68 = ints67 | (data0 == ConstAllAirDara.C_AIR_MODE_BODY ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_FOOT ? 96 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT ? 128 : 0);
                int ints69 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints70 = ints69 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints71 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                int ints72 = ints71 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                int ints73 = 0 | (data0 == ConstAllAirDara.C_AIR_ION ? 16 : 0);
                int ints74 = ints73 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT ? 1 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints64, ints66, ints68, ints70, ints72, ints74}, null, null);
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                }
                break;
            case FinalCanbus.CAR_452_LZ_Jaguar_F_TYPE /* 6881732 */:
            case FinalCanbus.CAR_452_LZ_Jaguar_XJL /* 7012804 */:
            case FinalCanbus.CAR_452_LZ_Jaguar_XFL_PACE /* 12779972 */:
            case FinalCanbus.CAR_452_LZ_Jaguar_XFL_PACE_H /* 13238724 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{8, data0}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{8, 0}, null, null);
                }
                break;
            case FinalCanbus.CAR_RZC_HavalH6Couple_BLUE_TOP /* 7078327 */:
            case FinalCanbus.CAR_RZC_HavalH6Couple_RED_TOP /* 7143863 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6Couple_19 /* 7602615 */:
            case FinalCanbus.CAR_439_RZC_Haval_18_19H6 /* 11272631 */:
                if (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT) {
                    if (data1 == 1) {
                        int ints75 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT];
                        int ints76 = ints75 + 1;
                        if (ints76 > 3) {
                            ints76 = 0;
                        }
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{44, ints76}, null, null);
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT) {
                    if (data1 == 1) {
                        int ints77 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT];
                        int ints78 = ints77 + 1;
                        if (ints78 > 3) {
                            ints78 = 0;
                        }
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{45, ints78}, null, null);
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_LEFT_COLD) {
                    if (data1 == 1) {
                        int ints79 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_LEFT];
                        int ints80 = ints79 + 1;
                        if (ints80 > 3) {
                            ints80 = 0;
                        }
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{46, ints80}, null, null);
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_RIGHT_COLD) {
                    if (data1 == 1) {
                        int ints81 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_RIGHT];
                        int ints82 = ints81 + 1;
                        if (ints82 > 3) {
                            ints82 = 0;
                        }
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{47, ints82}, null, null);
                    }
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                }
                break;
            case FinalCanbus.CAR_455_OD_CZH_Qichen_D60_EV /* 7799239 */:
            case FinalCanbus.CAR_455_YDT_OD_Qichen_D60_EV /* 8913351 */:
            case FinalCanbus.CAR_454_OD_Qichen_D60_EV /* 9961926 */:
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        data1 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        data0 = ConstAllAirDara.C_AIR_WIND_ADD;
                        data1 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD) {
                        data1 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                        data0 = ConstAllAirDara.C_AIR_TEMP_LEFT_ADD;
                        data1 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        data1 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        data0 = ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD;
                        data1 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_AC) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 1) {
                            data1 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 0) {
                            data1 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 1) {
                            data1 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_SYNC) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_SYNC] == 1) {
                            data1 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_SYNC] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_AUTO) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 1) {
                            data1 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_AC_MAX) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC_MAX] == 1) {
                            data1 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC_MAX] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST) {
                        data0 = 163;
                        data1 = 4;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODY) {
                        data0 = 163;
                        data1 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT) {
                        data0 = 163;
                        data1 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_FOOT) {
                        data0 = 163;
                        data1 = 3;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT) {
                        data0 = 163;
                        data1 = 2;
                    }
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                }
                break;
            case FinalCanbus.CAR_453_LZ_ALFA_ROMEO /* 7930309 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{34, data0}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{34, 0}, null, null);
                }
                break;
            case FinalCanbus.CAR_455_LZ_Benz_C200_NTG5 /* 8192455 */:
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER) {
                        int up = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT];
                        int body = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT];
                        int foot = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT];
                        int auto = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_AUTO_LEFT];
                        if (auto == 1) {
                            data0 = 13;
                        } else if (up == 1 && body == 0 && foot == 1) {
                            data0 = 12;
                        } else if (up == 1 && body == 1 && foot == 1) {
                            data0 = 11;
                        } else if (up == 1 && body == 1 && foot == 0) {
                            data0 = 10;
                        } else if (up == 1 && body == 0 && foot == 0) {
                            data0 = 17;
                        } else if (up == 0 && body == 1 && foot == 0) {
                            data0 = 16;
                        } else if (up == 0 && body == 1 && foot == 1) {
                            data0 = 15;
                        } else if (up == 0 && body == 0 && foot == 1) {
                            data0 = 14;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT) {
                        int up2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_RIGHT];
                        int body2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT];
                        int foot2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT];
                        int auto2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_AUTO_RIGHT];
                        if (auto2 == 1) {
                            data0 = 21;
                        } else if (up2 == 1 && body2 == 0 && foot2 == 1) {
                            data0 = 20;
                        } else if (up2 == 1 && body2 == 1 && foot2 == 1) {
                            data0 = 19;
                        } else if (up2 == 1 && body2 == 1 && foot2 == 0) {
                            data0 = 18;
                        } else if (up2 == 1 && body2 == 0 && foot2 == 0) {
                            data0 = 25;
                        } else if (up2 == 0 && body2 == 1 && foot2 == 0) {
                            data0 = 24;
                        } else if (up2 == 0 && body2 == 1 && foot2 == 1) {
                            data0 = 23;
                        } else if (up2 == 0 && body2 == 0 && foot2 == 1) {
                            data0 = 22;
                        }
                    }
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{16, data0}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{16, 0}, null, null);
                }
                break;
            case FinalCanbus.CAR_455_RZC_Jianghuai_Sihao_X6 /* 8389063 */:
                if (data1 == 1) {
                    int ints83 = 0;
                    int ints84 = 0;
                    int ints85 = 0;
                    if (data0 == ConstAllAirDara.C_AIR_POWER) {
                        ints83 = 1;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] != 0) {
                            ints84 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] == 0) {
                            ints84 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_AC) {
                        ints83 = 2;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 1) {
                            ints84 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 0) {
                            ints84 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        ints83 = 3;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            ints84 = 1;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 0) {
                            ints84 = 0;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODY) {
                        ints83 = 4;
                        ints84 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT) {
                        ints83 = 4;
                        ints84 = 2;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT) {
                        ints83 = 4;
                        ints84 = 4;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_FOOT) {
                        ints83 = 4;
                        ints84 = 3;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_UP) {
                        ints83 = 4;
                        ints84 = 5;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        ints83 = 5;
                        ints84 = 128;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        ints83 = 5;
                        ints84 = 129;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD) {
                        ints83 = 6;
                        ints84 = 0;
                        ints85 = 128;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                        ints83 = 6;
                        ints84 = 0;
                        ints85 = 129;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        ints83 = 6;
                        ints84 = 1;
                        ints85 = 128;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        ints83 = 6;
                        ints84 = 1;
                        ints85 = 129;
                    } else if (data0 == ConstAllAirDara.C_AIR_AC_MAX) {
                        ints83 = 7;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC_MAX] == 1) {
                            ints84 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC_MAX] == 0) {
                            ints84 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST) {
                        ints83 = 8;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 1) {
                            ints84 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 0) {
                            ints84 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST) {
                        ints83 = 9;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 1) {
                            ints84 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 0) {
                            ints84 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT) {
                        ints83 = 16;
                        ints84 = 0;
                        int value10 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT];
                        ints85 = value10 >= 4 ? 1 : value10 == 3 ? 0 : value10 + 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT) {
                        ints83 = 16;
                        ints84 = 1;
                        int value11 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT];
                        ints85 = value11 >= 4 ? 1 : value11 == 3 ? 0 : value11 + 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_LEFT_COLD) {
                        ints83 = 16;
                        ints84 = 0;
                        int value12 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT];
                        ints85 = value12 <= 3 ? 4 : value12 == 6 ? 0 : value12 + 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT) {
                        ints83 = 16;
                        ints84 = 1;
                        int value13 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT];
                        ints85 = value13 <= 3 ? 4 : value13 == 6 ? 0 : value13 + 1;
                    }
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints83, ints84, ints85}, null, null);
                }
                break;
            case FinalCanbus.CAR_453_LZ_Jili_Boyue_18 /* 8782277 */:
            case FinalCanbus.CAR_453_LZ_Jili_Boyue_18_H /* 8847813 */:
                int ints86 = 0;
                int ints87 = 0;
                int ints88 = 0;
                int ints89 = 0;
                int ints90 = 0;
                int ints91 = 0;
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST) {
                        ints86 = 128;
                        ints87 = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 1 ? 0 : 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        ints86 = 64;
                        ints87 = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1 ? 0 : 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_AUTO) {
                        ints86 = 32;
                        ints87 = DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 1 ? 0 : 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_AC) {
                        ints86 = 16;
                        ints87 = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 1 ? 0 : 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_AC_MAX) {
                        ints86 = 8;
                        ints87 = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC_MAX] == 1 ? 0 : 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_DUAL) {
                        ints86 = 4;
                        ints87 = DataCanbus.DATA[ConstAllAirDara.U_AIR_DUAL] == 1 ? 0 : 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_ION) {
                        ints86 = 2;
                        ints87 = DataCanbus.DATA[ConstAllAirDara.U_AIR_ION] == 1 ? 0 : 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST) {
                        ints86 = 1;
                        ints87 = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 1 ? 0 : 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        int winlev5 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                        if (winlev5 < 8) {
                            winlev5++;
                        }
                        ints88 = winlev5 | 128;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        int winlev6 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                        if (winlev6 > 0) {
                            winlev6--;
                        }
                        ints88 = winlev6 | 128;
                    } else if (data0 == ConstAllAirDara.C_AIR_POWER) {
                        ints88 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] != 0 ? 128 : 129;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODY) {
                        ints89 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_FOOT) {
                        ints89 = 2;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT) {
                        ints89 = 3;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT) {
                        ints89 = 4;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                        int value14 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT];
                        ints90 = value14 == -2 ? 1 : value14 == -3 ? 15 : value14 - 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD) {
                        int value15 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT];
                        ints90 = value15 == -2 ? 2 : value15 == -3 ? 16 : value15 + 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        int value16 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_RIGHT];
                        ints91 = value16 == -2 ? 1 : value16 == -3 ? 15 : value16 - 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        int value17 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_RIGHT];
                        ints91 = value17 == -2 ? 2 : value17 == -3 ? 16 : value17 + 1;
                    }
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints86, ints87, ints88, ints89, ints90, ints91, 0}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[7], null, null);
                }
                break;
            case FinalCanbus.CAR_454_RZC_Shanqi_DelongG2 /* 10027462 */:
                int ints92 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints93 = ints92 | (data0 == ConstAllAirDara.C_AIR_AC ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 8 : 0);
                int ints94 = 0 | (data0 == ConstAllAirDara.C_AIR_MODE_BODY ? 16 : 0);
                int ints95 = ints94 | (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_FOOT ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UP ? 1 : 0);
                int ints96 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints97 = ints96 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0) | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                int ints98 = 0 | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0);
                int ints99 = ints98 | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints93, ints95, ints97, 0, ints99}, null, null);
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[5], null, null);
                }
                break;
            case FinalCanbus.CAR_455_LUZ_Benz_GLC_NTG50 /* 10027463 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{0, data0}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[2], null, null);
                }
                break;
            case FinalCanbus.CAR_454_OD_Yutong_Qingka /* 11338182 */:
                int ints100 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints101 = ints100 | (data0 == ConstAllAirDara.C_AIR_PTC ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_AC_MAX ? 1 : 0);
                int ints102 = 0 | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0);
                int ints103 = ints102 | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints104 = 0 | (data0 == ConstAllAirDara.C_AIR_MODE_BODY ? 1 : 0);
                int ints105 = ints104 | (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_FOOT ? 3 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UP ? 5 : 0);
                int ints106 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints107 = ints106 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints108 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                int ints109 = ints108 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints101, ints103, ints105, ints107, ints109, 0}, null, null);
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                }
                break;
            case FinalCanbus.CAR_452_OD_Qirui_Xiaomayi /* 12517828 */:
                int ints110 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints111 = ints110 | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_PTC ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 1 : 0);
                int ints112 = 0 | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0);
                int ints113 = ints112 | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints114 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints115 = ints114 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints116 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                int ints117 = ints116 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints111, ints113, 0, ints115, ints117, 0}, null, null);
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                }
                break;
            default:
                DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                break;
        }
    }

    public void initCallbackId() {
        ConstAllAirDara.initClearAllId();
        switch (DataCanbus.DATA[1000]) {
            case 25:
            case 26:
            case 253:
            case FinalCanbus.CAR_XP1_GM_H1 /* 65561 */:
            case FinalCanbus.CAR_XP1_GM_H2 /* 131097 */:
            case FinalCanbus.CAR_XP1_GM_H3 /* 196633 */:
            case FinalCanbus.CAR_XP1_GM_Camaro_10 /* 262169 */:
            case FinalCanbus.CAR_XP1_GM_Silverado_14_Hand /* 458777 */:
            case FinalCanbus.CAR_XP1_GM_Silverado_14_Auto /* 524313 */:
            case FinalCanbus.CAR_XP1_GM_AJcd600 /* 2228249 */:
            case FinalCanbus.CAR_DJ_GM_ALL /* 2424857 */:
            case FinalCanbus.CAR_XP1_GM_AJcd650 /* 2490393 */:
            case FinalCanbus.CAR_XP1_GM_Opel_Meriva /* 2621465 */:
            case FinalCanbus.CAR_DJ_GM_Kopach /* 2687001 */:
                ConstAllAirDara.U_AIR_HAVE_REAR = 255;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_LEFT_COLD = 37;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 38;
                switch (DataCanbus.DATA[1000]) {
                    case 25:
                    case 26:
                    case FinalCanbus.CAR_XP1_GM_H1 /* 65561 */:
                    case FinalCanbus.CAR_XP1_GM_H2 /* 131097 */:
                    case FinalCanbus.CAR_XP1_GM_H3 /* 196633 */:
                    case FinalCanbus.CAR_XP1_GM_Silverado_14_Auto /* 524313 */:
                    case FinalCanbus.CAR_XP1_GM_AJcd600 /* 2228249 */:
                    case FinalCanbus.CAR_DJ_GM_ALL /* 2424857 */:
                    case FinalCanbus.CAR_XP1_GM_AJcd650 /* 2490393 */:
                    case FinalCanbus.CAR_XP1_GM_Opel_Meriva /* 2621465 */:
                    case FinalCanbus.CAR_DJ_GM_Kopach /* 2687001 */:
                        ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                        break;
                    case FinalCanbus.CAR_XP1_GM_Camaro_10 /* 262169 */:
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 255;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 255;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 255;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 255;
                        break;
                    case FinalCanbus.CAR_XP1_GM_Silverado_14_Hand /* 458777 */:
                        ConstAllAirDara.U_AIR_AUTO = 255;
                        ConstAllAirDara.U_AIR_DUAL = 255;
                        ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 24;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 22;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 23;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 33;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 34;
                ConstAllAirDara.C_AIR_MODE_BODY = 8;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 9;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 10;
                ConstAllAirDara.C_AIR_MODE_FOOT = 11;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 5;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_DUAL = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 20;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 21;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case 36:
            case 345:
            case FinalCanbus.CAR_WC2_ShuPingJW /* 65881 */:
            case FinalCanbus.CAR_WC2_ShuPingKeLuZi /* 131417 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao /* 196953 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS /* 262489 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS_S /* 328025 */:
            case FinalCanbus.CAR_WC2_GM_GL8 /* 393252 */:
            case FinalCanbus.CAR_WC2_GM_GL6 /* 458788 */:
            case FinalCanbus.CAR_WC2_ShuPing10JunYue /* 459097 */:
            case FinalCanbus.CAR_WC2_GM_WLD /* 524324 */:
            case FinalCanbus.CAR_WC2_ShuPingKeLuZi_Auto /* 524633 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao_L /* 590169 */:
            case FinalCanbus.CAR_WC2_GM_EXCELLE_19 /* 655396 */:
            case FinalCanbus.CAR_WC2_GM_EXCELLE_18 /* 720932 */:
            case FinalCanbus.CAR_WC2_GM_GL8_10_13 /* 786468 */:
            case FinalCanbus.CAR_WC2_GM_GL8_14_16 /* 852004 */:
            case FinalCanbus.CAR_WC2_GM_Encore_12_15 /* 917540 */:
            case FinalCanbus.CAR_WC2_GM_Encore_16_19 /* 983076 */:
            case FinalCanbus.CAR_WC2_GM_Regal_09_13 /* 1048612 */:
            case FinalCanbus.CAR_WC2_GM_Lacrosse_10_13 /* 1114148 */:
            case FinalCanbus.CAR_WC2_GM_Lacrosse_18 /* 1179684 */:
            case FinalCanbus.CAR_WC2_GM_Excelle_XT /* 1245220 */:
            case FinalCanbus.CAR_WC2_GM_Excelle_GT /* 1310756 */:
            case FinalCanbus.CAR_WC2_GM_AVEO_11 /* 1376292 */:
            case FinalCanbus.CAR_WC2_GM_Orlando_11 /* 1441828 */:
            case FinalCanbus.CAR_WC2_GM_Trax_13_18 /* 1507364 */:
            case FinalCanbus.CAR_WC2_GM_Cruze_08_14 /* 1572900 */:
            case FinalCanbus.CAR_WC2_GM_Cruze_15 /* 1638436 */:
            case FinalCanbus.CAR_WC2_GM_Malibu_13 /* 1703972 */:
            case FinalCanbus.CAR_WC2_GM_Spin_13 /* 1769508 */:
            case FinalCanbus.CAR_WC2_GM_Astra_09_14 /* 1835044 */:
            case FinalCanbus.CAR_WC2_GM_Astra_15 /* 1900580 */:
            case FinalCanbus.CAR_WC2_GM_Mokka_12_16 /* 1966116 */:
            case FinalCanbus.CAR_WC2_GM_MokkaX_17 /* 2031652 */:
            case FinalCanbus.CAR_WC2_GM_Insignia_08_12 /* 2097188 */:
            case FinalCanbus.CAR_WC2_GM_Insignia_13_16 /* 2162724 */:
            case FinalCanbus.CAR_WC2_GM_Regal_14 /* 2228260 */:
            case FinalCanbus.CAR_WC2_GM_ENVISION_14 /* 2293796 */:
            case FinalCanbus.CAR_WC2_GM_Lacrosse_14 /* 2359332 */:
            case FinalCanbus.CAR_WC2_GM_Verano_15 /* 2424868 */:
            case FinalCanbus.CAR_WC2_GM_Verano_GS_16 /* 2490404 */:
            case FinalCanbus.CAR_WC2_GM_MalibuXL_16_18 /* 2555940 */:
            case FinalCanbus.CAR_WC2_GM_MalibuXL_19 /* 2621476 */:
            case FinalCanbus.CAR_WC2_GM_Equinox_17 /* 2687012 */:
            case FinalCanbus.CAR_WC2_GM_Sail3_15 /* 2752548 */:
            case FinalCanbus.CAR_WC2_GM_Onix_16 /* 2818084 */:
            case FinalCanbus.CAR_WC2_GM_LOVA_16_18 /* 2883620 */:
            case FinalCanbus.CAR_WC2_GM_Excelle_15_18 /* 2949156 */:
            case FinalCanbus.CAR_WC2_GM_Monza_19 /* 3014692 */:
            case FinalCanbus.CAR_WC2_GM_GL8_28T_ES /* 3080228 */:
            case FinalCanbus.CAR_WC2_GM_GL8_20 /* 3145764 */:
            case FinalCanbus.CAR_WC2_GM_Trax_19 /* 3211300 */:
            case FinalCanbus.CAR_WC2_GM_Trailblazer_20 /* 3276836 */:
            case FinalCanbus.CAR_WC2_GM_S10_12 /* 3342372 */:
            case FinalCanbus.CAR_WC2_GM_Karl_15 /* 3407908 */:
            case FinalCanbus.CAR_WC2_GM_Encore_GX_20 /* 3473444 */:
            case FinalCanbus.CAR_WC2_GM_Encore_20 /* 3538980 */:
            case FinalCanbus.CAR_WC2_GM_CorsaE_14_19 /* 3604516 */:
            case FinalCanbus.CAR_WC2_GM_Adam_13_19 /* 3670052 */:
            case FinalCanbus.CAR_WC2_GM_Insignia_17 /* 3735588 */:
            case FinalCanbus.CAR_WC2_GM_Sierra_14_18 /* 3801124 */:
            case FinalCanbus.CAR_WC2_GM_Trailblazer_14_18 /* 3866660 */:
            case FinalCanbus.CAR_WC2_GM_Suburban_15 /* 3932196 */:
            case FinalCanbus.CAR_WC2_GM_Tahoe_16_18 /* 3997732 */:
            case FinalCanbus.CAR_WC2_GM_Colorado_18 /* 4063268 */:
            case FinalCanbus.CAR_WC2_GM_Kopach_12 /* 4128804 */:
            case FinalCanbus.CAR_WC2_OPEL_Meriva_10 /* 4194340 */:
            case FinalCanbus.CAR_WC2_GM_Onix_14 /* 4259876 */:
            case FinalCanbus.CAR_WC2_GM_Onix_19 /* 4325412 */:
            case FinalCanbus.CAR_WC2_GM_Montana_23 /* 4390948 */:
            case FinalCanbus.CAR_WC2_GM_Tracker_19 /* 4456484 */:
            case FinalCanbus.CAR_WC2_GM_Spin_Brazil_13 /* 4522020 */:
            case FinalCanbus.CAR_WC2_GM_S10_Brazil_10 /* 4587556 */:
            case FinalCanbus.CAR_WC2_GM_EQUINOX_22 /* 4653092 */:
            case FinalCanbus.CAR_WC2_GM_EQUINOX_22_H /* 4718628 */:
            case FinalCanbus.CAR_WC2_GM_Colorado_14 /* 4784164 */:
            case FinalCanbus.CAR_WC2_GM_Colorado_14_H /* 4849700 */:
            case FinalCanbus.CAR_WC2_GM_Silverado_07 /* 4915236 */:
            case FinalCanbus.CAR_WC2_GM_Silverado_14 /* 4980772 */:
            case FinalCanbus.CAR_WC2_GM_Silverado_14_H /* 5046308 */:
            case FinalCanbus.CAR_WC2_GM_Canyon_14 /* 5111844 */:
            case FinalCanbus.CAR_WC2_GM_Canyon_14_H /* 5177380 */:
            case FinalCanbus.CAR_WC2_GMC_Acadia_07 /* 5242916 */:
            case FinalCanbus.CAR_WC2_GMC_Yukon_07 /* 5308452 */:
            case FinalCanbus.CAR_WC2_GMC_Savana_08 /* 5373988 */:
            case FinalCanbus.CAR_WC2_GMC_Sierra_07 /* 5439524 */:
            case FinalCanbus.CAR_WC2_GMC_Sierra_14 /* 5505060 */:
            case FinalCanbus.CAR_WC2_GMC_Sierra_14_H /* 5570596 */:
            case FinalCanbus.CAR_WC2_GM_ExpressVan_08 /* 5636132 */:
            case FinalCanbus.CAR_WC2_GM_Impala_06 /* 5701668 */:
            case FinalCanbus.CAR_WC2_GM_Avalanch_07 /* 5767204 */:
            case FinalCanbus.CAR_WC2_GM_Escalade_07_Auto /* 5963812 */:
            case FinalCanbus.CAR_WC2_GM_XinJunWei2013 /* 6029348 */:
            case FinalCanbus.CAR_WC2_GM_SAIL3 /* 6094884 */:
            case FinalCanbus.CAR_WC2_GM_Excelle_19 /* 6160420 */:
            case FinalCanbus.CAR_WC2_GM_Excelle_21 /* 6225956 */:
            case FinalCanbus.CAR_WC2_GM_ExcelleGX_18 /* 6291492 */:
            case FinalCanbus.CAR_WC2_GM_Camaro_10 /* 6815780 */:
            case FinalCanbus.CAR_WC2_GMC_Yukon_14 /* 7143460 */:
            case FinalCanbus.CAR_WC2_GMC_Yukon_14_H /* 7208996 */:
            case FinalCanbus.CAR_WC2_GMC_Terrain_10 /* 7274532 */:
            case FinalCanbus.CAR_WC2_GM_EQUINOX_17 /* 7405604 */:
                ConstAllAirDara.TEMPERATURE_LOW = 254;
                ConstAllAirDara.TEMPERATURE_HIGHT = 255;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_AUTO = 49;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_WC2_GM_GL8 /* 393252 */:
                    case FinalCanbus.CAR_WC2_GM_Silverado_14_H /* 5046308 */:
                    case FinalCanbus.CAR_WC2_GM_Escalade_07_Auto /* 5963812 */:
                        ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                        ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                        ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                        ConstAllAirDara.U_AIR_BACK_POWER = 42;
                        ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                        ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                        ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                        ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                        ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                        ConstAllAirDara.U_AIR_REAR_SYNC = 80;
                        ConstAllAirDara.C_REAR_SYNC = 25;
                        ConstAllAirDara.C_REAR_LOCK = 24;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 22;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 246;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 22;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 246;
                        ConstAllAirDara.C_REAR_AUTO = 17;
                        ConstAllAirDara.C_REAR_OFF = 23;
                        ConstAllAirDara.C_REAR_MODE_FOOT = 18;
                        ConstAllAirDara.C_REAR_MODE_BODY = 20;
                        ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 19;
                        ConstAllAirDara.C_REAR_WIND_DOWN = 21;
                        ConstAllAirDara.C_REAR_WIND_UP = 245;
                        break;
                }
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_WC2_GM_GL8 /* 393252 */:
                        ConstAllAirDara.U_AIR_CYCLE_AUTO = 36;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_SYNC = 15;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 27;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 28;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 29;
                ConstAllAirDara.C_AIR_MODE_UP = 8;
                ConstAllAirDara.C_AIR_MODE_BODY = 9;
                ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 33;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 34;
                ConstAllAirDara.C_CONTRAL = 14;
                break;
            case 38:
            case 101:
            case FinalCanbus.CAR_WC1_Nawala_Philippine /* 131110 */:
            case FinalCanbus.CAR_WC1_QiJun_H /* 131173 */:
            case FinalCanbus.CAR_WC1_17QiJun /* 393317 */:
            case FinalCanbus.CAR_WC1_17QiJun_H /* 458853 */:
            case FinalCanbus.CAR_WC1_Tuda /* 524389 */:
            case FinalCanbus.CAR_WC1_19QiJun /* 589925 */:
            case FinalCanbus.CAR_WC1_Tuda_Hand /* 655461 */:
            case FinalCanbus.CAR_WC1_Nawala /* 720997 */:
            case FinalCanbus.CAR_WC1_Nawala_Hand /* 786533 */:
            case FinalCanbus.CAR_WC1_Tuda_H /* 852069 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                switch (DataCanbus.DATA[1000]) {
                    case 38:
                    case FinalCanbus.CAR_WC1_QiJun_H /* 131173 */:
                    case FinalCanbus.CAR_WC1_17QiJun /* 393317 */:
                    case FinalCanbus.CAR_WC1_17QiJun_H /* 458853 */:
                    case FinalCanbus.CAR_WC1_Tuda /* 524389 */:
                    case FinalCanbus.CAR_WC1_19QiJun /* 589925 */:
                    case FinalCanbus.CAR_WC1_Nawala /* 720997 */:
                    case FinalCanbus.CAR_WC1_Tuda_H /* 852069 */:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_DUAL = 62;
                        ConstAllAirDara.C_AIR_AUTO = 4;
                        ConstAllAirDara.C_AIR_DUAL = 41;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 21;
                        break;
                    case 101:
                        ConstAllAirDara.C_AIR_MODE_BODY = 9;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 23;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 24;
                        break;
                    case FinalCanbus.CAR_WC1_Nawala_Philippine /* 131110 */:
                        ConstAllAirDara.C_AIR_MODE_BODY = 9;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 23;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 24;
                        break;
                    case FinalCanbus.CAR_WC1_Tuda_Hand /* 655461 */:
                    case FinalCanbus.CAR_WC1_Nawala_Hand /* 786533 */:
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 21;
                        break;
                }
                ConstAllAirDara.C_CONTRAL = 0;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                break;
            case 40:
            case FinalCanbus.CAR_XP1_17MaiTeng /* 262184 */:
            case FinalCanbus.CAR_XP_MQB_Lamando /* 458792 */:
            case FinalCanbus.CAR_XP_MQB_Polo /* 524328 */:
            case FinalCanbus.CAR_XP_MQB_Passat_B8 /* 589864 */:
            case FinalCanbus.CAR_XP_MQB_Sportsvan /* 655400 */:
            case FinalCanbus.CAR_XP_MQB_TouranL /* 720936 */:
            case FinalCanbus.CAR_XP_MQB_Tiguan /* 786472 */:
            case FinalCanbus.CAR_XP_MQB_Terament /* 852008 */:
            case FinalCanbus.CAR_XP_MQB_Skoda_Octavia /* 917544 */:
            case FinalCanbus.CAR_XP_MQB_Skoda_Fabia /* 983080 */:
            case FinalCanbus.CAR_XP_MQB_Skoda_Superb /* 1048616 */:
            case FinalCanbus.CAR_XP_MQB_Skoda_Kodiaq /* 1114152 */:
            case FinalCanbus.CAR_XP_MQB_Seat_LeonFR /* 1179688 */:
            case FinalCanbus.CAR_XP_MQB_Seat_Ateca /* 1245224 */:
            case FinalCanbus.CAR_XP_TuGuan_L_20_H /* 1376296 */:
                ConstAllAirDara.TEMPERATURE_LOW = 0;
                ConstAllAirDara.TEMPERATURE_HIGHT = 31;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SYNC = 14;
                ConstAllAirDara.U_AIR_CLEAN = 76;
                ConstAllAirDara.U_AIR_STEER = 66;
                ConstAllAirDara.U_AIR_REAR_CTRL = 67;
                ConstAllAirDara.U_AIR_FRONT_HOT = 17;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 5;
                ConstAllAirDara.C_AIR_MODE_BODY = 6;
                ConstAllAirDara.C_AIR_MODE_FOOT = 7;
                ConstAllAirDara.C_AIR_MODE_UP = 8;
                ConstAllAirDara.C_AIR_CYCLE = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 11;
                ConstAllAirDara.C_AIR_SYNC = 12;
                ConstAllAirDara.C_AIR_AQS = 13;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 14;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 15;
                ConstAllAirDara.C_AIR_STEER = 16;
                ConstAllAirDara.C_AIR_FRONT_HOT = 17;
                ConstAllAirDara.C_REAR_CTRL = 18;
                ConstAllAirDara.C_CLEAN = 19;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 20;
                ConstAllAirDara.C_AIR_AC = 21;
                ConstAllAirDara.C_AIR_AUTO = 22;
                ConstAllAirDara.C_AIR_AC_MAX = 23;
                ConstAllAirDara.C_CONTRAL = 107;
                break;
            case 160:
            case FinalCanbus.CAR2_RZC_XP1_DaZhong_GaoErFu7_H /* 131232 */:
            case FinalCanbus.CAR_RZC_XP1_MaiTeng /* 196768 */:
            case FinalCanbus.CAR_RZC_TuGuan_L /* 262304 */:
            case FinalCanbus.CAR_RZC_TuAng /* 327840 */:
            case FinalCanbus.CAR2_RZC_DaZhong_Tange /* 589984 */:
            case FinalCanbus.CAR2_RZC_DaZhong_MQB_E /* 655520 */:
            case FinalCanbus.CAR_RZC_TuGuan_L_20 /* 721056 */:
            case FinalCanbus.CAR_RZC_MQB_18_19Lavida_plus /* 786592 */:
            case FinalCanbus.CAR_RZC_MQB_11_18Sagitar /* 852128 */:
            case FinalCanbus.CAR_RZC_MQB_19Sagitar /* 917664 */:
            case FinalCanbus.CAR_RZC_MQB_11_17Passat /* 983200 */:
            case FinalCanbus.CAR_RZC_MQB_19Passat /* 1048736 */:
            case FinalCanbus.CAR_RZC_MQB_19Tharu /* 1179808 */:
            case FinalCanbus.CAR_RZC_MQB_14_19Golf7 /* 1310880 */:
            case FinalCanbus.CAR_RZC_MQB_19Bora /* 1376416 */:
            case FinalCanbus.CAR_RZC_MQB_14_19Lamando /* 1441952 */:
            case FinalCanbus.CAR_RZC_MQB_19Polo /* 1507488 */:
            case FinalCanbus.CAR_RZC_MQB_19CC /* 1573024 */:
            case FinalCanbus.CAR_RZC_MQB_19T_Cross /* 1638560 */:
            case FinalCanbus.CAR_RZC_MQB_16_18TouranL /* 1704096 */:
            case FinalCanbus.CAR_RZC_MQB_17_18C_Trek /* 1769632 */:
            case FinalCanbus.CAR_RZC_MQB_16_19Golf_jialv /* 1835168 */:
            case FinalCanbus.CAR_RZC_MQB_19T_ROC /* 1900704 */:
            case FinalCanbus.CAR_RZC_MQB_19Tayron /* 1966240 */:
            case FinalCanbus.CAR_RZC_MQB_13_14Octavia /* 2031776 */:
            case FinalCanbus.CAR_RZC_MQB_15_19Octavia /* 2097312 */:
            case FinalCanbus.CAR_RZC_MQB_13_15Superb /* 2162848 */:
            case FinalCanbus.CAR_RZC_MQB_16_18Superb /* 2228384 */:
            case FinalCanbus.CAR_RZC_MQB_18Kamiq /* 2293920 */:
            case FinalCanbus.CAR_RZC_MQB_18_19Karoq /* 2359456 */:
            case FinalCanbus.CAR_RZC_MQB_17_19Kodiaq /* 2424992 */:
            case FinalCanbus.CAR_RZC_MQB_14_18Caravan /* 2490528 */:
            case FinalCanbus.CAR_RZC_MQB_19Jetta_VS5 /* 2556064 */:
            case FinalCanbus.CAR_RZC_MQB_11_17Touareg /* 2621600 */:
            case FinalCanbus.CAR_RZC_MQB_09_19Multivan /* 2687136 */:
            case FinalCanbus.CAR_RZC_MQB_Jetta_Brazil /* 2752672 */:
            case FinalCanbus.CAR_RZC_MQB_SUPERB_Turkey /* 2818208 */:
            case FinalCanbus.CAR_RZC_MQB_Huiang_21 /* 3080352 */:
            case FinalCanbus.CAR_RZC_MQB_20Tayron_GTE /* 3145888 */:
            case FinalCanbus.CAR_RZC_MQB_20Jetta_VS7 /* 3211424 */:
            case FinalCanbus.CAR_RZC_MQB_20Viloran /* 3276960 */:
            case FinalCanbus.CAR_RZC_MQB_21Golf8 /* 3342496 */:
            case FinalCanbus.CAR_RZC_MQB_16_18Weilan /* 3408032 */:
            case FinalCanbus.CAR_RZC_TuGuan_L_20_H /* 3473568 */:
            case FinalCanbus.CAR_6606_MQB_Lavida_23 /* 3539104 */:
            case FinalCanbus.CAR_RZC_MQB_17Passat_B8 /* 3604640 */:
            case FinalCanbus.CAR_RZC_MQB_All_360 /* 3670176 */:
            case FinalCanbus.CAR_RZC_MQB_Caddy_22 /* 3735712 */:
            case FinalCanbus.CAR_RZC_MaiTeng_20_H_EC /* 3801248 */:
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.U_AIR_WINLEV = 69;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_AQS = 54;
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
                ConstAllAirDara.U_AIR_CLEAN = 76;
                ConstAllAirDara.U_AIR_STEER = 66;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SYNC = 14;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                ConstAllAirDara.C_REAR_OFF = 36;
                ConstAllAirDara.C_REAR_AUTO = 37;
                ConstAllAirDara.C_REAR_MODE_FOOT = 39;
                ConstAllAirDara.C_REAR_MODE_BODY = 38;
                ConstAllAirDara.C_REAR_WIND_DOWN = 40;
                ConstAllAirDara.C_REAR_WIND_UP = 8;
                ConstAllAirDara.C_AIR_STEER = 172;
                ConstAllAirDara.C_AIR_WINLEV = 177;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 173;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 174;
                ConstAllAirDara.C_CLEAN = 175;
                ConstAllAirDara.C_AIR_AQS = 176;
                ConstAllAirDara.C_AIR_POWER = 178;
                ConstAllAirDara.C_AIR_SYNC = 179;
                ConstAllAirDara.C_AIR_MODE_BODY = 180;
                ConstAllAirDara.C_AIR_MODE_FOOT = 181;
                ConstAllAirDara.C_AIR_MODE_UP = 182;
                ConstAllAirDara.C_AIR_WIND_ADD = 183;
                ConstAllAirDara.C_AIR_WIND_SUB = 247;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 184;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 248;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 185;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 249;
                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 186;
                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 250;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 186;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 250;
                ConstAllAirDara.C_AIR_AC_MAX = 2;
                ConstAllAirDara.C_AIR_AUTO = 1;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 3;
                ConstAllAirDara.C_REAR_LOCK = 188;
                ConstAllAirDara.C_AIR_AC = 189;
                ConstAllAirDara.C_AIR_CYCLE = 190;
                ConstAllAirDara.C_AIR_LEFT_COLD = 191;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 192;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 205;
                ConstAllAirDara.C_CONTRAL = 160;
                break;
            case 263:
            case 309:
            case FinalCanbus.CAR_RZC_FLB_SaiOu3 /* 65799 */:
            case FinalCanbus.CAR_RZC_17Gl8 /* 262407 */:
            case FinalCanbus.CAR_RZC_ALL_GM_11_15GL8 /* 327943 */:
            case FinalCanbus.CAR_RZC_17_18GL8_ES_28T /* 393479 */:
            case FinalCanbus.CAR_RZC_18_19Excelle_GT /* 459015 */:
            case FinalCanbus.CAR_RZC_20GL8_652T /* 524551 */:
            case FinalCanbus.CAR_RZC_20GL8_652T_H /* 590087 */:
            case FinalCanbus.CAR_RZC_15GL8_24_H /* 655623 */:
            case FinalCanbus.CAR_RZC_21YingLang_CD /* 721159 */:
            case FinalCanbus.CAR_RZC_21YingLang /* 786695 */:
                ConstAllAirDara.TEMPERATURE_LOW = 0;
                ConstAllAirDara.TEMPERATURE_HIGHT = 30;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                switch (DataCanbus.DATA[1000]) {
                    case 263:
                    case FinalCanbus.CAR_RZC_FLB_SaiOu3 /* 65799 */:
                    case FinalCanbus.CAR_RZC_17Gl8 /* 262407 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_11_15GL8 /* 327943 */:
                    case FinalCanbus.CAR_RZC_17_18GL8_ES_28T /* 393479 */:
                    case FinalCanbus.CAR_RZC_18_19Excelle_GT /* 459015 */:
                    case FinalCanbus.CAR_RZC_20GL8_652T /* 524551 */:
                    case FinalCanbus.CAR_RZC_20GL8_652T_H /* 590087 */:
                    case FinalCanbus.CAR_RZC_15GL8_24_H /* 655623 */:
                    case FinalCanbus.CAR_RZC_21YingLang_CD /* 721159 */:
                    case FinalCanbus.CAR_RZC_21YingLang /* 786695 */:
                        ConstAllAirDara.C_AIR_MODE_BODY = 8;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 9;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 10;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 11;
                        break;
                    case 309:
                        ConstAllAirDara.C_AIR_MODE_UP = 28;
                        ConstAllAirDara.C_AIR_MODE_BODY = 8;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 11;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 26;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 12;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 27;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 22;
                ConstAllAirDara.C_AIR_LEFT_COLD = 23;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 24;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 25;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 5;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_DUAL = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 20;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 21;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case 274:
            case FinalCanbus.CAR_DJ_XP1_ACCORD7_H /* 65810 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_AIR_AC = 8;
                ConstAllAirDara.C_AIR_POWER = 9;
                ConstAllAirDara.C_AIR_AUTO = 1;
                ConstAllAirDara.C_AIR_DUAL = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 35;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 11;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case 276:
                ConstAllAirDara.TEMPERATURE_LOW = 1;
                ConstAllAirDara.TEMPERATURE_HIGHT = 15;
                ConstAllAirDara.TEMPERATURE_NONE = -1;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 62;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_CONTRAL = 0;
                ConstAllAirDara.C_AIR_AUTO = 1;
                ConstAllAirDara.C_AIR_DUAL = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_POWER = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                ConstAllAirDara.C_AIR_AC = 8;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 35;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 11;
                break;
            case 282:
            case FinalCanbus.CAR_WC2_17MingJueRuiTeng /* 131354 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.C_AIR_POWER = 16;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 15;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 27;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 28;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 28;
                ConstAllAirDara.C_CONTRAL = 26;
                break;
            case 289:
            case FinalCanbus.CAR_WC2_ChuanQiGS4_M /* 65825 */:
            case FinalCanbus.CAR_WC2_ChuanQiGS4_H /* 131361 */:
            case FinalCanbus.CAR_WC2_17ChuanQiGS4 /* 196897 */:
            case FinalCanbus.CAR_WC2_17ChuanQiGS3 /* 262433 */:
            case FinalCanbus.CAR_WC2_ChuanQiG_GS4_20 /* 590113 */:
            case FinalCanbus.CAR_WC2_ChuanQiG_AION_19 /* 655649 */:
            case FinalCanbus.CAR_WC2_ChuanQiG_GS8_17 /* 721185 */:
            case FinalCanbus.CAR_WC2_ChuanQiG_AION_22 /* 786721 */:
            case FinalCanbus.CAR_WC2_ChuanQiG_AION_YPLUS_23 /* 852257 */:
            case FinalCanbus.CAR_WC2_ChuanQiG_AION_SPLUS_25 /* 917793 */:
            case FinalCanbus.CAR_WC2_ChuanQiG_GS4_PLUS /* 983329 */:
            case FinalCanbus.CAR_WC2_ChuanQiG_GM8_21 /* 1048865 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_ION = 58;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_AUTO_LEFT = 49;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_WC2_ChuanQiG_GS8_17 /* 721185 */:
                        ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                        ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                        ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                        ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                        ConstAllAirDara.U_AIR_BACK_POWER = 42;
                        ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                        ConstAllAirDara.U_AIR_BACK_BLOW_UP = 46;
                        ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                        ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 33;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 32;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 33;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 32;
                        ConstAllAirDara.C_REAR_WIND_DOWN = 43;
                        ConstAllAirDara.C_REAR_WIND_UP = 42;
                        ConstAllAirDara.C_REAR_OFF = 19;
                        ConstAllAirDara.C_REAR_AUTO = 40;
                        ConstAllAirDara.C_REAR_MODE_FOOT = 81;
                        ConstAllAirDara.C_REAR_MODE_BODY = 82;
                        ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 83;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_MODE_UP = 8;
                ConstAllAirDara.C_AIR_MODE_BODY = 9;
                ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_WC2_ChuanQiG_GS4_20 /* 590113 */:
                    case FinalCanbus.CAR_WC2_ChuanQiG_AION_19 /* 655649 */:
                    case FinalCanbus.CAR_WC2_ChuanQiG_GS8_17 /* 721185 */:
                    case FinalCanbus.CAR_WC2_ChuanQiG_AION_22 /* 786721 */:
                    case FinalCanbus.CAR_WC2_ChuanQiG_AION_YPLUS_23 /* 852257 */:
                    case FinalCanbus.CAR_WC2_ChuanQiG_GM8_21 /* 1048865 */:
                        ConstAllAirDara.U_AIR_DUAL = 14;
                        ConstAllAirDara.C_AIR_DUAL = 41;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                        break;
                    default:
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 13;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 14;
                        break;
                }
                ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                ConstAllAirDara.C_AIR_ION = 25;
                ConstAllAirDara.C_CONTRAL = 4;
                break;
            case 372:
            case FinalCanbus.CAR_WC1_Jeep_ZiYouGuang_M /* 65908 */:
            case FinalCanbus.CAR_WC1_Jeep_ZiYouGuang_H /* 131444 */:
            case FinalCanbus.CAR_WC1_Jeep_17ZhiNanZhe /* 262516 */:
            case FinalCanbus.CAR_WC1_Jeep_17ZhiNanZhe_H /* 328052 */:
            case FinalCanbus.CAR_WC1_Jeep_18ZiYouXia /* 393588 */:
            case FinalCanbus.CAR_WC1_Jeep_18ZiYouXia_H /* 459124 */:
            case FinalCanbus.CAR_WC1_Jeep_19ZiYouXia_W /* 524660 */:
            case FinalCanbus.CAR_WC1_Fiat_19_500X /* 590196 */:
            case FinalCanbus.CAR_WC1_Jeep_13_Dodge_JCUV /* 655732 */:
            case FinalCanbus.CAR_WC1_Jeep_13_Dodge_JCUV_CD /* 721268 */:
            case FinalCanbus.CAR_WC1_Jeep_18_Zhihuiguan /* 852340 */:
            case FinalCanbus.CAR_WC1_Jeep_15_RAM /* 917876 */:
            case FinalCanbus.CAR_WC1_Jeep_18_Zhihuiguan_H /* 983412 */:
            case FinalCanbus.CAR_WC1_Jeep_15_RAM_H /* 1048948 */:
            case FinalCanbus.CAR_WC1_TMK_BENZ_MPV_ALL /* 1114484 */:
            case FinalCanbus.CAR_WC1_Jeep_20_GrdCherokee_H /* 1180020 */:
            case FinalCanbus.CAR_WC1_Jeep_19_MuMaRen_H /* 1245556 */:
            case FinalCanbus.CAR_WC1_Jeep_18ZhiNanZhe_EU /* 1311092 */:
            case FinalCanbus.CAR_WC1_Jeep_Chrysler_300C_11 /* 1376628 */:
            case FinalCanbus.CAR_WC1_Jeep_Chrysler_300C_11CD /* 1442164 */:
            case FinalCanbus.CAR_WC1_Jeep_19_MuMaRen_L /* 1507700 */:
            case FinalCanbus.CAR_WC1_Jeep_20_GrdCherokee_L /* 1573236 */:
            case FinalCanbus.CAR_WC1_Jeep_18_Zhihuiguan_M /* 1638772 */:
            case FinalCanbus.CAR_WC1_Jeep_15_RAM_M /* 1704308 */:
            case FinalCanbus.CAR_WC1_Jeep_20_GrdCherokee_M /* 1769844 */:
            case FinalCanbus.CAR_WC1_Jeep_19_MuMaRen_M /* 1835380 */:
            case FinalCanbus.CAR_WC1_Jeep_19_RAM /* 1900916 */:
            case FinalCanbus.CAR_WC1_Jeep_19_RAM_M /* 1966452 */:
            case FinalCanbus.CAR_WC1_Jeep_19_RAM_H /* 2031988 */:
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_WC1_Jeep_13_Dodge_JCUV /* 655732 */:
                    case FinalCanbus.CAR_WC1_Jeep_13_Dodge_JCUV_CD /* 721268 */:
                    case FinalCanbus.CAR_WC1_Jeep_18_Zhihuiguan /* 852340 */:
                    case FinalCanbus.CAR_WC1_Jeep_18_Zhihuiguan_H /* 983412 */:
                    case FinalCanbus.CAR_WC1_Jeep_18_Zhihuiguan_M /* 1638772 */:
                        ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                        ConstAllAirDara.U_AIR_BACK_POWER = 42;
                        ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                        ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                        ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                        ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                        ConstAllAirDara.U_AIR_BACK_BLOW_UP = 46;
                        ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                        ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                        ConstAllAirDara.C_REAR_AUTO = 66;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 33;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 32;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 33;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 32;
                        ConstAllAirDara.C_REAR_WIND_DOWN = 43;
                        ConstAllAirDara.C_REAR_WIND_UP = 42;
                        ConstAllAirDara.C_REAR_OFF = 46;
                        ConstAllAirDara.C_REAR_MODE_FOOT = 81;
                        ConstAllAirDara.C_REAR_MODE_BODY = 82;
                        ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 83;
                        break;
                }
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_REAR_CTRL = 67;
                ConstAllAirDara.U_AIR_STEER = 66;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.U_AIR_PARK = 38;
                ConstAllAirDara.C_AIR_PARK = 22;
                ConstAllAirDara.C_REAR_CTRL = 34;
                ConstAllAirDara.C_AIR_STEER = 45;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                ConstAllAirDara.C_AIR_LEFT_COLD = 19;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 20;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_WC1_Jeep_17ZhiNanZhe /* 262516 */:
                    case FinalCanbus.CAR_WC1_Jeep_17ZhiNanZhe_H /* 328052 */:
                        ConstAllAirDara.C_AIR_AC_MAX = 30;
                        ConstAllAirDara.C_AIR_MODE_BODY = 26;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 29;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 27;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 28;
                        break;
                    default:
                        ConstAllAirDara.C_AIR_MODE_UP = 8;
                        ConstAllAirDara.C_AIR_AC_MAX = 21;
                        ConstAllAirDara.C_AIR_MODE_UP = 8;
                        ConstAllAirDara.C_AIR_MODE_BODY = 9;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 24;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 23;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_SYNC = 3;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case 373:
            case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_H /* 65909 */:
            case FinalCanbus.CAR_RZC_XP1_ZiYouXia /* 131445 */:
            case FinalCanbus.CAR_RZC_XP1_GrdCherokee /* 196981 */:
            case FinalCanbus.CAR_RZC_17ZhiNanZhe /* 262517 */:
            case FinalCanbus.CAR_RZC_17ZhiNanZhe_H /* 328053 */:
            case FinalCanbus.CAR_RZC_18MuMaRen /* 393589 */:
            case FinalCanbus.CAR_RZC_XP1_GrdCherokee_H /* 459125 */:
            case FinalCanbus.CAR_RZC_18MuMaRen_H /* 524661 */:
            case FinalCanbus.CAR_RZC_19Tiaozhanzhe /* 590197 */:
            case FinalCanbus.CAR_RZC_19Tiaozhanzhe_H /* 721269 */:
            case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19 /* 852341 */:
            case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19_H /* 917877 */:
            case FinalCanbus.CAR_RZC_Chrysler_300C_16 /* 1245557 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM /* 1311093 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_H /* 1376629 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_M /* 1835381 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_HY /* 1900917 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_HY_M /* 1966453 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_HY_H /* 2031989 */:
            case FinalCanbus.CAR_RZC_XP1_ZiYouXia_H /* 2163061 */:
            case FinalCanbus.CAR_RZC_Jeep_22Gladiator /* 2949493 */:
            case FinalCanbus.CAR_RZC_Jeep_22Gladiator_H /* 3015029 */:
            case FinalCanbus.CAR_RZC_Jeep_18GrdCherokee /* 3080565 */:
            case FinalCanbus.CAR_RZC_Jeep_18GrdCherokee_H /* 3146101 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_STEER = 66;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 31;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 30;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 33;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 32;
                ConstAllAirDara.C_AIR_AUTO = 20;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 48;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 50;
                ConstAllAirDara.C_AIR_LEFT_COLD = 49;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 51;
                ConstAllAirDara.C_AIR_POWER = 9;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 21;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 22;
                ConstAllAirDara.C_AIR_WIND_ADD = 29;
                ConstAllAirDara.C_AIR_WIND_SUB = 28;
                ConstAllAirDara.C_AIR_AC = 17;
                ConstAllAirDara.C_AIR_CYCLE = 19;
                ConstAllAirDara.C_AIR_SYNC = 23;
                ConstAllAirDara.C_AIR_MODE_BODY = 24;
                ConstAllAirDara.C_AIR_MODE_FOOT = 26;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 25;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 27;
                ConstAllAirDara.C_AIR_AC_MAX = 18;
                ConstAllAirDara.C_AIR_STEER = 52;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case 397:
            case FinalCanbus.CAR_BNR_12Camry /* 524685 */:
            case FinalCanbus.CAR_BNR_ShuPing_15_Camery /* 590221 */:
            case FinalCanbus.CAR_BNR_ShuPing_12LandCruise /* 655757 */:
            case FinalCanbus.CAR_BNR_ShuPing_16LandCruise /* 721293 */:
            case FinalCanbus.CAR_BNR_ShuPing_09Camery /* 786829 */:
            case FinalCanbus.CAR_BNR_ShuPing_07Corolla /* 1180045 */:
            case FinalCanbus.CAR_BNR_12Camry_AMP /* 1376653 */:
            case FinalCanbus.CAR_BNR_ShuPing_15_Camery_AMP /* 1442189 */:
            case FinalCanbus.CAR_BNR_ShuPing_12LandCruise_AMP /* 1507725 */:
            case FinalCanbus.CAR_BNR_ShuPing_16LandCruise_AMP /* 1573261 */:
            case FinalCanbus.CAR_BNR_05Reiz /* 1966477 */:
            case FinalCanbus.CAR_BNR_12Crown_L /* 2163085 */:
            case FinalCanbus.CAR_BNR_12Crown_M /* 2228621 */:
            case FinalCanbus.CAR_BNR_12Crown_H /* 2294157 */:
            case FinalCanbus.CAR_BNR_07_15LandCruise_AMP /* 2621837 */:
            case FinalCanbus.CAR_BNR_07_15LandCruise /* 2687373 */:
            case FinalCanbus.CAR_RZC_12Camry /* 2752909 */:
            case FinalCanbus.CAR_RZC_ShuPing_15_Camery /* 2818445 */:
            case FinalCanbus.CAR_RZC_ShuPing_12LandCruise /* 2883981 */:
            case FinalCanbus.CAR_RZC_ShuPing_16LandCruise /* 2949517 */:
            case FinalCanbus.CAR_RZC_ShuPing_09Camery /* 3015053 */:
            case FinalCanbus.CAR_RZC_ShuPing_09HighLand_L /* 3277197 */:
            case FinalCanbus.CAR_RZC_ShuPing_09HighLand_H /* 3342733 */:
            case FinalCanbus.CAR_RZC_ShuPing_07Corolla /* 3408269 */:
            case FinalCanbus.CAR_RZC_ShuPing_14Corolla /* 3473805 */:
            case FinalCanbus.CAR_RZC_12Camry_AMP /* 3604877 */:
            case FinalCanbus.CAR_RZC_ShuPing_15_Camery_AMP /* 3670413 */:
            case FinalCanbus.CAR_RZC_ShuPing_12LandCruise_AMP /* 3735949 */:
            case FinalCanbus.CAR_RZC_ShuPing_16LandCruise_AMP /* 3801485 */:
            case FinalCanbus.CAR_RZC_05Reiz /* 4194701 */:
            case FinalCanbus.CAR_RZC_12Crown_L /* 4391309 */:
            case FinalCanbus.CAR_RZC_12Crown_M /* 4456845 */:
            case FinalCanbus.CAR_RZC_12Crown_H /* 4522381 */:
            case FinalCanbus.CAR_RZC_07_15LandCruise_AMP /* 4850061 */:
            case FinalCanbus.CAR_RZC_07_15LandCruise /* 4915597 */:
            case FinalCanbus.CAR_RZC_18Camery /* 4981133 */:
            case FinalCanbus.CAR_RZC_16_18RAV4 /* 5046669 */:
            case FinalCanbus.CAR_RZC_13Reiz_TOP /* 5702029 */:
            case FinalCanbus.CAR_RZC_12Reiz /* 5767565 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_MODE_ADD = 8;
                ConstAllAirDara.C_AIR_MODE_SUB = 7;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.U_AIR_POWER = 10;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_BNR_ShuPing_15_Camery /* 590221 */:
                    case FinalCanbus.CAR_BNR_ShuPing_15_Camery_AMP /* 1442189 */:
                    case FinalCanbus.CAR_RZC_ShuPing_15_Camery /* 2818445 */:
                    case FinalCanbus.CAR_RZC_ShuPing_15_Camery_AMP /* 3670413 */:
                        ConstAllAirDara.C_AIR_POWER = 1;
                        ConstAllAirDara.U_AIR_POWER = 10;
                        ConstAllAirDara.C_AIR_NANOE = 33;
                        ConstAllAirDara.U_AIR_NANOE = 34;
                        break;
                    case FinalCanbus.CAR_BNR_ShuPing_12LandCruise /* 655757 */:
                    case FinalCanbus.CAR_BNR_ShuPing_12LandCruise_AMP /* 1507725 */:
                    case FinalCanbus.CAR_BNR_07_15LandCruise_AMP /* 2621837 */:
                    case FinalCanbus.CAR_BNR_07_15LandCruise /* 2687373 */:
                    case FinalCanbus.CAR_RZC_ShuPing_12LandCruise /* 2883981 */:
                    case FinalCanbus.CAR_RZC_ShuPing_12LandCruise_AMP /* 3735949 */:
                    case FinalCanbus.CAR_RZC_07_15LandCruise_AMP /* 4850061 */:
                    case FinalCanbus.CAR_RZC_07_15LandCruise /* 4915597 */:
                        ConstAllAirDara.C_AIR_POWER = 1;
                        ConstAllAirDara.U_AIR_POWER = 10;
                        ConstAllAirDara.C_REAR_CTRL = 42;
                        ConstAllAirDara.U_AIR_REAR_CTRL = 67;
                        ConstAllAirDara.C_CLEAN_AIR = 32;
                        ConstAllAirDara.U_AIR_CLEANAIR = 33;
                        break;
                    case FinalCanbus.CAR_BNR_ShuPing_16LandCruise /* 721293 */:
                    case FinalCanbus.CAR_BNR_ShuPing_16LandCruise_AMP /* 1573261 */:
                    case FinalCanbus.CAR_RZC_ShuPing_16LandCruise /* 2949517 */:
                    case FinalCanbus.CAR_RZC_ShuPing_16LandCruise_AMP /* 3801485 */:
                    case FinalCanbus.CAR_RZC_13Reiz_TOP /* 5702029 */:
                    case FinalCanbus.CAR_RZC_12Reiz /* 5767565 */:
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 8;
                        ConstAllAirDara.C_AIR_POWER = 1;
                        ConstAllAirDara.U_AIR_POWER = 10;
                        ConstAllAirDara.C_REAR_CTRL = 42;
                        ConstAllAirDara.U_AIR_REAR_CTRL = 67;
                        ConstAllAirDara.C_AIR_MODE_ADD = 255;
                        ConstAllAirDara.C_AIR_MODE_SUB = 255;
                        break;
                    case FinalCanbus.CAR_BNR_ShuPing_07Corolla /* 1180045 */:
                    case FinalCanbus.CAR_RZC_ShuPing_07Corolla /* 3408269 */:
                    case FinalCanbus.CAR_RZC_16_18RAV4 /* 5046669 */:
                        ConstAllAirDara.C_AIR_POWER = 1;
                        ConstAllAirDara.U_AIR_POWER = 10;
                        break;
                    case FinalCanbus.CAR_BNR_12Crown_L /* 2163085 */:
                    case FinalCanbus.CAR_BNR_12Crown_M /* 2228621 */:
                    case FinalCanbus.CAR_BNR_12Crown_H /* 2294157 */:
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                        ConstAllAirDara.C_AIR_MODE_ADD = 255;
                        ConstAllAirDara.C_AIR_MODE_SUB = 255;
                        break;
                    case FinalCanbus.CAR_453_LZ_Toyota_Tacoma_11 /* 8126917 */:
                    case FinalCanbus.CAR_453_LZ_Toyota_Tacoma_05 /* 8192453 */:
                        ConstAllAirDara.C_AIR_FRONT_DEFROST = 18;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                        ConstAllAirDara.C_AIR_MODE_ADD = 255;
                        ConstAllAirDara.C_AIR_MODE_SUB = 255;
                        ConstAllAirDara.C_AIR_POWER = 1;
                        ConstAllAirDara.U_AIR_POWER = 10;
                        ConstAllAirDara.U_AIR_REAR = 255;
                        ConstAllAirDara.U_AIR_AUTO = 255;
                        ConstAllAirDara.U_AIR_DUAL = 255;
                        ConstAllAirDara.C_AIR_DUAL = 255;
                        ConstAllAirDara.C_AIR_AUTO = 255;
                        ConstAllAirDara.C_AIR_REAR_DEFROST = 255;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 255;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 255;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 255;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 255;
                        break;
                }
                ConstAllAirDara.C_CONTRAL = 22;
                break;
            case 412:
            case FinalCanbus.CAR_XP1_YearGmcSeries_NoAir /* 459164 */:
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_MODE_ADD = 8;
                ConstAllAirDara.C_AIR_MODE_SUB = 7;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case 429:
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_12Crown_AMP /* 65965 */:
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_12Crown_AMP_H /* 131501 */:
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_13Crown_AMP /* 197037 */:
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_14Prodo_H_ShuPing /* 459181 */:
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_14Prodo_ShuPing /* 524717 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown /* 590253 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown /* 655789 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown_L /* 721325 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown_L /* 786861 */:
            case FinalCanbus.CAR_DJ_XC_Nissan_Tianlai_03_07 /* 852397 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_10_13PRADO /* 917933 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_08_15LAND_CRUISER /* 983469 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_LEXUS /* 1049005 */:
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_HIGHLANDER /* 1114541 */:
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_HIGHLANDER_H /* 1180077 */:
            case FinalCanbus.CAR_DJ_XC_Infiniti_FX35_03_09 /* 1245613 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FLOWER_BLOW = 76;
                ConstAllAirDara.U_AIR_ION = 33;
                ConstAllAirDara.U_AIR_FRONT_HOT = 17;
                ConstAllAirDara.U_AIR_SWING = 35;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_DJ_XC_TOYOTA_LEXUS /* 1049005 */:
                        ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                        ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                        ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                        ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                        ConstAllAirDara.U_AIR_BACK_POWER = 42;
                        ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                        ConstAllAirDara.U_AIR_REAR_MANUAL = 78;
                        ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                        ConstAllAirDara.U_AIR_BACK_BLOW_UP = 48;
                        ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                        ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                        ConstAllAirDara.C_REAR_LOCK = 64;
                        ConstAllAirDara.C_REAR_AUTO = 65;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 68;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 67;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 68;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 67;
                        ConstAllAirDara.C_REAR_WIND_DOWN = 70;
                        ConstAllAirDara.C_REAR_WIND_UP = 69;
                        ConstAllAirDara.C_REAR_OFF = 66;
                        ConstAllAirDara.C_REAR_MODE_FOOT = 74;
                        ConstAllAirDara.C_REAR_MODE_BODY = 72;
                        ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 73;
                        ConstAllAirDara.C_AIR_REAR_MANUAL = 80;
                        break;
                    case FinalCanbus.CAR_DJ_XP1_TOYOTA_HIGHLANDER /* 1114541 */:
                    case FinalCanbus.CAR_DJ_XP1_TOYOTA_HIGHLANDER_H /* 1180077 */:
                        ConstAllAirDara.U_AIR_FLOWER_BLOW = 255;
                        ConstAllAirDara.U_AIR_ION = 255;
                        ConstAllAirDara.U_AIR_FRONT_HOT = 255;
                        ConstAllAirDara.U_AIR_SWING = 255;
                        ConstAllAirDara.C_AIR_FLOWER_BLOW = 255;
                        ConstAllAirDara.C_AIR_FRONT_HOT = 255;
                        ConstAllAirDara.C_AIR_SWING = 255;
                        ConstAllAirDara.C_AIR_ION = 255;
                        break;
                    default:
                        ConstAllAirDara.C_AIR_FLOWER_BLOW = 38;
                        ConstAllAirDara.C_AIR_FRONT_HOT = 41;
                        ConstAllAirDara.C_AIR_SWING = 40;
                        ConstAllAirDara.C_AIR_ION = 39;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 10;
                ConstAllAirDara.C_AIR_AC = 8;
                ConstAllAirDara.C_AIR_AUTO = 1;
                ConstAllAirDara.C_AIR_DUAL = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 4;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 9;
                ConstAllAirDara.C_CONTRAL = 3;
                break;
            case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
            case FinalCanbus.CAR_DAOJUN_OD_ATS /* 852316 */:
            case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
            case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
            case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
            case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AUTO = 54;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_AIR_MODE_ADD = 16;
                ConstAllAirDara.C_AIR_MODE_SUB = 17;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
                    case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
                    case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
                    case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
                    case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 30;
                        ConstAllAirDara.U_AIR_WAISTHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_WAISTHEAT_RIGHT = 30;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 36;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 37;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 38;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 39;
                        ConstAllAirDara.C_AIR_WAISTLEFT_HEAT = 40;
                        ConstAllAirDara.C_AIR_WAISTRIGHT_HEAT = 41;
                        break;
                    case FinalCanbus.CAR_DAOJUN_OD_ATS /* 852316 */:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        break;
                    case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 30;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 36;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 37;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 38;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 39;
                        break;
                }
                ConstAllAirDara.C_AIR_AUTO = 1;
                ConstAllAirDara.C_AIR_DUAL = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 4;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_AC = 8;
                ConstAllAirDara.C_AIR_POWER = 10;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                ConstAllAirDara.C_CONTRAL = 17;
                break;
            case FinalCanbus.CAR_RZC_XP1_BeiQiM50F /* 65932 */:
            case FinalCanbus.CAR_RZC_XP1_BeiQiBJ40_21_H /* 1048972 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_XP1_BeiQiBJ40_21_H /* 1048972 */:
                        ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_DUAL = 3;
                ConstAllAirDara.C_AIR_CYCLE = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 6;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 18;
                ConstAllAirDara.C_AIR_MODE_BODY = 7;
                ConstAllAirDara.C_AIR_MODE_FOOT = 9;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 8;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 10;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_452_XC_Tianlai_GJ /* 65988 */:
            case FinalCanbus.CAR_453_XC_Tianlai_GJ /* 1442245 */:
            case FinalCanbus.CAR_439_HC_Nissan_GuiShi /* 7799223 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 11;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 8;
                ConstAllAirDara.C_AIR_DUAL = 7;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 13;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                break;
            case FinalCanbus.CAR_455_LZ_CG_Toyota_4Runner_Auto /* 65991 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen /* 1114567 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen_3 /* 1180103 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_Proda_18 /* 3604935 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_Proda_23 /* 4194759 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha_3_156inch /* 4784583 */:
            case FinalCanbus.CAR_455_LZ_Daohang_Toyota_Proda_18 /* 10092999 */:
            case FinalCanbus.CAR_455_LZ_Daohang_Toyota_Proda_23 /* 10158535 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_4Runner /* 15073734 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha /* 15204806 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha_3 /* 16187846 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FLOWER_BLOW = 76;
                ConstAllAirDara.U_AIR_ION = 58;
                ConstAllAirDara.U_AIR_REAR_CTRL = 67;
                ConstAllAirDara.U_AIR_SWING = 35;
                ConstAllAirDara.U_AIR_FRONT_HOT = 17;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                ConstAllAirDara.U_AIR_BACK_BLOW_UP = 48;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                ConstAllAirDara.C_REAR_AUTO = 45;
                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 38;
                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 39;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 38;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 39;
                ConstAllAirDara.C_REAR_WIND_DOWN = 40;
                ConstAllAirDara.C_REAR_WIND_UP = 41;
                ConstAllAirDara.C_REAR_OFF = 44;
                ConstAllAirDara.C_REAR_MODE = 43;
                ConstAllAirDara.C_REAR_LOCK = 42;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 18;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_AIR_FLOWER_BLOW = 32;
                ConstAllAirDara.C_AIR_SWING = 29;
                ConstAllAirDara.C_AIR_ION = 28;
                ConstAllAirDara.C_AIR_FRONT_HOT = 26;
                ConstAllAirDara.C_CONTRAL = 22;
                break;
            case FinalCanbus.CAR_456_OD_Hongqi_H5 /* 65992 */:
            case FinalCanbus.CAR_455_CZH_OD_Hongqi_EQM5_Huandian /* 7274951 */:
            case FinalCanbus.CAR_454_CZH_OD_Hongqi_EQM5 /* 16515526 */:
                ConstAllAirDara.U_AIR_FRONT = 18;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_HEAT = 63;
                ConstAllAirDara.U_AIR_PARK = 80;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 1;
                ConstAllAirDara.C_AIR_CYCLE = 2;
                ConstAllAirDara.C_AIR_AUTO = 3;
                ConstAllAirDara.C_AIR_AC = 4;
                ConstAllAirDara.C_AIR_SYNC = 5;
                ConstAllAirDara.C_AIR_HEAT = 6;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 7;
                ConstAllAirDara.C_AIR_MODE_BODY = 8;
                ConstAllAirDara.C_AIR_MODE_FOOT = 9;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 10;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 11;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                ConstAllAirDara.C_AIR_WIND_ADD = 16;
                ConstAllAirDara.C_AIR_WIND_SUB = 17;
                ConstAllAirDara.C_AIR_POWER = 18;
                ConstAllAirDara.C_AIR_PARK = 19;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_RZCexc_Feiyate_TORO /* 131111 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_TORO_M /* 1441831 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_TORO_H /* 1507367 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.TEMPERATURE_NONE = 255;
                ConstAllAirDara.TEMPERATURE_LOW = 0;
                ConstAllAirDara.TEMPERATURE_HIGHT = 127;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_AC_MAX = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 4;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_CYCLE = 6;
                ConstAllAirDara.C_AIR_SYNC = 7;
                ConstAllAirDara.C_AIR_AUTO = 8;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 13;
                ConstAllAirDara.C_AIR_WIND_SUB = 14;
                ConstAllAirDara.C_AIR_MODE_BODY = 15;
                ConstAllAirDara.C_AIR_MODE_FOOT = 17;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 16;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 18;
                ConstAllAirDara.C_AIR_MODE_UP = 19;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_RZC_XP1_16HAIMAMV70 /* 131309 */:
            case FinalCanbus.CAR_RZC_XP1_HAIMA_F5 /* 262381 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_REAR_CTRL = 38;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 5;
                ConstAllAirDara.C_AIR_AC = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 8;
                ConstAllAirDara.C_AIR_WIND_ADD = 9;
                ConstAllAirDara.C_AIR_WIND_SUB = 10;
                ConstAllAirDara.C_AIR_MODE_BODY = 11;
                ConstAllAirDara.C_AIR_MODE_FOOT = 12;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 13;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 14;
                ConstAllAirDara.C_REAR_CTRL = 15;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 16;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6 /* 131379 */:
            case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6_H /* 196915 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONTMAX = 65;
                ConstAllAirDara.U_AIR_FRONT = 18;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6_H /* 196915 */:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_DUAL = 14;
                        ConstAllAirDara.C_AIR_AUTO = 17;
                        ConstAllAirDara.C_AIR_DUAL = 18;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_MODE_BODY = 4;
                ConstAllAirDara.C_AIR_MODE_FOOT = 5;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 6;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 7;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 8;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 9;
                ConstAllAirDara.C_AIR_CYCLE = 10;
                ConstAllAirDara.C_AIR_AC_MAX = 19;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 14;
                ConstAllAirDara.C_AIR_WIND_ADD = 15;
                ConstAllAirDara.C_AIR_WIND_SUB = 16;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_RZC_SeMar_NoAmp /* 196688 */:
            case FinalCanbus.CAR_RZC_SwMar_Amp /* 262224 */:
            case FinalCanbus.CAR_RZC_Nissan_Tianlai_20 /* 721086 */:
            case FinalCanbus.CAR_RZC_Nissan_Tianlai_20_H /* 786622 */:
            case FinalCanbus.CAR_RZC_Nissan_Qijun_H /* 983230 */:
            case FinalCanbus.CAR_RZC_SwMar_17 /* 1441872 */:
            case FinalCanbus.CAR_RZC_SwMar_Amp_17 /* 1507408 */:
            case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_14 /* 1966270 */:
            case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_11 /* 2031806 */:
            case FinalCanbus.CAR_RZC_Nissan_PATROL_13 /* 2097342 */:
            case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_14_H /* 2228414 */:
            case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_11_H /* 2293950 */:
            case FinalCanbus.CAR_RZC_Nissan_PATROL_13_H /* 2359486 */:
            case FinalCanbus.CAR_RZC_Nissan_Xtrail_Import_22 /* 2425022 */:
            case FinalCanbus.CAR_RZC_Nissan_Xtrail_Import_22_H /* 2490558 */:
            case FinalCanbus.CAR_RZC_Nissan_Tuda_18 /* 2556094 */:
            case FinalCanbus.CAR_RZC_Nissan_Tuda_18_H /* 2621630 */:
            case FinalCanbus.CAR_RZC_Nissan_NAVANA_16 /* 2687166 */:
            case FinalCanbus.CAR_RZC_Nissan_NAVANA_16_H /* 2752702 */:
            case FinalCanbus.CAR_RZC_Nissan_SENTRA_18_Import /* 2818238 */:
            case FinalCanbus.CAR_RZC_Nissan_SENTRA_18_Import_H /* 2883774 */:
            case FinalCanbus.CAR_RZC_Nissan_TITAN_19_Import /* 2949310 */:
            case FinalCanbus.CAR_RZC_Nissan_TITAN_19_Import_H /* 3014846 */:
            case FinalCanbus.CAR_RZC_Nissan_SENTRA_13_Import /* 3080382 */:
            case FinalCanbus.CAR_RZC_Nissan_SENTRA_13_Import_H /* 3145918 */:
            case FinalCanbus.CAR_RZC_Sanlin_OULANDE_24Overseas /* 3276990 */:
            case FinalCanbus.CAR_RZC_Sanlin_OULANDE_24Overseas_H /* 3342526 */:
            case FinalCanbus.CAR_RZC_Sanlin_Triton_25Overseas /* 3539134 */:
            case FinalCanbus.CAR_RZC_Sanlin_Triton_25Overseas_H /* 3604670 */:
            case FinalCanbus.CAR_RZC_Nissan_Rogue_14Overseas /* 3670206 */:
            case FinalCanbus.CAR_RZC_Nissan_Rogue_14Overseas_H /* 3735742 */:
            case FinalCanbus.CAR_RZC_Nissan_Rogue_21Overseas /* 3801278 */:
            case FinalCanbus.CAR_RZC_Nissan_Rogue_21Overseas_H /* 3866814 */:
            case FinalCanbus.CAR_RZC_Nissan_Altima_19Overseas /* 3932350 */:
            case FinalCanbus.CAR_RZC_Nissan_Altima_19Overseas_H /* 3997886 */:
            case FinalCanbus.CAR_RZC_Nissan_Pathfinder_22Overseas /* 4063422 */:
            case FinalCanbus.CAR_RZC_Nissan_Pathfinder_22Overseas_H /* 4128958 */:
            case FinalCanbus.CAR_RZC_Nissan_Pathfinder_20Overseas /* 4653246 */:
            case FinalCanbus.CAR_RZC_Nissan_Pathfinder_20Overseas_H /* 4718782 */:
            case FinalCanbus.CAR_439_RZC_Nissan_19Qida /* 8585655 */:
            case FinalCanbus.CAR_439_RZC_Nissan_19Qida_H /* 8651191 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_DUAL = 6;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_CYCLE = 4;
                ConstAllAirDara.C_AIR_AC = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 7;
                ConstAllAirDara.C_AIR_WIND_SUB = 8;
                ConstAllAirDara.C_AIR_WIND_ADD = 9;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 10;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 16;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_14 /* 1966270 */:
                    case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_11 /* 2031806 */:
                    case FinalCanbus.CAR_RZC_Nissan_PATROL_13 /* 2097342 */:
                    case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_14_H /* 2228414 */:
                    case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_11_H /* 2293950 */:
                    case FinalCanbus.CAR_RZC_Nissan_PATROL_13_H /* 2359486 */:
                        ConstAllAirDara.U_AIR_REAR_CTRL = 67;
                        ConstAllAirDara.U_AIR_BLOWTOP = 72;
                        ConstAllAirDara.C_AIR_BLOWTOP = 17;
                        ConstAllAirDara.C_REAR_CTRL = 18;
                        break;
                }
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_Nissan_Tianlai_20 /* 721086 */:
                    case FinalCanbus.CAR_RZC_Nissan_Tianlai_20_H /* 786622 */:
                    case FinalCanbus.CAR_RZC_Nissan_Qijun_H /* 983230 */:
                    case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_14 /* 1966270 */:
                    case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_11 /* 2031806 */:
                    case FinalCanbus.CAR_RZC_Nissan_PATROL_13 /* 2097342 */:
                    case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_14_H /* 2228414 */:
                    case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_11_H /* 2293950 */:
                    case FinalCanbus.CAR_RZC_Nissan_PATROL_13_H /* 2359486 */:
                    case FinalCanbus.CAR_RZC_Nissan_Xtrail_Import_22 /* 2425022 */:
                    case FinalCanbus.CAR_RZC_Nissan_Xtrail_Import_22_H /* 2490558 */:
                    case FinalCanbus.CAR_RZC_Nissan_Tuda_18 /* 2556094 */:
                    case FinalCanbus.CAR_RZC_Nissan_Tuda_18_H /* 2621630 */:
                    case FinalCanbus.CAR_RZC_Nissan_NAVANA_16 /* 2687166 */:
                    case FinalCanbus.CAR_RZC_Nissan_NAVANA_16_H /* 2752702 */:
                    case FinalCanbus.CAR_RZC_Nissan_SENTRA_18_Import /* 2818238 */:
                    case FinalCanbus.CAR_RZC_Nissan_SENTRA_18_Import_H /* 2883774 */:
                    case FinalCanbus.CAR_RZC_Nissan_TITAN_19_Import /* 2949310 */:
                    case FinalCanbus.CAR_RZC_Nissan_TITAN_19_Import_H /* 3014846 */:
                    case FinalCanbus.CAR_RZC_Nissan_SENTRA_13_Import /* 3080382 */:
                    case FinalCanbus.CAR_RZC_Nissan_SENTRA_13_Import_H /* 3145918 */:
                    case FinalCanbus.CAR_RZC_Sanlin_OULANDE_24Overseas /* 3276990 */:
                    case FinalCanbus.CAR_RZC_Sanlin_OULANDE_24Overseas_H /* 3342526 */:
                    case FinalCanbus.CAR_RZC_Sanlin_Triton_25Overseas /* 3539134 */:
                    case FinalCanbus.CAR_RZC_Sanlin_Triton_25Overseas_H /* 3604670 */:
                    case FinalCanbus.CAR_RZC_Nissan_Rogue_14Overseas /* 3670206 */:
                    case FinalCanbus.CAR_RZC_Nissan_Rogue_14Overseas_H /* 3735742 */:
                    case FinalCanbus.CAR_RZC_Nissan_Rogue_21Overseas /* 3801278 */:
                    case FinalCanbus.CAR_RZC_Nissan_Rogue_21Overseas_H /* 3866814 */:
                    case FinalCanbus.CAR_RZC_Nissan_Altima_19Overseas /* 3932350 */:
                    case FinalCanbus.CAR_RZC_Nissan_Altima_19Overseas_H /* 3997886 */:
                    case FinalCanbus.CAR_RZC_Nissan_Pathfinder_22Overseas /* 4063422 */:
                    case FinalCanbus.CAR_RZC_Nissan_Pathfinder_22Overseas_H /* 4128958 */:
                    case FinalCanbus.CAR_RZC_Nissan_Pathfinder_20Overseas /* 4653246 */:
                    case FinalCanbus.CAR_RZC_Nissan_Pathfinder_20Overseas_H /* 4718782 */:
                    case FinalCanbus.CAR_439_RZC_Nissan_19Qida /* 8585655 */:
                    case FinalCanbus.CAR_439_RZC_Nissan_19Qida_H /* 8651191 */:
                        ConstAllAirDara.C_CONTRAL = 0;
                        break;
                    default:
                        ConstAllAirDara.C_CONTRAL = 2;
                        break;
                }
                break;
            case FinalCanbus.CAR_RZC_HanTeng_H /* 196863 */:
            case FinalCanbus.CAR_Oudi_HanTeng_X5 /* 393471 */:
            case FinalCanbus.CAR_Oudi_XiaoYao /* 459007 */:
            case FinalCanbus.CAR_RZC_HanTeng_X5 /* 524543 */:
            case FinalCanbus.CAR_RZC_FengShen19_20AX7 /* 917759 */:
            case FinalCanbus.CAR_RZC_FengShen19_20AX7_H /* 983295 */:
            case FinalCanbus.CAR_RZC_FengShen_X37_21 /* 1442047 */:
            case FinalCanbus.CAR_RZC_FengShen15AX7 /* 1638655 */:
            case FinalCanbus.CAR_RZC_FengShen19AX7_Hand /* 1704191 */:
            case FinalCanbus.CAR_RZC_FengShen15AX7_View /* 1769727 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_HanTeng_H /* 196863 */:
                    case FinalCanbus.CAR_RZC_HanTeng_X5 /* 524543 */:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_AC_MAX = 53;
                        ConstAllAirDara.C_AIR_AUTO = 17;
                        ConstAllAirDara.C_AIR_AC_MAX = 18;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 19;
                        ConstAllAirDara.C_CONTRAL = 2;
                        break;
                    case FinalCanbus.CAR_RZC_FengShen19_20AX7 /* 917759 */:
                    case FinalCanbus.CAR_RZC_FengShen19_20AX7_H /* 983295 */:
                    case FinalCanbus.CAR_RZC_FengShen_X37_21 /* 1442047 */:
                    case FinalCanbus.CAR_RZC_FengShen15AX7 /* 1638655 */:
                    case FinalCanbus.CAR_RZC_FengShen19AX7_Hand /* 1704191 */:
                    case FinalCanbus.CAR_RZC_FengShen15AX7_View /* 1769727 */:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.C_AIR_AUTO = 17;
                        ConstAllAirDara.C_AIR_MODE_BODY = 12;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 13;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 14;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 15;
                        ConstAllAirDara.C_CONTRAL = 1;
                        break;
                    default:
                        ConstAllAirDara.C_AIR_MODE_BODY = 12;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 13;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 14;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 15;
                        ConstAllAirDara.C_AIR_MODE_UP = 16;
                        ConstAllAirDara.C_CONTRAL = 2;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 5;
                ConstAllAirDara.C_AIR_AC = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 8;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 11;
                break;
            case FinalCanbus.CAR_CYT_YaGe7_38400 /* 262561 */:
            case FinalCanbus.CAR_RCW_BYD_10_11F6 /* 328097 */:
            case FinalCanbus.CAR_RCW_BYD_10_13G6 /* 393633 */:
            case FinalCanbus.CAR_RCW_YaGe7_38400 /* 459169 */:
            case FinalCanbus.CAR_WC_YaGe7_38400 /* 524705 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_CONTRAL = 22;
                break;
            case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria /* 328124 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria_H /* 393660 */:
            case FinalCanbus.CAR_446_WC2_Teyes_XianDai_All_22SantaFe /* 1311166 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_15Carnival /* 1966524 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_15Carnival_H /* 2032060 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_23NewZealand /* 2097596 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_23NewZealand_H /* 2163132 */:
            case FinalCanbus.CAR_446_WC2_XianDai_CUSTO /* 2687422 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra /* 2949564 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra_H /* 3015100 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra_EV /* 3211708 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_20NIRO /* 3342780 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_12K9 /* 3408316 */:
            case FinalCanbus.CAR_444_WC2_Shuanglong_All_11Korando /* 3473852 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria_Amp /* 3539388 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_18Lafesta /* 3670460 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_17SoNaTa_USA /* 3735996 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_19Shengda_H /* 3867067 */:
            case FinalCanbus.CAR_444_Tyes_WC2_XianDai_All_21Elantra_EV /* 3998140 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_21IX35 /* 11993532 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_21IX35_H /* 12059068 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_20IX25 /* 12124604 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_20IX25_H /* 12190140 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_18OPTIMA /* 15073723 */:
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria /* 328124 */:
                    case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria_H /* 393660 */:
                    case FinalCanbus.CAR_446_WC2_Teyes_XianDai_All_22SantaFe /* 1311166 */:
                    case FinalCanbus.CAR_444_WC2_XianDai_All_15Carnival /* 1966524 */:
                    case FinalCanbus.CAR_444_WC2_XianDai_All_15Carnival_H /* 2032060 */:
                    case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria_Amp /* 3539388 */:
                    case FinalCanbus.CAR_443_WC2_XianDai_All_19Shengda_H /* 3867067 */:
                    case FinalCanbus.CAR_444_WC2_XianDai_All_21IX35 /* 11993532 */:
                    case FinalCanbus.CAR_444_WC2_XianDai_All_21IX35_H /* 12059068 */:
                    case FinalCanbus.CAR_444_WC2_XianDai_All_20IX25 /* 12124604 */:
                    case FinalCanbus.CAR_444_WC2_XianDai_All_20IX25_H /* 12190140 */:
                        switch (DataCanbus.DATA[1000]) {
                            case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria /* 328124 */:
                            case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria_H /* 393660 */:
                            case FinalCanbus.CAR_446_WC2_Teyes_XianDai_All_22SantaFe /* 1311166 */:
                                ConstAllAirDara.U_AIR_HAVE_REAR = 2;
                                break;
                            case FinalCanbus.CAR_444_WC2_XianDai_All_15Carnival /* 1966524 */:
                            case FinalCanbus.CAR_444_WC2_XianDai_All_15Carnival_H /* 2032060 */:
                            case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria_Amp /* 3539388 */:
                            case FinalCanbus.CAR_444_WC2_XianDai_All_21IX35 /* 11993532 */:
                            case FinalCanbus.CAR_444_WC2_XianDai_All_21IX35_H /* 12059068 */:
                            case FinalCanbus.CAR_444_WC2_XianDai_All_20IX25 /* 12124604 */:
                            case FinalCanbus.CAR_444_WC2_XianDai_All_20IX25_H /* 12190140 */:
                                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                                break;
                        }
                        ConstAllAirDara.U_AIR_BACK_POWER = 42;
                        ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                        ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                        ConstAllAirDara.U_AIR_BACK_BLOW_UP = 46;
                        ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                        ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                        ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                        ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                        ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                        ConstAllAirDara.C_REAR_LOCK = 34;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 33;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 32;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 33;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 32;
                        ConstAllAirDara.C_REAR_OFF = 19;
                        ConstAllAirDara.C_REAR_AUTO = 66;
                        ConstAllAirDara.C_REAR_MODE = 62;
                        ConstAllAirDara.C_REAR_WIND_DOWN = 43;
                        ConstAllAirDara.C_REAR_WIND_UP = 42;
                        break;
                }
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_CLEAN = 76;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                ConstAllAirDara.C_AIR_LEFT_COLD = 23;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 24;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_SYNC = 3;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_MODE_BODY = 26;
                ConstAllAirDara.C_AIR_MODE_FOOT = 29;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 27;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 28;
                ConstAllAirDara.C_CLEAN = 25;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_WC2_20BaoJun530_Auto /* 393462 */:
            case FinalCanbus.CAR_WC2_20BaoJun530_Hand /* 458998 */:
            case FinalCanbus.CAR_WC2_20BaoJunRS5 /* 524534 */:
            case FinalCanbus.CAR_WC2_20BaoJunRS5_H /* 590070 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 14;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 27;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 28;
                ConstAllAirDara.C_AIR_MODE_BODY = 26;
                ConstAllAirDara.C_AIR_MODE_FOOT = 29;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_OD_Jiangxi_Wushiling_Mux /* 393638 */:
            case FinalCanbus.CAR_OD_Jiangxi_Lingtuo /* 459174 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_CONTRAL = 4;
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_WIND_ADD = 1;
                ConstAllAirDara.C_AIR_WIND_SUB = 161;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 162;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 162;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 7;
                ConstAllAirDara.C_AIR_AC = 4;
                ConstAllAirDara.C_AIR_CYCLE = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_AUTO = 9;
                break;
            case FinalCanbus.CAR_RZC_20BaoJunRS3 /* 459062 */:
            case FinalCanbus.CAR_OD_RZC_20BaoJunRS3 /* 590134 */:
            case FinalCanbus.CAR_OD_RZC_Wuling_Xingchen /* 655670 */:
            case FinalCanbus.CAR_RZC_Wuling_Xingchen /* 721206 */:
            case FinalCanbus.CAR_RZC_Wuling_Kaijie /* 786742 */:
            case FinalCanbus.CAR_RZC_Wuling_Jiachen /* 852278 */:
            case FinalCanbus.CAR_RZC_20BaoJunRS3_Auto /* 917814 */:
            case FinalCanbus.CAR_RZC_Wuling_Xingchen_Auto /* 983350 */:
            case FinalCanbus.CAR_RZC_Wuling_Kaijie_Auto /* 1048886 */:
            case FinalCanbus.CAR_RZC_Wuling_Jiachen_Auto /* 1114422 */:
            case FinalCanbus.CAR_RZC_Wuling_Xingchi /* 1179958 */:
            case FinalCanbus.CAR_RZC_Wuling_Xingchi_Auto /* 1245494 */:
            case FinalCanbus.CAR_OD_RZC_Wuling_23XingGuang /* 1311030 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 18;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_20BaoJunRS3 /* 459062 */:
                    case FinalCanbus.CAR_RZC_Wuling_Xingchen /* 721206 */:
                    case FinalCanbus.CAR_RZC_Wuling_Jiachen /* 852278 */:
                    case FinalCanbus.CAR_RZC_Wuling_Xingchi /* 1179958 */:
                        ConstAllAirDara.U_AIR_AC_MAX = 53;
                        ConstAllAirDara.C_AIR_AC_MAX = 22;
                        break;
                    case FinalCanbus.CAR_OD_RZC_20BaoJunRS3 /* 590134 */:
                    case FinalCanbus.CAR_OD_RZC_Wuling_Xingchen /* 655670 */:
                        ConstAllAirDara.U_AIR_AC_MAX = 53;
                        ConstAllAirDara.C_AIR_AC_MAX = 24;
                        break;
                    case FinalCanbus.CAR_RZC_Wuling_Kaijie /* 786742 */:
                        ConstAllAirDara.U_AIR_AC_MAX = 53;
                        ConstAllAirDara.U_AIR_ION = 58;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.C_AIR_AC_MAX = 22;
                        ConstAllAirDara.C_AIR_ION = 24;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 25;
                        break;
                    case FinalCanbus.CAR_RZC_20BaoJunRS3_Auto /* 917814 */:
                    case FinalCanbus.CAR_RZC_Wuling_Xingchen_Auto /* 983350 */:
                    case FinalCanbus.CAR_RZC_Wuling_Jiachen_Auto /* 1114422 */:
                    case FinalCanbus.CAR_RZC_Wuling_Xingchi_Auto /* 1245494 */:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.C_AIR_AUTO = 2;
                        break;
                    case FinalCanbus.CAR_RZC_Wuling_Kaijie_Auto /* 1048886 */:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.C_AIR_AUTO = 2;
                        ConstAllAirDara.U_AIR_ION = 58;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.C_AIR_ION = 24;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 25;
                        break;
                    case FinalCanbus.CAR_OD_RZC_Wuling_23XingGuang /* 1311030 */:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_AC_MAX = 53;
                        ConstAllAirDara.C_AIR_AC_MAX = 24;
                        ConstAllAirDara.C_AIR_AUTO = 2;
                        break;
                }
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 6;
                ConstAllAirDara.C_AIR_MODE_BODY = 7;
                ConstAllAirDara.C_AIR_MODE_FOOT = 9;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 8;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 10;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 23;
                ConstAllAirDara.C_AIR_CYCLE = 21;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_444_WC2_Wuling_Xingguang70_24 /* 459196 */:
            case FinalCanbus.CAR_444_WC2_VinFast_VF5 /* 4129212 */:
            case FinalCanbus.CAR_444_WC2_Wuling_Kaijie_20_L /* 5505468 */:
            case FinalCanbus.CAR_444_WC2_Wuling_Kaijie_20_H /* 5571004 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 14;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_MODE_BODY = 26;
                ConstAllAirDara.C_AIR_MODE_FOOT = 29;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 27;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 28;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_XP1_Camry2018 /* 589844 */:
            case FinalCanbus.CAR_XP1_Camry2018_H /* 655380 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.C_AIR_LEFT_COLD = 12;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 14;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_MODE_ADD = 8;
                ConstAllAirDara.C_AIR_MODE_SUB = 7;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_CONTRAL = 25;
                break;
            case FinalCanbus.CAR_RZC_OD_DongNanDX5 /* 590153 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 8;
                ConstAllAirDara.C_AIR_AUTO = 10;
                ConstAllAirDara.C_AIR_AC_MAX = 12;
                ConstAllAirDara.C_AIR_CYCLE = 13;
                ConstAllAirDara.C_AIR_AC = 11;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 7;
                ConstAllAirDara.C_AIR_WIND_SUB = 6;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 14;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_CONTRAL = 7;
                break;
            case FinalCanbus.CAR_RZC_Explorer /* 590158 */:
            case FinalCanbus.CAR_RZC_13_20Mengdiou /* 852302 */:
            case FinalCanbus.CAR_RZC_Mustang /* 1048910 */:
            case FinalCanbus.CAR_RZC_Ford_F150_12 /* 2294094 */:
            case FinalCanbus.CAR_RZC_Mustang_NO_CD /* 2359630 */:
            case FinalCanbus.CAR_RZC_Mustang_15_NO_CD /* 2621774 */:
            case FinalCanbus.CAR_RZC_Explorer_13 /* 3014990 */:
            case FinalCanbus.CAR_RZC_Ford_F150 /* 3080526 */:
            case FinalCanbus.CAR_RZC_Ford_Puma_22 /* 3670350 */:
            case FinalCanbus.CAR_RZC_Mustang_M /* 5374286 */:
            case FinalCanbus.CAR_RZC_Mustang_H /* 5439822 */:
            case FinalCanbus.CAR_RZC_Mustang_NOCD_M /* 5505358 */:
            case FinalCanbus.CAR_RZC_Mustang_NOCD_H /* 5570894 */:
            case FinalCanbus.CAR_RZC_Ford_Puma_22_M /* 5636430 */:
            case FinalCanbus.CAR_RZC_Ford_Puma_22_H /* 5701966 */:
            case FinalCanbus.CAR_RZC_Ford_BRONCO_22 /* 5767502 */:
            case FinalCanbus.CAR_RZC_Ford_BRONCO_22_M /* 5833038 */:
            case FinalCanbus.CAR_RZC_Ford_BRONCO_22_H /* 5898574 */:
            case FinalCanbus.CAR_RZC_Ford_MAVERICK_24 /* 5964110 */:
            case FinalCanbus.CAR_RZC_Ford_MAVERICK_24_M /* 6029646 */:
            case FinalCanbus.CAR_RZC_Ford_MAVERICK_24_H /* 6095182 */:
            case FinalCanbus.CAR_RZC_Ford_Explorer_24 /* 6160718 */:
            case FinalCanbus.CAR_RZC_Ford_Explorer_24_M /* 6226254 */:
            case FinalCanbus.CAR_RZC_Ford_Explorer_24_H /* 6291790 */:
            case FinalCanbus.CAR_RZC_Ford_RANGER_24 /* 6357326 */:
            case FinalCanbus.CAR_RZC_Ford_RANGER_24_M /* 6422862 */:
            case FinalCanbus.CAR_RZC_Ford_RANGER_24_H /* 6488398 */:
            case FinalCanbus.CAR_RZC_Ford_F250_09 /* 6553934 */:
            case FinalCanbus.CAR_RZC_Ford_Expedition_07 /* 6619470 */:
            case FinalCanbus.CAR_RZC_Ford_Expedition_15 /* 6685006 */:
            case FinalCanbus.CAR_RZC_Ford_Flex_13 /* 6750542 */:
                ConstAllAirDara.TEMPERATURE_NONE = 1048578;
                ConstAllAirDara.TEMPERATURE_LOW = 1048576;
                ConstAllAirDara.TEMPERATURE_HIGHT = FinalCanbus.CAR_WC1_VW_Polo_08_18;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_FRONT_HOT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.C_AIR_FRONT_HOT = 5;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_Explorer /* 590158 */:
                    case FinalCanbus.CAR_RZC_Ford_Explorer_24 /* 6160718 */:
                    case FinalCanbus.CAR_RZC_Ford_Explorer_24_M /* 6226254 */:
                    case FinalCanbus.CAR_RZC_Ford_Explorer_24_H /* 6291790 */:
                        ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                        ConstAllAirDara.U_AIR_BACK_POWER = 42;
                        ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                        ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                        ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 20;
                        ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 19;
                        ConstAllAirDara.U_AIR_BACK_BLOW_UP = 19;
                        ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                        ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 30;
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.C_AIR_AUTO = 23;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 8;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 10;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 7;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 9;
                        ConstAllAirDara.C_AIR_MODE_UP = 32;
                        ConstAllAirDara.C_AIR_MODE_BODY = 33;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 34;
                        ConstAllAirDara.C_REAR_OFF = 17;
                        ConstAllAirDara.C_REAR_MODE_FOOT = 34;
                        ConstAllAirDara.C_REAR_MODE_BODY = 33;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 19;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 20;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 19;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 20;
                        ConstAllAirDara.C_REAR_WIND_DOWN = 21;
                        ConstAllAirDara.C_REAR_WIND_UP = 22;
                        ConstAllAirDara.C_REAR_LOCK = 18;
                        break;
                    case FinalCanbus.CAR_RZC_13_20Mengdiou /* 852302 */:
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 30;
                        ConstAllAirDara.U_AIR_STEER = 66;
                        ConstAllAirDara.C_AIR_STEER = 11;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 8;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 10;
                        ConstAllAirDara.C_AIR_MODE_UP = 32;
                        ConstAllAirDara.C_AIR_MODE_BODY = 33;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 34;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 7;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 9;
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.C_AIR_AUTO = 23;
                        break;
                    case FinalCanbus.CAR_RZC_Mustang /* 1048910 */:
                    case FinalCanbus.CAR_RZC_Mustang_NO_CD /* 2359630 */:
                    case FinalCanbus.CAR_RZC_Mustang_M /* 5374286 */:
                    case FinalCanbus.CAR_RZC_Mustang_H /* 5439822 */:
                    case FinalCanbus.CAR_RZC_Mustang_NOCD_M /* 5505358 */:
                    case FinalCanbus.CAR_RZC_Mustang_NOCD_H /* 5570894 */:
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 48;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 30;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 8;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 10;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 7;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 9;
                        break;
                    case FinalCanbus.CAR_RZC_Ford_F150_12 /* 2294094 */:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.C_AIR_AUTO = 23;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 7;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 9;
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 30;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 8;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 10;
                        ConstAllAirDara.C_AIR_MODE_UP = 32;
                        ConstAllAirDara.C_AIR_MODE_BODY = 33;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 34;
                        break;
                    case FinalCanbus.CAR_RZC_Mustang_15_NO_CD /* 2621774 */:
                    case FinalCanbus.CAR_RZC_Ford_Puma_22 /* 3670350 */:
                    case FinalCanbus.CAR_RZC_Ford_Puma_22_M /* 5636430 */:
                    case FinalCanbus.CAR_RZC_Ford_Puma_22_H /* 5701966 */:
                    case FinalCanbus.CAR_RZC_Ford_BRONCO_22 /* 5767502 */:
                    case FinalCanbus.CAR_RZC_Ford_BRONCO_22_M /* 5833038 */:
                    case FinalCanbus.CAR_RZC_Ford_BRONCO_22_H /* 5898574 */:
                    case FinalCanbus.CAR_RZC_Ford_MAVERICK_24 /* 5964110 */:
                    case FinalCanbus.CAR_RZC_Ford_MAVERICK_24_M /* 6029646 */:
                    case FinalCanbus.CAR_RZC_Ford_MAVERICK_24_H /* 6095182 */:
                    case FinalCanbus.CAR_RZC_Ford_RANGER_24 /* 6357326 */:
                    case FinalCanbus.CAR_RZC_Ford_RANGER_24_M /* 6422862 */:
                    case FinalCanbus.CAR_RZC_Ford_RANGER_24_H /* 6488398 */:
                    case FinalCanbus.CAR_RZC_Ford_F250_09 /* 6553934 */:
                    case FinalCanbus.CAR_RZC_Ford_Expedition_07 /* 6619470 */:
                    case FinalCanbus.CAR_RZC_Ford_Expedition_15 /* 6685006 */:
                    case FinalCanbus.CAR_RZC_Ford_Flex_13 /* 6750542 */:
                        ConstAllAirDara.C_AIR_MODE_UP = 32;
                        ConstAllAirDara.C_AIR_MODE_BODY = 33;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 34;
                        break;
                    case FinalCanbus.CAR_RZC_Explorer_13 /* 3014990 */:
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 30;
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_STEER = 66;
                        ConstAllAirDara.U_AIR_FRONT_HOT = 65;
                        ConstAllAirDara.C_AIR_FRONT_HOT = 5;
                        ConstAllAirDara.C_AIR_STEER = 11;
                        ConstAllAirDara.C_AIR_AUTO = 23;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 8;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 10;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 7;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 9;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 35;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 37;
                        ConstAllAirDara.C_AIR_MODE_BODY = 38;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 36;
                        break;
                    case FinalCanbus.CAR_RZC_Ford_F150 /* 3080526 */:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.C_AIR_AUTO = 23;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 35;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 37;
                        ConstAllAirDara.C_AIR_MODE_BODY = 38;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 36;
                        break;
                }
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 26;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 27;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 28;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 29;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 25;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_AC_MAX = 4;
                ConstAllAirDara.C_AIR_DUAL = 24;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_WIND_ADD = 30;
                ConstAllAirDara.C_AIR_WIND_SUB = 31;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_LZ_Dodge_RAM1500_09 /* 655647 */:
            case FinalCanbus.CAR_LZ_Dodge_RAM2500_09 /* 721183 */:
            case FinalCanbus.CAR_LZ_Dodge_RAM3500_09 /* 786719 */:
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 29;
                ConstAllAirDara.U_AIR_STEER = 66;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 1;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 3;
                ConstAllAirDara.C_AIR_LEFT_COLD = 2;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 4;
                ConstAllAirDara.C_AIR_STEER = 5;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_RZC_18Zhihuiguan /* 655733 */:
            case FinalCanbus.CAR_RZC_18Zhihuiguan_H /* 786805 */:
            case FinalCanbus.CAR_RZC_20Zhihuiguan_EV /* 983413 */:
            case FinalCanbus.CAR_RZC_Dodge_JCUV /* 1114485 */:
            case FinalCanbus.CAR_RZC_Dodge_JCUV_H /* 2359669 */:
            case FinalCanbus.CAR_RZC_CHRYSLER_21PACIFICA /* 2556277 */:
            case FinalCanbus.CAR_RZC_CHRYSLER_21PACIFICA_H /* 2621813 */:
            case FinalCanbus.CAR_RZC_Dodge_15CHARGER /* 2687349 */:
            case FinalCanbus.CAR_RZC_Dodge_15CHARGER_H /* 2752885 */:
            case FinalCanbus.CAR_RZC_Dodge_17DURANGO /* 2818421 */:
            case FinalCanbus.CAR_RZC_Dodge_17DURANGO_H /* 2883957 */:
            case FinalCanbus.CAR_RZC_CHRYSLER_19PACIFICA_H /* 3211637 */:
            case FinalCanbus.CAR_RZC_Dodge_20RAM /* 3277173 */:
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_STEER = 66;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.U_AIR_REAR_SYNC = 86;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 31;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 30;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 33;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 32;
                ConstAllAirDara.C_AIR_AUTO = 20;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 48;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 50;
                ConstAllAirDara.C_AIR_LEFT_COLD = 49;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 51;
                ConstAllAirDara.C_AIR_POWER = 9;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 21;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 22;
                ConstAllAirDara.C_AIR_WIND_ADD = 29;
                ConstAllAirDara.C_AIR_WIND_SUB = 28;
                ConstAllAirDara.C_AIR_AC = 17;
                ConstAllAirDara.C_AIR_CYCLE = 19;
                ConstAllAirDara.C_AIR_SYNC = 23;
                ConstAllAirDara.C_AIR_MODE_BODY = 24;
                ConstAllAirDara.C_AIR_MODE_FOOT = 26;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 25;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 27;
                ConstAllAirDara.C_AIR_AC_MAX = 18;
                ConstAllAirDara.C_AIR_STEER = 52;
                ConstAllAirDara.C_REAR_OFF = 1;
                ConstAllAirDara.C_REAR_MODE_FOOT = 7;
                ConstAllAirDara.C_REAR_MODE_BODY = 5;
                ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 6;
                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 10;
                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 11;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 10;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 11;
                ConstAllAirDara.C_REAR_WIND_DOWN = 8;
                ConstAllAirDara.C_REAR_WIND_UP = 9;
                ConstAllAirDara.C_REAR_LOCK = 4;
                ConstAllAirDara.C_REAR_SYNC = 3;
                ConstAllAirDara.C_REAR_AUTO = 2;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_RZC_BenTeng_19B50_HAND /* 655773 */:
            case FinalCanbus.CAR_RZC_BenTeng_19B50_AUTO /* 721309 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 18;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_BenTeng_19B50_HAND /* 655773 */:
                        ConstAllAirDara.C_AIR_MODE_BODY = 7;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 9;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 8;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 10;
                        break;
                    case FinalCanbus.CAR_RZC_BenTeng_19B50_AUTO /* 721309 */:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.C_AIR_AUTO = 2;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 6;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 14;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 23;
                ConstAllAirDara.C_AIR_CYCLE = 21;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_BNR_NISSAN_14QiJun_H /* 721220 */:
            case FinalCanbus.CAR_BNR_NISSAN_14QiJun_L /* 786756 */:
            case FinalCanbus.CAR_BNR_NISSAN_16Xiaoke_L /* 852292 */:
            case FinalCanbus.CAR_BNR_NISSAN_13TianLai_H /* 917828 */:
            case FinalCanbus.CAR_BNR_NISSAN_16Xiaoke_H /* 983364 */:
            case FinalCanbus.CAR_BNR_NISSAN_13TianLai_L /* 1048900 */:
            case FinalCanbus.CAR_BNR_NISSAN_08TianLai_H /* 1114436 */:
            case FinalCanbus.CAR_BNR_NISSAN_08TianLai_L /* 1179972 */:
            case FinalCanbus.CAR_BNR_NISSAN_11QiDa_H /* 1245508 */:
            case FinalCanbus.CAR_BNR_NISSAN_11QiDa_L /* 1311044 */:
            case FinalCanbus.CAR_BNR_NISSAN_14QiJun_RS /* 1376580 */:
            case FinalCanbus.CAR_BNR_NISSAN_14QiJun_RS_L /* 1442116 */:
                ConstAllAirDara.TEMPERATURE_LOW = 0;
                ConstAllAirDara.TEMPERATURE_HIGHT = 127;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                if (DataCanbus.DATA[1000] == 1245508 || DataCanbus.DATA[1000] == 983364 || DataCanbus.DATA[1000] == 1114436 || DataCanbus.DATA[1000] == 917828 || DataCanbus.DATA[1000] == 721220) {
                    ConstAllAirDara.U_AIR_DUAL = 14;
                    ConstAllAirDara.U_AIR_AUTO = 13;
                    ConstAllAirDara.C_AIR_AUTO = 21;
                    ConstAllAirDara.C_AIR_DUAL = 16;
                } else if (DataCanbus.DATA[1000] == 1376580) {
                    ConstAllAirDara.U_AIR_FRONT_HOT = 65;
                    ConstAllAirDara.C_AIR_FRONT_HOT = 39;
                    ConstAllAirDara.U_AIR_DUAL = 14;
                    ConstAllAirDara.U_AIR_AUTO = 13;
                    ConstAllAirDara.C_AIR_AUTO = 21;
                    ConstAllAirDara.C_AIR_DUAL = 16;
                } else if (DataCanbus.DATA[1000] == 1442116) {
                    ConstAllAirDara.U_AIR_FRONT_HOT = 65;
                    ConstAllAirDara.C_AIR_FRONT_HOT = 39;
                }
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_439_OuDi_ZTT500 /* 721335 */:
            case FinalCanbus.CAR_439_OuDi_DMX7 /* 917943 */:
            case FinalCanbus.CAR_439_OuDi_Z560 /* 983479 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 38;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 4;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_DUAL = 6;
                ConstAllAirDara.C_AIR_WIND_ADD = 7;
                ConstAllAirDara.C_AIR_WIND_SUB = 8;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_MODE_UP = 13;
                ConstAllAirDara.C_AIR_MODE_BODY = 14;
                ConstAllAirDara.C_AIR_MODE_FOOT = 15;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 16;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 17;
                ConstAllAirDara.C_AIR_AUTO = 18;
                ConstAllAirDara.C_AIR_AC_MAX = 19;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 20;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 21;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_455_OD_Zhongtai_E200 /* 786887 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_HEAT = 63;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 3;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 7;
                ConstAllAirDara.C_AIR_WIND_ADD = 9;
                ConstAllAirDara.C_AIR_WIND_SUB = 10;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_HEAT = 21;
                ConstAllAirDara.C_AIR_AC = 22;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_RZC_19MingjueHS /* 852241 */:
            case FinalCanbus.CAR_RZC_19RongWei_I5 /* 917777 */:
            case FinalCanbus.CAR_RZC_19RongWei_I6 /* 983313 */:
            case FinalCanbus.CAR_RZC_19MingjueHS_H /* 1048849 */:
            case FinalCanbus.CAR_RZC_19RongWei_I5_H /* 1114385 */:
            case FinalCanbus.CAR_RZC_19RongWei_RX8 /* 1310993 */:
            case FinalCanbus.CAR_RZC_Mingjue_20ZS /* 1376529 */:
            case FinalCanbus.CAR_RZC_Mingjue_20ZS_H /* 1442065 */:
            case FinalCanbus.CAR_RZC_19Mingjue_MG6 /* 1507601 */:
            case FinalCanbus.CAR_RZC_18RongWei_RX8 /* 1638673 */:
            case FinalCanbus.CAR_RZC_20RongWei_RX5 /* 1704209 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_21 /* 1835281 */:
            case FinalCanbus.CAR_RZC_21RongWei_I5 /* 1900817 */:
            case FinalCanbus.CAR_RZC_21RongWei_I5_H /* 1966353 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_21_L /* 2031889 */:
            case FinalCanbus.CAR_CZH_RZC_19Mingjue_MG6 /* 2097425 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_22_Top /* 2162961 */:
            case FinalCanbus.CAR_RZC_23MingjueHS /* 2228497 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_25 /* 2294033 */:
            case FinalCanbus.CAR_RZC_23RongWei_I5 /* 2425105 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_21_Top /* 2490641 */:
            case FinalCanbus.CAR_RZC_MingJue_MG6_21_Pro /* 2556177 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.C_AIR_DUAL = 23;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_19MingjueHS /* 852241 */:
                    case FinalCanbus.CAR_RZC_19RongWei_I5 /* 917777 */:
                    case FinalCanbus.CAR_RZC_19MingjueHS_H /* 1048849 */:
                    case FinalCanbus.CAR_RZC_19RongWei_I5_H /* 1114385 */:
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.C_AIR_AUTO = 9;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                        ConstAllAirDara.C_AIR_MODE_BODY = 225;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 226;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 227;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 228;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 21;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 245;
                        break;
                    case FinalCanbus.CAR_RZC_19RongWei_RX8 /* 1310993 */:
                    case FinalCanbus.CAR_RZC_18RongWei_RX8 /* 1638673 */:
                        ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                        ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                        ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                        ConstAllAirDara.U_AIR_BACK_BLOW_UP = 46;
                        ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                        ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                        ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                        ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                        ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                        ConstAllAirDara.U_AIR_BACK_POWER = 42;
                        ConstAllAirDara.C_REAR_LOCK = 22;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 248;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 24;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 248;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 24;
                        ConstAllAirDara.C_REAR_AUTO = 27;
                        ConstAllAirDara.C_REAR_OFF = 26;
                        ConstAllAirDara.C_REAR_MODE_FOOT = 81;
                        ConstAllAirDara.C_REAR_MODE_BODY = 82;
                        ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 83;
                        ConstAllAirDara.C_REAR_WIND_DOWN = 228;
                        ConstAllAirDara.C_REAR_WIND_UP = 20;
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.C_AIR_AUTO = 9;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 21;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 245;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 2;
                        break;
                    case FinalCanbus.CAR_RZC_MingJue_MG5_21_L /* 2031889 */:
                    case FinalCanbus.CAR_RZC_MingJue_MG5_21_Top /* 2490641 */:
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 1;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 241;
                        ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 2;
                        break;
                    default:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.C_AIR_AUTO = 9;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 21;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 245;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 2;
                        break;
                }
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 241;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_WIND_ADD = 4;
                ConstAllAirDara.C_AIR_WIND_SUB = 244;
                ConstAllAirDara.C_AIR_POWER = 5;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 6;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 7;
                ConstAllAirDara.C_AIR_AC = 8;
                ConstAllAirDara.C_CONTRAL = 5;
                break;
            case FinalCanbus.CAR_455_XP_Ford_F150_2012 /* 852423 */:
            case FinalCanbus.CAR_455_XP_Ford_F150_2012_Auto /* 917959 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_455_XP_Ford_F150_2012 /* 852423 */:
                        ConstAllAirDara.C_AIR_MODE_BODY = 8;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 9;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 11;
                        break;
                    case FinalCanbus.CAR_455_XP_Ford_F150_2012_Auto /* 917959 */:
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 12;
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_DUAL = 14;
                        ConstAllAirDara.C_AIR_AUTO = 2;
                        ConstAllAirDara.C_AIR_DUAL = 13;
                        break;
                }
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 20;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 21;
                ConstAllAirDara.C_AIR_POWER = 16;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_AC_MAX = 19;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 14;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 15;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                ConstAllAirDara.C_AIR_LEFT_COLD = 22;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 23;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx /* 917956 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx_H /* 983492 */:
            case FinalCanbus.CAR_453_LZ_Toyota_REIZ_09 /* 1114565 */:
            case FinalCanbus.CAR_453_LZ_Toyota_REIZ_09_H /* 1180101 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_IS /* 3080631 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_IS_H /* 3146167 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_ES /* 3211703 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_ES_H /* 3277239 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460 /* 5308868 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460_H /* 5374404 */:
            case FinalCanbus.CAR_452_LZ_Toyota_LC100 /* 5439940 */:
            case FinalCanbus.CAR_452_LZ_Toyota_LC100_H /* 5505476 */:
            case FinalCanbus.CAR_453_LZ_Toyota_markII_L /* 9634245 */:
            case FinalCanbus.CAR_453_LZ_Toyota_markII_H /* 9699781 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_CYCLE_AUTO = 54;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_453_LZ_Toyota_REIZ_09 /* 1114565 */:
                    case FinalCanbus.CAR_453_LZ_Toyota_REIZ_09_H /* 1180101 */:
                        ConstAllAirDara.U_AIR_HAVE_REAR = 255;
                        break;
                    case FinalCanbus.CAR_453_LZ_Toyota_markII_L /* 9634245 */:
                    case FinalCanbus.CAR_453_LZ_Toyota_markII_H /* 9699781 */:
                        ConstAllAirDara.U_AIR_SWING = 35;
                        ConstAllAirDara.C_AIR_SWING = 60;
                        ConstAllAirDara.C_AIR_OUTSIDE = 15;
                        break;
                    default:
                        ConstAllAirDara.U_AIR_FRONT_HOT = 17;
                        ConstAllAirDara.U_AIR_REAR_CTRL = 67;
                        ConstAllAirDara.U_AIR_SWING = 35;
                        switch (DataCanbus.DATA[1000]) {
                            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460 /* 5308868 */:
                                ConstAllAirDara.U_AIR_CLEAN = 76;
                                ConstAllAirDara.C_CLEAN = 39;
                                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 41;
                                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 41;
                                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 42;
                                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 50;
                                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 51;
                                break;
                            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460_H /* 5374404 */:
                                ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                                ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                                ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
                                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 41;
                                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 41;
                                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 42;
                                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 50;
                                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 51;
                                ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT = 37;
                                ConstAllAirDara.U_AIR_CLEAN = 76;
                                ConstAllAirDara.C_CLEAN = 39;
                                break;
                            default:
                                ConstAllAirDara.U_AIR_BACK_TEMP = 27;
                                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 28;
                                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 2;
                                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 3;
                                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 4;
                                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 5;
                                ConstAllAirDara.U_AIR_FLOWER_BLOW = 33;
                                ConstAllAirDara.C_AIR_FLOWER_BLOW = 40;
                                break;
                        }
                        ConstAllAirDara.C_AIR_SWING = 60;
                        ConstAllAirDara.C_AIR_FRONT_HOT = 38;
                        ConstAllAirDara.C_REAR_CTRL = 57;
                        ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                        ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                        ConstAllAirDara.U_AIR_BACK_POWER = 42;
                        ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                        ConstAllAirDara.U_AIR_BACK_BLOW_UP = 18;
                        ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 19;
                        ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 20;
                        ConstAllAirDara.U_AIR_REAR_MANUAL = 86;
                        ConstAllAirDara.C_REAR_AUTO = 52;
                        ConstAllAirDara.C_REAR_WIND_DOWN = 48;
                        ConstAllAirDara.C_REAR_WIND_UP = 49;
                        ConstAllAirDara.C_REAR_OFF = 61;
                        ConstAllAirDara.C_REAR_MODE = 36;
                        ConstAllAirDara.C_AIR_REAR_MANUAL = 59;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 18;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_FLOWER_BLOW = 40;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_WC2_GUOCHAN_15 /* 983435 */:
            case FinalCanbus.CAR_WC2_AiRuiZ_GX /* 1835403 */:
            case FinalCanbus.CAR_WC2_GUOCHAN_Ruihu5X /* 2097547 */:
            case FinalCanbus.CAR_WC2_GUOCHAN_21Ruihu8_H /* 2490763 */:
            case FinalCanbus.CAR_WC2_Qirui_Ruihu8 /* 2621835 */:
            case FinalCanbus.CAR_WC2_Qirui_Ruihu3X_23 /* 2752907 */:
            case FinalCanbus.CAR_WC2_Qirui_AiRuiZeE_23 /* 2818443 */:
            case FinalCanbus.CAR_WC2_Qirui_AiRuiZ_EX /* 2883979 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_FRONT_HOT = 17;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                if (DataCanbus.DATA[1000] == 2818443) {
                    ConstAllAirDara.C_AIR_MODE_CHANGER = 21;
                } else {
                    ConstAllAirDara.C_AIR_MODE_BODY = 25;
                    ConstAllAirDara.C_AIR_MODE_FOOT = 28;
                    ConstAllAirDara.C_AIR_MODE_BODYFOOT = 26;
                    ConstAllAirDara.C_AIR_MODE_UPFOOT = 27;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_DUAL = 3;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_AC_MAX = 30;
                ConstAllAirDara.C_AIR_FRONT_HOT = 44;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_446_WY_HCX_BBA_Screen /* 983486 */:
            case FinalCanbus.CAR_446_WY_HCX_BYD_TANG_Screen /* 1049022 */:
            case FinalCanbus.CAR_446_WY_HCX_BYD_QIN_Screen /* 1114558 */:
            case FinalCanbus.CAR_446_WY_HCX_WAY_VV7 /* 1442238 */:
            case FinalCanbus.CAR_446_WY_HCX_WAY_P8 /* 1507774 */:
            case FinalCanbus.CAR_446_WY_HCX_WAY_VV5 /* 1573310 */:
            case FinalCanbus.CAR_446_WY_HCX_WAY_VV6 /* 1638846 */:
            case FinalCanbus.CAR_444_WY_HCX_Chuanqi_21GS8_Screen /* 7012796 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_SYNC = 14;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_446_WY_HCX_BYD_TANG_Screen /* 1049022 */:
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.U_AIR_BLOWTOP = 72;
                        ConstAllAirDara.C_AIR_BLOWTOP = 30;
                        break;
                    case FinalCanbus.CAR_446_WY_HCX_WAY_P8 /* 1507774 */:
                    case FinalCanbus.CAR_446_WY_HCX_WAY_VV5 /* 1573310 */:
                    case FinalCanbus.CAR_446_WY_HCX_WAY_VV6 /* 1638846 */:
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 166;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 167;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 164;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 165;
                        break;
                }
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 6;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 7;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 8;
                ConstAllAirDara.C_AIR_WIND_ADD = 9;
                ConstAllAirDara.C_AIR_WIND_SUB = 11;
                ConstAllAirDara.C_AIR_AUTO = 14;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 15;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 17;
                ConstAllAirDara.C_AIR_CYCLE = 19;
                ConstAllAirDara.C_AIR_SYNC = 28;
                ConstAllAirDara.C_AIR_MODE_BODY = 22;
                ConstAllAirDara.C_AIR_MODE_FOOT = 21;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 24;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 26;
                ConstAllAirDara.C_CONTRAL = 11;
                break;
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD /* 8913349 */:
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD_H /* 8978885 */:
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH /* 10420679 */:
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH_H /* 10486215 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300 /* 15008198 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER /* 15139270 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER_H /* 15532486 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300_H /* 15598022 */:
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_FRONT_HOT = 17;
                ConstAllAirDara.U_AIR_CLEAN = 76;
                ConstAllAirDara.U_AIR_FLOWER_BLOW = 33;
                ConstAllAirDara.U_AIR_SWING = 35;
                ConstAllAirDara.U_AIR_REAR_CTRL = 38;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_CYCLE_AUTO = 54;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 41;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                ConstAllAirDara.U_AIR_REAR_MANUAL = 86;
                ConstAllAirDara.U_AIR_BACK_BLOW_UP = 18;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 19;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 20;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
                    case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
                        ConstAllAirDara.U_AIR_HAVE_REAR = 2;
                        break;
                    case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD /* 8913349 */:
                    case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD_H /* 8978885 */:
                        ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
                        ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                        ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                        ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT = 37;
                        break;
                    case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300 /* 15008198 */:
                    case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER /* 15139270 */:
                    case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER_H /* 15532486 */:
                    case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300_H /* 15598022 */:
                        ConstAllAirDara.U_AIR_HAVE_REAR = 255;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 18;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_FRONT_HOT = 38;
                ConstAllAirDara.C_CLEAN = 39;
                ConstAllAirDara.C_AIR_FLOWER_BLOW = 40;
                ConstAllAirDara.C_AIR_SWING = 60;
                ConstAllAirDara.C_REAR_CTRL = 57;
                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 41;
                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 42;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 50;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 51;
                ConstAllAirDara.C_REAR_WIND_DOWN = 48;
                ConstAllAirDara.C_REAR_WIND_UP = 49;
                ConstAllAirDara.C_REAR_AUTO = 52;
                ConstAllAirDara.C_AIR_REAR_MANUAL = 59;
                ConstAllAirDara.C_REAR_OFF = 61;
                break;
            case FinalCanbus.CAR_OD_RZC_BenTeng_B90 /* 1114525 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 18;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_MODE_ADD = 8;
                ConstAllAirDara.C_AIR_MODE_SUB = 7;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_RZC_17_18KeleiAo /* 1180050 */:
            case FinalCanbus.CAR_RZC_17_18KeleiAo_M /* 1311122 */:
            case FinalCanbus.CAR_RZC_17_18KeleiAo_H /* 1376658 */:
            case FinalCanbus.CAR_RZC_MEGANE_Turkey_L /* 1638802 */:
            case FinalCanbus.CAR_RZC_MEGANE_Turkey_M /* 1704338 */:
            case FinalCanbus.CAR_RZC_MEGANE_Turkey_H /* 1769874 */:
            case FinalCanbus.CAR_RZC_KADJAR_Turkey /* 1966482 */:
            case FinalCanbus.CAR_RZC_CLIO5_Turkey /* 2032018 */:
            case FinalCanbus.CAR_RZC_CLIO5_Turkey_M /* 2097554 */:
            case FinalCanbus.CAR_RZC_CLIO5_Turkey_H /* 2163090 */:
            case FinalCanbus.CAR_RZC_MEGANE_Turkey_L_AUTO /* 2228626 */:
            case FinalCanbus.CAR_RZC_Turkey_22KOLEOS_L /* 3604882 */:
            case FinalCanbus.CAR_RZC_Turkey_22KOLEOS_M /* 3670418 */:
            case FinalCanbus.CAR_RZC_Turkey_22KOLEOS_H /* 3735954 */:
            case FinalCanbus.CAR_RZC_Turkey_16KADJAR_L /* 3801490 */:
            case FinalCanbus.CAR_RZC_Turkey_16KADJAR_M /* 3867026 */:
            case FinalCanbus.CAR_RZC_Turkey_16KADJAR_H /* 3932562 */:
            case FinalCanbus.CAR_RZC_Turkey_22CAPTUR_L /* 3998098 */:
            case FinalCanbus.CAR_RZC_Turkey_22CAPTUR_M /* 4063634 */:
            case FinalCanbus.CAR_RZC_Turkey_22CAPTUR_H /* 4129170 */:
            case FinalCanbus.CAR_RZC_Turkey_22TRAFIC_L /* 4194706 */:
            case FinalCanbus.CAR_RZC_Turkey_22TRAFIC_M /* 4260242 */:
            case FinalCanbus.CAR_RZC_Turkey_22TRAFIC_H /* 4325778 */:
            case FinalCanbus.CAR_RZC_Turkey_22TALIANT_L /* 4391314 */:
            case FinalCanbus.CAR_RZC_Turkey_22TALIANT_M /* 4456850 */:
            case FinalCanbus.CAR_RZC_Turkey_22TALIANT_H /* 4522386 */:
            case FinalCanbus.CAR_RZC_Turkey_22DACIA_JOGGER_L /* 4587922 */:
            case FinalCanbus.CAR_RZC_Turkey_22DACIA_JOGGER_M /* 4653458 */:
            case FinalCanbus.CAR_RZC_Turkey_22DACIA_JOGGER_H /* 4718994 */:
            case FinalCanbus.CAR_RZC_Turkey_22DACIA_SANDERO_L /* 4784530 */:
            case FinalCanbus.CAR_RZC_Turkey_22DACIA_SANDERO_M /* 4850066 */:
            case FinalCanbus.CAR_RZC_Turkey_22DACIA_SANDERO_H /* 4915602 */:
            case FinalCanbus.CAR_RZC_Turkey_23MEGANE4_L /* 4981138 */:
            case FinalCanbus.CAR_RZC_Turkey_23MEGANE4_M /* 5046674 */:
            case FinalCanbus.CAR_RZC_Turkey_23MEGANE4_H /* 5112210 */:
            case FinalCanbus.CAR_RZC_Turkey_22TALISMAN_L /* 5177746 */:
            case FinalCanbus.CAR_RZC_Turkey_22TALISMAN_M /* 5243282 */:
            case FinalCanbus.CAR_RZC_Turkey_22TALISMAN_H /* 5308818 */:
            case FinalCanbus.CAR_RZC_Turkey_22DACIA_DUSTER_L /* 5374354 */:
            case FinalCanbus.CAR_RZC_Turkey_22DACIA_DUSTER_M /* 5439890 */:
            case FinalCanbus.CAR_RZC_Turkey_22DACIA_DUSTER_H /* 5505426 */:
            case FinalCanbus.CAR_RZC_Turkey_22EXPRESS_L /* 5570962 */:
            case FinalCanbus.CAR_RZC_Turkey_22EXPRESS_M /* 5636498 */:
            case FinalCanbus.CAR_RZC_Turkey_22EXPRESS_H /* 5702034 */:
            case FinalCanbus.CAR_RZC_Russian_20ARKANA_L /* 5767570 */:
            case FinalCanbus.CAR_RZC_Russian_20ARKANA_M /* 5833106 */:
            case FinalCanbus.CAR_RZC_Russian_20ARKANA_H /* 5898642 */:
            case FinalCanbus.CAR_RZC_Turkey_22KADJAR_M /* 5964178 */:
            case FinalCanbus.CAR_RZC_CLIO5_Turkey_L_ATUO /* 6029714 */:
            case FinalCanbus.CAR_RZC_17LIENUO_M_NoAQS /* 6095250 */:
            case FinalCanbus.CAR_RZC_Renault_SM6_18 /* 6226322 */:
            case FinalCanbus.CAR_RZC_Renault_SCENIC_16 /* 6291858 */:
            case FinalCanbus.CAR_RZC_Renault_SM6_18_M /* 6357394 */:
            case FinalCanbus.CAR_RZC_Renault_SCENIC_16_M /* 6422930 */:
            case FinalCanbus.CAR_RZC_Renault_SM6_18_H /* 6488466 */:
            case FinalCanbus.CAR_RZC_Renault_SCENIC_16_H /* 6554002 */:
            case FinalCanbus.CAR_RZC_Renault_Dokker_18 /* 6750610 */:
            case FinalCanbus.CAR_RZC_Renault_Dokker_18_H /* 6816146 */:
            case FinalCanbus.CAR_RZC_17LIENUO_L_AUTO /* 6881682 */:
            case FinalCanbus.CAR_RZC_17LIENUO_M_NoAQS_2 /* 6947218 */:
            case FinalCanbus.CAR_RZC_Renault_QM6_18_L /* 7012754 */:
            case FinalCanbus.CAR_RZC_Renault_QM6_18_M /* 7078290 */:
            case FinalCanbus.CAR_RZC_Renault_QM6_18_H /* 7143826 */:
            case FinalCanbus.CAR_RZC_Renault_ZOE_22_L /* 7209362 */:
            case FinalCanbus.CAR_RZC_Renault_ZOE_22_M /* 7274898 */:
            case FinalCanbus.CAR_RZC_Renault_ZOE_22_H /* 7340434 */:
            case FinalCanbus.CAR_RZC_Renault_DUSTER_ETECH_24_L /* 7405970 */:
            case FinalCanbus.CAR_RZC_Renault_DUSTER_ETECH_24_M /* 7471506 */:
            case FinalCanbus.CAR_RZC_Renault_DUSTER_ETECH_24_H /* 7537042 */:
            case FinalCanbus.CAR_RZC_Renault_Kardian_24_L /* 7602578 */:
            case FinalCanbus.CAR_RZC_Renault_Kardian_24_M /* 7668114 */:
            case FinalCanbus.CAR_RZC_Renault_Kardian_24_H /* 7733650 */:
            case FinalCanbus.CAR_RZC_Renault_XM3_24_L /* 7799186 */:
            case FinalCanbus.CAR_RZC_Renault_XM3_24_M /* 7864722 */:
            case FinalCanbus.CAR_RZC_Renault_XM3_24_H /* 7930258 */:
            case FinalCanbus.CAR_RZC_Renault_ARKANAEV_25_L /* 7995794 */:
            case FinalCanbus.CAR_RZC_Renault_ARKANAEV_25_M /* 8061330 */:
            case FinalCanbus.CAR_RZC_Renault_ARKANAEV_25_H /* 8126866 */:
            case FinalCanbus.CAR_RZC_Nissan_Townstar_24_L /* 8192402 */:
            case FinalCanbus.CAR_RZC_Nissan_Townstar_24_M /* 8257938 */:
            case FinalCanbus.CAR_RZC_Nissan_Townstar_24_H /* 8323474 */:
            case FinalCanbus.CAR_RZC_Renault_SM6_18_LAuto /* 8389010 */:
            case FinalCanbus.CAR_RZC_Renault_SM6_18_M_NoAQS /* 8454546 */:
            case FinalCanbus.CAR_RZC_Renault_SM6_18_M_NoAQS2 /* 8520082 */:
            case FinalCanbus.CAR_RZC_Renault_QM6_18_LAuto /* 8585618 */:
            case FinalCanbus.CAR_RZC_Renault_QM6_18_M_NoAQS /* 8651154 */:
            case FinalCanbus.CAR_RZC_Renault_QM6_18_M_NoAQS2 /* 8716690 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 6;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 23;
                ConstAllAirDara.C_AIR_CYCLE = 21;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_17_18KeleiAo_M /* 1311122 */:
                    case FinalCanbus.CAR_RZC_17_18KeleiAo_H /* 1376658 */:
                    case FinalCanbus.CAR_RZC_MEGANE_Turkey_M /* 1704338 */:
                    case FinalCanbus.CAR_RZC_MEGANE_Turkey_H /* 1769874 */:
                    case FinalCanbus.CAR_RZC_CLIO5_Turkey_M /* 2097554 */:
                    case FinalCanbus.CAR_RZC_CLIO5_Turkey_H /* 2163090 */:
                    case FinalCanbus.CAR_RZC_MEGANE_Turkey_L_AUTO /* 2228626 */:
                    case FinalCanbus.CAR_RZC_Turkey_22KOLEOS_M /* 3670418 */:
                    case FinalCanbus.CAR_RZC_Turkey_22KOLEOS_H /* 3735954 */:
                    case FinalCanbus.CAR_RZC_Turkey_22CAPTUR_M /* 4063634 */:
                    case FinalCanbus.CAR_RZC_Turkey_22CAPTUR_H /* 4129170 */:
                    case FinalCanbus.CAR_RZC_Turkey_22TRAFIC_M /* 4260242 */:
                    case FinalCanbus.CAR_RZC_Turkey_22TRAFIC_H /* 4325778 */:
                    case FinalCanbus.CAR_RZC_Turkey_22TALIANT_M /* 4456850 */:
                    case FinalCanbus.CAR_RZC_Turkey_22TALIANT_H /* 4522386 */:
                    case FinalCanbus.CAR_RZC_Turkey_22DACIA_JOGGER_M /* 4653458 */:
                    case FinalCanbus.CAR_RZC_Turkey_22DACIA_JOGGER_H /* 4718994 */:
                    case FinalCanbus.CAR_RZC_Turkey_22DACIA_SANDERO_M /* 4850066 */:
                    case FinalCanbus.CAR_RZC_Turkey_22DACIA_SANDERO_H /* 4915602 */:
                    case FinalCanbus.CAR_RZC_Turkey_23MEGANE4_M /* 5046674 */:
                    case FinalCanbus.CAR_RZC_Turkey_23MEGANE4_H /* 5112210 */:
                    case FinalCanbus.CAR_RZC_Turkey_22TALISMAN_M /* 5243282 */:
                    case FinalCanbus.CAR_RZC_Turkey_22TALISMAN_H /* 5308818 */:
                    case FinalCanbus.CAR_RZC_Turkey_22DACIA_DUSTER_M /* 5439890 */:
                    case FinalCanbus.CAR_RZC_Turkey_22DACIA_DUSTER_H /* 5505426 */:
                    case FinalCanbus.CAR_RZC_Turkey_22EXPRESS_M /* 5636498 */:
                    case FinalCanbus.CAR_RZC_Turkey_22EXPRESS_H /* 5702034 */:
                    case FinalCanbus.CAR_RZC_Russian_20ARKANA_M /* 5833106 */:
                    case FinalCanbus.CAR_RZC_Russian_20ARKANA_H /* 5898642 */:
                    case FinalCanbus.CAR_RZC_CLIO5_Turkey_L_ATUO /* 6029714 */:
                    case FinalCanbus.CAR_RZC_17LIENUO_M_NoAQS /* 6095250 */:
                    case FinalCanbus.CAR_RZC_Renault_SM6_18 /* 6226322 */:
                    case FinalCanbus.CAR_RZC_Renault_SM6_18_M /* 6357394 */:
                    case FinalCanbus.CAR_RZC_Renault_SCENIC_16_M /* 6422930 */:
                    case FinalCanbus.CAR_RZC_Renault_SM6_18_H /* 6488466 */:
                    case FinalCanbus.CAR_RZC_Renault_SCENIC_16_H /* 6554002 */:
                    case FinalCanbus.CAR_RZC_Renault_Dokker_18_H /* 6816146 */:
                    case FinalCanbus.CAR_RZC_17LIENUO_L_AUTO /* 6881682 */:
                    case FinalCanbus.CAR_RZC_17LIENUO_M_NoAQS_2 /* 6947218 */:
                    case FinalCanbus.CAR_RZC_Renault_QM6_18_M /* 7078290 */:
                    case FinalCanbus.CAR_RZC_Renault_QM6_18_H /* 7143826 */:
                    case FinalCanbus.CAR_RZC_Renault_ZOE_22_M /* 7274898 */:
                    case FinalCanbus.CAR_RZC_Renault_ZOE_22_H /* 7340434 */:
                    case FinalCanbus.CAR_RZC_Renault_DUSTER_ETECH_24_L /* 7405970 */:
                    case FinalCanbus.CAR_RZC_Renault_DUSTER_ETECH_24_M /* 7471506 */:
                    case FinalCanbus.CAR_RZC_Renault_DUSTER_ETECH_24_H /* 7537042 */:
                    case FinalCanbus.CAR_RZC_Renault_Kardian_24_M /* 7668114 */:
                    case FinalCanbus.CAR_RZC_Renault_Kardian_24_H /* 7733650 */:
                    case FinalCanbus.CAR_RZC_Renault_XM3_24_M /* 7864722 */:
                    case FinalCanbus.CAR_RZC_Renault_XM3_24_H /* 7930258 */:
                    case FinalCanbus.CAR_RZC_Renault_ARKANAEV_25_M /* 8061330 */:
                    case FinalCanbus.CAR_RZC_Renault_ARKANAEV_25_H /* 8126866 */:
                    case FinalCanbus.CAR_RZC_Nissan_Townstar_24_M /* 8257938 */:
                    case FinalCanbus.CAR_RZC_Nissan_Townstar_24_H /* 8323474 */:
                    case FinalCanbus.CAR_RZC_Renault_SM6_18_LAuto /* 8389010 */:
                    case FinalCanbus.CAR_RZC_Renault_SM6_18_M_NoAQS /* 8454546 */:
                    case FinalCanbus.CAR_RZC_Renault_SM6_18_M_NoAQS2 /* 8520082 */:
                    case FinalCanbus.CAR_RZC_Renault_QM6_18_LAuto /* 8585618 */:
                    case FinalCanbus.CAR_RZC_Renault_QM6_18_M_NoAQS /* 8651154 */:
                    case FinalCanbus.CAR_RZC_Renault_QM6_18_M_NoAQS2 /* 8716690 */:
                        ConstAllAirDara.U_AIR_DUAL = 14;
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_SOFT = 71;
                        ConstAllAirDara.U_AIR_FAST = 70;
                        ConstAllAirDara.U_AIR_NORMAL = 80;
                        ConstAllAirDara.C_SOFT = 25;
                        ConstAllAirDara.C_FAST = 26;
                        ConstAllAirDara.C_NORMAL = 27;
                        ConstAllAirDara.C_AIR_MODE_UP = 24;
                        ConstAllAirDara.C_AIR_MODE_BODY = 7;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 9;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                        ConstAllAirDara.C_AIR_AUTO = 2;
                        ConstAllAirDara.C_AIR_DUAL = 3;
                        break;
                    case FinalCanbus.CAR_RZC_KADJAR_Turkey /* 1966482 */:
                    case FinalCanbus.CAR_RZC_Turkey_16KADJAR_M /* 3867026 */:
                    case FinalCanbus.CAR_RZC_Turkey_16KADJAR_H /* 3932562 */:
                    case FinalCanbus.CAR_RZC_Turkey_22KADJAR_M /* 5964178 */:
                        ConstAllAirDara.U_AIR_DUAL = 14;
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_SOFT = 71;
                        ConstAllAirDara.U_AIR_FAST = 70;
                        ConstAllAirDara.U_AIR_NORMAL = 80;
                        ConstAllAirDara.C_SOFT = 25;
                        ConstAllAirDara.C_FAST = 26;
                        ConstAllAirDara.C_NORMAL = 27;
                        ConstAllAirDara.C_AIR_MODE_ADD = 28;
                        ConstAllAirDara.C_AIR_MODE_SUB = 29;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                        ConstAllAirDara.C_AIR_AUTO = 2;
                        ConstAllAirDara.C_AIR_DUAL = 3;
                        break;
                    default:
                        ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 14;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 13;
                        ConstAllAirDara.C_AIR_MODE_ADD = 15;
                        ConstAllAirDara.C_AIR_MODE_SUB = 16;
                        break;
                }
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_439_DJ_LEXUS_ES /* 1245623 */:
            case FinalCanbus.CAR_439_DJ_LEXUS_ES_H /* 3801527 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_AUTO = 1;
                ConstAllAirDara.C_AIR_DUAL = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 4;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_AC = 8;
                ConstAllAirDara.C_AIR_POWER = 10;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 13;
                ConstAllAirDara.C_AIR_MODE_ADD = 16;
                ConstAllAirDara.C_AIR_MODE_SUB = 17;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_OD_RZC_ShangQiDaTong22G50 /* 1310985 */:
            case FinalCanbus.CAR_OD_RZC_ShangQiDaTong19G50 /* 1442057 */:
            case FinalCanbus.CAR_OD_RZC_DaTong_25Dana_V1 /* 1638665 */:
            case FinalCanbus.CAR_OD_RZC_DaTong_25Dana_M1 /* 1704201 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                if (DataCanbus.DATA[1000] == 1704201) {
                    ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                    ConstAllAirDara.U_AIR_BACK_TEMP = 27;
                    ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 27;
                    ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                    ConstAllAirDara.U_AIR_BACK_POWER = 42;
                    ConstAllAirDara.U_AIR_REAR_AC = 78;
                    ConstAllAirDara.U_AIR_REAR_MANUAL = 86;
                    ConstAllAirDara.U_AIR_BACK_BLOW_UP = 18;
                    ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 19;
                    ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 20;
                    ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 2;
                    ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 3;
                    ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 2;
                    ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 3;
                    ConstAllAirDara.C_REAR_WIND_DOWN = 36;
                    ConstAllAirDara.C_REAR_WIND_UP = 35;
                    ConstAllAirDara.C_REAR_OFF = 32;
                    ConstAllAirDara.C_REAR_MODE = 7;
                    ConstAllAirDara.C_REAR_MODE_RIGHT = 8;
                    ConstAllAirDara.C_AIR_REAR_MANUAL = 34;
                    ConstAllAirDara.C_REAR_AC = 33;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 2;
                ConstAllAirDara.C_AIR_MODE_ADD = 7;
                ConstAllAirDara.C_AIR_MODE_SUB = 8;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 18;
                ConstAllAirDara.C_AIR_AUTO = 24;
                ConstAllAirDara.C_CONTRAL = 4;
                break;
            case FinalCanbus.CAR_WC2_QiChen_T90 /* 1376651 */:
            case FinalCanbus.CAR_WC2_QiChen_D60 /* 1507723 */:
            case FinalCanbus.CAR_WC2_QiChen_D50EV /* 2425227 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 21;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_455_LZ_GMC_Sierra_19_RScreen /* 1507783 */:
            case FinalCanbus.CAR_455_LZ_Chevrolet_Silverado_19_RScreen /* 1573319 */:
            case FinalCanbus.CAR_455_LZ_GM_Cadillac_CT5_Screen /* 5439943 */:
            case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_Screen /* 9437639 */:
            case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_Screen /* 9503175 */:
            case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_RScreen /* 9568711 */:
            case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_RScreen /* 9634247 */:
            case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
            case FinalCanbus.CAR_454_LZ_Chevrolet_Silverado_19_Screen /* 11993542 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_4Screen /* 15729095 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_4Screen /* 15794631 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_8Screen /* 15860167 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_8Screen /* 15925703 */:
                if (DataCanbus.DATA[1000] == 5439943) {
                    ConstAllAirDara.U_AIR_HAVE_REAR = 0;
                } else {
                    ConstAllAirDara.U_AIR_HAVE_REAR = 0;
                }
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_4Screen /* 15729095 */:
                    case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_8Screen /* 15860167 */:
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 17;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 18;
                        ConstAllAirDara.C_AIR_MODE_BODY = 14;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 15;
                        ConstAllAirDara.U_AIR_HAVE_REAR = 0;
                        break;
                    case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_4Screen /* 15794631 */:
                    case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_8Screen /* 15925703 */:
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 17;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 18;
                        ConstAllAirDara.C_AIR_MODE_BODY = 14;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 15;
                        ConstAllAirDara.U_AIR_SYNC = 62;
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.C_AIR_SYNC = 8;
                        ConstAllAirDara.C_AIR_AUTO = 11;
                        ConstAllAirDara.U_AIR_HAVE_REAR = 0;
                        break;
                    default:
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 30;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 30;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 33;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 31;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 34;
                        ConstAllAirDara.C_AIR_MODE_UP = 16;
                        ConstAllAirDara.C_AIR_MODE_BODY = 14;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 15;
                        ConstAllAirDara.U_AIR_SYNC = 62;
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.C_AIR_SYNC = 8;
                        ConstAllAirDara.C_AIR_AUTO = 11;
                        ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                        ConstAllAirDara.U_AIR_REAR_SYNC = 86;
                        ConstAllAirDara.C_REAR_AUTO = 28;
                        ConstAllAirDara.C_REAR_SYNC = 27;
                        break;
                }
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                ConstAllAirDara.U_AIR_BACK_BLOW_UP = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 6;
                ConstAllAirDara.C_AIR_POWER = 7;
                ConstAllAirDara.C_AIR_AC = 9;
                ConstAllAirDara.C_AIR_CYCLE = 10;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 12;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 13;
                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 20;
                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 19;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 20;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 19;
                ConstAllAirDara.C_REAR_WIND_DOWN = 22;
                ConstAllAirDara.C_REAR_WIND_UP = 21;
                ConstAllAirDara.C_REAR_MODE_FOOT = 24;
                ConstAllAirDara.C_REAR_MODE_BODY = 23;
                ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 25;
                ConstAllAirDara.C_REAR_LOCK = 29;
                ConstAllAirDara.C_REAR_OFF = 26;
                break;
            case FinalCanbus.CAR_CZH_OD_NISSAN_22Teana_Top /* 1572944 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_22Teana_Top_360View /* 1638480 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_16Trail /* 1704016 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_16Trail_H /* 1769552 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_16Xiaoke /* 1835088 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_16Xiaoke_H /* 1900624 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Xima_L /* 1966160 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Xima_H /* 2031696 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Loulan_L /* 2097232 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Loulan_H /* 2162768 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Tianlai_L /* 2228304 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Tianlai_H /* 2293840 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Xuanyi_L /* 2359376 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Xuanyi_H /* 2424912 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Lanniao_L /* 2490448 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Lannia_H /* 2555984 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Qida_L /* 2621520 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Qida_H /* 2687056 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Jinke_L /* 2752592 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Jinke_H /* 2818128 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_STEER = 66;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 5;
                ConstAllAirDara.C_AIR_AC = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 8;
                ConstAllAirDara.C_AIR_WIND_ADD = 9;
                ConstAllAirDara.C_AIR_WIND_SUB = 10;
                ConstAllAirDara.C_AIR_MODE_BODY = 11;
                ConstAllAirDara.C_AIR_MODE_FOOT = 12;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 13;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 14;
                ConstAllAirDara.C_AIR_SYNC = 15;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 16;
                ConstAllAirDara.C_AIR_AC_MAX = 17;
                ConstAllAirDara.C_AIR_AUTO = 18;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 19;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 20;
                ConstAllAirDara.C_AIR_LEFT_COLD = 21;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 22;
                ConstAllAirDara.C_AIR_STEER = 23;
                ConstAllAirDara.C_CONTRAL = 5;
                break;
            case FinalCanbus.CAR_452_XinCheng_Infiniti_ESQ /* 1573316 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_06FX /* 1638852 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_08FX /* 1704388 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_G /* 1769924 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_14QX50 /* 1835460 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_15QX60 /* 1900996 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_14QX70 /* 1966532 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_12FX /* 3998148 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_15Q50L /* 4063684 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_12JX35 /* 4129220 */:
            case FinalCanbus.CAR_455_XinCheng_Infiniti_18QX80 /* 6816199 */:
            case FinalCanbus.CAR_455_XinCheng_Infiniti_17QX30_Keep /* 6881735 */:
            case FinalCanbus.CAR_455_XinCheng_Infiniti_17QX30 /* 6947271 */:
            case FinalCanbus.CAR_455_XinCheng_Infiniti_17Q50 /* 7012807 */:
            case FinalCanbus.CAR_455_XinCheng_Infiniti_22QX50 /* 10355143 */:
            case FinalCanbus.CAR_455_XinCheng_Infiniti_15QX56 /* 11731399 */:
            case FinalCanbus.CAR_455_XinCheng_Nissan_11Loulan /* 11796935 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_CYCLE_AUTO = 36;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.C_AIR_AC_MAX = 24;
                ConstAllAirDara.C_AIR_DUAL = 16;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_452_XinCheng_Infiniti_ESQ /* 1573316 */:
                        ConstAllAirDara.C_AIR_MODE_BODY = 8;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 9;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 10;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 11;
                        ConstAllAirDara.U_AIR_REAR_CTRL = 42;
                        ConstAllAirDara.C_REAR_CTRL = 56;
                        break;
                    case FinalCanbus.CAR_452_XinCheng_Infiniti_14QX50 /* 1835460 */:
                    case FinalCanbus.CAR_452_XinCheng_Infiniti_15Q50L /* 4063684 */:
                    case FinalCanbus.CAR_455_XinCheng_Infiniti_15QX56 /* 11731399 */:
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 12;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 14;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                        ConstAllAirDara.U_AIR_REAR_CTRL = 42;
                        ConstAllAirDara.C_REAR_CTRL = 56;
                        break;
                    case FinalCanbus.CAR_452_XinCheng_Infiniti_15QX60 /* 1900996 */:
                        ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                        ConstAllAirDara.U_AIR_BACK_POWER = 42;
                        ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                        ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                        ConstAllAirDara.U_AIR_BACK_BLOW_UP = 46;
                        ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                        ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                        ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                        ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 50;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 51;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 50;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 51;
                        ConstAllAirDara.C_REAR_OFF = 56;
                        ConstAllAirDara.C_REAR_AUTO = 52;
                        ConstAllAirDara.C_REAR_MODE = 57;
                        ConstAllAirDara.C_REAR_WIND_DOWN = 48;
                        ConstAllAirDara.C_REAR_WIND_UP = 49;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                        break;
                    case FinalCanbus.CAR_452_XinCheng_Infiniti_14QX70 /* 1966532 */:
                        ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                        ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                        ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
                        ConstAllAirDara.U_AIR_CLEAN = 55;
                        ConstAllAirDara.U_AIR_BLOWTOP = 72;
                        ConstAllAirDara.U_AIR_REAR_CTRL = 42;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                        ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT = 66;
                        ConstAllAirDara.C_CLEAN = 67;
                        ConstAllAirDara.C_REAR_CTRL = 56;
                        ConstAllAirDara.C_AIR_BLOWTOP = 22;
                        break;
                    case FinalCanbus.CAR_455_XinCheng_Infiniti_18QX80 /* 6816199 */:
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                        ConstAllAirDara.U_AIR_REAR_CTRL = 42;
                        ConstAllAirDara.U_AIR_BLOWTOP = 72;
                        ConstAllAirDara.C_REAR_CTRL = 56;
                        ConstAllAirDara.C_AIR_BLOWTOP = 22;
                        break;
                    case FinalCanbus.CAR_455_XinCheng_Infiniti_22QX50 /* 10355143 */:
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 12;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                        ConstAllAirDara.U_AIR_DUAL = 255;
                        ConstAllAirDara.U_AIR_AC_MAX = 255;
                        ConstAllAirDara.C_AIR_AC_MAX = 255;
                        ConstAllAirDara.C_AIR_DUAL = 255;
                        break;
                    default:
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                        ConstAllAirDara.U_AIR_REAR_CTRL = 42;
                        ConstAllAirDara.C_REAR_CTRL = 56;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 18;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_CONTRAL = 3;
                break;
            case FinalCanbus.CAR_439_Oudi_Haval_H3 /* 1704375 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_AIR_POWER = 16;
                ConstAllAirDara.C_AIR_AC = 17;
                ConstAllAirDara.C_AIR_AUTO = 18;
                ConstAllAirDara.C_AIR_CYCLE = 19;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 21;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 22;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 24;
                ConstAllAirDara.C_AIR_WIND_ADD = 28;
                ConstAllAirDara.C_AIR_WIND_SUB = 29;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 30;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 31;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 30;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 31;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_455_TD_INFINIT_ESQ /* 1704391 */:
            case FinalCanbus.CAR_455_TD_INFINIT_G /* 1769927 */:
            case FinalCanbus.CAR_455_TD_INFINIT_QX50 /* 1835463 */:
            case FinalCanbus.CAR_455_TD_INFINIT_06FX /* 1900999 */:
            case FinalCanbus.CAR_455_TD_INFINIT_08FX /* 1966535 */:
            case FinalCanbus.CAR_455_TD_INFINIT_14QX70 /* 2032071 */:
            case FinalCanbus.CAR_455_TD_INFINIT_12FX /* 2097607 */:
            case FinalCanbus.CAR_455_Tangdu_Nissan_10PATROL_L /* 4260295 */:
            case FinalCanbus.CAR_455_Tangdu_Nissan_22PATROL_Armada /* 10224071 */:
            case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_L /* 13763014 */:
            case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_H /* 13828550 */:
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_455_Tangdu_Nissan_10PATROL_L /* 4260295 */:
                    case FinalCanbus.CAR_455_Tangdu_Nissan_22PATROL_Armada /* 10224071 */:
                    case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_L /* 13763014 */:
                    case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_H /* 13828550 */:
                        ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                        ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                        ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                        ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                        ConstAllAirDara.U_AIR_BACK_POWER = 38;
                        ConstAllAirDara.U_AIR_BACK_BLOW_UP = 18;
                        ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 19;
                        ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 20;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 50;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 51;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 50;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 51;
                        ConstAllAirDara.C_REAR_WIND_DOWN = 48;
                        ConstAllAirDara.C_REAR_WIND_UP = 49;
                        ConstAllAirDara.C_REAR_OFF = 40;
                        ConstAllAirDara.C_REAR_MODE_FOOT = 55;
                        ConstAllAirDara.C_REAR_MODE_BODY = 53;
                        ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 54;
                        break;
                    default:
                        ConstAllAirDara.U_AIR_HAVE_REAR = 0;
                        break;
                }
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_SYNC = 14;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_BLOWTOP = 33;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_SYNC = 16;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 18;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_AIR_BLOWTOP = 41;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_452_XinCheng_Infiniti_13Q70L /* 2032068 */:
            case FinalCanbus.CAR_452_XinCheng_Nissan_Tule_H /* 5112260 */:
            case FinalCanbus.CAR_452_XinCheng_Nissan_Tule_Top /* 7078343 */:
            case FinalCanbus.CAR_455_XinCheng_Nissan_20Tule_H /* 11665863 */:
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_452_XinCheng_Nissan_Tule_Top /* 7078343 */:
                    case FinalCanbus.CAR_455_XinCheng_Nissan_20Tule_H /* 11665863 */:
                        ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                        ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                        ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                        ConstAllAirDara.U_AIR_BACK_BLOW_UP = 46;
                        ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                        ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                        ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                        ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                        ConstAllAirDara.U_AIR_BACK_POWER = 42;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 50;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 51;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 50;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 51;
                        ConstAllAirDara.C_REAR_AUTO = 52;
                        ConstAllAirDara.C_REAR_OFF = 56;
                        ConstAllAirDara.C_REAR_MODE = 57;
                        ConstAllAirDara.C_REAR_WIND_DOWN = 48;
                        ConstAllAirDara.C_REAR_WIND_UP = 49;
                        break;
                }
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_BLOWTOP = 72;
                ConstAllAirDara.U_AIR_CLEAN = 55;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
                ConstAllAirDara.C_CONTRAL = 3;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 18;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_CYCLE = 34;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_CLEAN = 67;
                ConstAllAirDara.C_AIR_BLOWTOP = 22;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT = 66;
                break;
            case FinalCanbus.CAR_446_Xiaolin_WY_LEXUS_Screen /* 2097598 */:
            case FinalCanbus.CAR_446_Xiaolin_WY_LEXUS_Screen_H /* 2163134 */:
            case FinalCanbus.CAR_444_WY_LEXUS_Screen /* 6095292 */:
            case FinalCanbus.CAR_444_WY_LEXUS_Screen_H /* 6488508 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 62;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_AUTO = 16;
                ConstAllAirDara.C_AIR_CYCLE = 11;
                ConstAllAirDara.C_AIR_DUAL = 5;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 7;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 247;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 8;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 248;
                ConstAllAirDara.C_AIR_WIND_ADD = 17;
                ConstAllAirDara.C_AIR_WIND_SUB = 241;
                ConstAllAirDara.C_AIR_MODE_ADD = 14;
                ConstAllAirDara.C_AIR_MODE_SUB = 254;
                ConstAllAirDara.C_CONTRAL = 9;
                break;
            case FinalCanbus.CAR_453_LZ_GM_Camaro_17 /* 2163141 */:
            case FinalCanbus.CAR_453_LZ_GM_GMC_TERRAIN_17 /* 2228677 */:
            case FinalCanbus.CAR_453_LZ_GM_Equinox_17 /* 2294213 */:
            case FinalCanbus.CAR_454_LZ_GM_Camaro_17_Auto /* 6947270 */:
            case FinalCanbus.CAR_454_LZ_GM_Equinox_17_Auto /* 7012806 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_453_LZ_GM_Camaro_17 /* 2163141 */:
                    case FinalCanbus.CAR_453_LZ_GM_Equinox_17 /* 2294213 */:
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 16;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 18;
                        ConstAllAirDara.C_AIR_MODE_BODY = 15;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 17;
                        break;
                    case FinalCanbus.CAR_454_LZ_GM_Camaro_17_Auto /* 6947270 */:
                    case FinalCanbus.CAR_454_LZ_GM_Equinox_17_Auto /* 7012806 */:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.C_AIR_AUTO = 12;
                        ConstAllAirDara.C_AIR_MODE_ADD = 23;
                        ConstAllAirDara.C_AIR_MODE_SUB = 24;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 7;
                ConstAllAirDara.C_AIR_AC = 10;
                ConstAllAirDara.C_AIR_CYCLE = 11;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 13;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 14;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 6;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 21;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 19;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_455_OD_Dongfeng_Racing_EC75_23H /* 2294215 */:
            case FinalCanbus.CAR_454_OD_Dongfeng_Racing_EC75_23 /* 8454598 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_HEAT = 63;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                if (DataCanbus.DATA[1000] == 2294215) {
                    ConstAllAirDara.U_AIR_AC_MAX = 53;
                    ConstAllAirDara.C_AIR_AC_MAX = 13;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 4;
                ConstAllAirDara.C_AIR_HEAT = 5;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 8;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 9;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 11;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 12;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_RZC3_XianDai_19Palisade /* 2752959 */:
            case FinalCanbus.CAR_RZC3_XianDai_19Palisade_H /* 2818495 */:
            case FinalCanbus.CAR_RZC3_XianDai_20CARNIVAL /* 2884031 */:
            case FinalCanbus.CAR_RZC3_XianDai_20CARNIVAL_H /* 2949567 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_23Staria /* 3539391 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_23Staria_H /* 3604927 */:
                ConstAllAirDara.U_AIR_HAVE_REAR = 2;
                ConstAllAirDara.TEMPERATURE_NONE = 0;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                ConstAllAirDara.U_AIR_BACK_BLOW_UP = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                ConstAllAirDara.C_REAR_OFF = 1;
                ConstAllAirDara.C_REAR_AUTO = 3;
                ConstAllAirDara.C_REAR_LOCK = 6;
                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 8;
                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 7;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 8;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 7;
                ConstAllAirDara.C_REAR_WIND_DOWN = 13;
                ConstAllAirDara.C_REAR_WIND_UP = 12;
                ConstAllAirDara.C_REAR_MODE_FOOT = 34;
                ConstAllAirDara.C_REAR_MODE_BODY = 32;
                ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 33;
                ConstAllAirDara.C_CONTRAL = 10;
                break;
            case FinalCanbus.CAR_446_WC2_Ford_Mustang_Air_18_L /* 2884030 */:
            case FinalCanbus.CAR_446_WC2_Ford_Mustang_Air_18_M /* 2949566 */:
            case FinalCanbus.CAR_446_WC2_Ford_Mustang_Air_18_H /* 3015102 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_STEER = 66;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_DUAL = 41;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                ConstAllAirDara.C_AIR_LEFT_COLD = 23;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 24;
                ConstAllAirDara.C_AIR_AC_MAX = 30;
                ConstAllAirDara.C_AIR_MODE_ADD = 21;
                ConstAllAirDara.C_AIR_MODE_SUB = 22;
                ConstAllAirDara.C_AIR_STEER = 45;
                ConstAllAirDara.C_CONTRAL = 33;
                break;
            case FinalCanbus.CAR_454_Sanwu_Nissan_QX56_2004_Auto /* 3473862 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 39;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_AC_MAX = 24;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_444_WC2_Hongqi_H7 /* 3604924 */:
            case FinalCanbus.CAR_444_WC2_Hongqi_21EQM5 /* 5702076 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_SWING = 35;
                ConstAllAirDara.U_AIR_PARK = 80;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_SYNC = 3;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                ConstAllAirDara.C_AIR_LEFT_COLD = 23;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 24;
                ConstAllAirDara.C_AIR_MODE_BODY = 26;
                ConstAllAirDara.C_AIR_MODE_FOOT = 29;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 27;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 28;
                ConstAllAirDara.C_AIR_WIND_ADD = 39;
                ConstAllAirDara.C_AIR_WIND_SUB = 55;
                ConstAllAirDara.C_AIR_SWING = 89;
                ConstAllAirDara.C_AIR_PARK = 88;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_444_WC2_JiangHuai_JiayueX7 /* 4391356 */:
            case FinalCanbus.CAR_444_WC2_JiangHuai_JiayueX7_H /* 4456892 */:
            case FinalCanbus.CAR_444_WC2_JiangHuai_RuifengS7 /* 4522428 */:
            case FinalCanbus.CAR_444_WC2_JiangHuai_RuifengS7_H /* 4587964 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                ConstAllAirDara.C_AIR_MODE_ADD = 21;
                ConstAllAirDara.C_AIR_MODE_SUB = 22;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_455_LZ_NISSAN_patrol_H /* 4653511 */:
            case FinalCanbus.CAR_453_LZ_NISSAN_patrol /* 5308869 */:
            case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX60 /* 5374405 */:
            case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX80 /* 5439941 */:
            case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX56 /* 5505477 */:
            case FinalCanbus.CAR_454_LZ_Nissan_370Z_H /* 14746054 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_L /* 15729094 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H /* 15794630 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_TW /* 15860166 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H_NP /* 15925702 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_455_LZ_NISSAN_patrol_H /* 4653511 */:
                    case FinalCanbus.CAR_453_LZ_NISSAN_patrol /* 5308869 */:
                    case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX60 /* 5374405 */:
                    case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX80 /* 5439941 */:
                    case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX56 /* 5505477 */:
                        ConstAllAirDara.U_AIR_REAR_CTRL = 67;
                        ConstAllAirDara.U_AIR_BLOWTOP = 72;
                        ConstAllAirDara.U_AIR_DUAL = 14;
                        ConstAllAirDara.C_AIR_DUAL = 14;
                        ConstAllAirDara.C_REAR_CTRL = 16;
                        ConstAllAirDara.C_AIR_BLOWTOP = 17;
                        break;
                    case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_L /* 15729094 */:
                    case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H /* 15794630 */:
                    case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_TW /* 15860166 */:
                    case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H_NP /* 15925702 */:
                        ConstAllAirDara.U_AIR_DUAL = 14;
                        ConstAllAirDara.C_AIR_DUAL = 14;
                        break;
                }
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 1;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_AUTO = 5;
                ConstAllAirDara.C_AIR_POWER = 6;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 8;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 7;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_AC = 11;
                ConstAllAirDara.C_AIR_CYCLE = 12;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 13;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_455_LZ_HAITES_Toyota_LexusRX2018_H /* 4915655 */:
            case FinalCanbus.CAR_455_HAITES_LZ_Toyota_Alpha_2 /* 5112263 */:
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11 /* 5177797 */:
            case FinalCanbus.CAR_455_HAITES_LZ_Toyota_Alpha_3 /* 5177799 */:
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_18 /* 5243333 */:
            case FinalCanbus.CAR_LUZ_Toyato_All /* 7274935 */:
            case FinalCanbus.CAR_LUZ_Toyato_All_H /* 7340471 */:
            case FinalCanbus.CAR_LUZ_Toyato_20All /* 8126903 */:
            case FinalCanbus.CAR_LUZ_Toyato_30All /* 8192439 */:
            case FinalCanbus.CAR_LUZ_Toyato_20All_RightView /* 10879431 */:
            case FinalCanbus.CAR_452_LZ_Toyato_RX450 /* 12648900 */:
            case FinalCanbus.CAR_452_LZ_Toyato_RX270 /* 12714436 */:
            case FinalCanbus.CAR_455_LZ_Toyota_4Runner_Hand /* 14221767 */:
            case FinalCanbus.CAR_455_LZ_Toyota_4Runner_Auto /* 14287303 */:
            case FinalCanbus.CAR_455_LZ_Toyota_Lexus_20RX300_Screen /* 16253383 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FLOWER_BLOW = 76;
                ConstAllAirDara.U_AIR_ION = 58;
                ConstAllAirDara.U_AIR_REAR_CTRL = 67;
                ConstAllAirDara.U_AIR_SWING = 35;
                ConstAllAirDara.U_AIR_FRONT_HOT = 17;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11 /* 5177797 */:
                    case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_18 /* 5243333 */:
                    case FinalCanbus.CAR_455_LZ_Toyota_4Runner_Hand /* 14221767 */:
                    case FinalCanbus.CAR_455_LZ_Toyota_4Runner_Auto /* 14287303 */:
                        ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                        ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                        ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 41;
                        ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                        ConstAllAirDara.U_AIR_BACK_POWER = 42;
                        ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                        ConstAllAirDara.U_AIR_BACK_BLOW_UP = 48;
                        ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                        ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                        ConstAllAirDara.C_REAR_AUTO = 45;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 38;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 39;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 46;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 47;
                        ConstAllAirDara.C_REAR_WIND_DOWN = 40;
                        ConstAllAirDara.C_REAR_WIND_UP = 41;
                        ConstAllAirDara.C_REAR_OFF = 44;
                        ConstAllAirDara.C_REAR_MODE = 43;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 18;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_AIR_FLOWER_BLOW = 32;
                ConstAllAirDara.C_AIR_SWING = 29;
                ConstAllAirDara.C_AIR_ION = 28;
                ConstAllAirDara.C_AIR_FRONT_HOT = 26;
                ConstAllAirDara.C_CONTRAL = 22;
                break;
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
            case FinalCanbus.CAR_443_WC2_Ford_EDGE_11 /* 6685115 */:
            case FinalCanbus.CAR_443_WC2_Ford_EDGE_11_CD /* 6750651 */:
            case FinalCanbus.CAR_444_WC2_Ford_Escape_08_L /* 7274940 */:
            case FinalCanbus.CAR_444_WC2_Ford_Escape_08_M /* 7340476 */:
            case FinalCanbus.CAR_444_WC2_Ford_Escape_08_H /* 7406012 */:
            case FinalCanbus.CAR_444_WC2_Ford_KA_14 /* 7733692 */:
            case FinalCanbus.CAR_444_WC2_Ford_SAMX_15 /* 7799228 */:
            case FinalCanbus.CAR_444_WC2_Ford_TAURUS_18 /* 7864764 */:
            case FinalCanbus.CAR_444_WC2_Ford_Escape_20 /* 7930300 */:
            case FinalCanbus.CAR_444_WC2_Ford_Fusion_06_L /* 7995836 */:
            case FinalCanbus.CAR_444_WC2_Ford_Fusion_06_M /* 8061372 */:
            case FinalCanbus.CAR_444_WC2_Ford_Fusion_06_H /* 8126908 */:
            case FinalCanbus.CAR_444_WC2_Ford_Tourneo_15 /* 8192444 */:
            case FinalCanbus.CAR_444_WC2_Ford_Transit_20 /* 8257980 */:
            case FinalCanbus.CAR_444_WC2_Ford_Edge_06_L /* 8323516 */:
            case FinalCanbus.CAR_444_WC2_Ford_Edge_06_M /* 8389052 */:
            case FinalCanbus.CAR_444_WC2_Ford_Edge_06_H /* 8454588 */:
            case FinalCanbus.CAR_444_WC2_Ford_Edge_15_DWS /* 8520124 */:
            case FinalCanbus.CAR_444_WC2_Ford_Explorer_06_L /* 8585660 */:
            case FinalCanbus.CAR_444_WC2_Ford_Explorer_06_M /* 8651196 */:
            case FinalCanbus.CAR_444_WC2_Ford_Explorer_06_H /* 8716732 */:
            case FinalCanbus.CAR_444_WC2_Ford_Explorer_11 /* 8782268 */:
            case FinalCanbus.CAR_444_WC2_Ford_Explorer_11_CD /* 8847804 */:
            case FinalCanbus.CAR_444_WC2_Ford_Explorer_11_SP /* 8913340 */:
            case FinalCanbus.CAR_444_WC2_Ford_Everest_16 /* 8978876 */:
            case FinalCanbus.CAR_444_WC2_Ford_Everest_23 /* 9044412 */:
            case FinalCanbus.CAR_444_WC2_Ford_Ranger_16 /* 9109948 */:
            case FinalCanbus.CAR_444_WC2_Ford_Raptor_18 /* 9175484 */:
            case FinalCanbus.CAR_444_WC2_Ford_F150_04_L /* 9241020 */:
            case FinalCanbus.CAR_444_WC2_Ford_F150_04_M /* 9306556 */:
            case FinalCanbus.CAR_444_WC2_Ford_F150_04_H /* 9372092 */:
            case FinalCanbus.CAR_444_WC2_Ford_F250_04_L /* 9437628 */:
            case FinalCanbus.CAR_444_WC2_Ford_F250_04_M /* 9503164 */:
            case FinalCanbus.CAR_444_WC2_Ford_F250_04_H /* 9568700 */:
            case FinalCanbus.CAR_444_WC2_Ford_Mustang_05_L /* 9634236 */:
            case FinalCanbus.CAR_444_WC2_Ford_Mustang_05_M /* 9699772 */:
            case FinalCanbus.CAR_444_WC2_Ford_Mustang_05_H /* 9765308 */:
            case FinalCanbus.CAR_444_WC2_Ford_Expedition_03_L /* 9896380 */:
            case FinalCanbus.CAR_444_WC2_Ford_Expedition_03_M /* 9961916 */:
            case FinalCanbus.CAR_444_WC2_Ford_Expedition_03_H /* 10027452 */:
            case FinalCanbus.CAR_444_WC2_Ford_Yihu_12_CD /* 10092988 */:
            case FinalCanbus.CAR_444_WC2_Ford_Lincoln_Continental /* 10158524 */:
            case FinalCanbus.CAR_443_WC2_Ford_F150_18 /* 15401403 */:
            case FinalCanbus.CAR_443_WC2_Ford_F150_18_CD /* 15466939 */:
            case FinalCanbus.CAR_443_WC2_Ford_F150_18_M /* 15729083 */:
            case FinalCanbus.CAR_443_WC2_Ford_F150_18_H /* 15794619 */:
            case FinalCanbus.CAR_443_WC2_Ford_F250_18_L /* 15860155 */:
            case FinalCanbus.CAR_443_WC2_Ford_F250_18_M /* 15925691 */:
            case FinalCanbus.CAR_443_WC2_Ford_F250_18_H /* 15991227 */:
            case FinalCanbus.CAR_443_WC2_Ford_F350_18_L /* 16056763 */:
            case FinalCanbus.CAR_443_WC2_Ford_F350_18_M /* 16122299 */:
            case FinalCanbus.CAR_443_WC2_Ford_F350_18_H /* 16187835 */:
            case FinalCanbus.CAR_443_WC2_Ford_Mustang_18_L /* 16253371 */:
            case FinalCanbus.CAR_443_WC2_Ford_Mustang_18_M /* 16318907 */:
            case FinalCanbus.CAR_443_WC2_Ford_Mustang_18_H /* 16384443 */:
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_FRONT_HOT = 17;
                ConstAllAirDara.U_AIR_STEER = 66;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                ConstAllAirDara.U_AIR_BACK_BLOW_UP = 18;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 19;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 20;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_DUAL = 3;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                ConstAllAirDara.C_AIR_LEFT_COLD = 23;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 24;
                ConstAllAirDara.C_AIR_AC_MAX = 26;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_443_WC2_Ford_EDGE_11 /* 6685115 */:
                    case FinalCanbus.CAR_443_WC2_Ford_EDGE_11_CD /* 6750651 */:
                        ConstAllAirDara.C_AIR_MODE_BODY = 31;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 27;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 29;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 28;
                        ConstAllAirDara.C_REAR_MODE_FOOT = 29;
                        ConstAllAirDara.C_REAR_MODE_BODY = 31;
                        ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 27;
                        break;
                    case FinalCanbus.CAR_443_WC2_Ford_F150_18 /* 15401403 */:
                    case FinalCanbus.CAR_443_WC2_Ford_F150_18_CD /* 15466939 */:
                    case FinalCanbus.CAR_443_WC2_Ford_F150_18_M /* 15729083 */:
                    case FinalCanbus.CAR_443_WC2_Ford_F150_18_H /* 15794619 */:
                    case FinalCanbus.CAR_443_WC2_Ford_F250_18_L /* 15860155 */:
                    case FinalCanbus.CAR_443_WC2_Ford_F250_18_M /* 15925691 */:
                    case FinalCanbus.CAR_443_WC2_Ford_F250_18_H /* 15991227 */:
                    case FinalCanbus.CAR_443_WC2_Ford_F350_18_L /* 16056763 */:
                    case FinalCanbus.CAR_443_WC2_Ford_F350_18_M /* 16122299 */:
                    case FinalCanbus.CAR_443_WC2_Ford_F350_18_H /* 16187835 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Mustang_18_L /* 16253371 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Mustang_18_M /* 16318907 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Mustang_18_H /* 16384443 */:
                        ConstAllAirDara.C_AIR_MODE_UP = 8;
                        ConstAllAirDara.C_AIR_MODE_BODY = 9;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                        ConstAllAirDara.U_AIR_HAVE_REAR = 255;
                        break;
                    default:
                        ConstAllAirDara.C_AIR_MODE_UP = 8;
                        ConstAllAirDara.C_AIR_MODE_BODY = 9;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                        ConstAllAirDara.C_REAR_MODE_FOOT = 10;
                        ConstAllAirDara.C_REAR_MODE_BODY = 9;
                        break;
                }
                ConstAllAirDara.C_AIR_STEER = 45;
                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 33;
                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 32;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 33;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 32;
                ConstAllAirDara.C_REAR_WIND_DOWN = 43;
                ConstAllAirDara.C_REAR_WIND_UP = 42;
                ConstAllAirDara.C_REAR_LOCK = 34;
                ConstAllAirDara.C_REAR_OFF = 46;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_452_DJ_Dodge_JCUV /* 4981188 */:
            case FinalCanbus.CAR_455_DJ_Dodge_JCUV_SCREEN /* 15991239 */:
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 18;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                ConstAllAirDara.U_AIR_BACK_BLOW_UP = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.C_AIR_AUTO = 1;
                ConstAllAirDara.C_AIR_DUAL = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_AC = 8;
                ConstAllAirDara.C_AIR_POWER = 10;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 33;
                ConstAllAirDara.C_AIR_MODE_BODY = 34;
                ConstAllAirDara.C_AIR_MODE_FOOT = 35;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 18;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 19;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 36;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 37;
                ConstAllAirDara.C_REAR_OFF = 1;
                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 4;
                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 3;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 4;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 3;
                ConstAllAirDara.C_REAR_WIND_DOWN = 8;
                ConstAllAirDara.C_REAR_WIND_UP = 7;
                ConstAllAirDara.C_REAR_LOCK = 9;
                ConstAllAirDara.C_REAR_MODE_FOOT = 16;
                ConstAllAirDara.C_REAR_MODE_BODY = 18;
                ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 17;
                break;
            case FinalCanbus.CAR_WC2_CG_Honda_16Civic_H /* 5570881 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_MODE_BODY = 9;
                ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 24;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 23;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 250;
                ConstAllAirDara.C_AIR_WIND_SUB = 251;
                ConstAllAirDara.C_AIR_SYNC = 3;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_CONTRAL = 107;
                break;
            case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9 /* 5702084 */:
            case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_Auto /* 5833156 */:
            case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_EV /* 10355140 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9 /* 5702084 */:
                        ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                        ConstAllAirDara.TEMPERATURE_LOW = 1;
                        ConstAllAirDara.TEMPERATURE_HIGHT = 16;
                        break;
                    case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_Auto /* 5833156 */:
                        ConstAllAirDara.TEMPERATURE_LOW = 0;
                        ConstAllAirDara.TEMPERATURE_HIGHT = 255;
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.C_AIR_AUTO = 21;
                        break;
                    case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_EV /* 10355140 */:
                        ConstAllAirDara.TEMPERATURE_LOW = 0;
                        ConstAllAirDara.TEMPERATURE_HIGHT = 255;
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_AQS = 54;
                        ConstAllAirDara.U_AIR_HEAT = 63;
                        ConstAllAirDara.C_AIR_AUTO = 21;
                        ConstAllAirDara.C_AIR_AQS = 37;
                        ConstAllAirDara.C_AIR_HEAT = 38;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 2;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_455_RZC_Racing_EC75_25 /* 5767623 */:
            case FinalCanbus.CAR_454_RZC_Racing_EC75_23 /* 7340486 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_HEAT = 63;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 7;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_SYNC = 16;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_HEAT = 24;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_WC2_GM_Tahoe_15_Auto /* 5832740 */:
            case FinalCanbus.CAR_WC2_GM_Escalade_15_Auto /* 5898276 */:
            case FinalCanbus.CAR_WC2_GM_Regal_14_NoAir /* 6357028 */:
            case FinalCanbus.CAR_WC2_GM_Lacrosse_09_NoAir /* 6422564 */:
            case FinalCanbus.CAR_WC2_GM_Cruze_16_NoAir /* 6488100 */:
            case FinalCanbus.CAR_WC2_GM_Malibu_13_Hand /* 6553636 */:
            case FinalCanbus.CAR_WC2_GM_Malibu_13_Auto /* 6619172 */:
            case FinalCanbus.CAR_WC2_GM_Malibu_13_Auto_Double /* 6684708 */:
            case FinalCanbus.CAR_WC2_GM_Malibu_13_Top /* 6750244 */:
            case FinalCanbus.CAR_WC2_GM_Camaro_10_NoAIr /* 6881316 */:
            case FinalCanbus.CAR_WC2_GM_Colorado_14_NoAir /* 6946852 */:
            case FinalCanbus.CAR_WC2_GM_Silverado_14_NoAir /* 7012388 */:
            case FinalCanbus.CAR_WC2_GM_Silverado_19_NoAir /* 7077924 */:
            case FinalCanbus.CAR_WC2_GMC_Terrain_10_NoAir /* 7340068 */:
                ConstAllAirDara.TEMPERATURE_LOW = 254;
                ConstAllAirDara.TEMPERATURE_HIGHT = 255;
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_AUTO = 49;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_WC2_GM_Escalade_15_Auto /* 5898276 */:
                        ConstAllAirDara.U_AIR_REAR_SYNC = 80;
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                        ConstAllAirDara.U_AIR_WAISTHEAT_LEFT = 95;
                        ConstAllAirDara.U_AIR_WAISTHEAT_RIGHT = 96;
                        ConstAllAirDara.C_REAR_SYNC = 58;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 23;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 24;
                        ConstAllAirDara.C_AIR_WAISTLEFT_HEAT = 56;
                        ConstAllAirDara.C_AIR_WAISTRIGHT_HEAT = 57;
                        ConstAllAirDara.C_AIR_MODE_BODY = 9;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 27;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 28;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 28;
                        break;
                    case FinalCanbus.CAR_WC2_GM_Regal_14_NoAir /* 6357028 */:
                    case FinalCanbus.CAR_WC2_GM_Cruze_16_NoAir /* 6488100 */:
                    case FinalCanbus.CAR_WC2_GM_Malibu_13_Hand /* 6553636 */:
                    case FinalCanbus.CAR_WC2_GM_Malibu_13_Auto /* 6619172 */:
                    case FinalCanbus.CAR_WC2_GM_Malibu_13_Auto_Double /* 6684708 */:
                    case FinalCanbus.CAR_WC2_GM_Malibu_13_Top /* 6750244 */:
                    case FinalCanbus.CAR_WC2_GM_Camaro_10_NoAIr /* 6881316 */:
                    case FinalCanbus.CAR_WC2_GM_Colorado_14_NoAir /* 6946852 */:
                    case FinalCanbus.CAR_WC2_GM_Silverado_14_NoAir /* 7012388 */:
                    case FinalCanbus.CAR_WC2_GM_Silverado_19_NoAir /* 7077924 */:
                    case FinalCanbus.CAR_WC2_GMC_Terrain_10_NoAir /* 7340068 */:
                        ConstAllAirDara.U_AIR_HAVE_REAR = 255;
                        ConstAllAirDara.C_AIR_MODE_BODY = 9;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 27;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 28;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 28;
                        break;
                    case FinalCanbus.CAR_WC2_GM_Lacrosse_09_NoAir /* 6422564 */:
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 23;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 24;
                        ConstAllAirDara.C_AIR_MODE_ADD = 21;
                        ConstAllAirDara.C_AIR_MODE_SUB = 22;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_SYNC = 3;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                ConstAllAirDara.C_REAR_LOCK = 34;
                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 33;
                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 32;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 33;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 32;
                ConstAllAirDara.C_REAR_AUTO = 53;
                ConstAllAirDara.C_REAR_OFF = 52;
                ConstAllAirDara.C_REAR_MODE = 54;
                ConstAllAirDara.C_AIR_REAR_MODE_SUB = 55;
                ConstAllAirDara.C_REAR_WIND_DOWN = 51;
                ConstAllAirDara.C_REAR_WIND_UP = 50;
                ConstAllAirDara.C_CONTRAL = 15;
                break;
            case FinalCanbus.CAR_455_RZC_Sanlin_OULANDE_20Overseas /* 5833159 */:
            case FinalCanbus.CAR_455_RZC_Sanlin_OULANDE_20Overseas_L /* 5898695 */:
            case FinalCanbus.CAR_455_RZC_Sanlin_Triton_22 /* 8520135 */:
            case FinalCanbus.CAR_455_RZC_Sanlin_Triton_22t_H /* 8585671 */:
            case FinalCanbus.CAR_455_RZC_Sanlin_Triton_22_Top /* 8651207 */:
            case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport /* 10420678 */:
            case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport_H /* 10486214 */:
            case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport_Top /* 16056774 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_REAR_CTRL = 38;
                ConstAllAirDara.U_AIR_REST = 79;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_SYNC = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 6;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_CYCLE = 21;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 23;
                ConstAllAirDara.C_REAR_CTRL = 32;
                ConstAllAirDara.C_AIR_REST = 255;
                ConstAllAirDara.C_CONTRAL = 4;
                break;
            case FinalCanbus.CAR_452_LZ_TATA_ALL /* 5898692 */:
                ConstAllAirDara.TEMPERATURE_NONE = 127;
                ConstAllAirDara.TEMPERATURE_LOW = 0;
                ConstAllAirDara.TEMPERATURE_HIGHT = 255;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_ECO = 52;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 6;
                ConstAllAirDara.C_AIR_AC = 8;
                ConstAllAirDara.C_AIR_CYCLE = 9;
                ConstAllAirDara.C_AIR_AUTO = 10;
                ConstAllAirDara.C_AIR_ECO = 11;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 12;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 13;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 14;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_453_RZC_LandRover_Discovery_19 /* 6160837 */:
            case FinalCanbus.CAR_454_RZC_LandRover_Discovery_04 /* 9765318 */:
            case FinalCanbus.CAR_455_RZC_LandRover_Ranger_11 /* 13959623 */:
            case FinalCanbus.CAR_455_RZC_LandRover_Ranger_10 /* 14025159 */:
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_ECO = 52;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 14;
                ConstAllAirDara.C_AIR_WIND_ADD = 9;
                ConstAllAirDara.C_AIR_WIND_SUB = 10;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_SYNC = 8;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_CYCLE = 4;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 17;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_MODE_UP = 28;
                ConstAllAirDara.C_AIR_MODE_BODY = 29;
                ConstAllAirDara.C_AIR_MODE_FOOT = 31;
                ConstAllAirDara.C_AIR_AUTO = 6;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 15;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 16;
                ConstAllAirDara.C_AIR_ECO = 7;
                ConstAllAirDara.C_CONTRAL = 3;
                break;
            case FinalCanbus.CAR_455_RZC_Benz_Vito_24 /* 6291911 */:
            case FinalCanbus.CAR_455_RZC_Benz_Vito_24_H /* 6488519 */:
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_SYNC = 14;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_UP = 48;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                ConstAllAirDara.C_CONTRAL = 5;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_WIND_ADD = 2;
                ConstAllAirDara.C_AIR_WIND_SUB = 242;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 243;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 244;
                ConstAllAirDara.C_AIR_SYNC = 5;
                ConstAllAirDara.C_AIR_AUTO = 6;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 7;
                ConstAllAirDara.C_AIR_AC = 9;
                ConstAllAirDara.C_AIR_CYCLE = 8;
                ConstAllAirDara.C_AIR_MODE_UP = 16;
                ConstAllAirDara.C_AIR_MODE_BODY = 17;
                ConstAllAirDara.C_AIR_MODE_FOOT = 18;
                ConstAllAirDara.C_REAR_OFF = 161;
                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 179;
                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 163;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 179;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 163;
                ConstAllAirDara.C_REAR_WIND_DOWN = 178;
                ConstAllAirDara.C_REAR_WIND_UP = 162;
                ConstAllAirDara.C_REAR_AUTO = 164;
                break;
            case FinalCanbus.CAR_455_LZ_Dodge_RAM1500 /* 6357447 */:
            case FinalCanbus.CAR_455_LZ_Dodge_RAM1500_H /* 6422983 */:
            case FinalCanbus.CAR_455_6606_LZ_Dodge_RAM1500 /* 14877127 */:
            case FinalCanbus.CAR_455_6606_LZ_Dodge_RAM1500_H /* 14942663 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.U_AIR_STEER = 66;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 6;
                ConstAllAirDara.C_AIR_POWER = 7;
                ConstAllAirDara.C_AIR_SYNC = 8;
                ConstAllAirDara.C_AIR_AC_MAX = 9;
                ConstAllAirDara.C_AIR_AC = 10;
                ConstAllAirDara.C_AIR_CYCLE = 11;
                ConstAllAirDara.C_AIR_AUTO = 12;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 13;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 14;
                ConstAllAirDara.C_AIR_MODE_BODY = 15;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 16;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 18;
                ConstAllAirDara.C_AIR_MODE_FOOT = 17;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 22;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 20;
                ConstAllAirDara.C_AIR_LEFT_COLD = 23;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 21;
                ConstAllAirDara.C_AIR_STEER = 24;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_452_XC_Ford_Escape_13_17 /* 6422980 */:
            case FinalCanbus.CAR_452_XC_Ford_edge_11_13 /* 6488516 */:
            case FinalCanbus.CAR_452_XC_Ford_Raptor_F150_09_14 /* 6554052 */:
            case FinalCanbus.CAR_452_XC_Ford_edge_15_17 /* 6619588 */:
            case FinalCanbus.CAR_452_XC_Ford_Mondeo_13_18 /* 6685124 */:
            case FinalCanbus.CAR_439_HC_Ford_Explorer /* 15335863 */:
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
                ConstAllAirDara.U_AIR_STEER = 66;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                ConstAllAirDara.U_AIR_BACK_BLOW_UP = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 19;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 18;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 21;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 20;
                ConstAllAirDara.C_AIR_WIND_ADD = 17;
                ConstAllAirDara.C_AIR_WIND_SUB = 16;
                ConstAllAirDara.C_AIR_DUAL = 7;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 12;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_STEER = 13;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_AC_MAX = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_MODE_UP = 5;
                ConstAllAirDara.C_AIR_MODE_BODY = 8;
                ConstAllAirDara.C_AIR_MODE_FOOT = 9;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 32;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 34;
                ConstAllAirDara.C_AIR_LEFT_COLD = 33;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 35;
                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 14;
                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 15;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 14;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 15;
                ConstAllAirDara.C_REAR_WIND_DOWN = 12;
                ConstAllAirDara.C_REAR_WIND_UP = 13;
                ConstAllAirDara.C_REAR_LOCK = 31;
                ConstAllAirDara.C_REAR_MODE = 255;
                ConstAllAirDara.C_REAR_OFF = 0;
                break;
            case FinalCanbus.CAR_444_WC2_Beiqi_Zhixing_19 /* 6619580 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_CONTRAL = 0;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 14;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                ConstAllAirDara.C_AIR_MODE_SUB = 22;
                ConstAllAirDara.C_AIR_MODE_ADD = 21;
                break;
            case FinalCanbus.CAR_439_HC_Ruijie /* 6816183 */:
            case FinalCanbus.CAR_439_HC_Ruijie_H /* 6881719 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 99;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_AC_MAX = 24;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 39;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_452_OD_Zotye_T700 /* 6816196 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_REAR_CTRL = 45;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_ION = 30;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_CYCLE = 4;
                ConstAllAirDara.C_AIR_AC = 5;
                ConstAllAirDara.C_AIR_DUAL = 6;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 7;
                ConstAllAirDara.C_AIR_WIND_SUB = 8;
                ConstAllAirDara.C_AIR_WIND_ADD = 9;
                ConstAllAirDara.C_REAR_CTRL = 10;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 16;
                ConstAllAirDara.C_AIR_MODE_UP = 18;
                ConstAllAirDara.C_AIR_MODE_BODY = 19;
                ConstAllAirDara.C_AIR_MODE_FOOT = 20;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 21;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 22;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 23;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 24;
                ConstAllAirDara.C_AIR_ION = 25;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_RZC_HavalH6Couple_BLUE_TOP /* 7078327 */:
            case FinalCanbus.CAR_RZC_HavalH6Couple_RED_TOP /* 7143863 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6Couple_19 /* 7602615 */:
            case FinalCanbus.CAR_439_RZC_Haval_18_19H6 /* 11272631 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_ZONE = 14;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 16;
                ConstAllAirDara.C_AIR_AC = 17;
                ConstAllAirDara.C_AIR_AUTO = 34;
                ConstAllAirDara.C_AIR_ZONE = 35;
                ConstAllAirDara.C_AIR_CYCLE = 19;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 21;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 30;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 31;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 32;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 33;
                ConstAllAirDara.C_AIR_MODE_BODY = 24;
                ConstAllAirDara.C_AIR_MODE_FOOT = 26;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 27;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 25;
                ConstAllAirDara.C_AIR_WIND_ADD = 28;
                ConstAllAirDara.C_AIR_WIND_SUB = 29;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 44;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 45;
                ConstAllAirDara.C_AIR_LEFT_COLD = 46;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 47;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_452_RZC_Subaru /* 7209412 */:
            case FinalCanbus.CAR_454_RZC_Suburu_OUTBACK_18 /* 8323526 */:
            case FinalCanbus.CAR_455_RZC_Subaru_15 /* 8978887 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 2;
                ConstAllAirDara.C_AIR_AUTO = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 4;
                ConstAllAirDara.C_AIR_AC = 5;
                ConstAllAirDara.C_AIR_AC_MAX = 6;
                ConstAllAirDara.C_AIR_SYNC = 7;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 8;
                ConstAllAirDara.C_AIR_CYCLE = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 11;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 16;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 17;
                ConstAllAirDara.C_CONTRAL = 3;
                break;
            case FinalCanbus.CAR_454_OD_Xinte_DEV1_H /* 7274950 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_AC_MAX = 22;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_MODE_ADD = 7;
                ConstAllAirDara.C_AIR_MODE_SUB = 8;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_452_XC_Rongwei_ALl /* 7471556 */:
            case FinalCanbus.CAR_452_XC_GM_ALl /* 7537092 */:
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_ZONE = 57;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_ECO = 52;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 30;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_BLOW_UP = 48;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                ConstAllAirDara.C_AIR_AUTO = 1;
                ConstAllAirDara.C_AIR_ZONE = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 4;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_AC = 8;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 9;
                ConstAllAirDara.C_AIR_POWER = 10;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                ConstAllAirDara.C_AIR_ECO = 32;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 36;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 37;
                ConstAllAirDara.C_AIR_LEFT_COLD = 38;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 39;
                ConstAllAirDara.C_REAR_OFF = 65;
                ConstAllAirDara.C_REAR_AUTO = 66;
                ConstAllAirDara.C_REAR_MODE = 67;
                ConstAllAirDara.C_REAR_WIND_DOWN = 69;
                ConstAllAirDara.C_REAR_WIND_UP = 68;
                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 71;
                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 70;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 71;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 70;
                ConstAllAirDara.C_CONTRAL = 4;
                break;
            case FinalCanbus.CAR_452_OD_HZ_Nezha /* 7602628 */:
            case FinalCanbus.CAR_455_OD_HZ_Nezha_H /* 9699783 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_HEAT = 63;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_HEAT = 46;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_AC_MAX = 22;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 2;
                ConstAllAirDara.C_AIR_MODE_ADD = 8;
                ConstAllAirDara.C_AIR_MODE_SUB = 7;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_BNR_02_09Toyato_Prado /* 7668151 */:
            case FinalCanbus.CAR_BNR_02_09Toyato_Prado_H /* 7733687 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 18;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_455_OD_CZH_Qichen_D60_EV /* 7799239 */:
            case FinalCanbus.CAR_455_YDT_OD_Qichen_D60_EV /* 8913351 */:
            case FinalCanbus.CAR_454_OD_Qichen_D60_EV /* 9961926 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_CONTRAL = 0;
                ConstAllAirDara.C_AIR_POWER = 168;
                ConstAllAirDara.C_AIR_WIND_ADD = 160;
                ConstAllAirDara.C_AIR_WIND_SUB = 176;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 161;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 177;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 162;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 178;
                ConstAllAirDara.C_AIR_MODE_BODY = 179;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 180;
                ConstAllAirDara.C_AIR_MODE_FOOT = 181;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 182;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 166;
                ConstAllAirDara.C_AIR_AC = 164;
                ConstAllAirDara.C_AIR_CYCLE = 165;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 167;
                ConstAllAirDara.C_AIR_AUTO = 169;
                ConstAllAirDara.C_AIR_SYNC = 171;
                ConstAllAirDara.C_AIR_AC_MAX = 170;
                break;
            case FinalCanbus.CAR_453_LZ_ALFA_ROMEO /* 7930309 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_CYCLE_AUTO = 36;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 49;
                ConstAllAirDara.U_AIR_AUTO_RIGHT = 50;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_STEER = 66;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_AUTO_LEFT = 49;
                ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
                ConstAllAirDara.U_AIR_BLOW_AUTO_RIGHT = 50;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 6;
                ConstAllAirDara.C_AIR_POWER = 7;
                ConstAllAirDara.C_AIR_SYNC = 8;
                ConstAllAirDara.C_AIR_AC = 9;
                ConstAllAirDara.C_AIR_CYCLE = 10;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 11;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 12;
                ConstAllAirDara.C_AIR_MODE_UP = 15;
                ConstAllAirDara.C_AIR_MODE_BODY = 13;
                ConstAllAirDara.C_AIR_MODE_FOOT = 14;
                ConstAllAirDara.C_AIR_AUTO = 16;
                ConstAllAirDara.C_AIR_MODE_UP_RIGHT = 19;
                ConstAllAirDara.C_AIR_MODE_BODY_RIGHT = 17;
                ConstAllAirDara.C_AIR_MODE_FOOT_RIGHT = 18;
                ConstAllAirDara.C_AIR_AUTO_RIGHT = 20;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 21;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 22;
                ConstAllAirDara.C_AIR_STEER = 23;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_455_LZ_Benz_C200_NTG5 /* 8192455 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_SYNC = 57;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_AUTO_LEFT = 49;
                ConstAllAirDara.U_AIR_AUTO = 49;
                ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
                ConstAllAirDara.U_AIR_BLOW_AUTO_RIGHT = 50;
                ConstAllAirDara.U_AIR_AUTO_RIGHT = 50;
                ConstAllAirDara.U_AIR_PARK = 80;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 6;
                ConstAllAirDara.C_AIR_POWER = 7;
                ConstAllAirDara.C_AIR_SYNC = 8;
                ConstAllAirDara.C_AIR_AC = 9;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 14;
                ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT = 22;
                ConstAllAirDara.C_AIR_AUTO = 14;
                ConstAllAirDara.C_AIR_AUTO_RIGHT = 22;
                ConstAllAirDara.C_AIR_PARK = 26;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_455_RZC_Jianghuai_Sihao_X6 /* 8389063 */:
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 18;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 30;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 5;
                ConstAllAirDara.C_AIR_AC = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 8;
                ConstAllAirDara.C_AIR_WIND_ADD = 9;
                ConstAllAirDara.C_AIR_WIND_SUB = 10;
                ConstAllAirDara.C_AIR_MODE_BODY = 11;
                ConstAllAirDara.C_AIR_MODE_FOOT = 12;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 13;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 14;
                ConstAllAirDara.C_AIR_MODE_UP = 15;
                ConstAllAirDara.C_AIR_AC_MAX = 17;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 16;
                ConstAllAirDara.C_CONTRAL = 5;
                break;
            case FinalCanbus.CAR_453_LZ_Jili_Boyue_18 /* 8782277 */:
            case FinalCanbus.CAR_453_LZ_Jili_Boyue_18_H /* 8847813 */:
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_ION = 58;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 1;
                ConstAllAirDara.C_AIR_CYCLE = 2;
                ConstAllAirDara.C_AIR_AUTO = 3;
                ConstAllAirDara.C_AIR_AC = 4;
                ConstAllAirDara.C_AIR_AC_MAX = 5;
                ConstAllAirDara.C_AIR_DUAL = 6;
                ConstAllAirDara.C_AIR_ION = 7;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 8;
                ConstAllAirDara.C_AIR_MODE_BODY = 9;
                ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 11;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_WIND_ADD = 17;
                ConstAllAirDara.C_AIR_WIND_SUB = 18;
                ConstAllAirDara.C_AIR_POWER = 19;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_454_LZ_Nissan_05_Cima /* 9044422 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 49;
                ConstAllAirDara.U_AIR_AUTO_RIGHT = 50;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_AUTO = 5;
                ConstAllAirDara.C_AIR_POWER = 6;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 7;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 8;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_AC = 11;
                ConstAllAirDara.C_AIR_CYCLE = 12;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 13;
                ConstAllAirDara.C_AIR_DUAL = 14;
                ConstAllAirDara.C_AIR_EM = 15;
                ConstAllAirDara.C_AIR_AUTO_RIGHT = 19;
                ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT = 20;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_454_RZC_Shanqi_DelongG2 /* 10027462 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_FRONT = 18;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_MODE_BODY = 4;
                ConstAllAirDara.C_AIR_MODE_FOOT = 5;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 6;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 7;
                ConstAllAirDara.C_AIR_MODE_UP = 8;
                ConstAllAirDara.C_AIR_AUTO = 9;
                ConstAllAirDara.C_AIR_CYCLE = 10;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 14;
                ConstAllAirDara.C_AIR_WIND_ADD = 15;
                ConstAllAirDara.C_AIR_WIND_SUB = 16;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_455_LUZ_Benz_GLC_NTG50 /* 10027463 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_SYNC = 57;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_REST = 55;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_AUTO_LEFT = 49;
                ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
                ConstAllAirDara.U_AIR_BLOW_AUTO_RIGHT = 50;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_SYNC = 8;
                ConstAllAirDara.C_AIR_AC = 9;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 10;
                ConstAllAirDara.C_AIR_AUTO = 11;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 12;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 13;
                ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT = 15;
                ConstAllAirDara.C_AIR_REST = 14;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_452_KYC_Zhonghua_All /* 10617284 */:
            case FinalCanbus.CAR_452_KYC_Zhonghua_All_H /* 10682820 */:
            case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7 /* 10748356 */:
            case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7_H /* 10813892 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_SYNC = 8;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 13;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 14;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_AC_MAX = 39;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_454_OD_Dongfeng_Nami01 /* 10617286 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_MODE_ADD = 8;
                ConstAllAirDara.C_AIR_MODE_SUB = 7;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_454_OD_Yiqi_Jiefang_J6G_23 /* 10748358 */:
            case FinalCanbus.CAR_454_OD_Yiqi_Jiefang_J7_23 /* 10813894 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 2;
                ConstAllAirDara.C_AIR_MODE_ADD = 7;
                ConstAllAirDara.C_AIR_MODE_SUB = 8;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_AUTO = 16;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_AC_MAX = 24;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_454_OD_Yutong_Qingka /* 11338182 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_PTC = 68;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_PTC = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 4;
                ConstAllAirDara.C_AIR_CYCLE = 5;
                ConstAllAirDara.C_AIR_AC = 6;
                ConstAllAirDara.C_AIR_WIND_ADD = 7;
                ConstAllAirDara.C_AIR_WIND_SUB = 8;
                ConstAllAirDara.C_AIR_MODE_BODY = 9;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 10;
                ConstAllAirDara.C_AIR_MODE_FOOT = 11;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 12;
                ConstAllAirDara.C_AIR_MODE_UP = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 14;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 16;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 17;
                ConstAllAirDara.C_AIR_AC_MAX = 18;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_454_OD_Dongfeng_Tianlong /* 11403718 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_MODE_ADD = 7;
                ConstAllAirDara.C_AIR_MODE_SUB = 8;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_AC_MAX = 22;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_455_OD_RZC_DongFeng_Fengxing_16CM7 /* 11469255 */:
            case FinalCanbus.CAR_455_OD_YDT_DongFeng_Fengxing_18T5 /* 11534791 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AQS = 54;
                ConstAllAirDara.U_AIR_ION = 58;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 5;
                ConstAllAirDara.C_AIR_AC = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_MODE_UP = 8;
                ConstAllAirDara.C_AIR_WIND_ADD = 9;
                ConstAllAirDara.C_AIR_WIND_SUB = 10;
                ConstAllAirDara.C_AIR_MODE_BODY = 11;
                ConstAllAirDara.C_AIR_MODE_FOOT = 12;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 13;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 14;
                ConstAllAirDara.C_AIR_SYNC = 15;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 16;
                ConstAllAirDara.C_AIR_AC_MAX = 17;
                ConstAllAirDara.C_AIR_AUTO = 18;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 19;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 20;
                ConstAllAirDara.C_AIR_AQS = 21;
                ConstAllAirDara.C_AIR_ION = 22;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_452_OD_Qirui_Xiaomayi /* 12517828 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_PTC = 68;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 4;
                ConstAllAirDara.C_AIR_CYCLE = 5;
                ConstAllAirDara.C_AIR_AC = 6;
                ConstAllAirDara.C_AIR_PTC = 7;
                ConstAllAirDara.C_AIR_WIND_SUB = 8;
                ConstAllAirDara.C_AIR_WIND_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 13;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 14;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_439_LZ_INFINIT_FX35 /* 12714423 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_EM = 37;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_AUTO = 5;
                ConstAllAirDara.C_AIR_POWER = 6;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 7;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 8;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_AC = 11;
                ConstAllAirDara.C_AIR_CYCLE = 12;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 13;
                ConstAllAirDara.C_AIR_DUAL = 14;
                ConstAllAirDara.C_AIR_EM = 15;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_452_OD_LeiDing_Mangguo_L /* 13107652 */:
            case FinalCanbus.CAR_452_OD_LeiDing_Mangguo_H /* 13173188 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_PTC = 68;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_PTC = 16;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 2;
                ConstAllAirDara.C_AIR_MODE_ADD = 8;
                ConstAllAirDara.C_AIR_MODE_SUB = 7;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_454_KYC_Ford_Mustang_07_H /* 13631942 */:
            case FinalCanbus.CAR_454_KYC_Ford_Mustang_07_L /* 13697478 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_SYNC = 8;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_AC_MAX = 39;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_452_OD_ChangCheng_Fengjun5 /* 13763012 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_ZONE = 57;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_AIR_POWER = 16;
                ConstAllAirDara.C_AIR_AC = 17;
                ConstAllAirDara.C_AIR_AUTO = 18;
                ConstAllAirDara.C_AIR_CYCLE = 19;
                ConstAllAirDara.C_AIR_ZONE = 20;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 21;
                ConstAllAirDara.C_AIR_MODE_BODY = 24;
                ConstAllAirDara.C_AIR_MODE_FOOT = 26;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 25;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 27;
                ConstAllAirDara.C_AIR_WIND_ADD = 28;
                ConstAllAirDara.C_AIR_WIND_SUB = 29;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 30;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 31;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 32;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 33;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_439_DJ_Rongwei_i5 /* 13959607 */:
            case FinalCanbus.CAR_439_DJ_Rongwei_i5_H /* 14025143 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 18;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 10;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 13;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 33;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_AC = 8;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_MODE_BODY = 34;
                ConstAllAirDara.C_AIR_MODE_FOOT = 35;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 18;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 19;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 36;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 37;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_454_OD_ChangAn_Raeton /* 14352838 */:
            case FinalCanbus.CAR_454_OD_ChangAn_Raeton_H /* 14418374 */:
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_454_CZH_OUDI_BYD_ALL /* 15663558 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_AC_MAX = 22;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_MODE_ADD = 8;
                ConstAllAirDara.C_AIR_MODE_SUB = 7;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_454_LZ_Honda_AoDeSai_04 /* 16449990 */:
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.TEMPERATURE_NONE = 0;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_POWER = 38;
                ConstAllAirDara.U_AIR_BACK_BLOW_UP = 18;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 19;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 20;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                ConstAllAirDara.C_REAR_WIND_DOWN = 48;
                ConstAllAirDara.C_REAR_WIND_UP = 49;
                ConstAllAirDara.C_REAR_OFF = 61;
                ConstAllAirDara.C_REAR_MODE = 36;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
        }
    }

    private void init() {
        if (ConstAllAirDara.U_AIR_HAVE_REAR == 1) {
            findViewById(R.id.tv_sp_front).setVisibility(0);
            findViewById(R.id.tv_sp_rear).setVisibility(0);
            findViewById(R.id.tv_sp_front).setOnTouchListener(this);
            findViewById(R.id.tv_sp_rear).setOnTouchListener(this);
        } else if (ConstAllAirDara.U_AIR_HAVE_REAR == 2) {
            this.pagenum = 1;
            findViewById(R.id.veiw_air_front).setVisibility(8);
            findViewById(R.id.veiw_air_rear).setVisibility(0);
            findViewById(R.id.tv_sp_front).setVisibility(8);
            findViewById(R.id.tv_sp_rear).setVisibility(8);
        } else {
            findViewById(R.id.tv_sp_front).setVisibility(8);
            findViewById(R.id.tv_sp_rear).setVisibility(8);
        }
        findViewById(R.id.air_sp_power).setOnTouchListener(this);
        findViewById(R.id.air_sp_rear_wind_minuts).setOnTouchListener(this);
        findViewById(R.id.air_sp_rear_wind_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_rearleft_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_rearleft_minus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_rearright_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_rearright_minus).setOnTouchListener(this);
        findViewById(R.id.air_sp_wind_minuts).setOnTouchListener(this);
        findViewById(R.id.air_sp_wind_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_left_munits).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_right_munits).setOnTouchListener(this);
        if (ConstAllAirDara.C_REAR_MODE != 255) {
            findViewById(R.id.air_sp_rear_blow_changer).setVisibility(0);
            findViewById(R.id.view_sp_rear_blow_changer).setVisibility(0);
            findViewById(R.id.air_sp_rear_blow_changer).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_rear_blow_changer).setVisibility(8);
            findViewById(R.id.view_sp_rear_blow_changer).setVisibility(8);
        }
        if (ConstAllAirDara.C_REAR_MODE_RIGHT != 255) {
            findViewById(R.id.air_sp_rear_blow_changer_right).setVisibility(0);
            findViewById(R.id.view_sp_rear_blow_changer_right).setVisibility(0);
            findViewById(R.id.air_sp_rear_blow_changer_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_rear_blow_changer_right).setVisibility(8);
            findViewById(R.id.view_sp_rear_blow_changer_right).setVisibility(8);
        }
        if (ConstAllAirDara.C_REAR_MODE_BODY_FOOT != 255) {
            findViewById(R.id.view_sp_rear_blow_body_foot).setVisibility(0);
            findViewById(R.id.air_sp_rear_blow_body_foot).setVisibility(0);
            findViewById(R.id.air_sp_rear_blow_body_foot).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_rear_blow_body_foot).setVisibility(8);
            findViewById(R.id.view_sp_rear_blow_body_foot).setVisibility(8);
        }
        if (ConstAllAirDara.C_REAR_MODE_BODY != 255) {
            findViewById(R.id.view_sp_rear_blow_body).setVisibility(0);
            findViewById(R.id.air_sp_rear_blow_body).setVisibility(0);
            findViewById(R.id.air_sp_rear_blow_body).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_rear_blow_body).setVisibility(8);
            findViewById(R.id.view_sp_rear_blow_body).setVisibility(8);
        }
        if (ConstAllAirDara.C_REAR_MODE_FOOT != 255) {
            findViewById(R.id.view_sp_rear_blow_foot).setVisibility(0);
            findViewById(R.id.air_sp_rear_blow_foot).setVisibility(0);
            findViewById(R.id.air_sp_rear_blow_foot).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_rear_blow_foot).setVisibility(8);
            findViewById(R.id.view_sp_rear_blow_foot).setVisibility(8);
        }
        if (ConstAllAirDara.C_REAR_MODE_BODY_RIGHT != 255) {
            findViewById(R.id.view_sp_rear_blow_body_right).setVisibility(0);
            findViewById(R.id.air_sp_rear_blow_body_right).setVisibility(0);
            findViewById(R.id.air_sp_rear_blow_body_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_rear_blow_body_right).setVisibility(8);
            findViewById(R.id.view_sp_rear_blow_body_right).setVisibility(8);
        }
        if (ConstAllAirDara.C_REAR_MODE_FOOT_RIGHT != 255) {
            findViewById(R.id.view_sp_rear_blow_foot_right).setVisibility(0);
            findViewById(R.id.air_sp_rear_blow_foot_right).setVisibility(0);
            findViewById(R.id.air_sp_rear_blow_foot_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_rear_blow_foot_right).setVisibility(8);
            findViewById(R.id.view_sp_rear_blow_foot_right).setVisibility(8);
        }
        if (ConstAllAirDara.C_REAR_LOCK != 255) {
            findViewById(R.id.air_sp_rearlock_rear).setVisibility(0);
            findViewById(R.id.view_sp_rearlock_rear).setVisibility(0);
            findViewById(R.id.air_sp_rearlock_rear).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_rearlock_rear).setVisibility(8);
            findViewById(R.id.view_sp_rearlock_rear).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_REAR_SYNC != 255) {
            findViewById(R.id.air_sp_sync_rear).setVisibility(0);
            findViewById(R.id.view_sp_sync_rear).setVisibility(0);
            findViewById(R.id.air_sp_sync_rear).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_sync_rear).setVisibility(8);
            findViewById(R.id.view_sp_sync_rear).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_REAR_AC != 255) {
            findViewById(R.id.air_sp_ac_rear).setVisibility(0);
            findViewById(R.id.view_sp_ac_rear).setVisibility(0);
            findViewById(R.id.air_sp_ac_rear).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_ac_rear).setVisibility(8);
            findViewById(R.id.view_sp_ac_rear).setVisibility(8);
        }
        if (ConstAllAirDara.C_REAR_CTRL != 255) {
            findViewById(R.id.air_sp_car_rear).setVisibility(0);
            findViewById(R.id.view_sp_car_rear).setVisibility(0);
            findViewById(R.id.air_sp_car_rear).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_car_rear).setVisibility(8);
            findViewById(R.id.view_sp_car_rear).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_REST != 255) {
            findViewById(R.id.air_sp_rest).setVisibility(0);
            findViewById(R.id.view_sp_rest).setVisibility(0);
            findViewById(R.id.air_sp_rest).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_rest).setVisibility(8);
            findViewById(R.id.view_sp_rest).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_FLOWER_BLOW != 255) {
            findViewById(R.id.air_sp_flowerblow).setVisibility(0);
            findViewById(R.id.view_sp_flowerblow).setVisibility(0);
            findViewById(R.id.air_sp_flowerblow).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_flowerblow).setVisibility(8);
            findViewById(R.id.view_sp_flowerblow).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_PARK != 255) {
            findViewById(R.id.air_sp_airpark).setVisibility(0);
            findViewById(R.id.view_sp_airpark).setVisibility(0);
            findViewById(R.id.air_sp_airpark).setOnTouchListener(this);
        } else {
            findViewById(R.id.view_sp_airpark).setVisibility(8);
            findViewById(R.id.air_sp_airpark).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_FRONT_ONLY != 255) {
            findViewById(R.id.air_sp_onlyfront).setVisibility(0);
            findViewById(R.id.view_sp_onlyfront).setVisibility(0);
            findViewById(R.id.air_sp_onlyfront).setOnTouchListener(this);
        } else {
            findViewById(R.id.view_sp_onlyfront).setVisibility(8);
            findViewById(R.id.air_sp_onlyfront).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_FRONT_ONLY_F != 255) {
            findViewById(R.id.air_sp_onlyfront_front).setVisibility(0);
            findViewById(R.id.view_sp_onlyfront_front).setVisibility(0);
            findViewById(R.id.air_sp_onlyfront_front).setOnTouchListener(this);
        } else {
            findViewById(R.id.view_sp_onlyfront_front).setVisibility(8);
            findViewById(R.id.air_sp_onlyfront_front).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_REAR_MANUAL != 255) {
            findViewById(R.id.air_sp_rear_manual).setVisibility(0);
            findViewById(R.id.view_sp_rear_manual).setVisibility(0);
            findViewById(R.id.air_sp_rear_manual).setOnTouchListener(this);
        } else {
            findViewById(R.id.view_sp_rear_manual).setVisibility(8);
            findViewById(R.id.air_sp_rear_manual).setVisibility(8);
        }
        if (ConstAllAirDara.C_REAR_COOL != 255) {
            findViewById(R.id.air_sp_rear_cool).setVisibility(0);
            findViewById(R.id.view_sp_rear_cool).setVisibility(0);
            findViewById(R.id.air_sp_rear_cool).setOnTouchListener(this);
        } else {
            findViewById(R.id.view_sp_rear_cool).setVisibility(8);
            findViewById(R.id.air_sp_rear_cool).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_NANOE != 255) {
            findViewById(R.id.air_sp_nanoe).setVisibility(0);
            findViewById(R.id.view_sp_nanoe).setVisibility(0);
            findViewById(R.id.air_sp_nanoe).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_nanoe).setVisibility(8);
            findViewById(R.id.view_sp_nanoe).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_SWING != 255) {
            findViewById(R.id.air_sp_swing).setVisibility(0);
            findViewById(R.id.view_sp_swing).setVisibility(0);
            findViewById(R.id.air_sp_swing).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_swing).setVisibility(8);
            findViewById(R.id.view_sp_swing).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_AQS != 255) {
            findViewById(R.id.air_sp_aqs).setOnTouchListener(this);
            findViewById(R.id.air_sp_aqs).setVisibility(0);
            findViewById(R.id.view_sp_aqs).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_aqs).setVisibility(8);
            findViewById(R.id.view_sp_aqs).setVisibility(8);
        }
        if (ConstAllAirDara.C_SOFT != 255) {
            findViewById(R.id.air_sp_soft).setOnTouchListener(this);
            findViewById(R.id.air_sp_soft).setVisibility(0);
            findViewById(R.id.view_sp_soft).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_soft).setVisibility(8);
            findViewById(R.id.view_sp_soft).setVisibility(8);
        }
        if (ConstAllAirDara.C_FAST != 255) {
            findViewById(R.id.air_sp_fast).setOnTouchListener(this);
            findViewById(R.id.air_sp_fast).setVisibility(0);
            findViewById(R.id.view_sp_fast).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_fast).setVisibility(8);
            findViewById(R.id.view_sp_fast).setVisibility(8);
        }
        if (ConstAllAirDara.C_NORMAL != 255) {
            findViewById(R.id.air_sp_normal).setOnTouchListener(this);
            findViewById(R.id.air_sp_normal).setVisibility(0);
            findViewById(R.id.view_sp_normal).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_normal).setVisibility(8);
            findViewById(R.id.view_sp_normal).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_FRONTMAX != 255) {
            findViewById(R.id.air_sp_frontmax).setOnTouchListener(this);
            findViewById(R.id.air_sp_frontmax).setVisibility(0);
            findViewById(R.id.view_sp_frontmax).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_frontmax).setVisibility(8);
            findViewById(R.id.view_sp_frontmax).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_PTC != 255) {
            findViewById(R.id.air_sp_ptc).setOnTouchListener(this);
            findViewById(R.id.air_sp_ptc).setVisibility(0);
            findViewById(R.id.view_sp_ptc).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_ptc).setVisibility(8);
            findViewById(R.id.view_sp_ptc).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_AC_MAX != 255) {
            findViewById(R.id.air_sp_acmax).setOnTouchListener(this);
            findViewById(R.id.air_sp_acmax).setVisibility(0);
            findViewById(R.id.view_sp_acmax).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_acmax).setVisibility(8);
            findViewById(R.id.view_sp_acmax).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_ION != 255) {
            findViewById(R.id.air_sp_ion).setOnTouchListener(this);
            findViewById(R.id.air_sp_ion).setVisibility(0);
            findViewById(R.id.view_sp_ion).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_ion).setVisibility(8);
            findViewById(R.id.view_sp_ion).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_ECO != 255) {
            findViewById(R.id.air_sp_eco).setOnTouchListener(this);
            findViewById(R.id.air_sp_eco).setVisibility(0);
            findViewById(R.id.view_sp_eco).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_eco).setVisibility(8);
            findViewById(R.id.view_sp_eco).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_BLOWTOP != 255) {
            findViewById(R.id.air_sp_blowtop).setOnTouchListener(this);
            findViewById(R.id.air_sp_blowtop).setVisibility(0);
            findViewById(R.id.view_sp_blowtop).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_blowtop).setVisibility(8);
            findViewById(R.id.view_sp_blowtop).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_WINLEV != 255) {
            findViewById(R.id.air_sp_winlev).setOnTouchListener(this);
            findViewById(R.id.air_sp_winlev).setVisibility(0);
            findViewById(R.id.view_sp_winlev).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_winlev).setVisibility(8);
            findViewById(R.id.view_sp_winlev).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_AC != 255) {
            findViewById(R.id.air_sp_ac).setVisibility(0);
            findViewById(R.id.air_sp_ac).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_ac).setBackgroundResource(R.drawable.ic_hp_ac_off);
        }
        if (ConstAllAirDara.C_AIR_AUTO != 255) {
            findViewById(R.id.air_sp_auto).setVisibility(0);
            findViewById(R.id.view_sp_auto).setVisibility(0);
            findViewById(R.id.air_sp_auto).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_auto).setVisibility(8);
            findViewById(R.id.view_sp_auto).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_HEAT != 255) {
            findViewById(R.id.air_sp_heat).setVisibility(0);
            findViewById(R.id.view_sp_heat).setVisibility(0);
            findViewById(R.id.air_sp_heat).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_heat).setVisibility(8);
            findViewById(R.id.view_sp_heat).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_AUTO_RIGHT != 255) {
            findViewById(R.id.air_sp_auto_right).setVisibility(0);
            findViewById(R.id.view_sp_auto_right).setVisibility(0);
            findViewById(R.id.air_sp_auto_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_auto_right).setVisibility(8);
            findViewById(R.id.view_sp_auto_right).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_DUAL != 255) {
            findViewById(R.id.air_sp_dual).setVisibility(0);
            findViewById(R.id.view_sp_dual).setVisibility(0);
            findViewById(R.id.air_sp_dual).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_dual).setVisibility(8);
            findViewById(R.id.view_sp_dual).setVisibility(8);
        }
        if (ConstAllAirDara.C_CLEAN != 255) {
            findViewById(R.id.air_sp_clean).setVisibility(0);
            findViewById(R.id.view_sp_clean).setVisibility(0);
            findViewById(R.id.air_sp_clean).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_clean).setVisibility(8);
            findViewById(R.id.view_sp_clean).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_EM != 255) {
            findViewById(R.id.air_sp_em).setOnTouchListener(this);
            findViewById(R.id.air_sp_em).setVisibility(0);
            findViewById(R.id.view_sp_em).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_em).setVisibility(8);
            findViewById(R.id.view_sp_em).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_OUTSIDE != 255) {
            findViewById(R.id.air_sp_outside).setOnTouchListener(this);
            findViewById(R.id.air_sp_outside).setVisibility(0);
            findViewById(R.id.view_sp_outside).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_outside).setVisibility(8);
            findViewById(R.id.view_sp_outside).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_FRONT_HOT != 255) {
            findViewById(R.id.air_sp_fronthot).setOnTouchListener(this);
            findViewById(R.id.air_sp_fronthot).setVisibility(0);
            findViewById(R.id.view_sp_fronthot).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_fronthot).setVisibility(8);
            findViewById(R.id.view_sp_fronthot).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_SYNC != 255) {
            findViewById(R.id.air_sp_sync).setVisibility(0);
            findViewById(R.id.view_sp_sync).setVisibility(0);
            findViewById(R.id.air_sp_sync).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_sync).setVisibility(8);
            findViewById(R.id.view_sp_sync).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_ZONE != 255) {
            findViewById(R.id.air_sp_zone).setVisibility(0);
            findViewById(R.id.view_sp_zone).setVisibility(0);
            findViewById(R.id.air_sp_zone).setOnTouchListener(this);
        } else {
            findViewById(R.id.view_sp_zone).setVisibility(8);
            findViewById(R.id.air_sp_zone).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_CYCLE != 255) {
            findViewById(R.id.air_sp_cycle).setVisibility(0);
            findViewById(R.id.air_sp_cycle).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_cycle).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_STEER != 255) {
            findViewById(R.id.air_sp_steer).setOnTouchListener(this);
            findViewById(R.id.air_sp_steer).setVisibility(0);
            findViewById(R.id.view_sp_steer).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_steer).setVisibility(8);
            findViewById(R.id.view_sp_steer).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_FRONT_DEFROST != 255) {
            findViewById(R.id.air_sp_front).setVisibility(0);
            findViewById(R.id.air_sp_front).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_front).setBackgroundResource(R.drawable.ic_hp_front_off);
        }
        if (ConstAllAirDara.U_AIR_REAR != 255) {
            findViewById(R.id.air_sp_rear).setVisibility(0);
            findViewById(R.id.air_sp_rear).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_rear).setBackgroundResource(R.drawable.ic_hp_rear_off);
        }
        if (ConstAllAirDara.C_AIR_MODE_CHANGER != 255) {
            findViewById(R.id.air_sp_blow_changer).setOnTouchListener(this);
            findViewById(R.id.air_sp_blow_changer).setVisibility(0);
            findViewById(R.id.view_sp_blow_changer).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_blow_changer).setVisibility(8);
            findViewById(R.id.view_sp_blow_changer).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT != 255) {
            findViewById(R.id.air_sp_blow_changer_right).setVisibility(0);
            findViewById(R.id.view_sp_blow_changer_right).setVisibility(0);
            findViewById(R.id.air_sp_blow_changer_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_blow_changer_right).setVisibility(8);
            findViewById(R.id.view_sp_blow_changer_right).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_ADD != 255) {
            findViewById(R.id.air_sp_blow_mode_plus).setVisibility(0);
            findViewById(R.id.view_sp_blow_mode_plus).setVisibility(0);
            findViewById(R.id.air_sp_blow_mode_plus).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_blow_mode_plus).setVisibility(8);
            findViewById(R.id.view_sp_blow_mode_plus).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_UP != 255) {
            findViewById(R.id.air_sp_blow_win).setVisibility(0);
            findViewById(R.id.view_sp_blow_win).setVisibility(0);
            findViewById(R.id.air_sp_blow_win).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_blow_win).setVisibility(8);
            findViewById(R.id.view_sp_blow_win).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_BODY != 255) {
            findViewById(R.id.air_sp_blow_body).setVisibility(0);
            findViewById(R.id.view_sp_blow_body).setVisibility(0);
            findViewById(R.id.air_sp_blow_body).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_blow_body).setVisibility(8);
            findViewById(R.id.view_sp_blow_body).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_FOOT != 255) {
            findViewById(R.id.air_sp_blow_foot).setVisibility(0);
            findViewById(R.id.view_sp_blow_foot).setVisibility(0);
            findViewById(R.id.air_sp_blow_foot).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_blow_foot).setVisibility(8);
            findViewById(R.id.view_sp_blow_foot).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_UP_RIGHT != 255) {
            findViewById(R.id.air_sp_blow_win_right).setVisibility(0);
            findViewById(R.id.view_sp_blow_win_right).setVisibility(0);
            findViewById(R.id.air_sp_blow_win_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_blow_win_right).setVisibility(8);
            findViewById(R.id.view_sp_blow_win_right).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_BODY_RIGHT != 255) {
            findViewById(R.id.air_sp_blow_body_right).setVisibility(0);
            findViewById(R.id.view_sp_blow_body_right).setVisibility(0);
            findViewById(R.id.air_sp_blow_body_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_blow_body_right).setVisibility(8);
            findViewById(R.id.view_sp_blow_body_right).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_FOOT_RIGHT != 255) {
            findViewById(R.id.air_sp_blow_foot_right).setVisibility(0);
            findViewById(R.id.view_sp_blow_foot_right).setVisibility(0);
            findViewById(R.id.air_sp_blow_foot_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_blow_foot_right).setVisibility(8);
            findViewById(R.id.view_sp_blow_foot_right).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_BODYFOOT != 255) {
            findViewById(R.id.air_sp_blow_body_foot).setVisibility(0);
            findViewById(R.id.view_sp_blow_body_foot).setVisibility(0);
            findViewById(R.id.air_sp_blow_body_foot).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_blow_body_foot).setVisibility(8);
            findViewById(R.id.view_sp_blow_body_foot).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_UPFOOT != 255) {
            findViewById(R.id.air_sp_blow_foot_win).setVisibility(0);
            findViewById(R.id.view_sp_blow_foot_win).setVisibility(0);
            findViewById(R.id.air_sp_blow_foot_win).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_blow_foot_win).setVisibility(8);
            findViewById(R.id.view_sp_blow_foot_win).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_SUB != 255) {
            findViewById(R.id.air_sp_blow_mode_minus).setVisibility(0);
            findViewById(R.id.view_sp_blow_mode_minus).setVisibility(0);
            findViewById(R.id.air_sp_blow_mode_minus).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_blow_mode_minus).setVisibility(8);
            findViewById(R.id.view_sp_blow_mode_minus).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_REAR_MODE_SUB != 255) {
            findViewById(R.id.air_sp_rear_blow_mode_minus).setVisibility(0);
            findViewById(R.id.view_sp_rear_blow_mode_minus).setVisibility(0);
            findViewById(R.id.air_sp_rear_blow_mode_minus).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_rear_blow_mode_minus).setVisibility(8);
            findViewById(R.id.view_sp_rear_blow_mode_minus).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_CENTER != 255) {
            findViewById(R.id.air_sp_blow_changer_center).setVisibility(0);
            findViewById(R.id.view_sp_blow_changer_center).setVisibility(0);
            findViewById(R.id.air_sp_blow_changer_center).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_blow_changer_center).setVisibility(8);
            findViewById(R.id.view_sp_blow_changer_center).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_SEATWIND_LEFT != 255) {
            findViewById(R.id.air_sp_seatwind_left).setVisibility(0);
            findViewById(R.id.view_sp_seatwind_left).setVisibility(0);
            findViewById(R.id.air_sp_seatwind_left).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_seatwind_left).setVisibility(8);
            findViewById(R.id.view_sp_seatwind_left).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_SEATWIND_RIGHT != 255) {
            findViewById(R.id.air_sp_seatwind_right).setVisibility(0);
            findViewById(R.id.view_sp_seatwind_right).setVisibility(0);
            findViewById(R.id.air_sp_seatwind_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_seatwind_right).setVisibility(8);
            findViewById(R.id.view_sp_seatwind_right).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_SEATWIND_LEFT_REAR != 255) {
            findViewById(R.id.air_sp_seatwind_left_rear).setVisibility(0);
            findViewById(R.id.view_sp_seatwind_left_rear).setVisibility(0);
            findViewById(R.id.air_sp_seatwind_left_rear).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_seatwind_left_rear).setVisibility(8);
            findViewById(R.id.view_sp_seatwind_left_rear).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_SEATWIND_RIGHT_REAR != 255) {
            findViewById(R.id.air_sp_seatwind_right_rear).setVisibility(0);
            findViewById(R.id.view_sp_seatwind_right_rear).setVisibility(0);
            findViewById(R.id.air_sp_seatwind_right_rear).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_seatwind_right_rear).setVisibility(8);
            findViewById(R.id.view_sp_seatwind_right_rear).setVisibility(8);
        }
        if (ConstAllAirDara.C_REAR_AUTO != 255) {
            findViewById(R.id.air_sp_auto_rear).setVisibility(0);
            findViewById(R.id.view_sp_auto_rear).setVisibility(0);
            findViewById(R.id.air_sp_auto_rear).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_auto_rear).setVisibility(8);
            findViewById(R.id.view_sp_auto_rear).setVisibility(8);
        }
        if (ConstAllAirDara.C_REAR_AUTO_RIGHT != 255) {
            findViewById(R.id.air_sp_auto_rear_right).setVisibility(0);
            findViewById(R.id.view_sp_auto_rear_right).setVisibility(0);
            findViewById(R.id.air_sp_auto_rear_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_auto_rear_right).setVisibility(8);
            findViewById(R.id.view_sp_auto_rear_right).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_WAISTHEAT_LEFT != 255) {
            findViewById(R.id.air_sp_waistheat_left).setVisibility(0);
            findViewById(R.id.view_sp_waistheat_left).setVisibility(0);
            findViewById(R.id.air_sp_waistheat_left).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_waistheat_left).setVisibility(8);
            findViewById(R.id.view_sp_waistheat_left).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_WAISTHEAT_RIGHT != 255) {
            findViewById(R.id.air_sp_waistheat_right).setVisibility(0);
            findViewById(R.id.view_sp_waistheat_right).setVisibility(0);
            findViewById(R.id.air_sp_waistheat_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_waistheat_right).setVisibility(8);
            findViewById(R.id.view_sp_waistheat_right).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_SEATHEAT_LEFT != 255) {
            findViewById(R.id.air_sp_seatheat_left).setVisibility(0);
            findViewById(R.id.view_sp_seatheat_left).setVisibility(0);
            findViewById(R.id.air_sp_seatheat_left).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_seatheat_left).setVisibility(8);
            findViewById(R.id.view_sp_seatheat_left).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_SEATHEAT_RIGHT != 255) {
            findViewById(R.id.air_sp_seatheat_right).setVisibility(0);
            findViewById(R.id.view_sp_seatheat_right).setVisibility(0);
            findViewById(R.id.air_sp_seatheat_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_seatheat_right).setVisibility(8);
            findViewById(R.id.view_sp_seatheat_right).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_SEATHEAT_LEFT_REAR != 255) {
            findViewById(R.id.air_sp_seatheat_left_rear).setVisibility(0);
            findViewById(R.id.view_sp_seatheat_left_rear).setVisibility(0);
            findViewById(R.id.air_sp_seatheat_left_rear).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_seatheat_left_rear).setVisibility(8);
            findViewById(R.id.view_sp_seatheat_left_rear).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_SEATHEAT_RIGHT_REAR != 255) {
            findViewById(R.id.air_sp_seatheat_right_rear).setVisibility(0);
            findViewById(R.id.view_sp_seatheat_right_rear).setVisibility(0);
            findViewById(R.id.air_sp_seatheat_right_rear).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_seatheat_right_rear).setVisibility(8);
            findViewById(R.id.view_sp_seatheat_right_rear).setVisibility(8);
        }
    }

    private boolean IsdisableAirWindow() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_Tangdu_Nissan_10PATROL_L /* 4260295 */:
            case FinalCanbus.CAR_455_Tangdu_Nissan_22PATROL_Armada /* 10224071 */:
            case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_L /* 13763014 */:
            case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_H /* 13828550 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER /* 15139270 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER_H /* 15532486 */:
                return false;
            default:
                return true;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        if (ConstAllAirDara.JumpNewRearAir) {
            this.pagenum = 1;
            findViewById(R.id.veiw_air_front).setVisibility(8);
            findViewById(R.id.veiw_air_rear).setVisibility(0);
            ((TextView) findViewById(R.id.tv_sp_front)).setTextColor(Color.parseColor("#ffffff"));
            ((TextView) findViewById(R.id.tv_sp_rear)).setTextColor(Color.parseColor("#d5a45e"));
            if (ConstAllAirDara.U_AIR_BACK_POWER != 255) {
                mUpdatePower();
            } else {
                mUpdateBackWind();
            }
        }
        initCallbackId();
        init();
        addUpdater();
        if (IsdisableAirWindow()) {
            AirHelper.disableAirWindowLocal(true);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        if (IsdisableAirWindow()) {
            AirHelper.disableAirWindowLocal(false);
        }
        removeUpdater();
        ConstAllAirDara.JumpNewAir = false;
        ConstAllAirDara.JumpNewRearAir = false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int data0;
        int id = v.getId();
        int data1 = 255;
        switch (id) {
            case R.id.tv_sp_front /* 2131427513 */:
                this.pagenum = 0;
                findViewById(R.id.veiw_air_front).setVisibility(0);
                findViewById(R.id.veiw_air_rear).setVisibility(8);
                ((TextView) findViewById(R.id.tv_sp_front)).setTextColor(Color.parseColor("#d5a45e"));
                ((TextView) findViewById(R.id.tv_sp_rear)).setTextColor(Color.parseColor("#ffffff"));
                if (ConstAllAirDara.U_AIR_POWER != 255) {
                    mUpdatePower();
                } else {
                    mUpdaterAirWindLevelLeft();
                }
                break;
            case R.id.tv_sp_rear /* 2131427514 */:
                this.pagenum = 1;
                findViewById(R.id.veiw_air_front).setVisibility(8);
                findViewById(R.id.veiw_air_rear).setVisibility(0);
                ((TextView) findViewById(R.id.tv_sp_front)).setTextColor(Color.parseColor("#ffffff"));
                ((TextView) findViewById(R.id.tv_sp_rear)).setTextColor(Color.parseColor("#d5a45e"));
                if (ConstAllAirDara.U_AIR_BACK_POWER != 255) {
                    mUpdatePower();
                } else {
                    mUpdateBackWind();
                }
                break;
            case R.id.air_sp_temp_left_plus /* 2131427516 */:
                data1 = ConstAllAirDara.C_AIR_TEMP_LEFT_ADD;
                break;
            case R.id.air_sp_temp_left_munits /* 2131427517 */:
                data1 = ConstAllAirDara.C_AIR_TEMP_LEFT_SUB;
                break;
            case R.id.air_sp_blow_mode_minus /* 2131427518 */:
                data1 = ConstAllAirDara.C_AIR_MODE_SUB;
                break;
            case R.id.air_sp_blow_mode_plus /* 2131427519 */:
                data1 = ConstAllAirDara.C_AIR_MODE_ADD;
                break;
            case R.id.air_sp_wind_minuts /* 2131427520 */:
                data1 = ConstAllAirDara.C_AIR_WIND_SUB;
                break;
            case R.id.air_sp_wind_plus /* 2131427522 */:
                data1 = ConstAllAirDara.C_AIR_WIND_ADD;
                break;
            case R.id.air_sp_temp_right_plus /* 2131427523 */:
                data1 = ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD;
                break;
            case R.id.air_sp_temp_right_munits /* 2131427524 */:
                data1 = ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB;
                break;
            case R.id.air_sp_seatheat_left /* 2131427525 */:
                data1 = ConstAllAirDara.C_AIR_LEFT_HEAT;
                break;
            case R.id.air_sp_seatwind_left /* 2131427526 */:
                data1 = ConstAllAirDara.C_AIR_LEFT_COLD;
                break;
            case R.id.air_sp_flowerblow /* 2131427527 */:
                data1 = ConstAllAirDara.C_AIR_FLOWER_BLOW;
                break;
            case R.id.air_sp_power /* 2131427528 */:
                data1 = this.pagenum == 1 ? ConstAllAirDara.C_REAR_OFF : ConstAllAirDara.C_AIR_POWER;
                break;
            case R.id.air_sp_eco /* 2131427529 */:
                data1 = ConstAllAirDara.C_AIR_ECO;
                break;
            case R.id.air_sp_seatwind_right /* 2131427530 */:
                data1 = ConstAllAirDara.C_AIR_RIGHT_COLD;
                break;
            case R.id.air_sp_seatheat_right /* 2131427531 */:
                data1 = ConstAllAirDara.C_AIR_RIGHT_HEAT;
                break;
            case R.id.air_sp_dual /* 2131427532 */:
                data1 = ConstAllAirDara.C_AIR_DUAL;
                break;
            case R.id.air_sp_front /* 2131427533 */:
                data1 = ConstAllAirDara.C_AIR_FRONT_DEFROST;
                break;
            case R.id.air_sp_auto /* 2131427534 */:
                data1 = ConstAllAirDara.C_AIR_AUTO;
                break;
            case R.id.air_sp_ac /* 2131427535 */:
                data1 = ConstAllAirDara.C_AIR_AC;
                break;
            case R.id.air_sp_rear /* 2131427536 */:
                data1 = ConstAllAirDara.C_AIR_REAR_DEFROST;
                break;
            case R.id.air_sp_cycle /* 2131427537 */:
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_452_XC_Tianlai_GJ /* 65988 */:
                    case FinalCanbus.CAR_453_XC_Tianlai_GJ /* 1442245 */:
                    case FinalCanbus.CAR_439_HC_Nissan_GuiShi /* 7799223 */:
                        data1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1 ? 3 : 2;
                        break;
                    case FinalCanbus.CAR_BNR_NISSAN_14QiJun_H /* 721220 */:
                    case FinalCanbus.CAR_BNR_NISSAN_14QiJun_L /* 786756 */:
                    case FinalCanbus.CAR_BNR_NISSAN_16Xiaoke_L /* 852292 */:
                    case FinalCanbus.CAR_BNR_NISSAN_13TianLai_H /* 917828 */:
                    case FinalCanbus.CAR_BNR_NISSAN_16Xiaoke_H /* 983364 */:
                    case FinalCanbus.CAR_BNR_NISSAN_13TianLai_L /* 1048900 */:
                    case FinalCanbus.CAR_BNR_NISSAN_08TianLai_H /* 1114436 */:
                    case FinalCanbus.CAR_BNR_NISSAN_08TianLai_L /* 1179972 */:
                    case FinalCanbus.CAR_BNR_NISSAN_11QiDa_H /* 1245508 */:
                    case FinalCanbus.CAR_BNR_NISSAN_11QiDa_L /* 1311044 */:
                    case FinalCanbus.CAR_BNR_NISSAN_14QiJun_RS /* 1376580 */:
                    case FinalCanbus.CAR_BNR_NISSAN_14QiJun_RS_L /* 1442116 */:
                    case FinalCanbus.CAR_452_XinCheng_Infiniti_ESQ /* 1573316 */:
                    case FinalCanbus.CAR_452_XinCheng_Infiniti_13Q70L /* 2032068 */:
                    case FinalCanbus.CAR_452_XinCheng_Nissan_Tule_H /* 5112260 */:
                    case FinalCanbus.CAR_452_XinCheng_Nissan_Tule_Top /* 7078343 */:
                    case FinalCanbus.CAR_455_XinCheng_Nissan_20Tule_H /* 11665863 */:
                        data1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1 ? 35 : 34;
                        break;
                    case FinalCanbus.CAR_455_OD_Zhongtai_E200 /* 786887 */:
                        data1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1 ? 26 : 25;
                        break;
                    default:
                        data1 = ConstAllAirDara.C_AIR_CYCLE;
                        break;
                }
                break;
            case R.id.air_sp_temp_rearleft_plus /* 2131427539 */:
                data1 = ConstAllAirDara.C_REAR_LEFT_TEMP_UP;
                break;
            case R.id.air_sp_rear_blow_changer /* 2131427542 */:
                data1 = ConstAllAirDara.C_REAR_MODE;
                break;
            case R.id.air_sp_rear_wind_minuts /* 2131427543 */:
                data1 = ConstAllAirDara.C_REAR_WIND_DOWN;
                break;
            case R.id.air_sp_rear_wind_plus /* 2131427545 */:
                data1 = ConstAllAirDara.C_REAR_WIND_UP;
                break;
            case R.id.air_sp_temp_rearright_plus /* 2131427546 */:
                data1 = ConstAllAirDara.C_REAR_RIGHT_TEMP_UP;
                break;
            case R.id.air_sp_temp_rearright_minus /* 2131427548 */:
                data1 = ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN;
                break;
            case R.id.air_sp_rearlock_rear /* 2131427549 */:
                data1 = ConstAllAirDara.C_REAR_LOCK;
                break;
            case R.id.air_sp_auto_rear /* 2131427551 */:
                data1 = ConstAllAirDara.C_REAR_AUTO;
                break;
            case R.id.air_sp_blow_body_foot /* 2131428082 */:
                data1 = ConstAllAirDara.C_AIR_MODE_BODYFOOT;
                break;
            case R.id.air_sp_blow_foot /* 2131428083 */:
                data1 = ConstAllAirDara.C_AIR_MODE_FOOT;
                break;
            case R.id.air_sp_blow_body /* 2131428084 */:
                data1 = ConstAllAirDara.C_AIR_MODE_BODY;
                break;
            case R.id.air_sp_blow_foot_win /* 2131428085 */:
                data1 = ConstAllAirDara.C_AIR_MODE_UPFOOT;
                break;
            case R.id.air_sp_acmax /* 2131428086 */:
                data1 = ConstAllAirDara.C_AIR_AC_MAX;
                break;
            case R.id.air_sp_steer /* 2131428087 */:
                data1 = ConstAllAirDara.C_AIR_STEER;
                break;
            case R.id.air_sp_sync /* 2131428088 */:
                data1 = ConstAllAirDara.C_AIR_SYNC;
                break;
            case R.id.air_sp_mode_change /* 2131428713 */:
            case R.id.air_sp_blow_changer /* 2131428846 */:
                data1 = ConstAllAirDara.C_AIR_MODE_CHANGER;
                break;
            case R.id.air_sp_blow_win /* 2131428717 */:
                data1 = ConstAllAirDara.C_AIR_MODE_UP;
                break;
            case R.id.air_sp_frontmax /* 2131428803 */:
                data1 = ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST;
                break;
            case R.id.air_sp_nanoe /* 2131428847 */:
                data1 = ConstAllAirDara.C_AIR_NANOE;
                break;
            case R.id.air_sp_seatwind_left_rear /* 2131428848 */:
                data1 = ConstAllAirDara.C_AIR_LEFT_COLD_REAR;
                break;
            case R.id.air_sp_seatheat_left_rear /* 2131428849 */:
                data1 = ConstAllAirDara.C_AIR_LEFT_HEAT_REAR;
                break;
            case R.id.air_sp_seatheat_right_rear /* 2131428850 */:
                data1 = ConstAllAirDara.C_AIR_RIGHT_HEAT_REAR;
                break;
            case R.id.air_sp_seatwind_right_rear /* 2131428851 */:
                data1 = ConstAllAirDara.C_AIR_RIGHT_COLD_REAR;
                break;
            case R.id.air_sp_rear_blow_body_foot /* 2131428852 */:
                data1 = ConstAllAirDara.C_REAR_MODE_BODY_FOOT;
                break;
            case R.id.air_sp_rear_blow_foot /* 2131428853 */:
                data1 = ConstAllAirDara.C_REAR_MODE_FOOT;
                break;
            case R.id.air_sp_rear_blow_body /* 2131428854 */:
                data1 = ConstAllAirDara.C_REAR_MODE_BODY;
                break;
            case R.id.air_sp_sync_rear /* 2131428855 */:
                data1 = ConstAllAirDara.C_REAR_SYNC;
                break;
            case R.id.air_sp_ac_rear /* 2131428856 */:
                data1 = ConstAllAirDara.C_REAR_AC;
                break;
            case R.id.air_sp_fronthot /* 2131428859 */:
                data1 = ConstAllAirDara.C_AIR_FRONT_HOT;
                break;
            case R.id.air_sp_onlyfront_front /* 2131428860 */:
                data1 = ConstAllAirDara.C_AIR_FRONT_ONLY_F;
                break;
            case R.id.air_sp_auto_right /* 2131429692 */:
                data1 = ConstAllAirDara.C_AIR_AUTO_RIGHT;
                break;
            case R.id.air_sp_blow_win_right /* 2131429713 */:
                data1 = ConstAllAirDara.C_AIR_MODE_UP_RIGHT;
                break;
            case R.id.air_sp_blow_body_right /* 2131429714 */:
                data1 = ConstAllAirDara.C_AIR_MODE_BODY_RIGHT;
                break;
            case R.id.air_sp_blow_foot_right /* 2131429715 */:
                data1 = ConstAllAirDara.C_AIR_MODE_FOOT_RIGHT;
                break;
            case R.id.air_sp_car_rear /* 2131429716 */:
                data1 = ConstAllAirDara.C_REAR_CTRL;
                break;
            case R.id.air_sp_aqs /* 2131429717 */:
                data1 = ConstAllAirDara.C_AIR_AQS;
                break;
            case R.id.air_sp_rest /* 2131429718 */:
                data1 = ConstAllAirDara.C_AIR_REST;
                break;
            case R.id.air_sp_waistheat_left /* 2131429722 */:
                data1 = ConstAllAirDara.C_AIR_WAISTLEFT_HEAT;
                break;
            case R.id.air_sp_ptc /* 2131429725 */:
                data1 = ConstAllAirDara.C_AIR_PTC;
                break;
            case R.id.air_sp_em /* 2131429727 */:
                data1 = ConstAllAirDara.C_AIR_EM;
                break;
            case R.id.air_sp_airpark /* 2131429734 */:
                data1 = ConstAllAirDara.C_AIR_PARK;
                break;
            case R.id.air_sp_ion /* 2131429739 */:
                data1 = ConstAllAirDara.C_AIR_ION;
                break;
            case R.id.air_sp_soft /* 2131429741 */:
                data1 = ConstAllAirDara.C_SOFT;
                break;
            case R.id.air_sp_fast /* 2131429743 */:
                data1 = ConstAllAirDara.C_FAST;
                break;
            case R.id.air_sp_normal /* 2131429745 */:
                data1 = ConstAllAirDara.C_NORMAL;
                break;
            case R.id.air_sp_clean /* 2131429747 */:
                data1 = ConstAllAirDara.C_CLEAN;
                break;
            case R.id.air_sp_blowtop /* 2131429750 */:
                data1 = ConstAllAirDara.C_AIR_BLOWTOP;
                break;
            case R.id.air_sp_zone /* 2131429753 */:
                data1 = ConstAllAirDara.C_AIR_ZONE;
                break;
            case R.id.air_sp_swing /* 2131429758 */:
                data1 = ConstAllAirDara.C_AIR_SWING;
                break;
            case R.id.air_sp_winlev /* 2131429761 */:
                data1 = ConstAllAirDara.C_AIR_WINLEV;
                break;
            case R.id.air_sp_heat /* 2131429764 */:
                data1 = ConstAllAirDara.C_AIR_HEAT;
                break;
            case R.id.air_sp_waistheat_right /* 2131429767 */:
                data1 = ConstAllAirDara.C_AIR_WAISTRIGHT_HEAT;
                break;
            case R.id.air_sp_blow_changer_center /* 2131429781 */:
                data1 = ConstAllAirDara.C_AIR_MODE_CENTER;
                break;
            case R.id.air_sp_blow_changer_right /* 2131429784 */:
                data1 = ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT;
                break;
            case R.id.air_sp_rear_manual /* 2131429789 */:
                data1 = ConstAllAirDara.C_AIR_REAR_MANUAL;
                break;
            case R.id.air_sp_rear_cool /* 2131429791 */:
                data1 = ConstAllAirDara.C_REAR_COOL;
                break;
            case R.id.air_sp_onlyfront /* 2131429793 */:
                data1 = ConstAllAirDara.C_AIR_FRONT_ONLY;
                break;
            case R.id.air_sp_auto_rear_right /* 2131429798 */:
                data1 = ConstAllAirDara.C_REAR_AUTO_RIGHT;
                break;
            case R.id.air_sp_temp_rearleft_minus /* 2131429805 */:
                data1 = ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN;
                break;
            case R.id.air_sp_rear_blow_mode_minus /* 2131429816 */:
                data1 = ConstAllAirDara.C_AIR_REAR_MODE_SUB;
                break;
            case R.id.air_sp_rear_blow_changer_right /* 2131429821 */:
                data1 = ConstAllAirDara.C_REAR_MODE_RIGHT;
                break;
        }
        if (data1 == ConstAllAirDara.C_AIR_CYCLE) {
            if (event.getAction() == 0) {
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_WC2_GMC_Terrain_10_NoAir /* 7340068 */:
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            data0 = 49;
                        } else {
                            data0 = 48;
                        }
                        sendCmd(data0, 1);
                        SystemClock.sleep(100L);
                        sendCmd(data0, 0);
                        break;
                    default:
                        if (data1 != 255) {
                            sendCmd(data1, 1);
                        }
                        break;
                }
            } else if (event.getAction() == 1) {
                switch (DataCanbus.DATA[1000]) {
                    default:
                        if (data1 != 255) {
                            sendCmd(data1, 0);
                            break;
                        }
                    case FinalCanbus.CAR_WC2_GMC_Terrain_10_NoAir /* 7340068 */:
                        return false;
                }
            }
        } else if (event.getAction() == 0) {
            if (data1 != 255) {
                sendCmd(data1, 1);
            }
        } else if (event.getAction() == 1 && data1 != 255) {
            sendCmd(data1, 0);
        }
        return false;
    }

    private void addUpdater() {
        if (ConstAllAirDara.U_AIR_POWER != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_POWER].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BACK_POWER != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_POWER].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BACK_TEMP != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_TEMP].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_FLOWER_BLOW != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FLOWER_BLOW].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_PARK != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_PARK].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_REST != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REST].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_FRONT_ONLY != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FRONT_ONLY].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_FRONT_ONLY_F != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FRONT_ONLY_F].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_REAR_MANUAL != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR_MANUAL].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_REAR_COOL != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR_COOL].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_NANOE != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_NANOE].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_SOFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SOFT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_FAST != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FAST].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_NORMAL != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_NORMAL].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_SWING != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SWING].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_FRONT_POWER != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FRONT_POWER].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BACK_BLOW_BODY != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_BLOW_BODY].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BACK_BLOW_UP != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_BLOW_UP].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BACK_BLOW_FOOT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_BLOW_FOOT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BACK_BLOW_BODY_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_BLOW_BODY_RIGHT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BACK_BLOW_UP_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_BLOW_UP_RIGHT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BACK_BLOW_FOOT_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_BLOW_FOOT_RIGHT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BACK_BLOW_AUTO != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_BLOW_AUTO].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BACK_AUTO_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_AUTO_RIGHT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_REAR_LOCK != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR_LOCK].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_REAR_CTRL != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR_CTRL].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BACK_BLOW_WIND != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_BLOW_WIND].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_REAR != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_CYCLE != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_CYCLE].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_CYCLE_AUTO != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_CYCLE_AUTO].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_AC != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_AC].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_FRONT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FRONT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BLOW_AUTO_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_AUTO_LEFT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BLOW_BODY_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BLOW_UP_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_UP_LEFT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BLOW_AUTO_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_AUTO_RIGHT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BLOW_UP_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_UP_RIGHT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_TEMP_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_TEMP_LEFT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_AUTO != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_AUTO].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_AUTO_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_AUTO_RIGHT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_DUAL != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_DUAL].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_SYNC != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SYNC].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_ZONE != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_ZONE].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_SEATHEAT_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATHEAT_LEFT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_SEATHEAT_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_SEATWIND_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATWIND_LEFT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_SEATWIND_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATWIND_RIGHT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_SEATHEAT_LEFT_REAR != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATHEAT_LEFT_REAR].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_SEATHEAT_RIGHT_REAR != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT_REAR].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_SEATWIND_LEFT_REAR != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATWIND_LEFT_REAR].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_SEATWIND_RIGHT_REAR != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATWIND_RIGHT_REAR].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_TEMP_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_TEMP_RIGHT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_TEMP_UNIT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_TEMP_UNIT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_AQS != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_AQS].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_AC_MAX != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_AC_MAX].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_WINLEV != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_WINLEV].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_HEAT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_HEAT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_ION != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_ION].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_CLEAN != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_CLEAN].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BLOWTOP != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOWTOP].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_STEER != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_STEER].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_PTC != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_PTC].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_ECO != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_ECO].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_REAR_SYNC != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR_SYNC].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_REAR_AC != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR_AC].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_FRONTMAX != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FRONTMAX].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_FRONT_HOT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FRONT_HOT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_EM != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_EM].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_WAISTHEAT_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_WAISTHEAT_LEFT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_WAISTHEAT_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_WAISTHEAT_RIGHT].addNotify(this.mNotifyCanbus, 1);
        }
    }

    private void removeUpdater() {
        if (ConstAllAirDara.U_AIR_POWER != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_POWER].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BACK_POWER != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_POWER].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BACK_TEMP != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_TEMP].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_FLOWER_BLOW != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FLOWER_BLOW].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_PARK != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_PARK].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_REST != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REST].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_FRONT_ONLY != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FRONT_ONLY].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_FRONT_ONLY_F != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FRONT_ONLY_F].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_REAR_MANUAL != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR_MANUAL].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_REAR_COOL != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR_COOL].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_NANOE != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_NANOE].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_SOFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SOFT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_FAST != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FAST].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_NORMAL != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_NORMAL].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_SWING != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SWING].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_FRONT_POWER != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FRONT_POWER].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BACK_BLOW_BODY != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_BLOW_BODY].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BACK_BLOW_UP != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_BLOW_UP].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BACK_BLOW_FOOT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_BLOW_FOOT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BACK_BLOW_BODY_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_BLOW_BODY_RIGHT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BACK_BLOW_UP_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_BLOW_UP_RIGHT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BACK_BLOW_FOOT_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_BLOW_FOOT_RIGHT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BACK_BLOW_AUTO != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_BLOW_AUTO].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BACK_AUTO_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_AUTO_RIGHT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_REAR_LOCK != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR_LOCK].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_REAR_CTRL != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR_CTRL].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BACK_BLOW_WIND != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_BLOW_WIND].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_REAR != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_CYCLE != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_CYCLE].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_CYCLE_AUTO != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_CYCLE_AUTO].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_AC != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_AC].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_FRONT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FRONT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BLOW_AUTO_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_AUTO_LEFT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BLOW_BODY_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BLOW_UP_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_UP_LEFT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BLOW_AUTO_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_AUTO_RIGHT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BLOW_UP_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_UP_RIGHT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_TEMP_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_TEMP_LEFT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_AUTO != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_AUTO].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_AUTO_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_AUTO_RIGHT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_DUAL != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_DUAL].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_SYNC != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SYNC].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_ZONE != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_ZONE].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_SEATHEAT_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATHEAT_LEFT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_SEATHEAT_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_SEATWIND_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATWIND_LEFT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_SEATWIND_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATWIND_RIGHT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_SEATHEAT_LEFT_REAR != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATHEAT_LEFT_REAR].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_SEATHEAT_RIGHT_REAR != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT_REAR].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_SEATWIND_LEFT_REAR != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATWIND_LEFT_REAR].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_SEATWIND_RIGHT_REAR != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATWIND_RIGHT_REAR].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_TEMP_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_TEMP_RIGHT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_TEMP_UNIT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_TEMP_UNIT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_AQS != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_AQS].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_AC_MAX != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_AC_MAX].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_WINLEV != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_WINLEV].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_HEAT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_HEAT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_ION != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_ION].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_CLEAN != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_CLEAN].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BLOWTOP != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOWTOP].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_STEER != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_STEER].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_PTC != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_PTC].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_ECO != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_ECO].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_REAR_SYNC != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR_SYNC].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_REAR_AC != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR_AC].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_FRONTMAX != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FRONTMAX].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_FRONT_HOT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FRONT_HOT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_EM != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_EM].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_WAISTHEAT_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_WAISTHEAT_LEFT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_WAISTHEAT_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_WAISTHEAT_RIGHT].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirHeat() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_HEAT];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_456_OD_Hongqi_H5 /* 65992 */:
            case FinalCanbus.CAR_455_CZH_OD_Hongqi_EQM5_Huandian /* 7274951 */:
            case FinalCanbus.CAR_454_CZH_OD_Hongqi_EQM5 /* 16515526 */:
                findViewById(R.id.air_sp_heat).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_naturalwin_n : R.drawable.ic_hp_naturalwin_p);
                break;
            default:
                findViewById(R.id.air_sp_heat).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_heat_n : R.drawable.ic_hp_heat_p);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirPTC() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_PTC];
        findViewById(R.id.air_sp_ptc).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_ptc_n : R.drawable.ic_hp_ptc_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirWinlev() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_WINLEV];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_winlev).setBackgroundResource(R.drawable.ic_hp_winlev1);
                break;
            case 1:
                findViewById(R.id.air_sp_winlev).setBackgroundResource(R.drawable.ic_hp_winlev2);
                break;
            case 2:
                findViewById(R.id.air_sp_winlev).setBackgroundResource(R.drawable.ic_hp_winlev3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSteerHot() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_STEER];
        findViewById(R.id.air_sp_steer).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_steerhot_n : R.drawable.ic_hp_steerhot_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateClean() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_CLEAN];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_452_XinCheng_Infiniti_14QX70 /* 1966532 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_13Q70L /* 2032068 */:
            case FinalCanbus.CAR_452_XinCheng_Nissan_Tule_H /* 5112260 */:
            case FinalCanbus.CAR_452_XinCheng_Nissan_Tule_Top /* 7078343 */:
            case FinalCanbus.CAR_455_XinCheng_Nissan_20Tule_H /* 11665863 */:
                findViewById(R.id.air_sp_clean).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_forest_n : R.drawable.ic_hp_forest_p);
                break;
            default:
                findViewById(R.id.air_sp_clean).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_clean_n : R.drawable.ic_hp_clean_p);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateIon() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_ION];
        findViewById(R.id.air_sp_ion).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_ion_n : R.drawable.ic_hp_ion_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBlowTop() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOWTOP];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_446_WY_HCX_BYD_TANG_Screen /* 1049022 */:
                findViewById(R.id.air_sp_blowtop).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_ventilation_n : R.drawable.ic_hp_ventilation_p);
                break;
            default:
                findViewById(R.id.air_sp_blowtop).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_blowtop_n : R.drawable.ic_hp_blowtop_p);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcMax() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC_MAX];
        findViewById(R.id.air_sp_acmax).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_acmax_n : R.drawable.ic_hp_acmax_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirNormal() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_NORMAL];
        findViewById(R.id.air_sp_normal).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_normal_n : R.drawable.ic_hp_normal_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirFast() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_FAST];
        findViewById(R.id.air_sp_fast).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_fast_n : R.drawable.ic_hp_fast_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirSoft() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SOFT];
        findViewById(R.id.air_sp_soft).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_soft_n : R.drawable.ic_hp_soft_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirAQS() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_AQS];
        findViewById(R.id.air_sp_aqs).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_aqs_n : R.drawable.ic_hp_aqs_p);
    }

    private void mUpdateTempValue(int id, int value, boolean isdian) {
        if (isdian) {
            switch (value) {
                case 0:
                    findViewById(id).setBackgroundResource(R.drawable.ic_hp_air_temp_dian0);
                    break;
                case 5:
                    findViewById(id).setBackgroundResource(R.drawable.ic_hp_air_temp_dian5);
                    break;
            }
        }
        switch (value) {
            case 0:
                findViewById(id).setBackgroundResource(R.drawable.ic_hp_air_temp0);
                break;
            case 1:
                findViewById(id).setBackgroundResource(R.drawable.ic_hp_air_temp1);
                break;
            case 2:
                findViewById(id).setBackgroundResource(R.drawable.ic_hp_air_temp2);
                break;
            case 3:
                findViewById(id).setBackgroundResource(R.drawable.ic_hp_air_temp3);
                break;
            case 4:
                findViewById(id).setBackgroundResource(R.drawable.ic_hp_air_temp4);
                break;
            case 5:
                findViewById(id).setBackgroundResource(R.drawable.ic_hp_air_temp5);
                break;
            case 6:
                findViewById(id).setBackgroundResource(R.drawable.ic_hp_air_temp6);
                break;
            case 7:
                findViewById(id).setBackgroundResource(R.drawable.ic_hp_air_temp7);
                break;
            case 8:
                findViewById(id).setBackgroundResource(R.drawable.ic_hp_air_temp8);
                break;
            case 9:
                findViewById(id).setBackgroundResource(R.drawable.ic_hp_air_temp9);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBackTemp() {
        int temp = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_TEMP];
        if (findViewById(R.id.air_sp_temp_rearleft1) != null) {
            if (temp == ConstAllAirDara.TEMPERATURE_LOW) {
                findViewById(R.id.air_sp_tempvalue_rearleft).setVisibility(8);
                findViewById(R.id.air_sp_tempunit_rearleft).setVisibility(8);
                findViewById(R.id.air_sp_tempstate_rearleft).setVisibility(0);
                findViewById(R.id.air_sp_tempstate_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempstate_l);
                return;
            }
            if (temp == ConstAllAirDara.TEMPERATURE_HIGHT) {
                findViewById(R.id.air_sp_tempvalue_rearleft).setVisibility(8);
                findViewById(R.id.air_sp_tempunit_rearleft).setVisibility(8);
                findViewById(R.id.air_sp_tempstate_rearleft).setVisibility(0);
                findViewById(R.id.air_sp_tempstate_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempstate_h);
                return;
            }
            if (temp == ConstAllAirDara.TEMPERATURE_NONE) {
                findViewById(R.id.air_sp_tempvalue_rearleft).setVisibility(8);
                findViewById(R.id.air_sp_tempunit_rearleft).setVisibility(8);
                findViewById(R.id.air_sp_tempstate_rearleft).setVisibility(0);
                findViewById(R.id.air_sp_tempstate_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempstate_n);
                return;
            }
            findViewById(R.id.air_sp_tempvalue_rearleft).setVisibility(0);
            findViewById(R.id.air_sp_tempunit_rearleft).setVisibility(0);
            findViewById(R.id.air_sp_tempstate_rearleft).setVisibility(8);
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_WC2_GM_GL8 /* 393252 */:
                case FinalCanbus.CAR_455_TD_INFINIT_ESQ /* 1704391 */:
                case FinalCanbus.CAR_455_TD_INFINIT_G /* 1769927 */:
                case FinalCanbus.CAR_455_TD_INFINIT_QX50 /* 1835463 */:
                case FinalCanbus.CAR_455_TD_INFINIT_06FX /* 1900999 */:
                case FinalCanbus.CAR_455_TD_INFINIT_08FX /* 1966535 */:
                case FinalCanbus.CAR_455_TD_INFINIT_14QX70 /* 2032071 */:
                case FinalCanbus.CAR_455_TD_INFINIT_12FX /* 2097607 */:
                case FinalCanbus.CAR_455_Tangdu_Nissan_10PATROL_L /* 4260295 */:
                case FinalCanbus.CAR_WC2_GM_Tahoe_15_Auto /* 5832740 */:
                case FinalCanbus.CAR_WC2_GM_Escalade_15_Auto /* 5898276 */:
                case FinalCanbus.CAR_WC2_GM_Escalade_07_Auto /* 5963812 */:
                case FinalCanbus.CAR_455_Tangdu_Nissan_22PATROL_Armada /* 10224071 */:
                case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_L /* 13763014 */:
                case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_H /* 13828550 */:
                    temp *= 5;
                    break;
                case FinalCanbus.CAR_RZC_Explorer /* 590158 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                case FinalCanbus.CAR_RZC_Ford_Explorer_24 /* 6160718 */:
                case FinalCanbus.CAR_RZC_Ford_Explorer_24_M /* 6226254 */:
                case FinalCanbus.CAR_RZC_Ford_Explorer_24_H /* 6291790 */:
                case FinalCanbus.CAR_452_XC_Ford_Escape_13_17 /* 6422980 */:
                case FinalCanbus.CAR_452_XC_Ford_edge_11_13 /* 6488516 */:
                case FinalCanbus.CAR_452_XC_Ford_Raptor_F150_09_14 /* 6554052 */:
                case FinalCanbus.CAR_452_XC_Ford_edge_15_17 /* 6619588 */:
                case FinalCanbus.CAR_443_WC2_Ford_EDGE_11 /* 6685115 */:
                case FinalCanbus.CAR_452_XC_Ford_Mondeo_13_18 /* 6685124 */:
                case FinalCanbus.CAR_443_WC2_Ford_EDGE_11_CD /* 6750651 */:
                case FinalCanbus.CAR_444_WC2_Ford_Escape_08_L /* 7274940 */:
                case FinalCanbus.CAR_444_WC2_Ford_Escape_08_M /* 7340476 */:
                case FinalCanbus.CAR_444_WC2_Ford_Escape_08_H /* 7406012 */:
                case FinalCanbus.CAR_444_WC2_Ford_KA_14 /* 7733692 */:
                case FinalCanbus.CAR_444_WC2_Ford_SAMX_15 /* 7799228 */:
                case FinalCanbus.CAR_444_WC2_Ford_TAURUS_18 /* 7864764 */:
                case FinalCanbus.CAR_444_WC2_Ford_Escape_20 /* 7930300 */:
                case FinalCanbus.CAR_444_WC2_Ford_Fusion_06_L /* 7995836 */:
                case FinalCanbus.CAR_444_WC2_Ford_Fusion_06_M /* 8061372 */:
                case FinalCanbus.CAR_444_WC2_Ford_Fusion_06_H /* 8126908 */:
                case FinalCanbus.CAR_444_WC2_Ford_Tourneo_15 /* 8192444 */:
                case FinalCanbus.CAR_444_WC2_Ford_Transit_20 /* 8257980 */:
                case FinalCanbus.CAR_444_WC2_Ford_Edge_06_L /* 8323516 */:
                case FinalCanbus.CAR_444_WC2_Ford_Edge_06_M /* 8389052 */:
                case FinalCanbus.CAR_444_WC2_Ford_Edge_06_H /* 8454588 */:
                case FinalCanbus.CAR_444_WC2_Ford_Edge_15_DWS /* 8520124 */:
                case FinalCanbus.CAR_444_WC2_Ford_Explorer_06_L /* 8585660 */:
                case FinalCanbus.CAR_444_WC2_Ford_Explorer_06_M /* 8651196 */:
                case FinalCanbus.CAR_444_WC2_Ford_Explorer_06_H /* 8716732 */:
                case FinalCanbus.CAR_444_WC2_Ford_Explorer_11 /* 8782268 */:
                case FinalCanbus.CAR_444_WC2_Ford_Explorer_11_CD /* 8847804 */:
                case FinalCanbus.CAR_444_WC2_Ford_Explorer_11_SP /* 8913340 */:
                case FinalCanbus.CAR_444_WC2_Ford_Everest_16 /* 8978876 */:
                case FinalCanbus.CAR_444_WC2_Ford_Everest_23 /* 9044412 */:
                case FinalCanbus.CAR_444_WC2_Ford_Ranger_16 /* 9109948 */:
                case FinalCanbus.CAR_444_WC2_Ford_Raptor_18 /* 9175484 */:
                case FinalCanbus.CAR_444_WC2_Ford_F150_04_L /* 9241020 */:
                case FinalCanbus.CAR_444_WC2_Ford_F150_04_M /* 9306556 */:
                case FinalCanbus.CAR_444_WC2_Ford_F150_04_H /* 9372092 */:
                case FinalCanbus.CAR_444_WC2_Ford_F250_04_L /* 9437628 */:
                case FinalCanbus.CAR_444_WC2_Ford_F250_04_M /* 9503164 */:
                case FinalCanbus.CAR_444_WC2_Ford_F250_04_H /* 9568700 */:
                case FinalCanbus.CAR_444_WC2_Ford_Mustang_05_L /* 9634236 */:
                case FinalCanbus.CAR_444_WC2_Ford_Mustang_05_M /* 9699772 */:
                case FinalCanbus.CAR_444_WC2_Ford_Mustang_05_H /* 9765308 */:
                case FinalCanbus.CAR_444_WC2_Ford_Expedition_03_L /* 9896380 */:
                case FinalCanbus.CAR_444_WC2_Ford_Expedition_03_M /* 9961916 */:
                case FinalCanbus.CAR_444_WC2_Ford_Expedition_03_H /* 10027452 */:
                case FinalCanbus.CAR_444_WC2_Ford_Yihu_12_CD /* 10092988 */:
                case FinalCanbus.CAR_444_WC2_Ford_Lincoln_Continental /* 10158524 */:
                case FinalCanbus.CAR_439_HC_Ford_Explorer /* 15335863 */:
                case FinalCanbus.CAR_443_WC2_Ford_F150_18 /* 15401403 */:
                case FinalCanbus.CAR_443_WC2_Ford_F150_18_CD /* 15466939 */:
                case FinalCanbus.CAR_443_WC2_Ford_F150_18_M /* 15729083 */:
                case FinalCanbus.CAR_443_WC2_Ford_F150_18_H /* 15794619 */:
                case FinalCanbus.CAR_443_WC2_Ford_F250_18_L /* 15860155 */:
                case FinalCanbus.CAR_443_WC2_Ford_F250_18_M /* 15925691 */:
                case FinalCanbus.CAR_443_WC2_Ford_F250_18_H /* 15991227 */:
                case FinalCanbus.CAR_443_WC2_Ford_F350_18_L /* 16056763 */:
                case FinalCanbus.CAR_443_WC2_Ford_F350_18_M /* 16122299 */:
                case FinalCanbus.CAR_443_WC2_Ford_F350_18_H /* 16187835 */:
                case FinalCanbus.CAR_443_WC2_Ford_Mustang_18_L /* 16253371 */:
                case FinalCanbus.CAR_443_WC2_Ford_Mustang_18_M /* 16318907 */:
                case FinalCanbus.CAR_443_WC2_Ford_Mustang_18_H /* 16384443 */:
                    temp *= 10;
                    findViewById(R.id.air_sp_tempvalue_rearleft).setVisibility(8);
                    findViewById(R.id.air_sp_tempunit_rearleft).setVisibility(8);
                    findViewById(R.id.air_sp_tempstate_rearleft).setVisibility(0);
                    mUpdateTempValue(R.id.air_sp_tempstate_rearleft, (temp % 100) / 10, false);
                    break;
                case FinalCanbus.CAR_RZC_18Zhihuiguan /* 655733 */:
                case FinalCanbus.CAR_RZC_18Zhihuiguan_H /* 786805 */:
                case FinalCanbus.CAR_RZC_20Zhihuiguan_EV /* 983413 */:
                case FinalCanbus.CAR_RZC_Dodge_JCUV /* 1114485 */:
                case FinalCanbus.CAR_RZC_Dodge_JCUV_H /* 2359669 */:
                case FinalCanbus.CAR_RZC_CHRYSLER_21PACIFICA /* 2556277 */:
                case FinalCanbus.CAR_RZC_CHRYSLER_21PACIFICA_H /* 2621813 */:
                case FinalCanbus.CAR_RZC_Dodge_15CHARGER /* 2687349 */:
                case FinalCanbus.CAR_RZC_Dodge_15CHARGER_H /* 2752885 */:
                case FinalCanbus.CAR_RZC_Dodge_17DURANGO /* 2818421 */:
                case FinalCanbus.CAR_RZC_Dodge_17DURANGO_H /* 2883957 */:
                case FinalCanbus.CAR_RZC_CHRYSLER_19PACIFICA_H /* 3211637 */:
                case FinalCanbus.CAR_RZC_Dodge_20RAM /* 3277173 */:
                    temp = ((temp - 12) * 5) + 140;
                    break;
                case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx /* 917956 */:
                case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx_H /* 983492 */:
                case FinalCanbus.CAR_439_LUZ_LEXUS_IS /* 3080631 */:
                case FinalCanbus.CAR_439_LUZ_LEXUS_IS_H /* 3146167 */:
                case FinalCanbus.CAR_439_LUZ_LEXUS_ES /* 3211703 */:
                case FinalCanbus.CAR_439_LUZ_LEXUS_ES_H /* 3277239 */:
                case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460 /* 5308868 */:
                case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460_H /* 5374404 */:
                case FinalCanbus.CAR_452_LZ_Toyota_LC100 /* 5439940 */:
                case FinalCanbus.CAR_452_LZ_Toyota_LC100_H /* 5505476 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 635;
                    } else {
                        temp = (temp * 5) + 175;
                    }
                    break;
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
                case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD /* 8913349 */:
                case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD_H /* 8978885 */:
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH /* 10420679 */:
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH_H /* 10486215 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300 /* 15008198 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER /* 15139270 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER_H /* 15532486 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300_H /* 15598022 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 635;
                    } else {
                        temp = (temp * 5) + 175;
                    }
                    break;
                case FinalCanbus.CAR_DJ_XC_TOYOTA_LEXUS /* 1049005 */:
                case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_14_TX /* 2425286 */:
                case FinalCanbus.CAR_455_RZC_Benz_Vito_24 /* 6291911 */:
                case FinalCanbus.CAR_455_RZC_Benz_Vito_24_H /* 6488519 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 10) + 310;
                    } else {
                        temp *= 5;
                    }
                    break;
                case FinalCanbus.CAR_RZC_19RongWei_RX8 /* 1310993 */:
                case FinalCanbus.CAR_RZC_18RongWei_RX8 /* 1638673 */:
                    temp = (temp * 10) + 150;
                    break;
                case FinalCanbus.CAR_455_LZ_GMC_Sierra_19_RScreen /* 1507783 */:
                case FinalCanbus.CAR_455_LZ_Chevrolet_Silverado_19_RScreen /* 1573319 */:
                case FinalCanbus.CAR_455_LZ_GM_Cadillac_CT5_Screen /* 5439943 */:
                case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_Screen /* 9437639 */:
                case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_Screen /* 9503175 */:
                case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_RScreen /* 9568711 */:
                case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_RScreen /* 9634247 */:
                case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
                case FinalCanbus.CAR_454_LZ_Chevrolet_Silverado_19_Screen /* 11993542 */:
                case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_4Screen /* 15729095 */:
                case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_4Screen /* 15794631 */:
                case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_8Screen /* 15860167 */:
                case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_8Screen /* 15925703 */:
                    if (temp >= 1 && temp <= 16) {
                        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                            temp = ((temp + 15) * 18) + 320;
                        } else {
                            temp = (temp * 10) + 150;
                        }
                    } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0 && SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 320;
                    } else {
                        temp *= 5;
                    }
                    break;
                case FinalCanbus.CAR_452_XinCheng_Infiniti_15QX60 /* 1900996 */:
                case FinalCanbus.CAR_452_XinCheng_Nissan_Tule_Top /* 7078343 */:
                case FinalCanbus.CAR_455_XinCheng_Nissan_20Tule_H /* 11665863 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 10) + 590;
                    } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 635;
                    } else {
                        temp = (temp * 5) + 175;
                    }
                    break;
                case FinalCanbus.CAR_RZC3_XianDai_19Palisade /* 2752959 */:
                case FinalCanbus.CAR_RZC3_XianDai_19Palisade_H /* 2818495 */:
                case FinalCanbus.CAR_RZC3_XianDai_20CARNIVAL /* 2884031 */:
                case FinalCanbus.CAR_RZC3_XianDai_20CARNIVAL_H /* 2949567 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_23Staria /* 3539391 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_23Staria_H /* 3604927 */:
                case FinalCanbus.CAR_455_RZC_Jianghuai_Sihao_X6 /* 8389063 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp *= 10;
                    } else {
                        temp = (temp * 5) + 170;
                    }
                    break;
                case FinalCanbus.CAR_452_DJ_Dodge_JCUV /* 4981188 */:
                case FinalCanbus.CAR_455_DJ_Dodge_JCUV_SCREEN /* 15991239 */:
                    temp = (temp * 10) + 130;
                    break;
                case FinalCanbus.CAR_452_XC_Rongwei_ALl /* 7471556 */:
                case FinalCanbus.CAR_452_XC_GM_ALl /* 7537092 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = ((((temp * 5) + 95) * 9) / 5) + 320;
                        ((TextView) findViewById(R.id.air_sp_temp_rear)).setText(new StringBuilder().append(temp / 10).toString());
                    } else {
                        temp = (temp * 5) + 95;
                    }
                    break;
            }
            mUpdateTempValue(R.id.air_sp_temp_rearleft1, temp / 100, false);
            mUpdateTempValue(R.id.air_sp_temp_rearleft2, (temp % 100) / 10, false);
            mUpdateTempValue(R.id.air_sp_temp_rearleft3, temp % 10, true);
            mUpdateTempUNIT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBackTempRight() {
        int temp = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT];
        if (findViewById(R.id.air_sp_temp_rearright1) != null) {
            if (temp == ConstAllAirDara.TEMPERATURE_LOW) {
                findViewById(R.id.air_sp_tempvalue_rearright).setVisibility(8);
                findViewById(R.id.air_sp_tempunit_rearright).setVisibility(8);
                findViewById(R.id.air_sp_tempstate_rearright).setVisibility(0);
                findViewById(R.id.air_sp_tempstate_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempstate_l);
                return;
            }
            if (temp == ConstAllAirDara.TEMPERATURE_HIGHT) {
                findViewById(R.id.air_sp_tempvalue_rearright).setVisibility(8);
                findViewById(R.id.air_sp_tempunit_rearright).setVisibility(8);
                findViewById(R.id.air_sp_tempstate_rearright).setVisibility(0);
                findViewById(R.id.air_sp_tempstate_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempstate_h);
                return;
            }
            if (temp == ConstAllAirDara.TEMPERATURE_NONE) {
                findViewById(R.id.air_sp_tempvalue_rearright).setVisibility(8);
                findViewById(R.id.air_sp_tempunit_rearright).setVisibility(8);
                findViewById(R.id.air_sp_tempstate_rearright).setVisibility(0);
                findViewById(R.id.air_sp_tempstate_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempstate_n);
                return;
            }
            findViewById(R.id.air_sp_tempvalue_rearright).setVisibility(0);
            findViewById(R.id.air_sp_tempunit_rearright).setVisibility(0);
            findViewById(R.id.air_sp_tempstate_rearright).setVisibility(8);
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_WC2_GM_GL8 /* 393252 */:
                case FinalCanbus.CAR_455_TD_INFINIT_ESQ /* 1704391 */:
                case FinalCanbus.CAR_455_TD_INFINIT_G /* 1769927 */:
                case FinalCanbus.CAR_455_TD_INFINIT_QX50 /* 1835463 */:
                case FinalCanbus.CAR_455_TD_INFINIT_06FX /* 1900999 */:
                case FinalCanbus.CAR_455_TD_INFINIT_08FX /* 1966535 */:
                case FinalCanbus.CAR_455_TD_INFINIT_14QX70 /* 2032071 */:
                case FinalCanbus.CAR_455_TD_INFINIT_12FX /* 2097607 */:
                case FinalCanbus.CAR_455_Tangdu_Nissan_10PATROL_L /* 4260295 */:
                case FinalCanbus.CAR_WC2_GM_Tahoe_15_Auto /* 5832740 */:
                case FinalCanbus.CAR_WC2_GM_Escalade_15_Auto /* 5898276 */:
                case FinalCanbus.CAR_WC2_GM_Escalade_07_Auto /* 5963812 */:
                case FinalCanbus.CAR_455_Tangdu_Nissan_22PATROL_Armada /* 10224071 */:
                case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_L /* 13763014 */:
                case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_H /* 13828550 */:
                    temp *= 5;
                    break;
                case FinalCanbus.CAR_RZC_Explorer /* 590158 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                case FinalCanbus.CAR_RZC_Ford_Explorer_24 /* 6160718 */:
                case FinalCanbus.CAR_RZC_Ford_Explorer_24_M /* 6226254 */:
                case FinalCanbus.CAR_RZC_Ford_Explorer_24_H /* 6291790 */:
                case FinalCanbus.CAR_452_XC_Ford_Escape_13_17 /* 6422980 */:
                case FinalCanbus.CAR_452_XC_Ford_edge_11_13 /* 6488516 */:
                case FinalCanbus.CAR_452_XC_Ford_Raptor_F150_09_14 /* 6554052 */:
                case FinalCanbus.CAR_452_XC_Ford_edge_15_17 /* 6619588 */:
                case FinalCanbus.CAR_443_WC2_Ford_EDGE_11 /* 6685115 */:
                case FinalCanbus.CAR_452_XC_Ford_Mondeo_13_18 /* 6685124 */:
                case FinalCanbus.CAR_443_WC2_Ford_EDGE_11_CD /* 6750651 */:
                case FinalCanbus.CAR_444_WC2_Ford_Escape_08_L /* 7274940 */:
                case FinalCanbus.CAR_444_WC2_Ford_Escape_08_M /* 7340476 */:
                case FinalCanbus.CAR_444_WC2_Ford_Escape_08_H /* 7406012 */:
                case FinalCanbus.CAR_444_WC2_Ford_KA_14 /* 7733692 */:
                case FinalCanbus.CAR_444_WC2_Ford_SAMX_15 /* 7799228 */:
                case FinalCanbus.CAR_444_WC2_Ford_TAURUS_18 /* 7864764 */:
                case FinalCanbus.CAR_444_WC2_Ford_Escape_20 /* 7930300 */:
                case FinalCanbus.CAR_444_WC2_Ford_Fusion_06_L /* 7995836 */:
                case FinalCanbus.CAR_444_WC2_Ford_Fusion_06_M /* 8061372 */:
                case FinalCanbus.CAR_444_WC2_Ford_Fusion_06_H /* 8126908 */:
                case FinalCanbus.CAR_444_WC2_Ford_Tourneo_15 /* 8192444 */:
                case FinalCanbus.CAR_444_WC2_Ford_Transit_20 /* 8257980 */:
                case FinalCanbus.CAR_444_WC2_Ford_Edge_06_L /* 8323516 */:
                case FinalCanbus.CAR_444_WC2_Ford_Edge_06_M /* 8389052 */:
                case FinalCanbus.CAR_444_WC2_Ford_Edge_06_H /* 8454588 */:
                case FinalCanbus.CAR_444_WC2_Ford_Edge_15_DWS /* 8520124 */:
                case FinalCanbus.CAR_444_WC2_Ford_Explorer_06_L /* 8585660 */:
                case FinalCanbus.CAR_444_WC2_Ford_Explorer_06_M /* 8651196 */:
                case FinalCanbus.CAR_444_WC2_Ford_Explorer_06_H /* 8716732 */:
                case FinalCanbus.CAR_444_WC2_Ford_Explorer_11 /* 8782268 */:
                case FinalCanbus.CAR_444_WC2_Ford_Explorer_11_CD /* 8847804 */:
                case FinalCanbus.CAR_444_WC2_Ford_Explorer_11_SP /* 8913340 */:
                case FinalCanbus.CAR_444_WC2_Ford_Everest_16 /* 8978876 */:
                case FinalCanbus.CAR_444_WC2_Ford_Everest_23 /* 9044412 */:
                case FinalCanbus.CAR_444_WC2_Ford_Ranger_16 /* 9109948 */:
                case FinalCanbus.CAR_444_WC2_Ford_Raptor_18 /* 9175484 */:
                case FinalCanbus.CAR_444_WC2_Ford_F150_04_L /* 9241020 */:
                case FinalCanbus.CAR_444_WC2_Ford_F150_04_M /* 9306556 */:
                case FinalCanbus.CAR_444_WC2_Ford_F150_04_H /* 9372092 */:
                case FinalCanbus.CAR_444_WC2_Ford_F250_04_L /* 9437628 */:
                case FinalCanbus.CAR_444_WC2_Ford_F250_04_M /* 9503164 */:
                case FinalCanbus.CAR_444_WC2_Ford_F250_04_H /* 9568700 */:
                case FinalCanbus.CAR_444_WC2_Ford_Mustang_05_L /* 9634236 */:
                case FinalCanbus.CAR_444_WC2_Ford_Mustang_05_M /* 9699772 */:
                case FinalCanbus.CAR_444_WC2_Ford_Mustang_05_H /* 9765308 */:
                case FinalCanbus.CAR_444_WC2_Ford_Expedition_03_L /* 9896380 */:
                case FinalCanbus.CAR_444_WC2_Ford_Expedition_03_M /* 9961916 */:
                case FinalCanbus.CAR_444_WC2_Ford_Expedition_03_H /* 10027452 */:
                case FinalCanbus.CAR_444_WC2_Ford_Yihu_12_CD /* 10092988 */:
                case FinalCanbus.CAR_444_WC2_Ford_Lincoln_Continental /* 10158524 */:
                case FinalCanbus.CAR_439_HC_Ford_Explorer /* 15335863 */:
                case FinalCanbus.CAR_443_WC2_Ford_F150_18 /* 15401403 */:
                case FinalCanbus.CAR_443_WC2_Ford_F150_18_CD /* 15466939 */:
                case FinalCanbus.CAR_443_WC2_Ford_F150_18_M /* 15729083 */:
                case FinalCanbus.CAR_443_WC2_Ford_F150_18_H /* 15794619 */:
                case FinalCanbus.CAR_443_WC2_Ford_F250_18_L /* 15860155 */:
                case FinalCanbus.CAR_443_WC2_Ford_F250_18_M /* 15925691 */:
                case FinalCanbus.CAR_443_WC2_Ford_F250_18_H /* 15991227 */:
                case FinalCanbus.CAR_443_WC2_Ford_F350_18_L /* 16056763 */:
                case FinalCanbus.CAR_443_WC2_Ford_F350_18_M /* 16122299 */:
                case FinalCanbus.CAR_443_WC2_Ford_F350_18_H /* 16187835 */:
                case FinalCanbus.CAR_443_WC2_Ford_Mustang_18_L /* 16253371 */:
                case FinalCanbus.CAR_443_WC2_Ford_Mustang_18_M /* 16318907 */:
                case FinalCanbus.CAR_443_WC2_Ford_Mustang_18_H /* 16384443 */:
                    temp *= 10;
                    findViewById(R.id.air_sp_tempvalue_rearright).setVisibility(8);
                    findViewById(R.id.air_sp_tempunit_rearright).setVisibility(8);
                    findViewById(R.id.air_sp_tempstate_rearright).setVisibility(0);
                    mUpdateTempValue(R.id.air_sp_tempstate_rearright, (temp % 100) / 10, false);
                    break;
                case FinalCanbus.CAR_RZC_18Zhihuiguan /* 655733 */:
                case FinalCanbus.CAR_RZC_18Zhihuiguan_H /* 786805 */:
                case FinalCanbus.CAR_RZC_20Zhihuiguan_EV /* 983413 */:
                case FinalCanbus.CAR_RZC_Dodge_JCUV /* 1114485 */:
                case FinalCanbus.CAR_RZC_Dodge_JCUV_H /* 2359669 */:
                case FinalCanbus.CAR_RZC_CHRYSLER_21PACIFICA /* 2556277 */:
                case FinalCanbus.CAR_RZC_CHRYSLER_21PACIFICA_H /* 2621813 */:
                case FinalCanbus.CAR_RZC_Dodge_15CHARGER /* 2687349 */:
                case FinalCanbus.CAR_RZC_Dodge_15CHARGER_H /* 2752885 */:
                case FinalCanbus.CAR_RZC_Dodge_17DURANGO /* 2818421 */:
                case FinalCanbus.CAR_RZC_Dodge_17DURANGO_H /* 2883957 */:
                case FinalCanbus.CAR_RZC_CHRYSLER_19PACIFICA_H /* 3211637 */:
                case FinalCanbus.CAR_RZC_Dodge_20RAM /* 3277173 */:
                    temp = ((temp - 12) * 5) + 140;
                    break;
                case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx /* 917956 */:
                case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx_H /* 983492 */:
                case FinalCanbus.CAR_439_LUZ_LEXUS_IS /* 3080631 */:
                case FinalCanbus.CAR_439_LUZ_LEXUS_IS_H /* 3146167 */:
                case FinalCanbus.CAR_439_LUZ_LEXUS_ES /* 3211703 */:
                case FinalCanbus.CAR_439_LUZ_LEXUS_ES_H /* 3277239 */:
                case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460 /* 5308868 */:
                case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460_H /* 5374404 */:
                case FinalCanbus.CAR_452_LZ_Toyota_LC100 /* 5439940 */:
                case FinalCanbus.CAR_452_LZ_Toyota_LC100_H /* 5505476 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 635;
                    } else {
                        temp = (temp * 5) + 175;
                    }
                    break;
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
                case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD /* 8913349 */:
                case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD_H /* 8978885 */:
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH /* 10420679 */:
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH_H /* 10486215 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300 /* 15008198 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER /* 15139270 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER_H /* 15532486 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300_H /* 15598022 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 635;
                    } else {
                        temp = (temp * 5) + 175;
                    }
                    break;
                case FinalCanbus.CAR_DJ_XC_TOYOTA_LEXUS /* 1049005 */:
                case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_14_TX /* 2425286 */:
                case FinalCanbus.CAR_455_RZC_Benz_Vito_24 /* 6291911 */:
                case FinalCanbus.CAR_455_RZC_Benz_Vito_24_H /* 6488519 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 10) + 310;
                    } else {
                        temp *= 5;
                    }
                    break;
                case FinalCanbus.CAR_RZC_19RongWei_RX8 /* 1310993 */:
                case FinalCanbus.CAR_RZC_18RongWei_RX8 /* 1638673 */:
                    temp = (temp * 10) + 150;
                    break;
                case FinalCanbus.CAR_455_LZ_GMC_Sierra_19_RScreen /* 1507783 */:
                case FinalCanbus.CAR_455_LZ_Chevrolet_Silverado_19_RScreen /* 1573319 */:
                case FinalCanbus.CAR_455_LZ_GM_Cadillac_CT5_Screen /* 5439943 */:
                case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_Screen /* 9437639 */:
                case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_Screen /* 9503175 */:
                case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_RScreen /* 9568711 */:
                case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_RScreen /* 9634247 */:
                case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
                case FinalCanbus.CAR_454_LZ_Chevrolet_Silverado_19_Screen /* 11993542 */:
                case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_4Screen /* 15729095 */:
                case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_4Screen /* 15794631 */:
                case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_8Screen /* 15860167 */:
                case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_8Screen /* 15925703 */:
                    if (temp >= 1 && temp <= 16) {
                        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                            temp = ((temp + 15) * 18) + 320;
                        } else {
                            temp = (temp * 10) + 150;
                        }
                    } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0 && SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 320;
                    } else {
                        temp *= 5;
                    }
                    break;
                case FinalCanbus.CAR_452_XinCheng_Infiniti_15QX60 /* 1900996 */:
                case FinalCanbus.CAR_452_XinCheng_Nissan_Tule_Top /* 7078343 */:
                case FinalCanbus.CAR_455_XinCheng_Nissan_20Tule_H /* 11665863 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 10) + 590;
                    } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 635;
                    } else {
                        temp = (temp * 5) + 175;
                    }
                    break;
                case FinalCanbus.CAR_RZC3_XianDai_19Palisade /* 2752959 */:
                case FinalCanbus.CAR_RZC3_XianDai_19Palisade_H /* 2818495 */:
                case FinalCanbus.CAR_RZC3_XianDai_20CARNIVAL /* 2884031 */:
                case FinalCanbus.CAR_RZC3_XianDai_20CARNIVAL_H /* 2949567 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_23Staria /* 3539391 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_23Staria_H /* 3604927 */:
                case FinalCanbus.CAR_455_RZC_Jianghuai_Sihao_X6 /* 8389063 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp *= 10;
                    } else {
                        temp = (temp * 5) + 170;
                    }
                    break;
                case FinalCanbus.CAR_452_DJ_Dodge_JCUV /* 4981188 */:
                case FinalCanbus.CAR_455_DJ_Dodge_JCUV_SCREEN /* 15991239 */:
                    temp = (temp * 10) + 130;
                    break;
                case FinalCanbus.CAR_452_XC_Rongwei_ALl /* 7471556 */:
                case FinalCanbus.CAR_452_XC_GM_ALl /* 7537092 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = ((((temp * 5) + 95) * 9) / 5) + 320;
                        ((TextView) findViewById(R.id.air_sp_temp_rear)).setText(new StringBuilder().append(temp / 10).toString());
                    } else {
                        temp = (temp * 5) + 95;
                    }
                    break;
            }
            mUpdateTempValue(R.id.air_sp_temp_rearright1, temp / 100, false);
            mUpdateTempValue(R.id.air_sp_temp_rearright2, (temp % 100) / 10, false);
            mUpdateTempValue(R.id.air_sp_temp_rearright3, temp % 10, true);
            mUpdateTempUNIT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT];
        if (findViewById(R.id.air_sp_temp_left1) != null) {
            if (temp == ConstAllAirDara.TEMPERATURE_LOW) {
                findViewById(R.id.air_sp_tempvalue_left).setVisibility(8);
                findViewById(R.id.air_sp_tempunit_left).setVisibility(8);
                findViewById(R.id.air_sp_tempstate_left).setVisibility(0);
                findViewById(R.id.air_sp_tempstate_left).setBackgroundResource(R.drawable.ic_hp_air_tempstate_l);
                return;
            }
            if (temp == ConstAllAirDara.TEMPERATURE_HIGHT) {
                findViewById(R.id.air_sp_tempvalue_left).setVisibility(8);
                findViewById(R.id.air_sp_tempunit_left).setVisibility(8);
                findViewById(R.id.air_sp_tempstate_left).setVisibility(0);
                findViewById(R.id.air_sp_tempstate_left).setBackgroundResource(R.drawable.ic_hp_air_tempstate_h);
                return;
            }
            if (temp == ConstAllAirDara.TEMPERATURE_NONE) {
                findViewById(R.id.air_sp_tempvalue_left).setVisibility(8);
                findViewById(R.id.air_sp_tempunit_left).setVisibility(8);
                findViewById(R.id.air_sp_tempstate_left).setVisibility(0);
                findViewById(R.id.air_sp_tempstate_left).setBackgroundResource(R.drawable.ic_hp_air_tempstate_n);
                return;
            }
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_LZ_Dodge_RAM1500_09 /* 655647 */:
                case FinalCanbus.CAR_LZ_Dodge_RAM2500_09 /* 721183 */:
                case FinalCanbus.CAR_LZ_Dodge_RAM3500_09 /* 786719 */:
                    findViewById(R.id.air_sp_tempvalue_left).setVisibility(8);
                    findViewById(R.id.air_sp_tempunit_left).setVisibility(8);
                    findViewById(R.id.air_sp_tempstate_left).setVisibility(0);
                    findViewById(R.id.air_sp_tempstate_left).setBackgroundResource(R.drawable.ic_hp_air_tempstate_n);
                    break;
                default:
                    findViewById(R.id.air_sp_tempvalue_left).setVisibility(0);
                    findViewById(R.id.air_sp_tempunit_left).setVisibility(0);
                    findViewById(R.id.air_sp_tempstate_left).setVisibility(8);
                    break;
            }
            switch (DataCanbus.DATA[1000]) {
                case 25:
                case 26:
                case FinalCanbus.CAR_XP1_GM_H1 /* 65561 */:
                case FinalCanbus.CAR_XP1_GM_H2 /* 131097 */:
                case FinalCanbus.CAR_XP1_GM_H3 /* 196633 */:
                case FinalCanbus.CAR_XP1_GM_Camaro_10 /* 262169 */:
                case FinalCanbus.CAR_XP1_GM_Silverado_14_Hand /* 458777 */:
                case FinalCanbus.CAR_XP1_GM_Silverado_14_Auto /* 524313 */:
                case FinalCanbus.CAR_XP1_GM_AJcd600 /* 2228249 */:
                case FinalCanbus.CAR_DJ_GM_ALL /* 2424857 */:
                case FinalCanbus.CAR_XP1_GM_AJcd650 /* 2490393 */:
                case FinalCanbus.CAR_XP1_GM_Opel_Meriva /* 2621465 */:
                case FinalCanbus.CAR_DJ_GM_Kopach /* 2687001 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0 && SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = ((((temp * 9) / 5) + 320) / 10) * 10;
                    }
                    break;
                case 36:
                case 345:
                case FinalCanbus.CAR_WC2_ShuPingJW /* 65881 */:
                case FinalCanbus.CAR_WC2_ShuPingKeLuZi /* 131417 */:
                case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao /* 196953 */:
                case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS /* 262489 */:
                case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS_S /* 328025 */:
                case FinalCanbus.CAR_WC2_GM_GL8 /* 393252 */:
                case FinalCanbus.CAR_WC2_GM_GL6 /* 458788 */:
                case FinalCanbus.CAR_WC2_ShuPing10JunYue /* 459097 */:
                case FinalCanbus.CAR_WC2_GM_WLD /* 524324 */:
                case FinalCanbus.CAR_WC2_ShuPingKeLuZi_Auto /* 524633 */:
                case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao_L /* 590169 */:
                case FinalCanbus.CAR_WC2_GM_EXCELLE_19 /* 655396 */:
                case FinalCanbus.CAR_WC2_GM_EXCELLE_18 /* 720932 */:
                case FinalCanbus.CAR_WC2_GM_GL8_10_13 /* 786468 */:
                case FinalCanbus.CAR_WC2_GM_GL8_14_16 /* 852004 */:
                case FinalCanbus.CAR_WC2_GM_Encore_12_15 /* 917540 */:
                case FinalCanbus.CAR_WC2_GM_Encore_16_19 /* 983076 */:
                case FinalCanbus.CAR_446_WY_HCX_BBA_Screen /* 983486 */:
                case FinalCanbus.CAR_WC2_GM_Regal_09_13 /* 1048612 */:
                case FinalCanbus.CAR_446_WY_HCX_BYD_TANG_Screen /* 1049022 */:
                case FinalCanbus.CAR_WC2_GM_Lacrosse_10_13 /* 1114148 */:
                case FinalCanbus.CAR_446_WY_HCX_BYD_QIN_Screen /* 1114558 */:
                case FinalCanbus.CAR_WC2_GM_Lacrosse_18 /* 1179684 */:
                case FinalCanbus.CAR_WC2_GM_Excelle_XT /* 1245220 */:
                case FinalCanbus.CAR_WC2_GM_Excelle_GT /* 1310756 */:
                case FinalCanbus.CAR_WC2_GM_AVEO_11 /* 1376292 */:
                case FinalCanbus.CAR_WC2_GM_Orlando_11 /* 1441828 */:
                case FinalCanbus.CAR_446_WY_HCX_WAY_VV7 /* 1442238 */:
                case FinalCanbus.CAR_WC2_GM_Trax_13_18 /* 1507364 */:
                case FinalCanbus.CAR_446_WY_HCX_WAY_P8 /* 1507774 */:
                case FinalCanbus.CAR_WC2_GM_Cruze_08_14 /* 1572900 */:
                case FinalCanbus.CAR_446_WY_HCX_WAY_VV5 /* 1573310 */:
                case FinalCanbus.CAR_WC2_GM_Cruze_15 /* 1638436 */:
                case FinalCanbus.CAR_446_WY_HCX_WAY_VV6 /* 1638846 */:
                case FinalCanbus.CAR_WC2_GM_Malibu_13 /* 1703972 */:
                case FinalCanbus.CAR_WC2_GM_Spin_13 /* 1769508 */:
                case FinalCanbus.CAR_WC2_GM_Astra_09_14 /* 1835044 */:
                case FinalCanbus.CAR_WC2_GM_Astra_15 /* 1900580 */:
                case FinalCanbus.CAR_WC2_GM_Mokka_12_16 /* 1966116 */:
                case FinalCanbus.CAR_WC2_GM_MokkaX_17 /* 2031652 */:
                case FinalCanbus.CAR_WC2_GM_Insignia_08_12 /* 2097188 */:
                case FinalCanbus.CAR_WC2_GM_Insignia_13_16 /* 2162724 */:
                case FinalCanbus.CAR_WC2_GM_Regal_14 /* 2228260 */:
                case FinalCanbus.CAR_WC2_GM_ENVISION_14 /* 2293796 */:
                case FinalCanbus.CAR_WC2_GM_Lacrosse_14 /* 2359332 */:
                case FinalCanbus.CAR_WC2_GM_Verano_15 /* 2424868 */:
                case FinalCanbus.CAR_WC2_GM_Verano_GS_16 /* 2490404 */:
                case FinalCanbus.CAR_WC2_GM_MalibuXL_16_18 /* 2555940 */:
                case FinalCanbus.CAR_WC2_GM_MalibuXL_19 /* 2621476 */:
                case FinalCanbus.CAR_WC2_GM_Equinox_17 /* 2687012 */:
                case FinalCanbus.CAR_WC2_GM_Sail3_15 /* 2752548 */:
                case FinalCanbus.CAR_WC2_GM_Onix_16 /* 2818084 */:
                case FinalCanbus.CAR_WC2_GM_LOVA_16_18 /* 2883620 */:
                case FinalCanbus.CAR_WC2_GM_Excelle_15_18 /* 2949156 */:
                case FinalCanbus.CAR_WC2_GM_Monza_19 /* 3014692 */:
                case FinalCanbus.CAR_WC2_GM_GL8_28T_ES /* 3080228 */:
                case FinalCanbus.CAR_WC2_GM_GL8_20 /* 3145764 */:
                case FinalCanbus.CAR_WC2_GM_Trax_19 /* 3211300 */:
                case FinalCanbus.CAR_WC2_GM_Trailblazer_20 /* 3276836 */:
                case FinalCanbus.CAR_WC2_GM_S10_12 /* 3342372 */:
                case FinalCanbus.CAR_WC2_GM_Karl_15 /* 3407908 */:
                case FinalCanbus.CAR_WC2_GM_Encore_GX_20 /* 3473444 */:
                case FinalCanbus.CAR_WC2_GM_Encore_20 /* 3538980 */:
                case FinalCanbus.CAR_WC2_GM_CorsaE_14_19 /* 3604516 */:
                case FinalCanbus.CAR_WC2_GM_Adam_13_19 /* 3670052 */:
                case FinalCanbus.CAR_WC2_GM_Insignia_17 /* 3735588 */:
                case FinalCanbus.CAR_WC2_GM_Sierra_14_18 /* 3801124 */:
                case FinalCanbus.CAR_WC2_GM_Trailblazer_14_18 /* 3866660 */:
                case FinalCanbus.CAR_WC2_GM_Suburban_15 /* 3932196 */:
                case FinalCanbus.CAR_WC2_GM_Tahoe_16_18 /* 3997732 */:
                case FinalCanbus.CAR_WC2_GM_Colorado_18 /* 4063268 */:
                case FinalCanbus.CAR_WC2_GM_Kopach_12 /* 4128804 */:
                case FinalCanbus.CAR_WC2_OPEL_Meriva_10 /* 4194340 */:
                case FinalCanbus.CAR_WC2_GM_Onix_14 /* 4259876 */:
                case FinalCanbus.CAR_WC2_GM_Onix_19 /* 4325412 */:
                case FinalCanbus.CAR_WC2_GM_Montana_23 /* 4390948 */:
                case FinalCanbus.CAR_444_WC2_JiangHuai_JiayueX7 /* 4391356 */:
                case FinalCanbus.CAR_WC2_GM_Tracker_19 /* 4456484 */:
                case FinalCanbus.CAR_444_WC2_JiangHuai_JiayueX7_H /* 4456892 */:
                case FinalCanbus.CAR_WC2_GM_Spin_Brazil_13 /* 4522020 */:
                case FinalCanbus.CAR_444_WC2_JiangHuai_RuifengS7 /* 4522428 */:
                case FinalCanbus.CAR_WC2_GM_S10_Brazil_10 /* 4587556 */:
                case FinalCanbus.CAR_444_WC2_JiangHuai_RuifengS7_H /* 4587964 */:
                case FinalCanbus.CAR_WC2_GM_EQUINOX_22 /* 4653092 */:
                case FinalCanbus.CAR_WC2_GM_EQUINOX_22_H /* 4718628 */:
                case FinalCanbus.CAR_WC2_GM_Colorado_14 /* 4784164 */:
                case FinalCanbus.CAR_WC2_GM_Colorado_14_H /* 4849700 */:
                case FinalCanbus.CAR_WC2_GM_Silverado_07 /* 4915236 */:
                case FinalCanbus.CAR_WC2_GM_Silverado_14 /* 4980772 */:
                case FinalCanbus.CAR_WC2_GM_Silverado_14_H /* 5046308 */:
                case FinalCanbus.CAR_WC2_GM_Canyon_14 /* 5111844 */:
                case FinalCanbus.CAR_WC2_GM_Canyon_14_H /* 5177380 */:
                case FinalCanbus.CAR_WC2_GMC_Acadia_07 /* 5242916 */:
                case FinalCanbus.CAR_WC2_GMC_Yukon_07 /* 5308452 */:
                case FinalCanbus.CAR_WC2_GMC_Savana_08 /* 5373988 */:
                case FinalCanbus.CAR_WC2_GMC_Sierra_07 /* 5439524 */:
                case FinalCanbus.CAR_WC2_GMC_Sierra_14 /* 5505060 */:
                case FinalCanbus.CAR_WC2_GMC_Sierra_14_H /* 5570596 */:
                case FinalCanbus.CAR_WC2_GM_ExpressVan_08 /* 5636132 */:
                case FinalCanbus.CAR_WC2_GM_Impala_06 /* 5701668 */:
                case FinalCanbus.CAR_WC2_GM_Avalanch_07 /* 5767204 */:
                case FinalCanbus.CAR_WC2_GM_Tahoe_15_Auto /* 5832740 */:
                case FinalCanbus.CAR_455_RZC_Sanlin_OULANDE_20Overseas /* 5833159 */:
                case FinalCanbus.CAR_WC2_GM_Escalade_15_Auto /* 5898276 */:
                case FinalCanbus.CAR_455_RZC_Sanlin_OULANDE_20Overseas_L /* 5898695 */:
                case FinalCanbus.CAR_WC2_GM_Escalade_07_Auto /* 5963812 */:
                case FinalCanbus.CAR_WC2_GM_XinJunWei2013 /* 6029348 */:
                case FinalCanbus.CAR_WC2_GM_SAIL3 /* 6094884 */:
                case FinalCanbus.CAR_WC2_GM_Excelle_19 /* 6160420 */:
                case FinalCanbus.CAR_WC2_GM_Excelle_21 /* 6225956 */:
                case FinalCanbus.CAR_WC2_GM_ExcelleGX_18 /* 6291492 */:
                case FinalCanbus.CAR_WC2_GM_Regal_14_NoAir /* 6357028 */:
                case FinalCanbus.CAR_455_LZ_Dodge_RAM1500 /* 6357447 */:
                case FinalCanbus.CAR_WC2_GM_Lacrosse_09_NoAir /* 6422564 */:
                case FinalCanbus.CAR_455_LZ_Dodge_RAM1500_H /* 6422983 */:
                case FinalCanbus.CAR_WC2_GM_Cruze_16_NoAir /* 6488100 */:
                case FinalCanbus.CAR_WC2_GM_Malibu_13_Hand /* 6553636 */:
                case FinalCanbus.CAR_WC2_GM_Malibu_13_Auto /* 6619172 */:
                case FinalCanbus.CAR_WC2_GM_Malibu_13_Auto_Double /* 6684708 */:
                case FinalCanbus.CAR_WC2_GM_Malibu_13_Top /* 6750244 */:
                case FinalCanbus.CAR_WC2_GM_Camaro_10 /* 6815780 */:
                case FinalCanbus.CAR_WC2_GM_Camaro_10_NoAIr /* 6881316 */:
                case FinalCanbus.CAR_WC2_GM_Colorado_14_NoAir /* 6946852 */:
                case FinalCanbus.CAR_WC2_GM_Silverado_14_NoAir /* 7012388 */:
                case FinalCanbus.CAR_444_WY_HCX_Chuanqi_21GS8_Screen /* 7012796 */:
                case FinalCanbus.CAR_WC2_GM_Silverado_19_NoAir /* 7077924 */:
                case FinalCanbus.CAR_WC2_GMC_Yukon_14 /* 7143460 */:
                case FinalCanbus.CAR_WC2_GMC_Yukon_14_H /* 7208996 */:
                case FinalCanbus.CAR_WC2_GMC_Terrain_10 /* 7274532 */:
                case FinalCanbus.CAR_WC2_GMC_Terrain_10_NoAir /* 7340068 */:
                case FinalCanbus.CAR_WC2_GM_EQUINOX_17 /* 7405604 */:
                case FinalCanbus.CAR_455_RZC_Sanlin_Triton_22 /* 8520135 */:
                case FinalCanbus.CAR_455_RZC_Sanlin_Triton_22t_H /* 8585671 */:
                case FinalCanbus.CAR_455_RZC_Sanlin_Triton_22_Top /* 8651207 */:
                case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport /* 10420678 */:
                case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport_H /* 10486214 */:
                case FinalCanbus.CAR_455_6606_LZ_Dodge_RAM1500 /* 14877127 */:
                case FinalCanbus.CAR_455_6606_LZ_Dodge_RAM1500_H /* 14942663 */:
                case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport_Top /* 16056774 */:
                    temp = (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] != 1 && SystemProperties.getInt("persist.fyt.temperature", 0) == 1) ? (temp * 9) + 320 : temp * 5;
                    break;
                case 38:
                case 101:
                case FinalCanbus.CAR_WC1_Nawala_Philippine /* 131110 */:
                case FinalCanbus.CAR_WC1_QiJun_H /* 131173 */:
                case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6 /* 131379 */:
                case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6_H /* 196915 */:
                case FinalCanbus.CAR_WC1_17QiJun /* 393317 */:
                case FinalCanbus.CAR_WC2_20BaoJun530_Auto /* 393462 */:
                case FinalCanbus.CAR_WC1_17QiJun_H /* 458853 */:
                case FinalCanbus.CAR_WC2_20BaoJun530_Hand /* 458998 */:
                case FinalCanbus.CAR_RZC_20BaoJunRS3 /* 459062 */:
                case FinalCanbus.CAR_WC1_Tuda /* 524389 */:
                case FinalCanbus.CAR_WC2_20BaoJunRS5 /* 524534 */:
                case FinalCanbus.CAR_WC1_19QiJun /* 589925 */:
                case FinalCanbus.CAR_WC2_20BaoJunRS5_H /* 590070 */:
                case FinalCanbus.CAR_OD_RZC_20BaoJunRS3 /* 590134 */:
                case FinalCanbus.CAR_WC1_Tuda_Hand /* 655461 */:
                case FinalCanbus.CAR_OD_RZC_Wuling_Xingchen /* 655670 */:
                case FinalCanbus.CAR_RZC_BenTeng_19B50_HAND /* 655773 */:
                case FinalCanbus.CAR_WC1_Nawala /* 720997 */:
                case FinalCanbus.CAR_RZC_Wuling_Xingchen /* 721206 */:
                case FinalCanbus.CAR_BNR_NISSAN_14QiJun_H /* 721220 */:
                case FinalCanbus.CAR_RZC_BenTeng_19B50_AUTO /* 721309 */:
                case FinalCanbus.CAR_WC1_Nawala_Hand /* 786533 */:
                case FinalCanbus.CAR_RZC_Wuling_Kaijie /* 786742 */:
                case FinalCanbus.CAR_BNR_NISSAN_14QiJun_L /* 786756 */:
                case FinalCanbus.CAR_WC1_Tuda_H /* 852069 */:
                case FinalCanbus.CAR_RZC_Wuling_Jiachen /* 852278 */:
                case FinalCanbus.CAR_BNR_NISSAN_16Xiaoke_L /* 852292 */:
                case FinalCanbus.CAR_RZC_20BaoJunRS3_Auto /* 917814 */:
                case FinalCanbus.CAR_BNR_NISSAN_13TianLai_H /* 917828 */:
                case FinalCanbus.CAR_RZC_Wuling_Xingchen_Auto /* 983350 */:
                case FinalCanbus.CAR_BNR_NISSAN_16Xiaoke_H /* 983364 */:
                case FinalCanbus.CAR_RZC_Wuling_Kaijie_Auto /* 1048886 */:
                case FinalCanbus.CAR_BNR_NISSAN_13TianLai_L /* 1048900 */:
                case FinalCanbus.CAR_RZC_Wuling_Jiachen_Auto /* 1114422 */:
                case FinalCanbus.CAR_BNR_NISSAN_08TianLai_H /* 1114436 */:
                case FinalCanbus.CAR_OD_RZC_BenTeng_B90 /* 1114525 */:
                case FinalCanbus.CAR_RZC_Wuling_Xingchi /* 1179958 */:
                case FinalCanbus.CAR_BNR_NISSAN_08TianLai_L /* 1179972 */:
                case FinalCanbus.CAR_RZC_17_18KeleiAo /* 1180050 */:
                case FinalCanbus.CAR_RZC_Wuling_Xingchi_Auto /* 1245494 */:
                case FinalCanbus.CAR_BNR_NISSAN_11QiDa_H /* 1245508 */:
                case FinalCanbus.CAR_OD_RZC_Wuling_23XingGuang /* 1311030 */:
                case FinalCanbus.CAR_BNR_NISSAN_11QiDa_L /* 1311044 */:
                case FinalCanbus.CAR_RZC_17_18KeleiAo_M /* 1311122 */:
                case FinalCanbus.CAR_BNR_NISSAN_14QiJun_RS /* 1376580 */:
                case FinalCanbus.CAR_RZC_17_18KeleiAo_H /* 1376658 */:
                case FinalCanbus.CAR_BNR_NISSAN_14QiJun_RS_L /* 1442116 */:
                case FinalCanbus.CAR_RZC_MEGANE_Turkey_L /* 1638802 */:
                case FinalCanbus.CAR_RZC_MEGANE_Turkey_M /* 1704338 */:
                case FinalCanbus.CAR_RZC_MEGANE_Turkey_H /* 1769874 */:
                case FinalCanbus.CAR_RZC_KADJAR_Turkey /* 1966482 */:
                case FinalCanbus.CAR_RZC_CLIO5_Turkey /* 2032018 */:
                case FinalCanbus.CAR_RZC_CLIO5_Turkey_M /* 2097554 */:
                case FinalCanbus.CAR_446_Xiaolin_WY_LEXUS_Screen /* 2097598 */:
                case FinalCanbus.CAR_RZC_CLIO5_Turkey_H /* 2163090 */:
                case FinalCanbus.CAR_446_Xiaolin_WY_LEXUS_Screen_H /* 2163134 */:
                case FinalCanbus.CAR_RZC_MEGANE_Turkey_L_AUTO /* 2228626 */:
                case FinalCanbus.CAR_RZC_Turkey_22KOLEOS_L /* 3604882 */:
                case FinalCanbus.CAR_RZC_Turkey_22KOLEOS_M /* 3670418 */:
                case FinalCanbus.CAR_RZC_Turkey_22KOLEOS_H /* 3735954 */:
                case FinalCanbus.CAR_RZC_Turkey_16KADJAR_L /* 3801490 */:
                case FinalCanbus.CAR_RZC_Turkey_16KADJAR_M /* 3867026 */:
                case FinalCanbus.CAR_RZC_Turkey_16KADJAR_H /* 3932562 */:
                case FinalCanbus.CAR_RZC_Turkey_22CAPTUR_L /* 3998098 */:
                case FinalCanbus.CAR_RZC_Turkey_22CAPTUR_M /* 4063634 */:
                case FinalCanbus.CAR_RZC_Turkey_22CAPTUR_H /* 4129170 */:
                case FinalCanbus.CAR_RZC_Turkey_22TRAFIC_L /* 4194706 */:
                case FinalCanbus.CAR_RZC_Turkey_22TRAFIC_M /* 4260242 */:
                case FinalCanbus.CAR_455_Tangdu_Nissan_10PATROL_L /* 4260295 */:
                case FinalCanbus.CAR_RZC_Turkey_22TRAFIC_H /* 4325778 */:
                case FinalCanbus.CAR_RZC_Turkey_22TALIANT_L /* 4391314 */:
                case FinalCanbus.CAR_RZC_Turkey_22TALIANT_M /* 4456850 */:
                case FinalCanbus.CAR_RZC_Turkey_22TALIANT_H /* 4522386 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_JOGGER_L /* 4587922 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_JOGGER_M /* 4653458 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_JOGGER_H /* 4718994 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_SANDERO_L /* 4784530 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_SANDERO_M /* 4850066 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_SANDERO_H /* 4915602 */:
                case FinalCanbus.CAR_RZC_Turkey_23MEGANE4_L /* 4981138 */:
                case FinalCanbus.CAR_RZC_Turkey_23MEGANE4_M /* 5046674 */:
                case FinalCanbus.CAR_RZC_Turkey_23MEGANE4_H /* 5112210 */:
                case FinalCanbus.CAR_RZC_Turkey_22TALISMAN_L /* 5177746 */:
                case FinalCanbus.CAR_RZC_Turkey_22TALISMAN_M /* 5243282 */:
                case FinalCanbus.CAR_RZC_Turkey_22TALISMAN_H /* 5308818 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_DUSTER_L /* 5374354 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_DUSTER_M /* 5439890 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_DUSTER_H /* 5505426 */:
                case FinalCanbus.CAR_RZC_Turkey_22EXPRESS_L /* 5570962 */:
                case FinalCanbus.CAR_RZC_Turkey_22EXPRESS_M /* 5636498 */:
                case FinalCanbus.CAR_RZC_Turkey_22EXPRESS_H /* 5702034 */:
                case FinalCanbus.CAR_RZC_Russian_20ARKANA_L /* 5767570 */:
                case FinalCanbus.CAR_455_RZC_Racing_EC75_25 /* 5767623 */:
                case FinalCanbus.CAR_RZC_Russian_20ARKANA_M /* 5833106 */:
                case FinalCanbus.CAR_RZC_Russian_20ARKANA_H /* 5898642 */:
                case FinalCanbus.CAR_452_LZ_TATA_ALL /* 5898692 */:
                case FinalCanbus.CAR_RZC_Turkey_22KADJAR_M /* 5964178 */:
                case FinalCanbus.CAR_RZC_CLIO5_Turkey_L_ATUO /* 6029714 */:
                case FinalCanbus.CAR_RZC_17LIENUO_M_NoAQS /* 6095250 */:
                case FinalCanbus.CAR_444_WY_LEXUS_Screen /* 6095292 */:
                case FinalCanbus.CAR_453_RZC_LandRover_Discovery_19 /* 6160837 */:
                case FinalCanbus.CAR_RZC_Renault_SM6_18 /* 6226322 */:
                case FinalCanbus.CAR_RZC_Renault_SCENIC_16 /* 6291858 */:
                case FinalCanbus.CAR_RZC_Renault_SM6_18_M /* 6357394 */:
                case FinalCanbus.CAR_RZC_Renault_SCENIC_16_M /* 6422930 */:
                case FinalCanbus.CAR_RZC_Renault_SM6_18_H /* 6488466 */:
                case FinalCanbus.CAR_444_WY_LEXUS_Screen_H /* 6488508 */:
                case FinalCanbus.CAR_RZC_Renault_SCENIC_16_H /* 6554002 */:
                case FinalCanbus.CAR_444_WC2_Beiqi_Zhixing_19 /* 6619580 */:
                case FinalCanbus.CAR_RZC_Renault_Dokker_18 /* 6750610 */:
                case FinalCanbus.CAR_RZC_Renault_Dokker_18_H /* 6816146 */:
                case FinalCanbus.CAR_RZC_17LIENUO_L_AUTO /* 6881682 */:
                case FinalCanbus.CAR_RZC_17LIENUO_M_NoAQS_2 /* 6947218 */:
                case FinalCanbus.CAR_RZC_Renault_QM6_18_L /* 7012754 */:
                case FinalCanbus.CAR_RZC_Renault_QM6_18_M /* 7078290 */:
                case FinalCanbus.CAR_RZC_Renault_QM6_18_H /* 7143826 */:
                case FinalCanbus.CAR_RZC_Renault_ZOE_22_L /* 7209362 */:
                case FinalCanbus.CAR_452_RZC_Subaru /* 7209412 */:
                case FinalCanbus.CAR_RZC_Renault_ZOE_22_M /* 7274898 */:
                case FinalCanbus.CAR_RZC_Renault_ZOE_22_H /* 7340434 */:
                case FinalCanbus.CAR_454_RZC_Racing_EC75_23 /* 7340486 */:
                case FinalCanbus.CAR_RZC_Renault_DUSTER_ETECH_24_L /* 7405970 */:
                case FinalCanbus.CAR_RZC_Renault_DUSTER_ETECH_24_M /* 7471506 */:
                case FinalCanbus.CAR_RZC_Renault_DUSTER_ETECH_24_H /* 7537042 */:
                case FinalCanbus.CAR_RZC_Renault_Kardian_24_L /* 7602578 */:
                case FinalCanbus.CAR_RZC_Renault_Kardian_24_M /* 7668114 */:
                case FinalCanbus.CAR_RZC_Renault_Kardian_24_H /* 7733650 */:
                case FinalCanbus.CAR_RZC_Renault_XM3_24_L /* 7799186 */:
                case FinalCanbus.CAR_RZC_Renault_XM3_24_M /* 7864722 */:
                case FinalCanbus.CAR_RZC_Renault_XM3_24_H /* 7930258 */:
                case FinalCanbus.CAR_453_LZ_ALFA_ROMEO /* 7930309 */:
                case FinalCanbus.CAR_RZC_Renault_ARKANAEV_25_L /* 7995794 */:
                case FinalCanbus.CAR_RZC_Renault_ARKANAEV_25_M /* 8061330 */:
                case FinalCanbus.CAR_RZC_Renault_ARKANAEV_25_H /* 8126866 */:
                case FinalCanbus.CAR_RZC_Nissan_Townstar_24_L /* 8192402 */:
                case FinalCanbus.CAR_RZC_Nissan_Townstar_24_M /* 8257938 */:
                case FinalCanbus.CAR_RZC_Nissan_Townstar_24_H /* 8323474 */:
                case FinalCanbus.CAR_454_RZC_Suburu_OUTBACK_18 /* 8323526 */:
                case FinalCanbus.CAR_RZC_Renault_SM6_18_LAuto /* 8389010 */:
                case FinalCanbus.CAR_RZC_Renault_SM6_18_M_NoAQS /* 8454546 */:
                case FinalCanbus.CAR_RZC_Renault_SM6_18_M_NoAQS2 /* 8520082 */:
                case FinalCanbus.CAR_RZC_Renault_QM6_18_LAuto /* 8585618 */:
                case FinalCanbus.CAR_RZC_Renault_QM6_18_M_NoAQS /* 8651154 */:
                case FinalCanbus.CAR_RZC_Renault_QM6_18_M_NoAQS2 /* 8716690 */:
                case FinalCanbus.CAR_455_RZC_Subaru_15 /* 8978887 */:
                case FinalCanbus.CAR_454_RZC_LandRover_Discovery_04 /* 9765318 */:
                case FinalCanbus.CAR_455_Tangdu_Nissan_22PATROL_Armada /* 10224071 */:
                case FinalCanbus.CAR_452_KYC_Zhonghua_All /* 10617284 */:
                case FinalCanbus.CAR_452_KYC_Zhonghua_All_H /* 10682820 */:
                case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7 /* 10748356 */:
                case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7_H /* 10813892 */:
                case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_L /* 13763014 */:
                case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_H /* 13828550 */:
                case FinalCanbus.CAR_455_RZC_LandRover_Ranger_11 /* 13959623 */:
                case FinalCanbus.CAR_455_RZC_LandRover_Ranger_10 /* 14025159 */:
                    temp *= 5;
                    break;
                case 40:
                case FinalCanbus.CAR_RZCexc_Feiyate_TORO /* 131111 */:
                case FinalCanbus.CAR_XP1_17MaiTeng /* 262184 */:
                case FinalCanbus.CAR_XP_MQB_Lamando /* 458792 */:
                case FinalCanbus.CAR_XP_MQB_Polo /* 524328 */:
                case FinalCanbus.CAR_XP_MQB_Passat_B8 /* 589864 */:
                case FinalCanbus.CAR_XP_MQB_Sportsvan /* 655400 */:
                case FinalCanbus.CAR_XP_MQB_TouranL /* 720936 */:
                case FinalCanbus.CAR_XP_MQB_Tiguan /* 786472 */:
                case FinalCanbus.CAR_XP_MQB_Terament /* 852008 */:
                case FinalCanbus.CAR_XP_MQB_Skoda_Octavia /* 917544 */:
                case FinalCanbus.CAR_XP_MQB_Skoda_Fabia /* 983080 */:
                case FinalCanbus.CAR_XP_MQB_Skoda_Superb /* 1048616 */:
                case FinalCanbus.CAR_RZC_XP1_BeiQiBJ40_21_H /* 1048972 */:
                case FinalCanbus.CAR_XP_MQB_Skoda_Kodiaq /* 1114152 */:
                case FinalCanbus.CAR_XP_MQB_Seat_LeonFR /* 1179688 */:
                case FinalCanbus.CAR_XP_MQB_Seat_Ateca /* 1245224 */:
                case FinalCanbus.CAR_XP_TuGuan_L_20_H /* 1376296 */:
                case FinalCanbus.CAR_RZCexc_Feiyate_TORO_M /* 1441831 */:
                case FinalCanbus.CAR_RZCexc_Feiyate_TORO_H /* 1507367 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 10) + 590;
                    } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 579;
                    } else {
                        temp = (temp * 5) + 155;
                    }
                    break;
                case 274:
                case FinalCanbus.CAR_DJ_XP1_ACCORD7_H /* 65810 */:
                    temp = SystemProperties.getInt("persist.fyt.temperature", 0) == 1 ? (temp * 18) + 320 : temp * 10;
                    break;
                case 276:
                case FinalCanbus.CAR_OD_Jiangxi_Wushiling_Mux /* 393638 */:
                case FinalCanbus.CAR_OD_Jiangxi_Lingtuo /* 459174 */:
                    temp = (temp * 10) + 170;
                    break;
                case 373:
                case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_H /* 65909 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_4Runner_Auto /* 65991 */:
                case FinalCanbus.CAR_RZC_XP1_ZiYouXia /* 131445 */:
                case FinalCanbus.CAR_RZC_XP1_GrdCherokee /* 196981 */:
                case FinalCanbus.CAR_RZC_17ZhiNanZhe /* 262517 */:
                case FinalCanbus.CAR_RZC_17ZhiNanZhe_H /* 328053 */:
                case FinalCanbus.CAR_RZC_18MuMaRen /* 393589 */:
                case FinalCanbus.CAR_RZC_XP1_GrdCherokee_H /* 459125 */:
                case FinalCanbus.CAR_RZC_18MuMaRen_H /* 524661 */:
                case FinalCanbus.CAR_RZC_19Tiaozhanzhe /* 590197 */:
                case FinalCanbus.CAR_RZC_18Zhihuiguan /* 655733 */:
                case FinalCanbus.CAR_RZC_19Tiaozhanzhe_H /* 721269 */:
                case FinalCanbus.CAR_RZC_18Zhihuiguan_H /* 786805 */:
                case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19 /* 852341 */:
                case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19_H /* 917877 */:
                case FinalCanbus.CAR_RZC_20Zhihuiguan_EV /* 983413 */:
                case FinalCanbus.CAR_RZC_Dodge_JCUV /* 1114485 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen /* 1114567 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen_3 /* 1180103 */:
                case FinalCanbus.CAR_RZC_Chrysler_300C_16 /* 1245557 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM /* 1311093 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_H /* 1376629 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_M /* 1835381 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_HY /* 1900917 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_HY_M /* 1966453 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_HY_H /* 2031989 */:
                case FinalCanbus.CAR_RZC_XP1_ZiYouXia_H /* 2163061 */:
                case FinalCanbus.CAR_RZC_Dodge_JCUV_H /* 2359669 */:
                case FinalCanbus.CAR_RZC_CHRYSLER_21PACIFICA /* 2556277 */:
                case FinalCanbus.CAR_RZC_CHRYSLER_21PACIFICA_H /* 2621813 */:
                case FinalCanbus.CAR_RZC_Dodge_15CHARGER /* 2687349 */:
                case FinalCanbus.CAR_RZC_Dodge_15CHARGER_H /* 2752885 */:
                case FinalCanbus.CAR_RZC_Dodge_17DURANGO /* 2818421 */:
                case FinalCanbus.CAR_RZC_Dodge_17DURANGO_H /* 2883957 */:
                case FinalCanbus.CAR_RZC_Jeep_22Gladiator /* 2949493 */:
                case FinalCanbus.CAR_RZC_Jeep_22Gladiator_H /* 3015029 */:
                case FinalCanbus.CAR_RZC_Jeep_18GrdCherokee /* 3080565 */:
                case FinalCanbus.CAR_RZC_Jeep_18GrdCherokee_H /* 3146101 */:
                case FinalCanbus.CAR_RZC_CHRYSLER_19PACIFICA_H /* 3211637 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_Proda_18 /* 3604935 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha /* 3670471 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha_3 /* 3736007 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_Proda_23 /* 4194759 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha_Screen_3 /* 4587975 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha_3_156inch /* 4784583 */:
                case FinalCanbus.CAR_455_HAITES_LZ_Toyota_Alpha_Xuanniu_2 /* 5243335 */:
                case FinalCanbus.CAR_455_HAITES_LZ_Toyota_Alpha_Xuanniu_3 /* 5308871 */:
                case FinalCanbus.CAR_455_HAITES_LZ_Toyota_Alpha_Xuanniu_3Screen /* 5505479 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_4Runner /* 15073734 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha /* 15204806 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha_3 /* 16187846 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] != 1 && SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = ((temp * 9) / 5) + 320;
                    }
                    break;
                case 397:
                case FinalCanbus.CAR_BNR_12Camry /* 524685 */:
                case FinalCanbus.CAR_XP1_Camry2018 /* 589844 */:
                case FinalCanbus.CAR_BNR_ShuPing_15_Camery /* 590221 */:
                case FinalCanbus.CAR_XP1_Camry2018_H /* 655380 */:
                case FinalCanbus.CAR_BNR_ShuPing_12LandCruise /* 655757 */:
                case FinalCanbus.CAR_BNR_ShuPing_16LandCruise /* 721293 */:
                case FinalCanbus.CAR_BNR_ShuPing_09Camery /* 786829 */:
                case FinalCanbus.CAR_BNR_ShuPing_07Corolla /* 1180045 */:
                case FinalCanbus.CAR_BNR_12Camry_AMP /* 1376653 */:
                case FinalCanbus.CAR_BNR_ShuPing_15_Camery_AMP /* 1442189 */:
                case FinalCanbus.CAR_BNR_ShuPing_12LandCruise_AMP /* 1507725 */:
                case FinalCanbus.CAR_BNR_ShuPing_16LandCruise_AMP /* 1573261 */:
                case FinalCanbus.CAR_BNR_05Reiz /* 1966477 */:
                case FinalCanbus.CAR_BNR_12Crown_L /* 2163085 */:
                case FinalCanbus.CAR_BNR_12Crown_M /* 2228621 */:
                case FinalCanbus.CAR_BNR_12Crown_H /* 2294157 */:
                case FinalCanbus.CAR_BNR_07_15LandCruise_AMP /* 2621837 */:
                case FinalCanbus.CAR_BNR_07_15LandCruise /* 2687373 */:
                case FinalCanbus.CAR_RZC_12Camry /* 2752909 */:
                case FinalCanbus.CAR_RZC_ShuPing_15_Camery /* 2818445 */:
                case FinalCanbus.CAR_RZC_ShuPing_12LandCruise /* 2883981 */:
                case FinalCanbus.CAR_RZC_ShuPing_16LandCruise /* 2949517 */:
                case FinalCanbus.CAR_RZC_ShuPing_09Camery /* 3015053 */:
                case FinalCanbus.CAR_RZC_ShuPing_09HighLand_L /* 3277197 */:
                case FinalCanbus.CAR_RZC_ShuPing_09HighLand_H /* 3342733 */:
                case FinalCanbus.CAR_RZC_ShuPing_07Corolla /* 3408269 */:
                case FinalCanbus.CAR_RZC_ShuPing_14Corolla /* 3473805 */:
                case FinalCanbus.CAR_RZC_12Camry_AMP /* 3604877 */:
                case FinalCanbus.CAR_RZC_ShuPing_15_Camery_AMP /* 3670413 */:
                case FinalCanbus.CAR_RZC_ShuPing_12LandCruise_AMP /* 3735949 */:
                case FinalCanbus.CAR_RZC_ShuPing_16LandCruise_AMP /* 3801485 */:
                case FinalCanbus.CAR_RZC_05Reiz /* 4194701 */:
                case FinalCanbus.CAR_RZC_12Crown_L /* 4391309 */:
                case FinalCanbus.CAR_RZC_12Crown_M /* 4456845 */:
                case FinalCanbus.CAR_RZC_12Crown_H /* 4522381 */:
                case FinalCanbus.CAR_RZC_07_15LandCruise_AMP /* 4850061 */:
                case FinalCanbus.CAR_RZC_07_15LandCruise /* 4915597 */:
                case FinalCanbus.CAR_RZC_18Camery /* 4981133 */:
                case FinalCanbus.CAR_RZC_16_18RAV4 /* 5046669 */:
                case FinalCanbus.CAR_RZC_13Reiz_TOP /* 5702029 */:
                case FinalCanbus.CAR_RZC_12Reiz /* 5767565 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0 && SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (((temp * 2) / 10) * 9) + 320;
                    }
                    break;
                case 429:
                case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_12Crown_AMP /* 65965 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_12Crown_AMP_H /* 131501 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_13Crown_AMP /* 197037 */:
                case FinalCanbus.CAR_CYT_YaGe7_38400 /* 262561 */:
                case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
                case FinalCanbus.CAR_RCW_BYD_10_11F6 /* 328097 */:
                case FinalCanbus.CAR_RCW_BYD_10_13G6 /* 393633 */:
                case FinalCanbus.CAR_RCW_YaGe7_38400 /* 459169 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_14Prodo_H_ShuPing /* 459181 */:
                case FinalCanbus.CAR_WC_YaGe7_38400 /* 524705 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_14Prodo_ShuPing /* 524717 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown /* 590253 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown /* 655789 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown_L /* 721325 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown_L /* 786861 */:
                case FinalCanbus.CAR_DAOJUN_OD_ATS /* 852316 */:
                case FinalCanbus.CAR_DJ_XC_Nissan_Tianlai_03_07 /* 852397 */:
                case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_10_13PRADO /* 917933 */:
                case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_08_15LAND_CRUISER /* 983469 */:
                case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_LEXUS /* 1049005 */:
                case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_HIGHLANDER /* 1114541 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_HIGHLANDER_H /* 1180077 */:
                case FinalCanbus.CAR_DJ_XC_Infiniti_FX35_03_09 /* 1245613 */:
                case FinalCanbus.CAR_455_RZC_Benz_Vito_24 /* 6291911 */:
                case FinalCanbus.CAR_455_RZC_Benz_Vito_24_H /* 6488519 */:
                    temp = SystemProperties.getInt("persist.fyt.temperature", 0) == 1 ? (temp * 9) + 320 : temp * 5;
                    break;
                case FinalCanbus.CAR_RZC_XP1_BeiQiM50F /* 65932 */:
                    temp *= 10;
                    findViewById(R.id.air_sp_tempvalue_left).setVisibility(8);
                    findViewById(R.id.air_sp_tempunit_left).setVisibility(8);
                    findViewById(R.id.air_sp_tempstate_left).setVisibility(0);
                    mUpdateTempValue(R.id.air_sp_tempstate_left, (temp % 100) / 10, false);
                    break;
                case FinalCanbus.CAR_452_XC_Tianlai_GJ /* 65988 */:
                case FinalCanbus.CAR_453_XC_Tianlai_GJ /* 1442245 */:
                case FinalCanbus.CAR_439_HC_Nissan_GuiShi /* 7799223 */:
                case FinalCanbus.CAR_439_LZ_INFINIT_FX35 /* 12714423 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 10) + 590;
                    } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 635;
                    } else {
                        temp = (temp * 5) + 175;
                    }
                    break;
                case FinalCanbus.CAR_456_OD_Hongqi_H5 /* 65992 */:
                case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx /* 917956 */:
                case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx_H /* 983492 */:
                case FinalCanbus.CAR_453_LZ_Toyota_REIZ_09 /* 1114565 */:
                case FinalCanbus.CAR_453_LZ_Toyota_REIZ_09_H /* 1180101 */:
                case FinalCanbus.CAR_439_Oudi_Haval_H3 /* 1704375 */:
                case FinalCanbus.CAR_439_LUZ_LEXUS_IS /* 3080631 */:
                case FinalCanbus.CAR_439_LUZ_LEXUS_IS_H /* 3146167 */:
                case FinalCanbus.CAR_439_LUZ_LEXUS_ES /* 3211703 */:
                case FinalCanbus.CAR_439_LUZ_LEXUS_ES_H /* 3277239 */:
                case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460 /* 5308868 */:
                case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460_H /* 5374404 */:
                case FinalCanbus.CAR_452_LZ_Toyota_LC100 /* 5439940 */:
                case FinalCanbus.CAR_452_LZ_Toyota_LC100_H /* 5505476 */:
                case FinalCanbus.CAR_452_OD_Zotye_T700 /* 6816196 */:
                case FinalCanbus.CAR_455_CZH_OD_Hongqi_EQM5_Huandian /* 7274951 */:
                case FinalCanbus.CAR_453_LZ_Toyota_markII_L /* 9634245 */:
                case FinalCanbus.CAR_453_LZ_Toyota_markII_H /* 9699781 */:
                case FinalCanbus.CAR_454_OD_Dongfeng_Nami01 /* 10617286 */:
                case FinalCanbus.CAR_454_OD_ChangAn_Raeton /* 14352838 */:
                case FinalCanbus.CAR_454_OD_ChangAn_Raeton_H /* 14418374 */:
                case FinalCanbus.CAR_454_CZH_OD_Hongqi_EQM5 /* 16515526 */:
                    temp = SystemProperties.getInt("persist.fyt.temperature", 0) == 1 ? (temp * 9) + 635 : (temp * 5) + 175;
                    break;
                case FinalCanbus.CAR_RZC_XP1_16HAIMAMV70 /* 131309 */:
                case FinalCanbus.CAR_RZC_XP1_HAIMA_F5 /* 262381 */:
                case FinalCanbus.CAR_452_XC_Ford_Escape_13_17 /* 6422980 */:
                case FinalCanbus.CAR_452_XC_Ford_edge_11_13 /* 6488516 */:
                case FinalCanbus.CAR_452_XC_Ford_Raptor_F150_09_14 /* 6554052 */:
                case FinalCanbus.CAR_452_XC_Ford_edge_15_17 /* 6619588 */:
                case FinalCanbus.CAR_452_XC_Ford_Mondeo_13_18 /* 6685124 */:
                case FinalCanbus.CAR_439_HC_Ford_Explorer /* 15335863 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp *= 10;
                    } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 320;
                    } else {
                        temp *= 5;
                    }
                    break;
                case FinalCanbus.CAR_RZC_SeMar_NoAmp /* 196688 */:
                case FinalCanbus.CAR_RZC_SwMar_Amp /* 262224 */:
                case FinalCanbus.CAR_RZC_Nissan_Tianlai_20 /* 721086 */:
                case FinalCanbus.CAR_RZC_Nissan_Tianlai_20_H /* 786622 */:
                case FinalCanbus.CAR_RZC_Nissan_Qijun_H /* 983230 */:
                case FinalCanbus.CAR_RZC_SwMar_17 /* 1441872 */:
                case FinalCanbus.CAR_RZC_SwMar_Amp_17 /* 1507408 */:
                case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_14 /* 1966270 */:
                case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_11 /* 2031806 */:
                case FinalCanbus.CAR_RZC_Nissan_PATROL_13 /* 2097342 */:
                case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_14_H /* 2228414 */:
                case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_11_H /* 2293950 */:
                case FinalCanbus.CAR_RZC_Nissan_PATROL_13_H /* 2359486 */:
                case FinalCanbus.CAR_RZC_Nissan_Xtrail_Import_22 /* 2425022 */:
                case FinalCanbus.CAR_RZC_Nissan_Xtrail_Import_22_H /* 2490558 */:
                case FinalCanbus.CAR_RZC_Nissan_Tuda_18 /* 2556094 */:
                case FinalCanbus.CAR_RZC_Nissan_Tuda_18_H /* 2621630 */:
                case FinalCanbus.CAR_RZC_Nissan_NAVANA_16 /* 2687166 */:
                case FinalCanbus.CAR_RZC_Nissan_NAVANA_16_H /* 2752702 */:
                case FinalCanbus.CAR_RZC_Nissan_SENTRA_18_Import /* 2818238 */:
                case FinalCanbus.CAR_RZC_Nissan_SENTRA_18_Import_H /* 2883774 */:
                case FinalCanbus.CAR_RZC_Nissan_TITAN_19_Import /* 2949310 */:
                case FinalCanbus.CAR_RZC_Nissan_TITAN_19_Import_H /* 3014846 */:
                case FinalCanbus.CAR_RZC_Nissan_SENTRA_13_Import /* 3080382 */:
                case FinalCanbus.CAR_RZC_Nissan_SENTRA_13_Import_H /* 3145918 */:
                case FinalCanbus.CAR_RZC_Sanlin_OULANDE_24Overseas /* 3276990 */:
                case FinalCanbus.CAR_RZC_Sanlin_OULANDE_24Overseas_H /* 3342526 */:
                case FinalCanbus.CAR_RZC_Sanlin_Triton_25Overseas /* 3539134 */:
                case FinalCanbus.CAR_RZC_Sanlin_Triton_25Overseas_H /* 3604670 */:
                case FinalCanbus.CAR_RZC_Nissan_Rogue_14Overseas /* 3670206 */:
                case FinalCanbus.CAR_RZC_Nissan_Rogue_14Overseas_H /* 3735742 */:
                case FinalCanbus.CAR_RZC_Nissan_Rogue_21Overseas /* 3801278 */:
                case FinalCanbus.CAR_RZC_Nissan_Rogue_21Overseas_H /* 3866814 */:
                case FinalCanbus.CAR_RZC_Nissan_Altima_19Overseas /* 3932350 */:
                case FinalCanbus.CAR_RZC_Nissan_Altima_19Overseas_H /* 3997886 */:
                case FinalCanbus.CAR_RZC_Nissan_Pathfinder_22Overseas /* 4063422 */:
                case FinalCanbus.CAR_RZC_Nissan_Pathfinder_22Overseas_H /* 4128958 */:
                case FinalCanbus.CAR_RZC_Nissan_Pathfinder_20Overseas /* 4653246 */:
                case FinalCanbus.CAR_RZC_Nissan_Pathfinder_20Overseas_H /* 4718782 */:
                case FinalCanbus.CAR_439_RZC_Nissan_19Qida /* 8585655 */:
                case FinalCanbus.CAR_439_RZC_Nissan_19Qida_H /* 8651191 */:
                    temp = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1 ? (temp * 10) + 440 : (temp * 5) + 80;
                    break;
                case FinalCanbus.CAR_RZC_HanTeng_H /* 196863 */:
                case FinalCanbus.CAR_Oudi_HanTeng_X5 /* 393471 */:
                case FinalCanbus.CAR_Oudi_XiaoYao /* 459007 */:
                case FinalCanbus.CAR_RZC_HanTeng_X5 /* 524543 */:
                    temp = temp < 16 ? (temp * 10) + 160 : temp * 5;
                    break;
                case FinalCanbus.CAR_XP1_YearGmcSeries_NoAir /* 459164 */:
                case FinalCanbus.CAR_RZC_Explorer /* 590158 */:
                case FinalCanbus.CAR_RZC_13_20Mengdiou /* 852302 */:
                case FinalCanbus.CAR_RZC_Mustang /* 1048910 */:
                case FinalCanbus.CAR_RZC_Ford_F150_12 /* 2294094 */:
                case FinalCanbus.CAR_RZC_Mustang_NO_CD /* 2359630 */:
                case FinalCanbus.CAR_RZC_Mustang_15_NO_CD /* 2621774 */:
                case FinalCanbus.CAR_RZC_Explorer_13 /* 3014990 */:
                case FinalCanbus.CAR_RZC_Ford_F150 /* 3080526 */:
                case FinalCanbus.CAR_RZC_Ford_Puma_22 /* 3670350 */:
                case FinalCanbus.CAR_RZC_Mustang_M /* 5374286 */:
                case FinalCanbus.CAR_RZC_Mustang_H /* 5439822 */:
                case FinalCanbus.CAR_RZC_Mustang_NOCD_M /* 5505358 */:
                case FinalCanbus.CAR_RZC_Mustang_NOCD_H /* 5570894 */:
                case FinalCanbus.CAR_RZC_Ford_Puma_22_M /* 5636430 */:
                case FinalCanbus.CAR_RZC_Ford_Puma_22_H /* 5701966 */:
                case FinalCanbus.CAR_RZC_Ford_BRONCO_22 /* 5767502 */:
                case FinalCanbus.CAR_RZC_Ford_BRONCO_22_M /* 5833038 */:
                case FinalCanbus.CAR_RZC_Ford_BRONCO_22_H /* 5898574 */:
                case FinalCanbus.CAR_RZC_Ford_MAVERICK_24 /* 5964110 */:
                case FinalCanbus.CAR_RZC_Ford_MAVERICK_24_M /* 6029646 */:
                case FinalCanbus.CAR_RZC_Ford_MAVERICK_24_H /* 6095182 */:
                case FinalCanbus.CAR_RZC_Ford_Explorer_24 /* 6160718 */:
                case FinalCanbus.CAR_RZC_Ford_Explorer_24_M /* 6226254 */:
                case FinalCanbus.CAR_RZC_Ford_Explorer_24_H /* 6291790 */:
                case FinalCanbus.CAR_RZC_Ford_RANGER_24 /* 6357326 */:
                case FinalCanbus.CAR_RZC_Ford_RANGER_24_M /* 6422862 */:
                case FinalCanbus.CAR_RZC_Ford_RANGER_24_H /* 6488398 */:
                case FinalCanbus.CAR_RZC_Ford_F250_09 /* 6553934 */:
                case FinalCanbus.CAR_RZC_Ford_Expedition_07 /* 6619470 */:
                case FinalCanbus.CAR_RZC_Ford_Expedition_15 /* 6685006 */:
                case FinalCanbus.CAR_RZC_Ford_Flex_13 /* 6750542 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = ((((temp * 9) / 5) + 320) / 10) * 10;
                    }
                    break;
                case FinalCanbus.CAR_RZC_OD_DongNanDX5 /* 590153 */:
                case FinalCanbus.CAR_439_DJ_LEXUS_ES /* 1245623 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_22Teana_Top /* 1572944 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_22Teana_Top_360View /* 1638480 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_16Trail /* 1704016 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_16Trail_H /* 1769552 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_16Xiaoke /* 1835088 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_16Xiaoke_H /* 1900624 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Xima_L /* 1966160 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Xima_H /* 2031696 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Loulan_L /* 2097232 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Loulan_H /* 2162768 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Tianlai_L /* 2228304 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Tianlai_H /* 2293840 */:
                case FinalCanbus.CAR_455_OD_Dongfeng_Racing_EC75_23H /* 2294215 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Xuanyi_L /* 2359376 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Xuanyi_H /* 2424912 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Lanniao_L /* 2490448 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Lannia_H /* 2555984 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Qida_L /* 2621520 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Qida_H /* 2687056 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Jinke_L /* 2752592 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Jinke_H /* 2818128 */:
                case FinalCanbus.CAR_439_DJ_LEXUS_ES_H /* 3801527 */:
                case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_Auto /* 5833156 */:
                case FinalCanbus.CAR_452_OD_HZ_Nezha /* 7602628 */:
                case FinalCanbus.CAR_BNR_02_09Toyato_Prado /* 7668151 */:
                case FinalCanbus.CAR_BNR_02_09Toyato_Prado_H /* 7733687 */:
                case FinalCanbus.CAR_454_OD_Dongfeng_Racing_EC75_23 /* 8454598 */:
                case FinalCanbus.CAR_455_OD_HZ_Nezha_H /* 9699783 */:
                case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_EV /* 10355140 */:
                case FinalCanbus.CAR_454_OD_Dongfeng_Tianlong /* 11403718 */:
                case FinalCanbus.CAR_452_OD_LeiDing_Mangguo_L /* 13107652 */:
                case FinalCanbus.CAR_452_OD_LeiDing_Mangguo_H /* 13173188 */:
                    temp = (temp * 5) + 175;
                    break;
                case FinalCanbus.CAR_RZC_19MingjueHS /* 852241 */:
                case FinalCanbus.CAR_RZC_19RongWei_I5 /* 917777 */:
                case FinalCanbus.CAR_RZC_19RongWei_I6 /* 983313 */:
                case FinalCanbus.CAR_RZC_19MingjueHS_H /* 1048849 */:
                case FinalCanbus.CAR_RZC_19RongWei_I5_H /* 1114385 */:
                case FinalCanbus.CAR_OD_RZC_ShangQiDaTong22G50 /* 1310985 */:
                case FinalCanbus.CAR_RZC_19RongWei_RX8 /* 1310993 */:
                case FinalCanbus.CAR_RZC_Mingjue_20ZS /* 1376529 */:
                case FinalCanbus.CAR_OD_RZC_ShangQiDaTong19G50 /* 1442057 */:
                case FinalCanbus.CAR_RZC_Mingjue_20ZS_H /* 1442065 */:
                case FinalCanbus.CAR_RZC_19Mingjue_MG6 /* 1507601 */:
                case FinalCanbus.CAR_OD_RZC_DaTong_25Dana_V1 /* 1638665 */:
                case FinalCanbus.CAR_RZC_18RongWei_RX8 /* 1638673 */:
                case FinalCanbus.CAR_OD_RZC_DaTong_25Dana_M1 /* 1704201 */:
                case FinalCanbus.CAR_RZC_20RongWei_RX5 /* 1704209 */:
                case FinalCanbus.CAR_RZC_MingJue_MG5_21 /* 1835281 */:
                case FinalCanbus.CAR_RZC_21RongWei_I5 /* 1900817 */:
                case FinalCanbus.CAR_RZC_21RongWei_I5_H /* 1966353 */:
                case FinalCanbus.CAR_RZC_MingJue_MG5_21_L /* 2031889 */:
                case FinalCanbus.CAR_CZH_RZC_19Mingjue_MG6 /* 2097425 */:
                case FinalCanbus.CAR_RZC_MingJue_MG5_22_Top /* 2162961 */:
                case FinalCanbus.CAR_RZC_23MingjueHS /* 2228497 */:
                case FinalCanbus.CAR_RZC_MingJue_MG5_25 /* 2294033 */:
                case FinalCanbus.CAR_RZC_23RongWei_I5 /* 2425105 */:
                case FinalCanbus.CAR_RZC_MingJue_MG5_21_Top /* 2490641 */:
                case FinalCanbus.CAR_RZC_MingJue_MG6_21_Pro /* 2556177 */:
                case FinalCanbus.CAR_454_OD_Xinte_DEV1_H /* 7274950 */:
                    temp *= 10;
                    break;
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
                case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD /* 8913349 */:
                case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD_H /* 8978885 */:
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH /* 10420679 */:
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH_H /* 10486215 */:
                case FinalCanbus.CAR_452_OD_Qirui_Xiaomayi /* 12517828 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300 /* 15008198 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER /* 15139270 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER_H /* 15532486 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300_H /* 15598022 */:
                    temp = (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) ? (temp * 9) + 635 : (temp * 5) + 175;
                    break;
                case FinalCanbus.CAR_455_LZ_GMC_Sierra_19_RScreen /* 1507783 */:
                case FinalCanbus.CAR_455_LZ_Chevrolet_Silverado_19_RScreen /* 1573319 */:
                case FinalCanbus.CAR_453_LZ_GM_Camaro_17 /* 2163141 */:
                case FinalCanbus.CAR_453_LZ_GM_GMC_TERRAIN_17 /* 2228677 */:
                case FinalCanbus.CAR_453_LZ_GM_Equinox_17 /* 2294213 */:
                case FinalCanbus.CAR_455_LZ_GM_Cadillac_CT5_Screen /* 5439943 */:
                case FinalCanbus.CAR_454_LZ_GM_Camaro_17_Auto /* 6947270 */:
                case FinalCanbus.CAR_454_LZ_GM_Equinox_17_Auto /* 7012806 */:
                case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_Screen /* 9437639 */:
                case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_Screen /* 9503175 */:
                case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_RScreen /* 9568711 */:
                case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_RScreen /* 9634247 */:
                case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
                case FinalCanbus.CAR_454_LZ_Chevrolet_Silverado_19_Screen /* 11993542 */:
                case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_4Screen /* 15729095 */:
                case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_4Screen /* 15794631 */:
                case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_8Screen /* 15860167 */:
                case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_8Screen /* 15925703 */:
                    if (temp >= 1 && temp <= 16) {
                        temp = SystemProperties.getInt("persist.fyt.temperature", 0) == 1 ? ((temp + 15) * 18) + 320 : (temp * 10) + 150;
                    } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0 && SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 320;
                    } else {
                        temp *= 5;
                    }
                    break;
                case FinalCanbus.CAR_452_XinCheng_Infiniti_ESQ /* 1573316 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_06FX /* 1638852 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_08FX /* 1704388 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_G /* 1769924 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_14QX50 /* 1835460 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_15QX60 /* 1900996 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_14QX70 /* 1966532 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_12FX /* 3998148 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_15Q50L /* 4063684 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_12JX35 /* 4129220 */:
                case FinalCanbus.CAR_455_XinCheng_Infiniti_18QX80 /* 6816199 */:
                case FinalCanbus.CAR_455_XinCheng_Infiniti_17QX30_Keep /* 6881735 */:
                case FinalCanbus.CAR_455_XinCheng_Infiniti_17QX30 /* 6947271 */:
                case FinalCanbus.CAR_455_XinCheng_Infiniti_17Q50 /* 7012807 */:
                case FinalCanbus.CAR_455_XinCheng_Infiniti_22QX50 /* 10355143 */:
                case FinalCanbus.CAR_455_XinCheng_Infiniti_15QX56 /* 11731399 */:
                case FinalCanbus.CAR_455_XinCheng_Nissan_11Loulan /* 11796935 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 10) - 160;
                    } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 320;
                    } else {
                        temp *= 5;
                    }
                    break;
                case FinalCanbus.CAR_452_XinCheng_Infiniti_13Q70L /* 2032068 */:
                case FinalCanbus.CAR_452_XinCheng_Nissan_Tule_H /* 5112260 */:
                case FinalCanbus.CAR_452_XinCheng_Nissan_Tule_Top /* 7078343 */:
                case FinalCanbus.CAR_455_XinCheng_Nissan_20Tule_H /* 11665863 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 10) - 160;
                    } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 320;
                    } else {
                        temp *= 5;
                    }
                    break;
                case FinalCanbus.CAR_454_Sanwu_Nissan_QX56_2004_Auto /* 3473862 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0 && SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = ((temp * 9) / 5) + 320;
                    }
                    break;
                case FinalCanbus.CAR_452_DJ_Dodge_JCUV /* 4981188 */:
                case FinalCanbus.CAR_455_DJ_Dodge_JCUV_SCREEN /* 15991239 */:
                    temp = (temp * 10) + 130;
                    break;
                case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9 /* 5702084 */:
                case FinalCanbus.CAR_455_LZ_Benz_C200_NTG5 /* 8192455 */:
                case FinalCanbus.CAR_454_RZC_Shanqi_DelongG2 /* 10027462 */:
                case FinalCanbus.CAR_455_LUZ_Benz_GLC_NTG50 /* 10027463 */:
                case FinalCanbus.CAR_439_DJ_Rongwei_i5 /* 13959607 */:
                case FinalCanbus.CAR_439_DJ_Rongwei_i5_H /* 14025143 */:
                    temp = (temp * 10) + 150;
                    break;
                case FinalCanbus.CAR_439_HC_Ruijie /* 6816183 */:
                case FinalCanbus.CAR_439_HC_Ruijie_H /* 6881719 */:
                    temp = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0 ? ((temp - 12) * 5) + 155 : ((temp - 12) * 10) + 600;
                    break;
                case FinalCanbus.CAR_RZC_HavalH6Couple_BLUE_TOP /* 7078327 */:
                case FinalCanbus.CAR_RZC_HavalH6Couple_RED_TOP /* 7143863 */:
                case FinalCanbus.CAR_RZC_XP1_HavalH6Couple_19 /* 7602615 */:
                case FinalCanbus.CAR_439_RZC_Haval_18_19H6 /* 11272631 */:
                    temp = ((temp - 116) * 5) + 180;
                    if (temp < 0) {
                        temp = 0;
                    }
                    break;
                case FinalCanbus.CAR_452_XC_Rongwei_ALl /* 7471556 */:
                case FinalCanbus.CAR_452_XC_GM_ALl /* 7537092 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = ((((temp * 5) + 95) * 9) / 5) + 320;
                        ((TextView) findViewById(R.id.air_sp_temp_rear)).setText(new StringBuilder().append(temp / 10).toString());
                    } else {
                        temp = (temp * 5) + 95;
                    }
                    break;
                case FinalCanbus.CAR_455_OD_CZH_Qichen_D60_EV /* 7799239 */:
                case FinalCanbus.CAR_455_YDT_OD_Qichen_D60_EV /* 8913351 */:
                case FinalCanbus.CAR_454_OD_Qichen_D60_EV /* 9961926 */:
                    temp = (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0 && SystemProperties.getInt("persist.fyt.temperature", 0) == 1) ? (temp * 9) + 320 : temp * 10;
                    break;
                case FinalCanbus.CAR_453_LZ_Jili_Boyue_18 /* 8782277 */:
                case FinalCanbus.CAR_453_LZ_Jili_Boyue_18_H /* 8847813 */:
                    temp = (temp >= 32 && temp <= 34) ? ((temp - 32) * 5) + 160 : (temp * 5) + 170;
                    break;
                case FinalCanbus.CAR_454_OD_Yutong_Qingka /* 11338182 */:
                    temp = (temp * 10) + 160;
                    break;
                case FinalCanbus.CAR_454_KYC_Ford_Mustang_07_H /* 13631942 */:
                case FinalCanbus.CAR_454_KYC_Ford_Mustang_07_L /* 13697478 */:
                    temp = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0 ? (temp * 10) + 310 : temp * 5;
                    break;
                case FinalCanbus.CAR_452_OD_ChangCheng_Fengjun5 /* 13763012 */:
                    temp = ((temp - 116) * 5) + 160;
                    if (temp < 0) {
                        temp = 0;
                    }
                    break;
            }
            mUpdateTempValue(R.id.air_sp_temp_left1, temp / 100, false);
            mUpdateTempValue(R.id.air_sp_temp_left2, (temp % 100) / 10, false);
            mUpdateTempValue(R.id.air_sp_temp_left3, temp % 10, true);
            mUpdateTempUNIT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTempRight() {
        int temp = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_RIGHT];
        if (findViewById(R.id.air_sp_temp_right1) != null) {
            if (temp == ConstAllAirDara.TEMPERATURE_LOW) {
                findViewById(R.id.air_sp_tempvalue_right).setVisibility(8);
                findViewById(R.id.air_sp_tempunit_right).setVisibility(8);
                findViewById(R.id.air_sp_tempstate_right).setVisibility(0);
                findViewById(R.id.air_sp_tempstate_right).setBackgroundResource(R.drawable.ic_hp_air_tempstate_l);
                return;
            }
            if (temp == ConstAllAirDara.TEMPERATURE_HIGHT) {
                findViewById(R.id.air_sp_tempvalue_right).setVisibility(8);
                findViewById(R.id.air_sp_tempunit_right).setVisibility(8);
                findViewById(R.id.air_sp_tempstate_right).setVisibility(0);
                findViewById(R.id.air_sp_tempstate_right).setBackgroundResource(R.drawable.ic_hp_air_tempstate_h);
                return;
            }
            if (temp == ConstAllAirDara.TEMPERATURE_NONE) {
                findViewById(R.id.air_sp_tempvalue_right).setVisibility(8);
                findViewById(R.id.air_sp_tempunit_right).setVisibility(8);
                findViewById(R.id.air_sp_tempstate_right).setVisibility(0);
                findViewById(R.id.air_sp_tempstate_right).setBackgroundResource(R.drawable.ic_hp_air_tempstate_n);
                return;
            }
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_LZ_Dodge_RAM1500_09 /* 655647 */:
                case FinalCanbus.CAR_LZ_Dodge_RAM2500_09 /* 721183 */:
                case FinalCanbus.CAR_LZ_Dodge_RAM3500_09 /* 786719 */:
                    findViewById(R.id.air_sp_tempvalue_right).setVisibility(8);
                    findViewById(R.id.air_sp_tempunit_right).setVisibility(8);
                    findViewById(R.id.air_sp_tempstate_right).setVisibility(0);
                    findViewById(R.id.air_sp_tempstate_right).setBackgroundResource(R.drawable.ic_hp_air_tempstate_n);
                    break;
                default:
                    findViewById(R.id.air_sp_tempvalue_right).setVisibility(0);
                    findViewById(R.id.air_sp_tempunit_right).setVisibility(0);
                    findViewById(R.id.air_sp_tempstate_right).setVisibility(8);
                    break;
            }
            switch (DataCanbus.DATA[1000]) {
                case 25:
                case 26:
                case FinalCanbus.CAR_XP1_GM_H1 /* 65561 */:
                case FinalCanbus.CAR_XP1_GM_H2 /* 131097 */:
                case FinalCanbus.CAR_XP1_GM_H3 /* 196633 */:
                case FinalCanbus.CAR_XP1_GM_Camaro_10 /* 262169 */:
                case FinalCanbus.CAR_XP1_GM_Silverado_14_Hand /* 458777 */:
                case FinalCanbus.CAR_XP1_GM_Silverado_14_Auto /* 524313 */:
                case FinalCanbus.CAR_XP1_GM_AJcd600 /* 2228249 */:
                case FinalCanbus.CAR_DJ_GM_ALL /* 2424857 */:
                case FinalCanbus.CAR_XP1_GM_AJcd650 /* 2490393 */:
                case FinalCanbus.CAR_XP1_GM_Opel_Meriva /* 2621465 */:
                case FinalCanbus.CAR_DJ_GM_Kopach /* 2687001 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0 && SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = ((((temp * 9) / 5) + 320) / 10) * 10;
                    }
                    break;
                case 36:
                case 345:
                case FinalCanbus.CAR_WC2_ShuPingJW /* 65881 */:
                case FinalCanbus.CAR_WC2_ShuPingKeLuZi /* 131417 */:
                case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao /* 196953 */:
                case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS /* 262489 */:
                case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS_S /* 328025 */:
                case FinalCanbus.CAR_WC2_GM_GL8 /* 393252 */:
                case FinalCanbus.CAR_WC2_GM_GL6 /* 458788 */:
                case FinalCanbus.CAR_WC2_ShuPing10JunYue /* 459097 */:
                case FinalCanbus.CAR_WC2_GM_WLD /* 524324 */:
                case FinalCanbus.CAR_WC2_ShuPingKeLuZi_Auto /* 524633 */:
                case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao_L /* 590169 */:
                case FinalCanbus.CAR_WC2_GM_EXCELLE_19 /* 655396 */:
                case FinalCanbus.CAR_WC2_GM_EXCELLE_18 /* 720932 */:
                case FinalCanbus.CAR_WC2_GM_GL8_10_13 /* 786468 */:
                case FinalCanbus.CAR_WC2_GM_GL8_14_16 /* 852004 */:
                case FinalCanbus.CAR_WC2_GM_Encore_12_15 /* 917540 */:
                case FinalCanbus.CAR_WC2_GM_Encore_16_19 /* 983076 */:
                case FinalCanbus.CAR_446_WY_HCX_BBA_Screen /* 983486 */:
                case FinalCanbus.CAR_WC2_GM_Regal_09_13 /* 1048612 */:
                case FinalCanbus.CAR_446_WY_HCX_BYD_TANG_Screen /* 1049022 */:
                case FinalCanbus.CAR_WC2_GM_Lacrosse_10_13 /* 1114148 */:
                case FinalCanbus.CAR_446_WY_HCX_BYD_QIN_Screen /* 1114558 */:
                case FinalCanbus.CAR_WC2_GM_Lacrosse_18 /* 1179684 */:
                case FinalCanbus.CAR_WC2_GM_Excelle_XT /* 1245220 */:
                case FinalCanbus.CAR_WC2_GM_Excelle_GT /* 1310756 */:
                case FinalCanbus.CAR_WC2_GM_AVEO_11 /* 1376292 */:
                case FinalCanbus.CAR_WC2_GM_Orlando_11 /* 1441828 */:
                case FinalCanbus.CAR_446_WY_HCX_WAY_VV7 /* 1442238 */:
                case FinalCanbus.CAR_WC2_GM_Trax_13_18 /* 1507364 */:
                case FinalCanbus.CAR_446_WY_HCX_WAY_P8 /* 1507774 */:
                case FinalCanbus.CAR_WC2_GM_Cruze_08_14 /* 1572900 */:
                case FinalCanbus.CAR_446_WY_HCX_WAY_VV5 /* 1573310 */:
                case FinalCanbus.CAR_WC2_GM_Cruze_15 /* 1638436 */:
                case FinalCanbus.CAR_446_WY_HCX_WAY_VV6 /* 1638846 */:
                case FinalCanbus.CAR_WC2_GM_Malibu_13 /* 1703972 */:
                case FinalCanbus.CAR_WC2_GM_Spin_13 /* 1769508 */:
                case FinalCanbus.CAR_WC2_GM_Astra_09_14 /* 1835044 */:
                case FinalCanbus.CAR_WC2_GM_Astra_15 /* 1900580 */:
                case FinalCanbus.CAR_WC2_GM_Mokka_12_16 /* 1966116 */:
                case FinalCanbus.CAR_WC2_GM_MokkaX_17 /* 2031652 */:
                case FinalCanbus.CAR_WC2_GM_Insignia_08_12 /* 2097188 */:
                case FinalCanbus.CAR_WC2_GM_Insignia_13_16 /* 2162724 */:
                case FinalCanbus.CAR_WC2_GM_Regal_14 /* 2228260 */:
                case FinalCanbus.CAR_WC2_GM_ENVISION_14 /* 2293796 */:
                case FinalCanbus.CAR_WC2_GM_Lacrosse_14 /* 2359332 */:
                case FinalCanbus.CAR_WC2_GM_Verano_15 /* 2424868 */:
                case FinalCanbus.CAR_WC2_GM_Verano_GS_16 /* 2490404 */:
                case FinalCanbus.CAR_WC2_GM_MalibuXL_16_18 /* 2555940 */:
                case FinalCanbus.CAR_WC2_GM_MalibuXL_19 /* 2621476 */:
                case FinalCanbus.CAR_WC2_GM_Equinox_17 /* 2687012 */:
                case FinalCanbus.CAR_WC2_GM_Sail3_15 /* 2752548 */:
                case FinalCanbus.CAR_WC2_GM_Onix_16 /* 2818084 */:
                case FinalCanbus.CAR_WC2_GM_LOVA_16_18 /* 2883620 */:
                case FinalCanbus.CAR_WC2_GM_Excelle_15_18 /* 2949156 */:
                case FinalCanbus.CAR_WC2_GM_Monza_19 /* 3014692 */:
                case FinalCanbus.CAR_WC2_GM_GL8_28T_ES /* 3080228 */:
                case FinalCanbus.CAR_WC2_GM_GL8_20 /* 3145764 */:
                case FinalCanbus.CAR_WC2_GM_Trax_19 /* 3211300 */:
                case FinalCanbus.CAR_WC2_GM_Trailblazer_20 /* 3276836 */:
                case FinalCanbus.CAR_WC2_GM_S10_12 /* 3342372 */:
                case FinalCanbus.CAR_WC2_GM_Karl_15 /* 3407908 */:
                case FinalCanbus.CAR_WC2_GM_Encore_GX_20 /* 3473444 */:
                case FinalCanbus.CAR_WC2_GM_Encore_20 /* 3538980 */:
                case FinalCanbus.CAR_WC2_GM_CorsaE_14_19 /* 3604516 */:
                case FinalCanbus.CAR_WC2_GM_Adam_13_19 /* 3670052 */:
                case FinalCanbus.CAR_WC2_GM_Insignia_17 /* 3735588 */:
                case FinalCanbus.CAR_WC2_GM_Sierra_14_18 /* 3801124 */:
                case FinalCanbus.CAR_WC2_GM_Trailblazer_14_18 /* 3866660 */:
                case FinalCanbus.CAR_WC2_GM_Suburban_15 /* 3932196 */:
                case FinalCanbus.CAR_WC2_GM_Tahoe_16_18 /* 3997732 */:
                case FinalCanbus.CAR_WC2_GM_Colorado_18 /* 4063268 */:
                case FinalCanbus.CAR_WC2_GM_Kopach_12 /* 4128804 */:
                case FinalCanbus.CAR_WC2_OPEL_Meriva_10 /* 4194340 */:
                case FinalCanbus.CAR_WC2_GM_Onix_14 /* 4259876 */:
                case FinalCanbus.CAR_WC2_GM_Onix_19 /* 4325412 */:
                case FinalCanbus.CAR_WC2_GM_Montana_23 /* 4390948 */:
                case FinalCanbus.CAR_444_WC2_JiangHuai_JiayueX7 /* 4391356 */:
                case FinalCanbus.CAR_WC2_GM_Tracker_19 /* 4456484 */:
                case FinalCanbus.CAR_444_WC2_JiangHuai_JiayueX7_H /* 4456892 */:
                case FinalCanbus.CAR_WC2_GM_Spin_Brazil_13 /* 4522020 */:
                case FinalCanbus.CAR_444_WC2_JiangHuai_RuifengS7 /* 4522428 */:
                case FinalCanbus.CAR_WC2_GM_S10_Brazil_10 /* 4587556 */:
                case FinalCanbus.CAR_444_WC2_JiangHuai_RuifengS7_H /* 4587964 */:
                case FinalCanbus.CAR_WC2_GM_EQUINOX_22 /* 4653092 */:
                case FinalCanbus.CAR_WC2_GM_EQUINOX_22_H /* 4718628 */:
                case FinalCanbus.CAR_WC2_GM_Colorado_14 /* 4784164 */:
                case FinalCanbus.CAR_WC2_GM_Colorado_14_H /* 4849700 */:
                case FinalCanbus.CAR_WC2_GM_Silverado_07 /* 4915236 */:
                case FinalCanbus.CAR_WC2_GM_Silverado_14 /* 4980772 */:
                case FinalCanbus.CAR_WC2_GM_Silverado_14_H /* 5046308 */:
                case FinalCanbus.CAR_WC2_GM_Canyon_14 /* 5111844 */:
                case FinalCanbus.CAR_WC2_GM_Canyon_14_H /* 5177380 */:
                case FinalCanbus.CAR_WC2_GMC_Acadia_07 /* 5242916 */:
                case FinalCanbus.CAR_WC2_GMC_Yukon_07 /* 5308452 */:
                case FinalCanbus.CAR_WC2_GMC_Savana_08 /* 5373988 */:
                case FinalCanbus.CAR_WC2_GMC_Sierra_07 /* 5439524 */:
                case FinalCanbus.CAR_WC2_GMC_Sierra_14 /* 5505060 */:
                case FinalCanbus.CAR_WC2_GMC_Sierra_14_H /* 5570596 */:
                case FinalCanbus.CAR_WC2_GM_ExpressVan_08 /* 5636132 */:
                case FinalCanbus.CAR_WC2_GM_Impala_06 /* 5701668 */:
                case FinalCanbus.CAR_WC2_GM_Avalanch_07 /* 5767204 */:
                case FinalCanbus.CAR_WC2_GM_Tahoe_15_Auto /* 5832740 */:
                case FinalCanbus.CAR_455_RZC_Sanlin_OULANDE_20Overseas /* 5833159 */:
                case FinalCanbus.CAR_WC2_GM_Escalade_15_Auto /* 5898276 */:
                case FinalCanbus.CAR_455_RZC_Sanlin_OULANDE_20Overseas_L /* 5898695 */:
                case FinalCanbus.CAR_WC2_GM_Escalade_07_Auto /* 5963812 */:
                case FinalCanbus.CAR_WC2_GM_XinJunWei2013 /* 6029348 */:
                case FinalCanbus.CAR_WC2_GM_SAIL3 /* 6094884 */:
                case FinalCanbus.CAR_WC2_GM_Excelle_19 /* 6160420 */:
                case FinalCanbus.CAR_WC2_GM_Excelle_21 /* 6225956 */:
                case FinalCanbus.CAR_WC2_GM_ExcelleGX_18 /* 6291492 */:
                case FinalCanbus.CAR_WC2_GM_Regal_14_NoAir /* 6357028 */:
                case FinalCanbus.CAR_455_LZ_Dodge_RAM1500 /* 6357447 */:
                case FinalCanbus.CAR_WC2_GM_Lacrosse_09_NoAir /* 6422564 */:
                case FinalCanbus.CAR_455_LZ_Dodge_RAM1500_H /* 6422983 */:
                case FinalCanbus.CAR_WC2_GM_Cruze_16_NoAir /* 6488100 */:
                case FinalCanbus.CAR_WC2_GM_Malibu_13_Hand /* 6553636 */:
                case FinalCanbus.CAR_WC2_GM_Malibu_13_Auto /* 6619172 */:
                case FinalCanbus.CAR_WC2_GM_Malibu_13_Auto_Double /* 6684708 */:
                case FinalCanbus.CAR_WC2_GM_Malibu_13_Top /* 6750244 */:
                case FinalCanbus.CAR_WC2_GM_Camaro_10 /* 6815780 */:
                case FinalCanbus.CAR_WC2_GM_Camaro_10_NoAIr /* 6881316 */:
                case FinalCanbus.CAR_WC2_GM_Colorado_14_NoAir /* 6946852 */:
                case FinalCanbus.CAR_WC2_GM_Silverado_14_NoAir /* 7012388 */:
                case FinalCanbus.CAR_444_WY_HCX_Chuanqi_21GS8_Screen /* 7012796 */:
                case FinalCanbus.CAR_WC2_GM_Silverado_19_NoAir /* 7077924 */:
                case FinalCanbus.CAR_WC2_GMC_Yukon_14 /* 7143460 */:
                case FinalCanbus.CAR_WC2_GMC_Yukon_14_H /* 7208996 */:
                case FinalCanbus.CAR_WC2_GMC_Terrain_10 /* 7274532 */:
                case FinalCanbus.CAR_WC2_GMC_Terrain_10_NoAir /* 7340068 */:
                case FinalCanbus.CAR_WC2_GM_EQUINOX_17 /* 7405604 */:
                case FinalCanbus.CAR_455_RZC_Sanlin_Triton_22 /* 8520135 */:
                case FinalCanbus.CAR_455_RZC_Sanlin_Triton_22t_H /* 8585671 */:
                case FinalCanbus.CAR_455_RZC_Sanlin_Triton_22_Top /* 8651207 */:
                case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport /* 10420678 */:
                case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport_H /* 10486214 */:
                case FinalCanbus.CAR_455_6606_LZ_Dodge_RAM1500 /* 14877127 */:
                case FinalCanbus.CAR_455_6606_LZ_Dodge_RAM1500_H /* 14942663 */:
                case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport_Top /* 16056774 */:
                    temp = (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] != 1 && SystemProperties.getInt("persist.fyt.temperature", 0) == 1) ? (temp * 9) + 320 : temp * 5;
                    break;
                case 38:
                case 101:
                case FinalCanbus.CAR_WC1_Nawala_Philippine /* 131110 */:
                case FinalCanbus.CAR_WC1_QiJun_H /* 131173 */:
                case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6 /* 131379 */:
                case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6_H /* 196915 */:
                case FinalCanbus.CAR_WC1_17QiJun /* 393317 */:
                case FinalCanbus.CAR_WC2_20BaoJun530_Auto /* 393462 */:
                case FinalCanbus.CAR_WC1_17QiJun_H /* 458853 */:
                case FinalCanbus.CAR_WC2_20BaoJun530_Hand /* 458998 */:
                case FinalCanbus.CAR_RZC_20BaoJunRS3 /* 459062 */:
                case FinalCanbus.CAR_WC1_Tuda /* 524389 */:
                case FinalCanbus.CAR_WC2_20BaoJunRS5 /* 524534 */:
                case FinalCanbus.CAR_WC1_19QiJun /* 589925 */:
                case FinalCanbus.CAR_WC2_20BaoJunRS5_H /* 590070 */:
                case FinalCanbus.CAR_OD_RZC_20BaoJunRS3 /* 590134 */:
                case FinalCanbus.CAR_WC1_Tuda_Hand /* 655461 */:
                case FinalCanbus.CAR_OD_RZC_Wuling_Xingchen /* 655670 */:
                case FinalCanbus.CAR_RZC_BenTeng_19B50_HAND /* 655773 */:
                case FinalCanbus.CAR_WC1_Nawala /* 720997 */:
                case FinalCanbus.CAR_RZC_Wuling_Xingchen /* 721206 */:
                case FinalCanbus.CAR_BNR_NISSAN_14QiJun_H /* 721220 */:
                case FinalCanbus.CAR_RZC_BenTeng_19B50_AUTO /* 721309 */:
                case FinalCanbus.CAR_WC1_Nawala_Hand /* 786533 */:
                case FinalCanbus.CAR_RZC_Wuling_Kaijie /* 786742 */:
                case FinalCanbus.CAR_BNR_NISSAN_14QiJun_L /* 786756 */:
                case FinalCanbus.CAR_WC1_Tuda_H /* 852069 */:
                case FinalCanbus.CAR_RZC_Wuling_Jiachen /* 852278 */:
                case FinalCanbus.CAR_BNR_NISSAN_16Xiaoke_L /* 852292 */:
                case FinalCanbus.CAR_RZC_20BaoJunRS3_Auto /* 917814 */:
                case FinalCanbus.CAR_BNR_NISSAN_13TianLai_H /* 917828 */:
                case FinalCanbus.CAR_RZC_Wuling_Xingchen_Auto /* 983350 */:
                case FinalCanbus.CAR_BNR_NISSAN_16Xiaoke_H /* 983364 */:
                case FinalCanbus.CAR_RZC_Wuling_Kaijie_Auto /* 1048886 */:
                case FinalCanbus.CAR_BNR_NISSAN_13TianLai_L /* 1048900 */:
                case FinalCanbus.CAR_RZC_Wuling_Jiachen_Auto /* 1114422 */:
                case FinalCanbus.CAR_BNR_NISSAN_08TianLai_H /* 1114436 */:
                case FinalCanbus.CAR_OD_RZC_BenTeng_B90 /* 1114525 */:
                case FinalCanbus.CAR_RZC_Wuling_Xingchi /* 1179958 */:
                case FinalCanbus.CAR_BNR_NISSAN_08TianLai_L /* 1179972 */:
                case FinalCanbus.CAR_RZC_17_18KeleiAo /* 1180050 */:
                case FinalCanbus.CAR_RZC_Wuling_Xingchi_Auto /* 1245494 */:
                case FinalCanbus.CAR_BNR_NISSAN_11QiDa_H /* 1245508 */:
                case FinalCanbus.CAR_OD_RZC_Wuling_23XingGuang /* 1311030 */:
                case FinalCanbus.CAR_BNR_NISSAN_11QiDa_L /* 1311044 */:
                case FinalCanbus.CAR_RZC_17_18KeleiAo_M /* 1311122 */:
                case FinalCanbus.CAR_BNR_NISSAN_14QiJun_RS /* 1376580 */:
                case FinalCanbus.CAR_RZC_17_18KeleiAo_H /* 1376658 */:
                case FinalCanbus.CAR_BNR_NISSAN_14QiJun_RS_L /* 1442116 */:
                case FinalCanbus.CAR_RZC_MEGANE_Turkey_L /* 1638802 */:
                case FinalCanbus.CAR_RZC_MEGANE_Turkey_M /* 1704338 */:
                case FinalCanbus.CAR_RZC_MEGANE_Turkey_H /* 1769874 */:
                case FinalCanbus.CAR_RZC_KADJAR_Turkey /* 1966482 */:
                case FinalCanbus.CAR_RZC_CLIO5_Turkey /* 2032018 */:
                case FinalCanbus.CAR_RZC_CLIO5_Turkey_M /* 2097554 */:
                case FinalCanbus.CAR_446_Xiaolin_WY_LEXUS_Screen /* 2097598 */:
                case FinalCanbus.CAR_RZC_CLIO5_Turkey_H /* 2163090 */:
                case FinalCanbus.CAR_446_Xiaolin_WY_LEXUS_Screen_H /* 2163134 */:
                case FinalCanbus.CAR_RZC_MEGANE_Turkey_L_AUTO /* 2228626 */:
                case FinalCanbus.CAR_RZC_Turkey_22KOLEOS_L /* 3604882 */:
                case FinalCanbus.CAR_RZC_Turkey_22KOLEOS_M /* 3670418 */:
                case FinalCanbus.CAR_RZC_Turkey_22KOLEOS_H /* 3735954 */:
                case FinalCanbus.CAR_RZC_Turkey_16KADJAR_L /* 3801490 */:
                case FinalCanbus.CAR_RZC_Turkey_16KADJAR_M /* 3867026 */:
                case FinalCanbus.CAR_RZC_Turkey_16KADJAR_H /* 3932562 */:
                case FinalCanbus.CAR_RZC_Turkey_22CAPTUR_L /* 3998098 */:
                case FinalCanbus.CAR_RZC_Turkey_22CAPTUR_M /* 4063634 */:
                case FinalCanbus.CAR_RZC_Turkey_22CAPTUR_H /* 4129170 */:
                case FinalCanbus.CAR_RZC_Turkey_22TRAFIC_L /* 4194706 */:
                case FinalCanbus.CAR_RZC_Turkey_22TRAFIC_M /* 4260242 */:
                case FinalCanbus.CAR_455_Tangdu_Nissan_10PATROL_L /* 4260295 */:
                case FinalCanbus.CAR_RZC_Turkey_22TRAFIC_H /* 4325778 */:
                case FinalCanbus.CAR_RZC_Turkey_22TALIANT_L /* 4391314 */:
                case FinalCanbus.CAR_RZC_Turkey_22TALIANT_M /* 4456850 */:
                case FinalCanbus.CAR_RZC_Turkey_22TALIANT_H /* 4522386 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_JOGGER_L /* 4587922 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_JOGGER_M /* 4653458 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_JOGGER_H /* 4718994 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_SANDERO_L /* 4784530 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_SANDERO_M /* 4850066 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_SANDERO_H /* 4915602 */:
                case FinalCanbus.CAR_RZC_Turkey_23MEGANE4_L /* 4981138 */:
                case FinalCanbus.CAR_RZC_Turkey_23MEGANE4_M /* 5046674 */:
                case FinalCanbus.CAR_RZC_Turkey_23MEGANE4_H /* 5112210 */:
                case FinalCanbus.CAR_RZC_Turkey_22TALISMAN_L /* 5177746 */:
                case FinalCanbus.CAR_RZC_Turkey_22TALISMAN_M /* 5243282 */:
                case FinalCanbus.CAR_RZC_Turkey_22TALISMAN_H /* 5308818 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_DUSTER_L /* 5374354 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_DUSTER_M /* 5439890 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_DUSTER_H /* 5505426 */:
                case FinalCanbus.CAR_RZC_Turkey_22EXPRESS_L /* 5570962 */:
                case FinalCanbus.CAR_RZC_Turkey_22EXPRESS_M /* 5636498 */:
                case FinalCanbus.CAR_RZC_Turkey_22EXPRESS_H /* 5702034 */:
                case FinalCanbus.CAR_RZC_Russian_20ARKANA_L /* 5767570 */:
                case FinalCanbus.CAR_455_RZC_Racing_EC75_25 /* 5767623 */:
                case FinalCanbus.CAR_RZC_Russian_20ARKANA_M /* 5833106 */:
                case FinalCanbus.CAR_RZC_Russian_20ARKANA_H /* 5898642 */:
                case FinalCanbus.CAR_452_LZ_TATA_ALL /* 5898692 */:
                case FinalCanbus.CAR_RZC_Turkey_22KADJAR_M /* 5964178 */:
                case FinalCanbus.CAR_RZC_CLIO5_Turkey_L_ATUO /* 6029714 */:
                case FinalCanbus.CAR_RZC_17LIENUO_M_NoAQS /* 6095250 */:
                case FinalCanbus.CAR_444_WY_LEXUS_Screen /* 6095292 */:
                case FinalCanbus.CAR_453_RZC_LandRover_Discovery_19 /* 6160837 */:
                case FinalCanbus.CAR_RZC_Renault_SM6_18 /* 6226322 */:
                case FinalCanbus.CAR_RZC_Renault_SCENIC_16 /* 6291858 */:
                case FinalCanbus.CAR_RZC_Renault_SM6_18_M /* 6357394 */:
                case FinalCanbus.CAR_RZC_Renault_SCENIC_16_M /* 6422930 */:
                case FinalCanbus.CAR_RZC_Renault_SM6_18_H /* 6488466 */:
                case FinalCanbus.CAR_444_WY_LEXUS_Screen_H /* 6488508 */:
                case FinalCanbus.CAR_RZC_Renault_SCENIC_16_H /* 6554002 */:
                case FinalCanbus.CAR_444_WC2_Beiqi_Zhixing_19 /* 6619580 */:
                case FinalCanbus.CAR_RZC_Renault_Dokker_18 /* 6750610 */:
                case FinalCanbus.CAR_RZC_Renault_Dokker_18_H /* 6816146 */:
                case FinalCanbus.CAR_RZC_17LIENUO_L_AUTO /* 6881682 */:
                case FinalCanbus.CAR_RZC_17LIENUO_M_NoAQS_2 /* 6947218 */:
                case FinalCanbus.CAR_RZC_Renault_QM6_18_L /* 7012754 */:
                case FinalCanbus.CAR_RZC_Renault_QM6_18_M /* 7078290 */:
                case FinalCanbus.CAR_RZC_Renault_QM6_18_H /* 7143826 */:
                case FinalCanbus.CAR_RZC_Renault_ZOE_22_L /* 7209362 */:
                case FinalCanbus.CAR_452_RZC_Subaru /* 7209412 */:
                case FinalCanbus.CAR_RZC_Renault_ZOE_22_M /* 7274898 */:
                case FinalCanbus.CAR_RZC_Renault_ZOE_22_H /* 7340434 */:
                case FinalCanbus.CAR_454_RZC_Racing_EC75_23 /* 7340486 */:
                case FinalCanbus.CAR_RZC_Renault_DUSTER_ETECH_24_L /* 7405970 */:
                case FinalCanbus.CAR_RZC_Renault_DUSTER_ETECH_24_M /* 7471506 */:
                case FinalCanbus.CAR_RZC_Renault_DUSTER_ETECH_24_H /* 7537042 */:
                case FinalCanbus.CAR_RZC_Renault_Kardian_24_L /* 7602578 */:
                case FinalCanbus.CAR_RZC_Renault_Kardian_24_M /* 7668114 */:
                case FinalCanbus.CAR_RZC_Renault_Kardian_24_H /* 7733650 */:
                case FinalCanbus.CAR_RZC_Renault_XM3_24_L /* 7799186 */:
                case FinalCanbus.CAR_RZC_Renault_XM3_24_M /* 7864722 */:
                case FinalCanbus.CAR_RZC_Renault_XM3_24_H /* 7930258 */:
                case FinalCanbus.CAR_453_LZ_ALFA_ROMEO /* 7930309 */:
                case FinalCanbus.CAR_RZC_Renault_ARKANAEV_25_L /* 7995794 */:
                case FinalCanbus.CAR_RZC_Renault_ARKANAEV_25_M /* 8061330 */:
                case FinalCanbus.CAR_RZC_Renault_ARKANAEV_25_H /* 8126866 */:
                case FinalCanbus.CAR_RZC_Nissan_Townstar_24_L /* 8192402 */:
                case FinalCanbus.CAR_RZC_Nissan_Townstar_24_M /* 8257938 */:
                case FinalCanbus.CAR_RZC_Nissan_Townstar_24_H /* 8323474 */:
                case FinalCanbus.CAR_454_RZC_Suburu_OUTBACK_18 /* 8323526 */:
                case FinalCanbus.CAR_RZC_Renault_SM6_18_LAuto /* 8389010 */:
                case FinalCanbus.CAR_RZC_Renault_SM6_18_M_NoAQS /* 8454546 */:
                case FinalCanbus.CAR_RZC_Renault_SM6_18_M_NoAQS2 /* 8520082 */:
                case FinalCanbus.CAR_RZC_Renault_QM6_18_LAuto /* 8585618 */:
                case FinalCanbus.CAR_RZC_Renault_QM6_18_M_NoAQS /* 8651154 */:
                case FinalCanbus.CAR_RZC_Renault_QM6_18_M_NoAQS2 /* 8716690 */:
                case FinalCanbus.CAR_455_RZC_Subaru_15 /* 8978887 */:
                case FinalCanbus.CAR_454_RZC_LandRover_Discovery_04 /* 9765318 */:
                case FinalCanbus.CAR_455_Tangdu_Nissan_22PATROL_Armada /* 10224071 */:
                case FinalCanbus.CAR_452_KYC_Zhonghua_All /* 10617284 */:
                case FinalCanbus.CAR_452_KYC_Zhonghua_All_H /* 10682820 */:
                case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7 /* 10748356 */:
                case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7_H /* 10813892 */:
                case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_L /* 13763014 */:
                case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_H /* 13828550 */:
                case FinalCanbus.CAR_455_RZC_LandRover_Ranger_11 /* 13959623 */:
                case FinalCanbus.CAR_455_RZC_LandRover_Ranger_10 /* 14025159 */:
                    temp *= 5;
                    break;
                case 40:
                case FinalCanbus.CAR_RZCexc_Feiyate_TORO /* 131111 */:
                case FinalCanbus.CAR_XP1_17MaiTeng /* 262184 */:
                case FinalCanbus.CAR_XP_MQB_Lamando /* 458792 */:
                case FinalCanbus.CAR_XP_MQB_Polo /* 524328 */:
                case FinalCanbus.CAR_XP_MQB_Passat_B8 /* 589864 */:
                case FinalCanbus.CAR_XP_MQB_Sportsvan /* 655400 */:
                case FinalCanbus.CAR_XP_MQB_TouranL /* 720936 */:
                case FinalCanbus.CAR_XP_MQB_Tiguan /* 786472 */:
                case FinalCanbus.CAR_XP_MQB_Terament /* 852008 */:
                case FinalCanbus.CAR_XP_MQB_Skoda_Octavia /* 917544 */:
                case FinalCanbus.CAR_XP_MQB_Skoda_Fabia /* 983080 */:
                case FinalCanbus.CAR_XP_MQB_Skoda_Superb /* 1048616 */:
                case FinalCanbus.CAR_RZC_XP1_BeiQiBJ40_21_H /* 1048972 */:
                case FinalCanbus.CAR_XP_MQB_Skoda_Kodiaq /* 1114152 */:
                case FinalCanbus.CAR_XP_MQB_Seat_LeonFR /* 1179688 */:
                case FinalCanbus.CAR_XP_MQB_Seat_Ateca /* 1245224 */:
                case FinalCanbus.CAR_XP_TuGuan_L_20_H /* 1376296 */:
                case FinalCanbus.CAR_RZCexc_Feiyate_TORO_M /* 1441831 */:
                case FinalCanbus.CAR_RZCexc_Feiyate_TORO_H /* 1507367 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 10) + 590;
                    } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 579;
                    } else {
                        temp = (temp * 5) + 155;
                    }
                    break;
                case 274:
                case FinalCanbus.CAR_DJ_XP1_ACCORD7_H /* 65810 */:
                    temp = SystemProperties.getInt("persist.fyt.temperature", 0) == 1 ? (temp * 18) + 320 : temp * 10;
                    break;
                case 276:
                case FinalCanbus.CAR_OD_Jiangxi_Wushiling_Mux /* 393638 */:
                case FinalCanbus.CAR_OD_Jiangxi_Lingtuo /* 459174 */:
                    temp = (temp * 10) + 170;
                    break;
                case 373:
                case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_H /* 65909 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_4Runner_Auto /* 65991 */:
                case FinalCanbus.CAR_RZC_XP1_ZiYouXia /* 131445 */:
                case FinalCanbus.CAR_RZC_XP1_GrdCherokee /* 196981 */:
                case FinalCanbus.CAR_RZC_17ZhiNanZhe /* 262517 */:
                case FinalCanbus.CAR_RZC_17ZhiNanZhe_H /* 328053 */:
                case FinalCanbus.CAR_RZC_18MuMaRen /* 393589 */:
                case FinalCanbus.CAR_RZC_XP1_GrdCherokee_H /* 459125 */:
                case FinalCanbus.CAR_RZC_18MuMaRen_H /* 524661 */:
                case FinalCanbus.CAR_RZC_19Tiaozhanzhe /* 590197 */:
                case FinalCanbus.CAR_RZC_18Zhihuiguan /* 655733 */:
                case FinalCanbus.CAR_RZC_19Tiaozhanzhe_H /* 721269 */:
                case FinalCanbus.CAR_RZC_18Zhihuiguan_H /* 786805 */:
                case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19 /* 852341 */:
                case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19_H /* 917877 */:
                case FinalCanbus.CAR_RZC_20Zhihuiguan_EV /* 983413 */:
                case FinalCanbus.CAR_RZC_Dodge_JCUV /* 1114485 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen /* 1114567 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen_3 /* 1180103 */:
                case FinalCanbus.CAR_RZC_Chrysler_300C_16 /* 1245557 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM /* 1311093 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_H /* 1376629 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_M /* 1835381 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_HY /* 1900917 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_HY_M /* 1966453 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_HY_H /* 2031989 */:
                case FinalCanbus.CAR_RZC_XP1_ZiYouXia_H /* 2163061 */:
                case FinalCanbus.CAR_RZC_Dodge_JCUV_H /* 2359669 */:
                case FinalCanbus.CAR_RZC_CHRYSLER_21PACIFICA /* 2556277 */:
                case FinalCanbus.CAR_RZC_CHRYSLER_21PACIFICA_H /* 2621813 */:
                case FinalCanbus.CAR_RZC_Dodge_15CHARGER /* 2687349 */:
                case FinalCanbus.CAR_RZC_Dodge_15CHARGER_H /* 2752885 */:
                case FinalCanbus.CAR_RZC_Dodge_17DURANGO /* 2818421 */:
                case FinalCanbus.CAR_RZC_Dodge_17DURANGO_H /* 2883957 */:
                case FinalCanbus.CAR_RZC_Jeep_22Gladiator /* 2949493 */:
                case FinalCanbus.CAR_RZC_Jeep_22Gladiator_H /* 3015029 */:
                case FinalCanbus.CAR_RZC_Jeep_18GrdCherokee /* 3080565 */:
                case FinalCanbus.CAR_RZC_Jeep_18GrdCherokee_H /* 3146101 */:
                case FinalCanbus.CAR_RZC_CHRYSLER_19PACIFICA_H /* 3211637 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_Proda_18 /* 3604935 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha /* 3670471 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha_3 /* 3736007 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_Proda_23 /* 4194759 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha_Screen_3 /* 4587975 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha_3_156inch /* 4784583 */:
                case FinalCanbus.CAR_455_HAITES_LZ_Toyota_Alpha_Xuanniu_2 /* 5243335 */:
                case FinalCanbus.CAR_455_HAITES_LZ_Toyota_Alpha_Xuanniu_3 /* 5308871 */:
                case FinalCanbus.CAR_455_HAITES_LZ_Toyota_Alpha_Xuanniu_3Screen /* 5505479 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_4Runner /* 15073734 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha /* 15204806 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha_3 /* 16187846 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] != 1 && SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = ((temp * 9) / 5) + 320;
                    }
                    break;
                case 397:
                case FinalCanbus.CAR_BNR_12Camry /* 524685 */:
                case FinalCanbus.CAR_XP1_Camry2018 /* 589844 */:
                case FinalCanbus.CAR_BNR_ShuPing_15_Camery /* 590221 */:
                case FinalCanbus.CAR_XP1_Camry2018_H /* 655380 */:
                case FinalCanbus.CAR_BNR_ShuPing_12LandCruise /* 655757 */:
                case FinalCanbus.CAR_BNR_ShuPing_16LandCruise /* 721293 */:
                case FinalCanbus.CAR_BNR_ShuPing_09Camery /* 786829 */:
                case FinalCanbus.CAR_BNR_ShuPing_07Corolla /* 1180045 */:
                case FinalCanbus.CAR_BNR_12Camry_AMP /* 1376653 */:
                case FinalCanbus.CAR_BNR_ShuPing_15_Camery_AMP /* 1442189 */:
                case FinalCanbus.CAR_BNR_ShuPing_12LandCruise_AMP /* 1507725 */:
                case FinalCanbus.CAR_BNR_ShuPing_16LandCruise_AMP /* 1573261 */:
                case FinalCanbus.CAR_BNR_05Reiz /* 1966477 */:
                case FinalCanbus.CAR_BNR_12Crown_L /* 2163085 */:
                case FinalCanbus.CAR_BNR_12Crown_M /* 2228621 */:
                case FinalCanbus.CAR_BNR_12Crown_H /* 2294157 */:
                case FinalCanbus.CAR_BNR_07_15LandCruise_AMP /* 2621837 */:
                case FinalCanbus.CAR_BNR_07_15LandCruise /* 2687373 */:
                case FinalCanbus.CAR_RZC_12Camry /* 2752909 */:
                case FinalCanbus.CAR_RZC_ShuPing_15_Camery /* 2818445 */:
                case FinalCanbus.CAR_RZC_ShuPing_12LandCruise /* 2883981 */:
                case FinalCanbus.CAR_RZC_ShuPing_16LandCruise /* 2949517 */:
                case FinalCanbus.CAR_RZC_ShuPing_09Camery /* 3015053 */:
                case FinalCanbus.CAR_RZC_ShuPing_09HighLand_L /* 3277197 */:
                case FinalCanbus.CAR_RZC_ShuPing_09HighLand_H /* 3342733 */:
                case FinalCanbus.CAR_RZC_ShuPing_07Corolla /* 3408269 */:
                case FinalCanbus.CAR_RZC_ShuPing_14Corolla /* 3473805 */:
                case FinalCanbus.CAR_RZC_12Camry_AMP /* 3604877 */:
                case FinalCanbus.CAR_RZC_ShuPing_15_Camery_AMP /* 3670413 */:
                case FinalCanbus.CAR_RZC_ShuPing_12LandCruise_AMP /* 3735949 */:
                case FinalCanbus.CAR_RZC_ShuPing_16LandCruise_AMP /* 3801485 */:
                case FinalCanbus.CAR_RZC_05Reiz /* 4194701 */:
                case FinalCanbus.CAR_RZC_12Crown_L /* 4391309 */:
                case FinalCanbus.CAR_RZC_12Crown_M /* 4456845 */:
                case FinalCanbus.CAR_RZC_12Crown_H /* 4522381 */:
                case FinalCanbus.CAR_RZC_07_15LandCruise_AMP /* 4850061 */:
                case FinalCanbus.CAR_RZC_07_15LandCruise /* 4915597 */:
                case FinalCanbus.CAR_RZC_18Camery /* 4981133 */:
                case FinalCanbus.CAR_RZC_16_18RAV4 /* 5046669 */:
                case FinalCanbus.CAR_RZC_13Reiz_TOP /* 5702029 */:
                case FinalCanbus.CAR_RZC_12Reiz /* 5767565 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0 && SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (((temp * 2) / 10) * 9) + 320;
                    }
                    break;
                case 429:
                case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_12Crown_AMP /* 65965 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_12Crown_AMP_H /* 131501 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_13Crown_AMP /* 197037 */:
                case FinalCanbus.CAR_CYT_YaGe7_38400 /* 262561 */:
                case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
                case FinalCanbus.CAR_RCW_BYD_10_11F6 /* 328097 */:
                case FinalCanbus.CAR_RCW_BYD_10_13G6 /* 393633 */:
                case FinalCanbus.CAR_RCW_YaGe7_38400 /* 459169 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_14Prodo_H_ShuPing /* 459181 */:
                case FinalCanbus.CAR_WC_YaGe7_38400 /* 524705 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_14Prodo_ShuPing /* 524717 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown /* 590253 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown /* 655789 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown_L /* 721325 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown_L /* 786861 */:
                case FinalCanbus.CAR_DAOJUN_OD_ATS /* 852316 */:
                case FinalCanbus.CAR_DJ_XC_Nissan_Tianlai_03_07 /* 852397 */:
                case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_10_13PRADO /* 917933 */:
                case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_08_15LAND_CRUISER /* 983469 */:
                case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_LEXUS /* 1049005 */:
                case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_HIGHLANDER /* 1114541 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_HIGHLANDER_H /* 1180077 */:
                case FinalCanbus.CAR_DJ_XC_Infiniti_FX35_03_09 /* 1245613 */:
                case FinalCanbus.CAR_455_RZC_Benz_Vito_24 /* 6291911 */:
                case FinalCanbus.CAR_455_RZC_Benz_Vito_24_H /* 6488519 */:
                    temp = SystemProperties.getInt("persist.fyt.temperature", 0) == 1 ? (temp * 9) + 320 : temp * 5;
                    break;
                case FinalCanbus.CAR_RZC_XP1_BeiQiM50F /* 65932 */:
                    temp *= 10;
                    findViewById(R.id.air_sp_tempvalue_right).setVisibility(8);
                    findViewById(R.id.air_sp_tempunit_right).setVisibility(8);
                    findViewById(R.id.air_sp_tempstate_right).setVisibility(0);
                    mUpdateTempValue(R.id.air_sp_tempstate_right, (temp % 100) / 10, false);
                    break;
                case FinalCanbus.CAR_452_XC_Tianlai_GJ /* 65988 */:
                case FinalCanbus.CAR_453_XC_Tianlai_GJ /* 1442245 */:
                case FinalCanbus.CAR_439_HC_Nissan_GuiShi /* 7799223 */:
                case FinalCanbus.CAR_439_LZ_INFINIT_FX35 /* 12714423 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 10) + 590;
                    } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 635;
                    } else {
                        temp = (temp * 5) + 175;
                    }
                    break;
                case FinalCanbus.CAR_456_OD_Hongqi_H5 /* 65992 */:
                case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx /* 917956 */:
                case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx_H /* 983492 */:
                case FinalCanbus.CAR_453_LZ_Toyota_REIZ_09 /* 1114565 */:
                case FinalCanbus.CAR_453_LZ_Toyota_REIZ_09_H /* 1180101 */:
                case FinalCanbus.CAR_439_Oudi_Haval_H3 /* 1704375 */:
                case FinalCanbus.CAR_439_LUZ_LEXUS_IS /* 3080631 */:
                case FinalCanbus.CAR_439_LUZ_LEXUS_IS_H /* 3146167 */:
                case FinalCanbus.CAR_439_LUZ_LEXUS_ES /* 3211703 */:
                case FinalCanbus.CAR_439_LUZ_LEXUS_ES_H /* 3277239 */:
                case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460 /* 5308868 */:
                case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460_H /* 5374404 */:
                case FinalCanbus.CAR_452_LZ_Toyota_LC100 /* 5439940 */:
                case FinalCanbus.CAR_452_LZ_Toyota_LC100_H /* 5505476 */:
                case FinalCanbus.CAR_452_OD_Zotye_T700 /* 6816196 */:
                case FinalCanbus.CAR_455_CZH_OD_Hongqi_EQM5_Huandian /* 7274951 */:
                case FinalCanbus.CAR_453_LZ_Toyota_markII_L /* 9634245 */:
                case FinalCanbus.CAR_453_LZ_Toyota_markII_H /* 9699781 */:
                case FinalCanbus.CAR_454_OD_Dongfeng_Nami01 /* 10617286 */:
                case FinalCanbus.CAR_454_OD_ChangAn_Raeton /* 14352838 */:
                case FinalCanbus.CAR_454_OD_ChangAn_Raeton_H /* 14418374 */:
                case FinalCanbus.CAR_454_CZH_OD_Hongqi_EQM5 /* 16515526 */:
                    temp = SystemProperties.getInt("persist.fyt.temperature", 0) == 1 ? (temp * 9) + 635 : (temp * 5) + 175;
                    break;
                case FinalCanbus.CAR_RZC_XP1_16HAIMAMV70 /* 131309 */:
                case FinalCanbus.CAR_RZC_XP1_HAIMA_F5 /* 262381 */:
                case FinalCanbus.CAR_452_XC_Ford_Escape_13_17 /* 6422980 */:
                case FinalCanbus.CAR_452_XC_Ford_edge_11_13 /* 6488516 */:
                case FinalCanbus.CAR_452_XC_Ford_Raptor_F150_09_14 /* 6554052 */:
                case FinalCanbus.CAR_452_XC_Ford_edge_15_17 /* 6619588 */:
                case FinalCanbus.CAR_452_XC_Ford_Mondeo_13_18 /* 6685124 */:
                case FinalCanbus.CAR_439_HC_Ford_Explorer /* 15335863 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp *= 10;
                    } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 320;
                    } else {
                        temp *= 5;
                    }
                    break;
                case FinalCanbus.CAR_RZC_SeMar_NoAmp /* 196688 */:
                case FinalCanbus.CAR_RZC_SwMar_Amp /* 262224 */:
                case FinalCanbus.CAR_RZC_Nissan_Tianlai_20 /* 721086 */:
                case FinalCanbus.CAR_RZC_Nissan_Tianlai_20_H /* 786622 */:
                case FinalCanbus.CAR_RZC_Nissan_Qijun_H /* 983230 */:
                case FinalCanbus.CAR_RZC_SwMar_17 /* 1441872 */:
                case FinalCanbus.CAR_RZC_SwMar_Amp_17 /* 1507408 */:
                case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_14 /* 1966270 */:
                case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_11 /* 2031806 */:
                case FinalCanbus.CAR_RZC_Nissan_PATROL_13 /* 2097342 */:
                case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_14_H /* 2228414 */:
                case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_11_H /* 2293950 */:
                case FinalCanbus.CAR_RZC_Nissan_PATROL_13_H /* 2359486 */:
                case FinalCanbus.CAR_RZC_Nissan_Xtrail_Import_22 /* 2425022 */:
                case FinalCanbus.CAR_RZC_Nissan_Xtrail_Import_22_H /* 2490558 */:
                case FinalCanbus.CAR_RZC_Nissan_Tuda_18 /* 2556094 */:
                case FinalCanbus.CAR_RZC_Nissan_Tuda_18_H /* 2621630 */:
                case FinalCanbus.CAR_RZC_Nissan_NAVANA_16 /* 2687166 */:
                case FinalCanbus.CAR_RZC_Nissan_NAVANA_16_H /* 2752702 */:
                case FinalCanbus.CAR_RZC_Nissan_SENTRA_18_Import /* 2818238 */:
                case FinalCanbus.CAR_RZC_Nissan_SENTRA_18_Import_H /* 2883774 */:
                case FinalCanbus.CAR_RZC_Nissan_TITAN_19_Import /* 2949310 */:
                case FinalCanbus.CAR_RZC_Nissan_TITAN_19_Import_H /* 3014846 */:
                case FinalCanbus.CAR_RZC_Nissan_SENTRA_13_Import /* 3080382 */:
                case FinalCanbus.CAR_RZC_Nissan_SENTRA_13_Import_H /* 3145918 */:
                case FinalCanbus.CAR_RZC_Sanlin_OULANDE_24Overseas /* 3276990 */:
                case FinalCanbus.CAR_RZC_Sanlin_OULANDE_24Overseas_H /* 3342526 */:
                case FinalCanbus.CAR_RZC_Sanlin_Triton_25Overseas /* 3539134 */:
                case FinalCanbus.CAR_RZC_Sanlin_Triton_25Overseas_H /* 3604670 */:
                case FinalCanbus.CAR_RZC_Nissan_Rogue_14Overseas /* 3670206 */:
                case FinalCanbus.CAR_RZC_Nissan_Rogue_14Overseas_H /* 3735742 */:
                case FinalCanbus.CAR_RZC_Nissan_Rogue_21Overseas /* 3801278 */:
                case FinalCanbus.CAR_RZC_Nissan_Rogue_21Overseas_H /* 3866814 */:
                case FinalCanbus.CAR_RZC_Nissan_Altima_19Overseas /* 3932350 */:
                case FinalCanbus.CAR_RZC_Nissan_Altima_19Overseas_H /* 3997886 */:
                case FinalCanbus.CAR_RZC_Nissan_Pathfinder_22Overseas /* 4063422 */:
                case FinalCanbus.CAR_RZC_Nissan_Pathfinder_22Overseas_H /* 4128958 */:
                case FinalCanbus.CAR_RZC_Nissan_Pathfinder_20Overseas /* 4653246 */:
                case FinalCanbus.CAR_RZC_Nissan_Pathfinder_20Overseas_H /* 4718782 */:
                case FinalCanbus.CAR_439_RZC_Nissan_19Qida /* 8585655 */:
                case FinalCanbus.CAR_439_RZC_Nissan_19Qida_H /* 8651191 */:
                    temp = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1 ? (temp * 10) + 440 : (temp * 5) + 80;
                    break;
                case FinalCanbus.CAR_RZC_HanTeng_H /* 196863 */:
                case FinalCanbus.CAR_Oudi_HanTeng_X5 /* 393471 */:
                case FinalCanbus.CAR_Oudi_XiaoYao /* 459007 */:
                case FinalCanbus.CAR_RZC_HanTeng_X5 /* 524543 */:
                    temp = temp < 16 ? (temp * 10) + 160 : temp * 5;
                    break;
                case FinalCanbus.CAR_XP1_YearGmcSeries_NoAir /* 459164 */:
                case FinalCanbus.CAR_RZC_Explorer /* 590158 */:
                case FinalCanbus.CAR_RZC_13_20Mengdiou /* 852302 */:
                case FinalCanbus.CAR_RZC_Mustang /* 1048910 */:
                case FinalCanbus.CAR_RZC_Ford_F150_12 /* 2294094 */:
                case FinalCanbus.CAR_RZC_Mustang_NO_CD /* 2359630 */:
                case FinalCanbus.CAR_RZC_Mustang_15_NO_CD /* 2621774 */:
                case FinalCanbus.CAR_RZC_Explorer_13 /* 3014990 */:
                case FinalCanbus.CAR_RZC_Ford_F150 /* 3080526 */:
                case FinalCanbus.CAR_RZC_Ford_Puma_22 /* 3670350 */:
                case FinalCanbus.CAR_RZC_Mustang_M /* 5374286 */:
                case FinalCanbus.CAR_RZC_Mustang_H /* 5439822 */:
                case FinalCanbus.CAR_RZC_Mustang_NOCD_M /* 5505358 */:
                case FinalCanbus.CAR_RZC_Mustang_NOCD_H /* 5570894 */:
                case FinalCanbus.CAR_RZC_Ford_Puma_22_M /* 5636430 */:
                case FinalCanbus.CAR_RZC_Ford_Puma_22_H /* 5701966 */:
                case FinalCanbus.CAR_RZC_Ford_BRONCO_22 /* 5767502 */:
                case FinalCanbus.CAR_RZC_Ford_BRONCO_22_M /* 5833038 */:
                case FinalCanbus.CAR_RZC_Ford_BRONCO_22_H /* 5898574 */:
                case FinalCanbus.CAR_RZC_Ford_MAVERICK_24 /* 5964110 */:
                case FinalCanbus.CAR_RZC_Ford_MAVERICK_24_M /* 6029646 */:
                case FinalCanbus.CAR_RZC_Ford_MAVERICK_24_H /* 6095182 */:
                case FinalCanbus.CAR_RZC_Ford_Explorer_24 /* 6160718 */:
                case FinalCanbus.CAR_RZC_Ford_Explorer_24_M /* 6226254 */:
                case FinalCanbus.CAR_RZC_Ford_Explorer_24_H /* 6291790 */:
                case FinalCanbus.CAR_RZC_Ford_RANGER_24 /* 6357326 */:
                case FinalCanbus.CAR_RZC_Ford_RANGER_24_M /* 6422862 */:
                case FinalCanbus.CAR_RZC_Ford_RANGER_24_H /* 6488398 */:
                case FinalCanbus.CAR_RZC_Ford_F250_09 /* 6553934 */:
                case FinalCanbus.CAR_RZC_Ford_Expedition_07 /* 6619470 */:
                case FinalCanbus.CAR_RZC_Ford_Expedition_15 /* 6685006 */:
                case FinalCanbus.CAR_RZC_Ford_Flex_13 /* 6750542 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = ((((temp * 9) / 5) + 320) / 10) * 10;
                    }
                    break;
                case FinalCanbus.CAR_RZC_OD_DongNanDX5 /* 590153 */:
                case FinalCanbus.CAR_439_DJ_LEXUS_ES /* 1245623 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_22Teana_Top /* 1572944 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_22Teana_Top_360View /* 1638480 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_16Trail /* 1704016 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_16Trail_H /* 1769552 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_16Xiaoke /* 1835088 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_16Xiaoke_H /* 1900624 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Xima_L /* 1966160 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Xima_H /* 2031696 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Loulan_L /* 2097232 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Loulan_H /* 2162768 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Tianlai_L /* 2228304 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Tianlai_H /* 2293840 */:
                case FinalCanbus.CAR_455_OD_Dongfeng_Racing_EC75_23H /* 2294215 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Xuanyi_L /* 2359376 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Xuanyi_H /* 2424912 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Lanniao_L /* 2490448 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Lannia_H /* 2555984 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Qida_L /* 2621520 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Qida_H /* 2687056 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Jinke_L /* 2752592 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_Jinke_H /* 2818128 */:
                case FinalCanbus.CAR_439_DJ_LEXUS_ES_H /* 3801527 */:
                case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_Auto /* 5833156 */:
                case FinalCanbus.CAR_452_OD_HZ_Nezha /* 7602628 */:
                case FinalCanbus.CAR_BNR_02_09Toyato_Prado /* 7668151 */:
                case FinalCanbus.CAR_BNR_02_09Toyato_Prado_H /* 7733687 */:
                case FinalCanbus.CAR_454_OD_Dongfeng_Racing_EC75_23 /* 8454598 */:
                case FinalCanbus.CAR_455_OD_HZ_Nezha_H /* 9699783 */:
                case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_EV /* 10355140 */:
                case FinalCanbus.CAR_454_OD_Dongfeng_Tianlong /* 11403718 */:
                case FinalCanbus.CAR_452_OD_LeiDing_Mangguo_L /* 13107652 */:
                case FinalCanbus.CAR_452_OD_LeiDing_Mangguo_H /* 13173188 */:
                    temp = (temp * 5) + 175;
                    break;
                case FinalCanbus.CAR_RZC_19MingjueHS /* 852241 */:
                case FinalCanbus.CAR_RZC_19RongWei_I5 /* 917777 */:
                case FinalCanbus.CAR_RZC_19RongWei_I6 /* 983313 */:
                case FinalCanbus.CAR_RZC_19MingjueHS_H /* 1048849 */:
                case FinalCanbus.CAR_RZC_19RongWei_I5_H /* 1114385 */:
                case FinalCanbus.CAR_OD_RZC_ShangQiDaTong22G50 /* 1310985 */:
                case FinalCanbus.CAR_RZC_19RongWei_RX8 /* 1310993 */:
                case FinalCanbus.CAR_RZC_Mingjue_20ZS /* 1376529 */:
                case FinalCanbus.CAR_OD_RZC_ShangQiDaTong19G50 /* 1442057 */:
                case FinalCanbus.CAR_RZC_Mingjue_20ZS_H /* 1442065 */:
                case FinalCanbus.CAR_RZC_19Mingjue_MG6 /* 1507601 */:
                case FinalCanbus.CAR_OD_RZC_DaTong_25Dana_V1 /* 1638665 */:
                case FinalCanbus.CAR_RZC_18RongWei_RX8 /* 1638673 */:
                case FinalCanbus.CAR_OD_RZC_DaTong_25Dana_M1 /* 1704201 */:
                case FinalCanbus.CAR_RZC_20RongWei_RX5 /* 1704209 */:
                case FinalCanbus.CAR_RZC_MingJue_MG5_21 /* 1835281 */:
                case FinalCanbus.CAR_RZC_21RongWei_I5 /* 1900817 */:
                case FinalCanbus.CAR_RZC_21RongWei_I5_H /* 1966353 */:
                case FinalCanbus.CAR_RZC_MingJue_MG5_21_L /* 2031889 */:
                case FinalCanbus.CAR_CZH_RZC_19Mingjue_MG6 /* 2097425 */:
                case FinalCanbus.CAR_RZC_MingJue_MG5_22_Top /* 2162961 */:
                case FinalCanbus.CAR_RZC_23MingjueHS /* 2228497 */:
                case FinalCanbus.CAR_RZC_MingJue_MG5_25 /* 2294033 */:
                case FinalCanbus.CAR_RZC_23RongWei_I5 /* 2425105 */:
                case FinalCanbus.CAR_RZC_MingJue_MG5_21_Top /* 2490641 */:
                case FinalCanbus.CAR_RZC_MingJue_MG6_21_Pro /* 2556177 */:
                case FinalCanbus.CAR_454_OD_Xinte_DEV1_H /* 7274950 */:
                    temp *= 10;
                    break;
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
                case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD /* 8913349 */:
                case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD_H /* 8978885 */:
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH /* 10420679 */:
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH_H /* 10486215 */:
                case FinalCanbus.CAR_452_OD_Qirui_Xiaomayi /* 12517828 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300 /* 15008198 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER /* 15139270 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER_H /* 15532486 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300_H /* 15598022 */:
                    temp = (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) ? (temp * 9) + 635 : (temp * 5) + 175;
                    break;
                case FinalCanbus.CAR_455_LZ_GMC_Sierra_19_RScreen /* 1507783 */:
                case FinalCanbus.CAR_455_LZ_Chevrolet_Silverado_19_RScreen /* 1573319 */:
                case FinalCanbus.CAR_453_LZ_GM_Camaro_17 /* 2163141 */:
                case FinalCanbus.CAR_453_LZ_GM_GMC_TERRAIN_17 /* 2228677 */:
                case FinalCanbus.CAR_453_LZ_GM_Equinox_17 /* 2294213 */:
                case FinalCanbus.CAR_455_LZ_GM_Cadillac_CT5_Screen /* 5439943 */:
                case FinalCanbus.CAR_454_LZ_GM_Camaro_17_Auto /* 6947270 */:
                case FinalCanbus.CAR_454_LZ_GM_Equinox_17_Auto /* 7012806 */:
                case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_Screen /* 9437639 */:
                case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_Screen /* 9503175 */:
                case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_RScreen /* 9568711 */:
                case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_RScreen /* 9634247 */:
                case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
                case FinalCanbus.CAR_454_LZ_Chevrolet_Silverado_19_Screen /* 11993542 */:
                case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_4Screen /* 15729095 */:
                case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_4Screen /* 15794631 */:
                case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_8Screen /* 15860167 */:
                case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_8Screen /* 15925703 */:
                    if (temp >= 1 && temp <= 16) {
                        temp = SystemProperties.getInt("persist.fyt.temperature", 0) == 1 ? ((temp + 15) * 18) + 320 : (temp * 10) + 150;
                    } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0 && SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 320;
                    } else {
                        temp *= 5;
                    }
                    break;
                case FinalCanbus.CAR_452_XinCheng_Infiniti_ESQ /* 1573316 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_06FX /* 1638852 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_08FX /* 1704388 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_G /* 1769924 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_14QX50 /* 1835460 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_15QX60 /* 1900996 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_14QX70 /* 1966532 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_12FX /* 3998148 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_15Q50L /* 4063684 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_12JX35 /* 4129220 */:
                case FinalCanbus.CAR_455_XinCheng_Infiniti_18QX80 /* 6816199 */:
                case FinalCanbus.CAR_455_XinCheng_Infiniti_17QX30_Keep /* 6881735 */:
                case FinalCanbus.CAR_455_XinCheng_Infiniti_17QX30 /* 6947271 */:
                case FinalCanbus.CAR_455_XinCheng_Infiniti_17Q50 /* 7012807 */:
                case FinalCanbus.CAR_455_XinCheng_Infiniti_22QX50 /* 10355143 */:
                case FinalCanbus.CAR_455_XinCheng_Infiniti_15QX56 /* 11731399 */:
                case FinalCanbus.CAR_455_XinCheng_Nissan_11Loulan /* 11796935 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 10) - 160;
                    } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 320;
                    } else {
                        temp *= 5;
                    }
                    break;
                case FinalCanbus.CAR_452_XinCheng_Infiniti_13Q70L /* 2032068 */:
                case FinalCanbus.CAR_452_XinCheng_Nissan_Tule_H /* 5112260 */:
                case FinalCanbus.CAR_452_XinCheng_Nissan_Tule_Top /* 7078343 */:
                case FinalCanbus.CAR_455_XinCheng_Nissan_20Tule_H /* 11665863 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 10) - 160;
                    } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 320;
                    } else {
                        temp *= 5;
                    }
                    break;
                case FinalCanbus.CAR_454_Sanwu_Nissan_QX56_2004_Auto /* 3473862 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0 && SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = ((temp * 9) / 5) + 320;
                    }
                    break;
                case FinalCanbus.CAR_452_DJ_Dodge_JCUV /* 4981188 */:
                case FinalCanbus.CAR_455_DJ_Dodge_JCUV_SCREEN /* 15991239 */:
                    temp = (temp * 10) + 130;
                    break;
                case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9 /* 5702084 */:
                case FinalCanbus.CAR_455_LZ_Benz_C200_NTG5 /* 8192455 */:
                case FinalCanbus.CAR_454_RZC_Shanqi_DelongG2 /* 10027462 */:
                case FinalCanbus.CAR_455_LUZ_Benz_GLC_NTG50 /* 10027463 */:
                case FinalCanbus.CAR_439_DJ_Rongwei_i5 /* 13959607 */:
                case FinalCanbus.CAR_439_DJ_Rongwei_i5_H /* 14025143 */:
                    temp = (temp * 10) + 150;
                    break;
                case FinalCanbus.CAR_439_HC_Ruijie /* 6816183 */:
                case FinalCanbus.CAR_439_HC_Ruijie_H /* 6881719 */:
                    temp = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0 ? ((temp - 12) * 5) + 155 : ((temp - 12) * 10) + 600;
                    break;
                case FinalCanbus.CAR_RZC_HavalH6Couple_BLUE_TOP /* 7078327 */:
                case FinalCanbus.CAR_RZC_HavalH6Couple_RED_TOP /* 7143863 */:
                case FinalCanbus.CAR_RZC_XP1_HavalH6Couple_19 /* 7602615 */:
                case FinalCanbus.CAR_439_RZC_Haval_18_19H6 /* 11272631 */:
                    temp = ((temp - 116) * 5) + 180;
                    if (temp < 0) {
                        temp = 0;
                    }
                    break;
                case FinalCanbus.CAR_452_XC_Rongwei_ALl /* 7471556 */:
                case FinalCanbus.CAR_452_XC_GM_ALl /* 7537092 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = ((((temp * 5) + 95) * 9) / 5) + 320;
                        ((TextView) findViewById(R.id.air_sp_temp_rear)).setText(new StringBuilder().append(temp / 10).toString());
                    } else {
                        temp = (temp * 5) + 95;
                    }
                    break;
                case FinalCanbus.CAR_455_OD_CZH_Qichen_D60_EV /* 7799239 */:
                case FinalCanbus.CAR_455_YDT_OD_Qichen_D60_EV /* 8913351 */:
                case FinalCanbus.CAR_454_OD_Qichen_D60_EV /* 9961926 */:
                    temp = (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0 && SystemProperties.getInt("persist.fyt.temperature", 0) == 1) ? (temp * 9) + 320 : temp * 10;
                    break;
                case FinalCanbus.CAR_453_LZ_Jili_Boyue_18 /* 8782277 */:
                case FinalCanbus.CAR_453_LZ_Jili_Boyue_18_H /* 8847813 */:
                    temp = (temp >= 32 && temp <= 34) ? ((temp - 32) * 5) + 160 : (temp * 5) + 170;
                    break;
                case FinalCanbus.CAR_454_OD_Yutong_Qingka /* 11338182 */:
                    temp = (temp * 10) + 160;
                    break;
                case FinalCanbus.CAR_454_KYC_Ford_Mustang_07_H /* 13631942 */:
                case FinalCanbus.CAR_454_KYC_Ford_Mustang_07_L /* 13697478 */:
                    temp = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0 ? (temp * 10) + 310 : temp * 5;
                    break;
                case FinalCanbus.CAR_452_OD_ChangCheng_Fengjun5 /* 13763012 */:
                    temp = ((temp - 116) * 5) + 160;
                    if (temp < 0) {
                        temp = 0;
                    }
                    break;
            }
            mUpdateTempValue(R.id.air_sp_temp_right1, temp / 100, false);
            mUpdateTempValue(R.id.air_sp_temp_right2, (temp % 100) / 10, false);
            mUpdateTempValue(R.id.air_sp_temp_right3, temp % 10, true);
            mUpdateTempUNIT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTempUNIT() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT];
        if (ConstAllAirDara.U_AIR_TEMP_UNIT != 255) {
            switch (DataCanbus.DATA[1000]) {
                case 25:
                case 26:
                case 373:
                case FinalCanbus.CAR_XP1_GM_H1 /* 65561 */:
                case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_H /* 65909 */:
                case FinalCanbus.CAR_XP1_GM_H2 /* 131097 */:
                case FinalCanbus.CAR_RZC_XP1_ZiYouXia /* 131445 */:
                case FinalCanbus.CAR_XP1_GM_H3 /* 196633 */:
                case FinalCanbus.CAR_RZC_XP1_GrdCherokee /* 196981 */:
                case FinalCanbus.CAR_XP1_GM_Camaro_10 /* 262169 */:
                case FinalCanbus.CAR_RZC_17ZhiNanZhe /* 262517 */:
                case FinalCanbus.CAR_RZC_17ZhiNanZhe_H /* 328053 */:
                case FinalCanbus.CAR_RZC_18MuMaRen /* 393589 */:
                case FinalCanbus.CAR_XP1_GM_Silverado_14_Hand /* 458777 */:
                case FinalCanbus.CAR_RZC_XP1_GrdCherokee_H /* 459125 */:
                case FinalCanbus.CAR_XP1_GM_Silverado_14_Auto /* 524313 */:
                case FinalCanbus.CAR_RZC_18MuMaRen_H /* 524661 */:
                case FinalCanbus.CAR_RZC_19Tiaozhanzhe /* 590197 */:
                case FinalCanbus.CAR_RZC_18Zhihuiguan /* 655733 */:
                case FinalCanbus.CAR_RZC_19Tiaozhanzhe_H /* 721269 */:
                case FinalCanbus.CAR_RZC_18Zhihuiguan_H /* 786805 */:
                case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19 /* 852341 */:
                case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19_H /* 917877 */:
                case FinalCanbus.CAR_RZC_20Zhihuiguan_EV /* 983413 */:
                case FinalCanbus.CAR_RZC_Dodge_JCUV /* 1114485 */:
                case FinalCanbus.CAR_RZC_Chrysler_300C_16 /* 1245557 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM /* 1311093 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_H /* 1376629 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_M /* 1835381 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_HY /* 1900917 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_HY_M /* 1966453 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_HY_H /* 2031989 */:
                case FinalCanbus.CAR_RZC_XP1_ZiYouXia_H /* 2163061 */:
                case FinalCanbus.CAR_XP1_GM_AJcd600 /* 2228249 */:
                case FinalCanbus.CAR_RZC_Dodge_JCUV_H /* 2359669 */:
                case FinalCanbus.CAR_DJ_GM_ALL /* 2424857 */:
                case FinalCanbus.CAR_XP1_GM_AJcd650 /* 2490393 */:
                case FinalCanbus.CAR_RZC_CHRYSLER_21PACIFICA /* 2556277 */:
                case FinalCanbus.CAR_XP1_GM_Opel_Meriva /* 2621465 */:
                case FinalCanbus.CAR_RZC_CHRYSLER_21PACIFICA_H /* 2621813 */:
                case FinalCanbus.CAR_DJ_GM_Kopach /* 2687001 */:
                case FinalCanbus.CAR_RZC_Dodge_15CHARGER /* 2687349 */:
                case FinalCanbus.CAR_RZC_Dodge_15CHARGER_H /* 2752885 */:
                case FinalCanbus.CAR_RZC_Dodge_17DURANGO /* 2818421 */:
                case FinalCanbus.CAR_RZC_Dodge_17DURANGO_H /* 2883957 */:
                case FinalCanbus.CAR_RZC_Jeep_22Gladiator /* 2949493 */:
                case FinalCanbus.CAR_RZC_Jeep_22Gladiator_H /* 3015029 */:
                case FinalCanbus.CAR_RZC_Jeep_18GrdCherokee /* 3080565 */:
                case FinalCanbus.CAR_RZC_Jeep_18GrdCherokee_H /* 3146101 */:
                case FinalCanbus.CAR_RZC_CHRYSLER_19PACIFICA_H /* 3211637 */:
                case FinalCanbus.CAR_RZC_Dodge_20RAM /* 3277173 */:
                case FinalCanbus.CAR_454_Sanwu_Nissan_QX56_2004_Auto /* 3473862 */:
                case FinalCanbus.CAR_455_LZ_NISSAN_patrol_H /* 4653511 */:
                case FinalCanbus.CAR_453_LZ_NISSAN_patrol /* 5308869 */:
                case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX60 /* 5374405 */:
                case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX80 /* 5439941 */:
                case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX56 /* 5505477 */:
                case FinalCanbus.CAR_455_OD_CZH_Qichen_D60_EV /* 7799239 */:
                case FinalCanbus.CAR_455_YDT_OD_Qichen_D60_EV /* 8913351 */:
                case FinalCanbus.CAR_454_OD_Qichen_D60_EV /* 9961926 */:
                case FinalCanbus.CAR_454_LZ_Nissan_370Z_H /* 14746054 */:
                case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_L /* 15729094 */:
                case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H /* 15794630 */:
                case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_TW /* 15860166 */:
                case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H_NP /* 15925702 */:
                    if (vel == 1 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                        findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                        findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                        findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                    } else {
                        findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                    }
                    break;
                case 372:
                case FinalCanbus.CAR_WC1_Jeep_ZiYouGuang_M /* 65908 */:
                case FinalCanbus.CAR_WC1_Jeep_ZiYouGuang_H /* 131444 */:
                case FinalCanbus.CAR_WC1_Jeep_17ZhiNanZhe /* 262516 */:
                case FinalCanbus.CAR_WC1_Jeep_17ZhiNanZhe_H /* 328052 */:
                case FinalCanbus.CAR_WC1_Jeep_18ZiYouXia /* 393588 */:
                case FinalCanbus.CAR_WC1_Jeep_18ZiYouXia_H /* 459124 */:
                case FinalCanbus.CAR_WC1_Jeep_19ZiYouXia_W /* 524660 */:
                case FinalCanbus.CAR_WC1_Fiat_19_500X /* 590196 */:
                case FinalCanbus.CAR_WC1_Jeep_13_Dodge_JCUV /* 655732 */:
                case FinalCanbus.CAR_WC1_Jeep_13_Dodge_JCUV_CD /* 721268 */:
                case FinalCanbus.CAR_WC1_Jeep_18_Zhihuiguan /* 852340 */:
                case FinalCanbus.CAR_WC1_Jeep_15_RAM /* 917876 */:
                case FinalCanbus.CAR_WC1_Jeep_18_Zhihuiguan_H /* 983412 */:
                case FinalCanbus.CAR_WC1_Jeep_15_RAM_H /* 1048948 */:
                case FinalCanbus.CAR_WC1_TMK_BENZ_MPV_ALL /* 1114484 */:
                case FinalCanbus.CAR_WC1_Jeep_20_GrdCherokee_H /* 1180020 */:
                case FinalCanbus.CAR_WC1_Jeep_19_MuMaRen_H /* 1245556 */:
                case FinalCanbus.CAR_WC1_Jeep_18ZhiNanZhe_EU /* 1311092 */:
                case FinalCanbus.CAR_WC1_Jeep_Chrysler_300C_11 /* 1376628 */:
                case FinalCanbus.CAR_WC1_Jeep_Chrysler_300C_11CD /* 1442164 */:
                case FinalCanbus.CAR_WC1_Jeep_19_MuMaRen_L /* 1507700 */:
                case FinalCanbus.CAR_WC1_Jeep_20_GrdCherokee_L /* 1573236 */:
                case FinalCanbus.CAR_WC1_Jeep_18_Zhihuiguan_M /* 1638772 */:
                case FinalCanbus.CAR_WC1_Jeep_15_RAM_M /* 1704308 */:
                case FinalCanbus.CAR_WC1_Jeep_20_GrdCherokee_M /* 1769844 */:
                case FinalCanbus.CAR_WC1_Jeep_19_MuMaRen_M /* 1835380 */:
                case FinalCanbus.CAR_WC1_Jeep_19_RAM /* 1900916 */:
                case FinalCanbus.CAR_WC1_Jeep_19_RAM_M /* 1966452 */:
                case FinalCanbus.CAR_WC1_Jeep_19_RAM_H /* 2031988 */:
                    if (vel == 2) {
                        findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                        findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                        findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                        findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                    } else {
                        findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                    }
                    break;
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                case FinalCanbus.CAR_443_WC2_Ford_EDGE_11 /* 6685115 */:
                case FinalCanbus.CAR_443_WC2_Ford_EDGE_11_CD /* 6750651 */:
                case FinalCanbus.CAR_444_WC2_Ford_Escape_08_L /* 7274940 */:
                case FinalCanbus.CAR_444_WC2_Ford_Escape_08_M /* 7340476 */:
                case FinalCanbus.CAR_444_WC2_Ford_Escape_08_H /* 7406012 */:
                case FinalCanbus.CAR_444_WC2_Ford_KA_14 /* 7733692 */:
                case FinalCanbus.CAR_444_WC2_Ford_SAMX_15 /* 7799228 */:
                case FinalCanbus.CAR_444_WC2_Ford_TAURUS_18 /* 7864764 */:
                case FinalCanbus.CAR_444_WC2_Ford_Escape_20 /* 7930300 */:
                case FinalCanbus.CAR_444_WC2_Ford_Fusion_06_L /* 7995836 */:
                case FinalCanbus.CAR_444_WC2_Ford_Fusion_06_M /* 8061372 */:
                case FinalCanbus.CAR_444_WC2_Ford_Fusion_06_H /* 8126908 */:
                case FinalCanbus.CAR_444_WC2_Ford_Tourneo_15 /* 8192444 */:
                case FinalCanbus.CAR_444_WC2_Ford_Transit_20 /* 8257980 */:
                case FinalCanbus.CAR_444_WC2_Ford_Edge_06_L /* 8323516 */:
                case FinalCanbus.CAR_444_WC2_Ford_Edge_06_M /* 8389052 */:
                case FinalCanbus.CAR_444_WC2_Ford_Edge_06_H /* 8454588 */:
                case FinalCanbus.CAR_444_WC2_Ford_Edge_15_DWS /* 8520124 */:
                case FinalCanbus.CAR_444_WC2_Ford_Explorer_06_L /* 8585660 */:
                case FinalCanbus.CAR_444_WC2_Ford_Explorer_06_M /* 8651196 */:
                case FinalCanbus.CAR_444_WC2_Ford_Explorer_06_H /* 8716732 */:
                case FinalCanbus.CAR_444_WC2_Ford_Explorer_11 /* 8782268 */:
                case FinalCanbus.CAR_444_WC2_Ford_Explorer_11_CD /* 8847804 */:
                case FinalCanbus.CAR_444_WC2_Ford_Explorer_11_SP /* 8913340 */:
                case FinalCanbus.CAR_444_WC2_Ford_Everest_16 /* 8978876 */:
                case FinalCanbus.CAR_444_WC2_Ford_Everest_23 /* 9044412 */:
                case FinalCanbus.CAR_444_WC2_Ford_Ranger_16 /* 9109948 */:
                case FinalCanbus.CAR_444_WC2_Ford_Raptor_18 /* 9175484 */:
                case FinalCanbus.CAR_444_WC2_Ford_F150_04_L /* 9241020 */:
                case FinalCanbus.CAR_444_WC2_Ford_F150_04_M /* 9306556 */:
                case FinalCanbus.CAR_444_WC2_Ford_F150_04_H /* 9372092 */:
                case FinalCanbus.CAR_444_WC2_Ford_F250_04_L /* 9437628 */:
                case FinalCanbus.CAR_444_WC2_Ford_F250_04_M /* 9503164 */:
                case FinalCanbus.CAR_444_WC2_Ford_F250_04_H /* 9568700 */:
                case FinalCanbus.CAR_444_WC2_Ford_Mustang_05_L /* 9634236 */:
                case FinalCanbus.CAR_444_WC2_Ford_Mustang_05_M /* 9699772 */:
                case FinalCanbus.CAR_444_WC2_Ford_Mustang_05_H /* 9765308 */:
                case FinalCanbus.CAR_444_WC2_Ford_Expedition_03_L /* 9896380 */:
                case FinalCanbus.CAR_444_WC2_Ford_Expedition_03_M /* 9961916 */:
                case FinalCanbus.CAR_444_WC2_Ford_Expedition_03_H /* 10027452 */:
                case FinalCanbus.CAR_444_WC2_Ford_Yihu_12_CD /* 10092988 */:
                case FinalCanbus.CAR_444_WC2_Ford_Lincoln_Continental /* 10158524 */:
                case FinalCanbus.CAR_443_WC2_Ford_F150_18 /* 15401403 */:
                case FinalCanbus.CAR_443_WC2_Ford_F150_18_CD /* 15466939 */:
                case FinalCanbus.CAR_443_WC2_Ford_F150_18_M /* 15729083 */:
                case FinalCanbus.CAR_443_WC2_Ford_F150_18_H /* 15794619 */:
                case FinalCanbus.CAR_443_WC2_Ford_F250_18_L /* 15860155 */:
                case FinalCanbus.CAR_443_WC2_Ford_F250_18_M /* 15925691 */:
                case FinalCanbus.CAR_443_WC2_Ford_F250_18_H /* 15991227 */:
                case FinalCanbus.CAR_443_WC2_Ford_F350_18_L /* 16056763 */:
                case FinalCanbus.CAR_443_WC2_Ford_F350_18_M /* 16122299 */:
                case FinalCanbus.CAR_443_WC2_Ford_F350_18_H /* 16187835 */:
                case FinalCanbus.CAR_443_WC2_Ford_Mustang_18_L /* 16253371 */:
                case FinalCanbus.CAR_443_WC2_Ford_Mustang_18_M /* 16318907 */:
                case FinalCanbus.CAR_443_WC2_Ford_Mustang_18_H /* 16384443 */:
                    if (vel == 0) {
                        findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                        findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                        findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                        findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                    } else {
                        findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                    }
                    break;
                default:
                    if (vel == 1 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                        findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                        findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                        findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                    } else {
                        findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                    }
                    break;
            }
            return;
        }
        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
            findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
            findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
            findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
            return;
        }
        findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
        findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
        findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
        findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBackAuto() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_AUTO];
        findViewById(R.id.air_sp_auto_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_auto_n : R.drawable.ic_hp_auto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBackAutoRight() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_AUTO_RIGHT];
        findViewById(R.id.air_sp_auto_rear_right).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_auto_n : R.drawable.ic_hp_auto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBackRearLock() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_LOCK];
        findViewById(R.id.air_sp_rearlock_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_rearlight_n : R.drawable.ic_hp_rearlight_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBackRearSync() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_SYNC];
        findViewById(R.id.air_sp_sync_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_sync_n : R.drawable.ic_hp_sync_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBackRearAC() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_AC];
        findViewById(R.id.air_sp_ac_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_ac_n : R.drawable.ic_hp_ac_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBackRearCtrl() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_CTRL];
        findViewById(R.id.air_sp_car_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_rearlight_n : R.drawable.ic_hp_rearlight_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirEm() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_EM];
        findViewById(R.id.air_sp_em).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_em_n : R.drawable.ic_hp_em_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBackWind() {
        int leave = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_WIND];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria /* 328124 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria_H /* 393660 */:
            case FinalCanbus.CAR_446_WC2_Teyes_XianDai_All_22SantaFe /* 1311166 */:
            case FinalCanbus.CAR_455_LZ_GMC_Sierra_19_RScreen /* 1507783 */:
            case FinalCanbus.CAR_455_LZ_Chevrolet_Silverado_19_RScreen /* 1573319 */:
            case FinalCanbus.CAR_OD_RZC_DaTong_25Dana_M1 /* 1704201 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_15Carnival /* 1966524 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_15Carnival_H /* 2032060 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_23NewZealand /* 2097596 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_23NewZealand_H /* 2163132 */:
            case FinalCanbus.CAR_446_WC2_XianDai_CUSTO /* 2687422 */:
            case FinalCanbus.CAR_RZC3_XianDai_19Palisade /* 2752959 */:
            case FinalCanbus.CAR_RZC3_XianDai_19Palisade_H /* 2818495 */:
            case FinalCanbus.CAR_RZC3_XianDai_20CARNIVAL /* 2884031 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra /* 2949564 */:
            case FinalCanbus.CAR_RZC3_XianDai_20CARNIVAL_H /* 2949567 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra_H /* 3015100 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra_EV /* 3211708 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_20NIRO /* 3342780 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_12K9 /* 3408316 */:
            case FinalCanbus.CAR_444_WC2_Shuanglong_All_11Korando /* 3473852 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria_Amp /* 3539388 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_23Staria /* 3539391 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_23Staria_H /* 3604927 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_18Lafesta /* 3670460 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_17SoNaTa_USA /* 3735996 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_19Shengda_H /* 3867067 */:
            case FinalCanbus.CAR_444_Tyes_WC2_XianDai_All_21Elantra_EV /* 3998140 */:
            case FinalCanbus.CAR_455_LZ_GM_Cadillac_CT5_Screen /* 5439943 */:
            case FinalCanbus.CAR_455_RZC_Jianghuai_Sihao_X6 /* 8389063 */:
            case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_Screen /* 9437639 */:
            case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_Screen /* 9503175 */:
            case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_RScreen /* 9568711 */:
            case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_RScreen /* 9634247 */:
            case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_21IX35 /* 11993532 */:
            case FinalCanbus.CAR_454_LZ_Chevrolet_Silverado_19_Screen /* 11993542 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_21IX35_H /* 12059068 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_20IX25 /* 12124604 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_20IX25_H /* 12190140 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_4Screen /* 15729095 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_4Screen /* 15794631 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_8Screen /* 15860167 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_8Screen /* 15925703 */:
                ((TextView) findViewById(R.id.air_sp_rear_wind_txt)).setText(new StringBuilder().append(leave).toString());
                ((ProgressBar) findViewById(R.id.air_sp_rear_wind_lev)).setMax(8);
                break;
            case FinalCanbus.CAR_WC2_GM_GL8 /* 393252 */:
            case FinalCanbus.CAR_WC2_GM_Tahoe_15_Auto /* 5832740 */:
            case FinalCanbus.CAR_WC2_GM_Escalade_15_Auto /* 5898276 */:
            case FinalCanbus.CAR_WC2_GM_Escalade_07_Auto /* 5963812 */:
                if (leave == 32) {
                    ((TextView) findViewById(R.id.air_sp_rear_wind_txt)).setText("AUTO");
                    ((ProgressBar) findViewById(R.id.air_sp_rear_wind_lev)).setMax(8);
                } else {
                    ((TextView) findViewById(R.id.air_sp_rear_wind_txt)).setText(new StringBuilder().append(leave).toString());
                    ((ProgressBar) findViewById(R.id.air_sp_rear_wind_lev)).setMax(8);
                }
                break;
            case FinalCanbus.CAR_RZC_19RongWei_RX8 /* 1310993 */:
            case FinalCanbus.CAR_RZC_18RongWei_RX8 /* 1638673 */:
                if (leave == 15) {
                    ((TextView) findViewById(R.id.air_sp_rear_wind_txt)).setText("AUTO");
                    ((ProgressBar) findViewById(R.id.air_sp_rear_wind_lev)).setMax(7);
                } else {
                    ((TextView) findViewById(R.id.air_sp_rear_wind_txt)).setText(new StringBuilder().append(leave).toString());
                    ((ProgressBar) findViewById(R.id.air_sp_rear_wind_lev)).setMax(7);
                }
                break;
            case FinalCanbus.CAR_452_XinCheng_Nissan_Tule_Top /* 7078343 */:
            case FinalCanbus.CAR_455_XinCheng_Nissan_20Tule_H /* 11665863 */:
            case FinalCanbus.CAR_454_LZ_Honda_AoDeSai_04 /* 16449990 */:
                ((TextView) findViewById(R.id.air_sp_rear_wind_txt)).setText(new StringBuilder().append(leave).toString());
                ((ProgressBar) findViewById(R.id.air_sp_rear_wind_lev)).setMax(5);
                break;
            case FinalCanbus.CAR_452_XC_Rongwei_ALl /* 7471556 */:
            case FinalCanbus.CAR_452_XC_GM_ALl /* 7537092 */:
                ((TextView) findViewById(R.id.air_sp_rear_wind_txt)).setText(new StringBuilder().append(leave).toString());
                ((ProgressBar) findViewById(R.id.air_sp_rear_wind_lev)).setMax(4);
                break;
            default:
                ((TextView) findViewById(R.id.air_sp_rear_wind_txt)).setText(new StringBuilder().append(leave).toString());
                ((ProgressBar) findViewById(R.id.air_sp_rear_wind_lev)).setMax(7);
                break;
        }
        ((ProgressBar) findViewById(R.id.air_sp_rear_wind_lev)).setProgress(leave);
        ((ProgressBar) findViewById(R.id.air_sp_rear_wind_lev)).invalidate();
        if (ConstAllAirDara.C_REAR_OFF != 255 && ConstAllAirDara.U_AIR_BACK_POWER == 255 && this.pagenum == 1) {
            findViewById(R.id.air_sp_power).setBackgroundResource(leave == 0 ? R.drawable.ic_hp_power_n : R.drawable.ic_hp_power_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int value = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
        ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(value).toString());
        switch (DataCanbus.DATA[1000]) {
            case 25:
            case 26:
            case 253:
            case 263:
            case FinalCanbus.CAR_XP1_GM_H1 /* 65561 */:
            case FinalCanbus.CAR_RZC_FLB_SaiOu3 /* 65799 */:
            case FinalCanbus.CAR_XP1_GM_H2 /* 131097 */:
            case FinalCanbus.CAR_XP1_GM_H3 /* 196633 */:
            case FinalCanbus.CAR_XP1_GM_Camaro_10 /* 262169 */:
            case FinalCanbus.CAR_RZC_17Gl8 /* 262407 */:
            case FinalCanbus.CAR_RZC_ALL_GM_11_15GL8 /* 327943 */:
            case FinalCanbus.CAR_RZC_17_18GL8_ES_28T /* 393479 */:
            case FinalCanbus.CAR_XP1_GM_Silverado_14_Hand /* 458777 */:
            case FinalCanbus.CAR_RZC_18_19Excelle_GT /* 459015 */:
            case FinalCanbus.CAR_XP1_GM_Silverado_14_Auto /* 524313 */:
            case FinalCanbus.CAR_RZC_20GL8_652T /* 524551 */:
            case FinalCanbus.CAR_RZC_20GL8_652T_H /* 590087 */:
            case FinalCanbus.CAR_RZC_15GL8_24_H /* 655623 */:
            case FinalCanbus.CAR_RZC_21YingLang_CD /* 721159 */:
            case FinalCanbus.CAR_RZC_21YingLang /* 786695 */:
            case FinalCanbus.CAR_XP1_GM_AJcd600 /* 2228249 */:
            case FinalCanbus.CAR_DJ_GM_ALL /* 2424857 */:
            case FinalCanbus.CAR_XP1_GM_AJcd650 /* 2490393 */:
            case FinalCanbus.CAR_XP1_GM_Opel_Meriva /* 2621465 */:
            case FinalCanbus.CAR_DJ_GM_Kopach /* 2687001 */:
                if (value > 8) {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText("AUTO");
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(8);
                } else {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(value).toString());
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(8);
                }
                break;
            case 36:
            case 345:
            case FinalCanbus.CAR_WC2_ShuPingJW /* 65881 */:
            case FinalCanbus.CAR_WC2_ShuPingKeLuZi /* 131417 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao /* 196953 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS /* 262489 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS_S /* 328025 */:
            case FinalCanbus.CAR_WC2_GM_GL8 /* 393252 */:
            case FinalCanbus.CAR_WC2_GM_GL6 /* 458788 */:
            case FinalCanbus.CAR_WC2_ShuPing10JunYue /* 459097 */:
            case FinalCanbus.CAR_WC2_GM_WLD /* 524324 */:
            case FinalCanbus.CAR_WC2_ShuPingKeLuZi_Auto /* 524633 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao_L /* 590169 */:
            case FinalCanbus.CAR_WC2_GM_EXCELLE_19 /* 655396 */:
            case FinalCanbus.CAR_WC2_GM_EXCELLE_18 /* 720932 */:
            case FinalCanbus.CAR_WC2_GM_GL8_10_13 /* 786468 */:
            case FinalCanbus.CAR_WC2_GM_GL8_14_16 /* 852004 */:
            case FinalCanbus.CAR_WC2_GM_Encore_12_15 /* 917540 */:
            case FinalCanbus.CAR_WC2_GM_Encore_16_19 /* 983076 */:
            case FinalCanbus.CAR_WC2_GM_Regal_09_13 /* 1048612 */:
            case FinalCanbus.CAR_WC2_GM_Lacrosse_10_13 /* 1114148 */:
            case FinalCanbus.CAR_WC2_GM_Lacrosse_18 /* 1179684 */:
            case FinalCanbus.CAR_WC2_GM_Excelle_XT /* 1245220 */:
            case FinalCanbus.CAR_WC2_GM_Excelle_GT /* 1310756 */:
            case FinalCanbus.CAR_WC2_GM_AVEO_11 /* 1376292 */:
            case FinalCanbus.CAR_WC2_GM_Orlando_11 /* 1441828 */:
            case FinalCanbus.CAR_WC2_GM_Trax_13_18 /* 1507364 */:
            case FinalCanbus.CAR_WC2_GM_Cruze_08_14 /* 1572900 */:
            case FinalCanbus.CAR_WC2_GM_Cruze_15 /* 1638436 */:
            case FinalCanbus.CAR_WC2_GM_Malibu_13 /* 1703972 */:
            case FinalCanbus.CAR_WC2_GM_Spin_13 /* 1769508 */:
            case FinalCanbus.CAR_WC2_GM_Astra_09_14 /* 1835044 */:
            case FinalCanbus.CAR_WC2_GM_Astra_15 /* 1900580 */:
            case FinalCanbus.CAR_WC2_GM_Mokka_12_16 /* 1966116 */:
            case FinalCanbus.CAR_WC2_GM_MokkaX_17 /* 2031652 */:
            case FinalCanbus.CAR_WC2_GM_Insignia_08_12 /* 2097188 */:
            case FinalCanbus.CAR_WC2_GM_Insignia_13_16 /* 2162724 */:
            case FinalCanbus.CAR_WC2_GM_Regal_14 /* 2228260 */:
            case FinalCanbus.CAR_WC2_GM_ENVISION_14 /* 2293796 */:
            case FinalCanbus.CAR_WC2_GM_Lacrosse_14 /* 2359332 */:
            case FinalCanbus.CAR_WC2_GM_Verano_15 /* 2424868 */:
            case FinalCanbus.CAR_WC2_GM_Verano_GS_16 /* 2490404 */:
            case FinalCanbus.CAR_WC2_GM_MalibuXL_16_18 /* 2555940 */:
            case FinalCanbus.CAR_WC2_GM_MalibuXL_19 /* 2621476 */:
            case FinalCanbus.CAR_WC2_GM_Equinox_17 /* 2687012 */:
            case FinalCanbus.CAR_WC2_GM_Sail3_15 /* 2752548 */:
            case FinalCanbus.CAR_WC2_GM_Onix_16 /* 2818084 */:
            case FinalCanbus.CAR_WC2_GM_LOVA_16_18 /* 2883620 */:
            case FinalCanbus.CAR_WC2_GM_Excelle_15_18 /* 2949156 */:
            case FinalCanbus.CAR_WC2_GM_Monza_19 /* 3014692 */:
            case FinalCanbus.CAR_WC2_GM_GL8_28T_ES /* 3080228 */:
            case FinalCanbus.CAR_WC2_GM_GL8_20 /* 3145764 */:
            case FinalCanbus.CAR_WC2_GM_Trax_19 /* 3211300 */:
            case FinalCanbus.CAR_WC2_GM_Trailblazer_20 /* 3276836 */:
            case FinalCanbus.CAR_WC2_GM_S10_12 /* 3342372 */:
            case FinalCanbus.CAR_WC2_GM_Karl_15 /* 3407908 */:
            case FinalCanbus.CAR_WC2_GM_Encore_GX_20 /* 3473444 */:
            case FinalCanbus.CAR_WC2_GM_Encore_20 /* 3538980 */:
            case FinalCanbus.CAR_WC2_GM_CorsaE_14_19 /* 3604516 */:
            case FinalCanbus.CAR_WC2_GM_Adam_13_19 /* 3670052 */:
            case FinalCanbus.CAR_WC2_GM_Insignia_17 /* 3735588 */:
            case FinalCanbus.CAR_WC2_GM_Sierra_14_18 /* 3801124 */:
            case FinalCanbus.CAR_WC2_GM_Trailblazer_14_18 /* 3866660 */:
            case FinalCanbus.CAR_WC2_GM_Suburban_15 /* 3932196 */:
            case FinalCanbus.CAR_WC2_GM_Tahoe_16_18 /* 3997732 */:
            case FinalCanbus.CAR_WC2_GM_Colorado_18 /* 4063268 */:
            case FinalCanbus.CAR_WC2_GM_Kopach_12 /* 4128804 */:
            case FinalCanbus.CAR_WC2_OPEL_Meriva_10 /* 4194340 */:
            case FinalCanbus.CAR_WC2_GM_Onix_14 /* 4259876 */:
            case FinalCanbus.CAR_WC2_GM_Onix_19 /* 4325412 */:
            case FinalCanbus.CAR_WC2_GM_Montana_23 /* 4390948 */:
            case FinalCanbus.CAR_WC2_GM_Tracker_19 /* 4456484 */:
            case FinalCanbus.CAR_WC2_GM_Spin_Brazil_13 /* 4522020 */:
            case FinalCanbus.CAR_WC2_GM_S10_Brazil_10 /* 4587556 */:
            case FinalCanbus.CAR_WC2_GM_EQUINOX_22 /* 4653092 */:
            case FinalCanbus.CAR_WC2_GM_EQUINOX_22_H /* 4718628 */:
            case FinalCanbus.CAR_WC2_GM_Colorado_14 /* 4784164 */:
            case FinalCanbus.CAR_WC2_GM_Colorado_14_H /* 4849700 */:
            case FinalCanbus.CAR_WC2_GM_Silverado_07 /* 4915236 */:
            case FinalCanbus.CAR_WC2_GM_Silverado_14 /* 4980772 */:
            case FinalCanbus.CAR_WC2_GM_Silverado_14_H /* 5046308 */:
            case FinalCanbus.CAR_WC2_GM_Canyon_14 /* 5111844 */:
            case FinalCanbus.CAR_WC2_GM_Canyon_14_H /* 5177380 */:
            case FinalCanbus.CAR_WC2_GMC_Acadia_07 /* 5242916 */:
            case FinalCanbus.CAR_WC2_GMC_Yukon_07 /* 5308452 */:
            case FinalCanbus.CAR_WC2_GMC_Savana_08 /* 5373988 */:
            case FinalCanbus.CAR_WC2_GMC_Sierra_07 /* 5439524 */:
            case FinalCanbus.CAR_WC2_GMC_Sierra_14 /* 5505060 */:
            case FinalCanbus.CAR_WC2_GMC_Sierra_14_H /* 5570596 */:
            case FinalCanbus.CAR_WC2_GM_ExpressVan_08 /* 5636132 */:
            case FinalCanbus.CAR_WC2_GM_Impala_06 /* 5701668 */:
            case FinalCanbus.CAR_WC2_GM_Avalanch_07 /* 5767204 */:
            case FinalCanbus.CAR_WC2_GM_Tahoe_15_Auto /* 5832740 */:
            case FinalCanbus.CAR_WC2_GM_Escalade_15_Auto /* 5898276 */:
            case FinalCanbus.CAR_WC2_GM_Escalade_07_Auto /* 5963812 */:
            case FinalCanbus.CAR_WC2_GM_XinJunWei2013 /* 6029348 */:
            case FinalCanbus.CAR_WC2_GM_SAIL3 /* 6094884 */:
            case FinalCanbus.CAR_WC2_GM_Excelle_19 /* 6160420 */:
            case FinalCanbus.CAR_WC2_GM_Excelle_21 /* 6225956 */:
            case FinalCanbus.CAR_WC2_GM_ExcelleGX_18 /* 6291492 */:
            case FinalCanbus.CAR_WC2_GM_Regal_14_NoAir /* 6357028 */:
            case FinalCanbus.CAR_WC2_GM_Lacrosse_09_NoAir /* 6422564 */:
            case FinalCanbus.CAR_WC2_GM_Cruze_16_NoAir /* 6488100 */:
            case FinalCanbus.CAR_WC2_GM_Malibu_13_Hand /* 6553636 */:
            case FinalCanbus.CAR_WC2_GM_Malibu_13_Auto /* 6619172 */:
            case FinalCanbus.CAR_WC2_GM_Malibu_13_Auto_Double /* 6684708 */:
            case FinalCanbus.CAR_WC2_GM_Malibu_13_Top /* 6750244 */:
            case FinalCanbus.CAR_WC2_GM_Camaro_10 /* 6815780 */:
            case FinalCanbus.CAR_WC2_GM_Camaro_10_NoAIr /* 6881316 */:
            case FinalCanbus.CAR_WC2_GM_Colorado_14_NoAir /* 6946852 */:
            case FinalCanbus.CAR_WC2_GM_Silverado_14_NoAir /* 7012388 */:
            case FinalCanbus.CAR_WC2_GM_Silverado_19_NoAir /* 7077924 */:
            case FinalCanbus.CAR_WC2_GMC_Yukon_14 /* 7143460 */:
            case FinalCanbus.CAR_WC2_GMC_Yukon_14_H /* 7208996 */:
            case FinalCanbus.CAR_WC2_GMC_Terrain_10 /* 7274532 */:
            case FinalCanbus.CAR_WC2_GMC_Terrain_10_NoAir /* 7340068 */:
            case FinalCanbus.CAR_WC2_GM_EQUINOX_17 /* 7405604 */:
                if (value > 18) {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText("AUTO");
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(8);
                } else {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(value).toString());
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(8);
                }
                break;
            case 38:
            case 101:
            case 282:
            case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
            case FinalCanbus.CAR_WC1_Nawala_Philippine /* 131110 */:
            case FinalCanbus.CAR_WC1_QiJun_H /* 131173 */:
            case FinalCanbus.CAR_WC2_17MingJueRuiTeng /* 131354 */:
            case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6 /* 131379 */:
            case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6_H /* 196915 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria /* 328124 */:
            case FinalCanbus.CAR_WC1_17QiJun /* 393317 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria_H /* 393660 */:
            case FinalCanbus.CAR_WC1_17QiJun_H /* 458853 */:
            case FinalCanbus.CAR_WC1_Tuda /* 524389 */:
            case FinalCanbus.CAR_WC1_19QiJun /* 589925 */:
            case FinalCanbus.CAR_RZC_OD_DongNanDX5 /* 590153 */:
            case FinalCanbus.CAR_WC1_Tuda_Hand /* 655461 */:
            case FinalCanbus.CAR_WC1_Nawala /* 720997 */:
            case FinalCanbus.CAR_WC1_Nawala_Hand /* 786533 */:
            case FinalCanbus.CAR_WC1_Tuda_H /* 852069 */:
            case FinalCanbus.CAR_DAOJUN_OD_ATS /* 852316 */:
            case FinalCanbus.CAR_RZC_FengShen19_20AX7 /* 917759 */:
            case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
            case FinalCanbus.CAR_RZC_FengShen19_20AX7_H /* 983295 */:
            case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
            case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
            case FinalCanbus.CAR_RZC_XP1_BeiQiBJ40_21_H /* 1048972 */:
            case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
            case FinalCanbus.CAR_RZC_17_18KeleiAo /* 1180050 */:
            case FinalCanbus.CAR_OD_RZC_ShangQiDaTong22G50 /* 1310985 */:
            case FinalCanbus.CAR_RZC_17_18KeleiAo_M /* 1311122 */:
            case FinalCanbus.CAR_446_WC2_Teyes_XianDai_All_22SantaFe /* 1311166 */:
            case FinalCanbus.CAR_RZC_17_18KeleiAo_H /* 1376658 */:
            case FinalCanbus.CAR_RZC_FengShen_X37_21 /* 1442047 */:
            case FinalCanbus.CAR_OD_RZC_ShangQiDaTong19G50 /* 1442057 */:
            case FinalCanbus.CAR_455_LZ_GMC_Sierra_19_RScreen /* 1507783 */:
            case FinalCanbus.CAR_455_LZ_Chevrolet_Silverado_19_RScreen /* 1573319 */:
            case FinalCanbus.CAR_RZC_FengShen15AX7 /* 1638655 */:
            case FinalCanbus.CAR_OD_RZC_DaTong_25Dana_V1 /* 1638665 */:
            case FinalCanbus.CAR_RZC_MEGANE_Turkey_L /* 1638802 */:
            case FinalCanbus.CAR_RZC_FengShen19AX7_Hand /* 1704191 */:
            case FinalCanbus.CAR_OD_RZC_DaTong_25Dana_M1 /* 1704201 */:
            case FinalCanbus.CAR_RZC_MEGANE_Turkey_M /* 1704338 */:
            case FinalCanbus.CAR_RZC_FengShen15AX7_View /* 1769727 */:
            case FinalCanbus.CAR_RZC_MEGANE_Turkey_H /* 1769874 */:
            case FinalCanbus.CAR_RZC_KADJAR_Turkey /* 1966482 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_15Carnival /* 1966524 */:
            case FinalCanbus.CAR_RZC_CLIO5_Turkey /* 2032018 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_15Carnival_H /* 2032060 */:
            case FinalCanbus.CAR_RZC_CLIO5_Turkey_M /* 2097554 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_23NewZealand /* 2097596 */:
            case FinalCanbus.CAR_RZC_CLIO5_Turkey_H /* 2163090 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_23NewZealand_H /* 2163132 */:
            case FinalCanbus.CAR_453_LZ_GM_Camaro_17 /* 2163141 */:
            case FinalCanbus.CAR_RZC_MEGANE_Turkey_L_AUTO /* 2228626 */:
            case FinalCanbus.CAR_453_LZ_GM_GMC_TERRAIN_17 /* 2228677 */:
            case FinalCanbus.CAR_453_LZ_GM_Equinox_17 /* 2294213 */:
            case FinalCanbus.CAR_446_WC2_XianDai_CUSTO /* 2687422 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra /* 2949564 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra_H /* 3015100 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra_EV /* 3211708 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_20NIRO /* 3342780 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_12K9 /* 3408316 */:
            case FinalCanbus.CAR_444_WC2_Shuanglong_All_11Korando /* 3473852 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria_Amp /* 3539388 */:
            case FinalCanbus.CAR_RZC_Turkey_22KOLEOS_L /* 3604882 */:
            case FinalCanbus.CAR_RZC_Turkey_22KOLEOS_M /* 3670418 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_18Lafesta /* 3670460 */:
            case FinalCanbus.CAR_RZC_Turkey_22KOLEOS_H /* 3735954 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_17SoNaTa_USA /* 3735996 */:
            case FinalCanbus.CAR_RZC_Turkey_16KADJAR_L /* 3801490 */:
            case FinalCanbus.CAR_RZC_Turkey_16KADJAR_M /* 3867026 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_19Shengda_H /* 3867067 */:
            case FinalCanbus.CAR_RZC_Turkey_16KADJAR_H /* 3932562 */:
            case FinalCanbus.CAR_RZC_Turkey_22CAPTUR_L /* 3998098 */:
            case FinalCanbus.CAR_444_Tyes_WC2_XianDai_All_21Elantra_EV /* 3998140 */:
            case FinalCanbus.CAR_RZC_Turkey_22CAPTUR_M /* 4063634 */:
            case FinalCanbus.CAR_RZC_Turkey_22CAPTUR_H /* 4129170 */:
            case FinalCanbus.CAR_444_WC2_VinFast_VF5 /* 4129212 */:
            case FinalCanbus.CAR_RZC_Turkey_22TRAFIC_L /* 4194706 */:
            case FinalCanbus.CAR_RZC_Turkey_22TRAFIC_M /* 4260242 */:
            case FinalCanbus.CAR_RZC_Turkey_22TRAFIC_H /* 4325778 */:
            case FinalCanbus.CAR_RZC_Turkey_22TALIANT_L /* 4391314 */:
            case FinalCanbus.CAR_444_WC2_JiangHuai_JiayueX7 /* 4391356 */:
            case FinalCanbus.CAR_RZC_Turkey_22TALIANT_M /* 4456850 */:
            case FinalCanbus.CAR_444_WC2_JiangHuai_JiayueX7_H /* 4456892 */:
            case FinalCanbus.CAR_RZC_Turkey_22TALIANT_H /* 4522386 */:
            case FinalCanbus.CAR_RZC_Turkey_22DACIA_JOGGER_L /* 4587922 */:
            case FinalCanbus.CAR_RZC_Turkey_22DACIA_JOGGER_M /* 4653458 */:
            case FinalCanbus.CAR_RZC_Turkey_22DACIA_JOGGER_H /* 4718994 */:
            case FinalCanbus.CAR_RZC_Turkey_22DACIA_SANDERO_L /* 4784530 */:
            case FinalCanbus.CAR_RZC_Turkey_22DACIA_SANDERO_M /* 4850066 */:
            case FinalCanbus.CAR_RZC_Turkey_22DACIA_SANDERO_H /* 4915602 */:
            case FinalCanbus.CAR_RZC_Turkey_23MEGANE4_L /* 4981138 */:
            case FinalCanbus.CAR_RZC_Turkey_23MEGANE4_M /* 5046674 */:
            case FinalCanbus.CAR_RZC_Turkey_23MEGANE4_H /* 5112210 */:
            case FinalCanbus.CAR_RZC_Turkey_22TALISMAN_L /* 5177746 */:
            case FinalCanbus.CAR_RZC_Turkey_22TALISMAN_M /* 5243282 */:
            case FinalCanbus.CAR_RZC_Turkey_22TALISMAN_H /* 5308818 */:
            case FinalCanbus.CAR_RZC_Turkey_22DACIA_DUSTER_L /* 5374354 */:
            case FinalCanbus.CAR_RZC_Turkey_22DACIA_DUSTER_M /* 5439890 */:
            case FinalCanbus.CAR_455_LZ_GM_Cadillac_CT5_Screen /* 5439943 */:
            case FinalCanbus.CAR_RZC_Turkey_22DACIA_DUSTER_H /* 5505426 */:
            case FinalCanbus.CAR_RZC_Turkey_22EXPRESS_L /* 5570962 */:
            case FinalCanbus.CAR_RZC_Turkey_22EXPRESS_M /* 5636498 */:
            case FinalCanbus.CAR_RZC_Turkey_22EXPRESS_H /* 5702034 */:
            case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9 /* 5702084 */:
            case FinalCanbus.CAR_RZC_Russian_20ARKANA_L /* 5767570 */:
            case FinalCanbus.CAR_RZC_Russian_20ARKANA_M /* 5833106 */:
            case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_Auto /* 5833156 */:
            case FinalCanbus.CAR_455_RZC_Sanlin_OULANDE_20Overseas /* 5833159 */:
            case FinalCanbus.CAR_RZC_Russian_20ARKANA_H /* 5898642 */:
            case FinalCanbus.CAR_455_RZC_Sanlin_OULANDE_20Overseas_L /* 5898695 */:
            case FinalCanbus.CAR_RZC_Turkey_22KADJAR_M /* 5964178 */:
            case FinalCanbus.CAR_RZC_CLIO5_Turkey_L_ATUO /* 6029714 */:
            case FinalCanbus.CAR_RZC_17LIENUO_M_NoAQS /* 6095250 */:
            case FinalCanbus.CAR_RZC_Renault_SM6_18 /* 6226322 */:
            case FinalCanbus.CAR_RZC_Renault_SCENIC_16 /* 6291858 */:
            case FinalCanbus.CAR_RZC_Renault_SM6_18_M /* 6357394 */:
            case FinalCanbus.CAR_RZC_Renault_SCENIC_16_M /* 6422930 */:
            case FinalCanbus.CAR_452_XC_Ford_Escape_13_17 /* 6422980 */:
            case FinalCanbus.CAR_RZC_Renault_SM6_18_H /* 6488466 */:
            case FinalCanbus.CAR_452_XC_Ford_edge_11_13 /* 6488516 */:
            case FinalCanbus.CAR_RZC_Renault_SCENIC_16_H /* 6554002 */:
            case FinalCanbus.CAR_452_XC_Ford_Raptor_F150_09_14 /* 6554052 */:
            case FinalCanbus.CAR_444_WC2_Beiqi_Zhixing_19 /* 6619580 */:
            case FinalCanbus.CAR_452_XC_Ford_edge_15_17 /* 6619588 */:
            case FinalCanbus.CAR_452_XC_Ford_Mondeo_13_18 /* 6685124 */:
            case FinalCanbus.CAR_RZC_Renault_Dokker_18 /* 6750610 */:
            case FinalCanbus.CAR_RZC_Renault_Dokker_18_H /* 6816146 */:
            case FinalCanbus.CAR_439_HC_Ruijie /* 6816183 */:
            case FinalCanbus.CAR_RZC_17LIENUO_L_AUTO /* 6881682 */:
            case FinalCanbus.CAR_439_HC_Ruijie_H /* 6881719 */:
            case FinalCanbus.CAR_RZC_17LIENUO_M_NoAQS_2 /* 6947218 */:
            case FinalCanbus.CAR_454_LZ_GM_Camaro_17_Auto /* 6947270 */:
            case FinalCanbus.CAR_RZC_Renault_QM6_18_L /* 7012754 */:
            case FinalCanbus.CAR_454_LZ_GM_Equinox_17_Auto /* 7012806 */:
            case FinalCanbus.CAR_RZC_Renault_QM6_18_M /* 7078290 */:
            case FinalCanbus.CAR_RZC_HavalH6Couple_BLUE_TOP /* 7078327 */:
            case FinalCanbus.CAR_RZC_Renault_QM6_18_H /* 7143826 */:
            case FinalCanbus.CAR_RZC_HavalH6Couple_RED_TOP /* 7143863 */:
            case FinalCanbus.CAR_RZC_Renault_ZOE_22_L /* 7209362 */:
            case FinalCanbus.CAR_RZC_Renault_ZOE_22_M /* 7274898 */:
            case FinalCanbus.CAR_RZC_Renault_ZOE_22_H /* 7340434 */:
            case FinalCanbus.CAR_RZC_Renault_DUSTER_ETECH_24_L /* 7405970 */:
            case FinalCanbus.CAR_RZC_Renault_DUSTER_ETECH_24_M /* 7471506 */:
            case FinalCanbus.CAR_452_XC_Rongwei_ALl /* 7471556 */:
            case FinalCanbus.CAR_RZC_Renault_DUSTER_ETECH_24_H /* 7537042 */:
            case FinalCanbus.CAR_452_XC_GM_ALl /* 7537092 */:
            case FinalCanbus.CAR_RZC_Renault_Kardian_24_L /* 7602578 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6Couple_19 /* 7602615 */:
            case FinalCanbus.CAR_452_OD_HZ_Nezha /* 7602628 */:
            case FinalCanbus.CAR_RZC_Renault_Kardian_24_M /* 7668114 */:
            case FinalCanbus.CAR_BNR_02_09Toyato_Prado /* 7668151 */:
            case FinalCanbus.CAR_RZC_Renault_Kardian_24_H /* 7733650 */:
            case FinalCanbus.CAR_BNR_02_09Toyato_Prado_H /* 7733687 */:
            case FinalCanbus.CAR_RZC_Renault_XM3_24_L /* 7799186 */:
            case FinalCanbus.CAR_455_OD_CZH_Qichen_D60_EV /* 7799239 */:
            case FinalCanbus.CAR_RZC_Renault_XM3_24_M /* 7864722 */:
            case FinalCanbus.CAR_RZC_Renault_XM3_24_H /* 7930258 */:
            case FinalCanbus.CAR_RZC_Renault_ARKANAEV_25_L /* 7995794 */:
            case FinalCanbus.CAR_RZC_Renault_ARKANAEV_25_M /* 8061330 */:
            case FinalCanbus.CAR_RZC_Renault_ARKANAEV_25_H /* 8126866 */:
            case FinalCanbus.CAR_RZC_Nissan_Townstar_24_L /* 8192402 */:
            case FinalCanbus.CAR_RZC_Nissan_Townstar_24_M /* 8257938 */:
            case FinalCanbus.CAR_RZC_Nissan_Townstar_24_H /* 8323474 */:
            case FinalCanbus.CAR_RZC_Renault_SM6_18_LAuto /* 8389010 */:
            case FinalCanbus.CAR_RZC_Renault_SM6_18_M_NoAQS /* 8454546 */:
            case FinalCanbus.CAR_RZC_Renault_SM6_18_M_NoAQS2 /* 8520082 */:
            case FinalCanbus.CAR_455_RZC_Sanlin_Triton_22 /* 8520135 */:
            case FinalCanbus.CAR_RZC_Renault_QM6_18_LAuto /* 8585618 */:
            case FinalCanbus.CAR_455_RZC_Sanlin_Triton_22t_H /* 8585671 */:
            case FinalCanbus.CAR_RZC_Renault_QM6_18_M_NoAQS /* 8651154 */:
            case FinalCanbus.CAR_455_RZC_Sanlin_Triton_22_Top /* 8651207 */:
            case FinalCanbus.CAR_RZC_Renault_QM6_18_M_NoAQS2 /* 8716690 */:
            case FinalCanbus.CAR_453_LZ_Jili_Boyue_18 /* 8782277 */:
            case FinalCanbus.CAR_453_LZ_Jili_Boyue_18_H /* 8847813 */:
            case FinalCanbus.CAR_455_YDT_OD_Qichen_D60_EV /* 8913351 */:
            case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_Screen /* 9437639 */:
            case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_Screen /* 9503175 */:
            case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_RScreen /* 9568711 */:
            case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_RScreen /* 9634247 */:
            case FinalCanbus.CAR_455_OD_HZ_Nezha_H /* 9699783 */:
            case FinalCanbus.CAR_454_OD_Qichen_D60_EV /* 9961926 */:
            case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_EV /* 10355140 */:
            case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport /* 10420678 */:
            case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport_H /* 10486214 */:
            case FinalCanbus.CAR_452_KYC_Zhonghua_All /* 10617284 */:
            case FinalCanbus.CAR_452_KYC_Zhonghua_All_H /* 10682820 */:
            case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7 /* 10748356 */:
            case FinalCanbus.CAR_454_OD_Yiqi_Jiefang_J6G_23 /* 10748358 */:
            case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7_H /* 10813892 */:
            case FinalCanbus.CAR_454_OD_Yiqi_Jiefang_J7_23 /* 10813894 */:
            case FinalCanbus.CAR_439_RZC_Haval_18_19H6 /* 11272631 */:
            case FinalCanbus.CAR_454_OD_Yutong_Qingka /* 11338182 */:
            case FinalCanbus.CAR_455_OD_RZC_DongFeng_Fengxing_16CM7 /* 11469255 */:
            case FinalCanbus.CAR_455_OD_YDT_DongFeng_Fengxing_18T5 /* 11534791 */:
            case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_21IX35 /* 11993532 */:
            case FinalCanbus.CAR_454_LZ_Chevrolet_Silverado_19_Screen /* 11993542 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_21IX35_H /* 12059068 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_20IX25 /* 12124604 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_20IX25_H /* 12190140 */:
            case FinalCanbus.CAR_452_OD_ChangCheng_Fengjun5 /* 13763012 */:
            case FinalCanbus.CAR_454_OD_ChangAn_Raeton /* 14352838 */:
            case FinalCanbus.CAR_454_OD_ChangAn_Raeton_H /* 14418374 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_18OPTIMA /* 15073723 */:
            case FinalCanbus.CAR_439_HC_Ford_Explorer /* 15335863 */:
            case FinalCanbus.CAR_454_CZH_OUDI_BYD_ALL /* 15663558 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_4Screen /* 15729095 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_4Screen /* 15794631 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_8Screen /* 15860167 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_8Screen /* 15925703 */:
            case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport_Top /* 16056774 */:
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(8);
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setProgress(value);
                break;
            case 160:
            case FinalCanbus.CAR2_RZC_XP1_DaZhong_GaoErFu7_H /* 131232 */:
            case FinalCanbus.CAR_RZC_XP1_MaiTeng /* 196768 */:
            case FinalCanbus.CAR_RZC_TuGuan_L /* 262304 */:
            case FinalCanbus.CAR_RZC_TuAng /* 327840 */:
            case FinalCanbus.CAR2_RZC_DaZhong_Tange /* 589984 */:
            case FinalCanbus.CAR2_RZC_DaZhong_MQB_E /* 655520 */:
            case FinalCanbus.CAR_RZC_TuGuan_L_20 /* 721056 */:
            case FinalCanbus.CAR_RZC_MQB_18_19Lavida_plus /* 786592 */:
            case FinalCanbus.CAR_RZC_MQB_11_18Sagitar /* 852128 */:
            case FinalCanbus.CAR_RZC_MQB_19Sagitar /* 917664 */:
            case FinalCanbus.CAR_RZC_MQB_11_17Passat /* 983200 */:
            case FinalCanbus.CAR_RZC_MQB_19Passat /* 1048736 */:
            case FinalCanbus.CAR_RZC_MQB_19Tharu /* 1179808 */:
            case FinalCanbus.CAR_RZC_MQB_14_19Golf7 /* 1310880 */:
            case FinalCanbus.CAR_RZC_MQB_19Bora /* 1376416 */:
            case FinalCanbus.CAR_RZC_MQB_14_19Lamando /* 1441952 */:
            case FinalCanbus.CAR_RZC_MQB_19Polo /* 1507488 */:
            case FinalCanbus.CAR_RZC_MQB_19CC /* 1573024 */:
            case FinalCanbus.CAR_RZC_MQB_19T_Cross /* 1638560 */:
            case FinalCanbus.CAR_RZC_MQB_16_18TouranL /* 1704096 */:
            case FinalCanbus.CAR_RZC_MQB_17_18C_Trek /* 1769632 */:
            case FinalCanbus.CAR_RZC_MQB_16_19Golf_jialv /* 1835168 */:
            case FinalCanbus.CAR_RZC_MQB_19T_ROC /* 1900704 */:
            case FinalCanbus.CAR_RZC_MQB_19Tayron /* 1966240 */:
            case FinalCanbus.CAR_RZC_MQB_13_14Octavia /* 2031776 */:
            case FinalCanbus.CAR_RZC_MQB_15_19Octavia /* 2097312 */:
            case FinalCanbus.CAR_RZC_MQB_13_15Superb /* 2162848 */:
            case FinalCanbus.CAR_RZC_MQB_16_18Superb /* 2228384 */:
            case FinalCanbus.CAR_RZC_MQB_18Kamiq /* 2293920 */:
            case FinalCanbus.CAR_RZC_MQB_18_19Karoq /* 2359456 */:
            case FinalCanbus.CAR_RZC_MQB_17_19Kodiaq /* 2424992 */:
            case FinalCanbus.CAR_RZC_MQB_14_18Caravan /* 2490528 */:
            case FinalCanbus.CAR_RZC_MQB_19Jetta_VS5 /* 2556064 */:
            case FinalCanbus.CAR_RZC_MQB_11_17Touareg /* 2621600 */:
            case FinalCanbus.CAR_RZC_MQB_09_19Multivan /* 2687136 */:
            case FinalCanbus.CAR_RZC_MQB_Jetta_Brazil /* 2752672 */:
            case FinalCanbus.CAR_RZC_MQB_SUPERB_Turkey /* 2818208 */:
            case FinalCanbus.CAR_RZC_MQB_Huiang_21 /* 3080352 */:
            case FinalCanbus.CAR_RZC_MQB_20Tayron_GTE /* 3145888 */:
            case FinalCanbus.CAR_RZC_MQB_20Jetta_VS7 /* 3211424 */:
            case FinalCanbus.CAR_RZC_MQB_20Viloran /* 3276960 */:
            case FinalCanbus.CAR_RZC_MQB_21Golf8 /* 3342496 */:
            case FinalCanbus.CAR_RZC_MQB_16_18Weilan /* 3408032 */:
            case FinalCanbus.CAR_RZC_TuGuan_L_20_H /* 3473568 */:
            case FinalCanbus.CAR_6606_MQB_Lavida_23 /* 3539104 */:
            case FinalCanbus.CAR_RZC_MQB_17Passat_B8 /* 3604640 */:
            case FinalCanbus.CAR_RZC_MQB_All_360 /* 3670176 */:
            case FinalCanbus.CAR_RZC_MQB_Caddy_22 /* 3735712 */:
            case FinalCanbus.CAR_RZC_MaiTeng_20_H_EC /* 3801248 */:
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(12);
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setProgress(value);
                break;
            case 372:
            case FinalCanbus.CAR_WC1_Jeep_ZiYouGuang_M /* 65908 */:
            case FinalCanbus.CAR_WC1_Jeep_ZiYouGuang_H /* 131444 */:
            case FinalCanbus.CAR_WC1_Jeep_17ZhiNanZhe /* 262516 */:
            case FinalCanbus.CAR_WC1_Jeep_17ZhiNanZhe_H /* 328052 */:
            case FinalCanbus.CAR_WC1_Jeep_18ZiYouXia /* 393588 */:
            case FinalCanbus.CAR_WC1_Jeep_18ZiYouXia_H /* 459124 */:
            case FinalCanbus.CAR_WC1_Jeep_19ZiYouXia_W /* 524660 */:
            case FinalCanbus.CAR_WC1_Fiat_19_500X /* 590196 */:
            case FinalCanbus.CAR_WC1_Jeep_13_Dodge_JCUV /* 655732 */:
            case FinalCanbus.CAR_WC1_Jeep_13_Dodge_JCUV_CD /* 721268 */:
            case FinalCanbus.CAR_WC1_Jeep_18_Zhihuiguan /* 852340 */:
            case FinalCanbus.CAR_WC1_Jeep_15_RAM /* 917876 */:
            case FinalCanbus.CAR_WC1_Jeep_18_Zhihuiguan_H /* 983412 */:
            case FinalCanbus.CAR_WC1_Jeep_15_RAM_H /* 1048948 */:
            case FinalCanbus.CAR_WC1_TMK_BENZ_MPV_ALL /* 1114484 */:
            case FinalCanbus.CAR_WC1_Jeep_20_GrdCherokee_H /* 1180020 */:
            case FinalCanbus.CAR_WC1_Jeep_19_MuMaRen_H /* 1245556 */:
            case FinalCanbus.CAR_WC1_Jeep_18ZhiNanZhe_EU /* 1311092 */:
            case FinalCanbus.CAR_WC1_Jeep_Chrysler_300C_11 /* 1376628 */:
            case FinalCanbus.CAR_WC1_Jeep_Chrysler_300C_11CD /* 1442164 */:
            case FinalCanbus.CAR_WC1_Jeep_19_MuMaRen_L /* 1507700 */:
            case FinalCanbus.CAR_WC1_Jeep_20_GrdCherokee_L /* 1573236 */:
            case FinalCanbus.CAR_WC1_Jeep_18_Zhihuiguan_M /* 1638772 */:
            case FinalCanbus.CAR_WC1_Jeep_15_RAM_M /* 1704308 */:
            case FinalCanbus.CAR_WC1_Jeep_20_GrdCherokee_M /* 1769844 */:
            case FinalCanbus.CAR_WC1_Jeep_19_MuMaRen_M /* 1835380 */:
            case FinalCanbus.CAR_WC1_Jeep_19_RAM /* 1900916 */:
            case FinalCanbus.CAR_WC1_Jeep_19_RAM_M /* 1966452 */:
            case FinalCanbus.CAR_WC1_Jeep_19_RAM_H /* 2031988 */:
                if (value >= 8) {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText("AUTO");
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(7);
                } else {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(value).toString());
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(7);
                }
                break;
            case FinalCanbus.CAR_RZC_XP1_BeiQiM50F /* 65932 */:
            case FinalCanbus.CAR_WC2_20BaoJun530_Auto /* 393462 */:
            case FinalCanbus.CAR_WC2_20BaoJun530_Hand /* 458998 */:
            case FinalCanbus.CAR_RZC_20BaoJunRS3 /* 459062 */:
            case FinalCanbus.CAR_WC2_20BaoJunRS5 /* 524534 */:
            case FinalCanbus.CAR_OD_RZC_20BaoJunRS3 /* 590134 */:
            case FinalCanbus.CAR_OD_RZC_Wuling_Xingchen /* 655670 */:
            case FinalCanbus.CAR_RZC_Wuling_Xingchen /* 721206 */:
            case FinalCanbus.CAR_RZC_Wuling_Kaijie /* 786742 */:
            case FinalCanbus.CAR_RZC_Wuling_Jiachen /* 852278 */:
            case FinalCanbus.CAR_RZC_20BaoJunRS3_Auto /* 917814 */:
            case FinalCanbus.CAR_RZC_Wuling_Xingchen_Auto /* 983350 */:
            case FinalCanbus.CAR_RZC_Wuling_Kaijie_Auto /* 1048886 */:
            case FinalCanbus.CAR_RZC_Wuling_Jiachen_Auto /* 1114422 */:
            case FinalCanbus.CAR_RZC_Wuling_Xingchi /* 1179958 */:
            case FinalCanbus.CAR_RZC_Wuling_Xingchi_Auto /* 1245494 */:
            case FinalCanbus.CAR_454_OD_Xinte_DEV1_H /* 7274950 */:
            case FinalCanbus.CAR_439_DJ_Rongwei_i5 /* 13959607 */:
            case FinalCanbus.CAR_439_DJ_Rongwei_i5_H /* 14025143 */:
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(6);
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setProgress(value);
                break;
            case FinalCanbus.CAR_444_WC2_Wuling_Xingguang70_24 /* 459196 */:
            case FinalCanbus.CAR_OD_RZC_Wuling_23XingGuang /* 1311030 */:
            case FinalCanbus.CAR_453_LZ_ALFA_ROMEO /* 7930309 */:
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(9);
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setProgress(value);
                break;
            case FinalCanbus.CAR_RZC_Explorer /* 590158 */:
            case FinalCanbus.CAR_RZC_13_20Mengdiou /* 852302 */:
            case FinalCanbus.CAR_RZC_Mustang /* 1048910 */:
            case FinalCanbus.CAR_RZC_Ford_F150_12 /* 2294094 */:
            case FinalCanbus.CAR_RZC_Mustang_NO_CD /* 2359630 */:
            case FinalCanbus.CAR_RZC_Mustang_15_NO_CD /* 2621774 */:
            case FinalCanbus.CAR_RZC_Explorer_13 /* 3014990 */:
            case FinalCanbus.CAR_RZC_Ford_F150 /* 3080526 */:
            case FinalCanbus.CAR_RZC_Ford_Puma_22 /* 3670350 */:
            case FinalCanbus.CAR_RZC_Mustang_M /* 5374286 */:
            case FinalCanbus.CAR_RZC_Mustang_H /* 5439822 */:
            case FinalCanbus.CAR_RZC_Mustang_NOCD_M /* 5505358 */:
            case FinalCanbus.CAR_RZC_Mustang_NOCD_H /* 5570894 */:
            case FinalCanbus.CAR_RZC_Ford_Puma_22_M /* 5636430 */:
            case FinalCanbus.CAR_RZC_Ford_Puma_22_H /* 5701966 */:
            case FinalCanbus.CAR_RZC_Ford_BRONCO_22 /* 5767502 */:
            case FinalCanbus.CAR_RZC_Ford_BRONCO_22_M /* 5833038 */:
            case FinalCanbus.CAR_RZC_Ford_BRONCO_22_H /* 5898574 */:
            case FinalCanbus.CAR_RZC_Ford_MAVERICK_24 /* 5964110 */:
            case FinalCanbus.CAR_RZC_Ford_MAVERICK_24_M /* 6029646 */:
            case FinalCanbus.CAR_RZC_Ford_MAVERICK_24_H /* 6095182 */:
            case FinalCanbus.CAR_RZC_Ford_Explorer_24 /* 6160718 */:
            case FinalCanbus.CAR_RZC_Ford_Explorer_24_M /* 6226254 */:
            case FinalCanbus.CAR_RZC_Ford_Explorer_24_H /* 6291790 */:
            case FinalCanbus.CAR_RZC_Ford_RANGER_24 /* 6357326 */:
            case FinalCanbus.CAR_RZC_Ford_RANGER_24_M /* 6422862 */:
            case FinalCanbus.CAR_RZC_Ford_RANGER_24_H /* 6488398 */:
            case FinalCanbus.CAR_RZC_Ford_F250_09 /* 6553934 */:
            case FinalCanbus.CAR_RZC_Ford_Expedition_07 /* 6619470 */:
            case FinalCanbus.CAR_RZC_Ford_Expedition_15 /* 6685006 */:
            case FinalCanbus.CAR_RZC_Ford_Flex_13 /* 6750542 */:
            case FinalCanbus.CAR_455_LZ_Benz_C200_NTG5 /* 8192455 */:
            case FinalCanbus.CAR_455_LUZ_Benz_GLC_NTG50 /* 10027463 */:
            case FinalCanbus.CAR_454_KYC_Ford_Mustang_07_H /* 13631942 */:
            case FinalCanbus.CAR_454_KYC_Ford_Mustang_07_L /* 13697478 */:
                if (value == 15) {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText("AUTO");
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(7);
                } else {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(value).toString());
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(7);
                }
                break;
            case FinalCanbus.CAR_455_OD_Zhongtai_E200 /* 786887 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER /* 15139270 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER_H /* 15532486 */:
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(4);
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setProgress(value);
                break;
            case FinalCanbus.CAR_RZC_19MingjueHS /* 852241 */:
            case FinalCanbus.CAR_RZC_19RongWei_I5 /* 917777 */:
            case FinalCanbus.CAR_RZC_19RongWei_I6 /* 983313 */:
            case FinalCanbus.CAR_RZC_19MingjueHS_H /* 1048849 */:
            case FinalCanbus.CAR_RZC_19RongWei_I5_H /* 1114385 */:
            case FinalCanbus.CAR_RZC_19RongWei_RX8 /* 1310993 */:
            case FinalCanbus.CAR_RZC_Mingjue_20ZS /* 1376529 */:
            case FinalCanbus.CAR_RZC_Mingjue_20ZS_H /* 1442065 */:
            case FinalCanbus.CAR_RZC_19Mingjue_MG6 /* 1507601 */:
            case FinalCanbus.CAR_RZC_18RongWei_RX8 /* 1638673 */:
            case FinalCanbus.CAR_RZC_20RongWei_RX5 /* 1704209 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_21 /* 1835281 */:
            case FinalCanbus.CAR_RZC_21RongWei_I5 /* 1900817 */:
            case FinalCanbus.CAR_RZC_21RongWei_I5_H /* 1966353 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_21_L /* 2031889 */:
            case FinalCanbus.CAR_CZH_RZC_19Mingjue_MG6 /* 2097425 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_22_Top /* 2162961 */:
            case FinalCanbus.CAR_RZC_23MingjueHS /* 2228497 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_25 /* 2294033 */:
            case FinalCanbus.CAR_RZC_23RongWei_I5 /* 2425105 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_21_Top /* 2490641 */:
            case FinalCanbus.CAR_RZC_MingJue_MG6_21_Pro /* 2556177 */:
                if (value == 15) {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText("AUTO");
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(8);
                } else {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(value).toString());
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(8);
                }
                break;
            case FinalCanbus.CAR_446_WY_HCX_BBA_Screen /* 983486 */:
            case FinalCanbus.CAR_446_WY_HCX_BYD_TANG_Screen /* 1049022 */:
            case FinalCanbus.CAR_446_WY_HCX_BYD_QIN_Screen /* 1114558 */:
            case FinalCanbus.CAR_446_WY_HCX_WAY_VV7 /* 1442238 */:
            case FinalCanbus.CAR_446_WY_HCX_WAY_P8 /* 1507774 */:
            case FinalCanbus.CAR_446_WY_HCX_WAY_VV5 /* 1573310 */:
            case FinalCanbus.CAR_446_WY_HCX_WAY_VV6 /* 1638846 */:
            case FinalCanbus.CAR_446_Xiaolin_WY_LEXUS_Screen /* 2097598 */:
            case FinalCanbus.CAR_446_Xiaolin_WY_LEXUS_Screen_H /* 2163134 */:
            case FinalCanbus.CAR_444_WY_LEXUS_Screen /* 6095292 */:
            case FinalCanbus.CAR_444_WY_LEXUS_Screen_H /* 6488508 */:
            case FinalCanbus.CAR_444_WY_HCX_Chuanqi_21GS8_Screen /* 7012796 */:
                ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(String.valueOf(value / 2) + "." + ((value * 5) % 10));
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(14);
                break;
            case FinalCanbus.CAR_WC2_QiChen_T90 /* 1376651 */:
            case FinalCanbus.CAR_WC2_QiChen_D60 /* 1507723 */:
            case FinalCanbus.CAR_WC2_QiChen_D50EV /* 2425227 */:
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(10);
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setProgress(value);
                break;
            case FinalCanbus.CAR_444_WC2_Wuling_Kaijie_20_L /* 5505468 */:
            case FinalCanbus.CAR_444_WC2_Wuling_Kaijie_20_H /* 5571004 */:
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(6);
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setProgress(value);
                break;
            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300 /* 15008198 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300_H /* 15598022 */:
                if (value >= 5) {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText("5");
                }
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(5);
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setProgress(value);
                break;
            default:
                ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(value).toString());
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(7);
                break;
        }
        ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setProgress(value);
        ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).invalidate();
        if (ConstAllAirDara.C_AIR_POWER != 255 && ConstAllAirDara.U_AIR_POWER == 255 && this.pagenum == 0) {
            findViewById(R.id.air_sp_power).setBackgroundResource(value == 0 ? R.drawable.ic_hp_power_n : R.drawable.ic_hp_power_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateWaistHeatLeft() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_WAISTHEAT_LEFT];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
            case FinalCanbus.CAR_LZ_Dodge_RAM1500_09 /* 655647 */:
            case FinalCanbus.CAR_LZ_Dodge_RAM2500_09 /* 721183 */:
            case FinalCanbus.CAR_LZ_Dodge_RAM3500_09 /* 786719 */:
            case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
            case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
            case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
            case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
            case FinalCanbus.CAR_452_XC_Rongwei_ALl /* 7471556 */:
            case FinalCanbus.CAR_452_XC_GM_ALl /* 7537092 */:
                if ((vel & 8) != 0) {
                    findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_0);
                    findViewById(R.id.air_sp_waistheat_left).setBackgroundResource(R.drawable.ic_hp_waisthot_left_0);
                    break;
                } else {
                    findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_0);
                    findViewById(R.id.air_sp_waistheat_left).setBackgroundResource(R.drawable.ic_hp_waisthot_left_0);
                    switch (vel) {
                        case 1:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_3);
                            break;
                        case 5:
                            findViewById(R.id.air_sp_waistheat_left).setBackgroundResource(R.drawable.ic_hp_waisthot_left_1);
                            break;
                        case 6:
                            findViewById(R.id.air_sp_waistheat_left).setBackgroundResource(R.drawable.ic_hp_waisthot_left_2);
                            break;
                        case 7:
                            findViewById(R.id.air_sp_waistheat_left).setBackgroundResource(R.drawable.ic_hp_waisthot_left_3);
                            break;
                    }
                }
                break;
            case FinalCanbus.CAR_WC2_GM_Escalade_15_Auto /* 5898276 */:
                switch (vel) {
                    case 0:
                        findViewById(R.id.air_sp_waistheat_left).setBackgroundResource(R.drawable.ic_hp_waisthot_left_0);
                        break;
                    case 1:
                        findViewById(R.id.air_sp_waistheat_left).setBackgroundResource(R.drawable.ic_hp_waisthot_left_3);
                        break;
                }
                break;
            default:
                switch (vel) {
                    case 0:
                        findViewById(R.id.air_sp_waistheat_left).setBackgroundResource(R.drawable.ic_hp_waisthot_left_0);
                        break;
                    case 1:
                        findViewById(R.id.air_sp_waistheat_left).setBackgroundResource(R.drawable.ic_hp_waisthot_left_1);
                        break;
                    case 2:
                        findViewById(R.id.air_sp_waistheat_left).setBackgroundResource(R.drawable.ic_hp_waisthot_left_2);
                        break;
                    case 3:
                        findViewById(R.id.air_sp_waistheat_left).setBackgroundResource(R.drawable.ic_hp_waisthot_left_3);
                        break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateWaistHeatRight() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_WAISTHEAT_RIGHT];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
            case FinalCanbus.CAR_LZ_Dodge_RAM1500_09 /* 655647 */:
            case FinalCanbus.CAR_LZ_Dodge_RAM2500_09 /* 721183 */:
            case FinalCanbus.CAR_LZ_Dodge_RAM3500_09 /* 786719 */:
            case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
            case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
            case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
            case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
            case FinalCanbus.CAR_452_XC_Rongwei_ALl /* 7471556 */:
            case FinalCanbus.CAR_452_XC_GM_ALl /* 7537092 */:
                if ((vel & 8) != 0) {
                    findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_0);
                    findViewById(R.id.air_sp_waistheat_right).setBackgroundResource(R.drawable.ic_hp_waisthot_right_0);
                    break;
                } else {
                    findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_0);
                    findViewById(R.id.air_sp_waistheat_right).setBackgroundResource(R.drawable.ic_hp_waisthot_right_0);
                    switch (vel) {
                        case 1:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_3);
                            break;
                        case 5:
                            findViewById(R.id.air_sp_waistheat_right).setBackgroundResource(R.drawable.ic_hp_waisthot_right_1);
                            break;
                        case 6:
                            findViewById(R.id.air_sp_waistheat_right).setBackgroundResource(R.drawable.ic_hp_waisthot_right_2);
                            break;
                        case 7:
                            findViewById(R.id.air_sp_waistheat_right).setBackgroundResource(R.drawable.ic_hp_waisthot_right_3);
                            break;
                    }
                }
                break;
            case FinalCanbus.CAR_WC2_GM_Escalade_15_Auto /* 5898276 */:
                switch (vel) {
                    case 0:
                        findViewById(R.id.air_sp_waistheat_right).setBackgroundResource(R.drawable.ic_hp_waisthot_right_0);
                        break;
                    case 1:
                        findViewById(R.id.air_sp_waistheat_right).setBackgroundResource(R.drawable.ic_hp_waisthot_right_3);
                        break;
                }
                break;
            default:
                switch (vel) {
                    case 0:
                        findViewById(R.id.air_sp_waistheat_right).setBackgroundResource(R.drawable.ic_hp_waisthot_right_0);
                        break;
                    case 1:
                        findViewById(R.id.air_sp_waistheat_right).setBackgroundResource(R.drawable.ic_hp_waisthot_right_1);
                        break;
                    case 2:
                        findViewById(R.id.air_sp_waistheat_right).setBackgroundResource(R.drawable.ic_hp_waisthot_right_2);
                        break;
                    case 3:
                        findViewById(R.id.air_sp_waistheat_right).setBackgroundResource(R.drawable.ic_hp_waisthot_right_3);
                        break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateHeatLeft() {
        int flag;
        int heatlevel;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
            case FinalCanbus.CAR_LZ_Dodge_RAM1500_09 /* 655647 */:
            case FinalCanbus.CAR_LZ_Dodge_RAM2500_09 /* 721183 */:
            case FinalCanbus.CAR_LZ_Dodge_RAM3500_09 /* 786719 */:
            case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
            case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
            case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
            case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
            case FinalCanbus.CAR_452_XC_Rongwei_ALl /* 7471556 */:
            case FinalCanbus.CAR_452_XC_GM_ALl /* 7537092 */:
                if ((vel & 8) != 0) {
                    findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_0);
                    findViewById(R.id.air_sp_waistheat_left).setBackgroundResource(R.drawable.ic_hp_waisthot_left_0);
                    break;
                } else {
                    findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_0);
                    findViewById(R.id.air_sp_waistheat_left).setBackgroundResource(R.drawable.ic_hp_waisthot_left_0);
                    switch (vel) {
                        case 1:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_3);
                            break;
                        case 5:
                            findViewById(R.id.air_sp_waistheat_left).setBackgroundResource(R.drawable.ic_hp_waisthot_left_1);
                            break;
                        case 6:
                            findViewById(R.id.air_sp_waistheat_left).setBackgroundResource(R.drawable.ic_hp_waisthot_left_2);
                            break;
                        case 7:
                            findViewById(R.id.air_sp_waistheat_left).setBackgroundResource(R.drawable.ic_hp_waisthot_left_3);
                            break;
                    }
                }
                break;
            case FinalCanbus.CAR_RZC_Explorer /* 590158 */:
            case FinalCanbus.CAR_RZC_13_20Mengdiou /* 852302 */:
            case FinalCanbus.CAR_RZC_Mustang /* 1048910 */:
            case FinalCanbus.CAR_RZC_Ford_F150_12 /* 2294094 */:
            case FinalCanbus.CAR_RZC_Mustang_NO_CD /* 2359630 */:
            case FinalCanbus.CAR_RZC_Mustang_15_NO_CD /* 2621774 */:
            case FinalCanbus.CAR_RZC_Explorer_13 /* 3014990 */:
            case FinalCanbus.CAR_RZC_Mustang_M /* 5374286 */:
            case FinalCanbus.CAR_RZC_Mustang_H /* 5439822 */:
            case FinalCanbus.CAR_RZC_Mustang_NOCD_M /* 5505358 */:
            case FinalCanbus.CAR_RZC_Mustang_NOCD_H /* 5570894 */:
            case FinalCanbus.CAR_RZC_Ford_Explorer_24 /* 6160718 */:
            case FinalCanbus.CAR_RZC_Ford_Explorer_24_M /* 6226254 */:
            case FinalCanbus.CAR_RZC_Ford_Explorer_24_H /* 6291790 */:
                if (vel == 0) {
                    findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_0);
                    findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_0);
                    break;
                } else if (vel <= 3) {
                    findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_0);
                    switch (vel) {
                        case 1:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_3);
                            break;
                    }
                } else if (vel > 3) {
                    findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_0);
                    switch (vel - 3) {
                        case 1:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_3);
                            break;
                    }
                }
                break;
            case FinalCanbus.CAR_RZC_19MingjueHS /* 852241 */:
            case FinalCanbus.CAR_RZC_19RongWei_I5 /* 917777 */:
            case FinalCanbus.CAR_RZC_19RongWei_I6 /* 983313 */:
            case FinalCanbus.CAR_RZC_19MingjueHS_H /* 1048849 */:
            case FinalCanbus.CAR_RZC_19RongWei_I5_H /* 1114385 */:
            case FinalCanbus.CAR_RZC_19RongWei_RX8 /* 1310993 */:
            case FinalCanbus.CAR_RZC_Mingjue_20ZS /* 1376529 */:
            case FinalCanbus.CAR_RZC_Mingjue_20ZS_H /* 1442065 */:
            case FinalCanbus.CAR_RZC_19Mingjue_MG6 /* 1507601 */:
            case FinalCanbus.CAR_RZC_18RongWei_RX8 /* 1638673 */:
            case FinalCanbus.CAR_RZC_20RongWei_RX5 /* 1704209 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_21 /* 1835281 */:
            case FinalCanbus.CAR_RZC_21RongWei_I5 /* 1900817 */:
            case FinalCanbus.CAR_RZC_21RongWei_I5_H /* 1966353 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_21_L /* 2031889 */:
            case FinalCanbus.CAR_CZH_RZC_19Mingjue_MG6 /* 2097425 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_22_Top /* 2162961 */:
            case FinalCanbus.CAR_RZC_23MingjueHS /* 2228497 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_25 /* 2294033 */:
            case FinalCanbus.CAR_RZC_23RongWei_I5 /* 2425105 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_21_Top /* 2490641 */:
            case FinalCanbus.CAR_RZC_MingJue_MG6_21_Pro /* 2556177 */:
            case FinalCanbus.CAR_453_LZ_Jili_Boyue_18 /* 8782277 */:
            case FinalCanbus.CAR_453_LZ_Jili_Boyue_18_H /* 8847813 */:
                switch (vel) {
                    case 0:
                        findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_0);
                        break;
                    default:
                        findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_3);
                        break;
                }
                break;
            case FinalCanbus.CAR_455_LZ_GMC_Sierra_19_RScreen /* 1507783 */:
            case FinalCanbus.CAR_455_LZ_Chevrolet_Silverado_19_RScreen /* 1573319 */:
            case FinalCanbus.CAR_455_LZ_GM_Cadillac_CT5_Screen /* 5439943 */:
            case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_Screen /* 9437639 */:
            case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_Screen /* 9503175 */:
            case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_RScreen /* 9568711 */:
            case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_RScreen /* 9634247 */:
            case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
            case FinalCanbus.CAR_454_LZ_Chevrolet_Silverado_19_Screen /* 11993542 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_4Screen /* 15729095 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_4Screen /* 15794631 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_8Screen /* 15860167 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_8Screen /* 15925703 */:
                if ((vel & 8) != 0) {
                    heatlevel = 16 - vel;
                    flag = 1;
                } else {
                    flag = 0;
                    heatlevel = vel;
                }
                if (flag == 1) {
                    switch (heatlevel) {
                        case 1:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_3);
                            break;
                    }
                } else {
                    switch (heatlevel) {
                        case 0:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_0);
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_0);
                            break;
                        case 1:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_3);
                            break;
                    }
                }
                break;
            case FinalCanbus.CAR_CZH_OD_NISSAN_22Teana_Top /* 1572944 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_22Teana_Top_360View /* 1638480 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_16Trail /* 1704016 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_16Trail_H /* 1769552 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_16Xiaoke /* 1835088 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_16Xiaoke_H /* 1900624 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Xima_L /* 1966160 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Xima_H /* 2031696 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Loulan_L /* 2097232 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Loulan_H /* 2162768 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Tianlai_L /* 2228304 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Tianlai_H /* 2293840 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Xuanyi_L /* 2359376 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Xuanyi_H /* 2424912 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Lanniao_L /* 2490448 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Lannia_H /* 2555984 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Qida_L /* 2621520 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Qida_H /* 2687056 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Jinke_L /* 2752592 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Jinke_H /* 2818128 */:
                switch (vel) {
                    case 0:
                        findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_0);
                        break;
                    case 1:
                        findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_1);
                        break;
                    default:
                        findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_3);
                        break;
                }
                break;
            case FinalCanbus.CAR_WC2_GM_Escalade_15_Auto /* 5898276 */:
                int flag2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_LEFT];
                if (flag2 == 1) {
                    findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_0);
                    switch (vel) {
                        case 0:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_0);
                            break;
                        case 1:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_3);
                            break;
                    }
                } else {
                    findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_0);
                    switch (vel) {
                        case 0:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_0);
                            break;
                        case 1:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_3);
                            break;
                    }
                }
                break;
            default:
                switch (vel) {
                    case 0:
                        findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_0);
                        break;
                    case 1:
                        findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_1);
                        break;
                    case 2:
                        findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_2);
                        break;
                    case 3:
                        findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_3);
                        break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateHeatRight() {
        int flag;
        int heatlevel;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
            case FinalCanbus.CAR_LZ_Dodge_RAM1500_09 /* 655647 */:
            case FinalCanbus.CAR_LZ_Dodge_RAM2500_09 /* 721183 */:
            case FinalCanbus.CAR_LZ_Dodge_RAM3500_09 /* 786719 */:
            case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
            case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
            case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
            case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
            case FinalCanbus.CAR_452_XC_Rongwei_ALl /* 7471556 */:
            case FinalCanbus.CAR_452_XC_GM_ALl /* 7537092 */:
                if ((vel & 8) != 0) {
                    findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_0);
                    findViewById(R.id.air_sp_waistheat_right).setBackgroundResource(R.drawable.ic_hp_waisthot_right_0);
                    break;
                } else {
                    findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_0);
                    findViewById(R.id.air_sp_waistheat_right).setBackgroundResource(R.drawable.ic_hp_waisthot_right_0);
                    switch (vel) {
                        case 1:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_3);
                            break;
                        case 5:
                            findViewById(R.id.air_sp_waistheat_right).setBackgroundResource(R.drawable.ic_hp_waisthot_right_1);
                            break;
                        case 6:
                            findViewById(R.id.air_sp_waistheat_right).setBackgroundResource(R.drawable.ic_hp_waisthot_right_2);
                            break;
                        case 7:
                            findViewById(R.id.air_sp_waistheat_right).setBackgroundResource(R.drawable.ic_hp_waisthot_right_3);
                            break;
                    }
                }
                break;
            case FinalCanbus.CAR_RZC_Explorer /* 590158 */:
            case FinalCanbus.CAR_RZC_13_20Mengdiou /* 852302 */:
            case FinalCanbus.CAR_RZC_Mustang /* 1048910 */:
            case FinalCanbus.CAR_RZC_Ford_F150_12 /* 2294094 */:
            case FinalCanbus.CAR_RZC_Mustang_NO_CD /* 2359630 */:
            case FinalCanbus.CAR_RZC_Mustang_15_NO_CD /* 2621774 */:
            case FinalCanbus.CAR_RZC_Explorer_13 /* 3014990 */:
            case FinalCanbus.CAR_RZC_Mustang_M /* 5374286 */:
            case FinalCanbus.CAR_RZC_Mustang_H /* 5439822 */:
            case FinalCanbus.CAR_RZC_Mustang_NOCD_M /* 5505358 */:
            case FinalCanbus.CAR_RZC_Mustang_NOCD_H /* 5570894 */:
            case FinalCanbus.CAR_RZC_Ford_Explorer_24 /* 6160718 */:
            case FinalCanbus.CAR_RZC_Ford_Explorer_24_M /* 6226254 */:
            case FinalCanbus.CAR_RZC_Ford_Explorer_24_H /* 6291790 */:
                if (vel == 0) {
                    findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_0);
                    findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_0);
                    break;
                } else if (vel <= 3) {
                    findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_0);
                    switch (vel) {
                        case 1:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_3);
                            break;
                    }
                } else if (vel > 3) {
                    findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_0);
                    switch (vel - 3) {
                        case 1:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_3);
                            break;
                    }
                }
                break;
            case FinalCanbus.CAR_RZC_19MingjueHS /* 852241 */:
            case FinalCanbus.CAR_RZC_19RongWei_I5 /* 917777 */:
            case FinalCanbus.CAR_RZC_19RongWei_I6 /* 983313 */:
            case FinalCanbus.CAR_RZC_19MingjueHS_H /* 1048849 */:
            case FinalCanbus.CAR_RZC_19RongWei_I5_H /* 1114385 */:
            case FinalCanbus.CAR_RZC_19RongWei_RX8 /* 1310993 */:
            case FinalCanbus.CAR_RZC_Mingjue_20ZS /* 1376529 */:
            case FinalCanbus.CAR_RZC_Mingjue_20ZS_H /* 1442065 */:
            case FinalCanbus.CAR_RZC_19Mingjue_MG6 /* 1507601 */:
            case FinalCanbus.CAR_RZC_18RongWei_RX8 /* 1638673 */:
            case FinalCanbus.CAR_RZC_20RongWei_RX5 /* 1704209 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_21 /* 1835281 */:
            case FinalCanbus.CAR_RZC_21RongWei_I5 /* 1900817 */:
            case FinalCanbus.CAR_RZC_21RongWei_I5_H /* 1966353 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_21_L /* 2031889 */:
            case FinalCanbus.CAR_CZH_RZC_19Mingjue_MG6 /* 2097425 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_22_Top /* 2162961 */:
            case FinalCanbus.CAR_RZC_23MingjueHS /* 2228497 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_25 /* 2294033 */:
            case FinalCanbus.CAR_RZC_23RongWei_I5 /* 2425105 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_21_Top /* 2490641 */:
            case FinalCanbus.CAR_RZC_MingJue_MG6_21_Pro /* 2556177 */:
            case FinalCanbus.CAR_453_LZ_Jili_Boyue_18 /* 8782277 */:
            case FinalCanbus.CAR_453_LZ_Jili_Boyue_18_H /* 8847813 */:
                switch (vel) {
                    case 0:
                        findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_0);
                        break;
                    default:
                        findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_3);
                        break;
                }
                break;
            case FinalCanbus.CAR_455_LZ_GMC_Sierra_19_RScreen /* 1507783 */:
            case FinalCanbus.CAR_455_LZ_Chevrolet_Silverado_19_RScreen /* 1573319 */:
            case FinalCanbus.CAR_455_LZ_GM_Cadillac_CT5_Screen /* 5439943 */:
            case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_Screen /* 9437639 */:
            case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_Screen /* 9503175 */:
            case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_RScreen /* 9568711 */:
            case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_RScreen /* 9634247 */:
            case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
            case FinalCanbus.CAR_454_LZ_Chevrolet_Silverado_19_Screen /* 11993542 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_4Screen /* 15729095 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_4Screen /* 15794631 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_8Screen /* 15860167 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_8Screen /* 15925703 */:
                if ((vel & 8) != 0) {
                    heatlevel = 16 - vel;
                    flag = 1;
                } else {
                    flag = 0;
                    heatlevel = vel;
                }
                if (flag == 1) {
                    switch (heatlevel) {
                        case 1:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_3);
                            break;
                    }
                } else {
                    switch (heatlevel) {
                        case 0:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_0);
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_0);
                            break;
                        case 1:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_3);
                            break;
                    }
                }
                break;
            case FinalCanbus.CAR_CZH_OD_NISSAN_22Teana_Top /* 1572944 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_22Teana_Top_360View /* 1638480 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_16Trail /* 1704016 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_16Trail_H /* 1769552 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_16Xiaoke /* 1835088 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_16Xiaoke_H /* 1900624 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Xima_L /* 1966160 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Xima_H /* 2031696 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Loulan_L /* 2097232 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Loulan_H /* 2162768 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Tianlai_L /* 2228304 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Tianlai_H /* 2293840 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Xuanyi_L /* 2359376 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Xuanyi_H /* 2424912 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Lanniao_L /* 2490448 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Lannia_H /* 2555984 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Qida_L /* 2621520 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Qida_H /* 2687056 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Jinke_L /* 2752592 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Jinke_H /* 2818128 */:
                switch (vel) {
                    case 0:
                        findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_0);
                        break;
                    case 1:
                        findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_1);
                        break;
                    default:
                        findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_3);
                        break;
                }
                break;
            case FinalCanbus.CAR_WC2_GM_Escalade_15_Auto /* 5898276 */:
                int flag2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_RIGHT];
                if (flag2 == 1) {
                    findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_0);
                    switch (vel) {
                        case 0:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_0);
                            break;
                        case 1:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_3);
                            break;
                    }
                } else {
                    findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_0);
                    switch (vel) {
                        case 0:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_0);
                            break;
                        case 1:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_3);
                            break;
                    }
                }
                break;
            default:
                switch (vel) {
                    case 0:
                        findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_0);
                        break;
                    case 1:
                        findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_1);
                        break;
                    case 2:
                        findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_2);
                        break;
                    case 3:
                        findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_3);
                        break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateWindLeft() {
        int flag;
        int heatlevel;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_LEFT];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
            case FinalCanbus.CAR_LZ_Dodge_RAM1500_09 /* 655647 */:
            case FinalCanbus.CAR_LZ_Dodge_RAM2500_09 /* 721183 */:
            case FinalCanbus.CAR_LZ_Dodge_RAM3500_09 /* 786719 */:
            case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
            case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
            case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
            case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
                if ((vel & 8) != 0) {
                    switch (16 - vel) {
                        case 0:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_0);
                            break;
                        case 1:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_3);
                            break;
                    }
                } else {
                    findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_0);
                    break;
                }
                break;
            case FinalCanbus.CAR_455_LZ_GMC_Sierra_19_RScreen /* 1507783 */:
            case FinalCanbus.CAR_455_LZ_Chevrolet_Silverado_19_RScreen /* 1573319 */:
            case FinalCanbus.CAR_455_LZ_GM_Cadillac_CT5_Screen /* 5439943 */:
            case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_Screen /* 9437639 */:
            case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_Screen /* 9503175 */:
            case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_RScreen /* 9568711 */:
            case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_RScreen /* 9634247 */:
            case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
            case FinalCanbus.CAR_454_LZ_Chevrolet_Silverado_19_Screen /* 11993542 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_4Screen /* 15729095 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_4Screen /* 15794631 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_8Screen /* 15860167 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_8Screen /* 15925703 */:
                if ((vel & 8) != 0) {
                    heatlevel = 16 - vel;
                    flag = 1;
                } else {
                    flag = 0;
                    heatlevel = vel;
                }
                if (flag == 1) {
                    switch (heatlevel) {
                        case 1:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_3);
                            break;
                    }
                } else {
                    switch (heatlevel) {
                        case 0:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_0);
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_0);
                            break;
                        case 1:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_3);
                            break;
                    }
                }
                break;
            case FinalCanbus.CAR_WC2_GM_Escalade_15_Auto /* 5898276 */:
                int flag2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_LEFT];
                int vel2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT];
                if (flag2 == 1) {
                    findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_0);
                    switch (vel2) {
                        case 0:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_0);
                            break;
                        case 1:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_3);
                            break;
                    }
                } else {
                    findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_0);
                    switch (vel2) {
                        case 0:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_0);
                            break;
                        case 1:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_3);
                            break;
                    }
                }
                break;
            case FinalCanbus.CAR_444_WY_HCX_Chuanqi_21GS8_Screen /* 7012796 */:
                switch (vel) {
                    case 0:
                        findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_0);
                        break;
                    default:
                        findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_3);
                        break;
                }
                break;
            case FinalCanbus.CAR_452_XC_Rongwei_ALl /* 7471556 */:
            case FinalCanbus.CAR_452_XC_GM_ALl /* 7537092 */:
                if ((vel & 8) != 0) {
                    switch (vel & 7) {
                        case 0:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_0);
                            break;
                        case 1:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_3);
                            break;
                    }
                } else {
                    findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_0);
                    break;
                }
                break;
            default:
                switch (vel) {
                    case 0:
                        findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_0);
                        break;
                    case 1:
                        findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_1);
                        break;
                    case 2:
                        findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_2);
                        break;
                    case 3:
                        findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_3);
                        break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateWindRight() {
        int flag;
        int heatlevel;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_RIGHT];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
            case FinalCanbus.CAR_LZ_Dodge_RAM1500_09 /* 655647 */:
            case FinalCanbus.CAR_LZ_Dodge_RAM2500_09 /* 721183 */:
            case FinalCanbus.CAR_LZ_Dodge_RAM3500_09 /* 786719 */:
            case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
            case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
            case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
            case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
                if ((vel & 8) != 0) {
                    switch (16 - vel) {
                        case 0:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_0);
                            break;
                        case 1:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_3);
                            break;
                    }
                } else {
                    findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_0);
                    break;
                }
                break;
            case FinalCanbus.CAR_455_LZ_GMC_Sierra_19_RScreen /* 1507783 */:
            case FinalCanbus.CAR_455_LZ_Chevrolet_Silverado_19_RScreen /* 1573319 */:
            case FinalCanbus.CAR_455_LZ_GM_Cadillac_CT5_Screen /* 5439943 */:
            case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_Screen /* 9437639 */:
            case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_Screen /* 9503175 */:
            case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_RScreen /* 9568711 */:
            case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_RScreen /* 9634247 */:
            case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
            case FinalCanbus.CAR_454_LZ_Chevrolet_Silverado_19_Screen /* 11993542 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_4Screen /* 15729095 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_4Screen /* 15794631 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_8Screen /* 15860167 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_8Screen /* 15925703 */:
                if ((vel & 8) != 0) {
                    heatlevel = 16 - vel;
                    flag = 1;
                } else {
                    flag = 0;
                    heatlevel = vel;
                }
                if (flag == 1) {
                    switch (heatlevel) {
                        case 1:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_3);
                            break;
                    }
                } else {
                    switch (heatlevel) {
                        case 0:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_0);
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_0);
                            break;
                        case 1:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_3);
                            break;
                    }
                }
                break;
            case FinalCanbus.CAR_WC2_GM_Escalade_15_Auto /* 5898276 */:
                int flag2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_RIGHT];
                int vel2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT];
                if (flag2 == 1) {
                    findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_0);
                    switch (vel2) {
                        case 0:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_0);
                            break;
                        case 1:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_3);
                            break;
                    }
                } else {
                    findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_0);
                    switch (vel2) {
                        case 0:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_0);
                            break;
                        case 1:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_3);
                            break;
                    }
                }
                break;
            case FinalCanbus.CAR_452_XC_Rongwei_ALl /* 7471556 */:
            case FinalCanbus.CAR_452_XC_GM_ALl /* 7537092 */:
                if ((vel & 8) != 0) {
                    switch (vel & 7) {
                        case 0:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_0);
                            break;
                        case 1:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_1);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_2);
                            break;
                        case 3:
                            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_3);
                            break;
                    }
                } else {
                    findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_0);
                    break;
                }
                break;
            default:
                switch (vel) {
                    case 0:
                        findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_0);
                        break;
                    case 1:
                        findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_1);
                        break;
                    case 2:
                        findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_2);
                        break;
                    case 3:
                        findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_3);
                        break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateHeatLeftRear() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT_REAR];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatheat_left_rear).setBackgroundResource(R.drawable.ic_hp_seathot_left_0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatheat_left_rear).setBackgroundResource(R.drawable.ic_hp_seathot_left_1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatheat_left_rear).setBackgroundResource(R.drawable.ic_hp_seathot_left_2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatheat_left_rear).setBackgroundResource(R.drawable.ic_hp_seathot_left_3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateHeatRightRear() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT_REAR];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatheat_right_rear).setBackgroundResource(R.drawable.ic_hp_seathot_right_0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatheat_right_rear).setBackgroundResource(R.drawable.ic_hp_seathot_right_1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatheat_right_rear).setBackgroundResource(R.drawable.ic_hp_seathot_right_2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatheat_right_rear).setBackgroundResource(R.drawable.ic_hp_seathot_right_3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateWindLeftRear() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_LEFT_REAR];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatwind_left_rear).setBackgroundResource(R.drawable.ic_hp_seatblow_left_0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatwind_left_rear).setBackgroundResource(R.drawable.ic_hp_seatblow_left_1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatwind_left_rear).setBackgroundResource(R.drawable.ic_hp_seatblow_left_2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatwind_left_rear).setBackgroundResource(R.drawable.ic_hp_seatblow_left_3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateWindRightRear() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_RIGHT_REAR];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_seatwind_right_rear).setBackgroundResource(R.drawable.ic_hp_seatblow_right_0);
                break;
            case 1:
                findViewById(R.id.air_sp_seatwind_right_rear).setBackgroundResource(R.drawable.ic_hp_seatblow_right_1);
                break;
            case 2:
                findViewById(R.id.air_sp_seatwind_right_rear).setBackgroundResource(R.drawable.ic_hp_seatblow_right_2);
                break;
            case 3:
                findViewById(R.id.air_sp_seatwind_right_rear).setBackgroundResource(R.drawable.ic_hp_seatblow_right_3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateDual() {
        int i = R.drawable.ic_hp_dual_p;
        int i2 = R.drawable.ic_hp_dual_n;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_DUAL];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_446_Xiaolin_WY_LEXUS_Screen /* 2097598 */:
            case FinalCanbus.CAR_446_Xiaolin_WY_LEXUS_Screen_H /* 2163134 */:
            case FinalCanbus.CAR_444_WY_LEXUS_Screen /* 6095292 */:
            case FinalCanbus.CAR_444_WY_LEXUS_Screen_H /* 6488508 */:
                View viewFindViewById = findViewById(R.id.air_sp_dual);
                if (vel != 0) {
                    i = 2130840678;
                }
                viewFindViewById.setBackgroundResource(i);
                break;
            default:
                View viewFindViewById2 = findViewById(R.id.air_sp_dual);
                if (vel != 0) {
                    i2 = 2130840679;
                }
                viewFindViewById2.setBackgroundResource(i2);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSYNC() {
        int i = R.drawable.ic_hp_sync_p;
        int i2 = R.drawable.ic_hp_sync_n;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SYNC];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_TD_INFINIT_ESQ /* 1704391 */:
            case FinalCanbus.CAR_455_TD_INFINIT_G /* 1769927 */:
            case FinalCanbus.CAR_455_TD_INFINIT_QX50 /* 1835463 */:
            case FinalCanbus.CAR_455_TD_INFINIT_06FX /* 1900999 */:
            case FinalCanbus.CAR_455_TD_INFINIT_08FX /* 1966535 */:
            case FinalCanbus.CAR_455_TD_INFINIT_14QX70 /* 2032071 */:
            case FinalCanbus.CAR_455_TD_INFINIT_12FX /* 2097607 */:
            case FinalCanbus.CAR_455_Tangdu_Nissan_10PATROL_L /* 4260295 */:
            case FinalCanbus.CAR_455_LZ_Benz_C200_NTG5 /* 8192455 */:
            case FinalCanbus.CAR_455_Tangdu_Nissan_22PATROL_Armada /* 10224071 */:
            case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_L /* 13763014 */:
            case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_H /* 13828550 */:
                View viewFindViewById = findViewById(R.id.air_sp_sync);
                if (vel != 0) {
                    i = 2130840798;
                }
                viewFindViewById.setBackgroundResource(i);
                break;
            default:
                View viewFindViewById2 = findViewById(R.id.air_sp_sync);
                if (vel != 0) {
                    i2 = 2130840799;
                }
                viewFindViewById2.setBackgroundResource(i2);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateZONE() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_ZONE];
        findViewById(R.id.air_sp_zone).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_zone_n : R.drawable.ic_hp_zone_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAutoRight() {
        int i = R.drawable.ic_hp_auto_p;
        int i2 = R.drawable.ic_hp_auto_n;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO_RIGHT];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_LZ_Nissan_05_Cima /* 9044422 */:
                View viewFindViewById = findViewById(R.id.air_sp_auto_right);
                if (vel != 2) {
                    i = 2130840642;
                }
                viewFindViewById.setBackgroundResource(i);
                break;
            default:
                View viewFindViewById2 = findViewById(R.id.air_sp_auto_right);
                if (vel != 0) {
                    i2 = 2130840643;
                }
                viewFindViewById2.setBackgroundResource(i2);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAuto() {
        int i = R.drawable.ic_hp_auto_p;
        int i2 = R.drawable.ic_hp_auto_n;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_LZ_Nissan_05_Cima /* 9044422 */:
                View viewFindViewById = findViewById(R.id.air_sp_auto);
                if (vel != 2) {
                    i = 2130840642;
                }
                viewFindViewById.setBackgroundResource(i);
                break;
            default:
                View viewFindViewById2 = findViewById(R.id.air_sp_auto);
                if (vel != 0) {
                    i2 = 2130840643;
                }
                viewFindViewById2.setBackgroundResource(i2);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC];
        switch (DataCanbus.DATA[1000]) {
            case 274:
            case FinalCanbus.CAR_DJ_XP1_ACCORD7_H /* 65810 */:
                switch (acOn) {
                    case 2:
                    case 3:
                        ((Button) findViewById(R.id.air_sp_ac)).setBackgroundResource(R.drawable.ic_hp_ac_p);
                        break;
                    default:
                        ((Button) findViewById(R.id.air_sp_ac)).setBackgroundResource(R.drawable.ic_hp_ac_n);
                        break;
                }
                break;
            default:
                findViewById(R.id.air_sp_ac).setBackgroundResource(acOn == 0 ? 2130840616 : 2130840618);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCycle() {
        int i = R.drawable.ic_hp_cyclein_p;
        int cycle = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE];
        int cycle_auto = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE_AUTO];
        switch (DataCanbus.DATA[1000]) {
            case 373:
            case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_H /* 65909 */:
            case FinalCanbus.CAR_RZC_XP1_ZiYouXia /* 131445 */:
            case FinalCanbus.CAR_RZC_XP1_GrdCherokee /* 196981 */:
            case FinalCanbus.CAR_RZC_17ZhiNanZhe /* 262517 */:
            case FinalCanbus.CAR_RZC_17ZhiNanZhe_H /* 328053 */:
            case FinalCanbus.CAR_RZC_18MuMaRen /* 393589 */:
            case FinalCanbus.CAR_RZC_XP1_GrdCherokee_H /* 459125 */:
            case FinalCanbus.CAR_RZC_18MuMaRen_H /* 524661 */:
            case FinalCanbus.CAR_RZC_19Tiaozhanzhe /* 590197 */:
            case FinalCanbus.CAR_RZC_18Zhihuiguan /* 655733 */:
            case FinalCanbus.CAR_RZC_19Tiaozhanzhe_H /* 721269 */:
            case FinalCanbus.CAR_RZC_18Zhihuiguan_H /* 786805 */:
            case FinalCanbus.CAR_RZC_19MingjueHS /* 852241 */:
            case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19 /* 852341 */:
            case FinalCanbus.CAR_RZC_19RongWei_I5 /* 917777 */:
            case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19_H /* 917877 */:
            case FinalCanbus.CAR_RZC_19RongWei_I6 /* 983313 */:
            case FinalCanbus.CAR_RZC_20Zhihuiguan_EV /* 983413 */:
            case FinalCanbus.CAR_RZC_19MingjueHS_H /* 1048849 */:
            case FinalCanbus.CAR_RZC_19RongWei_I5_H /* 1114385 */:
            case FinalCanbus.CAR_RZC_Dodge_JCUV /* 1114485 */:
            case FinalCanbus.CAR_RZC_Chrysler_300C_16 /* 1245557 */:
            case FinalCanbus.CAR_RZC_19RongWei_RX8 /* 1310993 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM /* 1311093 */:
            case FinalCanbus.CAR_RZC_Mingjue_20ZS /* 1376529 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_H /* 1376629 */:
            case FinalCanbus.CAR_RZC_Mingjue_20ZS_H /* 1442065 */:
            case FinalCanbus.CAR_RZC_19Mingjue_MG6 /* 1507601 */:
            case FinalCanbus.CAR_RZC_18RongWei_RX8 /* 1638673 */:
            case FinalCanbus.CAR_RZC_20RongWei_RX5 /* 1704209 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_21 /* 1835281 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_M /* 1835381 */:
            case FinalCanbus.CAR_RZC_21RongWei_I5 /* 1900817 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_HY /* 1900917 */:
            case FinalCanbus.CAR_RZC_21RongWei_I5_H /* 1966353 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_HY_M /* 1966453 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_21_L /* 2031889 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_HY_H /* 2031989 */:
            case FinalCanbus.CAR_CZH_RZC_19Mingjue_MG6 /* 2097425 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_22_Top /* 2162961 */:
            case FinalCanbus.CAR_RZC_XP1_ZiYouXia_H /* 2163061 */:
            case FinalCanbus.CAR_RZC_23MingjueHS /* 2228497 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_25 /* 2294033 */:
            case FinalCanbus.CAR_RZC_Dodge_JCUV_H /* 2359669 */:
            case FinalCanbus.CAR_RZC_23RongWei_I5 /* 2425105 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_21_Top /* 2490641 */:
            case FinalCanbus.CAR_RZC_MingJue_MG6_21_Pro /* 2556177 */:
            case FinalCanbus.CAR_RZC_CHRYSLER_21PACIFICA /* 2556277 */:
            case FinalCanbus.CAR_RZC_CHRYSLER_21PACIFICA_H /* 2621813 */:
            case FinalCanbus.CAR_RZC_Dodge_15CHARGER /* 2687349 */:
            case FinalCanbus.CAR_RZC_Dodge_15CHARGER_H /* 2752885 */:
            case FinalCanbus.CAR_RZC_Dodge_17DURANGO /* 2818421 */:
            case FinalCanbus.CAR_RZC_Dodge_17DURANGO_H /* 2883957 */:
            case FinalCanbus.CAR_RZC_Jeep_22Gladiator /* 2949493 */:
            case FinalCanbus.CAR_RZC_Jeep_22Gladiator_H /* 3015029 */:
            case FinalCanbus.CAR_RZC_Jeep_18GrdCherokee /* 3080565 */:
            case FinalCanbus.CAR_RZC_Jeep_18GrdCherokee_H /* 3146101 */:
            case FinalCanbus.CAR_RZC_CHRYSLER_19PACIFICA_H /* 3211637 */:
            case FinalCanbus.CAR_RZC_Dodge_20RAM /* 3277173 */:
            case FinalCanbus.CAR_452_XC_Rongwei_ALl /* 7471556 */:
            case FinalCanbus.CAR_452_XC_GM_ALl /* 7537092 */:
                switch (cycle) {
                    case 0:
                        findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_hp_cycleout_n);
                        break;
                    case 1:
                        findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_hp_cyclein_p);
                        break;
                    case 2:
                        findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_hp_cycleauto_p);
                        break;
                }
                break;
            case FinalCanbus.CAR_WC2_GM_GL8 /* 393252 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx /* 917956 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx_H /* 983492 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_ESQ /* 1573316 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_06FX /* 1638852 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_08FX /* 1704388 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_G /* 1769924 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_14QX50 /* 1835460 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_15QX60 /* 1900996 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_14QX70 /* 1966532 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_IS /* 3080631 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_IS_H /* 3146167 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_ES /* 3211703 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_ES_H /* 3277239 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_12FX /* 3998148 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_15Q50L /* 4063684 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_12JX35 /* 4129220 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460 /* 5308868 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460_H /* 5374404 */:
            case FinalCanbus.CAR_452_LZ_Toyota_LC100 /* 5439940 */:
            case FinalCanbus.CAR_452_LZ_Toyota_LC100_H /* 5505476 */:
            case FinalCanbus.CAR_455_XinCheng_Infiniti_18QX80 /* 6816199 */:
            case FinalCanbus.CAR_455_XinCheng_Infiniti_17QX30_Keep /* 6881735 */:
            case FinalCanbus.CAR_455_XinCheng_Infiniti_17QX30 /* 6947271 */:
            case FinalCanbus.CAR_455_XinCheng_Infiniti_17Q50 /* 7012807 */:
            case FinalCanbus.CAR_453_LZ_Toyota_markII_L /* 9634245 */:
            case FinalCanbus.CAR_453_LZ_Toyota_markII_H /* 9699781 */:
            case FinalCanbus.CAR_455_XinCheng_Infiniti_22QX50 /* 10355143 */:
            case FinalCanbus.CAR_455_XinCheng_Infiniti_15QX56 /* 11731399 */:
                if (cycle_auto == 1) {
                    switch (cycle) {
                        case 0:
                            findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_hp_cycleauto3);
                            break;
                        case 1:
                            findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_hp_cycleauto_p);
                            break;
                    }
                } else {
                    switch (cycle) {
                        case 0:
                            findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_hp_cycleauto4);
                            break;
                        case 1:
                            findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_hp_cycleauto2);
                            break;
                    }
                }
                break;
            case FinalCanbus.CAR_444_WC2_Wuling_Xingguang70_24 /* 459196 */:
            case FinalCanbus.CAR_455_LZ_NISSAN_patrol_H /* 4653511 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
            case FinalCanbus.CAR_453_LZ_NISSAN_patrol /* 5308869 */:
            case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX60 /* 5374405 */:
            case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX80 /* 5439941 */:
            case FinalCanbus.CAR_444_WC2_Wuling_Kaijie_20_L /* 5505468 */:
            case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX56 /* 5505477 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
            case FinalCanbus.CAR_444_WC2_Wuling_Kaijie_20_H /* 5571004 */:
            case FinalCanbus.CAR_455_LZ_Dodge_RAM1500 /* 6357447 */:
            case FinalCanbus.CAR_455_LZ_Dodge_RAM1500_H /* 6422983 */:
            case FinalCanbus.CAR_444_WC2_Beiqi_Zhixing_19 /* 6619580 */:
            case FinalCanbus.CAR_443_WC2_Ford_EDGE_11 /* 6685115 */:
            case FinalCanbus.CAR_443_WC2_Ford_EDGE_11_CD /* 6750651 */:
            case FinalCanbus.CAR_444_WC2_Ford_Escape_08_L /* 7274940 */:
            case FinalCanbus.CAR_444_WC2_Ford_Escape_08_M /* 7340476 */:
            case FinalCanbus.CAR_444_WC2_Ford_Escape_08_H /* 7406012 */:
            case FinalCanbus.CAR_444_WC2_Ford_KA_14 /* 7733692 */:
            case FinalCanbus.CAR_444_WC2_Ford_SAMX_15 /* 7799228 */:
            case FinalCanbus.CAR_444_WC2_Ford_TAURUS_18 /* 7864764 */:
            case FinalCanbus.CAR_444_WC2_Ford_Escape_20 /* 7930300 */:
            case FinalCanbus.CAR_444_WC2_Ford_Fusion_06_L /* 7995836 */:
            case FinalCanbus.CAR_444_WC2_Ford_Fusion_06_M /* 8061372 */:
            case FinalCanbus.CAR_444_WC2_Ford_Fusion_06_H /* 8126908 */:
            case FinalCanbus.CAR_444_WC2_Ford_Tourneo_15 /* 8192444 */:
            case FinalCanbus.CAR_444_WC2_Ford_Transit_20 /* 8257980 */:
            case FinalCanbus.CAR_444_WC2_Ford_Edge_06_L /* 8323516 */:
            case FinalCanbus.CAR_444_WC2_Ford_Edge_06_M /* 8389052 */:
            case FinalCanbus.CAR_444_WC2_Ford_Edge_06_H /* 8454588 */:
            case FinalCanbus.CAR_444_WC2_Ford_Edge_15_DWS /* 8520124 */:
            case FinalCanbus.CAR_444_WC2_Ford_Explorer_06_L /* 8585660 */:
            case FinalCanbus.CAR_444_WC2_Ford_Explorer_06_M /* 8651196 */:
            case FinalCanbus.CAR_444_WC2_Ford_Explorer_06_H /* 8716732 */:
            case FinalCanbus.CAR_444_WC2_Ford_Explorer_11 /* 8782268 */:
            case FinalCanbus.CAR_444_WC2_Ford_Explorer_11_CD /* 8847804 */:
            case FinalCanbus.CAR_444_WC2_Ford_Explorer_11_SP /* 8913340 */:
            case FinalCanbus.CAR_444_WC2_Ford_Everest_16 /* 8978876 */:
            case FinalCanbus.CAR_444_WC2_Ford_Everest_23 /* 9044412 */:
            case FinalCanbus.CAR_454_LZ_Nissan_05_Cima /* 9044422 */:
            case FinalCanbus.CAR_444_WC2_Ford_Ranger_16 /* 9109948 */:
            case FinalCanbus.CAR_444_WC2_Ford_Raptor_18 /* 9175484 */:
            case FinalCanbus.CAR_444_WC2_Ford_F150_04_L /* 9241020 */:
            case FinalCanbus.CAR_444_WC2_Ford_F150_04_M /* 9306556 */:
            case FinalCanbus.CAR_444_WC2_Ford_F150_04_H /* 9372092 */:
            case FinalCanbus.CAR_444_WC2_Ford_F250_04_L /* 9437628 */:
            case FinalCanbus.CAR_444_WC2_Ford_F250_04_M /* 9503164 */:
            case FinalCanbus.CAR_444_WC2_Ford_F250_04_H /* 9568700 */:
            case FinalCanbus.CAR_444_WC2_Ford_Mustang_05_L /* 9634236 */:
            case FinalCanbus.CAR_444_WC2_Ford_Mustang_05_M /* 9699772 */:
            case FinalCanbus.CAR_444_WC2_Ford_Mustang_05_H /* 9765308 */:
            case FinalCanbus.CAR_444_WC2_Ford_Expedition_03_L /* 9896380 */:
            case FinalCanbus.CAR_444_WC2_Ford_Expedition_03_M /* 9961916 */:
            case FinalCanbus.CAR_444_WC2_Ford_Expedition_03_H /* 10027452 */:
            case FinalCanbus.CAR_444_WC2_Ford_Yihu_12_CD /* 10092988 */:
            case FinalCanbus.CAR_444_WC2_Ford_Lincoln_Continental /* 10158524 */:
            case FinalCanbus.CAR_439_LZ_INFINIT_FX35 /* 12714423 */:
            case FinalCanbus.CAR_454_LZ_Nissan_370Z_H /* 14746054 */:
            case FinalCanbus.CAR_455_6606_LZ_Dodge_RAM1500 /* 14877127 */:
            case FinalCanbus.CAR_455_6606_LZ_Dodge_RAM1500_H /* 14942663 */:
            case FinalCanbus.CAR_443_WC2_Ford_F150_18 /* 15401403 */:
            case FinalCanbus.CAR_443_WC2_Ford_F150_18_CD /* 15466939 */:
            case FinalCanbus.CAR_443_WC2_Ford_F150_18_M /* 15729083 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_L /* 15729094 */:
            case FinalCanbus.CAR_443_WC2_Ford_F150_18_H /* 15794619 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H /* 15794630 */:
            case FinalCanbus.CAR_443_WC2_Ford_F250_18_L /* 15860155 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_TW /* 15860166 */:
            case FinalCanbus.CAR_443_WC2_Ford_F250_18_M /* 15925691 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H_NP /* 15925702 */:
            case FinalCanbus.CAR_443_WC2_Ford_F250_18_H /* 15991227 */:
            case FinalCanbus.CAR_443_WC2_Ford_F350_18_L /* 16056763 */:
            case FinalCanbus.CAR_443_WC2_Ford_F350_18_M /* 16122299 */:
            case FinalCanbus.CAR_443_WC2_Ford_F350_18_H /* 16187835 */:
            case FinalCanbus.CAR_443_WC2_Ford_Mustang_18_L /* 16253371 */:
            case FinalCanbus.CAR_443_WC2_Ford_Mustang_18_M /* 16318907 */:
            case FinalCanbus.CAR_443_WC2_Ford_Mustang_18_H /* 16384443 */:
                View viewFindViewById = findViewById(R.id.air_sp_cycle);
                if (cycle != 0) {
                    i = 2130840675;
                }
                viewFindViewById.setBackgroundResource(i);
                break;
            case FinalCanbus.CAR_455_RZC_Sanlin_OULANDE_20Overseas /* 5833159 */:
            case FinalCanbus.CAR_455_RZC_Sanlin_OULANDE_20Overseas_L /* 5898695 */:
            case FinalCanbus.CAR_455_RZC_Sanlin_Triton_22 /* 8520135 */:
            case FinalCanbus.CAR_455_RZC_Sanlin_Triton_22t_H /* 8585671 */:
            case FinalCanbus.CAR_455_RZC_Sanlin_Triton_22_Top /* 8651207 */:
            case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport /* 10420678 */:
            case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport_H /* 10486214 */:
            case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport_Top /* 16056774 */:
                View viewFindViewById2 = findViewById(R.id.air_sp_cycle);
                if (cycle != 2) {
                    i = 2130840675;
                }
                viewFindViewById2.setBackgroundResource(i);
                break;
            case FinalCanbus.CAR_453_LZ_ALFA_ROMEO /* 7930309 */:
                switch (cycle) {
                    case 0:
                        switch (cycle_auto) {
                            case 0:
                                findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_hp_cycle_romeo_4);
                                break;
                            case 1:
                                findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_hp_cycle_romeo_5);
                                break;
                            case 2:
                                findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_hp_cycle_romeo_6);
                                break;
                            case 3:
                                findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_hp_cycle_romeo_7);
                                break;
                        }
                        break;
                    case 1:
                        switch (cycle_auto) {
                            case 0:
                                findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_hp_cycle_romeo_0);
                                break;
                            case 1:
                                findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_hp_cycle_romeo_1);
                                break;
                            case 2:
                                findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_hp_cycle_romeo_2);
                                break;
                            case 3:
                                findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_hp_cycle_romeo_3);
                                break;
                        }
                        break;
                }
                break;
            default:
                View viewFindViewById3 = findViewById(R.id.air_sp_cycle);
                if (cycle == 0) {
                    i = 2130840675;
                }
                viewFindViewById3.setBackgroundResource(i);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateNanoe() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_NANOE];
        findViewById(R.id.air_sp_nanoe).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_nanoe_n : R.drawable.ic_hp_nanoe_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateECO() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_ECO];
        findViewById(R.id.air_sp_eco).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_eco_n : R.drawable.ic_hp_eco_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFlowerBlow() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FLOWER_BLOW];
        findViewById(R.id.air_sp_flowerblow).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_flowerblow_n : R.drawable.ic_hp_flowerblow_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirPark() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_PARK];
        switch (DataCanbus.DATA[1000]) {
            case 372:
            case FinalCanbus.CAR_WC1_Jeep_ZiYouGuang_M /* 65908 */:
            case FinalCanbus.CAR_WC1_Jeep_ZiYouGuang_H /* 131444 */:
            case FinalCanbus.CAR_WC1_Jeep_17ZhiNanZhe /* 262516 */:
            case FinalCanbus.CAR_WC1_Jeep_17ZhiNanZhe_H /* 328052 */:
            case FinalCanbus.CAR_WC1_Jeep_18ZiYouXia /* 393588 */:
            case FinalCanbus.CAR_WC1_Jeep_18ZiYouXia_H /* 459124 */:
            case FinalCanbus.CAR_WC1_Jeep_19ZiYouXia_W /* 524660 */:
            case FinalCanbus.CAR_WC1_Fiat_19_500X /* 590196 */:
            case FinalCanbus.CAR_WC1_Jeep_13_Dodge_JCUV /* 655732 */:
            case FinalCanbus.CAR_WC1_Jeep_13_Dodge_JCUV_CD /* 721268 */:
            case FinalCanbus.CAR_WC1_Jeep_18_Zhihuiguan /* 852340 */:
            case FinalCanbus.CAR_WC1_Jeep_15_RAM /* 917876 */:
            case FinalCanbus.CAR_WC1_Jeep_18_Zhihuiguan_H /* 983412 */:
            case FinalCanbus.CAR_WC1_Jeep_15_RAM_H /* 1048948 */:
            case FinalCanbus.CAR_WC1_TMK_BENZ_MPV_ALL /* 1114484 */:
            case FinalCanbus.CAR_WC1_Jeep_20_GrdCherokee_H /* 1180020 */:
            case FinalCanbus.CAR_WC1_Jeep_19_MuMaRen_H /* 1245556 */:
            case FinalCanbus.CAR_WC1_Jeep_18ZhiNanZhe_EU /* 1311092 */:
            case FinalCanbus.CAR_WC1_Jeep_Chrysler_300C_11 /* 1376628 */:
            case FinalCanbus.CAR_WC1_Jeep_Chrysler_300C_11CD /* 1442164 */:
            case FinalCanbus.CAR_WC1_Jeep_19_MuMaRen_L /* 1507700 */:
            case FinalCanbus.CAR_WC1_Jeep_20_GrdCherokee_L /* 1573236 */:
            case FinalCanbus.CAR_WC1_Jeep_18_Zhihuiguan_M /* 1638772 */:
            case FinalCanbus.CAR_WC1_Jeep_15_RAM_M /* 1704308 */:
            case FinalCanbus.CAR_WC1_Jeep_20_GrdCherokee_M /* 1769844 */:
            case FinalCanbus.CAR_WC1_Jeep_19_MuMaRen_M /* 1835380 */:
            case FinalCanbus.CAR_WC1_Jeep_19_RAM /* 1900916 */:
            case FinalCanbus.CAR_WC1_Jeep_19_RAM_M /* 1966452 */:
            case FinalCanbus.CAR_WC1_Jeep_19_RAM_H /* 2031988 */:
                findViewById(R.id.air_sp_airpark).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_rearview_n : R.drawable.ic_hp_rearview_p);
                break;
            case FinalCanbus.CAR_456_OD_Hongqi_H5 /* 65992 */:
            case FinalCanbus.CAR_455_CZH_OD_Hongqi_EQM5_Huandian /* 7274951 */:
            case FinalCanbus.CAR_454_CZH_OD_Hongqi_EQM5 /* 16515526 */:
                findViewById(R.id.air_sp_airpark).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_chainuan_n : R.drawable.ic_hp_chainuan_p);
                break;
            case FinalCanbus.CAR_444_WC2_Hongqi_H7 /* 3604924 */:
            case FinalCanbus.CAR_444_WC2_Hongqi_21EQM5 /* 5702076 */:
                findViewById(R.id.air_sp_airpark).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_swing_toyota_n : R.drawable.ic_hp_swing_toyota_p);
                break;
            case FinalCanbus.CAR_455_LZ_Benz_C200_NTG5 /* 8192455 */:
                switch (rear) {
                    case 0:
                        findViewById(R.id.air_sp_airpark).setBackgroundResource(R.drawable.ic_hp_diffuse_p);
                        break;
                    case 1:
                        findViewById(R.id.air_sp_airpark).setBackgroundResource(R.drawable.ic_hp_focus_p);
                        break;
                    case 2:
                        findViewById(R.id.air_sp_airpark).setBackgroundResource(R.drawable.ic_hp_medium_p);
                        break;
                }
                break;
            default:
                findViewById(R.id.air_sp_airpark).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_airpark_n : R.drawable.ic_hp_airpark_p);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirRest() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_REST];
        findViewById(R.id.air_sp_rest).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_rest_n : R.drawable.ic_hp_rest_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirOnlyFront() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT_ONLY];
        findViewById(R.id.air_sp_onlyfront).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_onlyfront_n : R.drawable.ic_hp_onlyfront_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirOnlyFront_F() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT_ONLY_F];
        findViewById(R.id.air_sp_onlyfront_front).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_onlyfront_n : R.drawable.ic_hp_onlyfront_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirRearCool() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_COOL];
        findViewById(R.id.air_sp_rear_cool).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_rearcool_n : R.drawable.ic_hp_rearcool_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirRearManual() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_MANUAL];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx /* 917956 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx_H /* 983492 */:
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
            case FinalCanbus.CAR_453_LZ_Toyota_REIZ_09 /* 1114565 */:
            case FinalCanbus.CAR_453_LZ_Toyota_REIZ_09_H /* 1180101 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_IS /* 3080631 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_IS_H /* 3146167 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_ES /* 3211703 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_ES_H /* 3277239 */:
            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460 /* 5308868 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460_H /* 5374404 */:
            case FinalCanbus.CAR_452_LZ_Toyota_LC100 /* 5439940 */:
            case FinalCanbus.CAR_452_LZ_Toyota_LC100_H /* 5505476 */:
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD /* 8913349 */:
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD_H /* 8978885 */:
            case FinalCanbus.CAR_453_LZ_Toyota_markII_L /* 9634245 */:
            case FinalCanbus.CAR_453_LZ_Toyota_markII_H /* 9699781 */:
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH /* 10420679 */:
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH_H /* 10486215 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300 /* 15008198 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER /* 15139270 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER_H /* 15532486 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300_H /* 15598022 */:
                switch (rear) {
                    case 0:
                        findViewById(R.id.air_sp_rear_manual).setBackgroundResource(R.drawable.ic_hp_rearmanual_0);
                        break;
                    case 1:
                        findViewById(R.id.air_sp_rear_manual).setBackgroundResource(R.drawable.ic_hp_rearmanual_2);
                        break;
                    case 2:
                        findViewById(R.id.air_sp_rear_manual).setBackgroundResource(R.drawable.ic_hp_rearmanual_4);
                        break;
                    case 3:
                        findViewById(R.id.air_sp_rear_manual).setBackgroundResource(R.drawable.ic_hp_rearmanual_6);
                        break;
                    case 4:
                        findViewById(R.id.air_sp_rear_manual).setBackgroundResource(R.drawable.ic_hp_rearmanual_1);
                        break;
                    case 5:
                        findViewById(R.id.air_sp_rear_manual).setBackgroundResource(R.drawable.ic_hp_rearmanual_3);
                        break;
                    case 6:
                        findViewById(R.id.air_sp_rear_manual).setBackgroundResource(R.drawable.ic_hp_rearmanual_5);
                        break;
                    case 7:
                        findViewById(R.id.air_sp_rear_manual).setBackgroundResource(R.drawable.ic_hp_rearmanual_7);
                        break;
                }
                break;
            case FinalCanbus.CAR_OD_RZC_DaTong_25Dana_M1 /* 1704201 */:
                switch (rear) {
                    case 0:
                        findViewById(R.id.air_sp_rear_manual).setBackgroundResource(R.drawable.ic_hp_heat_n);
                        break;
                    case 1:
                        findViewById(R.id.air_sp_rear_manual).setBackgroundResource(R.drawable.ic_hp_heat_p);
                        break;
                }
                break;
            default:
                switch (rear) {
                    case 0:
                        findViewById(R.id.air_sp_rear_manual).setBackgroundResource(R.drawable.ic_hp_rearmanual_0);
                        break;
                    case 1:
                        findViewById(R.id.air_sp_rear_manual).setBackgroundResource(R.drawable.ic_hp_rearmanual_1);
                        break;
                    case 2:
                        findViewById(R.id.air_sp_rear_manual).setBackgroundResource(R.drawable.ic_hp_rearmanual_2);
                        break;
                    case 3:
                        findViewById(R.id.air_sp_rear_manual).setBackgroundResource(R.drawable.ic_hp_rearmanual_3);
                        break;
                    case 4:
                        findViewById(R.id.air_sp_rear_manual).setBackgroundResource(R.drawable.ic_hp_rearmanual_4);
                        break;
                    case 5:
                        findViewById(R.id.air_sp_rear_manual).setBackgroundResource(R.drawable.ic_hp_rearmanual_5);
                        break;
                    case 6:
                        findViewById(R.id.air_sp_rear_manual).setBackgroundResource(R.drawable.ic_hp_rearmanual_6);
                        break;
                    case 7:
                        findViewById(R.id.air_sp_rear_manual).setBackgroundResource(R.drawable.ic_hp_rearmanual_7);
                        break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirSwing() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_SWING];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx /* 917956 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx_H /* 983492 */:
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
            case FinalCanbus.CAR_453_LZ_Toyota_REIZ_09 /* 1114565 */:
            case FinalCanbus.CAR_453_LZ_Toyota_REIZ_09_H /* 1180101 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_IS /* 3080631 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_IS_H /* 3146167 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_ES /* 3211703 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_ES_H /* 3277239 */:
            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460 /* 5308868 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460_H /* 5374404 */:
            case FinalCanbus.CAR_452_LZ_Toyota_LC100 /* 5439940 */:
            case FinalCanbus.CAR_452_LZ_Toyota_LC100_H /* 5505476 */:
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD /* 8913349 */:
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD_H /* 8978885 */:
            case FinalCanbus.CAR_453_LZ_Toyota_markII_L /* 9634245 */:
            case FinalCanbus.CAR_453_LZ_Toyota_markII_H /* 9699781 */:
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH /* 10420679 */:
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH_H /* 10486215 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300 /* 15008198 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER /* 15139270 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER_H /* 15532486 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300_H /* 15598022 */:
                findViewById(R.id.air_sp_swing).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_swing_toyota_n : R.drawable.ic_hp_swing_toyota_p);
                break;
            default:
                findViewById(R.id.air_sp_swing).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_swing_n : R.drawable.ic_hp_swing_p);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR];
        findViewById(R.id.air_sp_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_rear_n : R.drawable.ic_hp_rear_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFrontHot() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT_HOT];
        findViewById(R.id.air_sp_fronthot).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_fronthot_n : R.drawable.ic_hp_fronthot_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFrontDefrost() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_TORO /* 131111 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
            case FinalCanbus.CAR_RZC_Explorer /* 590158 */:
            case FinalCanbus.CAR_RZC_13_20Mengdiou /* 852302 */:
            case FinalCanbus.CAR_DAOJUN_OD_ATS /* 852316 */:
            case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
            case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
            case FinalCanbus.CAR_RZC_Mustang /* 1048910 */:
            case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
            case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_TORO_M /* 1441831 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_TORO_H /* 1507367 */:
            case FinalCanbus.CAR_RZC_Ford_F150_12 /* 2294094 */:
            case FinalCanbus.CAR_RZC_Mustang_NO_CD /* 2359630 */:
            case FinalCanbus.CAR_RZC_Mustang_15_NO_CD /* 2621774 */:
            case FinalCanbus.CAR_RZC_Explorer_13 /* 3014990 */:
            case FinalCanbus.CAR_RZC_Ford_F150 /* 3080526 */:
            case FinalCanbus.CAR_RZC_Ford_Puma_22 /* 3670350 */:
            case FinalCanbus.CAR_RZC_Mustang_M /* 5374286 */:
            case FinalCanbus.CAR_RZC_Mustang_H /* 5439822 */:
            case FinalCanbus.CAR_RZC_Mustang_NOCD_M /* 5505358 */:
            case FinalCanbus.CAR_RZC_Mustang_NOCD_H /* 5570894 */:
            case FinalCanbus.CAR_RZC_Ford_Puma_22_M /* 5636430 */:
            case FinalCanbus.CAR_RZC_Ford_Puma_22_H /* 5701966 */:
            case FinalCanbus.CAR_RZC_Ford_BRONCO_22 /* 5767502 */:
            case FinalCanbus.CAR_RZC_Ford_BRONCO_22_M /* 5833038 */:
            case FinalCanbus.CAR_RZC_Ford_BRONCO_22_H /* 5898574 */:
            case FinalCanbus.CAR_RZC_Ford_MAVERICK_24 /* 5964110 */:
            case FinalCanbus.CAR_RZC_Ford_MAVERICK_24_M /* 6029646 */:
            case FinalCanbus.CAR_RZC_Ford_MAVERICK_24_H /* 6095182 */:
            case FinalCanbus.CAR_RZC_Ford_Explorer_24 /* 6160718 */:
            case FinalCanbus.CAR_RZC_Ford_Explorer_24_M /* 6226254 */:
            case FinalCanbus.CAR_RZC_Ford_Explorer_24_H /* 6291790 */:
            case FinalCanbus.CAR_RZC_Ford_RANGER_24 /* 6357326 */:
            case FinalCanbus.CAR_RZC_Ford_RANGER_24_M /* 6422862 */:
            case FinalCanbus.CAR_RZC_Ford_RANGER_24_H /* 6488398 */:
            case FinalCanbus.CAR_RZC_Ford_F250_09 /* 6553934 */:
            case FinalCanbus.CAR_RZC_Ford_Expedition_07 /* 6619470 */:
            case FinalCanbus.CAR_RZC_Ford_Expedition_15 /* 6685006 */:
            case FinalCanbus.CAR_RZC_Ford_Flex_13 /* 6750542 */:
            case FinalCanbus.CAR_454_OD_Xinte_DEV1_H /* 7274950 */:
                findViewById(R.id.air_sp_front).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_maxfront_n : R.drawable.ic_hp_maxfront_p);
                break;
            default:
                findViewById(R.id.air_sp_front).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_front_n : R.drawable.ic_hp_front_p);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateMaxFrontDefrost() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONTMAX];
        findViewById(R.id.air_sp_frontmax).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_maxfront_n : R.drawable.ic_hp_maxfront_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePower() {
        int value = DataCanbus.DATA[ConstAllAirDara.U_AIR_POWER];
        if (this.pagenum == 1) {
            value = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_POWER];
        }
        findViewById(R.id.air_sp_power).setBackgroundResource(value == 0 ? R.drawable.ic_hp_power_n : R.drawable.ic_hp_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowBackMode() {
        int mode;
        int mode2;
        int mode3;
        int win = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_UP];
        int body = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_BODY];
        int foot = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_FOOT];
        if (ConstAllAirDara.U_AIR_BACK_BLOW_UP == 255 && ConstAllAirDara.U_AIR_BACK_BLOW_BODY != 255) {
            win = body;
        }
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
        if (ConstAllAirDara.U_AIR_BACK_BLOW_UP == 255) {
            if (ConstAllAirDara.U_AIR_BACK_BLOW_BODY != 255) {
                findViewById(R.id.air_sp_rear_mode_up).setVisibility(win == 0 ? 8 : 0);
            } else {
                findViewById(R.id.air_sp_rear_mode_up).setVisibility(8);
            }
        } else {
            findViewById(R.id.air_sp_rear_mode_up).setVisibility(win == 0 ? 8 : 0);
        }
        findViewById(R.id.air_sp_rear_mode_body).setVisibility(body == 0 ? 8 : 0);
        findViewById(R.id.air_sp_rear_mode_foot).setVisibility(foot == 0 ? 8 : 0);
        findViewById(R.id.air_sp_rear_blow_foot).setBackgroundResource(R.drawable.ic_hp_mode_foot_n);
        findViewById(R.id.air_sp_rear_blow_body).setBackgroundResource(R.drawable.ic_hp_mode_body_n);
        findViewById(R.id.air_sp_rear_blow_body_foot).setBackgroundResource(R.drawable.ic_hp_mode_body_foot_n);
        switch (mode3 & 3) {
            case 1:
                findViewById(R.id.air_sp_rear_blow_foot).setBackgroundResource(R.drawable.ic_hp_mode_foot_p);
                break;
            case 2:
                findViewById(R.id.air_sp_rear_blow_body).setBackgroundResource(R.drawable.ic_hp_mode_body_p);
                break;
            case 3:
                findViewById(R.id.air_sp_rear_blow_body_foot).setBackgroundResource(R.drawable.ic_hp_mode_body_foot_p);
                break;
        }
        if (ConstAllAirDara.U_AIR_BACK_BLOW_UP_RIGHT == 255 && ConstAllAirDara.U_AIR_BACK_BLOW_BODY_RIGHT == 255 && ConstAllAirDara.U_AIR_BACK_BLOW_FOOT_RIGHT == 255) {
            findViewById(R.id.air_sp_rear_mode_up_right).setVisibility(win == 0 ? 8 : 0);
            findViewById(R.id.air_sp_rear_mode_body_right).setVisibility(body == 0 ? 8 : 0);
            findViewById(R.id.air_sp_rear_mode_foot_right).setVisibility(foot != 0 ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowBackModeRight() {
        int mode;
        int mode2;
        int win = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_UP_RIGHT];
        int body = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_BODY_RIGHT];
        int foot = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_FOOT_RIGHT];
        if (ConstAllAirDara.U_AIR_BACK_BLOW_UP_RIGHT == 255 && ConstAllAirDara.U_AIR_BACK_BLOW_BODY_RIGHT != 255) {
            win = body;
        }
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
            int i = mode2 | 1;
        } else {
            int i2 = mode2 & 254;
        }
        if (ConstAllAirDara.U_AIR_BACK_BLOW_UP_RIGHT == 255) {
            if (ConstAllAirDara.U_AIR_BACK_BLOW_BODY != 255) {
                findViewById(R.id.air_sp_rear_mode_up_right).setVisibility(win == 0 ? 8 : 0);
            } else {
                findViewById(R.id.air_sp_rear_mode_up_right).setVisibility(8);
            }
        } else {
            findViewById(R.id.air_sp_rear_mode_up_right).setVisibility(win == 0 ? 8 : 0);
        }
        findViewById(R.id.air_sp_rear_mode_body_right).setVisibility(body == 0 ? 8 : 0);
        findViewById(R.id.air_sp_rear_mode_foot_right).setVisibility(foot != 0 ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowModeLeft() {
        int mode;
        int mode2;
        int mode3;
        int win = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT];
        int body = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT];
        int foot = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT];
        int auto = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_AUTO_LEFT];
        if (win != 0) {
            mode = 0 | 4;
        } else {
            mode = 0 & 251;
        }
        if (body != 0) {
            mode2 = mode | 2;
        } else {
            mode2 = mode & 253;
        }
        if (foot != 0) {
            mode3 = mode2 | 1;
        } else {
            mode3 = mode2 & 254;
        }
        if (ConstAllAirDara.C_AIR_MODE_CENTER != 255) {
            findViewById(R.id.air_sp_blow_changer_center).setBackgroundResource(R.drawable.ic_hp_mode_win_foot_n);
            switch (mode3) {
                case 5:
                    findViewById(R.id.air_sp_blow_changer_center).setBackgroundResource(R.drawable.ic_hp_mode_win_foot_p);
                    break;
            }
        }
        if (ConstAllAirDara.C_AIR_MODE_BODYFOOT == 255 && ConstAllAirDara.C_AIR_MODE_UPFOOT == 255) {
            findViewById(R.id.air_sp_blow_win).setBackgroundResource(win != 0 ? R.drawable.ic_hp_mode_win_p : R.drawable.ic_hp_mode_win_n);
            findViewById(R.id.air_sp_blow_body).setBackgroundResource(body != 0 ? R.drawable.ic_hp_mode_body_p : R.drawable.ic_hp_mode_body_n);
            findViewById(R.id.air_sp_blow_foot).setBackgroundResource(foot != 0 ? R.drawable.ic_hp_mode_foot_p : R.drawable.ic_hp_mode_foot_n);
        } else {
            findViewById(R.id.air_sp_blow_foot).setBackgroundResource(R.drawable.ic_hp_mode_foot_n);
            findViewById(R.id.air_sp_blow_body).setBackgroundResource(R.drawable.ic_hp_mode_body_n);
            findViewById(R.id.air_sp_blow_win).setBackgroundResource(R.drawable.ic_hp_mode_win_n);
            findViewById(R.id.air_sp_blow_body_foot).setBackgroundResource(R.drawable.ic_hp_mode_body_foot_n);
            findViewById(R.id.air_sp_blow_foot_win).setBackgroundResource(R.drawable.ic_hp_mode_win_foot_n);
            switch (mode3) {
                case 1:
                    findViewById(R.id.air_sp_blow_foot).setBackgroundResource(R.drawable.ic_hp_mode_foot_p);
                    break;
                case 2:
                    findViewById(R.id.air_sp_blow_body).setBackgroundResource(R.drawable.ic_hp_mode_body_p);
                    break;
                case 3:
                    findViewById(R.id.air_sp_blow_body_foot).setBackgroundResource(R.drawable.ic_hp_mode_body_foot_p);
                    break;
                case 4:
                    findViewById(R.id.air_sp_blow_win).setBackgroundResource(R.drawable.ic_hp_mode_win_p);
                    break;
                case 5:
                    findViewById(R.id.air_sp_blow_foot_win).setBackgroundResource(R.drawable.ic_hp_mode_win_foot_p);
                    break;
            }
        }
        findViewById(R.id.air_sp_mode_up).setVisibility(win == 0 ? 8 : 0);
        findViewById(R.id.air_sp_mode_body).setVisibility(body == 0 ? 8 : 0);
        findViewById(R.id.air_sp_mode_foot).setVisibility(foot == 0 ? 8 : 0);
        findViewById(R.id.air_sp_mode_auto).setVisibility(auto == 0 ? 8 : 0);
        if (ConstAllAirDara.U_AIR_BLOW_UP_RIGHT == 255 && ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT == 255 && ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT == 255) {
            findViewById(R.id.air_sp_mode_up_right).setVisibility(win == 0 ? 8 : 0);
            findViewById(R.id.air_sp_mode_body_right).setVisibility(body == 0 ? 8 : 0);
            findViewById(R.id.air_sp_mode_foot_right).setVisibility(foot == 0 ? 8 : 0);
            findViewById(R.id.air_sp_mode_auto_right).setVisibility(auto != 0 ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowModeRight() {
        int mode;
        int mode2;
        int mode3;
        int win = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_RIGHT];
        int body = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT];
        int foot = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT];
        int auto = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_AUTO_RIGHT];
        if (win != 0) {
            mode = 0 | 4;
        } else {
            mode = 0 & 251;
        }
        if (body != 0) {
            mode2 = mode | 2;
        } else {
            mode2 = mode & 253;
        }
        if (foot != 0) {
            mode3 = mode2 | 1;
        } else {
            mode3 = mode2 & 254;
        }
        if (ConstAllAirDara.C_AIR_MODE_CENTER != 255) {
            findViewById(R.id.air_sp_blow_changer_center).setBackgroundResource(R.drawable.ic_hp_mode_win_foot_n);
            switch (mode3) {
                case 5:
                    findViewById(R.id.air_sp_blow_changer_center).setBackgroundResource(R.drawable.ic_hp_mode_win_foot_p);
                    break;
            }
        }
        findViewById(R.id.air_sp_mode_up_right).setVisibility(win == 0 ? 8 : 0);
        findViewById(R.id.air_sp_mode_body_right).setVisibility(body == 0 ? 8 : 0);
        findViewById(R.id.air_sp_mode_foot_right).setVisibility(foot == 0 ? 8 : 0);
        findViewById(R.id.air_sp_mode_auto_right).setVisibility(auto != 0 ? 0 : 8);
        if (ConstAllAirDara.C_AIR_MODE_FOOT_RIGHT != 255 && ConstAllAirDara.C_AIR_MODE_BODY_RIGHT != 255 && ConstAllAirDara.C_AIR_MODE_UP_RIGHT != 255) {
            findViewById(R.id.air_sp_blow_win_right).setBackgroundResource(win == 1 ? R.drawable.ic_hp_mode_win_p : R.drawable.ic_hp_mode_win_n);
            findViewById(R.id.air_sp_blow_body_right).setBackgroundResource(body == 1 ? R.drawable.ic_hp_mode_body_p : R.drawable.ic_hp_mode_body_n);
            findViewById(R.id.air_sp_blow_foot_right).setBackgroundResource(foot == 1 ? R.drawable.ic_hp_mode_foot_p : R.drawable.ic_hp_mode_foot_n);
        }
    }
}
