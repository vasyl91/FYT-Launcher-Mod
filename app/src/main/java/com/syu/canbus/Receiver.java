package com.syu.canbus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.air.Air_Activity_All_NewAdd_HP;
import com.syu.carinfo.air.Air_Activity_All_Toyota_prado_HP;
import com.syu.carinfo.air.Air_Activity_Daohang_Only_HP;
import com.syu.carinfo.air.ConstAllAirDara;
import com.syu.carinfo.aiying.ziyouguang.JeepCarAirSet;
import com.syu.carinfo.bg.ziyouguang.Bg_ZiYouGuangAirControlAct;
import com.syu.carinfo.biaozhi408.BZ408AirControlActi;
import com.syu.carinfo.bus.ActivityBusAirControl;
import com.syu.carinfo.byd.hcy.ActivityAirCrtrRZCFordMengdiou;
import com.syu.carinfo.byd.hcy.ActivityAirCrtrlBydSirui;
import com.syu.carinfo.byd.hcy.Activity_DaojunAirCrtrlBydG6;
import com.syu.carinfo.byd.hcy.Activity_DaojunAirCrtrlBydS6;
import com.syu.carinfo.byd.hcy.BYDAiyingIndexAct;
import com.syu.carinfo.byd.hcy.XBS_439_BYD_Song_AirControlAct;
import com.syu.carinfo.cxw.k50.BnrToyatoKuluzAirControlAct;
import com.syu.carinfo.cxw.k50.CxwK50AirControlAct;
import com.syu.carinfo.daojun.kaidilake.BnrChanganCS75AirControlAct;
import com.syu.carinfo.daojun.kaidilake.WcATSAirControlAct;
import com.syu.carinfo.daojun.kaidilake.WcXTSAirControlAct;
import com.syu.carinfo.daojun.kaidilake.djATSAirControlAct;
import com.syu.carinfo.daojun.kaidilake.djXTSAirControlAct;
import com.syu.carinfo.dasauto.TuRui_AirActi;
import com.syu.carinfo.dj.havalh8.Dj_0439_AirFrontCtrl;
import com.syu.carinfo.dj.huangguan.LZ_0439_Nissan_GTR_AirControlAct;
import com.syu.carinfo.dj.huangguan.LZ_0439_Toyota_AirControlAct;
import com.syu.carinfo.dj.huangguan.rzc_439_Huangguan_AirControlAct;
import com.syu.carinfo.dj.huangguan.rzc_6606_112_Toyota_AirControlAct;
import com.syu.carinfo.dongjian.ga6.GA6AirSeatControlAct;
import com.syu.carinfo.golf7.AirControlMQB_RZC_Front;
import com.syu.carinfo.golf7.AirControlMQB_WC_Front;
import com.syu.carinfo.golf7.AirControlMaiTengDZSJ;
import com.syu.carinfo.guochan.ActivityBenTengB50;
import com.syu.carinfo.guochan.ActivityHaiMaV70AirControl;
import com.syu.carinfo.guochan.AirQiChenT90;
import com.syu.carinfo.hc.tianlai.ActivityTianLaiFrontAirSetting;
import com.syu.carinfo.hc.tianlai.ActivityToread_AirRearCtrl;
import com.syu.carinfo.honda.ActivityAirControl;
import com.syu.carinfo.huiteng.Huiteng_AirFrontCtrl;
import com.syu.carinfo.huiteng.Huiteng_AirRearCtrl;
import com.syu.carinfo.jili.BoyueAirControlAct;
import com.syu.carinfo.jili.YuanJingX1AirControlAct;
import com.syu.carinfo.jili.YuanJingX1_AirControlAct_DJ;
import com.syu.carinfo.klc.KlcGl8AirControlAct;
import com.syu.carinfo.klc.MrbAirControlAct;
import com.syu.carinfo.leinuo.Act_Keleijia_Airset;
import com.syu.carinfo.leinuo.Act_Keleijia_Airset_high;
import com.syu.carinfo.lz.jaguar.JaguarAirControlAct;
import com.syu.carinfo.lz.lexusis.KYCLexusFrontAirControlAct;
import com.syu.carinfo.lz.lexusis.LuzDaoHangToyotaAirControlAct;
import com.syu.carinfo.lz.lexusis.LuzDaoHangToyotaAlphaAirControlAct;
import com.syu.carinfo.lz.lexusis.LuzLexusLSFrontAirControlAct;
import com.syu.carinfo.oudi.hantengx5.Oudi_0452_Hongqi_AirControlAct;
import com.syu.carinfo.qirui.ActivityRuiHu7;
import com.syu.carinfo.rzc.gs4.Rzc_Gs3_AirControlAct;
import com.syu.carinfo.rzc.gs4.Rzc_Gs8_AirControlAct;
import com.syu.carinfo.rzc.havalh6.Rzc_Oudi_0439_AirFrontCtrl;
import com.syu.carinfo.rzc.sanlin.KYCToyotaAllAirControlAct;
import com.syu.carinfo.rzc.sanlin.LuzJaguar09XFAirControlAct;
import com.syu.carinfo.rzc.sanlin.ODWeiEX5AirControlAct;
import com.syu.carinfo.rzc.t70.AirRzcQiChenT90;
import com.syu.carinfo.rzc.zhongtai.RzcChanganAirControlAct;
import com.syu.carinfo.saiou3.SO3AirControlAct;
import com.syu.carinfo.sbd.fordlieying.AirSBDFordLieYing;
import com.syu.carinfo.sbd_electric.Sbd_24vW3AirControlAct;
import com.syu.carinfo.sbd_electric.Sbd_AirControlAct;
import com.syu.carinfo.wc.crown.wc_420_crown_AirControlAct;
import com.syu.carinfo.wc.infeinidi.WcInfeinidiFrontAirControlAct;
import com.syu.carinfo.wc.ruijie15.LZBinliTianyueAirControlAct;
import com.syu.carinfo.wc.ruijie15.LZJaguarXJLFrontAirControlAct_SP;
import com.syu.carinfo.wc.ruijie15.NavigatorAirControlAct_Rzc;
import com.syu.carinfo.wc.ruijie15.RJ_GC_AirControlAct;
import com.syu.carinfo.wc.ruijie15.RZCRuijieFrontAirControlAct_SP;
import com.syu.carinfo.wc.ruijie15.RuijieAirControlAct_Rzc;
import com.syu.carinfo.wc.ruijie15.WcEverestFrontAirControlAct_SP;
import com.syu.carinfo.wc.ruijie15.WcRuiJieFrontAirControlAct;
import com.syu.carinfo.wc2.tata.WC2TataAirControlAct;
import com.syu.carinfo.wc2.weichai.WC2WeiChaiAirControlAct;
import com.syu.carinfo.xincheng.infiniti.Infiniti_XinCheng_ESQAirControl;
import com.syu.carinfo.xincheng.infiniti.Xincheng_Nissan_Tule_AirControlActi;
import com.syu.carinfo.xp.yinglang.XpMrbAirControlAct;
import com.syu.carinfo.xp.yinglang.YLAirControlAct_BNR;
import com.syu.carinfo.xp.yinglang.YLAirControlAct_LYDD;
import com.syu.carinfo.xp.ziyouguang.PAFordF150AirControlAct_SP;
import com.syu.carinfo.xp.ziyouguang.PAJeepAirControlAct_SP;
import com.syu.carinfo.xp.ziyouguang.PANissanAirControlAct_SP;
import com.syu.carinfo.xp.ziyouguang.PAToyota10TundraAirControlAct_SP;
import com.syu.carinfo.xp.ziyouguang.PAToyotaAirControlAct_SP;
import com.syu.carinfo.xp.ziyouguang.PAToyotaLexusLS460AirControlAct_SP;
import com.syu.carinfo.xp.ziyouguang.WCYuncheNissanAirControlAct;
import com.syu.carinfo.xp.ziyouguang.WCYuncheNissanAirControlAct_HP;
import com.syu.carinfo.xp.ziyouguang.WCYuncheUINissanAirControlAct;
import com.syu.carinfo.ztt600.ZTAirAct_Bnr;
import com.syu.carinfo.ztt600.ZTAirAct_Luz;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        boolean flag = false;
        switch (DataCanbus.DATA[1000]) {
            case 36:
            case 151:
            case 300:
            case 348:
            case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
            case FinalCanbus.CAR_RZC_XP1_YuanJingX6 /* 131211 */:
            case FinalCanbus.CAR_DAOJUN_XP1_XTS /* 131420 */:
            case FinalCanbus.CAR_RZC_XP1_YuanJingX1 /* 196747 */:
            case FinalCanbus.CAR_DJ_ShuPing_BYD_G6 /* 196759 */:
            case FinalCanbus.CAR_RZC_15Ruijie /* 196942 */:
            case FinalCanbus.CAR_DAOJUN_XP1_XTS_M /* 196956 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto /* 197052 */:
            case FinalCanbus.CAR_DJ_ShuPing_BYD_G6_H /* 262295 */:
            case FinalCanbus.CAR_RZC_ZhiSheng_Old /* 262478 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ATSL_Lo /* 262492 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_P15_MC_EV /* 262588 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
            case FinalCanbus.CAR_BNR_16CS75_L /* 393286 */:
            case FinalCanbus.CAR_RZC_Jinniu2018 /* 393550 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ATSL_Lowest /* 393564 */:
            case FinalCanbus.CAR_439_DJ_XP1_HuiTeng /* 393655 */:
            case FinalCanbus.CAR_BNR_16CS75_M /* 458822 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6 /* 458996 */:
            case FinalCanbus.CAR_RZC_Lingjie2019 /* 459086 */:
            case FinalCanbus.CAR_DAOJUN_XP1_17XTS /* 459100 */:
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_14Prodo_H_ShuPing /* 459181 */:
            case FinalCanbus.CAR_BNR_16CS75_H_RightCamera /* 524358 */:
            case FinalCanbus.CAR_DAOJUN_XP1_17XTS_M /* 524636 */:
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_14Prodo_ShuPing /* 524717 */:
            case FinalCanbus.CAR_WC2_MQB /* 589841 */:
            case FinalCanbus.CAR_BNR_16CS75_H_FullView /* 589894 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS /* 589963 */:
            case FinalCanbus.CAR_RZC_ChuanQiGS4_18 /* 590104 */:
            case FinalCanbus.CAR_RZC_Explorer /* 590158 */:
            case FinalCanbus.CAR_DAOJUN_18ATS_Auto /* 590172 */:
            case FinalCanbus.CAR_WC2_MQB_Hybrid /* 655377 */:
            case FinalCanbus.CAR_BNR_17CS75 /* 655430 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GL /* 655499 */:
            case FinalCanbus.CAR_BNR_ShuPing_12LandCruise /* 655757 */:
            case FinalCanbus.CAR_WC2_MQB_AllView /* 720913 */:
            case FinalCanbus.CAR_RZC_XP1_18YuanJingSUV /* 721035 */:
            case FinalCanbus.CAR_BNR_ShuPing_16LandCruise /* 721293 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Auto /* 721340 */:
            case FinalCanbus.CAR_453_PA_Ford_F150_10_CD /* 721349 */:
            case FinalCanbus.CAR_RZC_XP1_Borui /* 786571 */:
            case FinalCanbus.CAR_RZC_XP1_18YuanJingSUV_H /* 852107 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6_16HuanDai /* 852212 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_GCC /* 852412 */:
            case FinalCanbus.CAR_RZC_XP1_16YuanJingSUV /* 917643 */:
            case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV1 /* 917948 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx /* 917956 */:
            case FinalCanbus.CAR_RZC_XP1_16YuanJingSUV_H /* 983179 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6Couple_16_top /* 983284 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV2 /* 983484 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx_H /* 983492 */:
            case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV3 /* 1049020 */:
            case FinalCanbus.CAR_RZC_XP1_18YuanJing /* 1114251 */:
            case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_OFFROAD /* 1114556 */:
            case FinalCanbus.CAR_453_LZ_Toyota_REIZ_09 /* 1114565 */:
            case FinalCanbus.CAR_RZC_BoYue /* 1179787 */:
            case FinalCanbus.CAR_RZC_Lingjie2019_M /* 1179982 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto2 /* 1180092 */:
            case FinalCanbus.CAR_453_LZ_Toyota_REIZ_09_H /* 1180101 */:
            case FinalCanbus.CAR_RZC_BoYue_H /* 1245323 */:
            case FinalCanbus.CAR_RZC_HavalH4_20 /* 1245428 */:
            case FinalCanbus.CAR_RZC_Lingjie2019_H /* 1245518 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Hand1 /* 1245628 */:
            case FinalCanbus.CAR_RZC_Jili_19Dihao /* 1310859 */:
            case FinalCanbus.CAR_RZC_HavalH7_19 /* 1310964 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Hand2 /* 1311164 */:
            case FinalCanbus.CAR_RZC_HavalF7_20 /* 1376500 */:
            case FinalCanbus.CAR_RZC_Ford_18Everest_FLB /* 1376590 */:
            case FinalCanbus.CAR_PA_dorango_13_18_Low /* 1376630 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9 /* 1376695 */:
            case FinalCanbus.CAR_RZC_Jili_19Dihao_GL_E /* 1441931 */:
            case FinalCanbus.CAR_RZC_HavalH4_20_H /* 1442036 */:
            case FinalCanbus.CAR_RZC_Ford_18Everest_FLB_H /* 1442126 */:
            case FinalCanbus.CAR_PA_dorango_13_18_H /* 1442166 */:
            case FinalCanbus.CAR_RZC_Jili_18Dihao /* 1507467 */:
            case FinalCanbus.CAR_RZC_HavalF7_19 /* 1507572 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_SUV_Low1 /* 1507662 */:
            case FinalCanbus.CAR_PA_RAM_13_18_Low /* 1507702 */:
            case FinalCanbus.CAR_BNR_ShuPing_12LandCruise_AMP /* 1507725 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_GX50 /* 1507771 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS_18 /* 1573003 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6_H /* 1573108 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_SUV_Low2 /* 1573198 */:
            case FinalCanbus.CAR_PA_RAM_13_18_H /* 1573238 */:
            case FinalCanbus.CAR_BNR_ShuPing_16LandCruise_AMP /* 1573261 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GL_16 /* 1638539 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_PickUP_Low /* 1638734 */:
            case FinalCanbus.CAR_PA_Wrangler_18_20_Low /* 1638774 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_S1_18 /* 1704075 */:
            case FinalCanbus.CAR_RZC_HavalH7_19_NoAmp /* 1704180 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_PickUP_H /* 1704270 */:
            case FinalCanbus.CAR_PA_Wrangler_18_20_H /* 1704310 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS_19 /* 1769611 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
            case FinalCanbus.CAR_RZC_XP1_YuanJingX3_19_20 /* 1835147 */:
            case FinalCanbus.CAR_PA_RAM_20_H /* 1835382 */:
            case FinalCanbus.CAR_RZC_Haval_Fengjun5_21 /* 1900788 */:
            case FinalCanbus.CAR_PA_RAM_20_Low /* 1900918 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Iran /* 1900988 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GL_19 /* 1966219 */:
            case FinalCanbus.CAR_RZC_Haval_H3_05 /* 1966324 */:
            case FinalCanbus.CAR_PA_dorango_10 /* 1966454 */:
            case FinalCanbus.CAR_RZC_XP1_20YuanJingSUV /* 2031755 */:
            case FinalCanbus.CAR_RZC_Haval_Jinggangpao_22 /* 2031860 */:
            case FinalCanbus.CAR_PA_GMC_13 /* 2031990 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GL_20 /* 2097291 */:
            case FinalCanbus.CAR_RZC_Haval_H7Hongbiao_18 /* 2097396 */:
            case FinalCanbus.CAR_PA_RAM_22_H /* 2097526 */:
            case FinalCanbus.CAR_RZC_XP1_Boyue_Pro_20 /* 2162827 */:
            case FinalCanbus.CAR_RZC_Haval_H7Hongbiao_18_H /* 2162932 */:
            case FinalCanbus.CAR_PA_RAM_22_Low /* 2163062 */:
            case FinalCanbus.CAR_RZC_XP1_Bingyue_19 /* 2228363 */:
            case FinalCanbus.CAR_RZC_HavalF7_19_Top /* 2228468 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS_20 /* 2293899 */:
            case FinalCanbus.CAR_PA_SONOTEC_13 /* 2294134 */:
            case FinalCanbus.CAR_PA_Escalade_13 /* 2359670 */:
            case FinalCanbus.CAR_RZC_XP1_Jiaji_21 /* 2424971 */:
            case FinalCanbus.CAR_PA_Ford_F250 /* 2425206 */:
            case FinalCanbus.CAR_RZC_XP1_Binrui_20 /* 2490507 */:
            case FinalCanbus.CAR_PA_Ford_F450 /* 2490742 */:
            case FinalCanbus.CAR_RZC_Haval_H9 /* 2490807 */:
            case FinalCanbus.CAR_RZC_XP1_Haoyue_20 /* 2556043 */:
            case FinalCanbus.CAR_PA_Ford_F650 /* 2556278 */:
            case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
            case FinalCanbus.CAR_RZC_XP1_Dihaoe_22 /* 2621579 */:
            case FinalCanbus.CAR_PA_Cherokee_14_22 /* 2621814 */:
            case FinalCanbus.CAR_452_LZ_Bentley_Bentayga /* 2621893 */:
            case FinalCanbus.CAR_455_LUZ_Nissan_GTR_EN /* 2621895 */:
            case FinalCanbus.CAR_PA_GrandCherokee_14_22 /* 2687350 */:
            case FinalCanbus.CAR_PA_Chrysler_300C_11_22 /* 2752886 */:
            case FinalCanbus.CAR_PA_Dodge_Challenger_08_14 /* 2818422 */:
            case FinalCanbus.CAR_PA_Ford_Explorer_19 /* 2883958 */:
            case FinalCanbus.CAR_RZC_XP1_BingyuePro_19 /* 2949259 */:
            case FinalCanbus.CAR_PA_Ford_Fusion_22 /* 2949494 */:
            case FinalCanbus.CAR_RZC_Explorer_13 /* 3014990 */:
            case FinalCanbus.CAR_PA_Ford_F150_14 /* 3015030 */:
            case FinalCanbus.CAR_OuDi_XP1_Borui_18 /* 3080331 */:
            case FinalCanbus.CAR_PA_Ford_F150_20 /* 3080566 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_IS /* 3080631 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_ADAS /* 3080636 */:
            case FinalCanbus.CAR_OuDi_XP1_Borui_18_L /* 3145867 */:
            case FinalCanbus.CAR_RZC_15Ruijie_CD /* 3146062 */:
            case FinalCanbus.CAR_PA_Ford_Focus_18 /* 3146102 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_IS_H /* 3146167 */:
            case FinalCanbus.CAR_Oudi_Jili_Binyue_Pro /* 3211403 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_21 /* 3211638 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_ES /* 3211703 */:
            case FinalCanbus.CAR_RZC_XP1_Bingyue_21_RS /* 3276939 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_17 /* 3277174 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_ES_H /* 3277239 */:
            case FinalCanbus.CAR_RZC_XP1_Dihao_23 /* 3342475 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_21 /* 3342710 */:
            case FinalCanbus.CAR_PA_Ford_Explorer_19_CD /* 3408246 */:
            case FinalCanbus.CAR_PA_Ford_Fusion_22_CD /* 3473782 */:
            case FinalCanbus.CAR_PA_Ford_F150_14_CD /* 3539318 */:
            case FinalCanbus.CAR_PA_Ford_F150_20_CD /* 3604854 */:
            case FinalCanbus.CAR_PA_Ford_Focus_18_CD /* 3670390 */:
            case FinalCanbus.CAR_452_LZ_Jaguar_XK /* 3670468 */:
            case FinalCanbus.CAR_RZC_Ford_Ranger_15_Vietnam /* 3735886 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_21_CD /* 3735926 */:
            case FinalCanbus.CAR_RZC_Ford_Ranger_20_Turkey /* 3801422 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_17_CD /* 3801462 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_CD /* 3866998 */:
            case FinalCanbus.CAR_PA_Ford_mustang_15 /* 3932534 */:
            case FinalCanbus.CAR_PA_Ford_mustang_15_CD /* 3998070 */:
            case FinalCanbus.CAR_PA_Ford_Explorer_19_Amp /* 4260214 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_14QX60_SP /* 4260283 */:
            case FinalCanbus.CAR_PA_Ford_Fusion_22_Amp /* 4325750 */:
            case FinalCanbus.CAR_PA_Ford_F150_14_Amp /* 4391286 */:
            case FinalCanbus.CAR_443_WC2_Ford_18Everest_L /* 4391355 */:
            case FinalCanbus.CAR_PA_Ford_F150_20_Amp /* 4456822 */:
            case FinalCanbus.CAR_443_WC2_Ford_18Everest_H /* 4456891 */:
            case FinalCanbus.CAR_PA_Ford_Focus_18_Amp /* 4522358 */:
            case FinalCanbus.CAR_443_WC2_Ford_18Everest_FLB /* 4522427 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_21_Amp /* 4587894 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_17_Amp /* 4653430 */:
            case FinalCanbus.CAR_RZC_Jinniu2019_M /* 4718926 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_Amp /* 4718966 */:
            case FinalCanbus.CAR_RZC_Jinniu2019_H /* 4784462 */:
            case FinalCanbus.CAR_PA_Ford_mustang_15_Amp /* 4784502 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16 /* 4850038 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_CD /* 4915574 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_Amp /* 4981110 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_08 /* 5046646 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_Low /* 5112182 */:
            case FinalCanbus.CAR_PA_RAM_13_18_Low_win4 /* 5177718 */:
            case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
            case FinalCanbus.CAR_PA_Cherokee_14_22_Amp /* 5243254 */:
            case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_18 /* 5243333 */:
            case FinalCanbus.CAR_PA_GrandCherokee_14_22_Amp /* 5308790 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460 /* 5308868 */:
            case FinalCanbus.CAR_PA_Gladiator_20_23 /* 5374326 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460_H /* 5374404 */:
            case FinalCanbus.CAR_PA_Gladiator_20_23_Amp /* 5439862 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
            case FinalCanbus.CAR_452_LZ_Toyota_LC100 /* 5439940 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
            case FinalCanbus.CAR_452_LZ_Toyota_LC100_H /* 5505476 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
            case FinalCanbus.CAR_453_PA_Ford_Mustang_10_CD /* 5702085 */:
            case FinalCanbus.CAR_453_PA_Ford_Mustang_10 /* 5767621 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
            case FinalCanbus.CAR_443_WC2_Ford_RANGER /* 5898683 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
            case FinalCanbus.CAR_443_WC2_Ford_18Everest_FLB_H /* 5964219 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_LS460_06 /* 6095245 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_GS_06 /* 6160781 */:
            case FinalCanbus.CAR_443_WC2_Ford_Everest_SUV_Low1 /* 6160827 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_IS_06 /* 6226317 */:
            case FinalCanbus.CAR_443_WC2_Ford_Everest_SUV_Low2 /* 6226363 */:
            case FinalCanbus.CAR_453_OD_WeiMa_EX5 /* 6226373 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_ES_06 /* 6291853 */:
            case FinalCanbus.CAR_439_LUZ_KAYAN_MACAN_CD /* 6291895 */:
            case FinalCanbus.CAR_443_WC2_Ford_Everest_PickUP_Low /* 6291899 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_GX460_10 /* 6357389 */:
            case FinalCanbus.CAR_443_WC2_Ford_Everest_PickUP_H /* 6357435 */:
            case FinalCanbus.CAR_BNR_Toyota_14Tundra_AMP /* 6422925 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AMP /* 6488461 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP /* 6553997 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP_19 /* 6619533 */:
            case FinalCanbus.CAR_439_AY_BYD_Sirui /* 6619575 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10_AMP /* 6685069 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AMP /* 6750605 */:
            case FinalCanbus.CAR_439_HCY_BYD_S6_H /* 6750647 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_AMP /* 6816141 */:
            case FinalCanbus.CAR_452_LZ_Jaguar_F_TYPE /* 6881732 */:
            case FinalCanbus.CAR_439_HC_Nissan_Toread /* 7012791 */:
            case FinalCanbus.CAR_452_LZ_Jaguar_XJL /* 7012804 */:
            case FinalCanbus.CAR_LUZ_Toyato_All /* 7274935 */:
            case FinalCanbus.CAR_LUZ_Toyato_All_H /* 7340471 */:
            case FinalCanbus.CAR_LUZ_Toyato_20All /* 8126903 */:
            case FinalCanbus.CAR_LUZ_Toyato_30All /* 8192439 */:
            case FinalCanbus.CAR_452_RZC_Haval_H9_Low /* 8651204 */:
            case FinalCanbus.CAR_439_XBS_BYD_Song /* 8782263 */:
            case FinalCanbus.CAR_439_CXW_Kairui_K50 /* 8847799 */:
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD /* 8913349 */:
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD_H /* 8978885 */:
            case FinalCanbus.CAR_453_LZ_Toyota_markII_L /* 9634245 */:
            case FinalCanbus.CAR_453_LZ_Toyota_markII_H /* 9699781 */:
            case FinalCanbus.CAR_439_DJ_Haval_H8 /* 10420663 */:
            case FinalCanbus.CAR_439_DJ_Haval_H8_H /* 10486199 */:
            case FinalCanbus.CAR_452_PA_Nissan_XTrail_21 /* 11731396 */:
            case FinalCanbus.CAR_452_PA_Nissan_Loulan_21 /* 11796932 */:
            case FinalCanbus.CAR_454_RZC_Haval_H8_15 /* 11796934 */:
            case FinalCanbus.CAR_452_PA_Nissan_Terra_21 /* 11862468 */:
            case FinalCanbus.CAR_454_RZC_Haval_H8_15_H /* 11862470 */:
            case FinalCanbus.CAR_452_PA_Nissan_TITAN /* 11928004 */:
            case FinalCanbus.CAR_452_LZ_Toyato_RX450 /* 12648900 */:
            case FinalCanbus.CAR_452_LZ_Toyato_RX270 /* 12714436 */:
            case FinalCanbus.CAR_452_LZ_Jaguar_XFL_PACE /* 12779972 */:
            case FinalCanbus.CAR_439_OUDI_BYD_ALL /* 12976567 */:
            case FinalCanbus.CAR_452_LZ_Jaguar_XFL_PACE_H /* 13238724 */:
            case FinalCanbus.CAR_439_LUZ_Nissan_GTR /* 13566391 */:
            case FinalCanbus.CAR_452_PA_Infiniti_G37 /* 13894084 */:
            case FinalCanbus.CAR_452_KYC_Toyota_Landekuluze /* 14221764 */:
            case FinalCanbus.CAR_452_KYC_Toyota_Runner /* 14287300 */:
            case FinalCanbus.CAR_452_KYC_Toyota_Alpha /* 14352836 */:
            case FinalCanbus.CAR_443_WC2_Ford_12Focus_Overseas /* 15139259 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_RS /* 15598007 */:
            case FinalCanbus.CAR_452_PA_Ford_F150_10 /* 15598020 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
            case FinalCanbus.CAR_439_DJ_Haval_H9 /* 15794628 */:
            case FinalCanbus.CAR_439_DJ_Haval_H9_H /* 15860164 */:
            case FinalCanbus.CAR_439_DJ_Haval_VV5 /* 15925700 */:
            case FinalCanbus.CAR_439_DJ_Haval_VV6 /* 15991236 */:
            case FinalCanbus.CAR_439_DJ_Haval_VV7 /* 16056772 */:
            case FinalCanbus.CAR_452_OD_Haval_VV5 /* 16122308 */:
            case FinalCanbus.CAR_452_OD_Haval_VV6 /* 16187844 */:
            case FinalCanbus.CAR_452_OD_Haval_VV7 /* 16253380 */:
            case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
            case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
            case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                flag = true;
                break;
        }
        if ((LauncherApplication.getConfiguration() != 1 || flag) && "com.syu.canbus.enter.air".equals(action)) {
            switch (DataCanbus.DATA[1000]) {
                case 21:
                case 22:
                case 25:
                case 26:
                case 61:
                case 86:
                case 163:
                case 223:
                case 252:
                case 334:
                case 339:
                case 374:
                case 416:
                case 443:
                case FinalCanbus.CAR_WC2_MengDiOuZS2013_M /* 65557 */:
                case FinalCanbus.CAR_XP1_Ford_KUGA_2013 /* 65558 */:
                case FinalCanbus.CAR_XP1_GM_H1 /* 65561 */:
                case FinalCanbus.CAR_RZC_XP1_GM_1 /* 65597 */:
                case FinalCanbus.CAR_RZC_XP1_BenTeng14B70_QC /* 65624 */:
                case FinalCanbus.CAR_RZC4_PSA14_308_16 /* 65699 */:
                case FinalCanbus.CAR_WC2_PSAALL_1 /* 65788 */:
                case FinalCanbus.CAR_RZC4_PSA_4008 /* 65875 */:
                case FinalCanbus.CAR_XP1_ZiYouGuang_H /* 65910 */:
                case FinalCanbus.CAR_RZC_XP1_QiRuiRuiHu7 /* 65940 */:
                case FinalCanbus.CAR_WC2_17MingJue6 /* 65952 */:
                case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_H /* 65990 */:
                case FinalCanbus.CAR_WC2_MengDiOuZS2013_H /* 131093 */:
                case FinalCanbus.CAR_XP1_GM_H2 /* 131097 */:
                case FinalCanbus.CAR_RZC_XP1_GM_2 /* 131133 */:
                case FinalCanbus.CAR_RZC4_PSA14_408_M /* 131235 */:
                case FinalCanbus.CAR_WC2_PSAALL_2 /* 131324 */:
                case FinalCanbus.CAR_WeiChi2_17ChangChengH6 /* 131392 */:
                case FinalCanbus.CAR_RZC4_PSA_19_C4L /* 131411 */:
                case FinalCanbus.CAR_WC2_RongWei_I5 /* 131488 */:
                case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_M /* 131526 */:
                case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL /* 196629 */:
                case FinalCanbus.CAR_XP1_Ford_Ecosport_2013 /* 196630 */:
                case FinalCanbus.CAR_XP1_GM_H3 /* 196633 */:
                case FinalCanbus.CAR_RZC_XP1_GM_3 /* 196669 */:
                case FinalCanbus.CAR_WC_17Haval_H2S /* 196740 */:
                case FinalCanbus.CAR_RZC_XP1_YuanJingX1 /* 196747 */:
                case FinalCanbus.CAR_RZC4_PSA14_408_H /* 196771 */:
                case FinalCanbus.CAR_WC2_PSAALL_3 /* 196860 */:
                case FinalCanbus.CAR_Oudi_XP1_FengGuang17Y580 /* 196922 */:
                case FinalCanbus.CAR_WeiChi2_18ChangChengH6 /* 196928 */:
                case FinalCanbus.CAR_RZC4_PSA_19_508 /* 196947 */:
                case FinalCanbus.CAR_XP1_17ZhiNanZhe /* 196982 */:
                case FinalCanbus.CAR_WC2_RongWei_I6 /* 197024 */:
                case FinalCanbus.CAR_453_OD_Chuangwei_EV /* 197061 */:
                case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_L_Auto /* 197062 */:
                case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL_M /* 262165 */:
                case FinalCanbus.CAR_XP1_Ford_Fiesta_2013 /* 262166 */:
                case FinalCanbus.CAR_XP1_GM_Camaro_10 /* 262169 */:
                case FinalCanbus.CAR_RZC_XP1_GM_4 /* 262205 */:
                case FinalCanbus.CAR_WC2_CHANGAN_19KeSai /* 262272 */:
                case FinalCanbus.CAR_WC2_PSAALL_4 /* 262396 */:
                case FinalCanbus.CAR_WeiChi2_ChangChengM6 /* 262464 */:
                case FinalCanbus.CAR_RZC4_PSA_19_C3_XR_L /* 262483 */:
                case FinalCanbus.CAR_XP1_17ZhiNanZhe_H /* 262518 */:
                case FinalCanbus.CAR_RZC_XP1_18QiRuiAiRuiZeGX /* 262548 */:
                case FinalCanbus.CAR_WC2_RongWei_EI6 /* 262560 */:
                case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_L_Hand /* 262598 */:
                case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL_H /* 327701 */:
                case FinalCanbus.CAR_XP1_Ford_CMAX_2013 /* 327702 */:
                case FinalCanbus.CAR_WC2_CHANGAN_19KeSai_Hand /* 327808 */:
                case FinalCanbus.CAR_WC2_PSAALL_5 /* 327932 */:
                case FinalCanbus.CAR_WC2_TOYOTA_HIGHLANDER /* 327974 */:
                case FinalCanbus.CAR_RZC_Focus2019 /* 328014 */:
                case FinalCanbus.CAR_RZC4_PSA_19_C3_XR_M /* 328019 */:
                case FinalCanbus.CAR_RZC_XP1_18QiRuiAiRuiZeGX_H /* 328084 */:
                case FinalCanbus.CAR_WC2_RongWei_RX3 /* 328096 */:
                case FinalCanbus.CAR_454_Tangdu_Toyota_Lexus_Lx570_10_CD /* 328134 */:
                case FinalCanbus.CAR_WC2_18Ecosport /* 393237 */:
                case FinalCanbus.CAR_XP1_Ford_Focus_2015 /* 393238 */:
                case FinalCanbus.CAR_RZC_HavalLow_H2S_HongBiao /* 393460 */:
                case FinalCanbus.CAR_WC2_PSAALL_6 /* 393468 */:
                case FinalCanbus.CAR_RZC_FengGuang18Y580 /* 393530 */:
                case FinalCanbus.CAR_RZC4_PSA_19_C3_XR_H /* 393555 */:
                case FinalCanbus.CAR_RZC_XP1_19QiRuiHu5X /* 393620 */:
                case FinalCanbus.CAR_WC2_RongWei_HS /* 393632 */:
                case FinalCanbus.CAR_454_Tangdu_Toyota_Lexus_Lx570_15_CD /* 393670 */:
                case FinalCanbus.CAR_WC2_MengDiOuZS2018 /* 458773 */:
                case FinalCanbus.CAR_XP1_Ford_Tourneo_2015 /* 458774 */:
                case FinalCanbus.CAR_WC2_19Oushang_A800 /* 458880 */:
                case FinalCanbus.CAR_RZC_BeiQi_19EC5 /* 458979 */:
                case FinalCanbus.CAR_RZC_XP1_HavalH6 /* 458996 */:
                case FinalCanbus.CAR_WC2_PSAALL_7 /* 459004 */:
                case FinalCanbus.CAR_RZC_FengGuang18Y580_H /* 459066 */:
                case FinalCanbus.CAR_RZC4_PSA_ALL_M /* 459091 */:
                case FinalCanbus.CAR_RZC_XP1_19QiRuiHu5X_H /* 459156 */:
                case FinalCanbus.CAR_WC2_RongWei_I5_H /* 459168 */:
                case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_15_TCD /* 459206 */:
                case FinalCanbus.CAR_WC2_MengDiOuZS2021 /* 524309 */:
                case FinalCanbus.CAR_XP1_Ford_Transit_2015 /* 524310 */:
                case FinalCanbus.CAR_RZC1_MZDRX8 /* 524367 */:
                case FinalCanbus.CAR_RZC_XP1_18Carmy /* 524400 */:
                case FinalCanbus.CAR_WC2_PSAALL_8 /* 524540 */:
                case FinalCanbus.CAR_RZC_DongFengYiZhi_19EV3 /* 524602 */:
                case FinalCanbus.CAR_WeiChi2_18ChangChengH6_H /* 524608 */:
                case FinalCanbus.CAR_RZC4_PSA_ALL_H /* 524627 */:
                case FinalCanbus.CAR_RZC_XP1_18JieTU_X70 /* 524692 */:
                case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_16_TCD /* 524742 */:
                case FinalCanbus.CAR_CZH_WC2_MengDiOuZS2013_M /* 589845 */:
                case FinalCanbus.CAR_XP1_Ford_KUGA_2017 /* 589846 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_GS /* 589963 */:
                case FinalCanbus.CAR_WC2_PSAALL_9 /* 590076 */:
                case FinalCanbus.CAR_WeiChi2_ChangCheng_19Copue /* 590144 */:
                case FinalCanbus.CAR_RZC_XP1_19AiRuiZe5 /* 590228 */:
                case FinalCanbus.CAR_454_Tangdu_Toyota_LexusGX_13_CD /* 590278 */:
                case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15_YC /* 590279 */:
                case FinalCanbus.CAR_WC2_20Oushang_X7_H /* 655488 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_GL /* 655499 */:
                case FinalCanbus.CAR_WC2_PSAALL_10 /* 655612 */:
                case FinalCanbus.CAR_WeiChi2_ChangCheng_19F7 /* 655680 */:
                case FinalCanbus.CAR_RZC_XP1_19AiRuiZe5_H /* 655764 */:
                case FinalCanbus.CAR_454_Tangdu_Toyota_LexusGX_14_CD /* 655814 */:
                case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15H_YC /* 655815 */:
                case FinalCanbus.CAR_WC2_19ChangAn_CS35_PLUS /* 721024 */:
                case FinalCanbus.CAR_RZC_XP1_18YuanJingSUV /* 721035 */:
                case FinalCanbus.CAR_RZC_HavalLow_H2S_LanBiao /* 721140 */:
                case FinalCanbus.CAR_WC2_PSAALL_11 /* 721148 */:
                case FinalCanbus.CAR_WeiChi2_ChangCheng_19Copue_H /* 721216 */:
                case FinalCanbus.CAR_RZC4_PSA_17_3008 /* 721235 */:
                case FinalCanbus.CAR_XP1_18ZiYouXia /* 721270 */:
                case FinalCanbus.CAR_RZC_XP1_18QiRuiRuiHu7 /* 721300 */:
                case FinalCanbus.CAR_RZC_XP1_20RAV4 /* 786544 */:
                case FinalCanbus.CAR_RZC_XP1_Borui /* 786571 */:
                case FinalCanbus.CAR_RZC_BeiQi_18EU5 /* 786659 */:
                case FinalCanbus.CAR_WC2_PSAALL_12 /* 786684 */:
                case FinalCanbus.CAR_WeiChi2_ChangCheng_19F7_H /* 786752 */:
                case FinalCanbus.CAR_RZC4_PSA_17_3008_M /* 786771 */:
                case FinalCanbus.CAR_XP1_Cherokee /* 786806 */:
                case FinalCanbus.CAR_RZC_XP1_18QiRuiRuiHu7_H /* 786836 */:
                case FinalCanbus.CAR_RZC_BenTeng_OLDB50 /* 786845 */:
                case FinalCanbus.CAR_RZC_XP1_19Yazhoulong /* 852080 */:
                case FinalCanbus.CAR_RZC_XP1_18YuanJingSUV_H /* 852107 */:
                case FinalCanbus.CAR_RZC_BeiQi_Shenbao_D50_18 /* 852195 */:
                case FinalCanbus.CAR_RZC_XP1_HavalH6_16HuanDai /* 852212 */:
                case FinalCanbus.CAR_WC2_PSAALL_DS6 /* 852220 */:
                case FinalCanbus.CAR_RZC_Jiangxi_Wushiling_Mux /* 852282 */:
                case FinalCanbus.CAR_WeiChi2_ChangCheng_20FJUN7 /* 852288 */:
                case FinalCanbus.CAR_RZC4_PSA_17_3008_H /* 852307 */:
                case FinalCanbus.CAR_XP1_Cherokee_H /* 852342 */:
                case FinalCanbus.CAR_RZC_XP1_18QiRuiRuiHu8 /* 852372 */:
                case FinalCanbus.CAR_452_RZC_ZHongtai_E200_18 /* 852420 */:
                case FinalCanbus.CAR_RZC_XP1_18Carmy_H /* 917616 */:
                case FinalCanbus.CAR_RZC_XP1_16YuanJingSUV /* 917643 */:
                case FinalCanbus.CAR_WC2_PSAALL_301_19 /* 917756 */:
                case FinalCanbus.CAR_WC_SP_12LuXun /* 917798 */:
                case FinalCanbus.CAR_WeiChi2_17ChangChengH6_H /* 917824 */:
                case FinalCanbus.CAR_RZC4_PSA_14_2008 /* 917843 */:
                case FinalCanbus.CAR_BNR_XP1_ZiYouGuang /* 917878 */:
                case FinalCanbus.CAR_RZC_XP1_18QiRuiRuiHu8_H /* 917908 */:
                case FinalCanbus.CAR_RZC_XP1_98_05Lexus_Rx300 /* 983152 */:
                case FinalCanbus.CAR_RZC_XP1_16YuanJingSUV_H /* 983179 */:
                case FinalCanbus.CAR_RZC_XP1_HavalH6Couple_16_top /* 983284 */:
                case FinalCanbus.CAR_WC2_PSAALL_Rifter_19_H /* 983292 */:
                case FinalCanbus.CAR_WeiChi2_ChangChengH2S /* 983360 */:
                case FinalCanbus.CAR_RZC4_PSA_14_2008_M /* 983379 */:
                case FinalCanbus.CAR_BNR_XP1_ZiYouGuang_H /* 983414 */:
                case FinalCanbus.CAR_WC2_PSAALL_Rifter_19_L /* 1048828 */:
                case FinalCanbus.CAR_WeiChi2_ChangChengH4 /* 1048896 */:
                case FinalCanbus.CAR_RZC4_PSA_14_2008_H /* 1048915 */:
                case FinalCanbus.CAR_RZC_XP1_20QiRuiRuiHu7 /* 1048980 */:
                case FinalCanbus.CAR_RZC_XP1_98_03LC100 /* 1114224 */:
                case FinalCanbus.CAR_RZC_XP1_18YuanJing /* 1114251 */:
                case FinalCanbus.CAR_RZC_HavalLow_Changchengpao_19 /* 1114356 */:
                case FinalCanbus.CAR_WC2_PSAALL_TY_C5 /* 1114364 */:
                case FinalCanbus.CAR_BNR_XP1_17ZhiNanZhe /* 1114486 */:
                case FinalCanbus.CAR_RZC_BoYue /* 1179787 */:
                case FinalCanbus.CAR_WC2_PSAALL_308_11_Amp /* 1179900 */:
                case FinalCanbus.CAR_RZC_Jiangxi_FengguangS560_21 /* 1179962 */:
                case FinalCanbus.CAR_WeiChi2_17ChangChengH6_M /* 1179968 */:
                case FinalCanbus.CAR_WC2_RENAULT_Jinbei_Guanjing /* 1180000 */:
                case FinalCanbus.CAR_BNR_XP1_17ZhiNanZhe_H /* 1180022 */:
                case FinalCanbus.CAR_RZC_XP1_20QiRuiRuiHu8 /* 1180052 */:
                case FinalCanbus.CAR_443_WC2_Tianlai08_12 /* 1180091 */:
                case FinalCanbus.CAR_RZC_XP1_WildLander /* 1245296 */:
                case FinalCanbus.CAR_RZC_BoYue_H /* 1245323 */:
                case FinalCanbus.CAR_RZC_BeiQi_20EX3 /* 1245411 */:
                case FinalCanbus.CAR_RZC_HavalH4_20 /* 1245428 */:
                case FinalCanbus.CAR_WC2_PSAALL_407_06 /* 1245436 */:
                case FinalCanbus.CAR_RZC_FengGuang21Y580 /* 1245498 */:
                case FinalCanbus.CAR_455_LZ_Ford_Mustang_L_CYT /* 1245639 */:
                case FinalCanbus.CAR_RZC_XP1_CHR_EV /* 1310832 */:
                case FinalCanbus.CAR_RZC_Jili_19Dihao /* 1310859 */:
                case FinalCanbus.CAR_RZC_DongFeng_Fengxing_S60EVE /* 1310947 */:
                case FinalCanbus.CAR_RZC_HavalH7_19 /* 1310964 */:
                case FinalCanbus.CAR_WC2_PSAALL_C3Aircross_23 /* 1310972 */:
                case FinalCanbus.CAR_WC_SP_14KaluoLa_ZiDong /* 1311014 */:
                case FinalCanbus.CAR_RZC_FengGuang21Y580_H /* 1311034 */:
                case FinalCanbus.CAR_WC2_BeiQi_M50F /* 1311115 */:
                case FinalCanbus.CAR_RZC_XP1_18JieTU_X70_H /* 1311124 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand /* 1311174 */:
                case FinalCanbus.CAR_455_LZ_Ford_Mustang_H_CYT /* 1311175 */:
                case FinalCanbus.CAR_RZC_BeiQi_20EU5 /* 1376483 */:
                case FinalCanbus.CAR_RZC_HavalF7_20 /* 1376500 */:
                case FinalCanbus.CAR_WC2_PSAALL_3008_22 /* 1376508 */:
                case FinalCanbus.CAR_WC_SP_Alpha /* 1376550 */:
                case FinalCanbus.CAR_WeiChi2_Changcheng_Jingangpao /* 1376576 */:
                case FinalCanbus.CAR_RZC4_PSA_17_5008 /* 1376595 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto /* 1376710 */:
                case FinalCanbus.CAR_455_LZ_Ford_Mustang_RH_CYT /* 1376711 */:
                case FinalCanbus.CAR_RZC_Jili_19Dihao_GL_E /* 1441931 */:
                case FinalCanbus.CAR_RZC_HavalH4_20_H /* 1442036 */:
                case FinalCanbus.CAR_WC2_PSAALL_C4_09 /* 1442044 */:
                case FinalCanbus.CAR_WeiChi2_ChangCheng_Jingangpao_H /* 1442112 */:
                case FinalCanbus.CAR_RZC_XP1_20Ruihu_5X /* 1442196 */:
                case FinalCanbus.CAR_439_LUZ_BinLi_H /* 1442244 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand /* 1442246 */:
                case FinalCanbus.CAR_455_LZ_Ford_Mustang_RL_CYT /* 1442247 */:
                case FinalCanbus.CAR_RZC_XP1_Lexus_NX200_17 /* 1507440 */:
                case FinalCanbus.CAR_RZC_Jili_18Dihao /* 1507467 */:
                case FinalCanbus.CAR_RZC_HavalF7_19 /* 1507572 */:
                case FinalCanbus.CAR_WC2_PSAALL_Partner_09 /* 1507580 */:
                case FinalCanbus.CAR_Oudi_XP1_FengGuang17Y560 /* 1507642 */:
                case FinalCanbus.CAR_WeiChi2_Changcheng_pao /* 1507648 */:
                case FinalCanbus.CAR_RZC_XP1_21Ruihu_3X /* 1507732 */:
                case FinalCanbus.CAR_439_OD_Qirui_KaiyiX3 /* 1507780 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto /* 1507782 */:
                case FinalCanbus.CAR_RZC_XP1_Lexus_ES200_13 /* 1572976 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_GS_18 /* 1573003 */:
                case FinalCanbus.CAR_RZC_XP1_HavalH6_H /* 1573108 */:
                case FinalCanbus.CAR_WC2_PSAALL_Belingo_17 /* 1573116 */:
                case FinalCanbus.CAR_WC_SP_09_Lexus_ES350 /* 1573158 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand_S /* 1573318 */:
                case FinalCanbus.CAR_RZC_XP1_Lexus_RX270_14 /* 1638512 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_GL_16 /* 1638539 */:
                case FinalCanbus.CAR_RZC_HavalH7_19_H /* 1638644 */:
                case FinalCanbus.CAR_WC_SP_09_Lexus_ES350_H /* 1638694 */:
                case FinalCanbus.CAR_Oudi_XP1_FengGuang17S560 /* 1638714 */:
                case FinalCanbus.CAR_RZC4_PSA_04_407 /* 1638739 */:
                case FinalCanbus.CAR_RZC_XP1_21Xiaomayi_EQ1 /* 1638804 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto_S /* 1638854 */:
                case FinalCanbus.CAR_RZC_XP1_Lexus_ES300_05 /* 1704048 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_S1_18 /* 1704075 */:
                case FinalCanbus.CAR_RZC_HavalH7_19_NoAmp /* 1704180 */:
                case FinalCanbus.CAR_WC2_PSAALL_5008_21 /* 1704188 */:
                case FinalCanbus.CAR_WC_Toyota_21Sienna /* 1704230 */:
                case FinalCanbus.CAR_RZC4_PSA_04_407_CD /* 1704275 */:
                case FinalCanbus.CAR_RZC_LUZ_18QiRuiRuiHu8 /* 1704340 */:
                case FinalCanbus.CAR_443_WC2_Nissan_Ruiqi /* 1704379 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand_S /* 1704390 */:
                case FinalCanbus.CAR_RZC_XP1_Lexus_RX_09_14 /* 1769584 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_GS_19 /* 1769611 */:
                case FinalCanbus.CAR_RZC_HavalH7_19_H_NoAmp /* 1769716 */:
                case FinalCanbus.CAR_WC2_PSAALL_208_23_SA /* 1769724 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto_S /* 1769926 */:
                case FinalCanbus.CAR_RZC_XP1_Lexus_ES300_20 /* 1835120 */:
                case FinalCanbus.CAR_RZC_XP1_YuanJingX3_19_20 /* 1835147 */:
                case FinalCanbus.CAR_WC2_PSAALL_C3_22_SA /* 1835260 */:
                case FinalCanbus.CAR_RZC_FengGuang_580Pro_20 /* 1835322 */:
                case FinalCanbus.CAR_444_WC2_Dongfeng_Xiaokang_Ix5 /* 1835452 */:
                case FinalCanbus.CAR_453_OD_Jiangling_Kaiyun_H /* 1835461 */:
                case FinalCanbus.CAR_454_Tangdu_Toyota_LexusIS /* 1835462 */:
                case FinalCanbus.CAR_RZC_XP1_18Carmy_TOP /* 1900656 */:
                case FinalCanbus.CAR_RZC_Haval_Fengjun5_21 /* 1900788 */:
                case FinalCanbus.CAR_RZC_FengGuang_580Pro_20_H /* 1900858 */:
                case FinalCanbus.CAR_WeiChi2_ChangCheng_JOLION_21 /* 1900864 */:
                case FinalCanbus.CAR_RZC_OD_18JieTU_X70 /* 1900948 */:
                case FinalCanbus.CAR_453_XP1_ZH2_Ford_Explorer_13_Hand /* 1900997 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_GL_19 /* 1966219 */:
                case FinalCanbus.CAR_RZC_Haval_H3_05 /* 1966324 */:
                case FinalCanbus.CAR_WC2_18PRADO /* 1966374 */:
                case FinalCanbus.CAR_WeiChi2_ChangCheng_JOLION_21_H /* 1966400 */:
                case FinalCanbus.CAR_453_XP1_ZH2_Ford_Explorer_13_Auto /* 1966533 */:
                case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_07_MO /* 1966534 */:
                case FinalCanbus.CAR_RZC_XP1_20YuanJingSUV /* 2031755 */:
                case FinalCanbus.CAR_RZC_Haval_Jinggangpao_22 /* 2031860 */:
                case FinalCanbus.CAR_WC2_18Camery /* 2031910 */:
                case FinalCanbus.CAR_WeiChi2_ChangCheng_F7X_19 /* 2031936 */:
                case FinalCanbus.CAR_RZC4_PSA_ALL_NoAir_L /* 2031955 */:
                case FinalCanbus.CAR_RZC_XP1_22Ruihu_3X /* 2032020 */:
                case FinalCanbus.CAR_453_XP1_ZH2_Ford_Explorer_16_Hand /* 2032069 */:
                case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_07_TX /* 2032070 */:
                case FinalCanbus.CAR_RZC_XP1_22Highlander /* 2097264 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_GL_20 /* 2097291 */:
                case FinalCanbus.CAR_RZC_Haval_H7Hongbiao_18 /* 2097396 */:
                case FinalCanbus.CAR_WC2_18PRADO_H /* 2097446 */:
                case FinalCanbus.CAR_WeiChi2_ChangCheng_F7X_19_H /* 2097472 */:
                case FinalCanbus.CAR_RZC4_PSA_ALL_NoAir_M /* 2097491 */:
                case FinalCanbus.CAR_RZC_XP1_23Ruihu_3X /* 2097556 */:
                case FinalCanbus.CAR_453_XP1_ZH2_Ford_Explorer_16_Auto /* 2097605 */:
                case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_12_MO /* 2097606 */:
                case FinalCanbus.CAR_RZC_XC_Huangguan_14 /* 2162800 */:
                case FinalCanbus.CAR_RZC_XP1_Boyue_Pro_20 /* 2162827 */:
                case FinalCanbus.CAR_RZC_Haval_H7Hongbiao_18_H /* 2162932 */:
                case FinalCanbus.CAR_WC2_16PRADO /* 2162982 */:
                case FinalCanbus.CAR_RZC4_PSA_ALL_NoAir_H /* 2163027 */:
                case FinalCanbus.CAR_RZC_XP1_22AiRuiZe5 /* 2163092 */:
                case FinalCanbus.CAR_439_RZC_ZhongTaiT500 /* 2163127 */:
                case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_12_TX /* 2163142 */:
                case FinalCanbus.CAR_XP1_GM_AJcd600 /* 2228249 */:
                case FinalCanbus.CAR_RZC_XP1_Bingyue_19 /* 2228363 */:
                case FinalCanbus.CAR_RZC_HavalF7_19_Top /* 2228468 */:
                case FinalCanbus.CAR_WC2_16PRADO_H /* 2228518 */:
                case FinalCanbus.CAR_RZC4_PSA_C4_OE_L /* 2228563 */:
                case FinalCanbus.CAR_WC2_BeiQi_EV300_18 /* 2228619 */:
                case FinalCanbus.CAR_RZC_QiRui_Guojin_Junxing /* 2228628 */:
                case FinalCanbus.CAR_439_RZC_ZhongTaiT300 /* 2228663 */:
                case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_10_MO /* 2228678 */:
                case FinalCanbus.CAR_455_OD_Jilie_JiheA /* 2228679 */:
                case FinalCanbus.CAR_RZC_XP1_20_LandCruiser /* 2293872 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_GS_20 /* 2293899 */:
                case FinalCanbus.CAR_RZC_HavalLow_Changchengpao_19_L /* 2294004 */:
                case FinalCanbus.CAR_RZC4_PSA_C4_OE_M /* 2294099 */:
                case FinalCanbus.CAR_WC2_JieTu_X70_22 /* 2294155 */:
                case FinalCanbus.CAR_RZC_XP1_23Ruihu_5X /* 2294164 */:
                case FinalCanbus.CAR_439_RZC_ZhongTaiSR9 /* 2294199 */:
                case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_10_TX /* 2294214 */:
                case FinalCanbus.CAR_RZC_ALL_GM_SP_36 /* 2359357 */:
                case FinalCanbus.CAR_RZC_HavalH7L_17 /* 2359540 */:
                case FinalCanbus.CAR_RZC4_PSA_C4_OE_H /* 2359635 */:
                case FinalCanbus.CAR_WC2_JieTu_X70_22_H /* 2359691 */:
                case FinalCanbus.CAR_OD_RZC_23QiRuiAiRuiZeE /* 2359700 */:
                case FinalCanbus.CAR_439_RZC_ZhongTaiSR9_H /* 2359735 */:
                case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_14_MO /* 2359750 */:
                case FinalCanbus.CAR_DJ_GM_ALL /* 2424857 */:
                case FinalCanbus.CAR_RZC_ALL_GM_SP_37 /* 2424893 */:
                case FinalCanbus.CAR_RZC_XP1_22_Sienna /* 2424944 */:
                case FinalCanbus.CAR_RZC_XP1_Jiaji_21 /* 2424971 */:
                case FinalCanbus.CAR_RZC_HavalH7L_17_H /* 2425076 */:
                case FinalCanbus.CAR_RZC_XP1_23AiRuiZe5 /* 2425236 */:
                case FinalCanbus.CAR_452_OD_Ruilan_X3_Pro /* 2425285 */:
                case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_14_TX /* 2425286 */:
                case FinalCanbus.CAR_XP1_GM_AJcd650 /* 2490393 */:
                case FinalCanbus.CAR_RZC_ALL_GM_18Excelle /* 2490429 */:
                case FinalCanbus.CAR_RZC_XP1_19_Corolla /* 2490480 */:
                case FinalCanbus.CAR_RZC_XP1_Binrui_20 /* 2490507 */:
                case FinalCanbus.CAR_RZC_XP1_23AiRuiZe5_EV /* 2490772 */:
                case FinalCanbus.CAR_452_OD_Jihe_EX3 /* 2490821 */:
                case FinalCanbus.CAR_454_OD_Jianghuai_SEHOL_E50A /* 2490822 */:
                case FinalCanbus.CAR_RZC_ALL_GM_09_19Regal /* 2555965 */:
                case FinalCanbus.CAR_RZC_XP1_20_4Runner /* 2556016 */:
                case FinalCanbus.CAR_RZC_XP1_Haoyue_20 /* 2556043 */:
                case FinalCanbus.CAR_RZC_XP1_21DR_F35 /* 2556308 */:
                case FinalCanbus.CAR_452_LZ_Ferrari_430 /* 2556357 */:
                case FinalCanbus.CAR_XP1_GM_Opel_Meriva /* 2621465 */:
                case FinalCanbus.CAR_RZC_ALL_GM_14_18Trax /* 2621501 */:
                case FinalCanbus.CAR_RZC_XP1_22_Harrier /* 2621552 */:
                case FinalCanbus.CAR_RZC_XP1_Dihaoe_22 /* 2621579 */:
                case FinalCanbus.CAR_WC2_TOYOTA_23Corolla /* 2621734 */:
                case FinalCanbus.CAR_DJ_GM_Kopach /* 2687001 */:
                case FinalCanbus.CAR_RZC_ALL_GM_14_18Envision /* 2687037 */:
                case FinalCanbus.CAR_RZC_XP1_22_CROSS /* 2687088 */:
                case FinalCanbus.CAR_RZC_XP1_Xingrui_22 /* 2687115 */:
                case FinalCanbus.CAR_WC2_TOYOTA_23Corolla_H /* 2687270 */:
                case FinalCanbus.CAR_OD_RZC_20Showjet /* 2687380 */:
                case FinalCanbus.CAR_453_LZ_Nissan_Teana_03 /* 2687429 */:
                case FinalCanbus.CAR_RZC_ALL_GM_16_18Verano_GS /* 2752573 */:
                case FinalCanbus.CAR_RZC_XP1_22_FRONTLANDER /* 2752624 */:
                case FinalCanbus.CAR_RZC_BoYue_21 /* 2752651 */:
                case FinalCanbus.CAR_WC2_TOYOTA_22Corolla /* 2752806 */:
                case FinalCanbus.CAR_RZC_OD_18JieTU_X70_H /* 2752916 */:
                case FinalCanbus.CAR_453_LZ_Nissan_Teana_03_H /* 2752965 */:
                case FinalCanbus.CAR_RZC_ALL_GM_17_19Equinox /* 2818109 */:
                case FinalCanbus.CAR_RZC_XP1_Lexus_GS_04_07 /* 2818160 */:
                case FinalCanbus.CAR_RZC_Xiongmao_Mini_23 /* 2818187 */:
                case FinalCanbus.CAR_WC2_TOYOTA_22Corolla_H /* 2818342 */:
                case FinalCanbus.CAR_RZC_OD_19JieTU_X90 /* 2818452 */:
                case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5 /* 2818501 */:
                case FinalCanbus.CAR_RZC_ALL_GM_09_17Cruze /* 2883645 */:
                case FinalCanbus.CAR_RZC_XP1_Lexus_LS_04_06 /* 2883696 */:
                case FinalCanbus.CAR_RZC_Jili_TX5 /* 2883723 */:
                case FinalCanbus.CAR_WC2_TOYOTA_06ReiZ_KeepAir /* 2883878 */:
                case FinalCanbus.CAR_RZC_OD_19JieTU_X90_H /* 2883988 */:
                case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5_H /* 2884037 */:
                case FinalCanbus.CAR_RZC_ALL_GM_10_14Excelle /* 2949181 */:
                case FinalCanbus.CAR_RZC_XP1_22_VENZA /* 2949232 */:
                case FinalCanbus.CAR_RZC_XP1_BingyuePro_19 /* 2949259 */:
                case FinalCanbus.CAR_WC2_TOYOTA_06ReiZ_ChangeAir /* 2949414 */:
                case FinalCanbus.CAR_455_6606_RZC_VinFast_PLUS_23 /* 2949575 */:
                case FinalCanbus.CAR_RZC_ALL_GM_11_14Aveo /* 3014717 */:
                case FinalCanbus.CAR_RZC_Huangguan_14 /* 3014768 */:
                case FinalCanbus.CAR_RZC_Jili_15YuanJing /* 3014795 */:
                case FinalCanbus.CAR_WC2_TOYOTA_23GRANVIA /* 3014950 */:
                case FinalCanbus.CAR_WC2_Honda_17Acura_MDX /* 3014977 */:
                case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5 /* 3015109 */:
                case FinalCanbus.CAR_RZC_ALL_GM_19Trailblazer /* 3080253 */:
                case FinalCanbus.CAR_RZC_XP1_22Highlander_LOW /* 3080304 */:
                case FinalCanbus.CAR_OuDi_XP1_Borui_18 /* 3080331 */:
                case FinalCanbus.CAR_WC2_TOYOTA_23GRANVIA_H /* 3080486 */:
                case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5_H /* 3080645 */:
                case FinalCanbus.CAR_RZC_ALL_GM_20Encore_GX /* 3145789 */:
                case FinalCanbus.CAR_RZC_XP1_22_Sienna_LOW /* 3145840 */:
                case FinalCanbus.CAR_OuDi_XP1_Borui_18_L /* 3145867 */:
                case FinalCanbus.CAR_WC2_TOYOTA_22Veloz /* 3146022 */:
                case FinalCanbus.CAR_RZC_ALL_GM_18Excelle_GX /* 3211325 */:
                case FinalCanbus.CAR_Oudi_Jili_Binyue_Pro /* 3211403 */:
                case FinalCanbus.CAR_WC2_TOYOTA_22Veloz_H /* 3211558 */:
                case FinalCanbus.CAR_RZC_ALL_GM_18_19_GL6 /* 3276861 */:
                case FinalCanbus.CAR_RZC_XP1_Bingyue_21_RS /* 3276939 */:
                case FinalCanbus.CAR_WC2_TOYOTA_21Fortuner /* 3277094 */:
                case FinalCanbus.CAR_455_OD_ChangAn_CS95_H /* 3277255 */:
                case FinalCanbus.CAR_RZC_ALL_GM_16_20Cavalier /* 3342397 */:
                case FinalCanbus.CAR_RZC_XP1_Dihao_23 /* 3342475 */:
                case FinalCanbus.CAR_WC2_TOYOTA_21Fortuner_H /* 3342630 */:
                case FinalCanbus.CAR_RZC_ALL_GM_16_18LovaRV /* 3407933 */:
                case FinalCanbus.CAR_RZC_XP1_05_REIZ /* 3407984 */:
                case FinalCanbus.CAR_WC2_TOYOTA_23Innova /* 3408166 */:
                case FinalCanbus.CAR_RZC_ALL_GM_19Monza /* 3473469 */:
                case FinalCanbus.CAR_RZC_XP1_22Highlander_H /* 3473520 */:
                case FinalCanbus.CAR_WC2_TOYOTA_23Innova_H /* 3473702 */:
                case FinalCanbus.CAR_453_RZC_Changan_CS15_EPro_21 /* 3473861 */:
                case FinalCanbus.CAR_RZC_ALL_GM_19Trax /* 3539005 */:
                case FinalCanbus.CAR_WC2_TOYOTA_22RAV4 /* 3539238 */:
                case FinalCanbus.CAR_454_LZ_Toyota_Prius_03_L /* 3539398 */:
                case FinalCanbus.CAR_RZC_ALL_GM_20Encore /* 3604541 */:
                case FinalCanbus.CAR_WC2_TOYOTA_22RAV4_H /* 3604774 */:
                case FinalCanbus.CAR_454_LZ_Toyota_Prius_03_H /* 3604934 */:
                case FinalCanbus.CAR_RZC_ALL_GM_11_17AstraJ /* 3670077 */:
                case FinalCanbus.CAR_WC2_TOYOTA_22NOAH /* 3670310 */:
                case FinalCanbus.CAR_RZC_ALL_GM_17_19CorsaE /* 3735613 */:
                case FinalCanbus.CAR_WC2_TOYOTA_22NOAH_H /* 3735846 */:
                case FinalCanbus.CAR_452_OD_WeiCai_U70_20 /* 3736004 */:
                case FinalCanbus.CAR_RZC_ALL_GM_15_19Insignia /* 3801149 */:
                case FinalCanbus.CAR_454_LZ_Lexus_RX330_L /* 3801542 */:
                case FinalCanbus.CAR_RZC_ALL_GM_08_10AstraH /* 3866685 */:
                case FinalCanbus.CAR_CZH_RZC_Focus2015 /* 3866958 */:
                case FinalCanbus.CAR_454_LZ_Lexus_RX330_H /* 3867078 */:
                case FinalCanbus.CAR_RZC_ALL_GM_11CorsaD /* 3932221 */:
                case FinalCanbus.CAR_454_LZ_Ford_F150_15_L /* 3932614 */:
                case FinalCanbus.CAR_RZC_ALL_GM_08Combo /* 3997757 */:
                case FinalCanbus.CAR_454_LZ_Ford_F150_15_H /* 3998150 */:
                case FinalCanbus.CAR_RZC_ALL_GM_20Envision /* 4063293 */:
                case FinalCanbus.CAR_RZC_XP1_Focus2015_M /* 4063566 */:
                case FinalCanbus.CAR_439_XBS_09Tianlai /* 4063671 */:
                case FinalCanbus.CAR_454_OD_Beijing_X3_18 /* 4063686 */:
                case FinalCanbus.CAR_RZC_ALL_GM_63 /* 4128829 */:
                case FinalCanbus.CAR_RZC_XP1_15_LandCruiser /* 4128880 */:
                case FinalCanbus.CAR_RZC_XP1_Focus2015_H /* 4129102 */:
                case FinalCanbus.CAR_439_HC_RongWei950 /* 4129207 */:
                case FinalCanbus.CAR_454_OD_Beijing_X5_18 /* 4129222 */:
                case FinalCanbus.CAR_RZC_ALL_GM_Menlo_EV /* 4194365 */:
                case FinalCanbus.CAR_RZC_23_Corolla_Malaysia /* 4194416 */:
                case FinalCanbus.CAR_XP1_RAM1500_H_AUTO /* 4194678 */:
                case FinalCanbus.CAR_454_OD_Beiqi_EU5_18 /* 4194758 */:
                case FinalCanbus.CAR_RZC_ALL_GM_21Monza /* 4259901 */:
                case FinalCanbus.CAR_RZC_23_Vios_Malaysia /* 4259952 */:
                case FinalCanbus.CAR_RZC_HONDA_23Yage /* 4260138 */:
                case FinalCanbus.CAR_453_XP1_Ford_Edge_2013 /* 4260293 */:
                case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_D50_19 /* 4260294 */:
                case FinalCanbus.CAR_RZC_ALL_GM_19Lacrosse_EV /* 4325437 */:
                case FinalCanbus.CAR_DUDU_RZC_Toyota_Corolla_14 /* 4325488 */:
                case FinalCanbus.CAR_WC2_TOYOTA_17Fortuner /* 4325670 */:
                case FinalCanbus.CAR_439_RZC_LufengXiaoyao /* 4325815 */:
                case FinalCanbus.CAR_453_XP1_Ford_F150_2013 /* 4325829 */:
                case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X35_19 /* 4325830 */:
                case FinalCanbus.CAR_RZC_ALL_GM_20Regal_GS /* 4390973 */:
                case FinalCanbus.CAR_DUDU_RZC_Toyota_RAV4_20_Hand /* 4391024 */:
                case FinalCanbus.CAR_WC2_TOYOTA_13Vellfire /* 4391206 */:
                case FinalCanbus.CAR_453_XP1_Ford_Explorer_2013 /* 4391365 */:
                case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X55_18 /* 4391366 */:
                case FinalCanbus.CAR_RZC_ALL_GM_12_13Regal_GS /* 4456509 */:
                case FinalCanbus.CAR_DUDU_RZC_Toyota_RAV4_20_Auto /* 4456560 */:
                case FinalCanbus.CAR_WC2_TOYOTA_17Fortuner_H /* 4456742 */:
                case FinalCanbus.CAR_453_XP1_Ford_Taurus_2013 /* 4456901 */:
                case FinalCanbus.CAR_454_OD_Beiqi_Zhixing_18 /* 4456902 */:
                case FinalCanbus.CAR_RZC_ALL_GM_10Enclave /* 4522045 */:
                case FinalCanbus.CAR_DUDU_RZC_Toyota_Highlander_15_Hand /* 4522096 */:
                case FinalCanbus.CAR_WC2_TOYOTA_13Vellfire_H /* 4522278 */:
                case FinalCanbus.CAR_453_XP1_Ford_Expedition_2013 /* 4522437 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mondeo_16 /* 4522438 */:
                case FinalCanbus.CAR_RZC_ALL_GM_15GL8_Top /* 4587581 */:
                case FinalCanbus.CAR_DUDU_RZC_Toyota_Highlander_15_Auto /* 4587632 */:
                case FinalCanbus.CAR_WC2_TOYOTA_17CHR /* 4587814 */:
                case FinalCanbus.CAR_RZC_Focus2019_M /* 4587854 */:
                case FinalCanbus.CAR_453_XP1_Ford_Edge_2015 /* 4587973 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mondeo_17 /* 4587974 */:
                case FinalCanbus.CAR_RZC_Toyota_Prado_02_L /* 4653168 */:
                case FinalCanbus.CAR_WC2_TOYOTA_17CHR_H /* 4653350 */:
                case FinalCanbus.CAR_RZC_Focus2019_H /* 4653390 */:
                case FinalCanbus.CAR_453_XP1_Ford_Mustang_2015 /* 4653509 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_16_H /* 4653510 */:
                case FinalCanbus.CAR_RZC_Toyota_Prado_02_H /* 4718704 */:
                case FinalCanbus.CAR_WC2_TOYOTA_20Runner /* 4718886 */:
                case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD /* 4719035 */:
                case FinalCanbus.CAR_452_RZC_ChangAn_19OuShang /* 4719044 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Taurus_10_H /* 4719046 */:
                case FinalCanbus.CAR_RZC_XP1_GM_3_20 /* 4784189 */:
                case FinalCanbus.CAR_RZC_XP1_05_REIZ_H /* 4784240 */:
                case FinalCanbus.CAR_WC2_TOYOTA_20Runner_H /* 4784422 */:
                case FinalCanbus.CAR_453_RZC_SWM_G01_22 /* 4784581 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_17_Auto /* 4784582 */:
                case FinalCanbus.CAR_RZC_ALL_GM_20Regal /* 4849725 */:
                case FinalCanbus.CAR_RZC_Toyota_Prado_10_CD /* 4849776 */:
                case FinalCanbus.CAR_WC2_TOYOTA_21Sienna_H /* 4849958 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_14_Auto /* 4850118 */:
                case FinalCanbus.CAR_RZC_ALL_GM_20Equinox /* 4915261 */:
                case FinalCanbus.CAR_WC2_TOYOTA_22Harrier /* 4915494 */:
                case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD_HW /* 4915643 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_15 /* 4915654 */:
                case FinalCanbus.CAR_RZC_Toyota_LandCruiser_13_ABC /* 4980848 */:
                case FinalCanbus.CAR_WC2_TOYOTA_22Harrier_H /* 4981030 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_KUGA_15 /* 4981190 */:
                case FinalCanbus.CAR_RZC_ALL_GM_Menlo_EV_L /* 5046333 */:
                case FinalCanbus.CAR_RZC_XP1_22_CROSS_H /* 5046384 */:
                case FinalCanbus.CAR_WC2_TOYOTA_22VENZA /* 5046566 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_KUGA_18 /* 5046726 */:
                case FinalCanbus.CAR_RZC_ALL_GM_Laccrose_15_H /* 5111869 */:
                case FinalCanbus.CAR_RZC_XP1_22_FRONTLANDER_H /* 5111920 */:
                case FinalCanbus.CAR_WC2_TOYOTA_22VENZA_H /* 5112102 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_FOCUS_15 /* 5112262 */:
                case FinalCanbus.CAR_RZC_ALL_GM_Verano_22_L /* 5177405 */:
                case FinalCanbus.CAR_DUDU_RZC_XP1_18Carmy /* 5177456 */:
                case FinalCanbus.CAR_WC2_TOYOTA_21CROWNKLUGER /* 5177638 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_FOCUS_18 /* 5177798 */:
                case FinalCanbus.CAR_RZC_ALL_GM_Laccrose_10_L /* 5242941 */:
                case FinalCanbus.CAR_DUDU_RZC_XP1_18Carmy_H /* 5242992 */:
                case FinalCanbus.CAR_WC2_TOYOTA_21CROWNKLUGER_H /* 5243174 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_15_H /* 5243334 */:
                case FinalCanbus.CAR_RZC_ALL_GM_HUMMER_09_H2 /* 5308477 */:
                case FinalCanbus.CAR_DUDU_RZC_XP1_18Carmy_TOP /* 5308528 */:
                case FinalCanbus.CAR_WC2_TOYOTA_22COROLLACROSS /* 5308710 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_18_H /* 5308870 */:
                case FinalCanbus.CAR_RZC_ALL_GM_Chevrolet_12 /* 5374013 */:
                case FinalCanbus.CAR_RZC_XP1_20_Sienta /* 5374064 */:
                case FinalCanbus.CAR_WC2_TOYOTA_22COROLLACROSS_H /* 5374246 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_15 /* 5374406 */:
                case FinalCanbus.CAR_RZC_CYC_GM_All /* 5439549 */:
                case FinalCanbus.CAR_RZC_XP1_20_Sienta_H /* 5439600 */:
                case FinalCanbus.CAR_WC2_TOYOTA_22Frontlander /* 5439782 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_18 /* 5439942 */:
                case FinalCanbus.CAR_RZC_ALL_GM_11_17AstraK /* 5505085 */:
                case FinalCanbus.CAR_RZC_XP1_Lexus_IS_06 /* 5505136 */:
                case FinalCanbus.CAR_WC2_TOYOTA_22Frontlander_H /* 5505318 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_12_H /* 5505478 */:
                case FinalCanbus.CAR_RZC_ALL_GM_13_16Mokka /* 5570621 */:
                case FinalCanbus.CAR_RZC_XP1_Lexus_IS_06_H /* 5570672 */:
                case FinalCanbus.CAR_WC2_TOYOTA_22COROLLA_SA /* 5570854 */:
                case FinalCanbus.CAR_453_LZ_Chrysler_300C_15 /* 5571013 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_17 /* 5571014 */:
                case FinalCanbus.CAR_RZC_XP1_Lexus_ES_06 /* 5636208 */:
                case FinalCanbus.CAR_WC2_TOYOTA_22COROLLA_SA_H /* 5636390 */:
                case FinalCanbus.CAR_CZH_RZC_HONDA_Civic /* 5636394 */:
                case FinalCanbus.CAR_453_LZ_Maserati_Levante_18 /* 5636549 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_18 /* 5636550 */:
                case FinalCanbus.CAR_RZC_XP1_Lexus_ES_06_H /* 5701744 */:
                case FinalCanbus.CAR_WC2_TOYOTA_02Alpha /* 5701926 */:
                case FinalCanbus.CAR_CZH_RZC_HONDA_10Yage /* 5701930 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_15 /* 5702086 */:
                case FinalCanbus.CAR_RZC_ALL_GM_11_MerivaB /* 5767229 */:
                case FinalCanbus.CAR_RZC_Toyota_PRIUS_CD /* 5767280 */:
                case FinalCanbus.CAR_WC2_TOYOTA_23Yaris_ASEAN /* 5767462 */:
                case FinalCanbus.CAR_CZH_RZC_HONDA_Haoying /* 5767466 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_12_L /* 5767622 */:
                case FinalCanbus.CAR_RZC_Toyota_PRIUS_NOCD /* 5832816 */:
                case FinalCanbus.CAR_WC2_TOYOTA_23Yaris_ASEAN_H /* 5832998 */:
                case FinalCanbus.CAR_CZH_RZC_HONDA_CRV /* 5833002 */:
                case FinalCanbus.CAR_453_DJ_Nissan_NOCD /* 5833157 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_12_H /* 5833158 */:
                case FinalCanbus.CAR_RZC_XP1_Lexus_LS460 /* 5898352 */:
                case FinalCanbus.CAR_WC2_TOYOTA_TMK_BENZ_EV_ALL /* 5898534 */:
                case FinalCanbus.CAR_453_DJ_Nissan_NOCD_H /* 5898693 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_15_L /* 5898694 */:
                case FinalCanbus.CAR_RZC_XP1_Lexus_LS460_H /* 5963888 */:
                case FinalCanbus.CAR_WC2_TOYOTA_13Harrier_ASEAN /* 5964070 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Everest_16 /* 5964230 */:
                case FinalCanbus.CAR_RZC_XP1_LC100 /* 6029424 */:
                case FinalCanbus.CAR_WC2_TOYOTA_16Sienna /* 6029606 */:
                case FinalCanbus.CAR_439_RZC_YinFeiNiDi_QX50 /* 6029751 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Everest_18 /* 6029766 */:
                case FinalCanbus.CAR_RZC_XP1_LC100_H /* 6094960 */:
                case FinalCanbus.CAR_WC2_TOYOTA_17Sienna_NA /* 6095142 */:
                case FinalCanbus.CAR_452_OD_Nissan_Tule_low /* 6095300 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_16_L /* 6095302 */:
                case FinalCanbus.CAR_RZC_XP1_23_VOXY_H /* 6160496 */:
                case FinalCanbus.CAR_WC2_TOYOTA_21Tacoma_NA /* 6160678 */:
                case FinalCanbus.CAR_452_OD_Zhonghua_V6_18 /* 6160836 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Taurus_10_L /* 6160838 */:
                case FinalCanbus.CAR_RZC_XP1_23_VOXY /* 6226032 */:
                case FinalCanbus.CAR_WC2_TOYOTA_22Camery_NA /* 6226214 */:
                case FinalCanbus.CAR_452_Xinchi_Dodge_JCUV /* 6226372 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_14_Hand /* 6226374 */:
                case FinalCanbus.CAR_RZC_XP1_23_NOAH_H /* 6291568 */:
                case FinalCanbus.CAR_WC2_TOYOTA_18Prius_NA /* 6291750 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mondeo_18 /* 6291910 */:
                case FinalCanbus.CAR_RZC_ALL_GM_23ONIX /* 6357053 */:
                case FinalCanbus.CAR_RZC_XP1_23_NOAH /* 6357104 */:
                case FinalCanbus.CAR_WC2_TOYOTA_16PriusV_NA /* 6357286 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_17_SYNC3 /* 6357446 */:
                case FinalCanbus.CAR_RZC_XP1_MaiRuiBao16 /* 6422589 */:
                case FinalCanbus.CAR_RZC_Toyota_Corolla_CROSS_23_H /* 6422640 */:
                case FinalCanbus.CAR_WC2_TOYOTA_21RAV4_NA /* 6422822 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_17_Hand /* 6422982 */:
                case FinalCanbus.CAR_RZC_XP1_16_18MaiRuiBaoXL /* 6488125 */:
                case FinalCanbus.CAR_RZC_Toyota_Corolla_CROSS_23 /* 6488176 */:
                case FinalCanbus.CAR_WC2_TOYOTA_18IZOA /* 6488358 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_10_Auto /* 6488518 */:
                case FinalCanbus.CAR_RZC_XP1_19MaiRuiBaoXL /* 6553661 */:
                case FinalCanbus.CAR_RZC_TOYOTA_21Fortuner_ASEAN /* 6553712 */:
                case FinalCanbus.CAR_WC2_TOYOTA_18IZOA_H /* 6553894 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_10_Hand /* 6554054 */:
                case FinalCanbus.CAR_RZC_TOYOTA_21Fortuner_ASEAN_H /* 6619248 */:
                case FinalCanbus.CAR_WC2_TOYOTA_13Yaris /* 6619430 */:
                case FinalCanbus.CAR_454_LZ_TOYOTA_LC300_KycAir /* 6619590 */:
                case FinalCanbus.CAR_RZC_TOYOTA_23Yaris_ASEAN /* 6684784 */:
                case FinalCanbus.CAR_WC2_TOYOTA_21Yaris /* 6684966 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX70_13 /* 6685126 */:
                case FinalCanbus.CAR_RZC_TOYOTA_23Yaris_ASEAN_H /* 6750320 */:
                case FinalCanbus.CAR_WC2_TOYOTA_10ReiZ /* 6750502 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_Q70_16_L /* 6750662 */:
                case FinalCanbus.CAR_RZC_ALL_GM_18_23Suburban /* 6815805 */:
                case FinalCanbus.CAR_RZC_TOYOTA_23Veloz_ASEAN /* 6815856 */:
                case FinalCanbus.CAR_WC2_TOYOTA_14ReiZ /* 6816038 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_Q70_16_H /* 6816198 */:
                case FinalCanbus.CAR_RZC_ALL_GM_22Colorado /* 6881341 */:
                case FinalCanbus.CAR_RZC_TOYOTA_23Veloz_ASEAN_H /* 6881392 */:
                case FinalCanbus.CAR_WC2_TOYOTA_13Prius /* 6881574 */:
                case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_08_TX /* 6881733 */:
                case FinalCanbus.CAR_RZC_ALL_GM_18Traverse /* 6946877 */:
                case FinalCanbus.CAR_RZC_TOYOTA_23Innova_ASEAN /* 6946928 */:
                case FinalCanbus.CAR_WC2_TOYOTA_14PRADO /* 6947110 */:
                case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_08_MO10 /* 6947269 */:
                case FinalCanbus.CAR_RZC_ALL_GM_12_19Silverado /* 7012413 */:
                case FinalCanbus.CAR_RZC_TOYOTA_23Innova_ASEAN_H /* 7012464 */:
                case FinalCanbus.CAR_WC2_TOYOTA_10Avalon /* 7012646 */:
                case FinalCanbus.CAR_443_WC2_OULANDE_H /* 7012795 */:
                case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_08_MO13 /* 7012805 */:
                case FinalCanbus.CAR_RZC_ALL_GM_13_14Yukon /* 7077949 */:
                case FinalCanbus.CAR_WC2_TOYOTA_15Avalon /* 7078182 */:
                case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_16_MO /* 7078341 */:
                case FinalCanbus.CAR_RZC_ALL_GMC_18_23Terrain /* 7143485 */:
                case FinalCanbus.CAR_RZC_23_Corolla_Malaysia_H /* 7143536 */:
                case FinalCanbus.CAR_WC2_TOYOTA_19Avalon /* 7143718 */:
                case FinalCanbus.CAR_452_XBS_Nissan_Cedric /* 7143876 */:
                case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_Hand /* 7143877 */:
                case FinalCanbus.CAR_RZC_ALL_GMC_15_17Sierra /* 7209021 */:
                case FinalCanbus.CAR_RZC_23_Vios_Malaysia_H /* 7209072 */:
                case FinalCanbus.CAR_WC2_TOYOTA_10Sienna /* 7209254 */:
                case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_Audo /* 7209413 */:
                case FinalCanbus.CAR_RZC_ALL_GM_22VELITE6_EV /* 7274557 */:
                case FinalCanbus.CAR_WC2_TOYOTA_15Sienna /* 7274790 */:
                case FinalCanbus.CAR_443_WC_OPEL_Astra_04 /* 7274939 */:
                case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_CD /* 7274949 */:
                case FinalCanbus.CAR_RZC_ALL_GM_22VELITE6_PHEV /* 7340093 */:
                case FinalCanbus.CAR_RZC_TOYOTA_23Granvia /* 7340144 */:
                case FinalCanbus.CAR_WC2_TOYOTA_21Sienna_NA /* 7340326 */:
                case FinalCanbus.CAR_443_WC_OPEL_Zafira_05 /* 7340475 */:
                case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_DVD /* 7340485 */:
                case FinalCanbus.CAR_RZC_ALL_GM_18_23Suburban_H /* 7405629 */:
                case FinalCanbus.CAR_RZC_TOYOTA_23Granvia_H /* 7405680 */:
                case FinalCanbus.CAR_WC2_TOYOTA_10Sequoia /* 7405862 */:
                case FinalCanbus.CAR_443_WC_OPEL_Antara_06 /* 7406011 */:
                case FinalCanbus.CAR_453_KYC_Toyota_PRADO_10_Hand /* 7406021 */:
                case FinalCanbus.CAR_RZC_ALL_GM_10_23Suburban /* 7471165 */:
                case FinalCanbus.CAR_RZC_TOYOTA_Alpha_17 /* 7471216 */:
                case FinalCanbus.CAR_WC2_TOYOTA_14Tundra /* 7471398 */:
                case FinalCanbus.CAR_439_RZC_ChangAn_OUSAN_KESAI /* 7471543 */:
                case FinalCanbus.CAR_443_WC_OPEL_Vectra_02 /* 7471547 */:
                case FinalCanbus.CAR_453_KYC_Toyota_PRADO_10_Auto /* 7471557 */:
                case FinalCanbus.CAR_RZC_ALL_GM_10_23Suburban_H /* 7536701 */:
                case FinalCanbus.CAR_WC2_TOYOTA_18Tundra /* 7536934 */:
                case FinalCanbus.CAR_439_RZC_ZhongTaiSR7 /* 7537079 */:
                case FinalCanbus.CAR_443_WC_OPEL_Corsa_06 /* 7537083 */:
                case FinalCanbus.CAR_453_KYC_Toyota_PRADO_10_Top /* 7537093 */:
                case FinalCanbus.CAR_RZC_ALL_GM_18Traverse_H /* 7602237 */:
                case FinalCanbus.CAR_RZC_Toyota_Corolla_cross_America /* 7602288 */:
                case FinalCanbus.CAR_WC2_TOYOTA_16Hilux /* 7602470 */:
                case FinalCanbus.CAR_443_WC_OPEL_Meriva_03 /* 7602619 */:
                case FinalCanbus.CAR_453_KYC_Toyota_Alpha_08 /* 7602629 */:
                case FinalCanbus.CAR_RZC_ALL_GMC_15_17Sierra_H /* 7667773 */:
                case FinalCanbus.CAR_RZC_Toyota_Corolla_cross_AmericaH /* 7667824 */:
                case FinalCanbus.CAR_WC2_TOYOTA_16LuXun /* 7668006 */:
                case FinalCanbus.CAR_453_KYC_Toyota_Alpha_08_TX /* 7668165 */:
                case FinalCanbus.CAR_RZC_ALL_GM_12_19Silverado_H /* 7733309 */:
                case FinalCanbus.CAR_RZC_Toyota_Prado_24 /* 7733360 */:
                case FinalCanbus.CAR_WC2_TOYOTA_19ProACECity /* 7733542 */:
                case FinalCanbus.CAR_453_KYC_Toyota_Alpha_08_MO /* 7733701 */:
                case FinalCanbus.CAR_RZC_ALL_GMC_18_23Terrain_H /* 7798845 */:
                case FinalCanbus.CAR_RZC_Toyota_Prado_24_H /* 7798896 */:
                case FinalCanbus.CAR_WC2_TOYOTA_07Previa /* 7799078 */:
                case FinalCanbus.CAR_443_WC2_Nissan_Ruiqi7 /* 7799227 */:
                case FinalCanbus.CAR_452_OD_LandRover_Freelander /* 7799236 */:
                case FinalCanbus.CAR_453_KYC_Toyota_Alpha_15 /* 7799237 */:
                case FinalCanbus.CAR_RZC_ALL_GMC_10_17Terrain /* 7864381 */:
                case FinalCanbus.CAR_RZC_Toyota_RAV4_24 /* 7864432 */:
                case FinalCanbus.CAR_WC2_TOYOTA_21HIACE /* 7864614 */:
                case FinalCanbus.CAR_453_KYC_Toyota_Alpha_15_Top /* 7864773 */:
                case FinalCanbus.CAR_RZC_ALL_GMC_10_17Terrain_H /* 7929917 */:
                case FinalCanbus.CAR_RZC_Toyota_RAV4_24_H /* 7929968 */:
                case FinalCanbus.CAR_WC2_TOYOTA_20Willander /* 7930150 */:
                case FinalCanbus.CAR_439_OD_ChangAn_CS95 /* 7930295 */:
                case FinalCanbus.CAR_RZC_ALL_GMC_10_17Equinox /* 7995453 */:
                case FinalCanbus.CAR_WC2_TOYOTA_15Crown /* 7995686 */:
                case FinalCanbus.CAR_452_LZ_Volvo /* 7995844 */:
                case FinalCanbus.CAR_RZC_ALL_GMC_10_17Equinox_H /* 8060989 */:
                case FinalCanbus.CAR_RZC_XP1_22_Harrier_H /* 8061040 */:
                case FinalCanbus.CAR_WC2_TOYOTA_14Levin /* 8061222 */:
                case FinalCanbus.CAR_RZC_ALL_GM_22Colorado_H /* 8126525 */:
                case FinalCanbus.CAR_WC2_TOYOTA_19Levin /* 8126758 */:
                case FinalCanbus.CAR_RZC_ALL_GM_21Silverado /* 8192061 */:
                case FinalCanbus.CAR_WC2_TOYOTA_23Altis /* 8192294 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_Toro_19_H /* 8192443 */:
                case FinalCanbus.CAR_RZC_ALL_GM_21Silverado_H /* 8257597 */:
                case FinalCanbus.CAR_WC2_TOYOTA_23Altis_H /* 8257830 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_Toro_19_L /* 8257979 */:
                case FinalCanbus.CAR_RZC_ALL_GMC_19_20Sierra /* 8323133 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_Strada_19_H /* 8323515 */:
                case FinalCanbus.CAR_RZC_ALL_GMC_19_20Sierra_H /* 8388669 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_Strada_19_L /* 8389051 */:
                case FinalCanbus.CAR_453_OD_Ford_PRO_23 /* 8389061 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_FX50S_09 /* 8389062 */:
                case FinalCanbus.CAR_RZC_ALL_GM_24Onix /* 8454205 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_500x_20_H /* 8454587 */:
                case FinalCanbus.CAR_453_OD_Jili_Panda_Mini /* 8454597 */:
                case FinalCanbus.CAR_RZC_ALL_GM_23BOIT /* 8519741 */:
                case FinalCanbus.CAR_439_RZC_19yema_Bojun /* 8520119 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_500x_20_L /* 8520123 */:
                case FinalCanbus.CAR_454_OD_Shanqi_Delong_M3000S /* 8520134 */:
                case FinalCanbus.CAR_RZC_ALL_GM_23Regal /* 8585277 */:
                case FinalCanbus.CAR_454_OD_Shanqi_Delong_L5000 /* 8585670 */:
                case FinalCanbus.CAR_RZC_ALL_GM_23Lacrosse /* 8650813 */:
                case FinalCanbus.CAR_453_RZC_Chuangwei_EV /* 8651205 */:
                case FinalCanbus.CAR_454_OD_Shanqi_Delong_M6000 /* 8651206 */:
                case FinalCanbus.CAR_RZC_ALL_GM_23Equinox /* 8716349 */:
                case FinalCanbus.CAR_452_XC_Nissan_Tule_CD /* 8716740 */:
                case FinalCanbus.CAR_454_OD_Shanqi_Delong_X5000 /* 8716742 */:
                case FinalCanbus.CAR_RZC_ALL_GM_23MaiRuiBaoXL /* 8781885 */:
                case FinalCanbus.CAR_454_OD_Shanqi_Xuandeyi_6 /* 8782278 */:
                case FinalCanbus.CAR_RZC_ALL_GM_23ChevroletBlazer /* 8847421 */:
                case FinalCanbus.CAR_454_OD_Shanqi_Xuandeyi_9 /* 8847814 */:
                case FinalCanbus.CAR_452_Tangdu_Toyota_All /* 8913348 */:
                case FinalCanbus.CAR_454_OD_Shanqi_Zhiyun_E2 /* 8913350 */:
                case FinalCanbus.CAR_452_Tangdu_Toyota_All_H /* 8978884 */:
                case FinalCanbus.CAR_439_LUZ_BinLi /* 9241015 */:
                case FinalCanbus.CAR_443_WC2_Proton_X50_22 /* 9306555 */:
                case FinalCanbus.CAR_443_WC2_Proton_X50_22_H /* 9372091 */:
                case FinalCanbus.CAR_443_WC2_Proton_Persona_22 /* 9437627 */:
                case FinalCanbus.CAR_443_WC2_Proton_X70_22 /* 9503163 */:
                case FinalCanbus.CAR_452_Oudi_Jianghuai_IEV7 /* 9503172 */:
                case FinalCanbus.CAR_443_WC2_Proton_X70_22_H /* 9568699 */:
                case FinalCanbus.CAR_452_Oudi_Jianghuai_IEV7_H /* 9568708 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_Camery_12 /* 9765317 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_Prado_14_Auto /* 9830853 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_LexusRX_07_H /* 9896389 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_Camery_15 /* 9961925 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_Reiz_15 /* 10027461 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_LexusRX_07_L /* 10092997 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_LAND_CRUISE_12 /* 10158533 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_LAND_CRUISE_16 /* 10224069 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_FX37_13 /* 10224070 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_Reiz_12 /* 10289605 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX70_15 /* 10289606 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_Camery_09_A /* 10355141 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX37_11 /* 10355142 */:
                case FinalCanbus.CAR_443_WC_OPEL_Astra_04_H /* 10420667 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_Prado_14_Hand /* 10420677 */:
                case FinalCanbus.CAR_443_WC_OPEL_Zafira_05_H /* 10486203 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_HIGHLANDER_15_A /* 10486213 */:
                case FinalCanbus.CAR_443_WC_OPEL_Antara_06_H /* 10551739 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_ALPHARD_15_A /* 10551749 */:
                case FinalCanbus.CAR_454_OD_Futon_Dajiangjun /* 10551750 */:
                case FinalCanbus.CAR_443_WC_OPEL_Vectra_02_H /* 10617275 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_HIGHLANDER_15_H /* 10617285 */:
                case FinalCanbus.CAR_443_WC_OPEL_Corsa_06_H /* 10682811 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_HIGHLANDER_09_H /* 10682821 */:
                case FinalCanbus.CAR_443_WC_OPEL_Meriva_03_H /* 10748347 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_HIGHLANDER_09_A /* 10748357 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_ALPHARD_11_A /* 10813893 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_Corolla_07_A /* 10879429 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_Corolla_14_A /* 10944965 */:
                case FinalCanbus.CAR_452_RZC_ChangAn_KESAI_Pro_21 /* 11010500 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_Reiz_09_A /* 11010501 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_RAV4_12_A /* 11076037 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_Tundra_14_A /* 11141573 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_Tundra_14_H /* 11207109 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_Prado_18_Auto /* 11272645 */:
                case FinalCanbus.CAR_452_RZC_SWM_G01_21_Low /* 11338180 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_Prado_18_H /* 11338181 */:
                case FinalCanbus.CAR_452_LZ_Ford_Mustang /* 11403716 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_LAND_CRUISE_15_T /* 11403717 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_LexusLX570_10 /* 11469253 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_Camery_18 /* 11534789 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_ALPHARD_18_A /* 11600325 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_FORTUNER_15_A /* 11665861 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_FORTUNER_16_L /* 11731397 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_Tundra_10_A /* 11796933 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_Tundra_10_H /* 11862469 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_LAND_CRUISE_16_T /* 11928005 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_LexusLX570_14 /* 11993541 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_LexusGX_13 /* 12059077 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_LexusGX_14 /* 12124613 */:
                case FinalCanbus.CAR_454_Tangdu_LR_RangeRover_13_SCREEN /* 12124614 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_Camery_09_H /* 12190149 */:
                case FinalCanbus.CAR_454_Tangdu_LR_RangeRover_16_SCREEN /* 12190150 */:
                case FinalCanbus.CAR_452_LZ_Maserati_SP /* 12255684 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_LAND_CRUISE_08_M /* 12255685 */:
                case FinalCanbus.CAR_454_Tangdu_LR_RangeRover_17_SCREEN /* 12255686 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_LAND_CRUISE_16_M /* 12321221 */:
                case FinalCanbus.CAR_454_Tangdu_LR_RangeRover_SCREEN /* 12321222 */:
                case FinalCanbus.CAR_453_Tangdu_Toyota_FORTUNER_16_H /* 12386757 */:
                case FinalCanbus.CAR_454_Tangdu_LR_RangeRover_Sport_10_SCREEN /* 12386758 */:
                case FinalCanbus.CAR_453_XC_Honda_Acura_RL /* 12452293 */:
                case FinalCanbus.CAR_454_Tangdu_LR_RangeRover_Sport_14_SCREEN /* 12452294 */:
                case FinalCanbus.CAR_454_Tangdu_LR_RangeRover_Sport_17_SCREEN /* 12517830 */:
                case FinalCanbus.CAR_454_Tangdu_LR_RangeRover_Sport_SCREEN /* 12583366 */:
                case FinalCanbus.CAR_453_OD_JMC_Energy_Yizhi_EV3 /* 12648901 */:
                case FinalCanbus.CAR_454_Tangdu_LR_Evoque_12_SCREEN /* 12648902 */:
                case FinalCanbus.CAR_453_OD_Dongfeng_Chenglong_H7 /* 12714437 */:
                case FinalCanbus.CAR_454_Tangdu_LR_Evoque_13_SCREEN /* 12714438 */:
                case FinalCanbus.CAR_439_DJ_Nissan /* 12779959 */:
                case FinalCanbus.CAR_453_OD_Jianghuai_Chaoyue /* 12779973 */:
                case FinalCanbus.CAR_454_Tangdu_LR_Evoque_16_SCREEN /* 12779974 */:
                case FinalCanbus.CAR_439_DJ_Nissan_H /* 12845495 */:
                case FinalCanbus.CAR_453_OD_BQ_BJ30_21 /* 12845509 */:
                case FinalCanbus.CAR_454_Tangdu_LR_Evoque_17_SCREEN /* 12845510 */:
                case FinalCanbus.CAR_452_XC_Honda_Acura_TL /* 12911044 */:
                case FinalCanbus.CAR_454_Tangdu_LR_Evoque_SCREEN /* 12911046 */:
                case FinalCanbus.CAR_452_XC_Honda_Acura_RDX /* 12976580 */:
                case FinalCanbus.CAR_454_Tangdu_LR_Velar_SCREEN /* 12976582 */:
                case FinalCanbus.CAR_439_OUDI_Falcon_New_Single /* 13042103 */:
                case FinalCanbus.CAR_452_XC_Honda_Acura_TLX /* 13042116 */:
                case FinalCanbus.CAR_439_OUDI_Falcon_New_Double /* 13107639 */:
                case FinalCanbus.CAR_453_XP_Ford_All_RP3_Hand1 /* 13107653 */:
                case FinalCanbus.CAR_439_OUDI_Territory_New_Single /* 13173175 */:
                case FinalCanbus.CAR_453_XP_Ford_All_RP3_Hand2 /* 13173189 */:
                case FinalCanbus.CAR_439_OUDI_Territory_New_Double /* 13238711 */:
                case FinalCanbus.CAR_453_XP_Ford_All_RP3_Auto1 /* 13238725 */:
                case FinalCanbus.CAR_439_OUDI_Territory_Old_Single /* 13304247 */:
                case FinalCanbus.CAR_453_XP_Ford_All_RP3_Auto2 /* 13304261 */:
                case FinalCanbus.CAR_439_OUDI_Territory_Old_Double /* 13369783 */:
                case FinalCanbus.CAR_453_Tangdu_LR_RangeRover_13 /* 13369797 */:
                case FinalCanbus.CAR_439_OUDI_Falcon_Old_Single /* 13435319 */:
                case FinalCanbus.CAR_453_Tangdu_LR_RangeRover_16 /* 13435333 */:
                case FinalCanbus.CAR_439_OUDI_Falcon_Old_Double /* 13500855 */:
                case FinalCanbus.CAR_453_Tangdu_LR_RangeRover_17 /* 13500869 */:
                case FinalCanbus.CAR_453_Tangdu_LR_RangeRover /* 13566405 */:
                case FinalCanbus.CAR_443_WC2_Jili_GS_18 /* 13631931 */:
                case FinalCanbus.CAR_452_LZ_Volvo_10 /* 13631940 */:
                case FinalCanbus.CAR_453_Tangdu_LR_RangeRover_Sport_10 /* 13631941 */:
                case FinalCanbus.CAR_443_WC2_Jili_GL_18 /* 13697467 */:
                case FinalCanbus.CAR_452_RZC_Mangguo_LeiDing /* 13697476 */:
                case FinalCanbus.CAR_453_Tangdu_LR_RangeRover_Sport_14 /* 13697477 */:
                case FinalCanbus.CAR_443_WC2_Jili_Boyue_18 /* 13763003 */:
                case FinalCanbus.CAR_453_Tangdu_LR_RangeRover_Sport_17 /* 13763013 */:
                case FinalCanbus.CAR_443_WC2_Jili_Boyue_20 /* 13828539 */:
                case FinalCanbus.CAR_453_Tangdu_LR_RangeRover_Sport /* 13828549 */:
                case FinalCanbus.CAR_439_RZC_SWM_G01 /* 13894071 */:
                case FinalCanbus.CAR_443_WC2_Jili_Dihao_22 /* 13894075 */:
                case FinalCanbus.CAR_453_Tangdu_LR_Evoque_12 /* 13894085 */:
                case FinalCanbus.CAR_443_WC2_Jili_Binyue_22 /* 13959611 */:
                case FinalCanbus.CAR_453_Tangdu_LR_Evoque_13 /* 13959621 */:
                case FinalCanbus.CAR_443_WC2_Jili_All /* 14025147 */:
                case FinalCanbus.CAR_453_Tangdu_LR_Evoque_16 /* 14025157 */:
                case FinalCanbus.CAR_454_OD_Maserati_Ghibli_14 /* 14025158 */:
                case FinalCanbus.CAR_439_OUDI_Beiqi_EC3 /* 14090679 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_All_Brazil /* 14090683 */:
                case FinalCanbus.CAR_452_LZ_Ford_Mustang_H /* 14090692 */:
                case FinalCanbus.CAR_453_Tangdu_LR_Evoque_17 /* 14090693 */:
                case FinalCanbus.CAR_454_OD_Maserati_Quattroporte_13 /* 14090694 */:
                case FinalCanbus.CAR_439_OUDI_Beiqi_EC5 /* 14156215 */:
                case FinalCanbus.CAR_452_OD_Changcheng_Oula /* 14156228 */:
                case FinalCanbus.CAR_453_Tangdu_LR_Evoque /* 14156229 */:
                case FinalCanbus.CAR_454_OD_Jilie_DihaoS /* 14156230 */:
                case FinalCanbus.CAR_439_OUDI_Beiqi_EC180 /* 14221751 */:
                case FinalCanbus.CAR_453_Tangdu_LR_Velar /* 14221765 */:
                case FinalCanbus.CAR_454_OD_Zhonghua_V7 /* 14221766 */:
                case FinalCanbus.CAR_439_OUDI_Beiqi_EC220 /* 14287287 */:
                case FinalCanbus.CAR_453_Tangdu_LR_Discovery4_10 /* 14287301 */:
                case FinalCanbus.CAR_454_OD_Zhonghua_V7_H /* 14287302 */:
                case FinalCanbus.CAR_439_OUDI_Beiqi_EU5 /* 14352823 */:
                case FinalCanbus.CAR_453_Tangdu_LR_Discovery4 /* 14352837 */:
                case FinalCanbus.CAR_453_Tangdu_LR_Discovery5 /* 14418373 */:
                case FinalCanbus.CAR_453_Tangdu_LR_Discovery_Sport_15 /* 14483909 */:
                case FinalCanbus.CAR_454_OD_Jiangling_Dadao /* 14483910 */:
                case FinalCanbus.CAR_453_Tangdu_LR_Discovery_Sport_17 /* 14549445 */:
                case FinalCanbus.CAR_454_OD_Jilie_YuanchengXingzhi /* 14549446 */:
                case FinalCanbus.CAR_RZC_ZhongTaiDaMaiX7 /* 14614967 */:
                case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_L /* 14614971 */:
                case FinalCanbus.CAR_453_Tangdu_LR_Discovery_Sport /* 14614981 */:
                case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_M /* 14680507 */:
                case FinalCanbus.CAR_XP1_ZH2_RUIJIE2015 /* 14680516 */:
                case FinalCanbus.CAR_453_Tangdu_LR_Defender /* 14680517 */:
                case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_H /* 14746043 */:
                case FinalCanbus.CAR_453_Tangdu_LR_Freelander /* 14746053 */:
                case FinalCanbus.CAR_453_Tangdu_LR_Freelander2 /* 14811589 */:
                case FinalCanbus.CAR_453_Tangdu_Jaguar_XEXFL /* 14877125 */:
                case FinalCanbus.CAR_453_Tangdu_Jaguar_XFXFL /* 14942661 */:
                case FinalCanbus.CAR_453_Tangdu_Jaguar_F_PACE /* 15008197 */:
                case FinalCanbus.CAR_453_Tangdu_Jaguar_I_TYPE /* 15073733 */:
                case FinalCanbus.CAR_453_Tangdu_Jaguar_F_TYPE /* 15139269 */:
                case FinalCanbus.CAR_453_Tangdu_Jaguar_E_PACE /* 15204805 */:
                case FinalCanbus.CAR_453_Tangdu_Jaguar_XJXJL_12 /* 15270341 */:
                case FinalCanbus.CAR_454_OD_Jianghuai_IC5 /* 15270342 */:
                case FinalCanbus.CAR_453_Tangdu_Jaguar_XJXJL_14 /* 15335877 */:
                case FinalCanbus.CAR_453_Tangdu_Jaguar_XJXJL_16 /* 15401413 */:
                case FinalCanbus.CAR_453_Tangdu_Jaguar_XJXJL /* 15466949 */:
                case FinalCanbus.CAR_439_XC_Feiyate_Feiyue /* 15532471 */:
                case FinalCanbus.CAR_453_LZ_Teana_08_L /* 15532485 */:
                case FinalCanbus.CAR_453_LZ_Teana_08_H /* 15598021 */:
                case FinalCanbus.CAR_452_OD_WeiMa_E5 /* 15663556 */:
                case FinalCanbus.CAR_453_LZ_Teana_08_TW /* 15663557 */:
                case FinalCanbus.CAR_439_RZC_SWM_G01_19 /* 15729079 */:
                case FinalCanbus.CAR_439_RZC_WEICHAI_U70 /* 15794615 */:
                case FinalCanbus.CAR_453_RZC_VinFast_PLUS_23 /* 15860165 */:
                case FinalCanbus.CAR_453_OD_Shanqi_ZHongka /* 15991237 */:
                case FinalCanbus.CAR_453_OD_Jili_Dihao_EV /* 16056773 */:
                case FinalCanbus.CAR_453_XC_Ford_EDGE_L /* 16122309 */:
                case FinalCanbus.CAR_453_XC_Ford_EDGE_H /* 16187845 */:
                case FinalCanbus.CAR_453_OD_Modernin /* 16384453 */:
                case FinalCanbus.CAR_439_OD_Futon_Tunland /* 16449975 */:
                case FinalCanbus.CAR_443_WC2_Proton_S70_24 /* 16449979 */:
                case FinalCanbus.CAR_443_WC2_Proton_S70_24_H /* 16515515 */:
                case FinalCanbus.CAR_452_LZ_Volvo_15 /* 16515524 */:
                case FinalCanbus.CAR_443_WC2_Proton_X90_24 /* 16581051 */:
                case FinalCanbus.CAR_443_WC2_Proton_X90_24_H /* 16646587 */:
                    if (!Air_Activity_All_Toyota_prado_HP.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.air.Air_Activity_All_Toyota_prado_HP");
                        break;
                    } else if (Air_Activity_All_Toyota_prado_HP.mInstance != null) {
                        Air_Activity_All_Toyota_prado_HP.mInstance.finish();
                        break;
                    }
                case 36:
                case 40:
                case 254:
                case 271:
                case 274:
                case 276:
                case 282:
                case 289:
                case 308:
                case 345:
                case 372:
                case 373:
                case 429:
                case FinalCanbus.CAR_DJ_XP1_ACCORD7_H /* 65810 */:
                case FinalCanbus.CAR_WC2_ChuanQiGS4_M /* 65825 */:
                case FinalCanbus.CAR_WC2_ShuPingJW /* 65881 */:
                case FinalCanbus.CAR_WC1_Jeep_ZiYouGuang_M /* 65908 */:
                case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_H /* 65909 */:
                case FinalCanbus.CAR_RZC_XP1_BeiQiM50F /* 65932 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_12Crown_AMP /* 65965 */:
                case FinalCanbus.CAR_RZCexc_Feiyate_TORO /* 131111 */:
                case FinalCanbus.CAR_RZC_XP1_16HAIMAMV70 /* 131309 */:
                case FinalCanbus.CAR_WC2_17MingJueRuiTeng /* 131354 */:
                case FinalCanbus.CAR_WC2_ChuanQiGS4_H /* 131361 */:
                case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6 /* 131379 */:
                case FinalCanbus.CAR_WC2_ShuPingKeLuZi /* 131417 */:
                case FinalCanbus.CAR_WC1_Jeep_ZiYouGuang_H /* 131444 */:
                case FinalCanbus.CAR_RZC_XP1_ZiYouXia /* 131445 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_12Crown_AMP_H /* 131501 */:
                case FinalCanbus.CAR_RZC_SeMar_NoAmp /* 196688 */:
                case FinalCanbus.CAR_RZC_HanTeng_H /* 196863 */:
                case FinalCanbus.CAR_WC2_17ChuanQiGS4 /* 196897 */:
                case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6_H /* 196915 */:
                case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao /* 196953 */:
                case FinalCanbus.CAR_RZC_XP1_GrdCherokee /* 196981 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_13Crown_AMP /* 197037 */:
                case FinalCanbus.CAR_XP1_17MaiTeng /* 262184 */:
                case FinalCanbus.CAR_RZC_SwMar_Amp /* 262224 */:
                case FinalCanbus.CAR_RZC_XP1_HAIMA_F5 /* 262381 */:
                case FinalCanbus.CAR_WC2_17ChuanQiGS3 /* 262433 */:
                case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS /* 262489 */:
                case FinalCanbus.CAR_WC1_Jeep_17ZhiNanZhe /* 262516 */:
                case FinalCanbus.CAR_RZC_17ZhiNanZhe /* 262517 */:
                case FinalCanbus.CAR_CYT_YaGe7_38400 /* 262561 */:
                case FinalCanbus.CAR_WC2_ShuPingMaiRuiBaoS_S /* 328025 */:
                case FinalCanbus.CAR_WC1_Jeep_17ZhiNanZhe_H /* 328052 */:
                case FinalCanbus.CAR_RZC_17ZhiNanZhe_H /* 328053 */:
                case FinalCanbus.CAR_RCW_BYD_10_11F6 /* 328097 */:
                case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria /* 328124 */:
                case FinalCanbus.CAR_WC2_20BaoJun530_Auto /* 393462 */:
                case FinalCanbus.CAR_Oudi_HanTeng_X5 /* 393471 */:
                case FinalCanbus.CAR_WC1_Jeep_18ZiYouXia /* 393588 */:
                case FinalCanbus.CAR_RZC_18MuMaRen /* 393589 */:
                case FinalCanbus.CAR_RCW_BYD_10_13G6 /* 393633 */:
                case FinalCanbus.CAR_OD_Jiangxi_Wushiling_Mux /* 393638 */:
                case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria_H /* 393660 */:
                case FinalCanbus.CAR_WC2_GM_GL6 /* 458788 */:
                case FinalCanbus.CAR_XP_MQB_Lamando /* 458792 */:
                case FinalCanbus.CAR_WC2_20BaoJun530_Hand /* 458998 */:
                case FinalCanbus.CAR_Oudi_XiaoYao /* 459007 */:
                case FinalCanbus.CAR_RZC_20BaoJunRS3 /* 459062 */:
                case FinalCanbus.CAR_WC2_ShuPing10JunYue /* 459097 */:
                case FinalCanbus.CAR_WC1_Jeep_18ZiYouXia_H /* 459124 */:
                case FinalCanbus.CAR_RZC_XP1_GrdCherokee_H /* 459125 */:
                case FinalCanbus.CAR_RCW_YaGe7_38400 /* 459169 */:
                case FinalCanbus.CAR_OD_Jiangxi_Lingtuo /* 459174 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_14Prodo_H_ShuPing /* 459181 */:
                case FinalCanbus.CAR_WC2_GM_WLD /* 524324 */:
                case FinalCanbus.CAR_XP_MQB_Polo /* 524328 */:
                case FinalCanbus.CAR_RZC_HanTeng_X5 /* 524543 */:
                case FinalCanbus.CAR_WC2_ShuPingKeLuZi_Auto /* 524633 */:
                case FinalCanbus.CAR_WC1_Jeep_19ZiYouXia_W /* 524660 */:
                case FinalCanbus.CAR_RZC_18MuMaRen_H /* 524661 */:
                case FinalCanbus.CAR_WC_YaGe7_38400 /* 524705 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_14Prodo_ShuPing /* 524717 */:
                case FinalCanbus.CAR_XP_MQB_Passat_B8 /* 589864 */:
                case FinalCanbus.CAR_WC2_ChuanQiG_GS4_20 /* 590113 */:
                case FinalCanbus.CAR_OD_RZC_20BaoJunRS3 /* 590134 */:
                case FinalCanbus.CAR_RZC_OD_DongNanDX5 /* 590153 */:
                case FinalCanbus.CAR_WC2_ShuPingMaiRuiBao_L /* 590169 */:
                case FinalCanbus.CAR_WC1_Fiat_19_500X /* 590196 */:
                case FinalCanbus.CAR_RZC_19Tiaozhanzhe /* 590197 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown /* 590253 */:
                case FinalCanbus.CAR_WC2_GM_EXCELLE_19 /* 655396 */:
                case FinalCanbus.CAR_XP_MQB_Sportsvan /* 655400 */:
                case FinalCanbus.CAR_WC2_ChuanQiG_AION_19 /* 655649 */:
                case FinalCanbus.CAR_OD_RZC_Wuling_Xingchen /* 655670 */:
                case FinalCanbus.CAR_WC1_Jeep_13_Dodge_JCUV /* 655732 */:
                case FinalCanbus.CAR_RZC_18Zhihuiguan /* 655733 */:
                case FinalCanbus.CAR_RZC_BenTeng_19B50_HAND /* 655773 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown /* 655789 */:
                case FinalCanbus.CAR_WC2_GM_EXCELLE_18 /* 720932 */:
                case FinalCanbus.CAR_XP_MQB_TouranL /* 720936 */:
                case FinalCanbus.CAR_RZC_Nissan_Tianlai_20 /* 721086 */:
                case FinalCanbus.CAR_WC2_ChuanQiG_GS8_17 /* 721185 */:
                case FinalCanbus.CAR_RZC_Wuling_Xingchen /* 721206 */:
                case FinalCanbus.CAR_BNR_NISSAN_14QiJun_H /* 721220 */:
                case FinalCanbus.CAR_WC1_Jeep_13_Dodge_JCUV_CD /* 721268 */:
                case FinalCanbus.CAR_RZC_19Tiaozhanzhe_H /* 721269 */:
                case FinalCanbus.CAR_RZC_BenTeng_19B50_AUTO /* 721309 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown_L /* 721325 */:
                case FinalCanbus.CAR_WC2_GM_GL8_10_13 /* 786468 */:
                case FinalCanbus.CAR_XP_MQB_Tiguan /* 786472 */:
                case FinalCanbus.CAR_RZC_Nissan_Tianlai_20_H /* 786622 */:
                case FinalCanbus.CAR_WC2_ChuanQiG_AION_22 /* 786721 */:
                case FinalCanbus.CAR_RZC_Wuling_Kaijie /* 786742 */:
                case FinalCanbus.CAR_BNR_NISSAN_14QiJun_L /* 786756 */:
                case FinalCanbus.CAR_RZC_18Zhihuiguan_H /* 786805 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown_L /* 786861 */:
                case FinalCanbus.CAR_455_OD_Zhongtai_E200 /* 786887 */:
                case FinalCanbus.CAR_WC2_GM_GL8_14_16 /* 852004 */:
                case FinalCanbus.CAR_XP_MQB_Terament /* 852008 */:
                case FinalCanbus.CAR_RZC_19MingjueHS /* 852241 */:
                case FinalCanbus.CAR_RZC_Wuling_Jiachen /* 852278 */:
                case FinalCanbus.CAR_BNR_NISSAN_16Xiaoke_L /* 852292 */:
                case FinalCanbus.CAR_RZC_13_20Mengdiou /* 852302 */:
                case FinalCanbus.CAR_WC1_Jeep_18_Zhihuiguan /* 852340 */:
                case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19 /* 852341 */:
                case FinalCanbus.CAR_DJ_XC_Nissan_Tianlai_03_07 /* 852397 */:
                case FinalCanbus.CAR_455_XP_Ford_F150_2012 /* 852423 */:
                case FinalCanbus.CAR_WC2_GM_Encore_12_15 /* 917540 */:
                case FinalCanbus.CAR_XP_MQB_Skoda_Octavia /* 917544 */:
                case FinalCanbus.CAR_RZC_FengShen19_20AX7 /* 917759 */:
                case FinalCanbus.CAR_RZC_19RongWei_I5 /* 917777 */:
                case FinalCanbus.CAR_RZC_20BaoJunRS3_Auto /* 917814 */:
                case FinalCanbus.CAR_BNR_NISSAN_13TianLai_H /* 917828 */:
                case FinalCanbus.CAR_WC1_Jeep_15_RAM /* 917876 */:
                case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19_H /* 917877 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_10_13PRADO /* 917933 */:
                case FinalCanbus.CAR_455_XP_Ford_F150_2012_Auto /* 917959 */:
                case FinalCanbus.CAR_WC2_GM_Encore_16_19 /* 983076 */:
                case FinalCanbus.CAR_XP_MQB_Skoda_Fabia /* 983080 */:
                case FinalCanbus.CAR_RZC_Nissan_Qijun_H /* 983230 */:
                case FinalCanbus.CAR_RZC_FengShen19_20AX7_H /* 983295 */:
                case FinalCanbus.CAR_RZC_19RongWei_I6 /* 983313 */:
                case FinalCanbus.CAR_RZC_Wuling_Xingchen_Auto /* 983350 */:
                case FinalCanbus.CAR_BNR_NISSAN_16Xiaoke_H /* 983364 */:
                case FinalCanbus.CAR_WC1_Jeep_18_Zhihuiguan_H /* 983412 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_08_15LAND_CRUISER /* 983469 */:
                case FinalCanbus.CAR_439_OuDi_Z560 /* 983479 */:
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
                case FinalCanbus.CAR_WC2_GM_Regal_09_13 /* 1048612 */:
                case FinalCanbus.CAR_XP_MQB_Skoda_Superb /* 1048616 */:
                case FinalCanbus.CAR_RZC_19MingjueHS_H /* 1048849 */:
                case FinalCanbus.CAR_RZC_Wuling_Kaijie_Auto /* 1048886 */:
                case FinalCanbus.CAR_BNR_NISSAN_13TianLai_L /* 1048900 */:
                case FinalCanbus.CAR_RZC_Mustang /* 1048910 */:
                case FinalCanbus.CAR_WC1_Jeep_15_RAM_H /* 1048948 */:
                case FinalCanbus.CAR_RZC_XP1_BeiQiBJ40_21_H /* 1048972 */:
                case FinalCanbus.CAR_DJ_XC_TOYOTA_LEXUS /* 1049005 */:
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
                case FinalCanbus.CAR_WC2_GM_Lacrosse_10_13 /* 1114148 */:
                case FinalCanbus.CAR_XP_MQB_Skoda_Kodiaq /* 1114152 */:
                case FinalCanbus.CAR_RZC_19RongWei_I5_H /* 1114385 */:
                case FinalCanbus.CAR_RZC_Wuling_Jiachen_Auto /* 1114422 */:
                case FinalCanbus.CAR_BNR_NISSAN_08TianLai_H /* 1114436 */:
                case FinalCanbus.CAR_WC1_TMK_BENZ_MPV_ALL /* 1114484 */:
                case FinalCanbus.CAR_RZC_Dodge_JCUV /* 1114485 */:
                case FinalCanbus.CAR_OD_RZC_BenTeng_B90 /* 1114525 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_HIGHLANDER /* 1114541 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen /* 1114567 */:
                case FinalCanbus.CAR_WC2_GM_Lacrosse_18 /* 1179684 */:
                case FinalCanbus.CAR_XP_MQB_Seat_LeonFR /* 1179688 */:
                case FinalCanbus.CAR_RZC_Wuling_Xingchi /* 1179958 */:
                case FinalCanbus.CAR_BNR_NISSAN_08TianLai_L /* 1179972 */:
                case FinalCanbus.CAR_RZC_17_18KeleiAo /* 1180050 */:
                case FinalCanbus.CAR_DJ_XP1_TOYOTA_HIGHLANDER_H /* 1180077 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen_3 /* 1180103 */:
                case FinalCanbus.CAR_WC2_GM_Excelle_XT /* 1245220 */:
                case FinalCanbus.CAR_XP_MQB_Seat_Ateca /* 1245224 */:
                case FinalCanbus.CAR_RZC_Wuling_Xingchi_Auto /* 1245494 */:
                case FinalCanbus.CAR_BNR_NISSAN_11QiDa_H /* 1245508 */:
                case FinalCanbus.CAR_439_DJ_LEXUS_ES /* 1245623 */:
                case FinalCanbus.CAR_WC2_GM_Excelle_GT /* 1310756 */:
                case FinalCanbus.CAR_OD_RZC_ShangQiDaTong22G50 /* 1310985 */:
                case FinalCanbus.CAR_RZC_19RongWei_RX8 /* 1310993 */:
                case FinalCanbus.CAR_BNR_NISSAN_11QiDa_L /* 1311044 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM /* 1311093 */:
                case FinalCanbus.CAR_RZC_17_18KeleiAo_M /* 1311122 */:
                case FinalCanbus.CAR_WC2_GM_AVEO_11 /* 1376292 */:
                case FinalCanbus.CAR_XP_TuGuan_L_20_H /* 1376296 */:
                case FinalCanbus.CAR_RZC_Mingjue_20ZS /* 1376529 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_H /* 1376629 */:
                case FinalCanbus.CAR_RZC_17_18KeleiAo_H /* 1376658 */:
                case FinalCanbus.CAR_WC2_GM_Orlando_11 /* 1441828 */:
                case FinalCanbus.CAR_RZC_SwMar_17 /* 1441872 */:
                case FinalCanbus.CAR_RZC_FengShen_X37_21 /* 1442047 */:
                case FinalCanbus.CAR_RZC_Mingjue_20ZS_H /* 1442065 */:
                case FinalCanbus.CAR_WC2_GM_Trax_13_18 /* 1507364 */:
                case FinalCanbus.CAR_RZC_SwMar_Amp_17 /* 1507408 */:
                case FinalCanbus.CAR_RZC_19Mingjue_MG6 /* 1507601 */:
                case FinalCanbus.CAR_455_LZ_GMC_Sierra_19_RScreen /* 1507783 */:
                case FinalCanbus.CAR_WC2_GM_Cruze_08_14 /* 1572900 */:
                case FinalCanbus.CAR_CZH_OD_NISSAN_22Teana_Top /* 1572944 */:
                case FinalCanbus.CAR_455_LZ_Chevrolet_Silverado_19_RScreen /* 1573319 */:
                case FinalCanbus.CAR_WC2_GM_Cruze_15 /* 1638436 */:
                case FinalCanbus.CAR_RZC_FengShen15AX7 /* 1638655 */:
                case FinalCanbus.CAR_RZC_18RongWei_RX8 /* 1638673 */:
                case FinalCanbus.CAR_RZC_MEGANE_Turkey_L /* 1638802 */:
                case FinalCanbus.CAR_WC2_GM_Malibu_13 /* 1703972 */:
                case FinalCanbus.CAR_RZC_FengShen19AX7_Hand /* 1704191 */:
                case FinalCanbus.CAR_RZC_20RongWei_RX5 /* 1704209 */:
                case FinalCanbus.CAR_RZC_MEGANE_Turkey_M /* 1704338 */:
                case FinalCanbus.CAR_455_TD_INFINIT_ESQ /* 1704391 */:
                case FinalCanbus.CAR_WC2_GM_Spin_13 /* 1769508 */:
                case FinalCanbus.CAR_RZC_FengShen15AX7_View /* 1769727 */:
                case FinalCanbus.CAR_RZC_MEGANE_Turkey_H /* 1769874 */:
                case FinalCanbus.CAR_455_TD_INFINIT_G /* 1769927 */:
                case FinalCanbus.CAR_WC2_GM_Astra_09_14 /* 1835044 */:
                case FinalCanbus.CAR_RZC_MingJue_MG5_21 /* 1835281 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_M /* 1835381 */:
                case FinalCanbus.CAR_455_TD_INFINIT_QX50 /* 1835463 */:
                case FinalCanbus.CAR_WC2_GM_Astra_15 /* 1900580 */:
                case FinalCanbus.CAR_RZC_21RongWei_I5 /* 1900817 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_HY /* 1900917 */:
                case FinalCanbus.CAR_455_TD_INFINIT_06FX /* 1900999 */:
                case FinalCanbus.CAR_WC2_GM_Mokka_12_16 /* 1966116 */:
                case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_14 /* 1966270 */:
                case FinalCanbus.CAR_RZC_21RongWei_I5_H /* 1966353 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_HY_M /* 1966453 */:
                case FinalCanbus.CAR_RZC_KADJAR_Turkey /* 1966482 */:
                case FinalCanbus.CAR_444_WC2_XianDai_All_15Carnival /* 1966524 */:
                case FinalCanbus.CAR_455_TD_INFINIT_08FX /* 1966535 */:
                case FinalCanbus.CAR_WC2_GM_MokkaX_17 /* 2031652 */:
                case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_11 /* 2031806 */:
                case FinalCanbus.CAR_RZC_MingJue_MG5_21_L /* 2031889 */:
                case FinalCanbus.CAR_RZC_Dodge_RAM_HY_H /* 2031989 */:
                case FinalCanbus.CAR_RZC_CLIO5_Turkey /* 2032018 */:
                case FinalCanbus.CAR_444_WC2_XianDai_All_15Carnival_H /* 2032060 */:
                case FinalCanbus.CAR_455_TD_INFINIT_14QX70 /* 2032071 */:
                case FinalCanbus.CAR_WC2_GM_Insignia_08_12 /* 2097188 */:
                case FinalCanbus.CAR_RZC_Nissan_PATROL_13 /* 2097342 */:
                case FinalCanbus.CAR_CZH_RZC_19Mingjue_MG6 /* 2097425 */:
                case FinalCanbus.CAR_RZC_CLIO5_Turkey_M /* 2097554 */:
                case FinalCanbus.CAR_444_WC2_XianDai_All_23NewZealand /* 2097596 */:
                case FinalCanbus.CAR_455_TD_INFINIT_12FX /* 2097607 */:
                case FinalCanbus.CAR_WC2_GM_Insignia_13_16 /* 2162724 */:
                case FinalCanbus.CAR_RZC_XP1_ZiYouXia_H /* 2163061 */:
                case FinalCanbus.CAR_RZC_CLIO5_Turkey_H /* 2163090 */:
                case FinalCanbus.CAR_444_WC2_XianDai_All_23NewZealand_H /* 2163132 */:
                case FinalCanbus.CAR_453_LZ_GM_Camaro_17 /* 2163141 */:
                case FinalCanbus.CAR_WC2_GM_Regal_14 /* 2228260 */:
                case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_14_H /* 2228414 */:
                case FinalCanbus.CAR_RZC_MEGANE_Turkey_L_AUTO /* 2228626 */:
                case FinalCanbus.CAR_453_LZ_GM_GMC_TERRAIN_17 /* 2228677 */:
                case FinalCanbus.CAR_WC2_GM_ENVISION_14 /* 2293796 */:
                case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_11_H /* 2293950 */:
                case FinalCanbus.CAR_RZC_Ford_F150_12 /* 2294094 */:
                case FinalCanbus.CAR_453_LZ_GM_Equinox_17 /* 2294213 */:
                case FinalCanbus.CAR_455_OD_Dongfeng_Racing_EC75_23H /* 2294215 */:
                case FinalCanbus.CAR_WC2_GM_Lacrosse_14 /* 2359332 */:
                case FinalCanbus.CAR_RZC_Nissan_PATROL_13_H /* 2359486 */:
                case FinalCanbus.CAR_RZC_Mustang_NO_CD /* 2359630 */:
                case FinalCanbus.CAR_RZC_Dodge_JCUV_H /* 2359669 */:
                case FinalCanbus.CAR_WC2_GM_Verano_15 /* 2424868 */:
                case FinalCanbus.CAR_RZC_Nissan_Xtrail_Import_22 /* 2425022 */:
                case FinalCanbus.CAR_WC2_GM_Verano_GS_16 /* 2490404 */:
                case FinalCanbus.CAR_RZC_Nissan_Xtrail_Import_22_H /* 2490558 */:
                case FinalCanbus.CAR_WC2_GM_MalibuXL_16_18 /* 2555940 */:
                case FinalCanbus.CAR_RZC_Nissan_Tuda_18 /* 2556094 */:
                case FinalCanbus.CAR_WC2_GM_MalibuXL_19 /* 2621476 */:
                case FinalCanbus.CAR_RZC_Nissan_Tuda_18_H /* 2621630 */:
                case FinalCanbus.CAR_RZC_Mustang_15_NO_CD /* 2621774 */:
                case FinalCanbus.CAR_WC2_GM_Equinox_17 /* 2687012 */:
                case FinalCanbus.CAR_RZC_Nissan_NAVANA_16 /* 2687166 */:
                case FinalCanbus.CAR_WC2_GM_Sail3_15 /* 2752548 */:
                case FinalCanbus.CAR_RZC_Nissan_NAVANA_16_H /* 2752702 */:
                case FinalCanbus.CAR_RZC3_XianDai_19Palisade /* 2752959 */:
                case FinalCanbus.CAR_WC2_GM_Onix_16 /* 2818084 */:
                case FinalCanbus.CAR_RZC_Nissan_SENTRA_18_Import /* 2818238 */:
                case FinalCanbus.CAR_RZC3_XianDai_19Palisade_H /* 2818495 */:
                case FinalCanbus.CAR_WC2_GM_LOVA_16_18 /* 2883620 */:
                case FinalCanbus.CAR_RZC_Nissan_SENTRA_18_Import_H /* 2883774 */:
                case FinalCanbus.CAR_RZC3_XianDai_20CARNIVAL /* 2884031 */:
                case FinalCanbus.CAR_WC2_GM_Excelle_15_18 /* 2949156 */:
                case FinalCanbus.CAR_RZC_Nissan_TITAN_19_Import /* 2949310 */:
                case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra /* 2949564 */:
                case FinalCanbus.CAR_RZC3_XianDai_20CARNIVAL_H /* 2949567 */:
                case FinalCanbus.CAR_WC2_GM_Monza_19 /* 3014692 */:
                case FinalCanbus.CAR_RZC_Nissan_TITAN_19_Import_H /* 3014846 */:
                case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra_H /* 3015100 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
                case FinalCanbus.CAR_WC2_GM_GL8_28T_ES /* 3080228 */:
                case FinalCanbus.CAR_RZC_Nissan_SENTRA_13_Import /* 3080382 */:
                case FinalCanbus.CAR_RZC_Ford_F150 /* 3080526 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
                case FinalCanbus.CAR_WC2_GM_GL8_20 /* 3145764 */:
                case FinalCanbus.CAR_RZC_Nissan_SENTRA_13_Import_H /* 3145918 */:
                case FinalCanbus.CAR_WC2_GM_Trax_19 /* 3211300 */:
                case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra_EV /* 3211708 */:
                case FinalCanbus.CAR_WC2_GM_Trailblazer_20 /* 3276836 */:
                case FinalCanbus.CAR_WC2_GM_S10_12 /* 3342372 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
                case FinalCanbus.CAR_WC2_GM_Karl_15 /* 3407908 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
                case FinalCanbus.CAR_WC2_GM_Encore_GX_20 /* 3473444 */:
                case FinalCanbus.CAR_454_Sanwu_Nissan_QX56_2004_Auto /* 3473862 */:
                case FinalCanbus.CAR_WC2_GM_Encore_20 /* 3538980 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_23Staria /* 3539391 */:
                case FinalCanbus.CAR_WC2_GM_CorsaE_14_19 /* 3604516 */:
                case FinalCanbus.CAR_RZC_Turkey_22KOLEOS_L /* 3604882 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_23Staria_H /* 3604927 */:
                case FinalCanbus.CAR_WC2_GM_Adam_13_19 /* 3670052 */:
                case FinalCanbus.CAR_RZC_Ford_Puma_22 /* 3670350 */:
                case FinalCanbus.CAR_RZC_Turkey_22KOLEOS_M /* 3670418 */:
                case FinalCanbus.CAR_WC2_GM_Insignia_17 /* 3735588 */:
                case FinalCanbus.CAR_RZC_Turkey_22KOLEOS_H /* 3735954 */:
                case FinalCanbus.CAR_WC2_GM_Sierra_14_18 /* 3801124 */:
                case FinalCanbus.CAR_RZC_Turkey_16KADJAR_L /* 3801490 */:
                case FinalCanbus.CAR_439_DJ_LEXUS_ES_H /* 3801527 */:
                case FinalCanbus.CAR_WC2_GM_Trailblazer_14_18 /* 3866660 */:
                case FinalCanbus.CAR_RZC_Turkey_16KADJAR_M /* 3867026 */:
                case FinalCanbus.CAR_WC2_GM_Suburban_15 /* 3932196 */:
                case FinalCanbus.CAR_RZC_Turkey_16KADJAR_H /* 3932562 */:
                case FinalCanbus.CAR_WC2_GM_Tahoe_16_18 /* 3997732 */:
                case FinalCanbus.CAR_RZC_Turkey_22CAPTUR_L /* 3998098 */:
                case FinalCanbus.CAR_WC2_GM_Colorado_18 /* 4063268 */:
                case FinalCanbus.CAR_RZC_Turkey_22CAPTUR_M /* 4063634 */:
                case FinalCanbus.CAR_WC2_GM_Kopach_12 /* 4128804 */:
                case FinalCanbus.CAR_RZC_Turkey_22CAPTUR_H /* 4129170 */:
                case FinalCanbus.CAR_WC2_OPEL_Meriva_10 /* 4194340 */:
                case FinalCanbus.CAR_RZC_Turkey_22TRAFIC_L /* 4194706 */:
                case FinalCanbus.CAR_WC2_GM_Onix_14 /* 4259876 */:
                case FinalCanbus.CAR_RZC_Turkey_22TRAFIC_M /* 4260242 */:
                case FinalCanbus.CAR_WC2_GM_Onix_19 /* 4325412 */:
                case FinalCanbus.CAR_RZC_Turkey_22TRAFIC_H /* 4325778 */:
                case FinalCanbus.CAR_WC2_GM_Montana_23 /* 4390948 */:
                case FinalCanbus.CAR_RZC_Turkey_22TALIANT_L /* 4391314 */:
                case FinalCanbus.CAR_WC2_GM_Tracker_19 /* 4456484 */:
                case FinalCanbus.CAR_RZC_Turkey_22TALIANT_M /* 4456850 */:
                case FinalCanbus.CAR_WC2_GM_Spin_Brazil_13 /* 4522020 */:
                case FinalCanbus.CAR_RZC_Turkey_22TALIANT_H /* 4522386 */:
                case FinalCanbus.CAR_WC2_GM_S10_Brazil_10 /* 4587556 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_JOGGER_L /* 4587922 */:
                case FinalCanbus.CAR_WC2_GM_EQUINOX_22 /* 4653092 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_JOGGER_M /* 4653458 */:
                case FinalCanbus.CAR_WC2_GM_EQUINOX_22_H /* 4718628 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_JOGGER_H /* 4718994 */:
                case FinalCanbus.CAR_WC2_GM_Colorado_14 /* 4784164 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_SANDERO_L /* 4784530 */:
                case FinalCanbus.CAR_WC2_GM_Colorado_14_H /* 4849700 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_SANDERO_M /* 4850066 */:
                case FinalCanbus.CAR_WC2_GM_Silverado_07 /* 4915236 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_SANDERO_H /* 4915602 */:
                case FinalCanbus.CAR_WC2_GM_Silverado_14 /* 4980772 */:
                case FinalCanbus.CAR_RZC_Turkey_23MEGANE4_L /* 4981138 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
                case FinalCanbus.CAR_452_DJ_Dodge_JCUV /* 4981188 */:
                case FinalCanbus.CAR_WC2_GM_Silverado_14_H /* 5046308 */:
                case FinalCanbus.CAR_RZC_Turkey_23MEGANE4_M /* 5046674 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
                case FinalCanbus.CAR_WC2_GM_Canyon_14 /* 5111844 */:
                case FinalCanbus.CAR_RZC_Turkey_23MEGANE4_H /* 5112210 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
                case FinalCanbus.CAR_WC2_GM_Canyon_14_H /* 5177380 */:
                case FinalCanbus.CAR_RZC_Turkey_22TALISMAN_L /* 5177746 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
                case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11 /* 5177797 */:
                case FinalCanbus.CAR_WC2_GMC_Acadia_07 /* 5242916 */:
                case FinalCanbus.CAR_RZC_Turkey_22TALISMAN_M /* 5243282 */:
                case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_18 /* 5243333 */:
                case FinalCanbus.CAR_WC2_GMC_Yukon_07 /* 5308452 */:
                case FinalCanbus.CAR_RZC_Turkey_22TALISMAN_H /* 5308818 */:
                case FinalCanbus.CAR_453_LZ_NISSAN_patrol /* 5308869 */:
                case FinalCanbus.CAR_WC2_GMC_Savana_08 /* 5373988 */:
                case FinalCanbus.CAR_RZC_Mustang_M /* 5374286 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_DUSTER_L /* 5374354 */:
                case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX60 /* 5374405 */:
                case FinalCanbus.CAR_WC2_GMC_Sierra_07 /* 5439524 */:
                case FinalCanbus.CAR_RZC_Mustang_H /* 5439822 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_DUSTER_M /* 5439890 */:
                case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX80 /* 5439941 */:
                case FinalCanbus.CAR_WC2_GMC_Sierra_14 /* 5505060 */:
                case FinalCanbus.CAR_RZC_Mustang_NOCD_M /* 5505358 */:
                case FinalCanbus.CAR_RZC_Turkey_22DACIA_DUSTER_H /* 5505426 */:
                case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX56 /* 5505477 */:
                case FinalCanbus.CAR_WC2_GMC_Sierra_14_H /* 5570596 */:
                case FinalCanbus.CAR_RZC_Mustang_NOCD_H /* 5570894 */:
                case FinalCanbus.CAR_RZC_Turkey_22EXPRESS_L /* 5570962 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                case FinalCanbus.CAR_WC2_GM_ExpressVan_08 /* 5636132 */:
                case FinalCanbus.CAR_RZC_Ford_Puma_22_M /* 5636430 */:
                case FinalCanbus.CAR_RZC_Turkey_22EXPRESS_M /* 5636498 */:
                case FinalCanbus.CAR_WC2_GM_Impala_06 /* 5701668 */:
                case FinalCanbus.CAR_RZC_Ford_Puma_22_H /* 5701966 */:
                case FinalCanbus.CAR_RZC_Turkey_22EXPRESS_H /* 5702034 */:
                case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9 /* 5702084 */:
                case FinalCanbus.CAR_WC2_GM_Avalanch_07 /* 5767204 */:
                case FinalCanbus.CAR_RZC_Russian_20ARKANA_L /* 5767570 */:
                case FinalCanbus.CAR_RZC_Russian_20ARKANA_M /* 5833106 */:
                case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_Auto /* 5833156 */:
                case FinalCanbus.CAR_RZC_Russian_20ARKANA_H /* 5898642 */:
                case FinalCanbus.CAR_452_LZ_TATA_ALL /* 5898692 */:
                case FinalCanbus.CAR_RZC_Turkey_22KADJAR_M /* 5964178 */:
                case FinalCanbus.CAR_RZC_CLIO5_Turkey_L_ATUO /* 6029714 */:
                case FinalCanbus.CAR_453_RZC_LandRover_Discovery_19 /* 6160837 */:
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
                case FinalCanbus.CAR_443_WC2_Ford_EDGE_11 /* 6685115 */:
                case FinalCanbus.CAR_452_XC_Ford_Mondeo_13_18 /* 6685124 */:
                case FinalCanbus.CAR_RZC_Renault_Dokker_18 /* 6750610 */:
                case FinalCanbus.CAR_443_WC2_Ford_EDGE_11_CD /* 6750651 */:
                case FinalCanbus.CAR_RZC_Renault_Dokker_18_H /* 6816146 */:
                case FinalCanbus.CAR_439_HC_Ruijie /* 6816183 */:
                case FinalCanbus.CAR_439_HC_Ruijie_H /* 6881719 */:
                case FinalCanbus.CAR_454_LZ_GM_Camaro_17_Auto /* 6947270 */:
                case FinalCanbus.CAR_454_LZ_GM_Equinox_17_Auto /* 7012806 */:
                case FinalCanbus.CAR_RZC_HavalH6Couple_BLUE_TOP /* 7078327 */:
                case FinalCanbus.CAR_RZC_HavalH6Couple_RED_TOP /* 7143863 */:
                case FinalCanbus.CAR_452_RZC_Subaru /* 7209412 */:
                case FinalCanbus.CAR_454_OD_Xinte_DEV1_H /* 7274950 */:
                case FinalCanbus.CAR_454_RZC_Racing_EC75_23 /* 7340486 */:
                case FinalCanbus.CAR_RZC_XP1_HavalH6Couple_19 /* 7602615 */:
                case FinalCanbus.CAR_452_OD_HZ_Nezha /* 7602628 */:
                case FinalCanbus.CAR_BNR_02_09Toyato_Prado /* 7668151 */:
                case FinalCanbus.CAR_BNR_02_09Toyato_Prado_H /* 7733687 */:
                case FinalCanbus.CAR_453_LZ_ALFA_ROMEO /* 7930309 */:
                case FinalCanbus.CAR_454_RZC_Suburu_OUTBACK_18 /* 8323526 */:
                case FinalCanbus.CAR_454_OD_Dongfeng_Racing_EC75_23 /* 8454598 */:
                case FinalCanbus.CAR_439_RZC_Nissan_19Qida /* 8585655 */:
                case FinalCanbus.CAR_439_RZC_Nissan_19Qida_H /* 8651191 */:
                case FinalCanbus.CAR_453_LZ_Jili_Boyue_18 /* 8782277 */:
                case FinalCanbus.CAR_453_LZ_Jili_Boyue_18_H /* 8847813 */:
                case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD /* 8913349 */:
                case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD_H /* 8978885 */:
                case FinalCanbus.CAR_454_LZ_Nissan_05_Cima /* 9044422 */:
                case FinalCanbus.CAR_454_RZC_LandRover_Discovery_04 /* 9765318 */:
                case FinalCanbus.CAR_454_OD_Qichen_D60_EV /* 9961926 */:
                case FinalCanbus.CAR_454_RZC_Shanqi_DelongG2 /* 10027462 */:
                case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_EV /* 10355140 */:
                case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport /* 10420678 */:
                case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport_H /* 10486214 */:
                case FinalCanbus.CAR_452_KYC_Zhonghua_All /* 10617284 */:
                case FinalCanbus.CAR_454_OD_Dongfeng_Nami01 /* 10617286 */:
                case FinalCanbus.CAR_452_KYC_Zhonghua_All_H /* 10682820 */:
                case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7 /* 10748356 */:
                case FinalCanbus.CAR_454_OD_Yiqi_Jiefang_J6G_23 /* 10748358 */:
                case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7_H /* 10813892 */:
                case FinalCanbus.CAR_454_OD_Yiqi_Jiefang_J7_23 /* 10813894 */:
                case FinalCanbus.CAR_439_RZC_Haval_18_19H6 /* 11272631 */:
                case FinalCanbus.CAR_454_OD_Yutong_Qingka /* 11338182 */:
                case FinalCanbus.CAR_454_OD_Dongfeng_Tianlong /* 11403718 */:
                case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
                case FinalCanbus.CAR_454_LZ_Chevrolet_Silverado_19_Screen /* 11993542 */:
                case FinalCanbus.CAR_439_LZ_INFINIT_FX35 /* 12714423 */:
                case FinalCanbus.CAR_452_OD_LeiDing_Mangguo_L /* 13107652 */:
                case FinalCanbus.CAR_452_OD_LeiDing_Mangguo_H /* 13173188 */:
                case FinalCanbus.CAR_454_KYC_Ford_Mustang_07_H /* 13631942 */:
                case FinalCanbus.CAR_454_KYC_Ford_Mustang_07_L /* 13697478 */:
                case FinalCanbus.CAR_452_OD_ChangCheng_Fengjun5 /* 13763012 */:
                case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_L /* 13763014 */:
                case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_H /* 13828550 */:
                case FinalCanbus.CAR_439_DJ_Rongwei_i5 /* 13959607 */:
                case FinalCanbus.CAR_439_DJ_Rongwei_i5_H /* 14025143 */:
                case FinalCanbus.CAR_454_OD_ChangAn_Raeton /* 14352838 */:
                case FinalCanbus.CAR_454_OD_ChangAn_Raeton_H /* 14418374 */:
                case FinalCanbus.CAR_454_LZ_Nissan_370Z_H /* 14746054 */:
                case FinalCanbus.CAR_443_WC2_XianDai_All_18OPTIMA /* 15073723 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha /* 15204806 */:
                case FinalCanbus.CAR_439_HC_Ford_Explorer /* 15335863 */:
                case FinalCanbus.CAR_443_WC2_Ford_F150_18 /* 15401403 */:
                case FinalCanbus.CAR_443_WC2_Ford_F150_18_CD /* 15466939 */:
                case FinalCanbus.CAR_454_CZH_OUDI_BYD_ALL /* 15663558 */:
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
                case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport_Top /* 16056774 */:
                case FinalCanbus.CAR_443_WC2_Ford_F350_18_M /* 16122299 */:
                case FinalCanbus.CAR_443_WC2_Ford_F350_18_H /* 16187835 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha_3 /* 16187846 */:
                case FinalCanbus.CAR_443_WC2_Ford_Mustang_18_L /* 16253371 */:
                case FinalCanbus.CAR_443_WC2_Ford_Mustang_18_M /* 16318907 */:
                case FinalCanbus.CAR_443_WC2_Ford_Mustang_18_H /* 16384443 */:
                case FinalCanbus.CAR_454_LZ_Honda_AoDeSai_04 /* 16449990 */:
                    if (!Air_Activity_All_NewAdd_HP.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.air.Air_Activity_All_NewAdd_HP");
                        break;
                    } else if (Air_Activity_All_NewAdd_HP.mInstance != null) {
                        Air_Activity_All_NewAdd_HP.mInstance.finish();
                        break;
                    }
                case 118:
                case 122:
                case 185:
                case 281:
                case FinalCanbus.CAR_WC2_408_14_M /* 65658 */:
                case FinalCanbus.CAR_WC2_408_14_H /* 131194 */:
                case FinalCanbus.CAR_XP1_PsaAll_AutoPark /* 262425 */:
                    if (!BZ408AirControlActi.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.biaozhi408.BZ408AirControlActi");
                        break;
                    }
                case 151:
                case FinalCanbus.CAR_DAOJUN_XP1_BYDSurui /* 458903 */:
                case FinalCanbus.CAR_RCW_BYD_6 /* 524439 */:
                case FinalCanbus.CAR_RCW_BYD_12_18Surui /* 589975 */:
                    if (!Activity_DaojunAirCrtrlBydS6.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.byd.hcy.Activity_DaojunAirCrtrlBydS6");
                        break;
                    }
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
                    if (!AirControlMQB_RZC_Front.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.golf7.AirControlMQB_RZC_Front");
                        break;
                    }
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
                    if (!Air_Activity_All_NewAdd_HP.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.air.Air_Activity_All_NewAdd_HP");
                        break;
                    } else if (Air_Activity_All_NewAdd_HP.mInstance != null) {
                        Air_Activity_All_NewAdd_HP.mInstance.finish();
                        break;
                    }
                case 265:
                    if (!RzcChanganAirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.rzc.zhongtai.RzcChanganAirControlAct");
                        break;
                    }
                case 300:
                    if (!RJ_GC_AirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.ruijie15.RJ_GC_AirControlAct");
                        break;
                    }
                case 313:
                    if (!Sbd_AirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.sbd_electric.Sbd_AirControlAct");
                        break;
                    }
                case 317:
                case FinalCanbus.CAR_WeiChi2_XTS /* 65853 */:
                case FinalCanbus.CAR_WeiChi2_ATS_H /* 196925 */:
                case FinalCanbus.CAR_WeiChi2_18XTS /* 393533 */:
                case FinalCanbus.CAR_WeiChi2_18ATS /* 459069 */:
                    if (!WcATSAirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.daojun.kaidilake.WcATSAirControlAct");
                        break;
                    }
                case 332:
                    if (!SO3AirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.saiou3.SO3AirControlAct");
                        break;
                    }
                case 348:
                case FinalCanbus.CAR_DAOJUN_XP1_ATSL_Lo /* 262492 */:
                case FinalCanbus.CAR_DAOJUN_XP1_ATSL_Lowest /* 393564 */:
                case FinalCanbus.CAR_DAOJUN_OD_ATS /* 852316 */:
                    if (LauncherApplication.getConfiguration() != 1) {
                        if (!Air_Activity_All_NewAdd_HP.mIsFront) {
                            JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.air.Air_Activity_All_NewAdd_HP");
                            break;
                        } else if (Air_Activity_All_NewAdd_HP.mInstance != null) {
                            Air_Activity_All_NewAdd_HP.mInstance.finish();
                            break;
                        }
                    } else if (!djATSAirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.daojun.kaidilake.djATSAirControlAct");
                        break;
                    }
                case 357:
                    if (!MrbAirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.klc.MrbAirControlAct");
                        break;
                    }
                case 359:
                case FinalCanbus.CAR_XP1_MaiRuiBao16_M /* 65895 */:
                case FinalCanbus.CAR_XP1_MaiRuiBao16_H /* 131431 */:
                case FinalCanbus.CAR_XP1_MaiRuiBao16_XL_L /* 196967 */:
                case FinalCanbus.CAR_XP1_MaiRuiBao16_XL_H /* 262503 */:
                    if (!XpMrbAirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.yinglang.XpMrbAirControlAct");
                        break;
                    }
                case 365:
                case FinalCanbus.CAR_AY1_JeepZiYouGuang_M /* 65901 */:
                case FinalCanbus.CAR_AY1_JeepZiYouGuang_H /* 131437 */:
                    if (!JeepCarAirSet.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.aiying.ziyouguang.JeepCarAirSet");
                        break;
                    }
                case 371:
                case FinalCanbus.CAR_BoGoo_XP1_Jeep15ZiYouGuang_M /* 65907 */:
                case FinalCanbus.CAR_BoGoo_XP1_Jeep15ZiYouGuang_H /* 131443 */:
                    if (!Bg_ZiYouGuangAirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.bg.ziyouguang.Bg_ZiYouGuangAirControlAct");
                        break;
                    }
                case 379:
                case FinalCanbus.CAR_BNR_XP1_JunWei /* 459131 */:
                case FinalCanbus.CAR_BNR_XP1_New_KLZ /* 524667 */:
                case FinalCanbus.CAR_BNR_XP1_Mairuibao_L /* 590203 */:
                case FinalCanbus.CAR_BNR_XP1_Mairuibao_H /* 655739 */:
                case FinalCanbus.CAR_BNR_XP1_JunWei_L /* 721275 */:
                case FinalCanbus.CAR_BNR_XP1_JunWei_H /* 786811 */:
                case FinalCanbus.CAR_BNR_XP1_SRX_L /* 852347 */:
                case FinalCanbus.CAR_BNR_XP1_SRX_H /* 917883 */:
                case FinalCanbus.CAR_BNR_XP1_New_YingLang_L /* 983419 */:
                case FinalCanbus.CAR_BNR_XP1_New_YingLang_H /* 1048955 */:
                case FinalCanbus.CAR_BNR_XP1_New_GL8_ES_L /* 1114491 */:
                case FinalCanbus.CAR_BNR_XP1_New_GL8_ES_H /* 1180027 */:
                case FinalCanbus.CAR_BNR_XP1_WeiLang_L /* 1245563 */:
                case FinalCanbus.CAR_BNR_XP1_WeiLang_H /* 1311099 */:
                case FinalCanbus.CAR_BNR_XP1_YingLang_L /* 1376635 */:
                case FinalCanbus.CAR_BNR_XP1_YingLang_H /* 1442171 */:
                case FinalCanbus.CAR_BNR_XP1_CTS_L /* 1507707 */:
                case FinalCanbus.CAR_BNR_XP1_CTS_H /* 1573243 */:
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
                    if (!YLAirControlAct_BNR.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.yinglang.YLAirControlAct_BNR");
                        break;
                    }
                case 395:
                case FinalCanbus.CAR_WC2_GUOCHAN_14 /* 917899 */:
                case FinalCanbus.CAR_WC2_GUOCHAN_15 /* 983435 */:
                case FinalCanbus.CAR_WC2_AiRuiZ_GX /* 1835403 */:
                case FinalCanbus.CAR_WC2_GUOCHAN_Ruihu5X /* 2097547 */:
                    if (!ActivityRuiHu7.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.qirui.ActivityRuiHu7");
                        break;
                    }
                case 420:
                case FinalCanbus.CAR_WC2_ToYoTa_10_Crown_LOW /* 131492 */:
                case FinalCanbus.CAR_WC2_ToYoTa_10_Crown_ALL /* 197028 */:
                case FinalCanbus.CAR_WC2_ToYoTa_10_Crown_RADIO /* 262564 */:
                case FinalCanbus.CAR_WC2_ToYoTa_10_Crown_NoAmp /* 328100 */:
                case FinalCanbus.CAR_WC2_ToYoTa_13_Crown_H /* 393636 */:
                case FinalCanbus.CAR_WC2_ToYoTa_Lexus_05LX470 /* 459172 */:
                case FinalCanbus.CAR_WC2_ToYoTa_Lexus_08RX300 /* 524708 */:
                case FinalCanbus.CAR_WC2_ToYoTa_Lexus_08RX350 /* 590244 */:
                case FinalCanbus.CAR_WC2_ToYoTa_Prodo_10 /* 655780 */:
                case FinalCanbus.CAR_WC2_ToYoTa_Lexus_09IS_Low /* 721316 */:
                case FinalCanbus.CAR_WC2_ToYoTa_Lexus_06LS460 /* 786852 */:
                case FinalCanbus.CAR_WC2_ToYoTa_Lexus_NX_SCREEN /* 852388 */:
                    if (!wc_420_crown_AirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.crown.wc_420_crown_AirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_WC2_17MaiTeng /* 65553 */:
                case FinalCanbus.CAR_WC2_17MaiTeng_H /* 131089 */:
                case FinalCanbus.CAR_WC2_TuGuanL /* 196625 */:
                case FinalCanbus.CAR_WC2_17KeDiYaKe /* 262161 */:
                case FinalCanbus.CAR_WC2_17TuAng /* 327697 */:
                case FinalCanbus.CAR_WC2_MQB /* 589841 */:
                case FinalCanbus.CAR_WC2_MQB_Hybrid /* 655377 */:
                case FinalCanbus.CAR_WC2_MQB_AllView /* 720913 */:
                case FinalCanbus.CAR_WC2_MQB_Golf_Sportsvan_16 /* 786449 */:
                case FinalCanbus.CAR_WC2_MQB_Passat_17_18 /* 851985 */:
                case FinalCanbus.CAR_WC2_MQB_Passat_19 /* 917521 */:
                case FinalCanbus.CAR_WC2_MQB_Variant_16_18 /* 983057 */:
                case FinalCanbus.CAR_WC2_MQB_Bora_19 /* 1048593 */:
                case FinalCanbus.CAR_WC2_MQB_CC_19 /* 1114129 */:
                case FinalCanbus.CAR_WC2_MQB_Polo_19 /* 1179665 */:
                case FinalCanbus.CAR_WC2_MQB_Jetta_Brazil /* 1245201 */:
                case FinalCanbus.CAR_WC2_MQB_TIGUANL_17_20 /* 1310737 */:
                case FinalCanbus.CAR_WC2_MQB_TIGUANL_17_20_H /* 1376273 */:
                case FinalCanbus.CAR_WC2_MQB_Octavia_13_14 /* 1441809 */:
                case FinalCanbus.CAR_WC2_MQB_Octavia_15_19 /* 1507345 */:
                case FinalCanbus.CAR_WC2_MQB_Superb_16_18 /* 1572881 */:
                case FinalCanbus.CAR_WC2_MQB_KAMIQ_18 /* 1638417 */:
                case FinalCanbus.CAR_WC2_MQB_KAROQ_18_19 /* 1703953 */:
                case FinalCanbus.CAR_WC2_MQB_Caravelle_14_18 /* 1769489 */:
                case FinalCanbus.CAR_WC2_MQB_Jetta_VS5_19 /* 1835025 */:
                case FinalCanbus.CAR_WC2_MQB_Lavida_plus_19 /* 1900561 */:
                case FinalCanbus.CAR_WC2_MQB_Sagitar_19 /* 1966097 */:
                case FinalCanbus.CAR_WC2_MQB_Tharu_19 /* 2031633 */:
                case FinalCanbus.CAR_WC2_MQB_T_Cross_19 /* 2097169 */:
                case FinalCanbus.CAR_WC2_MQB_TouranL_16_18 /* 2162705 */:
                case FinalCanbus.CAR_WC2_MQB_Trek_17_18 /* 2228241 */:
                case FinalCanbus.CAR_WC2_MQB_Tange_19 /* 2293777 */:
                case FinalCanbus.CAR_WC2_MQB_Tayron_19 /* 2359313 */:
                case FinalCanbus.CAR_WC2_MQB_Multivan_19 /* 2424849 */:
                case FinalCanbus.CAR_WC2_MQB_Superb_Turkey /* 2490385 */:
                case FinalCanbus.CAR_WC2_MQB_Huiang_21 /* 2555921 */:
                case FinalCanbus.CAR_WC2_MQB_Viloran_20 /* 2621457 */:
                case FinalCanbus.CAR_WC2_MQB_Jetta_VS7_20 /* 2686993 */:
                case FinalCanbus.CAR_WC2_MQB_Tayron_GTE_20 /* 2752529 */:
                case FinalCanbus.CAR_WC2_MQB_Golf8_21 /* 2818065 */:
                    if (!AirControlMQB_WC_Front.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.golf7.AirControlMQB_WC_Front");
                        break;
                    }
                case FinalCanbus.CAR_DJ_ChuanQiGA6_M /* 65793 */:
                case FinalCanbus.CAR_DJ_ChuanQiGA6_H /* 131329 */:
                    if (!GA6AirSeatControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.dongjian.ga6.GA6AirSeatControlAct");
                        break;
                    }
                case FinalCanbus.CAR_SBD_WC1_24vW3 /* 65849 */:
                    if (!Sbd_24vW3AirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.sbd_electric.Sbd_24vW3AirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
                case FinalCanbus.CAR_DAOJUN_XP1_XTS /* 131420 */:
                case FinalCanbus.CAR_DAOJUN_XP1_XTS_M /* 196956 */:
                case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
                case FinalCanbus.CAR_DAOJUN_XP1_17XTS /* 459100 */:
                case FinalCanbus.CAR_DAOJUN_XP1_17XTS_M /* 524636 */:
                case FinalCanbus.CAR_DAOJUN_18ATS_Auto /* 590172 */:
                case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
                case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
                case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
                    if (LauncherApplication.getConfiguration() != 1) {
                        if (!Air_Activity_All_NewAdd_HP.mIsFront) {
                            JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.air.Air_Activity_All_NewAdd_HP");
                            break;
                        } else if (Air_Activity_All_NewAdd_HP.mInstance != null) {
                            Air_Activity_All_NewAdd_HP.mInstance.finish();
                            break;
                        }
                    } else if (!djXTSAirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.daojun.kaidilake.djXTSAirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_DJ_SHA_BUS /* 65944 */:
                    if (!ActivityBusAirControl.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.bus.ActivityBusAirControl");
                        break;
                    }
                case FinalCanbus.CAR_452_XC_Tianlai_GJ /* 65988 */:
                case FinalCanbus.CAR_453_XC_Tianlai_GJ /* 1442245 */:
                case FinalCanbus.CAR_439_HC_Nissan_GuiShi /* 7799223 */:
                    if (!ActivityTianLaiFrontAirSetting.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.hc.tianlai.ActivityTianLaiFrontAirSetting");
                        break;
                    }
                case FinalCanbus.CAR_RZC_XP1_YuanJingX6 /* 131211 */:
                    if (LauncherApplication.getConfiguration() != 1) {
                        if (!Air_Activity_All_Toyota_prado_HP.mIsFront) {
                            JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.air.Air_Activity_All_Toyota_prado_HP");
                            break;
                        }
                    } else if (!YuanJingX1AirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.jili.YuanJingX1AirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_WC2_DaZhong_TuRui /* 131342 */:
                case FinalCanbus.CAR_HSY_WC2_DaZhong_TuRui /* 196878 */:
                case FinalCanbus.CAR_LZ_WC2_DaZhong_TuRui /* 262414 */:
                case FinalCanbus.CAR_XC_WC2_DaZhong_TuRui /* 327950 */:
                    if (!TuRui_AirActi.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.dasauto.TuRui_AirActi");
                        break;
                    }
                case FinalCanbus.CAR_WeiChi2_XTS_SEATHEAT /* 131389 */:
                case FinalCanbus.CAR_WeiChi2_SRX /* 262461 */:
                case FinalCanbus.CAR_WeiChi2_15SRX /* 327997 */:
                    if (!WcXTSAirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.daojun.kaidilake.WcXTSAirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_455_LZ_Toyota_Alpha_DH_2 /* 131527 */:
                case FinalCanbus.CAR_455_LZ_Toyota_Alpha_DH_3 /* 197063 */:
                    if (!LuzDaoHangToyotaAlphaAirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.lz.lexusis.LuzDaoHangToyotaAlphaAirControlAct");
                        break;
                    } else if (LuzDaoHangToyotaAlphaAirControlAct.mInstance != null) {
                        LuzDaoHangToyotaAlphaAirControlAct.mInstance.finish();
                        break;
                    }
                case FinalCanbus.CAR_DJ_ShuPing_BYD_G6 /* 196759 */:
                case FinalCanbus.CAR_DJ_ShuPing_BYD_G6_H /* 262295 */:
                    if (!Activity_DaojunAirCrtrlBydG6.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.byd.hcy.Activity_DaojunAirCrtrlBydG6");
                        break;
                    }
                case FinalCanbus.CAR_RZC_16BoYue /* 196873 */:
                case FinalCanbus.CAR_BNR_BoYue /* 459017 */:
                case FinalCanbus.CAR_BNR_BoYue_H /* 786697 */:
                    if (!BoyueAirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.jili.BoyueAirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_XP1_2016SIYU /* 196906 */:
                case FinalCanbus.CAR_XP1_2016SIYU_H /* 262442 */:
                case FinalCanbus.CAR_WC2_Honda_AllCom_CIVIC /* 262465 */:
                case FinalCanbus.CAR_RZC_XP1_17CRV /* 786730 */:
                case FinalCanbus.CAR_XP1_17CRV /* 852266 */:
                case FinalCanbus.CAR_RZC_XP1_17CRV_H /* 917802 */:
                case FinalCanbus.CAR_RZC_HONDA_19Xiangyu /* 1311018 */:
                case FinalCanbus.CAR_RZC_HONDA_20Haoying /* 1835306 */:
                case FinalCanbus.CAR_RZC_HONDA_20Haoying_H /* 1900842 */:
                case FinalCanbus.CAR_RZC_HONDA_21Haoying /* 2425130 */:
                case FinalCanbus.CAR_RZC_HONDA_21CRV /* 2490666 */:
                case FinalCanbus.CAR_RZC_HONDA_2022SIYU /* 2687274 */:
                case FinalCanbus.CAR_RZC_HONDA_2022Lingpai /* 2752810 */:
                case FinalCanbus.CAR_RZC_XP1_2016SIYU /* 2818346 */:
                case FinalCanbus.CAR_RZC_XP1_2016SIYU_H /* 2883882 */:
                case FinalCanbus.CAR_RZC_XP1_22ZRV /* 3211562 */:
                case FinalCanbus.CAR_RZC_XP1_22ZRV_H /* 3277098 */:
                case FinalCanbus.CAR_RZC_HONDA_23StepWGN /* 4981034 */:
                case FinalCanbus.CAR_RZC_HONDA_21StepWGN /* 5046570 */:
                case FinalCanbus.CAR_RZC_HONDA_23HRV /* 5112106 */:
                case FinalCanbus.CAR_RZC_HONDA_23BRV /* 5177642 */:
                case FinalCanbus.CAR_RZC_HONDA_19NBox /* 5243178 */:
                case FinalCanbus.CAR_RZC_HONDA_19Freed /* 5308714 */:
                case FinalCanbus.CAR_RZC_HONDA_22CRV_EV /* 5898538 */:
                case FinalCanbus.CAR_RZC_HONDA_22CRV_EV_H /* 5964074 */:
                case FinalCanbus.CAR_RZC_HONDA_22Haoying_EV /* 6029610 */:
                case FinalCanbus.CAR_RZC_HONDA_22Haoying_EV_H /* 6095146 */:
                case FinalCanbus.CAR_RZC_HONDA_24Aodesai /* 6160682 */:
                case FinalCanbus.CAR_RZC_HONDA_24Aodesai_H /* 6226218 */:
                case FinalCanbus.CAR_RZC_HONDA_18Pilot /* 6291754 */:
                case FinalCanbus.CAR_RZC_HONDA_18Pilot_H /* 6357290 */:
                case FinalCanbus.CAR_RZC_HONDA_22CRV_CEV /* 6750506 */:
                case FinalCanbus.CAR_RZC_HONDA_22CRV_CEV_H /* 6816042 */:
                case FinalCanbus.CAR_RZC_HONDA_22Haoying_CEV /* 6881578 */:
                case FinalCanbus.CAR_RZC_HONDA_22Haoying_CEV_H /* 6947114 */:
                    if (!ActivityAirControl.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.honda.ActivityAirControl");
                        break;
                    }
                case FinalCanbus.CAR_RZC_15Ruijie /* 196942 */:
                case FinalCanbus.CAR_RZC_Jinniu2018 /* 393550 */:
                case FinalCanbus.CAR_RZC_Lingjie2019 /* 459086 */:
                case FinalCanbus.CAR_RZC_Escape_20 /* 917838 */:
                case FinalCanbus.CAR_RZC_Lingjie2019_M /* 1179982 */:
                case FinalCanbus.CAR_RZC_Lingjie2019_H /* 1245518 */:
                case FinalCanbus.CAR_RZC_Ford_18Everest_FLB /* 1376590 */:
                case FinalCanbus.CAR_RZC_Ford_18Everest_FLB_H /* 1442126 */:
                case FinalCanbus.CAR_RZC_Ford_Everest_SUV_Low1 /* 1507662 */:
                case FinalCanbus.CAR_RZC_Ford_Everest_SUV_Low2 /* 1573198 */:
                case FinalCanbus.CAR_RZC_Ford_Everest_PickUP_Low /* 1638734 */:
                case FinalCanbus.CAR_RZC_Ford_Everest_PickUP_H /* 1704270 */:
                case FinalCanbus.CAR_RZC_15Ruijie_CD /* 3146062 */:
                case FinalCanbus.CAR_RZC_Ford_Ranger_15_Vietnam /* 3735886 */:
                case FinalCanbus.CAR_RZC_Ford_Ranger_20_Turkey /* 3801422 */:
                case FinalCanbus.CAR_RZC_Jinniu2019_M /* 4718926 */:
                case FinalCanbus.CAR_RZC_Jinniu2019_H /* 4784462 */:
                    if (LauncherApplication.getConfiguration() == 1) {
                        if (!RZCRuijieFrontAirControlAct_SP.mIsFront) {
                            JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.ruijie15.RZCRuijieFrontAirControlAct_SP");
                            break;
                        }
                    } else if (!RuijieAirControlAct_Rzc.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.ruijie15.RuijieAirControlAct_Rzc");
                        break;
                    }
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
                    if (!WCYuncheNissanAirControlAct.mIsFront) {
                        ConstAllAirDara.JumpNewAir = true;
                        ConstAllAirDara.JumpNewAircnt = 8;
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.ziyouguang.WCYuncheNissanAirControlAct");
                        break;
                    } else if (WCYuncheNissanAirControlAct.mInstance != null) {
                        WCYuncheNissanAirControlAct.mInstance.finish();
                        break;
                    }
                case FinalCanbus.CAR_RZC_XP1_ChuanQiGS8 /* 262424 */:
                case FinalCanbus.CAR_RZC_XP1_ChuanQiGS8_H /* 524568 */:
                case FinalCanbus.CAR_RZC_ChuanQiGS8_19 /* 1245464 */:
                case FinalCanbus.CAR_RZC_XP1_ChuanQiGM8_20 /* 1573144 */:
                case FinalCanbus.CAR_RZC_ChuanQiGS8_20 /* 1835288 */:
                case FinalCanbus.CAR_RZC_XP1_ChuanQiM8_21 /* 2162968 */:
                    if (!Rzc_Gs8_AirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.rzc.gs4.Rzc_Gs8_AirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_RZC_ZhiSheng_Old /* 262478 */:
                    if (!ActivityAirCrtrRZCFordMengdiou.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.byd.hcy.ActivityAirCrtrRZCFordMengdiou");
                        break;
                    }
                case FinalCanbus.CAR_OD_GaoErFu7 /* 327720 */:
                case FinalCanbus.CAR_WC2_17MaiTeng_DZSJ /* 393233 */:
                case FinalCanbus.CAR_OD_TuAnL /* 393256 */:
                case FinalCanbus.CAR_WC2_17MaiTeng_SOS_DZSJ /* 458769 */:
                    if (!AirControlMaiTengDZSJ.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.golf7.AirControlMaiTengDZSJ");
                        break;
                    }
                case FinalCanbus.CAR_LUZ_ZhongTaiT600 /* 327945 */:
                    if (!ZTAirAct_Luz.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.ztt600.ZTAirAct_Luz");
                        break;
                    }
                case FinalCanbus.CAR_RZC_XP1_QiChenT90 /* 327970 */:
                case FinalCanbus.CAR_RZC_XP1_QiChenD60 /* 393506 */:
                case FinalCanbus.CAR_RZC_XP1_QiChen18T70 /* 459042 */:
                case FinalCanbus.CAR_RZC_XP1_QiChen20T60 /* 590114 */:
                case FinalCanbus.CAR_RZC_XP1_QiChen20T70 /* 655650 */:
                case FinalCanbus.CAR_RZC_XP1_QiChen21T90 /* 721186 */:
                case FinalCanbus.CAR_CZH_RZC_QiChenD60 /* 852258 */:
                case FinalCanbus.CAR_CZH_RZC_QiChen18T70 /* 917794 */:
                    if (!AirRzcQiChenT90.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.rzc.t70.AirRzcQiChenT90");
                        break;
                    }
                case FinalCanbus.CAR_XP1_KeLeiAo_L /* 328054 */:
                case FinalCanbus.CAR_XP1_Meiganna4_TR_HAND /* 1245558 */:
                    if (!Act_Keleijia_Airset.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.leinuo.Act_Keleijia_Airset");
                        break;
                    }
                case FinalCanbus.CAR_SBD_Ford_LieYing /* 328078 */:
                    if (!AirSBDFordLieYing.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.sbd.fordlieying.AirSBDFordLieYing");
                        break;
                    }
                case FinalCanbus.CAR_438_DJ_YuanJingX1 /* 328118 */:
                    if (!YuanJingX1_AirControlAct_DJ.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.jili.YuanJingX1_AirControlAct_DJ");
                        break;
                    }
                case FinalCanbus.CAR_WC2_GM_GL8 /* 393252 */:
                    if (!KlcGl8AirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.klc.KlcGl8AirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_BNR_16CS75_L /* 393286 */:
                case FinalCanbus.CAR_BNR_16CS75_M /* 458822 */:
                case FinalCanbus.CAR_BNR_16CS75_H_RightCamera /* 524358 */:
                case FinalCanbus.CAR_BNR_16CS75_H_FullView /* 589894 */:
                case FinalCanbus.CAR_BNR_17CS75 /* 655430 */:
                    if (!BnrChanganCS75AirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.daojun.kaidilake.BnrChanganCS75AirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_BNR_ZhongTaiT600 /* 393481 */:
                    if (!ZTAirAct_Bnr.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.ztt600.ZTAirAct_Bnr");
                        break;
                    }
                case FinalCanbus.CAR_XP1_KeLeiAo_H /* 393590 */:
                case FinalCanbus.CAR_XP1_Meiganna4_TR_AUTO /* 1311094 */:
                case FinalCanbus.CAR_XP1_Meiganna4_TR_AUTO_H /* 1769846 */:
                    if (!Act_Keleijia_Airset_high.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.leinuo.Act_Keleijia_Airset_high");
                        break;
                    }
                case FinalCanbus.CAR_439_DJ_XP1_HuiTeng /* 393655 */:
                    if (LauncherApplication.getConfiguration() == 1) {
                        if (!Huiteng_AirRearCtrl.mIsFront) {
                            JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.huiteng.Huiteng_AirRearCtrl");
                            break;
                        }
                    } else if (!Huiteng_AirFrontCtrl.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.huiteng.Huiteng_AirFrontCtrl");
                        break;
                    }
                case FinalCanbus.CAR_RZC_XP1_ChuanQiGS3 /* 459032 */:
                case FinalCanbus.CAR_RZC_ChuanQiGS4_18 /* 590104 */:
                case FinalCanbus.CAR_RZC_ChuanQiGS4_18_O /* 655640 */:
                case FinalCanbus.CAR_RZC_ChuanQiGA4_18 /* 721176 */:
                case FinalCanbus.CAR_RZC_ChuanQiGE3_18 /* 786712 */:
                case FinalCanbus.CAR_RZC_ChuanQiGS4_19_O /* 1114392 */:
                case FinalCanbus.CAR_RZC_Qizhi_EV /* 1179928 */:
                case FinalCanbus.CAR_RZC_ChuanQiGM6_19 /* 1311000 */:
                case FinalCanbus.CAR_RZC_XP1_ChuanQiGS7 /* 1376536 */:
                case FinalCanbus.CAR_RZC_XP1_ChuanQiGS4_20 /* 1507608 */:
                case FinalCanbus.CAR_RZC_XP1_ChuanQiGS5_20 /* 1638680 */:
                case FinalCanbus.CAR_RZC_XP1_ChuanQiGS3_21 /* 1704216 */:
                case FinalCanbus.CAR_RZC_XP1_ChuanQiGS3_17_H /* 1769752 */:
                case FinalCanbus.CAR_RZC_XP1_ChuanQiGS4_20_EV /* 1966360 */:
                case FinalCanbus.CAR_RZC_XP1_ChuanQiGS4_22 /* 2031896 */:
                case FinalCanbus.CAR_RZC_OD_AION_EV /* 2228504 */:
                case FinalCanbus.CAR_RZC_XP1_ChuanQiGS4_TF /* 2294040 */:
                    if (!Rzc_Gs3_AirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.rzc.gs4.Rzc_Gs3_AirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_WC2_Honda_17CRV /* 459073 */:
                case FinalCanbus.CAR_WC2_Honda_17CRV_H /* 524609 */:
                case FinalCanbus.CAR_WC2_Honda_17CRV_M /* 590145 */:
                case FinalCanbus.CAR_WC2_Honda_AllCom_Top /* 983361 */:
                case FinalCanbus.CAR_WC2_Honda_15Aodesai_Tai /* 1048897 */:
                case FinalCanbus.CAR_WC2_Honda_18Aodesai_Tai /* 1114433 */:
                case FinalCanbus.CAR_WC2_Honda_19CRV /* 1179969 */:
                case FinalCanbus.CAR_WC2_Honda_19Lingpai /* 1245505 */:
                case FinalCanbus.CAR_WC2_Honda_19Xiangyu /* 1311041 */:
                case FinalCanbus.CAR_WC2_Honda_17Elysion /* 1376577 */:
                case FinalCanbus.CAR_WC2_Honda_15Aodesai_H /* 1507649 */:
                case FinalCanbus.CAR_WC2_Honda_18Aodesai_H /* 1573185 */:
                case FinalCanbus.CAR_WC2_Honda_19INSPIRE /* 2031937 */:
                case FinalCanbus.CAR_WC2_Honda_20EVERUS /* 2097473 */:
                case FinalCanbus.CAR_WC2_Honda_21CRV /* 2163009 */:
                case FinalCanbus.CAR_WC2_Honda_21BREEZE /* 2228545 */:
                case FinalCanbus.CAR_WC2_Honda_22CIVIC /* 2294081 */:
                case FinalCanbus.CAR_WC2_Honda_22Accord /* 2359617 */:
                case FinalCanbus.CAR_WC2_Honda_22CRIDER /* 2425153 */:
                case FinalCanbus.CAR_WC2_Honda_21Fit /* 2490689 */:
                case FinalCanbus.CAR_WC2_Honda_19Elysion /* 2556225 */:
                case FinalCanbus.CAR_WC2_Honda_15Aodesai_MH /* 2621761 */:
                case FinalCanbus.CAR_WC2_Honda_16Acura_CDX /* 2687297 */:
                case FinalCanbus.CAR_WC2_Honda_20Aodesai_H /* 2752833 */:
                case FinalCanbus.CAR_WC2_Honda_22STEP_WGN /* 2818369 */:
                case FinalCanbus.CAR_WC2_Honda_23XRV /* 2883905 */:
                case FinalCanbus.CAR_WC2_Honda_15Aodesai_T /* 2949441 */:
                case FinalCanbus.CAR_WC2_Honda_16CRV_OverSea_H /* 3080513 */:
                case FinalCanbus.CAR_WC2_Honda_16CRV_OverSea_L /* 3146049 */:
                case FinalCanbus.CAR_WC2_Honda_15_18Aodesai_H /* 3342657 */:
                case FinalCanbus.CAR_WC2_Honda_19Aodesai /* 3408193 */:
                case FinalCanbus.CAR_WC2_Honda_14Freed /* 3473729 */:
                case FinalCanbus.CAR_WC2_Honda_23Freed /* 3539265 */:
                case FinalCanbus.CAR_WC2_Honda_19CRV_H /* 4915521 */:
                case FinalCanbus.CAR_WC2_Honda_21CRV_H /* 5046593 */:
                case FinalCanbus.CAR_WC2_Honda_17Elysion_H /* 5112129 */:
                case FinalCanbus.CAR_WC2_Honda_19Elysion_H /* 5177665 */:
                case FinalCanbus.CAR_WC2_Honda_19Aodesai_H /* 5243201 */:
                case FinalCanbus.CAR_WC2_Honda_21BREEZE_H /* 5308737 */:
                case FinalCanbus.CAR_WC2_Honda_19INSPIRE_H /* 5374273 */:
                case FinalCanbus.CAR_WC2_Honda_22Accord_H /* 5439809 */:
                    if (!ActivityAirControl.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.honda.Activity17CRVAirControl");
                        break;
                    }
                case FinalCanbus.CAR_WC2_GUOCHAN_7 /* 459147 */:
                    if (!ActivityHaiMaV70AirControl.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.guochan.ActivityHaiMaV70AirControl");
                        break;
                    }
                case FinalCanbus.CAR_RZC_Explorer /* 590158 */:
                case FinalCanbus.CAR_RZC_Explorer_13 /* 3014990 */:
                    if (LauncherApplication.getConfiguration() == 1) {
                        if (!RZCRuijieFrontAirControlAct_SP.mIsFront) {
                            JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.ruijie15.RZCRuijieFrontAirControlAct_SP");
                            break;
                        }
                    } else if (!Air_Activity_All_NewAdd_HP.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.air.Air_Activity_All_NewAdd_HP");
                        break;
                    } else if (Air_Activity_All_NewAdd_HP.mInstance != null) {
                        Air_Activity_All_NewAdd_HP.mInstance.finish();
                        break;
                    }
                case FinalCanbus.CAR_BNR_ShuPing_12LandCruise /* 655757 */:
                case FinalCanbus.CAR_BNR_ShuPing_16LandCruise /* 721293 */:
                case FinalCanbus.CAR_BNR_ShuPing_12LandCruise_AMP /* 1507725 */:
                case FinalCanbus.CAR_BNR_ShuPing_16LandCruise_AMP /* 1573261 */:
                    if (!BnrToyatoKuluzAirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.cxw.k50.BnrToyatoKuluzAirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_453_PA_Ford_F150_10_CD /* 721349 */:
                case FinalCanbus.CAR_453_PA_Ford_Mustang_10_CD /* 5702085 */:
                case FinalCanbus.CAR_453_PA_Ford_Mustang_10 /* 5767621 */:
                case FinalCanbus.CAR_452_PA_Ford_F150_10 /* 15598020 */:
                    if (!PAFordF150AirControlAct_SP.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.ziyouguang.PAFordF150AirControlAct_SP");
                        break;
                    } else if (PAFordF150AirControlAct_SP.mInstance != null) {
                        PAFordF150AirControlAct_SP.mInstance.finish();
                        break;
                    }
                case FinalCanbus.CAR_WC2_GUOCHAN_13 /* 852363 */:
                    if (!ActivityBenTengB50.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.guochan.ActivityBenTengB50");
                        break;
                    }
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
                    if (LauncherApplication.getConfiguration() != 1) {
                        if (!Air_Activity_All_NewAdd_HP.mIsFront) {
                            JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.air.Air_Activity_All_NewAdd_HP");
                            break;
                        } else if (Air_Activity_All_NewAdd_HP.mInstance != null) {
                            Air_Activity_All_NewAdd_HP.mInstance.finish();
                            break;
                        }
                    } else if (!LuzLexusLSFrontAirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.lz.lexusis.LuzLexusLSFrontAirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Hand1 /* 1245628 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Hand2 /* 1311164 */:
                    if (!WCYuncheNissanAirControlAct_HP.mIsFront) {
                        ConstAllAirDara.JumpNewAir = true;
                        ConstAllAirDara.JumpNewAircnt = 8;
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.ziyouguang.WCYuncheNissanAirControlAct_HP");
                        break;
                    } else if (WCYuncheNissanAirControlAct_HP.mInstance != null) {
                        WCYuncheNissanAirControlAct_HP.mInstance.finish();
                        break;
                    }
                case FinalCanbus.CAR_452_OD_Toyota_Lexus /* 1245636 */:
                case FinalCanbus.CAR_439_RZC_TOYATO_13HuangGuan /* 6947255 */:
                    if (!rzc_439_Huangguan_AirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.dj.huangguan.rzc_439_Huangguan_AirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_PA_dorango_13_18_Low /* 1376630 */:
                case FinalCanbus.CAR_PA_dorango_13_18_H /* 1442166 */:
                case FinalCanbus.CAR_PA_RAM_13_18_Low /* 1507702 */:
                case FinalCanbus.CAR_PA_RAM_13_18_H /* 1573238 */:
                case FinalCanbus.CAR_PA_Wrangler_18_20_Low /* 1638774 */:
                case FinalCanbus.CAR_PA_Wrangler_18_20_H /* 1704310 */:
                case FinalCanbus.CAR_PA_RAM_20_H /* 1835382 */:
                case FinalCanbus.CAR_PA_RAM_20_Low /* 1900918 */:
                case FinalCanbus.CAR_PA_dorango_10 /* 1966454 */:
                case FinalCanbus.CAR_PA_GMC_13 /* 2031990 */:
                case FinalCanbus.CAR_PA_RAM_22_H /* 2097526 */:
                case FinalCanbus.CAR_PA_RAM_22_Low /* 2163062 */:
                case FinalCanbus.CAR_PA_SONOTEC_13 /* 2294134 */:
                case FinalCanbus.CAR_PA_Escalade_13 /* 2359670 */:
                case FinalCanbus.CAR_PA_Ford_F250 /* 2425206 */:
                case FinalCanbus.CAR_PA_Ford_F450 /* 2490742 */:
                case FinalCanbus.CAR_PA_Ford_F650 /* 2556278 */:
                case FinalCanbus.CAR_PA_Cherokee_14_22 /* 2621814 */:
                case FinalCanbus.CAR_PA_GrandCherokee_14_22 /* 2687350 */:
                case FinalCanbus.CAR_PA_Chrysler_300C_11_22 /* 2752886 */:
                case FinalCanbus.CAR_PA_Dodge_Challenger_08_14 /* 2818422 */:
                case FinalCanbus.CAR_PA_Ford_Explorer_19 /* 2883958 */:
                case FinalCanbus.CAR_PA_Ford_Fusion_22 /* 2949494 */:
                case FinalCanbus.CAR_PA_Ford_F150_14 /* 3015030 */:
                case FinalCanbus.CAR_PA_Ford_F150_20 /* 3080566 */:
                case FinalCanbus.CAR_PA_Ford_Focus_18 /* 3146102 */:
                case FinalCanbus.CAR_PA_Ford_Expedition_21 /* 3211638 */:
                case FinalCanbus.CAR_PA_Ford_Expedition_17 /* 3277174 */:
                case FinalCanbus.CAR_PA_Ford_F_Super_duty_21 /* 3342710 */:
                case FinalCanbus.CAR_PA_Ford_Explorer_19_CD /* 3408246 */:
                case FinalCanbus.CAR_PA_Ford_Fusion_22_CD /* 3473782 */:
                case FinalCanbus.CAR_PA_Ford_F150_14_CD /* 3539318 */:
                case FinalCanbus.CAR_PA_Ford_F150_20_CD /* 3604854 */:
                case FinalCanbus.CAR_PA_Ford_Focus_18_CD /* 3670390 */:
                case FinalCanbus.CAR_PA_Ford_Expedition_21_CD /* 3735926 */:
                case FinalCanbus.CAR_PA_Ford_Expedition_17_CD /* 3801462 */:
                case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_CD /* 3866998 */:
                case FinalCanbus.CAR_PA_Ford_mustang_15 /* 3932534 */:
                case FinalCanbus.CAR_PA_Ford_mustang_15_CD /* 3998070 */:
                case FinalCanbus.CAR_PA_Ford_Explorer_19_Amp /* 4260214 */:
                case FinalCanbus.CAR_PA_Ford_Fusion_22_Amp /* 4325750 */:
                case FinalCanbus.CAR_PA_Ford_F150_14_Amp /* 4391286 */:
                case FinalCanbus.CAR_PA_Ford_F150_20_Amp /* 4456822 */:
                case FinalCanbus.CAR_PA_Ford_Focus_18_Amp /* 4522358 */:
                case FinalCanbus.CAR_PA_Ford_Expedition_21_Amp /* 4587894 */:
                case FinalCanbus.CAR_PA_Ford_Expedition_17_Amp /* 4653430 */:
                case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_Amp /* 4718966 */:
                case FinalCanbus.CAR_PA_Ford_mustang_15_Amp /* 4784502 */:
                case FinalCanbus.CAR_PA_Ford_F_Super_duty_16 /* 4850038 */:
                case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_CD /* 4915574 */:
                case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_Amp /* 4981110 */:
                case FinalCanbus.CAR_PA_Ford_F_Super_duty_08 /* 5046646 */:
                case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_Low /* 5112182 */:
                case FinalCanbus.CAR_PA_RAM_13_18_Low_win4 /* 5177718 */:
                case FinalCanbus.CAR_PA_Cherokee_14_22_Amp /* 5243254 */:
                case FinalCanbus.CAR_PA_GrandCherokee_14_22_Amp /* 5308790 */:
                case FinalCanbus.CAR_PA_Gladiator_20_23 /* 5374326 */:
                case FinalCanbus.CAR_PA_Gladiator_20_23_Amp /* 5439862 */:
                    if (!PAJeepAirControlAct_SP.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.ziyouguang.PAJeepAirControlAct_SP");
                        break;
                    } else if (PAJeepAirControlAct_SP.mInstance != null) {
                        PAJeepAirControlAct_SP.mInstance.finish();
                        break;
                    }
                case FinalCanbus.CAR_WC2_QiChen_T90 /* 1376651 */:
                case FinalCanbus.CAR_WC2_QiChen_D60 /* 1507723 */:
                    if (!AirQiChenT90.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.guochan.AirQiChenT90");
                        break;
                    }
                case FinalCanbus.CAR_439_OuDi_Haval_H9 /* 1376695 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                case FinalCanbus.CAR_RZC_Haval_H9 /* 2490807 */:
                case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                case FinalCanbus.CAR_452_RZC_Haval_H9_Low /* 8651204 */:
                case FinalCanbus.CAR_454_RZC_Haval_H8_15 /* 11796934 */:
                case FinalCanbus.CAR_454_RZC_Haval_H8_15_H /* 11862470 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_RS /* 15598007 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                case FinalCanbus.CAR_452_OD_Haval_VV5 /* 16122308 */:
                case FinalCanbus.CAR_452_OD_Haval_VV6 /* 16187844 */:
                case FinalCanbus.CAR_452_OD_Haval_VV7 /* 16253380 */:
                case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                case FinalCanbus.CAR_439_BNR_HAVAL_H9 /* 16384439 */:
                case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                    if (!Rzc_Oudi_0439_AirFrontCtrl.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.rzc.havalh6.Rzc_Oudi_0439_AirFrontCtrl");
                        break;
                    }
                case FinalCanbus.CAR_443_WC2_YingFeiNiDi_GX50 /* 1507771 */:
                case FinalCanbus.CAR_443_WC2_YingFeiNiDi_15Q70_All /* 4063675 */:
                case FinalCanbus.CAR_443_WC2_YingFeiNiDi_15Q70 /* 4129211 */:
                case FinalCanbus.CAR_443_WC2_YingFeiNiDi_14QX60 /* 4194747 */:
                case FinalCanbus.CAR_443_WC2_YingFeiNiDi_16Q50l /* 4325819 */:
                case FinalCanbus.CAR_443_WC2_YingFeiNiDi_10G37 /* 4587963 */:
                case FinalCanbus.CAR_443_WC2_YingFeiNiDi_11FX35 /* 6095291 */:
                case FinalCanbus.CAR_443_WC_12Cedric_CD /* 7143867 */:
                case FinalCanbus.CAR_443_WC_12Cedric /* 7209403 */:
                case FinalCanbus.CAR_443_WC2_YingFeiNiDi_20QX60 /* 15204795 */:
                    if (!WcInfeinidiFrontAirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.infeinidi.WcInfeinidiFrontAirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_452_XinCheng_Infiniti_ESQ /* 1573316 */:
                    if (!Infiniti_XinCheng_ESQAirControl.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xincheng.infiniti.Infiniti_XinCheng_ESQAirControl");
                        break;
                    }
                case FinalCanbus.CAR_452_XinCheng_Infiniti_06FX /* 1638852 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_08FX /* 1704388 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_G /* 1769924 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_14QX50 /* 1835460 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_15QX60 /* 1900996 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_14QX70 /* 1966532 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_13Q70L /* 2032068 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_12FX /* 3998148 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_15Q50L /* 4063684 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_12JX35 /* 4129220 */:
                    if (!Infiniti_XinCheng_ESQAirControl.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xincheng.infiniti.Infiniti_XinCheng_ESQAirControl");
                        break;
                    }
                case FinalCanbus.CAR_443_WC2_18Ruijie /* 1769915 */:
                case FinalCanbus.CAR_443_WC2_18Ruijie_H /* 1835451 */:
                case FinalCanbus.CAR_443_WC2_Ford_FIESTA_13 /* 15532475 */:
                case FinalCanbus.CAR_443_WC2_Ford_Tourneo_21 /* 15598011 */:
                    if (!WcRuiJieFrontAirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.ruijie15.WcRuiJieFrontAirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_RZC_Ford_Lincoln_navigator /* 1900878 */:
                    if (!NavigatorAirControlAct_Rzc.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.ruijie15.NavigatorAirControlAct_Rzc");
                        break;
                    }
                case FinalCanbus.CAR_454_LUZ_KAYAN_MACAN_CD_HP_LOW /* 1900998 */:
                case FinalCanbus.CAR_452_LZ_Bentley_Bentayga /* 2621893 */:
                case FinalCanbus.CAR_439_LUZ_KAYAN_MACAN_CD /* 6291895 */:
                case FinalCanbus.CAR_439_LUZ_KAYAN_MACAN_CD_HP /* 6422967 */:
                    if (LauncherApplication.getConfiguration() == 1) {
                        if (!LZBinliTianyueAirControlAct.mIsFront) {
                            JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.ruijie15.LZBinliTianyueAirControlAct");
                            break;
                        }
                    } else if (!LZBinliTianyueAirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.ruijie15.LZBinliTianyueAirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_DJ_XP1_ParkAvenue /* 2162713 */:
                    if (!YLAirControlAct_LYDD.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.yinglang.YLAirControlAct_LYDD");
                        break;
                    }
                case FinalCanbus.CAR_455_OUDI_Aiying_BYD_ALL /* 2556359 */:
                    if (!BYDAiyingIndexAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.byd.hcy.BYDAiyingIndexAct");
                        break;
                    }
                case FinalCanbus.CAR_455_LUZ_Nissan_GTR_EN /* 2621895 */:
                case FinalCanbus.CAR_439_LUZ_Nissan_GTR /* 13566391 */:
                    if (!LZ_0439_Nissan_GTR_AirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.dj.huangguan.LZ_0439_Nissan_GTR_AirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7 /* 2752956 */:
                    if (!WCYuncheUINissanAirControlAct.mIsFront) {
                        ConstAllAirDara.JumpNewAir = true;
                        ConstAllAirDara.JumpNewAircnt = 8;
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.ziyouguang.WCYuncheUINissanAirControlAct");
                        break;
                    } else if (WCYuncheUINissanAirControlAct.mInstance != null) {
                        WCYuncheUINissanAirControlAct.mInstance.finish();
                        break;
                    }
                case FinalCanbus.CAR_452_LZ_Jaguar_XK /* 3670468 */:
                    if (!JaguarAirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.lz.jaguar.JaguarAirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_ZX_6606_XP1_19Yazhoulong /* 3735664 */:
                case FinalCanbus.CAR_ZX_6606_XP1_Sienna /* 3801200 */:
                case FinalCanbus.CAR_ZX_6606_XP1_Bz4x /* 4915312 */:
                case FinalCanbus.CAR_ZX_6606_XP1_24Camry /* 7274608 */:
                    if (!rzc_6606_112_Toyota_AirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.dj.huangguan.rzc_6606_112_Toyota_AirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_443_WC2_YingFeiNiDi_14QX60_SP /* 4260283 */:
                    if (!WcInfeinidiFrontAirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.infeinidi.WcInfeinidiFrontAirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_443_WC2_Ford_18Everest_L /* 4391355 */:
                case FinalCanbus.CAR_443_WC2_Ford_18Everest_H /* 4456891 */:
                case FinalCanbus.CAR_443_WC2_Ford_18Everest_FLB /* 4522427 */:
                case FinalCanbus.CAR_443_WC2_Ford_RANGER /* 5898683 */:
                case FinalCanbus.CAR_443_WC2_Ford_18Everest_FLB_H /* 5964219 */:
                case FinalCanbus.CAR_443_WC2_Ford_Everest_SUV_Low1 /* 6160827 */:
                case FinalCanbus.CAR_443_WC2_Ford_Everest_SUV_Low2 /* 6226363 */:
                case FinalCanbus.CAR_443_WC2_Ford_Everest_PickUP_Low /* 6291899 */:
                case FinalCanbus.CAR_443_WC2_Ford_Everest_PickUP_H /* 6357435 */:
                case FinalCanbus.CAR_443_WC2_Ford_12Focus_Overseas /* 15139259 */:
                    if (LauncherApplication.getConfiguration() == 1) {
                        if (!WcEverestFrontAirControlAct_SP.mIsFront) {
                            JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.ruijie15.WcEverestFrontAirControlAct_SP");
                            break;
                        }
                    } else if (!WcRuiJieFrontAirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.ruijie15.WcRuiJieFrontAirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_443_WC2_Huaicai /* 4653499 */:
                    if (!WC2WeiChaiAirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc2.weichai.WC2WeiChaiAirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_452_LZ_Jaguar_XF /* 4915652 */:
                case FinalCanbus.CAR_452_LZ_Jaguar_XF_09 /* 6029764 */:
                    if (!LuzJaguar09XFAirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.rzc.sanlin.LuzJaguar09XFAirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_452_XinCheng_Nissan_Tule_L /* 5046724 */:
                case FinalCanbus.CAR_452_XinCheng_Nissan_Tule_H /* 5112260 */:
                    if (!Xincheng_Nissan_Tule_AirControlActi.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xincheng.infiniti.Xincheng_Nissan_Tule_AirControlActi");
                        break;
                    }
                case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
                case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
                case FinalCanbus.CAR_BNR_Toyota_14Tundra_AMP /* 6422925 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AMP /* 6488461 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP /* 6553997 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP_19 /* 6619533 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10_AMP /* 6685069 */:
                    if (!PAToyotaAirControlAct_SP.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.ziyouguang.PAToyotaAirControlAct_SP");
                        break;
                    } else if (PAToyotaAirControlAct_SP.mInstance != null) {
                        PAToyotaAirControlAct_SP.mInstance.finish();
                        break;
                    }
                case FinalCanbus.CAR_443_WC2_TATA_NWXON /* 5439931 */:
                case FinalCanbus.CAR_443_WC2_TATA_Altroz /* 11927995 */:
                case FinalCanbus.CAR_443_WC2_TATA_Tiago /* 11993531 */:
                case FinalCanbus.CAR_443_WC2_TATA_harrier /* 12059067 */:
                    if (!WC2TataAirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc2.tata.WC2TataAirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AMP /* 6750605 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_AMP /* 6816141 */:
                    if (!PAToyota10TundraAirControlAct_SP.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.ziyouguang.PAToyota10TundraAirControlAct_SP");
                        break;
                    } else if (PAToyota10TundraAirControlAct_SP.mInstance != null) {
                        PAToyota10TundraAirControlAct_SP.mInstance.finish();
                        break;
                    }
                case FinalCanbus.CAR_PA_BNR_Toyota_LS460_06 /* 6095245 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_GS_06 /* 6160781 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_IS_06 /* 6226317 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_ES_06 /* 6291853 */:
                case FinalCanbus.CAR_PA_BNR_Toyota_GX460_10 /* 6357389 */:
                    if (!PAToyotaLexusLS460AirControlAct_SP.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.ziyouguang.PAToyotaLexusLS460AirControlAct_SP");
                        break;
                    } else if (PAToyotaLexusLS460AirControlAct_SP.mInstance != null) {
                        PAToyotaLexusLS460AirControlAct_SP.mInstance.finish();
                        break;
                    }
                case FinalCanbus.CAR_453_OD_WeiMa_EX5 /* 6226373 */:
                    if (!ODWeiEX5AirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.rzc.sanlin.ODWeiEX5AirControlAct");
                        break;
                    } else if (ODWeiEX5AirControlAct.mInstance != null) {
                        ODWeiEX5AirControlAct.mInstance.finish();
                        break;
                    }
                case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_07_MO /* 6357445 */:
                case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_07_TX /* 6422981 */:
                case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_12_MO /* 6488517 */:
                case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_12_TX /* 6554053 */:
                case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_10_MO /* 6619589 */:
                case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_10_TX /* 6685125 */:
                case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_14_MO /* 6750661 */:
                case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_14_TX /* 6816197 */:
                    if (!KYCLexusFrontAirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.lz.lexusis.KYCLexusFrontAirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_439_AY_BYD_Sirui /* 6619575 */:
                case FinalCanbus.CAR_439_HCY_BYD_S6_H /* 6750647 */:
                case FinalCanbus.CAR_453_RCW_Honda_YaGe7 /* 8520133 */:
                case FinalCanbus.CAR_439_RCW_BYD_12_18Surui /* 9699767 */:
                case FinalCanbus.CAR_439_RCW_BYD_14_15G5 /* 9765303 */:
                case FinalCanbus.CAR_439_RCW_BYD_10_15M6 /* 9830839 */:
                case FinalCanbus.CAR_439_RCW_BYD_13_17S7 /* 9896375 */:
                case FinalCanbus.CAR_439_RCW_BYD_16_19Song /* 9961911 */:
                case FinalCanbus.CAR_439_RCW_BYD_17_19SongMax /* 10027447 */:
                case FinalCanbus.CAR_439_RCW_BYD_12_17E6 /* 10092983 */:
                case FinalCanbus.CAR_439_OUDI_BYD_ALL /* 12976567 */:
                case FinalCanbus.CAR_453_RCW_BYD_10_13G6 /* 13042117 */:
                    if (!ActivityAirCrtrlBydSirui.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.byd.hcy.ActivityAirCrtrlBydSirui");
                        break;
                    }
                case FinalCanbus.CAR_452_LZ_Jaguar_F_TYPE /* 6881732 */:
                case FinalCanbus.CAR_452_LZ_Jaguar_XJL /* 7012804 */:
                case FinalCanbus.CAR_452_LZ_Jaguar_XFL_PACE /* 12779972 */:
                case FinalCanbus.CAR_452_LZ_Jaguar_XFL_PACE_H /* 13238724 */:
                    if (!LZJaguarXJLFrontAirControlAct_SP.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.ruijie15.LZJaguarXJLFrontAirControlAct_SP");
                        break;
                    }
                case FinalCanbus.CAR_439_HC_Nissan_Toread /* 7012791 */:
                    if (!ActivityToread_AirRearCtrl.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.hc.tianlai.ActivityToread_AirRearCtrl");
                        break;
                    }
                case FinalCanbus.CAR_454_LZ_Chrysler_300C_15_Daohang /* 7078342 */:
                    if (!Air_Activity_Daohang_Only_HP.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.air.Air_Activity_Daohang_Only_HP");
                        break;
                    }
                case FinalCanbus.CAR_LUZ_Toyato_All /* 7274935 */:
                case FinalCanbus.CAR_LUZ_Toyato_All_H /* 7340471 */:
                case FinalCanbus.CAR_LUZ_Toyato_20All /* 8126903 */:
                case FinalCanbus.CAR_LUZ_Toyato_30All /* 8192439 */:
                case FinalCanbus.CAR_452_LZ_Toyato_RX450 /* 12648900 */:
                case FinalCanbus.CAR_452_LZ_Toyato_RX270 /* 12714436 */:
                    if (LauncherApplication.getConfiguration() != 1) {
                        if (!Air_Activity_All_NewAdd_HP.mIsFront) {
                            JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.air.Air_Activity_All_NewAdd_HP");
                            break;
                        } else if (Air_Activity_All_NewAdd_HP.mInstance != null) {
                            Air_Activity_All_NewAdd_HP.mInstance.finish();
                            break;
                        }
                    } else if (!LZ_0439_Toyota_AirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.dj.huangguan.LZ_0439_Toyota_AirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_439_XBS_BYD_Song /* 8782263 */:
                    if (!XBS_439_BYD_Song_AirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.byd.hcy.XBS_439_BYD_Song_AirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_439_CXW_Kairui_K50 /* 8847799 */:
                    if (!CxwK50AirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.cxw.k50.CxwK50AirControlAct");
                        break;
                    } else if (CxwK50AirControlAct.mInstance != null) {
                        CxwK50AirControlAct.mInstance.finish();
                        break;
                    }
                case FinalCanbus.CAR_439_DJ_Haval_H8 /* 10420663 */:
                case FinalCanbus.CAR_439_DJ_Haval_H8_H /* 10486199 */:
                case FinalCanbus.CAR_439_DJ_Haval_H9 /* 15794628 */:
                case FinalCanbus.CAR_439_DJ_Haval_H9_H /* 15860164 */:
                case FinalCanbus.CAR_439_DJ_Haval_VV5 /* 15925700 */:
                case FinalCanbus.CAR_439_DJ_Haval_VV6 /* 15991236 */:
                case FinalCanbus.CAR_439_DJ_Haval_VV7 /* 16056772 */:
                    if (!Dj_0439_AirFrontCtrl.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.dj.havalh8.Dj_0439_AirFrontCtrl");
                        break;
                    }
                case FinalCanbus.CAR_452_PA_Nissan_XTrail_21 /* 11731396 */:
                case FinalCanbus.CAR_452_PA_Nissan_Loulan_21 /* 11796932 */:
                case FinalCanbus.CAR_452_PA_Nissan_Terra_21 /* 11862468 */:
                case FinalCanbus.CAR_452_PA_Nissan_TITAN /* 11928004 */:
                case FinalCanbus.CAR_452_PA_Infiniti_G37 /* 13894084 */:
                    if (!PANissanAirControlAct_SP.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.ziyouguang.PANissanAirControlAct_SP");
                        break;
                    } else if (PANissanAirControlAct_SP.mInstance != null) {
                        PANissanAirControlAct_SP.mInstance.finish();
                        break;
                    }
                case FinalCanbus.CAR_452_OD_Hongqi_H7 /* 12124612 */:
                case FinalCanbus.CAR_454_CZH_OD_Hongqi_EQM5 /* 16515526 */:
                    if (!Oudi_0452_Hongqi_AirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.oudi.hantengx5.Oudi_0452_Hongqi_AirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_452_KYC_Toyota_Landekuluze /* 14221764 */:
                case FinalCanbus.CAR_452_KYC_Toyota_Runner /* 14287300 */:
                case FinalCanbus.CAR_452_KYC_Toyota_Alpha /* 14352836 */:
                    if (!KYCToyotaAllAirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.rzc.sanlin.KYCToyotaAllAirControlAct");
                        break;
                    }
                case FinalCanbus.CAR_454_LZ_Toyota_LAND_CRUISER_11_CD_DH /* 16581062 */:
                case FinalCanbus.CAR_454_LZ_Toyota_LAND_CRUISER_11_CD_DH_H /* 16646598 */:
                    if (!LuzDaoHangToyotaAirControlAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.lz.lexusis.LuzDaoHangToyotaAirControlAct");
                        break;
                    } else if (LuzDaoHangToyotaAirControlAct.mInstance != null) {
                        LuzDaoHangToyotaAirControlAct.mInstance.finish();
                        break;
                    }
            }
        }
    }
}
