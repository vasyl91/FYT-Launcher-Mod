package org.apache.xmlbeans;

import javax.xml.namespace.QName;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface SchemaGlobalElement extends SchemaLocalElement, SchemaComponent {
    boolean finalExtension();

    boolean finalRestriction();

    Ref getRef();

    SchemaGlobalElement substitutionGroup();

    QName[] substitutionGroupMembers();

    public static final class Ref extends SchemaComponent.Ref {
        @Override // org.apache.xmlbeans.SchemaComponent.Ref
        public final int getComponentType() {
            return 1;
        }

        public Ref(SchemaGlobalElement schemaGlobalElement) {
            super(schemaGlobalElement);
        }

        public Ref(SchemaTypeSystem schemaTypeSystem, String str) {
            super(schemaTypeSystem, str);
        }

        public final SchemaGlobalElement get() {
            return (SchemaGlobalElement) getComponent();
        }
    }
}
