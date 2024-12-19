package com.syu.module.canbus;

import com.syu.canbus.CarBtActi;
import com.syu.canbus.JumpPage;
import com.syu.module.IUiNotify;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class HandlerCanbus {
    private static final IUiNotify NTF_CANBUS_ID = new IUiNotify() { // from class: com.syu.module.canbus.HandlerCanbus.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            CallbackCanbusBase callbackCanbus = HandlerCanbus.getCallbackCanbusById(DataCanbus.DATA[updateCode]);
            ModuleCallbackCanbusProxy.getInstance().setCallbackCanbus(callbackCanbus);
        }
    };

    public static void update(int updateCode, int[] ints) {
        if (ints != null && ints.length != 0 && DataCanbus.DATA[updateCode] != ints[0]) {
            DataCanbus.DATA[updateCode] = ints[0];
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
        }
    }

    public static void update(int updateCode, int value) {
        if (DataCanbus.DATA[updateCode] != value) {
            DataCanbus.DATA[updateCode] = value;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
        }
    }

    public static void update(int updateCode, int[] ints, float[] flts, String[] strs) {
        if ((ints != null && ints.length != 0) || (strs != null && strs.length != 0)) {
            if (ints != null && DataCanbus.DATA[updateCode] != ints[0]) {
                DataCanbus.DATA[updateCode] = ints[0];
            }
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, flts, strs);
        }
    }

    public static void canbusId(int updateCode, int value) {
        if (DataCanbus.DATA[updateCode] != value) {
            DataCanbus.DATA[updateCode] = value;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
        }
    }

    public static void updateCarBt(int value) {
        if (value == 1) {
            if (!CarBtActi.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.canbus.CarBtActi");
            }
        } else if (value == 0 && CarBtActi.mIsFront && CarBtActi.mInstance != null) {
            CarBtActi.mInstance.finish();
        }
    }

    static {
        DataCanbus.NOTIFY_EVENTS[1000].addNotify(NTF_CANBUS_ID, 1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:1515:0x1159  */
    /* JADX WARN: Removed duplicated region for block: B:1517:0x1160  */
    /* JADX WARN: Removed duplicated region for block: B:1912:0x14d0  */
    /* JADX WARN: Removed duplicated region for block: B:1915:0x14d9 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static CallbackCanbusBase getCallbackCanbusById(int id) {
        DataCanbus.sCanbusId = id;
        int canbusId = id & 65535;
        int carId = (id >> 16) & 65535;
        DataCanbus.carId = carId;
        switch (canbusId) {
            case 1:
                return new Callback_0001_WC1_DaZhong();
            case 2:
                return new Callback_0002_XP1_DaZhong();
            case 4:
                return new Callback_0004_FYT1_DongNanV5();
            case 6:
                return new Callback_0006_RZC1_BydF3();
            case 8:
                return new Callback_0008_WC1_BenTengX80();
            case 9:
                return new Callback_0009_WC1_BenTengB50();
            case 10:
                return new Callback_0010_WC1_FeiyateFeixiang();
            case 12:
                return new Callback_0012_WC2_XueTieLongC4L();
            case 13:
            case FinalCanbus.CAR_WC2_AngkeWei /* 131085 */:
                return new Callback_0013_WC2_XinJunWei2013();
            case 14:
                return new Callback_0014_WC2_Focus();
            case 17:
                return new Callback_0017_WC2_GaoErFu7();
            case 18:
                return new Callback_0096_RZC1_FML();
            case 19:
                return new Callback_0019_XP1_JieDe();
            case 20:
            case FinalCanbus.CAR_XP1_Camry2013_H /* 131092 */:
                return new Callback_0020_XP1_Camry2013();
            case 21:
                return new Callback_0021_WC2_MengDiOuZS2013();
            case 22:
                return new Callback_0022_XP1_Focus2012();
            case 24:
                return new Callback_0024_XP1_SIYU2012();
            case 25:
                return new Callback_0025_XP1_GM_H();
            case 26:
                return new Callback_0026_XP1_GM_L();
            case 31:
                return new Callback_0031_XP1_XiandaiIX45();
            case 33:
                return new Callback_0033_WC2_XinRuiZhi2013();
            case 34:
                return new Callback_0034_WC1_Lifan720();
            case 35:
                return new Callback_0035_RZCexc_Lifan720();
            case 36:
                return new Callback_0036_WC2_GM();
            case 37:
            case FinalCanbus.CAR_WC2_Accord9_H /* 131109 */:
                return new Callback_0037_WC2_Accord9();
            case 38:
                return new Callback_0038_WC1_TianLai2013();
            case 39:
                return new Callback_0039_RZCexc_FeiyateFeixiang();
            case 40:
                return new Callback_0040_XP1_GaoErFu7();
            case 41:
                return new Callback_0041_XP1_ACCORD9_Lo();
            case 42:
                return new Callback_0042_WC2_ACCORD9_Lo();
            case 43:
                return new Callback_0043_WC1_SOHONG_FEIXIANG();
            case 44:
                return new Callback_0044_XP1_GaoErFu7_Lo();
            case 45:
                return new Callback_0045_WC2_GaoErFu7_Lo();
            case 46:
                return new Callback_0046_WC2_RAV4_2013();
            case 47:
                return new Callback_0047_XP1_CRV2012();
            case 48:
                return new Callback_0048_XP1_Yihu2012();
            case 49:
                return new Callback_0049_WC2_YiHu();
            case 51:
                return new Callback_0051_RZC_DaZhong();
            case 55:
                return new Callback_0055_WC1_XianDaiIX45();
            case 56:
                return new Callback_0056_WC2_XueTieLong2008();
            case 58:
                return new Callback_0058_XBS_XP1_HaiMaM8();
            case 59:
                return new Callback_0059_WC2_ACCORD9_Lo_ZYC785();
            case 60:
                return new Callback_0060_XBS_XP1_MengDiOu();
            case 61:
                return new Callback_0061_RZC_XP1_GM();
            case 64:
                return new Callback_0064_WC2_LingPai();
            case 65:
                return new Callback_0065_WC2_JieDe();
            case 66:
                return new Callback_0066_WC1_MingTu();
            case 67:
                return new Callback_0067_WC3_SiYu();
            case 68:
                return new Callback_0068_RZC_XP1_ROEWE550();
            case 69:
                return new Callback_0069_RZC_XP1_CHANGANBENBEN_MINI();
            case 70:
                return new Callback_0070_RZC_XP1_CHANGANCS75();
            case 71:
                return new Callback_0071_RZC_XP1_HAIMAM8();
            case 76:
                return new Callback_0076_WC3_CRV();
            case 77:
                return new Callback_0077_XP1_ACCORD9_H();
            case 79:
                return new Callback_0079_RZC1_MZD3_5();
            case 80:
                return new Callback_0080_RZC_XP1_QiJun();
            case 81:
                return new Callback_0081_LSDT_XP1_HaimaS7();
            case 86:
                return new Callback_0086_WC2_BENGTENGB70_QUANCHAI();
            case 87:
                return new Callback_0087_WC1_CHANGFENG_LIEBAO();
            case 88:
                return new Callback_0088_RZC_XP1_BenTeng14B70();
            case 89:
                return new Callback_0089_RZC2_BenTengX80();
            case 90:
                return new Callback_0090_WC2_DS5();
            case 91:
                return new Callback_0091_AY1_AUDIQ3();
            case 92:
                return new Callback_0092_WC2_DS5LS();
            case 94:
                return new Callback_0094_WC1_ROEWE550();
            case 95:
                return new Callback_0095_RZC1_QiRuiA3();
            case 96:
                return new Callback_0096_RZC1_FML();
            case 97:
                return new Callback_0097_RZC1_HaiMaM3();
            case 98:
                return new Callback_0098_RZC1_HaiMaS7();
            case 99:
                return new Callback_0099_RZC1_GC7();
            case 100:
                return new Callback_0100_RZC1_GA3();
            case 101:
                return new Callback_0101_WC1_QiJun();
            case 102:
                return new Callback_0102_RZC3_XiandaiIX45();
            case 103:
                return new Callback_0103_RZC_XP1_ELYSION();
            case 104:
                return new Callback_0104_WC1_BenTengB70_Old();
            case 105:
                return new Callback_0105_FYTA_DongNanV6();
            case 106:
                return new Callback_0106_RZC4_BYDS6();
            case 107:
                return new Callback_0107_DJ_QiRuiAiRuiZe7();
            case 108:
                return new Callback_0108_WC2_GeShiTu();
            case 109:
                return new Callback_0109_WC2_Corolla();
            case 110:
                return new Callback_0110_WC2_Camry();
            case 112:
                return new Callback_0112_RZC_XP1_Carmy();
            case 113:
                return new Callback_0113_HECHI_XP1_CRV();
            case 115:
                return new Callback_0115_WC2_YIBO();
            case 116:
                return new Callback_0116_XP1_YIBO();
            case 117:
                return new Callback_0117_XP1_LINGPAI();
            case 118:
                return new Callback_0118_XP1_BiaoZhi2008();
            case 119:
                return new Callback_0119_RZC3_ZYC_IX35();
            case 121:
                return new Callback_0121_WC2_14Prado();
            case 122:
                return new Callback_0122_WC2_408_14();
            case 123:
                return new Callback_0123_RZC4_PSA301();
            case 124:
                return new Callback_0124_XP1_2014SIYU_CRV();
            case 125:
                return new Callback_0125_WC2_BENGTENGB70_KeepTheHost();
            case 126:
                return new Callback_0126_WC1_GA3();
            case 128:
                return new Callback_0128_WC2_CHANGANCS75();
            case 129:
                return new Callback_0129_WC2_XueTieLongC5();
            case 131:
                return new Callback_0131_XBS_XP1_HavalH6();
            case 132:
                if (carId == 0 || carId == 4 || carId == 5 || carId == 3) {
                    return new Callback_0132_WC2_HavalH2();
                }
                if (carId == 1 || carId == 2) {
                    return new Callback_0132H_WC2_HavalH2();
                }
                return new Callback_0000_null();
            case 134:
                return new Callback_0134_RZC_XP1_JieDe();
            case 137:
                return new Callback_0137_RZC3_XiandaiIX35();
            case 138:
                return new Callback_0138_DJ_GA3();
            case 139:
                return new Callback_0139_RZC_XP1_JiLiEC7();
            case 141:
                return new Callback_0141_RZC_XP1_LingPai();
            case 142:
                return new Callback_0142_RZC_XP1_BaoJun730();
            case 143:
                return new Callback_0143_XP1_QiJun();
            case 144:
                return new Callback_0144_WC1_ZhiNanZhe();
            case 145:
                return new Callback_0144_WC1_ZhiNanZhe();
            case 151:
                if (carId == 3 || carId == 4) {
                    return new Callback_0151_DAOJUN_XP1_BYDG6();
                }
                if (carId == 2) {
                    return new Callback_0151_ANSHENG_XP1_BYDYUAN();
                }
                if (carId == 5) {
                    return new Callback_0151_ZYC_XP1_BYDE6();
                }
                return new Callback_0151_DAOJUN_XP1_BYDS6();
            case 152:
                return new Callback_0152_RZC_XP1_ChuanQiGS5();
            case 153:
                return new Callback_0153_RZC3_MingTu();
            case 154:
                return new Callback_0154_ZMYT_XP1_Mendeo();
            case 155:
                return new Callback_0155_DJ_WC1_BaoJun730();
            case 157:
                return new Callback_0157_DAOJUN_XP1_HaiMaM8_HaiMaS7();
            case 158:
                return new Callback_0158_RZC_XP1_AoDi_Q3();
            case 159:
                return new Callback_0159_XinBaSi_XP1_DaZhong();
            case 160:
                return new Callback_0160_RZC_XP1_DaZhong_GaoErFu7();
            case 162:
                return new Callback_0162_WC2_XiandaIx35();
            case 163:
                return new Callback_0163_RZC4_PSA14_408();
            case 164:
                return new Callback_0164_WC1_FIESTA09();
            case 165:
                return new Callback_0165_XBS_XP1_ChuanQiGS5();
            case 166:
                return new Callback_0166_WC2_15_AoDeSai();
            case 167:
                return new Callback_0167_XBS_XP1_OLD_MZD6();
            case 168:
                return new Callback_0168_XP1_SoNaTa();
            case 169:
                return new Callback_0169_DAOJUN_XP1_ZhongTai5008();
            case 170:
                return new Callback_0170_XP1_AnKeSela();
            case 172:
                return new Callback_0172_XBS_XP1_ChangChengFengJun6();
            case 173:
                return new Callback_0173_WC2_14_SiYu();
            case 174:
                return new Callback_0174_XP1_MengDiOu();
            case 175:
                return new Callback_0175_XP1_MZD_CX5();
            case 176:
                return new Callback_0176_RZC_XP1_DongNanV5();
            case 177:
                return new Callback_0177_RZC_XP1_ChangChengFengJun6();
            case 184:
                return new Callback_0184_CYT_XP1_C4L();
            case 185:
                return new Callback_0185_XP1_BiaoZhi408();
            case 187:
                return new Callback_0187_RZC4_PSA308();
            case 188:
                return new Callback_0188_XBS_XP1_CRV2012();
            case 189:
                return new Callback_0189_XBS_MZD();
            case 190:
                return new Callback_0190_RZC_XP1_TianLai();
            case 192:
                return new Callback_0192_WC2_15_BinZhi();
            case 193:
                return new Callback_0193_DJ_ChuanQiGs5SuBo();
            case 194:
                return new Callback_0194_XBS_XP1_BenTengX80();
            case 195:
                return new Callback_0195_XBS_XP1_JiLiGc7();
            case 196:
                return new Callback_0196_XBS_XP1_ChangChengC30();
            case 197:
                return new Callback_0197_RZC_XP1_ChuanQiGS5SuBo();
            case 198:
                return new Callback_0198_CYT_FYTA_BYDS6();
            case 200:
                return new Callback_0200_DJ1_ChangChengC30();
            case 202:
                return new Callback_0202_CYT_XP1_MengDiOu();
            case 203:
                return new Callback_0203_RZC_XP1_AoDeSai();
            case 206:
                return new Callback_0206_WC1_Benz();
            case 207:
                return new Callback_0207_SBD_WC1_ChangChengC30();
            case 208:
                return new Callback_0208_DJ1_JiLiGX9();
            case 210:
                return new Callback_0210_MSL_XP1_JUNYUE();
            case 211:
                return new Callback_0211_RZC_XP1_ChangChengC30();
            case 212:
                return new Callback_0212_XP1_BenChiB200();
            case 214:
                return new Callback_0214_RZC_XP1_14Prado_H();
            case 215:
                return new Callback_0215_RZC4_PSA3008();
            case 216:
                return new Callback_0216_RZC_XP1_BeiQiShenBaoD60();
            case 217:
                return new Callback_0217_RZC4_PSA13_408();
            case 218:
                return new Callback_0218_XBS_XP1_13MengDiOu();
            case 219:
                return new Callback_0219_DJ_ChangAnYueXiangV7();
            case 220:
                return new Callback_0220_DJ_DongFengFengShenAX7();
            case 221:
                return new Callback_0221_RZC4_PSA2008();
            case 222:
                return new Callback_0222_WC2_EU_Focus();
            case 223:
                return new Callback_0223_WC1_MENGDIOU2011();
            case 224:
                return new Callback_0224_DC_WC1_15YIDONG();
            case 225:
                return new Callback_0225_XP1_SanLinPajero();
            case 226:
                return new Callback_0226_FYTA_ChangAnYueXiangV7();
            case 227:
                return new Callback_0227_RZC_XP1_ChangAnYueXiangV7();
            case 228:
                return new Callback_0228_SBD_WC1_ChangAnYueXiangV7();
            case 229:
                return new Callback_0229_CYT_FYTA_DongNanV5();
            case 230:
                return new Callback_0230_WC1_BMWX1();
            case 231:
                return new Callback_0231_DJ_MENGDIOU2013();
            case 233:
                return new Callback_0233_XBS_XP1_Jeep();
            case 234:
                return new Callback_0234_RZC4_DS5();
            case 235:
                return new Callback_0235_RZC4_DS5LS();
            case 236:
                return new Callback_0236_WC2_SAIL3();
            case 237:
                return new Callback_0237_RZC_XP1_HAIMAM5();
            case 238:
                return new Callback_0238_RZC4_C5();
            case 240:
                return new Callback_0240_RZC_XP1_Sail3();
            case 241:
                return new Callback_0241_WC1_RuiJie();
            case 242:
                return new Callback_0242_CYT_XP1_BiaoZhi408();
            case 244:
                return new Callback_0244_RZC_XP1_HavalH2();
            case 246:
                return new Callback_0246_WC2_BaoJun730();
            case 247:
                return new Callback_0247_WC2_XueTieLongC3XR();
            case 248:
                return new Callback_0248_RZC2_ZhongHuaV5();
            case 249:
                return new Callback_0249_RZC3_SoNaTa9();
            case 251:
                return new Callback_0251_XP1_Qiya_SoLanTuo();
            case 252:
                return new Callback_0252_WC2_PSAALL();
            case 253:
                return new Callback_0253_XP1_15YingLang();
            case 254:
                return new Callback_0254_WC2_15YingLang();
            case 255:
                if (carId == 2 || carId == 3 || carId == 6 || carId == 7 || carId == 8 || carId == 28 || carId == 29) {
                    return new Callback_0255_RZC_HanTeng();
                }
                return new Callback_0255_RZC_XP1_FengShenAX7();
            case 256:
                return new Callback_0256_SBD_WC1_ChuanQiGA6();
            case 257:
                if (carId == 2) {
                    return new Callback_0257_DJ_ChuanQiGA6_H();
                }
                return new Callback_0257_DJ_ChuanQiGA6();
            case 258:
                return new Callback_0258_KeYuan_FYTA_ChuanQiGA6();
            case 259:
                return new Callback_0259_RZC_XP1_ChuanQiGA6();
            case 260:
                return new Callback_0260_WC2_ChuanQiGA6();
            case 261:
                return new Callback_0261_KANGSHENG_XP1_FuRuiSi();
            case 262:
                return new Callback_0262_XBS_XP1_ACCORD9_Lo();
            case 263:
                return new Callback_0263_XP1_15YingLang();
            case 264:
                return new Callback_0264_DJ_RuiHu5();
            case 265:
                return new Callback_0265_RZC_ZhongTaiT600();
            case 266:
                return new Callback_0266_XP1_SoNaTa9();
            case 269:
                return new Callback_0269_WC1_BenzB200();
            case 270:
                return new Callback_0270_WC2_LingDu();
            case 271:
                return new Callback_0271_DJ_BENGTENG14B70();
            case 272:
                return new Callback_0272_RZC_XP1_JiangHuaiRuiFengS3();
            case 273:
                return new Callback_0273_RZC_XP1_MingJueRuiTeng();
            case 274:
                return new Callback_0274_DJ_XP1_ACCORD7();
            case 275:
                return new Callback_0275_XBS_XP1_BaoShiJie();
            case 276:
                return new Callback_0276_DJ_XP1_BIYADI_F6();
            case 277:
                return new Callback_0277_MH_XP1_BmwX1();
            case 278:
                return new Callback_0278_XP1_BiaoZhi301();
            case 279:
                return new Callback_0279_XP1_LingDu();
            case 280:
                return new Callback_0280_RZC_XP1_ChuanQiGS4();
            case 281:
                return new Callback_0281_XP_PSA_ALL();
            case 282:
                return new Callback_0282_WC2_MingJueRuiTeng();
            case 283:
                return new Callback_0283_AY1_BMW3S();
            case 284:
                return new Callback_0284_AY1_KaiDiLaKe();
            case 285:
                return new Callback_0285_AY1_BMW_MINI();
            case 287:
                return new Callback_0287_XP_JEEP();
            case 288:
                return new Callback_0288_KeYuan_FYTA_MingJueRuiTeng();
            case 289:
                return new Callback_0289_WC2_ChuanQiGS4();
            case 290:
                if (carId == 5 || carId == 6 || carId == 7 || carId == 9 || carId == 10 || carId == 11) {
                    return new Callback_0290_RZC_QICHENG_T90();
                }
                return new Callback_0290_RZC_QICHENG_T70();
            case 291:
                return new Callback_0291_RZC2_BenTengB50();
            case 292:
                return new Callback_0292_RZC_XP1_DongNanV6();
            case 293:
                return new Callback_0293_WC3_RUIJIE15();
            case 294:
                if (carId == 0) {
                    return new Callback_0294_WC2_RAV4Corolla();
                }
                if (carId == 30) {
                    return new Callback_0294_WC2_18PRADO();
                }
                return new Callback_0294_WC2_TOYOTA_ALL();
            case 295:
                return new Callback_0295_SBD_FYTA_DongFengFengGuang360();
            case 296:
                return new Callback_0296_SH_FYTA_BydSuRui();
            case 297:
                return new Callback_0297_WC2_15_CRV();
            case 298:
                return new Callback_0298_XP1_2015SIYU_CRV();
            case 299:
                return new Callback_0299_AY1_15YingLang();
            case 300:
                return new Callback_0300_XP1_RUIJIE15();
            case 301:
                return new Callback_0301_HECHI_XP1_PSA206();
            case 302:
                return new Callback_0302_DJ_WC2_DS5LS();
            case 303:
                return new Callback_0303_DJ_WC2_DS5();
            case 304:
                return new Callback_0304_WC2_ChuanQiGS5AndSuBo();
            case 305:
                return new Callback_0305_DJ_MENGDIOU2013_BAOLIUAirPanel();
            case 306:
                return new Callback_0306_RZCexc_Lifan820();
            case 307:
                return new Callback_0307_XBS_XP1_15ZhongHuaV3();
            case 308:
                return new Callback_0308_WC2_GM_WEILANG();
            case 309:
                return new Callback_0309_RZC_XP1_15WeiLang();
            case 310:
                return new Callback_0310_RZC_XP1_BaoJun560();
            case 311:
                return new Callback_0311_XP1_FordF150();
            case 312:
                return new Callback_0312_XBS_XP1_MZD3_MZD6RuiYi();
            case 313:
                return new Callback_0313_SBD_WC1_ELECTRIC();
            case 314:
                return new Callback_0314_RZC_XP1_FengGuang360();
            case 315:
                return new Callback_0315_XBS_XP1_Subaru_SenLinRen();
            case 316:
                return new Callback_0316_AY1_BenzC200();
            case 317:
                return new Callback_0317_WC2_ATS();
            case Callback_0374_XP1_ZiYouGuang.U_CARSET_D57_D1_B30 /* 318 */:
                return new Callback_0318_XP1_15WeiLang();
            case 319:
                return new Callback_0319_WC2_FOCUS15();
            case 320:
                return new Callback_0320_WC2_HavalH6();
            case 321:
                if (carId == 10 || carId == 22) {
                    return new Callback_0321_DJ_Honda_AllCom();
                }
                return new Callback_0321_WC2_Honda_AllCom();
            case 322:
                return new Callback_0322_WC1_NISSAN_LouLan();
            case 323:
                return new Callback_0323_HC_XP1_PorscheCayenne();
            case 324:
                return new Callback_0324_BNR_XP1_NISSAN_LouLan();
            case 325:
                return new Callback_0325_DJ_WC1_MZD_CX5();
            case 326:
                return new Callback_0326_XFY_DX7();
            case 327:
                return new Callback_0327_HC_OLD_TianLai();
            case 328:
                return new Callback_0328_RZC2_MZD_CX7();
            case 329:
                return new Callback_0329_RZC_XP1_DongNanDX7();
            case 330:
                return new Callback_0330_RZC_XP1_OldFiestar();
            case 332:
                return new Callback_0332_SB_SAIL3();
            case 333:
                return new Callback_0333_XP1_NISSAN_LouLan();
            case 334:
                return new Callback_0334_RZC_XP1_Focus2015();
            case 335:
                return new Callback_0335_KeYuan_FYTA_BaoJun560();
            case 336:
                return new Callback_0336_WC2_Escort();
            case 337:
                return new Callback_0337_WC2_RongWei360();
            case 338:
                return new Callback_0338_JYKJ_XP1_RongWei360();
            case 339:
                return new Callback_0339_RZC4_PSA_ALL();
            case 340:
                return new Callback_0340_XBS_XP1_2015CRV();
            case 341:
                return new Callback_0341_WC2_BaoJun560();
            case 342:
                return new Callback_0342_RZC_XP1_ROEWE360();
            case 343:
                return new Callback_0343_AY1_LEXUS_RX270();
            case 344:
                return new Callback_0344__XP1_BenChiVITO();
            case 345:
                return new Callback_0345_WC2_ShuPingJunWei();
            case 347:
                return new Callback_0347_YingLong_Ruijie();
            case 348:
                return new Callback_0348_DAOJUN_XP1_ATS();
            case 349:
                return new Callback_0349_BAGOO_XP1_PorscheCayenne();
            case 350:
                return new Callback_0350_HAOZHENG_XP1_BmwSeries();
            case 351:
                return new Callback_0351_WC2_16_QiYaK5();
            case 352:
                return new Callback_0352_WC2_RENAULT_KaBin();
            case 354:
                return new Callback_0354_XP1_14SanlinSeries();
            case 355:
                return new Callback_0355_XP_QiYaK5();
            case 356:
                return new Callback_0356_DJ_BenTengB30();
            case 357:
                return new Callback_0357_WC2_MaiRuiBao16();
            case 358:
                return new Callback_0358_WC_XP1_BenZSmart();
            case 359:
                return new Callback_0359_XP1_MaiRuiBao16();
            case 360:
                return new Callback_0360_WC2_2012Prado();
            case 361:
                return new Callback_0361_JinYing_XBS_OldB70();
            case 362:
                return new Callback_0362_RZC3_16_QiYaK5();
            case 363:
                return new Callback_0363_DAOJUN_XP1_ShuPingNewJunWei();
            case 364:
                return new Callback_0364_RZC_XP1_MaiRuiBao16();
            case 365:
                return new Callback_0365_AY1_JeepZYG();
            case 366:
                return new Callback_0366_WC2_16TuSheng();
            case 367:
                return new Callback_0367_XP1_16TuSheng();
            case 369:
                return new Callback_0369_CYT_DaZhongZiDongKongTiao();
            case 370:
                return new Callback_0370_RZC_XP1_15FengFan();
            case 371:
                return new Callback_0371_BG_XP1_ZiYouGuang();
            case 372:
                return new Callback_0372_WC1_Jeep_ZiYouGuang();
            case 373:
                return new Callback_0373_RZC_XP1_ZiYouGuang();
            case 374:
                return new Callback_0374_XP1_ZiYouGuang();
            case 375:
                return new Callback_0375_SBD_WC1_ReservedCdBenTengX80();
            case 376:
                return new Callback_0376_SBD_WC1_ForeginVersionRuiFengS5();
            case 377:
                return new Callback_0377_JYKJ_XP1_16BenTengB30();
            case 378:
                return new Callback_0378_XP1_FIESTA09();
            case 379:
                return new Callback_0379_BNR_XP1_GM();
            case 380:
                return new Callback_0380_XP1_FocusKeepDVD();
            case 381:
                return new Callback_0381_AY1_ATS_SRX();
            case 382:
                return new Callback_0382_JYKJ_XP_BeiQiShengBaoX55();
            case 383:
                return new Callback_0383_JYKJ_XP_ZhongTaiDaMaiX5();
            case 384:
                return new Callback_0384_DJ_ZhongTaiDaMaiX5();
            case 385:
                return new Callback_0385_HC_XP1_PartComHonda();
            case 386:
                return new Callback_0386_Bagoo_XP1_NewBmwSeries();
            case 387:
                return new Callback_0387_DaoJun_Sp_XP1_Camry2013();
            case 388:
                return new Callback_0388_HC_OLD_9TianLai();
            case 389:
                return new Callback_0389_XBS_XP1_16QIYA_K5();
            case 390:
                return new Callback_0390_XBS_XP1_ZhongTaiT600();
            case 392:
                return new Callback_0392_CYT_SHUPING_CAMARY();
            case 393:
                return new Callback_0393_RZC3_16_QiYaKX5();
            case 394:
                return new Callback_0394_WC2_16_QiYaKX5();
            case 395:
                if (carId == 5 || carId == 11 || carId == 19 || carId == 20 || carId == 31 || carId == 33 || carId == 34) {
                    return new Callback_0395_WC2_GuoChan_Beiqi();
                }
                if (carId == 29 || carId == 30 || carId == 35 || carId == 36) {
                    return new Callback_0395_WC2_GuoChan_JietuX70();
                }
                return new Callback_0395_WC2_GuoChan();
            case 396:
                return new Callback_0396_RZC_XP1_BeiQiShenBaoX55();
            case 397:
                return new Callback_0397_BNR_XP1_VScreen_Camry2013();
            case 398:
                if (carId == 5) {
                    return new Callback_0398_SBD_FORD_LIEYING();
                }
                return new Callback_0398_SBD_FYTA_DongFengFengGuang330and330s();
            case 402:
                return new Callback_0402_RZC_XP1_RENAULT_KeLeiJia();
            case 403:
                return new Callback_0403_BNR_XP1_ShuPingFord();
            case 404:
                return new Callback_0404_RZC_XP1_QiRuiAiRuiZe5();
            case 406:
                return new Callback_0406_XFY_ZhongTaiRS7();
            case 407:
                return new Callback_0407_DaoJun_XINPU_ChuanQiGs4();
            case 408:
                return new Callback_0408_SHA_Bus();
            case 409:
                return new Callback_0409_HeChi_RuiHu5();
            case 410:
                return new Callback_0410_XBS_XP1_ACCORD9();
            case 411:
                return new Callback_0411_WC_LANDROVER();
            case 412:
                return new Callback_0412_XP1_YearGmcSeries();
            case 413:
                return new Callback_0413_RZC_XP1_16BenTengB50();
            case 414:
                return new Callback_0414_XFY_XP1_TianLai();
            case 415:
                return new Callback_0415_WC_Haval_Coupe();
            case 416:
                return new Callback_0416_WC2_RongWeiRX5();
            case 417:
                if (carId == 2) {
                    return new Callback_0417_RZC_Benz_ML();
                }
                return new Callback_0417_CYT_YaGe7();
            case 418:
                return new Callback_0418_XBS_XP1_AnKeSela_Cx4_Atenza();
            case 419:
                return new Callback_0419_FengShenAX7();
            case 420:
                return new Callback_0420_WC2_ToYoTa_10_Crown();
            case 422:
                return new Callback_0422_RZC_FuMeiLai();
            case 423:
                return new Callback_0423_CYT_ShuPing_QiYaK3();
            case 424:
                return new Callback_0424_XP_KeLeiAo();
            case 425:
                if (carId == 3) {
                    return new Callback_0425_LuZhen_Spirior();
                }
                return new Callback_0425_XFY_HonDa_GuanDao();
            case 426:
                return new Callback_0426_JINEN_MZD6();
            case 427:
                return new Callback_0427_XFY_K3();
            case 428:
                return new Callback_0428_XP_BiaoZhi206();
            case 429:
                return new Callback_0429_DJ_XP1_TOYOTA_12Crown();
            case 430:
                return new Callback_0430_WC2_TianLai03_07();
            case 431:
                return new Callback_0431_HC_PSAAll();
            case 432:
                return new Callback_0432_HC_B200();
            case 433:
                return new Callback_0433_CYT_SBL();
            case 434:
                return new Callback_0434_BG_FIAT();
            case 435:
                return new Callback_0435();
            case 436:
                return new Callback_0436();
            case 437:
                return new Callback_0437_BNR_GaoErfu();
            case 438:
                if (carId == 5) {
                    return new Callback_0438_DJ_YuanJingX1();
                }
                return new Callback_0438_BNR_DaZhong();
            case 439:
                if (carId == 1) {
                    return new Callback_0439_XP1_BNR_YuSheng_S350();
                }
                if (carId == 2 || carId == 3 || carId == 4) {
                    return new Callback_0439_KeYuan_Escort();
                }
                if (carId == 6 || carId == 7) {
                    return new Callback_0439_DJ_HUITENG();
                }
                if (carId == 8) {
                    return new Callback_0439_DJ_14B70();
                }
                if (carId == 9) {
                    return new Callback_0439_DJ_14B70_H();
                }
                if (carId == 10) {
                    return new Callback_0439_OUDI_17FengJun6();
                }
                if (carId == 11 || carId == 12 || carId == 13 || carId == 14 || carId == 15) {
                    return new Callback_0439_OUDI_CHANGAN();
                }
                if (carId == 16) {
                    return new Callback_0439_DJ_MAZIDA6();
                }
                if (carId == 17) {
                    return new Callback_0439_HC_DONGNANV5();
                }
                if (carId == 18) {
                    return new Callback_0439_HC_ZHONGHUA530();
                }
                if (carId == 19 || carId == 58) {
                    return new Callback_0439_DJ_LEXUS_ES();
                }
                if (carId == 20) {
                    return new Callback_0439_OUDI_17BISU_T3();
                }
                if (carId == 21 || carId == 27 || carId == 38 || carId == 39 || carId == 108 || carId == 109 || carId == 116 || carId == 172 || carId == 238 || carId == 239) {
                    return new Callback_0439_OUDI_Haval_H9();
                }
                if (carId == 22) {
                    return new Callback_0439_DJ_08Prado_H();
                }
                if (carId == 23) {
                    return new Callback_0439_AY_BYD_SURUI();
                }
                if (carId == 24) {
                    return new Callback_0439_OD_17Dongnan_V5();
                }
                if (carId == 25) {
                    return new Callback_0439_BNR_GuanZhi();
                }
                if (carId == 26) {
                    return new Callback_0439_OUDI_Haval_H3();
                }
                if (carId == 28 || carId == 29 || carId == 117 || carId == 118) {
                    return new Callback_0439_BNR_Lexus_ES();
                }
                if (carId == 30 || carId == 193) {
                    return new Callback_0439_LZ_LandRover();
                }
                if (carId == 31 || carId == 60) {
                    return new Callback_0439_OD_NazhijieU7();
                }
                if (carId == 32 || carId == 123) {
                    return new Callback_0439_OD_MZD_ALL();
                }
                if (carId == 33 || carId == 34 || carId == 35 || carId == 36 || carId == 115 || carId == 130 || carId == 223) {
                    return new Callback_0439_RZC_CHANGAN_ZhongTai();
                }
                if (carId == 37 || carId == 51 || carId == 133) {
                    return new Callback_0439_XBS_Nissan_Tul();
                }
                if (carId == 40 || carId == 41 || carId == 42 || carId == 127 || carId == 128 || carId == 173 || carId == 174) {
                    return new Callback_0439_RZC_Jianghuai_All();
                }
                if (carId == 43 || carId == 44 || carId == 45 || carId == 46) {
                    return new Callback_0439_RZC_ChangAn_All();
                }
                if (carId == 47 || carId == 48 || carId == 49 || carId == 50) {
                    return new Callback_0439_LUZ_Lexus_IS();
                }
                if (carId == 52 || carId == 95 || carId == 96 || carId == 98) {
                    return new Callback_0439_LZ_Kayan();
                }
                if (carId == 53 || carId == 54) {
                    return new Callback_0439_HC_Chrysler();
                }
                if (carId == 55) {
                    return new Callback_0439_HC_Volvo();
                }
                if (carId == 56) {
                    return new Callback_0439_XFY_Lagan();
                }
                if (carId == 57 || carId == 103 || carId == 148 || carId == 149 || carId == 150 || carId == 151 || carId == 152 || carId == 153 || carId == 154 || carId == 198) {
                    return new Callback_0439_HuaChengYu_Byd_S7();
                }
                if (carId == 61) {
                    return new Callback_0439_HC_OuGeTL();
                }
                if (carId == 62) {
                    return new Callback_0439_XBS_09Tianlai();
                }
                if (carId == 63) {
                    return new Callback_0439_HC_Rongwei950();
                }
                if (carId == 64) {
                    return new Callback_0439_BNR_ARRIZO();
                }
                if (carId == 65) {
                    return new Callback_0439_RZC_FengguangS560();
                }
                if (carId == 66) {
                    return new Callback_0439_RZC_LufengXiaoyao();
                }
                if (carId == 67 || carId == 113 || carId == 114 || carId == 126 || carId == 175) {
                    return new Callback_0439_RZC_Changan_CX70();
                }
                if (carId == 68 || carId == 69 || carId == 176 || carId == 177 || carId == 178 || carId == 179 || carId == 180 || carId == 181 || carId == 182 || carId == 183 || carId == 184) {
                    return new Callback_0439_RZC_BenzAll();
                }
                if (carId == 70) {
                    return new Callback_0439_RZC_AudiQ3();
                }
                if (carId == 71) {
                    return new Callback_0439_HC_08TIanlai();
                }
                if (carId == 72) {
                    return new Callback_0439_HC_Qiya_KaiZunK7();
                }
                if (carId == 73 || carId == 74) {
                    return new Callback_0439_RZC_AddCanAll();
                }
                if (carId == 75 || carId == 82 || carId == 83 || carId == 84 || carId == 85 || carId == 86 || carId == 87 || carId == 88 || carId == 89 || carId == 90 || carId == 91 || carId == 131 || carId == 132 || carId == 171) {
                    return new Callback_0439_RZC_Nissan_Tuda();
                }
                if (carId == 76 || carId == 77 || carId == 78 || carId == 79 || carId == 80 || carId == 81) {
                    return new Callback_0439_XFY_Sanling_All();
                }
                if (carId == 92) {
                    return new Callback_0439_RZC_YinFeiNidi_GX50();
                }
                if (carId == 93 || carId == 99 || carId == 107 || carId == 119) {
                    return new Callback_0439_HC_TianLai_Gongjue();
                }
                if (carId == 97) {
                    return new Callback_0439_HC_Oubao_CD();
                }
                if (carId == 100) {
                    return new Callback_0439_OD_BenzAll();
                }
                if (carId == 101) {
                    return new Callback_0439_OD_AIying_Byd_Sirui();
                }
                if (carId == 102) {
                    return new Callback_0439_HC_Nissan_Xiaoke();
                }
                if (carId == 104 || carId == 105) {
                    return new Callback_0439_HC_Ford_Ruijie();
                }
                if (carId == 106) {
                    return new Callback_0439_RZC_TOYOTA_HuangGuan();
                }
                if (carId == 110) {
                    return new Callback_0439_DJ_Yage9();
                }
                if (carId == 111 || carId == 112 || carId == 124 || carId == 125) {
                    return new Callback_0439_LUZ_Toyato_All();
                }
                if (carId == 120) {
                    return new Callback_0439_HC_Nissan_16Tule();
                }
                if (carId == 121) {
                    return new Callback_0439_OD_ChangAn_CS95();
                }
                if (carId == 122 || carId == 162 || carId == 163 || carId == 164 || carId == 165 || carId == 221) {
                    return new Callback_0439_BNR_Rongwei_RX5();
                }
                if (carId == 129) {
                    return new Callback_0439_RCW_MZD_Ruiyi();
                }
                if (carId == 134) {
                    return new Callback_0439_XBS_Byd_Song();
                }
                if (carId == 135) {
                    return new Callback_0439_CXW_K50();
                }
                if (carId == 136 || carId == 143 || carId == 144 || carId == 145 || carId == 146 || carId == 147 || carId == 156 || carId == 157 || carId == 158 || carId == 252) {
                    return new Callback_0439_RZC_Sanlin_Yige();
                }
                if (carId == 139 || carId == 245) {
                    return new Callback_0439_OD_Opel_adan();
                }
                if (carId == 140) {
                    return new Callback_0439_XBS_08Yage();
                }
                if (carId == 141) {
                    return new Callback_0439_LUZ_Binli();
                }
                if (carId == 142) {
                    return new Callback_0439_OD_Lingmu();
                }
                if (carId == 155) {
                    return new Callback_0439_HC_Benz_C200();
                }
                if (carId == 159 || carId == 160) {
                    return new Callback_0439_OUDI_Haval_H9();
                }
                if (carId == 161) {
                    return new Callback_0439_HC_HuansuH3();
                }
                if (carId == 166 || carId == 167 || carId == 168) {
                    return new Callback_0439_BNR_Qichen();
                }
                if (carId == 169 || carId == 249 || carId == 250) {
                    return new Callback_0439_BNR_Haval_H6();
                }
                if (carId == 170) {
                    return new Callback_0439_BNR_Nissan_Tule();
                }
                if (carId == 185 || carId == 186 || carId == 187 || carId == 188 || carId == 189 || carId == 190 || carId == 191 || carId == 192) {
                    return new Callback_0439_XP_SUBURU();
                }
                if (carId == 194) {
                    return new Callback_0439_LZ_Infinit_FX35();
                }
                if (carId == 195 || carId == 196) {
                    return new Callback_0439_Daojun_XP1_TianLai();
                }
                if (carId == 197) {
                    return new Callback_0439_Daojun_Kayan();
                }
                if (carId == 199 || carId == 200 || carId == 201 || carId == 202 || carId == 203 || carId == 204 || carId == 205 || carId == 206) {
                    return new Callback_0439_OD_Ford_Falcon();
                }
                if (carId == 207) {
                    return new Callback_0439_Luz_Nissac_GTR();
                }
                if (carId == 208 || carId == 209 || carId == 210 || carId == 211) {
                    return new Callback_0439_XFY_Keleiao();
                }
                if (carId == 212 || carId == 240 || carId == 241) {
                    return new Callback_0439_RZC_SiWei();
                }
                if (carId == 213 || carId == 214) {
                    return new Callback_0439_DJ_Rongwe_iI5();
                }
                if (carId == 215 || carId == 216 || carId == 217 || carId == 218 || carId == 219) {
                    return new Callback_0439_OUDI_Beiqi_Diandong();
                }
                if (carId == 220) {
                    return new Callback_0439_DJ_BYD_M6();
                }
                if (carId == 222) {
                    return new Callback_0439_DJ_Siyu_Diandong();
                }
                if (carId == 224 || carId == 225 || carId == 226 || carId == 227 || carId == 228 || carId == 229 || carId == 230 || carId == 231 || carId == 232) {
                    return new Callback_0439_RZC_MZD_ALL();
                }
                if (carId == 233) {
                    return new Callback_0439_LUZ_BMW_Mini();
                }
                if (carId == 234) {
                    return new Callback_0439_HC_Ford_Explorer();
                }
                if (carId == 235 || carId == 236) {
                    return new Callback_0439_XC_Xiandai_Suolantuo();
                }
                if (carId == 237) {
                    return new Callback_0439_XC_Feiyate_Feiyue();
                }
                if (carId == 242 || carId == 243 || carId == 244) {
                    return new Callback_0439_DJ_Qirui();
                }
                if (carId == 246) {
                    return new Callback_0439_HC_Gl8_Old();
                }
                if (carId == 247) {
                    return new Callback_0439_LZ_BMW_E46();
                }
                if (carId == 248) {
                    return new Callback_0439_XP_ISUZU_DMAX();
                }
                if (carId == 251) {
                    return new Callback_0439_OD_Foton_Tunland();
                }
                if (carId == 253) {
                    return new Callback_0439_OD_Audi_A6();
                }
                if (carId == 254) {
                    return new Callback_0439_OD_BMW_NBT_EVO();
                }
                if (carId != 1) {
                    return new Callback_0442_KSW_AUDI_Q5();
                }
                if (carId == 11) {
                    return new Callback_0442_WC1_AUDI_A3();
                }
                return new Callback_0442_CHEKU_ATS();
            case 442:
                if (carId != 1) {
                }
                break;
            case 443:
                if (carId == 0 || carId == 107 || carId == 133 || carId == 134 || carId == 135 || carId == 136 || carId == 137 || carId == 138 || carId == 139 || carId == 140 || carId == 141) {
                    return new Callback_0443_WC2_Oulande();
                }
                if (carId == 1) {
                    return new Callback_0443_WC2_SgmwS();
                }
                if (carId == 2) {
                    return new Callback_0443_WC2_KangDi();
                }
                if (carId == 3 || carId == 108) {
                    return new Callback_0443_WC2_12ELYSION();
                }
                if (carId == 4) {
                    return new Callback_0443_WC2_18FENGGUANG_S560();
                }
                if (carId == 6 || carId == 7 || carId == 8 || carId == 9 || carId == 10 || carId == 11 || carId == 12 || carId == 13 || carId == 14 || carId == 15 || carId == 16) {
                    return new Callback_0443_WC2_MAZD_ALL();
                }
                if (carId == 17 || carId == 86 || carId == 87 || carId == 88 || carId == 89) {
                    return new Callback_0443_WC2_Jianghuai_IEV6E();
                }
                if (carId == 18 || carId == 72 || carId == 75) {
                    return new Callback_0443_WC2_08_12Tianlai();
                }
                if (carId == 19 || carId == 54) {
                    return new Callback_0443_WC2_Benz_Metris();
                }
                if (carId == 20) {
                    return new Callback_0443_WC2_Jili_GC7();
                }
                if (carId == 21 || carId == 22 || carId == 24) {
                    return new Callback_0443_WC2_TOYOTA_09HG();
                }
                if (carId == 23 || carId == 62 || carId == 63 || carId == 64 || carId == 65 || carId == 66 || carId == 70 || carId == 81 || carId == 93 || carId == 109 || carId == 110) {
                    return new Callback_0443_WC2_YingFeiNiDi_GX50();
                }
                if (carId == 25 || carId == 27 || carId == 28 || carId == 67 || carId == 68 || carId == 69 || carId == 90 || carId == 91 || carId == 94 || carId == 95 || carId == 96 || carId == 97) {
                    return new Callback_0443_WC2_19Focus();
                }
                if (carId == 26 || carId == 119) {
                    return new Callback_0443_WC2_Nissan_Ruiqi6();
                }
                if (carId == 29) {
                    return new Callback_0443_WC2_Tianlai_Gongjue();
                }
                if ((carId >= 30 && carId <= 53) || carId == 59 || carId == 98 || carId == 99) {
                    return new Callback_0443_WC2_Xiandai_All();
                }
                if ((carId >= 55 && carId <= 57) || carId == 60 || carId == 61 || carId == 73 || carId == 74 || carId == 84 || carId == 100 || carId == 101 || carId == 104 || ((carId >= 120 && carId <= 130) || carId == 185 || carId == 186 || carId == 187 || carId == 188 || carId == 189 || carId == 190 || carId == 191 || carId == 192 || carId == 193 || carId == 194 || carId == 195 || carId == 196 || carId == 197 || carId == 198 || carId == 199 || carId == 200 || carId == 201 || carId == 202 || carId == 203 || carId == 204 || carId == 205 || carId == 206 || carId == 207)) {
                    return new Callback_0443_WC2_Fieyate_All();
                }
                if (carId == 58) {
                    return new Callback_0443_WC2_Nazhijie_U6();
                }
                if (carId == 71) {
                    return new Callback_0443_WC2_WeiChai();
                }
                if (carId == 76 || carId == 77 || carId == 78 || carId == 79 || carId == 85 || carId == 102 || carId == 103) {
                    return new Callback_0443_WC2_Ford_Lincoin_All();
                }
                if (carId == 82 || carId == 83 || carId == 182 || carId == 183 || carId == 184) {
                    return new Callback_0443_WC2_TATA_All();
                }
                if (carId == 92 || carId == 147 || carId == 148 || carId == 149 || carId == 150 || carId == 151) {
                    return new Callback_0443_WC2_MHD_SCORPIO();
                }
                if (carId == 105) {
                    return new Callback_0443_WC2_SAAB();
                }
                if (carId == 106) {
                    return new Callback_0443_UAZ_Patriot();
                }
                if (carId == 111 || carId == 112 || carId == 113 || carId == 114 || carId == 115 || carId == 116 || carId == 159 || carId == 160 || carId == 161 || carId == 162 || carId == 163 || carId == 164 || carId == 165 || carId == 166 || carId == 167 || carId == 168 || carId == 169 || carId == 170 || carId == 171 || carId == 172 || carId == 173 || carId == 174 || carId == 175 || carId == 176) {
                    return new Callback_0443_WC2_Opel_Old();
                }
                if (carId == 117 || carId == 118) {
                    return new Callback_0443_WY_BBA_All();
                }
                if (carId == 142 || carId == 143 || carId == 144 || carId == 145 || carId == 146) {
                    return new Callback_0443_WC2_Proton_All();
                }
                if (carId == 156 || carId == 157 || carId == 158) {
                    return new Callback_0443_WC2_Perodua_All();
                }
                if (carId == 177 || carId == 178 || carId == 179 || carId == 180 || carId == 181) {
                    return new Callback_0443_WC2_Suzuki_All();
                }
                if (carId == 1) {
                    return new Callback_0445_WC_RZC1_HaimaS7();
                }
                if (carId != 1 || carId == 2 || carId == 3 || carId == 4 || carId == 5 || carId == 6 || carId == 7 || carId == 8 || carId == 9 || carId == 10 || carId == 11 || carId == 12 || carId == 13 || carId == 14 || carId == 15 || carId == 16 || carId == 17 || carId == 18 || carId == 19 || carId == 20 || carId == 21 || carId == 22) {
                    return new Callback_0447_OD_RZC3_19Tusheng();
                }
                return new Callback_0448_LZ_BWM_CarUi();
            case 445:
                if (carId == 1) {
                }
                if (carId != 1) {
                }
                return new Callback_0447_OD_RZC3_19Tusheng();
            case 447:
                if (carId != 1) {
                }
                return new Callback_0447_OD_RZC3_19Tusheng();
            case 448:
                return new Callback_0448_LZ_BWM_CarUi();
            case 450:
                return new Callback_0450_ZHTD_BWM_CarUi();
            case 452:
                if (carId == 1) {
                    return new Callback_0439_HC_TianLai_Gongjue();
                }
                if (carId == 2 || carId == 3 || carId == 42 || carId == 43 || carId == 44 || carId == 45 || carId == 46 || carId == 47) {
                    return new Callback_0452_Baogu_Renault();
                }
                if (carId == 4 || carId == 5 || carId == 6 || carId == 21 || carId == 60 || carId == 72 || carId == 73 || carId == 168 || carId == 175) {
                    return new Callback_0439_RZC_Changan_CX70();
                }
                if (carId == 7 || carId == 8 || carId == 9) {
                    return new Callback_0452_Oudi_Dongnan_All();
                }
                if (carId == 10 || carId == 11 || carId == 145 || carId == 146) {
                    return new Callback_0452_Oudi_Jianghuai_Ruifeng();
                }
                if (carId == 12 || carId == 13 || carId == 16 || carId == 33 || carId == 54 || carId == 85 || carId == 209) {
                    return new Callback_0439_RZC_CHANGAN_ZhongTai();
                }
                if (carId == 14 || carId == 15 || carId == 81 || carId == 82 || carId == 83 || carId == 84) {
                    return new Callback_0439_LUZ_Lexus_IS();
                }
                if (carId == 17 || carId == 18) {
                    return new Callback_0452_XFY_PSA_3008();
                }
                if (carId == 19) {
                    return new Callback_0439_RZC_TOYOTA_HuangGuan();
                }
                if (carId == 20 || carId == 32) {
                    return new Callback_0452_XFY_SUBARU();
                }
                if (carId == 22) {
                    return new Callback_0439_LUZ_Binli();
                }
                if (carId == 23) {
                    return new Callback_0452_OD_Qirui_KaiyiX3();
                }
                if (carId == 24 || carId == 25 || carId == 26 || carId == 27 || carId == 28 || carId == 29 || carId == 30 || carId == 31 || carId == 61 || carId == 62 || carId == 63 || carId == 77 || carId == 78) {
                    return new Callback_0452_Xincheng_Infiniti_All();
                }
                if (carId == 34 || carId == 35 || carId == 36) {
                    return new Callback_0452_XP_Megane4_All();
                }
                if (carId == 38) {
                    return new Callback_0452_OD_Cadillac_Escalade();
                }
                if (carId == 39) {
                    return new Callback_0439_HC_Nissan_Xiaoke();
                }
                if (carId == 40) {
                    return new Callback_0452_XC_Nissan_Tule();
                }
                if (carId == 41) {
                    return new Callback_0452_Mixun_Liebao_CS9();
                }
                if (carId == 48 || carId == 49) {
                    return new Callback_0452_OD_Ferrari();
                }
                if (carId == 52 || carId == 53) {
                    return new Callback_0452_RZC_BisuT5();
                }
                if (carId == 55 || carId == 96 || carId == 97 || carId == 188) {
                    return new Callback_0439_XBS_08Yage();
                }
                if (carId == 56 || carId == 105 || carId == 106 || carId == 107 || carId == 195 || carId == 202 || carId == 240) {
                    return new Callback_0452_LZ_Jaguar();
                }
                if (carId == 57) {
                    return new Callback_0452_OD_Weichai_U70();
                }
                if (carId == 58 || carId == 140 || carId == 157) {
                    return new Callback_0452_RZC_Aodesai();
                }
                if (carId == 59) {
                    return new Callback_0452_OD_BMW_Mini();
                }
                if (carId == 64 || carId == 65 || carId == 66 || carId == 67 || carId == 68 || carId == 69 || carId == 70 || carId == 71) {
                    return new Callback_0452_OD_BMW_X1();
                }
                if (carId == 74 || carId == 123 || carId == 124 || carId == 236 || carId == 237) {
                    return new Callback_0452_RZC_Volvo_XC60();
                }
                if (carId == 75 || carId == 92) {
                    return new Callback_0452_LZ_Jaguar_XF();
                }
                if (carId == 76) {
                    return new Callback_0452_DJ_Dodge_JCUV();
                }
                if (carId == 79) {
                    return new Callback_0452_OD_Porsche_All();
                }
                if (carId == 86) {
                    return new Callback_0452_OD_Nissan_QUEST();
                }
                if (carId == 87 || carId == 89 || carId == 158) {
                    return new Callback_0452_OD_ChangfengLiebao_CS9();
                }
                if (carId == 88) {
                    return new Callback_0452_CYT_Hyundai_VERACRUZ();
                }
                if (carId == 90) {
                    return new Callback_0452_LZ_TATA_ALL();
                }
                if (carId == 91) {
                    return new Callback_0452_ZH_Pajero();
                }
                if (carId == 93) {
                    return new Callback_0452_OD_Nissan_Tule();
                }
                if (carId == 94) {
                    return new Callback_0452_OD_Zhonghua_V6();
                }
                if (carId == 95) {
                    return new Callback_0439_XC_Feiyate_Feiyue();
                }
                if (carId == 98 || carId == 99 || carId == 100 || carId == 101 || carId == 102) {
                    return new Callback_0439_HC_Ford_Explorer();
                }
                if (carId == 103) {
                    return new Callback_0452_OD_CAOTIVA_GM();
                }
                if (carId == 104 || carId == 189 || carId == 190) {
                    return new Callback_0452_OD_Zotye_T700();
                }
                if (carId == 108) {
                    return new Callback_0452_LZ_Subaru_TRIBECA();
                }
                if (carId == 109) {
                    return new Callback_0452_XBS_Nissan_cedric();
                }
                if (carId == 110) {
                    return new Callback_0452_RZC_Subaru();
                }
                if (carId == 111 || carId == 126 || carId == 186 || carId == 196 || carId == 206) {
                    return new Callback_0439_RZC_BenzAll();
                }
                if (carId == 112) {
                    return new Callback_0452_ZH_Toyota_PREVIA();
                }
                if (carId == 113) {
                    return new Callback_0452_ZH_Toyota_PREVIA();
                }
                if (carId == 114 || carId == 115) {
                    return new Callback_0452_XC_GM_Rongwei_All();
                }
                if (carId == 116) {
                    return new Callback_0452_OD_HZ_Nezha();
                }
                if (carId == 117 || carId == 118) {
                    return new Callback_0452_TangDu_Nissan_All();
                }
                if (carId == 119) {
                    return new Callback_0452_OD_LandRover_Freelander();
                }
                if (carId == 120) {
                    return new Callback_0452_LZ_Oubao_Andela();
                }
                if (carId == 121) {
                    return new Callback_0452_OD_Lamborghini();
                }
                if (carId == 122 || carId == 208 || carId == 252) {
                    return new Callback_0452_LZ_Volvo();
                }
                if (carId == 125) {
                    return new Callback_0452_OD_Volvo();
                }
                if (carId == 127 || carId == 128 || carId == 234 || carId == 235) {
                    return new Callback_0452_OD_Huachen_SWM();
                }
                if (carId == 129 || carId == 141) {
                    return new Callback_0452_OD_Ford_PRO();
                }
                if (carId == 130 || carId == 131 || carId == 220 || carId == 221 || carId == 222 || carId == 223) {
                    return new Callback_0452_XC_Lexus();
                }
                if (carId == 132 || carId == 246 || carId == 247 || carId == 248 || carId == 249 || carId == 250 || carId == 251) {
                    return new Callback_0439_OUDI_Haval_H9();
                }
                if (carId == 133) {
                    return new Callback_0452_XC_Nissan_Tule_CD();
                }
                if (carId == 134) {
                    return new Callback_0452_Bagu_360Guiji();
                }
                if (carId == 135) {
                    return new Callback_0452_ZH_Toyota_Proace();
                }
                if (carId == 136 || carId == 137) {
                    return new Callback_0452_Tangdu_Toyota_All();
                }
                if (carId == 138 || carId == 139) {
                    return new Callback_0452_DJ_Ford_All();
                }
                if (carId == 142 || carId == 143 || carId == 144 || carId == 169 || carId == 170 || carId == 171) {
                    return new Callback_0452_LZ_Audi_All();
                }
                if (carId == 147 || carId == 148 || carId == 149 || carId == 150 || carId == 151 || carId == 152 || carId == 153 || carId == 154 || carId == 155 || carId == 156) {
                    return new Callback_0452_KYC_Sanlin_All();
                }
                if (carId == 159) {
                    return new Callback_0452_DJ_Jianghuai_Sihao();
                }
                if (carId == 160) {
                    return new Callback_0452_OD_Jiangling_TAGA();
                }
                if (carId == 161) {
                    return new Callback_0452_LZ_Nissan_Fuga();
                }
                if (carId == 162 || carId == 163 || carId == 164 || carId == 165) {
                    return new Callback_0452_KYC_Zhonghua_All();
                }
                if (carId == 166 || carId == 167) {
                    return new Callback_0439_RZC_Jianghuai_All();
                }
                if (carId == 172) {
                    return new Callback_0452_DJ_Guanzhi_All();
                }
                if (carId == 173) {
                    return new Callback_0439_RZC_SiWei();
                }
                if (carId == 174 || carId == 215) {
                    return new Callback_0452_LZ_Ford_Mustang();
                }
                if (carId == 176) {
                    return new Callback_0439_OD_NazhijieU7();
                }
                if (carId == 179 || carId == 180 || carId == 181 || carId == 182 || carId == 212) {
                    return new Callback_0452_PA_Nissan_All();
                }
                if (carId == 183) {
                    return new Callback_0452_TZY_UAZ_Patriot();
                }
                if (carId == 184) {
                    return new Callback_0452_OD_Fengye_80V();
                }
                if (carId == 185) {
                    return new Callback_0452_OD_Hongqi_H7();
                }
                if (carId == 187) {
                    return new Callback_0452_LZ_Maserati();
                }
                if (carId == 191) {
                    return new Callback_0452_OD_Qirui_Xiaomayi();
                }
                if (carId == 192) {
                    return new Callback_0452_OD_Ford_Navigator();
                }
                if (carId == 193 || carId == 194) {
                    return new Callback_0439_LUZ_Toyato_All();
                }
                if (carId == 197 || carId == 198 || carId == 199) {
                    return new Callback_0452_XC_Honda_Acura();
                }
                if (carId == 200 || carId == 201) {
                    return new Callback_0452_OD_LeTin_Mangguo();
                }
                if (carId == 203 || carId == 204) {
                    return new Callback_0452_XP_Fiat_All();
                }
                if (carId == 205) {
                    return new Callback_0452_LZ_Benz_Smart();
                }
                if (carId == 210) {
                    return new Callback_0452_OD_Changcheng_Fengjun5();
                }
                if (carId == 211) {
                    return new Callback_0439_LZ_BMW_E46();
                }
                if (carId == 213 || carId == 214) {
                    return new Callback_0452_CYT_Toyota_Tundra();
                }
                if (carId == 216) {
                    return new Callback_0452_OD_ChangCheng_Oula();
                }
                if (carId == 217 || carId == 218 || carId == 219) {
                    return new Callback_0452_KYC_Toyota_All();
                }
                if (carId == 224) {
                    return new Callback_0452_XP_ZH_Ford_All();
                }
                if (carId == 225) {
                    return new Callback_0452_Daojun_Toyota_PREVIA();
                }
                if (carId == 226 || carId == 227 || carId == 228 || carId == 229 || carId == 230 || carId == 231 || carId == 232 || carId == 233) {
                    return new Callback_0452_LZ_Audi_Q5_All();
                }
                if (carId == 238) {
                    return new Callback_0452_PA_Ford_F150();
                }
                if (carId == 239 || carId == 253 || carId == 254) {
                    return new Callback_0452_OD_Weima_E5();
                }
                if (carId == 241 || carId == 242 || carId == 243 || carId == 244 || carId == 245) {
                    return new Callback_0439_OUDI_Haval_H9();
                }
                if (carId != 3 || carId == 132) {
                    return new Callback_0453_OD_Chuangwei_ET5();
                }
                if (carId == 4 || carId == 5 || carId == 6 || carId == 7) {
                    return new Callback_0439_LZ_BMW_E46();
                }
                if (carId == 8) {
                    return new Callback_0439_BNR_GuanZhi();
                }
                if (carId == 9) {
                    return new Callback_0439_RZC_Sanlin_Yige();
                }
                if (carId == 10) {
                    return new Callback_0453_LZ_Changcheng_Poer();
                }
                if (carId == 11 || carId == 87 || carId == 88) {
                    return new Callback_0452_PA_Ford_F150();
                }
                if (carId == 12) {
                    return new Callback_0453_OD_Futon_Lion();
                }
                if (carId == 14 || carId == 193) {
                    return new Callback_0453_OD_JMC_New_Energy();
                }
                if (carId == 16) {
                    return new Callback_0453_OD_Bent_NAT_Energy();
                }
                if (carId == 17 || carId == 18 || carId == 136 || carId == 137 || carId == 147 || carId == 148) {
                    return new Callback_0439_LUZ_Lexus_IS();
                }
                if (carId == 19 || carId == 20) {
                    return new Callback_0453_OD_Dongfeng_Energy();
                }
                if (carId == 21) {
                    return new Callback_0453_LZ_AstonMartin();
                }
                if (carId == 22) {
                    return new Callback_0439_HC_TianLai_Gongjue();
                }
                if (carId == 23) {
                    return new Callback_0453_LZ_BMW_15Mini();
                }
                if (carId == 24) {
                    return new Callback_0453_LZ_Nissan_QRV();
                }
                if (carId == 25) {
                    return new Callback_0452_RZC_Aodesai();
                }
                if (carId == 26) {
                    return new Callback_0453_RZC_Hongqi_H5();
                }
                if (carId == 27 || carId == 28) {
                    return new Callback_0452_OD_Ford_PRO();
                }
                if (carId == 29 || carId == 30 || carId == 31 || carId == 32 || carId == 65 || carId == 66 || carId == 67 || carId == 68 || carId == 69 || carId == 70 || carId == 71 || carId == 200 || carId == 201 || carId == 202 || carId == 203) {
                    return new Callback_0452_XP_ZH_Ford_All();
                }
                if (carId == 33 || carId == 34 || carId == 35) {
                    return new Callback_0453_LZ_GM_All();
                }
                if (carId == 36) {
                    return new Callback_0453_LZ_Benz_C200();
                }
                if (carId == 37 || carId == 38 || carId == 129 || carId == 245) {
                    return new Callback_0452_OD_Fengye_80V();
                }
                if (carId == 39) {
                    return new Callback_0453_LZ_Ferrari_430();
                }
                if (carId == 40) {
                    return new Callback_0453_LZ_Binli_Tianyue();
                }
                if (carId == 41 || carId == 42) {
                    return new Callback_0453_LZ_Nissan_03Teana();
                }
                if (carId == 43 || carId == 44 || carId == 46 || carId == 47) {
                    return new Callback_0453_OD_Jianghuai_JiayueA5();
                }
                if (carId == 45 || carId == 48) {
                    return new Callback_0452_OD_Weima_E5();
                }
                if (carId == 49 || carId == 50 || carId == 51) {
                    return new Callback_0439_RZC_MZD_ALL();
                }
                if (carId == 52 || carId == 53 || carId == 54) {
                    return new Callback_0439_RZC_Changan_CX70();
                }
                if (carId == 62 || carId == 63 || carId == 64) {
                    return new Callback_0453_XP_Audi_A3();
                }
                if (carId == 72) {
                    return new Callback_0453_BG_Toyota_Alpha();
                }
                if (carId == 73 || carId == 91) {
                    return new Callback_0439_RZC_SiWei();
                }
                if (carId == 74 || carId == 196 || carId == 197) {
                    return new Callback_0453_OD_Beiqi_BJ80();
                }
                if (carId == 75 || carId == 76) {
                    return new Callback_0453_RZC_Mclaren_All();
                }
                if (carId == 77) {
                    return new Callback_0453_LZ_Volvo_XC90();
                }
                if (carId == 78) {
                    return new Callback_0453_LZ_BBA_All();
                }
                if (carId == 79 || carId == 80 || carId == 124 || carId == 125) {
                    return new Callback_0439_LUZ_Toyato_All();
                }
                if (carId == 85 || carId == 86) {
                    return new Callback_0453_LZ_Maserati_300C();
                }
                if (carId == 89 || carId == 90) {
                    return new Callback_0439_Daojun_XP1_TianLai();
                }
                if (carId == 92 || carId == 93) {
                    return new Callback_0439_RZC_Jianghuai_All();
                }
                if (carId == 95) {
                    return new Callback_0453_OD_Weima_EX5();
                }
                if (carId == 96 || carId == 127) {
                    return new Callback_0453_OD_Zhidou_All();
                }
                if (carId == 97 || carId == 98 || carId == 99 || carId == 100 || carId == 101 || carId == 102 || carId == 103 || carId == 104 || carId == 105 || carId == 106 || carId == 107 || carId == 108 || carId == 109 || carId == 110 || carId == 111 || carId == 112 || carId == 113 || carId == 114 || carId == 115 || carId == 116 || carId == 117 || carId == 118 || carId == 119 || carId == 120) {
                    return new Callback_0452_KYC_Toyota_All();
                }
                if (carId == 121) {
                    return new Callback_0453_LZ_ALFA_ROMEO();
                }
                if (carId == 122) {
                    return new Callback_0453_LZ_Ferrari_F12();
                }
                if (carId == 123) {
                    return new Callback_0439_HuaChengYu_Byd_S7();
                }
                if (carId == 126) {
                    return new Callback_0453_XP_Opel_New();
                }
                if (carId == 128) {
                    return new Callback_0452_OD_Ford_PRO();
                }
                if (carId == 130 || carId == 199) {
                    return new Callback_0439_HuaChengYu_Byd_S7();
                }
                if (carId == 131) {
                    return new Callback_0453_LUZ_Bentley_MS();
                }
                if (carId == 133) {
                    return new Callback_0453_XC_Benz_Smart();
                }
                if (carId == 134 || carId == 135) {
                    return new Callback_0453_LZ_Jili_Boyue();
                }
                if (carId == 140 || carId == 141 || carId == 142) {
                    return new Callback_0453_LZ_LandRover_KeepCD();
                }
                if (carId >= 149 && carId <= 189) {
                    return new Callback_0452_Tangdu_Toyota_All();
                }
                if (carId == 190) {
                    return new Callback_0452_XC_Honda_Acura();
                }
                if (carId == 191 || carId == 192) {
                    return new Callback_0453_LZ_Toyota_Vios();
                }
                if (carId == 194) {
                    return new Callback_0453_OD_Dongfeng_Chenglong_H7();
                }
                if (carId == 195) {
                    return new Callback_0453_OD_Jianghuai_Chaoyue();
                }
                if (carId == 198) {
                    return new Callback_0453_OD_Renault_Keleos();
                }
                if (carId == 204 || carId == 205 || carId == 206 || carId == 207 || carId == 208 || carId == 209 || carId == 210 || carId == 211 || carId == 212 || carId == 213 || carId == 214 || carId == 215 || carId == 216 || carId == 217 || carId == 218 || carId == 219 || carId == 220 || carId == 221 || carId == 222 || carId == 223 || carId == 224 || carId == 225 || carId == 226 || carId == 227 || carId == 228 || carId == 229 || carId == 230 || carId == 231 || carId == 232 || carId == 233 || carId == 234 || carId == 235 || carId == 236) {
                    return new Callback_0453_TD_LandRover_All();
                }
                if (carId == 237 || carId == 238 || carId == 239) {
                    return new Callback_0453_LZ_Nissan_Teana_08();
                }
                if (carId == 240 || carId == 241) {
                    return new Callback_0453_LZ_Honda_06Civic();
                }
                if (carId == 242) {
                    return new Callback_0453_RZC_VinFast5_Plus_23();
                }
                if (carId == 243) {
                    return new Callback_0453_OD_Changhe_Q7();
                }
                if (carId == 244) {
                    return new Callback_0453_OD_Shanqi_ZHongka();
                }
                if (carId == 246 || carId == 247) {
                    return new Callback_0453_XC_Ford_EDGE();
                }
                if (carId == 248) {
                    return new Callback_0453_RZC_Suzuki_IGNIS();
                }
                if (carId == 249) {
                    return new Callback_0453_OD_Zhongqi_HOWO();
                }
                return new Callback_0000_null();
            case 453:
                if (carId != 3) {
                    break;
                }
                return new Callback_0453_OD_Chuangwei_ET5();
            case FinalCanbus.CAR_XP1_14Prado_L /* 3276820 */:
                return new Callback_0063_XP1_14Prado();
            default:
                return new Callback_0000_null();
        }
        return null;
    }
}
