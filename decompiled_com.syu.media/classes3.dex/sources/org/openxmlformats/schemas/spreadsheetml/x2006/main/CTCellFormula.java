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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTCellFormula extends STFormula {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTCellFormula.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcellformula3583type");

    public static final class Factory {
        private Factory() {
        }

        public static CTCellFormula newInstance() {
            return POIXMLTypeLoader.newInstance(CTCellFormula.type, (XmlOptions) null);
        }

        public static CTCellFormula newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(CTCellFormula.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCellFormula.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCellFormula.type, xmlOptions);
        }

        public static CTCellFormula parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, CTCellFormula.type, (XmlOptions) null);
        }

        public static CTCellFormula parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, CTCellFormula.type, xmlOptions);
        }

        public static CTCellFormula parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, CTCellFormula.type, (XmlOptions) null);
        }

        public static CTCellFormula parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, CTCellFormula.type, xmlOptions);
        }

        public static CTCellFormula parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, CTCellFormula.type, (XmlOptions) null);
        }

        public static CTCellFormula parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, CTCellFormula.type, xmlOptions);
        }

        public static CTCellFormula parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, CTCellFormula.type, (XmlOptions) null);
        }

        public static CTCellFormula parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, CTCellFormula.type, xmlOptions);
        }

        public static CTCellFormula parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, CTCellFormula.type, (XmlOptions) null);
        }

        public static CTCellFormula parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, CTCellFormula.type, xmlOptions);
        }

        public static CTCellFormula parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, CTCellFormula.type, (XmlOptions) null);
        }

        public static CTCellFormula parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, CTCellFormula.type, xmlOptions);
        }

        public static CTCellFormula parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, CTCellFormula.type, (XmlOptions) null);
        }

        public static CTCellFormula parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, CTCellFormula.type, xmlOptions);
        }

        public static CTCellFormula parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, CTCellFormula.type, (XmlOptions) null);
        }

        public static CTCellFormula parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, CTCellFormula.type, xmlOptions);
        }
    }

    boolean getAca();

    boolean getBx();

    boolean getCa();

    boolean getDel1();

    boolean getDel2();

    boolean getDt2D();

    boolean getDtr();

    String getR1();

    String getR2();

    String getRef();

    long getSi();

    STCellFormulaType.Enum getT();

    boolean isSetAca();

    boolean isSetBx();

    boolean isSetCa();

    boolean isSetDel1();

    boolean isSetDel2();

    boolean isSetDt2D();

    boolean isSetDtr();

    boolean isSetR1();

    boolean isSetR2();

    boolean isSetRef();

    boolean isSetSi();

    boolean isSetT();

    void setAca(boolean z);

    void setBx(boolean z);

    void setCa(boolean z);

    void setDel1(boolean z);

    void setDel2(boolean z);

    void setDt2D(boolean z);

    void setDtr(boolean z);

    void setR1(String str);

    void setR2(String str);

    void setRef(String str);

    void setSi(long j);

    void setT(STCellFormulaType.Enum r1);

    void unsetAca();

    void unsetBx();

    void unsetCa();

    void unsetDel1();

    void unsetDel2();

    void unsetDt2D();

    void unsetDtr();

    void unsetR1();

    void unsetR2();

    void unsetRef();

    void unsetSi();

    void unsetT();

    XmlBoolean xgetAca();

    XmlBoolean xgetBx();

    XmlBoolean xgetCa();

    XmlBoolean xgetDel1();

    XmlBoolean xgetDel2();

    XmlBoolean xgetDt2D();

    XmlBoolean xgetDtr();

    STCellRef xgetR1();

    STCellRef xgetR2();

    STRef xgetRef();

    XmlUnsignedInt xgetSi();

    STCellFormulaType xgetT();

    void xsetAca(XmlBoolean xmlBoolean);

    void xsetBx(XmlBoolean xmlBoolean);

    void xsetCa(XmlBoolean xmlBoolean);

    void xsetDel1(XmlBoolean xmlBoolean);

    void xsetDel2(XmlBoolean xmlBoolean);

    void xsetDt2D(XmlBoolean xmlBoolean);

    void xsetDtr(XmlBoolean xmlBoolean);

    void xsetR1(STCellRef sTCellRef);

    void xsetR2(STCellRef sTCellRef);

    void xsetRef(STRef sTRef);

    void xsetSi(XmlUnsignedInt xmlUnsignedInt);

    void xsetT(STCellFormulaType sTCellFormulaType);
}
