package org.apache.xmlbeans.impl.xb.substwsdl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface DefinitionsDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(DefinitionsDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("definitionsc7f1doctype");

    Definitions addNewDefinitions();

    Definitions getDefinitions();

    void setDefinitions(Definitions definitions);

    public interface Definitions extends XmlObject {
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Definitions.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("definitions05ddelemtype");

        XmlObject addNewBinding();

        TImport addNewImport();

        XmlObject addNewMessage();

        XmlObject addNewPortType();

        XmlObject addNewService();

        XmlObject addNewTypes();

        XmlObject getBindingArray(int i);

        XmlObject[] getBindingArray();

        TImport getImportArray(int i);

        TImport[] getImportArray();

        XmlObject getMessageArray(int i);

        XmlObject[] getMessageArray();

        XmlObject getPortTypeArray(int i);

        XmlObject[] getPortTypeArray();

        XmlObject getServiceArray(int i);

        XmlObject[] getServiceArray();

        XmlObject getTypesArray(int i);

        XmlObject[] getTypesArray();

        XmlObject insertNewBinding(int i);

        TImport insertNewImport(int i);

        XmlObject insertNewMessage(int i);

        XmlObject insertNewPortType(int i);

        XmlObject insertNewService(int i);

        XmlObject insertNewTypes(int i);

        void removeBinding(int i);

        void removeImport(int i);

        void removeMessage(int i);

        void removePortType(int i);

        void removeService(int i);

        void removeTypes(int i);

        void setBindingArray(int i, XmlObject xmlObject);

        void setBindingArray(XmlObject[] xmlObjectArr);

        void setImportArray(int i, TImport tImport);

        void setImportArray(TImport[] tImportArr);

        void setMessageArray(int i, XmlObject xmlObject);

        void setMessageArray(XmlObject[] xmlObjectArr);

        void setPortTypeArray(int i, XmlObject xmlObject);

        void setPortTypeArray(XmlObject[] xmlObjectArr);

        void setServiceArray(int i, XmlObject xmlObject);

        void setServiceArray(XmlObject[] xmlObjectArr);

        void setTypesArray(int i, XmlObject xmlObject);

        void setTypesArray(XmlObject[] xmlObjectArr);

        int sizeOfBindingArray();

        int sizeOfImportArray();

        int sizeOfMessageArray();

        int sizeOfPortTypeArray();

        int sizeOfServiceArray();

        int sizeOfTypesArray();

        public static final class Factory {
            public static Definitions newInstance() {
                return (Definitions) XmlBeans.getContextTypeLoader().newInstance(Definitions.type, (XmlOptions) null);
            }

            public static Definitions newInstance(XmlOptions xmlOptions) {
                return (Definitions) XmlBeans.getContextTypeLoader().newInstance(Definitions.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static DefinitionsDocument newInstance() {
            return (DefinitionsDocument) XmlBeans.getContextTypeLoader().newInstance(DefinitionsDocument.type, (XmlOptions) null);
        }

        public static DefinitionsDocument newInstance(XmlOptions xmlOptions) {
            return (DefinitionsDocument) XmlBeans.getContextTypeLoader().newInstance(DefinitionsDocument.type, xmlOptions);
        }

        public static DefinitionsDocument parse(String str) throws XmlException {
            return (DefinitionsDocument) XmlBeans.getContextTypeLoader().parse(str, DefinitionsDocument.type, (XmlOptions) null);
        }

        public static DefinitionsDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (DefinitionsDocument) XmlBeans.getContextTypeLoader().parse(str, DefinitionsDocument.type, xmlOptions);
        }

        public static DefinitionsDocument parse(File file) throws XmlException, IOException {
            return (DefinitionsDocument) XmlBeans.getContextTypeLoader().parse(file, DefinitionsDocument.type, (XmlOptions) null);
        }

        public static DefinitionsDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DefinitionsDocument) XmlBeans.getContextTypeLoader().parse(file, DefinitionsDocument.type, xmlOptions);
        }

        public static DefinitionsDocument parse(URL url) throws XmlException, IOException {
            return (DefinitionsDocument) XmlBeans.getContextTypeLoader().parse(url, DefinitionsDocument.type, (XmlOptions) null);
        }

        public static DefinitionsDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DefinitionsDocument) XmlBeans.getContextTypeLoader().parse(url, DefinitionsDocument.type, xmlOptions);
        }

        public static DefinitionsDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (DefinitionsDocument) XmlBeans.getContextTypeLoader().parse(inputStream, DefinitionsDocument.type, (XmlOptions) null);
        }

        public static DefinitionsDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DefinitionsDocument) XmlBeans.getContextTypeLoader().parse(inputStream, DefinitionsDocument.type, xmlOptions);
        }

        public static DefinitionsDocument parse(Reader reader) throws XmlException, IOException {
            return (DefinitionsDocument) XmlBeans.getContextTypeLoader().parse(reader, DefinitionsDocument.type, (XmlOptions) null);
        }

        public static DefinitionsDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DefinitionsDocument) XmlBeans.getContextTypeLoader().parse(reader, DefinitionsDocument.type, xmlOptions);
        }

        public static DefinitionsDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (DefinitionsDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DefinitionsDocument.type, (XmlOptions) null);
        }

        public static DefinitionsDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (DefinitionsDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DefinitionsDocument.type, xmlOptions);
        }

        public static DefinitionsDocument parse(Node node) throws XmlException {
            return (DefinitionsDocument) XmlBeans.getContextTypeLoader().parse(node, DefinitionsDocument.type, (XmlOptions) null);
        }

        public static DefinitionsDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (DefinitionsDocument) XmlBeans.getContextTypeLoader().parse(node, DefinitionsDocument.type, xmlOptions);
        }

        public static DefinitionsDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (DefinitionsDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DefinitionsDocument.type, (XmlOptions) null);
        }

        public static DefinitionsDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (DefinitionsDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DefinitionsDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DefinitionsDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DefinitionsDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
