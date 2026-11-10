package org.codehaus.stax2.ri;

import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
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
import org.codehaus.stax2.evt.DTD2;
import org.codehaus.stax2.evt.XMLEventFactory2;
import org.codehaus.stax2.ri.evt.AttributeEventImpl;
import org.codehaus.stax2.ri.evt.CharactersEventImpl;
import org.codehaus.stax2.ri.evt.CommentEventImpl;
import org.codehaus.stax2.ri.evt.DTDEventImpl;
import org.codehaus.stax2.ri.evt.EndDocumentEventImpl;
import org.codehaus.stax2.ri.evt.EndElementEventImpl;
import org.codehaus.stax2.ri.evt.EntityReferenceEventImpl;
import org.codehaus.stax2.ri.evt.NamespaceEventImpl;
import org.codehaus.stax2.ri.evt.ProcInstrEventImpl;
import org.codehaus.stax2.ri.evt.StartDocumentEventImpl;
import org.codehaus.stax2.ri.evt.StartElementEventImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class Stax2EventFactoryImpl extends XMLEventFactory2 {
    protected Location mLocation;

    protected abstract QName createQName(String str, String str2);

    protected abstract QName createQName(String str, String str2, String str3);

    public Attribute createAttribute(QName qName, String str) {
        return new AttributeEventImpl(this.mLocation, qName, str, true);
    }

    public Attribute createAttribute(String str, String str2) {
        return new AttributeEventImpl(this.mLocation, str, null, null, str2, true);
    }

    public Attribute createAttribute(String str, String str2, String str3, String str4) {
        return new AttributeEventImpl(this.mLocation, str3, str2, str, str4, true);
    }

    public Characters createCData(String str) {
        return new CharactersEventImpl(this.mLocation, str, true);
    }

    public Characters createCharacters(String str) {
        return new CharactersEventImpl(this.mLocation, str, false);
    }

    public Comment createComment(String str) {
        return new CommentEventImpl(this.mLocation, str);
    }

    public DTD createDTD(String str) {
        return new DTDEventImpl(this.mLocation, str);
    }

    public EndDocument createEndDocument() {
        return new EndDocumentEventImpl(this.mLocation);
    }

    public EndElement createEndElement(QName qName, Iterator it) {
        return new EndElementEventImpl(this.mLocation, qName, it);
    }

    public EndElement createEndElement(String str, String str2, String str3) {
        return createEndElement(createQName(str2, str3, str), null);
    }

    public EndElement createEndElement(String str, String str2, String str3, Iterator it) {
        return createEndElement(createQName(str2, str3, str), it);
    }

    public EntityReference createEntityReference(String str, EntityDeclaration entityDeclaration) {
        return new EntityReferenceEventImpl(this.mLocation, entityDeclaration);
    }

    public Characters createIgnorableSpace(String str) {
        return CharactersEventImpl.createIgnorableWS(this.mLocation, str);
    }

    public Namespace createNamespace(String str) {
        return NamespaceEventImpl.constructDefaultNamespace(this.mLocation, str);
    }

    public Namespace createNamespace(String str, String str2) {
        return NamespaceEventImpl.constructNamespace(this.mLocation, str, str2);
    }

    public ProcessingInstruction createProcessingInstruction(String str, String str2) {
        return new ProcInstrEventImpl(this.mLocation, str, str2);
    }

    public Characters createSpace(String str) {
        return CharactersEventImpl.createNonIgnorableWS(this.mLocation, str);
    }

    public StartDocument createStartDocument() {
        return new StartDocumentEventImpl(this.mLocation);
    }

    public StartDocument createStartDocument(String str) {
        return new StartDocumentEventImpl(this.mLocation, str);
    }

    public StartDocument createStartDocument(String str, String str2) {
        return new StartDocumentEventImpl(this.mLocation, str, str2);
    }

    public StartDocument createStartDocument(String str, String str2, boolean z) {
        return new StartDocumentEventImpl(this.mLocation, str, str2, true, z);
    }

    public StartElement createStartElement(QName qName, Iterator it, Iterator it2) {
        return createStartElement(qName, it, it2, null);
    }

    public StartElement createStartElement(String str, String str2, String str3) {
        return createStartElement(createQName(str2, str3, str), null, null, null);
    }

    public StartElement createStartElement(String str, String str2, String str3, Iterator it, Iterator it2) {
        return createStartElement(createQName(str2, str3, str), it, it2, null);
    }

    public StartElement createStartElement(String str, String str2, String str3, Iterator it, Iterator it2, NamespaceContext namespaceContext) {
        return createStartElement(createQName(str2, str3, str), it, it2, namespaceContext);
    }

    public void setLocation(Location location) {
        this.mLocation = location;
    }

    @Override // org.codehaus.stax2.evt.XMLEventFactory2
    public DTD2 createDTD(String str, String str2, String str3, String str4) {
        return new DTDEventImpl(this.mLocation, str, str2, str3, str4, null);
    }

    @Override // org.codehaus.stax2.evt.XMLEventFactory2
    public DTD2 createDTD(String str, String str2, String str3, String str4, Object obj) {
        return new DTDEventImpl(this.mLocation, str, str2, str3, str4, obj);
    }

    protected StartElement createStartElement(QName qName, Iterator<?> it, Iterator<?> it2, NamespaceContext namespaceContext) {
        return StartElementEventImpl.construct(this.mLocation, qName, it, it2, namespaceContext);
    }
}
