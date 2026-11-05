package org.apache.xmlbeans.impl.common;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import org.apache.xmlbeans.XmlError;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XmlErrorWatcher extends AbstractCollection {
    private XmlError _firstError;
    private Collection _underlying;

    public XmlErrorWatcher(Collection collection) {
        this._underlying = collection;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(Object obj) {
        if (this._firstError == null && (obj instanceof XmlError)) {
            XmlError xmlError = (XmlError) obj;
            if (xmlError.getSeverity() == 0) {
                this._firstError = xmlError;
            }
        }
        Collection collection = this._underlying;
        if (collection == null) {
            return false;
        }
        return collection.add(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        Collection collection = this._underlying;
        if (collection == null) {
            return Collections.EMPTY_LIST.iterator();
        }
        return collection.iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        Collection collection = this._underlying;
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    public boolean hasError() {
        return this._firstError != null;
    }

    public XmlError firstError() {
        return this._firstError;
    }
}
