package org.apache.xmlbeans.impl.jam.internal.elements;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.apache.xmlbeans.impl.jam.JAnnotation;
import org.apache.xmlbeans.impl.jam.JAnnotationValue;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JComment;
import org.apache.xmlbeans.impl.jam.JConstructor;
import org.apache.xmlbeans.impl.jam.JField;
import org.apache.xmlbeans.impl.jam.JMethod;
import org.apache.xmlbeans.impl.jam.JPackage;
import org.apache.xmlbeans.impl.jam.JProperty;
import org.apache.xmlbeans.impl.jam.JSourcePosition;
import org.apache.xmlbeans.impl.jam.JamClassLoader;
import org.apache.xmlbeans.impl.jam.internal.JamClassLoaderImpl;
import org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRef;
import org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRefContext;
import org.apache.xmlbeans.impl.jam.internal.classrefs.QualifiedJClassRef;
import org.apache.xmlbeans.impl.jam.internal.classrefs.UnqualifiedJClassRef;
import org.apache.xmlbeans.impl.jam.mutable.MClass;
import org.apache.xmlbeans.impl.jam.mutable.MConstructor;
import org.apache.xmlbeans.impl.jam.mutable.MField;
import org.apache.xmlbeans.impl.jam.mutable.MMethod;
import org.apache.xmlbeans.impl.jam.provider.JamClassPopulator;
import org.apache.xmlbeans.impl.jam.visitor.JVisitor;
import org.apache.xmlbeans.impl.jam.visitor.MVisitor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ClassImpl extends MemberImpl implements MClass, JClassRef, JClassRefContext {
    public static final int INITIALIZING = 5;
    public static final int LOADED = 6;
    public static final int NEW = 1;
    public static final int POPULATING = 3;
    public static final int UNINITIALIZED = 4;
    public static final int UNPOPULATED = 2;
    private ArrayList mConstructors;
    private ArrayList mDeclaredProperties;
    private ArrayList mFields;
    private String[] mImports;
    private ArrayList mInnerClasses;
    private ArrayList mInterfaceRefs;
    private boolean mIsAnnotationType;
    private boolean mIsEnum;
    private boolean mIsInterface;
    private ArrayList mMethods;
    private String mPackageName;
    private JamClassPopulator mPopulator;
    private ArrayList mProperties;
    private int mState;
    private JClassRef mSuperClassRef;

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JClass getArrayComponentType() {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public int getArrayDimensions() {
        return 0;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public Class getPrimitiveClass() {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRef
    public JClass getRefClass() {
        return this;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isArrayType() {
        return false;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isBuiltinType() {
        return false;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isPrimitiveType() {
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

    public ClassImpl(String str, String str2, ElementContext elementContext, String[] strArr, JamClassPopulator jamClassPopulator) {
        super(elementContext);
        this.mState = 1;
        this.mIsAnnotationType = false;
        this.mIsInterface = false;
        this.mIsEnum = false;
        this.mPackageName = null;
        this.mSuperClassRef = null;
        this.mInterfaceRefs = null;
        this.mFields = null;
        this.mMethods = null;
        this.mConstructors = null;
        this.mProperties = null;
        this.mDeclaredProperties = null;
        this.mInnerClasses = null;
        this.mImports = null;
        super.setSimpleName(str2);
        this.mPackageName = str.trim();
        this.mImports = strArr;
        this.mPopulator = jamClassPopulator;
        setState(2);
    }

    public ClassImpl(String str, String str2, ElementContext elementContext, String[] strArr) {
        super(elementContext);
        this.mState = 1;
        this.mIsAnnotationType = false;
        this.mIsInterface = false;
        this.mIsEnum = false;
        this.mPackageName = null;
        this.mSuperClassRef = null;
        this.mInterfaceRefs = null;
        this.mFields = null;
        this.mMethods = null;
        this.mConstructors = null;
        this.mProperties = null;
        this.mDeclaredProperties = null;
        this.mInnerClasses = null;
        this.mImports = null;
        super.setSimpleName(str2);
        this.mPackageName = str.trim();
        this.mImports = strArr;
        this.mPopulator = null;
        setState(4);
    }

    private ClassImpl(String str, String str2, String[] strArr, ClassImpl classImpl) {
        super(classImpl);
        this.mState = 1;
        this.mIsAnnotationType = false;
        this.mIsInterface = false;
        this.mIsEnum = false;
        this.mPackageName = null;
        this.mSuperClassRef = null;
        this.mInterfaceRefs = null;
        this.mFields = null;
        this.mMethods = null;
        this.mConstructors = null;
        this.mProperties = null;
        this.mDeclaredProperties = null;
        this.mInnerClasses = null;
        this.mImports = null;
        super.setSimpleName(str2);
        this.mPackageName = str.trim();
        this.mImports = strArr;
        this.mPopulator = null;
        setState(4);
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JPackage getContainingPackage() {
        return getClassLoader().getPackage(this.mPackageName);
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JClass getSuperclass() {
        ensureLoaded();
        JClassRef jClassRef = this.mSuperClassRef;
        if (jClassRef == null) {
            return null;
        }
        return jClassRef.getRefClass();
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JClass[] getInterfaces() {
        ensureLoaded();
        ArrayList arrayList = this.mInterfaceRefs;
        if (arrayList == null || arrayList.size() == 0) {
            return new JClass[0];
        }
        int size = this.mInterfaceRefs.size();
        JClass[] jClassArr = new JClass[size];
        for (int i = 0; i < size; i++) {
            jClassArr[i] = ((JClassRef) this.mInterfaceRefs.get(i)).getRefClass();
        }
        return jClassArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JField[] getFields() {
        ensureLoaded();
        ArrayList arrayList = new ArrayList();
        addFieldsRecursively(this, arrayList);
        JField[] jFieldArr = new JField[arrayList.size()];
        arrayList.toArray(jFieldArr);
        return jFieldArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JField[] getDeclaredFields() {
        ensureLoaded();
        return getMutableFields();
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JMethod[] getMethods() {
        ensureLoaded();
        ArrayList arrayList = new ArrayList();
        addMethodsRecursively(this, arrayList);
        JMethod[] jMethodArr = new JMethod[arrayList.size()];
        arrayList.toArray(jMethodArr);
        return jMethodArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JProperty[] getProperties() {
        ensureLoaded();
        ArrayList arrayList = this.mProperties;
        if (arrayList == null) {
            return new JProperty[0];
        }
        JProperty[] jPropertyArr = new JProperty[arrayList.size()];
        this.mProperties.toArray(jPropertyArr);
        return jPropertyArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JProperty[] getDeclaredProperties() {
        ensureLoaded();
        ArrayList arrayList = this.mDeclaredProperties;
        if (arrayList == null) {
            return new JProperty[0];
        }
        JProperty[] jPropertyArr = new JProperty[arrayList.size()];
        this.mDeclaredProperties.toArray(jPropertyArr);
        return jPropertyArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JMethod[] getDeclaredMethods() {
        ensureLoaded();
        return getMutableMethods();
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JConstructor[] getConstructors() {
        ensureLoaded();
        return getMutableConstructors();
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isInterface() {
        ensureLoaded();
        return this.mIsInterface;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isAnnotationType() {
        ensureLoaded();
        return this.mIsAnnotationType;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isEnumType() {
        ensureLoaded();
        return this.mIsEnum;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.MemberImpl, org.apache.xmlbeans.impl.jam.JMember
    public int getModifiers() {
        ensureLoaded();
        return super.getModifiers();
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isFinal() {
        return Modifier.isFinal(getModifiers());
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isStatic() {
        return Modifier.isStatic(getModifiers());
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isAbstract() {
        return Modifier.isAbstract(getModifiers());
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isAssignableFrom(JClass jClass) {
        ensureLoaded();
        if (isPrimitiveType() || jClass.isPrimitiveType()) {
            return getQualifiedName().equals(jClass.getQualifiedName());
        }
        return isAssignableFromRecursively(jClass);
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JClass[] getClasses() {
        ensureLoaded();
        ArrayList arrayList = this.mInnerClasses;
        if (arrayList == null) {
            return new JClass[0];
        }
        JClass[] jClassArr = new JClass[arrayList.size()];
        this.mInnerClasses.toArray(jClassArr);
        return jClassArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public String getFieldDescriptor() {
        return getQualifiedName();
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JClass forName(String str) {
        return getClassLoader().loadClass(str);
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JPackage[] getImportedPackages() {
        ensureLoaded();
        TreeSet treeSet = new TreeSet();
        for (JClass jClass : getImportedClasses()) {
            JPackage containingPackage = jClass.getContainingPackage();
            if (containingPackage != null) {
                treeSet.add(containingPackage);
            }
        }
        String[] importSpecs = getImportSpecs();
        if (importSpecs != null) {
            for (int i = 0; i < importSpecs.length; i++) {
                if (importSpecs[i].endsWith(".*")) {
                    JamClassLoader classLoader = getClassLoader();
                    String str = importSpecs[i];
                    treeSet.add(classLoader.getPackage(str.substring(0, str.length() - 2)));
                }
            }
        }
        JPackage[] jPackageArr = new JPackage[treeSet.size()];
        treeSet.toArray(jPackageArr);
        return jPackageArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public JClass[] getImportedClasses() {
        ensureLoaded();
        String[] importSpecs = getImportSpecs();
        if (importSpecs == null) {
            return new JClass[0];
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < importSpecs.length; i++) {
            if (!importSpecs[i].endsWith("*")) {
                arrayList.add(getClassLoader().loadClass(importSpecs[i]));
            }
        }
        JClass[] jClassArr = new JClass[arrayList.size()];
        arrayList.toArray(jClassArr);
        return jClassArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MElement
    public void accept(MVisitor mVisitor) {
        mVisitor.visit(this);
    }

    @Override // org.apache.xmlbeans.impl.jam.JElement
    public void accept(JVisitor jVisitor) {
        jVisitor.visit(this);
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.ElementImpl, org.apache.xmlbeans.impl.jam.mutable.MElement
    public void setSimpleName(String str) {
        throw new UnsupportedOperationException("Class names cannot be changed");
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isObjectType() {
        return getQualifiedName().equals("java.lang.Object");
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.AnnotatedElementImpl, org.apache.xmlbeans.impl.jam.JAnnotatedElement
    public JAnnotation[] getAnnotations() {
        ensureLoaded();
        return super.getAnnotations();
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.AnnotatedElementImpl, org.apache.xmlbeans.impl.jam.JAnnotatedElement
    public JAnnotation getAnnotation(Class cls) {
        ensureLoaded();
        return super.getAnnotation(cls);
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.AnnotatedElementImpl, org.apache.xmlbeans.impl.jam.JAnnotatedElement
    public JAnnotation getAnnotation(String str) {
        ensureLoaded();
        return super.getAnnotation(str);
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.AnnotatedElementImpl, org.apache.xmlbeans.impl.jam.JAnnotatedElement
    public JAnnotationValue getAnnotationValue(String str) {
        ensureLoaded();
        return super.getAnnotationValue(str);
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.AnnotatedElementImpl, org.apache.xmlbeans.impl.jam.JAnnotatedElement
    public Object getAnnotationProxy(Class cls) {
        ensureLoaded();
        return super.getAnnotationProxy(cls);
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.AnnotatedElementImpl, org.apache.xmlbeans.impl.jam.JAnnotatedElement
    public JComment getComment() {
        ensureLoaded();
        return super.getComment();
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.AnnotatedElementImpl, org.apache.xmlbeans.impl.jam.JAnnotatedElement
    public JAnnotation[] getAllJavadocTags() {
        ensureLoaded();
        return super.getAllJavadocTags();
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.ElementImpl, org.apache.xmlbeans.impl.jam.JElement
    public JSourcePosition getSourcePosition() {
        ensureLoaded();
        return super.getSourcePosition();
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void setSuperclass(String str) {
        if (str == null) {
            this.mSuperClassRef = null;
        } else {
            if (str.equals(getQualifiedName())) {
                throw new IllegalArgumentException("A class cannot be it's own superclass: '" + str + "'");
            }
            this.mSuperClassRef = QualifiedJClassRef.create(str, this);
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void setSuperclassUnqualified(String str) {
        this.mSuperClassRef = UnqualifiedJClassRef.create(str, this);
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void setSuperclass(JClass jClass) {
        if (jClass == null) {
            this.mSuperClassRef = null;
        } else {
            setSuperclass(jClass.getQualifiedName());
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void addInterface(JClass jClass) {
        if (jClass == null) {
            throw new IllegalArgumentException("null interf");
        }
        addInterface(jClass.getQualifiedName());
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void addInterface(String str) {
        if (this.mInterfaceRefs == null) {
            this.mInterfaceRefs = new ArrayList();
        }
        if (str.equals(getQualifiedName())) {
            throw new IllegalArgumentException("A class cannot implement itself: '" + str + "'");
        }
        this.mInterfaceRefs.add(QualifiedJClassRef.create(str, this));
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void addInterfaceUnqualified(String str) {
        if (this.mInterfaceRefs == null) {
            this.mInterfaceRefs = new ArrayList();
        }
        this.mInterfaceRefs.add(UnqualifiedJClassRef.create(str, this));
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void removeInterface(JClass jClass) {
        if (jClass == null) {
            throw new IllegalArgumentException("null interf");
        }
        removeInterface(jClass.getQualifiedName());
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void removeInterface(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null classname");
        }
        if (this.mInterfaceRefs == null) {
            return;
        }
        for (int i = 0; i < this.mInterfaceRefs.size(); i++) {
            if (str.equals(((JClassRef) this.mInterfaceRefs.get(i)).getQualifiedName())) {
                this.mInterfaceRefs.remove(i);
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public MConstructor addNewConstructor() {
        if (this.mConstructors == null) {
            this.mConstructors = new ArrayList();
        }
        ConstructorImpl constructorImpl = new ConstructorImpl(this);
        this.mConstructors.add(constructorImpl);
        return constructorImpl;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void removeConstructor(MConstructor mConstructor) {
        ArrayList arrayList = this.mConstructors;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(mConstructor);
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public MConstructor[] getMutableConstructors() {
        ArrayList arrayList = this.mConstructors;
        if (arrayList == null || arrayList.size() == 0) {
            return new MConstructor[0];
        }
        MConstructor[] mConstructorArr = new MConstructor[this.mConstructors.size()];
        this.mConstructors.toArray(mConstructorArr);
        return mConstructorArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public MField addNewField() {
        if (this.mFields == null) {
            this.mFields = new ArrayList();
        }
        FieldImpl fieldImpl = new FieldImpl(defaultName(this.mFields.size()), this, "java.lang.Object");
        this.mFields.add(fieldImpl);
        return fieldImpl;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void removeField(MField mField) {
        ArrayList arrayList = this.mFields;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(mField);
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public MField[] getMutableFields() {
        ArrayList arrayList = this.mFields;
        if (arrayList == null || arrayList.size() == 0) {
            return new MField[0];
        }
        MField[] mFieldArr = new MField[this.mFields.size()];
        this.mFields.toArray(mFieldArr);
        return mFieldArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public MMethod addNewMethod() {
        if (this.mMethods == null) {
            this.mMethods = new ArrayList();
        }
        MethodImpl methodImpl = new MethodImpl(defaultName(this.mMethods.size()), this);
        this.mMethods.add(methodImpl);
        return methodImpl;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void removeMethod(MMethod mMethod) {
        ArrayList arrayList = this.mMethods;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(mMethod);
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public MMethod[] getMutableMethods() {
        ArrayList arrayList = this.mMethods;
        if (arrayList == null || arrayList.size() == 0) {
            return new MMethod[0];
        }
        MMethod[] mMethodArr = new MMethod[this.mMethods.size()];
        this.mMethods.toArray(mMethodArr);
        return mMethodArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public JProperty addNewProperty(String str, JMethod jMethod, JMethod jMethod2) {
        if (this.mProperties == null) {
            this.mProperties = new ArrayList();
        }
        PropertyImpl propertyImpl = new PropertyImpl(str, jMethod, jMethod2, (jMethod != null ? jMethod.getReturnType() : jMethod2.getParameters()[0].getType()).getFieldDescriptor());
        this.mProperties.add(propertyImpl);
        return propertyImpl;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void removeProperty(JProperty jProperty) {
        ArrayList arrayList = this.mProperties;
        if (arrayList != null) {
            arrayList.remove(jProperty);
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public JProperty addNewDeclaredProperty(String str, JMethod jMethod, JMethod jMethod2) {
        if (this.mDeclaredProperties == null) {
            this.mDeclaredProperties = new ArrayList();
        }
        PropertyImpl propertyImpl = new PropertyImpl(str, jMethod, jMethod2, (jMethod != null ? jMethod.getReturnType() : jMethod2.getParameters()[0].getType()).getFieldDescriptor());
        this.mDeclaredProperties.add(propertyImpl);
        return propertyImpl;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void removeDeclaredProperty(JProperty jProperty) {
        ArrayList arrayList = this.mDeclaredProperties;
        if (arrayList != null) {
            arrayList.remove(jProperty);
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public MClass addNewInnerClass(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf == -1) {
            iLastIndexOf = str.lastIndexOf(36);
        }
        if (iLastIndexOf != -1) {
            str = str.substring(iLastIndexOf + 1);
        }
        ClassImpl classImpl = new ClassImpl(this.mPackageName, getSimpleName() + "$" + str, getImportSpecs(), this);
        if (this.mInnerClasses == null) {
            this.mInnerClasses = new ArrayList();
        }
        this.mInnerClasses.add(classImpl);
        classImpl.setState(6);
        ((JamClassLoaderImpl) getClassLoader()).addToCache(classImpl);
        return classImpl;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void removeInnerClass(MClass mClass) {
        ArrayList arrayList = this.mInnerClasses;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(mClass);
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void setIsInterface(boolean z) {
        this.mIsInterface = z;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void setIsAnnotationType(boolean z) {
        this.mIsAnnotationType = z;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MClass
    public void setIsEnumType(boolean z) {
        this.mIsEnum = z;
    }

    @Override // org.apache.xmlbeans.impl.jam.JElement
    public String getQualifiedName() {
        return (this.mPackageName.length() > 0 ? this.mPackageName + NameUtil.PERIOD : "") + this.mSimpleName;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRefContext
    public String getPackageName() {
        return this.mPackageName;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRefContext
    public String[] getImportSpecs() {
        ensureLoaded();
        String[] strArr = this.mImports;
        return strArr == null ? new String[0] : strArr;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public static void validateClassName(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("null class name specified");
        }
        if (!Character.isJavaIdentifierStart(str.charAt(0))) {
            throw new IllegalArgumentException("Invalid first character in class name: " + str);
        }
        for (int i = 1; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '.') {
                if (str.charAt(i - 1) == '.') {
                    throw new IllegalArgumentException("'..' not allowed in class name: " + str);
                }
                if (i == str.length() - 1) {
                    throw new IllegalArgumentException("'.' not allowed at end of class name: " + str);
                }
            } else if (!Character.isJavaIdentifierPart(cCharAt)) {
                throw new IllegalArgumentException("Illegal character '" + cCharAt + "' in class name: " + str);
            }
        }
    }

    private boolean isAssignableFromRecursively(JClass jClass) {
        if (getQualifiedName().equals(jClass.getQualifiedName())) {
            return true;
        }
        JClass[] interfaces = jClass.getInterfaces();
        if (interfaces != null) {
            for (JClass jClass2 : interfaces) {
                if (isAssignableFromRecursively(jClass2)) {
                    return true;
                }
            }
        }
        JClass superclass = jClass.getSuperclass();
        return superclass != null && isAssignableFromRecursively(superclass);
    }

    private void addFieldsRecursively(JClass jClass, Collection collection) {
        for (JField jField : jClass.getDeclaredFields()) {
            collection.add(jField);
        }
        for (JClass jClass2 : jClass.getInterfaces()) {
            addFieldsRecursively(jClass2, collection);
        }
        JClass superclass = jClass.getSuperclass();
        if (superclass != null) {
            addFieldsRecursively(superclass, collection);
        }
    }

    private void addMethodsRecursively(JClass jClass, Collection collection) {
        for (JMethod jMethod : jClass.getDeclaredMethods()) {
            collection.add(jMethod);
        }
        for (JClass jClass2 : jClass.getInterfaces()) {
            addMethodsRecursively(jClass2, collection);
        }
        JClass superclass = jClass.getSuperclass();
        if (superclass != null) {
            addMethodsRecursively(superclass, collection);
        }
    }

    public void ensureLoaded() {
        int i = this.mState;
        if (i == 6) {
            return;
        }
        if (i == 2) {
            if (this.mPopulator == null) {
                throw new IllegalStateException("null populator");
            }
            setState(3);
            this.mPopulator.populate(this);
            setState(4);
        }
        if (this.mState == 4) {
            setState(5);
            ((JamClassLoaderImpl) getClassLoader()).initialize(this);
        }
        setState(6);
    }
}
