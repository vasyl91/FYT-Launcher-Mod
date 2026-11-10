package org.apache.poi.openxml4j.opc;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface RelationshipSource {
    PackageRelationship addExternalRelationship(String str, String str2);

    PackageRelationship addExternalRelationship(String str, String str2, String str3);

    PackageRelationship addRelationship(PackagePartName packagePartName, TargetMode targetMode, String str);

    PackageRelationship addRelationship(PackagePartName packagePartName, TargetMode targetMode, String str, String str2);

    void clearRelationships();

    PackageRelationship getRelationship(String str);

    PackageRelationshipCollection getRelationships() throws OpenXML4JException;

    PackageRelationshipCollection getRelationshipsByType(String str) throws OpenXML4JException, IllegalArgumentException;

    boolean hasRelationships();

    boolean isRelationshipExists(PackageRelationship packageRelationship);

    void removeRelationship(String str);
}
