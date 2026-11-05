package org.apache.xmlbeans.impl.jam.internal.javadoc;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.ExecutableMemberDoc;
import com.sun.javadoc.Parameter;
import com.sun.javadoc.ProgramElementDoc;
import org.apache.xmlbeans.impl.jam.internal.TigerDelegate;
import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
import org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement;
import org.apache.xmlbeans.impl.jam.mutable.MClass;
import org.apache.xmlbeans.impl.jam.provider.JamLogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class JavadocTigerDelegate extends TigerDelegate {
    public static final String ANNOTATION_DEFAULTS_DISABLED_PROPERTY = "ANNOTATION_DEFAULTS_DISABLED_PROPERTY";
    private static final String JAVADOC_DELEGATE_IMPL = "org.apache.xmlbeans.impl.jam.internal.javadoc.JavadocTigerDelegateImpl_150";

    public abstract void extractAnnotations(MAnnotatedElement mAnnotatedElement, ExecutableMemberDoc executableMemberDoc, Parameter parameter);

    public abstract void extractAnnotations(MAnnotatedElement mAnnotatedElement, ProgramElementDoc programElementDoc);

    @Override // org.apache.xmlbeans.impl.jam.internal.TigerDelegate
    public abstract void init(JamLogger jamLogger);

    public abstract boolean isEnum(ClassDoc classDoc);

    public abstract void populateAnnotationTypeIfNecessary(ClassDoc classDoc, MClass mClass, JavadocClassBuilder javadocClassBuilder);

    public static JavadocTigerDelegate create(JamLogger jamLogger) {
        if (!isTigerJavadocAvailable(jamLogger)) {
            return null;
        }
        try {
            JavadocTigerDelegate javadocTigerDelegate = (JavadocTigerDelegate) Class.forName(JAVADOC_DELEGATE_IMPL).newInstance();
            javadocTigerDelegate.init(jamLogger);
            return javadocTigerDelegate;
        } catch (ClassNotFoundException e) {
            issue14BuildWarning(e, jamLogger);
            return null;
        } catch (IllegalAccessException e2) {
            jamLogger.error(e2);
            return null;
        } catch (InstantiationException e3) {
            jamLogger.error(e3);
            return null;
        }
    }

    public static JavadocTigerDelegate create(ElementContext elementContext) {
        if (!isTigerJavadocAvailable(elementContext.getLogger())) {
            return null;
        }
        try {
            JavadocTigerDelegate javadocTigerDelegate = (JavadocTigerDelegate) Class.forName(JAVADOC_DELEGATE_IMPL).newInstance();
            javadocTigerDelegate.init(elementContext);
            return javadocTigerDelegate;
        } catch (ClassNotFoundException e) {
            elementContext.getLogger().error(e);
            return null;
        } catch (IllegalAccessException e2) {
            elementContext.getLogger().error(e2);
            return null;
        } catch (InstantiationException e3) {
            elementContext.getLogger().error(e3);
            return null;
        }
    }
}
