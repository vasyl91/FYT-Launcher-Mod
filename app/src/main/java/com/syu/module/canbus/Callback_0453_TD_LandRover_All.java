package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0453_TD_LandRover_All;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0453_TD_LandRover_All extends CallbackCanbusBase {
    public static final int U_CARSET_D07_D0_B01 = 287;
    public static final int U_CARSET_D07_D0_B23 = 288;
    public static final int U_CARSET_D07_D0_B45 = 289;
    public static final int U_CARSET_D07_D0_B67 = 290;
    public static final int U_CARSET_D07_D1_B01 = 291;
    public static final int U_CARSET_D07_D1_B23 = 292;
    public static final int U_CARSET_D07_D1_B45 = 293;
    public static final int U_CARSET_D07_D1_B67 = 294;
    public static final int U_CARSET_D07_D2_B01 = 103;
    public static final int U_CARSET_D07_D2_B23 = 104;
    public static final int U_CARSET_D07_D2_B45 = 105;
    public static final int U_CARSET_D07_D2_B67 = 106;
    public static final int U_CARSET_D07_D3_B02 = 107;
    public static final int U_CARSET_D07_D3_B3 = 108;
    public static final int U_CARSET_D07_D3_B46 = 109;
    public static final int U_CARSET_D07_D3_B7 = 110;
    public static final int U_CARSET_D07_D4_B02 = 111;
    public static final int U_CARSET_D07_D4_B46 = 112;
    public static final int U_CARSET_D07_D5_B02 = 113;
    public static final int U_CARSET_D07_D5_B3 = 114;
    public static final int U_CARSET_D07_D5_B46 = 115;
    public static final int U_CARSET_D07_D5_B7 = 116;
    public static final int U_CARSET_D07_D6_B02 = 117;
    public static final int U_CARSET_D07_D6_B46 = 118;
    public static final int U_CARSET_D07_D7_B06 = 119;
    public static final int U_CARSET_D07_D7_B7 = 120;
    public static final int U_CARSET_D08_D3_B7 = 296;
    public static final int U_CARSET_D08_D6_B60 = 297;
    public static final int U_CARSET_D0A_D1_D2 = 295;
    public static final int U_CARSET_D0B_D0_B0 = 86;
    public static final int U_CARSET_D0B_D0_B1 = 87;
    public static final int U_CARSET_D0B_D0_B23 = 88;
    public static final int U_CARSET_D0B_D0_B45 = 89;
    public static final int U_CARSET_D0B_D0_B67 = 90;
    public static final int U_CARSET_D0B_D1_B01 = 91;
    public static final int U_CARSET_D0B_D1_B23 = 92;
    public static final int U_CARSET_D0B_D1_B7 = 93;
    public static final int U_CARSET_D0B_D2_B0 = 94;
    public static final int U_CARSET_D0B_D2_B1 = 95;
    public static final int U_CARSET_D0B_D2_B2 = 96;
    public static final int U_CARSET_D0B_D2_B3 = 97;
    public static final int U_CARSET_D0B_D2_B4 = 98;
    public static final int U_CARSET_D0B_D2_B5 = 99;
    public static final int U_CARSET_D0B_D2_B6 = 100;
    public static final int U_CARSET_D0B_D2_B7 = 101;
    public static final int U_CARSET_D0B_D3_B0 = 102;
    public static final int U_CARSET_D35_D2_D3 = 121;
    public static final int U_CARSET_D35_D7_D10 = 122;
    public static final int U_CARSET_D37_D0_D1 = 123;
    public static final int U_CARSET_D37_D2_D3 = 124;
    public static final int U_CARSET_D37_D4_D5 = 125;
    public static final int U_CARSET_D38_D0_B70 = 126;
    public static final int U_CARSET_D38_D10_B30 = 149;
    public static final int U_CARSET_D38_D10_B74 = 148;
    public static final int U_CARSET_D38_D11_B30 = 154;
    public static final int U_CARSET_D38_D11_B4 = 153;
    public static final int U_CARSET_D38_D11_B5 = 152;
    public static final int U_CARSET_D38_D11_B6 = 151;
    public static final int U_CARSET_D38_D11_B7 = 150;
    public static final int U_CARSET_D38_D12_B3 = 157;
    public static final int U_CARSET_D38_D12_B54 = 156;
    public static final int U_CARSET_D38_D12_B76 = 155;
    public static final int U_CARSET_D38_D1_B10 = 132;
    public static final int U_CARSET_D38_D1_B2 = 131;
    public static final int U_CARSET_D38_D1_B3 = 130;
    public static final int U_CARSET_D38_D1_B54 = 129;
    public static final int U_CARSET_D38_D1_B6 = 128;
    public static final int U_CARSET_D38_D1_B7 = 127;
    public static final int U_CARSET_D38_D2_B1 = 139;
    public static final int U_CARSET_D38_D2_B2 = 138;
    public static final int U_CARSET_D38_D2_B3 = 137;
    public static final int U_CARSET_D38_D2_B4 = 136;
    public static final int U_CARSET_D38_D2_B5 = 135;
    public static final int U_CARSET_D38_D2_B6 = 134;
    public static final int U_CARSET_D38_D2_B7 = 133;
    public static final int U_CARSET_D38_D3_B70 = 140;
    public static final int U_CARSET_D38_D4_B30 = 142;
    public static final int U_CARSET_D38_D4_B74 = 141;
    public static final int U_CARSET_D38_D5_B70 = 143;
    public static final int U_CARSET_D38_D6_B70 = 144;
    public static final int U_CARSET_D38_D7_B70 = 145;
    public static final int U_CARSET_D38_D8_B70 = 146;
    public static final int U_CARSET_D38_D9_B70 = 147;
    public static final int U_CARSET_D65_D0_B2 = 163;
    public static final int U_CARSET_D65_D0_B3 = 162;
    public static final int U_CARSET_D65_D0_B4 = 161;
    public static final int U_CARSET_D65_D0_B5 = 160;
    public static final int U_CARSET_D65_D0_B6 = 159;
    public static final int U_CARSET_D65_D0_B7 = 158;
    public static final int U_CARSET_D65_D1_B4 = 167;
    public static final int U_CARSET_D65_D1_B5 = 166;
    public static final int U_CARSET_D65_D1_B6 = 165;
    public static final int U_CARSET_D65_D1_B7 = 164;
    public static final int U_CARSET_D65_D2_B70 = 168;
    public static final int U_CARSET_D66_D0_B50 = 169;
    public static final int U_CARSET_D66_D1_B50 = 170;
    public static final int U_CARSET_D66_D2_B50 = 171;
    public static final int U_CARSET_D66_D3_B60 = 173;
    public static final int U_CARSET_D66_D3_B7 = 172;
    public static final int U_CARSET_D66_D4_B50 = 174;
    public static final int U_CARSET_D66_D5_B50 = 175;
    public static final int U_CARSET_D66_D6_B50 = 176;
    public static final int U_CARSET_D67_D0_B32 = 180;
    public static final int U_CARSET_D67_D0_B4 = 179;
    public static final int U_CARSET_D67_D0_B5 = 178;
    public static final int U_CARSET_D67_D0_B6 = 177;
    public static final int U_CARSET_D67_D0_D1_D2 = 181;
    public static final int U_CARSET_D67_D10_B50 = 186;
    public static final int U_CARSET_D67_D11_B50 = 187;
    public static final int U_CARSET_D67_D12_B50 = 188;
    public static final int U_CARSET_D67_D13_B60 = 189;
    public static final int U_CARSET_D67_D14_D15 = 190;
    public static final int U_CARSET_D67_D3_B71 = 182;
    public static final int U_CARSET_D67_D4_1B70 = 183;
    public static final int U_CARSET_D67_D5_D6 = 184;
    public static final int U_CARSET_D67_D7_D8_D9 = 185;
    public static final int U_CARSET_D68_D0_B32 = 193;
    public static final int U_CARSET_D68_D0_B4 = 192;
    public static final int U_CARSET_D68_D0_B5 = 191;
    public static final int U_CARSET_D68_D0_D1_D2 = 194;
    public static final int U_CARSET_D68_D10_B50 = 199;
    public static final int U_CARSET_D68_D11_B50 = 200;
    public static final int U_CARSET_D68_D12_B50 = 201;
    public static final int U_CARSET_D68_D13_B60 = 202;
    public static final int U_CARSET_D68_D14_B30 = 203;
    public static final int U_CARSET_D68_D15_B50 = 204;
    public static final int U_CARSET_D68_D16_B50 = 205;
    public static final int U_CARSET_D68_D17_B50 = 206;
    public static final int U_CARSET_D68_D3_B71 = 195;
    public static final int U_CARSET_D68_D4_1B70 = 196;
    public static final int U_CARSET_D68_D5_D6 = 197;
    public static final int U_CARSET_D68_D7_D8_D9 = 198;
    public static final int U_CARSET_D69_D0_B32 = 209;
    public static final int U_CARSET_D69_D0_B4 = 208;
    public static final int U_CARSET_D69_D0_B5 = 207;
    public static final int U_CARSET_D69_D0_D1_D2 = 210;
    public static final int U_CARSET_D69_D10_B50 = 215;
    public static final int U_CARSET_D69_D11_B50 = 216;
    public static final int U_CARSET_D69_D12_B50 = 217;
    public static final int U_CARSET_D69_D13_B60 = 218;
    public static final int U_CARSET_D69_D14_B30 = 219;
    public static final int U_CARSET_D69_D15_B50 = 220;
    public static final int U_CARSET_D69_D16_B50 = 221;
    public static final int U_CARSET_D69_D17_B50 = 222;
    public static final int U_CARSET_D69_D3_B71 = 211;
    public static final int U_CARSET_D69_D4_1B70 = 212;
    public static final int U_CARSET_D69_D5_D6 = 213;
    public static final int U_CARSET_D69_D7_D8_D9 = 214;
    public static final int U_CARSET_D6A_D0_B32 = 225;
    public static final int U_CARSET_D6A_D0_B4 = 224;
    public static final int U_CARSET_D6A_D0_B5 = 223;
    public static final int U_CARSET_D6A_D0_D1_D2 = 226;
    public static final int U_CARSET_D6A_D10_B50 = 231;
    public static final int U_CARSET_D6A_D11_B50 = 232;
    public static final int U_CARSET_D6A_D12_B50 = 233;
    public static final int U_CARSET_D6A_D13_B60 = 234;
    public static final int U_CARSET_D6A_D14_B30 = 235;
    public static final int U_CARSET_D6A_D15_B50 = 236;
    public static final int U_CARSET_D6A_D16_B50 = 237;
    public static final int U_CARSET_D6A_D17_B50 = 238;
    public static final int U_CARSET_D6A_D3_B71 = 227;
    public static final int U_CARSET_D6A_D4_1B70 = 228;
    public static final int U_CARSET_D6A_D5_D6 = 229;
    public static final int U_CARSET_D6A_D7_D8_D9 = 230;
    public static final int U_CARSET_D6B_D0_B32 = 241;
    public static final int U_CARSET_D6B_D0_B4 = 240;
    public static final int U_CARSET_D6B_D0_B5 = 239;
    public static final int U_CARSET_D6B_D0_D1_D2 = 242;
    public static final int U_CARSET_D6B_D10_B50 = 247;
    public static final int U_CARSET_D6B_D11_B50 = 248;
    public static final int U_CARSET_D6B_D12_B50 = 249;
    public static final int U_CARSET_D6B_D13_B60 = 250;
    public static final int U_CARSET_D6B_D14_B30 = 251;
    public static final int U_CARSET_D6B_D15_B50 = 252;
    public static final int U_CARSET_D6B_D16_B50 = 253;
    public static final int U_CARSET_D6B_D17_B50 = 254;
    public static final int U_CARSET_D6B_D3_B71 = 243;
    public static final int U_CARSET_D6B_D4_1B70 = 244;
    public static final int U_CARSET_D6B_D5_D6 = 245;
    public static final int U_CARSET_D6B_D7_D8_D9 = 246;
    public static final int U_CARSET_D6C_D0_B32 = 257;
    public static final int U_CARSET_D6C_D0_B4 = 256;
    public static final int U_CARSET_D6C_D0_B5 = 255;
    public static final int U_CARSET_D6C_D0_D1_D2 = 258;
    public static final int U_CARSET_D6C_D10_B50 = 263;
    public static final int U_CARSET_D6C_D11_B50 = 264;
    public static final int U_CARSET_D6C_D12_B50 = 265;
    public static final int U_CARSET_D6C_D13_B60 = 266;
    public static final int U_CARSET_D6C_D14_B30 = 267;
    public static final int U_CARSET_D6C_D15_B50 = 268;
    public static final int U_CARSET_D6C_D16_B50 = 269;
    public static final int U_CARSET_D6C_D17_B50 = 270;
    public static final int U_CARSET_D6C_D3_B71 = 259;
    public static final int U_CARSET_D6C_D4_1B70 = 260;
    public static final int U_CARSET_D6C_D5_D6 = 261;
    public static final int U_CARSET_D6C_D7_D8_D9 = 262;
    public static final int U_CARSET_D6D_D0_B32 = 273;
    public static final int U_CARSET_D6D_D0_B4 = 272;
    public static final int U_CARSET_D6D_D0_B5 = 271;
    public static final int U_CARSET_D6D_D0_D1_D2 = 274;
    public static final int U_CARSET_D6D_D10_B50 = 279;
    public static final int U_CARSET_D6D_D11_B50 = 280;
    public static final int U_CARSET_D6D_D12_B50 = 281;
    public static final int U_CARSET_D6D_D13_B60 = 282;
    public static final int U_CARSET_D6D_D14_B30 = 283;
    public static final int U_CARSET_D6D_D15_B50 = 284;
    public static final int U_CARSET_D6D_D16_B50 = 285;
    public static final int U_CARSET_D6D_D17_B50 = 286;
    public static final int U_CARSET_D6D_D3_B71 = 275;
    public static final int U_CARSET_D6D_D4_1B70 = 276;
    public static final int U_CARSET_D6D_D5_D6 = 277;
    public static final int U_CARSET_D6D_D7_D8_D9 = 278;
    public static final int U_CNT_MAX = 298;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 298; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0453_TD_LandRover_All(LauncherApplication.getInstance()));
        for (int i2 = 10; i2 < 85; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
        DoorHelper.getInstance().buildUi();
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 85; i++) {
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
        if (updateCode >= 0 && updateCode < 298) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
