package org.codehaus.stax2.validation;

import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ValidatorPair extends XMLValidator {
    public static final String ATTR_TYPE_DEFAULT = "CDATA";
    protected XMLValidator mFirst;
    protected XMLValidator mSecond;

    @Override // org.codehaus.stax2.validation.XMLValidator
    public XMLValidationSchema getSchema() {
        return null;
    }

    public ValidatorPair(XMLValidator xMLValidator, XMLValidator xMLValidator2) {
        this.mFirst = xMLValidator;
        this.mSecond = xMLValidator2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.validation.XMLValidator
    public void validateElementStart(String str, String str2, String str3) throws XMLStreamException {
        this.mFirst.validateElementStart(str, str2, str3);
        this.mSecond.validateElementStart(str, str2, str3);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.validation.XMLValidator
    public String validateAttribute(String str, String str2, String str3, String str4) throws XMLStreamException {
        String strValidateAttribute = this.mFirst.validateAttribute(str, str2, str3, str4);
        if (strValidateAttribute != null) {
            str4 = strValidateAttribute;
        }
        return this.mSecond.validateAttribute(str, str2, str3, str4);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.validation.XMLValidator
    public String validateAttribute(String str, String str2, String str3, char[] cArr, int i, int i2) throws XMLStreamException {
        String strValidateAttribute = this.mFirst.validateAttribute(str, str2, str3, cArr, i, i2);
        if (strValidateAttribute != null) {
            return this.mSecond.validateAttribute(str, str2, str3, strValidateAttribute);
        }
        return this.mSecond.validateAttribute(str, str2, str3, cArr, i, i2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.validation.XMLValidator
    public int validateElementAndAttributes() throws XMLStreamException {
        int iValidateElementAndAttributes = this.mFirst.validateElementAndAttributes();
        int iValidateElementAndAttributes2 = this.mSecond.validateElementAndAttributes();
        return iValidateElementAndAttributes < iValidateElementAndAttributes2 ? iValidateElementAndAttributes : iValidateElementAndAttributes2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.validation.XMLValidator
    public int validateElementEnd(String str, String str2, String str3) throws XMLStreamException {
        int iValidateElementEnd = this.mFirst.validateElementEnd(str, str2, str3);
        int iValidateElementEnd2 = this.mSecond.validateElementEnd(str, str2, str3);
        return iValidateElementEnd < iValidateElementEnd2 ? iValidateElementEnd : iValidateElementEnd2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.validation.XMLValidator
    public void validateText(String str, boolean z) throws XMLStreamException {
        this.mFirst.validateText(str, z);
        this.mSecond.validateText(str, z);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.validation.XMLValidator
    public void validateText(char[] cArr, int i, int i2, boolean z) throws XMLStreamException {
        this.mFirst.validateText(cArr, i, i2, z);
        this.mSecond.validateText(cArr, i, i2, z);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.codehaus.stax2.validation.XMLValidator
    public void validationCompleted(boolean z) throws XMLStreamException {
        this.mFirst.validationCompleted(z);
        this.mSecond.validationCompleted(z);
    }

    @Override // org.codehaus.stax2.validation.XMLValidator
    public String getAttributeType(int i) {
        String attributeType;
        String attributeType2 = this.mFirst.getAttributeType(i);
        return ((attributeType2 == null || attributeType2.length() == 0 || attributeType2.equals(ATTR_TYPE_DEFAULT)) && (attributeType = this.mSecond.getAttributeType(i)) != null && attributeType.length() > 0) ? attributeType : attributeType2;
    }

    @Override // org.codehaus.stax2.validation.XMLValidator
    public int getIdAttrIndex() {
        int idAttrIndex = this.mFirst.getIdAttrIndex();
        return idAttrIndex < 0 ? this.mSecond.getIdAttrIndex() : idAttrIndex;
    }

    @Override // org.codehaus.stax2.validation.XMLValidator
    public int getNotationAttrIndex() {
        int notationAttrIndex = this.mFirst.getNotationAttrIndex();
        return notationAttrIndex < 0 ? this.mSecond.getNotationAttrIndex() : notationAttrIndex;
    }

    public static boolean removeValidator(XMLValidator xMLValidator, XMLValidationSchema xMLValidationSchema, XMLValidator[] xMLValidatorArr) {
        if (xMLValidator instanceof ValidatorPair) {
            return ((ValidatorPair) xMLValidator).doRemoveValidator(xMLValidationSchema, xMLValidatorArr);
        }
        if (xMLValidator.getSchema() != xMLValidationSchema) {
            return false;
        }
        xMLValidatorArr[0] = xMLValidator;
        xMLValidatorArr[1] = null;
        return true;
    }

    public static boolean removeValidator(XMLValidator xMLValidator, XMLValidator xMLValidator2, XMLValidator[] xMLValidatorArr) {
        if (xMLValidator == xMLValidator2) {
            xMLValidatorArr[0] = xMLValidator;
            xMLValidatorArr[1] = null;
            return true;
        }
        if (xMLValidator instanceof ValidatorPair) {
            return ((ValidatorPair) xMLValidator).doRemoveValidator(xMLValidator2, xMLValidatorArr);
        }
        return false;
    }

    private boolean doRemoveValidator(XMLValidationSchema xMLValidationSchema, XMLValidator[] xMLValidatorArr) {
        if (removeValidator(this.mFirst, xMLValidationSchema, xMLValidatorArr)) {
            XMLValidator xMLValidator = xMLValidatorArr[1];
            if (xMLValidator == null) {
                xMLValidatorArr[1] = this.mSecond;
            } else {
                this.mFirst = xMLValidator;
                xMLValidatorArr[1] = this;
            }
            return true;
        }
        if (!removeValidator(this.mSecond, xMLValidationSchema, xMLValidatorArr)) {
            return false;
        }
        XMLValidator xMLValidator2 = xMLValidatorArr[1];
        if (xMLValidator2 == null) {
            xMLValidatorArr[1] = this.mFirst;
        } else {
            this.mSecond = xMLValidator2;
            xMLValidatorArr[1] = this;
        }
        return true;
    }

    private boolean doRemoveValidator(XMLValidator xMLValidator, XMLValidator[] xMLValidatorArr) {
        if (removeValidator(this.mFirst, xMLValidator, xMLValidatorArr)) {
            XMLValidator xMLValidator2 = xMLValidatorArr[1];
            if (xMLValidator2 == null) {
                xMLValidatorArr[1] = this.mSecond;
            } else {
                this.mFirst = xMLValidator2;
                xMLValidatorArr[1] = this;
            }
            return true;
        }
        if (!removeValidator(this.mSecond, xMLValidator, xMLValidatorArr)) {
            return false;
        }
        XMLValidator xMLValidator3 = xMLValidatorArr[1];
        if (xMLValidator3 == null) {
            xMLValidatorArr[1] = this.mFirst;
        } else {
            this.mSecond = xMLValidator3;
            xMLValidatorArr[1] = this;
        }
        return true;
    }
}
