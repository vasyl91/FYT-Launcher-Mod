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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTCellAlignment extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTCellAlignment.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcellalignmentb580type");

    public static final class Factory {
        private Factory() {
        }

        public static CTCellAlignment newInstance() {
            return (CTCellAlignment) POIXMLTypeLoader.newInstance(CTCellAlignment.type, (XmlOptions) null);
        }

        public static CTCellAlignment newInstance(XmlOptions xmlOptions) {
            return (CTCellAlignment) POIXMLTypeLoader.newInstance(CTCellAlignment.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCellAlignment.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCellAlignment.type, xmlOptions);
        }

        public static CTCellAlignment parse(File file) throws XmlException, IOException {
            return (CTCellAlignment) POIXMLTypeLoader.parse(file, CTCellAlignment.type, (XmlOptions) null);
        }

        public static CTCellAlignment parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCellAlignment) POIXMLTypeLoader.parse(file, CTCellAlignment.type, xmlOptions);
        }

        public static CTCellAlignment parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCellAlignment) POIXMLTypeLoader.parse(inputStream, CTCellAlignment.type, (XmlOptions) null);
        }

        public static CTCellAlignment parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCellAlignment) POIXMLTypeLoader.parse(inputStream, CTCellAlignment.type, xmlOptions);
        }

        public static CTCellAlignment parse(Reader reader) throws XmlException, IOException {
            return (CTCellAlignment) POIXMLTypeLoader.parse(reader, CTCellAlignment.type, (XmlOptions) null);
        }

        public static CTCellAlignment parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCellAlignment) POIXMLTypeLoader.parse(reader, CTCellAlignment.type, xmlOptions);
        }

        public static CTCellAlignment parse(String str) throws XmlException {
            return (CTCellAlignment) POIXMLTypeLoader.parse(str, CTCellAlignment.type, (XmlOptions) null);
        }

        public static CTCellAlignment parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCellAlignment) POIXMLTypeLoader.parse(str, CTCellAlignment.type, xmlOptions);
        }

        public static CTCellAlignment parse(URL url) throws XmlException, IOException {
            return (CTCellAlignment) POIXMLTypeLoader.parse(url, CTCellAlignment.type, (XmlOptions) null);
        }

        public static CTCellAlignment parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCellAlignment) POIXMLTypeLoader.parse(url, CTCellAlignment.type, xmlOptions);
        }

        public static CTCellAlignment parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCellAlignment) POIXMLTypeLoader.parse(xMLStreamReader, CTCellAlignment.type, (XmlOptions) null);
        }

        public static CTCellAlignment parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCellAlignment) POIXMLTypeLoader.parse(xMLStreamReader, CTCellAlignment.type, xmlOptions);
        }

        public static CTCellAlignment parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTCellAlignment) POIXMLTypeLoader.parse(xMLInputStream, CTCellAlignment.type, (XmlOptions) null);
        }

        public static CTCellAlignment parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTCellAlignment) POIXMLTypeLoader.parse(xMLInputStream, CTCellAlignment.type, xmlOptions);
        }

        public static CTCellAlignment parse(Node node) throws XmlException {
            return (CTCellAlignment) POIXMLTypeLoader.parse(node, CTCellAlignment.type, (XmlOptions) null);
        }

        public static CTCellAlignment parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCellAlignment) POIXMLTypeLoader.parse(node, CTCellAlignment.type, xmlOptions);
        }
    }

    STHorizontalAlignment.Enum getHorizontal();

    long getIndent();

    boolean getJustifyLastLine();

    long getReadingOrder();

    int getRelativeIndent();

    boolean getShrinkToFit();

    long getTextRotation();

    STVerticalAlignment.Enum getVertical();

    boolean getWrapText();

    boolean isSetHorizontal();

    boolean isSetIndent();

    boolean isSetJustifyLastLine();

    boolean isSetReadingOrder();

    boolean isSetRelativeIndent();

    boolean isSetShrinkToFit();

    boolean isSetTextRotation();

    boolean isSetVertical();

    boolean isSetWrapText();

    void setHorizontal(STHorizontalAlignment.Enum r1);

    void setIndent(long j);

    void setJustifyLastLine(boolean z);

    void setReadingOrder(long j);

    void setRelativeIndent(int i);

    void setShrinkToFit(boolean z);

    void setTextRotation(long j);

    void setVertical(STVerticalAlignment.Enum r1);

    void setWrapText(boolean z);

    void unsetHorizontal();

    void unsetIndent();

    void unsetJustifyLastLine();

    void unsetReadingOrder();

    void unsetRelativeIndent();

    void unsetShrinkToFit();

    void unsetTextRotation();

    void unsetVertical();

    void unsetWrapText();

    STHorizontalAlignment xgetHorizontal();

    XmlUnsignedInt xgetIndent();

    XmlBoolean xgetJustifyLastLine();

    XmlUnsignedInt xgetReadingOrder();

    XmlInt xgetRelativeIndent();

    XmlBoolean xgetShrinkToFit();

    XmlUnsignedInt xgetTextRotation();

    STVerticalAlignment xgetVertical();

    XmlBoolean xgetWrapText();

    void xsetHorizontal(STHorizontalAlignment sTHorizontalAlignment);

    void xsetIndent(XmlUnsignedInt xmlUnsignedInt);

    void xsetJustifyLastLine(XmlBoolean xmlBoolean);

    void xsetReadingOrder(XmlUnsignedInt xmlUnsignedInt);

    void xsetRelativeIndent(XmlInt xmlInt);

    void xsetShrinkToFit(XmlBoolean xmlBoolean);

    void xsetTextRotation(XmlUnsignedInt xmlUnsignedInt);

    void xsetVertical(STVerticalAlignment sTVerticalAlignment);

    void xsetWrapText(XmlBoolean xmlBoolean);
}
