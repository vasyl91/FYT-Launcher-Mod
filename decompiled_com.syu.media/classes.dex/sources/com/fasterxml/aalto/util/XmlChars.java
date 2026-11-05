package com.fasterxml.aalto.util;

import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import base.event.AutoKeyEvent;
import bsp.FinalBsp;
import com.syu.media.ListCondition01;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class XmlChars {
    static final int SIZE = 394;
    static final int[] sXml10Chars;
    static final int[] sXml10StartChars;

    public static final boolean is11NameChar(int i) {
        if (i > 12271) {
            if (i < 12289) {
                return false;
            }
            if (i <= 55295) {
                return true;
            }
            if (i < 63744) {
                return false;
            }
            if (i <= 65533) {
                return i <= 64975 || i >= 65008;
            }
            return i > 65535 && i <= 983039;
        }
        if (i < 8192) {
            return (i >= 192 && i != 894) || i == 183;
        }
        if (i >= 11264) {
            return true;
        }
        if (i < 8204 || i > 8591) {
            return false;
        }
        if (i >= 8304) {
            return true;
        }
        return i == 8204 || i == 8205 || i == 8255 || i == 8256;
    }

    public static final boolean is11NameStartChar(int i) {
        if (i > 12271) {
            if (i >= 12289) {
                if (i <= 55295) {
                    return true;
                }
                if (i >= 63744) {
                    if (i <= 65533) {
                        return i <= 64975 || i >= 65008;
                    }
                    return i > 65535 && i <= 983039;
                }
            }
            return false;
        }
        if (i < 768) {
            if (i < 192) {
                return false;
            }
            return (i == 215 || i == 247) ? false : true;
        }
        if (i >= 11264) {
            return true;
        }
        if (i < 880 || i > 8591) {
            return false;
        }
        if (i < 8192) {
            return i != 894;
        }
        if (i >= 8304) {
            return i <= 8591;
        }
        return i == 8204 || i == 8205;
    }

    static {
        int[] iArr = new int[SIZE];
        sXml10StartChars = iArr;
        SETBITS(iArr, 65, 90);
        SETBITS(iArr, 95);
        SETBITS(iArr, 97, 122);
        SETBITS(iArr, ListCondition01.USB, 214);
        SETBITS(iArr, 216, FinalBsp.KEY_AIR_TEMP_MINUS);
        SETBITS(iArr, FinalBsp.KEY_AIR_CYCLE, 255);
        SETBITS(iArr, 256, 305);
        SETBITS(iArr, 308, 318);
        SETBITS(iArr, 321, 328);
        SETBITS(iArr, 330, 382);
        SETBITS(iArr, 384, 451);
        SETBITS(iArr, 461, 496);
        SETBITS(iArr, 500, 501);
        SETBITS(iArr, 506, AutoKeyEvent.KEYCODE_CARUSB);
        SETBITS(iArr, AutoKeyEvent.KEYCODE_360_PANORAMIC_AND_REAR, 680);
        SETBITS(iArr, 699, 705);
        SETBITS(iArr, 902);
        SETBITS(iArr, 904, 906);
        SETBITS(iArr, 908);
        SETBITS(iArr, 910, 929);
        SETBITS(iArr, 931, 974);
        SETBITS(iArr, 976, 982);
        SETBITS(iArr, 986);
        SETBITS(iArr, 988);
        SETBITS(iArr, 990);
        SETBITS(iArr, 992);
        SETBITS(iArr, 994, PointerIconCompat.TYPE_COPY);
        SETBITS(iArr, InputDeviceCompat.SOURCE_GAMEPAD, 1036);
        SETBITS(iArr, 1038, 1103);
        SETBITS(iArr, 1105, 1116);
        SETBITS(iArr, 1118, 1153);
        SETBITS(iArr, 1168, 1220);
        SETBITS(iArr, 1223, 1224);
        SETBITS(iArr, 1227, 1228);
        SETBITS(iArr, 1232, 1259);
        SETBITS(iArr, 1262, 1269);
        SETBITS(iArr, 1272, 1273);
        SETBITS(iArr, 1329, 1366);
        SETBITS(iArr, 1369);
        SETBITS(iArr, 1377, 1414);
        SETBITS(iArr, 1488, 1514);
        SETBITS(iArr, 1520, 1522);
        SETBITS(iArr, 1569, 1594);
        SETBITS(iArr, 1601, 1610);
        SETBITS(iArr, 1649, 1719);
        SETBITS(iArr, 1722, 1726);
        SETBITS(iArr, 1728, 1742);
        SETBITS(iArr, 1744, 1747);
        SETBITS(iArr, 1749);
        SETBITS(iArr, 1765, 1766);
        SETBITS(iArr, 2309, 2361);
        SETBITS(iArr, 2365);
        SETBITS(iArr, 2392, 2401);
        SETBITS(iArr, 2437, 2444);
        SETBITS(iArr, 2447, 2448);
        SETBITS(iArr, 2451, 2472);
        SETBITS(iArr, 2474, 2480);
        SETBITS(iArr, 2482);
        SETBITS(iArr, 2486, 2489);
        SETBITS(iArr, 2524);
        SETBITS(iArr, 2525);
        SETBITS(iArr, 2527, 2529);
        SETBITS(iArr, 2544);
        SETBITS(iArr, 2545);
        SETBITS(iArr, 2565, 2570);
        SETBITS(iArr, 2575);
        SETBITS(iArr, 2576);
        SETBITS(iArr, 2579, 2600);
        SETBITS(iArr, 2602, 2608);
        SETBITS(iArr, 2610);
        SETBITS(iArr, 2611);
        SETBITS(iArr, 2613);
        SETBITS(iArr, 2614);
        SETBITS(iArr, 2616);
        SETBITS(iArr, 2617);
        SETBITS(iArr, 2649, 2652);
        SETBITS(iArr, 2654);
        SETBITS(iArr, 2674, 2676);
        SETBITS(iArr, 2693, 2699);
        SETBITS(iArr, 2701);
        SETBITS(iArr, 2703, 2705);
        SETBITS(iArr, 2707, 2728);
        SETBITS(iArr, 2730, 2736);
        SETBITS(iArr, 2738, 2739);
        SETBITS(iArr, 2741, 2745);
        SETBITS(iArr, 2749);
        SETBITS(iArr, 2784);
        SETBITS(iArr, 2821, 2828);
        SETBITS(iArr, 2831);
        SETBITS(iArr, 2832);
        SETBITS(iArr, 2835, 2856);
        SETBITS(iArr, 2858, 2864);
        SETBITS(iArr, 2866);
        SETBITS(iArr, 2867);
        SETBITS(iArr, 2870, 2873);
        SETBITS(iArr, 2877);
        SETBITS(iArr, 2908);
        SETBITS(iArr, 2909);
        SETBITS(iArr, 2911, 2913);
        SETBITS(iArr, 2949, 2954);
        SETBITS(iArr, 2958, 2960);
        SETBITS(iArr, 2962, 2965);
        SETBITS(iArr, 2969, 2970);
        SETBITS(iArr, 2972);
        SETBITS(iArr, 2974);
        SETBITS(iArr, 2975);
        SETBITS(iArr, 2979);
        SETBITS(iArr, 2980);
        SETBITS(iArr, 2984, 2986);
        SETBITS(iArr, 2990, 2997);
        SETBITS(iArr, 2999, 3001);
        SETBITS(iArr, 3077, 3084);
        SETBITS(iArr, 3086, 3088);
        SETBITS(iArr, 3090, 3112);
        SETBITS(iArr, 3114, 3123);
        SETBITS(iArr, 3125, 3129);
        SETBITS(iArr, 3168);
        SETBITS(iArr, 3169);
        SETBITS(iArr, 3205, 3212);
        SETBITS(iArr, 3214, 3216);
        SETBITS(iArr, 3218, 3240);
        SETBITS(iArr, 3242, 3251);
        SETBITS(iArr, 3253, 3257);
        SETBITS(iArr, 3294);
        SETBITS(iArr, 3296);
        SETBITS(iArr, 3297);
        SETBITS(iArr, 3333, 3340);
        SETBITS(iArr, 3342, 3344);
        SETBITS(iArr, 3346, 3368);
        SETBITS(iArr, 3370, 3385);
        SETBITS(iArr, 3424);
        SETBITS(iArr, 3425);
        SETBITS(iArr, 3585, 3630);
        SETBITS(iArr, 3632);
        SETBITS(iArr, 3634);
        SETBITS(iArr, 3635);
        SETBITS(iArr, 3648, 3653);
        SETBITS(iArr, 3713);
        SETBITS(iArr, 3714);
        SETBITS(iArr, 3716);
        SETBITS(iArr, 3719);
        SETBITS(iArr, 3720);
        SETBITS(iArr, 3722);
        SETBITS(iArr, 3725);
        SETBITS(iArr, 3732, 3735);
        SETBITS(iArr, 3737, 3743);
        SETBITS(iArr, 3745, 3747);
        SETBITS(iArr, 3749);
        SETBITS(iArr, 3751);
        SETBITS(iArr, 3754);
        SETBITS(iArr, 3755);
        SETBITS(iArr, 3757);
        SETBITS(iArr, 3758);
        SETBITS(iArr, 3760);
        SETBITS(iArr, 3762);
        SETBITS(iArr, 3763);
        SETBITS(iArr, 3773);
        SETBITS(iArr, 3776, 3780);
        SETBITS(iArr, 3904, 3911);
        SETBITS(iArr, 3913, 3945);
        SETBITS(iArr, 4256, 4293);
        SETBITS(iArr, 4304, 4342);
        SETBITS(iArr, 4352);
        SETBITS(iArr, 4354, 4355);
        SETBITS(iArr, 4357, 4359);
        SETBITS(iArr, 4361);
        SETBITS(iArr, 4363, 4364);
        SETBITS(iArr, 4366, 4370);
        SETBITS(iArr, 4412);
        SETBITS(iArr, 4414);
        SETBITS(iArr, 4416);
        SETBITS(iArr, 4428);
        SETBITS(iArr, 4430);
        SETBITS(iArr, 4432);
        SETBITS(iArr, 4436, 4437);
        SETBITS(iArr, 4441);
        SETBITS(iArr, 4447, 4449);
        SETBITS(iArr, 4451);
        SETBITS(iArr, 4453);
        SETBITS(iArr, 4455);
        SETBITS(iArr, 4457);
        SETBITS(iArr, 4461, 4462);
        SETBITS(iArr, 4466, 4467);
        SETBITS(iArr, 4469);
        SETBITS(iArr, 4510);
        SETBITS(iArr, 4520);
        SETBITS(iArr, 4523);
        SETBITS(iArr, 4526, 4527);
        SETBITS(iArr, 4535, 4536);
        SETBITS(iArr, 4538);
        SETBITS(iArr, 4540, 4546);
        SETBITS(iArr, 4587);
        SETBITS(iArr, 4592);
        SETBITS(iArr, 4601);
        SETBITS(iArr, 7680, 7835);
        SETBITS(iArr, 7840, 7929);
        SETBITS(iArr, 7936, 7957);
        SETBITS(iArr, 7960, 7965);
        SETBITS(iArr, 7968, 8005);
        SETBITS(iArr, 8008, 8013);
        SETBITS(iArr, 8016, 8023);
        SETBITS(iArr, 8025);
        SETBITS(iArr, 8027);
        SETBITS(iArr, 8029);
        SETBITS(iArr, 8031, 8061);
        SETBITS(iArr, 8064, 8116);
        SETBITS(iArr, 8118, 8124);
        SETBITS(iArr, 8126);
        SETBITS(iArr, 8130, 8132);
        SETBITS(iArr, 8134, 8140);
        SETBITS(iArr, 8144, 8147);
        SETBITS(iArr, 8150, 8155);
        SETBITS(iArr, 8160, 8172);
        SETBITS(iArr, 8178, 8180);
        SETBITS(iArr, 8182, 8188);
        SETBITS(iArr, 8486);
        SETBITS(iArr, 8490, 8491);
        SETBITS(iArr, 8494);
        SETBITS(iArr, 8576, 8578);
        SETBITS(iArr, 12353, 12436);
        SETBITS(iArr, 12449, 12538);
        SETBITS(iArr, 12549, 12588);
        SETBITS(iArr, 12295);
        SETBITS(iArr, 12321, 12329);
        int[] iArr2 = new int[SIZE];
        sXml10Chars = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, SIZE);
        SETBITS(iArr2, 45, 46);
        SETBITS(iArr2, 48, 57);
        SETBITS(iArr2, 183);
        SETBITS(iArr2, 768, 837);
        SETBITS(iArr2, 864, 865);
        SETBITS(iArr2, 1155, 1158);
        SETBITS(iArr2, 1425, 1441);
        SETBITS(iArr2, 1443, 1465);
        SETBITS(iArr2, 1467, 1469);
        SETBITS(iArr2, 1471);
        SETBITS(iArr2, 1473, 1474);
        SETBITS(iArr2, 1476);
        SETBITS(iArr2, 1611, 1618);
        SETBITS(iArr2, 1648);
        SETBITS(iArr2, 1750, 1756);
        SETBITS(iArr2, 1757, 1759);
        SETBITS(iArr2, 1760, 1764);
        SETBITS(iArr2, 1767, 1768);
        SETBITS(iArr2, 1770, 1773);
        SETBITS(iArr2, 2305, 2307);
        SETBITS(iArr2, 2364);
        SETBITS(iArr2, 2366, 2380);
        SETBITS(iArr2, 2381);
        SETBITS(iArr2, 2385, 2388);
        SETBITS(iArr2, 2402);
        SETBITS(iArr2, 2403);
        SETBITS(iArr2, 2433, 2435);
        SETBITS(iArr2, 2492);
        SETBITS(iArr2, 2494);
        SETBITS(iArr2, 2495);
        SETBITS(iArr2, 2496, 2500);
        SETBITS(iArr2, 2503);
        SETBITS(iArr2, 2504);
        SETBITS(iArr2, 2507, 2509);
        SETBITS(iArr2, 2519);
        SETBITS(iArr2, 2530);
        SETBITS(iArr2, 2531);
        SETBITS(iArr2, 2562);
        SETBITS(iArr2, 2620);
        SETBITS(iArr2, 2622);
        SETBITS(iArr2, 2623);
        SETBITS(iArr2, 2624, 2626);
        SETBITS(iArr2, 2631);
        SETBITS(iArr2, 2632);
        SETBITS(iArr2, 2635, 2637);
        SETBITS(iArr2, 2672);
        SETBITS(iArr2, 2673);
        SETBITS(iArr2, 2689, 2691);
        SETBITS(iArr2, 2748);
        SETBITS(iArr2, 2750, 2757);
        SETBITS(iArr2, 2759, 2761);
        SETBITS(iArr2, 2763, 2765);
        SETBITS(iArr2, 2817, 2819);
        SETBITS(iArr2, 2876);
        SETBITS(iArr2, 2878, 2883);
        SETBITS(iArr2, 2887);
        SETBITS(iArr2, 2888);
        SETBITS(iArr2, 2891, 2893);
        SETBITS(iArr2, 2902);
        SETBITS(iArr2, 2903);
        SETBITS(iArr2, 2946);
        SETBITS(iArr2, 2947);
        SETBITS(iArr2, 3006, 3010);
        SETBITS(iArr2, 3014, 3016);
        SETBITS(iArr2, 3018, 3021);
        SETBITS(iArr2, 3031);
        SETBITS(iArr2, 3073, 3075);
        SETBITS(iArr2, 3134, 3140);
        SETBITS(iArr2, 3142, 3144);
        SETBITS(iArr2, 3146, 3149);
        SETBITS(iArr2, 3157, 3158);
        SETBITS(iArr2, 3202, 3203);
        SETBITS(iArr2, 3262, 3268);
        SETBITS(iArr2, 3270, 3272);
        SETBITS(iArr2, 3274, 3277);
        SETBITS(iArr2, 3285, 3286);
        SETBITS(iArr2, 3330, 3331);
        SETBITS(iArr2, 3390, 3395);
        SETBITS(iArr2, 3398, 3400);
        SETBITS(iArr2, 3402, 3405);
        SETBITS(iArr2, 3415);
        SETBITS(iArr2, 3633);
        SETBITS(iArr2, 3636, 3642);
        SETBITS(iArr2, 3655, 3662);
        SETBITS(iArr2, 3761);
        SETBITS(iArr2, 3764, 3769);
        SETBITS(iArr2, 3771, 3772);
        SETBITS(iArr2, 3784, 3789);
        SETBITS(iArr2, 3864, 3865);
        SETBITS(iArr2, 3893);
        SETBITS(iArr2, 3895);
        SETBITS(iArr2, 3897);
        SETBITS(iArr2, 3902);
        SETBITS(iArr2, 3903);
        SETBITS(iArr2, 3953, 3972);
        SETBITS(iArr2, 3974, 3979);
        SETBITS(iArr2, 3984, 3989);
        SETBITS(iArr2, 3991);
        SETBITS(iArr2, 3993, 4013);
        SETBITS(iArr2, 4017, 4023);
        SETBITS(iArr2, 4025);
        SETBITS(iArr2, 8400, 8412);
        SETBITS(iArr2, 8417);
        SETBITS(iArr2, 12330, 12335);
        SETBITS(iArr2, 12441);
        SETBITS(iArr2, 12442);
        SETBITS(iArr2, 1632, 1641);
        SETBITS(iArr2, 1776, 1785);
        SETBITS(iArr2, 2406, 2415);
        SETBITS(iArr2, 2534, 2543);
        SETBITS(iArr2, 2662, 2671);
        SETBITS(iArr2, 2790, 2799);
        SETBITS(iArr2, 2918, 2927);
        SETBITS(iArr2, 3047, 3055);
        SETBITS(iArr2, 3174, 3183);
        SETBITS(iArr2, 3302, 3311);
        SETBITS(iArr2, 3430, 3439);
        SETBITS(iArr2, 3664, 3673);
        SETBITS(iArr2, 3792, 3801);
        SETBITS(iArr2, 3872, 3881);
        SETBITS(iArr2, 183);
        SETBITS(iArr2, 720);
        SETBITS(iArr2, 721);
        SETBITS(iArr2, 903);
        SETBITS(iArr2, 1600);
        SETBITS(iArr2, 3654);
        SETBITS(iArr2, 3782);
        SETBITS(iArr2, 12293);
        SETBITS(iArr2, 12337, 12341);
        SETBITS(iArr2, 12445, 12446);
        SETBITS(iArr2, 12540, 12542);
    }

    private XmlChars() {
    }

    public static final boolean is10NameStartChar(int i) {
        if (i <= 12588) {
            return ((1 << (i & 31)) & sXml10StartChars[i >> 5]) != 0;
        }
        if (i < 44032) {
            return i >= 19968 && i <= 40869;
        }
        return i <= 55203;
    }

    public static final boolean is10NameChar(int i) {
        if (i <= 12588) {
            return ((1 << (i & 31)) & sXml10Chars[i >> 5]) != 0;
        }
        if (i < 44032) {
            return i >= 19968 && i <= 40869;
        }
        return i <= 55203;
    }

    public static String getCharDesc(int i) {
        char c = (char) i;
        if (Character.isISOControl(c)) {
            return "(CTRL-CHAR, code " + i + ")";
        }
        if (i > 255) {
            return "'" + c + "' (code " + i + " / 0x" + Integer.toHexString(i) + ")";
        }
        return "'" + c + "' (code " + i + ")";
    }

    private static void SETBITS(int[] iArr, int i, int i2) {
        int i3 = i & 31;
        int i4 = i2 & 31;
        int i5 = i >> 5;
        int i6 = i2 >> 5;
        if (i5 == i6) {
            while (i3 <= i4) {
                iArr[i5] = iArr[i5] | (1 << i3);
                i3++;
            }
            return;
        }
        while (i3 <= 31) {
            iArr[i5] = iArr[i5] | (1 << i3);
            i3++;
        }
        while (true) {
            i5++;
            if (i5 >= i6) {
                break;
            } else {
                iArr[i5] = -1;
            }
        }
        for (int i7 = 0; i7 <= i4; i7++) {
            iArr[i6] = iArr[i6] | (1 << i7);
        }
    }

    private static void SETBITS(int[] iArr, int i) {
        int i2 = i >> 5;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }
}
