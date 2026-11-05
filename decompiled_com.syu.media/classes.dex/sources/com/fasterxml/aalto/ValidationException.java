package com.fasterxml.aalto;

import javax.xml.stream.Location;
import org.codehaus.stax2.validation.XMLValidationException;
import org.codehaus.stax2.validation.XMLValidationProblem;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class ValidationException extends XMLValidationException {
    protected ValidationException(XMLValidationProblem xMLValidationProblem, String str) {
        super(xMLValidationProblem, str);
    }

    protected ValidationException(XMLValidationProblem xMLValidationProblem, String str, Location location) {
        super(xMLValidationProblem, str, location);
    }

    public static ValidationException create(XMLValidationProblem xMLValidationProblem) {
        Location location = xMLValidationProblem.getLocation();
        if (location == null) {
            return new ValidationException(xMLValidationProblem, xMLValidationProblem.getMessage());
        }
        return new ValidationException(xMLValidationProblem, xMLValidationProblem.getMessage(), location);
    }

    public String getMessage() {
        String locationDesc = getLocationDesc();
        if (locationDesc == null) {
            return super.getMessage();
        }
        String message = getValidationProblem().getMessage();
        StringBuilder sb = new StringBuilder(message.length() + locationDesc.length() + 20);
        sb.append(message);
        sb.append("\n at ");
        sb.append(locationDesc);
        return sb.toString();
    }

    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }

    protected String getLocationDesc() {
        Location location = getLocation();
        if (location == null) {
            return null;
        }
        return location.toString();
    }
}
