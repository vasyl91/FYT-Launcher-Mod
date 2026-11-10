package javax.xml.stream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XMLStreamException extends Exception {
    protected Location location;
    protected Throwable nested;

    public XMLStreamException() {
    }

    public XMLStreamException(String str) {
        super(str);
    }

    public XMLStreamException(Throwable th) {
        this.nested = th;
    }

    public XMLStreamException(String str, Throwable th) {
        super(str);
        this.nested = th;
    }

    public XMLStreamException(String str, Location location, Throwable th) {
        super(new StringBuffer("ParseError at [row,col]:[").append(location.getLineNumber()).append(",").append(location.getColumnNumber()).append("]\nMessage: ").append(str).toString());
        this.nested = th;
        this.location = location;
    }

    public XMLStreamException(String str, Location location) {
        super(new StringBuffer("ParseError at [row,col]:[").append(location.getLineNumber()).append(",").append(location.getColumnNumber()).append("]\nMessage: ").append(str).toString());
        this.location = location;
    }

    public Throwable getNestedException() {
        return this.nested;
    }

    public Location getLocation() {
        return this.location;
    }
}
