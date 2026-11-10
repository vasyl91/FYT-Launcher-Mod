package org.apache.poi.hpsf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.EmptyFileException;
import org.apache.poi.hpsf.wellknown.PropertyIDMap;
import org.apache.poi.hpsf.wellknown.SectionIDMap;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.util.CodePageUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.NotImplemented;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class PropertySet {
    static final int BYTE_ORDER_ASSERTION = 65534;
    static final int FORMAT_ASSERTION = 0;
    static final int OFFSET_HEADER = 28;
    public static final int OS_MACINTOSH = 1;
    public static final int OS_WIN16 = 0;
    public static final int OS_WIN32 = 2;
    private int byteOrder;
    private ClassID classID;
    private int format;
    private int osVersion;
    private final List<Section> sections;

    public PropertyIDMap getPropertySetIDMap() {
        return null;
    }

    public PropertySet() {
        this.sections = new ArrayList();
        this.byteOrder = BYTE_ORDER_ASSERTION;
        this.format = 0;
        this.osVersion = 133636;
        this.classID = new ClassID();
        addSection(new MutableSection());
    }

    public PropertySet(InputStream inputStream) throws MarkUnsupportedException, NoPropertySetStreamException, IOException {
        this.sections = new ArrayList();
        if (!isPropertySetStream(inputStream)) {
            throw new NoPropertySetStreamException();
        }
        byte[] byteArray = IOUtils.toByteArray(inputStream);
        init(byteArray, 0, byteArray.length);
    }

    public PropertySet(byte[] bArr, int i, int i2) throws NoPropertySetStreamException, UnsupportedEncodingException {
        this.sections = new ArrayList();
        if (!isPropertySetStream(bArr, i, i2)) {
            throw new NoPropertySetStreamException();
        }
        init(bArr, i, i2);
    }

    public PropertySet(byte[] bArr) throws NoPropertySetStreamException, UnsupportedEncodingException {
        this(bArr, 0, bArr.length);
    }

    public PropertySet(PropertySet propertySet) {
        this.sections = new ArrayList();
        setByteOrder(propertySet.getByteOrder());
        setFormat(propertySet.getFormat());
        setOSVersion(propertySet.getOSVersion());
        setClassID(propertySet.getClassID());
        Iterator<Section> it = propertySet.getSections().iterator();
        while (it.hasNext()) {
            this.sections.add(new MutableSection(it.next()));
        }
    }

    public int getByteOrder() {
        return this.byteOrder;
    }

    public void setByteOrder(int i) {
        this.byteOrder = i;
    }

    public int getFormat() {
        return this.format;
    }

    public void setFormat(int i) {
        this.format = i;
    }

    public int getOSVersion() {
        return this.osVersion;
    }

    public void setOSVersion(int i) {
        this.osVersion = i;
    }

    public ClassID getClassID() {
        return this.classID;
    }

    public void setClassID(ClassID classID) {
        this.classID = classID;
    }

    public int getSectionCount() {
        return this.sections.size();
    }

    public List<Section> getSections() {
        return Collections.unmodifiableList(this.sections);
    }

    public void addSection(Section section) {
        this.sections.add(section);
    }

    public void clearSections() {
        this.sections.clear();
    }

    public static boolean isPropertySetStream(InputStream inputStream) throws MarkUnsupportedException, IOException {
        try {
            byte[] bArrPeekFirstNBytes = IOUtils.peekFirstNBytes(inputStream, 50);
            return isPropertySetStream(bArrPeekFirstNBytes, 0, bArrPeekFirstNBytes.length);
        } catch (EmptyFileException unused) {
            return false;
        }
    }

    public static boolean isPropertySetStream(byte[] bArr, int i, int i2) {
        int uShort = LittleEndian.getUShort(bArr, i);
        int i3 = i + 2;
        if (uShort != BYTE_ORDER_ASSERTION) {
            return false;
        }
        return LittleEndian.getUShort(bArr, i3) == 0 && LittleEndian.getUInt(bArr, ((i3 + 2) + 4) + 16) >= 0;
    }

    private void init(byte[] bArr, int i, int i2) throws UnsupportedEncodingException {
        this.byteOrder = LittleEndian.getUShort(bArr, i);
        int i3 = i + 2;
        this.format = LittleEndian.getUShort(bArr, i3);
        int i4 = i3 + 2;
        this.osVersion = (int) LittleEndian.getUInt(bArr, i4);
        int i5 = i4 + 4;
        this.classID = new ClassID(bArr, i5);
        int i6 = i5 + 16;
        int i7 = LittleEndian.getInt(bArr, i6);
        int i8 = i6 + 4;
        if (i7 < 0) {
            throw new HPSFRuntimeException("Section count " + i7 + " is negative.");
        }
        for (int i9 = 0; i9 < i7; i9++) {
            MutableSection mutableSection = new MutableSection(bArr, i8);
            i8 += 20;
            this.sections.add(mutableSection);
        }
    }

    public void write(OutputStream outputStream) throws IOException, WritingNotSupportedException {
        int sectionCount = getSectionCount();
        LittleEndian.putShort(outputStream, (short) getByteOrder());
        LittleEndian.putShort(outputStream, (short) getFormat());
        LittleEndian.putInt(getOSVersion(), outputStream);
        putClassId(outputStream, getClassID());
        LittleEndian.putInt(sectionCount, outputStream);
        int size = (sectionCount * 20) + 28;
        for (Section section : getSections()) {
            ClassID formatID = section.getFormatID();
            if (formatID == null) {
                throw new NoFormatIDException();
            }
            putClassId(outputStream, formatID);
            LittleEndian.putUInt(size, outputStream);
            try {
                size += section.getSize();
            } catch (HPSFRuntimeException e) {
                Throwable reason = e.getReason();
                if (reason instanceof UnsupportedEncodingException) {
                    throw new IllegalPropertySetDataException(reason);
                }
                throw e;
            }
        }
        Iterator<Section> it = getSections().iterator();
        while (it.hasNext()) {
            it.next().write(outputStream);
        }
        outputStream.close();
    }

    public void write(DirectoryEntry directoryEntry, String str) throws IOException, WritingNotSupportedException {
        if (directoryEntry.hasEntry(str)) {
            directoryEntry.getEntry(str).delete();
        }
        directoryEntry.createDocument(str, toInputStream());
    }

    public InputStream toInputStream() throws IOException, WritingNotSupportedException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            write(byteArrayOutputStream);
            return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        } finally {
            byteArrayOutputStream.close();
        }
    }

    protected String getPropertyStringValue(int i) {
        return getPropertyStringValue(getProperty(i));
    }

    public static String getPropertyStringValue(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length;
            if (length == 0) {
                return "";
            }
            if (length == 1) {
                return Byte.toString(bArr[0]);
            }
            if (length == 2) {
                return Integer.toString(LittleEndian.getUShort(bArr));
            }
            if (length == 4) {
                return Long.toString(LittleEndian.getUInt(bArr));
            }
            try {
                return CodePageUtil.getStringFromCodePage(bArr, 1252);
            } catch (UnsupportedEncodingException unused) {
                return "";
            }
        }
        return obj.toString();
    }

    public boolean isSummaryInformation() {
        return !this.sections.isEmpty() && matchesSummary(getFirstSection().getFormatID(), SectionIDMap.SUMMARY_INFORMATION_ID);
    }

    public boolean isDocumentSummaryInformation() {
        return !this.sections.isEmpty() && matchesSummary(getFirstSection().getFormatID(), SectionIDMap.DOCUMENT_SUMMARY_INFORMATION_ID);
    }

    static boolean matchesSummary(ClassID classID, ClassID... classIDArr) {
        for (ClassID classID2 : classIDArr) {
            if (classID2.equals(classID) || classID2.equalsInverted(classID)) {
                return true;
            }
        }
        return false;
    }

    public Property[] getProperties() throws NoSingleSectionException {
        return getFirstSection().getProperties();
    }

    protected Object getProperty(int i) throws NoSingleSectionException {
        return getFirstSection().getProperty(i);
    }

    protected boolean getPropertyBooleanValue(int i) throws NoSingleSectionException {
        return getFirstSection().getPropertyBooleanValue(i);
    }

    protected int getPropertyIntValue(int i) throws NoSingleSectionException {
        return getFirstSection().getPropertyIntValue(i);
    }

    public boolean wasNull() throws NoSingleSectionException {
        return getFirstSection().wasNull();
    }

    public Section getFirstSection() {
        if (this.sections.isEmpty()) {
            throw new MissingSectionException("Property set does not contain any sections.");
        }
        return this.sections.get(0);
    }

    public Section getSingleSection() {
        int sectionCount = getSectionCount();
        if (sectionCount != 1) {
            throw new NoSingleSectionException("Property set contains " + sectionCount + " sections.");
        }
        return this.sections.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof PropertySet)) {
            PropertySet propertySet = (PropertySet) obj;
            int byteOrder = propertySet.getByteOrder();
            int byteOrder2 = getByteOrder();
            ClassID classID = propertySet.getClassID();
            ClassID classID2 = getClassID();
            int format = propertySet.getFormat();
            int format2 = getFormat();
            int oSVersion = propertySet.getOSVersion();
            int oSVersion2 = getOSVersion();
            int sectionCount = propertySet.getSectionCount();
            int sectionCount2 = getSectionCount();
            if (byteOrder == byteOrder2 && classID.equals(classID2) && format == format2 && oSVersion == oSVersion2 && sectionCount == sectionCount2) {
                return getSections().containsAll(propertySet.getSections());
            }
        }
        return false;
    }

    @NotImplemented
    public int hashCode() {
        throw new UnsupportedOperationException("FIXME: Not yet implemented.");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int sectionCount = getSectionCount();
        sb.append(getClass().getName());
        sb.append("[byteOrder: ");
        sb.append(getByteOrder());
        sb.append(", classID: ");
        sb.append(getClassID());
        sb.append(", format: ");
        sb.append(getFormat());
        sb.append(", OSVersion: ");
        sb.append(getOSVersion());
        sb.append(", sectionCount: ");
        sb.append(sectionCount);
        sb.append(", sections: [\n");
        Iterator<Section> it = getSections().iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString(getPropertySetIDMap()));
        }
        sb.append("]]");
        return sb.toString();
    }

    protected void remove1stProperty(long j) {
        getFirstSection().removeProperty(j);
    }

    protected void set1stProperty(long j, String str) {
        getFirstSection().setProperty((int) j, str);
    }

    protected void set1stProperty(long j, int i) {
        getFirstSection().setProperty((int) j, i);
    }

    protected void set1stProperty(long j, boolean z) {
        getFirstSection().setProperty((int) j, z);
    }

    protected void set1stProperty(long j, byte[] bArr) {
        getFirstSection().setProperty((int) j, bArr);
    }

    private static void putClassId(OutputStream outputStream, ClassID classID) throws IOException {
        byte[] bArr = new byte[16];
        classID.write(bArr, 0);
        outputStream.write(bArr, 0, 16);
    }
}
