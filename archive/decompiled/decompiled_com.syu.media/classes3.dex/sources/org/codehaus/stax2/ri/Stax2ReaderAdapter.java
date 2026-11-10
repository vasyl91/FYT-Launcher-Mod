package org.codehaus.stax2.ri;

import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.codehaus.stax2.AttributeInfo;
import org.codehaus.stax2.DTDInfo;
import org.codehaus.stax2.LocationInfo;
import org.codehaus.stax2.XMLStreamLocation2;
import org.codehaus.stax2.XMLStreamReader2;
import org.codehaus.stax2.ri.typed.StringBase64Decoder;
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
public class Stax2ReaderAdapter extends StreamReaderDelegate implements XMLStreamReader2, AttributeInfo, DTDInfo, LocationInfo {
    static final int INT_SPACE = 32;
    private static final int MASK_GET_ELEMENT_TEXT = 4688;
    protected static final int MASK_TYPED_ACCESS_BINARY = 4178;
    protected StringBase64Decoder _base64Decoder;
    protected ValueDecoderFactory _decoderFactory;
    protected int _depth;
    protected String _typedContent;

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

    @Override // org.codehaus.stax2.XMLStreamReader2
    public final LocationInfo getLocationInfo() {
        return this;
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public NamespaceContext getNonTransientNamespaceContext() {
        return null;
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
    public long getStartingByteOffset() {
        return -1L;
    }

    @Override // org.codehaus.stax2.LocationInfo
    public long getStartingCharOffset() {
        return 0L;
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public boolean isEmptyElement() throws XMLStreamException {
        return false;
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public boolean isPropertySupported(String str) {
        return false;
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    @Deprecated
    public void setFeature(String str, Object obj) {
    }

    @Override // org.codehaus.stax2.XMLStreamReader2
    public boolean setProperty(String str, Object obj) {
        return false;
    }

    @Override // org.codehaus.stax2.validation.Validatable
    public ValidationProblemHandler setValidationProblemHandler(ValidationProblemHandler validationProblemHandler) {
        return null;
    }

    protected Stax2ReaderAdapter(XMLStreamReader xMLStreamReader) {
        super(xMLStreamReader);
        this._base64Decoder = null;
        this._depth = 0;
    }

    public static XMLStreamReader2 wrapIfNecessary(XMLStreamReader xMLStreamReader) {
        if (xMLStreamReader instanceof XMLStreamReader2) {
            return (XMLStreamReader2) xMLStreamReader;
        }
        return new Stax2ReaderAdapter(xMLStreamReader);
    }

    public int next() throws XMLStreamException {
        if (this._typedContent != null) {
            this._typedContent = null;
            return 2;
        }
        int next = super.next();
        if (next == 1) {
            this._depth++;
        } else if (next == 2) {
            this._depth--;
        }
        return next;
    }

    public String getElementText() throws XMLStreamException {
        boolean z = getEventType() == 1;
        String elementText = super.getElementText();
        if (z) {
            this._depth--;
        }
        return elementText;
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
        if (this._typedContent == null) {
            int eventType = getEventType();
            if (eventType == 2) {
                return -1;
            }
            if (eventType != 1) {
                throw new IllegalStateException("First call to readElementAsArray() must be for a START_ELEMENT");
            }
            this._typedContent = getElementText();
        }
        String str = this._typedContent;
        int length = str.length();
        int i = 0;
        int i2 = 0;
        String strSubstring = null;
        loop0: while (i < length) {
            while (str.charAt(i) <= ' ') {
                try {
                    try {
                        i++;
                        if (i >= length) {
                            break loop0;
                        }
                    } catch (IllegalArgumentException e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
            }
            int i3 = i + 1;
            while (i3 < length) {
                try {
                    if (str.charAt(i3) <= ' ') {
                        break;
                    }
                    i3++;
                } catch (IllegalArgumentException e2) {
                    e = e2;
                    i = i3;
                    throw new TypedXMLStreamException(strSubstring, e.getMessage(), getLocation(), e);
                } catch (Throwable th2) {
                    th = th2;
                    i = i3;
                    this._typedContent = length - i >= 1 ? str.substring(i) : null;
                    throw th;
                }
            }
            i2++;
            strSubstring = str.substring(i, i3);
            i = i3 + 1;
            if (typedArrayDecoder.decodeValue(strSubstring)) {
                break;
            }
        }
        this._typedContent = length - i >= 1 ? str.substring(i) : null;
        if (i2 < 1) {
            return -1;
        }
        return i2;
    }

    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int readElementAsBinary(byte[] bArr, int i, int i2) throws XMLStreamException {
        return readElementAsBinary(bArr, i, i2, Base64Variants.getDefaultVariant());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.typed.TypedXMLStreamReader
    public int readElementAsBinary(byte[] bArr, int i, int i2, Base64Variant base64Variant) throws XMLStreamException {
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
        StringBase64Decoder stringBase64Decoder_base64Decoder = _base64Decoder();
        int eventType = getEventType();
        if (((1 << eventType) & MASK_TYPED_ACCESS_BINARY) == 0) {
            if (eventType == 2) {
                if (!stringBase64Decoder_base64Decoder.hasData()) {
                    return -1;
                }
            } else {
                throwNotStartElemOrTextual(eventType);
            }
        }
        if (eventType == 1) {
            while (true) {
                int next2 = next();
                if (next2 != 2) {
                    if (next2 != 5 && next2 != 3) {
                        if (((1 << next2) & MASK_GET_ELEMENT_TEXT) == 0) {
                            throwNotStartElemOrTextual(next2);
                        }
                        stringBase64Decoder_base64Decoder.init(base64Variant, true, getText());
                        break;
                    }
                } else {
                    return -1;
                }
            }
        }
        int i3 = 0;
        while (true) {
            try {
                int iDecode = stringBase64Decoder_base64Decoder.decode(bArr, i, i2);
                i += iDecode;
                i3 += iDecode;
                i2 -= iDecode;
                if (i2 < 1 || getEventType() == 2) {
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
                        throwNotStartElemOrTextual(next);
                    }
                    stringBase64Decoder_base64Decoder.init(base64Variant, false, getText());
                }
            } catch (IllegalArgumentException e) {
                throw _constructTypeException(e, "");
            }
        }
        if (i3 > 0) {
            return i3;
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
    public void getAttributeAs(int i, TypedValueDecoder typedValueDecoder) throws XMLStreamException {
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
            throw new TypedXMLStreamException(attributeValue, e.getMessage(), getLocation(), e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.XMLStreamReader2
    public void skipElement() throws XMLStreamException {
        if (getEventType() != 1) {
            throwNotStartElem(getEventType());
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
            throwNotStartElem(getEventType());
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
    public int getDepth() {
        if (getEventType() == 2) {
            return this._depth + 1;
        }
        return this._depth;
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
        if (prefix == null || prefix.length() == 0) {
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

    @Override // org.codehaus.stax2.AttributeInfo
    public int findAttributeIndex(String str, String str2) {
        if ("".equals(str)) {
            str = null;
        }
        int attributeCount = getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (getAttributeLocalName(i).equals(str2)) {
                String attributeNamespace = getAttributeNamespace(i);
                if (str == null) {
                    if (attributeNamespace == null || attributeNamespace.length() == 0) {
                        return i;
                    }
                } else if (str.equals(attributeNamespace)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override // org.codehaus.stax2.AttributeInfo
    public int getIdAttributeIndex() {
        int attributeCount = getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if ("ID".equals(getAttributeType(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // org.codehaus.stax2.AttributeInfo
    public int getNotationAttributeIndex() {
        int attributeCount = getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if ("NOTATION".equals(getAttributeType(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // org.codehaus.stax2.DTDInfo
    public String getDTDInternalSubset() {
        if (getEventType() == 11) {
            return getText();
        }
        return null;
    }

    @Override // org.codehaus.stax2.LocationInfo
    public XMLStreamLocation2 getStartLocation() {
        return getCurrentLocation();
    }

    @Override // org.codehaus.stax2.LocationInfo
    public XMLStreamLocation2 getCurrentLocation() {
        return new Stax2LocationAdapter(getLocation());
    }

    @Override // org.codehaus.stax2.LocationInfo
    public final XMLStreamLocation2 getEndLocation() throws XMLStreamException {
        return getCurrentLocation();
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

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void throwUnsupported() throws XMLStreamException {
        throw new XMLStreamException("Unsupported method");
    }

    protected void throwNotStartElem(int i) {
        throw new IllegalStateException("Current event (" + Stax2Util.eventTypeDesc(i) + ") not START_ELEMENT");
    }

    protected void throwNotStartElemOrTextual(int i) {
        throw new IllegalStateException("Current event (" + Stax2Util.eventTypeDesc(i) + ") not START_ELEMENT, END_ELEMENT, CHARACTERS or CDATA");
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
        return new TypedXMLStreamException(str, message, startLocation, illegalArgumentException);
    }

    protected TypedXMLStreamException _constructTypeException(String str, String str2) {
        XMLStreamLocation2 startLocation = getStartLocation();
        if (startLocation == null) {
            return new TypedXMLStreamException(str2, str);
        }
        return new TypedXMLStreamException(str2, str, startLocation);
    }
}
