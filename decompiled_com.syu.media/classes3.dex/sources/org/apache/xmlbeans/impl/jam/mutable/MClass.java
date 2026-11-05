package org.apache.xmlbeans.impl.jam.mutable;

import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JMethod;
import org.apache.xmlbeans.impl.jam.JProperty;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface MClass extends MMember, JClass {
    void addInterface(String str);

    void addInterface(JClass jClass);

    void addInterfaceUnqualified(String str);

    MConstructor addNewConstructor();

    JProperty addNewDeclaredProperty(String str, JMethod jMethod, JMethod jMethod2);

    MField addNewField();

    MClass addNewInnerClass(String str);

    MMethod addNewMethod();

    JProperty addNewProperty(String str, JMethod jMethod, JMethod jMethod2);

    MConstructor[] getMutableConstructors();

    MField[] getMutableFields();

    MMethod[] getMutableMethods();

    void removeConstructor(MConstructor mConstructor);

    void removeDeclaredProperty(JProperty jProperty);

    void removeField(MField mField);

    void removeInnerClass(MClass mClass);

    void removeInterface(String str);

    void removeInterface(JClass jClass);

    void removeMethod(MMethod mMethod);

    void removeProperty(JProperty jProperty);

    void setIsAnnotationType(boolean z);

    void setIsEnumType(boolean z);

    void setIsInterface(boolean z);

    void setSuperclass(String str);

    void setSuperclass(JClass jClass);

    void setSuperclassUnqualified(String str);
}
