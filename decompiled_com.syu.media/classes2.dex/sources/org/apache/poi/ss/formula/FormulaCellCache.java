package org.apache.poi.ss.formula;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class FormulaCellCache {
    private final Map<Object, FormulaCellCacheEntry> _formulaEntriesByCell = new HashMap();

    interface IEntryOperation {
        void processEntry(FormulaCellCacheEntry formulaCellCacheEntry);
    }

    public CellCacheEntry[] getCacheEntries() {
        FormulaCellCacheEntry[] formulaCellCacheEntryArr = new FormulaCellCacheEntry[this._formulaEntriesByCell.size()];
        this._formulaEntriesByCell.values().toArray(formulaCellCacheEntryArr);
        return formulaCellCacheEntryArr;
    }

    public void clear() {
        this._formulaEntriesByCell.clear();
    }

    public FormulaCellCacheEntry get(EvaluationCell evaluationCell) {
        return this._formulaEntriesByCell.get(evaluationCell.getIdentityKey());
    }

    public void put(EvaluationCell evaluationCell, FormulaCellCacheEntry formulaCellCacheEntry) {
        this._formulaEntriesByCell.put(evaluationCell.getIdentityKey(), formulaCellCacheEntry);
    }

    public FormulaCellCacheEntry remove(EvaluationCell evaluationCell) {
        return this._formulaEntriesByCell.remove(evaluationCell.getIdentityKey());
    }

    public void applyOperation(IEntryOperation iEntryOperation) {
        Iterator<FormulaCellCacheEntry> it = this._formulaEntriesByCell.values().iterator();
        while (it.hasNext()) {
            iEntryOperation.processEntry(it.next());
        }
    }
}
