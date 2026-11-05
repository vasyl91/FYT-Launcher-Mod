package org.apache.xmlbeans.impl.xb.ltgfmt;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface TestCase extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(TestCase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("testcase939btype");

    Files addNewFiles();

    String getDescription();

    Files getFiles();

    String getId();

    boolean getModified();

    String getOrigin();

    boolean isSetDescription();

    boolean isSetId();

    boolean isSetModified();

    boolean isSetOrigin();

    void setDescription(String str);

    void setFiles(Files files);

    void setId(String str);

    void setModified(boolean z);

    void setOrigin(String str);

    void unsetDescription();

    void unsetId();

    void unsetModified();

    void unsetOrigin();

    XmlString xgetDescription();

    XmlID xgetId();

    XmlBoolean xgetModified();

    XmlToken xgetOrigin();

    void xsetDescription(XmlString xmlString);

    void xsetId(XmlID xmlID);

    void xsetModified(XmlBoolean xmlBoolean);

    void xsetOrigin(XmlToken xmlToken);

    public interface Files extends XmlObject {
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Files.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("files7c3eelemtype");

        FileDesc addNewFile();

        FileDesc getFileArray(int i);

        FileDesc[] getFileArray();

        FileDesc insertNewFile(int i);

        void removeFile(int i);

        void setFileArray(int i, FileDesc fileDesc);

        void setFileArray(FileDesc[] fileDescArr);

        int sizeOfFileArray();

        public static final class Factory {
            public static Files newInstance() {
                return (Files) XmlBeans.getContextTypeLoader().newInstance(Files.type, (XmlOptions) null);
            }

            public static Files newInstance(XmlOptions xmlOptions) {
                return (Files) XmlBeans.getContextTypeLoader().newInstance(Files.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static TestCase newInstance() {
            return (TestCase) XmlBeans.getContextTypeLoader().newInstance(TestCase.type, (XmlOptions) null);
        }

        public static TestCase newInstance(XmlOptions xmlOptions) {
            return (TestCase) XmlBeans.getContextTypeLoader().newInstance(TestCase.type, xmlOptions);
        }

        public static TestCase parse(String str) throws XmlException {
            return (TestCase) XmlBeans.getContextTypeLoader().parse(str, TestCase.type, (XmlOptions) null);
        }

        public static TestCase parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (TestCase) XmlBeans.getContextTypeLoader().parse(str, TestCase.type, xmlOptions);
        }

        public static TestCase parse(File file) throws XmlException, IOException {
            return (TestCase) XmlBeans.getContextTypeLoader().parse(file, TestCase.type, (XmlOptions) null);
        }

        public static TestCase parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TestCase) XmlBeans.getContextTypeLoader().parse(file, TestCase.type, xmlOptions);
        }

        public static TestCase parse(URL url) throws XmlException, IOException {
            return (TestCase) XmlBeans.getContextTypeLoader().parse(url, TestCase.type, (XmlOptions) null);
        }

        public static TestCase parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TestCase) XmlBeans.getContextTypeLoader().parse(url, TestCase.type, xmlOptions);
        }

        public static TestCase parse(InputStream inputStream) throws XmlException, IOException {
            return (TestCase) XmlBeans.getContextTypeLoader().parse(inputStream, TestCase.type, (XmlOptions) null);
        }

        public static TestCase parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TestCase) XmlBeans.getContextTypeLoader().parse(inputStream, TestCase.type, xmlOptions);
        }

        public static TestCase parse(Reader reader) throws XmlException, IOException {
            return (TestCase) XmlBeans.getContextTypeLoader().parse(reader, TestCase.type, (XmlOptions) null);
        }

        public static TestCase parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TestCase) XmlBeans.getContextTypeLoader().parse(reader, TestCase.type, xmlOptions);
        }

        public static TestCase parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (TestCase) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TestCase.type, (XmlOptions) null);
        }

        public static TestCase parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (TestCase) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TestCase.type, xmlOptions);
        }

        public static TestCase parse(Node node) throws XmlException {
            return (TestCase) XmlBeans.getContextTypeLoader().parse(node, TestCase.type, (XmlOptions) null);
        }

        public static TestCase parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (TestCase) XmlBeans.getContextTypeLoader().parse(node, TestCase.type, xmlOptions);
        }

        public static TestCase parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (TestCase) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TestCase.type, (XmlOptions) null);
        }

        public static TestCase parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (TestCase) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TestCase.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TestCase.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TestCase.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
