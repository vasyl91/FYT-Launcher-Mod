package org.apache.xmlbeans.impl.common;

import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import org.apache.xmlbeans.XmlCursor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface ValidatorListener {
    public static final int ATTR = 4;
    public static final int BEGIN = 1;
    public static final int END = 2;
    public static final int ENDATTRS = 5;
    public static final int TEXT = 3;

    public interface Event extends PrefixResolver {
        public static final int COLLAPSE = 3;
        public static final int PRESERVE = 1;
        public static final int REPLACE = 2;

        Location getLocation();

        XmlCursor getLocationAsCursor();

        QName getName();

        String getText();

        String getText(int i);

        String getXsiLoc();

        String getXsiNil();

        String getXsiNoLoc();

        String getXsiType();

        boolean textIsWhitespace();
    }

    void nextEvent(int i, Event event);
}
