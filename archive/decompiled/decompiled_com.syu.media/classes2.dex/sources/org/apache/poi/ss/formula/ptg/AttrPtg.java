package org.apache.poi.ss.formula.ptg;

import org.apache.poi.hpsf.Variant;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class AttrPtg extends ControlPtg {
    private static final int SIZE = 4;
    public static final byte sid = 25;
    private final int _chooseFuncOffset;
    private final short _data;
    private final int[] _jumpTable;
    private final byte _options;
    private static final BitField semiVolatile = BitFieldFactory.getInstance(1);
    private static final BitField optiIf = BitFieldFactory.getInstance(2);
    private static final BitField optiChoose = BitFieldFactory.getInstance(4);
    private static final BitField optiSkip = BitFieldFactory.getInstance(8);
    private static final BitField optiSum = BitFieldFactory.getInstance(16);
    private static final BitField baxcel = BitFieldFactory.getInstance(32);
    private static final BitField space = BitFieldFactory.getInstance(64);
    public static final AttrPtg SUM = new AttrPtg(16, 0, null, -1);

    public int getNumberOfOperands() {
        return 1;
    }

    public int getType() {
        return -1;
    }

    public static final class SpaceType {
        public static final int CR_BEFORE = 1;
        public static final int CR_BEFORE_CLOSE_PAREN = 5;
        public static final int CR_BEFORE_OPEN_PAREN = 3;
        public static final int SPACE_AFTER_EQUALITY = 6;
        public static final int SPACE_BEFORE = 0;
        public static final int SPACE_BEFORE_CLOSE_PAREN = 4;
        public static final int SPACE_BEFORE_OPEN_PAREN = 2;

        private SpaceType() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AttrPtg(LittleEndianInput littleEndianInput) {
        this._options = littleEndianInput.readByte();
        int i = littleEndianInput.readShort();
        this._data = i;
        if (isOptimizedChoose()) {
            int[] iArr = new int[i];
            for (int i2 = 0; i2 < i; i2++) {
                iArr[i2] = littleEndianInput.readUShort();
            }
            this._jumpTable = iArr;
            this._chooseFuncOffset = littleEndianInput.readUShort();
            return;
        }
        this._jumpTable = null;
        this._chooseFuncOffset = -1;
    }

    private AttrPtg(int i, int i2, int[] iArr, int i3) {
        this._options = (byte) i;
        this._data = (short) i2;
        this._jumpTable = iArr;
        this._chooseFuncOffset = i3;
    }

    public static AttrPtg createSpace(int i, int i2) {
        return new AttrPtg(space.set(0), (i & 255) | ((i2 << 8) & Variant.VT_ILLEGAL), null, -1);
    }

    public static AttrPtg createIf(int i) {
        return new AttrPtg(optiIf.set(0), i, null, -1);
    }

    public static AttrPtg createSkip(int i) {
        return new AttrPtg(optiSkip.set(0), i, null, -1);
    }

    public static AttrPtg getSumSingle() {
        return new AttrPtg(optiSum.set(0), 0, null, -1);
    }

    public boolean isSemiVolatile() {
        return semiVolatile.isSet(this._options);
    }

    public boolean isOptimizedIf() {
        return optiIf.isSet(this._options);
    }

    public boolean isOptimizedChoose() {
        return optiChoose.isSet(this._options);
    }

    public boolean isSum() {
        return optiSum.isSet(this._options);
    }

    public boolean isSkip() {
        return optiSkip.isSet(this._options);
    }

    private boolean isBaxcel() {
        return baxcel.isSet(this._options);
    }

    public boolean isSpace() {
        return space.isSet(this._options);
    }

    public short getData() {
        return this._data;
    }

    public int[] getJumpTable() {
        return (int[]) this._jumpTable.clone();
    }

    public int getChooseFuncOffset() {
        if (this._jumpTable == null) {
            throw new IllegalStateException("Not tAttrChoose");
        }
        return this._chooseFuncOffset;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append(getClass().getName()).append(" [");
        if (isSemiVolatile()) {
            stringBuffer.append("volatile ");
        }
        if (isSpace()) {
            stringBuffer.append("space count=").append((this._data >> 8) & 255);
            stringBuffer.append(" type=").append(this._data & 255).append(" ");
        }
        if (isOptimizedIf()) {
            stringBuffer.append("if dist=").append((int) this._data);
        } else if (isOptimizedChoose()) {
            stringBuffer.append("choose nCases=").append((int) this._data);
        } else if (isSkip()) {
            stringBuffer.append("skip dist=").append((int) this._data);
        } else if (isSum()) {
            stringBuffer.append("sum ");
        } else if (isBaxcel()) {
            stringBuffer.append("assign ");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + sid);
        littleEndianOutput.writeByte(this._options);
        littleEndianOutput.writeShort(this._data);
        int[] iArr = this._jumpTable;
        if (iArr != null) {
            for (int i : iArr) {
                littleEndianOutput.writeShort(i);
            }
            littleEndianOutput.writeShort(this._chooseFuncOffset);
        }
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        int[] iArr = this._jumpTable;
        if (iArr != null) {
            return ((iArr.length + 1) * 2) + 4;
        }
        return 4;
    }

    public String toFormulaString(String[] strArr) {
        if (space.isSet(this._options)) {
            return strArr[0];
        }
        if (optiIf.isSet(this._options)) {
            return toFormulaString() + "(" + strArr[0] + ")";
        }
        if (optiSkip.isSet(this._options)) {
            return toFormulaString() + strArr[0];
        }
        return toFormulaString() + "(" + strArr[0] + ")";
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        if (semiVolatile.isSet(this._options)) {
            return "ATTR(semiVolatile)";
        }
        if (optiIf.isSet(this._options)) {
            return "IF";
        }
        if (optiChoose.isSet(this._options)) {
            return "CHOOSE";
        }
        if (optiSkip.isSet(this._options)) {
            return "";
        }
        if (optiSum.isSet(this._options)) {
            return "SUM";
        }
        if (baxcel.isSet(this._options)) {
            return "ATTR(baxcel)";
        }
        return space.isSet(this._options) ? "" : "UNKNOWN ATTRIBUTE";
    }
}
