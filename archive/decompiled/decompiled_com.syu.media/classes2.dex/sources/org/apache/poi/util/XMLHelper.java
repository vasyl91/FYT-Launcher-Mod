package org.apache.poi.util;

import javax.xml.parsers.DocumentBuilderFactory;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class XMLHelper {
    private static POILogger logger = POILogFactory.getLogger((Class<?>) XMLHelper.class);

    public static DocumentBuilderFactory getDocumentBuilderFactory() {
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        documentBuilderFactoryNewInstance.setExpandEntityReferences(false);
        trySetSAXFeature(documentBuilderFactoryNewInstance, "http://javax.xml.XMLConstants/feature/secure-processing", true);
        trySetSAXFeature(documentBuilderFactoryNewInstance, "http://xml.org/sax/features/external-general-entities", false);
        trySetSAXFeature(documentBuilderFactoryNewInstance, "http://xml.org/sax/features/external-parameter-entities", false);
        trySetSAXFeature(documentBuilderFactoryNewInstance, "http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        trySetSAXFeature(documentBuilderFactoryNewInstance, "http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
        return documentBuilderFactoryNewInstance;
    }

    private static void trySetSAXFeature(DocumentBuilderFactory documentBuilderFactory, String str, boolean z) {
        try {
            documentBuilderFactory.setFeature(str, z);
        } catch (AbstractMethodError e) {
            logger.log(5, "Cannot set SAX feature because outdated XML parser in classpath", str, e);
        } catch (Exception e2) {
            logger.log(5, "SAX Feature unsupported", str, e2);
        }
    }
}
