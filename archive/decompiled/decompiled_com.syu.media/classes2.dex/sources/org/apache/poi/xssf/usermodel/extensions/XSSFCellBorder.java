package org.apache.poi.xssf.usermodel.extensions;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.model.ThemesTable;
import org.apache.poi.xssf.usermodel.IndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorderPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STBorderStyle;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFCellBorder {
    private IndexedColorMap _indexedColorMap;
    private ThemesTable _theme;
    private CTBorder border;

    public enum BorderSide {
        TOP,
        RIGHT,
        BOTTOM,
        LEFT
    }

    public XSSFCellBorder(CTBorder cTBorder, ThemesTable themesTable, IndexedColorMap indexedColorMap) {
        this(cTBorder, indexedColorMap);
        this._theme = themesTable;
    }

    public XSSFCellBorder(CTBorder cTBorder) {
        this(cTBorder, null);
    }

    public XSSFCellBorder(CTBorder cTBorder, IndexedColorMap indexedColorMap) {
        this.border = cTBorder;
        this._indexedColorMap = indexedColorMap;
    }

    public XSSFCellBorder() {
        this.border = CTBorder.Factory.newInstance();
    }

    public void setThemesTable(ThemesTable themesTable) {
        this._theme = themesTable;
    }

    @Internal
    public CTBorder getCTBorder() {
        return this.border;
    }

    public BorderStyle getBorderStyle(BorderSide borderSide) {
        CTBorderPr border = getBorder(borderSide);
        return BorderStyle.values()[(border == null ? STBorderStyle.NONE : border.getStyle()).intValue() - 1];
    }

    public void setBorderStyle(BorderSide borderSide, BorderStyle borderStyle) {
        getBorder(borderSide, true).setStyle(STBorderStyle.Enum.forInt(borderStyle.ordinal() + 1));
    }

    public XSSFColor getBorderColor(BorderSide borderSide) {
        CTBorderPr border = getBorder(borderSide);
        if (border == null || !border.isSetColor()) {
            return null;
        }
        XSSFColor xSSFColor = new XSSFColor(border.getColor(), this._indexedColorMap);
        ThemesTable themesTable = this._theme;
        if (themesTable != null) {
            themesTable.inheritFromThemeAsRequired(xSSFColor);
        }
        return xSSFColor;
    }

    public void setBorderColor(BorderSide borderSide, XSSFColor xSSFColor) {
        CTBorderPr border = getBorder(borderSide, true);
        if (xSSFColor == null) {
            border.unsetColor();
        } else {
            border.setColor(xSSFColor.getCTColor());
        }
    }

    private CTBorderPr getBorder(BorderSide borderSide) {
        return getBorder(borderSide, false);
    }

    /* JADX INFO: renamed from: org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide;

        static {
            int[] iArr = new int[BorderSide.values().length];
            $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide = iArr;
            try {
                iArr[BorderSide.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[BorderSide.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[BorderSide.BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[BorderSide.LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private CTBorderPr getBorder(BorderSide borderSide, boolean z) {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[borderSide.ordinal()];
        if (i == 1) {
            CTBorderPr top = this.border.getTop();
            return (z && top == null) ? this.border.addNewTop() : top;
        }
        if (i == 2) {
            CTBorderPr right = this.border.getRight();
            return (z && right == null) ? this.border.addNewRight() : right;
        }
        if (i == 3) {
            CTBorderPr bottom = this.border.getBottom();
            return (z && bottom == null) ? this.border.addNewBottom() : bottom;
        }
        if (i == 4) {
            CTBorderPr left = this.border.getLeft();
            return (z && left == null) ? this.border.addNewLeft() : left;
        }
        throw new IllegalArgumentException("No suitable side specified for the border");
    }

    public int hashCode() {
        return this.border.toString().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof XSSFCellBorder) {
            return this.border.toString().equals(((XSSFCellBorder) obj).getCTBorder().toString());
        }
        return false;
    }
}
