package javax.xml.stream;

import java.io.OutputStream;
import java.io.Writer;
import javax.xml.transform.Result;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class XMLOutputFactory {
    public static final String IS_REPAIRING_NAMESPACES = "javax.xml.stream.isRepairingNamespaces";

    public abstract XMLEventWriter createXMLEventWriter(OutputStream outputStream) throws XMLStreamException;

    public abstract XMLEventWriter createXMLEventWriter(OutputStream outputStream, String str) throws XMLStreamException;

    public abstract XMLEventWriter createXMLEventWriter(Writer writer) throws XMLStreamException;

    public abstract XMLEventWriter createXMLEventWriter(Result result) throws XMLStreamException;

    public abstract XMLStreamWriter createXMLStreamWriter(OutputStream outputStream) throws XMLStreamException;

    public abstract XMLStreamWriter createXMLStreamWriter(OutputStream outputStream, String str) throws XMLStreamException;

    public abstract XMLStreamWriter createXMLStreamWriter(Writer writer) throws XMLStreamException;

    public abstract XMLStreamWriter createXMLStreamWriter(Result result) throws XMLStreamException;

    public abstract Object getProperty(String str) throws IllegalArgumentException;

    public abstract boolean isPropertySupported(String str);

    public abstract void setProperty(String str, Object obj) throws IllegalArgumentException;

    protected XMLOutputFactory() {
    }

    public static XMLOutputFactory newInstance() throws FactoryConfigurationError {
        return (XMLOutputFactory) FactoryFinder.find("javax.xml.stream.XMLOutputFactory", "com.bea.xml.stream.XMLOutputFactoryBase");
    }

    public static XMLInputFactory newInstance(String str, ClassLoader classLoader) throws FactoryConfigurationError {
        return (XMLInputFactory) FactoryFinder.find(str, "com.bea.xml.stream.XMLOutputFactoryBase", classLoader);
    }
}
