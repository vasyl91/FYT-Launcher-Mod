package org.apache.xmlbeans.impl.store;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.values.NamespaceManager;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.TypeStoreUser;
import org.apache.xmlbeans.impl.values.TypeStoreVisitor;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class Public2 {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private static Locale newLocale(Saaj saaj) {
        XmlOptions xmlOptions;
        if (saaj != null) {
            xmlOptions = new XmlOptions();
            xmlOptions.put(Saaj.SAAJ_IMPL, saaj);
        } else {
            xmlOptions = null;
        }
        return Locale.getLocale(null, xmlOptions);
    }

    private static Locale newLocale() {
        return Locale.getLocale(null, null);
    }

    public static void setSync(Document document, boolean z) {
        ((DomImpl.Dom) document).locale()._noSync = !z;
    }

    public static String compilePath(String str, XmlOptions xmlOptions) {
        return Path.compilePath(str, xmlOptions);
    }

    public static DOMImplementation getDomImplementation() {
        return newLocale();
    }

    public static DOMImplementation getDomImplementation(Saaj saaj) {
        return newLocale(saaj);
    }

    public static Document parse(String str) throws XmlException {
        DomImpl.Dom domLoad;
        Locale localeNewLocale = newLocale();
        if (localeNewLocale.noSync()) {
            localeNewLocale.enter();
            try {
                domLoad = localeNewLocale.load(str);
            } finally {
                localeNewLocale.exit();
            }
        } else {
            synchronized (localeNewLocale) {
                localeNewLocale.enter();
                try {
                    domLoad = localeNewLocale.load(str);
                    localeNewLocale.exit();
                } catch (Throwable th) {
                    localeNewLocale.exit();
                    throw th;
                }
            }
        }
        return (Document) domLoad;
    }

    public static Document parse(String str, XmlOptions xmlOptions) throws XmlException {
        DomImpl.Dom domLoad;
        Locale localeNewLocale = newLocale();
        if (localeNewLocale.noSync()) {
            localeNewLocale.enter();
            try {
                domLoad = localeNewLocale.load(str, xmlOptions);
            } finally {
                localeNewLocale.exit();
            }
        } else {
            synchronized (localeNewLocale) {
                localeNewLocale.enter();
                try {
                    domLoad = localeNewLocale.load(str, xmlOptions);
                    localeNewLocale.exit();
                } catch (Throwable th) {
                    localeNewLocale.exit();
                    throw th;
                }
            }
        }
        return (Document) domLoad;
    }

    public static Document parse(String str, Saaj saaj) throws XmlException {
        DomImpl.Dom domLoad;
        Locale localeNewLocale = newLocale(saaj);
        if (localeNewLocale.noSync()) {
            localeNewLocale.enter();
            try {
                domLoad = localeNewLocale.load(str);
            } finally {
                localeNewLocale.exit();
            }
        } else {
            synchronized (localeNewLocale) {
                localeNewLocale.enter();
                try {
                    domLoad = localeNewLocale.load(str);
                    localeNewLocale.exit();
                } catch (Throwable th) {
                    localeNewLocale.exit();
                    throw th;
                }
            }
        }
        return (Document) domLoad;
    }

    public static Document parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
        DomImpl.Dom domLoad;
        Locale localeNewLocale = newLocale();
        if (localeNewLocale.noSync()) {
            localeNewLocale.enter();
            try {
                domLoad = localeNewLocale.load(inputStream, xmlOptions);
            } finally {
                localeNewLocale.exit();
            }
        } else {
            synchronized (localeNewLocale) {
                localeNewLocale.enter();
                try {
                    domLoad = localeNewLocale.load(inputStream, xmlOptions);
                    localeNewLocale.exit();
                } catch (Throwable th) {
                    localeNewLocale.exit();
                    throw th;
                }
            }
        }
        return (Document) domLoad;
    }

    public static Document parse(InputStream inputStream, Saaj saaj) throws XmlException, IOException {
        DomImpl.Dom domLoad;
        Locale localeNewLocale = newLocale(saaj);
        if (localeNewLocale.noSync()) {
            localeNewLocale.enter();
            try {
                domLoad = localeNewLocale.load(inputStream);
            } finally {
                localeNewLocale.exit();
            }
        } else {
            synchronized (localeNewLocale) {
                localeNewLocale.enter();
                try {
                    domLoad = localeNewLocale.load(inputStream);
                    localeNewLocale.exit();
                } catch (Throwable th) {
                    localeNewLocale.exit();
                    throw th;
                }
            }
        }
        return (Document) domLoad;
    }

    public static Node getNode(XMLStreamReader xMLStreamReader) {
        return Jsr173.nodeFromStream(xMLStreamReader);
    }

    public static XMLStreamReader getStream(Node node) {
        XMLStreamReader xmlStreamReader;
        DomImpl.Dom dom = (DomImpl.Dom) node;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return DomImpl.getXmlStreamReader(dom);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                xmlStreamReader = DomImpl.getXmlStreamReader(dom);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return xmlStreamReader;
    }

    public static String save(Node node) {
        return save(node, (XmlOptions) null);
    }

    public static void save(Node node, OutputStream outputStream, XmlOptions xmlOptions) throws IOException {
        XmlCursor cursor = getCursor(node);
        cursor.save(outputStream, xmlOptions);
        cursor.dispose();
    }

    public static String save(Node node, XmlOptions xmlOptions) {
        String strSaveImpl;
        DomImpl.Dom dom = (DomImpl.Dom) node;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return saveImpl(dom, xmlOptions);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                strSaveImpl = saveImpl(dom, xmlOptions);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return strSaveImpl;
    }

    private static String saveImpl(DomImpl.Dom dom, XmlOptions xmlOptions) {
        Cur curTempCur = dom.tempCur();
        String strSaveToString = new Saver.TextSaver(curTempCur, xmlOptions, null).saveToString();
        curTempCur.release();
        return strSaveToString;
    }

    public static String save(XmlCursor xmlCursor) {
        return save(xmlCursor, (XmlOptions) null);
    }

    public static String save(XmlCursor xmlCursor, XmlOptions xmlOptions) {
        String strSaveImpl;
        Cursor cursor = (Cursor) xmlCursor;
        Locale locale = cursor.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return saveImpl(cursor, xmlOptions);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                strSaveImpl = saveImpl(cursor, xmlOptions);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return strSaveImpl;
    }

    private static String saveImpl(Cursor cursor, XmlOptions xmlOptions) {
        Cur curTempCur = cursor.tempCur();
        String strSaveToString = new Saver.TextSaver(curTempCur, xmlOptions, null).saveToString();
        curTempCur.release();
        return strSaveToString;
    }

    public static XmlCursor newStore() {
        return newStore(null);
    }

    public static XmlCursor newStore(Saaj saaj) {
        XmlCursor xmlCursor_newStore;
        Locale localeNewLocale = newLocale(saaj);
        if (localeNewLocale.noSync()) {
            localeNewLocale.enter();
            try {
                return _newStore(localeNewLocale);
            } finally {
                localeNewLocale.exit();
            }
        }
        synchronized (localeNewLocale) {
            localeNewLocale.enter();
            try {
                xmlCursor_newStore = _newStore(localeNewLocale);
                localeNewLocale.exit();
            } catch (Throwable th) {
                localeNewLocale.exit();
                throw th;
            }
        }
        return xmlCursor_newStore;
    }

    public static XmlCursor _newStore(Locale locale) {
        Cur curTempCur = locale.tempCur();
        curTempCur.createRoot();
        Cursor cursor = new Cursor(curTempCur);
        curTempCur.release();
        return cursor;
    }

    public static XmlCursor getCursor(Node node) {
        XmlCursor xmlCursor;
        DomImpl.Dom dom = (DomImpl.Dom) node;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return DomImpl.getXmlCursor(dom);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                xmlCursor = DomImpl.getXmlCursor(dom);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return xmlCursor;
    }

    public static void dump(PrintStream printStream, DomImpl.Dom dom) {
        dom.dump(printStream);
    }

    public static void dump(PrintStream printStream, Node node) {
        dump(printStream, (DomImpl.Dom) node);
    }

    public static void dump(PrintStream printStream, XmlCursor xmlCursor) {
        ((Cursor) xmlCursor).dump(printStream);
    }

    public static void dump(PrintStream printStream, XmlObject xmlObject) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        DomImpl.Dom dom = (DomImpl.Dom) xmlCursorNewCursor.getDomNode();
        xmlCursorNewCursor.dispose();
        dump(printStream, dom);
    }

    public static void dump(DomImpl.Dom dom) {
        dump(System.out, dom);
    }

    public static void dump(Node node) {
        dump(System.out, node);
    }

    public static void dump(XmlCursor xmlCursor) {
        dump(System.out, xmlCursor);
    }

    public static void dump(XmlObject xmlObject) {
        dump(System.out, xmlObject);
    }

    private static class TestTypeStoreUser implements TypeStoreUser {
        private String _value;

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public void attach_store(TypeStore typeStore) {
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public void invalidate_value() {
        }

        TestTypeStoreUser(String str) {
            this._value = str;
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public SchemaType get_schema_type() {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public TypeStore get_store() {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public boolean uses_invalidate_value() {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public String build_text(NamespaceManager namespaceManager) {
            return this._value;
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public boolean build_nil() {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public void invalidate_nilvalue() {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public void invalidate_element_order() {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public void validate_now() {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public void disconnect_store() {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public TypeStoreUser create_element_user(QName qName, QName qName2) {
            return new TestTypeStoreUser("ELEM");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public TypeStoreUser create_attribute_user(QName qName) {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public String get_default_element_text(QName qName) {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public String get_default_attribute_text(QName qName) {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public SchemaType get_element_type(QName qName, QName qName2) {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public SchemaType get_attribute_type(QName qName) {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public int get_elementflags(QName qName) {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public int get_attributeflags(QName qName) {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public SchemaField get_attribute_field(QName qName) {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public boolean is_child_element_order_sensitive() {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public QNameSet get_element_ending_delimiters(QName qName) {
            throw new RuntimeException("Not impl");
        }

        @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
        public TypeStoreVisitor new_visitor() {
            throw new RuntimeException("Not impl");
        }
    }

    public static void test() throws Exception {
        Xobj xobj = (Xobj) parse("<a>XY</a>");
        Locale locale = xobj._locale;
        locale.enter();
        try {
            Cur curTempCur = xobj.tempCur();
            curTempCur.next();
            Cur curTempCur2 = curTempCur.tempCur();
            curTempCur2.next();
            Cur curTempCur3 = curTempCur2.tempCur();
            curTempCur3.nextChars(1);
            curTempCur3.tempCur().nextChars(1);
            curTempCur.dump();
            curTempCur.moveNodeContents(curTempCur, true);
            curTempCur.dump();
        } catch (Throwable th) {
            try {
                th.printStackTrace();
            } finally {
                locale.exit();
            }
        }
    }
}
