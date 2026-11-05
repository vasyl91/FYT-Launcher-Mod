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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface ReducedDerivationControl extends DerivationControl {
    public static final int INT_EXTENSION = 2;
    public static final int INT_RESTRICTION = 3;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(ReducedDerivationControl.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("reducedderivationcontrole1cbtype");
    public static final DerivationControl.Enum EXTENSION = DerivationControl.EXTENSION;
    public static final DerivationControl.Enum RESTRICTION = DerivationControl.RESTRICTION;

    public static final class Factory {
        public static ReducedDerivationControl newValue(Object obj) {
            return ReducedDerivationControl.type.newValue(obj);
        }

        public static ReducedDerivationControl newInstance() {
            return XmlBeans.getContextTypeLoader().newInstance(ReducedDerivationControl.type, (XmlOptions) null);
        }

        public static ReducedDerivationControl newInstance(XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newInstance(ReducedDerivationControl.type, xmlOptions);
        }

        public static ReducedDerivationControl parse(String str) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, ReducedDerivationControl.type, (XmlOptions) null);
        }

        public static ReducedDerivationControl parse(String str, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, ReducedDerivationControl.type, xmlOptions);
        }

        public static ReducedDerivationControl parse(File file) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, ReducedDerivationControl.type, (XmlOptions) null);
        }

        public static ReducedDerivationControl parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, ReducedDerivationControl.type, xmlOptions);
        }

        public static ReducedDerivationControl parse(URL url) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, ReducedDerivationControl.type, (XmlOptions) null);
        }

        public static ReducedDerivationControl parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, ReducedDerivationControl.type, xmlOptions);
        }

        public static ReducedDerivationControl parse(InputStream inputStream) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, ReducedDerivationControl.type, (XmlOptions) null);
        }

        public static ReducedDerivationControl parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, ReducedDerivationControl.type, xmlOptions);
        }

        public static ReducedDerivationControl parse(Reader reader) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, ReducedDerivationControl.type, (XmlOptions) null);
        }

        public static ReducedDerivationControl parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, ReducedDerivationControl.type, xmlOptions);
        }

        public static ReducedDerivationControl parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ReducedDerivationControl.type, (XmlOptions) null);
        }

        public static ReducedDerivationControl parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ReducedDerivationControl.type, xmlOptions);
        }

        public static ReducedDerivationControl parse(Node node) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, ReducedDerivationControl.type, (XmlOptions) null);
        }

        public static ReducedDerivationControl parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, ReducedDerivationControl.type, xmlOptions);
        }

        public static ReducedDerivationControl parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, ReducedDerivationControl.type, (XmlOptions) null);
        }

        public static ReducedDerivationControl parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, ReducedDerivationControl.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ReducedDerivationControl.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ReducedDerivationControl.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
