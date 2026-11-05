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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface SheetType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(SheetType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sheettype25actype");

    public static final class Factory {
        private Factory() {
        }

        public static SheetType newInstance() {
            return (SheetType) POIXMLTypeLoader.newInstance(SheetType.type, (XmlOptions) null);
        }

        public static SheetType newInstance(XmlOptions xmlOptions) {
            return (SheetType) POIXMLTypeLoader.newInstance(SheetType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SheetType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SheetType.type, xmlOptions);
        }

        public static SheetType parse(File file) throws XmlException, IOException {
            return (SheetType) POIXMLTypeLoader.parse(file, SheetType.type, (XmlOptions) null);
        }

        public static SheetType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SheetType) POIXMLTypeLoader.parse(file, SheetType.type, xmlOptions);
        }

        public static SheetType parse(InputStream inputStream) throws XmlException, IOException {
            return (SheetType) POIXMLTypeLoader.parse(inputStream, SheetType.type, (XmlOptions) null);
        }

        public static SheetType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SheetType) POIXMLTypeLoader.parse(inputStream, SheetType.type, xmlOptions);
        }

        public static SheetType parse(Reader reader) throws XmlException, IOException {
            return (SheetType) POIXMLTypeLoader.parse(reader, SheetType.type, (XmlOptions) null);
        }

        public static SheetType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SheetType) POIXMLTypeLoader.parse(reader, SheetType.type, xmlOptions);
        }

        public static SheetType parse(String str) throws XmlException {
            return (SheetType) POIXMLTypeLoader.parse(str, SheetType.type, (XmlOptions) null);
        }

        public static SheetType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SheetType) POIXMLTypeLoader.parse(str, SheetType.type, xmlOptions);
        }

        public static SheetType parse(URL url) throws XmlException, IOException {
            return (SheetType) POIXMLTypeLoader.parse(url, SheetType.type, (XmlOptions) null);
        }

        public static SheetType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SheetType) POIXMLTypeLoader.parse(url, SheetType.type, xmlOptions);
        }

        public static SheetType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SheetType) POIXMLTypeLoader.parse(xMLStreamReader, SheetType.type, (XmlOptions) null);
        }

        public static SheetType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SheetType) POIXMLTypeLoader.parse(xMLStreamReader, SheetType.type, xmlOptions);
        }

        public static SheetType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (SheetType) POIXMLTypeLoader.parse(xMLInputStream, SheetType.type, (XmlOptions) null);
        }

        public static SheetType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (SheetType) POIXMLTypeLoader.parse(xMLInputStream, SheetType.type, xmlOptions);
        }

        public static SheetType parse(Node node) throws XmlException {
            return (SheetType) POIXMLTypeLoader.parse(node, SheetType.type, (XmlOptions) null);
        }

        public static SheetType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SheetType) POIXMLTypeLoader.parse(node, SheetType.type, xmlOptions);
        }
    }

    CellType addNewCell();

    SectionType addNewSection();

    TriggerType addNewTrigger();

    CellType getCellArray(int i);

    CellType[] getCellArray();

    List<CellType> getCellList();

    long getFillStyle();

    long getLineStyle();

    SectionType getSectionArray(int i);

    SectionType[] getSectionArray();

    List<SectionType> getSectionList();

    long getTextStyle();

    TriggerType getTriggerArray(int i);

    TriggerType[] getTriggerArray();

    List<TriggerType> getTriggerList();

    CellType insertNewCell(int i);

    SectionType insertNewSection(int i);

    TriggerType insertNewTrigger(int i);

    boolean isSetFillStyle();

    boolean isSetLineStyle();

    boolean isSetTextStyle();

    void removeCell(int i);

    void removeSection(int i);

    void removeTrigger(int i);

    void setCellArray(int i, CellType cellType);

    void setCellArray(CellType[] cellTypeArr);

    void setFillStyle(long j);

    void setLineStyle(long j);

    void setSectionArray(int i, SectionType sectionType);

    void setSectionArray(SectionType[] sectionTypeArr);

    void setTextStyle(long j);

    void setTriggerArray(int i, TriggerType triggerType);

    void setTriggerArray(TriggerType[] triggerTypeArr);

    int sizeOfCellArray();

    int sizeOfSectionArray();

    int sizeOfTriggerArray();

    void unsetFillStyle();

    void unsetLineStyle();

    void unsetTextStyle();

    XmlUnsignedInt xgetFillStyle();

    XmlUnsignedInt xgetLineStyle();

    XmlUnsignedInt xgetTextStyle();

    void xsetFillStyle(XmlUnsignedInt xmlUnsignedInt);

    void xsetLineStyle(XmlUnsignedInt xmlUnsignedInt);

    void xsetTextStyle(XmlUnsignedInt xmlUnsignedInt);
}
