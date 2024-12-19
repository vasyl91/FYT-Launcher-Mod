package com.syu.carinfo.air;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemProperties;
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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Air_Activity_All_Toyota_prado_HP extends Activity implements View.OnTouchListener {
    public static Air_Activity_All_Toyota_prado_HP mInstance;
    public static boolean mIsFront = false;
    int pagenum = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.air.Air_Activity_All_Toyota_prado_HP.1
        @Override // com.syu.module.IUiNotify
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
            if (updateCode == ConstAllAirDara.U_AIR_FRONT_ONLY) {
                Air_Activity_All_Toyota_prado_HP.this.mUpdateAirOnlyFront();
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
            if (updateCode != ConstAllAirDara.U_AIR_BACK_BLOW_UP_RIGHT && updateCode != ConstAllAirDara.U_AIR_BACK_BLOW_BODY_RIGHT && updateCode != ConstAllAirDara.U_AIR_BACK_BLOW_FOOT_RIGHT) {
                return;
            }
            Air_Activity_All_Toyota_prado_HP.this.updateBlowBackModeRight();
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_air_hp_all_prado);
        initCallbackId();
        init();
        mInstance = this;
    }

    private void sendCmd(int data0, int data1) {
        int ints3;
        int ints4;
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
            case FinalCanbus.CAR_453_XP1_ZH2_Ford_Explorer_13_Hand /* 1900997 */:
            case FinalCanbus.CAR_453_XP1_ZH2_Ford_Explorer_13_Auto /* 1966533 */:
            case FinalCanbus.CAR_453_XP1_ZH2_Ford_Explorer_16_Hand /* 2032069 */:
            case FinalCanbus.CAR_453_XP1_ZH2_Ford_Explorer_16_Auto /* 2097605 */:
            case FinalCanbus.CAR_RZC_HONDA_23Yage /* 4260138 */:
            case FinalCanbus.CAR_453_XP1_Ford_Edge_2013 /* 4260293 */:
            case FinalCanbus.CAR_453_XP1_Ford_F150_2013 /* 4325829 */:
            case FinalCanbus.CAR_453_XP1_Ford_Explorer_2013 /* 4391365 */:
            case FinalCanbus.CAR_453_XP1_Ford_Taurus_2013 /* 4456901 */:
            case FinalCanbus.CAR_453_XP1_Ford_Expedition_2013 /* 4522437 */:
            case FinalCanbus.CAR_453_XP1_Ford_Edge_2015 /* 4587973 */:
            case FinalCanbus.CAR_453_XP1_Ford_Mustang_2015 /* 4653509 */:
            case FinalCanbus.CAR_452_LZ_Ford_Mustang /* 11403716 */:
            case FinalCanbus.CAR_453_XP_Ford_All_RP3_Hand1 /* 13107653 */:
            case FinalCanbus.CAR_453_XP_Ford_All_RP3_Hand2 /* 13173189 */:
            case FinalCanbus.CAR_453_XP_Ford_All_RP3_Auto1 /* 13238725 */:
            case FinalCanbus.CAR_453_XP_Ford_All_RP3_Auto2 /* 13304261 */:
            case FinalCanbus.CAR_452_LZ_Ford_Mustang_H /* 14090692 */:
            case FinalCanbus.CAR_XP1_ZH2_RUIJIE2015 /* 14680516 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{172, data0}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{172}, null, null);
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
            case FinalCanbus.CAR_RZC4_PSA_04_407 /* 1638739 */:
            case FinalCanbus.CAR_RZC4_PSA_04_407_CD /* 1704275 */:
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
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{1, data0}, null, null);
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
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS_20 /* 2293899 */:
            case FinalCanbus.CAR_RZC_XP1_Jiaji_21 /* 2424971 */:
            case FinalCanbus.CAR_452_OD_Ruilan_X3_Pro /* 2425285 */:
            case FinalCanbus.CAR_RZC_XP1_Binrui_20 /* 2490507 */:
            case FinalCanbus.CAR_452_OD_Jihe_EX3 /* 2490821 */:
            case FinalCanbus.CAR_RZC_XP1_Haoyue_20 /* 2556043 */:
            case FinalCanbus.CAR_RZC_Xiongmao_Mini_23 /* 2818187 */:
            case FinalCanbus.CAR_453_OD_Jili_Panda_Mini /* 8454597 */:
            case FinalCanbus.CAR_453_OD_Jili_Dihao_EV /* 16056773 */:
                int ints0 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints02 = ints0 | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_AC_MAX ? 1 : 0);
                int ints1 = 0 | (data0 == ConstAllAirDara.C_AIR_DUAL ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0);
                int ints2 = 0 | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 1 : 0);
                int ints32 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints42 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                int ints43 = ints42 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_452_OD_Ruilan_X3_Pro /* 2425285 */:
                    case FinalCanbus.CAR_452_OD_Jihe_EX3 /* 2490821 */:
                    case FinalCanbus.CAR_453_OD_Jili_Panda_Mini /* 8454597 */:
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
                    int value = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] + 1;
                    if (value > 8) {
                        value = 8;
                    }
                    ints1 = value << 4;
                } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                    int value2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] - 1;
                    if (value2 < 0) {
                        value2 = 0;
                    }
                    ints1 = value2 << 4;
                }
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints02, ints1, ints2, ints32, ints43, ints54}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                    break;
                }
            case FinalCanbus.CAR_Oudi_XP1_FengGuang17Y580 /* 196922 */:
            case FinalCanbus.CAR_Oudi_XP1_FengGuang17Y560 /* 1507642 */:
            case FinalCanbus.CAR_Oudi_XP1_FengGuang17S560 /* 1638714 */:
                if (data1 == 1) {
                    int ints03 = 0;
                    int ints12 = 0;
                    if (data0 == ConstAllAirDara.C_AIR_POWER) {
                        ints03 = 168;
                        ints12 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        ints03 = 160;
                        ints12 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        ints03 = 160;
                        ints12 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD || data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                        ints03 = 161;
                        ints12 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB || data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                        ints03 = 161;
                        ints12 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODY) {
                        ints03 = 163;
                        ints12 = 0;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT) {
                        ints03 = 163;
                        ints12 = 1;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT) {
                        ints03 = 163;
                        ints12 = 2;
                    } else if (data0 == ConstAllAirDara.C_AIR_MODE_FOOT) {
                        ints03 = 163;
                        ints12 = 3;
                    } else if (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST) {
                        ints03 = 163;
                        ints12 = 4;
                    } else if (data0 == ConstAllAirDara.C_AIR_AC) {
                        ints03 = 164;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 1) {
                            ints12 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AC] == 0) {
                            ints12 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                        ints03 = 165;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1) {
                            ints12 = 1;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 0) {
                            ints12 = 0;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST) {
                        ints03 = 167;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 1) {
                            ints12 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_REAR] == 0) {
                            ints12 = 1;
                        }
                    } else if (data0 == ConstAllAirDara.C_AIR_AUTO) {
                        ints03 = 169;
                        if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 1) {
                            ints12 = 0;
                        } else if (DataCanbus.DATA[ConstAllAirDara.U_AIR_AUTO] == 0) {
                            ints12 = 1;
                        }
                    }
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints03, ints12}, null, null);
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
                int ints04 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints05 = ints04 | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_AC_MAX ? 1 : 0);
                int ints13 = 0 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints22 = 0 | (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT ? 16 : 0);
                int ints23 = ints22 | (data0 == ConstAllAirDara.C_AIR_MODE_FOOT ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_BODY ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 1 : 0);
                int ints33 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints55 = 0 | (data0 == ConstAllAirDara.C_AIR_PTC ? 128 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints05, ints13, ints23, ints33, 0, ints55}, null, null);
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
                int ints44 = 0;
                int ints06 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints07 = ints06 | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_AC_MAX ? 1 : 0);
                int ints14 = 0 | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 4 : 0);
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
                    ints14 = ints14 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                }
                int ints24 = 0 | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 1 : 0);
                int ints34 = 0 | (data0 == ConstAllAirDara.C_AIR_HEAT ? 128 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints07, ints14, ints24, ints34, ints44}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[5], null, null);
                    break;
                }
            case FinalCanbus.CAR_RZC_BenTeng_OLDB50 /* 786845 */:
            case FinalCanbus.CAR_453_RZC_VinFast_PLUS_23 /* 15860165 */:
                int ints08 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints09 = ints08 | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_AC_MAX ? 1 : 0);
                int ints15 = 0 | (data0 == ConstAllAirDara.C_AIR_DUAL ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints25 = 0 | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 1 : 0);
                int ints35 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                int ints45 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                int ints46 = ints45 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                int ints56 = 0 | (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT ? 2 : 0);
                int ints57 = ints56 | (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT ? 1 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints09, ints15, ints25, ints35, ints46, ints57}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                    break;
                }
            case FinalCanbus.CAR_WC2_RENAULT_Jinbei_Guanjing /* 1180000 */:
                boolean flag = false;
                int value3 = 0;
                if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                    value3 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                    if (value3 < 7) {
                        value3++;
                    }
                    data0 = 39;
                    flag = true;
                } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                    value3 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                    if (value3 > 0) {
                        value3--;
                    }
                    data0 = 39;
                    flag = true;
                } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD) {
                    int tempAll = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT];
                    if (tempAll == -3) {
                        value3 = 255;
                    } else if (tempAll == -2 || tempAll == 0) {
                        value3 = 33;
                    } else {
                        int value4 = tempAll / 5;
                        value3 = value4 + 1;
                        if (value3 > 63) {
                            value3 = 255;
                        }
                    }
                    data0 = 37;
                    flag = true;
                } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                    int tempAll2 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT];
                    if (tempAll2 == -3) {
                        value3 = 63;
                    } else if (tempAll2 == -2 || tempAll2 == 0) {
                        value3 = 254;
                    } else {
                        int value5 = tempAll2 / 5;
                        value3 = value5 - 1;
                        if (value3 < 33) {
                            value3 = 254;
                        }
                    }
                    data0 = 37;
                    flag = true;
                }
                if (flag) {
                    if (data1 == 1) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, value3}, null, null);
                        break;
                    }
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                    break;
                }
            case FinalCanbus.CAR_RZC_XP1_22Highlander /* 2097264 */:
            case FinalCanbus.CAR_RZC_XP1_22_Sienna /* 2424944 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_LS_04_06 /* 2883696 */:
            case FinalCanbus.CAR_RZC_XP1_22_VENZA /* 2949232 */:
            case FinalCanbus.CAR_RZC_XP1_22Highlander_LOW /* 3080304 */:
            case FinalCanbus.CAR_RZC_XP1_22_Sienna_LOW /* 3145840 */:
            case FinalCanbus.CAR_RZC_XP1_22Highlander_H /* 3473520 */:
            case FinalCanbus.CAR_RZC_XP1_15_LandCruiser /* 4128880 */:
                int ints010 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints011 = ints010 | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT ? 8 : 0) | (data0 == ConstAllAirDara.C_CLEAN ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0);
                int ints16 = 0 | (data0 == ConstAllAirDara.C_AIR_ION ? 128 : 0) | (data0 == ConstAllAirDara.C_AIR_SWING ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_FLOWER_BLOW ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_HOT ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_ZONE ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_DUAL ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_WIND_SUB ? 1 : 0);
                int ints26 = 0 | (data0 == ConstAllAirDara.C_AIR_LEFT_COLD ? 64 : 0);
                int ints27 = ints26 | (data0 == ConstAllAirDara.C_AIR_RIGHT_COLD ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_RIGHT_HEAT ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 1 : 0);
                if (SystemProperties.getBoolean("persist.fyt.reversetemp", false)) {
                    int ints47 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0);
                    ints4 = ints47 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                    ints3 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                } else {
                    ints3 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB ? 1 : 0);
                    int ints48 = 0 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD ? 2 : 0);
                    ints4 = ints48 | (data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB ? 1 : 0);
                }
                int ints49 = ints4 | (data0 == ConstAllAirDara.C_AIR_FRONT_ONLY ? 64 : 0) | (data0 == ConstAllAirDara.C_REAR_RIGHT_TEMP_UP ? 32 : 0) | (data0 == ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_ECO ? 4 : 0);
                int ints58 = 0 | (data0 == ConstAllAirDara.C_REAR_OFF ? 64 : 0);
                int ints59 = ints58 | (data0 == ConstAllAirDara.C_REAR_WIND_UP ? 32 : 0) | (data0 == ConstAllAirDara.C_REAR_WIND_DOWN ? 16 : 0) | (data0 == ConstAllAirDara.C_REAR_MODE ? 8 : 0) | (data0 == ConstAllAirDara.C_REAR_AUTO ? 4 : 0) | (data0 == ConstAllAirDara.C_REAR_LEFT_TEMP_UP ? 2 : 0) | (data0 == ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN ? 1 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints011, ints16, ints27, ints3, ints49, ints59, 0}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[7], null, null);
                    break;
                }
            case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5 /* 2818501 */:
            case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5_H /* 2884037 */:
            case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5 /* 3015109 */:
            case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5_H /* 3080645 */:
                int ints17 = 0;
                int ints36 = 0;
                int ints410 = 0;
                int ints012 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints013 = ints012 | (data0 == ConstAllAirDara.C_AIR_REAR_DEFROST ? 64 : 0) | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_AC_MAX ? 1 : 0);
                int ints28 = 0 | (data0 == ConstAllAirDara.C_AIR_MODE_BODY ? 1 : 0);
                int ints29 = ints28 | (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_FOOT ? 3 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_UP ? 5 : 0);
                if (data0 == ConstAllAirDara.C_AIR_CYCLE) {
                    ints013 = DataCanbus.DATA[ConstAllAirDara.U_AIR_CYCLE] == 1 ? 8 : 4;
                } else if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] < 8) {
                        ints17 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] + 1;
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] > 0) {
                        ints17 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT] - 1;
                    }
                } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD || data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD) {
                    ints36 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] == -2 ? 2 : DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] == -3 ? 16 : (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] < 18 || DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] > 31) ? 1 : DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] - 15;
                } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB || data0 == ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB) {
                    ints36 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] == -2 ? 1 : DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] == -3 ? 15 : (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] < 18 || DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] > 31) ? 1 : DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT] - 17;
                } else if (data0 == ConstAllAirDara.C_AIR_LEFT_HEAT && (ints410 = DataCanbus.DATA[ConstAllAirDara.U_AIR_SEATHEAT_LEFT] + 2) > 4) {
                    ints410 = 1;
                }
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints013, ints17, ints29, ints36, ints410, 0}, null, null);
                    break;
                } else if (data1 == 0) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[6], null, null);
                    break;
                }
            case FinalCanbus.CAR_WC2_Honda_17Acura_MDX /* 3014977 */:
                boolean flag2 = false;
                int value6 = 0;
                if (data1 == 1) {
                    if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                        value6 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                        if (value6 < 7) {
                            value6++;
                        }
                        data0 = 25;
                        flag2 = true;
                    } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                        value6 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                        if (value6 > 0) {
                            value6--;
                        }
                        data0 = 25;
                        flag2 = true;
                    } else if (data0 == ConstAllAirDara.C_AIR_AC) {
                        int value7 = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC];
                        if (value7 == 0) {
                            value6 = 1;
                        } else {
                            value6 = 0;
                        }
                        flag2 = true;
                    }
                    if (flag2) {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, value6}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                        break;
                    }
                } else if (data0 != ConstAllAirDara.C_AIR_WIND_ADD && data0 != ConstAllAirDara.C_AIR_WIND_SUB && data0 != ConstAllAirDara.C_AIR_AC) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0, data1}, null, null);
                    break;
                }
            case FinalCanbus.CAR_439_HC_RongWei950 /* 4129207 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{7, data0}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{7}, null, null);
                    break;
                }
            case FinalCanbus.CAR_439_RZC_LufengXiaoyao /* 4325815 */:
                int ints18 = 0;
                int ints37 = 0;
                boolean flag3 = false;
                int ints014 = 0 | (data0 == ConstAllAirDara.C_AIR_POWER ? 128 : 0);
                int ints015 = ints014 | (data0 == ConstAllAirDara.C_AIR_AUTO ? 32 : 0) | (data0 == ConstAllAirDara.C_AIR_FRONT_DEFROST ? 16 : 0) | (data0 == ConstAllAirDara.C_AIR_AC ? 2 : 0);
                if (data0 == ConstAllAirDara.C_AIR_WIND_ADD) {
                    int vuale3 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                    if (vuale3 < 7) {
                        vuale3++;
                    }
                    ints18 = (vuale3 << 4) & 240;
                    flag3 = true;
                } else if (data0 == ConstAllAirDara.C_AIR_WIND_SUB) {
                    int vuale4 = DataCanbus.DATA[ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT];
                    if (vuale4 > 1) {
                        vuale4--;
                    }
                    ints18 = (vuale4 << 4) & 240;
                    flag3 = true;
                } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_ADD) {
                    int tempAll3 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT];
                    if (tempAll3 != -3) {
                        if (tempAll3 == -2 || tempAll3 == 0) {
                            ints37 = 80;
                        } else {
                            ints37 = (((tempAll3 + 1) + 18) << 2) & 252;
                        }
                    }
                    flag3 = true;
                } else if (data0 == ConstAllAirDara.C_AIR_TEMP_LEFT_SUB) {
                    int tempAll4 = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_LEFT];
                    if (tempAll4 == -3) {
                        ints37 = 192;
                    } else if (tempAll4 != -2 && tempAll4 != 0) {
                        ints37 = (((tempAll4 - 1) + 18) << 2) & 252;
                    }
                    flag3 = true;
                }
                int ints210 = 0 | (data0 == ConstAllAirDara.C_AIR_MODE_UPFOOT ? 16 : 0);
                int ints211 = ints210 | (data0 == ConstAllAirDara.C_AIR_MODE_FOOT ? 8 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_BODYFOOT ? 4 : 0) | (data0 == ConstAllAirDara.C_AIR_MODE_BODY ? 2 : 0) | (data0 == ConstAllAirDara.C_AIR_CYCLE ? 1 : 0);
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{ints015, ints18, ints211, ints37, 0}, null, null);
                    break;
                } else if (data1 == 0 && !flag3) {
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
            case FinalCanbus.CAR_452_OD_LandRover_Freelander /* 7799236 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Alpha_15 /* 7799237 */:
            case FinalCanbus.CAR_453_KYC_Toyota_Alpha_15_Top /* 7864773 */:
            case FinalCanbus.CAR_452_XC_Nissan_Tule_CD /* 8716740 */:
                if (data1 == 1) {
                    DataCanbus.PROXY.cmd(ConstAllAirDara.C_CONTRAL, new int[]{data0}, null, null);
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
            case FinalCanbus.CAR_RZC4_PSA_04_407 /* 1638739 */:
            case FinalCanbus.CAR_RZC4_PSA_04_407_CD /* 1704275 */:
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
                ConstAllAirDara.TEMPERATURE_LOW = 1048576;
                ConstAllAirDara.TEMPERATURE_HIGHT = FinalCanbus.CAR_WC1_VW_Polo_08_18;
                ConstAllAirDara.TEMPERATURE_NONE = 1048578;
                ConstAllAirDara.U_AIR_POWER = 15;
                ConstAllAirDara.U_AIR_AC = 16;
                ConstAllAirDara.U_AIR_CYCLE = 18;
                ConstAllAirDara.U_AIR_FRONT = 17;
                ConstAllAirDara.U_AIR_REAR = 48;
                ConstAllAirDara.U_AIR_AUTO = 19;
                ConstAllAirDara.U_AIR_AC_MAX = 27;
                ConstAllAirDara.U_AIR_DUAL = 26;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 28;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 20;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 21;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 22;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 23;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 24;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 25;
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
            case FinalCanbus.CAR_RZC_XP1_QiRuiRuiHu7 /* 65940 */:
            case FinalCanbus.CAR_RZC_XP1_18QiRuiAiRuiZeGX /* 262548 */:
            case FinalCanbus.CAR_RZC_XP1_18QiRuiAiRuiZeGX_H /* 328084 */:
            case FinalCanbus.CAR_RZC_XP1_19QiRuiHu5X /* 393620 */:
            case FinalCanbus.CAR_RZC_XP1_19QiRuiHu5X_H /* 459156 */:
            case FinalCanbus.CAR_RZC_XP1_19AiRuiZe5 /* 590228 */:
            case FinalCanbus.CAR_RZC_XP1_19AiRuiZe5_H /* 655764 */:
            case FinalCanbus.CAR_RZC_XP1_18QiRuiRuiHu7 /* 721300 */:
            case FinalCanbus.CAR_RZC_XP1_18QiRuiRuiHu7_H /* 786836 */:
            case FinalCanbus.CAR_RZC_XP1_18QiRuiRuiHu8 /* 852372 */:
            case FinalCanbus.CAR_RZC_XP1_18QiRuiRuiHu8_H /* 917908 */:
            case FinalCanbus.CAR_RZC_XP1_20QiRuiRuiHu7 /* 1048980 */:
            case FinalCanbus.CAR_RZC_XP1_20QiRuiRuiHu8 /* 1180052 */:
            case FinalCanbus.CAR_RZC_XP1_20Ruihu_5X /* 1442196 */:
            case FinalCanbus.CAR_RZC_XP1_21Ruihu_3X /* 1507732 */:
            case FinalCanbus.CAR_RZC_XP1_21Xiaomayi_EQ1 /* 1638804 */:
            case FinalCanbus.CAR_RZC_LUZ_18QiRuiRuiHu8 /* 1704340 */:
            case FinalCanbus.CAR_RZC_XP1_22Ruihu_3X /* 2032020 */:
            case FinalCanbus.CAR_RZC_XP1_23Ruihu_3X /* 2097556 */:
            case FinalCanbus.CAR_RZC_XP1_22AiRuiZe5 /* 2163092 */:
            case FinalCanbus.CAR_RZC_QiRui_Guojin_Junxing /* 2228628 */:
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
                if (DataCanbus.DATA[1000] == 1638804) {
                    ConstAllAirDara.U_AIR_REAR = 16;
                    ConstAllAirDara.U_AIR_PTC = 68;
                    ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                    ConstAllAirDara.C_AIR_PTC = 19;
                } else if (DataCanbus.DATA[1000] == 2228628) {
                    ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 29;
                    ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 30;
                    ConstAllAirDara.U_AIR_PTC = 68;
                    ConstAllAirDara.C_AIR_PTC = 19;
                    ConstAllAirDara.C_AIR_LEFT_HEAT = 21;
                    ConstAllAirDara.C_AIR_RIGHT_HEAT = 22;
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
            case FinalCanbus.CAR_RZC_Xiongmao_Mini_23 /* 2818187 */:
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
            case FinalCanbus.CAR_RZC_BenTeng_OLDB50 /* 786845 */:
                ConstAllAirDara.TEMPERATURE_NONE = 0;
                ConstAllAirDara.TEMPERATURE_LOW = 15;
                ConstAllAirDara.TEMPERATURE_HIGHT = 49;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 26;
                ConstAllAirDara.U_AIR_POWER = 21;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 15;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 16;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 17;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 18;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 19;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 20;
                ConstAllAirDara.U_AIR_DUAL = 23;
                ConstAllAirDara.U_AIR_AC_MAX = 24;
                ConstAllAirDara.U_AIR_REAR = 25;
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
            case FinalCanbus.CAR_443_WC2_Nissan_Ruiqi /* 1704379 */:
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
                ConstAllAirDara.U_AIR_FRONT_HOT = 17;
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
                ConstAllAirDara.C_AIR_FRONT_HOT = 41;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_RZC_XP1_22Highlander /* 2097264 */:
            case FinalCanbus.CAR_RZC_XP1_22_Sienna /* 2424944 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_LS_04_06 /* 2883696 */:
            case FinalCanbus.CAR_RZC_XP1_22_VENZA /* 2949232 */:
            case FinalCanbus.CAR_RZC_XP1_22Highlander_LOW /* 3080304 */:
            case FinalCanbus.CAR_RZC_XP1_22_Sienna_LOW /* 3145840 */:
            case FinalCanbus.CAR_RZC_XP1_22Highlander_H /* 3473520 */:
            case FinalCanbus.CAR_RZC_XP1_15_LandCruiser /* 4128880 */:
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_POWER = 60;
                ConstAllAirDara.U_AIR_AC = 61;
                ConstAllAirDara.U_AIR_REAR = 152;
                ConstAllAirDara.U_AIR_FRONT = 169;
                ConstAllAirDara.U_AIR_CYCLE = 62;
                ConstAllAirDara.U_AIR_AUTO = 63;
                ConstAllAirDara.U_AIR_ECO = 180;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 70;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 71;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 72;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 181;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 200;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 201;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 202;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 203;
                ConstAllAirDara.U_AIR_FRONT_ONLY = 253;
                ConstAllAirDara.U_AIR_BACK_TEMP = 216;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 246;
                ConstAllAirDara.U_AIR_REAR_LOCK = 215;
                ConstAllAirDara.U_AIR_BACK_POWER = 217;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 218;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 219;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 221;
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 220;
                ConstAllAirDara.U_AIR_FLOWER_BLOW = 163;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_XP1_22Highlander /* 2097264 */:
                    case FinalCanbus.CAR_RZC_XP1_22_Sienna /* 2424944 */:
                    case FinalCanbus.CAR_RZC_XP1_22_VENZA /* 2949232 */:
                    case FinalCanbus.CAR_RZC_XP1_22Highlander_LOW /* 3080304 */:
                    case FinalCanbus.CAR_RZC_XP1_22_Sienna_LOW /* 3145840 */:
                    case FinalCanbus.CAR_RZC_XP1_22Highlander_H /* 3473520 */:
                        ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 67;
                        ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 68;
                        ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 69;
                        ConstAllAirDara.U_AIR_SWING = 166;
                        ConstAllAirDara.C_AIR_SWING = 32;
                        ConstAllAirDara.U_AIR_DUAL = 65;
                        ConstAllAirDara.C_AIR_DUAL = 8;
                        break;
                    case FinalCanbus.CAR_RZC_XP1_Lexus_LS_04_06 /* 2883696 */:
                    case FinalCanbus.CAR_RZC_XP1_15_LandCruiser /* 4128880 */:
                        ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 153;
                        ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 154;
                        ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 155;
                        ConstAllAirDara.U_AIR_BLOW_UP_RIGHT = 156;
                        ConstAllAirDara.U_AIR_BLOW_BODY_RIGHT = 157;
                        ConstAllAirDara.U_AIR_BLOW_FOOT_RIGHT = 158;
                        ConstAllAirDara.U_AIR_ZONE = 65;
                        ConstAllAirDara.U_AIR_CLEAN = 252;
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
                ConstAllAirDara.C_CONTRAL = 48;
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
            case FinalCanbus.CAR_452_OD_Ruilan_X3_Pro /* 2425285 */:
            case FinalCanbus.CAR_452_OD_Jihe_EX3 /* 2490821 */:
            case FinalCanbus.CAR_453_OD_Jili_Panda_Mini /* 8454597 */:
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
                if (DataCanbus.DATA[1000] == 16056773) {
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
            case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5 /* 2818501 */:
            case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5_H /* 2884037 */:
            case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5 /* 3015109 */:
            case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5_H /* 3080645 */:
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
                ConstAllAirDara.C_AIR_LEFT_HEAT = 19;
                ConstAllAirDara.C_CONTRAL = 1;
                break;
            case FinalCanbus.CAR_WC2_Honda_17Acura_MDX /* 3014977 */:
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_POWER = 38;
                ConstAllAirDara.U_AIR_AC = 30;
                ConstAllAirDara.U_AIR_SYNC = 39;
                ConstAllAirDara.U_AIR_AUTO = 26;
                ConstAllAirDara.U_AIR_FRONT = 28;
                ConstAllAirDara.U_AIR_REAR = 29;
                ConstAllAirDara.U_AIR_CYCLE = 27;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 121;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 122;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 78;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 79;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 34;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 32;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 33;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 35;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 31;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 37;
                ConstAllAirDara.U_AIR_BACK_TEMP = 129;
                ConstAllAirDara.U_AIR_BACK_TEMP_RIGHT = 129;
                ConstAllAirDara.U_AIR_BACK_BLOW_UP = 126;
                ConstAllAirDara.U_AIR_BACK_BLOW_BODY = 127;
                ConstAllAirDara.U_AIR_BACK_BLOW_FOOT = 128;
                ConstAllAirDara.U_AIR_REAR_LOCK = 124;
                ConstAllAirDara.U_AIR_BACK_BLOW_AUTO = 123;
                ConstAllAirDara.U_AIR_BACK_BLOW_WIND = 125;
                ConstAllAirDara.C_AIR_POWER = 1;
                ConstAllAirDara.C_AIR_AC = 2;
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
                ConstAllAirDara.U_AIR_POWER = 32;
                ConstAllAirDara.U_AIR_AC = 24;
                ConstAllAirDara.U_AIR_CYCLE = 21;
                ConstAllAirDara.U_AIR_FRONT = 22;
                ConstAllAirDara.U_AIR_REAR = 23;
                ConstAllAirDara.U_AIR_AUTO = 20;
                ConstAllAirDara.U_AIR_DUAL = 30;
                ConstAllAirDara.U_AIR_SEATHEAT_LEFT = 95;
                ConstAllAirDara.U_AIR_SEATHEAT_RIGHT = 97;
                ConstAllAirDara.U_AIR_SEATWIND_LEFT = 94;
                ConstAllAirDara.U_AIR_SEATWIND_RIGHT = 96;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 28;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 26;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 27;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 29;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 25;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 31;
                ConstAllAirDara.U_AIR_TEMP_UNIT = 33;
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
            case FinalCanbus.CAR_453_OD_Ford_PRO_23 /* 8389061 */:
                ConstAllAirDara.TEMPERATURE_NONE = 0;
                ConstAllAirDara.TEMPERATURE_LOW = 36;
                ConstAllAirDara.TEMPERATURE_HIGHT = 64;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 65;
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
                ConstAllAirDara.C_AIR_MODE_UP = 6;
                ConstAllAirDara.C_AIR_MODE_BODY = 16;
                ConstAllAirDara.C_AIR_MODE_FOOT = 15;
                ConstAllAirDara.C_CONTRAL = 3;
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
            case FinalCanbus.CAR_443_WC2_Proton_X50_22 /* 9306555 */:
            case FinalCanbus.CAR_443_WC2_Proton_X50_22_H /* 9372091 */:
            case FinalCanbus.CAR_443_WC2_Proton_Persona_22 /* 9437627 */:
            case FinalCanbus.CAR_443_WC2_Proton_X70_22 /* 9503163 */:
            case FinalCanbus.CAR_443_WC2_Proton_X70_22_H /* 9568699 */:
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_REAR = 16;
                ConstAllAirDara.U_AIR_FRONT = 15;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_ION = 58;
                ConstAllAirDara.U_AIR_BLOW_UP_LEFT = 18;
                ConstAllAirDara.U_AIR_BLOW_BODY_LEFT = 19;
                ConstAllAirDara.U_AIR_BLOW_FOOT_LEFT = 20;
                ConstAllAirDara.U_AIR_WIND_LEVEL_LEFT = 21;
                ConstAllAirDara.U_AIR_TEMP_LEFT = 27;
                ConstAllAirDara.U_AIR_TEMP_RIGHT = 28;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 21;
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
                ConstAllAirDara.C_AIR_CYCLE = 7;
                ConstAllAirDara.C_CONTRAL = 0;
                break;
            case FinalCanbus.CAR_452_LZ_Ford_Mustang /* 11403716 */:
            case FinalCanbus.CAR_452_LZ_Ford_Mustang_H /* 14090692 */:
                ConstAllAirDara.U_AIR_HAVE_REAR = 1;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_FRONT = 15;
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
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 25;
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
            case FinalCanbus.CAR_453_RZC_VinFast_PLUS_23 /* 15860165 */:
                ConstAllAirDara.U_AIR_AC = 11;
                ConstAllAirDara.U_AIR_FRONT = 65;
                ConstAllAirDara.U_AIR_POWER = 10;
                ConstAllAirDara.U_AIR_CYCLE = 12;
                ConstAllAirDara.U_AIR_AUTO = 13;
                ConstAllAirDara.U_AIR_DUAL = 14;
                ConstAllAirDara.U_AIR_REAR = 16;
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
                ConstAllAirDara.C_AIR_WIND_SUB = 9;
                ConstAllAirDara.C_AIR_WIND_ADD = 10;
                ConstAllAirDara.C_AIR_DUAL = 16;
                ConstAllAirDara.C_AIR_FRONT_DEFROST = 39;
                ConstAllAirDara.C_AIR_REAR_DEFROST = 20;
                ConstAllAirDara.C_AIR_AUTO = 21;
                ConstAllAirDara.C_AIR_AC = 23;
                ConstAllAirDara.C_AIR_CYCLE = 25;
                ConstAllAirDara.C_AIR_MODE_CHANGER = 34;
                ConstAllAirDara.C_CONTRAL = 2;
                break;
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
        }
    }

    private void init() {
        if (ConstAllAirDara.U_AIR_HAVE_REAR != 255) {
            findViewById(R.id.tv_sp_front).setVisibility(0);
            findViewById(R.id.tv_sp_rear).setVisibility(0);
            findViewById(R.id.tv_sp_front).setOnTouchListener(this);
            findViewById(R.id.tv_sp_rear).setOnTouchListener(this);
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
            findViewById(R.id.air_sp_rear_blow_changer).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_rear_blow_changer).setVisibility(8);
        }
        if (ConstAllAirDara.C_REAR_MODE_RIGHT != 255) {
            findViewById(R.id.air_sp_rear_blow_changer_right).setVisibility(0);
            findViewById(R.id.air_sp_rear_blow_changer_right).setOnTouchListener(this);
        } else {
            findViewById(R.id.air_sp_rear_blow_changer_right).setVisibility(8);
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
            findViewById(R.id.air_sp_ac).setVisibility(8);
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
    }

    private boolean IsdisableAirWindow() {
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
                return false;
            default:
                return true;
        }
    }

    @Override // android.app.Activity
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

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        if (IsdisableAirWindow()) {
            AirHelper.disableAirWindowLocal(false);
        }
        removeUpdater();
        ConstAllAirDara.JumpNewAir = false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 255;
        switch (id) {
            case R.id.tv_sp_front /* 2131427929 */:
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
            case R.id.tv_sp_rear /* 2131427930 */:
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
            case R.id.air_sp_mode_change /* 2131428560 */:
            case R.id.air_sp_blow_changer /* 2131430407 */:
                data0 = ConstAllAirDara.C_AIR_MODE_CHANGER;
                break;
            case R.id.air_sp_temp_left_munits /* 2131430318 */:
                data0 = ConstAllAirDara.C_AIR_TEMP_LEFT_SUB;
                break;
            case R.id.air_sp_temp_left_plus /* 2131430321 */:
                data0 = ConstAllAirDara.C_AIR_TEMP_LEFT_ADD;
                break;
            case R.id.air_sp_blow_body_foot /* 2131430323 */:
                data0 = ConstAllAirDara.C_AIR_MODE_BODYFOOT;
                break;
            case R.id.air_sp_blow_foot /* 2131430324 */:
                data0 = ConstAllAirDara.C_AIR_MODE_FOOT;
                break;
            case R.id.air_sp_blow_body /* 2131430325 */:
                data0 = ConstAllAirDara.C_AIR_MODE_BODY;
                break;
            case R.id.air_sp_blow_foot_win /* 2131430326 */:
                data0 = ConstAllAirDara.C_AIR_MODE_UPFOOT;
                break;
            case R.id.air_sp_wind_minuts /* 2131430327 */:
                data0 = ConstAllAirDara.C_AIR_WIND_SUB;
                break;
            case R.id.air_sp_wind_plus /* 2131430329 */:
                data0 = ConstAllAirDara.C_AIR_WIND_ADD;
                break;
            case R.id.air_sp_ac /* 2131430330 */:
                data0 = ConstAllAirDara.C_AIR_AC;
                break;
            case R.id.air_sp_front /* 2131430331 */:
                data0 = ConstAllAirDara.C_AIR_FRONT_DEFROST;
                break;
            case R.id.air_sp_rear /* 2131430332 */:
                data0 = ConstAllAirDara.C_AIR_REAR_DEFROST;
                break;
            case R.id.air_sp_cycle /* 2131430333 */:
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_XP1_QiRuiRuiHu7 /* 65940 */:
                    case FinalCanbus.CAR_RZC_XP1_18QiRuiAiRuiZeGX /* 262548 */:
                    case FinalCanbus.CAR_RZC_XP1_18QiRuiAiRuiZeGX_H /* 328084 */:
                    case FinalCanbus.CAR_RZC_XP1_19QiRuiHu5X /* 393620 */:
                    case FinalCanbus.CAR_RZC_XP1_19QiRuiHu5X_H /* 459156 */:
                    case FinalCanbus.CAR_RZC_XP1_19AiRuiZe5 /* 590228 */:
                    case FinalCanbus.CAR_RZC_XP1_19AiRuiZe5_H /* 655764 */:
                    case FinalCanbus.CAR_RZC_XP1_18QiRuiRuiHu7 /* 721300 */:
                    case FinalCanbus.CAR_RZC_XP1_18QiRuiRuiHu7_H /* 786836 */:
                    case FinalCanbus.CAR_RZC_XP1_18QiRuiRuiHu8 /* 852372 */:
                    case FinalCanbus.CAR_RZC_XP1_18QiRuiRuiHu8_H /* 917908 */:
                    case FinalCanbus.CAR_RZC_XP1_20QiRuiRuiHu7 /* 1048980 */:
                    case FinalCanbus.CAR_RZC_XP1_20QiRuiRuiHu8 /* 1180052 */:
                    case FinalCanbus.CAR_RZC_DongFeng_Fengxing_S60EVE /* 1310947 */:
                    case FinalCanbus.CAR_RZC_XP1_20Ruihu_5X /* 1442196 */:
                    case FinalCanbus.CAR_RZC_XP1_21Ruihu_3X /* 1507732 */:
                    case FinalCanbus.CAR_RZC_XP1_21Xiaomayi_EQ1 /* 1638804 */:
                    case FinalCanbus.CAR_RZC_LUZ_18QiRuiRuiHu8 /* 1704340 */:
                    case FinalCanbus.CAR_RZC_XP1_22Ruihu_3X /* 2032020 */:
                    case FinalCanbus.CAR_RZC_XP1_23Ruihu_3X /* 2097556 */:
                    case FinalCanbus.CAR_RZC_XP1_22AiRuiZe5 /* 2163092 */:
                    case FinalCanbus.CAR_RZC_QiRui_Guojin_Junxing /* 2228628 */:
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
            case R.id.air_sp_power /* 2131430334 */:
                if (this.pagenum == 1) {
                    data0 = ConstAllAirDara.C_REAR_OFF;
                    break;
                } else {
                    data0 = ConstAllAirDara.C_AIR_POWER;
                    break;
                }
            case R.id.air_sp_seatwind_left /* 2131430336 */:
                data0 = ConstAllAirDara.C_AIR_LEFT_COLD;
                break;
            case R.id.air_sp_seatheat_left /* 2131430338 */:
                data0 = ConstAllAirDara.C_AIR_LEFT_HEAT;
                break;
            case R.id.air_sp_auto /* 2131430340 */:
                data0 = ConstAllAirDara.C_AIR_AUTO;
                break;
            case R.id.air_sp_ptc /* 2131430342 */:
                data0 = ConstAllAirDara.C_AIR_PTC;
                break;
            case R.id.air_sp_flowerblow /* 2131430344 */:
                data0 = ConstAllAirDara.C_AIR_FLOWER_BLOW;
                break;
            case R.id.air_sp_airpark /* 2131430346 */:
                data0 = ConstAllAirDara.C_AIR_PARK;
                break;
            case R.id.air_sp_frontmax /* 2131430348 */:
                data0 = ConstAllAirDara.C_AIR_MAX_FRONT_DEFROST;
                break;
            case R.id.air_sp_car_rear /* 2131430350 */:
                data0 = ConstAllAirDara.C_REAR_CTRL;
                break;
            case R.id.air_sp_acmax /* 2131430352 */:
                data0 = ConstAllAirDara.C_AIR_AC_MAX;
                break;
            case R.id.air_sp_ion /* 2131430354 */:
                data0 = ConstAllAirDara.C_AIR_ION;
                break;
            case R.id.air_sp_clean /* 2131430356 */:
                data0 = ConstAllAirDara.C_CLEAN;
                break;
            case R.id.air_sp_eco /* 2131430358 */:
                data0 = ConstAllAirDara.C_AIR_ECO;
                break;
            case R.id.air_sp_blowtop /* 2131430360 */:
                data0 = ConstAllAirDara.C_AIR_BLOWTOP;
                break;
            case R.id.air_sp_aqs /* 2131430362 */:
                data0 = ConstAllAirDara.C_AIR_AQS;
                break;
            case R.id.air_sp_zone /* 2131430364 */:
                data0 = ConstAllAirDara.C_AIR_ZONE;
                break;
            case R.id.air_sp_sync /* 2131430366 */:
                data0 = ConstAllAirDara.C_AIR_SYNC;
                break;
            case R.id.air_sp_dual /* 2131430368 */:
                data0 = ConstAllAirDara.C_AIR_DUAL;
                break;
            case R.id.air_sp_nanoe /* 2131430370 */:
                data0 = ConstAllAirDara.C_AIR_NANOE;
                break;
            case R.id.air_sp_swing /* 2131430372 */:
                data0 = ConstAllAirDara.C_AIR_SWING;
                break;
            case R.id.air_sp_winlev /* 2131430374 */:
                data0 = ConstAllAirDara.C_AIR_WINLEV;
                break;
            case R.id.air_sp_steer /* 2131430376 */:
                data0 = ConstAllAirDara.C_AIR_STEER;
                break;
            case R.id.air_sp_heat /* 2131430378 */:
                data0 = ConstAllAirDara.C_AIR_HEAT;
                break;
            case R.id.air_sp_auto_right /* 2131430380 */:
                data0 = ConstAllAirDara.C_AIR_AUTO_RIGHT;
                break;
            case R.id.air_sp_seatheat_right /* 2131430382 */:
                data0 = ConstAllAirDara.C_AIR_RIGHT_HEAT;
                break;
            case R.id.air_sp_seatwind_right /* 2131430384 */:
                data0 = ConstAllAirDara.C_AIR_RIGHT_COLD;
                break;
            case R.id.air_sp_blow_win /* 2131430399 */:
                data0 = ConstAllAirDara.C_AIR_MODE_UP;
                break;
            case R.id.air_sp_blow_foot_right /* 2131430401 */:
                data0 = ConstAllAirDara.C_AIR_MODE_FOOT_RIGHT;
                break;
            case R.id.air_sp_blow_body_right /* 2131430403 */:
                data0 = ConstAllAirDara.C_AIR_MODE_BODY_RIGHT;
                break;
            case R.id.air_sp_blow_win_right /* 2131430405 */:
                data0 = ConstAllAirDara.C_AIR_MODE_UP_RIGHT;
                break;
            case R.id.air_sp_blow_mode_minus /* 2131430409 */:
                data0 = ConstAllAirDara.C_AIR_MODE_SUB;
                break;
            case R.id.air_sp_blow_changer_center /* 2131430411 */:
                data0 = ConstAllAirDara.C_AIR_MODE_CENTER;
                break;
            case R.id.air_sp_blow_mode_plus /* 2131430413 */:
                data0 = ConstAllAirDara.C_AIR_MODE_ADD;
                break;
            case R.id.air_sp_blow_changer_right /* 2131430415 */:
                data0 = ConstAllAirDara.C_AIR_MODE_CHANGER_RIGHT;
                break;
            case R.id.air_sp_temp_right_plus /* 2131430416 */:
                data0 = ConstAllAirDara.C_AIR_TEMP_RIGHT_ADD;
                break;
            case R.id.air_sp_temp_right_munits /* 2131430423 */:
                data0 = ConstAllAirDara.C_AIR_TEMP_RIGHT_SUB;
                break;
            case R.id.air_sp_auto_rear /* 2131430426 */:
                data0 = ConstAllAirDara.C_REAR_AUTO;
                break;
            case R.id.air_sp_onlyfront /* 2131430428 */:
                data0 = ConstAllAirDara.C_AIR_FRONT_ONLY;
                break;
            case R.id.air_sp_rearlock_rear /* 2131430430 */:
                data0 = ConstAllAirDara.C_REAR_LOCK;
                break;
            case R.id.air_sp_sync_rear /* 2131430432 */:
                data0 = ConstAllAirDara.C_REAR_SYNC;
                break;
            case R.id.air_sp_ac_rear /* 2131430434 */:
                data0 = ConstAllAirDara.C_REAR_AC;
                break;
            case R.id.air_sp_auto_rear_right /* 2131430436 */:
                data0 = ConstAllAirDara.C_REAR_AUTO_RIGHT;
                break;
            case R.id.air_sp_temp_rearleft_plus /* 2131430437 */:
                data0 = ConstAllAirDara.C_REAR_LEFT_TEMP_UP;
                break;
            case R.id.air_sp_temp_rearleft_minus /* 2131430444 */:
                data0 = ConstAllAirDara.C_REAR_LEFT_TEMP_DOWN;
                break;
            case R.id.air_sp_rear_blow_changer /* 2131430455 */:
                data0 = ConstAllAirDara.C_REAR_MODE;
                break;
            case R.id.air_sp_rear_blow_body_foot /* 2131430457 */:
                data0 = ConstAllAirDara.C_REAR_MODE_BODY_FOOT;
                break;
            case R.id.air_sp_rear_blow_foot /* 2131430459 */:
                data0 = ConstAllAirDara.C_REAR_MODE_FOOT;
                break;
            case R.id.air_sp_rear_blow_body /* 2131430461 */:
                data0 = ConstAllAirDara.C_REAR_MODE_BODY;
                break;
            case R.id.air_sp_rear_blow_changer_right /* 2131430462 */:
                data0 = ConstAllAirDara.C_REAR_MODE_RIGHT;
                break;
            case R.id.air_sp_temp_rearright_plus /* 2131430463 */:
                data0 = ConstAllAirDara.C_REAR_RIGHT_TEMP_UP;
                break;
            case R.id.air_sp_temp_rearright_minus /* 2131430470 */:
                data0 = ConstAllAirDara.C_REAR_RIGHT_TEMP_DOWN;
                break;
            case R.id.air_sp_rear_wind_minuts /* 2131430471 */:
                data0 = ConstAllAirDara.C_REAR_WIND_DOWN;
                break;
            case R.id.air_sp_rear_wind_plus /* 2131430474 */:
                data0 = ConstAllAirDara.C_REAR_WIND_UP;
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
        if (ConstAllAirDara.U_AIR_FRONT_ONLY != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FRONT_ONLY].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstAllAirDara.U_AIR_NANOE != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_NANOE].addNotify(this.mNotifyCanbus, 1);
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
        if (ConstAllAirDara.U_AIR_FRONT_ONLY != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_FRONT_ONLY].removeNotify(this.mNotifyCanbus);
        }
        if (ConstAllAirDara.U_AIR_NANOE != 255) {
            DataCanbus.NOTIFY_EVENTS[ConstAllAirDara.U_AIR_NANOE].removeNotify(this.mNotifyCanbus);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirHeat() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_HEAT];
        findViewById(R.id.air_sp_heat).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_heat_n : R.drawable.ic_hp_heat_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirPTC() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_PTC];
        findViewById(R.id.air_sp_ptc).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_ptc_n : R.drawable.ic_hp_ptc_p);
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
        findViewById(R.id.air_sp_clean).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_clean_n : R.drawable.ic_hp_clean_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateIon() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_ION];
        findViewById(R.id.air_sp_ion).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_ion_n : R.drawable.ic_hp_ion_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateBlowTop() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_BLOWTOP];
        findViewById(R.id.air_sp_blowtop).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_blowtop_n : R.drawable.ic_hp_blowtop_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcMax() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_AC_MAX];
        findViewById(R.id.air_sp_acmax).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_acmax_n : R.drawable.ic_hp_acmax_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirAQS() {
        int i = R.drawable.ic_hp_aqs_n;
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_AQS];
        switch (DataCanbus.DATA[1000]) {
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
                    i = 2130839736;
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
                case FinalCanbus.CAR_453_LZ_Chrysler_300C_15 /* 5571013 */:
                case FinalCanbus.CAR_453_LZ_Maserati_Levante_18 /* 5636549 */:
                    temp *= 5;
                    break;
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
                case FinalCanbus.CAR_453_LZ_Chrysler_300C_15 /* 5571013 */:
                case FinalCanbus.CAR_453_LZ_Maserati_Levante_18 /* 5636549 */:
                    temp *= 5;
                    break;
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
                case FinalCanbus.CAR_RZC4_PSA_04_407 /* 1638739 */:
                case FinalCanbus.CAR_RZC4_PSA_04_407_CD /* 1704275 */:
                case FinalCanbus.CAR_RZC_HONDA_23Yage /* 4260138 */:
                case FinalCanbus.CAR_452_LZ_Ford_Mustang /* 11403716 */:
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
                case 416:
                case FinalCanbus.CAR_WC2_17MingJue6 /* 65952 */:
                case FinalCanbus.CAR_WC2_RongWei_I5 /* 131488 */:
                case FinalCanbus.CAR_WC2_RongWei_I6 /* 197024 */:
                case FinalCanbus.CAR_WC2_RongWei_EI6 /* 262560 */:
                case FinalCanbus.CAR_WC2_RongWei_RX3 /* 328096 */:
                case FinalCanbus.CAR_WC2_RongWei_HS /* 393632 */:
                case FinalCanbus.CAR_WC2_RongWei_I5_H /* 459168 */:
                case FinalCanbus.CAR_443_WC2_Tianlai08_12 /* 1180091 */:
                case FinalCanbus.CAR_WC2_BeiQi_M50F /* 1311115 */:
                case FinalCanbus.CAR_443_WC2_Nissan_Ruiqi /* 1704379 */:
                case FinalCanbus.CAR_453_OD_Jiangling_Kaiyun_H /* 1835461 */:
                case FinalCanbus.CAR_WC2_JieTu_X70_22 /* 2294155 */:
                case FinalCanbus.CAR_WC2_JieTu_X70_22_H /* 2359691 */:
                case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD /* 4719035 */:
                case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD_HW /* 4915643 */:
                case FinalCanbus.CAR_453_LZ_Chrysler_300C_15 /* 5571013 */:
                case FinalCanbus.CAR_453_LZ_Maserati_Levante_18 /* 5636549 */:
                case FinalCanbus.CAR_453_DJ_Nissan_NOCD /* 5833157 */:
                case FinalCanbus.CAR_453_DJ_Nissan_NOCD_H /* 5898693 */:
                case FinalCanbus.CAR_452_OD_Nissan_Tule_low /* 6095300 */:
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
                case FinalCanbus.CAR_443_WC2_Proton_X70_22_H /* 9568699 */:
                case FinalCanbus.CAR_443_WC_OPEL_Astra_04_H /* 10420667 */:
                case FinalCanbus.CAR_443_WC_OPEL_Zafira_05_H /* 10486203 */:
                case FinalCanbus.CAR_443_WC_OPEL_Antara_06_H /* 10551739 */:
                case FinalCanbus.CAR_443_WC_OPEL_Vectra_02_H /* 10617275 */:
                case FinalCanbus.CAR_443_WC_OPEL_Corsa_06_H /* 10682811 */:
                case FinalCanbus.CAR_443_WC_OPEL_Meriva_03_H /* 10748347 */:
                case FinalCanbus.CAR_439_DJ_Nissan /* 12779959 */:
                case FinalCanbus.CAR_439_DJ_Nissan_H /* 12845495 */:
                case FinalCanbus.CAR_453_OD_BQ_BJ30_21 /* 12845509 */:
                    temp *= 5;
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
                case FinalCanbus.CAR_452_OD_Ruilan_X3_Pro /* 2425285 */:
                case FinalCanbus.CAR_RZC_XP1_Binrui_20 /* 2490507 */:
                case FinalCanbus.CAR_452_OD_Jihe_EX3 /* 2490821 */:
                case FinalCanbus.CAR_RZC_XP1_Haoyue_20 /* 2556043 */:
                case FinalCanbus.CAR_RZC_Xiongmao_Mini_23 /* 2818187 */:
                case FinalCanbus.CAR_453_OD_Jili_Panda_Mini /* 8454597 */:
                case FinalCanbus.CAR_453_OD_Jili_Dihao_EV /* 16056773 */:
                    if (temp >= 32 && temp <= 34) {
                        temp = ((temp - 32) * 5) + 160;
                        break;
                    } else {
                        temp = (temp * 5) + 170;
                        break;
                    }
                case FinalCanbus.CAR_Oudi_XP1_FengGuang17Y580 /* 196922 */:
                case FinalCanbus.CAR_RZC_Jiangxi_FengguangS560_21 /* 1179962 */:
                case FinalCanbus.CAR_RZC_DongFeng_Fengxing_S60EVE /* 1310947 */:
                case FinalCanbus.CAR_Oudi_XP1_FengGuang17Y560 /* 1507642 */:
                case FinalCanbus.CAR_Oudi_XP1_FengGuang17S560 /* 1638714 */:
                case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5 /* 2818501 */:
                case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5_H /* 2884037 */:
                case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5 /* 3015109 */:
                case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5_H /* 3080645 */:
                    temp *= 10;
                    break;
                case FinalCanbus.CAR_453_OD_Chuangwei_EV /* 197061 */:
                case FinalCanbus.CAR_453_RZC_Chuangwei_EV /* 8651205 */:
                    temp = (temp * 5) + 175;
                    break;
                case FinalCanbus.CAR_RZC_HavalLow_H2S_HongBiao /* 393460 */:
                case FinalCanbus.CAR_RZC_HavalLow_H2S_LanBiao /* 721140 */:
                case FinalCanbus.CAR_WC2_BeiQi_EV300_18 /* 2228619 */:
                    temp *= 10;
                    findViewById(R.id.air_sp_tempvalue_left).setVisibility(8);
                    findViewById(R.id.air_sp_tempunit_left).setVisibility(8);
                    findViewById(R.id.air_sp_tempstate_left).setVisibility(0);
                    mUpdateTempValue(R.id.air_sp_tempstate_left, (temp % 100) / 10, false);
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
                case FinalCanbus.CAR_RZC_BeiQi_18EU5 /* 786659 */:
                case FinalCanbus.CAR_RZC_BeiQi_20EX3 /* 1245411 */:
                case FinalCanbus.CAR_RZC_BeiQi_20EU5 /* 1376483 */:
                case FinalCanbus.CAR_453_OD_Jianghuai_Chaoyue /* 12779973 */:
                    temp = (temp * 10) + 170;
                    break;
                case FinalCanbus.CAR_RZC_BenTeng_OLDB50 /* 786845 */:
                    temp = ((temp - 16) * 5) + 160;
                    break;
                case FinalCanbus.CAR_RZC_BeiQi_Shenbao_D50_18 /* 852195 */:
                    temp = (temp * 10) + 160;
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
                case FinalCanbus.CAR_439_HC_RongWei950 /* 4129207 */:
                case FinalCanbus.CAR_452_OD_WeiMa_E5 /* 15663556 */:
                    temp = (temp * 5) + 160;
                    break;
                case FinalCanbus.CAR_439_RZC_LufengXiaoyao /* 4325815 */:
                case FinalCanbus.CAR_453_OD_Dongfeng_Chenglong_H7 /* 12714437 */:
                    temp = (temp * 5) + 170;
                    break;
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
                case FinalCanbus.CAR_452_LZ_Volvo /* 7995844 */:
                case FinalCanbus.CAR_452_LZ_Volvo_10 /* 13631940 */:
                case FinalCanbus.CAR_452_LZ_Volvo_15 /* 16515524 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 9) + 320;
                        break;
                    } else {
                        temp *= 5;
                        break;
                    }
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
                case FinalCanbus.CAR_452_LZ_Maserati_SP /* 12255684 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 320;
                        break;
                    } else {
                        temp *= 5;
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
                case FinalCanbus.CAR_RZC4_PSA_04_407 /* 1638739 */:
                case FinalCanbus.CAR_RZC4_PSA_04_407_CD /* 1704275 */:
                case FinalCanbus.CAR_RZC_HONDA_23Yage /* 4260138 */:
                case FinalCanbus.CAR_452_LZ_Ford_Mustang /* 11403716 */:
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
                case 416:
                case FinalCanbus.CAR_WC2_17MingJue6 /* 65952 */:
                case FinalCanbus.CAR_WC2_RongWei_I5 /* 131488 */:
                case FinalCanbus.CAR_WC2_RongWei_I6 /* 197024 */:
                case FinalCanbus.CAR_WC2_RongWei_EI6 /* 262560 */:
                case FinalCanbus.CAR_WC2_RongWei_RX3 /* 328096 */:
                case FinalCanbus.CAR_WC2_RongWei_HS /* 393632 */:
                case FinalCanbus.CAR_WC2_RongWei_I5_H /* 459168 */:
                case FinalCanbus.CAR_443_WC2_Tianlai08_12 /* 1180091 */:
                case FinalCanbus.CAR_WC2_BeiQi_M50F /* 1311115 */:
                case FinalCanbus.CAR_443_WC2_Nissan_Ruiqi /* 1704379 */:
                case FinalCanbus.CAR_453_OD_Jiangling_Kaiyun_H /* 1835461 */:
                case FinalCanbus.CAR_WC2_JieTu_X70_22 /* 2294155 */:
                case FinalCanbus.CAR_WC2_JieTu_X70_22_H /* 2359691 */:
                case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD /* 4719035 */:
                case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD_HW /* 4915643 */:
                case FinalCanbus.CAR_453_LZ_Chrysler_300C_15 /* 5571013 */:
                case FinalCanbus.CAR_453_LZ_Maserati_Levante_18 /* 5636549 */:
                case FinalCanbus.CAR_453_DJ_Nissan_NOCD /* 5833157 */:
                case FinalCanbus.CAR_453_DJ_Nissan_NOCD_H /* 5898693 */:
                case FinalCanbus.CAR_452_OD_Nissan_Tule_low /* 6095300 */:
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
                case FinalCanbus.CAR_443_WC2_Proton_X70_22_H /* 9568699 */:
                case FinalCanbus.CAR_443_WC_OPEL_Astra_04_H /* 10420667 */:
                case FinalCanbus.CAR_443_WC_OPEL_Zafira_05_H /* 10486203 */:
                case FinalCanbus.CAR_443_WC_OPEL_Antara_06_H /* 10551739 */:
                case FinalCanbus.CAR_443_WC_OPEL_Vectra_02_H /* 10617275 */:
                case FinalCanbus.CAR_443_WC_OPEL_Corsa_06_H /* 10682811 */:
                case FinalCanbus.CAR_443_WC_OPEL_Meriva_03_H /* 10748347 */:
                case FinalCanbus.CAR_439_DJ_Nissan /* 12779959 */:
                case FinalCanbus.CAR_439_DJ_Nissan_H /* 12845495 */:
                case FinalCanbus.CAR_453_OD_BQ_BJ30_21 /* 12845509 */:
                    temp *= 5;
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
                case FinalCanbus.CAR_452_OD_Ruilan_X3_Pro /* 2425285 */:
                case FinalCanbus.CAR_RZC_XP1_Binrui_20 /* 2490507 */:
                case FinalCanbus.CAR_452_OD_Jihe_EX3 /* 2490821 */:
                case FinalCanbus.CAR_RZC_XP1_Haoyue_20 /* 2556043 */:
                case FinalCanbus.CAR_RZC_Xiongmao_Mini_23 /* 2818187 */:
                case FinalCanbus.CAR_453_OD_Jili_Panda_Mini /* 8454597 */:
                case FinalCanbus.CAR_453_OD_Jili_Dihao_EV /* 16056773 */:
                    if (temp >= 32 && temp <= 34) {
                        temp = ((temp - 32) * 5) + 160;
                        break;
                    } else {
                        temp = (temp * 5) + 170;
                        break;
                    }
                case FinalCanbus.CAR_Oudi_XP1_FengGuang17Y580 /* 196922 */:
                case FinalCanbus.CAR_RZC_Jiangxi_FengguangS560_21 /* 1179962 */:
                case FinalCanbus.CAR_RZC_DongFeng_Fengxing_S60EVE /* 1310947 */:
                case FinalCanbus.CAR_Oudi_XP1_FengGuang17Y560 /* 1507642 */:
                case FinalCanbus.CAR_Oudi_XP1_FengGuang17S560 /* 1638714 */:
                case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5 /* 2818501 */:
                case FinalCanbus.CAR_453_OD_Jianghuai_YuejiaA5_H /* 2884037 */:
                case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5 /* 3015109 */:
                case FinalCanbus.CAR_453_KYC_OD_Jianghuai_YuejiaA5_H /* 3080645 */:
                    temp *= 10;
                    break;
                case FinalCanbus.CAR_453_OD_Chuangwei_EV /* 197061 */:
                case FinalCanbus.CAR_453_RZC_Chuangwei_EV /* 8651205 */:
                    temp = (temp * 5) + 175;
                    break;
                case FinalCanbus.CAR_RZC_HavalLow_H2S_HongBiao /* 393460 */:
                case FinalCanbus.CAR_RZC_HavalLow_H2S_LanBiao /* 721140 */:
                case FinalCanbus.CAR_WC2_BeiQi_EV300_18 /* 2228619 */:
                    temp *= 10;
                    findViewById(R.id.air_sp_tempvalue_right).setVisibility(8);
                    findViewById(R.id.air_sp_tempunit_right).setVisibility(8);
                    findViewById(R.id.air_sp_tempstate_right).setVisibility(0);
                    mUpdateTempValue(R.id.air_sp_tempstate_right, (temp % 100) / 10, false);
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
                case FinalCanbus.CAR_RZC_BeiQi_18EU5 /* 786659 */:
                case FinalCanbus.CAR_RZC_BeiQi_20EX3 /* 1245411 */:
                case FinalCanbus.CAR_RZC_BeiQi_20EU5 /* 1376483 */:
                case FinalCanbus.CAR_453_OD_Jianghuai_Chaoyue /* 12779973 */:
                    temp = (temp * 10) + 170;
                    break;
                case FinalCanbus.CAR_RZC_BenTeng_OLDB50 /* 786845 */:
                    temp = ((temp - 16) * 5) + 160;
                    break;
                case FinalCanbus.CAR_RZC_BeiQi_Shenbao_D50_18 /* 852195 */:
                    temp = (temp * 10) + 160;
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
                case FinalCanbus.CAR_439_HC_RongWei950 /* 4129207 */:
                case FinalCanbus.CAR_452_OD_WeiMa_E5 /* 15663556 */:
                    temp = (temp * 5) + 160;
                    break;
                case FinalCanbus.CAR_439_RZC_LufengXiaoyao /* 4325815 */:
                case FinalCanbus.CAR_453_OD_Dongfeng_Chenglong_H7 /* 12714437 */:
                    temp = (temp * 5) + 170;
                    break;
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
                case FinalCanbus.CAR_452_LZ_Volvo /* 7995844 */:
                case FinalCanbus.CAR_452_LZ_Volvo_10 /* 13631940 */:
                case FinalCanbus.CAR_452_LZ_Volvo_15 /* 16515524 */:
                    if (DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT] == 1) {
                        temp = (temp * 9) + 320;
                        break;
                    } else {
                        temp *= 5;
                        break;
                    }
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
                case FinalCanbus.CAR_452_LZ_Maserati_SP /* 12255684 */:
                    if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        temp = (temp * 9) + 320;
                        break;
                    } else {
                        temp *= 5;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTempUNIT() {
        int vel = DataCanbus.DATA[ConstAllAirDara.U_AIR_TEMP_UNIT];
        if (ConstAllAirDara.U_AIR_TEMP_UNIT != 255) {
            if (vel == 1) {
                findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
                findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_f);
            }
            findViewById(R.id.air_sp_tempunit_rearleft).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
            findViewById(R.id.air_sp_tempunit_rearright).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
            findViewById(R.id.air_sp_tempunit_left).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
            findViewById(R.id.air_sp_tempunit_right).setBackgroundResource(R.drawable.ic_hp_air_tempunit_c);
            return;
        }
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
    public void mUpdateBackWind() {
        int leave = DataCanbus.DATA[ConstAllAirDara.U_AIR_BACK_BLOW_WIND];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WC2_Honda_17Acura_MDX /* 3014977 */:
                ((TextView) findViewById(R.id.air_sp_rear_wind_txt)).setText(new StringBuilder().append(leave).toString());
                ((ProgressBar) findViewById(R.id.air_sp_rear_wind_lev)).setMax(5);
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
            case FinalCanbus.CAR_RZC4_PSA_04_407 /* 1638739 */:
            case FinalCanbus.CAR_RZC4_PSA_04_407_CD /* 1704275 */:
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
            case FinalCanbus.CAR_WC2_PSAALL_1 /* 65788 */:
            case FinalCanbus.CAR_RZC_XP1_YuanJingX6 /* 131211 */:
            case FinalCanbus.CAR_WC2_PSAALL_2 /* 131324 */:
            case FinalCanbus.CAR_RZC_XP1_YuanJingX1 /* 196747 */:
            case FinalCanbus.CAR_WC2_PSAALL_3 /* 196860 */:
            case FinalCanbus.CAR_Oudi_XP1_FengGuang17Y580 /* 196922 */:
            case FinalCanbus.CAR_WC2_PSAALL_4 /* 262396 */:
            case FinalCanbus.CAR_WC2_PSAALL_5 /* 327932 */:
            case FinalCanbus.CAR_RZC_HavalLow_H2S_HongBiao /* 393460 */:
            case FinalCanbus.CAR_WC2_PSAALL_6 /* 393468 */:
            case FinalCanbus.CAR_RZC_BeiQi_19EC5 /* 458979 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6 /* 458996 */:
            case FinalCanbus.CAR_WC2_PSAALL_7 /* 459004 */:
            case FinalCanbus.CAR_WC2_PSAALL_8 /* 524540 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS /* 589963 */:
            case FinalCanbus.CAR_WC2_PSAALL_9 /* 590076 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GL /* 655499 */:
            case FinalCanbus.CAR_WC2_PSAALL_10 /* 655612 */:
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
            case FinalCanbus.CAR_WC2_BeiQi_M50F /* 1311115 */:
            case FinalCanbus.CAR_RZC_BeiQi_20EU5 /* 1376483 */:
            case FinalCanbus.CAR_RZC_HavalF7_20 /* 1376500 */:
            case FinalCanbus.CAR_RZC_Jili_19Dihao_GL_E /* 1441931 */:
            case FinalCanbus.CAR_RZC_HavalH4_20_H /* 1442036 */:
            case FinalCanbus.CAR_RZC_Jili_18Dihao /* 1507467 */:
            case FinalCanbus.CAR_RZC_HavalF7_19 /* 1507572 */:
            case FinalCanbus.CAR_Oudi_XP1_FengGuang17Y560 /* 1507642 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS_18 /* 1573003 */:
            case FinalCanbus.CAR_RZC_XP1_HavalH6_H /* 1573108 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GL_16 /* 1638539 */:
            case FinalCanbus.CAR_RZC_HavalH7_19_H /* 1638644 */:
            case FinalCanbus.CAR_Oudi_XP1_FengGuang17S560 /* 1638714 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_S1_18 /* 1704075 */:
            case FinalCanbus.CAR_RZC_HavalH7_19_NoAmp /* 1704180 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS_19 /* 1769611 */:
            case FinalCanbus.CAR_RZC_HavalH7_19_H_NoAmp /* 1769716 */:
            case FinalCanbus.CAR_RZC_XP1_YuanJingX3_19_20 /* 1835147 */:
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
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS_20 /* 2293899 */:
            case FinalCanbus.CAR_RZC_HavalLow_Changchengpao_19_L /* 2294004 */:
            case FinalCanbus.CAR_RZC_XP1_Jiaji_21 /* 2424971 */:
            case FinalCanbus.CAR_452_OD_Ruilan_X3_Pro /* 2425285 */:
            case FinalCanbus.CAR_RZC_XP1_Binrui_20 /* 2490507 */:
            case FinalCanbus.CAR_452_OD_Jihe_EX3 /* 2490821 */:
            case FinalCanbus.CAR_RZC_XP1_Haoyue_20 /* 2556043 */:
            case FinalCanbus.CAR_RZC_Xiongmao_Mini_23 /* 2818187 */:
            case FinalCanbus.CAR_439_HC_RongWei950 /* 4129207 */:
            case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD /* 4719035 */:
            case FinalCanbus.CAR_443_WC2_Tianlai08_12_CD_HW /* 4915643 */:
            case FinalCanbus.CAR_453_LZ_Chrysler_300C_15 /* 5571013 */:
            case FinalCanbus.CAR_453_LZ_Maserati_Levante_18 /* 5636549 */:
            case FinalCanbus.CAR_453_OD_Jili_Panda_Mini /* 8454597 */:
            case FinalCanbus.CAR_443_WC2_Proton_X50_22 /* 9306555 */:
            case FinalCanbus.CAR_443_WC2_Proton_X50_22_H /* 9372091 */:
            case FinalCanbus.CAR_443_WC2_Proton_Persona_22 /* 9437627 */:
            case FinalCanbus.CAR_443_WC2_Proton_X70_22 /* 9503163 */:
            case FinalCanbus.CAR_443_WC2_Proton_X70_22_H /* 9568699 */:
            case FinalCanbus.CAR_453_OD_Dongfeng_Chenglong_H7 /* 12714437 */:
            case FinalCanbus.CAR_453_OD_Jianghuai_Chaoyue /* 12779973 */:
            case FinalCanbus.CAR_453_OD_BQ_BJ30_21 /* 12845509 */:
            case FinalCanbus.CAR_452_OD_Changcheng_Oula /* 14156228 */:
            case FinalCanbus.CAR_453_RZC_VinFast_PLUS_23 /* 15860165 */:
            case FinalCanbus.CAR_453_OD_Shanqi_ZHongka /* 15991237 */:
            case FinalCanbus.CAR_453_OD_Jili_Dihao_EV /* 16056773 */:
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
            case FinalCanbus.CAR_452_LZ_Volvo /* 7995844 */:
            case FinalCanbus.CAR_452_LZ_Volvo_10 /* 13631940 */:
            case FinalCanbus.CAR_452_LZ_Volvo_15 /* 16515524 */:
                ((TextView) findViewById(R.id.air_sp_wind_txt)).setText(new StringBuilder().append(value).toString());
                ((ProgressBar) findViewById(R.id.air_sp_wind_lev)).setMax(18);
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

    /* JADX INFO: Access modifiers changed from: private */
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
                findViewById(R.id.air_sp_dual).setBackgroundResource(vel == 0 ? R.drawable.ic_hp_mono_n : R.drawable.ic_hp_mono_p);
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
        switch (DataCanbus.DATA[1000]) {
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
                    i = 2130839755;
                }
                findViewById.setBackgroundResource(i);
                break;
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
                    i = 2130839755;
                }
                findViewById2.setBackgroundResource(i);
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
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_XP1_22Highlander /* 2097264 */:
            case FinalCanbus.CAR_RZC_XP1_22_Sienna /* 2424944 */:
            case FinalCanbus.CAR_RZC_XP1_Lexus_LS_04_06 /* 2883696 */:
            case FinalCanbus.CAR_RZC_XP1_22_VENZA /* 2949232 */:
            case FinalCanbus.CAR_RZC_XP1_22Highlander_LOW /* 3080304 */:
            case FinalCanbus.CAR_RZC_XP1_22_Sienna_LOW /* 3145840 */:
            case FinalCanbus.CAR_RZC_XP1_22Highlander_H /* 3473520 */:
            case FinalCanbus.CAR_RZC_XP1_15_LandCruiser /* 4128880 */:
                findViewById(R.id.air_sp_eco).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_eco_toyota_n : R.drawable.ic_hp_eco_toyota_p);
                break;
            default:
                findViewById(R.id.air_sp_eco).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_eco_n : R.drawable.ic_hp_eco_p);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateFlowerBlow() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FLOWER_BLOW];
        findViewById(R.id.air_sp_flowerblow).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_flowerblow_n : R.drawable.ic_hp_flowerblow_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirPark() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_PARK];
        findViewById(R.id.air_sp_airpark).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_airpark_n : R.drawable.ic_hp_airpark_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirOnlyFront() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_FRONT_ONLY];
        findViewById(R.id.air_sp_onlyfront).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_onlyfront_n : R.drawable.ic_hp_onlyfront_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirSwing() {
        int rear = DataCanbus.DATA[ConstAllAirDara.U_AIR_SWING];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_XP1_22Highlander /* 2097264 */:
            case FinalCanbus.CAR_RZC_XP1_22_Sienna /* 2424944 */:
            case FinalCanbus.CAR_RZC_XP1_22_VENZA /* 2949232 */:
            case FinalCanbus.CAR_RZC_XP1_22Highlander_LOW /* 3080304 */:
            case FinalCanbus.CAR_RZC_XP1_22_Sienna_LOW /* 3145840 */:
            case FinalCanbus.CAR_RZC_XP1_22Highlander_H /* 3473520 */:
                findViewById(R.id.air_sp_swing).setBackgroundResource(rear == 0 ? R.drawable.ic_hp_swing_toyota_n : R.drawable.ic_hp_swing_toyota_p);
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
                    findViewById(R.id.air_sp_blow_changer_center).setBackgroundResource(win == 1 ? R.drawable.ic_hp_mode_win_p : 2130839791);
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

    /* JADX INFO: Access modifiers changed from: private */
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
