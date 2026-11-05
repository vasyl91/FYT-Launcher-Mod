package org.codehaus.stax2;

import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface LocationInfo {
    XMLStreamLocation2 getCurrentLocation();

    XMLStreamLocation2 getEndLocation() throws XMLStreamException;

    long getEndingByteOffset() throws XMLStreamException;

    long getEndingCharOffset() throws XMLStreamException;

    Location getLocation();

    XMLStreamLocation2 getStartLocation();

    long getStartingByteOffset();

    long getStartingCharOffset();
}
