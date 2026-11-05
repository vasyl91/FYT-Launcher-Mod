package org.openxmlformats.schemas.drawingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTEffectList extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTEffectList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cteffectlist6featype");

    public static final class Factory {
        private Factory() {
        }

        public static CTEffectList newInstance() {
            return (CTEffectList) POIXMLTypeLoader.newInstance(CTEffectList.type, (XmlOptions) null);
        }

        public static CTEffectList newInstance(XmlOptions xmlOptions) {
            return (CTEffectList) POIXMLTypeLoader.newInstance(CTEffectList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTEffectList.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTEffectList.type, xmlOptions);
        }

        public static CTEffectList parse(File file) throws XmlException, IOException {
            return (CTEffectList) POIXMLTypeLoader.parse(file, CTEffectList.type, (XmlOptions) null);
        }

        public static CTEffectList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEffectList) POIXMLTypeLoader.parse(file, CTEffectList.type, xmlOptions);
        }

        public static CTEffectList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTEffectList) POIXMLTypeLoader.parse(inputStream, CTEffectList.type, (XmlOptions) null);
        }

        public static CTEffectList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEffectList) POIXMLTypeLoader.parse(inputStream, CTEffectList.type, xmlOptions);
        }

        public static CTEffectList parse(Reader reader) throws XmlException, IOException {
            return (CTEffectList) POIXMLTypeLoader.parse(reader, CTEffectList.type, (XmlOptions) null);
        }

        public static CTEffectList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEffectList) POIXMLTypeLoader.parse(reader, CTEffectList.type, xmlOptions);
        }

        public static CTEffectList parse(String str) throws XmlException {
            return (CTEffectList) POIXMLTypeLoader.parse(str, CTEffectList.type, (XmlOptions) null);
        }

        public static CTEffectList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTEffectList) POIXMLTypeLoader.parse(str, CTEffectList.type, xmlOptions);
        }

        public static CTEffectList parse(URL url) throws XmlException, IOException {
            return (CTEffectList) POIXMLTypeLoader.parse(url, CTEffectList.type, (XmlOptions) null);
        }

        public static CTEffectList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEffectList) POIXMLTypeLoader.parse(url, CTEffectList.type, xmlOptions);
        }

        public static CTEffectList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTEffectList) POIXMLTypeLoader.parse(xMLStreamReader, CTEffectList.type, (XmlOptions) null);
        }

        public static CTEffectList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTEffectList) POIXMLTypeLoader.parse(xMLStreamReader, CTEffectList.type, xmlOptions);
        }

        public static CTEffectList parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTEffectList) POIXMLTypeLoader.parse(xMLInputStream, CTEffectList.type, (XmlOptions) null);
        }

        public static CTEffectList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTEffectList) POIXMLTypeLoader.parse(xMLInputStream, CTEffectList.type, xmlOptions);
        }

        public static CTEffectList parse(Node node) throws XmlException {
            return (CTEffectList) POIXMLTypeLoader.parse(node, CTEffectList.type, (XmlOptions) null);
        }

        public static CTEffectList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTEffectList) POIXMLTypeLoader.parse(node, CTEffectList.type, xmlOptions);
        }
    }

    CTBlurEffect addNewBlur();

    CTFillOverlayEffect addNewFillOverlay();

    CTGlowEffect addNewGlow();

    CTInnerShadowEffect addNewInnerShdw();

    CTOuterShadowEffect addNewOuterShdw();

    CTPresetShadowEffect addNewPrstShdw();

    CTReflectionEffect addNewReflection();

    CTSoftEdgesEffect addNewSoftEdge();

    CTBlurEffect getBlur();

    CTFillOverlayEffect getFillOverlay();

    CTGlowEffect getGlow();

    CTInnerShadowEffect getInnerShdw();

    CTOuterShadowEffect getOuterShdw();

    CTPresetShadowEffect getPrstShdw();

    CTReflectionEffect getReflection();

    CTSoftEdgesEffect getSoftEdge();

    boolean isSetBlur();

    boolean isSetFillOverlay();

    boolean isSetGlow();

    boolean isSetInnerShdw();

    boolean isSetOuterShdw();

    boolean isSetPrstShdw();

    boolean isSetReflection();

    boolean isSetSoftEdge();

    void setBlur(CTBlurEffect cTBlurEffect);

    void setFillOverlay(CTFillOverlayEffect cTFillOverlayEffect);

    void setGlow(CTGlowEffect cTGlowEffect);

    void setInnerShdw(CTInnerShadowEffect cTInnerShadowEffect);

    void setOuterShdw(CTOuterShadowEffect cTOuterShadowEffect);

    void setPrstShdw(CTPresetShadowEffect cTPresetShadowEffect);

    void setReflection(CTReflectionEffect cTReflectionEffect);

    void setSoftEdge(CTSoftEdgesEffect cTSoftEdgesEffect);

    void unsetBlur();

    void unsetFillOverlay();

    void unsetGlow();

    void unsetInnerShdw();

    void unsetOuterShdw();

    void unsetPrstShdw();

    void unsetReflection();

    void unsetSoftEdge();
}
