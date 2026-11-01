package com.syu.canbus.warn;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.widget.PopupWindow;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.util.HandlerUI;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WarnUtils {
    static int LocationX = 0;
    static int LocationY = 0;
    private static final Runnable SHOW = new Runnable() { // from class: com.syu.canbus.warn.WarnUtils.1
        @Override // java.lang.Runnable
        public void run() {
            PopupWindow window = WarnUtils.getWindow();
            TheApp.addRootView(window);
            if (TheApp.rootViewWindowToken() == null) {
                HandlerUI.getInstance().postDelayed(this, 1L);
            }
            if (!window.isShowing()) {
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_XP1_XiandaiIX45_M /* 65567 */:
                    case FinalCanbus.CAR_455_LZ_CG_Toyota_4Runner_Auto /* 65991 */:
                    case FinalCanbus.CAR_XP1_XiandaiIX45_H /* 131103 */:
                    case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria_H /* 393660 */:
                    case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15_YC /* 590279 */:
                    case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15H_YC /* 655815 */:
                    case FinalCanbus.CAR_355_XP_XIANDAI_19SDF_H /* 786787 */:
                    case FinalCanbus.CAR_355_XP_XIANDAI_19SDF_TOP /* 852323 */:
                    case FinalCanbus.CAR_448_6606_24Benz_Vito /* 852416 */:
                    case FinalCanbus.CAR_448_6606_24Benz_Vito_H /* 917952 */:
                    case FinalCanbus.CAR_XP_XIANDAI_ALl_H /* 983395 */:
                    case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
                    case FinalCanbus.CAR_XP_XIANDAI_ALl_TOP /* 1048931 */:
                    case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
                    case FinalCanbus.CAR_XP_XIANDAI_ALl_IX45_H /* 1114467 */:
                    case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen /* 1114567 */:
                    case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen_3 /* 1180103 */:
                    case FinalCanbus.CAR_XP_XIANDAI_19ALl_H /* 1311075 */:
                    case FinalCanbus.CAR_446_WC2_Teyes_XianDai_All_22SantaFe /* 1311166 */:
                    case FinalCanbus.CAR_RZC3_XianDai_Sorento_21 /* 1311167 */:
                    case FinalCanbus.CAR_XP_XIANDAI_19ALl_TOP /* 1376611 */:
                    case FinalCanbus.CAR_XP_18QiYaK5_M /* 1573219 */:
                    case FinalCanbus.CAR_RZC3_XianDai_AZERA_22 /* 1573311 */:
                    case FinalCanbus.CAR_XP_18QiYaK5_H /* 1638755 */:
                    case FinalCanbus.CAR_RZC3_XianDai_CRETA_22 /* 1638847 */:
                    case FinalCanbus.CAR_RZC3_XianDai_STARGAZER_22 /* 1704383 */:
                    case FinalCanbus.CAR_444_WC2_XianDai_All_15Carnival_H /* 2032060 */:
                    case FinalCanbus.CAR_446_Xiaolin_WY_LEXUS_Screen /* 2097598 */:
                    case FinalCanbus.CAR_444_WC2_XianDai_All_23NewZealand_H /* 2163132 */:
                    case FinalCanbus.CAR_XP_18KIA_carnival_H /* 2359651 */:
                    case FinalCanbus.CAR_RZC3_XianDai_HB20S_23 /* 2556351 */:
                    case FinalCanbus.CAR_RZC3_XianDai_19Palisade /* 2752959 */:
                    case FinalCanbus.CAR_RZC3_XianDai_20CARNIVAL /* 2884031 */:
                    case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra_H /* 3015100 */:
                    case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
                    case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
                    case FinalCanbus.CAR_455_LZ_YL_Toyota_Prado_14 /* 3211719 */:
                    case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
                    case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
                    case FinalCanbus.CAR_RZC3_XianDai_Qiya_23Staria /* 3539391 */:
                    case FinalCanbus.CAR_RZC3_XianDai_Qiya_23Staria_H /* 3604927 */:
                    case FinalCanbus.CAR_455_LZ_CG_Toyota_Proda_18 /* 3604935 */:
                    case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha /* 3670471 */:
                    case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha_3 /* 3736007 */:
                    case FinalCanbus.CAR_443_WC2_XianDai_All_19Shengda_H /* 3867067 */:
                    case FinalCanbus.CAR_455_LZ_CG_Toyota_Proda_23 /* 4194759 */:
                    case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha_Screen_3 /* 4587975 */:
                    case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha_3_156inch /* 4784583 */:
                    case FinalCanbus.CAR_RZC_HONDA_CRV_TW6_L /* 5374250 */:
                    case FinalCanbus.CAR_RZC_HONDA_CRV_TW6_CCD /* 5505322 */:
                    case FinalCanbus.CAR_WC2_CG_Honda_16Civic /* 5505345 */:
                    case FinalCanbus.CAR_WC2_CG_Honda_16Civic_H /* 5570881 */:
                    case FinalCanbus.CAR_444_WY_LEXUS_Screen /* 6095292 */:
                    case FinalCanbus.CAR_455_RZC_Benz_Vito_24_H /* 6488519 */:
                    case FinalCanbus.CAR_455_LZ_Daohang_Toyota_Proda_18 /* 10092999 */:
                    case FinalCanbus.CAR_455_LZ_Daohang_Toyota_Proda_23 /* 10158535 */:
                    case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH /* 10420679 */:
                    case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH_H /* 10486215 */:
                    case FinalCanbus.CAR_455_LZ_DH_Toyota_Prado_14 /* 10551751 */:
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
                    case FinalCanbus.CAR_455_OD_AiChi_U5_21_H /* 16515527 */:
                        window.showAtLocation(TheApp.getInstance().getRootView(), 83, 0, 0);
                        break;
                    case FinalCanbus.CAR_450_ZHTD_Audi /* 131522 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto /* 197052 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_P15_MC_EV /* 262588 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Auto /* 721340 */:
                    case FinalCanbus.CAR_444_WC2_DAIHATSU_All /* 786876 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_GCC /* 852412 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV1 /* 917948 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV2 /* 983484 */:
                    case FinalCanbus.CAR_RZCexc_ALFA_ROMEO_GIULIETTA_16 /* 1048615 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV3 /* 1049020 */:
                    case FinalCanbus.CAR_RZCexc_ALFA_ROMEO_159_09 /* 1114151 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_OFFROAD /* 1114556 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto2 /* 1180092 */:
                    case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto /* 1507782 */:
                    case FinalCanbus.CAR_WC2_Datong_D90_19_H /* 1769888 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Iran /* 1900988 */:
                    case FinalCanbus.CAR_455_OUDI_Aiying_BYD_ALL /* 2556359 */:
                    case FinalCanbus.CAR_RZCexc_ALFA_ROMEO_GIULIETTA_16_M /* 2752551 */:
                    case FinalCanbus.CAR_RZCexc_ALFA_ROMEO_GIULIETTA_16_H /* 2818087 */:
                    case FinalCanbus.CAR_RZCexc_ALFA_ROMEO_159_09_M /* 2883623 */:
                    case FinalCanbus.CAR_RZCexc_ALFA_ROMEO_159_09_H /* 2949159 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_ADAS /* 3080636 */:
                    case FinalCanbus.CAR_RZCexc_Feiyate_PANDA_L /* 3145767 */:
                    case FinalCanbus.CAR_RZCexc_Feiyate_PANDA_M /* 3211303 */:
                    case FinalCanbus.CAR_RZCexc_Feiyate_PANDA_H /* 3276839 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_GCC1 /* 3277244 */:
                    case FinalCanbus.CAR_RZCexc_Feiyate_PANDAEV_L /* 3342375 */:
                    case FinalCanbus.CAR_RZCexc_Feiyate_PANDAEV_M /* 3407911 */:
                    case FinalCanbus.CAR_RZCexc_Feiyate_PANDAEV_H /* 3473447 */:
                    case FinalCanbus.CAR_453_RZC_Jianghuai_S7_H /* 6095301 */:
                    case FinalCanbus.CAR_454_OD_ChangAn_Raeton_H /* 14418374 */:
                    case FinalCanbus.CAR_452_Luz_Audi_A4L_Low /* 14811588 */:
                    case FinalCanbus.CAR_452_Luz_Audi_A4L_H /* 14877124 */:
                    case FinalCanbus.CAR_452_Luz_Audi_Q5_Low /* 14942660 */:
                    case FinalCanbus.CAR_452_Luz_Audi_Q5_H /* 15008196 */:
                    case FinalCanbus.CAR_452_Luz_Audi_A6L_Low /* 15073732 */:
                    case FinalCanbus.CAR_452_Luz_Audi_A6L_H /* 15139268 */:
                    case FinalCanbus.CAR_452_Luz_Audi_Q7_Low /* 15204804 */:
                    case FinalCanbus.CAR_452_Luz_Audi_Q7_H /* 15270340 */:
                    case FinalCanbus.CAR_453_OD_Modernin /* 16384453 */:
                        window.showAtLocation(TheApp.getInstance().getRootView(), 3, 0, 0);
                        break;
                    case FinalCanbus.CAR_448_6606_Ford /* 983488 */:
                    case FinalCanbus.CAR_448_6606_Ford_CYTAIr /* 1180096 */:
                    case FinalCanbus.CAR_448_6606_Ford_CYTAIr_H /* 1245632 */:
                    case FinalCanbus.CAR_448_6606_Ford_CYTAIr_R /* 1311168 */:
                    case FinalCanbus.CAR_448_6606_Ford_CYTAIr_RH /* 1376704 */:
                    case FinalCanbus.CAR_448_6606_Ford_RANGER /* 1442240 */:
                    case FinalCanbus.CAR_448_6606_Ford_21F150_CYTAIr /* 1704384 */:
                    case FinalCanbus.CAR_448_6606_Ford_21F150_CYTAIr_H /* 1769920 */:
                    case FinalCanbus.CAR_448_6606_Ford_24F150 /* 1835456 */:
                    case FinalCanbus.CAR_448_6606_Ford_24F250 /* 1900992 */:
                    case FinalCanbus.CAR_448_6606_Ford_24F550 /* 1966528 */:
                    case FinalCanbus.CAR_448_6606_Ford_22Explorer /* 2032064 */:
                    case FinalCanbus.CAR_448_6606_Ford_24Maverick /* 2097600 */:
                    case FinalCanbus.CAR_448_6606_Ford_25Bronco_sport /* 2163136 */:
                    case FinalCanbus.CAR_455_YL_Tangdu_Toyota_LexusGX_13_CD /* 4981191 */:
                    case FinalCanbus.CAR_455_YL_Tangdu_Toyota_LexusGX_14_CD /* 5046727 */:
                    case FinalCanbus.CAR_455_YL_Tangdu_Toyota_LexusGX_13_Screen /* 16318919 */:
                    case FinalCanbus.CAR_455_YL_Tangdu_Toyota_LexusGX_14_Screen /* 16384455 */:
                        window.showAtLocation(TheApp.getInstance().getRootView(), 49, 0, 0);
                        break;
                    default:
                        window.showAtLocation(TheApp.getInstance().getRootView(), 17, WarnUtils.LocationX, WarnUtils.LocationY);
                        break;
                }
            }
        }
    };
    private static final Runnable WINDOW_HIDE = new Runnable() { // from class: com.syu.canbus.warn.WarnUtils.2
        @Override // java.lang.Runnable
        public void run() {
            PopupWindow window = WarnUtils.getWindow();
            if (window.isShowing()) {
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
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_GCC1 /* 3277244 */:
                        DataCanbus.PROXY.cmd(8, new int[]{1}, null, null);
                        DataCanbus.PROXY.cmd(8, new int[1], null, null);
                        break;
                }
                window.dismiss();
            }
        }
    };
    private static PopupWindow sPopupWindow;

    public static PopupWindow getWindow() {
        if (sPopupWindow == null) {
            Context context = TheApp.getInstance();
            PopupWindow window = new PopupWindow(context);
            window.setFocusable(true);
            window.setBackgroundDrawable(new ColorDrawable(0));
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_XP1_XiandaiIX45_M /* 65567 */:
                case FinalCanbus.CAR_XP1_XiandaiIX45_H /* 131103 */:
                case FinalCanbus.CAR_444_WC2_XianDai_All_22Staria_H /* 393660 */:
                case FinalCanbus.CAR_355_XP_XIANDAI_19SDF_H /* 786787 */:
                case FinalCanbus.CAR_355_XP_XIANDAI_19SDF_TOP /* 852323 */:
                case FinalCanbus.CAR_XP_XIANDAI_ALl_H /* 983395 */:
                case FinalCanbus.CAR_XP_XIANDAI_ALl_TOP /* 1048931 */:
                case FinalCanbus.CAR_XP_XIANDAI_ALl_IX45_H /* 1114467 */:
                case FinalCanbus.CAR_XP_XIANDAI_19ALl_H /* 1311075 */:
                case FinalCanbus.CAR_446_WC2_Teyes_XianDai_All_22SantaFe /* 1311166 */:
                case FinalCanbus.CAR_RZC3_XianDai_Sorento_21 /* 1311167 */:
                case FinalCanbus.CAR_XP_XIANDAI_19ALl_TOP /* 1376611 */:
                case FinalCanbus.CAR_XP_18QiYaK5_M /* 1573219 */:
                case FinalCanbus.CAR_RZC3_XianDai_AZERA_22 /* 1573311 */:
                case FinalCanbus.CAR_XP_18QiYaK5_H /* 1638755 */:
                case FinalCanbus.CAR_RZC3_XianDai_CRETA_22 /* 1638847 */:
                case FinalCanbus.CAR_RZC3_XianDai_STARGAZER_22 /* 1704383 */:
                case FinalCanbus.CAR_444_WC2_XianDai_All_15Carnival_H /* 2032060 */:
                case FinalCanbus.CAR_444_WC2_XianDai_All_23NewZealand_H /* 2163132 */:
                case FinalCanbus.CAR_XP_18KIA_carnival_H /* 2359651 */:
                case FinalCanbus.CAR_RZC3_XianDai_HB20S_23 /* 2556351 */:
                case FinalCanbus.CAR_RZC3_XianDai_19Palisade /* 2752959 */:
                case FinalCanbus.CAR_RZC3_XianDai_20CARNIVAL /* 2884031 */:
                case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra_H /* 3015100 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_23Staria /* 3539391 */:
                case FinalCanbus.CAR_RZC3_XianDai_Qiya_23Staria_H /* 3604927 */:
                case FinalCanbus.CAR_443_WC2_XianDai_All_19Shengda_H /* 3867067 */:
                case FinalCanbus.CAR_RZC_HONDA_CRV_TW6_L /* 5374250 */:
                case FinalCanbus.CAR_RZC_HONDA_CRV_TW6_CCD /* 5505322 */:
                case FinalCanbus.CAR_455_RZC_Benz_Vito_24_H /* 6488519 */:
                case FinalCanbus.CAR_455_OD_AiChi_U5_21_H /* 16515527 */:
                    window.setWidth(TheApp.getScreenWidth());
                    window.setHeight(TheApp.getScreenHeight() - 60);
                    break;
                case FinalCanbus.CAR_455_LZ_CG_Toyota_4Runner_Auto /* 65991 */:
                case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15_YC /* 590279 */:
                case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15H_YC /* 655815 */:
                case FinalCanbus.CAR_448_6606_24Benz_Vito /* 852416 */:
                case FinalCanbus.CAR_448_6606_24Benz_Vito_H /* 917952 */:
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen /* 1114567 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen_3 /* 1180103 */:
                case FinalCanbus.CAR_446_Xiaolin_WY_LEXUS_Screen /* 2097598 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_Prado_14 /* 3211719 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_Proda_18 /* 3604935 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha /* 3670471 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha_3 /* 3736007 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_Proda_23 /* 4194759 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_Alpha_Screen_3 /* 4587975 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha_3_156inch /* 4784583 */:
                case FinalCanbus.CAR_WC2_CG_Honda_16Civic /* 5505345 */:
                case FinalCanbus.CAR_WC2_CG_Honda_16Civic_H /* 5570881 */:
                case FinalCanbus.CAR_444_WY_LEXUS_Screen /* 6095292 */:
                case FinalCanbus.CAR_455_LZ_Daohang_Toyota_Proda_18 /* 10092999 */:
                case FinalCanbus.CAR_455_LZ_Daohang_Toyota_Proda_23 /* 10158535 */:
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH /* 10420679 */:
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH_H /* 10486215 */:
                case FinalCanbus.CAR_455_LZ_DH_Toyota_Prado_14 /* 10551751 */:
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
                    window.setWidth(TheApp.getScreenWidth());
                    window.setHeight(TheApp.getScreenHeight() - 100);
                    break;
                case FinalCanbus.CAR_WC2_LandRover_Discovery3 /* 131483 */:
                case FinalCanbus.CAR_446_WC2_GAZ_GAZelleNN_24 /* 852414 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand /* 1311174 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto /* 1376710 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand /* 1442246 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand_S /* 1573318 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto_S /* 1638854 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand_S /* 1704390 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto_S /* 1769926 */:
                case FinalCanbus.CAR_RZC_UAZ /* 3539346 */:
                case FinalCanbus.CAR_RZC_XP1_RD5_25 /* 3932299 */:
                case FinalCanbus.CAR_RZC_Dakache /* 5308467 */:
                case FinalCanbus.CAR_455_ZH2_VinFast_VF3_Screen /* 5702087 */:
                case FinalCanbus.CAR_443_WC2_UAZ_Patriot /* 6947259 */:
                case FinalCanbus.CAR_444_WC2_GAZ_GAZelleNN /* 7209404 */:
                case FinalCanbus.CAR_443_WC2_Xpander_23 /* 8978875 */:
                case FinalCanbus.CAR_443_WC2_Xpander_23_H /* 9241019 */:
                case FinalCanbus.CAR_455_XinCheng_Infiniti_22QX50 /* 10355143 */:
                case FinalCanbus.CAR_455_ZH2_Sanlin_XFore_Screen /* 11862471 */:
                case FinalCanbus.CAR_452_TZY_UAZ_Patriot /* 11993540 */:
                case FinalCanbus.CAR_443_WC2_Xpander_22 /* 14811579 */:
                case FinalCanbus.CAR_443_WC2_Xpander_22_H /* 14877115 */:
                    window.setWidth(-1);
                    window.setHeight(-2);
                    break;
                case FinalCanbus.CAR_450_ZHTD_Audi /* 131522 */:
                case FinalCanbus.CAR_452_Luz_Audi_A4L_Low /* 14811588 */:
                case FinalCanbus.CAR_452_Luz_Audi_A4L_H /* 14877124 */:
                case FinalCanbus.CAR_452_Luz_Audi_Q5_Low /* 14942660 */:
                case FinalCanbus.CAR_452_Luz_Audi_Q5_H /* 15008196 */:
                case FinalCanbus.CAR_452_Luz_Audi_A6L_Low /* 15073732 */:
                case FinalCanbus.CAR_452_Luz_Audi_A6L_H /* 15139268 */:
                case FinalCanbus.CAR_452_Luz_Audi_Q7_Low /* 15204804 */:
                case FinalCanbus.CAR_452_Luz_Audi_Q7_H /* 15270340 */:
                    window.setWidth(TheApp.getScreenWidth());
                    window.setHeight(230);
                    break;
                case FinalCanbus.CAR_WC2_07_AoDeSai /* 196774 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto /* 197052 */:
                case FinalCanbus.CAR_XP1_PsaAll_AutoPark /* 262425 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_P15_MC_EV /* 262588 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Auto /* 721340 */:
                case FinalCanbus.CAR_444_WC2_DAIHATSU_All /* 786876 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_GCC /* 852412 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV1 /* 917948 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV2 /* 983484 */:
                case FinalCanbus.CAR_RZCexc_ALFA_ROMEO_GIULIETTA_16 /* 1048615 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV3 /* 1049020 */:
                case FinalCanbus.CAR_RZCexc_ALFA_ROMEO_159_09 /* 1114151 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_OFFROAD /* 1114556 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto2 /* 1180092 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto /* 1507782 */:
                case FinalCanbus.CAR_WC2_Datong_D90_19_H /* 1769888 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Iran /* 1900988 */:
                case FinalCanbus.CAR_455_OUDI_Aiying_BYD_ALL /* 2556359 */:
                case FinalCanbus.CAR_RZCexc_ALFA_ROMEO_GIULIETTA_16_M /* 2752551 */:
                case FinalCanbus.CAR_RZCexc_ALFA_ROMEO_GIULIETTA_16_H /* 2818087 */:
                case FinalCanbus.CAR_RZCexc_ALFA_ROMEO_159_09_M /* 2883623 */:
                case FinalCanbus.CAR_RZCexc_ALFA_ROMEO_159_09_H /* 2949159 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_ADAS /* 3080636 */:
                case FinalCanbus.CAR_RZCexc_Feiyate_PANDA_L /* 3145767 */:
                case FinalCanbus.CAR_RZCexc_Feiyate_PANDA_M /* 3211303 */:
                case FinalCanbus.CAR_RZCexc_Feiyate_PANDA_H /* 3276839 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_GCC1 /* 3277244 */:
                case FinalCanbus.CAR_RZCexc_Feiyate_PANDAEV_L /* 3342375 */:
                case FinalCanbus.CAR_RZCexc_Feiyate_PANDAEV_M /* 3407911 */:
                case FinalCanbus.CAR_RZCexc_Feiyate_PANDAEV_H /* 3473447 */:
                case FinalCanbus.CAR_453_RZC_Jianghuai_S7_H /* 6095301 */:
                case FinalCanbus.CAR_454_OD_ChangAn_Raeton_H /* 14418374 */:
                case FinalCanbus.CAR_443_WC2_Ford_12Focus_Overseas /* 15139259 */:
                case FinalCanbus.CAR_453_OD_Modernin /* 16384453 */:
                    window.setWidth(TheApp.getScreenWidth());
                    window.setHeight(TheApp.getScreenHeight());
                    break;
                default:
                    window.setWidth(-2);
                    window.setHeight(-2);
                    break;
            }
            sPopupWindow = window;
        }
        return sPopupWindow;
    }

    public static void setLocation(int x, int y) {
        LocationX = x;
        LocationY = y;
    }

    public static void postDelayedSingle(Runnable runnable, int delay) {
        if (runnable != null) {
            HandlerUI.getInstance().removeCallbacks(runnable);
            HandlerUI.getInstance().postDelayed(runnable, delay);
        }
    }

    public static void postDimiss(int delay) {
        postDelayedSingle(WINDOW_HIDE, delay);
    }

    public static void showWindow() {
        HandlerUI.getInstance().post(SHOW);
    }
}
