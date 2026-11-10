package org.apache.poi.ss.formula.ptg;

import org.apache.poi.ss.formula.function.FunctionMetadata;
import org.apache.poi.ss.formula.function.FunctionMetadataRegistry;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class FuncVarPtg extends AbstractFunctionPtg {
    private static final int SIZE = 4;
    public static final OperationPtg SUM = create("SUM", 1);
    public static final byte sid = 34;

    @Override // org.apache.poi.ss.formula.ptg.AbstractFunctionPtg, org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 4;
    }

    private FuncVarPtg(int i, int i2, byte[] bArr, int i3) {
        super(i, i2, bArr, i3);
    }

    public static FuncVarPtg create(LittleEndianInput littleEndianInput) {
        return create(littleEndianInput.readByte(), littleEndianInput.readShort());
    }

    public static FuncVarPtg create(String str, int i) {
        return create(i, lookupIndex(str));
    }

    private static FuncVarPtg create(int i, int i2) {
        FunctionMetadata functionByIndex = FunctionMetadataRegistry.getFunctionByIndex(i2);
        if (functionByIndex == null) {
            return new FuncVarPtg(i2, 32, new byte[]{32}, i);
        }
        return new FuncVarPtg(i2, functionByIndex.getReturnClassCode(), functionByIndex.getParameterClassCodes(), i);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + 34);
        littleEndianOutput.writeByte(getNumberOfOperands());
        littleEndianOutput.writeShort(getFunctionIndex());
    }
}
