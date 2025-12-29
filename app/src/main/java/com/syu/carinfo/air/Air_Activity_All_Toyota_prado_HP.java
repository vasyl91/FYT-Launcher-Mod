package com.syu.carinfo.air;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.SystemProperties;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_Activity_All_Toyota_prado_HP extends Activity implements View.OnTouchListener {
    public static Air_Activity_All_Toyota_prado_HP mInstance;
    public static boolean mIsFront = false;
    int pagenum = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == ConstAllAirDara.U_AIR_AC) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateAcOn();
            }
            if (updateCode == ConstAllAirDara.U_AIR_CYCLE) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateCycle();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateRearDefrost();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SWING) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateAirSwing();
            }
            if (updateCode == ConstAllAirDara.U_AIR_ECO) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateECO();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FLOWER_BLOW) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateFlowerBlow();
            }
            if (updateCode == ConstAllAirDara.U_AIR_PARK) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateAirPark();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REST) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateAirRest();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FRONT_ONLY) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateAirOnlyFront();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FRONT_ONLY_F) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateAirOnlyFront_F();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR_MANUAL) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateAirRearManual();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR_COOL) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateAirRearCool();
            }
            if (updateCode == ConstAllAirDara.U_AIR_NANOE) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateNanoe();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FRONT) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateFrontDefrost();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FRONTMAX) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateMaxFrontDefrost();
            }
            if (updateCode == ConstAllAirDara.U_AIR_POWER) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdatePower();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_POWER) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdatePower();
            }
            if (updateCode == ConstAllAirDara.U_AIR_TEMP_LEFT) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateAirTempLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdaterAirWindLevelLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_AUTO) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateAuto();
            }
            if (updateCode == ConstAllAirDara.U_AIR_AUTO_RIGHT) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateAutoRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_DUAL) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateDual();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SYNC) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateSYNC();
            }
            if (updateCode == ConstAllAirDara.U_AIR_ZONE) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateZONE();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATHEAT_LEFT) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateHeatLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATHEAT_RIGHT) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateHeatRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATWIND_LEFT) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateWindLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATWIND_RIGHT) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateWindRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATHEAT_LEFT_REAR) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateHeatLeftRear();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATHEAT_RIGHT_REAR) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateHeatRightRear();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATWIND_LEFT_REAR) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateWindLeftRear();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SEATWIND_RIGHT_REAR) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateWindRightRear();
            }
            if (updateCode == ConstAllAirDara.U_AIR_TEMP_RIGHT) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateTempRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_TEMP_UNIT) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateTempUNIT();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_TEMP) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateBackTemp();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateBackTempRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_BLOW_AUTO) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateBackAuto();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_AUTO_RIGHT) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateBackAutoRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR_LOCK) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateBackRearLock();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR_SYNC) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateBackRearSync();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR_AC) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateBackRearAC();
            }
            if (updateCode == ConstAllAirDara.U_AIR_REAR_CTRL) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateBackRearCtrl();
            }
            if (updateCode == ConstAllAirDara.U_AIR_AQS) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateAirAQS();
            }
            if (updateCode == ConstAllAirDara.U_AIR_AC_MAX) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateAcMax();
            }
            if (updateCode == ConstAllAirDara.U_AIR_SOFT) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateAirSoft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_FAST) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateAirFast();
            }
            if (updateCode == ConstAllAirDara.U_AIR_NORMAL) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateAirNormal();
            }
            if (updateCode == ConstAllAirDara.U_AIR_ION) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateIon();
            }
            if (updateCode == ConstAllAirDara.U_AIR_CLEAN) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateClean();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOWTOP) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateBlowTop();
            }
            if (updateCode == ConstAllAirDara.U_AIR_STEER) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateSteerHot();
            }
            if (updateCode == ConstAllAirDara.U_AIR_WINLEV) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateAirWinlev();
            }
            if (updateCode == ConstAllAirDara.U_AIR_HEAT) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateAirHeat();
            }
            if (updateCode == ConstAllAirDara.U_AIR_PTC) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateAirPTC();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_BLOW_WIND) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateBackWind();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_UP_LEFT || updateCode == ConstAllAirDara.U_AIR_BLOW_BODY_LEFT || updateCode == ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT || updateCode == ConstAllAirDara.U_AIR_BLOW_AUTO_LEFT) {
                Air_Activity_All_Toyota_prado_HP.this.updateBlowModeLeft();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BLOW_UP_RIGHT || updateCode == ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT || updateCode == ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT || updateCode == ConstAllAirDara.U_AIR_BLOW_AUTO_RIGHT) {
                Air_Activity_All_Toyota_prado_HP.this.updateBlowModeRight();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_BLOW_UP || updateCode == ConstAllAirDara.U_AIR_BACK_BLOW_BODY || updateCode == ConstAllAirDara.U_AIR_BACK_BLOW_FOOT) {
                Air_Activity_All_Toyota_prado_HP.this.updateBlowBackMode();
            }
            if (updateCode == ConstAllAirDara.U_AIR_BACK_BLOW_UP_RIGHT || updateCode == ConstAllAirDara.U_AIR_BACK_BLOW_BODY_RIGHT || updateCode == ConstAllAirDara.U_AIR_BACK_BLOW_FOOT_RIGHT) {
                Air_Activity_All_Toyota_prado_HP.this.updateBlowBackModeRight();
            }
            if (DataCanbus.DATA[1000] == 15860165 || DataCanbus.DATA[1000] == 2949575) {
                if (updateCode == 117) {
                    ((TextView) Air_Activity_All_Toyota_prado_HP.this.findViewById(R.id.tv_sp_front)).setTextColor(-16711936);
                    ((TextView) Air_Activity_All_Toyota_prado_HP.this.findViewById(R.id.tv_sp_front)).setText("RANGE: " + DataCanbus.DATA[updateCode] + "km");
                }
                if (updateCode == 118) {
                    ((TextView) Air_Activity_All_Toyota_prado_HP.this.findViewById(R.id.tv_sp_rear)).setTextColor(-16711936);
                    ((TextView) Air_Activity_All_Toyota_prado_HP.this.findViewById(R.id.tv_sp_rear)).setText("SOC: " + DataCanbus.DATA[updateCode] + "%");
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15_YC /* 590279 */:
            case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15H_YC /* 655815 */:
                //setContentView(R.layout.layout_air_hp_all_prado_cg7870);
                break;
            default:
                //setContentView(R.layout.layout_air_hp_all_prado);
                break;
        }
        initCallbackId();
        init();
        mInstance = this;
    }

    private void sendCmd(int data0, int data1) {
        int ints3;
        int ints4;
        int ints0;
        int value;
        int value2;
        int value3;
        int value4;
        int ints5;
        switch (DataCanbus.DATA[1000]) {
            case 22:
            case 334:
            case FinalCanbus.CAR_XP1_Ford_KUGA_2013 /* 65558 */:
            case FinalCanbus.CAR_XP1_Ford_Ecosport_2013 /* 196630 */:
            case FinalCanbus.CAR_XP1_Ford_Fiesta_2013 /* 262166 */:
            case FinalCanbus.CAR_XP1_Ford_CMAX_2013 /* 327702 */:
            case FinalCanbus.CAR_RZC_Focus2019 /* 328014 */:
            case FinalCanbus.CAR_XP1_Ford_Focus_2015 /* 393238 */:
            case FinalCanbus.CAR_XP1_Ford_Tourneo_2015 /* 458774 */:
            case FinalCanbus.CAR_XP1_Ford_Transit_2015 /* 524310 */:
            case FinalCanbus.CAR_XP1_Ford_KUGA_2017 /* 589846 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand /* 1311174 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto /* 1376710 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand /* 1442246 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto /* 1507782 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand_S /* 1573318 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto_S /* 1638854 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand_S /* 1704390 */:
            case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto_S /* 1769926 */:
            case FinalCanbus.CAR_453_XP1_ZH2_Ford_Explorer_13_Hand /* 1900997 */:
            case FinalCanbus.CAR_453_XP1_ZH2_Ford_Explorer_13_Auto /* 1966533 */:
            case FinalCanbus.CAR_453_XP1_ZH2_Ford_Explorer_16_Hand /* 2032069 */:
            case FinalCanbus.CAR_453_XP1_ZH2_Ford_Explorer_16_Auto /* 2097605 */:
            case FinalCanbus.CAR_CZH_RZC_Focus2015 /* 3866958 */:
            case FinalCanbus.CAR_RZC_XP1_Focus2015_M /* 4063566 */:
            case FinalCanbus.CAR_RZC_XP1_Focus2015_H /* 4129102 */:
            case FinalCanbus.CAR_RZC_HONDA_23Yage /* 4260138 */:
            case FinalCanbus.CAR_453_XP1_Ford_Edge_2013 /* 4260293 */:
            case FinalCanbus.CAR_453_XP1_Ford_F150_2013 /* 4325829 */:
            case FinalCanbus.CAR_453_XP1_Ford_Explorer_2013 /* 4391365 */:
            case FinalCanbus.CAR_453_XP1_Ford_Taurus_2013 /* 4456901 */:
            case FinalCanbus.CAR_453_XP1_Ford_Expedition_2013 /* 4522437 */:
            case FinalCanbus.CAR_RZC_Focus2019_M /* 4587854 */:
            case FinalCanbus.CAR_453_XP1_Ford_Edge_2015 /* 4587973 */:
            case FinalCanbus.CAR_RZC_Focus2019_H /* 4653390 */:
            case FinalCanbus.CAR_453_XP1_Ford_Mustang_2015 /* 4653509 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_Civic /* 5636394 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_10Yage /* 5701930 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_Haoying /* 5767466 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_CRV /* 5833002 */:
            case FinalCanbus.CAR_452_LZ_Ford_Mustang /* 11403716 */:
            case FinalCanbus.CAR_453_XP_Ford_All_RP3_Hand1 /* 13107653 */:
            case FinalCanbus.CAR_453_XP_Ford_All_RP3_Hand2 /* 13173189 */:
            case FinalCanbus.CAR_453_XP_Ford_All_RP3_Auto1 /* 13238725 */:
            case FinalCanbus.CAR_453_XP_Ford_All_RP3_Auto2 /* 13304261 */:
            case FinalCanbus.CAR_452_LZ_Ford_Mustang_H /* 14090692 */:
            case FinalCanbus.CAR_XP1_ZH2_RUIJIE2015 /* 14680516 */:
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_453_XP1_ZH2_Ford_Explorer_13_Hand /* 1900997 */:
                    case FinalCanbus.CAR_453_XP1_ZH2_Ford_Explorer_13_Auto /* 1966533 */:
                        if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                            int value5 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                            int value6 = value5 + 1;
                            if (value6 > 7) {
                                value6 = 7;
                            }
                            if (data1 == 1) {
                                DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{173, value6}, null, null);
                                break;
                            }
                        } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                            int value7 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                            int value8 = value7 - 1;
                            if (value8 < 0) {
                                value8 = 0;
                            }
                            if (data1 == 1) {
                                DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{173, value8}, null, null);
                                break;
                            }
                        } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD) {
                            if (DataCanbus.DATA[1000] == 1900997) {
                                int value9 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT];
                                int value10 = value9 + 1;
                                if (value10 > 30) {
                                    value10 = 30;
                                }
                                if (data1 == 1) {
                                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{174, value10}, null, null);
                                    break;
                                }
                            } else {
                                int value11 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT];
                                if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                                    if (value11 == -2) {
                                        value4 = 120;
                                    } else if (value11 == -3) {
                                        value4 = 171;
                                    } else {
                                        value4 = value11 + 1;
                                    }
                                } else if (value11 == -2) {
                                    value4 = 31;
                                } else if (value11 == -3) {
                                    value4 = 60;
                                } else {
                                    value4 = value11 + 1;
                                }
                                if (data1 == 1) {
                                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{170, value4}, null, null);
                                    break;
                                }
                            }
                        } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                            if (DataCanbus.DATA[1000] == 1900997) {
                                int value12 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT];
                                int value13 = value12 - 1;
                                if (value13 < 0) {
                                    value13 = 0;
                                }
                                if (data1 == 1) {
                                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{174, value13}, null, null);
                                    break;
                                }
                            } else {
                                int value14 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT];
                                if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                                    if (value14 == -2) {
                                        value3 = 119;
                                    } else if (value14 == -3) {
                                        value3 = 170;
                                    } else {
                                        value3 = value14 - 1;
                                    }
                                } else if (value14 == -2) {
                                    value3 = 30;
                                } else if (value14 == -3) {
                                    value3 = 59;
                                } else {
                                    value3 = value14 + 1;
                                }
                                if (data1 == 1) {
                                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{170, value3}, null, null);
                                    break;
                                }
                            }
                        } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                            if (DataCanbus.DATA[1000] == 1900997) {
                                int value15 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_RIGHT];
                                int value16 = value15 + 1;
                                if (value16 > 30) {
                                    value16 = 30;
                                }
                                if (data1 == 1) {
                                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{174, value16}, null, null);
                                    break;
                                }
                            } else {
                                int value17 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_RIGHT];
                                if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                                    if (value17 == -2) {
                                        value2 = 120;
                                    } else if (value17 == -3) {
                                        value2 = 171;
                                    } else {
                                        value2 = value17 + 1;
                                    }
                                } else if (value17 == -2) {
                                    value2 = 31;
                                } else if (value17 == -3) {
                                    value2 = 60;
                                } else {
                                    value2 = value17 + 1;
                                }
                                if (data1 == 1) {
                                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{171, value2}, null, null);
                                    break;
                                }
                            }
                        } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                            if (DataCanbus.DATA[1000] == 1900997) {
                                int value18 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_RIGHT];
                                int value19 = value18 - 1;
                                if (value19 < 0) {
                                    value19 = 0;
                                }
                                if (data1 == 1) {
                                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{174, value19}, null, null);
                                    break;
                                }
                            } else {
                                int value20 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_RIGHT];
                                if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                                    if (value20 == -2) {
                                        value = 119;
                                    } else if (value20 == -3) {
                                        value = 170;
                                    } else {
                                        value = value20 - 1;
                                    }
                                } else if (value20 == -2) {
                                    value = 30;
                                } else if (value20 == -3) {
                                    value = 59;
                                } else {
                                    value = value20 + 1;
                                }
                                if (data1 == 1) {
                                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{171, value}, null, null);
                                    break;
                                }
                            }
                        } else if (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT) {
                            int value21 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT];
                            int righthot = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT];
                            int rightwind = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_RIGHT];
                            int value22 = value21 + 1;
                            if (value22 > 3) {
                                value22 = 0;
                            }
                            if (righthot != 0) {
                                value22 |= (righthot << 2) & 12;
                            } else if (rightwind != 0) {
                                value22 = ((rightwind << 2) & 12) | value22 | 128;
                            }
                            if (data1 == 1) {
                                DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{169, value22}, null, null);
                                break;
                            }
                        } else if (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT) {
                            int value23 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT];
                            int lefthot = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT];
                            int leftwind = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_LEFT];
                            int value24 = value23 + 1;
                            if (value24 > 3) {
                                value24 = 0;
                            }
                            int value25 = (value24 << 2) & 12;
                            if (lefthot != 0) {
                                value25 |= lefthot & 3;
                            } else if (leftwind != 0) {
                                value25 = (leftwind & 3) | value25 | 64;
                            }
                            if (data1 == 1) {
                                DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{169, value25}, null, null);
                                break;
                            }
                        } else if (data0 == ConstAllAirDara.C_AIR_LEFT_COLD) {
                            int value26 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_LEFT];
                            int righthot2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT];
                            int rightwind2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_RIGHT];
                            int value27 = value26 + 1;
                            if (value27 > 3) {
                                value27 = 0;
                            }
                            int value28 = ((value27 << 2) & 12) | 64;
                            if (righthot2 != 0) {
                                value28 |= (righthot2 << 2) & 12;
                            } else if (rightwind2 != 0) {
                                value28 = ((rightwind2 << 2) & 12) | value28 | 128;
                            }
                            if (data1 == 1) {
                                DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{169, value28}, null, null);
                                break;
                            }
                        } else if (data0 == ConstAllAirDara.C_AIR_RIGHT_COLD) {
                            int value29 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_RIGHT];
                            int lefthot2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT];
                            int leftwind2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_LEFT];
                            int value30 = value29 + 1;
                            if (value30 > 3) {
                                value30 = 0;
                            }
                            int value31 = ((value30 << 2) & 12) | 128;
                            if (lefthot2 != 0) {
                                value31 |= lefthot2 & 3;
                            } else if (leftwind2 != 0) {
                                value31 = (leftwind2 & 3) | value31 | 64;
                            }
                            if (data1 == 1) {
                                DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{169, value31}, null, null);
                                break;
                            }
                        } else if (data1 == 1) {
                            DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{172, data0}, null, null);
                            break;
                        } else if (data1 == 0) {
                            DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{172}, null, null);
                            break;
                        }
                    default:
                        if (data1 == 1) {
                            DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{172, data0}, null, null);
                            break;
                        } else if (data1 == 0) {
                            DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{172}, null, null);
                            break;
                        }
                }
            case 61:
            case FinalCanbus.CAR_RZC_XP1_GM_1 /* 65597 */:
            case FinalCanbus.CAR_RZC_XP1_GM_2 /* 131133 */:
            case FinalCanbus.CAR_RZC_XP1_GM_3 /* 196669 */:
            case FinalCanbus.CAR_RZC_XP1_GM_4 /* 262205 */:
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
            case FinalCanbus.CAR_RZC_ALL_GM_08_10AstraH /* 3866685 */:
            case FinalCanbus.CAR_RZC_ALL_GM_11CorsaD /* 3932221 */:
            case FinalCanbus.CAR_RZC_ALL_GM_08Combo /* 3997757 */:
            case FinalCanbus.CAR_RZC_ALL_GM_20Envision /* 4063293 */:
            case FinalCanbus.CAR_RZC_ALL_GM_63 /* 4128829 */:
            case FinalCanbus.CAR_439_HC_RongWei950 /* 4129207 */:
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
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{7, data0}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{7}, null, null);
                    break;
                }
            case 86:
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{18}, null, null);
                            break;
                        } else {
                            DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{6}, null, null);
                            break;
                        }
                    } else {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0}, null, null);
                        break;
                    }
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[1], null, null);
                    break;
                }
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
            case FinalCanbus.CAR_RZC4_PSA_17_3008 /* 721235 */:
            case FinalCanbus.CAR_RZC4_PSA_17_3008_M /* 786771 */:
            case FinalCanbus.CAR_RZC4_PSA_17_3008_H /* 852307 */:
            case FinalCanbus.CAR_RZC4_PSA_14_2008 /* 917843 */:
            case FinalCanbus.CAR_RZC4_PSA_14_2008_M /* 983379 */:
            case FinalCanbus.CAR_RZC4_PSA_14_2008_H /* 1048915 */:
            case FinalCanbus.CAR_RZC4_PSA_17_5008 /* 1376595 */:
            case FinalCanbus.CAR_RZC4_PSA_04_407 /* 1638739 */:
            case FinalCanbus.CAR_RZC4_PSA_04_407_CD /* 1704275 */:
            case FinalCanbus.CAR_RZC4_PSA_ALL_NoAir_L /* 2031955 */:
            case FinalCanbus.CAR_RZC4_PSA_ALL_NoAir_M /* 2097491 */:
            case FinalCanbus.CAR_RZC4_PSA_ALL_NoAir_H /* 2163027 */:
            case FinalCanbus.CAR_RZC4_PSA_C4_OE_L /* 2228563 */:
            case FinalCanbus.CAR_RZC4_PSA_C4_OE_M /* 2294099 */:
            case FinalCanbus.CAR_RZC4_PSA_C4_OE_H /* 2359635 */:
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_AUTO) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 1) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 0) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_AC) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 1) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 0) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_AC_MAX) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC_MAX] == 1) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC_MAX] == 0) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD) {
                        DataCanbus.PROXY.cmd(87, new int[]{4, 1}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                        DataCanbus.PROXY.cmd(87, new int[]{4, 2}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        DataCanbus.PROXY.cmd(87, new int[]{5, 1}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        DataCanbus.PROXY.cmd(87, new int[]{5, 2}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_UP) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT] == 1) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT] == 0) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODY) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT] == 1) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT] == 0) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_FOOT) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT] == 1) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT] == 0) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_WINLEV) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_WINLEV] == 0) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0, 1}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_WINLEV] == 1) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0, 2}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_WINLEV] == 2) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        DataCanbus.PROXY.cmd(87, new int[]{10, 1}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        DataCanbus.PROXY.cmd(87, new int[]{10, 2}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_DUAL) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_DUAL] == 1) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_DUAL] == 0) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_AQS) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AQS] == 1) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AQS] == 0) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        DataCanbus.PROXY.cmd(87, new int[]{data0, data1}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_REAR_CTRL) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_CTRL] == 1) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_CTRL] == 0) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 1) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 0) {
                            DataCanbus.PROXY.cmd(87, new int[]{data0, 1}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_CYCLE || data0 == ConstAllAirDara.C_AIR_POWER || data0 == ConstAllAirDara.C_AIR_REAR_DEFROST) {
                        DataCanbus.PROXY.cmd(87, new int[]{data0, data1}, null, null);
                        break;
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_CYCLE || data0 == ConstAllAirDara.C_AIR_POWER || data0 == ConstAllAirDara.C_AIR_REAR_DEFROST) {
                    DataCanbus.PROXY.cmd(87, new int[]{data0, data1}, null, null);
                    break;
                }
            case 223:
            case FinalCanbus.CAR_454_Sanwu_Ford_Mondeo_16 /* 4522438 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Mondeo_17 /* 4587974 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_16_H /* 4653510 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Taurus_10_H /* 4719046 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_17_Auto /* 4784582 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_F150_14_Auto /* 4850118 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_F150_15 /* 4915654 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_KUGA_15 /* 4981190 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_KUGA_18 /* 5046726 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_FOCUS_15 /* 5112262 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_FOCUS_18 /* 5177798 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_15_H /* 5243334 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_18_H /* 5308870 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_15 /* 5374406 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_18 /* 5439942 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_F150_12_H /* 5505478 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_F150_17 /* 5571014 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_F150_18 /* 5636550 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_15 /* 5702086 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_12_L /* 5767622 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_12_H /* 5833158 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_15_L /* 5898694 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Everest_16 /* 5964230 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Everest_18 /* 6029766 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_16_L /* 6095302 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Taurus_10_L /* 6160838 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_F150_14_Hand /* 6226374 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Mondeo_18 /* 6291910 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_17_SYNC3 /* 6357446 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_17_Hand /* 6422982 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_10_Auto /* 6488518 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_10_Hand /* 6554054 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[1], null, null);
                    break;
                }
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
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_POWER) {
                        RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                        int i = ConstAllAirDara.C_CONTRAL;
                        int[] iArr = new int[2];
                        iArr[0] = data0;
                        iArr[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_POWER] == 1 ? 0 : 1;
                        remoteModuleProxy.cmd(i, iArr, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_AC) {
                        RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                        int i2 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr2 = new int[2];
                        iArr2[0] = data0;
                        iArr2[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 1 ? 0 : 1;
                        remoteModuleProxy2.cmd(i2, iArr2, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_AC_MAX) {
                        RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                        int i3 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr3 = new int[2];
                        iArr3[0] = data0;
                        iArr3[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC_MAX] == 1 ? 0 : 1;
                        remoteModuleProxy3.cmd(i3, iArr3, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_AUTO) {
                        RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                        int i4 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr4 = new int[2];
                        iArr4[0] = data0;
                        iArr4[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 1 ? 0 : 1;
                        remoteModuleProxy4.cmd(i4, iArr4, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST) {
                        RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                        int i5 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr5 = new int[2];
                        iArr5[0] = data0;
                        iArr5[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 1 ? 0 : 1;
                        remoteModuleProxy5.cmd(i5, iArr5, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST) {
                        RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                        int i6 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr6 = new int[2];
                        iArr6[0] = data0;
                        iArr6[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 1 ? 0 : 1;
                        remoteModuleProxy6.cmd(i6, iArr6, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                        int i7 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr7 = new int[2];
                        iArr7[0] = data0;
                        iArr7[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1 ? 1 : 0;
                        remoteModuleProxy7.cmd(i7, iArr7, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_UP) {
                        RemoteModuleProxy remoteModuleProxy8 = DataCanbus.PROXY;
                        int i8 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr8 = new int[2];
                        iArr8[0] = data0;
                        iArr8[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT] == 1 ? 0 : 1;
                        remoteModuleProxy8.cmd(i8, iArr8, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODY) {
                        RemoteModuleProxy remoteModuleProxy9 = DataCanbus.PROXY;
                        int i9 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr9 = new int[2];
                        iArr9[0] = data0;
                        iArr9[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT] == 1 ? 0 : 1;
                        remoteModuleProxy9.cmd(i9, iArr9, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_FOOT) {
                        RemoteModuleProxy remoteModuleProxy10 = DataCanbus.PROXY;
                        int i10 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr10 = new int[2];
                        iArr10[0] = data0;
                        iArr10[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT] == 1 ? 0 : 1;
                        remoteModuleProxy10.cmd(i10, iArr10, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{11, 1}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{11, 2}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{12, 1}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{12, 2}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{13, 1}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{13, 2}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_WINLEV) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_WINLEV] == 0) {
                            DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, 1}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_WINLEV] == 1) {
                            DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, 2}, null, null);
                            break;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_WINLEV] == 2) {
                            DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0}, null, null);
                            break;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_DUAL) {
                        RemoteModuleProxy remoteModuleProxy11 = DataCanbus.PROXY;
                        int i11 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr11 = new int[2];
                        iArr11[0] = data0;
                        iArr11[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_DUAL] == 1 ? 0 : 1;
                        remoteModuleProxy11.cmd(i11, iArr11, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_AQS) {
                        RemoteModuleProxy remoteModuleProxy12 = DataCanbus.PROXY;
                        int i12 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr12 = new int[2];
                        iArr12[0] = data0;
                        iArr12[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_AQS] == 1 ? 0 : 1;
                        remoteModuleProxy12.cmd(i12, iArr12, null, null);
                        break;
                    }
                }
                break;
            case 374:
            case FinalCanbus.CAR_XP1_ZiYouGuang_H /* 65910 */:
            case FinalCanbus.CAR_XP1_17ZhiNanZhe /* 196982 */:
            case FinalCanbus.CAR_XP1_17ZhiNanZhe_H /* 262518 */:
            case FinalCanbus.CAR_XP1_18ZiYouXia /* 721270 */:
            case FinalCanbus.CAR_XP1_Cherokee /* 786806 */:
            case FinalCanbus.CAR_XP1_Cherokee_H /* 852342 */:
            case FinalCanbus.CAR_BNR_XP1_ZiYouGuang /* 917878 */:
            case FinalCanbus.CAR_BNR_XP1_ZiYouGuang_H /* 983414 */:
            case FinalCanbus.CAR_BNR_XP1_17ZhiNanZhe /* 1114486 */:
            case FinalCanbus.CAR_BNR_XP1_17ZhiNanZhe_H /* 1180022 */:
            case FinalCanbus.CAR_XP1_RAM1500_H_AUTO /* 4194678 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{1, data0}, null, null);
                    break;
                }
            case FinalCanbus.CAR_RZC_XP1_BenTeng14B70_QC /* 65624 */:
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{4}, null, null);
                            break;
                        } else {
                            DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{3}, null, null);
                            break;
                        }
                    } else {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0}, null, null);
                        break;
                    }
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[1], null, null);
                    break;
                }
            case FinalCanbus.CAR_RZC_XP1_YuanJingX6 /* 131211 */:
            case FinalCanbus.CAR_RZC_XP1_YuanJingX1 /* 196747 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS /* 589963 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GL /* 655499 */:
            case FinalCanbus.CAR_RZC_XP1_18YuanJingSUV /* 721035 */:
            case FinalCanbus.CAR_RZC_XP1_Borui /* 786571 */:
            case FinalCanbus.CAR_RZC_XP1_18YuanJingSUV_H /* 852107 */:
            case FinalCanbus.CAR_RZC_XP1_16YuanJingSUV /* 917643 */:
            case FinalCanbus.CAR_RZC_XP1_16YuanJingSUV_H /* 983179 */:
            case FinalCanbus.CAR_RZC_XP1_18YuanJing /* 1114251 */:
            case FinalCanbus.CAR_RZC_BoYue /* 1179787 */:
            case FinalCanbus.CAR_RZC_BoYue_H /* 1245323 */:
            case FinalCanbus.CAR_RZC_Jili_19Dihao /* 1310859 */:
            case FinalCanbus.CAR_RZC_Jili_19Dihao_GL_E /* 1441931 */:
            case FinalCanbus.CAR_RZC_Jili_18Dihao /* 1507467 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS_18 /* 1573003 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GL_16 /* 1638539 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_S1_18 /* 1704075 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS_19 /* 1769611 */:
            case FinalCanbus.CAR_RZC_XP1_YuanJingX3_19_20 /* 1835147 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GL_19 /* 1966219 */:
            case FinalCanbus.CAR_RZC_XP1_20YuanJingSUV /* 2031755 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GL_20 /* 2097291 */:
            case FinalCanbus.CAR_RZC_XP1_Boyue_Pro_20 /* 2162827 */:
            case FinalCanbus.CAR_RZC_XP1_Bingyue_19 /* 2228363 */:
            case FinalCanbus.CAR_455_OD_Jilie_JiheA /* 2228679 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS_20 /* 2293899 */:
            case FinalCanbus.CAR_RZC_XP1_Jiaji_21 /* 2424971 */:
            case FinalCanbus.CAR_452_OD_Ruilan_X3_Pro /* 2425285 */:
            case FinalCanbus.CAR_RZC_XP1_Binrui_20 /* 2490507 */:
            case FinalCanbus.CAR_452_OD_Jihe_EX3 /* 2490821 */:
            case FinalCanbus.CAR_RZC_XP1_Haoyue_20 /* 2556043 */:
            case FinalCanbus.CAR_RZC_XP1_Dihaoe_22 /* 2621579 */:
            case FinalCanbus.CAR_RZC_XP1_Xingrui_22 /* 2687115 */:
            case FinalCanbus.CAR_RZC_BoYue_21 /* 2752651 */:
            case FinalCanbus.CAR_RZC_Xiongmao_Mini_23 /* 2818187 */:
            case FinalCanbus.CAR_RZC_Jili_TX5 /* 2883723 */:
            case FinalCanbus.CAR_RZC_XP1_BingyuePro_19 /* 2949259 */:
            case FinalCanbus.CAR_RZC_Jili_15YuanJing /* 3014795 */:
            case FinalCanbus.CAR_OuDi_XP1_Borui_18 /* 3080331 */:
            case FinalCanbus.CAR_OuDi_XP1_Borui_18_L /* 3145867 */:
            case FinalCanbus.CAR_Oudi_Jili_Binyue_Pro /* 3211403 */:
            case FinalCanbus.CAR_RZC_XP1_Bingyue_21_RS /* 3276939 */:
            case FinalCanbus.CAR_RZC_XP1_Dihao_23 /* 3342475 */:
            case FinalCanbus.CAR_453_OD_Jili_Panda_Mini /* 8454597 */:
            case FinalCanbus.CAR_454_OD_Jilie_DihaoS /* 14156230 */:
            case FinalCanbus.CAR_454_OD_Jilie_YuanchengXingzhi /* 14549446 */:
            case FinalCanbus.CAR_453_OD_Jili_Dihao_EV /* 16056773 */:
                int ints02 = 0;
                if (data0 == ConstAllAirDara.C_AIR_POWER) {
                    int value32 = DataCanbus.DATA[ConstAllAirDara.U_AIR_POWER];
                    if (value32 == 0) {
                        switch (DataCanbus.DATA[1000]) {
                            case FinalCanbus.CAR_RZC_BoYue /* 1179787 */:
                            case FinalCanbus.CAR_RZC_BoYue_H /* 1245323 */:
                                ints02 = 32;
                                break;
                            default:
                                ints02 = 128;
                                break;
                        }
                    } else {
                        ints02 = 128;
                    }
                }
                if (DataCanbus.DATA[1000] == 3276939 && data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_STEER) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_STEER] == 1) {
                            DataCanbus.PROXY.cmd(1, new int[]{ConstAllAirDara.C_AIR_STEER}, null, null);
                        } else {
                            DataCanbus.PROXY.cmd(1, new int[]{ConstAllAirDara.C_AIR_STEER, 1}, null, null);
                        }
                    } else if (data0 == ConstAllAirDara.C_CLEAN) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CLEAN] == 1) {
                            DataCanbus.PROXY.cmd(1, new int[]{ConstAllAirDara.C_CLEAN}, null, null);
                        } else {
                            DataCanbus.PROXY.cmd(1, new int[]{ConstAllAirDara.C_CLEAN, 1}, null, null);
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_SWING) {
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_SWING] == 1) {
                            DataCanbus.PROXY.cmd(1, new int[]{ConstAllAirDara.C_AIR_SWING}, null, null);
                        } else {
                            DataCanbus.PROXY.cmd(1, new int[]{ConstAllAirDara.C_AIR_SWING, 1}, null, null);
                        }
                    }
                }
                int ints03 = ints02 | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_AC_MAX ? 1 : 0);
                int ints1 = 0 | (data0 == ConstAllAirDara.C_AIR_DUAL ? 8 : 0);
                int ints12 = ints1 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0);
                int ints2 = 0 | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 1 : 0);
                int ints32 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints33 = ints32 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints42 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                int ints43 = ints42 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_455_OD_Jilie_JiheA /* 2228679 */:
                    case FinalCanbus.CAR_452_OD_Ruilan_X3_Pro /* 2425285 */:
                    case FinalCanbus.CAR_452_OD_Jihe_EX3 /* 2490821 */:
                    case FinalCanbus.CAR_453_OD_Jili_Panda_Mini /* 8454597 */:
                    case FinalCanbus.CAR_454_OD_Jilie_DihaoS /* 14156230 */:
                    case FinalCanbus.CAR_454_OD_Jilie_YuanchengXingzhi /* 14549446 */:
                    case FinalCanbus.CAR_453_OD_Jili_Dihao_EV /* 16056773 */:
                        int ints52 = 0 | (data0 == ConstAllAirDara.C_AIR_AQS ? 128 : 0);
                        ints5 = ints52 | (data0 == ConstAllAirDara.C_CLEAN ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_ION ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_ECO ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_PARK ? 128 : 0);
                        break;
                    default:
                        int ints53 = 0 | (data0 == ConstAllAirDara.C_AIR_AQS ? 128 : 0);
                        ints5 = ints53 | (data0 == ConstAllAirDara.C_AIR_ECO ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_ION ? 32 : 0) | (data0 == ConstAllAirDara.C_CLEAN ? 4 : 0);
                        break;
                }
                int ints54 = ints5 | (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT ? 1 : 0);
                if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                    int value33 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] + 1;
                    if (value33 > 8) {
                        value33 = 8;
                    }
                    ints12 = value33 << 4;
                } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                    int value34 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] - 1;
                    if (value34 < 0) {
                        value34 = 0;
                    }
                    ints12 = value34 << 4;
                }
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints03, ints12, ints2, ints33, ints43, ints54}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                    break;
                }
            case FinalCanbus.CAR_Oudi_XP1_FengGuang17Y580 /* 196922 */:
            case FinalCanbus.CAR_Oudi_XP1_FengGuang17Y560 /* 1507642 */:
            case FinalCanbus.CAR_Oudi_XP1_FengGuang17S560 /* 1638714 */:
                if (data1 == 1) {
                    int ints04 = 0;
                    int ints13 = 0;
                    if (data0 == ConstAllAirDara.C_AIR_POWER) {
                        ints04 = 168;
                        ints13 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        ints04 = 160;
                        ints13 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        ints04 = 160;
                        ints13 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD || data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        ints04 = 161;
                        ints13 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB || data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        ints04 = 161;
                        ints13 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODY) {
                        ints04 = 163;
                        ints13 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT) {
                        ints04 = 163;
                        ints13 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT) {
                        ints04 = 163;
                        ints13 = 2;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_FOOT) {
                        ints04 = 163;
                        ints13 = 3;
                    } else if (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST) {
                        ints04 = 163;
                        ints13 = 4;
                    } else if (data0 == ConstAllAirDara.C_AIR_AC) {
                        ints04 = 164;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 1) {
                            ints13 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 0) {
                            ints13 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        ints04 = 165;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            ints13 = 1;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 0) {
                            ints13 = 0;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST) {
                        ints04 = 167;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 1) {
                            ints13 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 0) {
                            ints13 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_AUTO) {
                        ints04 = 169;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 1) {
                            ints13 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 0) {
                            ints13 = 1;
                        }
                    }
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints04, ints13}, null, null);
                    break;
                }
            case FinalCanbus.CAR_RZC_FengGuang18Y580 /* 393530 */:
            case FinalCanbus.CAR_RZC_FengGuang18Y580_H /* 459066 */:
            case FinalCanbus.CAR_RZC_DongFengYiZhi_19EV3 /* 524602 */:
            case FinalCanbus.CAR_RZC_Jiangxi_Wushiling_Mux /* 852282 */:
            case FinalCanbus.CAR_RZC_Jiangxi_FengguangS560_21 /* 1179962 */:
            case FinalCanbus.CAR_RZC_FengGuang21Y580 /* 1245498 */:
            case FinalCanbus.CAR_RZC_FengGuang21Y580_H /* 1311034 */:
            case FinalCanbus.CAR_RZC_FengGuang_580Pro_20 /* 1835322 */:
            case FinalCanbus.CAR_RZC_FengGuang_580Pro_20_H /* 1900858 */:
                int ints05 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_AC_MAX ? 1 : 0);
                int ints14 = 0 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0);
                int ints15 = ints14 | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints22 = 0 | (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_FOOT ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_BODY ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 1 : 0);
                int ints34 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints35 = ints34 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints55 = 0 | (data0 == ConstAllAirDara.C_AIR_PTC ? 128 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints05, ints15, ints22, ints35, 0, ints55}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                    break;
                }
            case FinalCanbus.CAR_RZC_BeiQi_19EC5 /* 458979 */:
            case FinalCanbus.CAR_RZC_BeiQi_18EU5 /* 786659 */:
            case FinalCanbus.CAR_RZC_BeiQi_Shenbao_D50_18 /* 852195 */:
            case FinalCanbus.CAR_RZC_BeiQi_20EX3 /* 1245411 */:
            case FinalCanbus.CAR_RZC_BeiQi_20EU5 /* 1376483 */:
            case FinalCanbus.CAR_454_OD_Beijing_X3_18 /* 4063686 */:
            case FinalCanbus.CAR_454_OD_Beijing_X5_18 /* 4129222 */:
            case FinalCanbus.CAR_454_OD_Beiqi_EU5_18 /* 4194758 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_D50_19 /* 4260294 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X35_19 /* 4325830 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X55_18 /* 4391366 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Zhixing_18 /* 4456902 */:
                int ints44 = 0;
                int ints06 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0);
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_454_OD_Beijing_X3_18 /* 4063686 */:
                    case FinalCanbus.CAR_454_OD_Beijing_X5_18 /* 4129222 */:
                    case FinalCanbus.CAR_454_OD_Beiqi_EU5_18 /* 4194758 */:
                    case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_D50_19 /* 4260294 */:
                    case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X35_19 /* 4325830 */:
                    case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X55_18 /* 4391366 */:
                    case FinalCanbus.CAR_454_OD_Beiqi_Zhixing_18 /* 4456902 */:
                        ints0 = ints06 | (data0 == ConstAllAirDara.C_AIR_AC_MAX ? 4 : 0);
                        break;
                    default:
                        ints0 = ints06 | (data0 == ConstAllAirDara.C_AIR_AC_MAX ? 1 : 0);
                        break;
                }
                int ints16 = 0 | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 8 : 0);
                int ints17 = ints16 | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 4 : 0);
                if (DataCanbus.DATA[1000] == 458979) {
                    if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD || data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        int vuale = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT];
                        if (vuale < 9) {
                            vuale++;
                        }
                        ints44 = vuale;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB || data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        int vuale2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT];
                        if (vuale2 > 1) {
                            vuale2--;
                        }
                        ints44 = vuale2;
                    }
                } else {
                    ints17 = ints17 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                }
                int ints23 = 0 | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 1 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_BODY ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_FOOT ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT ? 16 : 0);
                int ints36 = 0 | (data0 == ConstAllAirDara.C_AIR_HEAT ? 128 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints0, ints17, ints23, ints36, ints44}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[5], null, null);
                    break;
                }
            case FinalCanbus.CAR_RZC_XP1_18Carmy /* 524400 */:
            case FinalCanbus.CAR_RZC_XP1_20RAV4 /* 786544 */:
            case FinalCanbus.CAR_RZC_XP1_19Yazhoulong /* 852080 */:
            case FinalCanbus.CAR_RZC_XP1_18Carmy_H /* 917616 */:
            case FinalCanbus.CAR_RZC_XP1_98_05Lexus_Rx300 /* 983152 */:
            case FinalCanbus.CAR_RZC_XP1_98_03LC100 /* 1114224 */:
            case FinalCanbus.CAR_RZC_XP1_WildLander /* 1245296 */:
            case FinalCanbus.CAR_RZC_XP1_CHR_EV /* 1310832 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_NX200_17 /* 1507440 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES200_13 /* 1572976 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_RX270_14 /* 1638512 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES300_05 /* 1704048 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_RX_09_14 /* 1769584 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES300_20 /* 1835120 */:
            case FinalCanbus.CAR_RZC_XP1_18Carmy_TOP /* 1900656 */:
            case FinalCanbus.CAR_RZC_XP1_22Highlander /* 2097264 */:
            case FinalCanbus.CAR_RZC_XC_Huangguan_14 /* 2162800 */:
            case FinalCanbus.CAR_RZC_XP1_20_LandCruiser /* 2293872 */:
            case FinalCanbus.CAR_RZC_XP1_22_Sienna /* 2424944 */:
            case FinalCanbus.CAR_RZC_XP1_19_Corolla /* 2490480 */:
            case FinalCanbus.CAR_RZC_XP1_20_4Runner /* 2556016 */:
            case FinalCanbus.CAR_RZC_XP1_22_Harrier /* 2621552 */:
            case FinalCanbus.CAR_RZC_XP1_22_CROSS /* 2687088 */:
            case FinalCanbus.CAR_RZC_XP1_22_FRONTLANDER /* 2752624 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_GS_04_07 /* 2818160 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_LS_04_06 /* 2883696 */:
            case FinalCanbus.CAR_RZC_XP1_22_VENZA /* 2949232 */:
            case FinalCanbus.CAR_RZC_Huangguan_14 /* 3014768 */:
            case FinalCanbus.CAR_RZC_XP1_22Highlander_LOW /* 3080304 */:
            case FinalCanbus.CAR_RZC_XP1_22_Sienna_LOW /* 3145840 */:
            case FinalCanbus.CAR_RZC_XP1_05_REIZ /* 3407984 */:
            case FinalCanbus.CAR_RZC_XP1_22Highlander_H /* 3473520 */:
            case FinalCanbus.CAR_RZC_XP1_15_LandCruiser /* 4128880 */:
            case FinalCanbus.CAR_RZC_23_Corolla_Malaysia /* 4194416 */:
            case FinalCanbus.CAR_RZC_23_Vios_Malaysia /* 4259952 */:
            case FinalCanbus.CAR_DUDU_RZC_Toyota_Corolla_14 /* 4325488 */:
            case FinalCanbus.CAR_DUDU_RZC_Toyota_RAV4_20_Hand /* 4391024 */:
            case FinalCanbus.CAR_DUDU_RZC_Toyota_RAV4_20_Auto /* 4456560 */:
            case FinalCanbus.CAR_DUDU_RZC_Toyota_Highlander_15_Hand /* 4522096 */:
            case FinalCanbus.CAR_DUDU_RZC_Toyota_Highlander_15_Auto /* 4587632 */:
            case FinalCanbus.CAR_RZC_Toyota_Prado_02_L /* 4653168 */:
            case FinalCanbus.CAR_RZC_Toyota_Prado_02_H /* 4718704 */:
            case FinalCanbus.CAR_RZC_XP1_05_REIZ_H /* 4784240 */:
            case FinalCanbus.CAR_RZC_Toyota_Prado_10_CD /* 4849776 */:
            case FinalCanbus.CAR_RZC_Toyota_LandCruiser_13_ABC /* 4980848 */:
            case FinalCanbus.CAR_RZC_XP1_22_CROSS_H /* 5046384 */:
            case FinalCanbus.CAR_RZC_XP1_22_FRONTLANDER_H /* 5111920 */:
            case FinalCanbus.CAR_DUDU_RZC_XP1_18Carmy /* 5177456 */:
            case FinalCanbus.CAR_DUDU_RZC_XP1_18Carmy_H /* 5242992 */:
            case FinalCanbus.CAR_DUDU_RZC_XP1_18Carmy_TOP /* 5308528 */:
            case FinalCanbus.CAR_RZC_XP1_20_Sienta /* 5374064 */:
            case FinalCanbus.CAR_RZC_XP1_20_Sienta_H /* 5439600 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_IS_06 /* 5505136 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_IS_06_H /* 5570672 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES_06 /* 5636208 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES_06_H /* 5701744 */:
            case FinalCanbus.CAR_RZC_Toyota_PRIUS_CD /* 5767280 */:
            case FinalCanbus.CAR_RZC_Toyota_PRIUS_NOCD /* 5832816 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_LS460 /* 5898352 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_LS460_H /* 5963888 */:
            case FinalCanbus.CAR_RZC_XP1_LC100 /* 6029424 */:
            case FinalCanbus.CAR_RZC_XP1_LC100_H /* 6094960 */:
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
                int ints07 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT ? 8 : 0) | (data0 == ConstAllAirDara.C_CLEAN ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0);
                int ints18 = 0 | (data0 == ConstAllAirDara.C_AIR_ION ? 128 : 0);
                int ints19 = ints18 | (data0 == ConstAllAirDara.C_AIR_SWING ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_FLOWER_BLOW ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_SWING ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_ZONE ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_DUAL ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints24 = 0 | (data0 == ConstAllAirDara.C_AIR_LEFT_COLD ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_RIGHT_COLD ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 1 : 0);
                int ints37 = 0 | (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT_REAR ? 128 : 0);
                int ints38 = ints37 | (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT_REAR ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_LEFT_COLD_REAR ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_RIGHT_COLD_REAR ? 16 : 0);
                if (SystemProperties.getBoolean("persist.fyt.reversetemp", false)) {
                    int ints45 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                    ints4 = ints45 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                    ints3 = ints38 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                } else {
                    ints3 = ints38 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                    int ints46 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                    ints4 = ints46 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                }
                int ints47 = ints4 | (data0 == ConstAllAirDara.C_AIR_FRONT_ONLY ? 64 : 0) | (data0 == ConstAllAirDara.C_REAR_RIGHT_TEMP_UP ? 32 : 0) | (data0 == ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_ECO ? 4 : 0);
                int ints56 = 0 | (data0 == ConstAllAirDara.C_REAR_OFF ? 64 : 0);
                int ints57 = ints56 | (data0 == ConstAllAirDara.C_REAR_WIND_UP ? 32 : 0) | (data0 == ConstAllAirDara.C_REAR_WIND_DOWN ? 16 : 0) | (data0 == ConstAllAirDara.C_REAR_MODE ? 8 : 0) | (data0 == ConstAllAirDara.C_REAR_AUTO ? 4 : 0) | (data0 == ConstAllAirDara.C_REAR_LEFT_TEMP_UP ? 2 : 0) | (data0 == ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN ? 1 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints07, ints19, ints24, ints3, ints47, ints57, 0}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[7], null, null);
                    break;
                }
            case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15_YC /* 590279 */:
            case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15H_YC /* 655815 */:
            case FinalCanbus.CAR_455_LZ_Ford_Mustang_L_CYT /* 1245639 */:
            case FinalCanbus.CAR_455_LZ_Ford_Mustang_H_CYT /* 1311175 */:
            case FinalCanbus.CAR_455_LZ_Ford_Mustang_RH_CYT /* 1376711 */:
            case FinalCanbus.CAR_455_LZ_Ford_Mustang_RL_CYT /* 1442247 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_07_MO /* 1966534 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_07_TX /* 2032070 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_12_MO /* 2097606 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_LX570_12_TX /* 2163142 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_10_MO /* 2228678 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_10_TX /* 2294214 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_14_MO /* 2359750 */:
            case FinalCanbus.CAR_454_KYC_Toyota_Lexus_GX_14_TX /* 2425286 */:
            case FinalCanbus.CAR_454_LZ_Ford_F150_15_L /* 3932614 */:
            case FinalCanbus.CAR_454_LZ_Ford_F150_15_H /* 3998150 */:
            case FinalCanbus.CAR_439_XBS_09Tianlai /* 4063671 */:
            case FinalCanbus.CAR_454_LZ_TOYOTA_LC300_KycAir /* 6619590 */:
            case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_08_TX /* 6881733 */:
            case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_08_MO10 /* 6947269 */:
            case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_08_MO13 /* 7012805 */:
            case FinalCanbus.CAR_453_KYC_Toyota_LANDCRUISER_16_MO /* 7078341 */:
            case FinalCanbus.CAR_452_XBS_Nissan_Cedric /* 7143876 */:
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
            case FinalCanbus.CAR_452_OD_LandRover_Freelander /* 7799236 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Alpha_15 /* 7799237 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Alpha_15_Top /* 7864773 */:
            case FinalCanbus.CAR_452_XC_Nissan_Tule_CD /* 8716740 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0}, null, null);
                    break;
                }
            case FinalCanbus.CAR_RZC_BenTeng_OLDB50 /* 786845 */:
            case FinalCanbus.CAR_455_6606_RZC_VinFast_PLUS_23 /* 2949575 */:
            case FinalCanbus.CAR_453_RZC_SWM_G01_22 /* 4784581 */:
            case FinalCanbus.CAR_452_RZC_SWM_G01_21_Low /* 11338180 */:
            case FinalCanbus.CAR_439_RZC_SWM_G01 /* 13894071 */:
            case FinalCanbus.CAR_439_RZC_SWM_G01_19 /* 15729079 */:
            case FinalCanbus.CAR_439_RZC_WEICHAI_U70 /* 15794615 */:
            case FinalCanbus.CAR_453_RZC_VinFast_PLUS_23 /* 15860165 */:
                int ints08 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_AC_MAX ? 1 : 0);
                int ints110 = 0 | (data0 == ConstAllAirDara.C_AIR_DUAL ? 8 : 0);
                int ints111 = ints110 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints25 = 0 | (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_FOOT ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_BODY ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 1 : 0);
                int ints39 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints310 = ints39 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints48 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                int ints49 = ints48 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                int ints58 = 0 | (data0 == ConstAllAirDara.C_AIR_RIGHT_COLD ? 8 : 0);
                int ints59 = ints58 | (data0 == ConstAllAirDara.C_AIR_LEFT_COLD ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT ? 1 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints08, ints111, ints25, ints310, ints49, ints59}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                    break;
                }
            case FinalCanbus.CAR_452_RZC_ZHongtai_E200_18 /* 852420 */:
            case FinalCanbus.CAR_439_RZC_ZhongTaiT500 /* 2163127 */:
            case FinalCanbus.CAR_439_RZC_ZhongTaiT300 /* 2228663 */:
            case FinalCanbus.CAR_439_RZC_ZhongTaiSR9 /* 2294199 */:
            case FinalCanbus.CAR_439_RZC_ZhongTaiSR9_H /* 2359735 */:
            case FinalCanbus.CAR_439_RZC_ZhongTaiSR7 /* 7537079 */:
            case FinalCanbus.CAR_439_RZC_19yema_Bojun /* 8520119 */:
            case FinalCanbus.CAR_452_RZC_Mangguo_LeiDing /* 13697476 */:
            case FinalCanbus.CAR_RZC_ZhongTaiDaMaiX7 /* 14614967 */:
                int ints26 = 0;
                int ints09 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0);
                if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                    if (DataCanbus.DATA[1000] == 8520119) {
                        ints26 = 1;
                    } else {
                        ints09 = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1 ? 8 : 4;
                    }
                }
                int ints010 = ints09 | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_AC_MAX ? 1 : 0);
                int ints112 = 0 | (data0 == ConstAllAirDara.C_AIR_DUAL ? 8 : 0);
                int ints113 = ints112 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints27 = ints26 | (data0 == ConstAllAirDara.C_AIR_MODE_UP ? 160 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_BODY ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_FOOT ? 96 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT ? 128 : 0);
                int ints311 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints312 = ints311 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints410 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                int ints411 = ints410 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                int ints510 = 0 | (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT ? 1 : 0);
                int ints511 = ints510 | (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_ION ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_HEAT ? 4 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints010, ints113, ints27, ints312, ints411, ints511}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                    break;
                }
            case FinalCanbus.CAR_WC2_RENAULT_Jinbei_Guanjing /* 1180000 */:
                boolean flag = false;
                int value35 = 0;
                if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                    value35 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                    if (value35 < 7) {
                        value35++;
                    }
                    data0 = 39;
                    flag = true;
                } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                    value35 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                    if (value35 > 0) {
                        value35--;
                    }
                    data0 = 39;
                    flag = true;
                } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD) {
                    int tempAll = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT];
                    if (tempAll == -3) {
                        value35 = 255;
                    } else if (tempAll == -2 || tempAll == 0) {
                        value35 = 33;
                    } else {
                        int value36 = tempAll / 5;
                        value35 = value36 + 1;
                        if (value35 > 63) {
                            value35 = 255;
                        }
                    }
                    data0 = 37;
                    flag = true;
                } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                    int tempAll2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT];
                    if (tempAll2 == -3) {
                        value35 = 63;
                    } else if (tempAll2 == -2 || tempAll2 == 0) {
                        value35 = 254;
                    } else {
                        int value37 = tempAll2 / 5;
                        value35 = value37 - 1;
                        if (value35 < 33) {
                            value35 = 254;
                        }
                    }
                    data0 = 37;
                    flag = true;
                }
                if (flag) {
                    if (data1 == 1) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, value35}, null, null);
                        break;
                    }
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                    break;
                }
            case FinalCanbus.CAR_439_LUZ_BinLi_H /* 1442244 */:
            case FinalCanbus.CAR_452_LZ_Ferrari_430 /* 2556357 */:
            case FinalCanbus.CAR_439_LUZ_BinLi /* 9241015 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[1], null, null);
                    break;
                }
            case FinalCanbus.CAR_WeiChi2_ChangCheng_JOLION_21 /* 1900864 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_JOLION_21_H /* 1966400 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_F7X_19 /* 2031936 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_F7X_19_H /* 2097472 */:
                boolean flag2 = false;
                int value38 = 0;
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_FLOWER_BLOW) {
                        int value39 = DataCanbus.DATA[ConstAllAirDara.U_AIR_FLOWER_BLOW];
                        value38 = value39 + 1;
                        if (value38 > 2) {
                            value38 = 0;
                        }
                        flag2 = true;
                    }
                    if (flag2) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, value38}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                        break;
                    }
                } else if (data0 != ConstAllAirDara.C_AIR_FLOWER_BLOW) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                    break;
                }
            case FinalCanbus.CAR_454_OD_Jianghuai_SEHOL_E50A /* 2490822 */:
            case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5 /* 2818501 */:
            case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5_H /* 2884037 */:
            case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5 /* 3015109 */:
            case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5_H /* 3080645 */:
            case FinalCanbus.CAR_454_OD_Jianghuai_IC5 /* 15270342 */:
                int ints114 = 0;
                int ints313 = 0;
                int ints412 = 0;
                int ints011 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0) | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_AC_MAX ? 1 : 0);
                int ints28 = 0 | (data0 == ConstAllAirDara.C_AIR_MODE_BODY ? 1 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_FOOT ? 3 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UP ? 5 : 0);
                if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                    ints011 = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1 ? 8 : 4;
                } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] < 8) {
                        ints114 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] + 1;
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] > 0) {
                        ints114 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] - 1;
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD || data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                    ints313 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] == -2 ? 2 : DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] == -3 ? 16 : (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] < 18 || DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] > 31) ? 1 : DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] - 15;
                } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB || data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                    ints313 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] == -2 ? 1 : DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] == -3 ? 15 : (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] < 18 || DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] > 31) ? 1 : DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] - 17;
                } else if (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT && (ints412 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT] + 2) > 4) {
                    ints412 = 1;
                }
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints011, ints114, ints28, ints313, ints412, 0}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                    break;
                }
            case FinalCanbus.CAR_WC2_Honda_17Acura_MDX /* 3014977 */:
                boolean flag3 = false;
                int value40 = 0;
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        value40 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                        if (value40 < 7) {
                            value40++;
                        }
                        data0 = 25;
                        flag3 = true;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        value40 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                        if (value40 > 0) {
                            value40--;
                        }
                        data0 = 25;
                        flag3 = true;
                    } else if (data0 == ConstAllAirDara.C_AIR_AC) {
                        int value41 = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC];
                        if (value41 == 0) {
                            value40 = 1;
                        } else {
                            value40 = 0;
                        }
                        flag3 = true;
                    }
                    if (flag3) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, value40}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                        break;
                    }
                } else if (data0 != ConstAllAirDara.C_AIR_WIND_ADD && data0 != ConstAllAirDara.C_AIR_WIND_SUB && data0 != ConstAllAirDara.C_AIR_AC) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                    break;
                }
            case FinalCanbus.CAR_453_RZC_Changan_CS15_EPro_21 /* 3473861 */:
            case FinalCanbus.CAR_452_RZC_ChangAn_19OuShang /* 4719044 */:
            case FinalCanbus.CAR_439_RZC_ChangAn_OUSAN_KESAI /* 7471543 */:
            case FinalCanbus.CAR_452_RZC_ChangAn_KESAI_Pro_21 /* 11010500 */:
                int ints012 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0);
                if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                    if (DataCanbus.DATA[1000] == 4719044) {
                        ints012 = 4;
                    } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                        ints012 = 8;
                    } else {
                        ints012 = 4;
                    }
                }
                int ints013 = ints012 | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0);
                int ints115 = 0 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0);
                int ints116 = ints115 | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints29 = 0 | (data0 == ConstAllAirDara.C_AIR_MODE_BODY ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_FOOT ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT ? 16 : 0);
                int ints314 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                int ints315 = ints314 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints512 = 0 | (data0 == ConstAllAirDara.C_REAR_CTRL ? 4 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints013, ints116, ints29, ints315, 0, ints512}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                    break;
                }
            case FinalCanbus.CAR_452_OD_WeiCai_U70_20 /* 3736004 */:
            case FinalCanbus.CAR_452_Oudi_Jianghuai_IEV7 /* 9503172 */:
            case FinalCanbus.CAR_452_Oudi_Jianghuai_IEV7_H /* 9568708 */:
            case FinalCanbus.CAR_454_OD_WeiCai_EHPro_24 /* 11469254 */:
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_AC) {
                        RemoteModuleProxy remoteModuleProxy13 = DataCanbus.PROXY;
                        int i13 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr13 = new int[2];
                        iArr13[0] = data0;
                        iArr13[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 1 ? 2 : 1;
                        remoteModuleProxy13.cmd(i13, iArr13, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_AUTO) {
                        RemoteModuleProxy remoteModuleProxy14 = DataCanbus.PROXY;
                        int i14 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr14 = new int[2];
                        iArr14[0] = data0;
                        iArr14[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 1 ? 2 : 1;
                        remoteModuleProxy14.cmd(i14, iArr14, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_PTC) {
                        RemoteModuleProxy remoteModuleProxy15 = DataCanbus.PROXY;
                        int i15 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr15 = new int[2];
                        iArr15[0] = data0;
                        iArr15[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_PTC] == 1 ? 2 : 1;
                        remoteModuleProxy15.cmd(i15, iArr15, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_BLOWTOP) {
                        RemoteModuleProxy remoteModuleProxy16 = DataCanbus.PROXY;
                        int i16 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr16 = new int[2];
                        iArr16[0] = data0;
                        iArr16[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOWTOP] == 1 ? 2 : 1;
                        remoteModuleProxy16.cmd(i16, iArr16, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST) {
                        RemoteModuleProxy remoteModuleProxy17 = DataCanbus.PROXY;
                        int i17 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr17 = new int[2];
                        iArr17[0] = data0;
                        iArr17[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT] == 1 ? 2 : 1;
                        remoteModuleProxy17.cmd(i17, iArr17, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST) {
                        RemoteModuleProxy remoteModuleProxy18 = DataCanbus.PROXY;
                        int i18 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr18 = new int[2];
                        iArr18[0] = data0;
                        iArr18[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 1 ? 2 : 1;
                        remoteModuleProxy18.cmd(i18, iArr18, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        RemoteModuleProxy remoteModuleProxy19 = DataCanbus.PROXY;
                        int i19 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr19 = new int[2];
                        iArr19[0] = data0;
                        iArr19[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1 ? 1 : 2;
                        remoteModuleProxy19.cmd(i19, iArr19, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_HEAT) {
                        RemoteModuleProxy remoteModuleProxy20 = DataCanbus.PROXY;
                        int i20 = ConstAllAirDara.C_CONTRAL;
                        int[] iArr20 = new int[2];
                        iArr20[0] = data0;
                        iArr20[1] = DataCanbus.DATA[ConstAllAirDara.U_AIR_HEAT] == 1 ? 2 : 1;
                        remoteModuleProxy20.cmd(i20, iArr20, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{1, 1}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{1, 2}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD || data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{2, 1}, null, null);
                        break;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB || data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{2, 2}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, 1}, null, null);
                        break;
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD || data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{1}, null, null);
                    break;
                } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD || data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB || data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD || data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{2}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0}, null, null);
                    break;
                }
            case FinalCanbus.CAR_439_RZC_LufengXiaoyao /* 4325815 */:
                int ints117 = 0;
                int ints316 = 0;
                boolean flag4 = false;
                int ints014 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0);
                if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                    int vuale3 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                    if (vuale3 < 7) {
                        vuale3++;
                    }
                    ints117 = (vuale3 << 4) & 240;
                    flag4 = true;
                } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                    int vuale4 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                    if (vuale4 > 1) {
                        vuale4--;
                    }
                    ints117 = (vuale4 << 4) & 240;
                    flag4 = true;
                } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD) {
                    int tempAll3 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT];
                    if (tempAll3 != -3) {
                        if (tempAll3 == -2 || tempAll3 == 0) {
                            ints316 = 80;
                        } else {
                            ints316 = (((tempAll3 + 1) + 18) << 2) & 252;
                        }
                    }
                    flag4 = true;
                } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                    int tempAll4 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT];
                    if (tempAll4 == -3) {
                        ints316 = 192;
                    } else if (tempAll4 != -2 && tempAll4 != 0) {
                        ints316 = (((tempAll4 - 1) + 18) << 2) & 252;
                    }
                    flag4 = true;
                }
                int ints210 = 0 | (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_FOOT ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_BODY ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 1 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints014, ints117, ints210, ints316, 0}, null, null);
                    break;
                } else if (data1 == 0 && !flag4) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[5], null, null);
                    break;
                }
            case FinalCanbus.CAR_453_LZ_Chrysler_300C_15 /* 5571013 */:
            case FinalCanbus.CAR_453_LZ_Maserati_Levante_18 /* 5636549 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{24, data0}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{24}, null, null);
                    break;
                }
            case FinalCanbus.CAR_439_RZC_YinFeiNiDi_QX50 /* 6029751 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX70_13 /* 6685126 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_Q70_16_L /* 6750662 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_Q70_16_H /* 6816198 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_FX50S_09 /* 8389062 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_FX37_13 /* 10224070 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX70_15 /* 10289606 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX37_11 /* 10355142 */:
                int ints211 = 0;
                int ints015 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0);
                if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                    if (DataCanbus.DATA[1000] == 6750662 || DataCanbus.DATA[1000] == 6816198) {
                        ints015 = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1 ? 8 : 4;
                    } else {
                        ints211 = 1;
                    }
                }
                int ints016 = ints015 | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT ? 1 : 0);
                int ints118 = 0 | (data0 == ConstAllAirDara.C_AIR_DUAL ? 8 : 0);
                int ints119 = ints118 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints212 = ints211 | (data0 == ConstAllAirDara.C_REAR_LOCK ? 128 : 0) | (data0 == ConstAllAirDara.C_REAR_OFF ? 64 : 0) | (data0 == ConstAllAirDara.C_REAR_MODE ? 32 : 0) | (data0 == ConstAllAirDara.C_REAR_AUTO ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_FLOWER_BLOW ? 4 : 0) | (data0 == ConstAllAirDara.C_CLEAN ? 2 : 0);
                int ints317 = 0 | (data0 == ConstAllAirDara.C_AIR_MODE_ADD ? 8 : 0);
                int ints318 = ints317 | (data0 == ConstAllAirDara.C_AIR_MODE_SUB ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints413 = 0 | (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT ? 128 : 0);
                int ints414 = ints413 | (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT ? 64 : 0) | (data0 == ConstAllAirDara.C_REAR_WIND_UP ? 32 : 0) | (data0 == ConstAllAirDara.C_REAR_WIND_DOWN ? 16 : 0) | (data0 == ConstAllAirDara.C_REAR_LEFT_TEMP_UP ? 8 : 0) | (data0 == ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints016, ints119, ints212, ints318, ints414}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[5], null, null);
                    break;
                }
            case FinalCanbus.CAR_452_Xinchi_Dodge_JCUV /* 6226372 */:
            case FinalCanbus.CAR_454_OD_Maserati_Ghibli_14 /* 14025158 */:
            case FinalCanbus.CAR_454_OD_Maserati_Quattroporte_13 /* 14090694 */:
            case FinalCanbus.CAR_439_XC_Feiyate_Feiyue /* 15532471 */:
                if (this.pagenum == 1) {
                    DataCanbus.PROXY.cmd(3, new int[]{data0, data1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(2, new int[]{data0, data1}, null, null);
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
            case FinalCanbus.CAR_453_OD_BQ_BJ30_21 /* 12845509 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                    break;
                }
            case FinalCanbus.CAR_439_OUDI_Falcon_New_Single /* 13042103 */:
            case FinalCanbus.CAR_439_OUDI_Falcon_New_Double /* 13107639 */:
            case FinalCanbus.CAR_439_OUDI_Territory_New_Single /* 13173175 */:
            case FinalCanbus.CAR_439_OUDI_Territory_New_Double /* 13238711 */:
            case FinalCanbus.CAR_439_OUDI_Territory_Old_Single /* 13304247 */:
            case FinalCanbus.CAR_439_OUDI_Territory_Old_Double /* 13369783 */:
            case FinalCanbus.CAR_439_OUDI_Falcon_Old_Single /* 13435319 */:
            case FinalCanbus.CAR_439_OUDI_Falcon_Old_Double /* 13500855 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{0, data0}, null, null);
                    break;
                }
            case FinalCanbus.CAR_443_WC2_Jili_GS_18 /* 13631931 */:
            case FinalCanbus.CAR_443_WC2_Jili_GL_18 /* 13697467 */:
            case FinalCanbus.CAR_443_WC2_Jili_Boyue_18 /* 13763003 */:
            case FinalCanbus.CAR_443_WC2_Jili_Boyue_20 /* 13828539 */:
            case FinalCanbus.CAR_443_WC2_Jili_Dihao_22 /* 13894075 */:
            case FinalCanbus.CAR_443_WC2_Jili_Binyue_22 /* 13959611 */:
            case FinalCanbus.CAR_443_WC2_Jili_All /* 14025147 */:
                boolean flag5 = false;
                int value42 = 0;
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT) {
                        int value43 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT];
                        value42 = value43 + 1;
                        if (value42 > 3) {
                            value42 = 0;
                        }
                        flag5 = true;
                    } else if (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT) {
                        int value44 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT];
                        value42 = value44 + 1;
                        if (value42 > 3) {
                            value42 = 0;
                        }
                        flag5 = true;
                    }
                    if (flag5) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, value42}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                        break;
                    }
                } else if (data0 != ConstAllAirDara.C_AIR_LEFT_HEAT && data0 != ConstAllAirDara.C_AIR_RIGHT_HEAT) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                    break;
                }
            case FinalCanbus.CAR_439_OUDI_Beiqi_EC3 /* 14090679 */:
            case FinalCanbus.CAR_439_OUDI_Beiqi_EC5 /* 14156215 */:
            case FinalCanbus.CAR_439_OUDI_Beiqi_EC180 /* 14221751 */:
            case FinalCanbus.CAR_439_OUDI_Beiqi_EC220 /* 14287287 */:
            case FinalCanbus.CAR_439_OUDI_Beiqi_EU5 /* 14352823 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, 1}, null, null);
                    break;
                }
            case FinalCanbus.CAR_443_WC2_Feiyate_All_Brazil /* 14090683 */:
                boolean flag6 = false;
                int value45 = 0;
                if (data0 == ConstAllAirDara.C_REAR_WIND_UP) {
                    value45 = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_WIND];
                    if (value45 < 4) {
                        value45++;
                    }
                    data0 = 47;
                    flag6 = true;
                } else if (data0 == ConstAllAirDara.C_REAR_WIND_DOWN) {
                    value45 = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_WIND];
                    if (value45 > 0) {
                        value45--;
                    }
                    data0 = 47;
                    flag6 = true;
                }
                if (flag6) {
                    if (data1 == 1) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, value45}, null, null);
                        break;
                    }
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                    break;
                }
            case FinalCanbus.CAR_453_XC_Ford_EDGE_L /* 16122309 */:
            case FinalCanbus.CAR_453_XC_Ford_EDGE_H /* 16187845 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, 1}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[2], null, null);
                    break;
                }
            default:
                DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                break;
        }
    }

    public void initCallbackId() {
        ConstAllAirDara.initClearAllId();
        switch (DataCanbus.DATA[1000]) {
            case 21:
            case FinalCanbus.CAR_WC2_MengDiOuZS2013_M /* 65557 */:
            case FinalCanbus.CAR_WC2_MengDiOuZS2013_H /* 131093 */:
            case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL /* 196629 */:
            case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL_M /* 262165 */:
            case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL_H /* 327701 */:
            case FinalCanbus.CAR_WC2_18Ecosport /* 393237 */:
            case FinalCanbus.CAR_WC2_MengDiOuZS2018 /* 458773 */:
            case FinalCanbus.CAR_WC2_MengDiOuZS2021 /* 524309 */:
            case FinalCanbus.CAR_CZH_WC2_MengDiOuZS2013_M /* 589845 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_SWING = 17;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_STEER = 66;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_WC2_MengDiOuZS2018 /* 458773 */:
                    case FinalCanbus.CAR_WC2_MengDiOuZS2021 /* 524309 */:
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 23;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 24;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_DUAL = 3;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_MODE_UP = 8;
                ConstAllAirDara.C_AIR_MODE_BODY = 9;
                ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                ConstAllAirDara.C_AIR_AC_MAX = 26;
                ConstAllAirDara.C_AIR_STEER = 45;
                ConstAllAirDara.C_AIR_SWING = 44;
                ConstAllAirDara.C_CONTRAL = 0;
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
                ConstAllAirDara.TEMPERATURE_LOW = 1048576;
                ConstAllAirDara.TEMPERATURE_HIGHT = FinalCanbus.CAR_WC1_VW_Polo_08_18;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_AUTO = 23;
                ConstAllAirDara.C_AIR_DUAL = 24;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 25;
                ConstAllAirDara.C_AIR_AC_MAX = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 26;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 27;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 28;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 29;
                ConstAllAirDara.C_AIR_WIND_ADD = 30;
                ConstAllAirDara.C_AIR_WIND_SUB = 31;
                ConstAllAirDara.C_AIR_MODE_UP = 32;
                ConstAllAirDara.C_AIR_MODE_BODY = 33;
                ConstAllAirDara.C_AIR_MODE_FOOT = 34;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case 61:
            case FinalCanbus.CAR_RZC_XP1_GM_1 /* 65597 */:
            case FinalCanbus.CAR_RZC_XP1_GM_2 /* 131133 */:
            case FinalCanbus.CAR_RZC_XP1_GM_3 /* 196669 */:
            case FinalCanbus.CAR_RZC_XP1_GM_4 /* 262205 */:
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
            case FinalCanbus.CAR_RZC_ALL_GM_08_10AstraH /* 3866685 */:
            case FinalCanbus.CAR_RZC_ALL_GM_11CorsaD /* 3932221 */:
            case FinalCanbus.CAR_RZC_ALL_GM_08Combo /* 3997757 */:
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
                ConstAllAirDara.TEMPERATURE_LOW = 0;
                ConstAllAirDara.TEMPERATURE_HIGHT = 30;
                ConstAllAirDara.U_AIR_HAVE_REAR = 255;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SYNC = 57;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_XP1_GM_3 /* 196669 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_09_19Regal /* 2555965 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_14_18Envision /* 2687037 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_20Envision /* 4063293 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_19Lacrosse_EV /* 4325437 */:
                    case FinalCanbus.CAR_RZC_XP1_GM_3_20 /* 4784189 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_20Regal /* 4849725 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_Laccrose_15_H /* 5111869 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_23ONIX /* 6357053 */:
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
                    case FinalCanbus.CAR_RZC_ALL_GM_18Traverse_H /* 7602237 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_21Silverado /* 8192061 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_21Silverado_H /* 8257597 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_24Onix /* 8454205 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_23Regal /* 8585277 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_23Lacrosse /* 8650813 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_23MaiRuiBaoXL /* 8781885 */:
                    case FinalCanbus.CAR_RZC_ALL_GM_23ChevroletBlazer /* 8847421 */:
                        ConstAllAirDara.C_AIR_MODE_UP = 28;
                        ConstAllAirDara.C_AIR_MODE_BODY = 8;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 11;
                        break;
                    case FinalCanbus.CAR_RZC_ALL_GM_63 /* 4128829 */:
                        ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                        ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                        ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                        ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                        ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                        ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                        ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                        ConstAllAirDara.U_AIR_REAR_SYNC = 39;
                        ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                        ConstAllAirDara.C_REAR_OFF = 107;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 98;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 97;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 98;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 97;
                        ConstAllAirDara.C_REAR_WIND_DOWN = 100;
                        ConstAllAirDara.C_REAR_WIND_UP = 99;
                        ConstAllAirDara.C_REAR_MODE_FOOT = 103;
                        ConstAllAirDara.C_REAR_MODE_BODY = 101;
                        ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 102;
                        ConstAllAirDara.C_REAR_AUTO = 104;
                        ConstAllAirDara.C_REAR_LOCK = 105;
                        ConstAllAirDara.C_REAR_SYNC = 106;
                        ConstAllAirDara.C_AIR_MODE_UP = 28;
                        ConstAllAirDara.C_AIR_MODE_BODY = 8;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 11;
                        break;
                    default:
                        ConstAllAirDara.C_AIR_MODE_BODY = 8;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 9;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 10;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 11;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 26;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 5;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 12;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 27;
                ConstAllAirDara.C_AIR_SYNC = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 20;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 21;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 22;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 24;
                ConstAllAirDara.C_AIR_LEFT_COLD = 23;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 25;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case 86:
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
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 3;
                ConstAllAirDara.C_AIR_WIND_ADD = 4;
                ConstAllAirDara.C_AIR_WIND_SUB = 5;
                ConstAllAirDara.C_AIR_CYCLE = 6;
                ConstAllAirDara.C_AIR_POWER = 7;
                ConstAllAirDara.C_AIR_MODE_BODY = 9;
                ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 17;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_AUTO = 13;
                ConstAllAirDara.C_AIR_AC = 14;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 16;
                ConstAllAirDara.C_CONTRAL = 20;
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
            case FinalCanbus.CAR_RZC4_PSA_17_3008 /* 721235 */:
            case FinalCanbus.CAR_RZC4_PSA_17_3008_M /* 786771 */:
            case FinalCanbus.CAR_RZC4_PSA_17_3008_H /* 852307 */:
            case FinalCanbus.CAR_RZC4_PSA_14_2008 /* 917843 */:
            case FinalCanbus.CAR_RZC4_PSA_14_2008_M /* 983379 */:
            case FinalCanbus.CAR_RZC4_PSA_14_2008_H /* 1048915 */:
            case FinalCanbus.CAR_RZC4_PSA_17_5008 /* 1376595 */:
            case FinalCanbus.CAR_RZC4_PSA_04_407 /* 1638739 */:
            case FinalCanbus.CAR_RZC4_PSA_04_407_CD /* 1704275 */:
            case FinalCanbus.CAR_RZC4_PSA_ALL_NoAir_L /* 2031955 */:
            case FinalCanbus.CAR_RZC4_PSA_ALL_NoAir_M /* 2097491 */:
            case FinalCanbus.CAR_RZC4_PSA_ALL_NoAir_H /* 2163027 */:
            case FinalCanbus.CAR_RZC4_PSA_C4_OE_L /* 2228563 */:
            case FinalCanbus.CAR_RZC4_PSA_C4_OE_M /* 2294099 */:
            case FinalCanbus.CAR_RZC4_PSA_C4_OE_H /* 2359635 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_REAR_CTRL = 38;
                ConstAllAirDara.U_AIR_AQS = 54;
                ConstAllAirDara.U_AIR_WINLEV = 51;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.C_AIR_POWER = 12;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_AC_MAX = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 17;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 18;
                ConstAllAirDara.C_AIR_CYCLE = 14;
                ConstAllAirDara.C_AIR_AUTO = 1;
                ConstAllAirDara.C_AIR_DUAL = 11;
                ConstAllAirDara.C_REAR_CTRL = 15;
                ConstAllAirDara.C_AIR_AQS = 13;
                ConstAllAirDara.C_AIR_WINLEV = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 244;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 245;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 250;
                ConstAllAirDara.C_AIR_MODE_UP = 7;
                ConstAllAirDara.C_AIR_MODE_BODY = 6;
                ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                ConstAllAirDara.C_CONTRAL = 87;
                break;
            case 223:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 3;
                ConstAllAirDara.C_AIR_WIND_ADD = 4;
                ConstAllAirDara.C_AIR_WIND_SUB = 5;
                ConstAllAirDara.C_AIR_CYCLE = 6;
                ConstAllAirDara.C_AIR_POWER = 7;
                ConstAllAirDara.C_AIR_MODE_UP = 10;
                ConstAllAirDara.C_AIR_MODE_BODY = 9;
                ConstAllAirDara.C_AIR_MODE_FOOT = 8;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_AUTO = 13;
                ConstAllAirDara.C_AIR_AC = 14;
                ConstAllAirDara.C_AIR_DUAL = 15;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 17;
                ConstAllAirDara.C_AIR_AC_MAX = 16;
                ConstAllAirDara.C_CONTRAL = 49;
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
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 55;
                ConstAllAirDara.U_AIR_AQS = 54;
                ConstAllAirDara.U_AIR_WINLEV = 51;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                if (DataCanbus.DATA[1000] == 1245436) {
                    ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
                    ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                    ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_AC_MAX = 3;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_DUAL = 15;
                ConstAllAirDara.C_AIR_AQS = 16;
                ConstAllAirDara.C_AIR_WINLEV = 14;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 252;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 253;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 251;
                ConstAllAirDara.C_AIR_MODE_UP = 8;
                ConstAllAirDara.C_AIR_MODE_BODY = 9;
                ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                ConstAllAirDara.C_CONTRAL = 106;
                break;
            case 334:
            case FinalCanbus.CAR_RZC_Focus2019 /* 328014 */:
            case FinalCanbus.CAR_CZH_RZC_Focus2015 /* 3866958 */:
            case FinalCanbus.CAR_RZC_XP1_Focus2015_M /* 4063566 */:
            case FinalCanbus.CAR_RZC_XP1_Focus2015_H /* 4129102 */:
            case FinalCanbus.CAR_RZC_Focus2019_M /* 4587854 */:
            case FinalCanbus.CAR_RZC_Focus2019_H /* 4653390 */:
                ConstAllAirDara.TEMPERATURE_LOW = 1048576;
                ConstAllAirDara.TEMPERATURE_HIGHT = FinalCanbus.CAR_WC1_VW_Polo_08_18;
                ConstAllAirDara.TEMPERATURE_NONE = 1048578;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_AC_MAX = 4;
                ConstAllAirDara.C_AIR_AUTO = 23;
                ConstAllAirDara.C_AIR_DUAL = 24;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 25;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 26;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 27;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 28;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 29;
                ConstAllAirDara.C_AIR_WIND_ADD = 30;
                ConstAllAirDara.C_AIR_WIND_SUB = 31;
                ConstAllAirDara.C_AIR_MODE_UP = 32;
                ConstAllAirDara.C_AIR_MODE_BODY = 33;
                ConstAllAirDara.C_AIR_MODE_FOOT = 34;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case 374:
            case FinalCanbus.CAR_XP1_ZiYouGuang_H /* 65910 */:
            case FinalCanbus.CAR_XP1_17ZhiNanZhe /* 196982 */:
            case FinalCanbus.CAR_XP1_17ZhiNanZhe_H /* 262518 */:
            case FinalCanbus.CAR_XP1_18ZiYouXia /* 721270 */:
            case FinalCanbus.CAR_XP1_Cherokee /* 786806 */:
            case FinalCanbus.CAR_XP1_Cherokee_H /* 852342 */:
            case FinalCanbus.CAR_BNR_XP1_ZiYouGuang /* 917878 */:
            case FinalCanbus.CAR_BNR_XP1_ZiYouGuang_H /* 983414 */:
            case FinalCanbus.CAR_BNR_XP1_17ZhiNanZhe /* 1114486 */:
            case FinalCanbus.CAR_BNR_XP1_17ZhiNanZhe_H /* 1180022 */:
            case FinalCanbus.CAR_XP1_RAM1500_H_AUTO /* 4194678 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.U_AIR_STEER = 66;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.C_AIR_POWER = 16;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 12;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 14;
                ConstAllAirDara.C_AIR_AC_MAX = 15;
                ConstAllAirDara.C_AIR_SYNC = 13;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                ConstAllAirDara.C_AIR_LEFT_COLD = 22;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 23;
                ConstAllAirDara.C_AIR_STEER = 24;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_AIR_MODE_BODY = 8;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 9;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 11;
                ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 20;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 21;
                ConstAllAirDara.C_CONTRAL = 6;
                break;
            case 416:
            case FinalCanbus.CAR_WC2_17MingJue6 /* 65952 */:
            case FinalCanbus.CAR_WC2_RongWei_I5 /* 131488 */:
            case FinalCanbus.CAR_WC2_RongWei_I6 /* 197024 */:
            case FinalCanbus.CAR_WC2_RongWei_EI6 /* 262560 */:
            case FinalCanbus.CAR_WC2_RongWei_RX3 /* 328096 */:
            case FinalCanbus.CAR_WC2_RongWei_HS /* 393632 */:
            case FinalCanbus.CAR_WC2_RongWei_I5_H /* 459168 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_ECO = 52;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_AUTO_LEFT = 49;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_DUAL = 3;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_MODE_UP = 8;
                ConstAllAirDara.C_AIR_MODE_BODY = 9;
                ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 27;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 28;
                ConstAllAirDara.C_AIR_ECO = 40;
                ConstAllAirDara.C_CONTRAL = 0;
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
            case FinalCanbus.CAR_RZC_XP1_BenTeng14B70_QC /* 65624 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 15;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 10;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 11;
                ConstAllAirDara.C_AIR_MODE_BODY = 6;
                ConstAllAirDara.C_AIR_MODE_FOOT = 7;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 19;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 20;
                ConstAllAirDara.C_AIR_AUTO = 18;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 14;
                ConstAllAirDara.C_AIR_WIND_ADD = 8;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 13;
                ConstAllAirDara.C_AIR_CYCLE = 4;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 16;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_RZC_XP1_QiRuiRuiHu7 /* 65940 */:
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
            case FinalCanbus.CAR_RZC_XP1_20QiRuiRuiHu8 /* 1180052 */:
            case FinalCanbus.CAR_RZC_XP1_18JieTU_X70_H /* 1311124 */:
            case FinalCanbus.CAR_RZC_XP1_20Ruihu_5X /* 1442196 */:
            case FinalCanbus.CAR_RZC_XP1_21Ruihu_3X /* 1507732 */:
            case FinalCanbus.CAR_RZC_XP1_21Xiaomayi_EQ1 /* 1638804 */:
            case FinalCanbus.CAR_RZC_LUZ_18QiRuiRuiHu8 /* 1704340 */:
            case FinalCanbus.CAR_RZC_OD_18JieTU_X70 /* 1900948 */:
            case FinalCanbus.CAR_RZC_XP1_22Ruihu_3X /* 2032020 */:
            case FinalCanbus.CAR_RZC_XP1_23Ruihu_3X /* 2097556 */:
            case FinalCanbus.CAR_RZC_XP1_22AiRuiZe5 /* 2163092 */:
            case FinalCanbus.CAR_RZC_QiRui_Guojin_Junxing /* 2228628 */:
            case FinalCanbus.CAR_RZC_XP1_23Ruihu_5X /* 2294164 */:
            case FinalCanbus.CAR_OD_RZC_23QiRuiAiRuiZeE /* 2359700 */:
            case FinalCanbus.CAR_RZC_XP1_23AiRuiZe5 /* 2425236 */:
            case FinalCanbus.CAR_RZC_XP1_23AiRuiZe5_EV /* 2490772 */:
            case FinalCanbus.CAR_RZC_XP1_21DR_F35 /* 2556308 */:
            case FinalCanbus.CAR_OD_RZC_20Showjet /* 2687380 */:
            case FinalCanbus.CAR_RZC_OD_18JieTU_X70_H /* 2752916 */:
            case FinalCanbus.CAR_RZC_OD_19JieTU_X90 /* 2818452 */:
            case FinalCanbus.CAR_RZC_OD_19JieTU_X90_H /* 2883988 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_XP1_19QiRuiHu5X /* 393620 */:
                    case FinalCanbus.CAR_RZC_XP1_19QiRuiHu5X_H /* 459156 */:
                        ConstAllAirDara.U_AIR_SWING = 17;
                        ConstAllAirDara.C_AIR_SWING = 25;
                        break;
                    case FinalCanbus.CAR_RZC_XP1_21Xiaomayi_EQ1 /* 1638804 */:
                        ConstAllAirDara.U_AIR_REAR = 16;
                        ConstAllAirDara.U_AIR_PTC = 68;
                        ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                        ConstAllAirDara.C_AIR_PTC = 19;
                        break;
                    case FinalCanbus.CAR_RZC_QiRui_Guojin_Junxing /* 2228628 */:
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.U_AIR_PTC = 68;
                        ConstAllAirDara.C_AIR_PTC = 19;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 21;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 22;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_DUAL = 3;
                ConstAllAirDara.C_AIR_CYCLE = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 6;
                ConstAllAirDara.C_AIR_MODE_BODY = 7;
                ConstAllAirDara.C_AIR_MODE_FOOT = 9;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 8;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 10;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_AC_MAX = 17;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 18;
                ConstAllAirDara.C_CONTRAL = 1;
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
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_H /* 65990 */:
                    case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_M /* 131526 */:
                    case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_L_Auto /* 197062 */:
                        ConstAllAirDara.U_AIR_HAVE_REAR = 255;
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.C_AIR_AUTO = 21;
                        ConstAllAirDara.U_AIR_DUAL = 14;
                        ConstAllAirDara.C_AIR_DUAL = 16;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 8;
                        break;
                    case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_05_L_Hand /* 262598 */:
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 8;
                        ConstAllAirDara.U_AIR_DUAL = 14;
                        ConstAllAirDara.C_AIR_DUAL = 16;
                        ConstAllAirDara.U_AIR_HAVE_REAR = 255;
                        break;
                    case FinalCanbus.CAR_454_Tangdu_Toyota_Lexus_Lx570_10_CD /* 328134 */:
                    case FinalCanbus.CAR_454_Tangdu_Toyota_Lexus_Lx570_15_CD /* 393670 */:
                    case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_15_TCD /* 459206 */:
                    case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_16_TCD /* 524742 */:
                    case FinalCanbus.CAR_454_Tangdu_Toyota_LexusGX_13_CD /* 590278 */:
                    case FinalCanbus.CAR_454_Tangdu_Toyota_LexusGX_14_CD /* 655814 */:
                        ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
                        ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                        ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                        ConstAllAirDara.C_REAR_AUTO = 52;
                        ConstAllAirDara.C_AIR_AUTO = 21;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 67;
                        ConstAllAirDara.C_AIR_MODE_CENTER = 68;
                        ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT = 69;
                        ConstAllAirDara.U_AIR_ZONE = 14;
                        ConstAllAirDara.C_AIR_ZONE = 16;
                        break;
                }
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_FLOWER_BLOW = 33;
                ConstAllAirDara.U_AIR_SWING = 65;
                ConstAllAirDara.U_AIR_REAR_COOL = 85;
                ConstAllAirDara.U_AIR_REAR_MANUAL = 86;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 41;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_BACK_BLOW_UP = 18;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 19;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 20;
                ConstAllAirDara.U_AIR_REAR_LOCK = 38;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 18;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_FLOWER_BLOW = 32;
                ConstAllAirDara.C_AIR_SWING = 72;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_REAR_OFF = 44;
                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 38;
                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 39;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 65;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 66;
                ConstAllAirDara.C_REAR_WIND_DOWN = 40;
                ConstAllAirDara.C_REAR_WIND_UP = 41;
                ConstAllAirDara.C_REAR_LOCK = 42;
                ConstAllAirDara.C_REAR_COOL = 77;
                ConstAllAirDara.C_AIR_REAR_MANUAL = 76;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_RZC_XP1_YuanJingX6 /* 131211 */:
            case FinalCanbus.CAR_RZC_XP1_YuanJingX1 /* 196747 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS /* 589963 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GL /* 655499 */:
            case FinalCanbus.CAR_RZC_XP1_18YuanJingSUV /* 721035 */:
            case FinalCanbus.CAR_RZC_XP1_Borui /* 786571 */:
            case FinalCanbus.CAR_RZC_XP1_18YuanJingSUV_H /* 852107 */:
            case FinalCanbus.CAR_RZC_XP1_16YuanJingSUV /* 917643 */:
            case FinalCanbus.CAR_RZC_XP1_16YuanJingSUV_H /* 983179 */:
            case FinalCanbus.CAR_RZC_XP1_18YuanJing /* 1114251 */:
            case FinalCanbus.CAR_RZC_BoYue /* 1179787 */:
            case FinalCanbus.CAR_RZC_BoYue_H /* 1245323 */:
            case FinalCanbus.CAR_RZC_Jili_19Dihao /* 1310859 */:
            case FinalCanbus.CAR_RZC_Jili_19Dihao_GL_E /* 1441931 */:
            case FinalCanbus.CAR_RZC_Jili_18Dihao /* 1507467 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS_18 /* 1573003 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GL_16 /* 1638539 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_S1_18 /* 1704075 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS_19 /* 1769611 */:
            case FinalCanbus.CAR_RZC_XP1_YuanJingX3_19_20 /* 1835147 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GL_19 /* 1966219 */:
            case FinalCanbus.CAR_RZC_XP1_20YuanJingSUV /* 2031755 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GL_20 /* 2097291 */:
            case FinalCanbus.CAR_RZC_XP1_Boyue_Pro_20 /* 2162827 */:
            case FinalCanbus.CAR_RZC_XP1_Bingyue_19 /* 2228363 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS_20 /* 2293899 */:
            case FinalCanbus.CAR_RZC_XP1_Jiaji_21 /* 2424971 */:
            case FinalCanbus.CAR_RZC_XP1_Binrui_20 /* 2490507 */:
            case FinalCanbus.CAR_RZC_XP1_Haoyue_20 /* 2556043 */:
            case FinalCanbus.CAR_RZC_XP1_Dihaoe_22 /* 2621579 */:
            case FinalCanbus.CAR_RZC_XP1_Xingrui_22 /* 2687115 */:
            case FinalCanbus.CAR_RZC_BoYue_21 /* 2752651 */:
            case FinalCanbus.CAR_RZC_Xiongmao_Mini_23 /* 2818187 */:
            case FinalCanbus.CAR_RZC_Jili_TX5 /* 2883723 */:
            case FinalCanbus.CAR_RZC_XP1_BingyuePro_19 /* 2949259 */:
            case FinalCanbus.CAR_RZC_Jili_15YuanJing /* 3014795 */:
            case FinalCanbus.CAR_OuDi_XP1_Borui_18 /* 3080331 */:
            case FinalCanbus.CAR_OuDi_XP1_Borui_18_L /* 3145867 */:
            case FinalCanbus.CAR_Oudi_Jili_Binyue_Pro /* 3211403 */:
            case FinalCanbus.CAR_RZC_XP1_Bingyue_21_RS /* 3276939 */:
            case FinalCanbus.CAR_RZC_XP1_Dihao_23 /* 3342475 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                if (DataCanbus.DATA[1000] == 983179 || DataCanbus.DATA[1000] == 917643 || DataCanbus.DATA[1000] == 852107 || DataCanbus.DATA[1000] == 721035 || DataCanbus.DATA[1000] == 131211 || DataCanbus.DATA[1000] == 196747 || DataCanbus.DATA[1000] == 2818187 || DataCanbus.DATA[1000] == 1114251) {
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 2;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                    ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                } else {
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                    ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                    ConstAllAirDara.U_AIR_AQS = 54;
                    ConstAllAirDara.U_AIR_ION = 58;
                    ConstAllAirDara.U_AIR_ECO = 52;
                    ConstAllAirDara.U_AIR_DUAL = 14;
                    ConstAllAirDara.U_AIR_AC_MAX = 53;
                    ConstAllAirDara.C_AIR_AC_MAX = 15;
                    ConstAllAirDara.C_AIR_DUAL = 13;
                    ConstAllAirDara.C_AIR_AQS = 18;
                    ConstAllAirDara.C_AIR_ECO = 19;
                    ConstAllAirDara.C_AIR_ION = 20;
                }
                if (DataCanbus.DATA[1000] == 3276939) {
                    ConstAllAirDara.U_AIR_STEER = 66;
                    ConstAllAirDara.U_AIR_CLEAN = 76;
                    ConstAllAirDara.U_AIR_SWING = 17;
                    ConstAllAirDara.C_AIR_STEER = 72;
                    ConstAllAirDara.C_CLEAN = 73;
                    ConstAllAirDara.C_AIR_SWING = 74;
                }
                ConstAllAirDara.C_AIR_WIND_SUB = 6;
                ConstAllAirDara.C_AIR_WIND_ADD = 7;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 8;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 9;
                ConstAllAirDara.C_AIR_AUTO = 10;
                ConstAllAirDara.C_AIR_AC = 11;
                ConstAllAirDara.C_AIR_CYCLE = 12;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 14;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 16;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 17;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_WeiChi2_17ChangChengH6 /* 131392 */:
            case FinalCanbus.CAR_WeiChi2_18ChangChengH6 /* 196928 */:
            case FinalCanbus.CAR_WeiChi2_ChangChengM6 /* 262464 */:
            case FinalCanbus.CAR_WeiChi2_18ChangChengH6_H /* 524608 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_19Copue /* 590144 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_19F7 /* 655680 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_19Copue_H /* 721216 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_19F7_H /* 786752 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_20FJUN7 /* 852288 */:
            case FinalCanbus.CAR_WeiChi2_17ChangChengH6_H /* 917824 */:
            case FinalCanbus.CAR_WeiChi2_ChangChengH2S /* 983360 */:
            case FinalCanbus.CAR_WeiChi2_ChangChengH4 /* 1048896 */:
            case FinalCanbus.CAR_WeiChi2_17ChangChengH6_M /* 1179968 */:
            case FinalCanbus.CAR_WeiChi2_Changcheng_Jingangpao /* 1376576 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_Jingangpao_H /* 1442112 */:
            case FinalCanbus.CAR_WeiChi2_Changcheng_pao /* 1507648 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_JOLION_21 /* 1900864 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_JOLION_21_H /* 1966400 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_F7X_19 /* 2031936 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_F7X_19_H /* 2097472 */:
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
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_WeiChi2_ChangCheng_JOLION_21 /* 1900864 */:
                    case FinalCanbus.CAR_WeiChi2_ChangCheng_JOLION_21_H /* 1966400 */:
                    case FinalCanbus.CAR_WeiChi2_ChangCheng_F7X_19 /* 2031936 */:
                    case FinalCanbus.CAR_WeiChi2_ChangCheng_F7X_19_H /* 2097472 */:
                        ConstAllAirDara.U_AIR_ION = 58;
                        ConstAllAirDara.U_AIR_FLOWER_BLOW = 71;
                        ConstAllAirDara.C_AIR_ION = 78;
                        ConstAllAirDara.C_AIR_FLOWER_BLOW = 79;
                        break;
                }
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
                ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                ConstAllAirDara.C_AIR_LEFT_COLD = 23;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 24;
                ConstAllAirDara.C_AIR_MODE_BODY = 26;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 27;
                ConstAllAirDara.C_AIR_MODE_FOOT = 29;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 28;
                ConstAllAirDara.C_CONTRAL = 4;
                break;
            case FinalCanbus.CAR_WC_17Haval_H2S /* 196740 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 14;
                ConstAllAirDara.C_AIR_MODE_BODY = 26;
                ConstAllAirDara.C_AIR_MODE_FOOT = 29;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 27;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 28;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_Oudi_XP1_FengGuang17Y580 /* 196922 */:
            case FinalCanbus.CAR_Oudi_XP1_FengGuang17Y560 /* 1507642 */:
            case FinalCanbus.CAR_Oudi_XP1_FengGuang17S560 /* 1638714 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 4;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_AUTO = 6;
                ConstAllAirDara.C_AIR_WIND_ADD = 7;
                ConstAllAirDara.C_AIR_WIND_SUB = 8;
                ConstAllAirDara.C_AIR_MODE_BODY = 9;
                ConstAllAirDara.C_AIR_MODE_FOOT = 12;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 13;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 14;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 16;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_453_OD_Chuangwei_EV /* 197061 */:
            case FinalCanbus.CAR_453_RZC_Chuangwei_EV /* 8651205 */:
            case FinalCanbus.CAR_452_OD_WeiMa_E5 /* 15663556 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 7;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_AC_MAX = 22;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_WC2_CHANGAN_19KeSai /* 262272 */:
            case FinalCanbus.CAR_WC2_CHANGAN_19KeSai_Hand /* 327808 */:
            case FinalCanbus.CAR_WC2_19Oushang_A800 /* 458880 */:
            case FinalCanbus.CAR_WC2_20Oushang_X7_H /* 655488 */:
            case FinalCanbus.CAR_WC2_19ChangAn_CS35_PLUS /* 721024 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_REAR_CTRL = 38;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
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
                ConstAllAirDara.C_AIR_MODE_CHANGER = 21;
                ConstAllAirDara.C_AIR_AC_MAX = 30;
                ConstAllAirDara.C_REAR_CTRL = 46;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_WC2_TOYOTA_HIGHLANDER /* 327974 */:
            case FinalCanbus.CAR_WC_SP_12LuXun /* 917798 */:
            case FinalCanbus.CAR_WC_SP_14KaluoLa_ZiDong /* 1311014 */:
            case FinalCanbus.CAR_WC_SP_Alpha /* 1376550 */:
            case FinalCanbus.CAR_WC_SP_09_Lexus_ES350 /* 1573158 */:
            case FinalCanbus.CAR_WC_SP_09_Lexus_ES350_H /* 1638694 */:
            case FinalCanbus.CAR_WC_Toyota_21Sienna /* 1704230 */:
            case FinalCanbus.CAR_WC2_18PRADO /* 1966374 */:
            case FinalCanbus.CAR_WC2_18Camery /* 2031910 */:
            case FinalCanbus.CAR_WC2_18PRADO_H /* 2097446 */:
            case FinalCanbus.CAR_WC2_16PRADO /* 2162982 */:
            case FinalCanbus.CAR_WC2_16PRADO_H /* 2228518 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Corolla /* 2621734 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Corolla_H /* 2687270 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22Corolla /* 2752806 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22Corolla_H /* 2818342 */:
            case FinalCanbus.CAR_WC2_TOYOTA_06ReiZ_KeepAir /* 2883878 */:
            case FinalCanbus.CAR_WC2_TOYOTA_06ReiZ_ChangeAir /* 2949414 */:
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
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_WC2_TOYOTA_HIGHLANDER /* 327974 */:
                    case FinalCanbus.CAR_WC_SP_14KaluoLa_ZiDong /* 1311014 */:
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
                    case FinalCanbus.CAR_WC2_TOYOTA_17Fortuner /* 4325670 */:
                    case FinalCanbus.CAR_WC2_TOYOTA_13Vellfire /* 4391206 */:
                    case FinalCanbus.CAR_WC2_TOYOTA_17Fortuner_H /* 4456742 */:
                    case FinalCanbus.CAR_WC2_TOYOTA_13Vellfire_H /* 4522278 */:
                    case FinalCanbus.CAR_WC2_TOYOTA_17CHR /* 4587814 */:
                    case FinalCanbus.CAR_WC2_TOYOTA_17CHR_H /* 4653350 */:
                    case FinalCanbus.CAR_WC2_TOYOTA_20Runner /* 4718886 */:
                    case FinalCanbus.CAR_WC2_TOYOTA_20Runner_H /* 4784422 */:
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
                    case FinalCanbus.CAR_WC2_TOYOTA_23Altis /* 8192294 */:
                    case FinalCanbus.CAR_WC2_TOYOTA_23Altis_H /* 8257830 */:
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                        ConstAllAirDara.U_AIR_FRONT_ONLY_F = 92;
                        ConstAllAirDara.U_AIR_ECO = 52;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 23;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 24;
                        ConstAllAirDara.C_AIR_FRONT_ONLY_F = 84;
                        ConstAllAirDara.C_AIR_ECO = 35;
                        break;
                    case FinalCanbus.CAR_WC_SP_12LuXun /* 917798 */:
                    case FinalCanbus.CAR_WC_SP_Alpha /* 1376550 */:
                    case FinalCanbus.CAR_WC2_18Camery /* 2031910 */:
                    case FinalCanbus.CAR_WC2_TOYOTA_02Alpha /* 5701926 */:
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
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.U_AIR_REAR_CTRL = 67;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                        ConstAllAirDara.C_REAR_CTRL = 34;
                        break;
                    case FinalCanbus.CAR_WC_Toyota_21Sienna /* 1704230 */:
                    case FinalCanbus.CAR_WC2_18PRADO /* 1966374 */:
                    case FinalCanbus.CAR_WC2_18PRADO_H /* 2097446 */:
                    case FinalCanbus.CAR_WC2_16PRADO /* 2162982 */:
                    case FinalCanbus.CAR_WC2_16PRADO_H /* 2228518 */:
                    case FinalCanbus.CAR_WC2_TOYOTA_21Sienna_H /* 4849958 */:
                    case FinalCanbus.CAR_WC2_TOYOTA_10Sienna /* 7209254 */:
                    case FinalCanbus.CAR_WC2_TOYOTA_15Sienna /* 7274790 */:
                    case FinalCanbus.CAR_WC2_TOYOTA_21Sienna_NA /* 7340326 */:
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                        ConstAllAirDara.U_AIR_FRONT_ONLY_F = 92;
                        ConstAllAirDara.U_AIR_ECO = 52;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 23;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 24;
                        ConstAllAirDara.C_AIR_FRONT_ONLY_F = 84;
                        ConstAllAirDara.C_AIR_ECO = 35;
                        ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                        ConstAllAirDara.U_AIR_BACK_POWER = 42;
                        ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                        ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 41;
                        ConstAllAirDara.U_AIR_BACK_BLOW_UP = 46;
                        ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                        ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                        ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                        ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT_REAR = 88;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT_REAR = 89;
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT_REAR = 90;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT_REAR = 91;
                        ConstAllAirDara.C_AIR_LEFT_HEAT_REAR = 67;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT_REAR = 68;
                        ConstAllAirDara.C_AIR_LEFT_COLD_REAR = 69;
                        ConstAllAirDara.C_AIR_RIGHT_COLD_REAR = 70;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 33;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 32;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 65;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 64;
                        ConstAllAirDara.C_REAR_AUTO = 66;
                        ConstAllAirDara.C_REAR_OFF = 46;
                        ConstAllAirDara.C_REAR_MODE_FOOT = 81;
                        ConstAllAirDara.C_REAR_MODE_BODY = 82;
                        ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 83;
                        ConstAllAirDara.C_REAR_WIND_DOWN = 43;
                        ConstAllAirDara.C_REAR_WIND_UP = 42;
                        break;
                }
                ConstAllAirDara.C_AIR_DUAL = 41;
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
                ConstAllAirDara.C_CONTRAL = 27;
                break;
            case FinalCanbus.CAR_RZC_HavalLow_H2S_HongBiao /* 393460 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6 /* 458996 */:
            case FinalCanbus.CAR_RZC_HavalLow_H2S_LanBiao /* 721140 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6_16HuanDai /* 852212 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6Couple_16_top /* 983284 */:
            case FinalCanbus.CAR_RZC_HavalLow_Changchengpao_19 /* 1114356 */:
            case FinalCanbus.CAR_RZC_HavalH4_20 /* 1245428 */:
            case FinalCanbus.CAR_RZC_HavalH7_19 /* 1310964 */:
            case FinalCanbus.CAR_RZC_HavalF7_20 /* 1376500 */:
            case FinalCanbus.CAR_RZC_HavalH4_20_H /* 1442036 */:
            case FinalCanbus.CAR_RZC_HavalF7_19 /* 1507572 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6_H /* 1573108 */:
            case FinalCanbus.CAR_RZC_HavalH7_19_H /* 1638644 */:
            case FinalCanbus.CAR_RZC_HavalH7_19_NoAmp /* 1704180 */:
            case FinalCanbus.CAR_RZC_HavalH7_19_H_NoAmp /* 1769716 */:
            case FinalCanbus.CAR_RZC_Haval_Fengjun5_21 /* 1900788 */:
            case FinalCanbus.CAR_RZC_Haval_H3_05 /* 1966324 */:
            case FinalCanbus.CAR_RZC_Haval_Jinggangpao_22 /* 2031860 */:
            case FinalCanbus.CAR_RZC_Haval_H7Hongbiao_18 /* 2097396 */:
            case FinalCanbus.CAR_RZC_Haval_H7Hongbiao_18_H /* 2162932 */:
            case FinalCanbus.CAR_RZC_HavalF7_19_Top /* 2228468 */:
            case FinalCanbus.CAR_RZC_HavalLow_Changchengpao_19_L /* 2294004 */:
            case FinalCanbus.CAR_RZC_HavalH7L_17 /* 2359540 */:
            case FinalCanbus.CAR_RZC_HavalH7L_17_H /* 2425076 */:
                ConstAllAirDara.TEMPERATURE_LOW = 0;
                ConstAllAirDara.TEMPERATURE_HIGHT = 255;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.C_AIR_POWER = 16;
                ConstAllAirDara.C_AIR_AC = 17;
                ConstAllAirDara.C_AIR_CYCLE = 19;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 21;
                ConstAllAirDara.C_AIR_MODE_BODY = 24;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 25;
                ConstAllAirDara.C_AIR_MODE_FOOT = 26;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 27;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 31;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 30;
                ConstAllAirDara.C_AIR_WIND_SUB = 29;
                ConstAllAirDara.C_AIR_WIND_ADD = 28;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 36;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 37;
                ConstAllAirDara.C_AIR_LEFT_COLD = 38;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 39;
                ConstAllAirDara.C_AIR_AUTO = 34;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_HavalLow_H2S_HongBiao /* 393460 */:
                    case FinalCanbus.CAR_RZC_HavalLow_H2S_LanBiao /* 721140 */:
                    case FinalCanbus.CAR_RZC_HavalF7_20 /* 1376500 */:
                    case FinalCanbus.CAR_RZC_HavalF7_19 /* 1507572 */:
                        ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                        ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 31;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 30;
                        break;
                    default:
                        ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                        ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 33;
                        ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 32;
                        break;
                }
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_RZC_FengGuang18Y580 /* 393530 */:
            case FinalCanbus.CAR_RZC_FengGuang18Y580_H /* 459066 */:
            case FinalCanbus.CAR_RZC_DongFengYiZhi_19EV3 /* 524602 */:
            case FinalCanbus.CAR_RZC_Jiangxi_Wushiling_Mux /* 852282 */:
            case FinalCanbus.CAR_RZC_Jiangxi_FengguangS560_21 /* 1179962 */:
            case FinalCanbus.CAR_RZC_FengGuang21Y580 /* 1245498 */:
            case FinalCanbus.CAR_RZC_FengGuang21Y580_H /* 1311034 */:
            case FinalCanbus.CAR_RZC_FengGuang_580Pro_20 /* 1835322 */:
            case FinalCanbus.CAR_RZC_FengGuang_580Pro_20_H /* 1900858 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_DongFengYiZhi_19EV3 /* 524602 */:
                        ConstAllAirDara.C_AIR_PTC = 18;
                        ConstAllAirDara.C_AIR_MODE_BODY = 9;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 12;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 13;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 14;
                        ConstAllAirDara.U_AIR_PTC = 68;
                        break;
                    case FinalCanbus.CAR_RZC_FengGuang_580Pro_20 /* 1835322 */:
                    case FinalCanbus.CAR_RZC_FengGuang_580Pro_20_H /* 1900858 */:
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                        break;
                    default:
                        ConstAllAirDara.C_AIR_MODE_BODY = 9;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 12;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 13;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 14;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 4;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_AUTO = 6;
                ConstAllAirDara.C_AIR_WIND_ADD = 7;
                ConstAllAirDara.C_AIR_WIND_SUB = 8;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 16;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_RZC_BeiQi_19EC5 /* 458979 */:
            case FinalCanbus.CAR_RZC_BeiQi_18EU5 /* 786659 */:
            case FinalCanbus.CAR_RZC_BeiQi_Shenbao_D50_18 /* 852195 */:
            case FinalCanbus.CAR_RZC_BeiQi_20EX3 /* 1245411 */:
            case FinalCanbus.CAR_RZC_BeiQi_20EU5 /* 1376483 */:
            case FinalCanbus.CAR_454_OD_Beijing_X3_18 /* 4063686 */:
            case FinalCanbus.CAR_454_OD_Beijing_X5_18 /* 4129222 */:
            case FinalCanbus.CAR_454_OD_Beiqi_EU5_18 /* 4194758 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_D50_19 /* 4260294 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X35_19 /* 4325830 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X55_18 /* 4391366 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Zhixing_18 /* 4456902 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_HEAT = 63;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                if (DataCanbus.DATA[1000] != 458979) {
                    ConstAllAirDara.U_AIR_AUTO = 13;
                    ConstAllAirDara.U_AIR_AC_MAX = 53;
                    ConstAllAirDara.C_AIR_AUTO = 2;
                    ConstAllAirDara.C_AIR_AC_MAX = 7;
                }
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 4;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_HEAT = 6;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 8;
                ConstAllAirDara.C_AIR_WIND_ADD = 9;
                ConstAllAirDara.C_AIR_WIND_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_RZC1_MZDRX8 /* 524367 */:
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 65;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 7;
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
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_CONTRAL = 3;
                break;
            case FinalCanbus.CAR_RZC_XP1_18Carmy /* 524400 */:
            case FinalCanbus.CAR_RZC_XP1_20RAV4 /* 786544 */:
            case FinalCanbus.CAR_RZC_XP1_19Yazhoulong /* 852080 */:
            case FinalCanbus.CAR_RZC_XP1_18Carmy_H /* 917616 */:
            case FinalCanbus.CAR_RZC_XP1_98_05Lexus_Rx300 /* 983152 */:
            case FinalCanbus.CAR_RZC_XP1_98_03LC100 /* 1114224 */:
            case FinalCanbus.CAR_RZC_XP1_WildLander /* 1245296 */:
            case FinalCanbus.CAR_RZC_XP1_CHR_EV /* 1310832 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_NX200_17 /* 1507440 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES200_13 /* 1572976 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_RX270_14 /* 1638512 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES300_05 /* 1704048 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_RX_09_14 /* 1769584 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES300_20 /* 1835120 */:
            case FinalCanbus.CAR_RZC_XP1_18Carmy_TOP /* 1900656 */:
            case FinalCanbus.CAR_RZC_XP1_22Highlander /* 2097264 */:
            case FinalCanbus.CAR_RZC_XC_Huangguan_14 /* 2162800 */:
            case FinalCanbus.CAR_RZC_XP1_20_LandCruiser /* 2293872 */:
            case FinalCanbus.CAR_RZC_XP1_22_Sienna /* 2424944 */:
            case FinalCanbus.CAR_RZC_XP1_19_Corolla /* 2490480 */:
            case FinalCanbus.CAR_RZC_XP1_20_4Runner /* 2556016 */:
            case FinalCanbus.CAR_RZC_XP1_22_Harrier /* 2621552 */:
            case FinalCanbus.CAR_RZC_XP1_22_CROSS /* 2687088 */:
            case FinalCanbus.CAR_RZC_XP1_22_FRONTLANDER /* 2752624 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_GS_04_07 /* 2818160 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_LS_04_06 /* 2883696 */:
            case FinalCanbus.CAR_RZC_XP1_22_VENZA /* 2949232 */:
            case FinalCanbus.CAR_RZC_Huangguan_14 /* 3014768 */:
            case FinalCanbus.CAR_RZC_XP1_22Highlander_LOW /* 3080304 */:
            case FinalCanbus.CAR_RZC_XP1_22_Sienna_LOW /* 3145840 */:
            case FinalCanbus.CAR_RZC_XP1_05_REIZ /* 3407984 */:
            case FinalCanbus.CAR_RZC_XP1_22Highlander_H /* 3473520 */:
            case FinalCanbus.CAR_RZC_XP1_15_LandCruiser /* 4128880 */:
            case FinalCanbus.CAR_RZC_23_Corolla_Malaysia /* 4194416 */:
            case FinalCanbus.CAR_RZC_23_Vios_Malaysia /* 4259952 */:
            case FinalCanbus.CAR_DUDU_RZC_Toyota_Corolla_14 /* 4325488 */:
            case FinalCanbus.CAR_DUDU_RZC_Toyota_RAV4_20_Hand /* 4391024 */:
            case FinalCanbus.CAR_DUDU_RZC_Toyota_RAV4_20_Auto /* 4456560 */:
            case FinalCanbus.CAR_DUDU_RZC_Toyota_Highlander_15_Hand /* 4522096 */:
            case FinalCanbus.CAR_DUDU_RZC_Toyota_Highlander_15_Auto /* 4587632 */:
            case FinalCanbus.CAR_RZC_Toyota_Prado_02_L /* 4653168 */:
            case FinalCanbus.CAR_RZC_Toyota_Prado_02_H /* 4718704 */:
            case FinalCanbus.CAR_RZC_XP1_05_REIZ_H /* 4784240 */:
            case FinalCanbus.CAR_RZC_Toyota_Prado_10_CD /* 4849776 */:
            case FinalCanbus.CAR_RZC_Toyota_LandCruiser_13_ABC /* 4980848 */:
            case FinalCanbus.CAR_RZC_XP1_22_CROSS_H /* 5046384 */:
            case FinalCanbus.CAR_RZC_XP1_22_FRONTLANDER_H /* 5111920 */:
            case FinalCanbus.CAR_DUDU_RZC_XP1_18Carmy /* 5177456 */:
            case FinalCanbus.CAR_DUDU_RZC_XP1_18Carmy_H /* 5242992 */:
            case FinalCanbus.CAR_DUDU_RZC_XP1_18Carmy_TOP /* 5308528 */:
            case FinalCanbus.CAR_RZC_XP1_20_Sienta /* 5374064 */:
            case FinalCanbus.CAR_RZC_XP1_20_Sienta_H /* 5439600 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_IS_06 /* 5505136 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_IS_06_H /* 5570672 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES_06 /* 5636208 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES_06_H /* 5701744 */:
            case FinalCanbus.CAR_RZC_Toyota_PRIUS_CD /* 5767280 */:
            case FinalCanbus.CAR_RZC_Toyota_PRIUS_NOCD /* 5832816 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_LS460 /* 5898352 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_LS460_H /* 5963888 */:
            case FinalCanbus.CAR_RZC_XP1_LC100 /* 6029424 */:
            case FinalCanbus.CAR_RZC_XP1_LC100_H /* 6094960 */:
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
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_ECO = 52;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.U_AIR_FRONT_ONLY = 92;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 41;
                ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                ConstAllAirDara.U_AIR_FLOWER_BLOW = 76;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_XP1_18Carmy /* 524400 */:
                    case FinalCanbus.CAR_RZC_XP1_20RAV4 /* 786544 */:
                    case FinalCanbus.CAR_RZC_XP1_19Yazhoulong /* 852080 */:
                    case FinalCanbus.CAR_RZC_XP1_18Carmy_H /* 917616 */:
                    case FinalCanbus.CAR_RZC_XP1_98_05Lexus_Rx300 /* 983152 */:
                    case FinalCanbus.CAR_RZC_XP1_98_03LC100 /* 1114224 */:
                    case FinalCanbus.CAR_RZC_XP1_WildLander /* 1245296 */:
                    case FinalCanbus.CAR_RZC_XP1_CHR_EV /* 1310832 */:
                    case FinalCanbus.CAR_RZC_XP1_Lexus_NX200_17 /* 1507440 */:
                    case FinalCanbus.CAR_RZC_XP1_Lexus_ES200_13 /* 1572976 */:
                    case FinalCanbus.CAR_RZC_XP1_Lexus_RX270_14 /* 1638512 */:
                    case FinalCanbus.CAR_RZC_XP1_Lexus_ES300_05 /* 1704048 */:
                    case FinalCanbus.CAR_RZC_XP1_Lexus_RX_09_14 /* 1769584 */:
                    case FinalCanbus.CAR_RZC_XP1_Lexus_ES300_20 /* 1835120 */:
                    case FinalCanbus.CAR_RZC_XP1_18Carmy_TOP /* 1900656 */:
                    case FinalCanbus.CAR_RZC_XP1_22Highlander /* 2097264 */:
                    case FinalCanbus.CAR_RZC_XC_Huangguan_14 /* 2162800 */:
                    case FinalCanbus.CAR_RZC_XP1_20_LandCruiser /* 2293872 */:
                    case FinalCanbus.CAR_RZC_XP1_22_Sienna /* 2424944 */:
                    case FinalCanbus.CAR_RZC_XP1_19_Corolla /* 2490480 */:
                    case FinalCanbus.CAR_RZC_XP1_20_4Runner /* 2556016 */:
                    case FinalCanbus.CAR_RZC_XP1_22_Harrier /* 2621552 */:
                    case FinalCanbus.CAR_RZC_XP1_22_CROSS /* 2687088 */:
                    case FinalCanbus.CAR_RZC_XP1_22_FRONTLANDER /* 2752624 */:
                    case FinalCanbus.CAR_RZC_XP1_Lexus_GS_04_07 /* 2818160 */:
                    case FinalCanbus.CAR_RZC_XP1_22_VENZA /* 2949232 */:
                    case FinalCanbus.CAR_RZC_Huangguan_14 /* 3014768 */:
                    case FinalCanbus.CAR_RZC_XP1_22Highlander_LOW /* 3080304 */:
                    case FinalCanbus.CAR_RZC_XP1_22_Sienna_LOW /* 3145840 */:
                    case FinalCanbus.CAR_RZC_XP1_05_REIZ /* 3407984 */:
                    case FinalCanbus.CAR_RZC_XP1_22Highlander_H /* 3473520 */:
                    case FinalCanbus.CAR_RZC_23_Corolla_Malaysia /* 4194416 */:
                    case FinalCanbus.CAR_RZC_23_Vios_Malaysia /* 4259952 */:
                    case FinalCanbus.CAR_DUDU_RZC_Toyota_Corolla_14 /* 4325488 */:
                    case FinalCanbus.CAR_DUDU_RZC_Toyota_RAV4_20_Hand /* 4391024 */:
                    case FinalCanbus.CAR_DUDU_RZC_Toyota_RAV4_20_Auto /* 4456560 */:
                    case FinalCanbus.CAR_DUDU_RZC_Toyota_Highlander_15_Hand /* 4522096 */:
                    case FinalCanbus.CAR_DUDU_RZC_Toyota_Highlander_15_Auto /* 4587632 */:
                    case FinalCanbus.CAR_RZC_Toyota_Prado_02_L /* 4653168 */:
                    case FinalCanbus.CAR_RZC_Toyota_Prado_02_H /* 4718704 */:
                    case FinalCanbus.CAR_RZC_XP1_05_REIZ_H /* 4784240 */:
                    case FinalCanbus.CAR_RZC_Toyota_Prado_10_CD /* 4849776 */:
                    case FinalCanbus.CAR_RZC_XP1_22_CROSS_H /* 5046384 */:
                    case FinalCanbus.CAR_RZC_XP1_22_FRONTLANDER_H /* 5111920 */:
                    case FinalCanbus.CAR_DUDU_RZC_XP1_18Carmy /* 5177456 */:
                    case FinalCanbus.CAR_DUDU_RZC_XP1_18Carmy_H /* 5242992 */:
                    case FinalCanbus.CAR_DUDU_RZC_XP1_18Carmy_TOP /* 5308528 */:
                    case FinalCanbus.CAR_RZC_XP1_20_Sienta /* 5374064 */:
                    case FinalCanbus.CAR_RZC_XP1_20_Sienta_H /* 5439600 */:
                    case FinalCanbus.CAR_RZC_XP1_Lexus_IS_06 /* 5505136 */:
                    case FinalCanbus.CAR_RZC_XP1_Lexus_IS_06_H /* 5570672 */:
                    case FinalCanbus.CAR_RZC_XP1_Lexus_ES_06 /* 5636208 */:
                    case FinalCanbus.CAR_RZC_XP1_Lexus_ES_06_H /* 5701744 */:
                    case FinalCanbus.CAR_RZC_Toyota_PRIUS_NOCD /* 5832816 */:
                    case FinalCanbus.CAR_RZC_XP1_Lexus_LS460 /* 5898352 */:
                    case FinalCanbus.CAR_RZC_XP1_Lexus_LS460_H /* 5963888 */:
                    case FinalCanbus.CAR_RZC_XP1_LC100 /* 6029424 */:
                    case FinalCanbus.CAR_RZC_XP1_LC100_H /* 6094960 */:
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
                        ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                        ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                        ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                        ConstAllAirDara.U_AIR_SWING = 35;
                        ConstAllAirDara.C_AIR_SWING = 32;
                        ConstAllAirDara.U_AIR_DUAL = 14;
                        ConstAllAirDara.C_AIR_DUAL = 8;
                        break;
                    case FinalCanbus.CAR_RZC_XP1_Lexus_LS_04_06 /* 2883696 */:
                    case FinalCanbus.CAR_RZC_XP1_15_LandCruiser /* 4128880 */:
                    case FinalCanbus.CAR_RZC_Toyota_LandCruiser_13_ABC /* 4980848 */:
                    case FinalCanbus.CAR_RZC_Toyota_PRIUS_CD /* 5767280 */:
                        ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                        ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                        ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                        ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
                        ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                        ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                        ConstAllAirDara.U_AIR_ZONE = 14;
                        ConstAllAirDara.U_AIR_CLEAN = 76;
                        ConstAllAirDara.C_CLEAN = 6;
                        ConstAllAirDara.C_AIR_ZONE = 8;
                        ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT = 5;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 2;
                ConstAllAirDara.C_AIR_AUTO = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 4;
                ConstAllAirDara.C_AIR_AC = 7;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 11;
                ConstAllAirDara.C_AIR_LEFT_COLD = 12;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 13;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 14;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 15;
                ConstAllAirDara.C_AIR_CYCLE = 16;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 17;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 18;
                ConstAllAirDara.C_AIR_FLOWER_BLOW = 19;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 20;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 21;
                ConstAllAirDara.C_AIR_ECO = 22;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 23;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 24;
                ConstAllAirDara.C_REAR_OFF = 25;
                ConstAllAirDara.C_REAR_WIND_UP = 26;
                ConstAllAirDara.C_REAR_WIND_DOWN = 27;
                ConstAllAirDara.C_REAR_MODE = 28;
                ConstAllAirDara.C_REAR_AUTO = 29;
                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 30;
                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 31;
                ConstAllAirDara.C_AIR_FRONT_ONLY = 35;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT_REAR = 88;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT_REAR = 89;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT_REAR = 90;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT_REAR = 91;
                ConstAllAirDara.C_AIR_LEFT_HEAT_REAR = 36;
                ConstAllAirDara.C_AIR_RIGHT_HEAT_REAR = 37;
                ConstAllAirDara.C_AIR_LEFT_COLD_REAR = 38;
                ConstAllAirDara.C_AIR_RIGHT_COLD_REAR = 39;
                ConstAllAirDara.C_CONTRAL = 48;
                break;
            case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15_YC /* 590279 */:
            case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15H_YC /* 655815 */:
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
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15_YC /* 590279 */:
                    case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15H_YC /* 655815 */:
                        ConstAllAirDara.U_AIR_HAVE_REAR = 2;
                        break;
                }
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_FLOWER_BLOW = 33;
                ConstAllAirDara.U_AIR_SWING = 17;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 41;
                ConstAllAirDara.U_AIR_BACK_BLOW_UP = 18;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 19;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 20;
                ConstAllAirDara.U_AIR_REAR_LOCK = 67;
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
                ConstAllAirDara.C_AIR_FLOWER_BLOW = 15;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_REAR_LOCK = 37;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT = 42;
                ConstAllAirDara.C_AIR_SWING = 50;
                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 44;
                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 43;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 52;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 51;
                ConstAllAirDara.C_REAR_AUTO = 49;
                ConstAllAirDara.C_REAR_OFF = 48;
                ConstAllAirDara.C_REAR_MODE = 17;
                ConstAllAirDara.C_REAR_WIND_DOWN = 46;
                ConstAllAirDara.C_REAR_WIND_UP = 45;
                ConstAllAirDara.C_CONTRAL = 3;
                break;
            case FinalCanbus.CAR_RZC_BenTeng_OLDB50 /* 786845 */:
                ConstAllAirDara.TEMPERATURE_NONE = 0;
                ConstAllAirDara.TEMPERATURE_LOW = 15;
                ConstAllAirDara.TEMPERATURE_HIGHT = 49;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_REAR = 38;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 39;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 34;
                ConstAllAirDara.C_CONTRAL = 4;
                break;
            case FinalCanbus.CAR_452_RZC_ZHongtai_E200_18 /* 852420 */:
            case FinalCanbus.CAR_439_RZC_ZhongTaiT500 /* 2163127 */:
            case FinalCanbus.CAR_439_RZC_ZhongTaiT300 /* 2228663 */:
            case FinalCanbus.CAR_439_RZC_ZhongTaiSR9 /* 2294199 */:
            case FinalCanbus.CAR_439_RZC_ZhongTaiSR9_H /* 2359735 */:
            case FinalCanbus.CAR_439_RZC_ZhongTaiSR7 /* 7537079 */:
            case FinalCanbus.CAR_439_RZC_19yema_Bojun /* 8520119 */:
            case FinalCanbus.CAR_452_RZC_Mangguo_LeiDing /* 13697476 */:
            case FinalCanbus.CAR_RZC_ZhongTaiDaMaiX7 /* 14614967 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_REAR = 38;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_MODE_BODY = 18;
                ConstAllAirDara.C_AIR_MODE_FOOT = 19;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 20;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 21;
                if (DataCanbus.DATA[1000] == 852420) {
                    ConstAllAirDara.U_AIR_HEAT = 63;
                    ConstAllAirDara.C_AIR_HEAT = 23;
                    ConstAllAirDara.C_AIR_REAR_DEFROST = 3;
                    ConstAllAirDara.C_AIR_MODE_CHANGER = 24;
                    ConstAllAirDara.C_AIR_MODE_BODY = 255;
                    ConstAllAirDara.C_AIR_MODE_FOOT = 255;
                    ConstAllAirDara.C_AIR_MODE_BODYFOOT = 255;
                    ConstAllAirDara.C_AIR_MODE_UPFOOT = 255;
                } else if (DataCanbus.DATA[1000] == 13697476) {
                    ConstAllAirDara.U_AIR_HEAT = 63;
                    ConstAllAirDara.C_AIR_HEAT = 23;
                    ConstAllAirDara.U_AIR_REAR = 255;
                    ConstAllAirDara.C_AIR_REAR_DEFROST = 255;
                } else {
                    ConstAllAirDara.U_AIR_AC_MAX = 53;
                    ConstAllAirDara.U_AIR_DUAL = 14;
                    ConstAllAirDara.U_AIR_ION = 58;
                    ConstAllAirDara.U_AIR_AUTO = 13;
                    ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                    ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                    ConstAllAirDara.C_AIR_AUTO = 2;
                    ConstAllAirDara.C_AIR_REAR_DEFROST = 3;
                    ConstAllAirDara.C_AIR_AC_MAX = 7;
                    ConstAllAirDara.C_AIR_DUAL = 8;
                    ConstAllAirDara.C_AIR_LEFT_HEAT = 9;
                    ConstAllAirDara.C_AIR_RIGHT_HEAT = 10;
                    ConstAllAirDara.C_AIR_ION = 22;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 4;
                ConstAllAirDara.C_AIR_CYCLE = 5;
                ConstAllAirDara.C_AIR_AC = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 11;
                ConstAllAirDara.C_AIR_WIND_ADD = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 14;
                if (DataCanbus.DATA[1000] == 14614967 || DataCanbus.DATA[1000] == 13697476) {
                    ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 13;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 14;
                } else {
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 15;
                    ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 16;
                }
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_WC2_RENAULT_Jinbei_Guanjing /* 1180000 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR_CTRL = 42;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_AIR_MODE_UP = 8;
                ConstAllAirDara.C_AIR_MODE_BODY = 9;
                ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_REAR_CTRL = 46;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 14;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_443_WC2_Tianlai08_12 /* 1180091 */:
            case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD /* 4719035 */:
            case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD_HW /* 4915643 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 21;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_DUAL = 41;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_455_LZ_Ford_Mustang_L_CYT /* 1245639 */:
            case FinalCanbus.CAR_455_LZ_Ford_Mustang_H_CYT /* 1311175 */:
            case FinalCanbus.CAR_455_LZ_Ford_Mustang_RH_CYT /* 1376711 */:
            case FinalCanbus.CAR_455_LZ_Ford_Mustang_RL_CYT /* 1442247 */:
            case FinalCanbus.CAR_454_LZ_Ford_F150_15_L /* 3932614 */:
            case FinalCanbus.CAR_454_LZ_Ford_F150_15_H /* 3998150 */:
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_STEER = 66;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_455_LZ_Ford_Mustang_H_CYT /* 1311175 */:
                    case FinalCanbus.CAR_455_LZ_Ford_Mustang_RH_CYT /* 1376711 */:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_SYNC = 14;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 13;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 14;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 45;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 46;
                        ConstAllAirDara.C_AIR_SYNC = 8;
                        ConstAllAirDara.C_AIR_AUTO = 2;
                        break;
                    case FinalCanbus.CAR_454_LZ_Ford_F150_15_H /* 3998150 */:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_DUAL = 14;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 13;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 14;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 45;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 46;
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
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_MODE_UP = 3;
                ConstAllAirDara.C_AIR_MODE_BODY = 29;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_455_LZ_Ford_Mustang_L_CYT /* 1245639 */:
                    case FinalCanbus.CAR_455_LZ_Ford_Mustang_H_CYT /* 1311175 */:
                    case FinalCanbus.CAR_455_LZ_Ford_Mustang_RH_CYT /* 1376711 */:
                    case FinalCanbus.CAR_455_LZ_Ford_Mustang_RL_CYT /* 1442247 */:
                        ConstAllAirDara.C_AIR_MODE_FOOT = 31;
                        break;
                    default:
                        ConstAllAirDara.C_AIR_MODE_FOOT = 30;
                        break;
                }
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_AC_MAX = 39;
                ConstAllAirDara.C_AIR_STEER = 47;
                ConstAllAirDara.C_CONTRAL = 5;
                break;
            case FinalCanbus.CAR_RZC_DongFeng_Fengxing_S60EVE /* 1310947 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_REAR_CTRL = 38;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_CYCLE = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 6;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 8;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 10;
                ConstAllAirDara.C_AIR_MODE_BODY = 7;
                ConstAllAirDara.C_AIR_MODE_FOOT = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 23;
                ConstAllAirDara.C_REAR_CTRL = 21;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 24;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 25;
                ConstAllAirDara.C_AIR_LEFT_COLD = 26;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 27;
                ConstAllAirDara.C_CONTRAL = 5;
                break;
            case FinalCanbus.CAR_WC2_BeiQi_M50F /* 1311115 */:
            case FinalCanbus.CAR_WC2_BeiQi_EV300_18 /* 2228619 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_AUTO_LEFT = 49;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 14;
                ConstAllAirDara.C_AIR_MODE_BODY = 26;
                ConstAllAirDara.C_AIR_MODE_FOOT = 29;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 27;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 28;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
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
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
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
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
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
                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 19;
                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 20;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 19;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 20;
                ConstAllAirDara.C_REAR_WIND_DOWN = 21;
                ConstAllAirDara.C_REAR_WIND_UP = 22;
                ConstAllAirDara.C_REAR_LOCK = 18;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_439_LUZ_BinLi_H /* 1442244 */:
            case FinalCanbus.CAR_439_LUZ_BinLi /* 9241015 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AUTO_RIGHT = 26;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_REAR_CTRL = 67;
                ConstAllAirDara.U_AIR_SYNC = 14;
                ConstAllAirDara.U_AIR_REST = 52;
                ConstAllAirDara.U_AIR_AQS = 54;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
                ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
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
                ConstAllAirDara.C_AIR_AUTO_RIGHT = 11;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 12;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 13;
                ConstAllAirDara.C_AIR_MODE_UP = 16;
                ConstAllAirDara.C_AIR_MODE_BODY = 14;
                ConstAllAirDara.C_AIR_MODE_FOOT = 15;
                ConstAllAirDara.C_AIR_MODE_UP_RIGHT = 19;
                ConstAllAirDara.C_AIR_MODE_BODY_RIGHT = 17;
                ConstAllAirDara.C_AIR_MODE_FOOT_RIGHT = 18;
                ConstAllAirDara.C_AIR_AQS = 20;
                ConstAllAirDara.C_AIR_REST = 21;
                ConstAllAirDara.C_REAR_CTRL = 22;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_439_OD_Qirui_KaiyiX3 /* 1507780 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_WIND_ADD = 2;
                ConstAllAirDara.C_AIR_WIND_SUB = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 5;
                ConstAllAirDara.C_AIR_AC = 6;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 9;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 8;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 11;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 12;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_443_WC2_Nissan_Ruiqi /* 1704379 */:
            case FinalCanbus.CAR_444_WC2_Dongfeng_Xiaokang_Ix5 /* 1835452 */:
            case FinalCanbus.CAR_443_WC2_Nissan_Ruiqi7 /* 7799227 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                if (DataCanbus.DATA[1000] == 1835452) {
                    ConstAllAirDara.U_AIR_AUTO = 13;
                    ConstAllAirDara.U_AIR_REAR = 38;
                    ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                    ConstAllAirDara.C_AIR_AUTO = 4;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 21;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 14;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_453_OD_Jiangling_Kaiyun_H /* 1835461 */:
            case FinalCanbus.CAR_454_OD_Jiangling_Dadao /* 14483910 */:
                ConstAllAirDara.TEMPERATURE_NONE = 0;
                ConstAllAirDara.TEMPERATURE_LOW = 36;
                ConstAllAirDara.TEMPERATURE_HIGHT = 64;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_WIND_ADD = 2;
                ConstAllAirDara.C_AIR_WIND_SUB = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 5;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 6;
                ConstAllAirDara.C_AIR_AC = 7;
                ConstAllAirDara.C_AIR_CYCLE = 8;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 10;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 9;
                ConstAllAirDara.C_AIR_AUTO = 11;
                ConstAllAirDara.C_CONTRAL = 2;
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
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                switch (DataCanbus.DATA[1000]) {
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
                    case FinalCanbus.CAR_453_Tangdu_Toyota_HIGHLANDER_15_A /* 10486213 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_ALPHARD_15_A /* 10551749 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_HIGHLANDER_09_A /* 10748357 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_ALPHARD_11_A /* 10813893 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_Corolla_07_A /* 10879429 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_Corolla_14_A /* 10944965 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_Reiz_09_A /* 11010501 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_RAV4_12_A /* 11076037 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_Tundra_14_A /* 11141573 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_Prado_18_Auto /* 11272645 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_Camery_18 /* 11534789 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_ALPHARD_18_A /* 11600325 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_FORTUNER_15_A /* 11665861 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_Tundra_10_A /* 11796933 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_LexusGX_13 /* 12059077 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_LexusGX_14 /* 12124613 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_FORTUNER_16_H /* 12386757 */:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.C_AIR_AUTO = 21;
                        ConstAllAirDara.U_AIR_DUAL = 14;
                        ConstAllAirDara.C_AIR_DUAL = 16;
                        ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                        ConstAllAirDara.C_REAR_AUTO = 45;
                        ConstAllAirDara.C_AIR_MODE_ADD = 8;
                        ConstAllAirDara.C_AIR_MODE_SUB = 7;
                        break;
                    case FinalCanbus.CAR_453_Tangdu_Toyota_Prado_14_Hand /* 10420677 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_HIGHLANDER_15_H /* 10617285 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_HIGHLANDER_09_H /* 10682821 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_Tundra_14_H /* 11207109 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_Prado_18_H /* 11338181 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_FORTUNER_16_L /* 11731397 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_Tundra_10_H /* 11862469 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_Camery_09_H /* 12190149 */:
                        ConstAllAirDara.U_AIR_DUAL = 255;
                        ConstAllAirDara.C_AIR_DUAL = 255;
                        ConstAllAirDara.C_AIR_MODE_ADD = 8;
                        ConstAllAirDara.C_AIR_MODE_SUB = 7;
                        break;
                    case FinalCanbus.CAR_453_Tangdu_Toyota_LAND_CRUISE_15_T /* 11403717 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_LexusLX570_10 /* 11469253 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_LAND_CRUISE_16_T /* 11928005 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_LexusLX570_14 /* 11993541 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_LAND_CRUISE_08_M /* 12255685 */:
                    case FinalCanbus.CAR_453_Tangdu_Toyota_LAND_CRUISE_16_M /* 12321221 */:
                        ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
                        ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                        ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                        ConstAllAirDara.C_REAR_AUTO = 45;
                        ConstAllAirDara.C_AIR_AUTO = 21;
                        ConstAllAirDara.C_AIR_MODE_CHANGER = 69;
                        ConstAllAirDara.C_AIR_MODE_CENTER = 68;
                        ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT = 67;
                        ConstAllAirDara.U_AIR_ZONE = 14;
                        ConstAllAirDara.C_AIR_ZONE = 16;
                        break;
                }
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_FLOWER_BLOW = 33;
                ConstAllAirDara.U_AIR_NANOE = 34;
                ConstAllAirDara.U_AIR_SWING = 35;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 41;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.U_AIR_REAR_LOCK = 38;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_FLOWER_BLOW = 32;
                ConstAllAirDara.C_AIR_NANOE = 33;
                ConstAllAirDara.C_AIR_SWING = 54;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                ConstAllAirDara.C_AIR_LEFT_COLD = 12;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 14;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_REAR_OFF = 44;
                ConstAllAirDara.C_REAR_MODE = 43;
                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 38;
                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 39;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 65;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 66;
                ConstAllAirDara.C_REAR_WIND_DOWN = 40;
                ConstAllAirDara.C_REAR_WIND_UP = 41;
                ConstAllAirDara.C_REAR_LOCK = 42;
                ConstAllAirDara.C_CONTRAL = 3;
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
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_STEER = 66;
                ConstAllAirDara.U_AIR_SWING = 17;
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
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 19;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 20;
                ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_AC_MAX = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_REAR_OFF = 17;
                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 19;
                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 20;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 19;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 20;
                ConstAllAirDara.C_REAR_WIND_DOWN = 21;
                ConstAllAirDara.C_REAR_WIND_UP = 22;
                ConstAllAirDara.C_REAR_LOCK = 18;
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
                ConstAllAirDara.C_AIR_SWING = 41;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_455_OD_Jilie_JiheA /* 2228679 */:
            case FinalCanbus.CAR_452_OD_Ruilan_X3_Pro /* 2425285 */:
            case FinalCanbus.CAR_452_OD_Jihe_EX3 /* 2490821 */:
            case FinalCanbus.CAR_453_OD_Jili_Panda_Mini /* 8454597 */:
            case FinalCanbus.CAR_454_OD_Jilie_DihaoS /* 14156230 */:
            case FinalCanbus.CAR_454_OD_Jilie_YuanchengXingzhi /* 14549446 */:
            case FinalCanbus.CAR_453_OD_Jili_Dihao_EV /* 16056773 */:
                ConstAllAirDara.U_AIR_POWER = 10;
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
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                if (DataCanbus.DATA[1000] == 16056773 || DataCanbus.DATA[1000] == 14156230 || DataCanbus.DATA[1000] == 14549446) {
                    ConstAllAirDara.U_AIR_AQS = 54;
                    ConstAllAirDara.U_AIR_ION = 58;
                    ConstAllAirDara.U_AIR_ECO = 52;
                    ConstAllAirDara.U_AIR_CLEAN = 76;
                    ConstAllAirDara.U_AIR_PARK = 80;
                    ConstAllAirDara.C_AIR_AQS = 18;
                    ConstAllAirDara.C_AIR_ECO = 19;
                    ConstAllAirDara.C_AIR_ION = 20;
                    ConstAllAirDara.C_CLEAN = 21;
                    ConstAllAirDara.C_AIR_PARK = 22;
                } else {
                    ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                    ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                    ConstAllAirDara.C_AIR_LEFT_HEAT = 16;
                    ConstAllAirDara.C_AIR_RIGHT_HEAT = 17;
                }
                ConstAllAirDara.C_AIR_WIND_SUB = 6;
                ConstAllAirDara.C_AIR_WIND_ADD = 7;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 8;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 9;
                ConstAllAirDara.C_AIR_AUTO = 10;
                ConstAllAirDara.C_AIR_AC = 11;
                ConstAllAirDara.C_AIR_CYCLE = 12;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 14;
                ConstAllAirDara.C_AIR_AC_MAX = 15;
                ConstAllAirDara.C_AIR_DUAL = 13;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_WC2_JieTu_X70_22 /* 2294155 */:
            case FinalCanbus.CAR_WC2_JieTu_X70_22_H /* 2359691 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_AUTO_LEFT = 49;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_MODE_BODY = 25;
                ConstAllAirDara.C_AIR_MODE_FOOT = 28;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 26;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 27;
                ConstAllAirDara.C_AIR_AC_MAX = 30;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_454_OD_Jianghuai_SEHOL_E50A /* 2490822 */:
            case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5 /* 2818501 */:
            case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5_H /* 2884037 */:
            case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5 /* 3015109 */:
            case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5_H /* 3080645 */:
            case FinalCanbus.CAR_454_OD_Jianghuai_IC5 /* 15270342 */:
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
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 19;
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
            case FinalCanbus.CAR_452_LZ_Ferrari_430 /* 2556357 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_AUTO_LEFT = 49;
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
                ConstAllAirDara.C_AIR_AUTO = 5;
                ConstAllAirDara.C_AIR_CYCLE = 9;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 4;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_453_LZ_Nissan_Teana_03 /* 2687429 */:
            case FinalCanbus.CAR_453_LZ_Nissan_Teana_03_H /* 2752965 */:
                ConstAllAirDara.U_AIR_POWER = 10;
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
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_POWER = 6;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_DUAL = 14;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 8;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 7;
                ConstAllAirDara.C_AIR_AUTO = 5;
                ConstAllAirDara.C_AIR_AC = 11;
                ConstAllAirDara.C_AIR_CYCLE = 12;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_455_6606_RZC_VinFast_PLUS_23 /* 2949575 */:
            case FinalCanbus.CAR_453_RZC_VinFast_PLUS_23 /* 15860165 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 39;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 34;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_WC2_Honda_17Acura_MDX /* 3014977 */:
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                ConstAllAirDara.U_AIR_BACK_BLOW_UP = 48;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_AC_MAX = 30;
                ConstAllAirDara.C_AIR_SYNC = 3;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                ConstAllAirDara.C_AIR_LEFT_COLD = 19;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 20;
                ConstAllAirDara.C_AIR_WIND_ADD = 25;
                ConstAllAirDara.C_AIR_WIND_SUB = 249;
                ConstAllAirDara.C_AIR_MODE_BODY = 9;
                ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 24;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 23;
                ConstAllAirDara.C_REAR_OFF = 46;
                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 33;
                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 32;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 33;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 32;
                ConstAllAirDara.C_REAR_LOCK = 34;
                ConstAllAirDara.C_REAR_WIND_DOWN = 43;
                ConstAllAirDara.C_REAR_WIND_UP = 42;
                ConstAllAirDara.C_REAR_AUTO = 66;
                ConstAllAirDara.C_REAR_MODE_FOOT = 81;
                ConstAllAirDara.C_REAR_MODE_BODY = 82;
                ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 83;
                ConstAllAirDara.C_CONTRAL = 107;
                break;
            case FinalCanbus.CAR_455_OD_ChangAn_CS95_H /* 3277255 */:
            case FinalCanbus.CAR_439_OD_ChangAn_CS95 /* 7930295 */:
                ConstAllAirDara.TEMPERATURE_LOW = 0;
                ConstAllAirDara.TEMPERATURE_HIGHT = 255;
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
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_455_OD_ChangAn_CS95_H /* 3277255 */:
                        ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                        ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                        ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                        ConstAllAirDara.U_AIR_BACK_POWER = 42;
                        ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                        ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                        ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                        ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                        ConstAllAirDara.C_REAR_OFF = 37;
                        ConstAllAirDara.C_REAR_WIND_UP = 39;
                        ConstAllAirDara.C_REAR_WIND_DOWN = 38;
                        ConstAllAirDara.C_REAR_MODE = 42;
                        ConstAllAirDara.C_REAR_AUTO = 43;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 41;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 40;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 41;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 40;
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
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_AUTO = 25;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_453_RZC_Changan_CS15_EPro_21 /* 3473861 */:
            case FinalCanbus.CAR_452_RZC_ChangAn_19OuShang /* 4719044 */:
            case FinalCanbus.CAR_439_RZC_ChangAn_OUSAN_KESAI /* 7471543 */:
            case FinalCanbus.CAR_452_RZC_ChangAn_KESAI_Pro_21 /* 11010500 */:
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
                if (DataCanbus.DATA[1000] == 7471543 || DataCanbus.DATA[1000] == 11010500) {
                    ConstAllAirDara.U_AIR_REAR_CTRL = 38;
                    ConstAllAirDara.C_REAR_CTRL = 12;
                    ConstAllAirDara.C_AIR_MODE_BODY = 13;
                    ConstAllAirDara.C_AIR_MODE_FOOT = 14;
                    ConstAllAirDara.C_AIR_MODE_BODYFOOT = 15;
                    ConstAllAirDara.C_AIR_MODE_UPFOOT = 16;
                } else {
                    ConstAllAirDara.C_AIR_MODE_CHANGER = 2;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 3;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_CYCLE = 5;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 6;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 7;
                ConstAllAirDara.C_AIR_WIND_SUB = 8;
                ConstAllAirDara.C_AIR_WIND_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_454_LZ_Toyota_Prius_03_L /* 3539398 */:
            case FinalCanbus.CAR_454_LZ_Toyota_Prius_03_H /* 3604934 */:
            case FinalCanbus.CAR_454_LZ_Lexus_RX330_L /* 3801542 */:
            case FinalCanbus.CAR_454_LZ_Lexus_RX330_H /* 3867078 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_CYCLE = 12;
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
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 18;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_452_OD_WeiCai_U70_20 /* 3736004 */:
            case FinalCanbus.CAR_454_OD_WeiCai_EHPro_24 /* 11469254 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 18;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                if (DataCanbus.DATA[1000] == 11469254) {
                    ConstAllAirDara.U_AIR_PTC = 68;
                    ConstAllAirDara.U_AIR_BLOWTOP = 72;
                    ConstAllAirDara.C_AIR_PTC = 10;
                    ConstAllAirDara.C_AIR_BLOWTOP = 11;
                }
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_WIND_ADD = 1;
                ConstAllAirDara.C_AIR_WIND_SUB = 17;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 18;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 18;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 3;
                ConstAllAirDara.C_AIR_AC = 4;
                ConstAllAirDara.C_AIR_CYCLE = 5;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 7;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_AUTO = 9;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_439_XBS_09Tianlai /* 4063671 */:
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC = 11;
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
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 38;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_439_HC_RongWei950 /* 4129207 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SYNC = 14;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_SYNC = 13;
                ConstAllAirDara.C_AIR_MODE_BODY = 8;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 9;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 10;
                ConstAllAirDara.C_AIR_MODE_FOOT = 11;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 5;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 20;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 21;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 6;
                ConstAllAirDara.C_AIR_WIND_SUB = 7;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_RZC_HONDA_23Yage /* 4260138 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_Civic /* 5636394 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_10Yage /* 5701930 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_Haoying /* 5767466 */:
            case FinalCanbus.CAR_CZH_RZC_HONDA_CRV /* 5833002 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
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
                ConstAllAirDara.C_AIR_POWER = 17;
                ConstAllAirDara.C_AIR_AC = 39;
                ConstAllAirDara.C_AIR_CYCLE = 41;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 35;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 36;
                ConstAllAirDara.C_AIR_AUTO = 37;
                ConstAllAirDara.C_AIR_DUAL = 32;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 19;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 18;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 21;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 20;
                ConstAllAirDara.C_AIR_WIND_ADD = 26;
                ConstAllAirDara.C_AIR_WIND_SUB = 25;
                ConstAllAirDara.C_AIR_MODE_BODY = 3;
                ConstAllAirDara.C_AIR_MODE_FOOT = 5;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 4;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 6;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 27;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 29;
                ConstAllAirDara.C_AIR_LEFT_COLD = 28;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 30;
                ConstAllAirDara.C_CONTRAL = 105;
                break;
            case FinalCanbus.CAR_439_RZC_LufengXiaoyao /* 4325815 */:
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
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.C_AIR_AUTO = 13;
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_CYCLE = 2;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 6;
                ConstAllAirDara.C_AIR_MODE_BODY = 7;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 8;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 9;
                ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_454_Sanwu_Ford_Mondeo_16 /* 4522438 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Mondeo_17 /* 4587974 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_16_H /* 4653510 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Taurus_10_H /* 4719046 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_17_Auto /* 4784582 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_F150_14_Auto /* 4850118 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_F150_15 /* 4915654 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_KUGA_15 /* 4981190 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_KUGA_18 /* 5046726 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_FOCUS_15 /* 5112262 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_FOCUS_18 /* 5177798 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_15_H /* 5243334 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_18_H /* 5308870 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_15 /* 5374406 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_18 /* 5439942 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_F150_12_H /* 5505478 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_F150_17 /* 5571014 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_F150_18 /* 5636550 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_15 /* 5702086 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_12_L /* 5767622 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_12_H /* 5833158 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_15_L /* 5898694 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Everest_16 /* 5964230 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Everest_18 /* 6029766 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_16_L /* 6095302 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Taurus_10_L /* 6160838 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_F150_14_Hand /* 6226374 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Mondeo_18 /* 6291910 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_17_SYNC3 /* 6357446 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_17_Hand /* 6422982 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_10_Auto /* 6488518 */:
            case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_10_Hand /* 6554054 */:
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_12_L /* 5767622 */:
                    case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_15_L /* 5898694 */:
                    case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_16_L /* 6095302 */:
                    case FinalCanbus.CAR_454_Sanwu_Ford_Taurus_10_L /* 6160838 */:
                    case FinalCanbus.CAR_454_Sanwu_Ford_F150_14_Hand /* 6226374 */:
                    case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_17_Hand /* 6422982 */:
                    case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_10_Hand /* 6554054 */:
                        break;
                    default:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
                        ConstAllAirDara.C_AIR_AUTO = 23;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 58;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 59;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 60;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 61;
                        ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                        ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                        ConstAllAirDara.U_AIR_BACK_BLOW_UP = 18;
                        ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 19;
                        ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 20;
                        ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                        ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                        ConstAllAirDara.U_AIR_BACK_POWER = 42;
                        ConstAllAirDara.C_REAR_OFF = 17;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 19;
                        ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 20;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 19;
                        ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 20;
                        ConstAllAirDara.C_REAR_WIND_DOWN = 21;
                        ConstAllAirDara.C_REAR_WIND_UP = 22;
                        ConstAllAirDara.C_REAR_LOCK = 18;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_AC_MAX = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 7;
                ConstAllAirDara.C_AIR_DUAL = 24;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 49;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 50;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 51;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 52;
                ConstAllAirDara.C_AIR_WIND_ADD = 53;
                ConstAllAirDara.C_AIR_WIND_SUB = 54;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 62;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_453_RZC_SWM_G01_22 /* 4784581 */:
            case FinalCanbus.CAR_452_RZC_SWM_G01_21_Low /* 11338180 */:
            case FinalCanbus.CAR_439_RZC_SWM_G01 /* 13894071 */:
            case FinalCanbus.CAR_439_RZC_SWM_G01_19 /* 15729079 */:
            case FinalCanbus.CAR_439_RZC_WEICHAI_U70 /* 15794615 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 6;
                ConstAllAirDara.C_AIR_WIND_ADD = 7;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 8;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 9;
                ConstAllAirDara.C_AIR_AC = 10;
                ConstAllAirDara.C_AIR_CYCLE = 11;
                ConstAllAirDara.C_AIR_LEFT_COLD = 12;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 13;
                ConstAllAirDara.C_AIR_MODE_BODY = 14;
                ConstAllAirDara.C_AIR_MODE_FOOT = 15;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 16;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 17;
                ConstAllAirDara.C_AIR_AUTO = 18;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_453_LZ_Chrysler_300C_15 /* 5571013 */:
            case FinalCanbus.CAR_453_LZ_Maserati_Levante_18 /* 5636549 */:
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AUTO = 13;
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
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 41;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 19;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 20;
                ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_REAR_AC = 78;
                ConstAllAirDara.U_AIR_REAR_SYNC = 39;
                if (DataCanbus.DATA[1000] == 5636549) {
                    ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
                    ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                    ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                    ConstAllAirDara.U_AIR_AUTO_RIGHT = 26;
                    ConstAllAirDara.C_AIR_MODE_UP = 39;
                    ConstAllAirDara.C_AIR_MODE_FOOT = 17;
                    ConstAllAirDara.C_AIR_MODE_BODY = 15;
                    ConstAllAirDara.C_AIR_MODE_UP_RIGHT = 42;
                    ConstAllAirDara.C_AIR_MODE_BODY_RIGHT = 40;
                    ConstAllAirDara.C_AIR_MODE_FOOT_RIGHT = 41;
                    ConstAllAirDara.C_AIR_AUTO_RIGHT = 43;
                } else {
                    ConstAllAirDara.C_AIR_MODE_FOOT = 17;
                    ConstAllAirDara.C_AIR_MODE_BODY = 15;
                    ConstAllAirDara.C_AIR_MODE_BODYFOOT = 16;
                    ConstAllAirDara.C_AIR_MODE_UPFOOT = 18;
                }
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_AIR_WIND_ADD = 5;
                ConstAllAirDara.C_AIR_WIND_SUB = 6;
                ConstAllAirDara.C_AIR_POWER = 7;
                ConstAllAirDara.C_AIR_SYNC = 8;
                ConstAllAirDara.C_AIR_AC_MAX = 9;
                ConstAllAirDara.C_AIR_AC = 10;
                ConstAllAirDara.C_AIR_CYCLE = 11;
                ConstAllAirDara.C_AIR_AUTO = 12;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 13;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 14;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 22;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 20;
                ConstAllAirDara.C_AIR_LEFT_COLD = 23;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 21;
                ConstAllAirDara.C_AIR_STEER = 24;
                ConstAllAirDara.C_REAR_OFF = 31;
                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 26;
                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 25;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 28;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 27;
                ConstAllAirDara.C_REAR_WIND_DOWN = 30;
                ConstAllAirDara.C_REAR_WIND_UP = 29;
                ConstAllAirDara.C_REAR_SYNC = 32;
                ConstAllAirDara.C_REAR_AC = 33;
                ConstAllAirDara.C_REAR_AUTO = 34;
                ConstAllAirDara.C_REAR_MODE_FOOT = 37;
                ConstAllAirDara.C_REAR_MODE_BODY = 35;
                ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 36;
                ConstAllAirDara.C_REAR_LOCK = 38;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_453_DJ_Nissan_NOCD /* 5833157 */:
            case FinalCanbus.CAR_453_DJ_Nissan_NOCD_H /* 5898693 */:
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
            case FinalCanbus.CAR_439_RZC_YinFeiNiDi_QX50 /* 6029751 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX70_13 /* 6685126 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_Q70_16_L /* 6750662 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_Q70_16_H /* 6816198 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_FX50S_09 /* 8389062 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_FX37_13 /* 10224070 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX70_15 /* 10289606 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX37_11 /* 10355142 */:
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                if (DataCanbus.DATA[1000] == 6750662) {
                    ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
                    ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                    ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                    ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT = 7;
                } else if (DataCanbus.DATA[1000] == 6816198) {
                    ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                    ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
                    ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                    ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                    ConstAllAirDara.U_AIR_BACK_BLOW_UP = 46;
                    ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                    ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                    ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                    ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                    ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                    ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                    ConstAllAirDara.U_AIR_FLOWER_BLOW = 80;
                    ConstAllAirDara.U_AIR_CLEAN = 72;
                    ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                    ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                    ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                    ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT = 7;
                    ConstAllAirDara.C_REAR_LOCK = 12;
                    ConstAllAirDara.C_REAR_OFF = 13;
                    ConstAllAirDara.C_REAR_MODE = 14;
                    ConstAllAirDara.C_REAR_AUTO = 15;
                    ConstAllAirDara.C_AIR_FLOWER_BLOW = 16;
                    ConstAllAirDara.C_CLEAN = 17;
                    ConstAllAirDara.C_AIR_LEFT_HEAT = 21;
                    ConstAllAirDara.C_AIR_RIGHT_HEAT = 22;
                    ConstAllAirDara.C_REAR_WIND_UP = 22;
                    ConstAllAirDara.C_REAR_WIND_DOWN = 23;
                    ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 25;
                    ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 24;
                    ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 25;
                    ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 24;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 2;
                ConstAllAirDara.C_AIR_AUTO = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 4;
                ConstAllAirDara.C_AIR_CYCLE = 5;
                ConstAllAirDara.C_AIR_AC = 6;
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 11;
                ConstAllAirDara.C_AIR_CYCLE = 18;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 19;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 20;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 26;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 27;
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
            case FinalCanbus.CAR_454_OD_Zhonghua_V7 /* 14221766 */:
            case FinalCanbus.CAR_454_OD_Zhonghua_V7_H /* 14287302 */:
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
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
                ConstAllAirDara.C_AIR_AUTO = 16;
                ConstAllAirDara.C_AIR_DUAL = 17;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 18;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 19;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_452_Xinchi_Dodge_JCUV /* 6226372 */:
            case FinalCanbus.CAR_454_OD_Maserati_Ghibli_14 /* 14025158 */:
            case FinalCanbus.CAR_454_OD_Maserati_Quattroporte_13 /* 14090694 */:
            case FinalCanbus.CAR_439_XC_Feiyate_Feiyue /* 15532471 */:
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_STEER = 66;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 40;
                ConstAllAirDara.U_AIR_BACK_BLOW_UP = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_454_OD_Maserati_Ghibli_14 /* 14025158 */:
                    case FinalCanbus.CAR_454_OD_Maserati_Quattroporte_13 /* 14090694 */:
                        ConstAllAirDara.U_AIR_AC_MAX = 53;
                        ConstAllAirDara.C_AIR_AC_MAX = 18;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_SYNC = 7;
                ConstAllAirDara.C_AIR_MODE_BODY = 8;
                ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 9;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 11;
                ConstAllAirDara.C_AIR_WIND_ADD = 13;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 17;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 32;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 34;
                ConstAllAirDara.C_REAR_OFF = 0;
                ConstAllAirDara.C_REAR_LOCK = 31;
                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 14;
                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 15;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 14;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 15;
                ConstAllAirDara.C_REAR_AUTO = 4;
                ConstAllAirDara.C_REAR_MODE_FOOT = 10;
                ConstAllAirDara.C_REAR_MODE_BODY = 8;
                ConstAllAirDara.C_REAR_MODE_BODY_FOOT = 9;
                ConstAllAirDara.C_REAR_WIND_DOWN = 12;
                ConstAllAirDara.C_REAR_WIND_UP = 13;
                break;
            case FinalCanbus.CAR_454_LZ_TOYOTA_LC300_KycAir /* 6619590 */:
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR_CTRL = 67;
                ConstAllAirDara.U_AIR_SWING = 17;
                ConstAllAirDara.U_AIR_ECO = 52;
                ConstAllAirDara.U_AIR_SOFT = 71;
                ConstAllAirDara.U_AIR_STEER = 66;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 31;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 32;
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
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_REAR_CTRL = 37;
                ConstAllAirDara.C_AIR_SWING = 50;
                ConstAllAirDara.C_AIR_ECO = 59;
                ConstAllAirDara.C_SOFT = 62;
                ConstAllAirDara.C_AIR_STEER = 63;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 96;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 98;
                ConstAllAirDara.C_AIR_LEFT_COLD = 97;
                ConstAllAirDara.C_AIR_RIGHT_COLD = 99;
                ConstAllAirDara.C_CONTRAL = 52;
                break;
            case FinalCanbus.CAR_452_XBS_Nissan_Cedric /* 7143876 */:
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_CLEAN = 76;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_CLEAN = 50;
                ConstAllAirDara.C_CONTRAL = 2;
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
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_WINLEV = 69;
                ConstAllAirDara.U_AIR_STEER = 66;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_AUTO_LEFT = 49;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
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
                ConstAllAirDara.C_AIR_WINLEV = 31;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_452_OD_LandRover_Freelander /* 7799236 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 3;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 13;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 14;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_452_LZ_Volvo /* 7995844 */:
            case FinalCanbus.CAR_452_LZ_Volvo_10 /* 13631940 */:
            case FinalCanbus.CAR_452_LZ_Volvo_15 /* 16515524 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.C_AIR_POWER = 22;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_AUTO = 25;
                ConstAllAirDara.C_AIR_DUAL = 5;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 23;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 24;
                ConstAllAirDara.C_AIR_CYCLE = 26;
                ConstAllAirDara.C_AIR_MODE_UP = 2;
                ConstAllAirDara.C_AIR_MODE_BODY = 3;
                ConstAllAirDara.C_AIR_MODE_FOOT = 4;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 16;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 17;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 18;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 19;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 6;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 7;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_443_WC2_Feiyate_Toro_19_H /* 8192443 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Toro_19_L /* 8257979 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Strada_19_H /* 8323515 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Strada_19_L /* 8389051 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_500x_20_H /* 8454587 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_500x_20_L /* 8520123 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_All_Brazil /* 14090683 */:
                if (DataCanbus.DATA[1000] == 14090683) {
                    ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                    ConstAllAirDara.U_AIR_BACK_TEMP = 27;
                    ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 28;
                    ConstAllAirDara.U_AIR_BACK_POWER = 42;
                    ConstAllAirDara.U_AIR_BACK_BLOW_UP = 18;
                    ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 19;
                    ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 20;
                    ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                    ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                    ConstAllAirDara.C_REAR_OFF = 46;
                    ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 14;
                    ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 13;
                    ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 16;
                    ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 15;
                    ConstAllAirDara.C_REAR_WIND_DOWN = 239;
                    ConstAllAirDara.C_REAR_WIND_UP = 47;
                    ConstAllAirDara.C_REAR_LOCK = 34;
                }
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_STEER = 66;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
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
                ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                ConstAllAirDara.C_AIR_AC_MAX = 21;
                ConstAllAirDara.C_AIR_STEER = 45;
                ConstAllAirDara.C_AIR_MODE_UP = 8;
                ConstAllAirDara.C_AIR_MODE_BODY = 9;
                ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 24;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 23;
                ConstAllAirDara.C_CONTRAL = 5;
                break;
            case FinalCanbus.CAR_453_OD_Ford_PRO_23 /* 8389061 */:
                ConstAllAirDara.TEMPERATURE_NONE = 0;
                ConstAllAirDara.TEMPERATURE_LOW = 36;
                ConstAllAirDara.TEMPERATURE_HIGHT = 64;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
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
                ConstAllAirDara.C_AIR_AC_MAX = 12;
                ConstAllAirDara.C_AIR_CYCLE = 13;
                ConstAllAirDara.C_AIR_MODE_UP = 16;
                ConstAllAirDara.C_AIR_MODE_BODY = 14;
                ConstAllAirDara.C_AIR_MODE_FOOT = 15;
                ConstAllAirDara.C_CONTRAL = 3;
                break;
            case FinalCanbus.CAR_454_OD_Shanqi_Delong_M3000S /* 8520134 */:
            case FinalCanbus.CAR_454_OD_Shanqi_Delong_L5000 /* 8585670 */:
            case FinalCanbus.CAR_454_OD_Shanqi_Delong_M6000 /* 8651206 */:
            case FinalCanbus.CAR_454_OD_Shanqi_Delong_X5000 /* 8716742 */:
            case FinalCanbus.CAR_454_OD_Shanqi_Xuandeyi_6 /* 8782278 */:
            case FinalCanbus.CAR_454_OD_Shanqi_Xuandeyi_9 /* 8847814 */:
            case FinalCanbus.CAR_454_OD_Shanqi_Zhiyun_E2 /* 8913350 */:
            case FinalCanbus.CAR_453_OD_Shanqi_ZHongka /* 15991237 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_454_OD_Shanqi_Delong_X5000 /* 8716742 */:
                        ConstAllAirDara.U_AIR_ECO = 52;
                        ConstAllAirDara.C_AIR_ECO = 32;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 2;
                ConstAllAirDara.C_AIR_AUTO = 16;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_MODE_UP = 8;
                ConstAllAirDara.C_AIR_MODE_BODY = 4;
                ConstAllAirDara.C_AIR_MODE_FOOT = 6;
                ConstAllAirDara.C_AIR_MODE_BODYFOOT = 5;
                ConstAllAirDara.C_AIR_MODE_UPFOOT = 7;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_452_XC_Nissan_Tule_CD /* 8716740 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_REAR_CTRL = 38;
                ConstAllAirDara.U_AIR_BLOWTOP = 72;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 4;
                ConstAllAirDara.C_AIR_DUAL = 8;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 9;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 10;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 11;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 12;
                ConstAllAirDara.C_AIR_AC = 16;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_WIND_ADD = 20;
                ConstAllAirDara.C_AIR_WIND_SUB = 21;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 38;
                ConstAllAirDara.C_AIR_CYCLE = 35;
                ConstAllAirDara.C_AIR_AC_MAX = 39;
                ConstAllAirDara.C_AIR_BLOWTOP = 49;
                ConstAllAirDara.C_REAR_CTRL = 48;
                ConstAllAirDara.C_CONTRAL = 6;
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
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_ION = 58;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_443_WC2_Proton_X70_22 /* 9503163 */:
                    case FinalCanbus.CAR_443_WC2_Proton_X70_22_H /* 9568699 */:
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 30;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 23;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 24;
                        break;
                    case FinalCanbus.CAR_443_WC2_Proton_S70_24 /* 16449979 */:
                    case FinalCanbus.CAR_443_WC2_Proton_S70_24_H /* 16515515 */:
                        ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 30;
                        ConstAllAirDara.U_AIR_ECO = 52;
                        ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                        ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 23;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 24;
                        ConstAllAirDara.C_AIR_ECO = 31;
                        break;
                    case FinalCanbus.CAR_443_WC2_Proton_X90_24 /* 16581051 */:
                    case FinalCanbus.CAR_443_WC2_Proton_X90_24_H /* 16646587 */:
                        ConstAllAirDara.U_AIR_REAR_CTRL = 38;
                        ConstAllAirDara.U_AIR_CLEAN = 76;
                        ConstAllAirDara.U_AIR_SEATWIND_LEFT = 29;
                        ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 30;
                        ConstAllAirDara.U_AIR_ECO = 52;
                        ConstAllAirDara.C_AIR_LEFT_COLD = 23;
                        ConstAllAirDara.C_AIR_RIGHT_COLD = 24;
                        ConstAllAirDara.C_REAR_CTRL = 19;
                        ConstAllAirDara.C_CLEAN = 63;
                        ConstAllAirDara.C_AIR_ECO = 31;
                        break;
                }
                ConstAllAirDara.C_AIR_MODE_CHANGER = 21;
                ConstAllAirDara.C_AIR_MODE_UP = 8;
                ConstAllAirDara.C_AIR_MODE_BODY = 9;
                ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_DUAL = 41;
                ConstAllAirDara.C_AIR_ION = 25;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_AC_MAX = 30;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_452_Oudi_Jianghuai_IEV7 /* 9503172 */:
            case FinalCanbus.CAR_452_Oudi_Jianghuai_IEV7_H /* 9568708 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 18;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_HEAT = 63;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_WIND_ADD = 1;
                ConstAllAirDara.C_AIR_WIND_SUB = 17;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 2;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 18;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 18;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 3;
                ConstAllAirDara.C_AIR_AC = 4;
                ConstAllAirDara.C_AIR_CYCLE = 5;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 7;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_AUTO = 9;
                ConstAllAirDara.C_AIR_HEAT = 10;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_454_OD_Futon_Dajiangjun /* 10551750 */:
            case FinalCanbus.CAR_439_OD_Futon_Tunland /* 16449975 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_AC = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 8;
                ConstAllAirDara.C_AIR_WIND_ADD = 1;
                ConstAllAirDara.C_AIR_WIND_SUB = 2;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 5;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 4;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 4;
                ConstAllAirDara.C_CONTRAL = 1;
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
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AUTO_RIGHT = 26;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_SYNC = 62;
                ConstAllAirDara.U_AIR_AQS = 54;
                ConstAllAirDara.U_AIR_SWING = 17;
                ConstAllAirDara.U_AIR_NANOE = 34;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
                ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BACK_TEMP = 40;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 41;
                ConstAllAirDara.U_AIR_BACK_POWER = 42;
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 43;
                ConstAllAirDara.U_AIR_BACK_AUTO_RIGHT = 81;
                ConstAllAirDara.U_AIR_BACK_BLOW_UP = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 46;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 47;
                ConstAllAirDara.U_AIR_BACK_BLOW_UP_RIGHT = 82;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY_RIGHT = 82;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT_RIGHT = 83;
                ConstAllAirDara.U_AIR_REAR_LOCK = 67;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 44;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_SYNC = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 4;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 5;
                ConstAllAirDara.C_AIR_SWING = 6;
                ConstAllAirDara.C_AIR_AC = 9;
                ConstAllAirDara.C_AIR_AC_MAX = 10;
                ConstAllAirDara.C_AIR_CYCLE = 11;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 18;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 17;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 20;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 19;
                ConstAllAirDara.C_AIR_WIND_ADD = 25;
                ConstAllAirDara.C_AIR_WIND_SUB = 26;
                ConstAllAirDara.C_AIR_AUTO = 102;
                ConstAllAirDara.C_AIR_AUTO_RIGHT = 103;
                ConstAllAirDara.C_AIR_NANOE = 112;
                ConstAllAirDara.C_AIR_AQS = 113;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 34;
                ConstAllAirDara.C_AIR_MODE_CENTER = 33;
                ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT = 37;
                ConstAllAirDara.C_REAR_OFF = 2;
                ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN = 22;
                ConstAllAirDara.C_REAR_LEFT_TEMP_UP = 21;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN = 24;
                ConstAllAirDara.C_REAR_RIGHT_TEMP_UP = 23;
                ConstAllAirDara.C_REAR_WIND_DOWN = 28;
                ConstAllAirDara.C_REAR_WIND_UP = 27;
                ConstAllAirDara.C_REAR_LOCK = 12;
                ConstAllAirDara.C_REAR_AUTO = 104;
                ConstAllAirDara.C_REAR_AUTO_RIGHT = 105;
                ConstAllAirDara.C_REAR_MODE = 40;
                ConstAllAirDara.C_REAR_MODE_RIGHT = 43;
                ConstAllAirDara.C_CONTRAL = 1;
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
                ConstAllAirDara.U_AIR_DUAL = 55;
                ConstAllAirDara.U_AIR_AQS = 54;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_AUTO_LEFT = 49;
                ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 24;
                ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 23;
                ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 22;
                ConstAllAirDara.U_AIR_BLOW_AUTO_RIGHT = 50;
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
                ConstAllAirDara.C_AIR_DUAL = 7;
                ConstAllAirDara.C_AIR_MODE_UP = 16;
                ConstAllAirDara.C_AIR_MODE_BODY = 14;
                ConstAllAirDara.C_AIR_MODE_FOOT = 15;
                ConstAllAirDara.C_AIR_MODE_UP_RIGHT = 19;
                ConstAllAirDara.C_AIR_MODE_BODY_RIGHT = 18;
                ConstAllAirDara.C_AIR_MODE_FOOT_RIGHT = 17;
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
            case FinalCanbus.CAR_453_OD_JMC_Energy_Yizhi_EV3 /* 12648901 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_PTC = 68;
                ConstAllAirDara.U_AIR_AUTO = 13;
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
                ConstAllAirDara.C_AIR_MODE_ADD = 7;
                ConstAllAirDara.C_AIR_MODE_SUB = 8;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_PTC = 26;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_453_OD_Dongfeng_Chenglong_H7 /* 12714437 */:
            case FinalCanbus.CAR_453_OD_Jianghuai_Chaoyue /* 12779973 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                if (DataCanbus.DATA[1000] == 12779973) {
                    ConstAllAirDara.U_AIR_AUTO = 255;
                    ConstAllAirDara.C_AIR_AUTO = 255;
                    ConstAllAirDara.C_AIR_AC_MAX = 22;
                } else {
                    ConstAllAirDara.U_AIR_AUTO = 13;
                    ConstAllAirDara.C_AIR_AUTO = 16;
                    ConstAllAirDara.C_AIR_AC_MAX = 24;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 2;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 3;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 2;
                ConstAllAirDara.C_AIR_MODE_ADD = 7;
                ConstAllAirDara.C_AIR_MODE_SUB = 8;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_453_OD_BQ_BJ30_21 /* 12845509 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_ION = 58;
                ConstAllAirDara.U_AIR_AQS = 54;
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
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_AUTO = 2;
                ConstAllAirDara.C_AIR_DUAL = 3;
                ConstAllAirDara.C_AIR_CYCLE = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 6;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 18;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_ION = 19;
                ConstAllAirDara.C_AIR_AQS = 20;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
            case FinalCanbus.CAR_439_OUDI_Falcon_New_Single /* 13042103 */:
            case FinalCanbus.CAR_439_OUDI_Falcon_New_Double /* 13107639 */:
            case FinalCanbus.CAR_439_OUDI_Territory_New_Single /* 13173175 */:
            case FinalCanbus.CAR_439_OUDI_Territory_New_Double /* 13238711 */:
            case FinalCanbus.CAR_439_OUDI_Territory_Old_Single /* 13304247 */:
            case FinalCanbus.CAR_439_OUDI_Territory_Old_Double /* 13369783 */:
            case FinalCanbus.CAR_439_OUDI_Falcon_Old_Single /* 13435319 */:
            case FinalCanbus.CAR_439_OUDI_Falcon_Old_Double /* 13500855 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_439_OUDI_Falcon_New_Single /* 13042103 */:
                    case FinalCanbus.CAR_439_OUDI_Territory_New_Single /* 13173175 */:
                    case FinalCanbus.CAR_439_OUDI_Territory_Old_Single /* 13304247 */:
                    case FinalCanbus.CAR_439_OUDI_Falcon_Old_Single /* 13435319 */:
                        ConstAllAirDara.U_AIR_AC_MAX = 53;
                        ConstAllAirDara.C_AIR_AC_MAX = 4;
                        ConstAllAirDara.C_AIR_MODE_BODY = 9;
                        ConstAllAirDara.C_AIR_MODE_FOOT = 10;
                        ConstAllAirDara.C_AIR_MODE_BODYFOOT = 34;
                        ConstAllAirDara.C_AIR_MODE_UPFOOT = 35;
                        break;
                    case FinalCanbus.CAR_439_OUDI_Falcon_New_Double /* 13107639 */:
                    case FinalCanbus.CAR_439_OUDI_Territory_New_Double /* 13238711 */:
                    case FinalCanbus.CAR_439_OUDI_Territory_Old_Double /* 13369783 */:
                    case FinalCanbus.CAR_439_OUDI_Falcon_Old_Double /* 13500855 */:
                        ConstAllAirDara.U_AIR_AUTO = 13;
                        ConstAllAirDara.U_AIR_DUAL = 14;
                        ConstAllAirDara.C_AIR_DUAL = 51;
                        ConstAllAirDara.C_AIR_AUTO = 23;
                        ConstAllAirDara.C_AIR_MODE_ADD = 37;
                        ConstAllAirDara.C_AIR_MODE_SUB = 36;
                        break;
                }
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_CYCLE = 3;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 8;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 12;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 14;
                ConstAllAirDara.C_AIR_WIND_ADD = 32;
                ConstAllAirDara.C_AIR_WIND_SUB = 33;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_443_WC2_Jili_GS_18 /* 13631931 */:
            case FinalCanbus.CAR_443_WC2_Jili_GL_18 /* 13697467 */:
            case FinalCanbus.CAR_443_WC2_Jili_Boyue_18 /* 13763003 */:
            case FinalCanbus.CAR_443_WC2_Jili_Boyue_20 /* 13828539 */:
            case FinalCanbus.CAR_443_WC2_Jili_Dihao_22 /* 13894075 */:
            case FinalCanbus.CAR_443_WC2_Jili_Binyue_22 /* 13959611 */:
            case FinalCanbus.CAR_443_WC2_Jili_All /* 14025147 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_ION = 58;
                ConstAllAirDara.U_AIR_AQS = 54;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_DUAL = 41;
                ConstAllAirDara.C_AIR_AUTO = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 5;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 6;
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_AIR_ION = 25;
                ConstAllAirDara.C_AIR_AQS = 88;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 15;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 16;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 17;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 18;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_MODE_ADD = 21;
                ConstAllAirDara.C_AIR_MODE_SUB = 22;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_439_OUDI_Beiqi_EC3 /* 14090679 */:
            case FinalCanbus.CAR_439_OUDI_Beiqi_EC5 /* 14156215 */:
            case FinalCanbus.CAR_439_OUDI_Beiqi_EC180 /* 14221751 */:
            case FinalCanbus.CAR_439_OUDI_Beiqi_EC220 /* 14287287 */:
            case FinalCanbus.CAR_439_OUDI_Beiqi_EU5 /* 14352823 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 18;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_HEAT = 63;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.C_AIR_POWER = 0;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 14;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 13;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 14;
                ConstAllAirDara.C_AIR_AC = 1;
                ConstAllAirDara.C_AIR_CYCLE = 4;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 6;
                ConstAllAirDara.C_AIR_WIND_ADD = 11;
                ConstAllAirDara.C_AIR_WIND_SUB = 12;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 17;
                ConstAllAirDara.C_AIR_HEAT = 18;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_452_OD_Changcheng_Oula /* 14156228 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_ZONE = 57;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_POWER = 16;
                ConstAllAirDara.C_AIR_AC = 17;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 21;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 255;
                ConstAllAirDara.C_AIR_CYCLE = 19;
                ConstAllAirDara.C_AIR_AUTO = 18;
                ConstAllAirDara.C_AIR_ZONE = 20;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 34;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 35;
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
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_L /* 14614971 */:
            case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_M /* 14680507 */:
            case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_H /* 14746043 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_FLOWER_BLOW = 33;
                ConstAllAirDara.U_AIR_PTC = 68;
                ConstAllAirDara.U_AIR_SWING = 17;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
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
                ConstAllAirDara.C_AIR_MODE_CHANGER = 21;
                ConstAllAirDara.C_AIR_SWING = 44;
                ConstAllAirDara.C_AIR_PTC = 48;
                ConstAllAirDara.C_AIR_FLOWER_BLOW = 47;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_453_LZ_Teana_08_L /* 15532485 */:
            case FinalCanbus.CAR_453_LZ_Teana_08_H /* 15598021 */:
            case FinalCanbus.CAR_453_LZ_Teana_08_TW /* 15663557 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_CLEAN = 76;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
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
                ConstAllAirDara.C_AIR_DUAL = 14;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 13;
                ConstAllAirDara.C_CLEAN = 18;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_453_XC_Ford_EDGE_L /* 16122309 */:
            case FinalCanbus.CAR_453_XC_Ford_EDGE_H /* 16187845 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 17;
                ConstAllAirDara.U_AIR_FRONTMAX = 15;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_AC_MAX = 53;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_STEER = 66;
                ConstAllAirDara.U_AIR_SWING = 17;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 37;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_AUTO_LEFT = 49;
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
                ConstAllAirDara.C_AIR_LEFT_HEAT = 11;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 13;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 39;
                ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST = 19;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_AC_MAX = 24;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 36;
                ConstAllAirDara.C_AIR_STEER = 47;
                ConstAllAirDara.C_CONTRAL = 3;
                break;
            case FinalCanbus.CAR_453_OD_Modernin /* 16384453 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_HEAT = 63;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 27;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
                ConstAllAirDara.C_AIR_HEAT = 3;
                ConstAllAirDara.C_AIR_WIND_ADD = 4;
                ConstAllAirDara.C_AIR_WIND_SUB = 5;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 6;
                ConstAllAirDara.C_AIR_TEMP_LEFT_ADD = 7;
                ConstAllAirDara.C_AIR_TEMP_LEFT_SUB = 8;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD = 7;
                ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB = 8;
                ConstAllAirDara.C_AIR_CYCLE = 9;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 10;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 11;
                ConstAllAirDara.C_AIR_AUTO = 12;
                ConstAllAirDara.C_AIR_LEFT_HEAT = 13;
                ConstAllAirDara.C_AIR_RIGHT_HEAT = 14;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
        }
    }

    private void init() {
        if (DataCanbus.DATA[1000] == 15860165 || DataCanbus.DATA[1000] == 2949575) {
            findViewById(R.id.tv_sp_front).setVisibility(0);
            findViewById(R.id.tv_sp_rear).setVisibility(0);
        } else if (ConstAllAirDara.U_AIR_HAVE_REAR == 1) {
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
            findViewById(R.id.air_sp_front).setVisibility(8);
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
            case FinalCanbus.CAR_RZC_HavalF7_20 /* 1376500 */:
            case FinalCanbus.CAR_RZC_HavalF7_19 /* 1507572 */:
            case FinalCanbus.CAR_454_Tangdu_Toyota_LexusIS /* 1835462 */:
            case FinalCanbus.CAR_RZC_XP1_Bingyue_19 /* 2228363 */:
            case FinalCanbus.CAR_RZC_HavalF7_19_Top /* 2228468 */:
            case FinalCanbus.CAR_RZC_XP1_BingyuePro_19 /* 2949259 */:
            case FinalCanbus.CAR_RZC_XP1_Bingyue_21_RS /* 3276939 */:
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
                return false;
            default:
                return true;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        initCallbackId();
        init();
        addUpdater();
        if (IsdisableAirWindow()) {
            AirHelper.disableAirWindowLocal(true);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        if (IsdisableAirWindow()) {
            AirHelper.disableAirWindowLocal(false);
        }
        removeUpdater();
        ConstAllAirDara.JumpNewAir = false;
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
                ((TextView) findViewById(R.id.tv_sp_front)).setTextColor(Color.parseColor("#d5a45e"));
                ((TextView) findViewById(R.id.tv_sp_rear)).setTextColor(Color.parseColor("#ffffff"));
                if (ConstAllAirDara.U_AIR_POWER != 255) {
                    mUpdatePower();
                    break;
                } else {
                    mUpdaterAirWindLevelLeft();
                    break;
                }
            case R.id.tv_sp_rear /* 2131427933 */:
                this.pagenum = 1;
                findViewById(R.id.veiw_air_front).setVisibility(8);
                findViewById(R.id.veiw_air_rear).setVisibility(0);
                ((TextView) findViewById(R.id.tv_sp_front)).setTextColor(Color.parseColor("#ffffff"));
                ((TextView) findViewById(R.id.tv_sp_rear)).setTextColor(Color.parseColor("#d5a45e"));
                if (ConstAllAirDara.U_AIR_BACK_POWER != 255) {
                    mUpdatePower();
                    break;
                } else {
                    mUpdateBackWind();
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
                if (this.pagenum == 1) {
                    data0 = ConstAllAirDara.C_REAR_OFF;
                    break;
                } else {
                    data0 = ConstAllAirDara.C_AIR_POWER;
                    break;
                }
            case R.id.air_sp_wind_minuts /* 2131430281 */:
                data0 = ConstAllAirDara.C_AIR_WIND_SUB;
                break;
            case R.id.air_sp_wind_plus /* 2131430283 */:
                data0 = ConstAllAirDara.C_AIR_WIND_ADD;
                break;
            case R.id.air_sp_cycle /* 2131430284 */:
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_XP1_QiRuiRuiHu7 /* 65940 */:
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
                    case FinalCanbus.CAR_RZC_XP1_20QiRuiRuiHu8 /* 1180052 */:
                    case FinalCanbus.CAR_RZC_DongFeng_Fengxing_S60EVE /* 1310947 */:
                    case FinalCanbus.CAR_RZC_XP1_18JieTU_X70_H /* 1311124 */:
                    case FinalCanbus.CAR_RZC_XP1_20Ruihu_5X /* 1442196 */:
                    case FinalCanbus.CAR_RZC_XP1_21Ruihu_3X /* 1507732 */:
                    case FinalCanbus.CAR_RZC_XP1_21Xiaomayi_EQ1 /* 1638804 */:
                    case FinalCanbus.CAR_RZC_LUZ_18QiRuiRuiHu8 /* 1704340 */:
                    case FinalCanbus.CAR_RZC_OD_18JieTU_X70 /* 1900948 */:
                    case FinalCanbus.CAR_RZC_XP1_22Ruihu_3X /* 2032020 */:
                    case FinalCanbus.CAR_RZC_XP1_23Ruihu_3X /* 2097556 */:
                    case FinalCanbus.CAR_RZC_XP1_22AiRuiZe5 /* 2163092 */:
                    case FinalCanbus.CAR_RZC_QiRui_Guojin_Junxing /* 2228628 */:
                    case FinalCanbus.CAR_RZC_XP1_23Ruihu_5X /* 2294164 */:
                    case FinalCanbus.CAR_OD_RZC_23QiRuiAiRuiZeE /* 2359700 */:
                    case FinalCanbus.CAR_RZC_XP1_23AiRuiZe5 /* 2425236 */:
                    case FinalCanbus.CAR_RZC_XP1_23AiRuiZe5_EV /* 2490772 */:
                    case FinalCanbus.CAR_RZC_XP1_21DR_F35 /* 2556308 */:
                    case FinalCanbus.CAR_OD_RZC_20Showjet /* 2687380 */:
                    case FinalCanbus.CAR_RZC_OD_18JieTU_X70_H /* 2752916 */:
                    case FinalCanbus.CAR_RZC_OD_19JieTU_X90 /* 2818452 */:
                    case FinalCanbus.CAR_RZC_OD_19JieTU_X90_H /* 2883988 */:
                    case FinalCanbus.CAR_453_OD_BQ_BJ30_21 /* 12845509 */:
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            data0 = 5;
                            break;
                        } else {
                            data0 = 4;
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
            case R.id.air_sp_temp_rearleft_plus /* 2131430293 */:
                data0 = ConstAllAirDara.C_REAR_LEFT_TEMP_UP;
                break;
            case R.id.air_sp_temp_rearright_plus /* 2131430302 */:
                data0 = ConstAllAirDara.C_REAR_RIGHT_TEMP_UP;
                break;
            case R.id.air_sp_rearlock_rear /* 2131430307 */:
                data0 = ConstAllAirDara.C_REAR_LOCK;
                break;
            case R.id.air_sp_ac_rear /* 2131430308 */:
                data0 = ConstAllAirDara.C_REAR_AC;
                break;
            case R.id.air_sp_sync_rear /* 2131430309 */:
                data0 = ConstAllAirDara.C_REAR_SYNC;
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
            case R.id.air_sp_em /* 2131430321 */:
                data0 = ConstAllAirDara.C_AIR_EM;
                break;
            case R.id.air_sp_flowerblow /* 2131430327 */:
                data0 = ConstAllAirDara.C_AIR_FLOWER_BLOW;
                break;
            case R.id.air_sp_onlyfront_front /* 2131430329 */:
                data0 = ConstAllAirDara.C_AIR_FRONT_ONLY_F;
                break;
            case R.id.air_sp_airpark /* 2131430331 */:
                data0 = ConstAllAirDara.C_AIR_PARK;
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
            case R.id.air_sp_swing /* 2131430361 */:
                data0 = ConstAllAirDara.C_AIR_SWING;
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
            case R.id.air_sp_blow_mode_minus /* 2131430397 */:
                data0 = ConstAllAirDara.C_AIR_MODE_SUB;
                break;
            case R.id.air_sp_blow_changer_center /* 2131430399 */:
                data0 = ConstAllAirDara.C_AIR_MODE_CENTER;
                break;
            case R.id.air_sp_blow_mode_plus /* 2131430401 */:
                data0 = ConstAllAirDara.C_AIR_MODE_ADD;
                break;
            case R.id.air_sp_blow_changer_right /* 2131430403 */:
                data0 = ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT;
                break;
            case R.id.air_sp_seatwind_left_rear /* 2131430411 */:
                data0 = ConstAllAirDara.C_AIR_LEFT_COLD_REAR;
                break;
            case R.id.air_sp_seatheat_left_rear /* 2131430413 */:
                data0 = ConstAllAirDara.C_AIR_LEFT_HEAT_REAR;
                break;
            case R.id.air_sp_rear_manual /* 2131430416 */:
                data0 = ConstAllAirDara.C_AIR_REAR_MANUAL;
                break;
            case R.id.air_sp_rear_cool /* 2131430418 */:
                data0 = ConstAllAirDara.C_REAR_COOL;
                break;
            case R.id.air_sp_onlyfront /* 2131430420 */:
                data0 = ConstAllAirDara.C_AIR_FRONT_ONLY;
                break;
            case R.id.air_sp_auto_rear_right /* 2131430425 */:
                data0 = ConstAllAirDara.C_REAR_AUTO_RIGHT;
                break;
            case R.id.air_sp_seatheat_right_rear /* 2131430427 */:
                data0 = ConstAllAirDara.C_AIR_RIGHT_HEAT_REAR;
                break;
            case R.id.air_sp_seatwind_right_rear /* 2131430429 */:
                data0 = ConstAllAirDara.C_AIR_RIGHT_COLD_REAR;
                break;
            case R.id.air_sp_temp_rearleft_minus /* 2131430436 */:
                data0 = ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN;
                break;
            case R.id.air_sp_rear_blow_changer /* 2131430446 */:
                data0 = ConstAllAirDara.C_REAR_MODE;
                break;
            case R.id.air_sp_rear_blow_body_foot /* 2131430448 */:
                data0 = ConstAllAirDara.C_REAR_MODE_BODY_FOOT;
                break;
            case R.id.air_sp_rear_blow_foot /* 2131430450 */:
                data0 = ConstAllAirDara.C_REAR_MODE_FOOT;
                break;
            case R.id.air_sp_rear_blow_body /* 2131430452 */:
                data0 = ConstAllAirDara.C_REAR_MODE_BODY;
                break;
            case R.id.air_sp_rear_blow_changer_right /* 2131430454 */:
                data0 = ConstAllAirDara.C_REAR_MODE_RIGHT;
                break;
            case R.id.air_sp_temp_rearright_minus /* 2131430461 */:
                data0 = ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN;
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
        if (DataCanbus.DATA[1000] == 15860165 || DataCanbus.DATA[1000] == 2949575) {
            DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        }
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
    }

    private void removeUpdater() {
        if (DataCanbus.DATA[1000] == 15860165 || DataCanbus.DATA[1000] == 2949575) {
            DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        }
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
    }

    
    public void mUpdateAirHeat() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_HEAT];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_452_RZC_Mangguo_LeiDing /* 13697476 */:
                findViewById(R.id.air_sp_heat).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_ptc_n : R.drawable.ic_hp_ptc_p);
                break;
            default:
                findViewById(R.id.air_sp_heat).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_heat_n : R.drawable.ic_hp_heat_p);
                break;
        }
    }

    
    public void mUpdateAirPTC() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_PTC];
        findViewById(R.id.air_sp_ptc).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_ptc_n : R.drawable.ic_hp_ptc_p);
    }

    
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

    
    public void mUpdateSteerHot() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_STEER];
        findViewById(R.id.air_sp_steer).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_steerhot_n : R.drawable.ic_hp_steerhot_p);
    }

    
    public void mUpdateClean() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_CLEAN];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_XP1_Bingyue_21_RS /* 3276939 */:
                findViewById(R.id.air_sp_clean).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_frontclean_n : R.drawable.ic_hp_frontclean_p);
                break;
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_Q70_16_H /* 6816198 */:
                findViewById(R.id.air_sp_clean).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_forest_n : R.drawable.ic_hp_forest_p);
                break;
            default:
                findViewById(R.id.air_sp_clean).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_clean_n : R.drawable.ic_hp_clean_p);
                break;
        }
    }

    
    public void mUpdateIon() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_ION];
        findViewById(R.id.air_sp_ion).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_ion_n : R.drawable.ic_hp_ion_p);
    }

    
    public void mUpdateBlowTop() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOWTOP];
        findViewById(R.id.air_sp_blowtop).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_blowtop_n : R.drawable.ic_hp_blowtop_p);
    }

    
    public void mUpdateAcMax() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC_MAX];
        findViewById(R.id.air_sp_acmax).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_acmax_n : R.drawable.ic_hp_acmax_p);
    }

    
    public void mUpdateAirNormal() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_NORMAL];
        findViewById(R.id.air_sp_normal).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_normal_n : R.drawable.ic_hp_normal_p);
    }

    
    public void mUpdateAirFast() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_FAST];
        findViewById(R.id.air_sp_fast).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_fast_n : R.drawable.ic_hp_fast_p);
    }

    
    public void mUpdateAirSoft() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SOFT];
        findViewById(R.id.air_sp_soft).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_soft_n : R.drawable.ic_hp_soft_p);
    }

    
    public void mUpdateAirAQS() {
        int i = R.drawable.ic_hp_aqs_n;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_AQS];
        switch (DataCanbus.DATA[1000]) {
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
                switch (vel) {
                    case 0:
                        findViewById(R.id.air_sp_aqs).setBackgroundResource(R.drawable.ic_hp_aqs_n);
                        break;
                    case 1:
                        findViewById(R.id.air_sp_aqs).setBackgroundResource(R.drawable.ic_hp_aqs_p);
                        break;
                    case 2:
                        findViewById(R.id.air_sp_aqs).setBackgroundResource(R.drawable.ic_hp_man_p);
                        break;
                    case 3:
                        findViewById(R.id.air_sp_aqs).setBackgroundResource(R.drawable.ic_hp_man_lock_p);
                        break;
                }
            default:
                View findViewById = findViewById(R.id.air_sp_aqs);
                if (vel != 0) {
                    i = 2130840452;
                }
                findViewById.setBackgroundResource(i);
                break;
        }
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
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        if (temp >= 1 && temp <= 29) {
                            temp = (temp * 5) + 175;
                            break;
                        } else if (temp >= 33 && temp <= 38) {
                            temp = ((temp - 33) * 5) + 150;
                            break;
                        }
                    } else if (temp >= 1 && temp <= 29) {
                        temp = (temp * 10) + 640;
                        break;
                    } else if (temp >= 33 && temp <= 38) {
                        temp = ((temp - 33) * 10) + 590;
                        break;
                    }
                case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15_YC /* 590279 */:
                case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15H_YC /* 655815 */:
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
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 10) + 310;
                        break;
                    } else {
                        temp *= 5;
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
                case FinalCanbus.CAR_453_XP1_ZH2_Ford_Explorer_13_Hand /* 1900997 */:
                case FinalCanbus.CAR_453_XP1_ZH2_Ford_Explorer_13_Auto /* 1966533 */:
                case FinalCanbus.CAR_453_XP1_ZH2_Ford_Explorer_16_Hand /* 2032069 */:
                case FinalCanbus.CAR_453_XP1_ZH2_Ford_Explorer_16_Auto /* 2097605 */:
                case FinalCanbus.CAR_453_XP1_Ford_Edge_2013 /* 4260293 */:
                case FinalCanbus.CAR_453_XP1_Ford_F150_2013 /* 4325829 */:
                case FinalCanbus.CAR_453_XP1_Ford_Explorer_2013 /* 4391365 */:
                case FinalCanbus.CAR_453_XP1_Ford_Taurus_2013 /* 4456901 */:
                case FinalCanbus.CAR_453_XP1_Ford_Expedition_2013 /* 4522437 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mondeo_16 /* 4522438 */:
                case FinalCanbus.CAR_453_XP1_Ford_Edge_2015 /* 4587973 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mondeo_17 /* 4587974 */:
                case FinalCanbus.CAR_453_XP1_Ford_Mustang_2015 /* 4653509 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_16_H /* 4653510 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Taurus_10_H /* 4719046 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_17_Auto /* 4784582 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_14_Auto /* 4850118 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_15 /* 4915654 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_KUGA_15 /* 4981190 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_KUGA_18 /* 5046726 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_FOCUS_15 /* 5112262 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_FOCUS_18 /* 5177798 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_15_H /* 5243334 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_18_H /* 5308870 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_15 /* 5374406 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_18 /* 5439942 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_12_H /* 5505478 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_17 /* 5571014 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_18 /* 5636550 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_15 /* 5702086 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_12_L /* 5767622 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_12_H /* 5833158 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_15_L /* 5898694 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Everest_16 /* 5964230 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Everest_18 /* 6029766 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_16_L /* 6095302 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Taurus_10_L /* 6160838 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_14_Hand /* 6226374 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mondeo_18 /* 6291910 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_17_SYNC3 /* 6357446 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_17_Hand /* 6422982 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_10_Auto /* 6488518 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_10_Hand /* 6554054 */:
                case FinalCanbus.CAR_452_LZ_Ford_Mustang /* 11403716 */:
                case FinalCanbus.CAR_453_XP_Ford_All_RP3_Hand1 /* 13107653 */:
                case FinalCanbus.CAR_453_XP_Ford_All_RP3_Hand2 /* 13173189 */:
                case FinalCanbus.CAR_453_XP_Ford_All_RP3_Auto1 /* 13238725 */:
                case FinalCanbus.CAR_453_XP_Ford_All_RP3_Auto2 /* 13304261 */:
                case FinalCanbus.CAR_452_LZ_Ford_Mustang_H /* 14090692 */:
                case FinalCanbus.CAR_XP1_ZH2_RUIJIE2015 /* 14680516 */:
                    temp *= 10;
                    findViewById(R.id.air_sp_tempvalue_rearleft).setVisibility(8);
                    findViewById(R.id.air_sp_tempunit_rearleft).setVisibility(8);
                    findViewById(R.id.air_sp_tempstate_rearleft).setVisibility(0);
                    mUpdateTempValue(R.id.air_sp_tempstate_rearleft, (temp % 100) / 10, false);
                    break;
                case FinalCanbus.CAR_WC_Toyota_21Sienna /* 1704230 */:
                case FinalCanbus.CAR_RZC_ALL_GM_63 /* 4128829 */:
                case FinalCanbus.CAR_WC2_TOYOTA_21Sienna_H /* 4849958 */:
                case FinalCanbus.CAR_453_LZ_Chrysler_300C_15 /* 5571013 */:
                case FinalCanbus.CAR_453_LZ_Maserati_Levante_18 /* 5636549 */:
                    temp *= 5;
                    break;
                case FinalCanbus.CAR_439_RZC_YinFeiNiDi_QX50 /* 6029751 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX70_13 /* 6685126 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_Q70_16_L /* 6750662 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_Q70_16_H /* 6816198 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_FX50S_09 /* 8389062 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_FX37_13 /* 10224070 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX70_15 /* 10289606 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX37_11 /* 10355142 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_All_Brazil /* 14090683 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 320;
                        break;
                    } else {
                        temp *= 5;
                        break;
                    }
                case FinalCanbus.CAR_452_Xinchi_Dodge_JCUV /* 6226372 */:
                case FinalCanbus.CAR_454_OD_Maserati_Ghibli_14 /* 14025158 */:
                case FinalCanbus.CAR_454_OD_Maserati_Quattroporte_13 /* 14090694 */:
                case FinalCanbus.CAR_439_XC_Feiyate_Feiyue /* 15532471 */:
                    if (temp >= 60 && temp <= 84) {
                        temp *= 10;
                        break;
                    } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 18) + 320;
                        break;
                    } else {
                        temp *= 10;
                        break;
                    }
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
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp *= 10;
                        break;
                    } else {
                        temp *= 5;
                        break;
                    }
            }
            mUpdateTempValue(R.id.air_sp_temp_rearleft1, temp / 100, false);
            mUpdateTempValue(R.id.air_sp_temp_rearleft2, (temp % 100) / 10, false);
            mUpdateTempValue(R.id.air_sp_temp_rearleft3, temp % 10, true);
            mUpdateTempUNIT();
        }
    }

    
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
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        if (temp >= 1 && temp <= 29) {
                            temp = (temp * 5) + 175;
                            break;
                        } else if (temp >= 33 && temp <= 38) {
                            temp = ((temp - 33) * 5) + 150;
                            break;
                        }
                    } else if (temp >= 1 && temp <= 29) {
                        temp = (temp * 10) + 640;
                        break;
                    } else if (temp >= 33 && temp <= 38) {
                        temp = ((temp - 33) * 10) + 590;
                        break;
                    }
                case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15_YC /* 590279 */:
                case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15H_YC /* 655815 */:
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
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 10) + 310;
                        break;
                    } else {
                        temp *= 5;
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
                case FinalCanbus.CAR_453_XP1_ZH2_Ford_Explorer_13_Hand /* 1900997 */:
                case FinalCanbus.CAR_453_XP1_ZH2_Ford_Explorer_13_Auto /* 1966533 */:
                case FinalCanbus.CAR_453_XP1_ZH2_Ford_Explorer_16_Hand /* 2032069 */:
                case FinalCanbus.CAR_453_XP1_ZH2_Ford_Explorer_16_Auto /* 2097605 */:
                case FinalCanbus.CAR_453_XP1_Ford_Edge_2013 /* 4260293 */:
                case FinalCanbus.CAR_453_XP1_Ford_F150_2013 /* 4325829 */:
                case FinalCanbus.CAR_453_XP1_Ford_Explorer_2013 /* 4391365 */:
                case FinalCanbus.CAR_453_XP1_Ford_Taurus_2013 /* 4456901 */:
                case FinalCanbus.CAR_453_XP1_Ford_Expedition_2013 /* 4522437 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mondeo_16 /* 4522438 */:
                case FinalCanbus.CAR_453_XP1_Ford_Edge_2015 /* 4587973 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mondeo_17 /* 4587974 */:
                case FinalCanbus.CAR_453_XP1_Ford_Mustang_2015 /* 4653509 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_16_H /* 4653510 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Taurus_10_H /* 4719046 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_17_Auto /* 4784582 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_14_Auto /* 4850118 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_15 /* 4915654 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_KUGA_15 /* 4981190 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_KUGA_18 /* 5046726 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_FOCUS_15 /* 5112262 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_FOCUS_18 /* 5177798 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_15_H /* 5243334 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_18_H /* 5308870 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_15 /* 5374406 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_18 /* 5439942 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_12_H /* 5505478 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_17 /* 5571014 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_18 /* 5636550 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_15 /* 5702086 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_12_L /* 5767622 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_12_H /* 5833158 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_15_L /* 5898694 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Everest_16 /* 5964230 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Everest_18 /* 6029766 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_16_L /* 6095302 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Taurus_10_L /* 6160838 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_14_Hand /* 6226374 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mondeo_18 /* 6291910 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_17_SYNC3 /* 6357446 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_17_Hand /* 6422982 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_10_Auto /* 6488518 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_10_Hand /* 6554054 */:
                case FinalCanbus.CAR_452_LZ_Ford_Mustang /* 11403716 */:
                case FinalCanbus.CAR_453_XP_Ford_All_RP3_Hand1 /* 13107653 */:
                case FinalCanbus.CAR_453_XP_Ford_All_RP3_Hand2 /* 13173189 */:
                case FinalCanbus.CAR_453_XP_Ford_All_RP3_Auto1 /* 13238725 */:
                case FinalCanbus.CAR_453_XP_Ford_All_RP3_Auto2 /* 13304261 */:
                case FinalCanbus.CAR_452_LZ_Ford_Mustang_H /* 14090692 */:
                case FinalCanbus.CAR_XP1_ZH2_RUIJIE2015 /* 14680516 */:
                    temp *= 10;
                    findViewById(R.id.air_sp_tempvalue_rearright).setVisibility(8);
                    findViewById(R.id.air_sp_tempunit_rearright).setVisibility(8);
                    findViewById(R.id.air_sp_tempstate_rearright).setVisibility(0);
                    mUpdateTempValue(R.id.air_sp_tempstate_rearright, (temp % 100) / 10, false);
                    break;
                case FinalCanbus.CAR_WC_Toyota_21Sienna /* 1704230 */:
                case FinalCanbus.CAR_RZC_ALL_GM_63 /* 4128829 */:
                case FinalCanbus.CAR_WC2_TOYOTA_21Sienna_H /* 4849958 */:
                case FinalCanbus.CAR_453_LZ_Chrysler_300C_15 /* 5571013 */:
                case FinalCanbus.CAR_453_LZ_Maserati_Levante_18 /* 5636549 */:
                    temp *= 5;
                    break;
                case FinalCanbus.CAR_439_RZC_YinFeiNiDi_QX50 /* 6029751 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX70_13 /* 6685126 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_Q70_16_L /* 6750662 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_Q70_16_H /* 6816198 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_FX50S_09 /* 8389062 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_FX37_13 /* 10224070 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX70_15 /* 10289606 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX37_11 /* 10355142 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_All_Brazil /* 14090683 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 320;
                        break;
                    } else {
                        temp *= 5;
                        break;
                    }
                case FinalCanbus.CAR_452_Xinchi_Dodge_JCUV /* 6226372 */:
                case FinalCanbus.CAR_454_OD_Maserati_Ghibli_14 /* 14025158 */:
                case FinalCanbus.CAR_454_OD_Maserati_Quattroporte_13 /* 14090694 */:
                case FinalCanbus.CAR_439_XC_Feiyate_Feiyue /* 15532471 */:
                    if (temp >= 60 && temp <= 84) {
                        temp *= 10;
                        break;
                    } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 18) + 320;
                        break;
                    } else {
                        temp *= 10;
                        break;
                    }
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
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp *= 10;
                        break;
                    } else {
                        temp *= 5;
                        break;
                    }
            }
            mUpdateTempValue(R.id.air_sp_temp_rearright1, temp / 100, false);
            mUpdateTempValue(R.id.air_sp_temp_rearright2, (temp % 100) / 10, false);
            mUpdateTempValue(R.id.air_sp_temp_rearright3, temp % 10, true);
            mUpdateTempUNIT();
        }
    }

    
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
                case 21:
                case 416:
                case FinalCanbus.CAR_WC2_MengDiOuZS2013_M /* 65557 */:
                case FinalCanbus.CAR_WC2_17MingJue6 /* 65952 */:
                case FinalCanbus.CAR_WC2_MengDiOuZS2013_H /* 131093 */:
                case FinalCanbus.CAR_WC2_RongWei_I5 /* 131488 */:
                case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL /* 196629 */:
                case FinalCanbus.CAR_WC2_RongWei_I6 /* 197024 */:
                case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL_M /* 262165 */:
                case FinalCanbus.CAR_WC2_CHANGAN_19KeSai /* 262272 */:
                case FinalCanbus.CAR_WC2_RongWei_EI6 /* 262560 */:
                case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL_H /* 327701 */:
                case FinalCanbus.CAR_WC2_RongWei_RX3 /* 328096 */:
                case FinalCanbus.CAR_WC2_18Ecosport /* 393237 */:
                case FinalCanbus.CAR_WC2_RongWei_HS /* 393632 */:
                case FinalCanbus.CAR_WC2_MengDiOuZS2018 /* 458773 */:
                case FinalCanbus.CAR_WC2_RongWei_I5_H /* 459168 */:
                case FinalCanbus.CAR_WC2_MengDiOuZS2021 /* 524309 */:
                case FinalCanbus.CAR_CZH_WC2_MengDiOuZS2013_M /* 589845 */:
                case FinalCanbus.CAR_WC2_20Oushang_X7_H /* 655488 */:
                case FinalCanbus.CAR_WC2_19ChangAn_CS35_PLUS /* 721024 */:
                case FinalCanbus.CAR_443_WC2_Tianlai08_12 /* 1180091 */:
                case FinalCanbus.CAR_455_LZ_Ford_Mustang_L_CYT /* 1245639 */:
                case FinalCanbus.CAR_WC2_BeiQi_M50F /* 1311115 */:
                case FinalCanbus.CAR_455_LZ_Ford_Mustang_H_CYT /* 1311175 */:
                case FinalCanbus.CAR_455_LZ_Ford_Mustang_RH_CYT /* 1376711 */:
                case FinalCanbus.CAR_455_LZ_Ford_Mustang_RL_CYT /* 1442247 */:
                case FinalCanbus.CAR_443_WC2_Nissan_Ruiqi /* 1704379 */:
                case FinalCanbus.CAR_444_WC2_Dongfeng_Xiaokang_Ix5 /* 1835452 */:
                case FinalCanbus.CAR_453_OD_Jiangling_Kaiyun_H /* 1835461 */:
                case FinalCanbus.CAR_WC2_JieTu_X70_22 /* 2294155 */:
                case FinalCanbus.CAR_WC2_JieTu_X70_22_H /* 2359691 */:
                case FinalCanbus.CAR_454_LZ_Ford_F150_15_L /* 3932614 */:
                case FinalCanbus.CAR_454_LZ_Ford_F150_15_H /* 3998150 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mondeo_16 /* 4522438 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mondeo_17 /* 4587974 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_16_H /* 4653510 */:
                case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD /* 4719035 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Taurus_10_H /* 4719046 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_17_Auto /* 4784582 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_14_Auto /* 4850118 */:
                case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD_HW /* 4915643 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_15 /* 4915654 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_KUGA_15 /* 4981190 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_KUGA_18 /* 5046726 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_FOCUS_15 /* 5112262 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_FOCUS_18 /* 5177798 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_15_H /* 5243334 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_18_H /* 5308870 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_15 /* 5374406 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_18 /* 5439942 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_12_H /* 5505478 */:
                case FinalCanbus.CAR_453_LZ_Chrysler_300C_15 /* 5571013 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_17 /* 5571014 */:
                case FinalCanbus.CAR_453_LZ_Maserati_Levante_18 /* 5636549 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_18 /* 5636550 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_15 /* 5702086 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_12_L /* 5767622 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_12_H /* 5833158 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_15_L /* 5898694 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Everest_16 /* 5964230 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Everest_18 /* 6029766 */:
                case FinalCanbus.CAR_452_OD_Nissan_Tule_low /* 6095300 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_16_L /* 6095302 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Taurus_10_L /* 6160838 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_14_Hand /* 6226374 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mondeo_18 /* 6291910 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_17_SYNC3 /* 6357446 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_17_Hand /* 6422982 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_10_Auto /* 6488518 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_10_Hand /* 6554054 */:
                case FinalCanbus.CAR_452_XBS_Nissan_Cedric /* 7143876 */:
                case FinalCanbus.CAR_443_WC_OPEL_Astra_04 /* 7274939 */:
                case FinalCanbus.CAR_443_WC_OPEL_Zafira_05 /* 7340475 */:
                case FinalCanbus.CAR_443_WC_OPEL_Antara_06 /* 7406011 */:
                case FinalCanbus.CAR_443_WC_OPEL_Vectra_02 /* 7471547 */:
                case FinalCanbus.CAR_443_WC_OPEL_Corsa_06 /* 7537083 */:
                case FinalCanbus.CAR_443_WC_OPEL_Meriva_03 /* 7602619 */:
                case FinalCanbus.CAR_443_WC2_Nissan_Ruiqi7 /* 7799227 */:
                case FinalCanbus.CAR_452_OD_LandRover_Freelander /* 7799236 */:
                case FinalCanbus.CAR_453_OD_Ford_PRO_23 /* 8389061 */:
                case FinalCanbus.CAR_452_XC_Nissan_Tule_CD /* 8716740 */:
                case FinalCanbus.CAR_443_WC2_Proton_X50_22 /* 9306555 */:
                case FinalCanbus.CAR_443_WC2_Proton_X50_22_H /* 9372091 */:
                case FinalCanbus.CAR_443_WC2_Proton_Persona_22 /* 9437627 */:
                case FinalCanbus.CAR_443_WC2_Proton_X70_22 /* 9503163 */:
                case FinalCanbus.CAR_452_Oudi_Jianghuai_IEV7 /* 9503172 */:
                case FinalCanbus.CAR_443_WC2_Proton_X70_22_H /* 9568699 */:
                case FinalCanbus.CAR_452_Oudi_Jianghuai_IEV7_H /* 9568708 */:
                case FinalCanbus.CAR_443_WC_OPEL_Astra_04_H /* 10420667 */:
                case FinalCanbus.CAR_443_WC_OPEL_Zafira_05_H /* 10486203 */:
                case FinalCanbus.CAR_443_WC_OPEL_Antara_06_H /* 10551739 */:
                case FinalCanbus.CAR_443_WC_OPEL_Vectra_02_H /* 10617275 */:
                case FinalCanbus.CAR_443_WC_OPEL_Corsa_06_H /* 10682811 */:
                case FinalCanbus.CAR_443_WC_OPEL_Meriva_03_H /* 10748347 */:
                case FinalCanbus.CAR_453_OD_BQ_BJ30_21 /* 12845509 */:
                case FinalCanbus.CAR_439_OUDI_Falcon_New_Single /* 13042103 */:
                case FinalCanbus.CAR_439_OUDI_Falcon_New_Double /* 13107639 */:
                case FinalCanbus.CAR_439_OUDI_Territory_New_Single /* 13173175 */:
                case FinalCanbus.CAR_439_OUDI_Territory_New_Double /* 13238711 */:
                case FinalCanbus.CAR_439_OUDI_Territory_Old_Single /* 13304247 */:
                case FinalCanbus.CAR_439_OUDI_Territory_Old_Double /* 13369783 */:
                case FinalCanbus.CAR_439_OUDI_Falcon_Old_Single /* 13435319 */:
                case FinalCanbus.CAR_439_OUDI_Falcon_Old_Double /* 13500855 */:
                case FinalCanbus.CAR_443_WC2_Jili_GS_18 /* 13631931 */:
                case FinalCanbus.CAR_443_WC2_Jili_GL_18 /* 13697467 */:
                case FinalCanbus.CAR_443_WC2_Jili_Boyue_18 /* 13763003 */:
                case FinalCanbus.CAR_443_WC2_Jili_Boyue_20 /* 13828539 */:
                case FinalCanbus.CAR_443_WC2_Jili_Dihao_22 /* 13894075 */:
                case FinalCanbus.CAR_443_WC2_Jili_Binyue_22 /* 13959611 */:
                case FinalCanbus.CAR_443_WC2_Jili_All /* 14025147 */:
                case FinalCanbus.CAR_454_OD_Jiangling_Dadao /* 14483910 */:
                case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_L /* 14614971 */:
                case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_M /* 14680507 */:
                case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_H /* 14746043 */:
                case FinalCanbus.CAR_443_WC2_Proton_S70_24 /* 16449979 */:
                case FinalCanbus.CAR_443_WC2_Proton_S70_24_H /* 16515515 */:
                case FinalCanbus.CAR_443_WC2_Proton_X90_24 /* 16581051 */:
                case FinalCanbus.CAR_443_WC2_Proton_X90_24_H /* 16646587 */:
                    temp *= 5;
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
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp *= 10;
                        break;
                    }
                case 61:
                case FinalCanbus.CAR_RZC_XP1_GM_1 /* 65597 */:
                case FinalCanbus.CAR_RZC_XP1_GM_2 /* 131133 */:
                case FinalCanbus.CAR_RZC_XP1_GM_3 /* 196669 */:
                case FinalCanbus.CAR_RZC_XP1_GM_4 /* 262205 */:
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
                case FinalCanbus.CAR_RZC_ALL_GM_08_10AstraH /* 3866685 */:
                case FinalCanbus.CAR_RZC_ALL_GM_11CorsaD /* 3932221 */:
                case FinalCanbus.CAR_RZC_ALL_GM_08Combo /* 3997757 */:
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
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = ((temp - 160) / 5) + 600;
                        break;
                    } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = ((temp * 9) / 5) + 320;
                        break;
                    }
                case 163:
                case 339:
                case 374:
                case FinalCanbus.CAR_RZC4_PSA14_308_16 /* 65699 */:
                case FinalCanbus.CAR_RZC4_PSA_4008 /* 65875 */:
                case FinalCanbus.CAR_XP1_ZiYouGuang_H /* 65910 */:
                case FinalCanbus.CAR_RZC4_PSA14_408_M /* 131235 */:
                case FinalCanbus.CAR_RZC4_PSA_19_C4L /* 131411 */:
                case FinalCanbus.CAR_RZC4_PSA14_408_H /* 196771 */:
                case FinalCanbus.CAR_RZC4_PSA_19_508 /* 196947 */:
                case FinalCanbus.CAR_XP1_17ZhiNanZhe /* 196982 */:
                case FinalCanbus.CAR_RZC4_PSA_19_C3_XR_L /* 262483 */:
                case FinalCanbus.CAR_XP1_17ZhiNanZhe_H /* 262518 */:
                case FinalCanbus.CAR_RZC4_PSA_19_C3_XR_M /* 328019 */:
                case FinalCanbus.CAR_RZC4_PSA_19_C3_XR_H /* 393555 */:
                case FinalCanbus.CAR_RZC4_PSA_ALL_M /* 459091 */:
                case FinalCanbus.CAR_RZC4_PSA_ALL_H /* 524627 */:
                case FinalCanbus.CAR_RZC4_PSA_17_3008 /* 721235 */:
                case FinalCanbus.CAR_XP1_18ZiYouXia /* 721270 */:
                case FinalCanbus.CAR_RZC4_PSA_17_3008_M /* 786771 */:
                case FinalCanbus.CAR_XP1_Cherokee /* 786806 */:
                case FinalCanbus.CAR_RZC4_PSA_17_3008_H /* 852307 */:
                case FinalCanbus.CAR_XP1_Cherokee_H /* 852342 */:
                case FinalCanbus.CAR_RZC4_PSA_14_2008 /* 917843 */:
                case FinalCanbus.CAR_BNR_XP1_ZiYouGuang /* 917878 */:
                case FinalCanbus.CAR_RZC4_PSA_14_2008_M /* 983379 */:
                case FinalCanbus.CAR_BNR_XP1_ZiYouGuang_H /* 983414 */:
                case FinalCanbus.CAR_RZC4_PSA_14_2008_H /* 1048915 */:
                case FinalCanbus.CAR_BNR_XP1_17ZhiNanZhe /* 1114486 */:
                case FinalCanbus.CAR_BNR_XP1_17ZhiNanZhe_H /* 1180022 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand /* 1311174 */:
                case FinalCanbus.CAR_RZC4_PSA_17_5008 /* 1376595 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto /* 1376710 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand /* 1442246 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto /* 1507782 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand_S /* 1573318 */:
                case FinalCanbus.CAR_RZC4_PSA_04_407 /* 1638739 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto_S /* 1638854 */:
                case FinalCanbus.CAR_RZC4_PSA_04_407_CD /* 1704275 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand_S /* 1704390 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto_S /* 1769926 */:
                case FinalCanbus.CAR_RZC4_PSA_ALL_NoAir_L /* 2031955 */:
                case FinalCanbus.CAR_RZC4_PSA_ALL_NoAir_M /* 2097491 */:
                case FinalCanbus.CAR_RZC4_PSA_ALL_NoAir_H /* 2163027 */:
                case FinalCanbus.CAR_RZC4_PSA_C4_OE_L /* 2228563 */:
                case FinalCanbus.CAR_RZC4_PSA_C4_OE_M /* 2294099 */:
                case FinalCanbus.CAR_RZC4_PSA_C4_OE_H /* 2359635 */:
                case FinalCanbus.CAR_XP1_RAM1500_H_AUTO /* 4194678 */:
                case FinalCanbus.CAR_RZC_HONDA_23Yage /* 4260138 */:
                case FinalCanbus.CAR_CZH_RZC_HONDA_Civic /* 5636394 */:
                case FinalCanbus.CAR_CZH_RZC_HONDA_10Yage /* 5701930 */:
                case FinalCanbus.CAR_CZH_RZC_HONDA_Haoying /* 5767466 */:
                case FinalCanbus.CAR_CZH_RZC_HONDA_CRV /* 5833002 */:
                case FinalCanbus.CAR_452_LZ_Ford_Mustang /* 11403716 */:
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
                case FinalCanbus.CAR_452_LZ_Ford_Mustang_H /* 14090692 */:
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
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        temp *= 5;
                        break;
                    } else {
                        temp *= 10;
                        break;
                    }
                case 223:
                    temp = (temp * 5) - 400;
                    break;
                case 443:
                case FinalCanbus.CAR_452_LZ_Ferrari_430 /* 2556357 */:
                case FinalCanbus.CAR_439_RZC_YinFeiNiDi_QX50 /* 6029751 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX70_13 /* 6685126 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_Q70_16_L /* 6750662 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_Q70_16_H /* 6816198 */:
                case FinalCanbus.CAR_443_WC2_OULANDE_H /* 7012795 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_Toro_19_H /* 8192443 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_Toro_19_L /* 8257979 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_Strada_19_H /* 8323515 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_Strada_19_L /* 8389051 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_FX50S_09 /* 8389062 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_500x_20_H /* 8454587 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_500x_20_L /* 8520123 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_FX37_13 /* 10224070 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX70_15 /* 10289606 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX37_11 /* 10355142 */:
                case FinalCanbus.CAR_452_LZ_Maserati_SP /* 12255684 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_All_Brazil /* 14090683 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 320;
                        break;
                    } else {
                        temp *= 5;
                        break;
                    }
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
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        if (temp >= 1 && temp <= 29) {
                            temp = (temp * 5) + 175;
                            break;
                        } else if (temp >= 33 && temp <= 38) {
                            temp = ((temp - 33) * 5) + 150;
                            break;
                        }
                    } else if (temp >= 1 && temp <= 29) {
                        temp = (temp * 10) + 640;
                        break;
                    } else if (temp >= 33 && temp <= 38) {
                        temp = ((temp - 33) * 10) + 590;
                        break;
                    }
                case FinalCanbus.CAR_RZC_XP1_YuanJingX6 /* 131211 */:
                case FinalCanbus.CAR_RZC_XP1_YuanJingX1 /* 196747 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_GS /* 589963 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_GL /* 655499 */:
                case FinalCanbus.CAR_RZC_XP1_18YuanJingSUV /* 721035 */:
                case FinalCanbus.CAR_RZC_XP1_Borui /* 786571 */:
                case FinalCanbus.CAR_RZC_XP1_18YuanJingSUV_H /* 852107 */:
                case FinalCanbus.CAR_RZC_XP1_16YuanJingSUV /* 917643 */:
                case FinalCanbus.CAR_RZC_XP1_16YuanJingSUV_H /* 983179 */:
                case FinalCanbus.CAR_RZC_XP1_18YuanJing /* 1114251 */:
                case FinalCanbus.CAR_RZC_BoYue /* 1179787 */:
                case FinalCanbus.CAR_RZC_BoYue_H /* 1245323 */:
                case FinalCanbus.CAR_RZC_Jili_19Dihao /* 1310859 */:
                case FinalCanbus.CAR_RZC_Jili_19Dihao_GL_E /* 1441931 */:
                case FinalCanbus.CAR_RZC_Jili_18Dihao /* 1507467 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_GS_18 /* 1573003 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_GL_16 /* 1638539 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_S1_18 /* 1704075 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_GS_19 /* 1769611 */:
                case FinalCanbus.CAR_RZC_XP1_YuanJingX3_19_20 /* 1835147 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_GL_19 /* 1966219 */:
                case FinalCanbus.CAR_RZC_XP1_20YuanJingSUV /* 2031755 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_GL_20 /* 2097291 */:
                case FinalCanbus.CAR_RZC_XP1_Boyue_Pro_20 /* 2162827 */:
                case FinalCanbus.CAR_RZC_XP1_Bingyue_19 /* 2228363 */:
                case FinalCanbus.CAR_455_OD_Jilie_JiheA /* 2228679 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_GS_20 /* 2293899 */:
                case FinalCanbus.CAR_RZC_XP1_Jiaji_21 /* 2424971 */:
                case FinalCanbus.CAR_452_OD_Ruilan_X3_Pro /* 2425285 */:
                case FinalCanbus.CAR_RZC_XP1_Binrui_20 /* 2490507 */:
                case FinalCanbus.CAR_452_OD_Jihe_EX3 /* 2490821 */:
                case FinalCanbus.CAR_RZC_XP1_Haoyue_20 /* 2556043 */:
                case FinalCanbus.CAR_RZC_XP1_Dihaoe_22 /* 2621579 */:
                case FinalCanbus.CAR_RZC_XP1_Xingrui_22 /* 2687115 */:
                case FinalCanbus.CAR_RZC_BoYue_21 /* 2752651 */:
                case FinalCanbus.CAR_RZC_Xiongmao_Mini_23 /* 2818187 */:
                case FinalCanbus.CAR_RZC_Jili_TX5 /* 2883723 */:
                case FinalCanbus.CAR_RZC_XP1_BingyuePro_19 /* 2949259 */:
                case FinalCanbus.CAR_RZC_Jili_15YuanJing /* 3014795 */:
                case FinalCanbus.CAR_OuDi_XP1_Borui_18 /* 3080331 */:
                case FinalCanbus.CAR_OuDi_XP1_Borui_18_L /* 3145867 */:
                case FinalCanbus.CAR_Oudi_Jili_Binyue_Pro /* 3211403 */:
                case FinalCanbus.CAR_RZC_XP1_Bingyue_21_RS /* 3276939 */:
                case FinalCanbus.CAR_RZC_XP1_Dihao_23 /* 3342475 */:
                case FinalCanbus.CAR_453_OD_Jili_Panda_Mini /* 8454597 */:
                case FinalCanbus.CAR_454_OD_Jilie_DihaoS /* 14156230 */:
                case FinalCanbus.CAR_454_OD_Jilie_YuanchengXingzhi /* 14549446 */:
                case FinalCanbus.CAR_453_OD_Jili_Dihao_EV /* 16056773 */:
                    if (temp >= 32 && temp <= 34) {
                        temp = ((temp - 32) * 5) + 160;
                        break;
                    } else {
                        temp = (temp * 5) + 170;
                        break;
                    }
                case FinalCanbus.CAR_WC_17Haval_H2S /* 196740 */:
                case FinalCanbus.CAR_RZC_HavalLow_H2S_HongBiao /* 393460 */:
                case FinalCanbus.CAR_RZC_HavalLow_H2S_LanBiao /* 721140 */:
                case FinalCanbus.CAR_WC2_BeiQi_EV300_18 /* 2228619 */:
                    temp *= 10;
                    findViewById(R.id.air_sp_tempvalue_left).setVisibility(8);
                    findViewById(R.id.air_sp_tempunit_left).setVisibility(8);
                    findViewById(R.id.air_sp_tempstate_left).setVisibility(0);
                    mUpdateTempValue(R.id.air_sp_tempstate_left, (temp % 100) / 10, false);
                    break;
                case FinalCanbus.CAR_Oudi_XP1_FengGuang17Y580 /* 196922 */:
                case FinalCanbus.CAR_RZC_Jiangxi_FengguangS560_21 /* 1179962 */:
                case FinalCanbus.CAR_RZC_DongFeng_Fengxing_S60EVE /* 1310947 */:
                case FinalCanbus.CAR_Oudi_XP1_FengGuang17Y560 /* 1507642 */:
                case FinalCanbus.CAR_Oudi_XP1_FengGuang17S560 /* 1638714 */:
                case FinalCanbus.CAR_454_OD_Jianghuai_SEHOL_E50A /* 2490822 */:
                case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5 /* 2818501 */:
                case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5_H /* 2884037 */:
                case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5 /* 3015109 */:
                case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5_H /* 3080645 */:
                case FinalCanbus.CAR_454_OD_Jianghuai_IC5 /* 15270342 */:
                    temp *= 10;
                    break;
                case FinalCanbus.CAR_453_OD_Chuangwei_EV /* 197061 */:
                case FinalCanbus.CAR_452_RZC_ZHongtai_E200_18 /* 852420 */:
                case FinalCanbus.CAR_439_RZC_ZhongTaiT500 /* 2163127 */:
                case FinalCanbus.CAR_439_RZC_ZhongTaiT300 /* 2228663 */:
                case FinalCanbus.CAR_439_RZC_ZhongTaiSR9 /* 2294199 */:
                case FinalCanbus.CAR_439_RZC_ZhongTaiSR9_H /* 2359735 */:
                case FinalCanbus.CAR_455_OD_ChangAn_CS95_H /* 3277255 */:
                case FinalCanbus.CAR_453_RZC_Changan_CS15_EPro_21 /* 3473861 */:
                case FinalCanbus.CAR_452_OD_WeiCai_U70_20 /* 3736004 */:
                case FinalCanbus.CAR_439_XBS_09Tianlai /* 4063671 */:
                case FinalCanbus.CAR_452_RZC_ChangAn_19OuShang /* 4719044 */:
                case FinalCanbus.CAR_439_RZC_ChangAn_OUSAN_KESAI /* 7471543 */:
                case FinalCanbus.CAR_439_RZC_ZhongTaiSR7 /* 7537079 */:
                case FinalCanbus.CAR_439_OD_ChangAn_CS95 /* 7930295 */:
                case FinalCanbus.CAR_439_RZC_19yema_Bojun /* 8520119 */:
                case FinalCanbus.CAR_453_RZC_Chuangwei_EV /* 8651205 */:
                case FinalCanbus.CAR_452_RZC_ChangAn_KESAI_Pro_21 /* 11010500 */:
                case FinalCanbus.CAR_454_OD_WeiCai_EHPro_24 /* 11469254 */:
                case FinalCanbus.CAR_452_RZC_Mangguo_LeiDing /* 13697476 */:
                case FinalCanbus.CAR_RZC_ZhongTaiDaMaiX7 /* 14614967 */:
                    temp = (temp * 5) + 175;
                    break;
                case FinalCanbus.CAR_WC2_CHANGAN_19KeSai_Hand /* 327808 */:
                case FinalCanbus.CAR_WC2_19Oushang_A800 /* 458880 */:
                    temp = (temp * 10) + 150;
                    break;
                case FinalCanbus.CAR_RZC_FengGuang18Y580 /* 393530 */:
                case FinalCanbus.CAR_RZC_FengGuang18Y580_H /* 459066 */:
                case FinalCanbus.CAR_RZC_DongFengYiZhi_19EV3 /* 524602 */:
                case FinalCanbus.CAR_RZC_Jiangxi_Wushiling_Mux /* 852282 */:
                case FinalCanbus.CAR_RZC_FengGuang21Y580 /* 1245498 */:
                case FinalCanbus.CAR_RZC_FengGuang21Y580_H /* 1311034 */:
                case FinalCanbus.CAR_RZC_FengGuang_580Pro_20 /* 1835322 */:
                case FinalCanbus.CAR_RZC_FengGuang_580Pro_20_H /* 1900858 */:
                    temp = ((temp - 124) * 5) + 160;
                    break;
                case FinalCanbus.CAR_RZC_BeiQi_19EC5 /* 458979 */:
                    temp = (temp * 20) + 140;
                    break;
                case FinalCanbus.CAR_RZC_XP1_HavalH6 /* 458996 */:
                case FinalCanbus.CAR_RZC_XP1_HavalH6_16HuanDai /* 852212 */:
                case FinalCanbus.CAR_RZC_XP1_HavalH6Couple_16_top /* 983284 */:
                case FinalCanbus.CAR_RZC_HavalLow_Changchengpao_19 /* 1114356 */:
                case FinalCanbus.CAR_RZC_HavalH4_20 /* 1245428 */:
                case FinalCanbus.CAR_RZC_HavalH7_19 /* 1310964 */:
                case FinalCanbus.CAR_RZC_HavalF7_20 /* 1376500 */:
                case FinalCanbus.CAR_RZC_HavalH4_20_H /* 1442036 */:
                case FinalCanbus.CAR_RZC_HavalF7_19 /* 1507572 */:
                case FinalCanbus.CAR_RZC_XP1_HavalH6_H /* 1573108 */:
                case FinalCanbus.CAR_RZC_HavalH7_19_H /* 1638644 */:
                case FinalCanbus.CAR_RZC_HavalH7_19_NoAmp /* 1704180 */:
                case FinalCanbus.CAR_RZC_HavalH7_19_H_NoAmp /* 1769716 */:
                case FinalCanbus.CAR_RZC_Haval_Fengjun5_21 /* 1900788 */:
                case FinalCanbus.CAR_RZC_Haval_H3_05 /* 1966324 */:
                case FinalCanbus.CAR_RZC_Haval_Jinggangpao_22 /* 2031860 */:
                case FinalCanbus.CAR_RZC_Haval_H7Hongbiao_18 /* 2097396 */:
                case FinalCanbus.CAR_RZC_Haval_H7Hongbiao_18_H /* 2162932 */:
                case FinalCanbus.CAR_RZC_HavalF7_19_Top /* 2228468 */:
                case FinalCanbus.CAR_RZC_HavalLow_Changchengpao_19_L /* 2294004 */:
                case FinalCanbus.CAR_RZC_HavalH7L_17 /* 2359540 */:
                case FinalCanbus.CAR_RZC_HavalH7L_17_H /* 2425076 */:
                    if (temp >= 112 && temp <= 144) {
                        temp = ((temp - 112) * 5) + 160;
                        findViewById(R.id.air_sp_tempvalue_left).setVisibility(0);
                        findViewById(R.id.air_sp_tempunit_left).setVisibility(0);
                        findViewById(R.id.air_sp_tempstate_left).setVisibility(8);
                        break;
                    } else {
                        findViewById(R.id.air_sp_tempvalue_left).setVisibility(8);
                        findViewById(R.id.air_sp_tempunit_left).setVisibility(8);
                        findViewById(R.id.air_sp_tempstate_left).setVisibility(0);
                        findViewById(R.id.air_sp_tempstate_left).setBackgroundResource(R.drawable.ic_hp_air_tempstate_n);
                        break;
                    }
                case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15_YC /* 590279 */:
                case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15H_YC /* 655815 */:
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
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 10) + 310;
                        break;
                    } else {
                        temp *= 5;
                        break;
                    }
                case FinalCanbus.CAR_RZC_BeiQi_18EU5 /* 786659 */:
                case FinalCanbus.CAR_RZC_BeiQi_20EX3 /* 1245411 */:
                case FinalCanbus.CAR_RZC_BeiQi_20EU5 /* 1376483 */:
                case FinalCanbus.CAR_453_OD_Jianghuai_Chaoyue /* 12779973 */:
                case FinalCanbus.CAR_439_OUDI_Beiqi_EC3 /* 14090679 */:
                case FinalCanbus.CAR_439_OUDI_Beiqi_EC5 /* 14156215 */:
                case FinalCanbus.CAR_439_OUDI_Beiqi_EC180 /* 14221751 */:
                case FinalCanbus.CAR_439_OUDI_Beiqi_EC220 /* 14287287 */:
                case FinalCanbus.CAR_439_OUDI_Beiqi_EU5 /* 14352823 */:
                    temp = (temp * 10) + 170;
                    break;
                case FinalCanbus.CAR_RZC_BenTeng_OLDB50 /* 786845 */:
                    temp = ((temp - 16) * 5) + 160;
                    break;
                case FinalCanbus.CAR_RZC_BeiQi_Shenbao_D50_18 /* 852195 */:
                    temp = (temp * 10) + 160;
                    break;
                case FinalCanbus.CAR_439_LUZ_BinLi_H /* 1442244 */:
                case FinalCanbus.CAR_452_LZ_Volvo /* 7995844 */:
                case FinalCanbus.CAR_439_LUZ_BinLi /* 9241015 */:
                case FinalCanbus.CAR_452_LZ_Volvo_10 /* 13631940 */:
                case FinalCanbus.CAR_452_LZ_Volvo_15 /* 16515524 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 9) + 320;
                        break;
                    } else {
                        temp *= 5;
                        break;
                    }
                case FinalCanbus.CAR_439_OD_Qirui_KaiyiX3 /* 1507780 */:
                    temp = (temp * 5) + 155;
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
                    findViewById(R.id.air_sp_tempvalue_left).setVisibility(0);
                    findViewById(R.id.air_sp_tempunit_left).setVisibility(0);
                    findViewById(R.id.air_sp_tempstate_left).setVisibility(8);
                    if (temp >= 31 && temp <= 59) {
                        temp *= 5;
                        break;
                    } else if (temp >= 120 && temp <= 170) {
                        temp *= 5;
                        break;
                    } else {
                        findViewById(R.id.air_sp_tempvalue_left).setVisibility(8);
                        findViewById(R.id.air_sp_tempunit_left).setVisibility(8);
                        findViewById(R.id.air_sp_tempstate_left).setVisibility(0);
                        findViewById(R.id.air_sp_tempstate_left).setBackgroundResource(R.drawable.ic_hp_air_tempstate_n);
                        break;
                    }
                case FinalCanbus.CAR_453_LZ_Nissan_Teana_03 /* 2687429 */:
                case FinalCanbus.CAR_453_LZ_Nissan_Teana_03_H /* 2752965 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        temp = (temp * 5) + 175;
                        break;
                    } else {
                        temp = (temp * 10) + 590;
                        break;
                    }
                case FinalCanbus.CAR_454_LZ_Toyota_Prius_03_L /* 3539398 */:
                case FinalCanbus.CAR_454_LZ_Toyota_Prius_03_H /* 3604934 */:
                case FinalCanbus.CAR_454_LZ_Lexus_RX330_L /* 3801542 */:
                case FinalCanbus.CAR_454_LZ_Lexus_RX330_H /* 3867078 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 635;
                        break;
                    } else {
                        temp = (temp * 5) + 175;
                        break;
                    }
                case FinalCanbus.CAR_439_HC_RongWei950 /* 4129207 */:
                case FinalCanbus.CAR_452_OD_Zhonghua_V6_18 /* 6160836 */:
                case FinalCanbus.CAR_454_OD_Zhonghua_V7 /* 14221766 */:
                case FinalCanbus.CAR_454_OD_Zhonghua_V7_H /* 14287302 */:
                case FinalCanbus.CAR_452_OD_WeiMa_E5 /* 15663556 */:
                    temp = (temp * 5) + 160;
                    break;
                case FinalCanbus.CAR_439_RZC_LufengXiaoyao /* 4325815 */:
                case FinalCanbus.CAR_454_OD_Futon_Dajiangjun /* 10551750 */:
                case FinalCanbus.CAR_453_OD_Dongfeng_Chenglong_H7 /* 12714437 */:
                case FinalCanbus.CAR_439_OD_Futon_Tunland /* 16449975 */:
                    temp = (temp * 5) + 170;
                    break;
                case FinalCanbus.CAR_453_RZC_SWM_G01_22 /* 4784581 */:
                case FinalCanbus.CAR_439_RZC_SWM_G01 /* 13894071 */:
                case FinalCanbus.CAR_439_RZC_SWM_G01_19 /* 15729079 */:
                case FinalCanbus.CAR_439_RZC_WEICHAI_U70 /* 15794615 */:
                    if (temp >= 30 && temp <= 70) {
                        temp *= 5;
                        findViewById(R.id.air_sp_tempvalue_left).setVisibility(0);
                        findViewById(R.id.air_sp_tempunit_left).setVisibility(0);
                        findViewById(R.id.air_sp_tempstate_left).setVisibility(8);
                        break;
                    } else {
                        findViewById(R.id.air_sp_tempvalue_left).setVisibility(8);
                        findViewById(R.id.air_sp_tempunit_left).setVisibility(8);
                        findViewById(R.id.air_sp_tempstate_left).setVisibility(0);
                        findViewById(R.id.air_sp_tempstate_left).setBackgroundResource(R.drawable.ic_hp_air_tempstate_n);
                        break;
                    }
                case FinalCanbus.CAR_453_DJ_Nissan_NOCD /* 5833157 */:
                case FinalCanbus.CAR_453_DJ_Nissan_NOCD_H /* 5898693 */:
                case FinalCanbus.CAR_439_DJ_Nissan /* 12779959 */:
                case FinalCanbus.CAR_439_DJ_Nissan_H /* 12845495 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp *= 10;
                        break;
                    } else {
                        temp *= 5;
                        break;
                    }
                case FinalCanbus.CAR_452_Xinchi_Dodge_JCUV /* 6226372 */:
                case FinalCanbus.CAR_454_OD_Maserati_Ghibli_14 /* 14025158 */:
                case FinalCanbus.CAR_454_OD_Maserati_Quattroporte_13 /* 14090694 */:
                case FinalCanbus.CAR_439_XC_Feiyate_Feiyue /* 15532471 */:
                    if (temp >= 60 && temp <= 84) {
                        temp *= 10;
                        break;
                    } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 18) + 320;
                        break;
                    } else {
                        temp *= 10;
                        break;
                    }
                case FinalCanbus.CAR_452_RZC_SWM_G01_21_Low /* 11338180 */:
                    if (temp >= 36 && temp <= 50) {
                        temp = ((temp - 36) * 10) + 180;
                        findViewById(R.id.air_sp_tempvalue_left).setVisibility(0);
                        findViewById(R.id.air_sp_tempunit_left).setVisibility(0);
                        findViewById(R.id.air_sp_tempstate_left).setVisibility(8);
                        break;
                    } else {
                        findViewById(R.id.air_sp_tempvalue_left).setVisibility(8);
                        findViewById(R.id.air_sp_tempunit_left).setVisibility(8);
                        findViewById(R.id.air_sp_tempstate_left).setVisibility(0);
                        findViewById(R.id.air_sp_tempstate_left).setBackgroundResource(R.drawable.ic_hp_air_tempstate_n);
                        break;
                    }
                case FinalCanbus.CAR_453_XC_Honda_Acura_RL /* 12452293 */:
                case FinalCanbus.CAR_452_XC_Honda_Acura_TL /* 12911044 */:
                case FinalCanbus.CAR_452_XC_Honda_Acura_RDX /* 12976580 */:
                case FinalCanbus.CAR_452_XC_Honda_Acura_TLX /* 13042116 */:
                    if (temp >= 1 && temp <= 29) {
                        temp = (temp * 5) + 170;
                        break;
                    } else if (temp >= 32 && temp <= 34) {
                        temp = ((temp - 32) * 5) + 160;
                        break;
                    } else if (temp == 35) {
                        temp = 320;
                        break;
                    }
                case FinalCanbus.CAR_453_OD_JMC_Energy_Yizhi_EV3 /* 12648901 */:
                    temp = (temp * 5) + 180;
                    break;
                case FinalCanbus.CAR_452_OD_Changcheng_Oula /* 14156228 */:
                    temp = ((temp - 116) * 5) + 160;
                    if (temp < 0) {
                        temp = 0;
                        break;
                    }
            }
            mUpdateTempValue(R.id.air_sp_temp_left1, temp / 100, false);
            mUpdateTempValue(R.id.air_sp_temp_left2, (temp % 100) / 10, false);
            mUpdateTempValue(R.id.air_sp_temp_left3, temp % 10, true);
            mUpdateTempUNIT();
        }
    }

    
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
                case 21:
                case 416:
                case FinalCanbus.CAR_WC2_MengDiOuZS2013_M /* 65557 */:
                case FinalCanbus.CAR_WC2_17MingJue6 /* 65952 */:
                case FinalCanbus.CAR_WC2_MengDiOuZS2013_H /* 131093 */:
                case FinalCanbus.CAR_WC2_RongWei_I5 /* 131488 */:
                case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL /* 196629 */:
                case FinalCanbus.CAR_WC2_RongWei_I6 /* 197024 */:
                case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL_M /* 262165 */:
                case FinalCanbus.CAR_WC2_CHANGAN_19KeSai /* 262272 */:
                case FinalCanbus.CAR_WC2_RongWei_EI6 /* 262560 */:
                case FinalCanbus.CAR_WC2_MengDiOu_KEEP_AIR_PANNEL_H /* 327701 */:
                case FinalCanbus.CAR_WC2_RongWei_RX3 /* 328096 */:
                case FinalCanbus.CAR_WC2_18Ecosport /* 393237 */:
                case FinalCanbus.CAR_WC2_RongWei_HS /* 393632 */:
                case FinalCanbus.CAR_WC2_MengDiOuZS2018 /* 458773 */:
                case FinalCanbus.CAR_WC2_RongWei_I5_H /* 459168 */:
                case FinalCanbus.CAR_WC2_MengDiOuZS2021 /* 524309 */:
                case FinalCanbus.CAR_CZH_WC2_MengDiOuZS2013_M /* 589845 */:
                case FinalCanbus.CAR_WC2_20Oushang_X7_H /* 655488 */:
                case FinalCanbus.CAR_WC2_19ChangAn_CS35_PLUS /* 721024 */:
                case FinalCanbus.CAR_443_WC2_Tianlai08_12 /* 1180091 */:
                case FinalCanbus.CAR_455_LZ_Ford_Mustang_L_CYT /* 1245639 */:
                case FinalCanbus.CAR_WC2_BeiQi_M50F /* 1311115 */:
                case FinalCanbus.CAR_455_LZ_Ford_Mustang_H_CYT /* 1311175 */:
                case FinalCanbus.CAR_455_LZ_Ford_Mustang_RH_CYT /* 1376711 */:
                case FinalCanbus.CAR_455_LZ_Ford_Mustang_RL_CYT /* 1442247 */:
                case FinalCanbus.CAR_443_WC2_Nissan_Ruiqi /* 1704379 */:
                case FinalCanbus.CAR_444_WC2_Dongfeng_Xiaokang_Ix5 /* 1835452 */:
                case FinalCanbus.CAR_453_OD_Jiangling_Kaiyun_H /* 1835461 */:
                case FinalCanbus.CAR_WC2_JieTu_X70_22 /* 2294155 */:
                case FinalCanbus.CAR_WC2_JieTu_X70_22_H /* 2359691 */:
                case FinalCanbus.CAR_454_LZ_Ford_F150_15_L /* 3932614 */:
                case FinalCanbus.CAR_454_LZ_Ford_F150_15_H /* 3998150 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mondeo_16 /* 4522438 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mondeo_17 /* 4587974 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_16_H /* 4653510 */:
                case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD /* 4719035 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Taurus_10_H /* 4719046 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_17_Auto /* 4784582 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_14_Auto /* 4850118 */:
                case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD_HW /* 4915643 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_15 /* 4915654 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_KUGA_15 /* 4981190 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_KUGA_18 /* 5046726 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_FOCUS_15 /* 5112262 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_FOCUS_18 /* 5177798 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_15_H /* 5243334 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_18_H /* 5308870 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_15 /* 5374406 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_18 /* 5439942 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_12_H /* 5505478 */:
                case FinalCanbus.CAR_453_LZ_Chrysler_300C_15 /* 5571013 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_17 /* 5571014 */:
                case FinalCanbus.CAR_453_LZ_Maserati_Levante_18 /* 5636549 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_18 /* 5636550 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_15 /* 5702086 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_12_L /* 5767622 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_12_H /* 5833158 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mustang_15_L /* 5898694 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Everest_16 /* 5964230 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Everest_18 /* 6029766 */:
                case FinalCanbus.CAR_452_OD_Nissan_Tule_low /* 6095300 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_16_L /* 6095302 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Taurus_10_L /* 6160838 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_F150_14_Hand /* 6226374 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Mondeo_18 /* 6291910 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_17_SYNC3 /* 6357446 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_Explorer_17_Hand /* 6422982 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_10_Auto /* 6488518 */:
                case FinalCanbus.CAR_454_Sanwu_Ford_EDGE_10_Hand /* 6554054 */:
                case FinalCanbus.CAR_452_XBS_Nissan_Cedric /* 7143876 */:
                case FinalCanbus.CAR_443_WC_OPEL_Astra_04 /* 7274939 */:
                case FinalCanbus.CAR_443_WC_OPEL_Zafira_05 /* 7340475 */:
                case FinalCanbus.CAR_443_WC_OPEL_Antara_06 /* 7406011 */:
                case FinalCanbus.CAR_443_WC_OPEL_Vectra_02 /* 7471547 */:
                case FinalCanbus.CAR_443_WC_OPEL_Corsa_06 /* 7537083 */:
                case FinalCanbus.CAR_443_WC_OPEL_Meriva_03 /* 7602619 */:
                case FinalCanbus.CAR_443_WC2_Nissan_Ruiqi7 /* 7799227 */:
                case FinalCanbus.CAR_452_OD_LandRover_Freelander /* 7799236 */:
                case FinalCanbus.CAR_453_OD_Ford_PRO_23 /* 8389061 */:
                case FinalCanbus.CAR_452_XC_Nissan_Tule_CD /* 8716740 */:
                case FinalCanbus.CAR_443_WC2_Proton_X50_22 /* 9306555 */:
                case FinalCanbus.CAR_443_WC2_Proton_X50_22_H /* 9372091 */:
                case FinalCanbus.CAR_443_WC2_Proton_Persona_22 /* 9437627 */:
                case FinalCanbus.CAR_443_WC2_Proton_X70_22 /* 9503163 */:
                case FinalCanbus.CAR_452_Oudi_Jianghuai_IEV7 /* 9503172 */:
                case FinalCanbus.CAR_443_WC2_Proton_X70_22_H /* 9568699 */:
                case FinalCanbus.CAR_452_Oudi_Jianghuai_IEV7_H /* 9568708 */:
                case FinalCanbus.CAR_443_WC_OPEL_Astra_04_H /* 10420667 */:
                case FinalCanbus.CAR_443_WC_OPEL_Zafira_05_H /* 10486203 */:
                case FinalCanbus.CAR_443_WC_OPEL_Antara_06_H /* 10551739 */:
                case FinalCanbus.CAR_443_WC_OPEL_Vectra_02_H /* 10617275 */:
                case FinalCanbus.CAR_443_WC_OPEL_Corsa_06_H /* 10682811 */:
                case FinalCanbus.CAR_443_WC_OPEL_Meriva_03_H /* 10748347 */:
                case FinalCanbus.CAR_453_OD_BQ_BJ30_21 /* 12845509 */:
                case FinalCanbus.CAR_439_OUDI_Falcon_New_Single /* 13042103 */:
                case FinalCanbus.CAR_439_OUDI_Falcon_New_Double /* 13107639 */:
                case FinalCanbus.CAR_439_OUDI_Territory_New_Single /* 13173175 */:
                case FinalCanbus.CAR_439_OUDI_Territory_New_Double /* 13238711 */:
                case FinalCanbus.CAR_439_OUDI_Territory_Old_Single /* 13304247 */:
                case FinalCanbus.CAR_439_OUDI_Territory_Old_Double /* 13369783 */:
                case FinalCanbus.CAR_439_OUDI_Falcon_Old_Single /* 13435319 */:
                case FinalCanbus.CAR_439_OUDI_Falcon_Old_Double /* 13500855 */:
                case FinalCanbus.CAR_443_WC2_Jili_GS_18 /* 13631931 */:
                case FinalCanbus.CAR_443_WC2_Jili_GL_18 /* 13697467 */:
                case FinalCanbus.CAR_443_WC2_Jili_Boyue_18 /* 13763003 */:
                case FinalCanbus.CAR_443_WC2_Jili_Boyue_20 /* 13828539 */:
                case FinalCanbus.CAR_443_WC2_Jili_Dihao_22 /* 13894075 */:
                case FinalCanbus.CAR_443_WC2_Jili_Binyue_22 /* 13959611 */:
                case FinalCanbus.CAR_443_WC2_Jili_All /* 14025147 */:
                case FinalCanbus.CAR_454_OD_Jiangling_Dadao /* 14483910 */:
                case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_L /* 14614971 */:
                case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_M /* 14680507 */:
                case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_H /* 14746043 */:
                case FinalCanbus.CAR_443_WC2_Proton_S70_24 /* 16449979 */:
                case FinalCanbus.CAR_443_WC2_Proton_S70_24_H /* 16515515 */:
                case FinalCanbus.CAR_443_WC2_Proton_X90_24 /* 16581051 */:
                case FinalCanbus.CAR_443_WC2_Proton_X90_24_H /* 16646587 */:
                    temp *= 5;
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
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp *= 10;
                        break;
                    }
                case 61:
                case FinalCanbus.CAR_RZC_XP1_GM_1 /* 65597 */:
                case FinalCanbus.CAR_RZC_XP1_GM_2 /* 131133 */:
                case FinalCanbus.CAR_RZC_XP1_GM_3 /* 196669 */:
                case FinalCanbus.CAR_RZC_XP1_GM_4 /* 262205 */:
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
                case FinalCanbus.CAR_RZC_ALL_GM_08_10AstraH /* 3866685 */:
                case FinalCanbus.CAR_RZC_ALL_GM_11CorsaD /* 3932221 */:
                case FinalCanbus.CAR_RZC_ALL_GM_08Combo /* 3997757 */:
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
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = ((temp - 160) / 5) + 600;
                        break;
                    } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = ((temp * 9) / 5) + 320;
                        break;
                    }
                case 163:
                case 339:
                case 374:
                case FinalCanbus.CAR_RZC4_PSA14_308_16 /* 65699 */:
                case FinalCanbus.CAR_RZC4_PSA_4008 /* 65875 */:
                case FinalCanbus.CAR_XP1_ZiYouGuang_H /* 65910 */:
                case FinalCanbus.CAR_RZC4_PSA14_408_M /* 131235 */:
                case FinalCanbus.CAR_RZC4_PSA_19_C4L /* 131411 */:
                case FinalCanbus.CAR_RZC4_PSA14_408_H /* 196771 */:
                case FinalCanbus.CAR_RZC4_PSA_19_508 /* 196947 */:
                case FinalCanbus.CAR_XP1_17ZhiNanZhe /* 196982 */:
                case FinalCanbus.CAR_RZC4_PSA_19_C3_XR_L /* 262483 */:
                case FinalCanbus.CAR_XP1_17ZhiNanZhe_H /* 262518 */:
                case FinalCanbus.CAR_RZC4_PSA_19_C3_XR_M /* 328019 */:
                case FinalCanbus.CAR_RZC4_PSA_19_C3_XR_H /* 393555 */:
                case FinalCanbus.CAR_RZC4_PSA_ALL_M /* 459091 */:
                case FinalCanbus.CAR_RZC4_PSA_ALL_H /* 524627 */:
                case FinalCanbus.CAR_RZC4_PSA_17_3008 /* 721235 */:
                case FinalCanbus.CAR_XP1_18ZiYouXia /* 721270 */:
                case FinalCanbus.CAR_RZC4_PSA_17_3008_M /* 786771 */:
                case FinalCanbus.CAR_XP1_Cherokee /* 786806 */:
                case FinalCanbus.CAR_RZC4_PSA_17_3008_H /* 852307 */:
                case FinalCanbus.CAR_XP1_Cherokee_H /* 852342 */:
                case FinalCanbus.CAR_RZC4_PSA_14_2008 /* 917843 */:
                case FinalCanbus.CAR_BNR_XP1_ZiYouGuang /* 917878 */:
                case FinalCanbus.CAR_RZC4_PSA_14_2008_M /* 983379 */:
                case FinalCanbus.CAR_BNR_XP1_ZiYouGuang_H /* 983414 */:
                case FinalCanbus.CAR_RZC4_PSA_14_2008_H /* 1048915 */:
                case FinalCanbus.CAR_BNR_XP1_17ZhiNanZhe /* 1114486 */:
                case FinalCanbus.CAR_BNR_XP1_17ZhiNanZhe_H /* 1180022 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand /* 1311174 */:
                case FinalCanbus.CAR_RZC4_PSA_17_5008 /* 1376595 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto /* 1376710 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand /* 1442246 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto /* 1507782 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Hand_S /* 1573318 */:
                case FinalCanbus.CAR_RZC4_PSA_04_407 /* 1638739 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_L_Auto_S /* 1638854 */:
                case FinalCanbus.CAR_RZC4_PSA_04_407_CD /* 1704275 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Hand_S /* 1704390 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto_S /* 1769926 */:
                case FinalCanbus.CAR_RZC4_PSA_ALL_NoAir_L /* 2031955 */:
                case FinalCanbus.CAR_RZC4_PSA_ALL_NoAir_M /* 2097491 */:
                case FinalCanbus.CAR_RZC4_PSA_ALL_NoAir_H /* 2163027 */:
                case FinalCanbus.CAR_RZC4_PSA_C4_OE_L /* 2228563 */:
                case FinalCanbus.CAR_RZC4_PSA_C4_OE_M /* 2294099 */:
                case FinalCanbus.CAR_RZC4_PSA_C4_OE_H /* 2359635 */:
                case FinalCanbus.CAR_XP1_RAM1500_H_AUTO /* 4194678 */:
                case FinalCanbus.CAR_RZC_HONDA_23Yage /* 4260138 */:
                case FinalCanbus.CAR_CZH_RZC_HONDA_Civic /* 5636394 */:
                case FinalCanbus.CAR_CZH_RZC_HONDA_10Yage /* 5701930 */:
                case FinalCanbus.CAR_CZH_RZC_HONDA_Haoying /* 5767466 */:
                case FinalCanbus.CAR_CZH_RZC_HONDA_CRV /* 5833002 */:
                case FinalCanbus.CAR_452_LZ_Ford_Mustang /* 11403716 */:
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
                case FinalCanbus.CAR_452_LZ_Ford_Mustang_H /* 14090692 */:
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
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        temp *= 5;
                        break;
                    } else {
                        temp *= 10;
                        break;
                    }
                case 223:
                    temp = (temp * 5) - 400;
                    break;
                case 443:
                case FinalCanbus.CAR_452_LZ_Ferrari_430 /* 2556357 */:
                case FinalCanbus.CAR_439_RZC_YinFeiNiDi_QX50 /* 6029751 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX70_13 /* 6685126 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_Q70_16_L /* 6750662 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_Q70_16_H /* 6816198 */:
                case FinalCanbus.CAR_443_WC2_OULANDE_H /* 7012795 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_Toro_19_H /* 8192443 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_Toro_19_L /* 8257979 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_Strada_19_H /* 8323515 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_Strada_19_L /* 8389051 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_FX50S_09 /* 8389062 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_500x_20_H /* 8454587 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_500x_20_L /* 8520123 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_FX37_13 /* 10224070 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX70_15 /* 10289606 */:
                case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX37_11 /* 10355142 */:
                case FinalCanbus.CAR_452_LZ_Maserati_SP /* 12255684 */:
                case FinalCanbus.CAR_443_WC2_Feiyate_All_Brazil /* 14090683 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 320;
                        break;
                    } else {
                        temp *= 5;
                        break;
                    }
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
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        if (temp >= 1 && temp <= 29) {
                            temp = (temp * 5) + 175;
                            break;
                        } else if (temp >= 33 && temp <= 38) {
                            temp = ((temp - 33) * 5) + 150;
                            break;
                        }
                    } else if (temp >= 1 && temp <= 29) {
                        temp = (temp * 10) + 640;
                        break;
                    } else if (temp >= 33 && temp <= 38) {
                        temp = ((temp - 33) * 10) + 590;
                        break;
                    }
                case FinalCanbus.CAR_RZC_XP1_YuanJingX6 /* 131211 */:
                case FinalCanbus.CAR_RZC_XP1_YuanJingX1 /* 196747 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_GS /* 589963 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_GL /* 655499 */:
                case FinalCanbus.CAR_RZC_XP1_18YuanJingSUV /* 721035 */:
                case FinalCanbus.CAR_RZC_XP1_Borui /* 786571 */:
                case FinalCanbus.CAR_RZC_XP1_18YuanJingSUV_H /* 852107 */:
                case FinalCanbus.CAR_RZC_XP1_16YuanJingSUV /* 917643 */:
                case FinalCanbus.CAR_RZC_XP1_16YuanJingSUV_H /* 983179 */:
                case FinalCanbus.CAR_RZC_XP1_18YuanJing /* 1114251 */:
                case FinalCanbus.CAR_RZC_BoYue /* 1179787 */:
                case FinalCanbus.CAR_RZC_BoYue_H /* 1245323 */:
                case FinalCanbus.CAR_RZC_Jili_19Dihao /* 1310859 */:
                case FinalCanbus.CAR_RZC_Jili_19Dihao_GL_E /* 1441931 */:
                case FinalCanbus.CAR_RZC_Jili_18Dihao /* 1507467 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_GS_18 /* 1573003 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_GL_16 /* 1638539 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_S1_18 /* 1704075 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_GS_19 /* 1769611 */:
                case FinalCanbus.CAR_RZC_XP1_YuanJingX3_19_20 /* 1835147 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_GL_19 /* 1966219 */:
                case FinalCanbus.CAR_RZC_XP1_20YuanJingSUV /* 2031755 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_GL_20 /* 2097291 */:
                case FinalCanbus.CAR_RZC_XP1_Boyue_Pro_20 /* 2162827 */:
                case FinalCanbus.CAR_RZC_XP1_Bingyue_19 /* 2228363 */:
                case FinalCanbus.CAR_455_OD_Jilie_JiheA /* 2228679 */:
                case FinalCanbus.CAR_RZC_XP1_DiHao_GS_20 /* 2293899 */:
                case FinalCanbus.CAR_RZC_XP1_Jiaji_21 /* 2424971 */:
                case FinalCanbus.CAR_452_OD_Ruilan_X3_Pro /* 2425285 */:
                case FinalCanbus.CAR_RZC_XP1_Binrui_20 /* 2490507 */:
                case FinalCanbus.CAR_452_OD_Jihe_EX3 /* 2490821 */:
                case FinalCanbus.CAR_RZC_XP1_Haoyue_20 /* 2556043 */:
                case FinalCanbus.CAR_RZC_XP1_Dihaoe_22 /* 2621579 */:
                case FinalCanbus.CAR_RZC_XP1_Xingrui_22 /* 2687115 */:
                case FinalCanbus.CAR_RZC_BoYue_21 /* 2752651 */:
                case FinalCanbus.CAR_RZC_Xiongmao_Mini_23 /* 2818187 */:
                case FinalCanbus.CAR_RZC_Jili_TX5 /* 2883723 */:
                case FinalCanbus.CAR_RZC_XP1_BingyuePro_19 /* 2949259 */:
                case FinalCanbus.CAR_RZC_Jili_15YuanJing /* 3014795 */:
                case FinalCanbus.CAR_OuDi_XP1_Borui_18 /* 3080331 */:
                case FinalCanbus.CAR_OuDi_XP1_Borui_18_L /* 3145867 */:
                case FinalCanbus.CAR_Oudi_Jili_Binyue_Pro /* 3211403 */:
                case FinalCanbus.CAR_RZC_XP1_Bingyue_21_RS /* 3276939 */:
                case FinalCanbus.CAR_RZC_XP1_Dihao_23 /* 3342475 */:
                case FinalCanbus.CAR_453_OD_Jili_Panda_Mini /* 8454597 */:
                case FinalCanbus.CAR_454_OD_Jilie_DihaoS /* 14156230 */:
                case FinalCanbus.CAR_454_OD_Jilie_YuanchengXingzhi /* 14549446 */:
                case FinalCanbus.CAR_453_OD_Jili_Dihao_EV /* 16056773 */:
                    if (temp >= 32 && temp <= 34) {
                        temp = ((temp - 32) * 5) + 160;
                        break;
                    } else {
                        temp = (temp * 5) + 170;
                        break;
                    }
                case FinalCanbus.CAR_WC_17Haval_H2S /* 196740 */:
                case FinalCanbus.CAR_RZC_HavalLow_H2S_HongBiao /* 393460 */:
                case FinalCanbus.CAR_RZC_HavalLow_H2S_LanBiao /* 721140 */:
                case FinalCanbus.CAR_WC2_BeiQi_EV300_18 /* 2228619 */:
                    temp *= 10;
                    findViewById(R.id.air_sp_tempvalue_right).setVisibility(8);
                    findViewById(R.id.air_sp_tempunit_right).setVisibility(8);
                    findViewById(R.id.air_sp_tempstate_right).setVisibility(0);
                    mUpdateTempValue(R.id.air_sp_tempstate_right, (temp % 100) / 10, false);
                    break;
                case FinalCanbus.CAR_Oudi_XP1_FengGuang17Y580 /* 196922 */:
                case FinalCanbus.CAR_RZC_Jiangxi_FengguangS560_21 /* 1179962 */:
                case FinalCanbus.CAR_RZC_DongFeng_Fengxing_S60EVE /* 1310947 */:
                case FinalCanbus.CAR_Oudi_XP1_FengGuang17Y560 /* 1507642 */:
                case FinalCanbus.CAR_Oudi_XP1_FengGuang17S560 /* 1638714 */:
                case FinalCanbus.CAR_454_OD_Jianghuai_SEHOL_E50A /* 2490822 */:
                case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5 /* 2818501 */:
                case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5_H /* 2884037 */:
                case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5 /* 3015109 */:
                case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5_H /* 3080645 */:
                case FinalCanbus.CAR_454_OD_Jianghuai_IC5 /* 15270342 */:
                    temp *= 10;
                    break;
                case FinalCanbus.CAR_453_OD_Chuangwei_EV /* 197061 */:
                case FinalCanbus.CAR_452_RZC_ZHongtai_E200_18 /* 852420 */:
                case FinalCanbus.CAR_439_RZC_ZhongTaiT500 /* 2163127 */:
                case FinalCanbus.CAR_439_RZC_ZhongTaiT300 /* 2228663 */:
                case FinalCanbus.CAR_439_RZC_ZhongTaiSR9 /* 2294199 */:
                case FinalCanbus.CAR_439_RZC_ZhongTaiSR9_H /* 2359735 */:
                case FinalCanbus.CAR_455_OD_ChangAn_CS95_H /* 3277255 */:
                case FinalCanbus.CAR_453_RZC_Changan_CS15_EPro_21 /* 3473861 */:
                case FinalCanbus.CAR_452_OD_WeiCai_U70_20 /* 3736004 */:
                case FinalCanbus.CAR_439_XBS_09Tianlai /* 4063671 */:
                case FinalCanbus.CAR_452_RZC_ChangAn_19OuShang /* 4719044 */:
                case FinalCanbus.CAR_439_RZC_ChangAn_OUSAN_KESAI /* 7471543 */:
                case FinalCanbus.CAR_439_RZC_ZhongTaiSR7 /* 7537079 */:
                case FinalCanbus.CAR_439_OD_ChangAn_CS95 /* 7930295 */:
                case FinalCanbus.CAR_439_RZC_19yema_Bojun /* 8520119 */:
                case FinalCanbus.CAR_453_RZC_Chuangwei_EV /* 8651205 */:
                case FinalCanbus.CAR_452_RZC_ChangAn_KESAI_Pro_21 /* 11010500 */:
                case FinalCanbus.CAR_454_OD_WeiCai_EHPro_24 /* 11469254 */:
                case FinalCanbus.CAR_452_RZC_Mangguo_LeiDing /* 13697476 */:
                case FinalCanbus.CAR_RZC_ZhongTaiDaMaiX7 /* 14614967 */:
                    temp = (temp * 5) + 175;
                    break;
                case FinalCanbus.CAR_WC2_CHANGAN_19KeSai_Hand /* 327808 */:
                case FinalCanbus.CAR_WC2_19Oushang_A800 /* 458880 */:
                    temp = (temp * 10) + 150;
                    break;
                case FinalCanbus.CAR_RZC_FengGuang18Y580 /* 393530 */:
                case FinalCanbus.CAR_RZC_FengGuang18Y580_H /* 459066 */:
                case FinalCanbus.CAR_RZC_DongFengYiZhi_19EV3 /* 524602 */:
                case FinalCanbus.CAR_RZC_Jiangxi_Wushiling_Mux /* 852282 */:
                case FinalCanbus.CAR_RZC_FengGuang21Y580 /* 1245498 */:
                case FinalCanbus.CAR_RZC_FengGuang21Y580_H /* 1311034 */:
                case FinalCanbus.CAR_RZC_FengGuang_580Pro_20 /* 1835322 */:
                case FinalCanbus.CAR_RZC_FengGuang_580Pro_20_H /* 1900858 */:
                    temp = ((temp - 124) * 5) + 160;
                    break;
                case FinalCanbus.CAR_RZC_BeiQi_19EC5 /* 458979 */:
                    temp = (temp * 20) + 140;
                    break;
                case FinalCanbus.CAR_RZC_XP1_HavalH6 /* 458996 */:
                case FinalCanbus.CAR_RZC_XP1_HavalH6_16HuanDai /* 852212 */:
                case FinalCanbus.CAR_RZC_XP1_HavalH6Couple_16_top /* 983284 */:
                case FinalCanbus.CAR_RZC_HavalLow_Changchengpao_19 /* 1114356 */:
                case FinalCanbus.CAR_RZC_HavalH4_20 /* 1245428 */:
                case FinalCanbus.CAR_RZC_HavalH7_19 /* 1310964 */:
                case FinalCanbus.CAR_RZC_HavalF7_20 /* 1376500 */:
                case FinalCanbus.CAR_RZC_HavalH4_20_H /* 1442036 */:
                case FinalCanbus.CAR_RZC_HavalF7_19 /* 1507572 */:
                case FinalCanbus.CAR_RZC_XP1_HavalH6_H /* 1573108 */:
                case FinalCanbus.CAR_RZC_HavalH7_19_H /* 1638644 */:
                case FinalCanbus.CAR_RZC_HavalH7_19_NoAmp /* 1704180 */:
                case FinalCanbus.CAR_RZC_HavalH7_19_H_NoAmp /* 1769716 */:
                case FinalCanbus.CAR_RZC_Haval_Fengjun5_21 /* 1900788 */:
                case FinalCanbus.CAR_RZC_Haval_H3_05 /* 1966324 */:
                case FinalCanbus.CAR_RZC_Haval_Jinggangpao_22 /* 2031860 */:
                case FinalCanbus.CAR_RZC_Haval_H7Hongbiao_18 /* 2097396 */:
                case FinalCanbus.CAR_RZC_Haval_H7Hongbiao_18_H /* 2162932 */:
                case FinalCanbus.CAR_RZC_HavalF7_19_Top /* 2228468 */:
                case FinalCanbus.CAR_RZC_HavalLow_Changchengpao_19_L /* 2294004 */:
                case FinalCanbus.CAR_RZC_HavalH7L_17 /* 2359540 */:
                case FinalCanbus.CAR_RZC_HavalH7L_17_H /* 2425076 */:
                    if (temp >= 112 && temp <= 144) {
                        temp = ((temp - 112) * 5) + 160;
                        findViewById(R.id.air_sp_tempvalue_right).setVisibility(0);
                        findViewById(R.id.air_sp_tempunit_right).setVisibility(0);
                        findViewById(R.id.air_sp_tempstate_right).setVisibility(8);
                        break;
                    } else {
                        findViewById(R.id.air_sp_tempvalue_right).setVisibility(8);
                        findViewById(R.id.air_sp_tempunit_right).setVisibility(8);
                        findViewById(R.id.air_sp_tempstate_right).setVisibility(0);
                        findViewById(R.id.air_sp_tempstate_right).setBackgroundResource(R.drawable.ic_hp_air_tempstate_n);
                        break;
                    }
                case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15_YC /* 590279 */:
                case FinalCanbus.CAR_455_KYC_Toyota_Highlander_15H_YC /* 655815 */:
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
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 10) + 310;
                        break;
                    } else {
                        temp *= 5;
                        break;
                    }
                case FinalCanbus.CAR_RZC_BeiQi_18EU5 /* 786659 */:
                case FinalCanbus.CAR_RZC_BeiQi_20EX3 /* 1245411 */:
                case FinalCanbus.CAR_RZC_BeiQi_20EU5 /* 1376483 */:
                case FinalCanbus.CAR_453_OD_Jianghuai_Chaoyue /* 12779973 */:
                case FinalCanbus.CAR_439_OUDI_Beiqi_EC3 /* 14090679 */:
                case FinalCanbus.CAR_439_OUDI_Beiqi_EC5 /* 14156215 */:
                case FinalCanbus.CAR_439_OUDI_Beiqi_EC180 /* 14221751 */:
                case FinalCanbus.CAR_439_OUDI_Beiqi_EC220 /* 14287287 */:
                case FinalCanbus.CAR_439_OUDI_Beiqi_EU5 /* 14352823 */:
                    temp = (temp * 10) + 170;
                    break;
                case FinalCanbus.CAR_RZC_BenTeng_OLDB50 /* 786845 */:
                    temp = ((temp - 16) * 5) + 160;
                    break;
                case FinalCanbus.CAR_RZC_BeiQi_Shenbao_D50_18 /* 852195 */:
                    temp = (temp * 10) + 160;
                    break;
                case FinalCanbus.CAR_439_LUZ_BinLi_H /* 1442244 */:
                case FinalCanbus.CAR_452_LZ_Volvo /* 7995844 */:
                case FinalCanbus.CAR_439_LUZ_BinLi /* 9241015 */:
                case FinalCanbus.CAR_452_LZ_Volvo_10 /* 13631940 */:
                case FinalCanbus.CAR_452_LZ_Volvo_15 /* 16515524 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 9) + 320;
                        break;
                    } else {
                        temp *= 5;
                        break;
                    }
                case FinalCanbus.CAR_439_OD_Qirui_KaiyiX3 /* 1507780 */:
                    temp = (temp * 5) + 155;
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
                    findViewById(R.id.air_sp_tempvalue_right).setVisibility(0);
                    findViewById(R.id.air_sp_tempunit_right).setVisibility(0);
                    findViewById(R.id.air_sp_tempstate_right).setVisibility(8);
                    if (temp >= 31 && temp <= 59) {
                        temp *= 5;
                        break;
                    } else if (temp >= 120 && temp <= 170) {
                        temp *= 5;
                        break;
                    } else {
                        findViewById(R.id.air_sp_tempvalue_right).setVisibility(8);
                        findViewById(R.id.air_sp_tempunit_right).setVisibility(8);
                        findViewById(R.id.air_sp_tempstate_right).setVisibility(0);
                        findViewById(R.id.air_sp_tempstate_right).setBackgroundResource(R.drawable.ic_hp_air_tempstate_n);
                        break;
                    }
                case FinalCanbus.CAR_453_LZ_Nissan_Teana_03 /* 2687429 */:
                case FinalCanbus.CAR_453_LZ_Nissan_Teana_03_H /* 2752965 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 0) {
                        temp = (temp * 5) + 175;
                        break;
                    } else {
                        temp = (temp * 10) + 590;
                        break;
                    }
                case FinalCanbus.CAR_454_LZ_Toyota_Prius_03_L /* 3539398 */:
                case FinalCanbus.CAR_454_LZ_Toyota_Prius_03_H /* 3604934 */:
                case FinalCanbus.CAR_454_LZ_Lexus_RX330_L /* 3801542 */:
                case FinalCanbus.CAR_454_LZ_Lexus_RX330_H /* 3867078 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 635;
                        break;
                    } else {
                        temp = (temp * 5) + 175;
                        break;
                    }
                case FinalCanbus.CAR_439_HC_RongWei950 /* 4129207 */:
                case FinalCanbus.CAR_452_OD_Zhonghua_V6_18 /* 6160836 */:
                case FinalCanbus.CAR_454_OD_Zhonghua_V7 /* 14221766 */:
                case FinalCanbus.CAR_454_OD_Zhonghua_V7_H /* 14287302 */:
                case FinalCanbus.CAR_452_OD_WeiMa_E5 /* 15663556 */:
                    temp = (temp * 5) + 160;
                    break;
                case FinalCanbus.CAR_439_RZC_LufengXiaoyao /* 4325815 */:
                case FinalCanbus.CAR_454_OD_Futon_Dajiangjun /* 10551750 */:
                case FinalCanbus.CAR_453_OD_Dongfeng_Chenglong_H7 /* 12714437 */:
                case FinalCanbus.CAR_439_OD_Futon_Tunland /* 16449975 */:
                    temp = (temp * 5) + 170;
                    break;
                case FinalCanbus.CAR_453_RZC_SWM_G01_22 /* 4784581 */:
                case FinalCanbus.CAR_439_RZC_SWM_G01 /* 13894071 */:
                case FinalCanbus.CAR_439_RZC_SWM_G01_19 /* 15729079 */:
                case FinalCanbus.CAR_439_RZC_WEICHAI_U70 /* 15794615 */:
                    if (temp >= 30 && temp <= 70) {
                        temp *= 5;
                        findViewById(R.id.air_sp_tempvalue_right).setVisibility(0);
                        findViewById(R.id.air_sp_tempunit_right).setVisibility(0);
                        findViewById(R.id.air_sp_tempstate_right).setVisibility(8);
                        break;
                    } else {
                        findViewById(R.id.air_sp_tempvalue_right).setVisibility(8);
                        findViewById(R.id.air_sp_tempunit_right).setVisibility(8);
                        findViewById(R.id.air_sp_tempstate_right).setVisibility(0);
                        findViewById(R.id.air_sp_tempstate_right).setBackgroundResource(R.drawable.ic_hp_air_tempstate_n);
                        break;
                    }
                case FinalCanbus.CAR_453_DJ_Nissan_NOCD /* 5833157 */:
                case FinalCanbus.CAR_453_DJ_Nissan_NOCD_H /* 5898693 */:
                case FinalCanbus.CAR_439_DJ_Nissan /* 12779959 */:
                case FinalCanbus.CAR_439_DJ_Nissan_H /* 12845495 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp *= 10;
                        break;
                    } else {
                        temp *= 5;
                        break;
                    }
                case FinalCanbus.CAR_452_Xinchi_Dodge_JCUV /* 6226372 */:
                case FinalCanbus.CAR_454_OD_Maserati_Ghibli_14 /* 14025158 */:
                case FinalCanbus.CAR_454_OD_Maserati_Quattroporte_13 /* 14090694 */:
                case FinalCanbus.CAR_439_XC_Feiyate_Feiyue /* 15532471 */:
                    if (temp >= 60 && temp <= 84) {
                        temp *= 10;
                        break;
                    } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 18) + 320;
                        break;
                    } else {
                        temp *= 10;
                        break;
                    }
                case FinalCanbus.CAR_452_RZC_SWM_G01_21_Low /* 11338180 */:
                    if (temp >= 36 && temp <= 50) {
                        temp = ((temp - 36) * 10) + 180;
                        findViewById(R.id.air_sp_tempvalue_right).setVisibility(0);
                        findViewById(R.id.air_sp_tempunit_right).setVisibility(0);
                        findViewById(R.id.air_sp_tempstate_right).setVisibility(8);
                        break;
                    } else {
                        findViewById(R.id.air_sp_tempvalue_right).setVisibility(8);
                        findViewById(R.id.air_sp_tempunit_right).setVisibility(8);
                        findViewById(R.id.air_sp_tempstate_right).setVisibility(0);
                        findViewById(R.id.air_sp_tempstate_right).setBackgroundResource(R.drawable.ic_hp_air_tempstate_n);
                        break;
                    }
                case FinalCanbus.CAR_453_XC_Honda_Acura_RL /* 12452293 */:
                case FinalCanbus.CAR_452_XC_Honda_Acura_TL /* 12911044 */:
                case FinalCanbus.CAR_452_XC_Honda_Acura_RDX /* 12976580 */:
                case FinalCanbus.CAR_452_XC_Honda_Acura_TLX /* 13042116 */:
                    if (temp >= 1 && temp <= 29) {
                        temp = (temp * 5) + 170;
                        break;
                    } else if (temp >= 32 && temp <= 34) {
                        temp = ((temp - 32) * 5) + 160;
                        break;
                    } else if (temp == 35) {
                        temp = 320;
                        break;
                    }
                case FinalCanbus.CAR_453_OD_JMC_Energy_Yizhi_EV3 /* 12648901 */:
                    temp = (temp * 5) + 180;
                    break;
                case FinalCanbus.CAR_452_OD_Changcheng_Oula /* 14156228 */:
                    temp = ((temp - 116) * 5) + 160;
                    if (temp < 0) {
                        temp = 0;
                        break;
                    }
            }
            mUpdateTempValue(R.id.air_sp_temp_right1, temp / 100, false);
            mUpdateTempValue(R.id.air_sp_temp_right2, (temp % 100) / 10, false);
            mUpdateTempValue(R.id.air_sp_temp_right3, temp % 10, true);
            mUpdateTempUNIT();
        }
    }

    
    public void mUpdateTempUNIT() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT];
        switch (DataCanbus.DATA[1000]) {
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
                int temp = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT];
                if (temp >= 31 && temp <= 59) {
                    findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                    findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                    findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                    findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                    break;
                } else if (temp >= 120 && temp <= 170) {
                    findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                    findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                    findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                    findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                    break;
                }
            default:
                if (ConstAllAirDara.U_AIR_TEMP_UNIT != 255) {
                    if (vel == 1) {
                        findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                        findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                        findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                        findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                        break;
                    } else {
                        findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                        break;
                    }
                } else {
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_452_Xinchi_Dodge_JCUV /* 6226372 */:
                        case FinalCanbus.CAR_454_OD_Maserati_Ghibli_14 /* 14025158 */:
                        case FinalCanbus.CAR_454_OD_Maserati_Quattroporte_13 /* 14090694 */:
                        case FinalCanbus.CAR_439_XC_Feiyate_Feiyue /* 15532471 */:
                            int temp2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT];
                            if (temp2 >= 60 && temp2 <= 84) {
                                findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                                findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                                findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                                findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                                break;
                            } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                                findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                                findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                                findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                                findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                                break;
                            } else {
                                findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                                findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                                findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                                findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                                break;
                            }
                        default:
                            int vel2 = SystemProperties.getInt("persist.fyt.temperature", 0);
                            if (vel2 == 1) {
                                findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                                findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                                findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                                findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                                break;
                            } else {
                                findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                                findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                                findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                                findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
                                break;
                            }
                    }
                }
        }
    }

    
    public void mUpdateBackAuto() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_AUTO];
        findViewById(R.id.air_sp_auto_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_auto_n : R.drawable.ic_hp_auto_p);
    }

    
    public void mUpdateBackAutoRight() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_AUTO_RIGHT];
        findViewById(R.id.air_sp_auto_rear_right).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_auto_n : R.drawable.ic_hp_auto_p);
    }

    
    public void mUpdateBackRearLock() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_LOCK];
        findViewById(R.id.air_sp_rearlock_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_rearlight_n : R.drawable.ic_hp_rearlight_p);
    }

    
    public void mUpdateBackRearSync() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_SYNC];
        findViewById(R.id.air_sp_sync_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_sync_n : R.drawable.ic_hp_sync_p);
    }

    
    public void mUpdateBackRearAC() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_AC];
        findViewById(R.id.air_sp_ac_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_ac_n : R.drawable.ic_hp_ac_p);
    }

    
    public void mUpdateBackRearCtrl() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_CTRL];
        findViewById(R.id.air_sp_car_rear).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_rearlight_n : R.drawable.ic_hp_rearlight_p);
    }

    
    public void mUpdateBackWind() {
        int leave = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_WIND];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WC2_Honda_17Acura_MDX /* 3014977 */:
            case FinalCanbus.CAR_439_RZC_YinFeiNiDi_QX50 /* 6029751 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX70_13 /* 6685126 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_Q70_16_L /* 6750662 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_Q70_16_H /* 6816198 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_FX50S_09 /* 8389062 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_FX37_13 /* 10224070 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX70_15 /* 10289606 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX37_11 /* 10355142 */:
                ((TextView) findViewById(R.id.air_sp_rear_wind_txt)).setText(new StringBuilder().append(leave).toString());
                ((ProgressBar) findViewById(R.id.air_sp_rear_wind_lev)).setMax(5);
                break;
            case FinalCanbus.CAR_RZC_ALL_GM_63 /* 4128829 */:
                if (leave == 15) {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText("AUTO");
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(6);
                    break;
                } else {
                    ((TextView) findViewById(R.id.air_sp_rear_wind_txt)).setText(new StringBuilder().append(leave).toString());
                    ((ProgressBar) findViewById(R.id.air_sp_rear_wind_lev)).setMax(6);
                    break;
                }
            case FinalCanbus.CAR_443_WC2_Feiyate_All_Brazil /* 14090683 */:
                ((TextView) findViewById(R.id.air_sp_rear_wind_txt)).setText(new StringBuilder().append(leave).toString());
                ((ProgressBar) findViewById(R.id.air_sp_rear_wind_lev)).setMax(4);
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

    
    public void mUpdaterAirWindLevelLeft() {
        int value = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
        switch (DataCanbus.DATA[1000]) {
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
            case FinalCanbus.CAR_RZC4_PSA_17_3008 /* 721235 */:
            case FinalCanbus.CAR_RZC4_PSA_17_3008_M /* 786771 */:
            case FinalCanbus.CAR_RZC4_PSA_17_3008_H /* 852307 */:
            case FinalCanbus.CAR_RZC4_PSA_14_2008 /* 917843 */:
            case FinalCanbus.CAR_RZC4_PSA_14_2008_M /* 983379 */:
            case FinalCanbus.CAR_RZC4_PSA_14_2008_H /* 1048915 */:
            case FinalCanbus.CAR_RZC4_PSA_17_5008 /* 1376595 */:
            case FinalCanbus.CAR_RZC4_PSA_04_407 /* 1638739 */:
            case FinalCanbus.CAR_RZC4_PSA_04_407_CD /* 1704275 */:
            case FinalCanbus.CAR_RZC4_PSA_ALL_NoAir_L /* 2031955 */:
            case FinalCanbus.CAR_RZC4_PSA_ALL_NoAir_M /* 2097491 */:
            case FinalCanbus.CAR_RZC4_PSA_ALL_NoAir_H /* 2163027 */:
            case FinalCanbus.CAR_RZC4_PSA_C4_OE_L /* 2228563 */:
            case FinalCanbus.CAR_RZC4_PSA_C4_OE_M /* 2294099 */:
            case FinalCanbus.CAR_RZC4_PSA_C4_OE_H /* 2359635 */:
                if (value == 0) {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText("AUTO");
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(8);
                    break;
                } else {
                    value--;
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(value).toString());
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(8);
                    break;
                }
            case 252:
            case 443:
            case FinalCanbus.CAR_WC2_PSAALL_1 /* 65788 */:
            case FinalCanbus.CAR_RZC_XP1_YuanJingX6 /* 131211 */:
            case FinalCanbus.CAR_WC2_PSAALL_2 /* 131324 */:
            case FinalCanbus.CAR_RZC_XP1_YuanJingX1 /* 196747 */:
            case FinalCanbus.CAR_WC2_PSAALL_3 /* 196860 */:
            case FinalCanbus.CAR_Oudi_XP1_FengGuang17Y580 /* 196922 */:
            case FinalCanbus.CAR_WC2_CHANGAN_19KeSai /* 262272 */:
            case FinalCanbus.CAR_WC2_PSAALL_4 /* 262396 */:
            case FinalCanbus.CAR_WC2_CHANGAN_19KeSai_Hand /* 327808 */:
            case FinalCanbus.CAR_WC2_PSAALL_5 /* 327932 */:
            case FinalCanbus.CAR_RZC_HavalLow_H2S_HongBiao /* 393460 */:
            case FinalCanbus.CAR_WC2_PSAALL_6 /* 393468 */:
            case FinalCanbus.CAR_WC2_19Oushang_A800 /* 458880 */:
            case FinalCanbus.CAR_RZC_BeiQi_19EC5 /* 458979 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6 /* 458996 */:
            case FinalCanbus.CAR_WC2_PSAALL_7 /* 459004 */:
            case FinalCanbus.CAR_WC2_PSAALL_8 /* 524540 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS /* 589963 */:
            case FinalCanbus.CAR_WC2_PSAALL_9 /* 590076 */:
            case FinalCanbus.CAR_WC2_20Oushang_X7_H /* 655488 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GL /* 655499 */:
            case FinalCanbus.CAR_WC2_PSAALL_10 /* 655612 */:
            case FinalCanbus.CAR_WC2_19ChangAn_CS35_PLUS /* 721024 */:
            case FinalCanbus.CAR_RZC_XP1_18YuanJingSUV /* 721035 */:
            case FinalCanbus.CAR_RZC_HavalLow_H2S_LanBiao /* 721140 */:
            case FinalCanbus.CAR_WC2_PSAALL_11 /* 721148 */:
            case FinalCanbus.CAR_RZC_XP1_Borui /* 786571 */:
            case FinalCanbus.CAR_RZC_BeiQi_18EU5 /* 786659 */:
            case FinalCanbus.CAR_WC2_PSAALL_12 /* 786684 */:
            case FinalCanbus.CAR_RZC_XP1_18YuanJingSUV_H /* 852107 */:
            case FinalCanbus.CAR_RZC_BeiQi_Shenbao_D50_18 /* 852195 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6_16HuanDai /* 852212 */:
            case FinalCanbus.CAR_WC2_PSAALL_DS6 /* 852220 */:
            case FinalCanbus.CAR_RZC_XP1_16YuanJingSUV /* 917643 */:
            case FinalCanbus.CAR_WC2_PSAALL_301_19 /* 917756 */:
            case FinalCanbus.CAR_RZC_XP1_16YuanJingSUV_H /* 983179 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6Couple_16_top /* 983284 */:
            case FinalCanbus.CAR_WC2_PSAALL_Rifter_19_H /* 983292 */:
            case FinalCanbus.CAR_WC2_PSAALL_Rifter_19_L /* 1048828 */:
            case FinalCanbus.CAR_RZC_XP1_18YuanJing /* 1114251 */:
            case FinalCanbus.CAR_RZC_HavalLow_Changchengpao_19 /* 1114356 */:
            case FinalCanbus.CAR_WC2_PSAALL_TY_C5 /* 1114364 */:
            case FinalCanbus.CAR_RZC_BoYue /* 1179787 */:
            case FinalCanbus.CAR_WC2_PSAALL_308_11_Amp /* 1179900 */:
            case FinalCanbus.CAR_443_WC2_Tianlai08_12 /* 1180091 */:
            case FinalCanbus.CAR_RZC_BoYue_H /* 1245323 */:
            case FinalCanbus.CAR_RZC_BeiQi_20EX3 /* 1245411 */:
            case FinalCanbus.CAR_RZC_HavalH4_20 /* 1245428 */:
            case FinalCanbus.CAR_WC2_PSAALL_407_06 /* 1245436 */:
            case FinalCanbus.CAR_RZC_Jili_19Dihao /* 1310859 */:
            case FinalCanbus.CAR_RZC_DongFeng_Fengxing_S60EVE /* 1310947 */:
            case FinalCanbus.CAR_RZC_HavalH7_19 /* 1310964 */:
            case FinalCanbus.CAR_WC2_PSAALL_C3Aircross_23 /* 1310972 */:
            case FinalCanbus.CAR_WC2_BeiQi_M50F /* 1311115 */:
            case FinalCanbus.CAR_RZC_BeiQi_20EU5 /* 1376483 */:
            case FinalCanbus.CAR_RZC_HavalF7_20 /* 1376500 */:
            case FinalCanbus.CAR_WC2_PSAALL_3008_22 /* 1376508 */:
            case FinalCanbus.CAR_RZC_Jili_19Dihao_GL_E /* 1441931 */:
            case FinalCanbus.CAR_RZC_HavalH4_20_H /* 1442036 */:
            case FinalCanbus.CAR_WC2_PSAALL_C4_09 /* 1442044 */:
            case FinalCanbus.CAR_439_LUZ_BinLi_H /* 1442244 */:
            case FinalCanbus.CAR_RZC_Jili_18Dihao /* 1507467 */:
            case FinalCanbus.CAR_RZC_HavalF7_19 /* 1507572 */:
            case FinalCanbus.CAR_WC2_PSAALL_Partner_09 /* 1507580 */:
            case FinalCanbus.CAR_Oudi_XP1_FengGuang17Y560 /* 1507642 */:
            case FinalCanbus.CAR_439_OD_Qirui_KaiyiX3 /* 1507780 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS_18 /* 1573003 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6_H /* 1573108 */:
            case FinalCanbus.CAR_WC2_PSAALL_Belingo_17 /* 1573116 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GL_16 /* 1638539 */:
            case FinalCanbus.CAR_RZC_HavalH7_19_H /* 1638644 */:
            case FinalCanbus.CAR_Oudi_XP1_FengGuang17S560 /* 1638714 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_S1_18 /* 1704075 */:
            case FinalCanbus.CAR_RZC_HavalH7_19_NoAmp /* 1704180 */:
            case FinalCanbus.CAR_WC2_PSAALL_5008_21 /* 1704188 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS_19 /* 1769611 */:
            case FinalCanbus.CAR_RZC_HavalH7_19_H_NoAmp /* 1769716 */:
            case FinalCanbus.CAR_WC2_PSAALL_208_23_SA /* 1769724 */:
            case FinalCanbus.CAR_RZC_XP1_YuanJingX3_19_20 /* 1835147 */:
            case FinalCanbus.CAR_WC2_PSAALL_C3_22_SA /* 1835260 */:
            case FinalCanbus.CAR_444_WC2_Dongfeng_Xiaokang_Ix5 /* 1835452 */:
            case FinalCanbus.CAR_RZC_Haval_Fengjun5_21 /* 1900788 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GL_19 /* 1966219 */:
            case FinalCanbus.CAR_RZC_Haval_H3_05 /* 1966324 */:
            case FinalCanbus.CAR_RZC_XP1_20YuanJingSUV /* 2031755 */:
            case FinalCanbus.CAR_RZC_Haval_Jinggangpao_22 /* 2031860 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GL_20 /* 2097291 */:
            case FinalCanbus.CAR_RZC_Haval_H7Hongbiao_18 /* 2097396 */:
            case FinalCanbus.CAR_RZC_XP1_Boyue_Pro_20 /* 2162827 */:
            case FinalCanbus.CAR_RZC_Haval_H7Hongbiao_18_H /* 2162932 */:
            case FinalCanbus.CAR_RZC_XP1_Bingyue_19 /* 2228363 */:
            case FinalCanbus.CAR_RZC_HavalF7_19_Top /* 2228468 */:
            case FinalCanbus.CAR_WC2_BeiQi_EV300_18 /* 2228619 */:
            case FinalCanbus.CAR_455_OD_Jilie_JiheA /* 2228679 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS_20 /* 2293899 */:
            case FinalCanbus.CAR_RZC_HavalLow_Changchengpao_19_L /* 2294004 */:
            case FinalCanbus.CAR_RZC_HavalH7L_17 /* 2359540 */:
            case FinalCanbus.CAR_RZC_XP1_Jiaji_21 /* 2424971 */:
            case FinalCanbus.CAR_RZC_HavalH7L_17_H /* 2425076 */:
            case FinalCanbus.CAR_452_OD_Ruilan_X3_Pro /* 2425285 */:
            case FinalCanbus.CAR_RZC_XP1_Binrui_20 /* 2490507 */:
            case FinalCanbus.CAR_452_OD_Jihe_EX3 /* 2490821 */:
            case FinalCanbus.CAR_RZC_XP1_Haoyue_20 /* 2556043 */:
            case FinalCanbus.CAR_RZC_XP1_Dihaoe_22 /* 2621579 */:
            case FinalCanbus.CAR_RZC_XP1_Xingrui_22 /* 2687115 */:
            case FinalCanbus.CAR_RZC_BoYue_21 /* 2752651 */:
            case FinalCanbus.CAR_RZC_Xiongmao_Mini_23 /* 2818187 */:
            case FinalCanbus.CAR_RZC_Jili_TX5 /* 2883723 */:
            case FinalCanbus.CAR_RZC_XP1_BingyuePro_19 /* 2949259 */:
            case FinalCanbus.CAR_455_6606_RZC_VinFast_PLUS_23 /* 2949575 */:
            case FinalCanbus.CAR_RZC_Jili_15YuanJing /* 3014795 */:
            case FinalCanbus.CAR_OuDi_XP1_Borui_18 /* 3080331 */:
            case FinalCanbus.CAR_OuDi_XP1_Borui_18_L /* 3145867 */:
            case FinalCanbus.CAR_Oudi_Jili_Binyue_Pro /* 3211403 */:
            case FinalCanbus.CAR_RZC_XP1_Bingyue_21_RS /* 3276939 */:
            case FinalCanbus.CAR_455_OD_ChangAn_CS95_H /* 3277255 */:
            case FinalCanbus.CAR_RZC_XP1_Dihao_23 /* 3342475 */:
            case FinalCanbus.CAR_453_RZC_Changan_CS15_EPro_21 /* 3473861 */:
            case FinalCanbus.CAR_454_OD_Beijing_X3_18 /* 4063686 */:
            case FinalCanbus.CAR_439_HC_RongWei950 /* 4129207 */:
            case FinalCanbus.CAR_454_OD_Beijing_X5_18 /* 4129222 */:
            case FinalCanbus.CAR_454_OD_Beiqi_EU5_18 /* 4194758 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_D50_19 /* 4260294 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X35_19 /* 4325830 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X55_18 /* 4391366 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Zhixing_18 /* 4456902 */:
            case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD /* 4719035 */:
            case FinalCanbus.CAR_452_RZC_ChangAn_19OuShang /* 4719044 */:
            case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD_HW /* 4915643 */:
            case FinalCanbus.CAR_453_LZ_Chrysler_300C_15 /* 5571013 */:
            case FinalCanbus.CAR_453_LZ_Maserati_Levante_18 /* 5636549 */:
            case FinalCanbus.CAR_452_OD_Zhonghua_V6_18 /* 6160836 */:
            case FinalCanbus.CAR_443_WC2_OULANDE_H /* 7012795 */:
            case FinalCanbus.CAR_452_XBS_Nissan_Cedric /* 7143876 */:
            case FinalCanbus.CAR_439_RZC_ChangAn_OUSAN_KESAI /* 7471543 */:
            case FinalCanbus.CAR_439_OD_ChangAn_CS95 /* 7930295 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Toro_19_H /* 8192443 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Toro_19_L /* 8257979 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Strada_19_H /* 8323515 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_Strada_19_L /* 8389051 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_500x_20_H /* 8454587 */:
            case FinalCanbus.CAR_453_OD_Jili_Panda_Mini /* 8454597 */:
            case FinalCanbus.CAR_443_WC2_Feiyate_500x_20_L /* 8520123 */:
            case FinalCanbus.CAR_454_OD_Shanqi_Delong_M3000S /* 8520134 */:
            case FinalCanbus.CAR_454_OD_Shanqi_Delong_L5000 /* 8585670 */:
            case FinalCanbus.CAR_454_OD_Shanqi_Delong_M6000 /* 8651206 */:
            case FinalCanbus.CAR_454_OD_Shanqi_Delong_X5000 /* 8716742 */:
            case FinalCanbus.CAR_454_OD_Shanqi_Xuandeyi_6 /* 8782278 */:
            case FinalCanbus.CAR_454_OD_Shanqi_Xuandeyi_9 /* 8847814 */:
            case FinalCanbus.CAR_454_OD_Shanqi_Zhiyun_E2 /* 8913350 */:
            case FinalCanbus.CAR_439_LUZ_BinLi /* 9241015 */:
            case FinalCanbus.CAR_443_WC2_Proton_X50_22 /* 9306555 */:
            case FinalCanbus.CAR_443_WC2_Proton_X50_22_H /* 9372091 */:
            case FinalCanbus.CAR_443_WC2_Proton_Persona_22 /* 9437627 */:
            case FinalCanbus.CAR_443_WC2_Proton_X70_22 /* 9503163 */:
            case FinalCanbus.CAR_452_Oudi_Jianghuai_IEV7 /* 9503172 */:
            case FinalCanbus.CAR_443_WC2_Proton_X70_22_H /* 9568699 */:
            case FinalCanbus.CAR_452_Oudi_Jianghuai_IEV7_H /* 9568708 */:
            case FinalCanbus.CAR_454_OD_Futon_Dajiangjun /* 10551750 */:
            case FinalCanbus.CAR_452_RZC_ChangAn_KESAI_Pro_21 /* 11010500 */:
            case FinalCanbus.CAR_453_OD_Dongfeng_Chenglong_H7 /* 12714437 */:
            case FinalCanbus.CAR_453_OD_Jianghuai_Chaoyue /* 12779973 */:
            case FinalCanbus.CAR_453_OD_BQ_BJ30_21 /* 12845509 */:
            case FinalCanbus.CAR_443_WC2_Jili_Boyue_20 /* 13828539 */:
            case FinalCanbus.CAR_443_WC2_Jili_Dihao_22 /* 13894075 */:
            case FinalCanbus.CAR_443_WC2_Jili_Binyue_22 /* 13959611 */:
            case FinalCanbus.CAR_439_OUDI_Beiqi_EC3 /* 14090679 */:
            case FinalCanbus.CAR_439_OUDI_Beiqi_EC5 /* 14156215 */:
            case FinalCanbus.CAR_452_OD_Changcheng_Oula /* 14156228 */:
            case FinalCanbus.CAR_454_OD_Jilie_DihaoS /* 14156230 */:
            case FinalCanbus.CAR_439_OUDI_Beiqi_EC180 /* 14221751 */:
            case FinalCanbus.CAR_454_OD_Zhonghua_V7 /* 14221766 */:
            case FinalCanbus.CAR_439_OUDI_Beiqi_EC220 /* 14287287 */:
            case FinalCanbus.CAR_454_OD_Zhonghua_V7_H /* 14287302 */:
            case FinalCanbus.CAR_439_OUDI_Beiqi_EU5 /* 14352823 */:
            case FinalCanbus.CAR_454_OD_Jilie_YuanchengXingzhi /* 14549446 */:
            case FinalCanbus.CAR_453_RZC_VinFast_PLUS_23 /* 15860165 */:
            case FinalCanbus.CAR_453_OD_Shanqi_ZHongka /* 15991237 */:
            case FinalCanbus.CAR_453_OD_Jili_Dihao_EV /* 16056773 */:
            case FinalCanbus.CAR_439_OD_Futon_Tunland /* 16449975 */:
            case FinalCanbus.CAR_443_WC2_Proton_S70_24 /* 16449979 */:
            case FinalCanbus.CAR_443_WC2_Proton_S70_24_H /* 16515515 */:
            case FinalCanbus.CAR_443_WC2_Proton_X90_24 /* 16581051 */:
            case FinalCanbus.CAR_443_WC2_Proton_X90_24_H /* 16646587 */:
                ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(value).toString());
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(8);
                break;
            case 416:
            case FinalCanbus.CAR_WC2_17MingJue6 /* 65952 */:
            case FinalCanbus.CAR_WC2_RongWei_I5 /* 131488 */:
            case FinalCanbus.CAR_WC2_RongWei_I6 /* 197024 */:
            case FinalCanbus.CAR_WC2_RongWei_EI6 /* 262560 */:
            case FinalCanbus.CAR_WC2_RongWei_RX3 /* 328096 */:
            case FinalCanbus.CAR_WC2_RongWei_HS /* 393632 */:
            case FinalCanbus.CAR_WC2_RongWei_I5_H /* 459168 */:
                if (value == 15) {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText("AUTO");
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(8);
                    break;
                } else {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(value).toString());
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(8);
                    break;
                }
            case FinalCanbus.CAR_RZC_FengGuang18Y580 /* 393530 */:
            case FinalCanbus.CAR_RZC_FengGuang18Y580_H /* 459066 */:
            case FinalCanbus.CAR_RZC_DongFengYiZhi_19EV3 /* 524602 */:
            case FinalCanbus.CAR_RZC_Jiangxi_Wushiling_Mux /* 852282 */:
            case FinalCanbus.CAR_RZC_Jiangxi_FengguangS560_21 /* 1179962 */:
            case FinalCanbus.CAR_RZC_FengGuang21Y580 /* 1245498 */:
            case FinalCanbus.CAR_RZC_FengGuang21Y580_H /* 1311034 */:
            case FinalCanbus.CAR_RZC_FengGuang_580Pro_20 /* 1835322 */:
            case FinalCanbus.CAR_RZC_FengGuang_580Pro_20_H /* 1900858 */:
                if (value == 255) {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText("AUTO");
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(8);
                    break;
                } else {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(value).toString());
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(8);
                    break;
                }
            case FinalCanbus.CAR_452_LZ_Ferrari_430 /* 2556357 */:
                ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(value).toString());
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(4);
                break;
            case FinalCanbus.CAR_452_LZ_Volvo /* 7995844 */:
            case FinalCanbus.CAR_452_LZ_Volvo_10 /* 13631940 */:
            case FinalCanbus.CAR_452_LZ_Volvo_15 /* 16515524 */:
                ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(value).toString());
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(18);
                break;
            case FinalCanbus.CAR_439_OUDI_Falcon_New_Single /* 13042103 */:
            case FinalCanbus.CAR_439_OUDI_Falcon_New_Double /* 13107639 */:
            case FinalCanbus.CAR_439_OUDI_Territory_New_Single /* 13173175 */:
            case FinalCanbus.CAR_439_OUDI_Territory_New_Double /* 13238711 */:
            case FinalCanbus.CAR_439_OUDI_Territory_Old_Double /* 13369783 */:
            case FinalCanbus.CAR_439_OUDI_Falcon_Old_Double /* 13500855 */:
                ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(value).toString());
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(10);
                break;
            case FinalCanbus.CAR_439_OUDI_Territory_Old_Single /* 13304247 */:
            case FinalCanbus.CAR_439_OUDI_Falcon_Old_Single /* 13435319 */:
                ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(value).toString());
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(14);
                break;
            case FinalCanbus.CAR_453_XC_Ford_EDGE_L /* 16122309 */:
            case FinalCanbus.CAR_453_XC_Ford_EDGE_H /* 16187845 */:
                if (value == 29) {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText("AUTO");
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(7);
                    break;
                } else {
                    ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(value).toString());
                    ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(7);
                    break;
                }
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

    
    public void mUpdateHeatLeft() {
        int flag;
        int heatlevel;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT];
        if (DataCanbus.DATA[1000] == 7995844 || DataCanbus.DATA[1000] == 13631940 || DataCanbus.DATA[1000] == 16515524) {
            if ((vel & 8) != 0) {
                heatlevel = 16 - vel;
                flag = 1;
            } else {
                flag = 0;
                heatlevel = vel;
            }
            if (flag == 1) {
                switch (heatlevel) {
                    case 1:
                        findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_1);
                        break;
                    case 2:
                        findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_2);
                        break;
                    case 3:
                        findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_3);
                        break;
                }
            }
            switch (heatlevel) {
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
        if (DataCanbus.DATA[1000] == 65624) {
            switch (vel) {
                case 0:
                    findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_0);
                    break;
                default:
                    findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_3);
                    break;
            }
        }
        if (DataCanbus.DATA[1000] == 9503163 || DataCanbus.DATA[1000] == 9568699 || DataCanbus.DATA[1000] == 16449979 || DataCanbus.DATA[1000] == 16515515 || DataCanbus.DATA[1000] == 16581051 || DataCanbus.DATA[1000] == 16646587) {
            int flag2 = (vel >> 4) & 1;
            int heatlevel2 = vel & 3;
            if (flag2 == 1) {
                findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_0);
                switch (heatlevel2) {
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
            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_0);
            switch (heatlevel2) {
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

    
    public void mUpdateHeatRight() {
        int flag;
        int heatlevel;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_RIGHT];
        if (DataCanbus.DATA[1000] == 7995844 || DataCanbus.DATA[1000] == 13631940 || DataCanbus.DATA[1000] == 16515524) {
            if ((vel & 8) != 0) {
                heatlevel = 16 - vel;
                flag = 1;
            } else {
                flag = 0;
                heatlevel = vel;
            }
            if (flag == 1) {
                switch (heatlevel) {
                    case 1:
                        findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_1);
                        break;
                    case 2:
                        findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_2);
                        break;
                    case 3:
                        findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_3);
                        break;
                }
            }
            switch (heatlevel) {
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
        if (DataCanbus.DATA[1000] == 65624) {
            switch (vel) {
                case 0:
                    findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_left_0);
                    break;
                default:
                    findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_left_3);
                    break;
            }
        }
        if (DataCanbus.DATA[1000] == 9503163 || DataCanbus.DATA[1000] == 9568699 || DataCanbus.DATA[1000] == 16449979 || DataCanbus.DATA[1000] == 16515515 || DataCanbus.DATA[1000] == 16581051 || DataCanbus.DATA[1000] == 16646587) {
            int flag2 = (vel >> 4) & 1;
            int heatlevel2 = vel & 3;
            if (flag2 == 1) {
                findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_0);
                switch (heatlevel2) {
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
            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_0);
            switch (heatlevel2) {
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

    
    public void mUpdateWindLeft() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_LEFT];
        if (DataCanbus.DATA[1000] == 9503163 || DataCanbus.DATA[1000] == 9568699 || DataCanbus.DATA[1000] == 16449979 || DataCanbus.DATA[1000] == 16515515 || DataCanbus.DATA[1000] == 16581051 || DataCanbus.DATA[1000] == 16646587) {
            int flag = (vel >> 4) & 1;
            int heatlevel = vel & 3;
            if (flag == 1) {
                findViewById(R.id.air_sp_seatheat_left).setBackgroundResource(R.drawable.ic_hp_seathot_left_0);
                switch (heatlevel) {
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
            findViewById(R.id.air_sp_seatwind_left).setBackgroundResource(R.drawable.ic_hp_seatblow_left_0);
            switch (heatlevel) {
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

    
    public void mUpdateWindRight() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATWIND_RIGHT];
        if (DataCanbus.DATA[1000] == 9503163 || DataCanbus.DATA[1000] == 9568699 || DataCanbus.DATA[1000] == 16449979 || DataCanbus.DATA[1000] == 16515515 || DataCanbus.DATA[1000] == 16581051 || DataCanbus.DATA[1000] == 16646587) {
            int flag = (vel >> 4) & 1;
            int heatlevel = vel & 3;
            if (flag == 1) {
                findViewById(R.id.air_sp_seatheat_right).setBackgroundResource(R.drawable.ic_hp_seathot_right_0);
                switch (heatlevel) {
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
            findViewById(R.id.air_sp_seatwind_right).setBackgroundResource(R.drawable.ic_hp_seatblow_right_0);
            switch (heatlevel) {
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

    
    public void mUpdateDual() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_DUAL];
        switch (DataCanbus.DATA[1000]) {
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
                findViewById(R.id.air_sp_dual).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_mono_n : R.drawable.ic_hp_mono_p);
                break;
            default:
                findViewById(R.id.air_sp_dual).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_dual_n : R.drawable.ic_hp_dual_p);
                break;
        }
    }

    
    public void mUpdateSYNC() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_SYNC];
        findViewById(R.id.air_sp_sync).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_sync_n : R.drawable.ic_hp_sync_p);
    }

    
    public void mUpdateZONE() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_ZONE];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_Tangdu_Toyota_Lexus_Lx570_10_CD /* 328134 */:
            case FinalCanbus.CAR_454_Tangdu_Toyota_Lexus_Lx570_15_CD /* 393670 */:
            case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_15_TCD /* 459206 */:
            case FinalCanbus.CAR_454_Tangdu_Toyota_LAND_CRUISE_16_TCD /* 524742 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_LAND_CRUISE_15_T /* 11403717 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_LexusLX570_10 /* 11469253 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_LAND_CRUISE_16_T /* 11928005 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_LexusLX570_14 /* 11993541 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_LAND_CRUISE_08_M /* 12255685 */:
            case FinalCanbus.CAR_453_Tangdu_Toyota_LAND_CRUISE_16_M /* 12321221 */:
                findViewById(R.id.air_sp_zone).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_4zone_n : R.drawable.ic_hp_4zone_p);
                break;
            default:
                findViewById(R.id.air_sp_zone).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_zone_n : R.drawable.ic_hp_zone_p);
                break;
        }
    }

    
    public void mUpdateAutoRight() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO_RIGHT];
        findViewById(R.id.air_sp_auto_right).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_auto_n : R.drawable.ic_hp_auto_p);
    }

    
    public void mUpdateAuto() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO];
        findViewById(R.id.air_sp_auto).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_auto_n : R.drawable.ic_hp_auto_p);
    }

    
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC];
        findViewById(R.id.air_sp_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_hp_ac_n : R.drawable.ic_hp_ac_p);
    }

    
    public void mUpdateCycle() {
        int i = R.drawable.ic_hp_cyclein_p;
        int cycle = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE];
        switch (DataCanbus.DATA[1000]) {
            case 416:
            case FinalCanbus.CAR_WC2_17MingJue6 /* 65952 */:
            case FinalCanbus.CAR_WC2_RongWei_I5 /* 131488 */:
            case FinalCanbus.CAR_WC2_RongWei_I6 /* 197024 */:
            case FinalCanbus.CAR_WC2_RongWei_EI6 /* 262560 */:
            case FinalCanbus.CAR_WC2_RongWei_RX3 /* 328096 */:
            case FinalCanbus.CAR_WC2_RongWei_HS /* 393632 */:
            case FinalCanbus.CAR_WC2_RongWei_I5_H /* 459168 */:
            case FinalCanbus.CAR_439_RZC_YinFeiNiDi_QX50 /* 6029751 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX70_13 /* 6685126 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_Q70_16_L /* 6750662 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_Q70_16_H /* 6816198 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_FX50S_09 /* 8389062 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_FX37_13 /* 10224070 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX70_15 /* 10289606 */:
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_QX37_11 /* 10355142 */:
                switch (cycle) {
                    case 0:
                        findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_hp_cycleout_n);
                        break;
                    case 1:
                        findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_hp_cyclein_p);
                        break;
                    case 2:
                        findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_hp_cycleauto_p);
                        break;
                }
            case FinalCanbus.CAR_WeiChi2_17ChangChengH6 /* 131392 */:
            case FinalCanbus.CAR_WeiChi2_18ChangChengH6 /* 196928 */:
            case FinalCanbus.CAR_WeiChi2_ChangChengM6 /* 262464 */:
            case FinalCanbus.CAR_RZC1_MZDRX8 /* 524367 */:
            case FinalCanbus.CAR_WeiChi2_18ChangChengH6_H /* 524608 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_19Copue /* 590144 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_19F7 /* 655680 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_19Copue_H /* 721216 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_19F7_H /* 786752 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_20FJUN7 /* 852288 */:
            case FinalCanbus.CAR_WeiChi2_17ChangChengH6_H /* 917824 */:
            case FinalCanbus.CAR_WeiChi2_ChangChengH2S /* 983360 */:
            case FinalCanbus.CAR_WeiChi2_ChangChengH4 /* 1048896 */:
            case FinalCanbus.CAR_WeiChi2_17ChangChengH6_M /* 1179968 */:
            case FinalCanbus.CAR_WeiChi2_Changcheng_Jingangpao /* 1376576 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_Jingangpao_H /* 1442112 */:
            case FinalCanbus.CAR_WeiChi2_Changcheng_pao /* 1507648 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_JOLION_21 /* 1900864 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_JOLION_21_H /* 1966400 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_F7X_19 /* 2031936 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_F7X_19_H /* 2097472 */:
            case FinalCanbus.CAR_453_LZ_Nissan_Teana_03 /* 2687429 */:
            case FinalCanbus.CAR_453_LZ_Nissan_Teana_03_H /* 2752965 */:
            case FinalCanbus.CAR_453_LZ_Chrysler_300C_15 /* 5571013 */:
            case FinalCanbus.CAR_453_LZ_Maserati_Levante_18 /* 5636549 */:
            case FinalCanbus.CAR_452_LZ_Volvo /* 7995844 */:
            case FinalCanbus.CAR_452_LZ_Maserati_SP /* 12255684 */:
            case FinalCanbus.CAR_452_LZ_Volvo_10 /* 13631940 */:
            case FinalCanbus.CAR_453_LZ_Teana_08_L /* 15532485 */:
            case FinalCanbus.CAR_453_LZ_Teana_08_H /* 15598021 */:
            case FinalCanbus.CAR_453_LZ_Teana_08_TW /* 15663557 */:
            case FinalCanbus.CAR_452_LZ_Volvo_15 /* 16515524 */:
                View findViewById = findViewById(R.id.air_sp_cycle);
                if (cycle != 0) {
                    i = 2130840484;
                }
                findViewById.setBackgroundResource(i);
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
                switch (cycle) {
                    case 0:
                        findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_hp_cycleout_n);
                        break;
                    case 1:
                        findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_hp_cyclein_p);
                        break;
                    case 2:
                        findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_hp_cyclein_lock_p);
                        break;
                    case 3:
                        findViewById(R.id.air_sp_cycle).setBackgroundResource(R.drawable.ic_hp_cyclein_p);
                        break;
                }
            default:
                View findViewById2 = findViewById(R.id.air_sp_cycle);
                if (cycle != 1) {
                    i = 2130840484;
                }
                findViewById2.setBackgroundResource(i);
                break;
        }
    }

    
    public void mUpdateNanoe() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_NANOE];
        findViewById(R.id.air_sp_nanoe).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_nanoe_n : R.drawable.ic_hp_nanoe_p);
    }

    
    public void mUpdateECO() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_ECO];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WC2_TOYOTA_HIGHLANDER /* 327974 */:
            case FinalCanbus.CAR_RZC_XP1_18Carmy /* 524400 */:
            case FinalCanbus.CAR_RZC_XP1_20RAV4 /* 786544 */:
            case FinalCanbus.CAR_RZC_XP1_19Yazhoulong /* 852080 */:
            case FinalCanbus.CAR_RZC_XP1_18Carmy_H /* 917616 */:
            case FinalCanbus.CAR_WC_SP_12LuXun /* 917798 */:
            case FinalCanbus.CAR_RZC_XP1_98_05Lexus_Rx300 /* 983152 */:
            case FinalCanbus.CAR_RZC_XP1_98_03LC100 /* 1114224 */:
            case FinalCanbus.CAR_RZC_XP1_WildLander /* 1245296 */:
            case FinalCanbus.CAR_RZC_XP1_CHR_EV /* 1310832 */:
            case FinalCanbus.CAR_WC_SP_14KaluoLa_ZiDong /* 1311014 */:
            case FinalCanbus.CAR_WC_SP_Alpha /* 1376550 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_NX200_17 /* 1507440 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES200_13 /* 1572976 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_RX270_14 /* 1638512 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES300_05 /* 1704048 */:
            case FinalCanbus.CAR_WC_Toyota_21Sienna /* 1704230 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_RX_09_14 /* 1769584 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES300_20 /* 1835120 */:
            case FinalCanbus.CAR_RZC_XP1_18Carmy_TOP /* 1900656 */:
            case FinalCanbus.CAR_RZC_XP1_22Highlander /* 2097264 */:
            case FinalCanbus.CAR_RZC_XC_Huangguan_14 /* 2162800 */:
            case FinalCanbus.CAR_RZC_XP1_20_LandCruiser /* 2293872 */:
            case FinalCanbus.CAR_RZC_XP1_22_Sienna /* 2424944 */:
            case FinalCanbus.CAR_RZC_XP1_19_Corolla /* 2490480 */:
            case FinalCanbus.CAR_RZC_XP1_20_4Runner /* 2556016 */:
            case FinalCanbus.CAR_RZC_XP1_22_Harrier /* 2621552 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Corolla /* 2621734 */:
            case FinalCanbus.CAR_RZC_XP1_22_CROSS /* 2687088 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Corolla_H /* 2687270 */:
            case FinalCanbus.CAR_RZC_XP1_22_FRONTLANDER /* 2752624 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22Corolla /* 2752806 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_GS_04_07 /* 2818160 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22Corolla_H /* 2818342 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_LS_04_06 /* 2883696 */:
            case FinalCanbus.CAR_RZC_XP1_22_VENZA /* 2949232 */:
            case FinalCanbus.CAR_RZC_Huangguan_14 /* 3014768 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23GRANVIA /* 3014950 */:
            case FinalCanbus.CAR_RZC_XP1_22Highlander_LOW /* 3080304 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23GRANVIA_H /* 3080486 */:
            case FinalCanbus.CAR_RZC_XP1_22_Sienna_LOW /* 3145840 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22Veloz /* 3146022 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22Veloz_H /* 3211558 */:
            case FinalCanbus.CAR_WC2_TOYOTA_21Fortuner /* 3277094 */:
            case FinalCanbus.CAR_WC2_TOYOTA_21Fortuner_H /* 3342630 */:
            case FinalCanbus.CAR_RZC_XP1_05_REIZ /* 3407984 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Innova /* 3408166 */:
            case FinalCanbus.CAR_RZC_XP1_22Highlander_H /* 3473520 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Innova_H /* 3473702 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22RAV4 /* 3539238 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22RAV4_H /* 3604774 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22NOAH /* 3670310 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22NOAH_H /* 3735846 */:
            case FinalCanbus.CAR_RZC_XP1_15_LandCruiser /* 4128880 */:
            case FinalCanbus.CAR_RZC_23_Corolla_Malaysia /* 4194416 */:
            case FinalCanbus.CAR_RZC_23_Vios_Malaysia /* 4259952 */:
            case FinalCanbus.CAR_DUDU_RZC_Toyota_Corolla_14 /* 4325488 */:
            case FinalCanbus.CAR_WC2_TOYOTA_17Fortuner /* 4325670 */:
            case FinalCanbus.CAR_DUDU_RZC_Toyota_RAV4_20_Hand /* 4391024 */:
            case FinalCanbus.CAR_WC2_TOYOTA_13Vellfire /* 4391206 */:
            case FinalCanbus.CAR_DUDU_RZC_Toyota_RAV4_20_Auto /* 4456560 */:
            case FinalCanbus.CAR_WC2_TOYOTA_17Fortuner_H /* 4456742 */:
            case FinalCanbus.CAR_DUDU_RZC_Toyota_Highlander_15_Hand /* 4522096 */:
            case FinalCanbus.CAR_WC2_TOYOTA_13Vellfire_H /* 4522278 */:
            case FinalCanbus.CAR_DUDU_RZC_Toyota_Highlander_15_Auto /* 4587632 */:
            case FinalCanbus.CAR_WC2_TOYOTA_17CHR /* 4587814 */:
            case FinalCanbus.CAR_RZC_Toyota_Prado_02_L /* 4653168 */:
            case FinalCanbus.CAR_WC2_TOYOTA_17CHR_H /* 4653350 */:
            case FinalCanbus.CAR_RZC_Toyota_Prado_02_H /* 4718704 */:
            case FinalCanbus.CAR_WC2_TOYOTA_20Runner /* 4718886 */:
            case FinalCanbus.CAR_RZC_XP1_05_REIZ_H /* 4784240 */:
            case FinalCanbus.CAR_WC2_TOYOTA_20Runner_H /* 4784422 */:
            case FinalCanbus.CAR_RZC_Toyota_Prado_10_CD /* 4849776 */:
            case FinalCanbus.CAR_WC2_TOYOTA_21Sienna_H /* 4849958 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22Harrier /* 4915494 */:
            case FinalCanbus.CAR_RZC_Toyota_LandCruiser_13_ABC /* 4980848 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22Harrier_H /* 4981030 */:
            case FinalCanbus.CAR_RZC_XP1_22_CROSS_H /* 5046384 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22VENZA /* 5046566 */:
            case FinalCanbus.CAR_RZC_XP1_22_FRONTLANDER_H /* 5111920 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22VENZA_H /* 5112102 */:
            case FinalCanbus.CAR_DUDU_RZC_XP1_18Carmy /* 5177456 */:
            case FinalCanbus.CAR_WC2_TOYOTA_21CROWNKLUGER /* 5177638 */:
            case FinalCanbus.CAR_DUDU_RZC_XP1_18Carmy_H /* 5242992 */:
            case FinalCanbus.CAR_WC2_TOYOTA_21CROWNKLUGER_H /* 5243174 */:
            case FinalCanbus.CAR_DUDU_RZC_XP1_18Carmy_TOP /* 5308528 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22COROLLACROSS /* 5308710 */:
            case FinalCanbus.CAR_RZC_XP1_20_Sienta /* 5374064 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22COROLLACROSS_H /* 5374246 */:
            case FinalCanbus.CAR_RZC_XP1_20_Sienta_H /* 5439600 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22Frontlander /* 5439782 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_IS_06 /* 5505136 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22Frontlander_H /* 5505318 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_IS_06_H /* 5570672 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22COROLLA_SA /* 5570854 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES_06 /* 5636208 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22COROLLA_SA_H /* 5636390 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES_06_H /* 5701744 */:
            case FinalCanbus.CAR_WC2_TOYOTA_02Alpha /* 5701926 */:
            case FinalCanbus.CAR_RZC_Toyota_PRIUS_CD /* 5767280 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Yaris_ASEAN /* 5767462 */:
            case FinalCanbus.CAR_RZC_Toyota_PRIUS_NOCD /* 5832816 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Yaris_ASEAN_H /* 5832998 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_LS460 /* 5898352 */:
            case FinalCanbus.CAR_WC2_TOYOTA_TMK_BENZ_EV_ALL /* 5898534 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_LS460_H /* 5963888 */:
            case FinalCanbus.CAR_WC2_TOYOTA_13Harrier_ASEAN /* 5964070 */:
            case FinalCanbus.CAR_RZC_XP1_LC100 /* 6029424 */:
            case FinalCanbus.CAR_WC2_TOYOTA_16Sienna /* 6029606 */:
            case FinalCanbus.CAR_RZC_XP1_LC100_H /* 6094960 */:
            case FinalCanbus.CAR_WC2_TOYOTA_17Sienna_NA /* 6095142 */:
            case FinalCanbus.CAR_RZC_XP1_23_VOXY_H /* 6160496 */:
            case FinalCanbus.CAR_WC2_TOYOTA_21Tacoma_NA /* 6160678 */:
            case FinalCanbus.CAR_RZC_XP1_23_VOXY /* 6226032 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22Camery_NA /* 6226214 */:
            case FinalCanbus.CAR_RZC_XP1_23_NOAH_H /* 6291568 */:
            case FinalCanbus.CAR_WC2_TOYOTA_18Prius_NA /* 6291750 */:
            case FinalCanbus.CAR_RZC_XP1_23_NOAH /* 6357104 */:
            case FinalCanbus.CAR_WC2_TOYOTA_16PriusV_NA /* 6357286 */:
            case FinalCanbus.CAR_RZC_Toyota_Corolla_CROSS_23_H /* 6422640 */:
            case FinalCanbus.CAR_WC2_TOYOTA_21RAV4_NA /* 6422822 */:
            case FinalCanbus.CAR_RZC_Toyota_Corolla_CROSS_23 /* 6488176 */:
            case FinalCanbus.CAR_WC2_TOYOTA_18IZOA /* 6488358 */:
            case FinalCanbus.CAR_RZC_TOYOTA_21Fortuner_ASEAN /* 6553712 */:
            case FinalCanbus.CAR_WC2_TOYOTA_18IZOA_H /* 6553894 */:
            case FinalCanbus.CAR_RZC_TOYOTA_21Fortuner_ASEAN_H /* 6619248 */:
            case FinalCanbus.CAR_WC2_TOYOTA_13Yaris /* 6619430 */:
            case FinalCanbus.CAR_454_LZ_TOYOTA_LC300_KycAir /* 6619590 */:
            case FinalCanbus.CAR_RZC_TOYOTA_23Yaris_ASEAN /* 6684784 */:
            case FinalCanbus.CAR_WC2_TOYOTA_21Yaris /* 6684966 */:
            case FinalCanbus.CAR_RZC_TOYOTA_23Yaris_ASEAN_H /* 6750320 */:
            case FinalCanbus.CAR_WC2_TOYOTA_10ReiZ /* 6750502 */:
            case FinalCanbus.CAR_RZC_TOYOTA_23Veloz_ASEAN /* 6815856 */:
            case FinalCanbus.CAR_WC2_TOYOTA_14ReiZ /* 6816038 */:
            case FinalCanbus.CAR_RZC_TOYOTA_23Veloz_ASEAN_H /* 6881392 */:
            case FinalCanbus.CAR_WC2_TOYOTA_13Prius /* 6881574 */:
            case FinalCanbus.CAR_RZC_TOYOTA_23Innova_ASEAN /* 6946928 */:
            case FinalCanbus.CAR_WC2_TOYOTA_14PRADO /* 6947110 */:
            case FinalCanbus.CAR_RZC_TOYOTA_23Innova_ASEAN_H /* 7012464 */:
            case FinalCanbus.CAR_WC2_TOYOTA_10Avalon /* 7012646 */:
            case FinalCanbus.CAR_WC2_TOYOTA_15Avalon /* 7078182 */:
            case FinalCanbus.CAR_RZC_23_Corolla_Malaysia_H /* 7143536 */:
            case FinalCanbus.CAR_WC2_TOYOTA_19Avalon /* 7143718 */:
            case FinalCanbus.CAR_RZC_23_Vios_Malaysia_H /* 7209072 */:
            case FinalCanbus.CAR_WC2_TOYOTA_10Sienna /* 7209254 */:
            case FinalCanbus.CAR_WC2_TOYOTA_15Sienna /* 7274790 */:
            case FinalCanbus.CAR_RZC_TOYOTA_23Granvia /* 7340144 */:
            case FinalCanbus.CAR_WC2_TOYOTA_21Sienna_NA /* 7340326 */:
            case FinalCanbus.CAR_RZC_TOYOTA_23Granvia_H /* 7405680 */:
            case FinalCanbus.CAR_WC2_TOYOTA_10Sequoia /* 7405862 */:
            case FinalCanbus.CAR_RZC_TOYOTA_Alpha_17 /* 7471216 */:
            case FinalCanbus.CAR_WC2_TOYOTA_14Tundra /* 7471398 */:
            case FinalCanbus.CAR_WC2_TOYOTA_18Tundra /* 7536934 */:
            case FinalCanbus.CAR_RZC_Toyota_Corolla_cross_America /* 7602288 */:
            case FinalCanbus.CAR_WC2_TOYOTA_16Hilux /* 7602470 */:
            case FinalCanbus.CAR_RZC_Toyota_Corolla_cross_AmericaH /* 7667824 */:
            case FinalCanbus.CAR_WC2_TOYOTA_16LuXun /* 7668006 */:
            case FinalCanbus.CAR_RZC_Toyota_Prado_24 /* 7733360 */:
            case FinalCanbus.CAR_WC2_TOYOTA_19ProACECity /* 7733542 */:
            case FinalCanbus.CAR_RZC_Toyota_Prado_24_H /* 7798896 */:
            case FinalCanbus.CAR_WC2_TOYOTA_07Previa /* 7799078 */:
            case FinalCanbus.CAR_RZC_Toyota_RAV4_24 /* 7864432 */:
            case FinalCanbus.CAR_WC2_TOYOTA_21HIACE /* 7864614 */:
            case FinalCanbus.CAR_RZC_Toyota_RAV4_24_H /* 7929968 */:
            case FinalCanbus.CAR_WC2_TOYOTA_20Willander /* 7930150 */:
            case FinalCanbus.CAR_WC2_TOYOTA_15Crown /* 7995686 */:
            case FinalCanbus.CAR_RZC_XP1_22_Harrier_H /* 8061040 */:
            case FinalCanbus.CAR_WC2_TOYOTA_14Levin /* 8061222 */:
            case FinalCanbus.CAR_WC2_TOYOTA_19Levin /* 8126758 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Altis /* 8192294 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Altis_H /* 8257830 */:
                findViewById(R.id.air_sp_eco).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_eco_toyota_n : R.drawable.ic_hp_eco_toyota_p);
                break;
            default:
                findViewById(R.id.air_sp_eco).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_eco_n : R.drawable.ic_hp_eco_p);
                break;
        }
    }

    
    public void mUpdateFlowerBlow() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FLOWER_BLOW];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WeiChi2_ChangCheng_JOLION_21 /* 1900864 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_JOLION_21_H /* 1966400 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_F7X_19 /* 2031936 */:
            case FinalCanbus.CAR_WeiChi2_ChangCheng_F7X_19_H /* 2097472 */:
                switch (rear) {
                    case 0:
                        findViewById(R.id.air_sp_flowerblow).setBackgroundResource(R.drawable.ic_hp_soft_p);
                        break;
                    case 1:
                        findViewById(R.id.air_sp_flowerblow).setBackgroundResource(R.drawable.ic_hp_normal_p);
                        break;
                    case 2:
                        findViewById(R.id.air_sp_flowerblow).setBackgroundResource(R.drawable.ic_hp_fast_p);
                        break;
                }
            case FinalCanbus.CAR_454_RZC_YinFeiNiDi_Q70_16_H /* 6816198 */:
                findViewById(R.id.air_sp_flowerblow).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_blowhead_n : R.drawable.ic_hp_blowhead_p);
                break;
            case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_L /* 14614971 */:
            case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_M /* 14680507 */:
            case FinalCanbus.CAR_443_WC2_LeepMotor_T03_22_H /* 14746043 */:
                findViewById(R.id.air_sp_flowerblow).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_ventilation_n : R.drawable.ic_hp_ventilation_p);
                break;
            default:
                findViewById(R.id.air_sp_flowerblow).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_flowerblow_n : R.drawable.ic_hp_flowerblow_p);
                break;
        }
    }

    
    public void mUpdateAirPark() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_PARK];
        findViewById(R.id.air_sp_airpark).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_airpark_n : R.drawable.ic_hp_airpark_p);
    }

    
    public void mUpdateAirRest() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_REST];
        findViewById(R.id.air_sp_rest).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_rest_n : R.drawable.ic_hp_rest_p);
    }

    
    public void mUpdateAirOnlyFront() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT_ONLY];
        findViewById(R.id.air_sp_onlyfront).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_onlyfront_n : R.drawable.ic_hp_onlyfront_p);
    }

    
    public void mUpdateAirOnlyFront_F() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT_ONLY_F];
        findViewById(R.id.air_sp_onlyfront_front).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_onlyfront_n : R.drawable.ic_hp_onlyfront_p);
    }

    
    public void mUpdateAirRearCool() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR_COOL];
        findViewById(R.id.air_sp_rear_cool).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_rearcool_n : R.drawable.ic_hp_rearcool_p);
    }

    
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

    
    public void mUpdateAirSwing() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_SWING];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_XP1_18Carmy /* 524400 */:
            case FinalCanbus.CAR_RZC_XP1_20RAV4 /* 786544 */:
            case FinalCanbus.CAR_RZC_XP1_19Yazhoulong /* 852080 */:
            case FinalCanbus.CAR_RZC_XP1_18Carmy_H /* 917616 */:
            case FinalCanbus.CAR_RZC_XP1_98_05Lexus_Rx300 /* 983152 */:
            case FinalCanbus.CAR_RZC_XP1_98_03LC100 /* 1114224 */:
            case FinalCanbus.CAR_RZC_XP1_WildLander /* 1245296 */:
            case FinalCanbus.CAR_RZC_XP1_CHR_EV /* 1310832 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_NX200_17 /* 1507440 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES200_13 /* 1572976 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_RX270_14 /* 1638512 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES300_05 /* 1704048 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_RX_09_14 /* 1769584 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES300_20 /* 1835120 */:
            case FinalCanbus.CAR_RZC_XP1_18Carmy_TOP /* 1900656 */:
            case FinalCanbus.CAR_RZC_XP1_22Highlander /* 2097264 */:
            case FinalCanbus.CAR_RZC_XC_Huangguan_14 /* 2162800 */:
            case FinalCanbus.CAR_RZC_XP1_20_LandCruiser /* 2293872 */:
            case FinalCanbus.CAR_RZC_XP1_22_Sienna /* 2424944 */:
            case FinalCanbus.CAR_RZC_XP1_19_Corolla /* 2490480 */:
            case FinalCanbus.CAR_RZC_XP1_20_4Runner /* 2556016 */:
            case FinalCanbus.CAR_RZC_XP1_22_Harrier /* 2621552 */:
            case FinalCanbus.CAR_RZC_XP1_22_CROSS /* 2687088 */:
            case FinalCanbus.CAR_RZC_XP1_22_FRONTLANDER /* 2752624 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_GS_04_07 /* 2818160 */:
            case FinalCanbus.CAR_RZC_XP1_22_VENZA /* 2949232 */:
            case FinalCanbus.CAR_RZC_Huangguan_14 /* 3014768 */:
            case FinalCanbus.CAR_RZC_XP1_22Highlander_LOW /* 3080304 */:
            case FinalCanbus.CAR_RZC_XP1_22_Sienna_LOW /* 3145840 */:
            case FinalCanbus.CAR_RZC_XP1_05_REIZ /* 3407984 */:
            case FinalCanbus.CAR_RZC_XP1_22Highlander_H /* 3473520 */:
            case FinalCanbus.CAR_RZC_23_Corolla_Malaysia /* 4194416 */:
            case FinalCanbus.CAR_RZC_23_Vios_Malaysia /* 4259952 */:
            case FinalCanbus.CAR_DUDU_RZC_Toyota_Corolla_14 /* 4325488 */:
            case FinalCanbus.CAR_DUDU_RZC_Toyota_RAV4_20_Hand /* 4391024 */:
            case FinalCanbus.CAR_DUDU_RZC_Toyota_RAV4_20_Auto /* 4456560 */:
            case FinalCanbus.CAR_DUDU_RZC_Toyota_Highlander_15_Hand /* 4522096 */:
            case FinalCanbus.CAR_DUDU_RZC_Toyota_Highlander_15_Auto /* 4587632 */:
            case FinalCanbus.CAR_RZC_Toyota_Prado_02_L /* 4653168 */:
            case FinalCanbus.CAR_RZC_Toyota_Prado_02_H /* 4718704 */:
            case FinalCanbus.CAR_RZC_XP1_05_REIZ_H /* 4784240 */:
            case FinalCanbus.CAR_RZC_Toyota_Prado_10_CD /* 4849776 */:
            case FinalCanbus.CAR_RZC_XP1_22_CROSS_H /* 5046384 */:
            case FinalCanbus.CAR_RZC_XP1_22_FRONTLANDER_H /* 5111920 */:
            case FinalCanbus.CAR_DUDU_RZC_XP1_18Carmy /* 5177456 */:
            case FinalCanbus.CAR_DUDU_RZC_XP1_18Carmy_H /* 5242992 */:
            case FinalCanbus.CAR_DUDU_RZC_XP1_18Carmy_TOP /* 5308528 */:
            case FinalCanbus.CAR_RZC_XP1_20_Sienta /* 5374064 */:
            case FinalCanbus.CAR_RZC_XP1_20_Sienta_H /* 5439600 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_IS_06 /* 5505136 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_IS_06_H /* 5570672 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES_06 /* 5636208 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_ES_06_H /* 5701744 */:
            case FinalCanbus.CAR_RZC_Toyota_PRIUS_NOCD /* 5832816 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_LS460 /* 5898352 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_LS460_H /* 5963888 */:
            case FinalCanbus.CAR_RZC_XP1_LC100 /* 6029424 */:
            case FinalCanbus.CAR_RZC_XP1_LC100_H /* 6094960 */:
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
                findViewById(R.id.air_sp_swing).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_swing_toyota_n : R.drawable.ic_hp_swing_toyota_p);
                break;
            default:
                findViewById(R.id.air_sp_swing).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_swing_n : R.drawable.ic_hp_swing_p);
                break;
        }
    }

    
    public void mUpdateRearDefrost() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR];
        findViewById(R.id.air_sp_rear).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_rear_n : R.drawable.ic_hp_rear_p);
    }

    
    public void mUpdateFrontDefrost() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_LZ_TOYOTA_LC300_KycAir /* 6619590 */:
            case FinalCanbus.CAR_453_OD_Ford_PRO_23 /* 8389061 */:
                findViewById(R.id.air_sp_front).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_maxfront_n : R.drawable.ic_hp_maxfront_p);
                break;
            default:
                findViewById(R.id.air_sp_front).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_front_n : R.drawable.ic_hp_front_p);
                break;
        }
    }

    
    public void mUpdateMaxFrontDefrost() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONTMAX];
        findViewById(R.id.air_sp_frontmax).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_maxfront_n : R.drawable.ic_hp_maxfront_p);
    }

    
    public void mUpdatePower() {
        int value = DataCanbus.DATA[ConstAllAirDara.U_AIR_POWER];
        if (this.pagenum == 1) {
            value = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_POWER];
        }
        findViewById(R.id.air_sp_power).setBackgroundResource(value == 0 ? R.drawable.ic_hp_power_n : R.drawable.ic_hp_power_p);
    }

    
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

    
    public void updateBlowModeLeft() {
        int mode;
        int mode2;
        int mode3;
        int i = R.drawable.ic_hp_mode_win_n;
        int win = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_LEFT];
        int body = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_LEFT];
        int foot = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT];
        int auto = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_AUTO_LEFT];
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
        if (ConstAllAirDara.C_AIR_MODE_CENTER != 255) {
            switch (DataCanbus.DATA[1000]) {
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
                    findViewById(R.id.air_sp_blow_changer_center).setBackgroundResource(win == 1 ? R.drawable.ic_hp_mode_win_p : 2130840530);
                    break;
                default:
                    findViewById(R.id.air_sp_blow_changer_center).setBackgroundResource(R.drawable.ic_hp_mode_win_foot_n);
                    switch (mode3) {
                        case 5:
                            findViewById(R.id.air_sp_blow_changer_center).setBackgroundResource(R.drawable.ic_hp_mode_win_foot_p);
                            break;
                    }
            }
        }
        if (ConstAllAirDara.C_AIR_MODE_BODYFOOT == 255 && ConstAllAirDara.C_AIR_MODE_UPFOOT == 255) {
            View findViewById = findViewById(R.id.air_sp_blow_win);
            if (win == 1) {
                i = R.drawable.ic_hp_mode_win_p;
            }
            findViewById.setBackgroundResource(i);
            findViewById(R.id.air_sp_blow_body).setBackgroundResource(body == 1 ? R.drawable.ic_hp_mode_body_p : R.drawable.ic_hp_mode_body_n);
            findViewById(R.id.air_sp_blow_foot).setBackgroundResource(foot == 1 ? R.drawable.ic_hp_mode_foot_p : R.drawable.ic_hp_mode_foot_n);
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
        findViewById(R.id.air_sp_mode_foot).setVisibility(foot == 0 ? 8 : 0);
        findViewById(R.id.air_sp_mode_auto).setVisibility(auto == 0 ? 8 : 0);
        if (ConstAllAirDara.U_AIR_BLOW_UP_RIGHT == 255 && ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT == 255 && ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT == 255) {
            findViewById(R.id.air_sp_mode_up_right).setVisibility(win == 0 ? 8 : 0);
            findViewById(R.id.air_sp_mode_body_right).setVisibility(body == 0 ? 8 : 0);
            findViewById(R.id.air_sp_mode_foot_right).setVisibility(foot == 0 ? 8 : 0);
            findViewById(R.id.air_sp_mode_auto_right).setVisibility(auto != 0 ? 0 : 8);
        }
    }

    
    public void updateBlowModeRight() {
        int mode;
        int mode2;
        int mode3;
        int win = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_UP_RIGHT];
        int body = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT];
        int foot = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT];
        int auto = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOW_AUTO_RIGHT];
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
        if (ConstAllAirDara.C_AIR_MODE_CENTER != 255) {
            switch (DataCanbus.DATA[1000]) {
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
                    findViewById(R.id.air_sp_blow_changer_center).setBackgroundResource(win == 1 ? R.drawable.ic_hp_mode_win_p : R.drawable.ic_hp_mode_win_n);
                    break;
                default:
                    findViewById(R.id.air_sp_blow_changer_center).setBackgroundResource(R.drawable.ic_hp_mode_win_foot_n);
                    switch (mode3) {
                        case 5:
                            findViewById(R.id.air_sp_blow_changer_center).setBackgroundResource(R.drawable.ic_hp_mode_win_foot_p);
                            break;
                    }
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
