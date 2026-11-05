package org.apache.poi.ss.formula.ptg;

import org.apache.poi.ss.formula.function.FunctionMetadata;
import org.apache.poi.ss.formula.function.FunctionMetadataRegistry;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class FuncPtg extends AbstractFunctionPtg {
    public static final int SIZE = 3;
    public static final byte sid = 33;

    @Override // org.apache.poi.ss.formula.ptg.AbstractFunctionPtg, org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 3;
    }

    public static FuncPtg create(LittleEndianInput littleEndianInput) {
        return create(littleEndianInput.readUShort());
    }

    private FuncPtg(int i, FunctionMetadata functionMetadata) {
        super(i, functionMetadata.getReturnClassCode(), functionMetadata.getParameterClassCodes(), functionMetadata.getMinParams());
    }

    public static FuncPtg create(int i) {
        FunctionMetadata functionByIndex = FunctionMetadataRegistry.getFunctionByIndex(i);
        if (functionByIndex == null) {
            throw new RuntimeException("Invalid built-in function index (" + i + ")");
        }
        return new FuncPtg(i, functionByIndex);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + 33);
        littleEndianOutput.writeShort(getFunctionIndex());
    }
}
