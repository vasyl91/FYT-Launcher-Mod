package org.codehaus.stax2.ri.evt;

import java.util.ArrayList;
import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.DTD;
import javax.xml.stream.events.EntityReference;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.util.XMLEventAllocator;
import javax.xml.stream.util.XMLEventConsumer;
import org.codehaus.stax2.DTDInfo;
import org.codehaus.stax2.XMLStreamReader2;
import org.codehaus.stax2.ri.EmptyIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class Stax2EventAllocatorImpl implements XMLEventAllocator, XMLStreamConstants {
    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public XMLEvent allocate(XMLStreamReader xMLStreamReader) throws XMLStreamException {
        Location location = getLocation(xMLStreamReader);
        switch (xMLStreamReader.getEventType()) {
            case 1:
                return createStartElement(xMLStreamReader, location);
            case 2:
                return new EndElementEventImpl(location, xMLStreamReader);
            case 3:
                return new ProcInstrEventImpl(location, xMLStreamReader.getPITarget(), xMLStreamReader.getPIData());
            case 4:
                return new CharactersEventImpl(location, xMLStreamReader.getText(), false);
            case 5:
                return new CommentEventImpl(location, xMLStreamReader.getText());
            case 6:
                CharactersEventImpl charactersEventImpl = new CharactersEventImpl(location, xMLStreamReader.getText(), false);
                charactersEventImpl.setWhitespaceStatus(true);
                return charactersEventImpl;
            case 7:
                return new StartDocumentEventImpl(location, xMLStreamReader);
            case 8:
                return new EndDocumentEventImpl(location);
            case 9:
                return createEntityReference(xMLStreamReader, location);
            case 10:
            default:
                throw new XMLStreamException("Unrecognized event type " + xMLStreamReader.getEventType() + ".");
            case 11:
                return createDTD(xMLStreamReader, location);
            case 12:
                return new CharactersEventImpl(location, xMLStreamReader.getText(), true);
        }
    }

    public void allocate(XMLStreamReader xMLStreamReader, XMLEventConsumer xMLEventConsumer) throws XMLStreamException {
        xMLEventConsumer.add(allocate(xMLStreamReader));
    }

    public XMLEventAllocator newInstance() {
        return new Stax2EventAllocatorImpl();
    }

    protected Location getLocation(XMLStreamReader xMLStreamReader) {
        return xMLStreamReader.getLocation();
    }

    protected EntityReference createEntityReference(XMLStreamReader xMLStreamReader, Location location) throws XMLStreamException {
        return new EntityReferenceEventImpl(location, xMLStreamReader.getLocalName());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected DTD createDTD(XMLStreamReader xMLStreamReader, Location location) throws XMLStreamException {
        if (xMLStreamReader instanceof XMLStreamReader2) {
            DTDInfo dTDInfo = ((XMLStreamReader2) xMLStreamReader).getDTDInfo();
            return new DTDEventImpl(location, dTDInfo.getDTDRootName(), dTDInfo.getDTDSystemId(), dTDInfo.getDTDPublicId(), dTDInfo.getDTDInternalSubset(), dTDInfo.getProcessedDTD());
        }
        return new DTDEventImpl(location, null, xMLStreamReader.getText());
    }

    protected StartElement createStartElement(XMLStreamReader xMLStreamReader, Location location) throws XMLStreamException {
        ArrayList arrayList;
        ArrayList arrayList2 = null;
        NamespaceContext nonTransientNamespaceContext = xMLStreamReader instanceof XMLStreamReader2 ? ((XMLStreamReader2) xMLStreamReader).getNonTransientNamespaceContext() : null;
        int attributeCount = xMLStreamReader.getAttributeCount();
        if (attributeCount < 1) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(attributeCount);
            for (int i = 0; i < attributeCount; i++) {
                arrayList.add(new AttributeEventImpl(location, xMLStreamReader.getAttributeName(i), xMLStreamReader.getAttributeValue(i), xMLStreamReader.isAttributeSpecified(i)));
            }
        }
        int namespaceCount = xMLStreamReader.getNamespaceCount();
        if (namespaceCount >= 1) {
            arrayList2 = new ArrayList(namespaceCount);
            for (int i2 = 0; i2 < namespaceCount; i2++) {
                arrayList2.add(NamespaceEventImpl.constructNamespace(location, xMLStreamReader.getNamespacePrefix(i2), xMLStreamReader.getNamespaceURI(i2)));
            }
        }
        return StartElementEventImpl.construct(location, xMLStreamReader.getName(), arrayList == null ? EmptyIterator.getInstance() : arrayList.iterator(), arrayList2 == null ? EmptyIterator.getInstance() : arrayList2.iterator(), nonTransientNamespaceContext);
    }
}
