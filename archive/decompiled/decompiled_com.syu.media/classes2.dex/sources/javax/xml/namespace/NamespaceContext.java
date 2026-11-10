package javax.xml.namespace;

import java.util.Iterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface NamespaceContext {
    String getNamespaceURI(String str);

    String getPrefix(String str);

    Iterator getPrefixes(String str);
}
