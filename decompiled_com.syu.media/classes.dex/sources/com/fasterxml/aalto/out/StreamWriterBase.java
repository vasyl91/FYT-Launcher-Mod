package com.fasterxml.aalto.out;

import chip.FinalChip;
import com.fasterxml.aalto.ValidationException;
import com.fasterxml.aalto.impl.ErrorConsts;
import com.fasterxml.aalto.impl.IoStreamException;
import com.fasterxml.aalto.impl.LocationImpl;
import com.fasterxml.aalto.impl.StreamExceptionBase;
import com.fasterxml.aalto.util.TextUtil;
import com.fasterxml.aalto.util.XmlConsts;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.DTDInfo;
import org.codehaus.stax2.XMLStreamLocation2;
import org.codehaus.stax2.ri.Stax2WriterImpl;
import org.codehaus.stax2.ri.typed.AsciiValueEncoder;
import org.codehaus.stax2.ri.typed.ValueEncoderFactory;
import org.codehaus.stax2.typed.Base64Variant;
import org.codehaus.stax2.typed.Base64Variants;
import org.codehaus.stax2.validation.ValidationContext;
import org.codehaus.stax2.validation.ValidationProblemHandler;
import org.codehaus.stax2.validation.ValidatorPair;
import org.codehaus.stax2.validation.XMLValidationException;
import org.codehaus.stax2.validation.XMLValidationProblem;
import org.codehaus.stax2.validation.XMLValidationSchema;
import org.codehaus.stax2.validation.XMLValidator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public abstract class StreamWriterBase extends Stax2WriterImpl implements NamespaceContext, ValidationContext {
    static final int MAX_POOL_SIZE = 8;
    protected boolean _cfgCheckAttrs;
    protected boolean _cfgCheckContent;
    protected boolean _cfgCheckStructure;
    protected final WriterConfig _config;
    protected NamespaceContext _rootNsContext;
    protected WNameTable _symbols;
    protected ValueEncoderFactory _valueEncoderFactory;
    protected final XmlWriter _xmlWriter;
    protected XMLValidator _validator = null;
    protected int _vldContent = 4;
    protected ValidationProblemHandler _vldProblemHandler = null;
    protected State _state = State.PROLOG;
    protected OutputElement _currElem = OutputElement.createRoot();
    protected boolean _stateAnyOutput = false;
    protected boolean _stateStartElementOpen = false;
    protected boolean _stateEmptyElement = false;
    protected String _dtdRootElemName = null;
    protected OutputElement _outputElemPool = null;
    protected int _poolSize = 0;
    protected final boolean _cfgCDataAsText = false;

    protected enum State {
        PROLOG,
        TREE,
        EPILOG
    }

    protected abstract String _serializeQName(QName qName) throws XMLStreamException;

    protected abstract void _setPrefix(String str, String str2);

    protected final void _verifyWriteAttr(WName wName) {
    }

    public int addDefaultAttribute(String str, String str2, String str3, String str4) {
        return -1;
    }

    public int findAttributeIndex(String str, String str2) {
        return -1;
    }

    public int getAttributeCount() {
        return 0;
    }

    public String getAttributeLocalName(int i) {
        return null;
    }

    public String getAttributeNamespace(int i) {
        return null;
    }

    public String getAttributePrefix(int i) {
        return null;
    }

    public String getAttributeType(int i) {
        return FinalChip.BSP_PLATFORM_Null;
    }

    public String getAttributeValue(int i) {
        return null;
    }

    public String getAttributeValue(String str, String str2) {
        return null;
    }

    public String getBaseUri() {
        return null;
    }

    public final NamespaceContext getNamespaceContext() {
        return this;
    }

    public boolean isNotationDeclared(String str) {
        return false;
    }

    public boolean isUnparsedEntityDeclared(String str) {
        return false;
    }

    public abstract void setDefaultNamespace(String str) throws XMLStreamException;

    public abstract void writeAttribute(String str, String str2, String str3) throws XMLStreamException;

    public abstract void writeAttribute(String str, String str2, String str3, String str4) throws XMLStreamException;

    public abstract void writeDefaultNamespace(String str) throws XMLStreamException;

    public abstract void writeEmptyElement(String str, String str2) throws XMLStreamException;

    public abstract void writeEmptyElement(String str, String str2, String str3) throws XMLStreamException;

    public abstract void writeNamespace(String str, String str2) throws XMLStreamException;

    public abstract void writeStartElement(String str, String str2) throws XMLStreamException;

    public abstract void writeStartElement(String str, String str2, String str3) throws XMLStreamException;

    public abstract void writeTypedAttribute(String str, String str2, String str3, AsciiValueEncoder asciiValueEncoder) throws XMLStreamException;

    protected StreamWriterBase(WriterConfig writerConfig, XmlWriter xmlWriter, WNameTable wNameTable) {
        this._config = writerConfig;
        this._xmlWriter = xmlWriter;
        this._symbols = wNameTable;
        this._cfgCheckStructure = writerConfig.willCheckStructure();
        this._cfgCheckContent = writerConfig.willCheckContent();
        this._cfgCheckAttrs = writerConfig.willCheckAttributes();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void close() throws XMLStreamException {
        _finishDocument(false);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void flush() throws XMLStreamException {
        try {
            this._xmlWriter.flush();
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    public Object getProperty(String str) {
        return this._config.getProperty(str, true);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void setNamespaceContext(NamespaceContext namespaceContext) throws XMLStreamException {
        if (this._state != State.PROLOG) {
            throwOutputError("Called setNamespaceContext() after having already output root element.");
        }
        this._rootNsContext = namespaceContext;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final void setPrefix(String str, String str2) throws XMLStreamException {
        str.getClass();
        if (str.length() == 0) {
            setDefaultNamespace(str2);
            return;
        }
        str2.getClass();
        if (str.equals("xml")) {
            if (!str2.equals("http://www.w3.org/XML/1998/namespace")) {
                throwOutputError(ErrorConsts.ERR_NS_REDECL_XML, str2);
            }
        } else if (str.equals("xmlns")) {
            if (!str2.equals("http://www.w3.org/2000/xmlns/")) {
                throwOutputError(ErrorConsts.ERR_NS_REDECL_XMLNS, str2);
            }
        } else if (str2.equals("http://www.w3.org/XML/1998/namespace")) {
            throwOutputError(ErrorConsts.ERR_NS_REDECL_XML_URI, str);
        } else if (str2.equals("http://www.w3.org/2000/xmlns/")) {
            throwOutputError(ErrorConsts.ERR_NS_REDECL_XMLNS_URI, str);
        }
        if (str2.length() == 0 && !this._config.isXml11()) {
            throwOutputError(ErrorConsts.ERR_NS_EMPTY);
        }
        _setPrefix(str, str2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final void writeAttribute(String str, String str2) throws XMLStreamException {
        if (!this._stateStartElementOpen) {
            throwOutputError(ErrorConsts.WERR_ATTR_NO_ELEM);
        }
        _writeAttribute(this._symbols.findSymbol(str), str2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.validation.XMLValidationException */
    public void writeCData(String str) throws XMLValidationException, XMLStreamException {
        XMLValidator xMLValidator;
        if (this._cfgCDataAsText) {
            writeCharacters(str);
            return;
        }
        _verifyWriteCData();
        if (this._vldContent == 3 && (xMLValidator = this._validator) != null) {
            xMLValidator.validateText(str, false);
        }
        try {
            int iWriteCData = this._xmlWriter.writeCData(str);
            if (iWriteCData >= 0) {
                _reportNwfContent(ErrorConsts.WERR_CDATA_CONTENT, Integer.valueOf(iWriteCData));
            }
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.validation.XMLValidationException */
    public void writeCharacters(char[] cArr, int i, int i2) throws XMLValidationException, XMLStreamException {
        XMLValidator xMLValidator;
        this._stateAnyOutput = true;
        if (this._stateStartElementOpen) {
            _closeStartElement(this._stateEmptyElement);
        }
        if (inPrologOrEpilog()) {
            writeSpace(cArr, i, i2);
            return;
        }
        int i3 = this._vldContent;
        if (i3 <= 1) {
            if (i3 == 0 || !TextUtil.isAllWhitespace(cArr, i, i2, this._config.isXml11())) {
                _reportInvalidContent(4);
            }
        } else if (i3 == 3 && (xMLValidator = this._validator) != null) {
            xMLValidator.validateText(cArr, i, i2, false);
        }
        if (i2 > 0) {
            try {
                this._xmlWriter.writeCharacters(cArr, i, i2);
            } catch (IOException e) {
                throw new IoStreamException(e);
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.validation.XMLValidationException */
    public void writeCharacters(String str) throws XMLValidationException, XMLStreamException {
        XMLValidator xMLValidator;
        this._stateAnyOutput = true;
        if (this._stateStartElementOpen) {
            _closeStartElement(this._stateEmptyElement);
        }
        if (inPrologOrEpilog()) {
            writeSpace(str);
            return;
        }
        int i = this._vldContent;
        if (i <= 1) {
            if (i == 0 || !TextUtil.isAllWhitespace(str, this._config.isXml11())) {
                _reportInvalidContent(4);
            }
        } else if (i == 3 && (xMLValidator = this._validator) != null) {
            xMLValidator.validateText(str, false);
        }
        try {
            this._xmlWriter.writeCharacters(str);
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.validation.XMLValidationException */
    public void writeComment(String str) throws XMLValidationException, XMLStreamException {
        this._stateAnyOutput = true;
        if (this._stateStartElementOpen) {
            _closeStartElement(this._stateEmptyElement);
        }
        if (this._vldContent == 0) {
            _reportInvalidContent(5);
        }
        try {
            int iWriteComment = this._xmlWriter.writeComment(str);
            if (iWriteComment >= 0) {
                _reportNwfContent(ErrorConsts.WERR_COMMENT_CONTENT, Integer.valueOf(iWriteComment));
            }
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final void writeDTD(String str) throws XMLStreamException {
        _verifyWriteDTD();
        this._dtdRootElemName = FinalChip.BSP_PLATFORM_Null;
        try {
            this._xmlWriter.writeDTD(str);
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.validation.XMLValidationException */
    public void writeEmptyElement(String str) throws XMLValidationException, XMLStreamException {
        _verifyStartElement(null, str);
        WName wNameFindSymbol = this._symbols.findSymbol(str);
        XMLValidator xMLValidator = this._validator;
        if (xMLValidator != null) {
            xMLValidator.validateElementStart(str, FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null);
        }
        _writeStartTag(wNameFindSymbol, true);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeEndDocument() throws XMLStreamException {
        _finishDocument(false);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeEndElement() throws XMLStreamException {
        if (this._stateStartElementOpen && this._stateEmptyElement) {
            this._stateEmptyElement = false;
            _closeStartElement(true);
        }
        if (this._state != State.TREE) {
            _reportNwfStructure("No open start element, when trying to write end element");
        }
        OutputElement outputElement = this._currElem;
        this._currElem = outputElement.getParent();
        if (this._poolSize < 8) {
            outputElement.addToPool(this._outputElemPool);
            this._outputElemPool = outputElement;
            this._poolSize++;
        }
        try {
            if (this._stateStartElementOpen) {
                this._stateStartElementOpen = false;
                this._xmlWriter.writeStartTagEmptyEnd();
            } else {
                this._xmlWriter.writeEndTag(outputElement.getName());
            }
            if (this._currElem.isRoot()) {
                this._state = State.EPILOG;
            }
            XMLValidator xMLValidator = this._validator;
            if (xMLValidator != null) {
                this._vldContent = xMLValidator.validateElementEnd(outputElement.getLocalName(), outputElement.getNonNullPrefix(), outputElement.getNonNullNamespaceURI());
            }
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.validation.XMLValidationException */
    public void writeEntityRef(String str) throws XMLValidationException, XMLStreamException {
        this._stateAnyOutput = true;
        if (this._stateStartElementOpen) {
            _closeStartElement(this._stateEmptyElement);
        }
        if (this._cfgCheckStructure && inPrologOrEpilog()) {
            _reportNwfStructure(ErrorConsts.WERR_PROLOG_ENTITY);
        }
        if (this._vldContent == 0) {
            _reportInvalidContent(9);
        }
        try {
            this._xmlWriter.writeEntityReference(this._symbols.findSymbol(str));
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.validation.XMLValidationException */
    public void writeProcessingInstruction(String str) throws XMLValidationException, XMLStreamException {
        writeProcessingInstruction(str, null);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.validation.XMLValidationException */
    public void writeProcessingInstruction(String str, String str2) throws XMLValidationException, XMLStreamException {
        this._stateAnyOutput = true;
        if (this._stateStartElementOpen) {
            _closeStartElement(this._stateEmptyElement);
        }
        if (this._vldContent == 0) {
            _reportInvalidContent(3);
        }
        try {
            int iWritePI = this._xmlWriter.writePI(this._symbols.findSymbol(str), str2);
            if (iWritePI >= 0) {
                _reportNwfContent(ErrorConsts.WERR_PI_CONTENT, Integer.valueOf(iWritePI));
            }
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeStartDocument() throws XMLStreamException {
        String actualEncoding = this._config.getActualEncoding();
        if (actualEncoding == null) {
            this._config.setActualEncodingIfNotSet("UTF-8");
            actualEncoding = "UTF-8";
        }
        _writeStartDocument("1.0", actualEncoding, null);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeStartDocument(String str) throws XMLStreamException {
        _writeStartDocument(str, this._config.getActualEncoding(), null);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeStartDocument(String str, String str2) throws XMLStreamException {
        _writeStartDocument(str2, str, null);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.validation.XMLValidationException */
    public void writeStartElement(String str) throws XMLValidationException, XMLStreamException {
        _verifyStartElement(null, str);
        WName wNameFindSymbol = this._symbols.findSymbol(str);
        XMLValidator xMLValidator = this._validator;
        if (xMLValidator != null) {
            xMLValidator.validateElementStart(str, FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null);
        }
        _writeStartTag(wNameFindSymbol, false);
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getNamespaceURI(String str) {
        NamespaceContext namespaceContext;
        String namespaceURI = this._currElem.getNamespaceURI(str);
        return (namespaceURI != null || (namespaceContext = this._rootNsContext) == null) ? namespaceURI : namespaceContext.getNamespaceURI(str);
    }

    @Override // javax.xml.namespace.NamespaceContext
    public String getPrefix(String str) {
        NamespaceContext namespaceContext;
        String prefix = this._currElem.getPrefix(str);
        return (prefix != null || (namespaceContext = this._rootNsContext) == null) ? prefix : namespaceContext.getPrefix(str);
    }

    @Override // javax.xml.namespace.NamespaceContext
    public Iterator<String> getPrefixes(String str) {
        return this._currElem.getPrefixes(str, this._rootNsContext);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeBoolean(boolean z) throws XMLStreamException {
        writeTypedElement(valueEncoderFactory().getScalarEncoder(z ? "true" : "false"));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeInt(int i) throws XMLStreamException {
        writeTypedElement(valueEncoderFactory().getEncoder(i));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeLong(long j) throws XMLStreamException {
        writeTypedElement(valueEncoderFactory().getEncoder(j));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeFloat(float f) throws XMLStreamException {
        writeTypedElement(valueEncoderFactory().getEncoder(f));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeDouble(double d) throws XMLStreamException {
        writeTypedElement(valueEncoderFactory().getEncoder(d));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeInteger(BigInteger bigInteger) throws XMLStreamException {
        writeTypedElement(valueEncoderFactory().getScalarEncoder(bigInteger.toString()));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeDecimal(BigDecimal bigDecimal) throws XMLStreamException {
        writeTypedElement(valueEncoderFactory().getScalarEncoder(bigDecimal.toString()));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeQName(QName qName) throws XMLStreamException {
        writeTypedElement(valueEncoderFactory().getScalarEncoder(_serializeQName(qName)));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final void writeIntArray(int[] iArr, int i, int i2) throws XMLStreamException {
        writeTypedElement(valueEncoderFactory().getEncoder(iArr, i, i2));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeLongArray(long[] jArr, int i, int i2) throws XMLStreamException {
        writeTypedElement(valueEncoderFactory().getEncoder(jArr, i, i2));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeFloatArray(float[] fArr, int i, int i2) throws XMLStreamException {
        writeTypedElement(valueEncoderFactory().getEncoder(fArr, i, i2));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeDoubleArray(double[] dArr, int i, int i2) throws XMLStreamException {
        writeTypedElement(valueEncoderFactory().getEncoder(dArr, i, i2));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeBinary(byte[] bArr, int i, int i2) throws XMLStreamException {
        writeTypedElement(valueEncoderFactory().getEncoder(Base64Variants.getDefaultVariant(), bArr, i, i2));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws XMLStreamException {
        writeTypedElement(valueEncoderFactory().getEncoder(base64Variant, bArr, i, i2));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private final void writeTypedElement(AsciiValueEncoder asciiValueEncoder) throws XMLStreamException {
        this._stateAnyOutput = true;
        if (this._stateStartElementOpen) {
            _closeStartElement(this._stateEmptyElement);
        }
        try {
            this._xmlWriter.writeTypedValue(asciiValueEncoder);
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final void writeBooleanAttribute(String str, String str2, String str3, boolean z) throws XMLStreamException {
        writeTypedAttribute(str, str2, str3, valueEncoderFactory().getEncoder(z));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final void writeIntAttribute(String str, String str2, String str3, int i) throws XMLStreamException {
        writeTypedAttribute(str, str2, str3, valueEncoderFactory().getEncoder(i));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final void writeLongAttribute(String str, String str2, String str3, long j) throws XMLStreamException {
        writeTypedAttribute(str, str2, str3, valueEncoderFactory().getEncoder(j));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final void writeFloatAttribute(String str, String str2, String str3, float f) throws XMLStreamException {
        writeTypedAttribute(str, str2, str3, valueEncoderFactory().getEncoder(f));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final void writeDoubleAttribute(String str, String str2, String str3, double d) throws XMLStreamException {
        writeTypedAttribute(str, str2, str3, valueEncoderFactory().getEncoder(d));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final void writeIntegerAttribute(String str, String str2, String str3, BigInteger bigInteger) throws XMLStreamException {
        writeTypedAttribute(str, str2, str3, valueEncoderFactory().getScalarEncoder(bigInteger.toString()));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final void writeDecimalAttribute(String str, String str2, String str3, BigDecimal bigDecimal) throws XMLStreamException {
        writeTypedAttribute(str, str2, str3, valueEncoderFactory().getScalarEncoder(bigDecimal.toString()));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public final void writeQNameAttribute(String str, String str2, String str3, QName qName) throws XMLStreamException {
        writeAttribute(str, str2, str3, _serializeQName(qName));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeIntArrayAttribute(String str, String str2, String str3, int[] iArr) throws XMLStreamException {
        writeTypedAttribute(str, str2, str3, valueEncoderFactory().getEncoder(iArr, 0, iArr.length));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeLongArrayAttribute(String str, String str2, String str3, long[] jArr) throws XMLStreamException {
        writeTypedAttribute(str, str2, str3, valueEncoderFactory().getEncoder(jArr, 0, jArr.length));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeFloatArrayAttribute(String str, String str2, String str3, float[] fArr) throws XMLStreamException {
        writeTypedAttribute(str, str2, str3, valueEncoderFactory().getEncoder(fArr, 0, fArr.length));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeDoubleArrayAttribute(String str, String str2, String str3, double[] dArr) throws XMLStreamException {
        writeTypedAttribute(str, str2, str3, valueEncoderFactory().getEncoder(dArr, 0, dArr.length));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeBinaryAttribute(String str, String str2, String str3, byte[] bArr) throws XMLStreamException {
        writeTypedAttribute(str, str2, str3, valueEncoderFactory().getEncoder(Base64Variants.getDefaultVariant(), bArr, 0, bArr.length));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeBinaryAttribute(Base64Variant base64Variant, String str, String str2, String str3, byte[] bArr) throws XMLStreamException {
        writeTypedAttribute(str, str2, str3, valueEncoderFactory().getEncoder(base64Variant, bArr, 0, bArr.length));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeSpace(String str) throws XMLStreamException {
        try {
            this._xmlWriter.writeSpace(str);
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeSpace(char[] cArr, int i, int i2) throws XMLStreamException {
        try {
            this._xmlWriter.writeSpace(cArr, i, i2);
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void closeCompletely() throws XMLStreamException {
        _finishDocument(true);
    }

    public boolean isPropertySupported(String str) {
        return this._config.isPropertySupported(str);
    }

    public boolean setProperty(String str, Object obj) {
        return this._config.setProperty(str, obj);
    }

    public XMLValidator validateAgainst(XMLValidationSchema xMLValidationSchema) throws XMLStreamException {
        XMLValidator xMLValidatorCreateValidator = xMLValidationSchema.createValidator(this);
        if (this._validator == null) {
            this._cfgCheckStructure = true;
            this._cfgCheckAttrs = true;
            this._validator = xMLValidatorCreateValidator;
        } else {
            this._validator = new ValidatorPair(this._validator, xMLValidatorCreateValidator);
        }
        return xMLValidatorCreateValidator;
    }

    public XMLValidator stopValidatingAgainst(XMLValidationSchema xMLValidationSchema) throws XMLStreamException {
        XMLValidator[] xMLValidatorArr = new XMLValidator[2];
        if (!ValidatorPair.removeValidator(this._validator, xMLValidationSchema, xMLValidatorArr)) {
            return null;
        }
        XMLValidator xMLValidator = xMLValidatorArr[0];
        this._validator = xMLValidatorArr[1];
        xMLValidator.validationCompleted(false);
        if (this._validator != null) {
            return xMLValidator;
        }
        resetValidationFlags();
        return xMLValidator;
    }

    public XMLValidator stopValidatingAgainst(XMLValidator xMLValidator) throws XMLStreamException {
        XMLValidator[] xMLValidatorArr = new XMLValidator[2];
        if (!ValidatorPair.removeValidator(this._validator, xMLValidator, xMLValidatorArr)) {
            return null;
        }
        XMLValidator xMLValidator2 = xMLValidatorArr[0];
        this._validator = xMLValidatorArr[1];
        xMLValidator2.validationCompleted(false);
        if (this._validator != null) {
            return xMLValidator2;
        }
        resetValidationFlags();
        return xMLValidator2;
    }

    public ValidationProblemHandler setValidationProblemHandler(ValidationProblemHandler validationProblemHandler) {
        ValidationProblemHandler validationProblemHandler2 = this._vldProblemHandler;
        this._vldProblemHandler = validationProblemHandler;
        return validationProblemHandler2;
    }

    private void resetValidationFlags() {
        this._cfgCheckStructure = this._config.willCheckStructure();
        this._cfgCheckAttrs = this._config.willCheckAttributes();
    }

    public XMLStreamLocation2 getLocation() {
        return new LocationImpl(null, null, this._xmlWriter.getAbsOffset(), this._xmlWriter.getRow(), this._xmlWriter.getColumn());
    }

    public String getEncoding() {
        return this._config.getActualEncoding();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.validation.XMLValidationException */
    public void writeCData(char[] cArr, int i, int i2) throws XMLValidationException, XMLStreamException {
        if (this._cfgCDataAsText) {
            writeCharacters(cArr, i, i2);
            return;
        }
        _verifyWriteCData();
        try {
            int iWriteCData = this._xmlWriter.writeCData(cArr, i, i2);
            if (iWriteCData >= 0) {
                _reportNwfContent(ErrorConsts.WERR_CDATA_CONTENT, Integer.valueOf(iWriteCData));
            }
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeDTD(DTDInfo dTDInfo) throws XMLStreamException {
        writeDTD(dTDInfo.getDTDRootName(), dTDInfo.getDTDSystemId(), dTDInfo.getDTDPublicId(), dTDInfo.getDTDInternalSubset());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeDTD(String str, String str2, String str3, String str4) throws XMLStreamException {
        _verifyWriteDTD();
        this._dtdRootElemName = str;
        try {
            this._xmlWriter.writeDTD(this._symbols.findSymbol(str), str2, str3, str4);
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeFullEndElement() throws XMLStreamException {
        if (this._stateStartElementOpen && this._stateEmptyElement) {
            this._stateEmptyElement = false;
            _closeStartElement(true);
        }
        writeEndElement();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeStartDocument(String str, String str2, boolean z) throws XMLStreamException {
        _writeStartDocument(str, str2, z ? XmlConsts.XML_SA_YES : XmlConsts.XML_SA_NO);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeRaw(String str) throws XMLStreamException {
        this._stateAnyOutput = true;
        if (this._stateStartElementOpen) {
            _closeStartElement(this._stateEmptyElement);
        }
        try {
            this._xmlWriter.writeRaw(str, 0, str.length());
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeRaw(String str, int i, int i2) throws XMLStreamException {
        this._stateAnyOutput = true;
        if (this._stateStartElementOpen) {
            _closeStartElement(this._stateEmptyElement);
        }
        try {
            this._xmlWriter.writeRaw(str, i, i2);
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void writeRaw(char[] cArr, int i, int i2) throws XMLStreamException {
        this._stateAnyOutput = true;
        if (this._stateStartElementOpen) {
            _closeStartElement(this._stateEmptyElement);
        }
        try {
            this._xmlWriter.writeRaw(cArr, i, i2);
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    public String getXmlVersion() {
        return this._config.isXml11() ? XmlConsts.XML_V_11_STR : "1.0";
    }

    public QName getCurrentElementName() {
        return this._currElem.getQName();
    }

    public Location getValidationLocation() {
        return getLocation();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.validation.XMLValidationException */
    public void reportProblem(XMLValidationProblem xMLValidationProblem) throws XMLValidationException, XMLStreamException {
        ValidationProblemHandler validationProblemHandler = this._vldProblemHandler;
        if (validationProblemHandler != null) {
            validationProblemHandler.reportProblem(xMLValidationProblem);
        } else if (xMLValidationProblem.getSeverity() >= 2) {
            throw ValidationException.create(xMLValidationProblem);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void _closeStartElement(boolean z) throws XMLStreamException {
        this._stateStartElementOpen = false;
        try {
            if (z) {
                this._xmlWriter.writeStartTagEmptyEnd();
            } else {
                this._xmlWriter.writeStartTagEnd();
            }
            if (z) {
                OutputElement outputElement = this._currElem;
                OutputElement parent = outputElement.getParent();
                this._currElem = parent;
                if (parent.isRoot()) {
                    this._state = State.EPILOG;
                }
                if (this._poolSize < 8) {
                    outputElement.addToPool(this._outputElemPool);
                    this._outputElemPool = outputElement;
                    this._poolSize++;
                }
            }
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    protected final boolean inPrologOrEpilog() {
        return this._state != State.TREE;
    }

    protected final ValueEncoderFactory valueEncoderFactory() {
        if (this._valueEncoderFactory == null) {
            this._valueEncoderFactory = new ValueEncoderFactory();
        }
        return this._valueEncoderFactory;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final void _writeAttribute(WName wName, String str) throws XMLStreamException {
        if (this._cfgCheckAttrs) {
            _verifyWriteAttr(wName);
        }
        try {
            this._xmlWriter.writeAttribute(wName, str);
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final void _writeAttribute(WName wName, AsciiValueEncoder asciiValueEncoder) throws XMLStreamException {
        if (this._cfgCheckAttrs) {
            _verifyWriteAttr(wName);
        }
        try {
            this._xmlWriter.writeAttribute(wName, asciiValueEncoder);
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final void _writeDefaultNamespace(String str) throws XMLStreamException {
        try {
            this._xmlWriter.writeAttribute(this._symbols.findSymbol("xmlns"), str);
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final void _writeNamespace(String str, String str2) throws XMLStreamException {
        try {
            this._xmlWriter.writeAttribute(this._symbols.findSymbol("xmlns", str), str2);
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void _writeStartDocument(String str, String str2, String str3) throws XMLStreamException {
        if (this._cfgCheckStructure && this._stateAnyOutput) {
            _reportNwfStructure(ErrorConsts.WERR_DUP_XML_DECL);
        }
        this._stateAnyOutput = true;
        if (this._cfgCheckContent && str != null && str.length() > 0 && !str.equals("1.0") && !str.equals(XmlConsts.XML_V_11_STR)) {
            _reportNwfContent("Illegal version argument ('" + str + "'); should only use '1.0' or '1.1'");
        }
        if (str == null || str.length() == 0) {
            str = "1.0";
        }
        if (XmlConsts.XML_V_11_STR.equals(str)) {
            this._config.enableXml11();
            this._xmlWriter.enableXml11();
        }
        if (str2 != null && str2.length() > 0) {
            this._config.setActualEncodingIfNotSet(str2);
        }
        try {
            this._xmlWriter.writeXmlDeclaration(str, str2, str3);
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void _writeStartTag(WName wName, boolean z) throws XMLStreamException {
        this._stateAnyOutput = true;
        this._stateStartElementOpen = true;
        OutputElement outputElement = this._outputElemPool;
        if (outputElement != null) {
            this._outputElemPool = outputElement.reuseAsChild(this._currElem, wName);
            this._poolSize--;
            this._currElem = outputElement;
        } else {
            this._currElem = this._currElem.createChild(wName);
        }
        try {
            this._xmlWriter.writeStartTagStart(wName);
            this._stateEmptyElement = z;
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void _writeStartTag(WName wName, boolean z, String str) throws XMLStreamException {
        this._stateAnyOutput = true;
        this._stateStartElementOpen = true;
        if (str == null) {
            str = FinalChip.BSP_PLATFORM_Null;
        }
        OutputElement outputElement = this._outputElemPool;
        if (outputElement != null) {
            this._outputElemPool = outputElement.reuseAsChild(this._currElem, wName, str);
            this._poolSize--;
            this._currElem = outputElement;
        } else {
            this._currElem = this._currElem.createChild(wName, str);
        }
        try {
            this._xmlWriter.writeStartTagStart(wName);
            this._stateEmptyElement = z;
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.validation.XMLValidationException */
    protected void _verifyStartElement(String str, String str2) throws XMLValidationException, XMLStreamException {
        if (this._stateStartElementOpen) {
            _closeStartElement(this._stateEmptyElement);
            return;
        }
        if (this._state == State.PROLOG) {
            _verifyRootElement(str, str2);
            return;
        }
        if (this._state == State.EPILOG) {
            if (this._cfgCheckStructure) {
                if (str != null) {
                    str2 = str + ":" + str2;
                }
                _reportNwfStructure(ErrorConsts.WERR_PROLOG_SECOND_ROOT, str2);
            }
            this._state = State.TREE;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final void _verifyWriteCData() throws XMLStreamException {
        this._stateAnyOutput = true;
        if (this._stateStartElementOpen) {
            _closeStartElement(this._stateEmptyElement);
        }
        if (this._cfgCheckStructure && inPrologOrEpilog()) {
            _reportNwfStructure(ErrorConsts.WERR_PROLOG_CDATA);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected final void _verifyWriteDTD() throws XMLStreamException {
        if (this._cfgCheckStructure) {
            if (this._state != State.PROLOG) {
                throw new XMLStreamException("Can not write DOCTYPE declaration (DTD) when not in prolog any more (state " + this._state + "; start element(s) written)");
            }
            if (this._dtdRootElemName != null) {
                throw new XMLStreamException("Trying to write multiple DOCTYPE declarations");
            }
        }
    }

    protected void _verifyRootElement(String str, String str2) throws XMLValidationException {
        this._state = State.TREE;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected static void throwOutputError(String str) throws XMLStreamException {
        throw new StreamExceptionBase(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected static void throwOutputError(String str, Object obj) throws XMLStreamException {
        throwOutputError(MessageFormat.format(str, obj));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected static void reportIllegalMethod(String str) throws XMLStreamException {
        throwOutputError(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected static void _reportNwfStructure(String str) throws XMLStreamException {
        throwOutputError(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected static void _reportNwfStructure(String str, Object obj) throws XMLStreamException {
        throwOutputError(str, obj);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected static void _reportNwfContent(String str) throws XMLStreamException {
        throwOutputError(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected static void _reportNwfContent(String str, Object obj) throws XMLStreamException {
        throwOutputError(str, obj);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected static void _reportNwfAttr(String str) throws XMLStreamException {
        throwOutputError(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected static void _reportNwfAttr(String str, Object obj) throws XMLStreamException {
        throwOutputError(str, obj);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected static void _reportNwfName(String str) throws XMLStreamException {
        throwOutputError(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected static void throwFromIOE(IOException iOException) throws XMLStreamException {
        throw new IoStreamException(iOException);
    }

    protected static void reportIllegalArg(String str) throws IllegalArgumentException {
        throw new IllegalArgumentException(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.validation.XMLValidationException */
    protected void _reportInvalidContent(int i) throws XMLValidationException, XMLStreamException {
        int i2 = this._vldContent;
        if (i2 == 0) {
            _reportValidationProblem(MessageFormat.format(ErrorConsts.VERR_EMPTY, this._currElem.getNameDesc(), ErrorConsts.tokenTypeDesc(i)));
            return;
        }
        if (i2 == 1) {
            _reportValidationProblem(MessageFormat.format(ErrorConsts.VERR_NON_MIXED, this._currElem.getNameDesc()));
        } else if (i2 == 3 || i2 == 4) {
            _reportValidationProblem(MessageFormat.format(ErrorConsts.VERR_ANY, this._currElem.getNameDesc(), ErrorConsts.tokenTypeDesc(i)));
        } else {
            _reportValidationProblem("Internal error: trying to report invalid content for " + i);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.codehaus.stax2.validation.XMLValidationException */
    public void _reportValidationProblem(String str) throws XMLValidationException, XMLStreamException {
        reportProblem(new XMLValidationProblem(getValidationLocation(), str, 2));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private final void _finishDocument(boolean z) throws XMLStreamException {
        if (this._state != State.EPILOG) {
            if (this._cfgCheckStructure && this._state == State.PROLOG) {
                _reportNwfStructure(ErrorConsts.WERR_PROLOG_NO_ROOT);
            }
            if (this._stateStartElementOpen) {
                _closeStartElement(this._stateEmptyElement);
            }
            while (this._state != State.EPILOG) {
                writeEndElement();
            }
        }
        if (this._symbols.maybeDirty()) {
            this._symbols.mergeToParent();
        }
        try {
            this._xmlWriter.close(z);
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("[StreamWriter: ").append(getClass()).append(", underlying outputter: ");
        XmlWriter xmlWriter = this._xmlWriter;
        return sbAppend.append(xmlWriter == null ? "NULL" : xmlWriter.toString()).toString();
    }
}
