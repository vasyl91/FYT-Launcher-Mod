package org.apache.poi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class POIXMLRelation {
    private static final POILogger log = POILogFactory.getLogger((Class<?>) POIXMLRelation.class);
    private Class<? extends POIXMLDocumentPart> _cls;
    private String _defaultName;
    private String _relation;
    private String _type;

    public POIXMLRelation(String str, String str2, String str3, Class<? extends POIXMLDocumentPart> cls) {
        this._type = str;
        this._relation = str2;
        this._defaultName = str3;
        this._cls = cls;
    }

    public POIXMLRelation(String str, String str2, String str3) {
        this(str, str2, str3, null);
    }

    public String getContentType() {
        return this._type;
    }

    public String getRelation() {
        return this._relation;
    }

    public String getDefaultFileName() {
        return this._defaultName;
    }

    public String getFileName(int i) {
        if (!this._defaultName.contains("#")) {
            return getDefaultFileName();
        }
        return this._defaultName.replace("#", Integer.toString(i));
    }

    public Integer getFileNameIndex(POIXMLDocumentPart pOIXMLDocumentPart) {
        return Integer.valueOf(pOIXMLDocumentPart.getPackagePart().getPartName().getName().replaceAll(this._defaultName.replace("#", "(\\d+)"), "$1"));
    }

    public Class<? extends POIXMLDocumentPart> getRelationClass() {
        return this._cls;
    }

    public InputStream getContents(PackagePart packagePart) throws InvalidFormatException, IOException {
        Iterator<PackageRelationship> it = packagePart.getRelationshipsByType(getRelation()).iterator();
        if (it.hasNext()) {
            return packagePart.getPackage().getPart(PackagingURIHelper.createPartName(it.next().getTargetURI())).getInputStream();
        }
        log.log(5, "No part " + getDefaultFileName() + " found");
        return null;
    }
}
