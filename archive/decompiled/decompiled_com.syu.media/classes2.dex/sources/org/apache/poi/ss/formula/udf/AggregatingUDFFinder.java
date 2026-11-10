package org.apache.poi.ss.formula.udf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.apache.poi.ss.formula.atp.AnalysisToolPak;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class AggregatingUDFFinder implements UDFFinder {
    public static final UDFFinder DEFAULT = new AggregatingUDFFinder(AnalysisToolPak.instance);
    private final Collection<UDFFinder> _usedToolPacks;

    public AggregatingUDFFinder(UDFFinder... uDFFinderArr) {
        ArrayList arrayList = new ArrayList(uDFFinderArr.length);
        this._usedToolPacks = arrayList;
        arrayList.addAll(Arrays.asList(uDFFinderArr));
    }

    @Override // org.apache.poi.ss.formula.udf.UDFFinder
    public FreeRefFunction findFunction(String str) {
        Iterator<UDFFinder> it = this._usedToolPacks.iterator();
        while (it.hasNext()) {
            FreeRefFunction freeRefFunctionFindFunction = it.next().findFunction(str);
            if (freeRefFunctionFindFunction != null) {
                return freeRefFunctionFindFunction;
            }
        }
        return null;
    }

    public void add(UDFFinder uDFFinder) {
        this._usedToolPacks.add(uDFFinder);
    }
}
