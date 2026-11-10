package com.fasterxml.aalto.stax;

import chip.FinalChip;
import com.fasterxml.aalto.UncheckedStreamException;
import com.fasterxml.aalto.WFCException;
import com.fasterxml.aalto.impl.ErrorConsts;
import com.fasterxml.aalto.impl.IoStreamException;
import com.fasterxml.aalto.in.InputBootstrapper;
import com.fasterxml.aalto.in.PName;
import com.fasterxml.aalto.in.ReaderConfig;
import com.fasterxml.aalto.in.XmlScanner;
import com.fasterxml.aalto.util.TextAccumulator;
import com.fasterxml.aalto.util.XmlNames;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.NoSuchElementException;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.AttributeInfo;
import org.codehaus.stax2.DTDInfo;
import org.codehaus.stax2.LocationInfo;
import org.codehaus.stax2.XMLStreamLocation2;
import org.codehaus.stax2.XMLStreamReader2;
import org.codehaus.stax2.ri.Stax2Util;
import org.codehaus.stax2.ri.typed.CharArrayBase64Decoder;
import org.codehaus.stax2.ri.typed.ValueDecoderFactory;
import org.codehaus.stax2.typed.Base64Variant;
import org.codehaus.stax2.typed.Base64Variants;
import org.codehaus.stax2.typed.TypedArrayDecoder;
import org.codehaus.stax2.typed.TypedValueDecoder;
import org.codehaus.stax2.typed.TypedXMLStreamException;
import org.codehaus.stax2.validation.DTDValidationSchema;
import org.codehaus.stax2.validation.ValidationProblemHandler;
import org.codehaus.stax2.validation.XMLValidationSchema;
import org.codehaus.stax2.validation.XMLValidator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class StreamReaderImpl implements XMLStreamReader2, AttributeInfo, DTDInfo, LocationInfo {
    private static final int MASK_GET_ELEMENT_TEXT = 4688;
    private static final int MASK_GET_TEXT = 6768;
    private static final int MASK_GET_TEXT_WITH_WRITER = 6776;
    private static final int MASK_GET_TEXT_XXX = 4208;
    private static final int MASK_TYPED_ACCESS_ARRAY = 4182;
    private static final int MASK_TYPED_ACCESS_BINARY = 4178;
    static final int STATE_CLOSED = 3;
    static final int STATE_EPILOG = 2;
    static final int STATE_PROLOG = 0;
    static final int STATE_TREE = 1;
    protected int _attrCount;
    protected final boolean _cfgCoalesceText;
    protected final boolean _cfgReportTextAsChars;
    protected PName _currName;
    protected ValueDecoderFactory _decoderFactory;
    protected PName _dtdRootName;
    protected int _parseState;
    protected final XmlScanner _scanner;
    protected CharArrayBase64Decoder _base64Decoder = null;
    protected int _currToken = 7;

    @Deprecated
    public final Object getFeature(String str) {
        return null;
    }

    public final int getIdAttributeIndex() {
        return -1;
    }

    public final LocationInfo getLocationInfo() {
        return this;
    }

    public final int getNotationAttributeIndex() {
        return -1;
    }

    public final Object getProcessedDTD() {
        return null;
    }

    public final DTDValidationSchema getProcessedDTDSchema() {
        return null;
    }

    @Deprecated
    public final void setFeature(String str, Object obj) {
    }

    public final ValidationProblemHandler setValidationProblemHandler(ValidationProblemHandler validationProblemHandler) {
        return null;
    }

    public final XMLValidator stopValidatingAgainst(XMLValidationSchema xMLValidationSchema) throws XMLStreamException {
        return null;
    }

    public final XMLValidator stopValidatingAgainst(XMLValidator xMLValidator) throws XMLStreamException {
        return null;
    }

    public final XMLValidator validateAgainst(XMLValidationSchema xMLValidationSchema) throws XMLStreamException {
        return null;
    }

    public StreamReaderImpl(XmlScanner xmlScanner) {
        this._scanner = xmlScanner;
        ReaderConfig config = xmlScanner.getConfig();
        this._cfgCoalesceText = config.willCoalesceText();
        this._cfgReportTextAsChars = !config.willReportCData();
    }

    public static StreamReaderImpl construct(InputBootstrapper inputBootstrapper) throws XMLStreamException {
        return new StreamReaderImpl(inputBootstrapper.bootstrap());
    }

    public XmlScanner getScanner() {
        return this._scanner;
    }

    public final String getCharacterEncodingScheme() {
        return this._scanner.getConfig().getXmlDeclEncoding();
    }

    public final String getEncoding() {
        return this._scanner.getConfig().getActualEncoding();
    }

    public String getVersion() {
        return this._scanner.getConfig().getXmlDeclVersion();
    }

    public final boolean isStandalone() {
        return this._scanner.getConfig().getXmlDeclStandalone() == 1;
    }

    public final boolean standaloneSet() {
        return this._scanner.getConfig().getXmlDeclStandalone() != 0;
    }

    public Object getProperty(String str) {
        if (str.equals("javax.xml.stream.entities")) {
            return Collections.EMPTY_LIST;
        }
        if (str.equals("javax.xml.stream.notations")) {
            return Collections.EMPTY_LIST;
        }
        return this._scanner.getConfig().getProperty(str, false);
    }

    public ReaderConfig getConfig() {
        return this._scanner.getConfig();
    }

    public final int getAttributeCount() {
        if (this._currToken != 1) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_STELEM);
        }
        return this._attrCount;
    }

    public final String getAttributeLocalName(int i) {
        if (this._currToken != 1) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_STELEM);
        }
        if (i >= this._attrCount || i < 0) {
            reportInvalidAttrIndex(i);
        }
        return this._scanner.getAttrLocalName(i);
    }

    public final QName getAttributeName(int i) {
        if (this._currToken != 1) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_STELEM);
        }
        if (i >= this._attrCount || i < 0) {
            reportInvalidAttrIndex(i);
        }
        return this._scanner.getAttrQName(i);
    }

    public final String getAttributeNamespace(int i) {
        if (this._currToken != 1) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_STELEM);
        }
        if (i >= this._attrCount || i < 0) {
            reportInvalidAttrIndex(i);
        }
        String attrNsURI = this._scanner.getAttrNsURI(i);
        return attrNsURI == null ? FinalChip.BSP_PLATFORM_Null : attrNsURI;
    }

    public final String getAttributePrefix(int i) {
        if (this._currToken != 1) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_STELEM);
        }
        if (i >= this._attrCount || i < 0) {
            reportInvalidAttrIndex(i);
        }
        String attrPrefix = this._scanner.getAttrPrefix(i);
        return attrPrefix == null ? FinalChip.BSP_PLATFORM_Null : attrPrefix;
    }

    public final String getAttributeType(int i) {
        if (this._currToken != 1) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_STELEM);
        }
        if (i >= this._attrCount || i < 0) {
            reportInvalidAttrIndex(i);
        }
        return this._scanner.getAttrType(i);
    }

    public final String getAttributeValue(int i) {
        if (this._currToken != 1) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_STELEM);
        }
        if (i >= this._attrCount || i < 0) {
            reportInvalidAttrIndex(i);
        }
        return this._scanner.getAttrValue(i);
    }

    public final String getAttributeValue(String str, String str2) {
        if (this._currToken != 1) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_STELEM);
        }
        return this._scanner.getAttrValue(str, str2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final String getElementText() throws XMLStreamException {
        if (this._currToken != 1) {
            throwWfe(ErrorConsts.ERR_STATE_NOT_STELEM);
        }
        while (true) {
            int next = next();
            if (next == 2) {
                return FinalChip.BSP_PLATFORM_Null;
            }
            if (next != 5 && next != 3) {
                if (((1 << next) & MASK_GET_ELEMENT_TEXT) == 0) {
                    _reportNonTextEvent(next);
                }
                String text = this._scanner.getText();
                TextAccumulator textAccumulator = null;
                while (true) {
                    int next2 = next();
                    if (next2 == 2) {
                        break;
                    }
                    if (((1 << next2) & MASK_GET_ELEMENT_TEXT) != 0) {
                        if (textAccumulator == null) {
                            textAccumulator = new TextAccumulator();
                            textAccumulator.addText(text);
                        }
                        textAccumulator.addText(getText());
                    } else if (next2 != 5 && next2 != 3) {
                        _reportNonTextEvent(next2);
                    }
                }
                return textAccumulator == null ? text : textAccumulator.getAndClear();
            }
        }
    }

    public final int getEventType() {
        int i = this._currToken;
        if (i != 12) {
            return i;
        }
        if (this._cfgCoalesceText || this._cfgReportTextAsChars) {
            return 4;
        }
        return i;
    }

    public final String getLocalName() {
        int i = this._currToken;
        if (i == 1 || i == 2 || i == 9) {
            return this._currName.getLocalName();
        }
        throw new IllegalStateException("Current state not START_ELEMENT, END_ELEMENT or ENTITY_REFERENCE");
    }

    public final QName getName() {
        int i = this._currToken;
        if (i != 1 && i != 2) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_ELEM);
        }
        return this._scanner.getQName();
    }

    public final NamespaceContext getNamespaceContext() {
        return this._scanner;
    }

    public final int getNamespaceCount() {
        int i = this._currToken;
        if (i != 1 && i != 2) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_ELEM);
        }
        return this._scanner.getNsCount();
    }

    public final String getNamespacePrefix(int i) {
        int i2 = this._currToken;
        if (i2 != 1 && i2 != 2) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_ELEM);
        }
        String namespacePrefix = this._scanner.getNamespacePrefix(i);
        return namespacePrefix == null ? FinalChip.BSP_PLATFORM_Null : namespacePrefix;
    }

    public final String getNamespaceURI() {
        int i = this._currToken;
        if (i != 1 && i != 2) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_ELEM);
        }
        String namespaceURI = this._scanner.getNamespaceURI();
        return namespaceURI == null ? FinalChip.BSP_PLATFORM_Null : namespaceURI;
    }

    public final String getNamespaceURI(int i) {
        int i2 = this._currToken;
        if (i2 != 1 && i2 != 2) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_ELEM);
        }
        String namespaceURI = this._scanner.getNamespaceURI(i);
        return namespaceURI == null ? FinalChip.BSP_PLATFORM_Null : namespaceURI;
    }

    public final String getNamespaceURI(String str) {
        int i = this._currToken;
        if (i != 1 && i != 2) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_ELEM);
        }
        return this._scanner.getNamespaceURI(str);
    }

    public final String getPIData() {
        if (this._currToken != 3) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_PI);
        }
        try {
            return this._scanner.getText();
        } catch (XMLStreamException e) {
            throw UncheckedStreamException.createFrom(e);
        }
    }

    public final String getPITarget() {
        if (this._currToken != 3) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_PI);
        }
        return this._currName.getLocalName();
    }

    public final String getPrefix() {
        int i = this._currToken;
        if (i != 1 && i != 2) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_ELEM);
        }
        String prefix = this._currName.getPrefix();
        return prefix == null ? FinalChip.BSP_PLATFORM_Null : prefix;
    }

    public final String getText() {
        int i = this._currToken;
        if (((1 << i) & MASK_GET_TEXT) == 0) {
            throwNotTextual(i);
        }
        try {
            return this._scanner.getText();
        } catch (XMLStreamException e) {
            throw UncheckedStreamException.createFrom(e);
        }
    }

    public final char[] getTextCharacters() {
        int i = this._currToken;
        if (((1 << i) & MASK_GET_TEXT_XXX) == 0) {
            throwNotTextXxx(i);
        }
        try {
            return this._scanner.getTextCharacters();
        } catch (XMLStreamException e) {
            throw UncheckedStreamException.createFrom(e);
        }
    }

    public final int getTextCharacters(int i, char[] cArr, int i2, int i3) {
        int i4 = this._currToken;
        if (((1 << i4) & MASK_GET_TEXT_XXX) == 0) {
            throwNotTextXxx(i4);
        }
        try {
            return this._scanner.getTextCharacters(i, cArr, i2, i3);
        } catch (XMLStreamException e) {
            throw UncheckedStreamException.createFrom(e);
        }
    }

    public final int getTextLength() {
        int i = this._currToken;
        if (((1 << i) & MASK_GET_TEXT_XXX) == 0) {
            throwNotTextXxx(i);
        }
        try {
            return this._scanner.getTextLength();
        } catch (XMLStreamException e) {
            throw UncheckedStreamException.createFrom(e);
        }
    }

    public final int getTextStart() {
        int i = this._currToken;
        if (((1 << i) & MASK_GET_TEXT_XXX) != 0) {
            return 0;
        }
        throwNotTextXxx(i);
        return 0;
    }

    public final boolean hasName() {
        int i = this._currToken;
        return i == 1 || i == 2;
    }

    public final boolean hasNext() {
        return this._currToken != 8;
    }

    public final boolean hasText() {
        return ((1 << this._currToken) & MASK_GET_TEXT) != 0;
    }

    public final boolean isAttributeSpecified(int i) {
        if (this._currToken != 1) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_STELEM);
        }
        return this._scanner.isAttrSpecified(i);
    }

    public final boolean isCharacters() {
        return getEventType() == 4;
    }

    public final boolean isEndElement() {
        return this._currToken == 2;
    }

    public final boolean isStartElement() {
        return this._currToken == 1;
    }

    public final boolean isWhiteSpace() {
        int i = this._currToken;
        if (i != 4 && i != 12) {
            return i == 6;
        }
        try {
            return this._scanner.isTextWhitespace();
        } catch (XMLStreamException e) {
            throw UncheckedStreamException.createFrom(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final void require(int i, String str, String str2) throws XMLStreamException {
        int i2 = this._currToken;
        if (i2 != i && i2 == 12 && (this._cfgCoalesceText || this._cfgReportTextAsChars)) {
            i2 = 4;
        }
        if (i != i2) {
            throwWfe("Expected type " + ErrorConsts.tokenTypeDesc(i) + ", current type " + ErrorConsts.tokenTypeDesc(i2));
        }
        if (str2 != null) {
            if (i2 != 1 && i2 != 2 && i2 != 9) {
                throwWfe("Expected non-null local name, but current token not a START_ELEMENT, END_ELEMENT or ENTITY_REFERENCE (was " + ErrorConsts.tokenTypeDesc(this._currToken) + ")");
            }
            String localName = getLocalName();
            if (localName != str2 && !localName.equals(str2)) {
                throwWfe("Expected local name '" + str2 + "'; current local name '" + localName + "'.");
            }
        }
        if (str != null) {
            if (i2 != 1 && i2 != 2) {
                throwWfe("Expected non-null NS URI, but current token not a START_ELEMENT or END_ELEMENT (was " + ErrorConsts.tokenTypeDesc(i2) + ")");
            }
            String namespaceURI = getNamespaceURI();
            if (str.length() == 0) {
                if (namespaceURI == null || namespaceURI.length() <= 0) {
                    return;
                }
                throwWfe("Expected empty namespace, instead have '" + namespaceURI + "'.");
                return;
            }
            if (str == namespaceURI || str.equals(namespaceURI)) {
                return;
            }
            throwWfe("Expected namespace '" + str + "'; have '" + namespaceURI + "'.");
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final int next() throws XMLStreamException {
        int iNextFromProlog;
        int i = this._parseState;
        if (i == 1) {
            int iNextFromTree = this._scanner.nextFromTree();
            if (iNextFromTree == -1) {
                handleTreeEoi();
            }
            this._currToken = iNextFromTree;
            if (iNextFromTree == 12) {
                if (this._cfgCoalesceText || this._cfgReportTextAsChars) {
                    return 4;
                }
            } else {
                this._currName = this._scanner.getName();
                if (iNextFromTree == 2) {
                    if (this._scanner.hasEmptyStack()) {
                        this._parseState = 2;
                    }
                } else if (iNextFromTree == 1) {
                    this._attrCount = this._scanner.getAttrCount();
                }
            }
            return iNextFromTree;
        }
        if (i == 0) {
            iNextFromProlog = this._scanner.nextFromProlog(true);
            if (iNextFromProlog == 1) {
                this._parseState = 1;
                this._attrCount = this._scanner.getAttrCount();
            } else if (iNextFromProlog == 11) {
                if (this._dtdRootName != null) {
                    throwWfe("Duplicate DOCTYPE declaration");
                }
                this._dtdRootName = this._scanner.getName();
            }
        } else if (i == 2) {
            iNextFromProlog = this._scanner.nextFromProlog(false);
        } else {
            throw new NoSuchElementException();
        }
        if (iNextFromProlog < 0) {
            return handlePrologEoi(this._parseState == 0);
        }
        this._currName = this._scanner.getName();
        this._currToken = iNextFromProlog;
        return iNextFromProlog;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0008. Please report as an issue. */
    public final int nextTag() throws XMLStreamException {
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
                        throwWfe("Received event " + ErrorConsts.tokenTypeDesc(next) + ", instead of START_ELEMENT or END_ELEMENT.");
                        break;
                }
                return next;
            }
            if (!isWhiteSpace()) {
                throwWfe("Received non-all-whitespace CHARACTERS or CDATA event in nextTag().");
                throwWfe("Received event " + ErrorConsts.tokenTypeDesc(next) + ", instead of START_ELEMENT or END_ELEMENT.");
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final void close() throws XMLStreamException {
        _closeScanner(false);
    }

    public final Location getLocation() {
        return getStartLocation();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.typed.TypedXMLStreamException */
    public final boolean getElementAsBoolean() throws TypedXMLStreamException, XMLStreamException {
        ValueDecoderFactory.BooleanDecoder booleanDecoder = _decoderFactory().getBooleanDecoder();
        getElementAs(booleanDecoder);
        return booleanDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.typed.TypedXMLStreamException */
    public final int getElementAsInt() throws TypedXMLStreamException, XMLStreamException {
        ValueDecoderFactory.IntDecoder intDecoder = _decoderFactory().getIntDecoder();
        getElementAs(intDecoder);
        return intDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.typed.TypedXMLStreamException */
    public final long getElementAsLong() throws TypedXMLStreamException, XMLStreamException {
        ValueDecoderFactory.LongDecoder longDecoder = _decoderFactory().getLongDecoder();
        getElementAs(longDecoder);
        return longDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.typed.TypedXMLStreamException */
    public final float getElementAsFloat() throws TypedXMLStreamException, XMLStreamException {
        ValueDecoderFactory.FloatDecoder floatDecoder = _decoderFactory().getFloatDecoder();
        getElementAs(floatDecoder);
        return floatDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.typed.TypedXMLStreamException */
    public final double getElementAsDouble() throws TypedXMLStreamException, XMLStreamException {
        ValueDecoderFactory.DoubleDecoder doubleDecoder = _decoderFactory().getDoubleDecoder();
        getElementAs(doubleDecoder);
        return doubleDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.typed.TypedXMLStreamException */
    public final BigInteger getElementAsInteger() throws TypedXMLStreamException, XMLStreamException {
        ValueDecoderFactory.IntegerDecoder integerDecoder = _decoderFactory().getIntegerDecoder();
        getElementAs(integerDecoder);
        return integerDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.typed.TypedXMLStreamException */
    public final BigDecimal getElementAsDecimal() throws TypedXMLStreamException, XMLStreamException {
        ValueDecoderFactory.DecimalDecoder decimalDecoder = _decoderFactory().getDecimalDecoder();
        getElementAs(decimalDecoder);
        return decimalDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.typed.TypedXMLStreamException */
    public final QName getElementAsQName() throws TypedXMLStreamException, XMLStreamException {
        ValueDecoderFactory.QNameDecoder qNameDecoder = _decoderFactory().getQNameDecoder(getNamespaceContext());
        getElementAs(qNameDecoder);
        return verifyQName(qNameDecoder.getValue());
    }

    public final byte[] getElementAsBinary() throws XMLStreamException {
        return getElementAsBinary(Base64Variants.getDefaultVariant());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.typed.TypedXMLStreamException */
    public final void getElementAs(TypedValueDecoder typedValueDecoder) throws TypedXMLStreamException, XMLStreamException {
        String strTrim = getElementText().trim();
        if (strTrim.length() == 0) {
            _handleEmptyValue(typedValueDecoder);
            return;
        }
        try {
            typedValueDecoder.decode(strTrim);
        } catch (IllegalArgumentException e) {
            throw _constructTypeException(e, strTrim);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.typed.TypedXMLStreamException */
    public final byte[] getElementAsBinary(Base64Variant base64Variant) throws TypedXMLStreamException, XMLStreamException {
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

    public final int readElementAsIntArray(int[] iArr, int i, int i2) throws XMLStreamException {
        return readElementAsArray(_decoderFactory().getIntArrayDecoder(iArr, i, i2));
    }

    public final int readElementAsLongArray(long[] jArr, int i, int i2) throws XMLStreamException {
        return readElementAsArray(_decoderFactory().getLongArrayDecoder(jArr, i, i2));
    }

    public final int readElementAsFloatArray(float[] fArr, int i, int i2) throws XMLStreamException {
        return readElementAsArray(_decoderFactory().getFloatArrayDecoder(fArr, i, i2));
    }

    public final int readElementAsDoubleArray(double[] dArr, int i, int i2) throws XMLStreamException {
        return readElementAsArray(_decoderFactory().getDoubleArrayDecoder(dArr, i, i2));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:23:0x0038  */
    /* JADX WARN: Code duplicated, block: B:33:0x004a  */
    /* JADX WARN: Code duplicated, block: B:39:0x0060  */
    /* JADX WARN: Code duplicated, block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0055, code lost:
    
        if (r12.hasRoom() == false) goto L38;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0058 -> B:37:0x005c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int readElementAsArray(org.codehaus.stax2.typed.TypedArrayDecoder r12) throws javax.xml.stream.XMLStreamException {
        /*
            r11 = this;
            int r0 = r11._currToken
            r1 = 1
            int r2 = r1 << r0
            r2 = r2 & 4182(0x1056, float:5.86E-42)
            if (r2 == 0) goto L62
            r2 = 12
            r3 = 3
            r4 = 4
            r5 = 5
            r6 = 2
            r7 = 0
            r8 = -1
            if (r0 != r1) goto L35
            com.fasterxml.aalto.in.XmlScanner r0 = r11._scanner
            boolean r0 = r0.isEmptyTag()
            if (r0 == 0) goto L1f
            r11.next()
            return r8
        L1f:
            int r0 = r11.next()
            if (r0 != r6) goto L26
            return r8
        L26:
            if (r0 == r5) goto L1f
            if (r0 != r3) goto L2b
            goto L1f
        L2b:
            if (r0 == r4) goto L5c
            if (r0 != r2) goto L30
            goto L5c
        L30:
            javax.xml.stream.XMLStreamException r12 = r11._constructUnexpectedInTyped(r0)
            throw r12
        L35:
            r9 = r7
        L36:
            if (r0 == r6) goto L5e
            if (r0 == r4) goto L4a
            if (r0 == r2) goto L4a
            r10 = 6
            if (r0 != r10) goto L40
            goto L4a
        L40:
            if (r0 == r5) goto L58
            if (r0 != r3) goto L45
            goto L58
        L45:
            javax.xml.stream.XMLStreamException r12 = r11._constructUnexpectedInTyped(r0)
            throw r12
        L4a:
            com.fasterxml.aalto.in.XmlScanner r0 = r11._scanner
            int r0 = r0.decodeElements(r12, r9)
            int r7 = r7 + r0
            boolean r0 = r12.hasRoom()
            if (r0 != 0) goto L58
            goto L5e
        L58:
            int r0 = r11.next()
        L5c:
            r9 = r1
            goto L36
        L5e:
            if (r7 <= 0) goto L61
            r8 = r7
        L61:
            return r8
        L62:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = com.fasterxml.aalto.impl.ErrorConsts.ERR_STATE_NOT_STELEM_OR_TEXT
            r12.<init>(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.aalto.stax.StreamReaderImpl.readElementAsArray(org.codehaus.stax2.typed.TypedArrayDecoder):int");
    }

    public final int readElementAsBinary(byte[] bArr, int i, int i2) throws XMLStreamException {
        return readElementAsBinary(bArr, i, i2, Base64Variants.getDefaultVariant());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.typed.TypedXMLStreamException */
    public final int readElementAsBinary(byte[] bArr, int i, int i2, Base64Variant base64Variant) throws TypedXMLStreamException, XMLStreamException {
        int next;
        if (bArr == null) {
            throw new IllegalArgumentException("resultBuffer is null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("Illegal offset (" + i + "), must be [0, " + bArr.length + "[");
        }
        if (i2 < 1 || i + i2 > bArr.length) {
            if (i2 == 0) {
                return 0;
            }
            throw new IllegalArgumentException("Illegal maxLength (" + i2 + "), has to be positive number, and offset+maxLength can not exceed" + bArr.length);
        }
        CharArrayBase64Decoder charArrayBase64Decoder_base64Decoder = _base64Decoder();
        int i3 = this._currToken;
        if (((1 << i3) & MASK_TYPED_ACCESS_BINARY) == 0) {
            if (i3 == 2) {
                if (!charArrayBase64Decoder_base64Decoder.hasData()) {
                    return -1;
                }
            } else {
                throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_STELEM_OR_TEXT);
            }
        } else if (i3 == 1) {
            if (this._scanner.isEmptyTag()) {
                next();
                return -1;
            }
            while (true) {
                int next2 = next();
                if (next2 == 2) {
                    return -1;
                }
                if (next2 != 5 && next2 != 3) {
                    if (next2 != 4 && next2 != 12) {
                        throw _constructUnexpectedInTyped(next2);
                    }
                    this._scanner.resetForDecoding(base64Variant, charArrayBase64Decoder_base64Decoder, true);
                    break;
                }
            }
        }
        int i4 = 0;
        while (true) {
            try {
                int iDecode = charArrayBase64Decoder_base64Decoder.decode(bArr, i, i2);
                i += iDecode;
                i4 += iDecode;
                i2 -= iDecode;
                if (i2 < 1 || this._currToken == 2) {
                    break;
                }
                while (true) {
                    next = next();
                    if (next != 5 && next != 3 && next != 6) {
                        break;
                    }
                }
                if (next == 2) {
                    int iEndOfContent = charArrayBase64Decoder_base64Decoder.endOfContent();
                    if (iEndOfContent < 0) {
                        throw _constructTypeException("Incomplete base64 triplet at the end of decoded content", FinalChip.BSP_PLATFORM_Null);
                    }
                    if (iEndOfContent <= 0) {
                        break;
                    }
                } else {
                    this._scanner.resetForDecoding(base64Variant, charArrayBase64Decoder_base64Decoder, false);
                }
            } catch (IllegalArgumentException e) {
                throw _constructTypeException(e.getMessage(), FinalChip.BSP_PLATFORM_Null);
            }
        }
        if (i4 > 0) {
            return i4;
        }
        return -1;
    }

    public final int getAttributeIndex(String str, String str2) {
        if (this._currToken != 1) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_STELEM);
        }
        return findAttributeIndex(str, str2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.typed.TypedXMLStreamException */
    public final boolean getAttributeAsBoolean(int i) throws TypedXMLStreamException, XMLStreamException {
        ValueDecoderFactory.BooleanDecoder booleanDecoder = _decoderFactory().getBooleanDecoder();
        getAttributeAs(i, booleanDecoder);
        return booleanDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.typed.TypedXMLStreamException */
    public final int getAttributeAsInt(int i) throws TypedXMLStreamException, XMLStreamException {
        ValueDecoderFactory.IntDecoder intDecoder = _decoderFactory().getIntDecoder();
        getAttributeAs(i, intDecoder);
        return intDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.typed.TypedXMLStreamException */
    public final long getAttributeAsLong(int i) throws TypedXMLStreamException, XMLStreamException {
        ValueDecoderFactory.LongDecoder longDecoder = _decoderFactory().getLongDecoder();
        getAttributeAs(i, longDecoder);
        return longDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.typed.TypedXMLStreamException */
    public final float getAttributeAsFloat(int i) throws TypedXMLStreamException, XMLStreamException {
        ValueDecoderFactory.FloatDecoder floatDecoder = _decoderFactory().getFloatDecoder();
        getAttributeAs(i, floatDecoder);
        return floatDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.typed.TypedXMLStreamException */
    public final double getAttributeAsDouble(int i) throws TypedXMLStreamException, XMLStreamException {
        ValueDecoderFactory.DoubleDecoder doubleDecoder = _decoderFactory().getDoubleDecoder();
        getAttributeAs(i, doubleDecoder);
        return doubleDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.typed.TypedXMLStreamException */
    public final BigInteger getAttributeAsInteger(int i) throws TypedXMLStreamException, XMLStreamException {
        ValueDecoderFactory.IntegerDecoder integerDecoder = _decoderFactory().getIntegerDecoder();
        getAttributeAs(i, integerDecoder);
        return integerDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.typed.TypedXMLStreamException */
    public final BigDecimal getAttributeAsDecimal(int i) throws TypedXMLStreamException, XMLStreamException {
        ValueDecoderFactory.DecimalDecoder decimalDecoder = _decoderFactory().getDecimalDecoder();
        getAttributeAs(i, decimalDecoder);
        return decimalDecoder.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.typed.TypedXMLStreamException */
    public final QName getAttributeAsQName(int i) throws TypedXMLStreamException, XMLStreamException {
        ValueDecoderFactory.QNameDecoder qNameDecoder = _decoderFactory().getQNameDecoder(getNamespaceContext());
        getAttributeAs(i, qNameDecoder);
        return verifyQName(qNameDecoder.getValue());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.typed.TypedXMLStreamException */
    public final void getAttributeAs(int i, TypedValueDecoder typedValueDecoder) throws TypedXMLStreamException, XMLStreamException {
        if (this._currToken != 1) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_STELEM);
        }
        try {
            this._scanner.decodeAttrValue(i, typedValueDecoder);
        } catch (IllegalArgumentException e) {
            throw _constructTypeException(e, getAttributeValue(i));
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final int[] getAttributeAsIntArray(int i) throws XMLStreamException {
        ValueDecoderFactory.IntArrayDecoder intArrayDecoder = _decoderFactory().getIntArrayDecoder();
        getAttributeAsArray(i, intArrayDecoder);
        return intArrayDecoder.getValues();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final long[] getAttributeAsLongArray(int i) throws XMLStreamException {
        ValueDecoderFactory.LongArrayDecoder longArrayDecoder = _decoderFactory().getLongArrayDecoder();
        getAttributeAsArray(i, longArrayDecoder);
        return longArrayDecoder.getValues();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final float[] getAttributeAsFloatArray(int i) throws XMLStreamException {
        ValueDecoderFactory.FloatArrayDecoder floatArrayDecoder = _decoderFactory().getFloatArrayDecoder();
        getAttributeAsArray(i, floatArrayDecoder);
        return floatArrayDecoder.getValues();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final double[] getAttributeAsDoubleArray(int i) throws XMLStreamException {
        ValueDecoderFactory.DoubleArrayDecoder doubleArrayDecoder = _decoderFactory().getDoubleArrayDecoder();
        getAttributeAsArray(i, doubleArrayDecoder);
        return doubleArrayDecoder.getValues();
    }

    public final int getAttributeAsArray(int i, TypedArrayDecoder typedArrayDecoder) throws XMLStreamException {
        if (this._currToken != 1) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_STELEM);
        }
        return this._scanner.decodeAttrValues(i, typedArrayDecoder);
    }

    public final byte[] getAttributeAsBinary(int i) throws XMLStreamException {
        return getAttributeAsBinary(i, Base64Variants.getDefaultVariant());
    }

    public final byte[] getAttributeAsBinary(int i, Base64Variant base64Variant) throws XMLStreamException {
        if (this._currToken != 1) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_STELEM);
        }
        return this._scanner.decodeAttrBinaryValue(i, base64Variant, _base64Decoder());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.typed.TypedXMLStreamException */
    protected QName verifyQName(QName qName) throws TypedXMLStreamException {
        String localPart = qName.getLocalPart();
        int iFindIllegalNameChar = XmlNames.findIllegalNameChar(localPart, false);
        if (iFindIllegalNameChar < 0) {
            return qName;
        }
        String prefix = qName.getPrefix();
        throw _constructTypeException("Invalid local name \"" + localPart + "\" (character at #" + iFindIllegalNameChar + " is invalid)", (prefix == null || prefix.length() <= 0) ? localPart : prefix + ":" + localPart);
    }

    public final boolean isPropertySupported(String str) {
        return this._scanner.getConfig().isPropertySupported(str);
    }

    public final boolean setProperty(String str, Object obj) {
        return this._scanner.getConfig().setProperty(str, obj);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final void skipElement() throws XMLStreamException {
        if (this._currToken != 1) {
            throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_STELEM);
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

    public final AttributeInfo getAttributeInfo() throws XMLStreamException {
        if (this._currToken == 1) {
            return this;
        }
        throw new IllegalStateException(ErrorConsts.ERR_STATE_NOT_STELEM);
    }

    public final DTDInfo getDTDInfo() throws XMLStreamException {
        if (this._currToken != 11) {
            return null;
        }
        return this;
    }

    public final int getText(Writer writer, boolean z) throws XMLStreamException {
        int i = this._currToken;
        if (((1 << i) & MASK_GET_TEXT_WITH_WRITER) == 0) {
            throwNotTextual(i);
        }
        return this._scanner.getText(writer, z);
    }

    public final int getDepth() {
        int depth = this._scanner.getDepth();
        return this._currToken == 2 ? depth + 1 : depth;
    }

    public final boolean isEmptyElement() throws XMLStreamException {
        if (this._currToken == 1) {
            return this._scanner.isEmptyTag();
        }
        return false;
    }

    public final NamespaceContext getNonTransientNamespaceContext() {
        return this._scanner.getNonTransientNamespaceContext();
    }

    public final String getPrefixedName() {
        int i = this._currToken;
        if (i == 1 || i == 2) {
            return this._currName.getPrefixedName();
        }
        if (i == 3) {
            return getPITarget();
        }
        if (i == 9) {
            return getLocalName();
        }
        if (i == 11) {
            return getDTDRootName();
        }
        throw new IllegalStateException("Current state not START_ELEMENT, END_ELEMENT, ENTITY_REFERENCE, PROCESSING_INSTRUCTION or DTD");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final void closeCompletely() throws XMLStreamException {
        _closeScanner(true);
    }

    public final String getDTDRootName() {
        PName pName;
        if (this._currToken == 11 && (pName = this._currName) != null) {
            return pName.getPrefixedName();
        }
        return null;
    }

    public final String getDTDPublicId() {
        return this._scanner.getDTDPublicId();
    }

    public final String getDTDSystemId() {
        return this._scanner.getDTDSystemId();
    }

    public final String getDTDInternalSubset() {
        if (this._currToken != 11) {
            return null;
        }
        try {
            return this._scanner.getText();
        } catch (XMLStreamException e) {
            throw UncheckedStreamException.createFrom(e);
        }
    }

    public final long getStartingByteOffset() {
        return this._scanner.getStartingByteOffset();
    }

    public final long getStartingCharOffset() {
        return this._scanner.getStartingCharOffset();
    }

    public final long getEndingByteOffset() throws XMLStreamException {
        return this._scanner.getEndingByteOffset();
    }

    public final long getEndingCharOffset() throws XMLStreamException {
        return this._scanner.getEndingCharOffset();
    }

    public final XMLStreamLocation2 getStartLocation() {
        return this._scanner.getStartLocation();
    }

    public final XMLStreamLocation2 getEndLocation() throws XMLStreamException {
        return this._scanner.getEndLocation();
    }

    public final XMLStreamLocation2 getCurrentLocation() {
        return this._scanner.getCurrentLocation();
    }

    public final int findAttributeIndex(String str, String str2) {
        return this._scanner.findAttrIndex(str, str2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void _reportNonTextEvent(int i) throws XMLStreamException {
        throwWfe("Expected a text token, got " + ErrorConsts.tokenTypeDesc(i) + ".");
    }

    protected Location getLastCharLocation() {
        return this._scanner.getCurrentLocation();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected int handlePrologEoi(boolean z) throws XMLStreamException {
        close();
        if (!z) {
            return 8;
        }
        throwUnexpectedEOI(ErrorConsts.SUFFIX_IN_PROLOG);
        return 8;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void handleTreeEoi() throws XMLStreamException {
        this._currToken = 8;
        throwUnexpectedEOI(ErrorConsts.SUFFIX_IN_TREE);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void throwWfe(String str) throws XMLStreamException {
        throw new WFCException(str, getLastCharLocation());
    }

    private void throwNotTextual(int i) {
        throw new IllegalStateException("Not a textual event (" + ErrorConsts.tokenTypeDesc(this._currToken) + ")");
    }

    private void throwNotTextXxx(int i) {
        throw new IllegalStateException("getTextXxx() methods can not be called on " + ErrorConsts.tokenTypeDesc(this._currToken));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void throwFromIOE(IOException iOException) throws XMLStreamException {
        throw new IoStreamException(iOException);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void throwUnexpectedEOI(String str) throws XMLStreamException {
        throwWfe("Unexpected End-of-input" + str);
    }

    protected XMLStreamException _constructUnexpectedInTyped(int i) {
        if (i == 1) {
            return _constructTypeException("Element content can not contain child START_ELEMENT when using Typed Access methods", (String) null);
        }
        return _constructTypeException("Expected a text token, got " + ErrorConsts.tokenTypeDesc(i), (String) null);
    }

    private TypedXMLStreamException _constructTypeException(IllegalArgumentException illegalArgumentException, String str) {
        return new TypedXMLStreamException(str, illegalArgumentException.getMessage(), getStartLocation(), illegalArgumentException);
    }

    private TypedXMLStreamException _constructTypeException(String str, String str2) {
        return new TypedXMLStreamException(str2, str, getStartLocation());
    }

    protected void reportInvalidAttrIndex(int i) {
        throw new IllegalArgumentException("Illegal attribute index, " + i + ", current START_ELEMENT has " + this._attrCount + " attributes");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void _closeScanner(boolean z) throws XMLStreamException {
        if (this._parseState != 3) {
            this._parseState = 3;
            if (this._currToken != 8) {
                this._currToken = 8;
            }
        }
        this._scanner.close(z);
    }

    protected final ValueDecoderFactory _decoderFactory() {
        if (this._decoderFactory == null) {
            this._decoderFactory = new ValueDecoderFactory();
        }
        return this._decoderFactory;
    }

    protected CharArrayBase64Decoder _base64Decoder() {
        if (this._base64Decoder == null) {
            this._base64Decoder = new CharArrayBase64Decoder();
        }
        return this._base64Decoder;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.typed.TypedXMLStreamException */
    private void _handleEmptyValue(TypedValueDecoder typedValueDecoder) throws TypedXMLStreamException, XMLStreamException {
        try {
            typedValueDecoder.handleEmptyValue();
        } catch (IllegalArgumentException e) {
            throw _constructTypeException(e, FinalChip.BSP_PLATFORM_Null);
        }
    }

    public final String toString() {
        return "[Aalto stream reader, scanner: " + this._scanner + "]";
    }
}
