package org.apache.xmlbeans.impl.tool;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class SchemaImportResolver {

    public interface SchemaResource {
        String getNamespace();

        SchemaDocument.Schema getSchema();

        String getSchemaLocation();
    }

    public abstract SchemaResource lookupResource(String str, String str2);

    public abstract void reportActualNamespace(SchemaResource schemaResource, String str);

    protected final void resolveImports(SchemaResource[] schemaResourceArr) {
        SchemaResource schemaResourceLookupResource;
        LinkedList linkedList = new LinkedList(Arrays.asList(schemaResourceArr));
        LinkedList linkedList2 = new LinkedList();
        HashSet hashSet = new HashSet();
        while (true) {
            if (!linkedList.isEmpty()) {
                schemaResourceLookupResource = (SchemaResource) linkedList.removeFirst();
            } else {
                if (linkedList2.isEmpty()) {
                    return;
                }
                SchemaLocator schemaLocator = (SchemaLocator) linkedList2.removeFirst();
                schemaResourceLookupResource = lookupResource(schemaLocator.namespace, schemaLocator.schemaLocation);
                if (schemaResourceLookupResource == null) {
                }
            }
            if (!hashSet.contains(schemaResourceLookupResource)) {
                hashSet.add(schemaResourceLookupResource);
                SchemaDocument.Schema schema = schemaResourceLookupResource.getSchema();
                if (schema != null) {
                    String targetNamespace = schema.getTargetNamespace();
                    if (targetNamespace == null) {
                        targetNamespace = "";
                    }
                    String namespace = schemaResourceLookupResource.getNamespace();
                    if (namespace == null || !targetNamespace.equals(namespace)) {
                        reportActualNamespace(schemaResourceLookupResource, targetNamespace);
                    }
                    ImportDocument.Import[] importArray = schema.getImportArray();
                    for (int i = 0; i < importArray.length; i++) {
                        linkedList2.add(new SchemaLocator(importArray[i].getNamespace() == null ? "" : importArray[i].getNamespace(), importArray[i].getSchemaLocation()));
                    }
                    for (IncludeDocument.Include include : schema.getIncludeArray()) {
                        linkedList2.add(new SchemaLocator(null, include.getSchemaLocation()));
                    }
                }
            }
        }
    }

    private static class SchemaLocator {
        public final String namespace;
        public final String schemaLocation;

        public SchemaLocator(String str, String str2) {
            this.namespace = str;
            this.schemaLocation = str2;
        }
    }
}
