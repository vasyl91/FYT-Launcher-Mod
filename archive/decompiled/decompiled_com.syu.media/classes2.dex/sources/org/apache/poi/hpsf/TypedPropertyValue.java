package org.apache.poi.hpsf;

import java.math.BigInteger;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
class TypedPropertyValue {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) TypedPropertyValue.class);
    private int _type;
    private Object _value;

    TypedPropertyValue(int i, Object obj) {
        this._type = i;
        this._value = obj;
    }

    Object getValue() {
        return this._value;
    }

    void read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
        this._type = littleEndianByteArrayInputStream.readShort();
        short s = littleEndianByteArrayInputStream.readShort();
        if (s != 0) {
            LOG.log(5, "TypedPropertyValue padding at offset " + littleEndianByteArrayInputStream.getReadIndex() + " MUST be 0, but it's value is " + ((int) s));
        }
        readValue(littleEndianByteArrayInputStream);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:49:0x0130  */
    void readValue(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
        int i = this._type;
        if (i != 10) {
            if (i != 11) {
                if (i != 30) {
                    if (i == 31) {
                        UnicodeString unicodeString = new UnicodeString();
                        unicodeString.read(littleEndianByteArrayInputStream);
                        this._value = unicodeString;
                        return;
                    }
                    if (i != 4126 && i != 4127 && i != 4167 && i != 4168) {
                        switch (i) {
                            case 0:
                            case 1:
                                this._value = null;
                                return;
                            case 2:
                                this._value = Short.valueOf(littleEndianByteArrayInputStream.readShort());
                                return;
                            case 3:
                                this._value = Integer.valueOf(littleEndianByteArrayInputStream.readInt());
                                return;
                            case 4:
                                this._value = Float.valueOf(Float.intBitsToFloat(littleEndianByteArrayInputStream.readInt()));
                                return;
                            case 5:
                                this._value = Double.valueOf(littleEndianByteArrayInputStream.readDouble());
                                return;
                            case 6:
                                Currency currency = new Currency();
                                currency.read(littleEndianByteArrayInputStream);
                                this._value = currency;
                                return;
                            case 7:
                                Date date = new Date();
                                date.read(littleEndianByteArrayInputStream);
                                this._value = date;
                                return;
                            case 8:
                                break;
                            default:
                                switch (i) {
                                    case 14:
                                        Decimal decimal = new Decimal();
                                        decimal.read(littleEndianByteArrayInputStream);
                                        this._value = decimal;
                                        return;
                                    case 64:
                                        Filetime filetime = new Filetime();
                                        filetime.read(littleEndianByteArrayInputStream);
                                        this._value = filetime;
                                        return;
                                    case 65:
                                    case 70:
                                        Blob blob = new Blob();
                                        blob.read(littleEndianByteArrayInputStream);
                                        this._value = blob;
                                        return;
                                    case 66:
                                    case 67:
                                    case 68:
                                    case 69:
                                        IndirectPropertyName indirectPropertyName = new IndirectPropertyName();
                                        indirectPropertyName.read(littleEndianByteArrayInputStream);
                                        this._value = indirectPropertyName;
                                        return;
                                    case 71:
                                        ClipboardData clipboardData = new ClipboardData();
                                        clipboardData.read(littleEndianByteArrayInputStream);
                                        this._value = clipboardData;
                                        return;
                                    case 72:
                                        new GUID().read(littleEndianByteArrayInputStream);
                                        this._value = littleEndianByteArrayInputStream;
                                        return;
                                    case 73:
                                        VersionedStream versionedStream = new VersionedStream();
                                        versionedStream.read(littleEndianByteArrayInputStream);
                                        this._value = versionedStream;
                                        return;
                                    case 4160:
                                        break;
                                    case 8194:
                                    case 8195:
                                    case 8196:
                                    case 8197:
                                    case 8198:
                                    case 8199:
                                    case 8200:
                                    case 8202:
                                    case 8203:
                                    case 8204:
                                    case 8206:
                                    case 8208:
                                    case 8209:
                                    case 8210:
                                    case 8211:
                                    case 8214:
                                    case 8215:
                                        Array array = new Array();
                                        array.read(littleEndianByteArrayInputStream);
                                        this._value = array;
                                        return;
                                    default:
                                        switch (i) {
                                            case 16:
                                                this._value = Byte.valueOf(littleEndianByteArrayInputStream.readByte());
                                                return;
                                            case 17:
                                                this._value = Integer.valueOf(littleEndianByteArrayInputStream.readUByte());
                                                return;
                                            case 18:
                                                this._value = Integer.valueOf(littleEndianByteArrayInputStream.readUShort());
                                                return;
                                            case 19:
                                            case 23:
                                                break;
                                            case 20:
                                                this._value = Long.valueOf(littleEndianByteArrayInputStream.readLong());
                                                return;
                                            case 21:
                                                byte[] bArr = new byte[8];
                                                littleEndianByteArrayInputStream.readFully(bArr);
                                                byte[] bArr2 = new byte[9];
                                                int i2 = 8;
                                                for (int i3 = 0; i3 < 8; i3++) {
                                                    byte b = bArr[i3];
                                                    if (i2 <= 8) {
                                                        bArr2[i2] = b;
                                                    }
                                                    i2--;
                                                }
                                                this._value = new BigInteger(bArr2);
                                                return;
                                            case 22:
                                                this._value = Integer.valueOf(littleEndianByteArrayInputStream.readInt());
                                                return;
                                            default:
                                                switch (i) {
                                                    case 4098:
                                                    case 4099:
                                                    case 4100:
                                                    case 4101:
                                                    case 4102:
                                                    case 4103:
                                                    case 4104:
                                                        break;
                                                    default:
                                                        switch (i) {
                                                            case 4106:
                                                            case 4107:
                                                            case 4108:
                                                                break;
                                                            default:
                                                                switch (i) {
                                                                    case 4112:
                                                                    case 4113:
                                                                    case 4114:
                                                                    case 4115:
                                                                    case 4116:
                                                                    case 4117:
                                                                        break;
                                                                    default:
                                                                        throw new UnsupportedOperationException("Unknown (possibly, incorrect) TypedPropertyValue type: " + this._type);
                                                                }
                                                                break;
                                                        }
                                                        break;
                                                }
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                    }
                    Vector vector = new Vector((short) (this._type & 4095));
                    vector.read(littleEndianByteArrayInputStream);
                    this._value = vector;
                    return;
                }
                CodePageString codePageString = new CodePageString();
                codePageString.read(littleEndianByteArrayInputStream);
                this._value = codePageString;
                return;
            }
            VariantBool variantBool = new VariantBool();
            variantBool.read(littleEndianByteArrayInputStream);
            this._value = variantBool;
            return;
        }
        this._value = Long.valueOf(littleEndianByteArrayInputStream.readUInt());
    }

    static void skipPadding(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
        int readIndex = (4 - (littleEndianByteArrayInputStream.getReadIndex() & 3)) & 3;
        for (int i = 0; i < readIndex; i++) {
            littleEndianByteArrayInputStream.mark(1);
            int i2 = littleEndianByteArrayInputStream.read();
            if (i2 == -1 || i2 != 0) {
                littleEndianByteArrayInputStream.reset();
                return;
            }
        }
    }
}
