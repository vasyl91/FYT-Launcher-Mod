package org.codehaus.stax2.typed;

import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class TypedXMLStreamException extends XMLStreamException {
    private static final long serialVersionUID = 1;
    protected String mLexical;

    public TypedXMLStreamException(String str, String str2) {
        super(str2);
        this.mLexical = str;
    }

    public TypedXMLStreamException(String str, IllegalArgumentException illegalArgumentException) {
        super(illegalArgumentException);
        this.mLexical = str;
    }

    public TypedXMLStreamException(String str, String str2, IllegalArgumentException illegalArgumentException) {
        super(str2, illegalArgumentException);
        this.mLexical = str;
    }

    public TypedXMLStreamException(String str, String str2, Location location, IllegalArgumentException illegalArgumentException) {
        super(str2, location, illegalArgumentException);
        this.mLexical = str;
    }

    public TypedXMLStreamException(String str, String str2, Location location) {
        super(str2, location);
        this.mLexical = str;
    }

    public String getLexical() {
        return this.mLexical;
    }
}
