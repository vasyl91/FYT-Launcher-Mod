package org.apache.poi.ddf;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.ShortCompanionObject;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class EscherPropertyFactory {
    public List<EscherProperty> createProperties(byte[] bArr, int i, short s) {
        int length;
        EscherProperty escherBoolProperty;
        ArrayList<EscherProperty> arrayList = new ArrayList();
        for (int i2 = 0; i2 < s; i2++) {
            short s2 = LittleEndian.getShort(bArr, i);
            int i3 = LittleEndian.getInt(bArr, i + 2);
            short s3 = (short) (s2 & 16383);
            boolean z = (s2 & ShortCompanionObject.MIN_VALUE) != 0;
            byte propertyType = EscherProperties.getPropertyType(s3);
            if (propertyType == 1) {
                escherBoolProperty = new EscherBoolProperty(s2, i3);
            } else if (propertyType == 2) {
                escherBoolProperty = new EscherRGBProperty(s2, i3);
            } else if (propertyType == 3) {
                escherBoolProperty = new EscherShapePathProperty(s2, i3);
            } else if (!z) {
                escherBoolProperty = new EscherSimpleProperty(s2, i3);
            } else if (propertyType == 5) {
                escherBoolProperty = new EscherArrayProperty(s2, new byte[i3]);
            } else {
                escherBoolProperty = new EscherComplexProperty(s2, new byte[i3]);
            }
            arrayList.add(escherBoolProperty);
            i += 6;
        }
        for (EscherProperty escherProperty : arrayList) {
            if (escherProperty instanceof EscherComplexProperty) {
                if (escherProperty instanceof EscherArrayProperty) {
                    length = ((EscherArrayProperty) escherProperty).setArrayData(bArr, i);
                } else {
                    byte[] complexData = ((EscherComplexProperty) escherProperty).getComplexData();
                    int length2 = bArr.length - i;
                    if (length2 < complexData.length) {
                        throw new IllegalStateException("Could not read complex escher property, length was " + complexData.length + ", but had only " + length2 + " bytes left");
                    }
                    System.arraycopy(bArr, i, complexData, 0, complexData.length);
                    length = complexData.length;
                }
                i += length;
            }
        }
        return arrayList;
    }
}
