package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.wccamry.ConstWcToyota;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0397_BNR_Camry2013;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0397_BNR_XP1_VScreen_Camry2013 extends CallbackCanbusBase {
    public static String CDArtist = null;
    public static String CDFolder = null;
    public static String CDName = null;
    public static final int U_AIR_AC = 61;
    public static final int U_AIR_AQS = 231;
    public static final int U_AIR_AUTO = 64;
    public static final int U_AIR_AUTO_FRONT_DEFROST = 108;
    public static final int U_AIR_BACK_BLOW_AUTO = 115;
    public static final int U_AIR_BACK_BLOW_BODY = 113;
    public static final int U_AIR_BACK_BLOW_FOOT = 114;
    public static final int U_AIR_BACK_BLOW_WIND = 116;
    public static final int U_AIR_BACK_POWER = 111;
    public static final int U_AIR_BACK_TEMP = 110;
    public static final int U_AIR_BACK_TEMP_RIGHT = 214;
    public static final int U_AIR_BEGIN = 59;
    public static final int U_AIR_BIG_WIND_LIGHT = 63;
    public static final int U_AIR_BLOW_BODY_LEFT = 68;
    public static final int U_AIR_BLOW_FOOT_LEFT = 69;
    public static final int U_AIR_BLOW_UP_LEFT = 67;
    public static final int U_AIR_CYCLE = 62;
    public static final int U_AIR_DUAL = 65;
    public static final int U_AIR_END = 75;
    public static final int U_AIR_MAX = 66;
    public static final int U_AIR_MAXAC = 177;
    public static final int U_AIR_NANOE = 160;
    public static final int U_AIR_NEWADD_BLOW_AUTO_LEFT = 232;
    public static final int U_AIR_NEWADD_BLOW_AUTO_RIGHT = 233;
    public static final int U_AIR_NEWADD_BLOW_BODY_LEFT = 154;
    public static final int U_AIR_NEWADD_BLOW_BODY_RIGHT = 157;
    public static final int U_AIR_NEWADD_BLOW_FOOT_LEFT = 155;
    public static final int U_AIR_NEWADD_BLOW_FOOT_RIGHT = 158;
    public static final int U_AIR_NEWADD_BLOW_WIN_LEFT = 153;
    public static final int U_AIR_NEWADD_BLOW_WIN_RIGHT = 156;
    public static final int U_AIR_NEWADD_PURIFIER = 234;
    public static final int U_AIR_POWER = 60;
    public static final int U_AIR_REAR_CTRL = 117;
    public static final int U_AIR_REAR_DEFROG = 73;
    public static final int U_AIR_REAR_DEFROG1 = 152;
    public static final int U_AIR_REAR_LOCK = 109;
    public static final int U_AIR_TEMP_LEFT = 71;
    public static final int U_AIR_TEMP_RIGHT = 72;
    public static final int U_AIR_TEMP_UNIT = 74;
    public static final int U_AIR_WIND_LEVEL_LEFT = 70;
    public static final int U_CARINFO_AUTO_RELOCK_TIME = 107;
    public static final int U_CARINFO_ECO_MODE = 103;
    public static final int U_CARINFO_EV_MODE = 104;
    public static final int U_CARINFO_NEW_ADD = 102;
    public static final int U_CARINFO_NEW_ADD_END = 121;
    public static final int U_CARINFO_START_STOP_KEY = 105;
    public static final int U_CARINF_D11_D0_B20 = 196;
    public static final int U_CARINF_D11_D0_B3 = 195;
    public static final int U_CARINF_D11_D0_B4 = 194;
    public static final int U_CARINF_D11_D0_B5 = 193;
    public static final int U_CARINF_D11_D0_B6 = 192;
    public static final int U_CARINF_D11_D0_B7 = 191;
    public static final int U_CARINF_D11_D1_B70 = 197;
    public static final int U_CARINF_D11_D2_B70 = 198;
    public static final int U_CARINF_D11_D3_D4 = 199;
    public static final int U_CARINF_D12_D0_B30 = 202;
    public static final int U_CARINF_D12_D0_B7 = 201;
    public static final int U_CARINF_D12_D11_D12 = 208;
    public static final int U_CARINF_D12_D13_D14 = 209;
    public static final int U_CARINF_D12_D1_D2 = 203;
    public static final int U_CARINF_D12_D3_D4 = 204;
    public static final int U_CARINF_D12_D5_D6 = 205;
    public static final int U_CARINF_D12_D7_D8 = 206;
    public static final int U_CARINF_D12_D9_D10 = 207;
    public static final int U_CARINF_D13_ALL = 210;
    public static final int U_CARINF_D14_ALL = 211;
    public static final int U_CARINF_D15_ALL = 212;
    public static final int U_CARINF_D17_ALL = 213;
    public static final int U_CARINF_D18_ALL = 200;
    public static final int U_CARINF_D19_ALL = 221;
    public static final int U_CARINF_D1A_ALL = 222;
    public static final int U_CARINF_D1B_ALL1 = 215;
    public static final int U_CARINF_D1B_ALL2 = 216;
    public static final int U_CARINF_D1B_ALL3 = 217;
    public static final int U_CARINF_D1B_ALL4 = 218;
    public static final int U_CARINF_D1B_ALL5 = 219;
    public static final int U_CARINF_D1B_ALL6 = 220;
    public static final int U_CARINF_D1C_D0_B1 = 241;
    public static final int U_CARINF_D1C_D0_B2 = 240;
    public static final int U_CARINF_D1C_D0_B3 = 239;
    public static final int U_CARINF_D1C_D0_B4 = 238;
    public static final int U_CARINF_D1C_D0_B5 = 237;
    public static final int U_CARINF_D1C_D0_B6 = 236;
    public static final int U_CARINF_D1C_D0_B7 = 235;
    public static final int U_CARSET_ALTITUDE = 184;
    public static final int U_CARSET_ANGLE = 187;
    public static final int U_CARSET_CALIBRATE = 190;
    public static final int U_CARSET_D26_D4_B10 = 178;
    public static final int U_CARSET_D26_D4_B2 = 175;
    public static final int U_CARSET_D26_D5_B20 = 181;
    public static final int U_CARSET_D26_D5_B43 = 180;
    public static final int U_CARSET_D26_D5_B65 = 179;
    public static final int U_CARSET_D26_D5_B7 = 223;
    public static final int U_CARSET_D26_D6_B1 = 230;
    public static final int U_CARSET_D26_D6_B2 = 229;
    public static final int U_CARSET_D26_D6_B3 = 228;
    public static final int U_CARSET_D26_D6_B4 = 227;
    public static final int U_CARSET_D26_D6_B5 = 226;
    public static final int U_CARSET_D26_D6_B6 = 225;
    public static final int U_CARSET_D26_D6_B7 = 224;
    public static final int U_CARSET_D4D_D0_D1 = 188;
    public static final int U_CARSET_D4D_D2_D3 = 189;
    public static final int U_CARSET_D50_B10 = 151;
    public static final int U_CARSET_D50_B32 = 150;
    public static final int U_CARSET_D5D_D0_B0 = 176;
    public static final int U_CARSET_D5D_D0_B1 = 182;
    public static final int U_CARSET_D5D_D1_B0 = 183;
    public static final int U_CARSET_D5F_D0_B0 = 170;
    public static final int U_CARSET_D5F_D0_B1 = 169;
    public static final int U_CARSET_D5F_D0_B2 = 168;
    public static final int U_CARSET_D5F_D0_B3 = 167;
    public static final int U_CARSET_D5F_D0_B4 = 166;
    public static final int U_CARSET_D5F_D0_B5 = 165;
    public static final int U_CARSET_D5F_D0_B6 = 164;
    public static final int U_CARSET_D5F_D0_B7 = 163;
    public static final int U_CARSET_D5F_D1_B70 = 171;
    public static final int U_CARSET_D5F_D2_B70 = 172;
    public static final int U_CARSET_D5F_D3_B70 = 173;
    public static final int U_CARSET_D5F_D4_B70 = 174;
    public static final int U_CARSET_LATITUDE = 186;
    public static final int U_CARSET_LONGITUDE = 185;
    public static final int U_CARSET_OIL_UNIT = 159;
    public static final int U_CAR_AIR_AUTOWIN = 149;
    public static final int U_CAR_EC_LEV = 147;
    public static final int U_CAR_LANGUAGE_SET = 148;
    public static final int U_CMR_NEW_ADD = 140;
    public static final int U_CNT_MAX = 242;
    public static final int U_DOOR_BACK = 80;
    public static final int U_DOOR_BEGIN = 75;
    public static final int U_DOOR_END = 81;
    public static final int U_DOOR_ENGINE = 75;
    public static final int U_DOOR_FL = 76;
    public static final int U_DOOR_FR = 77;
    public static final int U_DOOR_RL = 78;
    public static final int U_DOOR_RR = 79;
    public static final int U_DRIVING_SPEED = 101;
    public static final int U_INFO_CAR_AMPMUTE = 130;
    public static final int U_INFO_CAR_AMPPMID = 132;
    public static final int U_INFO_CAR_AMPPOWERONOFF = 129;
    public static final int U_INFO_CAR_AMPPSEL = 131;
    public static final int U_INFO_CAR_ASL = 127;
    public static final int U_INFO_CAR_BAL = 124;
    public static final int U_INFO_CAR_BASS = 125;
    public static final int U_INFO_CAR_FAD = 123;
    public static final int U_INFO_CAR_KEEPVOLUEM = 128;
    public static final int U_INFO_CAR_START = 122;
    public static final int U_INFO_CAR_TRE = 126;
    public static final int U_INFO_CAR_VOL = 120;
    public static final int U_MOTOR_COLOR_TYPE = 146;
    public static final int U_RADARR_FRONT_DISTANCE = 145;
    public static final int U_RADARR_ONOFF = 143;
    public static final int U_RADARR_VOL_LEV = 144;
    public static final int U_RADAR_REAR_DISTANCE = 142;
    public static final int U_SEAT_BLOW_LEFT = 161;
    public static final int U_SEAT_BLOW_RIGHT = 162;
    public static final int U_SEAT_HEAT_LEFT = 118;
    public static final int U_SEAT_HEAT_RIGHT = 119;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 133;
    public static final int U_WARNNING_LOW_OIL = 106;
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

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 242; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 75;
        DoorHelper.sUcDoorFl = 76;
        DoorHelper.sUcDoorFr = 77;
        DoorHelper.sUcDoorRl = 78;
        DoorHelper.sUcDoorRr = 79;
        DoorHelper.sUcDoorBack = 80;
        int carId = (DataCanbus.DATA[1000] >> 16) & 65535;
        if ((carId < 79 || carId > 86) && carId != 89 && carId != 90 && carId != 91 && carId != 92 && carId != 93) {
            AirHelper.getInstance().buildUi(new Air_0397_BNR_Camry2013(LauncherApplication.getInstance()));
            for (int i2 = 59; i2 < 75; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            for (int i3 = 108; i3 <= 119; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        }
        DoorHelper.getInstance().buildUi();
        for (int i4 = 75; i4 < 81; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 75; i < 81; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 59; i2 < 75; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        for (int i3 = 108; i3 <= 119; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            switch (updateCode) {
                case 8:
                    TripOilExpand(updateCode, ints);
                    break;
                case 37:
                    LastMinuteOldExpand(updateCode, ints);
                    break;
                case 200:
                    if (strs != null && strs.length > 0) {
                        CDName = strs[0];
                    } else {
                        CDName = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 210:
                    if (strs != null && strs.length > 0) {
                        XMName = strs[0];
                    } else {
                        XMName = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 211:
                    if (strs != null && strs.length > 0) {
                        XMTitle = strs[0];
                    } else {
                        XMTitle = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 212:
                    if (strs != null && strs.length > 0) {
                        XMCategory = strs[0];
                    } else {
                        XMCategory = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 213:
                    if (strs != null && strs.length > 0) {
                        XMStatus = strs[0];
                    } else {
                        XMStatus = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 215:
                    if (strs != null && strs.length > 0) {
                        XMCH1 = strs[0];
                    } else {
                        XMCH1 = "-----";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 216:
                    if (strs != null && strs.length > 0) {
                        XMCH2 = strs[0];
                    } else {
                        XMCH2 = "-----";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 217:
                    if (strs != null && strs.length > 0) {
                        XMCH3 = strs[0];
                    } else {
                        XMCH3 = "-----";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 218:
                    if (strs != null && strs.length > 0) {
                        XMCH4 = strs[0];
                    } else {
                        XMCH4 = "-----";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 219:
                    if (strs != null && strs.length > 0) {
                        XMCH5 = strs[0];
                    } else {
                        XMCH5 = "-----";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 220:
                    if (strs != null && strs.length > 0) {
                        XMCH6 = strs[0];
                    } else {
                        XMCH6 = "-----";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 221:
                    if (strs != null && strs.length > 0) {
                        CDFolder = strs[0];
                    } else {
                        CDFolder = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 222:
                    if (strs != null && strs.length > 0) {
                        CDArtist = strs[0];
                    } else {
                        CDArtist = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 242) {
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
