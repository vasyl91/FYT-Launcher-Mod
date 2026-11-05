package com.fasterxml.aalto.sax;

import chip.FinalChip;
import com.fasterxml.aalto.in.AttributeCollector;
import com.fasterxml.aalto.in.ByteSourceBootstrapper;
import com.fasterxml.aalto.in.CharSourceBootstrapper;
import com.fasterxml.aalto.in.ReaderConfig;
import com.fasterxml.aalto.in.XmlScanner;
import com.fasterxml.aalto.stax.InputFactoryImpl;
import com.fasterxml.aalto.util.URLUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Locale;
import javax.xml.parsers.SAXParser;
import javax.xml.stream.XMLStreamException;
import org.xml.sax.AttributeList;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.DocumentHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.HandlerBase;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.Attributes2;
import org.xml.sax.ext.DeclHandler;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.ext.Locator2;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
class SAXParserImpl extends SAXParser implements Parser, XMLReader, Attributes2, Locator2 {
    protected AttributeCollector _attrCollector;
    private int _attrCount;
    protected ContentHandler _contentHandler;
    private DeclHandler _declHandler;
    protected DTDHandler _dtdHandler;
    private EntityResolver _entityResolver;
    private ErrorHandler _errorHandler;
    private LexicalHandler _lexicalHandler;
    protected XmlScanner _scanner;
    final InputFactoryImpl _staxFactory;

    @Override // javax.xml.parsers.SAXParser
    public final Parser getParser() {
        return this;
    }

    @Override // javax.xml.parsers.SAXParser
    public final XMLReader getXMLReader() {
        return this;
    }

    @Override // org.xml.sax.ext.Attributes2
    public boolean isDeclared(int i) {
        return false;
    }

    @Override // org.xml.sax.ext.Attributes2
    public boolean isDeclared(String str) {
        return false;
    }

    @Override // org.xml.sax.ext.Attributes2
    public boolean isDeclared(String str, String str2) {
        return false;
    }

    @Override // javax.xml.parsers.SAXParser
    public boolean isNamespaceAware() {
        return true;
    }

    @Override // org.xml.sax.ext.Attributes2
    public boolean isSpecified(int i) {
        return true;
    }

    @Override // org.xml.sax.ext.Attributes2
    public boolean isSpecified(String str) {
        return true;
    }

    @Override // org.xml.sax.ext.Attributes2
    public boolean isSpecified(String str, String str2) {
        return true;
    }

    @Override // javax.xml.parsers.SAXParser
    public boolean isValidating() {
        return false;
    }

    @Override // org.xml.sax.Parser
    public void setLocale(Locale locale) {
    }

    SAXParserImpl(InputFactoryImpl inputFactoryImpl) {
        this._staxFactory = inputFactoryImpl;
    }

    @Override // javax.xml.parsers.SAXParser, org.xml.sax.XMLReader
    public Object getProperty(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        SAXProperty sAXPropertyFindStdProperty = SAXUtil.findStdProperty(str);
        if (sAXPropertyFindStdProperty != null) {
            int i = AnonymousClass1.$SwitchMap$com$fasterxml$aalto$sax$SAXProperty[sAXPropertyFindStdProperty.ordinal()];
            if (i == 1) {
                return this._declHandler;
            }
            if (i == 2) {
                return this._scanner.getConfig().getXmlDeclVersion();
            }
            if (i == 3) {
                return null;
            }
            if (i == 4) {
                return this._lexicalHandler;
            }
            if (i == 5) {
                return null;
            }
        }
        SAXUtil.reportUnknownProperty(str);
        return null;
    }

