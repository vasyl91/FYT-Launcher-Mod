package com.microsoft.schemas.office.visio.x2012.main;

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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface PageType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(PageType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("pagetype2fcatype");

    public static final class Factory {
        private Factory() {
        }

        public static PageType newInstance() {
            return (PageType) POIXMLTypeLoader.newInstance(PageType.type, (XmlOptions) null);
        }

        public static PageType newInstance(XmlOptions xmlOptions) {
            return (PageType) POIXMLTypeLoader.newInstance(PageType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, PageType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, PageType.type, xmlOptions);
        }

        public static PageType parse(File file) throws XmlException, IOException {
            return (PageType) POIXMLTypeLoader.parse(file, PageType.type, (XmlOptions) null);
        }

        public static PageType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PageType) POIXMLTypeLoader.parse(file, PageType.type, xmlOptions);
        }

        public static PageType parse(InputStream inputStream) throws XmlException, IOException {
            return (PageType) POIXMLTypeLoader.parse(inputStream, PageType.type, (XmlOptions) null);
        }

        public static PageType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PageType) POIXMLTypeLoader.parse(inputStream, PageType.type, xmlOptions);
        }

        public static PageType parse(Reader reader) throws XmlException, IOException {
            return (PageType) POIXMLTypeLoader.parse(reader, PageType.type, (XmlOptions) null);
        }

        public static PageType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PageType) POIXMLTypeLoader.parse(reader, PageType.type, xmlOptions);
        }

        public static PageType parse(String str) throws XmlException {
            return (PageType) POIXMLTypeLoader.parse(str, PageType.type, (XmlOptions) null);
        }

        public static PageType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (PageType) POIXMLTypeLoader.parse(str, PageType.type, xmlOptions);
        }

        public static PageType parse(URL url) throws XmlException, IOException {
            return (PageType) POIXMLTypeLoader.parse(url, PageType.type, (XmlOptions) null);
        }

        public static PageType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PageType) POIXMLTypeLoader.parse(url, PageType.type, xmlOptions);
        }

        public static PageType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (PageType) POIXMLTypeLoader.parse(xMLStreamReader, PageType.type, (XmlOptions) null);
        }

        public static PageType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (PageType) POIXMLTypeLoader.parse(xMLStreamReader, PageType.type, xmlOptions);
        }

        public static PageType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (PageType) POIXMLTypeLoader.parse(xMLInputStream, PageType.type, (XmlOptions) null);
        }

        public static PageType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (PageType) POIXMLTypeLoader.parse(xMLInputStream, PageType.type, xmlOptions);
        }

        public static PageType parse(Node node) throws XmlException {
            return (PageType) POIXMLTypeLoader.parse(node, PageType.type, (XmlOptions) null);
        }

        public static PageType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (PageType) POIXMLTypeLoader.parse(node, PageType.type, xmlOptions);
        }
    }

    PageSheetType addNewPageSheet();

    RelType addNewRel();

    long getAssociatedPage();

    long getBackPage();

    boolean getBackground();

    long getID();

    boolean getIsCustomName();

    boolean getIsCustomNameU();

    String getName();

    String getNameU();

    PageSheetType getPageSheet();

    RelType getRel();

    long getReviewerID();

    double getViewCenterX();

    double getViewCenterY();

    double getViewScale();

    boolean isSetAssociatedPage();

    boolean isSetBackPage();

    boolean isSetBackground();

    boolean isSetIsCustomName();

    boolean isSetIsCustomNameU();

    boolean isSetName();

    boolean isSetNameU();

    boolean isSetPageSheet();

    boolean isSetReviewerID();

    boolean isSetViewCenterX();

    boolean isSetViewCenterY();

    boolean isSetViewScale();

    void setAssociatedPage(long j);

    void setBackPage(long j);

    void setBackground(boolean z);

    void setID(long j);

    void setIsCustomName(boolean z);

    void setIsCustomNameU(boolean z);

    void setName(String str);

    void setNameU(String str);

    void setPageSheet(PageSheetType pageSheetType);

    void setRel(RelType relType);

    void setReviewerID(long j);

    void setViewCenterX(double d);

    void setViewCenterY(double d);

    void setViewScale(double d);

    void unsetAssociatedPage();

    void unsetBackPage();

    void unsetBackground();

    void unsetIsCustomName();

    void unsetIsCustomNameU();

    void unsetName();

    void unsetNameU();

    void unsetPageSheet();

    void unsetReviewerID();

    void unsetViewCenterX();

    void unsetViewCenterY();

    void unsetViewScale();

    XmlUnsignedInt xgetAssociatedPage();

    XmlUnsignedInt xgetBackPage();

    XmlBoolean xgetBackground();

    XmlUnsignedInt xgetID();

    XmlBoolean xgetIsCustomName();

    XmlBoolean xgetIsCustomNameU();

    XmlString xgetName();

    XmlString xgetNameU();

    XmlUnsignedInt xgetReviewerID();

    XmlDouble xgetViewCenterX();

    XmlDouble xgetViewCenterY();

    XmlDouble xgetViewScale();

    void xsetAssociatedPage(XmlUnsignedInt xmlUnsignedInt);

    void xsetBackPage(XmlUnsignedInt xmlUnsignedInt);

    void xsetBackground(XmlBoolean xmlBoolean);

    void xsetID(XmlUnsignedInt xmlUnsignedInt);

    void xsetIsCustomName(XmlBoolean xmlBoolean);

    void xsetIsCustomNameU(XmlBoolean xmlBoolean);

    void xsetName(XmlString xmlString);

    void xsetNameU(XmlString xmlString);

    void xsetReviewerID(XmlUnsignedInt xmlUnsignedInt);

    void xsetViewCenterX(XmlDouble xmlDouble);

    void xsetViewCenterY(XmlDouble xmlDouble);

    void xsetViewScale(XmlDouble xmlDouble);
}
