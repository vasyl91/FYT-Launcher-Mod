package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_OD_Fengye_80V;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0452_OD_Fengye_80V extends CallbackCanbusBase {
    public static final int U_CARINF_D60_D0_B3 = 301;
    public static final int U_CARINF_D60_D0_B4 = 300;
    public static final int U_CARINF_D60_D0_B5 = 299;
    public static final int U_CARINF_D60_D0_B6 = 298;
    public static final int U_CARINF_D60_D0_B7 = 297;
    public static final int U_CARINF_D60_D13_B70 = 308;
    public static final int U_CARINF_D60_D1_B70 = 302;
    public static final int U_CARINF_D60_D2_B70 = 303;
    public static final int U_CARINF_D60_D3_D4 = 304;
    public static final int U_CARINF_D60_D5_D6 = 305;
    public static final int U_CARINF_D60_D7_D8 = 306;
    public static final int U_CARINF_D60_D9_D12 = 307;
    public static final int U_CARINF_D61_D0_D1 = 309;
    public static final int U_CARINF_D61_D13_B70 = 314;
    public static final int U_CARINF_D61_D14_B70 = 315;
    public static final int U_CARINF_D61_D15_B70 = 316;
    public static final int U_CARINF_D61_D16_B70 = 317;
    public static final int U_CARINF_D61_D17_B70 = 318;
    public static final int U_CARINF_D61_D18_B70 = 319;
    public static final int U_CARINF_D61_D2_D5 = 310;
    public static final int U_CARINF_D61_D6_B70 = 311;
    public static final int U_CARINF_D61_D7_D8 = 312;
    public static final int U_CARINF_D61_D9_D12 = 313;
    public static final int U_CARSET_D4D_D0_B10 = 181;
    public static final int U_CARSET_D4D_D0_B2 = 180;
    public static final int U_CARSET_D4D_D0_B3 = 179;
    public static final int U_CARSET_D4D_D1_B0 = 182;
    public static final int U_CARSET_D4D_D2_B10 = 185;
    public static final int U_CARSET_D4D_D2_B5 = 184;
    public static final int U_CARSET_D4D_D2_B7 = 183;
    public static final int U_CARSET_D4E_D0_B10 = 159;
    public static final int U_CARSET_D4E_D1_B4 = 161;
    public static final int U_CARSET_D4E_D1_B7 = 160;
    public static final int U_CARSET_D4E_D3_B0 = 166;
    public static final int U_CARSET_D4E_D3_B1 = 165;
    public static final int U_CARSET_D4E_D3_B2 = 164;
    public static final int U_CARSET_D4E_D3_B43 = 163;
    public static final int U_CARSET_D4E_D3_B5 = 162;
    public static final int U_CARSET_D4E_D4_B1 = 170;
    public static final int U_CARSET_D4E_D4_B32 = 169;
    public static final int U_CARSET_D4E_D4_B5 = 168;
    public static final int U_CARSET_D4E_D4_B7 = 167;
    public static final int U_CARSET_D4E_D5_B2 = 174;
    public static final int U_CARSET_D4E_D5_B3 = 173;
    public static final int U_CARSET_D4E_D5_B4 = 172;
    public static final int U_CARSET_D4E_D5_B7 = 171;
    public static final int U_CARSET_D4E_D6_B70 = 175;
    public static final int U_CARSET_D4E_D7_B30 = 177;
    public static final int U_CARSET_D4E_D7_B74 = 176;
    public static final int U_CARSET_D4E_D8_B70 = 178;
    public static final int U_CARSET_D4F_D0_B10 = 135;
    public static final int U_CARSET_D4F_D0_B2 = 134;
    public static final int U_CARSET_D4F_D1_B5 = 138;
    public static final int U_CARSET_D4F_D1_B6 = 137;
    public static final int U_CARSET_D4F_D1_B7 = 136;
    public static final int U_CARSET_D4F_D2_B3 = 140;
    public static final int U_CARSET_D4F_D2_B65 = 139;
    public static final int U_CARSET_D4F_D3_B0 = 144;
    public static final int U_CARSET_D4F_D3_B1 = 143;
    public static final int U_CARSET_D4F_D3_B2 = 142;
    public static final int U_CARSET_D4F_D3_B43 = 141;
    public static final int U_CARSET_D4F_D4_B0 = 151;
    public static final int U_CARSET_D4F_D4_B1 = 150;
    public static final int U_CARSET_D4F_D4_B32 = 149;
    public static final int U_CARSET_D4F_D4_B4 = 148;
    public static final int U_CARSET_D4F_D4_B5 = 147;
    public static final int U_CARSET_D4F_D4_B6 = 146;
    public static final int U_CARSET_D4F_D4_B7 = 145;
    public static final int U_CARSET_D4F_D5_B5 = 154;
    public static final int U_CARSET_D4F_D5_B6 = 153;
    public static final int U_CARSET_D4F_D5_B7 = 152;
    public static final int U_CARSET_D4F_D6_B70 = 155;
    public static final int U_CARSET_D4F_D7_B6 = 157;
    public static final int U_CARSET_D4F_D7_B7 = 156;
    public static final int U_CARSET_D4F_D8_B70 = 158;
    public static final int U_CARSET_D50_D0_B10 = 98;
    public static final int U_CARSET_D50_D1_B10 = 100;
    public static final int U_CARSET_D50_D1_B2 = 121;
    public static final int U_CARSET_D50_D1_B3 = 120;
    public static final int U_CARSET_D50_D1_B74 = 99;
    public static final int U_CARSET_D50_D2_B10 = 105;
    public static final int U_CARSET_D50_D2_B2 = 104;
    public static final int U_CARSET_D50_D2_B3 = 103;
    public static final int U_CARSET_D50_D2_B4 = 102;
    public static final int U_CARSET_D50_D2_B65 = 101;
    public static final int U_CARSET_D50_D3_B0 = 107;
    public static final int U_CARSET_D50_D3_B1 = 106;
    public static final int U_CARSET_D50_D4_B10 = 189;
    public static final int U_CARSET_D50_D4_B2 = 188;
    public static final int U_CARSET_D50_D4_B3 = 187;
    public static final int U_CARSET_D50_D4_B4 = 186;
    public static final int U_CARSET_D50_D4_B5 = 124;
    public static final int U_CARSET_D50_D4_B6 = 123;
    public static final int U_CARSET_D50_D4_B7 = 122;
    public static final int U_CARSET_D50_D5_B70 = 125;
    public static final int U_CARSET_D50_D6_B30 = 127;
    public static final int U_CARSET_D50_D6_B54 = 126;
    public static final int U_CARSET_D50_D7_B70 = 128;
    public static final int U_CARSET_D50_D8_B20 = 133;
    public static final int U_CARSET_D50_D8_B4 = 132;
    public static final int U_CARSET_D50_D8_B5 = 131;
    public static final int U_CARSET_D50_D8_B6 = 130;
    public static final int U_CARSET_D50_D8_B7 = 129;
    public static final int U_CARSET_JIAJI_D23_D9_B54 = 259;
    public static final int U_CARSET_JIAJI_D23_D9_B76 = 258;
    public static final int U_CARSET_JIAJI_D50_D0_B10 = 191;
    public static final int U_CARSET_JIAJI_D50_D0_B32 = 190;
    public static final int U_CARSET_JIAJI_D50_D1_B10 = 194;
    public static final int U_CARSET_JIAJI_D50_D1_B32 = 193;
    public static final int U_CARSET_JIAJI_D50_D1_B74 = 192;
    public static final int U_CARSET_JIAJI_D50_D2_B0 = 202;
    public static final int U_CARSET_JIAJI_D50_D2_B1 = 201;
    public static final int U_CARSET_JIAJI_D50_D2_B2 = 200;
    public static final int U_CARSET_JIAJI_D50_D2_B3 = 199;
    public static final int U_CARSET_JIAJI_D50_D2_B4 = 198;
    public static final int U_CARSET_JIAJI_D50_D2_B5 = 197;
    public static final int U_CARSET_JIAJI_D50_D2_B6 = 196;
    public static final int U_CARSET_JIAJI_D50_D2_B7 = 195;
    public static final int U_CARSET_JIAJI_D50_D3_B0 = 206;
    public static final int U_CARSET_JIAJI_D50_D3_B1 = 205;
    public static final int U_CARSET_JIAJI_D50_D3_B2 = 204;
    public static final int U_CARSET_JIAJI_D50_D3_B43 = 203;
    public static final int U_CARSET_JIAJI_D50_D4_B0 = 214;
    public static final int U_CARSET_JIAJI_D50_D4_B1 = 213;
    public static final int U_CARSET_JIAJI_D50_D4_B2 = 212;
    public static final int U_CARSET_JIAJI_D50_D4_B3 = 211;
    public static final int U_CARSET_JIAJI_D50_D4_B4 = 210;
    public static final int U_CARSET_JIAJI_D50_D4_B5 = 209;
    public static final int U_CARSET_JIAJI_D50_D4_B6 = 208;
    public static final int U_CARSET_JIAJI_D50_D4_B7 = 207;
    public static final int U_CARSET_JIAJI_D50_D6_B30 = 218;
    public static final int U_CARSET_JIAJI_D50_D6_B4 = 217;
    public static final int U_CARSET_JIAJI_D50_D6_B5 = 216;
    public static final int U_CARSET_JIAJI_D50_D6_B76 = 215;
    public static final int U_CARSET_JIAJI_D50_D7_B70 = 219;
    public static final int U_CARSET_JIAJI_D50_D8_B10 = 225;
    public static final int U_CARSET_JIAJI_D50_D8_B2 = 224;
    public static final int U_CARSET_JIAJI_D50_D8_B3 = 223;
    public static final int U_CARSET_JIAJI_D50_D8_B4 = 222;
    public static final int U_CARSET_JIAJI_D50_D8_B65 = 221;
    public static final int U_CARSET_JIAJI_D50_D8_B7 = 220;
    public static final int U_CARSET_JIAJI_D50_D9_B0 = 229;
    public static final int U_CARSET_JIAJI_D50_D9_B1 = 228;
    public static final int U_CARSET_JIAJI_D50_D9_B2 = 227;
    public static final int U_CARSET_JIAJI_D50_D9_B3 = 226;
    public static final int U_CARSET_RADAR_D50_D0_B30 = 288;
    public static final int U_CARSET_RADAR_D50_D0_B54 = 287;
    public static final int U_CARSET_RADAR_D50_D0_B7 = 286;
    public static final int U_CARSET_RADAR_D50_D1_B10 = 290;
    public static final int U_CARSET_RADAR_D50_D1_B32 = 289;
    public static final int U_CARSET_RADAR_D50_D2_B2 = 292;
    public static final int U_CARSET_RADAR_D50_D2_B3 = 291;
    public static final int U_CARSET_RADAR_D50_D4_B0 = 296;
    public static final int U_CARSET_RADAR_D50_D4_B1 = 295;
    public static final int U_CARSET_RADAR_D50_D4_B2 = 294;
    public static final int U_CARSET_RADAR_D50_D4_B3 = 293;
    public static final int U_CARSET_XRUI_D50_D0_B10 = 231;
    public static final int U_CARSET_XRUI_D50_D0_B32 = 230;
    public static final int U_CARSET_XRUI_D50_D1_B10 = 234;
    public static final int U_CARSET_XRUI_D50_D1_B32 = 233;
    public static final int U_CARSET_XRUI_D50_D1_B74 = 232;
    public static final int U_CARSET_XRUI_D50_D2_B0 = 240;
    public static final int U_CARSET_XRUI_D50_D2_B1 = 239;
    public static final int U_CARSET_XRUI_D50_D2_B2 = 238;
    public static final int U_CARSET_XRUI_D50_D2_B3 = 237;
    public static final int U_CARSET_XRUI_D50_D2_B5 = 236;
    public static final int U_CARSET_XRUI_D50_D2_B6 = 235;
    public static final int U_CARSET_XRUI_D50_D3_B0 = 243;
    public static final int U_CARSET_XRUI_D50_D3_B1 = 242;
    public static final int U_CARSET_XRUI_D50_D3_B43 = 241;
    public static final int U_CARSET_XRUI_D50_D4_B0 = 248;
    public static final int U_CARSET_XRUI_D50_D4_B1 = 247;
    public static final int U_CARSET_XRUI_D50_D4_B32 = 246;
    public static final int U_CARSET_XRUI_D50_D4_B5 = 245;
    public static final int U_CARSET_XRUI_D50_D4_B6 = 244;
    public static final int U_CARSET_XRUI_D50_D8_B10 = 253;
    public static final int U_CARSET_XRUI_D50_D8_B2 = 252;
    public static final int U_CARSET_XRUI_D50_D8_B3 = 251;
    public static final int U_CARSET_XRUI_D50_D8_B65 = 250;
    public static final int U_CARSET_XRUI_D50_D8_B7 = 249;
    public static final int U_CARSET_XRUI_D50_D9_B1 = 257;
    public static final int U_CARSET_XRUI_D50_D9_B2 = 256;
    public static final int U_CARSET_XRUI_D50_D9_B3 = 255;
    public static final int U_CARSET_XRUI_D50_D9_B54 = 254;
    public static final int U_CARSET_XYUAN_D50_D0_B10 = 264;
    public static final int U_CARSET_XYUAN_D50_D0_B2 = 263;
    public static final int U_CARSET_XYUAN_D50_D0_B3 = 262;
    public static final int U_CARSET_XYUAN_D50_D0_B54 = 261;
    public static final int U_CARSET_XYUAN_D50_D0_B6 = 260;
    public static final int U_CARSET_XYUAN_D50_D1_B10 = 268;
    public static final int U_CARSET_XYUAN_D50_D1_B2 = 267;
    public static final int U_CARSET_XYUAN_D50_D1_B3 = 266;
    public static final int U_CARSET_XYUAN_D50_D1_B74 = 265;
    public static final int U_CARSET_XYUAN_D50_D2_B3 = 271;
    public static final int U_CARSET_XYUAN_D50_D2_B64 = 270;
    public static final int U_CARSET_XYUAN_D50_D2_B7 = 269;
    public static final int U_CARSET_XYUAN_D50_D3_B0 = 273;
    public static final int U_CARSET_XYUAN_D50_D3_B2 = 272;
    public static final int U_CARSET_XYUAN_D50_D4_B0 = 279;
    public static final int U_CARSET_XYUAN_D50_D4_B1 = 278;
    public static final int U_CARSET_XYUAN_D50_D4_B2 = 277;
    public static final int U_CARSET_XYUAN_D50_D4_B3 = 276;
    public static final int U_CARSET_XYUAN_D50_D4_B4 = 275;
    public static final int U_CARSET_XYUAN_D50_D4_B5 = 274;
    public static final int U_CARSET_XYUAN_D50_D5_B20 = 280;
    public static final int U_CARSET_XYUAN_D50_D6_B30 = 283;
    public static final int U_CARSET_XYUAN_D50_D6_B4 = 282;
    public static final int U_CARSET_XYUAN_D50_D6_B75 = 281;
    public static final int U_CARSET_XYUAN_D50_D7_B70 = 284;
    public static final int U_CARSET_XYUAN_D50_D8_B10 = 285;
    public static final int U_CNT_MAX = 320;
    public static final int U_TIRE_STATE_FL = 108;
    public static final int U_TIRE_STATE_FR = 109;
    public static final int U_TIRE_STATE_RL = 110;
    public static final int U_TIRE_STATE_RR = 111;
    public static final int U_TIRE_TEMP_FL = 116;
    public static final int U_TIRE_TEMP_FR = 117;
    public static final int U_TIRE_TEMP_RL = 118;
    public static final int U_TIRE_TEMP_RR = 119;
    public static final int U_TIRE_VALUE_FL = 112;
    public static final int U_TIRE_VALUE_FR = 113;
    public static final int U_TIRE_VALUE_RL = 114;
    public static final int U_TIRE_VALUE_RR = 115;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 320; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_OD_Fengye_80V(TheApp.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 320) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
