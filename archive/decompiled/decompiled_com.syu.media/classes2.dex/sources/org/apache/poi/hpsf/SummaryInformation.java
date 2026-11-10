package org.apache.poi.hpsf;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.hpsf.wellknown.PropertyIDMap;
import org.apache.poi.hpsf.wellknown.SectionIDMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class SummaryInformation extends SpecialPropertySet {
    public static final String DEFAULT_STREAM_NAME = "\u0005SummaryInformation";

    @Override // org.apache.poi.hpsf.PropertySet
    public PropertyIDMap getPropertySetIDMap() {
        return PropertyIDMap.getSummaryInformationProperties();
    }

    public SummaryInformation() {
        getFirstSection().setFormatID(SectionIDMap.SUMMARY_INFORMATION_ID);
    }

    public SummaryInformation(PropertySet propertySet) throws UnexpectedPropertySetTypeException {
        super(propertySet);
        if (!isSummaryInformation()) {
            throw new UnexpectedPropertySetTypeException("Not a " + getClass().getName());
        }
    }

    public SummaryInformation(InputStream inputStream) throws MarkUnsupportedException, NoPropertySetStreamException, IOException {
        super(inputStream);
    }

    public String getTitle() {
        return getPropertyStringValue(2);
    }

    public void setTitle(String str) {
        set1stProperty(2L, str);
    }

    public void removeTitle() {
        remove1stProperty(2L);
    }

    public String getSubject() {
        return getPropertyStringValue(3);
    }

    public void setSubject(String str) {
        set1stProperty(3L, str);
    }

    public void removeSubject() {
        remove1stProperty(3L);
    }

    public String getAuthor() {
        return getPropertyStringValue(4);
    }

    public void setAuthor(String str) {
        set1stProperty(4L, str);
    }

    public void removeAuthor() {
        remove1stProperty(4L);
    }

    public String getKeywords() {
        return getPropertyStringValue(5);
    }

    public void setKeywords(String str) {
        set1stProperty(5L, str);
    }

    public void removeKeywords() {
        remove1stProperty(5L);
    }

    public String getComments() {
        return getPropertyStringValue(6);
    }

    public void setComments(String str) {
        set1stProperty(6L, str);
    }

    public void removeComments() {
        remove1stProperty(6L);
    }

    public String getTemplate() {
        return getPropertyStringValue(7);
    }

    public void setTemplate(String str) {
        set1stProperty(7L, str);
    }

    public void removeTemplate() {
        remove1stProperty(7L);
    }

    public String getLastAuthor() {
        return getPropertyStringValue(8);
    }

    public void setLastAuthor(String str) {
        set1stProperty(8L, str);
    }

    public void removeLastAuthor() {
        remove1stProperty(8L);
    }

    public String getRevNumber() {
        return getPropertyStringValue(9);
    }

    public void setRevNumber(String str) {
        set1stProperty(9L, str);
    }

    public void removeRevNumber() {
        remove1stProperty(9L);
    }

    public long getEditTime() {
        java.util.Date date = (java.util.Date) getProperty(10);
        if (date == null) {
            return 0L;
        }
        return Filetime.dateToFileTime(date);
    }

    public void setEditTime(long j) {
        getFirstSection().setProperty(10, 64L, Filetime.filetimeToDate(j));
    }

    public void removeEditTime() {
        remove1stProperty(10L);
    }

    public java.util.Date getLastPrinted() {
        return (java.util.Date) getProperty(11);
    }

    public void setLastPrinted(java.util.Date date) {
        getFirstSection().setProperty(11, 64L, date);
    }

    public void removeLastPrinted() {
        remove1stProperty(11L);
    }

    public java.util.Date getCreateDateTime() {
        return (java.util.Date) getProperty(12);
    }

    public void setCreateDateTime(java.util.Date date) {
        getFirstSection().setProperty(12, 64L, date);
    }

    public void removeCreateDateTime() {
        remove1stProperty(12L);
    }

    public java.util.Date getLastSaveDateTime() {
        return (java.util.Date) getProperty(13);
    }

    public void setLastSaveDateTime(java.util.Date date) {
        getFirstSection().setProperty(13, 64L, date);
    }

    public void removeLastSaveDateTime() {
        remove1stProperty(13L);
    }

    public int getPageCount() {
        return getPropertyIntValue(14);
    }

    public void setPageCount(int i) {
        set1stProperty(14L, i);
    }

    public void removePageCount() {
        remove1stProperty(14L);
    }

    public int getWordCount() {
        return getPropertyIntValue(15);
    }

    public void setWordCount(int i) {
        set1stProperty(15L, i);
    }

    public void removeWordCount() {
        remove1stProperty(15L);
    }

    public int getCharCount() {
        return getPropertyIntValue(16);
    }

    public void setCharCount(int i) {
        set1stProperty(16L, i);
    }

    public void removeCharCount() {
        remove1stProperty(16L);
    }

    public byte[] getThumbnail() {
        return (byte[]) getProperty(17);
    }

    public Thumbnail getThumbnailThumbnail() {
        byte[] thumbnail = getThumbnail();
        if (thumbnail == null) {
            return null;
        }
        return new Thumbnail(thumbnail);
    }

    public void setThumbnail(byte[] bArr) {
        getFirstSection().setProperty(17, 30L, bArr);
    }

    public void removeThumbnail() {
        remove1stProperty(17L);
    }

    public String getApplicationName() {
        return getPropertyStringValue(18);
    }

    public void setApplicationName(String str) {
        set1stProperty(18L, str);
    }

    public void removeApplicationName() {
        remove1stProperty(18L);
    }

    public int getSecurity() {
        return getPropertyIntValue(19);
    }

    public void setSecurity(int i) {
        set1stProperty(19L, i);
    }

    public void removeSecurity() {
        remove1stProperty(19L);
    }
}
