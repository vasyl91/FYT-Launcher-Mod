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
public interface SectionType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(SectionType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sectiontype30a6type");

    public static final class Factory {
        private Factory() {
        }

        public static SectionType newInstance() {
            return (SectionType) POIXMLTypeLoader.newInstance(SectionType.type, (XmlOptions) null);
        }

        public static SectionType newInstance(XmlOptions xmlOptions) {
            return (SectionType) POIXMLTypeLoader.newInstance(SectionType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SectionType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SectionType.type, xmlOptions);
        }

        public static SectionType parse(File file) throws XmlException, IOException {
            return (SectionType) POIXMLTypeLoader.parse(file, SectionType.type, (XmlOptions) null);
        }

        public static SectionType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SectionType) POIXMLTypeLoader.parse(file, SectionType.type, xmlOptions);
        }

        public static SectionType parse(InputStream inputStream) throws XmlException, IOException {
            return (SectionType) POIXMLTypeLoader.parse(inputStream, SectionType.type, (XmlOptions) null);
        }

        public static SectionType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SectionType) POIXMLTypeLoader.parse(inputStream, SectionType.type, xmlOptions);
        }

        public static SectionType parse(Reader reader) throws XmlException, IOException {
            return (SectionType) POIXMLTypeLoader.parse(reader, SectionType.type, (XmlOptions) null);
        }

        public static SectionType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SectionType) POIXMLTypeLoader.parse(reader, SectionType.type, xmlOptions);
        }

        public static SectionType parse(String str) throws XmlException {
            return (SectionType) POIXMLTypeLoader.parse(str, SectionType.type, (XmlOptions) null);
        }

        public static SectionType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SectionType) POIXMLTypeLoader.parse(str, SectionType.type, xmlOptions);
        }

        public static SectionType parse(URL url) throws XmlException, IOException {
            return (SectionType) POIXMLTypeLoader.parse(url, SectionType.type, (XmlOptions) null);
        }

        public static SectionType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SectionType) POIXMLTypeLoader.parse(url, SectionType.type, xmlOptions);
        }

        public static SectionType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SectionType) POIXMLTypeLoader.parse(xMLStreamReader, SectionType.type, (XmlOptions) null);
        }

        public static SectionType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SectionType) POIXMLTypeLoader.parse(xMLStreamReader, SectionType.type, xmlOptions);
        }

        public static SectionType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (SectionType) POIXMLTypeLoader.parse(xMLInputStream, SectionType.type, (XmlOptions) null);
        }

        public static SectionType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (SectionType) POIXMLTypeLoader.parse(xMLInputStream, SectionType.type, xmlOptions);
        }

        public static SectionType parse(Node node) throws XmlException {
            return (SectionType) POIXMLTypeLoader.parse(node, SectionType.type, (XmlOptions) null);
        }

        public static SectionType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SectionType) POIXMLTypeLoader.parse(node, SectionType.type, xmlOptions);
        }
    }

    CellType addNewCell();

    RowType addNewRow();

    TriggerType addNewTrigger();

    CellType getCellArray(int i);

    CellType[] getCellArray();

    List<CellType> getCellList();

    boolean getDel();

    long getIX();

    String getN();

    RowType getRowArray(int i);

    RowType[] getRowArray();

    List<RowType> getRowList();

    TriggerType getTriggerArray(int i);

    TriggerType[] getTriggerArray();

    List<TriggerType> getTriggerList();

    CellType insertNewCell(int i);

    RowType insertNewRow(int i);

    TriggerType insertNewTrigger(int i);

    boolean isSetDel();

    boolean isSetIX();

    void removeCell(int i);

    void removeRow(int i);

    void removeTrigger(int i);

    void setCellArray(int i, CellType cellType);

    void setCellArray(CellType[] cellTypeArr);

    void setDel(boolean z);

    void setIX(long j);

    void setN(String str);

    void setRowArray(int i, RowType rowType);

    void setRowArray(RowType[] rowTypeArr);

    void setTriggerArray(int i, TriggerType triggerType);

    void setTriggerArray(TriggerType[] triggerTypeArr);

    int sizeOfCellArray();

    int sizeOfRowArray();

    int sizeOfTriggerArray();

    void unsetDel();

    void unsetIX();

    XmlBoolean xgetDel();

    XmlUnsignedInt xgetIX();

    XmlString xgetN();

    void xsetDel(XmlBoolean xmlBoolean);

    void xsetIX(XmlUnsignedInt xmlUnsignedInt);

    void xsetN(XmlString xmlString);
}
