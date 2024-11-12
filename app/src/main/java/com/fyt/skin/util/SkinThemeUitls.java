package com.fyt.skin.util;

import android.content.Context;
import android.content.res.TypedArray;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class SkinThemeUitls {
    public static int[] getThemeResid(Context context, int[] attrs) {
        int[] resIds = new int[1];
        resIds[0] = attrs.length;
        TypedArray typedArray = context.obtainStyledAttributes(attrs);
        for (int i = 0; i < typedArray.length(); i++) {
            int resourceId = typedArray.getResourceId(i, 0);
            resIds[i] = resourceId;
        }
        typedArray.recycle();
        return resIds;
    }
}
