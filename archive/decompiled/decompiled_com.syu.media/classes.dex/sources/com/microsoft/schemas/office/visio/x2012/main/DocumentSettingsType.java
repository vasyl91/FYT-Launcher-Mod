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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface DocumentSettingsType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(DocumentSettingsType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("documentsettingstype945btype");

    public static final class Factory {
        private Factory() {
        }

        public static DocumentSettingsType newInstance() {
            return (DocumentSettingsType) POIXMLTypeLoader.newInstance(DocumentSettingsType.type, (XmlOptions) null);
        }

        public static DocumentSettingsType newInstance(XmlOptions xmlOptions) {
            return (DocumentSettingsType) POIXMLTypeLoader.newInstance(DocumentSettingsType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, DocumentSettingsType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, DocumentSettingsType.type, xmlOptions);
        }

        public static DocumentSettingsType parse(File file) throws XmlException, IOException {
            return (DocumentSettingsType) POIXMLTypeLoader.parse(file, DocumentSettingsType.type, (XmlOptions) null);
        }

        public static DocumentSettingsType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DocumentSettingsType) POIXMLTypeLoader.parse(file, DocumentSettingsType.type, xmlOptions);
        }

        public static DocumentSettingsType parse(InputStream inputStream) throws XmlException, IOException {
            return (DocumentSettingsType) POIXMLTypeLoader.parse(inputStream, DocumentSettingsType.type, (XmlOptions) null);
        }

        public static DocumentSettingsType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DocumentSettingsType) POIXMLTypeLoader.parse(inputStream, DocumentSettingsType.type, xmlOptions);
        }

        public static DocumentSettingsType parse(Reader reader) throws XmlException, IOException {
            return (DocumentSettingsType) POIXMLTypeLoader.parse(reader, DocumentSettingsType.type, (XmlOptions) null);
        }

        public static DocumentSettingsType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DocumentSettingsType) POIXMLTypeLoader.parse(reader, DocumentSettingsType.type, xmlOptions);
        }

        public static DocumentSettingsType parse(String str) throws XmlException {
            return (DocumentSettingsType) POIXMLTypeLoader.parse(str, DocumentSettingsType.type, (XmlOptions) null);
        }

        public static DocumentSettingsType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (DocumentSettingsType) POIXMLTypeLoader.parse(str, DocumentSettingsType.type, xmlOptions);
        }

        public static DocumentSettingsType parse(URL url) throws XmlException, IOException {
            return (DocumentSettingsType) POIXMLTypeLoader.parse(url, DocumentSettingsType.type, (XmlOptions) null);
        }

        public static DocumentSettingsType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DocumentSettingsType) POIXMLTypeLoader.parse(url, DocumentSettingsType.type, xmlOptions);
        }

        public static DocumentSettingsType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (DocumentSettingsType) POIXMLTypeLoader.parse(xMLStreamReader, DocumentSettingsType.type, (XmlOptions) null);
        }

        public static DocumentSettingsType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (DocumentSettingsType) POIXMLTypeLoader.parse(xMLStreamReader, DocumentSettingsType.type, xmlOptions);
        }

        public static DocumentSettingsType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (DocumentSettingsType) POIXMLTypeLoader.parse(xMLInputStream, DocumentSettingsType.type, (XmlOptions) null);
        }

        public static DocumentSettingsType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (DocumentSettingsType) POIXMLTypeLoader.parse(xMLInputStream, DocumentSettingsType.type, xmlOptions);
        }

        public static DocumentSettingsType parse(Node node) throws XmlException {
            return (DocumentSettingsType) POIXMLTypeLoader.parse(node, DocumentSettingsType.type, (XmlOptions) null);
        }

        public static DocumentSettingsType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (DocumentSettingsType) POIXMLTypeLoader.parse(node, DocumentSettingsType.type, xmlOptions);
        }
    }

    AttachedToolbarsType addNewAttachedToolbars();

    CustomMenusFileType addNewCustomMenusFile();

    CustomToolbarsFileType addNewCustomToolbarsFile();

    DynamicGridEnabledType addNewDynamicGridEnabled();

    GlueSettingsType addNewGlueSettings();

    ProtectBkgndsType addNewProtectBkgnds();

    ProtectMastersType addNewProtectMasters();

    ProtectShapesType addNewProtectShapes();

    ProtectStylesType addNewProtectStyles();

    SnapAnglesType addNewSnapAngles();

    SnapExtensionsType addNewSnapExtensions();

    SnapSettingsType addNewSnapSettings();

    AttachedToolbarsType getAttachedToolbars();

    CustomMenusFileType getCustomMenusFile();

    CustomToolbarsFileType getCustomToolbarsFile();

    long getDefaultFillStyle();

    long getDefaultGuideStyle();

    long getDefaultLineStyle();

    long getDefaultTextStyle();

    DynamicGridEnabledType getDynamicGridEnabled();

    GlueSettingsType getGlueSettings();

    ProtectBkgndsType getProtectBkgnds();

    ProtectMastersType getProtectMasters();

    ProtectShapesType getProtectShapes();

    ProtectStylesType getProtectStyles();

    SnapAnglesType getSnapAngles();

    SnapExtensionsType getSnapExtensions();

    SnapSettingsType getSnapSettings();

    long getTopPage();

    boolean isSetAttachedToolbars();

    boolean isSetCustomMenusFile();

    boolean isSetCustomToolbarsFile();

    boolean isSetDefaultFillStyle();

    boolean isSetDefaultGuideStyle();

    boolean isSetDefaultLineStyle();

    boolean isSetDefaultTextStyle();

    boolean isSetDynamicGridEnabled();

    boolean isSetGlueSettings();

    boolean isSetProtectBkgnds();

    boolean isSetProtectMasters();

    boolean isSetProtectShapes();

    boolean isSetProtectStyles();

    boolean isSetSnapAngles();

    boolean isSetSnapExtensions();

    boolean isSetSnapSettings();

    boolean isSetTopPage();

    void setAttachedToolbars(AttachedToolbarsType attachedToolbarsType);

    void setCustomMenusFile(CustomMenusFileType customMenusFileType);

    void setCustomToolbarsFile(CustomToolbarsFileType customToolbarsFileType);

    void setDefaultFillStyle(long j);

    void setDefaultGuideStyle(long j);

    void setDefaultLineStyle(long j);

    void setDefaultTextStyle(long j);

    void setDynamicGridEnabled(DynamicGridEnabledType dynamicGridEnabledType);

    void setGlueSettings(GlueSettingsType glueSettingsType);

    void setProtectBkgnds(ProtectBkgndsType protectBkgndsType);

    void setProtectMasters(ProtectMastersType protectMastersType);

    void setProtectShapes(ProtectShapesType protectShapesType);

    void setProtectStyles(ProtectStylesType protectStylesType);

    void setSnapAngles(SnapAnglesType snapAnglesType);

    void setSnapExtensions(SnapExtensionsType snapExtensionsType);

    void setSnapSettings(SnapSettingsType snapSettingsType);

    void setTopPage(long j);

    void unsetAttachedToolbars();

    void unsetCustomMenusFile();

    void unsetCustomToolbarsFile();

    void unsetDefaultFillStyle();

    void unsetDefaultGuideStyle();

    void unsetDefaultLineStyle();

    void unsetDefaultTextStyle();

    void unsetDynamicGridEnabled();

    void unsetGlueSettings();

    void unsetProtectBkgnds();

    void unsetProtectMasters();

    void unsetProtectShapes();

    void unsetProtectStyles();

    void unsetSnapAngles();

    void unsetSnapExtensions();

    void unsetSnapSettings();

    void unsetTopPage();

    XmlUnsignedInt xgetDefaultFillStyle();

    XmlUnsignedInt xgetDefaultGuideStyle();

    XmlUnsignedInt xgetDefaultLineStyle();

    XmlUnsignedInt xgetDefaultTextStyle();

    XmlUnsignedInt xgetTopPage();

    void xsetDefaultFillStyle(XmlUnsignedInt xmlUnsignedInt);

    void xsetDefaultGuideStyle(XmlUnsignedInt xmlUnsignedInt);

    void xsetDefaultLineStyle(XmlUnsignedInt xmlUnsignedInt);

    void xsetDefaultTextStyle(XmlUnsignedInt xmlUnsignedInt);

    void xsetTopPage(XmlUnsignedInt xmlUnsignedInt);
}
