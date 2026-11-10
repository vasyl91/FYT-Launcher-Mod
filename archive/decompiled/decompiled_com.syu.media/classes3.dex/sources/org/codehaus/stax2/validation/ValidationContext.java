package org.codehaus.stax2.validation;

import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface ValidationContext {
    int addDefaultAttribute(String str, String str2, String str3, String str4) throws XMLStreamException;

    int findAttributeIndex(String str, String str2);

    int getAttributeCount();

    String getAttributeLocalName(int i);

    String getAttributeNamespace(int i);

    String getAttributePrefix(int i);

    String getAttributeType(int i);

    String getAttributeValue(int i);

    String getAttributeValue(String str, String str2);

    String getBaseUri();

    QName getCurrentElementName();

    String getNamespaceURI(String str);

    Location getValidationLocation();

    String getXmlVersion();

    boolean isNotationDeclared(String str);

    boolean isUnparsedEntityDeclared(String str);

    void reportProblem(XMLValidationProblem xMLValidationProblem) throws XMLStreamException;
}
