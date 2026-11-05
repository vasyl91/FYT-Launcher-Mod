package org.apache.xmlbeans.impl.validator;

import java.util.AbstractCollection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XMLStreamValidationException;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.GenericXmlInputStream;
import org.apache.xmlbeans.impl.common.ValidatorListener;
import org.apache.xmlbeans.impl.common.XMLNameHelper;
import org.apache.xmlbeans.impl.common.XmlWhitespace;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;
import org.apache.xmlbeans.xml.stream.Attribute;
import org.apache.xmlbeans.xml.stream.AttributeIterator;
import org.apache.xmlbeans.xml.stream.CharacterData;
import org.apache.xmlbeans.xml.stream.StartElement;
import org.apache.xmlbeans.xml.stream.XMLEvent;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLName;
import org.apache.xmlbeans.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class ValidatingXMLInputStream extends GenericXmlInputStream implements ValidatorListener.Event {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private XMLStreamValidationException _exception;
    private boolean _finished;
    private XMLName _name;
    private XMLInputStream _source;
    private StartElement _startElement;
    private StringBuffer _text = new StringBuffer();
    private Validator _validator;
    private String _xsiLoc;
    private String _xsiNil;
    private String _xsiNoLoc;
    private String _xsiType;

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public XmlCursor getLocationAsCursor() {
        return null;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XMLStreamValidationException */
    public ValidatingXMLInputStream(XMLInputStream xMLInputStream, SchemaTypeLoader schemaTypeLoader, SchemaType schemaType, XmlOptions xmlOptions) throws XMLStreamException, XMLStreamValidationException {
        SchemaType schemaTypeFindDocumentType;
        this._source = xMLInputStream;
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        SchemaType schemaType2 = (SchemaType) xmlOptionsMaskNull.get("DOCUMENT_TYPE");
        schemaType = schemaType2 != null ? schemaType2 : schemaType;
        if (schemaType == null) {
            schemaType = BuiltinSchemaTypeSystem.ST_ANY_TYPE;
            XMLInputStream subStream = xMLInputStream.getSubStream();
            if (subStream.skip(2) && (schemaTypeFindDocumentType = schemaTypeLoader.findDocumentType(XMLNameHelper.getQName(subStream.next().getName()))) != null) {
                schemaType = schemaTypeFindDocumentType;
            }
            subStream.close();
        }
        this._validator = new Validator(schemaType, null, schemaTypeLoader, xmlOptionsMaskNull, new ExceptionXmlErrorListener());
        nextEvent(1);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XMLStreamValidationException */
    @Override // org.apache.xmlbeans.impl.common.GenericXmlInputStream
    protected XMLEvent nextEvent() throws XMLStreamException, XMLStreamValidationException {
        XMLEvent next = this._source.next();
        if (next == null) {
            if (!this._finished) {
                flushText();
                nextEvent(2);
                this._finished = true;
            }
        } else {
            int type = next.getType();
            if (type == 2) {
                StartElement startElement = (StartElement) next;
                flushText();
                this._startElement = startElement;
                AttributeIterator attributes = startElement.getAttributes();
                while (attributes.hasNext()) {
                    Attribute next2 = attributes.next();
                    XMLName name = next2.getName();
                    if ("http://www.w3.org/2001/XMLSchema-instance".equals(name.getNamespaceUri())) {
                        String localName = name.getLocalName();
                        if (localName.equals(JamXmlElements.TYPE)) {
                            this._xsiType = next2.getValue();
                        } else if (localName.equals("nil")) {
                            this._xsiNil = next2.getValue();
                        } else if (localName.equals("schemaLocation")) {
                            this._xsiLoc = next2.getValue();
                        } else if (localName.equals("noNamespaceSchemaLocation")) {
                            this._xsiNoLoc = next2.getValue();
                        }
                    }
                }
                this._name = next.getName();
                nextEvent(1);
                AttributeIterator attributes2 = startElement.getAttributes();
                while (attributes2.hasNext()) {
                    Attribute next3 = attributes2.next();
                    XMLName name2 = next3.getName();
                    if ("http://www.w3.org/2001/XMLSchema-instance".equals(name2.getNamespaceUri())) {
                        String localName2 = name2.getLocalName();
                        if (!localName2.equals(JamXmlElements.TYPE) && !localName2.equals("nil") && !localName2.equals("schemaLocation") && !localName2.equals("noNamespaceSchemaLocation")) {
                        }
                    }
                    this._text.append(next3.getValue());
                    this._name = next3.getName();
                    nextEvent(4);
                }
                clearText();
                this._startElement = null;
            } else if (type == 4) {
                flushText();
                nextEvent(2);
            } else if (type == 16 || type == 64) {
                CharacterData characterData = (CharacterData) next;
                if (characterData.hasContent()) {
                    this._text.append(characterData.getContent());
                }
            }
        }
        return next;
    }

    private void clearText() {
        StringBuffer stringBuffer = this._text;
        stringBuffer.delete(0, stringBuffer.length());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XMLStreamValidationException */
    private void flushText() throws XMLStreamException, XMLStreamValidationException {
        if (this._text.length() > 0) {
            nextEvent(3);
            clearText();
        }
    }

    @Override // org.apache.xmlbeans.impl.common.PrefixResolver
    public String getNamespaceForPrefix(String str) {
        Map namespaceMap;
        StartElement startElement = this._startElement;
        if (startElement == null || (namespaceMap = startElement.getNamespaceMap()) == null) {
            return null;
        }
        return (String) namespaceMap.get(str);
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public Location getLocation() {
        try {
            final org.apache.xmlbeans.xml.stream.Location location = this._source.peek().getLocation();
            if (location == null) {
                return null;
            }
            return new Location() { // from class: org.apache.xmlbeans.impl.validator.ValidatingXMLInputStream.1
                public int getCharacterOffset() {
                    return -1;
                }

                public int getLineNumber() {
                    return location.getLineNumber();
                }

                public int getColumnNumber() {
                    return location.getColumnNumber();
                }

                public String getPublicId() {
                    return location.getPublicId();
                }

                public String getSystemId() {
                    return location.getSystemId();
                }
            };
        } catch (XMLStreamException unused) {
            return null;
        }
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public String getXsiType() {
        return this._xsiType;
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public String getXsiNil() {
        return this._xsiNil;
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public String getXsiLoc() {
        return this._xsiLoc;
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public String getXsiNoLoc() {
        return this._xsiNoLoc;
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public QName getName() {
        return XMLNameHelper.getQName(this._name);
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public String getText() {
        return this._text.toString();
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public String getText(int i) {
        return XmlWhitespace.collapse(this._text.toString(), i);
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public boolean textIsWhitespace() {
        for (int i = 0; i < this._text.length(); i++) {
            char cCharAt = this._text.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != ' ') {
                return false;
            }
        }
        return true;
    }

    private final class ExceptionXmlErrorListener extends AbstractCollection {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return 0;
        }

        private ExceptionXmlErrorListener() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(Object obj) {
            ValidatingXMLInputStream.this._exception = new XMLStreamValidationException((XmlError) obj);
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return Collections.EMPTY_LIST.iterator();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XMLStreamValidationException */
    private void nextEvent(int i) throws XMLStreamException, XMLStreamValidationException {
        this._validator.nextEvent(i, this);
        XMLStreamValidationException xMLStreamValidationException = this._exception;
        if (xMLStreamValidationException != null) {
            throw xMLStreamValidationException;
        }
    }
}
