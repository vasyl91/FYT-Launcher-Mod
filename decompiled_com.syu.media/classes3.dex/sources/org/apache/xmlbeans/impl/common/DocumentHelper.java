package org.apache.xmlbeans.impl.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.xmlbeans.XmlOptionsBean;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class DocumentHelper {
    private static long lastLog;
    private static XBLogger logger = XBLogFactory.getLogger((Class<?>) DocumentHelper.class);
    private static final DocumentBuilder documentBuilderSingleton = newDocumentBuilder(new XmlOptionsBean());

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
            sb.append(NameUtil.COLON);
            sb.append(sAXParseException.getLineNumber());
            sb.append(NameUtil.COLON);
            sb.append(sAXParseException.getColumnNumber());
            sb.append(": ");
            sb.append(sAXParseException.getMessage());
            DocumentHelper.logger.log(i, sb.toString(), sAXParseException);
        }
    }

    public static DocumentBuilder newDocumentBuilder(XmlOptionsBean xmlOptionsBean) {
        try {
            DocumentBuilder documentBuilderNewDocumentBuilder = documentBuilderFactory(xmlOptionsBean).newDocumentBuilder();
            documentBuilderNewDocumentBuilder.setEntityResolver(SAXHelper.IGNORING_ENTITY_RESOLVER);
            documentBuilderNewDocumentBuilder.setErrorHandler(new DocHelperErrorHandler());
            return documentBuilderNewDocumentBuilder;
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException("cannot create a DocumentBuilder", e);
        }
    }

    private static final DocumentBuilderFactory documentBuilderFactory(XmlOptionsBean xmlOptionsBean) {
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        documentBuilderFactoryNewInstance.setNamespaceAware(true);
        documentBuilderFactoryNewInstance.setValidating(false);
        trySetFeature(documentBuilderFactoryNewInstance, "http://javax.xml.XMLConstants/feature/secure-processing", true);
        trySetFeature(documentBuilderFactoryNewInstance, XMLBeansConstants.FEATURE_LOAD_DTD_GRAMMAR, xmlOptionsBean.isLoadDTDGrammar());
        trySetFeature(documentBuilderFactoryNewInstance, XMLBeansConstants.FEATURE_LOAD_EXTERNAL_DTD, xmlOptionsBean.isLoadExternalDTD());
        trySetXercesSecurityManager(documentBuilderFactoryNewInstance, xmlOptionsBean);
        return documentBuilderFactoryNewInstance;
    }

    private static void trySetFeature(DocumentBuilderFactory documentBuilderFactory, String str, boolean z) {
        try {
            documentBuilderFactory.setFeature(str, z);
        } catch (AbstractMethodError e) {
            logger.log(5, "Cannot set SAX feature because outdated XML parser in classpath", str, e);
        } catch (Exception e2) {
            logger.log(5, "SAX Feature unsupported", str, e2);
        }
    }

    private static void trySetXercesSecurityManager(DocumentBuilderFactory documentBuilderFactory, XmlOptionsBean xmlOptionsBean) {
        try {
            Object objNewInstance = Class.forName(new String[]{"org.apache.xerces.util.SecurityManager"}[0]).newInstance();
            objNewInstance.getClass().getMethod("setEntityExpansionLimit", Integer.TYPE).invoke(objNewInstance, Integer.valueOf(xmlOptionsBean.getEntityExpansionLimit()));
            documentBuilderFactory.setAttribute(XMLBeansConstants.SECURITY_MANAGER, objNewInstance);
        } catch (ClassNotFoundException unused) {
            try {
                documentBuilderFactory.setAttribute(XMLBeansConstants.ENTITY_EXPANSION_LIMIT, Integer.valueOf(xmlOptionsBean.getEntityExpansionLimit()));
            } catch (Throwable th) {
                if (System.currentTimeMillis() > lastLog + TimeUnit.MINUTES.toMillis(5L)) {
                    logger.log(5, "DocumentBuilderFactory Entity Expansion Limit could not be setup [log suppressed for 5 minutes]", th);
                    lastLog = System.currentTimeMillis();
                }
            }
        } catch (Throwable th2) {
            if (System.currentTimeMillis() > lastLog + TimeUnit.MINUTES.toMillis(5L)) {
                logger.log(5, "DocumentBuilderFactory Security Manager could not be setup [log suppressed for 5 minutes]", th2);
                lastLog = System.currentTimeMillis();
            }
            documentBuilderFactory.setAttribute(XMLBeansConstants.ENTITY_EXPANSION_LIMIT, Integer.valueOf(xmlOptionsBean.getEntityExpansionLimit()));
        }
    }

    public static Document readDocument(XmlOptionsBean xmlOptionsBean, InputStream inputStream) throws SAXException, IOException {
        return newDocumentBuilder(xmlOptionsBean).parse(inputStream);
    }

    public static Document readDocument(XmlOptionsBean xmlOptionsBean, InputSource inputSource) throws SAXException, IOException {
        return newDocumentBuilder(xmlOptionsBean).parse(inputSource);
    }

    public static Document createDocument() {
        return documentBuilderSingleton.newDocument();
    }
}
