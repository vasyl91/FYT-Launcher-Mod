package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
interface IEvaluationListener {

    public interface ICacheEntry {
        ValueEval getValue();
    }

    void onCacheHit(int i, int i2, int i3, ValueEval valueEval);

    void onChangeFromBlankValue(int i, int i2, int i3, EvaluationCell evaluationCell, ICacheEntry iCacheEntry);

    void onClearCachedValue(ICacheEntry iCacheEntry);

    void onClearDependentCachedValue(ICacheEntry iCacheEntry, int i);

    void onClearWholeCache();

    void onEndEvaluate(ICacheEntry iCacheEntry, ValueEval valueEval);

    void onReadPlainValue(int i, int i2, int i3, ICacheEntry iCacheEntry);

    void onStartEvaluate(EvaluationCell evaluationCell, ICacheEntry iCacheEntry);

    void sortDependentCachedValues(ICacheEntry[] iCacheEntryArr);
}
