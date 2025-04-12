package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0374_XP1_ZiYouGuang extends CallbackCanbusBase {
    public static String Album = null;
    public static String Artist = null;
    public static String[] CD_LIST_DATA = new String[500];
    public static String Title = null;
    public static final int U_AIR_ADJUST_STEP = 176;
    public static final int U_AIR_AUX = 411;
    public static final int U_AIR_MAXWINDOW = 177;
    public static final int U_AIR_SEATBACK_LEFT = 412;
    public static final int U_AIR_SEATBACK_RIGHT = 413;
    public static final int U_AIR_TEMP_MODE = 153;
    public static final int U_CARCD_ALBUM = 193;
    public static final int U_CARCD_ARTIST = 194;
    public static final int U_CARCD_BEGIN = 180;
    public static final int U_CARCD_LIST = 355;
    public static final int U_CARCD_PLAYTIME_H = 184;
    public static final int U_CARCD_PLAYTIME_M = 185;
    public static final int U_CARCD_PLAYTIME_S = 186;
    public static final int U_CARCD_PLAYTRACK = 190;
    public static final int U_CARCD_RANDOM = 183;
    public static final int U_CARCD_REPEAT = 182;
    public static final int U_CARCD_TITLE = 192;
    public static final int U_CARCD_TOTALTIME_H = 187;
    public static final int U_CARCD_TOTALTIME_M = 188;
    public static final int U_CARCD_TOTALTIME_S = 189;
    public static final int U_CARCD_TOTALTRACK = 191;
    public static final int U_CARCD_WORKSTATE = 181;
    public static final int U_CARINDO_COMPASS_CAL = 143;
    public static final int U_CARINDO_COMPASS_POINT = 142;
    public static final int U_CARINFO_AURO_DOOR_LOCK = 112;
    public static final int U_CARINFO_AURO_UNLOCK_ON_EXIT = 113;
    public static final int U_CARINFO_AUTOCLOSE = 173;
    public static final int U_CARINFO_AUTO_ADJUST_SUSPENSION = 148;
    public static final int U_CARINFO_AUTO_ANTI_HIGH_BEAM = 109;
    public static final int U_CARINFO_AUTO_BRAKE = 146;
    public static final int U_CARINFO_AUTO_SEAT_START = 125;
    public static final int U_CARINFO_BEGIN = 97;
    public static final int U_CARINFO_BRAKE_LIST_ENABLE = 145;
    public static final int U_CARINFO_BRAKE_PARK_SENSE = 140;
    public static final int U_CARINFO_BUSY_POINT_ALARM = 131;
    public static final int U_CARINFO_COMPASS_DEVIATION_VALUE = 144;
    public static final int U_CARINFO_CORNERLING_LIGHTS = 106;
    public static final int U_CARINFO_DAYTIME_LIGHTS = 105;
    public static final int U_CARINFO_DISPLAY_SUSOENSION_INFO = 152;
    public static final int U_CARINFO_END = 155;
    public static final int U_CARINFO_ENGINE_OFF_POWER_DELAY = 123;
    public static final int U_CARINFO_Environmental_lighting = 179;
    public static final int U_CARINFO_FIRST_PRESS_KEY_UNLOCK = 118;
    public static final int U_CARINFO_FLASH_LIGHTS_WITH_LOCK_LIGHT = 103;
    public static final int U_CARINFO_FLASH_LIGHTS_WITH_LOCK_LOCK = 114;
    public static final int U_CARINFO_FRONT_COLLISION_WARN = 134;
    public static final int U_CARINFO_FRONT_COLLISION_WARN_AUTO_BRAKE = 135;
    public static final int U_CARINFO_FRONT_PARK_VOL = 132;
    public static final int U_CARINFO_GREETING_LIGHT = 111;
    public static final int U_CARINFO_HEADLIGHT_DELAYED = 102;
    public static final int U_CARINFO_HEADLIGHT_DELAYED_ENGINE = 122;
    public static final int U_CARINFO_HEADLIGHT_ILLUMI_ON_APPROACH = 104;
    public static final int U_CARINFO_HEADLIGHT_SENSI = 110;
    public static final int U_CARINFO_HILLSTART = 178;
    public static final int U_CARINFO_HORNWLOCK = 172;
    public static final int U_CARINFO_HORN_LOCK = 115;
    public static final int U_CARINFO_HORN_REMOTE = 120;
    public static final int U_CARINFO_LANE_DEVIATION_CALI = 137;
    public static final int U_CARINFO_LANE_DEVIATION_WARN = 141;
    public static final int U_CARINFO_LANG = 154;
    public static final int U_CARINFO_LIGHTS_WIPERS = 171;
    public static final int U_CARINFO_MIRROR_DIMMING = 108;
    public static final int U_CARINFO_PARKVIEW_DYNAMIC_GUIDE_LINE = 128;
    public static final int U_CARINFO_PARKVIEW_STATIC_GUIDE_LINE = 129;
    public static final int U_CARINFO_PARK_SENSE = 126;
    public static final int U_CARINFO_PASSIVE_ENTRY = 119;
    public static final int U_CARINFO_POWER_LEFT_GATE_ALERT = 117;
    public static final int U_CARINFO_RAIN_SENS_WIPERS = 138;
    public static final int U_CARINFO_RAMP_START_ASSIST = 130;
    public static final int U_CARINFO_REAR_BRAKE_PARK_AUTO = 139;
    public static final int U_CARINFO_REAR_BRAKE_PARK_SENSE = 127;
    public static final int U_CARINFO_REAR_PARK_VOL = 133;
    public static final int U_CARINFO_REMOTE_DOOR_UNLOCK = 121;
    public static final int U_CARINFO_SEAT_FACILITATES_ACCESS = 124;
    public static final int U_CARINFO_SMART_KEY_SETTINGS = 116;
    public static final int U_CARINFO_TILT_REARVIEW_MIRROR_WHEN_REVERSING = 136;
    public static final int U_CARINFO_TIRE_JACKS = 149;
    public static final int U_CARINFO_TRAILER = 174;
    public static final int U_CARINFO_TRAILERTYPE = 175;
    public static final int U_CARINFO_TRANSPORT_MODE = 150;
    public static final int U_CARINFO_UNIT_DISTANCE = 99;
    public static final int U_CARINFO_UNIT_FUEL = 98;
    public static final int U_CARINFO_UNIT_PRESS = 101;
    public static final int U_CARINFO_UNIT_TEMP = 100;
    public static final int U_CARINFO_UNIT_UNIT = 97;
    public static final int U_CARINFO_WHEEL_ALIGNMENT_MODE = 151;
    public static final int U_CARINFO_WIN_LIST = 147;
    public static final int U_CARINFO_WIPER_WITH_HEADLIGHT = 107;
    public static final int U_CARINF_D30_D0_D1 = 195;
    public static final int U_CARINF_D30_D2_D3 = 196;
    public static final int U_CARINF_D30_D4_D5_D6 = 197;
    public static final int U_CARINF_D40_D40_D3_B1 = 198;
    public static final int U_CARRADIO_D12_D0_B20 = 420;
    public static final int U_CARRADIO_D12_D0_B3 = 491;
    public static final int U_CARRADIO_D12_D0_B4 = 492;
    public static final int U_CARRADIO_D12_D0_B5 = 493;
    public static final int U_CARRADIO_D12_D0_B6 = 494;
    public static final int U_CARRADIO_D12_D0_B7 = 495;
    public static final int U_CARRADIO_D12_D1_B0 = 421;
    public static final int U_CARRADIO_D12_D1_B1 = 422;
    public static final int U_CARRADIO_D12_D1_B74 = 423;
    public static final int U_CARRADIO_D12_D2_D3 = 424;
    public static final int U_CARRADIO_D12_D4_B70 = 497;
    public static final int U_CARRADIO_D12_D5_B70 = 498;
    public static final int U_CARRADIO_D13_BAND = 425;
    public static final int U_CARRADIO_D14_FRQ = 426;
    public static final int U_CARRADIO_D15_RDS1 = 427;
    public static final int U_CARRADIO_D16_RDS2 = 428;
    public static final int U_CARRADIO_D18_RDS3 = 429;
    public static final int U_CARRADIO_D19_FRQ1 = 430;
    public static final int U_CARRADIO_D19_FRQ10 = 439;
    public static final int U_CARRADIO_D19_FRQ2 = 431;
    public static final int U_CARRADIO_D19_FRQ3 = 432;
    public static final int U_CARRADIO_D19_FRQ4 = 433;
    public static final int U_CARRADIO_D19_FRQ5 = 434;
    public static final int U_CARRADIO_D19_FRQ6 = 435;
    public static final int U_CARRADIO_D19_FRQ7 = 436;
    public static final int U_CARRADIO_D19_FRQ8 = 437;
    public static final int U_CARRADIO_D19_FRQ9 = 438;
    public static final int U_CARRADIO_D1A_RDS4 = 496;
    public static final int U_CARSET_ALTITUDE = 285;
    public static final int U_CARSET_ANGLE = 288;
    public static final int U_CARSET_CALIBRATE = 289;
    public static final int U_CARSET_D12_D0_B70 = 405;
    public static final int U_CARSET_D12_D1_D2 = 406;
    public static final int U_CARSET_D12_D3_D4 = 407;
    public static final int U_CARSET_D12_D5_D6 = 408;
    public static final int U_CARSET_D12_D7_D8 = 409;
    public static final int U_CARSET_D13_D0_B70 = 410;
    public static final int U_CARSET_D17_D0_B0 = 290;
    public static final int U_CARSET_D17_D0_B74 = 418;
    public static final int U_CARSET_D17_D1_B70 = 291;
    public static final int U_CARSET_D17_D2_B70 = 292;
    public static final int U_CARSET_D17_D3_B70 = 293;
    public static final int U_CARSET_D17_D4_B70 = 294;
    public static final int U_CARSET_D17_D5_B70 = 295;
    public static final int U_CARSET_D17_D6_B70 = 296;
    public static final int U_CARSET_D17_D7_B70 = 297;
    public static final int U_CARSET_D17_D8_B30 = 299;
    public static final int U_CARSET_D17_D8_B5 = 419;
    public static final int U_CARSET_D17_D8_B54 = 385;
    public static final int U_CARSET_D17_D8_B6 = 298;
    public static final int U_CARSET_D20_D0_0X40 = 310;
    public static final int U_CARSET_D20_D0_0X41 = 359;
    public static final int U_CARSET_D20_D0_0X43 = 384;
    public static final int U_CARSET_D27_D0_D1 = 388;
    public static final int U_CARSET_D28_D0_D1 = 369;
    public static final int U_CARSET_D40_D00_D2_B70 = 417;
    public static final int U_CARSET_D40_D01_D2_B10 = 360;
    public static final int U_CARSET_D40_D01_D2_B2 = 361;
    public static final int U_CARSET_D40_D02_D1_B0 = 377;
    public static final int U_CARSET_D40_D10_D1_B10 = 440;
    public static final int U_CARSET_D40_D10_D1_B32 = 441;
    public static final int U_CARSET_D40_D10_D1_B4 = 442;
    public static final int U_CARSET_D40_D10_D1_B65 = 443;
    public static final int U_CARSET_D40_D10_D1_B7 = 444;
    public static final int U_CARSET_D40_D10_D2_B0 = 445;
    public static final int U_CARSET_D40_D10_D2_B1 = 446;
    public static final int U_CARSET_D40_D10_D2_B2 = 447;
    public static final int U_CARSET_D40_D10_D2_B3 = 448;
    public static final int U_CARSET_D40_D10_D2_B4 = 449;
    public static final int U_CARSET_D40_D10_D2_B5 = 450;
    public static final int U_CARSET_D40_D10_D2_B6 = 451;
    public static final int U_CARSET_D40_D10_D2_B7 = 452;
    public static final int U_CARSET_D40_D10_D3_B0 = 453;
    public static final int U_CARSET_D40_D10_D3_B1 = 454;
    public static final int U_CARSET_D40_D10_D3_B32 = 455;
    public static final int U_CARSET_D40_D10_D3_B4 = 456;
    public static final int U_CARSET_D40_D10_D3_B5 = 457;
    public static final int U_CARSET_D40_D10_D3_B6 = 458;
    public static final int U_CARSET_D40_D10_D3_B7 = 459;
    public static final int U_CARSET_D40_D11_D1_B0 = 460;
    public static final int U_CARSET_D40_D11_D1_B1 = 461;
    public static final int U_CARSET_D40_D11_D1_B32 = 462;
    public static final int U_CARSET_D40_D11_D1_B4 = 463;
    public static final int U_CARSET_D40_D11_D1_B5 = 464;
    public static final int U_CARSET_D40_D11_D1_B6 = 465;
    public static final int U_CARSET_D40_D11_D1_B7 = 466;
    public static final int U_CARSET_D40_D11_D2_B0 = 467;
    public static final int U_CARSET_D40_D11_D2_B1 = 468;
    public static final int U_CARSET_D40_D11_D2_B2 = 469;
    public static final int U_CARSET_D40_D11_D2_B3 = 470;
    public static final int U_CARSET_D40_D11_D2_B4 = 471;
    public static final int U_CARSET_D40_D11_D2_B5 = 472;
    public static final int U_CARSET_D40_D11_D2_B6 = 473;
    public static final int U_CARSET_D40_D1_D1_B7 = 221;
    public static final int U_CARSET_D40_D30_D1_B6 = 222;
    public static final int U_CARSET_D40_D40_D1_B70 = 474;
    public static final int U_CARSET_D40_D40_D2_B30 = 475;
    public static final int U_CARSET_D40_D41_D1_B70 = 302;
    public static final int U_CARSET_D40_D41_D2_B70 = 303;
    public static final int U_CARSET_D40_D50_D1_B30 = 476;
    public static final int U_CARSET_D40_D50_D1_B74 = 477;
    public static final int U_CARSET_D40_D50_D2_B30 = 479;
    public static final int U_CARSET_D40_D50_D2_B40 = 401;
    public static final int U_CARSET_D40_D50_D2_B7 = 323;
    public static final int U_CARSET_D40_D50_D2_B74 = 478;
    public static final int U_CARSET_D40_D50_D3_B30 = 403;
    public static final int U_CARSET_D40_D50_D3_B74 = 402;
    public static final int U_CARSET_D40_D51_D1_B10 = 480;
    public static final int U_CARSET_D40_D51_D1_B32 = 481;
    public static final int U_CARSET_D40_D51_D1_B54 = 482;
    public static final int U_CARSET_D40_D51_D1_B70 = 404;
    public static final int U_CARSET_D40_D51_D1_B76 = 483;
    public static final int U_CARSET_D40_D51_D2_B10 = 484;
    public static final int U_CARSET_D40_D51_D2_B32 = 485;
    public static final int U_CARSET_D40_D51_D2_B54 = 486;
    public static final int U_CARSET_D40_D51_D2_B76 = 487;
    public static final int U_CARSET_D40_D51_D3_B10 = 488;
    public static final int U_CARSET_D40_D51_D3_B32 = 489;
    public static final int U_CARSET_D40_D5_B5 = 348;
    public static final int U_CARSET_D40_D60_D1_B10 = 378;
    public static final int U_CARSET_D40_D60_D1_B23 = 379;
    public static final int U_CARSET_D40_D60_D1_B4 = 380;
    public static final int U_CARSET_D40_D60_D1_B5 = 381;
    public static final int U_CARSET_D40_D60_D1_B6 = 382;
    public static final int U_CARSET_D40_D60_D1_B7 = 386;
    public static final int U_CARSET_D40_D60_D2_B01 = 414;
    public static final int U_CARSET_D40_D60_D2_B23 = 415;
    public static final int U_CARSET_D40_DA0_D1_B5 = 220;
    public static final int U_CARSET_D40_DA0_D3_B5 = 219;
    public static final int U_CARSET_D40_DA1_D1_B10 = 213;
    public static final int U_CARSET_D40_DA1_D1_B3 = 212;
    public static final int U_CARSET_D40_DA1_D1_B76 = 211;
    public static final int U_CARSET_D40_DA1_D2_B32 = 216;
    public static final int U_CARSET_D40_DA1_D2_B54 = 215;
    public static final int U_CARSET_D40_DA1_D2_B76 = 214;
    public static final int U_CARSET_D40_DA1_D3_B5 = 326;
    public static final int U_CARSET_D40_DA1_D3_B6 = 325;
    public static final int U_CARSET_D40_DA1_D3_B7 = 324;
    public static final int U_CARSET_D40_DC0_D1_B2 = 371;
    public static final int U_CARSET_D40_DC0_D2_B0 = 218;
    public static final int U_CARSET_D40_DC0_D2_B1 = 223;
    public static final int U_CARSET_D40_DC0_D3_B70 = 370;
    public static final int U_CARSET_D40_DD0_D3_B0 = 224;
    public static final int U_CARSET_D40_DD0_D3_B1 = 225;
    public static final int U_CARSET_D40_DD0_D3_B2 = 226;
    public static final int U_CARSET_D40_DE0_D1_B0 = 311;
    public static final int U_CARSET_D40_DE0_D1_B1 = 312;
    public static final int U_CARSET_D40_DE0_D1_B2 = 313;
    public static final int U_CARSET_D40_DE0_D1_B4 = 314;
    public static final int U_CARSET_D40_DE0_D1_B5 = 315;
    public static final int U_CARSET_D40_DE0_D1_B6 = 316;
    public static final int U_CARSET_D40_DE0_D2_B0 = 317;
    public static final int U_CARSET_D40_DE0_D2_B1 = 318;
    public static final int U_CARSET_D40_DE0_D2_B2 = 319;
    public static final int U_CARSET_D40_DE0_D2_B4 = 320;
    public static final int U_CARSET_D40_DE0_D2_B5 = 321;
    public static final int U_CARSET_D40_DE0_D2_B6 = 322;
    public static final int U_CARSET_D40_DE0_D3_B0 = 389;
    public static final int U_CARSET_D40_DE0_D3_B1 = 390;
    public static final int U_CARSET_D40_DE0_D3_B2 = 391;
    public static final int U_CARSET_D40_DE0_D3_B4 = 392;
    public static final int U_CARSET_D40_DE0_D3_B5 = 393;
    public static final int U_CARSET_D40_DE0_D3_B6 = 394;
    public static final int U_CARSET_D42_D1_B2 = 352;
    public static final int U_CARSET_D42_D1_B3 = 353;
    public static final int U_CARSET_D42_D1_B4 = 354;
    public static final int U_CARSET_D42_D2_B70 = 356;
    public static final int U_CARSET_D4C_D0_B70 = 490;
    public static final int U_CARSET_D4D_D0_D1 = 281;
    public static final int U_CARSET_D4D_D2_D3 = 282;
    public static final int U_CARSET_D4E_D0_B70 = 283;
    public static final int U_CARSET_D4E_D1_B70 = 284;
    public static final int U_CARSET_D4E_D4_B70 = 300;
    public static final int U_CARSET_D52_D0_D1 = 227;
    public static final int U_CARSET_D52_D10_D11 = 237;
    public static final int U_CARSET_D52_D12_B70 = 238;
    public static final int U_CARSET_D52_D13_D14 = 301;
    public static final int U_CARSET_D52_D15_D16 = 372;
    public static final int U_CARSET_D52_D17_D18 = 373;
    public static final int U_CARSET_D52_D19_D20 = 374;
    public static final int U_CARSET_D52_D21_D22 = 395;
    public static final int U_CARSET_D52_D2_B0 = 231;
    public static final int U_CARSET_D52_D2_B21 = 230;
    public static final int U_CARSET_D52_D2_B43 = 229;
    public static final int U_CARSET_D52_D2_B75 = 228;
    public static final int U_CARSET_D52_D3_B30 = 233;
    public static final int U_CARSET_D52_D3_B74 = 232;
    public static final int U_CARSET_D52_D4_D5 = 234;
    public static final int U_CARSET_D52_D6_D7 = 235;
    public static final int U_CARSET_D52_D8_D9 = 236;
    public static final int U_CARSET_D53_D0_B0 = 240;
    public static final int U_CARSET_D53_D0_B1 = 239;
    public static final int U_CARSET_D53_D1_D2 = 241;
    public static final int U_CARSET_D53_D3_D4 = 242;
    public static final int U_CARSET_D53_D5_D6 = 243;
    public static final int U_CARSET_D54_D0_B70 = 244;
    public static final int U_CARSET_D54_D10_B70 = 254;
    public static final int U_CARSET_D54_D11_B70 = 255;
    public static final int U_CARSET_D54_D12_B70 = 256;
    public static final int U_CARSET_D54_D13_B70 = 257;
    public static final int U_CARSET_D54_D1_B70 = 245;
    public static final int U_CARSET_D54_D2_B70 = 246;
    public static final int U_CARSET_D54_D3_B70 = 247;
    public static final int U_CARSET_D54_D4_B70 = 248;
    public static final int U_CARSET_D54_D5_B70 = 249;
    public static final int U_CARSET_D54_D6_B70 = 250;
    public static final int U_CARSET_D54_D7_B70 = 251;
    public static final int U_CARSET_D54_D8_B70 = 252;
    public static final int U_CARSET_D54_D9_B70 = 253;
    public static final int U_CARSET_D55_D0_B70 = 258;
    public static final int U_CARSET_D55_D10_B70 = 268;
    public static final int U_CARSET_D55_D11_B70 = 269;
    public static final int U_CARSET_D55_D12_B70 = 270;
    public static final int U_CARSET_D55_D13_B70 = 271;
    public static final int U_CARSET_D55_D1_B70 = 259;
    public static final int U_CARSET_D55_D2_B70 = 260;
    public static final int U_CARSET_D55_D3_B70 = 261;
    public static final int U_CARSET_D55_D4_B70 = 262;
    public static final int U_CARSET_D55_D5_B70 = 263;
    public static final int U_CARSET_D55_D6_B70 = 264;
    public static final int U_CARSET_D55_D7_B70 = 265;
    public static final int U_CARSET_D55_D8_B70 = 266;
    public static final int U_CARSET_D55_D9_B70 = 267;
    public static final int U_CARSET_D56_D0_B0 = 272;
    public static final int U_CARSET_D56_D10_B70 = 305;
    public static final int U_CARSET_D56_D11_B70 = 306;
    public static final int U_CARSET_D56_D12_B70 = 307;
    public static final int U_CARSET_D56_D13_B70 = 308;
    public static final int U_CARSET_D56_D14_B70 = 309;
    public static final int U_CARSET_D56_D1_B70 = 273;
    public static final int U_CARSET_D56_D2_B70 = 274;
    public static final int U_CARSET_D56_D3_B70 = 275;
    public static final int U_CARSET_D56_D4_B70 = 276;
    public static final int U_CARSET_D56_D5_B70 = 277;
    public static final int U_CARSET_D56_D6_B70 = 278;
    public static final int U_CARSET_D56_D7_B70 = 279;
    public static final int U_CARSET_D56_D8_B70 = 280;
    public static final int U_CARSET_D56_D9_B70 = 304;
    public static final int U_CARSET_D57_D0_B30 = 328;
    public static final int U_CARSET_D57_D0_B74 = 327;
    public static final int U_CARSET_D57_D1_B30 = 330;
    public static final int U_CARSET_D57_D1_B74 = 329;
    public static final int U_CARSET_D57_D2_B30 = 332;
    public static final int U_CARSET_D57_D2_B74 = 331;
    public static final int U_CARSET_D57_D3_B30 = 334;
    public static final int U_CARSET_D57_D3_B74 = 333;
    public static final int U_CARSET_D57_D4_B30 = 383;
    public static final int U_CARSET_D58_D0_B30 = 335;
    public static final int U_CARSET_D58_D1_B70 = 336;
    public static final int U_CARSET_D58_D2_B70 = 337;
    public static final int U_CARSET_D58_D3_B70 = 338;
    public static final int U_CARSET_D58_D4_B70 = 339;
    public static final int U_CARSET_D58_D5_B70 = 340;
    public static final int U_CARSET_D59_D0_B30 = 341;
    public static final int U_CARSET_D59_D1_B70 = 342;
    public static final int U_CARSET_D59_D2_B70 = 362;
    public static final int U_CARSET_D59_D2_B74 = 387;
    public static final int U_CARSET_D59_D3_B0 = 396;
    public static final int U_CARSET_D59_D3_B1 = 397;
    public static final int U_CARSET_D59_D3_B2 = 398;
    public static final int U_CARSET_D59_D3_B3 = 399;
    public static final int U_CARSET_D59_D3_B4 = 400;
    public static final int U_CARSET_D5A_D0_B70 = 343;
    public static final int U_CARSET_D5A_D1_D2 = 344;
    public static final int U_CARSET_D5A_D3_D4 = 345;
    public static final int U_CARSET_D5A_D5_D6 = 346;
    public static final int U_CARSET_D5A_D7_D8 = 347;
    public static final int U_CARSET_D5D_D0_B0 = 217;
    public static final int U_CARSET_D5D_D0_B1 = 357;
    public static final int U_CARSET_D5D_D0_B2 = 358;
    public static final int U_CARSET_D5D_D1_B70 = 416;
    public static final int U_CARSET_D5F_D0_B0 = 206;
    public static final int U_CARSET_D5F_D0_B1 = 205;
    public static final int U_CARSET_D5F_D0_B2 = 204;
    public static final int U_CARSET_D5F_D0_B3 = 203;
    public static final int U_CARSET_D5F_D0_B4 = 202;
    public static final int U_CARSET_D5F_D0_B5 = 201;
    public static final int U_CARSET_D5F_D0_B6 = 200;
    public static final int U_CARSET_D5F_D0_B7 = 199;
    public static final int U_CARSET_D5F_D1_B70 = 207;
    public static final int U_CARSET_D5F_D2_B70 = 208;
    public static final int U_CARSET_D5F_D3_B70 = 209;
    public static final int U_CARSET_D5F_D4_B70 = 210;
    public static final int U_CARSET_D60_D0_D1 = 363;
    public static final int U_CARSET_D60_D10_D11 = 368;
    public static final int U_CARSET_D60_D12_D13 = 375;
    public static final int U_CARSET_D60_D14_D15 = 376;
    public static final int U_CARSET_D60_D2_D3 = 364;
    public static final int U_CARSET_D60_D4_D5 = 365;
    public static final int U_CARSET_D60_D6_D7 = 366;
    public static final int U_CARSET_D60_D8_D9 = 367;
    public static final int U_CARSET_D63_D0_B54 = 351;
    public static final int U_CARSET_D63_D0_B6 = 350;
    public static final int U_CARSET_D63_D0_B7 = 349;
    public static final int U_CARSET_LATITUDE = 287;
    public static final int U_CARSET_LONGITUDE = 286;
    public static final int U_CNT_MAX = 499;
    public static final int U_CURRENT_OIL_CONSUMPTION = 157;
    public static final int U_DRIVING_MILEAGE = 156;
    public static final int U_OIL_END = 169;
    public static final int U_TRIPA_AVERAGE_OIL = 158;
    public static final int U_TRIPA_AVERAGE_SPEED = 159;
    public static final int U_TRIPA_RESET = 166;
    public static final int U_TRIPA_TRAVEL_DISTANCE = 160;
    public static final int U_TRIPA_TRAVEL_TIME = 161;
    public static final int U_TRIPB_AVERAGE_OIL = 162;
    public static final int U_TRIPB_AVERAGE_SPEED = 163;
    public static final int U_TRIPB_DISPLAY = 168;
    public static final int U_TRIPB_RESET = 167;
    public static final int U_TRIPB_TRAVEL_DISTANCE = 164;
    public static final int U_TRIPB_TRAVEL_TIME = 165;
    public static final int U_VEHICLE_IDENTIFY = 170;
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

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 499; i++) {
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
            //AirHelper.getInstance().buildUi(new Air_0374_XP_Keleiao(LauncherApplication.getInstance()));
            for (int i3 = 10; i3 < 97; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            }
            DataCanbus.NOTIFY_EVENTS[15].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            return;
        }
        if (DataCanbus.DATA[1000] == 393590) {
            //AirHelper.getInstance().buildUi(new Air_0374_XP_Keleiao_H(LauncherApplication.getInstance()));
            for (int i4 = 10; i4 < 97; i4++) {
                DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            }
            DataCanbus.NOTIFY_EVENTS[15].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            DataCanbus.NOTIFY_EVENTS[36].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            return;
        }
        if (DataCanbus.DATA[1000] == 590198 || DataCanbus.DATA[1000] == 1311094 || DataCanbus.DATA[1000] == 1769846) {
            //AirHelper.getInstance().buildUi(new Air_0374_XP_Sandero(LauncherApplication.getInstance()));
            for (int i5 = 10; i5 < 97; i5++) {
                DataCanbus.NOTIFY_EVENTS[i5].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            }
            DataCanbus.NOTIFY_EVENTS[15].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            DataCanbus.NOTIFY_EVENTS[36].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            return;
        }
        if (DataCanbus.DATA[1000] == 1245558) {
            //AirHelper.getInstance().buildUi(new Air_0374_XP_Megane_Hand(LauncherApplication.getInstance()));
            for (int i6 = 10; i6 < 97; i6++) {
                DataCanbus.NOTIFY_EVENTS[i6].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            }
            DataCanbus.NOTIFY_EVENTS[15].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            DataCanbus.NOTIFY_EVENTS[36].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            return;
        }
        if (DataCanbus.DATA[1000] == 655734 || DataCanbus.DATA[1000] == 4063606 || DataCanbus.DATA[1000] == 4129142) {
            //AirHelper.getInstance().buildUi(new Air_0374_XP_Ram1500(LauncherApplication.getInstance()));
            for (int i7 = 10; i7 < 97; i7++) {
                DataCanbus.NOTIFY_EVENTS[i7].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            }
            DataCanbus.NOTIFY_EVENTS[177].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            DataCanbus.NOTIFY_EVENTS[176].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            DataCanbus.NOTIFY_EVENTS[36].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            return;
        }
        if (DataCanbus.DATA[1000] != 1376630 && DataCanbus.DATA[1000] != 1442166 && DataCanbus.DATA[1000] != 1507702 && DataCanbus.DATA[1000] != 1573238 && DataCanbus.DATA[1000] != 1638774 && DataCanbus.DATA[1000] != 1704310 && DataCanbus.DATA[1000] != 2621814 && DataCanbus.DATA[1000] != 2687350 && DataCanbus.DATA[1000] != 2752886 && DataCanbus.DATA[1000] != 2818422 && DataCanbus.DATA[1000] != 1835382 && DataCanbus.DATA[1000] != 1900918 && DataCanbus.DATA[1000] != 2097526 && DataCanbus.DATA[1000] != 2163062 && DataCanbus.DATA[1000] != 5177718 && DataCanbus.DATA[1000] != 5243254 && DataCanbus.DATA[1000] != 5308790 && DataCanbus.DATA[1000] != 5374326 && DataCanbus.DATA[1000] != 5439862 && DataCanbus.DATA[1000] != 1966454 && DataCanbus.DATA[1000] != 2031990 && DataCanbus.DATA[1000] != 2294134 && DataCanbus.DATA[1000] != 2359670 && DataCanbus.DATA[1000] != 2425206 && DataCanbus.DATA[1000] != 2490742 && DataCanbus.DATA[1000] != 2556278 && DataCanbus.DATA[1000] != 5046646 && DataCanbus.DATA[1000] != 5112182 && DataCanbus.DATA[1000] != 2883958 && DataCanbus.DATA[1000] != 2949494 && DataCanbus.DATA[1000] != 3015030 && DataCanbus.DATA[1000] != 3080566 && DataCanbus.DATA[1000] != 3146102 && DataCanbus.DATA[1000] != 3211638 && DataCanbus.DATA[1000] != 3277174 && DataCanbus.DATA[1000] != 3342710 && DataCanbus.DATA[1000] != 3408246 && DataCanbus.DATA[1000] != 3473782 && DataCanbus.DATA[1000] != 3539318 && DataCanbus.DATA[1000] != 3604854 && DataCanbus.DATA[1000] != 3670390 && DataCanbus.DATA[1000] != 3735926 && DataCanbus.DATA[1000] != 3801462 && DataCanbus.DATA[1000] != 3866998 && DataCanbus.DATA[1000] != 3932534 && DataCanbus.DATA[1000] != 3998070 && DataCanbus.DATA[1000] != 4260214 && DataCanbus.DATA[1000] != 4325750 && DataCanbus.DATA[1000] != 4391286 && DataCanbus.DATA[1000] != 4456822 && DataCanbus.DATA[1000] != 4522358 && DataCanbus.DATA[1000] != 4587894 && DataCanbus.DATA[1000] != 4653430 && DataCanbus.DATA[1000] != 4718966 && DataCanbus.DATA[1000] != 4784502 && DataCanbus.DATA[1000] != 4850038 && DataCanbus.DATA[1000] != 4915574 && DataCanbus.DATA[1000] != 4981110) {
            //AirHelper.getInstance().buildUi(new Air_0374_XP_ZhiNanZhe(LauncherApplication.getInstance()));
            for (int i8 = 10; i8 < 97; i8++) {
                DataCanbus.NOTIFY_EVENTS[i8].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            }
            DataCanbus.NOTIFY_EVENTS[15].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            DataCanbus.NOTIFY_EVENTS[36].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            DataCanbus.NOTIFY_EVENTS[31].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            DataCanbus.NOTIFY_EVENTS[32].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            DataCanbus.NOTIFY_EVENTS[66].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
        }
    }

    @Override
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(AirHelper.SHOW_AND_REFRESH);
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 499) {
            switch (updateCode) {
                case 192:
                    if (strs != null && strs.length > 0) {
                        Title = strs[0];
                    } else {
                        Title = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 193:
                    if (strs != null && strs.length > 0) {
                        Album = strs[0];
                    } else {
                        Album = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 194:
                    if (strs != null && strs.length > 0) {
                        Artist = strs[0];
                    } else {
                        Artist = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 355:
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
                case 425:
                    if (strs != null && strs.length > 0) {
                        XMRadio_Band = strs[0];
                    } else {
                        XMRadio_Band = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 426:
                    if (strs != null && strs.length > 0) {
                        XMRadio_Freq = strs[0];
                    } else {
                        XMRadio_Freq = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 427:
                    if (strs != null && strs.length > 0) {
                        XMRadio_RDS1 = strs[0];
                    } else {
                        XMRadio_RDS1 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 428:
                    if (strs != null && strs.length > 0) {
                        XMRadio_RDS2 = strs[0];
                    } else {
                        XMRadio_RDS2 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 429:
                    if (strs != null && strs.length > 0) {
                        XMRadio_RDS3 = strs[0];
                    } else {
                        XMRadio_RDS3 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 430:
                    if (strs != null && strs.length > 0) {
                        XMRadio_FreqName1 = strs[0];
                    } else {
                        XMRadio_FreqName1 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 431:
                    if (strs != null && strs.length > 0) {
                        XMRadio_FreqName2 = strs[0];
                    } else {
                        XMRadio_FreqName2 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 432:
                    if (strs != null && strs.length > 0) {
                        XMRadio_FreqName3 = strs[0];
                    } else {
                        XMRadio_FreqName3 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 433:
                    if (strs != null && strs.length > 0) {
                        XMRadio_FreqName4 = strs[0];
                    } else {
                        XMRadio_FreqName4 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 434:
                    if (strs != null && strs.length > 0) {
                        XMRadio_FreqName5 = strs[0];
                    } else {
                        XMRadio_FreqName5 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 435:
                    if (strs != null && strs.length > 0) {
                        XMRadio_FreqName6 = strs[0];
                    } else {
                        XMRadio_FreqName6 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 436:
                    if (strs != null && strs.length > 0) {
                        XMRadio_FreqName7 = strs[0];
                    } else {
                        XMRadio_FreqName7 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 437:
                    if (strs != null && strs.length > 0) {
                        XMRadio_FreqName8 = strs[0];
                    } else {
                        XMRadio_FreqName8 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 438:
                    if (strs != null && strs.length > 0) {
                        XMRadio_FreqName9 = strs[0];
                    } else {
                        XMRadio_FreqName9 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 439:
                    if (strs != null && strs.length > 0) {
                        XMRadio_FreqName10 = strs[0];
                    } else {
                        XMRadio_FreqName10 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case U_CARRADIO_D1A_RDS4 /* 496 */:
                    if (strs != null && strs.length > 0) {
                        XMRadio_RDS4 = strs[0];
                    } else {
                        XMRadio_RDS4 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 499) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }
}
