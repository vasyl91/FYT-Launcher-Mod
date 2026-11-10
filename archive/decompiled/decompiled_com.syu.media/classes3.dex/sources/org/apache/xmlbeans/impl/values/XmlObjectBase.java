package org.apache.xmlbeans.impl.values;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.DelegateXmlObject;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDateSpecification;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.GDurationSpecification;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlRuntimeException;
import org.apache.xmlbeans.impl.common.GlobalLock;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.common.XmlErrorWatcher;
import org.apache.xmlbeans.impl.common.XmlLocale;
import org.apache.xmlbeans.impl.common.XmlWhitespace;
import org.apache.xmlbeans.impl.schema.SchemaTypeImpl;
import org.apache.xmlbeans.impl.schema.SchemaTypeVisitorImpl;
import org.apache.xmlbeans.impl.validator.Validator;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class XmlObjectBase implements TypeStoreUser, Serializable, XmlObject, SimpleValue {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int FLAGS_DATED = 672;
    private static final int FLAGS_ELEMENT = 7;
    private static final int FLAG_ATTRIBUTE = 8;
    private static final int FLAG_COMPLEXCONTENT = 16384;
    private static final int FLAG_COMPLEXTYPE = 8192;
    private static final int FLAG_ELEMENT_DATED = 512;
    private static final int FLAG_FIXED = 4;
    private static final int FLAG_HASDEFAULT = 2;
    private static final int FLAG_IMMUTABLE = 4096;
    private static final int FLAG_ISDEFAULT = 256;
    private static final int FLAG_NIL = 64;
    private static final int FLAG_NILLABLE = 1;
    private static final int FLAG_NIL_DATED = 128;
    private static final int FLAG_NOT_VARIABLE = 32768;
    private static final int FLAG_ORPHANED = 2048;
    private static final int FLAG_SETTINGDEFAULT = 1024;
    private static final int FLAG_STORE = 16;
    private static final int FLAG_VALIDATE_ON_SET = 65536;
    private static final int FLAG_VALUE_DATED = 32;
    public static final short KIND_SETTERHELPER_ARRAYITEM = 2;
    public static final short KIND_SETTERHELPER_SINGLETON = 1;
    public static final short MAJOR_VERSION_NUMBER = 1;
    public static final short MINOR_VERSION_NUMBER = 1;
    private int _flags = 65;
    private Object _textsource;
    public static final ValidationContext _voorVc = new ValueOutOfRangeValidationContext();
    private static final BigInteger _max = BigInteger.valueOf(Long.MAX_VALUE);
    private static final BigInteger _min = BigInteger.valueOf(Long.MIN_VALUE);
    private static final XmlOptions _toStringOptions = buildInnerPrettyOptions();
    private static final XmlObject[] EMPTY_RESULT = new XmlObject[0];

    protected abstract String compute_text(NamespaceManager namespaceManager);

    protected abstract boolean equal_to(XmlObject xmlObject);

    protected int get_wscanon_rule() {
        return 3;
    }

    protected boolean is_defaultable_ws(String str) {
        return true;
    }

    public abstract SchemaType schemaType();

    protected abstract void set_nil();

    protected abstract void set_text(String str);

    protected void validate_simpleval(String str, ValidationContext validationContext) {
    }

    protected abstract int value_hash_code();

    public final Object monitor() {
        return has_store() ? get_store().get_locale() : this;
    }

    private static XmlObjectBase underlying(XmlObject xmlObject) {
        if (xmlObject == null) {
            return null;
        }
        if (xmlObject instanceof XmlObjectBase) {
            return (XmlObjectBase) xmlObject;
        }
        while (xmlObject instanceof DelegateXmlObject) {
            xmlObject = ((DelegateXmlObject) xmlObject).underlyingXmlObject();
        }
        if (xmlObject instanceof XmlObjectBase) {
            return (XmlObjectBase) xmlObject;
        }
        throw new IllegalStateException("Non-native implementations of XmlObject should extend FilterXmlObject or implement DelegateXmlObject");
    }

    public final XmlObject copy() {
        XmlObject xmlObject_copy;
        if (preCheck()) {
            return _copy();
        }
        synchronized (monitor()) {
            xmlObject_copy = _copy();
        }
        return xmlObject_copy;
    }

    public final XmlObject copy(XmlOptions xmlOptions) {
        XmlObject xmlObject_copy;
        if (preCheck()) {
            return _copy(xmlOptions);
        }
        synchronized (monitor()) {
            xmlObject_copy = _copy(xmlOptions);
        }
        return xmlObject_copy;
    }

    private boolean preCheck() {
        return has_store() ? get_store().get_locale().noSync() : $assertionsDisabled;
    }

    public final XmlObject _copy() {
        return _copy(null);
    }

    public final XmlObject _copy(XmlOptions xmlOptions) {
        if (isImmutable()) {
            return this;
        }
        check_orphaned();
        return get_store().copy(get_store().get_schematypeloader(), schemaType(), xmlOptions);
    }

    public XmlDocumentProperties documentProperties() {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            return xmlCursorNewCursorForce.documentProperties();
        } finally {
            xmlCursorNewCursorForce.dispose();
        }
    }

    public XMLInputStream newXMLInputStream() {
        return newXMLInputStream(null);
    }

    public XMLInputStream newXMLInputStream(XmlOptions xmlOptions) {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            return xmlCursorNewCursorForce.newXMLInputStream(makeInnerOptions(xmlOptions));
        } finally {
            xmlCursorNewCursorForce.dispose();
        }
    }

    public XMLStreamReader newXMLStreamReader() {
        return newXMLStreamReader(null);
    }

    public XMLStreamReader newXMLStreamReader(XmlOptions xmlOptions) {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            return xmlCursorNewCursorForce.newXMLStreamReader(makeInnerOptions(xmlOptions));
        } finally {
            xmlCursorNewCursorForce.dispose();
        }
    }

    public InputStream newInputStream() {
        return newInputStream(null);
    }

    public InputStream newInputStream(XmlOptions xmlOptions) {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            return xmlCursorNewCursorForce.newInputStream(makeInnerOptions(xmlOptions));
        } finally {
            xmlCursorNewCursorForce.dispose();
        }
    }

    public Reader newReader() {
        return newReader(null);
    }

    public Reader newReader(XmlOptions xmlOptions) {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            return xmlCursorNewCursorForce.newReader(makeInnerOptions(xmlOptions));
        } finally {
            xmlCursorNewCursorForce.dispose();
        }
    }

    public Node getDomNode() {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            return xmlCursorNewCursorForce.getDomNode();
        } finally {
            xmlCursorNewCursorForce.dispose();
        }
    }

    public Node newDomNode() {
        return newDomNode(null);
    }

    public Node newDomNode(XmlOptions xmlOptions) {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            return xmlCursorNewCursorForce.newDomNode(makeInnerOptions(xmlOptions));
        } finally {
            xmlCursorNewCursorForce.dispose();
        }
    }

    public void save(ContentHandler contentHandler, LexicalHandler lexicalHandler, XmlOptions xmlOptions) throws SAXException {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            xmlCursorNewCursorForce.save(contentHandler, lexicalHandler, makeInnerOptions(xmlOptions));
        } finally {
            xmlCursorNewCursorForce.dispose();
        }
    }

    public void save(File file, XmlOptions xmlOptions) throws IOException {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            xmlCursorNewCursorForce.save(file, makeInnerOptions(xmlOptions));
        } finally {
            xmlCursorNewCursorForce.dispose();
        }
    }

    public void save(OutputStream outputStream, XmlOptions xmlOptions) throws IOException {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            xmlCursorNewCursorForce.save(outputStream, makeInnerOptions(xmlOptions));
        } finally {
            xmlCursorNewCursorForce.dispose();
        }
    }

    public void save(Writer writer, XmlOptions xmlOptions) throws IOException {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            xmlCursorNewCursorForce.save(writer, makeInnerOptions(xmlOptions));
        } finally {
            xmlCursorNewCursorForce.dispose();
        }
    }

    public void save(ContentHandler contentHandler, LexicalHandler lexicalHandler) throws SAXException {
        save(contentHandler, lexicalHandler, null);
    }

    public void save(File file) throws IOException {
        save(file, (XmlOptions) null);
    }

    public void save(OutputStream outputStream) throws IOException {
        save(outputStream, (XmlOptions) null);
    }

    public void save(Writer writer) throws IOException {
        save(writer, (XmlOptions) null);
    }

    public void dump() {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            xmlCursorNewCursorForce.dump();
        } finally {
            xmlCursorNewCursorForce.dispose();
        }
    }

    public XmlCursor newCursorForce() {
        XmlCursor xmlCursorNewCursor;
        synchronized (monitor()) {
            xmlCursorNewCursor = ensureStore().newCursor();
        }
        return xmlCursorNewCursor;
    }

    private XmlObject ensureStore() {
        String strCompute_text;
        if ((this._flags & 16) != 0) {
            return this;
        }
        check_dated();
        if ((this._flags & 64) != 0) {
            strCompute_text = "";
        } else {
            strCompute_text = compute_text(has_store() ? get_store() : null);
        }
        XmlObject xmlObjectNewInstance = XmlObject.Factory.newInstance(new XmlOptions().setDocumentType(schemaType()));
        XmlCursor xmlCursorNewCursor = xmlObjectNewInstance.newCursor();
        xmlCursorNewCursor.toNextToken();
        xmlCursorNewCursor.insertChars(strCompute_text);
        return xmlObjectNewInstance;
    }

    private static XmlOptions makeInnerOptions(XmlOptions xmlOptions) {
        XmlOptions xmlOptions2 = new XmlOptions(xmlOptions);
        xmlOptions2.put("SAVE_INNER");
        return xmlOptions2;
    }

    public XmlCursor newCursor() {
        XmlCursor xmlCursorNew_cursor;
        if ((this._flags & 16) == 0) {
            throw new IllegalStateException("XML Value Objects cannot create cursors");
        }
        check_orphaned();
        XmlLocale xmlLocale = getXmlLocale();
        if (xmlLocale.noSync()) {
            xmlLocale.enter();
            try {
                return get_store().new_cursor();
            } finally {
                xmlLocale.exit();
            }
        }
        synchronized (xmlLocale) {
            xmlLocale.enter();
            try {
                xmlCursorNew_cursor = get_store().new_cursor();
                xmlLocale.exit();
            } catch (Throwable th) {
                xmlLocale.exit();
                throw th;
            }
        }
        return xmlCursorNew_cursor;
    }

    public SchemaType instanceType() {
        SchemaType schemaType;
        synchronized (monitor()) {
            schemaType = isNil() ? null : schemaType();
        }
        return schemaType;
    }

    private SchemaField schemaField() {
        SchemaField containerField = schemaType().getContainerField();
        return containerField == null ? get_store().get_schema_field() : containerField;
    }

    private static final class ValueOutOfRangeValidationContext implements ValidationContext {
        private ValueOutOfRangeValidationContext() {
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str) {
            throw new XmlValueOutOfRangeException(str);
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str, Object[] objArr) {
            throw new XmlValueOutOfRangeException(str, objArr);
        }
    }

    private static final class ImmutableValueValidationContext implements ValidationContext {
        private Collection _coll;
        private XmlObject _loc;

        ImmutableValueValidationContext(Collection collection, XmlObject xmlObject) {
            this._coll = collection;
            this._loc = xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str) {
            this._coll.add(XmlError.forObject(str, this._loc));
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str, Object[] objArr) {
            this._coll.add(XmlError.forObject(str, objArr, this._loc));
        }
    }

    public boolean validate() {
        return validate(null);
    }

    public boolean validate(XmlOptions xmlOptions) {
        boolean zIsValid;
        int i = this._flags;
        if ((i & 16) == 0) {
            if ((i & 4096) != 0) {
                return validate_immutable(xmlOptions);
            }
            throw new IllegalStateException("XML objects with no underlying store cannot be validated");
        }
        synchronized (monitor()) {
            if ((this._flags & 2048) != 0) {
                throw new XmlValueDisconnectedException();
            }
            SchemaField schemaField = schemaField();
            SchemaType schemaType = schemaType();
            TypeStore typeStore = get_store();
            Validator validator = new Validator(schemaType, schemaField, typeStore.get_schematypeloader(), xmlOptions, null);
            typeStore.validate(validator);
            zIsValid = validator.isValid();
        }
        return zIsValid;
    }

    private boolean validate_immutable(XmlOptions xmlOptions) {
        XmlErrorWatcher xmlErrorWatcher = new XmlErrorWatcher(xmlOptions == null ? null : (Collection) xmlOptions.get("ERROR_LISTENER"));
        if (!schemaType().isSimpleType() && (xmlOptions == null || !xmlOptions.hasOption("VALIDATE_TEXT_ONLY"))) {
            SchemaProperty[] properties = schemaType().getProperties();
            for (int i = 0; i < properties.length; i++) {
                if (properties[i].getMinOccurs().signum() > 0) {
                    if (properties[i].isAttribute()) {
                        xmlErrorWatcher.add(XmlError.forObject("cvc-complex-type.4", new Object[]{QNameHelper.pretty(properties[i].getName())}, this));
                    } else {
                        xmlErrorWatcher.add(XmlError.forObject("cvc-complex-type.2.4c", new Object[]{properties[i].getMinOccurs(), QNameHelper.pretty(properties[i].getName())}, this));
                    }
                }
            }
            if (schemaType().getContentType() != 2) {
                return !xmlErrorWatcher.hasError();
            }
        }
        String str = (String) this._textsource;
        if (str == null) {
            str = "";
        }
        validate_simpleval(str, new ImmutableValueValidationContext(xmlErrorWatcher, this));
        return !xmlErrorWatcher.hasError();
    }

    private static XmlObject[] _typedArray(XmlObject[] xmlObjectArr) {
        if (xmlObjectArr.length == 0) {
            return xmlObjectArr;
        }
        SchemaType schemaType = xmlObjectArr[0].schemaType();
        if (schemaType.equals(XmlObject.type) || schemaType.isNoType()) {
            return xmlObjectArr;
        }
        for (int i = 1; i < xmlObjectArr.length; i++) {
            if (xmlObjectArr[i].schemaType().isNoType()) {
                return xmlObjectArr;
            }
            schemaType = schemaType.getCommonBaseType(xmlObjectArr[i].schemaType());
            if (schemaType.equals(XmlObject.type)) {
                return xmlObjectArr;
            }
        }
        Class javaClass = schemaType.getJavaClass();
        while (javaClass == null) {
            schemaType = schemaType.getBaseType();
            if (XmlObject.type.equals(schemaType)) {
                return xmlObjectArr;
            }
            javaClass = schemaType.getJavaClass();
        }
        XmlObject[] xmlObjectArr2 = (XmlObject[]) Array.newInstance((Class<?>) javaClass, xmlObjectArr.length);
        System.arraycopy(xmlObjectArr, 0, xmlObjectArr2, 0, xmlObjectArr.length);
        return xmlObjectArr2;
    }

    public XmlObject[] selectPath(String str) {
        return selectPath(str, null);
    }

    public XmlObject[] selectPath(String str, XmlOptions xmlOptions) {
        XmlObject[] xmlObjectArr;
        XmlCursor xmlCursorNewCursor = newCursor();
        if (xmlCursorNewCursor == null) {
            throw new XmlValueDisconnectedException();
        }
        try {
            xmlCursorNewCursor.selectPath(str, xmlOptions);
            if (!xmlCursorNewCursor.hasNextSelection()) {
                xmlObjectArr = EMPTY_RESULT;
            } else {
                xmlObjectArr = new XmlObject[xmlCursorNewCursor.getSelectionCount()];
                int i = 0;
                while (xmlCursorNewCursor.toNextSelection()) {
                    XmlObject object = xmlCursorNewCursor.getObject();
                    xmlObjectArr[i] = object;
                    if (object == null) {
                        if (xmlCursorNewCursor.toParent()) {
                            XmlObject object2 = xmlCursorNewCursor.getObject();
                            xmlObjectArr[i] = object2;
                            if (object2 != null) {
                            }
                        }
                        throw new XmlRuntimeException("Path must select only elements and attributes");
                    }
                    i++;
                }
            }
            xmlCursorNewCursor.dispose();
            return _typedArray(xmlObjectArr);
        } catch (Throwable th) {
            xmlCursorNewCursor.dispose();
            throw th;
        }
    }

    public XmlObject[] execQuery(String str) {
        return execQuery(str, null);
    }

    public XmlObject[] execQuery(String str, XmlOptions xmlOptions) {
        XmlObject[] xmlObjectArr_typedArray;
        synchronized (monitor()) {
            TypeStore typeStore = get_store();
            if (typeStore == null) {
                throw new XmlRuntimeException("Cannot do XQuery on XML Value Objects");
            }
            try {
                xmlObjectArr_typedArray = _typedArray(typeStore.exec_query(str, xmlOptions));
            } catch (XmlException e) {
                throw new XmlRuntimeException(e);
            }
        }
        return xmlObjectArr_typedArray;
    }

    public XmlObject changeType(SchemaType schemaType) {
        XmlObject xmlObjectChange_type;
        if (schemaType == null) {
            throw new IllegalArgumentException("Invalid type (null)");
        }
        if ((this._flags & 16) == 0) {
            throw new IllegalStateException("XML Value Objects cannot have thier type changed");
        }
        synchronized (monitor()) {
            check_orphaned();
            xmlObjectChange_type = get_store().change_type(schemaType);
        }
        return xmlObjectChange_type;
    }

    public XmlObject substitute(QName qName, SchemaType schemaType) {
        XmlObject xmlObjectSubstitute;
        if (qName == null) {
            throw new IllegalArgumentException("Invalid name (null)");
        }
        if (schemaType == null) {
            throw new IllegalArgumentException("Invalid type (null)");
        }
        if ((this._flags & 16) == 0) {
            throw new IllegalStateException("XML Value Objects cannot be used with substitution");
        }
        synchronized (monitor()) {
            check_orphaned();
            xmlObjectSubstitute = get_store().substitute(qName, schemaType);
        }
        return xmlObjectSubstitute;
    }

    protected XmlObjectBase() {
    }

    public void init_flags(SchemaProperty schemaProperty) {
        if (schemaProperty == null) {
            return;
        }
        if (schemaProperty.hasDefault() == 1 || schemaProperty.hasFixed() == 1 || schemaProperty.hasNillable() == 1) {
            return;
        }
        int i = this._flags & (-8);
        this._flags = i;
        this._flags = (schemaProperty.hasDefault() == 0 ? 0 : 2) | (schemaProperty.hasFixed() == 0 ? 0 : 4) | (schemaProperty.hasNillable() == 0 ? 0 : 1) | FLAG_NOT_VARIABLE | i;
    }

    protected void initComplexType(boolean z, boolean z2) {
        this._flags = (z ? 8192 : 0) | (z2 ? FLAG_COMPLEXCONTENT : 0) | this._flags;
    }

    protected boolean _isComplexType() {
        if ((this._flags & 8192) != 0) {
            return true;
        }
        return $assertionsDisabled;
    }

    protected boolean _isComplexContent() {
        if ((this._flags & FLAG_COMPLEXCONTENT) != 0) {
            return true;
        }
        return $assertionsDisabled;
    }

    public void setValidateOnSet() {
        this._flags |= FLAG_VALIDATE_ON_SET;
    }

    protected boolean _validateOnSet() {
        if ((this._flags & FLAG_VALIDATE_ON_SET) != 0) {
            return true;
        }
        return $assertionsDisabled;
    }

    public final boolean isNil() {
        boolean z;
        synchronized (monitor()) {
            check_dated();
            z = (this._flags & 64) != 0 ? true : $assertionsDisabled;
        }
        return z;
    }

    public final boolean isFixed() {
        check_element_dated();
        if ((this._flags & 4) != 0) {
            return true;
        }
        return $assertionsDisabled;
    }

    public final boolean isNillable() {
        check_element_dated();
        if ((this._flags & 1) != 0) {
            return true;
        }
        return $assertionsDisabled;
    }

    public final boolean isDefaultable() {
        check_element_dated();
        if ((this._flags & 2) != 0) {
            return true;
        }
        return $assertionsDisabled;
    }

    public final boolean isDefault() {
        check_dated();
        if ((this._flags & 256) != 0) {
            return true;
        }
        return $assertionsDisabled;
    }

    public final void setNil() {
        synchronized (monitor()) {
            set_prepare();
            int i = this._flags;
            if ((i & 1) == 0 && (i & FLAG_VALIDATE_ON_SET) != 0) {
                throw new XmlValueNotNillableException();
            }
            set_nil();
            int i2 = this._flags | 64;
            this._flags = i2;
            if ((i2 & 16) != 0) {
                get_store().invalidate_text();
                this._flags &= -673;
                get_store().invalidate_nil();
            } else {
                this._textsource = null;
            }
        }
    }

    protected int elementFlags() {
        check_element_dated();
        return this._flags & 7;
    }

    public void setImmutable() {
        int i = this._flags;
        if ((i & 4112) != 0) {
            throw new IllegalStateException();
        }
        this._flags = i | 4096;
    }

    public boolean isImmutable() {
        if ((this._flags & 4096) != 0) {
            return true;
        }
        return $assertionsDisabled;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final void attach_store(TypeStore typeStore) {
        this._textsource = typeStore;
        int i = this._flags;
        if ((i & 4096) != 0) {
            throw new IllegalStateException();
        }
        this._flags = i | 688;
        if (typeStore.is_attribute()) {
            this._flags |= 8;
        }
        if (typeStore.validate_on_set()) {
            this._flags |= FLAG_VALIDATE_ON_SET;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final void invalidate_value() {
        this._flags |= 32;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final boolean uses_invalidate_value() {
        SchemaType schemaType = schemaType();
        if (schemaType.isSimpleType() || schemaType.getContentType() == 2) {
            return true;
        }
        return $assertionsDisabled;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final void invalidate_nilvalue() {
        this._flags |= STShapeType.INT_FLOW_CHART_OFFPAGE_CONNECTOR;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final void invalidate_element_order() {
        this._flags |= FLAGS_DATED;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final TypeStore get_store() {
        return (TypeStore) this._textsource;
    }

    public final XmlLocale getXmlLocale() {
        return get_store().get_locale();
    }

    protected final boolean has_store() {
        if ((this._flags & 16) != 0) {
            return true;
        }
        return $assertionsDisabled;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final String build_text(NamespaceManager namespaceManager) {
        if ((this._flags & 320) != 0) {
            return "";
        }
        if (namespaceManager == null) {
            namespaceManager = has_store() ? get_store() : null;
        }
        return compute_text(namespaceManager);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public boolean build_nil() {
        if ((this._flags & 64) != 0) {
            return true;
        }
        return $assertionsDisabled;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public void validate_now() {
        check_dated();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public void disconnect_store() {
        this._flags |= 2720;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public TypeStoreUser create_element_user(QName qName, QName qName2) {
        return ((SchemaTypeImpl) schemaType()).createElementType(qName, qName2, get_store().get_schematypeloader());
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public TypeStoreUser create_attribute_user(QName qName) {
        return ((SchemaTypeImpl) schemaType()).createAttributeType(qName, get_store().get_schematypeloader());
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public SchemaType get_schema_type() {
        return schemaType();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public SchemaType get_element_type(QName qName, QName qName2) {
        return schemaType().getElementType(qName, qName2, get_store().get_schematypeloader());
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public SchemaType get_attribute_type(QName qName) {
        return schemaType().getAttributeType(qName, get_store().get_schematypeloader());
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public String get_default_element_text(QName qName) {
        if (!_isComplexContent()) {
            throw new IllegalStateException();
        }
        SchemaProperty elementProperty = schemaType().getElementProperty(qName);
        return elementProperty == null ? "" : elementProperty.getDefaultText();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public String get_default_attribute_text(QName qName) {
        if (!_isComplexType()) {
            throw new IllegalStateException();
        }
        SchemaProperty attributeProperty = schemaType().getAttributeProperty(qName);
        return attributeProperty == null ? "" : attributeProperty.getDefaultText();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public int get_elementflags(QName qName) {
        SchemaProperty elementProperty;
        if (!_isComplexContent() || (elementProperty = schemaType().getElementProperty(qName)) == null) {
            return 0;
        }
        if (elementProperty.hasDefault() == 1 || elementProperty.hasFixed() == 1 || elementProperty.hasNillable() == 1) {
            return -1;
        }
        return (elementProperty.hasDefault() == 0 ? 0 : 2) | (elementProperty.hasFixed() == 0 ? 0 : 4) | (elementProperty.hasNillable() != 0 ? 1 : 0);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public int get_attributeflags(QName qName) {
        SchemaProperty attributeProperty;
        if (_isComplexType() && (attributeProperty = schemaType().getAttributeProperty(qName)) != null) {
            return (attributeProperty.hasDefault() == 0 ? 0 : 2) | (attributeProperty.hasFixed() != 0 ? 4 : 0);
        }
        return 0;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public boolean is_child_element_order_sensitive() {
        return !_isComplexType() ? $assertionsDisabled : schemaType().isOrderSensitive();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final QNameSet get_element_ending_delimiters(QName qName) {
        SchemaProperty elementProperty = schemaType().getElementProperty(qName);
        if (elementProperty == null) {
            return null;
        }
        return elementProperty.getJavaSetterDelimiter();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public TypeStoreVisitor new_visitor() {
        if (_isComplexContent()) {
            return new SchemaTypeVisitorImpl(schemaType().getContentModel());
        }
        return null;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public SchemaField get_attribute_field(QName qName) {
        SchemaAttributeModel attributeModel = schemaType().getAttributeModel();
        if (attributeModel == null) {
            return null;
        }
        return attributeModel.getAttribute(qName);
    }

    protected void set_String(String str) {
        int i = this._flags;
        if ((i & 4096) != 0) {
            throw new IllegalStateException();
        }
        boolean z = (i & 64) != 0 ? true : $assertionsDisabled;
        update_from_wscanon_text(apply_wscanon(str));
        int i2 = this._flags;
        if ((i2 & 16) != 0) {
            int i3 = i2 & (-33);
            this._flags = i3;
            if ((i3 & 1024) == 0) {
                get_store().store_text(str);
            }
            if (z) {
                get_store().invalidate_nil();
                return;
            }
            return;
        }
        this._textsource = str;
    }

    protected void update_from_complex_content() {
        throw new XmlValueNotSupportedException("Complex content");
    }

    private final void update_from_wscanon_text(String str) {
        int i = this._flags;
        if ((i & 2) != 0 && (i & 1024) == 0 && (i & 8) == 0 && str.equals("")) {
            String strCompute_default_text = get_store().compute_default_text();
            if (strCompute_default_text == null) {
                throw new XmlValueOutOfRangeException();
            }
            this._flags |= 1024;
            try {
                setStringValue(strCompute_default_text);
                this._flags = (this._flags & (-1025) & (-65)) | 256;
                return;
            } catch (Throwable th) {
                this._flags &= -1025;
                throw th;
            }
        }
        set_text(str);
        this._flags &= -321;
    }

    private final String apply_wscanon(String str) {
        return XmlWhitespace.collapse(str, get_wscanon_rule());
    }

    private final void check_element_dated() {
        int i = this._flags;
        if ((i & 512) != 0 && (i & FLAG_NOT_VARIABLE) == 0) {
            if ((i & 2048) != 0) {
                throw new XmlValueDisconnectedException();
            }
            this._flags = get_store().compute_flags() | (this._flags & (-520));
        }
        int i2 = this._flags;
        if ((i2 & FLAG_NOT_VARIABLE) != 0) {
            this._flags = i2 & (-513);
        }
    }

    protected final boolean is_orphaned() {
        if ((this._flags & 2048) != 0) {
            return true;
        }
        return $assertionsDisabled;
    }

    protected final void check_orphaned() {
        if (is_orphaned()) {
            throw new XmlValueDisconnectedException();
        }
    }

    public final void check_dated() {
        String str;
        int i = this._flags;
        if ((i & FLAGS_DATED) != 0) {
            if ((i & 2048) != 0) {
                throw new XmlValueDisconnectedException();
            }
            check_element_dated();
            if ((this._flags & 512) != 0) {
                this._flags = get_store().compute_flags() | (this._flags & (-520));
            }
            int i2 = this._flags & 128;
            boolean z = $assertionsDisabled;
            if (i2 != 0) {
                if (get_store().find_nil()) {
                    int i3 = this._flags;
                    if ((i3 & 1) == 0 && (i3 & FLAG_VALIDATE_ON_SET) != 0) {
                        throw new XmlValueOutOfRangeException();
                    }
                    set_nil();
                    this._flags |= 64;
                    z = true;
                } else {
                    this._flags &= -65;
                }
                this._flags &= -129;
            }
            if (!z) {
                if ((this._flags & FLAG_COMPLEXCONTENT) != 0 || (str = get_wscanon_text()) == null) {
                    update_from_complex_content();
                } else {
                    NamespaceContext.push(new NamespaceContext(get_store()));
                    try {
                        update_from_wscanon_text(str);
                        NamespaceContext.pop();
                    } catch (Throwable th) {
                        NamespaceContext.pop();
                        throw th;
                    }
                }
            }
            this._flags &= -33;
        }
    }

    private final void set_prepare() {
        check_element_dated();
        if ((this._flags & 4096) != 0) {
            throw new IllegalStateException();
        }
    }

    private final void set_commit() {
        int i = this._flags;
        boolean z = (i & 64) != 0 ? true : $assertionsDisabled;
        int i2 = i & (-321);
        this._flags = i2;
        if ((i2 & 16) != 0) {
            this._flags = i2 & (-673);
            get_store().invalidate_text();
            if (z) {
                get_store().invalidate_nil();
                return;
            }
            return;
        }
        this._textsource = null;
    }

    public final String get_wscanon_text() {
        if ((this._flags & 16) == 0) {
            return apply_wscanon((String) this._textsource);
        }
        return get_store().fetch_text(get_wscanon_rule());
    }

    public float getFloatValue() {
        BigDecimal bigDecimalValue = getBigDecimalValue();
        if (bigDecimalValue == null) {
            return 0.0f;
        }
        return bigDecimalValue.floatValue();
    }

    public double getDoubleValue() {
        BigDecimal bigDecimalValue = getBigDecimalValue();
        if (bigDecimalValue == null) {
            return 0.0d;
        }
        return bigDecimalValue.doubleValue();
    }

    public BigDecimal getBigDecimalValue() {
        throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[]{getPrimitiveTypeName(), "numeric"});
    }

    public BigInteger getBigIntegerValue() {
        BigDecimal bigDecimalBigDecimalValue = bigDecimalValue();
        if (bigDecimalBigDecimalValue == null) {
            return null;
        }
        return bigDecimalBigDecimalValue.toBigInteger();
    }

    public byte getByteValue() {
        long intValue = getIntValue();
        if (intValue > 127) {
            throw new XmlValueOutOfRangeException();
        }
        if (intValue >= -128) {
            return (byte) intValue;
        }
        throw new XmlValueOutOfRangeException();
    }

    public short getShortValue() {
        long intValue = getIntValue();
        if (intValue > 32767) {
            throw new XmlValueOutOfRangeException();
        }
        if (intValue >= -32768) {
            return (short) intValue;
        }
        throw new XmlValueOutOfRangeException();
    }

    public int getIntValue() {
        long longValue = getLongValue();
        if (longValue > 2147483647L) {
            throw new XmlValueOutOfRangeException();
        }
        if (longValue >= -2147483648L) {
            return (int) longValue;
        }
        throw new XmlValueOutOfRangeException();
    }

    public long getLongValue() {
        BigInteger bigIntegerValue = getBigIntegerValue();
        if (bigIntegerValue == null) {
            return 0L;
        }
        if (bigIntegerValue.compareTo(_max) >= 0) {
            throw new XmlValueOutOfRangeException();
        }
        if (bigIntegerValue.compareTo(_min) <= 0) {
            throw new XmlValueOutOfRangeException();
        }
        return bigIntegerValue.longValue();
    }

    static final XmlOptions buildInnerPrettyOptions() {
        XmlOptions xmlOptions = new XmlOptions();
        xmlOptions.put("SAVE_INNER");
        xmlOptions.put("SAVE_PRETTY_PRINT");
        xmlOptions.put("SAVE_AGGRESSIVE_NAMESPACES");
        xmlOptions.put("SAVE_USE_DEFAULT_NAMESPACE");
        return xmlOptions;
    }

    public final String toString() {
        String strXmlText;
        synchronized (monitor()) {
            strXmlText = ensureStore().xmlText(_toStringOptions);
        }
        return strXmlText;
    }

    public String xmlText() {
        return xmlText(null);
    }

    public String xmlText(XmlOptions xmlOptions) {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            return xmlCursorNewCursorForce.xmlText(makeInnerOptions(xmlOptions));
        } finally {
            xmlCursorNewCursorForce.dispose();
        }
    }

    public StringEnumAbstractBase getEnumValue() {
        throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[]{getPrimitiveTypeName(), "enum"});
    }

    public String getStringValue() {
        if (isImmutable()) {
            if ((this._flags & 64) != 0) {
                return null;
            }
            return compute_text(null);
        }
        synchronized (monitor()) {
            if (_isComplexContent()) {
                return get_store().fetch_text(1);
            }
            check_dated();
            if ((this._flags & 64) != 0) {
                return null;
            }
            return compute_text(has_store() ? get_store() : null);
        }
    }

    public String stringValue() {
        return getStringValue();
    }

    public boolean booleanValue() {
        return getBooleanValue();
    }

    public byte byteValue() {
        return getByteValue();
    }

    public short shortValue() {
        return getShortValue();
    }

    public int intValue() {
        return getIntValue();
    }

    public long longValue() {
        return getLongValue();
    }

    public BigInteger bigIntegerValue() {
        return getBigIntegerValue();
    }

    public BigDecimal bigDecimalValue() {
        return getBigDecimalValue();
    }

    public float floatValue() {
        return getFloatValue();
    }

    public double doubleValue() {
        return getDoubleValue();
    }

    public byte[] byteArrayValue() {
        return getByteArrayValue();
    }

    public StringEnumAbstractBase enumValue() {
        return getEnumValue();
    }

    public Calendar calendarValue() {
        return getCalendarValue();
    }

    public Date dateValue() {
        return getDateValue();
    }

    public GDate gDateValue() {
        return getGDateValue();
    }

    public GDuration gDurationValue() {
        return getGDurationValue();
    }

    public QName qNameValue() {
        return getQNameValue();
    }

    public List xlistValue() {
        return xgetListValue();
    }

    public List listValue() {
        return getListValue();
    }

    public Object objectValue() {
        return getObjectValue();
    }

    public void set(String str) {
        setStringValue(str);
    }

    public void set(boolean z) {
        setBooleanValue(z);
    }

    public void set(byte b) {
        setByteValue(b);
    }

    public void set(short s) {
        setShortValue(s);
    }

    public void set(int i) {
        setIntValue(i);
    }

    public void set(long j) {
        setLongValue(j);
    }

    public void set(BigInteger bigInteger) {
        setBigIntegerValue(bigInteger);
    }

    public void set(BigDecimal bigDecimal) {
        setBigDecimalValue(bigDecimal);
    }

    public void set(float f) {
        setFloatValue(f);
    }

    public void set(double d) {
        setDoubleValue(d);
    }

    public void set(byte[] bArr) {
        setByteArrayValue(bArr);
    }

    public void set(StringEnumAbstractBase stringEnumAbstractBase) {
        setEnumValue(stringEnumAbstractBase);
    }

    public void set(Calendar calendar) {
        setCalendarValue(calendar);
    }

    public void set(Date date) {
        setDateValue(date);
    }

    public void set(GDateSpecification gDateSpecification) {
        setGDateValue(gDateSpecification);
    }

    public void set(GDurationSpecification gDurationSpecification) {
        setGDurationValue(gDurationSpecification);
    }

    public void set(QName qName) {
        setQNameValue(qName);
    }

    public void set(List list) {
        setListValue(list);
    }

    public void objectSet(Object obj) {
        setObjectValue(obj);
    }

    public byte[] getByteArrayValue() {
        throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[]{getPrimitiveTypeName(), "byte[]"});
    }

    public boolean getBooleanValue() {
        throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[]{getPrimitiveTypeName(), "boolean"});
    }

    public GDate getGDateValue() {
        throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[]{getPrimitiveTypeName(), "Date"});
    }

    public Date getDateValue() {
        throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[]{getPrimitiveTypeName(), "Date"});
    }

    public Calendar getCalendarValue() {
        throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[]{getPrimitiveTypeName(), "Calendar"});
    }

    public GDuration getGDurationValue() {
        throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[]{getPrimitiveTypeName(), "Duration"});
    }

    public QName getQNameValue() {
        throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[]{getPrimitiveTypeName(), "QName"});
    }

    public List getListValue() {
        throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[]{getPrimitiveTypeName(), "List"});
    }

    public List xgetListValue() {
        throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[]{getPrimitiveTypeName(), "List"});
    }

    public Object getObjectValue() {
        return java_value(this);
    }

    public final void setBooleanValue(boolean z) {
        synchronized (monitor()) {
            set_prepare();
            set_boolean(z);
            set_commit();
        }
    }

    public final void setByteValue(byte b) {
        synchronized (monitor()) {
            set_prepare();
            set_byte(b);
            set_commit();
        }
    }

    public final void setShortValue(short s) {
        synchronized (monitor()) {
            set_prepare();
            set_short(s);
            set_commit();
        }
    }

    public final void setIntValue(int i) {
        synchronized (monitor()) {
            set_prepare();
            set_int(i);
            set_commit();
        }
    }

    public final void setLongValue(long j) {
        synchronized (monitor()) {
            set_prepare();
            set_long(j);
            set_commit();
        }
    }

    public final void setFloatValue(float f) {
        synchronized (monitor()) {
            set_prepare();
            set_float(f);
            set_commit();
        }
    }

    public final void setDoubleValue(double d) {
        synchronized (monitor()) {
            set_prepare();
            set_double(d);
            set_commit();
        }
    }

    public final void setByteArrayValue(byte[] bArr) {
        if (bArr == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_ByteArray(bArr);
            set_commit();
        }
    }

    public final void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase) {
        if (stringEnumAbstractBase == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_enum(stringEnumAbstractBase);
            set_commit();
        }
    }

    public final void setBigIntegerValue(BigInteger bigInteger) {
        if (bigInteger == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_BigInteger(bigInteger);
            set_commit();
        }
    }

    public final void setBigDecimalValue(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_BigDecimal(bigDecimal);
            set_commit();
        }
    }

    public final void setCalendarValue(Calendar calendar) {
        if (calendar == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_Calendar(calendar);
            set_commit();
        }
    }

    public final void setDateValue(Date date) {
        if (date == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_Date(date);
            set_commit();
        }
    }

    public final void setGDateValue(GDate gDate) {
        if (gDate == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_GDate(gDate);
            set_commit();
        }
    }

    public final void setGDateValue(GDateSpecification gDateSpecification) {
        if (gDateSpecification == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_GDate(gDateSpecification);
            set_commit();
        }
    }

    public final void setGDurationValue(GDuration gDuration) {
        if (gDuration == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_GDuration(gDuration);
            set_commit();
        }
    }

    public final void setGDurationValue(GDurationSpecification gDurationSpecification) {
        if (gDurationSpecification == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_GDuration(gDurationSpecification);
            set_commit();
        }
    }

    public final void setQNameValue(QName qName) {
        if (qName == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_QName(qName);
            set_commit();
        }
    }

    public final void setListValue(List list) {
        if (list == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_list(list);
            set_commit();
        }
    }

    public final void setStringValue(String str) {
        if (str == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_String(str);
        }
    }

    public void setObjectValue(Object obj) throws Throwable {
        if (obj == null) {
            setNil();
            return;
        }
        if (obj instanceof XmlObject) {
            set((XmlObject) obj);
            return;
        }
        if (obj instanceof String) {
            setStringValue((String) obj);
            return;
        }
        if (obj instanceof StringEnumAbstractBase) {
            setEnumValue((StringEnumAbstractBase) obj);
            return;
        }
        if (obj instanceof BigInteger) {
            setBigIntegerValue((BigInteger) obj);
            return;
        }
        if (obj instanceof BigDecimal) {
            setBigDecimalValue((BigDecimal) obj);
            return;
        }
        if (obj instanceof Byte) {
            setByteValue(((Byte) obj).byteValue());
            return;
        }
        if (obj instanceof Short) {
            setShortValue(((Short) obj).shortValue());
            return;
        }
        if (obj instanceof Integer) {
            setIntValue(((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            setLongValue(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Boolean) {
            setBooleanValue(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Float) {
            setFloatValue(((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            setDoubleValue(((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Calendar) {
            setCalendarValue((Calendar) obj);
            return;
        }
        if (obj instanceof Date) {
            setDateValue((Date) obj);
            return;
        }
        if (obj instanceof GDateSpecification) {
            setGDateValue((GDateSpecification) obj);
            return;
        }
        if (obj instanceof GDurationSpecification) {
            setGDurationValue((GDurationSpecification) obj);
            return;
        }
        if (obj instanceof QName) {
            setQNameValue((QName) obj);
        } else if (obj instanceof List) {
            setListValue((List) obj);
        } else {
            if (obj instanceof byte[]) {
                setByteArrayValue((byte[]) obj);
                return;
            }
            throw new XmlValueNotSupportedException("Can't set union object of class : " + obj.getClass().getName());
        }
    }

    public final void set_newValue(XmlObject xmlObject) {
        boolean z;
        if (xmlObject == null || xmlObject.isNil()) {
            setNil();
            return;
        }
        if (xmlObject instanceof XmlAnySimpleType) {
            SimpleValue simpleValue = (XmlAnySimpleType) xmlObject;
            SchemaType schemaTypeInstanceType = simpleValue.instanceType();
            if (schemaTypeInstanceType.getSimpleVariety() == 3) {
                synchronized (monitor()) {
                    set_prepare();
                    set_list(simpleValue.xgetListValue());
                    set_commit();
                }
                return;
            }
            synchronized (monitor()) {
                switch (schemaTypeInstanceType.getPrimitiveType().getBuiltinTypeCode()) {
                    case 2:
                        if (simpleValue.isImmutable()) {
                            z = $assertionsDisabled;
                        } else {
                            NamespaceContext.push(new NamespaceContext((XmlObject) simpleValue));
                            z = true;
                        }
                        try {
                            set_prepare();
                            set_xmlanysimple(simpleValue);
                            if (z) {
                                NamespaceContext.pop();
                            }
                            set_commit();
                            return;
                        } catch (Throwable th) {
                            if (z) {
                                NamespaceContext.pop();
                            }
                            throw th;
                        }
                    case 3:
                        boolean booleanValue = simpleValue.getBooleanValue();
                        set_prepare();
                        set_boolean(booleanValue);
                        set_commit();
                        return;
                    case 4:
                        byte[] byteArrayValue = simpleValue.getByteArrayValue();
                        set_prepare();
                        set_b64(byteArrayValue);
                        set_commit();
                        return;
                    case 5:
                        byte[] byteArrayValue2 = simpleValue.getByteArrayValue();
                        set_prepare();
                        set_hex(byteArrayValue2);
                        set_commit();
                        return;
                    case 6:
                        String stringValue = simpleValue.getStringValue();
                        set_prepare();
                        set_text(stringValue);
                        set_commit();
                        return;
                    case 7:
                        QName qNameValue = simpleValue.getQNameValue();
                        set_prepare();
                        set_QName(qNameValue);
                        set_commit();
                        return;
                    case 8:
                        String stringValue2 = simpleValue.getStringValue();
                        set_prepare();
                        set_notation(stringValue2);
                        set_commit();
                        return;
                    case 9:
                        float floatValue = simpleValue.getFloatValue();
                        set_prepare();
                        set_float(floatValue);
                        set_commit();
                        return;
                    case 10:
                        double doubleValue = simpleValue.getDoubleValue();
                        set_prepare();
                        set_double(doubleValue);
                        set_commit();
                        return;
                    case 11:
                        int decimalSize = schemaTypeInstanceType.getDecimalSize();
                        if (decimalSize == 8) {
                            byte byteValue = simpleValue.getByteValue();
                            set_prepare();
                            set_byte(byteValue);
                        } else if (decimalSize == 16) {
                            short shortValue = simpleValue.getShortValue();
                            set_prepare();
                            set_short(shortValue);
                        } else if (decimalSize == 32) {
                            int intValue = simpleValue.getIntValue();
                            set_prepare();
                            set_int(intValue);
                        } else if (decimalSize == 64) {
                            long longValue = simpleValue.getLongValue();
                            set_prepare();
                            set_long(longValue);
                        } else {
                            switch (decimalSize) {
                                case 1000000:
                                    BigInteger bigIntegerValue = simpleValue.getBigIntegerValue();
                                    set_prepare();
                                    set_BigInteger(bigIntegerValue);
                                    break;
                                case 1000001:
                                default:
                                    BigDecimal bigDecimalValue = simpleValue.getBigDecimalValue();
                                    set_prepare();
                                    set_BigDecimal(bigDecimalValue);
                                    break;
                            }
                        }
                        set_commit();
                        return;
                    case 12:
                        String stringValue3 = simpleValue.getStringValue();
                        set_prepare();
                        set_String(stringValue3);
                        set_commit();
                        return;
                    case 13:
                        GDuration gDurationValue = simpleValue.getGDurationValue();
                        set_prepare();
                        set_GDuration(gDurationValue);
                        set_commit();
                        return;
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                        GDate gDateValue = simpleValue.getGDateValue();
                        set_prepare();
                        set_GDate(gDateValue);
                        set_commit();
                        return;
                    default:
                        break;
                }
            }
        }
        throw new IllegalStateException("Complex type unexpected");
    }

    private TypeStoreUser setterHelper(XmlObjectBase xmlObjectBase) {
        check_orphaned();
        xmlObjectBase.check_orphaned();
        return get_store().copy_contents_from(xmlObjectBase.get_store()).get_store().change_type(xmlObjectBase.schemaType());
    }

    public final XmlObject set(XmlObject xmlObject) throws Throwable {
        TypeStoreUser typeStoreUser;
        if (isImmutable()) {
            throw new IllegalStateException("Cannot set the value of an immutable XmlObject");
        }
        XmlObjectBase xmlObjectBaseUnderlying = underlying(xmlObject);
        if (xmlObjectBaseUnderlying == null) {
            setNil();
            return this;
        }
        if (xmlObjectBaseUnderlying.isImmutable()) {
            setStringValue(xmlObjectBaseUnderlying.getStringValue());
            typeStoreUser = this;
        } else {
            boolean zPreCheck = preCheck();
            boolean zPreCheck2 = xmlObjectBaseUnderlying.preCheck();
            if (monitor() == xmlObjectBaseUnderlying.monitor()) {
                if (zPreCheck) {
                    typeStoreUser = setterHelper(xmlObjectBaseUnderlying);
                } else {
                    synchronized (monitor()) {
                        typeStoreUser = setterHelper(xmlObjectBaseUnderlying);
                    }
                }
            } else if (zPreCheck) {
                if (zPreCheck2) {
                    typeStoreUser = setterHelper(xmlObjectBaseUnderlying);
                } else {
                    synchronized (xmlObjectBaseUnderlying.monitor()) {
                        typeStoreUser = setterHelper(xmlObjectBaseUnderlying);
                    }
                }
            } else if (zPreCheck2) {
                synchronized (monitor()) {
                    typeStoreUser = setterHelper(xmlObjectBaseUnderlying);
                }
            } else {
                boolean z = $assertionsDisabled;
                try {
                    try {
                        GlobalLock.acquire();
                        try {
                            try {
                                synchronized (monitor()) {
                                    try {
                                        try {
                                            synchronized (xmlObjectBaseUnderlying.monitor()) {
                                                try {
                                                    GlobalLock.release();
                                                    typeStoreUser = setterHelper(xmlObjectBaseUnderlying);
                                                } catch (Throwable th) {
                                                    th = th;
                                                    throw th;
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        z = true;
                                        throw th;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (InterruptedException e) {
                            e = e;
                            z = true;
                            throw new XmlRuntimeException(e);
                        } catch (Throwable th5) {
                            th = th5;
                            z = true;
                            if (z) {
                                GlobalLock.release();
                            }
                            throw th;
                        }
                    } catch (InterruptedException e2) {
                        e = e2;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            }
        }
        return (XmlObject) typeStoreUser;
    }

    public final XmlObject generatedSetterHelperImpl(XmlObject xmlObject, QName qName, int i, short s) throws Throwable {
        XmlObject xmlObjectObjSetterHelper;
        XmlObject xmlObjectObjSetterHelper2;
        XmlObject xmlObjectObjSetterHelper3;
        XmlObjectBase targetForSetter;
        XmlObjectBase targetForSetter2;
        XmlObjectBase xmlObjectBaseUnderlying = underlying(xmlObject);
        if (xmlObjectBaseUnderlying == null) {
            synchronized (monitor()) {
                targetForSetter2 = getTargetForSetter(qName, i, s);
                targetForSetter2.setNil();
            }
            return targetForSetter2;
        }
        if (xmlObjectBaseUnderlying.isImmutable()) {
            synchronized (monitor()) {
                targetForSetter = getTargetForSetter(qName, i, s);
                targetForSetter.setStringValue(xmlObjectBaseUnderlying.getStringValue());
            }
            return targetForSetter;
        }
        boolean zPreCheck = preCheck();
        boolean zPreCheck2 = xmlObjectBaseUnderlying.preCheck();
        if (monitor() == xmlObjectBaseUnderlying.monitor()) {
            if (zPreCheck) {
                return objSetterHelper(xmlObjectBaseUnderlying, qName, i, s);
            }
            synchronized (monitor()) {
                xmlObjectObjSetterHelper3 = objSetterHelper(xmlObjectBaseUnderlying, qName, i, s);
            }
            return xmlObjectObjSetterHelper3;
        }
        if (zPreCheck) {
            if (zPreCheck2) {
                return objSetterHelper(xmlObjectBaseUnderlying, qName, i, s);
            }
            synchronized (xmlObjectBaseUnderlying.monitor()) {
                xmlObjectObjSetterHelper2 = objSetterHelper(xmlObjectBaseUnderlying, qName, i, s);
            }
            return xmlObjectObjSetterHelper2;
        }
        if (zPreCheck2) {
            synchronized (monitor()) {
                xmlObjectObjSetterHelper = objSetterHelper(xmlObjectBaseUnderlying, qName, i, s);
            }
            return xmlObjectObjSetterHelper;
        }
        boolean z = $assertionsDisabled;
        try {
            try {
                GlobalLock.acquire();
                try {
                    try {
                        synchronized (monitor()) {
                            try {
                                try {
                                    synchronized (xmlObjectBaseUnderlying.monitor()) {
                                        try {
                                            GlobalLock.release();
                                            return objSetterHelper(xmlObjectBaseUnderlying, qName, i, s);
                                        } catch (Throwable th) {
                                            th = th;
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                throw th;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (InterruptedException e) {
                    e = e;
                    throw new XmlRuntimeException(e);
                } catch (Throwable th5) {
                    th = th5;
                    z = true;
                    if (z) {
                        GlobalLock.release();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (InterruptedException e2) {
            e = e2;
        }
    }

    private TypeStoreUser objSetterHelper(XmlObjectBase xmlObjectBase, QName qName, int i, short s) {
        XmlObjectBase targetForSetter = getTargetForSetter(qName, i, s);
        targetForSetter.check_orphaned();
        xmlObjectBase.check_orphaned();
        return targetForSetter.get_store().copy_contents_from(xmlObjectBase.get_store()).get_store().change_type(xmlObjectBase.schemaType());
    }

    private XmlObjectBase getTargetForSetter(QName qName, int i, short s) {
        if (s == 1) {
            check_orphaned();
            XmlObjectBase xmlObjectBase = (XmlObjectBase) get_store().find_element_user(qName, i);
            if (xmlObjectBase == null) {
                xmlObjectBase = (XmlObjectBase) get_store().add_element_user(qName);
            }
            if (xmlObjectBase.isImmutable()) {
                throw new IllegalStateException("Cannot set the value of an immutable XmlObject");
            }
            return xmlObjectBase;
        }
        if (s == 2) {
            check_orphaned();
            XmlObjectBase xmlObjectBase2 = (XmlObjectBase) get_store().find_element_user(qName, i);
            if (xmlObjectBase2 == null) {
                throw new IndexOutOfBoundsException();
            }
            if (xmlObjectBase2.isImmutable()) {
                throw new IllegalStateException("Cannot set the value of an immutable XmlObject");
            }
            return xmlObjectBase2;
        }
        throw new IllegalArgumentException("Unknown kindSetterHelper: " + ((int) s));
    }

    public final XmlObject _set(XmlObject xmlObject) {
        TypeStoreUser typeStoreUserChange_type;
        if (isImmutable()) {
            throw new IllegalStateException("Cannot set the value of an immutable XmlObject");
        }
        XmlObjectBase xmlObjectBaseUnderlying = underlying(xmlObject);
        if (xmlObjectBaseUnderlying == null) {
            setNil();
            return this;
        }
        if (xmlObjectBaseUnderlying.isImmutable()) {
            set(xmlObjectBaseUnderlying.stringValue());
            typeStoreUserChange_type = this;
        } else {
            check_orphaned();
            xmlObjectBaseUnderlying.check_orphaned();
            typeStoreUserChange_type = get_store().copy_contents_from(xmlObjectBaseUnderlying.get_store()).get_store().change_type(xmlObjectBaseUnderlying.schemaType());
        }
        return (XmlObject) typeStoreUserChange_type;
    }

    protected void set_list(List list) {
        throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[]{"List", getPrimitiveTypeName()});
    }

    protected void set_boolean(boolean z) {
        throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[]{"boolean", getPrimitiveTypeName()});
    }

    protected void set_byte(byte b) {
        set_int(b);
    }

    protected void set_short(short s) {
        set_int(s);
    }

    protected void set_int(int i) {
        set_long(i);
    }

    protected void set_long(long j) {
        set_BigInteger(BigInteger.valueOf(j));
    }

    protected void set_char(char c) {
        set_String(Character.toString(c));
    }

    protected void set_float(float f) {
        set_BigDecimal(new BigDecimal(f));
    }

    protected void set_double(double d) {
        set_BigDecimal(new BigDecimal(d));
    }

    protected void set_enum(StringEnumAbstractBase stringEnumAbstractBase) {
        throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[]{"enum", getPrimitiveTypeName()});
    }

    protected void set_ByteArray(byte[] bArr) {
        throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[]{"byte[]", getPrimitiveTypeName()});
    }

    protected void set_b64(byte[] bArr) {
        set_ByteArray(bArr);
    }

    protected void set_hex(byte[] bArr) {
        set_ByteArray(bArr);
    }

    protected void set_BigInteger(BigInteger bigInteger) {
        set_BigDecimal(new BigDecimal(bigInteger));
    }

    protected void set_BigDecimal(BigDecimal bigDecimal) {
        throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[]{"numeric", getPrimitiveTypeName()});
    }

    protected void set_Date(Date date) {
        throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[]{"Date", getPrimitiveTypeName()});
    }

    protected void set_Calendar(Calendar calendar) {
        throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[]{"Calendar", getPrimitiveTypeName()});
    }

    protected void set_GDate(GDateSpecification gDateSpecification) {
        throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[]{"Date", getPrimitiveTypeName()});
    }

    protected void set_GDuration(GDurationSpecification gDurationSpecification) {
        throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[]{"Duration", getPrimitiveTypeName()});
    }

    protected void set_ComplexXml(XmlObject xmlObject) {
        throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[]{"complex content", getPrimitiveTypeName()});
    }

    protected void set_QName(QName qName) {
        throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[]{"QName", getPrimitiveTypeName()});
    }

    protected void set_notation(String str) {
        throw new XmlValueNotSupportedException();
    }

    protected void set_xmlanysimple(XmlAnySimpleType xmlAnySimpleType) {
        set_String(xmlAnySimpleType.getStringValue());
    }

    private final String getPrimitiveTypeName() {
        SchemaType schemaType = schemaType();
        if (schemaType.isNoType()) {
            return "unknown";
        }
        SchemaType primitiveType = schemaType.getPrimitiveType();
        return primitiveType == null ? "complex" : primitiveType.getName().getLocalPart();
    }

    private final boolean comparable_value_spaces(SchemaType schemaType, SchemaType schemaType2) {
        if (!schemaType.isSimpleType() && !schemaType2.isSimpleType()) {
            if (schemaType.getContentType() == schemaType2.getContentType()) {
                return true;
            }
            return $assertionsDisabled;
        }
        if (schemaType.isSimpleType() && schemaType2.isSimpleType()) {
            if (schemaType.getSimpleVariety() == 3 && schemaType2.getSimpleVariety() == 3) {
                return true;
            }
            if (schemaType.getSimpleVariety() != 3 && schemaType2.getSimpleVariety() != 3) {
                return schemaType.getPrimitiveType().equals(schemaType2.getPrimitiveType());
            }
        }
        return $assertionsDisabled;
    }

    private final boolean valueEqualsImpl(XmlObject xmlObject) {
        check_dated();
        SchemaType schemaTypeInstanceType = instanceType();
        SchemaType schemaTypeInstanceType2 = ((SimpleValue) xmlObject).instanceType();
        if (schemaTypeInstanceType == null && schemaTypeInstanceType2 == null) {
            return true;
        }
        if (schemaTypeInstanceType == null || schemaTypeInstanceType2 == null || !comparable_value_spaces(schemaTypeInstanceType, schemaTypeInstanceType2)) {
            return $assertionsDisabled;
        }
        if (xmlObject.schemaType().getSimpleVariety() == 2) {
            return underlying(xmlObject).equal_to(this);
        }
        return equal_to(xmlObject);
    }

    public final boolean valueEquals(XmlObject xmlObject) throws Throwable {
        boolean zValueEqualsImpl;
        boolean zValueEqualsImpl2;
        boolean z = $assertionsDisabled;
        try {
            try {
                if (isImmutable()) {
                    if (xmlObject.isImmutable()) {
                        return valueEqualsImpl(xmlObject);
                    }
                    synchronized (xmlObject.monitor()) {
                        zValueEqualsImpl2 = valueEqualsImpl(xmlObject);
                    }
                    return zValueEqualsImpl2;
                }
                if (!xmlObject.isImmutable() && monitor() != xmlObject.monitor()) {
                    GlobalLock.acquire();
                    try {
                        try {
                            synchronized (monitor()) {
                                try {
                                    try {
                                        synchronized (xmlObject.monitor()) {
                                            try {
                                                GlobalLock.release();
                                                return valueEqualsImpl(xmlObject);
                                            } catch (Throwable th) {
                                                th = th;
                                                throw th;
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    throw th;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } catch (InterruptedException e) {
                        e = e;
                        throw new XmlRuntimeException(e);
                    } catch (Throwable th5) {
                        th = th5;
                        z = true;
                        if (z) {
                            GlobalLock.release();
                        }
                        throw th;
                    }
                }
                synchronized (monitor()) {
                    zValueEqualsImpl = valueEqualsImpl(xmlObject);
                }
                return zValueEqualsImpl;
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (InterruptedException e2) {
            e = e2;
        }
    }

    public final int compareTo(Object obj) throws Throwable {
        int iCompareValue = compareValue((XmlObject) obj);
        if (iCompareValue != 2) {
            return iCompareValue;
        }
        throw new ClassCastException();
    }

    private final int compareValueImpl(XmlObject xmlObject) {
        try {
            SchemaType schemaTypeInstanceType = instanceType();
            SchemaType schemaTypeInstanceType2 = ((SimpleValue) xmlObject).instanceType();
            if (schemaTypeInstanceType == null && schemaTypeInstanceType2 == null) {
                return 0;
            }
            if (schemaTypeInstanceType != null && schemaTypeInstanceType2 != null && schemaTypeInstanceType.isSimpleType() && !schemaTypeInstanceType.isURType() && schemaTypeInstanceType2.isSimpleType() && !schemaTypeInstanceType2.isURType()) {
                if (schemaTypeInstanceType.getPrimitiveType().getBuiltinTypeCode() != schemaTypeInstanceType2.getPrimitiveType().getBuiltinTypeCode()) {
                    return 2;
                }
                return compare_to(xmlObject);
            }
            return 2;
        } catch (XmlValueOutOfRangeException unused) {
        }
    }

    public final int compareValue(XmlObject xmlObject) throws Throwable {
        int iCompareValueImpl;
        int iCompareValueImpl2;
        if (xmlObject == null) {
            return 2;
        }
        boolean z = $assertionsDisabled;
        try {
            try {
                if (isImmutable()) {
                    if (xmlObject.isImmutable()) {
                        return compareValueImpl(xmlObject);
                    }
                    synchronized (xmlObject.monitor()) {
                        iCompareValueImpl2 = compareValueImpl(xmlObject);
                    }
                    return iCompareValueImpl2;
                }
                if (!xmlObject.isImmutable() && monitor() != xmlObject.monitor()) {
                    GlobalLock.acquire();
                    try {
                        try {
                            synchronized (monitor()) {
                                try {
                                    try {
                                        synchronized (xmlObject.monitor()) {
                                            try {
                                                GlobalLock.release();
                                                return compareValueImpl(xmlObject);
                                            } catch (Throwable th) {
                                                th = th;
                                                throw th;
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    throw th;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } catch (InterruptedException e) {
                        e = e;
                        throw new XmlRuntimeException(e);
                    } catch (Throwable th5) {
                        th = th5;
                        z = true;
                        if (z) {
                            GlobalLock.release();
                        }
                        throw th;
                    }
                }
                synchronized (monitor()) {
                    iCompareValueImpl = compareValueImpl(xmlObject);
                }
                return iCompareValueImpl;
            } catch (InterruptedException e2) {
                e = e2;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    protected int compare_to(XmlObject xmlObject) {
        return equal_to(xmlObject) ? 0 : 2;
    }

    public int valueHashCode() {
        int iValue_hash_code;
        synchronized (monitor()) {
            iValue_hash_code = value_hash_code();
        }
        return iValue_hash_code;
    }

    public boolean isInstanceOf(SchemaType schemaType) {
        if (schemaType.getSimpleVariety() != 2) {
            for (SchemaType schemaTypeInstanceType = instanceType(); schemaTypeInstanceType != null; schemaTypeInstanceType = schemaTypeInstanceType.getBaseType()) {
                if (schemaType == schemaTypeInstanceType) {
                    return true;
                }
            }
            return $assertionsDisabled;
        }
        HashSet hashSet = new HashSet(Arrays.asList(schemaType.getUnionConstituentTypes()));
        for (SchemaType schemaTypeInstanceType2 = instanceType(); schemaTypeInstanceType2 != null; schemaTypeInstanceType2 = schemaTypeInstanceType2.getBaseType()) {
            if (hashSet.contains(schemaTypeInstanceType2)) {
                return true;
            }
        }
        return $assertionsDisabled;
    }

    public final boolean equals(Object obj) {
        if (!isImmutable()) {
            return super.equals(obj);
        }
        if (!(obj instanceof XmlObject)) {
            return $assertionsDisabled;
        }
        XmlObject xmlObject = (XmlObject) obj;
        return !xmlObject.isImmutable() ? $assertionsDisabled : valueEquals(xmlObject);
    }

    public final int hashCode() {
        if (!isImmutable()) {
            return super.hashCode();
        }
        synchronized (monitor()) {
            if (isNil()) {
                return 0;
            }
            return value_hash_code();
        }
    }

    public XmlObject[] selectChildren(QName qName) {
        XmlCursor xmlCursorNewCursor = newCursor();
        try {
            if (!xmlCursorNewCursor.isContainer()) {
                XmlObject[] xmlObjectArr = EMPTY_RESULT;
                xmlCursorNewCursor.dispose();
                return xmlObjectArr;
            }
            ArrayList arrayList = new ArrayList();
            if (xmlCursorNewCursor.toChild(qName)) {
                do {
                    arrayList.add(xmlCursorNewCursor.getObject());
                } while (xmlCursorNewCursor.toNextSibling(qName));
            }
            if (arrayList.size() == 0) {
                XmlObject[] xmlObjectArr2 = EMPTY_RESULT;
                xmlCursorNewCursor.dispose();
                return xmlObjectArr2;
            }
            XmlObject[] xmlObjectArr3 = (XmlObject[]) arrayList.toArray(EMPTY_RESULT);
            xmlCursorNewCursor.dispose();
            return xmlObjectArr3;
        } catch (Throwable th) {
            xmlCursorNewCursor.dispose();
            throw th;
        }
    }

    public XmlObject[] selectChildren(String str, String str2) {
        return selectChildren(new QName(str, str2));
    }

    public XmlObject[] selectChildren(QNameSet qNameSet) {
        if (qNameSet == null) {
            throw new IllegalArgumentException();
        }
        XmlCursor xmlCursorNewCursor = newCursor();
        try {
            if (!xmlCursorNewCursor.isContainer()) {
                XmlObject[] xmlObjectArr = EMPTY_RESULT;
                xmlCursorNewCursor.dispose();
                return xmlObjectArr;
            }
            ArrayList arrayList = new ArrayList();
            if (xmlCursorNewCursor.toFirstChild()) {
                do {
                    if (qNameSet.contains(xmlCursorNewCursor.getName())) {
                        arrayList.add(xmlCursorNewCursor.getObject());
                    }
                } while (xmlCursorNewCursor.toNextSibling());
            }
            if (arrayList.size() == 0) {
                XmlObject[] xmlObjectArr2 = EMPTY_RESULT;
                xmlCursorNewCursor.dispose();
                return xmlObjectArr2;
            }
            XmlObject[] xmlObjectArr3 = (XmlObject[]) arrayList.toArray(EMPTY_RESULT);
            xmlCursorNewCursor.dispose();
            return xmlObjectArr3;
        } catch (Throwable th) {
            xmlCursorNewCursor.dispose();
            throw th;
        }
    }

    public XmlObject selectAttribute(QName qName) {
        XmlCursor xmlCursorNewCursor = newCursor();
        try {
            if (!xmlCursorNewCursor.isContainer()) {
                return null;
            }
            if (xmlCursorNewCursor.toFirstAttribute()) {
                while (!xmlCursorNewCursor.getName().equals(qName)) {
                    if (!xmlCursorNewCursor.toNextAttribute()) {
                    }
                }
                return xmlCursorNewCursor.getObject();
            }
            return null;
        } finally {
            xmlCursorNewCursor.dispose();
        }
    }

    public XmlObject selectAttribute(String str, String str2) {
        return selectAttribute(new QName(str, str2));
    }

    public XmlObject[] selectAttributes(QNameSet qNameSet) {
        if (qNameSet == null) {
            throw new IllegalArgumentException();
        }
        XmlCursor xmlCursorNewCursor = newCursor();
        try {
            if (!xmlCursorNewCursor.isContainer()) {
                XmlObject[] xmlObjectArr = EMPTY_RESULT;
                xmlCursorNewCursor.dispose();
                return xmlObjectArr;
            }
            ArrayList arrayList = new ArrayList();
            if (xmlCursorNewCursor.toFirstAttribute()) {
                do {
                    if (qNameSet.contains(xmlCursorNewCursor.getName())) {
                        arrayList.add(xmlCursorNewCursor.getObject());
                    }
                } while (xmlCursorNewCursor.toNextAttribute());
            }
            if (arrayList.size() == 0) {
                XmlObject[] xmlObjectArr2 = EMPTY_RESULT;
                xmlCursorNewCursor.dispose();
                return xmlObjectArr2;
            }
            XmlObject[] xmlObjectArr3 = (XmlObject[]) arrayList.toArray(EMPTY_RESULT);
            xmlCursorNewCursor.dispose();
            return xmlObjectArr3;
        } catch (Throwable th) {
            xmlCursorNewCursor.dispose();
            throw th;
        }
    }

    public Object writeReplace() {
        synchronized (monitor()) {
            if (isRootXmlObject()) {
                return new SerializedRootObject(this);
            }
            return new SerializedInteriorObject(this, getRootXmlObject());
        }
    }

    private boolean isRootXmlObject() {
        XmlCursor xmlCursorNewCursor = newCursor();
        if (xmlCursorNewCursor == null) {
            return $assertionsDisabled;
        }
        boolean z = !xmlCursorNewCursor.toParent();
        xmlCursorNewCursor.dispose();
        return z;
    }

    private XmlObject getRootXmlObject() {
        XmlCursor xmlCursorNewCursor = newCursor();
        if (xmlCursorNewCursor == null) {
            return this;
        }
        xmlCursorNewCursor.toStartDoc();
        XmlObject object = xmlCursorNewCursor.getObject();
        xmlCursorNewCursor.dispose();
        return object;
    }

    private static class SerializedRootObject implements Serializable {
        private static final long serialVersionUID = 1;
        transient XmlObject _impl;
        transient Class _xbeanClass;

        private SerializedRootObject() {
        }

        private SerializedRootObject(XmlObject xmlObject) {
            this._xbeanClass = xmlObject.schemaType().getJavaClass();
            this._impl = xmlObject;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this._xbeanClass);
            objectOutputStream.writeShort(0);
            objectOutputStream.writeShort(1);
            objectOutputStream.writeShort(1);
            objectOutputStream.writeObject(this._impl.xmlText());
            objectOutputStream.writeBoolean(XmlObjectBase.$assertionsDisabled);
        }

        private void readObject(ObjectInputStream objectInputStream) throws Throwable {
            int unsignedShort;
            int unsignedShort2;
            String objectV0;
            try {
                this._xbeanClass = (Class) objectInputStream.readObject();
                int unsignedShort3 = objectInputStream.readUnsignedShort();
                if (unsignedShort3 == 0) {
                    unsignedShort = objectInputStream.readUnsignedShort();
                    unsignedShort2 = objectInputStream.readUnsignedShort();
                } else {
                    unsignedShort = 0;
                    unsignedShort2 = 0;
                }
                if (unsignedShort == 0) {
                    objectV0 = readObjectV0(objectInputStream, unsignedShort3);
                    objectInputStream.readBoolean();
                } else {
                    if (unsignedShort != 1) {
                        throw new IOException("Deserialization error: version number " + unsignedShort + "." + unsignedShort2 + " not supported.");
                    }
                    if (unsignedShort2 == 1) {
                        objectV0 = (String) objectInputStream.readObject();
                        objectInputStream.readBoolean();
                    } else {
                        throw new IOException("Deserialization error: version number " + unsignedShort + "." + unsignedShort2 + " not supported.");
                    }
                }
                this._impl = XmlBeans.getContextTypeLoader().parse(objectV0, (SchemaType) null, new XmlOptions().setDocumentType(XmlBeans.typeForClass(this._xbeanClass)));
            } catch (Exception e) {
                throw ((IOException) new IOException(e.getMessage()).initCause(e));
            }
        }

        private String readObjectV0(ObjectInputStream objectInputStream, int i) throws Throwable {
            DataInputStream dataInputStream;
            Throwable th;
            byte[] bArr = new byte[i + 2];
            int i2 = 0;
            bArr[0] = (byte) ((i >> 8) & 255);
            bArr[1] = (byte) (i & 255);
            while (i2 < i) {
                int i3 = objectInputStream.read(bArr, i2 + 2, i - i2);
                if (i3 == -1) {
                    break;
                }
                i2 += i3;
            }
            if (i2 != i) {
                throw new IOException("Error reading backwards compatible XmlObject: number of bytes read (" + i2 + ") != number expected (" + i + ")");
            }
            try {
                dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
                try {
                    String utf = dataInputStream.readUTF();
                    dataInputStream.close();
                    return utf;
                } catch (Throwable th2) {
                    th = th2;
                    if (dataInputStream != null) {
                        dataInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                dataInputStream = null;
                th = th3;
            }
        }

        private Object readResolve() throws ObjectStreamException {
            return this._impl;
        }
    }

    private static class SerializedInteriorObject implements Serializable {
        private static final long serialVersionUID = 1;
        transient XmlObject _impl;
        transient XmlObject _root;

        private SerializedInteriorObject() {
        }

        private SerializedInteriorObject(XmlObject xmlObject, XmlObject xmlObject2) {
            this._impl = xmlObject;
            this._root = xmlObject2;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this._root);
            objectOutputStream.writeBoolean(XmlObjectBase.$assertionsDisabled);
            objectOutputStream.writeInt(distanceToRoot());
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this._root = (XmlObject) objectInputStream.readObject();
            objectInputStream.readBoolean();
            this._impl = objectAtDistance(objectInputStream.readInt());
        }

        private Object readResolve() throws ObjectStreamException {
            return this._impl;
        }

        private int distanceToRoot() {
            XmlCursor xmlCursorNewCursor = this._impl.newCursor();
            int i = 0;
            while (!xmlCursorNewCursor.toPrevToken().isNone()) {
                if (!xmlCursorNewCursor.currentTokenType().isNamespace()) {
                    i++;
                }
            }
            xmlCursorNewCursor.dispose();
            return i;
        }

        private XmlObject objectAtDistance(int i) {
            XmlCursor xmlCursorNewCursor = this._root.newCursor();
            while (i > 0) {
                xmlCursorNewCursor.toNextToken();
                if (!xmlCursorNewCursor.currentTokenType().isNamespace()) {
                    i--;
                }
            }
            XmlObject object = xmlCursorNewCursor.getObject();
            xmlCursorNewCursor.dispose();
            return object;
        }
    }

    protected static Object java_value(XmlObject xmlObject) {
        if (xmlObject.isNil()) {
            return null;
        }
        if (!(xmlObject instanceof XmlAnySimpleType)) {
            return xmlObject;
        }
        SimpleValue simpleValue = (SimpleValue) xmlObject;
        SchemaType schemaTypeInstanceType = simpleValue.instanceType();
        if (schemaTypeInstanceType.getSimpleVariety() == 3) {
            return simpleValue.getListValue();
        }
        switch (schemaTypeInstanceType.getPrimitiveType().getBuiltinTypeCode()) {
            case 2:
            case 8:
            case 12:
            default:
                return simpleValue.getStringValue();
            case 3:
                return simpleValue.getBooleanValue() ? Boolean.TRUE : Boolean.FALSE;
            case 4:
            case 5:
                return simpleValue.getByteArrayValue();
            case 6:
                return simpleValue.getStringValue();
            case 7:
                return simpleValue.getQNameValue();
            case 9:
                return new Float(simpleValue.getFloatValue());
            case 10:
                return new Double(simpleValue.getDoubleValue());
            case 11:
                int decimalSize = schemaTypeInstanceType.getDecimalSize();
                if (decimalSize == 8) {
                    return new Byte(simpleValue.getByteValue());
                }
                if (decimalSize == 16) {
                    return new Short(simpleValue.getShortValue());
                }
                if (decimalSize == 32) {
                    return new Integer(simpleValue.getIntValue());
                }
                if (decimalSize == 64) {
                    return new Long(simpleValue.getLongValue());
                }
                switch (decimalSize) {
                    case 1000000:
                        return simpleValue.getBigIntegerValue();
                    case 1000001:
                    default:
                        return simpleValue.getBigDecimalValue();
                }
            case 13:
                return simpleValue.getGDurationValue();
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                return simpleValue.getCalendarValue();
        }
    }

    protected XmlAnySimpleType get_default_attribute_value(QName qName) {
        SchemaLocalAttribute attribute;
        SchemaAttributeModel attributeModel = schemaType().getAttributeModel();
        if (attributeModel == null || (attribute = attributeModel.getAttribute(qName)) == null) {
            return null;
        }
        return attribute.getDefaultValue();
    }
}
