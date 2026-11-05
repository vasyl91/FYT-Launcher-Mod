package org.codehaus.stax2.validation;

import javax.xml.stream.Location;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XMLValidationProblem {
    public static final int SEVERITY_ERROR = 2;
    public static final int SEVERITY_FATAL = 3;
    public static final int SEVERITY_WARNING = 1;
    protected Location mLocation;
    protected final String mMessage;
    protected XMLValidator mReporter;
    protected final int mSeverity;
    protected String mType;

    public XMLValidationProblem(Location location, String str) {
        this(location, str, 2);
    }

    public XMLValidationProblem(Location location, String str, int i) {
        this(location, str, i, null);
    }

    public XMLValidationProblem(Location location, String str, int i, String str2) {
        this.mLocation = location;
        this.mMessage = str;
        this.mSeverity = i;
        this.mType = str2;
    }

    public XMLValidationException toException() {
        return XMLValidationException.createException(this);
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setLocation(Location location) {
        this.mLocation = location;
    }

    public void setReporter(XMLValidator xMLValidator) {
        this.mReporter = xMLValidator;
    }

    public Location getLocation() {
        return this.mLocation;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public int getSeverity() {
        return this.mSeverity;
    }

    public String getType() {
        return this.mType;
    }

    public XMLValidator getReporter() {
        return this.mReporter;
    }
}
