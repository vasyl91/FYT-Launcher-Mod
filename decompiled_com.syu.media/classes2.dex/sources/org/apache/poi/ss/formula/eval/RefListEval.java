package org.apache.poi.ss.formula.eval;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class RefListEval implements ValueEval {
    private final List<ValueEval> list = new ArrayList();

    public RefListEval(ValueEval valueEval, ValueEval valueEval2) {
        add(valueEval);
        add(valueEval2);
    }

    private void add(ValueEval valueEval) {
        if (valueEval instanceof RefListEval) {
            this.list.addAll(((RefListEval) valueEval).list);
        } else {
            this.list.add(valueEval);
        }
    }

    public List<ValueEval> getList() {
        return this.list;
    }
}
