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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTStylesheet extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTStylesheet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctstylesheet4257type");

    public static final class Factory {
        private Factory() {
        }

        public static CTStylesheet newInstance() {
            return (CTStylesheet) POIXMLTypeLoader.newInstance(CTStylesheet.type, (XmlOptions) null);
        }

        public static CTStylesheet newInstance(XmlOptions xmlOptions) {
            return (CTStylesheet) POIXMLTypeLoader.newInstance(CTStylesheet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTStylesheet.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTStylesheet.type, xmlOptions);
        }

        public static CTStylesheet parse(File file) throws XmlException, IOException {
            return (CTStylesheet) POIXMLTypeLoader.parse(file, CTStylesheet.type, (XmlOptions) null);
        }

        public static CTStylesheet parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStylesheet) POIXMLTypeLoader.parse(file, CTStylesheet.type, xmlOptions);
        }

        public static CTStylesheet parse(InputStream inputStream) throws XmlException, IOException {
            return (CTStylesheet) POIXMLTypeLoader.parse(inputStream, CTStylesheet.type, (XmlOptions) null);
        }

        public static CTStylesheet parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStylesheet) POIXMLTypeLoader.parse(inputStream, CTStylesheet.type, xmlOptions);
        }

        public static CTStylesheet parse(Reader reader) throws XmlException, IOException {
            return (CTStylesheet) POIXMLTypeLoader.parse(reader, CTStylesheet.type, (XmlOptions) null);
        }

        public static CTStylesheet parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStylesheet) POIXMLTypeLoader.parse(reader, CTStylesheet.type, xmlOptions);
        }

        public static CTStylesheet parse(String str) throws XmlException {
            return (CTStylesheet) POIXMLTypeLoader.parse(str, CTStylesheet.type, (XmlOptions) null);
        }

        public static CTStylesheet parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTStylesheet) POIXMLTypeLoader.parse(str, CTStylesheet.type, xmlOptions);
        }

        public static CTStylesheet parse(URL url) throws XmlException, IOException {
            return (CTStylesheet) POIXMLTypeLoader.parse(url, CTStylesheet.type, (XmlOptions) null);
        }

        public static CTStylesheet parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStylesheet) POIXMLTypeLoader.parse(url, CTStylesheet.type, xmlOptions);
        }

        public static CTStylesheet parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTStylesheet) POIXMLTypeLoader.parse(xMLStreamReader, CTStylesheet.type, (XmlOptions) null);
        }

        public static CTStylesheet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTStylesheet) POIXMLTypeLoader.parse(xMLStreamReader, CTStylesheet.type, xmlOptions);
        }

        public static CTStylesheet parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTStylesheet) POIXMLTypeLoader.parse(xMLInputStream, CTStylesheet.type, (XmlOptions) null);
        }

        public static CTStylesheet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTStylesheet) POIXMLTypeLoader.parse(xMLInputStream, CTStylesheet.type, xmlOptions);
        }

        public static CTStylesheet parse(Node node) throws XmlException {
            return (CTStylesheet) POIXMLTypeLoader.parse(node, CTStylesheet.type, (XmlOptions) null);
        }

        public static CTStylesheet parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTStylesheet) POIXMLTypeLoader.parse(node, CTStylesheet.type, xmlOptions);
        }
    }

    CTBorders addNewBorders();

    CTCellStyleXfs addNewCellStyleXfs();

    CTCellStyles addNewCellStyles();

    CTCellXfs addNewCellXfs();

    CTColors addNewColors();

    CTDxfs addNewDxfs();

    CTExtensionList addNewExtLst();

    CTFills addNewFills();

    CTFonts addNewFonts();

    CTNumFmts addNewNumFmts();

    CTTableStyles addNewTableStyles();

    CTBorders getBorders();

    CTCellStyleXfs getCellStyleXfs();

    CTCellStyles getCellStyles();

    CTCellXfs getCellXfs();

    CTColors getColors();

    CTDxfs getDxfs();

    CTExtensionList getExtLst();

    CTFills getFills();

    CTFonts getFonts();

    CTNumFmts getNumFmts();

    CTTableStyles getTableStyles();

    boolean isSetBorders();

    boolean isSetCellStyleXfs();

    boolean isSetCellStyles();

    boolean isSetCellXfs();

    boolean isSetColors();

    boolean isSetDxfs();

    boolean isSetExtLst();

    boolean isSetFills();

    boolean isSetFonts();

    boolean isSetNumFmts();

    boolean isSetTableStyles();

    void setBorders(CTBorders cTBorders);

    void setCellStyleXfs(CTCellStyleXfs cTCellStyleXfs);

    void setCellStyles(CTCellStyles cTCellStyles);

    void setCellXfs(CTCellXfs cTCellXfs);

    void setColors(CTColors cTColors);

    void setDxfs(CTDxfs cTDxfs);

    void setExtLst(CTExtensionList cTExtensionList);

    void setFills(CTFills cTFills);

    void setFonts(CTFonts cTFonts);

    void setNumFmts(CTNumFmts cTNumFmts);

    void setTableStyles(CTTableStyles cTTableStyles);

    void unsetBorders();

    void unsetCellStyleXfs();

    void unsetCellStyles();

    void unsetCellXfs();

    void unsetColors();

    void unsetDxfs();

    void unsetExtLst();

    void unsetFills();

    void unsetFonts();

    void unsetNumFmts();

    void unsetTableStyles();
}