    @Override // javax.xml.parsers.SAXParser, org.xml.sax.XMLReader
    public void setProperty(String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException {
        SAXProperty sAXPropertyFindStdProperty = SAXUtil.findStdProperty(str);
        if (sAXPropertyFindStdProperty != null) {
            int i = AnonymousClass1.$SwitchMap$com$fasterxml$aalto$sax$SAXProperty[sAXPropertyFindStdProperty.ordinal()];
            if (i == 1) {
                this._declHandler = (DeclHandler) obj;
                return;
            }
            if (i == 2) {
                this._scanner.getConfig().setXmlVersion(obj == null ? null : String.valueOf(obj));
                return;
            } else {
                if (i == 3) {
                    return;
                }
                if (i == 4) {
                    this._lexicalHandler = (LexicalHandler) obj;
                    return;
                } else if (i == 5) {
                    return;
                }
            }
        }
        SAXUtil.reportUnknownFeature(str);
    }

    @Override // javax.xml.parsers.SAXParser
    public void parse(InputSource inputSource, HandlerBase handlerBase) throws SAXException, IOException {
        if (handlerBase != null) {
            if (this._contentHandler == null) {
                setDocumentHandler(handlerBase);
            }
            if (this._entityResolver == null) {
                setEntityResolver(handlerBase);
            }
            if (this._errorHandler == null) {
                setErrorHandler(handlerBase);
            }
            if (this._dtdHandler == null) {
                setDTDHandler(handlerBase);
            }
        }
        parse(inputSource);
    }

    @Override // javax.xml.parsers.SAXParser
    public void parse(InputSource inputSource, DefaultHandler defaultHandler) throws SAXException, IOException {
        if (defaultHandler != null) {
            if (this._contentHandler == null) {
                setContentHandler(defaultHandler);
            }
            if (this._entityResolver == null) {
                setEntityResolver(defaultHandler);
            }
            if (this._errorHandler == null) {
                setErrorHandler(defaultHandler);
            }
            if (this._dtdHandler == null) {
                setDTDHandler(defaultHandler);
            }
        }
        parse(inputSource);
    }

    @Override // org.xml.sax.XMLReader
    public ContentHandler getContentHandler() {
        return this._contentHandler;
    }

    @Override // org.xml.sax.XMLReader
    public DTDHandler getDTDHandler() {
        return this._dtdHandler;
    }

    @Override // org.xml.sax.XMLReader
    public EntityResolver getEntityResolver() {
        return this._entityResolver;
    }

    @Override // org.xml.sax.XMLReader
    public ErrorHandler getErrorHandler() {
        return this._errorHandler;
    }

    @Override // org.xml.sax.XMLReader
    public boolean getFeature(String str) throws SAXNotRecognizedException {
        SAXFeature sAXFeatureFindStdFeature = SAXUtil.findStdFeature(str);
        if (sAXFeatureFindStdFeature != null) {
            Boolean fixedStdFeatureValue = SAXUtil.getFixedStdFeatureValue(sAXFeatureFindStdFeature);
            if (fixedStdFeatureValue != null) {
                return fixedStdFeatureValue.booleanValue();
            }
            if (AnonymousClass1.$SwitchMap$com$fasterxml$aalto$sax$SAXFeature[sAXFeatureFindStdFeature.ordinal()] == 1) {
                return true;
            }
        }
        SAXUtil.reportUnknownFeature(str);
        return false;
    }

    /* JADX INFO: renamed from: com.fasterxml.aalto.sax.SAXParserImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$aalto$sax$SAXFeature;
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$aalto$sax$SAXProperty;

        static {
            int[] iArr = new int[SAXFeature.values().length];
            $SwitchMap$com$fasterxml$aalto$sax$SAXFeature = iArr;
            try {
                iArr[SAXFeature.IS_STANDALONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            int[] iArr2 = new int[SAXProperty.values().length];
            $SwitchMap$com$fasterxml$aalto$sax$SAXProperty = iArr2;
            try {
                iArr2[SAXProperty.DECLARATION_HANDLER.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fasterxml$aalto$sax$SAXProperty[SAXProperty.DOCUMENT_XML_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$fasterxml$aalto$sax$SAXProperty[SAXProperty.DOM_NODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$fasterxml$aalto$sax$SAXProperty[SAXProperty.LEXICAL_HANDLER.ordinal()] = 4;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$fasterxml$aalto$sax$SAXProperty[SAXProperty.XML_STRING.ordinal()] = 5;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // org.xml.sax.XMLReader
    public void setContentHandler(ContentHandler contentHandler) {
        this._contentHandler = contentHandler;
    }

    @Override // org.xml.sax.Parser, org.xml.sax.XMLReader
    public void setDTDHandler(DTDHandler dTDHandler) {
        this._dtdHandler = dTDHandler;
    }

    @Override // org.xml.sax.Parser, org.xml.sax.XMLReader
    public void setEntityResolver(EntityResolver entityResolver) {
        this._entityResolver = entityResolver;
    }

    @Override // org.xml.sax.Parser, org.xml.sax.XMLReader
    public void setErrorHandler(ErrorHandler errorHandler) {
        this._errorHandler = errorHandler;
    }

    @Override // org.xml.sax.XMLReader
    public void setFeature(String str, boolean z) throws SAXNotRecognizedException {
        if (SAXUtil.findStdFeature(str) != null) {
            return;
        }
        SAXUtil.reportUnknownFeature(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.xml.sax.Parser, org.xml.sax.XMLReader
    public void parse(InputSource inputSource) throws SAXException {
        InputStream byteStream;
        String encoding = inputSource.getEncoding();
        String systemId = inputSource.getSystemId();
        ReaderConfig nonSharedConfig = this._staxFactory.getNonSharedConfig(systemId, inputSource.getPublicId(), encoding, false, false);
        nonSharedConfig.doParseLazily(false);
        Reader characterStream = inputSource.getCharacterStream();
        if (characterStream == null) {
            byteStream = inputSource.getByteStream();
            if (byteStream == null) {
                if (systemId == null) {
                    throw new SAXException("Invalid InputSource passed: neither character or byte stream passed, nor system id specified");
                }
                try {
                    byteStream = URLUtil.inputStreamFromURL(URLUtil.urlFromSystemId(systemId));
                } catch (IOException e) {
                    SAXException sAXException = new SAXException(e);
                    if (sAXException.getCause() == null) {
                        sAXException.initCause(e);
                        throw sAXException;
                    }
                    throw sAXException;
                }
            }
        } else {
            byteStream = null;
        }
        ContentHandler contentHandler = this._contentHandler;
        if (contentHandler != null) {
            contentHandler.setDocumentLocator(this);
            this._contentHandler.startDocument();
        }
        try {
            if (characterStream != null) {
                this._scanner = CharSourceBootstrapper.construct(nonSharedConfig, characterStream).bootstrap();
            } else {
                this._scanner = ByteSourceBootstrapper.construct(nonSharedConfig, byteStream).bootstrap();
            }
            this._attrCollector = this._scanner.getAttrCollector();
            fireEvents();
            ContentHandler contentHandler2 = this._contentHandler;
            if (contentHandler2 != null) {
                contentHandler2.endDocument();
            }
            XmlScanner xmlScanner = this._scanner;
            if (xmlScanner != null) {
                try {
                    xmlScanner.close(false);
                } catch (XMLStreamException unused) {
                }
                this._scanner = null;
            }
            if (characterStream != null) {
                try {
                    characterStream.close();
                } catch (IOException unused2) {
                }
            }
            if (byteStream == null) {
            }
        } catch (XMLStreamException e2) {
            throwSaxException((Exception) e2);
        } finally {
            ContentHandler contentHandler3 = this._contentHandler;
            if (contentHandler3 != null) {
                contentHandler3.endDocument();
            }
            XmlScanner xmlScanner2 = this._scanner;
            if (xmlScanner2 != null) {
                try {
                    xmlScanner2.close(false);
                } catch (XMLStreamException unused3) {
                }
                this._scanner = null;
            }
            if (characterStream != null) {
                try {
                    characterStream.close();
                } catch (IOException unused4) {
                }
            }
            if (byteStream != null) {
                try {
                    byteStream.close();
                } catch (IOException unused5) {
                }
            }
        }
    }

    @Override // org.xml.sax.Parser, org.xml.sax.XMLReader
    public void parse(String str) throws SAXException {
        parse(new InputSource(str));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private final void fireEvents() throws XMLStreamException, SAXException {
        while (true) {
            int iNextFromProlog = this._scanner.nextFromProlog(true);
            if (iNextFromProlog == 1) {
                break;
            } else {
                fireAuxEvent(iNextFromProlog, false);
            }
        }
        fireStartTag();
        int i = 1;
        while (true) {
            int iNextFromTree = this._scanner.nextFromTree();
            if (iNextFromTree == 1) {
                fireStartTag();
                i++;
            } else if (iNextFromTree == 2) {
                fireEndTag();
                i--;
                if (i < 1) {
                    break;
                }
            } else if (iNextFromTree == 4) {
                this._scanner.fireSaxCharacterEvents(this._contentHandler);
            } else {
                fireAuxEvent(iNextFromTree, true);
            }
        }
        while (true) {
            int iNextFromProlog2 = this._scanner.nextFromProlog(false);
            if (iNextFromProlog2 == -1) {
                return;
            }
            if (iNextFromProlog2 != 6) {
                fireAuxEvent(iNextFromProlog2, false);
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private final void fireAuxEvent(int i, boolean z) throws SAXException, XMLStreamException {
        if (i == 3) {
            this._scanner.fireSaxPIEvent(this._contentHandler);
            return;
        }
        if (i == 5) {
            this._scanner.fireSaxCommentEvent(this._lexicalHandler);
            return;
        }
        if (i == 6) {
            if (z) {
                this._scanner.fireSaxSpaceEvents(this._contentHandler);
                return;
            }
            return;
        }
        if (i == 11) {
            if (this._lexicalHandler != null) {
                this._lexicalHandler.startDTD(this._scanner.getName().getPrefixedName(), this._scanner.getDTDPublicId(), this._scanner.getDTDSystemId());
                this._lexicalHandler.endDTD();
                return;
            }
            return;
        }
        if (i == 12) {
            LexicalHandler lexicalHandler = this._lexicalHandler;
            if (lexicalHandler != null) {
                lexicalHandler.startCDATA();
                this._scanner.fireSaxCharacterEvents(this._contentHandler);
                this._lexicalHandler.endCDATA();
                return;
            }
            this._scanner.fireSaxCharacterEvents(this._contentHandler);
            return;
        }
        if (i == -1) {
            throwSaxException("Unexpected end-of-input in ".concat(z ? "tree" : "prolog"));
        }
        throw new RuntimeException("Internal error: unexpected type, " + i);
    }

    private final void fireStartTag() throws SAXException {
        this._attrCount = this._scanner.getAttrCount();
        this._scanner.fireSaxStartElement(this._contentHandler, this);
    }

    private final void fireEndTag() throws SAXException {
        this._scanner.fireSaxEndElement(this._contentHandler);
    }

    @Override // org.xml.sax.Parser
    public void setDocumentHandler(DocumentHandler documentHandler) {
        setContentHandler(new DocHandlerWrapper(documentHandler));
    }

    @Override // org.xml.sax.Attributes
    public int getIndex(String str) {
        AttributeCollector attributeCollector = this._attrCollector;
        if (attributeCollector == null) {
            return -1;
        }
        return attributeCollector.findIndex(null, str);
    }

    @Override // org.xml.sax.Attributes
    public int getIndex(String str, String str2) {
        AttributeCollector attributeCollector = this._attrCollector;
        if (attributeCollector == null) {
            return -1;
        }
        return attributeCollector.findIndex(str, str2);
    }

    @Override // org.xml.sax.Attributes
    public int getLength() {
        return this._attrCount;
    }

    @Override // org.xml.sax.Attributes
    public String getLocalName(int i) {
        if (i < 0 || i >= this._attrCount) {
            return null;
        }
        return this._attrCollector.getName(i).getLocalName();
    }

    @Override // org.xml.sax.Attributes
    public String getQName(int i) {
        if (i < 0 || i >= this._attrCount) {
            return null;
        }
        return this._attrCollector.getName(i).getPrefixedName();
    }

    @Override // org.xml.sax.Attributes
    public String getType(int i) {
        if (i < 0 || i >= this._attrCount) {
            return null;
        }
        return this._scanner.getAttrType(i);
    }

    @Override // org.xml.sax.Attributes
    public String getType(String str) {
        int index = getIndex(str);
        if (index < 0) {
            return null;
        }
        return this._scanner.getAttrType(index);
    }

    @Override // org.xml.sax.Attributes
    public String getType(String str, String str2) {
        int index = getIndex(str, str2);
        if (index < 0) {
            return null;
        }
        return this._scanner.getAttrType(index);
    }

    @Override // org.xml.sax.Attributes
    public String getURI(int i) {
        if (i < 0 || i >= this._attrCount) {
            return null;
        }
        String nsUri = this._attrCollector.getName(i).getNsUri();
        return nsUri == null ? FinalChip.BSP_PLATFORM_Null : nsUri;
    }

    @Override // org.xml.sax.Attributes
    public String getValue(int i) {
        if (i < 0 || i >= this._attrCount) {
            return null;
        }
        return this._attrCollector.getValue(i);
    }

    @Override // org.xml.sax.Attributes
    public String getValue(String str) {
        int index = getIndex(str);
        if (index < 0) {
            return null;
        }
        return this._attrCollector.getValue(index);
    }

    @Override // org.xml.sax.Attributes
    public String getValue(String str, String str2) {
        int index = getIndex(str, str2);
        if (index < 0) {
            return null;
        }
        return this._attrCollector.getValue(index);
    }

    @Override // org.xml.sax.Locator
    public int getColumnNumber() {
        XmlScanner xmlScanner = this._scanner;
        if (xmlScanner != null) {
            return xmlScanner.getCurrentColumnNr();
        }
        return -1;
    }

    @Override // org.xml.sax.Locator
    public int getLineNumber() {
        XmlScanner xmlScanner = this._scanner;
        if (xmlScanner != null) {
            return xmlScanner.getCurrentLineNr();
        }
        return -1;
    }

    @Override // org.xml.sax.Locator
    public String getPublicId() {
        XmlScanner xmlScanner = this._scanner;
        if (xmlScanner != null) {
            return xmlScanner.getInputPublicId();
        }
        return null;
    }

    @Override // org.xml.sax.Locator
    public String getSystemId() {
        XmlScanner xmlScanner = this._scanner;
        if (xmlScanner != null) {
            return xmlScanner.getInputSystemId();
        }
        return null;
    }

    @Override // org.xml.sax.ext.Locator2
    public String getEncoding() {
        ReaderConfig config = this._scanner.getConfig();
        String actualEncoding = config.getActualEncoding();
        if (actualEncoding != null) {
            return actualEncoding;
        }
        String xmlDeclEncoding = config.getXmlDeclEncoding();
        return xmlDeclEncoding == null ? config.getExternalEncoding() : xmlDeclEncoding;
    }

    @Override // org.xml.sax.ext.Locator2
    public String getXMLVersion() {
        return this._scanner.getConfig().getXmlDeclVersion();
    }

    private void throwSaxException(Exception exc) throws SAXException {
        SAXParseException sAXParseException = new SAXParseException(exc.getMessage(), this, exc);
        if (sAXParseException.getCause() == null) {
            sAXParseException.initCause(exc);
        }
        ErrorHandler errorHandler = this._errorHandler;
        if (errorHandler != null) {
            errorHandler.fatalError(sAXParseException);
            throw sAXParseException;
        }
        throw sAXParseException;
    }

    private void throwSaxException(String str) throws SAXException {
        SAXParseException sAXParseException = new SAXParseException(str, this);
        ErrorHandler errorHandler = this._errorHandler;
        if (errorHandler != null) {
            errorHandler.fatalError(sAXParseException);
            throw sAXParseException;
        }
        throw sAXParseException;
    }

    static final class DocHandlerWrapper implements ContentHandler {
        final AttributesWrapper mAttrWrapper = new AttributesWrapper();
        final DocumentHandler mDocHandler;

        @Override // org.xml.sax.ContentHandler
        public void endPrefixMapping(String str) {
        }

        @Override // org.xml.sax.ContentHandler
        public void skippedEntity(String str) {
        }

        @Override // org.xml.sax.ContentHandler
        public void startPrefixMapping(String str, String str2) {
        }

        DocHandlerWrapper(DocumentHandler documentHandler) {
            this.mDocHandler = documentHandler;
        }

        @Override // org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) throws SAXException {
            this.mDocHandler.characters(cArr, i, i2);
        }

        @Override // org.xml.sax.ContentHandler
        public void endDocument() throws SAXException {
            this.mDocHandler.endDocument();
        }

        @Override // org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            if (str3 != null) {
                str2 = str3;
            }
            this.mDocHandler.endElement(str2);
        }

        @Override // org.xml.sax.ContentHandler
        public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
            this.mDocHandler.ignorableWhitespace(cArr, i, i2);
        }

        @Override // org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) throws SAXException {
            this.mDocHandler.processingInstruction(str, str2);
        }

        @Override // org.xml.sax.ContentHandler
        public void setDocumentLocator(Locator locator) {
            this.mDocHandler.setDocumentLocator(locator);
        }

        @Override // org.xml.sax.ContentHandler
        public void startDocument() throws SAXException {
            this.mDocHandler.startDocument();
        }

        @Override // org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            if (str3 != null) {
                str2 = str3;
            }
            this.mAttrWrapper.setAttributes(attributes);
            this.mDocHandler.startElement(str2, this.mAttrWrapper);
        }
    }

    static final class AttributesWrapper implements AttributeList {
        Attributes mAttrs;

        public void setAttributes(Attributes attributes) {
            this.mAttrs = attributes;
        }

        @Override // org.xml.sax.AttributeList
        public int getLength() {
            return this.mAttrs.getLength();
        }

        @Override // org.xml.sax.AttributeList
        public String getName(int i) {
            String qName = this.mAttrs.getQName(i);
            return qName == null ? this.mAttrs.getLocalName(i) : qName;
        }

        @Override // org.xml.sax.AttributeList
        public String getType(int i) {
            return this.mAttrs.getType(i);
        }

        @Override // org.xml.sax.AttributeList
        public String getType(String str) {
            return this.mAttrs.getType(str);
        }

        @Override // org.xml.sax.AttributeList
        public String getValue(int i) {
            return this.mAttrs.getValue(i);
        }

        @Override // org.xml.sax.AttributeList
        public String getValue(String str) {
            return this.mAttrs.getValue(str);
        }
    }
}
