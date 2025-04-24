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

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_Activity_All_Normal extends Activity implements View.OnTouchListener {
    public static Air_Activity_All_Normal mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == ConstAllAirDara.U_AIR_AC) {
                Air_Activity_All_Normal.this.mUpdateAcOn();
            }
            if (updateCode == ConstAllAirDara.U_AIR_CYCLE) {
                Air_Activity_All_Normal.this.mUpdateCycle();
            }
            if (updateCode == ConstAllAirDara.U_AIR_PTC) {
                Air_Activity_All_Normal.this.mUpdatePtc();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SWING) {
                Air_Activity_All_Normal.this.mUpdateSwing();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FRONT_HOT) {
                Air_Activity_All_Normal.this.mUpdateFrontHot();
            }
            if (updateCode == ConstAllAirDara.U_AIR_ION) {
                Air_Activity_All_Normal.this.mUpdateION();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOWTOP) {
                Air_Activity_All_Normal.this.mUpdateBlowTop();
            }
            if (updateCode == ConstAllAirDara.U_AIR_CYCLE_AUTO) {
                Air_Activity_All_Normal.this.mUpdateCycle();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR) {
                Air_Activity_All_Normal.this.mUpdateRearDefrost();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FRONT) {
                Air_Activity_All_Normal.this.mUpdateFrontDefrost();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FRONTMAX) {
                Air_Activity_All_Normal.this.mUpdateFrontmaxDefrost();
            }
            if (updateCode == ConstAllAirDara.U_AIR_POWER) {
                Air_Activity_All_Normal.this.mUpdatePower();
            }
            if (updateCode == ConstAllAirDara.U_AIR_TEMP_LEFT) {
                Air_Activity_All_Normal.this.mUpdateAirTempLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_TEMP_UNIT) {
                Air_Activity_All_Normal.this.mUpdateAirTempLeft();
                Air_Activity_All_Normal.this.mUpdateTempRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT) {
                Air_Activity_All_Normal.this.mUpdaterAirWindLevelLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_BODYFOOT_LEFT) {
                Air_Activity_All_Normal.this.updateBlowMode();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_UPFOOT_LEFT) {
                Air_Activity_All_Normal.this.updateBlowMode();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_UP_LEFT) {
                Air_Activity_All_Normal.this.updateBlowModeUp();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_BODY_LEFT) {
                Air_Activity_All_Normal.this.updateBlowModeBody();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT) {
                Air_Activity_All_Normal.this.updateBlowModeFoot();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_UP_RIGHT) {
                Air_Activity_All_Normal.this.updateBlowModeUpRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT) {
                Air_Activity_All_Normal.this.updateBlowModeBodyRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT) {
                Air_Activity_All_Normal.this.updateBlowModeFootRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_AC_MAX) {
                Air_Activity_All_Normal.this.mUpdateAcMax();
            }
            if (updateCode == ConstAllAirDara.U_AIR_AUTO) {
                Air_Activity_All_Normal.this.mUpdateAuto();
            }
            if (updateCode == ConstAllAirDara.U_AIR_AUTO_RIGHT) {
                Air_Activity_All_Normal.this.mUpdateAutoRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_DUAL) {
                Air_Activity_All_Normal.this.mUpdateDual();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SYNC) {
                Air_Activity_All_Normal.this.mUpdateSYNC();
            }
            if (updateCode == ConstAllAirDara.U_AIR_ZONE) {
                Air_Activity_All_Normal.this.mUpdateZONE();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FOREST) {
                Air_Activity_All_Normal.this.mUpdateForest();
            }
            if (updateCode == ConstAllAirDara.U_AIR_STEER) {
                Air_Activity_All_Normal.this.mUpdateSteer();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATHEAT_LEFT) {
                Air_Activity_All_Normal.this.mUpdateHeatLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATHEAT_RIGHT) {
                Air_Activity_All_Normal.this.mUpdateHeatRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATWIND_LEFT) {
                Air_Activity_All_Normal.this.mUpdateWindLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATWIND_RIGHT) {
                Air_Activity_All_Normal.this.mUpdateWindRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_TEMP_RIGHT) {
                Air_Activity_All_Normal.this.mUpdateTempRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_EV) {
                Air_Activity_All_Normal.this.mUpdateEV();
            }
            if (updateCode == ConstAllAirDara.U_AIR_ECO) {
                Air_Activity_All_Normal.this.mUpdateECO();
            }
            if (updateCode == ConstAllAirDara.U_AIR_NANOE) {
                Air_Activity_All_Normal.this.mUpdateNANOE();
            }
            if (updateCode == ConstAllAirDara.U_AIR_CLEAN) {
                Air_Activity_All_Normal.this.mUpdateCLEAN();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR_CTRL) {
                Air_Activity_All_Normal.this.mUpdateRearCtrl();
            }
            if (updateCode == ConstAllAirDara.U_AIR_CLEANAIR) {
                Air_Activity_All_Normal.this.mUpdateCleanAir();
            }
            if (updateCode == ConstAllAirDara.U_AIR_HEAT) {
                Air_Activity_All_Normal.this.mUpdateAirHeat();
            }
            if (updateCode == ConstAllAirDara.U_AIR_COOL) {
                Air_Activity_All_Normal.this.mUpdateAirCool();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SOFT) {
                Air_Activity_All_Normal.this.mUpdateAirSoft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FAST) {
                Air_Activity_All_Normal.this.mUpdateAirFast();
            }
            if (updateCode == ConstAllAirDara.U_AIR_NORMAL) {
                Air_Activity_All_Normal.this.mUpdateAirNormal();
            }
            if (updateCode == ConstAllAirDara.U_AIR_MODE) {
                Air_Activity_All_Normal.this.mUpdateAirMode();
            }
            if (updateCode == ConstAllAirDara.U_AIR_AQS) {
                Air_Activity_All_Normal.this.mUpdateAirAQS();
            }
            if (updateCode == ConstAllAirDara.U_AIR_WINLEV) {
                Air_Activity_All_Normal.this.mUpdateAirWinlev();
            }
            if (updateCode != ConstAllAirDara.U_AIR_REST) {
                return;
            }
            Air_Activity_All_Normal.this.mUpdateAirRest();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String platform = SystemProperties.get("ro.fyt.platform", "");
        if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform) || "6318".equals(platform) || "823".equals(platform)) {
            //setContentView(R.layout.layout_air_sp_rzc_focus);
            if ("6318".equals(platform) || "823".equals(platform)) {
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.sp_air_bg_7870);
            } else {
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.sp_air_bg);
            }
        } else {
            //setContentView(R.layout.layout_air_sp_rzc_focus_7731);
        }
        mInstance = this;
    }

    private void sendCmd(int data0, int data1) {
        switch (DataCanbus.DATA[1000]) {
            case 20:
            case 38:
            case 40:
            case 101:
            case 151:
            case 231:
            case 274:
            case 317:
            case 363:
            case 372:
            case 406:
            case 407:
            case 412:
            case 416:
            case 437:
            case 438:
            case 443:
            case FinalCanbus.CAR_WC2_CHANGANCX7 /* 65664 */:
            case FinalCanbus.CAR_DJ_MENGDIOU2013_H /* 65767 */:
            case FinalCanbus.CAR_DJ_XP1_ACCORD7_H /* 65810 */:
            case FinalCanbus.CAR_DJ_ShuPing_MENGDIOU /* 65836 */:
            case FinalCanbus.CAR_WeiChi2_XTS /* 65853 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ShuPingNewJunWei_M /* 65899 */:
            case FinalCanbus.CAR_WC1_Jeep_ZiYouGuang_M /* 65908 */:
            case FinalCanbus.CAR_BSD_XP1_SHUPING_RENAULT_KeLeiAo /* 65938 */:
            case FinalCanbus.CAR_XFY_XP1_ChangAnCsSerial /* 65942 */:
            case FinalCanbus.CAR_DaoJun_XINPU_ChuanQiGs4_H /* 65943 */:
            case FinalCanbus.CAR_438_BNR_DaZhong_H /* 65974 */:
            case FinalCanbus.CAR_XP1_Camry2013_H /* 131092 */:
            case FinalCanbus.CAR_WC1_Nawala_Philippine /* 131110 */:
            case FinalCanbus.CAR_WC1_QiJun_H /* 131173 */:
            case FinalCanbus.CAR_WeiChi2_XTS_SEATHEAT /* 131389 */:
            case FinalCanbus.CAR_WC1_Jeep_ZiYouGuang_H /* 131444 */:
            case FinalCanbus.CAR_BSD_XP1_SHUPING_RENAULT_KeLeiAo_H /* 131474 */:
            case FinalCanbus.CAR_XFY_XP1_ZhongTaiSR7_H /* 131478 */:
            case FinalCanbus.CAR_WC2_RongWei_I5 /* 131488 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_17Koleos /* 131524 */:
            case FinalCanbus.CAR_WeiChi2_ATS_H /* 196925 */:
            case FinalCanbus.CAR_WC2_RongWei_I6 /* 197024 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_18Koleos /* 197060 */:
            case FinalCanbus.CAR_BNR_CX70 /* 262214 */:
            case FinalCanbus.CAR_WC2_CHANGAN_19KeSai /* 262272 */:
            case FinalCanbus.CAR_DJ_Shuping_YEMA /* 262444 */:
            case FinalCanbus.CAR_WeiChi2_SRX /* 262461 */:
            case FinalCanbus.CAR_WC1_Jeep_17ZhiNanZhe /* 262516 */:
            case FinalCanbus.CAR_WC2_RongWei_EI6 /* 262560 */:
            case FinalCanbus.CAR_WC2_CHANGAN_19KeSai_Hand /* 327808 */:
            case FinalCanbus.CAR_WeiChi2_15SRX /* 327997 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
            case FinalCanbus.CAR_WC1_Jeep_17ZhiNanZhe_H /* 328052 */:
            case FinalCanbus.CAR_WC2_RongWei_RX3 /* 328096 */:
            case FinalCanbus.CAR_BNR_16CS75_L /* 393286 */:
            case FinalCanbus.CAR_WC1_17QiJun /* 393317 */:
            case FinalCanbus.CAR_XP1_QiJun_DaoJun_SHOUDONG /* 393359 */:
            case FinalCanbus.CAR_WeiChi2_18XTS /* 393533 */:
            case FinalCanbus.CAR_BNR_16CS75_M /* 458822 */:
            case FinalCanbus.CAR_WC1_17QiJun_H /* 458853 */:
            case FinalCanbus.CAR_WeiChi2_18ATS /* 459069 */:
            case FinalCanbus.CAR_WC2_RENAULT_Megane4 /* 459104 */:
            case FinalCanbus.CAR_XP1_YearGmcSeries_NoAir /* 459164 */:
            case FinalCanbus.CAR_WC2_RongWei_I5_H /* 459168 */:
            case FinalCanbus.CAR_BNR_16CS75_H_RightCamera /* 524358 */:
            case FinalCanbus.CAR_WC1_Tuda /* 524389 */:
            case FinalCanbus.CAR_RCW_BYD_6 /* 524439 */:
            case FinalCanbus.CAR_WeiChi2_NewJunYue /* 524605 */:
            case FinalCanbus.CAR_BNR_16CS75_H_FullView /* 589894 */:
            case FinalCanbus.CAR_WC1_19QiJun /* 589925 */:
            case FinalCanbus.CAR_XP1_QiJun_DaoJun_ZIDONG /* 589967 */:
            case FinalCanbus.CAR_RCW_BYD_12_18Surui /* 589975 */:
            case FinalCanbus.CAR_WC_SP_1213Camery /* 590118 */:
            case FinalCanbus.CAR_BNR_17CS75 /* 655430 */:
            case FinalCanbus.CAR_WC1_Tuda_Hand /* 655461 */:
            case FinalCanbus.CAR_WC_SP_1516Camery_15Reiz /* 655654 */:
            case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng /* 655708 */:
            case FinalCanbus.CAR_RZC_BenTeng_19B50_HAND /* 655773 */:
            case FinalCanbus.CAR_WC2_RongWei_I6_17_low /* 655776 */:
            case FinalCanbus.CAR_WC1_Nawala /* 720997 */:
            case FinalCanbus.CAR_XP1_15QiJun_Shuping /* 721039 */:
            case FinalCanbus.CAR_WC_SP_101416Prado_LuXun_12Rezi_ZiDong /* 721190 */:
            case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng1 /* 721244 */:
            case FinalCanbus.CAR_RZC_BenTeng_19B50_AUTO /* 721309 */:
            case FinalCanbus.CAR_WC1_Nawala_Hand /* 786533 */:
            case FinalCanbus.CAR_WC_SP_101416Prado_LuXun_12Rezi_ShouDong /* 786726 */:
            case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng2 /* 786780 */:
            case FinalCanbus.CAR_WC1_Tuda_H /* 852069 */:
            case FinalCanbus.CAR_WC_SP_09Camery /* 852262 */:
            case FinalCanbus.CAR_DAOJUN_OD_ATS /* 852316 */:
            case FinalCanbus.CAR_BNR_19COS /* 917574 */:
            case FinalCanbus.CAR_WC_SP_12LuXun /* 917798 */:
            case FinalCanbus.CAR_WC2_Honda_17GuanDao /* 917825 */:
            case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
            case FinalCanbus.CAR_BNR_17CX70 /* 983110 */:
            case FinalCanbus.CAR_WC_SP_15HighLand_Zidong /* 983334 */:
            case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
            case FinalCanbus.CAR_WC2_RENAULT_Megane4_M /* 983392 */:
            case FinalCanbus.CAR_BNR_17CX70_M /* 1048646 */:
            case FinalCanbus.CAR_WC_SP_15HighLand_ShouDong /* 1048870 */:
            case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
            case FinalCanbus.CAR_BNR_17CX70_H /* 1114182 */:
            case FinalCanbus.CAR_WC_SP_09HighLand_Zidong /* 1114406 */:
            case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
            case FinalCanbus.CAR_WC1_TMK_BENZ_MPV_ALL /* 1114484 */:
            case FinalCanbus.CAR_WC_SP_09HighLand_ShouDong /* 1179942 */:
            case FinalCanbus.CAR_WC_SP_07KaluoLa_ZiDong /* 1245478 */:
            case FinalCanbus.CAR_WC_SP_14KaluoLa_ZiDong /* 1311014 */:
            case FinalCanbus.CAR_XP_TuGuan_L_20_H /* 1376296 */:
            case FinalCanbus.CAR_WC_SP_Alpha /* 1376550 */:
            case FinalCanbus.CAR_443_WC2_TOYOTA_09HG /* 1376699 */:
            case FinalCanbus.CAR_WC_SP_02_09Prado /* 1442086 */:
            case FinalCanbus.CAR_WC2_RENAULT_Megane4_H /* 1442144 */:
            case FinalCanbus.CAR_XP_Renault_23KOLEOS_L_Auto /* 1442216 */:
            case FinalCanbus.CAR_443_WC2_TOYOTA_09RAV4 /* 1442235 */:
            case FinalCanbus.CAR_WC_SP_09_13RAV4 /* 1507622 */:
            case FinalCanbus.CAR_XP_Renault_23KOLEOS_L_Hand /* 1507752 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES200_13 /* 1572976 */:
            case FinalCanbus.CAR_WC_SP_09_Lexus_ES350 /* 1573158 */:
            case FinalCanbus.CAR_XP_Renault_23KOLEOS_H_Auto /* 1573288 */:
            case FinalCanbus.CAR_443_WC2_TOYOTA_08Camery /* 1573307 */:
            case FinalCanbus.CAR_WC_SP_09_Lexus_ES350_H /* 1638694 */:
            case FinalCanbus.CAR_RZC_XP1_21Xiaomayi_EQ1 /* 1638804 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES300_05 /* 1704048 */:
            case FinalCanbus.CAR_WC2_RENAULT_23Megane4 /* 1704288 */:
            case FinalCanbus.CAR_439_Oudi_Haval_H3 /* 1704375 */:
            case FinalCanbus.CAR_455_TD_INFINIT_ESQ /* 1704391 */:
            case FinalCanbus.CAR_WC2_RENAULT_23Megane4_M /* 1769824 */:
            case FinalCanbus.CAR_444_WC2_ChangfengLiebao_CS9_17 /* 1769916 */:
            case FinalCanbus.CAR_455_TD_INFINIT_G /* 1769927 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES300_20 /* 1835120 */:
            case FinalCanbus.CAR_WC2_RENAULT_23Megane4_H /* 1835360 */:
            case FinalCanbus.CAR_RZC3_XianDai_I30_15 /* 1835370 */:
            case FinalCanbus.CAR_455_TD_INFINIT_QX50 /* 1835463 */:
            case FinalCanbus.CAR_WC2_RENAULT_Talisman /* 1900896 */:
            case FinalCanbus.CAR_RZC3_XianDai_CEED_11 /* 1900906 */:
            case FinalCanbus.CAR_455_TD_INFINIT_06FX /* 1900999 */:
            case FinalCanbus.CAR_WC2_RENAULT_Talisman_M /* 1966432 */:
            case FinalCanbus.CAR_455_TD_INFINIT_08FX /* 1966535 */:
            case FinalCanbus.CAR_WC2_RENAULT_Talisman_H /* 2031968 */:
            case FinalCanbus.CAR_439_OuDi_NaZhiJieU7 /* 2032055 */:
            case FinalCanbus.CAR_455_TD_INFINIT_14QX70 /* 2032071 */:
            case FinalCanbus.CAR_455_TD_INFINIT_12FX /* 2097607 */:
            case FinalCanbus.CAR_DJ_XP1_ParkAvenue /* 2162713 */:
            case FinalCanbus.CAR_WC2_RENAULT_17KOLEOS_L /* 2621792 */:
            case FinalCanbus.CAR_455_LUZ_Nissan_GTR_EN /* 2621895 */:
            case FinalCanbus.CAR_XP1_TOYOTA_12Camry_SP /* 2686996 */:
            case FinalCanbus.CAR_WC2_RENAULT_17KOLEOS_M /* 2687328 */:
            case FinalCanbus.CAR_452_Mixun_Liebao_CS9 /* 2687428 */:
            case FinalCanbus.CAR_XP1_TOYOTA_16CRUISER_SP /* 2752532 */:
            case FinalCanbus.CAR_WC2_RENAULT_17KOLEOS_H /* 2752864 */:
            case FinalCanbus.CAR_XP1_TOYOTA_15Camry_SP /* 2818068 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_17Koleos_M /* 2818500 */:
            case FinalCanbus.CAR_XP1_TOYOTA_18Camry_SP /* 2883604 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_17Koleos_H /* 2884036 */:
            case FinalCanbus.CAR_XP1_TOYOTA_15Highlander_Hand_SP /* 2949140 */:
            case FinalCanbus.CAR_XP1_TOYOTA_15Highlander_AUTO_SP /* 3014676 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_18Koleos_M /* 3015108 */:
            case FinalCanbus.CAR_XP1_TOYOTA_14Tundra_Hand_SP /* 3080212 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_18Koleos_H /* 3080644 */:
            case FinalCanbus.CAR_XP1_TOYOTA_14Tundra_AUTO_SP /* 3145748 */:
            case FinalCanbus.CAR_XP1_TOYOTA_10Prado_SP /* 3211284 */:
            case FinalCanbus.CAR_439_OuDi_NaZhiJieU5 /* 3932599 */:
            case FinalCanbus.CAR_439_HC_OuGeTL /* 3998135 */:
            case FinalCanbus.CAR_439_HC_TianLai_GongJue /* 6095287 */:
            case FinalCanbus.CAR_452_OD_Nissan_Tule_low /* 6095300 */:
            case FinalCanbus.CAR_452_OD_Zhonghua_V6_18 /* 6160836 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_07Shengda /* 6422971 */:
            case FinalCanbus.CAR_439_HC_TianLai_GongJue_CD /* 6488503 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_12SORENTO /* 6488507 */:
            case FinalCanbus.CAR_439_HC_Ruijie /* 6816183 */:
            case FinalCanbus.CAR_439_HC_Ruijie_H /* 6881719 */:
            case FinalCanbus.CAR_439_HC_Nissan_Toread /* 7012791 */:
            case FinalCanbus.CAR_443_WC2_OULANDE_H /* 7012795 */:
            case FinalCanbus.CAR_RZC_TOYOTA_04Verso_SP /* 7078000 */:
            case FinalCanbus.CAR_RZC_TOYOTA_10Prius_SP /* 7536752 */:
            case FinalCanbus.CAR_439_BNR_Rongwei_RX5 /* 7995831 */:
            case FinalCanbus.CAR_RZC_TOYOTA_16Prius_SP /* 8126576 */:
            case FinalCanbus.CAR_RZC_TOYOTA_14Tundra /* 8192112 */:
            case FinalCanbus.CAR_RZC_TOYOTA_14Tundra_Auto /* 8257648 */:
            case FinalCanbus.CAR_RZC_TOYOTA_10Sequoia /* 8323184 */:
            case FinalCanbus.CAR_RZC_TOYOTA_10Sequoia_Auto /* 8388720 */:
            case FinalCanbus.CAR_RZC_TOYOTA_08Camry /* 8454256 */:
            case FinalCanbus.CAR_RZC_TOYOTA_13Camry /* 8519792 */:
            case FinalCanbus.CAR_RZC_TOYOTA_10AURIS_Auto /* 8585328 */:
            case FinalCanbus.CAR_RZC_TOYOTA_13Avalon_Auto /* 8650864 */:
            case FinalCanbus.CAR_452_OuDi_NaZhiJieU6 /* 11534788 */:
            case FinalCanbus.CAR_439_DJ_Nissan /* 12779959 */:
            case FinalCanbus.CAR_439_DJ_Nissan_H /* 12845495 */:
            case FinalCanbus.CAR_439_DJ_06_09Kayan /* 12911031 */:
            case FinalCanbus.CAR_452_XC_Honda_Acura_TL /* 12911044 */:
            case FinalCanbus.CAR_452_XC_Honda_Acura_RDX /* 12976580 */:
            case FinalCanbus.CAR_452_XC_Honda_Acura_TLX /* 13042116 */:
            case FinalCanbus.CAR_439_LUZ_Nissan_GTR /* 13566391 */:
            case FinalCanbus.CAR_454_LZ_Nissan_370Z_L /* 14680518 */:
            case FinalCanbus.CAR_454_LZ_Nissan_370Z_TW /* 14811590 */:
            case FinalCanbus.CAR_453_LZ_Teana_08_L /* 15532485 */:
            case FinalCanbus.CAR_453_LZ_Teana_08_H /* 15598021 */:
            case FinalCanbus.CAR_453_LZ_Teana_08_TW /* 15663557 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_L /* 15729094 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H /* 15794630 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_TW /* 15860166 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H_NP /* 15925702 */:
                DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                break;
            case 80:
            case 369:
            case 392:
            case 414:
            case 433:
            case FinalCanbus.CAR_CYT_GaoErFu7 /* 65576 */:
            case FinalCanbus.CAR_WC1_CYT_ShuPing_07_11_MENGDIOU /* 65759 */:
            case FinalCanbus.CAR_CYT_DaZhongZiDongKongTiao_H /* 65905 */:
            case FinalCanbus.CAR_CYT_SHUPING_CAMARY_15 /* 65928 */:
            case FinalCanbus.CAR_CYT_GaoErFu7_M /* 131112 */:
            case FinalCanbus.CAR_RZC_XP1_QiJun_H /* 131152 */:
            case FinalCanbus.CAR_WC1_ShuPing_ZhiSheng_High /* 131295 */:
            case FinalCanbus.CAR_CYT_ShuPing_HavalH2 /* 131316 */:
            case FinalCanbus.CAR_XP_CYT_ShuPing_YeMa_L /* 131372 */:
            case FinalCanbus.CAR_CYT_LangYi_L /* 131441 */:
            case FinalCanbus.CAR_CYT_GaoErFu7_H /* 196648 */:
            case FinalCanbus.CAR_CYT_Haval_H6_ShuPing /* 196739 */:
            case FinalCanbus.CAR_XP1_QiJun_CYT_ZIDONG /* 196751 */:
            case FinalCanbus.CAR_CYT_ShuPing_HavalH2_H /* 196852 */:
            case FinalCanbus.CAR_XP_CYT_ShuPing_YeMa_H /* 196908 */:
            case FinalCanbus.CAR_XFY_ZhongHuaV3 /* 196934 */:
            case FinalCanbus.CAR_CYT_LangYi_H /* 196977 */:
            case FinalCanbus.CAR_XP1_QiJun_CYT_ZIDONG_H /* 262287 */:
            case FinalCanbus.CAR_XFY_ZhongHuaV3_H /* 262470 */:
            case FinalCanbus.CAR_CYT_ShouDongKongTiao /* 262513 */:
            case FinalCanbus.CAR_XP1_QiJun_CYT_SHOUDONG /* 327823 */:
            case FinalCanbus.CAR_XP1_KeLeiAo_L /* 328054 */:
            case FinalCanbus.CAR_XP1_KeLeiAo_H /* 393590 */:
            case FinalCanbus.CAR_XP1_CYT_XuanYi_L /* 458895 */:
            case FinalCanbus.CAR_XP1_CYT_XuanYi_H /* 524431 */:
            case FinalCanbus.CAR_355_HC_XIANDAI /* 590179 */:
            case FinalCanbus.CAR_355_HC_XIANDAI_AMP /* 655715 */:
            case FinalCanbus.CAR_XP1_Meiganna4_TR_HAND /* 1245558 */:
            case FinalCanbus.CAR_XP1_Meiganna4_TR_AUTO /* 1311094 */:
            case FinalCanbus.CAR_XP1_Meiganna4_TR_AUTO_H /* 1769846 */:
            case FinalCanbus.CAR_XP1_RAM1500_H_AUTO /* 4194678 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                    break;
                }
            case 139:
                int ints0 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints02 = ints0 | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_AC_MAX ? 1 : 0);
                int ints1 = 0 | (data0 == ConstAllAirDara.C_AIR_SYNC ? 8 : 0);
                int ints12 = ints1 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints2 = 0 | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 1 : 0);
                int ints3 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints32 = ints3 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints4 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                int ints42 = ints4 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                int ints5 = 0 | (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT ? 1 : 0);
                int ints52 = ints5 | (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT ? 2 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints02, ints12, ints2, ints32, ints42, ints52}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                    break;
                }
            case 280:
                if (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT || data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT) {
                    DataCanbus.PROXY.cmd(0, new int[]{data0, data1 + 1}, null, null);
                    break;
                } else {
                    if (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST) {
                        data0--;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{data0, data1}, null, null);
                    break;
                }
            case 327:
            case 388:
            case FinalCanbus.CAR_XFY_CYT_NaZhiJieU6_ShuPin /* 65826 */:
            case FinalCanbus.CAR_HC_OLD_TianLai_H /* 65863 */:
            case FinalCanbus.CAR_XC_08TianLai_LOW /* 65924 */:
            case FinalCanbus.CAR_XFY_Haval_H6_ShuPing /* 131203 */:
            case FinalCanbus.CAR_HC_OLD_YinFeiNiDi_Fx35 /* 131399 */:
            case FinalCanbus.CAR_XP1_XFY_SHUPING_KELUZE /* 196628 */:
            case FinalCanbus.CAR_CYT_OuLande_L /* 196833 */:
            case FinalCanbus.CAR_452_XC_05_TianLai /* 196935 */:
            case FinalCanbus.CAR_XP1_XFY_SHUPING_COROLLA /* 262164 */:
            case FinalCanbus.CAR_CYT_OuLande_H /* 262369 */:
            case FinalCanbus.CAR_XC_OLD_YinFeiNiDi_Fx35 /* 262471 */:
            case FinalCanbus.CAR_BNR_BoYue /* 459017 */:
            case FinalCanbus.CAR_BNR_SR7 /* 524553 */:
            case FinalCanbus.CAR_XFY_CYT_NaZhiJieU6_ShuPin_H /* 524578 */:
            case FinalCanbus.CAR_XP1_XFY_SHUPING_Benpaozhe /* 2555924 */:
                if (data1 != 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                    break;
                }
            case 345:
            case FinalCanbus.CAR_WC2_ShuPingJW /* 65881 */:
            case FinalCanbus.CAR_WC2_ShuPingKeLuZi /* 131417 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao /* 196953 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS /* 262489 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS_S /* 328025 */:
            case FinalCanbus.CAR_WC2_ShuPing10JunYue /* 459097 */:
            case FinalCanbus.CAR_WC2_ShuPingKeLuZi_Auto /* 524633 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao_L /* 590169 */:
                DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data1, data0}, null, null);
                break;
            case 422:
            case FinalCanbus.CAR_RZC_17HaiMaS7 /* 65958 */:
            case FinalCanbus.CAR_OD_RZC_FuMeiLai /* 328102 */:
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
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            data1 = 1;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 0) {
                            data1 = 2;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 1) {
                            data1 = 2;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 1) {
                            data1 = 2;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 0) {
                            data1 = 1;
                        }
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                    data0 = ConstAllAirDara.C_AIR_WIND_ADD;
                } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                    data0 = ConstAllAirDara.C_AIR_TEMP_LEFT_ADD;
                } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                    data0 = ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD;
                }
                DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                break;
            case FinalCanbus.CAR_BNR_16ZiYouGuang /* 65653 */:
            case FinalCanbus.CAR_BNR_16ZiYouXia /* 131189 */:
            case FinalCanbus.CAR_BNR_17ZhiNanZhe /* 196725 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{1, data0}, null, null);
                    break;
                }
            case FinalCanbus.CAR_CYT_ShuPing_ChuanQiGS4 /* 65816 */:
            case FinalCanbus.CAR_CYT_SHuPing_SoNaTa8 /* 196776 */:
            case FinalCanbus.CAR_WC2_HavalH2_CYT_AIR /* 262276 */:
            case FinalCanbus.CAR_CYT_SHuPing_SoNaTa8_H /* 262312 */:
            case FinalCanbus.CAR_WC2_HavalH2_CYT_AIR_H /* 327812 */:
            case FinalCanbus.CAR_CYT_SHuPing_SoNaTa8_D /* 327848 */:
            case FinalCanbus.CAR_XP1_RAM1500 /* 655734 */:
            case FinalCanbus.CAR_439_XBS_NISSAN_TuLe /* 2425271 */:
            case FinalCanbus.CAR_439_XBS_NISSAN_TuLe_ALLV /* 3342775 */:
            case FinalCanbus.CAR_439_XFY_LAGAN /* 3670455 */:
            case FinalCanbus.CAR_XP1_RAM1500_M /* 4063606 */:
            case FinalCanbus.CAR_XP1_RAM1500_H /* 4129142 */:
            case FinalCanbus.CAR_439_XFY_Keleiao_17_L /* 13631927 */:
            case FinalCanbus.CAR_439_XFY_Keleiao_17_H /* 13697463 */:
            case FinalCanbus.CAR_439_XFY_Keleiao_18_L /* 13762999 */:
            case FinalCanbus.CAR_439_XFY_Keleiao_18_H /* 13828535 */:
            case FinalCanbus.CAR_452_CYT_Toyota_Tundra /* 13959620 */:
            case FinalCanbus.CAR_452_CYT_Toyota_Tundra_H /* 14025156 */:
            case FinalCanbus.CAR_452_Luz_Audi_A4L_Low /* 14811588 */:
            case FinalCanbus.CAR_452_Luz_Audi_A4L_H /* 14877124 */:
            case FinalCanbus.CAR_452_Luz_Audi_Q5_Low /* 14942660 */:
            case FinalCanbus.CAR_452_Luz_Audi_Q5_H /* 15008196 */:
            case FinalCanbus.CAR_452_Luz_Audi_A6L_Low /* 15073732 */:
            case FinalCanbus.CAR_452_Luz_Audi_A6L_H /* 15139268 */:
            case FinalCanbus.CAR_452_Luz_Audi_Q7_Low /* 15204804 */:
            case FinalCanbus.CAR_452_Luz_Audi_Q7_H /* 15270340 */:
            case FinalCanbus.CAR_452_LUZ_LANDROVER_CYTAIR /* 15729092 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0}, null, null);
                    break;
                }
            case FinalCanbus.CAR_SB_GM /* 65868 */:
                if (data0 == ConstAllAirDara.C_AIR_MODE_ADD) {
                    data1 = 241;
                } else if (data0 == ConstAllAirDara.C_AIR_MODE_SUB) {
                    data1 = 242;
                } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
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
                }
                DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                break;
            case FinalCanbus.CAR_OuDi_06Prado /* 196822 */:
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
                            data1 = 1;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            data1 = 2;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 2) {
                            data1 = 0;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 1) {
                            data1 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 1) {
                            data1 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_DUAL) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_DUAL] == 1) {
                            data1 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_DUAL] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_AUTO) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 1) {
                            data1 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 0) {
                            data1 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_CLEAN_AIR) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CLEANAIR] == 1) {
                            data1 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CLEANAIR] == 0) {
                            data1 = 1;
                        }
                    }
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                    break;
                }
            case FinalCanbus.CAR_RZC_XP1_RongWei_RX5 /* 262417 */:
            case FinalCanbus.CAR_RZC_19MingjueHS /* 852241 */:
            case FinalCanbus.CAR_RZC_19MingjueHS_H /* 1048849 */:
            case FinalCanbus.CAR_RZC_17Rongwei_EI6 /* 1573137 */:
                if (data0 == ConstAllAirDara.C_AIR_MODE_BODY || data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT || data0 == ConstAllAirDara.C_AIR_MODE_FOOT || data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT) {
                    if (data1 == 1) {
                        data1 = data0 & 15;
                        data0 = 16;
                    } else {
                        data0 = 16;
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                    if (data1 == 1) {
                        data0 = ConstAllAirDara.C_AIR_WIND_ADD;
                        data1 = 2;
                    } else {
                        data0 = ConstAllAirDara.C_AIR_WIND_ADD;
                        data1 = 0;
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                    if (data1 == 1) {
                        data0 = ConstAllAirDara.C_AIR_TEMP_LEFT_ADD;
                        data1 = 2;
                    } else {
                        data0 = ConstAllAirDara.C_AIR_TEMP_LEFT_ADD;
                        data1 = 0;
                    }
                }
                DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                break;
            case FinalCanbus.CAR_BNR_ChuanQiGS4 /* 327960 */:
            case FinalCanbus.CAR_BNR_ChuanQiGS4_H /* 393496 */:
                if (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT || data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT) {
                    DataCanbus.PROXY.cmd(0, new int[]{data0, data1 + 1}, null, null);
                    break;
                } else if (data1 == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{data0}, null, null);
                    break;
                }
            case FinalCanbus.CAR_455_RZC_Mclaren_12C /* 721351 */:
            case FinalCanbus.CAR_453_XP1_Ford_Edge_2013 /* 4260293 */:
            case FinalCanbus.CAR_453_XP1_Ford_F150_2013 /* 4325829 */:
            case FinalCanbus.CAR_453_XP1_Ford_Explorer_2013 /* 4391365 */:
            case FinalCanbus.CAR_453_XP1_Ford_Taurus_2013 /* 4456901 */:
            case FinalCanbus.CAR_453_XP1_Ford_Expedition_2013 /* 4522437 */:
            case FinalCanbus.CAR_453_XP1_Ford_Edge_2015 /* 4587973 */:
            case FinalCanbus.CAR_453_XP1_Ford_Mustang_2015 /* 4653509 */:
            case FinalCanbus.CAR_453_RZC_Mclaren_16_560S /* 4915653 */:
            case FinalCanbus.CAR_453_RZC_Mclaren_19_720S /* 4981189 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{172, data0}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{172}, null, null);
                    break;
                }
            case FinalCanbus.CAR_453_LZ_AstonMartin /* 1376709 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{11, data0}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{11}, null, null);
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
            case FinalCanbus.CAR_439_RZC_ZhongTaiSR9 /* 2294199 */:
            case FinalCanbus.CAR_439_RZC_ZhongTaiSR9_H /* 2359735 */:
            case FinalCanbus.CAR_439_RZC_ZhongTaiSR7 /* 7537079 */:
                int ints03 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints04 = ints03 | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0);
                if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                        ints04 = 8;
                    } else {
                        ints04 = 4;
                    }
                }
                int ints05 = ints04 | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_AC_MAX ? 1 : 0);
                int ints13 = 0 | (data0 == ConstAllAirDara.C_AIR_DUAL ? 8 : 0);
                int ints14 = ints13 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints22 = 0 | (data0 == ConstAllAirDara.C_AIR_MODE_UP ? 160 : 0);
                int ints23 = ints22 | (data0 == ConstAllAirDara.C_AIR_MODE_BODY ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_FOOT ? 96 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT ? 128 : 0);
                int ints33 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints34 = ints33 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints43 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                int ints44 = ints43 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                int ints53 = 0 | (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT ? 1 : 0);
                int ints54 = ints53 | (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT ? 2 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints05, ints14, ints23, ints34, ints44, ints54}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                    break;
                }
            case FinalCanbus.CAR_454_OD_Jianghuai_SEHOL_E50A /* 2490822 */:
            case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5 /* 2818501 */:
            case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5_H /* 2884037 */:
            case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5 /* 3015109 */:
            case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5_H /* 3080645 */:
                int ints15 = 0;
                int ints35 = 0;
                int ints45 = 0;
                int ints06 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints07 = ints06 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_AC_MAX ? 1 : 0);
                int ints24 = 0 | (data0 == ConstAllAirDara.C_AIR_MODE_BODY ? 1 : 0);
                int ints25 = ints24 | (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_FOOT ? 3 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UP ? 5 : 0);
                if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                    ints07 = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1 ? 8 : 4;
                } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] < 8) {
                        ints15 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] + 1;
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] > 0) {
                        ints15 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] - 1;
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD || data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                    ints35 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] == -2 ? 2 : DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] == -3 ? 16 : (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] < 18 || DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] > 31) ? 1 : DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] - 15;
                } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB || data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                    ints35 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] == -2 ? 1 : DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] == -3 ? 15 : (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] < 18 || DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] > 31) ? 1 : DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] - 17;
                } else if (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT && (ints45 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT] + 2) > 4) {
                    ints45 = 1;
                }
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints07, ints15, ints25, ints35, ints45, 0}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                    break;
                }
            case FinalCanbus.CAR_453_RZC_SWM_G05Pro_22 /* 5964229 */:
                int ints08 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints09 = ints08 | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0);
                int ints16 = 0 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0);
                int ints17 = ints16 | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints26 = 0 | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 1 : 0);
                int ints36 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints37 = ints36 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints46 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                int ints47 = ints46 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                int ints55 = 0 | (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT ? 1 : 0);
                int ints56 = ints55 | (data0 == ConstAllAirDara.C_AIR_LEFT_COLD ? 4 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints09, ints17, ints26, ints37, ints47, ints56}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                    break;
                }
            case FinalCanbus.CAR_439_RZC_YinFeiNiDi_QX50 /* 6029751 */:
                int ints010 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints011 = ints010 | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0);
                int ints18 = 0 | (data0 == ConstAllAirDara.C_AIR_DUAL ? 8 : 0);
                int ints19 = ints18 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints27 = 0 | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 1 : 0);
                int ints38 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints39 = ints38 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints48 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                int ints49 = ints48 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints011, ints19, ints27, ints39, ints49}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[5], null, null);
                    break;
                }
            case FinalCanbus.CAR_453_LZ_LandRover_13_CD /* 9175493 */:
            case FinalCanbus.CAR_453_LZ_LandRover_18_CD /* 9241029 */:
            case FinalCanbus.CAR_453_LZ_Jaguar_12_CD /* 9306565 */:
            case FinalCanbus.CAR_454_LZ_LandRover_CD_Discovery5 /* 13894086 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{8, data0}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{8}, null, null);
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
            case FinalCanbus.CAR_454_OD_Beiqi_EV160 /* 10879430 */:
                int ints012 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints013 = ints012 | (data0 == ConstAllAirDara.C_AIR_PTC ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 1 : 0);
                int ints110 = 0 | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0);
                int ints111 = ints110 | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints28 = 0 | (data0 == ConstAllAirDara.C_AIR_MODE_BODY ? 1 : 0);
                int ints29 = ints28 | (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_FOOT ? 3 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UP ? 5 : 0);
                int ints310 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints311 = ints310 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints410 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                int ints411 = ints410 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints013, ints111, ints29, ints311, ints411, 0}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                    break;
                }
            case FinalCanbus.CAR_452_LZ_Maserati_SP /* 12255684 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{14, data0}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{14}, null, null);
                    break;
                }
            case FinalCanbus.CAR_452_OD_Qirui_Xiaomayi /* 12517828 */:
                int ints014 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints015 = ints014 | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_PTC ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 1 : 0);
                int ints112 = 0 | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0);
                int ints113 = ints112 | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints312 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints313 = ints312 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints412 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                int ints413 = ints412 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints015, ints113, 0, ints313, ints413, 0}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                    break;
                }
            case FinalCanbus.CAR_453_OD_Beiqi_Changhe_Q7_SP /* 15925701 */:
                int ints016 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints017 = ints016 | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0);
                int ints114 = 0 | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 8 : 0);
                int ints115 = ints114 | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0) | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                int ints210 = 0 | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 1 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints017, ints115, ints210, 0, 0}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[5], null, null);
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
            case 20:
            case FinalCanbus.CAR_XP1_Camry2013_H /* 131092 */:
            case FinalCanbus.CAR_XP1_TOYOTA_12Camry_SP /* 2686996 */:
            case FinalCanbus.CAR_XP1_TOYOTA_16CRUISER_SP /* 2752532 */:
            case FinalCanbus.CAR_XP1_TOYOTA_15Camry_SP /* 2818068 */:
            case FinalCanbus.CAR_XP1_TOYOTA_18Camry_SP /* 2883604 */:
            case FinalCanbus.CAR_XP1_TOYOTA_15Highlander_Hand_SP /* 2949140 */:
            case FinalCanbus.CAR_XP1_TOYOTA_15Highlander_AUTO_SP /* 3014676 */:
            case FinalCanbus.CAR_XP1_TOYOTA_14Tundra_Hand_SP /* 3080212 */:
            case FinalCanbus.CAR_XP1_TOYOTA_14Tundra_AUTO_SP /* 3145748 */:
            case FinalCanbus.CAR_XP1_TOYOTA_10Prado_SP /* 3211284 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                if (DataCanbus.DATA[1000] == 3014676) {
                    ConstAllAirDara.U_AIR_REAR_CTRL = 67;
                    ConstAllAirDara.C_REAR_CTRL = 42;
                    ConstAllAirDara.U_AIR_SEATWIND_LEFT = 255;
                    ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 255;
                    ConstAllAirDara.C_AIR_LEFT_COLD = 255;
                    ConstAllAirDara.C_AIR_RIGHT_COLD = 255;
                    ConstAllAirDara.C_AIR_DUAL = 16;
                    ConstAllAirDara.C_AIR_AUTO = 21;
                } else if (DataCanbus.DATA[1000] == 2949140) {
                    ConstAllAirDara.U_AIR_REAR_CTRL = 67;
                    ConstAllAirDara.C_REAR_CTRL = 42;
                    ConstAllAirDara.U_AIR_AUTO = 255;
                    ConstAllAirDara.U_AIR_DUAL = 255;
                    ConstAllAirDara.U_AIR_SEATWIND_LEFT = 255;
                    ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 255;
                    ConstAllAirDara.C_AIR_LEFT_COLD = 255;
                    ConstAllAirDara.C_AIR_RIGHT_COLD = 255;
                    ConstAllAirDara.C_AIR_DUAL = 255;
                    ConstAllAirDara.C_AIR_AUTO = 255;
                } else if (DataCanbus.DATA[1000] == 3211284) {
                    ConstAllAirDara.U_AIR_CLEANAIR = 33;
                    ConstAllAirDara.C_CLEAN_AIR = 32;
                    ConstAllAirDara.U_AIR_REAR_CTRL = 67;
                    ConstAllAirDara.C_REAR_CTRL = 42;
                    ConstAllAirDara.U_AIR_SEATWIND_LEFT = 255;
                    ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 255;
                    ConstAllAirDara.C_AIR_LEFT_COLD = 255;
                    ConstAllAirDara.C_AIR_RIGHT_COLD = 255;
                } else {
                    ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                    ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                    ConstAllAirDara.C_AIR_LEFT_COLD = 12;
                    ConstAllAirDara.C_AIR_RIGHT_COLD = 14;
                    ConstAllAirDara.C_AIR_DUAL = 16;
                    ConstAllAirDara.C_AIR_AUTO = 21;
                    ConstAllAirDara.U_AIR_REAR_CTRL = 255;
                }
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
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_CONTRAL = 25;
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
            case FinalCanbus.CAR_CYT_GaoErFu7 /* 65576 */:
            case FinalCanbus.CAR_CYT_GaoErFu7_M /* 131112 */:
            case FinalCanbus.CAR_CYT_GaoErFu7_H /* 196648 */:
                ConstAllAirDara.TEMPERATURE_NONE = 0;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                if (DataCanbus.DATA[1000] == 131112) {
                    ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                    ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                    ConstAllAirDara.C_AIR_LEFT_HEAT = 13;
                    ConstAllAirDara.C_AIR_RIGHT_HEAT = 14;
                } else if (DataCanbus.DATA[1000] == 196648 || DataCanbus.DATA[1000] == 40) {
                    ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                    ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                    ConstAllAirDara.U_AIR_AUTO = 13;
                    ConstAllAirDara.U_AIR_DUAL = 14;
                    ConstAllAirDara.C_AIR_DUAL = 8;
                    ConstAllAirDara.C_AIR_AUTO = 2;
                    ConstAllAirDara.C_AIR_LEFT_HEAT = 13;
                    ConstAllAirDara.C_AIR_RIGHT_HEAT = 14;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_MODE_UP = 3;
                ConstAllAirDara.C_AIR_MODE_BODY = 29;
                ConstAllAirDara.C_AIR_MODE_FOOT = 31;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_CYT_GaoErFu7 /* 65576 */:
                    case FinalCanbus.CAR_CYT_GaoErFu7_M /* 131112 */:
                    case FinalCanbus.CAR_CYT_GaoErFu7_H /* 196648 */:
                        ConstAllAirDara.C_CONTRAL = 102;
                        break;
                    default:
                        ConstAllAirDara.C_CONTRAL = 17;
                        break;
                }
            case 80:
            case FinalCanbus.CAR_RZC_XP1_QiJun_H /* 131152 */:
            case FinalCanbus.CAR_XP1_QiJun_CYT_ZIDONG /* 196751 */:
            case FinalCanbus.CAR_XP1_QiJun_CYT_ZIDONG_H /* 262287 */:
            case FinalCanbus.CAR_XP1_QiJun_CYT_SHOUDONG /* 327823 */:
            case FinalCanbus.CAR_XP1_CYT_XuanYi_L /* 458895 */:
            case FinalCanbus.CAR_XP1_CYT_XuanYi_H /* 524431 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 38;
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_XP1_QiJun_H /* 131152 */:
                    case FinalCanbus.CAR_XP1_QiJun_CYT_ZIDONG /* 196751 */:
                    case FinalCanbus.CAR_XP1_QiJun_CYT_ZIDONG_H /* 262287 */:
                    case FinalCanbus.CAR_XP1_CYT_XuanYi_H /* 524431 */:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_DUAL = 14;
                        ConstAllAirDara.C_AIR_AUTO = 2;
                        ConstAllAirDara.C_AIR_DUAL = 8;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                        break;
                    default:
                        ConstAllAirDara.C_AIR_MODE_BODY = 29;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 31;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 30;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 32;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                switch (DataCanbus.DATA[1000]) {
                    case 80:
                    case FinalCanbus.CAR_RZC_XP1_QiJun_H /* 131152 */:
                        ConstAllAirDara.C_CONTRAL = 1;
                        break;
                    default:
                        ConstAllAirDara.C_CONTRAL = 0;
                        break;
                }
            case 139:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 4;
                ConstAllAirDara.C_AIR_CYCLE = 5;
                ConstAllAirDara.C_AIR_AC = 6;
                ConstAllAirDara.C_AIR_AC_MAX = 7;
                ConstAllAirDara.C_AIR_SYNC = 8;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 9;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 11;
                ConstAllAirDara.C_AIR_WIND_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 16;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case 151:
            case FinalCanbus.CAR_RCW_BYD_6 /* 524439 */:
            case FinalCanbus.CAR_RCW_BYD_12_18Surui /* 589975 */:
                ConstAllAirDara.TEMPERATURE_NONE = 0;
                ConstAllAirDara.TEMPERATURE_LOW = 10;
                ConstAllAirDara.TEMPERATURE_HIGHT = 630;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                ConstAllAirDara.C_AIR_POWER = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 4;
                ConstAllAirDara.C_AIR_DUAL = 2;
                ConstAllAirDara.C_AIR_AUTO = 1;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_AC = 8;
                ConstAllAirDara.C_AIR_AC_MAX = 11;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case 231:
            case FinalCanbus.CAR_DJ_MENGDIOU2013_H /* 65767 */:
                ConstAllAirDara.TEMPERATURE_LOW = 1;
                ConstAllAirDara.TEMPERATURE_HIGHT = 65;
                ConstAllAirDara.TEMPERATURE_NONE = 0;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 65;
                if (DataCanbus.DATA[1000] == 65767) {
                    ConstAllAirDara.U_AIR_DUAL = 14;
                    ConstAllAirDara.U_AIR_AUTO = 13;
                    ConstAllAirDara.C_AIR_DUAL = 2;
                    ConstAllAirDara.C_AIR_AUTO = 1;
                }
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 35;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_POWER = 10;
                ConstAllAirDara.C_AIR_AC = 8;
                ConstAllAirDara.C_AIR_AC_MAX = 11;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                ConstAllAirDara.C_AIR_MODE_UP = 4;
                ConstAllAirDara.C_AIR_MODE_BODY = 33;
                ConstAllAirDara.C_AIR_MODE_FOOT = 34;
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
            case 280:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 65;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 22;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 23;
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 6;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 24;
                ConstAllAirDara.C_AIR_CYCLE = 21;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case 317:
            case FinalCanbus.CAR_WeiChi2_XTS /* 65853 */:
            case FinalCanbus.CAR_WeiChi2_XTS_SEATHEAT /* 131389 */:
            case FinalCanbus.CAR_WeiChi2_ATS_H /* 196925 */:
            case FinalCanbus.CAR_WeiChi2_SRX /* 262461 */:
            case FinalCanbus.CAR_WeiChi2_15SRX /* 327997 */:
            case FinalCanbus.CAR_WeiChi2_18XTS /* 393533 */:
            case FinalCanbus.CAR_WeiChi2_18ATS /* 459069 */:
            case FinalCanbus.CAR_WeiChi2_NewJunYue /* 524605 */:
                ConstAllAirDara.TEMPERATURE_NONE = 0;
                ConstAllAirDara.TEMPERATURE_LOW = 254;
                ConstAllAirDara.TEMPERATURE_HIGHT = 255;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AUTO = 49;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                if (DataCanbus.DATA[1000] == 131389 || DataCanbus.DATA[1000] == 262461 || DataCanbus.DATA[1000] == 327997 || DataCanbus.DATA[1000] == 524605) {
                    ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                    ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                    ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                    ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                    ConstAllAirDara.C_AIR_LEFT_HEAT = 19;
                    ConstAllAirDara.C_AIR_RIGHT_HEAT = 20;
                    ConstAllAirDara.C_AIR_LEFT_COLD = 23;
                    ConstAllAirDara.C_AIR_RIGHT_HEAT = 24;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_SYNC = 3;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_MODE_ADD = 17;
                ConstAllAirDara.C_AIR_MODE_SUB = 18;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case 327:
            case FinalCanbus.CAR_HC_OLD_TianLai_H /* 65863 */:
            case FinalCanbus.CAR_HC_OLD_YinFeiNiDi_Fx35 /* 131399 */:
            case FinalCanbus.CAR_452_XC_05_TianLai /* 196935 */:
            case FinalCanbus.CAR_XC_OLD_YinFeiNiDi_Fx35 /* 262471 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 96;
                ConstAllAirDara.C_AIR_DUAL = 82;
                ConstAllAirDara.C_AIR_AUTO = 83;
                ConstAllAirDara.C_AIR_AC = 84;
                ConstAllAirDara.C_AIR_CYCLE = 85;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 89;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 86;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 80;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 81;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 90;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 91;
                ConstAllAirDara.C_AIR_WIND_ADD = 87;
                ConstAllAirDara.C_AIR_WIND_SUB = 88;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case 345:
            case FinalCanbus.CAR_WC2_ShuPingJW /* 65881 */:
            case FinalCanbus.CAR_WC2_ShuPingKeLuZi /* 131417 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao /* 196953 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS /* 262489 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS_S /* 328025 */:
            case FinalCanbus.CAR_WC2_ShuPingKeLuZi_Auto /* 524633 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao_L /* 590169 */:
                ConstAllAirDara.TEMPERATURE_NONE = 0;
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
                ConstAllAirDara.C_AIR_MODE_BODY = 26;
                ConstAllAirDara.C_AIR_MODE_FOOT = 29;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_WC2_ShuPingKeLuZi /* 131417 */:
                        ConstAllAirDara.C_AIR_MODE_BODY = 9;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                        break;
                    case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao /* 196953 */:
                        ConstAllAirDara.U_AIR_AUTO = 49;
                        ConstAllAirDara.U_AIR_SYNC = 62;
                        ConstAllAirDara.C_AIR_AUTO = 4;
                        ConstAllAirDara.C_AIR_SYNC = 3;
                        ConstAllAirDara.C_AIR_MODE_BODY = 9;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                        break;
                    case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS /* 262489 */:
                        ConstAllAirDara.U_AIR_AUTO = 49;
                        ConstAllAirDara.U_AIR_SYNC = 62;
                        ConstAllAirDara.C_AIR_AUTO = 4;
                        ConstAllAirDara.C_AIR_SYNC = 3;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                        ConstAllAirDara.C_AIR_MODE_BODY = 9;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                        break;
                    case FinalCanbus.CAR_WC2_ShuPingKeLuZi_Auto /* 524633 */:
                        ConstAllAirDara.U_AIR_AUTO = 49;
                        ConstAllAirDara.C_AIR_AUTO = 4;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                        ConstAllAirDara.C_AIR_MODE_BODY = 9;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                        break;
                    case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao_L /* 590169 */:
                        ConstAllAirDara.U_AIR_AUTO = 49;
                        ConstAllAirDara.U_AIR_SYNC = 255;
                        ConstAllAirDara.C_AIR_AUTO = 4;
                        ConstAllAirDara.C_AIR_SYNC = 255;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                        ConstAllAirDara.C_AIR_MODE_BODY = 9;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                        break;
                }
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
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 27;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 28;
                ConstAllAirDara.C_CONTRAL = 14;
                break;
            case 363:
            case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ShuPingNewJunWei_M /* 65899 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
            case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng /* 655708 */:
            case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng1 /* 721244 */:
            case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng2 /* 786780 */:
            case FinalCanbus.CAR_DAOJUN_OD_ATS /* 852316 */:
            case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
            case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
            case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
            case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONTMAX = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_DUAL = 14;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_DAOJUN_OD_ATS /* 852316 */:
                    case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        break;
                    default:
                        ConstAllAirDara.U_AIR_AUTO = 54;
                        ConstAllAirDara.U_AIR_POWER = 10;
                        break;
                }
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_AIR_MODE_ADD = 16;
                ConstAllAirDara.C_AIR_MODE_SUB = 17;
                switch (DataCanbus.DATA[1000]) {
                    case 363:
                    case FinalCanbus.CAR_DAOJUN_XP1_ShuPingNewJunWei_M /* 65899 */:
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 36;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 37;
                        ConstAllAirDara.C_AIR_MODE_UP = 33;
                        ConstAllAirDara.C_AIR_MODE_BODY = 34;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 35;
                        ConstAllAirDara.C_AIR_MODE_ADD = 255;
                        ConstAllAirDara.C_AIR_MODE_SUB = 255;
                        break;
                    case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
                    case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
                    case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng /* 655708 */:
                    case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng1 /* 721244 */:
                    case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng2 /* 786780 */:
                    case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
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
                }
                ConstAllAirDara.C_AIR_AUTO = 1;
                ConstAllAirDara.C_AIR_DUAL = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 4;
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
            case 369:
            case FinalCanbus.CAR_CYT_DaZhongZiDongKongTiao_H /* 65905 */:
            case FinalCanbus.CAR_CYT_LangYi_L /* 131441 */:
            case FinalCanbus.CAR_CYT_LangYi_H /* 196977 */:
            case FinalCanbus.CAR_CYT_ShouDongKongTiao /* 262513 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 38;
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_MODE_UP = 3;
                ConstAllAirDara.C_AIR_MODE_BODY = 29;
                ConstAllAirDara.C_AIR_MODE_FOOT = 31;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_AC_MAX = 39;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 13;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 14;
                switch (DataCanbus.DATA[1000]) {
                    case 369:
                        ConstAllAirDara.C_AIR_AUTO = 2;
                        ConstAllAirDara.C_AIR_DUAL = 8;
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_DUAL = 14;
                        break;
                    case FinalCanbus.CAR_CYT_DaZhongZiDongKongTiao_H /* 65905 */:
                        ConstAllAirDara.C_REAR_CTRL = 37;
                        ConstAllAirDara.C_AIR_AUTO = 2;
                        ConstAllAirDara.C_AIR_DUAL = 8;
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_DUAL = 14;
                        ConstAllAirDara.U_AIR_REAR_CTRL = 67;
                        break;
                    case FinalCanbus.CAR_CYT_LangYi_L /* 131441 */:
                        ConstAllAirDara.C_AIR_AUTO = 2;
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.C_AIR_DUAL = 255;
                        ConstAllAirDara.U_AIR_DUAL = 255;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 255;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 255;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 255;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 255;
                        ConstAllAirDara.C_AIR_AC_MAX = 255;
                        ConstAllAirDara.U_AIR_AC_MAX = 255;
                        break;
                    case FinalCanbus.CAR_CYT_LangYi_H /* 196977 */:
                        ConstAllAirDara.C_AIR_AUTO = 2;
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.C_AIR_DUAL = 255;
                        ConstAllAirDara.U_AIR_DUAL = 255;
                        ConstAllAirDara.C_AIR_AC_MAX = 255;
                        ConstAllAirDara.U_AIR_AC_MAX = 255;
                        break;
                }
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case 372:
            case FinalCanbus.CAR_WC1_Jeep_ZiYouGuang_M /* 65908 */:
            case FinalCanbus.CAR_WC1_Jeep_ZiYouGuang_H /* 131444 */:
            case FinalCanbus.CAR_WC1_Jeep_17ZhiNanZhe /* 262516 */:
            case FinalCanbus.CAR_WC1_Jeep_17ZhiNanZhe_H /* 328052 */:
            case FinalCanbus.CAR_WC1_TMK_BENZ_MPV_ALL /* 1114484 */:
                ConstAllAirDara.TEMPERATURE_NONE = 0;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AUTO = 13;
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
                ConstAllAirDara.C_AIR_AC_MAX = 21;
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
                ConstAllAirDara.C_AIR_MODE_UP = 8;
                ConstAllAirDara.C_AIR_MODE_BODY = 9;
                ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 24;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 23;
                ConstAllAirDara.C_AIR_LEFT_COLD = 19;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 20;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case 388:
            case FinalCanbus.CAR_XC_08TianLai_LOW /* 65924 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 95;
                ConstAllAirDara.C_AIR_DUAL = 82;
                ConstAllAirDara.C_AIR_AUTO = 83;
                ConstAllAirDara.C_AIR_AC = 84;
                ConstAllAirDara.C_AIR_CYCLE = 85;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 86;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 89;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 80;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 81;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 90;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 91;
                ConstAllAirDara.C_AIR_WIND_ADD = 87;
                ConstAllAirDara.C_AIR_WIND_SUB = 88;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case 392:
            case FinalCanbus.CAR_CYT_SHUPING_CAMARY_15 /* 65928 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
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
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_AC_MAX = 39;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 13;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 14;
                ConstAllAirDara.C_CONTRAL = 22;
                break;
            case 406:
            case FinalCanbus.CAR_XFY_XP1_ChangAnCsSerial /* 65942 */:
            case FinalCanbus.CAR_XFY_XP1_ZhongTaiSR7_H /* 131478 */:
                ConstAllAirDara.TEMPERATURE_NONE = 0;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                if (DataCanbus.DATA[1000] == 131478 || DataCanbus.DATA[1000] == 406) {
                    ConstAllAirDara.TEMPERATURE_LOW = 1;
                    ConstAllAirDara.TEMPERATURE_HIGHT = 14;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 9;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 10;
                } else {
                    ConstAllAirDara.U_AIR_AUTO = 13;
                    ConstAllAirDara.U_AIR_SYNC = 62;
                    ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                    ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                    ConstAllAirDara.U_AIR_AC_MAX = 53;
                    ConstAllAirDara.C_AIR_AUTO = 2;
                    ConstAllAirDara.C_AIR_SYNC = 8;
                    ConstAllAirDara.C_AIR_AC_MAX = 15;
                    ConstAllAirDara.C_AIR_LEFT_HEAT = 13;
                    ConstAllAirDara.C_AIR_RIGHT_HEAT = 14;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                    ConstAllAirDara.TEMPERATURE_LOW = 16;
                    ConstAllAirDara.TEMPERATURE_HIGHT = 80;
                }
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case 407:
            case FinalCanbus.CAR_DaoJun_XINPU_ChuanQiGs4_H /* 65943 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONTMAX = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 65;
                if (DataCanbus.DATA[1000] == 65943) {
                    ConstAllAirDara.U_AIR_AUTO = 13;
                    ConstAllAirDara.C_AIR_AUTO = 1;
                }
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_POWER = 10;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 4;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_AC = 8;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 9;
                ConstAllAirDara.C_CONTRAL = 1;
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
            case 414:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONTMAX = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case 416:
            case FinalCanbus.CAR_WC2_RongWei_I5 /* 131488 */:
            case FinalCanbus.CAR_WC2_RongWei_I6 /* 197024 */:
            case FinalCanbus.CAR_WC2_RongWei_EI6 /* 262560 */:
            case FinalCanbus.CAR_WC2_RongWei_RX3 /* 328096 */:
            case FinalCanbus.CAR_WC2_RongWei_I5_H /* 459168 */:
            case FinalCanbus.CAR_WC2_RongWei_I6_17_low /* 655776 */:
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
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_AUTO = 13;
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
                ConstAllAirDara.C_AIR_MODE_BODY = 9;
                ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 27;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 28;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                break;
            case 422:
            case FinalCanbus.CAR_RZC_17HaiMaS7 /* 65958 */:
            case FinalCanbus.CAR_OD_RZC_FuMeiLai /* 328102 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                if (DataCanbus.DATA[1000] == 328102) {
                    ConstAllAirDara.U_AIR_TEMP_LEFT = 28;
                } else {
                    ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                }
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_CONTRAL = 0;
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_WIND_ADD = 1;
                ConstAllAirDara.C_AIR_WIND_SUB = 17;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 18;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 18;
                ConstAllAirDara.C_AIR_AC = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 7;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_CYCLE = 5;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 3;
                break;
            case 433:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case 437:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 38;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
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
                ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 12;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_AC_MAX = 24;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_MODE_UP = 55;
                ConstAllAirDara.C_AIR_MODE_BODY = 56;
                ConstAllAirDara.C_AIR_MODE_FOOT = 57;
                ConstAllAirDara.C_CONTRAL = 107;
                break;
            case 438:
            case FinalCanbus.CAR_438_BNR_DaZhong_H /* 65974 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 38;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                if (DataCanbus.DATA[1000] == 65974) {
                    ConstAllAirDara.U_AIR_AUTO = 13;
                    ConstAllAirDara.U_AIR_DUAL = 14;
                    ConstAllAirDara.C_AIR_DUAL = 16;
                    ConstAllAirDara.C_AIR_AUTO = 21;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 12;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_AC_MAX = 24;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_MODE_UP = 55;
                ConstAllAirDara.C_AIR_MODE_BODY = 56;
                ConstAllAirDara.C_AIR_MODE_FOOT = 57;
                ConstAllAirDara.C_CONTRAL = 107;
                break;
            case 443:
            case FinalCanbus.CAR_443_WC2_OULANDE_H /* 7012795 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
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
                ConstAllAirDara.C_AIR_MODE_CHANGER = 21;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_BNR_16ZiYouGuang /* 65653 */:
            case FinalCanbus.CAR_BNR_16ZiYouXia /* 131189 */:
            case FinalCanbus.CAR_BNR_17ZhiNanZhe /* 196725 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 16;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 20;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 21;
                ConstAllAirDara.C_AIR_MODE_BODY = 8;
                ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 9;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 11;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 12;
                ConstAllAirDara.C_AIR_SYNC = 13;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 14;
                ConstAllAirDara.C_AIR_AC_MAX = 15;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_WC2_CHANGANCX7 /* 65664 */:
            case FinalCanbus.CAR_WC2_CHANGAN_19KeSai /* 262272 */:
            case FinalCanbus.CAR_WC2_CHANGAN_19KeSai_Hand /* 327808 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                if (DataCanbus.DATA[1000] == 262272) {
                    ConstAllAirDara.U_AIR_AUTO = 13;
                    ConstAllAirDara.U_AIR_REAR_CTRL = 38;
                    ConstAllAirDara.C_AIR_AUTO = 4;
                    ConstAllAirDara.C_REAR_CTRL = 46;
                }
                ConstAllAirDara.C_CONTRAL = 0;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                if (DataCanbus.DATA[1000] == 65664) {
                    ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 15;
                    ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 16;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                } else {
                    ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                    ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 13;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 14;
                }
                ConstAllAirDara.C_AIR_MODE_CHANGER = 21;
                break;
            case FinalCanbus.CAR_WC1_CYT_ShuPing_07_11_MENGDIOU /* 65759 */:
            case FinalCanbus.CAR_WC1_ShuPing_ZhiSheng_High /* 131295 */:
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_WC1_CYT_ShuPing_07_11_MENGDIOU /* 65759 */:
                        ConstAllAirDara.C_AIR_POWER = 1;
                        ConstAllAirDara.C_AIR_AUTO = 2;
                        ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                        ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                        ConstAllAirDara.C_AIR_DUAL = 8;
                        ConstAllAirDara.C_AIR_CYCLE = 35;
                        ConstAllAirDara.C_AIR_AC = 16;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                        ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                        ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                        ConstAllAirDara.C_AIR_WIND_ADD = 20;
                        ConstAllAirDara.C_AIR_WIND_SUB = 21;
                        break;
                    default:
                        ConstAllAirDara.C_AIR_AUTO = 13;
                        ConstAllAirDara.C_AIR_FRONT_DEFROST = 1;
                        ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 2;
                        ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 3;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                        ConstAllAirDara.C_AIR_CYCLE = 6;
                        ConstAllAirDara.C_AIR_POWER = 7;
                        ConstAllAirDara.C_AIR_MODE_UP = 10;
                        ConstAllAirDara.C_AIR_MODE_BODY = 9;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                        ConstAllAirDara.C_AIR_DUAL = 15;
                        ConstAllAirDara.C_AIR_AC = 14;
                        ConstAllAirDara.C_AIR_WIND_ADD = 4;
                        ConstAllAirDara.C_AIR_WIND_SUB = 5;
                        break;
                }
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_CONTRAL = 50;
                break;
            case FinalCanbus.CAR_CYT_ShuPing_ChuanQiGS4 /* 65816 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 65;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 13;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 14;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_CONTRAL = 32;
                break;
            case FinalCanbus.CAR_XFY_CYT_NaZhiJieU6_ShuPin /* 65826 */:
            case FinalCanbus.CAR_XFY_CYT_NaZhiJieU6_ShuPin_H /* 524578 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 18;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_CONTRAL = 16;
                break;
            case FinalCanbus.CAR_DJ_ShuPing_MENGDIOU /* 65836 */:
            case FinalCanbus.CAR_DJ_Shuping_YEMA /* 262444 */:
                ConstAllAirDara.TEMPERATURE_LOW = 0;
                ConstAllAirDara.TEMPERATURE_HIGHT = 127;
                ConstAllAirDara.TEMPERATURE_NONE = -1;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                if (DataCanbus.DATA[1000] == 65836) {
                    ConstAllAirDara.U_AIR_DUAL = 14;
                    ConstAllAirDara.U_AIR_AUTO = 13;
                    ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                    ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                    ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                    ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                    ConstAllAirDara.C_AIR_AUTO = 1;
                    ConstAllAirDara.C_AIR_DUAL = 2;
                    ConstAllAirDara.C_AIR_LEFT_HEAT = 36;
                    ConstAllAirDara.C_AIR_RIGHT_HEAT = 37;
                    ConstAllAirDara.C_AIR_LEFT_COLD = 38;
                    ConstAllAirDara.C_AIR_RIGHT_COLD = 39;
                }
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 4;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_AC = 8;
                ConstAllAirDara.C_AIR_POWER = 10;
                ConstAllAirDara.C_AIR_AC_MAX = 11;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                ConstAllAirDara.C_AIR_MODE_UP = 33;
                ConstAllAirDara.C_AIR_MODE_BODY = 34;
                ConstAllAirDara.C_AIR_MODE_FOOT = 35;
                ConstAllAirDara.C_CONTRAL = 4;
                break;
            case FinalCanbus.CAR_SB_GM /* 65868 */:
                ConstAllAirDara.TEMPERATURE_LOW = 0;
                ConstAllAirDara.TEMPERATURE_HIGHT = 63;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SYNC = 62;
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
                ConstAllAirDara.C_AIR_POWER = 8;
                ConstAllAirDara.C_AIR_CYCLE = 1;
                ConstAllAirDara.C_AIR_AC = 3;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_SYNC = 11;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 9;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 10;
                ConstAllAirDara.C_AIR_MODE_ADD = 6;
                ConstAllAirDara.C_AIR_MODE_SUB = 38;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 34;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 39;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 7;
                ConstAllAirDara.C_AIR_WIND_SUB = 37;
                ConstAllAirDara.C_AIR_WIND_ADD = 5;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 12;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                ConstAllAirDara.C_AIR_LEFT_COLD = 14;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 15;
                ConstAllAirDara.C_CONTRAL = 9;
                break;
            case FinalCanbus.CAR_BSD_XP1_SHUPING_RENAULT_KeLeiAo /* 65938 */:
            case FinalCanbus.CAR_BSD_XP1_SHUPING_RENAULT_KeLeiAo_H /* 131474 */:
                ConstAllAirDara.TEMPERATURE_NONE = 0;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AQS = 54;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 9;
                ConstAllAirDara.C_AIR_AC = 17;
                ConstAllAirDara.C_AIR_CYCLE = 19;
                ConstAllAirDara.C_AIR_AUTO = 20;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 21;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 22;
                ConstAllAirDara.C_AIR_DUAL = 23;
                ConstAllAirDara.C_AIR_AQS = 67;
                ConstAllAirDara.C_AIR_WIND_SUB = 28;
                ConstAllAirDara.C_AIR_WIND_ADD = 29;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 30;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 31;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 32;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 33;
                ConstAllAirDara.C_AIR_MODE_UP = 27;
                ConstAllAirDara.C_AIR_MODE_BODY = 24;
                ConstAllAirDara.C_AIR_MODE_FOOT = 26;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_XFY_Haval_H6_ShuPing /* 131203 */:
            case FinalCanbus.CAR_CYT_Haval_H6_ShuPing /* 196739 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONTMAX = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                if (DataCanbus.DATA[1000] == 196739) {
                    ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 3;
                } else {
                    ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 38;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_CONTRAL = 3;
                break;
            case FinalCanbus.CAR_CYT_ShuPing_HavalH2 /* 131316 */:
            case FinalCanbus.CAR_CYT_ShuPing_HavalH2_H /* 196852 */:
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
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_AC = 16;
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
            case FinalCanbus.CAR_XP_CYT_ShuPing_YeMa_L /* 131372 */:
            case FinalCanbus.CAR_XP_CYT_ShuPing_YeMa_H /* 196908 */:
                ConstAllAirDara.TEMPERATURE_LOW = 16;
                ConstAllAirDara.TEMPERATURE_HIGHT = 80;
                ConstAllAirDara.TEMPERATURE_NONE = 0;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_AC_MAX = 39;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_MODE_UP = 3;
                ConstAllAirDara.C_AIR_MODE_BODY = 29;
                ConstAllAirDara.C_AIR_MODE_FOOT = 31;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 13;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 14;
                ConstAllAirDara.C_AIR_LEFT_COLD = 45;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 46;
                ConstAllAirDara.C_CONTRAL = 5;
                break;
            case FinalCanbus.CAR_452_BaoGu_Renault_17Koleos /* 131524 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_18Koleos /* 197060 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_17Koleos_M /* 2818500 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_17Koleos_H /* 2884036 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_18Koleos_M /* 3015108 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_18Koleos_H /* 3080644 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_SOFT = 75;
                ConstAllAirDara.U_AIR_FAST = 75;
                ConstAllAirDara.U_AIR_AQS = 36;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.C_AIR_POWER = 9;
                ConstAllAirDara.C_AIR_AUTO = 20;
                ConstAllAirDara.C_AIR_MODE_UP = 27;
                ConstAllAirDara.C_AIR_MODE_BODY = 24;
                ConstAllAirDara.C_AIR_MODE_FOOT = 26;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 22;
                ConstAllAirDara.C_AIR_DUAL = 23;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 21;
                ConstAllAirDara.C_AIR_AC = 17;
                ConstAllAirDara.C_AIR_CYCLE = 19;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 31;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 30;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 33;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 32;
                ConstAllAirDara.C_AIR_WIND_ADD = 29;
                ConstAllAirDara.C_AIR_WIND_SUB = 28;
                ConstAllAirDara.C_SOFT = 67;
                ConstAllAirDara.C_FAST = 66;
                ConstAllAirDara.C_AIR_AQS = 64;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_XP1_XFY_SHUPING_KELUZE /* 196628 */:
            case FinalCanbus.CAR_XP1_XFY_SHUPING_COROLLA /* 262164 */:
            case FinalCanbus.CAR_XP1_XFY_SHUPING_Benpaozhe /* 2555924 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_CONTRAL = 22;
                break;
            case FinalCanbus.CAR_CYT_SHuPing_SoNaTa8 /* 196776 */:
            case FinalCanbus.CAR_CYT_SHuPing_SoNaTa8_H /* 262312 */:
            case FinalCanbus.CAR_CYT_SHuPing_SoNaTa8_D /* 327848 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONTMAX = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 65;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_MODE_UP = 3;
                ConstAllAirDara.C_AIR_MODE_BODY = 29;
                ConstAllAirDara.C_AIR_MODE_FOOT = 31;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_CONTRAL = 32;
                break;
            case FinalCanbus.CAR_OuDi_06Prado /* 196822 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_CLEANAIR = 76;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_CONTRAL = 30;
                ConstAllAirDara.C_AIR_POWER = 168;
                ConstAllAirDara.C_AIR_WIND_ADD = 160;
                ConstAllAirDara.C_AIR_WIND_SUB = 176;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 161;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 177;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 162;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 178;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 163;
                ConstAllAirDara.C_AIR_AC = 164;
                ConstAllAirDara.C_AIR_CYCLE = 165;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 166;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 167;
                ConstAllAirDara.C_AIR_AUTO = 171;
                ConstAllAirDara.C_AIR_DUAL = 169;
                ConstAllAirDara.C_CLEAN_AIR = 170;
                break;
            case FinalCanbus.CAR_CYT_OuLande_L /* 196833 */:
            case FinalCanbus.CAR_CYT_OuLande_H /* 262369 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 18;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_CYT_OuLande_H /* 262369 */:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_DUAL = 14;
                        ConstAllAirDara.C_AIR_DUAL = 8;
                        ConstAllAirDara.C_AIR_AUTO = 2;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_XFY_ZhongHuaV3 /* 196934 */:
            case FinalCanbus.CAR_XFY_ZhongHuaV3_H /* 262470 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_XFY_ZhongHuaV3 /* 196934 */:
                        ConstAllAirDara.U_AIR_FRONT = 65;
                        ConstAllAirDara.U_AIR_AC_MAX = 255;
                        ConstAllAirDara.U_AIR_FRONTMAX = 255;
                        ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 255;
                        ConstAllAirDara.C_AIR_AC_MAX = 255;
                        ConstAllAirDara.C_AIR_MODE_UP = 255;
                        ConstAllAirDara.C_AIR_MODE_BODY = 29;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 31;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 30;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 32;
                        ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                        break;
                    case FinalCanbus.CAR_XFY_ZhongHuaV3_H /* 262470 */:
                        ConstAllAirDara.U_AIR_AC_MAX = 53;
                        ConstAllAirDara.U_AIR_FRONTMAX = 65;
                        ConstAllAirDara.U_AIR_FRONT = 255;
                        ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 38;
                        ConstAllAirDara.C_AIR_AC_MAX = 39;
                        ConstAllAirDara.C_AIR_MODE_UP = 3;
                        ConstAllAirDara.C_AIR_MODE_BODY = 29;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 31;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 255;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 255;
                        ConstAllAirDara.C_AIR_FRONT_DEFROST = 255;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 10;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_BNR_CX70 /* 262214 */:
            case FinalCanbus.CAR_BNR_16CS75_L /* 393286 */:
            case FinalCanbus.CAR_BNR_16CS75_M /* 458822 */:
            case FinalCanbus.CAR_BNR_16CS75_H_RightCamera /* 524358 */:
            case FinalCanbus.CAR_BNR_16CS75_H_FullView /* 589894 */:
            case FinalCanbus.CAR_BNR_17CS75 /* 655430 */:
            case FinalCanbus.CAR_BNR_19COS /* 917574 */:
            case FinalCanbus.CAR_BNR_17CX70 /* 983110 */:
            case FinalCanbus.CAR_BNR_17CX70_M /* 1048646 */:
            case FinalCanbus.CAR_BNR_17CX70_H /* 1114182 */:
                ConstAllAirDara.TEMPERATURE_LOW = 0;
                ConstAllAirDara.TEMPERATURE_HIGHT = 15;
                ConstAllAirDara.TEMPERATURE_NONE = -1;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_BNR_16CS75_M /* 458822 */:
                    case FinalCanbus.CAR_BNR_16CS75_H_RightCamera /* 524358 */:
                    case FinalCanbus.CAR_BNR_16CS75_H_FullView /* 589894 */:
                    case FinalCanbus.CAR_BNR_17CX70_M /* 1048646 */:
                    case FinalCanbus.CAR_BNR_17CX70_H /* 1114182 */:
                        ConstAllAirDara.TEMPERATURE_LOW = 0;
                        ConstAllAirDara.TEMPERATURE_HIGHT = 255;
                        ConstAllAirDara.TEMPERATURE_NONE = -1;
                        break;
                    case FinalCanbus.CAR_BNR_19COS /* 917574 */:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.C_AIR_AUTO = 21;
                        ConstAllAirDara.TEMPERATURE_LOW = 0;
                        ConstAllAirDara.TEMPERATURE_HIGHT = 255;
                        ConstAllAirDara.TEMPERATURE_NONE = -1;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 2;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_CONTRAL = 4;
                break;
            case FinalCanbus.CAR_WC2_HavalH2_CYT_AIR /* 262276 */:
            case FinalCanbus.CAR_WC2_HavalH2_CYT_AIR_H /* 327812 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONTMAX = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_CONTRAL = 32;
                break;
            case FinalCanbus.CAR_RZC_XP1_RongWei_RX5 /* 262417 */:
            case FinalCanbus.CAR_RZC_19MingjueHS /* 852241 */:
            case FinalCanbus.CAR_RZC_19MingjueHS_H /* 1048849 */:
            case FinalCanbus.CAR_RZC_17Rongwei_EI6 /* 1573137 */:
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
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                if (DataCanbus.DATA[1000] == 852241 || DataCanbus.DATA[1000] == 1048849) {
                    ConstAllAirDara.C_AIR_MODE_BODY = 241;
                    ConstAllAirDara.C_AIR_MODE_FOOT = 243;
                    ConstAllAirDara.C_AIR_MODE_BODYFOOT = 242;
                    ConstAllAirDara.C_AIR_MODE_UPFOOT = 244;
                } else {
                    ConstAllAirDara.C_AIR_MODE_CHANGER = 2;
                }
                ConstAllAirDara.C_AIR_POWER = 5;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_AC = 8;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 7;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 6;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 245;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 245;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 1;
                ConstAllAirDara.C_AIR_WIND_SUB = 36;
                ConstAllAirDara.C_AIR_WIND_ADD = 4;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                ConstAllAirDara.C_CONTRAL = 5;
                break;
            case FinalCanbus.CAR_BNR_ChuanQiGS4 /* 327960 */:
            case FinalCanbus.CAR_BNR_ChuanQiGS4_H /* 393496 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 65;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_BNR_ChuanQiGS4_H /* 393496 */:
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 22;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 23;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 24;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_XP1_KeLeiAo_L /* 328054 */:
            case FinalCanbus.CAR_XP1_KeLeiAo_H /* 393590 */:
            case FinalCanbus.CAR_XP1_Meiganna4_TR_HAND /* 1245558 */:
            case FinalCanbus.CAR_XP1_Meiganna4_TR_AUTO /* 1311094 */:
            case FinalCanbus.CAR_XP1_Meiganna4_TR_AUTO_H /* 1769846 */:
            case FinalCanbus.CAR_XP1_RAM1500_H_AUTO /* 4194678 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_XP1_KeLeiAo_L /* 328054 */:
                    case FinalCanbus.CAR_XP1_Meiganna4_TR_HAND /* 1245558 */:
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 25;
                        break;
                    case FinalCanbus.CAR_XP1_KeLeiAo_H /* 393590 */:
                    case FinalCanbus.CAR_XP1_Meiganna4_TR_AUTO /* 1311094 */:
                    case FinalCanbus.CAR_XP1_Meiganna4_TR_AUTO_H /* 1769846 */:
                    case FinalCanbus.CAR_XP1_RAM1500_H_AUTO /* 4194678 */:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_SYNC = 62;
                        ConstAllAirDara.C_AIR_AUTO = 20;
                        ConstAllAirDara.C_AIR_SYNC = 23;
                        ConstAllAirDara.C_AIR_MODE_UP = 27;
                        ConstAllAirDara.C_AIR_MODE_BODY = 24;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 26;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_AC = 17;
                ConstAllAirDara.C_AIR_CYCLE = 19;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 21;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 22;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 31;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 30;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 33;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 32;
                ConstAllAirDara.C_AIR_WIND_ADD = 29;
                ConstAllAirDara.C_AIR_WIND_SUB = 28;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_XP1_QiJun_DaoJun_SHOUDONG /* 393359 */:
            case FinalCanbus.CAR_XP1_QiJun_DaoJun_ZIDONG /* 589967 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 38;
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_XP1_QiJun_H /* 131152 */:
                    case FinalCanbus.CAR_XP1_QiJun_CYT_ZIDONG /* 196751 */:
                    case FinalCanbus.CAR_XP1_QiJun_CYT_ZIDONG_H /* 262287 */:
                    case FinalCanbus.CAR_XP1_CYT_XuanYi_H /* 524431 */:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_DUAL = 14;
                        ConstAllAirDara.C_AIR_AUTO = 1;
                        ConstAllAirDara.C_AIR_DUAL = 2;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 9;
                        break;
                    default:
                        ConstAllAirDara.C_AIR_MODE_BODY = 29;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 31;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 24;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 23;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 10;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 33;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                ConstAllAirDara.C_AIR_AC = 8;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_BNR_BoYue /* 459017 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_DUAL = 3;
                ConstAllAirDara.C_AIR_CYCLE = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 6;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 18;
                ConstAllAirDara.C_AIR_AC_MAX = 19;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_WC2_ShuPing10JunYue /* 459097 */:
                ConstAllAirDara.TEMPERATURE_NONE = 0;
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
                ConstAllAirDara.U_AIR_AUTO = 49;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_SYNC = 3;
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
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_MODE_ADD = 21;
                ConstAllAirDara.C_AIR_MODE_SUB = 22;
                ConstAllAirDara.C_CONTRAL = 14;
                break;
            case FinalCanbus.CAR_WC2_RENAULT_Megane4 /* 459104 */:
            case FinalCanbus.CAR_WC2_RENAULT_Megane4_M /* 983392 */:
            case FinalCanbus.CAR_WC2_RENAULT_Megane4_H /* 1442144 */:
            case FinalCanbus.CAR_WC2_RENAULT_23Megane4 /* 1704288 */:
            case FinalCanbus.CAR_WC2_RENAULT_23Megane4_M /* 1769824 */:
            case FinalCanbus.CAR_WC2_RENAULT_23Megane4_H /* 1835360 */:
            case FinalCanbus.CAR_WC2_RENAULT_Talisman /* 1900896 */:
            case FinalCanbus.CAR_WC2_RENAULT_Talisman_M /* 1966432 */:
            case FinalCanbus.CAR_WC2_RENAULT_Talisman_H /* 2031968 */:
            case FinalCanbus.CAR_WC2_RENAULT_17KOLEOS_L /* 2621792 */:
            case FinalCanbus.CAR_WC2_RENAULT_17KOLEOS_M /* 2687328 */:
            case FinalCanbus.CAR_WC2_RENAULT_17KOLEOS_H /* 2752864 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                if (DataCanbus.DATA[1000] == 983392 || DataCanbus.DATA[1000] == 1442144 || DataCanbus.DATA[1000] == 1966432 || DataCanbus.DATA[1000] == 2031968 || DataCanbus.DATA[1000] == 1769824 || DataCanbus.DATA[1000] == 1835360 || DataCanbus.DATA[1000] == 2687328 || DataCanbus.DATA[1000] == 2752864) {
                    ConstAllAirDara.U_AIR_SOFT = 71;
                    ConstAllAirDara.U_AIR_FAST = 70;
                    ConstAllAirDara.U_AIR_AQS = 36;
                    ConstAllAirDara.U_AIR_ZONE = 62;
                    ConstAllAirDara.C_AIR_ZONE = 3;
                    ConstAllAirDara.C_SOFT = 60;
                    ConstAllAirDara.C_FAST = 61;
                    ConstAllAirDara.C_AIR_AQS = 59;
                    ConstAllAirDara.C_AIR_MODE_UP = 8;
                    ConstAllAirDara.C_AIR_MODE_BODY = 9;
                    ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                } else {
                    ConstAllAirDara.C_AIR_MODE_ADD = 21;
                    ConstAllAirDara.C_AIR_MODE_SUB = 22;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_BNR_SR7 /* 524553 */:
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
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 2;
                ConstAllAirDara.C_AIR_MODE_BODY = 7;
                ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 33;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 32;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_WC_SP_1213Camery /* 590118 */:
            case FinalCanbus.CAR_WC_SP_1516Camery_15Reiz /* 655654 */:
            case FinalCanbus.CAR_WC_SP_101416Prado_LuXun_12Rezi_ZiDong /* 721190 */:
            case FinalCanbus.CAR_WC_SP_101416Prado_LuXun_12Rezi_ShouDong /* 786726 */:
            case FinalCanbus.CAR_WC_SP_09Camery /* 852262 */:
            case FinalCanbus.CAR_WC_SP_12LuXun /* 917798 */:
            case FinalCanbus.CAR_WC_SP_15HighLand_Zidong /* 983334 */:
            case FinalCanbus.CAR_WC_SP_15HighLand_ShouDong /* 1048870 */:
            case FinalCanbus.CAR_WC_SP_09HighLand_Zidong /* 1114406 */:
            case FinalCanbus.CAR_WC_SP_09HighLand_ShouDong /* 1179942 */:
            case FinalCanbus.CAR_WC_SP_07KaluoLa_ZiDong /* 1245478 */:
            case FinalCanbus.CAR_WC_SP_14KaluoLa_ZiDong /* 1311014 */:
            case FinalCanbus.CAR_WC_SP_Alpha /* 1376550 */:
            case FinalCanbus.CAR_WC_SP_02_09Prado /* 1442086 */:
            case FinalCanbus.CAR_WC_SP_09_13RAV4 /* 1507622 */:
            case FinalCanbus.CAR_WC_SP_09_Lexus_ES350 /* 1573158 */:
            case FinalCanbus.CAR_WC_SP_09_Lexus_ES350_H /* 1638694 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                if (DataCanbus.DATA[1000] == 852262) {
                    ConstAllAirDara.C_AIR_MODE_CHANGER = 21;
                } else if (DataCanbus.DATA[1000] == 1573158 || DataCanbus.DATA[1000] == 1638694) {
                    ConstAllAirDara.C_AIR_MODE_ADD = 37;
                    ConstAllAirDara.C_AIR_MODE_SUB = 21;
                    ConstAllAirDara.U_AIR_CYCLE_AUTO = 54;
                } else {
                    ConstAllAirDara.C_AIR_MODE_ADD = 37;
                    ConstAllAirDara.C_AIR_MODE_SUB = 21;
                    ConstAllAirDara.U_AIR_REAR_CTRL = 67;
                    ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                    ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                    ConstAllAirDara.U_AIR_CLEANAIR = 76;
                    ConstAllAirDara.C_REAR_CTRL = 34;
                    ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                    ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                    ConstAllAirDara.C_CLEAN_AIR = 25;
                }
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
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_DUAL = 41;
                ConstAllAirDara.C_CONTRAL = 27;
                break;
            case FinalCanbus.CAR_355_HC_XIANDAI /* 590179 */:
            case FinalCanbus.CAR_355_HC_XIANDAI_AMP /* 655715 */:
                ConstAllAirDara.TEMPERATURE_LOW = 0;
                ConstAllAirDara.TEMPERATURE_HIGHT = 30;
                ConstAllAirDara.TEMPERATURE_NONE = -1;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AQS = 54;
                ConstAllAirDara.U_AIR_REAR_CTRL = 38;
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
                ConstAllAirDara.C_AIR_MODE_CHANGER = 8;
                ConstAllAirDara.C_AIR_AQS = 26;
                ConstAllAirDara.C_REAR_CTRL = 27;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_XP1_RAM1500 /* 655734 */:
            case FinalCanbus.CAR_XP1_RAM1500_M /* 4063606 */:
            case FinalCanbus.CAR_XP1_RAM1500_H /* 4129142 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_XP1_RAM1500_H /* 4129142 */:
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 13;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 14;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 45;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 46;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_SYNC = 8;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_CONTRAL = 24;
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
                if (DataCanbus.DATA[1000] == 721309) {
                    ConstAllAirDara.U_AIR_AUTO = 13;
                    ConstAllAirDara.C_AIR_AUTO = 2;
                    ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                } else {
                    ConstAllAirDara.C_AIR_MODE_BODY = 7;
                    ConstAllAirDara.C_AIR_MODE_FOOT = 9;
                    ConstAllAirDara.C_AIR_MODE_BODYFOOT = 8;
                    ConstAllAirDara.C_AIR_MODE_UPFOOT = 10;
                }
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_CYCLE = 21;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 6;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 23;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 14;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_XP1_15QiJun_Shuping /* 721039 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 38;
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.C_AIR_POWER = 16;
                ConstAllAirDara.C_AIR_AC = 17;
                ConstAllAirDara.C_AIR_CYCLE = 19;
                ConstAllAirDara.C_AIR_AUTO = 20;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 21;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 22;
                ConstAllAirDara.C_AIR_DUAL = 23;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 25;
                ConstAllAirDara.C_AIR_WIND_ADD = 29;
                ConstAllAirDara.C_AIR_WIND_SUB = 28;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 31;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 30;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 33;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 32;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_455_RZC_Mclaren_12C /* 721351 */:
            case FinalCanbus.CAR_453_RZC_Mclaren_16_560S /* 4915653 */:
            case FinalCanbus.CAR_453_RZC_Mclaren_19_720S /* 4981189 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                if (DataCanbus.DATA[1000] == 4915653 || DataCanbus.DATA[1000] == 721351) {
                    ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                    ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                    ConstAllAirDara.C_AIR_LEFT_HEAT = 7;
                    ConstAllAirDara.C_AIR_RIGHT_HEAT = 9;
                } else {
                    ConstAllAirDara.U_AIR_HEAT = 63;
                    ConstAllAirDara.U_AIR_COOL = 85;
                    ConstAllAirDara.C_AIR_HEAT = 13;
                    ConstAllAirDara.C_AIR_COOL = 12;
                }
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_AUTO = 23;
                ConstAllAirDara.C_AIR_SYNC = 24;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 26;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 27;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 28;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 29;
                ConstAllAirDara.C_AIR_WIND_ADD = 30;
                ConstAllAirDara.C_AIR_WIND_SUB = 31;
                ConstAllAirDara.C_AIR_MODE_UP = 32;
                ConstAllAirDara.C_AIR_MODE_BODY = 33;
                ConstAllAirDara.C_AIR_MODE_FOOT = 34;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_WC2_Honda_17GuanDao /* 917825 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
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
                ConstAllAirDara.C_AIR_MODE_CHANGER = 21;
                ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT = 36;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                ConstAllAirDara.C_CONTRAL = 255;
                break;
            case FinalCanbus.CAR_443_WC2_TOYOTA_09HG /* 1376699 */:
            case FinalCanbus.CAR_443_WC2_TOYOTA_09RAV4 /* 1442235 */:
            case FinalCanbus.CAR_443_WC2_TOYOTA_08Camery /* 1573307 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 21;
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
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_DUAL = 41;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_453_LZ_AstonMartin /* 1376709 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 11;
                ConstAllAirDara.C_AIR_AC = 8;
                ConstAllAirDara.C_AIR_AUTO = 10;
                ConstAllAirDara.C_AIR_CYCLE = 9;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 12;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 13;
                ConstAllAirDara.C_AIR_MODE_UP = 14;
                ConstAllAirDara.C_AIR_MODE_BODY = 15;
                ConstAllAirDara.C_AIR_MODE_FOOT = 16;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 6;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_XP_Renault_23KOLEOS_L_Auto /* 1442216 */:
            case FinalCanbus.CAR_XP_Renault_23KOLEOS_L_Hand /* 1507752 */:
            case FinalCanbus.CAR_XP_Renault_23KOLEOS_H_Auto /* 1573288 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONTMAX = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_XP_Renault_23KOLEOS_L_Auto /* 1442216 */:
                    case FinalCanbus.CAR_XP_Renault_23KOLEOS_H_Auto /* 1573288 */:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_DUAL = 14;
                        ConstAllAirDara.U_AIR_AQS = 54;
                        ConstAllAirDara.U_AIR_SOFT = 71;
                        ConstAllAirDara.U_AIR_FAST = 70;
                        ConstAllAirDara.U_AIR_NORMAL = 34;
                        ConstAllAirDara.C_AIR_AUTO = 20;
                        ConstAllAirDara.C_AIR_DUAL = 23;
                        ConstAllAirDara.C_AIR_MODE_UP = 27;
                        ConstAllAirDara.C_AIR_MODE_BODY = 24;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 26;
                        ConstAllAirDara.C_AIR_AQS = 34;
                        ConstAllAirDara.C_SOFT = 64;
                        ConstAllAirDara.C_FAST = 66;
                        ConstAllAirDara.C_NORMAL = 65;
                        break;
                    case FinalCanbus.CAR_XP_Renault_23KOLEOS_L_Hand /* 1507752 */:
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 25;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 16;
                ConstAllAirDara.C_AIR_AC = 17;
                ConstAllAirDara.C_AIR_CYCLE = 19;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 21;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 22;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 31;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 30;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 33;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 32;
                ConstAllAirDara.C_AIR_WIND_ADD = 29;
                ConstAllAirDara.C_AIR_WIND_SUB = 28;
                ConstAllAirDara.C_CONTRAL = 4;
                break;
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES200_13 /* 1572976 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES300_05 /* 1704048 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES300_20 /* 1835120 */:
            case FinalCanbus.CAR_RZC_TOYOTA_04Verso_SP /* 7078000 */:
            case FinalCanbus.CAR_RZC_TOYOTA_10Prius_SP /* 7536752 */:
            case FinalCanbus.CAR_RZC_TOYOTA_16Prius_SP /* 8126576 */:
            case FinalCanbus.CAR_RZC_TOYOTA_14Tundra /* 8192112 */:
            case FinalCanbus.CAR_RZC_TOYOTA_14Tundra_Auto /* 8257648 */:
            case FinalCanbus.CAR_RZC_TOYOTA_10Sequoia /* 8323184 */:
            case FinalCanbus.CAR_RZC_TOYOTA_10Sequoia_Auto /* 8388720 */:
            case FinalCanbus.CAR_RZC_TOYOTA_08Camry /* 8454256 */:
            case FinalCanbus.CAR_RZC_TOYOTA_13Camry /* 8519792 */:
            case FinalCanbus.CAR_RZC_TOYOTA_10AURIS_Auto /* 8585328 */:
            case FinalCanbus.CAR_RZC_TOYOTA_13Avalon_Auto /* 8650864 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AQS = 54;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_MODE_ADD = 8;
                ConstAllAirDara.C_AIR_MODE_SUB = 7;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_CONTRAL = 47;
                break;
            case FinalCanbus.CAR_RZC_XP1_21Xiaomayi_EQ1 /* 1638804 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_PTC = 68;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 6;
                ConstAllAirDara.C_AIR_PTC = 19;
                ConstAllAirDara.C_AIR_CYCLE = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_MODE_BODY = 7;
                ConstAllAirDara.C_AIR_MODE_FOOT = 9;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 8;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 10;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_439_Oudi_Haval_H3 /* 1704375 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
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
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_DUAL = 14;
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
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 18;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_AIR_BLOWTOP = 41;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_444_WC2_ChangfengLiebao_CS9_17 /* 1769916 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
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
                ConstAllAirDara.C_AIR_MODE_CHANGER = 21;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_RZC3_XianDai_I30_15 /* 1835370 */:
            case FinalCanbus.CAR_RZC3_XianDai_CEED_11 /* 1900906 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
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
                ConstAllAirDara.C_AIR_AUTO = 3;
                ConstAllAirDara.C_AIR_CYCLE = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 7;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 8;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 10;
                ConstAllAirDara.C_AIR_SYNC = 11;
                ConstAllAirDara.C_AIR_WIND_ADD = 12;
                ConstAllAirDara.C_AIR_WIND_SUB = 13;
                ConstAllAirDara.C_AIR_MODE_UP = 32;
                ConstAllAirDara.C_AIR_MODE_BODY = 33;
                ConstAllAirDara.C_AIR_MODE_FOOT = 34;
                ConstAllAirDara.C_AIR_REST = 41;
                ConstAllAirDara.C_CONTRAL = 4;
                break;
            case FinalCanbus.CAR_439_OuDi_NaZhiJieU7 /* 2032055 */:
            case FinalCanbus.CAR_439_OuDi_NaZhiJieU5 /* 3932599 */:
            case FinalCanbus.CAR_452_OuDi_NaZhiJieU6 /* 11534788 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_FRONT = 18;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_AUTO = 24;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 32;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 2;
                ConstAllAirDara.C_AIR_MODE_ADD = 7;
                ConstAllAirDara.C_AIR_MODE_SUB = 8;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_DJ_XP1_ParkAvenue /* 2162713 */:
                ConstAllAirDara.TEMPERATURE_LOW = 0;
                ConstAllAirDara.TEMPERATURE_HIGHT = 30;
                ConstAllAirDara.TEMPERATURE_NONE = -1;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.C_AIR_POWER = 10;
                ConstAllAirDara.C_AIR_AUTO = 1;
                ConstAllAirDara.C_AIR_AC = 8;
                ConstAllAirDara.C_AIR_DUAL = 2;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 33;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                ConstAllAirDara.C_AIR_MODE_ADD = 16;
                ConstAllAirDara.C_AIR_MODE_SUB = 17;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 36;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 37;
                ConstAllAirDara.C_CONTRAL = 17;
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
            case FinalCanbus.CAR_439_RZC_ZhongTaiSR9 /* 2294199 */:
            case FinalCanbus.CAR_439_RZC_ZhongTaiSR9_H /* 2359735 */:
            case FinalCanbus.CAR_439_RZC_ZhongTaiSR7 /* 7537079 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_REAR = 38;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
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
                ConstAllAirDara.C_AIR_AC_MAX = 7;
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 9;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 11;
                ConstAllAirDara.C_AIR_WIND_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 16;
                ConstAllAirDara.C_AIR_MODE_UP = 17;
                ConstAllAirDara.C_AIR_MODE_BODY = 18;
                ConstAllAirDara.C_AIR_MODE_FOOT = 19;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 20;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 21;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_439_XBS_NISSAN_TuLe /* 2425271 */:
            case FinalCanbus.CAR_439_XBS_NISSAN_TuLe_ALLV /* 3342775 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONTMAX = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_REAR_CTRL = 38;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_REAR_CTRL = 48;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_454_OD_Jianghuai_SEHOL_E50A /* 2490822 */:
            case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5 /* 2818501 */:
            case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5_H /* 2884037 */:
            case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5 /* 3015109 */:
            case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5_H /* 3080645 */:
                ConstAllAirDara.U_AIR_POWER = 21;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                if (DataCanbus.DATA[1000] != 2490822) {
                    ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                    ConstAllAirDara.C_AIR_LEFT_HEAT = 19;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 2;
                ConstAllAirDara.C_AIR_AUTO = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 4;
                ConstAllAirDara.C_AIR_CYCLE = 5;
                ConstAllAirDara.C_AIR_AC = 6;
                ConstAllAirDara.C_AIR_AC_MAX = 7;
                ConstAllAirDara.C_AIR_WIND_ADD = 8;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_MODE_BODY = 10;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 11;
                ConstAllAirDara.C_AIR_MODE_FOOT = 12;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 13;
                ConstAllAirDara.C_AIR_MODE_UP = 14;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 16;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 17;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 18;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_455_LUZ_Nissan_GTR_EN /* 2621895 */:
            case FinalCanbus.CAR_439_LUZ_Nissan_GTR /* 13566391 */:
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
                ConstAllAirDara.C_AIR_POWER = 6;
                ConstAllAirDara.C_AIR_AUTO = 5;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 7;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 8;
                ConstAllAirDara.C_AIR_DUAL = 14;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_AC = 11;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 13;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_CYCLE = 12;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_452_Mixun_Liebao_CS9 /* 2687428 */:
                ConstAllAirDara.TEMPERATURE_NONE = 0;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AQS = 54;
                ConstAllAirDara.U_AIR_ECO = 52;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 2;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_ECO = 38;
                ConstAllAirDara.C_AIR_AQS = 37;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_439_XFY_LAGAN /* 3670455 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 10;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_439_HC_OuGeTL /* 3998135 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AUTO_RIGHT = 26;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 7;
                ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT = 32;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_AUTO_RIGHT = 33;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_453_XP1_Ford_Edge_2013 /* 4260293 */:
            case FinalCanbus.CAR_453_XP1_Ford_F150_2013 /* 4325829 */:
            case FinalCanbus.CAR_453_XP1_Ford_Explorer_2013 /* 4391365 */:
            case FinalCanbus.CAR_453_XP1_Ford_Taurus_2013 /* 4456901 */:
            case FinalCanbus.CAR_453_XP1_Ford_Expedition_2013 /* 4522437 */:
            case FinalCanbus.CAR_453_XP1_Ford_Edge_2015 /* 4587973 */:
            case FinalCanbus.CAR_453_XP1_Ford_Mustang_2015 /* 4653509 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
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
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_AC_MAX = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_AUTO = 23;
                ConstAllAirDara.C_AIR_DUAL = 24;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 36;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 35;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 38;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 37;
                ConstAllAirDara.C_AIR_WIND_ADD = 40;
                ConstAllAirDara.C_AIR_WIND_SUB = 39;
                ConstAllAirDara.C_AIR_MODE_UP = 32;
                ConstAllAirDara.C_AIR_MODE_BODY = 33;
                ConstAllAirDara.C_AIR_MODE_FOOT = 34;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 43;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 45;
                ConstAllAirDara.C_AIR_LEFT_COLD = 44;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 46;
                ConstAllAirDara.C_AIR_STEER = 42;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_453_RZC_SWM_G05Pro_22 /* 5964229 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 2;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_CYCLE = 4;
                ConstAllAirDara.C_AIR_AC = 5;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 6;
                ConstAllAirDara.C_AIR_LEFT_COLD = 7;
                ConstAllAirDara.C_AIR_WIND_SUB = 8;
                ConstAllAirDara.C_AIR_WIND_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 13;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_439_RZC_YinFeiNiDi_QX50 /* 6029751 */:
                ConstAllAirDara.TEMPERATURE_NONE = -1;
                ConstAllAirDara.TEMPERATURE_LOW = 36;
                ConstAllAirDara.TEMPERATURE_HIGHT = 64;
                ConstAllAirDara.U_AIR_POWER = 10;
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
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 4;
                ConstAllAirDara.C_AIR_CYCLE = 5;
                ConstAllAirDara.C_AIR_AC = 6;
                ConstAllAirDara.C_AIR_AC_MAX = 7;
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 11;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 15;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_439_HC_TianLai_GongJue /* 6095287 */:
            case FinalCanbus.CAR_439_HC_TianLai_GongJue_CD /* 6488503 */:
            case FinalCanbus.CAR_439_HC_Nissan_Toread /* 7012791 */:
                ConstAllAirDara.TEMPERATURE_NONE = 0;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_CYCLE = 2;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_DUAL = 7;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 8;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 11;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_452_OD_Nissan_Tule_low /* 6095300 */:
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
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
                ConstAllAirDara.C_AIR_WIND_ADD = 7;
                ConstAllAirDara.C_AIR_WIND_SUB = 6;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 8;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 9;
                ConstAllAirDara.C_AIR_AUTO = 10;
                ConstAllAirDara.C_AIR_AC = 11;
                ConstAllAirDara.C_AIR_CYCLE = 12;
                ConstAllAirDara.C_AIR_DUAL = 15;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 14;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_452_OD_Zhonghua_V6_18 /* 6160836 */:
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
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
                ConstAllAirDara.C_AIR_WIND_ADD = 7;
                ConstAllAirDara.C_AIR_WIND_SUB = 6;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 8;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 9;
                ConstAllAirDara.C_AIR_AC_MAX = 10;
                ConstAllAirDara.C_AIR_AC = 11;
                ConstAllAirDara.C_AIR_CYCLE = 12;
                ConstAllAirDara.C_AIR_MODE_UP = 13;
                ConstAllAirDara.C_AIR_MODE_BODY = 14;
                ConstAllAirDara.C_AIR_MODE_FOOT = 15;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_443_WC2_XianDai_All_07Shengda /* 6422971 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_12SORENTO /* 6488507 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_CYCLE_AUTO = 36;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SYNC = 62;
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
            case FinalCanbus.CAR_439_BNR_Rongwei_RX5 /* 7995831 */:
                ConstAllAirDara.TEMPERATURE_LOW = 1;
                ConstAllAirDara.TEMPERATURE_HIGHT = 15;
                ConstAllAirDara.TEMPERATURE_NONE = -1;
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
                ConstAllAirDara.C_CONTRAL = 1;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 2;
                ConstAllAirDara.C_AIR_MODE_BODY = 7;
                ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 33;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 32;
                break;
            case FinalCanbus.CAR_453_LZ_LandRover_13_CD /* 9175493 */:
            case FinalCanbus.CAR_453_LZ_LandRover_18_CD /* 9241029 */:
            case FinalCanbus.CAR_453_LZ_Jaguar_12_CD /* 9306565 */:
            case FinalCanbus.CAR_454_LZ_LandRover_CD_Discovery5 /* 13894086 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT_HOT = 17;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
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
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 6;
                ConstAllAirDara.C_AIR_SYNC = 7;
                ConstAllAirDara.C_AIR_AC = 8;
                ConstAllAirDara.C_AIR_CYCLE = 9;
                ConstAllAirDara.C_AIR_AUTO = 10;
                ConstAllAirDara.C_AIR_POWER = 11;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 12;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 13;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 18;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 14;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 15;
                ConstAllAirDara.C_AIR_FRONT_HOT = 29;
                ConstAllAirDara.C_AIR_AC_MAX = 51;
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
            case FinalCanbus.CAR_454_OD_Beiqi_EV160 /* 10879430 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_PTC = 68;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 2;
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
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_452_LZ_Maserati_SP /* 12255684 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 49;
                ConstAllAirDara.U_AIR_AUTO_RIGHT = 50;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 59;
                ConstAllAirDara.U_AIR_REAR_CTRL = 16;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_AC = 8;
                ConstAllAirDara.C_AIR_CYCLE = 9;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 12;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 13;
                ConstAllAirDara.C_AIR_AUTO = 10;
                ConstAllAirDara.C_AIR_AUTO_RIGHT = 11;
                ConstAllAirDara.C_REAR_CTRL = 20;
                ConstAllAirDara.C_AIR_MODE_UP = 16;
                ConstAllAirDara.C_AIR_MODE_BODY = 14;
                ConstAllAirDara.C_AIR_MODE_FOOT = 15;
                ConstAllAirDara.C_AIR_MODE_UP_RIGHT = 19;
                ConstAllAirDara.C_AIR_MODE_BODY_RIGHT = 17;
                ConstAllAirDara.C_AIR_MODE_FOOT_RIGHT = 18;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 6;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_453_XC_Honda_Acura_RL /* 12452293 */:
            case FinalCanbus.CAR_452_XC_Honda_Acura_TL /* 12911044 */:
            case FinalCanbus.CAR_452_XC_Honda_Acura_RDX /* 12976580 */:
            case FinalCanbus.CAR_452_XC_Honda_Acura_TLX /* 13042116 */:
                ConstAllAirDara.TEMPERATURE_NONE = 0;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AUTO_RIGHT = 26;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_REAR_CTRL = 38;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
                ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 7;
                ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT = 32;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_AUTO_RIGHT = 33;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_REAR_CTRL = 56;
                ConstAllAirDara.C_CONTRAL = 2;
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
            case FinalCanbus.CAR_439_DJ_Nissan /* 12779959 */:
            case FinalCanbus.CAR_439_DJ_Nissan_H /* 12845495 */:
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
                ConstAllAirDara.C_AIR_POWER = 10;
                ConstAllAirDara.C_AIR_DUAL = 2;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 33;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                ConstAllAirDara.C_AIR_AC = 8;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_AUTO = 1;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 9;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_439_DJ_06_09Kayan /* 12911031 */:
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_REST = 55;
                ConstAllAirDara.U_AIR_ECO = 52;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.C_AIR_POWER = 10;
                ConstAllAirDara.C_AIR_AUTO = 1;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 4;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                ConstAllAirDara.C_AIR_MODE_UP = 33;
                ConstAllAirDara.C_AIR_MODE_BODY = 34;
                ConstAllAirDara.C_AIR_MODE_FOOT = 35;
                ConstAllAirDara.C_AIR_ECO = 40;
                ConstAllAirDara.C_AIR_REST = 41;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_439_XFY_Keleiao_17_L /* 13631927 */:
            case FinalCanbus.CAR_439_XFY_Keleiao_17_H /* 13697463 */:
            case FinalCanbus.CAR_439_XFY_Keleiao_18_L /* 13762999 */:
            case FinalCanbus.CAR_439_XFY_Keleiao_18_H /* 13828535 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_SOFT = 71;
                ConstAllAirDara.U_AIR_FAST = 70;
                ConstAllAirDara.U_AIR_AQS = 36;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_MODE_UP = 3;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_MODE_BODY = 29;
                ConstAllAirDara.C_AIR_MODE_FOOT = 31;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_SOFT = 45;
                ConstAllAirDara.C_FAST = 46;
                ConstAllAirDara.C_AIR_AQS = 48;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 38;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_452_CYT_Toyota_Tundra /* 13959620 */:
            case FinalCanbus.CAR_452_CYT_Toyota_Tundra_H /* 14025156 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
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
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_452_CYT_Toyota_Tundra_H /* 14025156 */:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_DUAL = 14;
                        ConstAllAirDara.C_AIR_DUAL = 8;
                        ConstAllAirDara.C_AIR_AUTO = 2;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
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
                ConstAllAirDara.C_AIR_LEFT_COLD = 45;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 46;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_454_LZ_Nissan_370Z_L /* 14680518 */:
            case FinalCanbus.CAR_454_LZ_Nissan_370Z_TW /* 14811590 */:
            case FinalCanbus.CAR_453_LZ_Teana_08_L /* 15532485 */:
            case FinalCanbus.CAR_453_LZ_Teana_08_H /* 15598021 */:
            case FinalCanbus.CAR_453_LZ_Teana_08_TW /* 15663557 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_L /* 15729094 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H /* 15794630 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_TW /* 15860166 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H_NP /* 15925702 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_453_LZ_Teana_08_L /* 15532485 */:
                    case FinalCanbus.CAR_453_LZ_Teana_08_H /* 15598021 */:
                    case FinalCanbus.CAR_453_LZ_Teana_08_TW /* 15663557 */:
                        ConstAllAirDara.U_AIR_DUAL = 14;
                        ConstAllAirDara.U_AIR_CLEAN = 76;
                        ConstAllAirDara.C_CLEAN = 18;
                        ConstAllAirDara.C_AIR_DUAL = 14;
                        break;
                    case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_L /* 15729094 */:
                    case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H /* 15794630 */:
                    case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_TW /* 15860166 */:
                    case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H_NP /* 15925702 */:
                        ConstAllAirDara.U_AIR_DUAL = 14;
                        ConstAllAirDara.C_AIR_DUAL = 14;
                        break;
                }
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
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_453_LZ_Teana_08_L /* 15532485 */:
                    case FinalCanbus.CAR_453_LZ_Teana_08_H /* 15598021 */:
                    case FinalCanbus.CAR_453_LZ_Teana_08_TW /* 15663557 */:
                        ConstAllAirDara.C_CONTRAL = 0;
                        break;
                    default:
                        ConstAllAirDara.C_CONTRAL = 2;
                        break;
                }
            case FinalCanbus.CAR_452_Luz_Audi_A4L_Low /* 14811588 */:
            case FinalCanbus.CAR_452_Luz_Audi_A4L_H /* 14877124 */:
            case FinalCanbus.CAR_452_Luz_Audi_Q5_Low /* 14942660 */:
            case FinalCanbus.CAR_452_Luz_Audi_Q5_H /* 15008196 */:
            case FinalCanbus.CAR_452_Luz_Audi_A6L_Low /* 15073732 */:
            case FinalCanbus.CAR_452_Luz_Audi_A6L_H /* 15139268 */:
            case FinalCanbus.CAR_452_Luz_Audi_Q7_Low /* 15204804 */:
            case FinalCanbus.CAR_452_Luz_Audi_Q7_H /* 15270340 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_REAR_CTRL = 67;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 120;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_SYNC = 8;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_REAR_CTRL = 37;
                ConstAllAirDara.C_AIR_MODE_UP = 3;
                ConstAllAirDara.C_AIR_MODE_BODY = 29;
                ConstAllAirDara.C_AIR_MODE_FOOT = 31;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 13;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 14;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_452_LUZ_LANDROVER_CYTAIR /* 15729092 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_FRONTMAX = 17;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 62;
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
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 13;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 14;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_MODE_UP = 3;
                ConstAllAirDara.C_AIR_MODE_BODY = 29;
                ConstAllAirDara.C_AIR_MODE_FOOT = 31;
                ConstAllAirDara.C_CONTRAL = 3;
                break;
            case FinalCanbus.CAR_453_OD_Beiqi_Changhe_Q7_SP /* 15925701 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 4;
                ConstAllAirDara.C_AIR_CYCLE = 5;
                ConstAllAirDara.C_AIR_AC = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 11;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 15;
                ConstAllAirDara.C_CONTRAL = 1;
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
            findViewById(R.id.air_sp_forest).setVisibility(0);
            findViewById(R.id.air_sp_forest).setOnTouchListener(this);
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
        if (ConstAllAirDara.C_AIR_MODE_UP_RIGHT != 255) {
            findViewById(R.id.air_sp_blow_win_right).setVisibility(0);
            findViewById(R.id.air_sp_blow_win_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_blow_win_right).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_BODY_RIGHT != 255) {
            findViewById(R.id.air_sp_blow_body_right).setVisibility(0);
            findViewById(R.id.air_sp_blow_body_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_blow_body_right).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_FOOT_RIGHT != 255) {
            findViewById(R.id.air_sp_blow_foot_right).setVisibility(0);
            findViewById(R.id.air_sp_blow_foot_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_blow_foot_right).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_LEFT_COLD != 255) {
            findViewById(R.id.air_sp_seatwind_left).setOnTouchListener(this);
            findViewById(R.id.air_sp_seatwind_left).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_seatwind_left).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_RIGHT_COLD != 255) {
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

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        initCallbackId();
        init();
        addUpdater();
        AirHelper.disableAirWindowLocal(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeUpdater();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        switch (id) {
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
                data0 = ConstAllAirDara.C_AIR_POWER;
                break;
            case R.id.air_sp_wind_minuts /* 2131430281 */:
                data0 = ConstAllAirDara.C_AIR_WIND_SUB;
                break;
            case R.id.air_sp_wind_plus /* 2131430283 */:
                data0 = ConstAllAirDara.C_AIR_WIND_ADD;
                break;
            case R.id.air_sp_cycle /* 2131430284 */:
                switch (DataCanbus.DATA[1000]) {
                    case 388:
                    case FinalCanbus.CAR_XC_08TianLai_LOW /* 65924 */:
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            data0 = 94;
                            break;
                        } else {
                            data0 = 93;
                            break;
                        }
                    case FinalCanbus.CAR_RZC_XP1_QiJun_H /* 131152 */:
                    case FinalCanbus.CAR_XP1_QiJun_CYT_ZIDONG /* 196751 */:
                    case FinalCanbus.CAR_XP1_QiJun_CYT_ZIDONG_H /* 262287 */:
                    case FinalCanbus.CAR_XP1_CYT_XuanYi_H /* 524431 */:
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            data0 = 6;
                            break;
                        } else {
                            data0 = 5;
                            break;
                        }
                    case FinalCanbus.CAR_BNR_16CS75_L /* 393286 */:
                    case FinalCanbus.CAR_BNR_16CS75_M /* 458822 */:
                    case FinalCanbus.CAR_BNR_16CS75_H_RightCamera /* 524358 */:
                    case FinalCanbus.CAR_BNR_16CS75_H_FullView /* 589894 */:
                    case FinalCanbus.CAR_BNR_17CS75 /* 655430 */:
                    case FinalCanbus.CAR_BNR_19COS /* 917574 */:
                    case FinalCanbus.CAR_452_Mixun_Liebao_CS9 /* 2687428 */:
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            data0 = 35;
                            break;
                        } else {
                            data0 = 34;
                            break;
                        }
                    case FinalCanbus.CAR_XP1_QiJun_DaoJun_ZIDONG /* 589967 */:
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            data0 = 39;
                            break;
                        } else {
                            data0 = 38;
                            break;
                        }
                    case FinalCanbus.CAR_RZC_XP1_21Xiaomayi_EQ1 /* 1638804 */:
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            data0 = 5;
                            break;
                        } else {
                            data0 = 4;
                            break;
                        }
                    case FinalCanbus.CAR_439_HC_TianLai_GongJue /* 6095287 */:
                    case FinalCanbus.CAR_439_HC_TianLai_GongJue_CD /* 6488503 */:
                    case FinalCanbus.CAR_439_HC_Nissan_Toread /* 7012791 */:
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            data0 = 3;
                            break;
                        } else {
                            data0 = 2;
                            break;
                        }
                    case FinalCanbus.CAR_452_OD_Nissan_Tule_low /* 6095300 */:
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            data0 = 13;
                            break;
                        } else {
                            data0 = 12;
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
            case R.id.air_sp_ptc /* 2131430319 */:
                data0 = ConstAllAirDara.C_AIR_PTC;
                break;
            case R.id.air_sp_em /* 2131430321 */:
                data0 = ConstAllAirDara.C_AIR_EM;
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
            case R.id.air_sp_blow_changer /* 2131430395 */:
                data0 = ConstAllAirDara.C_AIR_MODE_CHANGER;
                break;
            case R.id.air_sp_blow_changer_right /* 2131430403 */:
                data0 = ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT;
                break;
            case R.id.air_sp_ev /* 2131430463 */:
                data0 = ConstAllAirDara.C_AIR_EV;
                break;
            case R.id.air_sp_clean_air /* 2131430464 */:
                data0 = ConstAllAirDara.C_CLEAN_AIR;
                break;
            case R.id.air_sp_front_hot /* 2131430465 */:
                data0 = ConstAllAirDara.C_AIR_FRONT_HOT;
                break;
            case R.id.air_sp_forest /* 2131430466 */:
                data0 = ConstAllAirDara.C_AIR_FOREST;
                break;
            case R.id.air_sp_mode_sub /* 2131430469 */:
                data0 = ConstAllAirDara.C_AIR_MODE_SUB;
                break;
            case R.id.air_sp_mode_add /* 2131430470 */:
                data0 = ConstAllAirDara.C_AIR_MODE_ADD;
                break;
            case R.id.air_sp_cool /* 2131430473 */:
                data0 = ConstAllAirDara.C_AIR_COOL;
                break;
        }
        if (0 == 0) {
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
        if (ConstAllAirDara.U_AIR_AUTO_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_AUTO_RIGHT].addNotify(this.mNotifyCanbus, 1);
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
        if (ConstAllAirDara.U_AIR_AUTO_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_AUTO_RIGHT].removeNotify(this.mNotifyCanbus);
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

    
    public void mUpdateAirRest() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REST];
        findViewById(R.id.air_sp_rest).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_rest_n : R.drawable.ic_sp_rest_p);
    }

    
    public void mUpdateAirHeat() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_HEAT];
        findViewById(R.id.air_sp_heat).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_heat_n : R.drawable.ic_sp_heat_p);
    }

    
    public void mUpdateAirCool() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_COOL];
        findViewById(R.id.air_sp_cool).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_cool_n : R.drawable.ic_sp_cool_p);
    }

    
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

    
    public void mUpdateAirAQS() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_AQS];
        findViewById(R.id.air_sp_aqs).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_aqs_n : R.drawable.ic_sp_aqs_p);
    }

    
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

    
    public void mUpdateAirNormal() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_NORMAL];
        findViewById(R.id.air_sp_normal).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_normal_n : R.drawable.ic_sp_normal_p);
    }

    
    public void mUpdateAirFast() {
        int i = R.drawable.ic_sp_fast_n;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_FAST];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_452_BaoGu_Renault_17Koleos /* 131524 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_18Koleos /* 197060 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_17Koleos_M /* 2818500 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_17Koleos_H /* 2884036 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_18Koleos_M /* 3015108 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_18Koleos_H /* 3080644 */:
                switch (vel) {
                    case 0:
                        findViewById(R.id.air_sp_soft).setBackgroundResource(R.drawable.ic_sp_soft_p);
                        findViewById(R.id.air_sp_fast).setBackgroundResource(R.drawable.ic_sp_fast_n);
                        break;
                    case 2:
                        findViewById(R.id.air_sp_fast).setBackgroundResource(R.drawable.ic_sp_fast_p);
                        findViewById(R.id.air_sp_soft).setBackgroundResource(R.drawable.ic_sp_soft_n);
                        break;
                }
            default:
                View findViewById = findViewById(R.id.air_sp_fast);
                if (vel != 0) {
                    i = 2130841914;
                }
                findViewById.setBackgroundResource(i);
                break;
        }
    }

    
    public void mUpdateAirSoft() {
        int i = R.drawable.ic_sp_soft_n;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SOFT];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_452_BaoGu_Renault_17Koleos /* 131524 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_18Koleos /* 197060 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_17Koleos_M /* 2818500 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_17Koleos_H /* 2884036 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_18Koleos_M /* 3015108 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_18Koleos_H /* 3080644 */:
                switch (vel) {
                    case 0:
                        findViewById(R.id.air_sp_soft).setBackgroundResource(R.drawable.ic_sp_soft_p);
                        findViewById(R.id.air_sp_fast).setBackgroundResource(R.drawable.ic_sp_fast_n);
                        break;
                    case 2:
                        findViewById(R.id.air_sp_fast).setBackgroundResource(R.drawable.ic_sp_fast_p);
                        findViewById(R.id.air_sp_soft).setBackgroundResource(R.drawable.ic_sp_soft_n);
                        break;
                }
            default:
                View findViewById = findViewById(R.id.air_sp_soft);
                if (vel != 0) {
                    i = 2130841971;
                }
                findViewById.setBackgroundResource(i);
                break;
        }
    }

    
    public void mUpdateRearCtrl() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_CTRL];
        findViewById(R.id.air_sp_car_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_carrear_n : R.drawable.ic_sp_carrear_p);
    }

    
    public void mUpdateCleanAir() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_CLEANAIR];
        findViewById(R.id.air_sp_clean_air).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_cleanair_n : R.drawable.ic_sp_cleanair_p);
    }

    
    public void mUpdateHeatLeft() {
        int blowlevel;
        int heatlevel;
        int blowlevel2;
        int heatlevel2;
        int i = R.drawable.ic_air_sp_seatheat_left;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
            case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng /* 655708 */:
            case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng1 /* 721244 */:
            case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng2 /* 786780 */:
            case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
            case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
            case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
            case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
                if (((vel >> 3) & 1) == 1) {
                    blowlevel = ((vel ^ (-1)) & 15) + 1;
                    heatlevel = 0;
                } else {
                    blowlevel = 0;
                    heatlevel = vel;
                }
                View findViewById = findViewById(R.id.air_sp_seatheat_left);
                if (heatlevel != 0) {
                    i = 2130839302;
                }
                findViewById.setBackgroundResource(i);
                ((TextView) findViewById(R.id.air_sp_seatheat_left)).setText(new StringBuilder().append(heatlevel).toString());
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(blowlevel == 0 ? R.drawable.ic_air_sp_seatwind_left : R.drawable.ic_air_sp_seatwind_left_p);
                ((TextView) findViewById(R.id.air_sp_seatwind_left)).setText(new StringBuilder().append(blowlevel).toString());
                break;
            case FinalCanbus.CAR_453_LZ_LandRover_13_CD /* 9175493 */:
            case FinalCanbus.CAR_453_LZ_LandRover_18_CD /* 9241029 */:
            case FinalCanbus.CAR_453_LZ_Jaguar_12_CD /* 9306565 */:
            case FinalCanbus.CAR_454_LZ_LandRover_CD_Discovery5 /* 13894086 */:
                if ((vel & 8) != 0) {
                    blowlevel2 = 16 - vel;
                    heatlevel2 = 0;
                } else {
                    blowlevel2 = 0;
                    heatlevel2 = vel;
                }
                if (blowlevel2 == 0 && heatlevel2 != 0) {
                    ((TextView) findViewById(R.id.air_sp_seatheat_left)).setText(new StringBuilder().append(heatlevel2).toString());
                    ((TextView) findViewById(R.id.air_sp_seatheat_left)).setTextColor(-65536);
                    break;
                } else if (blowlevel2 != 0 && heatlevel2 == 0) {
                    ((TextView) findViewById(R.id.air_sp_seatheat_left)).setText(new StringBuilder().append(blowlevel2).toString());
                    ((TextView) findViewById(R.id.air_sp_seatheat_left)).setTextColor(-16711936);
                    break;
                } else {
                    ((TextView) findViewById(R.id.air_sp_seatheat_left)).setText("0");
                    ((TextView) findViewById(R.id.air_sp_seatheat_left)).setTextColor(-1);
                    break;
                }
            default:
                View findViewById2 = findViewById(R.id.air_sp_seatheat_left);
                if (vel != 0) {
                    i = 2130839302;
                }
                findViewById2.setBackgroundResource(i);
                ((TextView) findViewById(R.id.air_sp_seatheat_left)).setText(new StringBuilder().append(vel).toString());
                break;
        }
    }

    
    public void mUpdateHeatRight() {
        int blowlevel;
        int heatlevel;
        int blowlevel2;
        int heatlevel2;
        int i = R.drawable.ic_air_sp_seatheat_right;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
            case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng /* 655708 */:
            case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng1 /* 721244 */:
            case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng2 /* 786780 */:
            case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
            case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
            case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
            case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
                if (((vel >> 3) & 1) == 1) {
                    blowlevel = ((vel ^ (-1)) & 15) + 1;
                    heatlevel = 0;
                } else {
                    blowlevel = 0;
                    heatlevel = vel;
                }
                View findViewById = findViewById(R.id.air_sp_seatheat_right);
                if (heatlevel != 0) {
                    i = 2130839304;
                }
                findViewById.setBackgroundResource(i);
                ((TextView) findViewById(R.id.air_sp_seatheat_right)).setText(new StringBuilder().append(heatlevel).toString());
                findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(blowlevel == 0 ? R.drawable.ic_air_sp_seatwind_right : R.drawable.ic_air_sp_seatwind_right_p);
                ((TextView) findViewById(R.id.air_sp_seatwind_right)).setText(new StringBuilder().append(blowlevel).toString());
                break;
            case FinalCanbus.CAR_453_LZ_LandRover_13_CD /* 9175493 */:
            case FinalCanbus.CAR_453_LZ_LandRover_18_CD /* 9241029 */:
            case FinalCanbus.CAR_453_LZ_Jaguar_12_CD /* 9306565 */:
            case FinalCanbus.CAR_454_LZ_LandRover_CD_Discovery5 /* 13894086 */:
                if ((vel & 8) != 0) {
                    blowlevel2 = 16 - vel;
                    heatlevel2 = 0;
                } else {
                    blowlevel2 = 0;
                    heatlevel2 = vel;
                }
                if (blowlevel2 == 0 && heatlevel2 != 0) {
                    ((TextView) findViewById(R.id.air_sp_seatheat_right)).setText(new StringBuilder().append(heatlevel2).toString());
                    ((TextView) findViewById(R.id.air_sp_seatheat_right)).setTextColor(-65536);
                    break;
                } else if (blowlevel2 != 0 && heatlevel2 == 0) {
                    ((TextView) findViewById(R.id.air_sp_seatheat_right)).setText(new StringBuilder().append(blowlevel2).toString());
                    ((TextView) findViewById(R.id.air_sp_seatheat_right)).setTextColor(-16711936);
                    break;
                } else {
                    ((TextView) findViewById(R.id.air_sp_seatheat_right)).setText("0");
                    ((TextView) findViewById(R.id.air_sp_seatheat_right)).setTextColor(-1);
                    break;
                }
            default:
                View findViewById2 = findViewById(R.id.air_sp_seatheat_right);
                if (vel != 0) {
                    i = 2130839304;
                }
                findViewById2.setBackgroundResource(i);
                ((TextView) findViewById(R.id.air_sp_seatheat_right)).setText(new StringBuilder().append(vel).toString());
                break;
        }
    }

    
    public void mUpdateWindLeft() {
        int blowlevel;
        int heatlevel;
        int i = R.drawable.ic_air_sp_seatwind_left;
        int i2 = R.drawable.ic_air_sp_seatheat_left;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_LEFT];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
            case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng /* 655708 */:
            case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng1 /* 721244 */:
            case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng2 /* 786780 */:
            case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
            case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
            case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
            case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
                if (((vel >> 3) & 1) == 1) {
                    blowlevel = ((vel ^ (-1)) & 15) + 1;
                    heatlevel = 0;
                } else {
                    blowlevel = 0;
                    heatlevel = vel;
                }
                View findViewById = findViewById(R.id.air_sp_seatheat_left);
                if (heatlevel != 0) {
                    i2 = 2130839302;
                }
                findViewById.setBackgroundResource(i2);
                ((TextView) findViewById(R.id.air_sp_seatheat_left)).setText(new StringBuilder().append(heatlevel).toString());
                findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(blowlevel == 0 ? 2130839313 : R.drawable.ic_air_sp_seatwind_left_p);
                ((TextView) findViewById(R.id.air_sp_seatwind_left)).setText(new StringBuilder().append(blowlevel).toString());
                break;
            case FinalCanbus.CAR_453_LZ_LandRover_13_CD /* 9175493 */:
            case FinalCanbus.CAR_453_LZ_LandRover_18_CD /* 9241029 */:
            case FinalCanbus.CAR_453_LZ_Jaguar_12_CD /* 9306565 */:
            case FinalCanbus.CAR_454_LZ_LandRover_CD_Discovery5 /* 13894086 */:
                View findViewById2 = findViewById(R.id.air_sp_seatheat_left);
                if (vel != 0) {
                    i2 = 2130839302;
                }
                findViewById2.setBackgroundResource(i2);
                break;
            default:
                View findViewById3 = findViewById(R.id.air_sp_seatwind_left);
                if (vel != 0) {
                    i = R.drawable.ic_air_sp_seatwind_left_p;
                }
                findViewById3.setBackgroundResource(i);
                ((TextView) findViewById(R.id.air_sp_seatwind_left)).setText(new StringBuilder().append(vel).toString());
                break;
        }
    }

    
    public void mUpdateWindRight() {
        int blowlevel;
        int heatlevel;
        int i = R.drawable.ic_air_sp_seatwind_right;
        int i2 = R.drawable.ic_air_sp_seatheat_right;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_RIGHT];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
            case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng /* 655708 */:
            case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng1 /* 721244 */:
            case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng2 /* 786780 */:
            case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
            case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
            case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
            case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
                if (((vel >> 3) & 1) == 1) {
                    blowlevel = ((vel ^ (-1)) & 15) + 1;
                    heatlevel = 0;
                } else {
                    blowlevel = 0;
                    heatlevel = vel;
                }
                View findViewById = findViewById(R.id.air_sp_seatheat_right);
                if (heatlevel != 0) {
                    i2 = 2130839304;
                }
                findViewById.setBackgroundResource(i2);
                ((TextView) findViewById(R.id.air_sp_seatheat_right)).setText(new StringBuilder().append(heatlevel).toString());
                findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(blowlevel == 0 ? 2130839315 : R.drawable.ic_air_sp_seatwind_right_p);
                ((TextView) findViewById(R.id.air_sp_seatwind_right)).setText(new StringBuilder().append(blowlevel).toString());
                break;
            case FinalCanbus.CAR_453_LZ_LandRover_13_CD /* 9175493 */:
            case FinalCanbus.CAR_453_LZ_LandRover_18_CD /* 9241029 */:
            case FinalCanbus.CAR_453_LZ_Jaguar_12_CD /* 9306565 */:
            case FinalCanbus.CAR_454_LZ_LandRover_CD_Discovery5 /* 13894086 */:
                View findViewById2 = findViewById(R.id.air_sp_seatheat_right);
                if (vel != 0) {
                    i2 = 2130839304;
                }
                findViewById2.setBackgroundResource(i2);
                break;
            default:
                View findViewById3 = findViewById(R.id.air_sp_seatwind_right);
                if (vel != 0) {
                    i = R.drawable.ic_air_sp_seatwind_right_p;
                }
                findViewById3.setBackgroundResource(i);
                ((TextView) findViewById(R.id.air_sp_seatwind_right)).setText(new StringBuilder().append(vel).toString());
                break;
        }
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT];
        if (((TextView) findViewById(R.id.air_sp_temp_left)) != null) {
            if (temp == ConstAllAirDara.TEMPERATURE_LOW) {
                switch (DataCanbus.DATA[1000]) {
                    case 406:
                    case 416:
                    case 422:
                    case FinalCanbus.CAR_WC2_CHANGANCX7 /* 65664 */:
                    case FinalCanbus.CAR_XFY_CYT_NaZhiJieU6_ShuPin /* 65826 */:
                    case FinalCanbus.CAR_RZC_17HaiMaS7 /* 65958 */:
                    case FinalCanbus.CAR_WC2_ShuPingKeLuZi /* 131417 */:
                    case FinalCanbus.CAR_XFY_XP1_ZhongTaiSR7_H /* 131478 */:
                    case FinalCanbus.CAR_WC2_RongWei_I5 /* 131488 */:
                    case FinalCanbus.CAR_CYT_OuLande_L /* 196833 */:
                    case FinalCanbus.CAR_XFY_ZhongHuaV3 /* 196934 */:
                    case FinalCanbus.CAR_WC2_RongWei_I6 /* 197024 */:
                    case FinalCanbus.CAR_BNR_CX70 /* 262214 */:
                    case FinalCanbus.CAR_WC2_CHANGAN_19KeSai /* 262272 */:
                    case FinalCanbus.CAR_RZC_XP1_RongWei_RX5 /* 262417 */:
                    case FinalCanbus.CAR_XFY_ZhongHuaV3_H /* 262470 */:
                    case FinalCanbus.CAR_WC2_RongWei_EI6 /* 262560 */:
                    case FinalCanbus.CAR_WC2_CHANGAN_19KeSai_Hand /* 327808 */:
                    case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS_S /* 328025 */:
                    case FinalCanbus.CAR_WC2_RongWei_RX3 /* 328096 */:
                    case FinalCanbus.CAR_OD_RZC_FuMeiLai /* 328102 */:
                    case FinalCanbus.CAR_BNR_16CS75_L /* 393286 */:
                    case FinalCanbus.CAR_BNR_16CS75_M /* 458822 */:
                    case FinalCanbus.CAR_WC2_RongWei_I5_H /* 459168 */:
                    case FinalCanbus.CAR_BNR_16CS75_H_RightCamera /* 524358 */:
                    case FinalCanbus.CAR_BNR_SR7 /* 524553 */:
                    case FinalCanbus.CAR_XFY_CYT_NaZhiJieU6_ShuPin_H /* 524578 */:
                    case FinalCanbus.CAR_WC2_ShuPingKeLuZi_Auto /* 524633 */:
                    case FinalCanbus.CAR_BNR_16CS75_H_FullView /* 589894 */:
                    case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao_L /* 590169 */:
                    case FinalCanbus.CAR_BNR_17CS75 /* 655430 */:
                    case FinalCanbus.CAR_RZC_BenTeng_19B50_HAND /* 655773 */:
                    case FinalCanbus.CAR_WC2_RongWei_I6_17_low /* 655776 */:
                    case FinalCanbus.CAR_RZC_BenTeng_19B50_AUTO /* 721309 */:
                    case FinalCanbus.CAR_BNR_19COS /* 917574 */:
                    case FinalCanbus.CAR_BNR_17CX70 /* 983110 */:
                    case FinalCanbus.CAR_BNR_17CX70_M /* 1048646 */:
                    case FinalCanbus.CAR_BNR_17CX70_H /* 1114182 */:
                    case FinalCanbus.CAR_XP1_Meiganna4_TR_HAND /* 1245558 */:
                    case FinalCanbus.CAR_RZC_17Rongwei_EI6 /* 1573137 */:
                    case FinalCanbus.CAR_439_Oudi_Haval_H3 /* 1704375 */:
                    case FinalCanbus.CAR_454_OD_Jianghuai_SEHOL_E50A /* 2490822 */:
                    case FinalCanbus.CAR_452_Mixun_Liebao_CS9 /* 2687428 */:
                    case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5 /* 2818501 */:
                    case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5_H /* 2884037 */:
                    case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5 /* 3015109 */:
                    case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5_H /* 3080645 */:
                    case FinalCanbus.CAR_439_XFY_LAGAN /* 3670455 */:
                    case FinalCanbus.CAR_439_BNR_Rongwei_RX5 /* 7995831 */:
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
                    case 406:
                    case 416:
                    case 422:
                    case FinalCanbus.CAR_WC2_CHANGANCX7 /* 65664 */:
                    case FinalCanbus.CAR_XFY_CYT_NaZhiJieU6_ShuPin /* 65826 */:
                    case FinalCanbus.CAR_RZC_17HaiMaS7 /* 65958 */:
                    case FinalCanbus.CAR_WC2_ShuPingKeLuZi /* 131417 */:
                    case FinalCanbus.CAR_XFY_XP1_ZhongTaiSR7_H /* 131478 */:
                    case FinalCanbus.CAR_WC2_RongWei_I5 /* 131488 */:
                    case FinalCanbus.CAR_CYT_OuLande_L /* 196833 */:
                    case FinalCanbus.CAR_XFY_ZhongHuaV3 /* 196934 */:
                    case FinalCanbus.CAR_WC2_RongWei_I6 /* 197024 */:
                    case FinalCanbus.CAR_BNR_CX70 /* 262214 */:
                    case FinalCanbus.CAR_WC2_CHANGAN_19KeSai /* 262272 */:
                    case FinalCanbus.CAR_RZC_XP1_RongWei_RX5 /* 262417 */:
                    case FinalCanbus.CAR_XFY_ZhongHuaV3_H /* 262470 */:
                    case FinalCanbus.CAR_WC2_RongWei_EI6 /* 262560 */:
                    case FinalCanbus.CAR_WC2_CHANGAN_19KeSai_Hand /* 327808 */:
                    case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS_S /* 328025 */:
                    case FinalCanbus.CAR_WC2_RongWei_RX3 /* 328096 */:
                    case FinalCanbus.CAR_OD_RZC_FuMeiLai /* 328102 */:
                    case FinalCanbus.CAR_BNR_16CS75_L /* 393286 */:
                    case FinalCanbus.CAR_BNR_16CS75_M /* 458822 */:
                    case FinalCanbus.CAR_WC2_RongWei_I5_H /* 459168 */:
                    case FinalCanbus.CAR_BNR_16CS75_H_RightCamera /* 524358 */:
                    case FinalCanbus.CAR_BNR_SR7 /* 524553 */:
                    case FinalCanbus.CAR_XFY_CYT_NaZhiJieU6_ShuPin_H /* 524578 */:
                    case FinalCanbus.CAR_WC2_ShuPingKeLuZi_Auto /* 524633 */:
                    case FinalCanbus.CAR_BNR_16CS75_H_FullView /* 589894 */:
                    case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao_L /* 590169 */:
                    case FinalCanbus.CAR_BNR_17CS75 /* 655430 */:
                    case FinalCanbus.CAR_RZC_BenTeng_19B50_HAND /* 655773 */:
                    case FinalCanbus.CAR_WC2_RongWei_I6_17_low /* 655776 */:
                    case FinalCanbus.CAR_RZC_BenTeng_19B50_AUTO /* 721309 */:
                    case FinalCanbus.CAR_BNR_19COS /* 917574 */:
                    case FinalCanbus.CAR_BNR_17CX70 /* 983110 */:
                    case FinalCanbus.CAR_BNR_17CX70_M /* 1048646 */:
                    case FinalCanbus.CAR_BNR_17CX70_H /* 1114182 */:
                    case FinalCanbus.CAR_XP1_Meiganna4_TR_HAND /* 1245558 */:
                    case FinalCanbus.CAR_RZC_17Rongwei_EI6 /* 1573137 */:
                    case FinalCanbus.CAR_439_Oudi_Haval_H3 /* 1704375 */:
                    case FinalCanbus.CAR_454_OD_Jianghuai_SEHOL_E50A /* 2490822 */:
                    case FinalCanbus.CAR_452_Mixun_Liebao_CS9 /* 2687428 */:
                    case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5 /* 2818501 */:
                    case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5_H /* 2884037 */:
                    case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5 /* 3015109 */:
                    case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5_H /* 3080645 */:
                    case FinalCanbus.CAR_439_XFY_LAGAN /* 3670455 */:
                    case FinalCanbus.CAR_439_BNR_Rongwei_RX5 /* 7995831 */:
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
                    case 406:
                    case 416:
                    case 422:
                    case FinalCanbus.CAR_WC2_CHANGANCX7 /* 65664 */:
                    case FinalCanbus.CAR_XFY_CYT_NaZhiJieU6_ShuPin /* 65826 */:
                    case FinalCanbus.CAR_RZC_17HaiMaS7 /* 65958 */:
                    case FinalCanbus.CAR_WC2_ShuPingKeLuZi /* 131417 */:
                    case FinalCanbus.CAR_XFY_XP1_ZhongTaiSR7_H /* 131478 */:
                    case FinalCanbus.CAR_WC2_RongWei_I5 /* 131488 */:
                    case FinalCanbus.CAR_CYT_OuLande_L /* 196833 */:
                    case FinalCanbus.CAR_XFY_ZhongHuaV3 /* 196934 */:
                    case FinalCanbus.CAR_WC2_RongWei_I6 /* 197024 */:
                    case FinalCanbus.CAR_BNR_CX70 /* 262214 */:
                    case FinalCanbus.CAR_WC2_CHANGAN_19KeSai /* 262272 */:
                    case FinalCanbus.CAR_RZC_XP1_RongWei_RX5 /* 262417 */:
                    case FinalCanbus.CAR_XFY_ZhongHuaV3_H /* 262470 */:
                    case FinalCanbus.CAR_WC2_RongWei_EI6 /* 262560 */:
                    case FinalCanbus.CAR_WC2_CHANGAN_19KeSai_Hand /* 327808 */:
                    case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS_S /* 328025 */:
                    case FinalCanbus.CAR_WC2_RongWei_RX3 /* 328096 */:
                    case FinalCanbus.CAR_OD_RZC_FuMeiLai /* 328102 */:
                    case FinalCanbus.CAR_BNR_16CS75_L /* 393286 */:
                    case FinalCanbus.CAR_BNR_16CS75_M /* 458822 */:
                    case FinalCanbus.CAR_WC2_RongWei_I5_H /* 459168 */:
                    case FinalCanbus.CAR_BNR_16CS75_H_RightCamera /* 524358 */:
                    case FinalCanbus.CAR_BNR_SR7 /* 524553 */:
                    case FinalCanbus.CAR_XFY_CYT_NaZhiJieU6_ShuPin_H /* 524578 */:
                    case FinalCanbus.CAR_WC2_ShuPingKeLuZi_Auto /* 524633 */:
                    case FinalCanbus.CAR_BNR_16CS75_H_FullView /* 589894 */:
                    case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao_L /* 590169 */:
                    case FinalCanbus.CAR_BNR_17CS75 /* 655430 */:
                    case FinalCanbus.CAR_RZC_BenTeng_19B50_HAND /* 655773 */:
                    case FinalCanbus.CAR_WC2_RongWei_I6_17_low /* 655776 */:
                    case FinalCanbus.CAR_RZC_BenTeng_19B50_AUTO /* 721309 */:
                    case FinalCanbus.CAR_BNR_19COS /* 917574 */:
                    case FinalCanbus.CAR_BNR_17CX70 /* 983110 */:
                    case FinalCanbus.CAR_BNR_17CX70_M /* 1048646 */:
                    case FinalCanbus.CAR_BNR_17CX70_H /* 1114182 */:
                    case FinalCanbus.CAR_XP1_Meiganna4_TR_HAND /* 1245558 */:
                    case FinalCanbus.CAR_RZC_17Rongwei_EI6 /* 1573137 */:
                    case FinalCanbus.CAR_439_Oudi_Haval_H3 /* 1704375 */:
                    case FinalCanbus.CAR_454_OD_Jianghuai_SEHOL_E50A /* 2490822 */:
                    case FinalCanbus.CAR_452_Mixun_Liebao_CS9 /* 2687428 */:
                    case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5 /* 2818501 */:
                    case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5_H /* 2884037 */:
                    case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5 /* 3015109 */:
                    case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5_H /* 3080645 */:
                    case FinalCanbus.CAR_439_XFY_LAGAN /* 3670455 */:
                    case FinalCanbus.CAR_439_BNR_Rongwei_RX5 /* 7995831 */:
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
                case 38:
                case 40:
                case 80:
                case 101:
                case 231:
                case 317:
                case 369:
                case 414:
                case 433:
                case FinalCanbus.CAR_CYT_GaoErFu7 /* 65576 */:
                case FinalCanbus.CAR_DJ_MENGDIOU2013_H /* 65767 */:
                case FinalCanbus.CAR_DJ_ShuPing_MENGDIOU /* 65836 */:
                case FinalCanbus.CAR_WeiChi2_XTS /* 65853 */:
                case FinalCanbus.CAR_CYT_DaZhongZiDongKongTiao_H /* 65905 */:
                case FinalCanbus.CAR_XC_08TianLai_LOW /* 65924 */:
                case FinalCanbus.CAR_BSD_XP1_SHUPING_RENAULT_KeLeiAo /* 65938 */:
                case FinalCanbus.CAR_XFY_XP1_ChangAnCsSerial /* 65942 */:
                case FinalCanbus.CAR_WC1_Nawala_Philippine /* 131110 */:
                case FinalCanbus.CAR_CYT_GaoErFu7_M /* 131112 */:
                case FinalCanbus.CAR_RZC_XP1_QiJun_H /* 131152 */:
                case FinalCanbus.CAR_WC1_QiJun_H /* 131173 */:
                case FinalCanbus.CAR_CYT_ShuPing_HavalH2 /* 131316 */:
                case FinalCanbus.CAR_XP_CYT_ShuPing_YeMa_L /* 131372 */:
                case FinalCanbus.CAR_WeiChi2_XTS_SEATHEAT /* 131389 */:
                case FinalCanbus.CAR_CYT_LangYi_L /* 131441 */:
                case FinalCanbus.CAR_BSD_XP1_SHUPING_RENAULT_KeLeiAo_H /* 131474 */:
                case FinalCanbus.CAR_452_BaoGu_Renault_17Koleos /* 131524 */:
                case FinalCanbus.CAR_CYT_GaoErFu7_H /* 196648 */:
                case FinalCanbus.CAR_XP1_QiJun_CYT_ZIDONG /* 196751 */:
                case FinalCanbus.CAR_CYT_ShuPing_HavalH2_H /* 196852 */:
                case FinalCanbus.CAR_XP_CYT_ShuPing_YeMa_H /* 196908 */:
                case FinalCanbus.CAR_WeiChi2_ATS_H /* 196925 */:
                case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao /* 196953 */:
                case FinalCanbus.CAR_CYT_LangYi_H /* 196977 */:
                case FinalCanbus.CAR_452_BaoGu_Renault_18Koleos /* 197060 */:
                case FinalCanbus.CAR_XP1_QiJun_CYT_ZIDONG_H /* 262287 */:
                case FinalCanbus.CAR_DJ_Shuping_YEMA /* 262444 */:
                case FinalCanbus.CAR_WeiChi2_SRX /* 262461 */:
                case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS /* 262489 */:
                case FinalCanbus.CAR_CYT_ShouDongKongTiao /* 262513 */:
                case FinalCanbus.CAR_XP1_QiJun_CYT_SHOUDONG /* 327823 */:
                case FinalCanbus.CAR_WeiChi2_15SRX /* 327997 */:
                case FinalCanbus.CAR_XP1_KeLeiAo_L /* 328054 */:
                case FinalCanbus.CAR_WC1_17QiJun /* 393317 */:
                case FinalCanbus.CAR_WeiChi2_18XTS /* 393533 */:
                case FinalCanbus.CAR_XP1_KeLeiAo_H /* 393590 */:
                case FinalCanbus.CAR_WC1_17QiJun_H /* 458853 */:
                case FinalCanbus.CAR_XP1_CYT_XuanYi_L /* 458895 */:
                case FinalCanbus.CAR_WeiChi2_18ATS /* 459069 */:
                case FinalCanbus.CAR_WC2_ShuPing10JunYue /* 459097 */:
                case FinalCanbus.CAR_WC1_Tuda /* 524389 */:
                case FinalCanbus.CAR_XP1_CYT_XuanYi_H /* 524431 */:
                case FinalCanbus.CAR_WeiChi2_NewJunYue /* 524605 */:
                case FinalCanbus.CAR_WC1_19QiJun /* 589925 */:
                case FinalCanbus.CAR_WC1_Tuda_Hand /* 655461 */:
                case FinalCanbus.CAR_WC1_Nawala /* 720997 */:
                case FinalCanbus.CAR_XP1_15QiJun_Shuping /* 721039 */:
                case FinalCanbus.CAR_WC1_Tuda_H /* 852069 */:
                case FinalCanbus.CAR_XP1_Meiganna4_TR_AUTO /* 1311094 */:
                case FinalCanbus.CAR_443_WC2_TOYOTA_09HG /* 1376699 */:
                case FinalCanbus.CAR_XP_Renault_23KOLEOS_L_Auto /* 1442216 */:
                case FinalCanbus.CAR_443_WC2_TOYOTA_09RAV4 /* 1442235 */:
                case FinalCanbus.CAR_XP_Renault_23KOLEOS_L_Hand /* 1507752 */:
                case FinalCanbus.CAR_XP_Renault_23KOLEOS_H_Auto /* 1573288 */:
                case FinalCanbus.CAR_443_WC2_TOYOTA_08Camery /* 1573307 */:
                case FinalCanbus.CAR_XP1_Meiganna4_TR_AUTO_H /* 1769846 */:
                case FinalCanbus.CAR_452_BaoGu_Renault_17Koleos_M /* 2818500 */:
                case FinalCanbus.CAR_452_BaoGu_Renault_17Koleos_H /* 2884036 */:
                case FinalCanbus.CAR_452_BaoGu_Renault_18Koleos_M /* 3015108 */:
                case FinalCanbus.CAR_452_BaoGu_Renault_18Koleos_H /* 3080644 */:
                case FinalCanbus.CAR_XP1_RAM1500_H_AUTO /* 4194678 */:
                case FinalCanbus.CAR_439_RZC_YinFeiNiDi_QX50 /* 6029751 */:
                case FinalCanbus.CAR_452_OD_Nissan_Tule_low /* 6095300 */:
                case FinalCanbus.CAR_439_DJ_Nissan /* 12779959 */:
                case FinalCanbus.CAR_439_DJ_Nissan_H /* 12845495 */:
                case FinalCanbus.CAR_439_XFY_Keleiao_17_L /* 13631927 */:
                case FinalCanbus.CAR_439_XFY_Keleiao_17_H /* 13697463 */:
                case FinalCanbus.CAR_439_XFY_Keleiao_18_L /* 13762999 */:
                case FinalCanbus.CAR_439_XFY_Keleiao_18_H /* 13828535 */:
                case FinalCanbus.CAR_452_CYT_Toyota_Tundra_H /* 14025156 */:
                    int temp2 = temp * 5;
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp2 / 10) + "." + (temp2 % 10));
                    mUpdateTempUNITLeft();
                    break;
                case 274:
                case FinalCanbus.CAR_DJ_XP1_ACCORD7_H /* 65810 */:
                case FinalCanbus.CAR_RZC_19MingjueHS /* 852241 */:
                case FinalCanbus.CAR_RZC_19MingjueHS_H /* 1048849 */:
                case FinalCanbus.CAR_454_OD_Qichen_D60_EV /* 9961926 */:
                case FinalCanbus.CAR_454_OD_Beiqi_EV160 /* 10879430 */:
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(temp).toString());
                    mUpdateTempUNITLeft();
                    break;
                case 280:
                case 407:
                case FinalCanbus.CAR_DaoJun_XINPU_ChuanQiGs4_H /* 65943 */:
                case FinalCanbus.CAR_BNR_ChuanQiGS4 /* 327960 */:
                case FinalCanbus.CAR_BNR_ChuanQiGS4_H /* 393496 */:
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp / 100) + "." + ((temp % 100) / 10));
                    mUpdateTempUNITLeft();
                    break;
                case 327:
                case 443:
                case FinalCanbus.CAR_CYT_ShuPing_ChuanQiGS4 /* 65816 */:
                case FinalCanbus.CAR_HC_OLD_TianLai_H /* 65863 */:
                case FinalCanbus.CAR_HC_OLD_YinFeiNiDi_Fx35 /* 131399 */:
                case FinalCanbus.CAR_CYT_Haval_H6_ShuPing /* 196739 */:
                case FinalCanbus.CAR_CYT_SHuPing_SoNaTa8 /* 196776 */:
                case FinalCanbus.CAR_452_XC_05_TianLai /* 196935 */:
                case FinalCanbus.CAR_CYT_SHuPing_SoNaTa8_H /* 262312 */:
                case FinalCanbus.CAR_XC_OLD_YinFeiNiDi_Fx35 /* 262471 */:
                case FinalCanbus.CAR_CYT_SHuPing_SoNaTa8_D /* 327848 */:
                case FinalCanbus.CAR_444_WC2_ChangfengLiebao_CS9_17 /* 1769916 */:
                case FinalCanbus.CAR_439_XBS_NISSAN_TuLe /* 2425271 */:
                case FinalCanbus.CAR_439_XBS_NISSAN_TuLe_ALLV /* 3342775 */:
                case FinalCanbus.CAR_443_WC2_OULANDE_H /* 7012795 */:
                case FinalCanbus.CAR_452_CYT_Toyota_Tundra /* 13959620 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(((temp * 9) + 320) / 10).toString());
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(((temp * 5) / 10) + "." + ((temp * 5) % 10));
                    }
                    mUpdateTempUNITLeft();
                    break;
                case 363:
                case 388:
                case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
                case FinalCanbus.CAR_DAOJUN_XP1_ShuPingNewJunWei_M /* 65899 */:
                case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
                case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng /* 655708 */:
                case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng1 /* 721244 */:
                case FinalCanbus.CAR_455_RZC_Mclaren_12C /* 721351 */:
                case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng2 /* 786780 */:
                case FinalCanbus.CAR_DAOJUN_OD_ATS /* 852316 */:
                case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
                case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
                case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
                case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
                case FinalCanbus.CAR_453_LZ_AstonMartin /* 1376709 */:
                case FinalCanbus.CAR_453_RZC_Mclaren_16_560S /* 4915653 */:
                case FinalCanbus.CAR_453_RZC_Mclaren_19_720S /* 4981189 */:
                case FinalCanbus.CAR_453_LZ_LandRover_13_CD /* 9175493 */:
                case FinalCanbus.CAR_453_LZ_LandRover_18_CD /* 9241029 */:
                case FinalCanbus.CAR_453_LZ_Jaguar_12_CD /* 9306565 */:
                case FinalCanbus.CAR_452_LZ_Maserati_SP /* 12255684 */:
                case FinalCanbus.CAR_454_LZ_LandRover_CD_Discovery5 /* 13894086 */:
                case FinalCanbus.CAR_452_LUZ_LANDROVER_CYTAIR /* 15729092 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(((temp * 9) / 10) + 32).toString());
                    } else {
                        int temp3 = temp * 5;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp3 / 10) + "." + (temp3 % 10));
                    }
                    mUpdateTempUNITLeft();
                    break;
                case 406:
                case 422:
                case FinalCanbus.CAR_RZC_17HaiMaS7 /* 65958 */:
                case FinalCanbus.CAR_XFY_XP1_ZhongTaiSR7_H /* 131478 */:
                case FinalCanbus.CAR_BNR_SR7 /* 524553 */:
                    int temp4 = (temp * 10) + 170;
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp4 / 10) + "." + (temp4 % 10));
                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp4 / 10) + "." + (temp4 % 10));
                    mUpdateTempUNITLeft();
                    mUpdateTempUNITRight();
                    break;
                case 416:
                case FinalCanbus.CAR_WC2_CHANGANCX7 /* 65664 */:
                case FinalCanbus.CAR_XFY_CYT_NaZhiJieU6_ShuPin /* 65826 */:
                case FinalCanbus.CAR_WC2_RongWei_I5 /* 131488 */:
                case FinalCanbus.CAR_WC2_RongWei_I6 /* 197024 */:
                case FinalCanbus.CAR_WC2_CHANGAN_19KeSai /* 262272 */:
                case FinalCanbus.CAR_WC2_RongWei_EI6 /* 262560 */:
                case FinalCanbus.CAR_WC2_RongWei_RX3 /* 328096 */:
                case FinalCanbus.CAR_OD_RZC_FuMeiLai /* 328102 */:
                case FinalCanbus.CAR_WC2_RongWei_I5_H /* 459168 */:
                case FinalCanbus.CAR_XFY_CYT_NaZhiJieU6_ShuPin_H /* 524578 */:
                case FinalCanbus.CAR_RZC_BenTeng_19B50_HAND /* 655773 */:
                case FinalCanbus.CAR_WC2_RongWei_I6_17_low /* 655776 */:
                case FinalCanbus.CAR_RZC_BenTeng_19B50_AUTO /* 721309 */:
                case FinalCanbus.CAR_BNR_19COS /* 917574 */:
                case FinalCanbus.CAR_XP1_Meiganna4_TR_HAND /* 1245558 */:
                case FinalCanbus.CAR_439_XFY_LAGAN /* 3670455 */:
                    int temp5 = temp * 5;
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp5 / 10) + "." + (temp5 % 10));
                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp5 / 10) + "." + (temp5 % 10));
                    mUpdateTempUNITLeft();
                    mUpdateTempUNITRight();
                    break;
                case FinalCanbus.CAR_WC1_CYT_ShuPing_07_11_MENGDIOU /* 65759 */:
                case FinalCanbus.CAR_XFY_Haval_H6_ShuPing /* 131203 */:
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
                        mUpdateTempUNITLeft();
                        break;
                    }
                case FinalCanbus.CAR_WC1_ShuPing_ZhiSheng_High /* 131295 */:
                    int temp6 = (temp * 5) - 400;
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp6 / 10) + "." + (temp6 % 10));
                    mUpdateTempUNITLeft();
                    break;
                case FinalCanbus.CAR_WC2_ShuPingKeLuZi /* 131417 */:
                case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS_S /* 328025 */:
                case FinalCanbus.CAR_WC2_ShuPingKeLuZi_Auto /* 524633 */:
                case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao_L /* 590169 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        int temp7 = ((temp * 9) / 10) + 32;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(temp7).toString());
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(temp7).toString());
                        mUpdateTempUNITLeft();
                        mUpdateTempUNITRight();
                        break;
                    } else {
                        int temp8 = temp * 5;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp8 / 10) + "." + (temp8 % 10));
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp8 / 10) + "." + (temp8 % 10));
                        mUpdateTempUNITLeft();
                        mUpdateTempUNITRight();
                        break;
                    }
                case FinalCanbus.CAR_OuDi_06Prado /* 196822 */:
                    if (temp <= 28 && temp >= 1) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(((temp * 5) + 160) / 10.0f).toString());
                        mUpdateTempUNITLeft();
                        break;
                    } else if (temp <= 36 && temp >= 32) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(((temp * 5) + 140) / 10.0f).toString());
                        mUpdateTempUNITLeft();
                        break;
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("--");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                        break;
                    }
                case FinalCanbus.CAR_CYT_OuLande_L /* 196833 */:
                case FinalCanbus.CAR_XFY_ZhongHuaV3 /* 196934 */:
                case FinalCanbus.CAR_XFY_ZhongHuaV3_H /* 262470 */:
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp / 10) + "." + (temp % 10));
                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp / 10) + "." + (temp % 10));
                    mUpdateTempUNITLeft();
                    mUpdateTempUNITRight();
                    break;
                case FinalCanbus.CAR_BNR_CX70 /* 262214 */:
                case FinalCanbus.CAR_BNR_16CS75_L /* 393286 */:
                case FinalCanbus.CAR_BNR_16CS75_M /* 458822 */:
                case FinalCanbus.CAR_BNR_16CS75_H_RightCamera /* 524358 */:
                case FinalCanbus.CAR_BNR_16CS75_H_FullView /* 589894 */:
                case FinalCanbus.CAR_BNR_17CS75 /* 655430 */:
                case FinalCanbus.CAR_BNR_17CX70 /* 983110 */:
                case FinalCanbus.CAR_BNR_17CX70_M /* 1048646 */:
                case FinalCanbus.CAR_BNR_17CX70_H /* 1114182 */:
                    if (temp < 15 && temp > 0) {
                        int temp9 = temp + 16;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(temp9 / 1.0f).toString());
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(temp9 / 1.0f).toString());
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
                case FinalCanbus.CAR_RZC_XP1_RongWei_RX5 /* 262417 */:
                case FinalCanbus.CAR_RZC_17Rongwei_EI6 /* 1573137 */:
                case FinalCanbus.CAR_454_OD_Jianghuai_SEHOL_E50A /* 2490822 */:
                case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5 /* 2818501 */:
                case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5_H /* 2884037 */:
                case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5 /* 3015109 */:
                case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5_H /* 3080645 */:
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(temp).toString());
                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(temp).toString());
                    mUpdateTempUNITLeft();
                    mUpdateTempUNITRight();
                    break;
                case FinalCanbus.CAR_WC2_CHANGAN_19KeSai_Hand /* 327808 */:
                    int temp10 = temp + 15;
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(temp10).toString());
                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(temp10).toString());
                    mUpdateTempUNITLeft();
                    mUpdateTempUNITRight();
                    break;
                case FinalCanbus.CAR_BNR_BoYue /* 459017 */:
                    int temp11 = (temp * 10) + 170;
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp11 / 10) + "." + (temp11 % 10));
                    mUpdateTempUNITLeft();
                    break;
                case FinalCanbus.CAR_XP1_YearGmcSeries_NoAir /* 459164 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(((temp * 9) / 50) + 32).toString());
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp / 10) + "." + (temp % 10));
                    }
                    mUpdateTempUNITLeft();
                    break;
                case FinalCanbus.CAR_355_HC_XIANDAI /* 590179 */:
                case FinalCanbus.CAR_355_HC_XIANDAI_AMP /* 655715 */:
                case FinalCanbus.CAR_439_HC_OuGeTL /* 3998135 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(((temp * 9) + 626) / 10).toString());
                    } else {
                        int temp12 = (temp * 5) + 170;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp12 / 10) + "." + (temp12 % 10));
                    }
                    mUpdateTempUNITLeft();
                    break;
                case FinalCanbus.CAR_XP1_RAM1500 /* 655734 */:
                case FinalCanbus.CAR_XP1_RAM1500_M /* 4063606 */:
                case FinalCanbus.CAR_XP1_RAM1500_H /* 4129142 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(temp + 27).toString());
                    } else {
                        int temp13 = temp * 5;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp13 / 10) + "." + (temp13 % 10));
                    }
                    mUpdateTempUNITLeft();
                    break;
                case FinalCanbus.CAR_WC1_Nawala_Hand /* 786533 */:
                case FinalCanbus.CAR_455_TD_INFINIT_ESQ /* 1704391 */:
                case FinalCanbus.CAR_455_TD_INFINIT_G /* 1769927 */:
                case FinalCanbus.CAR_455_TD_INFINIT_QX50 /* 1835463 */:
                case FinalCanbus.CAR_455_TD_INFINIT_06FX /* 1900999 */:
                case FinalCanbus.CAR_455_TD_INFINIT_08FX /* 1966535 */:
                case FinalCanbus.CAR_455_TD_INFINIT_14QX70 /* 2032071 */:
                case FinalCanbus.CAR_455_TD_INFINIT_12FX /* 2097607 */:
                    int temp14 = temp * 5;
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp14 / 10) + "." + (temp14 % 10));
                    ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                    break;
                case FinalCanbus.CAR_439_Oudi_Haval_H3 /* 1704375 */:
                case FinalCanbus.CAR_452_Mixun_Liebao_CS9 /* 2687428 */:
                    int temp15 = (temp * 5) + 175;
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp15 / 10) + "." + (temp15 % 10));
                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp15 / 10) + "." + (temp15 % 10));
                    mUpdateTempUNITLeft();
                    mUpdateTempUNITRight();
                    break;
                case FinalCanbus.CAR_RZC3_XianDai_I30_15 /* 1835370 */:
                case FinalCanbus.CAR_RZC3_XianDai_CEED_11 /* 1900906 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(temp).toString());
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(((temp * 5) + 170) / 10).toString());
                    }
                    mUpdateTempUNITLeft();
                    break;
                case FinalCanbus.CAR_439_OuDi_NaZhiJieU7 /* 2032055 */:
                case FinalCanbus.CAR_439_OuDi_NaZhiJieU5 /* 3932599 */:
                case FinalCanbus.CAR_452_OuDi_NaZhiJieU6 /* 11534788 */:
                    int temp16 = (temp * 5) + 170;
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp16 / 10) + "." + (temp16 % 10));
                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp16 / 10) + "." + (temp16 % 10));
                    mUpdateTempUNITLeft();
                    mUpdateTempUNITRight();
                    break;
                case FinalCanbus.CAR_453_LZ_GM_Camaro_17 /* 2163141 */:
                case FinalCanbus.CAR_453_LZ_GM_GMC_TERRAIN_17 /* 2228677 */:
                case FinalCanbus.CAR_453_LZ_GM_Equinox_17 /* 2294213 */:
                case FinalCanbus.CAR_454_LZ_GM_Camaro_17_Auto /* 6947270 */:
                case FinalCanbus.CAR_454_LZ_GM_Equinox_17_Auto /* 7012806 */:
                    if (temp >= 30 && temp <= 64) {
                        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                            ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(((temp * 9) / 10) + 32).toString());
                        } else {
                            int temp17 = temp * 5;
                            ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp17 / 10) + "." + (temp17 % 10));
                        }
                    } else if (temp >= 1 && temp <= 16) {
                        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                            ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append((((temp + 15) * 9) / 5) + 32).toString());
                        } else {
                            ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(temp + 15).toString());
                        }
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("--");
                    }
                    mUpdateTempUNITLeft();
                    break;
                case FinalCanbus.CAR_439_RZC_ZhongTaiSR9 /* 2294199 */:
                case FinalCanbus.CAR_439_RZC_ZhongTaiSR9_H /* 2359735 */:
                case FinalCanbus.CAR_439_RZC_ZhongTaiSR7 /* 7537079 */:
                case FinalCanbus.CAR_452_OD_Qirui_Xiaomayi /* 12517828 */:
                    int temp18 = (temp * 5) + 175;
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp18 / 10) + "." + (temp18 % 10));
                    mUpdateTempUNITLeft();
                    break;
                case FinalCanbus.CAR_455_LUZ_Nissan_GTR_EN /* 2621895 */:
                case FinalCanbus.CAR_439_LUZ_Nissan_GTR /* 13566391 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        if (temp >= 48) {
                            temp -= 51;
                        }
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(((temp * 9) + 635) / 10).toString());
                    } else {
                        if (temp >= 48) {
                            temp -= 51;
                        }
                        int temp19 = (temp * 5) + 175;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp19 / 10) + "." + (temp19 % 10));
                    }
                    mUpdateTempUNITLeft();
                    break;
                case FinalCanbus.CAR_453_XP1_Ford_Edge_2013 /* 4260293 */:
                case FinalCanbus.CAR_453_XP1_Ford_F150_2013 /* 4325829 */:
                case FinalCanbus.CAR_453_XP1_Ford_Explorer_2013 /* 4391365 */:
                case FinalCanbus.CAR_453_XP1_Ford_Taurus_2013 /* 4456901 */:
                case FinalCanbus.CAR_453_XP1_Ford_Expedition_2013 /* 4522437 */:
                case FinalCanbus.CAR_453_XP1_Ford_Edge_2015 /* 4587973 */:
                case FinalCanbus.CAR_453_XP1_Ford_Mustang_2015 /* 4653509 */:
                    int temp20 = temp * 5;
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp20 / 10) + "." + (temp20 % 10));
                    mUpdateTempUNITLeft();
                    break;
                case FinalCanbus.CAR_453_RZC_SWM_G05Pro_22 /* 5964229 */:
                    if (temp >= 36 && temp <= 50) {
                        int temp21 = ((temp - 12) * 10) + 18;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp21 / 10) + "." + (temp21 % 10));
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("--");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                        break;
                    }
                case FinalCanbus.CAR_439_HC_TianLai_GongJue /* 6095287 */:
                case FinalCanbus.CAR_439_HC_TianLai_GongJue_CD /* 6488503 */:
                case FinalCanbus.CAR_439_HC_Nissan_Toread /* 7012791 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(((temp * 9) + 635) / 10).toString());
                    } else {
                        int temp22 = (temp * 5) + 175;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp22 / 10) + "." + (temp22 % 10));
                    }
                    mUpdateTempUNITLeft();
                    break;
                case FinalCanbus.CAR_452_OD_Zhonghua_V6_18 /* 6160836 */:
                    int temp23 = (temp * 5) + 160;
                    ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp23 / 10) + "." + (temp23 % 10));
                    mUpdateTempUNITLeft();
                    break;
                case FinalCanbus.CAR_439_HC_Ruijie /* 6816183 */:
                case FinalCanbus.CAR_439_HC_Ruijie_H /* 6881719 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        if (temp >= 12 && temp <= 40) {
                            int temp24 = ((temp - 12) * 5) + 155;
                            ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp24 / 10) + "." + (temp24 % 10));
                            ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
                            break;
                        } else {
                            ((TextView) findViewById(R.id.air_sp_temp_left)).setText("--");
                            ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                            break;
                        }
                    } else if (temp >= 12 && temp <= 37) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append((temp - 12) + 60).toString());
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℉");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("--");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                        break;
                    }
                case FinalCanbus.CAR_439_BNR_Rongwei_RX5 /* 7995831 */:
                    if (temp < 15 && temp > 1) {
                        int temp25 = temp + 17;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(temp25 / 1.0f).toString());
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(temp25 / 1.0f).toString());
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
                case FinalCanbus.CAR_439_DJ_06_09Kayan /* 12911031 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append((((temp + 31) * 9) / 10) + 32).toString());
                    } else {
                        int temp26 = (temp * 5) + 155;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp26 / 10) + "." + (temp26 % 10));
                    }
                    mUpdateTempUNITLeft();
                    break;
                case FinalCanbus.CAR_452_XC_Honda_Acura_TL /* 12911044 */:
                case FinalCanbus.CAR_452_XC_Honda_Acura_RDX /* 12976580 */:
                case FinalCanbus.CAR_452_XC_Honda_Acura_TLX /* 13042116 */:
                    if (temp >= 1 && temp <= 29) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(((temp * 5) + 170) * 0.1f).toString());
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
                        break;
                    } else if (temp >= 32 && temp <= 34) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append((((temp - 32) * 5) + 160) * 0.1f).toString());
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
                        break;
                    } else if (temp == 35) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(320 * 0.1f).toString());
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("--");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                        break;
                    }
                case FinalCanbus.CAR_454_LZ_Nissan_370Z_L /* 14680518 */:
                case FinalCanbus.CAR_454_LZ_Nissan_370Z_TW /* 14811590 */:
                case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_L /* 15729094 */:
                case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H /* 15794630 */:
                case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_TW /* 15860166 */:
                case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H_NP /* 15925702 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp / 10) + "." + (temp % 10));
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(temp / 10).toString());
                    }
                    mUpdateTempUNITLeft();
                    break;
                case FinalCanbus.CAR_452_Luz_Audi_A4L_Low /* 14811588 */:
                case FinalCanbus.CAR_452_Luz_Audi_A4L_H /* 14877124 */:
                case FinalCanbus.CAR_452_Luz_Audi_Q5_Low /* 14942660 */:
                case FinalCanbus.CAR_452_Luz_Audi_Q5_H /* 15008196 */:
                case FinalCanbus.CAR_452_Luz_Audi_A6L_Low /* 15073732 */:
                case FinalCanbus.CAR_452_Luz_Audi_A6L_H /* 15139268 */:
                case FinalCanbus.CAR_452_Luz_Audi_Q7_Low /* 15204804 */:
                case FinalCanbus.CAR_452_Luz_Audi_Q7_H /* 15270340 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        int temp27 = (temp * 2) + 27;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℉");
                        break;
                    } else {
                        int temp28 = temp * 5;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp28 / 10) + "." + (temp28 % 10));
                        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("℃");
                        break;
                    }
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

    
    public void mUpdateTempRight() {
        switch (DataCanbus.DATA[1000]) {
            case 406:
            case 416:
            case 422:
            case FinalCanbus.CAR_WC2_CHANGANCX7 /* 65664 */:
            case FinalCanbus.CAR_XFY_CYT_NaZhiJieU6_ShuPin /* 65826 */:
            case FinalCanbus.CAR_RZC_17HaiMaS7 /* 65958 */:
            case FinalCanbus.CAR_WC2_ShuPingKeLuZi /* 131417 */:
            case FinalCanbus.CAR_XFY_XP1_ZhongTaiSR7_H /* 131478 */:
            case FinalCanbus.CAR_WC2_RongWei_I5 /* 131488 */:
            case FinalCanbus.CAR_CYT_OuLande_L /* 196833 */:
            case FinalCanbus.CAR_XFY_ZhongHuaV3 /* 196934 */:
            case FinalCanbus.CAR_WC2_RongWei_I6 /* 197024 */:
            case FinalCanbus.CAR_WC2_CHANGAN_19KeSai /* 262272 */:
            case FinalCanbus.CAR_RZC_XP1_RongWei_RX5 /* 262417 */:
            case FinalCanbus.CAR_XFY_ZhongHuaV3_H /* 262470 */:
            case FinalCanbus.CAR_WC2_RongWei_EI6 /* 262560 */:
            case FinalCanbus.CAR_WC2_CHANGAN_19KeSai_Hand /* 327808 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS_S /* 328025 */:
            case FinalCanbus.CAR_WC2_RongWei_RX3 /* 328096 */:
            case FinalCanbus.CAR_OD_RZC_FuMeiLai /* 328102 */:
            case FinalCanbus.CAR_WC2_RongWei_I5_H /* 459168 */:
            case FinalCanbus.CAR_BNR_SR7 /* 524553 */:
            case FinalCanbus.CAR_XFY_CYT_NaZhiJieU6_ShuPin_H /* 524578 */:
            case FinalCanbus.CAR_WC2_ShuPingKeLuZi_Auto /* 524633 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao_L /* 590169 */:
            case FinalCanbus.CAR_RZC_BenTeng_19B50_HAND /* 655773 */:
            case FinalCanbus.CAR_WC2_RongWei_I6_17_low /* 655776 */:
            case FinalCanbus.CAR_RZC_BenTeng_19B50_AUTO /* 721309 */:
            case FinalCanbus.CAR_XP1_Meiganna4_TR_HAND /* 1245558 */:
            case FinalCanbus.CAR_RZC_17Rongwei_EI6 /* 1573137 */:
            case FinalCanbus.CAR_439_Oudi_Haval_H3 /* 1704375 */:
            case FinalCanbus.CAR_439_OuDi_NaZhiJieU7 /* 2032055 */:
            case FinalCanbus.CAR_454_OD_Jianghuai_SEHOL_E50A /* 2490822 */:
            case FinalCanbus.CAR_452_Mixun_Liebao_CS9 /* 2687428 */:
            case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5 /* 2818501 */:
            case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5_H /* 2884037 */:
            case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5 /* 3015109 */:
            case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5_H /* 3080645 */:
            case FinalCanbus.CAR_439_XFY_LAGAN /* 3670455 */:
            case FinalCanbus.CAR_439_OuDi_NaZhiJieU5 /* 3932599 */:
            case FinalCanbus.CAR_439_BNR_Rongwei_RX5 /* 7995831 */:
            case FinalCanbus.CAR_452_OuDi_NaZhiJieU6 /* 11534788 */:
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
                            case 38:
                            case 40:
                            case 80:
                            case 101:
                            case 231:
                            case 317:
                            case 369:
                            case 414:
                            case 433:
                            case FinalCanbus.CAR_CYT_GaoErFu7 /* 65576 */:
                            case FinalCanbus.CAR_DJ_MENGDIOU2013_H /* 65767 */:
                            case FinalCanbus.CAR_DJ_ShuPing_MENGDIOU /* 65836 */:
                            case FinalCanbus.CAR_WeiChi2_XTS /* 65853 */:
                            case FinalCanbus.CAR_CYT_DaZhongZiDongKongTiao_H /* 65905 */:
                            case FinalCanbus.CAR_XC_08TianLai_LOW /* 65924 */:
                            case FinalCanbus.CAR_BSD_XP1_SHUPING_RENAULT_KeLeiAo /* 65938 */:
                            case FinalCanbus.CAR_XFY_XP1_ChangAnCsSerial /* 65942 */:
                            case FinalCanbus.CAR_WC1_Nawala_Philippine /* 131110 */:
                            case FinalCanbus.CAR_CYT_GaoErFu7_M /* 131112 */:
                            case FinalCanbus.CAR_RZC_XP1_QiJun_H /* 131152 */:
                            case FinalCanbus.CAR_WC1_QiJun_H /* 131173 */:
                            case FinalCanbus.CAR_CYT_ShuPing_HavalH2 /* 131316 */:
                            case FinalCanbus.CAR_XP_CYT_ShuPing_YeMa_L /* 131372 */:
                            case FinalCanbus.CAR_WeiChi2_XTS_SEATHEAT /* 131389 */:
                            case FinalCanbus.CAR_CYT_LangYi_L /* 131441 */:
                            case FinalCanbus.CAR_BSD_XP1_SHUPING_RENAULT_KeLeiAo_H /* 131474 */:
                            case FinalCanbus.CAR_452_BaoGu_Renault_17Koleos /* 131524 */:
                            case FinalCanbus.CAR_CYT_GaoErFu7_H /* 196648 */:
                            case FinalCanbus.CAR_XP1_QiJun_CYT_ZIDONG /* 196751 */:
                            case FinalCanbus.CAR_CYT_ShuPing_HavalH2_H /* 196852 */:
                            case FinalCanbus.CAR_XP_CYT_ShuPing_YeMa_H /* 196908 */:
                            case FinalCanbus.CAR_WeiChi2_ATS_H /* 196925 */:
                            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao /* 196953 */:
                            case FinalCanbus.CAR_CYT_LangYi_H /* 196977 */:
                            case FinalCanbus.CAR_452_BaoGu_Renault_18Koleos /* 197060 */:
                            case FinalCanbus.CAR_XP1_QiJun_CYT_ZIDONG_H /* 262287 */:
                            case FinalCanbus.CAR_DJ_Shuping_YEMA /* 262444 */:
                            case FinalCanbus.CAR_WeiChi2_SRX /* 262461 */:
                            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS /* 262489 */:
                            case FinalCanbus.CAR_CYT_ShouDongKongTiao /* 262513 */:
                            case FinalCanbus.CAR_XP1_QiJun_CYT_SHOUDONG /* 327823 */:
                            case FinalCanbus.CAR_WeiChi2_15SRX /* 327997 */:
                            case FinalCanbus.CAR_XP1_KeLeiAo_L /* 328054 */:
                            case FinalCanbus.CAR_WC1_17QiJun /* 393317 */:
                            case FinalCanbus.CAR_WeiChi2_18XTS /* 393533 */:
                            case FinalCanbus.CAR_XP1_KeLeiAo_H /* 393590 */:
                            case FinalCanbus.CAR_WC1_17QiJun_H /* 458853 */:
                            case FinalCanbus.CAR_XP1_CYT_XuanYi_L /* 458895 */:
                            case FinalCanbus.CAR_WeiChi2_18ATS /* 459069 */:
                            case FinalCanbus.CAR_WC2_ShuPing10JunYue /* 459097 */:
                            case FinalCanbus.CAR_WC1_Tuda /* 524389 */:
                            case FinalCanbus.CAR_XP1_CYT_XuanYi_H /* 524431 */:
                            case FinalCanbus.CAR_WeiChi2_NewJunYue /* 524605 */:
                            case FinalCanbus.CAR_WC1_19QiJun /* 589925 */:
                            case FinalCanbus.CAR_WC1_Tuda_Hand /* 655461 */:
                            case FinalCanbus.CAR_WC1_Nawala /* 720997 */:
                            case FinalCanbus.CAR_XP1_15QiJun_Shuping /* 721039 */:
                            case FinalCanbus.CAR_WC1_Tuda_H /* 852069 */:
                            case FinalCanbus.CAR_XP1_Meiganna4_TR_AUTO /* 1311094 */:
                            case FinalCanbus.CAR_443_WC2_TOYOTA_09HG /* 1376699 */:
                            case FinalCanbus.CAR_XP_Renault_23KOLEOS_L_Auto /* 1442216 */:
                            case FinalCanbus.CAR_443_WC2_TOYOTA_09RAV4 /* 1442235 */:
                            case FinalCanbus.CAR_XP_Renault_23KOLEOS_L_Hand /* 1507752 */:
                            case FinalCanbus.CAR_XP_Renault_23KOLEOS_H_Auto /* 1573288 */:
                            case FinalCanbus.CAR_443_WC2_TOYOTA_08Camery /* 1573307 */:
                            case FinalCanbus.CAR_XP1_Meiganna4_TR_AUTO_H /* 1769846 */:
                            case FinalCanbus.CAR_452_BaoGu_Renault_17Koleos_M /* 2818500 */:
                            case FinalCanbus.CAR_452_BaoGu_Renault_17Koleos_H /* 2884036 */:
                            case FinalCanbus.CAR_452_BaoGu_Renault_18Koleos_M /* 3015108 */:
                            case FinalCanbus.CAR_452_BaoGu_Renault_18Koleos_H /* 3080644 */:
                            case FinalCanbus.CAR_XP1_RAM1500_H_AUTO /* 4194678 */:
                            case FinalCanbus.CAR_439_RZC_YinFeiNiDi_QX50 /* 6029751 */:
                            case FinalCanbus.CAR_452_OD_Nissan_Tule_low /* 6095300 */:
                            case FinalCanbus.CAR_439_DJ_Nissan /* 12779959 */:
                            case FinalCanbus.CAR_439_DJ_Nissan_H /* 12845495 */:
                            case FinalCanbus.CAR_439_XFY_Keleiao_17_L /* 13631927 */:
                            case FinalCanbus.CAR_439_XFY_Keleiao_17_H /* 13697463 */:
                            case FinalCanbus.CAR_439_XFY_Keleiao_18_L /* 13762999 */:
                            case FinalCanbus.CAR_439_XFY_Keleiao_18_H /* 13828535 */:
                            case FinalCanbus.CAR_452_CYT_Toyota_Tundra_H /* 14025156 */:
                                int temp2 = temp * 5;
                                ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp2 / 10) + "." + (temp2 % 10));
                                mUpdateTempUNITRight();
                                break;
                            case 274:
                            case FinalCanbus.CAR_DJ_XP1_ACCORD7_H /* 65810 */:
                            case FinalCanbus.CAR_RZC_19MingjueHS /* 852241 */:
                            case FinalCanbus.CAR_RZC_19MingjueHS_H /* 1048849 */:
                            case FinalCanbus.CAR_454_OD_Qichen_D60_EV /* 9961926 */:
                            case FinalCanbus.CAR_454_OD_Beiqi_EV160 /* 10879430 */:
                                ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(temp).toString());
                                mUpdateTempUNITRight();
                                break;
                            case 280:
                            case 407:
                            case FinalCanbus.CAR_DaoJun_XINPU_ChuanQiGs4_H /* 65943 */:
                            case FinalCanbus.CAR_BNR_ChuanQiGS4 /* 327960 */:
                            case FinalCanbus.CAR_BNR_ChuanQiGS4_H /* 393496 */:
                                ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp / 100) + "." + ((temp % 100) / 10));
                                mUpdateTempUNITRight();
                                break;
                            case 327:
                            case 443:
                            case FinalCanbus.CAR_CYT_ShuPing_ChuanQiGS4 /* 65816 */:
                            case FinalCanbus.CAR_HC_OLD_TianLai_H /* 65863 */:
                            case FinalCanbus.CAR_HC_OLD_YinFeiNiDi_Fx35 /* 131399 */:
                            case FinalCanbus.CAR_CYT_Haval_H6_ShuPing /* 196739 */:
                            case FinalCanbus.CAR_CYT_SHuPing_SoNaTa8 /* 196776 */:
                            case FinalCanbus.CAR_452_XC_05_TianLai /* 196935 */:
                            case FinalCanbus.CAR_CYT_SHuPing_SoNaTa8_H /* 262312 */:
                            case FinalCanbus.CAR_XC_OLD_YinFeiNiDi_Fx35 /* 262471 */:
                            case FinalCanbus.CAR_CYT_SHuPing_SoNaTa8_D /* 327848 */:
                            case FinalCanbus.CAR_444_WC2_ChangfengLiebao_CS9_17 /* 1769916 */:
                            case FinalCanbus.CAR_439_XBS_NISSAN_TuLe /* 2425271 */:
                            case FinalCanbus.CAR_439_XBS_NISSAN_TuLe_ALLV /* 3342775 */:
                            case FinalCanbus.CAR_443_WC2_OULANDE_H /* 7012795 */:
                            case FinalCanbus.CAR_452_CYT_Toyota_Tundra /* 13959620 */:
                                if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(((temp * 9) + 320) / 10).toString());
                                } else {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(((temp * 5) / 10) + "." + ((temp * 5) % 10));
                                }
                                mUpdateTempUNITRight();
                                break;
                            case 363:
                            case 388:
                            case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
                            case FinalCanbus.CAR_DAOJUN_XP1_ShuPingNewJunWei_M /* 65899 */:
                            case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
                            case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng /* 655708 */:
                            case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng1 /* 721244 */:
                            case FinalCanbus.CAR_455_RZC_Mclaren_12C /* 721351 */:
                            case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng2 /* 786780 */:
                            case FinalCanbus.CAR_DAOJUN_OD_ATS /* 852316 */:
                            case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
                            case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
                            case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
                            case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
                            case FinalCanbus.CAR_453_LZ_AstonMartin /* 1376709 */:
                            case FinalCanbus.CAR_453_RZC_Mclaren_16_560S /* 4915653 */:
                            case FinalCanbus.CAR_453_RZC_Mclaren_19_720S /* 4981189 */:
                            case FinalCanbus.CAR_453_LZ_LandRover_13_CD /* 9175493 */:
                            case FinalCanbus.CAR_453_LZ_LandRover_18_CD /* 9241029 */:
                            case FinalCanbus.CAR_453_LZ_Jaguar_12_CD /* 9306565 */:
                            case FinalCanbus.CAR_452_LZ_Maserati_SP /* 12255684 */:
                            case FinalCanbus.CAR_454_LZ_LandRover_CD_Discovery5 /* 13894086 */:
                            case FinalCanbus.CAR_452_LUZ_LANDROVER_CYTAIR /* 15729092 */:
                                if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(((temp * 9) / 10) + 32).toString());
                                } else {
                                    int temp3 = temp * 5;
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp3 / 10) + "." + (temp3 % 10));
                                }
                                mUpdateTempUNITRight();
                                break;
                            case FinalCanbus.CAR_WC1_CYT_ShuPing_07_11_MENGDIOU /* 65759 */:
                            case FinalCanbus.CAR_XFY_Haval_H6_ShuPing /* 131203 */:
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
                                    mUpdateTempUNITRight();
                                    break;
                                }
                            case FinalCanbus.CAR_WC1_ShuPing_ZhiSheng_High /* 131295 */:
                                int temp4 = (temp * 5) - 400;
                                ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp4 / 10) + "." + (temp4 % 10));
                                mUpdateTempUNITRight();
                                break;
                            case FinalCanbus.CAR_OuDi_06Prado /* 196822 */:
                                if (temp <= 28 && temp >= 1) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(((temp * 5) + 160) / 10.0f).toString());
                                    mUpdateTempUNITRight();
                                    break;
                                } else if (temp <= 36 && temp >= 32) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(((temp * 5) + 140) / 10.0f).toString());
                                    mUpdateTempUNITRight();
                                    break;
                                } else {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText("--");
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                                    break;
                                }
                            case FinalCanbus.CAR_BNR_BoYue /* 459017 */:
                                int temp5 = (temp * 10) + 170;
                                ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp5 / 10) + "." + (temp5 % 10));
                                mUpdateTempUNITRight();
                                break;
                            case FinalCanbus.CAR_XP1_YearGmcSeries_NoAir /* 459164 */:
                                if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(((temp * 9) / 50) + 32).toString());
                                } else {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp / 10) + "." + (temp % 10));
                                }
                                mUpdateTempUNITRight();
                                break;
                            case FinalCanbus.CAR_355_HC_XIANDAI /* 590179 */:
                            case FinalCanbus.CAR_355_HC_XIANDAI_AMP /* 655715 */:
                            case FinalCanbus.CAR_439_HC_OuGeTL /* 3998135 */:
                                if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(((temp * 9) + 626) / 10).toString());
                                } else {
                                    int temp6 = (temp * 5) + 170;
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp6 / 10) + "." + (temp6 % 10));
                                }
                                mUpdateTempUNITRight();
                                break;
                            case FinalCanbus.CAR_XP1_RAM1500 /* 655734 */:
                            case FinalCanbus.CAR_XP1_RAM1500_M /* 4063606 */:
                            case FinalCanbus.CAR_XP1_RAM1500_H /* 4129142 */:
                                if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(temp + 27).toString());
                                } else {
                                    int temp7 = temp * 5;
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp7 / 10) + "." + (temp7 % 10));
                                }
                                mUpdateTempUNITRight();
                                break;
                            case FinalCanbus.CAR_WC1_Nawala_Hand /* 786533 */:
                            case FinalCanbus.CAR_455_TD_INFINIT_ESQ /* 1704391 */:
                            case FinalCanbus.CAR_455_TD_INFINIT_G /* 1769927 */:
                            case FinalCanbus.CAR_455_TD_INFINIT_QX50 /* 1835463 */:
                            case FinalCanbus.CAR_455_TD_INFINIT_06FX /* 1900999 */:
                            case FinalCanbus.CAR_455_TD_INFINIT_08FX /* 1966535 */:
                            case FinalCanbus.CAR_455_TD_INFINIT_14QX70 /* 2032071 */:
                            case FinalCanbus.CAR_455_TD_INFINIT_12FX /* 2097607 */:
                                int temp8 = temp * 5;
                                ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp8 / 10) + "." + (temp8 % 10));
                                ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                                break;
                            case FinalCanbus.CAR_RZC3_XianDai_I30_15 /* 1835370 */:
                            case FinalCanbus.CAR_RZC3_XianDai_CEED_11 /* 1900906 */:
                                if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(temp).toString());
                                } else {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(((temp * 5) + 170) / 10).toString());
                                }
                                mUpdateTempUNITRight();
                                break;
                            case FinalCanbus.CAR_453_LZ_GM_Camaro_17 /* 2163141 */:
                            case FinalCanbus.CAR_453_LZ_GM_GMC_TERRAIN_17 /* 2228677 */:
                            case FinalCanbus.CAR_453_LZ_GM_Equinox_17 /* 2294213 */:
                            case FinalCanbus.CAR_454_LZ_GM_Camaro_17_Auto /* 6947270 */:
                            case FinalCanbus.CAR_454_LZ_GM_Equinox_17_Auto /* 7012806 */:
                                if (temp >= 30 && temp <= 64) {
                                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(((temp * 9) / 10) + 32).toString());
                                    } else {
                                        int temp9 = temp * 5;
                                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp9 / 10) + "." + (temp9 % 10));
                                    }
                                } else if (temp >= 1 && temp <= 16) {
                                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append((((temp + 15) * 9) / 5) + 32).toString());
                                    } else {
                                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(temp + 15).toString());
                                    }
                                } else {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText("--");
                                }
                                mUpdateTempUNITRight();
                                break;
                            case FinalCanbus.CAR_439_RZC_ZhongTaiSR9 /* 2294199 */:
                            case FinalCanbus.CAR_439_RZC_ZhongTaiSR9_H /* 2359735 */:
                            case FinalCanbus.CAR_439_RZC_ZhongTaiSR7 /* 7537079 */:
                            case FinalCanbus.CAR_452_OD_Qirui_Xiaomayi /* 12517828 */:
                                int temp10 = (temp * 5) + 175;
                                ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp10 / 10) + "." + (temp10 % 10));
                                mUpdateTempUNITRight();
                                break;
                            case FinalCanbus.CAR_455_LUZ_Nissan_GTR_EN /* 2621895 */:
                            case FinalCanbus.CAR_439_LUZ_Nissan_GTR /* 13566391 */:
                                if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                                    if (temp >= 48) {
                                        temp -= 51;
                                    }
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(((temp * 9) + 635) / 10).toString());
                                } else {
                                    if (temp >= 48) {
                                        temp -= 51;
                                    }
                                    int temp11 = (temp * 5) + 175;
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp11 / 10) + "." + (temp11 % 10));
                                }
                                mUpdateTempUNITRight();
                                break;
                            case FinalCanbus.CAR_453_XP1_Ford_Edge_2013 /* 4260293 */:
                            case FinalCanbus.CAR_453_XP1_Ford_F150_2013 /* 4325829 */:
                            case FinalCanbus.CAR_453_XP1_Ford_Explorer_2013 /* 4391365 */:
                            case FinalCanbus.CAR_453_XP1_Ford_Taurus_2013 /* 4456901 */:
                            case FinalCanbus.CAR_453_XP1_Ford_Expedition_2013 /* 4522437 */:
                            case FinalCanbus.CAR_453_XP1_Ford_Edge_2015 /* 4587973 */:
                            case FinalCanbus.CAR_453_XP1_Ford_Mustang_2015 /* 4653509 */:
                                int temp12 = temp * 5;
                                ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp12 / 10) + "." + (temp12 % 10));
                                mUpdateTempUNITRight();
                                break;
                            case FinalCanbus.CAR_453_RZC_SWM_G05Pro_22 /* 5964229 */:
                                if (temp >= 36 && temp <= 50) {
                                    int temp13 = ((temp - 12) * 10) + 18;
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp13 / 10) + "." + (temp13 % 10));
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
                                    break;
                                } else {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText("--");
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                                    break;
                                }
                            case FinalCanbus.CAR_439_HC_TianLai_GongJue /* 6095287 */:
                            case FinalCanbus.CAR_439_HC_TianLai_GongJue_CD /* 6488503 */:
                            case FinalCanbus.CAR_439_HC_Nissan_Toread /* 7012791 */:
                                if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(((temp * 9) + 635) / 10).toString());
                                } else {
                                    int temp14 = (temp * 5) + 175;
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp14 / 10) + "." + (temp14 % 10));
                                }
                                mUpdateTempUNITRight();
                                break;
                            case FinalCanbus.CAR_452_OD_Zhonghua_V6_18 /* 6160836 */:
                                int temp15 = (temp * 5) + 160;
                                ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp15 / 10) + "." + (temp15 % 10));
                                mUpdateTempUNITRight();
                                break;
                            case FinalCanbus.CAR_439_HC_Ruijie /* 6816183 */:
                            case FinalCanbus.CAR_439_HC_Ruijie_H /* 6881719 */:
                                if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                                    if (temp >= 12 && temp <= 40) {
                                        int temp16 = ((temp - 12) * 5) + 155;
                                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp16 / 10) + "." + (temp16 % 10));
                                        ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
                                        break;
                                    } else {
                                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText("--");
                                        ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                                        break;
                                    }
                                } else if (temp >= 12 && temp <= 37) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append((temp - 12) + 60).toString());
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℉");
                                    break;
                                } else {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText("--");
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                                    break;
                                }
                            case FinalCanbus.CAR_439_DJ_06_09Kayan /* 12911031 */:
                                if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append((((temp + 31) * 9) / 10) + 32).toString());
                                } else {
                                    int temp17 = (temp * 5) + 155;
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp17 / 10) + "." + (temp17 % 10));
                                }
                                mUpdateTempUNITRight();
                                break;
                            case FinalCanbus.CAR_452_XC_Honda_Acura_TL /* 12911044 */:
                            case FinalCanbus.CAR_452_XC_Honda_Acura_RDX /* 12976580 */:
                            case FinalCanbus.CAR_452_XC_Honda_Acura_TLX /* 13042116 */:
                                if (temp >= 1 && temp <= 29) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(((temp * 5) + 170) * 0.1f).toString());
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
                                    break;
                                } else if (temp >= 32 && temp <= 34) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append((((temp - 32) * 5) + 160) * 0.1f).toString());
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
                                    break;
                                } else if (temp == 35) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(320 * 0.1f).toString());
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
                                    break;
                                } else {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText("--");
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                                    break;
                                }
                            case FinalCanbus.CAR_454_LZ_Nissan_370Z_L /* 14680518 */:
                            case FinalCanbus.CAR_454_LZ_Nissan_370Z_TW /* 14811590 */:
                            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_L /* 15729094 */:
                            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H /* 15794630 */:
                            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_TW /* 15860166 */:
                            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H_NP /* 15925702 */:
                                if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp / 10) + "." + (temp % 10));
                                } else {
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(temp / 10).toString());
                                }
                                mUpdateTempUNITRight();
                                break;
                            case FinalCanbus.CAR_452_Luz_Audi_A4L_Low /* 14811588 */:
                            case FinalCanbus.CAR_452_Luz_Audi_A4L_H /* 14877124 */:
                            case FinalCanbus.CAR_452_Luz_Audi_Q5_Low /* 14942660 */:
                            case FinalCanbus.CAR_452_Luz_Audi_Q5_H /* 15008196 */:
                            case FinalCanbus.CAR_452_Luz_Audi_A6L_Low /* 15073732 */:
                            case FinalCanbus.CAR_452_Luz_Audi_A6L_H /* 15139268 */:
                            case FinalCanbus.CAR_452_Luz_Audi_Q7_Low /* 15204804 */:
                            case FinalCanbus.CAR_452_Luz_Audi_Q7_H /* 15270340 */:
                                if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                                    int temp18 = (temp * 2) + 27;
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText("");
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℉");
                                    break;
                                } else {
                                    int temp19 = temp * 5;
                                    ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp19 / 10) + "." + (temp19 % 10));
                                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("℃");
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
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_OD_Beiqi_EV160 /* 10879430 */:
                ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                findViewById(R.id.air_sp_temp_unit_left).setVisibility(8);
                break;
            default:
                if (ConstAllAirDara.U_AIR_TEMP_UNIT != 255) {
                    ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText(vel == 0 ? "℃" : "℉");
                    break;
                } else {
                    int vel2 = SystemProperties.getInt("persist.fyt.temperature", 0);
                    ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText(vel2 == 0 ? "℃" : "℉");
                    break;
                }
        }
    }

    private void mUpdateTempUNITRight() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_OD_Beiqi_EV160 /* 10879430 */:
                ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                findViewById(R.id.air_sp_temp_unit_right).setVisibility(8);
                break;
            default:
                if (ConstAllAirDara.U_AIR_TEMP_UNIT != 255) {
                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText(vel == 0 ? "℃" : "℉");
                    break;
                } else {
                    int vel2 = SystemProperties.getInt("persist.fyt.temperature", 0);
                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText(vel2 == 0 ? "℃" : "℉");
                    break;
                }
        }
    }

    
    public void mUpdateDual() {
        int i = R.drawable.ic_sp_dual_n;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_DUAL];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_452_CYT_Toyota_Tundra /* 13959620 */:
            case FinalCanbus.CAR_452_CYT_Toyota_Tundra_H /* 14025156 */:
                View findViewById = findViewById(R.id.air_sp_dual);
                if (vel != 1) {
                    i = 2130841906;
                }
                findViewById.setBackgroundResource(i);
                break;
            default:
                View findViewById2 = findViewById(R.id.air_sp_dual);
                if (vel != 0) {
                    i = 2130841906;
                }
                findViewById2.setBackgroundResource(i);
                break;
        }
    }

    
    public void mUpdateSYNC() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SYNC];
        findViewById(R.id.air_sp_sync).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_sync_n : R.drawable.ic_sp_sync_p);
    }

    
    public void mUpdateZONE() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_ZONE];
        findViewById(R.id.air_sp_zone).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_zone_n : R.drawable.ic_sp_zone_p);
    }

    
    public void mUpdateForest() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_FOREST];
        findViewById(R.id.air_sp_forest).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_forest_n : R.drawable.ic_sp_forest_p);
    }

    
    public void mUpdateSteer() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_STEER];
        findViewById(R.id.air_sp_steer).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_steer_n : R.drawable.ic_sp_steer_p);
    }

    
    public void mUpdateAuto() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO];
        findViewById(R.id.air_sp_auto).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_auto_n : R.drawable.ic_sp_auto_p);
    }

    
    public void mUpdateAutoRight() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO_RIGHT];
        findViewById(R.id.air_sp_auto_right).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_auto_n : R.drawable.ic_sp_auto_p);
    }

    
    public void mUpdateAcMax() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC_MAX];
        findViewById(R.id.air_sp_acmax).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_acmax_n : R.drawable.ic_sp_acmax_p);
    }

    
    public void mUpdateAcOn() {
        int i = R.drawable.ic_sp_ac2_p;
        int i2 = R.drawable.ic_sp_ac2_n;
        int acOn = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC];
        switch (DataCanbus.DATA[1000]) {
            case 274:
            case FinalCanbus.CAR_DJ_XP1_ACCORD7_H /* 65810 */:
                View findViewById = findViewById(R.id.air_sp_ac);
                if (acOn <= 1) {
                    i = 2130841869;
                }
                findViewById.setBackgroundResource(i);
                break;
            default:
                View findViewById2 = findViewById(R.id.air_sp_ac);
                if (acOn != 0) {
                    i2 = 2130841870;
                }
                findViewById2.setBackgroundResource(i2);
                break;
        }
    }

    
    public void mUpdateCycle() {
        int i = R.drawable.ic_sp_cylce_out2_p;
        int i2 = R.drawable.ic_sp_cylce_in2_p;
        int cycle = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE];
        int cycle_auto = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE_AUTO];
        switch (DataCanbus.DATA[1000]) {
            case 280:
            case FinalCanbus.CAR_BNR_ChuanQiGS4 /* 327960 */:
            case FinalCanbus.CAR_BNR_ChuanQiGS4_H /* 393496 */:
            case FinalCanbus.CAR_DJ_XP1_ParkAvenue /* 2162713 */:
            case FinalCanbus.CAR_455_LUZ_Nissan_GTR_EN /* 2621895 */:
            case FinalCanbus.CAR_439_LUZ_Nissan_GTR /* 13566391 */:
            case FinalCanbus.CAR_454_LZ_Nissan_370Z_L /* 14680518 */:
            case FinalCanbus.CAR_454_LZ_Nissan_370Z_TW /* 14811590 */:
            case FinalCanbus.CAR_453_LZ_Teana_08_L /* 15532485 */:
            case FinalCanbus.CAR_453_LZ_Teana_08_H /* 15598021 */:
            case FinalCanbus.CAR_453_LZ_Teana_08_TW /* 15663557 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_L /* 15729094 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H /* 15794630 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_TW /* 15860166 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H_NP /* 15925702 */:
                View findViewById = findViewById(R.id.air_sp_cycle);
                if (cycle != 0) {
                    i2 = 2130841902;
                }
                findViewById.setBackgroundResource(i2);
                break;
            case 327:
            case FinalCanbus.CAR_HC_OLD_TianLai_H /* 65863 */:
            case FinalCanbus.CAR_HC_OLD_YinFeiNiDi_Fx35 /* 131399 */:
            case FinalCanbus.CAR_452_XC_05_TianLai /* 196935 */:
            case FinalCanbus.CAR_XC_OLD_YinFeiNiDi_Fx35 /* 262471 */:
                View findViewById2 = findViewById(R.id.air_sp_cycle);
                if (cycle != 2) {
                    i2 = 2130841902;
                }
                findViewById2.setBackgroundResource(i2);
                break;
            case FinalCanbus.CAR_OuDi_06Prado /* 196822 */:
            case FinalCanbus.CAR_439_RZC_YinFeiNiDi_QX50 /* 6029751 */:
            case FinalCanbus.CAR_439_DJ_06_09Kayan /* 12911031 */:
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
            case FinalCanbus.CAR_XP1_RAM1500 /* 655734 */:
            case FinalCanbus.CAR_XP1_RAM1500_M /* 4063606 */:
            case FinalCanbus.CAR_XP1_RAM1500_H /* 4129142 */:
                if (cycle == 2) {
                    findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_sp_cylce_out2_p);
                    break;
                } else if (cycle == 1) {
                    findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_sp_cylce_in2_p);
                    break;
                } else if (cycle == 3) {
                    findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_sp_cylce_auto_p);
                    break;
                }
            case FinalCanbus.CAR_WC_SP_09_Lexus_ES350 /* 1573158 */:
            case FinalCanbus.CAR_WC_SP_09_Lexus_ES350_H /* 1638694 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_07Shengda /* 6422971 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_12SORENTO /* 6488507 */:
                if (cycle_auto == 1) {
                    findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_sp_cylce_auto_p);
                    break;
                } else if (cycle == 1) {
                    findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_sp_cylce_in2_p);
                    break;
                } else {
                    findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_sp_cylce_out2_p);
                    break;
                }
            case FinalCanbus.CAR_452_CYT_Toyota_Tundra /* 13959620 */:
            case FinalCanbus.CAR_452_CYT_Toyota_Tundra_H /* 14025156 */:
            case FinalCanbus.CAR_452_Luz_Audi_A4L_Low /* 14811588 */:
            case FinalCanbus.CAR_452_Luz_Audi_A4L_H /* 14877124 */:
            case FinalCanbus.CAR_452_Luz_Audi_Q5_Low /* 14942660 */:
            case FinalCanbus.CAR_452_Luz_Audi_Q5_H /* 15008196 */:
            case FinalCanbus.CAR_452_Luz_Audi_A6L_Low /* 15073732 */:
            case FinalCanbus.CAR_452_Luz_Audi_A6L_H /* 15139268 */:
            case FinalCanbus.CAR_452_Luz_Audi_Q7_Low /* 15204804 */:
            case FinalCanbus.CAR_452_Luz_Audi_Q7_H /* 15270340 */:
            case FinalCanbus.CAR_452_LUZ_LANDROVER_CYTAIR /* 15729092 */:
                View findViewById3 = findViewById(R.id.air_sp_cycle);
                if (cycle != 1) {
                    i2 = 2130841902;
                }
                findViewById3.setBackgroundResource(i2);
                break;
            default:
                View findViewById4 = findViewById(R.id.air_sp_cycle);
                if (cycle != 0) {
                    i = 2130841898;
                }
                findViewById4.setBackgroundResource(i);
                break;
        }
    }

    
    public void mUpdateSwing() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_SWING];
        findViewById(R.id.air_sp_swing).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_swing_n : R.drawable.ic_sp_swing_p);
    }

    
    public void mUpdateFrontHot() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT_HOT];
        findViewById(R.id.air_sp_front_hot).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_front_hot_n : R.drawable.ic_sp_front_hot_p);
    }

    
    public void mUpdateION() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_ION];
        findViewById(R.id.air_sp_ion).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_ion_n : R.drawable.ic_sp_ion_p);
    }

    
    public void mUpdateBlowTop() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOWTOP];
        findViewById(R.id.air_sp_blowtop).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_blowtop_n : R.drawable.ic_sp_blowtop_p);
    }

    
    public void mUpdatePtc() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_PTC];
        findViewById(R.id.air_sp_ptc).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_ptc_n : R.drawable.ic_sp_ptc_p);
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR];
        findViewById(R.id.air_sp_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_rear2_n : R.drawable.ic_sp_rear2_p);
    }

    
    public void mUpdateFrontDefrost() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT];
        findViewById(R.id.air_sp_front).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_front2_n : R.drawable.ic_sp_front2_p);
    }

    
    public void mUpdateFrontmaxDefrost() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONTMAX];
        findViewById(R.id.air_sp_frontmax).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_frontmax_n : R.drawable.ic_sp_frontmax_p);
    }

    
    public void mUpdatePower() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_POWER];
        findViewById(R.id.air_sp_power).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_power_n : R.drawable.ic_sp_power_p);
    }

    
    public void mUpdateEV() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_EV];
        findViewById(R.id.air_sp_ev).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_ev_n : R.drawable.ic_sp_ev_p);
    }

    
    public void mUpdateECO() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_ECO];
        findViewById(R.id.air_sp_eco).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_eco_n : R.drawable.ic_sp_eco_p);
    }

    
    public void mUpdateNANOE() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_NANOE];
        findViewById(R.id.air_sp_nanoe).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_nanoe_n : R.drawable.ic_sp_nanoe_p);
    }

    
    public void mUpdateCLEAN() {
        int clean = DataCanbus.DATA[ConstAllAirDara.U_AIR_CLEAN];
        findViewById(R.id.air_sp_clean).setBackgroundResource(clean == 0 ? R.drawable.ic_sp_clean_n : R.drawable.ic_sp_clean_p);
    }

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
        findViewById(R.id.air_sp_wind_txt).setVisibility(8);
        if (ConstAllAirDara.C_AIR_POWER != 255 && ConstAllAirDara.U_AIR_POWER == 255) {
            findViewById(R.id.air_sp_power).setBackgroundResource(leave == 0 ? R.drawable.ic_sp_power_n : R.drawable.ic_sp_power_p);
        }
        switch (DataCanbus.DATA[1000]) {
            case 38:
            case 80:
            case 101:
            case 443:
            case FinalCanbus.CAR_WC2_CHANGANCX7 /* 65664 */:
            case FinalCanbus.CAR_WC1_Nawala_Philippine /* 131110 */:
            case FinalCanbus.CAR_RZC_XP1_QiJun_H /* 131152 */:
            case FinalCanbus.CAR_WC1_QiJun_H /* 131173 */:
            case FinalCanbus.CAR_XP1_QiJun_CYT_ZIDONG /* 196751 */:
            case FinalCanbus.CAR_WC2_CHANGAN_19KeSai /* 262272 */:
            case FinalCanbus.CAR_XP1_QiJun_CYT_ZIDONG_H /* 262287 */:
            case FinalCanbus.CAR_WC2_CHANGAN_19KeSai_Hand /* 327808 */:
            case FinalCanbus.CAR_XP1_QiJun_CYT_SHOUDONG /* 327823 */:
            case FinalCanbus.CAR_XP1_KeLeiAo_L /* 328054 */:
            case FinalCanbus.CAR_WC1_17QiJun /* 393317 */:
            case FinalCanbus.CAR_XP1_KeLeiAo_H /* 393590 */:
            case FinalCanbus.CAR_WC1_17QiJun_H /* 458853 */:
            case FinalCanbus.CAR_XP1_CYT_XuanYi_L /* 458895 */:
            case FinalCanbus.CAR_WC1_Tuda /* 524389 */:
            case FinalCanbus.CAR_XP1_CYT_XuanYi_H /* 524431 */:
            case FinalCanbus.CAR_WC1_19QiJun /* 589925 */:
            case FinalCanbus.CAR_WC1_Tuda_Hand /* 655461 */:
            case FinalCanbus.CAR_XP1_RAM1500 /* 655734 */:
            case FinalCanbus.CAR_WC1_Nawala /* 720997 */:
            case FinalCanbus.CAR_XP1_15QiJun_Shuping /* 721039 */:
            case FinalCanbus.CAR_455_RZC_Mclaren_12C /* 721351 */:
            case FinalCanbus.CAR_WC1_Nawala_Hand /* 786533 */:
            case FinalCanbus.CAR_WC1_Tuda_H /* 852069 */:
            case FinalCanbus.CAR_XP1_Meiganna4_TR_HAND /* 1245558 */:
            case FinalCanbus.CAR_XP1_Meiganna4_TR_AUTO /* 1311094 */:
            case FinalCanbus.CAR_453_LZ_AstonMartin /* 1376709 */:
            case FinalCanbus.CAR_XP_Renault_23KOLEOS_L_Auto /* 1442216 */:
            case FinalCanbus.CAR_XP_Renault_23KOLEOS_L_Hand /* 1507752 */:
            case FinalCanbus.CAR_XP_Renault_23KOLEOS_H_Auto /* 1573288 */:
            case FinalCanbus.CAR_XP1_Meiganna4_TR_AUTO_H /* 1769846 */:
            case FinalCanbus.CAR_444_WC2_ChangfengLiebao_CS9_17 /* 1769916 */:
            case FinalCanbus.CAR_RZC3_XianDai_I30_15 /* 1835370 */:
            case FinalCanbus.CAR_RZC3_XianDai_CEED_11 /* 1900906 */:
            case FinalCanbus.CAR_439_OuDi_NaZhiJieU7 /* 2032055 */:
            case FinalCanbus.CAR_453_LZ_GM_Camaro_17 /* 2163141 */:
            case FinalCanbus.CAR_453_LZ_GM_GMC_TERRAIN_17 /* 2228677 */:
            case FinalCanbus.CAR_453_LZ_GM_Equinox_17 /* 2294213 */:
            case FinalCanbus.CAR_439_OuDi_NaZhiJieU5 /* 3932599 */:
            case FinalCanbus.CAR_XP1_RAM1500_H_AUTO /* 4194678 */:
            case FinalCanbus.CAR_453_RZC_Mclaren_16_560S /* 4915653 */:
            case FinalCanbus.CAR_453_RZC_Mclaren_19_720S /* 4981189 */:
            case FinalCanbus.CAR_454_LZ_GM_Camaro_17_Auto /* 6947270 */:
            case FinalCanbus.CAR_443_WC2_OULANDE_H /* 7012795 */:
            case FinalCanbus.CAR_454_LZ_GM_Equinox_17_Auto /* 7012806 */:
            case FinalCanbus.CAR_454_OD_Qichen_D60_EV /* 9961926 */:
            case FinalCanbus.CAR_452_OuDi_NaZhiJieU6 /* 11534788 */:
            case FinalCanbus.CAR_453_OD_Beiqi_Changhe_Q7_SP /* 15925701 */:
                findViewById(R.id.air_sp_wind_lev).setVisibility(8);
                findViewById(R.id.air_sp_wind_txt).setVisibility(0);
                ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(leave).toString());
                break;
            case 345:
            case FinalCanbus.CAR_WC2_ShuPingJW /* 65881 */:
            case FinalCanbus.CAR_WC2_ShuPingKeLuZi /* 131417 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao /* 196953 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS /* 262489 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS_S /* 328025 */:
            case FinalCanbus.CAR_WC2_ShuPingKeLuZi_Auto /* 524633 */:
            case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao_L /* 590169 */:
                findViewById(R.id.air_sp_wind_lev).setVisibility(8);
                findViewById(R.id.air_sp_wind_txt).setVisibility(0);
                if (leave == 19) {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText("Auto");
                    break;
                } else {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(leave).toString());
                    break;
                }
            case FinalCanbus.CAR_RZC_XP1_RongWei_RX5 /* 262417 */:
            case FinalCanbus.CAR_RZC_19MingjueHS /* 852241 */:
            case FinalCanbus.CAR_RZC_19MingjueHS_H /* 1048849 */:
            case FinalCanbus.CAR_RZC_17Rongwei_EI6 /* 1573137 */:
                findViewById(R.id.air_sp_wind_lev).setVisibility(8);
                findViewById(R.id.air_sp_wind_txt).setVisibility(0);
                if (leave == 15) {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText("Auto");
                    break;
                } else {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(leave).toString());
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
            } else if (b_up_foot) {
                findViewById(R.id.air_sp_blow_changer_right).setBackgroundResource(R.drawable.ic_sp_mode_win_foot_p);
            } else if (b_foot) {
                findViewById(R.id.air_sp_blow_changer_right).setBackgroundResource(R.drawable.ic_sp_mode_foot_p);
            } else if (b_body) {
                findViewById(R.id.air_sp_blow_changer_right).setBackgroundResource(R.drawable.ic_sp_mode_body_p);
            } else if (b_up) {
                findViewById(R.id.air_sp_blow_changer_right).setBackgroundResource(R.drawable.ic_sp_mode_win_p);
            } else if (b_up_body) {
                findViewById(R.id.air_sp_blow_changer_right).setBackgroundResource(R.drawable.ic_sp_mode_body_win_p);
            } else if (b_up_body_foot) {
                findViewById(R.id.air_sp_blow_changer_right).setBackgroundResource(R.drawable.ic_sp_mode_body_foot_win_p);
            } else if (b_null) {
                findViewById(R.id.air_sp_blow_changer_right).setBackgroundResource(R.drawable.ic_sp_mode_null);
            }
        }
        if (ConstAllAirDara.C_AIR_MODE_BODY_RIGHT != 255) {
            findViewById(R.id.air_sp_blow_body_right).setBackgroundResource(DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT] == 1 ? 2130841936 : R.drawable.ic_sp_mode_body_n);
        }
        if (ConstAllAirDara.C_AIR_MODE_FOOT_RIGHT != 255) {
            findViewById(R.id.air_sp_blow_foot_right).setBackgroundResource(DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT] == 1 ? R.drawable.ic_sp_mode_foot_p : R.drawable.ic_sp_mode_foot_n);
        }
        if (ConstAllAirDara.C_AIR_MODE_UP_RIGHT != 255) {
            findViewById(R.id.air_sp_blow_win_right).setBackgroundResource(DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_RIGHT] == 1 ? R.drawable.ic_sp_mode_win_p : R.drawable.ic_sp_mode_win_n);
        }
    }

    
    public void updateBlowModeUpRight() {
        updateBlowModeRight();
    }

    
    public void updateBlowModeBodyRight() {
        updateBlowModeRight();
    }

    
    public void updateBlowModeFootRight() {
        updateBlowModeRight();
    }
}
