package org.apache.poi.util;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.events.Namespace;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class DocumentHelper {
    private static final DocumentBuilderFactory documentBuilderFactory;
    private static final DocumentBuilder documentBuilderSingleton;
    private static POILogger logger = POILogFactory.getLogger((Class<?>) DocumentHelper.class);

    static {
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        documentBuilderFactory = documentBuilderFactoryNewInstance;
        documentBuilderFactoryNewInstance.setNamespaceAware(true);
        documentBuilderFactoryNewInstance.setValidating(false);
        trySetSAXFeature(documentBuilderFactoryNewInstance, "http://javax.xml.XMLConstants/feature/secure-processing", true);
        trySetXercesSecurityManager(documentBuilderFactoryNewInstance);
        documentBuilderSingleton = newDocumentBuilder();
    }

    private DocumentHelper() {
    }

    private static class DocHelperErrorHandler implements ErrorHandler {
        private DocHelperErrorHandler() {
        }

        @Override // org.xml.sax.ErrorHandler
        public void warning(SAXParseException sAXParseException) throws SAXException {
            printError(5, sAXParseException);
        }

        @Override // org.xml.sax.ErrorHandler
        public void error(SAXParseException sAXParseException) throws SAXException {
            printError(7, sAXParseException);
        }

        @Override // org.xml.sax.ErrorHandler
        public void fatalError(SAXParseException sAXParseException) throws SAXException {
            printError(9, sAXParseException);
            throw sAXParseException;
        }

        private void printError(int i, SAXParseException sAXParseException) {
            StringBuilder sb = new StringBuilder();
            String systemId = sAXParseException.getSystemId();
            if (systemId != null) {
                int iLastIndexOf = systemId.lastIndexOf(47);
                if (iLastIndexOf != -1) {
                    systemId = systemId.substring(iLastIndexOf + 1);
                }
                sb.append(systemId);
            }
            sb.append(':');
            sb.append(sAXParseException.getLineNumber());
            sb.append(':');
            sb.append(sAXParseException.getColumnNumber());
            sb.append(": ");
            sb.append(sAXParseException.getMessage());
            DocumentHelper.logger.log(i, sb.toString(), sAXParseException);
        }
    }

    public static synchronized DocumentBuilder newDocumentBuilder() {
        DocumentBuilder documentBuilderNewDocumentBuilder;
        try {
            documentBuilderNewDocumentBuilder = documentBuilderFactory.newDocumentBuilder();
            documentBuilderNewDocumentBuilder.setEntityResolver(SAXHelper.IGNORING_ENTITY_RESOLVER);
            documentBuilderNewDocumentBuilder.setErrorHandler(new DocHelperErrorHandler());
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException("cannot create a DocumentBuilder", e);
        }
        return documentBuilderNewDocumentBuilder;
    }

    private static void trySetSAXFeature(DocumentBuilderFactory documentBuilderFactory2, String str, boolean z) {
        try {
            documentBuilderFactory2.setFeature(str, z);
        } catch (AbstractMethodError e) {
            logger.log(5, "Cannot set SAX feature because outdated XML parser in classpath", str, e);
        } catch (Exception e2) {
            logger.log(5, "SAX Feature unsupported", str, e2);
        }
    }

    private static void trySetXercesSecurityManager(DocumentBuilderFactory documentBuilderFactory2) {
        String[] strArr = {"com.sun.org.apache.xerces.internal.util.SecurityManager", "org.apache.xerces.util.SecurityManager"};
        for (int i = 0; i < 2; i++) {
            try {
                Object objNewInstance = Class.forName(strArr[i]).newInstance();
                objNewInstance.getClass().getMethod("setEntityExpansionLimit", Integer.TYPE).invoke(objNewInstance, 4096);
                documentBuilderFactory2.setAttribute("http://apache.org/xml/properties/security-manager", objNewInstance);
                return;
            } catch (Throwable th) {
                logger.log(5, "SAX Security Manager could not be setup", th);
            }
        }
    }

    public static Document readDocument(InputStream inputStream) throws SAXException, IOException {
        return newDocumentBuilder().parse(inputStream);
    }

    public static Document readDocument(InputSource inputSource) throws SAXException, IOException {
        return newDocumentBuilder().parse(inputSource);
    }

    public static synchronized Document createDocument() {
        return documentBuilderSingleton.newDocument();
    }

    public static void addNamespaceDeclaration(Element element, String str, String str2) {
        element.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:" + str, str2);
    }

    public static void addNamespaceDeclaration(Element element, Namespace namespace) {
        addNamespaceDeclaration(element, namespace.getPrefix(), namespace.getNamespaceURI());
    }
}
