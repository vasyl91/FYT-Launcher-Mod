package org.apache.xmlbeans.impl.jam.internal.elements;

import java.io.StringWriter;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JamClassLoader;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class ArrayClassImpl extends BuiltinClassImpl {
    private JClass mComponentType;
    private int mDimensions;

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.BuiltinClassImpl, org.apache.xmlbeans.impl.jam.JClass
    public boolean isArrayType() {
        return true;
    }

    public static JClass createClassForFD(String str, JamClassLoader jamClassLoader) {
        if (!str.startsWith("[")) {
            throw new IllegalArgumentException("must be an array type fd: " + str);
        }
        if (str.endsWith(";")) {
            int iIndexOf = str.indexOf("L");
            if (iIndexOf != -1 && iIndexOf < str.length() - 2) {
                return new ArrayClassImpl(jamClassLoader.loadClass(str.substring(iIndexOf + 1, str.length() - 1)), iIndexOf);
            }
            throw new IllegalArgumentException("array type field descriptor '" + str + "' is malformed");
        }
        int iLastIndexOf = str.lastIndexOf("[") + 1;
        JClass jClassLoadClass = jamClassLoader.loadClass(str.substring(iLastIndexOf, iLastIndexOf + 1));
        if (jClassLoadClass == null) {
            throw new IllegalArgumentException("array type field descriptor '" + str + "' is malformed");
        }
        return new ArrayClassImpl(jClassLoadClass, iLastIndexOf);
    }

    public static String normalizeArrayName(String str) {
        int iIndexOf;
        if (str.startsWith("[")) {
            return str;
        }
        if (str.endsWith("]") && (iIndexOf = str.indexOf(91)) != -1) {
            String strSubstring = str.substring(0, iIndexOf);
            String primitiveClassForName = PrimitiveClassImpl.getPrimitiveClassForName(strSubstring);
            if (primitiveClassForName == null) {
                primitiveClassForName = "L" + strSubstring + ';';
            }
            StringWriter stringWriter = new StringWriter();
            do {
                stringWriter.write(91);
                iIndexOf = str.indexOf(91, iIndexOf + 1);
            } while (iIndexOf != -1);
            stringWriter.write(primitiveClassForName);
            return stringWriter.toString();
        }
        throw new IllegalArgumentException("'" + str + "' does not name an array");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ArrayClassImpl(JClass jClass, int i) {
        super(((ElementImpl) jClass).getContext());
        if (i < 1) {
            throw new IllegalArgumentException("dimensions=" + i);
        }
        if (jClass == 0) {
            throw new IllegalArgumentException("null componentType");
        }
        this.mComponentType = jClass;
        this.mDimensions = i;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.ElementImpl, org.apache.xmlbeans.impl.jam.JElement
    public String getSimpleName() {
        String qualifiedName = getQualifiedName();
        int iLastIndexOf = qualifiedName.lastIndexOf(46);
        return iLastIndexOf == -1 ? qualifiedName : qualifiedName.substring(iLastIndexOf + 1);
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.BuiltinClassImpl, org.apache.xmlbeans.impl.jam.JElement
    public String getQualifiedName() {
        StringWriter stringWriter = new StringWriter();
        stringWriter.write(this.mComponentType.getQualifiedName());
        for (int i = 0; i < this.mDimensions; i++) {
            stringWriter.write("[]");
        }
        return stringWriter.toString();
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.BuiltinClassImpl, org.apache.xmlbeans.impl.jam.JClass
    public JClass getArrayComponentType() {
        return this.mComponentType;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.BuiltinClassImpl, org.apache.xmlbeans.impl.jam.JClass
    public int getArrayDimensions() {
        return this.mDimensions;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.BuiltinClassImpl, org.apache.xmlbeans.impl.jam.JClass
    public JClass getSuperclass() {
        return getClassLoader().loadClass("java.lang.Object");
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isAssignableFrom(JClass jClass) {
        return jClass.isArrayType() && jClass.getArrayDimensions() == this.mDimensions && this.mComponentType.isAssignableFrom(jClass.getArrayComponentType());
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.BuiltinClassImpl, org.apache.xmlbeans.impl.jam.JClass
    public String getFieldDescriptor() {
        StringWriter stringWriter = new StringWriter();
        for (int i = 0; i < this.mDimensions; i++) {
            stringWriter.write("[");
        }
        if (this.mComponentType.isPrimitiveType()) {
            stringWriter.write(this.mComponentType.getFieldDescriptor());
        } else {
            stringWriter.write("L");
            stringWriter.write(this.mComponentType.getQualifiedName());
            stringWriter.write(";");
        }
        return stringWriter.toString();
    }
}
