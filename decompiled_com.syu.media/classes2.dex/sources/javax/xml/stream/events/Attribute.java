package javax.xml.stream.events;

import javax.xml.namespace.QName;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Attribute extends XMLEvent {
    String getDTDType();

    QName getName();

    String getValue();

    boolean isSpecified();
}
