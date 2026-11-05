package org.apache.xmlbeans;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface InterfaceExtension {

    public interface MethodSignature {
        String[] getExceptionTypes();

        String getName();

        String[] getParameterTypes();

        String getReturnType();
    }

    String getInterface();

    MethodSignature[] getMethods();

    String getStaticHandler();
}
