package org.apache.xmlbeans;

import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface SchemaIdentityConstraint extends SchemaComponent, SchemaAnnotated {
    public static final int CC_KEY = 1;
    public static final int CC_KEYREF = 2;
    public static final int CC_UNIQUE = 3;

    int getConstraintCategory();

    Object getFieldPath(int i);

    String[] getFields();

    Map getNSMap();

    SchemaIdentityConstraint getReferencedKey();

    String getSelector();

    Object getSelectorPath();

    Object getUserData();

    public static final class Ref extends SchemaComponent.Ref {
        @Override // org.apache.xmlbeans.SchemaComponent.Ref
        public final int getComponentType() {
            return 5;
        }

        public Ref(SchemaIdentityConstraint schemaIdentityConstraint) {
            super(schemaIdentityConstraint);
        }

        public Ref(SchemaTypeSystem schemaTypeSystem, String str) {
            super(schemaTypeSystem, str);
        }

        public final SchemaIdentityConstraint get() {
            return (SchemaIdentityConstraint) getComponent();
        }
    }
}
