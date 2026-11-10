package org.apache.poi.hssf.record;

import java.util.Arrays;
import org.apache.poi.hssf.record.cf.ColorGradientFormatting;
import org.apache.poi.hssf.record.cf.ColorGradientThreshold;
import org.apache.poi.hssf.record.cf.DataBarFormatting;
import org.apache.poi.hssf.record.cf.DataBarThreshold;
import org.apache.poi.hssf.record.cf.IconMultiStateFormatting;
import org.apache.poi.hssf.record.cf.IconMultiStateThreshold;
import org.apache.poi.hssf.record.cf.Threshold;
import org.apache.poi.hssf.record.common.ExtendedColor;
import org.apache.poi.hssf.record.common.FtrHeader;
import org.apache.poi.hssf.record.common.FutureRecord;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.UnionPtg;
import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class CFRule12Record extends CFRuleBase implements FutureRecord, Cloneable {
    public static final short sid = 2170;
    private ColorGradientFormatting color_gradient;
    private DataBarFormatting data_bar;
    private byte[] ext_formatting_data;
    private int ext_formatting_length;
    private byte ext_opts;
    private byte[] filter_data;
    private Formula formula_scale;
    private FtrHeader futureHeader;
    private IconMultiStateFormatting multistate;
    private int priority;
    private byte template_param_length;
    private byte[] template_params;
    private int template_type;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    private CFRule12Record(byte b, byte b2) {
        super(b, b2);
        setDefaults();
    }

    private CFRule12Record(byte b, byte b2, Ptg[] ptgArr, Ptg[] ptgArr2, Ptg[] ptgArr3) {
        super(b, b2, ptgArr, ptgArr2);
        setDefaults();
        this.formula_scale = Formula.create(ptgArr3);
    }

    private void setDefaults() {
        FtrHeader ftrHeader = new FtrHeader();
        this.futureHeader = ftrHeader;
        ftrHeader.setRecordType(sid);
        this.ext_formatting_length = 0;
        this.ext_formatting_data = new byte[4];
        this.formula_scale = Formula.create(Ptg.EMPTY_PTG_ARRAY);
        this.ext_opts = (byte) 0;
        this.priority = 0;
        this.template_type = getConditionType();
        this.template_param_length = UnionPtg.sid;
        this.template_params = new byte[16];
    }

    public static CFRule12Record create(HSSFSheet hSSFSheet, String str) {
        return new CFRule12Record((byte) 2, (byte) 0, parseFormula(str, hSSFSheet), null, null);
    }

    public static CFRule12Record create(HSSFSheet hSSFSheet, byte b, String str, String str2) {
        return new CFRule12Record((byte) 1, b, parseFormula(str, hSSFSheet), parseFormula(str2, hSSFSheet), null);
    }

    public static CFRule12Record create(HSSFSheet hSSFSheet, byte b, String str, String str2, String str3) {
        return new CFRule12Record((byte) 1, b, parseFormula(str, hSSFSheet), parseFormula(str2, hSSFSheet), parseFormula(str3, hSSFSheet));
    }

    public static CFRule12Record create(HSSFSheet hSSFSheet, ExtendedColor extendedColor) {
        CFRule12Record cFRule12Record = new CFRule12Record((byte) 4, (byte) 0);
        DataBarFormatting dataBarFormattingCreateDataBarFormatting = cFRule12Record.createDataBarFormatting();
        dataBarFormattingCreateDataBarFormatting.setColor(extendedColor);
        dataBarFormattingCreateDataBarFormatting.setPercentMin((byte) 0);
        dataBarFormattingCreateDataBarFormatting.setPercentMax((byte) 100);
        DataBarThreshold dataBarThreshold = new DataBarThreshold();
        dataBarThreshold.setType(ConditionalFormattingThreshold.RangeType.MIN.id);
        dataBarFormattingCreateDataBarFormatting.setThresholdMin(dataBarThreshold);
        DataBarThreshold dataBarThreshold2 = new DataBarThreshold();
        dataBarThreshold2.setType(ConditionalFormattingThreshold.RangeType.MAX.id);
        dataBarFormattingCreateDataBarFormatting.setThresholdMax(dataBarThreshold2);
        return cFRule12Record;
    }

    public static CFRule12Record create(HSSFSheet hSSFSheet, org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet iconSet) {
        int i = iconSet.num;
        Threshold[] thresholdArr = new Threshold[i];
        for (int i2 = 0; i2 < i; i2++) {
            thresholdArr[i2] = new IconMultiStateThreshold();
        }
        CFRule12Record cFRule12Record = new CFRule12Record((byte) 6, (byte) 0);
        IconMultiStateFormatting iconMultiStateFormattingCreateMultiStateFormatting = cFRule12Record.createMultiStateFormatting();
        iconMultiStateFormattingCreateMultiStateFormatting.setIconSet(iconSet);
        iconMultiStateFormattingCreateMultiStateFormatting.setThresholds(thresholdArr);
        return cFRule12Record;
    }

    public static CFRule12Record createColorScale(HSSFSheet hSSFSheet) {
        ExtendedColor[] extendedColorArr = new ExtendedColor[3];
        ColorGradientThreshold[] colorGradientThresholdArr = new ColorGradientThreshold[3];
        for (int i = 0; i < 3; i++) {
            colorGradientThresholdArr[i] = new ColorGradientThreshold();
            extendedColorArr[i] = new ExtendedColor();
        }
        CFRule12Record cFRule12Record = new CFRule12Record((byte) 3, (byte) 0);
        ColorGradientFormatting colorGradientFormattingCreateColorGradientFormatting = cFRule12Record.createColorGradientFormatting();
        colorGradientFormattingCreateColorGradientFormatting.setNumControlPoints(3);
        colorGradientFormattingCreateColorGradientFormatting.setThresholds(colorGradientThresholdArr);
        colorGradientFormattingCreateColorGradientFormatting.setColors(extendedColorArr);
        return cFRule12Record;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CFRule12Record(RecordInputStream recordInputStream) {
        this.futureHeader = new FtrHeader(recordInputStream);
        setConditionType(recordInputStream.readByte());
        setComparisonOperation(recordInputStream.readByte());
        int uShort = recordInputStream.readUShort();
        int uShort2 = recordInputStream.readUShort();
        int i = recordInputStream.readInt();
        this.ext_formatting_length = i;
        this.ext_formatting_data = new byte[0];
        if (i == 0) {
            recordInputStream.readUShort();
        } else {
            int formatOptions = readFormatOptions(recordInputStream);
            int i2 = this.ext_formatting_length;
            if (formatOptions < i2) {
                byte[] bArr = new byte[i2 - formatOptions];
                this.ext_formatting_data = bArr;
                recordInputStream.readFully(bArr);
            }
        }
        setFormula1(Formula.read(uShort, recordInputStream));
        setFormula2(Formula.read(uShort2, recordInputStream));
        this.formula_scale = Formula.read(recordInputStream.readUShort(), recordInputStream);
        this.ext_opts = recordInputStream.readByte();
        this.priority = recordInputStream.readUShort();
        this.template_type = recordInputStream.readUShort();
        int i3 = recordInputStream.readByte();
        this.template_param_length = i3;
        if (i3 == 0 || i3 == 16) {
            byte[] bArr2 = new byte[i3];
            this.template_params = bArr2;
            recordInputStream.readFully(bArr2);
        } else {
            logger.log(5, "CF Rule v12 template params length should be 0 or 16, found " + ((int) this.template_param_length));
            recordInputStream.readRemainder();
        }
        byte conditionType = getConditionType();
        if (conditionType == 3) {
            this.color_gradient = new ColorGradientFormatting(recordInputStream);
            return;
        }
        if (conditionType == 4) {
            this.data_bar = new DataBarFormatting(recordInputStream);
        } else if (conditionType == 5) {
            this.filter_data = recordInputStream.readRemainder();
        } else if (conditionType == 6) {
            this.multistate = new IconMultiStateFormatting(recordInputStream);
        }
    }

    public boolean containsDataBarBlock() {
        return this.data_bar != null;
    }

    public DataBarFormatting getDataBarFormatting() {
        return this.data_bar;
    }

    public DataBarFormatting createDataBarFormatting() {
        DataBarFormatting dataBarFormatting = this.data_bar;
        if (dataBarFormatting != null) {
            return dataBarFormatting;
        }
        setConditionType((byte) 4);
        DataBarFormatting dataBarFormatting2 = new DataBarFormatting();
        this.data_bar = dataBarFormatting2;
        return dataBarFormatting2;
    }

    public boolean containsMultiStateBlock() {
        return this.multistate != null;
    }

    public IconMultiStateFormatting getMultiStateFormatting() {
        return this.multistate;
    }

    public IconMultiStateFormatting createMultiStateFormatting() {
        IconMultiStateFormatting iconMultiStateFormatting = this.multistate;
        if (iconMultiStateFormatting != null) {
            return iconMultiStateFormatting;
        }
        setConditionType((byte) 6);
        IconMultiStateFormatting iconMultiStateFormatting2 = new IconMultiStateFormatting();
        this.multistate = iconMultiStateFormatting2;
        return iconMultiStateFormatting2;
    }

    public boolean containsColorGradientBlock() {
        return this.color_gradient != null;
    }

    public ColorGradientFormatting getColorGradientFormatting() {
        return this.color_gradient;
    }

    public ColorGradientFormatting createColorGradientFormatting() {
        ColorGradientFormatting colorGradientFormatting = this.color_gradient;
        if (colorGradientFormatting != null) {
            return colorGradientFormatting;
        }
        setConditionType((byte) 3);
        ColorGradientFormatting colorGradientFormatting2 = new ColorGradientFormatting();
        this.color_gradient = colorGradientFormatting2;
        return colorGradientFormatting2;
    }

    public Ptg[] getParsedExpressionScale() {
        return this.formula_scale.getTokens();
    }

    public void setParsedExpressionScale(Ptg[] ptgArr) {
        this.formula_scale = Formula.create(ptgArr);
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        this.futureHeader.serialize(littleEndianOutput);
        int formulaSize = getFormulaSize(getFormula1());
        int formulaSize2 = getFormulaSize(getFormula2());
        littleEndianOutput.writeByte(getConditionType());
        littleEndianOutput.writeByte(getComparisonOperation());
        littleEndianOutput.writeShort(formulaSize);
        littleEndianOutput.writeShort(formulaSize2);
        int i = this.ext_formatting_length;
        if (i == 0) {
            littleEndianOutput.writeInt(0);
            littleEndianOutput.writeShort(0);
        } else {
            littleEndianOutput.writeInt(i);
            serializeFormattingBlock(littleEndianOutput);
            littleEndianOutput.write(this.ext_formatting_data);
        }
        getFormula1().serializeTokens(littleEndianOutput);
        getFormula2().serializeTokens(littleEndianOutput);
        littleEndianOutput.writeShort(getFormulaSize(this.formula_scale));
        this.formula_scale.serializeTokens(littleEndianOutput);
        littleEndianOutput.writeByte(this.ext_opts);
        littleEndianOutput.writeShort(this.priority);
        littleEndianOutput.writeShort(this.template_type);
        littleEndianOutput.writeByte(this.template_param_length);
        littleEndianOutput.write(this.template_params);
        byte conditionType = getConditionType();
        if (conditionType == 3) {
            this.color_gradient.serialize(littleEndianOutput);
            return;
        }
        if (conditionType == 4) {
            this.data_bar.serialize(littleEndianOutput);
        } else if (conditionType == 5) {
            littleEndianOutput.write(this.filter_data);
        } else if (conditionType == 6) {
            this.multistate.serialize(littleEndianOutput);
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        int dataLength;
        int dataSize = FtrHeader.getDataSize() + 6;
        int formattingBlockSize = (this.ext_formatting_length == 0 ? dataSize + 6 : dataSize + getFormattingBlockSize() + 4 + this.ext_formatting_data.length) + getFormulaSize(getFormula1()) + getFormulaSize(getFormula2()) + getFormulaSize(this.formula_scale) + 2 + this.template_params.length + 6;
        byte conditionType = getConditionType();
        if (conditionType == 3) {
            dataLength = this.color_gradient.getDataLength();
        } else if (conditionType == 4) {
            dataLength = this.data_bar.getDataLength();
        } else if (conditionType == 5) {
            dataLength = this.filter_data.length;
        } else {
            if (conditionType != 6) {
                return formattingBlockSize;
            }
            dataLength = this.multistate.getDataLength();
        }
        return formattingBlockSize + dataLength;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuilder sb = new StringBuilder("[CFRULE12]\n    .condition_type=");
        sb.append((int) getConditionType()).append("\n    .dxfn12_length =0x");
        sb.append(Integer.toHexString(this.ext_formatting_length)).append("\n    .option_flags  =0x");
        sb.append(Integer.toHexString(getOptions())).append("\n");
        if (containsFontFormattingBlock()) {
            sb.append(this._fontFormatting).append("\n");
        }
        if (containsBorderFormattingBlock()) {
            sb.append(this._borderFormatting).append("\n");
        }
        if (containsPatternFormattingBlock()) {
            sb.append(this._patternFormatting).append("\n");
        }
        sb.append("    .dxfn12_ext=").append(HexDump.toHex(this.ext_formatting_data)).append("\n    .formula_1 =");
        sb.append(Arrays.toString(getFormula1().getTokens())).append("\n    .formula_2 =");
        sb.append(Arrays.toString(getFormula2().getTokens())).append("\n    .formula_S =");
        sb.append(Arrays.toString(this.formula_scale.getTokens())).append("\n    .ext_opts  =");
        sb.append((int) this.ext_opts).append("\n    .priority  =");
        sb.append(this.priority).append("\n    .template_type  =");
        sb.append(this.template_type).append("\n    .template_params=");
        sb.append(HexDump.toHex(this.template_params)).append("\n    .filter_data    =");
        sb.append(HexDump.toHex(this.filter_data)).append("\n");
        ColorGradientFormatting colorGradientFormatting = this.color_gradient;
        if (colorGradientFormatting != null) {
            sb.append(colorGradientFormatting);
        }
        IconMultiStateFormatting iconMultiStateFormatting = this.multistate;
        if (iconMultiStateFormatting != null) {
            sb.append(iconMultiStateFormatting);
        }
        DataBarFormatting dataBarFormatting = this.data_bar;
        if (dataBarFormatting != null) {
            sb.append(dataBarFormatting);
        }
        sb.append("[/CFRULE12]\n");
        return sb.toString();
    }

    @Override // org.apache.poi.hssf.record.CFRuleBase, org.apache.poi.hssf.record.Record
    public CFRule12Record clone() {
        CFRule12Record cFRule12Record = new CFRule12Record(getConditionType(), getComparisonOperation());
        cFRule12Record.futureHeader.setAssociatedRange(this.futureHeader.getAssociatedRange().copy());
        super.copyTo(cFRule12Record);
        int iMin = Math.min(this.ext_formatting_length, this.ext_formatting_data.length);
        cFRule12Record.ext_formatting_length = iMin;
        byte[] bArr = new byte[this.ext_formatting_length];
        cFRule12Record.ext_formatting_data = bArr;
        System.arraycopy(this.ext_formatting_data, 0, bArr, 0, iMin);
        cFRule12Record.formula_scale = this.formula_scale.copy();
        cFRule12Record.ext_opts = this.ext_opts;
        cFRule12Record.priority = this.priority;
        cFRule12Record.template_type = this.template_type;
        cFRule12Record.template_param_length = this.template_param_length;
        int i = this.template_param_length;
        byte[] bArr2 = new byte[i];
        cFRule12Record.template_params = bArr2;
        System.arraycopy(this.template_params, 0, bArr2, 0, i);
        ColorGradientFormatting colorGradientFormatting = this.color_gradient;
        if (colorGradientFormatting != null) {
            cFRule12Record.color_gradient = (ColorGradientFormatting) colorGradientFormatting.clone();
        }
        IconMultiStateFormatting iconMultiStateFormatting = this.multistate;
        if (iconMultiStateFormatting != null) {
            cFRule12Record.multistate = (IconMultiStateFormatting) iconMultiStateFormatting.clone();
        }
        DataBarFormatting dataBarFormatting = this.data_bar;
        if (dataBarFormatting != null) {
            cFRule12Record.data_bar = (DataBarFormatting) dataBarFormatting.clone();
        }
        byte[] bArr3 = this.filter_data;
        if (bArr3 != null) {
            byte[] bArr4 = new byte[bArr3.length];
            cFRule12Record.filter_data = bArr4;
            byte[] bArr5 = this.filter_data;
            System.arraycopy(bArr5, 0, bArr4, 0, bArr5.length);
        }
        return cFRule12Record;
    }

    @Override // org.apache.poi.hssf.record.common.FutureRecord
    public short getFutureRecordType() {
        return this.futureHeader.getRecordType();
    }

    @Override // org.apache.poi.hssf.record.common.FutureRecord
    public FtrHeader getFutureHeader() {
        return this.futureHeader;
    }

    @Override // org.apache.poi.hssf.record.common.FutureRecord
    public CellRangeAddress getAssociatedRange() {
        return this.futureHeader.getAssociatedRange();
    }
}
