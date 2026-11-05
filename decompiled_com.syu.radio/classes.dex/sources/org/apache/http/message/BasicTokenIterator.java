package org.apache.http.message;

import java.util.NoSuchElementException;
import org.apache.http.HeaderIterator;
import org.apache.http.ParseException;
import org.apache.http.TokenIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class BasicTokenIterator implements TokenIterator {
    public static final String HTTP_SEPARATORS = " ,;=()<>@:\\\"/[]?{}\t";
    protected String currentHeader;
    protected String currentToken;
    protected final HeaderIterator headerIt;
    protected int searchPos;

    public BasicTokenIterator(HeaderIterator headerIterator) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.TokenIterator, java.util.Iterator
    public boolean hasNext() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.TokenIterator
    public String nextToken() throws ParseException, NoSuchElementException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.util.Iterator
    public final Object next() throws ParseException, NoSuchElementException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.util.Iterator
    public final void remove() throws UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    protected int findNext(int from) throws ParseException {
        throw new RuntimeException("Stub!");
    }

    protected String createToken(String value, int start, int end) {
        throw new RuntimeException("Stub!");
    }

    protected int findTokenStart(int from) {
        throw new RuntimeException("Stub!");
    }

    protected int findTokenSeparator(int from) {
        throw new RuntimeException("Stub!");
    }

    protected int findTokenEnd(int from) {
        throw new RuntimeException("Stub!");
    }

    protected boolean isTokenSeparator(char ch) {
        throw new RuntimeException("Stub!");
    }

    protected boolean isWhitespace(char ch) {
        throw new RuntimeException("Stub!");
    }

    protected boolean isTokenChar(char ch) {
        throw new RuntimeException("Stub!");
    }

    protected boolean isHttpSeparator(char ch) {
        throw new RuntimeException("Stub!");
    }
}
