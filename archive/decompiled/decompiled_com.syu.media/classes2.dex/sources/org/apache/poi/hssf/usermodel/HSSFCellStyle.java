package org.apache.poi.hssf.usermodel;

import java.util.List;
import kotlin.jvm.internal.ShortCompanionObject;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.ExtendedFormatRecord;
import org.apache.poi.hssf.record.FontRecord;
import org.apache.poi.hssf.record.FormatRecord;
import org.apache.poi.hssf.record.StyleRecord;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class HSSFCellStyle implements CellStyle {
    private final ExtendedFormatRecord _format;
    private final short _index;
    private final InternalWorkbook _workbook;
    private static final ThreadLocal<Short> lastDateFormat = new ThreadLocal<Short>() { // from class: org.apache.poi.hssf.usermodel.HSSFCellStyle.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Short initialValue() {
            return Short.valueOf(ShortCompanionObject.MIN_VALUE);
        }
    };
    private static final ThreadLocal<List<FormatRecord>> lastFormats = new ThreadLocal<>();
    private static final ThreadLocal<String> getDataFormatStringCache = new ThreadLocal<>();

    protected HSSFCellStyle(short s, ExtendedFormatRecord extendedFormatRecord, HSSFWorkbook hSSFWorkbook) {
        this(s, extendedFormatRecord, hSSFWorkbook.getWorkbook());
    }

    protected HSSFCellStyle(short s, ExtendedFormatRecord extendedFormatRecord, InternalWorkbook internalWorkbook) {
        this._workbook = internalWorkbook;
        this._index = s;
        this._format = extendedFormatRecord;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getIndex() {
        return this._index;
    }

    public HSSFCellStyle getParentStyle() {
        short parentIndex = this._format.getParentIndex();
        if (parentIndex == 0 || parentIndex == 4095) {
            return null;
        }
        return new HSSFCellStyle(parentIndex, this._workbook.getExFormatAt(parentIndex), this._workbook);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setDataFormat(short s) {
        this._format.setFormatIndex(s);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getDataFormat() {
        return this._format.getFormatIndex();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public String getDataFormatString() {
        ThreadLocal<String> threadLocal = getDataFormatStringCache;
        if (threadLocal.get() != null && lastDateFormat.get().shortValue() == getDataFormat() && this._workbook.getFormats().equals(lastFormats.get())) {
            return threadLocal.get();
        }
        lastFormats.set(this._workbook.getFormats());
        lastDateFormat.set(Short.valueOf(getDataFormat()));
        threadLocal.set(getDataFormatString(this._workbook));
        return threadLocal.get();
    }

    public String getDataFormatString(Workbook workbook) {
        return getDataFormat() == -1 ? "General" : new HSSFDataFormat(((HSSFWorkbook) workbook).getWorkbook()).getFormat(getDataFormat());
    }

    public String getDataFormatString(InternalWorkbook internalWorkbook) {
        return new HSSFDataFormat(internalWorkbook).getFormat(getDataFormat());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setFont(Font font) {
        setFont((HSSFFont) font);
    }

    public void setFont(HSSFFont hSSFFont) {
        this._format.setIndentNotParentFont(true);
        this._format.setFontIndex(hSSFFont.getIndex());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getFontIndex() {
        return this._format.getFontIndex();
    }

    public HSSFFont getFont(Workbook workbook) {
        return ((HSSFWorkbook) workbook).getFontAt(getFontIndex());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setHidden(boolean z) {
        this._format.setIndentNotParentCellOptions(true);
        this._format.setHidden(z);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public boolean getHidden() {
        return this._format.isHidden();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setLocked(boolean z) {
        this._format.setIndentNotParentCellOptions(true);
        this._format.setLocked(z);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public boolean getLocked() {
        return this._format.isLocked();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setQuotePrefixed(boolean z) {
        this._format.set123Prefix(z);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public boolean getQuotePrefixed() {
        return this._format.get123Prefix();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setAlignment(HorizontalAlignment horizontalAlignment) {
        this._format.setIndentNotParentAlignment(true);
        this._format.setAlignment(horizontalAlignment.getCode());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    @Deprecated
    public short getAlignment() {
        return this._format.getAlignment();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public HorizontalAlignment getAlignmentEnum() {
        return HorizontalAlignment.forInt(this._format.getAlignment());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setWrapText(boolean z) {
        this._format.setIndentNotParentAlignment(true);
        this._format.setWrapText(z);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public boolean getWrapText() {
        return this._format.getWrapText();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setVerticalAlignment(VerticalAlignment verticalAlignment) {
        this._format.setVerticalAlignment(verticalAlignment.getCode());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    @Deprecated
    public short getVerticalAlignment() {
        return this._format.getVerticalAlignment();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public VerticalAlignment getVerticalAlignmentEnum() {
        return VerticalAlignment.forInt(this._format.getVerticalAlignment());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setRotation(short s) {
        if (s != 255) {
            if (s < 0 && s >= -90) {
                s = (short) (90 - s);
            } else if ((s <= 90 || s > 180) && (s < -90 || s > 90)) {
                throw new IllegalArgumentException("The rotation must be between -90 and 90 degrees, or 0xff");
            }
        }
        this._format.setRotation(s);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getRotation() {
        short rotation = this._format.getRotation();
        return (rotation != 255 && rotation > 90) ? (short) (90 - rotation) : rotation;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setIndention(short s) {
        this._format.setIndent(s);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getIndention() {
        return this._format.getIndent();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setBorderLeft(BorderStyle borderStyle) {
        this._format.setIndentNotParentBorder(true);
        this._format.setBorderLeft(borderStyle.getCode());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    @Deprecated
    public short getBorderLeft() {
        return this._format.getBorderLeft();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public BorderStyle getBorderLeftEnum() {
        return BorderStyle.valueOf(this._format.getBorderLeft());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setBorderRight(BorderStyle borderStyle) {
        this._format.setIndentNotParentBorder(true);
        this._format.setBorderRight(borderStyle.getCode());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    @Deprecated
    public short getBorderRight() {
        return this._format.getBorderRight();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public BorderStyle getBorderRightEnum() {
        return BorderStyle.valueOf(this._format.getBorderRight());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setBorderTop(BorderStyle borderStyle) {
        this._format.setIndentNotParentBorder(true);
        this._format.setBorderTop(borderStyle.getCode());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    @Deprecated
    public short getBorderTop() {
        return this._format.getBorderTop();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public BorderStyle getBorderTopEnum() {
        return BorderStyle.valueOf(this._format.getBorderTop());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setBorderBottom(BorderStyle borderStyle) {
        this._format.setIndentNotParentBorder(true);
        this._format.setBorderBottom(borderStyle.getCode());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    @Deprecated
    public short getBorderBottom() {
        return this._format.getBorderBottom();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public BorderStyle getBorderBottomEnum() {
        return BorderStyle.valueOf(this._format.getBorderBottom());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setLeftBorderColor(short s) {
        this._format.setLeftBorderPaletteIdx(s);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getLeftBorderColor() {
        return this._format.getLeftBorderPaletteIdx();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setRightBorderColor(short s) {
        this._format.setRightBorderPaletteIdx(s);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getRightBorderColor() {
        return this._format.getRightBorderPaletteIdx();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setTopBorderColor(short s) {
        this._format.setTopBorderPaletteIdx(s);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getTopBorderColor() {
        return this._format.getTopBorderPaletteIdx();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setBottomBorderColor(short s) {
        this._format.setBottomBorderPaletteIdx(s);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getBottomBorderColor() {
        return this._format.getBottomBorderPaletteIdx();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setFillPattern(FillPatternType fillPatternType) {
        this._format.setAdtlFillPattern(fillPatternType.getCode());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    @Deprecated
    public short getFillPattern() {
        return getFillPatternEnum().getCode();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public FillPatternType getFillPatternEnum() {
        return FillPatternType.forInt(this._format.getAdtlFillPattern());
    }

    private void checkDefaultBackgroundFills() {
        short index = HSSFColor.HSSFColorPredefined.AUTOMATIC.getIndex();
        if (this._format.getFillForeground() == index) {
            int i = index + 1;
            if (this._format.getFillBackground() != i) {
                setFillBackgroundColor((short) i);
                return;
            }
            return;
        }
        if (this._format.getFillBackground() != index + 1 || this._format.getFillForeground() == index) {
            return;
        }
        setFillBackgroundColor(index);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setFillBackgroundColor(short s) {
        this._format.setFillBackground(s);
        checkDefaultBackgroundFills();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getFillBackgroundColor() {
        short index = HSSFColor.HSSFColorPredefined.AUTOMATIC.getIndex();
        short fillBackground = this._format.getFillBackground();
        return fillBackground == index + 1 ? index : fillBackground;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public HSSFColor getFillBackgroundColorColor() {
        return new HSSFPalette(this._workbook.getCustomPalette()).getColor(getFillBackgroundColor());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setFillForegroundColor(short s) {
        this._format.setFillForeground(s);
        checkDefaultBackgroundFills();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getFillForegroundColor() {
        return this._format.getFillForeground();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public HSSFColor getFillForegroundColorColor() {
        return new HSSFPalette(this._workbook.getCustomPalette()).getColor(getFillForegroundColor());
    }

    public String getUserStyleName() {
        StyleRecord styleRecord = this._workbook.getStyleRecord(this._index);
        if (styleRecord == null || styleRecord.isBuiltin()) {
            return null;
        }
        return styleRecord.getName();
    }

    public void setUserStyleName(String str) {
        StyleRecord styleRecord = this._workbook.getStyleRecord(this._index);
        if (styleRecord == null) {
            styleRecord = this._workbook.createStyleRecord(this._index);
        }
        if (styleRecord.isBuiltin() && this._index <= 20) {
            throw new IllegalArgumentException("Unable to set user specified style names for built in styles!");
        }
        styleRecord.setName(str);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setShrinkToFit(boolean z) {
        this._format.setShrinkToFit(z);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public boolean getShrinkToFit() {
        return this._format.getShrinkToFit();
    }

    public short getReadingOrder() {
        return this._format.getReadingOrder();
    }

    public void setReadingOrder(short s) {
        this._format.setReadingOrder(s);
    }

    public void verifyBelongsToWorkbook(HSSFWorkbook hSSFWorkbook) {
        if (hSSFWorkbook.getWorkbook() != this._workbook) {
            throw new IllegalArgumentException("This Style does not belong to the supplied Workbook. Are you trying to assign a style from one workbook to the cell of a differnt workbook?");
        }
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void cloneStyleFrom(CellStyle cellStyle) {
        if (cellStyle instanceof HSSFCellStyle) {
            cloneStyleFrom((HSSFCellStyle) cellStyle);
            return;
        }
        throw new IllegalArgumentException("Can only clone from one HSSFCellStyle to another, not between HSSFCellStyle and XSSFCellStyle");
    }

    public void cloneStyleFrom(HSSFCellStyle hSSFCellStyle) {
        this._format.cloneStyleFrom(hSSFCellStyle._format);
        if (this._workbook != hSSFCellStyle._workbook) {
            lastDateFormat.set(Short.valueOf(ShortCompanionObject.MIN_VALUE));
            lastFormats.set(null);
            getDataFormatStringCache.set(null);
            setDataFormat((short) this._workbook.createFormat(hSSFCellStyle.getDataFormatString()));
            FontRecord fontRecordCreateNewFont = this._workbook.createNewFont();
            fontRecordCreateNewFont.cloneStyleFrom(hSSFCellStyle._workbook.getFontRecordAt(hSSFCellStyle.getFontIndex()));
            setFont(new HSSFFont((short) this._workbook.getFontIndex(fontRecordCreateNewFont), fontRecordCreateNewFont));
        }
    }

    public int hashCode() {
        ExtendedFormatRecord extendedFormatRecord = this._format;
        return (((extendedFormatRecord == null ? 0 : extendedFormatRecord.hashCode()) + 31) * 31) + this._index;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof HSSFCellStyle)) {
            return false;
        }
        HSSFCellStyle hSSFCellStyle = (HSSFCellStyle) obj;
        ExtendedFormatRecord extendedFormatRecord = this._format;
        if (extendedFormatRecord == null) {
            if (hSSFCellStyle._format != null) {
                return false;
            }
        } else if (!extendedFormatRecord.equals(hSSFCellStyle._format)) {
            return false;
        }
        return this._index == hSSFCellStyle._index;
    }
}
