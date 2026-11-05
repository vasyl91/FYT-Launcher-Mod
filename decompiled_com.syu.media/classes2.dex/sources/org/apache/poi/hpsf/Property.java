package org.apache.poi.hpsf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.xml.bind.DatatypeConverter;
import org.apache.poi.hpsf.wellknown.PropertyIDMap;
import org.apache.poi.util.CodePageUtil;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Property {
    public static final int DEFAULT_CODEPAGE = 1252;
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) Property.class);
    private long id;
    private long type;
    private Object value;

    private boolean typesAreEqual(long j, long j2) {
        return j == j2 || (j == 30 && j2 == 31) || (j2 == 30 && j == 31);
    }

    public Property() {
    }

    public Property(Property property) {
        this(property.id, property.type, property.value);
    }

    public Property(long j, long j2, Object obj) {
        this.id = j;
        this.type = j2;
        this.value = obj;
    }

    public Property(long j, byte[] bArr, long j2, int i, int i2) throws UnsupportedEncodingException {
        this.id = j;
        if (j == 0) {
            throw new UnsupportedEncodingException("Dictionary not allowed here");
        }
        int i3 = (int) j2;
        long uInt = LittleEndian.getUInt(bArr, i3);
        this.type = uInt;
        try {
            this.value = VariantSupport.read(bArr, i3 + 4, i, (int) uInt, i2);
        } catch (UnsupportedVariantTypeException e) {
            VariantSupport.writeUnsupportedTypeMessage(e);
            this.value = e.getValue();
        }
    }

    public Property(long j, LittleEndianByteArrayInputStream littleEndianByteArrayInputStream, int i, int i2) throws UnsupportedEncodingException {
        this.id = j;
        if (j == 0) {
            throw new UnsupportedEncodingException("Dictionary not allowed here");
        }
        long uInt = littleEndianByteArrayInputStream.readUInt();
        this.type = uInt;
        try {
            this.value = VariantSupport.read(littleEndianByteArrayInputStream, i, (int) uInt, i2);
        } catch (UnsupportedVariantTypeException e) {
            VariantSupport.writeUnsupportedTypeMessage(e);
            this.value = e.getValue();
        }
    }

    public long getID() {
        return this.id;
    }

    public void setID(long j) {
        this.id = j;
    }

    public long getType() {
        return this.type;
    }

    public void setType(long j) {
        this.type = j;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }

    protected int getSize(int i) throws WritingNotSupportedException {
        int variantLength = Variant.getVariantLength(this.type);
        if (variantLength < 0) {
            long j = this.type;
            if (j != 0) {
                if (variantLength == -2) {
                    throw new WritingNotSupportedException(this.type, null);
                }
                if (j == 30 || j == 31) {
                    try {
                        int iWrite = write(new ByteArrayOutputStream(), i) - 8;
                        return iWrite + ((4 - (iWrite & 3)) & 3);
                    } catch (IOException unused) {
                        throw new WritingNotSupportedException(this.type, this.value);
                    }
                }
                throw new WritingNotSupportedException(this.type, this.value);
            }
        }
        return variantLength;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Property)) {
            return false;
        }
        Property property = (Property) obj;
        Object value = property.getValue();
        long id = property.getID();
        long j = this.id;
        if (j == id && (j == 0 || typesAreEqual(this.type, property.getType()))) {
            Object obj2 = this.value;
            if (obj2 == null && value == null) {
                return true;
            }
            if (obj2 != null && value != null) {
                Class<?> cls = obj2.getClass();
                Class<?> cls2 = value.getClass();
                if (!cls.isAssignableFrom(cls2) && !cls2.isAssignableFrom(cls)) {
                    return false;
                }
                Object obj3 = this.value;
                if (obj3 instanceof byte[]) {
                    byte[] bArr = (byte[]) obj3;
                    byte[] bArr2 = (byte[]) value;
                    int iUnpaddedLength = unpaddedLength(bArr);
                    if (iUnpaddedLength != unpaddedLength(bArr2)) {
                        return false;
                    }
                    for (int i = 0; i < iUnpaddedLength; i++) {
                        if (bArr[i] != bArr2[i]) {
                            return false;
                        }
                    }
                    return true;
                }
                return obj3.equals(value);
            }
        }
        return false;
    }

    private static int unpaddedLength(byte[] bArr) {
        int length = bArr.length;
        while (length > 0 && length > bArr.length - 4 && bArr[length - 1] == 0) {
            length--;
        }
        return length;
    }

    public int hashCode() {
        long jHashCode = this.id + 0 + this.type;
        Object obj = this.value;
        if (obj != null) {
            jHashCode += (long) obj.hashCode();
        }
        return (int) (4294967295L & jHashCode);
    }

    public String toString() {
        return toString(1252, null);
    }

    public String toString(int i, PropertyIDMap propertyIDMap) {
        StringBuilder sb = new StringBuilder("Property[id: ");
        sb.append(this.id);
        String str = propertyIDMap == null ? null : propertyIDMap.get((Object) Long.valueOf(this.id));
        if (str == null) {
            str = PropertyIDMap.getFallbackProperties().get((Object) Long.valueOf(this.id));
        }
        if (str != null) {
            sb.append(" (");
            sb.append(str);
            sb.append(")");
        }
        sb.append(", type: ");
        sb.append(getType());
        sb.append(" (");
        sb.append(getVariantName());
        sb.append(") , value: ");
        Object value = getValue();
        if (value instanceof String) {
            sb.append((String) value);
            sb.append("\n");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                write(byteArrayOutputStream, i);
            } catch (Exception e) {
                LOG.log(5, "can't serialize string", e);
            }
            if (byteArrayOutputStream.size() > 8) {
                sb.append(HexDump.dump(byteArrayOutputStream.toByteArray(), -8L, 8));
            }
        } else if (value instanceof byte[]) {
            sb.append("\n");
            byte[] bArr = (byte[]) value;
            if (bArr.length > 0) {
                sb.append(HexDump.dump(bArr, 0L, 0));
            }
        } else if (value instanceof java.util.Date) {
            java.util.Date date = (java.util.Date) value;
            long jDateToFileTime = Filetime.dateToFileTime(date);
            if (Filetime.isUndefined(date)) {
                sb.append("<undefined>");
            } else if ((jDateToFileTime >>> 32) == 0) {
                long j = jDateToFileTime * 100;
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                long hours = timeUnit.toHours(j);
                long nanos = j - TimeUnit.HOURS.toNanos(hours);
                long minutes = timeUnit.toMinutes(nanos);
                long nanos2 = nanos - TimeUnit.MINUTES.toNanos(minutes);
                long seconds = timeUnit.toSeconds(nanos2);
                sb.append(String.format(Locale.ROOT, "%02d:%02d:%02d.%03d", Long.valueOf(hours), Long.valueOf(minutes), Long.valueOf(seconds), Long.valueOf(timeUnit.toMillis(nanos2 - TimeUnit.SECONDS.toNanos(seconds)))));
            } else {
                Calendar calendar = Calendar.getInstance(LocaleUtil.TIMEZONE_UTC, Locale.ROOT);
                calendar.setTime(date);
                sb.append(DatatypeConverter.printDateTime(calendar));
            }
        } else {
            long j2 = this.type;
            if (j2 == 0 || j2 == 1 || value == null) {
                sb.append("null");
            } else {
                sb.append(value.toString());
                String strDecodeValueFromID = decodeValueFromID();
                if (strDecodeValueFromID != null) {
                    sb.append(" (");
                    sb.append(strDecodeValueFromID);
                    sb.append(")");
                }
            }
        }
        sb.append(']');
        return sb.toString();
    }

    private String getVariantName() {
        return getID() == 0 ? "dictionary" : Variant.getVariantName(getType());
    }

    private String decodeValueFromID() {
        try {
            int id = (int) getID();
            if (id == Integer.MIN_VALUE) {
                return LocaleUtil.getLocaleFromLCID(((Number) this.value).intValue());
            }
            if (id != 1) {
                return null;
            }
            return CodePageUtil.codepageToEncoding(((Number) this.value).intValue());
        } catch (Exception unused) {
            LOG.log(5, "Can't decode id " + getID());
            return null;
        }
    }

    public int write(OutputStream outputStream, int i) throws IOException, WritingNotSupportedException {
        long type = getType();
        if (type == 30 && i != 1200) {
            if (!Charset.forName(CodePageUtil.codepageToEncoding(i > 0 ? i : 1252)).newEncoder().canEncode((String) this.value)) {
                type = 31;
            }
        }
        LittleEndian.putUInt(type, outputStream);
        return 4 + VariantSupport.write(outputStream, type, getValue(), i);
    }
}
