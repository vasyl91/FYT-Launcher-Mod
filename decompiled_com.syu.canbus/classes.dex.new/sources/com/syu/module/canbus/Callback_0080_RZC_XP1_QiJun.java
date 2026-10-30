package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.xp.xiandai.XiandaiSosPage;
import com.syu.ipc.IModuleCallback;
import com.syu.module.main.DataMain;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0080_OD_Nissan_Teana;
import com.syu.ui.air.Air_0080_RZC_TianLai;
import com.syu.ui.door.DoorHelper;
import com.syu.ui.parking.ParkingHelper;
import com.syu.ui.parking.Parking_RZC_QiJun;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0080_RZC_XP1_QiJun extends CallbackCanbusBase {
    public static String CarNum = "";
    public static final int U_CARINF_D21_D6_B30 = 129;
    public static final int U_CARINF_D21_D6_B54 = 128;
    public static final int U_CARINF_D21_D6_B76 = 127;
    public static final int U_CARINF_D21_D7_B30 = 132;
    public static final int U_CARINF_D21_D7_B54 = 131;
    public static final int U_CARINF_D21_D7_B76 = 130;
    public static final int U_CARINF_D27_D0_B0 = 147;
    public static final int U_CARINF_D27_D0_B1 = 146;
    public static final int U_CARINF_D27_D1_D2_D3 = 148;
    public static final int U_CARINF_D27_D4_D5 = 149;
    public static final int U_CARINF_D38_D4_B70 = 123;
    public static final int U_CARINF_D38_D5_B70 = 124;
    public static final int U_CARINF_D38_D6_B70 = 125;
    public static final int U_CARINF_D38_D7_B70 = 126;
    public static final int U_CARINF_D40_D0_B4 = 135;
    public static final int U_CARINF_D40_D0_B5 = 134;
    public static final int U_CARINF_D40_D0_B7 = 133;
    public static final int U_CARINF_D40_D1_B60 = 137;
    public static final int U_CARINF_D40_D1_B7 = 136;
    public static final int U_CARINF_D40_D2_B60 = 139;
    public static final int U_CARINF_D40_D2_B7 = 138;
    public static final int U_CARINF_D40_D3_B60 = 141;
    public static final int U_CARINF_D40_D3_B7 = 140;
    public static final int U_CARINF_D40_D4_B4 = 145;
    public static final int U_CARINF_D40_D4_B5 = 144;
    public static final int U_CARINF_D40_D4_B6 = 143;
    public static final int U_CARINF_D40_D4_B7 = 142;
    public static final int U_CARINF_D41_D0_B5 = 116;
    public static final int U_CARINF_D41_D0_B6 = 115;
    public static final int U_CARINF_D41_D0_B7 = 114;
    public static final int U_CARINF_D41_D12_D13 = 122;
    public static final int U_CARINF_D41_D14_B70 = 152;
    public static final int U_CARINF_D41_D15_B70 = 153;
    public static final int U_CARINF_D41_D17_B70 = 154;
    public static final int U_CARINF_D41_D1_D2 = 117;
    public static final int U_CARINF_D41_D3_D4 = 118;
    public static final int U_CARINF_D41_D5_D6 = 119;
    public static final int U_CARINF_D41_D7_D8 = 120;
    public static final int U_CARINF_D41_D9_D11 = 121;
    public static final int U_CARINF_D45_D0_B70 = 199;
    public static final int U_CARINF_D45_D10_D11 = 204;
    public static final int U_CARINF_D45_D12_D13 = 205;
    public static final int U_CARINF_D45_D14_D16 = 206;
    public static final int U_CARINF_D45_D17_B10 = 207;
    public static final int U_CARINF_D45_D1_B70 = 200;
    public static final int U_CARINF_D45_D2_D4 = 201;
    public static final int U_CARINF_D45_D5_D6 = 202;
    public static final int U_CARINF_D45_D7_D9 = 203;
    public static final int U_CARSET_AIR_TYPE = 188;
    public static final int U_CARSET_D41_T80_D1_B70 = 193;
    public static final int U_CARSET_D41_T80_D2_B70 = 194;
    public static final int U_CARSET_D41_T80_D3_B70 = 195;
    public static final int U_CARSET_D41_T80_D4_B70 = 196;
    public static final int U_CARSET_D41_T80_D5_B70 = 197;
    public static final int U_CARSET_D41_T80_D6_B70 = 198;
    public static final int U_CARSET_D60_D30_B70 = 150;
    public static final int U_CARSET_D96_T32_D1_B70 = 210;
    public static final int U_CARSET_D96_T33_D1_B70 = 211;
    public static final int U_CARSET_D96_T34_D1_B70 = 212;
    public static final int U_CARSET_D96_T35_D1_B70 = 213;
    public static final int U_CARSET_D96_T36_D1_B70 = 214;
    public static final int U_CARSET_D96_T37_D1_B70 = 215;
    public static final int U_CARSTR_D44_CARNUM = 155;
    public static final int U_CAR_EQ_END = 144;
    public static final int U_CNT_MAX = 216;
    public static final int U_JUMP_SOS_PAGE = 112;
    public static final int U_PARK_BTN = 100;
    public static final int U_PARK_CAMERA = 101;
    public static final int U_PARK_PAGE = 99;
    public static final int U_PARK_TXTMSG = 98;
    public static final int U_SETTING_93D0 = 113;
    public static final int U_SETTING_93D1 = 108;
    public static final int U_SETTING_93D2 = 109;
    public static final int U_SETTING_93D3 = 110;
    public static final int U_SETTING_93D4 = 111;
    public static final int U_SETTING_93D5 = 103;
    public static final int U_SETTING_93D6 = 104;
    public static final int U_SETTING_93D7 = 105;
    public static final int U_SETTING_93D8 = 106;
    public static final int U_SETTING_BEGIN = 102;
    public static final int U_SETTING_LANGUAGE = 107;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 216; i++) {
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
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_CZH_OD_NISSAN_22Teana_Top /* 1572944 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_22Teana_Top_360View /* 1638480 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_16Trail /* 1704016 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_16Trail_H /* 1769552 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_16Xiaoke /* 1835088 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_16Xiaoke_H /* 1900624 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Xima_L /* 1966160 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Xima_H /* 2031696 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Loulan_L /* 2097232 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Loulan_H /* 2162768 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Tianlai_L /* 2228304 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Tianlai_H /* 2293840 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Xuanyi_L /* 2359376 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Xuanyi_H /* 2424912 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Lanniao_L /* 2490448 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Lannia_H /* 2555984 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Qida_L /* 2621520 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Qida_H /* 2687056 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Jinke_L /* 2752592 */:
            case FinalCanbus.CAR_CZH_OD_NISSAN_Jinke_H /* 2818128 */:
                AirHelper.getInstance().buildUi(new Air_0080_OD_Nissan_Teana(TheApp.getInstance()));
                break;
            default:
                AirHelper.getInstance().buildUi(new Air_0080_RZC_TianLai(TheApp.getInstance()));
                break;
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        if (458832 == DataCanbus.DATA[1000]) {
            ParkingHelper.getInstance().buildUi(new Parking_RZC_QiJun(TheApp.getInstance()));
            DataMain.NOTIFY_EVENTS[12].addNotify(ParkingHelper.getInstance(), 0);
            for (int i4 = 98; i4 <= 101; i4++) {
                DataCanbus.NOTIFY_EVENTS[i4].addNotify(ParkingHelper.getInstance(), 0);
            }
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        if (458832 == DataCanbus.DATA[1000]) {
            for (int i = 98; i <= 101; i++) {
                DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
            }
            DataMain.NOTIFY_EVENTS[12].removeNotify(ParkingHelper.getInstance());
            ParkingHelper.getInstance().destroyUi();
        }
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    private void showSosPage(int updateCode, int[] ints) {
        if (updateCode == 112) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value != 0 && !XiandaiSosPage.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.xiandai.XiandaiSosPage");
            } else if (value == 0 && XiandaiSosPage.mIsFront && XiandaiSosPage.mInstance != null) {
                XiandaiSosPage.mInstance.finish();
            }
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 216) {
            switch (updateCode) {
                case 112:
                    showSosPage(updateCode, ints);
                    break;
                case 155:
                    if (strs != null && strs.length > 0) {
                        CarNum = strs[0];
                        DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                        break;
                    }
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 216) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
                    break;
            }
        }
    }
}
