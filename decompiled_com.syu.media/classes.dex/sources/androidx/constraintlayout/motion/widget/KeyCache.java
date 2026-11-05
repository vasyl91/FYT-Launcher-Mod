package androidx.constraintlayout.motion.widget;

import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class KeyCache {
    HashMap<Object, HashMap<String, float[]>> map = new HashMap<>();

    void setFloatValue(Object obj, String str, int i, float f) {
        if (!this.map.containsKey(obj)) {
            HashMap<String, float[]> map = new HashMap<>();
            float[] fArr = new float[i + 1];
            fArr[i] = f;
            map.put(str, fArr);
            this.map.put(obj, map);
            return;
        }
        HashMap<String, float[]> map2 = this.map.get(obj);
        if (!map2.containsKey(str)) {
            float[] fArr2 = new float[i + 1];
            fArr2[i] = f;
            map2.put(str, fArr2);
            this.map.put(obj, map2);
            return;
        }
        float[] fArrCopyOf = map2.get(str);
        if (fArrCopyOf.length <= i) {
            fArrCopyOf = Arrays.copyOf(fArrCopyOf, i + 1);
        }
        fArrCopyOf[i] = f;
        map2.put(str, fArrCopyOf);
    }

    float getFloatValue(Object obj, String str, int i) {
        if (!this.map.containsKey(obj)) {
            return Float.NaN;
        }
        HashMap<String, float[]> map = this.map.get(obj);
        if (!map.containsKey(str)) {
            return Float.NaN;
        }
        float[] fArr = map.get(str);
        if (fArr.length > i) {
            return fArr[i];
        }
        return Float.NaN;
    }
}
