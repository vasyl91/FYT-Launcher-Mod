package org.apache.xmlbeans.impl.jam.internal.elements;

import java.util.HashMap;
import java.util.Map;
import org.apache.xmlbeans.impl.jam.JClass;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class PrimitiveClassImpl extends BuiltinClassImpl {
    private static final Object[][] PRIMITIVES = {new Object[]{"int", "I", Integer.TYPE}, new Object[]{"long", "J", Long.TYPE}, new Object[]{"boolean", "Z", Boolean.TYPE}, new Object[]{"short", "S", Short.TYPE}, new Object[]{"byte", "B", Byte.TYPE}, new Object[]{"char", "C", Character.TYPE}, new Object[]{"float", "F", Float.TYPE}, new Object[]{"double", "D", Double.TYPE}};
    private static final Map NAME_TO_FD = new HashMap();
    private static final Map NAME_TO_CLASS = new HashMap();

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.BuiltinClassImpl, org.apache.xmlbeans.impl.jam.JClass
    public boolean isPrimitiveType() {
        return true;
    }

    static {
        int i = 0;
        while (true) {
            Object[][] objArr = PRIMITIVES;
            if (i >= objArr.length) {
                return;
            }
            Map map = NAME_TO_FD;
            Object[] objArr2 = objArr[i];
            map.put(objArr2[0], objArr2[1]);
            Map map2 = NAME_TO_CLASS;
            Object[] objArr3 = objArr[i];
            map2.put(objArr3[0], objArr3[2]);
            i++;
        }
    }

    public static void mapNameToPrimitive(ElementContext elementContext, Map map) {
        int i = 0;
        while (true) {
            Object[][] objArr = PRIMITIVES;
            if (i >= objArr.length) {
                return;
            }
            PrimitiveClassImpl primitiveClassImpl = new PrimitiveClassImpl(elementContext, (String) objArr[i][0]);
            map.put(objArr[i][0], primitiveClassImpl);
            map.put(objArr[i][1], primitiveClassImpl);
            i++;
        }
    }

    public static String getPrimitiveClassForName(String str) {
        return (String) NAME_TO_FD.get(str);
    }

    public static boolean isPrimitive(String str) {
        return NAME_TO_FD.get(str) != null;
    }

    public static final String getFieldDescriptor(String str) {
        return (String) NAME_TO_FD.get(str);
    }

    public static final Class getPrimitiveClass(String str) {
        return (Class) NAME_TO_CLASS.get(str);
    }

    private PrimitiveClassImpl(ElementContext elementContext, String str) {
        super(elementContext);
        if (str == null) {
            throw new IllegalArgumentException("null name");
        }
        if (!NAME_TO_FD.containsKey(str)) {
            throw new IllegalArgumentException("Unknown primitive class '" + str + "'");
        }
        reallySetSimpleName(str);
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.BuiltinClassImpl, org.apache.xmlbeans.impl.jam.JElement
    public String getQualifiedName() {
        return getSimpleName();
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.BuiltinClassImpl, org.apache.xmlbeans.impl.jam.JClass
    public String getFieldDescriptor() {
        return (String) NAME_TO_FD.get(getSimpleName());
    }

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isAssignableFrom(JClass jClass) {
        return jClass.isPrimitiveType() && jClass.getSimpleName().equals(getSimpleName());
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.BuiltinClassImpl, org.apache.xmlbeans.impl.jam.JClass
    public Class getPrimitiveClass() {
        return (Class) NAME_TO_CLASS.get(getSimpleName());
    }
}
