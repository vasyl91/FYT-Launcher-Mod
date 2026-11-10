package org.apache.xmlbeans.impl.jam.internal.elements;

import org.apache.xmlbeans.impl.jam.JAnnotation;
import org.apache.xmlbeans.impl.jam.JAnnotationValue;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRef;
import org.apache.xmlbeans.impl.jam.internal.classrefs.QualifiedJClassRef;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class AnnotationValueImpl implements JAnnotationValue {
    private ElementContext mContext;
    private String mName;
    private JClassRef mType;
    private Object mValue;

    public AnnotationValueImpl(ElementContext elementContext, String str, Object obj, JClass jClass) {
        this.mValue = null;
        this.mType = null;
        if (elementContext == null) {
            throw new IllegalArgumentException("null ctx");
        }
        if (str == null) {
            throw new IllegalArgumentException("null name");
        }
        if (obj == null) {
            throw new IllegalArgumentException("null value");
        }
        if (jClass == null) {
            throw new IllegalArgumentException("null type");
        }
        if (obj.getClass().isArray()) {
            this.mValue = ensureArrayWrapped(obj);
        } else {
            this.mValue = obj;
        }
        this.mContext = elementContext;
        this.mName = str;
        this.mType = QualifiedJClassRef.create(jClass);
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotationValue
    public boolean isDefaultValueUsed() {
        throw new IllegalStateException("NYI");
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotationValue
    public String getName() {
        return this.mName;
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotationValue
    public JClass getType() {
        return this.mType.getRefClass();
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotationValue
    public JAnnotation asAnnotation() {
        Object obj = this.mValue;
        if (obj instanceof JAnnotation) {
            return (JAnnotation) obj;
        }
        return null;
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotationValue
    public JClass asClass() {
        Object obj = this.mValue;
        if (obj instanceof JClass) {
            return (JClass) obj;
        }
        return null;
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotationValue
    public String asString() {
        Object obj = this.mValue;
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotationValue
    public int asInt() throws NumberFormatException {
        Object obj = this.mValue;
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        try {
            return Integer.parseInt(obj.toString().trim());
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotationValue
    public boolean asBoolean() throws IllegalArgumentException {
        Object obj = this.mValue;
        if (obj == null) {
            return false;
        }
        return Boolean.valueOf(obj.toString().trim()).booleanValue();
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotationValue
    public long asLong() throws NumberFormatException {
        Object obj = this.mValue;
        if (obj == null) {
            return 0L;
        }
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        try {
            return Long.parseLong(obj.toString().trim());
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotationValue
    public short asShort() throws NumberFormatException {
        Object obj = this.mValue;
        if (obj == null) {
            return (short) 0;
        }
        if (obj instanceof Number) {
            return ((Number) obj).shortValue();
        }
        try {
            return Short.parseShort(obj.toString().trim());
        } catch (NumberFormatException unused) {
            return (short) 0;
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotationValue
    public double asDouble() throws NumberFormatException {
        Object obj = this.mValue;
        if (obj == null) {
            return 0.0d;
        }
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        try {
            return Double.parseDouble(obj.toString().trim());
        } catch (NumberFormatException unused) {
            return 0.0d;
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotationValue
    public float asFloat() throws NumberFormatException {
        Object obj = this.mValue;
        if (obj == null) {
            return 0.0f;
        }
        if (obj instanceof Number) {
            return ((Number) obj).floatValue();
        }
        try {
            return Float.parseFloat(obj.toString().trim());
        } catch (NumberFormatException unused) {
            return 0.0f;
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotationValue
    public byte asByte() throws NumberFormatException {
        Object obj = this.mValue;
        if (obj == null) {
            return (byte) 0;
        }
        if (obj instanceof Number) {
            return ((Number) obj).byteValue();
        }
        try {
            return Byte.parseByte(obj.toString().trim());
        } catch (NumberFormatException unused) {
            return (byte) 0;
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotationValue
    public char asChar() throws IllegalArgumentException {
        Object obj = this.mValue;
        if (obj == null) {
            return (char) 0;
        }
        if (obj instanceof Character) {
            return ((Character) obj).charValue();
        }
        String string = obj.toString();
        this.mValue = string;
        if (string.length() == 0) {
            return (char) 0;
        }
        return ((String) this.mValue).charAt(0);
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotationValue
    public JClass[] asClassArray() {
        Object obj = this.mValue;
        if (obj instanceof JClass[]) {
            return (JClass[]) obj;
        }
        return null;
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotationValue
    public JAnnotation[] asAnnotationArray() {
        Object obj = this.mValue;
        if (obj instanceof JAnnotation[]) {
            return (JAnnotation[]) obj;
        }
        return null;
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotationValue
    public String[] asStringArray() {
        if (!this.mValue.getClass().isArray()) {
            return null;
        }
        int length = ((Object[]) this.mValue).length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            Object obj = this.mValue;
            if (((Object[]) obj)[i] == null) {
                this.mContext.getLogger().error("Null annotation value array element on " + getName());
                strArr[i] = "";
            } else {
                strArr[i] = ((Object[]) obj)[i].toString();
            }
        }
        return strArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotationValue
    public int[] asIntArray() throws NumberFormatException {
        if (!this.mValue.getClass().isArray()) {
            return null;
        }
        int length = ((Object[]) this.mValue).length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            Object obj = this.mValue;
            if (((Object[]) obj)[i] == null) {
                this.mContext.getLogger().error("Null annotation value array element " + i + " on " + getName());
                iArr[i] = 0;
            } else {
                iArr[i] = Integer.parseInt(((Object[]) obj)[i].toString());
            }
        }
        return iArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotationValue
    public boolean[] asBooleanArray() throws IllegalArgumentException {
        if (!this.mValue.getClass().isArray()) {
            return null;
        }
        int length = ((Object[]) this.mValue).length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            Object obj = this.mValue;
            if (((Object[]) obj)[i] == null) {
                this.mContext.getLogger().error("Null annotation value array element " + i + " on " + getName());
                zArr[i] = false;
            } else {
                zArr[i] = Boolean.valueOf(((Object[]) obj)[i].toString()).booleanValue();
            }
        }
        return zArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotationValue
    public short[] asShortArray() throws NumberFormatException {
        if (!this.mValue.getClass().isArray()) {
            return null;
        }
        int length = ((Object[]) this.mValue).length;
        short[] sArr = new short[length];
        for (int i = 0; i < length; i++) {
            Object obj = this.mValue;
            if (((Object[]) obj)[i] == null) {
                this.mContext.getLogger().error("Null annotation value array element " + i + " on " + getName());
                sArr[i] = 0;
            } else {
                sArr[i] = Short.parseShort(((Object[]) obj)[i].toString());
            }
        }
        return sArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotationValue
    public long[] asLongArray() throws NumberFormatException {
        if (!this.mValue.getClass().isArray()) {
            return null;
        }
        int length = ((Object[]) this.mValue).length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            Object obj = this.mValue;
            if (((Object[]) obj)[i] == null) {
                this.mContext.getLogger().error("Null annotation value array element " + i + " on " + getName());
                jArr[i] = 0;
            } else {
                jArr[i] = Long.parseLong(((Object[]) obj)[i].toString());
            }
        }
        return jArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotationValue
    public double[] asDoubleArray() throws NumberFormatException {
        if (!this.mValue.getClass().isArray()) {
            return null;
        }
        int length = ((Object[]) this.mValue).length;
        double[] dArr = new double[length];
        for (int i = 0; i < length; i++) {
            Object obj = this.mValue;
            if (((Object[]) obj)[i] == null) {
                this.mContext.getLogger().error("Null annotation value array element " + i + " on " + getName());
                dArr[i] = 0.0d;
            } else {
                dArr[i] = Double.parseDouble(((Object[]) obj)[i].toString());
            }
        }
        return dArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotationValue
    public float[] asFloatArray() throws NumberFormatException {
        if (!this.mValue.getClass().isArray()) {
            return null;
        }
        int length = ((Object[]) this.mValue).length;
        float[] fArr = new float[length];
        for (int i = 0; i < length; i++) {
            Object obj = this.mValue;
            if (((Object[]) obj)[i] == null) {
                this.mContext.getLogger().error("Null annotation value array element " + i + " on " + getName());
                fArr[i] = 0.0f;
            } else {
                fArr[i] = Float.parseFloat(((Object[]) obj)[i].toString());
            }
        }
        return fArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotationValue
    public byte[] asByteArray() throws NumberFormatException {
        if (!this.mValue.getClass().isArray()) {
            return null;
        }
        int length = ((Object[]) this.mValue).length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            Object obj = this.mValue;
            if (((Object[]) obj)[i] == null) {
                this.mContext.getLogger().error("Null annotation value array element " + i + " on " + getName());
                bArr[i] = 0;
            } else {
                bArr[i] = Byte.parseByte(((Object[]) obj)[i].toString());
            }
        }
        return bArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotationValue
    public char[] asCharArray() throws IllegalArgumentException {
        if (!this.mValue.getClass().isArray()) {
            return null;
        }
        int length = ((Object[]) this.mValue).length;
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            Object obj = this.mValue;
            if (((Object[]) obj)[i] == null) {
                this.mContext.getLogger().error("Null annotation value array element " + i + " on " + getName());
                cArr[i] = 0;
            } else {
                cArr[i] = ((Object[]) obj)[i].toString().charAt(0);
            }
        }
        return cArr;
    }

    private static final Object[] ensureArrayWrapped(Object obj) {
        if (obj instanceof Object[]) {
            return (Object[]) obj;
        }
        int i = 0;
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length = iArr.length;
            Integer[] numArr = new Integer[length];
            while (i < length) {
                numArr[i] = new Integer(iArr[i]);
                i++;
            }
            return numArr;
        }
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length2 = zArr.length;
            Boolean[] boolArr = new Boolean[length2];
            while (i < length2) {
                boolArr[i] = Boolean.valueOf(zArr[i]);
                i++;
            }
            return boolArr;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length3 = bArr.length;
            Byte[] bArr2 = new Byte[length3];
            while (i < length3) {
                bArr2[i] = new Byte(bArr[i]);
                i++;
            }
            return bArr2;
        }
        if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            int length4 = cArr.length;
            Character[] chArr = new Character[length4];
            while (i < length4) {
                chArr[i] = new Character(cArr[i]);
                i++;
            }
            return chArr;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            int length5 = fArr.length;
            Float[] fArr2 = new Float[length5];
            while (i < length5) {
                fArr2[i] = new Float(fArr[i]);
                i++;
            }
            return fArr2;
        }
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length6 = dArr.length;
            Double[] dArr2 = new Double[length6];
            while (i < length6) {
                dArr2[i] = new Double(dArr[i]);
                i++;
            }
            return dArr2;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length7 = jArr.length;
            Long[] lArr = new Long[length7];
            while (i < length7) {
                lArr[i] = new Long(jArr[i]);
                i++;
            }
            return lArr;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length8 = sArr.length;
            Short[] shArr = new Short[length8];
            while (i < length8) {
                shArr[i] = new Short(sArr[i]);
                i++;
            }
            return shArr;
        }
        throw new IllegalStateException("Unknown array type " + obj.getClass());
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotationValue
    public Object getValue() {
        return this.mValue;
    }
}
