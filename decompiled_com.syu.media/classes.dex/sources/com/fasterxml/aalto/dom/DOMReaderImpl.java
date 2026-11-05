package com.fasterxml.aalto.dom;

import com.fasterxml.aalto.WFCException;
import com.fasterxml.aalto.in.ReaderConfig;
import java.util.Collections;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.dom.DOMSource;
import org.codehaus.stax2.ri.dom.DOMWrappingReader;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class DOMReaderImpl extends DOMWrappingReader {
    protected final ReaderConfig _config;

    protected DOMReaderImpl(DOMSource dOMSource, ReaderConfig readerConfig) throws XMLStreamException {
        super(dOMSource, readerConfig.willSupportNamespaces(), readerConfig.willCoalesceText());
        this._config = readerConfig;
        if (readerConfig.hasInternNamesBeenEnabled()) {
            setInternNames(readerConfig.willInternNames());
        }
        if (readerConfig.hasInternNsURIsBeenEnabled()) {
            setInternNsURIs(readerConfig.willInternNsURIs());
        }
    }

    public static DOMReaderImpl createFrom(DOMSource dOMSource, ReaderConfig readerConfig) throws XMLStreamException {
        return new DOMReaderImpl(dOMSource, readerConfig);
    }

    public boolean isPropertySupported(String str) {
        return this._config.isPropertySupported(str);
    }

    public Object getProperty(String str) {
        if (str.equals("javax.xml.stream.entities")) {
            return Collections.EMPTY_LIST;
        }
        if (str.equals("javax.xml.stream.notations")) {
            return Collections.EMPTY_LIST;
        }
        return this._config.getProperty(str, true);
    }

    public boolean setProperty(String str, Object obj) {
        return this._config.setProperty(str, obj);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void throwStreamException(String str, Location location) throws XMLStreamException {
        throw new WFCException(str, location);
    }
}
