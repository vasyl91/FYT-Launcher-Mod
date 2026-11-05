package com.fasterxml.aalto.impl;

import java.io.IOException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class IoStreamException extends StreamExceptionBase {
    public IoStreamException(IOException iOException) {
        super(iOException);
    }

    public IoStreamException(String str) {
        super(str);
    }
}
