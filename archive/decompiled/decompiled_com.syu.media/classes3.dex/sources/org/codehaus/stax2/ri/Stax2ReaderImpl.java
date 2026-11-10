package org.codehaus.stax2.ri;

import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.codehaus.stax2.AttributeInfo;
import org.codehaus.stax2.DTDInfo;
import org.codehaus.stax2.LocationInfo;
import org.codehaus.stax2.XMLStreamLocation2;
import org.codehaus.stax2.XMLStreamReader2;
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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class Stax2ReaderImpl implements XMLStreamReader2, AttributeInfo, DTDInfo, LocationInfo {
    protected ValueDecoderFactory _decoderFactory;

    @Override // org.codehaus.stax2.AttributeInfo
    public int findAttributeIndex(String str, String str2) {
        return -1;
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public abstract int getAttributeAsArray(int i, TypedArrayDecoder typedArrayDecoder) throws XMLStreamException;

    public abstract byte[] getAttributeAsBinary(Base64Variant base64Variant, int i) throws XMLStreamException;

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public abstract int getAttributeIndex(String str, String str2);

    @Override // org.codehaus.stax2.LocationInfo
    public abstract XMLStreamLocation2 getCurrentLocation();

    @Override // org.codehaus.stax2.DTDInfo
    public String getDTDInternalSubset() {
        return null;
    }

    @Override // org.codehaus.stax2.DTDInfo
    public String getDTDPublicId() {
        return null;
    }

    @Override // org.codehaus.stax2.DTDInfo
    public String getDTDRootName() {
        return null;
    }

    @Override // org.codehaus.stax2.DTDInfo
    public String getDTDSystemId() {
        return null;
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public abstract int getDepth();

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public abstract byte[] getElementAsBinary(Base64Variant base64Variant) throws XMLStreamException;

    @Override // org.codehaus.stax2.LocationInfo
    public abstract XMLStreamLocation2 getEndLocation() throws XMLStreamException;

    @Override // org.codehaus.stax2.LocationInfo
    public long getEndingByteOffset() throws XMLStreamException {
        return -1L;
    }

    @Override // org.codehaus.stax2.LocationInfo
    public long getEndingCharOffset() throws XMLStreamException {
        return -1L;
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    @Deprecated
    public Object getFeature(String str) {
        return null;
    }

    @Override // org.codehaus.stax2.AttributeInfo
    public int getIdAttributeIndex() {
        return -1;
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public final LocationInfo getLocationInfo() {
        return this;
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public abstract NamespaceContext getNonTransientNamespaceContext();

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

    @Override // org.codehaus.stax2.LocationInfo
    public abstract XMLStreamLocation2 getStartLocation();

    @Override // org.codehaus.stax2.LocationInfo
    public long getStartingByteOffset() {
        return -1L;
    }

    @Override // org.codehaus.stax2.LocationInfo
    public long getStartingCharOffset() {
        return 0L;
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public abstract boolean isEmptyElement() throws XMLStreamException;

    @Override // org.codehaus.stax2.XMLStreamReader2
    public boolean isPropertySupported(String str) {
        return false;
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public abstract int readElementAsArray(TypedArrayDecoder typedArrayDecoder) throws XMLStreamException;

    public abstract int readElementAsBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws XMLStreamException;

    @Override // org.codehaus.stax2.XMLStreamReader2
    @Deprecated
    public void setFeature(String str, Object obj) {
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public boolean setProperty(String str, Object obj) {
        return false;
    }

    @Override // org.codehaus.stax2.validation.Validatable
    public abstract ValidationProblemHandler setValidationProblemHandler(ValidationProblemHandler validationProblemHandler);

    protected Stax2ReaderImpl() {
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public void skipElement() throws XMLStreamException {
        if (getEventType() != 1) {
            throwNotStartElem();
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
        if (getEventType() != 1) {
            throwNotStartElem();
        }
        return this;
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public DTDInfo getDTDInfo() throws XMLStreamException {
        if (getEventType() != 11) {
            return null;
        }
        return this;
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public int getText(Writer writer, boolean z) throws XMLStreamException, IOException {
        char[] textCharacters = getTextCharacters();
        int textStart = getTextStart();
        int textLength = getTextLength();
        if (textLength > 0) {
            writer.write(textCharacters, textStart, textLength);
        }
        return textLength;
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public String getPrefixedName() {
        int eventType = getEventType();
        if (eventType != 1 && eventType != 2) {
            if (eventType == 3) {
                return getPITarget();
            }
            if (eventType == 9) {
                return getLocalName();
            }
            if (eventType == 11) {
                return getDTDRootName();
            }
            throw new IllegalStateException("Current state not START_ELEMENT, END_ELEMENT, ENTITY_REFERENCE, PROCESSING_INSTRUCTION or DTD");
        }
        String prefix = getPrefix();
        String localName = getLocalName();
        if (prefix == null) {
            return localName;
        }
        StringBuffer stringBuffer = new StringBuffer(localName.length() + 1 + prefix.length());
        stringBuffer.append(prefix);
        stringBuffer.append(NameUtil.COLON);
        stringBuffer.append(localName);
        return stringBuffer.toString();
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public void closeCompletely() throws XMLStreamException {
        close();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.validation.Validatable
    public XMLValidator validateAgainst(XMLValidationSchema xMLValidationSchema) throws XMLStreamException {
        throwUnsupported();
        return null;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.validation.Validatable
    public XMLValidator stopValidatingAgainst(XMLValidationSchema xMLValidationSchema) throws XMLStreamException {
        throwUnsupported();
        return null;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.validation.Validatable
    public XMLValidator stopValidatingAgainst(XMLValidator xMLValidator) throws XMLStreamException {
        throwUnsupported();
        return null;
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
    public void getElementAs(TypedValueDecoder typedValueDecoder) throws XMLStreamException {
        String elementText = getElementText();
        try {
            typedValueDecoder.decode(elementText);
        } catch (IllegalArgumentException e) {
            throw _constructTypeException(e, elementText);
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
    public int readElementAsBinary(byte[] bArr, int i, int i2) throws XMLStreamException {
        return readElementAsBinary(Base64Variants.getDefaultVariant(), bArr, i, i2);
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
    public void getAttributeAs(int i, TypedValueDecoder typedValueDecoder) throws XMLStreamException {
        String attributeValue = getAttributeValue(i);
        try {
            typedValueDecoder.decode(attributeValue);
        } catch (IllegalArgumentException e) {
            throw _constructTypeException(e, attributeValue);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int[] getAttributeAsIntArray(int i) throws XMLStreamException {
        ValueDecoderFactory.IntArrayDecoder intArrayDecoder = _decoderFactory().getIntArrayDecoder();
        getAttributeAsArray(i, intArrayDecoder);
        return intArrayDecoder.getValues();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public long[] getAttributeAsLongArray(int i) throws XMLStreamException {
        ValueDecoderFactory.LongArrayDecoder longArrayDecoder = _decoderFactory().getLongArrayDecoder();
        getAttributeAsArray(i, longArrayDecoder);
        return longArrayDecoder.getValues();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public float[] getAttributeAsFloatArray(int i) throws XMLStreamException {
        ValueDecoderFactory.FloatArrayDecoder floatArrayDecoder = _decoderFactory().getFloatArrayDecoder();
        getAttributeAsArray(i, floatArrayDecoder);
        return floatArrayDecoder.getValues();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public double[] getAttributeAsDoubleArray(int i) throws XMLStreamException {
        ValueDecoderFactory.DoubleArrayDecoder doubleArrayDecoder = _decoderFactory().getDoubleArrayDecoder();
        getAttributeAsArray(i, doubleArrayDecoder);
        return doubleArrayDecoder.getValues();
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public byte[] getAttributeAsBinary(int i) throws XMLStreamException {
        return getAttributeAsBinary(Base64Variants.getDefaultVariant(), i);
    }

    protected ValueDecoderFactory _decoderFactory() {
        if (this._decoderFactory == null) {
            this._decoderFactory = new ValueDecoderFactory();
        }
        return this._decoderFactory;
    }

    protected TypedXMLStreamException _constructTypeException(IllegalArgumentException illegalArgumentException, String str) {
        return new TypedXMLStreamException(str, illegalArgumentException.getMessage(), getStartLocation(), illegalArgumentException);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void throwUnsupported() throws XMLStreamException {
        throw new XMLStreamException("Unsupported method");
    }

    protected void throwNotStartElem() {
        throw new IllegalStateException("Current state not START_ELEMENT");
    }
}
