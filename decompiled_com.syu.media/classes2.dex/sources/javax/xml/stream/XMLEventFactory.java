package javax.xml.stream;

import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.Comment;
import javax.xml.stream.events.DTD;
import javax.xml.stream.events.EndDocument;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.EntityDeclaration;
import javax.xml.stream.events.EntityReference;
import javax.xml.stream.events.Namespace;
import javax.xml.stream.events.ProcessingInstruction;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class XMLEventFactory {
    public abstract Attribute createAttribute(String str, String str2);

    public abstract Attribute createAttribute(String str, String str2, String str3, String str4);

    public abstract Attribute createAttribute(QName qName, String str);

    public abstract Characters createCData(String str);

    public abstract Characters createCharacters(String str);

    public abstract Comment createComment(String str);

    public abstract DTD createDTD(String str);

    public abstract EndDocument createEndDocument();

    public abstract EndElement createEndElement(String str, String str2, String str3);

    public abstract EndElement createEndElement(String str, String str2, String str3, Iterator it);

    public abstract EndElement createEndElement(QName qName, Iterator it);

    public abstract EntityReference createEntityReference(String str, EntityDeclaration entityDeclaration);

    public abstract Characters createIgnorableSpace(String str);

    public abstract Namespace createNamespace(String str);

    public abstract Namespace createNamespace(String str, String str2);

    public abstract ProcessingInstruction createProcessingInstruction(String str, String str2);

    public abstract Characters createSpace(String str);

    public abstract StartDocument createStartDocument();

    public abstract StartDocument createStartDocument(String str);

    public abstract StartDocument createStartDocument(String str, String str2);

    public abstract StartDocument createStartDocument(String str, String str2, boolean z);

    public abstract StartElement createStartElement(String str, String str2, String str3);

    public abstract StartElement createStartElement(String str, String str2, String str3, Iterator it, Iterator it2);

    public abstract StartElement createStartElement(String str, String str2, String str3, Iterator it, Iterator it2, NamespaceContext namespaceContext);

    public abstract StartElement createStartElement(QName qName, Iterator it, Iterator it2);

    public abstract void setLocation(Location location);

    protected XMLEventFactory() {
    }

    public static XMLEventFactory newInstance() throws FactoryConfigurationError {
        return (XMLEventFactory) FactoryFinder.find("javax.xml.stream.XMLEventFactory", "com.bea.xml.stream.EventFactory");
    }

    public static XMLEventFactory newInstance(String str, ClassLoader classLoader) throws FactoryConfigurationError {
        return (XMLEventFactory) FactoryFinder.find(str, "com.bea.xml.stream.EventFactory", classLoader);
    }
}
