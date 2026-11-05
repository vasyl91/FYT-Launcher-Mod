package org.openxmlformats.schemas.presentationml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAudioCD;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAudioFile;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEmbeddedWAVAudioFile;
import org.openxmlformats.schemas.drawingml.x2006.main.CTQuickTimeFile;
import org.openxmlformats.schemas.drawingml.x2006.main.CTVideoFile;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTApplicationNonVisualDrawingProps extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTApplicationNonVisualDrawingProps.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctapplicationnonvisualdrawingprops2fb6type");

    public static final class Factory {
        private Factory() {
        }

        public static CTApplicationNonVisualDrawingProps newInstance() {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.newInstance(CTApplicationNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTApplicationNonVisualDrawingProps newInstance(XmlOptions xmlOptions) {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.newInstance(CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTApplicationNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTApplicationNonVisualDrawingProps parse(File file) throws XmlException, IOException {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(file, CTApplicationNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTApplicationNonVisualDrawingProps parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(file, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTApplicationNonVisualDrawingProps parse(InputStream inputStream) throws XmlException, IOException {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(inputStream, CTApplicationNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTApplicationNonVisualDrawingProps parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(inputStream, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTApplicationNonVisualDrawingProps parse(Reader reader) throws XmlException, IOException {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(reader, CTApplicationNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTApplicationNonVisualDrawingProps parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(reader, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTApplicationNonVisualDrawingProps parse(String str) throws XmlException {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(str, CTApplicationNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTApplicationNonVisualDrawingProps parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(str, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTApplicationNonVisualDrawingProps parse(URL url) throws XmlException, IOException {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(url, CTApplicationNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTApplicationNonVisualDrawingProps parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(url, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTApplicationNonVisualDrawingProps parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(xMLStreamReader, CTApplicationNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTApplicationNonVisualDrawingProps parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(xMLStreamReader, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTApplicationNonVisualDrawingProps parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(xMLInputStream, CTApplicationNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTApplicationNonVisualDrawingProps parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(xMLInputStream, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTApplicationNonVisualDrawingProps parse(Node node) throws XmlException {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(node, CTApplicationNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTApplicationNonVisualDrawingProps parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(node, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }
    }

    CTAudioCD addNewAudioCd();

    CTAudioFile addNewAudioFile();

    CTCustomerDataList addNewCustDataLst();

    CTExtensionList addNewExtLst();

    CTPlaceholder addNewPh();

    CTQuickTimeFile addNewQuickTimeFile();

    CTVideoFile addNewVideoFile();

    CTEmbeddedWAVAudioFile addNewWavAudioFile();

    CTAudioCD getAudioCd();

    CTAudioFile getAudioFile();

    CTCustomerDataList getCustDataLst();

    CTExtensionList getExtLst();

    boolean getIsPhoto();

    CTPlaceholder getPh();

    CTQuickTimeFile getQuickTimeFile();

    boolean getUserDrawn();

    CTVideoFile getVideoFile();

    CTEmbeddedWAVAudioFile getWavAudioFile();

    boolean isSetAudioCd();

    boolean isSetAudioFile();

    boolean isSetCustDataLst();

    boolean isSetExtLst();

    boolean isSetIsPhoto();

    boolean isSetPh();

    boolean isSetQuickTimeFile();

    boolean isSetUserDrawn();

    boolean isSetVideoFile();

    boolean isSetWavAudioFile();

    void setAudioCd(CTAudioCD cTAudioCD);

    void setAudioFile(CTAudioFile cTAudioFile);

    void setCustDataLst(CTCustomerDataList cTCustomerDataList);

    void setExtLst(CTExtensionList cTExtensionList);

    void setIsPhoto(boolean z);

    void setPh(CTPlaceholder cTPlaceholder);

    void setQuickTimeFile(CTQuickTimeFile cTQuickTimeFile);

    void setUserDrawn(boolean z);

    void setVideoFile(CTVideoFile cTVideoFile);

    void setWavAudioFile(CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFile);

    void unsetAudioCd();

    void unsetAudioFile();

    void unsetCustDataLst();

    void unsetExtLst();

    void unsetIsPhoto();

    void unsetPh();

    void unsetQuickTimeFile();

    void unsetUserDrawn();

    void unsetVideoFile();

    void unsetWavAudioFile();

    XmlBoolean xgetIsPhoto();

    XmlBoolean xgetUserDrawn();

    void xsetIsPhoto(XmlBoolean xmlBoolean);

    void xsetUserDrawn(XmlBoolean xmlBoolean);
}
