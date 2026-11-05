package org.apache.xmlbeans.xml.stream;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import org.apache.xmlbeans.xml.stream.utils.NestedThrowable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XMLStreamException extends IOException implements NestedThrowable {
    protected Throwable th;

    public XMLStreamException() {
    }

    public XMLStreamException(String str) {
        super(str);
    }

    public XMLStreamException(Throwable th) {
        this.th = th;
    }

    public XMLStreamException(String str, Throwable th) {
        super(str);
        this.th = th;
    }

    public Throwable getNestedException() {
        return getNested();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        Throwable th;
        String message = super.getMessage();
        return (message != null || (th = this.th) == null) ? message : th.getMessage();
    }

    @Override // org.apache.xmlbeans.xml.stream.utils.NestedThrowable
    public Throwable getNested() {
        return this.th;
    }

    @Override // org.apache.xmlbeans.xml.stream.utils.NestedThrowable
    public String superToString() {
        return super.toString();
    }

    @Override // org.apache.xmlbeans.xml.stream.utils.NestedThrowable
    public void superPrintStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
    }

    @Override // org.apache.xmlbeans.xml.stream.utils.NestedThrowable
    public void superPrintStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return NestedThrowable.Util.toString(this);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        NestedThrowable.Util.printStackTrace(this, printStream);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        NestedThrowable.Util.printStackTrace(this, printWriter);
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }
}
