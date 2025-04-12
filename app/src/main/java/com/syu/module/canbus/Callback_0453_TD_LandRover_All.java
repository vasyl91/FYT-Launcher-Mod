package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0453_TD_LandRover_All extends CallbackCanbusBase {
    public static final int U_CARSET_D01_D3_B6 = 313;
    public static final int U_CARSET_D01_D3_B7 = 312;
    public static final int U_CARSET_D07_D0_B01 = 299;
    public static final int U_CARSET_D07_D0_B23 = 300;
    public static final int U_CARSET_D07_D0_B45 = 301;
    public static final int U_CARSET_D07_D0_B67 = 302;
    public static final int U_CARSET_D07_D1_B01 = 303;
    public static final int U_CARSET_D07_D1_B23 = 304;
    public static final int U_CARSET_D07_D1_B45 = 305;
    public static final int U_CARSET_D07_D1_B67 = 306;
    public static final int U_CARSET_D07_D2_B01 = 115;
    public static final int U_CARSET_D07_D2_B23 = 116;
    public static final int U_CARSET_D07_D2_B45 = 117;
    public static final int U_CARSET_D07_D2_B67 = 118;
    public static final int U_CARSET_D07_D3_B02 = 119;
    public static final int U_CARSET_D07_D3_B3 = 120;
    public static final int U_CARSET_D07_D3_B46 = 121;
    public static final int U_CARSET_D07_D3_B7 = 122;
    public static final int U_CARSET_D07_D4_B02 = 123;
    public static final int U_CARSET_D07_D4_B46 = 124;
    public static final int U_CARSET_D07_D5_B02 = 125;
    public static final int U_CARSET_D07_D5_B3 = 126;
    public static final int U_CARSET_D07_D5_B46 = 127;
    public static final int U_CARSET_D07_D5_B7 = 128;
    public static final int U_CARSET_D07_D6_B02 = 129;
    public static final int U_CARSET_D07_D6_B46 = 130;
    public static final int U_CARSET_D07_D7_B06 = 131;
    public static final int U_CARSET_D07_D7_B7 = 132;
    public static final int U_CARSET_D08_D3_B7 = 308;
    public static final int U_CARSET_D08_D6_B60 = 309;
    public static final int U_CARSET_D0A_D1_D2 = 307;
    public static final int U_CARSET_D0B_D0_B0 = 98;
    public static final int U_CARSET_D0B_D0_B1 = 99;
    public static final int U_CARSET_D0B_D0_B23 = 100;
    public static final int U_CARSET_D0B_D0_B45 = 101;
    public static final int U_CARSET_D0B_D0_B67 = 102;
    public static final int U_CARSET_D0B_D1_B01 = 103;
    public static final int U_CARSET_D0B_D1_B23 = 104;
    public static final int U_CARSET_D0B_D1_B7 = 105;
    public static final int U_CARSET_D0B_D2_B0 = 106;
    public static final int U_CARSET_D0B_D2_B1 = 107;
    public static final int U_CARSET_D0B_D2_B2 = 108;
    public static final int U_CARSET_D0B_D2_B3 = 109;
    public static final int U_CARSET_D0B_D2_B4 = 110;
    public static final int U_CARSET_D0B_D2_B5 = 111;
    public static final int U_CARSET_D0B_D2_B6 = 112;
    public static final int U_CARSET_D0B_D2_B7 = 113;
    public static final int U_CARSET_D0B_D3_B0 = 114;
    public static final int U_CARSET_D35_D2_D3 = 133;
    public static final int U_CARSET_D35_D7_D10 = 134;
    public static final int U_CARSET_D36_D0_B30 = 311;
    public static final int U_CARSET_D36_D0_B74 = 310;
    public static final int U_CARSET_D37_D0_D1 = 135;
    public static final int U_CARSET_D37_D2_D3 = 136;
    public static final int U_CARSET_D37_D4_D5 = 137;
    public static final int U_CARSET_D38_D0_B70 = 138;
    public static final int U_CARSET_D38_D10_B30 = 161;
    public static final int U_CARSET_D38_D10_B74 = 160;
    public static final int U_CARSET_D38_D11_B30 = 166;
    public static final int U_CARSET_D38_D11_B4 = 165;
    public static final int U_CARSET_D38_D11_B5 = 164;
    public static final int U_CARSET_D38_D11_B6 = 163;
    public static final int U_CARSET_D38_D11_B7 = 162;
    public static final int U_CARSET_D38_D12_B3 = 169;
    public static final int U_CARSET_D38_D12_B54 = 168;
    public static final int U_CARSET_D38_D12_B76 = 167;
    public static final int U_CARSET_D38_D1_B10 = 144;
    public static final int U_CARSET_D38_D1_B2 = 143;
    public static final int U_CARSET_D38_D1_B3 = 142;
    public static final int U_CARSET_D38_D1_B54 = 141;
    public static final int U_CARSET_D38_D1_B6 = 140;
    public static final int U_CARSET_D38_D1_B7 = 139;
    public static final int U_CARSET_D38_D2_B1 = 151;
    public static final int U_CARSET_D38_D2_B2 = 150;
    public static final int U_CARSET_D38_D2_B3 = 149;
    public static final int U_CARSET_D38_D2_B4 = 148;
    public static final int U_CARSET_D38_D2_B5 = 147;
    public static final int U_CARSET_D38_D2_B6 = 146;
    public static final int U_CARSET_D38_D2_B7 = 145;
    public static final int U_CARSET_D38_D3_B70 = 152;
    public static final int U_CARSET_D38_D4_B30 = 154;
    public static final int U_CARSET_D38_D4_B74 = 153;
    public static final int U_CARSET_D38_D5_B70 = 155;
    public static final int U_CARSET_D38_D6_B70 = 156;
    public static final int U_CARSET_D38_D7_B70 = 157;
    public static final int U_CARSET_D38_D8_B70 = 158;
    public static final int U_CARSET_D38_D9_B70 = 159;
    public static final int U_CARSET_D65_D0_B2 = 175;
    public static final int U_CARSET_D65_D0_B3 = 174;
    public static final int U_CARSET_D65_D0_B4 = 173;
    public static final int U_CARSET_D65_D0_B5 = 172;
    public static final int U_CARSET_D65_D0_B6 = 171;
    public static final int U_CARSET_D65_D0_B7 = 170;
    public static final int U_CARSET_D65_D1_B4 = 179;
    public static final int U_CARSET_D65_D1_B5 = 178;
    public static final int U_CARSET_D65_D1_B6 = 177;
    public static final int U_CARSET_D65_D1_B7 = 176;
    public static final int U_CARSET_D65_D2_B70 = 180;
    public static final int U_CARSET_D66_D0_B50 = 181;
    public static final int U_CARSET_D66_D1_B50 = 182;
    public static final int U_CARSET_D66_D2_B50 = 183;
    public static final int U_CARSET_D66_D3_B60 = 185;
    public static final int U_CARSET_D66_D3_B7 = 184;
    public static final int U_CARSET_D66_D4_B50 = 186;
    public static final int U_CARSET_D66_D5_B50 = 187;
    public static final int U_CARSET_D66_D6_B50 = 188;
    public static final int U_CARSET_D67_D0_B32 = 192;
    public static final int U_CARSET_D67_D0_B4 = 191;
    public static final int U_CARSET_D67_D0_B5 = 190;
    public static final int U_CARSET_D67_D0_B6 = 189;
    public static final int U_CARSET_D67_D0_D1_D2 = 193;
    public static final int U_CARSET_D67_D10_B50 = 198;
    public static final int U_CARSET_D67_D11_B50 = 199;
    public static final int U_CARSET_D67_D12_B50 = 200;
    public static final int U_CARSET_D67_D13_B60 = 201;
    public static final int U_CARSET_D67_D14_D15 = 202;
    public static final int U_CARSET_D67_D3_B71 = 194;
    public static final int U_CARSET_D67_D4_1B70 = 195;
    public static final int U_CARSET_D67_D5_D6 = 196;
    public static final int U_CARSET_D67_D7_D8_D9 = 197;
    public static final int U_CARSET_D68_D0_B32 = 205;
    public static final int U_CARSET_D68_D0_B4 = 204;
    public static final int U_CARSET_D68_D0_B5 = 203;
    public static final int U_CARSET_D68_D0_D1_D2 = 206;
    public static final int U_CARSET_D68_D10_B50 = 211;
    public static final int U_CARSET_D68_D11_B50 = 212;
    public static final int U_CARSET_D68_D12_B50 = 213;
    public static final int U_CARSET_D68_D13_B60 = 214;
    public static final int U_CARSET_D68_D14_B30 = 215;
    public static final int U_CARSET_D68_D15_B50 = 216;
    public static final int U_CARSET_D68_D16_B50 = 217;
    public static final int U_CARSET_D68_D17_B50 = 218;
    public static final int U_CARSET_D68_D3_B71 = 207;
    public static final int U_CARSET_D68_D4_1B70 = 208;
    public static final int U_CARSET_D68_D5_D6 = 209;
    public static final int U_CARSET_D68_D7_D8_D9 = 210;
    public static final int U_CARSET_D69_D0_B32 = 221;
    public static final int U_CARSET_D69_D0_B4 = 220;
    public static final int U_CARSET_D69_D0_B5 = 219;
    public static final int U_CARSET_D69_D0_D1_D2 = 222;
    public static final int U_CARSET_D69_D10_B50 = 227;
    public static final int U_CARSET_D69_D11_B50 = 228;
    public static final int U_CARSET_D69_D12_B50 = 229;
    public static final int U_CARSET_D69_D13_B60 = 230;
    public static final int U_CARSET_D69_D14_B30 = 231;
    public static final int U_CARSET_D69_D15_B50 = 232;
    public static final int U_CARSET_D69_D16_B50 = 233;
    public static final int U_CARSET_D69_D17_B50 = 234;
    public static final int U_CARSET_D69_D3_B71 = 223;
    public static final int U_CARSET_D69_D4_1B70 = 224;
    public static final int U_CARSET_D69_D5_D6 = 225;
    public static final int U_CARSET_D69_D7_D8_D9 = 226;
    public static final int U_CARSET_D6A_D0_B32 = 237;
    public static final int U_CARSET_D6A_D0_B4 = 236;
    public static final int U_CARSET_D6A_D0_B5 = 235;
    public static final int U_CARSET_D6A_D0_D1_D2 = 238;
    public static final int U_CARSET_D6A_D10_B50 = 243;
    public static final int U_CARSET_D6A_D11_B50 = 244;
    public static final int U_CARSET_D6A_D12_B50 = 245;
    public static final int U_CARSET_D6A_D13_B60 = 246;
    public static final int U_CARSET_D6A_D14_B30 = 247;
    public static final int U_CARSET_D6A_D15_B50 = 248;
    public static final int U_CARSET_D6A_D16_B50 = 249;
    public static final int U_CARSET_D6A_D17_B50 = 250;
    public static final int U_CARSET_D6A_D3_B71 = 239;
    public static final int U_CARSET_D6A_D4_1B70 = 240;
    public static final int U_CARSET_D6A_D5_D6 = 241;
    public static final int U_CARSET_D6A_D7_D8_D9 = 242;
    public static final int U_CARSET_D6B_D0_B32 = 253;
    public static final int U_CARSET_D6B_D0_B4 = 252;
    public static final int U_CARSET_D6B_D0_B5 = 251;
    public static final int U_CARSET_D6B_D0_D1_D2 = 254;
    public static final int U_CARSET_D6B_D10_B50 = 259;
    public static final int U_CARSET_D6B_D11_B50 = 260;
    public static final int U_CARSET_D6B_D12_B50 = 261;
    public static final int U_CARSET_D6B_D13_B60 = 262;
    public static final int U_CARSET_D6B_D14_B30 = 263;
    public static final int U_CARSET_D6B_D15_B50 = 264;
    public static final int U_CARSET_D6B_D16_B50 = 265;
    public static final int U_CARSET_D6B_D17_B50 = 266;
    public static final int U_CARSET_D6B_D3_B71 = 255;
    public static final int U_CARSET_D6B_D4_1B70 = 256;
    public static final int U_CARSET_D6B_D5_D6 = 257;
    public static final int U_CARSET_D6B_D7_D8_D9 = 258;
    public static final int U_CARSET_D6C_D0_B32 = 269;
    public static final int U_CARSET_D6C_D0_B4 = 268;
    public static final int U_CARSET_D6C_D0_B5 = 267;
    public static final int U_CARSET_D6C_D0_D1_D2 = 270;
    public static final int U_CARSET_D6C_D10_B50 = 275;
    public static final int U_CARSET_D6C_D11_B50 = 276;
    public static final int U_CARSET_D6C_D12_B50 = 277;
    public static final int U_CARSET_D6C_D13_B60 = 278;
    public static final int U_CARSET_D6C_D14_B30 = 279;
    public static final int U_CARSET_D6C_D15_B50 = 280;
    public static final int U_CARSET_D6C_D16_B50 = 281;
    public static final int U_CARSET_D6C_D17_B50 = 282;
    public static final int U_CARSET_D6C_D3_B71 = 271;
    public static final int U_CARSET_D6C_D4_1B70 = 272;
    public static final int U_CARSET_D6C_D5_D6 = 273;
    public static final int U_CARSET_D6C_D7_D8_D9 = 274;
    public static final int U_CARSET_D6D_D0_B32 = 285;
    public static final int U_CARSET_D6D_D0_B4 = 284;
    public static final int U_CARSET_D6D_D0_B5 = 283;
    public static final int U_CARSET_D6D_D0_D1_D2 = 286;
    public static final int U_CARSET_D6D_D10_B50 = 291;
    public static final int U_CARSET_D6D_D11_B50 = 292;
    public static final int U_CARSET_D6D_D12_B50 = 293;
    public static final int U_CARSET_D6D_D13_B60 = 294;
    public static final int U_CARSET_D6D_D14_B30 = 295;
    public static final int U_CARSET_D6D_D15_B50 = 296;
    public static final int U_CARSET_D6D_D16_B50 = 297;
    public static final int U_CARSET_D6D_D17_B50 = 298;
    public static final int U_CARSET_D6D_D3_B71 = 287;
    public static final int U_CARSET_D6D_D4_1B70 = 288;
    public static final int U_CARSET_D6D_D5_D6 = 289;
    public static final int U_CARSET_D6D_D7_D8_D9 = 290;
    public static final int U_CNT_MAX = 314;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 314; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        //AirHelper.getInstance().buildUi(new Air_0453_TD_LandRover_All(LauncherApplication.getInstance()));
        for (int i2 = 10; i2 < 97; i2++) {
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

    @Override
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

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 314) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
