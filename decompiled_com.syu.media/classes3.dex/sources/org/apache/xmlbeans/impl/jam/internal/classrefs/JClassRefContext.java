package org.apache.xmlbeans.impl.jam.internal.classrefs;

import org.apache.xmlbeans.impl.jam.JamClassLoader;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface JClassRefContext {
    JamClassLoader getClassLoader();

    String[] getImportSpecs();

    String getPackageName();
}
