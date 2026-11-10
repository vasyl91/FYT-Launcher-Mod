package org.apache.xmlbeans;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.ref.SoftReference;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface XmlFactoryHook {
    DOMImplementation newDomImplementation(SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions);

    XmlObject newInstance(SchemaTypeLoader schemaTypeLoader, SchemaType schemaType, XmlOptions xmlOptions);

    XmlSaxHandler newXmlSaxHandler(SchemaTypeLoader schemaTypeLoader, SchemaType schemaType, XmlOptions xmlOptions);

    XmlObject parse(SchemaTypeLoader schemaTypeLoader, InputStream inputStream, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException;

    XmlObject parse(SchemaTypeLoader schemaTypeLoader, Reader reader, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException;

    XmlObject parse(SchemaTypeLoader schemaTypeLoader, String str, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException;

    XmlObject parse(SchemaTypeLoader schemaTypeLoader, XMLStreamReader xMLStreamReader, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException;

    XmlObject parse(SchemaTypeLoader schemaTypeLoader, XMLInputStream xMLInputStream, SchemaType schemaType, XmlOptions xmlOptions) throws XMLStreamException, XmlException;

    XmlObject parse(SchemaTypeLoader schemaTypeLoader, Node node, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException;

    public static final class ThreadContext {
        private static ThreadLocal threadHook = new ThreadLocal();

        public static void clearThreadLocals() {
            threadHook.remove();
        }

        public static XmlFactoryHook getHook() {
            SoftReference softReference = (SoftReference) threadHook.get();
            if (softReference == null) {
                return null;
            }
            return (XmlFactoryHook) softReference.get();
        }

        public static void setHook(XmlFactoryHook xmlFactoryHook) {
            threadHook.set(new SoftReference(xmlFactoryHook));
        }

        private ThreadContext() {
        }
    }
}
