package org.apache.xmlbeans;

import java.io.File;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface SchemaTypeSystem extends SchemaTypeLoader {
    SchemaAnnotation[] annotations();

    SchemaAttributeGroup[] attributeGroups();

    SchemaType[] attributeTypes();

    SchemaType[] documentTypes();

    ClassLoader getClassLoader();

    String getName();

    SchemaGlobalAttribute[] globalAttributes();

    SchemaGlobalElement[] globalElements();

    SchemaType[] globalTypes();

    SchemaModelGroup[] modelGroups();

    void resolve();

    SchemaComponent resolveHandle(String str);

    void save(Filer filer);

    void saveToDirectory(File file);

    SchemaType typeForHandle(String str);
}
