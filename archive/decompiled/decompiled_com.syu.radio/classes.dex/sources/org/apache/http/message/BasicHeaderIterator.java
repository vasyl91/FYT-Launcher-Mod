package org.apache.http.message;

import java.util.NoSuchElementException;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class BasicHeaderIterator implements HeaderIterator {
    protected final Header[] allHeaders = null;
    protected int currentIndex;
    protected String headerName;

    public BasicHeaderIterator(Header[] headers, String name) {
        throw new RuntimeException("Stub!");
    }

    protected int findNext(int from) {
        throw new RuntimeException("Stub!");
    }

    protected boolean filterHeader(int index) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HeaderIterator, java.util.Iterator
    public boolean hasNext() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HeaderIterator
    public Header nextHeader() throws NoSuchElementException {
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
