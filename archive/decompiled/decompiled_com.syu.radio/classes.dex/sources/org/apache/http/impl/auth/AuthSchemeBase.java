package org.apache.http.impl.auth;

import org.apache.http.Header;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public abstract class AuthSchemeBase implements AuthScheme {
    protected abstract void parseChallenge(CharArrayBuffer charArrayBuffer, int i, int i2) throws MalformedChallengeException;

    public AuthSchemeBase() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.auth.AuthScheme
    public void processChallenge(Header header) throws MalformedChallengeException {
        throw new RuntimeException("Stub!");
    }

    public boolean isProxy() {
        throw new RuntimeException("Stub!");
    }
}
