package com.syu.canbus.warn;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.widget.PopupWindow;

import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.util.HandlerUI;

public class WarnUtils {
    static int LocationX = 0;
    static int LocationY = 0;
    private static final Runnable SHOW = new Runnable() { 
        @Override
        public void run() {
            PopupWindow window = WarnUtils.getWindow();
            LauncherApplication.addRootView(window);
            if (LauncherApplication.rootViewWindowToken() == null) {
                HandlerUI.getInstance().postDelayed(this, 1L);
            }
            if (!window.isShowing()) {
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_455_LZ_CG_Toyota_4Runner_Auto /* 65991 */:
                    case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15_YC /* 590279 */:
                    case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15H_YC /* 655815 */:
                    case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen /* 1114567 */:
                    case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen_3 /* 1180103 */:
                    case FinalCanbus.CAR_455_LZ_YL_Toyota_Prado_14 /* 3211719 */:
                    case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
                    case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
                    case FinalCanbus.CAR_RZC_HONDA_CRV_TW6_L /* 5374250 */:
                    case FinalCanbus.CAR_RZC_HONDA_CRV_TW6_CCD /* 5505322 */:
                    case FinalCanbus.CAR_WC2_CG_Honda_16Civic /* 5505345 */:
                    case FinalCanbus.CAR_WC2_CG_Honda_16Civic_H /* 5570881 */:
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
                        window.showAtLocation(LauncherApplication.getInstance().getRootView(), 83, 0, 0);
                        break;
                    case FinalCanbus.CAR_450_ZHTD_Audi /* 131522 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto /* 197052 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_P15_MC_EV /* 262588 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Auto /* 721340 */:
                    case FinalCanbus.CAR_444_WC2_DAIHATSU_All /* 786876 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_GCC /* 852412 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV1 /* 917948 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV2 /* 983484 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV3 /* 1049020 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_OFFROAD /* 1114556 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto2 /* 1180092 */:
                    case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto /* 1507782 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Iran /* 1900988 */:
                    case FinalCanbus.CAR_455_OUDI_Aiying_BYD_ALL /* 2556359 */:
                    case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_ADAS /* 3080636 */:
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
                        window.showAtLocation(LauncherApplication.getInstance().getRootView(), 3, 0, 0);
                        break;
                    default:
                        window.showAtLocation(LauncherApplication.getInstance().getRootView(), 17, WarnUtils.LocationX, WarnUtils.LocationY);
                        break;
                }
            }
        }
    };
    private static final Runnable WINDOW_HIDE = new Runnable() { 
        @Override
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
            Context context = LauncherApplication.getInstance();
            PopupWindow window = new PopupWindow(context);
            window.setFocusable(true);
            window.setBackgroundDrawable(new ColorDrawable(0));
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_455_LZ_CG_Toyota_4Runner_Auto /* 65991 */:
                case FinalCanbus.CAR_WC2_07_AoDeSai /* 196774 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto /* 197052 */:
                case FinalCanbus.CAR_XP1_PsaAll_AutoPark /* 262425 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_P15_MC_EV /* 262588 */:
                case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15_YC /* 590279 */:
                case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15H_YC /* 655815 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Auto /* 721340 */:
                case FinalCanbus.CAR_444_WC2_DAIHATSU_All /* 786876 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_GCC /* 852412 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV1 /* 917948 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV2 /* 983484 */:
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV3 /* 1049020 */:
                case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_OFFROAD /* 1114556 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen /* 1114567 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto2 /* 1180092 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen_3 /* 1180103 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto /* 1507782 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Iran /* 1900988 */:
                case FinalCanbus.CAR_455_OUDI_Aiying_BYD_ALL /* 2556359 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
                case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_ADAS /* 3080636 */:
                case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
                case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
                case FinalCanbus.CAR_WC2_CG_Honda_16Civic /* 5505345 */:
                case FinalCanbus.CAR_WC2_CG_Honda_16Civic_H /* 5570881 */:
                case FinalCanbus.CAR_453_RZC_Jianghuai_S7_H /* 6095301 */:
                case FinalCanbus.CAR_454_OD_ChangAn_Raeton_H /* 14418374 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300 /* 15008198 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_4Runner /* 15073734 */:
                case FinalCanbus.CAR_443_WC2_Ford_12Focus_Overseas /* 15139259 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER /* 15139270 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha /* 15204806 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER_H /* 15532486 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300_H /* 15598022 */:
                case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha_3 /* 16187846 */:
                case FinalCanbus.CAR_453_OD_Modernin /* 16384453 */:
                    window.setWidth(LauncherApplication.getScreenWidth());
                    window.setHeight(LauncherApplication.getScreenHeight());
                    break;
                case FinalCanbus.CAR_WC2_LandRover_Discovery3 /* 131483 */:
                case FinalCanbus.CAR_RZC_UAZ /* 3539346 */:
                case FinalCanbus.CAR_443_WC2_UAZ_Patriot /* 6947259 */:
                case FinalCanbus.CAR_452_TZY_UAZ_Patriot /* 11993540 */:
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
                    window.setWidth(LauncherApplication.getScreenWidth());
                    window.setHeight(230);
                    break;
                case FinalCanbus.CAR_455_LZ_YL_Toyota_Prado_14 /* 3211719 */:
                case FinalCanbus.CAR_454_LZ_Toyota_FJ_CRUISER /* 14942662 */:
                case FinalCanbus.CAR_454_LZ_Toyota_FJ_CRUISER_3 /* 16253382 */:
                case FinalCanbus.CAR_454_LZ_6606_Toyota_FJ_CRUISER /* 16318918 */:
                case FinalCanbus.CAR_454_LZ_6606_Toyota_FJ_CRUISER_3 /* 16384454 */:
                    window.setWidth(LauncherApplication.getScreenWidth());
                    window.setHeight(LauncherApplication.getScreenHeight() - 100);
                    break;
                case FinalCanbus.CAR_RZC_HONDA_CRV_TW6_L /* 5374250 */:
                case FinalCanbus.CAR_RZC_HONDA_CRV_TW6_CCD /* 5505322 */:
                    window.setWidth(LauncherApplication.getScreenWidth());
                    window.setHeight(LauncherApplication.getScreenHeight() - 60);
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
