package org.apache.xmlbeans.impl.soap;

import java.util.Iterator;
import org.w3c.dom.Element;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface SOAPElement extends Node, Element {
    SOAPElement addAttribute(Name name, String str) throws SOAPException;

    SOAPElement addChildElement(String str) throws SOAPException;

    SOAPElement addChildElement(String str, String str2) throws SOAPException;

    SOAPElement addChildElement(String str, String str2, String str3) throws SOAPException;

    SOAPElement addChildElement(Name name) throws SOAPException;

    SOAPElement addChildElement(SOAPElement sOAPElement) throws SOAPException;

    SOAPElement addNamespaceDeclaration(String str, String str2) throws SOAPException;

    SOAPElement addTextNode(String str) throws SOAPException;

    Iterator getAllAttributes();

    String getAttributeValue(Name name);

    Iterator getChildElements();

    Iterator getChildElements(Name name);

    Name getElementName();

    String getEncodingStyle();

    Iterator getNamespacePrefixes();

    String getNamespaceURI(String str);

    Iterator getVisibleNamespacePrefixes();

    boolean removeAttribute(Name name);

    void removeContents();

    boolean removeNamespaceDeclaration(String str);

    void setEncodingStyle(String str) throws SOAPException;
}
