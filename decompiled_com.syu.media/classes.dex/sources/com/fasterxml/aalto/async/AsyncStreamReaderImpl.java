package com.fasterxml.aalto.async;

import com.fasterxml.aalto.AsyncInputFeeder;
import com.fasterxml.aalto.AsyncXMLStreamReader;
import com.fasterxml.aalto.stax.StreamReaderImpl;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class AsyncStreamReaderImpl<F extends AsyncInputFeeder> extends StreamReaderImpl implements AsyncXMLStreamReader<F> {
    protected final AsyncByteScanner _asyncScanner;

    public AsyncStreamReaderImpl(AsyncByteScanner asyncByteScanner) {
        super(asyncByteScanner);
        this._asyncScanner = asyncByteScanner;
        this._currToken = 257;
    }

    @Override // com.fasterxml.aalto.AsyncXMLStreamReader
    public F getInputFeeder() {
        return this._asyncScanner;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.fasterxml.aalto.stax.StreamReaderImpl
    protected void _reportNonTextEvent(int i) throws XMLStreamException {
        if (i == 257) {
            throwWfe("Can not use text-aggregating methods with non-blocking parser, as they (may) require blocking");
        }
        super._reportNonTextEvent(i);
    }
}
