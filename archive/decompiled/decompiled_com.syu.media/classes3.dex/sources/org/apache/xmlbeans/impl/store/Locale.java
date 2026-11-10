package org.apache.xmlbeans.impl.store;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.CDataBookmark;
import org.apache.xmlbeans.QNameCache;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlLineNumber;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlOptionsBean;
import org.apache.xmlbeans.XmlRuntimeException;
import org.apache.xmlbeans.XmlSaxHandler;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ResolverUtil;
import org.apache.xmlbeans.impl.common.SAXHelper;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.apache.xmlbeans.impl.common.XMLNameHelper;
import org.apache.xmlbeans.impl.common.XmlLocale;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.xml.stream.Attribute;
import org.apache.xmlbeans.xml.stream.AttributeIterator;
import org.apache.xmlbeans.xml.stream.CharacterData;
import org.apache.xmlbeans.xml.stream.Comment;
import org.apache.xmlbeans.xml.stream.Location;
import org.apache.xmlbeans.xml.stream.ProcessingInstruction;
import org.apache.xmlbeans.xml.stream.Space;
import org.apache.xmlbeans.xml.stream.StartDocument;
import org.apache.xmlbeans.xml.stream.StartElement;
import org.apache.xmlbeans.xml.stream.XMLEvent;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLName;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DeclHandler;
import org.xml.sax.ext.LexicalHandler;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class Locale implements DOMImplementation, Saaj.SaajCallback, XmlLocale {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int ATTR = 3;
    static final int COMMENT = 4;
    public static final String COPY_USE_NEW_LOCALE = "COPY_USE_NEW_LOCALE";
    static final int ELEM = 2;
    static final int PROCINST = 5;
    static final int ROOT = 1;
    static final int TEXT = 0;
    public static final String USE_SAME_LOCALE = "USE_SAME_LOCALE";
    static final int WS_COLLAPSE = 3;
    static final int WS_PRESERVE = 1;
    static final int WS_REPLACE = 2;
    static final int WS_UNSPECIFIED = 0;
    static final String _schema = "http://www.w3.org/2001/XMLSchema";
    static final String _xml1998Uri = "http://www.w3.org/XML/1998/namespace";
    static final String _xmlnsUri = "http://www.w3.org/2000/xmlns/";
    int _cchSrc;
    ChangeListener _changeListeners;
    private CharUtil _charUtil;
    Cur _curPool;
    int _curPoolCount;
    private int _entryCount;
    Cur.Locations _locations;
    boolean _noSync;
    int _numTempFramesLeft;
    int _offSrc;
    DomImpl.Dom _ownerDoc;
    int _posTemp;
    QNameFactory _qnameFactory;
    private ReferenceQueue _refQueue;
    Cur _registered;
    Saaj _saaj;
    SchemaTypeLoader _schemaTypeLoader;
    Cur[] _tempFrames;
    boolean _validateOnSet;
    long _versionAll;
    long _versionSansText;
    static final String _xsi = "http://www.w3.org/2001/XMLSchema-instance";
    static final QName _xsiNil = new QName(_xsi, "nil", "xsi");
    static final QName _xsiType = new QName(_xsi, JamXmlElements.TYPE, "xsi");
    static final QName _xsiLoc = new QName(_xsi, "schemaLocation", "xsi");
    static final QName _xsiNoLoc = new QName(_xsi, "noNamespaceSchemaLocation", "xsi");
    static final String _openFragUri = "http://www.openuri.org/fragment";
    static final QName _openuriFragment = new QName(_openFragUri, "fragment", "frag");
    static final QName _xmlFragment = new QName("xml-fragment");
    private static ThreadLocal tl_scrubBuffer = new ThreadLocal() { // from class: org.apache.xmlbeans.impl.store.Locale.1
        @Override // java.lang.ThreadLocal
        protected Object initialValue() {
            return new SoftReference(new ScrubBuffer());
        }
    };
    nthCache _nthCache_A = new nthCache();
    nthCache _nthCache_B = new nthCache();
    domNthCache _domNthCache_A = new domNthCache();
    domNthCache _domNthCache_B = new domNthCache();

    interface ChangeListener {
        ChangeListener getNextChangeListener();

        void notifyChange();

        void setNextChangeListener(ChangeListener changeListener);
    }

    private Locale(SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions) {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        this._noSync = xmlOptionsMaskNull.hasOption("UNSYNCHRONIZED");
        this._numTempFramesLeft = 8;
        this._tempFrames = new Cur[8];
        this._qnameFactory = new DefaultQNameFactory();
        this._locations = new Cur.Locations(this);
        this._schemaTypeLoader = schemaTypeLoader;
        this._validateOnSet = xmlOptionsMaskNull.hasOption("VALIDATE_ON_SET");
        Object obj = xmlOptionsMaskNull.get(Saaj.SAAJ_IMPL);
        if (obj != null) {
            if (!(obj instanceof Saaj)) {
                throw new IllegalStateException("Saaj impl not correct type: " + obj);
            }
            Saaj saaj = (Saaj) obj;
            this._saaj = saaj;
            saaj.setCallback(this);
        }
    }

    static Locale getLocale(SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions) {
        Locale locale;
        if (schemaTypeLoader == null) {
            schemaTypeLoader = XmlBeans.getContextTypeLoader();
        }
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        if (xmlOptionsMaskNull.hasOption(USE_SAME_LOCALE)) {
            Object obj = xmlOptionsMaskNull.get(USE_SAME_LOCALE);
            if (obj instanceof Locale) {
                locale = (Locale) obj;
            } else if (obj instanceof XmlTokenSource) {
                locale = (Locale) ((XmlTokenSource) obj).monitor();
            } else {
                throw new IllegalArgumentException("Source locale not understood: " + obj);
            }
            if (locale._schemaTypeLoader != schemaTypeLoader) {
                throw new IllegalArgumentException("Source locale does not support same schema type loader");
            }
            Saaj saaj = locale._saaj;
            if (saaj != null && saaj != xmlOptionsMaskNull.get(Saaj.SAAJ_IMPL)) {
                throw new IllegalArgumentException("Source locale does not support same saaj");
            }
            if (!locale._validateOnSet || xmlOptionsMaskNull.hasOption("VALIDATE_ON_SET")) {
                return locale;
            }
            throw new IllegalArgumentException("Source locale does not support same validate on set");
        }
        return new Locale(schemaTypeLoader, xmlOptionsMaskNull);
    }

    static void associateSourceName(Cur cur, XmlOptions xmlOptions) {
        String str = (String) XmlOptions.safeGet(xmlOptions, "DOCUMENT_SOURCE_NAME");
        if (str != null) {
            getDocProps(cur, true).setSourceName(str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0034  */
    static void autoTypeDocument(Cur cur, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        SchemaType schemaTypeFindType;
        SchemaType schemaType2 = (SchemaType) XmlOptions.maskNull(xmlOptions).get("DOCUMENT_TYPE");
        if (schemaType2 != null) {
            cur.setType(schemaType2);
            return;
        }
        SchemaType schemaTypeFindAttributeType = null;
        if (schemaType == null || schemaType.getName() != null) {
            QName xsiTypeName = cur.getXsiTypeName();
            schemaTypeFindType = xsiTypeName == null ? null : cur._locale._schemaTypeLoader.findType(xsiTypeName);
            if (schemaType != null && !schemaType.isAssignableFrom(schemaTypeFindType)) {
                schemaTypeFindType = null;
            }
        } else {
            schemaTypeFindType = null;
        }
        if (schemaTypeFindType == null && (schemaType == null || schemaType.isDocumentType())) {
            cur.push();
            QName name = (cur.hasAttrs() || !toFirstChildElement(cur) || toNextSiblingElement(cur)) ? null : cur.getName();
            cur.pop();
            if (name != null && (schemaTypeFindType = cur._locale._schemaTypeLoader.findDocumentType(name)) != null && schemaType != null) {
                QName documentElementName = schemaType.getDocumentElementName();
                if (!documentElementName.equals(name) && !schemaType.isValidSubstitution(name)) {
                    throw new XmlException("Element " + QNameHelper.pretty(name) + " is not a valid " + QNameHelper.pretty(documentElementName) + " document or a valid substitution.");
                }
            }
        }
        if (schemaTypeFindType == null && schemaType == null) {
            cur.push();
            if (toFirstNormalAttr(cur) && !toNextNormalAttr(cur)) {
                schemaTypeFindAttributeType = cur._locale._schemaTypeLoader.findAttributeType(cur.getName());
            }
            cur.pop();
            schemaTypeFindType = schemaTypeFindAttributeType;
        }
        if (schemaTypeFindType == null) {
            schemaTypeFindType = schemaType;
        }
        if (schemaTypeFindType == null) {
            schemaTypeFindType = XmlBeans.NO_TYPE;
        }
        cur.setType(schemaTypeFindType);
        if (schemaType != null) {
            if (schemaTypeFindType.isDocumentType()) {
                verifyDocumentType(cur, schemaTypeFindType.getDocumentElementName());
            } else if (schemaTypeFindType.isAttributeType()) {
                verifyAttributeType(cur, schemaTypeFindType.getAttributeTypeAttributeName());
            }
        }
    }

    private static boolean namespacesSame(QName qName, QName qName2) {
        if (qName == qName2) {
            return true;
        }
        if (qName != null && qName2 != null) {
            if (qName.getNamespaceURI() == qName2.getNamespaceURI()) {
                return true;
            }
            if (qName.getNamespaceURI() != null && qName2.getNamespaceURI() != null) {
                return qName.getNamespaceURI().equals(qName2.getNamespaceURI());
            }
        }
        return $assertionsDisabled;
    }

    private static void addNamespace(StringBuffer stringBuffer, QName qName) {
        if (qName.getNamespaceURI() == null) {
            stringBuffer.append("<no namespace>");
            return;
        }
        stringBuffer.append("\"");
        stringBuffer.append(qName.getNamespaceURI());
        stringBuffer.append("\"");
    }

    private static void verifyDocumentType(Cur cur, QName qName) throws XmlException {
        StringBuffer stringBuffer;
        cur.push();
        try {
            if (!toFirstChildElement(cur) || toNextSiblingElement(cur)) {
                stringBuffer = new StringBuffer();
                stringBuffer.append("The document is not a ");
                stringBuffer.append(QNameHelper.pretty(qName));
                stringBuffer.append(cur.isRoot() ? ": no document element" : ": multiple document elements");
            } else {
                QName name = cur.getName();
                if (name.equals(qName)) {
                    stringBuffer = null;
                } else {
                    stringBuffer = new StringBuffer();
                    stringBuffer.append("The document is not a ");
                    stringBuffer.append(QNameHelper.pretty(qName));
                    if (qName.getLocalPart().equals(name.getLocalPart())) {
                        stringBuffer.append(": document element namespace mismatch ");
                        stringBuffer.append("expected ");
                        addNamespace(stringBuffer, qName);
                        stringBuffer.append(" got ");
                        addNamespace(stringBuffer, name);
                    } else if (namespacesSame(qName, name)) {
                        stringBuffer.append(": document element local name mismatch ");
                        stringBuffer.append("expected " + qName.getLocalPart());
                        stringBuffer.append(" got " + name.getLocalPart());
                    } else {
                        stringBuffer.append(": document element mismatch ");
                        stringBuffer.append("got ");
                        stringBuffer.append(QNameHelper.pretty(name));
                    }
                }
            }
            if (stringBuffer != null) {
                XmlError xmlErrorForCursor = XmlError.forCursor(stringBuffer.toString(), new Cursor(cur));
                throw new XmlException(xmlErrorForCursor.toString(), (Throwable) null, xmlErrorForCursor);
            }
            cur.pop();
        } catch (Throwable th) {
            cur.pop();
            throw th;
        }
    }

    private static void verifyAttributeType(Cur cur, QName qName) throws XmlException {
        StringBuffer stringBuffer;
        cur.push();
        try {
            if (!toFirstNormalAttr(cur) || toNextNormalAttr(cur)) {
                stringBuffer = new StringBuffer();
                stringBuffer.append("The document is not a ");
                stringBuffer.append(QNameHelper.pretty(qName));
                stringBuffer.append(cur.isRoot() ? ": no attributes" : ": multiple attributes");
            } else {
                QName name = cur.getName();
                if (name.equals(qName)) {
                    stringBuffer = null;
                } else {
                    stringBuffer = new StringBuffer();
                    stringBuffer.append("The document is not a ");
                    stringBuffer.append(QNameHelper.pretty(qName));
                    if (qName.getLocalPart().equals(name.getLocalPart())) {
                        stringBuffer.append(": attribute namespace mismatch ");
                        stringBuffer.append("expected ");
                        addNamespace(stringBuffer, qName);
                        stringBuffer.append(" got ");
                        addNamespace(stringBuffer, name);
                    } else if (namespacesSame(qName, name)) {
                        stringBuffer.append(": attribute local name mismatch ");
                        stringBuffer.append("expected " + qName.getLocalPart());
                        stringBuffer.append(" got " + name.getLocalPart());
                    } else {
                        stringBuffer.append(": attribute element mismatch ");
                        stringBuffer.append("got ");
                        stringBuffer.append(QNameHelper.pretty(name));
                    }
                }
            }
            if (stringBuffer != null) {
                XmlError xmlErrorForCursor = XmlError.forCursor(stringBuffer.toString(), new Cursor(cur));
                throw new XmlException(xmlErrorForCursor.toString(), (Throwable) null, xmlErrorForCursor);
            }
            cur.pop();
        } catch (Throwable th) {
            cur.pop();
            throw th;
        }
    }

    static boolean isFragmentQName(QName qName) {
        if (qName.equals(_openuriFragment) || qName.equals(_xmlFragment)) {
            return true;
        }
        return $assertionsDisabled;
    }

    static boolean isFragment(Cur cur, Cur cur2) {
        boolean z;
        int iKind;
        cur.push();
        cur2.push();
        int i = 0;
        while (true) {
            if (cur.isSamePos(cur2) || (iKind = cur.kind()) == 3) {
                z = false;
            } else if ((iKind != 0 || isWhiteSpace(cur.getCharsAsString(-1))) && (iKind != 2 || (i = i + 1) <= 1)) {
                if (iKind != 0) {
                    cur.toEnd();
                }
                cur.next();
            } else {
                z = true;
            }
            cur.pop();
            cur2.pop();
            if (z || i != 1) {
                return true;
            }
            return $assertionsDisabled;
        }
    }

    public static XmlObject newInstance(SchemaTypeLoader schemaTypeLoader, SchemaType schemaType, XmlOptions xmlOptions) {
        XmlObject xmlObjectNewInstance;
        Locale locale = getLocale(schemaTypeLoader, xmlOptions);
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale.newInstance(schemaType, xmlOptions);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                xmlObjectNewInstance = locale.newInstance(schemaType, xmlOptions);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return xmlObjectNewInstance;
    }

    private XmlObject newInstance(SchemaType schemaType, XmlOptions xmlOptions) {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        Cur curTempCur = tempCur();
        SchemaType schemaType2 = (SchemaType) xmlOptionsMaskNull.get("DOCUMENT_TYPE");
        if (schemaType2 == null) {
            if (schemaType == null) {
                schemaType = XmlObject.type;
            }
            schemaType2 = schemaType;
        }
        if (schemaType2.isDocumentType()) {
            curTempCur.createDomDocumentRoot();
        } else {
            curTempCur.createRoot();
        }
        curTempCur.setType(schemaType2);
        XmlObject user = curTempCur.getUser();
        curTempCur.release();
        return user;
    }

    public static DOMImplementation newDomImplementation(SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions) {
        return getLocale(schemaTypeLoader, xmlOptions);
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, String str, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        XmlObject toXmlObject;
        Locale locale = getLocale(schemaTypeLoader, xmlOptions);
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale.parseToXmlObject(str, schemaType, xmlOptions);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                toXmlObject = locale.parseToXmlObject(str, schemaType, xmlOptions);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return toXmlObject;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlException */
    private XmlObject parseToXmlObject(String str, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        Cur cur = parse(str, schemaType, xmlOptions);
        XmlObject user = cur.getUser();
        cur.release();
        return user;
    }

    Cur parse(String str, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        StringReader stringReader = new StringReader(str);
        try {
            try {
                Cur curLoad = getSaxLoader(xmlOptions).load(this, new InputSource(stringReader), xmlOptions);
                autoTypeDocument(curLoad, schemaType, xmlOptions);
                try {
                    stringReader.close();
                } catch (IOException unused) {
                }
                return curLoad;
            } catch (IOException e) {
                throw new XmlException(e.getMessage(), e);
            }
        } catch (Throwable th) {
            try {
                stringReader.close();
            } catch (IOException unused2) {
            }
            throw th;
        }
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, XMLInputStream xMLInputStream, SchemaType schemaType, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
        XmlObject toXmlObject;
        Locale locale = getLocale(schemaTypeLoader, xmlOptions);
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale.parseToXmlObject(xMLInputStream, schemaType, xmlOptions);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                toXmlObject = locale.parseToXmlObject(xMLInputStream, schemaType, xmlOptions);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return toXmlObject;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlException */
    public XmlObject parseToXmlObject(XMLInputStream xMLInputStream, SchemaType schemaType, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
        try {
            Cur curLoadXMLInputStream = loadXMLInputStream(xMLInputStream, xmlOptions);
            autoTypeDocument(curLoadXMLInputStream, schemaType, xmlOptions);
            XmlObject user = curLoadXMLInputStream.getUser();
            curLoadXMLInputStream.release();
            return user;
        } catch (XMLStreamException e) {
            throw new XmlException(e.getMessage(), e);
        }
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, XMLStreamReader xMLStreamReader, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        XmlObject toXmlObject;
        Locale locale = getLocale(schemaTypeLoader, xmlOptions);
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale.parseToXmlObject(xMLStreamReader, schemaType, xmlOptions);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                toXmlObject = locale.parseToXmlObject(xMLStreamReader, schemaType, xmlOptions);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return toXmlObject;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlException */
    public XmlObject parseToXmlObject(XMLStreamReader xMLStreamReader, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        try {
            Cur curLoadXMLStreamReader = loadXMLStreamReader(xMLStreamReader, xmlOptions);
            autoTypeDocument(curLoadXMLStreamReader, schemaType, xmlOptions);
            XmlObject user = curLoadXMLStreamReader.getUser();
            curLoadXMLStreamReader.release();
            return user;
        } catch (javax.xml.stream.XMLStreamException e) {
            throw new XmlException(e.getMessage(), e);
        }
    }

    private static void lineNumber(XMLEvent xMLEvent, LoadContext loadContext) {
        Location location = xMLEvent.getLocation();
        if (location != null) {
            loadContext.lineNumber(location.getLineNumber(), location.getColumnNumber(), -1);
        }
    }

    private static void lineNumber(XMLStreamReader xMLStreamReader, LoadContext loadContext) {
        javax.xml.stream.Location location = xMLStreamReader.getLocation();
        if (location != null) {
            loadContext.lineNumber(location.getLineNumber(), location.getColumnNumber(), location.getCharacterOffset());
        }
    }

    private void doAttributes(XMLStreamReader xMLStreamReader, LoadContext loadContext) {
        int attributeCount = xMLStreamReader.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            loadContext.attr(xMLStreamReader.getAttributeLocalName(i), xMLStreamReader.getAttributeNamespace(i), xMLStreamReader.getAttributePrefix(i), xMLStreamReader.getAttributeValue(i));
        }
    }

    private void doNamespaces(XMLStreamReader xMLStreamReader, LoadContext loadContext) {
        int namespaceCount = xMLStreamReader.getNamespaceCount();
        for (int i = 0; i < namespaceCount; i++) {
            String namespacePrefix = xMLStreamReader.getNamespacePrefix(i);
            if (namespacePrefix == null || namespacePrefix.length() == 0) {
                loadContext.attr(Sax2Dom.XMLNS_PREFIX, "http://www.w3.org/2000/xmlns/", null, xMLStreamReader.getNamespaceURI(i));
            } else {
                loadContext.attr(namespacePrefix, "http://www.w3.org/2000/xmlns/", Sax2Dom.XMLNS_PREFIX, xMLStreamReader.getNamespaceURI(i));
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:36:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:77:0x0151 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x0151 A[SYNTHETIC] */
    private Cur loadXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException {
        CharacterData characterData;
        Map namespaceMap;
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        boolean zHasOption = xmlOptionsMaskNull.hasOption("LOAD_LINE_NUMBERS");
        XMLEvent xMLEventPeek = xMLInputStream.peek();
        if (xMLEventPeek != null && xMLEventPeek.getType() == 2 && (namespaceMap = ((StartElement) xMLEventPeek).getNamespaceMap()) != null && namespaceMap.size() > 0) {
            HashMap map = new HashMap();
            map.putAll(namespaceMap);
            XmlOptions xmlOptions2 = new XmlOptions(xmlOptionsMaskNull);
            xmlOptions2.put("LOAD_ADDITIONAL_NAMESPACES", map);
            xmlOptionsMaskNull = xmlOptions2;
        }
        Cur.CurLoadContext curLoadContext = new Cur.CurLoadContext(this, xmlOptionsMaskNull);
        XMLEvent next = xMLInputStream.next();
        String str = null;
        boolean z = true;
        String str2 = null;
        String str3 = null;
        while (next != null) {
            int type = next.getType();
            if (type != 1) {
                if (type == 2) {
                    curLoadContext.startElement(XMLNameHelper.getQName(next.getName()));
                    if (zHasOption) {
                        lineNumber(next, curLoadContext);
                    }
                    StartElement startElement = (StartElement) next;
                    AttributeIterator attributes = startElement.getAttributes();
                    while (attributes.hasNext()) {
                        Attribute next2 = attributes.next();
                        curLoadContext.attr(XMLNameHelper.getQName(next2.getName()), next2.getValue());
                    }
                    AttributeIterator namespaces = startElement.getNamespaces();
                    while (namespaces.hasNext()) {
                        Attribute next3 = namespaces.next();
                        XMLName name = next3.getName();
                        String localName = name.getLocalName();
                        if (name.getPrefix() == null && localName.equals(Sax2Dom.XMLNS_PREFIX)) {
                            localName = "";
                        }
                        curLoadContext.xmlns(localName, next3.getValue());
                    }
                } else {
                    switch (type) {
                        case 4:
                            curLoadContext.endElement();
                            if (zHasOption) {
                                lineNumber(next, curLoadContext);
                            }
                            break;
                        case 8:
                            ProcessingInstruction processingInstruction = (ProcessingInstruction) next;
                            curLoadContext.procInst(processingInstruction.getTarget(), processingInstruction.getData());
                            if (zHasOption) {
                                lineNumber(next, curLoadContext);
                            }
                            break;
                        case 16:
                            characterData = (CharacterData) next;
                            if (characterData.hasContent()) {
                                curLoadContext.text(characterData.getContent());
                                if (zHasOption) {
                                    lineNumber(next, curLoadContext);
                                }
                            }
                            break;
                        case 32:
                            Comment comment = (Comment) next;
                            if (comment.hasContent()) {
                                curLoadContext.comment(comment.getContent());
                                if (zHasOption) {
                                    lineNumber(next, curLoadContext);
                                }
                            }
                            break;
                        case 64:
                            if (!((Space) next).ignorable()) {
                                characterData = (CharacterData) next;
                                if (characterData.hasContent()) {
                                    curLoadContext.text(characterData.getContent());
                                    if (zHasOption) {
                                        lineNumber(next, curLoadContext);
                                    }
                                }
                            }
                            break;
                        case 128:
                            if (!xMLInputStream.hasNext()) {
                                Cur curFinish = curLoadContext.finish();
                                associateSourceName(curFinish, xmlOptionsMaskNull);
                                XmlDocumentProperties docProps = getDocProps(curFinish, true);
                                docProps.setDoctypeSystemId(str);
                                docProps.setEncoding(str2);
                                docProps.setVersion(str3);
                                docProps.setStandalone(z);
                                return curFinish;
                            }
                            break;
                            break;
                        case 256:
                            StartDocument startDocument = (StartDocument) next;
                            String systemId = startDocument.getSystemId();
                            String characterEncodingScheme = startDocument.getCharacterEncodingScheme();
                            String version = startDocument.getVersion();
                            startDocument.isStandalone();
                            boolean zIsStandalone = startDocument.isStandalone();
                            if (zHasOption) {
                                lineNumber(next, curLoadContext);
                            }
                            z = zIsStandalone;
                            str = systemId;
                            str2 = characterEncodingScheme;
                            str3 = version;
                            break;
                        case 512:
                            if (zHasOption) {
                                lineNumber(next, curLoadContext);
                            }
                            Cur curFinish2 = curLoadContext.finish();
                            associateSourceName(curFinish2, xmlOptionsMaskNull);
                            XmlDocumentProperties docProps2 = getDocProps(curFinish2, true);
                            docProps2.setDoctypeSystemId(str);
                            docProps2.setEncoding(str2);
                            docProps2.setVersion(str3);
                            docProps2.setStandalone(z);
                            return curFinish2;
                        case XMLEvent.START_PREFIX_MAPPING /* 1024 */:
                        case XMLEvent.END_PREFIX_MAPPING /* 2048 */:
                        case XMLEvent.CHANGE_PREFIX_MAPPING /* 4096 */:
                        case XMLEvent.ENTITY_REFERENCE /* 8192 */:
                            break;
                        default:
                            throw new RuntimeException("Unhandled xml event type: " + next.getTypeAsString());
                    }
                }
            }
            next = xMLInputStream.next();
        }
        Cur curFinish3 = curLoadContext.finish();
        associateSourceName(curFinish3, xmlOptionsMaskNull);
        XmlDocumentProperties docProps3 = getDocProps(curFinish3, true);
        docProps3.setDoctypeSystemId(str);
        docProps3.setEncoding(str2);
        docProps3.setVersion(str3);
        docProps3.setStandalone(z);
        return curFinish3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:33:0x00b9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:40:0x00c2 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    private Cur loadXMLStreamReader(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws javax.xml.stream.XMLStreamException {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        boolean zHasOption = xmlOptionsMaskNull.hasOption("LOAD_LINE_NUMBERS");
        Cur.CurLoadContext curLoadContext = new Cur.CurLoadContext(this, xmlOptionsMaskNull);
        int eventType = xMLStreamReader.getEventType();
        String str = null;
        int i = 0;
        boolean z = false;
        String str2 = null;
        while (true) {
            switch (eventType) {
                case 1:
                    i++;
                    curLoadContext.startElement(xMLStreamReader.getName());
                    if (zHasOption) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    doAttributes(xMLStreamReader, curLoadContext);
                    doNamespaces(xMLStreamReader, curLoadContext);
                    if (!xMLStreamReader.hasNext() && i > 0) {
                        eventType = xMLStreamReader.next();
                    } else {
                        Cur curFinish = curLoadContext.finish();
                        associateSourceName(curFinish, xmlOptionsMaskNull);
                        XmlDocumentProperties docProps = getDocProps(curFinish, true);
                        docProps.setEncoding(str);
                        docProps.setVersion(str2);
                        docProps.setStandalone(z);
                        return curFinish;
                    }
                    break;
                case 2:
                    i--;
                    curLoadContext.endElement();
                    if (zHasOption) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    if (!xMLStreamReader.hasNext()) {
                    }
                    Cur curFinish2 = curLoadContext.finish();
                    associateSourceName(curFinish2, xmlOptionsMaskNull);
                    XmlDocumentProperties docProps2 = getDocProps(curFinish2, true);
                    docProps2.setEncoding(str);
                    docProps2.setVersion(str2);
                    docProps2.setStandalone(z);
                    return curFinish2;
                case 3:
                    curLoadContext.procInst(xMLStreamReader.getPITarget(), xMLStreamReader.getPIData());
                    if (zHasOption) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    if (!xMLStreamReader.hasNext()) {
                    }
                    Cur curFinish3 = curLoadContext.finish();
                    associateSourceName(curFinish3, xmlOptionsMaskNull);
                    XmlDocumentProperties docProps3 = getDocProps(curFinish3, true);
                    docProps3.setEncoding(str);
                    docProps3.setVersion(str2);
                    docProps3.setStandalone(z);
                    return curFinish3;
                case 4:
                case 12:
                    curLoadContext.text(xMLStreamReader.getTextCharacters(), xMLStreamReader.getTextStart(), xMLStreamReader.getTextLength());
                    if (zHasOption) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    if (!xMLStreamReader.hasNext()) {
                    }
                    Cur curFinish4 = curLoadContext.finish();
                    associateSourceName(curFinish4, xmlOptionsMaskNull);
                    XmlDocumentProperties docProps4 = getDocProps(curFinish4, true);
                    docProps4.setEncoding(str);
                    docProps4.setVersion(str2);
                    docProps4.setStandalone(z);
                    return curFinish4;
                case 5:
                    curLoadContext.comment(xMLStreamReader.getText());
                    if (zHasOption) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    if (!xMLStreamReader.hasNext()) {
                    }
                    Cur curFinish5 = curLoadContext.finish();
                    associateSourceName(curFinish5, xmlOptionsMaskNull);
                    XmlDocumentProperties docProps5 = getDocProps(curFinish5, true);
                    docProps5.setEncoding(str);
                    docProps5.setVersion(str2);
                    docProps5.setStandalone(z);
                    return curFinish5;
                case 6:
                case 11:
                    if (!xMLStreamReader.hasNext()) {
                    }
                    Cur curFinish6 = curLoadContext.finish();
                    associateSourceName(curFinish6, xmlOptionsMaskNull);
                    XmlDocumentProperties docProps6 = getDocProps(curFinish6, true);
                    docProps6.setEncoding(str);
                    docProps6.setVersion(str2);
                    docProps6.setStandalone(z);
                    return curFinish6;
                case 7:
                    i++;
                    String characterEncodingScheme = xMLStreamReader.getCharacterEncodingScheme();
                    String version = xMLStreamReader.getVersion();
                    boolean zIsStandalone = xMLStreamReader.isStandalone();
                    if (zHasOption) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    z = zIsStandalone;
                    str2 = version;
                    str = characterEncodingScheme;
                    if (!xMLStreamReader.hasNext()) {
                    }
                    Cur curFinish7 = curLoadContext.finish();
                    associateSourceName(curFinish7, xmlOptionsMaskNull);
                    XmlDocumentProperties docProps7 = getDocProps(curFinish7, true);
                    docProps7.setEncoding(str);
                    docProps7.setVersion(str2);
                    docProps7.setStandalone(z);
                    return curFinish7;
                case 8:
                    if (zHasOption) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    Cur curFinish8 = curLoadContext.finish();
                    associateSourceName(curFinish8, xmlOptionsMaskNull);
                    XmlDocumentProperties docProps8 = getDocProps(curFinish8, true);
                    docProps8.setEncoding(str);
                    docProps8.setVersion(str2);
                    docProps8.setStandalone(z);
                    return curFinish8;
                case 9:
                    curLoadContext.text(xMLStreamReader.getText());
                    if (!xMLStreamReader.hasNext()) {
                    }
                    Cur curFinish9 = curLoadContext.finish();
                    associateSourceName(curFinish9, xmlOptionsMaskNull);
                    XmlDocumentProperties docProps9 = getDocProps(curFinish9, true);
                    docProps9.setEncoding(str);
                    docProps9.setVersion(str2);
                    docProps9.setStandalone(z);
                    return curFinish9;
                case 10:
                    doAttributes(xMLStreamReader, curLoadContext);
                    if (!xMLStreamReader.hasNext()) {
                    }
                    Cur curFinish10 = curLoadContext.finish();
                    associateSourceName(curFinish10, xmlOptionsMaskNull);
                    XmlDocumentProperties docProps10 = getDocProps(curFinish10, true);
                    docProps10.setEncoding(str);
                    docProps10.setVersion(str2);
                    docProps10.setStandalone(z);
                    return curFinish10;
                case 13:
                    doNamespaces(xMLStreamReader, curLoadContext);
                    if (!xMLStreamReader.hasNext()) {
                    }
                    Cur curFinish11 = curLoadContext.finish();
                    associateSourceName(curFinish11, xmlOptionsMaskNull);
                    XmlDocumentProperties docProps11 = getDocProps(curFinish11, true);
                    docProps11.setEncoding(str);
                    docProps11.setVersion(str2);
                    docProps11.setStandalone(z);
                    return curFinish11;
                default:
                    throw new RuntimeException("Unhandled xml event type: " + eventType);
            }
        }
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, InputStream inputStream, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException {
        XmlObject toXmlObject;
        Locale locale = getLocale(schemaTypeLoader, xmlOptions);
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale.parseToXmlObject(inputStream, schemaType, xmlOptions);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                toXmlObject = locale.parseToXmlObject(inputStream, schemaType, xmlOptions);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return toXmlObject;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlException */
    private XmlObject parseToXmlObject(InputStream inputStream, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException {
        Cur curLoad = getSaxLoader(xmlOptions).load(this, new InputSource(inputStream), xmlOptions);
        autoTypeDocument(curLoad, schemaType, xmlOptions);
        XmlObject user = curLoad.getUser();
        curLoad.release();
        return user;
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, Reader reader, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException {
        XmlObject toXmlObject;
        Locale locale = getLocale(schemaTypeLoader, xmlOptions);
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale.parseToXmlObject(reader, schemaType, xmlOptions);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                toXmlObject = locale.parseToXmlObject(reader, schemaType, xmlOptions);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return toXmlObject;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlException */
    private XmlObject parseToXmlObject(Reader reader, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException {
        Cur curLoad = getSaxLoader(xmlOptions).load(this, new InputSource(reader), xmlOptions);
        autoTypeDocument(curLoad, schemaType, xmlOptions);
        XmlObject user = curLoad.getUser();
        curLoad.release();
        return user;
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, Node node, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        XmlObject toXmlObject;
        Locale locale = getLocale(schemaTypeLoader, xmlOptions);
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale.parseToXmlObject(node, schemaType, xmlOptions);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                toXmlObject = locale.parseToXmlObject(node, schemaType, xmlOptions);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return toXmlObject;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlException */
    public XmlObject parseToXmlObject(Node node, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        Cur.CurLoadContext curLoadContext = new Cur.CurLoadContext(this, xmlOptions);
        loadNode(node, curLoadContext);
        Cur curFinish = curLoadContext.finish();
        associateSourceName(curFinish, xmlOptions);
        autoTypeDocument(curFinish, schemaType, xmlOptions);
        XmlObject user = curFinish.getUser();
        curFinish.release();
        return user;
    }

    private void loadNodeChildren(Node node, LoadContext loadContext) {
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            loadNode(firstChild, loadContext);
        }
    }

    void loadNode(Node node, LoadContext loadContext) {
        switch (node.getNodeType()) {
            case 1:
                loadContext.startElement(makeQualifiedQName(node.getNamespaceURI(), node.getNodeName()));
                NamedNodeMap attributes = node.getAttributes();
                for (int i = 0; i < attributes.getLength(); i++) {
                    Node nodeItem = attributes.item(i);
                    String nodeName = nodeItem.getNodeName();
                    String nodeValue = nodeItem.getNodeValue();
                    if (nodeName.toLowerCase().startsWith(Sax2Dom.XMLNS_PREFIX)) {
                        if (nodeName.length() == 5) {
                            loadContext.xmlns(null, nodeValue);
                        } else {
                            loadContext.xmlns(nodeName.substring(6), nodeValue);
                        }
                    } else {
                        loadContext.attr(makeQualifiedQName(nodeItem.getNamespaceURI(), nodeName), nodeValue);
                    }
                }
                loadNodeChildren(node, loadContext);
                loadContext.endElement();
                return;
            case 2:
                throw new RuntimeException("Unexpected node");
            case 3:
            case 4:
                loadContext.text(node.getNodeValue());
                return;
            case 5:
            case 9:
            case 11:
                loadNodeChildren(node, loadContext);
                return;
            case 6:
            case 10:
            case 12:
                Node nextSibling = node.getNextSibling();
                if (nextSibling != null) {
                    loadNode(nextSibling, loadContext);
                    return;
                }
                return;
            case 7:
                loadContext.procInst(node.getNodeName(), node.getNodeValue());
                return;
            case 8:
                loadContext.comment(node.getNodeValue());
                return;
            default:
                return;
        }
    }

    private class XmlSaxHandlerImpl extends SaxHandler implements XmlSaxHandler {
        private XmlOptions _options;
        private SchemaType _type;

        XmlSaxHandlerImpl(Locale locale, SchemaType schemaType, XmlOptions xmlOptions) {
            super(null);
            this._options = xmlOptions;
            this._type = schemaType;
            XmlOptions xmlOptions2 = new XmlOptions(xmlOptions);
            xmlOptions2.put("LOAD_USE_LOCALE_CHAR_UTIL");
            initSaxHandler(locale, xmlOptions2);
        }

        public ContentHandler getContentHandler() {
            if (this._context == null) {
                return null;
            }
            return this;
        }

        public LexicalHandler getLexicalHandler() {
            if (this._context == null) {
                return null;
            }
            return this;
        }

        public void bookmarkLastEvent(XmlCursor.XmlBookmark xmlBookmark) {
            this._context.bookmarkLastNonAttr(xmlBookmark);
        }

        public void bookmarkLastAttr(QName qName, XmlCursor.XmlBookmark xmlBookmark) {
            this._context.bookmarkLastAttr(qName, xmlBookmark);
        }

        public XmlObject getObject() throws XmlException {
            if (this._context == null) {
                return null;
            }
            this._locale.enter();
            try {
                Cur curFinish = this._context.finish();
                Locale.autoTypeDocument(curFinish, this._type, this._options);
                XmlObject user = curFinish.getUser();
                curFinish.release();
                this._context = null;
                return user;
            } finally {
                this._locale.exit();
            }
        }
    }

    public static XmlSaxHandler newSaxHandler(SchemaTypeLoader schemaTypeLoader, SchemaType schemaType, XmlOptions xmlOptions) {
        XmlSaxHandler xmlSaxHandlerNewSaxHandler;
        Locale locale = getLocale(schemaTypeLoader, xmlOptions);
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale.newSaxHandler(schemaType, xmlOptions);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                xmlSaxHandlerNewSaxHandler = locale.newSaxHandler(schemaType, xmlOptions);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return xmlSaxHandlerNewSaxHandler;
    }

    public XmlSaxHandler newSaxHandler(SchemaType schemaType, XmlOptions xmlOptions) {
        return new XmlSaxHandlerImpl(this, schemaType, xmlOptions);
    }

    QName makeQName(String str, String str2) {
        return this._qnameFactory.getQName(str, str2);
    }

    QName makeQNameNoCheck(String str, String str2) {
        return this._qnameFactory.getQName(str, str2);
    }

    QName makeQName(String str, String str2, String str3) {
        QNameFactory qNameFactory = this._qnameFactory;
        if (str3 == null) {
            str3 = "";
        }
        return qNameFactory.getQName(str, str2, str3);
    }

    QName makeQualifiedQName(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        int iIndexOf = str2.indexOf(58);
        return iIndexOf < 0 ? this._qnameFactory.getQName(str, str2) : this._qnameFactory.getQName(str, str2.substring(iIndexOf + 1), str2.substring(0, iIndexOf));
    }

    private static class DocProps extends XmlDocumentProperties {
        private HashMap _map;

        private DocProps() {
            this._map = new HashMap();
        }

        public Object put(Object obj, Object obj2) {
            return this._map.put(obj, obj2);
        }

        public Object get(Object obj) {
            return this._map.get(obj);
        }

        public Object remove(Object obj) {
            return this._map.remove(obj);
        }
    }

    static XmlDocumentProperties getDocProps(Cur cur, boolean z) {
        cur.push();
        while (cur.toParent()) {
        }
        DocProps docProps = (DocProps) cur.getBookmark(DocProps.class);
        if (docProps == null && z) {
            docProps = new DocProps();
            cur.setBookmark(DocProps.class, docProps);
        }
        cur.pop();
        return docProps;
    }

    void registerForChange(ChangeListener changeListener) {
        if (changeListener.getNextChangeListener() == null) {
            ChangeListener changeListener2 = this._changeListeners;
            if (changeListener2 == null) {
                changeListener.setNextChangeListener(changeListener);
            } else {
                changeListener.setNextChangeListener(changeListener2);
            }
            this._changeListeners = changeListener;
        }
    }

    void notifyChange() {
        while (true) {
            ChangeListener changeListener = this._changeListeners;
            if (changeListener != null) {
                changeListener.notifyChange();
                ChangeListener nextChangeListener = this._changeListeners.getNextChangeListener();
                ChangeListener changeListener2 = this._changeListeners;
                if (nextChangeListener == changeListener2) {
                    changeListener2.setNextChangeListener(null);
                }
                ChangeListener nextChangeListener2 = this._changeListeners.getNextChangeListener();
                this._changeListeners.setNextChangeListener(null);
                this._changeListeners = nextChangeListener2;
            } else {
                this._locations.notifyChange();
                return;
            }
        }
    }

    static String getTextValue(Cur cur) {
        if (!cur.hasChildren()) {
            return cur.getValueAsString();
        }
        StringBuffer stringBuffer = new StringBuffer();
        cur.push();
        while (true) {
            cur.next();
            if (!cur.isAtEndOfLastPush()) {
                if (cur.isText() && ((!cur._xobj.isComment() && !cur._xobj.isProcinst()) || cur._pos >= cur._xobj._cchValue)) {
                    CharUtil.getString(stringBuffer, cur.getChars(-1), cur._offSrc, cur._cchSrc);
                }
            } else {
                cur.pop();
                return stringBuffer.toString();
            }
        }
    }

    static int getTextValue(Cur cur, int i, char[] cArr, int i2, int i3) {
        String valueAsString = cur._xobj.getValueAsString(i);
        int length = valueAsString.length();
        if (length <= i3) {
            i3 = length;
        }
        if (i3 <= 0) {
            return 0;
        }
        valueAsString.getChars(0, i3, cArr, i2);
        return i3;
    }

    static String applyWhiteSpaceRule(String str, int i) {
        boolean z = $assertionsDisabled;
        int length = str == null ? 0 : str.length();
        if (length == 0) {
            return str;
        }
        int i2 = 1;
        if (i == 1) {
            return str;
        }
        if (i == 2) {
            for (int i3 = 0; i3 < length; i3++) {
                char cCharAt = str.charAt(i3);
                if (cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t') {
                    return processWhiteSpaceRule(str, i);
                }
            }
            return str;
        }
        if (i != 3) {
            return str;
        }
        if (CharUtil.isWhiteSpace(str.charAt(0)) || CharUtil.isWhiteSpace(str.charAt(length - 1))) {
            return processWhiteSpaceRule(str, i);
        }
        while (i2 < length) {
            boolean zIsWhiteSpace = CharUtil.isWhiteSpace(str.charAt(i2));
            if (zIsWhiteSpace && z) {
                return processWhiteSpaceRule(str, i);
            }
            i2++;
            z = zIsWhiteSpace;
        }
        return str;
    }

    static String processWhiteSpaceRule(String str, int i) {
        ScrubBuffer scrubBuffer = getScrubBuffer(i);
        scrubBuffer.scrub(str, 0, str.length());
        return scrubBuffer.getResultAsString();
    }

    static final class ScrubBuffer {
        private static final int NOSPACE_STATE = 2;
        private static final int SPACE_SEEN_STATE = 1;
        private static final int START_STATE = 0;
        private int _state;
        private int _wsr;
        private char[] _srcBuf = new char[XMLEvent.START_PREFIX_MAPPING];
        private StringBuffer _sb = new StringBuffer();

        ScrubBuffer() {
        }

        void init(int i) {
            StringBuffer stringBuffer = this._sb;
            stringBuffer.delete(0, stringBuffer.length());
            this._wsr = i;
            this._state = 0;
        }

        void scrub(Object obj, int i, int i2) {
            char[] cArr;
            if (i2 == 0) {
                return;
            }
            if (this._wsr == 1) {
                CharUtil.getString(this._sb, obj, i, i2);
                return;
            }
            if (obj instanceof char[]) {
                cArr = (char[]) obj;
            } else {
                char[] cArr2 = this._srcBuf;
                if (i2 > cArr2.length) {
                    if (i2 <= 16384) {
                        cArr2 = new char[16384];
                        this._srcBuf = cArr2;
                    } else {
                        cArr2 = new char[i2];
                    }
                }
                CharUtil.getChars(cArr2, 0, obj, i, i2);
                cArr = cArr2;
                i = 0;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                char c = cArr[i + i4];
                if (c == ' ' || c == '\n' || c == '\r' || c == '\t') {
                    this._sb.append(cArr, i + i3, i4 - i3);
                    i3 = i4 + 1;
                    if (this._wsr == 2) {
                        this._sb.append(' ');
                    } else if (this._state == 2) {
                        this._state = 1;
                    }
                } else {
                    if (this._state == 1) {
                        this._sb.append(' ');
                    }
                    this._state = 2;
                }
            }
            this._sb.append(cArr, i + i3, i2 - i3);
        }

        String getResultAsString() {
            return this._sb.toString();
        }
    }

    public static void clearThreadLocals() {
        tl_scrubBuffer.remove();
    }

    static ScrubBuffer getScrubBuffer(int i) {
        ScrubBuffer scrubBuffer = (ScrubBuffer) ((SoftReference) tl_scrubBuffer.get()).get();
        if (scrubBuffer == null) {
            scrubBuffer = new ScrubBuffer();
            tl_scrubBuffer.set(new SoftReference(scrubBuffer));
        }
        scrubBuffer.init(i);
        return scrubBuffer;
    }

    static boolean pushToContainer(Cur cur) {
        cur.push();
        while (true) {
            int iKind = cur.kind();
            if (iKind == -2 || iKind == -1) {
                break;
            }
            if (iKind == 1 || iKind == 2) {
                return true;
            }
            if (iKind == 4 || iKind == 5) {
                cur.skip();
            } else {
                cur.nextWithAttrs();
            }
        }
        cur.pop();
        return $assertionsDisabled;
    }

    static boolean toFirstNormalAttr(Cur cur) {
        cur.push();
        if (cur.toFirstAttr()) {
            while (cur.isXmlns()) {
                if (!cur.toNextAttr()) {
                }
            }
            cur.popButStay();
            return true;
        }
        cur.pop();
        return $assertionsDisabled;
    }

    static boolean toPrevNormalAttr(Cur cur) {
        if (!cur.isAttr()) {
            return $assertionsDisabled;
        }
        cur.push();
        while (cur.prev()) {
            cur.prev();
            if (!cur.isAttr()) {
                cur.prev();
            }
            if (cur.isNormalAttr()) {
                cur.popButStay();
                return true;
            }
        }
        cur.pop();
        return $assertionsDisabled;
    }

    static boolean toNextNormalAttr(Cur cur) {
        cur.push();
        while (cur.toNextAttr()) {
            if (!cur.isXmlns()) {
                cur.popButStay();
                return true;
            }
        }
        cur.pop();
        return $assertionsDisabled;
    }

    Xobj findNthChildElem(Xobj xobj, QName qName, QNameSet qNameSet, int i) {
        if (xobj == null) {
            return null;
        }
        int iDistance = this._nthCache_A.distance(xobj, qName, qNameSet, i);
        int iDistance2 = this._nthCache_B.distance(xobj, qName, qNameSet, i);
        Xobj xobjFetch = (iDistance <= iDistance2 ? this._nthCache_A : this._nthCache_B).fetch(xobj, qName, qNameSet, i);
        if (iDistance == iDistance2) {
            nthCache nthcache = this._nthCache_A;
            this._nthCache_A = this._nthCache_B;
            this._nthCache_B = nthcache;
        }
        return xobjFetch;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0020  */
    int count(Xobj xobj, QName qName, QNameSet qNameSet) {
        int i = 0;
        for (Xobj xobjFindNthChildElem = findNthChildElem(xobj, qName, qNameSet, 0); xobjFindNthChildElem != null; xobjFindNthChildElem = xobjFindNthChildElem._nextSibling) {
            if (xobjFindNthChildElem.isElem()) {
                if (qNameSet == null) {
                    if (xobjFindNthChildElem._name.equals(qName)) {
                        i++;
                    }
                } else if (qNameSet.contains(xobjFindNthChildElem._name)) {
                    i++;
                }
            }
        }
        return i;
    }

    static boolean toChild(Cur cur, QName qName, int i) {
        if (i < 0 || !pushToContainer(cur)) {
            return $assertionsDisabled;
        }
        Xobj xobjFindNthChildElem = cur._locale.findNthChildElem(cur._xobj, qName, null, i);
        cur.pop();
        if (xobjFindNthChildElem == null) {
            return $assertionsDisabled;
        }
        cur.moveTo(xobjFindNthChildElem);
        return true;
    }

    static boolean toFirstChildElement(Cur cur) {
        Xobj xobj = cur._xobj;
        int i = cur._pos;
        while (true) {
            int iKind = cur.kind();
            if (iKind == -2 || iKind == -1) {
                break;
            }
            if (iKind == 1 || iKind == 2) {
                if (cur.toFirstChild() && (cur.isElem() || toNextSiblingElement(cur))) {
                    return true;
                }
                cur.moveTo(xobj, i);
                return $assertionsDisabled;
            }
            if (iKind == 4 || iKind == 5) {
                cur.skip();
            } else {
                cur.nextWithAttrs();
            }
        }
        cur.moveTo(xobj, i);
        return $assertionsDisabled;
    }

    static boolean toLastChildElement(Cur cur) {
        if (!pushToContainer(cur)) {
            return $assertionsDisabled;
        }
        if (!cur.toLastChild() || (!cur.isElem() && !toPrevSiblingElement(cur))) {
            cur.pop();
            return $assertionsDisabled;
        }
        cur.popButStay();
        return true;
    }

    static boolean toPrevSiblingElement(Cur cur) {
        int iKind;
        boolean zHasParent = cur.hasParent();
        boolean z = $assertionsDisabled;
        if (!zHasParent) {
            return $assertionsDisabled;
        }
        Cur curTempCur = cur.tempCur();
        if (curTempCur.kind() != 3) {
            while (curTempCur.prev() && (iKind = curTempCur.kind()) != 1 && iKind != 2) {
                if (curTempCur.kind() == -2) {
                    curTempCur.toParent();
                    cur.moveToCur(curTempCur);
                    z = true;
                    break;
                }
            }
        }
        curTempCur.release();
        return z;
    }

    static boolean toNextSiblingElement(Cur cur) {
        if (!cur.hasParent()) {
            return $assertionsDisabled;
        }
        cur.push();
        int iKind = cur.kind();
        if (iKind == 3) {
            cur.toParent();
            cur.next();
        } else if (iKind == 2) {
            cur.skip();
        }
        while (true) {
            int iKind2 = cur.kind();
            if (iKind2 < 0) {
                cur.pop();
                return $assertionsDisabled;
            }
            if (iKind2 == 2) {
                cur.popButStay();
                return true;
            }
            if (iKind2 > 0) {
                cur.toEnd();
            }
            cur.next();
        }
    }

    static boolean toNextSiblingElement(Cur cur, Xobj xobj) {
        Xobj xobj2 = cur._xobj;
        int i = cur._pos;
        int iKind = cur.kind();
        if (iKind == 3) {
            cur.moveTo(xobj);
            cur.next();
        } else if (iKind == 2) {
            cur.skip();
        }
        while (true) {
            int iKind2 = cur.kind();
            if (iKind2 < 0) {
                cur.moveTo(xobj2, i);
                return $assertionsDisabled;
            }
            if (iKind2 == 2) {
                return true;
            }
            if (iKind2 > 0) {
                cur.toEnd();
            }
            cur.next();
        }
    }

    static void applyNamespaces(Cur cur, Map map) {
        for (String str : map.keySet()) {
            if (!str.toLowerCase().startsWith(Sax2Dom.XML_PREFIX) && cur.namespaceForPrefix(str, $assertionsDisabled) == null) {
                cur.push();
                cur.next();
                cur.createAttr(cur._locale.createXmlns(str));
                cur.next();
                cur.insertString((String) map.get(str));
                cur.pop();
            }
        }
    }

    static Map getAllNamespaces(Cur cur, Map map) {
        cur.push();
        if (!cur.isContainer()) {
            cur.toParent();
        }
        do {
            cur.getName();
            while (cur.toNextAttr()) {
                if (cur.isXmlns()) {
                    String xmlnsPrefix = cur.getXmlnsPrefix();
                    String xmlnsUri = cur.getXmlnsUri();
                    if (map == null) {
                        map = new HashMap();
                    }
                    if (!map.containsKey(xmlnsPrefix)) {
                        map.put(xmlnsPrefix, xmlnsUri);
                    }
                }
            }
            if (!cur.isContainer()) {
                cur.toParentRaw();
            }
        } while (cur.toParentRaw());
        cur.pop();
        return map;
    }

    class nthCache {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Xobj _child;
        private int _n;
        private QName _name;
        private Xobj _parent;
        private QNameSet _set;
        private long _version;

        private boolean setsSame(QNameSet qNameSet, QNameSet qNameSet2) {
            if (qNameSet == null || qNameSet != qNameSet2) {
                return Locale.$assertionsDisabled;
            }
            return true;
        }

        nthCache() {
        }

        private boolean namesSame(QName qName, QName qName2) {
            if (qName == null || qName.equals(qName2)) {
                return true;
            }
            return Locale.$assertionsDisabled;
        }

        private boolean nameHit(QName qName, QNameSet qNameSet, QName qName2) {
            return qNameSet == null ? namesSame(qName, qName2) : qNameSet.contains(qName2);
        }

        private boolean cacheSame(QName qName, QNameSet qNameSet) {
            return qNameSet == null ? namesSame(qName, this._name) : setsSame(qNameSet, this._set);
        }

        int distance(Xobj xobj, QName qName, QNameSet qNameSet, int i) {
            if (this._version != Locale.this.version()) {
                return 2147483646;
            }
            if (xobj != this._parent || !cacheSame(qName, qNameSet)) {
                return Integer.MAX_VALUE;
            }
            int i2 = this._n;
            return i > i2 ? i - i2 : i2 - i;
        }

        Xobj fetch(Xobj xobj, QName qName, QNameSet qNameSet, int i) {
            if (this._version != Locale.this.version() || this._parent != xobj || !cacheSame(qName, qNameSet) || i == 0) {
                this._version = Locale.this.version();
                this._parent = xobj;
                this._name = qName;
                this._child = null;
                this._n = -1;
                for (Xobj xobj2 = xobj._firstChild; xobj2 != null; xobj2 = xobj2._nextSibling) {
                    if (xobj2.isElem() && nameHit(qName, qNameSet, xobj2._name)) {
                        this._child = xobj2;
                        this._n = 0;
                        break;
                    }
                }
            }
            int i2 = this._n;
            if (i2 < 0) {
                return null;
            }
            if (i > i2) {
                while (i > this._n) {
                    Xobj xobj3 = this._child;
                    while (true) {
                        xobj3 = xobj3._nextSibling;
                        if (xobj3 == null) {
                            return null;
                        }
                        if (!xobj3.isElem() || !nameHit(qName, qNameSet, xobj3._name)) {
                        }
                    }
                    this._child = xobj3;
                    this._n++;
                }
            } else if (i < i2) {
                while (i < this._n) {
                    Xobj xobj4 = this._child;
                    while (true) {
                        xobj4 = xobj4._prevSibling;
                        if (xobj4 == null) {
                            return null;
                        }
                        if (!xobj4.isElem() || !nameHit(qName, qNameSet, xobj4._name)) {
                        }
                    }
                    this._child = xobj4;
                    this._n--;
                }
            }
            return this._child;
        }
    }

    DomImpl.Dom findDomNthChild(DomImpl.Dom dom, int i) {
        DomImpl.Dom domFetch;
        if (dom == null) {
            return null;
        }
        int iDistance = this._domNthCache_A.distance(dom, i);
        int iDistance2 = this._domNthCache_B.distance(dom, i);
        boolean z = iDistance2 - (this._domNthCache_B._len / 2) > 0 && (iDistance2 - (this._domNthCache_B._len / 2)) + (-40) > 0;
        boolean z2 = iDistance - (this._domNthCache_A._len / 2) > 0 && (iDistance - (this._domNthCache_A._len / 2)) + (-40) > 0;
        if (iDistance <= iDistance2) {
            if (!z2) {
                domFetch = this._domNthCache_A.fetch(dom, i);
            } else {
                this._domNthCache_B._version = -1L;
                domFetch = this._domNthCache_B.fetch(dom, i);
            }
        } else if (!z) {
            domFetch = this._domNthCache_B.fetch(dom, i);
        } else {
            this._domNthCache_A._version = -1L;
            domFetch = this._domNthCache_A.fetch(dom, i);
        }
        if (iDistance == iDistance2) {
            domNthCache domnthcache = this._domNthCache_A;
            this._domNthCache_A = this._domNthCache_B;
            this._domNthCache_B = domnthcache;
        }
        return domFetch;
    }

    int domLength(DomImpl.Dom dom) {
        if (dom == null) {
            return 0;
        }
        int iDistance = this._domNthCache_A.distance(dom, 0);
        int iDistance2 = this._domNthCache_B.distance(dom, 0);
        int length = (iDistance <= iDistance2 ? this._domNthCache_A : this._domNthCache_B).length(dom);
        if (iDistance == iDistance2) {
            domNthCache domnthcache = this._domNthCache_A;
            this._domNthCache_A = this._domNthCache_B;
            this._domNthCache_B = domnthcache;
        }
        return length;
    }

    void invalidateDomCaches(DomImpl.Dom dom) {
        if (this._domNthCache_A._parent == dom) {
            this._domNthCache_A._version = -1L;
        }
        if (this._domNthCache_B._parent == dom) {
            this._domNthCache_B._version = -1L;
        }
    }

    boolean isDomCached(DomImpl.Dom dom) {
        if (this._domNthCache_A._parent == dom || this._domNthCache_B._parent == dom) {
            return true;
        }
        return $assertionsDisabled;
    }

    class domNthCache {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final int BLITZ_BOUNDARY = 40;
        private DomImpl.Dom _child;
        private int _len;
        private int _n;
        private DomImpl.Dom _parent;
        private long _version;

        domNthCache() {
        }

        int distance(DomImpl.Dom dom, int i) {
            if (this._version != Locale.this.version()) {
                return 2147483646;
            }
            if (dom != this._parent) {
                return Integer.MAX_VALUE;
            }
            int i2 = this._n;
            return i > i2 ? i - i2 : i2 - i;
        }

        int length(DomImpl.Dom dom) {
            int i;
            if (this._version != Locale.this.version() || this._parent != dom) {
                this._parent = dom;
                this._version = Locale.this.version();
                this._child = null;
                this._n = -1;
                this._len = -1;
            }
            if (this._len == -1) {
                DomImpl.Dom domFirstChild = this._child;
                if (domFirstChild != null && (i = this._n) != -1) {
                    this._len = i;
                } else {
                    domFirstChild = DomImpl.firstChild(this._parent);
                    this._len = 0;
                    this._child = domFirstChild;
                    this._n = 0;
                }
                while (domFirstChild != null) {
                    this._len++;
                    domFirstChild = DomImpl.nextSibling(domFirstChild);
                }
            }
            return this._len;
        }

        DomImpl.Dom fetch(DomImpl.Dom dom, int i) {
            if (this._version != Locale.this.version() || this._parent != dom) {
                this._parent = dom;
                this._version = Locale.this.version();
                this._child = null;
                this._n = -1;
                this._len = -1;
                for (DomImpl.Dom domFirstChild = DomImpl.firstChild(this._parent); domFirstChild != null; domFirstChild = DomImpl.nextSibling(domFirstChild)) {
                    int i2 = this._n + 1;
                    this._n = i2;
                    if (this._child == null && i == i2) {
                        this._child = domFirstChild;
                        break;
                    }
                }
                return this._child;
            }
            int i3 = this._n;
            if (i3 < 0) {
                return null;
            }
            if (i > i3) {
                while (i > this._n) {
                    DomImpl.Dom domNextSibling = DomImpl.nextSibling(this._child);
                    if (domNextSibling == null) {
                        return null;
                    }
                    this._child = domNextSibling;
                    this._n++;
                }
            } else if (i < i3) {
                while (i < this._n) {
                    DomImpl.Dom domPrevSibling = DomImpl.prevSibling(this._child);
                    if (domPrevSibling == null) {
                        return null;
                    }
                    this._child = domPrevSibling;
                    this._n--;
                }
            }
            return this._child;
        }
    }

    CharUtil getCharUtil() {
        if (this._charUtil == null) {
            this._charUtil = new CharUtil(XMLEvent.START_PREFIX_MAPPING);
        }
        return this._charUtil;
    }

    long version() {
        return this._versionAll;
    }

    Cur weakCur(Object obj) {
        Cur cur = getCur();
        cur._ref = new Ref(cur, obj);
        return cur;
    }

    final ReferenceQueue refQueue() {
        if (this._refQueue == null) {
            this._refQueue = new ReferenceQueue();
        }
        return this._refQueue;
    }

    static final class Ref extends PhantomReference {
        Cur _cur;

        Ref(Cur cur, Object obj) {
            super(obj, cur._locale.refQueue());
            this._cur = cur;
        }
    }

    Cur tempCur() {
        return tempCur(null);
    }

    Cur tempCur(String str) {
        Cur cur = getCur();
        Cur[] curArr = this._tempFrames;
        int length = (curArr.length - this._numTempFramesLeft) - 1;
        Cur cur2 = curArr[length];
        cur._nextTemp = cur2;
        if (cur2 != null) {
            cur2._prevTemp = cur;
        }
        this._tempFrames[length] = cur;
        cur._tempFrame = length;
        cur._id = str;
        return cur;
    }

    Cur getCur() {
        Cur cur = this._curPool;
        if (cur == null) {
            cur = new Cur(this);
        } else {
            this._curPool = cur.listRemove(cur);
            this._curPoolCount--;
        }
        this._registered = cur.listInsert(this._registered);
        cur._state = 1;
        return cur;
    }

    void embedCurs() {
        while (true) {
            Cur cur = this._registered;
            if (cur == null) {
                return;
            }
            this._registered = cur.listRemove(cur);
            cur._xobj._embedded = cur.listInsert(cur._xobj._embedded);
            cur._state = 2;
        }
    }

    DomImpl.TextNode createTextNode() {
        return this._saaj == null ? new DomImpl.TextNode(this) : new DomImpl.SaajTextNode(this);
    }

    DomImpl.CdataNode createCdataNode() {
        return this._saaj == null ? new DomImpl.CdataNode(this) : new DomImpl.SaajCdataNode(this);
    }

    boolean entered() {
        if (this._tempFrames.length - this._numTempFramesLeft > 0) {
            return true;
        }
        return $assertionsDisabled;
    }

    public void enter(Locale locale) {
        enter();
        if (locale != this) {
            locale.enter();
        }
    }

    @Override // org.apache.xmlbeans.impl.common.XmlLocale
    public void enter() {
        int i = this._numTempFramesLeft - 1;
        this._numTempFramesLeft = i;
        if (i <= 0) {
            Cur[] curArr = this._tempFrames;
            Cur[] curArr2 = new Cur[curArr.length * 2];
            this._numTempFramesLeft = curArr.length;
            System.arraycopy(curArr, 0, curArr2, 0, curArr.length);
            this._tempFrames = curArr2;
        }
        int i2 = this._entryCount + 1;
        this._entryCount = i2;
        if (i2 > 1000) {
            pollQueue();
            this._entryCount = 0;
        }
    }

    private void pollQueue() {
        if (this._refQueue == null) {
            return;
        }
        while (true) {
            Ref ref = (Ref) this._refQueue.poll();
            if (ref == null) {
                return;
            }
            if (ref._cur != null) {
                ref._cur.release();
            }
        }
    }

    public void exit(Locale locale) {
        exit();
        if (locale != this) {
            locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.common.XmlLocale
    public void exit() {
        int length = this._tempFrames.length;
        int i = this._numTempFramesLeft + 1;
        this._numTempFramesLeft = i;
        int i2 = length - i;
        while (true) {
            Cur cur = this._tempFrames[i2];
            if (cur == null) {
                return;
            } else {
                cur.release();
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.common.XmlLocale
    public boolean noSync() {
        return this._noSync;
    }

    @Override // org.apache.xmlbeans.impl.common.XmlLocale
    public boolean sync() {
        return !this._noSync;
    }

    static final boolean isWhiteSpace(String str) {
        int length = str.length();
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (!CharUtil.isWhiteSpace(str.charAt(i))) {
                return $assertionsDisabled;
            }
            length = i;
        }
    }

    static final boolean isWhiteSpace(StringBuffer stringBuffer) {
        int length = stringBuffer.length();
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (!CharUtil.isWhiteSpace(stringBuffer.charAt(i))) {
                return $assertionsDisabled;
            }
            length = i;
        }
    }

    static boolean beginsWithXml(String str) {
        char cCharAt;
        char cCharAt2;
        if (str.length() < 3) {
            return $assertionsDisabled;
        }
        char cCharAt3 = str.charAt(0);
        if ((cCharAt3 == 'x' || cCharAt3 == 'X') && (((cCharAt = str.charAt(1)) == 'm' || cCharAt == 'M') && ((cCharAt2 = str.charAt(2)) == 'l' || cCharAt2 == 'L'))) {
            return true;
        }
        return $assertionsDisabled;
    }

    static boolean isXmlns(QName qName) {
        String prefix = qName.getPrefix();
        if (prefix.equals(Sax2Dom.XMLNS_PREFIX)) {
            return true;
        }
        if (prefix.length() == 0 && qName.getLocalPart().equals(Sax2Dom.XMLNS_PREFIX)) {
            return true;
        }
        return $assertionsDisabled;
    }

    QName createXmlns(String str) {
        if (str == null) {
            str = "";
        }
        return str.length() == 0 ? makeQName("http://www.w3.org/2000/xmlns/", Sax2Dom.XMLNS_PREFIX, "") : makeQName("http://www.w3.org/2000/xmlns/", str, Sax2Dom.XMLNS_PREFIX);
    }

    static String xmlnsPrefix(QName qName) {
        return qName.getPrefix().equals(Sax2Dom.XMLNS_PREFIX) ? qName.getLocalPart() : "";
    }

    static abstract class LoadContext {
        private Hashtable _idAttrs;

        protected abstract void abort();

        protected abstract void attr(String str, String str2, String str3, String str4);

        protected abstract void attr(QName qName, String str);

        protected abstract void bookmark(XmlCursor.XmlBookmark xmlBookmark);

        protected abstract void bookmarkLastAttr(QName qName, XmlCursor.XmlBookmark xmlBookmark);

        protected abstract void bookmarkLastNonAttr(XmlCursor.XmlBookmark xmlBookmark);

        protected abstract void comment(String str);

        protected abstract void comment(char[] cArr, int i, int i2);

        protected abstract void endDTD();

        protected abstract void endElement();

        protected abstract Cur finish();

        protected abstract void lineNumber(int i, int i2, int i3);

        protected abstract void procInst(String str, String str2);

        protected abstract void startDTD(String str, String str2, String str3);

        protected abstract void startElement(QName qName);

        protected abstract void text(String str);

        protected abstract void text(char[] cArr, int i, int i2);

        protected abstract void xmlns(String str, String str2);

        LoadContext() {
        }

        protected void addIdAttr(String str, String str2) {
            if (this._idAttrs == null) {
                this._idAttrs = new Hashtable();
            }
            this._idAttrs.put(str2, str);
        }

        protected boolean isAttrOfTypeId(QName qName, QName qName2) {
            if (this._idAttrs == null) {
                return Locale.$assertionsDisabled;
            }
            String prefix = qName.getPrefix();
            String localPart = qName.getLocalPart();
            if (!"".equals(prefix)) {
                localPart = prefix + ":" + localPart;
            }
            String str = (String) this._idAttrs.get(localPart);
            if (str == null) {
                return Locale.$assertionsDisabled;
            }
            String prefix2 = qName2.getPrefix();
            qName2.getLocalPart();
            String localPart2 = qName2.getLocalPart();
            if (!"".equals(prefix2)) {
                localPart2 = prefix2 + ":" + localPart2;
            }
            return str.equals(localPart2);
        }
    }

    private static class DefaultEntityResolver implements EntityResolver {
        private DefaultEntityResolver() {
        }

        @Override // org.xml.sax.EntityResolver
        public InputSource resolveEntity(String str, String str2) {
            return new InputSource(new StringReader(""));
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlException */
    /* JADX WARN: Multi-variable type inference failed */
    private static SaxLoader getSaxLoader(XmlOptions xmlOptions) throws XmlException {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        EntityResolver entityResolver = null;
        Object[] objArr = 0;
        if (!xmlOptionsMaskNull.hasOption("LOAD_USE_DEFAULT_RESOLVER")) {
            EntityResolver defaultEntityResolver = (EntityResolver) xmlOptionsMaskNull.get("ENTITY_RESOLVER");
            if (defaultEntityResolver == null) {
                defaultEntityResolver = ResolverUtil.getGlobalEntityResolver();
            }
            if (defaultEntityResolver == null) {
                defaultEntityResolver = new DefaultEntityResolver();
            }
            entityResolver = defaultEntityResolver;
        }
        XMLReader xMLReaderNewXMLReader = (XMLReader) xmlOptionsMaskNull.get("LOAD_USE_XMLREADER");
        if (xMLReaderNewXMLReader == null) {
            try {
                xMLReaderNewXMLReader = SAXHelper.newXMLReader(new XmlOptionsBean(xmlOptionsMaskNull));
            } catch (Exception e) {
                throw new XmlException("Problem creating XMLReader", e);
            }
        }
        XmlReaderSaxLoader xmlReaderSaxLoader = new XmlReaderSaxLoader(xMLReaderNewXMLReader);
        if (entityResolver != null) {
            xMLReaderNewXMLReader.setEntityResolver(entityResolver);
        }
        return xmlReaderSaxLoader;
    }

    private static class XmlReaderSaxLoader extends SaxLoader {
        XmlReaderSaxLoader(XMLReader xMLReader) {
            super(xMLReader, null);
        }
    }

    private static abstract class SaxHandler implements ContentHandler, LexicalHandler, DeclHandler, DTDHandler {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        protected LoadContext _context;
        private int _entityBytes;
        private int _entityBytesLimit;
        private boolean _insideCDATA;
        private int _insideEntity;
        protected Locale _locale;
        private Locator _startLocator;
        private boolean _wantCdataBookmarks;
        private boolean _wantLineNumbers;
        private boolean _wantLineNumbersAtEndElt;

        @Override // org.xml.sax.ext.DeclHandler
        public void elementDecl(String str, String str2) {
        }

        @Override // org.xml.sax.ContentHandler
        public void endDocument() throws SAXException {
        }

        @Override // org.xml.sax.ContentHandler
        public void endPrefixMapping(String str) throws SAXException {
        }

        @Override // org.xml.sax.ext.DeclHandler
        public void externalEntityDecl(String str, String str2, String str3) {
        }

        @Override // org.xml.sax.ContentHandler
        public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
        }

        @Override // org.xml.sax.ext.DeclHandler
        public void internalEntityDecl(String str, String str2) {
        }

        @Override // org.xml.sax.DTDHandler
        public void notationDecl(String str, String str2, String str3) {
        }

        @Override // org.xml.sax.ContentHandler
        public void skippedEntity(String str) throws SAXException {
        }

        @Override // org.xml.sax.ContentHandler
        public void startDocument() throws SAXException {
        }

        @Override // org.xml.sax.DTDHandler
        public void unparsedEntityDecl(String str, String str2, String str3, String str4) {
        }

        SaxHandler(Locator locator) {
            this._insideCDATA = Locale.$assertionsDisabled;
            this._entityBytesLimit = 10240;
            this._entityBytes = 0;
            this._insideEntity = 0;
            this._startLocator = locator;
        }

        SaxHandler() {
            this(null);
        }

        void initSaxHandler(Locale locale, XmlOptions xmlOptions) {
            this._locale = locale;
            XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
            this._context = new Cur.CurLoadContext(this._locale, xmlOptionsMaskNull);
            this._wantLineNumbers = xmlOptionsMaskNull.hasOption("LOAD_LINE_NUMBERS");
            this._wantLineNumbersAtEndElt = xmlOptionsMaskNull.hasOption("LOAD_LINE_NUMBERS_END_ELEMENT");
            this._wantCdataBookmarks = xmlOptionsMaskNull.hasOption("LOAD_SAVE_CDATA_BOOKMARKS");
            if (xmlOptionsMaskNull.hasOption("LOAD_ENTITY_BYTES_LIMIT")) {
                this._entityBytesLimit = ((Integer) xmlOptionsMaskNull.get("LOAD_ENTITY_BYTES_LIMIT")).intValue();
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlRuntimeException */
        @Override // org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws XmlRuntimeException, SAXException {
            str2.length();
            if (str3.indexOf(58) >= 0 && str.length() == 0) {
                XmlError xmlErrorForMessage = XmlError.forMessage("Use of undefined namespace prefix: " + str3.substring(0, str3.indexOf(58)));
                throw new XmlRuntimeException(xmlErrorForMessage.toString(), (Throwable) null, xmlErrorForMessage);
            }
            this._context.startElement(this._locale.makeQualifiedQName(str, str3));
            if (this._wantLineNumbers && this._startLocator != null) {
                this._context.bookmark(new XmlLineNumber(this._startLocator.getLineNumber(), this._startLocator.getColumnNumber() - 1, -1));
            }
            int length = attributes.getLength();
            for (int i = 0; i < length; i++) {
                String qName = attributes.getQName(i);
                if (qName.equals(Sax2Dom.XMLNS_PREFIX)) {
                    this._context.xmlns("", attributes.getValue(i));
                } else if (qName.startsWith(Sax2Dom.XMLNS_STRING)) {
                    String strSubstring = qName.substring(6);
                    if (strSubstring.length() == 0) {
                        XmlError xmlErrorForMessage2 = XmlError.forMessage("Prefix not specified", 0);
                        throw new XmlRuntimeException(xmlErrorForMessage2.toString(), (Throwable) null, xmlErrorForMessage2);
                    }
                    String value = attributes.getValue(i);
                    if (value.length() == 0) {
                        XmlError xmlErrorForMessage3 = XmlError.forMessage("Prefix can't be mapped to no namespace: " + strSubstring, 0);
                        throw new XmlRuntimeException(xmlErrorForMessage3.toString(), (Throwable) null, xmlErrorForMessage3);
                    }
                    this._context.xmlns(strSubstring, value);
                } else {
                    int iIndexOf = qName.indexOf(58);
                    if (iIndexOf < 0) {
                        this._context.attr(qName, attributes.getURI(i), null, attributes.getValue(i));
                    } else {
                        this._context.attr(qName.substring(iIndexOf + 1), attributes.getURI(i), qName.substring(0, iIndexOf), attributes.getValue(i));
                    }
                }
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            this._context.endElement();
            if (!this._wantLineNumbersAtEndElt || this._startLocator == null) {
                return;
            }
            this._context.bookmark(new XmlLineNumber(this._startLocator.getLineNumber(), this._startLocator.getColumnNumber() - 1, -1));
        }

        @Override // org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) throws SAXException {
            this._context.text(cArr, i, i2);
            if (this._wantCdataBookmarks && this._insideCDATA && this._startLocator != null) {
                this._context.bookmarkLastNonAttr(CDataBookmark.CDATA_BOOKMARK);
            }
            if (this._insideEntity != 0) {
                int i3 = this._entityBytes + i2;
                this._entityBytes = i3;
                int i4 = this._entityBytesLimit;
                if (i3 > i4) {
                    throw new SAXException(XmlError.forMessage("exceeded-entity-bytes", new Integer[]{Integer.valueOf(i4)}).getMessage());
                }
            }
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void comment(char[] cArr, int i, int i2) throws SAXException {
            this._context.comment(cArr, i, i2);
        }

        @Override // org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) throws SAXException {
            this._context.procInst(str, str2);
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void startDTD(String str, String str2, String str3) throws SAXException {
            this._context.startDTD(str, str2, str3);
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void endDTD() throws SAXException {
            this._context.endDTD();
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlRuntimeException */
        @Override // org.xml.sax.ContentHandler
        public void startPrefixMapping(String str, String str2) throws XmlRuntimeException, SAXException {
            if (Locale.beginsWithXml(str)) {
                if (Sax2Dom.XML_PREFIX.equals(str) && "http://www.w3.org/XML/1998/namespace".equals(str2)) {
                    return;
                }
                XmlError xmlErrorForMessage = XmlError.forMessage("Prefix can't begin with XML: " + str, 0);
                throw new XmlRuntimeException(xmlErrorForMessage.toString(), (Throwable) null, xmlErrorForMessage);
            }
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void startCDATA() throws SAXException {
            this._insideCDATA = true;
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void endCDATA() throws SAXException {
            this._insideCDATA = Locale.$assertionsDisabled;
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void startEntity(String str) throws SAXException {
            this._insideEntity++;
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void endEntity(String str) throws SAXException {
            int i = this._insideEntity - 1;
            this._insideEntity = i;
            if (i == 0) {
                this._entityBytes = 0;
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void setDocumentLocator(Locator locator) {
            if (this._startLocator == null) {
                this._startLocator = locator;
            }
        }

        @Override // org.xml.sax.ext.DeclHandler
        public void attributeDecl(String str, String str2, String str3, String str4, String str5) {
            if (str3.equals("ID")) {
                this._context.addIdAttr(str, str2);
            }
        }
    }

    private static abstract class SaxLoader extends SaxHandler implements ErrorHandler {
        private XMLReader _xr;

        SaxLoader(XMLReader xMLReader, Locator locator) {
            super(locator);
            this._xr = xMLReader;
            try {
                xMLReader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
                this._xr.setFeature("http://xml.org/sax/features/namespaces", true);
                this._xr.setFeature("http://xml.org/sax/features/validation", Locale.$assertionsDisabled);
                this._xr.setProperty("http://xml.org/sax/properties/lexical-handler", this);
                this._xr.setContentHandler(this);
                this._xr.setProperty("http://xml.org/sax/properties/declaration-handler", this);
                this._xr.setDTDHandler(this);
                this._xr.setErrorHandler(this);
            } catch (Throwable th) {
                throw new RuntimeException(th.getMessage(), th);
            }
        }

        void setEntityResolver(EntityResolver entityResolver) {
            this._xr.setEntityResolver(entityResolver);
        }

        void postLoad(Cur cur) {
            this._locale = null;
            this._context = null;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlException */
        public Cur load(Locale locale, InputSource inputSource, XmlOptions xmlOptions) throws XmlException, IOException {
            inputSource.setSystemId("file://");
            initSaxHandler(locale, xmlOptions);
            try {
                this._xr.parse(inputSource);
                Cur curFinish = this._context.finish();
                Locale.associateSourceName(curFinish, xmlOptions);
                postLoad(curFinish);
                return curFinish;
            } catch (RuntimeException e) {
                this._context.abort();
                throw e;
            } catch (SAXParseException e2) {
                this._context.abort();
                XmlError xmlErrorForLocation = XmlError.forLocation(e2.getMessage(), (String) XmlOptions.safeGet(xmlOptions, "DOCUMENT_SOURCE_NAME"), e2.getLineNumber(), e2.getColumnNumber(), -1);
                throw new XmlException(xmlErrorForLocation.toString(), e2, xmlErrorForLocation);
            } catch (SAXException e3) {
                this._context.abort();
                XmlError xmlErrorForMessage = XmlError.forMessage(e3.getMessage());
                throw new XmlException(xmlErrorForMessage.toString(), e3, xmlErrorForMessage);
            } catch (XmlRuntimeException e4) {
                this._context.abort();
                throw new XmlException(e4);
            }
        }

        @Override // org.xml.sax.ErrorHandler
        public void fatalError(SAXParseException sAXParseException) throws SAXException {
            throw sAXParseException;
        }

        @Override // org.xml.sax.ErrorHandler
        public void error(SAXParseException sAXParseException) throws SAXException {
            throw sAXParseException;
        }

        @Override // org.xml.sax.ErrorHandler
        public void warning(SAXParseException sAXParseException) throws SAXException {
            throw sAXParseException;
        }
    }

    private DomImpl.Dom load(InputSource inputSource, XmlOptions xmlOptions) throws XmlException, IOException {
        return getSaxLoader(xmlOptions).load(this, inputSource, xmlOptions).getDom();
    }

    public DomImpl.Dom load(Reader reader) throws XmlException, IOException {
        return load(reader, (XmlOptions) null);
    }

    public DomImpl.Dom load(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
        return load(new InputSource(reader), xmlOptions);
    }

    public DomImpl.Dom load(InputStream inputStream) throws XmlException, IOException {
        return load(inputStream, (XmlOptions) null);
    }

    public DomImpl.Dom load(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
        return load(new InputSource(inputStream), xmlOptions);
    }

    public DomImpl.Dom load(String str) throws XmlException {
        return load(str, (XmlOptions) null);
    }

    public DomImpl.Dom load(String str, XmlOptions xmlOptions) throws XmlException {
        StringReader stringReader = new StringReader(str);
        try {
            try {
                DomImpl.Dom domLoad = load(stringReader, xmlOptions);
                try {
                    stringReader.close();
                } catch (IOException unused) {
                }
                return domLoad;
            } catch (IOException e) {
                throw new XmlException(e.getMessage(), e);
            }
        } catch (Throwable th) {
            try {
                stringReader.close();
            } catch (IOException unused2) {
            }
            throw th;
        }
    }

    @Override // org.w3c.dom.DOMImplementation
    public Document createDocument(String str, String str2, DocumentType documentType) {
        return DomImpl._domImplementation_createDocument(this, str, str2, documentType);
    }

    @Override // org.w3c.dom.DOMImplementation
    public DocumentType createDocumentType(String str, String str2, String str3) {
        throw new RuntimeException("Not implemented");
    }

    @Override // org.w3c.dom.DOMImplementation
    public boolean hasFeature(String str, String str2) {
        return DomImpl._domImplementation_hasFeature(this, str, str2);
    }

    @Override // org.w3c.dom.DOMImplementation
    public Object getFeature(String str, String str2) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    private static DomImpl.Dom checkNode(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("Node is null");
        }
        if (!(node instanceof DomImpl.Dom)) {
            throw new IllegalArgumentException("Node is not an XmlBeans node");
        }
        return (DomImpl.Dom) node;
    }

    public static XmlCursor nodeToCursor(Node node) {
        return DomImpl._getXmlCursor(checkNode(node));
    }

    public static XmlObject nodeToXmlObject(Node node) {
        return DomImpl._getXmlObject(checkNode(node));
    }

    public static XMLStreamReader nodeToXmlStream(Node node) {
        return DomImpl._getXmlStreamReader(checkNode(node));
    }

    public static Node streamToNode(XMLStreamReader xMLStreamReader) {
        return Jsr173.nodeFromStream(xMLStreamReader);
    }

    @Override // org.apache.xmlbeans.impl.store.Saaj.SaajCallback
    public void setSaajData(Node node, Object obj) {
        DomImpl.saajCallback_setSaajData((DomImpl.Dom) node, obj);
    }

    @Override // org.apache.xmlbeans.impl.store.Saaj.SaajCallback
    public Object getSaajData(Node node) {
        return DomImpl.saajCallback_getSaajData((DomImpl.Dom) node);
    }

    @Override // org.apache.xmlbeans.impl.store.Saaj.SaajCallback
    public Element createSoapElement(QName qName, QName qName2) {
        return DomImpl.saajCallback_createSoapElement(this._ownerDoc, qName, qName2);
    }

    @Override // org.apache.xmlbeans.impl.store.Saaj.SaajCallback
    public Element importSoapElement(Document document, Element element, boolean z, QName qName) {
        return DomImpl.saajCallback_importSoapElement((DomImpl.Dom) document, element, z, qName);
    }

    private static final class DefaultQNameFactory implements QNameFactory {
        private QNameCache _cache;

        private DefaultQNameFactory() {
            this._cache = XmlBeans.getQNameCache();
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(String str, String str2) {
            return this._cache.getName(str, str2, "");
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(String str, String str2, String str3) {
            return this._cache.getName(str, str2, str3);
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4) {
            return this._cache.getName(new String(cArr, i, i2), new String(cArr2, i3, i4), "");
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4, char[] cArr3, int i5, int i6) {
            return this._cache.getName(new String(cArr, i, i2), new String(cArr2, i3, i4), new String(cArr3, i5, i6));
        }
    }

    private static final class LocalDocumentQNameFactory implements QNameFactory {
        private QNameCache _cache = new QNameCache(32);

        private LocalDocumentQNameFactory() {
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(String str, String str2) {
            return this._cache.getName(str, str2, "");
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(String str, String str2, String str3) {
            return this._cache.getName(str, str2, str3);
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4) {
            return this._cache.getName(new String(cArr, i, i2), new String(cArr2, i3, i4), "");
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4, char[] cArr3, int i5, int i6) {
            return this._cache.getName(new String(cArr, i, i2), new String(cArr2, i3, i4), new String(cArr3, i5, i6));
        }
    }
}
