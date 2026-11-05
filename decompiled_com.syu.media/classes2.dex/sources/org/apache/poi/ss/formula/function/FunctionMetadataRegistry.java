package org.apache.poi.ss.formula.function;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class FunctionMetadataRegistry {
    public static final int FUNCTION_INDEX_CHOOSE = 100;
    public static final short FUNCTION_INDEX_EXTERNAL = 255;
    public static final int FUNCTION_INDEX_IF = 1;
    public static final short FUNCTION_INDEX_INDIRECT = 148;
    public static final short FUNCTION_INDEX_SUM = 4;
    public static final String FUNCTION_NAME_IF = "IF";
    private static FunctionMetadataRegistry _instance;
    private final FunctionMetadata[] _functionDataByIndex;
    private final Map<String, FunctionMetadata> _functionDataByName;

    private static FunctionMetadataRegistry getInstance() {
        if (_instance == null) {
            _instance = FunctionMetadataReader.createRegistry();
        }
        return _instance;
    }

    FunctionMetadataRegistry(FunctionMetadata[] functionMetadataArr, Map<String, FunctionMetadata> map) {
        this._functionDataByIndex = functionMetadataArr == null ? null : (FunctionMetadata[]) functionMetadataArr.clone();
        this._functionDataByName = map;
    }

    Set<String> getAllFunctionNames() {
        return this._functionDataByName.keySet();
    }

    public static FunctionMetadata getFunctionByIndex(int i) {
        return getInstance().getFunctionByIndexInternal(i);
    }

    private FunctionMetadata getFunctionByIndexInternal(int i) {
        return this._functionDataByIndex[i];
    }

    public static short lookupIndexByName(String str) {
        FunctionMetadata functionByNameInternal = getInstance().getFunctionByNameInternal(str);
        if (functionByNameInternal == null) {
            return (short) -1;
        }
        return (short) functionByNameInternal.getIndex();
    }

    private FunctionMetadata getFunctionByNameInternal(String str) {
        return this._functionDataByName.get(str);
    }

    public static FunctionMetadata getFunctionByName(String str) {
        return getInstance().getFunctionByNameInternal(str);
    }
}
