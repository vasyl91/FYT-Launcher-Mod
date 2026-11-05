package org.apache.xmlbeans.impl.values;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaField;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface TypeStoreVisitor {
    String get_default_text();

    int get_elementflags();

    SchemaField get_schema_field();

    boolean visit(QName qName);
}
