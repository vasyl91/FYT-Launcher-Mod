package com.syu.carinfo.air;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.ui.air.AirHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Air_Activity_All_NewAdd_HP2 extends Activity implements View.OnTouchListener {
    public static Air_Activity_All_NewAdd_HP2 mInstance;
    public static boolean mIsFront = false;
    int pagenum = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.air.Air_Activity_All_NewAdd_HP2.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == ConstAllAirDara.U_AIR_AC) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateAcOn();
            }
            if (updateCode == ConstAllAirDara.U_AIR_CYCLE) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateCycle();
            }
            if (updateCode == ConstAllAirDara.U_AIR_CYCLE_AUTO) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateCycle();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateRearDefrost();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SWING) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateAirSwing();
            }
            if (updateCode == ConstAllAirDara.U_AIR_ECO) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateECO();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FLOWER_BLOW) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateFlowerBlow();
            }
            if (updateCode == ConstAllAirDara.U_AIR_PARK) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateAirPark();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REST) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateAirRest();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FRONT_ONLY) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateAirOnlyFront();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FRONT_ONLY_F) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateAirOnlyFront_F();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR_MANUAL) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateAirRearManual();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR_COOL) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateAirRearCool();
            }
            if (updateCode == ConstAllAirDara.U_AIR_NANOE) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateNanoe();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FRONT) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateFrontDefrost();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FRONT_HOT) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateFrontHot();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FRONTMAX) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateMaxFrontDefrost();
            }
            if (updateCode == ConstAllAirDara.U_AIR_POWER) {
                Air_Activity_All_NewAdd_HP2.this.mUpdatePower();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_POWER) {
                Air_Activity_All_NewAdd_HP2.this.mUpdatePower();
            }
            if (updateCode == ConstAllAirDara.U_AIR_TEMP_LEFT) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateAirTempLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT) {
                Air_Activity_All_NewAdd_HP2.this.mUpdaterAirWindLevelLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_AUTO) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateAuto();
            }
            if (updateCode == ConstAllAirDara.U_AIR_AUTO_RIGHT) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateAutoRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_DUAL) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateDual();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SYNC) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateSYNC();
            }
            if (updateCode == ConstAllAirDara.U_AIR_ZONE) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateZONE();
            }
            if (updateCode == ConstAllAirDara.U_AIR_WAISTHEAT_LEFT) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateWaistHeatLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_WAISTHEAT_RIGHT) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateWaistHeatRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATWAIST_LEFT) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateSeatWaistLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATWAIST_RIGHT) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateSeatWaistRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATMASSAGE_LEFT) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateSeatMassageLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATMASSAGE_RIGHT) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateSeatMassageRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATHEAT_LEFT || updateCode == ConstAllAirDara.U_AIR_SEATWIND_LEFT) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateHeatLeft();
                Air_Activity_All_NewAdd_HP2.this.mUpdateWindLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATHEAT_RIGHT || updateCode == ConstAllAirDara.U_AIR_SEATWIND_RIGHT) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateHeatRight();
                Air_Activity_All_NewAdd_HP2.this.mUpdateWindRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATHEAT_LEFT_REAR) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateHeatLeftRear();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATHEAT_RIGHT_REAR) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateHeatRightRear();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATWIND_LEFT_REAR) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateWindLeftRear();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATWIND_RIGHT_REAR) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateWindRightRear();
            }
            if (updateCode == ConstAllAirDara.U_AIR_TEMP_RIGHT) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateTempRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_TEMP_UNIT) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateTempUNIT();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_TEMP) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateBackTemp();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateBackTempRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_BLOW_AUTO) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateBackAuto();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_AUTO_RIGHT) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateBackAutoRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR_LOCK) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateBackRearLock();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR_SYNC) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateBackRearSync();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR_AC) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateBackRearAC();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR_CTRL) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateBackRearCtrl();
            }
            if (updateCode == ConstAllAirDara.U_AIR_AQS) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateAirAQS();
            }
            if (updateCode == ConstAllAirDara.U_AIR_AC_MAX) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateAcMax();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SOFT) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateAirSoft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FAST) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateAirFast();
            }
            if (updateCode == ConstAllAirDara.U_AIR_NORMAL) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateAirNormal();
            }
            if (updateCode == ConstAllAirDara.U_AIR_ION) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateIon();
            }
            if (updateCode == ConstAllAirDara.U_AIR_CLEAN) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateClean();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOWTOP) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateBlowTop();
            }
            if (updateCode == ConstAllAirDara.U_AIR_STEER) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateSteerHot();
            }
            if (updateCode == ConstAllAirDara.U_AIR_WINLEV) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateAirWinlev();
            }
            if (updateCode == ConstAllAirDara.U_AIR_HEAT) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateAirHeat();
            }
            if (updateCode == ConstAllAirDara.U_AIR_PTC) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateAirPTC();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_BLOW_WIND) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateBackWind();
            }
            if (updateCode == ConstAllAirDara.U_AIR_EM) {
                Air_Activity_All_NewAdd_HP2.this.mUpdateAirEm();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_UP_LEFT || updateCode == ConstAllAirDara.U_AIR_BLOW_BODY_LEFT || updateCode == ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT || updateCode == ConstAllAirDara.U_AIR_BLOW_AUTO_LEFT) {
                Air_Activity_All_NewAdd_HP2.this.updateBlowModeLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_UP_RIGHT || updateCode == ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT || updateCode == ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT || updateCode == ConstAllAirDara.U_AIR_BLOW_AUTO_RIGHT) {
                Air_Activity_All_NewAdd_HP2.this.updateBlowModeRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_BLOW_UP || updateCode == ConstAllAirDara.U_AIR_BACK_BLOW_BODY || updateCode == ConstAllAirDara.U_AIR_BACK_BLOW_FOOT) {
                Air_Activity_All_NewAdd_HP2.this.updateBlowBackMode();
            }
            if (updateCode != ConstAllAirDara.U_AIR_BACK_BLOW_UP_RIGHT && updateCode != ConstAllAirDara.U_AIR_BACK_BLOW_BODY_RIGHT && updateCode != ConstAllAirDara.U_AIR_BACK_BLOW_FOOT_RIGHT) {
                return;
            }
            Air_Activity_All_NewAdd_HP2.this.updateBlowBackModeRight();
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_LZ_CG_Toyota_4Runner_Auto /* 65991 */:
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen /* 1114567 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_Alpha_Screen_3 /* 1180103 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_Proda_18 /* 3604935 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_Proda_23 /* 4194759 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha_3_156inch /* 4784583 */:
            case FinalCanbus.CAR_WC2_CG_Honda_16Civic_H /* 5570881 */:
            case FinalCanbus.CAR_455_LZ_Daohang_Toyota_Proda_18 /* 10092999 */:
            case FinalCanbus.CAR_455_LZ_Daohang_Toyota_Proda_23 /* 10158535 */:
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH /* 10420679 */:
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_DH_H /* 10486215 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300 /* 15008198 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_4Runner /* 15073734 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER /* 15139270 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha /* 15204806 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER_H /* 15532486 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300_H /* 15598022 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_Alpha_3 /* 16187846 */:
                setContentView(R.layout.layout_air_hp_all_prado_cg7870);
                break;
            default:
                int toobarheigt = SystemProperties.getInt("persist.launcher.toobar_height", 0);
                int statusbarheigt = SystemProperties.getInt("sys.lsec.status_bar_height", 0);
                Configuration config = getResources().getConfiguration();
                int smallestScreenWidth = config.smallestScreenWidthDp;
                Log.v("zed", " 111 TheApp.getScreenWidth() == " + TheApp.getScreenWidth() + "  TheApp.getScreenHeight() = " + TheApp.getScreenHeight() + "  smallestScreenWidth = " + smallestScreenWidth + "  toobarheigt = " + toobarheigt + "  statusbarheigt = " + statusbarheigt);
                if ((toobarheigt >= 100 || statusbarheigt >= 100) && TheApp.getConfiguration() != 1) {
                    setContentView(R.layout.layout_air_hp_all_prado_small);
                } else if (TheApp.getScreenWidth() == 2284 && TheApp.getScreenHeight() == 896) {
                    setContentView(R.layout.layout_air_hp_all_prado_2284);
                } else {
                    setContentView(R.layout.layout_air_hp_all_prado);
                }
                break;
        }
        initCallbackId();
        init();
        mInstance = this;
    }

    private void sendCmd(int data0, int data1) {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_439_OuDi_Haval_H9 /* 1376695 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
            case FinalCanbus.CAR_RZC_Haval_H9 /* 2490807 */:
            case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
            case FinalCanbus.CAR_452_RZC_Haval_H9_Low /* 8651204 */:
            case FinalCanbus.CAR_454_RZC_Haval_H8_15 /* 11796934 */:
            case FinalCanbus.CAR_454_RZC_Haval_H8_15_H /* 11862470 */:
            case FinalCanbus.CAR_455_OD_Haval_H7 /* 12124615 */:
            case FinalCanbus.CAR_455_OD_Haval_H7_H /* 12190151 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_RS /* 15598007 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
            case FinalCanbus.CAR_452_OD_Haval_VV5 /* 16122308 */:
            case FinalCanbus.CAR_452_OD_Haval_VV6 /* 16187844 */:
            case FinalCanbus.CAR_452_OD_Haval_VV7 /* 16253380 */:
            case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
            case FinalCanbus.CAR_439_BNR_HAVAL_H9 /* 16384439 */:
            case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
            case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                if (this.pagenum == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{data0, data1}, null, null);
                } else if (this.pagenum == 1) {
                    DataCanbus.PROXY.cmd(3, new int[]{data0, data1}, null, null);
                }
                break;
            case FinalCanbus.CAR_456_LUZ_Honda_Pilot_Screen /* 7995848 */:
            case FinalCanbus.CAR_456_LZ_Xianddai_Screen /* 13631944 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{183, data0}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{183, 0}, null, null);
                }
                break;
            case FinalCanbus.CAR_456_CZH_Xiandai_All_L /* 13304264 */:
            case FinalCanbus.CAR_456_CZH_Xiandai_All_H /* 13369800 */:
                int ints0 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints1 = ints0 | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0);
                int ints2 = 0 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0);
                int ints3 = ints2 | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints4 = 0 | (data0 == ConstAllAirDara.C_AIR_MODE_BODY ? 32 : 0);
                int ints5 = ints4 | (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_FOOT ? 96 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT ? 128 : 0);
                int ints6 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints7 = ints6 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints8 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                int ints9 = ints8 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                int ints10 = 0 | (data0 == ConstAllAirDara.C_CLEAN ? 8 : 0);
                int ints11 = ints10 | (data0 == ConstAllAirDara.C_AIR_SWING ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT ? 1 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints1, ints3, ints5, ints7, ints9, ints11}, null, null);
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                }
                break;
            default:
                DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                break;
        }
    }

    public void initCallbackId() {
        ConstAllAirDara.initClearAllId();
        switch (DataCanbus.DATA[1000]) {
            case 151:
            case FinalCanbus.CAR_DJ_ShuPing_BYD_G6 /* 196759 */:
            case FinalCanbus.CAR_DJ_ShuPing_BYD_G6_H /* 262295 */:
            case FinalCanbus.CAR_DAOJUN_XP1_BYDSurui /* 458903 */:
            case FinalCanbus.CAR_RCW_BYD_6 /* 524439 */:
            case FinalCanbus.CAR_RCW_BYD_12_18Surui /* 589975 */:
            case FinalCanbus.CAR_455_RCW_BYD_20E1 /* 4325831 */:
            case FinalCanbus.CAR_455_RCW_BYD_19S2 /* 4391367 */:
            case FinalCanbus.CAR_455_RCW_BYD_21E3 /* 4456903 */:
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
            case FinalCanbus.CAR_456_OUDI_BYD_ALL_SONGMAX /* 12517832 */:
            case FinalCanbus.CAR_439_OUDI_BYD_ALL /* 12976567 */:
            case FinalCanbus.CAR_453_RCW_BYD_10_13G6 /* 13042117 */:
                ConstAllAirDara.C_CONTRAL = 0;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_SYNC = 14;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                switch (DataCanbus.DATA[1000]) {
                    case 151:
                    case FinalCanbus.CAR_DAOJUN_XP1_BYDSurui /* 458903 */:
                    case FinalCanbus.CAR_RCW_BYD_6 /* 524439 */:
                    case FinalCanbus.CAR_RCW_BYD_12_18Surui /* 589975 */:
                        ConstAllAirDara.C_AIR_POWER = 10;
                        ConstAllAirDara.C_AIR_WIND_ADD = 6;
                        ConstAllAirDara.C_AIR_WIND_SUB = 7;
                        ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                        ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                        ConstAllAirDara.C_AIR_AUTO = 1;
                        ConstAllAirDara.C_AIR_SYNC = 2;
                        ConstAllAirDara.C_AIR_CYCLE = 3;
                        ConstAllAirDara.C_AIR_FRONT_DEFROST = 4;
                        ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                        ConstAllAirDara.C_AIR_AC = 8;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 9;
                        ConstAllAirDara.C_AIR_AC_MAX = 11;
                        break;
                    case FinalCanbus.CAR_DJ_ShuPing_BYD_G6 /* 196759 */:
                    case FinalCanbus.CAR_DJ_ShuPing_BYD_G6_H /* 262295 */:
                        ConstAllAirDara.C_AIR_POWER = 10;
                        ConstAllAirDara.C_AIR_WIND_ADD = 6;
                        ConstAllAirDara.C_AIR_WIND_SUB = 7;
                        ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                        ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                        ConstAllAirDara.C_AIR_AUTO = 1;
                        ConstAllAirDara.C_AIR_SYNC = 2;
                        ConstAllAirDara.C_AIR_CYCLE = 3;
                        ConstAllAirDara.C_AIR_FRONT_DEFROST = 4;
                        ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                        ConstAllAirDara.C_AIR_AC = 8;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 11;
                        ConstAllAirDara.U_AIR_AC_MAX = 255;
                        break;
                    case FinalCanbus.CAR_456_OUDI_BYD_ALL_SONGMAX /* 12517832 */:
                    case FinalCanbus.CAR_439_OUDI_BYD_ALL /* 12976567 */:
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.C_AIR_POWER = 1;
                        ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                        ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                        ConstAllAirDara.C_AIR_MODE_ADD = 7;
                        ConstAllAirDara.C_AIR_MODE_SUB = 8;
                        ConstAllAirDara.C_AIR_WIND_ADD = 10;
                        ConstAllAirDara.C_AIR_WIND_SUB = 9;
                        ConstAllAirDara.C_AIR_SYNC = 16;
                        ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                        ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                        ConstAllAirDara.C_AIR_AC = 23;
                        ConstAllAirDara.C_AIR_AUTO = 21;
                        ConstAllAirDara.C_AIR_AC_MAX = 22;
                        ConstAllAirDara.C_AIR_CYCLE = 25;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                        if (DataCanbus.DATA[1000] == 12517832) {
                            ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                            ConstAllAirDara.U_AIR_BACK_TEMP = 27;
                            ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 28;
                            ConstAllAirDara.U_AIR_BACK_BLOW_UP = 18;
                            ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 19;
                            ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 20;
                            ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                            ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 13;
                            ConstAllAirDara.U_AIR_BACK_POWER = 42;
                            ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                            ConstAllAirDara.C_REAR_OFF = 44;
                            ConstAllAirDara.C_REAR_WIND_DOWN = 40;
                            ConstAllAirDara.C_REAR_WIND_UP = 41;
                            ConstAllAirDara.C_REAR_AUTO = 21;
                            ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 2;
                            ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 3;
                            ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 4;
                            ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 5;
                            ConstAllAirDara.C_REAR_MODE = 7;
                            ConstAllAirDara.C_REAR_LOCK = 46;
                        }
                        break;
                    default:
                        ConstAllAirDara.C_AIR_POWER = 1;
                        ConstAllAirDara.C_AIR_WIND_ADD = 2;
                        ConstAllAirDara.C_AIR_WIND_SUB = 3;
                        ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 4;
                        ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 5;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 6;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 7;
                        ConstAllAirDara.C_AIR_AUTO = 8;
                        ConstAllAirDara.C_AIR_SYNC = 9;
                        ConstAllAirDara.C_AIR_CYCLE = 10;
                        ConstAllAirDara.C_AIR_FRONT_DEFROST = 11;
                        ConstAllAirDara.C_AIR_REAR_DEFROST = 12;
                        ConstAllAirDara.C_AIR_AC = 13;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 14;
                        ConstAllAirDara.C_AIR_AC_MAX = 15;
                        break;
                }
                break;
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
            case FinalCanbus.CAR_RZC_XP1_ChuanQi_AION_23ES /* 2359576 */:
            case FinalCanbus.CAR_RZC_XP1_ChuanQi_AIRTREKEV_22 /* 2425112 */:
            case FinalCanbus.CAR_RZC_XP1_ChuanQi_AION_23ES_R /* 2490648 */:
            case FinalCanbus.CAR_RZC_OD_AION_EV_25 /* 2556184 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_ION = 58;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                if (DataCanbus.DATA[1000] == 1311000) {
                    ConstAllAirDara.U_AIR_REAR_CTRL = 38;
                    ConstAllAirDara.C_REAR_CTRL = 27;
                }
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_DUAL = 3;
                ConstAllAirDara.C_AIR_CYCLE = 21;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 6;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 23;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_446_WC2_Futon_FengjingI9_25 /* 721342 */:
            case FinalCanbus.CAR_446_WC2_Futon_Kawen_25 /* 786878 */:
            case FinalCanbus.CAR_446_WC2_Futon_TuyanuoDaV_24_Auto /* 3539390 */:
            case FinalCanbus.CAR_446_WC2_Futon_TuyanuoDaV_24_Hand /* 3604926 */:
            case FinalCanbus.CAR_446_WC2_Futon_XianglingU7_25 /* 3670462 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_CYCLE_AUTO = 36;
                ConstAllAirDara.U_AIR_PTC = 68;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_446_WC2_Futon_TuyanuoDaV_24_Hand /* 3604926 */:
                        ConstAllAirDara.U_AIR_AUTO = 255;
                        ConstAllAirDara.C_AIR_AUTO = 255;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 14;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 21;
                break;
            case FinalCanbus.CAR_439_OuDi_Haval_H9 /* 1376695 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
            case FinalCanbus.CAR_RZC_Haval_H9 /* 2490807 */:
            case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
            case FinalCanbus.CAR_452_RZC_Haval_H9_Low /* 8651204 */:
            case FinalCanbus.CAR_454_RZC_Haval_H8_15 /* 11796934 */:
            case FinalCanbus.CAR_454_RZC_Haval_H8_15_H /* 11862470 */:
            case FinalCanbus.CAR_455_OD_Haval_H7 /* 12124615 */:
            case FinalCanbus.CAR_455_OD_Haval_H7_H /* 12190151 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_RS /* 15598007 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
            case FinalCanbus.CAR_452_OD_Haval_VV5 /* 16122308 */:
            case FinalCanbus.CAR_452_OD_Haval_VV6 /* 16187844 */:
            case FinalCanbus.CAR_452_OD_Haval_VV7 /* 16253380 */:
            case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
            case FinalCanbus.CAR_439_BNR_HAVAL_H9 /* 16384439 */:
            case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
            case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                ConstAllAirDara.TEMPERATURE_NONE = 0;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_DUAL = 57;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.U_AIR_SEATWAIST_LEFT = 95;
                ConstAllAirDara.U_AIR_SEATWAIST_RIGHT = 96;
                ConstAllAirDara.U_AIR_SEATMASSAGE_LEFT = 93;
                ConstAllAirDara.U_AIR_SEATMASSAGE_RIGHT = 94;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                ConstAllAirDara.U_AIR_BACK_BLOW_UP = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT_REAR = 88;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_Haval_H9 /* 2490807 */:
                    case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                    case FinalCanbus.CAR_452_RZC_Haval_H9_Low /* 8651204 */:
                    case FinalCanbus.CAR_454_RZC_Haval_H8_15 /* 11796934 */:
                    case FinalCanbus.CAR_454_RZC_Haval_H8_15_H /* 11862470 */:
                        ConstAllAirDara.C_AIR_POWER = 16;
                        ConstAllAirDara.C_AIR_AC = 17;
                        ConstAllAirDara.C_AIR_AUTO = 34;
                        ConstAllAirDara.C_AIR_DUAL = 35;
                        ConstAllAirDara.C_AIR_CYCLE = 19;
                        ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 30;
                        ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 31;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 32;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 33;
                        ConstAllAirDara.C_AIR_WIND_ADD = 28;
                        ConstAllAirDara.C_AIR_WIND_SUB = 29;
                        ConstAllAirDara.C_AIR_MODE_BODY = 24;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 26;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 25;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 27;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 36;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 37;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 38;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 39;
                        ConstAllAirDara.C_AIR_LEFT_MASSAGE = 40;
                        ConstAllAirDara.C_AIR_RIGHT_MASSAGE = 41;
                        ConstAllAirDara.C_AIR_LEFT_WAIST = 42;
                        ConstAllAirDara.C_AIR_RIGHT_WAIST = 43;
                        ConstAllAirDara.C_REAR_OFF = 129;
                        ConstAllAirDara.C_REAR_AUTO = 130;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 134;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 133;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 134;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 133;
                        ConstAllAirDara.C_REAR_WIND_DOWN = 132;
                        ConstAllAirDara.C_REAR_WIND_UP = 131;
                        ConstAllAirDara.C_REAR_MODE_FOOT = 137;
                        ConstAllAirDara.C_REAR_MODE_BODY = 135;
                        ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 136;
                        ConstAllAirDara.C_AIR_LEFT_HEAT_REAR = 138;
                        break;
                    case FinalCanbus.CAR_439_BNR_HAVAL_H9 /* 16384439 */:
                        ConstAllAirDara.C_AIR_POWER = 1;
                        ConstAllAirDara.C_AIR_AC = 23;
                        ConstAllAirDara.C_AIR_AUTO = 21;
                        ConstAllAirDara.C_AIR_DUAL = 16;
                        ConstAllAirDara.C_AIR_CYCLE = 25;
                        ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                        ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                        ConstAllAirDara.C_AIR_WIND_ADD = 10;
                        ConstAllAirDara.C_AIR_WIND_SUB = 9;
                        ConstAllAirDara.C_AIR_MODE_BODY = 7;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 6;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 26;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 12;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 14;
                        ConstAllAirDara.C_AIR_LEFT_MASSAGE = 17;
                        ConstAllAirDara.C_AIR_RIGHT_MASSAGE = 19;
                        ConstAllAirDara.C_AIR_LEFT_WAIST = 18;
                        ConstAllAirDara.C_AIR_RIGHT_WAIST = 20;
                        ConstAllAirDara.C_REAR_OFF = 32;
                        ConstAllAirDara.C_REAR_AUTO = 37;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 33;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 34;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 33;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 34;
                        ConstAllAirDara.C_REAR_WIND_DOWN = 35;
                        ConstAllAirDara.C_REAR_WIND_UP = 36;
                        ConstAllAirDara.C_REAR_MODE_FOOT = 39;
                        ConstAllAirDara.C_REAR_MODE_BODY = 38;
                        ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 40;
                        break;
                    default:
                        ConstAllAirDara.C_AIR_POWER = 16;
                        ConstAllAirDara.C_AIR_AC = 17;
                        ConstAllAirDara.C_AIR_AUTO = 18;
                        ConstAllAirDara.C_AIR_DUAL = 20;
                        ConstAllAirDara.C_AIR_CYCLE = 19;
                        ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 30;
                        ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 31;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 32;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 33;
                        ConstAllAirDara.C_AIR_WIND_ADD = 28;
                        ConstAllAirDara.C_AIR_WIND_SUB = 29;
                        ConstAllAirDara.C_AIR_MODE_BODY = 24;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 26;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 25;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 27;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 34;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 35;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 36;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 37;
                        ConstAllAirDara.C_AIR_LEFT_MASSAGE = 38;
                        ConstAllAirDara.C_AIR_RIGHT_MASSAGE = 39;
                        ConstAllAirDara.C_AIR_LEFT_WAIST = 40;
                        ConstAllAirDara.C_AIR_RIGHT_WAIST = 41;
                        ConstAllAirDara.C_REAR_OFF = 16;
                        ConstAllAirDara.C_REAR_AUTO = 18;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 31;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 30;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 31;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 30;
                        ConstAllAirDara.C_REAR_WIND_DOWN = 29;
                        ConstAllAirDara.C_REAR_WIND_UP = 28;
                        ConstAllAirDara.C_REAR_MODE_FOOT = 26;
                        ConstAllAirDara.C_REAR_MODE_BODY = 24;
                        ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 25;
                        ConstAllAirDara.C_AIR_LEFT_HEAT_REAR = 32;
                        break;
                }
                break;
            case FinalCanbus.CAR_456_DJ_Haval_Screen_VV5 /* 3473864 */:
            case FinalCanbus.CAR_456_DJ_Haval_Screen_VV6 /* 3539400 */:
            case FinalCanbus.CAR_456_DJ_Haval_Screen_VV7 /* 3604936 */:
            case FinalCanbus.CAR_439_DJ_Haval_H8 /* 10420663 */:
            case FinalCanbus.CAR_439_DJ_Haval_H8_H /* 10486199 */:
            case FinalCanbus.CAR_439_DJ_Haval_H9 /* 15794628 */:
            case FinalCanbus.CAR_439_DJ_Haval_H9_H /* 15860164 */:
            case FinalCanbus.CAR_439_DJ_Haval_VV5 /* 15925700 */:
            case FinalCanbus.CAR_439_DJ_Haval_VV6 /* 15991236 */:
            case FinalCanbus.CAR_439_DJ_Haval_VV7 /* 16056772 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AQS = 54;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.U_AIR_SEATWAIST_LEFT = 95;
                ConstAllAirDara.U_AIR_SEATWAIST_RIGHT = 96;
                ConstAllAirDara.U_AIR_SEATMASSAGE_LEFT = 93;
                ConstAllAirDara.U_AIR_SEATMASSAGE_RIGHT = 94;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 48;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 49;
                ConstAllAirDara.C_AIR_AQS = 24;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 50;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                ConstAllAirDara.C_AIR_LEFT_COLD = 12;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 14;
                ConstAllAirDara.C_AIR_LEFT_MASSAGE = 17;
                ConstAllAirDara.C_AIR_RIGHT_MASSAGE = 19;
                ConstAllAirDara.C_AIR_LEFT_WAIST = 18;
                ConstAllAirDara.C_AIR_RIGHT_WAIST = 20;
                break;
            case FinalCanbus.CAR_443_WC_12Cedric_CD /* 7143867 */:
            case FinalCanbus.CAR_443_WC_12Cedric /* 7209403 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_DUAL = 14;
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
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_DUAL = 41;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 21;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_456_LUZ_Honda_Pilot_Screen /* 7995848 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                ConstAllAirDara.U_AIR_BACK_BLOW_UP = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_WIND_ADD = 2;
                ConstAllAirDara.C_AIR_WIND_SUB = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 6;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 7;
                ConstAllAirDara.C_AIR_MODE_BODY = 14;
                ConstAllAirDara.C_AIR_MODE_FOOT = 15;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 16;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 17;
                ConstAllAirDara.C_AIR_AC = 12;
                ConstAllAirDara.C_AIR_AUTO = 9;
                ConstAllAirDara.C_AIR_SYNC = 10;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 11;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 13;
                ConstAllAirDara.C_AIR_CYCLE = 18;
                ConstAllAirDara.C_REAR_OFF = 32;
                ConstAllAirDara.C_REAR_WIND_DOWN = 34;
                ConstAllAirDara.C_REAR_WIND_UP = 33;
                ConstAllAirDara.C_REAR_AUTO = 37;
                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 36;
                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 35;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 36;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 35;
                ConstAllAirDara.C_REAR_MODE_FOOT = 39;
                ConstAllAirDara.C_REAR_MODE_BODY = 38;
                ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 40;
                ConstAllAirDara.C_REAR_LOCK = 41;
                break;
            case FinalCanbus.CAR_456_OD_Changan_KuayueXT_S5 /* 8520136 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_PTC = 63;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
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
                ConstAllAirDara.C_AIR_PTC = 6;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_LEFT_COLD = 12;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_456_OUDI_Xugong_Qingka /* 12583368 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_HEAT = 63;
                ConstAllAirDara.U_AIR_ION = 53;
                ConstAllAirDara.U_AIR_FRONT = 65;
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
                ConstAllAirDara.C_AIR_WIND_ADD = 7;
                ConstAllAirDara.C_AIR_WIND_SUB = 6;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 8;
                ConstAllAirDara.C_AIR_AC = 9;
                ConstAllAirDara.C_AIR_CYCLE = 10;
                ConstAllAirDara.C_AIR_ION = 11;
                ConstAllAirDara.C_AIR_HEAT = 12;
                ConstAllAirDara.C_AIR_MODE_BODY = 13;
                ConstAllAirDara.C_AIR_MODE_FOOT = 15;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 14;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 16;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_456_OUDI_Dayun_YuanzhiM1 /* 12845512 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_HEAT = 63;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_BACK_TEMP = 27;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 27;
                ConstAllAirDara.U_AIR_BACK_BLOW_UP = 18;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 19;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 20;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_AUTO = 3;
                ConstAllAirDara.C_AIR_HEAT = 4;
                ConstAllAirDara.C_AIR_CYCLE = 5;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 6;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 7;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 14;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                ConstAllAirDara.C_AIR_WIND_ADD = 12;
                ConstAllAirDara.C_AIR_WIND_SUB = 13;
                ConstAllAirDara.C_AIR_MODE_BODY = 8;
                ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 9;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 11;
                ConstAllAirDara.C_REAR_OFF = 16;
                ConstAllAirDara.C_REAR_WIND_DOWN = 18;
                ConstAllAirDara.C_REAR_WIND_UP = 17;
                ConstAllAirDara.C_REAR_AUTO = 21;
                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 15;
                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 14;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 15;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 14;
                ConstAllAirDara.C_REAR_MODE = 19;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_456_CZH_Xiandai_All_L /* 13304264 */:
            case FinalCanbus.CAR_456_CZH_Xiandai_All_H /* 13369800 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_CLEAN = 76;
                ConstAllAirDara.U_AIR_SWING = 79;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_CYCLE = 4;
                ConstAllAirDara.C_AIR_AC = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 7;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 8;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 10;
                ConstAllAirDara.C_AIR_MODE_BODY = 11;
                ConstAllAirDara.C_AIR_MODE_FOOT = 12;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 13;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 14;
                ConstAllAirDara.C_AIR_WIND_ADD = 15;
                ConstAllAirDara.C_AIR_WIND_SUB = 16;
                ConstAllAirDara.C_CLEAN = 17;
                ConstAllAirDara.C_AIR_SWING = 18;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 19;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 20;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_456_Sanwu_huytu_Huangguan_DoubleAir /* 13435336 */:
            case FinalCanbus.CAR_456_Sanwu_huytu_Huangguan_FourAir /* 13500872 */:
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_FLOWER_BLOW = 33;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_CYCLE_AUTO = 54;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_NANOE = 34;
                ConstAllAirDara.U_AIR_PARK = 80;
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
                ConstAllAirDara.U_AIR_FRONT_HOT = 17;
                ConstAllAirDara.U_AIR_SWING = 35;
                ConstAllAirDara.C_AIR_FRONT_HOT = 72;
                ConstAllAirDara.C_AIR_SWING = 74;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_456_Sanwu_huytu_Huangguan_DoubleAir /* 13435336 */:
                        ConstAllAirDara.C_AIR_MODE_ADD = 8;
                        ConstAllAirDara.C_AIR_MODE_SUB = 7;
                        break;
                    case FinalCanbus.CAR_456_Sanwu_huytu_Huangguan_FourAir /* 13500872 */:
                        ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
                        ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                        ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 67;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 68;
                        ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT = 69;
                        break;
                }
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
                ConstAllAirDara.C_AIR_AC_MAX = 24;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_FLOWER_BLOW = 32;
                ConstAllAirDara.C_AIR_NANOE = 33;
                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 38;
                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 39;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 65;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 66;
                ConstAllAirDara.C_REAR_AUTO = 45;
                ConstAllAirDara.C_REAR_OFF = 44;
                ConstAllAirDara.C_AIR_REAR_MANUAL = 76;
                ConstAllAirDara.C_REAR_WIND_DOWN = 40;
                ConstAllAirDara.C_REAR_WIND_UP = 41;
                ConstAllAirDara.C_AIR_PARK = 78;
                ConstAllAirDara.C_CONTRAL = 4;
                break;
            case FinalCanbus.CAR_456_LZ_Xianddai_Screen /* 13631944 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CLEAN = 76;
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
                ConstAllAirDara.U_AIR_REAR_CTRL = 67;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_WIND_ADD = 2;
                ConstAllAirDara.C_AIR_WIND_SUB = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 6;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 7;
                ConstAllAirDara.C_AIR_MODE_BODY = 14;
                ConstAllAirDara.C_AIR_MODE_FOOT = 15;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 16;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 17;
                ConstAllAirDara.C_AIR_AC = 12;
                ConstAllAirDara.C_AIR_AUTO = 9;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 11;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 13;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 22;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 23;
                ConstAllAirDara.C_AIR_LEFT_COLD = 20;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 21;
                ConstAllAirDara.C_AIR_CYCLE = 18;
                ConstAllAirDara.C_CLEAN = 19;
                ConstAllAirDara.C_REAR_CTRL = 32;
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
        if (ConstAllAirDara.C_REAR_MODE_BODY_RIGHT != 255) {
            findViewById(R.id.view_sp_rear_blow_body_right).setVisibility(0);
            findViewById(R.id.air_sp_rear_blow_body_right).setVisibility(0);
            findViewById(R.id.air_sp_rear_blow_body_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_rear_blow_body_right).setVisibility(8);
            findViewById(R.id.view_sp_rear_blow_body_right).setVisibility(8);
        }
        if (ConstAllAirDara.C_REAR_MODE_FOOT_RIGHT != 255) {
            findViewById(R.id.view_sp_rear_blow_foot_right).setVisibility(0);
            findViewById(R.id.air_sp_rear_blow_foot_right).setVisibility(0);
            findViewById(R.id.air_sp_rear_blow_foot_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_rear_blow_foot_right).setVisibility(8);
            findViewById(R.id.view_sp_rear_blow_foot_right).setVisibility(8);
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
            findViewById(R.id.air_sp_front).setBackgroundResource(R.drawable.ic_hp_front_off);
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
        if (ConstAllAirDara.C_AIR_REAR_MODE_SUB != 255) {
            findViewById(R.id.air_sp_rear_blow_mode_minus).setVisibility(0);
            findViewById(R.id.view_sp_rear_blow_mode_minus).setVisibility(0);
            findViewById(R.id.air_sp_rear_blow_mode_minus).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_rear_blow_mode_minus).setVisibility(8);
            findViewById(R.id.view_sp_rear_blow_mode_minus).setVisibility(8);
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
        if (ConstAllAirDara.U_AIR_WAISTHEAT_LEFT != 255) {
            findViewById(R.id.air_sp_waistheat_left).setVisibility(0);
            findViewById(R.id.view_sp_waistheat_left).setVisibility(0);
            findViewById(R.id.air_sp_waistheat_left).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_waistheat_left).setVisibility(8);
            findViewById(R.id.view_sp_waistheat_left).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_SEATWAIST_LEFT != 255) {
            findViewById(R.id.air_xts_seatwaist_left).setVisibility(0);
            findViewById(R.id.view_sp_seatwaist_left).setVisibility(0);
            findViewById(R.id.air_xts_seatwaist_left).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_xts_seatwaist_left).setVisibility(8);
            findViewById(R.id.view_sp_seatwaist_left).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_SEATMASSAGE_LEFT != 255) {
            findViewById(R.id.air_xts_seatmassage_left).setVisibility(0);
            findViewById(R.id.view_sp_seatmassage_left).setVisibility(0);
            findViewById(R.id.air_xts_seatmassage_left).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_xts_seatmassage_left).setVisibility(8);
            findViewById(R.id.view_sp_seatmassage_left).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_WAISTHEAT_RIGHT != 255) {
            findViewById(R.id.air_sp_waistheat_right).setVisibility(0);
            findViewById(R.id.view_sp_waistheat_right).setVisibility(0);
            findViewById(R.id.air_sp_waistheat_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_waistheat_right).setVisibility(8);
            findViewById(R.id.view_sp_waistheat_right).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_SEATWAIST_RIGHT != 255) {
            findViewById(R.id.air_xts_seatwaist_right).setVisibility(0);
            findViewById(R.id.view_sp_seatwaist_right).setVisibility(0);
            findViewById(R.id.air_xts_seatwaist_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_xts_seatwaist_right).setVisibility(8);
            findViewById(R.id.view_sp_seatwaist_right).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_SEATMASSAGE_RIGHT != 255) {
            findViewById(R.id.air_xts_seatmassage_right).setVisibility(0);
            findViewById(R.id.view_sp_seatmassage_right).setVisibility(0);
            findViewById(R.id.air_xts_seatmassage_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_xts_seatmassage_right).setVisibility(8);
            findViewById(R.id.view_sp_seatmassage_right).setVisibility(8);
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
            case FinalCanbus.CAR_455_Tangdu_Nissan_10PATROL_L /* 4260295 */:
            case FinalCanbus.CAR_455_Tangdu_Nissan_22PATROL_Armada /* 10224071 */:
            case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_L /* 13763014 */:
            case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_H /* 13828550 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER /* 15139270 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER_H /* 15532486 */:
                return false;
            default:
                return true;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        if (ConstAllAirDara.JumpNewRearAir) {
            this.pagenum = 1;
            findViewById(R.id.veiw_air_front).setVisibility(8);
            findViewById(R.id.veiw_air_rear).setVisibility(0);
            ((TextView) findViewById(R.id.tv_sp_front)).setTextColor(Color.parseColor("#ffffff"));
            ((TextView) findViewById(R.id.tv_sp_rear)).setTextColor(Color.parseColor("#d5a45e"));
            if (ConstAllAirDara.U_AIR_BACK_POWER != 255) {
                mUpdatePower();
            } else {
                mUpdateBackWind();
            }
        }
        initCallbackId();
        init();
        addUpdater();
        if (IsdisableAirWindow()) {
            AirHelper.disableAirWindowLocal(true);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        if (IsdisableAirWindow()) {
            AirHelper.disableAirWindowLocal(false);
        }
        removeUpdater();
        ConstAllAirDara.JumpNewAir = false;
        ConstAllAirDara.JumpNewRearAir = false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int data0;
        int id = v.getId();
        int data1 = 255;
        switch (id) {
            case R.id.tv_sp_front /* 2131427507 */:
                this.pagenum = 0;
                findViewById(R.id.veiw_air_front).setVisibility(0);
                findViewById(R.id.veiw_air_rear).setVisibility(8);
                ((TextView) findViewById(R.id.tv_sp_front)).setTextColor(Color.parseColor("#d5a45e"));
                ((TextView) findViewById(R.id.tv_sp_rear)).setTextColor(Color.parseColor("#ffffff"));
                if (ConstAllAirDara.U_AIR_POWER != 255) {
                    mUpdatePower();
                } else {
                    mUpdaterAirWindLevelLeft();
                }
                break;
            case R.id.tv_sp_rear /* 2131427508 */:
                this.pagenum = 1;
                findViewById(R.id.veiw_air_front).setVisibility(8);
                findViewById(R.id.veiw_air_rear).setVisibility(0);
                ((TextView) findViewById(R.id.tv_sp_front)).setTextColor(Color.parseColor("#ffffff"));
                ((TextView) findViewById(R.id.tv_sp_rear)).setTextColor(Color.parseColor("#d5a45e"));
                if (ConstAllAirDara.U_AIR_BACK_POWER != 255) {
                    mUpdatePower();
                } else {
                    mUpdateBackWind();
                }
                break;
            case R.id.air_sp_temp_left_plus /* 2131427510 */:
                data1 = ConstAllAirDara.C_AIR_TEMP_LEFT_ADD;
                break;
            case R.id.air_sp_temp_left_munits /* 2131427511 */:
                data1 = ConstAllAirDara.C_AIR_TEMP_LEFT_SUB;
                break;
            case R.id.air_sp_blow_mode_minus /* 2131427512 */:
                data1 = ConstAllAirDara.C_AIR_MODE_SUB;
                break;
            case R.id.air_sp_blow_mode_plus /* 2131427513 */:
                data1 = ConstAllAirDara.C_AIR_MODE_ADD;
                break;
            case R.id.air_sp_wind_minuts /* 2131427514 */:
                data1 = ConstAllAirDara.C_AIR_WIND_SUB;
                break;
            case R.id.air_sp_wind_plus /* 2131427516 */:
                data1 = ConstAllAirDara.C_AIR_WIND_ADD;
                break;
            case R.id.air_sp_temp_right_plus /* 2131427517 */:
                data1 = ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD;
                break;
            case R.id.air_sp_temp_right_munits /* 2131427518 */:
                data1 = ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB;
                break;
            case R.id.air_sp_seatheat_left /* 2131427519 */:
                data1 = ConstAllAirDara.C_AIR_LEFT_HEAT;
                break;
            case R.id.air_sp_seatwind_left /* 2131427520 */:
                data1 = ConstAllAirDara.C_AIR_LEFT_COLD;
                break;
            case R.id.air_sp_flowerblow /* 2131427521 */:
                data1 = ConstAllAirDara.C_AIR_FLOWER_BLOW;
                break;
            case R.id.air_sp_power /* 2131427522 */:
                data1 = this.pagenum == 1 ? ConstAllAirDara.C_REAR_OFF : ConstAllAirDara.C_AIR_POWER;
                break;
            case R.id.air_sp_eco /* 2131427523 */:
                data1 = ConstAllAirDara.C_AIR_ECO;
                break;
            case R.id.air_sp_seatwind_right /* 2131427524 */:
                data1 = ConstAllAirDara.C_AIR_RIGHT_COLD;
                break;
            case R.id.air_sp_seatheat_right /* 2131427525 */:
                data1 = ConstAllAirDara.C_AIR_RIGHT_HEAT;
                break;
            case R.id.air_sp_dual /* 2131427526 */:
                data1 = ConstAllAirDara.C_AIR_DUAL;
                break;
            case R.id.air_sp_front /* 2131427527 */:
                data1 = ConstAllAirDara.C_AIR_FRONT_DEFROST;
                break;
            case R.id.air_sp_auto /* 2131427528 */:
                data1 = ConstAllAirDara.C_AIR_AUTO;
                break;
            case R.id.air_sp_ac /* 2131427529 */:
                data1 = ConstAllAirDara.C_AIR_AC;
                break;
            case R.id.air_sp_rear /* 2131427530 */:
                data1 = ConstAllAirDara.C_AIR_REAR_DEFROST;
                break;
            case R.id.air_sp_cycle /* 2131427531 */:
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_452_XC_Tianlai_GJ /* 65988 */:
                    case FinalCanbus.CAR_453_XC_Tianlai_GJ /* 1442245 */:
                    case FinalCanbus.CAR_439_HC_Nissan_GuiShi /* 7799223 */:
                        data1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1 ? 3 : 2;
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
                    case FinalCanbus.CAR_BNR_NISSAN_14QiJun_RS /* 1376580 */:
                    case FinalCanbus.CAR_BNR_NISSAN_14QiJun_RS_L /* 1442116 */:
                    case FinalCanbus.CAR_452_XinCheng_Infiniti_ESQ /* 1573316 */:
                    case FinalCanbus.CAR_452_XinCheng_Infiniti_13Q70L /* 2032068 */:
                    case FinalCanbus.CAR_452_XinCheng_Nissan_Tule_H /* 5112260 */:
                    case FinalCanbus.CAR_452_XinCheng_Nissan_Tule_Top /* 7078343 */:
                    case FinalCanbus.CAR_455_XinCheng_Nissan_20Tule_H /* 11665863 */:
                        data1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1 ? 35 : 34;
                        break;
                    case FinalCanbus.CAR_455_OD_Zhongtai_E200 /* 786887 */:
                        data1 = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1 ? 26 : 25;
                        break;
                    default:
                        data1 = ConstAllAirDara.C_AIR_CYCLE;
                        break;
                }
                break;
            case R.id.air_sp_temp_rearleft_plus /* 2131427533 */:
                data1 = ConstAllAirDara.C_REAR_LEFT_TEMP_UP;
                break;
            case R.id.air_sp_rear_blow_changer /* 2131427536 */:
                data1 = ConstAllAirDara.C_REAR_MODE;
                break;
            case R.id.air_sp_rear_wind_minuts /* 2131427537 */:
                data1 = ConstAllAirDara.C_REAR_WIND_DOWN;
                break;
            case R.id.air_sp_rear_wind_plus /* 2131427539 */:
                data1 = ConstAllAirDara.C_REAR_WIND_UP;
                break;
            case R.id.air_sp_temp_rearright_plus /* 2131427540 */:
                data1 = ConstAllAirDara.C_REAR_RIGHT_TEMP_UP;
                break;
            case R.id.air_sp_temp_rearright_minus /* 2131427542 */:
                data1 = ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN;
                break;
            case R.id.air_sp_rearlock_rear /* 2131427543 */:
                data1 = ConstAllAirDara.C_REAR_LOCK;
                break;
            case R.id.air_sp_auto_rear /* 2131427545 */:
                data1 = ConstAllAirDara.C_REAR_AUTO;
                break;
            case R.id.air_sp_blow_foot /* 2131428070 */:
                data1 = ConstAllAirDara.C_AIR_MODE_FOOT;
                break;
            case R.id.air_sp_blow_body /* 2131428071 */:
                data1 = ConstAllAirDara.C_AIR_MODE_BODY;
                break;
            case R.id.air_sp_blow_body_foot /* 2131428072 */:
                data1 = ConstAllAirDara.C_AIR_MODE_BODYFOOT;
                break;
            case R.id.air_sp_blow_foot_win /* 2131428073 */:
                data1 = ConstAllAirDara.C_AIR_MODE_UPFOOT;
                break;
            case R.id.air_sp_acmax /* 2131428074 */:
                data1 = ConstAllAirDara.C_AIR_AC_MAX;
                break;
            case R.id.air_sp_steer /* 2131428075 */:
                data1 = ConstAllAirDara.C_AIR_STEER;
                break;
            case R.id.air_sp_sync /* 2131428076 */:
                data1 = ConstAllAirDara.C_AIR_SYNC;
                break;
            case R.id.air_sp_rear_blow_body_foot /* 2131428077 */:
                data1 = ConstAllAirDara.C_REAR_MODE_BODY_FOOT;
                break;
            case R.id.air_sp_rear_blow_foot /* 2131428078 */:
                data1 = ConstAllAirDara.C_REAR_MODE_FOOT;
                break;
            case R.id.air_sp_rear_blow_body /* 2131428079 */:
                data1 = ConstAllAirDara.C_REAR_MODE_BODY;
                break;
            case R.id.air_sp_sync_rear /* 2131428080 */:
                data1 = ConstAllAirDara.C_REAR_SYNC;
                break;
            case R.id.air_xts_seatmassage_left /* 2131428246 */:
                data1 = ConstAllAirDara.C_AIR_LEFT_MASSAGE;
                break;
            case R.id.air_xts_seatwaist_left /* 2131428247 */:
                data1 = ConstAllAirDara.C_AIR_LEFT_WAIST;
                break;
            case R.id.air_xts_seatwaist_right /* 2131428249 */:
                data1 = ConstAllAirDara.C_AIR_RIGHT_WAIST;
                break;
            case R.id.air_xts_seatmassage_right /* 2131428250 */:
                data1 = ConstAllAirDara.C_AIR_RIGHT_MASSAGE;
                break;
            case R.id.air_sp_mode_change /* 2131428559 */:
            case R.id.air_sp_blow_changer /* 2131428693 */:
                data1 = ConstAllAirDara.C_AIR_MODE_CHANGER;
                break;
            case R.id.air_sp_blow_win /* 2131428563 */:
                data1 = ConstAllAirDara.C_AIR_MODE_UP;
                break;
            case R.id.air_sp_frontmax /* 2131428650 */:
                data1 = ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST;
                break;
            case R.id.air_sp_nanoe /* 2131428694 */:
                data1 = ConstAllAirDara.C_AIR_NANOE;
                break;
            case R.id.air_sp_seatwind_left_rear /* 2131428695 */:
                data1 = ConstAllAirDara.C_AIR_LEFT_COLD_REAR;
                break;
            case R.id.air_sp_seatheat_left_rear /* 2131428696 */:
                data1 = ConstAllAirDara.C_AIR_LEFT_HEAT_REAR;
                break;
            case R.id.air_sp_seatheat_right_rear /* 2131428697 */:
                data1 = ConstAllAirDara.C_AIR_RIGHT_HEAT_REAR;
                break;
            case R.id.air_sp_seatwind_right_rear /* 2131428698 */:
                data1 = ConstAllAirDara.C_AIR_RIGHT_COLD_REAR;
                break;
            case R.id.air_sp_ac_rear /* 2131428700 */:
                data1 = ConstAllAirDara.C_REAR_AC;
                break;
            case R.id.air_sp_onlyfront_front /* 2131428752 */:
                data1 = ConstAllAirDara.C_AIR_FRONT_ONLY_F;
                break;
            case R.id.air_sp_fronthot /* 2131428753 */:
                data1 = ConstAllAirDara.C_AIR_FRONT_HOT;
                break;
            case R.id.air_sp_auto_right /* 2131429376 */:
                data1 = ConstAllAirDara.C_AIR_AUTO_RIGHT;
                break;
            case R.id.air_sp_blow_win_right /* 2131429397 */:
                data1 = ConstAllAirDara.C_AIR_MODE_UP_RIGHT;
                break;
            case R.id.air_sp_blow_body_right /* 2131429398 */:
                data1 = ConstAllAirDara.C_AIR_MODE_BODY_RIGHT;
                break;
            case R.id.air_sp_blow_foot_right /* 2131429399 */:
                data1 = ConstAllAirDara.C_AIR_MODE_FOOT_RIGHT;
                break;
            case R.id.air_sp_car_rear /* 2131429400 */:
                data1 = ConstAllAirDara.C_REAR_CTRL;
                break;
            case R.id.air_sp_aqs /* 2131429401 */:
                data1 = ConstAllAirDara.C_AIR_AQS;
                break;
            case R.id.air_sp_rest /* 2131429402 */:
                data1 = ConstAllAirDara.C_AIR_REST;
                break;
            case R.id.air_sp_waistheat_left /* 2131429406 */:
                data1 = ConstAllAirDara.C_AIR_WAISTLEFT_HEAT;
                break;
            case R.id.air_sp_ptc /* 2131429411 */:
                data1 = ConstAllAirDara.C_AIR_PTC;
                break;
            case R.id.air_sp_em /* 2131429413 */:
                data1 = ConstAllAirDara.C_AIR_EM;
                break;
            case R.id.air_sp_airpark /* 2131429420 */:
                data1 = ConstAllAirDara.C_AIR_PARK;
                break;
            case R.id.air_sp_ion /* 2131429425 */:
                data1 = ConstAllAirDara.C_AIR_ION;
                break;
            case R.id.air_sp_soft /* 2131429427 */:
                data1 = ConstAllAirDara.C_SOFT;
                break;
            case R.id.air_sp_fast /* 2131429429 */:
                data1 = ConstAllAirDara.C_FAST;
                break;
            case R.id.air_sp_normal /* 2131429431 */:
                data1 = ConstAllAirDara.C_NORMAL;
                break;
            case R.id.air_sp_clean /* 2131429433 */:
                data1 = ConstAllAirDara.C_CLEAN;
                break;
            case R.id.air_sp_blowtop /* 2131429436 */:
                data1 = ConstAllAirDara.C_AIR_BLOWTOP;
                break;
            case R.id.air_sp_zone /* 2131429439 */:
                data1 = ConstAllAirDara.C_AIR_ZONE;
                break;
            case R.id.air_sp_swing /* 2131429444 */:
                data1 = ConstAllAirDara.C_AIR_SWING;
                break;
            case R.id.air_sp_winlev /* 2131429447 */:
                data1 = ConstAllAirDara.C_AIR_WINLEV;
                break;
            case R.id.air_sp_heat /* 2131429450 */:
                data1 = ConstAllAirDara.C_AIR_HEAT;
                break;
            case R.id.air_sp_waistheat_right /* 2131429455 */:
                data1 = ConstAllAirDara.C_AIR_WAISTRIGHT_HEAT;
                break;
            case R.id.air_sp_blow_changer_center /* 2131429469 */:
                data1 = ConstAllAirDara.C_AIR_MODE_CENTER;
                break;
            case R.id.air_sp_blow_changer_right /* 2131429472 */:
                data1 = ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT;
                break;
            case R.id.air_sp_rear_manual /* 2131429477 */:
                data1 = ConstAllAirDara.C_AIR_REAR_MANUAL;
                break;
            case R.id.air_sp_rear_cool /* 2131429479 */:
                data1 = ConstAllAirDara.C_REAR_COOL;
                break;
            case R.id.air_sp_onlyfront /* 2131429481 */:
                data1 = ConstAllAirDara.C_AIR_FRONT_ONLY;
                break;
            case R.id.air_sp_auto_rear_right /* 2131429486 */:
                data1 = ConstAllAirDara.C_REAR_AUTO_RIGHT;
                break;
            case R.id.air_sp_temp_rearleft_minus /* 2131429493 */:
                data1 = ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN;
                break;
            case R.id.air_sp_rear_blow_mode_minus /* 2131429504 */:
                data1 = ConstAllAirDara.C_AIR_REAR_MODE_SUB;
                break;
            case R.id.air_sp_rear_blow_changer_right /* 2131429509 */:
                data1 = ConstAllAirDara.C_REAR_MODE_RIGHT;
                break;
        }
        if (data1 == ConstAllAirDara.C_AIR_CYCLE) {
            if (event.getAction() == 0) {
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_WC2_GMC_Terrain_10_NoAir /* 7340068 */:
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            data0 = 49;
                        } else {
                            data0 = 48;
                        }
                        sendCmd(data0, 1);
                        SystemClock.sleep(100L);
                        sendCmd(data0, 0);
                        break;
                    default:
                        if (data1 != 255) {
                            sendCmd(data1, 1);
                        }
                        break;
                }
            } else if (event.getAction() == 1) {
                switch (DataCanbus.DATA[1000]) {
                    default:
                        if (data1 != 255) {
                            sendCmd(data1, 0);
                            break;
                        }
                    case FinalCanbus.CAR_WC2_GMC_Terrain_10_NoAir /* 7340068 */:
                        return false;
                }
            }
        } else if (event.getAction() == 0) {
            if (data1 != 255) {
                sendCmd(data1, 1);
            }
        } else if (event.getAction() == 1 && data1 != 255) {
            sendCmd(data1, 0);
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
        if (ConstAllAirDara.U_AIR_WAISTHEAT_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_WAISTHEAT_LEFT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_SEATWAIST_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATWAIST_LEFT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_SEATMASSAGE_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATMASSAGE_LEFT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_WAISTHEAT_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_WAISTHEAT_RIGHT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_SEATWAIST_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATWAIST_RIGHT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_SEATMASSAGE_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATMASSAGE_RIGHT].addNotify(this.mNotifyCanbus, 1);
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
        if (ConstAllAirDara.U_AIR_WAISTHEAT_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_WAISTHEAT_LEFT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_SEATWAIST_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATWAIST_LEFT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_SEATMASSAGE_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATMASSAGE_LEFT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_WAISTHEAT_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_WAISTHEAT_RIGHT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_SEATWAIST_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATWAIST_RIGHT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_SEATMASSAGE_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATMASSAGE_RIGHT].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirHeat() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_HEAT];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_456_OD_Hongqi_H5 /* 65992 */:
            case FinalCanbus.CAR_455_CZH_OD_Hongqi_EQM5_Huandian /* 7274951 */:
            case FinalCanbus.CAR_454_CZH_OD_Hongqi_EQM5 /* 16515526 */:
                findViewById(R.id.air_sp_heat).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_naturalwin_n : R.drawable.ic_hp_naturalwin_p);
                break;
            default:
                findViewById(R.id.air_sp_heat).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_heat_n : R.drawable.ic_hp_heat_p);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirPTC() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_PTC];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_453_OD_WeiMa_EX5 /* 6226373 */:
                switch (vel) {
                    case 0:
                        findViewById(R.id.air_sp_ptc).setBackgroundResource(R.drawable.ic_hp_soft_p);
                        break;
                    case 1:
                        findViewById(R.id.air_sp_ptc).setBackgroundResource(R.drawable.ic_hp_eco_p);
                        break;
                    case 2:
                        findViewById(R.id.air_sp_ptc).setBackgroundResource(R.drawable.ic_hp_naturalwin_p);
                        break;
                }
                break;
            default:
                findViewById(R.id.air_sp_ptc).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_ptc_n : R.drawable.ic_hp_ptc_p);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSteerHot() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_STEER];
        findViewById(R.id.air_sp_steer).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_steerhot_n : R.drawable.ic_hp_steerhot_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateClean() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_CLEAN];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_452_XinCheng_Infiniti_14QX70 /* 1966532 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_13Q70L /* 2032068 */:
            case FinalCanbus.CAR_452_XinCheng_Nissan_Tule_H /* 5112260 */:
            case FinalCanbus.CAR_452_XinCheng_Nissan_Tule_Top /* 7078343 */:
            case FinalCanbus.CAR_455_XinCheng_Nissan_20Tule_H /* 11665863 */:
                findViewById(R.id.air_sp_clean).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_forest_n : R.drawable.ic_hp_forest_p);
                break;
            default:
                findViewById(R.id.air_sp_clean).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_clean_n : R.drawable.ic_hp_clean_p);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateIon() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_ION];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_456_OUDI_Xugong_Qingka /* 12583368 */:
                findViewById(R.id.air_sp_ion).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_rearcool_n : R.drawable.ic_hp_rearcool_p);
                break;
            default:
                findViewById(R.id.air_sp_ion).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_ion_n : R.drawable.ic_hp_ion_p);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBlowTop() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOWTOP];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_446_WY_HCX_BYD_TANG_Screen /* 1049022 */:
                findViewById(R.id.air_sp_blowtop).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_ventilation_n : R.drawable.ic_hp_ventilation_p);
                break;
            default:
                findViewById(R.id.air_sp_blowtop).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_blowtop_n : R.drawable.ic_hp_blowtop_p);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcMax() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC_MAX];
        findViewById(R.id.air_sp_acmax).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_acmax_n : R.drawable.ic_hp_acmax_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirNormal() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_NORMAL];
        findViewById(R.id.air_sp_normal).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_normal_n : R.drawable.ic_hp_normal_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirFast() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_FAST];
        findViewById(R.id.air_sp_fast).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_fast_n : R.drawable.ic_hp_fast_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirSoft() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SOFT];
        findViewById(R.id.air_sp_soft).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_soft_n : R.drawable.ic_hp_soft_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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
                case FinalCanbus.CAR_439_OuDi_Haval_H9 /* 1376695 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                case FinalCanbus.CAR_455_OD_Haval_H7 /* 12124615 */:
                case FinalCanbus.CAR_455_OD_Haval_H7_H /* 12190151 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_RS /* 15598007 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                case FinalCanbus.CAR_452_OD_Haval_VV5 /* 16122308 */:
                case FinalCanbus.CAR_452_OD_Haval_VV6 /* 16187844 */:
                case FinalCanbus.CAR_452_OD_Haval_VV7 /* 16253380 */:
                case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                    temp = ((temp - 116) * 5) + 160;
                    break;
                case FinalCanbus.CAR_RZC_Haval_H9 /* 2490807 */:
                case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                case FinalCanbus.CAR_452_RZC_Haval_H9_Low /* 8651204 */:
                case FinalCanbus.CAR_454_RZC_Haval_H8_15 /* 11796934 */:
                case FinalCanbus.CAR_454_RZC_Haval_H8_15_H /* 11862470 */:
                    temp = ((temp - 112) * 5) + 160;
                    break;
                case FinalCanbus.CAR_439_BNR_HAVAL_H9 /* 16384439 */:
                    temp = (temp * 5) + 160;
                    break;
            }
            mUpdateTempValue(R.id.air_sp_temp_rearleft1, temp / 100, false);
            mUpdateTempValue(R.id.air_sp_temp_rearleft2, (temp % 100) / 10, false);
            mUpdateTempValue(R.id.air_sp_temp_rearleft3, temp % 10, true);
            mUpdateTempUNIT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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
                case FinalCanbus.CAR_439_OuDi_Haval_H9 /* 1376695 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                case FinalCanbus.CAR_455_OD_Haval_H7 /* 12124615 */:
                case FinalCanbus.CAR_455_OD_Haval_H7_H /* 12190151 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_RS /* 15598007 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                case FinalCanbus.CAR_452_OD_Haval_VV5 /* 16122308 */:
                case FinalCanbus.CAR_452_OD_Haval_VV6 /* 16187844 */:
                case FinalCanbus.CAR_452_OD_Haval_VV7 /* 16253380 */:
                case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                    temp = ((temp - 116) * 5) + 160;
                    break;
                case FinalCanbus.CAR_RZC_Haval_H9 /* 2490807 */:
                case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                case FinalCanbus.CAR_452_RZC_Haval_H9_Low /* 8651204 */:
                case FinalCanbus.CAR_454_RZC_Haval_H8_15 /* 11796934 */:
                case FinalCanbus.CAR_454_RZC_Haval_H8_15_H /* 11862470 */:
                    temp = ((temp - 112) * 5) + 160;
                    break;
                case FinalCanbus.CAR_439_BNR_HAVAL_H9 /* 16384439 */:
                    temp = (temp * 5) + 160;
                    break;
            }
            mUpdateTempValue(R.id.air_sp_temp_rearright1, temp / 100, false);
            mUpdateTempValue(R.id.air_sp_temp_rearright2, (temp % 100) / 10, false);
            mUpdateTempValue(R.id.air_sp_temp_rearright3, temp % 10, true);
            mUpdateTempUNIT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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
                case FinalCanbus.CAR_RZC_XP1_ChuanQi_AION_23ES /* 2359576 */:
                case FinalCanbus.CAR_RZC_XP1_ChuanQi_AIRTREKEV_22 /* 2425112 */:
                case FinalCanbus.CAR_RZC_XP1_ChuanQi_AION_23ES_R /* 2490648 */:
                case FinalCanbus.CAR_RZC_OD_AION_EV_25 /* 2556184 */:
                    temp /= 10;
                    break;
                case FinalCanbus.CAR_439_OuDi_Haval_H9 /* 1376695 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                case FinalCanbus.CAR_455_OD_Haval_H7 /* 12124615 */:
                case FinalCanbus.CAR_455_OD_Haval_H7_H /* 12190151 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_RS /* 15598007 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                case FinalCanbus.CAR_452_OD_Haval_VV5 /* 16122308 */:
                case FinalCanbus.CAR_452_OD_Haval_VV6 /* 16187844 */:
                case FinalCanbus.CAR_452_OD_Haval_VV7 /* 16253380 */:
                case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                    temp = ((temp - 116) * 5) + 160;
                    break;
                case FinalCanbus.CAR_RZC_Haval_H9 /* 2490807 */:
                case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                case FinalCanbus.CAR_452_RZC_Haval_H9_Low /* 8651204 */:
                case FinalCanbus.CAR_454_RZC_Haval_H8_15 /* 11796934 */:
                case FinalCanbus.CAR_454_RZC_Haval_H8_15_H /* 11862470 */:
                case FinalCanbus.CAR_439_BNR_HAVAL_H9 /* 16384439 */:
                    temp = ((temp - 112) * 5) + 160;
                    break;
                case FinalCanbus.CAR_456_DJ_Haval_Screen_VV5 /* 3473864 */:
                case FinalCanbus.CAR_456_DJ_Haval_Screen_VV6 /* 3539400 */:
                case FinalCanbus.CAR_456_DJ_Haval_Screen_VV7 /* 3604936 */:
                case FinalCanbus.CAR_439_DJ_Haval_H8 /* 10420663 */:
                case FinalCanbus.CAR_439_DJ_Haval_H8_H /* 10486199 */:
                case FinalCanbus.CAR_439_DJ_Haval_H9 /* 15794628 */:
                case FinalCanbus.CAR_439_DJ_Haval_H9_H /* 15860164 */:
                case FinalCanbus.CAR_439_DJ_Haval_VV5 /* 15925700 */:
                case FinalCanbus.CAR_439_DJ_Haval_VV6 /* 15991236 */:
                case FinalCanbus.CAR_439_DJ_Haval_VV7 /* 16056772 */:
                    temp = (temp * 5) + 160;
                    break;
                case FinalCanbus.CAR_443_WC_12Cedric_CD /* 7143867 */:
                case FinalCanbus.CAR_443_WC_12Cedric /* 7209403 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (((temp * 9) + 320) / 10) * 10;
                    } else {
                        temp *= 5;
                    }
                    break;
                case FinalCanbus.CAR_456_OD_Changan_KuayueXT_S5 /* 8520136 */:
                    temp *= 10;
                    findViewById(R.id.air_sp_tempvalue_left).setVisibility(8);
                    findViewById(R.id.air_sp_tempunit_left).setVisibility(8);
                    findViewById(R.id.air_sp_tempstate_left).setVisibility(0);
                    mUpdateTempValue(R.id.air_sp_tempstate_left, (temp % 100) / 10, false);
                    break;
            }
            mUpdateTempValue(R.id.air_sp_temp_left1, temp / 100, false);
            mUpdateTempValue(R.id.air_sp_temp_left2, (temp % 100) / 10, false);
            mUpdateTempValue(R.id.air_sp_temp_left3, temp % 10, true);
            mUpdateTempUNIT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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
                case FinalCanbus.CAR_RZC_XP1_ChuanQi_AION_23ES /* 2359576 */:
                case FinalCanbus.CAR_RZC_XP1_ChuanQi_AIRTREKEV_22 /* 2425112 */:
                case FinalCanbus.CAR_RZC_XP1_ChuanQi_AION_23ES_R /* 2490648 */:
                case FinalCanbus.CAR_RZC_OD_AION_EV_25 /* 2556184 */:
                    temp /= 10;
                    break;
                case FinalCanbus.CAR_439_OuDi_Haval_H9 /* 1376695 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                case FinalCanbus.CAR_455_OD_Haval_H7 /* 12124615 */:
                case FinalCanbus.CAR_455_OD_Haval_H7_H /* 12190151 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_RS /* 15598007 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                case FinalCanbus.CAR_452_OD_Haval_VV5 /* 16122308 */:
                case FinalCanbus.CAR_452_OD_Haval_VV6 /* 16187844 */:
                case FinalCanbus.CAR_452_OD_Haval_VV7 /* 16253380 */:
                case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                    temp = ((temp - 116) * 5) + 160;
                    break;
                case FinalCanbus.CAR_RZC_Haval_H9 /* 2490807 */:
                case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                case FinalCanbus.CAR_452_RZC_Haval_H9_Low /* 8651204 */:
                case FinalCanbus.CAR_454_RZC_Haval_H8_15 /* 11796934 */:
                case FinalCanbus.CAR_454_RZC_Haval_H8_15_H /* 11862470 */:
                case FinalCanbus.CAR_439_BNR_HAVAL_H9 /* 16384439 */:
                    temp = ((temp - 112) * 5) + 160;
                    break;
                case FinalCanbus.CAR_456_DJ_Haval_Screen_VV5 /* 3473864 */:
                case FinalCanbus.CAR_456_DJ_Haval_Screen_VV6 /* 3539400 */:
                case FinalCanbus.CAR_456_DJ_Haval_Screen_VV7 /* 3604936 */:
                case FinalCanbus.CAR_439_DJ_Haval_H8 /* 10420663 */:
                case FinalCanbus.CAR_439_DJ_Haval_H8_H /* 10486199 */:
                case FinalCanbus.CAR_439_DJ_Haval_H9 /* 15794628 */:
                case FinalCanbus.CAR_439_DJ_Haval_H9_H /* 15860164 */:
                case FinalCanbus.CAR_439_DJ_Haval_VV5 /* 15925700 */:
                case FinalCanbus.CAR_439_DJ_Haval_VV6 /* 15991236 */:
                case FinalCanbus.CAR_439_DJ_Haval_VV7 /* 16056772 */:
                    temp = (temp * 5) + 160;
                    break;
                case FinalCanbus.CAR_443_WC_12Cedric_CD /* 7143867 */:
                case FinalCanbus.CAR_443_WC_12Cedric /* 7209403 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (((temp * 9) + 320) / 10) * 10;
                    } else {
                        temp *= 5;
                    }
                    break;
                case FinalCanbus.CAR_456_OD_Changan_KuayueXT_S5 /* 8520136 */:
                    temp *= 10;
                    findViewById(R.id.air_sp_tempvalue_right).setVisibility(8);
                    findViewById(R.id.air_sp_tempunit_right).setVisibility(8);
                    findViewById(R.id.air_sp_tempstate_right).setVisibility(0);
                    mUpdateTempValue(R.id.air_sp_tempstate_right, (temp % 100) / 10, false);
                    break;
            }
            mUpdateTempValue(R.id.air_sp_temp_right1, temp / 100, false);
            mUpdateTempValue(R.id.air_sp_temp_right2, (temp % 100) / 10, false);
            mUpdateTempValue(R.id.air_sp_temp_right3, temp % 10, true);
            mUpdateTempUNIT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTempUNIT() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT];
        if (ConstAllAirDara.U_AIR_TEMP_UNIT != 255) {
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_454_Sanwu_Nissan_QX56_2004_Auto /* 3473862 */:
                    if (vel == 1 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                        findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                        findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                        findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                    } else {
                        findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                    }
                    break;
                default:
                    if (vel == 1 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                        findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                        findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                        findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                    } else {
                        findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                    }
                    break;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBackAuto() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_AUTO];
        findViewById(R.id.air_sp_auto_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_auto_n : R.drawable.ic_hp_auto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBackAutoRight() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_AUTO_RIGHT];
        findViewById(R.id.air_sp_auto_rear_right).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_auto_n : R.drawable.ic_hp_auto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBackRearLock() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_LOCK];
        findViewById(R.id.air_sp_rearlock_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_rearlight_n : R.drawable.ic_hp_rearlight_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBackRearSync() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_SYNC];
        findViewById(R.id.air_sp_sync_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_sync_n : R.drawable.ic_hp_sync_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBackRearAC() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_AC];
        findViewById(R.id.air_sp_ac_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_ac_n : R.drawable.ic_hp_ac_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBackRearCtrl() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_CTRL];
        findViewById(R.id.air_sp_car_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_rearlight_n : R.drawable.ic_hp_rearlight_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirEm() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_EM];
        findViewById(R.id.air_sp_em).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_em_n : R.drawable.ic_hp_em_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBackWind() {
        int leave = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_WIND];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_452_XC_Rongwei_ALl /* 7471556 */:
            case FinalCanbus.CAR_456_OUDI_BYD_ALL_SONGMAX /* 12517832 */:
                ((TextView) findViewById(R.id.air_sp_rear_wind_txt)).setText(new StringBuilder().append(leave).toString());
                ((ProgressBar) findViewById(R.id.air_sp_rear_wind_lev)).setMax(4);
                break;
            case FinalCanbus.CAR_456_OUDI_Dayun_YuanzhiM1 /* 12845512 */:
                ((TextView) findViewById(R.id.air_sp_rear_wind_txt)).setText(new StringBuilder().append(leave).toString());
                ((ProgressBar) findViewById(R.id.air_sp_rear_wind_lev)).setMax(6);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int value = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
        ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(value).toString());
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_446_WC2_Futon_FengjingI9_25 /* 721342 */:
            case FinalCanbus.CAR_446_WC2_Futon_Kawen_25 /* 786878 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9 /* 1376695 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
            case FinalCanbus.CAR_RZC_Haval_H9 /* 2490807 */:
            case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
            case FinalCanbus.CAR_456_DJ_Haval_Screen_VV5 /* 3473864 */:
            case FinalCanbus.CAR_446_WC2_Futon_TuyanuoDaV_24_Auto /* 3539390 */:
            case FinalCanbus.CAR_456_DJ_Haval_Screen_VV6 /* 3539400 */:
            case FinalCanbus.CAR_446_WC2_Futon_TuyanuoDaV_24_Hand /* 3604926 */:
            case FinalCanbus.CAR_456_DJ_Haval_Screen_VV7 /* 3604936 */:
            case FinalCanbus.CAR_452_RZC_Haval_H9_Low /* 8651204 */:
            case FinalCanbus.CAR_439_DJ_Haval_H8 /* 10420663 */:
            case FinalCanbus.CAR_439_DJ_Haval_H8_H /* 10486199 */:
            case FinalCanbus.CAR_454_RZC_Haval_H8_15 /* 11796934 */:
            case FinalCanbus.CAR_454_RZC_Haval_H8_15_H /* 11862470 */:
            case FinalCanbus.CAR_455_OD_Haval_H7 /* 12124615 */:
            case FinalCanbus.CAR_455_OD_Haval_H7_H /* 12190151 */:
            case FinalCanbus.CAR_456_CZH_Xiandai_All_L /* 13304264 */:
            case FinalCanbus.CAR_456_CZH_Xiandai_All_H /* 13369800 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_RS /* 15598007 */:
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
            case FinalCanbus.CAR_439_BNR_HAVAL_H9 /* 16384439 */:
            case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
            case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(value).toString());
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(8);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateWaistHeatLeft() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_WAISTHEAT_LEFT];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_waistheat_left).setBackgroundResource(R.drawable.ic_hp_waisthot_left_0);
                break;
            case 1:
                findViewById(R.id.air_sp_waistheat_left).setBackgroundResource(R.drawable.ic_hp_waisthot_left_1);
                break;
            case 2:
                findViewById(R.id.air_sp_waistheat_left).setBackgroundResource(R.drawable.ic_hp_waisthot_left_2);
                break;
            case 3:
                findViewById(R.id.air_sp_waistheat_left).setBackgroundResource(R.drawable.ic_hp_waisthot_left_3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSeatWaistLeft() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWAIST_LEFT];
        switch (vel) {
            case 0:
                findViewById(R.id.air_xts_seatwaist_left).setBackgroundResource(R.drawable.ic_hp_seatwaist_left_0);
                break;
            case 1:
                findViewById(R.id.air_xts_seatwaist_left).setBackgroundResource(R.drawable.ic_hp_seatwaist_left_1);
                break;
            case 2:
                findViewById(R.id.air_xts_seatwaist_left).setBackgroundResource(R.drawable.ic_hp_seatwaist_left_2);
                break;
            case 3:
                findViewById(R.id.air_xts_seatwaist_left).setBackgroundResource(R.drawable.ic_hp_seatwaist_left_3);
                break;
            case 4:
                findViewById(R.id.air_xts_seatwaist_left).setBackgroundResource(R.drawable.ic_hp_seatwaist_left_4);
                break;
            case 5:
                findViewById(R.id.air_xts_seatwaist_left).setBackgroundResource(R.drawable.ic_hp_seatwaist_left_5);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSeatMassageLeft() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATMASSAGE_LEFT];
        switch (vel) {
            case 0:
                findViewById(R.id.air_xts_seatmassage_left).setBackgroundResource(R.drawable.ic_hp_seatmassage_left_0);
                break;
            case 1:
                findViewById(R.id.air_xts_seatmassage_left).setBackgroundResource(R.drawable.ic_hp_seatmassage_left_1);
                break;
            case 2:
                findViewById(R.id.air_xts_seatmassage_left).setBackgroundResource(R.drawable.ic_hp_seatmassage_left_2);
                break;
            case 3:
                findViewById(R.id.air_xts_seatmassage_left).setBackgroundResource(R.drawable.ic_hp_seatmassage_left_3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateWaistHeatRight() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_WAISTHEAT_RIGHT];
        switch (vel) {
            case 0:
                findViewById(R.id.air_sp_waistheat_right).setBackgroundResource(R.drawable.ic_hp_waisthot_right_0);
                break;
            case 1:
                findViewById(R.id.air_sp_waistheat_right).setBackgroundResource(R.drawable.ic_hp_waisthot_right_1);
                break;
            case 2:
                findViewById(R.id.air_sp_waistheat_right).setBackgroundResource(R.drawable.ic_hp_waisthot_right_2);
                break;
            case 3:
                findViewById(R.id.air_sp_waistheat_right).setBackgroundResource(R.drawable.ic_hp_waisthot_right_3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSeatWaistRight() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWAIST_RIGHT];
        switch (vel) {
            case 0:
                findViewById(R.id.air_xts_seatwaist_right).setBackgroundResource(R.drawable.ic_hp_seatwaist_right_0);
                break;
            case 1:
                findViewById(R.id.air_xts_seatwaist_right).setBackgroundResource(R.drawable.ic_hp_seatwaist_right_1);
                break;
            case 2:
                findViewById(R.id.air_xts_seatwaist_right).setBackgroundResource(R.drawable.ic_hp_seatwaist_right_2);
                break;
            case 3:
                findViewById(R.id.air_xts_seatwaist_right).setBackgroundResource(R.drawable.ic_hp_seatwaist_right_3);
                break;
            case 4:
                findViewById(R.id.air_xts_seatwaist_right).setBackgroundResource(R.drawable.ic_hp_seatwaist_right_4);
                break;
            case 5:
                findViewById(R.id.air_xts_seatwaist_right).setBackgroundResource(R.drawable.ic_hp_seatwaist_right_5);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSeatMassageRight() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATMASSAGE_RIGHT];
        switch (vel) {
            case 0:
                findViewById(R.id.air_xts_seatmassage_right).setBackgroundResource(R.drawable.ic_hp_seatmassage_right_0);
                break;
            case 1:
                findViewById(R.id.air_xts_seatmassage_right).setBackgroundResource(R.drawable.ic_hp_seatmassage_right_1);
                break;
            case 2:
                findViewById(R.id.air_xts_seatmassage_right).setBackgroundResource(R.drawable.ic_hp_seatmassage_right_2);
                break;
            case 3:
                findViewById(R.id.air_xts_seatmassage_right).setBackgroundResource(R.drawable.ic_hp_seatmassage_right_3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateHeatLeft() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateHeatRight() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateWindLeft() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_LEFT];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateWindRight() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_RIGHT];
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateDual() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_DUAL];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_439_OuDi_Haval_H9 /* 1376695 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
            case FinalCanbus.CAR_455_OD_Haval_H7 /* 12124615 */:
            case FinalCanbus.CAR_455_OD_Haval_H7_H /* 12190151 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_RS /* 15598007 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
            case FinalCanbus.CAR_452_OD_Haval_VV5 /* 16122308 */:
            case FinalCanbus.CAR_452_OD_Haval_VV6 /* 16187844 */:
            case FinalCanbus.CAR_452_OD_Haval_VV7 /* 16253380 */:
            case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
            case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
            case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                findViewById(R.id.air_sp_dual).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_zone_n : R.drawable.ic_hp_zone_p);
                break;
            case FinalCanbus.CAR_456_Sanwu_huytu_Huangguan_FourAir /* 13500872 */:
                findViewById(R.id.air_sp_dual).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_4zone_n : R.drawable.ic_hp_4zone_p);
                break;
            default:
                findViewById(R.id.air_sp_dual).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_dual_n : R.drawable.ic_hp_dual_p);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSYNC() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SYNC];
        findViewById(R.id.air_sp_sync).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_sync_n : R.drawable.ic_hp_sync_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateZONE() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_ZONE];
        findViewById(R.id.air_sp_zone).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_zone_n : R.drawable.ic_hp_zone_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAutoRight() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO_RIGHT];
        findViewById(R.id.air_sp_auto_right).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_auto_n : R.drawable.ic_hp_auto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAuto() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO];
        findViewById(R.id.air_sp_auto).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_auto_n : R.drawable.ic_hp_auto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC];
        findViewById(R.id.air_sp_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_hp_ac_n : R.drawable.ic_hp_ac_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE];
        int cycle_auto = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE_AUTO];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_446_WC2_Futon_FengjingI9_25 /* 721342 */:
            case FinalCanbus.CAR_446_WC2_Futon_Kawen_25 /* 786878 */:
            case FinalCanbus.CAR_446_WC2_Futon_TuyanuoDaV_24_Auto /* 3539390 */:
            case FinalCanbus.CAR_446_WC2_Futon_TuyanuoDaV_24_Hand /* 3604926 */:
            case FinalCanbus.CAR_446_WC2_Futon_XianglingU7_25 /* 3670462 */:
            case FinalCanbus.CAR_456_Sanwu_huytu_Huangguan_DoubleAir /* 13435336 */:
            case FinalCanbus.CAR_456_Sanwu_huytu_Huangguan_FourAir /* 13500872 */:
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
                break;
            default:
                findViewById(R.id.air_sp_cycle).setBackgroundResource(cycle != 0 ? R.drawable.ic_hp_cyclein_p : R.drawable.ic_hp_cycleout_n);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateNanoe() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_NANOE];
        findViewById(R.id.air_sp_nanoe).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_nanoe_n : R.drawable.ic_hp_nanoe_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateECO() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_ECO];
        findViewById(R.id.air_sp_eco).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_eco_n : R.drawable.ic_hp_eco_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFlowerBlow() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FLOWER_BLOW];
        findViewById(R.id.air_sp_flowerblow).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_flowerblow_n : R.drawable.ic_hp_flowerblow_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirPark() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_PARK];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_456_Sanwu_huytu_Huangguan_DoubleAir /* 13435336 */:
            case FinalCanbus.CAR_456_Sanwu_huytu_Huangguan_FourAir /* 13500872 */:
                findViewById(R.id.air_sp_airpark).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_suansu_n : R.drawable.ic_hp_suansu_p);
                break;
            default:
                findViewById(R.id.air_sp_airpark).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_airpark_n : R.drawable.ic_hp_airpark_p);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirRest() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_REST];
        findViewById(R.id.air_sp_rest).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_rest_n : R.drawable.ic_hp_rest_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirOnlyFront() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT_ONLY];
        findViewById(R.id.air_sp_onlyfront).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_onlyfront_n : R.drawable.ic_hp_onlyfront_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirOnlyFront_F() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT_ONLY_F];
        findViewById(R.id.air_sp_onlyfront_front).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_onlyfront_n : R.drawable.ic_hp_onlyfront_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirRearCool() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_COOL];
        findViewById(R.id.air_sp_rear_cool).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_rearcool_n : R.drawable.ic_hp_rearcool_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirRearManual() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_MANUAL];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirSwing() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_SWING];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_456_CZH_Xiandai_All_L /* 13304264 */:
            case FinalCanbus.CAR_456_CZH_Xiandai_All_H /* 13369800 */:
                findViewById(R.id.air_sp_swing).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_swing_toyota_n : R.drawable.ic_hp_swing_toyota_p);
                break;
            case FinalCanbus.CAR_456_Sanwu_huytu_Huangguan_FourAir /* 13500872 */:
                findViewById(R.id.air_sp_swing).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_swing1_n : R.drawable.ic_hp_swing1_p);
                break;
            default:
                findViewById(R.id.air_sp_swing).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_swing_n : R.drawable.ic_hp_swing_p);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR];
        findViewById(R.id.air_sp_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_rear_n : R.drawable.ic_hp_rear_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFrontHot() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT_HOT];
        findViewById(R.id.air_sp_fronthot).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_fronthot_n : R.drawable.ic_hp_fronthot_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFrontDefrost() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT];
        findViewById(R.id.air_sp_front).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_front_n : R.drawable.ic_hp_front_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateMaxFrontDefrost() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONTMAX];
        findViewById(R.id.air_sp_frontmax).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_maxfront_n : R.drawable.ic_hp_maxfront_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePower() {
        int value = DataCanbus.DATA[ConstAllAirDara.U_AIR_POWER];
        if (this.pagenum == 1) {
            value = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_POWER];
        }
        findViewById(R.id.air_sp_power).setBackgroundResource(value == 0 ? R.drawable.ic_hp_power_n : R.drawable.ic_hp_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowModeLeft() {
        int mode;
        int mode2;
        int mode3;
        int win = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT];
        int body = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT];
        int foot = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT];
        int auto = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_AUTO_LEFT];
        if (win != 0) {
            mode = 0 | 4;
        } else {
            mode = 0 & 251;
        }
        if (body != 0) {
            mode2 = mode | 2;
        } else {
            mode2 = mode & 253;
        }
        if (foot != 0) {
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
            findViewById(R.id.air_sp_blow_win).setBackgroundResource(win != 0 ? R.drawable.ic_hp_mode_win_p : R.drawable.ic_hp_mode_win_n);
            findViewById(R.id.air_sp_blow_body).setBackgroundResource(body != 0 ? R.drawable.ic_hp_mode_body_p : R.drawable.ic_hp_mode_body_n);
            findViewById(R.id.air_sp_blow_foot).setBackgroundResource(foot != 0 ? R.drawable.ic_hp_mode_foot_p : R.drawable.ic_hp_mode_foot_n);
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
        findViewById(R.id.air_sp_mode_auto).setVisibility(auto == 0 ? 8 : 0);
        if (ConstAllAirDara.U_AIR_BLOW_UP_RIGHT == 255 && ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT == 255 && ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT == 255) {
            findViewById(R.id.air_sp_mode_up_right).setVisibility(win == 0 ? 8 : 0);
            findViewById(R.id.air_sp_mode_body_right).setVisibility(body == 0 ? 8 : 0);
            findViewById(R.id.air_sp_mode_foot_right).setVisibility(foot == 0 ? 8 : 0);
            findViewById(R.id.air_sp_mode_auto_right).setVisibility(auto != 0 ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlowModeRight() {
        int mode;
        int mode2;
        int mode3;
        int win = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_RIGHT];
        int body = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT];
        int foot = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT];
        int auto = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_AUTO_RIGHT];
        if (win != 0) {
            mode = 0 | 4;
        } else {
            mode = 0 & 251;
        }
        if (body != 0) {
            mode2 = mode | 2;
        } else {
            mode2 = mode & 253;
        }
        if (foot != 0) {
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
