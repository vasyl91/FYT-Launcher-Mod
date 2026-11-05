package org.apache.poi.xdgf.exceptions;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XDGFException {
    public static POIXMLException error(String str, Object obj) {
        return new POIXMLException(obj + ": " + str);
    }

    public static POIXMLException error(String str, Object obj, Throwable th) {
        return new POIXMLException(obj + ": " + str, th);
    }

    public static POIXMLException wrap(POIXMLDocumentPart pOIXMLDocumentPart, POIXMLException pOIXMLException) {
        String str = pOIXMLDocumentPart.getPackagePart().getPartName() + ": " + pOIXMLException.getMessage();
        Throwable cause = pOIXMLException.getCause();
        POIXMLException cause2 = pOIXMLException;
        if (cause != null) {
            cause2 = pOIXMLException.getCause();
        }
        return new POIXMLException(str, cause2);
    }

    public static POIXMLException wrap(String str, POIXMLException pOIXMLException) {
        String str2 = str + ": " + pOIXMLException.getMessage();
        Throwable cause = pOIXMLException.getCause();
        POIXMLException cause2 = pOIXMLException;
        if (cause != null) {
            cause2 = pOIXMLException.getCause();
        }
        return new POIXMLException(str2, cause2);
    }
}
