package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0374_XP_Keleiao;
import com.syu.ui.air.Air_0374_XP_Keleiao_H;
import com.syu.ui.air.Air_0374_XP_Megane_Hand;
import com.syu.ui.air.Air_0374_XP_Ram1500;
import com.syu.ui.air.Air_0374_XP_Sandero;
import com.syu.ui.air.Air_0374_XP_ZhiNanZhe;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0374_XP1_ZiYouGuang extends CallbackCanbusBase {
    public static String Album = null;
    public static String Artist = null;
    public static String[] CD_LIST_DATA = new String[ConstRzcAddData.U_CAR_ADD_START];
    public static String Title = null;
    public static final int U_AIR_ADJUST_STEP = 164;
    public static final int U_AIR_AUX = 399;
    public static final int U_AIR_MAXWINDOW = 165;
    public static final int U_AIR_SEATBACK_LEFT = 400;
    public static final int U_AIR_SEATBACK_RIGHT = 401;
    public static final int U_AIR_TEMP_MODE = 141;
    public static final int U_CARCD_ALBUM = 181;
    public static final int U_CARCD_ARTIST = 182;
    public static final int U_CARCD_BEGIN = 168;
    public static final int U_CARCD_LIST = 343;
    public static final int U_CARCD_PLAYTIME_H = 172;
    public static final int U_CARCD_PLAYTIME_M = 173;
    public static final int U_CARCD_PLAYTIME_S = 174;
    public static final int U_CARCD_PLAYTRACK = 178;
    public static final int U_CARCD_RANDOM = 171;
    public static final int U_CARCD_REPEAT = 170;
    public static final int U_CARCD_TITLE = 180;
    public static final int U_CARCD_TOTALTIME_H = 175;
    public static final int U_CARCD_TOTALTIME_M = 176;
    public static final int U_CARCD_TOTALTIME_S = 177;
    public static final int U_CARCD_TOTALTRACK = 179;
    public static final int U_CARCD_WORKSTATE = 169;
    public static final int U_CARINDO_COMPASS_CAL = 131;
    public static final int U_CARINDO_COMPASS_POINT = 130;
    public static final int U_CARINFO_AURO_DOOR_LOCK = 100;
    public static final int U_CARINFO_AURO_UNLOCK_ON_EXIT = 101;
    public static final int U_CARINFO_AUTOCLOSE = 161;
    public static final int U_CARINFO_AUTO_ADJUST_SUSPENSION = 136;
    public static final int U_CARINFO_AUTO_ANTI_HIGH_BEAM = 97;
    public static final int U_CARINFO_AUTO_BRAKE = 134;
    public static final int U_CARINFO_AUTO_SEAT_START = 113;
    public static final int U_CARINFO_BEGIN = 85;
    public static final int U_CARINFO_BRAKE_LIST_ENABLE = 133;
    public static final int U_CARINFO_BRAKE_PARK_SENSE = 128;
    public static final int U_CARINFO_BUSY_POINT_ALARM = 119;
    public static final int U_CARINFO_COMPASS_DEVIATION_VALUE = 132;
    public static final int U_CARINFO_CORNERLING_LIGHTS = 94;
    public static final int U_CARINFO_DAYTIME_LIGHTS = 93;
    public static final int U_CARINFO_DISPLAY_SUSOENSION_INFO = 140;
    public static final int U_CARINFO_END = 143;
    public static final int U_CARINFO_ENGINE_OFF_POWER_DELAY = 111;
    public static final int U_CARINFO_Environmental_lighting = 167;
    public static final int U_CARINFO_FIRST_PRESS_KEY_UNLOCK = 106;
    public static final int U_CARINFO_FLASH_LIGHTS_WITH_LOCK_LIGHT = 91;
    public static final int U_CARINFO_FLASH_LIGHTS_WITH_LOCK_LOCK = 102;
    public static final int U_CARINFO_FRONT_COLLISION_WARN = 122;
    public static final int U_CARINFO_FRONT_COLLISION_WARN_AUTO_BRAKE = 123;
    public static final int U_CARINFO_FRONT_PARK_VOL = 120;
    public static final int U_CARINFO_GREETING_LIGHT = 99;
    public static final int U_CARINFO_HEADLIGHT_DELAYED = 90;
    public static final int U_CARINFO_HEADLIGHT_DELAYED_ENGINE = 110;
    public static final int U_CARINFO_HEADLIGHT_ILLUMI_ON_APPROACH = 92;
    public static final int U_CARINFO_HEADLIGHT_SENSI = 98;
    public static final int U_CARINFO_HILLSTART = 166;
    public static final int U_CARINFO_HORNWLOCK = 160;
    public static final int U_CARINFO_HORN_LOCK = 103;
    public static final int U_CARINFO_HORN_REMOTE = 108;
    public static final int U_CARINFO_LANE_DEVIATION_CALI = 125;
    public static final int U_CARINFO_LANE_DEVIATION_WARN = 129;
    public static final int U_CARINFO_LANG = 142;
    public static final int U_CARINFO_LIGHTS_WIPERS = 159;
    public static final int U_CARINFO_MIRROR_DIMMING = 96;
    public static final int U_CARINFO_PARKVIEW_DYNAMIC_GUIDE_LINE = 116;
    public static final int U_CARINFO_PARKVIEW_STATIC_GUIDE_LINE = 117;
    public static final int U_CARINFO_PARK_SENSE = 114;
    public static final int U_CARINFO_PASSIVE_ENTRY = 107;
    public static final int U_CARINFO_POWER_LEFT_GATE_ALERT = 105;
    public static final int U_CARINFO_RAIN_SENS_WIPERS = 126;
    public static final int U_CARINFO_RAMP_START_ASSIST = 118;
    public static final int U_CARINFO_REAR_BRAKE_PARK_AUTO = 127;
    public static final int U_CARINFO_REAR_BRAKE_PARK_SENSE = 115;
    public static final int U_CARINFO_REAR_PARK_VOL = 121;
    public static final int U_CARINFO_REMOTE_DOOR_UNLOCK = 109;
    public static final int U_CARINFO_SEAT_FACILITATES_ACCESS = 112;
    public static final int U_CARINFO_SMART_KEY_SETTINGS = 104;
    public static final int U_CARINFO_TILT_REARVIEW_MIRROR_WHEN_REVERSING = 124;
    public static final int U_CARINFO_TIRE_JACKS = 137;
    public static final int U_CARINFO_TRAILER = 162;
    public static final int U_CARINFO_TRAILERTYPE = 163;
    public static final int U_CARINFO_TRANSPORT_MODE = 138;
    public static final int U_CARINFO_UNIT_DISTANCE = 87;
    public static final int U_CARINFO_UNIT_FUEL = 86;
    public static final int U_CARINFO_UNIT_PRESS = 89;
    public static final int U_CARINFO_UNIT_TEMP = 88;
    public static final int U_CARINFO_UNIT_UNIT = 85;
    public static final int U_CARINFO_WHEEL_ALIGNMENT_MODE = 139;
    public static final int U_CARINFO_WIN_LIST = 135;
    public static final int U_CARINFO_WIPER_WITH_HEADLIGHT = 95;
    public static final int U_CARINF_D30_D0_D1 = 183;
    public static final int U_CARINF_D30_D2_D3 = 184;
    public static final int U_CARINF_D30_D4_D5_D6 = 185;
    public static final int U_CARINF_D40_D40_D3_B1 = 186;
    public static final int U_CARRADIO_D12_D0_B20 = 408;
    public static final int U_CARRADIO_D12_D0_B3 = 479;
    public static final int U_CARRADIO_D12_D0_B4 = 480;
    public static final int U_CARRADIO_D12_D0_B5 = 481;
    public static final int U_CARRADIO_D12_D0_B6 = 482;
    public static final int U_CARRADIO_D12_D0_B7 = 483;
    public static final int U_CARRADIO_D12_D1_B0 = 409;
    public static final int U_CARRADIO_D12_D1_B1 = 410;
    public static final int U_CARRADIO_D12_D1_B74 = 411;
    public static final int U_CARRADIO_D12_D2_D3 = 412;
    public static final int U_CARRADIO_D12_D4_B70 = 485;
    public static final int U_CARRADIO_D12_D5_B70 = 486;
    public static final int U_CARRADIO_D13_BAND = 413;
    public static final int U_CARRADIO_D14_FRQ = 414;
    public static final int U_CARRADIO_D15_RDS1 = 415;
    public static final int U_CARRADIO_D16_RDS2 = 416;
    public static final int U_CARRADIO_D18_RDS3 = 417;
    public static final int U_CARRADIO_D19_FRQ1 = 418;
    public static final int U_CARRADIO_D19_FRQ10 = 427;
    public static final int U_CARRADIO_D19_FRQ2 = 419;
    public static final int U_CARRADIO_D19_FRQ3 = 420;
    public static final int U_CARRADIO_D19_FRQ4 = 421;
    public static final int U_CARRADIO_D19_FRQ5 = 422;
    public static final int U_CARRADIO_D19_FRQ6 = 423;
    public static final int U_CARRADIO_D19_FRQ7 = 424;
    public static final int U_CARRADIO_D19_FRQ8 = 425;
    public static final int U_CARRADIO_D19_FRQ9 = 426;
    public static final int U_CARRADIO_D1A_RDS4 = 484;
    public static final int U_CARSET_ALTITUDE = 273;
    public static final int U_CARSET_ANGLE = 276;
    public static final int U_CARSET_CALIBRATE = 277;
    public static final int U_CARSET_D12_D0_B70 = 393;
    public static final int U_CARSET_D12_D1_D2 = 394;
    public static final int U_CARSET_D12_D3_D4 = 395;
    public static final int U_CARSET_D12_D5_D6 = 396;
    public static final int U_CARSET_D12_D7_D8 = 397;
    public static final int U_CARSET_D13_D0_B70 = 398;
    public static final int U_CARSET_D17_D0_B0 = 278;
    public static final int U_CARSET_D17_D0_B74 = 406;
    public static final int U_CARSET_D17_D1_B70 = 279;
    public static final int U_CARSET_D17_D2_B70 = 280;
    public static final int U_CARSET_D17_D3_B70 = 281;
    public static final int U_CARSET_D17_D4_B70 = 282;
    public static final int U_CARSET_D17_D5_B70 = 283;
    public static final int U_CARSET_D17_D6_B70 = 284;
    public static final int U_CARSET_D17_D7_B70 = 285;
    public static final int U_CARSET_D17_D8_B30 = 287;
    public static final int U_CARSET_D17_D8_B5 = 407;
    public static final int U_CARSET_D17_D8_B54 = 373;
    public static final int U_CARSET_D17_D8_B6 = 286;
    public static final int U_CARSET_D20_D0_0X40 = 298;
    public static final int U_CARSET_D20_D0_0X41 = 347;
    public static final int U_CARSET_D20_D0_0X43 = 372;
    public static final int U_CARSET_D27_D0_D1 = 376;
    public static final int U_CARSET_D28_D0_D1 = 357;
    public static final int U_CARSET_D40_D00_D2_B70 = 405;
    public static final int U_CARSET_D40_D01_D2_B10 = 348;
    public static final int U_CARSET_D40_D01_D2_B2 = 349;
    public static final int U_CARSET_D40_D02_D1_B0 = 365;
    public static final int U_CARSET_D40_D10_D1_B10 = 428;
    public static final int U_CARSET_D40_D10_D1_B32 = 429;
    public static final int U_CARSET_D40_D10_D1_B4 = 430;
    public static final int U_CARSET_D40_D10_D1_B65 = 431;
    public static final int U_CARSET_D40_D10_D1_B7 = 432;
    public static final int U_CARSET_D40_D10_D2_B0 = 433;
    public static final int U_CARSET_D40_D10_D2_B1 = 434;
    public static final int U_CARSET_D40_D10_D2_B2 = 435;
    public static final int U_CARSET_D40_D10_D2_B3 = 436;
    public static final int U_CARSET_D40_D10_D2_B4 = 437;
    public static final int U_CARSET_D40_D10_D2_B5 = 438;
    public static final int U_CARSET_D40_D10_D2_B6 = 439;
    public static final int U_CARSET_D40_D10_D2_B7 = 440;
    public static final int U_CARSET_D40_D10_D3_B0 = 441;
    public static final int U_CARSET_D40_D10_D3_B1 = 442;
    public static final int U_CARSET_D40_D10_D3_B32 = 443;
    public static final int U_CARSET_D40_D10_D3_B4 = 444;
    public static final int U_CARSET_D40_D10_D3_B5 = 445;
    public static final int U_CARSET_D40_D10_D3_B6 = 446;
    public static final int U_CARSET_D40_D10_D3_B7 = 447;
    public static final int U_CARSET_D40_D11_D1_B0 = 448;
    public static final int U_CARSET_D40_D11_D1_B1 = 449;
    public static final int U_CARSET_D40_D11_D1_B32 = 450;
    public static final int U_CARSET_D40_D11_D1_B4 = 451;
    public static final int U_CARSET_D40_D11_D1_B5 = 452;
    public static final int U_CARSET_D40_D11_D1_B6 = 453;
    public static final int U_CARSET_D40_D11_D1_B7 = 454;
    public static final int U_CARSET_D40_D11_D2_B0 = 455;
    public static final int U_CARSET_D40_D11_D2_B1 = 456;
    public static final int U_CARSET_D40_D11_D2_B2 = 457;
    public static final int U_CARSET_D40_D11_D2_B3 = 458;
    public static final int U_CARSET_D40_D11_D2_B4 = 459;
    public static final int U_CARSET_D40_D11_D2_B5 = 460;
    public static final int U_CARSET_D40_D11_D2_B6 = 461;
    public static final int U_CARSET_D40_D1_D1_B7 = 209;
    public static final int U_CARSET_D40_D30_D1_B6 = 210;
    public static final int U_CARSET_D40_D40_D1_B70 = 462;
    public static final int U_CARSET_D40_D40_D2_B30 = 463;
    public static final int U_CARSET_D40_D41_D1_B70 = 290;
    public static final int U_CARSET_D40_D41_D2_B70 = 291;
    public static final int U_CARSET_D40_D50_D1_B30 = 464;
    public static final int U_CARSET_D40_D50_D1_B74 = 465;
    public static final int U_CARSET_D40_D50_D2_B30 = 467;
    public static final int U_CARSET_D40_D50_D2_B40 = 389;
    public static final int U_CARSET_D40_D50_D2_B7 = 311;
    public static final int U_CARSET_D40_D50_D2_B74 = 466;
    public static final int U_CARSET_D40_D50_D3_B30 = 391;
    public static final int U_CARSET_D40_D50_D3_B74 = 390;
    public static final int U_CARSET_D40_D51_D1_B10 = 468;
    public static final int U_CARSET_D40_D51_D1_B32 = 469;
    public static final int U_CARSET_D40_D51_D1_B54 = 470;
    public static final int U_CARSET_D40_D51_D1_B70 = 392;
    public static final int U_CARSET_D40_D51_D1_B76 = 471;
    public static final int U_CARSET_D40_D51_D2_B10 = 472;
    public static final int U_CARSET_D40_D51_D2_B32 = 473;
    public static final int U_CARSET_D40_D51_D2_B54 = 474;
    public static final int U_CARSET_D40_D51_D2_B76 = 475;
    public static final int U_CARSET_D40_D51_D3_B10 = 476;
    public static final int U_CARSET_D40_D51_D3_B32 = 477;
    public static final int U_CARSET_D40_D5_B5 = 336;
    public static final int U_CARSET_D40_D60_D1_B10 = 366;
    public static final int U_CARSET_D40_D60_D1_B23 = 367;
    public static final int U_CARSET_D40_D60_D1_B4 = 368;
    public static final int U_CARSET_D40_D60_D1_B5 = 369;
    public static final int U_CARSET_D40_D60_D1_B6 = 370;
    public static final int U_CARSET_D40_D60_D1_B7 = 374;
    public static final int U_CARSET_D40_D60_D2_B01 = 402;
    public static final int U_CARSET_D40_D60_D2_B23 = 403;
    public static final int U_CARSET_D40_DA0_D1_B5 = 208;
    public static final int U_CARSET_D40_DA0_D3_B5 = 207;
    public static final int U_CARSET_D40_DA1_D1_B10 = 201;
    public static final int U_CARSET_D40_DA1_D1_B3 = 200;
    public static final int U_CARSET_D40_DA1_D1_B76 = 199;
    public static final int U_CARSET_D40_DA1_D2_B32 = 204;
    public static final int U_CARSET_D40_DA1_D2_B54 = 203;
    public static final int U_CARSET_D40_DA1_D2_B76 = 202;
    public static final int U_CARSET_D40_DA1_D3_B5 = 314;
    public static final int U_CARSET_D40_DA1_D3_B6 = 313;
    public static final int U_CARSET_D40_DA1_D3_B7 = 312;
    public static final int U_CARSET_D40_DC0_D1_B2 = 359;
    public static final int U_CARSET_D40_DC0_D2_B0 = 206;
    public static final int U_CARSET_D40_DC0_D2_B1 = 211;
    public static final int U_CARSET_D40_DC0_D3_B70 = 358;
    public static final int U_CARSET_D40_DD0_D3_B0 = 212;
    public static final int U_CARSET_D40_DD0_D3_B1 = 213;
    public static final int U_CARSET_D40_DD0_D3_B2 = 214;
    public static final int U_CARSET_D40_DE0_D1_B0 = 299;
    public static final int U_CARSET_D40_DE0_D1_B1 = 300;
    public static final int U_CARSET_D40_DE0_D1_B2 = 301;
    public static final int U_CARSET_D40_DE0_D1_B4 = 302;
    public static final int U_CARSET_D40_DE0_D1_B5 = 303;
    public static final int U_CARSET_D40_DE0_D1_B6 = 304;
    public static final int U_CARSET_D40_DE0_D2_B0 = 305;
    public static final int U_CARSET_D40_DE0_D2_B1 = 306;
    public static final int U_CARSET_D40_DE0_D2_B2 = 307;
    public static final int U_CARSET_D40_DE0_D2_B4 = 308;
    public static final int U_CARSET_D40_DE0_D2_B5 = 309;
    public static final int U_CARSET_D40_DE0_D2_B6 = 310;
    public static final int U_CARSET_D40_DE0_D3_B0 = 377;
    public static final int U_CARSET_D40_DE0_D3_B1 = 378;
    public static final int U_CARSET_D40_DE0_D3_B2 = 379;
    public static final int U_CARSET_D40_DE0_D3_B4 = 380;
    public static final int U_CARSET_D40_DE0_D3_B5 = 381;
    public static final int U_CARSET_D40_DE0_D3_B6 = 382;
    public static final int U_CARSET_D42_D1_B2 = 340;
    public static final int U_CARSET_D42_D1_B3 = 341;
    public static final int U_CARSET_D42_D1_B4 = 342;
    public static final int U_CARSET_D42_D2_B70 = 344;
    public static final int U_CARSET_D4C_D0_B70 = 478;
    public static final int U_CARSET_D4D_D0_D1 = 269;
    public static final int U_CARSET_D4D_D2_D3 = 270;
    public static final int U_CARSET_D4E_D0_B70 = 271;
    public static final int U_CARSET_D4E_D1_B70 = 272;
    public static final int U_CARSET_D4E_D4_B70 = 288;
    public static final int U_CARSET_D52_D0_D1 = 215;
    public static final int U_CARSET_D52_D10_D11 = 225;
    public static final int U_CARSET_D52_D12_B70 = 226;
    public static final int U_CARSET_D52_D13_D14 = 289;
    public static final int U_CARSET_D52_D15_D16 = 360;
    public static final int U_CARSET_D52_D17_D18 = 361;
    public static final int U_CARSET_D52_D19_D20 = 362;
    public static final int U_CARSET_D52_D21_D22 = 383;
    public static final int U_CARSET_D52_D2_B0 = 219;
    public static final int U_CARSET_D52_D2_B21 = 218;
    public static final int U_CARSET_D52_D2_B43 = 217;
    public static final int U_CARSET_D52_D2_B75 = 216;
    public static final int U_CARSET_D52_D3_B30 = 221;
    public static final int U_CARSET_D52_D3_B74 = 220;
    public static final int U_CARSET_D52_D4_D5 = 222;
    public static final int U_CARSET_D52_D6_D7 = 223;
    public static final int U_CARSET_D52_D8_D9 = 224;
    public static final int U_CARSET_D53_D0_B0 = 228;
    public static final int U_CARSET_D53_D0_B1 = 227;
    public static final int U_CARSET_D53_D1_D2 = 229;
    public static final int U_CARSET_D53_D3_D4 = 230;
    public static final int U_CARSET_D53_D5_D6 = 231;
    public static final int U_CARSET_D54_D0_B70 = 232;
    public static final int U_CARSET_D54_D10_B70 = 242;
    public static final int U_CARSET_D54_D11_B70 = 243;
    public static final int U_CARSET_D54_D12_B70 = 244;
    public static final int U_CARSET_D54_D13_B70 = 245;
    public static final int U_CARSET_D54_D1_B70 = 233;
    public static final int U_CARSET_D54_D2_B70 = 234;
    public static final int U_CARSET_D54_D3_B70 = 235;
    public static final int U_CARSET_D54_D4_B70 = 236;
    public static final int U_CARSET_D54_D5_B70 = 237;
    public static final int U_CARSET_D54_D6_B70 = 238;
    public static final int U_CARSET_D54_D7_B70 = 239;
    public static final int U_CARSET_D54_D8_B70 = 240;
    public static final int U_CARSET_D54_D9_B70 = 241;
    public static final int U_CARSET_D55_D0_B70 = 246;
    public static final int U_CARSET_D55_D10_B70 = 256;
    public static final int U_CARSET_D55_D11_B70 = 257;
    public static final int U_CARSET_D55_D12_B70 = 258;
    public static final int U_CARSET_D55_D13_B70 = 259;
    public static final int U_CARSET_D55_D1_B70 = 247;
    public static final int U_CARSET_D55_D2_B70 = 248;
    public static final int U_CARSET_D55_D3_B70 = 249;
    public static final int U_CARSET_D55_D4_B70 = 250;
    public static final int U_CARSET_D55_D5_B70 = 251;
    public static final int U_CARSET_D55_D6_B70 = 252;
    public static final int U_CARSET_D55_D7_B70 = 253;
    public static final int U_CARSET_D55_D8_B70 = 254;
    public static final int U_CARSET_D55_D9_B70 = 255;
    public static final int U_CARSET_D56_D0_B0 = 260;
    public static final int U_CARSET_D56_D10_B70 = 293;
    public static final int U_CARSET_D56_D11_B70 = 294;
    public static final int U_CARSET_D56_D12_B70 = 295;
    public static final int U_CARSET_D56_D13_B70 = 296;
    public static final int U_CARSET_D56_D14_B70 = 297;
    public static final int U_CARSET_D56_D1_B70 = 261;
    public static final int U_CARSET_D56_D2_B70 = 262;
    public static final int U_CARSET_D56_D3_B70 = 263;
    public static final int U_CARSET_D56_D4_B70 = 264;
    public static final int U_CARSET_D56_D5_B70 = 265;
    public static final int U_CARSET_D56_D6_B70 = 266;
    public static final int U_CARSET_D56_D7_B70 = 267;
    public static final int U_CARSET_D56_D8_B70 = 268;
    public static final int U_CARSET_D56_D9_B70 = 292;
    public static final int U_CARSET_D57_D0_B30 = 316;
    public static final int U_CARSET_D57_D0_B74 = 315;
    public static final int U_CARSET_D57_D1_B30 = 318;
    public static final int U_CARSET_D57_D1_B74 = 317;
    public static final int U_CARSET_D57_D2_B30 = 320;
    public static final int U_CARSET_D57_D2_B74 = 319;
    public static final int U_CARSET_D57_D3_B30 = 322;
    public static final int U_CARSET_D57_D3_B74 = 321;
    public static final int U_CARSET_D57_D4_B30 = 371;
    public static final int U_CARSET_D58_D0_B30 = 323;
    public static final int U_CARSET_D58_D1_B70 = 324;
    public static final int U_CARSET_D58_D2_B70 = 325;
    public static final int U_CARSET_D58_D3_B70 = 326;
    public static final int U_CARSET_D58_D4_B70 = 327;
    public static final int U_CARSET_D58_D5_B70 = 328;
    public static final int U_CARSET_D59_D0_B30 = 329;
    public static final int U_CARSET_D59_D1_B70 = 330;
    public static final int U_CARSET_D59_D2_B70 = 350;
    public static final int U_CARSET_D59_D2_B74 = 375;
    public static final int U_CARSET_D59_D3_B0 = 384;
    public static final int U_CARSET_D59_D3_B1 = 385;
    public static final int U_CARSET_D59_D3_B2 = 386;
    public static final int U_CARSET_D59_D3_B3 = 387;
    public static final int U_CARSET_D59_D3_B4 = 388;
    public static final int U_CARSET_D5A_D0_B70 = 331;
    public static final int U_CARSET_D5A_D1_D2 = 332;
    public static final int U_CARSET_D5A_D3_D4 = 333;
    public static final int U_CARSET_D5A_D5_D6 = 334;
    public static final int U_CARSET_D5A_D7_D8 = 335;
    public static final int U_CARSET_D5D_D0_B0 = 205;
    public static final int U_CARSET_D5D_D0_B1 = 345;
    public static final int U_CARSET_D5D_D0_B2 = 346;
    public static final int U_CARSET_D5D_D1_B70 = 404;
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
    public static final int U_CARSET_D60_D0_D1 = 351;
    public static final int U_CARSET_D60_D10_D11 = 356;
    public static final int U_CARSET_D60_D12_D13 = 363;
    public static final int U_CARSET_D60_D14_D15 = 364;
    public static final int U_CARSET_D60_D2_D3 = 352;
    public static final int U_CARSET_D60_D4_D5 = 353;
    public static final int U_CARSET_D60_D6_D7 = 354;
    public static final int U_CARSET_D60_D8_D9 = 355;
    public static final int U_CARSET_D63_D0_B54 = 339;
    public static final int U_CARSET_D63_D0_B6 = 338;
    public static final int U_CARSET_D63_D0_B7 = 337;
    public static final int U_CARSET_LATITUDE = 275;
    public static final int U_CARSET_LONGITUDE = 274;
    public static final int U_CNT_MAX = 487;
    public static final int U_CURRENT_OIL_CONSUMPTION = 145;
    public static final int U_DRIVING_MILEAGE = 144;
    public static final int U_OIL_END = 157;
    public static final int U_TRIPA_AVERAGE_OIL = 146;
    public static final int U_TRIPA_AVERAGE_SPEED = 147;
    public static final int U_TRIPA_RESET = 154;
    public static final int U_TRIPA_TRAVEL_DISTANCE = 148;
    public static final int U_TRIPA_TRAVEL_TIME = 149;
    public static final int U_TRIPB_AVERAGE_OIL = 150;
    public static final int U_TRIPB_AVERAGE_SPEED = 151;
    public static final int U_TRIPB_DISPLAY = 156;
    public static final int U_TRIPB_RESET = 155;
    public static final int U_TRIPB_TRAVEL_DISTANCE = 152;
    public static final int U_TRIPB_TRAVEL_TIME = 153;
    public static final int U_VEHICLE_IDENTIFY = 158;
    public static String XMRadio_Band;
    public static String XMRadio_Freq;
    public static String XMRadio_FreqName1;
    public static String XMRadio_FreqName10;
    public static String XMRadio_FreqName2;
    public static String XMRadio_FreqName3;
    public static String XMRadio_FreqName4;
    public static String XMRadio_FreqName5;
    public static String XMRadio_FreqName6;
    public static String XMRadio_FreqName7;
    public static String XMRadio_FreqName8;
    public static String XMRadio_FreqName9;
    public static String XMRadio_RDS1;
    public static String XMRadio_RDS2;
    public static String XMRadio_RDS3;
    public static String XMRadio_RDS4;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 487; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        if (DataCanbus.DATA[1000] == 328054) {
            AirHelper.getInstance().buildUi(new Air_0374_XP_Keleiao(LauncherApplication.getInstance()));
            for (int i3 = 10; i3 < 85; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            }
            DataCanbus.NOTIFY_EVENTS[15].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            return;
        }
        if (DataCanbus.DATA[1000] == 393590) {
            AirHelper.getInstance().buildUi(new Air_0374_XP_Keleiao_H(LauncherApplication.getInstance()));
            for (int i4 = 10; i4 < 85; i4++) {
                DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            }
            DataCanbus.NOTIFY_EVENTS[15].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            DataCanbus.NOTIFY_EVENTS[36].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            return;
        }
        if (DataCanbus.DATA[1000] == 590198 || DataCanbus.DATA[1000] == 1311094 || DataCanbus.DATA[1000] == 1769846) {
            AirHelper.getInstance().buildUi(new Air_0374_XP_Sandero(LauncherApplication.getInstance()));
            for (int i5 = 10; i5 < 85; i5++) {
                DataCanbus.NOTIFY_EVENTS[i5].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            }
            DataCanbus.NOTIFY_EVENTS[15].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            DataCanbus.NOTIFY_EVENTS[36].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            return;
        }
        if (DataCanbus.DATA[1000] == 1245558) {
            AirHelper.getInstance().buildUi(new Air_0374_XP_Megane_Hand(LauncherApplication.getInstance()));
            for (int i6 = 10; i6 < 85; i6++) {
                DataCanbus.NOTIFY_EVENTS[i6].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            }
            DataCanbus.NOTIFY_EVENTS[15].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            DataCanbus.NOTIFY_EVENTS[36].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            return;
        }
        if (DataCanbus.DATA[1000] == 655734) {
            AirHelper.getInstance().buildUi(new Air_0374_XP_Ram1500(LauncherApplication.getInstance()));
            for (int i7 = 10; i7 < 85; i7++) {
                DataCanbus.NOTIFY_EVENTS[i7].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            }
            DataCanbus.NOTIFY_EVENTS[165].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            DataCanbus.NOTIFY_EVENTS[164].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            DataCanbus.NOTIFY_EVENTS[36].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            return;
        }
        if (DataCanbus.DATA[1000] != 1376630 && DataCanbus.DATA[1000] != 1442166 && DataCanbus.DATA[1000] != 1507702 && DataCanbus.DATA[1000] != 1573238 && DataCanbus.DATA[1000] != 1638774 && DataCanbus.DATA[1000] != 1704310 && DataCanbus.DATA[1000] != 2621814 && DataCanbus.DATA[1000] != 2687350 && DataCanbus.DATA[1000] != 2752886 && DataCanbus.DATA[1000] != 2818422 && DataCanbus.DATA[1000] != 1835382 && DataCanbus.DATA[1000] != 1900918 && DataCanbus.DATA[1000] != 2097526 && DataCanbus.DATA[1000] != 2163062 && DataCanbus.DATA[1000] != 1966454 && DataCanbus.DATA[1000] != 2031990 && DataCanbus.DATA[1000] != 2294134 && DataCanbus.DATA[1000] != 2359670 && DataCanbus.DATA[1000] != 2425206 && DataCanbus.DATA[1000] != 2490742 && DataCanbus.DATA[1000] != 2556278 && DataCanbus.DATA[1000] != 2883958 && DataCanbus.DATA[1000] != 2949494 && DataCanbus.DATA[1000] != 3015030 && DataCanbus.DATA[1000] != 3080566 && DataCanbus.DATA[1000] != 3146102 && DataCanbus.DATA[1000] != 3211638 && DataCanbus.DATA[1000] != 3277174 && DataCanbus.DATA[1000] != 3342710 && DataCanbus.DATA[1000] != 3408246 && DataCanbus.DATA[1000] != 3473782 && DataCanbus.DATA[1000] != 3539318 && DataCanbus.DATA[1000] != 3604854 && DataCanbus.DATA[1000] != 3670390 && DataCanbus.DATA[1000] != 3735926 && DataCanbus.DATA[1000] != 3801462 && DataCanbus.DATA[1000] != 3866998 && DataCanbus.DATA[1000] != 3932534 && DataCanbus.DATA[1000] != 3998070) {
            AirHelper.getInstance().buildUi(new Air_0374_XP_ZhiNanZhe(LauncherApplication.getInstance()));
            for (int i8 = 10; i8 < 85; i8++) {
                DataCanbus.NOTIFY_EVENTS[i8].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            }
            DataCanbus.NOTIFY_EVENTS[15].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            DataCanbus.NOTIFY_EVENTS[36].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            DataCanbus.NOTIFY_EVENTS[31].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            DataCanbus.NOTIFY_EVENTS[32].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            DataCanbus.NOTIFY_EVENTS[66].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 85; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(AirHelper.SHOW_AND_REFRESH);
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 487) {
            switch (updateCode) {
                case 180:
                    if (strs != null && strs.length > 0) {
                        Title = strs[0];
                    } else {
                        Title = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 181:
                    if (strs != null && strs.length > 0) {
                        Album = strs[0];
                    } else {
                        Album = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 182:
                    if (strs != null && strs.length > 0) {
                        Artist = strs[0];
                    } else {
                        Artist = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 343:
                    if (ints[0] < 500) {
                        if (strs != null && strs.length > 0) {
                            CD_LIST_DATA[ints[0]] = strs[0];
                        } else {
                            CD_LIST_DATA[ints[0]] = "";
                        }
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 413:
                    if (strs != null && strs.length > 0) {
                        XMRadio_Band = strs[0];
                    } else {
                        XMRadio_Band = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 414:
                    if (strs != null && strs.length > 0) {
                        XMRadio_Freq = strs[0];
                    } else {
                        XMRadio_Freq = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 415:
                    if (strs != null && strs.length > 0) {
                        XMRadio_RDS1 = strs[0];
                    } else {
                        XMRadio_RDS1 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 416:
                    if (strs != null && strs.length > 0) {
                        XMRadio_RDS2 = strs[0];
                    } else {
                        XMRadio_RDS2 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 417:
                    if (strs != null && strs.length > 0) {
                        XMRadio_RDS3 = strs[0];
                    } else {
                        XMRadio_RDS3 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 418:
                    if (strs != null && strs.length > 0) {
                        XMRadio_FreqName1 = strs[0];
                    } else {
                        XMRadio_FreqName1 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 419:
                    if (strs != null && strs.length > 0) {
                        XMRadio_FreqName2 = strs[0];
                    } else {
                        XMRadio_FreqName2 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 420:
                    if (strs != null && strs.length > 0) {
                        XMRadio_FreqName3 = strs[0];
                    } else {
                        XMRadio_FreqName3 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 421:
                    if (strs != null && strs.length > 0) {
                        XMRadio_FreqName4 = strs[0];
                    } else {
                        XMRadio_FreqName4 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 422:
                    if (strs != null && strs.length > 0) {
                        XMRadio_FreqName5 = strs[0];
                    } else {
                        XMRadio_FreqName5 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 423:
                    if (strs != null && strs.length > 0) {
                        XMRadio_FreqName6 = strs[0];
                    } else {
                        XMRadio_FreqName6 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 424:
                    if (strs != null && strs.length > 0) {
                        XMRadio_FreqName7 = strs[0];
                    } else {
                        XMRadio_FreqName7 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 425:
                    if (strs != null && strs.length > 0) {
                        XMRadio_FreqName8 = strs[0];
                    } else {
                        XMRadio_FreqName8 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 426:
                    if (strs != null && strs.length > 0) {
                        XMRadio_FreqName9 = strs[0];
                    } else {
                        XMRadio_FreqName9 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 427:
                    if (strs != null && strs.length > 0) {
                        XMRadio_FreqName10 = strs[0];
                    } else {
                        XMRadio_FreqName10 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case U_CARRADIO_D1A_RDS4 /* 484 */:
                    if (strs != null && strs.length > 0) {
                        XMRadio_RDS4 = strs[0];
                    } else {
                        XMRadio_RDS4 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 487) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }
}
