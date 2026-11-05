package org.apache.xmlbeans.impl.store;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlRuntimeException;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.apache.xmlbeans.impl.common.XMLChar;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.soap.Detail;
import org.apache.xmlbeans.impl.soap.DetailEntry;
import org.apache.xmlbeans.impl.soap.Name;
import org.apache.xmlbeans.impl.soap.SOAPBody;
import org.apache.xmlbeans.impl.soap.SOAPBodyElement;
import org.apache.xmlbeans.impl.soap.SOAPElement;
import org.apache.xmlbeans.impl.soap.SOAPEnvelope;
import org.apache.xmlbeans.impl.soap.SOAPException;
import org.apache.xmlbeans.impl.soap.SOAPFault;
import org.apache.xmlbeans.impl.soap.SOAPHeader;
import org.apache.xmlbeans.impl.soap.SOAPHeaderElement;
import org.apache.xmlbeans.impl.soap.SOAPPart;
import org.codehaus.stax2.validation.XMLValidationSchema;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.w3c.dom.UserDataHandler;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
final class DomImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int ATTR = 2;
    static final int CDATA = 4;
    static final int COMMENT = 8;
    static final int DOCFRAG = 11;
    static final int DOCTYPE = 10;
    static final int DOCUMENT = 9;
    static final int ELEMENT = 1;
    static final int ENTITY = 6;
    static final int ENTITYREF = 5;
    static final int NOTATION = 12;
    static final int PROCINST = 7;
    static final int TEXT = 3;
    public static NodeList _emptyNodeList = new EmptyNodeList();

    interface Dom {
        void dump();

        void dump(PrintStream printStream);

        void dump(PrintStream printStream, Object obj);

        QName getQName();

        Locale locale();

        boolean nodeCanHavePrefixUri();

        int nodeType();

        Cur tempCur();
    }

    public static boolean _attr_getSpecified(Dom dom) {
        return true;
    }

    public static Dom document_getDoctype(Dom dom) {
        return null;
    }

    public static Text impl_saajCallback_ensureSoapTextNode(Dom dom) {
        return null;
    }

    DomImpl() {
    }

    static Dom parent(Dom dom) {
        return node_getParentNode(dom);
    }

    static Dom firstChild(Dom dom) {
        return node_getFirstChild(dom);
    }

    static Dom nextSibling(Dom dom) {
        return node_getNextSibling(dom);
    }

    static Dom prevSibling(Dom dom) {
        return node_getPreviousSibling(dom);
    }

    public static Dom append(Dom dom, Dom dom2) {
        return node_insertBefore(dom2, dom, null);
    }

    public static Dom insert(Dom dom, Dom dom2) {
        return node_insertBefore(parent(dom2), dom, dom2);
    }

    public static Dom remove(Dom dom) {
        Dom domParent = parent(dom);
        if (domParent != null) {
            node_removeChild(domParent, dom);
        }
        return dom;
    }

    static class HierarchyRequestErr extends DOMException {
        HierarchyRequestErr() {
            this("This node isn't allowed there");
        }

        HierarchyRequestErr(String str) {
            super((short) 3, str);
        }
    }

    static class WrongDocumentErr extends DOMException {
        WrongDocumentErr() {
            this("Nodes do not belong to the same document");
        }

        WrongDocumentErr(String str) {
            super((short) 4, str);
        }
    }

    static class NotFoundErr extends DOMException {
        NotFoundErr() {
            this("Node not found");
        }

        NotFoundErr(String str) {
            super((short) 8, str);
        }
    }

    static class NamespaceErr extends DOMException {
        NamespaceErr() {
            this("Namespace error");
        }

        NamespaceErr(String str) {
            super((short) 14, str);
        }
    }

    static class NoModificationAllowedErr extends DOMException {
        NoModificationAllowedErr() {
            this("No modification allowed error");
        }

        NoModificationAllowedErr(String str) {
            super((short) 7, str);
        }
    }

    static class InuseAttributeError extends DOMException {
        InuseAttributeError() {
            this("Attribute currently in use error");
        }

        InuseAttributeError(String str) {
            super((short) 10, str);
        }
    }

    static class IndexSizeError extends DOMException {
        IndexSizeError() {
            this("Index Size Error");
        }

        IndexSizeError(String str) {
            super((short) 1, str);
        }
    }

    static class NotSupportedError extends DOMException {
        NotSupportedError() {
            this("This operation is not supported");
        }

        NotSupportedError(String str) {
            super((short) 9, str);
        }
    }

    static class InvalidCharacterError extends DOMException {
        InvalidCharacterError() {
            this("The name contains an invalid character");
        }

        InvalidCharacterError(String str) {
            super((short) 5, str);
        }
    }

    private static final class EmptyNodeList implements NodeList {
        @Override // org.w3c.dom.NodeList
        public int getLength() {
            return 0;
        }

        @Override // org.w3c.dom.NodeList
        public Node item(int i) {
            return null;
        }

        private EmptyNodeList() {
        }
    }

    static String nodeKindName(int i) {
        switch (i) {
            case 1:
                return "element";
            case 2:
                return "attribute";
            case 3:
                return "text";
            case 4:
                return "cdata section";
            case 5:
                return "entity reference";
            case 6:
                return "entity";
            case 7:
                return "processing instruction";
            case 8:
                return JamXmlElements.COMMENT;
            case 9:
                return "document";
            case 10:
                return "document type";
            case 11:
                return "document fragment";
            case 12:
                return "notation";
            default:
                throw new RuntimeException("Unknown node type");
        }
    }

    private static String isValidChild(Dom dom, Dom dom2) {
        int iNodeType = dom.nodeType();
        int iNodeType2 = dom2.nodeType();
        switch (iNodeType) {
            case 1:
            case 5:
            case 6:
            case 11:
                if (iNodeType2 == 1 || iNodeType2 == 3 || iNodeType2 == 4 || iNodeType2 == 5 || iNodeType2 == 7 || iNodeType2 == 8) {
                    return null;
                }
                break;
            case 2:
                if (iNodeType2 == 3 || iNodeType2 == 5) {
                    return null;
                }
                break;
            case 3:
            case 4:
            case 7:
            case 8:
            case 10:
            case 12:
                return nodeKindName(iNodeType) + " nodes may not have any children";
            case 9:
                if (iNodeType2 == 1) {
                    if (document_getDocumentElement(dom) != null) {
                        return "Documents may only have a maximum of one document element";
                    }
                    return null;
                }
                if (iNodeType2 == 10) {
                    if (document_getDoctype(dom) != null) {
                        return "Documents may only have a maximum of one document type node";
                    }
                    return null;
                }
                if (iNodeType2 == 7 || iNodeType2 == 8) {
                    return null;
                }
                break;
        }
        return nodeKindName(iNodeType) + " nodes may not have " + nodeKindName(iNodeType2) + " nodes as children";
    }

    private static void validateNewChild(Dom dom, Dom dom2) {
        String strIsValidChild = isValidChild(dom, dom2);
        if (strIsValidChild != null) {
            throw new HierarchyRequestErr(strIsValidChild);
        }
        if (dom == dom2) {
            throw new HierarchyRequestErr("New child and parent are the same node");
        }
        do {
            dom = parent(dom);
            if (dom == null) {
                return;
            }
            if (dom2.nodeType() == 5) {
                throw new NoModificationAllowedErr("Entity reference trees may not be modified");
            }
        } while (dom2 != dom);
        throw new HierarchyRequestErr("New child is an ancestor node of the parent node");
    }

    private static String validatePrefix(String str, String str2, String str3, boolean z) {
        validateNcName(str);
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str.length() > 0 && str2.length() == 0) {
            throw new NamespaceErr("Attempt to give a prefix for no namespace");
        }
        if (str.equals(Sax2Dom.XML_PREFIX) && !str2.equals(XMLValidationSchema.SCHEMA_ID_DTD)) {
            throw new NamespaceErr("Invalid prefix - begins with 'xml'");
        }
        if (z) {
            if (str.length() > 0) {
                if (str3.equals(Sax2Dom.XMLNS_PREFIX)) {
                    throw new NamespaceErr("Invalid namespace - attr is default namespace already");
                }
                if (Locale.beginsWithXml(str3)) {
                    throw new NamespaceErr("Invalid namespace - attr prefix begins with 'xml'");
                }
                if (str.equals(Sax2Dom.XMLNS_PREFIX) && !str2.equals(Sax2Dom.XMLNS_URI)) {
                    throw new NamespaceErr("Invalid namespace - uri is not 'http://www.w3.org/2000/xmlns/;");
                }
            } else if (str3.equals(Sax2Dom.XMLNS_PREFIX) && !str2.equals(Sax2Dom.XMLNS_URI)) {
                throw new NamespaceErr("Invalid namespace - uri is not 'http://www.w3.org/2000/xmlns/;");
            }
        } else if (Locale.beginsWithXml(str)) {
            throw new NamespaceErr("Invalid prefix - begins with 'xml'");
        }
        return str;
    }

    private static void validateName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Name is null");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("Name is empty");
        }
        if (!XMLChar.isValidName(str)) {
            throw new InvalidCharacterError("Name has an invalid character");
        }
    }

    private static void validateNcName(String str) {
        if (str != null && str.length() > 0 && !XMLChar.isValidNCName(str)) {
            throw new InvalidCharacterError();
        }
    }

    private static void validateQualifiedName(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        int iIndexOf = str.indexOf(58);
        if (iIndexOf < 0) {
            validateNcName(str);
            if (z && str.equals(Sax2Dom.XMLNS_PREFIX) && !str2.equals(Sax2Dom.XMLNS_URI)) {
                throw new NamespaceErr("Default xmlns attribute does not have namespace: http://www.w3.org/2000/xmlns/");
            }
        } else {
            if (iIndexOf == 0) {
                throw new NamespaceErr("Invalid qualified name, no prefix specified");
            }
            String strSubstring = str.substring(0, iIndexOf);
            validateNcName(strSubstring);
            if (str2.length() == 0) {
                throw new NamespaceErr("Attempt to give a prefix for no namespace");
            }
            str = str.substring(iIndexOf + 1);
            if (str.indexOf(58) >= 0) {
                throw new NamespaceErr("Invalid qualified name, more than one colon");
            }
            validateNcName(str);
            if (strSubstring.equals(Sax2Dom.XML_PREFIX) && !str2.equals(XMLValidationSchema.SCHEMA_ID_DTD)) {
                throw new NamespaceErr("Invalid prefix - begins with 'xml'");
            }
        }
        if (str.length() == 0) {
            throw new NamespaceErr("Invalid qualified name, no local part specified");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void removeNode(Dom dom) {
        CharNode charNodes;
        Cur curTempCur = dom.tempCur();
        curTempCur.toEnd();
        if (curTempCur.next() && (charNodes = curTempCur.getCharNodes()) != null) {
            curTempCur.setCharNodes(null);
            Cur curTempCur2 = dom.tempCur();
            curTempCur2.setCharNodes(CharNode.appendNodes(curTempCur2.getCharNodes(), charNodes));
            curTempCur2.release();
        }
        curTempCur.release();
        Cur.moveNode((Xobj) dom, null);
    }

    private static abstract class ElementsNodeList implements NodeList {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private ArrayList _elements;
        private Locale _locale;
        private Dom _root;
        private long _version = 0;

        protected abstract boolean match(Dom dom);

        ElementsNodeList(Dom dom) {
            this._root = dom;
            this._locale = dom.locale();
        }

        @Override // org.w3c.dom.NodeList
        public int getLength() {
            ensureElements();
            return this._elements.size();
        }

        @Override // org.w3c.dom.NodeList
        public Node item(int i) {
            ensureElements();
            if (i >= 0 && i < this._elements.size()) {
                return (Node) this._elements.get(i);
            }
            return null;
        }

        private void ensureElements() {
            if (this._version == this._locale.version()) {
                return;
            }
            this._version = this._locale.version();
            this._elements = new ArrayList();
            Locale locale = this._locale;
            if (locale.noSync()) {
                locale.enter();
                try {
                    addElements(this._root);
                    return;
                } finally {
                    locale.exit();
                }
            }
            synchronized (locale) {
                locale.enter();
                try {
                    addElements(this._root);
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            }
        }

        private void addElements(Dom dom) {
            for (Dom domFirstChild = DomImpl.firstChild(dom); domFirstChild != null; domFirstChild = DomImpl.nextSibling(domFirstChild)) {
                if (domFirstChild.nodeType() == 1) {
                    if (match(domFirstChild)) {
                        this._elements.add(domFirstChild);
                    }
                    addElements(domFirstChild);
                }
            }
        }
    }

    private static class ElementsByTagNameNodeList extends ElementsNodeList {
        private String _name;

        ElementsByTagNameNodeList(Dom dom, String str) {
            super(dom);
            this._name = str;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.ElementsNodeList
        protected boolean match(Dom dom) {
            if (this._name.equals("*")) {
                return true;
            }
            return DomImpl._node_getNodeName(dom).equals(this._name);
        }
    }

    private static class ElementsByTagNameNSNodeList extends ElementsNodeList {
        private String _local;
        private String _uri;

        ElementsByTagNameNSNodeList(Dom dom, String str, String str2) {
            super(dom);
            this._uri = str == null ? "" : str;
            this._local = str2;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.ElementsNodeList
        protected boolean match(Dom dom) {
            if (!this._uri.equals("*") && !DomImpl._node_getNamespaceURI(dom).equals(this._uri)) {
                return DomImpl.$assertionsDisabled;
            }
            if (this._local.equals("*")) {
                return true;
            }
            return DomImpl._node_getLocalName(dom).equals(this._local);
        }
    }

    public static Document _domImplementation_createDocument(Locale locale, String str, String str2, DocumentType documentType) {
        Document documentDomImplementation_createDocument;
        if (locale.noSync()) {
            locale.enter();
            try {
                return domImplementation_createDocument(locale, str, str2, documentType);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                documentDomImplementation_createDocument = domImplementation_createDocument(locale, str, str2, documentType);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return documentDomImplementation_createDocument;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlRuntimeException */
    public static Document domImplementation_createDocument(Locale locale, String str, String str2, DocumentType documentType) throws XmlRuntimeException {
        validateQualifiedName(str2, str, $assertionsDisabled);
        Cur curTempCur = locale.tempCur();
        curTempCur.createDomDocumentRoot();
        Document document = (Document) curTempCur.getDom();
        curTempCur.next();
        curTempCur.createElement(locale.makeQualifiedQName(str, str2));
        if (documentType != null) {
            throw new RuntimeException("Not impl");
        }
        curTempCur.toParent();
        try {
            Locale.autoTypeDocument(curTempCur, null, null);
            curTempCur.release();
            return document;
        } catch (XmlException e) {
            throw new XmlRuntimeException(e);
        }
    }

    public static boolean _domImplementation_hasFeature(Locale locale, String str, String str2) {
        if (str == null) {
            return $assertionsDisabled;
        }
        if (str2 != null && str2.length() > 0 && !str2.equals("1.0") && !str2.equals("2.0")) {
            return $assertionsDisabled;
        }
        if (str.equalsIgnoreCase("core") || str.equalsIgnoreCase(Sax2Dom.XML_PREFIX)) {
            return true;
        }
        return $assertionsDisabled;
    }

    public static Element _document_getDocumentElement(Dom dom) {
        Dom domDocument_getDocumentElement;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domDocument_getDocumentElement = document_getDocumentElement(dom);
            } finally {
                locale.exit();
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domDocument_getDocumentElement = document_getDocumentElement(dom);
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            }
        }
        return (Element) domDocument_getDocumentElement;
    }

    public static Dom document_getDocumentElement(Dom dom) {
        for (Dom domFirstChild = firstChild(dom); domFirstChild != null; domFirstChild = nextSibling(domFirstChild)) {
            if (domFirstChild.nodeType() == 1) {
                return domFirstChild;
            }
        }
        return null;
    }

    public static DocumentFragment _document_createDocumentFragment(Dom dom) {
        Dom domDocument_createDocumentFragment;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domDocument_createDocumentFragment = document_createDocumentFragment(dom);
            } finally {
                locale.exit();
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domDocument_createDocumentFragment = document_createDocumentFragment(dom);
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            }
        }
        return (DocumentFragment) domDocument_createDocumentFragment;
    }

    public static Dom document_createDocumentFragment(Dom dom) {
        Cur curTempCur = dom.locale().tempCur();
        curTempCur.createDomDocFragRoot();
        Dom dom2 = curTempCur.getDom();
        curTempCur.release();
        return dom2;
    }

    public static Element _document_createElement(Dom dom, String str) {
        Dom domDocument_createElement;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domDocument_createElement = document_createElement(dom, str);
            } finally {
                locale.exit();
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domDocument_createElement = document_createElement(dom, str);
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            }
        }
        return (Element) domDocument_createElement;
    }

    public static Dom document_createElement(Dom dom, String str) {
        validateName(str);
        Locale locale = dom.locale();
        Cur curTempCur = locale.tempCur();
        curTempCur.createElement(locale.makeQualifiedQName("", str));
        Dom dom2 = curTempCur.getDom();
        curTempCur.release();
        ((Xobj.ElementXobj) dom2)._canHavePrefixUri = $assertionsDisabled;
        return dom2;
    }

    public static Element _document_createElementNS(Dom dom, String str, String str2) {
        Dom domDocument_createElementNS;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domDocument_createElementNS = document_createElementNS(dom, str, str2);
            } finally {
                locale.exit();
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domDocument_createElementNS = document_createElementNS(dom, str, str2);
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            }
        }
        return (Element) domDocument_createElementNS;
    }

    public static Dom document_createElementNS(Dom dom, String str, String str2) {
        validateQualifiedName(str2, str, $assertionsDisabled);
        Locale locale = dom.locale();
        Cur curTempCur = locale.tempCur();
        curTempCur.createElement(locale.makeQualifiedQName(str, str2));
        Dom dom2 = curTempCur.getDom();
        curTempCur.release();
        return dom2;
    }

    public static Attr _document_createAttribute(Dom dom, String str) {
        Dom domDocument_createAttribute;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domDocument_createAttribute = document_createAttribute(dom, str);
            } finally {
                locale.exit();
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domDocument_createAttribute = document_createAttribute(dom, str);
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            }
        }
        return (Attr) domDocument_createAttribute;
    }

    public static Dom document_createAttribute(Dom dom, String str) {
        validateName(str);
        Locale locale = dom.locale();
        Cur curTempCur = locale.tempCur();
        curTempCur.createAttr(locale.makeQualifiedQName("", str));
        Dom dom2 = curTempCur.getDom();
        curTempCur.release();
        ((Xobj.AttrXobj) dom2)._canHavePrefixUri = $assertionsDisabled;
        return dom2;
    }

    public static Attr _document_createAttributeNS(Dom dom, String str, String str2) {
        Dom domDocument_createAttributeNS;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domDocument_createAttributeNS = document_createAttributeNS(dom, str, str2);
            } finally {
                locale.exit();
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domDocument_createAttributeNS = document_createAttributeNS(dom, str, str2);
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            }
        }
        return (Attr) domDocument_createAttributeNS;
    }

    public static Dom document_createAttributeNS(Dom dom, String str, String str2) {
        validateQualifiedName(str2, str, true);
        Locale locale = dom.locale();
        Cur curTempCur = locale.tempCur();
        curTempCur.createAttr(locale.makeQualifiedQName(str, str2));
        Dom dom2 = curTempCur.getDom();
        curTempCur.release();
        return dom2;
    }

    public static Comment _document_createComment(Dom dom, String str) {
        Dom domDocument_createComment;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domDocument_createComment = document_createComment(dom, str);
            } finally {
                locale.exit();
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domDocument_createComment = document_createComment(dom, str);
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            }
        }
        return (Comment) domDocument_createComment;
    }

    public static Dom document_createComment(Dom dom, String str) {
        Cur curTempCur = dom.locale().tempCur();
        curTempCur.createComment();
        Dom dom2 = curTempCur.getDom();
        if (str != null) {
            curTempCur.next();
            curTempCur.insertString(str);
        }
        curTempCur.release();
        return dom2;
    }

    public static ProcessingInstruction _document_createProcessingInstruction(Dom dom, String str, String str2) {
        Dom domDocument_createProcessingInstruction;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domDocument_createProcessingInstruction = document_createProcessingInstruction(dom, str, str2);
            } finally {
                locale.exit();
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domDocument_createProcessingInstruction = document_createProcessingInstruction(dom, str, str2);
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            }
        }
        return (ProcessingInstruction) domDocument_createProcessingInstruction;
    }

    public static Dom document_createProcessingInstruction(Dom dom, String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Target is null");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("Target is empty");
        }
        if (!XMLChar.isValidName(str)) {
            throw new InvalidCharacterError("Target has an invalid character");
        }
        if (Locale.beginsWithXml(str) && str.length() == 3) {
            throw new InvalidCharacterError("Invalid target - is 'xml'");
        }
        Cur curTempCur = dom.locale().tempCur();
        curTempCur.createProcinst(str);
        Dom dom2 = curTempCur.getDom();
        if (str2 != null) {
            curTempCur.next();
            curTempCur.insertString(str2);
        }
        curTempCur.release();
        return dom2;
    }

    public static CDATASection _document_createCDATASection(Dom dom, String str) {
        return (CDATASection) document_createCDATASection(dom, str);
    }

    public static Dom document_createCDATASection(Dom dom, String str) {
        CdataNode cdataNodeCreateCdataNode = dom.locale().createCdataNode();
        if (str == null) {
            str = "";
        }
        cdataNodeCreateCdataNode.setChars(str, 0, str.length());
        return cdataNodeCreateCdataNode;
    }

    public static Text _document_createTextNode(Dom dom, String str) {
        return (Text) document_createTextNode(dom, str);
    }

    public static CharNode document_createTextNode(Dom dom, String str) {
        TextNode textNodeCreateTextNode = dom.locale().createTextNode();
        if (str == null) {
            str = "";
        }
        textNodeCreateTextNode.setChars(str, 0, str.length());
        return textNodeCreateTextNode;
    }

    public static EntityReference _document_createEntityReference(Dom dom, String str) {
        throw new RuntimeException("Not implemented");
    }

    public static Element _document_getElementById(Dom dom, String str) {
        throw new RuntimeException("Not implemented");
    }

    public static NodeList _document_getElementsByTagName(Dom dom, String str) {
        NodeList nodeListDocument_getElementsByTagName;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return document_getElementsByTagName(dom, str);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                nodeListDocument_getElementsByTagName = document_getElementsByTagName(dom, str);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return nodeListDocument_getElementsByTagName;
    }

    public static NodeList document_getElementsByTagName(Dom dom, String str) {
        return new ElementsByTagNameNodeList(dom, str);
    }

    public static NodeList _document_getElementsByTagNameNS(Dom dom, String str, String str2) {
        NodeList nodeListDocument_getElementsByTagNameNS;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return document_getElementsByTagNameNS(dom, str, str2);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                nodeListDocument_getElementsByTagNameNS = document_getElementsByTagNameNS(dom, str, str2);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return nodeListDocument_getElementsByTagNameNS;
    }

    public static NodeList document_getElementsByTagNameNS(Dom dom, String str, String str2) {
        return new ElementsByTagNameNSNodeList(dom, str, str2);
    }

    public static DOMImplementation _document_getImplementation(Dom dom) {
        return dom.locale();
    }

    public static Node _document_importNode(Dom dom, Node node, boolean z) {
        Dom domDocument_importNode;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domDocument_importNode = document_importNode(dom, node, z);
            } finally {
                locale.exit();
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domDocument_importNode = document_importNode(dom, node, z);
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            }
        }
        return (Node) domDocument_importNode;
    }

    /* JADX WARN: Code duplicated, block: B:65:0x0119  */
    /* JADX WARN: Code duplicated, block: B:68:0x0123 A[LOOP:0: B:66:0x011d->B:68:0x0123, LOOP_END] */
    public static Dom document_importNode(Dom dom, Node node, boolean z) {
        Dom domDocument_createElement;
        Dom domDocument_createAttribute;
        NodeList childNodes;
        if (node == null) {
            return null;
        }
        switch (node.getNodeType()) {
            case 1:
                String localName = node.getLocalName();
                if (localName == null || localName.length() == 0) {
                    domDocument_createElement = document_createElement(dom, node.getNodeName());
                } else {
                    String prefix = node.getPrefix();
                    if (prefix != null && prefix.length() != 0) {
                        localName = prefix + ":" + localName;
                    }
                    String namespaceURI = node.getNamespaceURI();
                    if (namespaceURI == null || namespaceURI.length() == 0) {
                        domDocument_createElement = document_createElement(dom, localName);
                    } else {
                        domDocument_createElement = document_createElementNS(dom, namespaceURI, localName);
                    }
                }
                NamedNodeMap attributes = node.getAttributes();
                for (int i = 0; i < attributes.getLength(); i++) {
                    attributes_setNamedItem(domDocument_createElement, document_importNode(dom, attributes.item(i), true));
                }
                if (z) {
                    childNodes = node.getChildNodes();
                    for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                        node_insertBefore(domDocument_createElement, document_importNode(dom, childNodes.item(i2), true), null);
                    }
                }
                return domDocument_createElement;
            case 2:
                String localName2 = node.getLocalName();
                if (localName2 == null || localName2.length() == 0) {
                    domDocument_createAttribute = document_createAttribute(dom, node.getNodeName());
                } else {
                    String prefix2 = node.getPrefix();
                    if (prefix2 != null && prefix2.length() != 0) {
                        localName2 = prefix2 + ":" + localName2;
                    }
                    String namespaceURI2 = node.getNamespaceURI();
                    if (namespaceURI2 == null || namespaceURI2.length() == 0) {
                        domDocument_createAttribute = document_createAttribute(dom, localName2);
                    } else {
                        domDocument_createAttribute = document_createAttributeNS(dom, namespaceURI2, localName2);
                    }
                }
                domDocument_createElement = domDocument_createAttribute;
                z = true;
                if (z) {
                    childNodes = node.getChildNodes();
                    while (i2 < childNodes.getLength()) {
                        node_insertBefore(domDocument_createElement, document_importNode(dom, childNodes.item(i2), true), null);
                    }
                }
                return domDocument_createElement;
            case 3:
                domDocument_createElement = document_createTextNode(dom, node.getNodeValue());
                z = false;
                if (z) {
                    childNodes = node.getChildNodes();
                    while (i2 < childNodes.getLength()) {
                        node_insertBefore(domDocument_createElement, document_importNode(dom, childNodes.item(i2), true), null);
                    }
                }
                return domDocument_createElement;
            case 4:
                domDocument_createElement = document_createCDATASection(dom, node.getNodeValue());
                z = false;
                if (z) {
                    childNodes = node.getChildNodes();
                    while (i2 < childNodes.getLength()) {
                        node_insertBefore(domDocument_createElement, document_importNode(dom, childNodes.item(i2), true), null);
                    }
                }
                return domDocument_createElement;
            case 5:
            case 6:
            case 12:
                throw new RuntimeException("Not impl");
            case 7:
                domDocument_createElement = document_createProcessingInstruction(dom, node.getNodeName(), node.getNodeValue());
                z = false;
                if (z) {
                    childNodes = node.getChildNodes();
                    while (i2 < childNodes.getLength()) {
                        node_insertBefore(domDocument_createElement, document_importNode(dom, childNodes.item(i2), true), null);
                    }
                }
                return domDocument_createElement;
            case 8:
                domDocument_createElement = document_createComment(dom, node.getNodeValue());
                z = false;
                if (z) {
                    childNodes = node.getChildNodes();
                    while (i2 < childNodes.getLength()) {
                        node_insertBefore(domDocument_createElement, document_importNode(dom, childNodes.item(i2), true), null);
                    }
                }
                return domDocument_createElement;
            case 9:
                throw new NotSupportedError("Document nodes may not be imported");
            case 10:
                throw new NotSupportedError("Document type nodes may not be imported");
            case 11:
                domDocument_createElement = document_createDocumentFragment(dom);
                if (z) {
                    childNodes = node.getChildNodes();
                    while (i2 < childNodes.getLength()) {
                        node_insertBefore(domDocument_createElement, document_importNode(dom, childNodes.item(i2), true), null);
                    }
                }
                return domDocument_createElement;
            default:
                throw new RuntimeException("Unknown kind");
        }
    }

    public static DocumentType _document_getDoctype(Dom dom) {
        Dom domDocument_getDoctype;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domDocument_getDoctype = document_getDoctype(dom);
            } finally {
                locale.exit();
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domDocument_getDoctype = document_getDoctype(dom);
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            }
        }
        return (DocumentType) domDocument_getDoctype;
    }

    public static Document _node_getOwnerDocument(Dom dom) {
        Dom domNode_getOwnerDocument;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domNode_getOwnerDocument = node_getOwnerDocument(dom);
            } finally {
                locale.exit();
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domNode_getOwnerDocument = node_getOwnerDocument(dom);
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            }
        }
        return (Document) domNode_getOwnerDocument;
    }

    public static Dom node_getOwnerDocument(Dom dom) {
        if (dom.nodeType() == 9) {
            return null;
        }
        Locale locale = dom.locale();
        if (locale._ownerDoc == null) {
            Cur curTempCur = locale.tempCur();
            curTempCur.createDomDocumentRoot();
            locale._ownerDoc = curTempCur.getDom();
            curTempCur.release();
        }
        return locale._ownerDoc;
    }

    public static Node _node_getParentNode(Dom dom) {
        Dom domNode_getParentNode;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domNode_getParentNode = node_getParentNode(dom);
            } finally {
                locale.exit();
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domNode_getParentNode = node_getParentNode(dom);
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            }
        }
        return (Node) domNode_getParentNode;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x003b  */
    public static Dom node_getParentNode(Dom dom) {
        Cur curTempCur;
        switch (dom.nodeType()) {
            case 1:
            case 7:
            case 8:
                curTempCur = dom.tempCur();
                if (!curTempCur.toParentRaw()) {
                    curTempCur.release();
                    break;
                }
                if (curTempCur == null) {
                    return null;
                }
                Dom dom2 = curTempCur.getDom();
                curTempCur.release();
                return dom2;
            case 2:
            case 9:
            case 11:
                curTempCur = null;
                if (curTempCur == null) {
                    return null;
                }
                Dom dom3 = curTempCur.getDom();
                curTempCur.release();
                return dom3;
            case 3:
            case 4:
                curTempCur = dom.tempCur();
                if (curTempCur != null) {
                    curTempCur.toParent();
                }
                if (curTempCur == null) {
                    return null;
                }
                Dom dom4 = curTempCur.getDom();
                curTempCur.release();
                return dom4;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            default:
                throw new RuntimeException("Unknown kind");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Node _node_getFirstChild(Dom dom) {
        Dom domNode_getFirstChild;
        Locale locale = dom.locale();
        Xobj xobj = (Xobj) dom;
        if (!xobj.isVacant()) {
            if (xobj.isFirstChildPtrDomUsable()) {
                return (Node) xobj._firstChild;
            }
            Xobj xobjLastAttr = xobj.lastAttr();
            if (xobjLastAttr != null && xobjLastAttr.isNextSiblingPtrDomUsable()) {
                return (Xobj.NodeXobj) xobjLastAttr._nextSibling;
            }
            if (xobj.isExistingCharNodesValueUsable()) {
                return xobj._charNodesValue;
            }
        }
        if (locale.noSync()) {
            domNode_getFirstChild = node_getFirstChild(dom);
        } else {
            synchronized (locale) {
                domNode_getFirstChild = node_getFirstChild(dom);
            }
        }
        return (Node) domNode_getFirstChild;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Dom node_getFirstChild(Dom dom) {
        int iNodeType = dom.nodeType();
        if (iNodeType != 1 && iNodeType != 2) {
            if (iNodeType == 5) {
                throw new RuntimeException("Not impl");
            }
            if (iNodeType != 6) {
                switch (iNodeType) {
                    case 9:
                    case 11:
                        break;
                    case 10:
                    case 12:
                        break;
                    default:
                        return null;
                }
            }
            throw new RuntimeException("Not impl");
        }
        Xobj xobj = (Xobj) dom;
        xobj.ensureOccupancy();
        if (xobj.isFirstChildPtrDomUsable()) {
            return (Xobj.NodeXobj) xobj._firstChild;
        }
        Xobj xobjLastAttr = xobj.lastAttr();
        if (xobjLastAttr != null) {
            if (xobjLastAttr.isNextSiblingPtrDomUsable()) {
                return (Xobj.NodeXobj) xobjLastAttr._nextSibling;
            }
            if (xobjLastAttr.isCharNodesAfterUsable()) {
                return xobjLastAttr._charNodesAfter;
            }
        }
        if (xobj.isCharNodesValueUsable()) {
            return xobj._charNodesValue;
        }
        return null;
    }

    public static Node _node_getLastChild(Dom dom) {
        Dom domNode_getLastChild;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domNode_getLastChild = node_getLastChild(dom);
            } finally {
                locale.exit();
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domNode_getLastChild = node_getLastChild(dom);
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            }
        }
        return (Node) domNode_getLastChild;
    }

    public static Dom node_getLastChild(Dom dom) {
        CharNode charNodes;
        Dom dom2 = null;
        switch (dom.nodeType()) {
            case 3:
            case 4:
            case 7:
            case 8:
                return null;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            case 9:
            case 11:
            default:
                Cur curTempCur = dom.tempCur();
                if (curTempCur.toLastChild()) {
                    Dom dom3 = curTempCur.getDom();
                    curTempCur.skip();
                    charNodes = curTempCur.getCharNodes();
                    if (charNodes == null) {
                        dom2 = dom3;
                    }
                } else {
                    curTempCur.next();
                    charNodes = curTempCur.getCharNodes();
                }
                if (dom2 == null && charNodes != null) {
                    while (charNodes._next != null) {
                        charNodes = charNodes._next;
                    }
                    dom2 = charNodes;
                }
                curTempCur.release();
                return dom2;
        }
    }

    public static Node _node_getNextSibling(Dom dom) {
        Dom domNode_getNextSibling;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            domNode_getNextSibling = node_getNextSibling(dom);
        } else {
            synchronized (locale) {
                domNode_getNextSibling = node_getNextSibling(dom);
            }
        }
        return (Node) domNode_getNextSibling;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Dom node_getNextSibling(Dom dom) {
        switch (dom.nodeType()) {
            case 1:
            case 7:
            case 8:
                Xobj xobj = (Xobj) dom;
                xobj.ensureOccupancy();
                if (xobj.isNextSiblingPtrDomUsable()) {
                    return (Xobj.NodeXobj) xobj._nextSibling;
                }
                if (xobj.isCharNodesAfterUsable()) {
                    return xobj._charNodesAfter;
                }
                return null;
            case 2:
            case 9:
            case 11:
            default:
                return null;
            case 3:
            case 4:
                CharNode charNode = (CharNode) dom;
                if (!(charNode._src instanceof Xobj)) {
                    return null;
                }
                Xobj xobj2 = (Xobj) charNode._src;
                xobj2._charNodesAfter = Cur.updateCharNodes(xobj2._locale, xobj2, xobj2._charNodesAfter, xobj2._cchAfter);
                xobj2._charNodesValue = Cur.updateCharNodes(xobj2._locale, xobj2, xobj2._charNodesValue, xobj2._cchValue);
                if (charNode._next != null) {
                    return charNode._next;
                }
                if (charNode.isNodeAftertext()) {
                    return (Xobj.NodeXobj) xobj2._nextSibling;
                }
                return (Xobj.NodeXobj) xobj2._firstChild;
            case 5:
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not implemented");
        }
    }

    public static Node _node_getPreviousSibling(Dom dom) {
        Dom domNode_getPreviousSibling;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            domNode_getPreviousSibling = node_getPreviousSibling(dom);
        } else {
            synchronized (locale) {
                domNode_getPreviousSibling = node_getPreviousSibling(dom);
            }
        }
        return (Node) domNode_getPreviousSibling;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x004e -> B:20:0x0046). Please report as a decompilation issue!!! */
    public static Dom node_getPreviousSibling(Dom dom) {
        Dom domNode_getNextSibling;
        Dom domNode_getFirstChild;
        int iNodeType = dom.nodeType();
        if (iNodeType == 3 || iNodeType == 4) {
            CharNode charNode = (CharNode) dom;
            if (!(charNode._src instanceof Xobj)) {
                return null;
            }
            Xobj xobj = (Xobj) charNode._src;
            xobj.ensureOccupancy();
            boolean zIsNodeAftertext = charNode.isNodeAftertext();
            domNode_getNextSibling = charNode._prev;
            if (domNode_getNextSibling != null) {
                domNode_getFirstChild = domNode_getNextSibling;
            } else if (zIsNodeAftertext) {
                domNode_getFirstChild = (Dom) xobj;
            } else {
                domNode_getNextSibling = xobj._charNodesValue;
                domNode_getFirstChild = domNode_getNextSibling;
            }
        } else {
            Xobj xobj2 = (Xobj) dom;
            domNode_getFirstChild = (Dom) xobj2._prevSibling;
            if (domNode_getFirstChild == null && xobj2._parent != null) {
                domNode_getFirstChild = node_getFirstChild((Dom) xobj2._parent);
            }
        }
        if (domNode_getFirstChild != null || (domNode_getNextSibling = node_getNextSibling(domNode_getFirstChild)) == dom) {
            return domNode_getFirstChild;
        }
        domNode_getFirstChild = domNode_getNextSibling;
        if (domNode_getFirstChild != null) {
        }
        return domNode_getFirstChild;
    }

    public static boolean _node_hasAttributes(Dom dom) {
        boolean zNode_hasAttributes;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return node_hasAttributes(dom);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                zNode_hasAttributes = node_hasAttributes(dom);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return zNode_hasAttributes;
    }

    public static boolean node_hasAttributes(Dom dom) {
        if (dom.nodeType() != 1) {
            return $assertionsDisabled;
        }
        Cur curTempCur = dom.tempCur();
        boolean zHasAttrs = curTempCur.hasAttrs();
        curTempCur.release();
        return zHasAttrs;
    }

    public static boolean _node_isSupported(Dom dom, String str, String str2) {
        return _domImplementation_hasFeature(dom.locale(), str, str2);
    }

    public static void _node_normalize(Dom dom) {
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                node_normalize(dom);
                return;
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                node_normalize(dom);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
    }

    public static void node_normalize(Dom dom) {
        switch (dom.nodeType()) {
            case 3:
            case 4:
            case 7:
            case 8:
                return;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            case 9:
            case 11:
            default:
                Cur curTempCur = dom.tempCur();
                curTempCur.push();
                do {
                    curTempCur.nextWithAttrs();
                    CharNode charNodes = curTempCur.getCharNodes();
                    if (charNodes != null) {
                        if (!curTempCur.isText()) {
                            while (charNodes != null) {
                                charNodes.setChars(null, 0, 0);
                                charNodes = CharNode.remove(charNodes, charNodes);
                            }
                        } else if (charNodes._next != null) {
                            while (charNodes._next != null) {
                                charNodes.setChars(null, 0, 0);
                                charNodes = CharNode.remove(charNodes, charNodes._next);
                            }
                            charNodes._cch = Integer.MAX_VALUE;
                        }
                        curTempCur.setCharNodes(charNodes);
                    }
                } while (!curTempCur.isAtEndOfLastPush());
                curTempCur.release();
                dom.locale().invalidateDomCaches(dom);
                return;
        }
    }

    public static boolean _node_hasChildNodes(Dom dom) {
        if (_node_getFirstChild(dom) != null) {
            return true;
        }
        return $assertionsDisabled;
    }

    public static Node _node_appendChild(Dom dom, Node node) {
        return _node_insertBefore(dom, node, null);
    }

    public static Node _node_replaceChild(Dom dom, Node node, Node node2) {
        Dom domNode_replaceChild;
        Locale locale = dom.locale();
        if (node == null) {
            throw new IllegalArgumentException("Child to add is null");
        }
        if (node2 == null) {
            throw new NotFoundErr("Child to replace is null");
        }
        if (node instanceof Dom) {
            Dom dom2 = (Dom) node;
            if (dom2.locale() == locale) {
                if (node2 instanceof Dom) {
                    Dom dom3 = (Dom) node2;
                    if (dom3.locale() == locale) {
                        if (locale.noSync()) {
                            locale.enter();
                            try {
                                domNode_replaceChild = node_replaceChild(dom, dom2, dom3);
                            } finally {
                                locale.exit();
                            }
                        } else {
                            synchronized (locale) {
                                locale.enter();
                                try {
                                    domNode_replaceChild = node_replaceChild(dom, dom2, dom3);
                                    locale.exit();
                                } catch (Throwable th) {
                                    locale.exit();
                                    throw th;
                                }
                            }
                        }
                        return (Node) domNode_replaceChild;
                    }
                }
                throw new WrongDocumentErr("Child to replace is from another document");
            }
        }
        throw new WrongDocumentErr("Child to add is from another document");
    }

    public static Dom node_replaceChild(Dom dom, Dom dom2, Dom dom3) {
        Dom domNode_getNextSibling = node_getNextSibling(dom3);
        node_removeChild(dom, dom3);
        try {
            node_insertBefore(dom, dom2, domNode_getNextSibling);
            return dom3;
        } catch (DOMException e) {
            node_insertBefore(dom, dom3, domNode_getNextSibling);
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
    
        if (r4.locale() == r0) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.w3c.dom.Node _node_insertBefore(org.apache.xmlbeans.impl.store.DomImpl.Dom r2, org.w3c.dom.Node r3, org.w3c.dom.Node r4) {
        /*
            org.apache.xmlbeans.impl.store.Locale r0 = r2.locale()
            if (r3 == 0) goto L5f
            boolean r1 = r3 instanceof org.apache.xmlbeans.impl.store.DomImpl.Dom
            if (r1 == 0) goto L57
            org.apache.xmlbeans.impl.store.DomImpl$Dom r3 = (org.apache.xmlbeans.impl.store.DomImpl.Dom) r3
            org.apache.xmlbeans.impl.store.Locale r1 = r3.locale()
            if (r1 != r0) goto L57
            if (r4 == 0) goto L29
            boolean r1 = r4 instanceof org.apache.xmlbeans.impl.store.DomImpl.Dom
            if (r1 == 0) goto L21
            org.apache.xmlbeans.impl.store.DomImpl$Dom r4 = (org.apache.xmlbeans.impl.store.DomImpl.Dom) r4
            org.apache.xmlbeans.impl.store.Locale r1 = r4.locale()
            if (r1 != r0) goto L21
            goto L2a
        L21:
            org.apache.xmlbeans.impl.store.DomImpl$WrongDocumentErr r2 = new org.apache.xmlbeans.impl.store.DomImpl$WrongDocumentErr
            java.lang.String r3 = "Reference child is from another document"
            r2.<init>(r3)
            throw r2
        L29:
            r4 = 0
        L2a:
            boolean r1 = r0.noSync()
            if (r1 == 0) goto L40
            r0.enter()
            org.apache.xmlbeans.impl.store.DomImpl$Dom r2 = node_insertBefore(r2, r3, r4)     // Catch: java.lang.Throwable -> L3b
            r0.exit()
            goto L4c
        L3b:
            r2 = move-exception
            r0.exit()
            throw r2
        L40:
            monitor-enter(r0)
            r0.enter()     // Catch: java.lang.Throwable -> L54
            org.apache.xmlbeans.impl.store.DomImpl$Dom r2 = node_insertBefore(r2, r3, r4)     // Catch: java.lang.Throwable -> L4f
            r0.exit()     // Catch: java.lang.Throwable -> L54
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L54
        L4c:
            org.w3c.dom.Node r2 = (org.w3c.dom.Node) r2
            return r2
        L4f:
            r2 = move-exception
            r0.exit()     // Catch: java.lang.Throwable -> L54
            throw r2     // Catch: java.lang.Throwable -> L54
        L54:
            r2 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L54
            throw r2
        L57:
            org.apache.xmlbeans.impl.store.DomImpl$WrongDocumentErr r2 = new org.apache.xmlbeans.impl.store.DomImpl$WrongDocumentErr
            java.lang.String r3 = "Child to add is from another document"
            r2.<init>(r3)
            throw r2
        L5f:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Child to add is null"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.store.DomImpl._node_insertBefore(org.apache.xmlbeans.impl.store.DomImpl$Dom, org.w3c.dom.Node, org.w3c.dom.Node):org.w3c.dom.Node");
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:57:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:67:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:73:0x010e  */
    /* JADX WARN: Code duplicated, block: B:74:0x0112  */
    /* JADX WARN: Code duplicated, block: B:78:0x0120  */
    /* JADX WARN: Code duplicated, block: B:80:0x0128  */
    /* JADX WARN: Code duplicated, block: B:81:0x012c  */
    /* JADX WARN: Multi-variable type inference failed */
    public static Dom node_insertBefore(Dom dom, Dom dom2, Dom dom3) {
        int iNodeType;
        ArrayList arrayList;
        Dom domNextSibling;
        int i;
        Dom dom4;
        CharNode charNode;
        if (dom2 == dom3) {
            return dom2;
        }
        if (dom3 != null && parent(dom3) != dom) {
            throw new NotFoundErr("RefChild is not a child of this node");
        }
        int iNodeType2 = dom2.nodeType();
        if (iNodeType2 == 11) {
            for (Dom domFirstChild = firstChild(dom2); domFirstChild != null; domFirstChild = nextSibling(domFirstChild)) {
                validateNewChild(dom, domFirstChild);
            }
            Dom domFirstChild2 = firstChild(dom2);
            while (domFirstChild2 != null) {
                Dom domNextSibling2 = nextSibling(domFirstChild2);
                if (dom3 == null) {
                    append(domFirstChild2, dom);
                } else {
                    insert(domFirstChild2, dom3);
                }
                domFirstChild2 = domNextSibling2;
            }
            return dom2;
        }
        validateNewChild(dom, dom2);
        remove(dom2);
        dom.nodeType();
        if (iNodeType2 != 1) {
            if (iNodeType2 == 10) {
                throw new RuntimeException("Not implemented");
            }
            if (iNodeType2 == 3 || iNodeType2 == 4) {
                CharNode charNode2 = (CharNode) dom2;
                Cur curTempCur = dom.tempCur();
                if (dom3 == null) {
                    curTempCur.toEnd();
                } else {
                    int iNodeType3 = dom3.nodeType();
                    if (iNodeType3 == 3 || iNodeType3 == 4) {
                        charNode = (CharNode) dom3;
                        curTempCur.moveToCharNode(charNode);
                    } else {
                        if (iNodeType3 == 5) {
                            throw new RuntimeException("Not implemented");
                        }
                        curTempCur.moveToDom(dom3);
                    }
                    CharNode charNodeInsertNode = CharNode.insertNode(curTempCur.getCharNodes(), charNode2, charNode);
                    curTempCur.insertChars(charNode2._src, charNode2._off, charNode2._cch);
                    curTempCur.setCharNodes(charNodeInsertNode);
                    curTempCur.release();
                }
                charNode = null;
                CharNode charNodeInsertNode2 = CharNode.insertNode(curTempCur.getCharNodes(), charNode2, charNode);
                curTempCur.insertChars(charNode2._src, charNode2._off, charNode2._cch);
                curTempCur.setCharNodes(charNodeInsertNode2);
                curTempCur.release();
            } else {
                if (iNodeType2 == 5) {
                    throw new RuntimeException("Not implemented");
                }
                if (iNodeType2 != 7 && iNodeType2 != 8) {
                    throw new RuntimeException("Unexpected child node type");
                }
                if (dom3 == null) {
                    Cur curTempCur2 = dom.tempCur();
                    curTempCur2.toEnd();
                    Cur.moveNode((Xobj) dom2, curTempCur2);
                    curTempCur2.release();
                } else {
                    iNodeType = dom3.nodeType();
                    if (iNodeType != 3) {
                        arrayList = new ArrayList();
                        while (dom3 != null) {
                            Dom domNextSibling3 = nextSibling(dom3);
                            arrayList.add(remove(dom3));
                            dom3 = domNextSibling3;
                        }
                        if (dom3 == null) {
                            append(dom2, dom);
                        } else {
                            insert(dom2, dom3);
                        }
                        domNextSibling = nextSibling(dom2);
                        while (i < arrayList.size()) {
                            dom4 = (Dom) arrayList.get(i);
                            if (domNextSibling == null) {
                                append(dom4, dom);
                            } else {
                                insert(dom4, domNextSibling);
                            }
                        }
                    } else {
                        arrayList = new ArrayList();
                        while (dom3 != null) {
                            Dom domNextSibling4 = nextSibling(dom3);
                            arrayList.add(remove(dom3));
                            dom3 = domNextSibling4;
                        }
                        if (dom3 == null) {
                            append(dom2, dom);
                        } else {
                            insert(dom2, dom3);
                        }
                        domNextSibling = nextSibling(dom2);
                        while (i < arrayList.size()) {
                            dom4 = (Dom) arrayList.get(i);
                            if (domNextSibling == null) {
                                append(dom4, dom);
                            } else {
                                insert(dom4, domNextSibling);
                            }
                        }
                    }
                }
            }
        } else if (dom3 == null) {
            Cur curTempCur3 = dom.tempCur();
            curTempCur3.toEnd();
            Cur.moveNode((Xobj) dom2, curTempCur3);
            curTempCur3.release();
        } else {
            iNodeType = dom3.nodeType();
            if (iNodeType != 3 || iNodeType == 4) {
                arrayList = new ArrayList();
                while (dom3 != null && (dom3.nodeType() == 3 || dom3.nodeType() == 4)) {
                    Dom domNextSibling5 = nextSibling(dom3);
                    arrayList.add(remove(dom3));
                    dom3 = domNextSibling5;
                }
                if (dom3 == null) {
                    append(dom2, dom);
                } else {
                    insert(dom2, dom3);
                }
                domNextSibling = nextSibling(dom2);
                for (i = 0; i < arrayList.size(); i++) {
                    dom4 = (Dom) arrayList.get(i);
                    if (domNextSibling == null) {
                        append(dom4, dom);
                    } else {
                        insert(dom4, domNextSibling);
                    }
                }
            } else {
                if (iNodeType == 5) {
                    throw new RuntimeException("Not implemented");
                }
                Cur curTempCur4 = dom3.tempCur();
                Cur.moveNode((Xobj) dom2, curTempCur4);
                curTempCur4.release();
            }
        }
        return dom2;
    }

    public static Node _node_removeChild(Dom dom, Node node) {
        Dom domNode_removeChild;
        Locale locale = dom.locale();
        if (node == null) {
            throw new NotFoundErr("Child to remove is null");
        }
        if (node instanceof Dom) {
            Dom dom2 = (Dom) node;
            if (dom2.locale() == locale) {
                if (locale.noSync()) {
                    locale.enter();
                    try {
                        domNode_removeChild = node_removeChild(dom, dom2);
                    } finally {
                        locale.exit();
                    }
                } else {
                    synchronized (locale) {
                        locale.enter();
                        try {
                            domNode_removeChild = node_removeChild(dom, dom2);
                            locale.exit();
                        } catch (Throwable th) {
                            locale.exit();
                            throw th;
                        }
                    }
                }
                return (Node) domNode_removeChild;
            }
        }
        throw new WrongDocumentErr("Child to remove is from another document");
    }

    public static Dom node_removeChild(Dom dom, Dom dom2) {
        if (parent(dom2) != dom) {
            throw new NotFoundErr("Child to remove is not a child of given parent");
        }
        switch (dom2.nodeType()) {
            case 1:
            case 7:
            case 8:
                removeNode(dom2);
                return dom2;
            case 2:
            case 9:
            case 11:
                throw new IllegalStateException();
            case 3:
            case 4:
                Cur curTempCur = dom2.tempCur();
                CharNode charNodes = curTempCur.getCharNodes();
                CharNode charNode = (CharNode) dom2;
                charNode.setChars(curTempCur.moveChars(null, charNode._cch), curTempCur._offSrc, curTempCur._cchSrc);
                curTempCur.setCharNodes(CharNode.remove(charNodes, charNode));
                curTempCur.release();
                return dom2;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            default:
                throw new RuntimeException("Unknown kind");
        }
    }

    public static Node _node_cloneNode(Dom dom, boolean z) {
        Dom domNode_cloneNode;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domNode_cloneNode = node_cloneNode(dom, z);
            } finally {
                locale.exit();
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domNode_cloneNode = node_cloneNode(dom, z);
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            }
        }
        return (Node) domNode_cloneNode;
    }

    public static Dom node_cloneNode(Dom dom, boolean z) {
        Cur curTempCur;
        Locale locale = dom.locale();
        Dom dom2 = null;
        if (!z) {
            int iNodeType = dom.nodeType();
            if (iNodeType == 1) {
                curTempCur = locale.tempCur();
                curTempCur.createElement(dom.getQName());
                Element element = (Element) curTempCur.getDom();
                NamedNodeMap attributes = ((Element) dom).getAttributes();
                for (int i = 0; i < attributes.getLength(); i++) {
                    element.setAttributeNodeNS((Attr) attributes.item(i).cloneNode(true));
                }
            } else if (iNodeType == 2) {
                curTempCur = locale.tempCur();
                curTempCur.createAttr(dom.getQName());
            } else if (iNodeType == 9) {
                curTempCur = locale.tempCur();
                curTempCur.createDomDocumentRoot();
            } else if (iNodeType != 11) {
                curTempCur = null;
            } else {
                curTempCur = locale.tempCur();
                curTempCur.createDomDocFragRoot();
            }
            if (curTempCur != null) {
                dom2 = curTempCur.getDom();
                curTempCur.release();
            }
        }
        if (dom2 != null) {
            return dom2;
        }
        switch (dom.nodeType()) {
            case 1:
            case 2:
            case 7:
            case 8:
            case 9:
            case 11:
                Cur curTempCur2 = locale.tempCur();
                Cur curTempCur3 = dom.tempCur();
                curTempCur3.copyNode(curTempCur2);
                Dom dom3 = curTempCur2.getDom();
                curTempCur2.release();
                curTempCur3.release();
                return dom3;
            case 3:
            case 4:
                Cur curTempCur4 = dom.tempCur();
                TextNode textNodeCreateTextNode = dom.nodeType() == 3 ? locale.createTextNode() : locale.createCdataNode();
                textNodeCreateTextNode.setChars(curTempCur4.getChars(((CharNode) dom)._cch), curTempCur4._offSrc, curTempCur4._cchSrc);
                curTempCur4.release();
                return textNodeCreateTextNode;
            case 5:
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            default:
                throw new RuntimeException("Unknown kind");
        }
    }

    public static String _node_getLocalName(Dom dom) {
        if (!dom.nodeCanHavePrefixUri()) {
            return null;
        }
        QName qName = dom.getQName();
        return qName == null ? "" : qName.getLocalPart();
    }

    public static String _node_getNamespaceURI(Dom dom) {
        if (!dom.nodeCanHavePrefixUri()) {
            return null;
        }
        QName qName = dom.getQName();
        return qName == null ? "" : qName.getNamespaceURI();
    }

    public static void _node_setPrefix(Dom dom, String str) {
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                node_setPrefix(dom, str);
                return;
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                node_setPrefix(dom, str);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
    }

    public static void node_setPrefix(Dom dom, String str) {
        int iNodeType = dom.nodeType();
        boolean z = $assertionsDisabled;
        if (iNodeType == 1 || dom.nodeType() == 2) {
            Cur curTempCur = dom.tempCur();
            QName name = curTempCur.getName();
            String namespaceURI = name.getNamespaceURI();
            String localPart = name.getLocalPart();
            if (dom.nodeType() == 2) {
                z = true;
            }
            curTempCur.setName(dom.locale().makeQName(namespaceURI, localPart, validatePrefix(str, namespaceURI, localPart, z)));
            curTempCur.release();
            return;
        }
        validatePrefix(str, "", "", $assertionsDisabled);
    }

    public static String _node_getPrefix(Dom dom) {
        if (!dom.nodeCanHavePrefixUri()) {
            return null;
        }
        QName qName = dom.getQName();
        return qName == null ? "" : qName.getPrefix();
    }

    public static String _node_getNodeName(Dom dom) {
        switch (dom.nodeType()) {
            case 1:
            case 2:
                QName qName = dom.getQName();
                String prefix = qName.getPrefix();
                return prefix.length() == 0 ? qName.getLocalPart() : prefix + ":" + qName.getLocalPart();
            case 3:
                return "#text";
            case 4:
                return "#cdata-section";
            case 5:
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            case 7:
                return dom.getQName().getLocalPart();
            case 8:
                return "#comment";
            case 9:
                return "#document";
            case 11:
                return "#document-fragment";
            default:
                throw new RuntimeException("Unknown node type");
        }
    }

    public static short _node_getNodeType(Dom dom) {
        return (short) dom.nodeType();
    }

    public static void _node_setNodeValue(Dom dom, String str) {
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                node_setNodeValue(dom, str);
                return;
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                node_setNodeValue(dom, str);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
    }

    public static void node_setNodeValue(Dom dom, String str) {
        if (str == null) {
            str = "";
        }
        int iNodeType = dom.nodeType();
        if (iNodeType == 2) {
            NodeList childNodes = ((Node) dom).getChildNodes();
            while (childNodes.getLength() > 1) {
                node_removeChild(dom, (Dom) childNodes.item(1));
            }
            if (childNodes.getLength() == 0) {
                TextNode textNodeCreateTextNode = dom.locale().createTextNode();
                textNodeCreateTextNode.setChars(str, 0, str.length());
                node_insertBefore(dom, textNodeCreateTextNode, null);
            } else {
                childNodes.item(0).setNodeValue(str);
            }
            if (((Xobj.AttrXobj) dom).isId()) {
                Dom domNode_getOwnerDocument = node_getOwnerDocument(dom);
                String strNode_getNodeValue = node_getNodeValue(dom);
                if (domNode_getOwnerDocument instanceof Xobj.DocumentXobj) {
                    Xobj.DocumentXobj documentXobj = (Xobj.DocumentXobj) domNode_getOwnerDocument;
                    documentXobj.removeIdElement(strNode_getNodeValue);
                    documentXobj.addIdElement(str, attr_getOwnerElement(dom));
                    return;
                }
                return;
            }
            return;
        }
        if (iNodeType == 3 || iNodeType == 4) {
            CharNode charNode = (CharNode) dom;
            Cur curTempCur = charNode.tempCur();
            if (curTempCur != null) {
                curTempCur.moveChars(null, charNode._cch);
                charNode._cch = str.length();
                curTempCur.insertString(str);
                curTempCur.release();
                return;
            }
            charNode.setChars(str, 0, str.length());
            return;
        }
        if (iNodeType == 7 || iNodeType == 8) {
            Cur curTempCur2 = dom.tempCur();
            curTempCur2.next();
            curTempCur2.getChars(-1);
            curTempCur2.moveChars(null, curTempCur2._cchSrc);
            curTempCur2.insertString(str);
            curTempCur2.release();
        }
    }

    public static String _node_getNodeValue(Dom dom) {
        String strNode_getNodeValue;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            return node_getNodeValue(dom);
        }
        synchronized (locale) {
            strNode_getNodeValue = node_getNodeValue(dom);
        }
        return strNode_getNodeValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String node_getNodeValue(Dom dom) {
        int iNodeType = dom.nodeType();
        if (iNodeType != 2) {
            if (iNodeType == 3 || iNodeType == 4) {
                CharNode charNode = (CharNode) dom;
                if (!(charNode._src instanceof Xobj)) {
                    return CharUtil.getString(charNode._src, charNode._off, charNode._cch);
                }
                Xobj xobj = (Xobj) charNode._src;
                xobj.ensureOccupancy();
                if (charNode.isNodeAftertext()) {
                    xobj._charNodesAfter = Cur.updateCharNodes(xobj._locale, xobj, xobj._charNodesAfter, xobj._cchAfter);
                    return xobj.getCharsAfterAsString(charNode._off, charNode._cch);
                }
                xobj._charNodesValue = Cur.updateCharNodes(xobj._locale, xobj, xobj._charNodesValue, xobj._cchValue);
                return xobj.getCharsValueAsString(charNode._off, charNode._cch);
            }
            if (iNodeType != 7 && iNodeType != 8) {
                return null;
            }
        }
        return ((Xobj) dom).getValueAsString();
    }

    public static Object _node_getUserData(Dom dom, String str) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static Object _node_setUserData(Dom dom, String str, Object obj, UserDataHandler userDataHandler) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static Object _node_getFeature(Dom dom, String str, String str2) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static boolean _node_isEqualNode(Dom dom, Node node) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static boolean _node_isSameNode(Dom dom, Node node) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static String _node_lookupNamespaceURI(Dom dom, String str) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static boolean _node_isDefaultNamespace(Dom dom, String str) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static String _node_lookupPrefix(Dom dom, String str) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static void _node_setTextContent(Dom dom, String str) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static String _node_getTextContent(Dom dom) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static short _node_compareDocumentPosition(Dom dom, Node node) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static String _node_getBaseURI(Dom dom) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static Node _childNodes_item(Dom dom, int i) {
        Dom domChildNodes_item;
        Locale locale = dom.locale();
        if (i == 0) {
            return _node_getFirstChild(dom);
        }
        if (locale.noSync()) {
            domChildNodes_item = childNodes_item(dom, i);
        } else {
            synchronized (locale) {
                domChildNodes_item = childNodes_item(dom, i);
            }
        }
        return (Node) domChildNodes_item;
    }

    public static Dom childNodes_item(Dom dom, int i) {
        if (i < 0) {
            return null;
        }
        switch (dom.nodeType()) {
            case 3:
            case 4:
            case 7:
            case 8:
                return null;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            case 9:
            case 11:
            default:
                if (i == 0) {
                    return node_getFirstChild(dom);
                }
                return dom.locale().findDomNthChild(dom, i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int _childNodes_getLength(Dom dom) {
        int iChildNodes_getLength;
        int domZeroOneChildren;
        Locale locale = dom.locale();
        Xobj xobj = (Xobj) dom;
        if (!xobj.isVacant() && (domZeroOneChildren = xobj.getDomZeroOneChildren()) < 2) {
            return domZeroOneChildren;
        }
        if (locale.noSync()) {
            return childNodes_getLength(dom);
        }
        synchronized (locale) {
            iChildNodes_getLength = childNodes_getLength(dom);
        }
        return iChildNodes_getLength;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int childNodes_getLength(Dom dom) {
        switch (dom.nodeType()) {
            case 3:
            case 4:
            case 7:
            case 8:
                return 0;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            case 9:
            case 11:
            default:
                Xobj xobj = (Xobj) dom;
                xobj.ensureOccupancy();
                int domZeroOneChildren = xobj.getDomZeroOneChildren();
                return domZeroOneChildren < 2 ? domZeroOneChildren : dom.locale().domLength(dom);
        }
    }

    public static String _element_getTagName(Dom dom) {
        return _node_getNodeName(dom);
    }

    public static Attr _element_getAttributeNode(Dom dom, String str) {
        return (Attr) _attributes_getNamedItem(dom, str);
    }

    public static Attr _element_getAttributeNodeNS(Dom dom, String str, String str2) {
        return (Attr) _attributes_getNamedItemNS(dom, str, str2);
    }

    public static Attr _element_setAttributeNode(Dom dom, Attr attr) {
        return (Attr) _attributes_setNamedItem(dom, attr);
    }

    public static Attr _element_setAttributeNodeNS(Dom dom, Attr attr) {
        return (Attr) _attributes_setNamedItemNS(dom, attr);
    }

    public static String _element_getAttribute(Dom dom, String str) {
        Node node_attributes_getNamedItem = _attributes_getNamedItem(dom, str);
        return node_attributes_getNamedItem == null ? "" : node_attributes_getNamedItem.getNodeValue();
    }

    public static String _element_getAttributeNS(Dom dom, String str, String str2) {
        Node node_attributes_getNamedItemNS = _attributes_getNamedItemNS(dom, str, str2);
        return node_attributes_getNamedItemNS == null ? "" : node_attributes_getNamedItemNS.getNodeValue();
    }

    public static boolean _element_hasAttribute(Dom dom, String str) {
        if (_attributes_getNamedItem(dom, str) != null) {
            return true;
        }
        return $assertionsDisabled;
    }

    public static boolean _element_hasAttributeNS(Dom dom, String str, String str2) {
        if (_attributes_getNamedItemNS(dom, str, str2) != null) {
            return true;
        }
        return $assertionsDisabled;
    }

    public static void _element_removeAttribute(Dom dom, String str) {
        try {
            _attributes_removeNamedItem(dom, str);
        } catch (NotFoundErr unused) {
        }
    }

    public static void _element_removeAttributeNS(Dom dom, String str, String str2) {
        try {
            _attributes_removeNamedItemNS(dom, str, str2);
        } catch (NotFoundErr unused) {
        }
    }

    public static Attr _element_removeAttributeNode(Dom dom, Attr attr) {
        if (attr == null) {
            throw new NotFoundErr("Attribute to remove is null");
        }
        if (attr.getOwnerElement() != dom) {
            throw new NotFoundErr("Attribute to remove does not belong to this element");
        }
        return (Attr) _attributes_removeNamedItem(dom, attr.getNodeName());
    }

    public static void _element_setAttribute(Dom dom, String str, String str2) {
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                element_setAttribute(dom, str, str2);
                return;
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                element_setAttribute(dom, str, str2);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
    }

    public static void element_setAttribute(Dom dom, String str, String str2) {
        Dom domAttributes_getNamedItem = attributes_getNamedItem(dom, str);
        if (domAttributes_getNamedItem == null) {
            domAttributes_getNamedItem = document_createAttribute(node_getOwnerDocument(dom), str);
            attributes_setNamedItem(dom, domAttributes_getNamedItem);
        }
        node_setNodeValue(domAttributes_getNamedItem, str2);
    }

    public static void _element_setAttributeNS(Dom dom, String str, String str2, String str3) {
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                element_setAttributeNS(dom, str, str2, str3);
                return;
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                element_setAttributeNS(dom, str, str2, str3);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
    }

    public static void element_setAttributeNS(Dom dom, String str, String str2, String str3) {
        validateQualifiedName(str2, str, true);
        QName qNameMakeQualifiedQName = dom.locale().makeQualifiedQName(str, str2);
        String localPart = qNameMakeQualifiedQName.getLocalPart();
        String strValidatePrefix = validatePrefix(qNameMakeQualifiedQName.getPrefix(), str, localPart, true);
        Dom domAttributes_getNamedItemNS = attributes_getNamedItemNS(dom, str, localPart);
        if (domAttributes_getNamedItemNS == null) {
            domAttributes_getNamedItemNS = document_createAttributeNS(node_getOwnerDocument(dom), str, localPart);
            attributes_setNamedItemNS(dom, domAttributes_getNamedItemNS);
        }
        node_setPrefix(domAttributes_getNamedItemNS, strValidatePrefix);
        node_setNodeValue(domAttributes_getNamedItemNS, str3);
    }

    public static NodeList _element_getElementsByTagName(Dom dom, String str) {
        NodeList nodeListElement_getElementsByTagName;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return element_getElementsByTagName(dom, str);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                nodeListElement_getElementsByTagName = element_getElementsByTagName(dom, str);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return nodeListElement_getElementsByTagName;
    }

    public static NodeList element_getElementsByTagName(Dom dom, String str) {
        return new ElementsByTagNameNodeList(dom, str);
    }

    public static NodeList _element_getElementsByTagNameNS(Dom dom, String str, String str2) {
        NodeList nodeListElement_getElementsByTagNameNS;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return element_getElementsByTagNameNS(dom, str, str2);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                nodeListElement_getElementsByTagNameNS = element_getElementsByTagNameNS(dom, str, str2);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return nodeListElement_getElementsByTagNameNS;
    }

    public static NodeList element_getElementsByTagNameNS(Dom dom, String str, String str2) {
        return new ElementsByTagNameNSNodeList(dom, str, str2);
    }

    public static int _attributes_getLength(Dom dom) {
        int iAttributes_getLength;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return attributes_getLength(dom);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                iAttributes_getLength = attributes_getLength(dom);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return iAttributes_getLength;
    }

    public static int attributes_getLength(Dom dom) {
        Cur curTempCur = dom.tempCur();
        int i = 0;
        while (curTempCur.toNextAttr()) {
            i++;
        }
        curTempCur.release();
        return i;
    }

    public static Node _attributes_setNamedItem(Dom dom, Node node) {
        Dom domAttributes_setNamedItem;
        Locale locale = dom.locale();
        if (node == null) {
            throw new IllegalArgumentException("Attr to set is null");
        }
        if (node instanceof Dom) {
            Dom dom2 = (Dom) node;
            if (dom2.locale() == locale) {
                if (locale.noSync()) {
                    locale.enter();
                    try {
                        domAttributes_setNamedItem = attributes_setNamedItem(dom, dom2);
                    } finally {
                        locale.exit();
                    }
                } else {
                    synchronized (locale) {
                        locale.enter();
                        try {
                            domAttributes_setNamedItem = attributes_setNamedItem(dom, dom2);
                            locale.exit();
                        } catch (Throwable th) {
                            locale.exit();
                            throw th;
                        }
                    }
                }
                return (Node) domAttributes_setNamedItem;
            }
        }
        throw new WrongDocumentErr("Attr to set is from another document");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Dom attributes_setNamedItem(Dom dom, Dom dom2) {
        if (attr_getOwnerElement(dom2) != null) {
            throw new InuseAttributeError();
        }
        if (dom2.nodeType() != 2) {
            throw new HierarchyRequestErr("Node is not an attribute");
        }
        String str_node_getNodeName = _node_getNodeName(dom2);
        Cur curTempCur = dom.tempCur();
        Dom dom3 = null;
        while (curTempCur.toNextAttr()) {
            Dom dom4 = curTempCur.getDom();
            if (_node_getNodeName(dom4).equals(str_node_getNodeName)) {
                if (dom3 == null) {
                    dom3 = dom4;
                } else {
                    removeNode(dom4);
                    curTempCur.toPrevAttr();
                }
            }
        }
        if (dom3 == null) {
            curTempCur.moveToDom(dom);
            curTempCur.next();
            Cur.moveNode((Xobj) dom2, curTempCur);
        } else {
            curTempCur.moveToDom(dom3);
            Cur.moveNode((Xobj) dom2, curTempCur);
            removeNode(dom3);
        }
        curTempCur.release();
        return dom3;
    }

    public static Node _attributes_getNamedItem(Dom dom, String str) {
        Dom domAttributes_getNamedItem;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domAttributes_getNamedItem = attributes_getNamedItem(dom, str);
            } finally {
                locale.exit();
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domAttributes_getNamedItem = attributes_getNamedItem(dom, str);
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            }
        }
        return (Node) domAttributes_getNamedItem;
    }

    public static Dom attributes_getNamedItem(Dom dom, String str) {
        Dom dom2;
        Cur curTempCur = dom.tempCur();
        while (curTempCur.toNextAttr()) {
            dom2 = curTempCur.getDom();
            if (_node_getNodeName(dom2).equals(str)) {
                curTempCur.release();
                return dom2;
            }
        }
        dom2 = null;
        curTempCur.release();
        return dom2;
    }

    public static Node _attributes_getNamedItemNS(Dom dom, String str, String str2) {
        Dom domAttributes_getNamedItemNS;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domAttributes_getNamedItemNS = attributes_getNamedItemNS(dom, str, str2);
            } finally {
                locale.exit();
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domAttributes_getNamedItemNS = attributes_getNamedItemNS(dom, str, str2);
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            }
        }
        return (Node) domAttributes_getNamedItemNS;
    }

    public static Dom attributes_getNamedItemNS(Dom dom, String str, String str2) {
        Dom dom2;
        if (str == null) {
            str = "";
        }
        Cur curTempCur = dom.tempCur();
        while (curTempCur.toNextAttr()) {
            dom2 = curTempCur.getDom();
            QName qName = dom2.getQName();
            if (qName.getNamespaceURI().equals(str) && qName.getLocalPart().equals(str2)) {
                curTempCur.release();
                return dom2;
            }
        }
        dom2 = null;
        curTempCur.release();
        return dom2;
    }

    public static Node _attributes_removeNamedItem(Dom dom, String str) {
        Dom domAttributes_removeNamedItem;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domAttributes_removeNamedItem = attributes_removeNamedItem(dom, str);
            } finally {
                locale.exit();
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domAttributes_removeNamedItem = attributes_removeNamedItem(dom, str);
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            }
        }
        return (Node) domAttributes_removeNamedItem;
    }

    public static Dom attributes_removeNamedItem(Dom dom, String str) {
        Cur curTempCur = dom.tempCur();
        Dom dom2 = null;
        while (curTempCur.toNextAttr()) {
            Dom dom3 = curTempCur.getDom();
            if (_node_getNodeName(dom3).equals(str)) {
                if (dom2 == null) {
                    dom2 = dom3;
                }
                if (((Xobj.AttrXobj) dom3).isId()) {
                    Dom domNode_getOwnerDocument = node_getOwnerDocument(dom3);
                    String strNode_getNodeValue = node_getNodeValue(dom3);
                    if (domNode_getOwnerDocument instanceof Xobj.DocumentXobj) {
                        ((Xobj.DocumentXobj) domNode_getOwnerDocument).removeIdElement(strNode_getNodeValue);
                    }
                }
                removeNode(dom3);
                curTempCur.toPrevAttr();
            }
        }
        curTempCur.release();
        if (dom2 != null) {
            return dom2;
        }
        throw new NotFoundErr("Named item not found: " + str);
    }

    public static Node _attributes_removeNamedItemNS(Dom dom, String str, String str2) {
        Dom domAttributes_removeNamedItemNS;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domAttributes_removeNamedItemNS = attributes_removeNamedItemNS(dom, str, str2);
            } finally {
                locale.exit();
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domAttributes_removeNamedItemNS = attributes_removeNamedItemNS(dom, str, str2);
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            }
        }
        return (Node) domAttributes_removeNamedItemNS;
    }

    public static Dom attributes_removeNamedItemNS(Dom dom, String str, String str2) {
        if (str == null) {
            str = "";
        }
        Cur curTempCur = dom.tempCur();
        Dom dom2 = null;
        while (curTempCur.toNextAttr()) {
            Dom dom3 = curTempCur.getDom();
            QName qName = dom3.getQName();
            if (qName.getNamespaceURI().equals(str) && qName.getLocalPart().equals(str2)) {
                if (dom2 == null) {
                    dom2 = dom3;
                }
                if (((Xobj.AttrXobj) dom3).isId()) {
                    Dom domNode_getOwnerDocument = node_getOwnerDocument(dom3);
                    String strNode_getNodeValue = node_getNodeValue(dom3);
                    if (domNode_getOwnerDocument instanceof Xobj.DocumentXobj) {
                        ((Xobj.DocumentXobj) domNode_getOwnerDocument).removeIdElement(strNode_getNodeValue);
                    }
                }
                removeNode(dom3);
                curTempCur.toPrevAttr();
            }
        }
        curTempCur.release();
        if (dom2 != null) {
            return dom2;
        }
        throw new NotFoundErr("Named item not found: uri=" + str + ", local=" + str2);
    }

    public static Node _attributes_setNamedItemNS(Dom dom, Node node) {
        Dom domAttributes_setNamedItemNS;
        Locale locale = dom.locale();
        if (node == null) {
            throw new IllegalArgumentException("Attr to set is null");
        }
        if (node instanceof Dom) {
            Dom dom2 = (Dom) node;
            if (dom2.locale() == locale) {
                if (locale.noSync()) {
                    locale.enter();
                    try {
                        domAttributes_setNamedItemNS = attributes_setNamedItemNS(dom, dom2);
                    } finally {
                        locale.exit();
                    }
                } else {
                    synchronized (locale) {
                        locale.enter();
                        try {
                            domAttributes_setNamedItemNS = attributes_setNamedItemNS(dom, dom2);
                            locale.exit();
                        } catch (Throwable th) {
                            locale.exit();
                            throw th;
                        }
                    }
                }
                return (Node) domAttributes_setNamedItemNS;
            }
        }
        throw new WrongDocumentErr("Attr to set is from another document");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Dom attributes_setNamedItemNS(Dom dom, Dom dom2) {
        Dom domAttr_getOwnerElement = attr_getOwnerElement(dom2);
        if (domAttr_getOwnerElement == dom) {
            return dom2;
        }
        if (domAttr_getOwnerElement != null) {
            throw new InuseAttributeError();
        }
        if (dom2.nodeType() != 2) {
            throw new HierarchyRequestErr("Node is not an attribute");
        }
        QName qName = dom2.getQName();
        Cur curTempCur = dom.tempCur();
        Dom dom3 = null;
        while (curTempCur.toNextAttr()) {
            Dom dom4 = curTempCur.getDom();
            if (dom4.getQName().equals(qName)) {
                if (dom3 == null) {
                    dom3 = dom4;
                } else {
                    removeNode(dom4);
                    curTempCur.toPrevAttr();
                }
            }
        }
        if (dom3 == null) {
            curTempCur.moveToDom(dom);
            curTempCur.next();
            Cur.moveNode((Xobj) dom2, curTempCur);
        } else {
            curTempCur.moveToDom(dom3);
            Cur.moveNode((Xobj) dom2, curTempCur);
            removeNode(dom3);
        }
        curTempCur.release();
        return dom3;
    }

    public static Node _attributes_item(Dom dom, int i) {
        Dom domAttributes_item;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domAttributes_item = attributes_item(dom, i);
            } finally {
                locale.exit();
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domAttributes_item = attributes_item(dom, i);
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            }
        }
        return (Node) domAttributes_item;
    }

    public static Dom attributes_item(Dom dom, int i) {
        Dom dom2 = null;
        if (i < 0) {
            return null;
        }
        Cur curTempCur = dom.tempCur();
        while (curTempCur.toNextAttr()) {
            int i2 = i - 1;
            if (i == 0) {
                dom2 = curTempCur.getDom();
                break;
            }
            i = i2;
        }
        curTempCur.release();
        return dom2;
    }

    public static String _processingInstruction_getData(Dom dom) {
        return _node_getNodeValue(dom);
    }

    public static String _processingInstruction_getTarget(Dom dom) {
        return _node_getNodeName(dom);
    }

    public static void _processingInstruction_setData(Dom dom, String str) {
        _node_setNodeValue(dom, str);
    }

    public static Element _attr_getOwnerElement(Dom dom) {
        Dom domAttr_getOwnerElement;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domAttr_getOwnerElement = attr_getOwnerElement(dom);
            } finally {
                locale.exit();
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domAttr_getOwnerElement = attr_getOwnerElement(dom);
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            }
        }
        return (Element) domAttr_getOwnerElement;
    }

    public static Dom attr_getOwnerElement(Dom dom) {
        Cur curTempCur = dom.tempCur();
        if (!curTempCur.toParentRaw()) {
            curTempCur.release();
            return null;
        }
        Dom dom2 = curTempCur.getDom();
        curTempCur.release();
        return dom2;
    }

    public static void _characterData_appendData(Dom dom, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        _node_setNodeValue(dom, _node_getNodeValue(dom) + str);
    }

    public static void _characterData_deleteData(Dom dom, int i, int i2) {
        String str_characterData_getData = _characterData_getData(dom);
        if (i < 0 || i > str_characterData_getData.length() || i2 < 0) {
            throw new IndexSizeError();
        }
        if (i + i2 > str_characterData_getData.length()) {
            i2 = str_characterData_getData.length() - i;
        }
        if (i2 > 0) {
            _characterData_setData(dom, str_characterData_getData.substring(0, i) + str_characterData_getData.substring(i + i2));
        }
    }

    public static String _characterData_getData(Dom dom) {
        return _node_getNodeValue(dom);
    }

    public static int _characterData_getLength(Dom dom) {
        return _characterData_getData(dom).length();
    }

    public static void _characterData_insertData(Dom dom, int i, String str) {
        String str_characterData_getData = _characterData_getData(dom);
        if (i < 0 || i > str_characterData_getData.length()) {
            throw new IndexSizeError();
        }
        if (str == null || str.length() <= 0) {
            return;
        }
        _characterData_setData(dom, str_characterData_getData.substring(0, i) + str + str_characterData_getData.substring(i));
    }

    public static void _characterData_replaceData(Dom dom, int i, int i2, String str) {
        String str_characterData_getData = _characterData_getData(dom);
        if (i < 0 || i > str_characterData_getData.length() || i2 < 0) {
            throw new IndexSizeError();
        }
        if (i + i2 > str_characterData_getData.length()) {
            i2 = str_characterData_getData.length() - i;
        }
        if (i2 > 0) {
            StringBuilder sbAppend = new StringBuilder().append(str_characterData_getData.substring(0, i));
            if (str == null) {
                str = "";
            }
            _characterData_setData(dom, sbAppend.append(str).append(str_characterData_getData.substring(i + i2)).toString());
        }
    }

    public static void _characterData_setData(Dom dom, String str) {
        _node_setNodeValue(dom, str);
    }

    public static String _characterData_substringData(Dom dom, int i, int i2) {
        String str_characterData_getData = _characterData_getData(dom);
        if (i < 0 || i > str_characterData_getData.length() || i2 < 0) {
            throw new IndexSizeError();
        }
        if (i + i2 > str_characterData_getData.length()) {
            i2 = str_characterData_getData.length() - i;
        }
        return str_characterData_getData.substring(i, i2 + i);
    }

    public static Text _text_splitText(Dom dom, int i) {
        String str_characterData_getData = _characterData_getData(dom);
        if (i < 0 || i > str_characterData_getData.length()) {
            throw new IndexSizeError();
        }
        _characterData_deleteData(dom, i, str_characterData_getData.length() - i);
        Dom dom2 = (Dom) _document_createTextNode(dom, str_characterData_getData.substring(i));
        Dom dom3 = (Dom) _node_getParentNode(dom);
        if (dom3 != null) {
            _node_insertBefore(dom3, (Text) dom2, _node_getNextSibling(dom));
            dom.locale().invalidateDomCaches(dom3);
        }
        return (Text) dom2;
    }

    public static String _text_getWholeText(Dom dom) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static boolean _text_isElementContentWhitespace(Dom dom) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static Text _text_replaceWholeText(Dom dom, String str) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static XMLStreamReader _getXmlStreamReader(Dom dom) {
        XMLStreamReader xmlStreamReader;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return getXmlStreamReader(dom);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                xmlStreamReader = getXmlStreamReader(dom);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return xmlStreamReader;
    }

    public static XMLStreamReader getXmlStreamReader(Dom dom) {
        XMLStreamReader xMLStreamReaderNewXmlStreamReader;
        switch (dom.nodeType()) {
            case 1:
            case 2:
            case 7:
            case 8:
            case 9:
            case 11:
                Cur curTempCur = dom.tempCur();
                XMLStreamReader xMLStreamReaderNewXmlStreamReader2 = Jsr173.newXmlStreamReader(curTempCur, null);
                curTempCur.release();
                return xMLStreamReaderNewXmlStreamReader2;
            case 3:
            case 4:
                CharNode charNode = (CharNode) dom;
                Cur curTempCur2 = charNode.tempCur();
                if (curTempCur2 == null) {
                    curTempCur2 = dom.locale().tempCur();
                    xMLStreamReaderNewXmlStreamReader = Jsr173.newXmlStreamReader(curTempCur2, charNode._src, charNode._off, charNode._cch);
                } else {
                    xMLStreamReaderNewXmlStreamReader = Jsr173.newXmlStreamReader(curTempCur2, curTempCur2.getChars(charNode._cch), curTempCur2._offSrc, curTempCur2._cchSrc);
                }
                curTempCur2.release();
                return xMLStreamReaderNewXmlStreamReader;
            case 5:
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            default:
                throw new RuntimeException("Unknown kind");
        }
    }

    public static XmlCursor _getXmlCursor(Dom dom) {
        XmlCursor xmlCursor;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return getXmlCursor(dom);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                xmlCursor = getXmlCursor(dom);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return xmlCursor;
    }

    public static XmlCursor getXmlCursor(Dom dom) {
        Cur curTempCur = dom.tempCur();
        Cursor cursor = new Cursor(curTempCur);
        curTempCur.release();
        return cursor;
    }

    public static XmlObject _getXmlObject(Dom dom) {
        XmlObject xmlObject;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return getXmlObject(dom);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                xmlObject = getXmlObject(dom);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return xmlObject;
    }

    public static XmlObject getXmlObject(Dom dom) {
        Cur curTempCur = dom.tempCur();
        XmlObject object = curTempCur.getObject();
        curTempCur.release();
        return object;
    }

    static abstract class CharNode implements Dom, Node, CharacterData {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        int _cch;
        private Locale _locale;
        CharNode _next;
        int _off;
        CharNode _prev;
        private Object _src;

        @Override // org.w3c.dom.Node
        public NamedNodeMap getAttributes() {
            return null;
        }

        @Override // org.w3c.dom.Node
        public Node getFirstChild() {
            return null;
        }

        @Override // org.w3c.dom.Node
        public Node getLastChild() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public QName getQName() {
            return null;
        }

        @Override // org.w3c.dom.Node
        public boolean hasAttributes() {
            return DomImpl.$assertionsDisabled;
        }

        @Override // org.w3c.dom.Node
        public boolean hasChildNodes() {
            return DomImpl.$assertionsDisabled;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public boolean nodeCanHavePrefixUri() {
            return DomImpl.$assertionsDisabled;
        }

        public CharNode(Locale locale) {
            this._locale = locale;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public Locale locale() {
            Locale locale = this._locale;
            return locale == null ? ((Dom) this._src).locale() : locale;
        }

        public void setChars(Object obj, int i, int i2) {
            if (this._locale == null) {
                this._locale = ((Dom) this._src).locale();
            }
            this._src = obj;
            this._off = i;
            this._cch = i2;
        }

        public Dom getDom() {
            Object obj = this._src;
            if (obj instanceof Dom) {
                return (Dom) obj;
            }
            return null;
        }

        public void setDom(Dom dom) {
            this._src = dom;
            this._locale = null;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public Cur tempCur() {
            if (!(this._src instanceof Dom)) {
                return null;
            }
            Cur curTempCur = locale().tempCur();
            curTempCur.moveToCharNode(this);
            return curTempCur;
        }

        private boolean isValid() {
            if (this._src instanceof Dom) {
                if (this._locale == null) {
                    return true;
                }
                return DomImpl.$assertionsDisabled;
            }
            if (this._locale == null) {
                return DomImpl.$assertionsDisabled;
            }
            return true;
        }

        public static boolean isOnList(CharNode charNode, CharNode charNode2) {
            while (charNode != null) {
                if (charNode == charNode2) {
                    return true;
                }
                charNode = charNode._next;
            }
            return DomImpl.$assertionsDisabled;
        }

        public static CharNode remove(CharNode charNode, CharNode charNode2) {
            if (charNode == charNode2) {
                charNode = charNode2._next;
            } else {
                charNode2._prev._next = charNode2._next;
            }
            CharNode charNode3 = charNode2._next;
            if (charNode3 != null) {
                charNode3._prev = charNode2._prev;
            }
            charNode2._next = null;
            charNode2._prev = null;
            return charNode;
        }

        public static CharNode insertNode(CharNode charNode, CharNode charNode2, CharNode charNode3) {
            CharNode charNode4;
            if (charNode != null) {
                if (charNode == charNode3) {
                    charNode._prev = charNode2;
                    charNode2._next = charNode;
                } else {
                    CharNode charNode5 = charNode;
                    while (true) {
                        charNode4 = charNode5._next;
                        if (charNode4 == charNode3) {
                            break;
                        }
                        charNode5 = charNode4;
                    }
                    charNode2._next = charNode4;
                    if (charNode4 != null) {
                        charNode5._next._prev = charNode2;
                    }
                    charNode2._prev = charNode5;
                    charNode5._next = charNode2;
                    return charNode;
                }
            }
            return charNode2;
        }

        public static CharNode appendNode(CharNode charNode, CharNode charNode2) {
            return insertNode(charNode, charNode2, null);
        }

        public static CharNode appendNodes(CharNode charNode, CharNode charNode2) {
            if (charNode == null) {
                return charNode2;
            }
            CharNode charNode3 = charNode;
            while (true) {
                CharNode charNode4 = charNode3._next;
                if (charNode4 == null) {
                    charNode3._next = charNode2;
                    charNode2._prev = charNode3;
                    return charNode;
                }
                charNode3 = charNode4;
            }
        }

        public static CharNode copyNodes(CharNode charNode, Object obj) {
            TextNode textNodeCreateCdataNode;
            TextNode textNode = null;
            TextNode textNode2 = null;
            while (charNode != null) {
                if (charNode instanceof TextNode) {
                    textNodeCreateCdataNode = charNode.locale().createTextNode();
                } else {
                    textNodeCreateCdataNode = charNode.locale().createCdataNode();
                }
                textNodeCreateCdataNode.setChars(obj, charNode._off, charNode._cch);
                if (textNode == null) {
                    textNode = textNodeCreateCdataNode;
                }
                if (textNode2 != null) {
                    textNode2._next = textNodeCreateCdataNode;
                    textNodeCreateCdataNode._prev = textNode2;
                }
                charNode = charNode._next;
                textNode2 = textNodeCreateCdataNode;
            }
            return textNode;
        }

        public boolean isNodeAftertext() {
            Xobj xobj = (Xobj) this._src;
            if (xobj._charNodesValue == null) {
                return true;
            }
            return xobj._charNodesAfter == null ? DomImpl.$assertionsDisabled : isOnList(xobj._charNodesAfter, this);
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public void dump(PrintStream printStream, Object obj) {
            Object obj2 = this._src;
            if (obj2 instanceof Dom) {
                ((Dom) obj2).dump(printStream, obj);
            } else {
                printStream.println("Lonely CharNode: \"" + CharUtil.getString(this._src, this._off, this._cch) + "\"");
            }
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public void dump(PrintStream printStream) {
            dump(printStream, this);
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public void dump() {
            dump(System.out);
        }

        @Override // org.w3c.dom.Node
        public Node appendChild(Node node) {
            return DomImpl._node_appendChild(this, node);
        }

        @Override // org.w3c.dom.Node
        public Node cloneNode(boolean z) {
            return DomImpl._node_cloneNode(this, z);
        }

        @Override // org.w3c.dom.Node
        public NodeList getChildNodes() {
            return DomImpl._emptyNodeList;
        }

        @Override // org.w3c.dom.Node
        public Node getParentNode() {
            return DomImpl._node_getParentNode(this);
        }

        @Override // org.w3c.dom.Node
        public Node removeChild(Node node) {
            return DomImpl._node_removeChild(this, node);
        }

        @Override // org.w3c.dom.Node
        public String getLocalName() {
            return DomImpl._node_getLocalName(this);
        }

        @Override // org.w3c.dom.Node
        public String getNamespaceURI() {
            return DomImpl._node_getNamespaceURI(this);
        }

        @Override // org.w3c.dom.Node
        public Node getNextSibling() {
            return DomImpl._node_getNextSibling(this);
        }

        @Override // org.w3c.dom.Node
        public String getNodeName() {
            return DomImpl._node_getNodeName(this);
        }

        @Override // org.w3c.dom.Node
        public short getNodeType() {
            return DomImpl._node_getNodeType(this);
        }

        @Override // org.w3c.dom.Node
        public String getNodeValue() {
            return DomImpl._node_getNodeValue(this);
        }

        @Override // org.w3c.dom.Node
        public Document getOwnerDocument() {
            return DomImpl._node_getOwnerDocument(this);
        }

        @Override // org.w3c.dom.Node
        public String getPrefix() {
            return DomImpl._node_getPrefix(this);
        }

        @Override // org.w3c.dom.Node
        public Node getPreviousSibling() {
            return DomImpl._node_getPreviousSibling(this);
        }

        @Override // org.w3c.dom.Node
        public Node insertBefore(Node node, Node node2) {
            return DomImpl._node_insertBefore(this, node, node2);
        }

        @Override // org.w3c.dom.Node
        public boolean isSupported(String str, String str2) {
            return DomImpl._node_isSupported(this, str, str2);
        }

        @Override // org.w3c.dom.Node
        public void normalize() {
            DomImpl._node_normalize(this);
        }

        @Override // org.w3c.dom.Node
        public Node replaceChild(Node node, Node node2) {
            return DomImpl._node_replaceChild(this, node, node2);
        }

        @Override // org.w3c.dom.Node
        public void setNodeValue(String str) {
            DomImpl._node_setNodeValue(this, str);
        }

        @Override // org.w3c.dom.Node
        public void setPrefix(String str) {
            DomImpl._node_setPrefix(this, str);
        }

        @Override // org.w3c.dom.Node
        public Object getUserData(String str) {
            return DomImpl._node_getUserData(this, str);
        }

        @Override // org.w3c.dom.Node
        public Object setUserData(String str, Object obj, UserDataHandler userDataHandler) {
            return DomImpl._node_setUserData(this, str, obj, userDataHandler);
        }

        @Override // org.w3c.dom.Node
        public Object getFeature(String str, String str2) {
            return DomImpl._node_getFeature(this, str, str2);
        }

        @Override // org.w3c.dom.Node
        public boolean isEqualNode(Node node) {
            return DomImpl._node_isEqualNode(this, node);
        }

        @Override // org.w3c.dom.Node
        public boolean isSameNode(Node node) {
            return DomImpl._node_isSameNode(this, node);
        }

        @Override // org.w3c.dom.Node
        public String lookupNamespaceURI(String str) {
            return DomImpl._node_lookupNamespaceURI(this, str);
        }

        @Override // org.w3c.dom.Node
        public String lookupPrefix(String str) {
            return DomImpl._node_lookupPrefix(this, str);
        }

        @Override // org.w3c.dom.Node
        public boolean isDefaultNamespace(String str) {
            return DomImpl._node_isDefaultNamespace(this, str);
        }

        @Override // org.w3c.dom.Node
        public void setTextContent(String str) {
            DomImpl._node_setTextContent(this, str);
        }

        @Override // org.w3c.dom.Node
        public String getTextContent() {
            return DomImpl._node_getTextContent(this);
        }

        @Override // org.w3c.dom.Node
        public short compareDocumentPosition(Node node) {
            return DomImpl._node_compareDocumentPosition(this, node);
        }

        @Override // org.w3c.dom.Node
        public String getBaseURI() {
            return DomImpl._node_getBaseURI(this);
        }

        @Override // org.w3c.dom.CharacterData
        public void appendData(String str) {
            DomImpl._characterData_appendData(this, str);
        }

        @Override // org.w3c.dom.CharacterData
        public void deleteData(int i, int i2) {
            DomImpl._characterData_deleteData(this, i, i2);
        }

        @Override // org.w3c.dom.CharacterData
        public String getData() {
            return DomImpl._characterData_getData(this);
        }

        @Override // org.w3c.dom.CharacterData
        public int getLength() {
            return DomImpl._characterData_getLength(this);
        }

        @Override // org.w3c.dom.CharacterData
        public void insertData(int i, String str) {
            DomImpl._characterData_insertData(this, i, str);
        }

        @Override // org.w3c.dom.CharacterData
        public void replaceData(int i, int i2, String str) {
            DomImpl._characterData_replaceData(this, i, i2, str);
        }

        @Override // org.w3c.dom.CharacterData
        public void setData(String str) {
            DomImpl._characterData_setData(this, str);
        }

        @Override // org.w3c.dom.CharacterData
        public String substringData(int i, int i2) {
            return DomImpl._characterData_substringData(this, i, i2);
        }
    }

    static class TextNode extends CharNode implements Text {
        public String name() {
            return "#text";
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public int nodeType() {
            return 3;
        }

        TextNode(Locale locale) {
            super(locale);
        }

        @Override // org.w3c.dom.Text
        public Text splitText(int i) {
            return DomImpl._text_splitText(this, i);
        }

        @Override // org.w3c.dom.Text
        public String getWholeText() {
            return DomImpl._text_getWholeText(this);
        }

        @Override // org.w3c.dom.Text
        public boolean isElementContentWhitespace() {
            return DomImpl._text_isElementContentWhitespace(this);
        }

        @Override // org.w3c.dom.Text
        public Text replaceWholeText(String str) {
            return DomImpl._text_replaceWholeText(this, str);
        }
    }

    static class CdataNode extends TextNode implements CDATASection {
        @Override // org.apache.xmlbeans.impl.store.DomImpl.TextNode
        public String name() {
            return "#cdata-section";
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.TextNode, org.apache.xmlbeans.impl.store.DomImpl.Dom
        public int nodeType() {
            return 4;
        }

        CdataNode(Locale locale) {
            super(locale);
        }
    }

    static class SaajTextNode extends TextNode implements org.apache.xmlbeans.impl.soap.Text {
        SaajTextNode(Locale locale) {
            super(locale);
        }

        @Override // org.apache.xmlbeans.impl.soap.Text
        public boolean isComment() {
            return DomImpl._soapText_isComment(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public void detachNode() {
            DomImpl._soapNode_detachNode(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public void recycleNode() {
            DomImpl._soapNode_recycleNode(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public String getValue() {
            return DomImpl._soapNode_getValue(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public void setValue(String str) {
            DomImpl._soapNode_setValue(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public SOAPElement getParentElement() {
            return DomImpl._soapNode_getParentElement(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public void setParentElement(SOAPElement sOAPElement) {
            DomImpl._soapNode_setParentElement(this, sOAPElement);
        }
    }

    static class SaajCdataNode extends CdataNode implements org.apache.xmlbeans.impl.soap.Text {
        public SaajCdataNode(Locale locale) {
            super(locale);
        }

        @Override // org.apache.xmlbeans.impl.soap.Text
        public boolean isComment() {
            return DomImpl._soapText_isComment(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public void detachNode() {
            DomImpl._soapNode_detachNode(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public void recycleNode() {
            DomImpl._soapNode_recycleNode(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public String getValue() {
            return DomImpl._soapNode_getValue(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public void setValue(String str) {
            DomImpl._soapNode_setValue(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public SOAPElement getParentElement() {
            return DomImpl._soapNode_getParentElement(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public void setParentElement(SOAPElement sOAPElement) {
            DomImpl._soapNode_setParentElement(this, sOAPElement);
        }
    }

    public static boolean _soapText_isComment(Dom dom) {
        boolean zSoapText_isComment;
        Locale locale = dom.locale();
        org.apache.xmlbeans.impl.soap.Text text = (org.apache.xmlbeans.impl.soap.Text) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapText_isComment(text);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                zSoapText_isComment = locale._saaj.soapText_isComment(text);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return zSoapText_isComment;
    }

    public static void _soapNode_detachNode(Dom dom) {
        Locale locale = dom.locale();
        org.apache.xmlbeans.impl.soap.Node node = (org.apache.xmlbeans.impl.soap.Node) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapNode_detachNode(node);
                return;
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                locale._saaj.soapNode_detachNode(node);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
    }

    public static void _soapNode_recycleNode(Dom dom) {
        Locale locale = dom.locale();
        org.apache.xmlbeans.impl.soap.Node node = (org.apache.xmlbeans.impl.soap.Node) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapNode_recycleNode(node);
                return;
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                locale._saaj.soapNode_recycleNode(node);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
    }

    public static String _soapNode_getValue(Dom dom) {
        String strSoapNode_getValue;
        Locale locale = dom.locale();
        org.apache.xmlbeans.impl.soap.Node node = (org.apache.xmlbeans.impl.soap.Node) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapNode_getValue(node);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                strSoapNode_getValue = locale._saaj.soapNode_getValue(node);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return strSoapNode_getValue;
    }

    public static void _soapNode_setValue(Dom dom, String str) {
        Locale locale = dom.locale();
        org.apache.xmlbeans.impl.soap.Node node = (org.apache.xmlbeans.impl.soap.Node) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapNode_setValue(node, str);
                return;
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                locale._saaj.soapNode_setValue(node, str);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
    }

    public static SOAPElement _soapNode_getParentElement(Dom dom) {
        SOAPElement sOAPElementSoapNode_getParentElement;
        Locale locale = dom.locale();
        org.apache.xmlbeans.impl.soap.Node node = (org.apache.xmlbeans.impl.soap.Node) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapNode_getParentElement(node);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                sOAPElementSoapNode_getParentElement = locale._saaj.soapNode_getParentElement(node);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return sOAPElementSoapNode_getParentElement;
    }

    public static void _soapNode_setParentElement(Dom dom, SOAPElement sOAPElement) {
        Locale locale = dom.locale();
        org.apache.xmlbeans.impl.soap.Node node = (org.apache.xmlbeans.impl.soap.Node) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapNode_setParentElement(node, sOAPElement);
                return;
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                locale._saaj.soapNode_setParentElement(node, sOAPElement);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
    }

    public static void _soapElement_removeContents(Dom dom) {
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapElement_removeContents(sOAPElement);
                return;
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                locale._saaj.soapElement_removeContents(sOAPElement);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
    }

    public static String _soapElement_getEncodingStyle(Dom dom) {
        String strSoapElement_getEncodingStyle;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getEncodingStyle(sOAPElement);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                strSoapElement_getEncodingStyle = locale._saaj.soapElement_getEncodingStyle(sOAPElement);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return strSoapElement_getEncodingStyle;
    }

    public static void _soapElement_setEncodingStyle(Dom dom, String str) {
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapElement_setEncodingStyle(sOAPElement, str);
                return;
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                locale._saaj.soapElement_setEncodingStyle(sOAPElement, str);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
    }

    public static boolean _soapElement_removeNamespaceDeclaration(Dom dom, String str) {
        boolean zSoapElement_removeNamespaceDeclaration;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_removeNamespaceDeclaration(sOAPElement, str);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                zSoapElement_removeNamespaceDeclaration = locale._saaj.soapElement_removeNamespaceDeclaration(sOAPElement, str);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return zSoapElement_removeNamespaceDeclaration;
    }

    public static Iterator _soapElement_getAllAttributes(Dom dom) {
        Iterator itSoapElement_getAllAttributes;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getAllAttributes(sOAPElement);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                itSoapElement_getAllAttributes = locale._saaj.soapElement_getAllAttributes(sOAPElement);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return itSoapElement_getAllAttributes;
    }

    public static Iterator _soapElement_getChildElements(Dom dom) {
        Iterator itSoapElement_getChildElements;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getChildElements(sOAPElement);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                itSoapElement_getChildElements = locale._saaj.soapElement_getChildElements(sOAPElement);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return itSoapElement_getChildElements;
    }

    public static Iterator _soapElement_getNamespacePrefixes(Dom dom) {
        Iterator itSoapElement_getNamespacePrefixes;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getNamespacePrefixes(sOAPElement);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                itSoapElement_getNamespacePrefixes = locale._saaj.soapElement_getNamespacePrefixes(sOAPElement);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return itSoapElement_getNamespacePrefixes;
    }

    public static SOAPElement _soapElement_addAttribute(Dom dom, Name name, String str) throws SOAPException {
        SOAPElement sOAPElementSoapElement_addAttribute;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_addAttribute(sOAPElement, name, str);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                sOAPElementSoapElement_addAttribute = locale._saaj.soapElement_addAttribute(sOAPElement, name, str);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return sOAPElementSoapElement_addAttribute;
    }

    public static SOAPElement _soapElement_addChildElement(Dom dom, SOAPElement sOAPElement) throws SOAPException {
        SOAPElement sOAPElementSoapElement_addChildElement;
        Locale locale = dom.locale();
        SOAPElement sOAPElement2 = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_addChildElement(sOAPElement2, sOAPElement);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                sOAPElementSoapElement_addChildElement = locale._saaj.soapElement_addChildElement(sOAPElement2, sOAPElement);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return sOAPElementSoapElement_addChildElement;
    }

    public static SOAPElement _soapElement_addChildElement(Dom dom, Name name) throws SOAPException {
        SOAPElement sOAPElementSoapElement_addChildElement;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_addChildElement(sOAPElement, name);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                sOAPElementSoapElement_addChildElement = locale._saaj.soapElement_addChildElement(sOAPElement, name);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return sOAPElementSoapElement_addChildElement;
    }

    public static SOAPElement _soapElement_addChildElement(Dom dom, String str) throws SOAPException {
        SOAPElement sOAPElementSoapElement_addChildElement;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_addChildElement(sOAPElement, str);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                sOAPElementSoapElement_addChildElement = locale._saaj.soapElement_addChildElement(sOAPElement, str);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return sOAPElementSoapElement_addChildElement;
    }

    public static SOAPElement _soapElement_addChildElement(Dom dom, String str, String str2) throws SOAPException {
        SOAPElement sOAPElementSoapElement_addChildElement;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_addChildElement(sOAPElement, str, str2);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                sOAPElementSoapElement_addChildElement = locale._saaj.soapElement_addChildElement(sOAPElement, str, str2);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return sOAPElementSoapElement_addChildElement;
    }

    public static SOAPElement _soapElement_addChildElement(Dom dom, String str, String str2, String str3) throws SOAPException {
        SOAPElement sOAPElementSoapElement_addChildElement;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_addChildElement(sOAPElement, str, str2, str3);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                sOAPElementSoapElement_addChildElement = locale._saaj.soapElement_addChildElement(sOAPElement, str, str2, str3);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return sOAPElementSoapElement_addChildElement;
    }

    public static SOAPElement _soapElement_addNamespaceDeclaration(Dom dom, String str, String str2) {
        SOAPElement sOAPElementSoapElement_addNamespaceDeclaration;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_addNamespaceDeclaration(sOAPElement, str, str2);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                sOAPElementSoapElement_addNamespaceDeclaration = locale._saaj.soapElement_addNamespaceDeclaration(sOAPElement, str, str2);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return sOAPElementSoapElement_addNamespaceDeclaration;
    }

    public static SOAPElement _soapElement_addTextNode(Dom dom, String str) {
        SOAPElement sOAPElementSoapElement_addTextNode;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_addTextNode(sOAPElement, str);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                sOAPElementSoapElement_addTextNode = locale._saaj.soapElement_addTextNode(sOAPElement, str);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return sOAPElementSoapElement_addTextNode;
    }

    public static String _soapElement_getAttributeValue(Dom dom, Name name) {
        String strSoapElement_getAttributeValue;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getAttributeValue(sOAPElement, name);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                strSoapElement_getAttributeValue = locale._saaj.soapElement_getAttributeValue(sOAPElement, name);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return strSoapElement_getAttributeValue;
    }

    public static Iterator _soapElement_getChildElements(Dom dom, Name name) {
        Iterator itSoapElement_getChildElements;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getChildElements(sOAPElement, name);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                itSoapElement_getChildElements = locale._saaj.soapElement_getChildElements(sOAPElement, name);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return itSoapElement_getChildElements;
    }

    public static Name _soapElement_getElementName(Dom dom) {
        Name nameSoapElement_getElementName;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getElementName(sOAPElement);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                nameSoapElement_getElementName = locale._saaj.soapElement_getElementName(sOAPElement);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return nameSoapElement_getElementName;
    }

    public static String _soapElement_getNamespaceURI(Dom dom, String str) {
        String strSoapElement_getNamespaceURI;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getNamespaceURI(sOAPElement, str);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                strSoapElement_getNamespaceURI = locale._saaj.soapElement_getNamespaceURI(sOAPElement, str);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return strSoapElement_getNamespaceURI;
    }

    public static Iterator _soapElement_getVisibleNamespacePrefixes(Dom dom) {
        Iterator itSoapElement_getVisibleNamespacePrefixes;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getVisibleNamespacePrefixes(sOAPElement);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                itSoapElement_getVisibleNamespacePrefixes = locale._saaj.soapElement_getVisibleNamespacePrefixes(sOAPElement);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return itSoapElement_getVisibleNamespacePrefixes;
    }

    public static boolean _soapElement_removeAttribute(Dom dom, Name name) {
        boolean zSoapElement_removeAttribute;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_removeAttribute(sOAPElement, name);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                zSoapElement_removeAttribute = locale._saaj.soapElement_removeAttribute(sOAPElement, name);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return zSoapElement_removeAttribute;
    }

    public static SOAPBody _soapEnvelope_addBody(Dom dom) throws SOAPException {
        SOAPBody sOAPBodySoapEnvelope_addBody;
        Locale locale = dom.locale();
        SOAPEnvelope sOAPEnvelope = (SOAPEnvelope) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapEnvelope_addBody(sOAPEnvelope);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                sOAPBodySoapEnvelope_addBody = locale._saaj.soapEnvelope_addBody(sOAPEnvelope);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return sOAPBodySoapEnvelope_addBody;
    }

    public static SOAPBody _soapEnvelope_getBody(Dom dom) throws SOAPException {
        SOAPBody sOAPBodySoapEnvelope_getBody;
        Locale locale = dom.locale();
        SOAPEnvelope sOAPEnvelope = (SOAPEnvelope) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapEnvelope_getBody(sOAPEnvelope);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                sOAPBodySoapEnvelope_getBody = locale._saaj.soapEnvelope_getBody(sOAPEnvelope);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return sOAPBodySoapEnvelope_getBody;
    }

    public static SOAPHeader _soapEnvelope_getHeader(Dom dom) throws SOAPException {
        SOAPHeader sOAPHeaderSoapEnvelope_getHeader;
        Locale locale = dom.locale();
        SOAPEnvelope sOAPEnvelope = (SOAPEnvelope) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapEnvelope_getHeader(sOAPEnvelope);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                sOAPHeaderSoapEnvelope_getHeader = locale._saaj.soapEnvelope_getHeader(sOAPEnvelope);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return sOAPHeaderSoapEnvelope_getHeader;
    }

    public static SOAPHeader _soapEnvelope_addHeader(Dom dom) throws SOAPException {
        SOAPHeader sOAPHeaderSoapEnvelope_addHeader;
        Locale locale = dom.locale();
        SOAPEnvelope sOAPEnvelope = (SOAPEnvelope) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapEnvelope_addHeader(sOAPEnvelope);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                sOAPHeaderSoapEnvelope_addHeader = locale._saaj.soapEnvelope_addHeader(sOAPEnvelope);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return sOAPHeaderSoapEnvelope_addHeader;
    }

    public static Name _soapEnvelope_createName(Dom dom, String str) {
        Name nameSoapEnvelope_createName;
        Locale locale = dom.locale();
        SOAPEnvelope sOAPEnvelope = (SOAPEnvelope) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapEnvelope_createName(sOAPEnvelope, str);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                nameSoapEnvelope_createName = locale._saaj.soapEnvelope_createName(sOAPEnvelope, str);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return nameSoapEnvelope_createName;
    }

    public static Name _soapEnvelope_createName(Dom dom, String str, String str2, String str3) {
        Name nameSoapEnvelope_createName;
        Locale locale = dom.locale();
        SOAPEnvelope sOAPEnvelope = (SOAPEnvelope) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapEnvelope_createName(sOAPEnvelope, str, str2, str3);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                nameSoapEnvelope_createName = locale._saaj.soapEnvelope_createName(sOAPEnvelope, str, str2, str3);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return nameSoapEnvelope_createName;
    }

    public static Iterator soapHeader_examineAllHeaderElements(Dom dom) {
        Iterator itSoapHeader_examineAllHeaderElements;
        Locale locale = dom.locale();
        SOAPHeader sOAPHeader = (SOAPHeader) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapHeader_examineAllHeaderElements(sOAPHeader);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                itSoapHeader_examineAllHeaderElements = locale._saaj.soapHeader_examineAllHeaderElements(sOAPHeader);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return itSoapHeader_examineAllHeaderElements;
    }

    public static Iterator soapHeader_extractAllHeaderElements(Dom dom) {
        Iterator itSoapHeader_extractAllHeaderElements;
        Locale locale = dom.locale();
        SOAPHeader sOAPHeader = (SOAPHeader) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapHeader_extractAllHeaderElements(sOAPHeader);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                itSoapHeader_extractAllHeaderElements = locale._saaj.soapHeader_extractAllHeaderElements(sOAPHeader);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return itSoapHeader_extractAllHeaderElements;
    }

    public static Iterator soapHeader_examineHeaderElements(Dom dom, String str) {
        Iterator itSoapHeader_examineHeaderElements;
        Locale locale = dom.locale();
        SOAPHeader sOAPHeader = (SOAPHeader) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapHeader_examineHeaderElements(sOAPHeader, str);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                itSoapHeader_examineHeaderElements = locale._saaj.soapHeader_examineHeaderElements(sOAPHeader, str);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return itSoapHeader_examineHeaderElements;
    }

    public static Iterator soapHeader_examineMustUnderstandHeaderElements(Dom dom, String str) {
        Iterator itSoapHeader_examineMustUnderstandHeaderElements;
        Locale locale = dom.locale();
        SOAPHeader sOAPHeader = (SOAPHeader) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapHeader_examineMustUnderstandHeaderElements(sOAPHeader, str);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                itSoapHeader_examineMustUnderstandHeaderElements = locale._saaj.soapHeader_examineMustUnderstandHeaderElements(sOAPHeader, str);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return itSoapHeader_examineMustUnderstandHeaderElements;
    }

    public static Iterator soapHeader_extractHeaderElements(Dom dom, String str) {
        Iterator itSoapHeader_extractHeaderElements;
        Locale locale = dom.locale();
        SOAPHeader sOAPHeader = (SOAPHeader) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapHeader_extractHeaderElements(sOAPHeader, str);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                itSoapHeader_extractHeaderElements = locale._saaj.soapHeader_extractHeaderElements(sOAPHeader, str);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return itSoapHeader_extractHeaderElements;
    }

    public static SOAPHeaderElement soapHeader_addHeaderElement(Dom dom, Name name) {
        SOAPHeaderElement sOAPHeaderElementSoapHeader_addHeaderElement;
        Locale locale = dom.locale();
        SOAPHeader sOAPHeader = (SOAPHeader) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapHeader_addHeaderElement(sOAPHeader, name);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                sOAPHeaderElementSoapHeader_addHeaderElement = locale._saaj.soapHeader_addHeaderElement(sOAPHeader, name);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return sOAPHeaderElementSoapHeader_addHeaderElement;
    }

    public static boolean soapBody_hasFault(Dom dom) {
        boolean zSoapBody_hasFault;
        Locale locale = dom.locale();
        SOAPBody sOAPBody = (SOAPBody) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapBody_hasFault(sOAPBody);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                zSoapBody_hasFault = locale._saaj.soapBody_hasFault(sOAPBody);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return zSoapBody_hasFault;
    }

    public static SOAPFault soapBody_addFault(Dom dom) throws SOAPException {
        SOAPFault sOAPFaultSoapBody_addFault;
        Locale locale = dom.locale();
        SOAPBody sOAPBody = (SOAPBody) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapBody_addFault(sOAPBody);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                sOAPFaultSoapBody_addFault = locale._saaj.soapBody_addFault(sOAPBody);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return sOAPFaultSoapBody_addFault;
    }

    public static SOAPFault soapBody_getFault(Dom dom) {
        SOAPFault sOAPFaultSoapBody_getFault;
        Locale locale = dom.locale();
        SOAPBody sOAPBody = (SOAPBody) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapBody_getFault(sOAPBody);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                sOAPFaultSoapBody_getFault = locale._saaj.soapBody_getFault(sOAPBody);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return sOAPFaultSoapBody_getFault;
    }

    public static SOAPBodyElement soapBody_addBodyElement(Dom dom, Name name) {
        SOAPBodyElement sOAPBodyElementSoapBody_addBodyElement;
        Locale locale = dom.locale();
        SOAPBody sOAPBody = (SOAPBody) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapBody_addBodyElement(sOAPBody, name);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                sOAPBodyElementSoapBody_addBodyElement = locale._saaj.soapBody_addBodyElement(sOAPBody, name);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return sOAPBodyElementSoapBody_addBodyElement;
    }

    public static SOAPBodyElement soapBody_addDocument(Dom dom, Document document) {
        SOAPBodyElement sOAPBodyElementSoapBody_addDocument;
        Locale locale = dom.locale();
        SOAPBody sOAPBody = (SOAPBody) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapBody_addDocument(sOAPBody, document);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                sOAPBodyElementSoapBody_addDocument = locale._saaj.soapBody_addDocument(sOAPBody, document);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return sOAPBodyElementSoapBody_addDocument;
    }

    public static SOAPFault soapBody_addFault(Dom dom, Name name, String str) throws SOAPException {
        SOAPFault sOAPFaultSoapBody_addFault;
        Locale locale = dom.locale();
        SOAPBody sOAPBody = (SOAPBody) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapBody_addFault(sOAPBody, name, str);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                sOAPFaultSoapBody_addFault = locale._saaj.soapBody_addFault(sOAPBody, name, str);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return sOAPFaultSoapBody_addFault;
    }

    public static SOAPFault soapBody_addFault(Dom dom, Name name, String str, java.util.Locale locale) throws SOAPException {
        SOAPFault sOAPFaultSoapBody_addFault;
        Locale locale2 = dom.locale();
        SOAPBody sOAPBody = (SOAPBody) dom;
        if (locale2.noSync()) {
            locale2.enter();
            try {
                return locale2._saaj.soapBody_addFault(sOAPBody, name, str, locale);
            } finally {
                locale2.exit();
            }
        }
        synchronized (locale2) {
            locale2.enter();
            try {
                sOAPFaultSoapBody_addFault = locale2._saaj.soapBody_addFault(sOAPBody, name, str, locale);
                locale2.exit();
            } catch (Throwable th) {
                locale2.exit();
                throw th;
            }
        }
        return sOAPFaultSoapBody_addFault;
    }

    public static void soapFault_setFaultString(Dom dom, String str) {
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapFault_setFaultString(sOAPFault, str);
                return;
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                locale._saaj.soapFault_setFaultString(sOAPFault, str);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
    }

    public static void soapFault_setFaultString(Dom dom, String str, java.util.Locale locale) {
        Locale locale2 = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale2.noSync()) {
            locale2.enter();
            try {
                locale2._saaj.soapFault_setFaultString(sOAPFault, str, locale);
                return;
            } finally {
                locale2.exit();
            }
        }
        synchronized (locale2) {
            locale2.enter();
            try {
                locale2._saaj.soapFault_setFaultString(sOAPFault, str, locale);
                locale2.exit();
            } catch (Throwable th) {
                locale2.exit();
                throw th;
            }
        }
    }

    public static void soapFault_setFaultCode(Dom dom, Name name) throws SOAPException {
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapFault_setFaultCode(sOAPFault, name);
                return;
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                locale._saaj.soapFault_setFaultCode(sOAPFault, name);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
    }

    public static void soapFault_setFaultActor(Dom dom, String str) {
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapFault_setFaultActor(sOAPFault, str);
                return;
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                locale._saaj.soapFault_setFaultActor(sOAPFault, str);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
    }

    public static String soapFault_getFaultActor(Dom dom) {
        String strSoapFault_getFaultActor;
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapFault_getFaultActor(sOAPFault);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                strSoapFault_getFaultActor = locale._saaj.soapFault_getFaultActor(sOAPFault);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return strSoapFault_getFaultActor;
    }

    public static String soapFault_getFaultCode(Dom dom) {
        String strSoapFault_getFaultCode;
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapFault_getFaultCode(sOAPFault);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                strSoapFault_getFaultCode = locale._saaj.soapFault_getFaultCode(sOAPFault);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return strSoapFault_getFaultCode;
    }

    public static void soapFault_setFaultCode(Dom dom, String str) throws SOAPException {
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapFault_setFaultCode(sOAPFault, str);
                return;
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                locale._saaj.soapFault_setFaultCode(sOAPFault, str);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
    }

    public static java.util.Locale soapFault_getFaultStringLocale(Dom dom) {
        java.util.Locale localeSoapFault_getFaultStringLocale;
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapFault_getFaultStringLocale(sOAPFault);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                localeSoapFault_getFaultStringLocale = locale._saaj.soapFault_getFaultStringLocale(sOAPFault);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return localeSoapFault_getFaultStringLocale;
    }

    public static Name soapFault_getFaultCodeAsName(Dom dom) {
        Name nameSoapFault_getFaultCodeAsName;
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapFault_getFaultCodeAsName(sOAPFault);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                nameSoapFault_getFaultCodeAsName = locale._saaj.soapFault_getFaultCodeAsName(sOAPFault);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return nameSoapFault_getFaultCodeAsName;
    }

    public static String soapFault_getFaultString(Dom dom) {
        String strSoapFault_getFaultString;
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapFault_getFaultString(sOAPFault);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                strSoapFault_getFaultString = locale._saaj.soapFault_getFaultString(sOAPFault);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return strSoapFault_getFaultString;
    }

    public static Detail soapFault_addDetail(Dom dom) throws SOAPException {
        Detail detailSoapFault_addDetail;
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapFault_addDetail(sOAPFault);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                detailSoapFault_addDetail = locale._saaj.soapFault_addDetail(sOAPFault);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return detailSoapFault_addDetail;
    }

    public static Detail soapFault_getDetail(Dom dom) {
        Detail detailSoapFault_getDetail;
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapFault_getDetail(sOAPFault);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                detailSoapFault_getDetail = locale._saaj.soapFault_getDetail(sOAPFault);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return detailSoapFault_getDetail;
    }

    public static void soapHeaderElement_setMustUnderstand(Dom dom, boolean z) {
        Locale locale = dom.locale();
        SOAPHeaderElement sOAPHeaderElement = (SOAPHeaderElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapHeaderElement_setMustUnderstand(sOAPHeaderElement, z);
                return;
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                locale._saaj.soapHeaderElement_setMustUnderstand(sOAPHeaderElement, z);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
    }

    public static boolean soapHeaderElement_getMustUnderstand(Dom dom) {
        boolean zSoapHeaderElement_getMustUnderstand;
        Locale locale = dom.locale();
        SOAPHeaderElement sOAPHeaderElement = (SOAPHeaderElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapHeaderElement_getMustUnderstand(sOAPHeaderElement);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                zSoapHeaderElement_getMustUnderstand = locale._saaj.soapHeaderElement_getMustUnderstand(sOAPHeaderElement);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return zSoapHeaderElement_getMustUnderstand;
    }

    public static void soapHeaderElement_setActor(Dom dom, String str) {
        Locale locale = dom.locale();
        SOAPHeaderElement sOAPHeaderElement = (SOAPHeaderElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapHeaderElement_setActor(sOAPHeaderElement, str);
                return;
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                locale._saaj.soapHeaderElement_setActor(sOAPHeaderElement, str);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
    }

    public static String soapHeaderElement_getActor(Dom dom) {
        String strSoapHeaderElement_getActor;
        Locale locale = dom.locale();
        SOAPHeaderElement sOAPHeaderElement = (SOAPHeaderElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapHeaderElement_getActor(sOAPHeaderElement);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                strSoapHeaderElement_getActor = locale._saaj.soapHeaderElement_getActor(sOAPHeaderElement);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return strSoapHeaderElement_getActor;
    }

    public static DetailEntry detail_addDetailEntry(Dom dom, Name name) {
        DetailEntry detailEntryDetail_addDetailEntry;
        Locale locale = dom.locale();
        Detail detail = (Detail) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.detail_addDetailEntry(detail, name);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                detailEntryDetail_addDetailEntry = locale._saaj.detail_addDetailEntry(detail, name);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return detailEntryDetail_addDetailEntry;
    }

    public static Iterator detail_getDetailEntries(Dom dom) {
        Iterator itDetail_getDetailEntries;
        Locale locale = dom.locale();
        Detail detail = (Detail) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.detail_getDetailEntries(detail);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                itDetail_getDetailEntries = locale._saaj.detail_getDetailEntries(detail);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return itDetail_getDetailEntries;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void _soapPart_removeAllMimeHeaders(Dom dom) {
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapPart_removeAllMimeHeaders(sOAPPart);
                return;
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                locale._saaj.soapPart_removeAllMimeHeaders(sOAPPart);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void _soapPart_removeMimeHeader(Dom dom, String str) {
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapPart_removeMimeHeader(sOAPPart, str);
                return;
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                locale._saaj.soapPart_removeMimeHeader(sOAPPart, str);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Iterator _soapPart_getAllMimeHeaders(Dom dom) {
        Iterator itSoapPart_getAllMimeHeaders;
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapPart_getAllMimeHeaders(sOAPPart);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                itSoapPart_getAllMimeHeaders = locale._saaj.soapPart_getAllMimeHeaders(sOAPPart);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return itSoapPart_getAllMimeHeaders;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static SOAPEnvelope _soapPart_getEnvelope(Dom dom) {
        SOAPEnvelope sOAPEnvelopeSoapPart_getEnvelope;
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapPart_getEnvelope(sOAPPart);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                sOAPEnvelopeSoapPart_getEnvelope = locale._saaj.soapPart_getEnvelope(sOAPPart);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return sOAPEnvelopeSoapPart_getEnvelope;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Source _soapPart_getContent(Dom dom) {
        Source sourceSoapPart_getContent;
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapPart_getContent(sOAPPart);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                sourceSoapPart_getContent = locale._saaj.soapPart_getContent(sOAPPart);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return sourceSoapPart_getContent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void _soapPart_setContent(Dom dom, Source source) {
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapPart_setContent(sOAPPart, source);
                return;
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                locale._saaj.soapPart_setContent(sOAPPart, source);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String[] _soapPart_getMimeHeader(Dom dom, String str) {
        String[] strArrSoapPart_getMimeHeader;
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapPart_getMimeHeader(sOAPPart, str);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                strArrSoapPart_getMimeHeader = locale._saaj.soapPart_getMimeHeader(sOAPPart, str);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return strArrSoapPart_getMimeHeader;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void _soapPart_addMimeHeader(Dom dom, String str, String str2) {
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapPart_addMimeHeader(sOAPPart, str, str2);
                return;
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                locale._saaj.soapPart_addMimeHeader(sOAPPart, str, str2);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void _soapPart_setMimeHeader(Dom dom, String str, String str2) {
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapPart_setMimeHeader(sOAPPart, str, str2);
                return;
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                locale._saaj.soapPart_setMimeHeader(sOAPPart, str, str2);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Iterator _soapPart_getMatchingMimeHeaders(Dom dom, String[] strArr) {
        Iterator itSoapPart_getMatchingMimeHeaders;
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapPart_getMatchingMimeHeaders(sOAPPart, strArr);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                itSoapPart_getMatchingMimeHeaders = locale._saaj.soapPart_getMatchingMimeHeaders(sOAPPart, strArr);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return itSoapPart_getMatchingMimeHeaders;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Iterator _soapPart_getNonMatchingMimeHeaders(Dom dom, String[] strArr) {
        Iterator itSoapPart_getNonMatchingMimeHeaders;
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapPart_getNonMatchingMimeHeaders(sOAPPart, strArr);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                itSoapPart_getNonMatchingMimeHeaders = locale._saaj.soapPart_getNonMatchingMimeHeaders(sOAPPart, strArr);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return itSoapPart_getNonMatchingMimeHeaders;
    }

    private static class SaajData {
        Object _obj;

        private SaajData() {
        }
    }

    public static void saajCallback_setSaajData(Dom dom, Object obj) {
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                impl_saajCallback_setSaajData(dom, obj);
                return;
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                impl_saajCallback_setSaajData(dom, obj);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void impl_saajCallback_setSaajData(Dom dom, Object obj) {
        Cur curTempCur = dom.locale().tempCur();
        curTempCur.moveToDom(dom);
        SaajData saajData = null;
        Object[] objArr = 0;
        if (obj != null) {
            SaajData saajData2 = (SaajData) curTempCur.getBookmark(SaajData.class);
            if (saajData2 == null) {
                saajData2 = new SaajData();
            }
            saajData = saajData2;
            saajData._obj = obj;
        }
        curTempCur.setBookmark(SaajData.class, saajData);
        curTempCur.release();
    }

    public static Object saajCallback_getSaajData(Dom dom) {
        Object objImpl_saajCallback_getSaajData;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return impl_saajCallback_getSaajData(dom);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                objImpl_saajCallback_getSaajData = impl_saajCallback_getSaajData(dom);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return objImpl_saajCallback_getSaajData;
    }

    public static Object impl_saajCallback_getSaajData(Dom dom) {
        Cur curTempCur = dom.locale().tempCur();
        curTempCur.moveToDom(dom);
        SaajData saajData = (SaajData) curTempCur.getBookmark(SaajData.class);
        Object obj = saajData == null ? null : saajData._obj;
        curTempCur.release();
        return obj;
    }

    public static Element saajCallback_createSoapElement(Dom dom, QName qName, QName qName2) {
        Dom domImpl_saajCallback_createSoapElement;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domImpl_saajCallback_createSoapElement = impl_saajCallback_createSoapElement(dom, qName, qName2);
            } finally {
                locale.exit();
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domImpl_saajCallback_createSoapElement = impl_saajCallback_createSoapElement(dom, qName, qName2);
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            }
        }
        return (Element) domImpl_saajCallback_createSoapElement;
    }

    public static Dom impl_saajCallback_createSoapElement(Dom dom, QName qName, QName qName2) {
        Cur curTempCur = dom.locale().tempCur();
        curTempCur.createElement(qName, qName2);
        Dom dom2 = curTempCur.getDom();
        curTempCur.release();
        return dom2;
    }

    public static Element saajCallback_importSoapElement(Dom dom, Element element, boolean z, QName qName) {
        Dom domImpl_saajCallback_importSoapElement;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                domImpl_saajCallback_importSoapElement = impl_saajCallback_importSoapElement(dom, element, z, qName);
            } finally {
                locale.exit();
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    domImpl_saajCallback_importSoapElement = impl_saajCallback_importSoapElement(dom, element, z, qName);
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            }
        }
        return (Element) domImpl_saajCallback_importSoapElement;
    }

    public static Dom impl_saajCallback_importSoapElement(Dom dom, Element element, boolean z, QName qName) {
        throw new RuntimeException("Not impl");
    }

    public static Text saajCallback_ensureSoapTextNode(Dom dom) {
        Text textImpl_saajCallback_ensureSoapTextNode;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return impl_saajCallback_ensureSoapTextNode(dom);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                textImpl_saajCallback_ensureSoapTextNode = impl_saajCallback_ensureSoapTextNode(dom);
                locale.exit();
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        return textImpl_saajCallback_ensureSoapTextNode;
    }
}
