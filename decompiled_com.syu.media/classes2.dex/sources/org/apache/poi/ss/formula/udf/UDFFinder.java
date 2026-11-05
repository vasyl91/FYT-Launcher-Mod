package org.apache.poi.ss.formula.udf;

import org.apache.poi.ss.formula.atp.AnalysisToolPak;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface UDFFinder {

    @Deprecated
    public static final UDFFinder DEFAULT = new AggregatingUDFFinder(AnalysisToolPak.instance);

    FreeRefFunction findFunction(String str);
}
