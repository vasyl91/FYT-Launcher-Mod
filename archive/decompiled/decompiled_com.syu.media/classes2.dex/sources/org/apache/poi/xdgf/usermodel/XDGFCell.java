package org.apache.poi.xdgf.usermodel;

import com.microsoft.schemas.office.visio.x2012.main.CellType;
import java.util.Map;
import org.apache.poi.POIXMLException;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XDGFCell {
    CellType _cell;

    public static Boolean maybeGetBoolean(Map<String, XDGFCell> map, String str) {
        XDGFCell xDGFCell = map.get(str);
        if (xDGFCell == null) {
            return null;
        }
        if (xDGFCell.getValue().equals("0")) {
            return false;
        }
        if (xDGFCell.getValue().equals("1")) {
            return true;
        }
        throw new POIXMLException("Invalid boolean value for '" + xDGFCell.getName() + "'");
    }

    public static Double maybeGetDouble(Map<String, XDGFCell> map, String str) {
        XDGFCell xDGFCell = map.get(str);
        if (xDGFCell != null) {
            return parseDoubleValue(xDGFCell._cell);
        }
        return null;
    }

    public static Integer maybeGetInteger(Map<String, XDGFCell> map, String str) {
        XDGFCell xDGFCell = map.get(str);
        if (xDGFCell != null) {
            return parseIntegerValue(xDGFCell._cell);
        }
        return null;
    }

    public static String maybeGetString(Map<String, XDGFCell> map, String str) {
        XDGFCell xDGFCell = map.get(str);
        if (xDGFCell == null) {
            return null;
        }
        String v = xDGFCell._cell.getV();
        if (v.equals("Themed")) {
            return null;
        }
        return v;
    }

    public static Double parseDoubleValue(CellType cellType) {
        try {
            return Double.valueOf(Double.parseDouble(cellType.getV()));
        } catch (NumberFormatException e) {
            if (cellType.getV().equals("Themed")) {
                return null;
            }
            throw new POIXMLException("Invalid float value for '" + cellType.getN() + "': " + e);
        }
    }

    public static Integer parseIntegerValue(CellType cellType) {
        try {
            return Integer.valueOf(Integer.parseInt(cellType.getV()));
        } catch (NumberFormatException e) {
            if (cellType.getV().equals("Themed")) {
                return null;
            }
            throw new POIXMLException("Invalid integer value for '" + cellType.getN() + "': " + e);
        }
    }

    public static Double parseVLength(CellType cellType) {
        try {
            return Double.valueOf(Double.parseDouble(cellType.getV()));
        } catch (NumberFormatException e) {
            if (cellType.getV().equals("Themed")) {
                return null;
            }
            throw new POIXMLException("Invalid float value for '" + cellType.getN() + "': " + e);
        }
    }

    public XDGFCell(CellType cellType) {
        this._cell = cellType;
    }

    @Internal
    protected CellType getXmlObject() {
        return this._cell;
    }

    public String getName() {
        return this._cell.getN();
    }

    public String getValue() {
        return this._cell.getV();
    }

    public String getFormula() {
        return this._cell.getF();
    }

    public String getError() {
        return this._cell.getE();
    }
}
