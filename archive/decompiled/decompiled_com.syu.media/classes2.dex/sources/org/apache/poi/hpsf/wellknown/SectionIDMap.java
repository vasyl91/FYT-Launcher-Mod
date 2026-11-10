package org.apache.poi.hpsf.wellknown;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.POIXMLProperties;
import org.apache.poi.hpsf.ClassID;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public class SectionIDMap {
    public static final ClassID[] DOCUMENT_SUMMARY_INFORMATION_ID;
    private static final ClassID DOC_SUMMARY_INFORMATION;
    public static final String UNDEFINED = "[undefined]";
    private static final ClassID USER_DEFINED_PROPERTIES;
    private static ThreadLocal<Map<ClassID, PropertyIDMap>> defaultMap = new ThreadLocal<>();
    public static final ClassID SUMMARY_INFORMATION_ID = new ClassID("{F29F85E0-4FF9-1068-AB91-08002B27B3D9}");

    static {
        ClassID classID = new ClassID("{D5CDD502-2E9C-101B-9397-08002B2CF9AE}");
        DOC_SUMMARY_INFORMATION = classID;
        ClassID classID2 = new ClassID(POIXMLProperties.CustomProperties.FORMAT_ID);
        USER_DEFINED_PROPERTIES = classID2;
        DOCUMENT_SUMMARY_INFORMATION_ID = new ClassID[]{classID, classID2};
    }

    public static SectionIDMap getInstance() {
        if (defaultMap.get() == null) {
            HashMap map = new HashMap();
            map.put(SUMMARY_INFORMATION_ID, PropertyIDMap.getSummaryInformationProperties());
            map.put(DOCUMENT_SUMMARY_INFORMATION_ID[0], PropertyIDMap.getDocumentSummaryInformationProperties());
            defaultMap.set(map);
        }
        return new SectionIDMap();
    }

    public static String getPIDString(ClassID classID, long j) {
        String str;
        PropertyIDMap propertyIDMap = getInstance().get(classID);
        return (propertyIDMap == null || (str = propertyIDMap.get((Object) Long.valueOf(j))) == null) ? UNDEFINED : str;
    }

    public PropertyIDMap get(ClassID classID) {
        return getInstance().get(classID);
    }

    public PropertyIDMap put(ClassID classID, PropertyIDMap propertyIDMap) {
        return getInstance().put(classID, propertyIDMap);
    }

    protected PropertyIDMap put(String str, PropertyIDMap propertyIDMap) {
        return put(new ClassID(str), propertyIDMap);
    }
}
