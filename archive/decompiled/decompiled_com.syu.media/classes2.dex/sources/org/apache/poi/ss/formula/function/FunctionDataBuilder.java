package org.apache.poi.ss.formula.function;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class FunctionDataBuilder {
    private final Map<Integer, FunctionMetadata> _functionDataByIndex;
    private final Map<String, FunctionMetadata> _functionDataByName;
    private int _maxFunctionIndex = -1;
    private final Set<Integer> _mutatingFunctionIndexes = new HashSet();

    public FunctionDataBuilder(int i) {
        int i2 = (i * 3) / 2;
        this._functionDataByName = new HashMap(i2);
        this._functionDataByIndex = new HashMap(i2);
    }

    public void add(int i, String str, int i2, int i3, byte b, byte[] bArr, boolean z) {
        FunctionMetadata functionMetadata = new FunctionMetadata(i, str, i2, i3, b, bArr);
        Integer numValueOf = Integer.valueOf(i);
        if (i > this._maxFunctionIndex) {
            this._maxFunctionIndex = i;
        }
        FunctionMetadata functionMetadata2 = this._functionDataByName.get(str);
        if (functionMetadata2 != null) {
            if (!z || !this._mutatingFunctionIndexes.contains(numValueOf)) {
                throw new RuntimeException("Multiple entries for function name '" + str + "'");
            }
            this._functionDataByIndex.remove(Integer.valueOf(functionMetadata2.getIndex()));
        }
        FunctionMetadata functionMetadata3 = this._functionDataByIndex.get(numValueOf);
        if (functionMetadata3 != null) {
            if (!z || !this._mutatingFunctionIndexes.contains(numValueOf)) {
                throw new RuntimeException("Multiple entries for function index (" + i + ")");
            }
            this._functionDataByName.remove(functionMetadata3.getName());
        }
        if (z) {
            this._mutatingFunctionIndexes.add(numValueOf);
        }
        this._functionDataByIndex.put(numValueOf, functionMetadata);
        this._functionDataByName.put(str, functionMetadata);
    }

    public FunctionMetadataRegistry build() {
        int size = this._functionDataByName.size();
        FunctionMetadata[] functionMetadataArr = new FunctionMetadata[size];
        this._functionDataByName.values().toArray(functionMetadataArr);
        FunctionMetadata[] functionMetadataArr2 = new FunctionMetadata[this._maxFunctionIndex + 1];
        for (int i = 0; i < size; i++) {
            FunctionMetadata functionMetadata = functionMetadataArr[i];
            functionMetadataArr2[functionMetadata.getIndex()] = functionMetadata;
        }
        return new FunctionMetadataRegistry(functionMetadataArr2, this._functionDataByName);
    }
}
