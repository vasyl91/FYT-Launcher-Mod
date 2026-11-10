package org.codehaus.stax2.validation;

import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface Validatable {
    ValidationProblemHandler setValidationProblemHandler(ValidationProblemHandler validationProblemHandler);

    XMLValidator stopValidatingAgainst(XMLValidationSchema xMLValidationSchema) throws XMLStreamException;

    XMLValidator stopValidatingAgainst(XMLValidator xMLValidator) throws XMLStreamException;

    XMLValidator validateAgainst(XMLValidationSchema xMLValidationSchema) throws XMLStreamException;
}
