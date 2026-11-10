package org.codehaus.stax2;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface XMLEventReader2 extends XMLEventReader {
    boolean hasNextEvent() throws XMLStreamException;

    boolean isPropertySupported(String str);

    boolean setProperty(String str, Object obj);
}
