package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.carinfo.wccamry.ConstWcToyota;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0397_BNR_XP1_VScreen_Camry2013 extends CallbackCanbusBase {
    public static String CDArtist = null;
    public static String CDFolder = null;
    public static String CDName = null;
    public static final int U_CARINFO_AUTO_RELOCK_TIME = 161;
    public static final int U_CARINFO_ECO_MODE = 158;
    public static final int U_CARINFO_EV_MODE = 159;
    public static final int U_CARINFO_NEW_ADD = 157;
    public static final int U_CARINFO_START_STOP_KEY = 160;
    public static final int U_CARINF_D11_D0_B20 = 219;
    public static final int U_CARINF_D11_D0_B3 = 218;
    public static final int U_CARINF_D11_D0_B4 = 217;
    public static final int U_CARINF_D11_D0_B5 = 216;
    public static final int U_CARINF_D11_D0_B6 = 215;
    public static final int U_CARINF_D11_D0_B7 = 214;
    public static final int U_CARINF_D11_D1_B70 = 220;
    public static final int U_CARINF_D11_D2_B70 = 221;
    public static final int U_CARINF_D11_D3_D4 = 222;
    public static final int U_CARINF_D12_D0_B30 = 225;
    public static final int U_CARINF_D12_D0_B7 = 224;
    public static final int U_CARINF_D12_D11_D12 = 231;
    public static final int U_CARINF_D12_D13_D14 = 232;
    public static final int U_CARINF_D12_D1_D2 = 226;
    public static final int U_CARINF_D12_D3_D4 = 227;
    public static final int U_CARINF_D12_D5_D6 = 228;
    public static final int U_CARINF_D12_D7_D8 = 229;
    public static final int U_CARINF_D12_D9_D10 = 230;
    public static final int U_CARINF_D13_ALL = 233;
    public static final int U_CARINF_D14_ALL = 234;
    public static final int U_CARINF_D15_ALL = 235;
    public static final int U_CARINF_D17_ALL = 236;
    public static final int U_CARINF_D18_ALL = 223;
    public static final int U_CARINF_D19_ALL = 243;
    public static final int U_CARINF_D1A_ALL = 244;
    public static final int U_CARINF_D1B_ALL1 = 237;
    public static final int U_CARINF_D1B_ALL2 = 238;
    public static final int U_CARINF_D1B_ALL3 = 239;
    public static final int U_CARINF_D1B_ALL4 = 240;
    public static final int U_CARINF_D1B_ALL5 = 241;
    public static final int U_CARINF_D1B_ALL6 = 242;
    public static final int U_CARINF_D1C_D0_B1 = 259;
    public static final int U_CARINF_D1C_D0_B2 = 258;
    public static final int U_CARINF_D1C_D0_B3 = 257;
    public static final int U_CARINF_D1C_D0_B4 = 256;
    public static final int U_CARINF_D1C_D0_B5 = 255;
    public static final int U_CARINF_D1C_D0_B6 = 254;
    public static final int U_CARINF_D1C_D0_B7 = 253;
    public static final int U_CARSET_ALTITUDE = 207;
    public static final int U_CARSET_ANGLE = 210;
    public static final int U_CARSET_CALIBRATE = 213;
    public static final int U_CARSET_D26_D4_B10 = 201;
    public static final int U_CARSET_D26_D4_B2 = 199;
    public static final int U_CARSET_D26_D5_B20 = 204;
    public static final int U_CARSET_D26_D5_B43 = 203;
    public static final int U_CARSET_D26_D5_B65 = 202;
    public static final int U_CARSET_D26_D5_B7 = 245;
    public static final int U_CARSET_D26_D6_B1 = 252;
    public static final int U_CARSET_D26_D6_B2 = 251;
    public static final int U_CARSET_D26_D6_B3 = 250;
    public static final int U_CARSET_D26_D6_B4 = 249;
    public static final int U_CARSET_D26_D6_B5 = 248;
    public static final int U_CARSET_D26_D6_B6 = 247;
    public static final int U_CARSET_D26_D6_B7 = 246;
    public static final int U_CARSET_D4D_D0_D1 = 211;
    public static final int U_CARSET_D4D_D2_D3 = 212;
    public static final int U_CARSET_D50_B10 = 185;
    public static final int U_CARSET_D50_B32 = 184;
    public static final int U_CARSET_D5D_D0_B0 = 200;
    public static final int U_CARSET_D5D_D0_B1 = 205;
    public static final int U_CARSET_D5D_D1_B0 = 206;
    public static final int U_CARSET_D5F_D0_B0 = 194;
    public static final int U_CARSET_D5F_D0_B1 = 193;
    public static final int U_CARSET_D5F_D0_B2 = 192;
    public static final int U_CARSET_D5F_D0_B3 = 191;
    public static final int U_CARSET_D5F_D0_B4 = 190;
    public static final int U_CARSET_D5F_D0_B5 = 189;
    public static final int U_CARSET_D5F_D0_B6 = 188;
    public static final int U_CARSET_D5F_D0_B7 = 187;
    public static final int U_CARSET_D5F_D1_B70 = 195;
    public static final int U_CARSET_D5F_D2_B70 = 196;
    public static final int U_CARSET_D5F_D3_B70 = 197;
    public static final int U_CARSET_D5F_D4_B70 = 198;
    public static final int U_CARSET_LATITUDE = 209;
    public static final int U_CARSET_LONGITUDE = 208;
    public static final int U_CARSET_OIL_UNIT = 186;
    public static final int U_CAR_AIR_AUTOWIN = 183;
    public static final int U_CAR_EC_LEV = 181;
    public static final int U_CAR_LANGUAGE_SET = 182;
    public static final int U_CMR_NEW_ADD = 175;
    public static final int U_CNT_MAX = 260;
    public static final int U_DRIVING_SPEED = 156;
    public static final int U_INFO_CAR_AMPMUTE = 171;
    public static final int U_INFO_CAR_AMPPMID = 173;
    public static final int U_INFO_CAR_AMPPOWERONOFF = 170;
    public static final int U_INFO_CAR_AMPPSEL = 172;
    public static final int U_INFO_CAR_ASL = 168;
    public static final int U_INFO_CAR_BAL = 165;
    public static final int U_INFO_CAR_BASS = 166;
    public static final int U_INFO_CAR_FAD = 164;
    public static final int U_INFO_CAR_KEEPVOLUEM = 169;
    public static final int U_INFO_CAR_START = 163;
    public static final int U_INFO_CAR_TRE = 167;
    public static final int U_INFO_CAR_VOL = 162;
    public static final int U_MOTOR_COLOR_TYPE = 180;
    public static final int U_RADARR_FRONT_DISTANCE = 179;
    public static final int U_RADARR_ONOFF = 177;
    public static final int U_RADARR_VOL_LEV = 178;
    public static final int U_RADAR_REAR_DISTANCE = 176;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 174;
    public static String XMCH1;
    public static String XMCH2;
    public static String XMCH3;
    public static String XMCH4;
    public static String XMCH5;
    public static String XMCH6;
    public static String XMCategory;
    public static String XMName;
    public static String XMStatus;
    public static String XMTitle;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 260; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        int carId = (DataCanbus.DATA[1000] >> 16) & 65535;
        if ((carId < 79 || carId > 86) && carId != 89 && carId != 90 && carId != 91 && carId != 92 && carId != 93 && carId != 94 && carId != 95 && carId != 96 && carId != 97 && carId != 98 && carId != 99 && carId != 100 && carId != 101 && carId != 102 && carId != 103 && carId != 104) {
            //AirHelper.getInstance().buildUi(new Air_0397_BNR_Camry2013(LauncherApplication.getInstance()));
            for (int i2 = 10; i2 < 97; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        }
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            switch (updateCode) {
                case 105:
                    TripOilExpand(updateCode, ints);
                    break;
                case 134:
                    LastMinuteOldExpand(updateCode, ints);
                    break;
                case 223:
                    if (strs != null && strs.length > 0) {
                        CDName = strs[0];
                    } else {
                        CDName = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 233:
                    if (strs != null && strs.length > 0) {
                        XMName = strs[0];
                    } else {
                        XMName = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 234:
                    if (strs != null && strs.length > 0) {
                        XMTitle = strs[0];
                    } else {
                        XMTitle = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 235:
                    if (strs != null && strs.length > 0) {
                        XMCategory = strs[0];
                    } else {
                        XMCategory = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 236:
                    if (strs != null && strs.length > 0) {
                        XMStatus = strs[0];
                    } else {
                        XMStatus = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 237:
                    if (strs != null && strs.length > 0) {
                        XMCH1 = strs[0];
                    } else {
                        XMCH1 = "-----";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 238:
                    if (strs != null && strs.length > 0) {
                        XMCH2 = strs[0];
                    } else {
                        XMCH2 = "-----";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 239:
                    if (strs != null && strs.length > 0) {
                        XMCH3 = strs[0];
                    } else {
                        XMCH3 = "-----";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 240:
                    if (strs != null && strs.length > 0) {
                        XMCH4 = strs[0];
                    } else {
                        XMCH4 = "-----";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 241:
                    if (strs != null && strs.length > 0) {
                        XMCH5 = strs[0];
                    } else {
                        XMCH5 = "-----";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 242:
                    if (strs != null && strs.length > 0) {
                        XMCH6 = strs[0];
                    } else {
                        XMCH6 = "-----";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 243:
                    if (strs != null && strs.length > 0) {
                        CDFolder = strs[0];
                    } else {
                        CDFolder = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 244:
                    if (strs != null && strs.length > 0) {
                        CDArtist = strs[0];
                    } else {
                        CDArtist = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 260) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }

    private void TripOilExpand(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 5) {
            ConstWcToyota.mTripoilexpend[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }

    private void LastMinuteOldExpand(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 30) {
            ConstWcToyota.mMinuteoilexpend[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }
}
