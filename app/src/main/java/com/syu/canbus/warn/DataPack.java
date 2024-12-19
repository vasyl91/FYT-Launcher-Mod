package com.syu.canbus.warn;

import android.content.Context;
import android.os.SystemProperties;
import com.syu.carinfo.honda.Act_CarCD_AoDeSai;
import com.syu.carinfo.honda.Act_LEDScreen_AoDeSai_wc;
import com.syu.carinfo.wc.tianlaicd.WC08TianlaiCarEqAct;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class DataPack {
    public static int sPackWarm;
    public static int sWCRuijieWarnIndex;
    public static int sWCRuijieWarnStatus;
    static int mCurrentID = 0;
    static int[] mCurrentUpdatteCode = null;
    static IUiNotify mCurrentNotify = null;
    static IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.1
        @Override // com.syu.module.IUiNotify
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
                case FinalCanbus.CAR_RCW_XP1_Focus2015 /* 2556238 */:
                case FinalCanbus.CAR_RZC_XP1_Focus2015_Air /* 2949454 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyFocus;
                    DataPack.mCurrentUpdatteCode = new int[]{13, 6};
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
                    DataPack.mCurrentNotify = DataPack.mNotifyXPMQBAirClear;
                    DataPack.mCurrentUpdatteCode = new int[]{122};
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
                    DataPack.mCurrentNotify = DataPack.mNotifyRZCMQBTireWarn;
                    DataPack.mCurrentUpdatteCode = new int[]{386, 387};
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
                    DataPack.mCurrentNotify = DataPack.mNotifyRZCBiaozhi;
                    DataPack.mCurrentUpdatteCode = new int[]{194, 195, 196};
                    break;
                case 265:
                    DataPack.mCurrentNotify = DataPack.mNotifyRzcZhongtaiT600;
                    DataPack.mCurrentUpdatteCode = new int[]{81, 82, 83};
                    break;
                case 293:
                    DataPack.mCurrentNotify = DataPack.mNotifyRuiJie15;
                    DataPack.mCurrentUpdatteCode = new int[]{10};
                    break;
                case 388:
                case FinalCanbus.CAR_XC_08TianLai_LOW /* 65924 */:
                case FinalCanbus.CAR_XP_OLD_9TianLai /* 196996 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyXcTianlai;
                    DataPack.mCurrentUpdatteCode = new int[]{67};
                    break;
                case 420:
                case FinalCanbus.CAR_WC2_ToYoTa_Lexus_09IS_Low /* 721316 */:
                case FinalCanbus.CAR_WC2_ToYoTa_Lexus_06LS460 /* 786852 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyWCHuangguan;
                    DataPack.mCurrentUpdatteCode = new int[]{77};
                    break;
                case FinalCanbus.CAR_DJ_SHA_BUS /* 65944 */:
                case FinalCanbus.CAR_DJ_SHA_BUS_NOAIR /* 131480 */:
                case FinalCanbus.CAR_DJ_SHA_BUS_JiuLong /* 197016 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyBus;
                    DataPack.mCurrentUpdatteCode = new int[]{25};
                    break;
                case FinalCanbus.CAR_WC2_FengShenAX5 /* 65955 */:
                case FinalCanbus.CAR_WC2_16FengShenAX7 /* 1048995 */:
                case FinalCanbus.CAR_WC2_16FengShenAX7_L /* 1311139 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyAX5;
                    DataPack.mCurrentUpdatteCode = new int[]{50, 51, 52, 53, 54, 55, 56, 57, 58, 59};
                    break;
                case FinalCanbus.CAR_452_XC_Tianlai_GJ /* 65988 */:
                case FinalCanbus.CAR_453_XC_Tianlai_GJ /* 1442245 */:
                case FinalCanbus.CAR_439_HC_Nissan_GuiShi /* 7799223 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyXcTianlaiGJ;
                    DataPack.mCurrentUpdatteCode = new int[]{31};
                    break;
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_All /* 131434 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_All_H /* 524650 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyRZCXiandai;
                    DataPack.mCurrentUpdatteCode = new int[]{29};
                    break;
                case FinalCanbus.CAR_450_ZHTD_Audi /* 131522 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyAdui_Zhtd;
                    DataPack.mCurrentUpdatteCode = new int[]{40, 23, 24, 33, 34, 41, 42};
                    break;
                case FinalCanbus.CAR_RZC_BeiQi_EC180 /* 196835 */:
                case FinalCanbus.CAR_RZC_BeiQi_19EC5 /* 458979 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyEC180;
                    DataPack.mCurrentUpdatteCode = new int[]{92};
                    break;
                case FinalCanbus.CAR_LZ_XP1_PsaAll_CD /* 196889 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyLZPsaAll;
                    DataPack.mCurrentUpdatteCode = new int[]{141, 142, 143, 144, 145, 146, 147};
                    break;
                case FinalCanbus.CAR_LUZ_ZhongTaiT600 /* 327945 */:
                case FinalCanbus.CAR_BNR_ZhongTaiT600 /* 393481 */:
                case FinalCanbus.CAR_BNR_SR7 /* 524553 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyZhongTaiT600_Bnr;
                    DataPack.mCurrentUpdatteCode = new int[]{84};
                    break;
                case FinalCanbus.CAR_BNR_XP1_AoDeSai /* 327978 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyBNRAds;
                    DataPack.mCurrentUpdatteCode = new int[]{120};
                    break;
                case FinalCanbus.CAR_WC2_GUOCHAN_6 /* 393611 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyZhongTai;
                    DataPack.mCurrentUpdatteCode = new int[]{86};
                    break;
                case FinalCanbus.CAR_450_CM_ZHTD_BMWM /* 393666 */:
                    int CustomerId = SystemProperties.getInt("ro.build.fytmanufacturer", 0);
                    if (CustomerId == 95) {
                        DataPack.mCurrentNotify = DataPack.mNotifyCMTZYBMW;
                        DataPack.mCurrentUpdatteCode = new int[]{99, 13, 98};
                        break;
                    }
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_19FeiSiTa /* 459114 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyRZCXiandai;
                    DataPack.mCurrentUpdatteCode = new int[]{29};
                    break;
                case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown /* 590253 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown /* 655789 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown_L /* 721325 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown_L /* 786861 */:
                case FinalCanbus.CAR_DJ_XC_Nissan_Tianlai_03_07 /* 852397 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_10_13PRADO /* 917933 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_08_15LAND_CRUISER /* 983469 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyXcToyota;
                    DataPack.mCurrentUpdatteCode = new int[]{75};
                    break;
                case FinalCanbus.CAR_443_WC2_MAZD_ALL_AKSL /* 721339 */:
                case FinalCanbus.CAR_443_WC2_MAZD_ALL_CX5 /* 786875 */:
                case FinalCanbus.CAR_443_WC2_MAZD_ALL_CX4 /* 917947 */:
                case FinalCanbus.CAR_443_WC2_MAZD_ALL_ATZ /* 983483 */:
                case FinalCanbus.CAR_439_OuDi_MZD_ALL /* 2097591 */:
                case FinalCanbus.CAR_439_BNR_MZD_ALL /* 8061367 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyWcMzdWarn;
                    DataPack.mCurrentUpdatteCode = new int[]{102, 103, 104, 105};
                    break;
                case FinalCanbus.CAR_453_PA_Ford_F150_10_CD /* 721349 */:
                case FinalCanbus.CAR_453_PA_Ford_Mustang_10_CD /* 5702085 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyPAFord;
                    DataPack.mCurrentUpdatteCode = new int[]{78};
                    break;
                case FinalCanbus.CAR_452_RZC_LandRover_Discovery_15 /* 786884 */:
                case FinalCanbus.CAR_452_RZC_LandRover_RANGE_12 /* 2163140 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyLandrover;
                    DataPack.mCurrentUpdatteCode = new int[]{121, 122};
                    break;
                case FinalCanbus.CAR_RZC_XP1_18YuanJing /* 1114251 */:
                    DataPack.mCurrentNotify = DataPack.mNotify18JiliYuanjing;
                    DataPack.mCurrentUpdatteCode = new int[]{168, 182, 183, 184};
                    break;
                case FinalCanbus.CAR_WC2_PSAALL_407_06 /* 1245436 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyWCPSA407;
                    DataPack.mCurrentUpdatteCode = new int[]{205};
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
                    DataPack.mCurrentNotify = DataPack.mNotifyPAJeepBrakeMode;
                    DataPack.mCurrentUpdatteCode = new int[]{358};
                    break;
                case FinalCanbus.CAR_RZC_19Mingjue_MG6 /* 1507601 */:
                case FinalCanbus.CAR_RZC_17Rongwei_EI6 /* 1573137 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyEi6;
                    DataPack.mCurrentUpdatteCode = new int[]{108, 110};
                    break;
                case FinalCanbus.CAR_RZC_XP1_21Xiaomayi_EQ1 /* 1638804 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyRZCXiaomayi;
                    DataPack.mCurrentUpdatteCode = new int[]{131};
                    break;
                case FinalCanbus.CAR_RZC4_PSA_04_407_CD /* 1704275 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyRZC407PsaAll;
                    DataPack.mCurrentUpdatteCode = new int[]{215, 216, 217, 218, 219, 220, 221, 222, 223};
                    break;
                case FinalCanbus.CAR_RZC_FengGuang19E3 /* 1769786 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyRZCDongfengE3;
                    DataPack.mCurrentUpdatteCode = new int[]{112};
                    break;
                case FinalCanbus.CAR_453_OD_Jiangling_Kaiyun /* 1769925 */:
                case FinalCanbus.CAR_453_OD_Jiangling_Kaiyun_H /* 1835461 */:
                case FinalCanbus.CAR_453_OD_Ford_PRO_23 /* 8389061 */:
                case FinalCanbus.CAR_452_OD_Ford_PRO /* 8454596 */:
                case FinalCanbus.CAR_452_OD_Ford_PRO_H /* 9241028 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyODFordPro;
                    DataPack.mCurrentUpdatteCode = new int[]{118};
                    break;
                case FinalCanbus.CAR_RZC_XP1_Boyue_Pro_20 /* 2162827 */:
                case FinalCanbus.CAR_RZC_XP1_Jiaji_21 /* 2424971 */:
                case FinalCanbus.CAR_RZC_XP1_Dihaoe_22 /* 2621579 */:
                    DataPack.mCurrentNotify = DataPack.mNotify20boyue;
                    DataPack.mCurrentUpdatteCode = new int[]{174};
                    break;
                case FinalCanbus.CAR_439_LUZ_LEXUS_IS /* 3080631 */:
                case FinalCanbus.CAR_439_LUZ_LEXUS_IS_H /* 3146167 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyLZLeuxs;
                    DataPack.mCurrentUpdatteCode = new int[]{85};
                    break;
                case FinalCanbus.CAR_443_WC2_XianDai_All_19Shengda /* 3473851 */:
                case FinalCanbus.CAR_443_WC2_XianDai_All_19Shengda_H /* 3867067 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyWCXiandaiSeat;
                    DataPack.mCurrentUpdatteCode = new int[]{36, 37, 41};
                    break;
                case FinalCanbus.CAR_452_XC_08_Yage /* 3604932 */:
                case FinalCanbus.CAR_452_XC_Honda_SPIRIOR_09_13 /* 6291908 */:
                case FinalCanbus.CAR_452_XC_Honda_Crosstour_11_12 /* 6357444 */:
                case FinalCanbus.CAR_452_WC_Honda_Yage8 /* 12321220 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyXcYage8;
                    DataPack.mCurrentUpdatteCode = new int[]{52, 55, 56, 57, 59};
                    break;
                case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD /* 4719035 */:
                case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD_HW /* 4915643 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyWCTianlai;
                    DataPack.mCurrentUpdatteCode = new int[]{132, 133, 134, 135, 136, 137, 138};
                    break;
                case FinalCanbus.CAR_452_DJ_Dodge_JCUV /* 4981188 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyDJDoggeJcuv;
                    DataPack.mCurrentUpdatteCode = new int[]{42};
                    break;
                case FinalCanbus.CAR_443_WC2_JiangHuai_T8_H /* 5702075 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyWCJianghuaiT8;
                    DataPack.mCurrentUpdatteCode = new int[]{55};
                    break;
                case FinalCanbus.CAR_452_XC_Ford_Escape_13_17 /* 6422980 */:
                case FinalCanbus.CAR_452_XC_Ford_edge_11_13 /* 6488516 */:
                case FinalCanbus.CAR_452_XC_Ford_Raptor_F150_09_14 /* 6554052 */:
                case FinalCanbus.CAR_452_XC_Ford_edge_15_17 /* 6619588 */:
                case FinalCanbus.CAR_452_XC_Ford_Mondeo_13_18 /* 6685124 */:
                case FinalCanbus.CAR_439_HC_Ford_Explorer /* 15335863 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyXcFord;
                    DataPack.mCurrentUpdatteCode = new int[]{63};
                    break;
                case FinalCanbus.CAR_443_WC2_UAZ_Patriot /* 6947259 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyWCUAZPatriot;
                    DataPack.mCurrentUpdatteCode = new int[]{86};
                    break;
                case FinalCanbus.CAR_452_LZ_Subaru_TRIBECA /* 7078340 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyLZSubaru;
                    DataPack.mCurrentUpdatteCode = new int[]{22, 23, 24, 25, 26, 27, 60};
                    break;
                case FinalCanbus.CAR_452_RZC_Beiqi_BJ90 /* 7274948 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyRZCBj90;
                    DataPack.mCurrentUpdatteCode = new int[]{44};
                    break;
                case FinalCanbus.CAR_452_XC_Rongwei_ALl /* 7471556 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyXcRongwei;
                    DataPack.mCurrentUpdatteCode = new int[]{60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 79};
                    break;
                case FinalCanbus.CAR_452_OD_HZ_Nezha /* 7602628 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyODHzNezha;
                    DataPack.mCurrentUpdatteCode = new int[]{23};
                    break;
                case FinalCanbus.CAR_453_LZ_ALFA_ROMEO /* 7930309 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyLZRomeoBrakeMode;
                    DataPack.mCurrentUpdatteCode = new int[]{33};
                    break;
                case FinalCanbus.CAR_443_WC2_Alfa_Romeo_Stelvio /* 8126907 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_Toro_19_H /* 8192443 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_Toro_19_L /* 8257979 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_Strada_19_H /* 8323515 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_Strada_19_L /* 8389051 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_500x_20_H /* 8454587 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_500x_20_L /* 8520123 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyWCFeiyateBrake;
                    DataPack.mCurrentUpdatteCode = new int[]{135};
                    break;
                case FinalCanbus.CAR_452_XC_LEXUS_ES250 /* 8520132 */:
                case FinalCanbus.CAR_452_XC_LEXUS_RX270 /* 8585668 */:
                case FinalCanbus.CAR_452_XC_Lexus_ES200 /* 14418372 */:
                case FinalCanbus.CAR_452_XC_Lexus_CT200 /* 14483908 */:
                case FinalCanbus.CAR_452_XC_Lexus_NX200 /* 14549444 */:
                case FinalCanbus.CAR_452_XC_Lexus_RX350 /* 14614980 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyXcLexus;
                    DataPack.mCurrentUpdatteCode = new int[]{27, 28, 29, 30, 31, 32, 33, 34};
                    break;
                case FinalCanbus.CAR_452_XC_Nissan_Tule_CD /* 8716740 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyXcTule;
                    DataPack.mCurrentUpdatteCode = new int[]{128};
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
                    DataPack.mCurrentUpdatteCode = new int[]{21};
                    break;
                case FinalCanbus.CAR_452_Luz_Audi_A4L_Low /* 14811588 */:
                case FinalCanbus.CAR_452_Luz_Audi_A4L_H /* 14877124 */:
                case FinalCanbus.CAR_452_Luz_Audi_Q5_Low /* 14942660 */:
                case FinalCanbus.CAR_452_Luz_Audi_Q5_H /* 15008196 */:
                case FinalCanbus.CAR_452_Luz_Audi_A6L_Low /* 15073732 */:
                case FinalCanbus.CAR_452_Luz_Audi_A6L_H /* 15139268 */:
                case FinalCanbus.CAR_452_Luz_Audi_Q7_Low /* 15204804 */:
                case FinalCanbus.CAR_452_Luz_Audi_Q7_H /* 15270340 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyLZAudiQ5;
                    DataPack.mCurrentUpdatteCode = new int[]{59};
                    break;
                case FinalCanbus.CAR_439_HC_Junyue_Old /* 16122295 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyGl8Old;
                    DataPack.mCurrentUpdatteCode = new int[]{1};
                    break;
                case FinalCanbus.CAR_453_XC_Ford_EDGE_H /* 16187845 */:
                    DataPack.mCurrentNotify = DataPack.mNotifyXcFordEDGE;
                    DataPack.mCurrentUpdatteCode = new int[]{88};
                    break;
            }
            if (DataPack.mCurrentUpdatteCode != null && DataPack.mCurrentNotify != null) {
                for (int i2 : DataPack.mCurrentUpdatteCode) {
                    DataCanbus.NOTIFY_EVENTS[i2].addNotify(DataPack.mCurrentNotify, 1);
                }
            }
        }
    };
    static IUiNotify mNotifyRuiJie15 = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
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
    static IUiNotify mNotifyFocus = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.3
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 6:
                    if (DataPack.sPackWarm != DataCanbus.DATA[updateCode]) {
                        DataPack.sPackWarm = DataCanbus.DATA[updateCode];
                        UIWarn.refreshPack();
                        break;
                    }
                case 13:
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
    static IUiNotify mNotifyWCXiandaiSeat = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.4
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIWCXiandaiSeat.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotify07WCAodesai = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.5
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (!Act_LEDScreen_AoDeSai_wc.mIsFront) {
                if (FinalCanbus.num >= 0) {
                    UIWC07AoDeSai.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode], ints);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotify18JiliYuanjing = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.6
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIRZC18Yuanjing.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyUAZPatriot = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.7
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIUAZPatriot.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyRzcZhongtaiT600 = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.8
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIRzcZhongtaiT600PM25.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyWCUAZPatriot = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.9
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIWCUAZPatriot.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyLZRomeoBrakeMode = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.10
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 33) {
                UILZRomeoBrakeMode.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyPAJeepBrakeMode = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.11
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 358 && DataCanbus.DATA[updateCode] != 0) {
                UIPAJeepBrakeMode.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyXcYage8 = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.12
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 59 && DataCanbus.DATA[updateCode] == 0) {
                UIXCYage8MenuList.getInstance().Hideindow();
            } else {
                UIXCYage8MenuList.getInstance().showWindowTip(DataCanbus.DATA[updateCode], updateCode);
            }
        }
    };
    static IUiNotify mNotifyXcFord = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.13
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 63) {
                if (FinalCanbus.num >= 0) {
                    UIXCTianlai.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyWCJianghuaiT8 = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.14
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 55 && DataCanbus.DATA[updateCode] != 0) {
                UIWCJianghuaiT8.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyRZCBj90 = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.15
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 44) {
                UIRzcBj90.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyLZPsaAll = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.16
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UILZPsaAll.getInstance().showWindowTip(DataCanbus.DATA[updateCode], updateCode);
        }
    };
    static IUiNotify mNotifyRZC407PsaAll = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.17
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIRZCPsa407All.getInstance().showWindowTip(DataCanbus.DATA[updateCode], updateCode);
        }
    };
    static IUiNotify mNotifyWCTianlai = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.18
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (!WC08TianlaiCarEqAct.mIsFront) {
                UIWCNissan08TianlaiAll.getInstance().showWindowTip(DataCanbus.DATA[updateCode], updateCode);
            }
        }
    };
    static IUiNotify mNotifyLZLeuxs = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.19
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 85) {
                if (FinalCanbus.num >= 0) {
                    UIXCTianlai.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyWCPSA407 = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.20
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 205) {
                if (FinalCanbus.num >= 0) {
                    UIXCTianlai.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyPAFord = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.21
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 61) {
                if (FinalCanbus.num >= 0) {
                    UIPAFordF150Vol.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                    return;
                } else {
                    FinalCanbus.num++;
                    return;
                }
            }
            if (updateCode == 78) {
                UIPAFordF150Show.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyCMTZYBMW = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.22
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UICMBMW_WarnState.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyWcMzdWarn = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.23
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIWCMzdWarn.getInstance().showWindowTip(DataCanbus.DATA[updateCode], updateCode);
        }
    };
    static IUiNotify mNotifyWCFeiyateBrake = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.24
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 135) {
                UIWCFeiyateBrake.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyXcTianlai = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.25
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 67) {
                if (FinalCanbus.num >= 0) {
                    UIXCTianlai.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyXcFordEDGE = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.26
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 88) {
                if (FinalCanbus.num >= 0) {
                    UIXCTianlai.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyBNRAds = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.27
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 120 && !Act_CarCD_AoDeSai.mIsFront) {
                if (FinalCanbus.num >= 0) {
                    UIXCTianlai.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyWCHuangguan = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.28
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 77) {
                if (FinalCanbus.num >= 0) {
                    UIXCTianlai.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyRZCXiaomayi = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.29
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 131) {
                if (FinalCanbus.num >= 0) {
                    UIRZCXiaomayi.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyRZCDongfengE3 = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.30
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 112) {
                if (FinalCanbus.num >= 0) {
                    UIRZCDongfengE3.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyXcTianlaiGJ = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.31
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 31) {
                if (FinalCanbus.num >= 0) {
                    UIXCTianlai.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyODFordPro = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.32
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 118) {
                if (FinalCanbus.num >= 0) {
                    UIODFordPro.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyDJDoggeJcuv = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.33
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 42) {
                if (FinalCanbus.num >= 0) {
                    UIXCTianlai.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyXcTule = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.34
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 128) {
                if (FinalCanbus.num >= 0) {
                    UIXCTianlai.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyRZCXiandai = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.35
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 29) {
                if (FinalCanbus.num >= 0) {
                    UIRZCXiandai.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
                } else {
                    FinalCanbus.num++;
                }
            }
        }
    };
    static IUiNotify mNotifyLZAudiQ5 = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.36
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 59) {
                LuzAudiQ5.getInstance().showWindowTip();
            }
        }
    };
    static IUiNotify mNotifyODHzNezha = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.37
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 23) {
                ODHZNezha.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyXcLexus = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.38
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIXCLexus.getInstance().showWindowTip(DataCanbus.DATA[updateCode], updateCode);
        }
    };
    static IUiNotify mNotifyZHToyotaProace = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.39
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIZHToyotaProace.getInstance().showWindowTip(DataCanbus.DATA[updateCode], updateCode);
        }
    };
    static IUiNotify mNotifyXcRongwei = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.40
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIXCRongwei950.getInstance().showWindowTip(DataCanbus.DATA[updateCode], updateCode);
        }
    };
    static IUiNotify mNotifyLZSubaru = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.41
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UILZSubaru.getInstance().showWindowTip(DataCanbus.DATA[updateCode], updateCode);
        }
    };
    static IUiNotify mNotifyXcToyota = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.42
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 75) {
                UIXCTianlai.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyBus = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.43
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 25) {
                UIWarn.showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyRZCBiaozhi = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.44
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if ((updateCode == 194 || updateCode == 195 || updateCode == 196) && DataCanbus.DATA[updateCode] != 0) {
                UIRZCBiaozhiWarn.getInstance().showWindowTip(DataCanbus.DATA[updateCode], updateCode);
            }
        }
    };
    static IUiNotify mNotifyEi6 = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.45
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UIEi6Warn.getInstance().showWindowTip(DataCanbus.DATA[updateCode], updateCode);
        }
    };
    static IUiNotify mNotifyLandrover = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.46
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            UILandroverWarn.getInstance().showWindowTip(DataCanbus.DATA[updateCode], updateCode);
        }
    };
    static IUiNotify mNotifyAX5 = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.47
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            WarnAX5.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyZhongTai = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.48
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            WarnZhongTaiX5.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyEC180 = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.49
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 92) {
                WarnEC180.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotify20boyue = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.50
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 174) {
                Warn20BoyuePro.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyXPMQBAirClear = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.51
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 122) {
                WarnXpMQBClearAir.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyRZCMQBTireWarn = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.52
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 386 || updateCode == 387) {
                WarnRZCMQBTire.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyGl8Old = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.53
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 1) {
                WarnGl8Old.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyOdBeiqiEC = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.54
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 21) {
                WarnEC180.getInstance().showWindowTip(DataCanbus.DATA[updateCode]);
            }
        }
    };
    static IUiNotify mNotifyZhongTaiT600_Bnr = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.55
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            WarnT600.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };
    static IUiNotify mNotifyAdui_Zhtd = new IUiNotify() { // from class: com.syu.canbus.warn.DataPack.56
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            WarnZhtdAudiAir.getInstance().showWindowTip(updateCode, DataCanbus.DATA[updateCode]);
        }
    };

    public static void init(Context context) {
        addUpdate();
    }

    private static void addUpdate() {
        DataCanbus.NOTIFY_EVENTS[1000].addNotify(mNotifyCanbus, 0);
    }
}
