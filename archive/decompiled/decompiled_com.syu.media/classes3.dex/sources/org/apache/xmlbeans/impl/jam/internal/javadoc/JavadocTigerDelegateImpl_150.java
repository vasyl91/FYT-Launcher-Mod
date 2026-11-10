package org.apache.xmlbeans.impl.jam.internal.javadoc;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.ExecutableMemberDoc;
import com.sun.javadoc.Parameter;
import com.sun.javadoc.ProgramElementDoc;
import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
import org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement;
import org.apache.xmlbeans.impl.jam.mutable.MClass;
import org.apache.xmlbeans.impl.jam.provider.JamLogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class JavadocTigerDelegateImpl_150 extends JavadocTigerDelegate {
    @Override // org.apache.xmlbeans.impl.jam.internal.javadoc.JavadocTigerDelegate
    public void extractAnnotations(MAnnotatedElement mAnnotatedElement, ExecutableMemberDoc executableMemberDoc, Parameter parameter) {
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.javadoc.JavadocTigerDelegate
    public void extractAnnotations(MAnnotatedElement mAnnotatedElement, ProgramElementDoc programElementDoc) {
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.TigerDelegate
    public void init(ElementContext elementContext) {
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.javadoc.JavadocTigerDelegate, org.apache.xmlbeans.impl.jam.internal.TigerDelegate
    public void init(JamLogger jamLogger) {
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.javadoc.JavadocTigerDelegate
    public boolean isEnum(ClassDoc classDoc) {
        return false;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.javadoc.JavadocTigerDelegate
    public void populateAnnotationTypeIfNecessary(ClassDoc classDoc, MClass mClass, JavadocClassBuilder javadocClassBuilder) {
    }
}
