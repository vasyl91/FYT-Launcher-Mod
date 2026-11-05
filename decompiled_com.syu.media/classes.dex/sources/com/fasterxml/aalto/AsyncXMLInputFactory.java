package com.fasterxml.aalto;

import java.nio.ByteBuffer;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLInputFactory2;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public abstract class AsyncXMLInputFactory extends XMLInputFactory2 {
    public abstract AsyncXMLStreamReader<AsyncByteBufferFeeder> createAsyncFor(ByteBuffer byteBuffer) throws XMLStreamException;

    public abstract AsyncXMLStreamReader<AsyncByteArrayFeeder> createAsyncFor(byte[] bArr) throws XMLStreamException;

    public abstract AsyncXMLStreamReader<AsyncByteArrayFeeder> createAsyncFor(byte[] bArr, int i, int i2) throws XMLStreamException;

    public abstract AsyncXMLStreamReader<AsyncByteArrayFeeder> createAsyncForByteArray();

    public abstract AsyncXMLStreamReader<AsyncByteBufferFeeder> createAsyncForByteBuffer();
}
