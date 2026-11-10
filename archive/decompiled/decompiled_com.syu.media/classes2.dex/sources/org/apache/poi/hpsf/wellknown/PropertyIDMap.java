package org.apache.poi.hpsf.wellknown;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class PropertyIDMap implements Map<Long, String> {
    public static final int PID_APPNAME = 18;
    public static final int PID_AUTHOR = 4;
    public static final int PID_BEHAVIOUR = -2147483645;
    public static final int PID_BYTECOUNT = 4;
    public static final int PID_CATEGORY = 2;
    public static final int PID_CCHWITHSPACES = 17;
    public static final int PID_CHARCOUNT = 16;
    public static final int PID_CODEPAGE = 1;
    public static final int PID_COMMENTS = 6;
    public static final int PID_COMPANY = 15;
    public static final int PID_CONTENTSTATUS = 27;
    public static final int PID_CONTENTTYPE = 26;
    public static final int PID_CREATE_DTM = 12;
    public static final int PID_DICTIONARY = 0;
    public static final int PID_DIGSIG = 24;
    public static final int PID_DOCPARTS = 13;
    public static final int PID_DOCVERSION = 29;
    public static final int PID_EDITTIME = 10;
    public static final int PID_HEADINGPAIR = 12;
    public static final int PID_HIDDENCOUNT = 9;
    public static final int PID_HYPERLINKSCHANGED = 22;
    public static final int PID_KEYWORDS = 5;
    public static final int PID_LANGUAGE = 28;
    public static final int PID_LASTAUTHOR = 8;
    public static final int PID_LASTPRINTED = 11;
    public static final int PID_LASTSAVE_DTM = 13;
    public static final int PID_LINECOUNT = 5;
    public static final int PID_LINKSDIRTY = 16;
    public static final int PID_LOCALE = Integer.MIN_VALUE;
    public static final int PID_MANAGER = 14;
    public static final int PID_MAX = 31;
    public static final int PID_MMCLIPCOUNT = 10;
    public static final int PID_NOTECOUNT = 8;
    public static final int PID_PAGECOUNT = 14;
    public static final int PID_PARCOUNT = 6;
    public static final int PID_PRESFORMAT = 3;
    public static final int PID_REVNUMBER = 9;
    public static final int PID_SCALE = 11;
    public static final int PID_SECURITY = 19;
    public static final int PID_SLIDECOUNT = 7;
    public static final int PID_SUBJECT = 3;
    public static final int PID_TEMPLATE = 7;
    public static final int PID_THUMBNAIL = 17;
    public static final int PID_TITLE = 2;
    public static final int PID_VERSION = 23;
    public static final int PID_WORDCOUNT = 15;
    private static PropertyIDMap documentSummaryInformationProperties;
    private static PropertyIDMap fallbackProperties;
    private static PropertyIDMap summaryInformationProperties;
    private final Map<Long, String> idMap;
    private static final Object[][] summaryInformationIdValues = {new Object[]{2L, "PID_TITLE"}, new Object[]{3L, "PID_SUBJECT"}, new Object[]{4L, "PID_AUTHOR"}, new Object[]{5L, "PID_KEYWORDS"}, new Object[]{6L, "PID_COMMENTS"}, new Object[]{7L, "PID_TEMPLATE"}, new Object[]{8L, "PID_LASTAUTHOR"}, new Object[]{9L, "PID_REVNUMBER"}, new Object[]{10L, "PID_EDITTIME"}, new Object[]{11L, "PID_LASTPRINTED"}, new Object[]{12L, "PID_CREATE_DTM"}, new Object[]{13L, "PID_LASTSAVE_DTM"}, new Object[]{14L, "PID_PAGECOUNT"}, new Object[]{15L, "PID_WORDCOUNT"}, new Object[]{16L, "PID_CHARCOUNT"}, new Object[]{17L, "PID_THUMBNAIL"}, new Object[]{18L, "PID_APPNAME"}, new Object[]{19L, "PID_SECURITY"}};
    private static final Object[][] documentSummaryInformationIdValues = {new Object[]{0L, "PID_DICTIONARY"}, new Object[]{1L, "PID_CODEPAGE"}, new Object[]{2L, "PID_CATEGORY"}, new Object[]{3L, "PID_PRESFORMAT"}, new Object[]{4L, "PID_BYTECOUNT"}, new Object[]{5L, "PID_LINECOUNT"}, new Object[]{6L, "PID_PARCOUNT"}, new Object[]{7L, "PID_SLIDECOUNT"}, new Object[]{8L, "PID_NOTECOUNT"}, new Object[]{9L, "PID_HIDDENCOUNT"}, new Object[]{10L, "PID_MMCLIPCOUNT"}, new Object[]{11L, "PID_SCALE"}, new Object[]{12L, "PID_HEADINGPAIR"}, new Object[]{13L, "PID_DOCPARTS"}, new Object[]{14L, "PID_MANAGER"}, new Object[]{15L, "PID_COMPANY"}, new Object[]{16L, "PID_LINKSDIRTY"}};
    private static final Object[][] fallbackIdValues = {new Object[]{0L, "PID_DICTIONARY"}, new Object[]{1L, "PID_CODEPAGE"}, new Object[]{2L, "PID_CATEGORY"}, new Object[]{3L, "PID_PRESFORMAT"}, new Object[]{4L, "PID_BYTECOUNT"}, new Object[]{5L, "PID_LINECOUNT"}, new Object[]{6L, "PID_PARCOUNT"}, new Object[]{7L, "PID_SLIDECOUNT"}, new Object[]{8L, "PID_NOTECOUNT"}, new Object[]{9L, "PID_HIDDENCOUNT"}, new Object[]{10L, "PID_MMCLIPCOUNT"}, new Object[]{11L, "PID_SCALE"}, new Object[]{12L, "PID_HEADINGPAIR"}, new Object[]{13L, "PID_DOCPARTS"}, new Object[]{14L, "PID_MANAGER"}, new Object[]{15L, "PID_COMPANY"}, new Object[]{16L, "PID_LINKSDIRTY"}, new Object[]{17L, "PID_CCHWITHSPACES"}, new Object[]{22L, "PID_HYPERLINKSCHANGED"}, new Object[]{23L, "PID_VERSION"}, new Object[]{24L, "PID_DIGSIG"}, new Object[]{26L, "PID_CONTENTTYPE"}, new Object[]{27L, "PID_CONTENTSTATUS"}, new Object[]{28L, "PID_LANGUAGE"}, new Object[]{29L, "PID_DOCVERSION"}, new Object[]{31L, "PID_MAX"}, new Object[]{-2147483648L, "PID_LOCALE"}, new Object[]{-2147483645L, "PID_BEHAVIOUR"}};

    private PropertyIDMap(Object[][] objArr) {
        HashMap map = new HashMap(objArr.length);
        for (Object[] objArr2 : objArr) {
            map.put((Long) objArr2[0], (String) objArr2[1]);
        }
        this.idMap = Collections.unmodifiableMap(map);
    }

    public static synchronized PropertyIDMap getSummaryInformationProperties() {
        if (summaryInformationProperties == null) {
            summaryInformationProperties = new PropertyIDMap(summaryInformationIdValues);
        }
        return summaryInformationProperties;
    }

    public static synchronized PropertyIDMap getDocumentSummaryInformationProperties() {
        if (documentSummaryInformationProperties == null) {
            documentSummaryInformationProperties = new PropertyIDMap(documentSummaryInformationIdValues);
        }
        return documentSummaryInformationProperties;
    }

    public static synchronized PropertyIDMap getFallbackProperties() {
        if (fallbackProperties == null) {
            fallbackProperties = new PropertyIDMap(fallbackIdValues);
        }
        return fallbackProperties;
    }

    @Override // java.util.Map
    public int size() {
        return this.idMap.size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.idMap.isEmpty();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.idMap.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.idMap.containsValue(obj);
    }

    @Override // java.util.Map
    public String get(Object obj) {
        return this.idMap.get(obj);
    }

    @Override // java.util.Map
    public String put(Long l, String str) {
        return this.idMap.put(l, str);
    }

    @Override // java.util.Map
    public String remove(Object obj) {
        return this.idMap.remove(obj);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Long, ? extends String> map) {
        this.idMap.putAll(map);
    }

    @Override // java.util.Map
    public void clear() {
        this.idMap.clear();
    }

    @Override // java.util.Map
    public Set<Long> keySet() {
        return this.idMap.keySet();
    }

    @Override // java.util.Map
    public Collection<String> values() {
        return this.idMap.values();
    }

    @Override // java.util.Map
    public Set<Map.Entry<Long, String>> entrySet() {
        return this.idMap.entrySet();
    }

    public static void main(String[] strArr) {
        PropertyIDMap summaryInformationProperties2 = getSummaryInformationProperties();
        PropertyIDMap documentSummaryInformationProperties2 = getDocumentSummaryInformationProperties();
        System.out.println("s1: " + summaryInformationProperties2);
        System.out.println("s2: " + documentSummaryInformationProperties2);
    }
}
