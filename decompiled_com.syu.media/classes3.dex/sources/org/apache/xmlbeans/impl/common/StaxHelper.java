package org.apache.xmlbeans.impl.common;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import org.apache.xmlbeans.XmlOptionsBean;
import org.codehaus.stax2.XMLStreamProperties;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class StaxHelper {
    private static final XBLogger logger = XBLogFactory.getLogger((Class<?>) StaxHelper.class);

    private StaxHelper() {
    }

    public static XMLInputFactory newXMLInputFactory(XmlOptionsBean xmlOptionsBean) {
        XMLInputFactory xMLInputFactoryNewFactory = XMLInputFactory.newFactory();
        trySetProperty(xMLInputFactoryNewFactory, XMLStreamProperties.XSP_NAMESPACE_AWARE, true);
        trySetProperty(xMLInputFactoryNewFactory, "javax.xml.stream.isValidating", false);
        trySetProperty(xMLInputFactoryNewFactory, "javax.xml.stream.supportDTD", xmlOptionsBean.isLoadDTDGrammar());
        trySetProperty(xMLInputFactoryNewFactory, "javax.xml.stream.isSupportingExternalEntities", xmlOptionsBean.isLoadExternalDTD());
        return xMLInputFactoryNewFactory;
    }

    public static XMLOutputFactory newXMLOutputFactory(XmlOptionsBean xmlOptionsBean) {
        XMLOutputFactory xMLOutputFactoryNewFactory = XMLOutputFactory.newFactory();
        trySetProperty(xMLOutputFactoryNewFactory, "javax.xml.stream.isRepairingNamespaces", true);
        return xMLOutputFactoryNewFactory;
    }

    public static XMLEventFactory newXMLEventFactory(XmlOptionsBean xmlOptionsBean) {
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
