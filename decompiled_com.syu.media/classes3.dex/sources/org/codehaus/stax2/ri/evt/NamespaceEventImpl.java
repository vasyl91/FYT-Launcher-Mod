package org.codehaus.stax2.ri.evt;

import javax.xml.stream.Location;
import javax.xml.stream.events.Namespace;
import org.apache.xmlbeans.impl.common.Sax2Dom;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class NamespaceEventImpl extends AttributeEventImpl implements Namespace {
    final String mPrefix;
    final String mURI;

    @Override // org.codehaus.stax2.ri.evt.AttributeEventImpl, org.codehaus.stax2.ri.evt.BaseEventImpl
    public int getEventType() {
        return 13;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public boolean isNamespace() {
        return true;
    }

    protected NamespaceEventImpl(Location location, String str) {
        super(location, Sax2Dom.XMLNS_PREFIX, Sax2Dom.XMLNS_URI, null, str, true);
        this.mPrefix = "";
        this.mURI = str;
    }

    protected NamespaceEventImpl(Location location, String str, String str2) {
        super(location, str, Sax2Dom.XMLNS_URI, Sax2Dom.XMLNS_PREFIX, str2, true);
        this.mPrefix = str;
        this.mURI = str2;
    }

    public static NamespaceEventImpl constructDefaultNamespace(Location location, String str) {
        return new NamespaceEventImpl(location, str);
    }

    public static NamespaceEventImpl constructNamespace(Location location, String str, String str2) {
        if (str == null || str.length() == 0) {
            return new NamespaceEventImpl(location, str2);
        }
        return new NamespaceEventImpl(location, str, str2);
    }

    public String getNamespaceURI() {
        return this.mURI;
    }

    public String getPrefix() {
        return this.mPrefix;
    }

    public boolean isDefaultNamespaceDeclaration() {
        return this.mPrefix.length() == 0;
    }
}
