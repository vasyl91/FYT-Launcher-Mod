package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CellCopyPolicy {
    public static final boolean DEFAULT_CONDENSE_ROWS_POLICY = false;
    public static final boolean DEFAULT_COPY_CELL_FORMULA_POLICY = true;
    public static final boolean DEFAULT_COPY_CELL_STYLE_POLICY = true;
    public static final boolean DEFAULT_COPY_CELL_VALUE_POLICY = true;
    public static final boolean DEFAULT_COPY_HYPERLINK_POLICY = true;
    public static final boolean DEFAULT_COPY_MERGED_REGIONS_POLICY = true;
    public static final boolean DEFAULT_COPY_ROW_HEIGHT_POLICY = true;
    public static final boolean DEFAULT_MERGE_HYPERLINK_POLICY = false;
    private boolean condenseRows;
    private boolean copyCellFormula;
    private boolean copyCellStyle;
    private boolean copyCellValue;
    private boolean copyHyperlink;
    private boolean copyMergedRegions;
    private boolean copyRowHeight;
    private boolean mergeHyperlink;

    public CellCopyPolicy() {
        this.copyCellValue = true;
        this.copyCellStyle = true;
        this.copyCellFormula = true;
        this.copyHyperlink = true;
        this.mergeHyperlink = false;
        this.copyRowHeight = true;
        this.condenseRows = false;
        this.copyMergedRegions = true;
    }

    public CellCopyPolicy(CellCopyPolicy cellCopyPolicy) {
        this.copyCellValue = true;
        this.copyCellStyle = true;
        this.copyCellFormula = true;
        this.copyHyperlink = true;
        this.mergeHyperlink = false;
        this.copyRowHeight = true;
        this.condenseRows = false;
        this.copyMergedRegions = true;
        this.copyCellValue = cellCopyPolicy.isCopyCellValue();
        this.copyCellStyle = cellCopyPolicy.isCopyCellStyle();
        this.copyCellFormula = cellCopyPolicy.isCopyCellFormula();
        this.copyHyperlink = cellCopyPolicy.isCopyHyperlink();
        this.mergeHyperlink = cellCopyPolicy.isMergeHyperlink();
        this.copyRowHeight = cellCopyPolicy.isCopyRowHeight();
        this.condenseRows = cellCopyPolicy.isCondenseRows();
        this.copyMergedRegions = cellCopyPolicy.isCopyMergedRegions();
    }

    private CellCopyPolicy(Builder builder) {
        this.copyCellValue = true;
        this.copyCellStyle = true;
        this.copyCellFormula = true;
        this.copyHyperlink = true;
        this.mergeHyperlink = false;
        this.copyRowHeight = true;
        this.condenseRows = false;
        this.copyMergedRegions = true;
        this.copyCellValue = builder.copyCellValue;
        this.copyCellStyle = builder.copyCellStyle;
        this.copyCellFormula = builder.copyCellFormula;
        this.copyHyperlink = builder.copyHyperlink;
        this.mergeHyperlink = builder.mergeHyperlink;
        this.copyRowHeight = builder.copyRowHeight;
        this.condenseRows = builder.condenseRows;
        this.copyMergedRegions = builder.copyMergedRegions;
    }

    public static class Builder {
        private boolean copyCellValue = true;
        private boolean copyCellStyle = true;
        private boolean copyCellFormula = true;
        private boolean copyHyperlink = true;
        private boolean mergeHyperlink = false;
        private boolean copyRowHeight = true;
        private boolean condenseRows = false;
        private boolean copyMergedRegions = true;

        public Builder cellValue(boolean z) {
            this.copyCellValue = z;
            return this;
        }

        public Builder cellStyle(boolean z) {
            this.copyCellStyle = z;
            return this;
        }

        public Builder cellFormula(boolean z) {
            this.copyCellFormula = z;
            return this;
        }

        public Builder copyHyperlink(boolean z) {
            this.copyHyperlink = z;
            return this;
        }

        public Builder mergeHyperlink(boolean z) {
            this.mergeHyperlink = z;
            return this;
        }

        public Builder rowHeight(boolean z) {
            this.copyRowHeight = z;
            return this;
        }

        public Builder condenseRows(boolean z) {
            this.condenseRows = z;
            return this;
        }

        public Builder mergedRegions(boolean z) {
            this.copyMergedRegions = z;
            return this;
        }

        public CellCopyPolicy build() {
            return new CellCopyPolicy(this);
        }
    }

    public Builder createBuilder() {
        return new Builder().cellValue(this.copyCellValue).cellStyle(this.copyCellStyle).cellFormula(this.copyCellFormula).copyHyperlink(this.copyHyperlink).mergeHyperlink(this.mergeHyperlink).rowHeight(this.copyRowHeight).condenseRows(this.condenseRows).mergedRegions(this.copyMergedRegions);
    }

    public boolean isCopyCellValue() {
        return this.copyCellValue;
    }

    public void setCopyCellValue(boolean z) {
        this.copyCellValue = z;
    }

    public boolean isCopyCellStyle() {
        return this.copyCellStyle;
    }

    public void setCopyCellStyle(boolean z) {
        this.copyCellStyle = z;
    }

    public boolean isCopyCellFormula() {
        return this.copyCellFormula;
    }

    public void setCopyCellFormula(boolean z) {
        this.copyCellFormula = z;
    }

    public boolean isCopyHyperlink() {
        return this.copyHyperlink;
    }

    public void setCopyHyperlink(boolean z) {
        this.copyHyperlink = z;
    }

    public boolean isMergeHyperlink() {
        return this.mergeHyperlink;
    }

    public void setMergeHyperlink(boolean z) {
        this.mergeHyperlink = z;
    }

    public boolean isCopyRowHeight() {
        return this.copyRowHeight;
    }

    public void setCopyRowHeight(boolean z) {
        this.copyRowHeight = z;
    }

    public boolean isCondenseRows() {
        return this.condenseRows;
    }

    public void setCondenseRows(boolean z) {
        this.condenseRows = z;
    }

    public boolean isCopyMergedRegions() {
        return this.copyMergedRegions;
    }

    public void setCopyMergedRegions(boolean z) {
        this.copyMergedRegions = z;
    }
}
