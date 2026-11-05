package org.apache.xmlbeans.impl.common;

import java.io.IOException;
import java.io.StringReader;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.apache.xmlbeans.XmlOptionsBean;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class SAXHelper {
    private static long lastLog;
    private static final XBLogger logger = XBLogFactory.getLogger((Class<?>) SAXHelper.class);
    public static final EntityResolver IGNORING_ENTITY_RESOLVER = new EntityResolver() { // from class: org.apache.xmlbeans.impl.common.SAXHelper.1
        @Override // org.xml.sax.EntityResolver
        public InputSource resolveEntity(String str, String str2) throws SAXException, IOException {
            return new InputSource(new StringReader(""));
        }
    };

    private SAXHelper() {
    }

    public static XMLReader newXMLReader(XmlOptionsBean xmlOptionsBean) throws ParserConfigurationException, SAXException {
        XMLReader xMLReader = saxFactory(xmlOptionsBean).newSAXParser().getXMLReader();
        xMLReader.setEntityResolver(IGNORING_ENTITY_RESOLVER);
        trySetSAXFeature(xMLReader, "http://javax.xml.XMLConstants/feature/secure-processing");
        trySetXercesSecurityManager(xMLReader, xmlOptionsBean);
        return xMLReader;
    }

    static SAXParserFactory saxFactory() {
        return saxFactory(new XmlOptionsBean());
    }

    static SAXParserFactory saxFactory(XmlOptionsBean xmlOptionsBean) {
        SAXParserFactory sAXParserFactoryNewInstance = SAXParserFactory.newInstance();
        sAXParserFactoryNewInstance.setValidating(false);
        sAXParserFactoryNewInstance.setNamespaceAware(true);
        trySetSAXFeature(sAXParserFactoryNewInstance, "http://javax.xml.XMLConstants/feature/secure-processing", true);
        trySetSAXFeature(sAXParserFactoryNewInstance, XMLBeansConstants.FEATURE_LOAD_DTD_GRAMMAR, xmlOptionsBean.isLoadDTDGrammar());
        trySetSAXFeature(sAXParserFactoryNewInstance, XMLBeansConstants.FEATURE_LOAD_EXTERNAL_DTD, xmlOptionsBean.isLoadExternalDTD());
        return sAXParserFactoryNewInstance;
    }

    private static void trySetSAXFeature(SAXParserFactory sAXParserFactory, String str, boolean z) {
        try {
            sAXParserFactory.setFeature(str, z);
        } catch (AbstractMethodError e) {
            logger.log(5, "Cannot set SAX feature because outdated XML parser in classpath", str, e);
        } catch (Exception e2) {
            logger.log(5, "SAX Feature unsupported", str, e2);
        }
    }

    private static void trySetSAXFeature(XMLReader xMLReader, String str) {
        try {
            xMLReader.setFeature(str, true);
        } catch (AbstractMethodError e) {
            logger.log(5, "Cannot set SAX feature because outdated XML parser in classpath", str, e);
        } catch (Exception e2) {
            logger.log(5, "SAX Feature unsupported", str, e2);
        }
    }

    private static void trySetXercesSecurityManager(XMLReader xMLReader, XmlOptionsBean xmlOptionsBean) {
        try {
            Object objNewInstance = Class.forName(new String[]{"org.apache.xerces.util.SecurityManager"}[0]).newInstance();
            objNewInstance.getClass().getMethod("setEntityExpansionLimit", Integer.TYPE).invoke(objNewInstance, Integer.valueOf(xmlOptionsBean.getEntityExpansionLimit()));
            xMLReader.setProperty(XMLBeansConstants.SECURITY_MANAGER, objNewInstance);
        } catch (Throwable th) {
            if (System.currentTimeMillis() > lastLog + TimeUnit.MINUTES.toMillis(5L)) {
                logger.log(5, "SAX Security Manager could not be setup [log suppressed for 5 minutes]", th);
                lastLog = System.currentTimeMillis();
            }
            try {
                xMLReader.setProperty(XMLBeansConstants.ENTITY_EXPANSION_LIMIT, Integer.valueOf(xmlOptionsBean.getEntityExpansionLimit()));
            } catch (SAXException e) {
                if (System.currentTimeMillis() > lastLog + TimeUnit.MINUTES.toMillis(5L)) {
                    logger.log(5, "SAX Security Manager could not be setup [log suppressed for 5 minutes]", e);
                    lastLog = System.currentTimeMillis();
                }
            }
        }
    }
}
