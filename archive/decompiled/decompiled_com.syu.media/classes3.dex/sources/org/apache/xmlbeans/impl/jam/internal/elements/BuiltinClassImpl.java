package org.apache.xmlbeans.impl.jam.internal.elements;

import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JConstructor;
import org.apache.xmlbeans.impl.jam.JField;
import org.apache.xmlbeans.impl.jam.JMethod;
import org.apache.xmlbeans.impl.jam.JPackage;
import org.apache.xmlbeans.impl.jam.JProperty;
import org.apache.xmlbeans.impl.jam.JSourcePosition;
import org.apache.xmlbeans.impl.jam.mutable.MClass;
import org.apache.xmlbeans.impl.jam.mutable.MConstructor;
import org.apache.xmlbeans.impl.jam.mutable.MField;
import org.apache.xmlbeans.impl.jam.mutable.MMethod;
import org.apache.xmlbeans.impl.jam.visitor.JVisitor;
import org.apache.xmlbeans.impl.jam.visitor.MVisitor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class BuiltinClassImpl extends AnnotatedElementImpl implements MClass {
    public JClass getArrayComponentType() {
        return null;
    }

    public int getArrayDimensions() {
        return 0;
    }

    @Override // org.apache.xmlbeans.impl.jam.JMember
    public JClass getContainingClass() {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JPackage getContainingPackage() {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public Class getPrimitiveClass() {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.ElementImpl, org.apache.xmlbeans.impl.jam.JElement
    public JSourcePosition getSourcePosition() {
        return null;
    }

    public JClass getSuperclass() {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isAbstract() {
        return false;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isAnnotationType() {
        return false;
    }

    public boolean isArrayType() {
        return false;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isBuiltinType() {
        return true;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isEnumType() {
        return false;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isFinal() {
        return false;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isInterface() {
        return false;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isObjectType() {
        return false;
    }

    @Override // org.apache.xmlbeans.impl.jam.JMember
    public boolean isPackagePrivate() {
        return false;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isPrimitiveType() {
        return false;
    }

    @Override // org.apache.xmlbeans.impl.jam.JMember
    public boolean isPrivate() {
        return false;
    }

    @Override // org.apache.xmlbeans.impl.jam.JMember
    public boolean isProtected() {
        return false;
    }

    @Override // org.apache.xmlbeans.impl.jam.JMember
    public boolean isPublic() {
        return true;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isStatic() {
        return false;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isUnresolvedType() {
        return false;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isVoidType() {
        return false;
    }

    protected BuiltinClassImpl(ElementContext elementContext) {
        super(elementContext);
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MElement
    public void accept(MVisitor mVisitor) {
        mVisitor.visit(this);
    }

    @Override // org.apache.xmlbeans.impl.jam.JElement
    public void accept(JVisitor jVisitor) {
        jVisitor.visit(this);
    }

    public String getQualifiedName() {
        return this.mSimpleName;
    }

    public String getFieldDescriptor() {
        return this.mSimpleName;
    }

    @Override // org.apache.xmlbeans.impl.jam.JMember
    public int getModifiers() {
        return Object.class.getModifiers();
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JClass forName(String str) {
        return getClassLoader().loadClass(str);
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JClass[] getInterfaces() {
        return NO_CLASS;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JField[] getFields() {
        return NO_FIELD;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JField[] getDeclaredFields() {
        return NO_FIELD;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JConstructor[] getConstructors() {
        return NO_CONSTRUCTOR;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JMethod[] getMethods() {
        return NO_METHOD;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JMethod[] getDeclaredMethods() {
        return NO_METHOD;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JClass[] getClasses() {
        return NO_CLASS;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JProperty[] getProperties() {
        return NO_PROPERTY;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JProperty[] getDeclaredProperties() {
        return NO_PROPERTY;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JPackage[] getImportedPackages() {
        return NO_PACKAGE;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JClass[] getImportedClasses() {
        return NO_CLASS;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public MField[] getMutableFields() {
        return NO_FIELD;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public MConstructor[] getMutableConstructors() {
        return NO_CONSTRUCTOR;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public MMethod[] getMutableMethods() {
        return NO_METHOD;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.ElementImpl, org.apache.xmlbeans.impl.jam.mutable.MElement
    public void setSimpleName(String str) {
        nocando();
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void setIsAnnotationType(boolean z) {
        nocando();
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void setIsInterface(boolean z) {
        nocando();
    }

    public void setIsUnresolvedType(boolean z) {
        nocando();
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void setIsEnumType(boolean z) {
        nocando();
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void setSuperclass(String str) {
        nocando();
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void setSuperclassUnqualified(String str) {
        nocando();
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void setSuperclass(JClass jClass) {
        nocando();
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void addInterface(String str) {
        nocando();
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void addInterfaceUnqualified(String str) {
        nocando();
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void addInterface(JClass jClass) {
        nocando();
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void removeInterface(String str) {
        nocando();
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void removeInterface(JClass jClass) {
        nocando();
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public MConstructor addNewConstructor() {
        nocando();
        return null;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void removeConstructor(MConstructor mConstructor) {
        nocando();
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public MField addNewField() {
        nocando();
        return null;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void removeField(MField mField) {
        nocando();
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public MMethod addNewMethod() {
        nocando();
        return null;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void removeMethod(MMethod mMethod) {
        nocando();
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MMember
    public void setModifiers(int i) {
        nocando();
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public MClass addNewInnerClass(String str) {
        nocando();
        return null;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void removeInnerClass(MClass mClass) {
        nocando();
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public JProperty addNewProperty(String str, JMethod jMethod, JMethod jMethod2) {
        nocando();
        return null;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void removeProperty(JProperty jProperty) {
        nocando();
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public JProperty addNewDeclaredProperty(String str, JMethod jMethod, JMethod jMethod2) {
        nocando();
        return null;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void removeDeclaredProperty(JProperty jProperty) {
        nocando();
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.ElementImpl, org.apache.xmlbeans.impl.jam.JClass
    public boolean equals(Object obj) {
        if (obj instanceof JClass) {
            return ((JClass) obj).getFieldDescriptor().equals(getFieldDescriptor());
        }
        return false;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.ElementImpl
    public int hashCode() {
        return getFieldDescriptor().hashCode();
    }

    protected void reallySetSimpleName(String str) {
        super.setSimpleName(str);
    }

    private void nocando() {
        throw new UnsupportedOperationException("Cannot alter builtin types");
    }
}
