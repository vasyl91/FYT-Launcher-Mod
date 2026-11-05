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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTCell extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTCell.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcell842btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTCell newInstance() {
            return (CTCell) POIXMLTypeLoader.newInstance(CTCell.type, (XmlOptions) null);
        }

        public static CTCell newInstance(XmlOptions xmlOptions) {
            return (CTCell) POIXMLTypeLoader.newInstance(CTCell.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCell.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCell.type, xmlOptions);
        }

        public static CTCell parse(File file) throws XmlException, IOException {
            return (CTCell) POIXMLTypeLoader.parse(file, CTCell.type, (XmlOptions) null);
        }

        public static CTCell parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCell) POIXMLTypeLoader.parse(file, CTCell.type, xmlOptions);
        }

        public static CTCell parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCell) POIXMLTypeLoader.parse(inputStream, CTCell.type, (XmlOptions) null);
        }

        public static CTCell parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCell) POIXMLTypeLoader.parse(inputStream, CTCell.type, xmlOptions);
        }

        public static CTCell parse(Reader reader) throws XmlException, IOException {
            return (CTCell) POIXMLTypeLoader.parse(reader, CTCell.type, (XmlOptions) null);
        }

        public static CTCell parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCell) POIXMLTypeLoader.parse(reader, CTCell.type, xmlOptions);
        }

        public static CTCell parse(String str) throws XmlException {
            return (CTCell) POIXMLTypeLoader.parse(str, CTCell.type, (XmlOptions) null);
        }

        public static CTCell parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCell) POIXMLTypeLoader.parse(str, CTCell.type, xmlOptions);
        }

        public static CTCell parse(URL url) throws XmlException, IOException {
            return (CTCell) POIXMLTypeLoader.parse(url, CTCell.type, (XmlOptions) null);
        }

        public static CTCell parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCell) POIXMLTypeLoader.parse(url, CTCell.type, xmlOptions);
        }

        public static CTCell parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCell) POIXMLTypeLoader.parse(xMLStreamReader, CTCell.type, (XmlOptions) null);
        }

        public static CTCell parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCell) POIXMLTypeLoader.parse(xMLStreamReader, CTCell.type, xmlOptions);
        }

        public static CTCell parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTCell) POIXMLTypeLoader.parse(xMLInputStream, CTCell.type, (XmlOptions) null);
        }

        public static CTCell parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTCell) POIXMLTypeLoader.parse(xMLInputStream, CTCell.type, xmlOptions);
        }

        public static CTCell parse(Node node) throws XmlException {
            return (CTCell) POIXMLTypeLoader.parse(node, CTCell.type, (XmlOptions) null);
        }

        public static CTCell parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCell) POIXMLTypeLoader.parse(node, CTCell.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTCellFormula addNewF();

    CTRst addNewIs();

    long getCm();

    CTExtensionList getExtLst();

    CTCellFormula getF();

    CTRst getIs();

    boolean getPh();

    String getR();

    long getS();

    STCellType.Enum getT();

    String getV();

    long getVm();

    boolean isSetCm();

    boolean isSetExtLst();

    boolean isSetF();

    boolean isSetIs();

    boolean isSetPh();

    boolean isSetR();

    boolean isSetS();

    boolean isSetT();

    boolean isSetV();

    boolean isSetVm();

    void setCm(long j);

    void setExtLst(CTExtensionList cTExtensionList);

    void setF(CTCellFormula cTCellFormula);

    void setIs(CTRst cTRst);

    void setPh(boolean z);

    void setR(String str);

    void setS(long j);

    void setT(STCellType.Enum r1);

    void setV(String str);

    void setVm(long j);

    void unsetCm();

    void unsetExtLst();

    void unsetF();

    void unsetIs();

    void unsetPh();

    void unsetR();

    void unsetS();

    void unsetT();

    void unsetV();

    void unsetVm();

    XmlUnsignedInt xgetCm();

    XmlBoolean xgetPh();

    STCellRef xgetR();

    XmlUnsignedInt xgetS();

    STCellType xgetT();

    STXstring xgetV();

    XmlUnsignedInt xgetVm();

    void xsetCm(XmlUnsignedInt xmlUnsignedInt);

    void xsetPh(XmlBoolean xmlBoolean);

    void xsetR(STCellRef sTCellRef);

    void xsetS(XmlUnsignedInt xmlUnsignedInt);

    void xsetT(STCellType sTCellType);

    void xsetV(STXstring sTXstring);

    void xsetVm(XmlUnsignedInt xmlUnsignedInt);
}
