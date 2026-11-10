package org.apache.xmlbeans.impl.xb.xsdschema;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface NotationDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(NotationDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("notation3381doctype");

    Notation addNewNotation();

    Notation getNotation();

    void setNotation(Notation notation);

    public interface Notation extends Annotated {
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Notation.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("notation8b1felemtype");

        String getName();

        String getPublic();

        String getSystem();

        boolean isSetPublic();

        boolean isSetSystem();

        void setName(String str);

        void setPublic(String str);

        void setSystem(String str);

        void unsetPublic();

        void unsetSystem();

        XmlNCName xgetName();

        Public xgetPublic();

        XmlAnyURI xgetSystem();

        void xsetName(XmlNCName xmlNCName);

        void xsetPublic(Public r1);

        void xsetSystem(XmlAnyURI xmlAnyURI);

        public static final class Factory {
            public static Notation newInstance() {
                return (Notation) XmlBeans.getContextTypeLoader().newInstance(Notation.type, (XmlOptions) null);
            }

            public static Notation newInstance(XmlOptions xmlOptions) {
                return (Notation) XmlBeans.getContextTypeLoader().newInstance(Notation.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static NotationDocument newInstance() {
            return (NotationDocument) XmlBeans.getContextTypeLoader().newInstance(NotationDocument.type, (XmlOptions) null);
        }

        public static NotationDocument newInstance(XmlOptions xmlOptions) {
            return (NotationDocument) XmlBeans.getContextTypeLoader().newInstance(NotationDocument.type, xmlOptions);
        }

        public static NotationDocument parse(String str) throws XmlException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(str, NotationDocument.type, (XmlOptions) null);
        }

        public static NotationDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(str, NotationDocument.type, xmlOptions);
        }

        public static NotationDocument parse(File file) throws XmlException, IOException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(file, NotationDocument.type, (XmlOptions) null);
        }

        public static NotationDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(file, NotationDocument.type, xmlOptions);
        }

        public static NotationDocument parse(URL url) throws XmlException, IOException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(url, NotationDocument.type, (XmlOptions) null);
        }

        public static NotationDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(url, NotationDocument.type, xmlOptions);
        }

        public static NotationDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(inputStream, NotationDocument.type, (XmlOptions) null);
        }

        public static NotationDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(inputStream, NotationDocument.type, xmlOptions);
        }

        public static NotationDocument parse(Reader reader) throws XmlException, IOException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(reader, NotationDocument.type, (XmlOptions) null);
        }

        public static NotationDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(reader, NotationDocument.type, xmlOptions);
        }

        public static NotationDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NotationDocument.type, (XmlOptions) null);
        }

        public static NotationDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, NotationDocument.type, xmlOptions);
        }

        public static NotationDocument parse(Node node) throws XmlException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(node, NotationDocument.type, (XmlOptions) null);
        }

        public static NotationDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(node, NotationDocument.type, xmlOptions);
        }

        public static NotationDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NotationDocument.type, (XmlOptions) null);
        }

        public static NotationDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (NotationDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, NotationDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NotationDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, NotationDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
