package org.apache.poi.xdgf.usermodel;

import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.microsoft.schemas.office.visio.x2012.main.SectionType;
import com.microsoft.schemas.office.visio.x2012.main.SheetType;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.poi.POIXMLException;
import org.apache.poi.xdgf.exceptions.XDGFException;
import org.apache.poi.xdgf.usermodel.section.CharacterSection;
import org.apache.poi.xdgf.usermodel.section.GeometrySection;
import org.apache.poi.xdgf.usermodel.section.XDGFSection;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class XDGFSheet {
    protected CharacterSection _character;
    protected XDGFDocument _document;
    protected SheetType _sheet;
    protected Map<String, XDGFCell> _cells = new HashMap();
    protected Map<String, XDGFSection> _sections = new HashMap();
    protected SortedMap<Long, GeometrySection> _geometry = new TreeMap();

    /* JADX INFO: renamed from: getXmlObject */
    abstract SheetType mo1575getXmlObject();

    public XDGFSheet(SheetType sheetType, XDGFDocument xDGFDocument) {
        this._character = null;
        try {
            this._sheet = sheetType;
            this._document = xDGFDocument;
            for (CellType cellType : sheetType.getCellArray()) {
                if (this._cells.containsKey(cellType.getN())) {
                    throw new POIXMLException("Unexpected duplicate cell " + cellType.getN());
                }
                this._cells.put(cellType.getN(), new XDGFCell(cellType));
            }
            for (SectionType sectionType : sheetType.getSectionArray()) {
                String n = sectionType.getN();
                if (n.equals("Geometry")) {
                    this._geometry.put(Long.valueOf(sectionType.getIX()), new GeometrySection(sectionType, this));
                } else if (n.equals("Character")) {
                    this._character = new CharacterSection(sectionType, this);
                } else {
                    this._sections.put(n, XDGFSection.load(sectionType, this));
                }
            }
        } catch (POIXMLException e) {
            throw XDGFException.wrap(toString(), e);
        }
    }

    public XDGFDocument getDocument() {
        return this._document;
    }

    public XDGFCell getCell(String str) {
        return this._cells.get(str);
    }

    public XDGFSection getSection(String str) {
        return this._sections.get(str);
    }

    public XDGFStyleSheet getLineStyle() {
        if (this._sheet.isSetLineStyle()) {
            return this._document.getStyleById(this._sheet.getLineStyle());
        }
        return null;
    }

    public XDGFStyleSheet getFillStyle() {
        if (this._sheet.isSetFillStyle()) {
            return this._document.getStyleById(this._sheet.getFillStyle());
        }
        return null;
    }

    public XDGFStyleSheet getTextStyle() {
        if (this._sheet.isSetTextStyle()) {
            return this._document.getStyleById(this._sheet.getTextStyle());
        }
        return null;
    }

    public Color getFontColor() {
        Color fontColor;
        CharacterSection characterSection = this._character;
        if (characterSection != null && (fontColor = characterSection.getFontColor()) != null) {
            return fontColor;
        }
        XDGFStyleSheet textStyle = getTextStyle();
        if (textStyle != null) {
            return textStyle.getFontColor();
        }
        return null;
    }

    public Double getFontSize() {
        Double fontSize;
        CharacterSection characterSection = this._character;
        if (characterSection != null && (fontSize = characterSection.getFontSize()) != null) {
            return fontSize;
        }
        XDGFStyleSheet textStyle = getTextStyle();
        if (textStyle != null) {
            return textStyle.getFontSize();
        }
        return null;
    }

    public Integer getLineCap() {
        Integer numMaybeGetInteger = XDGFCell.maybeGetInteger(this._cells, "LineCap");
        if (numMaybeGetInteger != null) {
            return numMaybeGetInteger;
        }
        XDGFStyleSheet lineStyle = getLineStyle();
        if (lineStyle != null) {
            return lineStyle.getLineCap();
        }
        return null;
    }

    public Color getLineColor() {
        String strMaybeGetString = XDGFCell.maybeGetString(this._cells, "LineColor");
        if (strMaybeGetString != null) {
            return Color.decode(strMaybeGetString);
        }
        XDGFStyleSheet lineStyle = getLineStyle();
        if (lineStyle != null) {
            return lineStyle.getLineColor();
        }
        return null;
    }

    public Integer getLinePattern() {
        Integer numMaybeGetInteger = XDGFCell.maybeGetInteger(this._cells, "LinePattern");
        if (numMaybeGetInteger != null) {
            return numMaybeGetInteger;
        }
        XDGFStyleSheet lineStyle = getLineStyle();
        if (lineStyle != null) {
            return lineStyle.getLinePattern();
        }
        return null;
    }

    public Double getLineWeight() {
        Double dMaybeGetDouble = XDGFCell.maybeGetDouble(this._cells, "LineWeight");
        if (dMaybeGetDouble != null) {
            return dMaybeGetDouble;
        }
        XDGFStyleSheet lineStyle = getLineStyle();
        if (lineStyle != null) {
            return lineStyle.getLineWeight();
        }
        return null;
    }
}
