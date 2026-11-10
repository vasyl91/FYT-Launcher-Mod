package org.apache.xmlbeans.impl.values;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface TypeStoreUser {
    void attach_store(TypeStore typeStore);

    boolean build_nil();

    String build_text(NamespaceManager namespaceManager);

    TypeStoreUser create_attribute_user(QName qName);

    TypeStoreUser create_element_user(QName qName, QName qName2);

    void disconnect_store();

    SchemaField get_attribute_field(QName qName);

    SchemaType get_attribute_type(QName qName);

    int get_attributeflags(QName qName);

    String get_default_attribute_text(QName qName);

    String get_default_element_text(QName qName);

    QNameSet get_element_ending_delimiters(QName qName);

    SchemaType get_element_type(QName qName, QName qName2);

    int get_elementflags(QName qName);

    SchemaType get_schema_type();

    TypeStore get_store();

    void invalidate_element_order();

    void invalidate_nilvalue();

    void invalidate_value();

    boolean is_child_element_order_sensitive();

    TypeStoreVisitor new_visitor();

    boolean uses_invalidate_value();

    void validate_now();
}
