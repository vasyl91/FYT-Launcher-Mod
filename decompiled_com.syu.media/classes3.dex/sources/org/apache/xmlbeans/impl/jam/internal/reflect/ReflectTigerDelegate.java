package org.apache.xmlbeans.impl.jam.internal.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.apache.xmlbeans.impl.jam.internal.TigerDelegate;
import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
import org.apache.xmlbeans.impl.jam.mutable.MClass;
import org.apache.xmlbeans.impl.jam.mutable.MConstructor;
import org.apache.xmlbeans.impl.jam.mutable.MField;
import org.apache.xmlbeans.impl.jam.mutable.MMember;
import org.apache.xmlbeans.impl.jam.mutable.MParameter;
import org.apache.xmlbeans.impl.jam.provider.JamLogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class ReflectTigerDelegate extends TigerDelegate {
    private static final String IMPL_NAME = "org.apache.xmlbeans.impl.jam.internal.reflect.ReflectTigerDelegateImpl_150";

    public abstract void extractAnnotations(MClass mClass, Class cls);

    public abstract void extractAnnotations(MConstructor mConstructor, Constructor constructor);

    public abstract void extractAnnotations(MField mField, Field field);

    public abstract void extractAnnotations(MMember mMember, Method method);

    public abstract void extractAnnotations(MParameter mParameter, Constructor constructor, int i);

    public abstract void extractAnnotations(MParameter mParameter, Method method, int i);

    public abstract Constructor getEnclosingConstructor(Class cls);

    public abstract Method getEnclosingMethod(Class cls);

    public abstract boolean isEnum(Class cls);

    public abstract void populateAnnotationTypeIfNecessary(Class cls, MClass mClass, ReflectClassBuilder reflectClassBuilder);

    public static ReflectTigerDelegate create(JamLogger jamLogger) {
        if (!isTigerReflectionAvailable(jamLogger)) {
            return null;
        }
        try {
            ReflectTigerDelegate reflectTigerDelegate = (ReflectTigerDelegate) Class.forName(IMPL_NAME).newInstance();
            reflectTigerDelegate.init(jamLogger);
            return reflectTigerDelegate;
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

    public static ReflectTigerDelegate create(ElementContext elementContext) {
        if (!isTigerReflectionAvailable(elementContext.getLogger())) {
            return null;
        }
        try {
            ReflectTigerDelegate reflectTigerDelegate = (ReflectTigerDelegate) Class.forName(IMPL_NAME).newInstance();
            reflectTigerDelegate.init(elementContext);
            return reflectTigerDelegate;
        } catch (ClassNotFoundException e) {
            issue14BuildWarning(e, elementContext.getLogger());
            return null;
        } catch (IllegalAccessException e2) {
            elementContext.getLogger().error(e2);
            return null;
        } catch (InstantiationException e3) {
            elementContext.getLogger().error(e3);
            return null;
        }
    }

    protected ReflectTigerDelegate() {
    }
}
