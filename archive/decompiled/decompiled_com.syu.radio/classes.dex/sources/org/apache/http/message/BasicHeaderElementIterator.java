package org.apache.http.message;

import java.util.NoSuchElementException;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HeaderIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class BasicHeaderElementIterator implements HeaderElementIterator {
    public BasicHeaderElementIterator(HeaderIterator headerIterator, HeaderValueParser parser) {
        throw new RuntimeException("Stub!");
    }

    public BasicHeaderElementIterator(HeaderIterator headerIterator) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HeaderElementIterator, java.util.Iterator
    public boolean hasNext() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HeaderElementIterator
    public HeaderElement nextElement() throws NoSuchElementException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.util.Iterator
    public final Object next() throws NoSuchElementException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.util.Iterator
    public void remove() throws UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }
}
