package org.apache.xmlbeans.impl.jam.internal.elements;

import org.apache.xmlbeans.impl.jam.JamClassLoader;
import org.apache.xmlbeans.impl.jam.annotation.AnnotationProxy;
import org.apache.xmlbeans.impl.jam.provider.JamLogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface ElementContext extends JamLogger {
    AnnotationProxy createAnnotationProxy(String str);

    JamClassLoader getClassLoader();

    JamLogger getLogger();
}
