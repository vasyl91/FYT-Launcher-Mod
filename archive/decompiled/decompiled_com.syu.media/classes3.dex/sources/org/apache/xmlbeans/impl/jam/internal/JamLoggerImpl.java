package org.apache.xmlbeans.impl.jam.internal;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.apache.xmlbeans.impl.jam.provider.JamLogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class JamLoggerImpl implements JamLogger {
    private boolean mShowWarnings = true;
    private Set mVerboseClasses = null;
    private PrintWriter mOut = new PrintWriter((OutputStream) System.out, true);

    protected void setOut(PrintWriter printWriter) {
        this.mOut = printWriter;
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamLogger
    public boolean isVerbose(Object obj) {
        Set set = this.mVerboseClasses;
        if (set == null) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (((Class) it.next()).isAssignableFrom(obj.getClass())) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamLogger
    public boolean isVerbose(Class cls) {
        Set set = this.mVerboseClasses;
        if (set == null) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (((Class) it.next()).isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamLogger
    public void setVerbose(Class cls) {
        if (cls == null) {
            throw new IllegalArgumentException();
        }
        if (this.mVerboseClasses == null) {
            this.mVerboseClasses = new HashSet();
        }
        this.mVerboseClasses.add(cls);
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamLogger
    public void setShowWarnings(boolean z) {
        this.mShowWarnings = z;
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamLogger
    public void verbose(String str, Object obj) {
        if (isVerbose(obj)) {
            verbose(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamLogger
    public void verbose(Throwable th, Object obj) {
        if (isVerbose(obj)) {
            verbose(th);
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamLogger
    public void verbose(String str) {
        printVerbosePrefix();
        this.mOut.println(str);
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamLogger
    public void verbose(Throwable th) {
        printVerbosePrefix();
        this.mOut.println();
        th.printStackTrace(this.mOut);
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamLogger
    public void warning(Throwable th) {
        if (this.mShowWarnings) {
            this.mOut.println("[JAM] Warning: unexpected exception thrown: ");
            th.printStackTrace();
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamLogger
    public void warning(String str) {
        if (this.mShowWarnings) {
            this.mOut.print("[JAM] Warning: ");
            this.mOut.println(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamLogger
    public void error(Throwable th) {
        this.mOut.println("[JAM] Error: unexpected exception thrown: ");
        th.printStackTrace(this.mOut);
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamLogger
    public void error(String str) {
        this.mOut.print("[JAM] Error: ");
        this.mOut.println(str);
    }

    public void setVerbose(boolean z) {
        setVerbose(Object.class);
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamLogger
    public boolean isVerbose() {
        return this.mVerboseClasses != null;
    }

    private void printVerbosePrefix() {
        StackTraceElement[] stackTrace = new Exception().getStackTrace();
        this.mOut.println("[JAM] Verbose: ");
        this.mOut.print('(');
        this.mOut.print(shortName(stackTrace[2].getClassName()));
        this.mOut.print(NameUtil.PERIOD);
        this.mOut.print(stackTrace[2].getMethodName());
        this.mOut.print(NameUtil.COLON);
        this.mOut.print(stackTrace[2].getLineNumber());
        this.mOut.print(")  ");
    }

    private static String shortName(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf != -1 ? str.substring(iLastIndexOf + 1, str.length()) : str;
    }
}
