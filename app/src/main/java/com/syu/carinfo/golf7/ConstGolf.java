package com.syu.carinfo.golf7;

import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class ConstGolf {
    public static final int CONV_CONSUMER_MAX = 7;
    public static final int START_STOP_MAX = 7;
    public static final int U_0_BY_START = 97;
    public static final int U_10_BY_REFUELLING = 107;
    public static final int U_11_BY_REFUELLING = 108;
    public static final int U_12_BY_REFUELLING = 109;
    public static final int U_13_BY_REFUELLING = 110;
    public static final int U_14_BY_REFUELLING = 111;
    public static final int U_15 = 112;
    public static final int U_1_BY_START = 98;
    public static final int U_2_BY_START = 99;
    public static final int U_2_ELECTRIC_BY_LONG = 307;
    public static final int U_2_ELECTRIC_BY_REFUEL = 309;
    public static final int U_2_ELECTRIC_BY_START = 305;
    public static final int U_2_MILEAGE_BY_LONG = 308;
    public static final int U_2_MILEAGE_BY_REFUEL = 310;
    public static final int U_2_MILEAGE_BY_START = 306;
    public static final int U_3_BY_START = 100;
    public static final int U_3_ELECTRIC_DRIVING_MILEAGE = 313;
    public static final int U_3_ELECTRIC_DRIVING_POTENTIAL = 311;
    public static final int U_3_ELECTRIC_ELECTRIC_MILEAGE = 314;
    public static final int U_3_ELECTRIC_ELECTRIC_OIL_RATE = 315;
    public static final int U_3_ELECTRIC_ENERGY_FLOW = 312;
    public static final int U_4_BY_START = 101;
    public static final int U_4_HYBRID_BATTERY_LEVEL = 321;
    public static final int U_4_HYBRID_DRIVE_MODE_BATTERY_CHARGE = 319;
    public static final int U_4_HYBRID_DRIVE_MODE_BATTERY_MAINTAIN = 318;
    public static final int U_4_HYBRID_DRIVE_MODE_E = 316;
    public static final int U_4_HYBRID_DRIVE_MODE_GTE = 320;
    public static final int U_4_HYBRID_DRIVE_MODE_HYBRID = 317;
    public static final int U_5_BY_LONG_TERM = 102;
    public static final int U_6_BY_LONG_TERM = 103;
    public static final int U_7_BY_LONG_TERM = 104;
    public static final int U_8_BY_LONG_TERM = 105;
    public static final int U_9_BY_LONG_TERM = 106;
    public static final int U_ACTIVATEAUTOMATICLLY = 116;
    public static final int U_ACTIVATEMATICLLY = 216;
    public static final int U_AIR_AUTOCYCLE_SET = 212;
    public static final int U_AIR_AUTO_SET = 210;
    public static final int U_AIR_FRONT_SET = 211;
    public static final int U_AUTO_AC_ENABLED = 181;
    public static final int U_BACK_BRIGHT = 213;
    public static final int U_BACK_CONTRAST = 214;
    public static final int U_BACK_SATURATION = 215;
    public static final int U_BLIND_DETECT = 245;
    public static final int U_CARDAY = 167;
    public static final int U_CARDISTANCE = 168;
    public static final int U_CARINFO_OFF_ROAD_ICON = 250;
    public static final int U_CARINFO_OFF_ROAD_KEY = 249;
    public static final int U_CARLOG_SET = 183;
    public static final int U_CARSET_BACKCAR_DELAY = 458;
    public static final int U_CARSET_DOORLOCK = 459;
    public static final int U_CAR_KEY_ACTIVATED = 217;
    public static final int U_CHANGE_AIDS_OD = 286;
    public static final int U_CHANGE_BRIGHT_OD = 287;
    public static final int U_CNT_MAX = 461;
    public static final int U_CUR_SPEED = 188;
    public static final int U_DASHBOARD_SET = 293;
    public static final int U_DASHBOARD_SHOW = 294;
    public static final int U_DAYTIME_RUNNING_LIGHTS = 175;
    public static final int U_DIRECT_TIRE_DETECT = 253;
    public static final int U_DIRIVEOUT_PARK_ASSIST = 244;
    public static final int U_DOOR_LOCK_BY_VOICE = 297;
    public static final int U_DOOR_MIND_PAIR = 208;
    public static final int U_DOOR_SENSE_LAN = 209;
    public static final int U_DRIVERACC = 128;
    public static final int U_DRIVERACTIVE = 129;
    public static final int U_DRIVERADVANCEWARNNINGSETTING = 130;
    public static final int U_DRIVERALERTSYSTEM = 134;
    public static final int U_DRIVERDISPLAYDISTANCEWARNNING = 131;
    public static final int U_DRIVERLANEASSIST = 132;
    public static final int U_DRIVERLANEASSIST_JH = 272;
    public static final int U_DRIVERLASTDISTANCESELECTED = 127;
    public static final int U_DRIVERPROACTIVEOCCUPATION = 135;
    public static final int U_DRIVERPROGRAM = 126;
    public static final int U_DRIVERTRAFFICESIGNRECOGNITION = 133;
    public static final int U_DRIVER_PROTECT_MEMBER_SYS = 270;
    public static final int U_DRIVE_MODE_OD = 285;
    public static final int U_ENGINE_SPEED = 189;
    public static final int U_ESC_SYSTEM = 162;
    public static final int U_FEEDBACK_LAMP_ENABLED = 180;
    public static final int U_FRONTTONE = 118;
    public static final int U_FRONTVOL = 117;
    public static final int U_HANDPART_STATE = 289;
    public static final int U_IDCARNUM = 179;
    public static final int U_INFO_OIL_TEMP = 264;
    public static final int U_INFO_WATER_TEMP = 265;
    public static final int U_INSTANT_FUEL_COST = 271;
    public static final int U_JUMP_CARINFO = 201;
    public static final int U_JUMP_CARINFO_MODE = 298;
    public static final int U_JUMP_SOS_PAGE = 460;
    public static final int U_LIFEBELT_STATE = 290;
    public static final int U_LIGHTAUTOMATICHEADLIGHTRAIN = 140;
    public static final int U_LIGHTCOMINGHOME = 146;
    public static final int U_LIGHTDOORBACKGROUND = 144;
    public static final int U_LIGHTFOOTWELL = 145;
    public static final int U_LIGHTINSTRUMENT = 143;
    public static final int U_LIGHTLANECHANGEFLASH = 141;
    public static final int U_LIGHTLEAVINGHOME = 147;
    public static final int U_LIGHTSWITCHONTIME = 139;
    public static final int U_LIGHTTRAVELMODE = 142;
    public static final int U_LIGHT_ALL = 207;
    public static final int U_LIGHT_ALL_DZSJ = 296;
    public static final int U_LIGHT_ASSIST = 205;
    public static final int U_LIGHT_BEND = 206;
    public static final int U_LIGHT_COLOR = 202;
    public static final int U_LIGHT_FAN = 203;
    public static final int U_LIGHT_RIGHT = 204;
    public static final int U_LIGHT_STATE = 288;
    public static final int U_LIGHT_TURN_LEFT = 291;
    public static final int U_LIGHT_TURN_RIGHT = 292;
    public static final int U_MATCHED_KEYS_NUMBER = 273;
    public static final int U_MIRRORWIPERSLOWWHILEREVESING = 149;
    public static final int U_MIRRORWIPERSREARWINWIPINGINREV = 152;
    public static final int U_MIRRORWIPERSSYNADJUST = 148;
    public static final int U_MORRORWIPERSAUTOWIPINGINRAIN = 151;
    public static final int U_MORRORWIPERSFOLDINWHENPARKED = 150;
    public static final int U_MUTIILDIGITSPEEDDISPLAY = 160;
    public static final int U_MUTILAVERAGECONSUMPTION = 154;
    public static final int U_MUTILAVERAGESPEED = 159;
    public static final int U_MUTILCONVENIENCECONSUMER = 155;
    public static final int U_MUTILCURRENTCONSUMPTION = 153;
    public static final int U_MUTILDISTANCETRAVELLED = 158;
    public static final int U_MUTILECOTIPS = 156;
    public static final int U_MUTILOILTEMP = 176;
    public static final int U_MUTILSPEEDWARNNING = 161;
    public static final int U_MUTILTRAVERLLINGTIME = 157;
    public static final int U_NEWADD_AIR_STEER_SEAT_LEV = 359;
    public static final int U_NEWADD_AIR_STEER_SEAT_ON = 358;
    public static final int U_NEWADD_AUTO_ROAD_NAVI = 323;
    public static final int U_NEWADD_AVTIVATION = 327;
    public static final int U_NEWADD_BACKCAR_MODE = 330;
    public static final int U_NEWADD_BACKGROUND_LIGHTING = 363;
    public static final int U_NEWADD_BACKGROUND_LIGHTING_COLOR = 364;
    public static final int U_NEWADD_BEGIN = 322;
    public static final int U_NEWADD_BLIND_BRIGHT = 357;
    public static final int U_NEWADD_BLIND_SYS = 325;
    public static final int U_NEWADD_CARKEY = 338;
    public static final int U_NEWADD_CARLIGHT_TYPE = 377;
    public static final int U_NEWADD_CHARGING_SET1 = 349;
    public static final int U_NEWADD_CHARGING_SET2 = 350;
    public static final int U_NEWADD_CHARGING_SET3 = 351;
    public static final int U_NEWADD_CHARGING_SET4 = 352;
    public static final int U_NEWADD_CURTIME_H = 456;
    public static final int U_NEWADD_CURTIME_M = 457;
    public static final int U_NEWADD_D40_D10_D2_B70 = 388;
    public static final int U_NEWADD_D40_D30_D1_B7 = 389;
    public static final int U_NEWADD_D40_D40_D1_B7 = 390;
    public static final int U_NEWADD_D40_D53_D1_B70 = 387;
    public static final int U_NEWADD_D40_D53_D2_B30 = 392;
    public static final int U_NEWADD_D40_D53_D2_B7 = 391;
    public static final int U_NEWADD_D40_D53_D3_B50 = 393;
    public static final int U_NEWADD_D40_D53_D4_B50 = 394;
    public static final int U_NEWADD_D50_D70_D0 = 381;
    public static final int U_NEWADD_D50_D70_D1_D2 = 382;
    public static final int U_NEWADD_D50_D71_D0 = 383;
    public static final int U_NEWADD_D50_D71_D1_D2 = 384;
    public static final int U_NEWADD_D50_D72_D0 = 385;
    public static final int U_NEWADD_D50_D72_D1_D2 = 386;
    public static final int U_NEWADD_D50_D80_D0 = 380;
    public static final int U_NEWADD_D52_D0_D1 = 365;
    public static final int U_NEWADD_D52_D10_B70 = 373;
    public static final int U_NEWADD_D52_D2_D3 = 366;
    public static final int U_NEWADD_D52_D4_B42 = 369;
    public static final int U_NEWADD_D52_D4_B5 = 368;
    public static final int U_NEWADD_D52_D4_B76 = 367;
    public static final int U_NEWADD_D52_D5_B70 = 370;
    public static final int U_NEWADD_D52_D6_D7 = 371;
    public static final int U_NEWADD_D52_D8_D9 = 372;
    public static final int U_NEWADD_D53_00_D1_D2 = 374;
    public static final int U_NEWADD_D53_10_D1_D15 = 375;
    public static final int U_NEWADD_D53_11_D16_D30 = 376;
    public static final int U_NEWADD_D54_DT0_D1_B0 = 398;
    public static final int U_NEWADD_D54_DT0_D1_B1 = 397;
    public static final int U_NEWADD_D54_DT0_D1_B2 = 396;
    public static final int U_NEWADD_D54_DT1_D1_B70 = 399;
    public static final int U_NEWADD_D54_DT1_D2_B70 = 400;
    public static final int U_NEWADD_D54_DT1_D3_B10 = 405;
    public static final int U_NEWADD_D54_DT1_D3_B4 = 404;
    public static final int U_NEWADD_D54_DT1_D3_B5 = 403;
    public static final int U_NEWADD_D54_DT1_D3_B6 = 402;
    public static final int U_NEWADD_D54_DT1_D3_B7 = 401;
    public static final int U_NEWADD_D54_DT1_D4_B1 = 412;
    public static final int U_NEWADD_D54_DT1_D4_B2 = 411;
    public static final int U_NEWADD_D54_DT1_D4_B3 = 410;
    public static final int U_NEWADD_D54_DT1_D4_B4 = 409;
    public static final int U_NEWADD_D54_DT1_D4_B5 = 408;
    public static final int U_NEWADD_D54_DT1_D4_B6 = 407;
    public static final int U_NEWADD_D54_DT1_D4_B7 = 406;
    public static final int U_NEWADD_D54_DT1_D5_B70 = 413;
    public static final int U_NEWADD_D54_DT1_D6_B70 = 414;
    public static final int U_NEWADD_D54_DT1_D7_B70 = 415;
    public static final int U_NEWADD_D54_DT1_D8_B70 = 416;
    public static final int U_NEWADD_D54_DT1_D9_B70 = 417;
    public static final int U_NEWADD_D54_DT2_D1_B70 = 418;
    public static final int U_NEWADD_D54_DT2_D2_B70 = 419;
    public static final int U_NEWADD_D54_DT2_D3_B10 = 424;
    public static final int U_NEWADD_D54_DT2_D3_B4 = 423;
    public static final int U_NEWADD_D54_DT2_D3_B5 = 422;
    public static final int U_NEWADD_D54_DT2_D3_B6 = 421;
    public static final int U_NEWADD_D54_DT2_D3_B7 = 420;
    public static final int U_NEWADD_D54_DT2_D4_B1 = 431;
    public static final int U_NEWADD_D54_DT2_D4_B2 = 430;
    public static final int U_NEWADD_D54_DT2_D4_B3 = 429;
    public static final int U_NEWADD_D54_DT2_D4_B4 = 428;
    public static final int U_NEWADD_D54_DT2_D4_B5 = 427;
    public static final int U_NEWADD_D54_DT2_D4_B6 = 426;
    public static final int U_NEWADD_D54_DT2_D4_B7 = 425;
    public static final int U_NEWADD_D54_DT2_D5_B70 = 432;
    public static final int U_NEWADD_D54_DT2_D6_B70 = 433;
    public static final int U_NEWADD_D54_DT2_D7_B70 = 434;
    public static final int U_NEWADD_D54_DT2_D8_B70 = 435;
    public static final int U_NEWADD_D54_DT2_D9_B70 = 436;
    public static final int U_NEWADD_D54_DT3_D1_B70 = 437;
    public static final int U_NEWADD_D54_DT3_D2_B70 = 438;
    public static final int U_NEWADD_D54_DT3_D3_B10 = 443;
    public static final int U_NEWADD_D54_DT3_D3_B4 = 442;
    public static final int U_NEWADD_D54_DT3_D3_B5 = 441;
    public static final int U_NEWADD_D54_DT3_D3_B6 = 440;
    public static final int U_NEWADD_D54_DT3_D3_B7 = 439;
    public static final int U_NEWADD_D54_DT3_D4_B1 = 450;
    public static final int U_NEWADD_D54_DT3_D4_B2 = 449;
    public static final int U_NEWADD_D54_DT3_D4_B3 = 448;
    public static final int U_NEWADD_D54_DT3_D4_B4 = 447;
    public static final int U_NEWADD_D54_DT3_D4_B5 = 446;
    public static final int U_NEWADD_D54_DT3_D4_B6 = 445;
    public static final int U_NEWADD_D54_DT3_D4_B7 = 444;
    public static final int U_NEWADD_D54_DT3_D5_B70 = 451;
    public static final int U_NEWADD_D54_DT3_D6_B70 = 452;
    public static final int U_NEWADD_D54_DT3_D7_B70 = 453;
    public static final int U_NEWADD_D54_DT3_D8_B70 = 454;
    public static final int U_NEWADD_D54_DT3_D9_B70 = 455;
    public static final int U_NEWADD_D54_DTYPE = 395;
    public static final int U_NEWADD_D68_D0 = 378;
    public static final int U_NEWADD_D68_D1 = 379;
    public static final int U_NEWADD_DRIVER_ASSIST = 356;
    public static final int U_NEWADD_DRIVER_SEAT = 337;
    public static final int U_NEWADD_E_MODE = 336;
    public static final int U_NEWADD_FRONT_WINDOW = 332;
    public static final int U_NEWADD_HIGH_BLOW_SLOW = 326;
    public static final int U_NEWADD_INTER_MONITOR = 360;
    public static final int U_NEWADD_LANGUAGE_SETS = 362;
    public static final int U_NEWADD_LIGHT_MODE = 331;
    public static final int U_NEWADD_METER_SET1 = 353;
    public static final int U_NEWADD_METER_SET2 = 354;
    public static final int U_NEWADD_METER_SET3 = 355;
    public static final int U_NEWADD_OFFROAD_UNSER_1 = 339;
    public static final int U_NEWADD_OFFROAD_UNSER_2 = 340;
    public static final int U_NEWADD_OFFROAD_UNSER_3 = 341;
    public static final int U_NEWADD_OFFROAD_UNSER_4 = 342;
    public static final int U_NEWADD_OFFROAD_UNSER_5 = 343;
    public static final int U_NEWADD_OFFROAD_UNSER_6 = 344;
    public static final int U_NEWADD_PARK_STOP = 328;
    public static final int U_NEWADD_REAR_WINDOW = 333;
    public static final int U_NEWADD_RUNAWAY_SYS = 329;
    public static final int U_NEWADD_SKY_WINDOW = 334;
    public static final int U_NEWADD_SOUNC_FACBACK = 361;
    public static final int U_NEWADD_TANGE_UNSER_1 = 345;
    public static final int U_NEWADD_TANGE_UNSER_2 = 346;
    public static final int U_NEWADD_TANGE_UNSER_3 = 347;
    public static final int U_NEWADD_TANGE_UNSER_4 = 348;
    public static final int U_NEWADD_UNIT_ELECTRICITY = 335;
    public static final int U_NEWADD_WARN_TISHI = 324;
    public static final int U_OILBOX_SET = 295;
    public static final int U_OILDAY = 169;
    public static final int U_OILDISTANCE = 170;
    public static final int U_OIL_MARK_MAX = 113;
    public static final int U_OIL_PROGRESS = 114;
    public static final int U_OIL_UNIT = 115;
    public static final int U_OPENCLOSEAUTOLOCK = 138;
    public static final int U_OPENCLOSECONVENIENCE = 136;
    public static final int U_OPENCLOSEDOORUNLOCK = 137;
    public static final int U_PARK = 121;
    public static final int U_RADARMUTE = 122;
    public static final int U_REARTONE = 120;
    public static final int U_REARVOL = 119;
    public static final int U_SETTING_86D10 = 248;
    public static final int U_SETTING_86D11 = 247;
    public static final int U_SETTING_86D12 = 246;
    public static final int U_SETTING_86D13 = 194;
    public static final int U_SETTING_86D13_ENABLE = 269;
    public static final int U_SETTING_86D14 = 193;
    public static final int U_SETTING_86D15 = 192;
    public static final int U_SETTING_86D16 = 191;
    public static final int U_SETTING_86D17 = 190;
    public static final int U_SETTING_86D20 = 198;
    public static final int U_SETTING_86D22 = 197;
    public static final int U_SETTING_86D24 = 196;
    public static final int U_SETTING_86D26 = 195;
    public static final int U_SETTING_86D36 = 200;
    public static final int U_SETTING_86D37 = 199;
    public static final int U_SET_BACKCAR_BRIGTHNESS = 267;
    public static final int U_SET_BACKCAR_COLOR = 266;
    public static final int U_SET_BACKCAR_CONTRAST = 268;
    public static final int U_SET_DRIVEMODE = 254;
    public static final int U_SET_FOOTLIGHT_VALUE = 224;
    public static final int U_SET_FRONT_WINDOW = 226;
    public static final int U_SET_HOMELIGHT = 222;
    public static final int U_SET_HYBRID_AIR_USE_BATTERY_SWITCH = 302;
    public static final int U_SET_HYBRID_CHARGE_CURRENT_MAX = 300;
    public static final int U_SET_HYBRID_CHARGE_LOW_LIMIT = 303;
    public static final int U_SET_HYBRID_TEMPERATURE_INTER = 301;
    public static final int U_SET_HYBRID_VISIBLE_OR_GONE = 299;
    public static final int U_SET_INSIDECARLIGHT_VALUE = 225;
    public static final int U_SET_LEAVEHOMELIGHT = 223;
    public static final int U_SET_LEFT_DRIVE = 220;
    public static final int U_SET_LIGHT_DISTANCE = 277;
    public static final int U_SET_MAINTEN_CHECK_DATE = 240;
    public static final int U_SET_MAINTEN_CHECK_MILES = 239;
    public static final int U_SET_MAINTEN_CHECK_PERIOD_DATE = 242;
    public static final int U_SET_MAINTEN_CHECK_PERIOD_MILES = 241;
    public static final int U_SET_MILES_UNIT = 238;
    public static final int U_SET_OFFROAD_4ENGINE = 257;
    public static final int U_SET_OFFROAD_ACC = 263;
    public static final int U_SET_OFFROAD_AIRCONDITION = 258;
    public static final int U_SET_OFFROAD_BEND = 262;
    public static final int U_SET_OFFROAD_DOWNHILL_ASSIST = 259;
    public static final int U_SET_OFFROAD_ENGINE = 255;
    public static final int U_SET_OFFROAD_PARKING_ASSIST = 261;
    public static final int U_SET_OFFROAD_RAMP_START = 260;
    public static final int U_SET_OFFROAD_STEER = 256;
    public static final int U_SET_OIL_VOLUME = 237;
    public static final int U_SET_ONLYUNLOCK_LUGGAGE = 230;
    public static final int U_SET_PARKING_BRAKE = 276;
    public static final int U_SET_RAINBRUSH_AT_MAITEN = 243;
    public static final int U_SET_RAIN_SENSOR = 218;
    public static final int U_SET_REAR_WINDOW = 227;
    public static final int U_SET_REMAINING_OIL = 278;
    public static final int U_SET_REVERSE_REARMIRROR = 229;
    public static final int U_SET_SKY_WINDOW = 228;
    public static final int U_SET_SMART_BIGLIGHT = 221;
    public static final int U_SET_UNIT_CAPACITY = 234;
    public static final int U_SET_UNIT_DISTANCE = 231;
    public static final int U_SET_UNIT_ENERGEY_COMSUME = 235;
    public static final int U_SET_UNIT_SPEED = 232;
    public static final int U_SET_UNIT_TEMP = 233;
    public static final int U_SET_UNIT_TIRE_PRESS = 236;
    public static final int U_SPEEDWARNNING = 124;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 182;
    public static final int U_TEMPERATUREUNIT = 174;
    public static final int U_TIRE_ALARM = 279;
    public static final int U_TIRE_DISPLAY = 251;
    public static final int U_TIRE_PRESSURE_CK_FL = 281;
    public static final int U_TIRE_PRESSURE_CK_FR = 282;
    public static final int U_TIRE_PRESSURE_CK_RL = 283;
    public static final int U_TIRE_PRESSURE_CK_RR = 284;
    public static final int U_TIRE_PRESSURE_FL = 184;
    public static final int U_TIRE_PRESSURE_FR = 185;
    public static final int U_TIRE_PRESSURE_LOAD_STATUS = 274;
    public static final int U_TIRE_PRESSURE_RL = 186;
    public static final int U_TIRE_PRESSURE_RR = 187;
    public static final int U_TIRE_PRESSURE_TYPE = 275;
    public static final int U_TIRE_PRESSURE_UNIT = 280;
    public static final int U_TIRE_UNIT = 252;
    public static final int U_TPMS = 123;
    public static final int U_UNITCONSUMPTION = 165;
    public static final int U_UNITMILEAGE = 177;
    public static final int U_UNITPRESSURE = 166;
    public static final int U_UNITSPEED = 178;
    public static final int U_UNITTEMPERATURE = 163;
    public static final int U_UNITVOLUME = 164;
    public static final int U_UNIT_ELECTRICITY = 304;
    public static final int U_WARNNINGAT = 125;
    public static final int U_WARNNING_CONV_CONSUMER = 173;
    public static final int U_WARNNING_START_STOP = 172;
    public static final int U_WARNNING_VEHICLE = 171;
    public static final int VEHICLE_WARNING_MAX = 16;
    public static String mCarId = null;
    public static int sCarMove_x = 0;
    public static int[][] mConvConsumer = new int[7][];
    public static int[][] mSartStop = new int[7][];
    public static int[][] mVehicleWarning = new int[16][];

    public static boolean isWcGolf() {
        return DataCanbus.DATA[1000] == 17 || DataCanbus.DATA[1000] == 65553 || DataCanbus.DATA[1000] == 131089 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769 || DataCanbus.DATA[1000] == 131342 || DataCanbus.DATA[1000] == 262414 || DataCanbus.DATA[1000] == 327950 || DataCanbus.DATA[1000] == 262414 || DataCanbus.DATA[1000] == 270 || DataCanbus.DATA[1000] == 45 || DataCanbus.DATA[1000] == 196625 || DataCanbus.DATA[1000] == 262161 || DataCanbus.DATA[1000] == 327697 || DataCanbus.DATA[1000] == 589841 || DataCanbus.DATA[1000] == 720913 || DataCanbus.DATA[1000] == 655377 || DataCanbus.DATA[1000] == 524305 || DataCanbus.DATA[1000] == 786449 || DataCanbus.DATA[1000] == 851985 || DataCanbus.DATA[1000] == 917521 || DataCanbus.DATA[1000] == 983057 || DataCanbus.DATA[1000] == 1048593 || DataCanbus.DATA[1000] == 1114129 || DataCanbus.DATA[1000] == 1179665 || DataCanbus.DATA[1000] == 1245201 || DataCanbus.DATA[1000] == 1310737 || DataCanbus.DATA[1000] == 1376273 || DataCanbus.DATA[1000] == 1441809 || DataCanbus.DATA[1000] == 1507345 || DataCanbus.DATA[1000] == 1572881 || DataCanbus.DATA[1000] == 1638417 || DataCanbus.DATA[1000] == 1703953 || DataCanbus.DATA[1000] == 1769489 || DataCanbus.DATA[1000] == 1835025 || DataCanbus.DATA[1000] == 1900561 || DataCanbus.DATA[1000] == 1966097 || DataCanbus.DATA[1000] == 2031633 || DataCanbus.DATA[1000] == 2097169 || DataCanbus.DATA[1000] == 2162705 || DataCanbus.DATA[1000] == 2228241 || DataCanbus.DATA[1000] == 2293777 || DataCanbus.DATA[1000] == 2359313 || DataCanbus.DATA[1000] == 2424849 || DataCanbus.DATA[1000] == 2490385 || DataCanbus.DATA[1000] == 2555921 || DataCanbus.DATA[1000] == 2621457 || DataCanbus.DATA[1000] == 2686993 || DataCanbus.DATA[1000] == 2752529 || DataCanbus.DATA[1000] == 2818065;
    }

    public static boolean isRZCGolf() {
        switch (DataCanbus.DATA[1000]) {
            case 160:
            case FinalCanbus.CAR2_RZC_XP1_DaZhong_GaoErFu7_H /* 131232 */:
            case FinalCanbus.CAR_RZC_XP1_MaiTeng /* 196768 */:
            case FinalCanbus.CAR_RZC_TuGuan_L /* 262304 */:
            case FinalCanbus.CAR_RZC_TuAng /* 327840 */:
            case FinalCanbus.CAR_RZC_DaZhong_MQB_SUP /* 458912 */:
            case FinalCanbus.CAR_RZC_DaZhong_MQB_SUP_H /* 524448 */:
            case FinalCanbus.CAR2_RZC_DaZhong_Tange /* 589984 */:
            case FinalCanbus.CAR2_RZC_DaZhong_MQB_E /* 655520 */:
            case FinalCanbus.CAR_RZC_TuGuan_L_20 /* 721056 */:
            case FinalCanbus.CAR_RZC_MQB_18_19Lavida_plus /* 786592 */:
            case FinalCanbus.CAR_RZC_MQB_11_18Sagitar /* 852128 */:
            case FinalCanbus.CAR_RZC_MQB_19Sagitar /* 917664 */:
            case FinalCanbus.CAR_RZC_MQB_11_17Passat /* 983200 */:
            case FinalCanbus.CAR_RZC_MQB_19Passat /* 1048736 */:
            case FinalCanbus.CAR_RZC_MQB_19Tharu /* 1179808 */:
            case FinalCanbus.CAR_RZC_MQB_14_19Golf7 /* 1310880 */:
            case FinalCanbus.CAR_RZC_MQB_19Bora /* 1376416 */:
            case FinalCanbus.CAR_RZC_MQB_14_19Lamando /* 1441952 */:
            case FinalCanbus.CAR_RZC_MQB_19Polo /* 1507488 */:
            case FinalCanbus.CAR_RZC_MQB_19CC /* 1573024 */:
            case FinalCanbus.CAR_RZC_MQB_19T_Cross /* 1638560 */:
            case FinalCanbus.CAR_RZC_MQB_16_18TouranL /* 1704096 */:
            case FinalCanbus.CAR_RZC_MQB_17_18C_Trek /* 1769632 */:
            case FinalCanbus.CAR_RZC_MQB_16_19Golf_jialv /* 1835168 */:
            case FinalCanbus.CAR_RZC_MQB_19T_ROC /* 1900704 */:
            case FinalCanbus.CAR_RZC_MQB_19Tayron /* 1966240 */:
            case FinalCanbus.CAR_RZC_MQB_13_14Octavia /* 2031776 */:
            case FinalCanbus.CAR_RZC_MQB_15_19Octavia /* 2097312 */:
            case FinalCanbus.CAR_RZC_MQB_13_15Superb /* 2162848 */:
            case FinalCanbus.CAR_RZC_MQB_16_18Superb /* 2228384 */:
            case FinalCanbus.CAR_RZC_MQB_18Kamiq /* 2293920 */:
            case FinalCanbus.CAR_RZC_MQB_18_19Karoq /* 2359456 */:
            case FinalCanbus.CAR_RZC_MQB_17_19Kodiaq /* 2424992 */:
            case FinalCanbus.CAR_RZC_MQB_14_18Caravan /* 2490528 */:
            case FinalCanbus.CAR_RZC_MQB_19Jetta_VS5 /* 2556064 */:
            case FinalCanbus.CAR_RZC_MQB_11_17Touareg /* 2621600 */:
            case FinalCanbus.CAR_RZC_MQB_09_19Multivan /* 2687136 */:
            case FinalCanbus.CAR_RZC_MQB_Jetta_Brazil /* 2752672 */:
            case FinalCanbus.CAR_RZC_MQB_SUPERB_Turkey /* 2818208 */:
            case FinalCanbus.CAR_RZC_MQB_LAVIDA_19_E /* 2883744 */:
            case FinalCanbus.CAR_RZC_MQB_GOLF_20_E /* 2949280 */:
            case FinalCanbus.CAR_RZC_MQB_BORA_20_E /* 3014816 */:
            case FinalCanbus.CAR_RZC_MQB_Huiang_21 /* 3080352 */:
            case FinalCanbus.CAR_RZC_MQB_20Tayron_GTE /* 3145888 */:
            case FinalCanbus.CAR_RZC_MQB_20Jetta_VS7 /* 3211424 */:
            case FinalCanbus.CAR_RZC_MQB_20Viloran /* 3276960 */:
            case FinalCanbus.CAR_RZC_MQB_21Golf8 /* 3342496 */:
            case FinalCanbus.CAR_RZC_MQB_16_18Weilan /* 3408032 */:
            case FinalCanbus.CAR_RZC_TuGuan_L_20_H /* 3473568 */:
            case FinalCanbus.CAR_6606_MQB_Lavida_23 /* 3539104 */:
            case FinalCanbus.CAR_RZC_MQB_17Passat_B8 /* 3604640 */:
            case FinalCanbus.CAR_RZC_MQB_All_360 /* 3670176 */:
            case FinalCanbus.CAR_RZC_MQB_Caddy_22 /* 3735712 */:
            case FinalCanbus.CAR_RZC_MaiTeng_20_H_EC /* 3801248 */:
                return true;
            default:
                return false;
        }
    }
}
