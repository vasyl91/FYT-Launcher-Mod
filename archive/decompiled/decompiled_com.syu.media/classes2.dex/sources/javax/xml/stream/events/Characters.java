package javax.xml.stream.events;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Characters extends XMLEvent {
    String getData();

    boolean isCData();

    boolean isIgnorableWhiteSpace();

    boolean isWhiteSpace();
}
