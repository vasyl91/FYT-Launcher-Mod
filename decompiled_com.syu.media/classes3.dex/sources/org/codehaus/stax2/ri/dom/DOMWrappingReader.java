package org.codehaus.stax2.ri.dom;

import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.dom.DOMSource;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.codehaus.stax2.AttributeInfo;
import org.codehaus.stax2.DTDInfo;
import org.codehaus.stax2.LocationInfo;
import org.codehaus.stax2.XMLStreamLocation2;
import org.codehaus.stax2.XMLStreamReader2;
import org.codehaus.stax2.ri.EmptyIterator;
import org.codehaus.stax2.ri.EmptyNamespaceContext;
import org.codehaus.stax2.ri.SingletonIterator;
import org.codehaus.stax2.ri.Stax2Util;
import org.codehaus.stax2.ri.typed.StringBase64Decoder;
import org.codehaus.stax2.ri.typed.ValueDecoderFactory;
import org.codehaus.stax2.typed.Base64Variant;
import org.codehaus.stax2.typed.Base64Variants;
import org.codehaus.stax2.typed.TypedArrayDecoder;
import org.codehaus.stax2.typed.TypedValueDecoder;
import org.codehaus.stax2.typed.TypedXMLStreamException;
import org.codehaus.stax2.validation.DTDValidationSchema;
import org.codehaus.stax2.validation.ValidationProblemHandler;
import org.codehaus.stax2.validation.ValidatorPair;
import org.codehaus.stax2.validation.XMLValidationSchema;
import org.codehaus.stax2.validation.XMLValidator;
import org.w3c.dom.Attr;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class DOMWrappingReader implements XMLStreamReader2, AttributeInfo, DTDInfo, LocationInfo, NamespaceContext, XMLStreamConstants {
    protected static final int ERR_STATE_NOT_ELEM = 2;
    protected static final int ERR_STATE_NOT_PI = 3;
    protected static final int ERR_STATE_NOT_START_ELEM = 1;
    protected static final int ERR_STATE_NOT_TEXTUAL = 4;
    protected static final int ERR_STATE_NOT_TEXTUAL_OR_ELEM = 6;
    protected static final int ERR_STATE_NOT_TEXTUAL_XXX = 5;
    protected static final int ERR_STATE_NO_LOCALNAME = 7;
    protected static final int INT_SPACE = 32;
    private static final int MASK_GET_ELEMENT_TEXT = 4688;
    private static final int MASK_GET_TEXT = 6768;
    private static final int MASK_GET_TEXT_XXX = 4208;
    protected static final int MASK_TYPED_ACCESS_BINARY = 4178;
    protected final boolean _cfgNsAware;
    protected String _coalescedText;
    protected final boolean _coalescing;
    protected Node _currNode;
    protected ValueDecoderFactory _decoderFactory;
    protected final Node _rootNode;
    protected final String _systemId;
    protected boolean _cfgInternNames = false;
    protected boolean _cfgInternNsURIs = false;
    protected int _currEvent = 7;
    protected int _depth = 0;
    protected Stax2Util.TextBuffer _textBuffer = new Stax2Util.TextBuffer();
    protected List<Node> _attrList = null;
    protected List<String> _nsDeclList = null;
    protected StringBase64Decoder _base64Decoder = null;

    public void close() throws XMLStreamException {
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public void closeCompletely() throws XMLStreamException {
    }

    public String getCharacterEncodingScheme() {
        return null;
    }

    @Override // org.codehaus.stax2.DTDInfo
    public String getDTDInternalSubset() {
        return null;
    }

    @Override // org.codehaus.stax2.LocationInfo
    public long getEndingByteOffset() throws XMLStreamException {
        return -1L;
    }

    @Override // org.codehaus.stax2.LocationInfo
    public long getEndingCharOffset() throws XMLStreamException {
        return -1L;
    }

    @Override // org.codehaus.stax2.AttributeInfo
    public int getIdAttributeIndex() {
        return -1;
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public final LocationInfo getLocationInfo() {
        return this;
    }

    public NamespaceContext getNamespaceContext() {
        return this;
    }

    @Override // org.codehaus.stax2.AttributeInfo
    public int getNotationAttributeIndex() {
        return -1;
    }

    @Override // org.codehaus.stax2.DTDInfo
    public Object getProcessedDTD() {
        return null;
    }

    @Override // org.codehaus.stax2.DTDInfo
    public DTDValidationSchema getProcessedDTDSchema() {
        return null;
    }

    public abstract Object getProperty(String str);

    @Override // org.codehaus.stax2.LocationInfo
    public long getStartingByteOffset() {
        return -1L;
    }

    @Override // org.codehaus.stax2.LocationInfo
    public long getStartingCharOffset() {
        return 0L;
    }

    public String getVersion() {
        return null;
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public boolean isEmptyElement() throws XMLStreamException {
        return false;
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public abstract boolean isPropertySupported(String str);

    public boolean isStandalone() {
        return false;
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public abstract boolean setProperty(String str, Object obj);

    @Override // org.codehaus.stax2.validation.Validatable
    public ValidationProblemHandler setValidationProblemHandler(ValidationProblemHandler validationProblemHandler) {
        return null;
    }

    public boolean standaloneSet() {
        return false;
    }

    @Override // org.codehaus.stax2.validation.Validatable
    public XMLValidator stopValidatingAgainst(XMLValidationSchema xMLValidationSchema) throws XMLStreamException {
        return null;
    }

    @Override // org.codehaus.stax2.validation.Validatable
    public XMLValidator stopValidatingAgainst(XMLValidator xMLValidator) throws XMLStreamException {
        return null;
    }

    protected abstract void throwStreamException(String str, Location location) throws XMLStreamException;

    @Override // org.codehaus.stax2.validation.Validatable
    public XMLValidator validateAgainst(XMLValidationSchema xMLValidationSchema) throws XMLStreamException {
        return null;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected DOMWrappingReader(DOMSource dOMSource, boolean z, boolean z2) throws XMLStreamException {
        Node node = dOMSource.getNode();
        if (node == null) {
            throw new IllegalArgumentException("Can not pass null Node for constructing a DOM-based XMLStreamReader");
        }
        this._cfgNsAware = z;
        this._coalescing = z2;
        this._systemId = dOMSource.getSystemId();
        short nodeType = node.getNodeType();
        if (nodeType != 1 && nodeType != 9 && nodeType != 11) {
            throw new XMLStreamException("Can not create an XMLStreamReader for a DOM node of type " + node.getClass());
        }
        this._currNode = node;
        this._rootNode = node;
    }

    protected void setInternNames(boolean z) {
        this._cfgInternNames = z;
    }

    protected void setInternNsURIs(boolean z) {
        this._cfgInternNsURIs = z;
    }

    public String getEncoding() {
        return getCharacterEncodingScheme();
    }

    @Override // org.codehaus.stax2.AttributeInfo
    public int getAttributeCount() {
        if (this._currEvent != 1) {
            reportWrongState(1);
        }
        if (this._attrList == null) {
            _calcNsAndAttrLists(true);
        }
        return this._attrList.size();
    }

    public String getAttributeLocalName(int i) {
        if (this._currEvent != 1) {
            reportWrongState(1);
        }
        if (this._attrList == null) {
            _calcNsAndAttrLists(true);
        }
        if (i >= this._attrList.size() || i < 0) {
            handleIllegalAttrIndex(i);
            return null;
        }
        return _internName(_safeGetLocalName((Attr) this._attrList.get(i)));
    }

    public QName getAttributeName(int i) {
        if (this._currEvent != 1) {
            reportWrongState(1);
        }
        if (this._attrList == null) {
            _calcNsAndAttrLists(true);
        }
        if (i >= this._attrList.size() || i < 0) {
            handleIllegalAttrIndex(i);
            return null;
        }
        Attr attr = (Attr) this._attrList.get(i);
        return _constructQName(attr.getNamespaceURI(), _safeGetLocalName(attr), attr.getPrefix());
    }

    public String getAttributeNamespace(int i) {
        if (this._currEvent != 1) {
            reportWrongState(1);
        }
        if (this._attrList == null) {
            _calcNsAndAttrLists(true);
        }
        if (i >= this._attrList.size() || i < 0) {
            handleIllegalAttrIndex(i);
            return null;
        }
        return _internNsURI(((Attr) this._attrList.get(i)).getNamespaceURI());
    }

    public String getAttributePrefix(int i) {
        if (this._currEvent != 1) {
            reportWrongState(1);
        }
        if (this._attrList == null) {
            _calcNsAndAttrLists(true);
        }
        if (i >= this._attrList.size() || i < 0) {
            handleIllegalAttrIndex(i);
            return null;
        }
        return _internName(((Attr) this._attrList.get(i)).getPrefix());
    }

    public String getAttributeType(int i) {
        if (this._currEvent != 1) {
            reportWrongState(1);
        }
        if (this._attrList == null) {
            _calcNsAndAttrLists(true);
        }
        if (i < this._attrList.size() && i >= 0) {
            return ValidatorPair.ATTR_TYPE_DEFAULT;
        }
        handleIllegalAttrIndex(i);
        return null;
    }

    public String getAttributeValue(int i) {
        if (this._currEvent != 1) {
            reportWrongState(1);
        }
        if (this._attrList == null) {
            _calcNsAndAttrLists(true);
        }
        if (i >= this._attrList.size() || i < 0) {
            handleIllegalAttrIndex(i);
            return null;
        }
        return ((Attr) this._attrList.get(i)).getValue();
    }

    public String getAttributeValue(String str, String str2) {
        if (this._currEvent != 1) {
            reportWrongState(1);
        }
        NamedNodeMap attributes = ((Element) this._currNode).getAttributes();
        if (str != null && str.length() == 0) {
            str = null;
        }
        Attr attr = (Attr) attributes.getNamedItemNS(str, str2);
        if (attr == null) {
            return null;
        }
        return attr.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public String getElementText() throws XMLStreamException {
        if (this._currEvent != 1) {
            reportParseProblem(1);
        }
        if (this._coalescing) {
            String text = null;
            while (true) {
                int next = next();
                if (next == 2) {
                    break;
                }
                if (next != 5 && next != 3) {
                    if (((1 << next) & MASK_GET_ELEMENT_TEXT) == 0) {
                        reportParseProblem(4);
                    }
                    if (text == null) {
                        text = getText();
                    } else {
                        text = text + getText();
                    }
                }
            }
            return text == null ? "" : text;
        }
        this._textBuffer.reset();
        while (true) {
            int next2 = next();
            if (next2 == 2) {
                return this._textBuffer.get();
            }
            if (next2 != 5 && next2 != 3) {
                if (((1 << next2) & MASK_GET_ELEMENT_TEXT) == 0) {
                    reportParseProblem(4);
                }
                this._textBuffer.append(getText());
            }
        }
    }

    public int getEventType() {
        return this._currEvent;
    }

    public String getLocalName() {
        int i = this._currEvent;
        if (i == 1 || i == 2) {
            return _internName(_safeGetLocalName(this._currNode));
        }
        if (i != 9) {
            reportWrongState(7);
        }
        return _internName(this._currNode.getNodeName());
    }

    @Override // org.codehaus.stax2.LocationInfo
    public final Location getLocation() {
        return getStartLocation();
    }

    public QName getName() {
        int i = this._currEvent;
        if (i != 1 && i != 2) {
            reportWrongState(1);
        }
        return _constructQName(this._currNode.getNamespaceURI(), _safeGetLocalName(this._currNode), this._currNode.getPrefix());
    }

    public int getNamespaceCount() {
        int i = this._currEvent;
        if (i != 1 && i != 2) {
            reportWrongState(2);
        }
        if (this._nsDeclList == null) {
            if (!this._cfgNsAware) {
                return 0;
            }
            _calcNsAndAttrLists(this._currEvent == 1);
        }
        return this._nsDeclList.size() / 2;
    }

    public String getNamespacePrefix(int i) {
        int i2 = this._currEvent;
        if (i2 != 1 && i2 != 2) {
            reportWrongState(2);
        }
        if (this._nsDeclList == null) {
            if (!this._cfgNsAware) {
                handleIllegalNsIndex(i);
            }
            _calcNsAndAttrLists(this._currEvent == 1);
        }
        if (i < 0 || i + i >= this._nsDeclList.size()) {
            handleIllegalNsIndex(i);
        }
        return this._nsDeclList.get(i + i);
    }

    public String getNamespaceURI() {
        int i = this._currEvent;
        if (i != 1 && i != 2) {
            reportWrongState(2);
        }
        return _internNsURI(this._currNode.getNamespaceURI());
    }

    public String getNamespaceURI(int i) {
        int i2 = this._currEvent;
        if (i2 != 1 && i2 != 2) {
            reportWrongState(2);
        }
        if (this._nsDeclList == null) {
            if (!this._cfgNsAware) {
                handleIllegalNsIndex(i);
            }
            _calcNsAndAttrLists(this._currEvent == 1);
        }
        if (i < 0 || i + i >= this._nsDeclList.size()) {
            handleIllegalNsIndex(i);
        }
        return this._nsDeclList.get(i + i + 1);
    }

    public String getPIData() {
        if (this._currEvent != 3) {
            reportWrongState(3);
        }
        return this._currNode.getNodeValue();
    }

    public String getPITarget() {
        if (this._currEvent != 3) {
            reportWrongState(3);
        }
        return _internName(this._currNode.getNodeName());
    }

    public String getPrefix() {
        int i = this._currEvent;
        if (i != 1 && i != 2) {
            reportWrongState(2);
        }
        return _internName(this._currNode.getPrefix());
    }

    public String getText() {
        String str = this._coalescedText;
        if (str != null) {
            return str;
        }
        if (((1 << this._currEvent) & MASK_GET_TEXT) == 0) {
            reportWrongState(4);
        }
        return this._currNode.getNodeValue();
    }

    public char[] getTextCharacters() {
        return getText().toCharArray();
    }

    public int getTextCharacters(int i, char[] cArr, int i2, int i3) {
        if (((1 << this._currEvent) & MASK_GET_TEXT_XXX) == 0) {
            reportWrongState(5);
        }
        String text = getText();
        if (i3 > text.length()) {
            i3 = text.length();
        }
        text.getChars(i, i + i3, cArr, i2);
        return i3;
    }

    public int getTextLength() {
        if (((1 << this._currEvent) & MASK_GET_TEXT_XXX) == 0) {
            reportWrongState(5);
        }
        return getText().length();
    }

    public int getTextStart() {
        if (((1 << this._currEvent) & MASK_GET_TEXT_XXX) != 0) {
            return 0;
        }
        reportWrongState(5);
        return 0;
    }

    public boolean hasName() {
        int i = this._currEvent;
        return i == 1 || i == 2;
    }

    public boolean hasNext() {
        return this._currEvent != 8;
    }

    public boolean hasText() {
        return ((1 << this._currEvent) & MASK_GET_TEXT) != 0;
    }

    public boolean isAttributeSpecified(int i) {
        if (this._currEvent != 1) {
            reportWrongState(1);
        }
        Attr attr = (Attr) ((Element) this._currNode).getAttributes().item(i);
        if (attr == null) {
            handleIllegalAttrIndex(i);
            return false;
        }
        return attr.getSpecified();
    }

    public boolean isCharacters() {
        return this._currEvent == 4;
    }

    public boolean isEndElement() {
        return this._currEvent == 2;
    }

    public boolean isStartElement() {
        return this._currEvent == 1;
    }

    public boolean isWhiteSpace() {
        int i = this._currEvent;
        if (i != 4 && i != 12) {
            return i == 6;
        }
        String text = getText();
        int length = text.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (text.charAt(i2) > ' ') {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void require(int i, String str, String str2) throws XMLStreamException {
        int i2 = this._currEvent;
        if (i2 != i && (i2 == 12 || i2 == 6)) {
            i2 = 4;
        }
        if (i != i2) {
            throwStreamException("Required type " + Stax2Util.eventTypeDesc(i) + ", current type " + Stax2Util.eventTypeDesc(i2));
        }
        if (str2 != null) {
            if (i2 != 1 && i2 != 2 && i2 != 9) {
                throwStreamException("Required a non-null local name, but current token not a START_ELEMENT, END_ELEMENT or ENTITY_REFERENCE (was " + Stax2Util.eventTypeDesc(this._currEvent) + ")");
            }
            String localName = getLocalName();
            if (localName != str2 && !localName.equals(str2)) {
                throwStreamException("Required local name '" + str2 + "'; current local name '" + localName + "'.");
            }
        }
        if (str != null) {
            if (i2 != 1 && i2 != 2) {
                throwStreamException("Required non-null NS URI, but current token not a START_ELEMENT or END_ELEMENT (was " + Stax2Util.eventTypeDesc(i2) + ")");
            }
            String namespaceURI = getNamespaceURI();
            if (str.length() == 0) {
                if (namespaceURI == null || namespaceURI.length() <= 0) {
                    return;
                }
                throwStreamException("Required empty namespace, instead have '" + namespaceURI + "'.");
                return;
            }
            if (str == namespaceURI || str.equals(namespaceURI)) {
                return;
            }
            throwStreamException("Required namespace '" + str + "'; have '" + namespaceURI + "'.");
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public int next() throws XMLStreamException {
        this._coalescedText = null;
        int i = this._currEvent;
        if (i == 1) {
            this._depth++;
            this._attrList = null;
            Node firstChild = this._currNode.getFirstChild();
            if (firstChild == null) {
                this._currEvent = 2;
                return 2;
            }
            this._nsDeclList = null;
            this._currNode = firstChild;
        } else {
            if (i == 2) {
                this._depth--;
                this._attrList = null;
                this._nsDeclList = null;
                if (this._currNode == this._rootNode) {
                    this._currEvent = 8;
                    return 8;
                }
            } else if (i == 7) {
                short nodeType = this._currNode.getNodeType();
                if (nodeType == 1) {
                    this._currEvent = 1;
                    return 1;
                }
                if (nodeType == 9 || nodeType == 11) {
                    Node firstChild2 = this._currNode.getFirstChild();
                    this._currNode = firstChild2;
                    if (firstChild2 == null) {
                        this._currEvent = 8;
                        return 8;
                    }
                } else {
                    throw new XMLStreamException("Internal error: unexpected DOM root node type " + ((int) this._currNode.getNodeType()) + " for node '" + this._currNode + "'");
                }
            } else if (i == 8) {
                throw new NoSuchElementException("Can not call next() after receiving END_DOCUMENT");
            }
            Node nextSibling = this._currNode.getNextSibling();
            if (nextSibling != null) {
                this._currNode = nextSibling;
            } else {
                Node parentNode = this._currNode.getParentNode();
                this._currNode = parentNode;
                short nodeType2 = parentNode.getNodeType();
                if (nodeType2 == 1) {
                    this._currEvent = 2;
                    return 2;
                }
                if (this._currNode != this._rootNode || (nodeType2 != 9 && nodeType2 != 11)) {
                    throw new XMLStreamException("Internal error: non-element parent node (" + ((int) nodeType2) + ") that is not the initial root node");
                }
                this._currEvent = 8;
                return 8;
            }
        }
        switch (this._currNode.getNodeType()) {
            case 1:
                this._currEvent = 1;
                break;
            case 2:
            case 6:
            case 12:
                throw new XMLStreamException("Internal error: unexpected DOM node type " + ((int) this._currNode.getNodeType()) + " (attr/entity/notation?), for node '" + this._currNode + "'");
            case 3:
                if (this._coalescing) {
                    coalesceText(4);
                } else {
                    this._currEvent = 4;
                }
                break;
            case 4:
                if (this._coalescing) {
                    coalesceText(12);
                } else {
                    this._currEvent = 12;
                }
                break;
            case 5:
                this._currEvent = 9;
                break;
            case 7:
                this._currEvent = 3;
                break;
            case 8:
                this._currEvent = 5;
                break;
            case 9:
            case 11:
            default:
                throw new XMLStreamException("Internal error: unrecognized DOM node type " + ((int) this._currNode.getNodeType()) + ", for node '" + this._currNode + "'");
            case 10:
                this._currEvent = 11;
                break;
        }
        return this._currEvent;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0008. Please report as an issue. */
    public int nextTag() throws XMLStreamException {
        while (true) {
            int next = next();
            if (next != 12) {
                switch (next) {
                    case 1:
                    case 2:
                        break;
                    case 3:
                    case 5:
                    case 6:
                        break;
                    case 4:
                        break;
                    default:
                        throwStreamException("Received event " + Stax2Util.eventTypeDesc(next) + ", instead of START_ELEMENT or END_ELEMENT.");
                        break;
                }
                return next;
            }
            if (!isWhiteSpace()) {
                throwStreamException("Received non-all-whitespace CHARACTERS or CDATA event in nextTag().");
                throwStreamException("Received event " + Stax2Util.eventTypeDesc(next) + ", instead of START_ELEMENT or END_ELEMENT.");
            }
        }
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getNamespaceURI(String str) {
        boolean z = str == null || str.length() == 0;
        for (Node parentNode = this._currNode; parentNode != null; parentNode = parentNode.getParentNode()) {
            NamedNodeMap attributes = parentNode.getAttributes();
            if (attributes != null) {
                int length = attributes.getLength();
                for (int i = 0; i < length; i++) {
                    Node nodeItem = attributes.item(i);
                    String prefix = nodeItem.getPrefix();
                    if (prefix == null || prefix.length() == 0) {
                        if (z && Sax2Dom.XMLNS_PREFIX.equals(nodeItem.getLocalName())) {
                            return nodeItem.getNodeValue();
                        }
                    } else if (!z && Sax2Dom.XMLNS_PREFIX.equals(prefix) && str.equals(nodeItem.getLocalName())) {
                        return nodeItem.getNodeValue();
                    }
                }
            }
        }
        return null;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getPrefix(String str) {
        if (str == null) {
            str = "";
        }
        for (Node parentNode = this._currNode; parentNode != null; parentNode = parentNode.getParentNode()) {
            NamedNodeMap attributes = parentNode.getAttributes();
            int length = attributes.getLength();
            for (int i = 0; i < length; i++) {
                Node nodeItem = attributes.item(i);
                String prefix = nodeItem.getPrefix();
                if (prefix == null || prefix.length() == 0) {
                    if (Sax2Dom.XMLNS_PREFIX.equals(nodeItem.getLocalName()) && str.equals(nodeItem.getNodeValue())) {
                        return "";
                    }
                } else if (Sax2Dom.XMLNS_PREFIX.equals(prefix) && str.equals(nodeItem.getNodeValue())) {
                    return nodeItem.getLocalName();
                }
            }
        }
        return null;
    }

    @Override // javax.xml.namespace.NamespaceContext
    public Iterator<String> getPrefixes(String str) {
        String prefix = getPrefix(str);
        if (prefix == null) {
            return EmptyIterator.getInstance();
        }
        return SingletonIterator.create(prefix);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public boolean getElementAsBoolean() throws XMLStreamException {
        ValueDecoderFactory.BooleanDecoder booleanDecoder = _decoderFactory().getBooleanDecoder();
        getElementAs(booleanDecoder);
        return booleanDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int getElementAsInt() throws XMLStreamException {
        ValueDecoderFactory.IntDecoder intDecoder = _decoderFactory().getIntDecoder();
        getElementAs(intDecoder);
        return intDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public long getElementAsLong() throws XMLStreamException {
        ValueDecoderFactory.LongDecoder longDecoder = _decoderFactory().getLongDecoder();
        getElementAs(longDecoder);
        return longDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public float getElementAsFloat() throws XMLStreamException {
        ValueDecoderFactory.FloatDecoder floatDecoder = _decoderFactory().getFloatDecoder();
        getElementAs(floatDecoder);
        return floatDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public double getElementAsDouble() throws XMLStreamException {
        ValueDecoderFactory.DoubleDecoder doubleDecoder = _decoderFactory().getDoubleDecoder();
        getElementAs(doubleDecoder);
        return doubleDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public BigInteger getElementAsInteger() throws XMLStreamException {
        ValueDecoderFactory.IntegerDecoder integerDecoder = _decoderFactory().getIntegerDecoder();
        getElementAs(integerDecoder);
        return integerDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public BigDecimal getElementAsDecimal() throws XMLStreamException {
        ValueDecoderFactory.DecimalDecoder decimalDecoder = _decoderFactory().getDecimalDecoder();
        getElementAs(decimalDecoder);
        return decimalDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public QName getElementAsQName() throws XMLStreamException {
        ValueDecoderFactory.QNameDecoder qNameDecoder = _decoderFactory().getQNameDecoder(getNamespaceContext());
        getElementAs(qNameDecoder);
        return qNameDecoder.getValue();
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public byte[] getElementAsBinary() throws XMLStreamException {
        return getElementAsBinary(Base64Variants.getDefaultVariant());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public byte[] getElementAsBinary(Base64Variant base64Variant) throws XMLStreamException {
        Stax2Util.ByteAggregator byteAggregator = _base64Decoder().getByteAggregator();
        byte[] bArrStartAggregation = byteAggregator.startAggregation();
        while (true) {
            int length = bArrStartAggregation.length;
            int i = 0;
            do {
                int elementAsBinary = readElementAsBinary(bArrStartAggregation, i, length, base64Variant);
                if (elementAsBinary < 1) {
                    return byteAggregator.aggregateAll(bArrStartAggregation, i);
                }
                i += elementAsBinary;
                length -= elementAsBinary;
            } while (length > 0);
            bArrStartAggregation = byteAggregator.addFullBlock(bArrStartAggregation);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public void getElementAs(TypedValueDecoder typedValueDecoder) throws XMLStreamException {
        String strTrimSpaces = Stax2Util.trimSpaces(getElementText());
        try {
            if (strTrimSpaces == null) {
                typedValueDecoder.handleEmptyValue();
            } else {
                typedValueDecoder.decode(strTrimSpaces);
            }
        } catch (IllegalArgumentException e) {
            throw _constructTypeException(e, strTrimSpaces);
        }
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int readElementAsIntArray(int[] iArr, int i, int i2) throws XMLStreamException {
        return readElementAsArray(_decoderFactory().getIntArrayDecoder(iArr, i, i2));
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int readElementAsLongArray(long[] jArr, int i, int i2) throws XMLStreamException {
        return readElementAsArray(_decoderFactory().getLongArrayDecoder(jArr, i, i2));
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int readElementAsFloatArray(float[] fArr, int i, int i2) throws XMLStreamException {
        return readElementAsArray(_decoderFactory().getFloatArrayDecoder(fArr, i, i2));
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int readElementAsDoubleArray(double[] dArr, int i, int i2) throws XMLStreamException {
        return readElementAsArray(_decoderFactory().getDoubleArrayDecoder(dArr, i, i2));
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int readElementAsArray(TypedArrayDecoder typedArrayDecoder) throws Throwable {
        int i = this._currEvent;
        if (i == 1) {
            Node firstChild = this._currNode.getFirstChild();
            if (firstChild == null) {
                this._currEvent = 2;
                return -1;
            }
            this._coalescedText = coalesceTypedText(firstChild);
            this._currEvent = 4;
            this._currNode = this._currNode.getLastChild();
        } else {
            if (i != 4 && i != 12) {
                if (i == 2) {
                    return -1;
                }
                reportWrongState(6);
            }
            if (this._coalescedText == null) {
                throw new IllegalStateException("First call to readElementAsArray() must be for a START_ELEMENT, not directly for a textual event");
            }
        }
        String str = this._coalescedText;
        int length = str.length();
        int i2 = 0;
        String strSubstring = null;
        int i3 = 0;
        loop0: do {
            if (i2 >= length) {
                break;
            }
            while (str.charAt(i2) <= ' ') {
                try {
                    try {
                        i2++;
                        if (i2 >= length) {
                            break loop0;
                        }
                    } catch (IllegalArgumentException e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
            }
            int i4 = i2 + 1;
            while (i4 < length) {
                try {
                    if (str.charAt(i4) <= ' ') {
                        break;
                    }
                    i4++;
                } catch (IllegalArgumentException e2) {
                    e = e2;
                    i2 = i4;
                    throw new TypedXMLStreamException(strSubstring, e.getMessage(), getLocation(), e);
                } catch (Throwable th2) {
                    th = th2;
                    i2 = i4;
                    this._coalescedText = length - i2 >= 1 ? str.substring(i2) : "";
                    throw th;
                }
            }
            i3++;
            strSubstring = str.substring(i2, i4);
            i2 = i4 + 1;
        } while (!typedArrayDecoder.decodeValue(strSubstring));
        this._coalescedText = length - i2 >= 1 ? str.substring(i2) : "";
        if (i3 >= 1) {
            return i3;
        }
        this._currEvent = 2;
        this._currNode = this._currNode.getParentNode();
        return -1;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private String coalesceTypedText(Node node) throws XMLStreamException {
        this._textBuffer.reset();
        this._attrList = null;
        while (node != null) {
            short nodeType = node.getNodeType();
            if (nodeType != 1) {
                if (nodeType != 3 && nodeType != 4) {
                    if (nodeType != 7 && nodeType != 8) {
                        throwStreamException("Unexpected DOM node type (" + ((int) node.getNodeType()) + ") when trying to decode Typed content");
                    }
                }
                node = node.getNextSibling();
            } else {
                throwStreamException("Element content can not contain child START_ELEMENT when using Typed Access methods");
            }
            this._textBuffer.append(node.getNodeValue());
            node = node.getNextSibling();
        }
        return this._textBuffer.get();
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int readElementAsBinary(byte[] bArr, int i, int i2) throws XMLStreamException {
        return readElementAsBinary(bArr, i, i2, Base64Variants.getDefaultVariant());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int readElementAsBinary(byte[] bArr, int i, int i2, Base64Variant base64Variant) throws XMLStreamException {
        int next;
        int i3 = i;
        int i4 = i2;
        if (bArr == null) {
            throw new IllegalArgumentException("resultBuffer is null");
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("Illegal offset (" + i3 + "), must be [0, " + bArr.length + "[");
        }
        if (i4 < 1 || i3 + i4 > bArr.length) {
            if (i4 == 0) {
                return 0;
            }
            throw new IllegalArgumentException("Illegal maxLength (" + i4 + "), has to be positive number, and offset+maxLength can not exceed" + bArr.length);
        }
        StringBase64Decoder stringBase64Decoder_base64Decoder = _base64Decoder();
        int i5 = this._currEvent;
        if (((1 << i5) & MASK_TYPED_ACCESS_BINARY) == 0) {
            if (i5 == 2) {
                if (!stringBase64Decoder_base64Decoder.hasData()) {
                    return -1;
                }
            } else {
                reportWrongState(6);
            }
        }
        if (i5 == 1) {
            while (true) {
                int next2 = next();
                if (next2 != 2) {
                    if (next2 != 5 && next2 != 3) {
                        if (((1 << next2) & MASK_GET_ELEMENT_TEXT) == 0) {
                            reportParseProblem(4);
                        }
                        stringBase64Decoder_base64Decoder.init(base64Variant, true, getText());
                        break;
                    }
                } else {
                    return -1;
                }
            }
        }
        int i6 = 0;
        while (true) {
            try {
                int iDecode = stringBase64Decoder_base64Decoder.decode(bArr, i3, i4);
                i3 += iDecode;
                i6 += iDecode;
                i4 -= iDecode;
                if (i4 < 1 || this._currEvent == 2) {
                    break;
                }
                while (true) {
                    next = next();
                    if (next != 5 && next != 3 && next != 6) {
                        break;
                    }
                }
                if (next == 2) {
                    int iEndOfContent = stringBase64Decoder_base64Decoder.endOfContent();
                    if (iEndOfContent < 0) {
                        throw _constructTypeException("Incomplete base64 triplet at the end of decoded content", "");
                    }
                    if (iEndOfContent <= 0) {
                        break;
                    }
                } else {
                    if (((1 << next) & MASK_GET_ELEMENT_TEXT) == 0) {
                        reportParseProblem(4);
                    }
                    stringBase64Decoder_base64Decoder.init(base64Variant, false, getText());
                }
            } catch (IllegalArgumentException e) {
                throw _constructTypeException(e, "");
            }
        }
        if (i6 > 0) {
            return i6;
        }
        return -1;
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int getAttributeIndex(String str, String str2) {
        return findAttributeIndex(str, str2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public boolean getAttributeAsBoolean(int i) throws XMLStreamException {
        ValueDecoderFactory.BooleanDecoder booleanDecoder = _decoderFactory().getBooleanDecoder();
        getAttributeAs(i, booleanDecoder);
        return booleanDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int getAttributeAsInt(int i) throws XMLStreamException {
        ValueDecoderFactory.IntDecoder intDecoder = _decoderFactory().getIntDecoder();
        getAttributeAs(i, intDecoder);
        return intDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public long getAttributeAsLong(int i) throws XMLStreamException {
        ValueDecoderFactory.LongDecoder longDecoder = _decoderFactory().getLongDecoder();
        getAttributeAs(i, longDecoder);
        return longDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public float getAttributeAsFloat(int i) throws XMLStreamException {
        ValueDecoderFactory.FloatDecoder floatDecoder = _decoderFactory().getFloatDecoder();
        getAttributeAs(i, floatDecoder);
        return floatDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public double getAttributeAsDouble(int i) throws XMLStreamException {
        ValueDecoderFactory.DoubleDecoder doubleDecoder = _decoderFactory().getDoubleDecoder();
        getAttributeAs(i, doubleDecoder);
        return doubleDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public BigInteger getAttributeAsInteger(int i) throws XMLStreamException {
        ValueDecoderFactory.IntegerDecoder integerDecoder = _decoderFactory().getIntegerDecoder();
        getAttributeAs(i, integerDecoder);
        return integerDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public BigDecimal getAttributeAsDecimal(int i) throws XMLStreamException {
        ValueDecoderFactory.DecimalDecoder decimalDecoder = _decoderFactory().getDecimalDecoder();
        getAttributeAs(i, decimalDecoder);
        return decimalDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public QName getAttributeAsQName(int i) throws XMLStreamException {
        ValueDecoderFactory.QNameDecoder qNameDecoder = _decoderFactory().getQNameDecoder(getNamespaceContext());
        getAttributeAs(i, qNameDecoder);
        return qNameDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public final void getAttributeAs(int i, TypedValueDecoder typedValueDecoder) throws XMLStreamException {
        String strTrimSpaces = Stax2Util.trimSpaces(getAttributeValue(i));
        try {
            if (strTrimSpaces == null) {
                typedValueDecoder.handleEmptyValue();
            } else {
                typedValueDecoder.decode(strTrimSpaces);
            }
        } catch (IllegalArgumentException e) {
            throw _constructTypeException(e, strTrimSpaces);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int[] getAttributeAsIntArray(int i) throws XMLStreamException {
        ValueDecoderFactory.IntArrayDecoder intArrayDecoder = _decoderFactory().getIntArrayDecoder();
        _getAttributeAsArray(intArrayDecoder, getAttributeValue(i));
        return intArrayDecoder.getValues();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public long[] getAttributeAsLongArray(int i) throws XMLStreamException {
        ValueDecoderFactory.LongArrayDecoder longArrayDecoder = _decoderFactory().getLongArrayDecoder();
        _getAttributeAsArray(longArrayDecoder, getAttributeValue(i));
        return longArrayDecoder.getValues();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public float[] getAttributeAsFloatArray(int i) throws XMLStreamException {
        ValueDecoderFactory.FloatArrayDecoder floatArrayDecoder = _decoderFactory().getFloatArrayDecoder();
        _getAttributeAsArray(floatArrayDecoder, getAttributeValue(i));
        return floatArrayDecoder.getValues();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public double[] getAttributeAsDoubleArray(int i) throws XMLStreamException {
        ValueDecoderFactory.DoubleArrayDecoder doubleArrayDecoder = _decoderFactory().getDoubleArrayDecoder();
        _getAttributeAsArray(doubleArrayDecoder, getAttributeValue(i));
        return doubleArrayDecoder.getValues();
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int getAttributeAsArray(int i, TypedArrayDecoder typedArrayDecoder) throws XMLStreamException {
        return _getAttributeAsArray(typedArrayDecoder, getAttributeValue(i));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected int _getAttributeAsArray(TypedArrayDecoder typedArrayDecoder, String str) throws XMLStreamException {
        int length = str.length();
        int i = 0;
        String strSubstring = null;
        int i2 = 0;
        loop0: while (i < length) {
            while (str.charAt(i) <= ' ') {
                try {
                    i++;
                    if (i >= length) {
                        break loop0;
                    }
                } catch (IllegalArgumentException e) {
                    throw new TypedXMLStreamException(strSubstring, e.getMessage(), getLocation(), e);
                }
            }
            int i3 = i + 1;
            while (i3 < length && str.charAt(i3) > ' ') {
                i3++;
            }
            int i4 = i3 + 1;
            strSubstring = str.substring(i, i3);
            i2++;
            if (typedArrayDecoder.decodeValue(strSubstring) && !checkExpand(typedArrayDecoder)) {
                break;
            }
            i = i4;
        }
        return i2;
    }

    private final boolean checkExpand(TypedArrayDecoder typedArrayDecoder) {
        if (!(typedArrayDecoder instanceof ValueDecoderFactory.BaseArrayDecoder)) {
            return false;
        }
        ((ValueDecoderFactory.BaseArrayDecoder) typedArrayDecoder).expand();
        return true;
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public byte[] getAttributeAsBinary(int i) throws XMLStreamException {
        return getAttributeAsBinary(i, Base64Variants.getDefaultVariant());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public byte[] getAttributeAsBinary(int i, Base64Variant base64Variant) throws XMLStreamException {
        String attributeValue = getAttributeValue(i);
        StringBase64Decoder stringBase64Decoder_base64Decoder = _base64Decoder();
        stringBase64Decoder_base64Decoder.init(base64Variant, true, attributeValue);
        try {
            return stringBase64Decoder_base64Decoder.decodeCompletely();
        } catch (IllegalArgumentException e) {
            throw _constructTypeException(e, attributeValue);
        }
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    @Deprecated
    public Object getFeature(String str) {
        throw new IllegalArgumentException("Unrecognized feature \"" + str + "\"");
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    @Deprecated
    public void setFeature(String str, Object obj) {
        throw new IllegalArgumentException("Unrecognized feature \"" + str + "\"");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.XMLStreamReader2
    public void skipElement() throws XMLStreamException {
        if (this._currEvent != 1) {
            reportWrongState(1);
        }
        int i = 1;
        while (true) {
            int next = next();
            if (next == 1) {
                i++;
            } else if (next == 2 && (i = i - 1) == 0) {
                return;
            }
        }
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public AttributeInfo getAttributeInfo() throws XMLStreamException {
        if (this._currEvent != 1) {
            reportWrongState(1);
        }
        return this;
    }

    @Override // org.codehaus.stax2.AttributeInfo
    public int findAttributeIndex(String str, String str2) {
        if (this._currEvent != 1) {
            reportWrongState(1);
        }
        NamedNodeMap attributes = ((Element) this._currNode).getAttributes();
        if (str != null && str.length() == 0) {
            str = null;
        }
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            Node nodeItem = attributes.item(i);
            if (str2.equals(_safeGetLocalName(nodeItem))) {
                String namespaceURI = nodeItem.getNamespaceURI();
                boolean z = namespaceURI == null || namespaceURI.length() == 0;
                if (str == null) {
                    if (z) {
                        return i;
                    }
                } else if (!z && str.equals(namespaceURI)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public DTDInfo getDTDInfo() throws XMLStreamException {
        if (this._currEvent != 11) {
            return null;
        }
        return this;
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public int getText(Writer writer, boolean z) throws XMLStreamException, IOException {
        String text = getText();
        writer.write(text);
        return text.length();
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public int getDepth() {
        return this._depth;
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public NamespaceContext getNonTransientNamespaceContext() {
        return EmptyNamespaceContext.getInstance();
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public String getPrefixedName() {
        int i = this._currEvent;
        if (i != 1 && i != 2) {
            if (i == 3) {
                return getPITarget();
            }
            if (i == 9) {
                return getLocalName();
            }
            if (i == 11) {
                return getDTDRootName();
            }
            throw new IllegalStateException("Current state (" + Stax2Util.eventTypeDesc(this._currEvent) + ") not START_ELEMENT, END_ELEMENT, ENTITY_REFERENCE, PROCESSING_INSTRUCTION or DTD");
        }
        String prefix = this._currNode.getPrefix();
        String str_safeGetLocalName = _safeGetLocalName(this._currNode);
        if (prefix == null) {
            return _internName(str_safeGetLocalName);
        }
        StringBuffer stringBuffer = new StringBuffer(str_safeGetLocalName.length() + 1 + prefix.length());
        stringBuffer.append(prefix);
        stringBuffer.append(NameUtil.COLON);
        stringBuffer.append(str_safeGetLocalName);
        return _internName(stringBuffer.toString());
    }

    @Override // org.codehaus.stax2.DTDInfo
    public String getDTDRootName() {
        if (this._currEvent == 11) {
            return _internName(((DocumentType) this._currNode).getName());
        }
        return null;
    }

    @Override // org.codehaus.stax2.DTDInfo
    public String getDTDPublicId() {
        if (this._currEvent == 11) {
            return ((DocumentType) this._currNode).getPublicId();
        }
        return null;
    }

    @Override // org.codehaus.stax2.DTDInfo
    public String getDTDSystemId() {
        if (this._currEvent == 11) {
            return ((DocumentType) this._currNode).getSystemId();
        }
        return null;
    }

    @Override // org.codehaus.stax2.LocationInfo
    public XMLStreamLocation2 getStartLocation() {
        return XMLStreamLocation2.NOT_AVAILABLE;
    }

    @Override // org.codehaus.stax2.LocationInfo
    public XMLStreamLocation2 getCurrentLocation() {
        return XMLStreamLocation2.NOT_AVAILABLE;
    }

    @Override // org.codehaus.stax2.LocationInfo
    public final XMLStreamLocation2 getEndLocation() throws XMLStreamException {
        return XMLStreamLocation2.NOT_AVAILABLE;
    }

    protected void coalesceText(int i) {
        short nodeType;
        this._textBuffer.reset();
        this._textBuffer.append(this._currNode.getNodeValue());
        while (true) {
            Node nextSibling = this._currNode.getNextSibling();
            if (nextSibling == null || !((nodeType = nextSibling.getNodeType()) == 3 || nodeType == 4)) {
                break;
            }
            this._currNode = nextSibling;
            this._textBuffer.append(nextSibling.getNodeValue());
        }
        this._coalescedText = this._textBuffer.get();
        this._currEvent = 4;
    }

    private QName _constructQName(String str, String str2, String str3) {
        return new QName(_internNsURI(str), _internName(str2), _internName(str3));
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0088  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.List<org.w3c.dom.Node>] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v9 */
    private void _calcNsAndAttrLists(boolean z) {
        String localName;
        NamedNodeMap attributes = this._currNode.getAttributes();
        int length = attributes.getLength();
        if (length == 0) {
            this._attrList = Collections.emptyList();
            this._nsDeclList = Collections.emptyList();
            return;
        }
        int i = 0;
        if (!this._cfgNsAware) {
            this._attrList = new ArrayList(length);
            while (i < length) {
                this._attrList.add(attributes.item(i));
                i++;
            }
            this._nsDeclList = Collections.emptyList();
            return;
        }
        ?? EmptyList = 0;
        ArrayList arrayList = null;
        while (i < length) {
            Node nodeItem = attributes.item(i);
            String prefix = nodeItem.getPrefix();
            if (prefix == null || prefix.length() == 0) {
                EmptyList = EmptyList;
                if (Sax2Dom.XMLNS_PREFIX.equals(nodeItem.getLocalName())) {
                    localName = null;
                    if (arrayList == null) {
                        EmptyList = EmptyList;
                        arrayList = new ArrayList((length - i) * 2);
                    }
                    EmptyList = EmptyList;
                    arrayList.add(_internName(localName));
                    arrayList.add(_internNsURI(nodeItem.getNodeValue()));
                } else if (z) {
                    if (EmptyList == 0) {
                        EmptyList = new ArrayList(length - i);
                    }
                    EmptyList.add(nodeItem);
                }
            } else if (Sax2Dom.XMLNS_PREFIX.equals(prefix)) {
                localName = nodeItem.getLocalName();
                if (arrayList == null) {
                    EmptyList = EmptyList;
                    arrayList = new ArrayList((length - i) * 2);
                }
                EmptyList = EmptyList;
                arrayList.add(_internName(localName));
                arrayList.add(_internNsURI(nodeItem.getNodeValue()));
            } else if (z) {
                if (EmptyList == 0) {
                    EmptyList = new ArrayList(length - i);
                }
                EmptyList.add(nodeItem);
            }
            i++;
            EmptyList = EmptyList;
            arrayList = arrayList;
        }
        if (EmptyList == 0) {
            EmptyList = Collections.emptyList();
        }
        this._attrList = EmptyList;
        List<String> listEmptyList = arrayList;
        if (arrayList == null) {
            listEmptyList = Collections.emptyList();
        }
        this._nsDeclList = listEmptyList;
    }

    private void handleIllegalAttrIndex(int i) {
        Element element = (Element) this._currNode;
        int length = element.getAttributes().getLength();
        throw new IllegalArgumentException("Illegal attribute index " + i + "; element <" + element.getNodeName() + "> has " + (length == 0 ? "no" : String.valueOf(length)) + " attributes");
    }

    private void handleIllegalNsIndex(int i) {
        throw new IllegalArgumentException("Illegal namespace declaration index " + i + " (has " + getNamespaceCount() + " ns declarations)");
    }

    private String _safeGetLocalName(Node node) {
        String localName = node.getLocalName();
        return localName == null ? node.getNodeName() : localName;
    }

    protected void reportWrongState(int i) {
        throw new IllegalStateException(findErrorDesc(i, this._currEvent));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportParseProblem(int i) throws XMLStreamException {
        throwStreamException(findErrorDesc(i, this._currEvent));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void throwStreamException(String str) throws XMLStreamException {
        throwStreamException(str, getErrorLocation());
    }

    protected Location getErrorLocation() {
        XMLStreamLocation2 currentLocation = getCurrentLocation();
        return currentLocation == null ? getLocation() : currentLocation;
    }

    protected TypedXMLStreamException _constructTypeException(IllegalArgumentException illegalArgumentException, String str) {
        String message = illegalArgumentException.getMessage();
        if (message == null) {
            message = "";
        }
        XMLStreamLocation2 startLocation = getStartLocation();
        if (startLocation == null) {
            return new TypedXMLStreamException(str, message, illegalArgumentException);
        }
        return new TypedXMLStreamException(str, message, startLocation);
    }

    protected TypedXMLStreamException _constructTypeException(String str, String str2) {
        XMLStreamLocation2 startLocation = getStartLocation();
        if (startLocation == null) {
            return new TypedXMLStreamException(str2, str);
        }
        return new TypedXMLStreamException(str2, str, startLocation);
    }

    protected ValueDecoderFactory _decoderFactory() {
        if (this._decoderFactory == null) {
            this._decoderFactory = new ValueDecoderFactory();
        }
        return this._decoderFactory;
    }

    protected StringBase64Decoder _base64Decoder() {
        if (this._base64Decoder == null) {
            this._base64Decoder = new StringBase64Decoder();
        }
        return this._base64Decoder;
    }

    protected String findErrorDesc(int i, int i2) {
        String strEventTypeDesc = Stax2Util.eventTypeDesc(i2);
        switch (i) {
            case 1:
                return "Current event " + strEventTypeDesc + ", needs to be START_ELEMENT";
            case 2:
                return "Current event " + strEventTypeDesc + ", needs to be START_ELEMENT or END_ELEMENT";
            case 3:
                return "Current event (" + strEventTypeDesc + ") needs to be PROCESSING_INSTRUCTION";
            case 4:
                return "Current event (" + strEventTypeDesc + ") not a textual event";
            case 5:
                return "Current event " + strEventTypeDesc + ", needs to be one of CHARACTERS, CDATA, SPACE or COMMENT";
            case 6:
                return "Current event (" + strEventTypeDesc + " not START_ELEMENT, END_ELEMENT, CHARACTERS or CDATA";
            case 7:
                return "Current event (" + strEventTypeDesc + ") has no local name";
            default:
                return "Internal error (unrecognized error type: " + i + ")";
        }
    }

    protected String _internName(String str) {
        if (str == null) {
            return "";
        }
        return this._cfgInternNames ? str.intern() : str;
    }

    protected String _internNsURI(String str) {
        if (str == null) {
            return "";
        }
        return this._cfgInternNsURIs ? str.intern() : str;
    }
}
