package org.apache.poi.ss.formula.udf;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class DefaultUDFFinder implements UDFFinder {
    private final Map<String, FreeRefFunction> _functionsByName;

    public DefaultUDFFinder(String[] strArr, FreeRefFunction[] freeRefFunctionArr) {
        int length = strArr.length;
        if (freeRefFunctionArr.length != length) {
            throw new IllegalArgumentException("Mismatch in number of function names and implementations");
        }
        HashMap map = new HashMap((length * 3) / 2);
        for (int i = 0; i < freeRefFunctionArr.length; i++) {
            map.put(strArr[i].toUpperCase(Locale.ROOT), freeRefFunctionArr[i]);
        }
        this._functionsByName = map;
    }

    @Override // org.apache.poi.ss.formula.udf.UDFFinder
    public FreeRefFunction findFunction(String str) {
        return this._functionsByName.get(str.toUpperCase(Locale.ROOT));
    }
}
