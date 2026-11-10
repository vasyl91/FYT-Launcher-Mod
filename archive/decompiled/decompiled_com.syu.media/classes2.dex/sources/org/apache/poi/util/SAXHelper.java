package org.apache.poi.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class SAXHelper {
    private static long lastLog;
    private static final SAXParserFactory saxFactory;
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) SAXHelper.class);
    static final EntityResolver IGNORING_ENTITY_RESOLVER = new EntityResolver() { // from class: org.apache.poi.util.SAXHelper.1
        @Override // org.xml.sax.EntityResolver
        public InputSource resolveEntity(String str, String str2) throws SAXException, IOException {
            return new InputSource(new StringReader(""));
        }
    };

    static {
        try {
            SAXParserFactory sAXParserFactoryNewInstance = SAXParserFactory.newInstance();
            saxFactory = sAXParserFactoryNewInstance;
            sAXParserFactoryNewInstance.setValidating(false);
            sAXParserFactoryNewInstance.setNamespaceAware(true);
        } catch (Error e) {
            logger.log(5, "Failed to create SAXParserFactory", e);
            throw e;
        } catch (RuntimeException e2) {
            logger.log(5, "Failed to create SAXParserFactory", e2);
            throw e2;
        } catch (Exception e3) {
            logger.log(5, "Failed to create SAXParserFactory", e3);
            throw new RuntimeException("Failed to create SAXParserFactory", e3);
        }
    }

    private SAXHelper() {
    }

    public static synchronized XMLReader newXMLReader() throws ParserConfigurationException, SAXException {
        XMLReader xMLReader;
        xMLReader = saxFactory.newSAXParser().getXMLReader();
        xMLReader.setEntityResolver(IGNORING_ENTITY_RESOLVER);
        trySetSAXFeature(xMLReader, "http://javax.xml.XMLConstants/feature/secure-processing");
        trySetXercesSecurityManager(xMLReader);
        return xMLReader;
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

    private static void trySetXercesSecurityManager(XMLReader xMLReader) {
        String[] strArr = {"com.sun.org.apache.xerces.internal.util.SecurityManager", "org.apache.xerces.util.SecurityManager"};
        for (int i = 0; i < 2; i++) {
            try {
                Object objNewInstance = Class.forName(strArr[i]).newInstance();
                objNewInstance.getClass().getMethod("setEntityExpansionLimit", Integer.TYPE).invoke(objNewInstance, 4096);
                xMLReader.setProperty("http://apache.org/xml/properties/security-manager", objNewInstance);
                return;
            } catch (Throwable th) {
                if (System.currentTimeMillis() > lastLog + TimeUnit.MINUTES.toMillis(5L)) {
                    logger.log(5, "SAX Security Manager could not be setup [log suppressed for 5 minutes]", th);
                    lastLog = System.currentTimeMillis();
                }
            }
        }
    }
}
