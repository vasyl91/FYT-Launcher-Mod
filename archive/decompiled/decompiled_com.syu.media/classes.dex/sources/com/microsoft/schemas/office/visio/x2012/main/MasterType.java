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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.XmlUnsignedShort;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface MasterType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(MasterType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("mastertype2d97type");

    public static final class Factory {
        private Factory() {
        }

        public static MasterType newInstance() {
            return (MasterType) POIXMLTypeLoader.newInstance(MasterType.type, (XmlOptions) null);
        }

        public static MasterType newInstance(XmlOptions xmlOptions) {
            return (MasterType) POIXMLTypeLoader.newInstance(MasterType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, MasterType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, MasterType.type, xmlOptions);
        }

        public static MasterType parse(File file) throws XmlException, IOException {
            return (MasterType) POIXMLTypeLoader.parse(file, MasterType.type, (XmlOptions) null);
        }

        public static MasterType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MasterType) POIXMLTypeLoader.parse(file, MasterType.type, xmlOptions);
        }

        public static MasterType parse(InputStream inputStream) throws XmlException, IOException {
            return (MasterType) POIXMLTypeLoader.parse(inputStream, MasterType.type, (XmlOptions) null);
        }

        public static MasterType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MasterType) POIXMLTypeLoader.parse(inputStream, MasterType.type, xmlOptions);
        }

        public static MasterType parse(Reader reader) throws XmlException, IOException {
            return (MasterType) POIXMLTypeLoader.parse(reader, MasterType.type, (XmlOptions) null);
        }

        public static MasterType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MasterType) POIXMLTypeLoader.parse(reader, MasterType.type, xmlOptions);
        }

        public static MasterType parse(String str) throws XmlException {
            return (MasterType) POIXMLTypeLoader.parse(str, MasterType.type, (XmlOptions) null);
        }

        public static MasterType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (MasterType) POIXMLTypeLoader.parse(str, MasterType.type, xmlOptions);
        }

        public static MasterType parse(URL url) throws XmlException, IOException {
            return (MasterType) POIXMLTypeLoader.parse(url, MasterType.type, (XmlOptions) null);
        }

        public static MasterType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MasterType) POIXMLTypeLoader.parse(url, MasterType.type, xmlOptions);
        }

        public static MasterType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (MasterType) POIXMLTypeLoader.parse(xMLStreamReader, MasterType.type, (XmlOptions) null);
        }

        public static MasterType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (MasterType) POIXMLTypeLoader.parse(xMLStreamReader, MasterType.type, xmlOptions);
        }

        public static MasterType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (MasterType) POIXMLTypeLoader.parse(xMLInputStream, MasterType.type, (XmlOptions) null);
        }

        public static MasterType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (MasterType) POIXMLTypeLoader.parse(xMLInputStream, MasterType.type, xmlOptions);
        }

        public static MasterType parse(Node node) throws XmlException {
            return (MasterType) POIXMLTypeLoader.parse(node, MasterType.type, (XmlOptions) null);
        }

        public static MasterType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (MasterType) POIXMLTypeLoader.parse(node, MasterType.type, xmlOptions);
        }
    }

    IconType addNewIcon();

    PageSheetType addNewPageSheet();

    RelType addNewRel();

    int getAlignName();

    String getBaseID();

    boolean getHidden();

    long getID();

    IconType getIcon();

    int getIconSize();

    boolean getIconUpdate();

    boolean getIsCustomName();

    boolean getIsCustomNameU();

    int getMasterType();

    boolean getMatchByName();

    String getName();

    String getNameU();

    PageSheetType getPageSheet();

    int getPatternFlags();

    String getPrompt();

    RelType getRel();

    String getUniqueID();

    boolean isSetAlignName();

    boolean isSetBaseID();

    boolean isSetHidden();

    boolean isSetIcon();

    boolean isSetIconSize();

    boolean isSetIconUpdate();

    boolean isSetIsCustomName();

    boolean isSetIsCustomNameU();

    boolean isSetMasterType();

    boolean isSetMatchByName();

    boolean isSetName();

    boolean isSetNameU();

    boolean isSetPageSheet();

    boolean isSetPatternFlags();

    boolean isSetPrompt();

    boolean isSetUniqueID();

    void setAlignName(int i);

    void setBaseID(String str);

    void setHidden(boolean z);

    void setID(long j);

    void setIcon(IconType iconType);

    void setIconSize(int i);

    void setIconUpdate(boolean z);

    void setIsCustomName(boolean z);

    void setIsCustomNameU(boolean z);

    void setMasterType(int i);

    void setMatchByName(boolean z);

    void setName(String str);

    void setNameU(String str);

    void setPageSheet(PageSheetType pageSheetType);

    void setPatternFlags(int i);

    void setPrompt(String str);

    void setRel(RelType relType);

    void setUniqueID(String str);

    void unsetAlignName();

    void unsetBaseID();

    void unsetHidden();

    void unsetIcon();

    void unsetIconSize();

    void unsetIconUpdate();

    void unsetIsCustomName();

    void unsetIsCustomNameU();

    void unsetMasterType();

    void unsetMatchByName();

    void unsetName();

    void unsetNameU();

    void unsetPageSheet();

    void unsetPatternFlags();

    void unsetPrompt();

    void unsetUniqueID();

    XmlUnsignedShort xgetAlignName();

    XmlString xgetBaseID();

    XmlBoolean xgetHidden();

    XmlUnsignedInt xgetID();

    XmlUnsignedShort xgetIconSize();

    XmlBoolean xgetIconUpdate();

    XmlBoolean xgetIsCustomName();

    XmlBoolean xgetIsCustomNameU();

    XmlUnsignedShort xgetMasterType();

    XmlBoolean xgetMatchByName();

    XmlString xgetName();

    XmlString xgetNameU();

    XmlUnsignedShort xgetPatternFlags();

    XmlString xgetPrompt();

    XmlString xgetUniqueID();

    void xsetAlignName(XmlUnsignedShort xmlUnsignedShort);

    void xsetBaseID(XmlString xmlString);

    void xsetHidden(XmlBoolean xmlBoolean);

    void xsetID(XmlUnsignedInt xmlUnsignedInt);

    void xsetIconSize(XmlUnsignedShort xmlUnsignedShort);

    void xsetIconUpdate(XmlBoolean xmlBoolean);

    void xsetIsCustomName(XmlBoolean xmlBoolean);

    void xsetIsCustomNameU(XmlBoolean xmlBoolean);

    void xsetMasterType(XmlUnsignedShort xmlUnsignedShort);

    void xsetMatchByName(XmlBoolean xmlBoolean);

    void xsetName(XmlString xmlString);

    void xsetNameU(XmlString xmlString);

    void xsetPatternFlags(XmlUnsignedShort xmlUnsignedShort);

    void xsetPrompt(XmlString xmlString);

    void xsetUniqueID(XmlString xmlString);
}
