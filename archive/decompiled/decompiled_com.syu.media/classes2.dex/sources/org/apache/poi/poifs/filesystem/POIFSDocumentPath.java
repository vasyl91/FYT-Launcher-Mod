package org.apache.poi.poifs.filesystem;

import java.io.File;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class POIFSDocumentPath {
    private static final POILogger log = POILogFactory.getLogger((Class<?>) POIFSDocumentPath.class);
    private final String[] components;
    private int hashcode;

    public POIFSDocumentPath(String[] strArr) throws IllegalArgumentException {
        this.hashcode = 0;
        if (strArr == null) {
            this.components = new String[0];
            return;
        }
        this.components = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("components cannot contain null or empty strings");
            }
            this.components[i] = strArr[i];
        }
    }

    public POIFSDocumentPath() {
        this.hashcode = 0;
        this.components = new String[0];
    }

    public POIFSDocumentPath(POIFSDocumentPath pOIFSDocumentPath, String[] strArr) throws IllegalArgumentException {
        this.hashcode = 0;
        if (strArr == null) {
            this.components = new String[pOIFSDocumentPath.components.length];
        } else {
            this.components = new String[pOIFSDocumentPath.components.length + strArr.length];
        }
        int i = 0;
        while (true) {
            String[] strArr2 = pOIFSDocumentPath.components;
            if (i >= strArr2.length) {
                break;
            }
            this.components[i] = strArr2[i];
            i++;
        }
        if (strArr != null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                String str = strArr[i2];
                if (str == null) {
                    throw new IllegalArgumentException("components cannot contain null");
                }
                if (str.length() == 0) {
                    log.log(5, "Directory under " + pOIFSDocumentPath + " has an empty name, not all OLE2 readers will handle this file correctly!");
                }
                this.components[pOIFSDocumentPath.components.length + i2] = strArr[i2];
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (this != obj) {
            POIFSDocumentPath pOIFSDocumentPath = (POIFSDocumentPath) obj;
            if (pOIFSDocumentPath.components.length != this.components.length) {
                return false;
            }
            int i = 0;
            while (true) {
                String[] strArr = this.components;
                if (i >= strArr.length) {
                    break;
                }
                if (!pOIFSDocumentPath.components[i].equals(strArr[i])) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public int hashCode() {
        if (this.hashcode == 0) {
            this.hashcode = computeHashCode();
        }
        return this.hashcode;
    }

    private int computeHashCode() {
        int i = 0;
        int iHashCode = 0;
        while (true) {
            String[] strArr = this.components;
            if (i >= strArr.length) {
                return iHashCode;
            }
            iHashCode += strArr[i].hashCode();
            i++;
        }
    }

    public int length() {
        return this.components.length;
    }

    public String getComponent(int i) throws ArrayIndexOutOfBoundsException {
        return this.components[i];
    }

    public POIFSDocumentPath getParent() {
        String[] strArr = this.components;
        int length = strArr.length - 1;
        if (length < 0) {
            return null;
        }
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, length);
        return new POIFSDocumentPath(strArr2);
    }

    public String getName() {
        String[] strArr = this.components;
        return strArr.length == 0 ? "" : strArr[strArr.length - 1];
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        int length = length();
        stringBuffer.append(File.separatorChar);
        for (int i = 0; i < length; i++) {
            stringBuffer.append(getComponent(i));
            if (i < length - 1) {
                stringBuffer.append(File.separatorChar);
            }
        }
        return stringBuffer.toString();
    }
}
