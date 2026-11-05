package org.apache.xmlbeans;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface SchemaGlobalAttribute extends SchemaLocalAttribute, SchemaComponent {
    Ref getRef();

    public static final class Ref extends SchemaComponent.Ref {
        @Override // org.apache.xmlbeans.SchemaComponent.Ref
        public final int getComponentType() {
            return 3;
        }

        public Ref(SchemaGlobalAttribute schemaGlobalAttribute) {
            super(schemaGlobalAttribute);
        }

        public Ref(SchemaTypeSystem schemaTypeSystem, String str) {
            super(schemaTypeSystem, str);
        }

        public final SchemaGlobalAttribute get() {
            return (SchemaGlobalAttribute) getComponent();
        }
    }
}
