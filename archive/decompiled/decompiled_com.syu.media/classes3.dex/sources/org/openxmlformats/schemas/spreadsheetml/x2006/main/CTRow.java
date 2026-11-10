package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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
public interface CTRow extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTRow.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctrowdd39type");

    public static final class Factory {
        private Factory() {
        }

        public static CTRow newInstance() {
            return (CTRow) POIXMLTypeLoader.newInstance(CTRow.type, (XmlOptions) null);
        }

        public static CTRow newInstance(XmlOptions xmlOptions) {
            return (CTRow) POIXMLTypeLoader.newInstance(CTRow.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRow.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRow.type, xmlOptions);
        }

        public static CTRow parse(File file) throws XmlException, IOException {
            return (CTRow) POIXMLTypeLoader.parse(file, CTRow.type, (XmlOptions) null);
        }

        public static CTRow parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRow) POIXMLTypeLoader.parse(file, CTRow.type, xmlOptions);
        }

        public static CTRow parse(InputStream inputStream) throws XmlException, IOException {
            return (CTRow) POIXMLTypeLoader.parse(inputStream, CTRow.type, (XmlOptions) null);
        }

        public static CTRow parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRow) POIXMLTypeLoader.parse(inputStream, CTRow.type, xmlOptions);
        }

        public static CTRow parse(Reader reader) throws XmlException, IOException {
            return (CTRow) POIXMLTypeLoader.parse(reader, CTRow.type, (XmlOptions) null);
        }

        public static CTRow parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRow) POIXMLTypeLoader.parse(reader, CTRow.type, xmlOptions);
        }

        public static CTRow parse(String str) throws XmlException {
            return (CTRow) POIXMLTypeLoader.parse(str, CTRow.type, (XmlOptions) null);
        }

        public static CTRow parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTRow) POIXMLTypeLoader.parse(str, CTRow.type, xmlOptions);
        }

        public static CTRow parse(URL url) throws XmlException, IOException {
            return (CTRow) POIXMLTypeLoader.parse(url, CTRow.type, (XmlOptions) null);
        }

        public static CTRow parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRow) POIXMLTypeLoader.parse(url, CTRow.type, xmlOptions);
        }

        public static CTRow parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTRow) POIXMLTypeLoader.parse(xMLStreamReader, CTRow.type, (XmlOptions) null);
        }

        public static CTRow parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTRow) POIXMLTypeLoader.parse(xMLStreamReader, CTRow.type, xmlOptions);
        }

        public static CTRow parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTRow) POIXMLTypeLoader.parse(xMLInputStream, CTRow.type, (XmlOptions) null);
        }

        public static CTRow parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTRow) POIXMLTypeLoader.parse(xMLInputStream, CTRow.type, xmlOptions);
        }

        public static CTRow parse(Node node) throws XmlException {
            return (CTRow) POIXMLTypeLoader.parse(node, CTRow.type, (XmlOptions) null);
        }

        public static CTRow parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTRow) POIXMLTypeLoader.parse(node, CTRow.type, xmlOptions);
        }
    }

    CTCell addNewC();

    CTExtensionList addNewExtLst();

    CTCell getCArray(int i);

    CTCell[] getCArray();

    List<CTCell> getCList();

    boolean getCollapsed();

    boolean getCustomFormat();

    boolean getCustomHeight();

    CTExtensionList getExtLst();

    boolean getHidden();

    double getHt();

    short getOutlineLevel();

    boolean getPh();

    long getR();

    long getS();

    List getSpans();

    boolean getThickBot();

    boolean getThickTop();

    CTCell insertNewC(int i);

    boolean isSetCollapsed();

    boolean isSetCustomFormat();

    boolean isSetCustomHeight();

    boolean isSetExtLst();

    boolean isSetHidden();

    boolean isSetHt();

    boolean isSetOutlineLevel();

    boolean isSetPh();

    boolean isSetR();

    boolean isSetS();

    boolean isSetSpans();

    boolean isSetThickBot();

    boolean isSetThickTop();

    void removeC(int i);

    void setCArray(int i, CTCell cTCell);

    void setCArray(CTCell[] cTCellArr);

    void setCollapsed(boolean z);

    void setCustomFormat(boolean z);

    void setCustomHeight(boolean z);

    void setExtLst(CTExtensionList cTExtensionList);

    void setHidden(boolean z);

    void setHt(double d);

    void setOutlineLevel(short s);

    void setPh(boolean z);

    void setR(long j);

    void setS(long j);

    void setSpans(List list);

    void setThickBot(boolean z);

    void setThickTop(boolean z);

    int sizeOfCArray();

    void unsetCollapsed();

    void unsetCustomFormat();

    void unsetCustomHeight();

    void unsetExtLst();

    void unsetHidden();

    void unsetHt();

    void unsetOutlineLevel();

    void unsetPh();

    void unsetR();

    void unsetS();

    void unsetSpans();

    void unsetThickBot();

    void unsetThickTop();

    XmlBoolean xgetCollapsed();

    XmlBoolean xgetCustomFormat();

    XmlBoolean xgetCustomHeight();

    XmlBoolean xgetHidden();

    XmlDouble xgetHt();

    XmlUnsignedByte xgetOutlineLevel();

    XmlBoolean xgetPh();

    XmlUnsignedInt xgetR();

    XmlUnsignedInt xgetS();

    STCellSpans xgetSpans();

    XmlBoolean xgetThickBot();

    XmlBoolean xgetThickTop();

    void xsetCollapsed(XmlBoolean xmlBoolean);

    void xsetCustomFormat(XmlBoolean xmlBoolean);

    void xsetCustomHeight(XmlBoolean xmlBoolean);

    void xsetHidden(XmlBoolean xmlBoolean);

    void xsetHt(XmlDouble xmlDouble);

    void xsetOutlineLevel(XmlUnsignedByte xmlUnsignedByte);

    void xsetPh(XmlBoolean xmlBoolean);

    void xsetR(XmlUnsignedInt xmlUnsignedInt);

    void xsetS(XmlUnsignedInt xmlUnsignedInt);

    void xsetSpans(STCellSpans sTCellSpans);

    void xsetThickBot(XmlBoolean xmlBoolean);

    void xsetThickTop(XmlBoolean xmlBoolean);
}
