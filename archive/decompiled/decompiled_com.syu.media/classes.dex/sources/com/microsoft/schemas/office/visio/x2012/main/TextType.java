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
public interface TextType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(TextType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("texttyped2ectype");

    public static final class Factory {
        private Factory() {
        }

        public static TextType newInstance() {
            return (TextType) POIXMLTypeLoader.newInstance(TextType.type, (XmlOptions) null);
        }

        public static TextType newInstance(XmlOptions xmlOptions) {
            return (TextType) POIXMLTypeLoader.newInstance(TextType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, TextType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, TextType.type, xmlOptions);
        }

        public static TextType parse(File file) throws XmlException, IOException {
            return (TextType) POIXMLTypeLoader.parse(file, TextType.type, (XmlOptions) null);
        }

        public static TextType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TextType) POIXMLTypeLoader.parse(file, TextType.type, xmlOptions);
        }

        public static TextType parse(InputStream inputStream) throws XmlException, IOException {
            return (TextType) POIXMLTypeLoader.parse(inputStream, TextType.type, (XmlOptions) null);
        }

        public static TextType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TextType) POIXMLTypeLoader.parse(inputStream, TextType.type, xmlOptions);
        }

        public static TextType parse(Reader reader) throws XmlException, IOException {
            return (TextType) POIXMLTypeLoader.parse(reader, TextType.type, (XmlOptions) null);
        }

        public static TextType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TextType) POIXMLTypeLoader.parse(reader, TextType.type, xmlOptions);
        }

        public static TextType parse(String str) throws XmlException {
            return (TextType) POIXMLTypeLoader.parse(str, TextType.type, (XmlOptions) null);
        }

        public static TextType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (TextType) POIXMLTypeLoader.parse(str, TextType.type, xmlOptions);
        }

        public static TextType parse(URL url) throws XmlException, IOException {
            return (TextType) POIXMLTypeLoader.parse(url, TextType.type, (XmlOptions) null);
        }

        public static TextType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TextType) POIXMLTypeLoader.parse(url, TextType.type, xmlOptions);
        }

        public static TextType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (TextType) POIXMLTypeLoader.parse(xMLStreamReader, TextType.type, (XmlOptions) null);
        }

        public static TextType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (TextType) POIXMLTypeLoader.parse(xMLStreamReader, TextType.type, xmlOptions);
        }

        public static TextType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (TextType) POIXMLTypeLoader.parse(xMLInputStream, TextType.type, (XmlOptions) null);
        }

        public static TextType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (TextType) POIXMLTypeLoader.parse(xMLInputStream, TextType.type, xmlOptions);
        }

        public static TextType parse(Node node) throws XmlException {
            return (TextType) POIXMLTypeLoader.parse(node, TextType.type, (XmlOptions) null);
        }

        public static TextType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (TextType) POIXMLTypeLoader.parse(node, TextType.type, xmlOptions);
        }
    }

    CpType addNewCp();

    FldType addNewFld();

    PpType addNewPp();

    TpType addNewTp();

    CpType getCpArray(int i);

    CpType[] getCpArray();

    List<CpType> getCpList();

    FldType getFldArray(int i);

    FldType[] getFldArray();

    List<FldType> getFldList();

    PpType getPpArray(int i);

    PpType[] getPpArray();

    List<PpType> getPpList();

    TpType getTpArray(int i);

    TpType[] getTpArray();

    List<TpType> getTpList();

    CpType insertNewCp(int i);

    FldType insertNewFld(int i);

    PpType insertNewPp(int i);

    TpType insertNewTp(int i);

    void removeCp(int i);

    void removeFld(int i);

    void removePp(int i);

    void removeTp(int i);

    void setCpArray(int i, CpType cpType);

    void setCpArray(CpType[] cpTypeArr);

    void setFldArray(int i, FldType fldType);

    void setFldArray(FldType[] fldTypeArr);

    void setPpArray(int i, PpType ppType);

    void setPpArray(PpType[] ppTypeArr);

    void setTpArray(int i, TpType tpType);

    void setTpArray(TpType[] tpTypeArr);

    int sizeOfCpArray();

    int sizeOfFldArray();

    int sizeOfPpArray();

    int sizeOfTpArray();
}
