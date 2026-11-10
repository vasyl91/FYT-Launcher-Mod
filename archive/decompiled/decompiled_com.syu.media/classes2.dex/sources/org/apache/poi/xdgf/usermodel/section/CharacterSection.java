package org.apache.poi.xdgf.usermodel.section;

import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.microsoft.schemas.office.visio.x2012.main.SectionType;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.xdgf.usermodel.XDGFCell;
import org.apache.poi.xdgf.usermodel.XDGFSheet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CharacterSection extends XDGFSection {
    Map<String, XDGFCell> _characterCells;
    Color _fontColor;
    Double _fontSize;

    @Override // org.apache.poi.xdgf.usermodel.section.XDGFSection
    public void setupMaster(XDGFSection xDGFSection) {
    }

    public CharacterSection(SectionType sectionType, XDGFSheet xDGFSheet) {
        super(sectionType, xDGFSheet);
        this._fontSize = null;
        this._fontColor = null;
        this._characterCells = new HashMap();
        for (CellType cellType : sectionType.getRowArray(0).getCellArray()) {
            this._characterCells.put(cellType.getN(), new XDGFCell(cellType));
        }
        this._fontSize = XDGFCell.maybeGetDouble(this._characterCells, "Size");
        String strMaybeGetString = XDGFCell.maybeGetString(this._characterCells, "Color");
        if (strMaybeGetString != null) {
            this._fontColor = Color.decode(strMaybeGetString);
        }
    }

    public Double getFontSize() {
        return this._fontSize;
    }

    public Color getFontColor() {
        return this._fontColor;
    }
}
