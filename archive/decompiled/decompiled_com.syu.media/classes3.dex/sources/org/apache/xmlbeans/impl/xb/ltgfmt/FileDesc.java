package org.apache.xmlbeans.impl.xb.ltgfmt;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface FileDesc extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(FileDesc.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("filedesc9392type");

    Code addNewCode();

    Code getCode();

    String getFileName();

    String getFolder();

    Role.Enum getRole();

    String getTsDir();

    boolean getValidity();

    boolean isSetCode();

    boolean isSetFileName();

    boolean isSetFolder();

    boolean isSetRole();

    boolean isSetTsDir();

    boolean isSetValidity();

    void setCode(Code code);

    void setFileName(String str);

    void setFolder(String str);

    void setRole(Role.Enum r1);

    void setTsDir(String str);

    void setValidity(boolean z);

    void unsetCode();

    void unsetFileName();

    void unsetFolder();

    void unsetRole();

    void unsetTsDir();

    void unsetValidity();

    XmlToken xgetFileName();

    XmlToken xgetFolder();

    Role xgetRole();

    XmlToken xgetTsDir();

    XmlBoolean xgetValidity();

    void xsetFileName(XmlToken xmlToken);

    void xsetFolder(XmlToken xmlToken);

    void xsetRole(Role role);

    void xsetTsDir(XmlToken xmlToken);

    void xsetValidity(XmlBoolean xmlBoolean);

    public interface Role extends XmlToken {
        public static final int INT_INSTANCE = 2;
        public static final int INT_RESOURCE = 3;
        public static final int INT_SCHEMA = 1;
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Role.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("role21a8attrtype");
        public static final Enum SCHEMA = Enum.forString("schema");
        public static final Enum INSTANCE = Enum.forString("instance");
        public static final Enum RESOURCE = Enum.forString("resource");

        StringEnumAbstractBase enumValue();

        void set(StringEnumAbstractBase stringEnumAbstractBase);

        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_INSTANCE = 2;
            static final int INT_RESOURCE = 3;
            static final int INT_SCHEMA = 1;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("schema", 1), new Enum("instance", 2), new Enum("resource", 3)});

            public static Enum forString(String str) {
                return (Enum) table.forString(str);
            }

            public static Enum forInt(int i) {
                return (Enum) table.forInt(i);
            }

            private Enum(String str, int i) {
                super(str, i);
            }

            private Object readResolve() {
                return forInt(intValue());
            }
        }

        public static final class Factory {
            public static Role newValue(Object obj) {
                return Role.type.newValue(obj);
            }

            public static Role newInstance() {
                return XmlBeans.getContextTypeLoader().newInstance(Role.type, (XmlOptions) null);
            }

            public static Role newInstance(XmlOptions xmlOptions) {
                return XmlBeans.getContextTypeLoader().newInstance(Role.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static FileDesc newInstance() {
            return (FileDesc) XmlBeans.getContextTypeLoader().newInstance(FileDesc.type, (XmlOptions) null);
        }

        public static FileDesc newInstance(XmlOptions xmlOptions) {
            return (FileDesc) XmlBeans.getContextTypeLoader().newInstance(FileDesc.type, xmlOptions);
        }

        public static FileDesc parse(String str) throws XmlException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(str, FileDesc.type, (XmlOptions) null);
        }

        public static FileDesc parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(str, FileDesc.type, xmlOptions);
        }

        public static FileDesc parse(File file) throws XmlException, IOException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(file, FileDesc.type, (XmlOptions) null);
        }

        public static FileDesc parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(file, FileDesc.type, xmlOptions);
        }

        public static FileDesc parse(URL url) throws XmlException, IOException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(url, FileDesc.type, (XmlOptions) null);
        }

        public static FileDesc parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(url, FileDesc.type, xmlOptions);
        }

        public static FileDesc parse(InputStream inputStream) throws XmlException, IOException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(inputStream, FileDesc.type, (XmlOptions) null);
        }

        public static FileDesc parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(inputStream, FileDesc.type, xmlOptions);
        }

        public static FileDesc parse(Reader reader) throws XmlException, IOException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(reader, FileDesc.type, (XmlOptions) null);
        }

        public static FileDesc parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(reader, FileDesc.type, xmlOptions);
        }

        public static FileDesc parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, FileDesc.type, (XmlOptions) null);
        }

        public static FileDesc parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, FileDesc.type, xmlOptions);
        }

        public static FileDesc parse(Node node) throws XmlException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(node, FileDesc.type, (XmlOptions) null);
        }

        public static FileDesc parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(node, FileDesc.type, xmlOptions);
        }

        public static FileDesc parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(xMLInputStream, FileDesc.type, (XmlOptions) null);
        }

        public static FileDesc parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(xMLInputStream, FileDesc.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, FileDesc.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, FileDesc.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
