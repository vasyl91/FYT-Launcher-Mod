package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.XmlListImpl;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.BlockSet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class BlockSetImpl extends XmlUnionImpl implements BlockSet, BlockSet.Member, BlockSet.Member2 {
    private static final long serialVersionUID = 1;

    public BlockSetImpl(SchemaType schemaType) {
        super(schemaType, false);
    }

    protected BlockSetImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }

    public static class MemberImpl extends JavaStringEnumerationHolderEx implements BlockSet.Member {
        private static final long serialVersionUID = 1;

        public MemberImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected MemberImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }

    public static class MemberImpl2 extends XmlListImpl implements BlockSet.Member2 {
        private static final long serialVersionUID = 1;

        public MemberImpl2(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected MemberImpl2(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }

        public static class ItemImpl extends JavaStringEnumerationHolderEx implements BlockSet.Member2.Item {
            private static final long serialVersionUID = 1;

            public ItemImpl(SchemaType schemaType) {
                super(schemaType, false);
            }

            protected ItemImpl(SchemaType schemaType, boolean z) {
                super(schemaType, z);
            }
        }
    }
}
