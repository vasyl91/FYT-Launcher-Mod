package javax.xml.stream.events;

import java.util.Iterator;
import javax.xml.namespace.QName;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface EndElement extends XMLEvent {
    QName getName();

    Iterator getNamespaces();
}
