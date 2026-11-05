package com.fasterxml.aalto.stax;

import com.fasterxml.aalto.AsyncByteArrayFeeder;
import com.fasterxml.aalto.AsyncByteBufferFeeder;
import com.fasterxml.aalto.AsyncXMLInputFactory;
import com.fasterxml.aalto.AsyncXMLStreamReader;
import com.fasterxml.aalto.async.AsyncByteArrayScanner;
import com.fasterxml.aalto.async.AsyncByteBufferScanner;
import com.fasterxml.aalto.async.AsyncStreamReaderImpl;
import com.fasterxml.aalto.dom.DOMReaderImpl;
import com.fasterxml.aalto.evt.EventAllocatorImpl;
import com.fasterxml.aalto.evt.EventReaderImpl;
import com.fasterxml.aalto.impl.IoStreamException;
import com.fasterxml.aalto.in.ByteSourceBootstrapper;
import com.fasterxml.aalto.in.CharSourceBootstrapper;
import com.fasterxml.aalto.in.ReaderConfig;
import com.fasterxml.aalto.util.URLUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.nio.ByteBuffer;
import javax.xml.stream.EventFilter;
import javax.xml.stream.StreamFilter;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLReporter;
import javax.xml.stream.XMLResolver;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.XMLEventAllocator;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamSource;
import org.codehaus.stax2.XMLEventReader2;
import org.codehaus.stax2.XMLStreamReader2;
import org.codehaus.stax2.io.Stax2ByteArraySource;
import org.codehaus.stax2.io.Stax2CharArraySource;
import org.codehaus.stax2.io.Stax2Source;
import org.codehaus.stax2.ri.Stax2FilteredStreamReader;
import org.codehaus.stax2.ri.Stax2ReaderAdapter;
import org.codehaus.stax2.ri.evt.Stax2EventReaderAdapter;
import org.codehaus.stax2.ri.evt.Stax2FilteredEventReader;
import org.xml.sax.InputSource;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class InputFactoryImpl extends AsyncXMLInputFactory {
    protected XMLEventAllocator _allocator = null;
    final ReaderConfig _config = new ReaderConfig();

    public XMLEventReader createFilteredReader(XMLEventReader xMLEventReader, EventFilter eventFilter) {
        return new Stax2FilteredEventReader(Stax2EventReaderAdapter.wrapIfNecessary(xMLEventReader), eventFilter);
    }

    public XMLStreamReader createFilteredReader(XMLStreamReader xMLStreamReader, StreamFilter streamFilter) throws XMLStreamException {
        Stax2FilteredStreamReader stax2FilteredStreamReader = new Stax2FilteredStreamReader(xMLStreamReader, streamFilter);
        if (!streamFilter.accept(stax2FilteredStreamReader)) {
            stax2FilteredStreamReader.next();
        }
        return stax2FilteredStreamReader;
    }

    public XMLEventReader createXMLEventReader(InputStream inputStream) throws XMLStreamException {
        return createXMLEventReader(inputStream, (String) null);
    }

    public XMLEventReader createXMLEventReader(InputStream inputStream, String str) throws XMLStreamException {
        return constructER(constructSR(inputStream, str, true));
    }

    public XMLEventReader createXMLEventReader(Reader reader) throws XMLStreamException {
        return createXMLEventReader((String) null, reader);
    }

    public XMLEventReader createXMLEventReader(Source source) throws XMLStreamException {
        return constructER(constructSR(source, true));
    }

    public XMLEventReader createXMLEventReader(String str, InputStream inputStream) throws XMLStreamException {
        return constructER(constructSR(str, inputStream, true));
    }

    public XMLEventReader createXMLEventReader(String str, Reader reader) throws XMLStreamException {
        return constructER(constructSR(str, reader, true));
    }

    public XMLEventReader createXMLEventReader(XMLStreamReader xMLStreamReader) throws XMLStreamException {
        return constructER(Stax2ReaderAdapter.wrapIfNecessary(xMLStreamReader));
    }

    public XMLStreamReader createXMLStreamReader(InputStream inputStream) throws XMLStreamException {
        return constructSR(inputStream, (String) null, false);
    }

    public XMLStreamReader createXMLStreamReader(InputStream inputStream, String str) throws XMLStreamException {
        return constructSR(inputStream, str, false);
    }

    public XMLStreamReader createXMLStreamReader(Reader reader) throws XMLStreamException {
        return constructSR((String) null, reader, false);
    }

    public XMLStreamReader createXMLStreamReader(String str, Reader reader) throws XMLStreamException {
        return constructSR(str, reader, false);
    }

    public XMLStreamReader createXMLStreamReader(Source source) throws XMLStreamException {
        return constructSR(source, false);
    }

    public XMLStreamReader createXMLStreamReader(String str, InputStream inputStream) throws XMLStreamException {
        return constructSR(str, inputStream, false);
    }

    public Object getProperty(String str) {
        return this._config.getProperty(str, true);
    }

    public void setProperty(String str, Object obj) {
        this._config.setProperty(str, obj);
    }

    public XMLEventAllocator getEventAllocator() {
        return this._allocator;
    }

    public XMLReporter getXMLReporter() {
        return this._config.getXMLReporter();
    }

    public XMLResolver getXMLResolver() {
        return this._config.getXMLResolver();
    }

    public boolean isPropertySupported(String str) {
        return this._config.isPropertySupported(str);
    }

    public void setEventAllocator(XMLEventAllocator xMLEventAllocator) {
        this._allocator = xMLEventAllocator;
    }

    public void setXMLReporter(XMLReporter xMLReporter) {
        this._config.setXMLReporter(xMLReporter);
    }

    public void setXMLResolver(XMLResolver xMLResolver) {
        this._config.setXMLResolver(xMLResolver);
    }

    public XMLEventReader2 createXMLEventReader(URL url) throws XMLStreamException {
        return constructER(constructSR(url, true));
    }

    public XMLEventReader2 createXMLEventReader(File file) throws XMLStreamException {
        return constructER(constructSR(file, true));
    }

    public XMLStreamReader2 createXMLStreamReader(URL url) throws XMLStreamException {
        return constructSR(url, false);
    }

    public XMLStreamReader2 createXMLStreamReader(File file) throws XMLStreamException {
        return constructSR(file, false);
    }

    public void configureForXmlConformance() {
        this._config.configureForXmlConformance();
    }

    public void configureForConvenience() {
        this._config.configureForConvenience();
    }

    public void configureForSpeed() {
        this._config.configureForSpeed();
    }

    public void configureForLowMemUsage() {
        this._config.configureForLowMemUsage();
    }

    public void configureForRoundTripping() {
        this._config.configureForRoundTripping();
    }

    @Override // com.fasterxml.aalto.AsyncXMLInputFactory
    public AsyncXMLStreamReader<AsyncByteArrayFeeder> createAsyncForByteArray() {
        ReaderConfig nonSharedConfig = getNonSharedConfig(null, null, null, false, false);
        nonSharedConfig.setActualEncoding("UTF-8");
        return new AsyncStreamReaderImpl(new AsyncByteArrayScanner(nonSharedConfig));
    }

    @Override // com.fasterxml.aalto.AsyncXMLInputFactory
    public AsyncXMLStreamReader<AsyncByteArrayFeeder> createAsyncFor(byte[] bArr) throws XMLStreamException {
        return createAsyncFor(bArr, 0, bArr.length);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.AsyncXMLInputFactory
    public AsyncXMLStreamReader<AsyncByteArrayFeeder> createAsyncFor(byte[] bArr, int i, int i2) throws XMLStreamException {
        ReaderConfig nonSharedConfig = getNonSharedConfig(null, null, null, false, false);
        nonSharedConfig.setActualEncoding("UTF-8");
        AsyncByteArrayScanner asyncByteArrayScanner = new AsyncByteArrayScanner(nonSharedConfig);
        asyncByteArrayScanner.feedInput(bArr, i, i2);
        return new AsyncStreamReaderImpl(asyncByteArrayScanner);
    }

    @Override // com.fasterxml.aalto.AsyncXMLInputFactory
    public AsyncXMLStreamReader<AsyncByteBufferFeeder> createAsyncForByteBuffer() {
        ReaderConfig nonSharedConfig = getNonSharedConfig(null, null, null, false, false);
        nonSharedConfig.setActualEncoding("UTF-8");
        return new AsyncStreamReaderImpl(new AsyncByteBufferScanner(nonSharedConfig));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.AsyncXMLInputFactory
    public AsyncXMLStreamReader<AsyncByteBufferFeeder> createAsyncFor(ByteBuffer byteBuffer) throws XMLStreamException {
        ReaderConfig nonSharedConfig = getNonSharedConfig(null, null, null, false, false);
        nonSharedConfig.setActualEncoding("UTF-8");
        AsyncByteBufferScanner asyncByteBufferScanner = new AsyncByteBufferScanner(nonSharedConfig);
        asyncByteBufferScanner.feedInput(byteBuffer);
        return new AsyncStreamReaderImpl(asyncByteBufferScanner);
    }

    public ReaderConfig getNonSharedConfig(String str, String str2, String str3, boolean z, boolean z2) {
        ReaderConfig readerConfigCreateNonShared = this._config.createNonShared(str2, str, str3);
        if (z) {
            readerConfigCreateNonShared.doParseLazily(false);
        }
        if (z2) {
            readerConfigCreateNonShared.doAutoCloseInput(true);
        }
        return readerConfigCreateNonShared;
    }

    protected XMLStreamReader2 constructSR(InputStream inputStream, String str, boolean z) throws XMLStreamException {
        return StreamReaderImpl.construct(ByteSourceBootstrapper.construct(getNonSharedConfig(null, null, str, z, false), inputStream));
    }

    protected XMLStreamReader2 constructSR(String str, Reader reader, boolean z) throws XMLStreamException {
        return StreamReaderImpl.construct(CharSourceBootstrapper.construct(getNonSharedConfig(null, str, null, z, false), reader));
    }

    protected XMLStreamReader2 constructSR(String str, InputStream inputStream, boolean z) throws XMLStreamException {
        return StreamReaderImpl.construct(ByteSourceBootstrapper.construct(getNonSharedConfig(null, str, null, z, false), inputStream));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v5 */
    protected XMLStreamReader2 constructSR(Source source, boolean z) throws XMLStreamException {
        String systemId;
        Reader characterStream;
        String str;
        String str2;
        ?? r2;
        if (source instanceof Stax2Source) {
            return constructSR2((Stax2Source) source, z);
        }
        String publicId = null;
        String encoding = null;
        Reader reader = null;
        if (source instanceof StreamSource) {
            StreamSource streamSource = (StreamSource) source;
            systemId = streamSource.getSystemId();
            String publicId2 = streamSource.getPublicId();
            InputStream inputStream = streamSource.getInputStream();
            reader = inputStream == null ? streamSource.getReader() : null;
            str = publicId2;
            str2 = null;
            r2 = inputStream;
        } else if (source instanceof SAXSource) {
            SAXSource sAXSource = (SAXSource) source;
            systemId = sAXSource.getSystemId();
            InputSource inputSource = sAXSource.getInputSource();
            if (inputSource != null) {
                systemId = inputSource.getSystemId();
                publicId = inputSource.getPublicId();
                encoding = inputSource.getEncoding();
                InputStream byteStream = inputSource.getByteStream();
                characterStream = byteStream == null ? inputSource.getCharacterStream() : null;
                reader = byteStream;
            } else {
                characterStream = null;
            }
            str = publicId;
            str2 = encoding;
            r2 = reader;
            reader = characterStream;
        } else {
            if (source instanceof DOMSource) {
                return DOMReaderImpl.createFrom((DOMSource) source, getNonSharedConfig(null, null, null, z, false));
            }
            throw new IllegalArgumentException("Can not instantiate StAX reader for XML source type " + source.getClass() + " (unrecognized type)");
        }
        if (r2 != 0) {
            return StreamReaderImpl.construct(ByteSourceBootstrapper.construct(getNonSharedConfig(str, systemId, str2, z, false), r2));
        }
        if (reader != null) {
            return StreamReaderImpl.construct(CharSourceBootstrapper.construct(getNonSharedConfig(str, systemId, str2, z, false), reader));
        }
        if (systemId != null && systemId.length() > 0) {
            try {
                return StreamReaderImpl.construct(ByteSourceBootstrapper.construct(getNonSharedConfig(str, systemId, str2, z, true), URLUtil.inputStreamFromURL(URLUtil.urlFromSystemId(systemId))));
            } catch (IOException e) {
                throw new IoStreamException(e);
            }
        }
        throw new XMLStreamException("Can not create Stax reader for the Source passed -- neither reader, input stream nor system id was accessible; can not use other types of sources (like embedded SAX streams)");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected XMLStreamReader2 constructSR2(Stax2Source stax2Source, boolean z) throws XMLStreamException {
        ReaderConfig nonSharedConfig = getNonSharedConfig(stax2Source.getPublicId(), stax2Source.getSystemId(), stax2Source.getEncoding(), z, true);
        if (stax2Source instanceof Stax2ByteArraySource) {
            Stax2ByteArraySource stax2ByteArraySource = (Stax2ByteArraySource) stax2Source;
            return StreamReaderImpl.construct(ByteSourceBootstrapper.construct(nonSharedConfig, stax2ByteArraySource.getBuffer(), stax2ByteArraySource.getBufferStart(), stax2ByteArraySource.getBufferLength()));
        }
        if (stax2Source instanceof Stax2CharArraySource) {
            Stax2CharArraySource stax2CharArraySource = (Stax2CharArraySource) stax2Source;
            return StreamReaderImpl.construct(CharSourceBootstrapper.construct(nonSharedConfig, stax2CharArraySource.getBuffer(), stax2CharArraySource.getBufferStart(), stax2CharArraySource.getBufferLength()));
        }
        try {
            InputStream inputStreamConstructInputStream = stax2Source.constructInputStream();
            if (inputStreamConstructInputStream != null) {
                return StreamReaderImpl.construct(ByteSourceBootstrapper.construct(nonSharedConfig, inputStreamConstructInputStream));
            }
            Reader readerConstructReader = stax2Source.constructReader();
            if (readerConstructReader != null) {
                return StreamReaderImpl.construct(CharSourceBootstrapper.construct(nonSharedConfig, readerConstructReader));
            }
            throw new IllegalArgumentException("Can not create stream reader for given Stax2Source: neither InputStream nor Reader available");
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected XMLStreamReader2 constructSR(URL url, boolean z) throws XMLStreamException {
        try {
            return StreamReaderImpl.construct(ByteSourceBootstrapper.construct(getNonSharedConfig(URLUtil.urlToSystemId(url), null, null, z, true), URLUtil.inputStreamFromURL(url)));
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected XMLStreamReader2 constructSR(File file, boolean z) throws XMLStreamException {
        try {
            return StreamReaderImpl.construct(ByteSourceBootstrapper.construct(getNonSharedConfig(URLUtil.fileToSystemId(file), null, null, z, true), new FileInputStream(file)));
        } catch (IOException e) {
            throw new IoStreamException(e);
        }
    }

    public XMLEventReader2 constructER(XMLStreamReader2 xMLStreamReader2) {
        return new EventReaderImpl(createEventAllocator(), xMLStreamReader2);
    }

    protected XMLEventAllocator createEventAllocator() {
        XMLEventAllocator xMLEventAllocator = this._allocator;
        if (xMLEventAllocator != null) {
            return xMLEventAllocator.newInstance();
        }
        if (this._config.willPreserveLocation()) {
            return EventAllocatorImpl.getDefaultInstance();
        }
        return EventAllocatorImpl.getFastInstance();
    }
}
