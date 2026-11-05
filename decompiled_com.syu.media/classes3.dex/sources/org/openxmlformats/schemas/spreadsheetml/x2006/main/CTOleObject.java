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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTOleObject extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTOleObject.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctoleobjectd866type");

    public static final class Factory {
        private Factory() {
        }

        public static CTOleObject newInstance() {
            return (CTOleObject) POIXMLTypeLoader.newInstance(CTOleObject.type, (XmlOptions) null);
        }

        public static CTOleObject newInstance(XmlOptions xmlOptions) {
            return (CTOleObject) POIXMLTypeLoader.newInstance(CTOleObject.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOleObject.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOleObject.type, xmlOptions);
        }

        public static CTOleObject parse(File file) throws XmlException, IOException {
            return (CTOleObject) POIXMLTypeLoader.parse(file, CTOleObject.type, (XmlOptions) null);
        }

        public static CTOleObject parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOleObject) POIXMLTypeLoader.parse(file, CTOleObject.type, xmlOptions);
        }

        public static CTOleObject parse(InputStream inputStream) throws XmlException, IOException {
            return (CTOleObject) POIXMLTypeLoader.parse(inputStream, CTOleObject.type, (XmlOptions) null);
        }

        public static CTOleObject parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOleObject) POIXMLTypeLoader.parse(inputStream, CTOleObject.type, xmlOptions);
        }

        public static CTOleObject parse(Reader reader) throws XmlException, IOException {
            return (CTOleObject) POIXMLTypeLoader.parse(reader, CTOleObject.type, (XmlOptions) null);
        }

        public static CTOleObject parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOleObject) POIXMLTypeLoader.parse(reader, CTOleObject.type, xmlOptions);
        }

        public static CTOleObject parse(String str) throws XmlException {
            return (CTOleObject) POIXMLTypeLoader.parse(str, CTOleObject.type, (XmlOptions) null);
        }

        public static CTOleObject parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTOleObject) POIXMLTypeLoader.parse(str, CTOleObject.type, xmlOptions);
        }

        public static CTOleObject parse(URL url) throws XmlException, IOException {
            return (CTOleObject) POIXMLTypeLoader.parse(url, CTOleObject.type, (XmlOptions) null);
        }

        public static CTOleObject parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOleObject) POIXMLTypeLoader.parse(url, CTOleObject.type, xmlOptions);
        }

        public static CTOleObject parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTOleObject) POIXMLTypeLoader.parse(xMLStreamReader, CTOleObject.type, (XmlOptions) null);
        }

        public static CTOleObject parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTOleObject) POIXMLTypeLoader.parse(xMLStreamReader, CTOleObject.type, xmlOptions);
        }

        public static CTOleObject parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTOleObject) POIXMLTypeLoader.parse(xMLInputStream, CTOleObject.type, (XmlOptions) null);
        }

        public static CTOleObject parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTOleObject) POIXMLTypeLoader.parse(xMLInputStream, CTOleObject.type, xmlOptions);
        }

        public static CTOleObject parse(Node node) throws XmlException {
            return (CTOleObject) POIXMLTypeLoader.parse(node, CTOleObject.type, (XmlOptions) null);
        }

        public static CTOleObject parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTOleObject) POIXMLTypeLoader.parse(node, CTOleObject.type, xmlOptions);
        }
    }

    boolean getAutoLoad();

    STDvAspect$Enum getDvAspect();

    String getId();

    String getLink();

    STOleUpdate$Enum getOleUpdate();

    String getProgId();

    long getShapeId();

    boolean isSetAutoLoad();

    boolean isSetDvAspect();

    boolean isSetId();

    boolean isSetLink();

    boolean isSetOleUpdate();

    boolean isSetProgId();

    void setAutoLoad(boolean z);

    void setDvAspect(STDvAspect$Enum sTDvAspect$Enum);

    void setId(String str);

    void setLink(String str);

    void setOleUpdate(STOleUpdate$Enum sTOleUpdate$Enum);

    void setProgId(String str);

    void setShapeId(long j);

    void unsetAutoLoad();

    void unsetDvAspect();

    void unsetId();

    void unsetLink();

    void unsetOleUpdate();

    void unsetProgId();

    XmlBoolean xgetAutoLoad();

    STDvAspect xgetDvAspect();

    STRelationshipId xgetId();

    STXstring xgetLink();

    STOleUpdate xgetOleUpdate();

    XmlString xgetProgId();

    XmlUnsignedInt xgetShapeId();

    void xsetAutoLoad(XmlBoolean xmlBoolean);

    void xsetDvAspect(STDvAspect sTDvAspect);

    void xsetId(STRelationshipId sTRelationshipId);

    void xsetLink(STXstring sTXstring);

    void xsetOleUpdate(STOleUpdate sTOleUpdate);

    void xsetProgId(XmlString xmlString);

    void xsetShapeId(XmlUnsignedInt xmlUnsignedInt);
}
