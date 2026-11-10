package org.apache.poi.ss.formula;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public final class CollaboratingWorkbooksEnvironment {
    public static final CollaboratingWorkbooksEnvironment EMPTY = new CollaboratingWorkbooksEnvironment();
    private final WorkbookEvaluator[] _evaluators;
    private final Map<String, WorkbookEvaluator> _evaluatorsByName;
    private boolean _unhooked;

    public static final class WorkbookNotFoundException extends Exception {
        private static final long serialVersionUID = 8787784539811167941L;

        WorkbookNotFoundException(String str) {
            super(str);
        }
    }

    private CollaboratingWorkbooksEnvironment() {
        this._evaluatorsByName = Collections.emptyMap();
        this._evaluators = new WorkbookEvaluator[0];
    }

    public static void setup(String[] strArr, WorkbookEvaluator[] workbookEvaluatorArr) {
        int length = strArr.length;
        if (workbookEvaluatorArr.length != length) {
            throw new IllegalArgumentException("Number of workbook names is " + length + " but number of evaluators is " + workbookEvaluatorArr.length);
        }
        if (length < 1) {
            throw new IllegalArgumentException("Must provide at least one collaborating worbook");
        }
        new CollaboratingWorkbooksEnvironment(strArr, workbookEvaluatorArr, length);
    }

    public static void setup(Map<String, WorkbookEvaluator> map) {
        if (map.size() < 1) {
            throw new IllegalArgumentException("Must provide at least one collaborating worbook");
        }
        new CollaboratingWorkbooksEnvironment(map, (WorkbookEvaluator[]) map.values().toArray(new WorkbookEvaluator[map.size()]));
    }

    public static void setupFormulaEvaluator(Map<String, FormulaEvaluator> map) {
        HashMap map2 = new HashMap(map.size());
        for (Map.Entry<String, FormulaEvaluator> entry : map.entrySet()) {
            String key = entry.getKey();
            FormulaEvaluator value = entry.getValue();
            if (value instanceof WorkbookEvaluatorProvider) {
                map2.put(key, ((WorkbookEvaluatorProvider) value)._getWorkbookEvaluator());
            } else {
                throw new IllegalArgumentException("Formula Evaluator " + value + " provides no WorkbookEvaluator access");
            }
        }
        setup(map2);
    }

    private CollaboratingWorkbooksEnvironment(String[] strArr, WorkbookEvaluator[] workbookEvaluatorArr, int i) {
        this(toUniqueMap(strArr, workbookEvaluatorArr, i), workbookEvaluatorArr);
    }

    private static Map<String, WorkbookEvaluator> toUniqueMap(String[] strArr, WorkbookEvaluator[] workbookEvaluatorArr, int i) {
        HashMap map = new HashMap((i * 3) / 2);
        for (int i2 = 0; i2 < i; i2++) {
            String str = strArr[i2];
            WorkbookEvaluator workbookEvaluator = workbookEvaluatorArr[i2];
            if (map.containsKey(str)) {
                throw new IllegalArgumentException("Duplicate workbook name '" + str + "'");
            }
            map.put(str, workbookEvaluator);
        }
        return map;
    }

    private CollaboratingWorkbooksEnvironment(Map<String, WorkbookEvaluator> map, WorkbookEvaluator[] workbookEvaluatorArr) {
        IdentityHashMap identityHashMap = new IdentityHashMap(workbookEvaluatorArr.length);
        for (Map.Entry<String, WorkbookEvaluator> entry : map.entrySet()) {
            String str = (String) identityHashMap.put(entry.getValue(), entry.getKey());
            if (str != null) {
                throw new IllegalArgumentException("Attempted to register same workbook under names '" + str + "' and '" + entry.getKey() + "'");
            }
        }
        unhookOldEnvironments(workbookEvaluatorArr);
        hookNewEnvironment(workbookEvaluatorArr, this);
        this._unhooked = false;
        this._evaluators = (WorkbookEvaluator[]) workbookEvaluatorArr.clone();
        this._evaluatorsByName = map;
    }

    private static void hookNewEnvironment(WorkbookEvaluator[] workbookEvaluatorArr, CollaboratingWorkbooksEnvironment collaboratingWorkbooksEnvironment) {
        int length = workbookEvaluatorArr.length;
        IEvaluationListener evaluationListener = workbookEvaluatorArr[0].getEvaluationListener();
        for (WorkbookEvaluator workbookEvaluator : workbookEvaluatorArr) {
            if (evaluationListener != workbookEvaluator.getEvaluationListener()) {
                throw new RuntimeException("Workbook evaluators must all have the same evaluation listener");
            }
        }
        EvaluationCache evaluationCache = new EvaluationCache(evaluationListener);
        for (int i = 0; i < length; i++) {
            workbookEvaluatorArr[i].attachToEnvironment(collaboratingWorkbooksEnvironment, evaluationCache, i);
        }
    }

    private void unhookOldEnvironments(WorkbookEvaluator[] workbookEvaluatorArr) {
        HashSet hashSet = new HashSet();
        for (WorkbookEvaluator workbookEvaluator : workbookEvaluatorArr) {
            hashSet.add(workbookEvaluator.getEnvironment());
        }
        int size = hashSet.size();
        CollaboratingWorkbooksEnvironment[] collaboratingWorkbooksEnvironmentArr = new CollaboratingWorkbooksEnvironment[size];
        hashSet.toArray(collaboratingWorkbooksEnvironmentArr);
        for (int i = 0; i < size; i++) {
            collaboratingWorkbooksEnvironmentArr[i].unhook();
        }
    }

    private void unhook() {
        if (this._evaluators.length < 1) {
            return;
        }
        int i = 0;
        while (true) {
            WorkbookEvaluator[] workbookEvaluatorArr = this._evaluators;
            if (i < workbookEvaluatorArr.length) {
                workbookEvaluatorArr[i].detachFromEnvironment();
                i++;
            } else {
                this._unhooked = true;
                return;
            }
        }
    }

    public WorkbookEvaluator getWorkbookEvaluator(String str) throws WorkbookNotFoundException {
        if (this._unhooked) {
            throw new IllegalStateException("This environment has been unhooked");
        }
        WorkbookEvaluator workbookEvaluator = this._evaluatorsByName.get(str);
        if (workbookEvaluator != null) {
            return workbookEvaluator;
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("Could not resolve external workbook name '").append(str).append("'.");
        if (this._evaluators.length < 1) {
            stringBuffer.append(" Workbook environment has not been set up.");
        } else {
            stringBuffer.append(" The following workbook names are valid: (");
            Iterator<String> it = this._evaluatorsByName.keySet().iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2 = i + 1;
                if (i > 0) {
                    stringBuffer.append(", ");
                }
                stringBuffer.append("'").append(it.next()).append("'");
                i = i2;
            }
            stringBuffer.append(")");
        }
        throw new WorkbookNotFoundException(stringBuffer.toString());
    }
}
