package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTCol extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTCol.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcola95ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTCol newInstance() {
            return (CTCol) POIXMLTypeLoader.newInstance(CTCol.type, (XmlOptions) null);
        }

        public static CTCol newInstance(XmlOptions xmlOptions) {
            return (CTCol) POIXMLTypeLoader.newInstance(CTCol.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCol.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCol.type, xmlOptions);
        }

        public static CTCol parse(File file) throws XmlException, IOException {
            return (CTCol) POIXMLTypeLoader.parse(file, CTCol.type, (XmlOptions) null);
        }

        public static CTCol parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCol) POIXMLTypeLoader.parse(file, CTCol.type, xmlOptions);
        }

        public static CTCol parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCol) POIXMLTypeLoader.parse(inputStream, CTCol.type, (XmlOptions) null);
        }

        public static CTCol parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCol) POIXMLTypeLoader.parse(inputStream, CTCol.type, xmlOptions);
        }

        public static CTCol parse(Reader reader) throws XmlException, IOException {
            return (CTCol) POIXMLTypeLoader.parse(reader, CTCol.type, (XmlOptions) null);
        }

        public static CTCol parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCol) POIXMLTypeLoader.parse(reader, CTCol.type, xmlOptions);
        }

        public static CTCol parse(String str) throws XmlException {
            return (CTCol) POIXMLTypeLoader.parse(str, CTCol.type, (XmlOptions) null);
        }

        public static CTCol parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCol) POIXMLTypeLoader.parse(str, CTCol.type, xmlOptions);
        }

        public static CTCol parse(URL url) throws XmlException, IOException {
            return (CTCol) POIXMLTypeLoader.parse(url, CTCol.type, (XmlOptions) null);
        }

        public static CTCol parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCol) POIXMLTypeLoader.parse(url, CTCol.type, xmlOptions);
        }

        public static CTCol parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCol) POIXMLTypeLoader.parse(xMLStreamReader, CTCol.type, (XmlOptions) null);
        }

        public static CTCol parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCol) POIXMLTypeLoader.parse(xMLStreamReader, CTCol.type, xmlOptions);
        }

        public static CTCol parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTCol) POIXMLTypeLoader.parse(xMLInputStream, CTCol.type, (XmlOptions) null);
        }

        public static CTCol parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTCol) POIXMLTypeLoader.parse(xMLInputStream, CTCol.type, xmlOptions);
        }

        public static CTCol parse(Node node) throws XmlException {
            return (CTCol) POIXMLTypeLoader.parse(node, CTCol.type, (XmlOptions) null);
        }

        public static CTCol parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCol) POIXMLTypeLoader.parse(node, CTCol.type, xmlOptions);
        }
    }

    boolean getBestFit();

    boolean getCollapsed();

    boolean getCustomWidth();

    boolean getHidden();

    long getMax();

    long getMin();

    short getOutlineLevel();

    boolean getPhonetic();

    long getStyle();

    double getWidth();

    boolean isSetBestFit();

    boolean isSetCollapsed();

    boolean isSetCustomWidth();

    boolean isSetHidden();

    boolean isSetOutlineLevel();

    boolean isSetPhonetic();

    boolean isSetStyle();

    boolean isSetWidth();

    void setBestFit(boolean z);

    void setCollapsed(boolean z);

    void setCustomWidth(boolean z);

    void setHidden(boolean z);

    void setMax(long j);

    void setMin(long j);

    void setOutlineLevel(short s);

    void setPhonetic(boolean z);

    void setStyle(long j);

    void setWidth(double d);

    void unsetBestFit();

    void unsetCollapsed();

    void unsetCustomWidth();

    void unsetHidden();

    void unsetOutlineLevel();

    void unsetPhonetic();

    void unsetStyle();

    void unsetWidth();

    XmlBoolean xgetBestFit();

    XmlBoolean xgetCollapsed();

    XmlBoolean xgetCustomWidth();

    XmlBoolean xgetHidden();

    XmlUnsignedInt xgetMax();

    XmlUnsignedInt xgetMin();

    XmlUnsignedByte xgetOutlineLevel();

    XmlBoolean xgetPhonetic();

    XmlUnsignedInt xgetStyle();

    XmlDouble xgetWidth();

    void xsetBestFit(XmlBoolean xmlBoolean);

    void xsetCollapsed(XmlBoolean xmlBoolean);

    void xsetCustomWidth(XmlBoolean xmlBoolean);

    void xsetHidden(XmlBoolean xmlBoolean);

    void xsetMax(XmlUnsignedInt xmlUnsignedInt);

    void xsetMin(XmlUnsignedInt xmlUnsignedInt);

    void xsetOutlineLevel(XmlUnsignedByte xmlUnsignedByte);

    void xsetPhonetic(XmlBoolean xmlBoolean);

    void xsetStyle(XmlUnsignedInt xmlUnsignedInt);

    void xsetWidth(XmlDouble xmlDouble);
}
