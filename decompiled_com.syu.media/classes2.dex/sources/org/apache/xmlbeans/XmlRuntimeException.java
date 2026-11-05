package org.apache.xmlbeans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XmlRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1;
    private List _errors;

    public XmlRuntimeException(String str) {
        super(str);
    }

    public XmlRuntimeException(String str, Throwable th) {
        super(str, th);
    }

    public XmlRuntimeException(Throwable th) {
        super(th);
    }

    public XmlRuntimeException(String str, Throwable th, Collection collection) {
        super(str, th);
        if (collection != null) {
            this._errors = Collections.unmodifiableList(new ArrayList(collection));
        }
    }

    public XmlRuntimeException(XmlError xmlError) {
        this(xmlError.toString(), (Throwable) null, xmlError);
    }

    public XmlRuntimeException(String str, Throwable th, XmlError xmlError) {
        this(str, th, Collections.singletonList(xmlError));
    }

    public XmlRuntimeException(XmlException xmlException) {
        super(xmlException.getMessage(), xmlException.getCause());
        Collection errors = xmlException.getErrors();
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
