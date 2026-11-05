package org.apache.xmlbeans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface SchemaTypeLoader {
    String compilePath(String str, XmlOptions xmlOptions) throws XmlException;

    String compileQuery(String str, XmlOptions xmlOptions) throws XmlException;

    SchemaGlobalAttribute findAttribute(QName qName);

    SchemaAttributeGroup findAttributeGroup(QName qName);

    SchemaAttributeGroup.Ref findAttributeGroupRef(QName qName);

    SchemaGlobalAttribute.Ref findAttributeRef(QName qName);

    SchemaType findAttributeType(QName qName);

    SchemaType.Ref findAttributeTypeRef(QName qName);

    SchemaType findDocumentType(QName qName);

    SchemaType.Ref findDocumentTypeRef(QName qName);

    SchemaGlobalElement findElement(QName qName);

    SchemaGlobalElement.Ref findElementRef(QName qName);

    SchemaIdentityConstraint.Ref findIdentityConstraintRef(QName qName);

    SchemaModelGroup findModelGroup(QName qName);

    SchemaModelGroup.Ref findModelGroupRef(QName qName);

    SchemaType findType(QName qName);

    SchemaType.Ref findTypeRef(QName qName);

    InputStream getSourceAsStream(String str);

    boolean isNamespaceDefined(String str);

    DOMImplementation newDomImplementation(XmlOptions xmlOptions);

    XmlObject newInstance(SchemaType schemaType, XmlOptions xmlOptions);

    XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, SchemaType schemaType, XmlOptions xmlOptions) throws XMLStreamException, XmlException;

    XmlSaxHandler newXmlSaxHandler(SchemaType schemaType, XmlOptions xmlOptions);

    XmlObject parse(File file, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException;

    XmlObject parse(InputStream inputStream, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException;

    XmlObject parse(Reader reader, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException;

    XmlObject parse(String str, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException;

    XmlObject parse(URL url, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException;

    XmlObject parse(XMLStreamReader xMLStreamReader, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException;

    XmlObject parse(XMLInputStream xMLInputStream, SchemaType schemaType, XmlOptions xmlOptions) throws XMLStreamException, XmlException;

    XmlObject parse(Node node, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException;

    SchemaType typeForClassname(String str);

    SchemaType typeForSignature(String str);
}
