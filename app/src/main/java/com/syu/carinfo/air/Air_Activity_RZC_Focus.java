package com.syu.carinfo.air;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.carinfo.rzc.klc.RzcKlcFunc;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_Activity_RZC_Focus extends Activity implements View.OnTouchListener {
    public static Air_Activity_RZC_Focus mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.air.Air_Activity_RZC_Focus.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == ConstAllAirDara.U_AIR_AC) {
                Air_Activity_RZC_Focus.this.mUpdateAcOn();
            }
            if (updateCode == ConstAllAirDara.U_AIR_CYCLE) {
                Air_Activity_RZC_Focus.this.mUpdateCycle();
            }
            if (updateCode == ConstAllAirDara.U_AIR_CYCLE_AUTO) {
                Air_Activity_RZC_Focus.this.mUpdateCycle();
            }
            if (updateCode == ConstAllAirDara.U_AIR_PTC) {
                Air_Activity_RZC_Focus.this.mUpdatePtc();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SWING) {
                Air_Activity_RZC_Focus.this.mUpdateSwing();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FRONT_HOT) {
                Air_Activity_RZC_Focus.this.mUpdateFrontHot();
            }
            if (updateCode == ConstAllAirDara.U_AIR_ION) {
                Air_Activity_RZC_Focus.this.mUpdateION();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOWTOP) {
                Air_Activity_RZC_Focus.this.mUpdateBlowTop();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR) {
                Air_Activity_RZC_Focus.this.mUpdateRearDefrost();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FRONT) {
                Air_Activity_RZC_Focus.this.mUpdateFrontDefrost();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FRONTMAX) {
                Air_Activity_RZC_Focus.this.mUpdateFrontmaxDefrost();
            }
            if (updateCode == ConstAllAirDara.U_AIR_POWER) {
                Air_Activity_RZC_Focus.this.mUpdatePower();
            }
            if (updateCode == ConstAllAirDara.U_AIR_TEMP_LEFT) {
                Air_Activity_RZC_Focus.this.mUpdateAirTempLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_TEMP_UNIT) {
                Air_Activity_RZC_Focus.this.mUpdateAirTempLeft();
                Air_Activity_RZC_Focus.this.mUpdateTempRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT) {
                Air_Activity_RZC_Focus.this.mUpdaterAirWindLevelLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_BODYFOOT_LEFT) {
                Air_Activity_RZC_Focus.this.updateBlowMode();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_UPFOOT_LEFT) {
                Air_Activity_RZC_Focus.this.updateBlowMode();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_UP_LEFT) {
                Air_Activity_RZC_Focus.this.updateBlowModeUp();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_BODY_LEFT) {
                Air_Activity_RZC_Focus.this.updateBlowModeBody();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT) {
                Air_Activity_RZC_Focus.this.updateBlowModeFoot();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_UP_RIGHT) {
                Air_Activity_RZC_Focus.this.updateBlowModeUpRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT) {
                Air_Activity_RZC_Focus.this.updateBlowModeBodyRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT) {
                Air_Activity_RZC_Focus.this.updateBlowModeFootRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_AC_MAX) {
                Air_Activity_RZC_Focus.this.mUpdateAcMax();
            }
            if (updateCode == ConstAllAirDara.U_AIR_AUTO) {
                Air_Activity_RZC_Focus.this.mUpdateAuto();
            }
            if (updateCode == ConstAllAirDara.U_AIR_AUTO_LEV) {
                Air_Activity_RZC_Focus.this.mUpdateAuto();
            }
            if (updateCode == ConstAllAirDara.U_AIR_DUAL) {
                Air_Activity_RZC_Focus.this.mUpdateDual();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SYNC) {
                Air_Activity_RZC_Focus.this.mUpdateSYNC();
            }
            if (updateCode == ConstAllAirDara.U_AIR_ZONE) {
                Air_Activity_RZC_Focus.this.mUpdateZONE();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FOREST) {
                Air_Activity_RZC_Focus.this.mUpdateForest();
            }
            if (updateCode == ConstAllAirDara.U_AIR_STEER) {
                Air_Activity_RZC_Focus.this.mUpdateSteer();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATHEAT_LEFT) {
                Air_Activity_RZC_Focus.this.mUpdateHeatLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATHEAT_RIGHT) {
                Air_Activity_RZC_Focus.this.mUpdateHeatRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATWIND_LEFT) {
                Air_Activity_RZC_Focus.this.mUpdateWindLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATWIND_RIGHT) {
                Air_Activity_RZC_Focus.this.mUpdateWindRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_TEMP_RIGHT) {
                Air_Activity_RZC_Focus.this.mUpdateTempRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_EV) {
                Air_Activity_RZC_Focus.this.mUpdateEV();
            }
            if (updateCode == ConstAllAirDara.U_AIR_ECO) {
                Air_Activity_RZC_Focus.this.mUpdateECO();
            }
            if (updateCode == ConstAllAirDara.U_AIR_NANOE) {
                Air_Activity_RZC_Focus.this.mUpdateNANOE();
            }
            if (updateCode == ConstAllAirDara.U_AIR_CLEAN) {
                Air_Activity_RZC_Focus.this.mUpdateCLEAN();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR_CTRL) {
                Air_Activity_RZC_Focus.this.mUpdateRearCtrl();
            }
            if (updateCode == ConstAllAirDara.U_AIR_CLEANAIR) {
                Air_Activity_RZC_Focus.this.mUpdateCleanAir();
            }
            if (updateCode == ConstAllAirDara.U_AIR_HEAT) {
                Air_Activity_RZC_Focus.this.mUpdateAirHeat();
            }
            if (updateCode == ConstAllAirDara.U_AIR_COOL) {
                Air_Activity_RZC_Focus.this.mUpdateAirCool();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SOFT) {
                Air_Activity_RZC_Focus.this.mUpdateAirSoft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FAST) {
                Air_Activity_RZC_Focus.this.mUpdateAirFast();
            }
            if (updateCode == ConstAllAirDara.U_AIR_NORMAL) {
                Air_Activity_RZC_Focus.this.mUpdateAirNormal();
            }
            if (updateCode == ConstAllAirDara.U_AIR_MODE) {
                Air_Activity_RZC_Focus.this.mUpdateAirMode();
            }
            if (updateCode == ConstAllAirDara.U_AIR_AQS) {
                Air_Activity_RZC_Focus.this.mUpdateAirAQS();
            }
            if (updateCode == ConstAllAirDara.U_AIR_WINLEV) {
                Air_Activity_RZC_Focus.this.mUpdateAirWinlev();
            }
            if (updateCode != ConstAllAirDara.U_AIR_REST) {
                return;
            }
            Air_Activity_RZC_Focus.this.mUpdateAirRest();
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String platform = SystemProperties.get("ro.fyt.platform", "");
        if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform)) {
            setContentView(R.layout.layout_air_sp_rzc_focus);
        } else {
            setContentView(R.layout.layout_air_sp_rzc_focus_7731);
        }
        mInstance = this;
    }

    private void sendCmd(int data0, int data1) {
        int value;
        int value2;
        int value3;
        int value4;
        switch (DataCanbus.DATA[1000]) {
            case 21:
            case 276:
            case 373:
            case 397:
            case FinalCanbus.CAR_WC2_MengDiOuZS2013_M /* 65557 */:
            case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_H /* 65909 */:
            case FinalCanbus.CAR_WC2_MengDiOuZS2013_H /* 131093 */:
            case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL /* 196629 */:
            case FinalCanbus.CAR_DJ_ShuPing_BYD_G6 /* 196759 */:
            case FinalCanbus.CAR_RZC_XP1_GrdCherokee /* 196981 */:
            case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL_M /* 262165 */:
            case FinalCanbus.CAR_DJ_ShuPing_BYD_G6_H /* 262295 */:
            case FinalCanbus.CAR_WC2_Honda_AllCom_CIVIC /* 262465 */:
            case FinalCanbus.CAR_RZC_17ZhiNanZhe /* 262517 */:
            case FinalCanbus.CAR_BNR_17LIENUO_L /* 262546 */:
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_12Crown_ShuPing /* 262573 */:
            case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL_H /* 327701 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_5 /* 327741 */:
            case FinalCanbus.CAR_RZC_17ZhiNanZhe_H /* 328053 */:
            case FinalCanbus.CAR_BNR_17LIENUO_M /* 328082 */:
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_12Crown_H_ShuPing /* 328109 */:
            case FinalCanbus.CAR_BNR_HONDA_16Civic_Vsceen_L /* 393514 */:
            case FinalCanbus.CAR_BNR_17LIENUO_H /* 393618 */:
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_06Prado_ShuPing /* 393645 */:
            case FinalCanbus.CAR_BNR_HONDA_16Civic_Vsceen_H /* 459050 */:
            case FinalCanbus.CAR_WC2_Honda_17CRV /* 459073 */:
            case FinalCanbus.CAR_RZC_XP1_GrdCherokee_H /* 459125 */:
            case FinalCanbus.CAR_BNR_XP1_JunWei /* 459131 */:
            case FinalCanbus.CAR_BNR_17KeLeiJia_L /* 459154 */:
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_14Prodo_H_ShuPing /* 459181 */:
            case FinalCanbus.CAR_BNR_XP1_New_KLZ /* 524667 */:
            case FinalCanbus.CAR_BNR_12Camry /* 524685 */:
            case FinalCanbus.CAR_BNR_17KeLeiJia_H /* 524690 */:
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_14Prodo_ShuPing /* 524717 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_9 /* 589885 */:
            case FinalCanbus.CAR_BNR_XP1_Mairuibao_L /* 590203 */:
            case FinalCanbus.CAR_BNR_ShuPing_15_Camery /* 590221 */:
            case FinalCanbus.CAR_BNR_18KeLeiAo_M /* 590226 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown /* 590253 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_10 /* 655421 */:
            case FinalCanbus.CAR_BNR_HONDA_Avancier_Vsceen_NoAmp /* 655658 */:
            case FinalCanbus.CAR_BNR_XP1_Mairuibao_H /* 655739 */:
            case FinalCanbus.CAR_BNR_ShuPing_12LandCruise /* 655757 */:
            case FinalCanbus.CAR_RZC_17LIENUO_L /* 655762 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown /* 655789 */:
            case FinalCanbus.CAR_BNR_HONDA_Avancier_Vsceen_Amp_View /* 721194 */:
            case FinalCanbus.CAR_BNR_NISSAN_14QiJun_H /* 721220 */:
            case FinalCanbus.CAR_BNR_XP1_JunWei_L /* 721275 */:
            case FinalCanbus.CAR_BNR_ShuPing_16LandCruise /* 721293 */:
            case FinalCanbus.CAR_RZC_17LIENUO_M /* 721298 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown_L /* 721325 */:
            case FinalCanbus.CAR_WC2_Honda_16SIYU_HAND /* 786753 */:
            case FinalCanbus.CAR_BNR_NISSAN_14QiJun_L /* 786756 */:
            case FinalCanbus.CAR_BNR_XP1_JunWei_H /* 786811 */:
            case FinalCanbus.CAR_BNR_ShuPing_09Camery /* 786829 */:
            case FinalCanbus.CAR_RZC_17LIENUO_H /* 786834 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown_L /* 786861 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_13 /* 852029 */:
            case FinalCanbus.CAR_WC2_Honda_16SIYU_AUTO /* 852289 */:
            case FinalCanbus.CAR_BNR_NISSAN_16Xiaoke_L /* 852292 */:
            case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19 /* 852341 */:
            case FinalCanbus.CAR_RZC_17KeLeiJia_L /* 852370 */:
            case FinalCanbus.CAR_DJ_XC_Nissan_Tianlai_03_07 /* 852397 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_14 /* 917565 */:
            case FinalCanbus.CAR_BNR_NISSAN_13TianLai_H /* 917828 */:
            case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19_H /* 917877 */:
            case FinalCanbus.CAR_RZC_17KeLeiJia_H /* 917906 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx /* 917956 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_15 /* 983101 */:
            case FinalCanbus.CAR_BNR_17CRV /* 983338 */:
            case FinalCanbus.CAR_BNR_NISSAN_16Xiaoke_H /* 983364 */:
            case FinalCanbus.CAR_BNR_XP1_New_YingLang_L /* 983419 */:
            case FinalCanbus.CAR_RZC_18KeLeiAo_M /* 983442 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx_H /* 983492 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_16 /* 1048637 */:
            case FinalCanbus.CAR_RZC_HONDA_16Civic_Vsceen_L /* 1048874 */:
            case FinalCanbus.CAR_BNR_NISSAN_13TianLai_L /* 1048900 */:
            case FinalCanbus.CAR_BNR_XP1_New_YingLang_H /* 1048955 */:
            case FinalCanbus.CAR_RZC_18KeLeiAo_H /* 1048978 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_17 /* 1114173 */:
            case FinalCanbus.CAR_RZC_DongFeng_Fengxing_M7 /* 1114339 */:
            case FinalCanbus.CAR_RZC_HONDA_16Civic_Vsceen_H /* 1114410 */:
            case FinalCanbus.CAR_BNR_NISSAN_08TianLai_H /* 1114436 */:
            case FinalCanbus.CAR_BNR_XP1_New_GL8_ES_L /* 1114491 */:
            case FinalCanbus.CAR_RZC_18KeLeiAo_L /* 1114514 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_18 /* 1179709 */:
            case FinalCanbus.CAR_BNR_NISSAN_08TianLai_L /* 1179972 */:
            case FinalCanbus.CAR_BNR_XP1_New_GL8_ES_H /* 1180027 */:
            case FinalCanbus.CAR_BNR_ShuPing_07Corolla /* 1180045 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_19 /* 1245245 */:
            case FinalCanbus.CAR_RZC_HavalH4_20 /* 1245428 */:
            case FinalCanbus.CAR_BNR_NISSAN_11QiDa_H /* 1245508 */:
            case FinalCanbus.CAR_BNR_XP1_WeiLang_L /* 1245563 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_20 /* 1310781 */:
            case FinalCanbus.CAR_BNR_NISSAN_11QiDa_L /* 1311044 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM /* 1311093 */:
            case FinalCanbus.CAR_BNR_XP1_WeiLang_H /* 1311099 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_H /* 1376629 */:
            case FinalCanbus.CAR_BNR_XP1_YingLang_L /* 1376635 */:
            case FinalCanbus.CAR_BNR_12Camry_AMP /* 1376653 */:
            case FinalCanbus.CAR_BNR_XP1_YingLang_H /* 1442171 */:
            case FinalCanbus.CAR_BNR_ShuPing_15_Camery_AMP /* 1442189 */:
            case FinalCanbus.CAR_439_DJ_TOYOTA_08Prado_ShuPing_H /* 1442231 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_23 /* 1507389 */:
            case FinalCanbus.CAR_BNR_ShuPing_12LandCruise_AMP /* 1507725 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_GX50 /* 1507771 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_24 /* 1572925 */:
            case FinalCanbus.CAR_BNR_ShuPing_16LandCruise_AMP /* 1573261 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_ESQ /* 1573316 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_25 /* 1638461 */:
            case FinalCanbus.CAR_BNR_XP1_MairuibaoXL_L /* 1638779 */:
            case FinalCanbus.CAR_RZC_MEGANE_Turkey_L /* 1638802 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_06FX /* 1638852 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_26 /* 1703997 */:
            case FinalCanbus.CAR_BNR_XP1_MairuibaoXL_H /* 1704315 */:
            case FinalCanbus.CAR_RZC_MEGANE_Turkey_M /* 1704338 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_08FX /* 1704388 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_27 /* 1769533 */:
            case FinalCanbus.CAR_BNR_XP1_JunYue_L /* 1769851 */:
            case FinalCanbus.CAR_RZC_MEGANE_Turkey_H /* 1769874 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_G /* 1769924 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_28 /* 1835069 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_M /* 1835381 */:
            case FinalCanbus.CAR_BNR_XP1_JunYue_H /* 1835387 */:
            case FinalCanbus.CAR_439_BNR_LEXUS_ES /* 1835447 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_14QX50 /* 1835460 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_HY /* 1900917 */:
            case FinalCanbus.CAR_BNR_XP1_Mairuibao_Top /* 1900923 */:
            case FinalCanbus.CAR_439_BNR_LEXUS_ES_H /* 1900983 */:
            case FinalCanbus.CAR_443_WC2_Tianlai08_12_GongJue /* 1900987 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_HY_M /* 1966453 */:
            case FinalCanbus.CAR_BNR_XP1_New_Klz_Top /* 1966459 */:
            case FinalCanbus.CAR_BNR_05Reiz /* 1966477 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_14QX70 /* 1966532 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_31 /* 2031677 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_HY_H /* 2031989 */:
            case FinalCanbus.CAR_BNR_XP1_OldJunYue_L /* 2031995 */:
            case FinalCanbus.CAR_RZC_CLIO5_Turkey /* 2032018 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_13Q70L /* 2032068 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_32 /* 2097213 */:
            case FinalCanbus.CAR_BNR_XP1_OldJunYue_H /* 2097531 */:
            case FinalCanbus.CAR_RZC_CLIO5_Turkey_M /* 2097554 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_33 /* 2162749 */:
            case FinalCanbus.CAR_BNR_12Crown_L /* 2163085 */:
            case FinalCanbus.CAR_RZC_CLIO5_Turkey_H /* 2163090 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_34 /* 2228285 */:
            case FinalCanbus.CAR_BNR_12Crown_M /* 2228621 */:
            case FinalCanbus.CAR_RZC_MEGANE_Turkey_L_AUTO /* 2228626 */:
            case FinalCanbus.CAR_452_XP_Megane4_SP_L_HAND /* 2228676 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_35 /* 2293821 */:
            case FinalCanbus.CAR_BNR_12Crown_H /* 2294157 */:
            case FinalCanbus.CAR_452_XP_Megane4_SP_L_AUTO /* 2294212 */:
            case FinalCanbus.CAR_BNR_RZC_Mairuibao_L /* 2359675 */:
            case FinalCanbus.CAR_452_XP_Megane4_SP_H_AUTO /* 2359748 */:
            case FinalCanbus.CAR_BNR_RZC_Mairuibao_H /* 2425211 */:
            case FinalCanbus.CAR_BNR_RZC_Mairuibao_Top /* 2490747 */:
            case FinalCanbus.CAR_BNR_07_15LandCruise_AMP /* 2621837 */:
            case FinalCanbus.CAR_BNR_07_15LandCruise /* 2687373 */:
            case FinalCanbus.CAR_RZC_12Camry /* 2752909 */:
            case FinalCanbus.CAR_RZC_ShuPing_15_Camery /* 2818445 */:
            case FinalCanbus.CAR_RZC_ShuPing_12LandCruise /* 2883981 */:
            case FinalCanbus.CAR_RZC_ShuPing_16LandCruise /* 2949517 */:
            case FinalCanbus.CAR_RZC_ShuPing_09Camery /* 3015053 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_IS /* 3080631 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_IS_H /* 3146167 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_ES /* 3211703 */:
            case FinalCanbus.CAR_RZC_ShuPing_09HighLand_L /* 3277197 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_ES_H /* 3277239 */:
            case FinalCanbus.CAR_RZC_ShuPing_09HighLand_H /* 3342733 */:
            case FinalCanbus.CAR_RZC_ShuPing_07Corolla /* 3408269 */:
            case FinalCanbus.CAR_RZC_ShuPing_14Corolla /* 3473805 */:
            case FinalCanbus.CAR_RZC_12Camry_AMP /* 3604877 */:
            case FinalCanbus.CAR_RZC_BMW_X3_11_13 /* 3670067 */:
            case FinalCanbus.CAR_RZC_ShuPing_15_Camery_AMP /* 3670413 */:
            case FinalCanbus.CAR_RZC_BMW_X3_13_16 /* 3735603 */:
            case FinalCanbus.CAR_RZC_ShuPing_12LandCruise_AMP /* 3735949 */:
            case FinalCanbus.CAR_RZC_BMW_X3_16_17 /* 3801139 */:
            case FinalCanbus.CAR_RZC_ShuPing_16LandCruise_AMP /* 3801485 */:
            case FinalCanbus.CAR_RZC_Turkey_16KADJAR_L /* 3801490 */:
            case FinalCanbus.CAR_RZC_BMW_3_13_17 /* 3866675 */:
            case FinalCanbus.CAR_RZC_Turkey_16KADJAR_M /* 3867026 */:
            case FinalCanbus.CAR_RZC_Turkey_16KADJAR_H /* 3932562 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_12FX /* 3998148 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_15Q50L /* 4063684 */:
            case FinalCanbus.CAR_RZC_BMW_CCC /* 4128819 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_12JX35 /* 4129220 */:
            case FinalCanbus.CAR_RZC_05Reiz /* 4194701 */:
            case FinalCanbus.CAR_RZC_BMW_EVO /* 4390963 */:
            case FinalCanbus.CAR_RZC_12Crown_L /* 4391309 */:
            case FinalCanbus.CAR_RZC_12Crown_M /* 4456845 */:
            case FinalCanbus.CAR_RZC_12Crown_H /* 4522381 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_10G37 /* 4587963 */:
            case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD /* 4719035 */:
            case FinalCanbus.CAR_RZC_07_15LandCruise_AMP /* 4850061 */:
            case FinalCanbus.CAR_RZC_07_15LandCruise /* 4915597 */:
            case FinalCanbus.CAR_439_RZC_TuDa /* 4915639 */:
            case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD_HW /* 4915643 */:
            case FinalCanbus.CAR_RZC_18Camery /* 4981133 */:
            case FinalCanbus.CAR_RZC_16_18RAV4 /* 5046669 */:
            case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
            case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_16Q50l_SP /* 5308859 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
            case FinalCanbus.CAR_439_RZC_14QiJun_Auto /* 5374391 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
            case FinalCanbus.CAR_439_RZC_14QiJun_Hand /* 5439927 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
            case FinalCanbus.CAR_439_RZC_16Xiaoke_Auto /* 5505463 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
            case FinalCanbus.CAR_439_RZC_16Xiaoke_Hand /* 5570999 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
            case FinalCanbus.CAR_439_RZC_13Tianlai_Auto /* 5636535 */:
            case FinalCanbus.CAR_RZC_13Reiz_TOP /* 5702029 */:
            case FinalCanbus.CAR_439_RZC_13Tianlai_Hand /* 5702071 */:
            case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9 /* 5702084 */:
            case FinalCanbus.CAR_RZC_12Reiz /* 5767565 */:
            case FinalCanbus.CAR_439_RZC_08Tianlai_Auto /* 5767607 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
            case FinalCanbus.CAR_439_RZC_08Tianlai_Hand /* 5833143 */:
            case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_Auto /* 5833156 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
            case FinalCanbus.CAR_439_RZC_16Qida_Auto /* 5898679 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
            case FinalCanbus.CAR_RZC_Turkey_22KADJAR_M /* 5964178 */:
            case FinalCanbus.CAR_439_RZC_16Qida_Hand /* 5964215 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_11FX35 /* 6095291 */:
            case FinalCanbus.CAR_439_HC_Nissan_XiaoKe /* 6685111 */:
            case FinalCanbus.CAR_LUZ_Toyato_All /* 7274935 */:
            case FinalCanbus.CAR_LUZ_Toyato_All_H /* 7340471 */:
            case FinalCanbus.CAR_BNR_02_09Toyato_Prado /* 7668151 */:
            case FinalCanbus.CAR_452_TangDu_Nissan_Tuda_Hand /* 7668164 */:
            case FinalCanbus.CAR_BNR_02_09Toyato_Prado_H /* 7733687 */:
            case FinalCanbus.CAR_452_TangDu_Nissan_Tuda_Auto /* 7733700 */:
            case FinalCanbus.CAR_452_LZ_Volvo /* 7995844 */:
            case FinalCanbus.CAR_LUZ_Toyato_20All /* 8126903 */:
            case FinalCanbus.CAR_453_LZ_Toyota_Tacoma_11 /* 8126917 */:
            case FinalCanbus.CAR_LUZ_Toyato_30All /* 8192439 */:
            case FinalCanbus.CAR_453_LZ_Toyota_Tacoma_05 /* 8192453 */:
            case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_EV /* 10355140 */:
            case FinalCanbus.CAR_439_RZC_TuDa_Hand /* 11207095 */:
            case FinalCanbus.CAR_439_LZ_INFINIT_FX35 /* 12714423 */:
            case FinalCanbus.CAR_452_LZ_Volvo_10 /* 13631940 */:
            case FinalCanbus.CAR_439_DJ_Siyu /* 14549431 */:
            case FinalCanbus.CAR_452_LZ_Volvo_15 /* 16515524 */:
                DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                break;
            case 334:
            case 403:
            case FinalCanbus.CAR_BNR_XP1_ShuPingFord_YIHU /* 65939 */:
            case FinalCanbus.CAR_BNR_XP1_ShuPingFord_YIHU_H /* 131475 */:
            case FinalCanbus.CAR_BNR_KX_ShuPingFord_Mengdiou /* 197011 */:
            case FinalCanbus.CAR_RZC_ZhiSheng_Old /* 262478 */:
            case FinalCanbus.CAR_RZC_Ford_Lincoln_navigator /* 1900878 */:
            case FinalCanbus.CAR_RZC_Ford_F150_12 /* 2294094 */:
            case FinalCanbus.CAR_RZC_Mustang_NO_CD /* 2359630 */:
            case FinalCanbus.CAR_RZC_LHT_Ford_F150_Auto /* 2425166 */:
            case FinalCanbus.CAR_RZC_Mustang_15_NO_CD /* 2621774 */:
            case FinalCanbus.CAR_RZC_Mustang_HY_LEFT /* 2687310 */:
            case FinalCanbus.CAR_RZC_Mustang_HY_RIGHT /* 2752846 */:
            case FinalCanbus.CAR_RZC_Mustang_HY_LOW /* 2818382 */:
            case FinalCanbus.CAR_RZC_Mustang_HY_H /* 2883918 */:
            case FinalCanbus.CAR_RZC_Ford_F150 /* 3080526 */:
                if (data1 == 1) {
                    RzcKlcFunc.CAR_AIR_CONTROL(172, data0);
                    break;
                } else if (data1 == 0) {
                    RzcKlcFunc.CAR_AIR_CONTROL(172, 0);
                    break;
                }
            case 374:
            case FinalCanbus.CAR_XP1_ZiYouGuang_H /* 65910 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{1, data0}, null, null);
                    break;
                }
            case 423:
            case 427:
            case FinalCanbus.CAR_CYT_ShuPing_QiYaK3_H /* 65959 */:
            case FinalCanbus.CAR_XFY_SHUPING_K3_M /* 65963 */:
            case FinalCanbus.CAR_XFY_SHUPING_K3_H /* 131499 */:
            case FinalCanbus.CAR_WC_16_QiYaKX5_WITH_CYT_SHUPING_K3AIR /* 262538 */:
            case FinalCanbus.CAR_BNR_ShuPing_Sonata8 /* 393571 */:
            case FinalCanbus.CAR_BNR_ShuPing_Sonata8_AMP /* 459107 */:
            case FinalCanbus.CAR_452_XFY_PSA_3008_L /* 1114564 */:
            case FinalCanbus.CAR_452_XFY_PSA_3008_H /* 1180100 */:
            case FinalCanbus.CAR_RZC_LHT_Ford_F150_Hand /* 2490702 */:
            case FinalCanbus.CAR_439_XBS_09Tianlai /* 4063671 */:
            case FinalCanbus.CAR_439_XFY_SanLing_13Oulande_H /* 4981175 */:
            case FinalCanbus.CAR_439_XFY_SanLing_17Oulande_H /* 5046711 */:
            case FinalCanbus.CAR_439_XFY_SanLing_Tai_Pajieluo_H /* 5112247 */:
            case FinalCanbus.CAR_439_XFY_SanLing_13Oulande_Low /* 5177783 */:
            case FinalCanbus.CAR_439_XFY_SanLing_17Oulande_Low /* 5243319 */:
            case FinalCanbus.CAR_439_XFY_SanLing_Tai_Pajieluo_Low /* 5308855 */:
            case FinalCanbus.CAR_452_CYT_Hyundai_VERACRUZ /* 5767620 */:
            case FinalCanbus.CAR_452_XBS_Nissan_Cedric /* 7143876 */:
            case FinalCanbus.CAR_452_OD_LandRover_Freelander /* 7799236 */:
            case FinalCanbus.CAR_452_OD_Lamborghini /* 7930308 */:
            case FinalCanbus.CAR_452_LZ_Audi_A3_SP /* 9306564 */:
            case FinalCanbus.CAR_452_LZ_Audi_A4_SP /* 9372100 */:
            case FinalCanbus.CAR_452_LZ_Audi_TT_SP /* 9437636 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_outlander_13_H /* 9634244 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_outlander_17_H /* 9699780 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_16_H /* 9765316 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_outlander_13_L /* 9830852 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_outlander_17_L /* 9896388 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_16_L /* 9961924 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_V97_H /* 10027460 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_V97_L /* 10092996 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_20_H /* 10158532 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_20_L /* 10224068 */:
            case FinalCanbus.CAR_452_KYC_Zhonghua_All /* 10617284 */:
            case FinalCanbus.CAR_452_KYC_Zhonghua_All_H /* 10682820 */:
            case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7 /* 10748356 */:
            case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7_H /* 10813892 */:
            case FinalCanbus.CAR_452_LZ_Audi_A3_SP_H /* 11076036 */:
            case FinalCanbus.CAR_452_LZ_Audi_A4_SP_H /* 11141572 */:
            case FinalCanbus.CAR_452_LZ_Audi_TT_SP_H /* 11207108 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0}, null, null);
                    break;
                }
            case 425:
            case FinalCanbus.CAR_CYT_YaGe7_Portrait /* 65953 */:
            case FinalCanbus.CAR_XFY_ShuPing_Honda_GuanDao_H /* 65961 */:
            case FinalCanbus.CAR_CYT_YaGe8 /* 197025 */:
            case FinalCanbus.CAR_XFY_ShuPing_Honda_06CRV /* 262569 */:
            case FinalCanbus.CAR_RCW_BYD_10_11F6 /* 328097 */:
            case FinalCanbus.CAR_RCW_BYD_10_13G6 /* 393633 */:
            case FinalCanbus.CAR_453_RCW_Honda_YaGe7 /* 8520133 */:
            case FinalCanbus.CAR_439_RCW_BYD_12_18Surui /* 9699767 */:
            case FinalCanbus.CAR_439_RCW_BYD_14_15G5 /* 9765303 */:
            case FinalCanbus.CAR_439_RCW_BYD_10_15M6 /* 9830839 */:
            case FinalCanbus.CAR_439_RCW_BYD_13_17S7 /* 9896375 */:
            case FinalCanbus.CAR_439_RCW_BYD_16_19Song /* 9961911 */:
            case FinalCanbus.CAR_439_RCW_BYD_17_19SongMax /* 10027447 */:
            case FinalCanbus.CAR_439_RCW_BYD_12_17E6 /* 10092983 */:
            case FinalCanbus.CAR_453_RCW_BYD_10_13G6 /* 13042117 */:
                if (data1 != 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                    break;
                }
            case FinalCanbus.CAR_WC2_DaZhong_TuRui /* 131342 */:
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_POWER) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_POWER] == 1) {
                            DataCanbus.PROXY.cmd(22, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_POWER] == 0) {
                            DataCanbus.PROXY.cmd(22, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_UP) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT] == 1) {
                            DataCanbus.PROXY.cmd(22, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT] == 0) {
                            DataCanbus.PROXY.cmd(22, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODY) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT] == 1) {
                            DataCanbus.PROXY.cmd(22, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT] == 0) {
                            DataCanbus.PROXY.cmd(22, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_FOOT) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT] == 1) {
                            DataCanbus.PROXY.cmd(22, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT] == 0) {
                            DataCanbus.PROXY.cmd(22, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_STEER) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_STEER] == 1) {
                            DataCanbus.PROXY.cmd(22, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_STEER] == 0) {
                            DataCanbus.PROXY.cmd(22, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_FRONT_HOT) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT_HOT] == 1) {
                            DataCanbus.PROXY.cmd(22, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT_HOT] == 0) {
                            DataCanbus.PROXY.cmd(22, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_AUTO) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO_LEV] == 1) {
                            DataCanbus.PROXY.cmd(22, new int[]{data0, 2}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO_LEV] == 2) {
                            DataCanbus.PROXY.cmd(22, new int[]{data0}, null, null);
                            break;
                        } else {
                            DataCanbus.PROXY.cmd(22, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            DataCanbus.PROXY.cmd(22, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 0) {
                            DataCanbus.PROXY.cmd(22, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        int value5 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] + 1;
                        if (value5 > 7) {
                            value5 = 7;
                        }
                        DataCanbus.PROXY.cmd(22, new int[]{data0 & 15, value5}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        int value6 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] - 1;
                        if (value6 < 0) {
                            value6 = 0;
                        }
                        DataCanbus.PROXY.cmd(22, new int[]{data0 & 15, value6}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD) {
                        int value7 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] & 255;
                        if (value7 == 254) {
                            value4 = 34;
                        } else if (value7 == 255) {
                            value4 = 255;
                        } else {
                            value4 = value7 + 2;
                        }
                        if (value4 > 62) {
                            value4 = 255;
                        }
                        DataCanbus.PROXY.cmd(22, new int[]{data0 & 15, value4}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                        int value8 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] & 255;
                        if (value8 == 255) {
                            value3 = 62;
                        } else if (value8 == 254) {
                            value3 = 254;
                        } else {
                            value3 = value8 - 2;
                        }
                        if (value3 < 34) {
                            value3 = 254;
                        }
                        DataCanbus.PROXY.cmd(22, new int[]{data0 & 15, value3}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        int value9 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_RIGHT] & 255;
                        if (value9 == 254) {
                            value2 = 34;
                        } else if (value9 == 255) {
                            value2 = 255;
                        } else {
                            value2 = value9 + 2;
                        }
                        if (value2 > 62) {
                            value2 = 255;
                        }
                        DataCanbus.PROXY.cmd(22, new int[]{data0 & 15, value2}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        int value10 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_RIGHT] & 255;
                        if (value10 == 255) {
                            value = 62;
                        } else if (value10 == 254) {
                            value = 254;
                        } else {
                            value = value10 - 2;
                        }
                        if (value < 34) {
                            value = 254;
                        }
                        DataCanbus.PROXY.cmd(22, new int[]{data0 & 15, value}, null, null);
                        break;
                    }
                }
                break;
            case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6 /* 131379 */:
            case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6_H /* 196915 */:
                int ints0 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints02 = ints0 | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_AC_MAX ? 1 : 0);
                int ints1 = 0 | (data0 == ConstAllAirDara.C_AIR_DUAL ? 8 : 0);
                int ints12 = ints1 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints2 = 0 | (data0 == ConstAllAirDara.C_AIR_MODE_UP ? 160 : 0);
                int ints22 = ints2 | (data0 == ConstAllAirDara.C_AIR_MODE_BODY ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_FOOT ? 96 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT ? 128 : 0) | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 1 : 0);
                int ints3 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints32 = ints3 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints4 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                int ints42 = ints4 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints02, ints12, ints22, ints32, ints42, 0}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                    break;
                }
            case FinalCanbus.CAR_RZC_DaZhong_SUP /* 196659 */:
            case FinalCanbus.CAR_RZC_DaZhong_SUP_H /* 262195 */:
            case FinalCanbus.CAR_RZC_HavalLow_H2_HongBiao /* 327924 */:
            case FinalCanbus.CAR_RZC_DaZhong_SUP_M /* 458803 */:
            case FinalCanbus.CAR_RZC_DaZhong_MQB_SUP /* 458912 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6 /* 458996 */:
            case FinalCanbus.CAR_RZC_DaZhong_MQB_SUP_H /* 524448 */:
            case FinalCanbus.CAR_RZC_BenTeng_OLDB50 /* 786845 */:
            case FinalCanbus.CAR_RZC_XP1_M6_17 /* 917748 */:
            case FinalCanbus.CAR_RZC_HavalLow_Changchengpao_19 /* 1114356 */:
            case FinalCanbus.CAR_RZC_HavalLow_Changchengpao_19_L /* 2294004 */:
                int ints03 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints04 = ints03 | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_AC_MAX ? 1 : 0);
                int ints13 = 0 | (data0 == ConstAllAirDara.C_AIR_DUAL ? 8 : 0);
                int ints14 = ints13 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints23 = 0 | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 1 : 0);
                int ints33 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints34 = ints33 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints43 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                int ints44 = ints43 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                int ints5 = 0 | (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT ? 2 : 0);
                int ints52 = ints5 | (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT ? 1 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints04, ints14, ints23, ints34, ints44, ints52}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                    break;
                }
            case FinalCanbus.CAR_BoGoo_XP1_ShuPing_GrdCherokee_CYT_AIRPANEL /* 262515 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                    break;
                }
            case FinalCanbus.CAR_RZC_Nissan_Qijun_HW /* 590014 */:
                int ints05 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints06 = ints05 | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0);
                if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                        ints06 = 8;
                    } else {
                        ints06 = 4;
                    }
                }
                int ints15 = 0 | (data0 == ConstAllAirDara.C_AIR_DUAL ? 8 : 0);
                int ints16 = ints15 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints24 = 0 | (data0 == ConstAllAirDara.C_AIR_MODE_UP ? 1 : 0);
                int ints25 = ints24 | (data0 == ConstAllAirDara.C_AIR_MODE_BODY ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_FOOT ? 8 : 0);
                int ints35 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints36 = ints35 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints45 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                int ints46 = ints45 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints06, ints16, ints25, ints36, ints46}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[5], null, null);
                    break;
                }
            case FinalCanbus.CAR_RZC4_PSA_19_408 /* 590163 */:
            case FinalCanbus.CAR_RZC4_PSA_19_408_H /* 655699 */:
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_AUTO) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 1) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 0) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_AC) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 1) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 0) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_AC_MAX) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC_MAX] == 1) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC_MAX] == 0) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD) {
                        DataCanbus.PROXY.cmd(87, new int[]{4, 1}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                        DataCanbus.PROXY.cmd(87, new int[]{4, 2}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        DataCanbus.PROXY.cmd(87, new int[]{5, 1}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        DataCanbus.PROXY.cmd(87, new int[]{5, 2}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_UP) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT] == 1) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT] == 0) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODY) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT] == 1) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT] == 0) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_FOOT) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT] == 1) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT] == 0) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_WINLEV) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_WINLEV] == 0) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0, 1}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_WINLEV] == 1) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0, 2}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_WINLEV] == 2) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        DataCanbus.PROXY.cmd(87, new int[]{10, 1}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        DataCanbus.PROXY.cmd(87, new int[]{10, 2}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_DUAL) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_DUAL] == 1) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_DUAL] == 0) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_POWER) {
                        DataCanbus.PROXY.cmd(87, new int[]{data0}, null, null);
                        DataCanbus.PROXY.cmd(87, new int[]{data0, 1}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_AQS) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AQS] == 1) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AQS] == 0) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        DataCanbus.PROXY.cmd(87, new int[]{data0}, null, null);
                        DataCanbus.PROXY.cmd(87, new int[]{data0, 1}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_REAR_CTRL) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_CTRL] == 1) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_CTRL] == 0) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 1) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 0) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST) {
                        DataCanbus.PROXY.cmd(87, new int[]{data0}, null, null);
                        DataCanbus.PROXY.cmd(87, new int[]{data0, 1}, null, null);
                        break;
                    }
                }
                break;
            case FinalCanbus.CAR_WC2_PSAALL_10 /* 655612 */:
            case FinalCanbus.CAR_WC2_PSAALL_407_06 /* 1245436 */:
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_AUTO) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 1) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 0) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_AC) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 1) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 0) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_AC_MAX) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC_MAX] == 1) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC_MAX] == 0) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD) {
                        DataCanbus.PROXY.cmd(106, new int[]{12, 1}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                        DataCanbus.PROXY.cmd(106, new int[]{12, 2}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        DataCanbus.PROXY.cmd(106, new int[]{13, 1}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        DataCanbus.PROXY.cmd(106, new int[]{13, 2}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_UP) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT] == 1) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT] == 0) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODY) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT] == 1) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT] == 0) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_FOOT) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT] == 1) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT] == 0) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_WINLEV) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_WINLEV] == 0) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0, 1}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_WINLEV] == 1) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0, 2}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_WINLEV] == 2) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        DataCanbus.PROXY.cmd(106, new int[]{11, 1}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        DataCanbus.PROXY.cmd(106, new int[]{11, 2}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_DUAL) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_DUAL] == 1) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_DUAL] == 0) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_POWER) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_POWER] == 1) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_POWER] == 0) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_AQS) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AQS] == 1) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AQS] == 0) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0, 1}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 0) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 1) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 0) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 1) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 0) {
                            DataCanbus.PROXY.cmd(106, new int[]{data0, 1}, null, null);
                            break;
                        }
                    }
                }
                break;
            case FinalCanbus.CAR_452_LZ_Jaguar_XK /* 3670468 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{8, data0}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{8}, null, null);
                    break;
                }
            case FinalCanbus.CAR_439_RZC_ChangAn_CX70 /* 4391351 */:
            case FinalCanbus.CAR_439_RZC_ChangAn_OUSAN_KESAI /* 7471543 */:
            case FinalCanbus.CAR_452_RZC_ChangAn_KESAI_Pro_21 /* 11010500 */:
                int ints07 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints08 = ints07 | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0);
                if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                    if (DataCanbus.DATA[1000] == 4391351) {
                        ints08 = 4;
                    } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                        ints08 = 8;
                    } else {
                        ints08 = 4;
                    }
                }
                int ints09 = ints08 | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0);
                int ints17 = 0 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0);
                int ints18 = ints17 | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints26 = 0 | (data0 == ConstAllAirDara.C_AIR_MODE_BODY ? 2 : 0);
                int ints27 = ints26 | (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_FOOT ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT ? 16 : 0);
                int ints37 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints38 = ints37 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints53 = 0 | (data0 == ConstAllAirDara.C_REAR_CTRL ? 4 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints09, ints18, ints27, ints38, 0, ints53}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                    break;
                }
            case FinalCanbus.CAR_452_OD_HuaChen_SWM_X7 /* 8323524 */:
            case FinalCanbus.CAR_452_OD_HuaChen_SWM_X7_H /* 8389060 */:
            case FinalCanbus.CAR_452_OD_HuaChen_SWM_G05 /* 15335876 */:
            case FinalCanbus.CAR_452_OD_HuaChen_SWM_G05_H /* 15401412 */:
                if (data0 != 255) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                    break;
                }
            default:
                RzcKlcFunc.CAR_AIR_CONTROL(data0, data1);
                break;
        }
    }

    public void initCallbackId() {
        ConstAllAirDara.initClearAllId();
        switch (DataCanbus.DATA[1000]) {
            case 21:
            case FinalCanbus.CAR_WC2_MengDiOuZS2013_M /* 65557 */:
            case FinalCanbus.CAR_WC2_MengDiOuZS2013_H /* 131093 */:
            case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL /* 196629 */:
            case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL_M /* 262165 */:
            case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL_H /* 327701 */:
                ConstAllAirDara.U_AIR_AC = 5;
                ConstAllAirDara.U_AIR_AC_MAX = 10;
                ConstAllAirDara.U_AIR_FRONTMAX = 3;
                ConstAllAirDara.U_AIR_POWER = 14;
                ConstAllAirDara.U_AIR_CYCLE = 2;
                ConstAllAirDara.U_AIR_AUTO = 1;
                ConstAllAirDara.U_AIR_REAR = 4;
                ConstAllAirDara.U_AIR_DUAL = 12;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 9;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 7;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 8;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 11;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 6;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 13;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_AC_MAX = 26;
                ConstAllAirDara.C_AIR_DUAL = 3;
                ConstAllAirDara.C_AIR_MODE_UP = 8;
                ConstAllAirDara.C_AIR_MODE_BODY = 9;
                ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                if (DataCanbus.DATA[1000] == 327701) {
                    ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 27;
                    ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                    ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 26;
                    ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                }
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case 276:
                ConstAllAirDara.TEMPERATURE_LOW = 1;
                ConstAllAirDara.TEMPERATURE_HIGHT = 15;
                ConstAllAirDara.TEMPERATURE_NONE = -1;
                ConstAllAirDara.U_AIR_AC = 17;
                ConstAllAirDara.U_AIR_AUTO = 24;
                ConstAllAirDara.U_AIR_DUAL = 25;
                ConstAllAirDara.U_AIR_FRONT = 19;
                ConstAllAirDara.U_AIR_REAR = 20;
                ConstAllAirDara.U_AIR_CYCLE = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 12;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 11;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 21;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 15;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 14;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 13;
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
            case 334:
            case FinalCanbus.CAR_RZC_ZhiSheng_Old /* 262478 */:
            case FinalCanbus.CAR_RZC_Ford_Lincoln_navigator /* 1900878 */:
            case FinalCanbus.CAR_RZC_Ford_F150_12 /* 2294094 */:
            case FinalCanbus.CAR_RZC_Mustang_NO_CD /* 2359630 */:
            case FinalCanbus.CAR_RZC_LHT_Ford_F150_Auto /* 2425166 */:
            case FinalCanbus.CAR_RZC_Mustang_15_NO_CD /* 2621774 */:
            case FinalCanbus.CAR_RZC_Mustang_HY_LEFT /* 2687310 */:
            case FinalCanbus.CAR_RZC_Mustang_HY_RIGHT /* 2752846 */:
            case FinalCanbus.CAR_RZC_Mustang_HY_LOW /* 2818382 */:
            case FinalCanbus.CAR_RZC_Mustang_HY_H /* 2883918 */:
            case FinalCanbus.CAR_RZC_Ford_F150 /* 3080526 */:
                ConstAllAirDara.TEMPERATURE_LOW = 1048576;
                ConstAllAirDara.TEMPERATURE_HIGHT = FinalCanbus.CAR_WC1_VW_Polo_08_18;
                ConstAllAirDara.TEMPERATURE_NONE = 1048578;
                ConstAllAirDara.C_CONTRAL = 1;
                ConstAllAirDara.U_AIR_AC = 16;
                ConstAllAirDara.U_AIR_FRONT = 17;
                ConstAllAirDara.U_AIR_CYCLE = 18;
                ConstAllAirDara.U_AIR_AUTO = 19;
                ConstAllAirDara.U_AIR_DUAL = 26;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 22;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 23;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 24;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 25;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 28;
                ConstAllAirDara.U_AIR_AC_MAX = 27;
                ConstAllAirDara.U_AIR_REAR = 48;
                ConstAllAirDara.U_AIR_STEER = 112;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 54;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 55;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 7;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 9;
                ConstAllAirDara.C_AIR_STEER = 11;
                if (DataCanbus.DATA[1000] != 2294094 && DataCanbus.DATA[1000] != 3080526) {
                    ConstAllAirDara.U_AIR_SEATWIND_LEFT = 54;
                    ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 55;
                    ConstAllAirDara.C_AIR_LEFT_COLD = 8;
                    ConstAllAirDara.C_AIR_RIGHT_COLD = 10;
                } else if (DataCanbus.DATA[1000] == 262478) {
                    ConstAllAirDara.U_AIR_STEER = 255;
                    ConstAllAirDara.C_AIR_STEER = 255;
                    ConstAllAirDara.U_AIR_SEATWIND_LEFT = 255;
                    ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 255;
                    ConstAllAirDara.C_AIR_LEFT_COLD = 255;
                    ConstAllAirDara.C_AIR_RIGHT_COLD = 255;
                } else {
                    ConstAllAirDara.U_AIR_STEER = 255;
                    ConstAllAirDara.C_AIR_STEER = 255;
                    ConstAllAirDara.U_AIR_SEATWIND_LEFT = 255;
                    ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 255;
                    ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 255;
                    ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 255;
                    ConstAllAirDara.C_AIR_LEFT_COLD = 255;
                    ConstAllAirDara.C_AIR_RIGHT_COLD = 255;
                    ConstAllAirDara.C_AIR_LEFT_HEAT = 255;
                    ConstAllAirDara.C_AIR_RIGHT_HEAT = 255;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_AC_MAX = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 25;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_AUTO = 23;
                ConstAllAirDara.C_AIR_DUAL = 24;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 26;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 27;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 28;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 29;
                ConstAllAirDara.C_AIR_WIND_ADD = 30;
                ConstAllAirDara.C_AIR_WIND_SUB = 31;
                if (DataCanbus.DATA[1000] == 3080526 || DataCanbus.DATA[1000] == 2425166) {
                    ConstAllAirDara.C_AIR_MODE_BODYFOOT = 37;
                    ConstAllAirDara.C_AIR_MODE_UPFOOT = 35;
                    ConstAllAirDara.C_AIR_MODE_BODY = 38;
                    ConstAllAirDara.C_AIR_MODE_FOOT = 36;
                } else {
                    ConstAllAirDara.C_AIR_MODE_UP = 32;
                    ConstAllAirDara.C_AIR_MODE_BODY = 33;
                    ConstAllAirDara.C_AIR_MODE_FOOT = 34;
                }
                ConstAllAirDara.C_AIR_MODE_CHANGER = 255;
                if (DataCanbus.DATA[1000] == 2294094 || DataCanbus.DATA[1000] == 2359630 || DataCanbus.DATA[1000] == 3080526) {
                    ConstAllAirDara.U_AIR_AUTO = 255;
                    ConstAllAirDara.U_AIR_DUAL = 255;
                    ConstAllAirDara.C_AIR_AUTO = 255;
                    ConstAllAirDara.C_AIR_DUAL = 255;
                }
                if (DataCanbus.DATA[1000] == 2359630) {
                    ConstAllAirDara.C_AIR_MODE_CHANGER = 48;
                    ConstAllAirDara.C_AIR_MODE_UP = 255;
                    ConstAllAirDara.C_AIR_MODE_BODY = 255;
                    ConstAllAirDara.C_AIR_MODE_FOOT = 255;
                    break;
                }
            case 373:
            case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_H /* 65909 */:
            case FinalCanbus.CAR_RZC_XP1_GrdCherokee /* 196981 */:
            case FinalCanbus.CAR_RZC_17ZhiNanZhe /* 262517 */:
            case FinalCanbus.CAR_RZC_17ZhiNanZhe_H /* 328053 */:
            case FinalCanbus.CAR_RZC_XP1_GrdCherokee_H /* 459125 */:
            case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19 /* 852341 */:
            case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19_H /* 917877 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM /* 1311093 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_H /* 1376629 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_M /* 1835381 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_HY /* 1900917 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_HY_M /* 1966453 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_HY_H /* 2031989 */:
                ConstAllAirDara.U_AIR_AC = 46;
                ConstAllAirDara.U_AIR_POWER = 56;
                ConstAllAirDara.U_AIR_FRONT = 44;
                ConstAllAirDara.U_AIR_CYCLE = 43;
                ConstAllAirDara.U_AIR_AUTO = 42;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 50;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 48;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 49;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 52;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 47;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 55;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 57;
                ConstAllAirDara.U_AIR_SYNC = 59;
                ConstAllAirDara.U_AIR_AC_MAX = 51;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 53;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 54;
                ConstAllAirDara.U_AIR_REAR = 45;
                ConstAllAirDara.U_AIR_STEER = 113;
                ConstAllAirDara.C_AIR_POWER = 9;
                ConstAllAirDara.C_AIR_AC = 17;
                ConstAllAirDara.C_AIR_CYCLE = 19;
                ConstAllAirDara.C_AIR_AC_MAX = 18;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 21;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 22;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 48;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 50;
                ConstAllAirDara.C_AIR_AUTO = 20;
                ConstAllAirDara.C_AIR_SYNC = 23;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 31;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 30;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 33;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 32;
                ConstAllAirDara.C_AIR_WIND_ADD = 29;
                ConstAllAirDara.C_AIR_WIND_SUB = 28;
                ConstAllAirDara.C_AIR_STEER = 52;
                ConstAllAirDara.C_AIR_MODE_BODY = 24;
                ConstAllAirDara.C_AIR_MODE_FOOT = 26;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 25;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 27;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_XP1_GrdCherokee /* 196981 */:
                    case FinalCanbus.CAR_RZC_XP1_GrdCherokee_H /* 459125 */:
                    case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19 /* 852341 */:
                    case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19_H /* 917877 */:
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 111;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 112;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 49;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 51;
                        break;
                    case FinalCanbus.CAR_RZC_Dodge_RAM /* 1311093 */:
                    case FinalCanbus.CAR_RZC_Dodge_RAM_H /* 1376629 */:
                    case FinalCanbus.CAR_RZC_Dodge_RAM_M /* 1835381 */:
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 111;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 112;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 49;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 51;
                        ConstAllAirDara.U_AIR_AC_MAX = 255;
                        break;
                    case FinalCanbus.CAR_RZC_Dodge_RAM_HY /* 1900917 */:
                    case FinalCanbus.CAR_RZC_Dodge_RAM_HY_M /* 1966453 */:
                    case FinalCanbus.CAR_RZC_Dodge_RAM_HY_H /* 2031989 */:
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 111;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 112;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 49;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 51;
                        ConstAllAirDara.U_AIR_AC_MAX = 255;
                        ConstAllAirDara.C_AIR_MODE_BODY = 255;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 255;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 255;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 255;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 53;
                        break;
                }
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case 374:
            case FinalCanbus.CAR_XP1_ZiYouGuang_H /* 65910 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.C_AIR_POWER = 16;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 12;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 14;
                ConstAllAirDara.C_AIR_SYNC = 13;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 5;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 21;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 20;
                ConstAllAirDara.C_AIR_MODE_BODY = 8;
                ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 9;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 11;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                ConstAllAirDara.C_AIR_LEFT_COLD = 22;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 23;
                ConstAllAirDara.C_CONTRAL = 6;
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
            case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
            case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
            case FinalCanbus.CAR_RZC_13Reiz_TOP /* 5702029 */:
            case FinalCanbus.CAR_RZC_12Reiz /* 5767565 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
            case FinalCanbus.CAR_LUZ_Toyato_All /* 7274935 */:
            case FinalCanbus.CAR_LUZ_Toyato_All_H /* 7340471 */:
            case FinalCanbus.CAR_LUZ_Toyato_20All /* 8126903 */:
            case FinalCanbus.CAR_453_LZ_Toyota_Tacoma_11 /* 8126917 */:
            case FinalCanbus.CAR_LUZ_Toyato_30All /* 8192439 */:
            case FinalCanbus.CAR_453_LZ_Toyota_Tacoma_05 /* 8192453 */:
                ConstAllAirDara.U_AIR_AC = 61;
                ConstAllAirDara.U_AIR_FRONT = 66;
                ConstAllAirDara.U_AIR_CYCLE = 62;
                ConstAllAirDara.U_AIR_AUTO = 64;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 67;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 68;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 69;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 70;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 71;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 72;
                ConstAllAirDara.U_AIR_DUAL = 65;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 118;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 119;
                ConstAllAirDara.U_AIR_REAR = 73;
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
                ConstAllAirDara.U_AIR_POWER = 60;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_BNR_ShuPing_15_Camery /* 590221 */:
                    case FinalCanbus.CAR_BNR_ShuPing_15_Camery_AMP /* 1442189 */:
                    case FinalCanbus.CAR_RZC_ShuPing_15_Camery /* 2818445 */:
                    case FinalCanbus.CAR_RZC_ShuPing_15_Camery_AMP /* 3670413 */:
                        ConstAllAirDara.C_AIR_POWER = 1;
                        ConstAllAirDara.U_AIR_POWER = 60;
                        ConstAllAirDara.C_AIR_NANOE = 33;
                        ConstAllAirDara.U_AIR_NANOE = 160;
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
                        ConstAllAirDara.U_AIR_POWER = 60;
                        ConstAllAirDara.C_REAR_CTRL = 42;
                        ConstAllAirDara.U_AIR_REAR_CTRL = 117;
                        ConstAllAirDara.C_CLEAN_AIR = 32;
                        ConstAllAirDara.U_AIR_CLEANAIR = 108;
                        break;
                    case FinalCanbus.CAR_BNR_ShuPing_16LandCruise /* 721293 */:
                    case FinalCanbus.CAR_BNR_ShuPing_16LandCruise_AMP /* 1573261 */:
                    case FinalCanbus.CAR_RZC_ShuPing_16LandCruise /* 2949517 */:
                    case FinalCanbus.CAR_RZC_ShuPing_16LandCruise_AMP /* 3801485 */:
                    case FinalCanbus.CAR_RZC_13Reiz_TOP /* 5702029 */:
                    case FinalCanbus.CAR_RZC_12Reiz /* 5767565 */:
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 8;
                        ConstAllAirDara.C_AIR_POWER = 1;
                        ConstAllAirDara.U_AIR_POWER = 60;
                        ConstAllAirDara.C_REAR_CTRL = 42;
                        ConstAllAirDara.U_AIR_REAR_CTRL = 117;
                        ConstAllAirDara.C_AIR_MODE_ADD = 255;
                        ConstAllAirDara.C_AIR_MODE_SUB = 255;
                        break;
                    case FinalCanbus.CAR_BNR_ShuPing_07Corolla /* 1180045 */:
                    case FinalCanbus.CAR_RZC_ShuPing_07Corolla /* 3408269 */:
                    case FinalCanbus.CAR_RZC_16_18RAV4 /* 5046669 */:
                        ConstAllAirDara.C_AIR_POWER = 1;
                        ConstAllAirDara.U_AIR_POWER = 60;
                        break;
                    case FinalCanbus.CAR_BNR_12Crown_L /* 2163085 */:
                    case FinalCanbus.CAR_BNR_12Crown_M /* 2228621 */:
                    case FinalCanbus.CAR_BNR_12Crown_H /* 2294157 */:
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                        ConstAllAirDara.C_AIR_MODE_ADD = 255;
                        ConstAllAirDara.C_AIR_MODE_SUB = 255;
                        break;
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
                        ConstAllAirDara.C_AIR_MODE_ADD = 255;
                        ConstAllAirDara.C_AIR_MODE_SUB = 255;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 8;
                        ConstAllAirDara.C_AIR_POWER = 1;
                        ConstAllAirDara.U_AIR_POWER = 60;
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 161;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 162;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 12;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 14;
                        break;
                    case FinalCanbus.CAR_LUZ_Toyato_All /* 7274935 */:
                    case FinalCanbus.CAR_LUZ_Toyato_All_H /* 7340471 */:
                    case FinalCanbus.CAR_LUZ_Toyato_20All /* 8126903 */:
                    case FinalCanbus.CAR_LUZ_Toyato_30All /* 8192439 */:
                        ConstAllAirDara.C_AIR_FRONT_DEFROST = 18;
                        ConstAllAirDara.C_AIR_MODE_ADD = 36;
                        ConstAllAirDara.C_AIR_MODE_SUB = 36;
                        ConstAllAirDara.C_AIR_POWER = 1;
                        ConstAllAirDara.U_AIR_POWER = 60;
                        ConstAllAirDara.C_REAR_CTRL = 42;
                        ConstAllAirDara.U_AIR_REAR_CTRL = 117;
                        ConstAllAirDara.C_CLEAN_AIR = 32;
                        ConstAllAirDara.U_AIR_CLEANAIR = 163;
                        ConstAllAirDara.U_AIR_NANOE = 168;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 255;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 255;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 255;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 255;
                        ConstAllAirDara.C_AIR_NANOE = 27;
                        break;
                    case FinalCanbus.CAR_453_LZ_Toyota_Tacoma_11 /* 8126917 */:
                    case FinalCanbus.CAR_453_LZ_Toyota_Tacoma_05 /* 8192453 */:
                        ConstAllAirDara.C_AIR_FRONT_DEFROST = 18;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                        ConstAllAirDara.C_AIR_MODE_ADD = 255;
                        ConstAllAirDara.C_AIR_MODE_SUB = 255;
                        ConstAllAirDara.C_AIR_POWER = 1;
                        ConstAllAirDara.U_AIR_POWER = 60;
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
            case 403:
            case FinalCanbus.CAR_BNR_XP1_ShuPingFord_YIHU /* 65939 */:
            case FinalCanbus.CAR_BNR_XP1_ShuPingFord_YIHU_H /* 131475 */:
            case FinalCanbus.CAR_BNR_KX_ShuPingFord_Mengdiou /* 197011 */:
                ConstAllAirDara.U_AIR_AC = 16;
                ConstAllAirDara.U_AIR_FRONT = 60;
                ConstAllAirDara.U_AIR_FRONTMAX = 17;
                ConstAllAirDara.U_AIR_CYCLE = 18;
                ConstAllAirDara.U_AIR_AUTO = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 22;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 23;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 24;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 25;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 28;
                ConstAllAirDara.U_AIR_DUAL = 26;
                ConstAllAirDara.U_AIR_AC_MAX = 27;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 56;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 57;
                ConstAllAirDara.U_AIR_REAR = 49;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 59;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 58;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_AC_MAX = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 63;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 58;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 59;
                ConstAllAirDara.C_AIR_LEFT_COLD = 60;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 61;
                ConstAllAirDara.C_AIR_AUTO = 23;
                ConstAllAirDara.C_AIR_DUAL = 24;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 49;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 50;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 51;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 52;
                ConstAllAirDara.C_AIR_WIND_ADD = 53;
                ConstAllAirDara.C_AIR_WIND_SUB = 54;
                ConstAllAirDara.C_AIR_MODE_UP = 55;
                ConstAllAirDara.C_AIR_MODE_BODY = 56;
                ConstAllAirDara.C_AIR_MODE_FOOT = 57;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 62;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case 423:
            case FinalCanbus.CAR_CYT_ShuPing_QiYaK3_H /* 65959 */:
                ConstAllAirDara.TEMPERATURE_LOW = 16;
                ConstAllAirDara.TEMPERATURE_HIGHT = 80;
                ConstAllAirDara.TEMPERATURE_NONE = -1;
                ConstAllAirDara.U_AIR_AC = 17;
                ConstAllAirDara.U_AIR_CYCLE = 21;
                ConstAllAirDara.U_AIR_FRONT = 32;
                ConstAllAirDara.U_AIR_REAR = 23;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 24;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 25;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 27;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 28;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 29;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 30;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_CYT_ShuPing_QiYaK3_H /* 65959 */:
                        ConstAllAirDara.U_AIR_AUTO = 33;
                        ConstAllAirDara.U_AIR_DUAL = 22;
                        ConstAllAirDara.C_AIR_SYNC = 8;
                        ConstAllAirDara.C_AIR_AUTO = 2;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case 425:
            case FinalCanbus.CAR_XFY_ShuPing_Honda_GuanDao_H /* 65961 */:
            case FinalCanbus.CAR_XFY_ShuPing_Honda_06CRV /* 262569 */:
                ConstAllAirDara.U_AIR_AC = 17;
                ConstAllAirDara.U_AIR_AUTO = 24;
                ConstAllAirDara.U_AIR_CYCLE = 18;
                ConstAllAirDara.U_AIR_REAR = 20;
                ConstAllAirDara.U_AIR_FRONTMAX = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 13;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 14;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 15;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 12;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 11;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 21;
                if (DataCanbus.DATA[1000] == 425 || DataCanbus.DATA[1000] == 65961) {
                    ConstAllAirDara.U_AIR_SYNC = 25;
                    ConstAllAirDara.C_AIR_SYNC = 8;
                    ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 22;
                    ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 23;
                    ConstAllAirDara.C_AIR_LEFT_HEAT = 13;
                    ConstAllAirDara.C_AIR_RIGHT_HEAT = 14;
                } else {
                    ConstAllAirDara.U_AIR_DUAL = 25;
                    ConstAllAirDara.C_AIR_DUAL = 8;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case 427:
            case FinalCanbus.CAR_XFY_SHUPING_K3_M /* 65963 */:
            case FinalCanbus.CAR_XFY_SHUPING_K3_H /* 131499 */:
                ConstAllAirDara.TEMPERATURE_LOW = 16;
                ConstAllAirDara.TEMPERATURE_HIGHT = 80;
                ConstAllAirDara.TEMPERATURE_NONE = -1;
                ConstAllAirDara.U_AIR_AC = 17;
                ConstAllAirDara.U_AIR_CYCLE = 18;
                ConstAllAirDara.U_AIR_FRONT = 19;
                ConstAllAirDara.U_AIR_REAR = 20;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 13;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 14;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 15;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 12;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 11;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 21;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_AC = 16;
                if (DataCanbus.DATA[1000] == 427) {
                    ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                } else if (DataCanbus.DATA[1000] == 65963) {
                    ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                    ConstAllAirDara.U_AIR_AUTO = 24;
                    ConstAllAirDara.U_AIR_SYNC = 25;
                    ConstAllAirDara.C_AIR_SYNC = 8;
                    ConstAllAirDara.C_AIR_AUTO = 2;
                } else if (DataCanbus.DATA[1000] == 131499) {
                    ConstAllAirDara.C_AIR_MODE_UP = 3;
                    ConstAllAirDara.C_AIR_MODE_BODY = 29;
                    ConstAllAirDara.C_AIR_MODE_FOOT = 31;
                    ConstAllAirDara.U_AIR_AUTO = 24;
                    ConstAllAirDara.U_AIR_SYNC = 25;
                    ConstAllAirDara.C_AIR_SYNC = 8;
                    ConstAllAirDara.C_AIR_AUTO = 2;
                }
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_CYT_YaGe7_Portrait /* 65953 */:
            case FinalCanbus.CAR_CYT_YaGe8 /* 197025 */:
            case FinalCanbus.CAR_RCW_BYD_10_11F6 /* 328097 */:
            case FinalCanbus.CAR_RCW_BYD_10_13G6 /* 393633 */:
                ConstAllAirDara.U_AIR_AC = 15;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 11;
                ConstAllAirDara.U_AIR_DUAL = 22;
                ConstAllAirDara.U_AIR_FRONT = 13;
                ConstAllAirDara.U_AIR_REAR = 14;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 16;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 17;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 19;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 20;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 21;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_CONTRAL = 22;
                break;
            case FinalCanbus.CAR_WC2_DaZhong_TuRui /* 131342 */:
                ConstAllAirDara.TEMPERATURE_LOW = 254;
                ConstAllAirDara.TEMPERATURE_HIGHT = 255;
                ConstAllAirDara.U_AIR_CYCLE = 149;
                ConstAllAirDara.U_AIR_AUTO = 94;
                ConstAllAirDara.U_AIR_AUTO_LEV = 89;
                ConstAllAirDara.U_AIR_POWER = 87;
                ConstAllAirDara.U_AIR_FRONT_HOT = 235;
                ConstAllAirDara.U_AIR_STEER = 234;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 120;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 95;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 96;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 97;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 98;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 99;
                ConstAllAirDara.C_AIR_CYCLE = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_MODE_UP = 3;
                ConstAllAirDara.C_AIR_MODE_BODY = 4;
                ConstAllAirDara.C_AIR_MODE_FOOT = 5;
                ConstAllAirDara.C_AIR_POWER = 6;
                ConstAllAirDara.C_AIR_FRONT_HOT = 11;
                ConstAllAirDara.C_AIR_STEER = 10;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 8;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 248;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 249;
                ConstAllAirDara.C_AIR_WIND_ADD = 7;
                ConstAllAirDara.C_AIR_WIND_SUB = 247;
                ConstAllAirDara.C_CONTRAL = 22;
                break;
            case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6 /* 131379 */:
            case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6_H /* 196915 */:
                ConstAllAirDara.U_AIR_POWER = 0;
                ConstAllAirDara.U_AIR_AC = 1;
                ConstAllAirDara.U_AIR_AC_MAX = 68;
                ConstAllAirDara.U_AIR_CYCLE = 2;
                ConstAllAirDara.U_AIR_REAR = 4;
                ConstAllAirDara.U_AIR_FRONTMAX = 3;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 7;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 8;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 9;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 10;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 5;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 6;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6_H /* 196915 */:
                        ConstAllAirDara.U_AIR_AUTO = 69;
                        ConstAllAirDara.U_AIR_DUAL = 70;
                        ConstAllAirDara.C_AIR_AUTO = 17;
                        ConstAllAirDara.C_AIR_DUAL = 18;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_MODE_UP = 3;
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
            case FinalCanbus.CAR_RZC_DaZhong_SUP /* 196659 */:
            case FinalCanbus.CAR_RZC_DaZhong_SUP_H /* 262195 */:
            case FinalCanbus.CAR_RZC_DaZhong_SUP_M /* 458803 */:
                ConstAllAirDara.TEMPERATURE_NONE = 0;
                ConstAllAirDara.TEMPERATURE_LOW = 15;
                ConstAllAirDara.TEMPERATURE_HIGHT = 49;
                ConstAllAirDara.U_AIR_AC = 17;
                ConstAllAirDara.U_AIR_FRONT = 44;
                ConstAllAirDara.U_AIR_POWER = 14;
                ConstAllAirDara.U_AIR_CYCLE = 19;
                ConstAllAirDara.U_AIR_AUTO = 35;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 22;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 23;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 25;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 26;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_DUAL = 20;
                ConstAllAirDara.U_AIR_AC_MAX = 18;
                ConstAllAirDara.U_AIR_REAR = 21;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 39;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 34;
                ConstAllAirDara.C_CONTRAL = 4;
                if (DataCanbus.DATA[1000] == 262195 || DataCanbus.DATA[1000] == 458803) {
                    ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 30;
                    ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 33;
                    ConstAllAirDara.C_AIR_LEFT_HEAT = 32;
                    ConstAllAirDara.C_AIR_RIGHT_HEAT = 33;
                    break;
                }
            case FinalCanbus.CAR_DJ_ShuPing_BYD_G6 /* 196759 */:
            case FinalCanbus.CAR_DJ_ShuPing_BYD_G6_H /* 262295 */:
                ConstAllAirDara.TEMPERATURE_LOW = 1;
                ConstAllAirDara.TEMPERATURE_HIGHT = 17;
                ConstAllAirDara.TEMPERATURE_NONE = -1;
                ConstAllAirDara.U_AIR_AC = 24;
                ConstAllAirDara.U_AIR_AUTO = 20;
                ConstAllAirDara.U_AIR_DUAL = 30;
                ConstAllAirDara.U_AIR_FRONT = 22;
                ConstAllAirDara.U_AIR_REAR = 23;
                ConstAllAirDara.U_AIR_CYCLE = 21;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 29;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 25;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 31;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 27;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 26;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 28;
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
            case FinalCanbus.CAR_WC2_Honda_AllCom_CIVIC /* 262465 */:
            case FinalCanbus.CAR_WC2_Honda_17CRV /* 459073 */:
            case FinalCanbus.CAR_WC2_Honda_16SIYU_HAND /* 786753 */:
            case FinalCanbus.CAR_WC2_Honda_16SIYU_AUTO /* 852289 */:
                ConstAllAirDara.U_AIR_AC = 30;
                ConstAllAirDara.U_AIR_FRONT = 28;
                ConstAllAirDara.U_AIR_POWER = 38;
                ConstAllAirDara.U_AIR_CYCLE = 27;
                ConstAllAirDara.U_AIR_AUTO = 26;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 34;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 32;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 33;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 35;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 31;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 37;
                ConstAllAirDara.U_AIR_SYNC = 39;
                ConstAllAirDara.U_AIR_REAR = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 78;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 79;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_MODE_BODY = 9;
                ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 24;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 23;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_SYNC = 3;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_CONTRAL = 255;
                break;
            case FinalCanbus.CAR_BoGoo_XP1_ShuPing_GrdCherokee_CYT_AIRPANEL /* 262515 */:
                ConstAllAirDara.TEMPERATURE_LOW = 16;
                ConstAllAirDara.TEMPERATURE_HIGHT = 80;
                ConstAllAirDara.TEMPERATURE_NONE = -1;
                ConstAllAirDara.U_AIR_AC = 43;
                ConstAllAirDara.U_AIR_CYCLE = 40;
                ConstAllAirDara.U_AIR_REAR = 42;
                ConstAllAirDara.U_AIR_FRONT = 41;
                ConstAllAirDara.U_AIR_AUTO = 39;
                ConstAllAirDara.U_AIR_DUAL = 56;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 47;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 45;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 46;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 49;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 44;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 52;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 50;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 51;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 95;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 96;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 13;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                ConstAllAirDara.C_AIR_LEFT_COLD = 45;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 46;
                ConstAllAirDara.C_CONTRAL = 5;
                break;
            case FinalCanbus.CAR_WC_16_QiYaKX5_WITH_CYT_SHUPING_K3AIR /* 262538 */:
                ConstAllAirDara.TEMPERATURE_LOW = 16;
                ConstAllAirDara.TEMPERATURE_HIGHT = 80;
                ConstAllAirDara.TEMPERATURE_NONE = -1;
                ConstAllAirDara.U_AIR_AC = 5;
                ConstAllAirDara.U_AIR_CYCLE = 2;
                ConstAllAirDara.U_AIR_FRONT = 3;
                ConstAllAirDara.U_AIR_REAR = 4;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 9;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 7;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 8;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 10;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 6;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 11;
                ConstAllAirDara.U_AIR_AUTO = 1;
                ConstAllAirDara.U_AIR_SYNC = 15;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_SYNC = 8;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_BNR_17LIENUO_L /* 262546 */:
            case FinalCanbus.CAR_BNR_17LIENUO_M /* 328082 */:
            case FinalCanbus.CAR_BNR_17LIENUO_H /* 393618 */:
            case FinalCanbus.CAR_BNR_17KeLeiJia_L /* 459154 */:
            case FinalCanbus.CAR_BNR_17KeLeiJia_H /* 524690 */:
            case FinalCanbus.CAR_BNR_18KeLeiAo_M /* 590226 */:
                ConstAllAirDara.U_AIR_AC = 108;
                ConstAllAirDara.U_AIR_FRONT = 113;
                ConstAllAirDara.U_AIR_CYCLE = 109;
                ConstAllAirDara.U_AIR_REAR = 112;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 120;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 119;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 118;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 121;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 122;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 123;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                if (DataCanbus.DATA[1000] == 328082 || DataCanbus.DATA[1000] == 393618 || DataCanbus.DATA[1000] == 590226) {
                    ConstAllAirDara.U_AIR_DUAL = 111;
                    ConstAllAirDara.U_AIR_AUTO = 110;
                    ConstAllAirDara.C_AIR_AUTO = 21;
                    ConstAllAirDara.C_AIR_DUAL = 16;
                    ConstAllAirDara.C_AIR_MODE_UP = 55;
                    ConstAllAirDara.C_AIR_MODE_BODY = 56;
                    ConstAllAirDara.C_AIR_MODE_FOOT = 57;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                } else if (DataCanbus.DATA[1000] == 262546 || DataCanbus.DATA[1000] == 459154) {
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 2;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                    ConstAllAirDara.C_AIR_MODE_ADD = 36;
                    ConstAllAirDara.C_AIR_MODE_SUB = 36;
                } else if (DataCanbus.DATA[1000] == 524690) {
                    ConstAllAirDara.U_AIR_DUAL = 111;
                    ConstAllAirDara.U_AIR_AUTO = 110;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                    ConstAllAirDara.C_AIR_AUTO = 2;
                    ConstAllAirDara.C_AIR_DUAL = 3;
                    ConstAllAirDara.C_AIR_MODE_ADD = 36;
                    ConstAllAirDara.C_AIR_MODE_SUB = 36;
                }
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_12Crown_ShuPing /* 262573 */:
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_12Crown_H_ShuPing /* 328109 */:
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_06Prado_ShuPing /* 393645 */:
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_14Prodo_H_ShuPing /* 459181 */:
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_14Prodo_ShuPing /* 524717 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown /* 590253 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown /* 655789 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown_L /* 721325 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown_L /* 786861 */:
            case FinalCanbus.CAR_DJ_XC_Nissan_Tianlai_03_07 /* 852397 */:
                ConstAllAirDara.U_AIR_AC = 12;
                ConstAllAirDara.U_AIR_CYCLE = 13;
                ConstAllAirDara.U_AIR_AUTO = 14;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 22;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 23;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 24;
                ConstAllAirDara.U_AIR_DUAL = 15;
                ConstAllAirDara.U_AIR_REAR = 26;
                ConstAllAirDara.U_AIR_CLEANAIR = 66;
                if (DataCanbus.DATA[1000] == 393645) {
                    ConstAllAirDara.U_AIR_FRONTMAX = 16;
                    ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 4;
                } else if (DataCanbus.DATA[1000] == 590253 || DataCanbus.DATA[1000] == 655789 || DataCanbus.DATA[1000] == 721325 || DataCanbus.DATA[1000] == 786861) {
                    ConstAllAirDara.U_AIR_SWING = 69;
                    ConstAllAirDara.U_AIR_FRONT_HOT = 68;
                    ConstAllAirDara.U_AIR_ION = 67;
                    ConstAllAirDara.U_AIR_FRONTMAX = 16;
                    ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 4;
                    ConstAllAirDara.C_AIR_SWING = 40;
                    ConstAllAirDara.C_AIR_FRONT_HOT = 41;
                    ConstAllAirDara.C_AIR_ION = 39;
                } else {
                    ConstAllAirDara.U_AIR_FRONT = 25;
                    ConstAllAirDara.C_AIR_FRONT_DEFROST = 33;
                }
                ConstAllAirDara.C_AIR_AC = 8;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_AUTO = 1;
                ConstAllAirDara.C_AIR_DUAL = 2;
                ConstAllAirDara.C_CLEAN_AIR = 38;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 9;
                ConstAllAirDara.C_AIR_POWER = 10;
                ConstAllAirDara.C_CONTRAL = 3;
                break;
            case FinalCanbus.CAR_RZC_ALL_GM_SP_5 /* 327741 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_9 /* 589885 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_10 /* 655421 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_13 /* 852029 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_14 /* 917565 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_15 /* 983101 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_16 /* 1048637 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_17 /* 1114173 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_18 /* 1179709 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_19 /* 1245245 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_20 /* 1310781 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_23 /* 1507389 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_24 /* 1572925 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_25 /* 1638461 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_26 /* 1703997 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_27 /* 1769533 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_28 /* 1835069 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_31 /* 2031677 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_32 /* 2097213 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_33 /* 2162749 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_34 /* 2228285 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_35 /* 2293821 */:
                ConstAllAirDara.TEMPERATURE_LOW = 0;
                ConstAllAirDara.TEMPERATURE_HIGHT = 30;
                ConstAllAirDara.TEMPERATURE_NONE = -1;
                ConstAllAirDara.U_AIR_AC = 34;
                ConstAllAirDara.U_AIR_FRONT = 46;
                ConstAllAirDara.U_AIR_REAR = 33;
                ConstAllAirDara.U_AIR_CYCLE = 32;
                ConstAllAirDara.U_AIR_AUTO = 58;
                ConstAllAirDara.U_AIR_SYNC = 57;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 37;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 38;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 42;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 41;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 40;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 39;
                ConstAllAirDara.C_CONTRAL = 10;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_SYNC = 16;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                if (DataCanbus.DATA[1000] == 2031677) {
                    ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 35;
                    ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 36;
                    ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                    ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                    ConstAllAirDara.C_AIR_MODE_BODY = 7;
                    ConstAllAirDara.C_AIR_MODE_BODYFOOT = 33;
                    ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                    ConstAllAirDara.C_AIR_MODE_UPFOOT = 32;
                    break;
                } else if (DataCanbus.DATA[1000] == 2097213) {
                    ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 35;
                    ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 36;
                    ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                    ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                    ConstAllAirDara.C_AIR_MODE_BODY = 7;
                    ConstAllAirDara.C_AIR_MODE_BODYFOOT = 33;
                    ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                    ConstAllAirDara.C_AIR_MODE_UPFOOT = 32;
                    ConstAllAirDara.U_AIR_SYNC = 255;
                    ConstAllAirDara.C_AIR_SYNC = 255;
                    break;
                } else if (DataCanbus.DATA[1000] == 852029 || DataCanbus.DATA[1000] == 2162749 || DataCanbus.DATA[1000] == 2228285) {
                    ConstAllAirDara.U_AIR_AUTO = 255;
                    ConstAllAirDara.U_AIR_SYNC = 255;
                    ConstAllAirDara.C_AIR_MODE_BODY = 7;
                    ConstAllAirDara.C_AIR_MODE_BODYFOOT = 33;
                    ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                    ConstAllAirDara.C_AIR_MODE_UPFOOT = 32;
                    break;
                } else if (DataCanbus.DATA[1000] == 1769533 || DataCanbus.DATA[1000] == 917565) {
                    ConstAllAirDara.C_AIR_MODE_ADD = 37;
                    ConstAllAirDara.C_AIR_MODE_SUB = 38;
                    break;
                } else if (DataCanbus.DATA[1000] == 1835069) {
                    ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 35;
                    ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 36;
                    ConstAllAirDara.U_AIR_SEATWIND_LEFT = 59;
                    ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 60;
                    ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                    ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                    ConstAllAirDara.C_AIR_LEFT_COLD = 12;
                    ConstAllAirDara.C_AIR_RIGHT_COLD = 14;
                    ConstAllAirDara.C_AIR_MODE_ADD = 37;
                    ConstAllAirDara.C_AIR_MODE_SUB = 38;
                    break;
                } else if (DataCanbus.DATA[1000] == 1638461 || DataCanbus.DATA[1000] == 1703997 || DataCanbus.DATA[1000] == 983101 || DataCanbus.DATA[1000] == 1048637) {
                    ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 35;
                    ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 36;
                    ConstAllAirDara.U_AIR_SEATWIND_LEFT = 59;
                    ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 60;
                    ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                    ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                    ConstAllAirDara.C_AIR_LEFT_COLD = 12;
                    ConstAllAirDara.C_AIR_RIGHT_COLD = 14;
                    ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                    break;
                } else if (DataCanbus.DATA[1000] == 655421) {
                    ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 35;
                    ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 36;
                    ConstAllAirDara.U_AIR_SEATWIND_LEFT = 59;
                    ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 60;
                    ConstAllAirDara.C_AIR_MODE_BODY = 7;
                    ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                    ConstAllAirDara.C_AIR_MODE_UP = 6;
                    ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                    ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                    ConstAllAirDara.C_AIR_LEFT_COLD = 12;
                    ConstAllAirDara.C_AIR_RIGHT_COLD = 14;
                    ConstAllAirDara.U_AIR_SYNC = 255;
                    ConstAllAirDara.C_AIR_SYNC = 255;
                    break;
                } else if (DataCanbus.DATA[1000] == 1245245 || DataCanbus.DATA[1000] == 589885) {
                    ConstAllAirDara.U_AIR_SYNC = 255;
                    ConstAllAirDara.C_AIR_SYNC = 255;
                    ConstAllAirDara.C_AIR_MODE_BODY = 7;
                    ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                    ConstAllAirDara.C_AIR_MODE_UP = 6;
                    break;
                } else if (DataCanbus.DATA[1000] == 1114173 || DataCanbus.DATA[1000] == 1507389 || DataCanbus.DATA[1000] == 2293821) {
                    ConstAllAirDara.U_AIR_SYNC = 255;
                    ConstAllAirDara.C_AIR_SYNC = 255;
                    ConstAllAirDara.U_AIR_AUTO = 255;
                    ConstAllAirDara.C_AIR_AUTO = 255;
                    ConstAllAirDara.C_AIR_MODE_BODY = 7;
                    ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                    ConstAllAirDara.C_AIR_MODE_UP = 6;
                    break;
                } else if (DataCanbus.DATA[1000] == 1310781) {
                    ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 35;
                    ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 36;
                    ConstAllAirDara.U_AIR_SYNC = 255;
                    ConstAllAirDara.C_AIR_SYNC = 255;
                    ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                    ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                    ConstAllAirDara.C_AIR_MODE_BODY = 7;
                    ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                    ConstAllAirDara.C_AIR_MODE_UP = 6;
                    break;
                } else if (DataCanbus.DATA[1000] == 1179709) {
                    ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 35;
                    ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 36;
                    ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                    ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                    ConstAllAirDara.C_AIR_MODE_BODY = 7;
                    ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                    ConstAllAirDara.C_AIR_MODE_UP = 6;
                    break;
                } else if (DataCanbus.DATA[1000] == 327741) {
                    ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 35;
                    ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 36;
                    ConstAllAirDara.U_AIR_SEATWIND_LEFT = 59;
                    ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 60;
                    ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                    ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                    ConstAllAirDara.C_AIR_LEFT_COLD = 12;
                    ConstAllAirDara.C_AIR_RIGHT_COLD = 14;
                    ConstAllAirDara.C_AIR_MODE_BODY = 7;
                    ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                    ConstAllAirDara.C_AIR_MODE_UP = 6;
                    break;
                }
            case FinalCanbus.CAR_RZC_HavalLow_H2_HongBiao /* 327924 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6 /* 458996 */:
            case FinalCanbus.CAR_RZC_XP1_M6_17 /* 917748 */:
            case FinalCanbus.CAR_RZC_HavalLow_Changchengpao_19 /* 1114356 */:
            case FinalCanbus.CAR_RZC_HavalLow_Changchengpao_19_L /* 2294004 */:
                ConstAllAirDara.TEMPERATURE_NONE = 0;
                ConstAllAirDara.TEMPERATURE_LOW = 15;
                ConstAllAirDara.TEMPERATURE_HIGHT = 49;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 39;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 34;
                ConstAllAirDara.C_CONTRAL = 4;
                break;
            case FinalCanbus.CAR_BNR_HONDA_16Civic_Vsceen_L /* 393514 */:
            case FinalCanbus.CAR_BNR_HONDA_16Civic_Vsceen_H /* 459050 */:
            case FinalCanbus.CAR_BNR_HONDA_Avancier_Vsceen_NoAmp /* 655658 */:
            case FinalCanbus.CAR_BNR_HONDA_Avancier_Vsceen_Amp_View /* 721194 */:
            case FinalCanbus.CAR_BNR_17CRV /* 983338 */:
            case FinalCanbus.CAR_RZC_HONDA_16Civic_Vsceen_L /* 1048874 */:
            case FinalCanbus.CAR_RZC_HONDA_16Civic_Vsceen_H /* 1114410 */:
                ConstAllAirDara.U_AIR_POWER = 32;
                ConstAllAirDara.U_AIR_AC = 24;
                ConstAllAirDara.U_AIR_FRONT = 22;
                ConstAllAirDara.U_AIR_CYCLE = 21;
                ConstAllAirDara.U_AIR_AUTO = 20;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 28;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 26;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 27;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 29;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 25;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 31;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 33;
                ConstAllAirDara.U_AIR_DUAL = 30;
                ConstAllAirDara.U_AIR_REAR = 23;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_MODE_BODY = 7;
                ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 32;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 33;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 94;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 95;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 96;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 97;
                ConstAllAirDara.C_AIR_LEFT_COLD = 12;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 14;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                if (DataCanbus.DATA[1000] == 655658 || DataCanbus.DATA[1000] == 721194) {
                    ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 91;
                    ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 92;
                    ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 93;
                    ConstAllAirDara.C_AIR_MODE_BODY = 255;
                    ConstAllAirDara.C_AIR_MODE_FOOT = 255;
                    ConstAllAirDara.C_AIR_MODE_UPFOOT = 255;
                    ConstAllAirDara.C_AIR_MODE_BODYFOOT = 255;
                    ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                    ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT = 37;
                }
                ConstAllAirDara.C_CONTRAL = 107;
                break;
            case FinalCanbus.CAR_BNR_ShuPing_Sonata8 /* 393571 */:
            case FinalCanbus.CAR_BNR_ShuPing_Sonata8_AMP /* 459107 */:
                ConstAllAirDara.TEMPERATURE_LOW = 0;
                ConstAllAirDara.TEMPERATURE_HIGHT = 30;
                ConstAllAirDara.TEMPERATURE_NONE = -1;
                ConstAllAirDara.U_AIR_AC = 4;
                ConstAllAirDara.U_AIR_CYCLE = 2;
                ConstAllAirDara.U_AIR_FRONT = 3;
                ConstAllAirDara.U_AIR_REAR = 13;
                ConstAllAirDara.U_AIR_AUTO = 1;
                ConstAllAirDara.U_AIR_DUAL = 10;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 42;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 43;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 8;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 6;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 7;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 9;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 5;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 11;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_MODE_SUB = 7;
                ConstAllAirDara.C_AIR_MODE_ADD = 8;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 33;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 35;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_RZC_DaZhong_MQB_SUP /* 458912 */:
            case FinalCanbus.CAR_RZC_DaZhong_MQB_SUP_H /* 524448 */:
                ConstAllAirDara.TEMPERATURE_NONE = 0;
                ConstAllAirDara.TEMPERATURE_LOW = 15;
                ConstAllAirDara.TEMPERATURE_HIGHT = 49;
                ConstAllAirDara.U_AIR_AC = 91;
                ConstAllAirDara.U_AIR_FRONT = 152;
                ConstAllAirDara.U_AIR_POWER = 87;
                ConstAllAirDara.U_AIR_CYCLE = 122;
                ConstAllAirDara.U_AIR_AUTO = 89;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 120;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 95;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 96;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 97;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 98;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 99;
                ConstAllAirDara.U_AIR_DUAL = 100;
                ConstAllAirDara.U_AIR_AC_MAX = 106;
                ConstAllAirDara.U_AIR_REAR = 123;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 39;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 34;
                ConstAllAirDara.C_CONTRAL = 140;
                if (DataCanbus.DATA[1000] == 524448) {
                    ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 92;
                    ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 93;
                    ConstAllAirDara.C_AIR_LEFT_HEAT = 32;
                    ConstAllAirDara.C_AIR_RIGHT_HEAT = 33;
                    break;
                }
            case FinalCanbus.CAR_BNR_XP1_JunWei /* 459131 */:
            case FinalCanbus.CAR_BNR_XP1_New_KLZ /* 524667 */:
            case FinalCanbus.CAR_BNR_XP1_Mairuibao_L /* 590203 */:
            case FinalCanbus.CAR_BNR_XP1_Mairuibao_H /* 655739 */:
            case FinalCanbus.CAR_BNR_XP1_JunWei_L /* 721275 */:
            case FinalCanbus.CAR_BNR_XP1_JunWei_H /* 786811 */:
            case FinalCanbus.CAR_BNR_XP1_New_YingLang_L /* 983419 */:
            case FinalCanbus.CAR_BNR_XP1_New_YingLang_H /* 1048955 */:
            case FinalCanbus.CAR_BNR_XP1_New_GL8_ES_L /* 1114491 */:
            case FinalCanbus.CAR_BNR_XP1_New_GL8_ES_H /* 1180027 */:
            case FinalCanbus.CAR_BNR_XP1_WeiLang_L /* 1245563 */:
            case FinalCanbus.CAR_BNR_XP1_WeiLang_H /* 1311099 */:
            case FinalCanbus.CAR_BNR_XP1_YingLang_L /* 1376635 */:
            case FinalCanbus.CAR_BNR_XP1_YingLang_H /* 1442171 */:
            case FinalCanbus.CAR_BNR_XP1_MairuibaoXL_L /* 1638779 */:
            case FinalCanbus.CAR_BNR_XP1_MairuibaoXL_H /* 1704315 */:
            case FinalCanbus.CAR_BNR_XP1_JunYue_L /* 1769851 */:
            case FinalCanbus.CAR_BNR_XP1_JunYue_H /* 1835387 */:
            case FinalCanbus.CAR_BNR_XP1_Mairuibao_Top /* 1900923 */:
            case FinalCanbus.CAR_BNR_XP1_New_Klz_Top /* 1966459 */:
            case FinalCanbus.CAR_BNR_XP1_OldJunYue_L /* 2031995 */:
            case FinalCanbus.CAR_BNR_XP1_OldJunYue_H /* 2097531 */:
            case FinalCanbus.CAR_BNR_RZC_Mairuibao_L /* 2359675 */:
            case FinalCanbus.CAR_BNR_RZC_Mairuibao_H /* 2425211 */:
            case FinalCanbus.CAR_BNR_RZC_Mairuibao_Top /* 2490747 */:
                ConstAllAirDara.U_AIR_AC = 93;
                ConstAllAirDara.U_AIR_REAR = 92;
                ConstAllAirDara.U_AIR_CYCLE = 89;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 112;
                ConstAllAirDara.U_AIR_FRONT = 111;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 97;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 98;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 101;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 100;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 99;
                ConstAllAirDara.C_CONTRAL = 10;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_BNR_XP1_JunWei /* 459131 */:
                        ConstAllAirDara.U_AIR_AUTO = 88;
                        ConstAllAirDara.U_AIR_DUAL = 87;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 95;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 96;
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 102;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 106;
                        ConstAllAirDara.C_AIR_AUTO = 21;
                        ConstAllAirDara.C_AIR_DUAL = 16;
                        ConstAllAirDara.C_AIR_MODE_UP = 6;
                        ConstAllAirDara.C_AIR_MODE_BODY = 7;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 12;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 14;
                        break;
                    case FinalCanbus.CAR_BNR_XP1_New_KLZ /* 524667 */:
                    case FinalCanbus.CAR_BNR_XP1_Mairuibao_L /* 590203 */:
                    case FinalCanbus.CAR_BNR_XP1_Mairuibao_H /* 655739 */:
                    case FinalCanbus.CAR_BNR_XP1_New_YingLang_L /* 983419 */:
                    case FinalCanbus.CAR_BNR_RZC_Mairuibao_L /* 2359675 */:
                    case FinalCanbus.CAR_BNR_RZC_Mairuibao_H /* 2425211 */:
                        ConstAllAirDara.C_AIR_MODE_BODY = 7;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 33;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 32;
                        break;
                    case FinalCanbus.CAR_BNR_XP1_JunWei_L /* 721275 */:
                    case FinalCanbus.CAR_BNR_XP1_YingLang_H /* 1442171 */:
                        ConstAllAirDara.U_AIR_AUTO = 88;
                        ConstAllAirDara.C_AIR_AUTO = 21;
                        ConstAllAirDara.C_AIR_MODE_UP = 6;
                        ConstAllAirDara.C_AIR_MODE_BODY = 7;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                        break;
                    case FinalCanbus.CAR_BNR_XP1_JunWei_H /* 786811 */:
                        ConstAllAirDara.U_AIR_AUTO = 88;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 95;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 96;
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 102;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 106;
                        ConstAllAirDara.C_AIR_AUTO = 21;
                        ConstAllAirDara.C_AIR_MODE_UP = 6;
                        ConstAllAirDara.C_AIR_MODE_BODY = 7;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 12;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 14;
                        break;
                    case FinalCanbus.CAR_BNR_XP1_New_YingLang_H /* 1048955 */:
                        ConstAllAirDara.U_AIR_AUTO = 88;
                        ConstAllAirDara.C_AIR_AUTO = 21;
                        ConstAllAirDara.C_AIR_MODE_ADD = 37;
                        ConstAllAirDara.C_AIR_MODE_SUB = 38;
                        break;
                    case FinalCanbus.CAR_BNR_XP1_New_GL8_ES_L /* 1114491 */:
                    case FinalCanbus.CAR_BNR_XP1_New_GL8_ES_H /* 1180027 */:
                    case FinalCanbus.CAR_BNR_XP1_JunYue_L /* 1769851 */:
                    case FinalCanbus.CAR_BNR_XP1_JunYue_H /* 1835387 */:
                        ConstAllAirDara.U_AIR_AUTO = 88;
                        ConstAllAirDara.U_AIR_DUAL = 87;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 95;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 96;
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 102;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 106;
                        ConstAllAirDara.C_AIR_AUTO = 21;
                        ConstAllAirDara.C_AIR_DUAL = 16;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 12;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 14;
                        break;
                    case FinalCanbus.CAR_BNR_XP1_WeiLang_L /* 1245563 */:
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 95;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 96;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                        ConstAllAirDara.C_AIR_MODE_UP = 6;
                        ConstAllAirDara.C_AIR_MODE_BODY = 7;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                        break;
                    case FinalCanbus.CAR_BNR_XP1_WeiLang_H /* 1311099 */:
                        ConstAllAirDara.U_AIR_AUTO = 88;
                        ConstAllAirDara.U_AIR_DUAL = 87;
                        ConstAllAirDara.C_AIR_AUTO = 21;
                        ConstAllAirDara.C_AIR_DUAL = 16;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 95;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 96;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                        ConstAllAirDara.C_AIR_MODE_UP = 6;
                        ConstAllAirDara.C_AIR_MODE_BODY = 7;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                        break;
                    case FinalCanbus.CAR_BNR_XP1_YingLang_L /* 1376635 */:
                    case FinalCanbus.CAR_BNR_XP1_MairuibaoXL_L /* 1638779 */:
                        ConstAllAirDara.C_AIR_MODE_UP = 6;
                        ConstAllAirDara.C_AIR_MODE_BODY = 7;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                        break;
                    case FinalCanbus.CAR_BNR_XP1_MairuibaoXL_H /* 1704315 */:
                        ConstAllAirDara.U_AIR_AUTO = 88;
                        ConstAllAirDara.U_AIR_DUAL = 87;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 95;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 96;
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 102;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 106;
                        ConstAllAirDara.C_AIR_AUTO = 21;
                        ConstAllAirDara.C_AIR_DUAL = 16;
                        ConstAllAirDara.C_AIR_MODE_UP = 6;
                        ConstAllAirDara.C_AIR_MODE_BODY = 7;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 12;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 14;
                        break;
                    case FinalCanbus.CAR_BNR_XP1_Mairuibao_Top /* 1900923 */:
                    case FinalCanbus.CAR_BNR_RZC_Mairuibao_Top /* 2490747 */:
                        ConstAllAirDara.U_AIR_AUTO = 88;
                        ConstAllAirDara.U_AIR_DUAL = 87;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 95;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 96;
                        ConstAllAirDara.C_AIR_AUTO = 21;
                        ConstAllAirDara.C_AIR_DUAL = 16;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                        ConstAllAirDara.C_AIR_MODE_BODY = 7;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 33;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 32;
                        break;
                    case FinalCanbus.CAR_BNR_XP1_New_Klz_Top /* 1966459 */:
                        ConstAllAirDara.U_AIR_AUTO = 88;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 95;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 96;
                        ConstAllAirDara.C_AIR_AUTO = 21;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                        ConstAllAirDara.C_AIR_MODE_BODY = 7;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 33;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 32;
                        break;
                    case FinalCanbus.CAR_BNR_XP1_OldJunYue_L /* 2031995 */:
                        ConstAllAirDara.U_AIR_AUTO = 88;
                        ConstAllAirDara.U_AIR_DUAL = 87;
                        ConstAllAirDara.C_AIR_AUTO = 21;
                        ConstAllAirDara.C_AIR_DUAL = 16;
                        ConstAllAirDara.C_AIR_MODE_ADD = 37;
                        ConstAllAirDara.C_AIR_MODE_SUB = 38;
                        break;
                    case FinalCanbus.CAR_BNR_XP1_OldJunYue_H /* 2097531 */:
                        ConstAllAirDara.U_AIR_AUTO = 88;
                        ConstAllAirDara.U_AIR_DUAL = 87;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 95;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 96;
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 102;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 106;
                        ConstAllAirDara.C_AIR_AUTO = 21;
                        ConstAllAirDara.C_AIR_DUAL = 16;
                        ConstAllAirDara.C_AIR_MODE_ADD = 37;
                        ConstAllAirDara.C_AIR_MODE_SUB = 38;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 12;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 14;
                        break;
                }
            case FinalCanbus.CAR_RZC_Nissan_Qijun_HW /* 590014 */:
                ConstAllAirDara.U_AIR_POWER = 1;
                ConstAllAirDara.U_AIR_AUTO = 4;
                ConstAllAirDara.U_AIR_FRONT = 5;
                ConstAllAirDara.U_AIR_CYCLE = 3;
                ConstAllAirDara.U_AIR_AC = 2;
                ConstAllAirDara.U_AIR_DUAL = 7;
                ConstAllAirDara.U_AIR_REAR = 6;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 12;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 10;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 8;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 9;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 13;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 14;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_CYCLE = 4;
                ConstAllAirDara.C_AIR_AC = 5;
                ConstAllAirDara.C_AIR_DUAL = 6;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 7;
                ConstAllAirDara.C_AIR_WIND_SUB = 8;
                ConstAllAirDara.C_AIR_WIND_ADD = 9;
                ConstAllAirDara.C_AIR_MODE_UP = 10;
                ConstAllAirDara.C_AIR_MODE_BODY = 11;
                ConstAllAirDara.C_AIR_MODE_FOOT = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 16;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_RZC4_PSA_19_408 /* 590163 */:
            case FinalCanbus.CAR_RZC4_PSA_19_408_H /* 655699 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_REAR_CTRL = 38;
                ConstAllAirDara.U_AIR_AQS = 54;
                ConstAllAirDara.U_AIR_WINLEV = 51;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 12;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_AC_MAX = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 17;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 18;
                ConstAllAirDara.C_AIR_CYCLE = 14;
                ConstAllAirDara.C_AIR_AUTO = 1;
                ConstAllAirDara.C_AIR_DUAL = 11;
                ConstAllAirDara.C_REAR_CTRL = 15;
                ConstAllAirDara.C_AIR_AQS = 13;
                ConstAllAirDara.C_AIR_WINLEV = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 244;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 245;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 250;
                ConstAllAirDara.C_AIR_MODE_UP = 7;
                ConstAllAirDara.C_AIR_MODE_BODY = 6;
                ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                ConstAllAirDara.C_CONTRAL = 87;
                break;
            case FinalCanbus.CAR_WC2_PSAALL_10 /* 655612 */:
            case FinalCanbus.CAR_WC2_PSAALL_407_06 /* 1245436 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 55;
                ConstAllAirDara.U_AIR_AQS = 54;
                ConstAllAirDara.U_AIR_WINLEV = 52;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_AC_MAX = 3;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_MODE_UP = 8;
                ConstAllAirDara.C_AIR_MODE_BODY = 9;
                ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 251;
                ConstAllAirDara.C_AIR_DUAL = 15;
                ConstAllAirDara.C_AIR_AQS = 16;
                ConstAllAirDara.C_AIR_WINLEV = 14;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 252;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 253;
                ConstAllAirDara.C_CONTRAL = 106;
                break;
            case FinalCanbus.CAR_RZC_17LIENUO_L /* 655762 */:
            case FinalCanbus.CAR_RZC_17LIENUO_M /* 721298 */:
            case FinalCanbus.CAR_RZC_17LIENUO_H /* 786834 */:
            case FinalCanbus.CAR_RZC_17KeLeiJia_L /* 852370 */:
            case FinalCanbus.CAR_RZC_17KeLeiJia_H /* 917906 */:
            case FinalCanbus.CAR_RZC_18KeLeiAo_M /* 983442 */:
            case FinalCanbus.CAR_RZC_18KeLeiAo_H /* 1048978 */:
            case FinalCanbus.CAR_RZC_18KeLeiAo_L /* 1114514 */:
            case FinalCanbus.CAR_RZC_MEGANE_Turkey_L /* 1638802 */:
            case FinalCanbus.CAR_RZC_MEGANE_Turkey_M /* 1704338 */:
            case FinalCanbus.CAR_RZC_MEGANE_Turkey_H /* 1769874 */:
            case FinalCanbus.CAR_RZC_CLIO5_Turkey /* 2032018 */:
            case FinalCanbus.CAR_RZC_CLIO5_Turkey_M /* 2097554 */:
            case FinalCanbus.CAR_RZC_CLIO5_Turkey_H /* 2163090 */:
            case FinalCanbus.CAR_RZC_MEGANE_Turkey_L_AUTO /* 2228626 */:
            case FinalCanbus.CAR_RZC_Turkey_16KADJAR_L /* 3801490 */:
            case FinalCanbus.CAR_RZC_Turkey_16KADJAR_M /* 3867026 */:
            case FinalCanbus.CAR_RZC_Turkey_16KADJAR_H /* 3932562 */:
            case FinalCanbus.CAR_RZC_Turkey_22KADJAR_M /* 5964178 */:
                ConstAllAirDara.U_AIR_AC = 108;
                ConstAllAirDara.U_AIR_FRONT = 113;
                ConstAllAirDara.U_AIR_CYCLE = 109;
                ConstAllAirDara.U_AIR_REAR = 112;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 120;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 119;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 118;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 121;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 122;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 123;
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 6;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 23;
                ConstAllAirDara.C_AIR_CYCLE = 21;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                if (DataCanbus.DATA[1000] == 721298 || DataCanbus.DATA[1000] == 983442 || DataCanbus.DATA[1000] == 786834 || DataCanbus.DATA[1000] == 1048978 || DataCanbus.DATA[1000] == 1704338 || DataCanbus.DATA[1000] == 1769874 || DataCanbus.DATA[1000] == 2228626 || DataCanbus.DATA[1000] == 2097554 || DataCanbus.DATA[1000] == 2163090) {
                    ConstAllAirDara.U_AIR_DUAL = 111;
                    ConstAllAirDara.U_AIR_AUTO = 110;
                    ConstAllAirDara.U_AIR_AQS = 107;
                    ConstAllAirDara.C_AIR_MODE_UP = 24;
                    ConstAllAirDara.C_AIR_MODE_BODY = 7;
                    ConstAllAirDara.C_AIR_MODE_FOOT = 9;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                    ConstAllAirDara.C_AIR_AUTO = 2;
                    ConstAllAirDara.C_AIR_DUAL = 3;
                    ConstAllAirDara.C_AIR_AQS = 22;
                } else if (DataCanbus.DATA[1000] == 3867026 || DataCanbus.DATA[1000] == 3932562 || DataCanbus.DATA[1000] == 5964178) {
                    ConstAllAirDara.U_AIR_DUAL = 111;
                    ConstAllAirDara.U_AIR_AUTO = 110;
                    ConstAllAirDara.U_AIR_AQS = 107;
                    ConstAllAirDara.C_AIR_MODE_ADD = 28;
                    ConstAllAirDara.C_AIR_MODE_SUB = 29;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                    ConstAllAirDara.C_AIR_AUTO = 2;
                    ConstAllAirDara.C_AIR_DUAL = 3;
                    ConstAllAirDara.C_AIR_AQS = 22;
                } else if (DataCanbus.DATA[1000] == 3801490) {
                    ConstAllAirDara.C_AIR_MODE_ADD = 28;
                    ConstAllAirDara.C_AIR_MODE_SUB = 29;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 14;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 13;
                } else if (DataCanbus.DATA[1000] == 655762 || DataCanbus.DATA[1000] == 1114514 || DataCanbus.DATA[1000] == 852370 || DataCanbus.DATA[1000] == 1638802 || DataCanbus.DATA[1000] == 2032018) {
                    ConstAllAirDara.C_AIR_MODE_ADD = 15;
                    ConstAllAirDara.C_AIR_MODE_SUB = 16;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 14;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 13;
                } else if (DataCanbus.DATA[1000] == 917906) {
                    ConstAllAirDara.U_AIR_DUAL = 111;
                    ConstAllAirDara.U_AIR_AUTO = 110;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                    ConstAllAirDara.C_AIR_AUTO = 2;
                    ConstAllAirDara.C_AIR_DUAL = 3;
                    ConstAllAirDara.C_AIR_MODE_ADD = 15;
                    ConstAllAirDara.C_AIR_MODE_SUB = 16;
                }
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
                ConstAllAirDara.TEMPERATURE_NONE = -1;
                ConstAllAirDara.TEMPERATURE_LOW = 0;
                ConstAllAirDara.TEMPERATURE_HIGHT = 127;
                ConstAllAirDara.U_AIR_AC = 12;
                ConstAllAirDara.U_AIR_FRONT = 14;
                ConstAllAirDara.U_AIR_POWER = 11;
                ConstAllAirDara.U_AIR_CYCLE = 13;
                ConstAllAirDara.U_AIR_AUTO = 22;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 16;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 17;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 20;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 24;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 28;
                ConstAllAirDara.U_AIR_DUAL = 23;
                ConstAllAirDara.U_AIR_REAR = 15;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 39;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                if (DataCanbus.DATA[1000] == 1311044 || DataCanbus.DATA[1000] == 852292 || DataCanbus.DATA[1000] == 1179972 || DataCanbus.DATA[1000] == 1048900 || DataCanbus.DATA[1000] == 786756) {
                    ConstAllAirDara.C_AIR_AUTO = 255;
                    ConstAllAirDara.U_AIR_AUTO = 255;
                    ConstAllAirDara.C_AIR_DUAL = 255;
                    ConstAllAirDara.U_AIR_DUAL = 255;
                }
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_RZC_BenTeng_OLDB50 /* 786845 */:
                ConstAllAirDara.TEMPERATURE_NONE = 0;
                ConstAllAirDara.TEMPERATURE_LOW = 15;
                ConstAllAirDara.TEMPERATURE_HIGHT = 49;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 26;
                ConstAllAirDara.U_AIR_POWER = 21;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 15;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 16;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 17;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 18;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 19;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 20;
                ConstAllAirDara.U_AIR_DUAL = 23;
                ConstAllAirDara.U_AIR_AC_MAX = 24;
                ConstAllAirDara.U_AIR_REAR = 25;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 39;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 34;
                ConstAllAirDara.C_CONTRAL = 4;
                break;
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx /* 917956 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx_H /* 983492 */:
            case FinalCanbus.CAR_439_BNR_LEXUS_ES /* 1835447 */:
            case FinalCanbus.CAR_439_BNR_LEXUS_ES_H /* 1900983 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_IS /* 3080631 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_IS_H /* 3146167 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_ES /* 3211703 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_ES_H /* 3277239 */:
            case FinalCanbus.CAR_BNR_02_09Toyato_Prado /* 7668151 */:
            case FinalCanbus.CAR_BNR_02_09Toyato_Prado_H /* 7733687 */:
                ConstAllAirDara.U_AIR_FRONT = 6;
                ConstAllAirDara.U_AIR_REAR = 14;
                ConstAllAirDara.U_AIR_POWER = 1;
                ConstAllAirDara.U_AIR_AUTO = 4;
                ConstAllAirDara.U_AIR_AC = 2;
                ConstAllAirDara.U_AIR_CYCLE = 3;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 7;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 8;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 9;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 10;
                ConstAllAirDara.U_AIR_DUAL = 5;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 11;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 12;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 18;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_RZC_DongFeng_Fengxing_M7 /* 1114339 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR_CTRL = 38;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 6;
                ConstAllAirDara.C_REAR_CTRL = 21;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 23;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_CYCLE = 5;
                ConstAllAirDara.C_AIR_MODE_BODY = 7;
                ConstAllAirDara.C_AIR_MODE_FOOT = 9;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 8;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 10;
                ConstAllAirDara.C_CONTRAL = 5;
                break;
            case FinalCanbus.CAR_452_XFY_PSA_3008_L /* 1114564 */:
            case FinalCanbus.CAR_452_XFY_PSA_3008_H /* 1180100 */:
                ConstAllAirDara.U_AIR_AC = 14;
                ConstAllAirDara.U_AIR_CYCLE = 16;
                ConstAllAirDara.U_AIR_REAR = 18;
                ConstAllAirDara.U_AIR_FRONTMAX = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 10;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 11;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 12;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 9;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 7;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 8;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_452_XFY_PSA_3008_H /* 1180100 */:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_DUAL = 15;
                        ConstAllAirDara.C_AIR_AUTO = 2;
                        ConstAllAirDara.C_AIR_DUAL = 8;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_RZC_HavalH4_20 /* 1245428 */:
                ConstAllAirDara.TEMPERATURE_NONE = -1;
                ConstAllAirDara.TEMPERATURE_LOW = 0;
                ConstAllAirDara.TEMPERATURE_HIGHT = 255;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_MODE_BODY = 7;
                ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 32;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 33;
                ConstAllAirDara.C_AIR_LEFT_COLD = 12;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 14;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                ConstAllAirDara.C_CONTRAL = 6;
                break;
            case FinalCanbus.CAR_439_DJ_TOYOTA_08Prado_ShuPing_H /* 1442231 */:
                ConstAllAirDara.U_AIR_POWER = 1;
                ConstAllAirDara.U_AIR_AC = 2;
                ConstAllAirDara.U_AIR_FRONT = 6;
                ConstAllAirDara.U_AIR_CYCLE = 3;
                ConstAllAirDara.U_AIR_AUTO = 4;
                ConstAllAirDara.U_AIR_DUAL = 5;
                ConstAllAirDara.U_AIR_REAR = 9;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 11;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 12;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 14;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 15;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 16;
                ConstAllAirDara.C_AIR_POWER = 10;
                ConstAllAirDara.C_AIR_AUTO = 1;
                ConstAllAirDara.C_AIR_DUAL = 2;
                ConstAllAirDara.C_AIR_AC = 8;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 9;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 4;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_GX50 /* 1507771 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_10G37 /* 4587963 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_16Q50l_SP /* 5308859 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_11FX35 /* 6095291 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_14Q50_L /* 8651195 */:
                ConstAllAirDara.U_AIR_AC = 3;
                ConstAllAirDara.U_AIR_FRONT = 7;
                ConstAllAirDara.U_AIR_POWER = 1;
                ConstAllAirDara.U_AIR_CYCLE = 4;
                ConstAllAirDara.U_AIR_AUTO = 2;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 10;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 9;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 8;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 12;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 13;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 14;
                ConstAllAirDara.U_AIR_DUAL = 5;
                ConstAllAirDara.U_AIR_REAR = 6;
                if (DataCanbus.DATA[1000] == 5308859 || DataCanbus.DATA[1000] == 8651195 || DataCanbus.DATA[1000] == 6095291) {
                    ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 143;
                    ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 144;
                    ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                    ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_DUAL = 41;
                ConstAllAirDara.C_AIR_MODE_ADD = 21;
                ConstAllAirDara.C_AIR_MODE_SUB = 22;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_452_XinCheng_Infiniti_ESQ /* 1573316 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_06FX /* 1638852 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_08FX /* 1704388 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_G /* 1769924 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_14QX50 /* 1835460 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_14QX70 /* 1966532 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_13Q70L /* 2032068 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_12FX /* 3998148 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_15Q50L /* 4063684 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_12JX35 /* 4129220 */:
                ConstAllAirDara.U_AIR_AC = 8;
                ConstAllAirDara.U_AIR_AUTO = 11;
                ConstAllAirDara.U_AIR_FRONT = 13;
                ConstAllAirDara.U_AIR_REAR = 10;
                ConstAllAirDara.U_AIR_CYCLE = 9;
                ConstAllAirDara.U_AIR_CYCLE_AUTO = 14;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 18;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 19;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 20;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 17;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 16;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 15;
                ConstAllAirDara.U_AIR_DUAL = 12;
                ConstAllAirDara.C_CONTRAL = 3;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 18;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_452_XinCheng_Infiniti_ESQ /* 1573316 */:
                    case FinalCanbus.CAR_452_XinCheng_Infiniti_12FX /* 3998148 */:
                    case FinalCanbus.CAR_452_XinCheng_Infiniti_12JX35 /* 4129220 */:
                        ConstAllAirDara.C_AIR_MODE_BODY = 7;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 33;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 32;
                        break;
                    case FinalCanbus.CAR_452_XinCheng_Infiniti_06FX /* 1638852 */:
                    case FinalCanbus.CAR_452_XinCheng_Infiniti_08FX /* 1704388 */:
                    case FinalCanbus.CAR_452_XinCheng_Infiniti_G /* 1769924 */:
                    case FinalCanbus.CAR_452_XinCheng_Infiniti_14QX50 /* 1835460 */:
                    case FinalCanbus.CAR_452_XinCheng_Infiniti_14QX70 /* 1966532 */:
                    case FinalCanbus.CAR_452_XinCheng_Infiniti_15Q50L /* 4063684 */:
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                        break;
                    case FinalCanbus.CAR_452_XinCheng_Infiniti_13Q70L /* 2032068 */:
                        ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 114;
                        ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 113;
                        ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 112;
                        ConstAllAirDara.U_AIR_FOREST = 111;
                        ConstAllAirDara.U_AIR_BLOWTOP = 110;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                        ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT = 66;
                        ConstAllAirDara.C_AIR_FOREST = 67;
                        ConstAllAirDara.C_AIR_BLOWTOP = 22;
                        break;
                }
            case FinalCanbus.CAR_443_WC2_Tianlai08_12_GongJue /* 1900987 */:
                ConstAllAirDara.TEMPERATURE_NONE = 0;
                ConstAllAirDara.U_AIR_POWER = 1;
                ConstAllAirDara.U_AIR_AC = 3;
                ConstAllAirDara.U_AIR_CYCLE = 4;
                ConstAllAirDara.U_AIR_REAR = 7;
                ConstAllAirDara.U_AIR_FRONT = 6;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 8;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 9;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 10;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 12;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 13;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 14;
                ConstAllAirDara.U_AIR_AUTO = 2;
                ConstAllAirDara.U_AIR_DUAL = 5;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_DUAL = 41;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 21;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_452_XP_Megane4_SP_L_HAND /* 2228676 */:
            case FinalCanbus.CAR_452_XP_Megane4_SP_L_AUTO /* 2294212 */:
            case FinalCanbus.CAR_452_XP_Megane4_SP_H_AUTO /* 2359748 */:
                ConstAllAirDara.U_AIR_AC = 10;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_CYCLE = 11;
                ConstAllAirDara.U_AIR_REAR = 14;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 16;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 17;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 19;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 20;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 21;
                if (DataCanbus.DATA[1000] == 2294212 || DataCanbus.DATA[1000] == 2359748) {
                    ConstAllAirDara.U_AIR_AUTO = 12;
                    ConstAllAirDara.U_AIR_DUAL = 13;
                    ConstAllAirDara.U_AIR_MODE = 22;
                    ConstAllAirDara.C_AIR_AUTO = 20;
                    ConstAllAirDara.C_AIR_DUAL = 23;
                    ConstAllAirDara.C_AIR_MODE_CHANGER = 1;
                    ConstAllAirDara.C_SOFT = 64;
                    ConstAllAirDara.C_FAST = 66;
                    ConstAllAirDara.C_NORMAL = 65;
                    ConstAllAirDara.C_AIR_AQS = 34;
                } else {
                    ConstAllAirDara.C_AIR_MODE_UP = 27;
                    ConstAllAirDara.C_AIR_MODE_BODY = 24;
                    ConstAllAirDara.C_AIR_MODE_FOOT = 26;
                }
                ConstAllAirDara.C_AIR_POWER = 9;
                ConstAllAirDara.C_AIR_AC = 17;
                ConstAllAirDara.C_AIR_CYCLE = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 22;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 21;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 30;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 31;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 30;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 31;
                ConstAllAirDara.C_AIR_WIND_SUB = 28;
                ConstAllAirDara.C_AIR_WIND_ADD = 29;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_RZC_LHT_Ford_F150_Hand /* 2490702 */:
                ConstAllAirDara.TEMPERATURE_LOW = 1048576;
                ConstAllAirDara.TEMPERATURE_HIGHT = FinalCanbus.CAR_WC1_VW_Polo_08_18;
                ConstAllAirDara.TEMPERATURE_NONE = 1048578;
                ConstAllAirDara.U_AIR_POWER = 15;
                ConstAllAirDara.U_AIR_AC = 16;
                ConstAllAirDara.U_AIR_FRONTMAX = 17;
                ConstAllAirDara.U_AIR_CYCLE = 18;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 22;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 23;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 24;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 25;
                ConstAllAirDara.U_AIR_AC_MAX = 27;
                ConstAllAirDara.U_AIR_REAR = 48;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 54;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 55;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 181;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 182;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_AC_MAX = 39;
                ConstAllAirDara.C_AIR_LEFT_COLD = 45;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 46;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 13;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 14;
                ConstAllAirDara.C_AIR_MODE_UP = 3;
                ConstAllAirDara.C_AIR_MODE_BODY = 29;
                ConstAllAirDara.C_AIR_MODE_FOOT = 31;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_CONTRAL = 12;
                break;
            case FinalCanbus.CAR_RZC_BMW_X3_11_13 /* 3670067 */:
            case FinalCanbus.CAR_RZC_BMW_X3_13_16 /* 3735603 */:
            case FinalCanbus.CAR_RZC_BMW_X3_16_17 /* 3801139 */:
            case FinalCanbus.CAR_RZC_BMW_3_13_17 /* 3866675 */:
            case FinalCanbus.CAR_RZC_BMW_CCC /* 4128819 */:
            case FinalCanbus.CAR_RZC_BMW_EVO /* 4390963 */:
                ConstAllAirDara.TEMPERATURE_NONE = -1;
                ConstAllAirDara.TEMPERATURE_LOW = 0;
                ConstAllAirDara.TEMPERATURE_HIGHT = 254;
                ConstAllAirDara.U_AIR_POWER = 14;
                ConstAllAirDara.U_AIR_AC = 17;
                ConstAllAirDara.U_AIR_DUAL = 20;
                ConstAllAirDara.U_AIR_FRONT = 18;
                ConstAllAirDara.U_AIR_CYCLE = 19;
                ConstAllAirDara.U_AIR_AUTO = 16;
                ConstAllAirDara.U_AIR_AC_MAX = 32;
                ConstAllAirDara.U_AIR_REAR = 21;
                ConstAllAirDara.U_AIR_CYCLE_AUTO = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 30;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 33;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 22;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 23;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 25;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 26;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_DUAL = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 6;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 31;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 32;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 23;
                ConstAllAirDara.C_AIR_AC_MAX = 30;
                ConstAllAirDara.C_AIR_CYCLE = 21;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_MODE_UP = 24;
                ConstAllAirDara.C_AIR_MODE_BODY = 7;
                ConstAllAirDara.C_AIR_MODE_FOOT = 9;
                ConstAllAirDara.C_CONTRAL = 10;
                break;
            case FinalCanbus.CAR_452_LZ_Jaguar_XK /* 3670468 */:
                ConstAllAirDara.U_AIR_POWER = 7;
                ConstAllAirDara.U_AIR_AUTO = 10;
                ConstAllAirDara.U_AIR_AC = 8;
                ConstAllAirDara.U_AIR_FRONT = 12;
                ConstAllAirDara.U_AIR_REAR = 13;
                ConstAllAirDara.U_AIR_CYCLE = 9;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 14;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 15;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 16;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 19;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 20;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 24;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 25;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 24;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 25;
                ConstAllAirDara.C_AIR_POWER = 11;
                ConstAllAirDara.C_AIR_AUTO = 10;
                ConstAllAirDara.C_AIR_AC = 8;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 12;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 13;
                ConstAllAirDara.C_AIR_CYCLE = 9;
                ConstAllAirDara.C_AIR_WIND_SUB = 6;
                ConstAllAirDara.C_AIR_WIND_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 1;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 8;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 19;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 20;
                ConstAllAirDara.C_AIR_LEFT_COLD = 30;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 31;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_439_XBS_09Tianlai /* 4063671 */:
                ConstAllAirDara.U_AIR_AC = 13;
                ConstAllAirDara.U_AIR_CYCLE = 11;
                ConstAllAirDara.U_AIR_REAR = 8;
                ConstAllAirDara.U_AIR_FRONT = 9;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 4;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 5;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 6;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 3;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 1;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 2;
                ConstAllAirDara.U_AIR_AUTO = 12;
                ConstAllAirDara.U_AIR_DUAL = 10;
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_439_RZC_ChangAn_CX70 /* 4391351 */:
            case FinalCanbus.CAR_439_RZC_ChangAn_OUSAN_KESAI /* 7471543 */:
            case FinalCanbus.CAR_452_RZC_ChangAn_KESAI_Pro_21 /* 11010500 */:
                ConstAllAirDara.U_AIR_AUTO = 5;
                ConstAllAirDara.U_AIR_REAR = 8;
                ConstAllAirDara.U_AIR_FRONT = 7;
                ConstAllAirDara.U_AIR_CYCLE = 6;
                ConstAllAirDara.U_AIR_AC = 9;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 14;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 13;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 11;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 12;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 10;
                if (DataCanbus.DATA[1000] == 7471543 || DataCanbus.DATA[1000] == 11010500) {
                    ConstAllAirDara.U_AIR_REAR_CTRL = 16;
                    ConstAllAirDara.C_REAR_CTRL = 12;
                    ConstAllAirDara.C_AIR_MODE_BODY = 13;
                    ConstAllAirDara.C_AIR_MODE_FOOT = 14;
                    ConstAllAirDara.C_AIR_MODE_BODYFOOT = 15;
                    ConstAllAirDara.C_AIR_MODE_UPFOOT = 16;
                } else {
                    ConstAllAirDara.C_AIR_MODE_CHANGER = 2;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 3;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_CYCLE = 5;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 6;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 7;
                ConstAllAirDara.C_AIR_WIND_SUB = 8;
                ConstAllAirDara.C_AIR_WIND_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD /* 4719035 */:
            case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD_HW /* 4915643 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_DUAL = 41;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 21;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_439_RZC_TuDa /* 4915639 */:
            case FinalCanbus.CAR_439_RZC_14QiJun_Auto /* 5374391 */:
            case FinalCanbus.CAR_439_RZC_14QiJun_Hand /* 5439927 */:
            case FinalCanbus.CAR_439_RZC_16Xiaoke_Auto /* 5505463 */:
            case FinalCanbus.CAR_439_RZC_16Xiaoke_Hand /* 5570999 */:
            case FinalCanbus.CAR_439_RZC_13Tianlai_Auto /* 5636535 */:
            case FinalCanbus.CAR_439_RZC_13Tianlai_Hand /* 5702071 */:
            case FinalCanbus.CAR_439_RZC_08Tianlai_Auto /* 5767607 */:
            case FinalCanbus.CAR_439_RZC_08Tianlai_Hand /* 5833143 */:
            case FinalCanbus.CAR_439_RZC_16Qida_Auto /* 5898679 */:
            case FinalCanbus.CAR_439_RZC_16Qida_Hand /* 5964215 */:
            case FinalCanbus.CAR_439_RZC_TuDa_Hand /* 11207095 */:
                ConstAllAirDara.U_AIR_AC = 8;
                ConstAllAirDara.U_AIR_FRONT = 13;
                ConstAllAirDara.U_AIR_POWER = 7;
                ConstAllAirDara.U_AIR_CYCLE = 9;
                ConstAllAirDara.U_AIR_AUTO = 11;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 14;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 15;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 16;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 17;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 18;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 19;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 22;
                ConstAllAirDara.U_AIR_DUAL = 12;
                ConstAllAirDara.U_AIR_REAR = 10;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                if (DataCanbus.DATA[1000] == 5439927 || DataCanbus.DATA[1000] == 5702071 || DataCanbus.DATA[1000] == 5570999 || DataCanbus.DATA[1000] == 5964215 || DataCanbus.DATA[1000] == 5833143) {
                    ConstAllAirDara.C_AIR_AUTO = 255;
                    ConstAllAirDara.U_AIR_AUTO = 255;
                    ConstAllAirDara.C_AIR_DUAL = 255;
                    ConstAllAirDara.U_AIR_DUAL = 255;
                }
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_439_XFY_SanLing_13Oulande_H /* 4981175 */:
            case FinalCanbus.CAR_439_XFY_SanLing_17Oulande_H /* 5046711 */:
            case FinalCanbus.CAR_439_XFY_SanLing_Tai_Pajieluo_H /* 5112247 */:
            case FinalCanbus.CAR_439_XFY_SanLing_13Oulande_Low /* 5177783 */:
            case FinalCanbus.CAR_439_XFY_SanLing_17Oulande_Low /* 5243319 */:
            case FinalCanbus.CAR_439_XFY_SanLing_Tai_Pajieluo_Low /* 5308855 */:
                ConstAllAirDara.U_AIR_AC = 19;
                ConstAllAirDara.U_AIR_CYCLE = 17;
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 20;
                ConstAllAirDara.U_AIR_DUAL = 18;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 11;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 12;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 10;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 8;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 9;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9 /* 5702084 */:
            case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_Auto /* 5833156 */:
            case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_EV /* 10355140 */:
                ConstAllAirDara.U_AIR_AC = 9;
                ConstAllAirDara.U_AIR_CYCLE = 10;
                ConstAllAirDara.U_AIR_REAR = 11;
                ConstAllAirDara.U_AIR_FRONTMAX = 12;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 14;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 15;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 16;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 13;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 18;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 19;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9 /* 5702084 */:
                        ConstAllAirDara.TEMPERATURE_LOW = 1;
                        ConstAllAirDara.TEMPERATURE_HIGHT = 16;
                        break;
                    case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_Auto /* 5833156 */:
                        ConstAllAirDara.TEMPERATURE_LOW = 0;
                        ConstAllAirDara.TEMPERATURE_HIGHT = 255;
                        ConstAllAirDara.U_AIR_AUTO = 8;
                        ConstAllAirDara.C_AIR_AUTO = 21;
                        break;
                    case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_EV /* 10355140 */:
                        ConstAllAirDara.TEMPERATURE_LOW = 0;
                        ConstAllAirDara.TEMPERATURE_HIGHT = 255;
                        ConstAllAirDara.U_AIR_AUTO = 8;
                        ConstAllAirDara.U_AIR_AQS = 20;
                        ConstAllAirDara.U_AIR_HEAT = 21;
                        ConstAllAirDara.C_AIR_AUTO = 21;
                        ConstAllAirDara.C_AIR_AQS = 37;
                        ConstAllAirDara.C_AIR_HEAT = 38;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 19;
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
            case FinalCanbus.CAR_452_CYT_Hyundai_VERACRUZ /* 5767620 */:
                ConstAllAirDara.U_AIR_AC = 15;
                ConstAllAirDara.U_AIR_CYCLE = 19;
                ConstAllAirDara.U_AIR_REAR = 18;
                ConstAllAirDara.U_AIR_FRONTMAX = 17;
                ConstAllAirDara.U_AIR_AUTO = 14;
                ConstAllAirDara.U_AIR_DUAL = 16;
                ConstAllAirDara.U_AIR_REAR_CTRL = 20;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 10;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 11;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 12;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 9;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 7;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 8;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_REAR_CTRL = 37;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_439_HC_Nissan_XiaoKe /* 6685111 */:
                ConstAllAirDara.U_AIR_AC = 9;
                ConstAllAirDara.U_AIR_FRONT = 23;
                ConstAllAirDara.U_AIR_FRONTMAX = 14;
                ConstAllAirDara.U_AIR_POWER = 8;
                ConstAllAirDara.U_AIR_CYCLE = 10;
                ConstAllAirDara.U_AIR_AUTO = 12;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 15;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 16;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 17;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 19;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 20;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 21;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 22;
                ConstAllAirDara.U_AIR_DUAL = 13;
                ConstAllAirDara.U_AIR_AC_MAX = 24;
                ConstAllAirDara.U_AIR_REAR = 11;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 39;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_AIR_AC_MAX = 24;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_452_XBS_Nissan_Cedric /* 7143876 */:
                ConstAllAirDara.U_AIR_AC = 15;
                ConstAllAirDara.U_AIR_FRONTMAX = 19;
                ConstAllAirDara.U_AIR_CYCLE = 17;
                ConstAllAirDara.U_AIR_AUTO = 14;
                ConstAllAirDara.U_AIR_DUAL = 16;
                ConstAllAirDara.U_AIR_REAR = 18;
                ConstAllAirDara.U_AIR_CLEAN = 20;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 11;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 12;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 10;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 8;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 9;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_CLEAN = 50;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_452_TangDu_Nissan_Tuda_Hand /* 7668164 */:
            case FinalCanbus.CAR_452_TangDu_Nissan_Tuda_Auto /* 7733700 */:
                ConstAllAirDara.U_AIR_AC = 9;
                ConstAllAirDara.U_AIR_CYCLE = 10;
                ConstAllAirDara.U_AIR_REAR = 11;
                ConstAllAirDara.U_AIR_FRONT = 14;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 15;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 16;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 17;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 18;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 19;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 20;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_452_TangDu_Nissan_Tuda_Hand /* 7668164 */:
                        ConstAllAirDara.C_AIR_MODE_BODY = 7;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 33;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 32;
                        break;
                    case FinalCanbus.CAR_452_TangDu_Nissan_Tuda_Auto /* 7733700 */:
                        ConstAllAirDara.U_AIR_AUTO = 12;
                        ConstAllAirDara.U_AIR_DUAL = 13;
                        ConstAllAirDara.C_AIR_AUTO = 21;
                        ConstAllAirDara.C_AIR_DUAL = 16;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                        break;
                }
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_452_OD_LandRover_Freelander /* 7799236 */:
            case FinalCanbus.CAR_452_OD_Lamborghini /* 7930308 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 13;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 14;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_452_LZ_Volvo /* 7995844 */:
            case FinalCanbus.CAR_452_LZ_Volvo_10 /* 13631940 */:
            case FinalCanbus.CAR_452_LZ_Volvo_15 /* 16515524 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.C_AIR_POWER = 22;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_AUTO = 25;
                ConstAllAirDara.C_AIR_DUAL = 5;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 23;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 24;
                ConstAllAirDara.C_AIR_CYCLE = 26;
                ConstAllAirDara.C_AIR_MODE_UP = 2;
                ConstAllAirDara.C_AIR_MODE_BODY = 3;
                ConstAllAirDara.C_AIR_MODE_FOOT = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 16;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 17;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 18;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 19;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 6;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 7;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_452_OD_HuaChen_SWM_X7 /* 8323524 */:
            case FinalCanbus.CAR_452_OD_HuaChen_SWM_X7_H /* 8389060 */:
            case FinalCanbus.CAR_452_OD_HuaChen_SWM_G05 /* 15335876 */:
            case FinalCanbus.CAR_452_OD_HuaChen_SWM_G05_H /* 15401412 */:
                ConstAllAirDara.U_AIR_AC = 9;
                ConstAllAirDara.U_AIR_CYCLE = 10;
                ConstAllAirDara.U_AIR_AUTO = 11;
                ConstAllAirDara.U_AIR_REAR = 14;
                ConstAllAirDara.U_AIR_FRONT = 13;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 15;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 16;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 17;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 18;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 19;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 20;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 2;
                ConstAllAirDara.C_AIR_WIND_ADD = 7;
                ConstAllAirDara.C_AIR_WIND_SUB = 6;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 8;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 9;
                ConstAllAirDara.C_AIR_AC = 11;
                ConstAllAirDara.C_AIR_CYCLE = 12;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 16;
                ConstAllAirDara.C_AIR_AUTO = 17;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_453_RCW_Honda_YaGe7 /* 8520133 */:
            case FinalCanbus.CAR_439_RCW_BYD_12_18Surui /* 9699767 */:
            case FinalCanbus.CAR_439_RCW_BYD_14_15G5 /* 9765303 */:
            case FinalCanbus.CAR_439_RCW_BYD_10_15M6 /* 9830839 */:
            case FinalCanbus.CAR_439_RCW_BYD_13_17S7 /* 9896375 */:
            case FinalCanbus.CAR_439_RCW_BYD_16_19Song /* 9961911 */:
            case FinalCanbus.CAR_439_RCW_BYD_17_19SongMax /* 10027447 */:
            case FinalCanbus.CAR_439_RCW_BYD_12_17E6 /* 10092983 */:
            case FinalCanbus.CAR_453_RCW_BYD_10_13G6 /* 13042117 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 72;
                ConstAllAirDara.U_AIR_CYCLE = 13;
                ConstAllAirDara.U_AIR_REAR = 14;
                ConstAllAirDara.U_AIR_FRONT = 17;
                ConstAllAirDara.U_AIR_AUTO = 12;
                ConstAllAirDara.U_AIR_DUAL = 15;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 22;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 21;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 18;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 24;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 25;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 23;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 6;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 7;
                ConstAllAirDara.C_AIR_WIND_ADD = 2;
                ConstAllAirDara.C_AIR_WIND_SUB = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 11;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 12;
                ConstAllAirDara.C_AIR_AUTO = 8;
                ConstAllAirDara.C_AIR_DUAL = 9;
                ConstAllAirDara.C_AIR_CYCLE = 10;
                ConstAllAirDara.C_AIR_AC = 13;
                ConstAllAirDara.C_AIR_AC_MAX = 15;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 14;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_452_LZ_Audi_A3_SP /* 9306564 */:
            case FinalCanbus.CAR_452_LZ_Audi_A4_SP /* 9372100 */:
            case FinalCanbus.CAR_452_LZ_Audi_TT_SP /* 9437636 */:
            case FinalCanbus.CAR_452_LZ_Audi_A3_SP_H /* 11076036 */:
            case FinalCanbus.CAR_452_LZ_Audi_A4_SP_H /* 11141572 */:
            case FinalCanbus.CAR_452_LZ_Audi_TT_SP_H /* 11207108 */:
                ConstAllAirDara.U_AIR_AC = 15;
                ConstAllAirDara.U_AIR_AC_MAX = 20;
                ConstAllAirDara.U_AIR_FRONTMAX = 17;
                ConstAllAirDara.U_AIR_CYCLE = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 11;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 12;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 10;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 8;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 9;
                ConstAllAirDara.U_AIR_REAR = 18;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_452_LZ_Audi_A3_SP_H /* 11076036 */:
                    case FinalCanbus.CAR_452_LZ_Audi_A4_SP_H /* 11141572 */:
                    case FinalCanbus.CAR_452_LZ_Audi_TT_SP_H /* 11207108 */:
                        ConstAllAirDara.U_AIR_AUTO = 14;
                        ConstAllAirDara.U_AIR_DUAL = 16;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 21;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 22;
                        ConstAllAirDara.C_AIR_AUTO = 2;
                        ConstAllAirDara.C_AIR_DUAL = 8;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 13;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 14;
                        break;
                }
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_AC_MAX = 39;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_MODE_UP = 3;
                ConstAllAirDara.C_AIR_MODE_BODY = 29;
                ConstAllAirDara.C_AIR_MODE_FOOT = 31;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_452_KYC_Sanlin_outlander_13_H /* 9634244 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_outlander_17_H /* 9699780 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_16_H /* 9765316 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_outlander_13_L /* 9830852 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_outlander_17_L /* 9896388 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_16_L /* 9961924 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_V97_H /* 10027460 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_V97_L /* 10092996 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_20_H /* 10158532 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_20_L /* 10224068 */:
                ConstAllAirDara.U_AIR_AC = 16;
                ConstAllAirDara.U_AIR_FRONTMAX = 20;
                ConstAllAirDara.U_AIR_CYCLE = 18;
                ConstAllAirDara.U_AIR_AUTO = 15;
                ConstAllAirDara.U_AIR_SYNC = 17;
                ConstAllAirDara.U_AIR_REAR = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 11;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 12;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 10;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 8;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 9;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_20_H /* 10158532 */:
                    case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_20_L /* 10224068 */:
                        ConstAllAirDara.U_AIR_REAR_CTRL = 14;
                        ConstAllAirDara.C_REAR_CTRL = 37;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_SYNC = 8;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_452_KYC_Zhonghua_All /* 10617284 */:
            case FinalCanbus.CAR_452_KYC_Zhonghua_All_H /* 10682820 */:
            case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7 /* 10748356 */:
            case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7_H /* 10813892 */:
                ConstAllAirDara.U_AIR_AC = 17;
                ConstAllAirDara.U_AIR_AC_MAX = 20;
                ConstAllAirDara.U_AIR_FRONT = 22;
                ConstAllAirDara.U_AIR_CYCLE = 19;
                ConstAllAirDara.U_AIR_AUTO = 16;
                ConstAllAirDara.U_AIR_SYNC = 18;
                ConstAllAirDara.U_AIR_REAR = 21;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 14;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 15;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 11;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 12;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 10;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 8;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 9;
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
            case FinalCanbus.CAR_439_LZ_INFINIT_FX35 /* 12714423 */:
                ConstAllAirDara.U_AIR_AC = 9;
                ConstAllAirDara.U_AIR_FRONT = 17;
                ConstAllAirDara.U_AIR_POWER = 8;
                ConstAllAirDara.U_AIR_CYCLE = 10;
                ConstAllAirDara.U_AIR_AUTO = 11;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 13;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 13;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 14;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 19;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 15;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 16;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 20;
                ConstAllAirDara.U_AIR_DUAL = 12;
                ConstAllAirDara.U_AIR_REAR = 18;
                ConstAllAirDara.C_AIR_EM = 15;
                ConstAllAirDara.C_AIR_POWER = 6;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 1;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_DUAL = 14;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 7;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 8;
                ConstAllAirDara.C_AIR_AUTO = 5;
                ConstAllAirDara.C_AIR_AC = 11;
                ConstAllAirDara.C_AIR_CYCLE = 12;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 13;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_439_DJ_Siyu /* 14549431 */:
                ConstAllAirDara.U_AIR_POWER = 1;
                ConstAllAirDara.U_AIR_AC = 2;
                ConstAllAirDara.U_AIR_CYCLE = 3;
                ConstAllAirDara.U_AIR_REAR = 4;
                ConstAllAirDara.U_AIR_FRONTMAX = 5;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 6;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 7;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 8;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 9;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 10;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 11;
                ConstAllAirDara.C_AIR_POWER = 10;
                ConstAllAirDara.C_AIR_AC = 8;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 33;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 13;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_MODE_UP = 33;
                ConstAllAirDara.C_AIR_MODE_BODY = 34;
                ConstAllAirDara.C_AIR_MODE_FOOT = 35;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 18;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 19;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
        }
    }

    private void init() {
        findViewById(R.id.air_sp_wind_minuts).setOnTouchListener(this);
        findViewById(R.id.air_sp_wind_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_left_munits).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_right_munits).setOnTouchListener(this);
        if (ConstAllAirDara.U_AIR_REAR_CTRL != 255) {
            findViewById(R.id.air_sp_car_rear).setOnTouchListener(this);
            findViewById(R.id.air_sp_car_rear).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_car_rear).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_AQS != 255) {
            findViewById(R.id.air_sp_aqs).setOnTouchListener(this);
            findViewById(R.id.air_sp_aqs).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_aqs).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_WINLEV != 255) {
            findViewById(R.id.air_sp_winlev).setOnTouchListener(this);
            findViewById(R.id.air_sp_winlev).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_winlev).setVisibility(8);
        }
        if (ConstAllAirDara.C_SOFT != 255) {
            findViewById(R.id.air_sp_soft).setOnTouchListener(this);
            findViewById(R.id.air_sp_soft).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_soft).setVisibility(8);
        }
        if (ConstAllAirDara.C_FAST != 255) {
            findViewById(R.id.air_sp_fast).setOnTouchListener(this);
            findViewById(R.id.air_sp_fast).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_fast).setVisibility(8);
        }
        if (ConstAllAirDara.C_NORMAL != 255) {
            findViewById(R.id.air_sp_normal).setOnTouchListener(this);
            findViewById(R.id.air_sp_normal).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_normal).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_REST != 255) {
            findViewById(R.id.air_sp_rest).setOnTouchListener(this);
            findViewById(R.id.air_sp_rest).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_rest).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_CLEANAIR != 255) {
            findViewById(R.id.air_sp_clean_air).setOnTouchListener(this);
            findViewById(R.id.air_sp_clean_air).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_clean_air).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_AC != 255) {
            findViewById(R.id.air_sp_ac).setOnTouchListener(this);
            findViewById(R.id.air_sp_ac).setVisibility(0);
            findViewById(R.id.view_sp_ac).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_ac).setVisibility(8);
            findViewById(R.id.view_sp_ac).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_HEAT != 255) {
            findViewById(R.id.air_sp_heat).setOnTouchListener(this);
            findViewById(R.id.air_sp_heat).setVisibility(0);
            findViewById(R.id.view_sp_heat).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_heat).setVisibility(8);
            findViewById(R.id.view_sp_heat).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_COOL != 255) {
            findViewById(R.id.air_sp_cool).setOnTouchListener(this);
            findViewById(R.id.air_sp_cool).setVisibility(0);
            findViewById(R.id.view_sp_cool).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_cool).setVisibility(8);
            findViewById(R.id.view_sp_cool).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_AC_MAX != 255) {
            findViewById(R.id.air_sp_acmax).setOnTouchListener(this);
            findViewById(R.id.air_sp_acmax).setVisibility(0);
            findViewById(R.id.view_sp_acmax).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_acmax).setVisibility(8);
            findViewById(R.id.view_sp_acmax).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_AUTO != 255) {
            findViewById(R.id.air_sp_auto).setOnTouchListener(this);
            findViewById(R.id.air_sp_auto).setVisibility(0);
            findViewById(R.id.view_sp_auto).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_auto).setVisibility(8);
            findViewById(R.id.view_sp_auto).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_AUTO_RIGHT != 255) {
            findViewById(R.id.air_sp_auto_right).setVisibility(0);
            findViewById(R.id.view_sp_auto_right).setVisibility(0);
            findViewById(R.id.air_sp_auto_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_auto_right).setVisibility(8);
            findViewById(R.id.view_sp_auto_right).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_DUAL != 255) {
            findViewById(R.id.air_sp_dual).setOnTouchListener(this);
            findViewById(R.id.air_sp_dual).setVisibility(0);
            findViewById(R.id.view_sp_dual).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_dual).setVisibility(8);
            findViewById(R.id.view_sp_dual).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_CLEAN != 255) {
            findViewById(R.id.air_sp_clean).setOnTouchListener(this);
            findViewById(R.id.air_sp_clean).setVisibility(0);
            findViewById(R.id.view_sp_clean).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_clean).setVisibility(8);
            findViewById(R.id.view_sp_clean).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_SYNC != 255) {
            findViewById(R.id.air_sp_sync).setOnTouchListener(this);
            findViewById(R.id.air_sp_sync).setVisibility(0);
            findViewById(R.id.view_sp_sync).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_sync).setVisibility(8);
            findViewById(R.id.view_sp_sync).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_ZONE != 255) {
            findViewById(R.id.air_sp_zone).setOnTouchListener(this);
            findViewById(R.id.air_sp_zone).setVisibility(0);
            findViewById(R.id.view_sp_zone).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_zone).setVisibility(8);
            findViewById(R.id.view_sp_zone).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_FOREST != 255) {
            findViewById(R.id.air_sp_forest).setOnTouchListener(this);
            findViewById(R.id.air_sp_forest).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_forest).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_STEER != 255) {
            findViewById(R.id.air_sp_steer).setOnTouchListener(this);
            findViewById(R.id.air_sp_steer).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_steer).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_CYCLE != 255) {
            findViewById(R.id.air_sp_cycle).setOnTouchListener(this);
            findViewById(R.id.air_sp_cycle).setVisibility(0);
            findViewById(R.id.view_sp_cycle).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_cycle).setVisibility(8);
            findViewById(R.id.view_sp_cycle).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_PTC != 255) {
            findViewById(R.id.air_sp_ptc).setOnTouchListener(this);
            findViewById(R.id.air_sp_ptc).setVisibility(0);
            findViewById(R.id.view_sp_ptc).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_ptc).setVisibility(8);
            findViewById(R.id.view_sp_ptc).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_SWING != 255) {
            findViewById(R.id.air_sp_swing).setOnTouchListener(this);
            findViewById(R.id.air_sp_swing).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_swing).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_FRONT_HOT != 255) {
            findViewById(R.id.air_sp_front_hot).setOnTouchListener(this);
            findViewById(R.id.air_sp_front_hot).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_front_hot).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_ION != 255) {
            findViewById(R.id.air_sp_ion).setOnTouchListener(this);
            findViewById(R.id.air_sp_ion).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_ion).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_BLOWTOP != 255) {
            findViewById(R.id.air_sp_blowtop).setOnTouchListener(this);
            findViewById(R.id.air_sp_blowtop).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_blowtop).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_FRONT != 255) {
            findViewById(R.id.air_sp_front).setOnTouchListener(this);
            findViewById(R.id.air_sp_front).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_front).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_FRONTMAX != 255) {
            findViewById(R.id.air_sp_frontmax).setOnTouchListener(this);
            findViewById(R.id.air_sp_frontmax).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_frontmax).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_POWER != 255) {
            findViewById(R.id.air_sp_power).setOnTouchListener(this);
            findViewById(R.id.air_sp_power).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_power).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_EV != 255) {
            findViewById(R.id.air_sp_ev).setOnTouchListener(this);
            findViewById(R.id.air_sp_ev).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_ev).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_ECO != 255) {
            findViewById(R.id.air_sp_eco).setOnTouchListener(this);
            findViewById(R.id.air_sp_eco).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_eco).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_NANOE != 255) {
            findViewById(R.id.air_sp_nanoe).setOnTouchListener(this);
            findViewById(R.id.air_sp_nanoe).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_nanoe).setVisibility(8);
        }
        if (ConstAllAirDara.C_CLEAN != 255) {
            findViewById(R.id.air_sp_clean).setOnTouchListener(this);
            findViewById(R.id.air_sp_clean).setVisibility(0);
            findViewById(R.id.view_sp_clean).setVisibility(0);
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
        if (ConstAllAirDara.U_AIR_REAR != 255) {
            findViewById(R.id.air_sp_rear).setOnTouchListener(this);
            findViewById(R.id.air_sp_rear).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_rear).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_BODY != 255) {
            findViewById(R.id.air_sp_blow_body).setOnTouchListener(this);
            findViewById(R.id.air_sp_blow_body).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_blow_body).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_FOOT != 255) {
            findViewById(R.id.air_sp_blow_foot).setOnTouchListener(this);
            findViewById(R.id.air_sp_blow_foot).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_blow_foot).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_UP != 255) {
            findViewById(R.id.air_sp_blow_win).setOnTouchListener(this);
            findViewById(R.id.air_sp_blow_win).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_blow_win).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_BODYFOOT != 255) {
            findViewById(R.id.air_sp_blow_body_foot).setOnTouchListener(this);
            findViewById(R.id.air_sp_blow_body_foot).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_blow_body_foot).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_UPFOOT != 255) {
            findViewById(R.id.air_sp_blow_foot_win).setOnTouchListener(this);
            findViewById(R.id.air_sp_blow_foot_win).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_blow_foot_win).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_ADD != 255) {
            findViewById(R.id.air_sp_mode_add).setOnTouchListener(this);
            findViewById(R.id.air_sp_mode_add).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_mode_add).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_SUB != 255) {
            findViewById(R.id.air_sp_mode_sub).setOnTouchListener(this);
            findViewById(R.id.air_sp_mode_sub).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_mode_sub).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_CHANGER != 255) {
            findViewById(R.id.air_sp_blow_changer).setOnTouchListener(this);
            findViewById(R.id.air_sp_blow_changer).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_blow_changer).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT != 255) {
            findViewById(R.id.air_sp_blow_changer_right).setVisibility(0);
            findViewById(R.id.air_sp_blow_changer_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_blow_changer_right).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_SEATWIND_LEFT != 255) {
            findViewById(R.id.air_sp_seatwind_left).setOnTouchListener(this);
            findViewById(R.id.air_sp_seatwind_left).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_seatwind_left).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_SEATWIND_RIGHT != 255) {
            findViewById(R.id.air_sp_seatwind_right).setOnTouchListener(this);
            findViewById(R.id.air_sp_seatwind_right).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_seatwind_right).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_SEATHEAT_LEFT != 255) {
            findViewById(R.id.air_sp_seatheat_left).setOnTouchListener(this);
            findViewById(R.id.air_sp_seatheat_left).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_seatheat_left).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_SEATHEAT_RIGHT != 255) {
            findViewById(R.id.air_sp_seatheat_right).setOnTouchListener(this);
            findViewById(R.id.air_sp_seatheat_right).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_seatheat_right).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_BLOW_BODY_LEFT == 255) {
            findViewById(R.id.air_sp_mode_body).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_BLOW_UP_LEFT == 255) {
            findViewById(R.id.air_sp_mode_up).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT == 255) {
            findViewById(R.id.air_sp_mode_foot).setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        initCallbackId();
        init();
        addUpdater();
        AirHelper.disableAirWindowLocal(true);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeUpdater();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        boolean sendflag = false;
        switch (id) {
            case R.id.air_sp_temp_left_munits /* 2131430318 */:
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_BNR_02_09Toyato_Prado_H /* 7733687 */:
                        sendflag = true;
                        break;
                    default:
                        data0 = ConstAllAirDara.C_AIR_TEMP_LEFT_SUB;
                        break;
                }
            case R.id.air_sp_temp_left_plus /* 2131430321 */:
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_BNR_02_09Toyato_Prado_H /* 7733687 */:
                        sendflag = true;
                        break;
                    default:
                        data0 = ConstAllAirDara.C_AIR_TEMP_LEFT_ADD;
                        break;
                }
            case R.id.air_sp_blow_body_foot /* 2131430323 */:
                data0 = ConstAllAirDara.C_AIR_MODE_BODYFOOT;
                break;
            case R.id.air_sp_blow_foot /* 2131430324 */:
                data0 = ConstAllAirDara.C_AIR_MODE_FOOT;
                break;
            case R.id.air_sp_blow_body /* 2131430325 */:
                data0 = ConstAllAirDara.C_AIR_MODE_BODY;
                break;
            case R.id.air_sp_blow_foot_win /* 2131430326 */:
                data0 = ConstAllAirDara.C_AIR_MODE_UPFOOT;
                break;
            case R.id.air_sp_wind_minuts /* 2131430327 */:
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_WC2_Honda_AllCom_CIVIC /* 262465 */:
                    case FinalCanbus.CAR_WC2_Honda_17CRV /* 459073 */:
                    case FinalCanbus.CAR_WC2_Honda_16SIYU_HAND /* 786753 */:
                    case FinalCanbus.CAR_WC2_Honda_16SIYU_AUTO /* 852289 */:
                        if (event.getAction() == 0) {
                            int value = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                            if (value > 1) {
                                value--;
                            }
                            sendCmd(25, value);
                            sendflag = true;
                            break;
                        }
                    case FinalCanbus.CAR_BNR_02_09Toyato_Prado_H /* 7733687 */:
                        if (event.getAction() == 0) {
                            int value2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                            if (value2 > 1) {
                                value2--;
                            }
                            sendCmd(56, value2);
                            sendflag = true;
                            break;
                        }
                        break;
                    default:
                        data0 = ConstAllAirDara.C_AIR_WIND_SUB;
                        break;
                }
            case R.id.air_sp_wind_plus /* 2131430329 */:
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_WC2_Honda_AllCom_CIVIC /* 262465 */:
                    case FinalCanbus.CAR_WC2_Honda_17CRV /* 459073 */:
                    case FinalCanbus.CAR_WC2_Honda_16SIYU_HAND /* 786753 */:
                    case FinalCanbus.CAR_WC2_Honda_16SIYU_AUTO /* 852289 */:
                        if (event.getAction() == 0) {
                            int value3 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                            if (value3 < 7) {
                                value3++;
                            }
                            sendCmd(25, value3);
                            sendflag = true;
                            break;
                        }
                    case FinalCanbus.CAR_BNR_02_09Toyato_Prado_H /* 7733687 */:
                        if (event.getAction() == 0) {
                            int value4 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                            if (value4 < 5) {
                                value4++;
                            }
                            sendCmd(56, value4);
                            sendflag = true;
                            break;
                        }
                        break;
                    default:
                        data0 = ConstAllAirDara.C_AIR_WIND_ADD;
                        break;
                }
            case R.id.air_sp_ac /* 2131430330 */:
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_WC2_Honda_AllCom_CIVIC /* 262465 */:
                    case FinalCanbus.CAR_WC2_Honda_17CRV /* 459073 */:
                    case FinalCanbus.CAR_WC2_Honda_16SIYU_HAND /* 786753 */:
                    case FinalCanbus.CAR_WC2_Honda_16SIYU_AUTO /* 852289 */:
                        if (event.getAction() == 0) {
                            int value5 = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC];
                            if (value5 == 1) {
                                value5 = 0;
                            } else if (value5 == 0) {
                                value5 = 1;
                            }
                            sendCmd(2, value5);
                            sendflag = true;
                            break;
                        }
                        break;
                    default:
                        data0 = ConstAllAirDara.C_AIR_AC;
                        break;
                }
            case R.id.air_sp_front /* 2131430331 */:
                data0 = ConstAllAirDara.C_AIR_FRONT_DEFROST;
                break;
            case R.id.air_sp_rear /* 2131430332 */:
                data0 = ConstAllAirDara.C_AIR_REAR_DEFROST;
                break;
            case R.id.air_sp_cycle /* 2131430333 */:
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_XP1_CYT_XuanYi_H /* 524431 */:
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            data0 = 6;
                            break;
                        } else {
                            data0 = 5;
                            break;
                        }
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
                    case FinalCanbus.CAR_452_XinCheng_Infiniti_ESQ /* 1573316 */:
                    case FinalCanbus.CAR_439_RZC_TuDa /* 4915639 */:
                    case FinalCanbus.CAR_439_RZC_14QiJun_Auto /* 5374391 */:
                    case FinalCanbus.CAR_439_RZC_14QiJun_Hand /* 5439927 */:
                    case FinalCanbus.CAR_439_RZC_16Xiaoke_Auto /* 5505463 */:
                    case FinalCanbus.CAR_439_RZC_16Xiaoke_Hand /* 5570999 */:
                    case FinalCanbus.CAR_439_RZC_13Tianlai_Auto /* 5636535 */:
                    case FinalCanbus.CAR_439_RZC_13Tianlai_Hand /* 5702071 */:
                    case FinalCanbus.CAR_439_RZC_08Tianlai_Auto /* 5767607 */:
                    case FinalCanbus.CAR_439_RZC_08Tianlai_Hand /* 5833143 */:
                    case FinalCanbus.CAR_439_RZC_16Qida_Auto /* 5898679 */:
                    case FinalCanbus.CAR_439_RZC_16Qida_Hand /* 5964215 */:
                    case FinalCanbus.CAR_439_RZC_TuDa_Hand /* 11207095 */:
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            data0 = 35;
                            break;
                        } else {
                            data0 = 34;
                            break;
                        }
                    case FinalCanbus.CAR_RZC_DongFeng_Fengxing_M7 /* 1114339 */:
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            data0 = 5;
                            break;
                        } else {
                            data0 = 4;
                            break;
                        }
                    default:
                        data0 = ConstAllAirDara.C_AIR_CYCLE;
                        break;
                }
            case R.id.air_sp_power /* 2131430334 */:
                switch (DataCanbus.DATA[1000]) {
                    case 373:
                    case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_H /* 65909 */:
                    case FinalCanbus.CAR_RZC_XP1_GrdCherokee /* 196981 */:
                    case FinalCanbus.CAR_RZC_17ZhiNanZhe /* 262517 */:
                    case FinalCanbus.CAR_RZC_17ZhiNanZhe_H /* 328053 */:
                    case FinalCanbus.CAR_RZC_XP1_GrdCherokee_H /* 459125 */:
                    case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19 /* 852341 */:
                    case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19_H /* 917877 */:
                    case FinalCanbus.CAR_RZC_Dodge_RAM /* 1311093 */:
                    case FinalCanbus.CAR_RZC_Dodge_RAM_H /* 1376629 */:
                    case FinalCanbus.CAR_RZC_Dodge_RAM_M /* 1835381 */:
                    case FinalCanbus.CAR_RZC_Dodge_RAM_HY /* 1900917 */:
                    case FinalCanbus.CAR_RZC_Dodge_RAM_HY_M /* 1966453 */:
                    case FinalCanbus.CAR_RZC_Dodge_RAM_HY_H /* 2031989 */:
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_POWER] == 1) {
                            data0 = 16;
                            break;
                        } else {
                            data0 = 9;
                            break;
                        }
                    default:
                        data0 = ConstAllAirDara.C_AIR_POWER;
                        break;
                }
            case R.id.air_sp_seatwind_left /* 2131430336 */:
                data0 = ConstAllAirDara.C_AIR_LEFT_COLD;
                break;
            case R.id.air_sp_seatheat_left /* 2131430338 */:
                data0 = ConstAllAirDara.C_AIR_LEFT_HEAT;
                break;
            case R.id.air_sp_auto /* 2131430340 */:
                data0 = ConstAllAirDara.C_AIR_AUTO;
                break;
            case R.id.air_sp_ptc /* 2131430342 */:
                data0 = ConstAllAirDara.C_AIR_PTC;
                break;
            case R.id.air_sp_frontmax /* 2131430348 */:
                data0 = ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST;
                break;
            case R.id.air_sp_car_rear /* 2131430350 */:
                data0 = ConstAllAirDara.C_REAR_CTRL;
                break;
            case R.id.air_sp_acmax /* 2131430352 */:
                data0 = ConstAllAirDara.C_AIR_AC_MAX;
                break;
            case R.id.air_sp_ion /* 2131430354 */:
                data0 = ConstAllAirDara.C_AIR_ION;
                break;
            case R.id.air_sp_clean /* 2131430356 */:
                data0 = ConstAllAirDara.C_CLEAN;
                break;
            case R.id.air_sp_eco /* 2131430358 */:
                data0 = ConstAllAirDara.C_AIR_ECO;
                break;
            case R.id.air_sp_blowtop /* 2131430360 */:
                data0 = ConstAllAirDara.C_AIR_BLOWTOP;
                break;
            case R.id.air_sp_aqs /* 2131430362 */:
                data0 = ConstAllAirDara.C_AIR_AQS;
                break;
            case R.id.air_sp_zone /* 2131430364 */:
                data0 = ConstAllAirDara.C_AIR_ZONE;
                break;
            case R.id.air_sp_sync /* 2131430366 */:
                data0 = ConstAllAirDara.C_AIR_SYNC;
                break;
            case R.id.air_sp_dual /* 2131430368 */:
                data0 = ConstAllAirDara.C_AIR_DUAL;
                break;
            case R.id.air_sp_nanoe /* 2131430370 */:
                data0 = ConstAllAirDara.C_AIR_NANOE;
                break;
            case R.id.air_sp_swing /* 2131430372 */:
                data0 = ConstAllAirDara.C_AIR_SWING;
                break;
            case R.id.air_sp_winlev /* 2131430374 */:
                data0 = ConstAllAirDara.C_AIR_WINLEV;
                break;
            case R.id.air_sp_steer /* 2131430376 */:
                data0 = ConstAllAirDara.C_AIR_STEER;
                break;
            case R.id.air_sp_heat /* 2131430378 */:
                data0 = ConstAllAirDara.C_AIR_HEAT;
                break;
            case R.id.air_sp_seatheat_right /* 2131430382 */:
                data0 = ConstAllAirDara.C_AIR_RIGHT_HEAT;
                break;
            case R.id.air_sp_seatwind_right /* 2131430384 */:
                data0 = ConstAllAirDara.C_AIR_RIGHT_COLD;
                break;
            case R.id.air_sp_blow_win /* 2131430399 */:
                data0 = ConstAllAirDara.C_AIR_MODE_UP;
                break;
            case R.id.air_sp_blow_changer /* 2131430407 */:
                data0 = ConstAllAirDara.C_AIR_MODE_CHANGER;
                break;
            case R.id.air_sp_blow_changer_right /* 2131430415 */:
                data0 = ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT;
                break;
            case R.id.air_sp_temp_right_plus /* 2131430416 */:
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_BNR_02_09Toyato_Prado_H /* 7733687 */:
                        sendflag = true;
                        break;
                    default:
                        data0 = ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD;
                        break;
                }
            case R.id.air_sp_temp_right_munits /* 2131430423 */:
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_BNR_02_09Toyato_Prado_H /* 7733687 */:
                        sendflag = true;
                        break;
                    default:
                        data0 = ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB;
                        break;
                }
            case R.id.air_sp_soft /* 2131430475 */:
                data0 = ConstAllAirDara.C_SOFT;
                break;
            case R.id.air_sp_normal /* 2131430476 */:
                data0 = ConstAllAirDara.C_NORMAL;
                break;
            case R.id.air_sp_fast /* 2131430477 */:
                data0 = ConstAllAirDara.C_FAST;
                break;
            case R.id.air_sp_ev /* 2131430479 */:
                data0 = ConstAllAirDara.C_AIR_EV;
                break;
            case R.id.air_sp_clean_air /* 2131430480 */:
                data0 = ConstAllAirDara.C_CLEAN_AIR;
                break;
            case R.id.air_sp_front_hot /* 2131430481 */:
                data0 = ConstAllAirDara.C_AIR_FRONT_HOT;
                break;
            case R.id.air_sp_forest /* 2131430482 */:
                data0 = ConstAllAirDara.C_AIR_FOREST;
                break;
            case R.id.air_sp_mode_sub /* 2131430487 */:
                data0 = ConstAllAirDara.C_AIR_MODE_SUB;
                break;
            case R.id.air_sp_mode_add /* 2131430488 */:
                data0 = ConstAllAirDara.C_AIR_MODE_ADD;
                break;
            case R.id.air_sp_cool /* 2131430491 */:
                data0 = ConstAllAirDara.C_AIR_COOL;
                break;
            case R.id.air_sp_em /* 2131430493 */:
                data0 = ConstAllAirDara.C_AIR_EM;
                break;
        }
        if (!sendflag) {
            if (event.getAction() == 0) {
                sendCmd(data0, 1);
            } else if (event.getAction() == 1) {
                sendCmd(data0, 0);
            }
        }
        return false;
    }

    private void addUpdater() {
        if (ConstAllAirDara.U_AIR_REAR != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_CYCLE != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_CYCLE].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_PTC != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_PTC].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_SWING != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SWING].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_FRONT_HOT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FRONT_HOT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_ION != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_ION].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BLOWTOP != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOWTOP].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_CYCLE_AUTO != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_CYCLE_AUTO].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_AC != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_AC].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_POWER != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_POWER].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BLOW_BODYFOOT_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_BODYFOOT_LEFT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BLOW_UPFOOT_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_UPFOOT_LEFT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_FRONT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FRONT].addNotify(this.mNotifyCanbus, 1);
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
        if (ConstAllAirDara.U_AIR_AC_MAX != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_AC_MAX].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_FRONTMAX != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FRONTMAX].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_AUTO != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_AUTO].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_AUTO_LEV != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_AUTO_LEV].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_DUAL != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_DUAL].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_SYNC != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SYNC].addNotify(this.mNotifyCanbus, 1);
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
        if (ConstAllAirDara.U_AIR_TEMP_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_TEMP_RIGHT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_TEMP_UNIT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_TEMP_UNIT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_EV != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_EV].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_ECO != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_ECO].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_NANOE != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_NANOE].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_REAR_CTRL != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR_CTRL].addNotify(this.mNotifyCanbus, 1);
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
        if (ConstAllAirDara.U_AIR_MODE != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_MODE].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_AQS != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_AQS].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_WINLEV != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_WINLEV].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_CLEANAIR != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_CLEANAIR].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_HEAT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_HEAT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_COOL != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_COOL].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_REST != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REST].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_ZONE != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_ZONE].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_FOREST != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FOREST].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_STEER != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_STEER].addNotify(this.mNotifyCanbus, 1);
        }
    }

    private void removeUpdater() {
        if (ConstAllAirDara.U_AIR_REAR != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_POWER != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_POWER].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_AC != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_AC].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_CYCLE != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_CYCLE].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_PTC != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_PTC].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_SWING != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SWING].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_FRONT_HOT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FRONT_HOT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_ION != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_ION].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BLOWTOP != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOWTOP].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_CYCLE_AUTO != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_CYCLE_AUTO].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BLOW_BODYFOOT_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_BODYFOOT_LEFT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BLOW_UPFOOT_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_UPFOOT_LEFT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_FRONT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FRONT].removeNotify(this.mNotifyCanbus);
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
        if (ConstAllAirDara.U_AIR_AC_MAX != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_AC_MAX].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_FRONTMAX != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FRONTMAX].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_AUTO != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_AUTO].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_AUTO_LEV != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_AUTO_LEV].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_DUAL != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_DUAL].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_SYNC != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SYNC].removeNotify(this.mNotifyCanbus);
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
        if (ConstAllAirDara.U_AIR_TEMP_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_TEMP_RIGHT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_TEMP_UNIT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_TEMP_UNIT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_EV != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_EV].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_ECO != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_ECO].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_NANOE != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_NANOE].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_REAR_CTRL != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR_CTRL].removeNotify(this.mNotifyCanbus);
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
        if (ConstAllAirDara.U_AIR_MODE != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_MODE].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_AQS != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_AQS].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_WINLEV != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_WINLEV].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_CLEANAIR != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_CLEANAIR].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_HEAT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_HEAT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_COOL != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_COOL].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_REST != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REST].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_ZONE != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_ZONE].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_FOREST != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FOREST].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_STEER != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_STEER].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirRest() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REST];
        findViewById(R.id.air_sp_rest).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_rest_n : R.drawable.ic_sp_rest_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirHeat() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_HEAT];
        findViewById(R.id.air_sp_heat).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_heat_n : R.drawable.ic_sp_heat_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirCool() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_COOL];
        findViewById(R.id.air_sp_cool).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_cool_n : R.drawable.ic_sp_cool_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirWinlev() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_WINLEV];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_winlev).setBackgroundResource(R.drawable.ic_sp_winlev1);
                break;
            case 1:
                findViewById(R.id.air_sp_winlev).setBackgroundResource(R.drawable.ic_sp_winlev2);
                break;
            case 2:
                findViewById(R.id.air_sp_winlev).setBackgroundResource(R.drawable.ic_sp_winlev3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirAQS() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_AQS];
        findViewById(R.id.air_sp_aqs).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_aqs_n : R.drawable.ic_sp_aqs_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirMode() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_MODE];
        findViewById(R.id.air_sp_soft).setBackgroundResource(R.drawable.ic_sp_soft_n);
        findViewById(R.id.air_sp_normal).setBackgroundResource(R.drawable.ic_sp_normal_n);
        findViewById(R.id.air_sp_fast).setBackgroundResource(R.drawable.ic_sp_fast_n);
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_soft).setBackgroundResource(R.drawable.ic_sp_soft_p);
                break;
            case 1:
                findViewById(R.id.air_sp_normal).setBackgroundResource(R.drawable.ic_sp_normal_p);
                break;
            case 2:
                findViewById(R.id.air_sp_fast).setBackgroundResource(R.drawable.ic_sp_fast_p);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirNormal() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_NORMAL];
        findViewById(R.id.air_sp_normal).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_normal_n : R.drawable.ic_sp_normal_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirFast() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_FAST];
        findViewById(R.id.air_sp_fast).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_fast_n : R.drawable.ic_sp_fast_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirSoft() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SOFT];
        findViewById(R.id.air_sp_soft).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_soft_n : R.drawable.ic_sp_soft_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearCtrl() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_CTRL];
        findViewById(R.id.air_sp_car_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_carrear_n : R.drawable.ic_sp_carrear_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCleanAir() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_CLEANAIR];
        findViewById(R.id.air_sp_clean_air).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_cleanair_n : R.drawable.ic_sp_cleanair_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateHeatLeft() {
        int vel;
        int flag;
        int heatlevel;
        int blowlevel;
        int heatlevel2;
        int i = R.drawable.ic_air_sp_seatheat_left;
        int vel2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT];
        if (DataCanbus.DATA[1000] == 334 || DataCanbus.DATA[1000] == 262478 || DataCanbus.DATA[1000] == 2425166 || DataCanbus.DATA[1000] == 2359630 || DataCanbus.DATA[1000] == 2621774 || DataCanbus.DATA[1000] == 2687310 || DataCanbus.DATA[1000] == 2752846 || DataCanbus.DATA[1000] == 2818382 || DataCanbus.DATA[1000] == 2883918) {
            if (vel2 <= 3) {
                vel = 0;
            } else {
                vel = vel2 - 3;
            }
            View findViewById = findViewById(R.id.air_sp_seatheat_left);
            if (vel != 0) {
                i = 2130839086;
            }
            findViewById.setBackgroundResource(i);
            ((TextView) findViewById(R.id.air_sp_seatheat_left)).setText(new StringBuilder().append(vel).toString());
            return;
        }
        if (DataCanbus.DATA[1000] == 3670468) {
            if ((vel2 & 8) != 0) {
                blowlevel = 16 - vel2;
                heatlevel2 = 0;
            } else {
                blowlevel = 0;
                heatlevel2 = vel2;
            }
            View findViewById2 = findViewById(R.id.air_sp_seatheat_left);
            if (heatlevel2 != 0) {
                i = 2130839086;
            }
            findViewById2.setBackgroundResource(i);
            ((TextView) findViewById(R.id.air_sp_seatheat_left)).setText(new StringBuilder().append(heatlevel2).toString());
            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(blowlevel == 0 ? R.drawable.ic_air_sp_seatwind_left : R.drawable.ic_air_sp_seatwind_left_p);
            ((TextView) findViewById(R.id.air_sp_seatwind_left)).setText(new StringBuilder().append(blowlevel).toString());
            return;
        }
        if (DataCanbus.DATA[1000] == 7995844 || DataCanbus.DATA[1000] == 13631940 || DataCanbus.DATA[1000] == 16515524) {
            if ((vel2 & 8) != 0) {
                heatlevel = 16 - vel2;
                flag = 1;
            } else {
                flag = 0;
                heatlevel = vel2;
            }
            View findViewById3 = findViewById(R.id.air_sp_seatheat_left);
            if (heatlevel != 0) {
                i = 2130839086;
            }
            findViewById3.setBackgroundResource(i);
            if (flag == 1) {
                ((TextView) findViewById(R.id.air_sp_seatheat_left)).setText("-" + heatlevel);
                return;
            } else {
                ((TextView) findViewById(R.id.air_sp_seatheat_left)).setText(new StringBuilder().append(heatlevel).toString());
                return;
            }
        }
        View findViewById4 = findViewById(R.id.air_sp_seatheat_left);
        if (vel2 != 0) {
            i = 2130839086;
        }
        findViewById4.setBackgroundResource(i);
        ((TextView) findViewById(R.id.air_sp_seatheat_left)).setText(new StringBuilder().append(vel2).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateHeatRight() {
        int vel;
        int flag;
        int heatlevel;
        int i = R.drawable.ic_air_sp_seatheat_right;
        int vel2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT];
        if (DataCanbus.DATA[1000] == 334 || DataCanbus.DATA[1000] == 262478 || DataCanbus.DATA[1000] == 2425166 || DataCanbus.DATA[1000] == 2359630 || DataCanbus.DATA[1000] == 2621774 || DataCanbus.DATA[1000] == 2687310 || DataCanbus.DATA[1000] == 2752846 || DataCanbus.DATA[1000] == 2818382 || DataCanbus.DATA[1000] == 2883918) {
            if (vel2 <= 3) {
                vel = 0;
            } else {
                vel = vel2 - 3;
            }
            View findViewById = findViewById(R.id.air_sp_seatheat_right);
            if (vel != 0) {
                i = 2130839088;
            }
            findViewById.setBackgroundResource(i);
            ((TextView) findViewById(R.id.air_sp_seatheat_right)).setText(new StringBuilder().append(vel).toString());
            return;
        }
        if (DataCanbus.DATA[1000] == 7995844 || DataCanbus.DATA[1000] == 13631940 || DataCanbus.DATA[1000] == 16515524) {
            if ((vel2 & 8) != 0) {
                heatlevel = 16 - vel2;
                flag = 1;
            } else {
                flag = 0;
                heatlevel = vel2;
            }
            View findViewById2 = findViewById(R.id.air_sp_seatheat_right);
            if (heatlevel != 0) {
                i = 2130839088;
            }
            findViewById2.setBackgroundResource(i);
            if (flag == 1) {
                ((TextView) findViewById(R.id.air_sp_seatheat_right)).setText("-" + heatlevel);
                return;
            } else {
                ((TextView) findViewById(R.id.air_sp_seatheat_right)).setText(new StringBuilder().append(heatlevel).toString());
                return;
            }
        }
        View findViewById3 = findViewById(R.id.air_sp_seatheat_right);
        if (vel2 != 0) {
            i = 2130839088;
        }
        findViewById3.setBackgroundResource(i);
        ((TextView) findViewById(R.id.air_sp_seatheat_right)).setText(new StringBuilder().append(vel2).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateWindLeft() {
        int i = R.drawable.ic_air_sp_seatwind_left;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_LEFT];
        if (DataCanbus.DATA[1000] == 334 || DataCanbus.DATA[1000] == 262478 || DataCanbus.DATA[1000] == 2425166 || DataCanbus.DATA[1000] == 2359630 || DataCanbus.DATA[1000] == 2621774 || DataCanbus.DATA[1000] == 2687310 || DataCanbus.DATA[1000] == 2752846 || DataCanbus.DATA[1000] == 2818382 || DataCanbus.DATA[1000] == 2883918) {
            if (vel > 3) {
                vel = 0;
            }
            View findViewById = findViewById(R.id.air_sp_seatwind_left);
            if (vel != 0) {
                i = 2130839098;
            }
            findViewById.setBackgroundResource(i);
            ((TextView) findViewById(R.id.air_sp_seatwind_left)).setText(new StringBuilder().append(vel).toString());
            return;
        }
        View findViewById2 = findViewById(R.id.air_sp_seatwind_left);
        if (vel != 0) {
            i = 2130839098;
        }
        findViewById2.setBackgroundResource(i);
        ((TextView) findViewById(R.id.air_sp_seatwind_left)).setText(new StringBuilder().append(vel).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateWindRight() {
        int i = R.drawable.ic_air_sp_seatwind_right;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_RIGHT];
        if (DataCanbus.DATA[1000] == 334 || DataCanbus.DATA[1000] == 262478 || DataCanbus.DATA[1000] == 2425166 || DataCanbus.DATA[1000] == 2359630 || DataCanbus.DATA[1000] == 2621774 || DataCanbus.DATA[1000] == 2687310 || DataCanbus.DATA[1000] == 2752846 || DataCanbus.DATA[1000] == 2818382 || DataCanbus.DATA[1000] == 2883918) {
            if (vel > 3) {
                vel = 0;
            }
            View findViewById = findViewById(R.id.air_sp_seatwind_right);
            if (vel != 0) {
                i = 2130839100;
            }
            findViewById.setBackgroundResource(i);
            ((TextView) findViewById(R.id.air_sp_seatwind_right)).setText(new StringBuilder().append(vel).toString());
            return;
        }
        View findViewById2 = findViewById(R.id.air_sp_seatwind_right);
        if (vel != 0) {
            i = 2130839100;
        }
        findViewById2.setBackgroundResource(i);
        ((TextView) findViewById(R.id.air_sp_seatwind_right)).setText(new StringBuilder().append(vel).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT];
        if (((TextView) findViewById(R.id.air_sp_temp_left)) != null) {
            if (temp == ConstAllAirDara.TEMPERATURE_LOW) {
                switch (DataCanbus.DATA[1000]) {
                    case 423:
                    case 427:
                    case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6 /* 131379 */:
                    case FinalCanbus.CAR_BNR_17LIENUO_L /* 262546 */:
                    case FinalCanbus.CAR_BNR_17KeLeiJia_L /* 459154 */:
                    case FinalCanbus.CAR_BNR_XP1_New_KLZ /* 524667 */:
                    case FinalCanbus.CAR_BNR_XP1_Mairuibao_L /* 590203 */:
                    case FinalCanbus.CAR_BNR_XP1_Mairuibao_H /* 655739 */:
                    case FinalCanbus.CAR_RZC_17LIENUO_L /* 655762 */:
                    case FinalCanbus.CAR_BNR_XP1_JunWei_L /* 721275 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_13 /* 852029 */:
                    case FinalCanbus.CAR_RZC_17KeLeiJia_L /* 852370 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_14 /* 917565 */:
                    case FinalCanbus.CAR_BNR_XP1_New_YingLang_L /* 983419 */:
                    case FinalCanbus.CAR_BNR_XP1_New_YingLang_H /* 1048955 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_17 /* 1114173 */:
                    case FinalCanbus.CAR_RZC_18KeLeiAo_L /* 1114514 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_19 /* 1245245 */:
                    case FinalCanbus.CAR_BNR_XP1_WeiLang_L /* 1245563 */:
                    case FinalCanbus.CAR_BNR_XP1_YingLang_L /* 1376635 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_23 /* 1507389 */:
                    case FinalCanbus.CAR_BNR_XP1_MairuibaoXL_L /* 1638779 */:
                    case FinalCanbus.CAR_RZC_MEGANE_Turkey_L /* 1638802 */:
                    case FinalCanbus.CAR_BNR_XP1_New_Klz_Top /* 1966459 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_32 /* 2097213 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_33 /* 2162749 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_34 /* 2228285 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_35 /* 2293821 */:
                    case FinalCanbus.CAR_BNR_RZC_Mairuibao_L /* 2359675 */:
                    case FinalCanbus.CAR_BNR_RZC_Mairuibao_H /* 2425211 */:
                    case FinalCanbus.CAR_RZC_Turkey_16KADJAR_L /* 3801490 */:
                    case FinalCanbus.CAR_439_RZC_ChangAn_CX70 /* 4391351 */:
                    case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9 /* 5702084 */:
                    case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_Auto /* 5833156 */:
                    case FinalCanbus.CAR_439_RZC_ChangAn_OUSAN_KESAI /* 7471543 */:
                    case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_EV /* 10355140 */:
                    case FinalCanbus.CAR_452_RZC_ChangAn_KESAI_Pro_21 /* 11010500 */:
                    case FinalCanbus.CAR_439_DJ_Siyu /* 14549431 */:
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("LO");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText("LO");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                        break;
                    default:
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("LO");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                        break;
                }
            }
            if (temp == ConstAllAirDara.TEMPERATURE_HIGHT) {
                switch (DataCanbus.DATA[1000]) {
                    case 423:
                    case 427:
                    case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6 /* 131379 */:
                    case FinalCanbus.CAR_BNR_17LIENUO_L /* 262546 */:
                    case FinalCanbus.CAR_BNR_17KeLeiJia_L /* 459154 */:
                    case FinalCanbus.CAR_BNR_XP1_New_KLZ /* 524667 */:
                    case FinalCanbus.CAR_BNR_XP1_Mairuibao_L /* 590203 */:
                    case FinalCanbus.CAR_BNR_XP1_Mairuibao_H /* 655739 */:
                    case FinalCanbus.CAR_RZC_17LIENUO_L /* 655762 */:
                    case FinalCanbus.CAR_BNR_XP1_JunWei_L /* 721275 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_13 /* 852029 */:
                    case FinalCanbus.CAR_RZC_17KeLeiJia_L /* 852370 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_14 /* 917565 */:
                    case FinalCanbus.CAR_BNR_XP1_New_YingLang_L /* 983419 */:
                    case FinalCanbus.CAR_BNR_XP1_New_YingLang_H /* 1048955 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_17 /* 1114173 */:
                    case FinalCanbus.CAR_RZC_18KeLeiAo_L /* 1114514 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_19 /* 1245245 */:
                    case FinalCanbus.CAR_BNR_XP1_WeiLang_L /* 1245563 */:
                    case FinalCanbus.CAR_BNR_XP1_YingLang_L /* 1376635 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_23 /* 1507389 */:
                    case FinalCanbus.CAR_BNR_XP1_MairuibaoXL_L /* 1638779 */:
                    case FinalCanbus.CAR_RZC_MEGANE_Turkey_L /* 1638802 */:
                    case FinalCanbus.CAR_BNR_XP1_New_Klz_Top /* 1966459 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_32 /* 2097213 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_33 /* 2162749 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_34 /* 2228285 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_35 /* 2293821 */:
                    case FinalCanbus.CAR_BNR_RZC_Mairuibao_L /* 2359675 */:
                    case FinalCanbus.CAR_BNR_RZC_Mairuibao_H /* 2425211 */:
                    case FinalCanbus.CAR_RZC_Turkey_16KADJAR_L /* 3801490 */:
                    case FinalCanbus.CAR_439_RZC_ChangAn_CX70 /* 4391351 */:
                    case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9 /* 5702084 */:
                    case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_Auto /* 5833156 */:
                    case FinalCanbus.CAR_439_RZC_ChangAn_OUSAN_KESAI /* 7471543 */:
                    case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_EV /* 10355140 */:
                    case FinalCanbus.CAR_452_RZC_ChangAn_KESAI_Pro_21 /* 11010500 */:
                    case FinalCanbus.CAR_439_DJ_Siyu /* 14549431 */:
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("HI");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText("HI");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                        break;
                    default:
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("HI");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                        break;
                }
            }
            if (temp == ConstAllAirDara.TEMPERATURE_NONE) {
                switch (DataCanbus.DATA[1000]) {
                    case 423:
                    case 427:
                    case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6 /* 131379 */:
                    case FinalCanbus.CAR_BNR_17LIENUO_L /* 262546 */:
                    case FinalCanbus.CAR_BNR_17KeLeiJia_L /* 459154 */:
                    case FinalCanbus.CAR_BNR_XP1_New_KLZ /* 524667 */:
                    case FinalCanbus.CAR_BNR_XP1_Mairuibao_L /* 590203 */:
                    case FinalCanbus.CAR_BNR_XP1_Mairuibao_H /* 655739 */:
                    case FinalCanbus.CAR_RZC_17LIENUO_L /* 655762 */:
                    case FinalCanbus.CAR_BNR_XP1_JunWei_L /* 721275 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_13 /* 852029 */:
                    case FinalCanbus.CAR_RZC_17KeLeiJia_L /* 852370 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_14 /* 917565 */:
                    case FinalCanbus.CAR_BNR_XP1_New_YingLang_L /* 983419 */:
                    case FinalCanbus.CAR_BNR_XP1_New_YingLang_H /* 1048955 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_17 /* 1114173 */:
                    case FinalCanbus.CAR_RZC_18KeLeiAo_L /* 1114514 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_19 /* 1245245 */:
                    case FinalCanbus.CAR_BNR_XP1_WeiLang_L /* 1245563 */:
                    case FinalCanbus.CAR_BNR_XP1_YingLang_L /* 1376635 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_23 /* 1507389 */:
                    case FinalCanbus.CAR_BNR_XP1_MairuibaoXL_L /* 1638779 */:
                    case FinalCanbus.CAR_RZC_MEGANE_Turkey_L /* 1638802 */:
                    case FinalCanbus.CAR_BNR_XP1_New_Klz_Top /* 1966459 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_32 /* 2097213 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_33 /* 2162749 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_34 /* 2228285 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_SP_35 /* 2293821 */:
                    case FinalCanbus.CAR_BNR_RZC_Mairuibao_L /* 2359675 */:
                    case FinalCanbus.CAR_BNR_RZC_Mairuibao_H /* 2425211 */:
                    case FinalCanbus.CAR_RZC_Turkey_16KADJAR_L /* 3801490 */:
                    case FinalCanbus.CAR_439_RZC_ChangAn_CX70 /* 4391351 */:
                    case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9 /* 5702084 */:
                    case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_Auto /* 5833156 */:
                    case FinalCanbus.CAR_439_RZC_ChangAn_OUSAN_KESAI /* 7471543 */:
                    case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_EV /* 10355140 */:
                    case FinalCanbus.CAR_452_RZC_ChangAn_KESAI_Pro_21 /* 11010500 */:
                    case FinalCanbus.CAR_439_DJ_Siyu /* 14549431 */:
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("--");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText("--");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                        break;
                    default:
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("--");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                        break;
                }
            }
            switch (DataCanbus.DATA[1000]) {
                case 21:
                case 425:
                case FinalCanbus.CAR_WC2_MengDiOuZS2013_M /* 65557 */:
                case FinalCanbus.CAR_XFY_ShuPing_Honda_GuanDao_H /* 65961 */:
                case FinalCanbus.CAR_WC2_MengDiOuZS2013_H /* 131093 */:
                case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL /* 196629 */:
                case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL_M /* 262165 */:
                case FinalCanbus.CAR_XFY_ShuPing_Honda_06CRV /* 262569 */:
                case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL_H /* 327701 */:
                case FinalCanbus.CAR_BNR_HONDA_16Civic_Vsceen_L /* 393514 */:
                case FinalCanbus.CAR_BNR_HONDA_16Civic_Vsceen_H /* 459050 */:
                case FinalCanbus.CAR_BNR_HONDA_Avancier_Vsceen_NoAmp /* 655658 */:
                case FinalCanbus.CAR_BNR_HONDA_Avancier_Vsceen_Amp_View /* 721194 */:
                case FinalCanbus.CAR_BNR_17CRV /* 983338 */:
                case FinalCanbus.CAR_RZC_HONDA_16Civic_Vsceen_L /* 1048874 */:
                case FinalCanbus.CAR_RZC_HONDA_16Civic_Vsceen_H /* 1114410 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(((temp * 5) / 10) + "." + ((temp * 5) % 10));
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(temp).toString());
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℉");
                        break;
                    }
                case 276:
                    int temp2 = (temp * 10) + 170;
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp2 / 10) + "." + (temp2 % 10));
                    ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
                    break;
                case 334:
                case FinalCanbus.CAR_RZC_ZhiSheng_Old /* 262478 */:
                case FinalCanbus.CAR_RZC_Ford_Lincoln_navigator /* 1900878 */:
                case FinalCanbus.CAR_RZC_Ford_F150_12 /* 2294094 */:
                case FinalCanbus.CAR_RZC_Mustang_NO_CD /* 2359630 */:
                case FinalCanbus.CAR_RZC_LHT_Ford_F150_Auto /* 2425166 */:
                case FinalCanbus.CAR_RZC_Mustang_15_NO_CD /* 2621774 */:
                case FinalCanbus.CAR_RZC_Mustang_HY_LEFT /* 2687310 */:
                case FinalCanbus.CAR_RZC_Mustang_HY_RIGHT /* 2752846 */:
                case FinalCanbus.CAR_RZC_Mustang_HY_LOW /* 2818382 */:
                case FinalCanbus.CAR_RZC_Mustang_HY_H /* 2883918 */:
                case FinalCanbus.CAR_RZC_Ford_F150 /* 3080526 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp / 10) + "." + (temp % 10));
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(temp / 10).toString());
                    }
                    mUpdateTempUNITLeft();
                    break;
                case 373:
                case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_H /* 65909 */:
                case FinalCanbus.CAR_RZC_XP1_GrdCherokee /* 196981 */:
                case FinalCanbus.CAR_RZC_XP1_GrdCherokee_H /* 459125 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM /* 1311093 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_H /* 1376629 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_M /* 1835381 */:
                    int temp3 = temp * 10;
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp3 / 10) + "." + (temp3 % 10));
                    mUpdateTempUNITLeft();
                    break;
                case 374:
                case FinalCanbus.CAR_XP1_ZiYouGuang_H /* 65910 */:
                case FinalCanbus.CAR_CYT_YaGe7_Portrait /* 65953 */:
                case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6_H /* 196915 */:
                case FinalCanbus.CAR_CYT_YaGe8 /* 197025 */:
                case FinalCanbus.CAR_BNR_17LIENUO_M /* 328082 */:
                case FinalCanbus.CAR_RCW_BYD_10_11F6 /* 328097 */:
                case FinalCanbus.CAR_BNR_17LIENUO_H /* 393618 */:
                case FinalCanbus.CAR_RCW_BYD_10_13G6 /* 393633 */:
                case FinalCanbus.CAR_BNR_17KeLeiJia_H /* 524690 */:
                case FinalCanbus.CAR_RZC4_PSA_19_408 /* 590163 */:
                case FinalCanbus.CAR_BNR_18KeLeiAo_M /* 590226 */:
                case FinalCanbus.CAR_RZC4_PSA_19_408_H /* 655699 */:
                case FinalCanbus.CAR_RZC_17LIENUO_M /* 721298 */:
                case FinalCanbus.CAR_RZC_17LIENUO_H /* 786834 */:
                case FinalCanbus.CAR_RZC_17KeLeiJia_H /* 917906 */:
                case FinalCanbus.CAR_RZC_18KeLeiAo_M /* 983442 */:
                case FinalCanbus.CAR_RZC_18KeLeiAo_H /* 1048978 */:
                case FinalCanbus.CAR_RZC_MEGANE_Turkey_M /* 1704338 */:
                case FinalCanbus.CAR_RZC_MEGANE_Turkey_H /* 1769874 */:
                case FinalCanbus.CAR_443_WC2_Tianlai08_12_GongJue /* 1900987 */:
                case FinalCanbus.CAR_RZC_CLIO5_Turkey /* 2032018 */:
                case FinalCanbus.CAR_RZC_CLIO5_Turkey_M /* 2097554 */:
                case FinalCanbus.CAR_RZC_CLIO5_Turkey_H /* 2163090 */:
                case FinalCanbus.CAR_RZC_MEGANE_Turkey_L_AUTO /* 2228626 */:
                case FinalCanbus.CAR_452_XP_Megane4_SP_L_HAND /* 2228676 */:
                case FinalCanbus.CAR_452_XP_Megane4_SP_L_AUTO /* 2294212 */:
                case FinalCanbus.CAR_452_XP_Megane4_SP_H_AUTO /* 2359748 */:
                case FinalCanbus.CAR_RZC_BMW_X3_11_13 /* 3670067 */:
                case FinalCanbus.CAR_RZC_BMW_X3_13_16 /* 3735603 */:
                case FinalCanbus.CAR_RZC_BMW_X3_16_17 /* 3801139 */:
                case FinalCanbus.CAR_RZC_BMW_3_13_17 /* 3866675 */:
                case FinalCanbus.CAR_RZC_Turkey_16KADJAR_M /* 3867026 */:
                case FinalCanbus.CAR_RZC_Turkey_16KADJAR_H /* 3932562 */:
                case FinalCanbus.CAR_RZC_BMW_CCC /* 4128819 */:
                case FinalCanbus.CAR_RZC_BMW_EVO /* 4390963 */:
                case FinalCanbus.CAR_439_RZC_TuDa /* 4915639 */:
                case FinalCanbus.CAR_439_XFY_SanLing_13Oulande_H /* 4981175 */:
                case FinalCanbus.CAR_439_XFY_SanLing_17Oulande_H /* 5046711 */:
                case FinalCanbus.CAR_439_XFY_SanLing_Tai_Pajieluo_H /* 5112247 */:
                case FinalCanbus.CAR_439_XFY_SanLing_13Oulande_Low /* 5177783 */:
                case FinalCanbus.CAR_439_XFY_SanLing_17Oulande_Low /* 5243319 */:
                case FinalCanbus.CAR_439_XFY_SanLing_Tai_Pajieluo_Low /* 5308855 */:
                case FinalCanbus.CAR_439_RZC_14QiJun_Auto /* 5374391 */:
                case FinalCanbus.CAR_439_RZC_14QiJun_Hand /* 5439927 */:
                case FinalCanbus.CAR_439_RZC_16Xiaoke_Auto /* 5505463 */:
                case FinalCanbus.CAR_439_RZC_16Xiaoke_Hand /* 5570999 */:
                case FinalCanbus.CAR_439_RZC_13Tianlai_Auto /* 5636535 */:
                case FinalCanbus.CAR_439_RZC_13Tianlai_Hand /* 5702071 */:
                case FinalCanbus.CAR_439_RZC_08Tianlai_Auto /* 5767607 */:
                case FinalCanbus.CAR_439_RZC_08Tianlai_Hand /* 5833143 */:
                case FinalCanbus.CAR_439_RZC_16Qida_Auto /* 5898679 */:
                case FinalCanbus.CAR_RZC_Turkey_22KADJAR_M /* 5964178 */:
                case FinalCanbus.CAR_439_RZC_16Qida_Hand /* 5964215 */:
                case FinalCanbus.CAR_439_HC_Nissan_XiaoKe /* 6685111 */:
                case FinalCanbus.CAR_452_KYC_Sanlin_outlander_13_H /* 9634244 */:
                case FinalCanbus.CAR_452_KYC_Sanlin_outlander_17_H /* 9699780 */:
                case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_16_H /* 9765316 */:
                case FinalCanbus.CAR_452_KYC_Sanlin_outlander_13_L /* 9830852 */:
                case FinalCanbus.CAR_452_KYC_Sanlin_outlander_17_L /* 9896388 */:
                case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_16_L /* 9961924 */:
                case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_V97_H /* 10027460 */:
                case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_V97_L /* 10092996 */:
                case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_20_H /* 10158532 */:
                case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_20_L /* 10224068 */:
                case FinalCanbus.CAR_452_KYC_Zhonghua_All /* 10617284 */:
                case FinalCanbus.CAR_452_KYC_Zhonghua_All_H /* 10682820 */:
                case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7 /* 10748356 */:
                case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7_H /* 10813892 */:
                case FinalCanbus.CAR_439_RZC_TuDa_Hand /* 11207095 */:
                    int temp4 = temp * 5;
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp4 / 10) + "." + (temp4 % 10));
                    mUpdateTempUNITLeft();
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
                case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
                case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
                case FinalCanbus.CAR_RZC_13Reiz_TOP /* 5702029 */:
                case FinalCanbus.CAR_RZC_12Reiz /* 5767565 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
                case FinalCanbus.CAR_LUZ_Toyato_All /* 7274935 */:
                case FinalCanbus.CAR_LUZ_Toyato_All_H /* 7340471 */:
                case FinalCanbus.CAR_LUZ_Toyato_20All /* 8126903 */:
                case FinalCanbus.CAR_453_LZ_Toyota_Tacoma_11 /* 8126917 */:
                case FinalCanbus.CAR_LUZ_Toyato_30All /* 8192439 */:
                case FinalCanbus.CAR_453_LZ_Toyota_Tacoma_05 /* 8192453 */:
                    int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
                    if (TempUnit == 1) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(((temp * 9) / 50) + 32).toString());
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp / 10) + "." + (temp % 10));
                    }
                    mUpdateTempUNITLeft();
                    break;
                case 423:
                case 427:
                case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6 /* 131379 */:
                case FinalCanbus.CAR_BNR_17LIENUO_L /* 262546 */:
                case FinalCanbus.CAR_BNR_17KeLeiJia_L /* 459154 */:
                case FinalCanbus.CAR_RZC_17LIENUO_L /* 655762 */:
                case FinalCanbus.CAR_RZC_17KeLeiJia_L /* 852370 */:
                case FinalCanbus.CAR_RZC_18KeLeiAo_L /* 1114514 */:
                case FinalCanbus.CAR_RZC_MEGANE_Turkey_L /* 1638802 */:
                case FinalCanbus.CAR_RZC_Turkey_16KADJAR_L /* 3801490 */:
                    int temp5 = temp * 5;
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp5 / 10) + "." + (temp5 % 10));
                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp5 / 10) + "." + (temp5 % 10));
                    mUpdateTempUNITLeft();
                    mUpdateTempUNITRight();
                    break;
                case FinalCanbus.CAR_CYT_ShuPing_QiYaK3_H /* 65959 */:
                case FinalCanbus.CAR_XFY_SHUPING_K3_M /* 65963 */:
                case FinalCanbus.CAR_XFY_SHUPING_K3_H /* 131499 */:
                case FinalCanbus.CAR_WC_16_QiYaKX5_WITH_CYT_SHUPING_K3AIR /* 262538 */:
                    if (temp <= 16) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("LO");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                        break;
                    } else if (temp >= 80) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("HI");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(((temp * 5) / 10) + "." + ((temp * 5) % 10));
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
                        break;
                    }
                case FinalCanbus.CAR_WC2_DaZhong_TuRui /* 131342 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_12Crown_ShuPing /* 262573 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_12Crown_H_ShuPing /* 328109 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_06Prado_ShuPing /* 393645 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_14Prodo_H_ShuPing /* 459181 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_14Prodo_ShuPing /* 524717 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown /* 590253 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown /* 655789 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown_L /* 721325 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown_L /* 786861 */:
                case FinalCanbus.CAR_DJ_XC_Nissan_Tianlai_03_07 /* 852397 */:
                case FinalCanbus.CAR_452_XFY_PSA_3008_L /* 1114564 */:
                case FinalCanbus.CAR_452_XFY_PSA_3008_H /* 1180100 */:
                case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD /* 4719035 */:
                case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD_HW /* 4915643 */:
                case FinalCanbus.CAR_452_CYT_Hyundai_VERACRUZ /* 5767620 */:
                case FinalCanbus.CAR_452_XBS_Nissan_Cedric /* 7143876 */:
                case FinalCanbus.CAR_452_LZ_Audi_A3_SP /* 9306564 */:
                case FinalCanbus.CAR_452_LZ_Audi_A4_SP /* 9372100 */:
                case FinalCanbus.CAR_452_LZ_Audi_TT_SP /* 9437636 */:
                case FinalCanbus.CAR_452_LZ_Audi_A3_SP_H /* 11076036 */:
                case FinalCanbus.CAR_452_LZ_Audi_A4_SP_H /* 11141572 */:
                case FinalCanbus.CAR_452_LZ_Audi_TT_SP_H /* 11207108 */:
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText(((temp * 5) / 10) + "." + ((temp * 5) % 10));
                    ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
                    break;
                case FinalCanbus.CAR_RZC_DaZhong_SUP /* 196659 */:
                case FinalCanbus.CAR_RZC_DaZhong_SUP_H /* 262195 */:
                case FinalCanbus.CAR_RZC_HavalLow_H2_HongBiao /* 327924 */:
                case FinalCanbus.CAR_RZC_DaZhong_SUP_M /* 458803 */:
                case FinalCanbus.CAR_RZC_DaZhong_MQB_SUP /* 458912 */:
                case FinalCanbus.CAR_RZC_XP1_HavalH6 /* 458996 */:
                case FinalCanbus.CAR_RZC_DaZhong_MQB_SUP_H /* 524448 */:
                case FinalCanbus.CAR_RZC_BenTeng_OLDB50 /* 786845 */:
                case FinalCanbus.CAR_RZC_XP1_M6_17 /* 917748 */:
                case FinalCanbus.CAR_RZC_HavalLow_Changchengpao_19 /* 1114356 */:
                case FinalCanbus.CAR_RZC_HavalLow_Changchengpao_19_L /* 2294004 */:
                    if (temp <= 16 && temp >= 1) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("LO");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                        break;
                    } else if (temp <= 63 && temp >= 49) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("HI");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                        break;
                    } else {
                        int temp_p = ((temp - 16) * 5) + 160;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp_p / 10) + "." + (temp_p % 10));
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
                        break;
                    }
                case FinalCanbus.CAR_DJ_ShuPing_BYD_G6 /* 196759 */:
                case FinalCanbus.CAR_DJ_ShuPing_BYD_G6_H /* 262295 */:
                    int temp6 = (temp * 10) + 160;
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp6 / 10) + "." + (temp6 % 10));
                    ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
                    break;
                case FinalCanbus.CAR_BoGoo_XP1_ShuPing_GrdCherokee_CYT_AIRPANEL /* 262515 */:
                    if (temp <= 63 && temp >= 35) {
                        int temp_p2 = temp * 5;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp_p2 / 10) + "." + (temp_p2 % 10));
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("--");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                        break;
                    }
                case FinalCanbus.CAR_RZC_17ZhiNanZhe /* 262517 */:
                case FinalCanbus.CAR_RZC_17ZhiNanZhe_H /* 328053 */:
                case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19 /* 852341 */:
                case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19_H /* 917877 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        int temp7 = (temp * 5) + 155;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp7 / 10) + "." + (temp7 % 10));
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(temp + 59).toString());
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℉");
                        break;
                    }
                case FinalCanbus.CAR_BNR_ShuPing_Sonata8 /* 393571 */:
                case FinalCanbus.CAR_BNR_ShuPing_Sonata8_AMP /* 459107 */:
                    if (temp <= 29 && temp >= 1) {
                        int temp_p3 = (temp * 5) + 170;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp_p3 / 10) + "." + (temp_p3 % 10));
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("--");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                        break;
                    }
                case FinalCanbus.CAR_BNR_XP1_New_KLZ /* 524667 */:
                case FinalCanbus.CAR_BNR_XP1_Mairuibao_L /* 590203 */:
                case FinalCanbus.CAR_BNR_XP1_Mairuibao_H /* 655739 */:
                case FinalCanbus.CAR_BNR_XP1_JunWei_L /* 721275 */:
                case FinalCanbus.CAR_RZC_ALL_GM_SP_13 /* 852029 */:
                case FinalCanbus.CAR_RZC_ALL_GM_SP_14 /* 917565 */:
                case FinalCanbus.CAR_BNR_XP1_New_YingLang_L /* 983419 */:
                case FinalCanbus.CAR_BNR_XP1_New_YingLang_H /* 1048955 */:
                case FinalCanbus.CAR_RZC_ALL_GM_SP_17 /* 1114173 */:
                case FinalCanbus.CAR_RZC_ALL_GM_SP_19 /* 1245245 */:
                case FinalCanbus.CAR_BNR_XP1_WeiLang_L /* 1245563 */:
                case FinalCanbus.CAR_BNR_XP1_YingLang_L /* 1376635 */:
                case FinalCanbus.CAR_RZC_ALL_GM_SP_23 /* 1507389 */:
                case FinalCanbus.CAR_BNR_XP1_MairuibaoXL_L /* 1638779 */:
                case FinalCanbus.CAR_BNR_XP1_New_Klz_Top /* 1966459 */:
                case FinalCanbus.CAR_RZC_ALL_GM_SP_32 /* 2097213 */:
                case FinalCanbus.CAR_RZC_ALL_GM_SP_33 /* 2162749 */:
                case FinalCanbus.CAR_RZC_ALL_GM_SP_34 /* 2228285 */:
                case FinalCanbus.CAR_RZC_ALL_GM_SP_35 /* 2293821 */:
                case FinalCanbus.CAR_BNR_RZC_Mairuibao_L /* 2359675 */:
                case FinalCanbus.CAR_BNR_RZC_Mairuibao_H /* 2425211 */:
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp / 10) + "." + (temp % 10));
                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp / 10) + "." + (temp % 10));
                    mUpdateTempUNITLeft();
                    mUpdateTempUNITRight();
                    break;
                case FinalCanbus.CAR_RZC_Nissan_Qijun_HW /* 590014 */:
                    int temp8 = (temp * 5) + 80;
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp8 / 10) + "." + (temp8 % 10));
                    ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
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
                case FinalCanbus.CAR_452_TangDu_Nissan_Tuda_Hand /* 7668164 */:
                case FinalCanbus.CAR_452_TangDu_Nissan_Tuda_Auto /* 7733700 */:
                    if (temp <= 64 && temp >= 31) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp / 5) + "." + (temp % 5));
                        mUpdateTempUNITLeft();
                        break;
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("--");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                        break;
                    }
                case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx /* 917956 */:
                case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx_H /* 983492 */:
                case FinalCanbus.CAR_439_LUZ_LEXUS_IS /* 3080631 */:
                case FinalCanbus.CAR_439_LUZ_LEXUS_IS_H /* 3146167 */:
                case FinalCanbus.CAR_439_LUZ_LEXUS_ES /* 3211703 */:
                case FinalCanbus.CAR_439_LUZ_LEXUS_ES_H /* 3277239 */:
                case FinalCanbus.CAR_BNR_02_09Toyato_Prado /* 7668151 */:
                case FinalCanbus.CAR_BNR_02_09Toyato_Prado_H /* 7733687 */:
                    int TempUnit2 = SystemProperties.getInt("persist.fyt.temperature", 0);
                    if (TempUnit2 == 1) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder(String.valueOf(((temp * 9) + 635) / 10)).toString());
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℉");
                        break;
                    } else {
                        int temp9 = (temp * 5) + 175;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp9 / 10) + "." + (temp9 % 10));
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
                        break;
                    }
                case FinalCanbus.CAR_RZC_DongFeng_Fengxing_M7 /* 1114339 */:
                    int TempUnit3 = SystemProperties.getInt("persist.fyt.temperature", 0);
                    if (TempUnit3 == 1) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(((temp * 9) / 5) + 32).toString());
                    } else {
                        int temp10 = temp * 10;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp10 / 10) + "." + (temp10 % 10));
                    }
                    mUpdateTempUNITLeft();
                    break;
                case FinalCanbus.CAR_RZC_HavalH4_20 /* 1245428 */:
                    if (temp <= 144 && temp >= 112) {
                        int temp11 = ((temp - 112) * 5) + 160;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp11 / 10) + "." + (temp11 % 10));
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("--");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                        break;
                    }
                case FinalCanbus.CAR_439_DJ_TOYOTA_08Prado_ShuPing_H /* 1442231 */:
                case FinalCanbus.CAR_439_BNR_LEXUS_ES /* 1835447 */:
                case FinalCanbus.CAR_439_BNR_LEXUS_ES_H /* 1900983 */:
                case FinalCanbus.CAR_439_XBS_09Tianlai /* 4063671 */:
                    int temp12 = (temp * 5) + 175;
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp12 / 10) + "." + (temp12 % 10));
                    ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
                    break;
                case FinalCanbus.CAR_443_WC2_YingFeiNiDi_GX50 /* 1507771 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_ESQ /* 1573316 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_06FX /* 1638852 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_08FX /* 1704388 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_G /* 1769924 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_14QX50 /* 1835460 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_14QX70 /* 1966532 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_13Q70L /* 2032068 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_12FX /* 3998148 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_15Q50L /* 4063684 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_12JX35 /* 4129220 */:
                case FinalCanbus.CAR_443_WC2_YingFeiNiDi_10G37 /* 4587963 */:
                case FinalCanbus.CAR_443_WC2_YingFeiNiDi_16Q50l_SP /* 5308859 */:
                case FinalCanbus.CAR_443_WC2_YingFeiNiDi_11FX35 /* 6095291 */:
                case FinalCanbus.CAR_443_WC2_YingFeiNiDi_14Q50_L /* 8651195 */:
                    int TempUnit4 = SystemProperties.getInt("persist.fyt.temperature", 0);
                    if (TempUnit4 == 1) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder(String.valueOf(((temp * 9) + 320) / 10)).toString());
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℉");
                        break;
                    } else {
                        int temp13 = temp * 5;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp13 / 10) + "." + (temp13 % 10));
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
                        break;
                    }
                case FinalCanbus.CAR_RZC_Dodge_RAM_HY /* 1900917 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_HY_M /* 1966453 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_HY_H /* 2031989 */:
                    int temp14 = (temp * 5) + 155;
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp14 / 10) + "." + (temp14 % 10));
                    mUpdateTempUNITLeft();
                    break;
                case FinalCanbus.CAR_439_RZC_ChangAn_CX70 /* 4391351 */:
                case FinalCanbus.CAR_439_RZC_ChangAn_OUSAN_KESAI /* 7471543 */:
                case FinalCanbus.CAR_452_RZC_ChangAn_KESAI_Pro_21 /* 11010500 */:
                    int temp15 = (temp * 5) + 175;
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp15 / 10) + "." + (temp15 % 10));
                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp15 / 10) + "." + (temp15 % 10));
                    ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
                    break;
                case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9 /* 5702084 */:
                    if (temp < 16 && temp > 0) {
                        int temp16 = temp + 15;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(temp16).toString());
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(temp16).toString());
                        mUpdateTempUNITLeft();
                        mUpdateTempUNITRight();
                        break;
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("--");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText("--");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                        break;
                    }
                case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_Auto /* 5833156 */:
                case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_EV /* 10355140 */:
                    if (temp < 30 && temp > 0) {
                        int temp17 = (temp * 5) + 175;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp17 / 10) + "." + (temp17 % 10));
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp17 / 10) + "." + (temp17 % 10));
                        mUpdateTempUNITLeft();
                        mUpdateTempUNITRight();
                        break;
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("--");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText("--");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                        break;
                    }
                case FinalCanbus.CAR_452_OD_LandRover_Freelander /* 7799236 */:
                case FinalCanbus.CAR_452_OD_Lamborghini /* 7930308 */:
                    if (temp == 16) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("LO");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                        break;
                    } else if (temp == 80) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("HI");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                        break;
                    } else {
                        int TempUnit5 = SystemProperties.getInt("persist.fyt.temperature", 0);
                        if (TempUnit5 == 1) {
                            ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder(String.valueOf(((temp * 9) + 320) / 10.0f)).toString());
                            ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℉");
                            break;
                        } else {
                            int temp18 = temp * 5;
                            ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp18 / 10) + "." + (temp18 % 10));
                            ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
                            break;
                        }
                    }
                case FinalCanbus.CAR_452_LZ_Volvo /* 7995844 */:
                case FinalCanbus.CAR_452_LZ_Volvo_10 /* 13631940 */:
                case FinalCanbus.CAR_452_LZ_Volvo_15 /* 16515524 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(((temp * 5) / 10) + "." + ((temp * 5) % 10));
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(((temp * 9) + 320) / 10).toString());
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℉");
                        break;
                    }
                case FinalCanbus.CAR_452_OD_HuaChen_SWM_X7 /* 8323524 */:
                case FinalCanbus.CAR_452_OD_HuaChen_SWM_X7_H /* 8389060 */:
                case FinalCanbus.CAR_452_OD_HuaChen_SWM_G05 /* 15335876 */:
                case FinalCanbus.CAR_452_OD_HuaChen_SWM_G05_H /* 15401412 */:
                    if (temp <= 32 && temp >= 1) {
                        int temp_p4 = (temp * 5) + 160;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp_p4 / 10) + "." + (temp_p4 % 10));
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("--");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                        break;
                    }
                case FinalCanbus.CAR_439_LZ_INFINIT_FX35 /* 12714423 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((((temp * 5) + 175) / 10) + "." + (((temp * 5) + 175) % 10));
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(temp + 59).toString());
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℉");
                        break;
                    }
                case FinalCanbus.CAR_439_DJ_Siyu /* 14549431 */:
                    int temp19 = (temp * 10) + 160;
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp19 / 10) + "." + (temp19 % 10));
                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp19 / 10) + "." + (temp19 % 10));
                    mUpdateTempUNITLeft();
                    mUpdateTempUNITRight();
                    break;
                default:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp / 10) + "." + (temp % 10));
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(temp).toString());
                    }
                    mUpdateTempUNITLeft();
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTempRight() {
        switch (DataCanbus.DATA[1000]) {
            case 423:
            case 427:
            case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6 /* 131379 */:
            case FinalCanbus.CAR_BNR_17LIENUO_L /* 262546 */:
            case FinalCanbus.CAR_BNR_17KeLeiJia_L /* 459154 */:
            case FinalCanbus.CAR_BNR_XP1_New_KLZ /* 524667 */:
            case FinalCanbus.CAR_BNR_XP1_Mairuibao_L /* 590203 */:
            case FinalCanbus.CAR_BNR_XP1_Mairuibao_H /* 655739 */:
            case FinalCanbus.CAR_RZC_17LIENUO_L /* 655762 */:
            case FinalCanbus.CAR_BNR_XP1_JunWei_L /* 721275 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_13 /* 852029 */:
            case FinalCanbus.CAR_RZC_17KeLeiJia_L /* 852370 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_14 /* 917565 */:
            case FinalCanbus.CAR_BNR_XP1_New_YingLang_L /* 983419 */:
            case FinalCanbus.CAR_BNR_XP1_New_YingLang_H /* 1048955 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_17 /* 1114173 */:
            case FinalCanbus.CAR_RZC_18KeLeiAo_L /* 1114514 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_19 /* 1245245 */:
            case FinalCanbus.CAR_BNR_XP1_WeiLang_L /* 1245563 */:
            case FinalCanbus.CAR_BNR_XP1_YingLang_L /* 1376635 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_23 /* 1507389 */:
            case FinalCanbus.CAR_BNR_XP1_MairuibaoXL_L /* 1638779 */:
            case FinalCanbus.CAR_RZC_MEGANE_Turkey_L /* 1638802 */:
            case FinalCanbus.CAR_BNR_XP1_New_Klz_Top /* 1966459 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_32 /* 2097213 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_33 /* 2162749 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_34 /* 2228285 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_35 /* 2293821 */:
            case FinalCanbus.CAR_BNR_RZC_Mairuibao_L /* 2359675 */:
            case FinalCanbus.CAR_BNR_RZC_Mairuibao_H /* 2425211 */:
            case FinalCanbus.CAR_RZC_Turkey_16KADJAR_L /* 3801490 */:
            case FinalCanbus.CAR_439_RZC_ChangAn_CX70 /* 4391351 */:
            case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9 /* 5702084 */:
            case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_Auto /* 5833156 */:
            case FinalCanbus.CAR_439_RZC_ChangAn_OUSAN_KESAI /* 7471543 */:
            case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_EV /* 10355140 */:
            case FinalCanbus.CAR_452_RZC_ChangAn_KESAI_Pro_21 /* 11010500 */:
            case FinalCanbus.CAR_439_DJ_Siyu /* 14549431 */:
                break;
            default:
                int temp = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_RIGHT];
                if (((TextView) findViewById(R.id.air_sp_temp_right)) != null) {
                    if (temp == ConstAllAirDara.TEMPERATURE_LOW) {
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText("LO");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                        break;
                    } else if (temp == ConstAllAirDara.TEMPERATURE_HIGHT) {
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText("HI");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                        break;
                    } else if (temp == ConstAllAirDara.TEMPERATURE_NONE) {
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText("--");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                        break;
                    } else {
                        switch (DataCanbus.DATA[1000]) {
                            case 21:
                            case 425:
                            case FinalCanbus.CAR_WC2_MengDiOuZS2013_M /* 65557 */:
                            case FinalCanbus.CAR_XFY_ShuPing_Honda_GuanDao_H /* 65961 */:
                            case FinalCanbus.CAR_WC2_MengDiOuZS2013_H /* 131093 */:
                            case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL /* 196629 */:
                            case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL_M /* 262165 */:
                            case FinalCanbus.CAR_XFY_ShuPing_Honda_06CRV /* 262569 */:
                            case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL_H /* 327701 */:
                            case FinalCanbus.CAR_BNR_HONDA_16Civic_Vsceen_L /* 393514 */:
                            case FinalCanbus.CAR_BNR_HONDA_16Civic_Vsceen_H /* 459050 */:
                            case FinalCanbus.CAR_BNR_HONDA_Avancier_Vsceen_NoAmp /* 655658 */:
                            case FinalCanbus.CAR_BNR_HONDA_Avancier_Vsceen_Amp_View /* 721194 */:
                            case FinalCanbus.CAR_BNR_17CRV /* 983338 */:
                            case FinalCanbus.CAR_RZC_HONDA_16Civic_Vsceen_L /* 1048874 */:
                            case FinalCanbus.CAR_RZC_HONDA_16Civic_Vsceen_H /* 1114410 */:
                                if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(((temp * 5) / 10) + "." + ((temp * 5) % 10));
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
                                    break;
                                } else {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(temp).toString());
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℉");
                                    break;
                                }
                            case 276:
                                int temp2 = (temp * 10) + 170;
                                ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp2 / 10) + "." + (temp2 % 10));
                                ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
                                break;
                            case 334:
                            case FinalCanbus.CAR_RZC_ZhiSheng_Old /* 262478 */:
                            case FinalCanbus.CAR_RZC_Ford_Lincoln_navigator /* 1900878 */:
                            case FinalCanbus.CAR_RZC_Ford_F150_12 /* 2294094 */:
                            case FinalCanbus.CAR_RZC_Mustang_NO_CD /* 2359630 */:
                            case FinalCanbus.CAR_RZC_LHT_Ford_F150_Auto /* 2425166 */:
                            case FinalCanbus.CAR_RZC_Mustang_15_NO_CD /* 2621774 */:
                            case FinalCanbus.CAR_RZC_Mustang_HY_LEFT /* 2687310 */:
                            case FinalCanbus.CAR_RZC_Mustang_HY_RIGHT /* 2752846 */:
                            case FinalCanbus.CAR_RZC_Mustang_HY_LOW /* 2818382 */:
                            case FinalCanbus.CAR_RZC_Mustang_HY_H /* 2883918 */:
                            case FinalCanbus.CAR_RZC_Ford_F150 /* 3080526 */:
                                if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp / 10) + "." + (temp % 10));
                                } else {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(temp / 10).toString());
                                }
                                mUpdateTempUNITRight();
                                break;
                            case 373:
                            case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_H /* 65909 */:
                            case FinalCanbus.CAR_RZC_XP1_GrdCherokee /* 196981 */:
                            case FinalCanbus.CAR_RZC_XP1_GrdCherokee_H /* 459125 */:
                            case FinalCanbus.CAR_RZC_Dodge_RAM /* 1311093 */:
                            case FinalCanbus.CAR_RZC_Dodge_RAM_H /* 1376629 */:
                            case FinalCanbus.CAR_RZC_Dodge_RAM_M /* 1835381 */:
                                int temp3 = temp * 10;
                                ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp3 / 10) + "." + (temp3 % 10));
                                mUpdateTempUNITRight();
                                break;
                            case 374:
                            case FinalCanbus.CAR_XP1_ZiYouGuang_H /* 65910 */:
                            case FinalCanbus.CAR_CYT_YaGe7_Portrait /* 65953 */:
                            case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6_H /* 196915 */:
                            case FinalCanbus.CAR_CYT_YaGe8 /* 197025 */:
                            case FinalCanbus.CAR_BNR_17LIENUO_M /* 328082 */:
                            case FinalCanbus.CAR_RCW_BYD_10_11F6 /* 328097 */:
                            case FinalCanbus.CAR_BNR_17LIENUO_H /* 393618 */:
                            case FinalCanbus.CAR_RCW_BYD_10_13G6 /* 393633 */:
                            case FinalCanbus.CAR_BNR_17KeLeiJia_H /* 524690 */:
                            case FinalCanbus.CAR_RZC4_PSA_19_408 /* 590163 */:
                            case FinalCanbus.CAR_BNR_18KeLeiAo_M /* 590226 */:
                            case FinalCanbus.CAR_RZC4_PSA_19_408_H /* 655699 */:
                            case FinalCanbus.CAR_RZC_17LIENUO_M /* 721298 */:
                            case FinalCanbus.CAR_RZC_17LIENUO_H /* 786834 */:
                            case FinalCanbus.CAR_RZC_17KeLeiJia_H /* 917906 */:
                            case FinalCanbus.CAR_RZC_18KeLeiAo_M /* 983442 */:
                            case FinalCanbus.CAR_RZC_18KeLeiAo_H /* 1048978 */:
                            case FinalCanbus.CAR_RZC_MEGANE_Turkey_M /* 1704338 */:
                            case FinalCanbus.CAR_RZC_MEGANE_Turkey_H /* 1769874 */:
                            case FinalCanbus.CAR_443_WC2_Tianlai08_12_GongJue /* 1900987 */:
                            case FinalCanbus.CAR_RZC_CLIO5_Turkey /* 2032018 */:
                            case FinalCanbus.CAR_RZC_CLIO5_Turkey_M /* 2097554 */:
                            case FinalCanbus.CAR_RZC_CLIO5_Turkey_H /* 2163090 */:
                            case FinalCanbus.CAR_RZC_MEGANE_Turkey_L_AUTO /* 2228626 */:
                            case FinalCanbus.CAR_452_XP_Megane4_SP_L_HAND /* 2228676 */:
                            case FinalCanbus.CAR_452_XP_Megane4_SP_L_AUTO /* 2294212 */:
                            case FinalCanbus.CAR_452_XP_Megane4_SP_H_AUTO /* 2359748 */:
                            case FinalCanbus.CAR_RZC_BMW_X3_11_13 /* 3670067 */:
                            case FinalCanbus.CAR_RZC_BMW_X3_13_16 /* 3735603 */:
                            case FinalCanbus.CAR_RZC_BMW_X3_16_17 /* 3801139 */:
                            case FinalCanbus.CAR_RZC_BMW_3_13_17 /* 3866675 */:
                            case FinalCanbus.CAR_RZC_Turkey_16KADJAR_M /* 3867026 */:
                            case FinalCanbus.CAR_RZC_Turkey_16KADJAR_H /* 3932562 */:
                            case FinalCanbus.CAR_RZC_BMW_CCC /* 4128819 */:
                            case FinalCanbus.CAR_RZC_BMW_EVO /* 4390963 */:
                            case FinalCanbus.CAR_439_RZC_TuDa /* 4915639 */:
                            case FinalCanbus.CAR_439_XFY_SanLing_13Oulande_H /* 4981175 */:
                            case FinalCanbus.CAR_439_XFY_SanLing_17Oulande_H /* 5046711 */:
                            case FinalCanbus.CAR_439_XFY_SanLing_Tai_Pajieluo_H /* 5112247 */:
                            case FinalCanbus.CAR_439_XFY_SanLing_13Oulande_Low /* 5177783 */:
                            case FinalCanbus.CAR_439_XFY_SanLing_17Oulande_Low /* 5243319 */:
                            case FinalCanbus.CAR_439_XFY_SanLing_Tai_Pajieluo_Low /* 5308855 */:
                            case FinalCanbus.CAR_439_RZC_14QiJun_Auto /* 5374391 */:
                            case FinalCanbus.CAR_439_RZC_14QiJun_Hand /* 5439927 */:
                            case FinalCanbus.CAR_439_RZC_16Xiaoke_Auto /* 5505463 */:
                            case FinalCanbus.CAR_439_RZC_16Xiaoke_Hand /* 5570999 */:
                            case FinalCanbus.CAR_439_RZC_13Tianlai_Auto /* 5636535 */:
                            case FinalCanbus.CAR_439_RZC_13Tianlai_Hand /* 5702071 */:
                            case FinalCanbus.CAR_439_RZC_08Tianlai_Auto /* 5767607 */:
                            case FinalCanbus.CAR_439_RZC_08Tianlai_Hand /* 5833143 */:
                            case FinalCanbus.CAR_439_RZC_16Qida_Auto /* 5898679 */:
                            case FinalCanbus.CAR_RZC_Turkey_22KADJAR_M /* 5964178 */:
                            case FinalCanbus.CAR_439_RZC_16Qida_Hand /* 5964215 */:
                            case FinalCanbus.CAR_439_HC_Nissan_XiaoKe /* 6685111 */:
                            case FinalCanbus.CAR_452_KYC_Sanlin_outlander_13_H /* 9634244 */:
                            case FinalCanbus.CAR_452_KYC_Sanlin_outlander_17_H /* 9699780 */:
                            case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_16_H /* 9765316 */:
                            case FinalCanbus.CAR_452_KYC_Sanlin_outlander_13_L /* 9830852 */:
                            case FinalCanbus.CAR_452_KYC_Sanlin_outlander_17_L /* 9896388 */:
                            case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_16_L /* 9961924 */:
                            case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_V97_H /* 10027460 */:
                            case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_V97_L /* 10092996 */:
                            case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_20_H /* 10158532 */:
                            case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_20_L /* 10224068 */:
                            case FinalCanbus.CAR_452_KYC_Zhonghua_All /* 10617284 */:
                            case FinalCanbus.CAR_452_KYC_Zhonghua_All_H /* 10682820 */:
                            case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7 /* 10748356 */:
                            case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7_H /* 10813892 */:
                            case FinalCanbus.CAR_439_RZC_TuDa_Hand /* 11207095 */:
                                int temp4 = temp * 5;
                                ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp4 / 10) + "." + (temp4 % 10));
                                mUpdateTempUNITRight();
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
                            case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
                            case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
                            case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
                            case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
                            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
                            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
                            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
                            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
                            case FinalCanbus.CAR_RZC_13Reiz_TOP /* 5702029 */:
                            case FinalCanbus.CAR_RZC_12Reiz /* 5767565 */:
                            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
                            case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
                            case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
                            case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
                            case FinalCanbus.CAR_LUZ_Toyato_All /* 7274935 */:
                            case FinalCanbus.CAR_LUZ_Toyato_All_H /* 7340471 */:
                            case FinalCanbus.CAR_LUZ_Toyato_20All /* 8126903 */:
                            case FinalCanbus.CAR_453_LZ_Toyota_Tacoma_11 /* 8126917 */:
                            case FinalCanbus.CAR_LUZ_Toyato_30All /* 8192439 */:
                            case FinalCanbus.CAR_453_LZ_Toyota_Tacoma_05 /* 8192453 */:
                                int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
                                if (TempUnit == 1) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(((temp * 9) / 50) + 32).toString());
                                } else {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp / 10) + "." + (temp % 10));
                                }
                                mUpdateTempUNITRight();
                                break;
                            case FinalCanbus.CAR_CYT_ShuPing_QiYaK3_H /* 65959 */:
                            case FinalCanbus.CAR_XFY_SHUPING_K3_M /* 65963 */:
                            case FinalCanbus.CAR_XFY_SHUPING_K3_H /* 131499 */:
                            case FinalCanbus.CAR_WC_16_QiYaKX5_WITH_CYT_SHUPING_K3AIR /* 262538 */:
                                if (temp <= 16) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText("LO");
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                                    break;
                                } else if (temp >= 80) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText("HI");
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                                    break;
                                } else {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(((temp * 5) / 10) + "." + ((temp * 5) % 10));
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
                                    break;
                                }
                            case FinalCanbus.CAR_WC2_DaZhong_TuRui /* 131342 */:
                            case FinalCanbus.CAR_DJ_XP1_TOYOTA_12Crown_ShuPing /* 262573 */:
                            case FinalCanbus.CAR_DJ_XP1_TOYOTA_12Crown_H_ShuPing /* 328109 */:
                            case FinalCanbus.CAR_DJ_XP1_TOYOTA_06Prado_ShuPing /* 393645 */:
                            case FinalCanbus.CAR_DJ_XP1_TOYOTA_14Prodo_H_ShuPing /* 459181 */:
                            case FinalCanbus.CAR_DJ_XP1_TOYOTA_14Prodo_ShuPing /* 524717 */:
                            case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown /* 590253 */:
                            case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown /* 655789 */:
                            case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown_L /* 721325 */:
                            case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown_L /* 786861 */:
                            case FinalCanbus.CAR_DJ_XC_Nissan_Tianlai_03_07 /* 852397 */:
                            case FinalCanbus.CAR_452_XFY_PSA_3008_L /* 1114564 */:
                            case FinalCanbus.CAR_452_XFY_PSA_3008_H /* 1180100 */:
                            case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD /* 4719035 */:
                            case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD_HW /* 4915643 */:
                            case FinalCanbus.CAR_452_CYT_Hyundai_VERACRUZ /* 5767620 */:
                            case FinalCanbus.CAR_452_XBS_Nissan_Cedric /* 7143876 */:
                            case FinalCanbus.CAR_452_LZ_Audi_A3_SP /* 9306564 */:
                            case FinalCanbus.CAR_452_LZ_Audi_A4_SP /* 9372100 */:
                            case FinalCanbus.CAR_452_LZ_Audi_TT_SP /* 9437636 */:
                            case FinalCanbus.CAR_452_LZ_Audi_A3_SP_H /* 11076036 */:
                            case FinalCanbus.CAR_452_LZ_Audi_A4_SP_H /* 11141572 */:
                            case FinalCanbus.CAR_452_LZ_Audi_TT_SP_H /* 11207108 */:
                                ((TextView) findViewById(R.id.air_sp_temp_right)).setText(((temp * 5) / 10) + "." + ((temp * 5) % 10));
                                ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
                                break;
                            case FinalCanbus.CAR_RZC_DaZhong_SUP /* 196659 */:
                            case FinalCanbus.CAR_RZC_DaZhong_SUP_H /* 262195 */:
                            case FinalCanbus.CAR_RZC_HavalLow_H2_HongBiao /* 327924 */:
                            case FinalCanbus.CAR_RZC_DaZhong_SUP_M /* 458803 */:
                            case FinalCanbus.CAR_RZC_DaZhong_MQB_SUP /* 458912 */:
                            case FinalCanbus.CAR_RZC_XP1_HavalH6 /* 458996 */:
                            case FinalCanbus.CAR_RZC_DaZhong_MQB_SUP_H /* 524448 */:
                            case FinalCanbus.CAR_RZC_BenTeng_OLDB50 /* 786845 */:
                            case FinalCanbus.CAR_RZC_XP1_M6_17 /* 917748 */:
                            case FinalCanbus.CAR_RZC_HavalLow_Changchengpao_19 /* 1114356 */:
                            case FinalCanbus.CAR_RZC_HavalLow_Changchengpao_19_L /* 2294004 */:
                                if (temp <= 16 && temp >= 1) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText("LO");
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                                    break;
                                } else if (temp <= 63 && temp >= 49) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText("HI");
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                                    break;
                                } else {
                                    int temp_p = ((temp - 16) * 5) + 160;
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp_p / 10) + "." + (temp_p % 10));
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
                                    break;
                                }
                            case FinalCanbus.CAR_DJ_ShuPing_BYD_G6 /* 196759 */:
                            case FinalCanbus.CAR_DJ_ShuPing_BYD_G6_H /* 262295 */:
                                int temp5 = (temp * 10) + 160;
                                ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp5 / 10) + "." + (temp5 % 10));
                                ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
                                break;
                            case FinalCanbus.CAR_BoGoo_XP1_ShuPing_GrdCherokee_CYT_AIRPANEL /* 262515 */:
                                if (temp <= 63 && temp >= 35) {
                                    int temp_p2 = temp * 5;
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp_p2 / 10) + "." + (temp_p2 % 10));
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
                                    break;
                                } else {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText("--");
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                                    break;
                                }
                            case FinalCanbus.CAR_RZC_17ZhiNanZhe /* 262517 */:
                            case FinalCanbus.CAR_RZC_17ZhiNanZhe_H /* 328053 */:
                            case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19 /* 852341 */:
                            case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19_H /* 917877 */:
                                if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                                    int temp6 = (temp * 5) + 155;
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp6 / 10) + "." + (temp6 % 10));
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
                                    break;
                                } else {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(temp + 59).toString());
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℉");
                                    break;
                                }
                            case FinalCanbus.CAR_BNR_ShuPing_Sonata8 /* 393571 */:
                            case FinalCanbus.CAR_BNR_ShuPing_Sonata8_AMP /* 459107 */:
                                if (temp <= 29 && temp >= 1) {
                                    int temp_p3 = (temp * 5) + 170;
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp_p3 / 10) + "." + (temp_p3 % 10));
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
                                    break;
                                } else {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText("--");
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                                    break;
                                }
                            case FinalCanbus.CAR_RZC_Nissan_Qijun_HW /* 590014 */:
                                int temp7 = (temp * 5) + 80;
                                ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp7 / 10) + "." + (temp7 % 10));
                                ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
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
                            case FinalCanbus.CAR_452_TangDu_Nissan_Tuda_Hand /* 7668164 */:
                            case FinalCanbus.CAR_452_TangDu_Nissan_Tuda_Auto /* 7733700 */:
                                if (temp <= 64 && temp >= 31) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp / 5) + "." + (temp % 5));
                                    mUpdateTempUNITRight();
                                    break;
                                } else {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText("--");
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                                    break;
                                }
                            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx /* 917956 */:
                            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx_H /* 983492 */:
                            case FinalCanbus.CAR_439_LUZ_LEXUS_IS /* 3080631 */:
                            case FinalCanbus.CAR_439_LUZ_LEXUS_IS_H /* 3146167 */:
                            case FinalCanbus.CAR_439_LUZ_LEXUS_ES /* 3211703 */:
                            case FinalCanbus.CAR_439_LUZ_LEXUS_ES_H /* 3277239 */:
                            case FinalCanbus.CAR_BNR_02_09Toyato_Prado /* 7668151 */:
                            case FinalCanbus.CAR_BNR_02_09Toyato_Prado_H /* 7733687 */:
                                int TempUnit2 = SystemProperties.getInt("persist.fyt.temperature", 0);
                                if (TempUnit2 == 1) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder(String.valueOf(((temp * 9) + 635) / 10)).toString());
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℉");
                                    break;
                                } else {
                                    int temp8 = (temp * 5) + 175;
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp8 / 10) + "." + (temp8 % 10));
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
                                    break;
                                }
                            case FinalCanbus.CAR_RZC_DongFeng_Fengxing_M7 /* 1114339 */:
                                int TempUnit3 = SystemProperties.getInt("persist.fyt.temperature", 0);
                                if (TempUnit3 == 1) {
                                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(((temp * 9) / 5) + 32).toString());
                                } else {
                                    int temp9 = temp * 10;
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp9 / 10) + "." + (temp9 % 10));
                                }
                                mUpdateTempUNITRight();
                                break;
                            case FinalCanbus.CAR_RZC_HavalH4_20 /* 1245428 */:
                                if (temp <= 144 && temp >= 112) {
                                    int temp10 = ((temp - 112) * 5) + 160;
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp10 / 10) + "." + (temp10 % 10));
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
                                    break;
                                } else {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText("--");
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                                    break;
                                }
                            case FinalCanbus.CAR_439_DJ_TOYOTA_08Prado_ShuPing_H /* 1442231 */:
                            case FinalCanbus.CAR_439_BNR_LEXUS_ES /* 1835447 */:
                            case FinalCanbus.CAR_439_BNR_LEXUS_ES_H /* 1900983 */:
                            case FinalCanbus.CAR_439_XBS_09Tianlai /* 4063671 */:
                                int temp11 = (temp * 5) + 175;
                                ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp11 / 10) + "." + (temp11 % 10));
                                ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
                                break;
                            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_GX50 /* 1507771 */:
                            case FinalCanbus.CAR_452_XinCheng_Infiniti_ESQ /* 1573316 */:
                            case FinalCanbus.CAR_452_XinCheng_Infiniti_06FX /* 1638852 */:
                            case FinalCanbus.CAR_452_XinCheng_Infiniti_08FX /* 1704388 */:
                            case FinalCanbus.CAR_452_XinCheng_Infiniti_G /* 1769924 */:
                            case FinalCanbus.CAR_452_XinCheng_Infiniti_14QX50 /* 1835460 */:
                            case FinalCanbus.CAR_452_XinCheng_Infiniti_14QX70 /* 1966532 */:
                            case FinalCanbus.CAR_452_XinCheng_Infiniti_13Q70L /* 2032068 */:
                            case FinalCanbus.CAR_452_XinCheng_Infiniti_12FX /* 3998148 */:
                            case FinalCanbus.CAR_452_XinCheng_Infiniti_15Q50L /* 4063684 */:
                            case FinalCanbus.CAR_452_XinCheng_Infiniti_12JX35 /* 4129220 */:
                            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_10G37 /* 4587963 */:
                            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_16Q50l_SP /* 5308859 */:
                            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_11FX35 /* 6095291 */:
                            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_14Q50_L /* 8651195 */:
                                int TempUnit4 = SystemProperties.getInt("persist.fyt.temperature", 0);
                                if (TempUnit4 == 1) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder(String.valueOf(((temp * 9) + 320) / 10)).toString());
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℉");
                                    break;
                                } else {
                                    int temp12 = temp * 5;
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp12 / 10) + "." + (temp12 % 10));
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
                                    break;
                                }
                            case FinalCanbus.CAR_RZC_Dodge_RAM_HY /* 1900917 */:
                            case FinalCanbus.CAR_RZC_Dodge_RAM_HY_M /* 1966453 */:
                            case FinalCanbus.CAR_RZC_Dodge_RAM_HY_H /* 2031989 */:
                                int temp13 = (temp * 5) + 155;
                                ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp13 / 10) + "." + (temp13 % 10));
                                mUpdateTempUNITRight();
                                break;
                            case FinalCanbus.CAR_452_OD_LandRover_Freelander /* 7799236 */:
                            case FinalCanbus.CAR_452_OD_Lamborghini /* 7930308 */:
                                if (temp == 16) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText("LO");
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                                    break;
                                } else if (temp == 80) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText("HI");
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                                    break;
                                } else {
                                    int TempUnit5 = SystemProperties.getInt("persist.fyt.temperature", 0);
                                    if (TempUnit5 == 1) {
                                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder(String.valueOf(((temp * 9) + 320) / 10.0f)).toString());
                                        ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℉");
                                        break;
                                    } else {
                                        int temp14 = temp * 5;
                                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp14 / 10) + "." + (temp14 % 10));
                                        ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
                                        break;
                                    }
                                }
                            case FinalCanbus.CAR_452_LZ_Volvo /* 7995844 */:
                            case FinalCanbus.CAR_452_LZ_Volvo_10 /* 13631940 */:
                            case FinalCanbus.CAR_452_LZ_Volvo_15 /* 16515524 */:
                                if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(((temp * 5) / 10) + "." + ((temp * 5) % 10));
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
                                    break;
                                } else {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(((temp * 9) + 320) / 10).toString());
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℉");
                                    break;
                                }
                            case FinalCanbus.CAR_452_OD_HuaChen_SWM_X7 /* 8323524 */:
                            case FinalCanbus.CAR_452_OD_HuaChen_SWM_X7_H /* 8389060 */:
                            case FinalCanbus.CAR_452_OD_HuaChen_SWM_G05 /* 15335876 */:
                            case FinalCanbus.CAR_452_OD_HuaChen_SWM_G05_H /* 15401412 */:
                                if (temp <= 32 && temp >= 1) {
                                    int temp_p4 = (temp * 5) + 160;
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp_p4 / 10) + "." + (temp_p4 % 10));
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
                                    break;
                                } else {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText("--");
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                                    break;
                                }
                            case FinalCanbus.CAR_439_LZ_INFINIT_FX35 /* 12714423 */:
                                if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((((temp * 5) + 175) / 10) + "." + (((temp * 5) + 175) % 10));
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
                                    break;
                                } else {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(temp + 59).toString());
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℉");
                                    break;
                                }
                            default:
                                if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp / 10) + "." + (temp % 10));
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
                                } else {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(temp).toString());
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℉");
                                }
                                mUpdateTempUNITRight();
                                break;
                        }
                    }
                }
                break;
        }
    }

    private void mUpdateTempUNITLeft() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT];
        if (ConstAllAirDara.U_AIR_TEMP_UNIT != 255) {
            ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText(vel == 0 ? "℃" : "℉");
        } else {
            int vel2 = SystemProperties.getInt("persist.fyt.temperature", 0);
            ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText(vel2 == 0 ? "℃" : "℉");
        }
    }

    private void mUpdateTempUNITRight() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT];
        if (ConstAllAirDara.U_AIR_TEMP_UNIT != 255) {
            ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText(vel == 0 ? "℃" : "℉");
        } else {
            int vel2 = SystemProperties.getInt("persist.fyt.temperature", 0);
            ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText(vel2 == 0 ? "℃" : "℉");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateDual() {
        int i = R.drawable.ic_sp_dual_p;
        int i2 = R.drawable.ic_sp_dual_n;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_DUAL];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_CYT_YaGe7_Portrait /* 65953 */:
            case FinalCanbus.CAR_CYT_YaGe8 /* 197025 */:
            case FinalCanbus.CAR_RCW_BYD_10_11F6 /* 328097 */:
            case FinalCanbus.CAR_RCW_BYD_10_13G6 /* 393633 */:
            case FinalCanbus.CAR_452_LZ_Audi_A3_SP /* 9306564 */:
            case FinalCanbus.CAR_452_LZ_Audi_A4_SP /* 9372100 */:
            case FinalCanbus.CAR_452_LZ_Audi_TT_SP /* 9437636 */:
            case FinalCanbus.CAR_452_LZ_Audi_A3_SP_H /* 11076036 */:
            case FinalCanbus.CAR_452_LZ_Audi_A4_SP_H /* 11141572 */:
            case FinalCanbus.CAR_452_LZ_Audi_TT_SP_H /* 11207108 */:
                View findViewById = findViewById(R.id.air_sp_dual);
                if (vel != 0) {
                    i = 2130840904;
                }
                findViewById.setBackgroundResource(i);
                break;
            default:
                View findViewById2 = findViewById(R.id.air_sp_dual);
                if (vel != 0) {
                    i2 = 2130840905;
                }
                findViewById2.setBackgroundResource(i2);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSYNC() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SYNC];
        findViewById(R.id.air_sp_sync).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_sync_n : R.drawable.ic_sp_sync_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateZONE() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_ZONE];
        findViewById(R.id.air_sp_zone).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_zone_n : R.drawable.ic_sp_zone_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateForest() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_FOREST];
        findViewById(R.id.air_sp_forest).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_forest_n : R.drawable.ic_sp_forest_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSteer() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_STEER];
        findViewById(R.id.air_sp_steer).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_steer_n : R.drawable.ic_sp_steer_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAuto() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO];
        int lev = DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO_LEV];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WC2_DaZhong_TuRui /* 131342 */:
                if (vel != 0) {
                    switch (lev) {
                        case 1:
                            findViewById(R.id.air_sp_auto).setBackgroundResource(R.drawable.ic_sp_auto_mid);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_auto).setBackgroundResource(R.drawable.ic_sp_auto_high);
                            break;
                        default:
                            findViewById(R.id.air_sp_auto).setBackgroundResource(R.drawable.ic_sp_auto_low);
                            break;
                    }
                } else {
                    switch (lev) {
                        case 1:
                            findViewById(R.id.air_sp_auto).setBackgroundResource(R.drawable.ic_sp_auto_off_mid);
                            break;
                        case 2:
                            findViewById(R.id.air_sp_auto).setBackgroundResource(R.drawable.ic_sp_auto_off_high);
                            break;
                        default:
                            findViewById(R.id.air_sp_auto).setBackgroundResource(R.drawable.ic_sp_auto_off_low);
                            break;
                    }
                }
            default:
                findViewById(R.id.air_sp_auto).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_auto_n : R.drawable.ic_sp_auto_p);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcMax() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC_MAX];
        findViewById(R.id.air_sp_acmax).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_acmax_n : R.drawable.ic_sp_acmax_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcOn() {
        int i = R.drawable.ic_sp_ac2_p;
        int i2 = R.drawable.ic_sp_ac2_n;
        int acOn = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_DJ_ShuPing_BYD_G6 /* 196759 */:
            case FinalCanbus.CAR_DJ_ShuPing_BYD_G6_H /* 262295 */:
                View findViewById = findViewById(R.id.air_sp_ac);
                if (acOn != 2) {
                    i = 2130840868;
                }
                findViewById.setBackgroundResource(i);
                break;
            default:
                View findViewById2 = findViewById(R.id.air_sp_ac);
                if (acOn != 0) {
                    i2 = 2130840869;
                }
                findViewById2.setBackgroundResource(i2);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCycle() {
        int i = R.drawable.ic_sp_cylce_out2_p;
        int i2 = R.drawable.ic_sp_cylce_in2_p;
        int cycle = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE];
        int cycle_auto = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE_AUTO];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WC2_DaZhong_TuRui /* 131342 */:
                findViewById(R.id.air_sp_cycle).setBackgroundResource(cycle == 1 ? 2130840895 : R.drawable.ic_sp_cylce_auto_n);
                break;
            case FinalCanbus.CAR_DJ_ShuPing_BYD_G6 /* 196759 */:
            case FinalCanbus.CAR_DJ_ShuPing_BYD_G6_H /* 262295 */:
                if (cycle == 1) {
                    findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_sp_cylce_in2_p);
                    break;
                } else if (cycle == 3) {
                    findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_sp_cylce_auto_p);
                    break;
                } else {
                    findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_sp_cylce_out2_p);
                    break;
                }
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_GX50 /* 1507771 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_10G37 /* 4587963 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_16Q50l_SP /* 5308859 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_11FX35 /* 6095291 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_14Q50_L /* 8651195 */:
                if (cycle == 0) {
                    findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_sp_cylce_out2_p);
                    break;
                } else if (cycle == 1) {
                    findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_sp_cylce_in2_p);
                    break;
                } else if (cycle == 2) {
                    findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_sp_cylce_auto_p);
                    break;
                }
            case FinalCanbus.CAR_452_XinCheng_Infiniti_06FX /* 1638852 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_08FX /* 1704388 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_G /* 1769924 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_14QX50 /* 1835460 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_14QX70 /* 1966532 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_12FX /* 3998148 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_15Q50L /* 4063684 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_12JX35 /* 4129220 */:
                if (cycle_auto == 1 && cycle == 1) {
                    findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_sp_cylce_auto_p);
                    break;
                } else if (cycle_auto == 0 && cycle == 1) {
                    findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_sp_cylce_in2_p);
                    break;
                } else if (cycle_auto == 0 && cycle == 0) {
                    findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_sp_cylce_out2_p);
                    break;
                }
            case FinalCanbus.CAR_RZC_BMW_X3_11_13 /* 3670067 */:
            case FinalCanbus.CAR_RZC_BMW_X3_13_16 /* 3735603 */:
            case FinalCanbus.CAR_RZC_BMW_X3_16_17 /* 3801139 */:
            case FinalCanbus.CAR_RZC_BMW_3_13_17 /* 3866675 */:
            case FinalCanbus.CAR_RZC_BMW_CCC /* 4128819 */:
            case FinalCanbus.CAR_RZC_BMW_EVO /* 4390963 */:
                if (cycle_auto == 1) {
                    findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_sp_cylce_auto_p);
                    break;
                } else if (cycle_auto == 0 && cycle == 1) {
                    findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_sp_cylce_in2_p);
                    break;
                } else if (cycle_auto == 0 && cycle == 0) {
                    findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_sp_cylce_out2_p);
                    break;
                }
            case FinalCanbus.CAR_452_OD_LandRover_Freelander /* 7799236 */:
            case FinalCanbus.CAR_452_OD_Lamborghini /* 7930308 */:
            case FinalCanbus.CAR_452_LZ_Audi_A3_SP /* 9306564 */:
            case FinalCanbus.CAR_452_LZ_Audi_A4_SP /* 9372100 */:
            case FinalCanbus.CAR_452_LZ_Audi_TT_SP /* 9437636 */:
            case FinalCanbus.CAR_452_LZ_Audi_A3_SP_H /* 11076036 */:
            case FinalCanbus.CAR_452_LZ_Audi_A4_SP_H /* 11141572 */:
            case FinalCanbus.CAR_452_LZ_Audi_TT_SP_H /* 11207108 */:
                View findViewById = findViewById(R.id.air_sp_cycle);
                if (cycle != 1) {
                    i2 = 2130840901;
                }
                findViewById.setBackgroundResource(i2);
                break;
            case FinalCanbus.CAR_452_LZ_Volvo /* 7995844 */:
            case FinalCanbus.CAR_452_LZ_Volvo_10 /* 13631940 */:
            case FinalCanbus.CAR_452_LZ_Volvo_15 /* 16515524 */:
                View findViewById2 = findViewById(R.id.air_sp_cycle);
                if (cycle != 0) {
                    i2 = R.drawable.ic_sp_cylce_out2_n;
                }
                findViewById2.setBackgroundResource(i2);
                break;
            default:
                View findViewById3 = findViewById(R.id.air_sp_cycle);
                if (cycle != 0) {
                    i = 2130840897;
                }
                findViewById3.setBackgroundResource(i);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSwing() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_SWING];
        findViewById(R.id.air_sp_swing).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_swing_n : R.drawable.ic_sp_swing_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFrontHot() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT_HOT];
        findViewById(R.id.air_sp_front_hot).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_front_hot_n : R.drawable.ic_sp_front_hot_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateION() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_ION];
        findViewById(R.id.air_sp_ion).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_ion_n : R.drawable.ic_sp_ion_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBlowTop() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOWTOP];
        findViewById(R.id.air_sp_blowtop).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_blowtop_n : R.drawable.ic_sp_blowtop_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePtc() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_PTC];
        findViewById(R.id.air_sp_ptc).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_ptc_n : R.drawable.ic_sp_ptc_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR];
        findViewById(R.id.air_sp_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_rear2_n : R.drawable.ic_sp_rear2_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFrontDefrost() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT];
        findViewById(R.id.air_sp_front).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_front2_n : R.drawable.ic_sp_front2_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFrontmaxDefrost() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONTMAX];
        findViewById(R.id.air_sp_frontmax).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_frontmax_n : R.drawable.ic_sp_frontmax_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePower() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_POWER];
        findViewById(R.id.air_sp_power).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_power_n : R.drawable.ic_sp_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateEV() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_EV];
        findViewById(R.id.air_sp_ev).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_ev_n : R.drawable.ic_sp_ev_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateECO() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_ECO];
        findViewById(R.id.air_sp_eco).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_eco_n : R.drawable.ic_sp_eco_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateNANOE() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_NANOE];
        findViewById(R.id.air_sp_nanoe).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_nanoe_n : R.drawable.ic_sp_nanoe_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCLEAN() {
        int clean = DataCanbus.DATA[ConstAllAirDara.U_AIR_CLEAN];
        findViewById(R.id.air_sp_clean).setBackgroundResource(clean == 0 ? R.drawable.ic_sp_clean_n : R.drawable.ic_sp_clean_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
        findViewById(R.id.air_sp_wind_txt).setVisibility(8);
        if (ConstAllAirDara.C_AIR_POWER != 255 && ConstAllAirDara.U_AIR_POWER == 255) {
            findViewById(R.id.air_sp_power).setBackgroundResource(leave == 0 ? R.drawable.ic_sp_power_n : R.drawable.ic_sp_power_p);
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_ALL_GM_SP_5 /* 327741 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_9 /* 589885 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_10 /* 655421 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_13 /* 852029 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_14 /* 917565 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_15 /* 983101 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_16 /* 1048637 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_17 /* 1114173 */:
            case FinalCanbus.CAR_452_XFY_PSA_3008_L /* 1114564 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_18 /* 1179709 */:
            case FinalCanbus.CAR_452_XFY_PSA_3008_H /* 1180100 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_19 /* 1245245 */:
            case FinalCanbus.CAR_RZC_HavalH4_20 /* 1245428 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_20 /* 1310781 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_23 /* 1507389 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_24 /* 1572925 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_25 /* 1638461 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_26 /* 1703997 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_27 /* 1769533 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_28 /* 1835069 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_29 /* 1900605 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_30 /* 1966141 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_31 /* 2031677 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_32 /* 2097213 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_33 /* 2162749 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_34 /* 2228285 */:
            case FinalCanbus.CAR_452_XP_Megane4_SP_L_HAND /* 2228676 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_35 /* 2293821 */:
            case FinalCanbus.CAR_452_XP_Megane4_SP_L_AUTO /* 2294212 */:
            case FinalCanbus.CAR_452_XP_Megane4_SP_H_AUTO /* 2359748 */:
            case FinalCanbus.CAR_439_RZC_ChangAn_CX70 /* 4391351 */:
            case FinalCanbus.CAR_439_RZC_ChangAn_OUSAN_KESAI /* 7471543 */:
            case FinalCanbus.CAR_452_LZ_Volvo /* 7995844 */:
            case FinalCanbus.CAR_453_LZ_Toyota_Tacoma_11 /* 8126917 */:
            case FinalCanbus.CAR_453_LZ_Toyota_Tacoma_05 /* 8192453 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_outlander_13_H /* 9634244 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_outlander_17_H /* 9699780 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_16_H /* 9765316 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_outlander_13_L /* 9830852 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_outlander_17_L /* 9896388 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_16_L /* 9961924 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_V97_H /* 10027460 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_V97_L /* 10092996 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_20_H /* 10158532 */:
            case FinalCanbus.CAR_452_KYC_Sanlin_Pajero_20_L /* 10224068 */:
            case FinalCanbus.CAR_452_RZC_ChangAn_KESAI_Pro_21 /* 11010500 */:
            case FinalCanbus.CAR_452_LZ_Volvo_10 /* 13631940 */:
            case FinalCanbus.CAR_439_DJ_Siyu /* 14549431 */:
            case FinalCanbus.CAR_452_LZ_Volvo_15 /* 16515524 */:
                findViewById(R.id.air_sp_wind_lev).setVisibility(8);
                findViewById(R.id.air_sp_wind_txt).setVisibility(0);
                ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(leave).toString());
                break;
            case FinalCanbus.CAR_RZC4_PSA_19_408 /* 590163 */:
            case FinalCanbus.CAR_RZC4_PSA_19_408_H /* 655699 */:
                findViewById(R.id.air_sp_wind_lev).setVisibility(8);
                findViewById(R.id.air_sp_wind_txt).setVisibility(0);
                if (leave >= 1) {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(leave - 1).toString());
                    break;
                } else {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText("Auto");
                    break;
                }
            case FinalCanbus.CAR_BNR_02_09Toyato_Prado /* 7668151 */:
            case FinalCanbus.CAR_BNR_02_09Toyato_Prado_H /* 7733687 */:
                switch (leave) {
                    case 0:
                        findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind7_0);
                        break;
                    case 1:
                        findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind7_2);
                        break;
                    case 2:
                        findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind7_3);
                        break;
                    case 3:
                        findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind7_4);
                        break;
                    case 4:
                        findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind7_5);
                        break;
                    case 5:
                        findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind7_7);
                        break;
                }
            default:
                switch (leave) {
                    case 0:
                        findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind7_0);
                        break;
                    case 1:
                        findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind7_1);
                        break;
                    case 2:
                        findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind7_2);
                        break;
                    case 3:
                        findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind7_3);
                        break;
                    case 4:
                        findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind7_4);
                        break;
                    case 5:
                        findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind7_5);
                        break;
                    case 6:
                        findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind7_6);
                        break;
                    case 7:
                        findViewById(R.id.air_sp_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind7_7);
                        break;
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowMode() {
        boolean b_body_foot = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT] != 1 && DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT] == 1 && DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT] == 1;
        boolean b_up_foot = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT] == 1 && DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT] != 1 && DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT] == 1;
        boolean b_foot = (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT] == 1 || DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT] == 1 || DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT] != 1) ? false : true;
        boolean b_body = (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT] == 1 || DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT] == 1 || DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT] != 1) ? false : true;
        boolean b_up = (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT] != 1 || DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT] == 1 || DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT] == 1) ? false : true;
        boolean b_up_body = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT] == 1 && DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT] != 1 && DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT] == 1;
        boolean b_up_body_foot = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT] == 1 && DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT] == 1 && DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT] == 1;
        boolean b_null = (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT] == 1 || DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT] == 1 || DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT] == 1) ? false : true;
        if (ConstAllAirDara.U_AIR_BLOW_BODYFOOT_LEFT != 255 || ConstAllAirDara.U_AIR_BLOW_UPFOOT_LEFT != 255) {
            b_body_foot = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODYFOOT_LEFT] == 1;
            b_up_foot = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UPFOOT_LEFT] == 1;
            b_foot = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT] == 1;
            b_body = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT] == 1;
            findViewById(R.id.air_sp_mode_up).setVisibility(8);
            findViewById(R.id.air_sp_mode_body).setVisibility(8);
            findViewById(R.id.air_sp_mode_foot).setVisibility(8);
            if (b_body_foot) {
                findViewById(R.id.air_sp_mode_body).setVisibility(0);
                findViewById(R.id.air_sp_mode_foot).setVisibility(0);
            } else if (b_up_foot) {
                findViewById(R.id.air_sp_mode_up).setVisibility(0);
                findViewById(R.id.air_sp_mode_foot).setVisibility(0);
            } else if (b_foot) {
                findViewById(R.id.air_sp_mode_foot).setVisibility(0);
            } else if (b_body) {
                findViewById(R.id.air_sp_mode_body).setVisibility(0);
            }
        }
        findViewById(R.id.air_sp_blow_body_foot).setBackgroundResource(b_body_foot ? R.drawable.ic_sp_mode_body_foot_p : R.drawable.ic_sp_mode_body_foot_n);
        findViewById(R.id.air_sp_blow_foot_win).setBackgroundResource(b_up_foot ? R.drawable.ic_sp_mode_win_foot_p : R.drawable.ic_sp_mode_win_foot_n);
        if (ConstAllAirDara.C_AIR_MODE_BODYFOOT == 255 && ConstAllAirDara.C_AIR_MODE_UPFOOT == 255) {
            findViewById(R.id.air_sp_blow_body).setBackgroundResource(DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT] == 1 ? R.drawable.ic_sp_mode_body_p : R.drawable.ic_sp_mode_body_n);
            findViewById(R.id.air_sp_blow_foot).setBackgroundResource(DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT] == 1 ? R.drawable.ic_sp_mode_foot_p : R.drawable.ic_sp_mode_foot_n);
            findViewById(R.id.air_sp_blow_win).setBackgroundResource(DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT] == 1 ? R.drawable.ic_sp_mode_win_p : R.drawable.ic_sp_mode_win_n);
        } else {
            if (ConstAllAirDara.C_AIR_MODE_BODY != 255) {
                findViewById(R.id.air_sp_blow_body).setBackgroundResource(b_body ? R.drawable.ic_sp_mode_body_p : R.drawable.ic_sp_mode_body_n);
            }
            if (ConstAllAirDara.C_AIR_MODE_FOOT != 255) {
                findViewById(R.id.air_sp_blow_foot).setBackgroundResource(b_foot ? R.drawable.ic_sp_mode_foot_p : R.drawable.ic_sp_mode_foot_n);
            }
            if (ConstAllAirDara.C_AIR_MODE_UP != 255) {
                findViewById(R.id.air_sp_blow_win).setBackgroundResource(b_up ? R.drawable.ic_sp_mode_win_p : R.drawable.ic_sp_mode_win_n);
            }
        }
        if (ConstAllAirDara.C_AIR_MODE_CHANGER != 255) {
            if (b_body_foot) {
                findViewById(R.id.air_sp_blow_changer).setBackgroundResource(R.drawable.ic_sp_mode_body_foot_p);
                return;
            }
            if (b_up_foot) {
                findViewById(R.id.air_sp_blow_changer).setBackgroundResource(R.drawable.ic_sp_mode_win_foot_p);
                return;
            }
            if (b_foot) {
                findViewById(R.id.air_sp_blow_changer).setBackgroundResource(R.drawable.ic_sp_mode_foot_p);
                return;
            }
            if (b_body) {
                findViewById(R.id.air_sp_blow_changer).setBackgroundResource(R.drawable.ic_sp_mode_body_p);
                return;
            }
            if (b_up) {
                findViewById(R.id.air_sp_blow_changer).setBackgroundResource(R.drawable.ic_sp_mode_win_p);
                return;
            }
            if (b_up_body) {
                findViewById(R.id.air_sp_blow_changer).setBackgroundResource(R.drawable.ic_sp_mode_body_win_p);
            } else if (b_up_body_foot) {
                findViewById(R.id.air_sp_blow_changer).setBackgroundResource(R.drawable.ic_sp_mode_body_foot_win_p);
            } else if (b_null) {
                findViewById(R.id.air_sp_blow_changer).setBackgroundResource(R.drawable.ic_sp_mode_null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowModeUp() {
        int data = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT];
        if (ConstAllAirDara.U_AIR_BLOW_BODYFOOT_LEFT == 255 && ConstAllAirDara.U_AIR_BLOW_UPFOOT_LEFT == 255) {
            if (ConstAllAirDara.U_AIR_BLOW_UP_LEFT == 255) {
                findViewById(R.id.air_sp_mode_up).setVisibility(8);
            } else {
                findViewById(R.id.air_sp_mode_up).setVisibility(data == 1 ? 0 : 8);
            }
        }
        updateBlowMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowModeBody() {
        int data = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT];
        if (ConstAllAirDara.U_AIR_BLOW_BODYFOOT_LEFT == 255 && ConstAllAirDara.U_AIR_BLOW_UPFOOT_LEFT == 255) {
            if (ConstAllAirDara.U_AIR_BLOW_BODY_LEFT == 255) {
                findViewById(R.id.air_sp_mode_body).setVisibility(8);
            } else {
                findViewById(R.id.air_sp_mode_body).setVisibility(data == 1 ? 0 : 8);
            }
        }
        updateBlowMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowModeFoot() {
        int data = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT];
        if (ConstAllAirDara.U_AIR_BLOW_BODYFOOT_LEFT == 255 && ConstAllAirDara.U_AIR_BLOW_UPFOOT_LEFT == 255) {
            if (ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT == 255) {
                findViewById(R.id.air_sp_mode_foot).setVisibility(8);
            } else {
                findViewById(R.id.air_sp_mode_foot).setVisibility(data == 1 ? 0 : 8);
            }
        }
        updateBlowMode();
    }

    private void updateBlowModeRight() {
        boolean b_body_foot = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_RIGHT] != 1 && DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT] == 1 && DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT] == 1;
        boolean b_up_foot = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_RIGHT] == 1 && DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT] != 1 && DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT] == 1;
        boolean b_foot = (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_RIGHT] == 1 || DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT] == 1 || DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT] != 1) ? false : true;
        boolean b_body = (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_RIGHT] == 1 || DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT] != 1 || DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT] == 1) ? false : true;
        boolean b_up = (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_RIGHT] != 1 || DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT] == 1 || DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT] == 1) ? false : true;
        boolean b_up_body = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_RIGHT] == 1 && DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT] != 1 && DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT] == 1;
        boolean b_up_body_foot = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_RIGHT] == 1 && DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT] == 1 && DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT] == 1;
        boolean b_null = (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_RIGHT] == 1 || DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT] == 1 || DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT] == 1) ? false : true;
        if (ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT != 255) {
            if (b_body_foot) {
                findViewById(R.id.air_sp_blow_changer_right).setBackgroundResource(R.drawable.ic_sp_mode_body_foot_p);
                return;
            }
            if (b_up_foot) {
                findViewById(R.id.air_sp_blow_changer_right).setBackgroundResource(R.drawable.ic_sp_mode_win_foot_p);
                return;
            }
            if (b_foot) {
                findViewById(R.id.air_sp_blow_changer_right).setBackgroundResource(R.drawable.ic_sp_mode_foot_p);
                return;
            }
            if (b_body) {
                findViewById(R.id.air_sp_blow_changer_right).setBackgroundResource(R.drawable.ic_sp_mode_body_p);
                return;
            }
            if (b_up) {
                findViewById(R.id.air_sp_blow_changer_right).setBackgroundResource(R.drawable.ic_sp_mode_win_p);
                return;
            }
            if (b_up_body) {
                findViewById(R.id.air_sp_blow_changer_right).setBackgroundResource(R.drawable.ic_sp_mode_body_win_p);
            } else if (b_up_body_foot) {
                findViewById(R.id.air_sp_blow_changer_right).setBackgroundResource(R.drawable.ic_sp_mode_body_foot_win_p);
            } else if (b_null) {
                findViewById(R.id.air_sp_blow_changer_right).setBackgroundResource(R.drawable.ic_sp_mode_null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowModeUpRight() {
        updateBlowModeRight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowModeBodyRight() {
        updateBlowModeRight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowModeFootRight() {
        updateBlowModeRight();
    }
}
