package org.apache.xmlbeans.impl.common;

import java.net.URI;
import java.util.AbstractCollection;
import java.util.Collections;
import java.util.Iterator;
import org.apache.xmlbeans.XmlError;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XmlErrorPrinter extends AbstractCollection {
    private URI _baseURI;
    private boolean _noisy;

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return 0;
    }

    public XmlErrorPrinter(boolean z, URI uri) {
        this._noisy = z;
        this._baseURI = uri;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(Object obj) {
        if (!(obj instanceof XmlError)) {
            return false;
        }
        XmlError xmlError = (XmlError) obj;
        if (xmlError.getSeverity() == 0 || xmlError.getSeverity() == 1) {
            System.err.println(xmlError.toString(this._baseURI));
            return false;
        }
        if (!this._noisy) {
            return false;
        }
        System.out.println(xmlError.toString(this._baseURI));
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return Collections.EMPTY_LIST.iterator();
    }
}
