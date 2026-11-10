package org.apache.xmlbeans.impl.xb.xsdschema;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface UnionDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(UnionDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("union5866doctype");

    Union addNewUnion();

    Union getUnion();

    void setUnion(Union union);

    public interface Union extends Annotated {
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Union.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("union498belemtype");

        LocalSimpleType addNewSimpleType();

        List getMemberTypes();

        LocalSimpleType getSimpleTypeArray(int i);

        LocalSimpleType[] getSimpleTypeArray();

        LocalSimpleType insertNewSimpleType(int i);

        boolean isSetMemberTypes();

        void removeSimpleType(int i);

        void setMemberTypes(List list);

        void setSimpleTypeArray(int i, LocalSimpleType localSimpleType);

        void setSimpleTypeArray(LocalSimpleType[] localSimpleTypeArr);

        int sizeOfSimpleTypeArray();

        void unsetMemberTypes();

        MemberTypes xgetMemberTypes();

        void xsetMemberTypes(MemberTypes memberTypes);

        public interface MemberTypes extends XmlAnySimpleType {
            public static final SchemaType type = XmlBeans.typeSystemForClassLoader(MemberTypes.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("membertypes2404attrtype");

            List getListValue();

            List listValue();

            void set(List list);

            void setListValue(List list);

            List xgetListValue();

            List xlistValue();

            public static final class Factory {
                public static MemberTypes newValue(Object obj) {
                    return (MemberTypes) MemberTypes.type.newValue(obj);
                }

                public static MemberTypes newInstance() {
                    return XmlBeans.getContextTypeLoader().newInstance(MemberTypes.type, (XmlOptions) null);
                }

                public static MemberTypes newInstance(XmlOptions xmlOptions) {
                    return XmlBeans.getContextTypeLoader().newInstance(MemberTypes.type, xmlOptions);
                }

                private Factory() {
                }
            }
        }

        public static final class Factory {
            public static Union newInstance() {
                return (Union) XmlBeans.getContextTypeLoader().newInstance(Union.type, (XmlOptions) null);
            }

            public static Union newInstance(XmlOptions xmlOptions) {
                return (Union) XmlBeans.getContextTypeLoader().newInstance(Union.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static UnionDocument newInstance() {
            return (UnionDocument) XmlBeans.getContextTypeLoader().newInstance(UnionDocument.type, (XmlOptions) null);
        }

        public static UnionDocument newInstance(XmlOptions xmlOptions) {
            return (UnionDocument) XmlBeans.getContextTypeLoader().newInstance(UnionDocument.type, xmlOptions);
        }

        public static UnionDocument parse(String str) throws XmlException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(str, UnionDocument.type, (XmlOptions) null);
        }

        public static UnionDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(str, UnionDocument.type, xmlOptions);
        }

        public static UnionDocument parse(File file) throws XmlException, IOException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(file, UnionDocument.type, (XmlOptions) null);
        }

        public static UnionDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(file, UnionDocument.type, xmlOptions);
        }

        public static UnionDocument parse(URL url) throws XmlException, IOException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(url, UnionDocument.type, (XmlOptions) null);
        }

        public static UnionDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(url, UnionDocument.type, xmlOptions);
        }

        public static UnionDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(inputStream, UnionDocument.type, (XmlOptions) null);
        }

        public static UnionDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(inputStream, UnionDocument.type, xmlOptions);
        }

        public static UnionDocument parse(Reader reader) throws XmlException, IOException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(reader, UnionDocument.type, (XmlOptions) null);
        }

        public static UnionDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(reader, UnionDocument.type, xmlOptions);
        }

        public static UnionDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, UnionDocument.type, (XmlOptions) null);
        }

        public static UnionDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, UnionDocument.type, xmlOptions);
        }

        public static UnionDocument parse(Node node) throws XmlException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(node, UnionDocument.type, (XmlOptions) null);
        }

        public static UnionDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(node, UnionDocument.type, xmlOptions);
        }

        public static UnionDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, UnionDocument.type, (XmlOptions) null);
        }

        public static UnionDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (UnionDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, UnionDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, UnionDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, UnionDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
