package org.codehaus.stax2.ri;

import javax.xml.stream.Location;
import org.codehaus.stax2.XMLStreamLocation2;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class Stax2LocationAdapter implements XMLStreamLocation2 {
    protected final Location mParentLocation;
    protected final Location mWrappedLocation;

    public Stax2LocationAdapter(Location location) {
        this(location, null);
    }

    public Stax2LocationAdapter(Location location, Location location2) {
        this.mWrappedLocation = location;
        this.mParentLocation = location2;
    }

    public int getCharacterOffset() {
        return this.mWrappedLocation.getCharacterOffset();
    }

    public int getColumnNumber() {
        return this.mWrappedLocation.getColumnNumber();
    }

    public int getLineNumber() {
        return this.mWrappedLocation.getLineNumber();
    }

    public String getPublicId() {
        return this.mWrappedLocation.getPublicId();
    }

    public String getSystemId() {
        return this.mWrappedLocation.getSystemId();
    }

    @Override // org.codehaus.stax2.XMLStreamLocation2
    public XMLStreamLocation2 getContext() {
        Location location = this.mParentLocation;
        if (location == null) {
            return null;
        }
        if (location instanceof XMLStreamLocation2) {
            return (XMLStreamLocation2) location;
        }
        return new Stax2LocationAdapter(location);
    }
}
