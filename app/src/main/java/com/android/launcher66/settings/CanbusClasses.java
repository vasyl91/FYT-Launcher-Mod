package com.android.launcher66.settings;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.preference.PreferenceManager;

import com.android.async.AsyncTask;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;
import com.syu.module.canbus.DataCanbus;

import java.io.File;

import com.syu.carinfo.accord.ActivityAccord7Index;
import com.syu.carinfo.accord9.wc.Accord9HIndexAct;
import com.syu.carinfo.accord9.wc.Accord9LowIndexAct;
import com.syu.carinfo.accord9.xp.XPAccord9IndexActi;
import com.syu.carinfo.aiying.ziyouguang.JeepIndexAct;
import com.syu.carinfo.ansheng.mzd6.AnSheng_167_Mzd6_CarCdAct;
import com.syu.carinfo.b70.BenTeng14B70ClockSet;
import com.syu.carinfo.b70.BengTeng_RZC_17B70QC_Index;
import com.syu.carinfo.b70.WCBenTeng14B70ClockSet;
import com.syu.carinfo.bagoo.aodi.AudiAct;
import com.syu.carinfo.bagoo.kayan.KaYanAct;
import com.syu.carinfo.bagu.bmw.BaguBmwIndexAct;
import com.syu.carinfo.baogu.renault.Baogu_Renault_IndexAct;
import com.syu.carinfo.bg.fiat.ActivityFiatCarUSB;
import com.syu.carinfo.bg.fiat.ActivityFiatIndex;
import com.syu.carinfo.bg.ziyouguang.Bg_DaQieNuoJi_IndexAct;
import com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_IndexAct;
import com.syu.carinfo.biaozhi408.BZ408IndexActi;
import com.syu.carinfo.biaozhi408.BZ408OilMileIndexActi;
import com.syu.carinfo.biaozhi408.Biaozhi206OilPage;
import com.syu.carinfo.biaozhi408.HC_Biaozhi206OilPage;
import com.syu.carinfo.biaozhi408.XpPsa301Acti;
import com.syu.carinfo.bmw.BMWX1IndexActi;
import com.syu.carinfo.bnr.Acti_Crow_Amp_Bnr;
import com.syu.carinfo.bnr.Acti_Nissan_Bnr;
import com.syu.carinfo.bnr.Acti_Nissan_Sanwu;
import com.syu.carinfo.bnr.Bnr_255_FengShengax7_Allvideo;
import com.syu.carinfo.bnr.arrizo.BNR_Arrizo_CarSettingAct;
import com.syu.carinfo.bnr.ford.Activity_ford_index;
import com.syu.carinfo.bnr.guanzhi.BnrGuanzhiIndexAct;
import com.syu.carinfo.bnr.guanzhi.LZFerrariF12CarInfo;
import com.syu.carinfo.bnr.jeep.ActiIndex_Bnr_117_Functionl;
import com.syu.carinfo.bnr.tule.BnrTuleIndexAct;
import com.syu.carinfo.bus.ActivityBusCarCheck;
import com.syu.carinfo.byd.Act_Byd_Tang_XBS;
import com.syu.carinfo.byd.RzcBydS6Acti;
import com.syu.carinfo.byd.hcy.Activity_DaojunSetCrtrl;
import com.syu.carinfo.byd.hcy.Activity_HCY_BYD_S7;
import com.syu.carinfo.byd.hcy.Activity_OD_Aiying_BYD_Sirui;
import com.syu.carinfo.byd.hcy.Activity_OD_BYD_ALL;
import com.syu.carinfo.byd.hcy.Activity_OD_Zotye_T700;
import com.syu.carinfo.byd.hcy.Activity_RCW_BYD_S7;
import com.syu.carinfo.byd.hcy.Activity_XBS_BYD_Song;
import com.syu.carinfo.byd.hcy.BYDAiyingIndexAct;
import com.syu.carinfo.camry.luz.CamryIndexAct_LuZ;
import com.syu.carinfo.camry.luz.ToyotaLexusEQActi_Luz;
import com.syu.carinfo.camry.zh.CamryIndexAct_ZH;
import com.syu.carinfo.camry2012.xp.CamryIndexAct;
import com.syu.carinfo.camry2012.xp.CamryIndexAct_XP;
import com.syu.carinfo.camry2012.xp.CamryIndexEVAct;
import com.syu.carinfo.camry2012.xp.LadaSettingsAct;
import com.syu.carinfo.camry2012.xp.RzcPeroduaIndexAct;
import com.syu.carinfo.camry2012.xp.ToyotaLexusEQActi;
import com.syu.carinfo.camry2012.xp.ToyotaLexusIndexActi;
import com.syu.carinfo.crv.CrvXBSActi;
import com.syu.carinfo.crv.KangshengXpCrvActi;
import com.syu.carinfo.crv.WcCrvActi;
import com.syu.carinfo.crv.XpCrvActi;
import com.syu.carinfo.daojun.ats.AtsIndexAct;
import com.syu.carinfo.daojun.b70.DaojunB70CarSettingAct;
import com.syu.carinfo.daojun.b70.DaojunB70LowCarSettingAct;
import com.syu.carinfo.daojun.bydm6.DaojunBydM6SetFunc;
import com.syu.carinfo.daojun.lexus.DJPrado8SetFunc;
import com.syu.carinfo.daojun.lexus.djLexusIndexAct;
import com.syu.carinfo.daojun.tianlai.djTianlaiAudio;
import com.syu.carinfo.daojun.tianlai.djTianlaiIndexAct;
import com.syu.carinfo.dasauto.DasAutoIndexAct;
import com.syu.carinfo.dasauto.DasAutoWcAct;
import com.syu.carinfo.dasauto.DasAutoXpAct;
import com.syu.carinfo.dasauto.FaultCodeWindow;
import com.syu.carinfo.dasauto.TuRui_IndexAct;
import com.syu.carinfo.dasauto.VwDashBoard_DZSJ;
import com.syu.carinfo.dj.DjAiruize7Setting;
import com.syu.carinfo.dj.DjBYDG6;
import com.syu.carinfo.dj.b70.DjB70Act;
import com.syu.carinfo.dj.dodge.DjDodgeCarSet;
import com.syu.carinfo.dj.havalh8.Dj_0439_HavalH8_IndexAct;
import com.syu.carinfo.dj.huangguan.ActivityHuangGuanIndex;
import com.syu.carinfo.dongjian.ga6.GA6CarSetIndexAct;
import com.syu.carinfo.dongjian.wc2.ds5.DS5IndexAct;
import com.syu.carinfo.focus.ActivityIndex_14Festia;
import com.syu.carinfo.focus.FocusSyncBtActi;
import com.syu.carinfo.focus.yl.YLFocusIndex;
import com.syu.carinfo.ford.FordCarSet_RZC;
import com.syu.carinfo.ford.FordIndexAct;
import com.syu.carinfo.ford.FordRuijieCDIndexAct;
import com.syu.carinfo.ford.LZMustangCarEQSet;
import com.syu.carinfo.ford.MustangIndexAct;
import com.syu.carinfo.geshitu.wc.WCGeshituIndexActi;
import com.syu.carinfo.geshitu.wc.WCRenaultIndexActi;
import com.syu.carinfo.golf7.Golf7IndexAct;
import com.syu.carinfo.golf7.Golf7OilMileageIndexActiOD;
import com.syu.carinfo.golf7.Golf7OilMileagePage1LowActi;
import com.syu.carinfo.golf7.LingDuActi;
import com.syu.carinfo.golf7_xp.Golf7_XP_IndexAct;
import com.syu.carinfo.guochan.Acti_BNR_ShengDaFei;
import com.syu.carinfo.guochan.ActivityBaojun530Info;
import com.syu.carinfo.guochan.ActivityBiSuT3;
import com.syu.carinfo.guochan.ActivityHuanSuS6Index;
import com.syu.carinfo.guochan.ActivityWC20Baojun530Info;
import com.syu.carinfo.guochan.ActivityZhongHuaH3;
import com.syu.carinfo.guochan.Activity_RZC_SettingT60;
import com.syu.carinfo.haozheng.bmw.BmwIndexAct;
import com.syu.carinfo.hava.ActivityHava18H6Index;
import com.syu.carinfo.hava.ActivityHava18H6SetAct;
import com.syu.carinfo.hava.ActivityHavaH2SIndex;
import com.syu.carinfo.hava.ActivityHavaH3;
import com.syu.carinfo.hava.BNRActivityHavaH6SetAct;
import com.syu.carinfo.havah6.HavalH6Acti;
import com.syu.carinfo.havah6.WC_0320_HavalH9_IndexAct;
import com.syu.carinfo.havah6.WcHaval17and18H6Acti;
import com.syu.carinfo.havah6.WcHavalH6Acti;
import com.syu.carinfo.havah6.WcHavalH6CoupeActi;
import com.syu.carinfo.hc.accord8.Hc_385_CarCdAct;
import com.syu.carinfo.hc.chrysler.ChryslerCarEqActi;
import com.syu.carinfo.hc.elysion.Hc_103_Elysion_IndexAct;
import com.syu.carinfo.hc.oubao.IndexAct_Hc_14Oubao;
import com.syu.carinfo.hc.qiyakaizunk7.HCQiyaKaizunK7Audio;
import com.syu.carinfo.hc.rongwei950.Hc_Rongwei950_IndexAct;
import com.syu.carinfo.hc.ruijie.XCFordRuijieEQAct;
import com.syu.carinfo.hc.tianlai.ActivityODRenaultKeleosCD;
import com.syu.carinfo.hc.tianlai.ActivityTianLaiCarSettings;
import com.syu.carinfo.hc.tianlai.IndexAct_Hc_03TianLai;
import com.syu.carinfo.hc.volvo.IndexAct_Hc_volvo;
import com.syu.carinfo.hechi.fordexplorer.HcFordExplorerIndexAct;
import com.syu.carinfo.honda.Act_CarCD_AoDeSai;
import com.syu.carinfo.honda.Act_LEDScreen_AoDeSai_wc;
import com.syu.carinfo.honda.Act_RZC_CarCD_AoDeSai;
import com.syu.carinfo.honda.ActivitySiYuIndex;
import com.syu.carinfo.honda.HondaIndexActi;
import com.syu.carinfo.honda.RZCSuzukiIndexActi;
import com.syu.carinfo.huiteng.HuitengIndexAct;
import com.syu.carinfo.jianianhua_wc.JiaNianHuaMainActivity;
import com.syu.carinfo.jili.BoyueCarSettingsAct;
import com.syu.carinfo.jili.BoyueIndexAct;
import com.syu.carinfo.jili.Dihao19GLECarSettingsAct;
import com.syu.carinfo.jili.LZJiliBoyueCarSettingsAct;
import com.syu.carinfo.jili.ODJiliRuilanX3CarSettingsAct;
import com.syu.carinfo.jili.RZCBoyueCarSettingsAct;
import com.syu.carinfo.jili.RZCNisaanGuishiCarSettingsAct;
import com.syu.carinfo.jili.YuanJingX1CarSettingsAct;
import com.syu.carinfo.jili.YuanjingX3TireAct;
import com.syu.carinfo.klc.DJGMKopachBasicInfoAct;
import com.syu.carinfo.klc.KlcIndexAct;
import com.syu.carinfo.klc.WcGMKopachBasicInfoAct;
import com.syu.carinfo.ksw.audiq5.KswAudiQ5SetFunc;
import com.syu.carinfo.ksw.audiq5.LZBmwIndexFunc;
import com.syu.carinfo.ksw.audiq5.RDWBenzSetFunc;
import com.syu.carinfo.ksw.audiq5.ZXMZDSetFunc;
import com.syu.carinfo.ky.ActivityDaMaiX7;
import com.syu.carinfo.ky.ActivityHaimaS3;
import com.syu.carinfo.ky.escort.Ky_439_Escort_CarSettingAct;
import com.syu.carinfo.leinuo.Act_Keleijia_Index;
import com.syu.carinfo.leinuo.Act_Keleijia_set;
import com.syu.carinfo.lifan720.LiFan720IndexAct;
import com.syu.carinfo.luz.binli.BinliIndexAct;
import com.syu.carinfo.luz.oubao.Luz_Oubao_IndexAct;
import com.syu.carinfo.lz.infinit.fx35.LuzInfinitF35IndexAct;
import com.syu.carinfo.lz.jaguar.TDLandRoverIndexAct;
import com.syu.carinfo.lz.kayan.LuzKayanSetFunc;
import com.syu.carinfo.lz.landrover.LandRoverIndexAct;
import com.syu.carinfo.lz.lexusis.LuzLexusISIndexAct;
import com.syu.carinfo.lz.lexusis.LuzLexusLSClockSetAct;
import com.syu.carinfo.lz.nissan.gtr.LuzNissanGTRIndexAct;
import com.syu.carinfo.lz.spirior.Lz_425_Spirior_IndexActi;
import com.syu.carinfo.mzd.GMCPannelSetActi;
import com.syu.carinfo.mzd.MzdClockSetActi;
import com.syu.carinfo.mzd.MzdRZCM3ClockSetActi;
import com.syu.carinfo.mzd.MzdRZCM6ClockSetActi;
import com.syu.carinfo.mzd.cx5.ActivityHaiMaSettings;
import com.syu.carinfo.mzd.cx5.ActivityHaiMaV70Index;
import com.syu.carinfo.mzd.cx5.CX5Index;
import com.syu.carinfo.od.bmw.ODBMWMiniIndexAct;
import com.syu.carinfo.od.dongnanv5.Dongnanv5IndexActi;
import com.syu.carinfo.od.ford.falcon.FordFalconIndexAct;
import com.syu.carinfo.od.mazdall.MazdAllIndexAct;
import com.syu.carinfo.od.mazdall.WCSuzukiAllIndexAct;
import com.syu.carinfo.od.porsche.ODPorscheIndexAct;
import com.syu.carinfo.od.tusheng.OD_19Tusheng_CarSettingAct;
import com.syu.carinfo.od.tusheng.RZC_Xiandai_E_IndexAct;
import com.syu.carinfo.od.tusheng.XP_19ShengDafei_CarSettingAct;
import com.syu.carinfo.opel.OPELCarKeyActivity;
import com.syu.carinfo.opel.WCOPELCarIndexActi;
import com.syu.carinfo.opel.WCOPELCarKeyActivity;
import com.syu.carinfo.opel.XP_Opel_Panel_New;
import com.syu.carinfo.oudi.ActivityCarCD_Oudi_Aodesai;
import com.syu.carinfo.oudi.ODOpelAdanCarTire;
import com.syu.carinfo.oudi.ODOpelAdanIndexActi;
import com.syu.carinfo.oudi.ODWeiChaiU70CarInfo;
import com.syu.carinfo.oudi.OD_Lamborghini_PanelButton;
import com.syu.carinfo.oudi.RZC_0314_Dongfeng_Ev3_IndexAct;
import com.syu.carinfo.oudi.baojun530.ActivityOudiBaojun530Info;
import com.syu.carinfo.oudi.beiqi.ActivityODBeiqiECIndex;
import com.syu.carinfo.oudi.bisu.ActivityBiSuT3AndM3;
import com.syu.carinfo.oudi.changan.OdChanganIndexAct;
import com.syu.carinfo.oudi.changan.OdChanganSetFunc;
import com.syu.carinfo.oudi.hantengx5.Oudi_0255_HanTengX5_IndexAct;
import com.syu.carinfo.oudi.nazhijieu7.OdNazhijieU7SetFunc;
import com.syu.carinfo.pardo2014.wc.PardoIndexAct;
import com.syu.carinfo.pasbiaozhi408.PsasettingActi_HC;
import com.syu.carinfo.psa.Psa2008IndexActi;
import com.syu.carinfo.psa.Psa301IndexActi;
import com.syu.carinfo.psa.PsaDs5lsIndexActi;
import com.syu.carinfo.psa.PsaOilMileIndexActi;
import com.syu.carinfo.psa_all.PSAIndexActi;
import com.syu.carinfo.qirui.ActivityWCAiRuiZe;
import com.syu.carinfo.qirui.ActivityWCQiruiJietuX70;
import com.syu.carinfo.qirui.DaojunQiruiCarSet;
import com.syu.carinfo.qiya.kx7.ActivityKX7CameraSet;
import com.syu.carinfo.qiya.kx7.ActivityQiYaKaiShenSet;
import com.syu.carinfo.qiya.kx7.ActivityWCXianDaiAllSet;
import com.syu.carinfo.rongwei.Wc_416_RongWei_CarSetAct;
import com.syu.carinfo.rongwei.Wc_416_RongWei_IndexAct;
import com.syu.carinfo.rzc.andra.GmAndraIndexActi;
import com.syu.carinfo.rzc.baojun.ODDongnanSetFunc;
import com.syu.carinfo.rzc.baojun.ODFotonTOANOSetFunc;
import com.syu.carinfo.rzc.baojun.ODFotonTunlandSetFunc;
import com.syu.carinfo.rzc.baojun.ODXinteDEV1SetFunc;
import com.syu.carinfo.rzc.baojun.RzcBaojunSetFunc;
import com.syu.carinfo.rzc.beiqi.Activity18EU5CarSet;
import com.syu.carinfo.rzc.beiqi.Activity19EC5Index;
import com.syu.carinfo.rzc.beiqi.ActivityEC180Index;
import com.syu.carinfo.rzc.biaozhi408.RZC_BZ408IndexActi;
import com.syu.carinfo.rzc.biaozhi408.RZC_BZ408_Panel_IndexActi;
import com.syu.carinfo.rzc.changan.ODChanganCS95AllSetAct;
import com.syu.carinfo.rzc.changan.RzcChanganAllIndexAct;
import com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70IndexAct;
import com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70SetFunc;
import com.syu.carinfo.rzc.changan_cx70.RzcChanganCX70TireAct;
import com.syu.carinfo.rzc.feiyate.RzcFYTOilMileIndexActi;
import com.syu.carinfo.rzc.feiyate.RzcFeiyateIndexAct;
import com.syu.carinfo.rzc.fengshen_ax7.RzcFengshenAx7SetFunc;
import com.syu.carinfo.rzc.fengshen_ax7.RzcFengshenX37SetFunc;
import com.syu.carinfo.rzc.fengshen_ax7.RzcFengshenYixuanSetFunc;
import com.syu.carinfo.rzc.gs4.ActGS4LowSetting;
import com.syu.carinfo.rzc.gs4.RzcGS4IndexAct;
import com.syu.carinfo.rzc.gs4.Rzc_Gs8_IndexAct;
import com.syu.carinfo.rzc.haima.HaimaS5SetFunc;
import com.syu.carinfo.rzc.haima.ODJianglingSetFunc;
import com.syu.carinfo.rzc.hantengx5.RZC_0255_FengShenAx7_IndexAct;
import com.syu.carinfo.rzc.hantengx5.RZC_0255_HanTengX5_IndexAct;
import com.syu.carinfo.rzc.hantengx5.RZC_0255_HanTengX5_TireAct;
import com.syu.carinfo.rzc.havalh6.RZC_Oudi_0439_HavalH9_IndexAct;
import com.syu.carinfo.rzc.jianghuai.RzcJianghuaiIndexAct;
import com.syu.carinfo.rzc.jingyix5.ActivityJingYiX5;
import com.syu.carinfo.rzc.keleijia.KeLeiJiaIndexActi;
import com.syu.carinfo.rzc.keleijia.KeLeiJiaRadarSetting;
import com.syu.carinfo.rzc.keleijia.KeleiaoCarCD;
import com.syu.carinfo.rzc.klc.RzcKlcIndex;
import com.syu.carinfo.rzc.lufengxiaoyao.RZCLufengXiaoyaoIndexAct;
import com.syu.carinfo.rzc.mazda.Rzc_Mazda_IndexAct;
import com.syu.carinfo.rzc.mingjueruiteng.Act17RuiTengCarSet;
import com.syu.carinfo.rzc.mingjueruiteng.Act20ZSIndexAct;
import com.syu.carinfo.rzc.mingjueruiteng.ActDaojunRongweI5CarSet;
import com.syu.carinfo.rzc.mingjueruiteng.ActRongwei550CarSet;
import com.syu.carinfo.rzc.mingjueruiteng.ActRuiTengIndex;
import com.syu.carinfo.rzc.mingjueruiteng.ActivityBNRRongWeiRX5;
import com.syu.carinfo.rzc.mingjueruiteng.ActivityRZCRongWeiRX5;
import com.syu.carinfo.rzc.nissa_tuda.RzcNissanTudaInTireAct;
import com.syu.carinfo.rzc.qirui.ActivityQiRuiAiRuiZe;
import com.syu.carinfo.rzc.qirui.ActivityQiRuiXMYCarSet;
import com.syu.carinfo.rzc.ruifengs3.JhRuiFengR3IndexAct;
import com.syu.carinfo.rzc.ruifengs3.JhRuiFengS3TireAct;
import com.syu.carinfo.rzc.sanlin.BNRToyotaAmpCarSet;
import com.syu.carinfo.rzc.sanlin.DJFordFiestaCarSet;
import com.syu.carinfo.rzc.sanlin.DJJianghuaiSihaoCarInfo;
import com.syu.carinfo.rzc.sanlin.DaojunPreviaCarSet;
import com.syu.carinfo.rzc.sanlin.KYCToyotaAllCarSet;
import com.syu.carinfo.rzc.sanlin.KYCZhonghuaCarSet;
import com.syu.carinfo.rzc.sanlin.LZAudiQ5CarSet;
import com.syu.carinfo.rzc.sanlin.LZCadillacCarSet;
import com.syu.carinfo.rzc.sanlin.LZFiatInfCarSet;
import com.syu.carinfo.rzc.sanlin.LZHonda06CivicCarInfo;
import com.syu.carinfo.rzc.sanlin.LZNissanFugaCarInfo;
import com.syu.carinfo.rzc.sanlin.LuZAstonMartinCarInfo;
import com.syu.carinfo.rzc.sanlin.LuZMaserati300CCarSet;
import com.syu.carinfo.rzc.sanlin.LuzAudioOldCarInfo;
import com.syu.carinfo.rzc.sanlin.LuzBenzC200CarSet;
import com.syu.carinfo.rzc.sanlin.LuzJaguarXFCarSet;
import com.syu.carinfo.rzc.sanlin.LuzTATACarSet;
import com.syu.carinfo.rzc.sanlin.LuzVolvoCarSet;
import com.syu.carinfo.rzc.sanlin.NissanJukeCarSet;
import com.syu.carinfo.rzc.sanlin.NissanXiaokeCarSet;
import com.syu.carinfo.rzc.sanlin.ODBMWCarInfo;
import com.syu.carinfo.rzc.sanlin.ODBeiqiBJ30CarSet;
import com.syu.carinfo.rzc.sanlin.ODBeiqiBJ80CarSet;
import com.syu.carinfo.rzc.sanlin.ODBeiqiBJ90CarSet;
import com.syu.carinfo.rzc.sanlin.ODBeiqiEV160CarSet;
import com.syu.carinfo.rzc.sanlin.ODBentNATCarSet;
import com.syu.carinfo.rzc.sanlin.ODCHuangWeiET5CarSet;
import com.syu.carinfo.rzc.sanlin.ODChangChengOulaCarInfo;
import com.syu.carinfo.rzc.sanlin.ODChanganLuminCarSet;
import com.syu.carinfo.rzc.sanlin.ODChangfengCS9EVCarInfo;
import com.syu.carinfo.rzc.sanlin.ODDongfengChenglongH7CarSet;
import com.syu.carinfo.rzc.sanlin.ODDongfengEVCarInfo;
import com.syu.carinfo.rzc.sanlin.ODFordNavigatorCarSet;
import com.syu.carinfo.rzc.sanlin.ODFreeLanderCarInfo;
import com.syu.carinfo.rzc.sanlin.ODHuachenSWMCarInfo;
import com.syu.carinfo.rzc.sanlin.ODJianghuaiChaoyueCarSet;
import com.syu.carinfo.rzc.sanlin.ODKaiyiX3CarSet;
import com.syu.carinfo.rzc.sanlin.ODLeTinMangguoCarSet;
import com.syu.carinfo.rzc.sanlin.ODModerninIndexAct;
import com.syu.carinfo.rzc.sanlin.ODNissanQuystCarSet;
import com.syu.carinfo.rzc.sanlin.ODQiruiXiaomayiCarInfo;
import com.syu.carinfo.rzc.sanlin.ODRuichiEC75CarSet;
import com.syu.carinfo.rzc.sanlin.ODSanlinCarSet;
import com.syu.carinfo.rzc.sanlin.ODShanqiZHongkaCarSet;
import com.syu.carinfo.rzc.sanlin.ODSubaruLegacyCarInfo;
import com.syu.carinfo.rzc.sanlin.ODWeimaEx5IndexAct;
import com.syu.carinfo.rzc.sanlin.ODYiqiJiefangJ6GCarSet;
import com.syu.carinfo.rzc.sanlin.ODZhidouD1EVCarInfo;
import com.syu.carinfo.rzc.sanlin.ODZhidouEVCarInfo;
import com.syu.carinfo.rzc.sanlin.ODZhonghuaV6CarSet;
import com.syu.carinfo.rzc.sanlin.ODZhongtaiE200CarInfo;
import com.syu.carinfo.rzc.sanlin.PANissanAllCarSet;
import com.syu.carinfo.rzc.sanlin.RZCBeiqiBJ40CarSet;
import com.syu.carinfo.rzc.sanlin.RZCBeiqiBJ90CarSet;
import com.syu.carinfo.rzc.sanlin.RZCFengshenEX1CarInfo;
import com.syu.carinfo.rzc.sanlin.RZCHongqiH5CarSet;
import com.syu.carinfo.rzc.sanlin.RZCLeTinMangguoCarSet;
import com.syu.carinfo.rzc.sanlin.RZCMclarenCarSet;
import com.syu.carinfo.rzc.sanlin.RZCMzd3CarInfo;
import com.syu.carinfo.rzc.sanlin.RZCNissanAmpCarSet;
import com.syu.carinfo.rzc.sanlin.RZCNissanJUKECarSet;
import com.syu.carinfo.rzc.sanlin.RZCShanqiDelongCarInfo;
import com.syu.carinfo.rzc.sanlin.RZCXiandaiAmpCarSet;
import com.syu.carinfo.rzc.sanlin.RZCXiandaiRohensCarSet;
import com.syu.carinfo.rzc.sanlin.RzcBenzCCarSet;
import com.syu.carinfo.rzc.sanlin.SanlinCarSet;
import com.syu.carinfo.rzc.sanlin.SanlinIndexAct;
import com.syu.carinfo.rzc.sanlin.SanwuNissanAllCarSet;
import com.syu.carinfo.rzc.sanlin.TDPorscheCarSet;
import com.syu.carinfo.rzc.sanlin.WC2FordMDOCarSeatSet;
import com.syu.carinfo.rzc.sanlin.WC2IKCOAllCarSetAct;
import com.syu.carinfo.rzc.sanlin.WC2SanlinCarInfo;
import com.syu.carinfo.rzc.sanlin.WCJiliAllCarSet;
import com.syu.carinfo.rzc.sanlin.WCNissanCarSet;
import com.syu.carinfo.rzc.sanlin.WCOldJeepAmpSet;
import com.syu.carinfo.rzc.sanlin.WCPeroduaAllCarSet;
import com.syu.carinfo.rzc.sanlin.WCProtonAllCarSet;
import com.syu.carinfo.rzc.sanlin.WCSaipaShahinTireAct;
import com.syu.carinfo.rzc.sanlin.WCUAZPatriotCarSet;
import com.syu.carinfo.rzc.sanlin.WYBBACarInfo;
import com.syu.carinfo.rzc.sanlin.XBSNissanCedricCarSet;
import com.syu.carinfo.rzc.sanlin.XCBenzSmartCarSet;
import com.syu.carinfo.rzc.sanlin.XCFordEDGECarSet;
import com.syu.carinfo.rzc.sanlin.XCHondaAmpCarSet;
import com.syu.carinfo.rzc.sanlin.XPFordF150CarSet;
import com.syu.carinfo.rzc.sanlin.XPMeganeCarInfo;
import com.syu.carinfo.rzc.sanlin.XPNissanCarSet;
import com.syu.carinfo.rzc.sanlin.XPXiandaiCarSet;
import com.syu.carinfo.rzc.sanlin.ZHToyotaProaceCarSet;
import com.syu.carinfo.rzc.siwei.ODChangAnRaetonCarSet;
import com.syu.carinfo.rzc.siwei.RZCSiWeiCarSet;
import com.syu.carinfo.rzc.siwei.XCXiandaiSuolataCarSet;
import com.syu.carinfo.rzc.t70.ActivityNaZhiJie;
import com.syu.carinfo.rzc.t70.BNR_QiChenT70Act;
import com.syu.carinfo.rzc.t70.QiChenT70Act;
import com.syu.carinfo.rzc.xima.Acti_Xima_Xfy;
import com.syu.carinfo.rzc.xima.LZ_NIssanInfinitiIndexAct;
import com.syu.carinfo.rzc.xima.LZ_Nissan08TeanaIndexAct;
import com.syu.carinfo.rzc.xima.OD_NissanXimaCarinfoAct;
import com.syu.carinfo.rzc.xima.OD_NissanXimaIndexAct;
import com.syu.carinfo.rzc.xima.Rzc_80_DspinfoActi;
import com.syu.carinfo.rzc.xp.cs75.BnrChanganCX70IndexAct;
import com.syu.carinfo.rzc.xp.cs75.ChangAnCS75Act;
import com.syu.carinfo.rzc.xp.cs75.ChangAnOuShangAct;
import com.syu.carinfo.rzc.yingfeinidi_gx50.DJYage9CarSet;
import com.syu.carinfo.rzc.yingfeinidi_gx50.RZCBeiqiBj40CarSet;
import com.syu.carinfo.rzc.yingfeinidi_gx50.RZCBeiqiSuansuS7CarSet;
import com.syu.carinfo.rzc.yingfeinidi_gx50.Rzc_YingFeiNiDi_GX50_CarSettingAct;
import com.syu.carinfo.rzc.zhongtai.RzcChanganIndexAct;
import com.syu.carinfo.rzc.zhongtai.RzcChanganSetFunc;
import com.syu.carinfo.rzc.zhongtai.RzcChanganTireAct;
import com.syu.carinfo.rzc.zhongtai.RzcLandRoverIndexAct;
import com.syu.carinfo.rzc.zhongtai.RzcZhongtaiE200CarInfo;
import com.syu.carinfo.rzc.ziyouguang.RZC_JeepCarEQSet;
import com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_IndexAct;
import com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_Settings;
import com.syu.carinfo.saiou3.SaiOu3Index;
import com.syu.carinfo.sbd.ruifengs5.ActivityTireRuiFengS5;
import com.syu.carinfo.sbd.x80.Dongfeng_FullView_SBDAct;
import com.syu.carinfo.sbd.x80.TianLai09Act;
import com.syu.carinfo.sbd.x80.X80Act;
import com.syu.carinfo.sbd_electric.Sbd_IndexAct;
import com.syu.carinfo.toyota.tangdu.ToyotaTangduIndexAct;
import com.syu.carinfo.wc.axela.ActivityMzdAllHUDCarSet;
import com.syu.carinfo.wc.axela.ActivityMzdAllIndexAct;
import com.syu.carinfo.wc.benz.WCBenzSprinterCarSet;
import com.syu.carinfo.wc.bydyuan.BYDYuanCarSettingsAct;
import com.syu.carinfo.wc.changan.ActivityChangAn17CS75;
import com.syu.carinfo.wc.changan.ActivityChangAnCS75;
import com.syu.carinfo.wc.changan.WCChanganAllIndexAct;
import com.syu.carinfo.wc.changan.WCChanganAllTireAct;
import com.syu.carinfo.wc.crown.Wc_420_IndexAct;
import com.syu.carinfo.wc.ecosport18.Wc_21_EcosportSetAct;
import com.syu.carinfo.wc.feiyate.FYTOilMileIndexActi;
import com.syu.carinfo.wc.feiyate.WCFeiyateIndexAct;
import com.syu.carinfo.wc.gs4.GS4CarSettingsAct;
import com.syu.carinfo.wc.gs4.GS4IndexAct;
import com.syu.carinfo.wc.gs4.GS4SetAct_Bnr;
import com.syu.carinfo.wc.infeinidi.WcInfeinidiCarSet;
import com.syu.carinfo.wc.infeinidi.WcInfeonidiIndexAct;
import com.syu.carinfo.wc.infeinidi.WcInfinitCarTire;
import com.syu.carinfo.wc.jianghuai.WcJianghuaiIEV6EIndexAct;
import com.syu.carinfo.wc.jingyix5.JYIndexAct;
import com.syu.carinfo.wc.leinuo.DusterOilMileIndexActi;
import com.syu.carinfo.wc.leinuo.LeinuoGuanjingSetActi;
import com.syu.carinfo.wc.leinuo.Megane4SetActi;
import com.syu.carinfo.wc.nissan.Wc_322_DspinfoActi;
import com.syu.carinfo.wc.nissan.Wc_360_DspinfoActi;
import com.syu.carinfo.wc.nissan.Wc_443_TianlaiGongjueAct;
import com.syu.carinfo.wc.ruijie15.Focus19CarSetAct;
import com.syu.carinfo.wc.ruijie15.RJIndexAct;
import com.syu.carinfo.wc.ruijie15.RJXpCarSetAct;
import com.syu.carinfo.wc.ruiteng.MingjueZS_Wc;
import com.syu.carinfo.wc.ruiteng.RuiTengIndexActi;
import com.syu.carinfo.wc.sgmws.SgmwsAlarmInfoAct;
import com.syu.carinfo.wc.tianlai.ActivityWCTianLaiCarCD;
import com.syu.carinfo.wc.tianlaicd.WC08TianlaiIndexAct;
import com.syu.carinfo.wc.ziyouguang.Wc_372_FunctionalActi;
import com.syu.carinfo.wc.ziyouguang.Wc_372_IndexAct;
import com.syu.carinfo.wc2.ford.WC2FordLincoinCarSettingsAct;
import com.syu.carinfo.wc2.ford.WC2FordLincoinIndexAct;
import com.syu.carinfo.wc2.huangguan.WC209HuangguanEQAct;
import com.syu.carinfo.wc2.nazhijie.WCNazhijieU6CarSet;
import com.syu.carinfo.wc2.ruiqi.WCNissanRuiqi6IndexAct;
import com.syu.carinfo.wc2.tata.LZBMWMiniCarSet;
import com.syu.carinfo.wc2.tata.WC2MHDCarSet;
import com.syu.carinfo.wc2.tata.WC2TataCarSet;
import com.syu.carinfo.wccamry.Rav4TripAct;
import com.syu.carinfo.wccamry.Wc09LexusESEQActi;
import com.syu.carinfo.wccamry.Wc09LexusESIndexActi;
import com.syu.carinfo.xbs.accord9.XBSAccord9IndexActi;
import com.syu.carinfo.xbs.angkesaila.XBS_AngKeSaiLa_Cx4_IndexAct;
import com.syu.carinfo.xbs.gs3.GS3CarSettingsAct;
import com.syu.carinfo.xbs.gs3.GS3IndexAct;
import com.syu.carinfo.xbs.jeep.Activity_XBS_FunctionlActi;
import com.syu.carinfo.xbs.tianlai.XBS09TianlaiIndexAct;
import com.syu.carinfo.xbs.tule.XBSTuleDZSJIndexAct;
import com.syu.carinfo.xbs.tule.XBSTuleIndexAct;
import com.syu.carinfo.xbs.tule.XBSZTT600CarTire;
import com.syu.carinfo.xbs.xbshaimam8.XbsHaiMaM8IndexActi;
import com.syu.carinfo.xbs.yage8.XBS08YageIndexAct;
import com.syu.carinfo.xc.feiyatefeiyue.XCFeiyateFeiyueSetFunc;
import com.syu.carinfo.xc.gm.XC_GMandRongweiIndexAct;
import com.syu.carinfo.xc.lexus.XCLexusIndexAct;
import com.syu.carinfo.xc.tule.XCTuleCDIndexAct;
import com.syu.carinfo.xc.tule.XCTuleIndexAct;
import com.syu.carinfo.xfy.dx7.RzcDx7Settings;
import com.syu.carinfo.xfy.dx7.XfyDx7HistroyAct;
import com.syu.carinfo.xfy.dx7.XfyDx7IndexAct;
import com.syu.carinfo.xfy.dx7.XfyZhV3CarSet;
import com.syu.carinfo.xfy.guandao.ActivityGuanDaoIndex;
import com.syu.carinfo.xfy.psa.ActivityPSA3008Index;
import com.syu.carinfo.xfy.sanlingall.XFYSanLingAllEQAct;
import com.syu.carinfo.xfy.sr7.ActivitySR7Setting;
import com.syu.carinfo.xfy.sr7.ActivitySR7Setting_Bnr;
import com.syu.carinfo.xfy.xc60.Xc60SettingsAct;
import com.syu.carinfo.xincheng.infiniti.Infiniti_XinCheng_IndexAct;
import com.syu.carinfo.xincheng.infiniti.Nissan_Xiaoke_XinCheng_CarTire;
import com.syu.carinfo.xp.SanlinSeries.SanlinXPCarSet;
import com.syu.carinfo.xp.SanlinSeries.SanlinXPIndexAct;
import com.syu.carinfo.xp.psa_all.LZPsaAllIndexAct;
import com.syu.carinfo.xp.psa_all.XpPsaAllIndexActi;
import com.syu.carinfo.xp.psa_all.XpPsaAllOrinalCarActivity;
import com.syu.carinfo.xp.suburu.RZCSuburuCarSet;
import com.syu.carinfo.xp.suburu.SuburuCarSet;
import com.syu.carinfo.xp.yinglang.DjXp1_ParkAvenue_25to33_info;
import com.syu.carinfo.xp.yinglang.YLCarSettingsAct;
import com.syu.carinfo.xp.yinglang.YLIndexAct;
import com.syu.carinfo.xp.ziyouguang.Activity_287_Engine_Shotdown;
import com.syu.carinfo.xp.ziyouguang.Activity_424_ClioFuncSet;
import com.syu.carinfo.xp.ziyouguang.PAFordAllIndexActi;
import com.syu.carinfo.xp.ziyouguang.PAFord_FunctionlActi;
import com.syu.carinfo.xp.ziyouguang.PAJeepAllIndexActi;
import com.syu.carinfo.xp.ziyouguang.PAToyotaAllIndexActi;
import com.syu.carinfo.xp.ziyouguang.Xp_374_AegeaIndexActi;
import com.syu.carinfo.xp.ziyouguang.Xp_374_FunctionlActi;
import com.syu.carinfo.xp.ziyouguang.Xp_374_IndexActi;
import com.syu.carinfo.xp_angkesailam3.M3CarCD;
import com.syu.carinfo.zhtd.bmw.LZBenzSmartSetFunc;
import com.syu.carinfo.zhtd.bmw.LZNewAllBBASetFunc;
import com.syu.carinfo.zhtd.bmw.LZNewAllGMCSetFunc;
import com.syu.carinfo.zhtd.bmw.LZNewAllMazdaSetFunc;
import com.syu.carinfo.zhtd.bmw.LZNewLandRoverSetFunc;
import com.syu.carinfo.zhtd.bmw.YL6606NewVinFanAllSetFunc;
import com.syu.carinfo.zhtd.bmw.ZH2PilotcarCarinfoAct;
import com.syu.carinfo.zhtd.bmw.ZhtdBmwIndexFunc;
import com.syu.carinfo.zhtd.bmw.ZhtdBmwSetFunc;
import com.syu.carinfo.ztt600.IndexAct_Bnr;
import com.syu.carinfo.ztt600.IndexAct_Luz;
import com.syu.carinfo.ztt600.IndexAct_RZC;
import com.syu.carinfo.ztt600.ZTTireAct_Wc;
import com.syu.carinfo.zx6606.ZX6606HondaIndexActi;
import com.syu.module.canbus.FinalCanbus;
import com.syu.module.main.FinalShare;
import com.syu.canbus.FuncMain;
import java.io.BufferedReader;
import java.io.FileReader;

public class CanbusClasses extends AsyncTask<Void, Void, Void> {

	// Runs the canbus service in background
	
    private final Context mContext;
    private final SharedPreferences mPrefs;

    public CanbusClasses(Context context) {
        this.mContext = context;
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    protected Void doInBackground(Void... input) throws Exception {
    	launchCanbus();
        return null;
    }

    @Override
    protected void onBackgroundError(Exception e) {
    	launchCanbus();
    }
    
    public void launchCanbus() {
        Class<?> cls = null;
        switch (DataCanbus.DATA[1000]) {
            case 1:
            case FinalCanbus.CAR_WC1_Benz_Old /* 262145 */:
            case FinalCanbus.CAR_WC1_VW_Golf6_10_12 /* 327681 */:
            case FinalCanbus.CAR_WC1_VW_PASSAT_11_16 /* 393217 */:
            case FinalCanbus.CAR_WC1_VW_PASSAT_05_11 /* 458753 */:
            case FinalCanbus.CAR_WC1_VW_Sharan_12_18 /* 524289 */:
            case FinalCanbus.CAR_WC1_VW_Bora_08_10 /* 589825 */:
            case FinalCanbus.CAR_WC1_VW_Bora_11_18 /* 655361 */:
            case FinalCanbus.CAR_WC1_VW_Lavida_12_17 /* 720897 */:
            case FinalCanbus.CAR_WC1_VW_Gran_13_17 /* 786433 */:
            case FinalCanbus.CAR_WC1_VW_Santana_13_17 /* 851969 */:
            case FinalCanbus.CAR_WC1_VW_CC_10_12 /* 917505 */:
            case FinalCanbus.CAR_WC1_VW_CC_13_18 /* 983041 */:
            case FinalCanbus.CAR_WC1_VW_Polo_08_18 /* 1048577 */:
            case FinalCanbus.CAR_WC1_VW_Fabia_08_17 /* 1114113 */:
            case FinalCanbus.CAR_WC1_VW_Jetta_07_10 /* 1179649 */:
            case FinalCanbus.CAR_WC1_VW_Jetta_11_19 /* 1245185 */:
            case FinalCanbus.CAR_WC1_VW_Touran_08_15 /* 1310721 */:
            case FinalCanbus.CAR_WC1_VW_Cross_14_17 /* 1376257 */:
            case FinalCanbus.CAR_WC1_VW_Yeti_14_17 /* 1441793 */:
            case FinalCanbus.CAR_WC1_VW_Superb_09_13 /* 1507329 */:
            case FinalCanbus.CAR_WC1_VW_Rapid_13_19 /* 1572865 */:
            case FinalCanbus.CAR_WC1_VW_Spaceback_14_19 /* 1638401 */:
            case FinalCanbus.CAR_WC1_VW_Scirocco_08_10 /* 1703937 */:
            case FinalCanbus.CAR_WC1_VW_Scirocco_11_16 /* 1769473 */:
            case FinalCanbus.CAR_WC1_VW_Octavia_07_12 /* 1835009 */:
            case FinalCanbus.CAR_WC1_VW_Superb_13_15 /* 1900545 */:
            case FinalCanbus.CAR_WC1_VW_Sagitar_07_18 /* 1966081 */:
            case FinalCanbus.CAR_WC1_VW_TIGUAN_10_16 /* 2031617 */:
            case FinalCanbus.CAR_WC1_VW_MAGOTAN_07_10 /* 2097153 */:
            case FinalCanbus.CAR_WC1_VW_MAGOTAN_11_15 /* 2162689 */:
            case FinalCanbus.CAR_WC1_Benz_Smart_17_L /* 2228225 */:
                cls = DasAutoWcAct.class;
                break;
            case 2:
            case FinalCanbus.CAR_XP1_DaZhong_H /* 65538 */:
            case FinalCanbus.CAR_RZC_Audi_TT_08_13 /* 2424883 */:
            case FinalCanbus.CAR_RZC_Audi_A3_04_12 /* 2490419 */:
            case FinalCanbus.CAR_RZC_Audi_A4_03_07 /* 2555955 */:
            case FinalCanbus.CAR_RZC_Audi_Q3_13_18 /* 2883635 */:
            case FinalCanbus.CAR_RZC_Audi_Q5_10_18 /* 2949171 */:
            case FinalCanbus.CAR_RZC_BMW_320i_05_12 /* 3145779 */:
            case FinalCanbus.CAR_RZC_BMW_320i_05_12_H /* 3211315 */:
            case FinalCanbus.CAR_RZC_BMW_X1_12_14 /* 3538995 */:
            case FinalCanbus.CAR_RZC_BMW_X3_11_13 /* 3670067 */:
            case FinalCanbus.CAR_RZC_BMW_X3_13_16 /* 3735603 */:
            case FinalCanbus.CAR_RZC_BMW_X3_16_17 /* 3801139 */:
            case FinalCanbus.CAR_RZC_BMW_3_13_17 /* 3866675 */:
            case FinalCanbus.CAR_RZC_BMW_CCC /* 4128819 */:
            case FinalCanbus.CAR_RZC_Audi_R8_12 /* 4194355 */:
            case FinalCanbus.CAR_RZC_BMW_EVO /* 4390963 */:
            case FinalCanbus.CAR_RZC_BMW_E53 /* 4522035 */:
            case FinalCanbus.CAR_RZC_Audi_A4L_13 /* 4587571 */:
            case FinalCanbus.CAR_RZC_BMW_E53_H /* 4653107 */:
            case FinalCanbus.CAR_RZC_BMW_E39_L /* 4718643 */:
            case FinalCanbus.CAR_RZC_BMW_E39_H /* 4784179 */:
            case FinalCanbus.CAR_RZC_Audi_Q5L_18 /* 4849715 */:
            case FinalCanbus.CAR_RZC_Audi_A4L_22 /* 4915251 */:
            case FinalCanbus.CAR_RZC_Audi_RS3_17 /* 4980787 */:
            case FinalCanbus.CAR_RZC_Audi_A4L_17 /* 5046323 */:
                cls = DasAutoIndexAct.class;
                break;
            case 12:
            case 129:
                cls = Psa301IndexActi.class;
                break;
            case 14:
            case 48:
            case 49:
            case 116:
            case 319:
            case FinalCanbus.CAR_XP1_Focus2012_H /* 131094 */:
            case FinalCanbus.CAR_BNR_Yihu2012 /* 131120 */:
            case FinalCanbus.CAR_WC2_12RANGER /* 131391 */:
            case FinalCanbus.CAR_BNR_Yihu2012_H /* 196656 */:
            case FinalCanbus.CAR_WC2_12BT50 /* 196927 */:
            case FinalCanbus.CAR_CZH_RZC_YiHu2017_H /* 3932494 */:
                cls = FocusSyncBtActi.class;
                break;
            case 16:
            case FinalCanbus.CAR_RZC1_LZ_MZD3_5_H /* 131363 */:
                cls = MzdClockSetActi.class;
                break;
            case 17:
            case 160:
            case 437:
            case FinalCanbus.CAR_WC2_17MaiTeng /* 65553 */:
            case FinalCanbus.CAR_CYT_GaoErFu7 /* 65576 */:
            case FinalCanbus.CAR_WC2_17MaiTeng_H /* 131089 */:
            case FinalCanbus.CAR_CYT_GaoErFu7_M /* 131112 */:
            case FinalCanbus.CAR2_RZC_XP1_DaZhong_GaoErFu7_H /* 131232 */:
            case FinalCanbus.CAR_WC2_TuGuanL /* 196625 */:
            case FinalCanbus.CAR_CYT_GaoErFu7_H /* 196648 */:
            case FinalCanbus.CAR_RZC_XP1_MaiTeng /* 196768 */:
            case FinalCanbus.CAR_WC2_17KeDiYaKe /* 262161 */:
            case FinalCanbus.CAR_RZC_TuGuan_L /* 262304 */:
            case FinalCanbus.CAR_WC2_17TuAng /* 327697 */:
            case FinalCanbus.CAR_RZC_TuAng /* 327840 */:
            case FinalCanbus.CAR_RZC_DaZhong_MQB_SUP /* 458912 */:
            case FinalCanbus.CAR_WC2_17MaiTeng_DZSJ1 /* 524305 */:
            case FinalCanbus.CAR_RZC_DaZhong_MQB_SUP_H /* 524448 */:
            case FinalCanbus.CAR_WC2_MQB /* 589841 */:
            case FinalCanbus.CAR2_RZC_DaZhong_Tange /* 589984 */:
            case FinalCanbus.CAR_WC2_MQB_Hybrid /* 655377 */:
            case FinalCanbus.CAR2_RZC_DaZhong_MQB_E /* 655520 */:
            case FinalCanbus.CAR_WC2_MQB_AllView /* 720913 */:
            case FinalCanbus.CAR_RZC_TuGuan_L_20 /* 721056 */:
            case FinalCanbus.CAR_WC2_MQB_Golf_Sportsvan_16 /* 786449 */:
            case FinalCanbus.CAR_RZC_MQB_18_19Lavida_plus /* 786592 */:
            case FinalCanbus.CAR_WC2_MQB_Passat_17_18 /* 851985 */:
            case FinalCanbus.CAR_RZC_MQB_11_18Sagitar /* 852128 */:
            case FinalCanbus.CAR_WC2_MQB_Passat_19 /* 917521 */:
            case FinalCanbus.CAR_RZC_MQB_19Sagitar /* 917664 */:
            case FinalCanbus.CAR_WC2_MQB_Variant_16_18 /* 983057 */:
            case FinalCanbus.CAR_RZC_MQB_11_17Passat /* 983200 */:
            case FinalCanbus.CAR_WC2_MQB_Bora_19 /* 1048593 */:
            case FinalCanbus.CAR_RZC_MQB_19Passat /* 1048736 */:
            case FinalCanbus.CAR_WC2_MQB_CC_19 /* 1114129 */:
            case FinalCanbus.CAR_WC2_MQB_Polo_19 /* 1179665 */:
            case FinalCanbus.CAR_RZC_MQB_19Tharu /* 1179808 */:
            case FinalCanbus.CAR_WC2_MQB_Jetta_Brazil /* 1245201 */:
            case FinalCanbus.CAR_WC2_MQB_TIGUANL_17_20 /* 1310737 */:
            case FinalCanbus.CAR_RZC_MQB_14_19Golf7 /* 1310880 */:
            case FinalCanbus.CAR_WC2_MQB_TIGUANL_17_20_H /* 1376273 */:
            case FinalCanbus.CAR_RZC_MQB_19Bora /* 1376416 */:
            case FinalCanbus.CAR_WC2_MQB_Octavia_13_14 /* 1441809 */:
            case FinalCanbus.CAR_RZC_MQB_14_19Lamando /* 1441952 */:
            case FinalCanbus.CAR_WC2_MQB_Octavia_15_19 /* 1507345 */:
            case FinalCanbus.CAR_RZC_MQB_19Polo /* 1507488 */:
            case FinalCanbus.CAR_WC2_MQB_Superb_16_18 /* 1572881 */:
            case FinalCanbus.CAR_RZC_MQB_19CC /* 1573024 */:
            case FinalCanbus.CAR_WC2_MQB_KAMIQ_18 /* 1638417 */:
            case FinalCanbus.CAR_RZC_MQB_19T_Cross /* 1638560 */:
            case FinalCanbus.CAR_WC2_MQB_KAROQ_18_19 /* 1703953 */:
            case FinalCanbus.CAR_RZC_MQB_16_18TouranL /* 1704096 */:
            case FinalCanbus.CAR_WC2_MQB_Caravelle_14_18 /* 1769489 */:
            case FinalCanbus.CAR_RZC_MQB_17_18C_Trek /* 1769632 */:
            case FinalCanbus.CAR_WC2_MQB_Jetta_VS5_19 /* 1835025 */:
            case FinalCanbus.CAR_RZC_MQB_16_19Golf_jialv /* 1835168 */:
            case FinalCanbus.CAR_WC2_MQB_Lavida_plus_19 /* 1900561 */:
            case FinalCanbus.CAR_RZC_MQB_19T_ROC /* 1900704 */:
            case FinalCanbus.CAR_WC2_MQB_Sagitar_19 /* 1966097 */:
            case FinalCanbus.CAR_RZC_MQB_19Tayron /* 1966240 */:
            case FinalCanbus.CAR_WC2_MQB_Tharu_19 /* 2031633 */:
            case FinalCanbus.CAR_RZC_MQB_13_14Octavia /* 2031776 */:
            case FinalCanbus.CAR_WC2_MQB_T_Cross_19 /* 2097169 */:
            case FinalCanbus.CAR_RZC_MQB_15_19Octavia /* 2097312 */:
            case FinalCanbus.CAR_WC2_MQB_TouranL_16_18 /* 2162705 */:
            case FinalCanbus.CAR_RZC_MQB_13_15Superb /* 2162848 */:
            case FinalCanbus.CAR_WC2_MQB_Trek_17_18 /* 2228241 */:
            case FinalCanbus.CAR_RZC_MQB_16_18Superb /* 2228384 */:
            case FinalCanbus.CAR_WC2_MQB_Tange_19 /* 2293777 */:
            case FinalCanbus.CAR_RZC_MQB_18Kamiq /* 2293920 */:
            case FinalCanbus.CAR_WC2_MQB_Tayron_19 /* 2359313 */:
            case FinalCanbus.CAR_RZC_MQB_18_19Karoq /* 2359456 */:
            case FinalCanbus.CAR_WC2_MQB_Multivan_19 /* 2424849 */:
            case FinalCanbus.CAR_RZC_MQB_17_19Kodiaq /* 2424992 */:
            case FinalCanbus.CAR_WC2_MQB_Superb_Turkey /* 2490385 */:
            case FinalCanbus.CAR_RZC_MQB_14_18Caravan /* 2490528 */:
            case FinalCanbus.CAR_WC2_MQB_Huiang_21 /* 2555921 */:
            case FinalCanbus.CAR_RZC_MQB_19Jetta_VS5 /* 2556064 */:
            case FinalCanbus.CAR_WC2_MQB_Viloran_20 /* 2621457 */:
            case FinalCanbus.CAR_RZC_MQB_11_17Touareg /* 2621600 */:
            case FinalCanbus.CAR_WC2_MQB_Jetta_VS7_20 /* 2686993 */:
            case FinalCanbus.CAR_RZC_MQB_09_19Multivan /* 2687136 */:
            case FinalCanbus.CAR_WC2_MQB_Tayron_GTE_20 /* 2752529 */:
            case FinalCanbus.CAR_RZC_MQB_Jetta_Brazil /* 2752672 */:
            case FinalCanbus.CAR_WC2_MQB_Golf8_21 /* 2818065 */:
            case FinalCanbus.CAR_RZC_MQB_SUPERB_Turkey /* 2818208 */:
            case FinalCanbus.CAR_RZC_MQB_LAVIDA_19_E /* 2883744 */:
            case FinalCanbus.CAR_RZC_MQB_GOLF_20_E /* 2949280 */:
            case FinalCanbus.CAR_RZC_MQB_BORA_20_E /* 3014816 */:
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
                cls = Golf7IndexAct.class;
                break;
            case 19:
            case 64:
            case 65:
            case 117:
            case 166:
            case 192:
            case 297:
            case 370:
            case FinalCanbus.CAR_WC2_15_BinZhi_LOW /* 65728 */:
            case FinalCanbus.CAR_WC2_15_CRV_L /* 65833 */:
            case FinalCanbus.CAR_WC2_Honda_AllCom_FengFan /* 65857 */:
            case FinalCanbus.CAR_WC2_Honda_AllCom_H /* 131393 */:
            case FinalCanbus.CAR_WC2_Honda_AllCom_LINGPAI_LO /* 196929 */:
            case FinalCanbus.CAR_WC2_Honda_17Avancier_NoAmp /* 328001 */:
            case FinalCanbus.CAR_WC2_Honda_17Avancier_Amp /* 393537 */:
            case FinalCanbus.CAR_WC2_Honda_18Accod /* 721217 */:
                cls = HondaIndexActi.class;
                break;
            case 20:
            case FinalCanbus.CAR_XP1_Camry2013_H /* 131092 */:
            case FinalCanbus.CAR_XP1_XFY_SHUPING_KELUZE /* 196628 */:
            case FinalCanbus.CAR_XP1_XFY_SHUPING_COROLLA /* 262164 */:
            case FinalCanbus.CAR_XP1_16RAV4_VIEW /* 393236 */:
            case FinalCanbus.CAR_XP1_16RAV4_VIEW_AMP /* 458772 */:
            case FinalCanbus.CAR_XP1_Camry2018 /* 589844 */:
            case FinalCanbus.CAR_XP1_Camry2018_H /* 655380 */:
            case FinalCanbus.CAR_XYF_09Prado /* 2359316 */:
            case FinalCanbus.CAR_XYF_09Prado_AMP /* 2424852 */:
            case FinalCanbus.CAR_XP1_XFY_SHUPING_Benpaozhe /* 2555924 */:
            case FinalCanbus.CAR_XP1_TOYOTA_12Camry_SP /* 2686996 */:
            case FinalCanbus.CAR_XP1_TOYOTA_16CRUISER_SP /* 2752532 */:
            case FinalCanbus.CAR_XP1_TOYOTA_15Camry_SP /* 2818068 */:
            case FinalCanbus.CAR_XP1_TOYOTA_18Camry_SP /* 2883604 */:
            case FinalCanbus.CAR_XP1_TOYOTA_15Highlander_Hand_SP /* 2949140 */:
            case FinalCanbus.CAR_XP1_TOYOTA_15Highlander_AUTO_SP /* 3014676 */:
            case FinalCanbus.CAR_XP1_TOYOTA_14Tundra_Hand_SP /* 3080212 */:
            case FinalCanbus.CAR_XP1_TOYOTA_14Tundra_AUTO_SP /* 3145748 */:
            case FinalCanbus.CAR_XP1_TOYOTA_10Prado_SP /* 3211284 */:
            case FinalCanbus.CAR_XP1_14Prado_L /* 3276820 */:
            case FinalCanbus.CAR_XP1_14Prado_M /* 3342356 */:
            case FinalCanbus.CAR_XP1_14Prado_H /* 3407892 */:
            case FinalCanbus.CAR_ZH2_XP1_Toyota_All /* 3473428 */:
                cls = CamryIndexAct_XP.class;
                break;
            case 21:
            case FinalCanbus.CAR_WC2_MengDiOuZS2013_M /* 65557 */:
            case FinalCanbus.CAR_WC2_MengDiOuZS2013_H /* 131093 */:
            case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL /* 196629 */:
            case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL_M /* 262165 */:
            case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL_H /* 327701 */:
            case FinalCanbus.CAR_CZH_WC2_MengDiOuZS2013_M /* 589845 */:
                cls = WC2FordMDOCarSeatSet.class;
                break;
            case 22:
            case FinalCanbus.CAR_XP1_Ford_KUGA_2013 /* 65558 */:
            case FinalCanbus.CAR_XP1_Ford_Ecosport_2013 /* 196630 */:
            case FinalCanbus.CAR_XP1_Ford_Fiesta_2013 /* 262166 */:
            case FinalCanbus.CAR_XP1_Ford_CMAX_2013 /* 327702 */:
            case FinalCanbus.CAR_XP1_Ford_Focus_2015 /* 393238 */:
            case FinalCanbus.CAR_XP1_Ford_Tourneo_2015 /* 458774 */:
            case FinalCanbus.CAR_XP1_Ford_Transit_2015 /* 524310 */:
            case FinalCanbus.CAR_XP1_Ford_KUGA_2017 /* 589846 */:
                cls = ActivityIndex_14Festia.class;
                break;
            case 24:
            case 47:
            case FinalCanbus.CAR_RZC_SIYU2012 /* 65560 */:
            case FinalCanbus.CAR_XP1_CRV2012_BNR /* 131119 */:
            case FinalCanbus.CAR_RZC_CRV2012 /* 196655 */:
                cls = XpCrvActi.class;
                break;
            case 25:
            case 26:
            case 253:
            case 263:
            case 309:
            case 359:
            case FinalCanbus.CAR_XP1_GM_H1 /* 65561 */:
            case FinalCanbus.CAR_XP1_MaiRuiBao16_M /* 65895 */:
            case FinalCanbus.CAR_XP1_GM_H2 /* 131097 */:
            case FinalCanbus.CAR_XP1_MaiRuiBao16_H /* 131431 */:
            case FinalCanbus.CAR_XP1_GM_H3 /* 196633 */:
            case FinalCanbus.CAR_XP1_MaiRuiBao16_XL_L /* 196967 */:
            case FinalCanbus.CAR_XP1_GM_Camaro_10 /* 262169 */:
            case FinalCanbus.CAR_RZC_17Gl8 /* 262407 */:
            case FinalCanbus.CAR_XP1_MaiRuiBao16_XL_H /* 262503 */:
            case FinalCanbus.CAR_RZC_ALL_GM_11_15GL8 /* 327943 */:
            case FinalCanbus.CAR_DJ_XP1_JunYue /* 393241 */:
            case FinalCanbus.CAR_RZC_17_18GL8_ES_28T /* 393479 */:
            case FinalCanbus.CAR_RZC_18_19Excelle_GT /* 459015 */:
            case FinalCanbus.CAR_RZC_20GL8_652T /* 524551 */:
            case FinalCanbus.CAR_RZC_20GL8_652T_H /* 590087 */:
            case FinalCanbus.CAR_RZC_15GL8_24_H /* 655623 */:
            case FinalCanbus.CAR_RZC_21YingLang_CD /* 721159 */:
            case FinalCanbus.CAR_RZC_21YingLang /* 786695 */:
            case FinalCanbus.CAR_XP1_GM_AJcd600 /* 2228249 */:
            case FinalCanbus.CAR_DJ_Saiou3 /* 2359321 */:
            case FinalCanbus.CAR_DJ_GM_ALL /* 2424857 */:
            case FinalCanbus.CAR_XP1_GM_AJcd650 /* 2490393 */:
            case FinalCanbus.CAR_XP1_GM_Opel_Meriva /* 2621465 */:
                cls = YLIndexAct.class;
                break;
            case 31:
            case 355:
            case FinalCanbus.CAR_XP1_XiandaiIX45_M /* 65567 */:
            case FinalCanbus.CAR_XP_QiYaK5_M /* 65891 */:
            case FinalCanbus.CAR_XP1_XiandaiIX45_H /* 131103 */:
            case FinalCanbus.CAR_XP_QiYaK5_H /* 131427 */:
            case FinalCanbus.CAR_355_XP_XIANDAI_19SDF /* 721251 */:
            case FinalCanbus.CAR_355_XP_XIANDAI_19SDF_H /* 786787 */:
            case FinalCanbus.CAR_355_XP_XIANDAI_19SDF_TOP /* 852323 */:
            case FinalCanbus.CAR_XP_XIANDAI_ALl /* 917859 */:
            case FinalCanbus.CAR_XP_XIANDAI_ALl_H /* 983395 */:
            case FinalCanbus.CAR_XP_XIANDAI_ALl_TOP /* 1048931 */:
            case FinalCanbus.CAR_XP_XIANDAI_ALl_IX45_H /* 1114467 */:
            case FinalCanbus.CAR_XP_XIANDAI_ALl_BORREGO /* 1180003 */:
            case FinalCanbus.CAR_XP_XIANDAI_19ALl /* 1245539 */:
            case FinalCanbus.CAR_XP_XIANDAI_19ALl_H /* 1311075 */:
            case FinalCanbus.CAR_XP_XIANDAI_19ALl_TOP /* 1376611 */:
            case FinalCanbus.CAR_XP_18QiYaK5 /* 1507683 */:
            case FinalCanbus.CAR_XP_18QiYaK5_M /* 1573219 */:
            case FinalCanbus.CAR_XP_18QiYaK5_H /* 1638755 */:
            case FinalCanbus.CAR_XP_16QiYaKX5 /* 1704291 */:
            case FinalCanbus.CAR_XP_16QiYaKX5_M /* 1769827 */:
            case FinalCanbus.CAR_XP_16QiYaKX5_H /* 1835363 */:
            case FinalCanbus.CAR_XP_19QiYa_Sportage_M /* 1900899 */:
            case FinalCanbus.CAR_XP_19QiYa_Sportage_H /* 1966435 */:
            case FinalCanbus.CAR_XP_19QiYa_Sportage_L /* 2097507 */:
            case FinalCanbus.CAR_XP_18KIA_carnival /* 2163043 */:
            case FinalCanbus.CAR_XP_16QiYaKX5_H_Noamp /* 2228579 */:
                cls = XP_19ShengDafei_CarSettingAct.class;
                break;
            case 35:
            case 306:
            case FinalCanbus.CAR_RZCexc_Lifan650EV /* 65842 */:
                cls = LiFan720IndexAct.class;
                break;
            case 36:
            case 254:
            case 308:
            case 345:
            case 357:
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
            case FinalCanbus.CAR_WC2_GM_Enclave /* 589860 */:
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
                cls = KlcIndexAct.class;
                break;
            case 37:
            case FinalCanbus.CAR_WC2_Accord9_H /* 131109 */:
                cls = Accord9HIndexAct.class;
                break;
            case 38:
            case 231:
            case 327:
            case 363:
            case 423:
            case 427:
            case 433:
            case FinalCanbus.CAR_WC1_CYT_ShuPing_07_11_MENGDIOU /* 65759 */:
            case FinalCanbus.CAR_DJ_MENGDIOU2013_H /* 65767 */:
            case FinalCanbus.CAR_DJ_ShuPing_MENGDIOU /* 65836 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ShuPingNewJunWei_M /* 65899 */:
            case FinalCanbus.CAR_XFY_XP1_ChangAnCsSerial /* 65942 */:
            case FinalCanbus.CAR_CYT_YaGe7_Portrait /* 65953 */:
            case FinalCanbus.CAR_CYT_ShuPing_QiYaK3_H /* 65959 */:
            case FinalCanbus.CAR_XFY_SHUPING_K3_M /* 65963 */:
            case FinalCanbus.CAR_WC1_Nawala_Philippine /* 131110 */:
            case FinalCanbus.CAR_WC1_ShuPing_ZhiSheng_High /* 131295 */:
            case FinalCanbus.CAR_CYT_ShuPing_HavalH2 /* 131316 */:
            case FinalCanbus.CAR_XFY_SHUPING_K3_H /* 131499 */:
            case FinalCanbus.CAR_XP1_QiJun_CYT_ZIDONG /* 196751 */:
            case FinalCanbus.CAR_DJ_ShuPing_BYD_G6 /* 196759 */:
            case FinalCanbus.CAR_CYT_SHuPing_SoNaTa8 /* 196776 */:
            case FinalCanbus.CAR_CYT_OuLande_L /* 196833 */:
            case FinalCanbus.CAR_CYT_ShuPing_HavalH2_H /* 196852 */:
            case FinalCanbus.CAR_XFY_ZhongHuaV3 /* 196934 */:
            case FinalCanbus.CAR_CYT_YaGe8 /* 197025 */:
            case FinalCanbus.CAR_WC2_HavalH2_CYT_AIR /* 262276 */:
            case FinalCanbus.CAR_XP1_QiJun_CYT_ZIDONG_H /* 262287 */:
            case FinalCanbus.CAR_CYT_SHuPing_SoNaTa8_H /* 262312 */:
            case FinalCanbus.CAR_CYT_OuLande_H /* 262369 */:
            case FinalCanbus.CAR_DJ_Shuping_YEMA /* 262444 */:
            case FinalCanbus.CAR_WC_16_QiYaKX5_WITH_CYT_SHUPING_K3AIR /* 262538 */:
            case FinalCanbus.CAR_XFY_ShuPing_Honda_06CRV /* 262569 */:
            case FinalCanbus.CAR_455_RZC_Nissan_Tuda_SP_18 /* 262599 */:
            case FinalCanbus.CAR_WC2_ShuPing_Prado_L /* 327801 */:
            case FinalCanbus.CAR_WC2_HavalH2_CYT_AIR_H /* 327812 */:
            case FinalCanbus.CAR_XP1_QiJun_CYT_SHOUDONG /* 327823 */:
            case FinalCanbus.CAR_CYT_SHuPing_SoNaTa8_D /* 327848 */:
            case FinalCanbus.CAR_455_RZC_Nissan_Tuda_SP_18_Auto /* 328135 */:
            case FinalCanbus.CAR_WC2_ShuPing_14Prado_L /* 393337 */:
            case FinalCanbus.CAR_BNR_ShuPing_Sonata8 /* 393571 */:
            case FinalCanbus.CAR_XP1_CYT_XuanYi_L /* 458895 */:
            case FinalCanbus.CAR_BNR_ShuPing_Sonata8_AMP /* 459107 */:
            case FinalCanbus.CAR_XP1_CYT_XuanYi_H /* 524431 */:
            case FinalCanbus.CAR_WeiChi2_NewJunYue /* 524605 */:
            case FinalCanbus.CAR_WC2_ShuPing_Prado_Luxun_ZiDong /* 589945 */:
            case FinalCanbus.CAR_355_HC_XIANDAI /* 590179 */:
            case FinalCanbus.CAR_WC2_ShuPing_Prado_Luxun_ZiDongRight /* 655481 */:
            case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng /* 655708 */:
            case FinalCanbus.CAR_355_HC_XIANDAI_AMP /* 655715 */:
            case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng1 /* 721244 */:
            case FinalCanbus.CAR_455_RZC_Mclaren_12C /* 721351 */:
            case FinalCanbus.CAR_DAOJUN_14Junwei_Luzheng2 /* 786780 */:
            case FinalCanbus.CAR_439_Oudi_Haval_H3 /* 1704375 */:
            case FinalCanbus.CAR_444_WC2_ChangfengLiebao_CS9_17 /* 1769916 */:
            case FinalCanbus.CAR_452_Mixun_Liebao_CS9 /* 2687428 */:
            case FinalCanbus.CAR_439_HC_OuGeTL /* 3998135 */:
            case FinalCanbus.CAR_RZC_ALL_GM_Enclave_SP /* 4980797 */:
            case FinalCanbus.CAR_439_RZC_14QiJun_Auto /* 5374391 */:
            case FinalCanbus.CAR_439_RZC_14QiJun_Hand /* 5439927 */:
            case FinalCanbus.CAR_439_RZC_16Xiaoke_Auto /* 5505463 */:
            case FinalCanbus.CAR_439_RZC_16Xiaoke_Hand /* 5570999 */:
            case FinalCanbus.CAR_439_RZC_13Tianlai_Auto /* 5636535 */:
            case FinalCanbus.CAR_439_RZC_13Tianlai_Hand /* 5702071 */:
            case FinalCanbus.CAR_439_RZC_08Tianlai_Auto /* 5767607 */:
            case FinalCanbus.CAR_452_CYT_Hyundai_VERACRUZ /* 5767620 */:
            case FinalCanbus.CAR_439_RZC_08Tianlai_Hand /* 5833143 */:
            case FinalCanbus.CAR_439_RZC_16Qida_Auto /* 5898679 */:
            case FinalCanbus.CAR_439_RZC_16Qida_Hand /* 5964215 */:
            case FinalCanbus.CAR_452_ZH_PAJERO_SP /* 5964228 */:
            case FinalCanbus.CAR_439_HC_TianLai_GongJue /* 6095287 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_07Shengda /* 6422971 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_12SORENTO /* 6488507 */:
            case FinalCanbus.CAR_439_HC_Nissan_XiaoKe /* 6685111 */:
            case FinalCanbus.CAR_BNR_02_09Toyato_Prado /* 7668151 */:
            case FinalCanbus.CAR_452_TangDu_Nissan_Tuda_Hand /* 7668164 */:
            case FinalCanbus.CAR_452_TangDu_Nissan_Tuda_Auto /* 7733700 */:
            case FinalCanbus.CAR_454_RZC_Nissan_Loulan_SP /* 9241030 */:
            case FinalCanbus.CAR_452_LZ_Audi_A3_SP /* 9306564 */:
            case FinalCanbus.CAR_454_RZC_Nissan_Nawala_SP /* 9306566 */:
            case FinalCanbus.CAR_452_LZ_Audi_A4_SP /* 9372100 */:
            case FinalCanbus.CAR_454_RZC_Nissan_Loulan_SP_Auto /* 9372102 */:
            case FinalCanbus.CAR_452_LZ_Audi_TT_SP /* 9437636 */:
            case FinalCanbus.CAR_454_RZC_Nissan_Nawala_SP_Auto /* 9437638 */:
            case FinalCanbus.CAR_452_LZ_Audi_A3_SP_H /* 11076036 */:
            case FinalCanbus.CAR_452_LZ_Audi_A4_SP_H /* 11141572 */:
            case FinalCanbus.CAR_452_LZ_Audi_TT_SP_H /* 11207108 */:
            case FinalCanbus.CAR_439_DJ_06_09Kayan /* 12911031 */:
            case FinalCanbus.CAR_452_CYT_Toyota_Tundra /* 13959620 */:
            case FinalCanbus.CAR_452_CYT_Toyota_Tundra_H /* 14025156 */:
            case FinalCanbus.CAR_439_DJ_Siyu /* 14549431 */:
            case FinalCanbus.CAR_453_OD_Beiqi_Changhe_Q7_SP /* 15925701 */:
            case 39:
            case FinalCanbus.CAR_RZCexc_FeiyateZhiyue /* 65575 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_FLORLNO /* 327719 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_LINEA /* 458791 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_PUNTO /* 524327 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_11Bravo /* 655399 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_BRAVO_12 /* 917543 */:
            case FinalCanbus.CAR_RZCexc_FeiyateZhiyue_M /* 1310759 */:
            case FinalCanbus.CAR_RZCexc_FeiyateZhiyue_H /* 1376295 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_FLORLNO_M /* 1703975 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_FLORLNO_H /* 1769511 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_LINEA_M /* 1966119 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_LINEA_H /* 2031655 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_PUNTO_M /* 2097191 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_PUNTO_H /* 2162727 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_11Bravo_M /* 2359335 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_11Bravo_H /* 2424871 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_BRAVO_12_M /* 2490407 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_BRAVO_12_H /* 2555943 */:
            case FinalCanbus.CAR_RZCexc_FeiyateFeixiang_M /* 3014695 */:
            case FinalCanbus.CAR_RZCexc_FeiyateFeixiang_H /* 3080231 */:
                cls = RzcFYTOilMileIndexActi.class;
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
                cls = Golf7_XP_IndexAct.class;
                break;
            case 41:
            case 77:
            case FinalCanbus.CAR_BNR_ACCORD9_Lo /* 65577 */:
            case FinalCanbus.CAR_XP1_ACCORD9_L /* 65613 */:
            case FinalCanbus.CAR_BNR_ACCORD9_H /* 131149 */:
            case FinalCanbus.CAR_BNR_ACCORD9_L /* 196685 */:
            case FinalCanbus.CAR_BNR_HONDA_Crosstour /* 262221 */:
                cls = XPAccord9IndexActi.class;
                break;
            case 42:
            case 59:
            case FinalCanbus.CAR_WC2_16_ACCORD9_Lo /* 65578 */:
            case FinalCanbus.CAR_WC2_16_ACCORD9_NotBackCar_Lo /* 131114 */:
                cls = Accord9LowIndexAct.class;
                break;
            case 44:
            case 45:
            case FinalCanbus.CAR_CYT_GaoErFu7_Lo /* 65580 */:
                cls = Golf7OilMileagePage1LowActi.class;
                break;
            case 51:
            case 261:
            case 369:
            case 438:
            case FinalCanbus.CAR_CYT_DaZhongZiDongKongTiao_H /* 65905 */:
            case FinalCanbus.CAR_438_BNR_DaZhong_H /* 65974 */:
            case FinalCanbus.CAR_RZC_DaZhong_H /* 131123 */:
            case FinalCanbus.CAR_CYT_LangYi_L /* 131441 */:
            case FinalCanbus.CAR_RZC_DaZhong_SUP /* 196659 */:
            case FinalCanbus.CAR_CYT_LangYi_H /* 196977 */:
            case FinalCanbus.CAR_RZC_DaZhong_SUP_H /* 262195 */:
            case FinalCanbus.CAR_CYT_ShouDongKongTiao /* 262513 */:
            case FinalCanbus.CAR_RCW_DaZhong_07_11Maiteng /* 327731 */:
            case FinalCanbus.CAR_RCW_DaZhong_07_11Maiteng_H /* 393267 */:
            case FinalCanbus.CAR_RZC_DaZhong_SUP_M /* 458803 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_07_10Suteng /* 524339 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_05_11Pasate /* 589875 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_07_10Maiteng /* 655411 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_10_12Gaoerfu6 /* 720947 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_08_10Gaoerfu6 /* 786483 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_07_12Mingrui /* 852019 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_07_10Jieda /* 917555 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_10_12CC /* 983091 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_08_10Shangku /* 1048627 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_08_10Langyi /* 1114163 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_13_17Langyi /* 1179699 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_11_18Baolai /* 1245235 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_08_18Polo /* 1310771 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_13_18CC /* 1376307 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_13_18Sangtana /* 1441843 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_13_17langxing /* 1507379 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_14_17langJing /* 1572915 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_08_15Tuan /* 1638451 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_11_19Jieda /* 1703987 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_08_17Jingrui /* 1769523 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_14_19Xindong /* 1835059 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_13_19XinRui /* 1900595 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_09_13HaoRui /* 1966131 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_14_17Yedi /* 2031667 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_12_18Xialang /* 2162739 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_11_16Shangku /* 2228275 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_11_16Passat /* 2293811 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_10_15Tiguan /* 2359347 */:
            case FinalCanbus.CAR_RCW_Audi_Q5 /* 2687027 */:
            case FinalCanbus.CAR_RCW_Audi_Q5_H /* 2752563 */:
            case FinalCanbus.CAR_RZC_PQ_11_15Magotan_B7 /* 2818099 */:
            case FinalCanbus.CAR_RZC_BMW_318i_05_12 /* 3014707 */:
            case FinalCanbus.CAR_RZC_BMW_318i_05_12_H /* 3080243 */:
            case FinalCanbus.CAR_RZC_BMW_3_98_06 /* 3276851 */:
            case FinalCanbus.CAR_RZC_BMW_5_95_03 /* 3342387 */:
            case FinalCanbus.CAR_RZC_BMW_X5_99_06 /* 3407923 */:
            case FinalCanbus.CAR_RZC_BMW_X3_06_10 /* 3604531 */:
            case FinalCanbus.CAR_OD_Audi_A3 /* 3932211 */:
            case FinalCanbus.CAR_OD_Audi_A4 /* 3997747 */:
            case FinalCanbus.CAR_OD_Audi_TT /* 4063283 */:
            case FinalCanbus.CAR_XC_Ford_ForexClub /* 4259891 */:
            case FinalCanbus.CAR_RZC_SSANGYONG_TIVOLAN /* 4325427 */:
            case FinalCanbus.CAR_RZC_JH_All /* 4456499 */:
                cls = DasAutoXpAct.class;
                break;
            case 56:
                cls = Psa2008IndexActi.class;
                break;
            case 58:
                cls = XbsHaiMaM8IndexActi.class;
                break;
            case 61:
            case FinalCanbus.CAR_RZC_XP1_GM_1 /* 65597 */:
            case FinalCanbus.CAR_RZC_XP1_GM_2 /* 131133 */:
            case FinalCanbus.CAR_RZC_XP1_GM_3 /* 196669 */:
            case FinalCanbus.CAR_RZC_XP1_GM_4 /* 262205 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_5 /* 327741 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_6 /* 393277 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_7 /* 458813 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_8 /* 524349 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_9 /* 589885 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_10 /* 655421 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_11 /* 720957 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_12 /* 786493 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_13 /* 852029 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_14 /* 917565 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_15 /* 983101 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_16 /* 1048637 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_17 /* 1114173 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_18 /* 1179709 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_19 /* 1245245 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_20 /* 1310781 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_21 /* 1376317 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_22 /* 1441853 */:
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
            case FinalCanbus.CAR_RZC_ALL_GM_SP_35 /* 2293821 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_36 /* 2359357 */:
            case FinalCanbus.CAR_RZC_ALL_GM_SP_37 /* 2424893 */:
            case FinalCanbus.CAR_RZC_ALL_GM_18Excelle /* 2490429 */:
            case FinalCanbus.CAR_RZC_ALL_GM_09_19Regal /* 2555965 */:
            case FinalCanbus.CAR_RZC_ALL_GM_14_18Trax /* 2621501 */:
            case FinalCanbus.CAR_RZC_ALL_GM_14_18Envision /* 2687037 */:
            case FinalCanbus.CAR_RZC_ALL_GM_16_18Verano_GS /* 2752573 */:
            case FinalCanbus.CAR_RZC_ALL_GM_17_19Equinox /* 2818109 */:
            case FinalCanbus.CAR_RZC_ALL_GM_09_17Cruze /* 2883645 */:
            case FinalCanbus.CAR_RZC_ALL_GM_10_14Excelle /* 2949181 */:
            case FinalCanbus.CAR_RZC_ALL_GM_11_14Aveo /* 3014717 */:
            case FinalCanbus.CAR_RZC_ALL_GM_19Trailblazer /* 3080253 */:
            case FinalCanbus.CAR_RZC_ALL_GM_20Encore_GX /* 3145789 */:
            case FinalCanbus.CAR_RZC_ALL_GM_18Excelle_GX /* 3211325 */:
            case FinalCanbus.CAR_RZC_ALL_GM_18_19_GL6 /* 3276861 */:
            case FinalCanbus.CAR_RZC_ALL_GM_16_20Cavalier /* 3342397 */:
            case FinalCanbus.CAR_RZC_ALL_GM_16_18LovaRV /* 3407933 */:
            case FinalCanbus.CAR_RZC_ALL_GM_19Monza /* 3473469 */:
            case FinalCanbus.CAR_RZC_ALL_GM_19Trax /* 3539005 */:
            case FinalCanbus.CAR_RZC_ALL_GM_20Encore /* 3604541 */:
            case FinalCanbus.CAR_RZC_ALL_GM_11_17AstraJ /* 3670077 */:
            case FinalCanbus.CAR_RZC_ALL_GM_17_19CorsaE /* 3735613 */:
            case FinalCanbus.CAR_RZC_ALL_GM_15_19Insignia /* 3801149 */:
            case FinalCanbus.CAR_RZC_ALL_GM_20Envision /* 4063293 */:
            case FinalCanbus.CAR_RZC_ALL_GM_63 /* 4128829 */:
            case FinalCanbus.CAR_RZC_ALL_GM_Menlo_EV /* 4194365 */:
            case FinalCanbus.CAR_RZC_ALL_GM_21Monza /* 4259901 */:
            case FinalCanbus.CAR_RZC_ALL_GM_19Lacrosse_EV /* 4325437 */:
            case FinalCanbus.CAR_RZC_ALL_GM_20Regal_GS /* 4390973 */:
            case FinalCanbus.CAR_RZC_ALL_GM_12_13Regal_GS /* 4456509 */:
            case FinalCanbus.CAR_RZC_ALL_GM_10Enclave /* 4522045 */:
            case FinalCanbus.CAR_RZC_ALL_GM_15GL8_Top /* 4587581 */:
            case FinalCanbus.CAR_RZC_XP1_GM_3_20 /* 4784189 */:
            case FinalCanbus.CAR_RZC_ALL_GM_20Regal /* 4849725 */:
            case FinalCanbus.CAR_RZC_ALL_GM_20Equinox /* 4915261 */:
            case FinalCanbus.CAR_RZC_ALL_GM_Menlo_EV_L /* 5046333 */:
            case FinalCanbus.CAR_RZC_ALL_GM_Laccrose_15_H /* 5111869 */:
            case FinalCanbus.CAR_RZC_ALL_GM_Verano_22_L /* 5177405 */:
            case FinalCanbus.CAR_RZC_ALL_GM_Laccrose_10_L /* 5242941 */:
            case FinalCanbus.CAR_RZC_ALL_GM_HUMMER_09_H2 /* 5308477 */:
            case FinalCanbus.CAR_RZC_ALL_GM_Chevrolet_12 /* 5374013 */:
            case FinalCanbus.CAR_RZC_CYC_GM_All /* 5439549 */:
            case FinalCanbus.CAR_RZC_ALL_GM_11_17AstraK /* 5505085 */:
            case FinalCanbus.CAR_RZC_ALL_GM_13_16Mokka /* 5570621 */:
            case FinalCanbus.CAR_RZC_ALL_GM_11_MerivaB /* 5767229 */:
            case FinalCanbus.CAR_RZC_ALL_GM_23ONIX /* 6357053 */:
            case FinalCanbus.CAR_RZC_XP1_MaiRuiBao16 /* 6422589 */:
            case FinalCanbus.CAR_RZC_XP1_16_18MaiRuiBaoXL /* 6488125 */:
            case FinalCanbus.CAR_RZC_XP1_19MaiRuiBaoXL /* 6553661 */:
            case FinalCanbus.CAR_RZC_ALL_GM_11_17AstraJ_H /* 6619197 */:
            case FinalCanbus.CAR_RZC_ALL_GM_11_12Insignia_L /* 6684733 */:
            case FinalCanbus.CAR_RZC_ALL_GM_11_12Insignia_H /* 6750269 */:
            case FinalCanbus.CAR_RZC_ALL_GM_18_23Suburban /* 6815805 */:
            case FinalCanbus.CAR_RZC_ALL_GM_22Colorado /* 6881341 */:
            case FinalCanbus.CAR_RZC_ALL_GM_18Traverse /* 6946877 */:
            case FinalCanbus.CAR_RZC_ALL_GM_12_19Silverado /* 7012413 */:
            case FinalCanbus.CAR_RZC_ALL_GM_13_14Yukon /* 7077949 */:
            case FinalCanbus.CAR_RZC_ALL_GMC_18_23Terrain /* 7143485 */:
            case FinalCanbus.CAR_RZC_ALL_GMC_15_17Sierra /* 7209021 */:
            case FinalCanbus.CAR_RZC_ALL_GM_22VELITE6_EV /* 7274557 */:
            case FinalCanbus.CAR_RZC_ALL_GM_22VELITE6_PHEV /* 7340093 */:
            case FinalCanbus.CAR_RZC_ALL_GM_18_23Suburban_H /* 7405629 */:
            case FinalCanbus.CAR_RZC_ALL_GM_10_23Suburban /* 7471165 */:
            case FinalCanbus.CAR_RZC_ALL_GM_10_23Suburban_H /* 7536701 */:
            case FinalCanbus.CAR_RZC_ALL_GM_18Traverse_H /* 7602237 */:
            case FinalCanbus.CAR_RZC_ALL_GMC_15_17Sierra_H /* 7667773 */:
            case FinalCanbus.CAR_RZC_ALL_GM_12_19Silverado_H /* 7733309 */:
            case FinalCanbus.CAR_RZC_ALL_GMC_18_23Terrain_H /* 7798845 */:
            case FinalCanbus.CAR_RZC_ALL_GMC_10_17Terrain /* 7864381 */:
            case FinalCanbus.CAR_RZC_ALL_GMC_10_17Terrain_H /* 7929917 */:
            case FinalCanbus.CAR_RZC_ALL_GMC_10_17Equinox /* 7995453 */:
            case FinalCanbus.CAR_RZC_ALL_GMC_10_17Equinox_H /* 8060989 */:
            case FinalCanbus.CAR_RZC_ALL_GM_22Colorado_H /* 8126525 */:
            case FinalCanbus.CAR_RZC_ALL_GM_21Silverado /* 8192061 */:
            case FinalCanbus.CAR_RZC_ALL_GM_21Silverado_H /* 8257597 */:
            case FinalCanbus.CAR_RZC_ALL_GMC_19_20Sierra /* 8323133 */:
            case FinalCanbus.CAR_RZC_ALL_GMC_19_20Sierra_H /* 8388669 */:
            case FinalCanbus.CAR_RZC_ALL_GM_24Onix /* 8454205 */:
            case FinalCanbus.CAR_RZC_ALL_GM_23BOIT /* 8519741 */:
            case FinalCanbus.CAR_RZC_ALL_GM_23Regal /* 8585277 */:
            case FinalCanbus.CAR_RZC_ALL_GM_23Lacrosse /* 8650813 */:
            case FinalCanbus.CAR_RZC_ALL_GM_23Equinox /* 8716349 */:
            case FinalCanbus.CAR_RZC_ALL_GM_23MaiRuiBaoXL /* 8781885 */:
            case FinalCanbus.CAR_RZC_ALL_GM_23ChevroletBlazer /* 8847421 */:
                cls = RzcKlcIndex.class;
                break;
            case 67:
            case 76:
                cls = WcCrvActi.class;
                break;
            case 68:
            case FinalCanbus.CAR_RZC_XP1_ROEWE550_13_15 /* 65604 */:
                cls = ActRongwei550CarSet.class;
                break;
            case 70:
            case FinalCanbus.CAR_RZC_XP1_17CHANGANCS75 /* 65606 */:
            case FinalCanbus.CAR_RZC_XP1_17YCHANGANCS55 /* 327750 */:
            case FinalCanbus.CAR_BNR_16CS75_L /* 393286 */:
            case FinalCanbus.CAR_BNR_16CS75_M /* 458822 */:
            case FinalCanbus.CAR_BNR_16CS75_H_RightCamera /* 524358 */:
            case FinalCanbus.CAR_BNR_16CS75_H_FullView /* 589894 */:
            case FinalCanbus.CAR_BNR_17CS75 /* 655430 */:
            case FinalCanbus.CAR_OD_18YIDONG /* 720966 */:
            case FinalCanbus.CAR_OD_18YIDONG_H /* 786502 */:
            case FinalCanbus.CAR_RZC_XP1_17CHANGANCS75_H /* 852038 */:
            case FinalCanbus.CAR_BNR_17CS35 /* 1179718 */:
            case FinalCanbus.CAR_BNR_17CS55 /* 1245254 */:
            case FinalCanbus.CAR_BNR_17CS95 /* 1310790 */:
            case FinalCanbus.CAR_RZC_17CHANGANCS35 /* 1507398 */:
            case FinalCanbus.CAR_RZC_16_17CHANGANCS15 /* 1572934 */:
            case FinalCanbus.CAR_RZC_15_17CHANGAN_YD /* 1638470 */:
            case FinalCanbus.CAR_RZC_XP1_17YCHANGANCS55_H /* 1704006 */:
                cls = ChangAnCS75Act.class;
                break;
            case 79:
            case FinalCanbus.CAR_RZC1_MZD3_5_H /* 65827 */:
                cls = MzdRZCM3ClockSetActi.class;
                break;
            case 80:
            case FinalCanbus.CAR_RZC_XP1_QiJun_H /* 131152 */:
            case FinalCanbus.CAR_RZC_SeMar_NoAmp /* 196688 */:
            case FinalCanbus.CAR_RZC_SwMar_Amp /* 262224 */:
            case FinalCanbus.CAR_RZC_XP1_17QiJun_L /* 327760 */:
            case FinalCanbus.CAR_RZC_XP1_17QiJun_M /* 393296 */:
            case FinalCanbus.CAR_RZC_XP1_17QiJun_H /* 458832 */:
            case FinalCanbus.CAR_OD_XP1_Nissan_All_L /* 524368 */:
            case FinalCanbus.CAR_OD_XP1_Nissan_All_H /* 589904 */:
            case FinalCanbus.CAR_RZC_SwMar_17 /* 1441872 */:
            case FinalCanbus.CAR_RZC_SwMar_Amp_17 /* 1507408 */:
                cls = Rzc_80_DspinfoActi.class;
                break;
            case 86:
                cls = WCBenTeng14B70ClockSet.class;
                break;
            case 88:
                cls = BenTeng14B70ClockSet.class;
                break;
            case 90:
            case FinalCanbus.CAR_WC2_DS5_H /* 65626 */:
                cls = PsaOilMileIndexActi.class;
                break;
            case 92:
            case FinalCanbus.CAR_WC2_DS5LS_H /* 65628 */:
                cls = PsaDs5lsIndexActi.class;
                break;
            case 100:
            case 280:
            case FinalCanbus.CAR_CYT_ShuPing_ChuanQiGS4 /* 65816 */:
            case FinalCanbus.CAR_DaoJun_XINPU_ChuanQiGs4_H /* 65943 */:
            case FinalCanbus.CAR_RZC_XP1_ChuanQiGS4_16H /* 196888 */:
            case FinalCanbus.CAR_BNR_ChuanQiGS4 /* 327960 */:
            case FinalCanbus.CAR_BNR_ChuanQiGS4_H /* 393496 */:
            case FinalCanbus.CAR_RZC_ChuanQiGS4_18_O /* 655640 */:
            case FinalCanbus.CAR_RZC_ChuanQiGA4_18 /* 721176 */:
            case FinalCanbus.CAR_BNR_ChuanQiGA6 /* 852248 */:
            case FinalCanbus.CAR_BNR_ChuanQiGA6_H /* 917784 */:
            case FinalCanbus.CAR_RZC_ChuanQiGS4_19_O /* 1114392 */:
            case FinalCanbus.CAR_RZC_ChuanQiGS8_19 /* 1245464 */:
            case FinalCanbus.CAR_RZC_ChuanQiGM6_19 /* 1311000 */:
            case FinalCanbus.CAR_RZC_XP1_ChuanQiGS7 /* 1376536 */:
            case FinalCanbus.CAR_RZC_XP1_ChuanQiGA6_19 /* 1442072 */:
            case FinalCanbus.CAR_RZC_XP1_ChuanQiGS4_20 /* 1507608 */:
            case FinalCanbus.CAR_RZC_XP1_ChuanQiGM8_20 /* 1573144 */:
            case FinalCanbus.CAR_RZC_XP1_ChuanQiGS5_20 /* 1638680 */:
            case FinalCanbus.CAR_RZC_XP1_ChuanQiGS3_21 /* 1704216 */:
            case FinalCanbus.CAR_RZC_XP1_ChuanQiGS3_17_H /* 1769752 */:
            case FinalCanbus.CAR_RZC_ChuanQiGS8_20 /* 1835288 */:
            case FinalCanbus.CAR_RZC_ChuanQi_GiaoXinglang /* 1900824 */:
            case FinalCanbus.CAR_RZC_XP1_ChuanQiGS4_22 /* 2031896 */:
            case FinalCanbus.CAR_RZC_OD_ChuanQiGS4 /* 2097432 */:
            case FinalCanbus.CAR_RZC_XP1_ChuanQiM8_21 /* 2162968 */:
            case FinalCanbus.CAR_RZC_XP1_ChuanQiGS4_TF /* 2294040 */:
                cls = GS4SetAct_Bnr.class;
                break;
            case 101:
            case FinalCanbus.CAR_WC1_QiJun_H /* 131173 */:
            case FinalCanbus.CAR_WC1_NISSAN_TuLe /* 327781 */:
            case FinalCanbus.CAR_WC1_17QiJun /* 393317 */:
            case FinalCanbus.CAR_WC1_17QiJun_H /* 458853 */:
            case FinalCanbus.CAR_WC1_Tuda /* 524389 */:
            case FinalCanbus.CAR_WC1_19QiJun /* 589925 */:
            case FinalCanbus.CAR_WC1_Tuda_Hand /* 655461 */:
            case FinalCanbus.CAR_WC1_Nawala /* 720997 */:
            case FinalCanbus.CAR_WC1_Nawala_Hand /* 786533 */:
            case FinalCanbus.CAR_WC1_Tuda_H /* 852069 */:
            case FinalCanbus.CAR_WC1_16Xiaoke_Hand /* 917605 */:
            case FinalCanbus.CAR_WC1_16Xima_Hand /* 983141 */:
            case FinalCanbus.CAR_WC1_13Xiaoke_Hand /* 1048677 */:
            case FinalCanbus.CAR_WC1_13Xiaoke_Auto /* 1114213 */:
            case FinalCanbus.CAR_WC1_15Loulan /* 1179749 */:
            case FinalCanbus.CAR_WC1_15Lanniao /* 1245285 */:
            case FinalCanbus.CAR_WC1_16Qida /* 1310821 */:
            case FinalCanbus.CAR_WC1_16Xuanyi /* 1376357 */:
            case FinalCanbus.CAR_WC1_17Jinke /* 1441893 */:
            case FinalCanbus.CAR_WC1_19Qijun_HW /* 1507429 */:
            case FinalCanbus.CAR_WC1_19Qijun_HW_H /* 1572965 */:
            case FinalCanbus.CAR_WC1_19Qijun_TW /* 1638501 */:
            case FinalCanbus.CAR_WC1_19Qijun_TW_H /* 1704037 */:
            case FinalCanbus.CAR_WC1_20Xuanyi /* 1769573 */:
            case FinalCanbus.CAR_WC1_21Qijun /* 1835109 */:
            case FinalCanbus.CAR_WC1_21Qijun_H /* 1900645 */:
            case FinalCanbus.CAR_WC1_21Xiaoke_Hand /* 1966181 */:
            case FinalCanbus.CAR_WC1_21Xiaoke_Auto /* 2031717 */:
            case FinalCanbus.CAR_WC1_13QiJun /* 2097253 */:
            case FinalCanbus.CAR_WC1_23Xiaoke /* 2228325 */:
            case FinalCanbus.CAR_WC1_22Serena /* 2293861 */:
            case FinalCanbus.CAR_WC1_23Serena /* 2359397 */:
                cls = WCNissanCarSet.class;
                break;
            case 106:
                cls = RzcBydS6Acti.class;
                break;
            case 107:
                cls = DjAiruize7Setting.class;
                break;
            case 108:
                cls = WCGeshituIndexActi.class;
                break;
            case 112:
            case 214:
            case 392:
            case 397:
            case FinalCanbus.CAR_RZC_XP1_Carmy_M /* 65648 */:
            case FinalCanbus.CAR_RZC_XP1_14Prado_M /* 65750 */:
            case FinalCanbus.CAR_CYT_SHUPING_CAMARY_15 /* 65928 */:
            case FinalCanbus.CAR_RZC_XP1_Carmy_H /* 131184 */:
            case FinalCanbus.CAR_RZC_XP1_14Prado_H /* 131286 */:
            case FinalCanbus.CAR_RZC_XP1_16RAV4_VIEW /* 393328 */:
            case FinalCanbus.CAR_RZC_XP1_16RAV4_VIEW_AMP /* 458864 */:
            case FinalCanbus.CAR_RZC_XP1_18Carmy /* 524400 */:
            case FinalCanbus.CAR_BNR_12Camry /* 524685 */:
            case FinalCanbus.CAR_RZC_OD_14HuangGuan /* 589936 */:
            case FinalCanbus.CAR_BNR_ShuPing_15_Camery /* 590221 */:
            case FinalCanbus.CAR_RZC_OD_14HuangGuan_H /* 655472 */:
            case FinalCanbus.CAR_BNR_ShuPing_12LandCruise /* 655757 */:
            case FinalCanbus.CAR_RZC_HST_14HuangGuan_H /* 721008 */:
            case FinalCanbus.CAR_BNR_ShuPing_16LandCruise /* 721293 */:
            case FinalCanbus.CAR_RZC_XP1_20RAV4 /* 786544 */:
            case FinalCanbus.CAR_BNR_ShuPing_09Camery /* 786829 */:
            case FinalCanbus.CAR_RZC_XP1_19Yazhoulong /* 852080 */:
            case FinalCanbus.CAR_BNR_ShuPing_14PradoShouDong /* 852365 */:
            case FinalCanbus.CAR_RZC_XP1_18Carmy_H /* 917616 */:
            case FinalCanbus.CAR_BNR_ShuPing_15HighLand_L /* 917901 */:
            case FinalCanbus.CAR_BNR_ShuPing_15HighLand_H /* 983437 */:
            case FinalCanbus.CAR_RZC_XP1_09_15Previa /* 1048688 */:
            case FinalCanbus.CAR_BNR_ShuPing_09HighLand_L /* 1048973 */:
            case FinalCanbus.CAR_RZC_XP1_98_03LC100 /* 1114224 */:
            case FinalCanbus.CAR_BNR_ShuPing_09HighLand_H /* 1114509 */:
            case FinalCanbus.CAR_RZC_XP1_15_18Hilux /* 1179760 */:
            case FinalCanbus.CAR_BNR_ShuPing_07Corolla /* 1180045 */:
            case FinalCanbus.CAR_RZC_XP1_WildLander /* 1245296 */:
            case FinalCanbus.CAR_BNR_ShuPing_14Corolla /* 1245581 */:
            case FinalCanbus.CAR_RZC_XP1_Levin /* 1376368 */:
            case FinalCanbus.CAR_BNR_12Camry_AMP /* 1376653 */:
            case FinalCanbus.CAR_RZC_XP1_Levin_21 /* 1441904 */:
            case FinalCanbus.CAR_BNR_ShuPing_15_Camery_AMP /* 1442189 */:
            case FinalCanbus.CAR_BNR_ShuPing_12LandCruise_AMP /* 1507725 */:
            case FinalCanbus.CAR_BNR_ShuPing_16LandCruise_AMP /* 1573261 */:
            case FinalCanbus.CAR_BNR_ShuPing_14PradoShouDong_AMP /* 1638797 */:
            case FinalCanbus.CAR_BNR_10PradoAuto /* 1704333 */:
            case FinalCanbus.CAR_BNR_10PradoAuto_AMP /* 1769869 */:
            case FinalCanbus.CAR_BNR_14PradoAuto /* 1835405 */:
            case FinalCanbus.CAR_RZC_XP1_18Carmy_TOP /* 1900656 */:
            case FinalCanbus.CAR_BNR_14PradoAuto_AMP /* 1900941 */:
            case FinalCanbus.CAR_RZC_XP1_21Allion /* 1966192 */:
            case FinalCanbus.CAR_BNR_05Reiz /* 1966477 */:
            case FinalCanbus.CAR_RZC_XP1_21Allion_TOP /* 2031728 */:
            case FinalCanbus.CAR_BNR_09Rav4 /* 2032013 */:
            case FinalCanbus.CAR_RZC_XP1_22Highlander /* 2097264 */:
            case FinalCanbus.CAR_RZC_XP1_05_Sienna /* 2228336 */:
            case FinalCanbus.CAR_RZC_XP1_20_LandCruiser /* 2293872 */:
            case FinalCanbus.CAR_RZC_XP1_13_REIZ /* 2359408 */:
            case FinalCanbus.CAR_BNR_18PradoHand /* 2359693 */:
            case FinalCanbus.CAR_RZC_XP1_22_Sienna /* 2424944 */:
            case FinalCanbus.CAR_BNR_18PradoHand_AMP /* 2425229 */:
            case FinalCanbus.CAR_RZC_XP1_19_Corolla /* 2490480 */:
            case FinalCanbus.CAR_BNR_18PradoAuto /* 2490765 */:
            case FinalCanbus.CAR_RZC_XP1_20_4Runner /* 2556016 */:
            case FinalCanbus.CAR_BNR_18PradoAuto_AMP /* 2556301 */:
            case FinalCanbus.CAR_RZC_XP1_22_Harrier /* 2621552 */:
            case FinalCanbus.CAR_BNR_07_15LandCruise_AMP /* 2621837 */:
            case FinalCanbus.CAR_RZC_XP1_22_CROSS /* 2687088 */:
            case FinalCanbus.CAR_BNR_07_15LandCruise /* 2687373 */:
            case FinalCanbus.CAR_RZC_XP1_22_FRONTLANDER /* 2752624 */:
            case FinalCanbus.CAR_RZC_12Camry /* 2752909 */:
            case FinalCanbus.CAR_RZC_ShuPing_15_Camery /* 2818445 */:
            case FinalCanbus.CAR_RZC_ShuPing_12LandCruise /* 2883981 */:
            case FinalCanbus.CAR_RZC_XP1_22_VENZA /* 2949232 */:
            case FinalCanbus.CAR_RZC_ShuPing_16LandCruise /* 2949517 */:
            case FinalCanbus.CAR_RZC_Huangguan_14 /* 3014768 */:
            case FinalCanbus.CAR_RZC_ShuPing_09Camery /* 3015053 */:
            case FinalCanbus.CAR_RZC_XP1_22Highlander_LOW /* 3080304 */:
            case FinalCanbus.CAR_RZC_ShuPing_14PradoShouDong /* 3080589 */:
            case FinalCanbus.CAR_RZC_XP1_22_Sienna_LOW /* 3145840 */:
            case FinalCanbus.CAR_RZC_ShuPing_15HighLand_L /* 3146125 */:
            case FinalCanbus.CAR_ZX_6606_XP1_Carmy /* 3211376 */:
            case FinalCanbus.CAR_RZC_ShuPing_15HighLand_H /* 3211661 */:
            case FinalCanbus.CAR_ZX_6606_XP1_Carmy_M /* 3276912 */:
            case FinalCanbus.CAR_RZC_ShuPing_09HighLand_L /* 3277197 */:
            case FinalCanbus.CAR_ZX_6606_XP1_Carmy_H /* 3342448 */:
            case FinalCanbus.CAR_RZC_ShuPing_09HighLand_H /* 3342733 */:
            case FinalCanbus.CAR_RZC_ShuPing_07Corolla /* 3408269 */:
            case FinalCanbus.CAR_RZC_XP1_22Highlander_H /* 3473520 */:
            case FinalCanbus.CAR_RZC_ShuPing_14Corolla /* 3473805 */:
            case FinalCanbus.CAR_RZC_XP1_Alpha_H /* 3604592 */:
            case FinalCanbus.CAR_RZC_12Camry_AMP /* 3604877 */:
            case FinalCanbus.CAR_ZX_6606_XP1_Carmy_21 /* 3670128 */:
            case FinalCanbus.CAR_RZC_ShuPing_15_Camery_AMP /* 3670413 */:
            case FinalCanbus.CAR_ZX_6606_XP1_19Yazhoulong /* 3735664 */:
            case FinalCanbus.CAR_RZC_ShuPing_12LandCruise_AMP /* 3735949 */:
            case FinalCanbus.CAR_ZX_6606_XP1_Sienna /* 3801200 */:
            case FinalCanbus.CAR_RZC_ShuPing_16LandCruise_AMP /* 3801485 */:
            case FinalCanbus.CAR_RZC_ShuPing_14PradoShouDong_AMP /* 3867021 */:
            case FinalCanbus.CAR_RZC_10PradoAuto /* 3932557 */:
            case FinalCanbus.CAR_RZC_10PradoAuto_AMP /* 3998093 */:
            case FinalCanbus.CAR_RZC_14PradoAuto /* 4063629 */:
            case FinalCanbus.CAR_RZC_XP1_15_LandCruiser /* 4128880 */:
            case FinalCanbus.CAR_RZC_14PradoAuto_AMP /* 4129165 */:
            case FinalCanbus.CAR_RZC_23_Corolla_Malaysia /* 4194416 */:
            case FinalCanbus.CAR_RZC_05Reiz /* 4194701 */:
            case FinalCanbus.CAR_RZC_23_Vios_Malaysia /* 4259952 */:
            case FinalCanbus.CAR_RZC_09Rav4 /* 4260237 */:
            case FinalCanbus.CAR_DUDU_RZC_Toyota_Corolla_14 /* 4325488 */:
            case FinalCanbus.CAR_DUDU_RZC_Toyota_RAV4_20_Hand /* 4391024 */:
            case FinalCanbus.CAR_DUDU_RZC_Toyota_RAV4_20_Auto /* 4456560 */:
            case FinalCanbus.CAR_DUDU_RZC_Toyota_Highlander_15_Hand /* 4522096 */:
            case FinalCanbus.CAR_DUDU_RZC_Toyota_Highlander_15_Auto /* 4587632 */:
            case FinalCanbus.CAR_ZX_6606_XP1_Bz4x /* 4915312 */:
            case FinalCanbus.CAR_RZC_18Camery /* 4981133 */:
            case FinalCanbus.CAR_RZC_XP1_22_CROSS_H /* 5046384 */:
            case FinalCanbus.CAR_RZC_16_18RAV4 /* 5046669 */:
            case FinalCanbus.CAR_RZC_XP1_22_FRONTLANDER_H /* 5111920 */:
            case FinalCanbus.CAR_BNR_18PradoHand_AirP /* 5112205 */:
            case FinalCanbus.CAR_DUDU_RZC_XP1_18Carmy /* 5177456 */:
            case FinalCanbus.CAR_DUDU_RZC_XP1_18Carmy_H /* 5242992 */:
            case FinalCanbus.CAR_DUDU_RZC_XP1_18Carmy_TOP /* 5308528 */:
            case FinalCanbus.CAR_RZC_XP1_20_Sienta /* 5374064 */:
            case FinalCanbus.CAR_RZC_XP1_20_Sienta_H /* 5439600 */:
            case FinalCanbus.CAR_RZC_Toyota_PRIUS_NOCD /* 5832816 */:
            case FinalCanbus.CAR_RZC_XP1_23_VOXY_H /* 6160496 */:
            case FinalCanbus.CAR_RZC_XP1_23_VOXY /* 6226032 */:
            case FinalCanbus.CAR_RZC_XP1_23_NOAH_H /* 6291568 */:
            case FinalCanbus.CAR_RZC_XP1_23_NOAH /* 6357104 */:
            case FinalCanbus.CAR_RZC_Toyota_Corolla_CROSS_23_H /* 6422640 */:
            case FinalCanbus.CAR_RZC_Toyota_Corolla_CROSS_23 /* 6488176 */:
            case FinalCanbus.CAR_RZC_TOYOTA_21Fortuner_ASEAN /* 6553712 */:
            case FinalCanbus.CAR_RZC_TOYOTA_21Fortuner_ASEAN_H /* 6619248 */:
            case FinalCanbus.CAR_RZC_TOYOTA_23Yaris_ASEAN /* 6684784 */:
            case FinalCanbus.CAR_RZC_TOYOTA_23Yaris_ASEAN_H /* 6750320 */:
            case FinalCanbus.CAR_RZC_TOYOTA_23Veloz_ASEAN /* 6815856 */:
            case FinalCanbus.CAR_RZC_TOYOTA_23Veloz_ASEAN_H /* 6881392 */:
            case FinalCanbus.CAR_RZC_TOYOTA_23Innova_ASEAN /* 6946928 */:
            case FinalCanbus.CAR_RZC_TOYOTA_23Innova_ASEAN_H /* 7012464 */:
            case FinalCanbus.CAR_RZC_23_Corolla_Malaysia_H /* 7143536 */:
            case FinalCanbus.CAR_RZC_23_Vios_Malaysia_H /* 7209072 */:
            case FinalCanbus.CAR_ZX_6606_XP1_24Camry /* 7274608 */:
            case FinalCanbus.CAR_RZC_TOYOTA_23Granvia /* 7340144 */:
            case FinalCanbus.CAR_RZC_TOYOTA_23Granvia_H /* 7405680 */:
            case FinalCanbus.CAR_RZC_TOYOTA_Alpha_17 /* 7471216 */:
            case FinalCanbus.CAR_RZC_Toyota_Corolla_cross_America /* 7602288 */:
            case FinalCanbus.CAR_RZC_Toyota_Corolla_cross_AmericaH /* 7667824 */:
            case FinalCanbus.CAR_RZC_Toyota_Prado_24 /* 7733360 */:
            case FinalCanbus.CAR_RZC_Toyota_Prado_24_H /* 7798896 */:
            case FinalCanbus.CAR_RZC_Toyota_RAV4_24 /* 7864432 */:
            case FinalCanbus.CAR_RZC_Toyota_RAV4_24_H /* 7929968 */:
            case FinalCanbus.CAR_RZC_XP1_22_Harrier_H /* 8061040 */:
            case FinalCanbus.CAR_RZC_TOYOTA_16Prius_SP /* 8126576 */:
            case FinalCanbus.CAR_RZC_TOYOTA_14Tundra /* 8192112 */:
            case FinalCanbus.CAR_RZC_TOYOTA_14Tundra_Auto /* 8257648 */:
            case FinalCanbus.CAR_RZC_TOYOTA_10Sequoia /* 8323184 */:
            case FinalCanbus.CAR_RZC_TOYOTA_10Sequoia_Auto /* 8388720 */:
            case FinalCanbus.CAR_RZC_TOYOTA_08Camry /* 8454256 */:
            case FinalCanbus.CAR_RZC_TOYOTA_13Camry /* 8519792 */:
            case FinalCanbus.CAR_RZC_TOYOTA_10AURIS_Auto /* 8585328 */:
            case FinalCanbus.CAR_RZC_TOYOTA_13Avalon_Auto /* 8650864 */:
                cls = CamryIndexAct.class;
                break;
            case 115:
            case 293:
                cls = RJIndexAct.class;
                break;
            case 118:
            case 122:
            case 185:
            case FinalCanbus.CAR_WC2_408_14_M /* 65658 */:
            case FinalCanbus.CAR_WC2_408_14_H /* 131194 */:
                cls = BZ408IndexActi.class;
                break;
            case 121:
            case FinalCanbus.CAR_WC2_14Prado_M /* 65657 */:
            case FinalCanbus.CAR_WC2_14Prado_H /* 131193 */:
            case FinalCanbus.CAR_WC2_ShuPing_14Prado_M /* 196729 */:
            case FinalCanbus.CAR_WC2_ShuPing_14Prado_H /* 262265 */:
            case FinalCanbus.CAR_WC2_ShuPing_Prado_M /* 458873 */:
            case FinalCanbus.CAR_WC2_ShuPing_Prado_H /* 524409 */:
            case FinalCanbus.CAR_WC2_ShuPing_14Prado_H_NoAMP /* 721017 */:
                cls = PardoIndexAct.class;
                break;
            case 123:
            case 278:
                cls = XpPsa301Acti.class;
                break;
            case 128:
                cls = ActivityChangAnCS75.class;
                break;
            case 131:
            case FinalCanbus.CAR_XFY_Haval_H6_ShuPing /* 131203 */:
                cls = HavalH6Acti.class;
                break;
            case 143:
            case FinalCanbus.CAR_XP1_QiJun_M /* 65679 */:
            case FinalCanbus.CAR_XP1_QiJun_H /* 131215 */:
            case FinalCanbus.CAR_XP1_QiJun_DaoJun_SHOUDONG /* 393359 */:
            case FinalCanbus.CAR_XP1_QiJun_DaoJun_ZIDONG /* 589967 */:
            case FinalCanbus.CAR_XHCN_DianDongChe /* 655503 */:
            case FinalCanbus.CAR_XP1_15QiJun_Shuping /* 721039 */:
            case FinalCanbus.CAR_XP1_15Tule_Shuping_L /* 786575 */:
            case FinalCanbus.CAR_XP1_Nissan_Qashqai /* 852111 */:
            case FinalCanbus.CAR_XP1_Nissan_Qashqai_H /* 917647 */:
            case FinalCanbus.CAR_XP1_Nissan_SYLPHY_20 /* 983183 */:
            case FinalCanbus.CAR_XP1_Nissan_SYLPHY_20_H /* 1048719 */:
                cls = XPNissanCarSet.class;
                break;
            case 144:
            case 145:
            case FinalCanbus.CAR_WC1_ZhiNanZhe_H /* 65680 */:
            case FinalCanbus.CAR_WC1_MuMaRen_H /* 65681 */:
                cls = WCOldJeepAmpSet.class;
                break;
            case 151:
            case FinalCanbus.CAR_DAOJUN_XP1_BYDSurui /* 458903 */:
            case FinalCanbus.CAR_RCW_BYD_6 /* 524439 */:
            case FinalCanbus.CAR_RCW_BYD_12_18Surui /* 589975 */:
                cls = Activity_DaojunSetCrtrl.class;
                break;
            case 153:
            case 249:
            case 393:
            case FinalCanbus.CAR_RZC_16_QiYaKX5_M /* 65929 */:
            case FinalCanbus.CAR_RZC3_XiandaiIX35_H /* 131209 */:
            case FinalCanbus.CAR_RZC3_MingTu_H /* 131225 */:
            case FinalCanbus.CAR_RZC3_SoNaTa9_H /* 131321 */:
            case FinalCanbus.CAR_RZC_16_QiYaKX5_H /* 131465 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_18Sonata9_M /* 262506 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_18Sonata9_H /* 328042 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_All_H /* 524650 */:
            case FinalCanbus.CAR_RZC3_XianDai_Rohens_Coupe_12_H /* 1376618 */:
                cls = RZCXiandaiAmpCarSet.class;
                break;
            case 163:
            case 221:
            case 238:
            case FinalCanbus.CAR_RZC4_PSA14_308_16 /* 65699 */:
            case FinalCanbus.CAR_RZC4_PSA_4008 /* 65875 */:
            case FinalCanbus.CAR_RZC4_PSA14_408_M /* 131235 */:
            case FinalCanbus.CAR_RZC4_PSA14_408_H /* 196771 */:
                cls = RZC_BZ408IndexActi.class;
                break;
            case 164:
                cls = JiaNianHuaMainActivity.class;
                break;
            case 165:
            case FinalCanbus.CAR_XBS_XP1_ChuanQiGS3 /* 65701 */:
                cls = GS3CarSettingsAct.class;
                break;
            case 170:
                cls = M3CarCD.class;
                break;
            case 175:
            case FinalCanbus.CAR_XP1_MZD_CX5_M /* 65711 */:
            case FinalCanbus.CAR_XP1_MZD_CX5_H /* 131247 */:
                cls = CX5Index.class;
                break;
            case 187:
                cls = BZ408OilMileIndexActi.class;
                break;
            case 188:
                cls = CrvXBSActi.class;
                break;
            case 190:
            case 331:
            case FinalCanbus.CAR_RZC_XP1_TianLai_H /* 65726 */:
            case FinalCanbus.CAR_RZC_XP1_04_07TianLai /* 131262 */:
            case FinalCanbus.CAR_RZC_XP1_LuoLan_H /* 131403 */:
            case FinalCanbus.CAR_RZC_XP1_04_07TianLai_SP /* 196798 */:
            case FinalCanbus.CAR_RZC_XP1_20Xuanyi /* 262334 */:
            case FinalCanbus.CAR_RZC_XP1_20Xuanyi_H /* 327870 */:
            case FinalCanbus.CAR_RZC_Nissan_All /* 393406 */:
            case FinalCanbus.CAR_RZC_Nissan_Xiaoke /* 524478 */:
            case FinalCanbus.CAR_RZC_Nissan_Qijun_HW /* 590014 */:
            case FinalCanbus.CAR_RZC_Nissan_Xiaoke_H /* 655550 */:
            case FinalCanbus.CAR_RZC_Nissan_Tianlai_20 /* 721086 */:
            case FinalCanbus.CAR_RZC_Nissan_Tianlai_20_H /* 786622 */:
            case FinalCanbus.CAR_RZC_Nissan_Qijun_H /* 983230 */:
            case FinalCanbus.CAR_RZC_Nissan_NAVANA_H /* 1048766 */:
            case FinalCanbus.CAR_RZC_Nissan_PULSAR_M /* 1114302 */:
            case FinalCanbus.CAR_RZC_Nissan_Jingke /* 1179838 */:
            case FinalCanbus.CAR_RZC_Nissan_Jingke_H /* 1245374 */:
            case FinalCanbus.CAR_RZC_Nissan_LANNIA_H /* 1310910 */:
            case FinalCanbus.CAR_RZC_Nissan_Sylphy_20 /* 1441982 */:
            case FinalCanbus.CAR_RZC_Nissan_Sylphy_20_H /* 1507518 */:
            case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_14 /* 1966270 */:
            case FinalCanbus.CAR_RZC_Nissan_PATHFINDER_11 /* 2031806 */:
            case FinalCanbus.CAR_RZC_Nissan_PATROL_13 /* 2097342 */:
            case FinalCanbus.CAR_RZC_Nissan_ALTIMA_12 /* 2162878 */:
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
                cls = NissanXiaokeCarSet.class;
                break;
            case 217:
            case FinalCanbus.CAR_RZC4_PSA_MPV_Tepee /* 65753 */:
            case FinalCanbus.CAR_RZC4_PSA_307_13 /* 131289 */:
            case FinalCanbus.CAR_RZC4_PSA_408_SW /* 196825 */:
            case FinalCanbus.CAR_RZC4_PSA_408_CC /* 262361 */:
            case FinalCanbus.CAR_RZC4_PSA_RCZ /* 327897 */:
            case FinalCanbus.CAR_RZC4_PSA_3008_KeepScreen /* 393433 */:
            case FinalCanbus.CAR_RZC4_PSA_ALL_Screen /* 458969 */:
                cls = RZC_BZ408_Panel_IndexActi.class;
                break;
            case 223:
            case FinalCanbus.CAR_RZC_FengGuang18Y580 /* 393530 */:
            case FinalCanbus.CAR_RZC_FengGuang18Y580_H /* 459066 */:
            case FinalCanbus.CAR_RZC1_MZDRX8 /* 524367 */:
            case FinalCanbus.CAR_RZC_Jiangxi_Wushiling_Mux /* 852282 */:
            case FinalCanbus.CAR_RZC_Jiangxi_FengguangS560_21 /* 1179962 */:
            case FinalCanbus.CAR_RZC_FengGuang21Y580 /* 1245498 */:
            case FinalCanbus.CAR_RZC_FengGuang21Y580_H /* 1311034 */:
            case FinalCanbus.CAR_452_LZ_Ferrari_430 /* 2556357 */:
            case FinalCanbus.CAR_OuDi_XP1_Borui_18 /* 3080331 */:
            case FinalCanbus.CAR_OuDi_XP1_Borui_18_L /* 3145867 */:
            case 230:
            case FinalCanbus.CAR_WC1_BMW_E9X /* 65766 */:
            case FinalCanbus.CAR_WC1_BMW_F30 /* 131302 */:
            case FinalCanbus.CAR_WC1_BMW_CIC /* 196838 */:
                cls = BMWX1IndexActi.class;
                break;
            case 232:
            case FinalCanbus.CAR_XP2_OPEL_Baud19200 /* 65768 */:
            case FinalCanbus.CAR_XP2_LUZ_OPEL_Zafira /* 131304 */:
            case FinalCanbus.CAR_XP2_LUZ_OPEL_Antara /* 196840 */:
            case FinalCanbus.CAR_XP2_LUZ_OPEL_Astra /* 262376 */:
                cls = OPELCarKeyActivity.class;
                break;
            case 237:
            case FinalCanbus.CAR_RZC_XP1_16HAIMAM3 /* 65773 */:
                cls = ActivityHaiMaSettings.class;
                break;
            case 244:
            case FinalCanbus.CAR_RZC_XP1_HavalH2_H /* 65780 */:
            case FinalCanbus.CAR_RZC_HavalLow_H2_LanBiao /* 262388 */:
            case FinalCanbus.CAR_RZC_HavalLow_H2_HongBiao /* 327924 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6 /* 458996 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6Couple_HongBiao /* 524532 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6Couple_LanBiao /* 590068 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6Couple_16 /* 786676 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6Couple_16_top /* 983284 */:
            case FinalCanbus.CAR_RZC_HavalLow_Changchengpao_19 /* 1114356 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6_H /* 1573108 */:
            case FinalCanbus.CAR_RZC_Haval_H3_05 /* 1966324 */:
            case FinalCanbus.CAR_RZC_HavalLow_Changchengpao_19_L /* 2294004 */:
                cls = ActivityHava18H6SetAct.class;
                break;
            case 252:
            case FinalCanbus.CAR_WC2_PSAALL_1 /* 65788 */:
            case FinalCanbus.CAR_WC2_PSAALL_2 /* 131324 */:
            case FinalCanbus.CAR_WC2_PSAALL_3 /* 196860 */:
            case FinalCanbus.CAR_WC2_PSAALL_4 /* 262396 */:
            case FinalCanbus.CAR_WC2_PSAALL_5 /* 327932 */:
            case FinalCanbus.CAR_WC2_PSAALL_6 /* 393468 */:
            case FinalCanbus.CAR_WC2_PSAALL_7 /* 459004 */:
            case FinalCanbus.CAR_WC2_PSAALL_8 /* 524540 */:
            case FinalCanbus.CAR_WC2_PSAALL_9 /* 590076 */:
            case FinalCanbus.CAR_WC2_PSAALL_10 /* 655612 */:
            case FinalCanbus.CAR_WC2_PSAALL_11 /* 721148 */:
            case FinalCanbus.CAR_WC2_PSAALL_12 /* 786684 */:
            case FinalCanbus.CAR_WC2_PSAALL_DS6 /* 852220 */:
            case FinalCanbus.CAR_WC2_PSAALL_301_19 /* 917756 */:
            case FinalCanbus.CAR_WC2_PSAALL_Rifter_19_H /* 983292 */:
            case FinalCanbus.CAR_WC2_PSAALL_Rifter_19_L /* 1048828 */:
            case FinalCanbus.CAR_WC2_PSAALL_TY_C5 /* 1114364 */:
            case FinalCanbus.CAR_WC2_PSAALL_308_11_Amp /* 1179900 */:
            case FinalCanbus.CAR_WC2_PSAALL_407_06 /* 1245436 */:
            case FinalCanbus.CAR_WC2_PSAALL_C3Aircross_23 /* 1310972 */:
            case FinalCanbus.CAR_WC2_PSAALL_3008_22 /* 1376508 */:
            case FinalCanbus.CAR_WC2_PSAALL_C4_09 /* 1442044 */:
            case FinalCanbus.CAR_WC2_PSAALL_Partner_09 /* 1507580 */:
            case FinalCanbus.CAR_WC2_PSAALL_Belingo_17 /* 1573116 */:
            case FinalCanbus.CAR_WC2_PSAALL_5008_21 /* 1704188 */:
            case FinalCanbus.CAR_WC2_PSAALL_208_23_SA /* 1769724 */:
            case FinalCanbus.CAR_WC2_PSAALL_C3_22_SA /* 1835260 */:
                cls = PSAIndexActi.class;
                break;
            case 260:
            case FinalCanbus.CAR_WC2_ChuanQiGA6_M /* 65796 */:
            case FinalCanbus.CAR_WC2_ChuanQiGA6_H /* 131332 */:
            case FinalCanbus.CAR_WC2_17ChuanQiGS3 /* 262433 */:
            case FinalCanbus.CAR_WC2_17ChuanQiGA4 /* 327969 */:
            case FinalCanbus.CAR_WC2_17ChuanQiGA4_H /* 393505 */:
            case FinalCanbus.CAR_WC2_18ChuanQiGE3 /* 459041 */:
            case FinalCanbus.CAR_WC2_ChuanQiG_GS4_20 /* 590113 */:
            case FinalCanbus.CAR_WC2_ChuanQiG_AION_19 /* 655649 */:
            case FinalCanbus.CAR_WC2_ChuanQiG_GS8_17 /* 721185 */:
            case FinalCanbus.CAR_WC2_ChuanQiG_AION_22 /* 786721 */:
                cls = GS4CarSettingsAct.class;
                break;
            case 262:
            case 410:
                cls = XBSAccord9IndexActi.class;
                break;
            case 265:
                cls = IndexAct_RZC.class;
                break;
            case 266:
            case FinalCanbus.CAR_XP1_SoNaTa9_AMP /* 131338 */:
            case FinalCanbus.CAR_XP1_18SoNaTa9_L /* 655626 */:
            case FinalCanbus.CAR_XP1_18SoNaTa9_M /* 721162 */:
            case FinalCanbus.CAR_XP1_18SoNaTa9_H /* 786698 */:
            case FinalCanbus.CAR_XP1_19SoNaTa9 /* 852234 */:
                cls = XPXiandaiCarSet.class;
                break;
            case 270:
            case 279:
                cls = LingDuActi.class;
                break;
            case 271:
                cls = DjB70Act.class;
                break;
            case 272:
            case FinalCanbus.CAR_RZC_XP1_Ruifeng_MiniS2 /* 196880 */:
            case FinalCanbus.CAR_BNR_Jianghuai_Ruifeng_S2 /* 393488 */:
            case FinalCanbus.CAR_BNR_Jianghuai_Ruifeng_S3 /* 459024 */:
                cls = JhRuiFengS3TireAct.class;
                break;
            case 273:
            case FinalCanbus.CAR_RZC_XP1_Mingjue_17RuiTeng /* 196881 */:
            case FinalCanbus.CAR_RZC_XP1_Mingjue_16RuiTeng /* 524561 */:
            case FinalCanbus.CAR_RZC_MingJue_3 /* 1769745 */:
                cls = ActRuiTengIndex.class;
                break;
            case 274:
            case FinalCanbus.CAR_DJ_XP1_ACCORD7_H /* 65810 */:
                if (LauncherApplication.getConfiguration() != 1) {
                    cls = ActivityAccord7Index.class;
                    break;
                }
            case 276:
            case 281:
            case FinalCanbus.CAR_BNR_XP1_PsaAll /* 65817 */:
            case FinalCanbus.CAR_XP1_PsaAll_AutoPark /* 262425 */:
                cls = XpPsaAllIndexActi.class;
                break;
            case 282:
            case FinalCanbus.CAR_WC2_17MingJueRuiTeng /* 131354 */:
                cls = RuiTengIndexActi.class;
                break;
            case 286:
                cls = AudiAct.class;
                break;
            case 287:
            case FinalCanbus.CAR_XP_JEEP_H /* 65823 */:
            case FinalCanbus.CAR_LUZ_XP_KelaiSile_H /* 196895 */:
            case FinalCanbus.CAR_BNR_JEEP_H /* 327967 */:
            case FinalCanbus.CAR_BNR_Zhinanzhe_14_H /* 459039 */:
                cls = Activity_287_Engine_Shotdown.class;
                break;
            case 289:
            case FinalCanbus.CAR_WC2_ChuanQiGS4_M /* 65825 */:
            case FinalCanbus.CAR_WC2_ChuanQiGS4_H /* 131361 */:
            case FinalCanbus.CAR_WC2_17ChuanQiGS4 /* 196897 */:
                cls = GS4IndexAct.class;
                break;
            case 290:
            case FinalCanbus.CAR_CZH_RZC_QiChenT70 /* 786722 */:
                cls = QiChenT70Act.class;
                break;
            case 294:
            case FinalCanbus.CAR_WC2_TOYOTA_REIZ /* 65830 */:
            case FinalCanbus.CAR_WC2_TOYOTA_RAV4 /* 131366 */:
            case FinalCanbus.CAR_WC2_TOYOTA_CAMRY /* 196902 */:
            case FinalCanbus.CAR_WC2_TOYOTA_COROLLA /* 262438 */:
            case FinalCanbus.CAR_WC2_TOYOTA_HIGHLANDER /* 327974 */:
            case FinalCanbus.CAR_WC2_16RAV4_VIEW /* 459046 */:
            case FinalCanbus.CAR_WC2_16RAV4_VIEW_AMP /* 524582 */:
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
            case FinalCanbus.CAR_WC_Toyota_21Sienna /* 1704230 */:
            case FinalCanbus.CAR_WC2_18PRADO /* 1966374 */:
            case FinalCanbus.CAR_WC2_18Camery /* 2031910 */:
            case FinalCanbus.CAR_WC2_18PRADO_H /* 2097446 */:
            case FinalCanbus.CAR_WC2_16PRADO /* 2162982 */:
            case FinalCanbus.CAR_WC2_16PRADO_H /* 2228518 */:
            case FinalCanbus.CAR_WC2_19RAV4 /* 2294054 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22Vios /* 2359590 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22Vios_H /* 2425126 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Vios /* 2490662 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Vios_H /* 2556198 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Corolla /* 2621734 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Corolla_H /* 2687270 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22Corolla /* 2752806 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22Corolla_H /* 2818342 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23GRANVIA /* 3014950 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23GRANVIA_H /* 3080486 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22Veloz /* 3146022 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22Veloz_H /* 3211558 */:
            case FinalCanbus.CAR_WC2_TOYOTA_21Fortuner /* 3277094 */:
            case FinalCanbus.CAR_WC2_TOYOTA_21Fortuner_H /* 3342630 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Innova /* 3408166 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Innova_H /* 3473702 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22RAV4 /* 3539238 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22RAV4_H /* 3604774 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22NOAH /* 3670310 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22NOAH_H /* 3735846 */:
            case FinalCanbus.CAR_WC2_TOYOTA_19RAV4_TW /* 3801382 */:
            case FinalCanbus.CAR_WC2_TOYOTA_19RAV4_TW_H /* 3866918 */:
            case FinalCanbus.CAR_WC2_TOYOTA_19Corolla_TW /* 3932454 */:
            case FinalCanbus.CAR_WC2_TOYOTA_19Corolla_TW_H /* 3997990 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23YarisCross_TW /* 4063526 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23YarisCross_TW_H /* 4129062 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Sienta_TW /* 4194598 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Sienta_TW_H /* 4260134 */:
            case FinalCanbus.CAR_WC2_TOYOTA_17Fortuner /* 4325670 */:
            case FinalCanbus.CAR_WC2_TOYOTA_13Vellfire /* 4391206 */:
            case FinalCanbus.CAR_WC2_TOYOTA_17Fortuner_H /* 4456742 */:
            case FinalCanbus.CAR_WC2_TOYOTA_13Vellfire_H /* 4522278 */:
            case FinalCanbus.CAR_WC2_TOYOTA_17CHR /* 4587814 */:
            case FinalCanbus.CAR_WC2_TOYOTA_17CHR_H /* 4653350 */:
            case FinalCanbus.CAR_WC2_TOYOTA_20Runner /* 4718886 */:
            case FinalCanbus.CAR_WC2_TOYOTA_20Runner_H /* 4784422 */:
            case FinalCanbus.CAR_WC2_TOYOTA_21Sienna_H /* 4849958 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22Harrier /* 4915494 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22Harrier_H /* 4981030 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22VENZA /* 5046566 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22VENZA_H /* 5112102 */:
            case FinalCanbus.CAR_WC2_TOYOTA_21CROWNKLUGER /* 5177638 */:
            case FinalCanbus.CAR_WC2_TOYOTA_21CROWNKLUGER_H /* 5243174 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22COROLLACROSS /* 5308710 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22COROLLACROSS_H /* 5374246 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22Frontlander /* 5439782 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22Frontlander_H /* 5505318 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22COROLLA_SA /* 5570854 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22COROLLA_SA_H /* 5636390 */:
            case FinalCanbus.CAR_WC2_TOYOTA_02Alpha /* 5701926 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Yaris_ASEAN /* 5767462 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Yaris_ASEAN_H /* 5832998 */:
            case FinalCanbus.CAR_WC2_TOYOTA_TMK_BENZ_EV_ALL /* 5898534 */:
            case FinalCanbus.CAR_WC2_TOYOTA_13Harrier_ASEAN /* 5964070 */:
            case FinalCanbus.CAR_WC2_TOYOTA_16Sienna /* 6029606 */:
            case FinalCanbus.CAR_WC2_TOYOTA_17Sienna_NA /* 6095142 */:
            case FinalCanbus.CAR_WC2_TOYOTA_21Tacoma_NA /* 6160678 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22Camery_NA /* 6226214 */:
            case FinalCanbus.CAR_WC2_TOYOTA_18Prius_NA /* 6291750 */:
            case FinalCanbus.CAR_WC2_TOYOTA_16PriusV_NA /* 6357286 */:
            case FinalCanbus.CAR_WC2_TOYOTA_21RAV4_NA /* 6422822 */:
            case FinalCanbus.CAR_WC2_TOYOTA_18IZOA /* 6488358 */:
            case FinalCanbus.CAR_WC2_TOYOTA_18IZOA_H /* 6553894 */:
            case FinalCanbus.CAR_WC2_TOYOTA_13Yaris /* 6619430 */:
            case FinalCanbus.CAR_WC2_TOYOTA_21Yaris /* 6684966 */:
            case FinalCanbus.CAR_WC2_TOYOTA_10ReiZ /* 6750502 */:
            case FinalCanbus.CAR_WC2_TOYOTA_14ReiZ /* 6816038 */:
            case FinalCanbus.CAR_WC2_TOYOTA_13Prius /* 6881574 */:
            case FinalCanbus.CAR_WC2_TOYOTA_14PRADO /* 6947110 */:
            case FinalCanbus.CAR_WC2_TOYOTA_10Avalon /* 7012646 */:
            case FinalCanbus.CAR_WC2_TOYOTA_15Avalon /* 7078182 */:
            case FinalCanbus.CAR_WC2_TOYOTA_19Avalon /* 7143718 */:
            case FinalCanbus.CAR_WC2_TOYOTA_10Sienna /* 7209254 */:
            case FinalCanbus.CAR_WC2_TOYOTA_15Sienna /* 7274790 */:
            case FinalCanbus.CAR_WC2_TOYOTA_21Sienna_NA /* 7340326 */:
            case FinalCanbus.CAR_WC2_TOYOTA_10Sequoia /* 7405862 */:
            case FinalCanbus.CAR_WC2_TOYOTA_14Tundra /* 7471398 */:
            case FinalCanbus.CAR_WC2_TOYOTA_18Tundra /* 7536934 */:
            case FinalCanbus.CAR_WC2_TOYOTA_16Hilux /* 7602470 */:
            case FinalCanbus.CAR_WC2_TOYOTA_16LuXun /* 7668006 */:
            case FinalCanbus.CAR_WC2_TOYOTA_19ProACECity /* 7733542 */:
            case FinalCanbus.CAR_WC2_TOYOTA_07Previa /* 7799078 */:
            case FinalCanbus.CAR_WC2_TOYOTA_21HIACE /* 7864614 */:
            case FinalCanbus.CAR_WC2_TOYOTA_20Willander /* 7930150 */:
            case FinalCanbus.CAR_WC2_TOYOTA_15Crown /* 7995686 */:
            case FinalCanbus.CAR_WC2_TOYOTA_14Levin /* 8061222 */:
            case FinalCanbus.CAR_WC2_TOYOTA_19Levin /* 8126758 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Altis /* 8192294 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Altis_H /* 8257830 */:
                cls = Rav4TripAct.class;
                break;
            case 298:
            case FinalCanbus.CAR_XP1_2015SIYU_CRV_M /* 65834 */:
            case FinalCanbus.CAR_XP1_2015SIYU_CRV_H /* 131370 */:
            case FinalCanbus.CAR_DJ_WC2_Honda_SPIRIOR /* 655681 */:
            case FinalCanbus.CAR_DJ_WC2_Honda_SPIRIOR_RADIO /* 1442113 */:
            case FinalCanbus.CAR_RZC_XP1_ELYSION /* 1638698 */:
            case FinalCanbus.CAR_RZC_XP1_15ELYSION /* 1704234 */:
            case FinalCanbus.CAR_XP_2015SiYu_CRV /* 2294058 */:
            case FinalCanbus.CAR_XP1_2015SiYu_CRV_H /* 4325674 */:
            case FinalCanbus.CAR_RZC_CRV2012_H /* 4391210 */:
            case FinalCanbus.CAR_RZC_2014SIYU_CRV_H /* 4456746 */:
            case FinalCanbus.CAR_RZC_2014_CRV_H /* 4522282 */:
            case FinalCanbus.CAR_RZC_SIYU2012_H /* 4587818 */:
                cls = HondaIndexActi.class;
                break;
            case 301:
                cls = HC_Biaozhi206OilPage.class;
                break;
            case 302:
            case 303:
            case FinalCanbus.CAR_DJ_WC2_DS5LS_H /* 65838 */:
            case FinalCanbus.CAR_DJ_WC2_DS5_H /* 65839 */:
                cls = DS5IndexAct.class;
                break;
            case 313:
                cls = Sbd_IndexAct.class;
                break;
            case 320:
            case FinalCanbus.CAR_WeiChi2_ChangChengH2_H /* 65856 */:
                cls = WcHavalH6Acti.class;
                break;
            case 321:
            case FinalCanbus.CAR_XP1_2016SIYU /* 196906 */:
            case FinalCanbus.CAR_XP1_2016SIYU_H /* 262442 */:
            case FinalCanbus.CAR_WC2_Honda_AllCom_CIVIC /* 262465 */:
            case FinalCanbus.CAR_BNR_HONDA_16Civic_Vsceen_L /* 393514 */:
            case FinalCanbus.CAR_BNR_HONDA_16Civic_Vsceen_H /* 459050 */:
            case FinalCanbus.CAR_WC2_Honda_17CRV /* 459073 */:
            case FinalCanbus.CAR_BNR_HONDA_Avancier_NoAmp /* 524586 */:
            case FinalCanbus.CAR_WC2_Honda_17CRV_H /* 524609 */:
            case FinalCanbus.CAR_BNR_HONDA_Avancier_Amp_View /* 590122 */:
            case FinalCanbus.CAR_WC2_Honda_17CRV_M /* 590145 */:
            case FinalCanbus.CAR_BNR_HONDA_Avancier_Vsceen_NoAmp /* 655658 */:
            case FinalCanbus.CAR_BNR_HONDA_Avancier_Vsceen_Amp_View /* 721194 */:
            case FinalCanbus.CAR_RZC_XP1_17CRV /* 786730 */:
            case FinalCanbus.CAR_WC2_Honda_16SIYU_HAND /* 786753 */:
            case FinalCanbus.CAR_XP1_17CRV /* 852266 */:
            case FinalCanbus.CAR_WC2_Honda_16SIYU_AUTO /* 852289 */:
            case FinalCanbus.CAR_RZC_XP1_17CRV_H /* 917802 */:
            case FinalCanbus.CAR_WC2_Honda_17GuanDao /* 917825 */:
            case FinalCanbus.CAR_BNR_17CRV /* 983338 */:
            case FinalCanbus.CAR_WC2_Honda_AllCom_Top /* 983361 */:
            case FinalCanbus.CAR_RZC_HONDA_16Civic_Vsceen_L /* 1048874 */:
            case FinalCanbus.CAR_WC2_Honda_15Aodesai_Tai /* 1048897 */:
            case FinalCanbus.CAR_RZC_HONDA_16Civic_Vsceen_H /* 1114410 */:
            case FinalCanbus.CAR_WC2_Honda_18Aodesai_Tai /* 1114433 */:
            case FinalCanbus.CAR_RZC_HONDA_19YingSipai /* 1179946 */:
            case FinalCanbus.CAR_WC2_Honda_19CRV /* 1179969 */:
            case FinalCanbus.CAR_RZC_HONDA_19Linpai /* 1245482 */:
            case FinalCanbus.CAR_WC2_Honda_19Lingpai /* 1245505 */:
            case FinalCanbus.CAR_RZC_HONDA_19Xiangyu /* 1311018 */:
            case FinalCanbus.CAR_WC2_Honda_19Xiangyu /* 1311041 */:
            case FinalCanbus.CAR_RZC_HONDA_15_18Aodesai_Tai /* 1376554 */:
            case FinalCanbus.CAR_WC2_Honda_17Elysion /* 1376577 */:
            case FinalCanbus.CAR_RZC_HONDA_15_18Aodesai_Tai_H /* 1442090 */:
            case FinalCanbus.CAR_WC2_Honda_15Aodesai_H /* 1507649 */:
            case FinalCanbus.CAR_WC2_Honda_18Aodesai_H /* 1573185 */:
            case FinalCanbus.CAR_RZC_HONDA_20Haoying /* 1835306 */:
            case FinalCanbus.CAR_RZC_HONDA_20Haoying_H /* 1900842 */:
            case FinalCanbus.CAR_RZC_HONDA_Crown /* 2031914 */:
            case FinalCanbus.CAR_WC2_Honda_19INSPIRE /* 2031937 */:
            case FinalCanbus.CAR_RZC_HONDA_Crown_H /* 2097450 */:
            case FinalCanbus.CAR_WC2_Honda_20EVERUS /* 2097473 */:
            case FinalCanbus.CAR_WC2_Honda_21CRV /* 2163009 */:
            case FinalCanbus.CAR_RZC_HONDA_21Fit /* 2228522 */:
            case FinalCanbus.CAR_WC2_Honda_21BREEZE /* 2228545 */:
            case FinalCanbus.CAR_WC2_Honda_22CIVIC /* 2294081 */:
            case FinalCanbus.CAR_RZC_HONDA_19YingSipai_H /* 2359594 */:
            case FinalCanbus.CAR_WC2_Honda_22Accord /* 2359617 */:
            case FinalCanbus.CAR_RZC_HONDA_21Haoying /* 2425130 */:
            case FinalCanbus.CAR_WC2_Honda_22CRIDER /* 2425153 */:
            case FinalCanbus.CAR_RZC_HONDA_21CRV /* 2490666 */:
            case FinalCanbus.CAR_WC2_Honda_21Fit /* 2490689 */:
            case FinalCanbus.CAR_WC2_Honda_19Elysion /* 2556225 */:
            case FinalCanbus.CAR_BNR_HONDA_16Civic_NoAir /* 2621738 */:
            case FinalCanbus.CAR_WC2_Honda_15Aodesai_MH /* 2621761 */:
            case FinalCanbus.CAR_RZC_HONDA_2022SIYU /* 2687274 */:
            case FinalCanbus.CAR_WC2_Honda_16Acura_CDX /* 2687297 */:
            case FinalCanbus.CAR_RZC_HONDA_2022Lingpai /* 2752810 */:
            case FinalCanbus.CAR_WC2_Honda_20Aodesai_H /* 2752833 */:
            case FinalCanbus.CAR_RZC_XP1_2016SIYU /* 2818346 */:
            case FinalCanbus.CAR_WC2_Honda_22STEP_WGN /* 2818369 */:
            case FinalCanbus.CAR_RZC_XP1_2016SIYU_H /* 2883882 */:
            case FinalCanbus.CAR_WC2_Honda_23XRV /* 2883905 */:
            case FinalCanbus.CAR_RZC_HONDA_22INTEGRA /* 2949418 */:
            case FinalCanbus.CAR_WC2_Honda_15Aodesai_T /* 2949441 */:
            case FinalCanbus.CAR_WC2_Honda_16CRV_OverSea_H /* 3080513 */:
            case FinalCanbus.CAR_DJ_RZC_HONDA_22Aodesai_Tai /* 3146026 */:
            case FinalCanbus.CAR_WC2_Honda_16CRV_OverSea_L /* 3146049 */:
            case FinalCanbus.CAR_RZC_XP1_22ZRV /* 3211562 */:
            case FinalCanbus.CAR_RZC_XP1_22ZRV_H /* 3277098 */:
            case FinalCanbus.CAR_RZC_HONDA_22Aodesai_Tai /* 3342634 */:
            case FinalCanbus.CAR_WC2_Honda_15_18Aodesai_H /* 3342657 */:
            case FinalCanbus.CAR_RZC_HONDA_22CRV /* 3408170 */:
            case FinalCanbus.CAR_WC2_Honda_19Aodesai /* 3408193 */:
            case FinalCanbus.CAR_RZC_XP1_22ELYSION /* 3473706 */:
            case FinalCanbus.CAR_WC2_Honda_14Freed /* 3473729 */:
            case FinalCanbus.CAR_RZC_XP1_XRV /* 3539242 */:
            case FinalCanbus.CAR_WC2_Honda_23Freed /* 3539265 */:
            case FinalCanbus.CAR_RZC_XP1_XRV_H /* 3604778 */:
            case FinalCanbus.CAR_WC2_Honda_22ZRV /* 3604801 */:
            case FinalCanbus.CAR_RZC_XP1_298JieDe /* 3670314 */:
            case FinalCanbus.CAR_WC2_Honda_23HRV /* 3670337 */:
            case FinalCanbus.CAR_RZC_15FengFan /* 3735850 */:
            case FinalCanbus.CAR_WC2_Honda_17URV /* 3735873 */:
            case FinalCanbus.CAR_RZC_16LingPai_HI /* 3801386 */:
            case FinalCanbus.CAR_WC2_Honda_21LIFE /* 3801409 */:
            case FinalCanbus.CAR_RZC_15LingPai_MILOW /* 3866922 */:
            case FinalCanbus.CAR_WC2_Honda_21MNV /* 3866945 */:
            case FinalCanbus.CAR_WC2_Honda_22Integra /* 3932481 */:
            case FinalCanbus.CAR_WC2_Honda_14Vezel /* 3998017 */:
            case FinalCanbus.CAR_RZC_HONDA_23CRV /* 4063530 */:
            case FinalCanbus.CAR_WC2_Honda_13Jade /* 4063553 */:
            case FinalCanbus.CAR_RZC_HONDA_23XRV /* 4129066 */:
            case FinalCanbus.CAR_WC2_Honda_15Greiz /* 4129089 */:
            case FinalCanbus.CAR_WC2_Honda_17Gienia /* 4194625 */:
            case FinalCanbus.CAR_WC2_Honda_14Jazz /* 4260161 */:
            case FinalCanbus.CAR_WC2_Honda_15Spirior /* 4325697 */:
            case FinalCanbus.CAR_WC2_Honda_18Clarity /* 4391233 */:
            case FinalCanbus.CAR_WC2_Honda_15Pilot /* 4456769 */:
            case FinalCanbus.CAR_WC2_Honda_19Passport /* 4522305 */:
            case FinalCanbus.CAR_WC2_Honda_18Insight /* 4587841 */:
            case FinalCanbus.CAR_RZC_HONDA_23FIT_Taiwan /* 4653354 */:
            case FinalCanbus.CAR_WC2_Honda_12CRV_SP /* 4653377 */:
            case FinalCanbus.CAR_RZC_HONDA_23HRV_Taiwan /* 4718890 */:
            case FinalCanbus.CAR_WC2_Honda_12Civic_SP /* 4718913 */:
            case FinalCanbus.CAR_WC2_Honda_14Civic_L_SP /* 4784449 */:
            case FinalCanbus.CAR_WC2_Honda_14Civic_H_SP /* 4849985 */:
            case FinalCanbus.CAR_RZC_HONDA_21Fit_H /* 4915498 */:
            case FinalCanbus.CAR_WC2_Honda_19CRV_H /* 4915521 */:
            case FinalCanbus.CAR_RZC_HONDA_23StepWGN /* 4981034 */:
            case FinalCanbus.CAR_WC2_Honda_14Vezel_H /* 4981057 */:
            case FinalCanbus.CAR_RZC_HONDA_21StepWGN /* 5046570 */:
            case FinalCanbus.CAR_WC2_Honda_21CRV_H /* 5046593 */:
            case FinalCanbus.CAR_RZC_HONDA_23HRV /* 5112106 */:
            case FinalCanbus.CAR_WC2_Honda_17Elysion_H /* 5112129 */:
            case FinalCanbus.CAR_RZC_HONDA_23BRV /* 5177642 */:
            case FinalCanbus.CAR_WC2_Honda_19Elysion_H /* 5177665 */:
            case FinalCanbus.CAR_RZC_HONDA_19NBox /* 5243178 */:
            case FinalCanbus.CAR_WC2_Honda_19Aodesai_H /* 5243201 */:
            case FinalCanbus.CAR_RZC_HONDA_19Freed /* 5308714 */:
            case FinalCanbus.CAR_WC2_Honda_21BREEZE_H /* 5308737 */:
            case FinalCanbus.CAR_RZC_HONDA_CRV_TW6_L /* 5374250 */:
            case FinalCanbus.CAR_RZC_HONDA_SIYU_06_SP /* 5439786 */:
            case FinalCanbus.CAR_WC2_Honda_22Accord_H /* 5439809 */:
            case FinalCanbus.CAR_RZC_HONDA_CRV_TW6_CCD /* 5505322 */:
            case FinalCanbus.CAR_RZC_HONDA_22CRV_EV /* 5898538 */:
            case FinalCanbus.CAR_RZC_HONDA_22CRV_EV_H /* 5964074 */:
            case FinalCanbus.CAR_RZC_HONDA_22Haoying_EV /* 6029610 */:
            case FinalCanbus.CAR_RZC_HONDA_22Haoying_EV_H /* 6095146 */:
            case FinalCanbus.CAR_RZC_HONDA_24Aodesai /* 6160682 */:
            case FinalCanbus.CAR_RZC_HONDA_24Aodesai_H /* 6226218 */:
            case FinalCanbus.CAR_RZC_HONDA_18Pilot /* 6291754 */:
            case FinalCanbus.CAR_RZC_HONDA_18Pilot_H /* 6357290 */:
            case FinalCanbus.CAR_RZC_HONDA_SIYU_06_SP_H /* 6422826 */:
            case FinalCanbus.CAR_RZC_HONDA_SIYU_08_TypeR /* 6488362 */:
            case FinalCanbus.CAR_RZC_HONDA_SIYU_08_TypeR_H /* 6553898 */:
            case FinalCanbus.CAR_RZC_HONDA_Yage_03 /* 6619434 */:
            case FinalCanbus.CAR_RZC_HONDA_Yage_03_H /* 6684970 */:
            case FinalCanbus.CAR_RZC_HONDA_22CRV_CEV /* 6750506 */:
            case FinalCanbus.CAR_RZC_HONDA_22CRV_CEV_H /* 6816042 */:
            case FinalCanbus.CAR_RZC_HONDA_22Haoying_CEV /* 6881578 */:
            case FinalCanbus.CAR_RZC_HONDA_22Haoying_CEV_H /* 6947114 */:
            case FinalCanbus.CAR_RZC_HONDA_17URV /* 7012650 */:
            case FinalCanbus.CAR_RZC_HONDA_17URV_H /* 7078186 */:
                if (LauncherApplication.getConfiguration() == 1) {
                    cls = HondaIndexActi.class;
                    break;
                } else {
                    cls = ActivitySiYuIndex.class;
                    break;
                }
            case 326:
            case 329:
            case FinalCanbus.CAR_DJ_DongNanDX7 /* 131401 */:
            case FinalCanbus.CAR_RZC_OD_DongNanDX7_15_17 /* 328009 */:
            case FinalCanbus.CAR_RZC_OD_DongNanDX5_18_20 /* 393545 */:
            case FinalCanbus.CAR_RZC_XP1_DongNanDX7_Low /* 459081 */:
            case FinalCanbus.CAR_RZC_OD_DongNanDX7_18_20_H /* 655689 */:
            case FinalCanbus.CAR_CZH_OD_DongNanDX7_18_20_H /* 721225 */:
                cls = XfyDx7IndexAct.class;
                break;
            case 330:
            case 334:
            case FinalCanbus.CAR_RZC_XP1_YiHu2017 /* 131406 */:
            case FinalCanbus.CAR_RZC_15Ruijie /* 196942 */:
            case FinalCanbus.CAR_RZC_ZhiSheng_Old /* 262478 */:
            case FinalCanbus.CAR_RZC_Lingjie2019 /* 459086 */:
            case FinalCanbus.CAR_RZC_Explorer /* 590158 */:
            case FinalCanbus.CAR_RZC_XP1_YiHu2017_M /* 655694 */:
            case FinalCanbus.CAR_RZC_XP1_YiHu2017_H /* 721230 */:
            case FinalCanbus.CAR_RZC_Escape_20 /* 917838 */:
            case FinalCanbus.CAR_RZC_NewFiestar /* 983374 */:
            case FinalCanbus.CAR_RZC_Ford_Transit /* 1114446 */:
            case FinalCanbus.CAR_RZC_Lingjie2019_M /* 1179982 */:
            case FinalCanbus.CAR_RZC_Lingjie2019_H /* 1245518 */:
            case FinalCanbus.CAR_RZC_Ecosport /* 1311054 */:
            case FinalCanbus.CAR_RZC_Ford_18Everest_FLB /* 1376590 */:
            case FinalCanbus.CAR_RZC_Ford_18Everest_FLB_H /* 1442126 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_SUV_Low1 /* 1507662 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_SUV_Low2 /* 1573198 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_PickUP_Low /* 1638734 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_PickUP_H /* 1704270 */:
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
            case FinalCanbus.CAR_RZC_Explorer_13 /* 3014990 */:
            case FinalCanbus.CAR_RZC_Ford_Transit_22_Overseas /* 3211598 */:
            case FinalCanbus.CAR_RZC_LHT_Ford_F150_13 /* 3277134 */:
            case FinalCanbus.CAR_RZC_Ford_Puma_22 /* 3670350 */:
            case FinalCanbus.CAR_RZC_Ford_Ranger_15_Vietnam /* 3735886 */:
            case FinalCanbus.CAR_RZC_Ford_Ranger_20_Turkey /* 3801422 */:
            case FinalCanbus.CAR_CZH_RZC_Focus2015 /* 3866958 */:
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
            case FinalCanbus.CAR_RZC_XP1_OldFiestar_M /* 4981070 */:
            case FinalCanbus.CAR_RZC_XP1_OldFiestar_H /* 5046606 */:
            case FinalCanbus.CAR_RZC_Ford_Transit_M /* 5112142 */:
            case FinalCanbus.CAR_RZC_Ford_Transit_H /* 5177678 */:
            case FinalCanbus.CAR_RZC_Ford_Transit_22_OS_M /* 5243214 */:
            case FinalCanbus.CAR_RZC_Ford_Transit_22_OS_H /* 5308750 */:
            case FinalCanbus.CAR_RZC_Ford_Puma_22_M /* 5636430 */:
            case FinalCanbus.CAR_RZC_Ford_Puma_22_H /* 5701966 */:
                cls = FordIndexAct.class;
                break;
            case 332:
            case FinalCanbus.CAR_SB_GM /* 65868 */:
                cls = SaiOu3Index.class;
                break;
            case 339:
            case FinalCanbus.CAR_RZC4_PSA_19_C4L /* 131411 */:
            case FinalCanbus.CAR_RZC4_PSA_19_508 /* 196947 */:
            case FinalCanbus.CAR_RZC4_PSA_19_C3_XR_L /* 262483 */:
            case FinalCanbus.CAR_RZC4_PSA_19_C3_XR_M /* 328019 */:
            case FinalCanbus.CAR_RZC4_PSA_19_C3_XR_H /* 393555 */:
            case FinalCanbus.CAR_RZC4_PSA_ALL_M /* 459091 */:
            case FinalCanbus.CAR_RZC4_PSA_ALL_H /* 524627 */:
            case FinalCanbus.CAR_RZC4_PSA_17_3008 /* 721235 */:
            case FinalCanbus.CAR_RZC4_PSA_17_3008_M /* 786771 */:
            case FinalCanbus.CAR_RZC4_PSA_17_3008_H /* 852307 */:
            case FinalCanbus.CAR_RZC4_PSA_14_2008 /* 917843 */:
            case FinalCanbus.CAR_RZC4_PSA_14_2008_M /* 983379 */:
            case FinalCanbus.CAR_RZC4_PSA_14_2008_H /* 1048915 */:
            case FinalCanbus.CAR_RZC4_PSA_05_Xsars /* 1114451 */:
            case FinalCanbus.CAR_RZC4_PSA_06_206 /* 1179987 */:
            case FinalCanbus.CAR_RZC4_PSA_07_307 /* 1245523 */:
            case FinalCanbus.CAR_RZC4_PSA_17_BerLingo_Turkey /* 1311059 */:
            case FinalCanbus.CAR_RZC4_PSA_17_5008 /* 1376595 */:
            case FinalCanbus.CAR_RZC4_PSA_11_C3_Turkey /* 1442131 */:
            case FinalCanbus.CAR_RZC4_PSA_16_CELYSEE_Turkey /* 1507667 */:
            case FinalCanbus.CAR_RZC4_PSA_19_BerLingo_Turkey /* 1573203 */:
            case FinalCanbus.CAR_RZC4_PSA_04_407 /* 1638739 */:
            case FinalCanbus.CAR_RZC4_PSA_C4_OE_L /* 2228563 */:
            case FinalCanbus.CAR_RZC4_PSA_C4_OE_M /* 2294099 */:
            case FinalCanbus.CAR_RZC4_PSA_C4_OE_H /* 2359635 */:
                cls = RZC_BZ408IndexActi.class;
                break;
            case 347:
                cls = YLFocusIndex.class;
                break;
            case 349:
                cls = KaYanAct.class;
                break;
            case 350:
            case FinalCanbus.CAR_HAOZHENG_XP1_Bmw_X1 /* 65886 */:
            case FinalCanbus.CAR_HAOZHENG_XP1_Bmw_E90 /* 131422 */:
            case FinalCanbus.CAR_HAOZHENG_XP1_Bmw_120i /* 196958 */:
            case FinalCanbus.CAR_HAOZHENG_XP1_Bmw_130i /* 262494 */:
            case FinalCanbus.CAR_HAOZHENG_XP1_Bmw_318i /* 328030 */:
            case FinalCanbus.CAR_HAOZHENG_XP1_Bmw_320i /* 393566 */:
            case FinalCanbus.CAR_HAOZHENG_XP1_Bmw_325i /* 459102 */:
                cls = BmwIndexAct.class;
                break;
            case 352:
            case FinalCanbus.CAR_WC2_RENAULT_KeLeiAo /* 65888 */:
            case FinalCanbus.CAR_WC2_RENAULT_KeLeiJia /* 131424 */:
            case FinalCanbus.CAR_WC2_RENAULT_CLIO4 /* 196960 */:
            case FinalCanbus.CAR_WC2_RENAULT_04_07Megane2 /* 328032 */:
            case FinalCanbus.CAR_WC2_RENAULT_Megane3 /* 393568 */:
            case FinalCanbus.CAR_WC2_RENAULT_12Fluence /* 524640 */:
            case FinalCanbus.CAR_WC2_RENAULT_DUSTER /* 590176 */:
            case FinalCanbus.CAR_WC2_RENAULT_LATITUDE /* 655712 */:
            case FinalCanbus.CAR_WC2_RENAULT_12Fluence_M /* 721248 */:
            case FinalCanbus.CAR_WC2_RENAULT_12Fluence_H /* 786784 */:
            case FinalCanbus.CAR_WC2_RENAULT_16DACIA_SANDERO /* 852320 */:
            case FinalCanbus.CAR_WC2_RENAULT_Symbol /* 917856 */:
            case FinalCanbus.CAR_WC2_RENAULT_CLIO3 /* 2294112 */:
                cls = Megane4SetActi.class;
                break;
            case 354:
            case FinalCanbus.CAR_XP1_14SanLinPajero_M /* 65890 */:
                cls = SanlinXPCarSet.class;
                break;
            case 360:
                cls = Wc_360_DspinfoActi.class;
                break;
            case 362:
            case FinalCanbus.CAR_RZC3_18_Zhipao /* 65898 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_All /* 131434 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_18Sonata9_L /* 196970 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_10_15IX35 /* 393578 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_19FeiSiTa /* 459114 */:
            case FinalCanbus.CAR_RZC3_XianDai_Rohens /* 590186 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_19FeiSiTa_L /* 655722 */:
            case FinalCanbus.CAR_RZC3_XianDai_15Veloster /* 721258 */:
            case FinalCanbus.CAR_RZC3_XianDai_15I40 /* 786794 */:
            case FinalCanbus.CAR_RZC3_Qiya_16Cadenza /* 852330 */:
            case FinalCanbus.CAR_RZC3_Qiya_15Grandeur /* 917866 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_15Sonata8 /* 983402 */:
            case FinalCanbus.CAR_RZC3_Qiya_16K3 /* 1048938 */:
            case FinalCanbus.CAR_RZC3_Qiya_17KX7 /* 1114474 */:
            case FinalCanbus.CAR_RZC3_Qiya_17KX_CORSS /* 1180010 */:
            case FinalCanbus.CAR_RZC3_XianDai_Rohens_Coupe /* 1245546 */:
            case FinalCanbus.CAR_RZC3_XianDai_Rohens_Coupe_12 /* 1311082 */:
            case FinalCanbus.CAR_RZC3_XianDai_SPORTAGE_16 /* 1442154 */:
            case FinalCanbus.CAR_RZC3_XianDai_SOUL_19 /* 1638762 */:
            case FinalCanbus.CAR_RZC3_XianDai_CARNIVAL_19 /* 1704298 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_IX35_10 /* 1769834 */:
            case FinalCanbus.CAR_RZC3_XianDai_I30_15 /* 1835370 */:
            case FinalCanbus.CAR_RZC3_XianDai_CEED_11 /* 1900906 */:
            case FinalCanbus.CAR_RZC3_XianDai_Sorento_18 /* 2031978 */:
            case FinalCanbus.CAR_RZC3_Qiya_16KX7_Import /* 2097514 */:
            case FinalCanbus.CAR_RZC3_Qiya_18Tucson_Import /* 2163050 */:
            case FinalCanbus.CAR_RZC3_Qiya_15K5_Import /* 2228586 */:
            case FinalCanbus.CAR_RZC3_XianDai_13Rohens /* 2294122 */:
            case FinalCanbus.CAR_RZC3_XianDai_12GRANDEUR_HG240 /* 2359658 */:
            case FinalCanbus.CAR_RZC3_XianDai_14GENESIS_G330 /* 2425194 */:
                cls = RZCXiandaiRohensCarSet.class;
                break;
            case 365:
            case FinalCanbus.CAR_AY1_JeepZiYouGuang_M /* 65901 */:
            case FinalCanbus.CAR_AY1_JeepZiYouGuang_H /* 131437 */:
                cls = JeepIndexAct.class;
                break;
            case 371:
            case FinalCanbus.CAR_BoGoo_XP1_Jeep15ZiYouGuang_M /* 65907 */:
            case FinalCanbus.CAR_BoGoo_XP1_Jeep15ZiYouGuang_H /* 131443 */:
                cls = Bg_ZiYouguang_IndexAct.class;
                break;
            case 372:
            case FinalCanbus.CAR_WC1_Jeep_ZiYouGuang_M /* 65908 */:
            case FinalCanbus.CAR_WC1_Jeep_ZiYouGuang_H /* 131444 */:
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
                cls = Wc_372_IndexAct.class;
                break;
            case 373:
            case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_H /* 65909 */:
            case FinalCanbus.CAR_RZC_XP1_GrdCherokee /* 196981 */:
            case FinalCanbus.CAR_RZC_17ZhiNanZhe /* 262517 */:
            case FinalCanbus.CAR_RZC_17ZhiNanZhe_H /* 328053 */:
            case FinalCanbus.CAR_RZC_XP1_GrdCherokee_H /* 459125 */:
            case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19 /* 852341 */:
            case FinalCanbus.CAR_RZC_XP1_ZiYouGuang_19_H /* 917877 */:
            case FinalCanbus.CAR_RZC_Chrysler_300C /* 1048949 */:
                cls = Rzc_ZiYouguang_IndexAct.class;
                break;
            case 374:
            case FinalCanbus.CAR_XP1_ZiYouGuang_H /* 65910 */:
                if (LauncherApplication.getConfiguration() == 1) {
                    cls = Xp_374_FunctionlActi.class;
                    break;
                } else {
                    cls = Xp_374_IndexActi.class;
                    break;
                }
            case 375:
                cls = X80Act.class;
                break;
            case 376:
                cls = ActivityTireRuiFengS5.class;
                break;
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
            case FinalCanbus.CAR_HC_GM_GL6 /* 2294139 */:
            case FinalCanbus.CAR_BNR_RZC_Mairuibao_L /* 2359675 */:
            case FinalCanbus.CAR_BNR_RZC_Mairuibao_H /* 2425211 */:
            case FinalCanbus.CAR_BNR_RZC_Mairuibao_Top /* 2490747 */:
                cls = YLIndexAct.class;
                break;
            case 380:
                cls = FocusSyncBtActi.class;
                break;
            case 385:
                cls = Hc_385_CarCdAct.class;
                break;
            case 386:
            case FinalCanbus.CAR_Bagoo_XP1_NewBmwSeries_NoCD /* 65922 */:
                cls = BaguBmwIndexAct.class;
                break;
            case 388:
            case FinalCanbus.CAR_XC_08TianLai_LOW /* 65924 */:
            case FinalCanbus.CAR_XP_OLD_9TianLai /* 196996 */:
                cls = TianLai09Act.class;
                break;
            case 390:
            case FinalCanbus.CAR_XBS_XP1_ZhongTaiT600_H /* 65926 */:
                cls = XBSZTT600CarTire.class;
                break;
            case 402:
            case FinalCanbus.CAR_BSD_XP1_SHUPING_RENAULT_KeLeiAo /* 65938 */:
            case FinalCanbus.CAR_BSD_XP1_SHUPING_RENAULT_KeLeiAo_H /* 131474 */:
            case FinalCanbus.CAR_BNR_17LIENUO_L /* 262546 */:
            case FinalCanbus.CAR_BNR_17LIENUO_M /* 328082 */:
            case FinalCanbus.CAR_BNR_17LIENUO_H /* 393618 */:
            case FinalCanbus.CAR_BNR_17KeLeiJia_L /* 459154 */:
            case FinalCanbus.CAR_BNR_17KeLeiJia_H /* 524690 */:
            case FinalCanbus.CAR_BNR_18KeLeiAo_M /* 590226 */:
            case FinalCanbus.CAR_RZC_17LIENUO_L /* 655762 */:
            case FinalCanbus.CAR_RZC_17LIENUO_M /* 721298 */:
            case FinalCanbus.CAR_RZC_17LIENUO_H /* 786834 */:
            case FinalCanbus.CAR_RZC_17KeLeiJia_L /* 852370 */:
            case FinalCanbus.CAR_RZC_17KeLeiJia_H /* 917906 */:
            case FinalCanbus.CAR_RZC_18KeLeiAo_M /* 983442 */:
            case FinalCanbus.CAR_RZC_18KeLeiAo_H /* 1048978 */:
            case FinalCanbus.CAR_RZC_18KeLeiAo_L /* 1114514 */:
            case FinalCanbus.CAR_RZC_17_18KeleiAo /* 1180050 */:
            case FinalCanbus.CAR_RZC_17_18KeleiAo_M /* 1311122 */:
            case FinalCanbus.CAR_RZC_17_18KeleiAo_H /* 1376658 */:
            case FinalCanbus.CAR_RZC_SANDERO_Brazil /* 1442194 */:
            case FinalCanbus.CAR_RZC_DUSTER_Brazil /* 1507730 */:
            case FinalCanbus.CAR_RZC_CAPTUR_Brazil /* 1573266 */:
            case FinalCanbus.CAR_RZC_MEGANE_Turkey_L /* 1638802 */:
            case FinalCanbus.CAR_RZC_MEGANE_Turkey_M /* 1704338 */:
            case FinalCanbus.CAR_RZC_MEGANE_Turkey_H /* 1769874 */:
            case FinalCanbus.CAR_RZC_CAPTUR_Turkey /* 1835410 */:
            case FinalCanbus.CAR_RZC_CLIO_Turkey /* 1900946 */:
            case FinalCanbus.CAR_RZC_KADJAR_Turkey /* 1966482 */:
            case FinalCanbus.CAR_RZC_CLIO5_Turkey /* 2032018 */:
            case FinalCanbus.CAR_RZC_CLIO5_Turkey_M /* 2097554 */:
            case FinalCanbus.CAR_RZC_CLIO5_Turkey_H /* 2163090 */:
            case FinalCanbus.CAR_RZC_MEGANE_Turkey_L_AUTO /* 2228626 */:
            case FinalCanbus.CAR_RZC_17LIENUO_LOW /* 3277202 */:
            case FinalCanbus.CAR_RZC_18KeLeiAo_LOW /* 3342738 */:
            case FinalCanbus.CAR_RZC_RENAULT_ARKANA /* 3408274 */:
            case FinalCanbus.CAR_RZC_RENAULT_ARKANA_H /* 3473810 */:
            case FinalCanbus.CAR_RZC_UAZ /* 3539346 */:
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
            case FinalCanbus.CAR_RZC_Vesta_21 /* 6160786 */:
            case FinalCanbus.CAR_RZC_Renault_SM6_18 /* 6226322 */:
            case FinalCanbus.CAR_RZC_Renault_SCENIC_16 /* 6291858 */:
            case FinalCanbus.CAR_RZC_Renault_SM6_18_M /* 6357394 */:
            case FinalCanbus.CAR_RZC_Renault_SCENIC_16_M /* 6422930 */:
            case FinalCanbus.CAR_RZC_Renault_SM6_18_H /* 6488466 */:
            case FinalCanbus.CAR_RZC_Renault_SCENIC_16_H /* 6554002 */:
            case FinalCanbus.CAR_RZC_Renault_Dokker_18 /* 6750610 */:
            case FinalCanbus.CAR_RZC_Renault_Dokker_18_H /* 6816146 */:
            case FinalCanbus.CAR_RZC_17LIENUO_L_AUTO /* 6881682 */:
                cls = KeLeiJiaIndexActi.class;
                break;
            case 403:
            case FinalCanbus.CAR_BNR_XP1_ShuPingFord_YIHU /* 65939 */:
            case FinalCanbus.CAR_BNR_XP1_ShuPingFord_YIHU_H /* 131475 */:
            case FinalCanbus.CAR_BNR_KX_ShuPingFord_Mengdiou /* 197011 */:
                cls = Activity_ford_index.class;
                break;
            case 404:
            case FinalCanbus.CAR_RZC_XP1_QiRuiRuiHu7 /* 65940 */:
            case FinalCanbus.CAR_RZC_XP1_QiRuiAiRuiZe7 /* 197012 */:
            case FinalCanbus.CAR_RZC_XP1_18QiRuiAiRuiZeGX /* 262548 */:
            case FinalCanbus.CAR_RZC_XP1_18QiRuiAiRuiZeGX_H /* 328084 */:
            case FinalCanbus.CAR_RZC_XP1_19QiRuiHu5X /* 393620 */:
            case FinalCanbus.CAR_RZC_XP1_19QiRuiHu5X_H /* 459156 */:
            case FinalCanbus.CAR_RZC_XP1_18JieTU_X70 /* 524692 */:
            case FinalCanbus.CAR_RZC_XP1_19AiRuiZe5 /* 590228 */:
            case FinalCanbus.CAR_RZC_XP1_19AiRuiZe5_H /* 655764 */:
            case FinalCanbus.CAR_RZC_XP1_18QiRuiRuiHu7 /* 721300 */:
            case FinalCanbus.CAR_RZC_XP1_18QiRuiRuiHu7_H /* 786836 */:
            case FinalCanbus.CAR_RZC_XP1_18QiRuiRuiHu8 /* 852372 */:
            case FinalCanbus.CAR_RZC_XP1_18QiRuiRuiHu8_H /* 917908 */:
            case FinalCanbus.CAR_RZC_XP1_20QiRuiRuiHu7 /* 1048980 */:
            case FinalCanbus.CAR_RZC_XP1_20QiRuiRuiHu3x /* 1114516 */:
            case FinalCanbus.CAR_RZC_XP1_20QiRuiRuiHu8 /* 1180052 */:
            case FinalCanbus.CAR_RZC_XP1_15QiRuiRuiHu5 /* 1245588 */:
            case FinalCanbus.CAR_RZC_XP1_18JieTU_X70_H /* 1311124 */:
            case FinalCanbus.CAR_RZC_XP1_20Ruihu_5X /* 1442196 */:
            case FinalCanbus.CAR_RZC_XP1_21Ruihu_3X /* 1507732 */:
            case FinalCanbus.CAR_RZC_LUZ_18QiRuiRuiHu8 /* 1704340 */:
            case FinalCanbus.CAR_RZC_XP1_19X90 /* 1835412 */:
            case FinalCanbus.CAR_RZC_OD_18JieTU_X70 /* 1900948 */:
            case FinalCanbus.CAR_RZC_XP1_22Ruihu_3X /* 2032020 */:
            case FinalCanbus.CAR_RZC_XP1_23Ruihu_3X /* 2097556 */:
            case FinalCanbus.CAR_RZC_XP1_22AiRuiZe5 /* 2163092 */:
            case FinalCanbus.CAR_RZC_QiRui_Guojin_Junxing /* 2228628 */:
            case FinalCanbus.CAR_RZC_XP1_23Ruihu_5X /* 2294164 */:
            case FinalCanbus.CAR_OD_RZC_23QiRuiAiRuiZeE /* 2359700 */:
            case FinalCanbus.CAR_RZC_XP1_23AiRuiZe5 /* 2425236 */:
            case FinalCanbus.CAR_RZC_XP1_23AiRuiZe5_EV /* 2490772 */:
            case FinalCanbus.CAR_OD_RZC_20Showjet /* 2687380 */:
            case FinalCanbus.CAR_RZC_OD_18JieTU_X70_H /* 2752916 */:
            case FinalCanbus.CAR_RZC_OD_19JieTU_X90 /* 2818452 */:
            case FinalCanbus.CAR_RZC_OD_19JieTU_X90_H /* 2883988 */:
                cls = ActivityQiRuiAiRuiZe.class;
                break;
            case 406:
            case FinalCanbus.CAR_XFY_XP1_ZhongTaiSR7_H /* 131478 */:
                cls = ActivitySR7Setting.class;
                break;
            case 407:
                cls = ActGS4LowSetting.class;
                break;
            case 411:
            case FinalCanbus.CAR_WC2_LandRover_H /* 65947 */:
                DataCanbus.PROXY.cmd(2, new int[]{241, 255}, null, null);
                return;
            case 414:
                cls = Acti_Xima_Xfy.class;
                break;
            case 415:
            case FinalCanbus.CAR_WC_Haval_Coupe_H /* 65951 */:
            case FinalCanbus.CAR_WC_Haval_18Coupe /* 131487 */:
            case FinalCanbus.CAR_WC_Haval_18Coupe_H /* 197023 */:
            case FinalCanbus.CAR_WC_Haval_18Coupe_TOP /* 262559 */:
            case FinalCanbus.CAR_WC_Haval_Coupe_TOP /* 328095 */:
                cls = WcHavalH6CoupeActi.class;
                break;
            case 416:
            case FinalCanbus.CAR_WC2_17MingJue6 /* 65952 */:
            case FinalCanbus.CAR_WC2_RongWei_I6 /* 197024 */:
            case FinalCanbus.CAR_WC2_RongWei_HS /* 393632 */:
                cls = Wc_416_RongWei_CarSetAct.class;
                break;
            case 418:
                cls = XBS_AngKeSaiLa_Cx4_IndexAct.class;
                break;
            case 420:
            case FinalCanbus.CAR_WC2_ToYoTa_10_Crown_HY /* 65956 */:
            case FinalCanbus.CAR_WC2_ToYoTa_10_Crown_LOW /* 131492 */:
            case FinalCanbus.CAR_WC2_ToYoTa_10_Crown_RADIO /* 262564 */:
            case FinalCanbus.CAR_WC2_ToYoTa_10_Crown_NoAmp /* 328100 */:
            case FinalCanbus.CAR_WC2_ToYoTa_13_Crown_H /* 393636 */:
            case FinalCanbus.CAR_WC2_ToYoTa_Lexus_05LX470 /* 459172 */:
            case FinalCanbus.CAR_WC2_ToYoTa_Lexus_08RX300 /* 524708 */:
            case FinalCanbus.CAR_WC2_ToYoTa_Lexus_08RX350 /* 590244 */:
            case FinalCanbus.CAR_WC2_ToYoTa_Lexus_09IS_Low /* 721316 */:
            case FinalCanbus.CAR_WC2_ToYoTa_Lexus_06LS460 /* 786852 */:
                cls = Wc_420_IndexAct.class;
                break;
            case 425:
            case FinalCanbus.CAR_XFY_ShuPing_Honda_GuanDao_H /* 65961 */:
                cls = ActivityGuanDaoIndex.class;
                break;
            case 428:
                cls = Biaozhi206OilPage.class;
                break;
            case 429:
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_12Crown_AMP /* 65965 */:
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_12Crown_AMP_H /* 131501 */:
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_13Crown_AMP /* 197037 */:
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_12Crown_ShuPing /* 262573 */:
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_12Crown_H_ShuPing /* 328109 */:
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_14Prodo_H_ShuPing /* 459181 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown /* 590253 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown /* 655789 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_12Crown_L /* 721325 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_13Crown_L /* 786861 */:
            case FinalCanbus.CAR_DJ_XC_Nissan_Tianlai_03_07 /* 852397 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_10_13PRADO /* 917933 */:
            case FinalCanbus.CAR_DJ_XC_TOYOTA_08_15LAND_CRUISER /* 983469 */:
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_HIGHLANDER /* 1114541 */:
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_HIGHLANDER_H /* 1180077 */:
                cls = ActivityHuangGuanIndex.class;
                break;
            case 430:
                cls = ActivityWCTianLaiCarCD.class;
                break;
            case 431:
            case FinalCanbus.CAR_431_BG_PSAALL /* 65967 */:
                cls = PsasettingActi_HC.class;
                break;
            case 434:
                cls = ActivityFiatCarUSB.class;
                break;
            case 439:
            case FinalCanbus.CAR_RZC4_PSA_19_408 /* 590163 */:
            case FinalCanbus.CAR_RZC4_PSA_19_408_H /* 655699 */:
            case FinalCanbus.CAR_RZC4_PSA_ALL_NoAir_L /* 2031955 */:
            case FinalCanbus.CAR_RZC4_PSA_ALL_NoAir_M /* 2097491 */:
            case FinalCanbus.CAR_RZC4_PSA_ALL_NoAir_H /* 2163027 */:
                cls = RZC_BZ408IndexActi.class;
                break;
            case 443:
            case FinalCanbus.CAR_443_WC2_OULANDE_H /* 7012795 */:
            case FinalCanbus.CAR_443_WC2_Pajero_Sport /* 8716731 */:
            case FinalCanbus.CAR_443_WC2_OUTLANDER_21 /* 8782267 */:
            case FinalCanbus.CAR_443_WC2_OUTLANDER_22 /* 8847803 */:
            case FinalCanbus.CAR_443_WC2_Triton_23 /* 8913339 */:
            case FinalCanbus.CAR_443_WC2_Xpander_23 /* 8978875 */:
            case FinalCanbus.CAR_443_WC2_Pajero_11 /* 9044411 */:
            case FinalCanbus.CAR_443_WC2_Galant_07 /* 9109947 */:
            case FinalCanbus.CAR_443_WC2_Triton_23_H /* 9175483 */:
            case FinalCanbus.CAR_443_WC2_Xpander_23_H /* 9241019 */:
            case FinalCanbus.CAR_443_WC2_Pajero_17 /* 14352827 */:
            case FinalCanbus.CAR_443_WC2_Pajero_23 /* 14418363 */:
            case FinalCanbus.CAR_443_WC2_Xpander_22 /* 14811579 */:
            case FinalCanbus.CAR_443_WC2_Xpander_22_H /* 14877115 */:
                cls = WC2SanlinCarInfo.class;
                break;
            case 444:
            case FinalCanbus.CAR_444_WC2_Perodua_Aruz_17 /* 65980 */:
            case FinalCanbus.CAR_444_WC2_Perodua_Bezza_16 /* 131516 */:
            case FinalCanbus.CAR_444_WC2_Perodua_ALZA_H /* 2884028 */:
            case FinalCanbus.CAR_443_WC2_Perodua_ALZA /* 10224059 */:
            case FinalCanbus.CAR_443_WC2_Perodua_ATIVA /* 10289595 */:
            case FinalCanbus.CAR_443_WC2_Perodua_AXIA /* 10355131 */:
                cls = WCPeroduaAllCarSet.class;
                break;
            case 448:
            case FinalCanbus.CAR_448_ZX_Yage10 /* 131520 */:
                cls = LZBmwIndexFunc.class;
                break;
            case 450:
            case FinalCanbus.CAR_450_ZHTD_Benz /* 65986 */:
            case FinalCanbus.CAR_450_ZHTD_Audi /* 131522 */:
            case FinalCanbus.CAR_450_ZHTD_Benz_S /* 197058 */:
            case FinalCanbus.CAR_450_ZHTD_Lexus /* 262594 */:
            case FinalCanbus.CAR_450_ZHTD_LandRover /* 328130 */:
            case FinalCanbus.CAR_450_CM_ZHTD_BMWM /* 393666 */:
            case FinalCanbus.CAR_450_ZHTD_Audi_A3 /* 459202 */:
            case FinalCanbus.CAR_450_ZHTD_Volvo /* 524738 */:
            case FinalCanbus.CAR_450_ZHTD_Lexus_L /* 590274 */:
            case FinalCanbus.CAR_450_ZHTD_Porsche /* 655810 */:
                cls = ZhtdBmwSetFunc.class;
                break;
            case FinalCanbus.CAR_XP1_CRV2012_H /* 65583 */:
                cls = KangshengXpCrvActi.class;
                break;
            case FinalCanbus.CAR_RZC_XP1_BenTeng14B70_QC /* 65624 */:
                cls = BengTeng_RZC_17B70QC_Index.class;
                break;
            case FinalCanbus.CAR_BNR_16ZiYouGuang /* 65653 */:
                cls = ActiIndex_Bnr_117_Functionl.class;
                break;
            case FinalCanbus.CAR_WC2_CHANGANCX7 /* 65664 */:
                cls = WCChanganAllTireAct.class;
                break;
            case FinalCanbus.CAR_DJ_ChuanQiGA6_M /* 65793 */:
            case FinalCanbus.CAR_XP2_LUZ_Audi_A3 /* 65803 */:
            case FinalCanbus.CAR_XP2_LUZ_Audi_A4 /* 131339 */:
            case FinalCanbus.CAR_XP2_LUZ_Audi_TT /* 196875 */:
            case FinalCanbus.CAR_XP2_LUZ_Audi_A6_97 /* 262411 */:
            case FinalCanbus.CAR_XP2_LUZ_Audi_R8_08 /* 327947 */:
                cls = LuzAudioOldCarInfo.class;
                break;
            case FinalCanbus.CAR_RZC_MingjueZS /* 65809 */:
            case FinalCanbus.CAR_RZC_XP1_RongWei_RX3 /* 327953 */:
            case FinalCanbus.CAR_RZC_XP1_RongWei_EI5_L /* 393489 */:
            case FinalCanbus.CAR_RZC_XP1_RongWei_EI5_M /* 459025 */:
            case FinalCanbus.CAR_BNR_Mingjue_GS /* 590097 */:
            case FinalCanbus.CAR_BNR_Mingjue_17GS /* 655633 */:
            case FinalCanbus.CAR_BNR_Mingjue_ZS /* 721169 */:
            case FinalCanbus.CAR_BNR_Mingjue_17ZS /* 786705 */:
            case FinalCanbus.CAR_RZC_19MingjueHS /* 852241 */:
            case FinalCanbus.CAR_RZC_19RongWei_I5 /* 917777 */:
            case FinalCanbus.CAR_RZC_19RongWei_I6 /* 983313 */:
            case FinalCanbus.CAR_RZC_19RongWei_I5_H /* 1114385 */:
            case FinalCanbus.CAR_RZC_19MingjueEZS /* 1245457 */:
            case FinalCanbus.CAR_RZC_19RongWei_RX8 /* 1310993 */:
            case FinalCanbus.CAR_RZC_20RongWei_RX5 /* 1704209 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_21 /* 1835281 */:
            case FinalCanbus.CAR_RZC_MingJue_MG5_21_L /* 2031889 */:
                cls = Act17RuiTengCarSet.class;
                break;
            case FinalCanbus.CAR_WC2_MingJueZS /* 65818 */:
                cls = MingjueZS_Wc.class;
                break;
            case FinalCanbus.CAR_XFY_CYT_NaZhiJieU6_ShuPin /* 65826 */:
            case FinalCanbus.CAR_XFY_CYT_NaZhiJieU6_ShuPin_H /* 524578 */:
                cls = ActivityNaZhiJie.class;
                break;
            case FinalCanbus.CAR_RZC_XP1_17ZhongHuaH3 /* 65843 */:
            case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6 /* 131379 */:
            case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6_H /* 196915 */:
                cls = ActivityHavaH3.class;
                break;
            case FinalCanbus.CAR_SBD_WC1_24vW3 /* 65849 */:
            case FinalCanbus.CAR_WC2_14FIESTA /* 65855 */:
                cls = ActivityIndex_14Festia.class;
                break;
            case FinalCanbus.CAR_HC_OLD_TianLai_H /* 65863 */:
            case FinalCanbus.CAR_HC_OLD_YinFeiNiDi_Fx35 /* 131399 */:
            case FinalCanbus.CAR_452_XC_05_TianLai /* 196935 */:
            case FinalCanbus.CAR_XC_OLD_YinFeiNiDi_Fx35 /* 262471 */:
                cls = IndexAct_Hc_03TianLai.class;
                break;
            case FinalCanbus.CAR_DAOJUN_XP1_ATS_M /* 65884 */:
            case FinalCanbus.CAR_DAOJUN_XP1_ATSL_High /* 328028 */:
            case FinalCanbus.CAR_DAOJUN_CT5 /* 1048924 */:
            case FinalCanbus.CAR_DAOJUN_XT4 /* 1114460 */:
            case FinalCanbus.CAR_WC2_GUOCHAN_1 /* 65931 */:
            case FinalCanbus.CAR_WC2_GUOCHAN_2 /* 131467 */:
            case FinalCanbus.CAR_WC2_GUOCHAN_4 /* 262539 */:
            case FinalCanbus.CAR_WC2_GUOCHAN_6 /* 393611 */:
            case FinalCanbus.CAR_WC2_RuiFeng_S2Mini /* 1442187 */:
            case FinalCanbus.CAR_WC2_RUIFENG_M4 /* 1704331 */:
                cls = ZTTireAct_Wc.class;
                break;
            case FinalCanbus.CAR_RZC_XP1_BeiQiM50F /* 65932 */:
            case FinalCanbus.CAR_DJ_SHA_BUS /* 65944 */:
            case FinalCanbus.CAR_XP_Renault_17Captur /* 65960 */:
            case FinalCanbus.CAR_XP_Renault_17Clio /* 131496 */:
            case FinalCanbus.CAR_XP_Renault_17Symbol /* 197032 */:
            case FinalCanbus.CAR_XP_Renault_17Kwid /* 262568 */:
            case FinalCanbus.CAR_XP_Dacia_16Duster /* 328104 */:
            case FinalCanbus.CAR_XP_Dacia_17Lodgy /* 393640 */:
            case FinalCanbus.CAR_XP_Dacia_17Logan /* 459176 */:
            case FinalCanbus.CAR_XP_Dacia_17Dokker /* 524712 */:
            case FinalCanbus.CAR_XP_Dacia_10_15Duster /* 590248 */:
            case FinalCanbus.CAR_XP_Dacia_16Sandero /* 655784 */:
            case FinalCanbus.CAR_XP_Dacia_17Sandero /* 721320 */:
            case FinalCanbus.CAR_XP_Renault_20Clio_Low /* 786856 */:
            case FinalCanbus.CAR_XP_Renault_20Clio_M /* 1049000 */:
            case FinalCanbus.CAR_XP_Renault_20Clio_H /* 1114536 */:
            case FinalCanbus.CAR_XP_Renault_05_17Duster /* 1180072 */:
            case FinalCanbus.CAR_XP_Renault_20ARKANA /* 1245608 */:
            case FinalCanbus.CAR_XP_Renault_15KOLEOS /* 1376680 */:
            case FinalCanbus.CAR_XP_Renault_23KOLEOS_L_Auto /* 1442216 */:
            case FinalCanbus.CAR_XP_Renault_23KOLEOS_L_Hand /* 1507752 */:
            case FinalCanbus.CAR_XP_Renault_23KOLEOS_H_Auto /* 1573288 */:
                cls = Xp_374_AegeaIndexActi.class;
                break;
            case FinalCanbus.CAR_434_XP_Bravo_11 /* 65970 */:
            case FinalCanbus.CAR_434_XP_Punto_10 /* 131506 */:
            case FinalCanbus.CAR_434_XP_Linea_07_Classic /* 197042 */:
            case FinalCanbus.CAR_434_XP_Linea_12 /* 262578 */:
            case FinalCanbus.CAR_434_XP_Palio_12 /* 328114 */:
            case FinalCanbus.CAR_434_XP_Fiorino_09 /* 393650 */:
            case FinalCanbus.CAR_434_XP_Dobol_10 /* 459186 */:
                cls = ActivityFiatIndex.class;
                break;
            case FinalCanbus.CAR_442_KSW_ADUI_Q5 /* 65978 */:
                cls = KswAudiQ5SetFunc.class;
                break;
            case FinalCanbus.CAR_443_WC2_SgmwS /* 65979 */:
            case FinalCanbus.CAR_443_WC2_KangDi /* 131515 */:
                cls = SgmwsAlarmInfoAct.class;
                break;
            case FinalCanbus.CAR_447_OD_RZC_19Tusheng /* 65983 */:
            case FinalCanbus.CAR_447_OD_RZC_19Tusheng_H /* 131519 */:
            case FinalCanbus.CAR_447_OD_RZC_19Tusheng_Top /* 197055 */:
                cls = OD_19Tusheng_CarSettingAct.class;
                break;
            case FinalCanbus.CAR_448_ZX_MZD /* 65984 */:
            case FinalCanbus.CAR_448_ZX_MZD_360 /* 197056 */:
            case FinalCanbus.CAR_448_6606_ZX_MZD /* 262592 */:
            case FinalCanbus.CAR_448_6606_ZX_Honda_CRV_24 /* 328128 */:
            case FinalCanbus.CAR_448_6606_ZX_Honda_CRV_17 /* 393664 */:
            case FinalCanbus.CAR_448_6606_ZX_Honda_Accord_8 /* 459200 */:
            case FinalCanbus.CAR_448_6606_ZX_Honda_Accord_7 /* 524736 */:
            case FinalCanbus.CAR_448_ZX_Chuanqi_GS7 /* 590272 */:
            case FinalCanbus.CAR_448_6606_ZX_MAZ /* 655808 */:
            case FinalCanbus.CAR_448_6606_ZX_Honda_CRV_17_RIGHT /* 721344 */:
                cls = ZXMZDSetFunc.class;
                break;
            case FinalCanbus.CAR_452_XC_Tianlai_GJ /* 65988 */:
            case FinalCanbus.CAR_453_XC_Tianlai_GJ /* 1442245 */:
            case FinalCanbus.CAR_439_HC_TianLai_GongJue_CD /* 6488503 */:
            case FinalCanbus.CAR_439_HC_Nissan_Toread /* 7012791 */:
            case FinalCanbus.CAR_439_HC_Nissan_GuiShi /* 7799223 */:
                cls = ActivityTianLaiCarSettings.class;
                break;
            case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_H /* 65990 */:
            case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_M /* 131526 */:
            case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_L_Auto /* 197062 */:
            case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_L_Hand /* 262598 */:
            case FinalCanbus.CAR_454_Tangdu_Toyota_Lexus_Lx570_10_CD /* 328134 */:
            case FinalCanbus.CAR_454_Tangdu_Toyota_Lexus_Lx570_15_CD /* 393670 */:
            case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_15_TCD /* 459206 */:
            case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_16_TCD /* 524742 */:
            case FinalCanbus.CAR_454_Tangdu_Toyota_LexusGX_13_CD /* 590278 */:
            case FinalCanbus.CAR_454_Tangdu_Toyota_LexusGX_14_CD /* 655814 */:
                cls = LuzLexusISIndexAct.class;
                break;
            case FinalCanbus.CAR_455_LZ_CG_Toyota_4Runner_Auto /* 65991 */:
            case FinalCanbus.CAR_455_LZ_Toyota_Alpha_DH_2 /* 131527 */:
            case FinalCanbus.CAR_455_LZ_Toyota_Alpha_DH_3 /* 197063 */:
            case FinalCanbus.CAR_455_LZ_YL_Toyota_Prado_14 /* 3211719 */:
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11 /* 5177797 */:
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_18 /* 5243333 */:
            case FinalCanbus.CAR_454_LZ_TOYOTA_LC300_KycAir /* 6619590 */:
            case FinalCanbus.CAR_LUZ_Toyato_All /* 7274935 */:
            case FinalCanbus.CAR_LUZ_Toyato_All_H /* 7340471 */:
            case FinalCanbus.CAR_LUZ_Toyato_20All /* 8126903 */:
            case FinalCanbus.CAR_LUZ_Toyato_30All /* 8192439 */:
            case FinalCanbus.CAR_452_LZ_Toyato_RX270 /* 12714436 */:
            case FinalCanbus.CAR_454_LZ_Toyota_Prado /* 14877126 */:
            case FinalCanbus.CAR_454_LZ_Toyota_FJ_CRUISER /* 14942662 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_4Runner /* 15073734 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha /* 15204806 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha_3 /* 16187846 */:
            case FinalCanbus.CAR_454_LZ_Toyota_FJ_CRUISER_3 /* 16253382 */:
            case FinalCanbus.CAR_454_LZ_6606_Toyota_FJ_CRUISER /* 16318918 */:
            case FinalCanbus.CAR_454_LZ_6606_Toyota_FJ_CRUISER_3 /* 16384454 */:
                cls = CamryIndexAct_LuZ.class;
                break;
            case FinalCanbus.CAR_WC1_DaZhong_DZSJ /* 131073 */:
            case FinalCanbus.CAR_WC1_DaZhong_DZSJ1 /* 196609 */:
                cls = VwDashBoard_DZSJ.class;
                break;
            case FinalCanbus.CAR_RZCexc_Feiyate_TORO /* 131111 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_DOBLO /* 196647 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_EGEA /* 262183 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_500L /* 393255 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_500X /* 589863 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_All_L /* 720935 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_All_M /* 786471 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_All_H /* 852007 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_ARGO_19 /* 983079 */:
            case FinalCanbus.CAR_RZCexc_ALFA_ROMEO_GIULIETTA_16 /* 1048615 */:
            case FinalCanbus.CAR_RZCexc_ALFA_ROMEO_159_09 /* 1114151 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_EGEA_M /* 1179687 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_EGEA_H /* 1245223 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_TORO_M /* 1441831 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_TORO_H /* 1507367 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_DOBLO_M /* 1572903 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_DOBLO_H /* 1638439 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_500L_M /* 1835047 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_500L_H /* 1900583 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_500X_M /* 2228263 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_500X_H /* 2293799 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_ARGO_19_M /* 2621479 */:
            case FinalCanbus.CAR_RZCexc_Feiyate_ARGO_19_H /* 2687015 */:
            case FinalCanbus.CAR_RZCexc_ALFA_ROMEO_GIULIETTA_16_M /* 2752551 */:
            case FinalCanbus.CAR_RZCexc_ALFA_ROMEO_GIULIETTA_16_H /* 2818087 */:
            case FinalCanbus.CAR_RZCexc_ALFA_ROMEO_159_09_M /* 2883623 */:
            case FinalCanbus.CAR_RZCexc_ALFA_ROMEO_159_09_H /* 2949159 */:
                cls = RzcFeiyateIndexAct.class;
                break;
            case FinalCanbus.CAR_RZC_XP1_OUSHANG /* 131142 */:
                cls = ChangAnOuShangAct.class;
                break;
            case FinalCanbus.CAR_HC_HONDA_ELYSION /* 131175 */:
                cls = Hc_103_Elysion_IndexAct.class;
                break;
            case FinalCanbus.CAR_WC2_CHANGAN_17CS75 /* 131200 */:
            case FinalCanbus.CAR_WC2_CHANGAN_18YIDONG /* 196736 */:
            case FinalCanbus.CAR_WC2_20Oushang_X7_M /* 589952 */:
                cls = ActivityChangAn17CS75.class;
                break;
            case FinalCanbus.CAR_RZC_XP1_YuanJingX6 /* 131211 */:
                cls = YuanJingX1CarSettingsAct.class;
                break;
            case FinalCanbus.CAR_OUDI_BaoJun530 /* 131214 */:
                cls = ActivityOudiBaojun530Info.class;
                break;
            case FinalCanbus.CAR_XBS_XP1_ChuanQiGS3_H /* 131237 */:
            case FinalCanbus.CAR_XBS_XP1_ChuanQiGE3 /* 196773 */:
                cls = GS3IndexAct.class;
                break;
            case FinalCanbus.CAR_XBS_BYD_16S7 /* 131266 */:
            case FinalCanbus.CAR_XBS_XP1_16BYDTang /* 196802 */:
                cls = Act_Byd_Tang_XBS.class;
                break;
            case FinalCanbus.CAR_OuDi_BiSuT3AndM3 /* 131288 */:
                cls = ActivityBiSuT3AndM3.class;
                break;
            case FinalCanbus.CAR_RZC_DongFeng_JingYiX5 /* 131299 */:
            case FinalCanbus.CAR_RZC_DongFeng_JingYiX5_H /* 327907 */:
            case FinalCanbus.CAR_RZC_DongFeng_19JingYiX5_Low /* 393443 */:
            case FinalCanbus.CAR_RZC_DongFeng_19FengxingSX6_H /* 655587 */:
            case FinalCanbus.CAR_RZC_DongFeng_19FengxingSX6_L /* 721123 */:
            case FinalCanbus.CAR_RZC_DongFeng_JingYiSX60 /* 1048803 */:
            case FinalCanbus.CAR_RZC_DongFeng_Fengxing_M7 /* 1114339 */:
            case FinalCanbus.CAR_RZC_DongFeng_Fengxing_M7_LOW /* 1179875 */:
            case FinalCanbus.CAR_RZC_DongFeng_Fengxing_S60EVE /* 1310947 */:
                cls = ActivityJingYiX5.class;
                break;
            case FinalCanbus.CAR_XBS_XP1_ZhiYouXia /* 131305 */:
            case FinalCanbus.CAR_XBS_XP1_ZhiYouXia_H /* 196841 */:
                cls = Activity_XBS_FunctionlActi.class;
                break;
            case FinalCanbus.CAR_RZC_XP1_16HAIMAMV70 /* 131309 */:
            case FinalCanbus.CAR_RZC_XP1_HAIMA_F5 /* 262381 */:
                cls = ActivityHaiMaV70Index.class;
                break;
            case FinalCanbus.CAR_DJ_ChuanQiGA6_H /* 131329 */:
                cls = GA6CarSetIndexAct.class;
                break;
            case FinalCanbus.CAR_KeYuan_FYTA_DaMaiX7 /* 131330 */:
                cls = ActivityDaMaiX7.class;
                break;
            case FinalCanbus.CAR_WC2_DaZhong_TuRui /* 131342 */:
            case FinalCanbus.CAR_HSY_WC2_DaZhong_TuRui /* 196878 */:
            case FinalCanbus.CAR_LZ_WC2_DaZhong_TuRui /* 262414 */:
            case FinalCanbus.CAR_XC_WC2_DaZhong_TuRui /* 327950 */:
                cls = TuRui_IndexAct.class;
                break;
            case FinalCanbus.CAR_RZC_XP1_RongWei_RX5_NoInternet /* 131345 */:
            case FinalCanbus.CAR_RZC_XP1_RongWei_RX5 /* 262417 */:
            case FinalCanbus.CAR_RZC_17_18RongWei_I6 /* 1179921 */:
                cls = ActivityRZCRongWeiRX5.class;
                break;
            case FinalCanbus.CAR_XP1_PsaAll_Berlingo /* 131353 */:
                cls = XpPsaAllOrinalCarActivity.class;
                break;
            case FinalCanbus.CAR_XP_CYT_ShuPing_YeMa_L /* 131372 */:
            case FinalCanbus.CAR_XP_CYT_ShuPing_YeMa_H /* 196908 */:
                cls = RJIndexAct.class;
                break;
            case FinalCanbus.CAR_WeiChi2_17ChangChengH6 /* 131392 */:
            case FinalCanbus.CAR_WeiChi2_18ChangChengH6 /* 196928 */:
            case FinalCanbus.CAR_WeiChi2_ChangChengM6 /* 262464 */:
            case FinalCanbus.CAR_WeiChi2_18ChangChengH6_H /* 524608 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_19Copue /* 590144 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_19F7 /* 655680 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_19Copue_H /* 721216 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_19F7_H /* 786752 */:
            case FinalCanbus.CAR_WeiChi2_17ChangChengH6_H /* 917824 */:
            case FinalCanbus.CAR_WeiChi2_ChangChengH2S /* 983360 */:
            case FinalCanbus.CAR_WeiChi2_ChangChengH4 /* 1048896 */:
            case FinalCanbus.CAR_WeiChi2_17ChangChengH6_M /* 1179968 */:
            case FinalCanbus.CAR_WeiChi2_Haval_15_16Coupe /* 1245504 */:
            case FinalCanbus.CAR_WeiChi2_Haval_15_16Coupe_H /* 1311040 */:
            case FinalCanbus.CAR_WeiChi2_Changcheng_Jingangpao /* 1376576 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_Jingangpao_H /* 1442112 */:
            case FinalCanbus.CAR_WeiChi2_Changcheng_pao /* 1507648 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_18Copue /* 1769792 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_18Copue_H /* 1835328 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_JOLION_21 /* 1900864 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_JOLION_21_H /* 1966400 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_F7X_19 /* 2031936 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_F7X_19_H /* 2097472 */:
                cls = WcHaval17and18H6Acti.class;
                break;
            case FinalCanbus.CAR_XP1_14SanLinPajero_H /* 131426 */:
                cls = SanlinXPIndexAct.class;
                break;
            case FinalCanbus.CAR_RZC_XP1_ZiYouXia /* 131445 */:
            case FinalCanbus.CAR_RZC_18MuMaRen /* 393589 */:
            case FinalCanbus.CAR_RZC_18MuMaRen_H /* 524661 */:
            case FinalCanbus.CAR_RZC_19Tiaozhanzhe /* 590197 */:
            case FinalCanbus.CAR_RZC_18Zhihuiguan /* 655733 */:
            case FinalCanbus.CAR_RZC_19Tiaozhanzhe_H /* 721269 */:
            case FinalCanbus.CAR_RZC_18Zhihuiguan_H /* 786805 */:
            case FinalCanbus.CAR_RZC_Dodge_JCUV /* 1114485 */:
            case FinalCanbus.CAR_RZC_Jeep_Patriot /* 1180021 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM /* 1311093 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_H /* 1376629 */:
            case FinalCanbus.CAR_RZC_10ZhiNanZhe /* 1442165 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_M /* 1835381 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_HY /* 1900917 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_HY_M /* 1966453 */:
            case FinalCanbus.CAR_RZC_Dodge_RAM_HY_H /* 2031989 */:
            case FinalCanbus.CAR_RZC_XP1_ZiYouXia_H /* 2163061 */:
            case FinalCanbus.CAR_RZC_Jeep_Patriot_H /* 2228597 */:
            case FinalCanbus.CAR_RZC_10ZhiNanZhe_H /* 2294133 */:
            case FinalCanbus.CAR_RZC_Dodge_JCUV_H /* 2359669 */:
                cls = Rzc_ZiYouguang_Settings.class;
                break;
            case FinalCanbus.CAR_XP1_ZiYouXia /* 131446 */:
            case FinalCanbus.CAR_XP1_RAM1500 /* 655734 */:
            case FinalCanbus.CAR_XP1_18ZiYouXia /* 721270 */:
            case FinalCanbus.CAR_BNR_XP1_ZiYouXia /* 1048950 */:
            case FinalCanbus.CAR_XP1_RAM1500_M /* 4063606 */:
            case FinalCanbus.CAR_XP1_RAM1500_H /* 4129142 */:
                cls = Xp_374_FunctionlActi.class;
                break;
            case FinalCanbus.CAR_WC2_RongWei_I5 /* 131488 */:
            case FinalCanbus.CAR_WC2_RongWei_RX3 /* 328096 */:
            case FinalCanbus.CAR_WC2_RongWei_I5_H /* 459168 */:
                cls = Wc_416_RongWei_IndexAct.class;
                break;
            case FinalCanbus.CAR_RZC_HaiMaS5YOUNG /* 131494 */:
            case FinalCanbus.CAR_RZC_19HaiMaS5 /* 197030 */:
            case FinalCanbus.CAR_RZC_HaiMaS5YOUNG_H /* 262566 */:
                cls = HaimaS5SetFunc.class;
                break;
            case FinalCanbus.CAR_XFY_VolvoXC60 /* 131497 */:
                cls = Xc60SettingsAct.class;
                break;
            case FinalCanbus.CAR_KeYuan_Escort /* 131511 */:
            case FinalCanbus.CAR_KeYuan_YingLang /* 197047 */:
            case FinalCanbus.CAR_KeYuan_YARiSL /* 262583 */:
                cls = Ky_439_Escort_CarSettingAct.class;
                break;
            case FinalCanbus.CAR_452_BaoGu_Renault_17Koleos /* 131524 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_18Koleos /* 197060 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_17Koleos_L /* 2752964 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_17Koleos_M /* 2818500 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_17Koleos_H /* 2884036 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_18Koleos_L /* 2949572 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_18Koleos_M /* 3015108 */:
            case FinalCanbus.CAR_452_BaoGu_Renault_18Koleos_H /* 3080644 */:
                cls = Baogu_Renault_IndexAct.class;
                break;
            case FinalCanbus.CAR_RZC_XP1_CX70 /* 196678 */:
            case FinalCanbus.CAR_BNR_CX70 /* 262214 */:
            case FinalCanbus.CAR_BNR_19COS /* 917574 */:
            case FinalCanbus.CAR_BNR_17CX70 /* 983110 */:
            case FinalCanbus.CAR_BNR_17CX70_M /* 1048646 */:
            case FinalCanbus.CAR_BNR_17CX70_H /* 1114182 */:
            case FinalCanbus.CAR_RZC_17CHANGAN_A800 /* 1769542 */:
                cls = BnrChanganCX70IndexAct.class;
                break;
            case FinalCanbus.CAR_RZC1_MZD6 /* 196687 */:
            case FinalCanbus.CAR_RZC1_MZD6_38400 /* 196899 */:
                cls = MzdRZCM6ClockSetActi.class;
                break;
            case FinalCanbus.CAR_WC_17Haval_H2S /* 196740 */:
            case FinalCanbus.CAR_RZC_HavalLow_H2S_HongBiao /* 393460 */:
            case FinalCanbus.CAR_RZC_HavalLow_H2S_LanBiao /* 721140 */:
                cls = ActivityHavaH2SIndex.class;
                break;
            case FinalCanbus.CAR_RZC_XP1_YuanJingX1 /* 196747 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS /* 589963 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GL /* 655499 */:
            case FinalCanbus.CAR_RZC_XP1_18YuanJingSUV /* 721035 */:
            case FinalCanbus.CAR_RZC_XP1_18YuanJingSUV_H /* 852107 */:
            case FinalCanbus.CAR_RZC_XP1_16YuanJingSUV /* 917643 */:
            case FinalCanbus.CAR_RZC_XP1_16YuanJingSUV_H /* 983179 */:
            case FinalCanbus.CAR_RZC_Jili_19Dihao /* 1310859 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS_18 /* 1573003 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GL_16 /* 1638539 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS_19 /* 1769611 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GL_19 /* 1966219 */:
            case FinalCanbus.CAR_RZC_XP1_20YuanJingSUV /* 2031755 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GL_20 /* 2097291 */:
            case FinalCanbus.CAR_RZC_XP1_Boyue_Pro_20 /* 2162827 */:
            case FinalCanbus.CAR_RZC_XP1_Bingyue_19 /* 2228363 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS_20 /* 2293899 */:
            case FinalCanbus.CAR_RZC_XP1_GSe_20 /* 2359435 */:
            case FinalCanbus.CAR_RZC_XP1_Jiaji_21 /* 2424971 */:
            case FinalCanbus.CAR_RZC_XP1_Binrui_20 /* 2490507 */:
            case FinalCanbus.CAR_RZC_XP1_Haoyue_20 /* 2556043 */:
            case FinalCanbus.CAR_RZC_XP1_Dihaoe_22 /* 2621579 */:
            case FinalCanbus.CAR_RZC_XP1_Xingrui_22 /* 2687115 */:
            case FinalCanbus.CAR_RZC_Xiongmao_Mini_23 /* 2818187 */:
            case FinalCanbus.CAR_RZC_Jili_TX5 /* 2883723 */:
            case FinalCanbus.CAR_RZC_XP1_BingyuePro_19 /* 2949259 */:
            case FinalCanbus.CAR_RZC_XP1_Bingyue_21_RS /* 3276939 */:
            case FinalCanbus.CAR_RZC_XP1_Dihao_23 /* 3342475 */:
                cls = YuanJingX1CarSettingsAct.class;
                break;
            case FinalCanbus.CAR_WC2_07_AoDeSai /* 196774 */:
                cls = Act_LEDScreen_AoDeSai_wc.class;
                break;
            case FinalCanbus.CAR_ANSHENG_OLD_MZD6 /* 196775 */:
            case FinalCanbus.CAR_ANSHENG_AnKeSeLa /* 262311 */:
                cls = AnSheng_167_Mzd6_CarCdAct.class;
                break;
            case FinalCanbus.CAR_OuDi_08AoDeSai /* 196811 */:
                cls = ActivityCarCD_Oudi_Aodesai.class;
                break;
            case FinalCanbus.CAR_RZC_BeiQi_EC180 /* 196835 */:
                cls = ActivityEC180Index.class;
                break;
            case FinalCanbus.CAR_BNR_HuaTai_ShengDaFei /* 196845 */:
                cls = Acti_BNR_ShengDaFei.class;
                break;
            case FinalCanbus.CAR_RZC_HanTeng_H /* 196863 */:
            case FinalCanbus.CAR_RZC_HanTeng_X5 /* 524543 */:
                cls = RZC_0255_HanTengX5_IndexAct.class;
                break;
            case FinalCanbus.CAR_RZC_16BoYue /* 196873 */:
            case FinalCanbus.CAR_BNR_BoYue /* 459017 */:
            case FinalCanbus.CAR_BNR_BoYue_H /* 786697 */:
                cls = BoyueIndexAct.class;
                break;
            case FinalCanbus.CAR_LZ_XP1_PsaAll_CD /* 196889 */:
            case FinalCanbus.CAR_RZC4_PSA_04_407_CD /* 1704275 */:
                cls = LZPsaAllIndexAct.class;
                break;
            case FinalCanbus.CAR_RZC_18BaoJun530 /* 196918 */:
            case FinalCanbus.CAR_RZC_19BaoJun730 /* 393526 */:
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
                cls = RzcBaojunSetFunc.class;
                break;
            case FinalCanbus.CAR_WC1_NISSAN_XiMa_L /* 196930 */:
            case FinalCanbus.CAR_WC1_NISSAN_XiMa_H /* 262466 */:
                cls = Wc_322_DspinfoActi.class;
                break;
            case FinalCanbus.CAR_DJ_DongNanDX7_LOW /* 196937 */:
                cls = XfyDx7HistroyAct.class;
                break;
            case FinalCanbus.CAR_BoGoo_XP1_GrdCherokee /* 196979 */:
            case FinalCanbus.CAR_BoGoo_XP1_ShuPing_GrdCherokee_CYT_AIRPANEL /* 262515 */:
                cls = Bg_DaQieNuoJi_IndexAct.class;
                break;
            case FinalCanbus.CAR_WC1_Jeep_ZiYouXia /* 196980 */:
                cls = Wc_372_FunctionalActi.class;
                break;
            case FinalCanbus.CAR_XP1_17ZhiNanZhe /* 196982 */:
            case FinalCanbus.CAR_XP1_17ZhiNanZhe_H /* 262518 */:
            case FinalCanbus.CAR_XP1_Cherokee /* 786806 */:
            case FinalCanbus.CAR_XP1_Cherokee_H /* 852342 */:
            case FinalCanbus.CAR_BNR_XP1_ZiYouGuang /* 917878 */:
            case FinalCanbus.CAR_BNR_XP1_ZiYouGuang_H /* 983414 */:
            case FinalCanbus.CAR_BNR_XP1_17ZhiNanZhe /* 1114486 */:
            case FinalCanbus.CAR_BNR_XP1_17ZhiNanZhe_H /* 1180022 */:
            case FinalCanbus.CAR_XP1_RAM1500_H_AUTO /* 4194678 */:
                cls = Xp_374_IndexActi.class;
                break;
            case FinalCanbus.CAR_RZC_XP1_RENAULT_KaBin /* 197010 */:
            case FinalCanbus.CAR_RZC_Kangoo_Turkey_12 /* 2294162 */:
            case FinalCanbus.CAR_RZC_FLUENCE_Turkey_14 /* 2359698 */:
            case FinalCanbus.CAR_RZC_Symbol_Turkey_15 /* 2425234 */:
            case FinalCanbus.CAR_RZC_SANDERO_Turkey /* 2490770 */:
            case FinalCanbus.CAR_RZC_LODGY_Turkey /* 2556306 */:
            case FinalCanbus.CAR_RZC_DUSTER_Turkey /* 2621842 */:
            case FinalCanbus.CAR_RZC_MEGANE2 /* 2687378 */:
            case FinalCanbus.CAR_RZC_MEGANE3 /* 2752914 */:
            case FinalCanbus.CAR_RZC_Latltude_11 /* 2818450 */:
            case FinalCanbus.CAR_RZC_Logan_17 /* 2883986 */:
            case FinalCanbus.CAR_RZC_Dokker_17 /* 2949522 */:
            case FinalCanbus.CAR_RZC_Lodgy_19 /* 3015058 */:
            case FinalCanbus.CAR_RZC_Symbol_15 /* 3080594 */:
            case FinalCanbus.CAR_RZC_Kangoo_12 /* 3146130 */:
            case FinalCanbus.CAR_RZC_Kiwd_17 /* 3211666 */:
            case FinalCanbus.CAR_RZC_Renault_CLIO3_05 /* 6619538 */:
            case FinalCanbus.CAR_RZC_Renault_L9_05 /* 6685074 */:
                cls = KeLeiJiaRadarSetting.class;
                break;
            case FinalCanbus.CAR_DJ_SHA_BUS_JiuLong /* 197016 */:
                cls = ActivityBusCarCheck.class;
                break;
            case FinalCanbus.CAR_WC2_ToYoTa_10_Crown_ALL /* 197028 */:
            case FinalCanbus.CAR_WC2_ToYoTa_Lexus_NX_SCREEN /* 852388 */:
            case FinalCanbus.CAR_LuZhen_Honda_Spirior /* 197033 */:
                cls = Lz_425_Spirior_IndexActi.class;
                break;
            case FinalCanbus.CAR_443_WC_12ELYSION /* 197051 */:
                cls = HondaIndexActi.class;
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
            case FinalCanbus.CAR_453_OD_Chuangwei_EV /* 197061 */:
            case FinalCanbus.CAR_453_RZC_Chuangwei_EV /* 8651205 */:
                cls = ODCHuangWeiET5CarSet.class;
                break;
            case FinalCanbus.CAR_XP1_DaZhong_L /* 262146 */:
            case FinalCanbus.CAR_LZ_XP1_DaZhong_TuRui_03 /* 327682 */:
                cls = DasAutoXpAct.class;
                break;
            case FinalCanbus.CAR_WC2_CHANGAN_19KeSai /* 262272 */:
            case FinalCanbus.CAR_WC2_CHANGAN_19KeSai_Hand /* 327808 */:
            case FinalCanbus.CAR_WC2_18Oushang_X70A /* 393344 */:
            case FinalCanbus.CAR_WC2_19Oushang_A800 /* 458880 */:
            case FinalCanbus.CAR_WC2_18Changan_CS55 /* 524416 */:
            case FinalCanbus.CAR_WC2_20Oushang_X7_H /* 655488 */:
            case FinalCanbus.CAR_WC2_19ChangAn_CS35_PLUS /* 721024 */:
                cls = WCChanganAllIndexAct.class;
                break;
            case FinalCanbus.CAR_DJ_ShuPing_BYD_G6_H /* 262295 */:
                cls = DjBYDG6.class;
                break;
            case FinalCanbus.CAR_KeYuan_FYTA_S3 /* 262402 */:
                cls = ActivityHaimaS3.class;
                break;
            case FinalCanbus.CAR_RZC_OD_Ruifeng_R3 /* 262416 */:
            case FinalCanbus.CAR_RZC_OD_Sibalu_XV /* 327952 */:
                cls = JhRuiFengR3IndexAct.class;
                break;
            case FinalCanbus.CAR_RZC_XP1_ChuanQiGS8 /* 262424 */:
            case FinalCanbus.CAR_RZC_XP1_ChuanQiGS3 /* 459032 */:
            case FinalCanbus.CAR_RZC_XP1_ChuanQiGS8_H /* 524568 */:
                cls = Rzc_Gs8_IndexAct.class;
                break;
            case FinalCanbus.CAR_XP1_15WeiLang /* 262462 */:
            case FinalCanbus.CAR_XP1_15WeiLang_H /* 327998 */:
                cls = YLCarSettingsAct.class;
                break;
            case FinalCanbus.CAR_XFY_ZhongHuaV3_H /* 262470 */:
                cls = XfyZhV3CarSet.class;
                break;
            case FinalCanbus.CAR_RZC_XP1_DongNanDX5_19 /* 262473 */:
                cls = RzcDx7Settings.class;
                break;
            case FinalCanbus.CAR_WC2_RENAULT_18DUSTER /* 262496 */:
                cls = DusterOilMileIndexActi.class;
                break;
            case FinalCanbus.CAR_WC1_Jeep_17ZhiNanZhe /* 262516 */:
            case FinalCanbus.CAR_WC1_Jeep_17ZhiNanZhe_H /* 328052 */:
                if (LauncherApplication.getConfiguration() == 1) {
                    cls = Wc_372_FunctionalActi.class;
                    break;
                } else {
                    cls = Wc_372_IndexAct.class;
                    break;
                }
            case FinalCanbus.CAR_RZC_16_QiYaKaiShen /* 262537 */:
                cls = ActivityQiYaKaiShenSet.class;
                break;
            case FinalCanbus.CAR_SBD_DongFeng_FullView /* 262542 */:
                cls = Dongfeng_FullView_SBDAct.class;
                break;
            case FinalCanbus.CAR_412_LZ_GM_GMC /* 262556 */:
            case FinalCanbus.CAR_412_LZ_Cadillac_SLS /* 328092 */:
            case FinalCanbus.CAR_412_LZ_Cadillac_Escalade /* 393628 */:
                cls = LZCadillacCarSet.class;
                break;
            case FinalCanbus.CAR_WC2_RongWei_EI6 /* 262560 */:
                cls = Act20ZSIndexAct.class;
                break;
            case FinalCanbus.CAR_CYT_YaGe7_38400 /* 262561 */:
            case FinalCanbus.CAR_RCW_BYD_10_11F6 /* 328097 */:
            case FinalCanbus.CAR_RCW_BYD_10_13G6 /* 393633 */:
            case FinalCanbus.CAR_RCW_YaGe7_38400 /* 459169 */:
            case FinalCanbus.CAR_WC_YaGe7_38400 /* 524705 */:
            case FinalCanbus.CAR_454_LZ_Honda_AoDeSai_04 /* 16449990 */:
            case FinalCanbus.CAR_WC2_HuanSuS6 /* 262563 */:
            case FinalCanbus.CAR_WC2_HuanSuS6_H /* 328099 */:
            case FinalCanbus.CAR_OD_WC2_HuanSuS6 /* 1180067 */:
            case FinalCanbus.CAR_OD_WC2_HuanSuS6_H /* 1245603 */:
                cls = ActivityHuanSuS6Index.class;
                break;
            case FinalCanbus.CAR_447_RZC_19IX45 /* 262591 */:
            case FinalCanbus.CAR_447_RZC_19IX45_H /* 328127 */:
            case FinalCanbus.CAR_447_RZC_19IX45_Top /* 393663 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_19Tusheng /* 459199 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_19Tusheng_H /* 524735 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_19KX5 /* 590271 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_19KX5_H /* 655807 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_19K3 /* 721343 */:
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
            case FinalCanbus.CAR_RZC3_XianDai_OPTIMA_17 /* 2294207 */:
            case FinalCanbus.CAR_RZC3_XianDai_OPTIMA_17_H /* 2359743 */:
            case FinalCanbus.CAR_RZC3_XianDai_SANTAFE_17 /* 2425279 */:
            case FinalCanbus.CAR_RZC3_XianDai_SANTAFE_17_H /* 2490815 */:
            case FinalCanbus.CAR_RZC3_XianDai_HB20S_23 /* 2556351 */:
            case FinalCanbus.CAR_RZC3_XianDai_HB20S_23_M /* 2621887 */:
            case FinalCanbus.CAR_RZC3_XianDai_HB20S_23_H /* 2687423 */:
            case FinalCanbus.CAR_RZC3_XianDai_19Palisade /* 2752959 */:
            case FinalCanbus.CAR_RZC3_XianDai_19Palisade_H /* 2818495 */:
            case FinalCanbus.CAR_RZC3_XianDai_20CARNIVAL /* 2884031 */:
            case FinalCanbus.CAR_RZC3_XianDai_20CARNIVAL_H /* 2949567 */:
            case FinalCanbus.CAR_RZC3_XianDai_17KX7_H /* 3015103 */:
            case FinalCanbus.CAR_RZC3_XianDai_15Sorento /* 3080639 */:
            case FinalCanbus.CAR_RZC3_XianDai_15Sorento_H /* 3146175 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_19KX5_M /* 3211711 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_KX3_M /* 3277247 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_23Staria /* 3539391 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_23Staria_H /* 3604927 */:
                cls = OD_19Tusheng_CarSettingAct.class;
                break;
            case FinalCanbus.CAR_452_RZC_ChangAn_CS15_19 /* 262596 */:
            case FinalCanbus.CAR_452_RZC_ChangAn_Yidong_19 /* 393668 */:
            case FinalCanbus.CAR_452_RZC_ChangAn_CS35_19PLUS /* 1376708 */:
            case FinalCanbus.CAR_453_RZC_Changan_Lumin_22 /* 3408325 */:
            case FinalCanbus.CAR_453_RZC_Changan_RAETON_CC_21 /* 3539397 */:
            case FinalCanbus.CAR_452_RZC_ChangAn_18CS55_H /* 3932612 */:
            case FinalCanbus.CAR_439_RZC_ChangAn_18CS55 /* 7406007 */:
            case FinalCanbus.CAR_439_RZC_ChangAn_18CS75 /* 8257975 */:
            case FinalCanbus.CAR_454_RZC_Changan_Hunter_22_H /* 10092998 */:
            case FinalCanbus.CAR_452_RZC_ChangAn_Oushang_Changxing /* 11469252 */:
                cls = RzcChanganCX70SetFunc.class;
                break;
            case FinalCanbus.CAR_453_LZ_BMW_E39 /* 262597 */:
            case FinalCanbus.CAR_453_LZ_BMW_E53 /* 328133 */:
            case FinalCanbus.CAR_453_LZ_BMW_E39_H /* 393669 */:
            case FinalCanbus.CAR_453_LZ_BMW_E53_H /* 459205 */:
            case FinalCanbus.CAR_452_LZ_BMW_E46_H /* 13828548 */:
            case FinalCanbus.CAR_439_LZ_BMW_E46 /* 16187831 */:
                cls = ODBMWMiniIndexAct.class;
                break;
            case FinalCanbus.CAR_OD_GaoErFu7 /* 327720 */:
            case FinalCanbus.CAR_WC2_17MaiTeng_DZSJ /* 393233 */:
            case FinalCanbus.CAR_OD_TuAnL /* 393256 */:
            case FinalCanbus.CAR_WC2_17MaiTeng_SOS_DZSJ /* 458769 */:
                cls = Golf7OilMileageIndexActiOD.class;
                break;
            case FinalCanbus.CAR_OuDi_XP1_T60 /* 327819 */:
                cls = BoyueCarSettingsAct.class;
                break;
            case FinalCanbus.CAR_WC2_18BaoJun530 /* 327926 */:
                cls = ActivityBaojun530Info.class;
                break;
            case FinalCanbus.CAR_BNR_XP1_FengShenAX7_HI /* 327935 */:
                cls = Bnr_255_FengShengax7_Allvideo.class;
                break;
            case FinalCanbus.CAR_LUZ_ZhongTaiT600 /* 327945 */:
                cls = IndexAct_Luz.class;
                break;
            case FinalCanbus.CAR_RZC_XP1_QiChenT90 /* 327970 */:
            case FinalCanbus.CAR_RZC_XP1_QiChenD60 /* 393506 */:
            case FinalCanbus.CAR_RZC_XP1_QiChen18T70 /* 459042 */:
            case FinalCanbus.CAR_CZH_RZC_QiChenD60 /* 852258 */:
            case FinalCanbus.CAR_CZH_RZC_QiChen18T70 /* 917794 */:
            case FinalCanbus.CAR_BNR_XP1_AoDeSai /* 327978 */:
                cls = Act_CarCD_AoDeSai.class;
                break;
            case FinalCanbus.CAR_WeiChi2_ChangChengH9 /* 328000 */:
            case FinalCanbus.CAR_WeiChi2_ChangChengH9_M /* 393536 */:
            case FinalCanbus.CAR_WeiChi2_ChangChengH9_H /* 459072 */:
            case FinalCanbus.CAR_WeiChi2_ChangChengH8 /* 1573184 */:
            case FinalCanbus.CAR_WeiChi2_ChangChengH8_M /* 1638720 */:
            case FinalCanbus.CAR_WeiChi2_ChangChengH8_H /* 1704256 */:
                cls = WC_0320_HavalH9_IndexAct.class;
                break;
            case FinalCanbus.CAR_RZC_Focus2019 /* 328014 */:
            case FinalCanbus.CAR_RZC_Jinniu2018 /* 393550 */:
            case FinalCanbus.CAR_RZC_TOURNEO_COURIER /* 524622 */:
            case FinalCanbus.CAR_RZC_13_20Mengdiou /* 852302 */:
            case FinalCanbus.CAR_RZC_Ford_F150_12 /* 2294094 */:
            case FinalCanbus.CAR_RZC_Mustang_NO_CD /* 2359630 */:
            case FinalCanbus.CAR_RZC_Mustang_15_NO_CD /* 2621774 */:
            case FinalCanbus.CAR_RZC_Mustang_HY_LEFT /* 2687310 */:
            case FinalCanbus.CAR_RZC_Mustang_HY_RIGHT /* 2752846 */:
            case FinalCanbus.CAR_RZC_Mustang_HY_LOW /* 2818382 */:
            case FinalCanbus.CAR_RZC_Mustang_HY_H /* 2883918 */:
            case FinalCanbus.CAR_RZC_Ford_F150 /* 3080526 */:
            case FinalCanbus.CAR_RZC_Ford_F150_DZ /* 3604814 */:
            case FinalCanbus.CAR_CZH_RZC_13_20Mengdiou /* 3998030 */:
            case FinalCanbus.CAR_RZC_Focus2019_M /* 4587854 */:
            case FinalCanbus.CAR_RZC_Focus2019_H /* 4653390 */:
            case FinalCanbus.CAR_RZC_Jinniu2019_M /* 4718926 */:
            case FinalCanbus.CAR_RZC_Jinniu2019_H /* 4784462 */:
            case FinalCanbus.CAR_RZC_Mustang_NOCD_M /* 5505358 */:
            case FinalCanbus.CAR_RZC_Mustang_NOCD_H /* 5570894 */:
                cls = FordCarSet_RZC.class;
                break;
            case FinalCanbus.CAR_XP1_KeLeiAo_L /* 328054 */:
            case FinalCanbus.CAR_XP1_KeLeiAo_H /* 393590 */:
                cls = Act_Keleijia_Index.class;
                break;
            case FinalCanbus.CAR_SBD_Ford_LieYing /* 328078 */:
            case FinalCanbus.CAR_438_DJ_YuanJingX1 /* 328118 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria /* 328124 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria_H /* 393660 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_IX35 /* 1966523 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_15Carnival /* 1966524 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_IX35_H /* 2032059 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_15Carnival_H /* 2032060 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_IX45 /* 2097595 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_23NewZealand /* 2097596 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_IX45_H /* 2163131 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_23NewZealand_H /* 2163132 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_Sonata8 /* 2228667 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_15Sonata9_M /* 2228668 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_Sonata8_H /* 2294203 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_15Sonata9_H /* 2294204 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_Sonata9 /* 2359739 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_18Sonata9_H /* 2359740 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_Sonata9_H /* 2425275 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_11Veloster /* 2425276 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_Mingtu /* 2490811 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_Mingtu_H /* 2556347 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_TuSheng /* 2621883 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_Lingdong /* 2687419 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_16K5 /* 2752955 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_16KX5 /* 2818491 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_Suolantuo /* 2884027 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_17Sonata9 /* 2949563 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra /* 2949564 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_15IX45_H /* 3015099 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra_H /* 3015100 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_17KX7 /* 3080635 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_17KX7_H /* 3146171 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_18Sonata9_M /* 3211707 */:
            case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra_EV /* 3211708 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_18Sonata9_L /* 3277243 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_18Encino /* 3342779 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_18Sportage /* 3408315 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_19Shengda /* 3473851 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_19Shengda_H /* 3867067 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_Santafe /* 10092987 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_22NIRO /* 10158523 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_18OPTIMA /* 15073723 */:
                cls = ActivityWCXianDaiAllSet.class;
                break;
            case FinalCanbus.CAR_452_RZC_ChangAn_Oushangx7_20 /* 328132 */:
            case FinalCanbus.CAR_453_RZC_Changan_CS15_EPro_21 /* 3473861 */:
            case FinalCanbus.CAR_439_RZC_ChangAn_CX70 /* 4391351 */:
            case FinalCanbus.CAR_452_RZC_ChangAn_19OuShang /* 4719044 */:
            case FinalCanbus.CAR_439_RZC_ChangAn_OUSAN_KESAI /* 7471543 */:
            case FinalCanbus.CAR_452_RZC_ChangAn_KESAI_Pro_21 /* 11010500 */:
            case FinalCanbus.CAR_439_RZC_Changan_19Yuexiang /* 11469239 */:
                cls = RzcChanganCX70IndexAct.class;
                break;
            case FinalCanbus.CAR_WC2_18Ecosport /* 393237 */:
            case FinalCanbus.CAR_WC2_MengDiOuZS2018 /* 458773 */:
                cls = Wc_21_EcosportSetAct.class;
                break;
            case FinalCanbus.CAR_WC2_20BaoJun530_Auto /* 393462 */:
            case FinalCanbus.CAR_WC2_20BaoJun530_Hand /* 458998 */:
                cls = ActivityWC20Baojun530Info.class;
                break;
            case FinalCanbus.CAR_Oudi_HanTeng_X5 /* 393471 */:
            case FinalCanbus.CAR_Oudi_XiaoYao /* 459007 */:
            case FinalCanbus.CAR_452_OD_Hongqi_H7 /* 12124612 */:
            case FinalCanbus.CAR_454_CZH_OD_Hongqi_EQM5 /* 16515526 */:
                cls = Oudi_0255_HanTengX5_IndexAct.class;
                break;
            case FinalCanbus.CAR_BNR_ZhongTaiT600 /* 393481 */:
                cls = IndexAct_Bnr.class;
                break;
            case FinalCanbus.CAR_WC_17KX7_ARM /* 393610 */:
                cls = ActivityKX7CameraSet.class;
                break;
            case FinalCanbus.CAR_OD_Jiangxi_Wushiling_Mux /* 393638 */:
            case FinalCanbus.CAR_OD_Jiangxi_Lingtuo /* 459174 */:
                cls = ODJianglingSetFunc.class;
                break;
            case FinalCanbus.CAR_439_DJ_XP1_HuiTeng /* 393655 */:
            case FinalCanbus.CAR_439_DJ_XP1_HuiTeng_H /* 459191 */:
                cls = HuitengIndexAct.class;
                break;
            case FinalCanbus.CAR_443_WC2_MAZD_ALL_M6 /* 393659 */:
            case FinalCanbus.CAR_443_WC2_MAZD_ALL_M3 /* 459195 */:
            case FinalCanbus.CAR_443_WC2_MAZD_ALL_M5 /* 524731 */:
            case FinalCanbus.CAR_443_WC2_MAZD_ALL_M8 /* 590267 */:
            case FinalCanbus.CAR_443_WC2_MAZD_ALL_CX7_H /* 655803 */:
            case FinalCanbus.CAR_443_WC2_MAZD_ALL_M7 /* 852411 */:
            case FinalCanbus.CAR_443_WC2_MAZD_ALL_CX7_L /* 1049019 */:
            case FinalCanbus.CAR_443_WC2_MAZD_ALL_M6_Ruiyi /* 15663547 */:
                cls = ActivityMzdAllHUDCarSet.class;
                break;
            case FinalCanbus.CAR_455_LZ_Fiat_500_07 /* 393671 */:
            case FinalCanbus.CAR_455_LZ_Fiat_Bravo_08 /* 459207 */:
            case FinalCanbus.CAR_455_LZ_Alfa_MITO_08 /* 524743 */:
                cls = LZFiatInfCarSet.class;
                break;
            case FinalCanbus.CAR_RZC_XP1_08_12TianLai /* 458942 */:
                cls = XBS09TianlaiIndexAct.class;
                break;
            case FinalCanbus.CAR_RZC_BeiQi_19EC5 /* 458979 */:
            case FinalCanbus.CAR_RZC_BeiQi_18EU5 /* 786659 */:
            case FinalCanbus.CAR_RZC_BeiQi_20EU5 /* 1376483 */:
                cls = Activity19EC5Index.class;
                break;
            case FinalCanbus.CAR_WC2_RENAULT_Megane4 /* 459104 */:
            case FinalCanbus.CAR_WC2_RENAULT_Megane4_M /* 983392 */:
            case FinalCanbus.CAR_WC2_RENAULT_CAPTUR_19 /* 1048928 */:
            case FinalCanbus.CAR_WC2_RENAULT_CLio5 /* 1114464 */:
            case FinalCanbus.CAR_WC2_RENAULT_CLio5_M /* 1311072 */:
            case FinalCanbus.CAR_WC2_RENAULT_CLio5_H /* 1376608 */:
            case FinalCanbus.CAR_WC2_RENAULT_Megane4_H /* 1442144 */:
            case FinalCanbus.CAR_WC2_RENAULT_21Sandero_L /* 1507680 */:
            case FinalCanbus.CAR_WC2_RENAULT_21Sandero_M /* 1573216 */:
            case FinalCanbus.CAR_WC2_RENAULT_21Sandero_H /* 1638752 */:
            case FinalCanbus.CAR_WC2_RENAULT_23Megane4 /* 1704288 */:
            case FinalCanbus.CAR_WC2_RENAULT_23Megane4_M /* 1769824 */:
            case FinalCanbus.CAR_WC2_RENAULT_23Megane4_H /* 1835360 */:
            case FinalCanbus.CAR_WC2_RENAULT_Talisman /* 1900896 */:
            case FinalCanbus.CAR_WC2_RENAULT_Talisman_M /* 1966432 */:
            case FinalCanbus.CAR_WC2_RENAULT_Talisman_H /* 2031968 */:
            case FinalCanbus.CAR_WC2_RENAULT_23Jogger_L /* 2097504 */:
            case FinalCanbus.CAR_WC2_RENAULT_23Jogger_M /* 2163040 */:
            case FinalCanbus.CAR_WC2_RENAULT_23Jogger_H /* 2228576 */:
            case FinalCanbus.CAR_WC2_RENAULT_23Duster_L /* 2359648 */:
            case FinalCanbus.CAR_WC2_RENAULT_23Duster_M /* 2425184 */:
            case FinalCanbus.CAR_WC2_RENAULT_23Duster_H /* 2490720 */:
            case FinalCanbus.CAR_WC2_RENAULT_17KOLEOS_L /* 2621792 */:
            case FinalCanbus.CAR_WC2_RENAULT_17KOLEOS_M /* 2687328 */:
            case FinalCanbus.CAR_WC2_RENAULT_17KOLEOS_H /* 2752864 */:
            case FinalCanbus.CAR_WC2_LADA_VESTA /* 2818400 */:
                cls = WCRenaultIndexActi.class;
                break;
            case FinalCanbus.CAR_XP1_FAITAEGEA /* 459126 */:
            case FinalCanbus.CAR_XP1_FAITDOBLO /* 524662 */:
            case FinalCanbus.CAR_ZH2_XP1_FAITAEGEA /* 2228598 */:
                cls = Xp_374_AegeaIndexActi.class;
                break;
            case FinalCanbus.CAR_WC2_GUOCHAN_7 /* 459147 */:
            case FinalCanbus.CAR_XP1_YearGmcSeries_NoAir /* 459164 */:
                cls = GMCPannelSetActi.class;
                break;
            case FinalCanbus.CAR_452_Oudi_DongnanV5_13_16 /* 459204 */:
            case FinalCanbus.CAR_452_Oudi_DongnanV6_13_16 /* 524740 */:
            case FinalCanbus.CAR_452_Oudi_DongnanA5_20 /* 590276 */:
                cls = ODDongnanSetFunc.class;
                break;
            case FinalCanbus.CAR_WC2_MengDiOuZS2021 /* 524309 */:
                cls = BnrTuleIndexAct.class;
                break;
            case FinalCanbus.CAR_RZC_XP1_YuanJingX3 /* 524427 */:
            case FinalCanbus.CAR_RZC_XP1_15YuanJing /* 1048715 */:
                cls = YuanjingX3TireAct.class;
                break;
            case FinalCanbus.CAR_BNR_SR7 /* 524553 */:
                cls = ActivitySR7Setting_Bnr.class;
                break;
            case FinalCanbus.CAR_RZC_OD_Sibalu_Legacy_20 /* 524560 */:
                cls = ODSubaruLegacyCarInfo.class;
                break;
            case FinalCanbus.CAR_RZC_DongFengYiZhi_19EV3 /* 524602 */:
            case FinalCanbus.CAR_RZC_DongFengYiZhi_18E400 /* 721210 */:
            case FinalCanbus.CAR_RZC_FengGuang19E3 /* 1769786 */:
            case FinalCanbus.CAR_RZC_FengGuang_580Pro_20 /* 1835322 */:
            case FinalCanbus.CAR_RZC_FengGuang_580Pro_20_H /* 1900858 */:
                cls = RZC_0314_Dongfeng_Ev3_IndexAct.class;
                break;
            case FinalCanbus.CAR_WC2_JingyiX5 /* 524707 */:
            case FinalCanbus.CAR_WC2_17JingyiS50 /* 1114531 */:
                cls = JYIndexAct.class;
                break;
            case FinalCanbus.CAR_DJ_XP1_TOYOTA_14Prodo_ShuPing /* 524717 */:
            case FinalCanbus.CAR_439_DJ_14B70 /* 524727 */:
                cls = DaojunB70LowCarSettingAct.class;
                break;
            case FinalCanbus.CAR_444_WC2_TD_LandRover_Bose /* 524732 */:
            case FinalCanbus.CAR_444_WC2_TD_LandRover_Haman /* 590268 */:
            case FinalCanbus.CAR_444_WC2_TD_BBA_SCREEN /* 655804 */:
            case FinalCanbus.CAR_444_WY_Audi_Q4 /* 2818492 */:
            case FinalCanbus.CAR_443_WY_Audi_Q3 /* 7668155 */:
            case FinalCanbus.CAR_443_WY_MZD_All /* 7733691 */:
                cls = WYBBACarInfo.class;
                break;
            case FinalCanbus.CAR_453_OD_GuanZhi /* 524741 */:
            case FinalCanbus.CAR_439_BNR_GuanZhi /* 1638839 */:
            case FinalCanbus.CAR_452_DJ_Guanzhi /* 11272644 */:
                cls = BnrGuanzhiIndexAct.class;
                break;
            case FinalCanbus.CAR_RZC1_MZD3_05 /* 589903 */:
                cls = RZCMzd3CarInfo.class;
                break;
            case FinalCanbus.CAR_RZC_XP1_ShangQiDaTongT60 /* 590089 */:
            case FinalCanbus.CAR_RZC_XP1_ShangQiDaTongV80 /* 721161 */:
            case FinalCanbus.CAR_RZC_XP1_ShangQiDaTong19EV30 /* 852233 */:
            case FinalCanbus.CAR_RZC_XP1_ShangQiDaTong19T70 /* 983305 */:
                cls = Activity_RZC_SettingT60.class;
                break;
            case FinalCanbus.CAR_RZC_ChuanQiGS4_18 /* 590104 */:
            case FinalCanbus.CAR_RZC_ChuanQiGE3_18 /* 786712 */:
            case FinalCanbus.CAR_RZC_Qizhi_EV /* 1179928 */:
            case FinalCanbus.CAR_RZC_XP1_ChuanQiGS4_20_EV /* 1966360 */:
            case FinalCanbus.CAR_RZC_OD_AION_EV /* 2228504 */:
                cls = RzcGS4IndexAct.class;
                break;
            case FinalCanbus.CAR_439_DJ_14B70_H /* 590263 */:
                cls = DaojunB70CarSettingAct.class;
                break;
            case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15_YC /* 590279 */:
            case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15H_YC /* 655815 */:
                cls = KYCToyotaAllCarSet.class;
                break;
            case FinalCanbus.CAR_OD_NISSAN_Qijun_L /* 655440 */:
            case FinalCanbus.CAR_OD_NISSAN_Qijun_H /* 720976 */:
            case FinalCanbus.CAR_OD_NISSAN_Tianlai_L /* 786512 */:
            case FinalCanbus.CAR_OD_NISSAN_Tianlai_H /* 852048 */:
            case FinalCanbus.CAR_OD_NISSAN_Xuanyi_L /* 917584 */:
            case FinalCanbus.CAR_OD_NISSAN_Xuanyi_H /* 983120 */:
                cls = OD_NissanXimaCarinfoAct.class;
                break;
            case FinalCanbus.CAR_RZC_XP1_HavalH6_18 /* 655604 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6_16HuanDai /* 852212 */:
            case FinalCanbus.CAR_RZC_HavalLow_H2_LanBiao_H /* 1048820 */:
            case FinalCanbus.CAR_RZC_HavalH6_Sport_19 /* 1179892 */:
            case FinalCanbus.CAR_RZC_HavalH4_20 /* 1245428 */:
            case FinalCanbus.CAR_RZC_HavalF7_20 /* 1376500 */:
            case FinalCanbus.CAR_RZC_HavalH4_20_H /* 1442036 */:
            case FinalCanbus.CAR_RZC_HavalF7_19 /* 1507572 */:
            case FinalCanbus.CAR_RZC_Haval_Fengjun5_21 /* 1900788 */:
            case FinalCanbus.CAR_RZC_Haval_Jinggangpao_22 /* 2031860 */:
            case FinalCanbus.CAR_RZC_HavalF7_19_Top /* 2228468 */:
                cls = ActivityHava18H6Index.class;
                break;
            case FinalCanbus.CAR_RZC_FengShenAX7_18H /* 655615 */:
                cls = RZC_0255_FengShenAx7_IndexAct.class;
                break;
            case FinalCanbus.CAR_WC2_GUOCHAN_10 /* 655755 */:
            case FinalCanbus.CAR_WC2_GUOCHAN_14 /* 917899 */:
            case FinalCanbus.CAR_WC2_GUOCHAN_15 /* 983435 */:
            case FinalCanbus.CAR_WC2_AiRuiZ7 /* 1638795 */:
            case FinalCanbus.CAR_WC2_AiRuiZ_GX /* 1835403 */:
            case FinalCanbus.CAR_WC2_GUOCHAN_Ruihu5X /* 2097547 */:
                cls = ActivityWCAiRuiZe.class;
                break;
            case FinalCanbus.CAR_RZC_XP1_BeiQiBJ40 /* 655756 */:
                cls = RZCBeiqiBj40CarSet.class;
                break;
            case FinalCanbus.CAR_452_Oudi_Jianghuai_Ruifeng_S7 /* 655812 */:
            case FinalCanbus.CAR_452_Oudi_Jianghuai_Ruifeng_S7_H /* 721348 */:
            case FinalCanbus.CAR_454_OD_Jianghuai_SEHOL_E50A /* 2490822 */:
            case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5 /* 2818501 */:
            case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5_H /* 2884037 */:
            case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5 /* 3015109 */:
            case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5_H /* 3080645 */:
            case FinalCanbus.CAR_452_Oudi_Jianghuai_IEV7 /* 9503172 */:
            case FinalCanbus.CAR_452_Oudi_Jianghuai_IEV7_H /* 9568708 */:
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
            case FinalCanbus.CAR_454_OD_Jianghuai_IC5 /* 15270342 */:
                cls = JhRuiFengR3IndexAct.class;
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
                cls = Acti_Nissan_Bnr.class;
                break;
            case FinalCanbus.CAR_439_OuDi_ZTT500 /* 721335 */:
            case FinalCanbus.CAR_439_OuDi_ZTT600 /* 786871 */:
            case FinalCanbus.CAR_439_OuDi_DMX7 /* 917943 */:
                cls = OdChanganIndexAct.class;
                break;
            case FinalCanbus.CAR_443_WC2_MAZD_ALL_AKSL /* 721339 */:
            case FinalCanbus.CAR_443_WC2_MAZD_ALL_CX5 /* 786875 */:
            case FinalCanbus.CAR_443_WC2_MAZD_ALL_CX4 /* 917947 */:
            case FinalCanbus.CAR_443_WC2_MAZD_ALL_ATZ /* 983483 */:
                cls = ActivityMzdAllIndexAct.class;
                break;
            case FinalCanbus.CAR_453_PA_Ford_F150_10_CD /* 721349 */:
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
            case FinalCanbus.CAR_453_PA_Ford_Mustang_10_CD /* 5702085 */:
                cls = PAFordAllIndexActi.class;
                break;
            case FinalCanbus.CAR_454_RZC_Perodua_Alza_22 /* 721350 */:
            case FinalCanbus.CAR_454_RZC_Perodua_Aruz_22 /* 786886 */:
            case FinalCanbus.CAR_454_RZC_Perodua_Ativa_22 /* 852422 */:
            case FinalCanbus.CAR_454_RZC_Perodua_Axia_22 /* 917958 */:
            case FinalCanbus.CAR_454_RZC_Perodua_Bezza_22 /* 983494 */:
            case FinalCanbus.CAR_454_RZC_Perodua_Myvi_22 /* 1049030 */:
                cls = RzcPeroduaIndexAct.class;
                break;
            case FinalCanbus.CAR_RZC_XP1_BeiQi_18HuansuS7 /* 786828 */:
            case FinalCanbus.CAR_RZC_XP1_BeiQi_18HuansuS7_H /* 852364 */:
                cls = RZCBeiqiSuansuS7CarSet.class;
                break;
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_Sonata9_E /* 786879 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_19K3_E /* 852415 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_19K5_E /* 917951 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_Sonata9M_E /* 983487 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_Sonata9H_E /* 1049023 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_ENCINO /* 3342783 */:
            case FinalCanbus.CAR_RZC3_XianDai_Qiya_ENCINO_H /* 3408319 */:
                cls = RZC_Xiandai_E_IndexAct.class;
                break;
            case FinalCanbus.CAR_452_RZC_LandRover_Discovery_15 /* 786884 */:
            case FinalCanbus.CAR_452_RZC_LandRover_RANGE_12 /* 2163140 */:
                cls = RzcLandRoverIndexAct.class;
                break;
            case FinalCanbus.CAR_455_OD_Zhongtai_E200 /* 786887 */:
                cls = ODZhongtaiE200CarInfo.class;
                break;
            case FinalCanbus.CAR_RZC_Nissan_Tianlai_Gongjue /* 852158 */:
                cls = RZCNissanAmpCarSet.class;
                break;
            case FinalCanbus.CAR_RZC_BeiQi_Shenbao_D50_18 /* 852195 */:
            case FinalCanbus.CAR_RZC_BeiQi_20EX3 /* 1245411 */:
                cls = Activity18EU5CarSet.class;
                break;
            case FinalCanbus.CAR_DAOJUN_OD_ATS /* 852316 */:
            case FinalCanbus.CAR_DAOJUN_OD_SRX_XTS /* 917852 */:
            case FinalCanbus.CAR_DAOJUN_SRX_10 /* 983388 */:
                cls = AtsIndexAct.class;
                break;
            case FinalCanbus.CAR_WC2_ZhongHua_17H3 /* 852387 */:
                cls = ActivityZhongHuaH3.class;
                break;
            case FinalCanbus.CAR_439_OuDi_DMX5 /* 852407 */:
                cls = OdChanganSetFunc.class;
                break;
            case FinalCanbus.CAR_452_RZC_ZHongtai_E200_18 /* 852420 */:
                cls = RzcZhongtaiE200CarInfo.class;
                break;
            case FinalCanbus.CAR_455_XP_Ford_F150_2012 /* 852423 */:
            case FinalCanbus.CAR_455_XP_Ford_F150_2012_Auto /* 917959 */:
                cls = XPFordF150CarSet.class;
                break;
            case FinalCanbus.CAR_RZC_Nissan_JUKE_H /* 917694 */:
                cls = RZCNissanJUKECarSet.class;
                break;
            case FinalCanbus.CAR_RZC_FengShen19_20AX7 /* 917759 */:
            case FinalCanbus.CAR_RZC_FengShen19_20AX7_H /* 983295 */:
            case FinalCanbus.CAR_RZC_FengShen15AX7 /* 1638655 */:
            case FinalCanbus.CAR_RZC_FengShen19AX7_Hand /* 1704191 */:
            case FinalCanbus.CAR_RZC_FengShen15AX7_View /* 1769727 */:
                cls = RzcFengshenAx7SetFunc.class;
                break;
            case FinalCanbus.CAR_RZC_XP1_ShangQiDaTong19G50 /* 917769 */:
            case FinalCanbus.CAR_RZC_XP1_ShangQiDaTong19V90 /* 1048841 */:
            case FinalCanbus.CAR_RZC_XP1_ShangQiDaTong21V90 /* 1179913 */:
            case FinalCanbus.CAR_RZC_XP1_ShangQiDaTong22V90 /* 1245449 */:
                cls = RzcChanganIndexAct.class;
                break;
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx /* 917956 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_Rx_H /* 983492 */:
            case FinalCanbus.CAR_453_LZ_Toyota_REIZ_09 /* 1114565 */:
            case FinalCanbus.CAR_453_LZ_Toyota_REIZ_09_H /* 1180101 */:
            case FinalCanbus.CAR_455_LZ_ToYoTa_12Crown_L /* 2687431 */:
            case FinalCanbus.CAR_455_LZ_ToYoTa_12Crown_M /* 2752967 */:
            case FinalCanbus.CAR_455_LZ_ToYoTa_12Crown_H /* 2818503 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_IS /* 3080631 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_IS_H /* 3146167 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_ES /* 3211703 */:
            case FinalCanbus.CAR_439_LUZ_LEXUS_ES_H /* 3277239 */:
            case FinalCanbus.CAR_454_LZ_Toyota_Prius_03_L /* 3539398 */:
            case FinalCanbus.CAR_454_LZ_Toyota_Prius_03_H /* 3604934 */:
            case FinalCanbus.CAR_454_LZ_Lexus_RX330_L /* 3801542 */:
            case FinalCanbus.CAR_454_LZ_Lexus_RX330_H /* 3867078 */:
            case FinalCanbus.CAR_453_LZ_Toyota_markII_L /* 9634245 */:
            case FinalCanbus.CAR_453_LZ_Toyota_markII_H /* 9699781 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300 /* 15008198 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER /* 15139270 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER_H /* 15532486 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300_H /* 15598022 */:
                cls = LuzLexusISIndexAct.class;
                break;
            case FinalCanbus.CAR_RZC_XP1_98_05Lexus_Rx300 /* 983152 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_NX200_17 /* 1507440 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES200_13 /* 1572976 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_RX270_14 /* 1638512 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_RX_09_14 /* 1769584 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES300_20 /* 1835120 */:
            case FinalCanbus.CAR_RZC_XC_Huangguan_14 /* 2162800 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_GS_04_07 /* 2818160 */:
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
                cls = ToyotaLexusIndexActi.class;
                break;
            case FinalCanbus.CAR_RZC_XP1_BeiQiBJ40_21 /* 983436 */:
            case FinalCanbus.CAR_RZC_XP1_BeiQiBJ40_21_H /* 1048972 */:
            case FinalCanbus.CAR_RZC_XP1_BeiQiBJ40_20_H /* 1114508 */:
                cls = RZCBeiqiBJ40CarSet.class;
                break;
            case FinalCanbus.CAR_439_OuDi_Z560 /* 983479 */:
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460 /* 5308868 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460_H /* 5374404 */:
            case FinalCanbus.CAR_452_LZ_Toyota_LC100 /* 5439940 */:
            case FinalCanbus.CAR_452_LZ_Toyota_LC100_H /* 5505476 */:
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD /* 8913349 */:
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11_CD_H /* 8978885 */:
            case FinalCanbus.CAR_454_LZ_Toyota_LAND_CRUISER_11_CD_DH /* 16581062 */:
            case FinalCanbus.CAR_454_LZ_Toyota_LAND_CRUISER_11_CD_DH_H /* 16646598 */:
                if (LauncherApplication.getConfiguration() == 1) {
                    cls = LuzLexusLSClockSetAct.class;
                    break;
                } else {
                    cls = LuzLexusISIndexAct.class;
                    break;
                }
            case FinalCanbus.CAR_OD_NISSAN_Xima_L /* 1048656 */:
            case FinalCanbus.CAR_OD_NISSAN_Xima_H /* 1114192 */:
            case FinalCanbus.CAR_OD_NISSAN_Loulan_L /* 1179728 */:
            case FinalCanbus.CAR_OD_NISSAN_Loulan_H /* 1245264 */:
            case FinalCanbus.CAR_OD_NISSAN_Gongjue_L /* 1310800 */:
            case FinalCanbus.CAR_OD_NISSAN_Gongjue_H /* 1376336 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_22Teana_Top /* 1572944 */:
                cls = OD_NissanXimaIndexAct.class;
                break;
            case FinalCanbus.CAR_RZC_FengShen_YiXuan /* 1048831 */:
            case FinalCanbus.CAR_RZC_FengShen_YiXuan_H /* 1114367 */:
            case FinalCanbus.CAR_RZC_FengShen_YiXuan_21 /* 1310975 */:
            case FinalCanbus.CAR_RZC_FengShen_YiXuan_H_21 /* 1376511 */:
                cls = RzcFengshenYixuanSetFunc.class;
                break;
            case FinalCanbus.CAR_RZC_19MingjueHS_H /* 1048849 */:
            case FinalCanbus.CAR_RZC_Mingjue_20ZS /* 1376529 */:
            case FinalCanbus.CAR_RZC_Mingjue_20ZS_H /* 1442065 */:
            case FinalCanbus.CAR_RZC_19Mingjue_MG6 /* 1507601 */:
            case FinalCanbus.CAR_RZC_17Rongwei_EI6 /* 1573137 */:
            case FinalCanbus.CAR_RZC_18RongWei_RX8 /* 1638673 */:
            case FinalCanbus.CAR_RZC_21RongWei_I5 /* 1900817 */:
            case FinalCanbus.CAR_RZC_21RongWei_I5_H /* 1966353 */:
            case FinalCanbus.CAR_CZH_RZC_19Mingjue_MG6 /* 2097425 */:
                cls = Act20ZSIndexAct.class;
                break;
            case FinalCanbus.CAR_RZC_Mustang /* 1048910 */:
            case FinalCanbus.CAR_RZC_Mustang_M /* 5374286 */:
            case FinalCanbus.CAR_RZC_Mustang_H /* 5439822 */:
            case FinalCanbus.CAR_452_LZ_Subaru_TRIBECA /* 7078340 */:
                cls = MustangIndexAct.class;
                break;
            case FinalCanbus.CAR_DJ_XC_TOYOTA_LEXUS /* 1049005 */:
                cls = ActivityHuangGuanIndex.class;
                break;
            case FinalCanbus.CAR_453_OD_Bent_NAT /* 1049029 */:
                cls = ODBentNATCarSet.class;
                break;
            case FinalCanbus.CAR_RZC_XP1_18YuanJing /* 1114251 */:
            case FinalCanbus.CAR_RZC_Jili_18Dihao /* 1507467 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_S1_18 /* 1704075 */:
            case FinalCanbus.CAR_RZC_XP1_YuanJingX3_19_20 /* 1835147 */:
            case FinalCanbus.CAR_455_OD_Jilie_JiheA /* 2228679 */:
            case FinalCanbus.CAR_452_OD_Ruilan_X3_Pro /* 2425285 */:
            case FinalCanbus.CAR_452_OD_Jihe_EX3 /* 2490821 */:
            case FinalCanbus.CAR_454_OD_Jilie_DihaoS /* 14156230 */:
            case FinalCanbus.CAR_454_OD_Jilie_YuanchengXingzhi /* 14549446 */:
            case FinalCanbus.CAR_453_OD_Jili_Dihao_EV /* 16056773 */:
                cls = BoyueIndexAct.class;
                break;
            case FinalCanbus.CAR_RZC_BiSuT3 /* 1114377 */:
                cls = ActivityBiSuT3.class;
                break;
            case FinalCanbus.CAR_443_WC2_JiangHuai_IEV6E /* 1114555 */:
            case FinalCanbus.CAR_443_WC2_JiangHuai_T8 /* 5636539 */:
            case FinalCanbus.CAR_443_WC2_JiangHuai_T8_H /* 5702075 */:
            case FinalCanbus.CAR_443_WC2_JiangHuai_ZK /* 5767611 */:
            case FinalCanbus.CAR_443_WC2_JiangHuai_ZK_H /* 5833147 */:
                cls = WcJianghuaiIEV6EIndexAct.class;
                break;
            case FinalCanbus.CAR_452_XFY_PSA_3008_L /* 1114564 */:
            case FinalCanbus.CAR_452_XFY_PSA_3008_H /* 1180100 */:
                cls = ActivityPSA3008Index.class;
                break;
            case FinalCanbus.CAR_454_RZC_Mahindra_Thar_21 /* 1114566 */:
            case FinalCanbus.CAR_454_RZC_Mahindra_XUV_16_Hand /* 1180102 */:
            case FinalCanbus.CAR_454_RZC_TATA_NEXON_21_Hand /* 1245638 */:
                cls = LuzNissanGTRIndexAct.class;
                break;
            case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen /* 1114567 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen_3 /* 1180103 */:
            case FinalCanbus.CAR_454_LZ_Alpha_35_SCREEN /* 2621894 */:
            case FinalCanbus.CAR_454_LZ_VW_Touareg_Screen /* 9175494 */:
                cls = LZNewAllBBASetFunc.class;
                break;
            case FinalCanbus.CAR_RZC_BoYue /* 1179787 */:
            case FinalCanbus.CAR_RZC_BoYue_H /* 1245323 */:
            case FinalCanbus.CAR_RZC_BoYue_21 /* 2752651 */:
                cls = RZCBoyueCarSettingsAct.class;
                break;
            case FinalCanbus.CAR_WC2_RENAULT_Jinbei_Guanjing /* 1180000 */:
            case FinalCanbus.CAR_WC2_Benz_Smart_17 /* 1245536 */:
                cls = LeinuoGuanjingSetActi.class;
                break;
            case FinalCanbus.CAR_XP1_Meiganna4_TR_HAND /* 1245558 */:
            case FinalCanbus.CAR_XP1_Meiganna4_TR_AUTO /* 1311094 */:
            case FinalCanbus.CAR_XP1_Meiganna4_TR_AUTO_H /* 1769846 */:
                cls = Act_Keleijia_set.class;
                break;
            case FinalCanbus.CAR_RZC_09_16KeleiAo /* 1245586 */:
                cls = KeleiaoCarCD.class;
                break;
            case FinalCanbus.CAR_439_DJ_LEXUS_ES /* 1245623 */:
            case FinalCanbus.CAR_439_DJ_LEXUS_ES_H /* 3801527 */:
                cls = djLexusIndexAct.class;
                break;
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Hand1 /* 1245628 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Hand2 /* 1311164 */:
            case FinalCanbus.CAR_452_OD_Toyota_Lexus /* 1245636 */:
            case FinalCanbus.CAR_439_RZC_TOYATO_13HuangGuan /* 6947255 */:
                cls = ActivityHuangGuanIndex.class;
                break;
            case FinalCanbus.CAR_453_OD_Dongfeng_Xiaohu /* 1245637 */:
            case FinalCanbus.CAR_453_OD_Dongfeng_EX1_Pro /* 1311173 */:
                cls = ODDongfengEVCarInfo.class;
                break;
            case FinalCanbus.CAR_455_LZ_Ford_Mustang_L_CYT /* 1245639 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand /* 1311174 */:
            case FinalCanbus.CAR_455_LZ_Ford_Mustang_H_CYT /* 1311175 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto /* 1376710 */:
            case FinalCanbus.CAR_455_LZ_Ford_Mustang_RH_CYT /* 1376711 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand /* 1442246 */:
            case FinalCanbus.CAR_455_LZ_Ford_Mustang_RL_CYT /* 1442247 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto /* 1507782 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand_S /* 1573318 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto_S /* 1638854 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand_S /* 1704390 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto_S /* 1769926 */:
            case FinalCanbus.CAR_454_LZ_Ford_F150_15_L /* 3932614 */:
            case FinalCanbus.CAR_454_LZ_Ford_F150_15_H /* 3998150 */:
            case FinalCanbus.CAR_452_LZ_Ford_Mustang /* 11403716 */:
            case FinalCanbus.CAR_452_LZ_Ford_Mustang_H /* 14090692 */:
                if (LauncherApplication.getConfiguration() == 1) {
                    cls = LZMustangCarEQSet.class;
                    break;
                } else {
                    cls = MustangIndexAct.class;
                    break;
                }
            case FinalCanbus.CAR_RZC_XP1_CHR_EV /* 1310832 */:
                cls = CamryIndexEVAct.class;
                break;
            case FinalCanbus.CAR_RZC_HavalH7_19 /* 1310964 */:
            case FinalCanbus.CAR_RZC_HavalH7_19_H /* 1638644 */:
            case FinalCanbus.CAR_RZC_HavalH7_19_NoAmp /* 1704180 */:
            case FinalCanbus.CAR_RZC_HavalH7_19_H_NoAmp /* 1769716 */:
            case FinalCanbus.CAR_RZC_Haval_H7Hongbiao_18 /* 2097396 */:
            case FinalCanbus.CAR_RZC_Haval_H7Hongbiao_18_H /* 2162932 */:
            case FinalCanbus.CAR_RZC_HavalH7L_17 /* 2359540 */:
            case FinalCanbus.CAR_RZC_HavalH7L_17_H /* 2425076 */:
                cls = ActivityHava18H6Index.class;
                break;
            case FinalCanbus.CAR_XP_Renault_21Duster /* 1311144 */:
                cls = Activity_424_ClioFuncSet.class;
                break;
            case FinalCanbus.CAR_RZC_Nissan_Tianlai_Amp /* 1376446 */:
                cls = SanlinIndexAct.class;
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
                cls = PAJeepAllIndexActi.class;
                break;
            case FinalCanbus.CAR_WC2_QiChen_T90 /* 1376651 */:
            case FinalCanbus.CAR_WC2_QiChen_D60 /* 1507723 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9 /* 1376695 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
            case FinalCanbus.CAR_RZC_Haval_H9 /* 2490807 */:
            case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
            case FinalCanbus.CAR_RZC_HavalH6Couple_BLUE_TOP /* 7078327 */:
            case FinalCanbus.CAR_RZC_HavalH6Couple_RED_TOP /* 7143863 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6Couple_19 /* 7602615 */:
            case FinalCanbus.CAR_452_RZC_Haval_H9_Low /* 8651204 */:
            case FinalCanbus.CAR_439_RZC_Haval_18_19H6 /* 11272631 */:
            case FinalCanbus.CAR_454_RZC_Haval_H8_15 /* 11796934 */:
            case FinalCanbus.CAR_454_RZC_Haval_H8_15_H /* 11862470 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_RS /* 15598007 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
            case FinalCanbus.CAR_452_OD_Haval_VV5 /* 16122308 */:
            case FinalCanbus.CAR_452_OD_Haval_VV6 /* 16187844 */:
            case FinalCanbus.CAR_452_OD_Haval_VV7 /* 16253380 */:
            case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
            case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
            case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                cls = RZC_Oudi_0439_HavalH9_IndexAct.class;
                break;
            case FinalCanbus.CAR_443_WC2_TOYOTA_09HG /* 1376699 */:
                cls = WC209HuangguanEQAct.class;
                break;
            case FinalCanbus.CAR_444_WC2_IKCO_Tara_21 /* 1376700 */:
            case FinalCanbus.CAR_444_WC2_IKCO_Dena_15 /* 1442236 */:
                cls = WC2IKCOAllCarSetAct.class;
                break;
            case FinalCanbus.CAR_453_LZ_AstonMartin /* 1376709 */:
                cls = LuZAstonMartinCarInfo.class;
                break;
            case FinalCanbus.CAR_RZC_Jili_19Dihao_GL_E /* 1441931 */:
            case FinalCanbus.CAR_Oudi_Jili_Binyue_Pro /* 3211403 */:
                cls = Dihao19GLECarSettingsAct.class;
                break;
            case FinalCanbus.CAR_RZC_FengShen_X37_21 /* 1442047 */:
            case FinalCanbus.CAR_RZC_FengShen_D27_21 /* 1507583 */:
                cls = RzcFengshenX37SetFunc.class;
                break;
            case FinalCanbus.CAR_439_DJ_TOYOTA_08Prado_ShuPing_H /* 1442231 */:
                cls = DJPrado8SetFunc.class;
                break;
            case FinalCanbus.CAR_439_LUZ_BinLi_H /* 1442244 */:
            case FinalCanbus.CAR_439_LUZ_BinLi /* 9241015 */:
                cls = BinliIndexAct.class;
                break;
            case FinalCanbus.CAR_RZC_HONDA_9Yage /* 1507626 */:
            case FinalCanbus.CAR_RZC_HONDA_9Yage_H /* 1573162 */:
            case FinalCanbus.CAR_RZC_HONDA_10Yage /* 1769770 */:
            case FinalCanbus.CAR_RZC_HONDA_Concept_EV1 /* 1966378 */:
            case FinalCanbus.CAR_RZC_HONDA_Crosstour /* 2162986 */:
            case FinalCanbus.CAR_RZC_HONDA_10Yage_H /* 2556202 */:
            case FinalCanbus.CAR_RZC_HONDA_23Yage /* 4260138 */:
                cls = HondaIndexActi.class;
                break;
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_GX50 /* 1507771 */:
                if (LauncherApplication.getConfiguration() == 1) {
                    cls = WcInfeinidiCarSet.class;
                    break;
                } else {
                    cls = WcInfeonidiIndexAct.class;
                    break;
                }
            case FinalCanbus.CAR_439_OD_Qirui_KaiyiX3 /* 1507780 */:
                cls = ODKaiyiX3CarSet.class;
                break;
            case FinalCanbus.CAR_453_LZ_BMW_Mini_15 /* 1507781 */:
            case FinalCanbus.CAR_439_RZC_Sanlin_19Yige /* 10224055 */:
            case FinalCanbus.CAR_439_RZC_Sanlin_19Yige_H /* 10289591 */:
            case FinalCanbus.CAR_439_RZC_Sanlin_19Yige_Top /* 10355127 */:
            case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport /* 10420678 */:
            case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport_H /* 10486214 */:
            case FinalCanbus.CAR_452_LZ_Maserati_SP /* 12255684 */:
            case FinalCanbus.CAR_454_RZC_Sanlin_LancerEVO_08 /* 15991238 */:
            case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport_Top /* 16056774 */:
                cls = SanlinIndexAct.class;
                break;
            case FinalCanbus.CAR_455_LZ_GMC_Sierra_19_RScreen /* 1507783 */:
            case FinalCanbus.CAR_455_LZ_Chevrolet_Silverado_19_RScreen /* 1573319 */:
            case FinalCanbus.CAR_454_LZ_GMC_Sierra_19_Screen /* 11928006 */:
            case FinalCanbus.CAR_454_LZ_Chevrolet_Silverado_19_Screen /* 11993542 */:
                cls = LZNewAllGMCSetFunc.class;
                break;
            case FinalCanbus.CAR_RZC_Nissan_QUEST_13 /* 1573054 */:
            case FinalCanbus.CAR_RZC_Nissan_QUEST_13_H /* 1638590 */:
            case FinalCanbus.CAR_RZC_Nissan_Tianlai_GJ /* 1835198 */:
                cls = RZCNisaanGuishiCarSettingsAct.class;
                break;
            case FinalCanbus.CAR_RZC_FengShen_EX1_21 /* 1573119 */:
                cls = RZCFengshenEX1CarInfo.class;
                break;
            case FinalCanbus.CAR_WC_SP_09_Lexus_ES350 /* 1573158 */:
            case FinalCanbus.CAR_WC_SP_09_Lexus_ES350_H /* 1638694 */:
            case FinalCanbus.CAR_WC2_TOYOTA_06ReiZ_KeepAir /* 2883878 */:
            case FinalCanbus.CAR_WC2_TOYOTA_06ReiZ_ChangeAir /* 2949414 */:
                if (LauncherApplication.getConfiguration() == 1) {
                    cls = Wc09LexusESEQActi.class;
                    break;
                } else {
                    cls = Wc09LexusESIndexActi.class;
                    break;
                }
            case FinalCanbus.CAR_439_OuDi_17DongNanV5 /* 1573303 */:
                cls = Dongnanv5IndexActi.class;
                break;
            case FinalCanbus.CAR_444_WC2_Saipa_Shahin_20 /* 1573308 */:
            case FinalCanbus.CAR_444_WC2_IKCO_207i_17 /* 1638844 */:
                cls = WCSaipaShahinTireAct.class;
                break;
            case FinalCanbus.CAR_452_XinCheng_Infiniti_ESQ /* 1573316 */:
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
            case FinalCanbus.CAR_452_XinCheng_Nissan_Tule_L /* 5046724 */:
            case FinalCanbus.CAR_452_XinCheng_Nissan_Tule_H /* 5112260 */:
                cls = Infiniti_XinCheng_IndexAct.class;
                break;
            case FinalCanbus.CAR_WC2_Honda_12Siyu_CRV /* 1638721 */:
            case FinalCanbus.CAR_WC2_Honda_14Siyu_L /* 1704257 */:
            case FinalCanbus.CAR_WC2_Honda_15CRV_L /* 1769793 */:
            case FinalCanbus.CAR_WC2_Honda_12Siyu /* 1966401 */:
            case FinalCanbus.CAR_WC2_Honda_15CIVIC_OverSea_L /* 3277121 */:
                cls = ActivitySiYuIndex.class;
                break;
            case FinalCanbus.CAR_RZC_XP1_21Xiaomayi_EQ1 /* 1638804 */:
                cls = ActivityQiRuiXMYCarSet.class;
                break;
            case FinalCanbus.CAR_443_WC2_19Foucs /* 1638843 */:
            case FinalCanbus.CAR_443_WC2_18Ruijie /* 1769915 */:
            case FinalCanbus.CAR_443_WC2_18Ruijie_H /* 1835451 */:
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
            case FinalCanbus.CAR_443_WC2_Ford_FIESTA_13 /* 15532475 */:
            case FinalCanbus.CAR_443_WC2_Ford_Tourneo_21 /* 15598011 */:
                cls = Focus19CarSetAct.class;
                break;
            case FinalCanbus.CAR_453_RZC_Honda_SPIRIOR_09 /* 1638853 */:
            case FinalCanbus.CAR_452_RZC_09_14_AodeSai /* 3801540 */:
            case FinalCanbus.CAR_452_RZC_Yage8 /* 9175492 */:
            case FinalCanbus.CAR_452_RZC_Crosstour_13 /* 10289604 */:
                cls = Act_RZC_CarCD_AoDeSai.class;
                break;
            case FinalCanbus.CAR_455_XP_SUBARU_19FORESTER_H /* 1638855 */:
            case FinalCanbus.CAR_439_XP_SUBARU_15_17FORESTER /* 12124599 */:
            case FinalCanbus.CAR_439_XP_SUBARU_15_16EMPREZA /* 12190135 */:
            case FinalCanbus.CAR_439_XP_SUBARU_15_17CROSSTREK /* 12255671 */:
            case FinalCanbus.CAR_439_XP_SUBARU_15_19OUTBACK /* 12321207 */:
            case FinalCanbus.CAR_439_XP_SUBARU_15_19LEGACY /* 12386743 */:
            case FinalCanbus.CAR_439_XP_SUBARU_17_19EMPREZA /* 12452279 */:
            case FinalCanbus.CAR_439_XP_SUBARU_18_19CROSSTREK /* 12517815 */:
            case FinalCanbus.CAR_439_XP_SUBARU_19FORESTER /* 12583351 */:
                cls = SuburuCarSet.class;
                break;
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES300_05 /* 1704048 */:
            case FinalCanbus.CAR_RZC_TOYOTA_04Verso_SP /* 7078000 */:
            case FinalCanbus.CAR_RZC_TOYOTA_10Prius_SP /* 7536752 */:
                if (LauncherApplication.getConfiguration() == 1) {
                    cls = ToyotaLexusEQActi.class;
                    break;
                } else {
                    cls = ToyotaLexusIndexActi.class;
                    break;
                }
            case FinalCanbus.CAR_RZC_Nissan_Ruiqi6_21 /* 1704126 */:
            case FinalCanbus.CAR_RZC_Nissan_Ruiqi6_21_H /* 1769662 */:
                cls = BoyueIndexAct.class;
                break;
            case FinalCanbus.CAR_443_WC2_Nissan_Ruiqi /* 1704379 */:
            case FinalCanbus.CAR_444_WC2_Dongfeng_Xiaokang_Ix5 /* 1835452 */:
            case FinalCanbus.CAR_443_WC2_Nissan_Ruiqi7 /* 7799227 */:
                cls = WCNissanRuiqi6IndexAct.class;
                break;
            case FinalCanbus.CAR_453_RZC_Hongqi_H5 /* 1704389 */:
            case FinalCanbus.CAR_453_RZC_Hongqi_H5_M /* 9044421 */:
            case FinalCanbus.CAR_453_RZC_Hongqi_H5_H /* 9109957 */:
                cls = RZCHongqiH5CarSet.class;
                break;
            case FinalCanbus.CAR_455_TD_INFINIT_ESQ /* 1704391 */:
            case FinalCanbus.CAR_455_TD_INFINIT_G /* 1769927 */:
            case FinalCanbus.CAR_455_TD_INFINIT_QX50 /* 1835463 */:
            case FinalCanbus.CAR_455_TD_INFINIT_06FX /* 1900999 */:
            case FinalCanbus.CAR_455_TD_INFINIT_08FX /* 1966535 */:
            case FinalCanbus.CAR_455_TD_INFINIT_14QX70 /* 2032071 */:
            case FinalCanbus.CAR_455_TD_INFINIT_12FX /* 2097607 */:
            case FinalCanbus.CAR_439_XBS_NISSAN_TuLe /* 2425271 */:
            case FinalCanbus.CAR_439_XBS_NISSAN_TuLe_ALLV /* 3342775 */:
            case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_L /* 13763014 */:
            case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_H /* 13828550 */:
                cls = XBSTuleIndexAct.class;
                break;
            case FinalCanbus.CAR_WC2_18BYD_YUAN /* 1769867 */:
                cls = BYDYuanCarSettingsAct.class;
                break;
            case FinalCanbus.CAR_453_OD_Jiangling_Kaiyun /* 1769925 */:
            case FinalCanbus.CAR_453_OD_Jiangling_Kaiyun_H /* 1835461 */:
            case FinalCanbus.CAR_453_OD_Ford_PRO_23 /* 8389061 */:
            case FinalCanbus.CAR_452_OD_Ford_PRO /* 8454596 */:
            case FinalCanbus.CAR_452_OD_Ford_PRO_H /* 9241028 */:
            case FinalCanbus.CAR_453_OD_JMC_Energy_Yizhi_EV3 /* 12648901 */:
            case FinalCanbus.CAR_454_OD_Jiangling_Dadao /* 14483910 */:
                cls = BnrGuanzhiIndexAct.class;
                break;
            case FinalCanbus.CAR_Oudi_Zhongxing_Terralord /* 1835263 */:
            case FinalCanbus.CAR_Oudi_Zhongxing_Terralord_H /* 1900799 */:
                cls = RZC_0255_HanTengX5_TireAct.class;
                break;
            case FinalCanbus.CAR_WC2_Honda_14Siyu_H /* 1835329 */:
            case FinalCanbus.CAR_WC2_Honda_15CRV_H /* 1900865 */:
            case FinalCanbus.CAR_WC2_Honda_15CIVIC_OverSea_H /* 3211585 */:
                cls = HondaIndexActi.class;
                break;
            case FinalCanbus.CAR_454_Tangdu_Toyota_LexusIS /* 1835462 */:
            case FinalCanbus.CAR_452_Tangdu_Toyota_All /* 8913348 */:
            case FinalCanbus.CAR_452_Tangdu_Toyota_All_H /* 8978884 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_Camery_12 /* 9765317 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_Prado_14_Auto /* 9830853 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_LexusRX_07_H /* 9896389 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_Camery_15 /* 9961925 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_Reiz_15 /* 10027461 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_LexusRX_07_L /* 10092997 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_LAND_CRUISE_12 /* 10158533 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_LAND_CRUISE_16 /* 10224069 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_Reiz_12 /* 10289605 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_Camery_09_A /* 10355141 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_Prado_14_Hand /* 10420677 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_HIGHLANDER_15_A /* 10486213 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_ALPHARD_15_A /* 10551749 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_HIGHLANDER_15_H /* 10617285 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_HIGHLANDER_09_H /* 10682821 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_HIGHLANDER_09_A /* 10748357 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_ALPHARD_11_A /* 10813893 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_Corolla_07_A /* 10879429 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_Corolla_14_A /* 10944965 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_Reiz_09_A /* 11010501 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_RAV4_12_A /* 11076037 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_Tundra_14_A /* 11141573 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_Tundra_14_H /* 11207109 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_Prado_18_Auto /* 11272645 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_Prado_18_H /* 11338181 */:
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
            case FinalCanbus.CAR_453_Tangdu_Toyota_Camery_09_H /* 12190149 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_LAND_CRUISE_08_M /* 12255685 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_LAND_CRUISE_16_M /* 12321221 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_FORTUNER_16_H /* 12386757 */:
                cls = ToyotaTangduIndexAct.class;
                break;
            case FinalCanbus.CAR_RZC_Nissan_JUKE_HW /* 1900734 */:
                cls = NissanJukeCarSet.class;
                break;
            case FinalCanbus.CAR_RZC_Ford_Lincoln_navigator /* 1900878 */:
            case FinalCanbus.CAR_RZC_Ford_Lincoln_Continental /* 2031950 */:
                cls = MustangIndexAct.class;
                break;
            case FinalCanbus.CAR_WC2_JieTu_X70 /* 1900939 */:
            case FinalCanbus.CAR_WC2_JieTu_X70_H /* 1966475 */:
            case FinalCanbus.CAR_WC2_JieTu_X70_22 /* 2294155 */:
            case FinalCanbus.CAR_WC2_JieTu_X70_22_H /* 2359691 */:
                cls = ActivityWCQiruiJietuX70.class;
                break;
            case FinalCanbus.CAR_439_BNR_LEXUS_ES_H /* 1900983 */:
            case FinalCanbus.CAR_BNR_02_09Toyato_Prado_H /* 7733687 */:
                cls = BNRToyotaAmpCarSet.class;
                break;
            case FinalCanbus.CAR_443_WC2_Tianlai08_12_GongJue /* 1900987 */:
                cls = Wc_443_TianlaiGongjueAct.class;
                break;
            case FinalCanbus.CAR_453_XP1_ZH2_Ford_Explorer_13_Hand /* 1900997 */:
            case FinalCanbus.CAR_453_XP1_ZH2_Ford_Explorer_13_Auto /* 1966533 */:
            case FinalCanbus.CAR_453_XP1_ZH2_Ford_Explorer_16_Hand /* 2032069 */:
            case FinalCanbus.CAR_453_XP1_ZH2_Ford_Explorer_16_Auto /* 2097605 */:
            case FinalCanbus.CAR_453_XP1_Ford_Edge_2013 /* 4260293 */:
            case FinalCanbus.CAR_453_XP1_Ford_F150_2013 /* 4325829 */:
            case FinalCanbus.CAR_453_XP1_Ford_Explorer_2013 /* 4391365 */:
            case FinalCanbus.CAR_453_XP1_Ford_Taurus_2013 /* 4456901 */:
            case FinalCanbus.CAR_453_XP1_Ford_Expedition_2013 /* 4522437 */:
            case FinalCanbus.CAR_453_XP1_Ford_Edge_2015 /* 4587973 */:
            case FinalCanbus.CAR_453_XP1_Ford_Mustang_2015 /* 4653509 */:
            case FinalCanbus.CAR_453_XP_Ford_All_RP3_Hand1 /* 13107653 */:
            case FinalCanbus.CAR_453_XP_Ford_All_RP3_Hand2 /* 13173189 */:
            case FinalCanbus.CAR_453_XP_Ford_All_RP3_Auto1 /* 13238725 */:
            case FinalCanbus.CAR_453_XP_Ford_All_RP3_Auto2 /* 13304261 */:
            case FinalCanbus.CAR_XP1_ZH2_RUIJIE2015 /* 14680516 */:
                cls = RJXpCarSetAct.class;
                break;
            case FinalCanbus.CAR_454_LUZ_KAYAN_MACAN_CD_HP_LOW /* 1900998 */:
            case FinalCanbus.CAR_454_LUZ_KAYAN_LOW /* 2556358 */:
            case FinalCanbus.CAR_439_LUZ_KAYAN /* 3408311 */:
            case FinalCanbus.CAR_439_LUZ_KAYAN2 /* 6226359 */:
            case FinalCanbus.CAR_439_LUZ_KAYAN_MACAN_CD /* 6291895 */:
            case FinalCanbus.CAR_439_LUZ_KAYAN_MACAN_CD_HP /* 6422967 */:
                cls = LuzKayanSetFunc.class;
                break;
            case FinalCanbus.CAR_PA_dorango_10 /* 1966454 */:
            case FinalCanbus.CAR_PA_GMC_13 /* 2031990 */:
            case FinalCanbus.CAR_PA_SONOTEC_13 /* 2294134 */:
            case FinalCanbus.CAR_PA_Escalade_13 /* 2359670 */:
            case FinalCanbus.CAR_PA_Ford_F250 /* 2425206 */:
            case FinalCanbus.CAR_PA_Ford_F450 /* 2490742 */:
            case FinalCanbus.CAR_PA_Ford_F650 /* 2556278 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_08 /* 5046646 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_Low /* 5112182 */:
                cls = Xp_374_FunctionlActi.class;
                break;
            case FinalCanbus.CAR_439_LUZ_LANDROVER /* 1966519 */:
                cls = LandRoverIndexAct.class;
                break;
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_07_MO /* 1966534 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_07_TX /* 2032070 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_12_MO /* 2097606 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_12_TX /* 2163142 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_10_MO /* 2228678 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_10_TX /* 2294214 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_14_MO /* 2359750 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_14_TX /* 2425286 */:
            case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_08_TX /* 6881733 */:
            case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_08_MO10 /* 6947269 */:
            case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_08_MO13 /* 7012805 */:
            case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_16_MO /* 7078341 */:
            case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_Hand /* 7143877 */:
            case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_Audo /* 7209413 */:
            case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_CD /* 7274949 */:
            case FinalCanbus.CAR_453_KYC_Toyota_PRADO_04_DVD /* 7340485 */:
            case FinalCanbus.CAR_453_KYC_Toyota_PRADO_10_Hand /* 7406021 */:
            case FinalCanbus.CAR_453_KYC_Toyota_PRADO_10_Auto /* 7471557 */:
            case FinalCanbus.CAR_453_KYC_Toyota_PRADO_10_Top /* 7537093 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Alpha_08 /* 7602629 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Alpha_08_TX /* 7668165 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Alpha_08_MO /* 7733701 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Alpha_15 /* 7799237 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Alpha_15_Top /* 7864773 */:
                cls = LuzLexusISIndexAct.class;
                break;
            case FinalCanbus.CAR_439_OuDi_NaZhiJieU7 /* 2032055 */:
            case FinalCanbus.CAR_439_OuDi_NaZhiJieU5 /* 3932599 */:
            case FinalCanbus.CAR_452_OuDi_NaZhiJieU6 /* 11534788 */:
                cls = OdNazhijieU7SetFunc.class;
                break;
            case FinalCanbus.CAR_RZC_10GrdCherokee_H /* 2097525 */:
                cls = RZC_JeepCarEQSet.class;
                break;
            case FinalCanbus.CAR_439_OuDi_MZD_ALL /* 2097591 */:
            case FinalCanbus.CAR_439_BNR_MZD_ALL /* 8061367 */:
                cls = MazdAllIndexAct.class;
                break;
            case FinalCanbus.CAR_DJ_XP1_ParkAvenue /* 2162713 */:
                cls = DjXp1_ParkAvenue_25to33_info.class;
                break;
            case FinalCanbus.CAR_439_RZC_ZhongTaiT500 /* 2163127 */:
            case FinalCanbus.CAR_439_RZC_ZhongTaiT300 /* 2228663 */:
            case FinalCanbus.CAR_439_RZC_ZhongTaiSR9 /* 2294199 */:
            case FinalCanbus.CAR_439_RZC_ZhongTaiSR9_H /* 2359735 */:
            case FinalCanbus.CAR_452_RZC_ZHongtai_JunmaS70 /* 5571012 */:
            case FinalCanbus.CAR_RZC_ZhongTaiDaMaiX7 /* 14614967 */:
                cls = RzcChanganIndexAct.class;
                break;
            case FinalCanbus.CAR_453_LZ_GM_Camaro_17 /* 2163141 */:
            case FinalCanbus.CAR_453_LZ_GM_GMC_TERRAIN_17 /* 2228677 */:
            case FinalCanbus.CAR_453_LZ_GM_Equinox_17 /* 2294213 */:
            case FinalCanbus.CAR_454_LZ_GM_Camaro_17_Auto /* 6947270 */:
            case FinalCanbus.CAR_454_LZ_GM_Equinox_17_Auto /* 7012806 */:
                cls = OD_NissanXimaIndexAct.class;
                break;
            case FinalCanbus.CAR_BNR_12Crown_M /* 2228621 */:
            case FinalCanbus.CAR_BNR_12Crown_H /* 2294157 */:
                cls = Acti_Crow_Amp_Bnr.class;
                break;
            case FinalCanbus.CAR_452_XP_Megane4_SP_L_HAND /* 2228676 */:
            case FinalCanbus.CAR_452_XP_Megane4_SP_L_AUTO /* 2294212 */:
            case FinalCanbus.CAR_452_XP_Megane4_SP_H_AUTO /* 2359748 */:
                cls = XPMeganeCarInfo.class;
                break;
            case FinalCanbus.CAR_455_OD_Dongfeng_Racing_EC75_23H /* 2294215 */:
                cls = ODRuichiEC75CarSet.class;
                break;
            case FinalCanbus.CAR_453_LZ_Benz_C200 /* 2359749 */:
                cls = LuzBenzC200CarSet.class;
                break;
            case FinalCanbus.CAR_455_LZ_MZD_CX30_Sreen /* 2359751 */:
            case FinalCanbus.CAR_455_LZ_MZD_Axela_Sreen /* 2425287 */:
            case FinalCanbus.CAR_455_LZ_MZD_CX5_Sreen /* 2490823 */:
                cls = LZNewAllMazdaSetFunc.class;
                break;
            case FinalCanbus.CAR_Lada_2019Westa /* 2490388 */:
                cls = LadaSettingsAct.class;
                break;
            case FinalCanbus.CAR_452_HC_Nissan_XiaoKe_H /* 2556356 */:
                cls = Nissan_Xiaoke_XinCheng_CarTire.class;
                break;
            case FinalCanbus.CAR_455_OUDI_Aiying_BYD_ALL /* 2556359 */:
                cls = BYDAiyingIndexAct.class;
                break;
            case FinalCanbus.CAR_XP1_TOYOTA_TR1151 /* 2621460 */:
                cls = CamryIndexAct_ZH.class;
                break;
            case FinalCanbus.CAR_439_RZC_JiangHuai_IEV6 /* 2621879 */:
            case FinalCanbus.CAR_439_RZC_JiangHuai_ALL /* 2687415 */:
            case FinalCanbus.CAR_439_RZC_JiangHuai_ALL_H /* 2752951 */:
            case FinalCanbus.CAR_453_RZC_Jianghuai_S7 /* 6029765 */:
            case FinalCanbus.CAR_453_RZC_Jianghuai_S7_H /* 6095301 */:
            case FinalCanbus.CAR_454_RZC_Jianghuai_M4_16 /* 7995846 */:
            case FinalCanbus.CAR_454_RZC_Jianghuai_S2_15 /* 8061382 */:
            case FinalCanbus.CAR_454_RZC_Jianghuai_M5_17 /* 8126918 */:
            case FinalCanbus.CAR_439_RZC_JiangHuai_19S4 /* 8323511 */:
            case FinalCanbus.CAR_439_RZC_JiangHuai_19S4_H /* 8389047 */:
            case FinalCanbus.CAR_452_RZC_Jianghuai_IEV7S /* 10879428 */:
            case FinalCanbus.CAR_452_RZC_Jianghuai_IEV7S_H /* 10944964 */:
            case FinalCanbus.CAR_439_RZC_JiangHuai_IEV6_19Low /* 11338167 */:
            case FinalCanbus.CAR_439_RZC_JiangHuai_IEV6_18Low /* 11403703 */:
                cls = RzcJianghuaiIndexAct.class;
                break;
            case FinalCanbus.CAR_452_XC_Nissan_Tul /* 2621892 */:
                cls = XCTuleIndexAct.class;
                break;
            case FinalCanbus.CAR_452_LZ_Bentley_Bentayga /* 2621893 */:
            case FinalCanbus.CAR_455_LUZ_Nissan_GTR_EN /* 2621895 */:
            case FinalCanbus.CAR_439_LUZ_Nissan_GTR /* 13566391 */:
                cls = LuzNissanGTRIndexAct.class;
                break;
            case FinalCanbus.CAR_DJ_GM_Kopach /* 2687001 */:
                cls = DJGMKopachBasicInfoAct.class;
                break;
            case FinalCanbus.CAR_444_WC2_JMC_Fusun_24 /* 2687420 */:
                cls = WC2FordLincoinCarSettingsAct.class;
                break;
            case FinalCanbus.CAR_453_LZ_Nissan_Teana_03 /* 2687429 */:
            case FinalCanbus.CAR_453_LZ_Nissan_Teana_03_H /* 2752965 */:
            case FinalCanbus.CAR_RZC_ALL_GM_08_10AstraH /* 3866685 */:
            case FinalCanbus.CAR_RZC_ALL_GM_11CorsaD /* 3932221 */:
            case FinalCanbus.CAR_RZC_ALL_GM_08Combo /* 3997757 */:
            case FinalCanbus.CAR_RZC_ALL_GM_Antara_CD /* 4653117 */:
            case FinalCanbus.CAR_RZC_ALL_GM_Antara /* 4718653 */:
            case FinalCanbus.CAR_RZC_ALL_GM_Kopach_SP /* 5636157 */:
            case FinalCanbus.CAR_RZC_ALL_GM_04_Tigra /* 5701693 */:
            case FinalCanbus.CAR_RZC_ALL_GM_06_Astra /* 5832765 */:
            case FinalCanbus.CAR_RZC_ALL_GM_08_Zafira /* 5898301 */:
            case FinalCanbus.CAR_RZC_ALL_GM_05_Vectra /* 5963837 */:
            case FinalCanbus.CAR_RZC_ALL_GM_06_Astra_CD /* 6029373 */:
            case FinalCanbus.CAR_RZC_ALL_GM_08_Zafira_CD /* 6094909 */:
            case FinalCanbus.CAR_RZC_ALL_GM_08_10AstraH_CD /* 6160445 */:
            case FinalCanbus.CAR_RZC_ALL_GM_11CorsaD_CD /* 6225981 */:
            case FinalCanbus.CAR_RZC_ALL_GM_08Combo_CD /* 6291517 */:
            case FinalCanbus.CAR_454_LZ_Nissan_05_Cima /* 9044422 */:
                cls = GmAndraIndexActi.class;
                break;
            case FinalCanbus.CAR_454_OD_Changan_Lumin /* 2687430 */:
                cls = ODChanganLuminCarSet.class;
                break;
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7 /* 2752956 */:
            case FinalCanbus.CAR_454_Sanwu_Nissan_TRAIL_2014_Auto /* 2752966 */:
            case FinalCanbus.CAR_454_Sanwu_Nissan_TRAIL_2014_Hand /* 2818502 */:
            case FinalCanbus.CAR_454_Sanwu_Nissan_Qashqai_2016_Auto /* 2884038 */:
            case FinalCanbus.CAR_454_Sanwu_Nissan_Qashqai_2016_Hand /* 2949574 */:
            case FinalCanbus.CAR_454_Sanwu_Nissan_TEANA_2013_Auto /* 3015110 */:
            case FinalCanbus.CAR_454_Sanwu_Nissan_TEANA_2013_Hand /* 3080646 */:
            case FinalCanbus.CAR_454_Sanwu_Nissan_TEANA_2008_Auto /* 3146182 */:
            case FinalCanbus.CAR_454_Sanwu_Nissan_TEANA_2008_Hand /* 3211718 */:
            case FinalCanbus.CAR_454_Sanwu_Nissan_Tiida_2011_Auto /* 3277254 */:
            case FinalCanbus.CAR_454_Sanwu_Nissan_Tiida_2011_Hand /* 3342790 */:
            case FinalCanbus.CAR_454_Sanwu_Nissan_307Z_2008_Auto /* 3408326 */:
                cls = Acti_Nissan_Sanwu.class;
                break;
            case FinalCanbus.CAR_439_RZC_ChangAn_ALL_1 /* 2818487 */:
            case FinalCanbus.CAR_439_RZC_ChangAn_ALL_2 /* 2884023 */:
            case FinalCanbus.CAR_439_RZC_ChangAn_ALL_3 /* 2949559 */:
            case FinalCanbus.CAR_439_RZC_ChangAn_ALL_4 /* 3015095 */:
                cls = RzcChanganAllIndexAct.class;
                break;
            case FinalCanbus.CAR_455_XP_ZH2_Pilotcar_P133 /* 2884039 */:
            case FinalCanbus.CAR_455_6606_RZC_VinFast_PLUS_23 /* 2949575 */:
                cls = YL6606NewVinFanAllSetFunc.class;
                break;
            case FinalCanbus.CAR_ZX_6606_HONDA_10Yage /* 3014954 */:
            case FinalCanbus.CAR_ZX_6606_HONDA_10Yage_H /* 3080490 */:
            case FinalCanbus.CAR_ZX_6606_HONDA_17CRV /* 3932458 */:
            case FinalCanbus.CAR_ZX_6606_HONDA_17BREEZE /* 3997994 */:
            case FinalCanbus.CAR_ZX_6606_HONDA_17CRV_H /* 4194602 */:
            case FinalCanbus.CAR_ZX_6606_HONDA_23CRV /* 4784426 */:
            case FinalCanbus.CAR_ZX_6606_HONDA_23CRV_H /* 4849962 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_Civic /* 5636394 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_10Yage /* 5701930 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_Haoying /* 5767466 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_CRV /* 5833002 */:
                cls = ZX6606HondaIndexActi.class;
                break;
            case FinalCanbus.CAR_WC2_Honda_17Acura_MDX /* 3014977 */:
            case FinalCanbus.CAR_WC2_CG_Honda_16Civic /* 5505345 */:
            case FinalCanbus.CAR_WC2_CG_Honda_16Civic_H /* 5570881 */:
                cls = HondaIndexActi.class;
                break;
            case FinalCanbus.CAR_RZC_15Ruijie_CD /* 3146062 */:
                cls = FordRuijieCDIndexAct.class;
                break;
            case FinalCanbus.CAR_455_LZ_BBA_LUXFT_FN /* 3146183 */:
            case FinalCanbus.CAR_453_LZ_BBA_All /* 5112261 */:
            case FinalCanbus.CAR_454_LZ_Ford_Screen /* 9503174 */:
            case FinalCanbus.CAR_454_LZ_BBA_All /* 9568710 */:
            case FinalCanbus.CAR_454_LZ_BBA_All_LOW /* 16122310 */:
                cls = ZhtdBmwIndexFunc.class;
                break;
            case FinalCanbus.CAR_453_RZC_MZD_3_20 /* 3211717 */:
            case FinalCanbus.CAR_453_RZC_MZD_ATZ_20 /* 3277253 */:
            case FinalCanbus.CAR_453_RZC_MZD_CX30_20 /* 3342789 */:
            case FinalCanbus.CAR_RZC_MZD_CX4_16 /* 14680503 */:
            case FinalCanbus.CAR_RZC_MZD_CX5_17 /* 14746039 */:
            case FinalCanbus.CAR_RZC_MZD_3_17 /* 14811575 */:
            case FinalCanbus.CAR_RZC_MZD_Atenza_17 /* 14877111 */:
            case FinalCanbus.CAR_RZC_MZD3_15_18_TW /* 14942647 */:
            case FinalCanbus.CAR_RZC_MZD_CX3_18 /* 15008183 */:
            case FinalCanbus.CAR_RZC_MZD_CX5_19 /* 15073719 */:
            case FinalCanbus.CAR_RZC_MZD_CX5_17_ML /* 15139255 */:
            case FinalCanbus.CAR_RZC_MZD_CX3_15_ML /* 15204791 */:
                cls = Rzc_Mazda_IndexAct.class;
                break;
            case FinalCanbus.CAR_455_OD_ChangAn_CS95_H /* 3277255 */:
            case FinalCanbus.CAR_439_OD_ChangAn_CS95 /* 7930295 */:
                cls = ODChanganCS95AllSetAct.class;
                break;
            case FinalCanbus.CAR_RZC_LHT_Ford_F150_10 /* 3342670 */:
            case FinalCanbus.CAR_RZC_LHT_Ford_F150_12 /* 3408206 */:
            case FinalCanbus.CAR_RZC_LHT_Ford_F150_10_Auto /* 3473742 */:
            case FinalCanbus.CAR_RZC_LHT_Ford_F150_12_Auto /* 3539278 */:
                cls = FordCarSet_RZC.class;
                break;
            case FinalCanbus.CAR_454_Sanwu_Nissan_QX56_2004_Auto /* 3473862 */:
                cls = SanwuNissanAllCarSet.class;
                break;
            case FinalCanbus.CAR_439_HC_CHRYSLER_H /* 3539383 */:
                cls = ChryslerCarEqActi.class;
                break;
            case FinalCanbus.CAR_443_WC2_BENZ_19Sprinter /* 3539387 */:
            case FinalCanbus.CAR_443_WC2_BENZ_C200_08 /* 14221755 */:
            case FinalCanbus.CAR_443_WC2_BENZ_C200_08_CD /* 14287291 */:
                cls = WCBenzSprinterCarSet.class;
                break;
            case FinalCanbus.CAR_452_RZC_ZhongTaiDaMai_X5 /* 3539396 */:
                cls = RzcChanganTireAct.class;
                break;
            case FinalCanbus.CAR_439_HC_VOLVO /* 3604919 */:
                cls = IndexAct_Hc_volvo.class;
                break;
            case FinalCanbus.CAR_443_WC2_Feiyate_Fiorino /* 3604923 */:
                cls = FYTOilMileIndexActi.class;
                break;
            case FinalCanbus.CAR_452_XC_08_Yage /* 3604932 */:
            case FinalCanbus.CAR_452_XC_Honda_SPIRIOR_09_13 /* 6291908 */:
            case FinalCanbus.CAR_452_XC_Honda_Crosstour_11_12 /* 6357444 */:
            case FinalCanbus.CAR_439_XBS_08_Yage /* 9175479 */:
            case FinalCanbus.CAR_452_WC_Honda_Yage8 /* 12321220 */:
                cls = XBS08YageIndexAct.class;
                break;
            case FinalCanbus.CAR_443_WC2_Feiyate_Doblo /* 3670459 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Egea /* 3735995 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_18Aegea /* 3932603 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_19Aegea /* 3998139 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_13_500L /* 4784571 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_19_500L /* 4850107 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_17Panda /* 5505467 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Doblo_18 /* 6554043 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Linea_09 /* 6619579 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_500_11 /* 6816187 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Ducato_23 /* 7864763 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_500_07 /* 7930299 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Fiorino_11 /* 7995835 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Puto_11 /* 8061371 */:
            case FinalCanbus.CAR_443_WC2_Alfa_Romeo_Stelvio /* 8126907 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Toro_19_H /* 8192443 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Toro_19_L /* 8257979 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Strada_19_H /* 8323515 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Strada_19_L /* 8389051 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_500x_20_H /* 8454587 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_500x_20_L /* 8520123 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Ducato_23_M /* 12124603 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Ducato_23_H /* 12190139 */:
            case FinalCanbus.CAR_443_WC2_Alfa_Romeo_Stelvio_23_L /* 12255675 */:
            case FinalCanbus.CAR_443_WC2_Alfa_Romeo_Stelvio_23_M /* 12321211 */:
            case FinalCanbus.CAR_443_WC2_Alfa_Romeo_Stelvio_23_H /* 12386747 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Panda_15 /* 12452283 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_500L_15 /* 12517819 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Linea_09_M /* 12583355 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_500_07_M /* 12648891 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Fiorino_11_M /* 12714427 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Puto_11_M /* 12779963 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Doblo_M /* 12845499 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Doblo_18_M /* 12911035 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Panda_15_M /* 12976571 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_500L_15_M /* 13042107 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Linea_09_H /* 13107643 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_500_07_H /* 13173179 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Fiorino_11_H /* 13238715 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Puto_11_H /* 13304251 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Doblo_H /* 13369787 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Doblo_18_H /* 13435323 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Panda_15_H /* 13500859 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_500L_15_H /* 13566395 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_All_Brazil /* 14090683 */:
                cls = WCFeiyateIndexAct.class;
                break;
            case FinalCanbus.CAR_452_LZ_Jaguar_XK /* 3670468 */:
            case FinalCanbus.CAR_452_LZ_Jaguar_F_TYPE /* 6881732 */:
            case FinalCanbus.CAR_452_LZ_Jaguar_XJL /* 7012804 */:
            case FinalCanbus.CAR_452_LZ_Jaguar_XFL_PACE /* 12779972 */:
            case FinalCanbus.CAR_452_LZ_Jaguar_XFL_PACE_H /* 13238724 */:
            case FinalCanbus.CAR_452_LUZ_LANDROVER_CYTAIR /* 15729092 */:
            case FinalCanbus.CAR_454_OD_Nissan_ELGRAND /* 3670470 */:
            case FinalCanbus.CAR_454_OD_Nissan_ELGRAND_H /* 3736006 */:
            case FinalCanbus.CAR_452_OD_Nissan_QUEST /* 5636548 */:
                cls = ODNissanQuystCarSet.class;
                break;
            case FinalCanbus.CAR_439_HCY_BYD_E6_H /* 3735991 */:
            case FinalCanbus.CAR_439_HCY_BYD_S6_H /* 6750647 */:
                cls = Activity_HCY_BYD_S7.class;
                break;
            case FinalCanbus.CAR_452_OD_WeiCai_U70_20 /* 3736004 */:
                cls = ODWeiChaiU70CarInfo.class;
                break;
            case FinalCanbus.CAR_443_WC2_Nazhijie_U6 /* 3801531 */:
                cls = WCNazhijieU6CarSet.class;
                break;
            case FinalCanbus.CAR_452_OD_BMW_Mini_14_20 /* 3867076 */:
                cls = ODBMWMiniIndexAct.class;
                break;
            case FinalCanbus.CAR_439_XBS_09Tianlai /* 4063671 */:
                cls = XBS09TianlaiIndexAct.class;
                break;
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_15Q70_All /* 4063675 */:
                cls = WcInfinitCarTire.class;
                break;
            case FinalCanbus.CAR_454_OD_Beijing_X3_18 /* 4063686 */:
            case FinalCanbus.CAR_454_OD_Beijing_X5_18 /* 4129222 */:
            case FinalCanbus.CAR_454_OD_Beiqi_EU5_18 /* 4194758 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_D50_19 /* 4260294 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X35_19 /* 4325830 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X55_18 /* 4391366 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Zhixing_18 /* 4456902 */:
            case FinalCanbus.CAR_439_OUDI_Beiqi_EC3 /* 14090679 */:
            case FinalCanbus.CAR_439_OUDI_Beiqi_EC5 /* 14156215 */:
            case FinalCanbus.CAR_439_OUDI_Beiqi_EC180 /* 14221751 */:
            case FinalCanbus.CAR_439_OUDI_Beiqi_EC220 /* 14287287 */:
            case FinalCanbus.CAR_439_OUDI_Beiqi_EU5 /* 14352823 */:
                cls = ActivityODBeiqiECIndex.class;
                break;
            case FinalCanbus.CAR_WC2_GM_Kopach_12 /* 4128804 */:
                cls = WcGMKopachBasicInfoAct.class;
                break;
            case FinalCanbus.CAR_439_HC_RongWei950 /* 4129207 */:
                cls = Hc_Rongwei950_IndexAct.class;
                break;
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_15Q70 /* 4129211 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_16Q50l_SP /* 5308859 */:
            case FinalCanbus.CAR_443_WC_12Cedric /* 7209403 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_14Q50_L /* 8651195 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_20QX60 /* 15204795 */:
                cls = WcInfeonidiIndexAct.class;
                break;
            case FinalCanbus.CAR_439_BNR_ARRIZO /* 4194743 */:
                cls = BNR_Arrizo_CarSettingAct.class;
                break;
            case FinalCanbus.CAR_452_OD_BMW_120 /* 4194756 */:
            case FinalCanbus.CAR_452_OD_BMW_130 /* 4260292 */:
            case FinalCanbus.CAR_452_OD_BMW_318 /* 4325828 */:
            case FinalCanbus.CAR_452_OD_BMW_320 /* 4391364 */:
            case FinalCanbus.CAR_452_OD_BMW_325 /* 4456900 */:
            case FinalCanbus.CAR_452_OD_BMW_X1 /* 4522436 */:
            case FinalCanbus.CAR_452_OD_BMW_E90 /* 4587972 */:
            case FinalCanbus.CAR_452_OD_BMW_E60 /* 4653508 */:
                cls = ODBMWMiniIndexAct.class;
                break;
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_14QX60_SP /* 4260283 */:
            case FinalCanbus.CAR_439_RZC_LufengXiaoyao /* 4325815 */:
                cls = RZCLufengXiaoyaoIndexAct.class;
                break;
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_16Q50l /* 4325819 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_10G37 /* 4587963 */:
                cls = WcInfeinidiCarSet.class;
                break;
            case FinalCanbus.CAR_439_RZC_BenzAll /* 4456887 */:
            case FinalCanbus.CAR_439_RZC_BenzAll_H /* 4522423 */:
            case FinalCanbus.CAR_454_RZC_Benz_C_02_07 /* 7406022 */:
            case FinalCanbus.CAR_454_RZC_Benz_E200_02_08 /* 7471558 */:
            case FinalCanbus.CAR_454_RZC_Benz_Sprinter_14 /* 7537094 */:
            case FinalCanbus.CAR_454_RZC_Benz_S_99_05 /* 7602630 */:
            case FinalCanbus.CAR_454_RZC_Benz_CLS_12_13 /* 7668166 */:
            case FinalCanbus.CAR_454_RZC_Benz_C_15 /* 7733702 */:
            case FinalCanbus.CAR_452_RZC_Benz_Vito_16_18 /* 8257988 */:
            case FinalCanbus.CAR_454_RZC_Benz_GLK300_12 /* 9634246 */:
            case FinalCanbus.CAR_454_RZC_Benz_GLK350_09 /* 9699782 */:
            case FinalCanbus.CAR_454_RZC_Benz_S350_10 /* 9830854 */:
            case FinalCanbus.CAR_454_RZC_Benz_E260_09 /* 10682822 */:
            case FinalCanbus.CAR_454_RZC_Benz_GLA200_17 /* 10944966 */:
            case FinalCanbus.CAR_454_RZC_Benz_C180_17 /* 11010502 */:
            case FinalCanbus.CAR_439_RZC_Benz_GLK300 /* 11534775 */:
            case FinalCanbus.CAR_439_RZC_Benz_A180 /* 11600311 */:
            case FinalCanbus.CAR_439_RZC_Benz_14ML350 /* 11665847 */:
            case FinalCanbus.CAR_439_RZC_Benz_14ML320 /* 11731383 */:
            case FinalCanbus.CAR_439_RZC_Benz_04_12A /* 11796919 */:
            case FinalCanbus.CAR_439_RZC_Benz_05_11B /* 11862455 */:
            case FinalCanbus.CAR_439_RZC_Benz_06_15R /* 11927991 */:
            case FinalCanbus.CAR_439_RZC_Benz_05_13GL /* 11993527 */:
            case FinalCanbus.CAR_439_RZC_Benz_10_WeiYaNuo /* 12059063 */:
            case FinalCanbus.CAR_452_RZC_Benz_C_11_13 /* 12190148 */:
            case FinalCanbus.CAR_452_RZC_Benz_SLK200_11 /* 12845508 */:
            case FinalCanbus.CAR_452_RZC_Benz_E260_10 /* 13500868 */:
            case FinalCanbus.CAR_452_RZC_Benz_CLK_06 /* 13566404 */:
                cls = RzcBenzCCarSet.class;
                break;
            case FinalCanbus.CAR_439_HC_Qiya_KaiZunK7 /* 4719031 */:
                cls = HCQiyaKaizunK7Audio.class;
                break;
            case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD /* 4719035 */:
            case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD_HW /* 4915643 */:
                cls = WC08TianlaiIndexAct.class;
                break;
            case FinalCanbus.CAR_453_RZC_SWM_G01_22 /* 4784581 */:
            case FinalCanbus.CAR_453_RZC_SWM_G05Pro_22 /* 5964229 */:
            case FinalCanbus.CAR_452_RZC_SWM_G01_21_Low /* 11338180 */:
            case FinalCanbus.CAR_439_RZC_SWM_G01 /* 13894071 */:
            case FinalCanbus.CAR_439_RZC_SWM_G01_19 /* 15729079 */:
                cls = RZCSiWeiCarSet.class;
                break;
            case FinalCanbus.CAR_439_RZC_CanAdd1 /* 4850103 */:
                cls = RZC_0255_FengShenAx7_IndexAct.class;
                break;
            case FinalCanbus.CAR_453_OD_BQ_BJ80 /* 4850117 */:
                cls = ODBeiqiBJ80CarSet.class;
                break;
            case FinalCanbus.CAR_439_RZC_TuDa /* 4915639 */:
            case FinalCanbus.CAR_439_RZC_TuDa_Hand /* 11207095 */:
                cls = RzcNissanTudaInTireAct.class;
                break;
            case FinalCanbus.CAR_452_LZ_Jaguar_XF /* 4915652 */:
            case FinalCanbus.CAR_452_LZ_Jaguar_XF_09 /* 6029764 */:
                cls = LuzJaguarXFCarSet.class;
                break;
            case FinalCanbus.CAR_453_RZC_Mclaren_16_560S /* 4915653 */:
            case FinalCanbus.CAR_453_RZC_Mclaren_19_720S /* 4981189 */:
                cls = RZCMclarenCarSet.class;
                break;
            case FinalCanbus.CAR_439_XFY_SanLing_13Oulande_H /* 4981175 */:
            case FinalCanbus.CAR_439_XFY_SanLing_17Oulande_H /* 5046711 */:
            case FinalCanbus.CAR_439_XFY_SanLing_Tai_Pajieluo_H /* 5112247 */:
            case FinalCanbus.CAR_439_XFY_SanLing_13Oulande_Low /* 5177783 */:
            case FinalCanbus.CAR_439_XFY_SanLing_17Oulande_Low /* 5243319 */:
            case FinalCanbus.CAR_439_XFY_SanLing_Tai_Pajieluo_Low /* 5308855 */:
                cls = XFYSanLingAllEQAct.class;
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
                cls = WC2FordLincoinIndexAct.class;
                break;
            case FinalCanbus.CAR_452_DJ_Dodge_JCUV /* 4981188 */:
                cls = DjDodgeCarSet.class;
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
            case FinalCanbus.CAR_PA_BNR_Toyota_LS460_06 /* 6095245 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_GS_06 /* 6160781 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_IS_06 /* 6226317 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_ES_06 /* 6291853 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_GX460_10 /* 6357389 */:
            case FinalCanbus.CAR_BNR_Toyota_14Tundra_AMP /* 6422925 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AMP /* 6488461 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP /* 6553997 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP_19 /* 6619533 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10_AMP /* 6685069 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AMP /* 6750605 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_AMP /* 6816141 */:
                cls = PAToyotaAllIndexActi.class;
                break;
            case FinalCanbus.CAR_452_OD_Porsche_15_20 /* 5177796 */:
                cls = ODPorscheIndexAct.class;
                break;
            case FinalCanbus.CAR_453_LZ_NISSAN_patrol /* 5308869 */:
            case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX60 /* 5374405 */:
            case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX80 /* 5439941 */:
            case FinalCanbus.CAR_453_LZ_YinFeiNiDi_QX56 /* 5505477 */:
            case FinalCanbus.CAR_454_LZ_Nissan_370Z_L /* 14680518 */:
            case FinalCanbus.CAR_454_LZ_Nissan_370Z_H /* 14746054 */:
            case FinalCanbus.CAR_454_LZ_Nissan_370Z_TW /* 14811590 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_L /* 15729094 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H /* 15794630 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_TW /* 15860166 */:
            case FinalCanbus.CAR_454_LZ_Infinite_Qx56_08_H_NP /* 15925702 */:
                cls = LZ_NIssanInfinitiIndexAct.class;
                break;
            case FinalCanbus.CAR_443_WC2_TATA_HEXA /* 5374395 */:
            case FinalCanbus.CAR_443_WC2_TATA_NWXON /* 5439931 */:
            case FinalCanbus.CAR_443_WC2_TATA_Altroz /* 11927995 */:
            case FinalCanbus.CAR_443_WC2_TATA_Tiago /* 11993531 */:
                cls = WC2TataCarSet.class;
                break;
            case FinalCanbus.CAR_453_LZ_Chrysler_300C_15 /* 5571013 */:
            case FinalCanbus.CAR_453_LZ_Maserati_Levante_18 /* 5636549 */:
            case FinalCanbus.CAR_454_LZ_Chrysler_300C_15_Daohang /* 7078342 */:
                cls = LuZMaserati300CCarSet.class;
                break;
            case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9 /* 5702084 */:
            case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_Auto /* 5833156 */:
            case FinalCanbus.CAR_454_OD_Qichen_D60_EV /* 9961926 */:
            case FinalCanbus.CAR_453_PA_Ford_Mustang_10 /* 5767621 */:
            case FinalCanbus.CAR_452_PA_Ford_F150_10 /* 15598020 */:
                cls = PAFord_FunctionlActi.class;
                break;
            case FinalCanbus.CAR_453_DJ_Nissan_NOCD /* 5833157 */:
            case FinalCanbus.CAR_453_DJ_Nissan_NOCD_H /* 5898693 */:
                cls = djTianlaiAudio.class;
                break;
            case FinalCanbus.CAR_452_LZ_TATA_ALL /* 5898692 */:
                cls = LuzTATACarSet.class;
                break;
            case FinalCanbus.CAR_439_RZC_YinFeiNiDi_QX50 /* 6029751 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX70_13 /* 6685126 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_Q70_16_L /* 6750662 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_Q70_16_H /* 6816198 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_FX50S_09 /* 8389062 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_FX37_13 /* 10224070 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX70_15 /* 10289606 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX37_11 /* 10355142 */:
                cls = Rzc_YingFeiNiDi_GX50_CarSettingAct.class;
                break;
            case FinalCanbus.CAR_443_WC2_Mahindra_SCORPIO /* 6029755 */:
            case FinalCanbus.CAR_443_WC2_Mahindra_SCORPIO_9 /* 9634235 */:
            case FinalCanbus.CAR_443_WC2_Mahindra_SCORPIO_6 /* 9699771 */:
            case FinalCanbus.CAR_443_WC2_Mahindra_TUV300 /* 9765307 */:
            case FinalCanbus.CAR_443_WC2_Mahindra_KUV100 /* 9830843 */:
            case FinalCanbus.CAR_443_WC2_Mahindra_THAR /* 9896379 */:
                cls = WC2MHDCarSet.class;
                break;
            case FinalCanbus.CAR_452_OD_Nissan_Tule_low /* 6095300 */:
                cls = XCTuleIndexAct.class;
                break;
            case FinalCanbus.CAR_452_OD_Zhonghua_V6_18 /* 6160836 */:
            case FinalCanbus.CAR_454_OD_Zhonghua_V7 /* 14221766 */:
            case FinalCanbus.CAR_454_OD_Zhonghua_V7_H /* 14287302 */:
                cls = ODZhonghuaV6CarSet.class;
                break;
            case FinalCanbus.CAR_453_RZC_LandRover_Discovery_19 /* 6160837 */:
            case FinalCanbus.CAR_454_RZC_LandRover_Discovery_04 /* 9765318 */:
                cls = TDLandRoverIndexAct.class;
                break;
            case FinalCanbus.CAR_452_Xinchi_Dodge_JCUV /* 6226372 */:
            case FinalCanbus.CAR_454_OD_Maserati_Ghibli_14 /* 14025158 */:
            case FinalCanbus.CAR_454_OD_Maserati_Quattroporte_13 /* 14090694 */:
            case FinalCanbus.CAR_439_XC_Feiyate_Feiyue /* 15532471 */:
                cls = XCFeiyateFeiyueSetFunc.class;
                break;
            case FinalCanbus.CAR_453_OD_WeiMa_EX5 /* 6226373 */:
                cls = ODWeimaEx5IndexAct.class;
                break;
            case FinalCanbus.CAR_453_OD_Zhidou_15 /* 6291909 */:
                cls = ODZhidouEVCarInfo.class;
                break;
            case FinalCanbus.CAR_439_HC_14OUBAO_CD /* 6357431 */:
                cls = IndexAct_Hc_14Oubao.class;
                break;
            case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_07_MO /* 6357445 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_07_TX /* 6422981 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_12_MO /* 6488517 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Lexus_LX570_12_TX /* 6554053 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_10_MO /* 6619589 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_10_TX /* 6685125 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_14_MO /* 6750661 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Lexus_GX_14_TX /* 6816197 */:
                cls = KYCToyotaAllCarSet.class;
                break;
            case FinalCanbus.CAR_452_XC_Ford_Escape_13_17 /* 6422980 */:
            case FinalCanbus.CAR_452_XC_Ford_edge_11_13 /* 6488516 */:
            case FinalCanbus.CAR_452_XC_Ford_Raptor_F150_09_14 /* 6554052 */:
            case FinalCanbus.CAR_452_XC_Ford_edge_15_17 /* 6619588 */:
            case FinalCanbus.CAR_452_XC_Ford_Mondeo_13_18 /* 6685124 */:
            case FinalCanbus.CAR_439_HC_Ford_Explorer /* 15335863 */:
                cls = HcFordExplorerIndexAct.class;
                break;
            case FinalCanbus.CAR_439_AY_BYD_Sirui /* 6619575 */:
                cls = Activity_OD_Aiying_BYD_Sirui.class;
                break;
            case FinalCanbus.CAR_452_OD_chevrolet_Captiva /* 6750660 */:
                cls = RzcChanganIndexAct.class;
                break;
            case FinalCanbus.CAR_439_HC_Ruijie /* 6816183 */:
            case FinalCanbus.CAR_439_HC_Ruijie_H /* 6881719 */:
                cls = XCFordRuijieEQAct.class;
                break;
            case FinalCanbus.CAR_452_OD_Zotye_T700 /* 6816196 */:
            case FinalCanbus.CAR_452_OD_Zhongtai_Z700_H /* 12386756 */:
            case FinalCanbus.CAR_452_OD_Zhongtai_Z700 /* 12452292 */:
                cls = Activity_OD_Zotye_T700.class;
                break;
            case FinalCanbus.CAR_454_RZC_Sprinter_22 /* 6881734 */:
                cls = SanlinIndexAct.class;
                break;
            case FinalCanbus.CAR_443_WC2_UAZ_Patriot /* 6947259 */:
                cls = WCUAZPatriotCarSet.class;
                break;
            case FinalCanbus.CAR_443_WC_14Aodesai_CD /* 7078331 */:
                cls = ActivitySiYuIndex.class;
                break;
            case FinalCanbus.CAR_452_XBS_Nissan_Cedric /* 7143876 */:
                cls = XBSNissanCedricCarSet.class;
                break;
            case FinalCanbus.CAR_454_OD_Futon_TOANO /* 7143878 */:
                cls = ODFotonTOANOSetFunc.class;
                break;
            case FinalCanbus.CAR_DJ_Yage_9 /* 7209399 */:
                cls = DJYage9CarSet.class;
                break;
            case FinalCanbus.CAR_452_RZC_Subaru /* 7209412 */:
            case FinalCanbus.CAR_454_RZC_Suburu_OUTBACK_18 /* 8323526 */:
                cls = RZCSuburuCarSet.class;
                break;
            case FinalCanbus.CAR_443_WC_OPEL_Astra_04 /* 7274939 */:
            case FinalCanbus.CAR_443_WC_OPEL_Zafira_05 /* 7340475 */:
            case FinalCanbus.CAR_443_WC_OPEL_Antara_06 /* 7406011 */:
            case FinalCanbus.CAR_443_WC_OPEL_Vectra_02 /* 7471547 */:
            case FinalCanbus.CAR_443_WC_OPEL_Corsa_06 /* 7537083 */:
            case FinalCanbus.CAR_443_WC_OPEL_Meriva_03 /* 7602619 */:
            case FinalCanbus.CAR_443_WC_OPEL_Astra_04_H /* 10420667 */:
            case FinalCanbus.CAR_443_WC_OPEL_Zafira_05_H /* 10486203 */:
            case FinalCanbus.CAR_443_WC_OPEL_Antara_06_H /* 10551739 */:
            case FinalCanbus.CAR_443_WC_OPEL_Vectra_02_H /* 10617275 */:
            case FinalCanbus.CAR_443_WC_OPEL_Corsa_06_H /* 10682811 */:
            case FinalCanbus.CAR_443_WC_OPEL_Meriva_03_H /* 10748347 */:
                cls = WCOPELCarIndexActi.class;
                break;
            case FinalCanbus.CAR_452_RZC_Beiqi_BJ90 /* 7274948 */:
                cls = RZCBeiqiBJ90CarSet.class;
                break;
            case FinalCanbus.CAR_454_OD_Xinte_DEV1_H /* 7274950 */:
                cls = ODXinteDEV1SetFunc.class;
                break;
            case FinalCanbus.CAR_454_RZC_Racing_EC75_23 /* 7340486 */:
            case FinalCanbus.CAR_454_OD_Dongfeng_Racing_EC75_23 /* 8454598 */:
            case FinalCanbus.CAR_454_OD_Yutong_Qingka /* 11338182 */:
            case FinalCanbus.CAR_454_OD_Dongfeng_Tianlong /* 11403718 */:
            case FinalCanbus.CAR_454_OD_WeiCai_EHPro_24 /* 11469254 */:
            case FinalCanbus.CAR_452_XC_Rongwei_ALl /* 7471556 */:
            case FinalCanbus.CAR_452_XC_GM_ALl /* 7537092 */:
                cls = XC_GMandRongweiIndexAct.class;
                break;
            case FinalCanbus.CAR_439_RZC_ZhongTaiSR7 /* 7537079 */:
                cls = RzcChanganSetFunc.class;
                break;
            case FinalCanbus.CAR_452_OD_LandRover_Freelander /* 7799236 */:
                cls = ODFreeLanderCarInfo.class;
                break;
            case FinalCanbus.CAR_452_LZ_OUBao_Andela_CD /* 7864772 */:
                cls = Luz_Oubao_IndexAct.class;
                break;
            case FinalCanbus.CAR_452_OD_Lamborghini /* 7930308 */:
                cls = OD_Lamborghini_PanelButton.class;
                break;
            case FinalCanbus.CAR_453_LZ_ALFA_ROMEO /* 7930309 */:
                cls = BnrGuanzhiIndexAct.class;
                break;
            case FinalCanbus.CAR_439_BNR_Rongwei_RX5 /* 7995831 */:
            case FinalCanbus.CAR_439_BNR_17_RONGWEI_I6 /* 10813879 */:
                cls = ActivityBNRRongWeiRX5.class;
                break;
            case FinalCanbus.CAR_452_LZ_Volvo /* 7995844 */:
            case FinalCanbus.CAR_452_LZ_Volvo_15 /* 16515524 */:
                cls = LuzVolvoCarSet.class;
                break;
            case FinalCanbus.CAR_453_LZ_Ferrari_F12 /* 7995845 */:
                cls = LZFerrariF12CarInfo.class;
                break;
            case FinalCanbus.CAR_453_OD_BYD_Sirui /* 8061381 */:
            case FinalCanbus.CAR_439_OUDI_BYD_ALL /* 12976567 */:
            case FinalCanbus.CAR_454_CZH_OUDI_BYD_ALL /* 15663558 */:
                cls = Activity_OD_BYD_ALL.class;
                break;
            case FinalCanbus.CAR_453_LZ_Toyota_Tacoma_11 /* 8126917 */:
            case FinalCanbus.CAR_453_LZ_Toyota_Tacoma_05 /* 8192453 */:
                cls = ToyotaLexusEQActi_Luz.class;
                break;
            case FinalCanbus.CAR_454_RZC_Guanzhi3_14 /* 8192454 */:
            case FinalCanbus.CAR_454_RZC_Guanzhi5_16 /* 8257990 */:
                cls = LZ_Nissan08TeanaIndexAct.class;
                break;
            case FinalCanbus.CAR_453_XP_OPEL /* 8257989 */:
                cls = XP_Opel_Panel_New.class;
                break;
            case FinalCanbus.CAR_452_OD_HuaChen_SWM_X7 /* 8323524 */:
            case FinalCanbus.CAR_452_OD_HuaChen_SWM_X7_H /* 8389060 */:
            case FinalCanbus.CAR_454_OD_HuaChen_SWM_Dahu /* 14614982 */:
            case FinalCanbus.CAR_452_OD_HuaChen_SWM_G05 /* 15335876 */:
            case FinalCanbus.CAR_452_OD_HuaChen_SWM_G05_H /* 15401412 */:
                cls = ODHuachenSWMCarInfo.class;
                break;
            case FinalCanbus.CAR_453_OD_Zhidou_15_D1 /* 8323525 */:
                cls = ODZhidouD1EVCarInfo.class;
                break;
            case FinalCanbus.CAR_453_OD_Jili_Panda_Mini /* 8454597 */:
                cls = ODJiliRuilanX3CarSettingsAct.class;
                break;
            case FinalCanbus.CAR_452_XC_LEXUS_ES250 /* 8520132 */:
            case FinalCanbus.CAR_452_XC_LEXUS_RX270 /* 8585668 */:
            case FinalCanbus.CAR_452_XC_Lexus_ES200 /* 14418372 */:
            case FinalCanbus.CAR_452_XC_Lexus_CT200 /* 14483908 */:
            case FinalCanbus.CAR_452_XC_Lexus_NX200 /* 14549444 */:
            case FinalCanbus.CAR_452_XC_Lexus_RX350 /* 14614980 */:
                cls = XCLexusIndexAct.class;
                break;
            case FinalCanbus.CAR_454_OD_Shanqi_Delong_M3000S /* 8520134 */:
            case FinalCanbus.CAR_454_OD_Shanqi_Delong_L5000 /* 8585670 */:
            case FinalCanbus.CAR_454_OD_Shanqi_Delong_M6000 /* 8651206 */:
            case FinalCanbus.CAR_454_OD_Shanqi_Delong_X5000 /* 8716742 */:
            case FinalCanbus.CAR_454_OD_Shanqi_Xuandeyi_6 /* 8782278 */:
            case FinalCanbus.CAR_454_OD_Shanqi_Xuandeyi_9 /* 8847814 */:
            case FinalCanbus.CAR_454_OD_Shanqi_Zhiyun_E2 /* 8913350 */:
            case FinalCanbus.CAR_453_OD_Shanqi_ZHongka /* 15991237 */:
                cls = ODShanqiZHongkaCarSet.class;
                break;
            case FinalCanbus.CAR_439_XBS_NISSAN_TuLe_DZSJ /* 8716727 */:
                cls = XBSTuleDZSJIndexAct.class;
                break;
            case FinalCanbus.CAR_452_XC_Nissan_Tule_CD /* 8716740 */:
                cls = XCTuleCDIndexAct.class;
                break;
            case FinalCanbus.CAR_453_XC_BenZ_Smart /* 8716741 */:
                cls = XCBenzSmartCarSet.class;
                break;
            case FinalCanbus.CAR_439_XBS_BYD_Song /* 8782263 */:
                cls = Activity_XBS_BYD_Song.class;
                break;
            case FinalCanbus.CAR_453_LZ_Jili_Boyue_18 /* 8782277 */:
            case FinalCanbus.CAR_453_LZ_Jili_Boyue_18_H /* 8847813 */:
                cls = LZJiliBoyueCarSettingsAct.class;
                break;
            case FinalCanbus.CAR_452_ZH_Toyota_Proace /* 8847812 */:
                cls = ZHToyotaProaceCarSet.class;
                break;
            case FinalCanbus.CAR_452_DJ_Ford_Fiesta_09_15 /* 9044420 */:
            case FinalCanbus.CAR_452_DJ_Ford_Kuga_09_15 /* 9109956 */:
                cls = DJFordFiestaCarSet.class;
                break;
            case FinalCanbus.CAR_439_OD_Opel_Adan /* 9109943 */:
                cls = ODOpelAdanCarTire.class;
                break;
            case FinalCanbus.CAR_453_LZ_LandRover_13_CD /* 9175493 */:
            case FinalCanbus.CAR_453_LZ_LandRover_18_CD /* 9241029 */:
            case FinalCanbus.CAR_453_LZ_Jaguar_12_CD /* 9306565 */:
            case FinalCanbus.CAR_454_LZ_LandRover_CD_Discovery5 /* 13894086 */:
                cls = LZNewLandRoverSetFunc.class;
                break;
            case FinalCanbus.CAR_443_WC2_Proton_X50_22 /* 9306555 */:
            case FinalCanbus.CAR_443_WC2_Proton_X50_22_H /* 9372091 */:
            case FinalCanbus.CAR_443_WC2_Proton_Persona_22 /* 9437627 */:
            case FinalCanbus.CAR_443_WC2_Proton_X70_22 /* 9503163 */:
            case FinalCanbus.CAR_443_WC2_Proton_X70_22_H /* 9568699 */:
            case FinalCanbus.CAR_443_WC2_Proton_S70_24 /* 16449979 */:
            case FinalCanbus.CAR_443_WC2_Proton_S70_24_H /* 16515515 */:
            case FinalCanbus.CAR_443_WC2_Proton_X90_24 /* 16581051 */:
            case FinalCanbus.CAR_443_WC2_Proton_X90_24_H /* 16646587 */:
                cls = WCProtonAllCarSet.class;
                break;
            case FinalCanbus.CAR_439_RZC_Sanlin_18Pajieluo_H /* 9634231 */:
                cls = SanlinCarSet.class;
                break;
            case FinalCanbus.CAR_439_RCW_BYD_12_18Surui /* 9699767 */:
            case FinalCanbus.CAR_439_RCW_BYD_14_15G5 /* 9765303 */:
            case FinalCanbus.CAR_439_RCW_BYD_10_15M6 /* 9830839 */:
            case FinalCanbus.CAR_439_RCW_BYD_13_17S7 /* 9896375 */:
            case FinalCanbus.CAR_439_RCW_BYD_16_19Song /* 9961911 */:
            case FinalCanbus.CAR_439_RCW_BYD_17_19SongMax /* 10027447 */:
            case FinalCanbus.CAR_439_RCW_BYD_12_17E6 /* 10092983 */:
                cls = Activity_RCW_BYD_S7.class;
                break;
            case FinalCanbus.CAR_454_RZC_Shanqi_DelongG2 /* 10027462 */:
                cls = RZCShanqiDelongCarInfo.class;
                break;
            case FinalCanbus.CAR_454_RZC_Changan_BenBen_22 /* 10158534 */:
                cls = RzcChanganCX70TireAct.class;
                break;
            case FinalCanbus.CAR_452_OD_ChangfengLiebao_CS9_EV /* 10355140 */:
                cls = ODChangfengCS9EVCarInfo.class;
                break;
            case FinalCanbus.CAR_439_DJ_Haval_H8 /* 10420663 */:
            case FinalCanbus.CAR_439_DJ_Haval_H8_H /* 10486199 */:
            case FinalCanbus.CAR_439_DJ_Haval_H9 /* 15794628 */:
            case FinalCanbus.CAR_439_DJ_Haval_H9_H /* 15860164 */:
            case FinalCanbus.CAR_439_DJ_Haval_VV5 /* 15925700 */:
            case FinalCanbus.CAR_439_DJ_Haval_VV6 /* 15991236 */:
            case FinalCanbus.CAR_439_DJ_Haval_VV7 /* 16056772 */:
                cls = Dj_0439_HavalH8_IndexAct.class;
                break;
            case FinalCanbus.CAR_452_DJ_Jianghuai_Sihao /* 10420676 */:
                cls = DJJianghuaiSihaoCarInfo.class;
                break;
            case FinalCanbus.CAR_452_LZ_Nissan_Fuga /* 10551748 */:
                cls = LZNissanFugaCarInfo.class;
                break;
            case FinalCanbus.CAR_454_OD_Futon_Dajiangjun /* 10551750 */:
            case FinalCanbus.CAR_439_OD_Futon_Tunland /* 16449975 */:
                cls = ODFotonTunlandSetFunc.class;
                break;
            case FinalCanbus.CAR_452_KYC_Zhonghua_All /* 10617284 */:
            case FinalCanbus.CAR_452_KYC_Zhonghua_All_H /* 10682820 */:
            case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7 /* 10748356 */:
            case FinalCanbus.CAR_452_KYC_Zhonghua_All_V7_H /* 10813892 */:
                cls = KYCZhonghuaCarSet.class;
                break;
            case FinalCanbus.CAR_454_OD_Yiqi_Jiefang_J6G_23 /* 10748358 */:
                cls = ODYiqiJiefangJ6GCarSet.class;
                break;
            case FinalCanbus.CAR_443_WC_OPEL_Astra_04_P /* 10813883 */:
            case FinalCanbus.CAR_443_WC_OPEL_Zafira_05_P /* 10879419 */:
            case FinalCanbus.CAR_443_WC_OPEL_Antara_06_P /* 10944955 */:
            case FinalCanbus.CAR_443_WC_OPEL_Vectra_02_P /* 11010491 */:
            case FinalCanbus.CAR_443_WC_OPEL_Corsa_06_P /* 11076027 */:
            case FinalCanbus.CAR_443_WC_OPEL_Meriva_03_P /* 11141563 */:
            case FinalCanbus.CAR_443_WC_OPEL_Astra_04_H_P /* 11207099 */:
            case FinalCanbus.CAR_443_WC_OPEL_Zafira_05_H_P /* 11272635 */:
            case FinalCanbus.CAR_443_WC_OPEL_Antara_06_H_P /* 11338171 */:
            case FinalCanbus.CAR_443_WC_OPEL_Vectra_02_H_P /* 11403707 */:
            case FinalCanbus.CAR_443_WC_OPEL_Corsa_06_H_P /* 11469243 */:
            case FinalCanbus.CAR_443_WC_OPEL_Meriva_03_H_P /* 11534779 */:
                cls = WCOPELCarKeyActivity.class;
                break;
            case FinalCanbus.CAR_454_OD_Yiqi_Jiefang_J7_23 /* 10813894 */:
            case FinalCanbus.CAR_454_KYC_Ford_Mustang_07_H /* 13631942 */:
            case FinalCanbus.CAR_454_KYC_Ford_Mustang_07_L /* 13697478 */:
            case FinalCanbus.CAR_454_OD_Beiqi_EV160 /* 10879430 */:
                cls = ODBeiqiEV160CarSet.class;
                break;
            case FinalCanbus.CAR_439_BNR_Qichen_17T70 /* 10944951 */:
            case FinalCanbus.CAR_439_BNR_Qichen_16T70 /* 11010487 */:
                cls = BNR_QiChenT70Act.class;
                break;
            case FinalCanbus.CAR_439_BNR_Haval_H6 /* 11076023 */:
                cls = BNRActivityHavaH6SetAct.class;
                break;
            case FinalCanbus.CAR_454_Tangdu_Porsche_Cayenne_12_H /* 11076038 */:
            case FinalCanbus.CAR_454_Tangdu_Porsche_Cayenne_16_H /* 11141574 */:
            case FinalCanbus.CAR_454_Tangdu_Porsche_macan_17_H /* 11207110 */:
            case FinalCanbus.CAR_454_Tangdu_Porsche_macan_13_H /* 11272646 */:
            case FinalCanbus.CAR_453_Tangdu_Porsche_macan_17 /* 16449989 */:
            case FinalCanbus.CAR_453_Tangdu_Porsche_macan_13 /* 16515525 */:
            case FinalCanbus.CAR_453_Tangdu_Porsche_Cayenne_12 /* 16581061 */:
            case FinalCanbus.CAR_453_Tangdu_Porsche_Cayenne_16 /* 16646597 */:
                cls = TDPorscheCarSet.class;
                break;
            case FinalCanbus.CAR_439_BNR_Nissan_Tule /* 11141559 */:
                cls = BnrTuleIndexAct.class;
                break;
            case FinalCanbus.CAR_443_WC_Suzuki_S_croos_22_L /* 11600315 */:
            case FinalCanbus.CAR_443_WC_Suzuki_S_croos_22_M /* 11665851 */:
            case FinalCanbus.CAR_443_WC_Suzuki_S_croos_22_H /* 11731387 */:
            case FinalCanbus.CAR_443_WC_Suzuki_Baleno_23 /* 11796923 */:
            case FinalCanbus.CAR_443_WC_Suzuki_Fronx_23 /* 11862459 */:
            case FinalCanbus.CAR_443_WC2_TATA_harrier /* 12059067 */:
            case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_L /* 14614971 */:
            case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_M /* 14680507 */:
            case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_H /* 14746043 */:
                cls = WCSuzukiAllIndexAct.class;
                break;
            case FinalCanbus.CAR_454_OD_Jianghuai_Xingrui_24 /* 11665862 */:
            case FinalCanbus.CAR_454_OD_Jianghuai_KanglingL3_24 /* 11731398 */:
            case FinalCanbus.CAR_453_OD_Jianghuai_Chaoyue /* 12779973 */:
                cls = ODJianghuaiChaoyueCarSet.class;
                break;
            case FinalCanbus.CAR_452_PA_Nissan_XTrail_21 /* 11731396 */:
            case FinalCanbus.CAR_452_PA_Nissan_Loulan_21 /* 11796932 */:
            case FinalCanbus.CAR_452_PA_Nissan_Terra_21 /* 11862468 */:
            case FinalCanbus.CAR_452_PA_Nissan_TITAN /* 11928004 */:
            case FinalCanbus.CAR_452_PA_Infiniti_G37 /* 13894084 */:
                cls = PANissanAllCarSet.class;
                break;
            case FinalCanbus.CAR_452_TZY_UAZ_Patriot /* 11993540 */:
                cls = FaultCodeWindow.class;
                break;
            case FinalCanbus.CAR_454_Tangdu_LR_RangeRover_13_SCREEN /* 12124614 */:
            case FinalCanbus.CAR_454_Tangdu_LR_RangeRover_16_SCREEN /* 12190150 */:
            case FinalCanbus.CAR_454_Tangdu_LR_RangeRover_17_SCREEN /* 12255686 */:
            case FinalCanbus.CAR_454_Tangdu_LR_RangeRover_SCREEN /* 12321222 */:
            case FinalCanbus.CAR_454_Tangdu_LR_RangeRover_Sport_10_SCREEN /* 12386758 */:
            case FinalCanbus.CAR_454_Tangdu_LR_RangeRover_Sport_14_SCREEN /* 12452294 */:
            case FinalCanbus.CAR_454_Tangdu_LR_RangeRover_Sport_17_SCREEN /* 12517830 */:
            case FinalCanbus.CAR_454_Tangdu_LR_RangeRover_Sport_SCREEN /* 12583366 */:
            case FinalCanbus.CAR_454_Tangdu_LR_Evoque_12_SCREEN /* 12648902 */:
            case FinalCanbus.CAR_454_Tangdu_LR_Evoque_13_SCREEN /* 12714438 */:
            case FinalCanbus.CAR_454_Tangdu_LR_Evoque_16_SCREEN /* 12779974 */:
            case FinalCanbus.CAR_454_Tangdu_LR_Evoque_17_SCREEN /* 12845510 */:
            case FinalCanbus.CAR_454_Tangdu_LR_Evoque_SCREEN /* 12911046 */:
            case FinalCanbus.CAR_454_Tangdu_LR_Velar_SCREEN /* 12976582 */:
            case FinalCanbus.CAR_453_Tangdu_LR_RangeRover_13 /* 13369797 */:
            case FinalCanbus.CAR_453_Tangdu_LR_RangeRover_16 /* 13435333 */:
            case FinalCanbus.CAR_453_Tangdu_LR_RangeRover_17 /* 13500869 */:
            case FinalCanbus.CAR_453_Tangdu_LR_RangeRover /* 13566405 */:
            case FinalCanbus.CAR_453_Tangdu_LR_RangeRover_Sport_10 /* 13631941 */:
            case FinalCanbus.CAR_453_Tangdu_LR_RangeRover_Sport_14 /* 13697477 */:
            case FinalCanbus.CAR_453_Tangdu_LR_RangeRover_Sport_17 /* 13763013 */:
            case FinalCanbus.CAR_453_Tangdu_LR_RangeRover_Sport /* 13828549 */:
            case FinalCanbus.CAR_453_Tangdu_LR_Evoque_12 /* 13894085 */:
            case FinalCanbus.CAR_453_Tangdu_LR_Evoque_13 /* 13959621 */:
            case FinalCanbus.CAR_453_Tangdu_LR_Evoque_16 /* 14025157 */:
            case FinalCanbus.CAR_453_Tangdu_LR_Evoque_17 /* 14090693 */:
            case FinalCanbus.CAR_453_Tangdu_LR_Evoque /* 14156229 */:
            case FinalCanbus.CAR_453_Tangdu_LR_Velar /* 14221765 */:
            case FinalCanbus.CAR_453_Tangdu_LR_Discovery4_10 /* 14287301 */:
            case FinalCanbus.CAR_453_Tangdu_LR_Discovery4 /* 14352837 */:
            case FinalCanbus.CAR_453_Tangdu_LR_Discovery5 /* 14418373 */:
            case FinalCanbus.CAR_453_Tangdu_LR_Discovery_Sport_15 /* 14483909 */:
            case FinalCanbus.CAR_453_Tangdu_LR_Discovery_Sport_17 /* 14549445 */:
            case FinalCanbus.CAR_453_Tangdu_LR_Discovery_Sport /* 14614981 */:
            case FinalCanbus.CAR_453_Tangdu_LR_Defender /* 14680517 */:
            case FinalCanbus.CAR_453_Tangdu_LR_Freelander /* 14746053 */:
            case FinalCanbus.CAR_453_Tangdu_LR_Freelander2 /* 14811589 */:
            case FinalCanbus.CAR_453_Tangdu_Jaguar_XEXFL /* 14877125 */:
            case FinalCanbus.CAR_453_Tangdu_Jaguar_XFXFL /* 14942661 */:
            case FinalCanbus.CAR_453_Tangdu_Jaguar_F_PACE /* 15008197 */:
            case FinalCanbus.CAR_453_Tangdu_Jaguar_I_TYPE /* 15073733 */:
            case FinalCanbus.CAR_453_Tangdu_Jaguar_F_TYPE /* 15139269 */:
            case FinalCanbus.CAR_453_Tangdu_Jaguar_E_PACE /* 15204805 */:
            case FinalCanbus.CAR_453_Tangdu_Jaguar_XJXJL_12 /* 15270341 */:
            case FinalCanbus.CAR_453_Tangdu_Jaguar_XJXJL_14 /* 15335877 */:
            case FinalCanbus.CAR_453_Tangdu_Jaguar_XJXJL_16 /* 15401413 */:
            case FinalCanbus.CAR_453_Tangdu_Jaguar_XJXJL /* 15466949 */:
                cls = TDLandRoverIndexAct.class;
                break;
            case FinalCanbus.CAR_453_XC_Honda_Acura_RL /* 12452293 */:
            case FinalCanbus.CAR_452_XC_Honda_Acura_TL /* 12911044 */:
            case FinalCanbus.CAR_452_XC_Honda_Acura_RDX /* 12976580 */:
            case FinalCanbus.CAR_452_XC_Honda_Acura_TLX /* 13042116 */:
                cls = XCHondaAmpCarSet.class;
                break;
            case FinalCanbus.CAR_452_OD_Qirui_Xiaomayi /* 12517828 */:
                cls = ODQiruiXiaomayiCarInfo.class;
                break;
            case FinalCanbus.CAR_452_OD_Ford_Lincoln_navigator /* 12583364 */:
                cls = ODFordNavigatorCarSet.class;
                break;
            case FinalCanbus.CAR_452_LZ_Toyato_RX450 /* 12648900 */:
                if (readFile("/sys/fytver/fyt_bin_version").contains("Ls18") || readFile("/sys/fytver/fyt_bin_version").contains("Lt18")) {
                    cls = LZNewAllBBASetFunc.class;
                    break;
                } else {
                    cls = CamryIndexAct_LuZ.class;
                    break;
                }
            case FinalCanbus.CAR_439_LZ_INFINIT_FX35 /* 12714423 */:
                cls = LuzInfinitF35IndexAct.class;
                break;
            case FinalCanbus.CAR_453_OD_Dongfeng_Chenglong_H7 /* 12714437 */:
                cls = ODDongfengChenglongH7CarSet.class;
                break;
            case FinalCanbus.CAR_439_DJ_Nissan /* 12779959 */:
            case FinalCanbus.CAR_439_DJ_Nissan_H /* 12845495 */:
                cls = djTianlaiIndexAct.class;
                break;
            case FinalCanbus.CAR_453_OD_BQ_BJ30_21 /* 12845509 */:
                cls = ODBeiqiBJ30CarSet.class;
                break;
            case FinalCanbus.CAR_453_OD_BQ_BJ90 /* 12911045 */:
                cls = ODBeiqiBJ90CarSet.class;
                break;
            case FinalCanbus.CAR_453_OD_RENAUL_KOLEOS_05 /* 12976581 */:
                cls = ActivityODRenaultKeleosCD.class;
                break;
            case FinalCanbus.CAR_439_OUDI_Falcon_New_Single /* 13042103 */:
            case FinalCanbus.CAR_439_OUDI_Falcon_New_Double /* 13107639 */:
            case FinalCanbus.CAR_439_OUDI_Territory_New_Single /* 13173175 */:
            case FinalCanbus.CAR_439_OUDI_Territory_New_Double /* 13238711 */:
            case FinalCanbus.CAR_439_OUDI_Territory_Old_Single /* 13304247 */:
            case FinalCanbus.CAR_439_OUDI_Territory_Old_Double /* 13369783 */:
            case FinalCanbus.CAR_439_OUDI_Falcon_Old_Single /* 13435319 */:
            case FinalCanbus.CAR_439_OUDI_Falcon_Old_Double /* 13500855 */:
                cls = FordFalconIndexAct.class;
                break;
            case FinalCanbus.CAR_452_OD_LeiDing_Mangguo_L /* 13107652 */:
            case FinalCanbus.CAR_452_OD_LeiDing_Mangguo_H /* 13173188 */:
                cls = ODLeTinMangguoCarSet.class;
                break;
            case FinalCanbus.CAR_454_RDW_BENZ_ML350_08_T1 /* 13173190 */:
            case FinalCanbus.CAR_454_RDW_BENZ_ML350_08_T2 /* 13238726 */:
            case FinalCanbus.CAR_454_RDW_BENZ_R350_08_T1 /* 13304262 */:
            case FinalCanbus.CAR_454_RDW_BENZ_R350_08_T2 /* 13369798 */:
            case FinalCanbus.CAR_454_RDW_BENZ_ML350_12 /* 13435334 */:
            case FinalCanbus.CAR_454_RDW_BENZ_GL450_08 /* 13500870 */:
            case FinalCanbus.CAR_454_RDW_BENZ_GL_12 /* 13566406 */:
                cls = RDWBenzSetFunc.class;
                break;
            case FinalCanbus.CAR_452_LZ_Benz_Smart /* 13435332 */:
                cls = LZBenzSmartSetFunc.class;
                break;
            case FinalCanbus.CAR_443_WC2_Jili_GS_18 /* 13631931 */:
            case FinalCanbus.CAR_443_WC2_Jili_GL_18 /* 13697467 */:
            case FinalCanbus.CAR_443_WC2_Jili_Boyue_18 /* 13763003 */:
            case FinalCanbus.CAR_443_WC2_Jili_Boyue_20 /* 13828539 */:
            case FinalCanbus.CAR_443_WC2_Jili_Dihao_22 /* 13894075 */:
            case FinalCanbus.CAR_443_WC2_Jili_Binyue_22 /* 13959611 */:
            case FinalCanbus.CAR_443_WC2_Jili_All /* 14025147 */:
                cls = WCJiliAllCarSet.class;
                break;
            case FinalCanbus.CAR_452_LZ_Volvo_10 /* 13631940 */:
                if (LauncherApplication.getConfiguration() == 1) {
                    cls = SanlinIndexAct.class;
                    break;
                } else {
                    cls = LuzVolvoCarSet.class;
                    break;
                }
            case FinalCanbus.CAR_452_RZC_Mangguo_LeiDing /* 13697476 */:
                cls = RZCLeTinMangguoCarSet.class;
                break;
            case FinalCanbus.CAR_439_DJ_Rongwei_i5 /* 13959607 */:
            case FinalCanbus.CAR_439_DJ_Rongwei_i5_H /* 14025143 */:
                cls = ActDaojunRongweI5CarSet.class;
                break;
            case FinalCanbus.CAR_454_XP_ZH2_Pilotcar /* 13959622 */:
                cls = ZH2PilotcarCarinfoAct.class;
                break;
            case FinalCanbus.CAR_452_OD_Changcheng_Oula /* 14156228 */:
                cls = ODChangChengOulaCarInfo.class;
                break;
            case FinalCanbus.CAR_452_KYC_Toyota_Landekuluze /* 14221764 */:
            case FinalCanbus.CAR_452_KYC_Toyota_Runner /* 14287300 */:
            case FinalCanbus.CAR_452_KYC_Toyota_Alpha /* 14352836 */:
                cls = KYCToyotaAllCarSet.class;
                break;
            case FinalCanbus.CAR_454_OD_ChangAn_Raeton /* 14352838 */:
            case FinalCanbus.CAR_454_OD_ChangAn_Raeton_H /* 14418374 */:
                cls = ODChangAnRaetonCarSet.class;
                break;
            case FinalCanbus.CAR_439_DJ_BYD_M6 /* 14418359 */:
                cls = DaojunBydM6SetFunc.class;
                break;
            case FinalCanbus.CAR_XP1_Daojun_Toyota_PREVIA /* 14746052 */:
                cls = DaojunPreviaCarSet.class;
                break;
            case FinalCanbus.CAR_452_Luz_Audi_A4L_Low /* 14811588 */:
            case FinalCanbus.CAR_452_Luz_Audi_A4L_H /* 14877124 */:
            case FinalCanbus.CAR_452_Luz_Audi_Q5_Low /* 14942660 */:
            case FinalCanbus.CAR_452_Luz_Audi_Q5_H /* 15008196 */:
            case FinalCanbus.CAR_452_Luz_Audi_A6L_Low /* 15073732 */:
            case FinalCanbus.CAR_452_Luz_Audi_A6L_H /* 15139268 */:
            case FinalCanbus.CAR_452_Luz_Audi_Q7_Low /* 15204804 */:
            case FinalCanbus.CAR_452_Luz_Audi_Q7_H /* 15270340 */:
                cls = LZAudiQ5CarSet.class;
                break;
            case FinalCanbus.CAR_439_LUZ_BMW_MINI /* 15270327 */:
                cls = LZBMWMiniCarSet.class;
                break;
            case FinalCanbus.CAR_454_OD_Sanlin_Pajero_18 /* 15335878 */:
            case FinalCanbus.CAR_454_OD_Sanlin_LC200_23 /* 15401414 */:
                cls = ODSanlinCarSet.class;
                break;
            case FinalCanbus.CAR_439_XC_Xiandai_Suolantuo_Amp /* 15466935 */:
                cls = XCXiandaiSuolataCarSet.class;
                break;
            case FinalCanbus.CAR_453_LZ_Teana_08_L /* 15532485 */:
            case FinalCanbus.CAR_453_LZ_Teana_08_H /* 15598021 */:
            case FinalCanbus.CAR_453_LZ_Teana_08_TW /* 15663557 */:
                cls = LZ_Nissan08TeanaIndexAct.class;
                break;
            case FinalCanbus.CAR_453_LZ_Honda_Civic_06 /* 15729093 */:
            case FinalCanbus.CAR_453_LZ_Honda_Civic_06_H /* 15794629 */:
                cls = LZHonda06CivicCarInfo.class;
                break;
            case FinalCanbus.CAR_439_DJ_Qirui_Airuizhe5 /* 15860151 */:
            case FinalCanbus.CAR_439_DJ_Qirui_Airuizhe7 /* 15925687 */:
            case FinalCanbus.CAR_439_DJ_Qirui_A3 /* 15991223 */:
                cls = DaojunQiruiCarSet.class;
                break;
            case FinalCanbus.CAR_453_RZC_VinFast_PLUS_23 /* 15860165 */:
                cls = SanlinIndexAct.class;
                break;
            case FinalCanbus.CAR_439_OD_Opel_Adan_CD /* 16056759 */:
                cls = ODOpelAdanIndexActi.class;
                break;
            case FinalCanbus.CAR_453_XC_Ford_EDGE_L /* 16122309 */:
            case FinalCanbus.CAR_453_XC_Ford_EDGE_H /* 16187845 */:
                cls = XCFordEDGECarSet.class;
                break;
            case FinalCanbus.CAR_453_RZC_Suzuki_IGNIS_16 /* 16253381 */:
                cls = RZCSuzukiIndexActi.class;
                break;
            case FinalCanbus.CAR_439_BNR_HAVAL_H8 /* 16318903 */:
            case FinalCanbus.CAR_439_BNR_HAVAL_H9 /* 16384439 */:
                cls = RZC_Oudi_0439_HavalH9_IndexAct.class;
                break;
            case FinalCanbus.CAR_453_OD_Modernin /* 16384453 */:
                cls = ODModerninIndexAct.class;
                break;
            case FinalCanbus.CAR_439_OD_BMW_ALL /* 16646583 */:
                cls = ODBMWCarInfo.class;
                break;
        }
            
        if (cls != null) {
            boolean userStats = mPrefs.getBoolean("user_stats", false);
            boolean userLayout = mPrefs.getBoolean("user_layout", false);
            SharedPreferences.Editor editor = mPrefs.edit();
            editor.putString("canbus_class", String.valueOf(cls));
            editor.apply();
            if (userLayout && userStats) {
                if (DataCanbus.DATA[1000] == 76 || DataCanbus.DATA[1000] == 67) {
                    if (DataCanbus.DATA[11] != 13 && DataCanbus.DATA[11] != 14 && FinalShare.CUSTOMER_ID != 31) {
                        FuncMain.tips(this.mContext.getString(R.string.vehicle_not_exist));
                        return;
                    } else {
                        startCanbusService();
                        return;
                    }
                }
                startCanbusService();
            }
        }
    }

    public void startCanbusService() {
        Intent intent = new Intent(this.mContext, CanbusService.class);
        Bundle extras = new Bundle();
        extras.putInt("fuel", Integer.parseInt(mPrefs.getString("fuel_code_int", "0")));
        extras.putInt("range", Integer.parseInt(mPrefs.getString("range_code_int", "0")));
        extras.putInt("rpm", Integer.parseInt(mPrefs.getString("rpm_code_int", "0")));
        extras.putInt("cmdInt", Integer.parseInt(mPrefs.getString("cmdInt_code_int", "0")));
        extras.putInt("cmdArr", Integer.parseInt(mPrefs.getString("cmdArr_code_int", "0")));
        intent.putExtras(extras);
        this.mContext.startService(intent);
    }
    
    private String readFile(String path) {
        String strInfo = "";
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuffer sb = new StringBuffer();
            while (true) {
                String str = br.readLine();
                if (str != null) {
                    sb.append(String.valueOf(str) + "\n");
                } else {
                    br.close();
                    strInfo = sb.toString();
                    return strInfo;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return strInfo;
        }
    }
}