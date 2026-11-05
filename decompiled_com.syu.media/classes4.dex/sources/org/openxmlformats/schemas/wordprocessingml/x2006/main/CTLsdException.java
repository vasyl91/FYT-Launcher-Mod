package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTLsdException extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTLsdException.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlsdexceptiona296type");

    public static final class Factory {
        private Factory() {
        }

        public static CTLsdException newInstance() {
            return (CTLsdException) POIXMLTypeLoader.newInstance(CTLsdException.type, (XmlOptions) null);
        }

        public static CTLsdException newInstance(XmlOptions xmlOptions) {
            return (CTLsdException) POIXMLTypeLoader.newInstance(CTLsdException.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLsdException.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLsdException.type, xmlOptions);
        }

        public static CTLsdException parse(File file) throws XmlException, IOException {
            return (CTLsdException) POIXMLTypeLoader.parse(file, CTLsdException.type, (XmlOptions) null);
        }

        public static CTLsdException parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLsdException) POIXMLTypeLoader.parse(file, CTLsdException.type, xmlOptions);
        }

        public static CTLsdException parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLsdException) POIXMLTypeLoader.parse(inputStream, CTLsdException.type, (XmlOptions) null);
        }

        public static CTLsdException parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLsdException) POIXMLTypeLoader.parse(inputStream, CTLsdException.type, xmlOptions);
        }

        public static CTLsdException parse(Reader reader) throws XmlException, IOException {
            return (CTLsdException) POIXMLTypeLoader.parse(reader, CTLsdException.type, (XmlOptions) null);
        }

        public static CTLsdException parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLsdException) POIXMLTypeLoader.parse(reader, CTLsdException.type, xmlOptions);
        }

        public static CTLsdException parse(String str) throws XmlException {
            return (CTLsdException) POIXMLTypeLoader.parse(str, CTLsdException.type, (XmlOptions) null);
        }

        public static CTLsdException parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLsdException) POIXMLTypeLoader.parse(str, CTLsdException.type, xmlOptions);
        }

        public static CTLsdException parse(URL url) throws XmlException, IOException {
            return (CTLsdException) POIXMLTypeLoader.parse(url, CTLsdException.type, (XmlOptions) null);
        }

        public static CTLsdException parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLsdException) POIXMLTypeLoader.parse(url, CTLsdException.type, xmlOptions);
        }

        public static CTLsdException parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLsdException) POIXMLTypeLoader.parse(xMLStreamReader, CTLsdException.type, (XmlOptions) null);
        }

        public static CTLsdException parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLsdException) POIXMLTypeLoader.parse(xMLStreamReader, CTLsdException.type, xmlOptions);
        }

        public static CTLsdException parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTLsdException) POIXMLTypeLoader.parse(xMLInputStream, CTLsdException.type, (XmlOptions) null);
        }

        public static CTLsdException parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTLsdException) POIXMLTypeLoader.parse(xMLInputStream, CTLsdException.type, xmlOptions);
        }

        public static CTLsdException parse(Node node) throws XmlException {
            return (CTLsdException) POIXMLTypeLoader.parse(node, CTLsdException.type, (XmlOptions) null);
        }

        public static CTLsdException parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLsdException) POIXMLTypeLoader.parse(node, CTLsdException.type, xmlOptions);
        }
    }

    STOnOff.Enum getLocked();

    String getName();

    STOnOff.Enum getQFormat();

    STOnOff.Enum getSemiHidden();

    BigInteger getUiPriority();

    STOnOff.Enum getUnhideWhenUsed();

    boolean isSetLocked();

    boolean isSetQFormat();

    boolean isSetSemiHidden();

    boolean isSetUiPriority();

    boolean isSetUnhideWhenUsed();

    void setLocked(STOnOff.Enum r1);

    void setName(String str);

    void setQFormat(STOnOff.Enum r1);

    void setSemiHidden(STOnOff.Enum r1);

    void setUiPriority(BigInteger bigInteger);

    void setUnhideWhenUsed(STOnOff.Enum r1);

    void unsetLocked();

    void unsetQFormat();

    void unsetSemiHidden();

    void unsetUiPriority();

    void unsetUnhideWhenUsed();

    STOnOff xgetLocked();

    STString xgetName();

    STOnOff xgetQFormat();

    STOnOff xgetSemiHidden();

    STDecimalNumber xgetUiPriority();

    STOnOff xgetUnhideWhenUsed();

    void xsetLocked(STOnOff sTOnOff);

    void xsetName(STString sTString);

    void xsetQFormat(STOnOff sTOnOff);

    void xsetSemiHidden(STOnOff sTOnOff);

    void xsetUiPriority(STDecimalNumber sTDecimalNumber);

    void xsetUnhideWhenUsed(STOnOff sTOnOff);
}
