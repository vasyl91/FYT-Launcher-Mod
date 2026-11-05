package org.apache.xmlbeans.impl.jam.internal.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
import org.apache.xmlbeans.impl.jam.mutable.MClass;
import org.apache.xmlbeans.impl.jam.mutable.MConstructor;
import org.apache.xmlbeans.impl.jam.mutable.MField;
import org.apache.xmlbeans.impl.jam.mutable.MInvokable;
import org.apache.xmlbeans.impl.jam.mutable.MMethod;
import org.apache.xmlbeans.impl.jam.mutable.MParameter;
import org.apache.xmlbeans.impl.jam.provider.JamClassBuilder;
import org.apache.xmlbeans.impl.jam.provider.JamClassPopulator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ReflectClassBuilder extends JamClassBuilder implements JamClassPopulator {
    private ClassLoader mLoader;
    private ReflectTigerDelegate mTigerDelegate = null;

    public ReflectClassBuilder(ClassLoader classLoader) {
        if (classLoader == null) {
            throw new IllegalArgumentException("null rcl");
        }
        this.mLoader = classLoader;
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamClassBuilder
    public void init(ElementContext elementContext) {
        super.init(elementContext);
        initDelegate(elementContext);
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamClassBuilder
    public MClass build(String str, String str2) {
        assertInitialized();
        if (getLogger().isVerbose(this)) {
            getLogger().verbose("trying to build '" + str + "' '" + str2 + "'");
        }
        try {
            Class<?> clsLoadClass = this.mLoader.loadClass(str.trim().length() > 0 ? str + NameUtil.PERIOD + str2 : str2);
            MClass mClassCreateClassToBuild = createClassToBuild(str, str2, null, this);
            mClassCreateClassToBuild.setArtifact(clsLoadClass);
            return mClassCreateClassToBuild;
        } catch (ClassNotFoundException e) {
            getLogger().verbose(e, this);
            return null;
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamClassPopulator
    public void populate(MClass mClass) {
        Field[] fields;
        assertInitialized();
        Class cls = (Class) mClass.getArtifact();
        mClass.setModifiers(cls.getModifiers());
        mClass.setIsInterface(cls.isInterface());
        ReflectTigerDelegate reflectTigerDelegate = this.mTigerDelegate;
        if (reflectTigerDelegate != null) {
            mClass.setIsEnumType(reflectTigerDelegate.isEnum(cls));
        }
        Class superclass = cls.getSuperclass();
        if (superclass != null) {
            mClass.setSuperclass(superclass.getName());
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            mClass.addInterface(cls2.getName());
        }
        try {
            fields = cls.getFields();
        } catch (Exception unused) {
            fields = null;
        }
        if (fields != null) {
            for (Field field : fields) {
                populate(mClass.addNewField(), field);
            }
        }
        for (Method method : cls.getDeclaredMethods()) {
            populate(mClass.addNewMethod(), method);
        }
        ReflectTigerDelegate reflectTigerDelegate2 = this.mTigerDelegate;
        if (reflectTigerDelegate2 != null) {
            reflectTigerDelegate2.populateAnnotationTypeIfNecessary(cls, mClass, this);
        }
        for (Constructor constructor : cls.getDeclaredConstructors()) {
            populate(mClass.addNewConstructor(), constructor);
        }
        ReflectTigerDelegate reflectTigerDelegate3 = this.mTigerDelegate;
        if (reflectTigerDelegate3 != null) {
            reflectTigerDelegate3.extractAnnotations(mClass, cls);
        }
        Class<?>[] declaredClasses = cls.getDeclaredClasses();
        if (declaredClasses != null) {
            for (int i = 0; i < declaredClasses.length; i++) {
                ReflectTigerDelegate reflectTigerDelegate4 = this.mTigerDelegate;
                if (reflectTigerDelegate4 == null || (reflectTigerDelegate4.getEnclosingConstructor(declaredClasses[i]) == null && this.mTigerDelegate.getEnclosingMethod(declaredClasses[i]) == null)) {
                    String name = declaredClasses[i].getName();
                    String strSubstring = name.substring(name.lastIndexOf(36) + 1);
                    char cCharAt = strSubstring.charAt(0);
                    if ('0' > cCharAt || cCharAt > '9') {
                        MClass mClassAddNewInnerClass = mClass.addNewInnerClass(strSubstring);
                        mClassAddNewInnerClass.setArtifact(declaredClasses[i]);
                        populate(mClassAddNewInnerClass);
                    }
                }
            }
        }
    }

    private void initDelegate(ElementContext elementContext) {
        this.mTigerDelegate = ReflectTigerDelegate.create(elementContext);
    }

    private void populate(MField mField, Field field) {
        mField.setArtifact(field);
        mField.setSimpleName(field.getName());
        mField.setType(field.getType().getName());
        mField.setModifiers(field.getModifiers());
        ReflectTigerDelegate reflectTigerDelegate = this.mTigerDelegate;
        if (reflectTigerDelegate != null) {
            reflectTigerDelegate.extractAnnotations(mField, field);
        }
    }

    private void populate(MConstructor mConstructor, Constructor constructor) {
        mConstructor.setArtifact(constructor);
        mConstructor.setSimpleName(constructor.getName());
        mConstructor.setModifiers(constructor.getModifiers());
        addThrows(mConstructor, constructor.getExceptionTypes());
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            MParameter mParameterAddParameter = addParameter(mConstructor, i, parameterTypes[i]);
            ReflectTigerDelegate reflectTigerDelegate = this.mTigerDelegate;
            if (reflectTigerDelegate != null) {
                reflectTigerDelegate.extractAnnotations(mParameterAddParameter, constructor, i);
            }
        }
        ReflectTigerDelegate reflectTigerDelegate2 = this.mTigerDelegate;
        if (reflectTigerDelegate2 != null) {
            reflectTigerDelegate2.extractAnnotations(mConstructor, constructor);
        }
    }

    private void populate(MMethod mMethod, Method method) {
        mMethod.setArtifact(method);
        mMethod.setSimpleName(method.getName());
        mMethod.setModifiers(method.getModifiers());
        mMethod.setReturnType(method.getReturnType().getName());
        addThrows(mMethod, method.getExceptionTypes());
        Class<?>[] parameterTypes = method.getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            MParameter mParameterAddParameter = addParameter(mMethod, i, parameterTypes[i]);
            ReflectTigerDelegate reflectTigerDelegate = this.mTigerDelegate;
            if (reflectTigerDelegate != null) {
                reflectTigerDelegate.extractAnnotations(mParameterAddParameter, method, i);
            }
        }
        ReflectTigerDelegate reflectTigerDelegate2 = this.mTigerDelegate;
        if (reflectTigerDelegate2 != null) {
            reflectTigerDelegate2.extractAnnotations(mMethod, method);
        }
    }

    private void addThrows(MInvokable mInvokable, Class[] clsArr) {
        for (Class cls : clsArr) {
            mInvokable.addException(cls.getName());
        }
    }

    private MParameter addParameter(MInvokable mInvokable, int i, Class cls) {
        MParameter mParameterAddNewParameter = mInvokable.addNewParameter();
        mParameterAddNewParameter.setSimpleName("param" + i);
        mParameterAddNewParameter.setType(cls.getName());
        return mParameterAddNewParameter;
    }
}
