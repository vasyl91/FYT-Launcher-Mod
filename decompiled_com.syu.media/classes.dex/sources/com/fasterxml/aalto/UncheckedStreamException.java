package com.fasterxml.aalto;

import java.io.PrintStream;
import java.io.PrintWriter;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class UncheckedStreamException extends RuntimeException {
    private UncheckedStreamException(XMLStreamException xMLStreamException) {
        super((Throwable) xMLStreamException);
    }

    public static UncheckedStreamException createFrom(XMLStreamException xMLStreamException) {
        return new UncheckedStreamException(xMLStreamException);
    }

    @Override // java.lang.Throwable
    public StackTraceElement[] getStackTrace() {
        return getCause().getStackTrace();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return getCause().getMessage();
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return getCause().getLocalizedMessage();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        getCause().printStackTrace();
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        getCause().printStackTrace(printStream);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        getCause().printStackTrace(printWriter);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getCause().toString();
    }
}
