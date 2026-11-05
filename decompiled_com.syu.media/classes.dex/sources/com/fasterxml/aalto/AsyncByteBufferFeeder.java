package com.fasterxml.aalto;

import java.nio.ByteBuffer;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface AsyncByteBufferFeeder extends AsyncInputFeeder {
    void feedInput(ByteBuffer byteBuffer) throws XMLStreamException;
}
