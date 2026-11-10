package org.apache.poi.hpsf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import org.apache.poi.util.CodePageUtil;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.Removal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class VariantSupport extends Variant {
    private static boolean logUnsupportedTypes;
    private static List<Long> unsupportedMessage;
    public static final int[] SUPPORTED_TYPES = {0, 2, 3, 20, 5, 64, 30, 31, 71, 11};
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) VariantSupport.class);
    private static final byte[] paddingBytes = new byte[3];

    public static void setLogUnsupportedTypes(boolean z) {
        logUnsupportedTypes = z;
    }

    public static boolean isLogUnsupportedTypes() {
        return logUnsupportedTypes;
    }

    protected static void writeUnsupportedTypeMessage(UnsupportedVariantTypeException unsupportedVariantTypeException) {
        if (isLogUnsupportedTypes()) {
            if (unsupportedMessage == null) {
                unsupportedMessage = new LinkedList();
            }
            Long lValueOf = Long.valueOf(unsupportedVariantTypeException.getVariantType());
            if (unsupportedMessage.contains(lValueOf)) {
                return;
            }
            logger.log(7, unsupportedVariantTypeException.getMessage());
            unsupportedMessage.add(lValueOf);
        }
    }

    public boolean isSupportedType(int i) {
        for (int i2 : SUPPORTED_TYPES) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    public static Object read(byte[] bArr, int i, int i2, long j, int i3) throws ReadingNotSupportedException, UnsupportedEncodingException {
        return read(new LittleEndianByteArrayInputStream(bArr, i), i2, j, i3);
    }

    public static Object read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream, int i, long j, int i2) throws ReadingNotSupportedException, UnsupportedEncodingException {
        int readIndex = littleEndianByteArrayInputStream.getReadIndex();
        int i3 = (int) j;
        TypedPropertyValue typedPropertyValue = new TypedPropertyValue(i3, null);
        try {
            typedPropertyValue.readValue(littleEndianByteArrayInputStream);
            if (i3 != 0) {
                if (i3 == 11) {
                    return Boolean.valueOf(((VariantBool) typedPropertyValue.getValue()).getValue());
                }
                if (i3 == 64) {
                    return ((Filetime) typedPropertyValue.getValue()).getJavaValue();
                }
                if (i3 == 71) {
                    return ((ClipboardData) typedPropertyValue.getValue()).toByteArray();
                }
                if (i3 == 2) {
                    return Integer.valueOf(((Short) typedPropertyValue.getValue()).intValue());
                }
                if (i3 != 3 && i3 != 4 && i3 != 5) {
                    if (i3 == 30) {
                        return ((CodePageString) typedPropertyValue.getValue()).getJavaValue(i2);
                    }
                    if (i3 == 31) {
                        return ((UnicodeString) typedPropertyValue.getValue()).toJavaString();
                    }
                    switch (i3) {
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                            break;
                        default:
                            int readIndex2 = littleEndianByteArrayInputStream.getReadIndex() - readIndex;
                            littleEndianByteArrayInputStream.setReadIndex(readIndex);
                            byte[] bArr = new byte[readIndex2];
                            littleEndianByteArrayInputStream.readFully(bArr, 0, readIndex2);
                            throw new ReadingNotSupportedException(j, bArr);
                    }
                }
            }
            return typedPropertyValue.getValue();
        } catch (UnsupportedOperationException unused) {
            int iMin = Math.min(i, littleEndianByteArrayInputStream.available());
            byte[] bArr2 = new byte[iMin];
            littleEndianByteArrayInputStream.readFully(bArr2, 0, iMin);
            throw new ReadingNotSupportedException(j, bArr2);
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static String codepageToEncoding(int i) throws UnsupportedEncodingException {
        return CodePageUtil.codepageToEncoding(i);
    }

    /* JADX WARN: Code duplicated, block: B:85:0x014d  */
    /* JADX WARN: Code duplicated, block: B:87:0x0151  */
    /* JADX WARN: Code duplicated, block: B:88:0x0163  */
    public static int write(OutputStream outputStream, long j, Object obj, int i) throws IOException, WritingNotSupportedException {
        int length;
        int i2 = (int) j;
        if (i2 == 0) {
            LittleEndian.putUInt(0L, outputStream);
        } else {
            length = 2;
            if (i2 != 11) {
                if (i2 == 64) {
                    length = (obj instanceof java.util.Date ? new Filetime((java.util.Date) obj) : new Filetime()).write(outputStream);
                } else if (i2 != 71) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                if (i2 != 5) {
                                    if (i2 != 30) {
                                        if (i2 == 31) {
                                            if (obj instanceof String) {
                                                UnicodeString unicodeString = new UnicodeString();
                                                unicodeString.setJavaValue((String) obj);
                                                length = unicodeString.write(outputStream);
                                            } else {
                                                length = -1;
                                            }
                                        } else {
                                            switch (i2) {
                                                case 18:
                                                    if (obj instanceof Number) {
                                                        LittleEndian.putUShort(((Number) obj).intValue(), outputStream);
                                                    } else {
                                                        length = -1;
                                                    }
                                                    break;
                                                case 19:
                                                    if (obj instanceof Number) {
                                                        LittleEndian.putUInt(((Number) obj).longValue(), outputStream);
                                                    } else {
                                                        length = -1;
                                                    }
                                                    break;
                                                case 20:
                                                    if (obj instanceof Number) {
                                                        LittleEndian.putLong(((Number) obj).longValue(), outputStream);
                                                        length = 8;
                                                    } else {
                                                        length = -1;
                                                    }
                                                    break;
                                                case 21:
                                                    if (obj instanceof Number) {
                                                        BigInteger bigIntegerValueOf = obj instanceof BigInteger ? (BigInteger) obj : BigInteger.valueOf(((Number) obj).longValue());
                                                        if (bigIntegerValueOf.bitLength() > 64) {
                                                            throw new WritingNotSupportedException(j, obj);
                                                        }
                                                        byte[] byteArray = bigIntegerValueOf.toByteArray();
                                                        byte[] bArr = new byte[8];
                                                        int length2 = byteArray.length;
                                                        for (byte b : byteArray) {
                                                            if (length2 <= 8) {
                                                                bArr[length2 - 1] = b;
                                                            }
                                                            length2--;
                                                        }
                                                        outputStream.write(bArr);
                                                        length = 8;
                                                    } else {
                                                        length = -1;
                                                    }
                                                    break;
                                                default:
                                                    length = -1;
                                                    break;
                                            }
                                        }
                                    } else if (obj instanceof String) {
                                        CodePageString codePageString = new CodePageString();
                                        codePageString.setJavaValue((String) obj, i);
                                        length = codePageString.write(outputStream);
                                    } else {
                                        length = -1;
                                    }
                                } else if (obj instanceof Number) {
                                    LittleEndian.putDouble(((Number) obj).doubleValue(), outputStream);
                                    length = 8;
                                } else {
                                    length = -1;
                                }
                            } else if (obj instanceof Number) {
                                LittleEndian.putInt(Float.floatToIntBits(((Number) obj).floatValue()), outputStream);
                            } else {
                                length = -1;
                            }
                        } else if (obj instanceof Number) {
                            LittleEndian.putInt(((Number) obj).intValue(), outputStream);
                        } else {
                            length = -1;
                        }
                    } else if (obj instanceof Number) {
                        LittleEndian.putShort(outputStream, ((Number) obj).shortValue());
                    } else {
                        length = -1;
                    }
                } else if (obj instanceof byte[]) {
                    byte[] bArr2 = (byte[]) obj;
                    outputStream.write(bArr2);
                    length = bArr2.length;
                } else {
                    length = -1;
                }
            } else if (obj instanceof Boolean) {
                int i3 = ((Boolean) obj).booleanValue() ? 255 : 0;
                outputStream.write(i3);
                outputStream.write(i3);
            } else {
                length = -1;
            }
            if (length == -1) {
                if (obj instanceof byte[]) {
                    byte[] bArr3 = (byte[]) obj;
                    outputStream.write(bArr3);
                    length = bArr3.length;
                    writeUnsupportedTypeMessage(new WritingNotSupportedException(j, obj));
                } else {
                    throw new WritingNotSupportedException(j, obj);
                }
            }
            int i4 = (4 - (length & 3)) & 3;
            outputStream.write(paddingBytes, 0, i4);
            return length + i4;
        }
        length = 4;
        if (length == -1) {
            if (obj instanceof byte[]) {
                byte[] bArr4 = (byte[]) obj;
                outputStream.write(bArr4);
                length = bArr4.length;
                writeUnsupportedTypeMessage(new WritingNotSupportedException(j, obj));
            } else {
                throw new WritingNotSupportedException(j, obj);
            }
        }
        int i5 = (4 - (length & 3)) & 3;
        outputStream.write(paddingBytes, 0, i5);
        return length + i5;
    }
}
