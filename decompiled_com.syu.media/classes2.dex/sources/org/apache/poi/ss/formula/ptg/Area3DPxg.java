package org.apache.poi.ss.formula.ptg;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.SheetIdentifier;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.ss.formula.SheetRangeIdentifier;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Area3DPxg extends AreaPtgBase implements Pxg3D {
    private int externalWorkbookNumber;
    private String firstSheetName;
    private String lastSheetName;

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 1;
    }

    public Area3DPxg(int i, SheetIdentifier sheetIdentifier, String str) {
        this(i, sheetIdentifier, new AreaReference(str, SpreadsheetVersion.EXCEL2007));
    }

    public Area3DPxg(int i, SheetIdentifier sheetIdentifier, AreaReference areaReference) {
        super(areaReference);
        this.externalWorkbookNumber = i;
        this.firstSheetName = sheetIdentifier.getSheetIdentifier().getName();
        if (sheetIdentifier instanceof SheetRangeIdentifier) {
            this.lastSheetName = ((SheetRangeIdentifier) sheetIdentifier).getLastSheetIdentifier().getName();
        } else {
            this.lastSheetName = null;
        }
    }

    public Area3DPxg(SheetIdentifier sheetIdentifier, String str) {
        this(sheetIdentifier, new AreaReference(str, SpreadsheetVersion.EXCEL2007));
    }

    public Area3DPxg(SheetIdentifier sheetIdentifier, AreaReference areaReference) {
        this(-1, sheetIdentifier, areaReference);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getClass().getName());
        stringBuffer.append(" [");
        if (this.externalWorkbookNumber >= 0) {
            stringBuffer.append(" [workbook=");
            stringBuffer.append(getExternalWorkbookNumber());
            stringBuffer.append("] ");
        }
        stringBuffer.append("sheet=").append(getSheetName());
        if (this.lastSheetName != null) {
            stringBuffer.append(" : sheet=");
            stringBuffer.append(this.lastSheetName);
        }
        stringBuffer.append(" ! ");
        stringBuffer.append(formatReferenceAsString());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.ss.formula.ptg.Pxg
    public int getExternalWorkbookNumber() {
        return this.externalWorkbookNumber;
    }

    @Override // org.apache.poi.ss.formula.ptg.Pxg
    public String getSheetName() {
        return this.firstSheetName;
    }

    @Override // org.apache.poi.ss.formula.ptg.Pxg3D
    public String getLastSheetName() {
        return this.lastSheetName;
    }

    @Override // org.apache.poi.ss.formula.ptg.Pxg
    public void setSheetName(String str) {
        this.firstSheetName = str;
    }

    @Override // org.apache.poi.ss.formula.ptg.Pxg3D
    public void setLastSheetName(String str) {
        this.lastSheetName = str;
    }

    public String format2DRefAsString() {
        return formatReferenceAsString();
    }

    @Override // org.apache.poi.ss.formula.ptg.AreaPtgBase, org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.externalWorkbookNumber >= 0) {
            stringBuffer.append('[');
            stringBuffer.append(this.externalWorkbookNumber);
            stringBuffer.append(']');
        }
        SheetNameFormatter.appendFormat(stringBuffer, this.firstSheetName);
        if (this.lastSheetName != null) {
            stringBuffer.append(':');
            SheetNameFormatter.appendFormat(stringBuffer, this.lastSheetName);
        }
        stringBuffer.append('!');
        stringBuffer.append(formatReferenceAsString());
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        throw new IllegalStateException("XSSF-only Ptg, should not be serialised");
    }
}
