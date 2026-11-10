package org.apache.poi.util;

import java.io.IOException;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import kotlin.UByte;
import module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public class LittleEndianCP950Reader extends Reader {
    private static final POILogger LOGGER = POILogFactory.getLogger((Class<?>) LittleEndianCP950Reader.class);
    private static final char UNMAPPABLE = '?';
    private static final char range1High = 36350;
    private static final char range1Low = 33088;
    private static final char range2High = 41214;
    private static final char range2Low = 36416;
    private static final char range3High = 51454;
    private static final char range3Low = 50849;
    private static final char range4High = 65278;
    private static final char range4Low = 64064;
    private final CharBuffer charBuffer;
    int cnt;
    private final byte[] data;
    private final CharsetDecoder decoder;
    private final ByteBuffer doubleByteBuffer;
    private int leading;
    private final int length;
    private int offset;
    private final int startOffset;
    private int trailing;

    private int handleRange1(int i, int i2) {
        return ((i - 129) * 157) + 61112 + (i2 < 128 ? i2 - 64 : i2 - 98);
    }

    private int handleRange2(int i, int i2) {
        return ((i - 142) * 157) + 58129 + (i2 < 128 ? i2 - 64 : i2 - 98);
    }

    private int handleRange3(int i, int i2) {
        return ((i - 198) * 157) + 63090 + (i2 < 128 ? i2 - 64 : i2 - 98);
    }

    private int handleRange4(int i, int i2) {
        return ((i - 250) * 157) + FinalCanbus.CAR_E000_ATS + (i2 < 128 ? i2 - 64 : i2 - 98);
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public LittleEndianCP950Reader(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public LittleEndianCP950Reader(byte[] bArr, int i, int i2) {
        this.doubleByteBuffer = ByteBuffer.allocate(2);
        this.charBuffer = CharBuffer.allocate(2);
        this.decoder = StringUtil.BIG5.newDecoder();
        this.cnt = 0;
        this.data = bArr;
        this.startOffset = i;
        this.offset = i;
        this.length = i2;
    }

    @Override // java.io.Reader
    public int read() {
        int i = this.offset;
        int i2 = i + 1;
        byte[] bArr = this.data;
        if (i2 > bArr.length || i - this.startOffset > this.length) {
            return -1;
        }
        int i3 = i + 1;
        this.trailing = bArr[i] & UByte.MAX_VALUE;
        this.offset = i3 + 1;
        this.leading = bArr[i3] & UByte.MAX_VALUE;
        this.decoder.reset();
        int i4 = this.leading;
        if (i4 < 129) {
            return this.trailing;
        }
        if (i4 == 249) {
            return handleF9(this.trailing);
        }
        int i5 = this.trailing;
        int i6 = (i4 << 8) + i5;
        if (i6 >= 33088 && i6 <= 36350) {
            return handleRange1(i4, i5);
        }
        if (i6 >= 36416 && i6 <= 41214) {
            return handleRange2(i4, i5);
        }
        if (i6 >= 50849 && i6 <= 51454) {
            return handleRange3(i4, i5);
        }
        if (i6 >= 64064 && i6 <= 65278) {
            return handleRange4(i4, i5);
        }
        this.charBuffer.clear();
        this.doubleByteBuffer.clear();
        this.doubleByteBuffer.put((byte) this.leading);
        this.doubleByteBuffer.put((byte) this.trailing);
        this.doubleByteBuffer.flip();
        this.decoder.decode(this.doubleByteBuffer, this.charBuffer, true);
        this.charBuffer.flip();
        if (this.charBuffer.length() == 0) {
            LOGGER.log(5, "couldn't create char for: " + Integer.toString(this.leading & 255, 16) + " " + Integer.toString(this.trailing & 255, 16));
            return 63;
        }
        return Character.codePointAt(this.charBuffer, 0);
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        for (int i3 = i; i3 < i + i2; i3++) {
            int i4 = read();
            if (i4 == -1) {
                return i3 - i;
            }
            cArr[i3] = (char) i4;
        }
        return i2;
    }

    private int handleF9(int i) {
        switch (i) {
            case 64:
                return 32408;
            case 65:
                return 32411;
            case 66:
                return 32409;
            case 67:
                return 33248;
            case 68:
                return 33249;
            case 69:
                return 34374;
            case 70:
                return 34375;
            case 71:
                return 34376;
            case 72:
                return 35193;
            case 73:
                return 35194;
            case 74:
                return 35196;
            case 75:
                return 35195;
            case 76:
                return 35327;
            case 77:
                return 35736;
            case 78:
                return 35737;
            case 79:
                return 36517;
            case 80:
                return 36516;
            case 81:
                return 36515;
            case 82:
                return 37998;
            case 83:
                return 37997;
            case 84:
                return 37999;
            case 85:
                return 38001;
            case 86:
                return 38003;
            case 87:
                return 38729;
            case 88:
                return 39026;
            case 89:
                return 39263;
            case 90:
                return 40040;
            case 91:
                return 40046;
            case 92:
                return 40045;
            case 93:
                return 40459;
            case 94:
                return 40461;
            case 95:
                return 40464;
            case 96:
                return 40463;
            case 97:
                return 40466;
            case 98:
                return 40465;
            case 99:
                return 40609;
            case 100:
                return 40693;
            case 101:
                return 40713;
            case 102:
                return 40775;
            case 103:
                return 40824;
            case 104:
                return 40827;
            case 105:
                return 40826;
            case 106:
                return 40825;
            case 107:
                return 22302;
            case 108:
                return 28774;
            case 109:
                return 31855;
            case 110:
                return 34876;
            case 111:
                return 36274;
            case 112:
                return 36518;
            case 113:
                return 37315;
            case 114:
                return 38004;
            case 115:
                return 38008;
            case 116:
                return 38006;
            case 117:
                return 38005;
            case 118:
                return 39520;
            case 119:
                return 40052;
            case 120:
                return 40051;
            case 121:
                return 40049;
            case 122:
                return 40053;
            case 123:
                return 40468;
            case 124:
                return 40467;
            case 125:
                return 40694;
            case 126:
                return 40714;
            default:
                switch (i) {
                    case 161:
                        return 40868;
                    case 162:
                        return 28776;
                    case 163:
                        return 28773;
                    case 164:
                        return 31991;
                    case 165:
                        return 34410;
                    case 166:
                        return 34878;
                    case 167:
                        return 34877;
                    case 168:
                        return 34879;
                    case 169:
                        return 35742;
                    case 170:
                        return 35996;
                    case 171:
                        return 36521;
                    case 172:
                        return 36553;
                    case 173:
                        return 38731;
                    case 174:
                        return 39027;
                    case 175:
                        return 39028;
                    case 176:
                        return 39116;
                    case 177:
                        return 39265;
                    case 178:
                        return 39339;
                    case 179:
                        return 39524;
                    case 180:
                        return 39526;
                    case 181:
                        return 39527;
                    case 182:
                        return 39716;
                    case 183:
                        return 40469;
                    case 184:
                        return 40471;
                    case 185:
                        return 40776;
                    case 186:
                        return 25095;
                    case 187:
                        return 27422;
                    case 188:
                        return 29223;
                    case 189:
                        return 34380;
                    case 190:
                        return 36520;
                    case 191:
                        return 38018;
                    case 192:
                        return 38016;
                    case 193:
                        return 38017;
                    case 194:
                        return 39529;
                    case 195:
                        return 39528;
                    case 196:
                        return 39726;
                    case 197:
                        return 40473;
                    case 198:
                        return 29225;
                    case 199:
                        return 34379;
                    case 200:
                        return 35743;
                    case 201:
                        return 38019;
                    case 202:
                        return 40057;
                    case FinalCanbus.CAR_RZC_XP1_AoDeSai /* 203 */:
                        return 40631;
                    case FinalCanbus.CAR_MSN_RZC_PSA301 /* 204 */:
                        return 30325;
                    case FinalCanbus.CAR_FYTA_JIAO /* 205 */:
                        return 39531;
                    case FinalCanbus.CAR_WC1_Benz /* 206 */:
                        return 40058;
                    case FinalCanbus.CAR_SBD_WC1_ChangChengC30 /* 207 */:
                        return 40477;
                    case FinalCanbus.CAR_DJ1_JiLiGX9 /* 208 */:
                        return 28777;
                    case FinalCanbus.CAR_FYT_ACCORD8 /* 209 */:
                        return 28778;
                    case FinalCanbus.CAR_MSL_XP1_JUNYUE /* 210 */:
                        return 40612;
                    case FinalCanbus.CAR_RZC_XP1_ChangChengC30 /* 211 */:
                        return 40830;
                    case FinalCanbus.CAR_XP1_BenChiB200 /* 212 */:
                        return 40777;
                    case FinalCanbus.CAR_FYTA_ChangChengC30 /* 213 */:
                        return 40856;
                    case FinalCanbus.CAR_RZC_XP1_14Prado_L /* 214 */:
                        return 30849;
                    case FinalCanbus.CAR_RZC4_PSA3008 /* 215 */:
                        return 37561;
                    case FinalCanbus.CAR_RZC_XP1_BeiQiShenBaoD60 /* 216 */:
                        return 35023;
                    case FinalCanbus.CAR_RZC4_PSA13_408 /* 217 */:
                        return 22715;
                    case FinalCanbus.CAR_XBS_XP1_13MengDiOu /* 218 */:
                        return 24658;
                    case FinalCanbus.CAR_DJ_ChangAnYueXiangV7 /* 219 */:
                        return 31911;
                    case FinalCanbus.CAR_DJ_DongFengFengShenAX7 /* 220 */:
                        return 23290;
                    case FinalCanbus.CAR_RZC4_PSA2008 /* 221 */:
                        return 9556;
                    case FinalCanbus.CAR_WC2_EU_Focus /* 222 */:
                        return 9574;
                    case FinalCanbus.CAR_WC1_MENGDIOU2011 /* 223 */:
                        return 9559;
                    case FinalCanbus.CAR_DC_WC1_15YIDONG /* 224 */:
                        return 9568;
                    case FinalCanbus.CAR_XP1_SanLinPajero /* 225 */:
                        return 9580;
                    case FinalCanbus.CAR_FYTA_ChangAnYueXiangV7 /* 226 */:
                        return 9571;
                    case FinalCanbus.CAR_RZC_XP1_ChangAnYueXiangV7 /* 227 */:
                        return 9562;
                    case FinalCanbus.CAR_SBD_WC1_ChangAnYueXiangV7 /* 228 */:
                        return 9577;
                    case FinalCanbus.CAR_CYT_FYTA_DongNanV5 /* 229 */:
                        return 9565;
                    case FinalCanbus.CAR_WC1_BMWX1 /* 230 */:
                        return 9554;
                    case FinalCanbus.CAR_DJ_MENGDIOU2013 /* 231 */:
                        return 9572;
                    case FinalCanbus.CAR_XP2_OPEL /* 232 */:
                        return 9557;
                    case 233:
                        return 9566;
                    case FinalCanbus.CAR_RZC4_DS5 /* 234 */:
                        return 9578;
                    case FinalCanbus.CAR_RZC4_DS5LS /* 235 */:
                        return 9569;
                    case FinalCanbus.CAR_WC2_SAIL3 /* 236 */:
                        return 9560;
                    case FinalCanbus.CAR_RZC_XP1_HAIMAM5 /* 237 */:
                        return 9575;
                    case FinalCanbus.CAR_RZC4_C5 /* 238 */:
                        return 9563;
                    case 239:
                        return 9555;
                    case 240:
                        return 9573;
                    case FinalCanbus.CAR_WC1_RUIJIE /* 241 */:
                        return 9558;
                    case FinalCanbus.CAR_CYT_XP1_BiaoZhi408 /* 242 */:
                        return 9567;
                    case FinalCanbus.CAR_FYT_WC1_HAIMAM5 /* 243 */:
                        return 9579;
                    case FinalCanbus.CAR_RZC_XP1_HavalH2 /* 244 */:
                        return 9570;
                    case FinalCanbus.CAR_DJ_BydL3 /* 245 */:
                        return 9561;
                    case FinalCanbus.CAR_WC2_14BaoJun730 /* 246 */:
                        return 9576;
                    case FinalCanbus.CAR_WC2_XueTieLongC3XR /* 247 */:
                        return 9564;
                    case FinalCanbus.CAR_RZC2_ZhongHuaV5 /* 248 */:
                        return 9553;
                    case FinalCanbus.CAR_RZC3_SoNaTa9 /* 249 */:
                        return 9552;
                    case FinalCanbus.CAR_FYT_XP1_FengShenAX7 /* 250 */:
                        return 9581;
                    case FinalCanbus.CAR_XP_QIYA_SoLanTuo_L /* 251 */:
                        return 9582;
                    case FinalCanbus.CAR_WC2_PSAALL_0 /* 252 */:
                        return 9584;
                    case FinalCanbus.CAR_XP1_15YingLang /* 253 */:
                        return 9583;
                    case FinalCanbus.CAR_WC2_15YingLang /* 254 */:
                        return 9619;
                    default:
                        LOGGER.log(5, "couldn't create char for: f9 " + Integer.toString(i & 255, 16));
                        return 63;
                }
        }
    }
}
