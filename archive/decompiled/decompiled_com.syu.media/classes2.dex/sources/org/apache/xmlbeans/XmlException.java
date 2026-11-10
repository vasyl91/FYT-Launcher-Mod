package org.apache.xmlbeans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XmlException extends Exception {
    private static final long serialVersionUID = 1;
    private List _errors;

    public XmlException(String str) {
        super(str);
    }

    public XmlException(String str, Throwable th) {
        super(str, th);
    }

    public XmlException(Throwable th) {
        super(th);
    }

    public XmlException(XmlError xmlError) {
        this(xmlError.toString(), (Throwable) null, xmlError);
    }

    public XmlException(String str, Throwable th, XmlError xmlError) {
        this(str, th, Collections.singletonList(xmlError));
    }

    public XmlException(String str, Throwable th, Collection collection) {
        super(str, th);
        if (collection != null) {
            this._errors = Collections.unmodifiableList(new ArrayList(collection));
        }
    }

    public XmlException(XmlRuntimeException xmlRuntimeException) {
        super(xmlRuntimeException.getMessage(), xmlRuntimeException.getCause());
        Collection errors = xmlRuntimeException.getErrors();
        if (errors != null) {
            this._errors = Collections.unmodifiableList(new ArrayList(errors));
        }
    }

    public XmlError getError() {
        List list = this._errors;
        if (list == null || list.size() == 0) {
            return null;
        }
        return (XmlError) this._errors.get(0);
    }

    public Collection getErrors() {
        return this._errors;
    }
}
