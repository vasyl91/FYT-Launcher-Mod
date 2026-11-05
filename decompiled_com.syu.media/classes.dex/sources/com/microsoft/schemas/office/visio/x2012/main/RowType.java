package com.microsoft.schemas.office.visio.x2012.main;

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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface RowType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(RowType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("rowtype03d1type");

    public static final class Factory {
        private Factory() {
        }

        public static RowType newInstance() {
            return (RowType) POIXMLTypeLoader.newInstance(RowType.type, (XmlOptions) null);
        }

        public static RowType newInstance(XmlOptions xmlOptions) {
            return (RowType) POIXMLTypeLoader.newInstance(RowType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, RowType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, RowType.type, xmlOptions);
        }

        public static RowType parse(File file) throws XmlException, IOException {
            return (RowType) POIXMLTypeLoader.parse(file, RowType.type, (XmlOptions) null);
        }

        public static RowType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RowType) POIXMLTypeLoader.parse(file, RowType.type, xmlOptions);
        }

        public static RowType parse(InputStream inputStream) throws XmlException, IOException {
            return (RowType) POIXMLTypeLoader.parse(inputStream, RowType.type, (XmlOptions) null);
        }

        public static RowType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RowType) POIXMLTypeLoader.parse(inputStream, RowType.type, xmlOptions);
        }

        public static RowType parse(Reader reader) throws XmlException, IOException {
            return (RowType) POIXMLTypeLoader.parse(reader, RowType.type, (XmlOptions) null);
        }

        public static RowType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RowType) POIXMLTypeLoader.parse(reader, RowType.type, xmlOptions);
        }

        public static RowType parse(String str) throws XmlException {
            return (RowType) POIXMLTypeLoader.parse(str, RowType.type, (XmlOptions) null);
        }

        public static RowType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (RowType) POIXMLTypeLoader.parse(str, RowType.type, xmlOptions);
        }

        public static RowType parse(URL url) throws XmlException, IOException {
            return (RowType) POIXMLTypeLoader.parse(url, RowType.type, (XmlOptions) null);
        }

        public static RowType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RowType) POIXMLTypeLoader.parse(url, RowType.type, xmlOptions);
        }

        public static RowType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (RowType) POIXMLTypeLoader.parse(xMLStreamReader, RowType.type, (XmlOptions) null);
        }

        public static RowType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (RowType) POIXMLTypeLoader.parse(xMLStreamReader, RowType.type, xmlOptions);
        }

        public static RowType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (RowType) POIXMLTypeLoader.parse(xMLInputStream, RowType.type, (XmlOptions) null);
        }

        public static RowType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (RowType) POIXMLTypeLoader.parse(xMLInputStream, RowType.type, xmlOptions);
        }

        public static RowType parse(Node node) throws XmlException {
            return (RowType) POIXMLTypeLoader.parse(node, RowType.type, (XmlOptions) null);
        }

        public static RowType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (RowType) POIXMLTypeLoader.parse(node, RowType.type, xmlOptions);
        }
    }

    CellType addNewCell();

    TriggerType addNewTrigger();

    CellType getCellArray(int i);

    CellType[] getCellArray();

    List<CellType> getCellList();

    boolean getDel();

    long getIX();

    String getLocalName();

    String getN();

    String getT();

    TriggerType getTriggerArray(int i);

    TriggerType[] getTriggerArray();

    List<TriggerType> getTriggerList();

    CellType insertNewCell(int i);

    TriggerType insertNewTrigger(int i);

    boolean isSetDel();

    boolean isSetIX();

    boolean isSetLocalName();

    boolean isSetN();

    boolean isSetT();

    void removeCell(int i);

    void removeTrigger(int i);

    void setCellArray(int i, CellType cellType);

    void setCellArray(CellType[] cellTypeArr);

    void setDel(boolean z);

    void setIX(long j);

    void setLocalName(String str);

    void setN(String str);

    void setT(String str);

    void setTriggerArray(int i, TriggerType triggerType);

    void setTriggerArray(TriggerType[] triggerTypeArr);

    int sizeOfCellArray();

    int sizeOfTriggerArray();

    void unsetDel();

    void unsetIX();

    void unsetLocalName();

    void unsetN();

    void unsetT();

    XmlBoolean xgetDel();

    XmlUnsignedInt xgetIX();

    XmlString xgetLocalName();

    XmlString xgetN();

    XmlString xgetT();

    void xsetDel(XmlBoolean xmlBoolean);

    void xsetIX(XmlUnsignedInt xmlUnsignedInt);

    void xsetLocalName(XmlString xmlString);

    void xsetN(XmlString xmlString);

    void xsetT(XmlString xmlString);
}
