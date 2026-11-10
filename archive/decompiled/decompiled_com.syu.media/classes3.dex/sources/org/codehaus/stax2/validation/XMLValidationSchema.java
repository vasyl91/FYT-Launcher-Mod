package org.codehaus.stax2.validation;

import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface XMLValidationSchema {
    public static final String SCHEMA_ID_DTD = "http://www.w3.org/XML/1998/namespace";
    public static final String SCHEMA_ID_RELAXNG = "http://relaxng.org/ns/structure/0.9";
    public static final String SCHEMA_ID_TREX = "http://www.thaiopensource.com/trex";
    public static final String SCHEMA_ID_W3C_SCHEMA = "http://www.w3.org/2001/XMLSchema";

    XMLValidator createValidator(ValidationContext validationContext) throws XMLStreamException;

    String getSchemaType();
}
