package com.syu.canbus.warn;

import android.content.Context;
import android.os.SystemProperties;
import android.util.Log;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.honda.Act_CarCD_AoDeSai;
import com.syu.carinfo.lz.lexusis.LZLexusISCarSet;
import com.syu.carinfo.wc.tianlaicd.WC08TianlaiCarEqAct;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class DataPack {
    public static int sPackWarm;
    public static int sWCRuijieWarnIndex;
    public static int sWCRuijieWarnStatus;
    static int mCurrentID = 0;
    static int[] mCurrentUpdatteCode = null;
    static IUiNotify mCurrentNotify = null;
    static IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (DataPack.mCurrentID != DataCanbus.DATA[1000]) {
                FinalCanbus.num = -1;
                if (DataPack.mCurrentNotify != null && DataPack.mCurrentUpdatteCode != null) {
                    for (int i : DataPack.mCurrentUpdatteCode) {
                        DataCanbus.NOTIFY_EVENTS[i].removeNotify(DataPack.mCurrentNotify);
                    }
                    DataPack.mCurrentUpdatteCode = null;
                }
                DataPack.mCurrentID = DataCanbus.DATA[1000];
            }
            switch (DataCanbus.DATA[1000]) {
                case 22:
                case 48:
                case 116:
                case 334:
                case 403:
                case FinalCanbus.CAR_BNR_XP1_ShuPingFord_YIHU /* 65939 */:
                case FinalCanbus.CAR_XP1_Focus2012_H /* 131094 */:
                case FinalCanbus.CAR_BNR_Yihu2012 /* 131120 */:
                case FinalCanbus.CAR_RZC_XP1_YiHu2017 /* 131406 */:
                case FinalCanbus.CAR_BNR_XP1_ShuPingFord_YIHU_H /* 131475 */:
                case FinalCanbus.CAR_BNR_Yihu2012_H /* 196656 */:
                case FinalCanbus.CAR_BNR_KX_ShuPingFord_Mengdiou /* 197011 */:
                case FinalCanbus.CAR_RZC_XP1_YiHu2017_M /* 655694 */:
                case FinalCanbus.CAR_RZC_XP1_YiHu2017_H /* 721230 */:
                case FinalCanbus.CAR_RZC_NewFiestar /* 983374 */:
                case FinalCanbus.CAR_RZC_Ecosport /* 1311054 */:
                case FinalCanbus.CAR_RZC_Ford_SMAX /* 1769806 */:
                case FinalCanbus.CAR_RZC_Ford_Tourneo /* 1835342 */:
                case FinalCanbus.CAR_XC_RZC_NewFiestar /* 1966414 */:
                case FinalCanbus.CAR_RZC_Foed_Yihu /* 2097486 */:
                case FinalCanbus.CAR_RZC_Foed_YiBo /* 2163022 */:
                case FinalCanbus.CAR_RZC_Foed_YiBo_19 /* 2228558 */:
                case FinalCanbus.CAR_RZC_LHT_Ford_F150_Auto /* 2425166 */:
                case FinalCanbus.CAR_RZC_LHT_Ford_F150_Hand /* 2490702 */:
                case FinalCanbus.CAR_RCW_XP1_Focus2015 /* 2556238 */:
                case FinalCanbus.CAR_RZC_XP1_Focus2015_Air /* 2949454 */:
                case FinalCanbus.CAR_RZC_LHT_Ford_F150_13 /* 3277134 */:
                case FinalCanbus.CAR_RZC_LHT_Ford_F150_10 /* 3342670 */:
                case FinalCanbus.CAR_RZC_LHT_Ford_F150_12 /* 3408206 */:
                case FinalCanbus.CAR_RZC_LHT_Ford_F150_10_Auto /* 3473742 */:
                case FinalCanbus.CAR_RZC_LHT_Ford_F150_12_Auto /* 3539278 */:
                case FinalCanbus.CAR_CZH_RZC_Focus2015 /* 3866958 */:
                case FinalCanbus.CAR_CZH_RZC_YiHu2017_H /* 3932494 */:
                case FinalCanbus.CAR_RZC_XP1_Focus2015_M /* 4063566 */:
                case FinalCanbus.CAR_RZC_XP1_Focus2015_H /* 4129102 */:
                case FinalCanbus.CAR_RZC_Foed_Yihu_M /* 4194638 */:
                case FinalCanbus.CAR_RZC_Foed_Yihu_H /* 4260174 */:
                case FinalCanbus.CAR_RZC_Ecosport_M /* 4325710 */:
                case FinalCanbus.CAR_RZC_Ecosport_H /* 4391246 */:
                case FinalCanbus.CAR_RZC_NewFiestar_M /* 4456782 */:
                case FinalCanbus.CAR_RZC_NewFiestar_H /* 4522318 */:
                case FinalCanbus.CAR_RZC_Ford_YiBH_19_M /* 4849998 */:
                case FinalCanbus.CAR_RZC_Ford_YiBH_19_H /* 4915534 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyFocus;
                    DataPack.mCurrentUpdatteCode = new int[]{111, 104};
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
                case FinalCanbus.CAR_ZH_XP_MQB_T_CROSS /* 1310760 */:
                case FinalCanbus.CAR_XP_TuGuan_L_20_H /* 1376296 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyXPMQBAirClear;
                    DataPack.mCurrentUpdatteCode = new int[]{235};
                    break;
                case 160:
                case FinalCanbus.CAR2_RZC_XP1_DaZhong_GaoErFu7_H /* 131232 */:
                case FinalCanbus.CAR_RZC_XP1_MaiTeng /* 196768 */:
                case FinalCanbus.CAR_RZC_TuGuan_L /* 262304 */:
                case FinalCanbus.CAR_RZC_TuAng /* 327840 */:
                case FinalCanbus.CAR_RZC_DaZhong_MQB_SUP /* 458912 */:
                case FinalCanbus.CAR_RZC_DaZhong_MQB_SUP_H /* 524448 */:
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
                case FinalCanbus.CAR_RZC_MQB_LAVIDA_19_E /* 2883744 */:
                case FinalCanbus.CAR_RZC_MQB_GOLF_20_E /* 2949280 */:
                case FinalCanbus.CAR_RZC_MQB_BORA_20_E /* 3014816 */:
                case FinalCanbus.CAR_RZC_MQB_Huiang_21 /* 3080352 */:
                case FinalCanbus.CAR_RZC_MQB_20Tayron_GTE /* 3145888 */:
                case FinalCanbus.CAR_RZC_MQB_20Jetta_VS7 /* 3211424 */:
                case FinalCanbus.CAR_RZC_MQB_20Viloran /* 3276960 */:
                case FinalCanbus.CAR_RZC_MQB_16_18Weilan /* 3408032 */:
                case FinalCanbus.CAR_RZC_TuGuan_L_20_H /* 3473568 */:
                case FinalCanbus.CAR_RZC_MQB_All_360 /* 3670176 */:
                case FinalCanbus.CAR_RZC_MaiTeng_20_H_EC /* 3801248 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyRZCMQBTireWarn;
                    DataPack.mCurrentUpdatteCode = new int[]{378, 379};
                    break;
                case 163:
                case 339:
                case FinalCanbus.CAR_RZC4_PSA14_308_16 /* 65699 */:
                case FinalCanbus.CAR_RZC4_PSA_4008 /* 65875 */:
                case FinalCanbus.CAR_RZC4_PSA14_408_M /* 131235 */:
                case FinalCanbus.CAR_RZC4_PSA_19_C4L /* 131411 */:
                case FinalCanbus.CAR_RZC4_PSA14_408_H /* 196771 */:
                case FinalCanbus.CAR_RZC4_PSA_19_508 /* 196947 */:
                case FinalCanbus.CAR_RZC4_PSA_19_C3_XR_L /* 262483 */:
                case FinalCanbus.CAR_RZC4_PSA_19_C3_XR_M /* 328019 */:
                case FinalCanbus.CAR_RZC4_PSA_19_C3_XR_H /* 393555 */:
                case FinalCanbus.CAR_RZC4_PSA_ALL_M /* 459091 */:
                case FinalCanbus.CAR_RZC4_PSA_ALL_H /* 524627 */:
                case FinalCanbus.CAR_RZC4_PSA_19_408 /* 590163 */:
                case FinalCanbus.CAR_RZC4_PSA_19_408_H /* 655699 */:
                case FinalCanbus.CAR_RZC4_PSA_17_3008 /* 721235 */:
                case FinalCanbus.CAR_RZC4_PSA_17_3008_M /* 786771 */:
                case FinalCanbus.CAR_RZC4_PSA_17_3008_H /* 852307 */:
                case FinalCanbus.CAR_RZC4_PSA_14_2008 /* 917843 */:
                case FinalCanbus.CAR_RZC4_PSA_14_2008_M /* 983379 */:
                case FinalCanbus.CAR_RZC4_PSA_14_2008_H /* 1048915 */:
                case FinalCanbus.CAR_RZC4_PSA_05_Xsars /* 1114451 */:
                case FinalCanbus.CAR_RZC4_PSA_06_206 /* 1179987 */:
                case FinalCanbus.CAR_RZC4_PSA_07_307 /* 1245523 */:
                case FinalCanbus.CAR_RZC4_PSA_ALL_NoAir_L /* 2031955 */:
                case FinalCanbus.CAR_RZC4_PSA_ALL_NoAir_M /* 2097491 */:
                case FinalCanbus.CAR_RZC4_PSA_ALL_NoAir_H /* 2163027 */:
                case FinalCanbus.CAR_RZC4_PSA_C4_OE_L /* 2228563 */:
                case FinalCanbus.CAR_RZC4_PSA_C4_OE_M /* 2294099 */:
                case FinalCanbus.CAR_RZC4_PSA_C4_OE_H /* 2359635 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyRZCBiaozhi;
                    DataPack.mCurrentUpdatteCode = new int[]{205, 206, 207};
                    break;
                case 265:
                    DataPack.mCurrentNotify = DataPack.mNotifyRzcZhongtaiT600;
                    DataPack.mCurrentUpdatteCode = new int[]{147, 148, 149};
                    break;
                case 293:
                    DataPack.mCurrentNotify = DataPack.mNotifyRuiJie15;
                    DataPack.mCurrentUpdatteCode = new int[]{107};
                    break;
                case 388:
                case FinalCanbus.CAR_XC_08TianLai_LOW /* 65924 */:
                case FinalCanbus.CAR_XP_OLD_9TianLai /* 196996 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyXcTianlai;
                    DataPack.mCurrentUpdatteCode = new int[]{115};
                    break;
                case 420:
                case FinalCanbus.CAR_WC2_ToYoTa_Lexus_09IS_Low /* 721316 */:
                case FinalCanbus.CAR_WC2_ToYoTa_Lexus_06LS460 /* 786852 */:
                case FinalCanbus.CAR_WC2_ToYoTa_Lexus_NX_SCREEN /* 852388 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyWCHuangguan;
                    DataPack.mCurrentUpdatteCode = new int[]{127};
                    break;
                case FinalCanbus.CAR_DJ_SHA_BUS /* 65944 */:
                case FinalCanbus.CAR_DJ_SHA_BUS_NOAIR /* 131480 */:
                case FinalCanbus.CAR_DJ_SHA_BUS_JiuLong /* 197016 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyBus;
                    DataPack.mCurrentUpdatteCode = new int[]{98};
                    break;
                case FinalCanbus.CAR_WC2_FengShenAX5 /* 65955 */:
                case FinalCanbus.CAR_WC2_16FengShenAX7 /* 1048995 */:
                case FinalCanbus.CAR_WC2_16FengShenAX7_L /* 1311139 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyAX5;
                    DataPack.mCurrentUpdatteCode = new int[]{99, 100, 101, 102, 103, 104, 105, 106, 107, 108};
                    break;
                case FinalCanbus.CAR_452_XC_Tianlai_GJ /* 65988 */:
                case FinalCanbus.CAR_453_XC_Tianlai_GJ /* 1442245 */:
                case FinalCanbus.CAR_439_HC_Nissan_GuiShi /* 7799223 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyXcTianlaiGJ;
                    DataPack.mCurrentUpdatteCode = new int[]{106};
                    break;
                case FinalCanbus.CAR_455_LZ_CG_Toyota_4Runner_Auto /* 65991 */:
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen /* 1114567 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen_3 /* 1180103 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_Prado_14 /* 3211719 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
                case FinalCanbus.CAR_454_LZ_Toyota_FJ_CRUISER /* 14942662 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300 /* 15008198 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_4Runner /* 15073734 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER /* 15139270 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha /* 15204806 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER_H /* 15532486 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300_H /* 15598022 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha_3 /* 16187846 */:
                case FinalCanbus.CAR_454_LZ_Toyota_FJ_CRUISER_3 /* 16253382 */:
                case FinalCanbus.CAR_454_LZ_6606_Toyota_FJ_CRUISER /* 16318918 */:
                case FinalCanbus.CAR_454_LZ_6606_Toyota_FJ_CRUISER_3 /* 16384454 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyLzYLAishow;
                    DataPack.mCurrentUpdatteCode = new int[]{158, 15, 16, 67, 14, 18, 19, 20, 33, 92, 10, 42, 46, 47, 38};
                    break;
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_All /* 131434 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_All_H /* 524650 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyRZCXiandai;
                    DataPack.mCurrentUpdatteCode = new int[]{104};
                    break;
                case FinalCanbus.CAR_WC2_LandRover_Discovery3 /* 131483 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyWCLandRover;
                    DataPack.mCurrentUpdatteCode = new int[]{100};
                    break;
                case FinalCanbus.CAR_450_ZHTD_Audi /* 131522 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyAdui_Zhtd;
                    DataPack.mCurrentUpdatteCode = new int[]{80, 27, 28, 21, 25, 77, 87};
                    break;
                case FinalCanbus.CAR_RZC_BeiQi_EC180 /* 196835 */:
                case FinalCanbus.CAR_RZC_BeiQi_19EC5 /* 458979 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyEC180;
                    DataPack.mCurrentUpdatteCode = new int[]{104};
                    break;
                case FinalCanbus.CAR_LZ_XP1_PsaAll_CD /* 196889 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyLZPsaAll;
                    DataPack.mCurrentUpdatteCode = new int[]{207, 208, 209, 210, 211, 212, 213};
                    break;
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto /* 197052 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_P15_MC_EV /* 262588 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Auto /* 721340 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_GCC /* 852412 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV1 /* 917948 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV2 /* 983484 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV3 /* 1049020 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_OFFROAD /* 1114556 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto2 /* 1180092 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Iran /* 1900988 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_ADAS /* 3080636 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyWCYuncheAishow;
                    DataPack.mCurrentUpdatteCode = new int[]{120, 121, 27, 21};
                    break;
                case FinalCanbus.CAR_XP1_PsaAll_AutoPark /* 262425 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyXPPsaAutoPark;
                    DataPack.mCurrentUpdatteCode = new int[]{216, 217};
                    break;
                case FinalCanbus.CAR_447_RZC_19IX45 /* 262591 */:
                case FinalCanbus.CAR_447_RZC_19IX45_H /* 328127 */:
                case FinalCanbus.CAR_447_RZC_19IX45_Top /* 393663 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_19Tusheng /* 459199 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_19Tusheng_H /* 524735 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_19KX5 /* 590271 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_19KX5_H /* 655807 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_19K3 /* 721343 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_Sonata9_E /* 786879 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_19K3_E /* 852415 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_19K5_E /* 917951 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_Sonata9M_E /* 983487 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_Sonata9H_E /* 1049023 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_KX3 /* 1114559 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_KX3_H /* 1180095 */:
                case FinalCanbus.CAR_RZC3_XianDai_Sorento_21 /* 1311167 */:
                case FinalCanbus.CAR_RZC3_XianDai_Sorento_21_H /* 1376703 */:
                case FinalCanbus.CAR_RZC3_XianDai_Sorento_21_M /* 1442239 */:
                case FinalCanbus.CAR_RZC3_XianDai_SONATA_21 /* 1507775 */:
                case FinalCanbus.CAR_RZC3_XianDai_AZERA_22 /* 1573311 */:
                case FinalCanbus.CAR_RZC3_XianDai_CRETA_22 /* 1638847 */:
                case FinalCanbus.CAR_RZC3_XianDai_STARGAZER_22 /* 1704383 */:
                case FinalCanbus.CAR_RZC3_XianDai_SONATA_21_M /* 1769919 */:
                case FinalCanbus.CAR_RZC3_XianDai_AZERA_22_M /* 1835455 */:
                case FinalCanbus.CAR_RZC3_XianDai_CRETA_22_M /* 1900991 */:
                case FinalCanbus.CAR_RZC3_XianDai_STARGAZER_22_M /* 1966527 */:
                case FinalCanbus.CAR_RZC3_XianDai_SONATA_21_H /* 2032063 */:
                case FinalCanbus.CAR_RZC3_XianDai_AZERA_22_H /* 2097599 */:
                case FinalCanbus.CAR_RZC3_XianDai_CRETA_22_H /* 2163135 */:
                case FinalCanbus.CAR_RZC3_XianDai_STARGAZER_22_H /* 2228671 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_ENCINO /* 3342783 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_ENCINO_H /* 3408319 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyRZCXiandai;
                    DataPack.mCurrentUpdatteCode = new int[]{195};
                    break;
                case FinalCanbus.CAR_LUZ_ZhongTaiT600 /* 327945 */:
                case FinalCanbus.CAR_BNR_ZhongTaiT600 /* 393481 */:
                case FinalCanbus.CAR_BNR_SR7 /* 524553 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyZhongTaiT600_Bnr;
                    DataPack.mCurrentUpdatteCode = new int[]{150};
                    break;
                case FinalCanbus.CAR_BNR_XP1_AoDeSai /* 327978 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyBNRAds;
                    DataPack.mCurrentUpdatteCode = new int[]{164};
                    break;
                case FinalCanbus.CAR_WC2_GUOCHAN_6 /* 393611 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyZhongTai;
                    DataPack.mCurrentUpdatteCode = new int[]{145};
                    break;
                case FinalCanbus.CAR_450_CM_ZHTD_BMWM /* 393666 */:
                    int CustomerId = SystemProperties.getInt("ro.build.fytmanufacturer", 0);
                    if (CustomerId == 95) {
                        DataPack.mCurrentNotify = DataPack.mNotifyCMTZYBMW;
                        DataPack.mCurrentUpdatteCode = new int[]{164, 104, 163};
                        break;
                    }
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_19FeiSiTa /* 459114 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyRZCXiandai;
                    DataPack.mCurrentUpdatteCode = new int[]{104};
                    break;
                case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown /* 590253 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown /* 655789 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown_L /* 721325 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown_L /* 786861 */:
                case FinalCanbus.CAR_DJ_XC_Nissan_Tianlai_03_07 /* 852397 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_10_13PRADO /* 917933 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_08_15LAND_CRUISER /* 983469 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyXcToyota;
                    DataPack.mCurrentUpdatteCode = new int[]{119};
                    break;
                case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15_YC /* 590279 */:
                case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15H_YC /* 655815 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyKycYCAishow;
                    DataPack.mCurrentUpdatteCode = new int[]{171, 65, 16, 67, 62, 18, 19, 20, 33, 10, 42, 46, 47};
                    break;
                case FinalCanbus.CAR_443_WC2_MAZD_ALL_AKSL /* 721339 */:
                case FinalCanbus.CAR_443_WC2_MAZD_ALL_CX5 /* 786875 */:
                case FinalCanbus.CAR_443_WC2_MAZD_ALL_CX4 /* 917947 */:
                case FinalCanbus.CAR_443_WC2_MAZD_ALL_ATZ /* 983483 */:
                case FinalCanbus.CAR_439_OuDi_MZD_ALL /* 2097591 */:
                case FinalCanbus.CAR_439_BNR_MZD_ALL /* 8061367 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyWcMzdWarn;
                    DataPack.mCurrentUpdatteCode = new int[]{170, 171, 172, 173};
                    break;
                case FinalCanbus.CAR_453_PA_Ford_F150_10_CD /* 721349 */:
                case FinalCanbus.CAR_453_PA_Ford_Mustang_10_CD /* 5702085 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyPAFord;
                    DataPack.mCurrentUpdatteCode = new int[]{148};
                    break;
                case FinalCanbus.CAR_444_WC2_DAIHATSU_All /* 786876 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyWC2DAIHATSUPark;
                    DataPack.mCurrentUpdatteCode = new int[]{1, 2, 3, 4};
                    break;
                case FinalCanbus.CAR_RZC_XP1_09_15Previa /* 1048688 */:
                case FinalCanbus.CAR_RZC_XP1_Lexus_LS_04_06 /* 2883696 */:
                case FinalCanbus.CAR_RZC_XP1_05_REIZ /* 3407984 */:
                case FinalCanbus.CAR_RZC_Toyota_Prado_02_L /* 4653168 */:
                case FinalCanbus.CAR_RZC_Toyota_Prado_02_H /* 4718704 */:
                case FinalCanbus.CAR_RZC_XP1_05_REIZ_H /* 4784240 */:
                case FinalCanbus.CAR_RZC_Toyota_Prado_10_CD /* 4849776 */:
                case FinalCanbus.CAR_RZC_Toyota_LandCruiser_13_ABC /* 4980848 */:
                case FinalCanbus.CAR_RZC_XP1_Lexus_IS_06 /* 5505136 */:
                case FinalCanbus.CAR_RZC_XP1_Lexus_IS_06_H /* 5570672 */:
                case FinalCanbus.CAR_RZC_XP1_Lexus_ES_06 /* 5636208 */:
                case FinalCanbus.CAR_RZC_XP1_Lexus_ES_06_H /* 5701744 */:
                case FinalCanbus.CAR_RZC_Toyota_PRIUS_CD /* 5767280 */:
                case FinalCanbus.CAR_RZC_XP1_Lexus_LS460 /* 5898352 */:
                case FinalCanbus.CAR_RZC_XP1_Lexus_LS460_H /* 5963888 */:
                case FinalCanbus.CAR_RZC_XP1_LC100 /* 6029424 */:
                case FinalCanbus.CAR_RZC_XP1_LC100_H /* 6094960 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyRZCToyota;
                    DataPack.mCurrentUpdatteCode = new int[]{189};
                    break;
                case FinalCanbus.CAR_RZC_XP1_18YuanJing /* 1114251 */:
                    DataPack.mCurrentNotify = DataPack.mNotify18JiliYuanjing;
                    DataPack.mCurrentUpdatteCode = new int[]{180, 194, 195, 196};
                    break;
                case FinalCanbus.CAR_WC2_PSAALL_407_06 /* 1245436 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyWCPSA407;
                    DataPack.mCurrentUpdatteCode = new int[]{217};
                    break;
                case FinalCanbus.CAR_PA_dorango_13_18_Low /* 1376630 */:
                case FinalCanbus.CAR_PA_dorango_13_18_H /* 1442166 */:
                case FinalCanbus.CAR_PA_RAM_13_18_Low /* 1507702 */:
                case FinalCanbus.CAR_PA_RAM_13_18_H /* 1573238 */:
                case FinalCanbus.CAR_PA_Wrangler_18_20_Low /* 1638774 */:
                case FinalCanbus.CAR_PA_Wrangler_18_20_H /* 1704310 */:
                case FinalCanbus.CAR_PA_RAM_20_H /* 1835382 */:
                case FinalCanbus.CAR_PA_RAM_20_Low /* 1900918 */:
                case FinalCanbus.CAR_PA_RAM_22_H /* 2097526 */:
                case FinalCanbus.CAR_PA_RAM_22_Low /* 2163062 */:
                case FinalCanbus.CAR_PA_Cherokee_14_22 /* 2621814 */:
                case FinalCanbus.CAR_PA_GrandCherokee_14_22 /* 2687350 */:
                case FinalCanbus.CAR_PA_Chrysler_300C_11_22 /* 2752886 */:
                case FinalCanbus.CAR_PA_Dodge_Challenger_08_14 /* 2818422 */:
                case FinalCanbus.CAR_PA_RAM_13_18_Low_win4 /* 5177718 */:
                case FinalCanbus.CAR_PA_Cherokee_14_22_Amp /* 5243254 */:
                case FinalCanbus.CAR_PA_GrandCherokee_14_22_Amp /* 5308790 */:
                case FinalCanbus.CAR_PA_Gladiator_20_23 /* 5374326 */:
                case FinalCanbus.CAR_PA_Gladiator_20_23_Amp /* 5439862 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyPAJeepBrakeMode;
                    DataPack.mCurrentUpdatteCode = new int[]{370};
                    break;
                case FinalCanbus.CAR_444_WC2_IKCO_Tara_21 /* 1376700 */:
                case FinalCanbus.CAR_444_WC2_IKCO_Dena_15 /* 1442236 */:
                case FinalCanbus.CAR_444_WC2_IKCO_Soren_07 /* 1507772 */:
                case FinalCanbus.CAR_444_WC2_Saipa_Shahin_20 /* 1573308 */:
                case FinalCanbus.CAR_444_WC2_IKCO_207i_17 /* 1638844 */:
                case FinalCanbus.CAR_444_WC2_AMICO_Asena_15 /* 1704380 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyWCIKCODrivemode;
                    DataPack.mCurrentUpdatteCode = new int[]{111, 112};
                    break;
                case FinalCanbus.CAR_RZC_19Mingjue_MG6 /* 1507601 */:
                case FinalCanbus.CAR_RZC_17Rongwei_EI6 /* 1573137 */:
                case FinalCanbus.CAR_CZH_RZC_19Mingjue_MG6 /* 2097425 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyEi6;
                    DataPack.mCurrentUpdatteCode = new int[]{176, 178};
                    break;
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto /* 1507782 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyLzMustangAutoPark;
                    DataPack.mCurrentUpdatteCode = new int[]{170, 171, 172, 173};
                    break;
                case FinalCanbus.CAR_RZC_XP1_21Xiaomayi_EQ1 /* 1638804 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyRZCXiaomayi;
                    DataPack.mCurrentUpdatteCode = new int[]{143};
                    break;
                case FinalCanbus.CAR_RZC4_PSA_04_407_CD /* 1704275 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyRZC407PsaAll;
                    DataPack.mCurrentUpdatteCode = new int[]{226, 227, 228, 229, 230, 231, 232, 233, 234};
                    break;
                case FinalCanbus.CAR_RZC_FengGuang19E3 /* 1769786 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyRZCDongfengE3;
                    DataPack.mCurrentUpdatteCode = new int[]{124};
                    break;
                case FinalCanbus.CAR_453_OD_Jiangling_Kaiyun /* 1769925 */:
                case FinalCanbus.CAR_453_OD_Jiangling_Kaiyun_H /* 1835461 */:
                case FinalCanbus.CAR_453_OD_Ford_PRO_23 /* 8389061 */:
                case FinalCanbus.CAR_452_OD_Ford_PRO /* 8454596 */:
                case FinalCanbus.CAR_452_OD_Ford_PRO_H /* 9241028 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyODFordPro;
                    DataPack.mCurrentUpdatteCode = new int[]{130};
                    break;
                case FinalCanbus.CAR_RZC_XP1_Boyue_Pro_20 /* 2162827 */:
                case FinalCanbus.CAR_RZC_XP1_Jiaji_21 /* 2424971 */:
                case FinalCanbus.CAR_RZC_XP1_Dihaoe_22 /* 2621579 */:
                    DataPack.mCurrentNotify = DataPack.mNotify20boyue;
                    DataPack.mCurrentUpdatteCode = new int[]{186};
                    break;
                case FinalCanbus.CAR_455_OUDI_Aiying_BYD_ALL /* 2556359 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyAiyBYDPM25show;
                    DataPack.mCurrentUpdatteCode = new int[]{175, 105, 113, 114};
                    break;
                case FinalCanbus.CAR_439_LUZ_LEXUS_IS /* 3080631 */:
                case FinalCanbus.CAR_439_LUZ_LEXUS_IS_H /* 3146167 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyLZLeuxs;
                    DataPack.mCurrentUpdatteCode = new int[]{142};
                    break;
                case FinalCanbus.CAR_Oudi_Jili_Binyue_Pro /* 3211403 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyODJiliBinyuePro;
                    DataPack.mCurrentUpdatteCode = new int[]{216, 171};
                    break;
                case FinalCanbus.CAR_443_WC2_XianDai_All_19Shengda /* 3473851 */:
                case FinalCanbus.CAR_443_WC2_XianDai_All_19Shengda_H /* 3867067 */:
                case FinalCanbus.CAR_443_WC2_XianDai_All_18OPTIMA /* 15073723 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyWCXiandaiSeat;
                    DataPack.mCurrentUpdatteCode = new int[]{103, 104, 105};
                    break;
                case FinalCanbus.CAR_RZC_UAZ /* 3539346 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyRZCUAZPatriot;
                    DataPack.mCurrentUpdatteCode = new int[]{188};
                    break;
                case FinalCanbus.CAR_452_XC_08_Yage /* 3604932 */:
                case FinalCanbus.CAR_452_XC_Honda_SPIRIOR_09_13 /* 6291908 */:
                case FinalCanbus.CAR_452_XC_Honda_Crosstour_11_12 /* 6357444 */:
                case FinalCanbus.CAR_452_WC_Honda_Yage8 /* 12321220 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyXcYage8;
                    DataPack.mCurrentUpdatteCode = new int[]{132, 135, 136, 137, 139};
                    break;
                case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD /* 4719035 */:
                case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD_HW /* 4915643 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyWCTianlai;
                    DataPack.mCurrentUpdatteCode = new int[]{144, 145, 146, 147, 148, 149, 150};
                    break;
                case FinalCanbus.CAR_452_DJ_Dodge_JCUV /* 4981188 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyDJDoggeJcuv;
                    DataPack.mCurrentUpdatteCode = new int[]{111};
                    break;
                case FinalCanbus.CAR_RZC_HONDA_CRV_TW6_L /* 5374250 */:
                case FinalCanbus.CAR_RZC_HONDA_CRV_TW6_CCD /* 5505322 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyRZCTWCRVPark;
                    DataPack.mCurrentUpdatteCode = new int[]{216, 311, 312, 313, 314, 315, 316, 317};
                    break;
                case FinalCanbus.CAR_WC2_CG_Honda_16Civic /* 5505345 */:
                case FinalCanbus.CAR_WC2_CG_Honda_16Civic_H /* 5570881 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyWCCGHondaAishow;
                    DataPack.mCurrentUpdatteCode = new int[]{212, 65, 16, 62, 77};
                    break;
                case FinalCanbus.CAR_443_WC2_JiangHuai_T8_H /* 5702075 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyWCJianghuaiT8;
                    DataPack.mCurrentUpdatteCode = new int[]{130};
                    break;
                case FinalCanbus.CAR_453_RZC_Jianghuai_S7_H /* 6095301 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyRZCJianghuaiS7360View;
                    DataPack.mCurrentUpdatteCode = new int[]{164, 165, 166, 167};
                    break;
                case FinalCanbus.CAR_452_XC_Ford_Escape_13_17 /* 6422980 */:
                case FinalCanbus.CAR_452_XC_Ford_edge_11_13 /* 6488516 */:
                case FinalCanbus.CAR_452_XC_Ford_Raptor_F150_09_14 /* 6554052 */:
                case FinalCanbus.CAR_452_XC_Ford_edge_15_17 /* 6619588 */:
                case FinalCanbus.CAR_452_XC_Ford_Mondeo_13_18 /* 6685124 */:
                case FinalCanbus.CAR_439_HC_Ford_Explorer /* 15335863 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyXcFord;
                    DataPack.mCurrentUpdatteCode = new int[]{123};
                    break;
                case FinalCanbus.CAR_443_WC2_UAZ_Patriot /* 6947259 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyWCUAZPatriot;
                    DataPack.mCurrentUpdatteCode = new int[]{98};
                    break;
                case FinalCanbus.CAR_452_LZ_Subaru_TRIBECA /* 7078340 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyLZSubaru;
                    DataPack.mCurrentUpdatteCode = new int[]{98, 99, 100, 101, 102, 103, 136};
                    break;
                case FinalCanbus.CAR_452_RZC_Beiqi_BJ90 /* 7274948 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyRZCBj90;
                    DataPack.mCurrentUpdatteCode = new int[]{64};
                    break;
                case FinalCanbus.CAR_452_XC_Rongwei_ALl /* 7471556 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyXcRongwei;
                    DataPack.mCurrentUpdatteCode = new int[]{124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 143};
                    break;
                case FinalCanbus.CAR_452_OD_HZ_Nezha /* 7602628 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyODHzNezha;
                    DataPack.mCurrentUpdatteCode = new int[]{98};
                    break;
                case FinalCanbus.CAR_453_LZ_ALFA_ROMEO /* 7930309 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyLZRomeoBrakeMode;
                    DataPack.mCurrentUpdatteCode = new int[]{103};
                    break;
                case FinalCanbus.CAR_443_WC2_Alfa_Romeo_Stelvio /* 8126907 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_Toro_19_H /* 8192443 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_Toro_19_L /* 8257979 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_Strada_19_H /* 8323515 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_Strada_19_L /* 8389051 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_500x_20_H /* 8454587 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_500x_20_L /* 8520123 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyWCFeiyateBrake;
                    DataPack.mCurrentUpdatteCode = new int[]{147};
                    break;
                case FinalCanbus.CAR_452_XC_LEXUS_ES250 /* 8520132 */:
                case FinalCanbus.CAR_452_XC_LEXUS_RX270 /* 8585668 */:
                case FinalCanbus.CAR_452_XC_Lexus_ES200 /* 14418372 */:
                case FinalCanbus.CAR_452_XC_Lexus_CT200 /* 14483908 */:
                case FinalCanbus.CAR_452_XC_Lexus_NX200 /* 14549444 */:
                case FinalCanbus.CAR_452_XC_Lexus_RX350 /* 14614980 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyXcLexus;
                    DataPack.mCurrentUpdatteCode = new int[]{98, 99, 100, 101, 102, 103, 104, 105};
                    break;
                case FinalCanbus.CAR_452_XC_Nissan_Tule_CD /* 8716740 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyXcTule;
                    DataPack.mCurrentUpdatteCode = new int[]{140};
                    break;
                case FinalCanbus.CAR_452_TZY_UAZ_Patriot /* 11993540 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyUAZPatriot;
                    DataPack.mCurrentUpdatteCode = new int[]{0, 1};
                    break;
                case FinalCanbus.CAR_439_OUDI_Beiqi_EC3 /* 14090679 */:
                case FinalCanbus.CAR_439_OUDI_Beiqi_EC5 /* 14156215 */:
                case FinalCanbus.CAR_439_OUDI_Beiqi_EC180 /* 14221751 */:
                case FinalCanbus.CAR_439_OUDI_Beiqi_EC220 /* 14287287 */:
                case FinalCanbus.CAR_439_OUDI_Beiqi_EU5 /* 14352823 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyOdBeiqiEC;
                    DataPack.mCurrentUpdatteCode = new int[]{99};
                    break;
                case FinalCanbus.CAR_443_WC2_BENZ_C200_08_CD /* 14287291 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyWCBenzC200;
                    DataPack.mCurrentUpdatteCode = new int[]{125};
                    break;
                case FinalCanbus.CAR_454_OD_ChangAn_Raeton_H /* 14418374 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyODRaetonPark;
                    DataPack.mCurrentUpdatteCode = new int[]{134, 131};
                    break;
                case FinalCanbus.CAR_452_Luz_Audi_A4L_Low /* 14811588 */:
                case FinalCanbus.CAR_452_Luz_Audi_A4L_H /* 14877124 */:
                case FinalCanbus.CAR_452_Luz_Audi_Q5_Low /* 14942660 */:
                case FinalCanbus.CAR_452_Luz_Audi_Q5_H /* 15008196 */:
                case FinalCanbus.CAR_452_Luz_Audi_A6L_Low /* 15073732 */:
                case FinalCanbus.CAR_452_Luz_Audi_A6L_H /* 15139268 */:
                case FinalCanbus.CAR_452_Luz_Audi_Q7_Low /* 15204804 */:
                case FinalCanbus.CAR_452_Luz_Audi_Q7_H /* 15270340 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyAdui_LuzHp;
                    DataPack.mCurrentUpdatteCode = new int[]{153, 27, 28, 21, 25, 77, 87, 29, 30};
                    break;
                case FinalCanbus.CAR_443_WC2_Ford_12Focus_Overseas /* 15139259 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyWCFocusAutoPark;
                    DataPack.mCurrentUpdatteCode = new int[]{114};
                    break;
                case FinalCanbus.CAR_439_HC_Junyue_Old /* 16122295 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyGl8Old;
                    DataPack.mCurrentUpdatteCode = new int[]{1};
                    break;
                case FinalCanbus.CAR_453_XC_Ford_EDGE_H /* 16187845 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyXcFordEDGE;
                    DataPack.mCurrentUpdatteCode = new int[]{100};
                    break;
                case FinalCanbus.CAR_453_OD_Modernin /* 16384453 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyODModernin;
                    DataPack.mCurrentUpdatteCode = new int[]{152, 153, 154, 155, 156, 157, 158};
                    break;
                case FinalCanbus.CAR_443_WC2_Proton_S70_24 /* 16449979 */:
                case FinalCanbus.CAR_443_WC2_Proton_S70_24_H /* 16515515 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyWCProtonS70;
                    DataPack.mCurrentUpdatteCode = new int[]{127};
                    break;
            }
            if (DataPack.mCurrentUpdatteCode != null && DataPack.mCurrentNotify != null) {
                for (int i2 : DataPack.mCurrentUpdatteCode) {
                    DataCanbus.NOTIFY_EVENTS[i2].addNotify(DataPack.mCurrentNotify, 1);
                }
            }
        }
    };
    static IUiNotify mNotifyRuiJie15 = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 107:
                    if (ints != null && ints.length > 1) {
                        if (DataPack.sWCRuijieWarnIndex != ints[0]) {
                            DataPack.sWCRuijieWarnIndex = ints[0];
                        }
                        if (DataPack.sWCRuijieWarnStatus != ints[1]) {
                            DataPack.sWCRuijieWarnStatus = ints[1];
                        }
                        UIWarn.refreshWarnUI();
                        break;
                    }
            }
        }
    };
    static IUiNotify mNotifyFocus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 104:
                    if (DataPack.sPackWarm != DataCanbus.DATA[updateCode]) {
                        DataPack.sPackWarm = DataCanbus.DATA[updateCode];
                        UIWarn.refreshPack();
                        break;
                    }
                case 111:
                    if (ints != null && ints.length > 1) {
                        if (DataPack.sWCRuijieWarnIndex != ints[0]) {
                            DataPack.sWCRuijieWarnIndex = ints[0];
                        }
                        if (DataPack.sWCRuijieWarnStatus != ints[1]) {
                            DataPack.sWCRuijieWarnStatus = ints[1];
                        }
                        UIWarn.refreshFocusWarnUI();
                        break;
                    }
            }
        }
    };
    static IUiNotify mNotifyWCXiandaiSeat = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIWCXiandaiSeat.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyLzMustangAutoPark = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UILZFordMustang.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyRZCJianghuaiS7360View = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIRZCJiangHuaiS7ParkUI.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyRZCTWCRVPark = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIRZCTWCRVParkUI.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyODRaetonPark = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIODRaetonParkUI.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyWC2DAIHATSUPark = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIWC2DAIHATSUParkUI.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyAiyBYDPM25show = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Log.v("zed", "updateCode = " + updateCode + "---------- DataCanbus.DATA[updateCode] = " + DataCanbus.DATA[updateCode]);
            UIAYBYDPM25UIShow.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyWCYuncheAishow = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Log.v("zed", "updateCode = " + updateCode + "---------- DataCanbus.DATA[updateCode] = " + DataCanbus.DATA[updateCode]);
            UIWCYuncheShowAir.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyLzYLAishow = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Log.v("zed", "updateCode = " + updateCode + "---------- DataCanbus.DATA[updateCode] = " + DataCanbus.DATA[updateCode]);
            UILZYilingShowAir.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyKycYCAishow = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Log.v("zed", "updateCode = " + updateCode + "---------- DataCanbus.DATA[updateCode] = " + DataCanbus.DATA[updateCode]);
            UIKYCYichangShowAir.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyWCCGHondaAishow = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Log.v("zed", "updateCode = " + updateCode + "---------- DataCanbus.DATA[updateCode] = " + DataCanbus.DATA[updateCode]);
            UIWCCGHondaShowAir.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyWCFocusAutoPark = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIWCFordFocus.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyXPPsaAutoPark = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIXPPsaAutoPark.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyODModernin = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIODModernin.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotify18JiliYuanjing = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIRZC18Yuanjing.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyUAZPatriot = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIUAZPatriot.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyRzcZhongtaiT600 = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIRzcZhongtaiT600PM25.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyWCUAZPatriot = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIWCUAZPatriot.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyRZCUAZPatriot = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIRZCUAZPatriot.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyLZRomeoBrakeMode = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 103) {
                UILZRomeoBrakeMode.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyWCProtonS70 = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 127) {
                UIWCProtonS70Mode.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyWCIKCODrivemode = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIWCIKCODriveMode.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyWCLandRover = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 100) {
                UIWCLandRoverDriveMode.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyPAJeepBrakeMode = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 370 && DataCanbus.DATA[updateCode] != 0) {
                UIPAJeepBrakeMode.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyXcYage8 = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 139 && DataCanbus.DATA[updateCode] == 0) {
                UIXCYage8MenuList.getInstance().Hideindow();
            } else {
                UIXCYage8MenuList.getInstance().showWindowTip(DataCanbus.DATA[updateCode], updateCode);
            }
        }
    };
    static IUiNotify mNotifyXcFord = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 123) {
                if (FinalCanbus.num >= 0) {
                    UIXCTianlai.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyWCJianghuaiT8 = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 130 && DataCanbus.DATA[updateCode] != 0) {
                UIWCJianghuaiT8.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyRZCBj90 = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 64) {
                UIRzcBj90.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyLZPsaAll = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UILZPsaAll.getInstance().showWindowTip(DataCanbus.DATA[updateCode], updateCode);
        }
    };
    static IUiNotify mNotifyRZC407PsaAll = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIRZCPsa407All.getInstance().showWindowTip(DataCanbus.DATA[updateCode], updateCode);
        }
    };
    static IUiNotify mNotifyWCTianlai = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (!WC08TianlaiCarEqAct.mIsFront) {
                UIWCNissan08TianlaiAll.getInstance().showWindowTip(DataCanbus.DATA[updateCode], updateCode);
            }
        }
    };
    static IUiNotify mNotifyLZLeuxs = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 142 && !LZLexusISCarSet.isFront) {
                if (FinalCanbus.num >= 0) {
                    UIXCTianlai.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyWCPSA407 = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 217) {
                if (FinalCanbus.num >= 0) {
                    UIXCTianlai.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyPAFord = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 131) {
                if (FinalCanbus.num >= 0) {
                    UIPAFordF150Vol.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                    return;
                } else {
                    FinalCanbus.num++;
                    return;
                }
            }
            if (updateCode == 148) {
                UIPAFordF150Show.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyCMTZYBMW = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UICMBMW_WarnState.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyWcMzdWarn = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIWCMzdWarn.getInstance().showWindowTip(DataCanbus.DATA[updateCode], updateCode);
        }
    };
    static IUiNotify mNotifyWCFeiyateBrake = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 147) {
                UIWCFeiyateBrake.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyWCBenzC200 = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 125) {
                UIWCBenzC200.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyXcTianlai = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 115) {
                if (FinalCanbus.num >= 0) {
                    UIXCTianlai.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyODJiliBinyuePro = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 216) {
                if (FinalCanbus.num >= 0) {
                    UIOudiSocShow.getInstance().showWindowTip();
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyRZCToyota = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 189) {
                if (FinalCanbus.num >= 0) {
                    UIXCTianlai.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyXcFordEDGE = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 100) {
                if (FinalCanbus.num >= 0) {
                    UIXCTianlai.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyBNRAds = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 164 && !Act_CarCD_AoDeSai.mIsFront) {
                if (FinalCanbus.num >= 0) {
                    UIXCTianlai.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyWCHuangguan = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 127) {
                if (FinalCanbus.num >= 0) {
                    UIXCTianlai.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyRZCXiaomayi = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 143) {
                if (FinalCanbus.num >= 0) {
                    UIRZCXiaomayi.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyRZCDongfengE3 = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 124) {
                if (FinalCanbus.num >= 0) {
                    UIRZCDongfengE3.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyXcTianlaiGJ = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 106) {
                if (FinalCanbus.num >= 0) {
                    UIXCTianlai.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyODFordPro = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 130) {
                if (FinalCanbus.num >= 0) {
                    UIODFordPro.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyDJDoggeJcuv = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 111) {
                if (FinalCanbus.num >= 0) {
                    UIXCTianlai.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyXcTule = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 140) {
                if (FinalCanbus.num >= 0) {
                    UIXCTianlai.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyRZCXiandai = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (FinalCanbus.num >= 0) {
                UIRZCXiandai.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            } else {
                FinalCanbus.num++;
            }
        }
    };
    static IUiNotify mNotifyODHzNezha = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 98) {
                ODHZNezha.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyXcLexus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIXCLexus.getInstance().showWindowTip(DataCanbus.DATA[updateCode], updateCode);
        }
    };
    static IUiNotify mNotifyZHToyotaProace = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIZHToyotaProace.getInstance().showWindowTip(DataCanbus.DATA[updateCode], updateCode);
        }
    };
    static IUiNotify mNotifyXcRongwei = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIXCRongwei950.getInstance().showWindowTip(DataCanbus.DATA[updateCode], updateCode);
        }
    };
    static IUiNotify mNotifyLZSubaru = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UILZSubaru.getInstance().showWindowTip(DataCanbus.DATA[updateCode], updateCode);
        }
    };
    static IUiNotify mNotifyXcToyota = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 119) {
                UIXCTianlai.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyBus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 98) {
                UIWarn.showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyRZCBiaozhi = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if ((updateCode == 205 || updateCode == 206 || updateCode == 207) && DataCanbus.DATA[updateCode] != 0) {
                UIRZCBiaozhiWarn.getInstance().showWindowTip(DataCanbus.DATA[updateCode], updateCode);
            }
        }
    };
    static IUiNotify mNotifyEi6 = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIEi6Warn.getInstance().showWindowTip(DataCanbus.DATA[updateCode], updateCode);
        }
    };
    static IUiNotify mNotifyLandrover = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UILandroverWarn.getInstance().showWindowTip(DataCanbus.DATA[updateCode], updateCode);
        }
    };
    static IUiNotify mNotifyAX5 = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            WarnAX5.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyZhongTai = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            WarnZhongTaiX5.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyEC180 = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 104) {
                WarnEC180.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotify20boyue = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 186) {
                Warn20BoyuePro.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyXPMQBAirClear = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 235) {
                WarnXpMQBClearAir.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyRZCMQBTireWarn = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 378 || updateCode == 379) {
                WarnRZCMQBTire.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyGl8Old = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 1) {
                WarnGl8Old.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyOdBeiqiEC = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 99) {
                WarnEC180.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyZhongTaiT600_Bnr = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            WarnT600.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyAdui_Zhtd = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            WarnZhtdAudiAir.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyAdui_LuzHp = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (LauncherApplication.getConfiguration() != 1) {
                WarnLuzHpAudiAir.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
            }
        }
    };

    public static void init(Context context) {        
        addUpdate();
    }

    private static void addUpdate() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto /* 197052 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_P15_MC_EV /* 262588 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Auto /* 721340 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_GCC /* 852412 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV1 /* 917948 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV2 /* 983484 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV3 /* 1049020 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_OFFROAD /* 1114556 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto2 /* 1180092 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Iran /* 1900988 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_ADAS /* 3080636 */:
                DataCanbus.NOTIFY_EVENTS[1000].addNotify(mNotifyCanbus, 1);
                break;
            default:
                DataCanbus.NOTIFY_EVENTS[1000].addNotify(mNotifyCanbus, 0);
                break;
        }
    }
}
