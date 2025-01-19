package com.syu.carinfo.air;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.ui.air.AirHelper;

public class Air_Activity_All_NewAdd_HP extends Activity implements View.OnTouchListener {
    public static Air_Activity_All_NewAdd_HP mInstance;
    public static boolean mIsFront = false;
    int pagenum = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
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
            if (updateCode == ConstAllAirDara.U_AIR_SEATHEAT_LEFT) {
                Air_Activity_All_NewAdd_HP.this.mUpdateHeatLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATHEAT_RIGHT) {
                Air_Activity_All_NewAdd_HP.this.mUpdateHeatRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATWIND_LEFT) {
                Air_Activity_All_NewAdd_HP.this.mUpdateWindLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATWIND_RIGHT) {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen /* 1114567 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen_3 /* 1180103 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha /* 15204806 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha_3 /* 16187846 */:
                //setContentView(R.layout.layout_air_hp_all_prado_cg7870);
                break;
            default:
                //setContentView(R.layout.layout_air_hp_all_prado);
                break;
        }
        initCallbackId();
        init();
        mInstance = this;
    }

    private void sendCmd(int data0, int data1) {
        int data02;
        int data03;
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
            case FinalCanbus.CAR_RZC_18_19Excelle_GT /* 459015 */:
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
                    break;
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{7}, null, null);
                    break;
                }
            case 36:
            case 254:
            case 308:
            case 345:
            case FinalCanbus.CAR_WC2_ShuPingJW /* 65881 */:
            case FinalCanbus.CAR_WC2_ShuPingKeLuZi /* 131417 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao /* 196953 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS /* 262489 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS_S /* 328025 */:
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
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_POWER) {
                        RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                        int i = ConstAllAirDara.C_CONTRAL;
                        int[] iArr = new int[2];
                        iArr[0] = data0;
                        iArr[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_POWER] == 1 ? 0 : 1;
                        remoteModuleProxy.cmd(i, iArr, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_AC) {
                        RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                        int i2 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr2 = new int[2];
                        iArr2[0] = data0;
                        iArr2[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 1 ? 0 : 1;
                        remoteModuleProxy2.cmd(i2, iArr2, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_AUTO) {
                        RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                        int i3 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr3 = new int[2];
                        iArr3[0] = data0;
                        iArr3[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 1 ? 0 : 1;
                        remoteModuleProxy3.cmd(i3, iArr3, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                        int i4 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr4 = new int[2];
                        iArr4[0] = data0;
                        iArr4[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1 ? 1 : 0;
                        remoteModuleProxy4.cmd(i4, iArr4, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_SYNC) {
                        RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                        int i5 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr5 = new int[2];
                        iArr5[0] = data0;
                        iArr5[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_SYNC] == 1 ? 0 : 1;
                        remoteModuleProxy5.cmd(i5, iArr5, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{11, 1}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{11, 2}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{12, 1}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{12, 2}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{13, 1}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{13, 2}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, 255}, null, null);
                        break;
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
                        int ints12 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT];
                        ints1 = ints12 + 1;
                        if (ints1 > 3) {
                            ints1 = 0;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT) {
                        ints0 = 174;
                        int ints13 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT];
                        ints1 = ints13 + 1;
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
                    }
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints0, ints1}, null, null);
                    break;
                }
            case 271:
                if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{3, data1}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{4, data1}, null, null);
                        break;
                    }
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                    break;
                }
            case 282:
            case FinalCanbus.CAR_WC2_17MingJueRuiTeng /* 131354 */:
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_POWER || data0 == ConstAllAirDara.C_AIR_MODE_CHANGER) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, 255}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_AC) {
                        RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                        int i6 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr6 = new int[2];
                        iArr6[0] = data0;
                        iArr6[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 1 ? 0 : 1;
                        remoteModuleProxy6.cmd(i6, iArr6, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_AUTO) {
                        RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                        int i7 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr7 = new int[2];
                        iArr7[0] = data0;
                        iArr7[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 1 ? 0 : 1;
                        remoteModuleProxy7.cmd(i7, iArr7, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST) {
                        RemoteModuleProxy remoteModuleProxy8 = DataCanbus.PROXY;
                        int i8 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr8 = new int[2];
                        iArr8[0] = data0;
                        iArr8[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 1 ? 0 : 1;
                        remoteModuleProxy8.cmd(i8, iArr8, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST) {
                        RemoteModuleProxy remoteModuleProxy9 = DataCanbus.PROXY;
                        int i9 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr9 = new int[2];
                        iArr9[0] = data0;
                        iArr9[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 1 ? 0 : 1;
                        remoteModuleProxy9.cmd(i9, iArr9, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        RemoteModuleProxy remoteModuleProxy10 = DataCanbus.PROXY;
                        int i10 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr10 = new int[2];
                        iArr10[0] = data0;
                        iArr10[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1 ? 1 : 0;
                        remoteModuleProxy10.cmd(i10, iArr10, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{11, 1}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{11, 2}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD || data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{12, 1}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB || data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{12, 2}, null, null);
                        break;
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
                if (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT) {
                    if (data1 == 1) {
                        int value = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT] + 1;
                        if (value > 3) {
                            value = 0;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{15, value}, null, null);
                        break;
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT) {
                    if (data1 == 1) {
                        int value2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT] + 1;
                        if (value2 > 3) {
                            value2 = 0;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{16, value2}, null, null);
                        break;
                    }
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                    break;
                }
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
            case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19 /* 852341 */:
            case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19_H /* 917877 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM /* 1311093 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_H /* 1376629 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_M /* 1835381 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_HY /* 1900917 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_HY_M /* 1966453 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_HY_H /* 2031989 */:
            case FinalCanbus.CAR_RZC_XP1_ZiYouXia_H /* 2163061 */:
                if (data0 == ConstAllAirDara.C_AIR_POWER) {
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_POWER] == 1) {
                        data03 = 16;
                    } else {
                        data03 = 9;
                    }
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data03, data1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                    break;
                }
            case FinalCanbus.CAR_RZC_XP1_BeiQiM50F /* 65932 */:
            case FinalCanbus.CAR_CYT_YaGe7_38400 /* 262561 */:
            case FinalCanbus.CAR_RCW_BYD_10_11F6 /* 328097 */:
            case FinalCanbus.CAR_RCW_BYD_10_13G6 /* 393633 */:
            case FinalCanbus.CAR_RCW_YaGe7_38400 /* 459169 */:
            case FinalCanbus.CAR_WC_YaGe7_38400 /* 524705 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                    break;
                }
            case FinalCanbus.CAR_RZCexc_Feiyate_TORO /* 131111 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[2], null, null);
                    break;
                }
            case FinalCanbus.CAR_RZC_XP1_16HAIMAMV70 /* 131309 */:
            case FinalCanbus.CAR_RZC_XP1_HAIMA_F5 /* 262381 */:
                if (data1 == 1) {
                    int ints02 = 0;
                    int ints14 = 0;
                    if (data0 == ConstAllAirDara.C_AIR_POWER) {
                        ints02 = 168;
                        ints14 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        ints02 = 160;
                        ints14 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        ints02 = 160;
                        ints14 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD) {
                        ints02 = 161;
                        ints14 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                        ints02 = 161;
                        ints14 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        ints02 = 162;
                        ints14 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        ints02 = 162;
                        ints14 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODY) {
                        ints02 = 163;
                        ints14 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT) {
                        ints02 = 163;
                        ints14 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT) {
                        ints02 = 163;
                        ints14 = 2;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_FOOT) {
                        ints02 = 163;
                        ints14 = 3;
                    } else if (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST) {
                        ints02 = 163;
                        ints14 = 4;
                    } else if (data0 == ConstAllAirDara.C_AIR_AC) {
                        ints02 = 164;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 1) {
                            ints14 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 0) {
                            ints14 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        ints02 = 165;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            ints14 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 0) {
                            ints14 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST) {
                        ints02 = 167;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 1) {
                            ints14 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 0) {
                            ints14 = 1;
                        }
                    }
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints02, ints14}, null, null);
                    break;
                }
            case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6 /* 131379 */:
            case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6_H /* 196915 */:
                int ints03 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints04 = ints03 | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_AC_MAX ? 1 : 0);
                int ints15 = 0 | (data0 == ConstAllAirDara.C_AIR_DUAL ? 8 : 0);
                int ints16 = ints15 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints2 = 0 | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 160 : 0);
                int ints22 = ints2 | (data0 == ConstAllAirDara.C_AIR_MODE_BODY ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_FOOT ? 96 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT ? 128 : 0) | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 1 : 0);
                int ints3 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints32 = ints3 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints4 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                int ints42 = ints4 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints04, ints16, ints22, ints32, ints42, 0}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                    break;
                }
            case FinalCanbus.CAR_RZC_SeMar_NoAmp /* 196688 */:
            case FinalCanbus.CAR_RZC_SwMar_Amp /* 262224 */:
            case FinalCanbus.CAR_RZC_SwMar_17 /* 1441872 */:
            case FinalCanbus.CAR_RZC_SwMar_Amp_17 /* 1507408 */:
                int ints05 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints06 = ints05 | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0);
                if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                        ints06 = 8;
                    } else {
                        ints06 = 4;
                    }
                }
                int ints17 = 0 | (data0 == ConstAllAirDara.C_AIR_DUAL ? 8 : 0);
                int ints18 = ints17 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints33 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints34 = ints33 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints43 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                int ints44 = ints43 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints06, ints18, 0, ints34, ints44, 0}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                    break;
                }
            case FinalCanbus.CAR_RZC_HanTeng_H /* 196863 */:
            case FinalCanbus.CAR_Oudi_HanTeng_X5 /* 393471 */:
            case FinalCanbus.CAR_Oudi_XiaoYao /* 459007 */:
            case FinalCanbus.CAR_RZC_HanTeng_X5 /* 524543 */:
            case FinalCanbus.CAR_RZC_FengShen19_20AX7 /* 917759 */:
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
                int ints19 = 0;
                int ints23 = 0;
                int ints45 = 0;
                int ints5 = 0;
                int ints07 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints08 = ints07 | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0);
                if (DataCanbus.DATA[1000] == 2294215) {
                    ints19 = 0 | (data0 == ConstAllAirDara.C_AIR_AC_MAX ? 8 : 0);
                } else {
                    ints08 |= data0 == ConstAllAirDara.C_AIR_AC_MAX ? 1 : 0;
                }
                if (data0 == ConstAllAirDara.C_AIR_MODE_BODY) {
                    ints23 = 32;
                } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT) {
                    ints23 = 64;
                } else if (data0 == ConstAllAirDara.C_AIR_MODE_FOOT) {
                    ints23 = 96;
                } else if (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT) {
                    ints23 = 128;
                } else if (data0 == ConstAllAirDara.C_AIR_MODE_UP) {
                    ints23 = 160;
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
                        ints19 = ints19 | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                        if (data0 != ConstAllAirDara.C_AIR_CYCLE) {
                            if (data0 != ConstAllAirDara.C_AIR_MODE_BODY) {
                                if (data0 != ConstAllAirDara.C_AIR_MODE_BODYFOOT) {
                                    if (data0 != ConstAllAirDara.C_AIR_MODE_FOOT) {
                                        if (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT) {
                                            ints23 = 16;
                                            break;
                                        }
                                    } else {
                                        ints23 = 8;
                                        break;
                                    }
                                } else {
                                    ints23 = 4;
                                    break;
                                }
                            } else {
                                ints23 = 2;
                                break;
                            }
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            ints08 = 8;
                            break;
                        } else {
                            ints08 = 4;
                            break;
                        }
                    case FinalCanbus.CAR_Oudi_HanTeng_X5 /* 393471 */:
                    case FinalCanbus.CAR_Oudi_XiaoYao /* 459007 */:
                        if (data0 != ConstAllAirDara.C_AIR_WIND_ADD) {
                            if (data0 != ConstAllAirDara.C_AIR_WIND_SUB) {
                                if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                                        ints08 = 8;
                                        break;
                                    } else {
                                        ints08 = 4;
                                        break;
                                    }
                                }
                            } else {
                                int value3 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] - 1;
                                if (value3 < 0) {
                                    value3 = 0;
                                }
                                ints19 = value3 << 4;
                                break;
                            }
                        } else {
                            int value4 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] + 1;
                            if (value4 > 7) {
                                value4 = 7;
                            }
                            ints19 = value4 << 4;
                            break;
                        }
                    case FinalCanbus.CAR_439_OuDi_Z560 /* 983479 */:
                        ints19 = ints19 | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0) | (data0 == ConstAllAirDara.C_AIR_DUAL ? 8 : 0);
                        if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                            if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                                ints08 = 8;
                                break;
                            } else {
                                ints08 = 4;
                                break;
                            }
                        }
                        break;
                    case FinalCanbus.CAR_455_OD_Dongfeng_Racing_EC75_23H /* 2294215 */:
                    case FinalCanbus.CAR_454_OD_Dongfeng_Racing_EC75_23 /* 8454598 */:
                        ints08 |= data0 == ConstAllAirDara.C_AIR_CYCLE ? 4 : 0;
                        ints19 = ints19 | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0) | (data0 == ConstAllAirDara.C_AIR_HEAT ? 4 : 0);
                        break;
                    case FinalCanbus.CAR_452_RZC_Subaru /* 7209412 */:
                    case FinalCanbus.CAR_454_RZC_Suburu_OUTBACK_18 /* 8323526 */:
                        if (data0 != ConstAllAirDara.C_AIR_WIND_ADD) {
                            if (data0 != ConstAllAirDara.C_AIR_WIND_SUB) {
                                if (data0 != ConstAllAirDara.C_AIR_CYCLE) {
                                    if (data0 != ConstAllAirDara.C_AIR_SYNC) {
                                        if (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST) {
                                            ints19 = 4;
                                            break;
                                        }
                                    } else {
                                        ints19 = 8;
                                        break;
                                    }
                                } else {
                                    ints23 = 1;
                                    break;
                                }
                            } else {
                                int value5 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] - 1;
                                if (value5 < 0) {
                                    value5 = 0;
                                }
                                ints19 = value5 << 4;
                                break;
                            }
                        } else {
                            int value6 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] + 1;
                            if (value6 > 7) {
                                value6 = 7;
                            }
                            ints19 = value6 << 4;
                            break;
                        }
                }
                int ints110 = ints19 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0);
                int ints35 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints36 = ints35 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_452_RZC_Subaru /* 7209412 */:
                    case FinalCanbus.CAR_454_RZC_Suburu_OUTBACK_18 /* 8323526 */:
                        int ints46 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                        ints45 = ints46 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                        int ints52 = 0 | (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT ? 2 : 0);
                        ints5 = ints52 | (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT ? 1 : 0);
                        break;
                    default:
                        ints36 = ints36 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                        break;
                }
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints08, ints110, ints23, ints36, ints45, ints5}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                    break;
                }
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
                    break;
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                    break;
                }
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
                if (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT) {
                    if (data1 == 1) {
                        int value7 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT] + 1;
                        if (value7 > 3) {
                            value7 = 0;
                        }
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, value7}, null, null);
                        break;
                    }
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                    break;
                }
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
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{172, data0}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{172}, null, null);
                    break;
                }
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
            case FinalCanbus.CAR_439_RZC_Nissan_19Qida /* 8585655 */:
            case FinalCanbus.CAR_439_RZC_Nissan_19Qida_H /* 8651191 */:
                int ints09 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints010 = ints09 | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0);
                if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                        ints010 = 8;
                    } else {
                        ints010 = 4;
                    }
                }
                int ints111 = 0 | (data0 == ConstAllAirDara.C_AIR_DUAL ? 8 : 0);
                int ints112 = ints111 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints37 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints38 = ints37 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints47 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                int ints48 = ints47 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                int ints53 = 0 | (data0 == ConstAllAirDara.C_REAR_CTRL ? 4 : 0);
                int ints54 = ints53 | (data0 == ConstAllAirDara.C_AIR_BLOWTOP ? 2 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints010, ints112, 0, ints38, ints48, ints54}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                    break;
                }
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
                } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODY) {
                    data0 = 16;
                } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT) {
                    data0 = 16;
                } else if (data0 == ConstAllAirDara.C_AIR_MODE_FOOT) {
                    data0 = 16;
                } else if (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT) {
                    data0 = 16;
                }
                DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                break;
            case FinalCanbus.CAR_RZC_XP1_BeiQiBJ40_21_H /* 1048972 */:
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{3, data1}, null, null);
                            break;
                        } else {
                            DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{4, data1}, null, null);
                            break;
                        }
                    } else {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                        break;
                    }
                }
                break;
            case FinalCanbus.CAR_DJ_XC_TOYOTA_LEXUS /* 1049005 */:
                if (this.pagenum == 0) {
                    DataCanbus.PROXY.cmd(3, new int[]{data0, data1}, null, null);
                    break;
                } else if (this.pagenum == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_REAR_MANUAL) {
                        DataCanbus.PROXY.cmd(3, new int[]{64, data1}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(6, new int[]{data0, data1}, null, null);
                        break;
                    }
                }
                break;
            case FinalCanbus.CAR_RZC_Dodge_JCUV /* 1114485 */:
            case FinalCanbus.CAR_RZC_Dodge_JCUV_H /* 2359669 */:
                if (this.pagenum == 0) {
                    if (data0 == ConstAllAirDara.C_AIR_POWER) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_POWER] == 1) {
                            data02 = 16;
                        } else {
                            data02 = 9;
                        }
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data02, data1}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                        break;
                    }
                } else if (this.pagenum == 1) {
                    DataCanbus.PROXY.cmd(10, new int[]{data0, data1}, null, null);
                    break;
                }
            case FinalCanbus.CAR_455_LZ_GMC_Sierra_19_RScreen /* 1507783 */:
            case FinalCanbus.CAR_455_LZ_Chevrolet_Silverado_19_RScreen /* 1573319 */:
            case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
            case FinalCanbus.CAR_454_LZ_Chevrolet_Silverado_19_Screen /* 11993542 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{1, data0}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{1}, null, null);
                    break;
                }
            case FinalCanbus.CAR_CZH_OD_NISSAN_22Teana_Top /* 1572944 */:
                if (data1 == 1) {
                    int ints011 = 0;
                    int ints113 = 0;
                    if (data0 == ConstAllAirDara.C_AIR_POWER) {
                        ints011 = 168;
                        ints113 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        ints011 = 160;
                        ints113 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        ints011 = 160;
                        ints113 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD) {
                        ints011 = 161;
                        ints113 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                        ints011 = 161;
                        ints113 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        ints011 = 162;
                        ints113 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        ints011 = 162;
                        ints113 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODY) {
                        ints011 = 163;
                        ints113 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT) {
                        ints011 = 163;
                        ints113 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT) {
                        ints011 = 163;
                        ints113 = 2;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_FOOT) {
                        ints011 = 163;
                        ints113 = 3;
                    } else if (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST) {
                        ints011 = 166;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 1) {
                            ints113 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 0) {
                            ints113 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_AC) {
                        ints011 = 164;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 1) {
                            ints113 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 0) {
                            ints113 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        ints011 = 165;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            ints113 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 0) {
                            ints113 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST) {
                        ints011 = 167;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 1) {
                            ints113 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 0) {
                            ints113 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_AUTO) {
                        ints011 = 169;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 1) {
                            ints113 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 0) {
                            ints113 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_AC_MAX) {
                        ints011 = 170;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC_MAX] == 1) {
                            ints113 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC_MAX] == 0) {
                            ints113 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_SYNC) {
                        ints011 = 171;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_SYNC] == 1) {
                            ints113 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_SYNC] == 0) {
                            ints113 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_STEER) {
                        ints011 = 182;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_STEER] == 1) {
                            ints113 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_STEER] == 0) {
                            ints113 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT) {
                        ints011 = 172;
                        int ints114 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT];
                        ints113 = ints114 + 1;
                        if (ints113 > 2) {
                            ints113 = 0;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT) {
                        ints011 = 173;
                        int ints115 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT];
                        ints113 = ints115 + 1;
                        if (ints113 > 2) {
                            ints113 = 0;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_LEFT_COLD) {
                        ints011 = 174;
                        int ints116 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_LEFT];
                        ints113 = ints116 + 1;
                        if (ints113 > 3) {
                            ints113 = 0;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_RIGHT_COLD) {
                        ints011 = 175;
                        int ints117 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_RIGHT];
                        ints113 = ints117 + 1;
                        if (ints113 > 3) {
                            ints113 = 0;
                        }
                    }
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints011, ints113}, null, null);
                    break;
                }
            case FinalCanbus.CAR_453_LZ_GM_Camaro_17 /* 2163141 */:
            case FinalCanbus.CAR_453_LZ_GM_GMC_TERRAIN_17 /* 2228677 */:
            case FinalCanbus.CAR_453_LZ_GM_Equinox_17 /* 2294213 */:
            case FinalCanbus.CAR_454_LZ_GM_Camaro_17_Auto /* 6947270 */:
            case FinalCanbus.CAR_454_LZ_GM_Equinox_17_Auto /* 7012806 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{39, data0}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{39}, null, null);
                    break;
                }
            case FinalCanbus.CAR_452_DJ_Dodge_JCUV /* 4981188 */:
                if (this.pagenum == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{data0, data1}, null, null);
                    break;
                } else if (this.pagenum == 1) {
                    DataCanbus.PROXY.cmd(1, new int[]{data0, data1}, null, null);
                    break;
                }
            case FinalCanbus.CAR_452_LZ_TATA_ALL /* 5898692 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{13, data0}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{13}, null, null);
                    break;
                }
            case FinalCanbus.CAR_453_RZC_LandRover_Discovery_19 /* 6160837 */:
            case FinalCanbus.CAR_454_RZC_LandRover_Discovery_04 /* 9765318 */:
            case FinalCanbus.CAR_452_KYC_Zhonghua_All /* 10617284 */:
            case FinalCanbus.CAR_452_KYC_Zhonghua_All_H /* 10682820 */:
            case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7 /* 10748356 */:
            case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7_H /* 10813892 */:
            case FinalCanbus.CAR_454_KYC_Ford_Mustang_07_H /* 13631942 */:
            case FinalCanbus.CAR_454_KYC_Ford_Mustang_07_L /* 13697478 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0}, null, null);
                    break;
                }
            case FinalCanbus.CAR_452_XC_Ford_Escape_13_17 /* 6422980 */:
            case FinalCanbus.CAR_452_XC_Ford_edge_11_13 /* 6488516 */:
            case FinalCanbus.CAR_452_XC_Ford_Raptor_F150_09_14 /* 6554052 */:
            case FinalCanbus.CAR_452_XC_Ford_edge_15_17 /* 6619588 */:
            case FinalCanbus.CAR_452_XC_Ford_Mondeo_13_18 /* 6685124 */:
            case FinalCanbus.CAR_439_HC_Ford_Explorer /* 15335863 */:
                if (this.pagenum == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{data0, data1}, null, null);
                    break;
                } else if (this.pagenum == 1) {
                    DataCanbus.PROXY.cmd(5, new int[]{data0, data1}, null, null);
                    break;
                }
            case FinalCanbus.CAR_452_LZ_Jaguar_F_TYPE /* 6881732 */:
            case FinalCanbus.CAR_452_LZ_Jaguar_XJL /* 7012804 */:
            case FinalCanbus.CAR_452_LZ_Jaguar_XFL_PACE /* 12779972 */:
            case FinalCanbus.CAR_452_LZ_Jaguar_XFL_PACE_H /* 13238724 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{8, data0}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{8}, null, null);
                    break;
                }
            case FinalCanbus.CAR_RZC_HavalH6Couple_BLUE_TOP /* 7078327 */:
            case FinalCanbus.CAR_RZC_HavalH6Couple_RED_TOP /* 7143863 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6Couple_19 /* 7602615 */:
            case FinalCanbus.CAR_439_RZC_Haval_18_19H6 /* 11272631 */:
                if (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT) {
                    if (data1 == 1) {
                        int ints118 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT];
                        int ints119 = ints118 + 1;
                        if (ints119 > 3) {
                            ints119 = 0;
                        }
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{44, ints119}, null, null);
                        break;
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT) {
                    if (data1 == 1) {
                        int ints120 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT];
                        int ints121 = ints120 + 1;
                        if (ints121 > 3) {
                            ints121 = 0;
                        }
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{45, ints121}, null, null);
                        break;
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_LEFT_COLD) {
                    if (data1 == 1) {
                        int ints122 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_LEFT];
                        int ints123 = ints122 + 1;
                        if (ints123 > 3) {
                            ints123 = 0;
                        }
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{46, ints123}, null, null);
                        break;
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_RIGHT_COLD) {
                    if (data1 == 1) {
                        int ints124 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_RIGHT];
                        int ints125 = ints124 + 1;
                        if (ints125 > 3) {
                            ints125 = 0;
                        }
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{47, ints125}, null, null);
                        break;
                    }
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                    break;
                }
            case FinalCanbus.CAR_453_LZ_ALFA_ROMEO /* 7930309 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{34, data0}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{34}, null, null);
                    break;
                }
            case FinalCanbus.CAR_453_LZ_Jili_Boyue_18 /* 8782277 */:
            case FinalCanbus.CAR_453_LZ_Jili_Boyue_18_H /* 8847813 */:
                int ints012 = 0;
                int ints126 = 0;
                int ints24 = 0;
                int ints39 = 0;
                int ints49 = 0;
                int ints55 = 0;
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST) {
                        ints012 = 128;
                        ints126 = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 1 ? 0 : 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        ints012 = 64;
                        ints126 = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1 ? 0 : 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_AUTO) {
                        ints012 = 32;
                        ints126 = DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 1 ? 0 : 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_AC) {
                        ints012 = 16;
                        ints126 = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 1 ? 0 : 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_AC_MAX) {
                        ints012 = 8;
                        ints126 = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC_MAX] == 1 ? 0 : 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_DUAL) {
                        ints012 = 4;
                        ints126 = DataCanbus.DATA[ConstAllAirDara.U_AIR_DUAL] == 1 ? 0 : 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_ION) {
                        ints012 = 2;
                        ints126 = DataCanbus.DATA[ConstAllAirDara.U_AIR_ION] == 1 ? 0 : 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST) {
                        ints012 = 1;
                        ints126 = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 1 ? 0 : 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        int winlev = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                        if (winlev < 8) {
                            winlev++;
                        }
                        ints24 = winlev | 128;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        int winlev2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                        if (winlev2 > 0) {
                            winlev2--;
                        }
                        ints24 = winlev2 | 128;
                    } else if (data0 == ConstAllAirDara.C_AIR_POWER) {
                        ints24 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] != 0 ? 128 : 129;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODY) {
                        ints39 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_FOOT) {
                        ints39 = 2;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT) {
                        ints39 = 3;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT) {
                        ints39 = 4;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                        int value8 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT];
                        ints49 = value8 == -2 ? 1 : value8 == -3 ? 15 : value8 - 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD) {
                        int value9 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT];
                        ints49 = value9 == -2 ? 2 : value9 == -3 ? 16 : value9 + 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        int value10 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_RIGHT];
                        ints55 = value10 == -2 ? 1 : value10 == -3 ? 15 : value10 - 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        int value11 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_RIGHT];
                        ints55 = value11 == -2 ? 2 : value11 == -3 ? 16 : value11 + 1;
                    }
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints012, ints126, ints24, ints39, ints49, ints55, 0}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[7], null, null);
                    break;
                }
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
                    break;
                }
            case FinalCanbus.CAR_454_RZC_Shanqi_DelongG2 /* 10027462 */:
                int ints013 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints014 = ints013 | (data0 == ConstAllAirDara.C_AIR_AC ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 8 : 0);
                int ints127 = 0 | (data0 == ConstAllAirDara.C_AIR_MODE_BODY ? 16 : 0);
                int ints128 = ints127 | (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_FOOT ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UP ? 1 : 0);
                int ints25 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints26 = ints25 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0) | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                int ints410 = 0 | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0);
                int ints411 = ints410 | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints014, ints128, ints26, 0, ints411}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[5], null, null);
                    break;
                }
            case FinalCanbus.CAR_454_OD_Yutong_Qingka /* 11338182 */:
                int ints015 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints016 = ints015 | (data0 == ConstAllAirDara.C_AIR_PTC ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_AC_MAX ? 1 : 0);
                int ints129 = 0 | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0);
                int ints130 = ints129 | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints27 = 0 | (data0 == ConstAllAirDara.C_AIR_MODE_BODY ? 1 : 0);
                int ints28 = ints27 | (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_FOOT ? 3 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UP ? 5 : 0);
                int ints310 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints311 = ints310 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints412 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                int ints413 = ints412 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints016, ints130, ints28, ints311, ints413, 0}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                    break;
                }
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
            case FinalCanbus.CAR_RZC_18_19Excelle_GT /* 459015 */:
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
                ConstAllAirDara.TEMPERATURE_LOW = 0;
                ConstAllAirDara.TEMPERATURE_HIGHT = 30;
                ConstAllAirDara.U_AIR_HAVE_REAR = 255;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 49;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                switch (DataCanbus.DATA[1000]) {
                    case 25:
                    case 26:
                    case FinalCanbus.CAR_XP1_GM_H1 /* 65561 */:
                    case FinalCanbus.CAR_XP1_GM_H2 /* 131097 */:
                    case FinalCanbus.CAR_XP1_GM_H3 /* 196633 */:
                    case FinalCanbus.CAR_XP1_GM_Camaro_10 /* 262169 */:
                    case FinalCanbus.CAR_XP1_GM_AJcd600 /* 2228249 */:
                    case FinalCanbus.CAR_DJ_GM_ALL /* 2424857 */:
                    case FinalCanbus.CAR_XP1_GM_AJcd650 /* 2490393 */:
                    case FinalCanbus.CAR_XP1_GM_Opel_Meriva /* 2621465 */:
                    case FinalCanbus.CAR_DJ_GM_Kopach /* 2687001 */:
                        ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 24;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 5;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 22;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 23;
                ConstAllAirDara.C_AIR_DUAL = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 20;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 21;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 33;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 34;
                ConstAllAirDara.C_AIR_MODE_BODY = 8;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 9;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 10;
                ConstAllAirDara.C_AIR_MODE_FOOT = 11;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case 36:
            case 254:
            case 308:
            case 345:
            case FinalCanbus.CAR_WC2_ShuPingJW /* 65881 */:
            case FinalCanbus.CAR_WC2_ShuPingKeLuZi /* 131417 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao /* 196953 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS /* 262489 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS_S /* 328025 */:
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
                ConstAllAirDara.C_AIR_AC = 8;
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
                ConstAllAirDara.C_CONTRAL = 107;
                break;
            case 271:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 18;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 18;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 19;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 21;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 22;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_WIND_ADD = 16;
                ConstAllAirDara.C_AIR_WIND_SUB = 17;
                ConstAllAirDara.C_AIR_POWER = 20;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_MODE_BODY = 10;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 11;
                ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 9;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 23;
                ConstAllAirDara.C_CONTRAL = 0;
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
                ConstAllAirDara.C_AIR_POWER = 10;
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
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_WC1_Jeep_17ZhiNanZhe /* 262516 */:
                    case FinalCanbus.CAR_WC1_Jeep_17ZhiNanZhe_H /* 328052 */:
                        break;
                    default:
                        ConstAllAirDara.U_AIR_REAR_CTRL = 67;
                        ConstAllAirDara.U_AIR_STEER = 66;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.C_REAR_CTRL = 22;
                        ConstAllAirDara.C_AIR_STEER = 45;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                        ConstAllAirDara.C_AIR_MODE_UP = 8;
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
                ConstAllAirDara.C_AIR_AC_MAX = 21;
                ConstAllAirDara.C_AIR_MODE_BODY = 9;
                ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 24;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 23;
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
            case FinalCanbus.CAR_RZC_18Zhihuiguan /* 655733 */:
            case FinalCanbus.CAR_RZC_19Tiaozhanzhe_H /* 721269 */:
            case FinalCanbus.CAR_RZC_18Zhihuiguan_H /* 786805 */:
            case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19 /* 852341 */:
            case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19_H /* 917877 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM /* 1311093 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_H /* 1376629 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_M /* 1835381 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_HY /* 1900917 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_HY_M /* 1966453 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_HY_H /* 2031989 */:
            case FinalCanbus.CAR_RZC_XP1_ZiYouXia_H /* 2163061 */:
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
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 36;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 37;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 38;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 39;
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
            case FinalCanbus.CAR_RZCexc_Feiyate_TORO /* 131111 */:
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
                    case FinalCanbus.CAR_439_RZC_Nissan_19Qida /* 8585655 */:
                    case FinalCanbus.CAR_439_RZC_Nissan_19Qida_H /* 8651191 */:
                        ConstAllAirDara.C_CONTRAL = 0;
                        break;
                    default:
                        ConstAllAirDara.C_CONTRAL = 2;
                        break;
                }
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
            case FinalCanbus.CAR_444_WC2_XianDai_All_15Carnival /* 1966524 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_15Carnival_H /* 2032060 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_23NewZealand /* 2097596 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_23NewZealand_H /* 2163132 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra /* 2949564 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra_H /* 3015100 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra_EV /* 3211708 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_18OPTIMA /* 15073723 */:
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria /* 328124 */:
                    case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria_H /* 393660 */:
                    case FinalCanbus.CAR_444_WC2_XianDai_All_15Carnival /* 1966524 */:
                    case FinalCanbus.CAR_444_WC2_XianDai_All_15Carnival_H /* 2032060 */:
                        switch (DataCanbus.DATA[1000]) {
                            case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria /* 328124 */:
                            case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria_H /* 393660 */:
                                ConstAllAirDara.U_AIR_HAVE_REAR = 2;
                                break;
                            case FinalCanbus.CAR_444_WC2_XianDai_All_15Carnival /* 1966524 */:
                            case FinalCanbus.CAR_444_WC2_XianDai_All_15Carnival_H /* 2032060 */:
                            case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra /* 2949564 */:
                            case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra_H /* 3015100 */:
                            case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra_EV /* 3211708 */:
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
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
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
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_WC2_20BaoJun530_Auto /* 393462 */:
            case FinalCanbus.CAR_WC2_20BaoJun530_Hand /* 458998 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
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
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 18;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_20BaoJunRS3 /* 459062 */:
                    case FinalCanbus.CAR_OD_RZC_20BaoJunRS3 /* 590134 */:
                    case FinalCanbus.CAR_OD_RZC_Wuling_Xingchen /* 655670 */:
                    case FinalCanbus.CAR_RZC_Wuling_Xingchen /* 721206 */:
                    case FinalCanbus.CAR_RZC_Wuling_Jiachen /* 852278 */:
                    case FinalCanbus.CAR_RZC_Wuling_Xingchi /* 1179958 */:
                        ConstAllAirDara.U_AIR_AC_MAX = 53;
                        ConstAllAirDara.C_AIR_AC_MAX = 22;
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
                ConstAllAirDara.TEMPERATURE_NONE = 1048578;
                ConstAllAirDara.TEMPERATURE_LOW = 1048576;
                ConstAllAirDara.TEMPERATURE_HIGHT = FinalCanbus.CAR_WC1_VW_Polo_08_18;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 25;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_Explorer /* 590158 */:
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
                        ConstAllAirDara.U_AIR_FRONTMAX = 255;
                        ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 255;
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
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
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
                ConstAllAirDara.TEMPERATURE_LOW = 0;
                ConstAllAirDara.TEMPERATURE_HIGHT = 127;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
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
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 39;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                if (DataCanbus.DATA[1000] == 1245508 || DataCanbus.DATA[1000] == 983364 || DataCanbus.DATA[1000] == 1114436 || DataCanbus.DATA[1000] == 917828 || DataCanbus.DATA[1000] == 721220) {
                    ConstAllAirDara.U_AIR_DUAL = 14;
                    ConstAllAirDara.U_AIR_AUTO = 13;
                    ConstAllAirDara.C_AIR_AUTO = 21;
                    ConstAllAirDara.C_AIR_DUAL = 16;
                }
                ConstAllAirDara.C_CONTRAL = 2;
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
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.C_AIR_SYNC = 23;
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
                                break;
                            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460_H /* 5374404 */:
                                ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                                ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                                ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
                                ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT = 37;
                                ConstAllAirDara.U_AIR_CLEAN = 76;
                                ConstAllAirDara.C_CLEAN = 39;
                                break;
                            default:
                                ConstAllAirDara.U_AIR_FLOWER_BLOW = 33;
                                ConstAllAirDara.C_AIR_FLOWER_BLOW = 40;
                                break;
                        }
                        ConstAllAirDara.C_AIR_SWING = 60;
                        ConstAllAirDara.C_AIR_FRONT_HOT = 38;
                        ConstAllAirDara.C_REAR_CTRL = 57;
                        ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                        ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                        ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 41;
                        ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                        ConstAllAirDara.U_AIR_BACK_POWER = 42;
                        ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                        ConstAllAirDara.U_AIR_BACK_BLOW_UP = 18;
                        ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 19;
                        ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 20;
                        ConstAllAirDara.U_AIR_REAR_MANUAL = 86;
                        ConstAllAirDara.C_REAR_AUTO = 52;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 41;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 42;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 50;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 51;
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
            case FinalCanbus.CAR_439_OuDi_Z560 /* 983479 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
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
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD /* 8913349 */:
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD_H /* 8978885 */:
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
            case FinalCanbus.CAR_RZC_Dodge_JCUV /* 1114485 */:
            case FinalCanbus.CAR_RZC_Dodge_JCUV_H /* 2359669 */:
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
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
            case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen /* 1114567 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen_3 /* 1180103 */:
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
            case FinalCanbus.CAR_RZC_Renault_SM6_18 /* 6226322 */:
            case FinalCanbus.CAR_RZC_Renault_SCENIC_16 /* 6291858 */:
            case FinalCanbus.CAR_RZC_Renault_SM6_18_M /* 6357394 */:
            case FinalCanbus.CAR_RZC_Renault_SCENIC_16_M /* 6422930 */:
            case FinalCanbus.CAR_RZC_Renault_SM6_18_H /* 6488466 */:
            case FinalCanbus.CAR_RZC_Renault_SCENIC_16_H /* 6554002 */:
            case FinalCanbus.CAR_RZC_Renault_Dokker_18 /* 6750610 */:
            case FinalCanbus.CAR_RZC_Renault_Dokker_18_H /* 6816146 */:
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
                    case FinalCanbus.CAR_RZC_Renault_SM6_18 /* 6226322 */:
                    case FinalCanbus.CAR_RZC_Renault_SM6_18_M /* 6357394 */:
                    case FinalCanbus.CAR_RZC_Renault_SCENIC_16_M /* 6422930 */:
                    case FinalCanbus.CAR_RZC_Renault_SM6_18_H /* 6488466 */:
                    case FinalCanbus.CAR_RZC_Renault_SCENIC_16_H /* 6554002 */:
                    case FinalCanbus.CAR_RZC_Renault_Dokker_18_H /* 6816146 */:
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
            case FinalCanbus.CAR_455_LZ_GMC_Sierra_19_RScreen /* 1507783 */:
            case FinalCanbus.CAR_455_LZ_Chevrolet_Silverado_19_RScreen /* 1573319 */:
            case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
            case FinalCanbus.CAR_454_LZ_Chevrolet_Silverado_19_Screen /* 11993542 */:
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
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
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                ConstAllAirDara.U_AIR_REAR_SYNC = 86;
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
                ConstAllAirDara.C_AIR_SYNC = 8;
                ConstAllAirDara.C_AIR_AC = 9;
                ConstAllAirDara.C_AIR_CYCLE = 10;
                ConstAllAirDara.C_AIR_AUTO = 11;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 12;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 13;
                ConstAllAirDara.C_AIR_MODE_UP = 16;
                ConstAllAirDara.C_AIR_MODE_BODY = 14;
                ConstAllAirDara.C_AIR_MODE_FOOT = 15;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 17;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 18;
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
                ConstAllAirDara.C_REAR_AUTO = 28;
                ConstAllAirDara.C_REAR_SYNC = 27;
                ConstAllAirDara.C_REAR_OFF = 26;
                break;
            case FinalCanbus.CAR_CZH_OD_NISSAN_22Teana_Top /* 1572944 */:
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
            case FinalCanbus.CAR_455_TD_INFINIT_ESQ /* 1704391 */:
            case FinalCanbus.CAR_455_TD_INFINIT_G /* 1769927 */:
            case FinalCanbus.CAR_455_TD_INFINIT_QX50 /* 1835463 */:
            case FinalCanbus.CAR_455_TD_INFINIT_06FX /* 1900999 */:
            case FinalCanbus.CAR_455_TD_INFINIT_08FX /* 1966535 */:
            case FinalCanbus.CAR_455_TD_INFINIT_14QX70 /* 2032071 */:
            case FinalCanbus.CAR_455_TD_INFINIT_12FX /* 2097607 */:
            case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_L /* 13763014 */:
            case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_H /* 13828550 */:
                switch (DataCanbus.DATA[1000]) {
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
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
            case FinalCanbus.CAR_443_WC2_Ford_EDGE_11 /* 6685115 */:
            case FinalCanbus.CAR_443_WC2_Ford_EDGE_11_CD /* 6750651 */:
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
                ConstAllAirDara.TEMPERATURE_LOW = 254;
                ConstAllAirDara.TEMPERATURE_HIGHT = 255;
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
                ConstAllAirDara.C_REAR_TEMP_DOWN = 33;
                ConstAllAirDara.C_REAR_TEMP_UP = 32;
                ConstAllAirDara.C_REAR_WIND_DOWN = 43;
                ConstAllAirDara.C_REAR_WIND_UP = 42;
                ConstAllAirDara.C_REAR_LOCK = 34;
                ConstAllAirDara.C_REAR_OFF = 46;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_452_DJ_Dodge_JCUV /* 4981188 */:
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
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11 /* 5177797 */:
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_18 /* 5243333 */:
            case FinalCanbus.CAR_LUZ_Toyato_All /* 7274935 */:
            case FinalCanbus.CAR_LUZ_Toyato_All_H /* 7340471 */:
            case FinalCanbus.CAR_LUZ_Toyato_20All /* 8126903 */:
            case FinalCanbus.CAR_LUZ_Toyato_30All /* 8192439 */:
            case FinalCanbus.CAR_452_LZ_Toyato_RX450 /* 12648900 */:
            case FinalCanbus.CAR_452_LZ_Toyato_RX270 /* 12714436 */:
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
                    case FinalCanbus.CAR_453_LZ_NISSAN_patrol /* 5308869 */:
                    case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX60 /* 5374405 */:
                    case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX80 /* 5439941 */:
                    case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX56 /* 5505477 */:
                        ConstAllAirDara.U_AIR_REAR_CTRL = 38;
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
            case FinalCanbus.CAR_452_OD_HZ_Nezha /* 7602628 */:
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
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 65;
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
                ConstAllAirDara.C_AIR_LEFT_HEAT = 13;
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
            findViewById(R.id.air_sp_front).setVisibility(8);
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
            case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_L /* 13763014 */:
            case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_H /* 13828550 */:
                return false;
            default:
                return true;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        initCallbackId();
        init();
        addUpdater();
        if (IsdisableAirWindow()) {
            AirHelper.disableAirWindowLocal(true);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        if (IsdisableAirWindow()) {
            AirHelper.disableAirWindowLocal(false);
        }
        removeUpdater();
        ConstAllAirDara.JumpNewAir = false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 255;
        switch (id) {
            case R.id.tv_sp_front /* 2131427932 */:
                this.pagenum = 0;
                findViewById(R.id.veiw_air_front).setVisibility(0);
                findViewById(R.id.veiw_air_rear).setVisibility(8);
                ((TextView) findViewById(R.id.tv_sp_front)).setTextColor(Color.parseColor("#d5a45e"));
                ((TextView) findViewById(R.id.tv_sp_rear)).setTextColor(Color.parseColor("#ffffff"));
                if (ConstAllAirDara.U_AIR_POWER != 255) {
                    mUpdatePower();
                    break;
                } else {
                    mUpdaterAirWindLevelLeft();
                    break;
                }
            case R.id.tv_sp_rear /* 2131427933 */:
                this.pagenum = 1;
                findViewById(R.id.veiw_air_front).setVisibility(8);
                findViewById(R.id.veiw_air_rear).setVisibility(0);
                ((TextView) findViewById(R.id.tv_sp_front)).setTextColor(Color.parseColor("#ffffff"));
                ((TextView) findViewById(R.id.tv_sp_rear)).setTextColor(Color.parseColor("#d5a45e"));
                if (ConstAllAirDara.U_AIR_BACK_POWER != 255) {
                    mUpdatePower();
                    break;
                } else {
                    mUpdateBackWind();
                    break;
                }
            case R.id.air_sp_mode_change /* 2131428557 */:
            case R.id.air_sp_blow_changer /* 2131430395 */:
                data0 = ConstAllAirDara.C_AIR_MODE_CHANGER;
                break;
            case R.id.air_sp_temp_left_plus /* 2131430261 */:
                data0 = ConstAllAirDara.C_AIR_TEMP_LEFT_ADD;
                break;
            case R.id.air_sp_temp_left_munits /* 2131430265 */:
                data0 = ConstAllAirDara.C_AIR_TEMP_LEFT_SUB;
                break;
            case R.id.air_sp_temp_right_plus /* 2131430269 */:
                data0 = ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD;
                break;
            case R.id.air_sp_temp_right_munits /* 2131430273 */:
                data0 = ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB;
                break;
            case R.id.air_sp_acmax /* 2131430274 */:
                data0 = ConstAllAirDara.C_AIR_AC_MAX;
                break;
            case R.id.air_sp_ac /* 2131430275 */:
                data0 = ConstAllAirDara.C_AIR_AC;
                break;
            case R.id.air_sp_sync /* 2131430276 */:
                data0 = ConstAllAirDara.C_AIR_SYNC;
                break;
            case R.id.air_sp_front /* 2131430277 */:
                data0 = ConstAllAirDara.C_AIR_FRONT_DEFROST;
                break;
            case R.id.air_sp_rear /* 2131430278 */:
                data0 = ConstAllAirDara.C_AIR_REAR_DEFROST;
                break;
            case R.id.air_sp_auto /* 2131430279 */:
                data0 = ConstAllAirDara.C_AIR_AUTO;
                break;
            case R.id.air_sp_power /* 2131430280 */:
                if (this.pagenum == 1) {
                    data0 = ConstAllAirDara.C_REAR_OFF;
                    break;
                } else {
                    data0 = ConstAllAirDara.C_AIR_POWER;
                    break;
                }
            case R.id.air_sp_wind_minuts /* 2131430281 */:
                data0 = ConstAllAirDara.C_AIR_WIND_SUB;
                break;
            case R.id.air_sp_wind_plus /* 2131430283 */:
                data0 = ConstAllAirDara.C_AIR_WIND_ADD;
                break;
            case R.id.air_sp_cycle /* 2131430284 */:
                switch (DataCanbus.DATA[1000]) {
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
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            data0 = 35;
                            break;
                        } else {
                            data0 = 34;
                            break;
                        }
                    case FinalCanbus.CAR_455_OD_Zhongtai_E200 /* 786887 */:
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            data0 = 26;
                            break;
                        } else {
                            data0 = 25;
                            break;
                        }
                    default:
                        data0 = ConstAllAirDara.C_AIR_CYCLE;
                        break;
                }
            case R.id.air_sp_auto_right /* 2131430285 */:
                data0 = ConstAllAirDara.C_AIR_AUTO_RIGHT;
                break;
            case R.id.air_sp_seatheat_left /* 2131430287 */:
                data0 = ConstAllAirDara.C_AIR_LEFT_HEAT;
                break;
            case R.id.air_sp_seatwind_left /* 2131430288 */:
                data0 = ConstAllAirDara.C_AIR_LEFT_COLD;
                break;
            case R.id.air_sp_steer /* 2131430289 */:
                data0 = ConstAllAirDara.C_AIR_STEER;
                break;
            case R.id.air_sp_seatheat_right /* 2131430291 */:
                data0 = ConstAllAirDara.C_AIR_RIGHT_HEAT;
                break;
            case R.id.air_sp_seatwind_right /* 2131430292 */:
                data0 = ConstAllAirDara.C_AIR_RIGHT_COLD;
                break;
            case R.id.air_sp_temp_rearleft_plus /* 2131430293 */:
                data0 = ConstAllAirDara.C_REAR_LEFT_TEMP_UP;
                break;
            case R.id.air_sp_temp_rearright_plus /* 2131430302 */:
                data0 = ConstAllAirDara.C_REAR_RIGHT_TEMP_UP;
                break;
            case R.id.air_sp_rearlock_rear /* 2131430307 */:
                data0 = ConstAllAirDara.C_REAR_LOCK;
                break;
            case R.id.air_sp_ac_rear /* 2131430308 */:
                data0 = ConstAllAirDara.C_REAR_AC;
                break;
            case R.id.air_sp_sync_rear /* 2131430309 */:
                data0 = ConstAllAirDara.C_REAR_SYNC;
                break;
            case R.id.air_sp_rear_wind_minuts /* 2131430311 */:
                data0 = ConstAllAirDara.C_REAR_WIND_DOWN;
                break;
            case R.id.air_sp_rear_wind_plus /* 2131430313 */:
                data0 = ConstAllAirDara.C_REAR_WIND_UP;
                break;
            case R.id.air_sp_auto_rear /* 2131430314 */:
                data0 = ConstAllAirDara.C_REAR_AUTO;
                break;
            case R.id.air_sp_ptc /* 2131430319 */:
                data0 = ConstAllAirDara.C_AIR_PTC;
                break;
            case R.id.air_sp_em /* 2131430321 */:
                data0 = ConstAllAirDara.C_AIR_EM;
                break;
            case R.id.air_sp_fronthot /* 2131430325 */:
                data0 = ConstAllAirDara.C_AIR_FRONT_HOT;
                break;
            case R.id.air_sp_flowerblow /* 2131430327 */:
                data0 = ConstAllAirDara.C_AIR_FLOWER_BLOW;
                break;
            case R.id.air_sp_onlyfront_front /* 2131430329 */:
                data0 = ConstAllAirDara.C_AIR_FRONT_ONLY_F;
                break;
            case R.id.air_sp_airpark /* 2131430331 */:
                data0 = ConstAllAirDara.C_AIR_PARK;
                break;
            case R.id.air_sp_frontmax /* 2131430333 */:
                data0 = ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST;
                break;
            case R.id.air_sp_car_rear /* 2131430335 */:
                data0 = ConstAllAirDara.C_REAR_CTRL;
                break;
            case R.id.air_sp_ion /* 2131430338 */:
                data0 = ConstAllAirDara.C_AIR_ION;
                break;
            case R.id.air_sp_soft /* 2131430340 */:
                data0 = ConstAllAirDara.C_SOFT;
                break;
            case R.id.air_sp_fast /* 2131430342 */:
                data0 = ConstAllAirDara.C_FAST;
                break;
            case R.id.air_sp_normal /* 2131430344 */:
                data0 = ConstAllAirDara.C_NORMAL;
                break;
            case R.id.air_sp_clean /* 2131430346 */:
                data0 = ConstAllAirDara.C_CLEAN;
                break;
            case R.id.air_sp_eco /* 2131430348 */:
                data0 = ConstAllAirDara.C_AIR_ECO;
                break;
            case R.id.air_sp_blowtop /* 2131430350 */:
                data0 = ConstAllAirDara.C_AIR_BLOWTOP;
                break;
            case R.id.air_sp_aqs /* 2131430352 */:
                data0 = ConstAllAirDara.C_AIR_AQS;
                break;
            case R.id.air_sp_zone /* 2131430354 */:
                data0 = ConstAllAirDara.C_AIR_ZONE;
                break;
            case R.id.air_sp_dual /* 2131430357 */:
                data0 = ConstAllAirDara.C_AIR_DUAL;
                break;
            case R.id.air_sp_nanoe /* 2131430359 */:
                data0 = ConstAllAirDara.C_AIR_NANOE;
                break;
            case R.id.air_sp_swing /* 2131430361 */:
                data0 = ConstAllAirDara.C_AIR_SWING;
                break;
            case R.id.air_sp_rest /* 2131430363 */:
                data0 = ConstAllAirDara.C_AIR_REST;
                break;
            case R.id.air_sp_winlev /* 2131430365 */:
                data0 = ConstAllAirDara.C_AIR_WINLEV;
                break;
            case R.id.air_sp_heat /* 2131430368 */:
                data0 = ConstAllAirDara.C_AIR_HEAT;
                break;
            case R.id.air_sp_blow_body_foot /* 2131430379 */:
                data0 = ConstAllAirDara.C_AIR_MODE_BODYFOOT;
                break;
            case R.id.air_sp_blow_foot /* 2131430381 */:
                data0 = ConstAllAirDara.C_AIR_MODE_FOOT;
                break;
            case R.id.air_sp_blow_body /* 2131430383 */:
                data0 = ConstAllAirDara.C_AIR_MODE_BODY;
                break;
            case R.id.air_sp_blow_foot_win /* 2131430385 */:
                data0 = ConstAllAirDara.C_AIR_MODE_UPFOOT;
                break;
            case R.id.air_sp_blow_win /* 2131430387 */:
                data0 = ConstAllAirDara.C_AIR_MODE_UP;
                break;
            case R.id.air_sp_blow_foot_right /* 2131430389 */:
                data0 = ConstAllAirDara.C_AIR_MODE_FOOT_RIGHT;
                break;
            case R.id.air_sp_blow_body_right /* 2131430391 */:
                data0 = ConstAllAirDara.C_AIR_MODE_BODY_RIGHT;
                break;
            case R.id.air_sp_blow_win_right /* 2131430393 */:
                data0 = ConstAllAirDara.C_AIR_MODE_UP_RIGHT;
                break;
            case R.id.air_sp_blow_mode_minus /* 2131430397 */:
                data0 = ConstAllAirDara.C_AIR_MODE_SUB;
                break;
            case R.id.air_sp_blow_changer_center /* 2131430399 */:
                data0 = ConstAllAirDara.C_AIR_MODE_CENTER;
                break;
            case R.id.air_sp_blow_mode_plus /* 2131430401 */:
                data0 = ConstAllAirDara.C_AIR_MODE_ADD;
                break;
            case R.id.air_sp_blow_changer_right /* 2131430403 */:
                data0 = ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT;
                break;
            case R.id.air_sp_seatwind_left_rear /* 2131430411 */:
                data0 = ConstAllAirDara.C_AIR_LEFT_COLD_REAR;
                break;
            case R.id.air_sp_seatheat_left_rear /* 2131430413 */:
                data0 = ConstAllAirDara.C_AIR_LEFT_HEAT_REAR;
                break;
            case R.id.air_sp_rear_manual /* 2131430416 */:
                data0 = ConstAllAirDara.C_AIR_REAR_MANUAL;
                break;
            case R.id.air_sp_rear_cool /* 2131430418 */:
                data0 = ConstAllAirDara.C_REAR_COOL;
                break;
            case R.id.air_sp_onlyfront /* 2131430420 */:
                data0 = ConstAllAirDara.C_AIR_FRONT_ONLY;
                break;
            case R.id.air_sp_auto_rear_right /* 2131430425 */:
                data0 = ConstAllAirDara.C_REAR_AUTO_RIGHT;
                break;
            case R.id.air_sp_seatheat_right_rear /* 2131430427 */:
                data0 = ConstAllAirDara.C_AIR_RIGHT_HEAT_REAR;
                break;
            case R.id.air_sp_seatwind_right_rear /* 2131430429 */:
                data0 = ConstAllAirDara.C_AIR_RIGHT_COLD_REAR;
                break;
            case R.id.air_sp_temp_rearleft_minus /* 2131430436 */:
                data0 = ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN;
                break;
            case R.id.air_sp_rear_blow_changer /* 2131430446 */:
                data0 = ConstAllAirDara.C_REAR_MODE;
                break;
            case R.id.air_sp_rear_blow_body_foot /* 2131430448 */:
                data0 = ConstAllAirDara.C_REAR_MODE_BODY_FOOT;
                break;
            case R.id.air_sp_rear_blow_foot /* 2131430450 */:
                data0 = ConstAllAirDara.C_REAR_MODE_FOOT;
                break;
            case R.id.air_sp_rear_blow_body /* 2131430452 */:
                data0 = ConstAllAirDara.C_REAR_MODE_BODY;
                break;
            case R.id.air_sp_rear_blow_changer_right /* 2131430454 */:
                data0 = ConstAllAirDara.C_REAR_MODE_RIGHT;
                break;
            case R.id.air_sp_temp_rearright_minus /* 2131430461 */:
                data0 = ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN;
                break;
        }
        if (event.getAction() == 0) {
            if (data0 != 255) {
                sendCmd(data0, 1);
            }
        } else if (event.getAction() == 1 && data0 != 255) {
            sendCmd(data0, 0);
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
    }

    
    public void mUpdateAirHeat() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_HEAT];
        findViewById(R.id.air_sp_heat).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_heat_n : R.drawable.ic_hp_heat_p);
    }

    
    public void mUpdateAirPTC() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_PTC];
        findViewById(R.id.air_sp_ptc).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_ptc_n : R.drawable.ic_hp_ptc_p);
    }

    
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

    
    public void mUpdateSteerHot() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_STEER];
        findViewById(R.id.air_sp_steer).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_steerhot_n : R.drawable.ic_hp_steerhot_p);
    }

    
    public void mUpdateClean() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_CLEAN];
        findViewById(R.id.air_sp_clean).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_clean_n : R.drawable.ic_hp_clean_p);
    }

    
    public void mUpdateIon() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_ION];
        findViewById(R.id.air_sp_ion).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_ion_n : R.drawable.ic_hp_ion_p);
    }

    
    public void mUpdateBlowTop() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOWTOP];
        findViewById(R.id.air_sp_blowtop).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_blowtop_n : R.drawable.ic_hp_blowtop_p);
    }

    
    public void mUpdateAcMax() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC_MAX];
        findViewById(R.id.air_sp_acmax).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_acmax_n : R.drawable.ic_hp_acmax_p);
    }

    
    public void mUpdateAirNormal() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_NORMAL];
        findViewById(R.id.air_sp_normal).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_normal_n : R.drawable.ic_hp_normal_p);
    }

    
    public void mUpdateAirFast() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_FAST];
        findViewById(R.id.air_sp_fast).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_fast_n : R.drawable.ic_hp_fast_p);
    }

    
    public void mUpdateAirSoft() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SOFT];
        findViewById(R.id.air_sp_soft).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_soft_n : R.drawable.ic_hp_soft_p);
    }

    
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
                case FinalCanbus.CAR_RZC_Explorer /* 590158 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                case FinalCanbus.CAR_452_XC_Ford_Escape_13_17 /* 6422980 */:
                case FinalCanbus.CAR_452_XC_Ford_edge_11_13 /* 6488516 */:
                case FinalCanbus.CAR_452_XC_Ford_Raptor_F150_09_14 /* 6554052 */:
                case FinalCanbus.CAR_452_XC_Ford_edge_15_17 /* 6619588 */:
                case FinalCanbus.CAR_443_WC2_Ford_EDGE_11 /* 6685115 */:
                case FinalCanbus.CAR_452_XC_Ford_Mondeo_13_18 /* 6685124 */:
                case FinalCanbus.CAR_443_WC2_Ford_EDGE_11_CD /* 6750651 */:
                case FinalCanbus.CAR_439_HC_Ford_Explorer /* 15335863 */:
                    temp *= 10;
                    findViewById(R.id.air_sp_tempvalue_rearleft).setVisibility(8);
                    findViewById(R.id.air_sp_tempunit_rearleft).setVisibility(8);
                    findViewById(R.id.air_sp_tempstate_rearleft).setVisibility(0);
                    mUpdateTempValue(R.id.air_sp_tempstate_rearleft, (temp % 100) / 10, false);
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
                        break;
                    } else {
                        temp = (temp * 5) + 175;
                        break;
                    }
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
                case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD /* 8913349 */:
                case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD_H /* 8978885 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 9) + 635;
                        break;
                    } else {
                        temp = (temp * 5) + 175;
                        break;
                    }
                case FinalCanbus.CAR_DJ_XC_TOYOTA_LEXUS /* 1049005 */:
                case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_14_TX /* 2425286 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 10) + 310;
                        break;
                    } else {
                        temp *= 5;
                        break;
                    }
                case FinalCanbus.CAR_RZC_Dodge_JCUV /* 1114485 */:
                case FinalCanbus.CAR_RZC_Dodge_JCUV_H /* 2359669 */:
                    temp = ((temp - 12) * 5) + 140;
                    break;
                case FinalCanbus.CAR_RZC_19RongWei_RX8 /* 1310993 */:
                case FinalCanbus.CAR_RZC_18RongWei_RX8 /* 1638673 */:
                    temp = (temp * 10) + 150;
                    break;
                case FinalCanbus.CAR_455_LZ_GMC_Sierra_19_RScreen /* 1507783 */:
                case FinalCanbus.CAR_455_LZ_Chevrolet_Silverado_19_RScreen /* 1573319 */:
                case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
                case FinalCanbus.CAR_454_LZ_Chevrolet_Silverado_19_Screen /* 11993542 */:
                    if (temp >= 30 && temp <= 64) {
                        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                            temp = (temp * 9) + 320;
                            break;
                        } else {
                            temp *= 5;
                            break;
                        }
                    } else if (temp >= 1 && temp <= 16) {
                        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                            temp = ((temp + 15) * 18) + 320;
                            break;
                        } else {
                            temp = (temp * 10) + 150;
                            break;
                        }
                    }
                    break;
                case FinalCanbus.CAR_455_TD_INFINIT_ESQ /* 1704391 */:
                case FinalCanbus.CAR_455_TD_INFINIT_G /* 1769927 */:
                case FinalCanbus.CAR_455_TD_INFINIT_QX50 /* 1835463 */:
                case FinalCanbus.CAR_455_TD_INFINIT_06FX /* 1900999 */:
                case FinalCanbus.CAR_455_TD_INFINIT_08FX /* 1966535 */:
                case FinalCanbus.CAR_455_TD_INFINIT_14QX70 /* 2032071 */:
                case FinalCanbus.CAR_455_TD_INFINIT_12FX /* 2097607 */:
                case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_L /* 13763014 */:
                case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_H /* 13828550 */:
                    temp *= 5;
                    break;
                case FinalCanbus.CAR_RZC3_XianDai_19Palisade /* 2752959 */:
                case FinalCanbus.CAR_RZC3_XianDai_19Palisade_H /* 2818495 */:
                case FinalCanbus.CAR_RZC3_XianDai_20CARNIVAL /* 2884031 */:
                case FinalCanbus.CAR_RZC3_XianDai_20CARNIVAL_H /* 2949567 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_23Staria /* 3539391 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_23Staria_H /* 3604927 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp *= 10;
                        break;
                    } else {
                        temp = (temp * 5) + 170;
                        break;
                    }
                case FinalCanbus.CAR_452_DJ_Dodge_JCUV /* 4981188 */:
                    temp = (temp * 10) + 130;
                    break;
            }
            mUpdateTempValue(R.id.air_sp_temp_rearleft1, temp / 100, false);
            mUpdateTempValue(R.id.air_sp_temp_rearleft2, (temp % 100) / 10, false);
            mUpdateTempValue(R.id.air_sp_temp_rearleft3, temp % 10, true);
            mUpdateTempUNIT();
        }
    }

    
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
                case FinalCanbus.CAR_RZC_Explorer /* 590158 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                case FinalCanbus.CAR_452_XC_Ford_Escape_13_17 /* 6422980 */:
                case FinalCanbus.CAR_452_XC_Ford_edge_11_13 /* 6488516 */:
                case FinalCanbus.CAR_452_XC_Ford_Raptor_F150_09_14 /* 6554052 */:
                case FinalCanbus.CAR_452_XC_Ford_edge_15_17 /* 6619588 */:
                case FinalCanbus.CAR_443_WC2_Ford_EDGE_11 /* 6685115 */:
                case FinalCanbus.CAR_452_XC_Ford_Mondeo_13_18 /* 6685124 */:
                case FinalCanbus.CAR_443_WC2_Ford_EDGE_11_CD /* 6750651 */:
                case FinalCanbus.CAR_439_HC_Ford_Explorer /* 15335863 */:
                    temp *= 10;
                    findViewById(R.id.air_sp_tempvalue_rearright).setVisibility(8);
                    findViewById(R.id.air_sp_tempunit_rearright).setVisibility(8);
                    findViewById(R.id.air_sp_tempstate_rearright).setVisibility(0);
                    mUpdateTempValue(R.id.air_sp_tempstate_rearright, (temp % 100) / 10, false);
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
                        break;
                    } else {
                        temp = (temp * 5) + 175;
                        break;
                    }
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
                case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD /* 8913349 */:
                case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD_H /* 8978885 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 9) + 635;
                        break;
                    } else {
                        temp = (temp * 5) + 175;
                        break;
                    }
                case FinalCanbus.CAR_DJ_XC_TOYOTA_LEXUS /* 1049005 */:
                case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_14_TX /* 2425286 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 10) + 310;
                        break;
                    } else {
                        temp *= 5;
                        break;
                    }
                case FinalCanbus.CAR_RZC_Dodge_JCUV /* 1114485 */:
                case FinalCanbus.CAR_RZC_Dodge_JCUV_H /* 2359669 */:
                    temp = ((temp - 12) * 5) + 140;
                    break;
                case FinalCanbus.CAR_RZC_19RongWei_RX8 /* 1310993 */:
                case FinalCanbus.CAR_RZC_18RongWei_RX8 /* 1638673 */:
                    temp = (temp * 10) + 150;
                    break;
                case FinalCanbus.CAR_455_LZ_GMC_Sierra_19_RScreen /* 1507783 */:
                case FinalCanbus.CAR_455_LZ_Chevrolet_Silverado_19_RScreen /* 1573319 */:
                case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
                case FinalCanbus.CAR_454_LZ_Chevrolet_Silverado_19_Screen /* 11993542 */:
                    if (temp >= 30 && temp <= 64) {
                        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                            temp = (temp * 9) + 320;
                            break;
                        } else {
                            temp *= 5;
                            break;
                        }
                    } else if (temp >= 1 && temp <= 16) {
                        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                            temp = ((temp + 15) * 18) + 320;
                            break;
                        } else {
                            temp = (temp * 10) + 150;
                            break;
                        }
                    }
                    break;
                case FinalCanbus.CAR_455_TD_INFINIT_ESQ /* 1704391 */:
                case FinalCanbus.CAR_455_TD_INFINIT_G /* 1769927 */:
                case FinalCanbus.CAR_455_TD_INFINIT_QX50 /* 1835463 */:
                case FinalCanbus.CAR_455_TD_INFINIT_06FX /* 1900999 */:
                case FinalCanbus.CAR_455_TD_INFINIT_08FX /* 1966535 */:
                case FinalCanbus.CAR_455_TD_INFINIT_14QX70 /* 2032071 */:
                case FinalCanbus.CAR_455_TD_INFINIT_12FX /* 2097607 */:
                case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_L /* 13763014 */:
                case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_H /* 13828550 */:
                    temp *= 5;
                    break;
                case FinalCanbus.CAR_RZC3_XianDai_19Palisade /* 2752959 */:
                case FinalCanbus.CAR_RZC3_XianDai_19Palisade_H /* 2818495 */:
                case FinalCanbus.CAR_RZC3_XianDai_20CARNIVAL /* 2884031 */:
                case FinalCanbus.CAR_RZC3_XianDai_20CARNIVAL_H /* 2949567 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_23Staria /* 3539391 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_23Staria_H /* 3604927 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp *= 10;
                        break;
                    } else {
                        temp = (temp * 5) + 170;
                        break;
                    }
                case FinalCanbus.CAR_452_DJ_Dodge_JCUV /* 4981188 */:
                    temp = (temp * 10) + 130;
                    break;
            }
            mUpdateTempValue(R.id.air_sp_temp_rearright1, temp / 100, false);
            mUpdateTempValue(R.id.air_sp_temp_rearright2, (temp % 100) / 10, false);
            mUpdateTempValue(R.id.air_sp_temp_rearright3, temp % 10, true);
            mUpdateTempUNIT();
        }
    }

    
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
            findViewById(R.id.air_sp_tempvalue_left).setVisibility(0);
            findViewById(R.id.air_sp_tempunit_left).setVisibility(0);
            findViewById(R.id.air_sp_tempstate_left).setVisibility(8);
            switch (DataCanbus.DATA[1000]) {
                case 36:
                case 254:
                case 308:
                case 345:
                case 429:
                case FinalCanbus.CAR_WC2_ShuPingJW /* 65881 */:
                case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_12Crown_AMP /* 65965 */:
                case FinalCanbus.CAR_WC2_ShuPingKeLuZi /* 131417 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_12Crown_AMP_H /* 131501 */:
                case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao /* 196953 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_13Crown_AMP /* 197037 */:
                case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS /* 262489 */:
                case FinalCanbus.CAR_CYT_YaGe7_38400 /* 262561 */:
                case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS_S /* 328025 */:
                case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
                case FinalCanbus.CAR_RCW_BYD_10_11F6 /* 328097 */:
                case FinalCanbus.CAR_RCW_BYD_10_13G6 /* 393633 */:
                case FinalCanbus.CAR_WC2_GM_GL6 /* 458788 */:
                case FinalCanbus.CAR_WC2_ShuPing10JunYue /* 459097 */:
                case FinalCanbus.CAR_RCW_YaGe7_38400 /* 459169 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_14Prodo_H_ShuPing /* 459181 */:
                case FinalCanbus.CAR_WC2_GM_WLD /* 524324 */:
                case FinalCanbus.CAR_WC2_ShuPingKeLuZi_Auto /* 524633 */:
                case FinalCanbus.CAR_WC_YaGe7_38400 /* 524705 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_14Prodo_ShuPing /* 524717 */:
                case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao_L /* 590169 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown /* 590253 */:
                case FinalCanbus.CAR_WC2_GM_EXCELLE_19 /* 655396 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown /* 655789 */:
                case FinalCanbus.CAR_WC2_GM_EXCELLE_18 /* 720932 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown_L /* 721325 */:
                case FinalCanbus.CAR_WC2_GM_GL8_10_13 /* 786468 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown_L /* 786861 */:
                case FinalCanbus.CAR_WC2_GM_GL8_14_16 /* 852004 */:
                case FinalCanbus.CAR_DAOJUN_OD_ATS /* 852316 */:
                case FinalCanbus.CAR_DJ_XC_Nissan_Tianlai_03_07 /* 852397 */:
                case FinalCanbus.CAR_WC2_GM_Encore_12_15 /* 917540 */:
                case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_10_13PRADO /* 917933 */:
                case FinalCanbus.CAR_WC2_GM_Encore_16_19 /* 983076 */:
                case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_08_15LAND_CRUISER /* 983469 */:
                case FinalCanbus.CAR_WC2_GM_Regal_09_13 /* 1048612 */:
                case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_LEXUS /* 1049005 */:
                case FinalCanbus.CAR_WC2_GM_Lacrosse_10_13 /* 1114148 */:
                case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_HIGHLANDER /* 1114541 */:
                case FinalCanbus.CAR_WC2_GM_Lacrosse_18 /* 1179684 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_HIGHLANDER_H /* 1180077 */:
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
                case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport /* 10420678 */:
                case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport_H /* 10486214 */:
                case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport_Top /* 16056774 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 320;
                        break;
                    } else {
                        temp *= 5;
                        break;
                    }
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
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 10) + 590;
                        break;
                    } else {
                        temp = (temp * 5) + 155;
                        break;
                    }
                case 271:
                case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6 /* 131379 */:
                case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6_H /* 196915 */:
                case FinalCanbus.CAR_RZC_20BaoJunRS3 /* 459062 */:
                case FinalCanbus.CAR_OD_RZC_20BaoJunRS3 /* 590134 */:
                case FinalCanbus.CAR_OD_RZC_Wuling_Xingchen /* 655670 */:
                case FinalCanbus.CAR_RZC_BenTeng_19B50_HAND /* 655773 */:
                case FinalCanbus.CAR_RZC_Wuling_Xingchen /* 721206 */:
                case FinalCanbus.CAR_BNR_NISSAN_14QiJun_H /* 721220 */:
                case FinalCanbus.CAR_RZC_BenTeng_19B50_AUTO /* 721309 */:
                case FinalCanbus.CAR_RZC_Wuling_Kaijie /* 786742 */:
                case FinalCanbus.CAR_BNR_NISSAN_14QiJun_L /* 786756 */:
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
                case FinalCanbus.CAR_BNR_NISSAN_11QiDa_L /* 1311044 */:
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
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
                case FinalCanbus.CAR_RZC_Turkey_23MEGANE4_M /* 5046674 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
                case FinalCanbus.CAR_RZC_Turkey_23MEGANE4_H /* 5112210 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
                case FinalCanbus.CAR_RZC_Turkey_22TALISMAN_L /* 5177746 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
                case FinalCanbus.CAR_RZC_Turkey_22TALISMAN_M /* 5243282 */:
                case FinalCanbus.CAR_RZC_Turkey_22TALISMAN_H /* 5308818 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_DUSTER_L /* 5374354 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_DUSTER_M /* 5439890 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_DUSTER_H /* 5505426 */:
                case FinalCanbus.CAR_RZC_Turkey_22EXPRESS_L /* 5570962 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                case FinalCanbus.CAR_RZC_Turkey_22EXPRESS_M /* 5636498 */:
                case FinalCanbus.CAR_RZC_Turkey_22EXPRESS_H /* 5702034 */:
                case FinalCanbus.CAR_RZC_Russian_20ARKANA_L /* 5767570 */:
                case FinalCanbus.CAR_RZC_Russian_20ARKANA_M /* 5833106 */:
                case FinalCanbus.CAR_RZC_Russian_20ARKANA_H /* 5898642 */:
                case FinalCanbus.CAR_452_LZ_TATA_ALL /* 5898692 */:
                case FinalCanbus.CAR_RZC_Turkey_22KADJAR_M /* 5964178 */:
                case FinalCanbus.CAR_RZC_CLIO5_Turkey_L_ATUO /* 6029714 */:
                case FinalCanbus.CAR_453_RZC_LandRover_Discovery_19 /* 6160837 */:
                case FinalCanbus.CAR_RZC_Renault_SM6_18 /* 6226322 */:
                case FinalCanbus.CAR_RZC_Renault_SCENIC_16 /* 6291858 */:
                case FinalCanbus.CAR_RZC_Renault_SM6_18_M /* 6357394 */:
                case FinalCanbus.CAR_RZC_Renault_SCENIC_16_M /* 6422930 */:
                case FinalCanbus.CAR_RZC_Renault_SM6_18_H /* 6488466 */:
                case FinalCanbus.CAR_RZC_Renault_SCENIC_16_H /* 6554002 */:
                case FinalCanbus.CAR_443_WC2_Ford_EDGE_11 /* 6685115 */:
                case FinalCanbus.CAR_RZC_Renault_Dokker_18 /* 6750610 */:
                case FinalCanbus.CAR_443_WC2_Ford_EDGE_11_CD /* 6750651 */:
                case FinalCanbus.CAR_RZC_Renault_Dokker_18_H /* 6816146 */:
                case FinalCanbus.CAR_452_RZC_Subaru /* 7209412 */:
                case FinalCanbus.CAR_454_RZC_Racing_EC75_23 /* 7340486 */:
                case FinalCanbus.CAR_453_LZ_ALFA_ROMEO /* 7930309 */:
                case FinalCanbus.CAR_454_RZC_Suburu_OUTBACK_18 /* 8323526 */:
                case FinalCanbus.CAR_454_RZC_LandRover_Discovery_04 /* 9765318 */:
                case FinalCanbus.CAR_452_KYC_Zhonghua_All /* 10617284 */:
                case FinalCanbus.CAR_452_KYC_Zhonghua_All_H /* 10682820 */:
                case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7 /* 10748356 */:
                case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7_H /* 10813892 */:
                case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_L /* 13763014 */:
                case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_H /* 13828550 */:
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
                    temp *= 5;
                    break;
                case 274:
                case FinalCanbus.CAR_DJ_XP1_ACCORD7_H /* 65810 */:
                case FinalCanbus.CAR_439_OuDi_Z560 /* 983479 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 320;
                        break;
                    } else {
                        temp *= 10;
                        break;
                    }
                case 276:
                case FinalCanbus.CAR_OD_Jiangxi_Wushiling_Mux /* 393638 */:
                case FinalCanbus.CAR_OD_Jiangxi_Lingtuo /* 459174 */:
                    temp = (temp * 10) + 170;
                    break;
                case 373:
                case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_H /* 65909 */:
                case FinalCanbus.CAR_RZC_XP1_GrdCherokee /* 196981 */:
                case FinalCanbus.CAR_RZC_XP1_GrdCherokee_H /* 459125 */:
                case FinalCanbus.CAR_RZC_Dodge_JCUV /* 1114485 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM /* 1311093 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_H /* 1376629 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_M /* 1835381 */:
                case FinalCanbus.CAR_RZC_Dodge_JCUV_H /* 2359669 */:
                case FinalCanbus.CAR_454_OD_Qichen_D60_EV /* 9961926 */:
                    temp *= 10;
                    break;
                case FinalCanbus.CAR_RZC_XP1_BeiQiM50F /* 65932 */:
                    temp *= 10;
                    findViewById(R.id.air_sp_tempvalue_left).setVisibility(8);
                    findViewById(R.id.air_sp_tempunit_left).setVisibility(8);
                    findViewById(R.id.air_sp_tempstate_left).setVisibility(0);
                    mUpdateTempValue(R.id.air_sp_tempstate_left, (temp % 100) / 10, false);
                    break;
                case FinalCanbus.CAR_RZC_XP1_16HAIMAMV70 /* 131309 */:
                case FinalCanbus.CAR_RZC_XP1_HAIMA_F5 /* 262381 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        temp *= 10;
                        break;
                    } else {
                        temp *= 5;
                        break;
                    }
                case FinalCanbus.CAR_RZC_XP1_ZiYouXia /* 131445 */:
                case FinalCanbus.CAR_RZC_17ZhiNanZhe /* 262517 */:
                case FinalCanbus.CAR_RZC_17ZhiNanZhe_H /* 328053 */:
                case FinalCanbus.CAR_RZC_18MuMaRen /* 393589 */:
                case FinalCanbus.CAR_RZC_18MuMaRen_H /* 524661 */:
                case FinalCanbus.CAR_RZC_19Tiaozhanzhe /* 590197 */:
                case FinalCanbus.CAR_RZC_18Zhihuiguan /* 655733 */:
                case FinalCanbus.CAR_RZC_19Tiaozhanzhe_H /* 721269 */:
                case FinalCanbus.CAR_RZC_18Zhihuiguan_H /* 786805 */:
                case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19 /* 852341 */:
                case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19_H /* 917877 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_HY /* 1900917 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_HY_M /* 1966453 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_HY_H /* 2031989 */:
                case FinalCanbus.CAR_RZC_XP1_ZiYouXia_H /* 2163061 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 9) + 599;
                        break;
                    } else {
                        temp = (temp * 5) + 155;
                        break;
                    }
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
                case FinalCanbus.CAR_439_RZC_Nissan_19Qida /* 8585655 */:
                case FinalCanbus.CAR_439_RZC_Nissan_19Qida_H /* 8651191 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 10) + 440;
                        break;
                    } else {
                        temp = (temp * 5) + 80;
                        break;
                    }
                case FinalCanbus.CAR_RZC_HanTeng_H /* 196863 */:
                case FinalCanbus.CAR_Oudi_HanTeng_X5 /* 393471 */:
                case FinalCanbus.CAR_Oudi_XiaoYao /* 459007 */:
                case FinalCanbus.CAR_RZC_HanTeng_X5 /* 524543 */:
                    if (temp < 16) {
                        temp = (temp * 10) + 160;
                        break;
                    } else {
                        temp *= 5;
                        break;
                    }
                case FinalCanbus.CAR_WC2_20BaoJun530_Auto /* 393462 */:
                case FinalCanbus.CAR_WC2_20BaoJun530_Hand /* 458998 */:
                    temp = (temp * 20) + 160;
                    break;
                case FinalCanbus.CAR_RZC_OD_DongNanDX5 /* 590153 */:
                case FinalCanbus.CAR_439_DJ_LEXUS_ES /* 1245623 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_22Teana_Top /* 1572944 */:
                case FinalCanbus.CAR_455_OD_Dongfeng_Racing_EC75_23H /* 2294215 */:
                case FinalCanbus.CAR_439_DJ_LEXUS_ES_H /* 3801527 */:
                case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_Auto /* 5833156 */:
                case FinalCanbus.CAR_452_OD_HZ_Nezha /* 7602628 */:
                case FinalCanbus.CAR_BNR_02_09Toyato_Prado /* 7668151 */:
                case FinalCanbus.CAR_BNR_02_09Toyato_Prado_H /* 7733687 */:
                case FinalCanbus.CAR_454_OD_Dongfeng_Racing_EC75_23 /* 8454598 */:
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
                case FinalCanbus.CAR_RZC_Mingjue_20ZS_H /* 1442065 */:
                case FinalCanbus.CAR_RZC_19Mingjue_MG6 /* 1507601 */:
                case FinalCanbus.CAR_RZC_18RongWei_RX8 /* 1638673 */:
                case FinalCanbus.CAR_RZC_20RongWei_RX5 /* 1704209 */:
                case FinalCanbus.CAR_RZC_MingJue_MG5_21 /* 1835281 */:
                case FinalCanbus.CAR_RZC_21RongWei_I5 /* 1900817 */:
                case FinalCanbus.CAR_RZC_21RongWei_I5_H /* 1966353 */:
                case FinalCanbus.CAR_RZC_MingJue_MG5_21_L /* 2031889 */:
                case FinalCanbus.CAR_CZH_RZC_19Mingjue_MG6 /* 2097425 */:
                case FinalCanbus.CAR_454_OD_Xinte_DEV1_H /* 7274950 */:
                    temp *= 10;
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
                case FinalCanbus.CAR_454_OD_Dongfeng_Nami01 /* 10617286 */:
                case FinalCanbus.CAR_454_OD_ChangAn_Raeton /* 14352838 */:
                case FinalCanbus.CAR_454_OD_ChangAn_Raeton_H /* 14418374 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 635;
                        break;
                    } else {
                        temp = (temp * 5) + 175;
                        break;
                    }
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
                case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD /* 8913349 */:
                case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD_H /* 8978885 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 9) + 635;
                        break;
                    } else {
                        temp = (temp * 5) + 175;
                        break;
                    }
                case FinalCanbus.CAR_455_LZ_GMC_Sierra_19_RScreen /* 1507783 */:
                case FinalCanbus.CAR_455_LZ_Chevrolet_Silverado_19_RScreen /* 1573319 */:
                case FinalCanbus.CAR_453_LZ_GM_Camaro_17 /* 2163141 */:
                case FinalCanbus.CAR_453_LZ_GM_GMC_TERRAIN_17 /* 2228677 */:
                case FinalCanbus.CAR_453_LZ_GM_Equinox_17 /* 2294213 */:
                case FinalCanbus.CAR_454_LZ_GM_Camaro_17_Auto /* 6947270 */:
                case FinalCanbus.CAR_454_LZ_GM_Equinox_17_Auto /* 7012806 */:
                case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
                case FinalCanbus.CAR_454_LZ_Chevrolet_Silverado_19_Screen /* 11993542 */:
                    if (temp >= 30 && temp <= 64) {
                        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                            temp = (temp * 9) + 320;
                            break;
                        } else {
                            temp *= 5;
                            break;
                        }
                    } else if (temp >= 1 && temp <= 16) {
                        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                            temp = ((temp + 15) * 18) + 320;
                            break;
                        } else {
                            temp = (temp * 10) + 150;
                            break;
                        }
                    }
                    break;
                case FinalCanbus.CAR_452_DJ_Dodge_JCUV /* 4981188 */:
                    temp = (temp * 10) + 130;
                    break;
                case FinalCanbus.CAR_453_LZ_NISSAN_patrol /* 5308869 */:
                case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX60 /* 5374405 */:
                case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX80 /* 5439941 */:
                case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX56 /* 5505477 */:
                case FinalCanbus.CAR_439_LZ_INFINIT_FX35 /* 12714423 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 10) + 590;
                        break;
                    } else {
                        temp = (temp * 5) + 175;
                        break;
                    }
                case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9 /* 5702084 */:
                case FinalCanbus.CAR_454_RZC_Shanqi_DelongG2 /* 10027462 */:
                case FinalCanbus.CAR_439_DJ_Rongwei_i5 /* 13959607 */:
                case FinalCanbus.CAR_439_DJ_Rongwei_i5_H /* 14025143 */:
                    temp = (temp * 10) + 150;
                    break;
                case FinalCanbus.CAR_452_XC_Ford_Escape_13_17 /* 6422980 */:
                case FinalCanbus.CAR_452_XC_Ford_edge_11_13 /* 6488516 */:
                case FinalCanbus.CAR_452_XC_Ford_Raptor_F150_09_14 /* 6554052 */:
                case FinalCanbus.CAR_452_XC_Ford_edge_15_17 /* 6619588 */:
                case FinalCanbus.CAR_452_XC_Ford_Mondeo_13_18 /* 6685124 */:
                case FinalCanbus.CAR_439_HC_Ford_Explorer /* 15335863 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp *= 10;
                        break;
                    } else {
                        temp *= 5;
                        break;
                    }
                case FinalCanbus.CAR_439_HC_Ruijie /* 6816183 */:
                case FinalCanbus.CAR_439_HC_Ruijie_H /* 6881719 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        temp = ((temp - 12) * 5) + 155;
                        break;
                    } else {
                        temp = ((temp - 12) * 10) + 600;
                        break;
                    }
                case FinalCanbus.CAR_RZC_HavalH6Couple_BLUE_TOP /* 7078327 */:
                case FinalCanbus.CAR_RZC_HavalH6Couple_RED_TOP /* 7143863 */:
                case FinalCanbus.CAR_RZC_XP1_HavalH6Couple_19 /* 7602615 */:
                case FinalCanbus.CAR_439_RZC_Haval_18_19H6 /* 11272631 */:
                    temp = ((temp - 116) * 5) + 180;
                    if (temp < 0) {
                        temp = 0;
                        break;
                    }
                case FinalCanbus.CAR_453_LZ_Jili_Boyue_18 /* 8782277 */:
                case FinalCanbus.CAR_453_LZ_Jili_Boyue_18_H /* 8847813 */:
                    if (temp >= 32 && temp <= 34) {
                        temp = ((temp - 32) * 5) + 160;
                        break;
                    } else {
                        temp = (temp * 5) + 170;
                        break;
                    }
                case FinalCanbus.CAR_454_OD_Yutong_Qingka /* 11338182 */:
                    temp = (temp * 10) + 160;
                    break;
                case FinalCanbus.CAR_454_KYC_Ford_Mustang_07_H /* 13631942 */:
                case FinalCanbus.CAR_454_KYC_Ford_Mustang_07_L /* 13697478 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        temp = (temp * 10) + 310;
                        break;
                    } else {
                        temp *= 5;
                        break;
                    }
                case FinalCanbus.CAR_452_OD_ChangCheng_Fengjun5 /* 13763012 */:
                    temp = ((temp - 116) * 5) + 160;
                    if (temp < 0) {
                        temp = 0;
                        break;
                    }
            }
            mUpdateTempValue(R.id.air_sp_temp_left1, temp / 100, false);
            mUpdateTempValue(R.id.air_sp_temp_left2, (temp % 100) / 10, false);
            mUpdateTempValue(R.id.air_sp_temp_left3, temp % 10, true);
            mUpdateTempUNIT();
        }
    }

    
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
            findViewById(R.id.air_sp_tempvalue_right).setVisibility(0);
            findViewById(R.id.air_sp_tempunit_right).setVisibility(0);
            findViewById(R.id.air_sp_tempstate_right).setVisibility(8);
            switch (DataCanbus.DATA[1000]) {
                case 36:
                case 254:
                case 308:
                case 345:
                case 429:
                case FinalCanbus.CAR_WC2_ShuPingJW /* 65881 */:
                case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_12Crown_AMP /* 65965 */:
                case FinalCanbus.CAR_WC2_ShuPingKeLuZi /* 131417 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_12Crown_AMP_H /* 131501 */:
                case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao /* 196953 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_13Crown_AMP /* 197037 */:
                case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS /* 262489 */:
                case FinalCanbus.CAR_CYT_YaGe7_38400 /* 262561 */:
                case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS_S /* 328025 */:
                case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
                case FinalCanbus.CAR_RCW_BYD_10_11F6 /* 328097 */:
                case FinalCanbus.CAR_RCW_BYD_10_13G6 /* 393633 */:
                case FinalCanbus.CAR_WC2_GM_GL6 /* 458788 */:
                case FinalCanbus.CAR_WC2_ShuPing10JunYue /* 459097 */:
                case FinalCanbus.CAR_RCW_YaGe7_38400 /* 459169 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_14Prodo_H_ShuPing /* 459181 */:
                case FinalCanbus.CAR_WC2_GM_WLD /* 524324 */:
                case FinalCanbus.CAR_WC2_ShuPingKeLuZi_Auto /* 524633 */:
                case FinalCanbus.CAR_WC_YaGe7_38400 /* 524705 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_14Prodo_ShuPing /* 524717 */:
                case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao_L /* 590169 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown /* 590253 */:
                case FinalCanbus.CAR_WC2_GM_EXCELLE_19 /* 655396 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown /* 655789 */:
                case FinalCanbus.CAR_WC2_GM_EXCELLE_18 /* 720932 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown_L /* 721325 */:
                case FinalCanbus.CAR_WC2_GM_GL8_10_13 /* 786468 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown_L /* 786861 */:
                case FinalCanbus.CAR_WC2_GM_GL8_14_16 /* 852004 */:
                case FinalCanbus.CAR_DAOJUN_OD_ATS /* 852316 */:
                case FinalCanbus.CAR_DJ_XC_Nissan_Tianlai_03_07 /* 852397 */:
                case FinalCanbus.CAR_WC2_GM_Encore_12_15 /* 917540 */:
                case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_10_13PRADO /* 917933 */:
                case FinalCanbus.CAR_WC2_GM_Encore_16_19 /* 983076 */:
                case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_08_15LAND_CRUISER /* 983469 */:
                case FinalCanbus.CAR_WC2_GM_Regal_09_13 /* 1048612 */:
                case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_LEXUS /* 1049005 */:
                case FinalCanbus.CAR_WC2_GM_Lacrosse_10_13 /* 1114148 */:
                case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_HIGHLANDER /* 1114541 */:
                case FinalCanbus.CAR_WC2_GM_Lacrosse_18 /* 1179684 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_HIGHLANDER_H /* 1180077 */:
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
                case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport /* 10420678 */:
                case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport_H /* 10486214 */:
                case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport_Top /* 16056774 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 320;
                        break;
                    } else {
                        temp *= 5;
                        break;
                    }
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
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 10) + 590;
                        break;
                    } else {
                        temp = (temp * 5) + 155;
                        break;
                    }
                case 271:
                case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6 /* 131379 */:
                case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6_H /* 196915 */:
                case FinalCanbus.CAR_RZC_20BaoJunRS3 /* 459062 */:
                case FinalCanbus.CAR_OD_RZC_20BaoJunRS3 /* 590134 */:
                case FinalCanbus.CAR_OD_RZC_Wuling_Xingchen /* 655670 */:
                case FinalCanbus.CAR_RZC_BenTeng_19B50_HAND /* 655773 */:
                case FinalCanbus.CAR_RZC_Wuling_Xingchen /* 721206 */:
                case FinalCanbus.CAR_BNR_NISSAN_14QiJun_H /* 721220 */:
                case FinalCanbus.CAR_RZC_BenTeng_19B50_AUTO /* 721309 */:
                case FinalCanbus.CAR_RZC_Wuling_Kaijie /* 786742 */:
                case FinalCanbus.CAR_BNR_NISSAN_14QiJun_L /* 786756 */:
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
                case FinalCanbus.CAR_BNR_NISSAN_11QiDa_L /* 1311044 */:
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
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
                case FinalCanbus.CAR_RZC_Turkey_23MEGANE4_M /* 5046674 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
                case FinalCanbus.CAR_RZC_Turkey_23MEGANE4_H /* 5112210 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
                case FinalCanbus.CAR_RZC_Turkey_22TALISMAN_L /* 5177746 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
                case FinalCanbus.CAR_RZC_Turkey_22TALISMAN_M /* 5243282 */:
                case FinalCanbus.CAR_RZC_Turkey_22TALISMAN_H /* 5308818 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_DUSTER_L /* 5374354 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_DUSTER_M /* 5439890 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_DUSTER_H /* 5505426 */:
                case FinalCanbus.CAR_RZC_Turkey_22EXPRESS_L /* 5570962 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                case FinalCanbus.CAR_RZC_Turkey_22EXPRESS_M /* 5636498 */:
                case FinalCanbus.CAR_RZC_Turkey_22EXPRESS_H /* 5702034 */:
                case FinalCanbus.CAR_RZC_Russian_20ARKANA_L /* 5767570 */:
                case FinalCanbus.CAR_RZC_Russian_20ARKANA_M /* 5833106 */:
                case FinalCanbus.CAR_RZC_Russian_20ARKANA_H /* 5898642 */:
                case FinalCanbus.CAR_452_LZ_TATA_ALL /* 5898692 */:
                case FinalCanbus.CAR_RZC_Turkey_22KADJAR_M /* 5964178 */:
                case FinalCanbus.CAR_RZC_CLIO5_Turkey_L_ATUO /* 6029714 */:
                case FinalCanbus.CAR_453_RZC_LandRover_Discovery_19 /* 6160837 */:
                case FinalCanbus.CAR_RZC_Renault_SM6_18 /* 6226322 */:
                case FinalCanbus.CAR_RZC_Renault_SCENIC_16 /* 6291858 */:
                case FinalCanbus.CAR_RZC_Renault_SM6_18_M /* 6357394 */:
                case FinalCanbus.CAR_RZC_Renault_SCENIC_16_M /* 6422930 */:
                case FinalCanbus.CAR_RZC_Renault_SM6_18_H /* 6488466 */:
                case FinalCanbus.CAR_RZC_Renault_SCENIC_16_H /* 6554002 */:
                case FinalCanbus.CAR_443_WC2_Ford_EDGE_11 /* 6685115 */:
                case FinalCanbus.CAR_RZC_Renault_Dokker_18 /* 6750610 */:
                case FinalCanbus.CAR_443_WC2_Ford_EDGE_11_CD /* 6750651 */:
                case FinalCanbus.CAR_RZC_Renault_Dokker_18_H /* 6816146 */:
                case FinalCanbus.CAR_452_RZC_Subaru /* 7209412 */:
                case FinalCanbus.CAR_454_RZC_Racing_EC75_23 /* 7340486 */:
                case FinalCanbus.CAR_453_LZ_ALFA_ROMEO /* 7930309 */:
                case FinalCanbus.CAR_454_RZC_Suburu_OUTBACK_18 /* 8323526 */:
                case FinalCanbus.CAR_454_RZC_LandRover_Discovery_04 /* 9765318 */:
                case FinalCanbus.CAR_452_KYC_Zhonghua_All /* 10617284 */:
                case FinalCanbus.CAR_452_KYC_Zhonghua_All_H /* 10682820 */:
                case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7 /* 10748356 */:
                case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7_H /* 10813892 */:
                case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_L /* 13763014 */:
                case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_H /* 13828550 */:
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
                    temp *= 5;
                    break;
                case 274:
                case FinalCanbus.CAR_DJ_XP1_ACCORD7_H /* 65810 */:
                case FinalCanbus.CAR_439_OuDi_Z560 /* 983479 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 320;
                        break;
                    } else {
                        temp *= 10;
                        break;
                    }
                case 276:
                case FinalCanbus.CAR_OD_Jiangxi_Wushiling_Mux /* 393638 */:
                case FinalCanbus.CAR_OD_Jiangxi_Lingtuo /* 459174 */:
                    temp = (temp * 10) + 170;
                    break;
                case 373:
                case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_H /* 65909 */:
                case FinalCanbus.CAR_RZC_XP1_GrdCherokee /* 196981 */:
                case FinalCanbus.CAR_RZC_XP1_GrdCherokee_H /* 459125 */:
                case FinalCanbus.CAR_RZC_Dodge_JCUV /* 1114485 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM /* 1311093 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_H /* 1376629 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_M /* 1835381 */:
                case FinalCanbus.CAR_RZC_Dodge_JCUV_H /* 2359669 */:
                case FinalCanbus.CAR_454_OD_Qichen_D60_EV /* 9961926 */:
                    temp *= 10;
                    break;
                case FinalCanbus.CAR_RZC_XP1_BeiQiM50F /* 65932 */:
                    temp *= 10;
                    findViewById(R.id.air_sp_tempvalue_right).setVisibility(8);
                    findViewById(R.id.air_sp_tempunit_right).setVisibility(8);
                    findViewById(R.id.air_sp_tempstate_right).setVisibility(0);
                    mUpdateTempValue(R.id.air_sp_tempstate_right, (temp % 100) / 10, false);
                    break;
                case FinalCanbus.CAR_RZC_XP1_16HAIMAMV70 /* 131309 */:
                case FinalCanbus.CAR_RZC_XP1_HAIMA_F5 /* 262381 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        temp *= 10;
                        break;
                    } else {
                        temp *= 5;
                        break;
                    }
                case FinalCanbus.CAR_RZC_XP1_ZiYouXia /* 131445 */:
                case FinalCanbus.CAR_RZC_17ZhiNanZhe /* 262517 */:
                case FinalCanbus.CAR_RZC_17ZhiNanZhe_H /* 328053 */:
                case FinalCanbus.CAR_RZC_18MuMaRen /* 393589 */:
                case FinalCanbus.CAR_RZC_18MuMaRen_H /* 524661 */:
                case FinalCanbus.CAR_RZC_19Tiaozhanzhe /* 590197 */:
                case FinalCanbus.CAR_RZC_18Zhihuiguan /* 655733 */:
                case FinalCanbus.CAR_RZC_19Tiaozhanzhe_H /* 721269 */:
                case FinalCanbus.CAR_RZC_18Zhihuiguan_H /* 786805 */:
                case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19 /* 852341 */:
                case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19_H /* 917877 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_HY /* 1900917 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_HY_M /* 1966453 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_HY_H /* 2031989 */:
                case FinalCanbus.CAR_RZC_XP1_ZiYouXia_H /* 2163061 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 9) + 599;
                        break;
                    } else {
                        temp = (temp * 5) + 155;
                        break;
                    }
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
                case FinalCanbus.CAR_439_RZC_Nissan_19Qida /* 8585655 */:
                case FinalCanbus.CAR_439_RZC_Nissan_19Qida_H /* 8651191 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 10) + 440;
                        break;
                    } else {
                        temp = (temp * 5) + 80;
                        break;
                    }
                case FinalCanbus.CAR_RZC_HanTeng_H /* 196863 */:
                case FinalCanbus.CAR_Oudi_HanTeng_X5 /* 393471 */:
                case FinalCanbus.CAR_Oudi_XiaoYao /* 459007 */:
                case FinalCanbus.CAR_RZC_HanTeng_X5 /* 524543 */:
                    if (temp < 16) {
                        temp = (temp * 10) + 160;
                        break;
                    } else {
                        temp *= 5;
                        break;
                    }
                case FinalCanbus.CAR_WC2_20BaoJun530_Auto /* 393462 */:
                case FinalCanbus.CAR_WC2_20BaoJun530_Hand /* 458998 */:
                    temp = (temp * 20) + 160;
                    break;
                case FinalCanbus.CAR_RZC_OD_DongNanDX5 /* 590153 */:
                case FinalCanbus.CAR_439_DJ_LEXUS_ES /* 1245623 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_22Teana_Top /* 1572944 */:
                case FinalCanbus.CAR_455_OD_Dongfeng_Racing_EC75_23H /* 2294215 */:
                case FinalCanbus.CAR_439_DJ_LEXUS_ES_H /* 3801527 */:
                case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_Auto /* 5833156 */:
                case FinalCanbus.CAR_452_OD_HZ_Nezha /* 7602628 */:
                case FinalCanbus.CAR_BNR_02_09Toyato_Prado /* 7668151 */:
                case FinalCanbus.CAR_BNR_02_09Toyato_Prado_H /* 7733687 */:
                case FinalCanbus.CAR_454_OD_Dongfeng_Racing_EC75_23 /* 8454598 */:
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
                case FinalCanbus.CAR_RZC_Mingjue_20ZS_H /* 1442065 */:
                case FinalCanbus.CAR_RZC_19Mingjue_MG6 /* 1507601 */:
                case FinalCanbus.CAR_RZC_18RongWei_RX8 /* 1638673 */:
                case FinalCanbus.CAR_RZC_20RongWei_RX5 /* 1704209 */:
                case FinalCanbus.CAR_RZC_MingJue_MG5_21 /* 1835281 */:
                case FinalCanbus.CAR_RZC_21RongWei_I5 /* 1900817 */:
                case FinalCanbus.CAR_RZC_21RongWei_I5_H /* 1966353 */:
                case FinalCanbus.CAR_RZC_MingJue_MG5_21_L /* 2031889 */:
                case FinalCanbus.CAR_CZH_RZC_19Mingjue_MG6 /* 2097425 */:
                case FinalCanbus.CAR_454_OD_Xinte_DEV1_H /* 7274950 */:
                    temp *= 10;
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
                case FinalCanbus.CAR_454_OD_Dongfeng_Nami01 /* 10617286 */:
                case FinalCanbus.CAR_454_OD_ChangAn_Raeton /* 14352838 */:
                case FinalCanbus.CAR_454_OD_ChangAn_Raeton_H /* 14418374 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 635;
                        break;
                    } else {
                        temp = (temp * 5) + 175;
                        break;
                    }
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
                case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD /* 8913349 */:
                case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD_H /* 8978885 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 9) + 635;
                        break;
                    } else {
                        temp = (temp * 5) + 175;
                        break;
                    }
                case FinalCanbus.CAR_455_LZ_GMC_Sierra_19_RScreen /* 1507783 */:
                case FinalCanbus.CAR_455_LZ_Chevrolet_Silverado_19_RScreen /* 1573319 */:
                case FinalCanbus.CAR_453_LZ_GM_Camaro_17 /* 2163141 */:
                case FinalCanbus.CAR_453_LZ_GM_GMC_TERRAIN_17 /* 2228677 */:
                case FinalCanbus.CAR_453_LZ_GM_Equinox_17 /* 2294213 */:
                case FinalCanbus.CAR_454_LZ_GM_Camaro_17_Auto /* 6947270 */:
                case FinalCanbus.CAR_454_LZ_GM_Equinox_17_Auto /* 7012806 */:
                case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
                case FinalCanbus.CAR_454_LZ_Chevrolet_Silverado_19_Screen /* 11993542 */:
                    if (temp >= 30 && temp <= 64) {
                        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                            temp = (temp * 9) + 320;
                            break;
                        } else {
                            temp *= 5;
                            break;
                        }
                    } else if (temp >= 1 && temp <= 16) {
                        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                            temp = ((temp + 15) * 18) + 320;
                            break;
                        } else {
                            temp = (temp * 10) + 150;
                            break;
                        }
                    }
                    break;
                case FinalCanbus.CAR_452_DJ_Dodge_JCUV /* 4981188 */:
                    temp = (temp * 10) + 130;
                    break;
                case FinalCanbus.CAR_453_LZ_NISSAN_patrol /* 5308869 */:
                case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX60 /* 5374405 */:
                case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX80 /* 5439941 */:
                case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX56 /* 5505477 */:
                case FinalCanbus.CAR_439_LZ_INFINIT_FX35 /* 12714423 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 10) + 590;
                        break;
                    } else {
                        temp = (temp * 5) + 175;
                        break;
                    }
                case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9 /* 5702084 */:
                case FinalCanbus.CAR_454_RZC_Shanqi_DelongG2 /* 10027462 */:
                case FinalCanbus.CAR_439_DJ_Rongwei_i5 /* 13959607 */:
                case FinalCanbus.CAR_439_DJ_Rongwei_i5_H /* 14025143 */:
                    temp = (temp * 10) + 150;
                    break;
                case FinalCanbus.CAR_452_XC_Ford_Escape_13_17 /* 6422980 */:
                case FinalCanbus.CAR_452_XC_Ford_edge_11_13 /* 6488516 */:
                case FinalCanbus.CAR_452_XC_Ford_Raptor_F150_09_14 /* 6554052 */:
                case FinalCanbus.CAR_452_XC_Ford_edge_15_17 /* 6619588 */:
                case FinalCanbus.CAR_452_XC_Ford_Mondeo_13_18 /* 6685124 */:
                case FinalCanbus.CAR_439_HC_Ford_Explorer /* 15335863 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp *= 10;
                        break;
                    } else {
                        temp *= 5;
                        break;
                    }
                case FinalCanbus.CAR_439_HC_Ruijie /* 6816183 */:
                case FinalCanbus.CAR_439_HC_Ruijie_H /* 6881719 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        temp = ((temp - 12) * 5) + 155;
                        break;
                    } else {
                        temp = ((temp - 12) * 10) + 600;
                        break;
                    }
                case FinalCanbus.CAR_RZC_HavalH6Couple_BLUE_TOP /* 7078327 */:
                case FinalCanbus.CAR_RZC_HavalH6Couple_RED_TOP /* 7143863 */:
                case FinalCanbus.CAR_RZC_XP1_HavalH6Couple_19 /* 7602615 */:
                case FinalCanbus.CAR_439_RZC_Haval_18_19H6 /* 11272631 */:
                    temp = ((temp - 116) * 5) + 180;
                    if (temp < 0) {
                        temp = 0;
                        break;
                    }
                case FinalCanbus.CAR_453_LZ_Jili_Boyue_18 /* 8782277 */:
                case FinalCanbus.CAR_453_LZ_Jili_Boyue_18_H /* 8847813 */:
                    if (temp >= 32 && temp <= 34) {
                        temp = ((temp - 32) * 5) + 160;
                        break;
                    } else {
                        temp = (temp * 5) + 170;
                        break;
                    }
                case FinalCanbus.CAR_454_OD_Yutong_Qingka /* 11338182 */:
                    temp = (temp * 10) + 160;
                    break;
                case FinalCanbus.CAR_454_KYC_Ford_Mustang_07_H /* 13631942 */:
                case FinalCanbus.CAR_454_KYC_Ford_Mustang_07_L /* 13697478 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        temp = (temp * 10) + 310;
                        break;
                    } else {
                        temp *= 5;
                        break;
                    }
                case FinalCanbus.CAR_452_OD_ChangCheng_Fengjun5 /* 13763012 */:
                    temp = ((temp - 116) * 5) + 160;
                    if (temp < 0) {
                        temp = 0;
                        break;
                    }
            }
            mUpdateTempValue(R.id.air_sp_temp_right1, temp / 100, false);
            mUpdateTempValue(R.id.air_sp_temp_right2, (temp % 100) / 10, false);
            mUpdateTempValue(R.id.air_sp_temp_right3, temp % 10, true);
            mUpdateTempUNIT();
        }
    }

    
    public void mUpdateTempUNIT() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT];
        if (ConstAllAirDara.U_AIR_TEMP_UNIT != 255) {
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                case FinalCanbus.CAR_443_WC2_Ford_EDGE_11 /* 6685115 */:
                case FinalCanbus.CAR_443_WC2_Ford_EDGE_11_CD /* 6750651 */:
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
                        break;
                    } else {
                        findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        break;
                    }
                default:
                    if (vel == 1) {
                        findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                        findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                        findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                        findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                        break;
                    } else {
                        findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        break;
                    }
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

    
    public void mUpdateBackAuto() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_AUTO];
        findViewById(R.id.air_sp_auto_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_auto_n : R.drawable.ic_hp_auto_p);
    }

    
    public void mUpdateBackAutoRight() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_AUTO_RIGHT];
        findViewById(R.id.air_sp_auto_rear_right).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_auto_n : R.drawable.ic_hp_auto_p);
    }

    
    public void mUpdateBackRearLock() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_LOCK];
        findViewById(R.id.air_sp_rearlock_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_rearlight_n : R.drawable.ic_hp_rearlight_p);
    }

    
    public void mUpdateBackRearSync() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_SYNC];
        findViewById(R.id.air_sp_sync_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_sync_n : R.drawable.ic_hp_sync_p);
    }

    
    public void mUpdateBackRearAC() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_AC];
        findViewById(R.id.air_sp_ac_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_ac_n : R.drawable.ic_hp_ac_p);
    }

    
    public void mUpdateBackRearCtrl() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_CTRL];
        findViewById(R.id.air_sp_car_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_rearlight_n : R.drawable.ic_hp_rearlight_p);
    }

    
    public void mUpdateAirEm() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_EM];
        findViewById(R.id.air_sp_em).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_em_n : R.drawable.ic_hp_em_p);
    }

    
    public void mUpdateBackWind() {
        int leave = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_WIND];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria /* 328124 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria_H /* 393660 */:
            case FinalCanbus.CAR_455_LZ_GMC_Sierra_19_RScreen /* 1507783 */:
            case FinalCanbus.CAR_455_LZ_Chevrolet_Silverado_19_RScreen /* 1573319 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_15Carnival /* 1966524 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_15Carnival_H /* 2032060 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_23NewZealand /* 2097596 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_23NewZealand_H /* 2163132 */:
            case FinalCanbus.CAR_RZC3_XianDai_19Palisade /* 2752959 */:
            case FinalCanbus.CAR_RZC3_XianDai_19Palisade_H /* 2818495 */:
            case FinalCanbus.CAR_RZC3_XianDai_20CARNIVAL /* 2884031 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra /* 2949564 */:
            case FinalCanbus.CAR_RZC3_XianDai_20CARNIVAL_H /* 2949567 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra_H /* 3015100 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra_EV /* 3211708 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_23Staria /* 3539391 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_23Staria_H /* 3604927 */:
            case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
            case FinalCanbus.CAR_454_LZ_Chevrolet_Silverado_19_Screen /* 11993542 */:
                ((TextView) findViewById(R.id.air_sp_rear_wind_txt)).setText(new StringBuilder().append(leave).toString());
                ((ProgressBar) findViewById(R.id.air_sp_rear_wind_lev)).setMax(8);
                break;
            case FinalCanbus.CAR_RZC_19RongWei_RX8 /* 1310993 */:
            case FinalCanbus.CAR_RZC_18RongWei_RX8 /* 1638673 */:
                if (leave == 15) {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText("AUTO");
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(7);
                    break;
                } else {
                    ((TextView) findViewById(R.id.air_sp_rear_wind_txt)).setText(new StringBuilder().append(leave).toString());
                    ((ProgressBar) findViewById(R.id.air_sp_rear_wind_lev)).setMax(7);
                    break;
                }
            case FinalCanbus.CAR_454_LZ_Honda_AoDeSai_04 /* 16449990 */:
                ((TextView) findViewById(R.id.air_sp_rear_wind_txt)).setText(new StringBuilder().append(leave).toString());
                ((ProgressBar) findViewById(R.id.air_sp_rear_wind_lev)).setMax(5);
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

    
    public void mUpdaterAirWindLevelLeft() {
        int value = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
        ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(value).toString());
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
            case FinalCanbus.CAR_RZC_18_19Excelle_GT /* 459015 */:
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
                    break;
                } else {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(value).toString());
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(8);
                    break;
                }
            case 36:
            case 254:
            case 308:
            case 345:
            case FinalCanbus.CAR_WC2_ShuPingJW /* 65881 */:
            case FinalCanbus.CAR_WC2_ShuPingKeLuZi /* 131417 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao /* 196953 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS /* 262489 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS_S /* 328025 */:
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
                if (value > 18) {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText("AUTO");
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(8);
                    break;
                } else {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(value).toString());
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(8);
                    break;
                }
            case 282:
            case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
            case FinalCanbus.CAR_WC2_17MingJueRuiTeng /* 131354 */:
            case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6 /* 131379 */:
            case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6_H /* 196915 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria /* 328124 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria_H /* 393660 */:
            case FinalCanbus.CAR_RZC_OD_DongNanDX5 /* 590153 */:
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
            case FinalCanbus.CAR_RZC_17_18KeleiAo_H /* 1376658 */:
            case FinalCanbus.CAR_RZC_FengShen_X37_21 /* 1442047 */:
            case FinalCanbus.CAR_455_LZ_GMC_Sierra_19_RScreen /* 1507783 */:
            case FinalCanbus.CAR_455_LZ_Chevrolet_Silverado_19_RScreen /* 1573319 */:
            case FinalCanbus.CAR_RZC_FengShen15AX7 /* 1638655 */:
            case FinalCanbus.CAR_RZC_MEGANE_Turkey_L /* 1638802 */:
            case FinalCanbus.CAR_RZC_FengShen19AX7_Hand /* 1704191 */:
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
            case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra /* 2949564 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra_H /* 3015100 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra_EV /* 3211708 */:
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
            case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9 /* 5702084 */:
            case FinalCanbus.CAR_RZC_Russian_20ARKANA_L /* 5767570 */:
            case FinalCanbus.CAR_RZC_Russian_20ARKANA_M /* 5833106 */:
            case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_Auto /* 5833156 */:
            case FinalCanbus.CAR_RZC_Russian_20ARKANA_H /* 5898642 */:
            case FinalCanbus.CAR_RZC_Turkey_22KADJAR_M /* 5964178 */:
            case FinalCanbus.CAR_RZC_CLIO5_Turkey_L_ATUO /* 6029714 */:
            case FinalCanbus.CAR_RZC_Renault_SM6_18 /* 6226322 */:
            case FinalCanbus.CAR_RZC_Renault_SCENIC_16 /* 6291858 */:
            case FinalCanbus.CAR_RZC_Renault_SM6_18_M /* 6357394 */:
            case FinalCanbus.CAR_RZC_Renault_SCENIC_16_M /* 6422930 */:
            case FinalCanbus.CAR_452_XC_Ford_Escape_13_17 /* 6422980 */:
            case FinalCanbus.CAR_RZC_Renault_SM6_18_H /* 6488466 */:
            case FinalCanbus.CAR_452_XC_Ford_edge_11_13 /* 6488516 */:
            case FinalCanbus.CAR_RZC_Renault_SCENIC_16_H /* 6554002 */:
            case FinalCanbus.CAR_452_XC_Ford_Raptor_F150_09_14 /* 6554052 */:
            case FinalCanbus.CAR_452_XC_Ford_edge_15_17 /* 6619588 */:
            case FinalCanbus.CAR_452_XC_Ford_Mondeo_13_18 /* 6685124 */:
            case FinalCanbus.CAR_RZC_Renault_Dokker_18 /* 6750610 */:
            case FinalCanbus.CAR_RZC_Renault_Dokker_18_H /* 6816146 */:
            case FinalCanbus.CAR_439_HC_Ruijie /* 6816183 */:
            case FinalCanbus.CAR_439_HC_Ruijie_H /* 6881719 */:
            case FinalCanbus.CAR_454_LZ_GM_Camaro_17_Auto /* 6947270 */:
            case FinalCanbus.CAR_454_LZ_GM_Equinox_17_Auto /* 7012806 */:
            case FinalCanbus.CAR_RZC_HavalH6Couple_BLUE_TOP /* 7078327 */:
            case FinalCanbus.CAR_RZC_HavalH6Couple_RED_TOP /* 7143863 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6Couple_19 /* 7602615 */:
            case FinalCanbus.CAR_452_OD_HZ_Nezha /* 7602628 */:
            case FinalCanbus.CAR_BNR_02_09Toyato_Prado /* 7668151 */:
            case FinalCanbus.CAR_BNR_02_09Toyato_Prado_H /* 7733687 */:
            case FinalCanbus.CAR_453_LZ_Jili_Boyue_18 /* 8782277 */:
            case FinalCanbus.CAR_453_LZ_Jili_Boyue_18_H /* 8847813 */:
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
            case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
            case FinalCanbus.CAR_454_LZ_Chevrolet_Silverado_19_Screen /* 11993542 */:
            case FinalCanbus.CAR_452_OD_ChangCheng_Fengjun5 /* 13763012 */:
            case FinalCanbus.CAR_454_OD_ChangAn_Raeton /* 14352838 */:
            case FinalCanbus.CAR_454_OD_ChangAn_Raeton_H /* 14418374 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_18OPTIMA /* 15073723 */:
            case FinalCanbus.CAR_439_HC_Ford_Explorer /* 15335863 */:
            case FinalCanbus.CAR_454_CZH_OUDI_BYD_ALL /* 15663558 */:
            case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport_Top /* 16056774 */:
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(8);
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
                if (value >= 8) {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText("AUTO");
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(7);
                    break;
                } else {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(value).toString());
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(7);
                    break;
                }
            case FinalCanbus.CAR_RZC_XP1_BeiQiM50F /* 65932 */:
            case FinalCanbus.CAR_WC2_20BaoJun530_Auto /* 393462 */:
            case FinalCanbus.CAR_WC2_20BaoJun530_Hand /* 458998 */:
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
            case FinalCanbus.CAR_454_OD_Xinte_DEV1_H /* 7274950 */:
            case FinalCanbus.CAR_439_DJ_Rongwei_i5 /* 13959607 */:
            case FinalCanbus.CAR_439_DJ_Rongwei_i5_H /* 14025143 */:
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(6);
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
            case FinalCanbus.CAR_454_KYC_Ford_Mustang_07_H /* 13631942 */:
            case FinalCanbus.CAR_454_KYC_Ford_Mustang_07_L /* 13697478 */:
                if (value == 15) {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText("AUTO");
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(7);
                    break;
                } else {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(value).toString());
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(7);
                    break;
                }
            case FinalCanbus.CAR_455_OD_Zhongtai_E200 /* 786887 */:
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
                if (value == 15) {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText("AUTO");
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(8);
                    break;
                } else {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(value).toString());
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(8);
                    break;
                }
            case FinalCanbus.CAR_453_LZ_ALFA_ROMEO /* 7930309 */:
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(9);
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

    
    public void mUpdateHeatLeft() {
        int flag;
        int heatlevel;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
            case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
            case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
            case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
            case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
                if ((vel & 8) != 0) {
                    heatlevel = 16 - vel;
                    flag = 1;
                } else {
                    flag = 0;
                    heatlevel = vel;
                }
                if (flag == 0) {
                    switch (heatlevel) {
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
                } else {
                    findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_0);
                    break;
                }
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
            case FinalCanbus.CAR_CZH_OD_NISSAN_22Teana_Top /* 1572944 */:
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
        }
    }

    
    public void mUpdateHeatRight() {
        int flag;
        int heatlevel;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
            case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
            case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
            case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
            case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
                if ((vel & 8) != 0) {
                    heatlevel = 16 - vel;
                    flag = 1;
                } else {
                    flag = 0;
                    heatlevel = vel;
                }
                if (flag == 0) {
                    switch (heatlevel) {
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
                } else {
                    findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_0);
                    break;
                }
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
            case FinalCanbus.CAR_CZH_OD_NISSAN_22Teana_Top /* 1572944 */:
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
        }
    }

    
    public void mUpdateWindLeft() {
        int flag;
        int heatlevel;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_LEFT];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
            case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
            case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
            case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
            case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
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
                    findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_0);
                    break;
                }
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
        }
    }

    
    public void mUpdateWindRight() {
        int flag;
        int heatlevel;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_RIGHT];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
            case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
            case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
            case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
            case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
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
                    findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_0);
                    break;
                }
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
        }
    }

    
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

    
    public void mUpdateDual() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_DUAL];
        findViewById(R.id.air_sp_dual).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_dual_n : R.drawable.ic_hp_dual_p);
    }

    
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
            case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_L /* 13763014 */:
            case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_H /* 13828550 */:
                View findViewById = findViewById(R.id.air_sp_sync);
                if (vel != 0) {
                    i = 2130840589;
                }
                findViewById.setBackgroundResource(i);
                break;
            default:
                View findViewById2 = findViewById(R.id.air_sp_sync);
                if (vel != 0) {
                    i2 = 2130840590;
                }
                findViewById2.setBackgroundResource(i2);
                break;
        }
    }

    
    public void mUpdateZONE() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_ZONE];
        findViewById(R.id.air_sp_zone).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_zone_n : R.drawable.ic_hp_zone_p);
    }

    
    public void mUpdateAutoRight() {
        int i = R.drawable.ic_hp_auto_p;
        int i2 = R.drawable.ic_hp_auto_n;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO_RIGHT];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_LZ_Nissan_05_Cima /* 9044422 */:
                View findViewById = findViewById(R.id.air_sp_auto_right);
                if (vel != 2) {
                    i = 2130840453;
                }
                findViewById.setBackgroundResource(i);
                break;
            default:
                View findViewById2 = findViewById(R.id.air_sp_auto_right);
                if (vel != 0) {
                    i2 = 2130840454;
                }
                findViewById2.setBackgroundResource(i2);
                break;
        }
    }

    
    public void mUpdateAuto() {
        int i = R.drawable.ic_hp_auto_p;
        int i2 = R.drawable.ic_hp_auto_n;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_LZ_Nissan_05_Cima /* 9044422 */:
                View findViewById = findViewById(R.id.air_sp_auto);
                if (vel != 2) {
                    i = 2130840453;
                }
                findViewById.setBackgroundResource(i);
                break;
            default:
                View findViewById2 = findViewById(R.id.air_sp_auto);
                if (vel != 0) {
                    i2 = 2130840454;
                }
                findViewById2.setBackgroundResource(i2);
                break;
        }
    }

    
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
            default:
                findViewById(R.id.air_sp_ac).setBackgroundResource(acOn == 0 ? 2130840427 : 2130840429);
                break;
        }
    }

    
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
            case FinalCanbus.CAR_RZC_19MingjueHS_H /* 1048849 */:
            case FinalCanbus.CAR_RZC_19RongWei_I5_H /* 1114385 */:
            case FinalCanbus.CAR_RZC_Dodge_JCUV /* 1114485 */:
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
            case FinalCanbus.CAR_RZC_XP1_ZiYouXia_H /* 2163061 */:
            case FinalCanbus.CAR_RZC_Dodge_JCUV_H /* 2359669 */:
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
            case FinalCanbus.CAR_453_LZ_Toyota_markII_L /* 9634245 */:
            case FinalCanbus.CAR_453_LZ_Toyota_markII_H /* 9699781 */:
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
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
            case FinalCanbus.CAR_453_LZ_NISSAN_patrol /* 5308869 */:
            case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX60 /* 5374405 */:
            case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX80 /* 5439941 */:
            case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX56 /* 5505477 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
            case FinalCanbus.CAR_443_WC2_Ford_EDGE_11 /* 6685115 */:
            case FinalCanbus.CAR_443_WC2_Ford_EDGE_11_CD /* 6750651 */:
            case FinalCanbus.CAR_454_LZ_Nissan_05_Cima /* 9044422 */:
            case FinalCanbus.CAR_439_LZ_INFINIT_FX35 /* 12714423 */:
            case FinalCanbus.CAR_454_LZ_Nissan_370Z_H /* 14746054 */:
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
                View findViewById = findViewById(R.id.air_sp_cycle);
                if (cycle != 0) {
                    i = 2130840484;
                }
                findViewById.setBackgroundResource(i);
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
                }
            case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport /* 10420678 */:
            case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport_H /* 10486214 */:
            case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport_Top /* 16056774 */:
                View findViewById2 = findViewById(R.id.air_sp_cycle);
                if (cycle != 2) {
                    i = 2130840484;
                }
                findViewById2.setBackgroundResource(i);
                break;
            default:
                View findViewById3 = findViewById(R.id.air_sp_cycle);
                if (cycle != 1) {
                    i = 2130840484;
                }
                findViewById3.setBackgroundResource(i);
                break;
        }
    }

    
    public void mUpdateNanoe() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_NANOE];
        findViewById(R.id.air_sp_nanoe).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_nanoe_n : R.drawable.ic_hp_nanoe_p);
    }

    
    public void mUpdateECO() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_ECO];
        findViewById(R.id.air_sp_eco).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_eco_n : R.drawable.ic_hp_eco_p);
    }

    
    public void mUpdateFlowerBlow() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FLOWER_BLOW];
        findViewById(R.id.air_sp_flowerblow).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_flowerblow_n : R.drawable.ic_hp_flowerblow_p);
    }

    
    public void mUpdateAirPark() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_PARK];
        findViewById(R.id.air_sp_airpark).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_airpark_n : R.drawable.ic_hp_airpark_p);
    }

    
    public void mUpdateAirRest() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_REST];
        findViewById(R.id.air_sp_rest).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_rest_n : R.drawable.ic_hp_rest_p);
    }

    
    public void mUpdateAirOnlyFront() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT_ONLY];
        findViewById(R.id.air_sp_onlyfront).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_onlyfront_n : R.drawable.ic_hp_onlyfront_p);
    }

    
    public void mUpdateAirOnlyFront_F() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT_ONLY_F];
        findViewById(R.id.air_sp_onlyfront_front).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_onlyfront_n : R.drawable.ic_hp_onlyfront_p);
    }

    
    public void mUpdateAirRearCool() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_COOL];
        findViewById(R.id.air_sp_rear_cool).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_rearcool_n : R.drawable.ic_hp_rearcool_p);
    }

    
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
        }
    }

    
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
                findViewById(R.id.air_sp_swing).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_swing_toyota_n : R.drawable.ic_hp_swing_toyota_p);
                break;
            default:
                findViewById(R.id.air_sp_swing).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_swing_n : R.drawable.ic_hp_swing_p);
                break;
        }
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR];
        findViewById(R.id.air_sp_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_rear_n : R.drawable.ic_hp_rear_p);
    }

    
    public void mUpdateFrontHot() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT_HOT];
        findViewById(R.id.air_sp_fronthot).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_fronthot_n : R.drawable.ic_hp_fronthot_p);
    }

    
    public void mUpdateFrontDefrost() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_TORO /* 131111 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
            case FinalCanbus.CAR_DAOJUN_OD_ATS /* 852316 */:
            case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
            case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
            case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
            case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
            case FinalCanbus.CAR_454_OD_Xinte_DEV1_H /* 7274950 */:
                findViewById(R.id.air_sp_front).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_maxfront_n : R.drawable.ic_hp_maxfront_p);
                break;
            default:
                findViewById(R.id.air_sp_front).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_front_n : R.drawable.ic_hp_front_p);
                break;
        }
    }

    
    public void mUpdateMaxFrontDefrost() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONTMAX];
        findViewById(R.id.air_sp_frontmax).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_maxfront_n : R.drawable.ic_hp_maxfront_p);
    }

    
    public void mUpdatePower() {
        int value = DataCanbus.DATA[ConstAllAirDara.U_AIR_POWER];
        if (this.pagenum == 1) {
            value = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_POWER];
        }
        findViewById(R.id.air_sp_power).setBackgroundResource(value == 0 ? R.drawable.ic_hp_power_n : R.drawable.ic_hp_power_p);
    }

    
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

    
    public void updateBlowModeLeft() {
        int mode;
        int mode2;
        int mode3;
        int win = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT];
        int body = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT];
        int foot = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT];
        int auto = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_AUTO_LEFT];
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
        if (ConstAllAirDara.C_AIR_MODE_CENTER != 255) {
            findViewById(R.id.air_sp_blow_changer_center).setBackgroundResource(R.drawable.ic_hp_mode_win_foot_n);
            switch (mode3) {
                case 5:
                    findViewById(R.id.air_sp_blow_changer_center).setBackgroundResource(R.drawable.ic_hp_mode_win_foot_p);
                    break;
            }
        }
        if (ConstAllAirDara.C_AIR_MODE_BODYFOOT == 255 && ConstAllAirDara.C_AIR_MODE_UPFOOT == 255) {
            findViewById(R.id.air_sp_blow_win).setBackgroundResource(win == 1 ? R.drawable.ic_hp_mode_win_p : R.drawable.ic_hp_mode_win_n);
            findViewById(R.id.air_sp_blow_body).setBackgroundResource(body == 1 ? R.drawable.ic_hp_mode_body_p : R.drawable.ic_hp_mode_body_n);
            findViewById(R.id.air_sp_blow_foot).setBackgroundResource(foot == 1 ? R.drawable.ic_hp_mode_foot_p : R.drawable.ic_hp_mode_foot_n);
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
        findViewById(R.id.air_sp_mode_foot).setVisibility(foot == 0 ? 8 : 0);
        findViewById(R.id.air_sp_mode_auto).setVisibility(auto == 0 ? 8 : 0);
        if (ConstAllAirDara.U_AIR_BLOW_UP_RIGHT == 255 && ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT == 255 && ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT == 255) {
            findViewById(R.id.air_sp_mode_up_right).setVisibility(win == 0 ? 8 : 0);
            findViewById(R.id.air_sp_mode_body_right).setVisibility(body == 0 ? 8 : 0);
            findViewById(R.id.air_sp_mode_foot_right).setVisibility(foot == 0 ? 8 : 0);
            findViewById(R.id.air_sp_mode_auto_right).setVisibility(auto != 0 ? 0 : 8);
        }
    }

    
    public void updateBlowModeRight() {
        int mode;
        int mode2;
        int mode3;
        int win = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_RIGHT];
        int body = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT];
        int foot = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT];
        int auto = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_AUTO_RIGHT];
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
