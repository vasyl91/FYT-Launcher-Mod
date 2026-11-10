package org.apache.xmlbeans.impl.store;

import java.util.Iterator;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import org.apache.xmlbeans.impl.soap.Detail;
import org.apache.xmlbeans.impl.soap.DetailEntry;
import org.apache.xmlbeans.impl.soap.Name;
import org.apache.xmlbeans.impl.soap.SOAPBody;
import org.apache.xmlbeans.impl.soap.SOAPBodyElement;
import org.apache.xmlbeans.impl.soap.SOAPElement;
import org.apache.xmlbeans.impl.soap.SOAPEnvelope;
import org.apache.xmlbeans.impl.soap.SOAPException;
import org.apache.xmlbeans.impl.soap.SOAPFault;
import org.apache.xmlbeans.impl.soap.SOAPHeader;
import org.apache.xmlbeans.impl.soap.SOAPHeaderElement;
import org.apache.xmlbeans.impl.soap.SOAPPart;
import org.apache.xmlbeans.impl.soap.Text;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface Saaj {
    public static final String SAAJ_IMPL = "SAAJ_IMPL";

    public interface SaajCallback {
        Element createSoapElement(QName qName, QName qName2);

        Object getSaajData(Node node);

        Element importSoapElement(Document document, Element element, boolean z, QName qName);

        void setSaajData(Node node, Object obj);
    }

    DetailEntry detail_addDetailEntry(Detail detail, Name name);

    Iterator detail_getDetailEntries(Detail detail);

    Class identifyElement(QName qName, QName qName2);

    void setCallback(SaajCallback saajCallback);

    SOAPBodyElement soapBody_addBodyElement(SOAPBody sOAPBody, Name name);

    SOAPBodyElement soapBody_addDocument(SOAPBody sOAPBody, Document document);

    SOAPFault soapBody_addFault(SOAPBody sOAPBody) throws SOAPException;

    SOAPFault soapBody_addFault(SOAPBody sOAPBody, Name name, String str) throws SOAPException;

    SOAPFault soapBody_addFault(SOAPBody sOAPBody, Name name, String str, java.util.Locale locale) throws SOAPException;

    SOAPFault soapBody_getFault(SOAPBody sOAPBody);

    boolean soapBody_hasFault(SOAPBody sOAPBody);

    SOAPElement soapElement_addAttribute(SOAPElement sOAPElement, Name name, String str) throws SOAPException;

    SOAPElement soapElement_addChildElement(SOAPElement sOAPElement, String str) throws SOAPException;

    SOAPElement soapElement_addChildElement(SOAPElement sOAPElement, String str, String str2) throws SOAPException;

    SOAPElement soapElement_addChildElement(SOAPElement sOAPElement, String str, String str2, String str3) throws SOAPException;

    SOAPElement soapElement_addChildElement(SOAPElement sOAPElement, Name name) throws SOAPException;

    SOAPElement soapElement_addChildElement(SOAPElement sOAPElement, SOAPElement sOAPElement2) throws SOAPException;

    SOAPElement soapElement_addNamespaceDeclaration(SOAPElement sOAPElement, String str, String str2);

    SOAPElement soapElement_addTextNode(SOAPElement sOAPElement, String str);

    Iterator soapElement_getAllAttributes(SOAPElement sOAPElement);

    String soapElement_getAttributeValue(SOAPElement sOAPElement, Name name);

    Iterator soapElement_getChildElements(SOAPElement sOAPElement);

    Iterator soapElement_getChildElements(SOAPElement sOAPElement, Name name);

    Name soapElement_getElementName(SOAPElement sOAPElement);

    String soapElement_getEncodingStyle(SOAPElement sOAPElement);

    Iterator soapElement_getNamespacePrefixes(SOAPElement sOAPElement);

    String soapElement_getNamespaceURI(SOAPElement sOAPElement, String str);

    Iterator soapElement_getVisibleNamespacePrefixes(SOAPElement sOAPElement);

    boolean soapElement_removeAttribute(SOAPElement sOAPElement, Name name);

    void soapElement_removeContents(SOAPElement sOAPElement);

    boolean soapElement_removeNamespaceDeclaration(SOAPElement sOAPElement, String str);

    void soapElement_setEncodingStyle(SOAPElement sOAPElement, String str);

    SOAPBody soapEnvelope_addBody(SOAPEnvelope sOAPEnvelope) throws SOAPException;

    SOAPHeader soapEnvelope_addHeader(SOAPEnvelope sOAPEnvelope) throws SOAPException;

    Name soapEnvelope_createName(SOAPEnvelope sOAPEnvelope, String str);

    Name soapEnvelope_createName(SOAPEnvelope sOAPEnvelope, String str, String str2, String str3);

    SOAPBody soapEnvelope_getBody(SOAPEnvelope sOAPEnvelope) throws SOAPException;

    SOAPHeader soapEnvelope_getHeader(SOAPEnvelope sOAPEnvelope) throws SOAPException;

    Detail soapFault_addDetail(SOAPFault sOAPFault) throws SOAPException;

    Detail soapFault_getDetail(SOAPFault sOAPFault);

    String soapFault_getFaultActor(SOAPFault sOAPFault);

    String soapFault_getFaultCode(SOAPFault sOAPFault);

    Name soapFault_getFaultCodeAsName(SOAPFault sOAPFault);

    String soapFault_getFaultString(SOAPFault sOAPFault);

    java.util.Locale soapFault_getFaultStringLocale(SOAPFault sOAPFault);

    void soapFault_setFaultActor(SOAPFault sOAPFault, String str);

    void soapFault_setFaultCode(SOAPFault sOAPFault, String str) throws SOAPException;

    void soapFault_setFaultCode(SOAPFault sOAPFault, Name name) throws SOAPException;

    void soapFault_setFaultString(SOAPFault sOAPFault, String str);

    void soapFault_setFaultString(SOAPFault sOAPFault, String str, java.util.Locale locale);

    String soapHeaderElement_getActor(SOAPHeaderElement sOAPHeaderElement);

    boolean soapHeaderElement_getMustUnderstand(SOAPHeaderElement sOAPHeaderElement);

    void soapHeaderElement_setActor(SOAPHeaderElement sOAPHeaderElement, String str);

    void soapHeaderElement_setMustUnderstand(SOAPHeaderElement sOAPHeaderElement, boolean z);

    SOAPHeaderElement soapHeader_addHeaderElement(SOAPHeader sOAPHeader, Name name);

    Iterator soapHeader_examineAllHeaderElements(SOAPHeader sOAPHeader);

    Iterator soapHeader_examineHeaderElements(SOAPHeader sOAPHeader, String str);

    Iterator soapHeader_examineMustUnderstandHeaderElements(SOAPHeader sOAPHeader, String str);

    Iterator soapHeader_extractAllHeaderElements(SOAPHeader sOAPHeader);

    Iterator soapHeader_extractHeaderElements(SOAPHeader sOAPHeader, String str);

    void soapNode_detachNode(org.apache.xmlbeans.impl.soap.Node node);

    SOAPElement soapNode_getParentElement(org.apache.xmlbeans.impl.soap.Node node);

    String soapNode_getValue(org.apache.xmlbeans.impl.soap.Node node);

    void soapNode_recycleNode(org.apache.xmlbeans.impl.soap.Node node);

    void soapNode_setParentElement(org.apache.xmlbeans.impl.soap.Node node, SOAPElement sOAPElement);

    void soapNode_setValue(org.apache.xmlbeans.impl.soap.Node node, String str);

    void soapPart_addMimeHeader(SOAPPart sOAPPart, String str, String str2);

    Iterator soapPart_getAllMimeHeaders(SOAPPart sOAPPart);

    Source soapPart_getContent(SOAPPart sOAPPart);

    SOAPEnvelope soapPart_getEnvelope(SOAPPart sOAPPart);

    Iterator soapPart_getMatchingMimeHeaders(SOAPPart sOAPPart, String[] strArr);

    String[] soapPart_getMimeHeader(SOAPPart sOAPPart, String str);

    Iterator soapPart_getNonMatchingMimeHeaders(SOAPPart sOAPPart, String[] strArr);

    void soapPart_removeAllMimeHeaders(SOAPPart sOAPPart);

    void soapPart_removeMimeHeader(SOAPPart sOAPPart, String str);

    void soapPart_setContent(SOAPPart sOAPPart, Source source);

    void soapPart_setMimeHeader(SOAPPart sOAPPart, String str, String str2);

    boolean soapText_isComment(Text text);
}
