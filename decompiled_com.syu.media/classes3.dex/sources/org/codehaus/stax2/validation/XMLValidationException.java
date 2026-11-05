package org.codehaus.stax2.validation;

import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XMLValidationException extends XMLStreamException {
    private static final long serialVersionUID = 1;
    protected XMLValidationProblem mCause;

    protected XMLValidationException(XMLValidationProblem xMLValidationProblem) {
        if (xMLValidationProblem == null) {
            throwMissing();
        }
        this.mCause = xMLValidationProblem;
    }

    protected XMLValidationException(XMLValidationProblem xMLValidationProblem, String str) {
        super(str);
        if (xMLValidationProblem == null) {
            throwMissing();
        }
        this.mCause = xMLValidationProblem;
    }

    protected XMLValidationException(XMLValidationProblem xMLValidationProblem, String str, Location location) {
        super(str, location);
        if (xMLValidationProblem == null) {
            throwMissing();
        }
        this.mCause = xMLValidationProblem;
    }

    public static XMLValidationException createException(XMLValidationProblem xMLValidationProblem) {
        String message = xMLValidationProblem.getMessage();
        if (message == null) {
            return new XMLValidationException(xMLValidationProblem);
        }
        Location location = xMLValidationProblem.getLocation();
        if (location == null) {
            return new XMLValidationException(xMLValidationProblem, message);
        }
        return new XMLValidationException(xMLValidationProblem, message, location);
    }

    public XMLValidationProblem getValidationProblem() {
        return this.mCause;
    }

    protected static void throwMissing() throws RuntimeException {
        throw new IllegalArgumentException("Validation problem argument can not be null");
    }
}
