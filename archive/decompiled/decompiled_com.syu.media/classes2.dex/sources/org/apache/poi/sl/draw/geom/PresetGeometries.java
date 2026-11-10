package org.apache.poi.sl.draw.geom;

import java.io.InputStream;
import java.util.LinkedHashMap;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.EventFilter;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import org.apache.poi.sl.draw.binding.CTCustomGeometry2D;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.StaxHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class PresetGeometries extends LinkedHashMap<String, CustomGeometry> {
    protected static final String BINDING_PACKAGE = "org.apache.poi.sl.draw.binding";
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) PresetGeometries.class);
    protected static PresetGeometries _inst;

    protected PresetGeometries() {
    }

    public void init(InputStream inputStream) throws XMLStreamException, JAXBException {
        EventFilter eventFilter = new EventFilter() { // from class: org.apache.poi.sl.draw.geom.PresetGeometries.1
            @Override // javax.xml.stream.EventFilter
            public boolean accept(XMLEvent xMLEvent) {
                return xMLEvent.isStartElement();
            }
        };
        XMLInputFactory xMLInputFactoryNewXMLInputFactory = StaxHelper.newXMLInputFactory();
        XMLEventReader xMLEventReaderCreateXMLEventReader = xMLInputFactoryNewXMLInputFactory.createXMLEventReader(inputStream);
        XMLEventReader xMLEventReaderCreateFilteredReader = xMLInputFactoryNewXMLInputFactory.createFilteredReader(xMLEventReaderCreateXMLEventReader, eventFilter);
        xMLEventReaderCreateFilteredReader.nextEvent();
        Unmarshaller unmarshallerCreateUnmarshaller = JAXBContext.newInstance(BINDING_PACKAGE).createUnmarshaller();
        while (xMLEventReaderCreateFilteredReader.peek() != null) {
            String localPart = ((StartElement) xMLEventReaderCreateFilteredReader.peek()).getName().getLocalPart();
            CTCustomGeometry2D cTCustomGeometry2D = (CTCustomGeometry2D) unmarshallerCreateUnmarshaller.unmarshal(xMLEventReaderCreateXMLEventReader, CTCustomGeometry2D.class).getValue();
            if (containsKey(localPart)) {
                LOG.log(5, "Duplicate definition of " + localPart);
            }
            put(localPart, new CustomGeometry(cTCustomGeometry2D));
        }
    }

    public static CustomGeometry convertCustomGeometry(XMLStreamReader xMLStreamReader) {
        try {
            return new CustomGeometry((CTCustomGeometry2D) JAXBContext.newInstance(BINDING_PACKAGE).createUnmarshaller().unmarshal(xMLStreamReader, CTCustomGeometry2D.class).getValue());
        } catch (JAXBException e) {
            LOG.log(7, "Unable to parse single custom geometry", e);
            return null;
        }
    }

    public static synchronized PresetGeometries getInstance() {
        if (_inst == null) {
            PresetGeometries presetGeometries = new PresetGeometries();
            try {
                InputStream resourceAsStream = PresetGeometries.class.getResourceAsStream("presetShapeDefinitions.xml");
                try {
                    presetGeometries.init(resourceAsStream);
                    resourceAsStream.close();
                    _inst = presetGeometries;
                } catch (Throwable th) {
                    resourceAsStream.close();
                    throw th;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return _inst;
    }
}
