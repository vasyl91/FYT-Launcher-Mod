package org.apache.poi.util;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class StaxHelper {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) StaxHelper.class);

    private StaxHelper() {
    }

    public static XMLInputFactory newXMLInputFactory() {
        XMLInputFactory xMLInputFactoryNewFactory = XMLInputFactory.newFactory();
        trySetProperty(xMLInputFactoryNewFactory, XMLInputFactory.IS_NAMESPACE_AWARE, true);
        trySetProperty(xMLInputFactoryNewFactory, XMLInputFactory.IS_VALIDATING, false);
        trySetProperty(xMLInputFactoryNewFactory, XMLInputFactory.SUPPORT_DTD, false);
        trySetProperty(xMLInputFactoryNewFactory, XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
        return xMLInputFactoryNewFactory;
    }

    public static XMLOutputFactory newXMLOutputFactory() {
        XMLOutputFactory xMLOutputFactoryNewFactory = XMLOutputFactory.newFactory();
        trySetProperty(xMLOutputFactoryNewFactory, XMLOutputFactory.IS_REPAIRING_NAMESPACES, true);
        return xMLOutputFactoryNewFactory;
    }

    public static XMLEventFactory newXMLEventFactory() {
        return XMLEventFactory.newFactory();
    }

    private static void trySetProperty(XMLInputFactory xMLInputFactory, String str, boolean z) {
        try {
            xMLInputFactory.setProperty(str, Boolean.valueOf(z));
        } catch (AbstractMethodError e) {
            logger.log(5, "Cannot set StAX property because outdated StAX parser in classpath", str, e);
        } catch (Exception e2) {
            logger.log(5, "StAX Property unsupported", str, e2);
        }
    }

    private static void trySetProperty(XMLOutputFactory xMLOutputFactory, String str, boolean z) {
        try {
            xMLOutputFactory.setProperty(str, Boolean.valueOf(z));
        } catch (AbstractMethodError e) {
            logger.log(5, "Cannot set StAX property because outdated StAX parser in classpath", str, e);
        } catch (Exception e2) {
            logger.log(5, "StAX Property unsupported", str, e2);
        }
    }
}
