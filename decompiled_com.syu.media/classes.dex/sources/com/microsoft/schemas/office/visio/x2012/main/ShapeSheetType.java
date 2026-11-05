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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface ShapeSheetType extends SheetType {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(ShapeSheetType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("shapesheettype59bbtype");

    public static final class Factory {
        private Factory() {
        }

        public static ShapeSheetType newInstance() {
            return (ShapeSheetType) POIXMLTypeLoader.newInstance(ShapeSheetType.type, (XmlOptions) null);
        }

        public static ShapeSheetType newInstance(XmlOptions xmlOptions) {
            return (ShapeSheetType) POIXMLTypeLoader.newInstance(ShapeSheetType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, ShapeSheetType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, ShapeSheetType.type, xmlOptions);
        }

        public static ShapeSheetType parse(File file) throws XmlException, IOException {
            return (ShapeSheetType) POIXMLTypeLoader.parse(file, ShapeSheetType.type, (XmlOptions) null);
        }

        public static ShapeSheetType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ShapeSheetType) POIXMLTypeLoader.parse(file, ShapeSheetType.type, xmlOptions);
        }

        public static ShapeSheetType parse(InputStream inputStream) throws XmlException, IOException {
            return (ShapeSheetType) POIXMLTypeLoader.parse(inputStream, ShapeSheetType.type, (XmlOptions) null);
        }

        public static ShapeSheetType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ShapeSheetType) POIXMLTypeLoader.parse(inputStream, ShapeSheetType.type, xmlOptions);
        }

        public static ShapeSheetType parse(Reader reader) throws XmlException, IOException {
            return (ShapeSheetType) POIXMLTypeLoader.parse(reader, ShapeSheetType.type, (XmlOptions) null);
        }

        public static ShapeSheetType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ShapeSheetType) POIXMLTypeLoader.parse(reader, ShapeSheetType.type, xmlOptions);
        }

        public static ShapeSheetType parse(String str) throws XmlException {
            return (ShapeSheetType) POIXMLTypeLoader.parse(str, ShapeSheetType.type, (XmlOptions) null);
        }

        public static ShapeSheetType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ShapeSheetType) POIXMLTypeLoader.parse(str, ShapeSheetType.type, xmlOptions);
        }

        public static ShapeSheetType parse(URL url) throws XmlException, IOException {
            return (ShapeSheetType) POIXMLTypeLoader.parse(url, ShapeSheetType.type, (XmlOptions) null);
        }

        public static ShapeSheetType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ShapeSheetType) POIXMLTypeLoader.parse(url, ShapeSheetType.type, xmlOptions);
        }

        public static ShapeSheetType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ShapeSheetType) POIXMLTypeLoader.parse(xMLStreamReader, ShapeSheetType.type, (XmlOptions) null);
        }

        public static ShapeSheetType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ShapeSheetType) POIXMLTypeLoader.parse(xMLStreamReader, ShapeSheetType.type, xmlOptions);
        }

        public static ShapeSheetType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (ShapeSheetType) POIXMLTypeLoader.parse(xMLInputStream, ShapeSheetType.type, (XmlOptions) null);
        }

        public static ShapeSheetType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (ShapeSheetType) POIXMLTypeLoader.parse(xMLInputStream, ShapeSheetType.type, xmlOptions);
        }

        public static ShapeSheetType parse(Node node) throws XmlException {
            return (ShapeSheetType) POIXMLTypeLoader.parse(node, ShapeSheetType.type, (XmlOptions) null);
        }

        public static ShapeSheetType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ShapeSheetType) POIXMLTypeLoader.parse(node, ShapeSheetType.type, xmlOptions);
        }
    }

    DataType addNewData1();

    DataType addNewData2();

    DataType addNewData3();

    ForeignDataType addNewForeignData();

    ShapesType addNewShapes();

    TextType addNewText();

    DataType getData1();

    DataType getData2();

    DataType getData3();

    boolean getDel();

    ForeignDataType getForeignData();

    long getID();

    boolean getIsCustomName();

    boolean getIsCustomNameU();

    long getMaster();

    long getMasterShape();

    String getName();

    String getNameU();

    long getOriginalID();

    ShapesType getShapes();

    TextType getText();

    String getType();

    String getUniqueID();

    boolean isSetData1();

    boolean isSetData2();

    boolean isSetData3();

    boolean isSetDel();

    boolean isSetForeignData();

    boolean isSetIsCustomName();

    boolean isSetIsCustomNameU();

    boolean isSetMaster();

    boolean isSetMasterShape();

    boolean isSetName();

    boolean isSetNameU();

    boolean isSetOriginalID();

    boolean isSetShapes();

    boolean isSetText();

    boolean isSetType();

    boolean isSetUniqueID();

    void setData1(DataType dataType);

    void setData2(DataType dataType);

    void setData3(DataType dataType);

    void setDel(boolean z);

    void setForeignData(ForeignDataType foreignDataType);

    void setID(long j);

    void setIsCustomName(boolean z);

    void setIsCustomNameU(boolean z);

    void setMaster(long j);

    void setMasterShape(long j);

    void setName(String str);

    void setNameU(String str);

    void setOriginalID(long j);

    void setShapes(ShapesType shapesType);

    void setText(TextType textType);

    void setType(String str);

    void setUniqueID(String str);

    void unsetData1();

    void unsetData2();

    void unsetData3();

    void unsetDel();

    void unsetForeignData();

    void unsetIsCustomName();

    void unsetIsCustomNameU();

    void unsetMaster();

    void unsetMasterShape();

    void unsetName();

    void unsetNameU();

    void unsetOriginalID();

    void unsetShapes();

    void unsetText();

    void unsetType();

    void unsetUniqueID();

    XmlBoolean xgetDel();

    XmlUnsignedInt xgetID();

    XmlBoolean xgetIsCustomName();

    XmlBoolean xgetIsCustomNameU();

    XmlUnsignedInt xgetMaster();

    XmlUnsignedInt xgetMasterShape();

    XmlString xgetName();

    XmlString xgetNameU();

    XmlUnsignedInt xgetOriginalID();

    XmlToken xgetType();

    XmlString xgetUniqueID();

    void xsetDel(XmlBoolean xmlBoolean);

    void xsetID(XmlUnsignedInt xmlUnsignedInt);

    void xsetIsCustomName(XmlBoolean xmlBoolean);

    void xsetIsCustomNameU(XmlBoolean xmlBoolean);

    void xsetMaster(XmlUnsignedInt xmlUnsignedInt);

    void xsetMasterShape(XmlUnsignedInt xmlUnsignedInt);

    void xsetName(XmlString xmlString);

    void xsetNameU(XmlString xmlString);

    void xsetOriginalID(XmlUnsignedInt xmlUnsignedInt);

    void xsetType(XmlToken xmlToken);

    void xsetUniqueID(XmlString xmlString);
}
