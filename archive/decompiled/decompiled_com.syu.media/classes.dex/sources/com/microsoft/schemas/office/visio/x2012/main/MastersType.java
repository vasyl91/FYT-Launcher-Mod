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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface MastersType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(MastersType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("masterstypeaebatype");

    public static final class Factory {
        private Factory() {
        }

        public static MastersType newInstance() {
            return (MastersType) POIXMLTypeLoader.newInstance(MastersType.type, (XmlOptions) null);
        }

        public static MastersType newInstance(XmlOptions xmlOptions) {
            return (MastersType) POIXMLTypeLoader.newInstance(MastersType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, MastersType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, MastersType.type, xmlOptions);
        }

        public static MastersType parse(File file) throws XmlException, IOException {
            return (MastersType) POIXMLTypeLoader.parse(file, MastersType.type, (XmlOptions) null);
        }

        public static MastersType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MastersType) POIXMLTypeLoader.parse(file, MastersType.type, xmlOptions);
        }

        public static MastersType parse(InputStream inputStream) throws XmlException, IOException {
            return (MastersType) POIXMLTypeLoader.parse(inputStream, MastersType.type, (XmlOptions) null);
        }

        public static MastersType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MastersType) POIXMLTypeLoader.parse(inputStream, MastersType.type, xmlOptions);
        }

        public static MastersType parse(Reader reader) throws XmlException, IOException {
            return (MastersType) POIXMLTypeLoader.parse(reader, MastersType.type, (XmlOptions) null);
        }

        public static MastersType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MastersType) POIXMLTypeLoader.parse(reader, MastersType.type, xmlOptions);
        }

        public static MastersType parse(String str) throws XmlException {
            return (MastersType) POIXMLTypeLoader.parse(str, MastersType.type, (XmlOptions) null);
        }

        public static MastersType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (MastersType) POIXMLTypeLoader.parse(str, MastersType.type, xmlOptions);
        }

        public static MastersType parse(URL url) throws XmlException, IOException {
            return (MastersType) POIXMLTypeLoader.parse(url, MastersType.type, (XmlOptions) null);
        }

        public static MastersType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MastersType) POIXMLTypeLoader.parse(url, MastersType.type, xmlOptions);
        }

        public static MastersType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (MastersType) POIXMLTypeLoader.parse(xMLStreamReader, MastersType.type, (XmlOptions) null);
        }

        public static MastersType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (MastersType) POIXMLTypeLoader.parse(xMLStreamReader, MastersType.type, xmlOptions);
        }

        public static MastersType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (MastersType) POIXMLTypeLoader.parse(xMLInputStream, MastersType.type, (XmlOptions) null);
        }

        public static MastersType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (MastersType) POIXMLTypeLoader.parse(xMLInputStream, MastersType.type, xmlOptions);
        }

        public static MastersType parse(Node node) throws XmlException {
            return (MastersType) POIXMLTypeLoader.parse(node, MastersType.type, (XmlOptions) null);
        }

        public static MastersType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (MastersType) POIXMLTypeLoader.parse(node, MastersType.type, xmlOptions);
        }
    }

    MasterType addNewMaster();

    MasterShortcutType addNewMasterShortcut();

    MasterType getMasterArray(int i);

    MasterType[] getMasterArray();

    List<MasterType> getMasterList();

    MasterShortcutType getMasterShortcutArray(int i);

    MasterShortcutType[] getMasterShortcutArray();

    List<MasterShortcutType> getMasterShortcutList();

    MasterType insertNewMaster(int i);

    MasterShortcutType insertNewMasterShortcut(int i);

    void removeMaster(int i);

    void removeMasterShortcut(int i);

    void setMasterArray(int i, MasterType masterType);

    void setMasterArray(MasterType[] masterTypeArr);

    void setMasterShortcutArray(int i, MasterShortcutType masterShortcutType);

    void setMasterShortcutArray(MasterShortcutType[] masterShortcutTypeArr);

    int sizeOfMasterArray();

    int sizeOfMasterShortcutArray();
}
