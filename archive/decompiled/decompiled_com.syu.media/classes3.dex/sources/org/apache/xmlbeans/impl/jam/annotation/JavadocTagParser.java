package org.apache.xmlbeans.impl.jam.annotation;

import com.sun.javadoc.SourcePosition;
import com.sun.javadoc.Tag;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
import org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement;
import org.apache.xmlbeans.impl.jam.mutable.MAnnotation;
import org.apache.xmlbeans.impl.jam.mutable.MSourcePosition;
import org.apache.xmlbeans.impl.jam.provider.JamLogger;
import org.apache.xmlbeans.impl.jam.provider.JamServiceContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class JavadocTagParser {
    private JamServiceContext mContext = null;
    private boolean mAddSingleValueMembers = false;

    public abstract void parse(MAnnotatedElement mAnnotatedElement, Tag tag);

    public void setAddSingleValueMembers(boolean z) {
        this.mAddSingleValueMembers = z;
    }

    public void init(JamServiceContext jamServiceContext) {
        if (jamServiceContext == null) {
            throw new IllegalArgumentException("null logger");
        }
        if (this.mContext != null) {
            throw new IllegalStateException("JavadocTagParser.init() called twice");
        }
        this.mContext = jamServiceContext;
    }

    protected MAnnotation[] createAnnotations(MAnnotatedElement mAnnotatedElement, Tag tag) {
        String strSubstring = tag.name().trim().substring(1);
        MAnnotation mutableAnnotation = mAnnotatedElement.getMutableAnnotation(strSubstring);
        if (mutableAnnotation == null) {
            mutableAnnotation = mAnnotatedElement.findOrCreateAnnotation(strSubstring);
            setPosition(mutableAnnotation, tag);
        }
        MAnnotation mAnnotationAddLiteralAnnotation = mAnnotatedElement.addLiteralAnnotation(strSubstring);
        setPosition(mAnnotationAddLiteralAnnotation, tag);
        MAnnotation[] mAnnotationArr = {mAnnotationAddLiteralAnnotation, mutableAnnotation};
        if (this.mAddSingleValueMembers) {
            setSingleValueText(mAnnotationArr, tag);
        }
        return mAnnotationArr;
    }

    protected void setValue(MAnnotation[] mAnnotationArr, String str, String str2) {
        String strTrim = str2.trim();
        String strTrim2 = str.trim();
        for (int i = 0; i < mAnnotationArr.length; i++) {
            if (mAnnotationArr[i].getValue(strTrim2) == null) {
                mAnnotationArr[i].setSimpleValue(strTrim2, strTrim, getStringType());
            }
        }
    }

    protected JamLogger getLogger() {
        return this.mContext.getLogger();
    }

    protected JClass getStringType() {
        return ((ElementContext) this.mContext).getClassLoader().loadClass("java.lang.String");
    }

    protected void setSingleValueText(MAnnotation[] mAnnotationArr, Tag tag) {
        String strText = tag.text();
        for (MAnnotation mAnnotation : mAnnotationArr) {
            mAnnotation.setSimpleValue("value", strText, getStringType());
        }
    }

    private void setPosition(MAnnotation mAnnotation, Tag tag) {
        SourcePosition sourcePositionPosition = tag.position();
        if (sourcePositionPosition != null) {
            MSourcePosition mSourcePositionCreateSourcePosition = mAnnotation.createSourcePosition();
            mSourcePositionCreateSourcePosition.setLine(sourcePositionPosition.line());
            mSourcePositionCreateSourcePosition.setColumn(sourcePositionPosition.column());
            if (sourcePositionPosition.file() != null) {
                mSourcePositionCreateSourcePosition.setSourceURI(sourcePositionPosition.file().toURI());
            }
        }
    }
}
