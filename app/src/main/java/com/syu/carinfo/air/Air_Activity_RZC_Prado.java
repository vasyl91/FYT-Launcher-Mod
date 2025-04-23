package com.syu.carinfo.air;

import android.app.Activity;
import android.graphics.Color;
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

public class Air_Activity_RZC_Prado extends Activity implements View.OnTouchListener {
    public static Air_Activity_RZC_Prado mInstance;
    public static boolean mIsFront = false;
    int pagenum = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == ConstAllAirDara.U_AIR_AC) {
                Air_Activity_RZC_Prado.this.mUpdateAcOn();
            }
            if (updateCode == ConstAllAirDara.U_AIR_CYCLE) {
                Air_Activity_RZC_Prado.this.mUpdateCycle();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR) {
                Air_Activity_RZC_Prado.this.mUpdateRearDefrost();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SWING) {
                Air_Activity_RZC_Prado.this.mUpdateSwing();
            }
            if (updateCode == ConstAllAirDara.U_AIR_ION) {
                Air_Activity_RZC_Prado.this.mUpdateION();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FRONT) {
                Air_Activity_RZC_Prado.this.mUpdateFrontDefrost();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FRONTMAX) {
                Air_Activity_RZC_Prado.this.mUpdateFrontmaxDefrost();
            }
            if (updateCode == ConstAllAirDara.U_AIR_POWER) {
                Air_Activity_RZC_Prado.this.mUpdatePower();
            }
            if (updateCode == ConstAllAirDara.U_AIR_TEMP_LEFT) {
                Air_Activity_RZC_Prado.this.mUpdateAirTempLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT) {
                Air_Activity_RZC_Prado.this.mUpdaterAirWindLevelLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_MODE_LEFT) {
                Air_Activity_RZC_Prado.this.updateBlowMode();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_UP_LEFT) {
                Air_Activity_RZC_Prado.this.updateBlowModeUp();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_BODY_LEFT) {
                Air_Activity_RZC_Prado.this.updateBlowModeBody();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT) {
                Air_Activity_RZC_Prado.this.updateBlowModeFoot();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_UP_RIGHT) {
                Air_Activity_RZC_Prado.this.updateBlowModeUpRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT) {
                Air_Activity_RZC_Prado.this.updateBlowModeBodyRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT) {
                Air_Activity_RZC_Prado.this.updateBlowModeFootRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_AC_MAX) {
                Air_Activity_RZC_Prado.this.mUpdateAcMax();
            }
            if (updateCode == ConstAllAirDara.U_AIR_AUTO) {
                Air_Activity_RZC_Prado.this.mUpdateAuto();
            }
            if (updateCode == ConstAllAirDara.U_AIR_DUAL) {
                Air_Activity_RZC_Prado.this.mUpdateDual();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SYNC) {
                Air_Activity_RZC_Prado.this.mUpdateSYNC();
            }
            if (updateCode == ConstAllAirDara.U_AIR_ZONE) {
                Air_Activity_RZC_Prado.this.mUpdateZONE();
            }
            if (updateCode == ConstAllAirDara.U_AIR_STEER) {
                Air_Activity_RZC_Prado.this.mUpdateSteer();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REARVIEW_HOT) {
                Air_Activity_RZC_Prado.this.mUpdateRearViewHot();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATHEAT_LEFT) {
                Air_Activity_RZC_Prado.this.mUpdateHeatLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATHEAT_RIGHT) {
                Air_Activity_RZC_Prado.this.mUpdateHeatRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATWIND_LEFT) {
                Air_Activity_RZC_Prado.this.mUpdateWindLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATWIND_RIGHT) {
                Air_Activity_RZC_Prado.this.mUpdateWindRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATMASSAGE_LEFT) {
                Air_Activity_RZC_Prado.this.mUpdateMassageLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATMASSAGE_RIGHT) {
                Air_Activity_RZC_Prado.this.mUpdateMassageRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATWAIST_LEFT) {
                Air_Activity_RZC_Prado.this.mUpdateWaistLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATWAIST_RIGHT) {
                Air_Activity_RZC_Prado.this.mUpdateWaistRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR_SEAT_HEAT) {
                Air_Activity_RZC_Prado.this.mUpdateRearSeatHeat();
            }
            if (updateCode == ConstAllAirDara.U_AIR_TEMP_RIGHT) {
                Air_Activity_RZC_Prado.this.mUpdateTempRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_TEMP) {
                Air_Activity_RZC_Prado.this.mUpdateBackTemp();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_POWER) {
                Air_Activity_RZC_Prado.this.mUpdateBackPower();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FRONT_POWER) {
                Air_Activity_RZC_Prado.this.mUpdateFrontPower();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_BLOW_BODY) {
                Air_Activity_RZC_Prado.this.mUpdateBackBody();
                if (ConstAllAirDara.U_AIR_BACK_BLOW_UP == 255) {
                    Air_Activity_RZC_Prado.this.mUpdateBackUp();
                }
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_BLOW_UP) {
                Air_Activity_RZC_Prado.this.mUpdateBackUp();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_BLOW_FOOT) {
                Air_Activity_RZC_Prado.this.mUpdateBackFoot();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_BLOW_AUTO) {
                Air_Activity_RZC_Prado.this.mUpdateBackAuto();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_BLOW_WIND) {
                Air_Activity_RZC_Prado.this.mUpdateBackWind();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR_LOCK) {
                Air_Activity_RZC_Prado.this.mUpdateBackRearLock();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR_SYNC) {
                Air_Activity_RZC_Prado.this.mUpdateBackSync();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR_CTRL) {
                Air_Activity_RZC_Prado.this.mUpdateRearCtrl();
            }
            if (updateCode == ConstAllAirDara.U_AIR_CLEAN_AIR) {
                Air_Activity_RZC_Prado.this.mUpdateCleanAir();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR_HEAT) {
                Air_Activity_RZC_Prado.this.mUpdateRearHeat();
            }
            if (updateCode != ConstAllAirDara.U_AIR_REAR_COOL) {
                return;
            }
            Air_Activity_RZC_Prado.this.mUpdateRearCool();
        }
    };

    private void sendCmd(int data0, int data1) {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WC2_ShuPing_14Prado_M /* 196729 */:
            case FinalCanbus.CAR_WC2_ShuPing_14Prado_H /* 262265 */:
            case FinalCanbus.CAR_WC2_ShuPing_Prado_L /* 327801 */:
            case FinalCanbus.CAR_WeiChi2_ChangChengH9 /* 328000 */:
            case FinalCanbus.CAR_WC2_ShuPing_14Prado_L /* 393337 */:
            case FinalCanbus.CAR_WeiChi2_ChangChengH9_M /* 393536 */:
            case FinalCanbus.CAR_WC2_ShuPing_Prado_M /* 458873 */:
            case FinalCanbus.CAR_WeiChi2_ChangChengH9_H /* 459072 */:
            case FinalCanbus.CAR_WC2_ShuPing_Prado_H /* 524409 */:
            case FinalCanbus.CAR_WC2_ShuPing_Prado_Luxun_ZiDong /* 589945 */:
            case FinalCanbus.CAR_WC2_ShuPing_Prado_Luxun_ZiDongRight /* 655481 */:
            case FinalCanbus.CAR_WC2_ShuPing_14Prado_H_NoAMP /* 721017 */:
            case FinalCanbus.CAR_BNR_ShuPing_14PradoShouDong /* 852365 */:
            case FinalCanbus.CAR_BNR_ShuPing_15HighLand_L /* 917901 */:
            case FinalCanbus.CAR_BNR_ShuPing_15HighLand_H /* 983437 */:
            case FinalCanbus.CAR_BNR_ShuPing_09HighLand_L /* 1048973 */:
            case FinalCanbus.CAR_BNR_ShuPing_09HighLand_H /* 1114509 */:
            case FinalCanbus.CAR_BNR_12Camry_AMP /* 1376653 */:
            case FinalCanbus.CAR_WeiChi2_ChangChengH8 /* 1573184 */:
            case FinalCanbus.CAR_WeiChi2_ChangChengH8_M /* 1638720 */:
            case FinalCanbus.CAR_BNR_ShuPing_14PradoShouDong_AMP /* 1638797 */:
            case FinalCanbus.CAR_WeiChi2_ChangChengH8_H /* 1704256 */:
            case FinalCanbus.CAR_BNR_10PradoAuto /* 1704333 */:
            case FinalCanbus.CAR_BNR_10PradoAuto_AMP /* 1769869 */:
            case FinalCanbus.CAR_BNR_14PradoAuto /* 1835405 */:
            case FinalCanbus.CAR_BNR_14PradoAuto_AMP /* 1900941 */:
            case FinalCanbus.CAR_452_XinCheng_Infiniti_15QX60 /* 1900996 */:
            case FinalCanbus.CAR_BNR_09Rav4 /* 2032013 */:
            case FinalCanbus.CAR_BNR_18PradoHand /* 2359693 */:
            case FinalCanbus.CAR_BNR_18PradoHand_AMP /* 2425229 */:
            case FinalCanbus.CAR_BNR_18PradoAuto /* 2490765 */:
            case FinalCanbus.CAR_BNR_18PradoAuto_AMP /* 2556301 */:
            case FinalCanbus.CAR_RZC_ShuPing_14PradoShouDong /* 3080589 */:
            case FinalCanbus.CAR_RZC_ShuPing_15HighLand_L /* 3146125 */:
            case FinalCanbus.CAR_RZC_ShuPing_15HighLand_H /* 3211661 */:
            case FinalCanbus.CAR_RZC_ShuPing_09HighLand_L /* 3277197 */:
            case FinalCanbus.CAR_RZC_ShuPing_09HighLand_H /* 3342733 */:
            case FinalCanbus.CAR_RZC_12Camry_AMP /* 3604877 */:
            case FinalCanbus.CAR_RZC_ShuPing_14PradoShouDong_AMP /* 3867021 */:
            case FinalCanbus.CAR_RZC_10PradoAuto /* 3932557 */:
            case FinalCanbus.CAR_RZC_10PradoAuto_AMP /* 3998093 */:
            case FinalCanbus.CAR_RZC_14PradoAuto /* 4063629 */:
            case FinalCanbus.CAR_RZC_14PradoAuto_AMP /* 4129165 */:
            case FinalCanbus.CAR_RZC_09Rav4 /* 4260237 */:
            case FinalCanbus.CAR_RZC_18PradoHand /* 4587917 */:
            case FinalCanbus.CAR_RZC_18PradoHand_AMP /* 4653453 */:
            case FinalCanbus.CAR_RZC_18PradoAuto /* 4718989 */:
            case FinalCanbus.CAR_RZC_18PradoAuto_AMP /* 4784525 */:
            case FinalCanbus.CAR_RZC_ALL_GM_Enclave_SP /* 4980797 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11 /* 5177797 */:
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_18 /* 5243333 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460 /* 5308868 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460_H /* 5374404 */:
            case FinalCanbus.CAR_452_LZ_Toyota_LC100 /* 5439940 */:
            case FinalCanbus.CAR_452_LZ_Toyota_LC100_H /* 5505476 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
            case FinalCanbus.CAR_452_ZH_PAJERO_SP /* 5964228 */:
            case FinalCanbus.CAR_443_WC2_Ford_EDGE_11 /* 6685115 */:
            case FinalCanbus.CAR_443_WC2_Ford_EDGE_11_CD /* 6750651 */:
            case FinalCanbus.CAR_LUZ_Toyato_20All /* 8126903 */:
            case FinalCanbus.CAR_LUZ_Toyato_30All /* 8192439 */:
                DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                break;
            case FinalCanbus.CAR_RZC_15Ruijie /* 196942 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand /* 1311174 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto /* 1376710 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand /* 1442246 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto /* 1507782 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand_S /* 1573318 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto_S /* 1638854 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand_S /* 1704390 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto_S /* 1769926 */:
            case FinalCanbus.CAR_RZC_Ford_Lincoln_navigator /* 1900878 */:
            case FinalCanbus.CAR_452_LZ_Ford_Mustang /* 11403716 */:
            case FinalCanbus.CAR_452_LZ_Ford_Mustang_H /* 14090692 */:
                if (data1 == 1) {
                    RzcKlcFunc.CAR_AIR_CONTROL(172, data0);
                    break;
                } else if (data1 == 0) {
                    RzcKlcFunc.CAR_AIR_CONTROL(172, 0);
                    break;
                }
            case FinalCanbus.CAR_439_OuDi_Haval_H9 /* 1376695 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
            case FinalCanbus.CAR_RZC_Haval_H9 /* 2490807 */:
            case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_RS /* 15598007 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
            case FinalCanbus.CAR_452_OD_Haval_VV5 /* 16122308 */:
            case FinalCanbus.CAR_452_OD_Haval_VV6 /* 16187844 */:
            case FinalCanbus.CAR_452_OD_Haval_VV7 /* 16253380 */:
            case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
            case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
            case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                if (this.pagenum == 0) {
                    if (ConstAllAirDara.C_AIR_MODE_UP != data0) {
                        DataCanbus.PROXY.cmd(0, new int[]{data0, data1}, null, null);
                        break;
                    }
                } else if (this.pagenum == 1) {
                    DataCanbus.PROXY.cmd(3, new int[]{data0, data1}, null, null);
                    break;
                }
            case FinalCanbus.CAR_452_DJ_Dodge_JCUV /* 4981188 */:
                if (this.pagenum == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{data0, data1}, null, null);
                    break;
                } else if (this.pagenum == 1) {
                    DataCanbus.PROXY.cmd(1, new int[]{data0, data1}, null, null);
                    break;
                }
            case FinalCanbus.CAR_439_HC_Nissan_Toread /* 7012791 */:
                if (data0 == 128) {
                    DataCanbus.PROXY.cmd(6, new int[]{data0, data1}, null, null);
                    break;
                } else if (this.pagenum == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{data0, data1}, null, null);
                    break;
                } else if (this.pagenum == 1) {
                    DataCanbus.PROXY.cmd(6, new int[]{data0, data1}, null, null);
                    break;
                }
            case FinalCanbus.CAR_452_KYC_Toyota_Landekuluze /* 14221764 */:
            case FinalCanbus.CAR_452_KYC_Toyota_Runner /* 14287300 */:
            case FinalCanbus.CAR_452_KYC_Toyota_Alpha /* 14352836 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0}, null, null);
                    break;
                }
            case FinalCanbus.CAR_439_HC_Ford_Explorer /* 15335863 */:
                if (this.pagenum == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{data0, data1}, null, null);
                    break;
                } else if (this.pagenum == 1) {
                    DataCanbus.PROXY.cmd(5, new int[]{data0, data1}, null, null);
                    break;
                }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String platform = SystemProperties.get("ro.fyt.platform", "");
        if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform) || "6318".equals(platform) || "823".equals(platform)) {
            //setContentView(R.layout.layout_air_sp_rzc_prado);
            if ("6318".equals(platform) || "823".equals(platform)) {
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.sp_air_bg_7870);
            } else {
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.sp_air_bg);
            }
        } else {
            //setContentView(R.layout.layout_air_sp_rzc_prado_7731);
        }
        initCallbackId();
        init();
        mInstance = this;
    }

    public void initCallbackId() {
        ConstAllAirDara.initClearAllId();
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WC2_ShuPing_14Prado_M /* 196729 */:
            case FinalCanbus.CAR_WC2_ShuPing_14Prado_H /* 262265 */:
            case FinalCanbus.CAR_WC2_ShuPing_Prado_L /* 327801 */:
            case FinalCanbus.CAR_WC2_ShuPing_14Prado_L /* 393337 */:
            case FinalCanbus.CAR_WC2_ShuPing_Prado_M /* 458873 */:
            case FinalCanbus.CAR_WC2_ShuPing_Prado_H /* 524409 */:
            case FinalCanbus.CAR_WC2_ShuPing_Prado_Luxun_ZiDong /* 589945 */:
            case FinalCanbus.CAR_WC2_ShuPing_Prado_Luxun_ZiDongRight /* 655481 */:
            case FinalCanbus.CAR_WC2_ShuPing_14Prado_H_NoAMP /* 721017 */:
                ConstAllAirDara.U_AIR_POWER = 10;
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
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
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
                ConstAllAirDara.C_AIR_MODE_ADD = 21;
                ConstAllAirDara.C_AIR_MODE_SUB = 22;
                ConstAllAirDara.C_AIR_DUAL = 41;
                ConstAllAirDara.C_REAR_TEMP_DOWN = 65;
                ConstAllAirDara.C_REAR_TEMP_UP = 64;
                ConstAllAirDara.C_REAR_WIND_DOWN = 43;
                ConstAllAirDara.C_REAR_WIND_UP = 42;
                ConstAllAirDara.C_REAR_OFF = 46;
                ConstAllAirDara.C_REAR_OFF = 66;
                ConstAllAirDara.C_REAR_MODE_FOOT = 81;
                ConstAllAirDara.C_REAR_MODE_BODY = 82;
                ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 83;
                ConstAllAirDara.C_CONTRAL = 17;
                break;
            case FinalCanbus.CAR_RZC_15Ruijie /* 196942 */:
            case FinalCanbus.CAR_RZC_Ford_Lincoln_navigator /* 1900878 */:
                ConstAllAirDara.TEMPERATURE_LOW = 1048576;
                ConstAllAirDara.TEMPERATURE_HIGHT = FinalCanbus.CAR_WC1_VW_Polo_08_18;
                ConstAllAirDara.TEMPERATURE_NONE = 1048578;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 30;
                ConstAllAirDara.U_AIR_STEER = 66;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                ConstAllAirDara.C_REAR_TEMP_DOWN = 19;
                ConstAllAirDara.C_REAR_TEMP_UP = 20;
                ConstAllAirDara.C_REAR_WIND_DOWN = 21;
                ConstAllAirDara.C_REAR_WIND_UP = 22;
                ConstAllAirDara.C_REAR_OFF = 17;
                ConstAllAirDara.C_REAR_LOCK = 18;
                ConstAllAirDara.C_AIR_LEFT_COLD = 8;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 10;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_AC_MAX = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 7;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 9;
                ConstAllAirDara.C_AIR_AUTO = 23;
                ConstAllAirDara.C_AIR_DUAL = 24;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 26;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 27;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 28;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 29;
                ConstAllAirDara.C_AIR_WIND_ADD = 30;
                ConstAllAirDara.C_AIR_WIND_SUB = 31;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_15Ruijie /* 196942 */:
                        ConstAllAirDara.C_AIR_MODE_UP = 32;
                        ConstAllAirDara.C_AIR_MODE_BODY = 33;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 34;
                        break;
                    default:
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 37;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 35;
                        ConstAllAirDara.C_AIR_MODE_BODY = 38;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 36;
                        break;
                }
                ConstAllAirDara.C_AIR_STEER = 11;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_WeiChi2_ChangChengH9 /* 328000 */:
            case FinalCanbus.CAR_WeiChi2_ChangChengH9_M /* 393536 */:
            case FinalCanbus.CAR_WeiChi2_ChangChengH9_H /* 459072 */:
            case FinalCanbus.CAR_WeiChi2_ChangChengH8 /* 1573184 */:
            case FinalCanbus.CAR_WeiChi2_ChangChengH8_M /* 1638720 */:
            case FinalCanbus.CAR_WeiChi2_ChangChengH8_H /* 1704256 */:
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_FRONT_POWER = 10;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.C_AIR_POWER_FRONT = 1;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                ConstAllAirDara.C_AIR_MODE_ADD = 21;
                ConstAllAirDara.C_AIR_MODE_SUB = 22;
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
                ConstAllAirDara.C_REAR_MODE = 45;
                ConstAllAirDara.C_REAR_WIND_DOWN = 43;
                ConstAllAirDara.C_REAR_WIND_UP = 42;
                ConstAllAirDara.C_REAR_TEMP_DOWN = 33;
                ConstAllAirDara.C_REAR_TEMP_UP = 32;
                ConstAllAirDara.C_REAR_AUTO = 44;
                ConstAllAirDara.C_REAR_OFF = 19;
                ConstAllAirDara.C_CONTRAL = 4;
                break;
            case FinalCanbus.CAR_BNR_ShuPing_14PradoShouDong /* 852365 */:
            case FinalCanbus.CAR_BNR_ShuPing_15HighLand_L /* 917901 */:
            case FinalCanbus.CAR_BNR_ShuPing_15HighLand_H /* 983437 */:
            case FinalCanbus.CAR_BNR_ShuPing_09HighLand_L /* 1048973 */:
            case FinalCanbus.CAR_BNR_ShuPing_09HighLand_H /* 1114509 */:
            case FinalCanbus.CAR_BNR_12Camry_AMP /* 1376653 */:
            case FinalCanbus.CAR_BNR_ShuPing_14PradoShouDong_AMP /* 1638797 */:
            case FinalCanbus.CAR_BNR_10PradoAuto /* 1704333 */:
            case FinalCanbus.CAR_BNR_10PradoAuto_AMP /* 1769869 */:
            case FinalCanbus.CAR_BNR_14PradoAuto /* 1835405 */:
            case FinalCanbus.CAR_BNR_14PradoAuto_AMP /* 1900941 */:
            case FinalCanbus.CAR_BNR_09Rav4 /* 2032013 */:
            case FinalCanbus.CAR_BNR_18PradoHand /* 2359693 */:
            case FinalCanbus.CAR_BNR_18PradoHand_AMP /* 2425229 */:
            case FinalCanbus.CAR_BNR_18PradoAuto /* 2490765 */:
            case FinalCanbus.CAR_BNR_18PradoAuto_AMP /* 2556301 */:
            case FinalCanbus.CAR_RZC_ShuPing_14PradoShouDong /* 3080589 */:
            case FinalCanbus.CAR_RZC_ShuPing_15HighLand_L /* 3146125 */:
            case FinalCanbus.CAR_RZC_ShuPing_15HighLand_H /* 3211661 */:
            case FinalCanbus.CAR_RZC_ShuPing_09HighLand_L /* 3277197 */:
            case FinalCanbus.CAR_RZC_ShuPing_09HighLand_H /* 3342733 */:
            case FinalCanbus.CAR_RZC_12Camry_AMP /* 3604877 */:
            case FinalCanbus.CAR_RZC_ShuPing_14PradoShouDong_AMP /* 3867021 */:
            case FinalCanbus.CAR_RZC_10PradoAuto /* 3932557 */:
            case FinalCanbus.CAR_RZC_10PradoAuto_AMP /* 3998093 */:
            case FinalCanbus.CAR_RZC_14PradoAuto /* 4063629 */:
            case FinalCanbus.CAR_RZC_14PradoAuto_AMP /* 4129165 */:
            case FinalCanbus.CAR_RZC_09Rav4 /* 4260237 */:
            case FinalCanbus.CAR_RZC_18PradoHand /* 4587917 */:
            case FinalCanbus.CAR_RZC_18PradoHand_AMP /* 4653453 */:
            case FinalCanbus.CAR_RZC_18PradoAuto /* 4718989 */:
            case FinalCanbus.CAR_RZC_18PradoAuto_AMP /* 4784525 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_REAR_CTRL = 67;
                ConstAllAirDara.U_AIR_CLEAN_AIR = 33;
                ConstAllAirDara.C_AIR_POWER = 1;
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
                ConstAllAirDara.C_AIR_MODE_CHANGER = 8;
                ConstAllAirDara.C_CONTRAL = 22;
                ConstAllAirDara.C_REAR_TEMP_DOWN = 38;
                ConstAllAirDara.C_REAR_TEMP_UP = 39;
                ConstAllAirDara.C_REAR_WIND_DOWN = 40;
                ConstAllAirDara.C_REAR_WIND_UP = 41;
                ConstAllAirDara.C_REAR_CTRL = 42;
                ConstAllAirDara.C_REAR_MODE = 43;
                ConstAllAirDara.C_REAR_OFF = 44;
                ConstAllAirDara.C_REAR_AUTO = 45;
                ConstAllAirDara.C_CLEAN_AIR = 32;
                ConstAllAirDara.C_CONTRAL = 22;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_BNR_ShuPing_14PradoShouDong /* 852365 */:
                    case FinalCanbus.CAR_BNR_ShuPing_14PradoShouDong_AMP /* 1638797 */:
                    case FinalCanbus.CAR_BNR_18PradoHand /* 2359693 */:
                    case FinalCanbus.CAR_BNR_18PradoHand_AMP /* 2425229 */:
                    case FinalCanbus.CAR_RZC_ShuPing_14PradoShouDong /* 3080589 */:
                    case FinalCanbus.CAR_RZC_ShuPing_14PradoShouDong_AMP /* 3867021 */:
                    case FinalCanbus.CAR_RZC_18PradoHand /* 4587917 */:
                    case FinalCanbus.CAR_RZC_18PradoHand_AMP /* 4653453 */:
                        ConstAllAirDara.U_AIR_AUTO = 255;
                        ConstAllAirDara.U_AIR_DUAL = 255;
                        ConstAllAirDara.C_AIR_DUAL = 255;
                        ConstAllAirDara.C_AIR_AUTO = 255;
                        break;
                    case FinalCanbus.CAR_BNR_ShuPing_15HighLand_L /* 917901 */:
                    case FinalCanbus.CAR_BNR_ShuPing_15HighLand_H /* 983437 */:
                    case FinalCanbus.CAR_BNR_ShuPing_09HighLand_L /* 1048973 */:
                    case FinalCanbus.CAR_BNR_ShuPing_09HighLand_H /* 1114509 */:
                    case FinalCanbus.CAR_RZC_ShuPing_15HighLand_L /* 3146125 */:
                    case FinalCanbus.CAR_RZC_ShuPing_15HighLand_H /* 3211661 */:
                    case FinalCanbus.CAR_RZC_ShuPing_09HighLand_L /* 3277197 */:
                    case FinalCanbus.CAR_RZC_ShuPing_09HighLand_H /* 3342733 */:
                        ConstAllAirDara.U_AIR_DUAL = 255;
                        ConstAllAirDara.C_AIR_DUAL = 255;
                        ConstAllAirDara.U_AIR_SYNC = 14;
                        ConstAllAirDara.C_AIR_SYNC = 16;
                        ConstAllAirDara.C_CLEAN_AIR = 255;
                        ConstAllAirDara.U_AIR_CLEAN_AIR = 255;
                        break;
                    case FinalCanbus.CAR_BNR_09Rav4 /* 2032013 */:
                    case FinalCanbus.CAR_RZC_09Rav4 /* 4260237 */:
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 255;
                        ConstAllAirDara.C_AIR_MODE_ADD = 8;
                        ConstAllAirDara.C_AIR_MODE_SUB = 7;
                        break;
                }
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand /* 1311174 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto /* 1376710 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand /* 1442246 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto /* 1507782 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand_S /* 1573318 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto_S /* 1638854 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand_S /* 1704390 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto_S /* 1769926 */:
            case FinalCanbus.CAR_452_LZ_Ford_Mustang /* 11403716 */:
            case FinalCanbus.CAR_452_LZ_Ford_Mustang_H /* 14090692 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_STEER = 66;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 19;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 20;
                ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 25;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 42;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 40;
                ConstAllAirDara.C_AIR_AC_MAX = 4;
                ConstAllAirDara.C_AIR_AUTO = 23;
                ConstAllAirDara.C_AIR_DUAL = 24;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 26;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 27;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 28;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 29;
                ConstAllAirDara.C_AIR_WIND_ADD = 30;
                ConstAllAirDara.C_AIR_WIND_SUB = 31;
                ConstAllAirDara.C_AIR_MODE_UP = 32;
                ConstAllAirDara.C_AIR_MODE_BODY = 33;
                ConstAllAirDara.C_AIR_MODE_FOOT = 34;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 35;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 36;
                ConstAllAirDara.C_AIR_LEFT_COLD = 37;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 38;
                ConstAllAirDara.C_AIR_STEER = 41;
                ConstAllAirDara.C_REAR_OFF = 17;
                ConstAllAirDara.C_REAR_TEMP_DOWN = 19;
                ConstAllAirDara.C_REAR_TEMP_UP = 20;
                ConstAllAirDara.C_REAR_WIND_DOWN = 21;
                ConstAllAirDara.C_REAR_WIND_UP = 22;
                ConstAllAirDara.C_REAR_LOCK = 18;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_439_OuDi_Haval_H9 /* 1376695 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
            case FinalCanbus.CAR_RZC_Haval_H9 /* 2490807 */:
            case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_RS /* 15598007 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
            case FinalCanbus.CAR_452_OD_Haval_VV5 /* 16122308 */:
            case FinalCanbus.CAR_452_OD_Haval_VV6 /* 16187844 */:
            case FinalCanbus.CAR_452_OD_Haval_VV7 /* 16253380 */:
            case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
            case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
            case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                ConstAllAirDara.U_AIR_ZONE = 57;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_FRONT_POWER = 10;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.U_AIR_SEATMASSAGE_LEFT = 93;
                ConstAllAirDara.U_AIR_SEATMASSAGE_RIGHT = 94;
                ConstAllAirDara.U_AIR_SEATWAIST_LEFT = 95;
                ConstAllAirDara.U_AIR_SEATWAIST_RIGHT = 96;
                ConstAllAirDara.U_AIR_REAR_SEAT_HEAT = 88;
                ConstAllAirDara.C_AIR_POWER_FRONT = 16;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_Haval_H9 /* 2490807 */:
                    case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                        ConstAllAirDara.C_AIR_AUTO = 34;
                        ConstAllAirDara.C_AIR_ZONE = 35;
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
                        ConstAllAirDara.C_REAR_TEMP_DOWN = 134;
                        ConstAllAirDara.C_REAR_TEMP_UP = 133;
                        ConstAllAirDara.C_REAR_WIND_DOWN = 132;
                        ConstAllAirDara.C_REAR_WIND_UP = 131;
                        ConstAllAirDara.C_REAR_MODE_BODY = 135;
                        ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 136;
                        ConstAllAirDara.C_REAR_MODE_FOOT = 137;
                        ConstAllAirDara.C_REAR_SEAT_HEAT = 138;
                        break;
                    default:
                        ConstAllAirDara.C_AIR_AUTO = 18;
                        ConstAllAirDara.C_AIR_ZONE = 20;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 34;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 35;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 36;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 37;
                        ConstAllAirDara.C_AIR_LEFT_MASSAGE = 38;
                        ConstAllAirDara.C_AIR_RIGHT_MASSAGE = 39;
                        ConstAllAirDara.C_AIR_LEFT_WAIST = 40;
                        ConstAllAirDara.C_AIR_RIGHT_WAIST = 41;
                        ConstAllAirDara.C_REAR_MODE_FOOT = 26;
                        ConstAllAirDara.C_REAR_MODE_BODY = 24;
                        ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 25;
                        ConstAllAirDara.C_REAR_WIND_DOWN = 29;
                        ConstAllAirDara.C_REAR_WIND_UP = 28;
                        ConstAllAirDara.C_REAR_TEMP_DOWN = 31;
                        ConstAllAirDara.C_REAR_TEMP_UP = 30;
                        ConstAllAirDara.C_REAR_AUTO = 18;
                        ConstAllAirDara.C_REAR_OFF = 16;
                        break;
                }
                ConstAllAirDara.C_AIR_MODE_BODY = 24;
                ConstAllAirDara.C_AIR_MODE_FOOT = 26;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 25;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 27;
                ConstAllAirDara.C_AIR_AC = 17;
                ConstAllAirDara.C_AIR_CYCLE = 19;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 30;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 31;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 32;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 33;
                ConstAllAirDara.C_AIR_WIND_ADD = 28;
                ConstAllAirDara.C_AIR_WIND_SUB = 29;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_452_XinCheng_Infiniti_15QX60 /* 1900996 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
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
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_REAR_TEMP_DOWN = 50;
                ConstAllAirDara.C_REAR_TEMP_UP = 51;
                ConstAllAirDara.C_REAR_WIND_DOWN = 48;
                ConstAllAirDara.C_REAR_WIND_UP = 49;
                ConstAllAirDara.C_REAR_MODE = 57;
                ConstAllAirDara.C_REAR_MODE = 57;
                ConstAllAirDara.C_REAR_OFF = 56;
                ConstAllAirDara.C_REAR_AUTO = 52;
                ConstAllAirDara.C_CONTRAL = 3;
                break;
            case FinalCanbus.CAR_RZC_ALL_GM_Enclave_SP /* 4980797 */:
            case FinalCanbus.CAR_RZC_ALL_GM_Kopach_SP /* 5636157 */:
                ConstAllAirDara.TEMPERATURE_LOW = 0;
                ConstAllAirDara.TEMPERATURE_HIGHT = 30;
                ConstAllAirDara.TEMPERATURE_NONE = -1;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SYNC = 57;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.U_AIR_REAR_LOCK = 67;
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
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_ALL_GM_Enclave_SP /* 4980797 */:
                        ConstAllAirDara.C_AIR_MODE_ADD = 37;
                        ConstAllAirDara.C_AIR_MODE_SUB = 38;
                        break;
                    case FinalCanbus.CAR_RZC_ALL_GM_Kopach_SP /* 5636157 */:
                        ConstAllAirDara.C_AIR_MODE_BODY = 7;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 33;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 32;
                        break;
                }
                ConstAllAirDara.C_REAR_MODE_FOOT = 55;
                ConstAllAirDara.C_REAR_MODE_BODY = 53;
                ConstAllAirDara.C_REAR_TEMP_DOWN = 50;
                ConstAllAirDara.C_REAR_TEMP_UP = 51;
                ConstAllAirDara.C_REAR_WIND_DOWN = 48;
                ConstAllAirDara.C_REAR_WIND_UP = 49;
                ConstAllAirDara.C_REAR_AUTO = 52;
                ConstAllAirDara.C_REAR_LOCK = 56;
                ConstAllAirDara.C_CONTRAL = 10;
                break;
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
            case FinalCanbus.CAR_443_WC2_Ford_EDGE_11 /* 6685115 */:
            case FinalCanbus.CAR_443_WC2_Ford_EDGE_11_CD /* 6750651 */:
                ConstAllAirDara.TEMPERATURE_LOW = 254;
                ConstAllAirDara.TEMPERATURE_HIGHT = 255;
                ConstAllAirDara.TEMPERATURE_NONE = -1;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_STEER = 66;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_BLOW_UP = 18;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 19;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 20;
                ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_DUAL = 3;
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
                ConstAllAirDara.C_AIR_LEFT_COLD = 23;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 24;
                ConstAllAirDara.C_AIR_AC_MAX = 26;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_443_WC2_Ford_EDGE_11 /* 6685115 */:
                    case FinalCanbus.CAR_443_WC2_Ford_EDGE_11_CD /* 6750651 */:
                        ConstAllAirDara.C_AIR_MODE_BODY = 31;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 27;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 29;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 28;
                        ConstAllAirDara.C_REAR_MODE_FOOT = 29;
                        ConstAllAirDara.C_REAR_MODE_BODY = 31;
                        ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 27;
                        break;
                    default:
                        ConstAllAirDara.C_AIR_MODE_UP = 8;
                        ConstAllAirDara.C_AIR_MODE_BODY = 9;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                        ConstAllAirDara.C_REAR_MODE_FOOT = 10;
                        ConstAllAirDara.C_REAR_MODE_BODY = 9;
                        break;
                }
                ConstAllAirDara.C_AIR_STEER = 45;
                ConstAllAirDara.C_REAR_MODE_FOOT = 29;
                ConstAllAirDara.C_REAR_MODE_BODY = 31;
                ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 27;
                ConstAllAirDara.C_REAR_TEMP_DOWN = 33;
                ConstAllAirDara.C_REAR_TEMP_UP = 32;
                ConstAllAirDara.C_REAR_WIND_DOWN = 43;
                ConstAllAirDara.C_REAR_WIND_UP = 42;
                ConstAllAirDara.C_REAR_LOCK = 34;
                ConstAllAirDara.C_REAR_OFF = 46;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_452_DJ_Dodge_JCUV /* 4981188 */:
                ConstAllAirDara.U_AIR_FRONT_POWER = 21;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_FRONT = 18;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                ConstAllAirDara.C_AIR_POWER_FRONT = 10;
                ConstAllAirDara.C_AIR_AC = 8;
                ConstAllAirDara.C_AIR_DUAL = 2;
                ConstAllAirDara.C_AIR_AUTO = 1;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 33;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                ConstAllAirDara.C_AIR_MODE_BODY = 34;
                ConstAllAirDara.C_AIR_MODE_FOOT = 35;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 18;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 19;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 36;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 37;
                ConstAllAirDara.C_REAR_OFF = 1;
                ConstAllAirDara.C_REAR_TEMP_DOWN = 4;
                ConstAllAirDara.C_REAR_TEMP_UP = 3;
                ConstAllAirDara.C_REAR_WIND_DOWN = 8;
                ConstAllAirDara.C_REAR_WIND_UP = 7;
                ConstAllAirDara.C_REAR_MODE_FOOT = 16;
                ConstAllAirDara.C_REAR_MODE_BODY = 18;
                ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 17;
                ConstAllAirDara.C_REAR_LOCK = 9;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_11 /* 5177797 */:
            case FinalCanbus.CAR_453_LZ_Toyota_LAND_CRUISER_18 /* 5243333 */:
            case FinalCanbus.CAR_LUZ_Toyato_20All /* 8126903 */:
            case FinalCanbus.CAR_LUZ_Toyato_30All /* 8192439 */:
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CLEAN_AIR = 33;
                ConstAllAirDara.U_AIR_ION = 58;
                ConstAllAirDara.U_AIR_REAR_CTRL = 67;
                ConstAllAirDara.U_AIR_SWING = 35;
                ConstAllAirDara.U_AIR_FRONT_POWER = 10;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 41;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_BLOW_UP = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_LUZ_Toyato_20All /* 8126903 */:
                    case FinalCanbus.CAR_LUZ_Toyato_30All /* 8192439 */:
                        break;
                    default:
                        ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT = 37;
                        break;
                }
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_AIR_ION = 28;
                ConstAllAirDara.C_CLEAN_AIR = 32;
                ConstAllAirDara.C_AIR_SWING = 29;
                ConstAllAirDara.C_REAR_CTRL = 42;
                ConstAllAirDara.C_REAR_MODE = 43;
                ConstAllAirDara.C_REAR_WIND_DOWN = 40;
                ConstAllAirDara.C_REAR_WIND_UP = 41;
                ConstAllAirDara.C_REAR_TEMP_DOWN = 38;
                ConstAllAirDara.C_REAR_TEMP_UP = 39;
                ConstAllAirDara.C_REAR_AUTO = 45;
                ConstAllAirDara.C_REAR_OFF = 44;
                ConstAllAirDara.C_AIR_POWER_FRONT = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 18;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_CONTRAL = 22;
                break;
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460 /* 5308868 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460_H /* 5374404 */:
            case FinalCanbus.CAR_452_LZ_Toyota_LC100 /* 5439940 */:
            case FinalCanbus.CAR_452_LZ_Toyota_LC100_H /* 5505476 */:
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_REARVIEW_HOT = 59;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CLEAN_AIR = 33;
                ConstAllAirDara.U_AIR_REAR_CTRL = 38;
                ConstAllAirDara.U_AIR_SWING = 35;
                ConstAllAirDara.U_AIR_FRONT_POWER = 10;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
                ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 22;
                ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_POWER = 44;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_BLOW_UP = 18;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 19;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 20;
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                ConstAllAirDara.U_AIR_REAR_HEAT = 63;
                ConstAllAirDara.U_AIR_REAR_COOL = 85;
                ConstAllAirDara.C_AIR_POWER_FRONT = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT = 37;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 18;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_CLEAN_AIR = 40;
                ConstAllAirDara.C_AIR_SWING = 60;
                ConstAllAirDara.C_REAR_CTRL = 57;
                ConstAllAirDara.C_AIR_REARVIEW_HOT = 58;
                ConstAllAirDara.C_REAR_MODE = 36;
                ConstAllAirDara.C_REAR_WIND_DOWN = 48;
                ConstAllAirDara.C_REAR_WIND_UP = 49;
                ConstAllAirDara.C_REAR_TEMP_DOWN = 41;
                ConstAllAirDara.C_REAR_TEMP_UP = 42;
                ConstAllAirDara.C_REAR_AUTO = 52;
                ConstAllAirDara.C_REAR_OFF = 61;
                ConstAllAirDara.C_REAR_HEAT = 62;
                ConstAllAirDara.C_REAR_COOL = 63;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_452_ZH_PAJERO_SP /* 5964228 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_BLOW_UP = 48;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 21;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 22;
                ConstAllAirDara.C_AIR_POWER = 16;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 31;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 30;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 33;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 32;
                ConstAllAirDara.C_AIR_WIND_ADD = 29;
                ConstAllAirDara.C_AIR_WIND_SUB = 28;
                ConstAllAirDara.C_AIR_AUTO = 20;
                ConstAllAirDara.C_AIR_AC = 17;
                ConstAllAirDara.C_AIR_CYCLE = 19;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 1;
                ConstAllAirDara.C_REAR_TEMP_DOWN = 36;
                ConstAllAirDara.C_REAR_TEMP_UP = 37;
                ConstAllAirDara.C_REAR_WIND_DOWN = 38;
                ConstAllAirDara.C_REAR_WIND_UP = 39;
                ConstAllAirDara.C_REAR_MODE = 40;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_439_HC_Nissan_Toread /* 7012791 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                ConstAllAirDara.C_REAR_MODE_FOOT = 255;
                ConstAllAirDara.C_REAR_MODE_BODY = 255;
                ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 255;
                ConstAllAirDara.C_REAR_WIND_DOWN = 9;
                ConstAllAirDara.C_REAR_WIND_UP = 10;
                ConstAllAirDara.C_REAR_TEMP_DOWN = 11;
                ConstAllAirDara.C_REAR_TEMP_UP = 12;
                ConstAllAirDara.C_REAR_AUTO = 4;
                ConstAllAirDara.C_REAR_OFF = 0;
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
            case FinalCanbus.CAR_452_KYC_Toyota_Landekuluze /* 14221764 */:
            case FinalCanbus.CAR_452_KYC_Toyota_Runner /* 14287300 */:
            case FinalCanbus.CAR_452_KYC_Toyota_Alpha /* 14352836 */:
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
                ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_REAR_CTRL = 67;
                ConstAllAirDara.U_AIR_CLEAN_AIR = 33;
                ConstAllAirDara.U_AIR_FRONTMAX = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_SWING = 17;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_SYNC = 8;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_CLEAN_AIR = 15;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_REAR_CTRL = 37;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT = 42;
                ConstAllAirDara.C_AIR_SWING = 50;
                ConstAllAirDara.C_REAR_MODE = 47;
                ConstAllAirDara.C_REAR_WIND_DOWN = 46;
                ConstAllAirDara.C_REAR_WIND_UP = 45;
                ConstAllAirDara.C_REAR_TEMP_DOWN = 44;
                ConstAllAirDara.C_REAR_TEMP_UP = 43;
                ConstAllAirDara.C_REAR_AUTO = 49;
                ConstAllAirDara.C_REAR_OFF = 48;
                ConstAllAirDara.C_CONTRAL = 3;
                break;
            case FinalCanbus.CAR_439_HC_Ford_Explorer /* 15335863 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
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
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 19;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 18;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 21;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 20;
                ConstAllAirDara.C_AIR_WIND_ADD = 17;
                ConstAllAirDara.C_AIR_WIND_SUB = 16;
                ConstAllAirDara.C_AIR_DUAL = 7;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 12;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_AC_MAX = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_MODE_UP = 5;
                ConstAllAirDara.C_AIR_MODE_BODY = 8;
                ConstAllAirDara.C_AIR_MODE_FOOT = 9;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 32;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 34;
                ConstAllAirDara.C_AIR_LEFT_COLD = 33;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 35;
                ConstAllAirDara.C_REAR_TEMP_DOWN = 14;
                ConstAllAirDara.C_REAR_TEMP_UP = 15;
                ConstAllAirDara.C_REAR_WIND_DOWN = 12;
                ConstAllAirDara.C_REAR_WIND_UP = 13;
                ConstAllAirDara.C_REAR_LOCK = 31;
                ConstAllAirDara.C_REAR_MODE = 255;
                ConstAllAirDara.C_REAR_OFF = 0;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
        }
    }

    private void init() {
        findViewById(R.id.air_sp_rear_wind_minuts).setOnTouchListener(this);
        findViewById(R.id.air_sp_rear_wind_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_rear_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_rear_munits).setOnTouchListener(this);
        if (ConstAllAirDara.C_REAR_MODE != 255) {
            findViewById(R.id.air_sp_rear_blow_changer).setVisibility(0);
            findViewById(R.id.air_sp_rear_blow_changer).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_rear_blow_changer).setVisibility(8);
        }
        if (ConstAllAirDara.C_REAR_MODE_BODY_FOOT != 255) {
            findViewById(R.id.air_sp_blow_body_foot_rear).setVisibility(0);
            findViewById(R.id.air_sp_blow_body_foot_rear).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_blow_body_foot_rear).setVisibility(8);
        }
        if (ConstAllAirDara.C_REAR_MODE_BODY != 255) {
            findViewById(R.id.air_sp_blow_body_rear).setVisibility(0);
            findViewById(R.id.air_sp_blow_body_rear).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_blow_body_rear).setVisibility(8);
        }
        if (ConstAllAirDara.C_REAR_MODE_FOOT != 255) {
            findViewById(R.id.air_sp_blow_foot_rear).setVisibility(0);
            findViewById(R.id.air_sp_blow_foot_rear).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_blow_foot_rear).setVisibility(8);
        }
        if (ConstAllAirDara.C_REAR_OFF != 255) {
            findViewById(R.id.air_sp_power_rear).setVisibility(0);
            findViewById(R.id.view_sp_power_rear).setVisibility(0);
            findViewById(R.id.air_sp_power_rear).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_power_rear).setVisibility(8);
            findViewById(R.id.view_sp_power_rear).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_FRONT_POWER != 255) {
            findViewById(R.id.air_sp_power_front).setOnTouchListener(this);
            findViewById(R.id.air_sp_power_front).setVisibility(0);
            findViewById(R.id.view_sp_power_front).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_power_front).setVisibility(8);
            findViewById(R.id.view_sp_power_front).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_REAR_LOCK != 255) {
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
        if (ConstAllAirDara.U_AIR_REAR_HEAT != 255) {
            findViewById(R.id.air_sp_heat_rear).setVisibility(0);
            findViewById(R.id.view_sp_heat_rear).setVisibility(0);
            findViewById(R.id.air_sp_heat_rear).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_heat_rear).setVisibility(8);
            findViewById(R.id.view_sp_heat_rear).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_REAR_COOL != 255) {
            findViewById(R.id.air_sp_cool_rear).setVisibility(0);
            findViewById(R.id.view_sp_cool_rear).setVisibility(0);
            findViewById(R.id.air_sp_cool_rear).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_cool_rear).setVisibility(8);
            findViewById(R.id.view_sp_cool_rear).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_BACK_BLOW_AUTO != 255) {
            findViewById(R.id.air_sp_auto_rear).setVisibility(0);
            findViewById(R.id.view_sp_auto_rear).setVisibility(0);
            findViewById(R.id.air_sp_auto_rear).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_auto_rear).setVisibility(8);
            findViewById(R.id.view_sp_auto_rear).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_REAR_CTRL != 255) {
            findViewById(R.id.air_sp_car_rear).setVisibility(0);
            findViewById(R.id.air_sp_car_rear).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_car_rear).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_CLEAN_AIR != 255) {
            findViewById(R.id.air_sp_clean_air).setVisibility(0);
            findViewById(R.id.air_sp_clean_air).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_clean_air).setVisibility(8);
        }
        findViewById(R.id.tv_sp_front).setOnTouchListener(this);
        findViewById(R.id.tv_sp_rear).setOnTouchListener(this);
        findViewById(R.id.air_sp_wind_minuts).setOnTouchListener(this);
        findViewById(R.id.air_sp_wind_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_left_munits).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.air_sp_temp_right_munits).setOnTouchListener(this);
        if (ConstAllAirDara.U_AIR_AC != 255) {
            findViewById(R.id.air_sp_ac).setVisibility(0);
            findViewById(R.id.view_sp_ac).setVisibility(0);
            findViewById(R.id.air_sp_ac).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_ac).setVisibility(8);
            findViewById(R.id.view_sp_ac).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_AC_MAX != 255) {
            findViewById(R.id.air_sp_acmax).setVisibility(0);
            findViewById(R.id.view_sp_acmax).setVisibility(0);
            findViewById(R.id.air_sp_acmax).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_acmax).setVisibility(8);
            findViewById(R.id.view_sp_acmax).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_AUTO != 255) {
            findViewById(R.id.air_sp_auto).setVisibility(0);
            findViewById(R.id.view_sp_auto).setVisibility(0);
            findViewById(R.id.air_sp_auto).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_auto).setVisibility(8);
            findViewById(R.id.view_sp_auto).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_DUAL != 255) {
            findViewById(R.id.air_sp_dual).setVisibility(0);
            findViewById(R.id.view_sp_dual).setVisibility(0);
            findViewById(R.id.air_sp_dual).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_dual).setVisibility(8);
            findViewById(R.id.view_sp_dual).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_SYNC != 255) {
            findViewById(R.id.air_sp_sync).setVisibility(0);
            findViewById(R.id.view_sp_sync).setVisibility(0);
            findViewById(R.id.air_sp_sync).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_sync).setVisibility(8);
            findViewById(R.id.view_sp_sync).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_ZONE != 255) {
            findViewById(R.id.air_sp_zone).setVisibility(0);
            findViewById(R.id.view_sp_zone).setVisibility(0);
            findViewById(R.id.air_sp_zone).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_zone).setVisibility(8);
            findViewById(R.id.view_sp_zone).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_STEER != 255) {
            findViewById(R.id.air_sp_steer).setOnTouchListener(this);
            findViewById(R.id.air_sp_steer).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_steer).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_REARVIEW_HOT != 255) {
            findViewById(R.id.air_sp_rearviewhot).setOnTouchListener(this);
            findViewById(R.id.air_sp_rearviewhot).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_rearviewhot).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_CYCLE != 255) {
            findViewById(R.id.air_sp_cycle).setVisibility(0);
            findViewById(R.id.view_sp_cycle).setVisibility(0);
            findViewById(R.id.air_sp_cycle).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_cycle).setVisibility(8);
            findViewById(R.id.view_sp_cycle).setVisibility(8);
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
        if (ConstAllAirDara.U_AIR_ION != 255) {
            findViewById(R.id.air_sp_ion).setOnTouchListener(this);
            findViewById(R.id.air_sp_ion).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_ion).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_FRONT != 255) {
            findViewById(R.id.air_sp_front).setVisibility(0);
            findViewById(R.id.air_sp_front).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_front).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_FRONTMAX != 255) {
            findViewById(R.id.air_sp_frontmax).setVisibility(0);
            findViewById(R.id.air_sp_frontmax).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_frontmax).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_POWER != 255) {
            findViewById(R.id.air_sp_power).setVisibility(0);
            findViewById(R.id.air_sp_power).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_power).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_REAR != 255) {
            findViewById(R.id.air_sp_rear).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_rear).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_BODY != 255) {
            findViewById(R.id.air_sp_blow_body).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_blow_body).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_FOOT != 255) {
            findViewById(R.id.air_sp_blow_foot).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_blow_foot).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_UP != 255) {
            findViewById(R.id.air_sp_blow_win).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_blow_win).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_BODYFOOT != 255) {
            findViewById(R.id.air_sp_blow_body_foot).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_blow_body_foot).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_UPFOOT != 255) {
            findViewById(R.id.air_sp_blow_foot_win).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_blow_foot_win).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_ADD != 255) {
            findViewById(R.id.air_sp_mode_add).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_mode_add).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_SUB != 255) {
            findViewById(R.id.air_sp_mode_sub).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_mode_sub).setVisibility(8);
        }
        if (ConstAllAirDara.C_AIR_MODE_CHANGER != 255) {
            findViewById(R.id.air_sp_mode_change).setOnTouchListener(this);
            findViewById(R.id.air_sp_blow_changer).setOnTouchListener(this);
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
        } else {
            findViewById(R.id.air_sp_seatwind_left).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_SEATWIND_RIGHT != 255) {
            findViewById(R.id.air_sp_seatwind_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_seatwind_right).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_SEATHEAT_LEFT != 255) {
            findViewById(R.id.air_sp_seatheat_left).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_seatheat_left).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_SEATHEAT_RIGHT != 255) {
            findViewById(R.id.air_sp_seatheat_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_seatheat_right).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_SEATMASSAGE_LEFT != 255) {
            findViewById(R.id.air_sp_seatmassage_left).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_seatmassage_left).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_SEATMASSAGE_RIGHT != 255) {
            findViewById(R.id.air_sp_seatmassage_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_seatmassage_right).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_SEATWAIST_LEFT != 255) {
            findViewById(R.id.air_sp_seatwaist_left).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_seatwaist_left).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_SEATWAIST_RIGHT != 255) {
            findViewById(R.id.air_sp_seatwaist_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_seatwaist_right).setVisibility(8);
        }
        if (ConstAllAirDara.U_AIR_REAR_SEAT_HEAT != 255) {
            findViewById(R.id.air_sp_seatheat_rear).setOnTouchListener(this);
            findViewById(R.id.view_sp_seatheat_rear).setVisibility(0);
            findViewById(R.id.air_sp_seatheat_rear).setVisibility(0);
        } else {
            findViewById(R.id.view_sp_seatheat_rear).setVisibility(8);
            findViewById(R.id.air_sp_seatheat_rear).setVisibility(8);
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
        int data0 = 255;
        switch (id) {
            case R.id.tv_sp_front /* 2131427932 */:
                this.pagenum = 0;
                findViewById(R.id.veiw_air_front).setVisibility(0);
                findViewById(R.id.veiw_air_rear).setVisibility(8);
                ((TextView) findViewById(R.id.tv_sp_front)).setTextColor(Color.parseColor("#02edc0"));
                ((TextView) findViewById(R.id.tv_sp_rear)).setTextColor(Color.parseColor("#ffffff"));
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_439_HC_Nissan_Toread /* 7012791 */:
                        data0 = 128;
                        break;
                }
            case R.id.tv_sp_rear /* 2131427933 */:
                this.pagenum = 1;
                findViewById(R.id.veiw_air_front).setVisibility(8);
                findViewById(R.id.veiw_air_rear).setVisibility(0);
                ((TextView) findViewById(R.id.tv_sp_front)).setTextColor(Color.parseColor("#ffffff"));
                ((TextView) findViewById(R.id.tv_sp_rear)).setTextColor(Color.parseColor("#02edc0"));
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_439_HC_Nissan_Toread /* 7012791 */:
                        data0 = 129;
                        break;
                }
            case R.id.air_sp_mode_change /* 2131428557 */:
            case R.id.air_sp_blow_changer /* 2131430395 */:
                data0 = ConstAllAirDara.C_AIR_MODE_CHANGER;
                break;
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
                    case FinalCanbus.CAR_439_HC_Nissan_Toread /* 7012791 */:
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            data0 = 3;
                            break;
                        } else {
                            data0 = 2;
                            break;
                        }
                    default:
                        data0 = ConstAllAirDara.C_AIR_CYCLE;
                        break;
                }
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
            case R.id.air_sp_rearlock_rear /* 2131430307 */:
                data0 = ConstAllAirDara.C_REAR_LOCK;
                break;
            case R.id.air_sp_sync_rear /* 2131430309 */:
                data0 = ConstAllAirDara.C_REAR_SYNC;
                break;
            case R.id.air_sp_power_rear /* 2131430310 */:
                data0 = ConstAllAirDara.C_REAR_OFF;
                break;
            case R.id.air_sp_rear_wind_minuts /* 2131430311 */:
                data0 = ConstAllAirDara.C_REAR_WIND_DOWN;
                break;
            case R.id.air_sp_rear_wind_plus /* 2131430313 */:
                data0 = ConstAllAirDara.C_REAR_WIND_UP;
                break;
            case R.id.air_sp_auto_rear /* 2131430314 */:
                data0 = ConstAllAirDara.C_REAR_AUTO;
                break;
            case R.id.air_sp_ptc /* 2131430319 */:
                data0 = ConstAllAirDara.C_AIR_PTC;
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
            case R.id.air_sp_blowtop /* 2131430350 */:
                data0 = ConstAllAirDara.C_AIR_BLOWTOP;
                break;
            case R.id.air_sp_zone /* 2131430354 */:
                data0 = ConstAllAirDara.C_AIR_ZONE;
                break;
            case R.id.air_sp_dual /* 2131430357 */:
                data0 = ConstAllAirDara.C_AIR_DUAL;
                break;
            case R.id.air_sp_swing /* 2131430361 */:
                data0 = ConstAllAirDara.C_AIR_SWING;
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
            case R.id.air_sp_blow_changer_right /* 2131430403 */:
                data0 = ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT;
                break;
            case R.id.air_sp_rear_blow_changer /* 2131430446 */:
                data0 = ConstAllAirDara.C_REAR_MODE;
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
            case R.id.air_sp_temp_rear_munits /* 2131430475 */:
                data0 = ConstAllAirDara.C_REAR_TEMP_DOWN;
                break;
            case R.id.air_sp_temp_rear_plus /* 2131430478 */:
                data0 = ConstAllAirDara.C_REAR_TEMP_UP;
                break;
            case R.id.air_sp_blow_body_foot_rear /* 2131430480 */:
                data0 = ConstAllAirDara.C_REAR_MODE_BODY_FOOT;
                break;
            case R.id.air_sp_blow_foot_rear /* 2131430481 */:
                data0 = ConstAllAirDara.C_REAR_MODE_FOOT;
                break;
            case R.id.air_sp_blow_body_rear /* 2131430482 */:
                data0 = ConstAllAirDara.C_REAR_MODE_BODY;
                break;
            case R.id.air_sp_seatheat_rear /* 2131430485 */:
                data0 = ConstAllAirDara.C_REAR_SEAT_HEAT;
                break;
            case R.id.air_sp_cool_rear /* 2131430487 */:
                data0 = ConstAllAirDara.C_REAR_COOL;
                break;
            case R.id.air_sp_heat_rear /* 2131430489 */:
                data0 = ConstAllAirDara.C_REAR_HEAT;
                break;
            case R.id.air_sp_seatmassage_left /* 2131430490 */:
                data0 = ConstAllAirDara.C_AIR_LEFT_MASSAGE;
                break;
            case R.id.air_sp_seatwaist_left /* 2131430491 */:
                data0 = ConstAllAirDara.C_AIR_LEFT_WAIST;
                break;
            case R.id.air_sp_rearviewhot /* 2131430492 */:
                data0 = ConstAllAirDara.C_AIR_REARVIEW_HOT;
                break;
            case R.id.air_sp_seatwaist_right /* 2131430493 */:
                data0 = ConstAllAirDara.C_AIR_RIGHT_WAIST;
                break;
            case R.id.air_sp_seatmassage_right /* 2131430494 */:
                data0 = ConstAllAirDara.C_AIR_RIGHT_MASSAGE;
                break;
            case R.id.air_sp_power_front /* 2131430496 */:
                data0 = ConstAllAirDara.C_AIR_POWER_FRONT;
                break;
        }
        if (event.getAction() == 0) {
            if (data0 != 255) {
                sendCmd(data0, 1);
            }
        } else if (event.getAction() == 1 && data0 != 255) {
            sendCmd(data0, 0);
        }
        return false;
    }

    private void addUpdater() {
        if (ConstAllAirDara.U_AIR_BACK_TEMP != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_TEMP].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BACK_POWER != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_POWER].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_FRONT_POWER != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FRONT_POWER].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_SWING != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SWING].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_ION != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_ION].addNotify(this.mNotifyCanbus, 1);
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
        if (ConstAllAirDara.U_AIR_BACK_BLOW_AUTO != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_BLOW_AUTO].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_BACK_BLOW_WIND != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_BLOW_WIND].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_REAR_CTRL != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR_CTRL].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_CLEAN_AIR != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_CLEAN_AIR].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_REAR_LOCK != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR_LOCK].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_REAR_SYNC != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR_SYNC].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_REAR_HEAT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR_HEAT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_REAR_COOL != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR_COOL].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_REAR != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_CYCLE != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_CYCLE].addNotify(this.mNotifyCanbus, 1);
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
        if (ConstAllAirDara.U_AIR_BLOW_MODE_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_MODE_LEFT].addNotify(this.mNotifyCanbus, 1);
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
        if (ConstAllAirDara.U_AIR_SEATMASSAGE_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATMASSAGE_LEFT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_SEATMASSAGE_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATMASSAGE_RIGHT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_SEATWAIST_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATWAIST_LEFT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_SEATWAIST_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATWAIST_RIGHT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_REAR_SEAT_HEAT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR_SEAT_HEAT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_TEMP_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_TEMP_RIGHT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_TEMP_UNIT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_TEMP_UNIT].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_STEER != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_STEER].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_REARVIEW_HOT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REARVIEW_HOT].addNotify(this.mNotifyCanbus, 1);
        }
    }

    private void removeUpdater() {
        if (ConstAllAirDara.U_AIR_BACK_TEMP != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_TEMP].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BACK_POWER != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_POWER].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_FRONT_POWER != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FRONT_POWER].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_SWING != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SWING].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_ION != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_ION].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BACK_BLOW_UP != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_BLOW_UP].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BACK_BLOW_BODY != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_BLOW_BODY].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BACK_BLOW_FOOT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_BLOW_FOOT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BACK_BLOW_AUTO != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_BLOW_AUTO].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BACK_BLOW_WIND != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BACK_BLOW_WIND].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_REAR_CTRL != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR_CTRL].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_CLEAN_AIR != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_CLEAN_AIR].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_REAR_LOCK != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR_LOCK].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_REAR_SYNC != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR_SYNC].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_REAR_HEAT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR_HEAT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_REAR_COOL != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR_COOL].removeNotify(this.mNotifyCanbus);
        }
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
        if (ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_BLOW_MODE_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_BLOW_MODE_LEFT].removeNotify(this.mNotifyCanbus);
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
        if (ConstAllAirDara.U_AIR_SEATMASSAGE_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATMASSAGE_LEFT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_SEATMASSAGE_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATMASSAGE_RIGHT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_SEATWAIST_LEFT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATWAIST_LEFT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_SEATWAIST_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_SEATWAIST_RIGHT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_REAR_SEAT_HEAT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REAR_SEAT_HEAT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_TEMP_RIGHT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_TEMP_RIGHT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_TEMP_UNIT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_TEMP_UNIT].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_STEER != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_STEER].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_REARVIEW_HOT != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_REARVIEW_HOT].removeNotify(this.mNotifyCanbus);
        }
    }

    
    public void mUpdateBackTemp() {
        int temp = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_TEMP];
        if (((TextView) findViewById(R.id.air_sp_temp_rear)) != null) {
            if (DataCanbus.DATA[1000] == 4980797) {
                if (temp == 0) {
                    ((TextView) findViewById(R.id.air_sp_temp_rear)).setText("LO");
                    ((TextView) findViewById(R.id.air_sp_temp_unit_rear)).setText("");
                }
                if (temp == 129) {
                    ((TextView) findViewById(R.id.air_sp_temp_rear)).setText("HI");
                    ((TextView) findViewById(R.id.air_sp_temp_unit_rear)).setText("");
                    return;
                }
                if (temp == 255) {
                    ((TextView) findViewById(R.id.air_sp_temp_rear)).setText("--");
                    ((TextView) findViewById(R.id.air_sp_temp_unit_rear)).setText("");
                    return;
                }
                int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
                if (TempUnit == 0) {
                    int temp2 = temp * 5;
                    ((TextView) findViewById(R.id.air_sp_temp_rear)).setText((temp2 / 10) + "." + (temp2 % 10));
                } else {
                    ((TextView) findViewById(R.id.air_sp_temp_rear)).setText(new StringBuilder().append(temp + 31).toString());
                }
                mUpdateTempBackUNIT();
                return;
            }
            if (DataCanbus.DATA[1000] == 6685115 || DataCanbus.DATA[1000] == 6750651 || DataCanbus.DATA[1000] == 4981179 || DataCanbus.DATA[1000] == 5046715 || DataCanbus.DATA[1000] == 5112251 || DataCanbus.DATA[1000] == 5177787 || DataCanbus.DATA[1000] == 5571003) {
                if (temp == 1) {
                    ((TextView) findViewById(R.id.air_sp_temp_rear)).setText("LO");
                    ((TextView) findViewById(R.id.air_sp_temp_unit_rear)).setText("");
                    return;
                } else if (temp == 9) {
                    ((TextView) findViewById(R.id.air_sp_temp_rear)).setText("HI");
                    ((TextView) findViewById(R.id.air_sp_temp_unit_rear)).setText("");
                    return;
                } else if (temp == 0) {
                    ((TextView) findViewById(R.id.air_sp_temp_rear)).setText("--");
                    ((TextView) findViewById(R.id.air_sp_temp_unit_rear)).setText("");
                    return;
                } else {
                    ((TextView) findViewById(R.id.air_sp_temp_rear)).setText(new StringBuilder().append(temp).toString());
                    ((TextView) findViewById(R.id.air_sp_temp_unit_rear)).setText("");
                    return;
                }
            }
            if (temp == ConstAllAirDara.TEMPERATURE_LOW) {
                ((TextView) findViewById(R.id.air_sp_temp_rear)).setText("LO");
                ((TextView) findViewById(R.id.air_sp_temp_unit_rear)).setText("");
                return;
            }
            if (temp == ConstAllAirDara.TEMPERATURE_HIGHT) {
                ((TextView) findViewById(R.id.air_sp_temp_rear)).setText("HI");
                ((TextView) findViewById(R.id.air_sp_temp_unit_rear)).setText("");
                return;
            }
            if (temp == ConstAllAirDara.TEMPERATURE_NONE) {
                ((TextView) findViewById(R.id.air_sp_temp_rear)).setText("--");
                ((TextView) findViewById(R.id.air_sp_temp_unit_rear)).setText("");
                return;
            }
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_WC2_ShuPing_14Prado_M /* 196729 */:
                case FinalCanbus.CAR_WC2_ShuPing_14Prado_H /* 262265 */:
                case FinalCanbus.CAR_WC2_ShuPing_Prado_L /* 327801 */:
                case FinalCanbus.CAR_WC2_ShuPing_14Prado_L /* 393337 */:
                case FinalCanbus.CAR_WC2_ShuPing_Prado_M /* 458873 */:
                case FinalCanbus.CAR_WC2_ShuPing_Prado_H /* 524409 */:
                case FinalCanbus.CAR_WC2_ShuPing_Prado_Luxun_ZiDong /* 589945 */:
                case FinalCanbus.CAR_WC2_ShuPing_Prado_Luxun_ZiDongRight /* 655481 */:
                case FinalCanbus.CAR_WC2_ShuPing_14Prado_H_NoAMP /* 721017 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        ((TextView) findViewById(R.id.air_sp_temp_rear)).setText(new StringBuilder().append((temp * 9) + 320).toString());
                    } else {
                        int temp3 = temp * 5;
                        ((TextView) findViewById(R.id.air_sp_temp_rear)).setText((temp3 / 10) + "." + (temp3 % 10));
                    }
                    mUpdateTempBackUNIT();
                    break;
                case FinalCanbus.CAR_RZC_15Ruijie /* 196942 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand /* 1311174 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto /* 1376710 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand /* 1442246 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto /* 1507782 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand_S /* 1573318 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto_S /* 1638854 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand_S /* 1704390 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto_S /* 1769926 */:
                case FinalCanbus.CAR_RZC_Ford_Lincoln_navigator /* 1900878 */:
                case FinalCanbus.CAR_452_LZ_Ford_Mustang /* 11403716 */:
                case FinalCanbus.CAR_452_LZ_Ford_Mustang_H /* 14090692 */:
                case FinalCanbus.CAR_439_HC_Ford_Explorer /* 15335863 */:
                    ((TextView) findViewById(R.id.air_sp_temp_rear)).setText(new StringBuilder().append(temp).toString());
                    ((TextView) findViewById(R.id.air_sp_temp_unit_rear)).setText("");
                    break;
                case FinalCanbus.CAR_439_OuDi_Haval_H9 /* 1376695 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_RS /* 15598007 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                case FinalCanbus.CAR_452_OD_Haval_VV5 /* 16122308 */:
                case FinalCanbus.CAR_452_OD_Haval_VV6 /* 16187844 */:
                case FinalCanbus.CAR_452_OD_Haval_VV7 /* 16253380 */:
                case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                    if (temp == 0) {
                        ((TextView) findViewById(R.id.air_sp_temp_rear)).setText("--.-");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_rear)).setText("");
                        break;
                    } else {
                        int temp4 = ((temp - 116) * 5) + 160;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                            ((TextView) findViewById(R.id.air_sp_temp_rear)).setText((temp4 / 10) + "." + (temp4 % 10));
                        } else {
                            ((TextView) findViewById(R.id.air_sp_temp_rear)).setText(new StringBuilder().append(temp4).toString());
                        }
                        mUpdateTempBackUNIT();
                        break;
                    }
                case FinalCanbus.CAR_452_XinCheng_Infiniti_15QX60 /* 1900996 */:
                case FinalCanbus.CAR_439_HC_Nissan_Toread /* 7012791 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        ((TextView) findViewById(R.id.air_sp_temp_rear)).setText(new StringBuilder().append(((temp * 9) + 635) / 10).toString());
                    } else {
                        int temp5 = (temp * 5) + 175;
                        ((TextView) findViewById(R.id.air_sp_temp_rear)).setText((temp5 / 10) + "." + (temp5 % 10));
                    }
                    mUpdateTempBackUNIT();
                    break;
                case FinalCanbus.CAR_RZC_Haval_H9 /* 2490807 */:
                case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                    if (temp == 0) {
                        ((TextView) findViewById(R.id.air_sp_temp_rear)).setText("--.-");
                        ((TextView) findViewById(R.id.air_sp_temp_unit_rear)).setText("");
                        break;
                    } else {
                        int temp6 = ((temp - 112) * 5) + 160;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                            ((TextView) findViewById(R.id.air_sp_temp_rear)).setText((temp6 / 10) + "." + (temp6 % 10));
                        } else {
                            ((TextView) findViewById(R.id.air_sp_temp_rear)).setText(new StringBuilder().append(temp6).toString());
                        }
                        mUpdateTempBackUNIT();
                        break;
                    }
                case FinalCanbus.CAR_452_DJ_Dodge_JCUV /* 4981188 */:
                    if (temp >= 1 && temp <= 18) {
                        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                            ((TextView) findViewById(R.id.air_sp_temp_rear)).setText(new StringBuilder().append((((temp + 13) * 18) + 320) / 10).toString());
                        } else {
                            ((TextView) findViewById(R.id.air_sp_temp_rear)).setText(new StringBuilder().append((temp + 13) * 1.0f).toString());
                        }
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_rear)).setText("None");
                    }
                    mUpdateTempBackUNIT();
                    break;
                case FinalCanbus.CAR_452_KYC_Toyota_Landekuluze /* 14221764 */:
                case FinalCanbus.CAR_452_KYC_Toyota_Runner /* 14287300 */:
                case FinalCanbus.CAR_452_KYC_Toyota_Alpha /* 14352836 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        int temp7 = temp * 5;
                        ((TextView) findViewById(R.id.air_sp_temp_rear)).setText((temp7 / 10) + "." + (temp7 % 10));
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_rear)).setText(new StringBuilder().append(temp + 31).toString());
                    }
                    mUpdateTempBackUNIT();
                    break;
                default:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        ((TextView) findViewById(R.id.air_sp_temp_rear)).setText((temp / 10) + "." + (temp % 10));
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_rear)).setText(new StringBuilder().append(temp).toString());
                    }
                    mUpdateTempBackUNIT();
                    break;
            }
        }
    }

    
    public void mUpdateFrontPower() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT_POWER];
        findViewById(R.id.air_sp_power_front).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_power_rear_n : R.drawable.ic_sp_power_rear_p);
    }

    
    public void mUpdateBackPower() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_POWER];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_BNR_ShuPing_15HighLand_L /* 917901 */:
            case FinalCanbus.CAR_BNR_ShuPing_15HighLand_H /* 983437 */:
            case FinalCanbus.CAR_BNR_ShuPing_09HighLand_L /* 1048973 */:
            case FinalCanbus.CAR_BNR_ShuPing_09HighLand_H /* 1114509 */:
            case FinalCanbus.CAR_RZC_ShuPing_15HighLand_L /* 3146125 */:
            case FinalCanbus.CAR_RZC_ShuPing_15HighLand_H /* 3211661 */:
            case FinalCanbus.CAR_RZC_ShuPing_09HighLand_L /* 3277197 */:
            case FinalCanbus.CAR_RZC_ShuPing_09HighLand_H /* 3342733 */:
            case FinalCanbus.CAR_452_KYC_Toyota_Landekuluze /* 14221764 */:
            case FinalCanbus.CAR_452_KYC_Toyota_Runner /* 14287300 */:
            case FinalCanbus.CAR_452_KYC_Toyota_Alpha /* 14352836 */:
                break;
            default:
                findViewById(R.id.air_sp_power_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_power_rear_n : R.drawable.ic_sp_power_rear_p);
                break;
        }
    }

    private void updateBlowBackMode() {
        int i = R.drawable.ic_sp_mode_foot_p;
        int i2 = R.drawable.ic_sp_mode_body_p;
        if (ConstAllAirDara.U_AIR_BACK_BLOW_UP == 255) {
            DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_UP] = 0;
        }
        boolean b_body_foot = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_UP] != 1 && DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_BODY] == 1 && DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_FOOT] == 1;
        boolean b_up_foot = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_UP] == 1 && DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_BODY] != 1 && DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_FOOT] == 1;
        boolean b_foot = (DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_UP] == 1 || DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_BODY] == 1 || DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_FOOT] != 1) ? false : true;
        boolean b_body = (DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_UP] == 1 || DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_FOOT] == 1 || DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_BODY] != 1) ? false : true;
        boolean b_up = (DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_UP] != 1 || DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_FOOT] == 1 || DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_BODY] == 1) ? false : true;
        boolean b_up_body = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_UP] == 1 && DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_FOOT] != 1 && DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_BODY] == 1;
        boolean b_up_body_foot = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_UP] == 1 && DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_FOOT] == 1 && DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_BODY] == 1;
        boolean b_null = (DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_UP] == 1 || DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_FOOT] == 1 || DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_BODY] == 1) ? false : true;
        if (b_body_foot) {
            findViewById(R.id.air_sp_rear_blow_changer).setBackgroundResource(R.drawable.ic_sp_mode_body_foot_p);
        } else if (b_up_foot) {
            findViewById(R.id.air_sp_rear_blow_changer).setBackgroundResource(R.drawable.ic_sp_mode_win_foot_p);
        } else if (b_foot) {
            findViewById(R.id.air_sp_rear_blow_changer).setBackgroundResource(R.drawable.ic_sp_mode_foot_p);
        } else if (b_body) {
            findViewById(R.id.air_sp_rear_blow_changer).setBackgroundResource(R.drawable.ic_sp_mode_body_p);
        } else if (b_up) {
            findViewById(R.id.air_sp_rear_blow_changer).setBackgroundResource(R.drawable.ic_sp_mode_win_p);
        } else if (b_up_body) {
            findViewById(R.id.air_sp_rear_blow_changer).setBackgroundResource(R.drawable.ic_sp_mode_body_win_p);
        } else if (b_up_body_foot) {
            findViewById(R.id.air_sp_rear_blow_changer).setBackgroundResource(R.drawable.ic_sp_mode_body_foot_win_p);
        } else if (b_null) {
            findViewById(R.id.air_sp_rear_blow_changer).setBackgroundResource(R.drawable.ic_sp_mode_null);
        }
        if (ConstAllAirDara.C_REAR_MODE_BODY_FOOT == 255) {
            findViewById(R.id.air_sp_blow_body_rear).setBackgroundResource(DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_BODY] == 1 ? 2130841936 : R.drawable.ic_sp_mode_body_n);
            findViewById(R.id.air_sp_blow_foot_rear).setBackgroundResource(DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_FOOT] == 1 ? 2130841940 : R.drawable.ic_sp_mode_foot_n);
            return;
        }
        findViewById(R.id.air_sp_blow_body_foot_rear).setBackgroundResource(b_body_foot ? R.drawable.ic_sp_mode_body_foot_p : R.drawable.ic_sp_mode_body_foot_n);
        View findViewById = findViewById(R.id.air_sp_blow_body_rear);
        if (!b_body) {
            i2 = R.drawable.ic_sp_mode_body_n;
        }
        findViewById.setBackgroundResource(i2);
        View findViewById2 = findViewById(R.id.air_sp_blow_foot_rear);
        if (!b_foot) {
            i = R.drawable.ic_sp_mode_foot_n;
        }
        findViewById2.setBackgroundResource(i);
    }

    
    public void mUpdateBackUp() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_UP];
        if (ConstAllAirDara.U_AIR_BACK_BLOW_UP == 255) {
            if (ConstAllAirDara.U_AIR_BACK_BLOW_BODY != 255) {
                int vel2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_BODY];
                findViewById(R.id.air_sp_rear_mode_up).setVisibility(vel2 != 0 ? 0 : 8);
            } else {
                findViewById(R.id.air_sp_rear_mode_up).setVisibility(8);
            }
        } else {
            findViewById(R.id.air_sp_rear_mode_up).setVisibility(vel != 0 ? 0 : 8);
        }
        updateBlowBackMode();
    }

    
    public void mUpdateBackBody() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_BODY];
        if (ConstAllAirDara.U_AIR_BACK_BLOW_BODY == 255) {
            findViewById(R.id.air_sp_rear_mode_body).setVisibility(8);
        } else {
            findViewById(R.id.air_sp_rear_mode_body).setVisibility(vel != 0 ? 0 : 8);
        }
        updateBlowBackMode();
    }

    
    public void mUpdateBackFoot() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_FOOT];
        if (ConstAllAirDara.U_AIR_BACK_BLOW_FOOT == 255) {
            findViewById(R.id.air_sp_rear_mode_foot).setVisibility(8);
        } else {
            findViewById(R.id.air_sp_rear_mode_foot).setVisibility(vel != 0 ? 0 : 8);
        }
        updateBlowBackMode();
    }

    
    public void mUpdateBackAuto() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_AUTO];
        findViewById(R.id.air_sp_auto_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_auto_n : R.drawable.ic_sp_auto_p);
    }

    
    public void mUpdateBackRearLock() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_LOCK];
        findViewById(R.id.air_sp_rearlock_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_rearlock_n : R.drawable.ic_sp_rearlock_p);
    }

    
    public void mUpdateBackSync() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_SYNC];
        findViewById(R.id.air_sp_sync_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_sync_n : R.drawable.ic_sp_sync_p);
    }

    
    public void mUpdateBackWind() {
        int leave = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_WIND] & 255;
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_BNR_ShuPing_15HighLand_L /* 917901 */:
            case FinalCanbus.CAR_BNR_ShuPing_15HighLand_H /* 983437 */:
            case FinalCanbus.CAR_BNR_ShuPing_09HighLand_L /* 1048973 */:
            case FinalCanbus.CAR_BNR_ShuPing_09HighLand_H /* 1114509 */:
            case FinalCanbus.CAR_RZC_ShuPing_15HighLand_L /* 3146125 */:
            case FinalCanbus.CAR_RZC_ShuPing_15HighLand_H /* 3211661 */:
            case FinalCanbus.CAR_RZC_ShuPing_09HighLand_L /* 3277197 */:
            case FinalCanbus.CAR_RZC_ShuPing_09HighLand_H /* 3342733 */:
            case FinalCanbus.CAR_452_KYC_Toyota_Landekuluze /* 14221764 */:
            case FinalCanbus.CAR_452_KYC_Toyota_Runner /* 14287300 */:
            case FinalCanbus.CAR_452_KYC_Toyota_Alpha /* 14352836 */:
                findViewById(R.id.air_sp_power_rear).setBackgroundResource(leave == 0 ? R.drawable.ic_sp_power_rear_n : R.drawable.ic_sp_power_rear_p);
                break;
        }
        findViewById(R.id.air_sp_rear_wind_txt).setVisibility(8);
        findViewById(R.id.air_sp_rear_wind_lev).setVisibility(0);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_439_OuDi_Haval_H9 /* 1376695 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
            case FinalCanbus.CAR_RZC_Haval_H9 /* 2490807 */:
            case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460 /* 5308868 */:
            case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460_H /* 5374404 */:
            case FinalCanbus.CAR_452_LZ_Toyota_LC100 /* 5439940 */:
            case FinalCanbus.CAR_452_LZ_Toyota_LC100_H /* 5505476 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_RS /* 15598007 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
            case FinalCanbus.CAR_452_OD_Haval_VV5 /* 16122308 */:
            case FinalCanbus.CAR_452_OD_Haval_VV6 /* 16187844 */:
            case FinalCanbus.CAR_452_OD_Haval_VV7 /* 16253380 */:
            case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
            case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
            case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                findViewById(R.id.air_sp_rear_wind_lev).setVisibility(8);
                findViewById(R.id.air_sp_rear_wind_txt).setVisibility(0);
                ((TextView) findViewById(R.id.air_sp_rear_wind_txt)).setText(new StringBuilder().append(leave).toString());
                break;
            case FinalCanbus.CAR_RZC_ALL_GM_Enclave_SP /* 4980797 */:
                findViewById(R.id.air_sp_rear_wind_lev).setVisibility(8);
                findViewById(R.id.air_sp_rear_wind_txt).setVisibility(0);
                if (leave == 15) {
                    ((TextView) findViewById(R.id.air_sp_rear_wind_txt)).setText("A");
                    break;
                } else {
                    ((TextView) findViewById(R.id.air_sp_rear_wind_txt)).setText(new StringBuilder().append(leave).toString());
                    break;
                }
            default:
                findViewById(R.id.air_sp_rear_wind_txt).setVisibility(8);
                switch (leave) {
                    case 0:
                        findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind7_0);
                        break;
                    case 1:
                        findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind7_1);
                        break;
                    case 2:
                        findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind7_2);
                        break;
                    case 3:
                        findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind7_3);
                        break;
                    case 4:
                        findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind7_4);
                        break;
                    case 5:
                        findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind7_5);
                        break;
                    case 6:
                        findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind7_6);
                        break;
                    case 7:
                        findViewById(R.id.air_sp_rear_wind_lev).setBackgroundResource(R.drawable.d_air_sp_wind7_7);
                        break;
                }
        }
    }

    
    public void mUpdateRearCtrl() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_CTRL];
        findViewById(R.id.air_sp_car_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_carrear_n : R.drawable.ic_sp_carrear_p);
    }

    
    public void mUpdateCleanAir() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_CLEAN_AIR];
        findViewById(R.id.air_sp_clean_air).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_cleanair_n : R.drawable.ic_sp_cleanair_p);
    }

    
    public void mUpdateRearHeat() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_HEAT];
        findViewById(R.id.air_sp_heat_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_heat_n : R.drawable.ic_sp_heat_p);
    }

    
    public void mUpdateRearCool() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_COOL];
        findViewById(R.id.air_sp_cool_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_cool_n : R.drawable.ic_sp_cool_p);
    }

    
    public void mUpdateHeatLeft() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT];
        if (DataCanbus.DATA[1000] == 334 || DataCanbus.DATA[1000] == 1900878 || DataCanbus.DATA[1000] == 196942) {
            if (vel <= 3) {
                vel = 0;
            } else {
                vel -= 3;
            }
        }
        findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(vel == 0 ? R.drawable.ic_air_sp_seatheat_left : R.drawable.ic_air_sp_seatheat_left_p);
        ((TextView) findViewById(R.id.air_sp_seatheat_left)).setText(new StringBuilder().append(vel).toString());
    }

    
    public void mUpdateHeatRight() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT];
        if (DataCanbus.DATA[1000] == 1900878 || DataCanbus.DATA[1000] == 196942) {
            if (vel <= 3) {
                vel = 0;
            } else {
                vel -= 3;
            }
        }
        findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(vel == 0 ? R.drawable.ic_air_sp_seatheat_right : R.drawable.ic_air_sp_seatheat_right_p);
        ((TextView) findViewById(R.id.air_sp_seatheat_right)).setText(new StringBuilder().append(vel).toString());
    }

    
    public void mUpdateWindLeft() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_LEFT];
        if ((DataCanbus.DATA[1000] == 1900878 || DataCanbus.DATA[1000] == 196942 || DataCanbus.DATA[1000] == 1376695 || DataCanbus.DATA[1000] == 1769911 || DataCanbus.DATA[1000] == 15598007 || DataCanbus.DATA[1000] == 15663543 || DataCanbus.DATA[1000] == 16122308 || DataCanbus.DATA[1000] == 16187844 || DataCanbus.DATA[1000] == 16253380 || DataCanbus.DATA[1000] == 16318916 || DataCanbus.DATA[1000] == 16384452 || DataCanbus.DATA[1000] == 16449988) && vel > 3) {
            vel = 0;
        }
        findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(vel == 0 ? R.drawable.ic_air_sp_seatwind_left : R.drawable.ic_air_sp_seatwind_left_p);
        ((TextView) findViewById(R.id.air_sp_seatwind_left)).setText(new StringBuilder().append(vel).toString());
    }

    
    public void mUpdateWindRight() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_RIGHT];
        if ((DataCanbus.DATA[1000] == 1900878 || DataCanbus.DATA[1000] == 196942 || DataCanbus.DATA[1000] == 1376695 || DataCanbus.DATA[1000] == 1769911 || DataCanbus.DATA[1000] == 15598007 || DataCanbus.DATA[1000] == 15663543 || DataCanbus.DATA[1000] == 16122308 || DataCanbus.DATA[1000] == 16187844 || DataCanbus.DATA[1000] == 16253380 || DataCanbus.DATA[1000] == 16318916 || DataCanbus.DATA[1000] == 16384452 || DataCanbus.DATA[1000] == 16449988) && vel > 3) {
            vel = 0;
        }
        findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(vel == 0 ? R.drawable.ic_air_sp_seatwind_right : R.drawable.ic_air_sp_seatwind_right_p);
        ((TextView) findViewById(R.id.air_sp_seatwind_right)).setText(new StringBuilder().append(vel).toString());
    }

    
    public void mUpdateMassageLeft() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATMASSAGE_LEFT];
        findViewById(R.id.air_sp_seatmassage_left).setBackgroundResource(vel == 0 ? R.drawable.ic_air_sp_seatmassage_left_n : R.drawable.ic_air_sp_seatmassage_left_p);
        ((TextView) findViewById(R.id.air_sp_seatmassage_left)).setText(new StringBuilder().append(vel).toString());
    }

    
    public void mUpdateMassageRight() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATMASSAGE_RIGHT];
        findViewById(R.id.air_sp_seatmassage_right).setBackgroundResource(vel == 0 ? R.drawable.ic_air_sp_seatmassage_right_n : R.drawable.ic_air_sp_seatmassage_right_p);
        ((TextView) findViewById(R.id.air_sp_seatmassage_right)).setText(new StringBuilder().append(vel).toString());
    }

    
    public void mUpdateWaistLeft() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWAIST_LEFT];
        findViewById(R.id.air_sp_seatwaist_left).setBackgroundResource(vel == 0 ? R.drawable.ic_air_sp_seatwaist_left_n : R.drawable.ic_air_sp_seatwaist_left_p);
        ((TextView) findViewById(R.id.air_sp_seatwaist_left)).setText(new StringBuilder().append(vel).toString());
    }

    
    public void mUpdateWaistRight() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWAIST_RIGHT];
        findViewById(R.id.air_sp_seatwaist_right).setBackgroundResource(vel == 0 ? R.drawable.ic_air_sp_seatwaist_right_n : R.drawable.ic_air_sp_seatwaist_right_p);
        ((TextView) findViewById(R.id.air_sp_seatwaist_right)).setText(new StringBuilder().append(vel).toString());
    }

    
    public void mUpdateRearSeatHeat() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_SEAT_HEAT];
        findViewById(R.id.air_sp_seatheat_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_seatheat_rear_n : R.drawable.ic_sp_seatheat_rear_p);
        ((TextView) findViewById(R.id.air_sp_seatheat_rear)).setText(new StringBuilder().append(vel).toString());
    }

    
    public void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT];
        if (((TextView) findViewById(R.id.air_sp_temp_left)) != null) {
            if (temp == ConstAllAirDara.TEMPERATURE_LOW) {
                ((TextView) findViewById(R.id.air_sp_temp_left)).setText("LO");
                ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
            }
            if (temp == ConstAllAirDara.TEMPERATURE_HIGHT) {
                ((TextView) findViewById(R.id.air_sp_temp_left)).setText("HI");
                ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                return;
            }
            if (temp == ConstAllAirDara.TEMPERATURE_NONE) {
                ((TextView) findViewById(R.id.air_sp_temp_left)).setText("--");
                ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText("");
                return;
            }
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_WC2_ShuPing_14Prado_M /* 196729 */:
                case FinalCanbus.CAR_WC2_ShuPing_14Prado_H /* 262265 */:
                case FinalCanbus.CAR_WC2_ShuPing_Prado_L /* 327801 */:
                case FinalCanbus.CAR_WC2_ShuPing_14Prado_L /* 393337 */:
                case FinalCanbus.CAR_WC2_ShuPing_Prado_M /* 458873 */:
                case FinalCanbus.CAR_WC2_ShuPing_Prado_H /* 524409 */:
                case FinalCanbus.CAR_WC2_ShuPing_Prado_Luxun_ZiDong /* 589945 */:
                case FinalCanbus.CAR_WC2_ShuPing_Prado_Luxun_ZiDongRight /* 655481 */:
                case FinalCanbus.CAR_WC2_ShuPing_14Prado_H_NoAMP /* 721017 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand /* 1311174 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto /* 1376710 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand /* 1442246 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto /* 1507782 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand_S /* 1573318 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto_S /* 1638854 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand_S /* 1704390 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto_S /* 1769926 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_15QX60 /* 1900996 */:
                case FinalCanbus.CAR_452_LZ_Ford_Mustang /* 11403716 */:
                case FinalCanbus.CAR_452_LZ_Ford_Mustang_H /* 14090692 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(((temp * 9) + 320) / 10).toString());
                    } else {
                        int temp2 = temp * 5;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp2 / 10) + "." + (temp2 % 10));
                    }
                    mUpdateTempLeftUNIT();
                    break;
                case FinalCanbus.CAR_439_OuDi_Haval_H9 /* 1376695 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_RS /* 15598007 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                case FinalCanbus.CAR_452_OD_Haval_VV5 /* 16122308 */:
                case FinalCanbus.CAR_452_OD_Haval_VV6 /* 16187844 */:
                case FinalCanbus.CAR_452_OD_Haval_VV7 /* 16253380 */:
                case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                    if (temp == 0) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("----");
                    } else {
                        int temp3 = ((temp - 116) * 5) + 160;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                            ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp3 / 10) + "." + (temp3 % 10));
                        } else {
                            ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(temp3).toString());
                        }
                    }
                    mUpdateTempLeftUNIT();
                    break;
                case FinalCanbus.CAR_RZC_Haval_H9 /* 2490807 */:
                case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                    if (temp == 0) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("----");
                    } else {
                        int temp4 = ((temp - 112) * 5) + 160;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                            ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp4 / 10) + "." + (temp4 % 10));
                        } else {
                            ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(temp4).toString());
                        }
                    }
                    mUpdateTempLeftUNIT();
                    break;
                case FinalCanbus.CAR_RZC_ALL_GM_Enclave_SP /* 4980797 */:
                    int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
                    if (TempUnit == 1) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(((temp * 9) / 50) + 32).toString());
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp / 10) + "." + (temp % 10));
                    }
                    mUpdateTempLeftUNIT();
                    break;
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                case FinalCanbus.CAR_443_WC2_Ford_EDGE_11 /* 6685115 */:
                case FinalCanbus.CAR_443_WC2_Ford_EDGE_11_CD /* 6750651 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        int temp5 = temp * 5;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp5 / 10) + "." + (temp5 % 10));
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(temp).toString());
                    }
                    mUpdateTempLeftUNIT();
                    break;
                case FinalCanbus.CAR_452_DJ_Dodge_JCUV /* 4981188 */:
                    if (temp >= 1 && temp <= 18) {
                        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                            ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append((((temp + 13) * 18) + 320) / 10).toString());
                        } else {
                            ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append((temp + 13) * 1.0f).toString());
                        }
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText("None");
                    }
                    mUpdateTempLeftUNIT();
                    break;
                case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460 /* 5308868 */:
                case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460_H /* 5374404 */:
                case FinalCanbus.CAR_452_LZ_Toyota_LC100 /* 5439940 */:
                case FinalCanbus.CAR_452_LZ_Toyota_LC100_H /* 5505476 */:
                case FinalCanbus.CAR_439_HC_Nissan_Toread /* 7012791 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(((temp * 9) + 635) / 10).toString());
                    } else {
                        int temp6 = (temp * 5) + 175;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp6 / 10) + "." + (temp6 % 10));
                    }
                    mUpdateTempLeftUNIT();
                    break;
                case FinalCanbus.CAR_452_KYC_Toyota_Landekuluze /* 14221764 */:
                case FinalCanbus.CAR_452_KYC_Toyota_Runner /* 14287300 */:
                case FinalCanbus.CAR_452_KYC_Toyota_Alpha /* 14352836 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        int temp7 = temp * 5;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp7 / 10) + "." + (temp7 % 10));
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(temp + 31).toString());
                    }
                    mUpdateTempLeftUNIT();
                    break;
                case FinalCanbus.CAR_439_HC_Ford_Explorer /* 15335863 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        int temp8 = temp * 5;
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp8 / 10) + "." + (temp8 % 10));
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(temp).toString());
                    }
                    mUpdateTempLeftUNIT();
                    break;
                default:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText((temp / 10) + "." + (temp % 10));
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_left)).setText(new StringBuilder().append(temp).toString());
                    }
                    mUpdateTempLeftUNIT();
                    break;
            }
        }
    }

    
    public void mUpdateTempRight() {
        int temp = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_RIGHT];
        if (((TextView) findViewById(R.id.air_sp_temp_right)) != null) {
            if (temp == ConstAllAirDara.TEMPERATURE_LOW) {
                ((TextView) findViewById(R.id.air_sp_temp_right)).setText("LO");
                ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
            }
            if (temp == ConstAllAirDara.TEMPERATURE_HIGHT) {
                ((TextView) findViewById(R.id.air_sp_temp_right)).setText("HI");
                ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                return;
            }
            if (temp == ConstAllAirDara.TEMPERATURE_NONE) {
                ((TextView) findViewById(R.id.air_sp_temp_right)).setText("--");
                ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText("");
                return;
            }
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_WC2_ShuPing_14Prado_M /* 196729 */:
                case FinalCanbus.CAR_WC2_ShuPing_14Prado_H /* 262265 */:
                case FinalCanbus.CAR_WC2_ShuPing_Prado_L /* 327801 */:
                case FinalCanbus.CAR_WC2_ShuPing_14Prado_L /* 393337 */:
                case FinalCanbus.CAR_WC2_ShuPing_Prado_M /* 458873 */:
                case FinalCanbus.CAR_WC2_ShuPing_Prado_H /* 524409 */:
                case FinalCanbus.CAR_WC2_ShuPing_Prado_Luxun_ZiDong /* 589945 */:
                case FinalCanbus.CAR_WC2_ShuPing_Prado_Luxun_ZiDongRight /* 655481 */:
                case FinalCanbus.CAR_WC2_ShuPing_14Prado_H_NoAMP /* 721017 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand /* 1311174 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto /* 1376710 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand /* 1442246 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto /* 1507782 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand_S /* 1573318 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto_S /* 1638854 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand_S /* 1704390 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto_S /* 1769926 */:
                case FinalCanbus.CAR_452_XinCheng_Infiniti_15QX60 /* 1900996 */:
                case FinalCanbus.CAR_452_LZ_Ford_Mustang /* 11403716 */:
                case FinalCanbus.CAR_452_LZ_Ford_Mustang_H /* 14090692 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(((temp * 9) + 320) / 10).toString());
                    } else {
                        int temp2 = temp * 5;
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp2 / 10) + "." + (temp2 % 10));
                    }
                    mUpdateTempRightUNIT();
                    break;
                case FinalCanbus.CAR_439_OuDi_Haval_H9 /* 1376695 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_RS /* 15598007 */:
                case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
                case FinalCanbus.CAR_452_OD_Haval_VV5 /* 16122308 */:
                case FinalCanbus.CAR_452_OD_Haval_VV6 /* 16187844 */:
                case FinalCanbus.CAR_452_OD_Haval_VV7 /* 16253380 */:
                case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
                case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
                case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                    if (temp == 0) {
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText("----");
                    } else {
                        int temp3 = ((temp - 116) * 5) + 160;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                            ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp3 / 10) + "." + (temp3 % 10));
                        } else {
                            ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(temp3).toString());
                        }
                    }
                    mUpdateTempRightUNIT();
                    break;
                case FinalCanbus.CAR_RZC_Haval_H9 /* 2490807 */:
                case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
                    if (temp == 0) {
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText("----");
                    } else {
                        int temp4 = ((temp - 112) * 5) + 160;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                            ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp4 / 10) + "." + (temp4 % 10));
                        } else {
                            ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(temp4).toString());
                        }
                    }
                    mUpdateTempRightUNIT();
                    break;
                case FinalCanbus.CAR_RZC_ALL_GM_Enclave_SP /* 4980797 */:
                    int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
                    if (TempUnit == 1) {
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(((temp * 9) / 50) + 32).toString());
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp / 10) + "." + (temp % 10));
                    }
                    mUpdateTempRightUNIT();
                    break;
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                case FinalCanbus.CAR_443_WC2_Ford_EDGE_11 /* 6685115 */:
                case FinalCanbus.CAR_443_WC2_Ford_EDGE_11_CD /* 6750651 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        int temp5 = temp * 5;
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp5 / 10) + "." + (temp5 % 10));
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(temp).toString());
                    }
                    mUpdateTempRightUNIT();
                    break;
                case FinalCanbus.CAR_452_DJ_Dodge_JCUV /* 4981188 */:
                    if (temp >= 1 && temp <= 18) {
                        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                            ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append((((temp + 13) * 18) + 320) / 10).toString());
                        } else {
                            ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append((temp + 13) * 1.0f).toString());
                        }
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText("None");
                    }
                    mUpdateTempRightUNIT();
                    break;
                case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460 /* 5308868 */:
                case FinalCanbus.CAR_452_LZ_Toyota_Lexus_LS460_H /* 5374404 */:
                case FinalCanbus.CAR_452_LZ_Toyota_LC100 /* 5439940 */:
                case FinalCanbus.CAR_452_LZ_Toyota_LC100_H /* 5505476 */:
                case FinalCanbus.CAR_439_HC_Nissan_Toread /* 7012791 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(((temp * 9) + 635) / 10).toString());
                    } else {
                        int temp6 = (temp * 5) + 175;
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp6 / 10) + "." + (temp6 % 10));
                    }
                    mUpdateTempRightUNIT();
                    break;
                case FinalCanbus.CAR_452_KYC_Toyota_Landekuluze /* 14221764 */:
                case FinalCanbus.CAR_452_KYC_Toyota_Runner /* 14287300 */:
                case FinalCanbus.CAR_452_KYC_Toyota_Alpha /* 14352836 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        int temp7 = temp * 5;
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp7 / 10) + "." + (temp7 % 10));
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(temp + 31).toString());
                    }
                    mUpdateTempRightUNIT();
                    break;
                case FinalCanbus.CAR_439_HC_Ford_Explorer /* 15335863 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        int temp8 = temp * 5;
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp8 / 10) + "." + (temp8 % 10));
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(temp).toString());
                    }
                    mUpdateTempRightUNIT();
                    break;
                default:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText((temp / 10) + "." + (temp % 10));
                    } else {
                        ((TextView) findViewById(R.id.air_sp_temp_right)).setText(new StringBuilder().append(temp).toString());
                    }
                    mUpdateTempRightUNIT();
                    break;
            }
        }
    }

    private void mUpdateTempLeftUNIT() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT];
        if (ConstAllAirDara.U_AIR_TEMP_UNIT != 255) {
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                case FinalCanbus.CAR_443_WC2_Ford_EDGE_11 /* 6685115 */:
                case FinalCanbus.CAR_443_WC2_Ford_EDGE_11_CD /* 6750651 */:
                    ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText(vel == 1 ? "℃" : "℉");
                    break;
                default:
                    ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText(vel == 0 ? "℃" : "℉");
                    break;
            }
            return;
        }
        ((TextView) findViewById(R.id.air_sp_temp_unit_left)).setText(SystemProperties.getInt("persist.fyt.temperature", 0) == 0 ? "℃" : "℉");
    }

    private void mUpdateTempRightUNIT() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT];
        if (ConstAllAirDara.U_AIR_TEMP_UNIT != 255) {
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
                case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                case FinalCanbus.CAR_443_WC2_Ford_EDGE_11 /* 6685115 */:
                case FinalCanbus.CAR_443_WC2_Ford_EDGE_11_CD /* 6750651 */:
                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText(vel == 1 ? "℃" : "℉");
                    break;
                default:
                    ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText(vel == 0 ? "℃" : "℉");
                    break;
            }
            return;
        }
        ((TextView) findViewById(R.id.air_sp_temp_unit_right)).setText(SystemProperties.getInt("persist.fyt.temperature", 0) == 0 ? "℃" : "℉");
    }

    private void mUpdateTempBackUNIT() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT];
        if (ConstAllAirDara.U_AIR_TEMP_UNIT != 255) {
            ((TextView) findViewById(R.id.air_sp_temp_unit_rear)).setText(vel == 0 ? "℃" : "℉");
        } else {
            int vel2 = SystemProperties.getInt("persist.fyt.temperature", 0);
            ((TextView) findViewById(R.id.air_sp_temp_unit_rear)).setText(vel2 == 0 ? "℃" : "℉");
        }
    }

    
    public void mUpdateDual() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_DUAL];
        findViewById(R.id.air_sp_dual).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_dual_n : R.drawable.ic_sp_dual_p);
    }

    
    public void mUpdateSYNC() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SYNC];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_BNR_ShuPing_15HighLand_L /* 917901 */:
            case FinalCanbus.CAR_BNR_ShuPing_15HighLand_H /* 983437 */:
            case FinalCanbus.CAR_BNR_ShuPing_09HighLand_L /* 1048973 */:
            case FinalCanbus.CAR_BNR_ShuPing_09HighLand_H /* 1114509 */:
            case FinalCanbus.CAR_RZC_ShuPing_15HighLand_L /* 3146125 */:
            case FinalCanbus.CAR_RZC_ShuPing_15HighLand_H /* 3211661 */:
            case FinalCanbus.CAR_RZC_ShuPing_09HighLand_L /* 3277197 */:
            case FinalCanbus.CAR_RZC_ShuPing_09HighLand_H /* 3342733 */:
                if (DataCanbus.DATA[ConstAllAirDara.U_AIR_SYNC] == 1) {
                    vel = 0;
                    break;
                } else {
                    vel = 1;
                    break;
                }
        }
        findViewById(R.id.air_sp_sync).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_sync_n : R.drawable.ic_sp_sync_p);
    }

    
    public void mUpdateZONE() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_ZONE];
        findViewById(R.id.air_sp_zone).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_zone_n : R.drawable.ic_sp_zone_p);
    }

    
    public void mUpdateSteer() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_STEER];
        findViewById(R.id.air_sp_steer).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_steer_n : R.drawable.ic_sp_steer_p);
    }

    
    public void mUpdateRearViewHot() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REARVIEW_HOT];
        findViewById(R.id.air_sp_rearviewhot).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_rearviewhot_n : R.drawable.ic_sp_rearviewhot_p);
    }

    
    public void mUpdateAuto() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO];
        findViewById(R.id.air_sp_auto).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_auto_n : R.drawable.ic_sp_auto_p);
    }

    
    public void mUpdateAcMax() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC_MAX];
        findViewById(R.id.air_sp_acmax).setBackgroundResource(vel == 0 ? R.drawable.ic_sp_acmax_n : R.drawable.ic_sp_acmax_p);
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC];
        findViewById(R.id.air_sp_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_sp_ac2_n : R.drawable.ic_sp_ac2_p);
    }

    
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE];
        findViewById(R.id.air_sp_cycle).setBackgroundResource(cycle == 0 ? R.drawable.ic_sp_cylce_out2_p : R.drawable.ic_sp_cylce_in2_p);
    }

    
    public void mUpdateSwing() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_SWING];
        findViewById(R.id.air_sp_swing).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_swing_n : R.drawable.ic_sp_swing_p);
    }

    
    public void mUpdateION() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_ION];
        findViewById(R.id.air_sp_ion).setBackgroundResource(rear == 0 ? R.drawable.ic_sp_ion_n : R.drawable.ic_sp_ion_p);
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

    
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
        if (ConstAllAirDara.C_AIR_POWER != 255 && ConstAllAirDara.U_AIR_POWER == 255) {
            findViewById(R.id.air_sp_power).setBackgroundResource(leave == 0 ? R.drawable.ic_sp_power_n : R.drawable.ic_sp_power_p);
        }
        findViewById(R.id.air_sp_wind_txt).setVisibility(8);
        findViewById(R.id.air_sp_wind_lev).setVisibility(0);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_ALL_GM_Enclave_SP /* 4980797 */:
            case FinalCanbus.CAR_452_LZ_Volvo /* 7995844 */:
                findViewById(R.id.air_sp_wind_lev).setVisibility(8);
                findViewById(R.id.air_sp_wind_txt).setVisibility(0);
                ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(leave).toString());
                break;
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
        findViewById(R.id.air_sp_blow_body_foot).setBackgroundResource(b_body_foot ? R.drawable.ic_sp_mode_body_foot_p : R.drawable.ic_sp_mode_body_foot_n);
        findViewById(R.id.air_sp_blow_foot_win).setBackgroundResource(b_up_foot ? R.drawable.ic_sp_mode_win_foot_p : R.drawable.ic_sp_mode_win_foot_n);
        if (ConstAllAirDara.C_AIR_MODE_BODYFOOT == 255 && ConstAllAirDara.C_AIR_MODE_UPFOOT == 255) {
            findViewById(R.id.air_sp_blow_body).setBackgroundResource(DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT] == 1 ? 2130841936 : R.drawable.ic_sp_mode_body_n);
            findViewById(R.id.air_sp_blow_foot).setBackgroundResource(DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT] == 1 ? R.drawable.ic_sp_mode_foot_p : R.drawable.ic_sp_mode_foot_n);
            findViewById(R.id.air_sp_blow_win).setBackgroundResource(DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT] == 1 ? R.drawable.ic_sp_mode_win_p : R.drawable.ic_sp_mode_win_n);
        } else {
            if (ConstAllAirDara.C_AIR_MODE_BODY != 255) {
                findViewById(R.id.air_sp_blow_body).setBackgroundResource(b_body ? 2130841936 : R.drawable.ic_sp_mode_body_n);
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
        if (ConstAllAirDara.U_AIR_BLOW_UP_LEFT == 255) {
            findViewById(R.id.air_sp_mode_up).setVisibility(8);
        } else {
            findViewById(R.id.air_sp_mode_up).setVisibility(data == 1 ? 0 : 8);
        }
        updateBlowMode();
    }

    
    public void updateBlowModeBody() {
        int data = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT];
        if (ConstAllAirDara.U_AIR_BLOW_BODY_LEFT == 255) {
            findViewById(R.id.air_sp_mode_body).setVisibility(8);
        } else {
            findViewById(R.id.air_sp_mode_body).setVisibility(data == 1 ? 0 : 8);
        }
        updateBlowMode();
    }

    
    public void updateBlowModeFoot() {
        int data = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT];
        if (ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT == 255) {
            findViewById(R.id.air_sp_mode_foot).setVisibility(8);
        } else {
            findViewById(R.id.air_sp_mode_foot).setVisibility(data == 1 ? 0 : 8);
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
