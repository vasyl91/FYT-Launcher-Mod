package org.apache.xmlbeans.impl.xb.xsdschema;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface SimpleType extends Annotated {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(SimpleType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("simpletype0707type");

    ListDocument.List addNewList();

    RestrictionDocument.Restriction addNewRestriction();

    UnionDocument.Union addNewUnion();

    Object getFinal();

    ListDocument.List getList();

    String getName();

    RestrictionDocument.Restriction getRestriction();

    UnionDocument.Union getUnion();

    boolean isSetFinal();

    boolean isSetList();

    boolean isSetName();

    boolean isSetRestriction();

    boolean isSetUnion();

    void setFinal(Object obj);

    void setList(ListDocument.List list);

    void setName(String str);

    void setRestriction(RestrictionDocument.Restriction restriction);

    void setUnion(UnionDocument.Union union);

    void unsetFinal();

    void unsetList();

    void unsetName();

    void unsetRestriction();

    void unsetUnion();

    SimpleDerivationSet xgetFinal();

    XmlNCName xgetName();

    void xsetFinal(SimpleDerivationSet simpleDerivationSet);

    void xsetName(XmlNCName xmlNCName);

    public static final class Factory {
        public static SimpleType newInstance() {
            return (SimpleType) XmlBeans.getContextTypeLoader().newInstance(SimpleType.type, (XmlOptions) null);
        }

        public static SimpleType newInstance(XmlOptions xmlOptions) {
            return (SimpleType) XmlBeans.getContextTypeLoader().newInstance(SimpleType.type, xmlOptions);
        }

        public static SimpleType parse(String str) throws XmlException {
            return (SimpleType) XmlBeans.getContextTypeLoader().parse(str, SimpleType.type, (XmlOptions) null);
        }

        public static SimpleType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SimpleType) XmlBeans.getContextTypeLoader().parse(str, SimpleType.type, xmlOptions);
        }

        public static SimpleType parse(File file) throws XmlException, IOException {
            return (SimpleType) XmlBeans.getContextTypeLoader().parse(file, SimpleType.type, (XmlOptions) null);
        }

        public static SimpleType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleType) XmlBeans.getContextTypeLoader().parse(file, SimpleType.type, xmlOptions);
        }

        public static SimpleType parse(URL url) throws XmlException, IOException {
            return (SimpleType) XmlBeans.getContextTypeLoader().parse(url, SimpleType.type, (XmlOptions) null);
        }

        public static SimpleType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleType) XmlBeans.getContextTypeLoader().parse(url, SimpleType.type, xmlOptions);
        }

        public static SimpleType parse(InputStream inputStream) throws XmlException, IOException {
            return (SimpleType) XmlBeans.getContextTypeLoader().parse(inputStream, SimpleType.type, (XmlOptions) null);
        }

        public static SimpleType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleType) XmlBeans.getContextTypeLoader().parse(inputStream, SimpleType.type, xmlOptions);
        }

        public static SimpleType parse(Reader reader) throws XmlException, IOException {
            return (SimpleType) XmlBeans.getContextTypeLoader().parse(reader, SimpleType.type, (XmlOptions) null);
        }

        public static SimpleType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleType) XmlBeans.getContextTypeLoader().parse(reader, SimpleType.type, xmlOptions);
        }

        public static SimpleType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SimpleType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SimpleType.type, (XmlOptions) null);
        }

        public static SimpleType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SimpleType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SimpleType.type, xmlOptions);
        }

        public static SimpleType parse(Node node) throws XmlException {
            return (SimpleType) XmlBeans.getContextTypeLoader().parse(node, SimpleType.type, (XmlOptions) null);
        }

        public static SimpleType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SimpleType) XmlBeans.getContextTypeLoader().parse(node, SimpleType.type, xmlOptions);
        }

        public static SimpleType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (SimpleType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SimpleType.type, (XmlOptions) null);
        }

        public static SimpleType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (SimpleType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SimpleType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SimpleType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SimpleType.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
