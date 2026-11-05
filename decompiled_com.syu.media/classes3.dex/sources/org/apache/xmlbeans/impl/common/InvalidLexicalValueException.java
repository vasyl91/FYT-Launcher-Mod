package org.apache.xmlbeans.impl.common;

import javax.xml.stream.Location;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class InvalidLexicalValueException extends RuntimeException {
    private Location _location;

    public InvalidLexicalValueException() {
    }

    public InvalidLexicalValueException(String str) {
        super(str);
    }

    public InvalidLexicalValueException(String str, Throwable th) {
        super(str, th);
    }

    public InvalidLexicalValueException(Throwable th) {
        super(th);
    }

    public InvalidLexicalValueException(String str, Location location) {
        super(str);
        setLocation(location);
    }

    public InvalidLexicalValueException(String str, Throwable th, Location location) {
        super(str, th);
        setLocation(location);
    }

    public InvalidLexicalValueException(Throwable th, Location location) {
        super(th);
        setLocation(location);
    }

    public Location getLocation() {
        return this._location;
    }

    public void setLocation(Location location) {
        this._location = location;
    }
}
