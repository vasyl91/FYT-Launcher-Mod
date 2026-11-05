package org.apache.xmlbeans.impl.jam.internal.javadoc;

import com.sun.javadoc.RootDoc;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class JavadocResults {
    private static final JavadocResults INSTANCE = new JavadocResults();
    private ThreadLocal mRootsPerThread = new ThreadLocal();

    public static void prepare() {
        Thread.currentThread().setContextClassLoader(JavadocResults.class.getClassLoader());
    }

    public static void setRoot(RootDoc rootDoc) {
        try {
            Object holder = getHolder();
            holder.getClass().getMethod("_setRoot", RootDoc.class).invoke(holder, rootDoc);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    public static RootDoc getRoot() {
        try {
            Object holder = getHolder();
            return (RootDoc) holder.getClass().getMethod("_getRoot", new Class[0]).invoke(holder, null);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    public void _setRoot(RootDoc rootDoc) {
        this.mRootsPerThread.set(rootDoc);
    }

    public RootDoc _getRoot() {
        return (RootDoc) this.mRootsPerThread.get();
    }

    public static JavadocResults getInstance() {
        return INSTANCE;
    }

    private static Object getHolder() throws Exception {
        return Thread.currentThread().getContextClassLoader().loadClass(JavadocResults.class.getName()).getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
    }
}
