package org.apache.poi.hpsf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.apache.poi.hpsf.wellknown.PropertyIDMap;
import org.apache.poi.hpsf.wellknown.SectionIDMap;
import org.apache.poi.util.CodePageUtil;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Section {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) Section.class);
    private final long _offset;
    private Map<Long, String> dictionary;
    private ClassID formatID;
    private final Map<Long, Property> properties;
    private final ByteArrayOutputStream sectionBytes;
    private boolean wasNull;

    public Section() {
        this.sectionBytes = new ByteArrayOutputStream();
        this.properties = new LinkedHashMap();
        this._offset = -1L;
    }

    public Section(Section section) {
        this.sectionBytes = new ByteArrayOutputStream();
        this.properties = new LinkedHashMap();
        this._offset = -1L;
        setFormatID(section.getFormatID());
        for (Property property : section.properties.values()) {
            this.properties.put(Long.valueOf(property.getID()), new MutableProperty(property));
        }
        setDictionary(section.getDictionary());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Section(byte[] bArr, int i) throws UnsupportedEncodingException {
        int uShort;
        this.sectionBytes = new ByteArrayOutputStream();
        this.properties = new LinkedHashMap();
        this.formatID = new ClassID(bArr, i);
        int uInt = (int) LittleEndian.getUInt(bArr, i + 16);
        if (bArr[uInt] == 0) {
            int i2 = 0;
            while (i2 < 3 && bArr[uInt] == 0) {
                i2++;
                uInt++;
            }
            int i3 = 0;
            while (i3 < 3 && (bArr[uInt + 3] != 0 || bArr[uInt + 7] != 0 || bArr[uInt + 11] != 0)) {
                i3++;
                uInt--;
            }
        }
        long j = uInt;
        this._offset = j;
        LittleEndianByteArrayInputStream littleEndianByteArrayInputStream = new LittleEndianByteArrayInputStream(bArr, uInt);
        int iMin = (int) Math.min(littleEndianByteArrayInputStream.readUInt(), ((long) bArr.length) - j);
        int uInt2 = (int) littleEndianByteArrayInputStream.readUInt();
        TreeBidiMap treeBidiMap = new TreeBidiMap();
        for (int i4 = 0; i4 < uInt2; i4++) {
            treeBidiMap.put(Long.valueOf((int) littleEndianByteArrayInputStream.readUInt()), Long.valueOf((int) littleEndianByteArrayInputStream.readUInt()));
        }
        long j2 = 1;
        Long l = (Long) treeBidiMap.getKey((Object) 1L);
        if (l != null) {
            littleEndianByteArrayInputStream.setReadIndex((int) (this._offset + l.longValue()));
            long uInt3 = littleEndianByteArrayInputStream.readUInt();
            if (uInt3 != 2) {
                throw new HPSFRuntimeException("Value type of property ID 1 is not VT_I2 but " + uInt3 + ".");
            }
            uShort = littleEndianByteArrayInputStream.readUShort();
            setCodepage(uShort);
        } else {
            uShort = -1;
        }
        for (Map.Entry entry : treeBidiMap.entrySet()) {
            long jLongValue = ((Long) entry.getKey()).longValue();
            long jLongValue2 = ((Long) entry.getValue()).longValue();
            if (jLongValue2 != j2) {
                int iPropLen = propLen(treeBidiMap, Long.valueOf(jLongValue), iMin);
                littleEndianByteArrayInputStream.setReadIndex((int) (this._offset + jLongValue));
                if (jLongValue2 == 0) {
                    littleEndianByteArrayInputStream.mark(100000);
                    if (readDictionary(littleEndianByteArrayInputStream, iPropLen, uShort)) {
                        j2 = 1;
                    } else {
                        littleEndianByteArrayInputStream.reset();
                        try {
                            j2 = 1;
                            try {
                                setProperty(new MutableProperty(Math.max(31L, ((Long) treeBidiMap.inverseBidiMap().lastKey()).longValue()) + 1, littleEndianByteArrayInputStream, iPropLen, uShort));
                            } catch (RuntimeException unused) {
                                LOG.log(3, "Dictionary fallback failed - ignoring property");
                            }
                        } catch (RuntimeException unused2) {
                            j2 = 1;
                        }
                    }
                } else {
                    j2 = 1;
                    setProperty(new MutableProperty(jLongValue2, littleEndianByteArrayInputStream, iPropLen, uShort));
                }
            }
        }
        this.sectionBytes.write(bArr, (int) this._offset, iMin);
        padSectionBytes();
    }

    private static int propLen(TreeBidiMap<Long, Long> treeBidiMap, Long l, long j) {
        Long l2 = (Long) treeBidiMap.nextKey(l);
        long jLongValue = l.longValue();
        if (l2 != null) {
            j = l2.longValue();
        }
        return (int) (j - jLongValue);
    }

    public ClassID getFormatID() {
        return this.formatID;
    }

    public void setFormatID(ClassID classID) {
        this.formatID = classID;
    }

    public void setFormatID(byte[] bArr) {
        ClassID formatID = getFormatID();
        if (formatID == null) {
            formatID = new ClassID();
            setFormatID(formatID);
        }
        formatID.setBytes(bArr);
    }

    public long getOffset() {
        return this._offset;
    }

    public int getPropertyCount() {
        return this.properties.size();
    }

    public Property[] getProperties() {
        return (Property[]) this.properties.values().toArray(new Property[this.properties.size()]);
    }

    public void setProperties(Property[] propertyArr) {
        this.properties.clear();
        for (Property property : propertyArr) {
            setProperty(property);
        }
    }

    public Object getProperty(long j) {
        boolean z = !this.properties.containsKey(Long.valueOf(j));
        this.wasNull = z;
        if (z) {
            return null;
        }
        return this.properties.get(Long.valueOf(j)).getValue();
    }

    public void setProperty(int i, String str) {
        setProperty(i, 30L, str);
    }

    public void setProperty(int i, int i2) {
        setProperty(i, 3L, Integer.valueOf(i2));
    }

    public void setProperty(int i, long j) {
        setProperty(i, 20L, Long.valueOf(j));
    }

    public void setProperty(int i, boolean z) {
        setProperty(i, 11L, Boolean.valueOf(z));
    }

    public void setProperty(int i, long j, Object obj) {
        setProperty(new MutableProperty(i, j, obj));
    }

    public void setProperty(Property property) {
        Property property2 = this.properties.get(Long.valueOf(property.getID()));
        if (property2 == null || !property2.equals(property)) {
            this.properties.put(Long.valueOf(property.getID()), property);
            this.sectionBytes.reset();
        }
    }

    public void setProperty(int i, Object obj) {
        if (obj instanceof String) {
            setProperty(i, (String) obj);
            return;
        }
        if (obj instanceof Long) {
            setProperty(i, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Integer) {
            setProperty(i, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Short) {
            setProperty(i, ((Short) obj).intValue());
        } else if (obj instanceof Boolean) {
            setProperty(i, ((Boolean) obj).booleanValue());
        } else {
            if (obj instanceof java.util.Date) {
                setProperty(i, 64L, obj);
                return;
            }
            throw new HPSFRuntimeException("HPSF does not support properties of type " + obj.getClass().getName() + ".");
        }
    }

    protected int getPropertyIntValue(long j) {
        Object property = getProperty(j);
        if (property == null) {
            return 0;
        }
        if (!(property instanceof Long) && !(property instanceof Integer)) {
            throw new HPSFRuntimeException("This property is not an integer type, but " + property.getClass().getName() + ".");
        }
        return ((Number) property).intValue();
    }

    protected boolean getPropertyBooleanValue(int i) {
        Boolean bool = (Boolean) getProperty(i);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    protected void setPropertyBooleanValue(int i, boolean z) {
        setProperty(i, 11L, Boolean.valueOf(z));
    }

    public int getSize() {
        int size = this.sectionBytes.size();
        if (size > 0) {
            return size;
        }
        try {
            return calcSize();
        } catch (HPSFRuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new HPSFRuntimeException(e2);
        }
    }

    private int calcSize() throws IOException, WritingNotSupportedException {
        this.sectionBytes.reset();
        write(this.sectionBytes);
        padSectionBytes();
        return this.sectionBytes.size();
    }

    private void padSectionBytes() {
        int size = 3 & (4 - (this.sectionBytes.size() & 3));
        this.sectionBytes.write(new byte[]{0, 0, 0}, 0, size);
    }

    public boolean wasNull() {
        return this.wasNull;
    }

    public String getPIDString(long j) {
        Map<Long, String> dictionary = getDictionary();
        String str = dictionary != null ? dictionary.get(Long.valueOf(j)) : null;
        return str == null ? SectionIDMap.getPIDString(getFormatID(), j) : str;
    }

    public void clear() {
        for (Property property : getProperties()) {
            removeProperty(property.getID());
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Section)) {
            return false;
        }
        Section section = (Section) obj;
        if (!section.getFormatID().equals(getFormatID())) {
            return false;
        }
        HashSet<Long> hashSet = new HashSet(this.properties.keySet());
        hashSet.addAll(section.properties.keySet());
        hashSet.remove(0L);
        hashSet.remove(1L);
        for (Long l : hashSet) {
            Property property = this.properties.get(l);
            Property property2 = section.properties.get(l);
            if (property == null || property2 == null || !property.equals(property2)) {
                return false;
            }
        }
        Map<Long, String> dictionary = getDictionary();
        Map<Long, String> dictionary2 = section.getDictionary();
        return (dictionary == null && dictionary2 == null) || !(dictionary == null || dictionary2 == null || !dictionary.equals(dictionary2));
    }

    public void removeProperty(long j) {
        if (this.properties.remove(Long.valueOf(j)) != null) {
            this.sectionBytes.reset();
        }
    }

    public int write(OutputStream outputStream) throws IOException, WritingNotSupportedException {
        int iWriteDictionary;
        if (this.sectionBytes.size() > 0) {
            this.sectionBytes.writeTo(outputStream);
            return this.sectionBytes.size();
        }
        int codepage = getCodepage();
        if (codepage == -1) {
            LOG.log(5, "The codepage property is not set although a dictionary is present. Defaulting to ISO-8859-1.");
            codepage = 1252;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        int propertyCount = (getPropertyCount() * 2 * 4) + 8 + 0;
        for (Property property : this.properties.values()) {
            long id = property.getID();
            LittleEndian.putUInt(id, byteArrayOutputStream2);
            LittleEndian.putUInt(propertyCount, byteArrayOutputStream2);
            if (id != 0) {
                iWriteDictionary = property.write(byteArrayOutputStream, codepage);
            } else {
                if (codepage == -1) {
                    throw new IllegalPropertySetDataException("Codepage (property 1) is undefined.");
                }
                iWriteDictionary = writeDictionary(byteArrayOutputStream, codepage);
            }
            propertyCount += iWriteDictionary;
        }
        int size = byteArrayOutputStream2.size() + 8 + byteArrayOutputStream.size();
        LittleEndian.putInt(size, outputStream);
        LittleEndian.putInt(getPropertyCount(), outputStream);
        byteArrayOutputStream2.writeTo(outputStream);
        byteArrayOutputStream.writeTo(outputStream);
        return size;
    }

    private boolean readDictionary(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream, int i, int i2) throws UnsupportedEncodingException {
        HashMap map = new HashMap();
        long uInt = littleEndianByteArrayInputStream.readUInt();
        long j = -1;
        boolean z = false;
        int i3 = 0;
        while (i3 < uInt) {
            String str = "The property set's dictionary contains bogus data. All dictionary entries starting with the one with ID " + j + " will be ignored.";
            long uInt2 = littleEndianByteArrayInputStream.readUInt();
            long uInt3 = littleEndianByteArrayInputStream.readUInt();
            int i4 = i2 == -1 ? 1252 : i2;
            int i5 = (int) ((uInt3 - 1) * ((long) (i4 == 1200 ? 2 : 1)));
            if (i5 > 16777215) {
                LOG.log(5, str);
            } else {
                try {
                    byte[] bArr = new byte[i5];
                    littleEndianByteArrayInputStream.readFully(bArr, 0, i5);
                    String stringFromCodePage = CodePageUtil.getStringFromCodePage(bArr, 0, i5, i4);
                    littleEndianByteArrayInputStream.skip(i4 == 1200 ? ((4 - ((i5 + 2) & 3)) & 3) + 2 : 1);
                    map.put(Long.valueOf(uInt2), stringFromCodePage);
                    i3++;
                    j = uInt2;
                } catch (RuntimeException e) {
                    LOG.log(5, str, e);
                }
            }
            z = true;
        }
        setDictionary(map);
        return !z;
    }

    private int writeDictionary(OutputStream outputStream, int i) throws IOException {
        byte[] bArr = new byte[4];
        Map<Long, String> dictionary = getDictionary();
        LittleEndian.putUInt(dictionary.size(), outputStream);
        int length = 4;
        for (Map.Entry<Long, String> entry : dictionary.entrySet()) {
            LittleEndian.putUInt(entry.getKey().longValue(), outputStream);
            String str = entry.getValue() + "\u0000";
            LittleEndian.putUInt(str.length(), outputStream);
            byte[] bytesInCodePage = CodePageUtil.getBytesInCodePage(str, i);
            outputStream.write(bytesInCodePage);
            length = length + 4 + 4 + bytesInCodePage.length;
            if (i == 1200) {
                int i2 = (4 - (length & 3)) & 3;
                outputStream.write(bArr, 0, i2);
                length += i2;
            }
        }
        int i3 = (4 - (length & 3)) & 3;
        outputStream.write(bArr, 0, i3);
        return length + i3;
    }

    public void setDictionary(Map<Long, String> map) throws IllegalPropertySetDataException {
        if (map != null) {
            if (this.dictionary == null) {
                this.dictionary = new TreeMap();
            }
            this.dictionary.putAll(map);
            if (getCodepage() == -1) {
                setCodepage(1252);
            }
            setProperty(0, -1L, map);
            return;
        }
        removeProperty(0L);
        this.dictionary = null;
    }

    public int hashCode() {
        long jHashCode = ((long) getFormatID().hashCode()) + 0;
        for (Property property : getProperties()) {
            jHashCode += (long) property.hashCode();
        }
        return (int) (jHashCode & 4294967295L);
    }

    public String toString() {
        return toString(null);
    }

    public String toString(PropertyIDMap propertyIDMap) {
        StringBuffer stringBuffer = new StringBuffer("\n\n\n");
        Property[] properties = getProperties();
        stringBuffer.append(getClass().getName());
        stringBuffer.append("[formatID: ");
        stringBuffer.append(getFormatID());
        stringBuffer.append(", offset: ");
        stringBuffer.append(getOffset());
        stringBuffer.append(", propertyCount: ");
        stringBuffer.append(getPropertyCount());
        stringBuffer.append(", size: ");
        stringBuffer.append(getSize());
        stringBuffer.append(", properties: [\n");
        int codepage = getCodepage();
        if (codepage == -1) {
            codepage = 1252;
        }
        for (Property property : properties) {
            stringBuffer.append(property.toString(codepage, propertyIDMap));
            stringBuffer.append(",\n");
        }
        stringBuffer.append("]]");
        return stringBuffer.toString();
    }

    public Map<Long, String> getDictionary() {
        if (this.dictionary == null) {
            this.dictionary = (Map) getProperty(0L);
        }
        return this.dictionary;
    }

    public int getCodepage() {
        Integer num = (Integer) getProperty(1L);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public void setCodepage(int i) {
        setProperty(1, 2L, Integer.valueOf(i));
    }
}
