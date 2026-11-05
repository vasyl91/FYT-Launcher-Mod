package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.impl.values.JavaIntegerHolderEx;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.AllNNI;
import org.apache.xmlbeans.impl.xb.xsdschema.NarrowMaxMin;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class NarrowMaxMinImpl extends LocalElementImpl implements NarrowMaxMin {
    private static final long serialVersionUID = 1;

    public NarrowMaxMinImpl(SchemaType schemaType) {
        super(schemaType);
    }

    public static class MinOccursImpl extends JavaIntegerHolderEx implements NarrowMaxMin.MinOccurs {
        private static final long serialVersionUID = 1;

        public MinOccursImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected MinOccursImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }

    public static class MaxOccursImpl extends XmlUnionImpl implements NarrowMaxMin.MaxOccurs, XmlNonNegativeInteger, AllNNI.Member {
        private static final long serialVersionUID = 1;

        public MaxOccursImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected MaxOccursImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }
}
