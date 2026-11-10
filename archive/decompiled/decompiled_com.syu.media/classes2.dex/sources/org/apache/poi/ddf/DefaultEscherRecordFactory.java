package org.apache.poi.ddf;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DefaultEscherRecordFactory implements EscherRecordFactory {
    private static Class<?>[] escherRecordClasses;
    private static Map<Short, Constructor<? extends EscherRecord>> recordsMap;

    public static boolean isContainer(short s, short s2) {
        if (s2 < -4096 || s2 > -4091) {
            return s2 != -4083 && (s & 15) == 15;
        }
        return true;
    }

    static {
        Class<?>[] clsArr = {EscherBSERecord.class, EscherOptRecord.class, EscherTertiaryOptRecord.class, EscherClientAnchorRecord.class, EscherDgRecord.class, EscherSpgrRecord.class, EscherSpRecord.class, EscherClientDataRecord.class, EscherDggRecord.class, EscherSplitMenuColorsRecord.class, EscherChildAnchorRecord.class, EscherTextboxRecord.class};
        escherRecordClasses = clsArr;
        recordsMap = recordsToMap(clsArr);
    }

    @Override // org.apache.poi.ddf.EscherRecordFactory
    public EscherRecord createRecord(byte[] bArr, int i) {
        EscherRecord escherBitmapBlip;
        short s = LittleEndian.getShort(bArr, i);
        short s2 = LittleEndian.getShort(bArr, i + 2);
        if (isContainer(s, s2)) {
            EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
            escherContainerRecord.setRecordId(s2);
            escherContainerRecord.setOptions(s);
            return escherContainerRecord;
        }
        if (s2 >= -4072 && s2 <= -3817) {
            if (s2 == -4065 || s2 == -4067 || s2 == -4066) {
                escherBitmapBlip = new EscherBitmapBlip();
            } else if (s2 == -4070 || s2 == -4069 || s2 == -4068) {
                escherBitmapBlip = new EscherMetafileBlip();
            } else {
                escherBitmapBlip = new EscherBlipRecord();
            }
            escherBitmapBlip.setRecordId(s2);
            escherBitmapBlip.setOptions(s);
            return escherBitmapBlip;
        }
        Constructor<? extends EscherRecord> constructor = recordsMap.get(Short.valueOf(s2));
        if (constructor == null) {
            return new UnknownEscherRecord();
        }
        try {
            EscherRecord escherRecordNewInstance = constructor.newInstance(new Object[0]);
            escherRecordNewInstance.setRecordId(s2);
            escherRecordNewInstance.setOptions(s);
            return escherRecordNewInstance;
        } catch (Exception unused) {
            return new UnknownEscherRecord();
        }
    }

    protected static Map<Short, Constructor<? extends EscherRecord>> recordsToMap(Class<?>[] clsArr) {
        HashMap map = new HashMap();
        Class<?>[] clsArr2 = new Class[0];
        for (Class<?> cls : clsArr) {
            try {
                try {
                    map.put(Short.valueOf(cls.getField("RECORD_ID").getShort(null)), cls.getConstructor(clsArr2));
                } catch (NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (IllegalArgumentException e3) {
                throw new RuntimeException(e3);
            } catch (NoSuchFieldException e4) {
                throw new RuntimeException(e4);
            }
        }
        return map;
    }
}
