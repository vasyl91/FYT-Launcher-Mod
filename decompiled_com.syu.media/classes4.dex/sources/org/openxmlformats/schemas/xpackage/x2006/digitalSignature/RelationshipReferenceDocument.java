package org.openxmlformats.schemas.xpackage.x2006.digitalSignature;

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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface RelationshipReferenceDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(RelationshipReferenceDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("relationshipreference8903doctype");

    public static final class Factory {
        private Factory() {
        }

        public static RelationshipReferenceDocument newInstance() {
            return (RelationshipReferenceDocument) POIXMLTypeLoader.newInstance(RelationshipReferenceDocument.type, (XmlOptions) null);
        }

        public static RelationshipReferenceDocument newInstance(XmlOptions xmlOptions) {
            return (RelationshipReferenceDocument) POIXMLTypeLoader.newInstance(RelationshipReferenceDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, RelationshipReferenceDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, RelationshipReferenceDocument.type, xmlOptions);
        }

        public static RelationshipReferenceDocument parse(File file) throws XmlException, IOException {
            return (RelationshipReferenceDocument) POIXMLTypeLoader.parse(file, RelationshipReferenceDocument.type, (XmlOptions) null);
        }

        public static RelationshipReferenceDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RelationshipReferenceDocument) POIXMLTypeLoader.parse(file, RelationshipReferenceDocument.type, xmlOptions);
        }

        public static RelationshipReferenceDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (RelationshipReferenceDocument) POIXMLTypeLoader.parse(inputStream, RelationshipReferenceDocument.type, (XmlOptions) null);
        }

        public static RelationshipReferenceDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RelationshipReferenceDocument) POIXMLTypeLoader.parse(inputStream, RelationshipReferenceDocument.type, xmlOptions);
        }

        public static RelationshipReferenceDocument parse(Reader reader) throws XmlException, IOException {
            return (RelationshipReferenceDocument) POIXMLTypeLoader.parse(reader, RelationshipReferenceDocument.type, (XmlOptions) null);
        }

        public static RelationshipReferenceDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RelationshipReferenceDocument) POIXMLTypeLoader.parse(reader, RelationshipReferenceDocument.type, xmlOptions);
        }

        public static RelationshipReferenceDocument parse(String str) throws XmlException {
            return (RelationshipReferenceDocument) POIXMLTypeLoader.parse(str, RelationshipReferenceDocument.type, (XmlOptions) null);
        }

        public static RelationshipReferenceDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (RelationshipReferenceDocument) POIXMLTypeLoader.parse(str, RelationshipReferenceDocument.type, xmlOptions);
        }

        public static RelationshipReferenceDocument parse(URL url) throws XmlException, IOException {
            return (RelationshipReferenceDocument) POIXMLTypeLoader.parse(url, RelationshipReferenceDocument.type, (XmlOptions) null);
        }

        public static RelationshipReferenceDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RelationshipReferenceDocument) POIXMLTypeLoader.parse(url, RelationshipReferenceDocument.type, xmlOptions);
        }

        public static RelationshipReferenceDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (RelationshipReferenceDocument) POIXMLTypeLoader.parse(xMLStreamReader, RelationshipReferenceDocument.type, (XmlOptions) null);
        }

        public static RelationshipReferenceDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (RelationshipReferenceDocument) POIXMLTypeLoader.parse(xMLStreamReader, RelationshipReferenceDocument.type, xmlOptions);
        }

        public static RelationshipReferenceDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (RelationshipReferenceDocument) POIXMLTypeLoader.parse(xMLInputStream, RelationshipReferenceDocument.type, (XmlOptions) null);
        }

        public static RelationshipReferenceDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (RelationshipReferenceDocument) POIXMLTypeLoader.parse(xMLInputStream, RelationshipReferenceDocument.type, xmlOptions);
        }

        public static RelationshipReferenceDocument parse(Node node) throws XmlException {
            return (RelationshipReferenceDocument) POIXMLTypeLoader.parse(node, RelationshipReferenceDocument.type, (XmlOptions) null);
        }

        public static RelationshipReferenceDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (RelationshipReferenceDocument) POIXMLTypeLoader.parse(node, RelationshipReferenceDocument.type, xmlOptions);
        }
    }

    CTRelationshipReference addNewRelationshipReference();

    CTRelationshipReference getRelationshipReference();

    void setRelationshipReference(CTRelationshipReference cTRelationshipReference);
}
