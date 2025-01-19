package com.syu.ui.air;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;

import com.syu.canbus.JumpPage;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.air.Air_Activity_All_Toyota_prado_HP;
import com.syu.carinfo.air.ConstAllAirDara;
import com.syu.carinfo.lz.lexusis.KYCLexusFrontAirControlAct;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.util.HandlerUI;
import com.syu.util.SecondTickThread;

public class AirHelper implements Runnable {
    public static boolean sDisableAirWindowLocal;
    private int mTick;
    private PopupWindow mWindow;
    private static final AirHelper INSTANCE = new AirHelper();
    public static int sAirWindowEnable = 1;
    public static boolean sFlagShowAirWindow = true;
    public static final IUiNotify SHOW_AND_REFRESH = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (AirHelper.sFlagShowAirWindow) {
                if (DataCanbus.DATA[1000] == 589841 || DataCanbus.DATA[1000] == 720913 || DataCanbus.DATA[1000] == 655377 || DataCanbus.DATA[1000] == 786449 || DataCanbus.DATA[1000] == 851985 || DataCanbus.DATA[1000] == 917521 || DataCanbus.DATA[1000] == 983057 || DataCanbus.DATA[1000] == 1048593 || DataCanbus.DATA[1000] == 1114129 || DataCanbus.DATA[1000] == 1179665 || DataCanbus.DATA[1000] == 1245201 || DataCanbus.DATA[1000] == 1310737 || DataCanbus.DATA[1000] == 1376273 || DataCanbus.DATA[1000] == 1441809 || DataCanbus.DATA[1000] == 1507345 || DataCanbus.DATA[1000] == 1572881 || DataCanbus.DATA[1000] == 1638417 || DataCanbus.DATA[1000] == 1703953 || DataCanbus.DATA[1000] == 1769489 || DataCanbus.DATA[1000] == 1835025 || DataCanbus.DATA[1000] == 1900561 || DataCanbus.DATA[1000] == 1966097 || DataCanbus.DATA[1000] == 2031633 || DataCanbus.DATA[1000] == 2097169 || DataCanbus.DATA[1000] == 2162705 || DataCanbus.DATA[1000] == 2228241 || DataCanbus.DATA[1000] == 2293777 || DataCanbus.DATA[1000] == 2359313 || DataCanbus.DATA[1000] == 2424849 || DataCanbus.DATA[1000] == 2490385 || DataCanbus.DATA[1000] == 2555921 || DataCanbus.DATA[1000] == 2621457 || DataCanbus.DATA[1000] == 2686993 || DataCanbus.DATA[1000] == 2752529 || DataCanbus.DATA[1000] == 2818065) {
                    switch (updateCode) {
                        case 158:
                            if (DataCanbus.DATA[158] == 1) {
                                AirHelper.getInstance().showAndRefresh();
                                break;
                            }
                        default:
                            AirHelper.getInstance().showAndRefresh();
                            break;
                    }
                    return;
                }
                if (DataCanbus.DATA[1000] == 590253 || DataCanbus.DATA[1000] == 655789 || DataCanbus.DATA[1000] == 721325 || DataCanbus.DATA[1000] == 786861) {
                    switch (updateCode) {
                        case 14:
                            AirHelper.getInstance().showAndRefresh();
                            break;
                        default:
                            if (DataCanbus.DATA[14] == 0) {
                                AirHelper.getInstance().showAndRefresh();
                                break;
                            } else if (DataCanbus.DATA[14] == 1) {
                                if (updateCode == 23 || updateCode == 24) {
                                    AirHelper.getInstance().showAndRefresh();
                                    break;
                                }
                            }
                            break;
                    }
                    return;
                }
                if (DataCanbus.DATA[1000] == 6357445 || DataCanbus.DATA[1000] == 6422981 || DataCanbus.DATA[1000] == 6488517 || DataCanbus.DATA[1000] == 6554053 || DataCanbus.DATA[1000] == 6619589 || DataCanbus.DATA[1000] == 6685125 || DataCanbus.DATA[1000] == 6750661 || DataCanbus.DATA[1000] == 6816197) {
                    switch (updateCode) {
                        case 13:
                            AirHelper.getInstance().showAndRefresh();
                            break;
                        default:
                            if (DataCanbus.DATA[13] == 0) {
                                AirHelper.getInstance().showAndRefresh();
                                break;
                            } else if (DataCanbus.DATA[13] == 1) {
                                if (updateCode == 27 || updateCode == 28) {
                                    AirHelper.getInstance().showAndRefresh();
                                    break;
                                }
                            }
                            break;
                    }
                    return;
                }
                if (AirHelper.IsNewAirContl()) {
                    switch (updateCode) {
                        case 13:
                            AirHelper.getInstance().showAndRefresh();
                            break;
                        default:
                            if (DataCanbus.DATA[13] == 0) {
                                AirHelper.getInstance().showAndRefresh();
                                break;
                            } else if (DataCanbus.DATA[13] == 1) {
                                if (updateCode == 27 || updateCode == 28) {
                                    AirHelper.getInstance().showAndRefresh();
                                    break;
                                }
                            }
                            break;
                    }
                    return;
                }
                if (DataCanbus.DATA[1000] == 12124612) {
                    switch (updateCode) {
                        case 5:
                            AirHelper.getInstance().showAndRefresh();
                            break;
                        default:
                            if (DataCanbus.DATA[5] == 0) {
                                AirHelper.getInstance().showAndRefresh();
                                break;
                            } else if (DataCanbus.DATA[5] == 1) {
                                if (updateCode == 13 || updateCode == 14) {
                                    AirHelper.getInstance().showAndRefresh();
                                    break;
                                }
                            }
                            break;
                    }
                    return;
                }
                if (DataCanbus.DATA[1000] == 2490807 || DataCanbus.DATA[1000] == 2556343) {
                    switch (updateCode) {
                        case 14:
                            AirHelper.getInstance().showAndRefresh();
                            break;
                        default:
                            if (DataCanbus.DATA[14] == 0) {
                                AirHelper.getInstance().showAndRefresh();
                                break;
                            } else if (DataCanbus.DATA[14] == 1) {
                                if (updateCode == 22 || updateCode == 23) {
                                    AirHelper.getInstance().showAndRefresh();
                                    break;
                                }
                            }
                            break;
                    }
                    return;
                }
                if ((DataCanbus.DATA[1000] & 65535) == 320) {
                    switch (updateCode) {
                        case 4:
                            AirHelper.getInstance().showAndRefresh();
                            break;
                        default:
                            if (DataCanbus.DATA[4] == 0) {
                                AirHelper.getInstance().showAndRefresh();
                                break;
                            } else if (DataCanbus.DATA[4] == 1) {
                                if (updateCode == 27 || updateCode == 68) {
                                    AirHelper.getInstance().showAndRefresh();
                                    break;
                                }
                            }
                            break;
                    }
                    return;
                }
                if ((DataCanbus.DATA[1000] & 65535) == 355) {
                    switch (updateCode) {
                        case 1:
                            AirHelper.getInstance().showAndRefresh();
                            break;
                        default:
                            if (DataCanbus.DATA[1] == 0) {
                                AirHelper.getInstance().showAndRefresh();
                                break;
                            } else if (DataCanbus.DATA[1] == 1) {
                                if (updateCode == 5 || updateCode == 11) {
                                    AirHelper.getInstance().showAndRefresh();
                                    break;
                                }
                            }
                            break;
                    }
                    return;
                }
                if ((DataCanbus.DATA[1000] & 65535) == 244) {
                    switch (updateCode) {
                        case 13:
                            AirHelper.getInstance().showAndRefresh();
                            break;
                        default:
                            if (DataCanbus.DATA[13] == 0) {
                                AirHelper.getInstance().showAndRefresh();
                                break;
                            } else if (DataCanbus.DATA[13] == 1) {
                                if (updateCode == 27 || updateCode == 28) {
                                    AirHelper.getInstance().showAndRefresh();
                                    break;
                                }
                            }
                            break;
                    }
                    return;
                }
                if ((DataCanbus.DATA[1000] & 65535) == 298) {
                    switch (updateCode) {
                        case 20:
                            AirHelper.getInstance().showAndRefresh();
                            break;
                        default:
                            if (DataCanbus.DATA[20] == 0) {
                                AirHelper.getInstance().showAndRefresh();
                                break;
                            } else if (DataCanbus.DATA[20] == 1) {
                                if (updateCode == 25 || updateCode == 31 || updateCode == 30 || updateCode == 21 || updateCode == 22 || updateCode == 23 || updateCode == 26 || updateCode == 27 || updateCode == 28) {
                                    AirHelper.getInstance().showAndRefresh();
                                    break;
                                }
                            }
                            break;
                    }
                    return;
                }
                if (DataCanbus.DATA[1000] == 10420663 || DataCanbus.DATA[1000] == 10486199 || DataCanbus.DATA[1000] == 15794628 || DataCanbus.DATA[1000] == 15860164 || DataCanbus.DATA[1000] == 15925700 || DataCanbus.DATA[1000] == 15991236 || DataCanbus.DATA[1000] == 16056772) {
                    switch (updateCode) {
                        case 14:
                            AirHelper.getInstance().showAndRefresh();
                            break;
                        default:
                            if (DataCanbus.DATA[14] == 0) {
                                AirHelper.getInstance().showAndRefresh();
                                break;
                            } else if (DataCanbus.DATA[14] == 1) {
                                if (updateCode == 22 || updateCode == 23) {
                                    AirHelper.getInstance().showAndRefresh();
                                    break;
                                }
                            }
                            break;
                    }
                    return;
                }
                if (DataCanbus.DATA[1000] == 31 || DataCanbus.DATA[1000] == 65567 || DataCanbus.DATA[1000] == 131103) {
                    switch (updateCode) {
                        case 3:
                            AirHelper.getInstance().showAndRefresh();
                            break;
                        case 19:
                            if (DataCanbus.DATA[19] == 1) {
                                AirHelper.getInstance().showAndRefresh();
                                break;
                            }
                        default:
                            if (DataCanbus.DATA[3] == 0) {
                                AirHelper.getInstance().showAndRefresh();
                                break;
                            } else if (DataCanbus.DATA[3] == 1) {
                                if (updateCode == 10 || updateCode == 11) {
                                    AirHelper.getInstance().showAndRefresh();
                                    break;
                                }
                            }
                            break;
                    }
                    return;
                }
                if ((DataCanbus.DATA[1000] & 65535) == 395) {
                    switch (updateCode) {
                        case 25:
                            AirHelper.getInstance().showAndRefresh();
                            break;
                        default:
                            if (DataCanbus.DATA[25] == 0) {
                                AirHelper.getInstance().showAndRefresh();
                                break;
                            } else if (DataCanbus.DATA[25] == 1) {
                                if (updateCode == 40 || updateCode == 68) {
                                    AirHelper.getInstance().showAndRefresh();
                                    break;
                                }
                            }
                            break;
                    }
                    return;
                }
                AirHelper.getInstance().showAndRefresh();
            }
        }
    };
    public static final IUiNotify REFRESH_ON_SHOW = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            AirHelper.getInstance().refreshOnShow();
        }
    };
    private final Runnable mHideWindow = new Runnable() { 
        @Override
        public void run() {
            AirHelper.this.mWindow.dismiss();
        }
    };
    int[] idAirShowInPortMode = {40, 22, 48, FinalCanbus.CAR_BNR_Yihu2012, FinalCanbus.CAR_BNR_Yihu2012_H, FinalCanbus.CAR_BNR_Yihu2012_H, 36, FinalCanbus.CAR_WC2_GM_WLD, 319, 14, 49, 115, 293, 70, FinalCanbus.CAR_RZC_XP1_17CHANGANCS75, 128, FinalCanbus.CAR_WC2_CHANGAN_17CS75, FinalCanbus.CAR_XP1_CRV2012_BNR, 298, 142, FinalCanbus.CAR_RZC_Ecosport, 334, FinalCanbus.CAR_RZC_XP1_Focus2015_Air, FinalCanbus.CAR_RCW_XP1_Focus2015, FinalCanbus.CAR_RZC_LHT_Ford_F150_Auto, FinalCanbus.CAR_RZC_Ford_Lincoln_navigator, FinalCanbus.CAR_RZC_NewFiestar, FinalCanbus.CAR_XC_RZC_NewFiestar, 61, FinalCanbus.CAR_RZC_XP1_GM_1, FinalCanbus.CAR_RZC_XP1_GM_2, FinalCanbus.CAR_RZC_XP1_GM_3, FinalCanbus.CAR_RZC_XP1_GM_3_20, 263, 255, FinalCanbus.CAR_RZC_FengShenAX5, FinalCanbus.CAR_RZC_FengShenA60, 254, 280, 257, FinalCanbus.CAR_DJ_ChuanQiGA6_M, FinalCanbus.CAR_DJ_ChuanQiGA6_H, 308, FinalCanbus.CAR_RZC_DaZhong_H, 51, FinalCanbus.CAR_WC2_GUOCHAN_9, 240, 289, FinalCanbus.CAR_WC2_ChuanQiGS4_M, FinalCanbus.CAR_WC2_ChuanQiGS4_H, FinalCanbus.CAR_WC2_17ChuanQiGS4, 367, FinalCanbus.CAR_XP1_16_TuSheng_H, 404, FinalCanbus.CAR_WC_16_QiYaLINGDONG, 1, 300, 98, FinalCanbus.CAR_WC2_GUOCHAN_2, FinalCanbus.CAR_WC2_RUIFENG_M4, 297, FinalCanbus.CAR_WC2_15_CRV_L, 76, 173, 137, FinalCanbus.CAR_RZC3_XiandaiIX35_H, 31, FinalCanbus.CAR_XP1_XiandaiIX45_M, FinalCanbus.CAR_XP1_XiandaiIX45_H, FinalCanbus.CAR_RZC_FLB_SaiOu3, 366, 432, FinalCanbus.CAR_432_HZ_B200, 394, 17, FinalCanbus.CAR_WC2_MQB, FinalCanbus.CAR_WC2_MQB_AllView, FinalCanbus.CAR_WC2_MQB_Hybrid, 45, 274, FinalCanbus.CAR_DJ_XP1_ACCORD7_H, 106, 157, FinalCanbus.CAR_RZC_XP1_RongWei_RX5_NoInternet, FinalCanbus.CAR_RZC_XP1_Mingjue_17RuiTeng, 256, FinalCanbus.CAR_SBD_WC1_ChuanQi_GS4, FinalCanbus.CAR_XP1_DaZhong_Turui, FinalCanbus.CAR_WC2_DaZhong_TuRui, FinalCanbus.CAR_WC2_GUOCHAN_14, FinalCanbus.CAR_BNR_HuaTai_ShengDaFei, 6, FinalCanbus.CAR_BYD_F3_ShuRui, FinalCanbus.CAR_CYT_ShuPing_BYDF3_SuRui, FinalCanbus.CAR_DJ_XP1_ParkAvenue, FinalCanbus.CAR_RZC_BENZ_MLSERIES_Portrait, FinalCanbus.CAR_WC2_MingJueZS, 160, FinalCanbus.CAR2_RZC_XP1_DaZhong_GaoErFu7_H, 151, FinalCanbus.CAR_DAOJUN_XP1_BYDSurui, 417, FinalCanbus.CAR_439_BNR_YUSHENG_S350, FinalCanbus.CAR_443_WC2_SgmwS, FinalCanbus.CAR_443_WC2_KangDi, FinalCanbus.CAR_WC2_GUOCHAN_10, 419, FinalCanbus.CAR_WC2_FengShenAX5, FinalCanbus.CAR_WC2_16FengShenAX7, FinalCanbus.CAR_WC2_16FengShenAX7_L, FinalCanbus.CAR_DJ_Saiou3, FinalCanbus.CAR_RZC1_MZD3_5_H, FinalCanbus.CAR_RZC1_LZ_MZD3_5_H, FinalCanbus.CAR_439_DJ_MAZIDA6, FinalCanbus.CAR_439_OuDi_Haval_H9, FinalCanbus.CAR_439_OuDi_Haval_H9_H, FinalCanbus.CAR_439_OuDi_Haval_H9_RS, FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS, FinalCanbus.CAR_452_OD_Haval_VV5, FinalCanbus.CAR_452_OD_Haval_VV6, FinalCanbus.CAR_452_OD_Haval_VV7, FinalCanbus.CAR_452_OD_Haval_VV5_H, FinalCanbus.CAR_452_OD_Haval_VV6_H, FinalCanbus.CAR_452_OD_Haval_VV7_H, FinalCanbus.CAR_RZC_Haval_H9, FinalCanbus.CAR_452_RZC_Haval_H9_Low, FinalCanbus.CAR_RZC_Haval_H9_H, FinalCanbus.CAR_439_AY_BYD_SURUI, FinalCanbus.CAR_WC2_JiLiYuanJing, FinalCanbus.CAR_439_RZC_JiangHuai_ALL, FinalCanbus.CAR_439_RZC_JiangHuai_ALL_H, FinalCanbus.CAR_WC2_PSAALL_10, 307, FinalCanbus.CAR_443_WC2_Tianlai08_12, FinalCanbus.CAR_439_RZC_ZhongTaiSR7, FinalCanbus.CAR_439_RZC_ZhongTaiSR9, FinalCanbus.CAR_439_RZC_ZhongTaiSR9_H, FinalCanbus.CAR_439_HCY_BYD_E6_H, 9, 413, 132, FinalCanbus.CAR_WC2_HavalH2_H, FinalCanbus.CAR_439_RZC_BenzAll_H, FinalCanbus.CAR_RZC_XP1_17X80_L, FinalCanbus.CAR_RZC_XP1_17X80_H, 413, FinalCanbus.CAR_RZC_FengShenAX7_18, FinalCanbus.CAR_RZC_FengShenAX7_18H, FinalCanbus.CAR_RZC_XP1_YuanJingX6, FinalCanbus.CAR_RZC_ALL_GM_SP_5, FinalCanbus.CAR_RZC_ALL_GM_SP_6, FinalCanbus.CAR_RZC_ALL_GM_SP_7, FinalCanbus.CAR_RZC_ALL_GM_SP_8, FinalCanbus.CAR_RZC_ALL_GM_SP_9, FinalCanbus.CAR_RZC_ALL_GM_SP_10, FinalCanbus.CAR_RZC_ALL_GM_SP_11, FinalCanbus.CAR_RZC_ALL_GM_SP_12, FinalCanbus.CAR_RZC_ALL_GM_SP_13, FinalCanbus.CAR_RZC_ALL_GM_SP_14, FinalCanbus.CAR_RZC_ALL_GM_SP_15, FinalCanbus.CAR_RZC_ALL_GM_SP_16, FinalCanbus.CAR_RZC_ALL_GM_SP_17, FinalCanbus.CAR_RZC_ALL_GM_SP_18, FinalCanbus.CAR_RZC_ALL_GM_SP_19, FinalCanbus.CAR_RZC_ALL_GM_SP_20, FinalCanbus.CAR_RZC_ALL_GM_SP_21, FinalCanbus.CAR_RZC_ALL_GM_SP_22, FinalCanbus.CAR_RZC_ALL_GM_SP_23, FinalCanbus.CAR_RZC_ALL_GM_SP_24, FinalCanbus.CAR_RZC_ALL_GM_SP_25, FinalCanbus.CAR_RZC_ALL_GM_SP_26, FinalCanbus.CAR_RZC_ALL_GM_SP_27, FinalCanbus.CAR_RZC_ALL_GM_SP_28, FinalCanbus.CAR_RZC_ALL_GM_SP_29, FinalCanbus.CAR_RZC_ALL_GM_SP_30, FinalCanbus.CAR_RZC_ALL_GM_SP_31, FinalCanbus.CAR_RZC_ALL_GM_SP_32, FinalCanbus.CAR_RZC_ALL_GM_SP_33, FinalCanbus.CAR_RZC_ALL_GM_SP_34, FinalCanbus.CAR_RZC_ALL_GM_SP_35, 339, FinalCanbus.CAR_RZC4_PSA_ALL_M, FinalCanbus.CAR_RZC4_PSA_ALL_H, FinalCanbus.CAR_RZC_XP1_18JieTU_X70, FinalCanbus.CAR_RZC_XP1_18JieTU_X70_H, FinalCanbus.CAR_WC2_CHANGAN_19KeSai_Hand, FinalCanbus.CAR_439_OD_BenzAll, FinalCanbus.CAR_439_RCW_MZD_Ruiyi, FinalCanbus.CAR_439_OuDi_NaZhiJieU5, FinalCanbus.CAR_452_OuDi_NaZhiJieU6, FinalCanbus.CAR_439_OuDi_NaZhiJieU7, FinalCanbus.CAR_443_WC2_Nazhijie_U6, FinalCanbus.CAR_445_WC2_HaiMaM3S7, FinalCanbus.CAR_DJ_XIANDAI_Sorento, FinalCanbus.CAR_DJ_XIANDAI_Sorento_H, FinalCanbus.CAR_439_HC_Benc_C200, FinalCanbus.CAR_BNR_XP1_PsaAll, 47, FinalCanbus.CAR_RZC_CRV2012, FinalCanbus.CAR_439_OUDI_BYD_ALL, FinalCanbus.CAR_439_HCY_BYD_S6_H, FinalCanbus.CAR_RZC_ShuPing_15_Camery_AMP, FinalCanbus.CAR_RZC_ShuPing_15_Camery_AMP, FinalCanbus.CAR_RZC_ShuPing_15_Camery_AMP, FinalCanbus.CAR_BNR_ShuPing_Sonata8, FinalCanbus.CAR_BNR_ShuPing_Sonata8_AMP, FinalCanbus.CAR_BNR_ShuPing_Sonata8_AMP_KEEPAIRPANEL, FinalCanbus.CAR_RZC_DaZhong_SUP, FinalCanbus.CAR_RZC_DaZhong_SUP_H, FinalCanbus.CAR_RZC_DaZhong_SUP_M, FinalCanbus.CAR_RZC_DaZhong_MQB_SUP, FinalCanbus.CAR_RZC_DaZhong_MQB_SUP_H, FinalCanbus.CAR_443_WC2_YingFeiNiDi_14QX60_SP, FinalCanbus.CAR_439_RZC_14QiJun_Auto, FinalCanbus.CAR_439_RZC_14QiJun_Hand, FinalCanbus.CAR_RZC_ShuPing_09HighLand_L, FinalCanbus.CAR_RZC_ShuPing_09HighLand_H, FinalCanbus.CAR_BNR_18PradoHand_AirP, 412, FinalCanbus.CAR_439_HC_Nissan_XiaoKe, 290, FinalCanbus.CAR_RZC_XP1_QiChen18T70, FinalCanbus.CAR_RZC_XP1_QiChen20T70, FinalCanbus.CAR_XP_Renault_20Clio_Low, FinalCanbus.CAR_XP_Renault_20Clio_M, FinalCanbus.CAR_XP_Renault_20Clio_H, FinalCanbus.CAR_452_LUZ_SUBARU, FinalCanbus.CAR_RZC3_XianDai_Qiya_All, FinalCanbus.CAR_452_OD_Cadillac_Escalade, FinalCanbus.CAR_439_RCW_BYD_12_18Surui, FinalCanbus.CAR_439_RCW_BYD_14_15G5, FinalCanbus.CAR_439_RCW_BYD_10_15M6, FinalCanbus.CAR_439_RCW_BYD_13_17S7, FinalCanbus.CAR_439_RCW_BYD_16_19Song, FinalCanbus.CAR_439_RCW_BYD_17_19SongMax, FinalCanbus.CAR_439_RCW_BYD_12_17E6, FinalCanbus.CAR_XP_Renault_05_17Duster, FinalCanbus.CAR_RZC_XP1_15QiRuiRuiHu5, FinalCanbus.CAR_XP1_Meiganna4_TR_HAND, FinalCanbus.CAR_XP1_Meiganna4_TR_AUTO, FinalCanbus.CAR_XP1_Meiganna4_TR_AUTO_H, FinalCanbus.CAR_WeiChi2_18ChangChengH6, FinalCanbus.CAR_WeiChi2_18ChangChengH6_H, FinalCanbus.CAR_WC2_RENAULT_CAPTUR_19, FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V, FinalCanbus.CAR_439_XP_SUBARU_19FORESTER, FinalCanbus.CAR_439_XP_SUBARU_15_17FORESTER, FinalCanbus.CAR_439_XP_SUBARU_15_17CROSSTREK, FinalCanbus.CAR_DAOJUN_XP1_ATSL_High, FinalCanbus.CAR_DAOJUN_OD_SRX_XTS, FinalCanbus.CAR_DAOJUN_XP1_ATS_M, FinalCanbus.CAR_DAOJUN_OD_ATS, FinalCanbus.CAR_DJ_ShuPing_BYD_G6, FinalCanbus.CAR_DJ_ShuPing_BYD_G6_H, FinalCanbus.CAR_452_LZ_OUBao_Andela_CD, FinalCanbus.CAR_452_DJ_Ford_Fiesta_09_15, FinalCanbus.CAR_452_DJ_Ford_Kuga_09_15, FinalCanbus.CAR_RZC_OD_Sibalu_XV, FinalCanbus.CAR_RZC_17ZhiNanZhe, FinalCanbus.CAR_RZC_17ZhiNanZhe_H, FinalCanbus.CAR_452_WC_Honda_Yage8, FinalCanbus.CAR_439_RZC_08Tianlai_Auto, FinalCanbus.CAR_439_RZC_08Tianlai_Hand, FinalCanbus.CAR_RZC_Nissan_Tianlai_Gongjue, FinalCanbus.CAR_452_XP_Megane4_SP_L_AUTO, FinalCanbus.CAR_452_XP_Megane4_SP_H_AUTO, FinalCanbus.CAR_452_XP_Megane4_SP_L_HAND, FinalCanbus.CAR_BNR_HONDA_16Civic_NoAir, FinalCanbus.CAR_443_WC2_XianDai_All_07Shengda, 164, 167, FinalCanbus.CAR_XP_19QiYa_Sportage_M, FinalCanbus.CAR_XP_19QiYa_Sportage_H, FinalCanbus.CAR_XP_19QiYa_Sportage_L};
    int[] idShpOnlyInPortMode = {FinalCanbus.CAR_DJ_XP1_TOYOTA_06Prado_ShuPing};
    private final Runnable SHOW = new Runnable() { 
        @Override
        public void run() {
            AirHelper.this.mTick = 5;
            int i = DataCanbus.DATA[1000];
            if (AirHelper.IsNewAirContl()) {
                if (!Air_Activity_All_Toyota_prado_HP.mIsFront) {
                    ConstAllAirDara.JumpNewAir = true;
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.air.Air_Activity_All_Toyota_prado_HP");
                    return;
                }
                return;
            }
            if (DataCanbus.DATA[1000] != 6357445 && DataCanbus.DATA[1000] != 6422981 && DataCanbus.DATA[1000] != 6488517 && DataCanbus.DATA[1000] != 6554053 && DataCanbus.DATA[1000] != 6619589 && DataCanbus.DATA[1000] != 6685125 && DataCanbus.DATA[1000] != 6750661 && DataCanbus.DATA[1000] != 6816197) {
                if (!AirHelper.this.mWindow.isShowing()) {
                    LauncherApplication.addRootView(AirHelper.this.mWindow);
                    if (LauncherApplication.rootViewWindowToken() == null) {
                        HandlerUI.getInstance().postDelayed(this, 1L);
                        return;
                    } else if (LauncherApplication.getConfiguration() == 1) {
                        LauncherApplication.showWindow(AirHelper.this.mWindow, 80, 0, 0);
                    } else {
                        LauncherApplication.showWindow(AirHelper.this.mWindow, 48, 0, LauncherApplication.getScreenHeight());
                    }
                }
                View view = AirHelper.this.mWindow.getContentView();
                if (view != null) {
                    view.invalidate();
                    return;
                }
                return;
            }
            if (!KYCLexusFrontAirControlAct.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.lz.lexusis.KYCLexusFrontAirControlAct");
            }
        }
    };

    private AirHelper() {
    }

    public static AirHelper getInstance() {
        return INSTANCE;
    }

    public void initWindow(Context context) {
        if (this.mWindow == null) {
            SecondTickThread.getInstance().addTick(this);
            this.mWindow = new PopupWindow(context);
            this.mWindow.setAnimationStyle(R.style.anim_window_pack);
            this.mWindow.setWidth(-2);
            this.mWindow.setHeight(-2);
            this.mWindow.setBackgroundDrawable(new ColorDrawable(0));
            this.mWindow.setOutsideTouchable(true);
            this.mWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { 
                @Override
                public void onDismiss() {
                    //LauncherApplication.removeRootView(AirHelper.this.mWindow);
                }
            });
        }
    }

    @Override
    public void run() {
        if (this.mTick > 0) {
            this.mTick--;
            if (this.mTick == 0) {
                if (IsNewAirContl()) {
                    if (Air_Activity_All_Toyota_prado_HP.mIsFront && ConstAllAirDara.JumpNewAir && Air_Activity_All_Toyota_prado_HP.mInstance != null) {
                        Air_Activity_All_Toyota_prado_HP.mInstance.finish();
                    }
                } else if (DataCanbus.DATA[1000] == 6357445 || DataCanbus.DATA[1000] == 6422981 || DataCanbus.DATA[1000] == 6488517 || DataCanbus.DATA[1000] == 6554053 || DataCanbus.DATA[1000] == 6619589 || DataCanbus.DATA[1000] == 6685125 || DataCanbus.DATA[1000] == 6750661 || DataCanbus.DATA[1000] == 6816197) {
                    if (KYCLexusFrontAirControlAct.mIsFront && KYCLexusFrontAirControlAct.mInstance != null) {
                        KYCLexusFrontAirControlAct.mInstance.finish();
                    }
                } else {
                    HandlerUI.getInstance().post(this.mHideWindow);
                }
                if (DataCanbus.DATA[1000] == 589841 || DataCanbus.DATA[1000] == 720913 || DataCanbus.DATA[1000] == 655377 || DataCanbus.DATA[1000] == 786449 || DataCanbus.DATA[1000] == 851985 || DataCanbus.DATA[1000] == 917521 || DataCanbus.DATA[1000] == 983057 || DataCanbus.DATA[1000] == 1048593 || DataCanbus.DATA[1000] == 1114129 || DataCanbus.DATA[1000] == 1179665 || DataCanbus.DATA[1000] == 1245201 || DataCanbus.DATA[1000] == 1310737 || DataCanbus.DATA[1000] == 1376273 || DataCanbus.DATA[1000] == 1441809 || DataCanbus.DATA[1000] == 1507345 || DataCanbus.DATA[1000] == 1572881 || DataCanbus.DATA[1000] == 1638417 || DataCanbus.DATA[1000] == 1703953 || DataCanbus.DATA[1000] == 1769489 || DataCanbus.DATA[1000] == 1835025 || DataCanbus.DATA[1000] == 1900561 || DataCanbus.DATA[1000] == 1966097 || DataCanbus.DATA[1000] == 2031633 || DataCanbus.DATA[1000] == 2097169 || DataCanbus.DATA[1000] == 2162705 || DataCanbus.DATA[1000] == 2228241 || DataCanbus.DATA[1000] == 2293777 || DataCanbus.DATA[1000] == 2359313 || DataCanbus.DATA[1000] == 2424849 || DataCanbus.DATA[1000] == 2490385 || DataCanbus.DATA[1000] == 2555921 || DataCanbus.DATA[1000] == 2621457 || DataCanbus.DATA[1000] == 2686993 || DataCanbus.DATA[1000] == 2752529 || DataCanbus.DATA[1000] == 2818065) {
                    DataCanbus.PROXY.cmd(107, new int[]{240}, null, null);
                }
            }
        }
    }

    public void hideWindow() {
        //HandlerUI.getInstance().post(this.mHideWindow);
    }

    public static void disableAirWindowLocal(boolean flag) {
        if (sDisableAirWindowLocal != flag) {
            sDisableAirWindowLocal = flag;
            calcFlagShowAirWindow();
        }
    }

    public static void airWindowEnable(int value) {
        if (sAirWindowEnable != value) {
            sAirWindowEnable = value;
            calcFlagShowAirWindow();
        }
    }

    private static void calcFlagShowAirWindow() {
        boolean flag = !sDisableAirWindowLocal && sAirWindowEnable != 0;
        if (sFlagShowAirWindow != flag) {
            sFlagShowAirWindow = flag;
            if (!flag) {
                getInstance().hideWindow();
            }
        }
    }

    public void showAndRefresh() {
        //HandlerUI.getInstance().post(this.SHOW);
    }

    static boolean IsNewAirContl() {
        if (LauncherApplication.getConfiguration() == 1) {
            return false;
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_HavalF7_20 /* 1376500 */:
            case FinalCanbus.CAR_RZC_HavalF7_19 /* 1507572 */:
            case FinalCanbus.CAR_RZC_XP1_Bingyue_19 /* 2228363 */:
            case FinalCanbus.CAR_RZC_HavalF7_19_Top /* 2228468 */:
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
                return true;
            default:
                return false;
        }
    }

    public void refreshOnShow() {
        /*View view;
        if (this.mWindow != null && this.mWindow.isShowing() && (view = this.mWindow.getContentView()) != null) {
            view.invalidate();
        }*/
    }

    public void buildUi(View view) {
        //this.mWindow.dismiss();
        //this.mWindow.setContentView(view);
    }

    public void destroyUi() {
        //this.mWindow.setContentView(null);
    }
}
