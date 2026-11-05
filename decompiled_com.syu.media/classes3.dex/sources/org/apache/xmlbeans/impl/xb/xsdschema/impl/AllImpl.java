package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.impl.values.JavaIntegerHolderEx;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.apache.xmlbeans.impl.xb.xsdschema.AllNNI;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class AllImpl extends ExplicitGroupImpl implements All {
    private static final long serialVersionUID = 1;

    public AllImpl(SchemaType schemaType) {
        super(schemaType);
    }

    public static class MinOccursImpl extends JavaIntegerHolderEx implements All.MinOccurs {
        private static final long serialVersionUID = 1;

        public MinOccursImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected MinOccursImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }

    public static class MaxOccursImpl extends XmlUnionImpl implements All.MaxOccurs, XmlNonNegativeInteger, AllNNI.Member {
        private static final long serialVersionUID = 1;

        public MaxOccursImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected MaxOccursImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }
}
