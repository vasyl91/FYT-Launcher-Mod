package org.apache.xmlbeans.impl.values;

import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.ValidatorListener;
import org.apache.xmlbeans.impl.common.XmlLocale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface TypeStore extends NamespaceManager {
    public static final int FIXED = 4;
    public static final int HASDEFAULT = 2;
    public static final int NILLABLE = 1;
    public static final int WS_COLLAPSE = 3;
    public static final int WS_PRESERVE = 1;
    public static final int WS_REPLACE = 2;
    public static final int WS_UNSPECIFIED = 0;

    TypeStoreUser add_attribute_user(QName qName);

    TypeStoreUser add_element_user(QName qName);

    void array_setter(XmlObject[] xmlObjectArr, QName qName);

    TypeStoreUser change_type(SchemaType schemaType);

    String compute_default_text();

    int compute_flags();

    TypeStoreUser copy(SchemaTypeLoader schemaTypeLoader, SchemaType schemaType, XmlOptions xmlOptions);

    TypeStoreUser copy_contents_from(TypeStore typeStore);

    int count_elements(QName qName);

    int count_elements(QNameSet qNameSet);

    XmlObject[] exec_query(String str, XmlOptions xmlOptions) throws XmlException;

    String fetch_text(int i);

    void find_all_element_users(QName qName, List list);

    void find_all_element_users(QNameSet qNameSet, List list);

    TypeStoreUser find_attribute_user(QName qName);

    TypeStoreUser find_element_user(QName qName, int i);

    TypeStoreUser find_element_user(QNameSet qNameSet, int i);

    boolean find_nil();

    XmlLocale get_locale();

    Object get_root_object();

    SchemaField get_schema_field();

    SchemaTypeLoader get_schematypeloader();

    QName get_xsi_type();

    TypeStoreUser insert_element_user(QName qName, int i);

    TypeStoreUser insert_element_user(QNameSet qNameSet, QName qName, int i);

    void invalidate_nil();

    void invalidate_text();

    boolean is_attribute();

    XmlCursor new_cursor();

    void remove_attribute(QName qName);

    void remove_element(QName qName, int i);

    void remove_element(QNameSet qNameSet, int i);

    void store_text(String str);

    TypeStoreUser substitute(QName qName, SchemaType schemaType);

    void validate(ValidatorListener validatorListener);

    boolean validate_on_set();

    void visit_elements(TypeStoreVisitor typeStoreVisitor);
}
