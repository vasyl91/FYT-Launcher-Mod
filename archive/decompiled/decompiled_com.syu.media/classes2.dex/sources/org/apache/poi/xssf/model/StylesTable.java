package org.apache.poi.xssf.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import module.canbus.FinalCanbus;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.FontFamily;
import org.apache.poi.ss.usermodel.FontScheme;
import org.apache.poi.ss.usermodel.TableStyle;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.CustomIndexedColorMap;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;
import org.apache.poi.xssf.usermodel.IndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFBuiltinTableStyle;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.poi.xssf.usermodel.XSSFTableStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellFill;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorders;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyleXfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellXfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFills;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPatternType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.StyleSheetDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class StylesTable extends POIXMLDocumentPart {
    public static final int FIRST_CUSTOM_STYLE_ID = 165;
    private static final short FIRST_USER_DEFINED_NUMBER_FORMAT_ID = 164;
    private static final int MAXIMUM_STYLE_ID = SpreadsheetVersion.EXCEL2007.getMaxCellStyles();
    private int MAXIMUM_NUMBER_OF_DATA_FORMATS;
    private final List<XSSFCellBorder> borders;
    private StyleSheetDocument doc;
    private final List<CTDxf> dxfs;
    private final List<XSSFCellFill> fills;
    private final List<XSSFFont> fonts;
    private IndexedColorMap indexedColors;
    private final SortedMap<Short, String> numberFormats;
    private final List<CTXf> styleXfs;
    private final Map<String, TableStyle> tableStyles;
    private ThemesTable theme;
    private XSSFWorkbook workbook;
    private final List<CTXf> xfs;

    public void setMaxNumberOfDataFormats(int i) {
        if (i >= getNumDataFormats()) {
            this.MAXIMUM_NUMBER_OF_DATA_FORMATS = i;
        } else {
            if (i < 0) {
                throw new IllegalArgumentException("Maximum Number of Data Formats must be greater than or equal to 0");
            }
            throw new IllegalStateException("Cannot set the maximum number of data formats less than the current quantity.Data formats must be explicitly removed (via StylesTable.removeNumberFormat) before the limit can be decreased.");
        }
    }

    public int getMaxNumberOfDataFormats() {
        return this.MAXIMUM_NUMBER_OF_DATA_FORMATS;
    }

    public StylesTable() {
        this.numberFormats = new TreeMap();
        this.fonts = new ArrayList();
        this.fills = new ArrayList();
        this.borders = new ArrayList();
        this.styleXfs = new ArrayList();
        this.xfs = new ArrayList();
        this.dxfs = new ArrayList();
        this.tableStyles = new HashMap();
        this.indexedColors = new DefaultIndexedColorMap();
        this.MAXIMUM_NUMBER_OF_DATA_FORMATS = FinalCanbus.CAR_FYT_XP1_FengShenAX7;
        StyleSheetDocument styleSheetDocumentNewInstance = StyleSheetDocument.Factory.newInstance();
        this.doc = styleSheetDocumentNewInstance;
        styleSheetDocumentNewInstance.addNewStyleSheet();
        initialize();
    }

    public StylesTable(PackagePart packagePart) throws IOException {
        super(packagePart);
        this.numberFormats = new TreeMap();
        this.fonts = new ArrayList();
        this.fills = new ArrayList();
        this.borders = new ArrayList();
        this.styleXfs = new ArrayList();
        this.xfs = new ArrayList();
        this.dxfs = new ArrayList();
        this.tableStyles = new HashMap();
        this.indexedColors = new DefaultIndexedColorMap();
        this.MAXIMUM_NUMBER_OF_DATA_FORMATS = FinalCanbus.CAR_FYT_XP1_FengShenAX7;
        readFrom(packagePart.getInputStream());
    }

    public void setWorkbook(XSSFWorkbook xSSFWorkbook) {
        this.workbook = xSSFWorkbook;
    }

    public ThemesTable getTheme() {
        return this.theme;
    }

    public void setTheme(ThemesTable themesTable) {
        this.theme = themesTable;
        if (themesTable != null) {
            themesTable.setColorMap(getIndexedColors());
        }
        Iterator<XSSFFont> it = this.fonts.iterator();
        while (it.hasNext()) {
            it.next().setThemesTable(themesTable);
        }
        Iterator<XSSFCellBorder> it2 = this.borders.iterator();
        while (it2.hasNext()) {
            it2.next().setThemesTable(themesTable);
        }
    }

    public void ensureThemesTable() {
        if (this.theme != null) {
            return;
        }
        setTheme((ThemesTable) this.workbook.createRelationship(XSSFRelation.THEME, XSSFFactory.getInstance()));
    }

    public void readFrom(InputStream inputStream) throws IOException {
        try {
            StyleSheetDocument styleSheetDocument = StyleSheetDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
            this.doc = styleSheetDocument;
            CTStylesheet styleSheet = styleSheetDocument.getStyleSheet();
            CustomIndexedColorMap customIndexedColorMapFromColors = CustomIndexedColorMap.fromColors(styleSheet.getColors());
            if (customIndexedColorMapFromColors != null) {
                this.indexedColors = customIndexedColorMapFromColors;
            }
            CTNumFmts numFmts = styleSheet.getNumFmts();
            int i = 0;
            if (numFmts != null) {
                for (CTNumFmt cTNumFmt : numFmts.getNumFmtArray()) {
                    this.numberFormats.put(Short.valueOf((short) cTNumFmt.getNumFmtId()), cTNumFmt.getFormatCode());
                }
            }
            CTFonts fonts = styleSheet.getFonts();
            if (fonts != null) {
                int i2 = 0;
                for (CTFont cTFont : fonts.getFontArray()) {
                    this.fonts.add(new XSSFFont(cTFont, i2, this.indexedColors));
                    i2++;
                }
            }
            CTFills fills = styleSheet.getFills();
            if (fills != null) {
                for (CTFill cTFill : fills.getFillArray()) {
                    this.fills.add(new XSSFCellFill(cTFill, this.indexedColors));
                }
            }
            CTBorders borders = styleSheet.getBorders();
            if (borders != null) {
                for (CTBorder cTBorder : borders.getBorderArray()) {
                    this.borders.add(new XSSFCellBorder(cTBorder, this.indexedColors));
                }
            }
            CTCellXfs cellXfs = styleSheet.getCellXfs();
            if (cellXfs != null) {
                this.xfs.addAll(Arrays.asList(cellXfs.getXfArray()));
            }
            CTCellStyleXfs cellStyleXfs = styleSheet.getCellStyleXfs();
            if (cellStyleXfs != null) {
                this.styleXfs.addAll(Arrays.asList(cellStyleXfs.getXfArray()));
            }
            CTDxfs dxfs = styleSheet.getDxfs();
            if (dxfs != null) {
                this.dxfs.addAll(Arrays.asList(dxfs.getDxfArray()));
            }
            CTTableStyles tableStyles = styleSheet.getTableStyles();
            if (tableStyles != null) {
                for (CTTableStyle cTTableStyle : Arrays.asList(tableStyles.getTableStyleArray())) {
                    this.tableStyles.put(cTTableStyle.getName(), new XSSFTableStyle(i, dxfs, cTTableStyle, this.indexedColors));
                    i++;
                }
            }
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public String getNumberFormatAt(short s) {
        return this.numberFormats.get(Short.valueOf(s));
    }

    private short getNumberFormatId(String str) {
        for (Map.Entry<Short, String> entry : this.numberFormats.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey().shortValue();
            }
        }
        throw new IllegalStateException("Number format not in style table: " + str);
    }

    public int putNumberFormat(String str) {
        if (this.numberFormats.containsValue(str)) {
            try {
                return getNumberFormatId(str);
            } catch (IllegalStateException unused) {
                throw new IllegalStateException("Found the format, but couldn't figure out where - should never happen!");
            }
        }
        if (this.numberFormats.size() >= this.MAXIMUM_NUMBER_OF_DATA_FORMATS) {
            throw new IllegalStateException("The maximum number of Data Formats was exceeded. You can define up to " + this.MAXIMUM_NUMBER_OF_DATA_FORMATS + " formats in a .xlsx Workbook.");
        }
        short sMax = 164;
        if (!this.numberFormats.isEmpty()) {
            short sShortValue = (short) (this.numberFormats.lastKey().shortValue() + 1);
            if (sShortValue < 0) {
                throw new IllegalStateException("Cowardly avoiding creating a number format with a negative id.This is probably due to arithmetic overflow.");
            }
            sMax = (short) Math.max((int) sShortValue, 164);
        }
        this.numberFormats.put(Short.valueOf(sMax), str);
        return sMax;
    }

    public void putNumberFormat(short s, String str) {
        this.numberFormats.put(Short.valueOf(s), str);
    }

    public boolean removeNumberFormat(short s) {
        boolean z = this.numberFormats.remove(Short.valueOf(s)) != null;
        if (z) {
            for (CTXf cTXf : this.xfs) {
                if (cTXf.isSetNumFmtId() && cTXf.getNumFmtId() == s) {
                    cTXf.unsetApplyNumberFormat();
                    cTXf.unsetNumFmtId();
                }
            }
        }
        return z;
    }

    public boolean removeNumberFormat(String str) {
        return removeNumberFormat(getNumberFormatId(str));
    }

    public XSSFFont getFontAt(int i) {
        return this.fonts.get(i);
    }

    public int putFont(XSSFFont xSSFFont, boolean z) {
        int iIndexOf = !z ? this.fonts.indexOf(xSSFFont) : -1;
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        int size = this.fonts.size();
        this.fonts.add(xSSFFont);
        return size;
    }

    public int putFont(XSSFFont xSSFFont) {
        return putFont(xSSFFont, false);
    }

    public XSSFCellStyle getStyleAt(int i) {
        if (i < 0 || i >= this.xfs.size()) {
            return null;
        }
        return new XSSFCellStyle(i, this.xfs.get(i).getXfId() > 0 ? (int) this.xfs.get(i).getXfId() : 0, this, this.theme);
    }

    public int putStyle(XSSFCellStyle xSSFCellStyle) {
        CTXf coreXf = xSSFCellStyle.getCoreXf();
        if (!this.xfs.contains(coreXf)) {
            this.xfs.add(coreXf);
        }
        return this.xfs.indexOf(coreXf);
    }

    public XSSFCellBorder getBorderAt(int i) {
        return this.borders.get(i);
    }

    public int putBorder(XSSFCellBorder xSSFCellBorder) {
        int iIndexOf = this.borders.indexOf(xSSFCellBorder);
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        this.borders.add(xSSFCellBorder);
        xSSFCellBorder.setThemesTable(this.theme);
        return this.borders.size() - 1;
    }

    public XSSFCellFill getFillAt(int i) {
        return this.fills.get(i);
    }

    public List<XSSFCellBorder> getBorders() {
        return Collections.unmodifiableList(this.borders);
    }

    public List<XSSFCellFill> getFills() {
        return Collections.unmodifiableList(this.fills);
    }

    public List<XSSFFont> getFonts() {
        return Collections.unmodifiableList(this.fonts);
    }

    public Map<Short, String> getNumberFormats() {
        return Collections.unmodifiableMap(this.numberFormats);
    }

    public int putFill(XSSFCellFill xSSFCellFill) {
        int iIndexOf = this.fills.indexOf(xSSFCellFill);
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        this.fills.add(xSSFCellFill);
        return this.fills.size() - 1;
    }

    @Internal
    public CTXf getCellXfAt(int i) {
        return this.xfs.get(i);
    }

    @Internal
    public int putCellXf(CTXf cTXf) {
        this.xfs.add(cTXf);
        return this.xfs.size();
    }

    @Internal
    public void replaceCellXfAt(int i, CTXf cTXf) {
        this.xfs.set(i, cTXf);
    }

    @Internal
    public CTXf getCellStyleXfAt(int i) {
        try {
            return this.styleXfs.get(i);
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    @Internal
    public int putCellStyleXf(CTXf cTXf) {
        this.styleXfs.add(cTXf);
        return this.styleXfs.size();
    }

    @Internal
    protected void replaceCellStyleXfAt(int i, CTXf cTXf) {
        this.styleXfs.set(i, cTXf);
    }

    public int getNumCellStyles() {
        return this.xfs.size();
    }

    public int getNumDataFormats() {
        return this.numberFormats.size();
    }

    @Internal
    int _getXfsSize() {
        return this.xfs.size();
    }

    @Internal
    public int _getStyleXfsSize() {
        return this.styleXfs.size();
    }

    @Internal
    public CTStylesheet getCTStylesheet() {
        return this.doc.getStyleSheet();
    }

    @Internal
    public int _getDXfsSize() {
        return this.dxfs.size();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        CTStylesheet styleSheet = this.doc.getStyleSheet();
        CTNumFmts cTNumFmtsNewInstance = CTNumFmts.Factory.newInstance();
        cTNumFmtsNewInstance.setCount(this.numberFormats.size());
        for (Map.Entry<Short, String> entry : this.numberFormats.entrySet()) {
            CTNumFmt cTNumFmtAddNewNumFmt = cTNumFmtsNewInstance.addNewNumFmt();
            cTNumFmtAddNewNumFmt.setNumFmtId(entry.getKey().shortValue());
            cTNumFmtAddNewNumFmt.setFormatCode(entry.getValue());
        }
        styleSheet.setNumFmts(cTNumFmtsNewInstance);
        CTFonts fonts = styleSheet.getFonts();
        if (fonts == null) {
            fonts = CTFonts.Factory.newInstance();
        }
        fonts.setCount(this.fonts.size());
        CTFont[] cTFontArr = new CTFont[this.fonts.size()];
        Iterator<XSSFFont> it = this.fonts.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            cTFontArr[i2] = it.next().getCTFont();
            i2++;
        }
        fonts.setFontArray(cTFontArr);
        styleSheet.setFonts(fonts);
        CTFills fills = styleSheet.getFills();
        if (fills == null) {
            fills = CTFills.Factory.newInstance();
        }
        fills.setCount(this.fills.size());
        CTFill[] cTFillArr = new CTFill[this.fills.size()];
        Iterator<XSSFCellFill> it2 = this.fills.iterator();
        int i3 = 0;
        while (it2.hasNext()) {
            cTFillArr[i3] = it2.next().getCTFill();
            i3++;
        }
        fills.setFillArray(cTFillArr);
        styleSheet.setFills(fills);
        CTBorders borders = styleSheet.getBorders();
        if (borders == null) {
            borders = CTBorders.Factory.newInstance();
        }
        borders.setCount(this.borders.size());
        CTBorder[] cTBorderArr = new CTBorder[this.borders.size()];
        Iterator<XSSFCellBorder> it3 = this.borders.iterator();
        while (it3.hasNext()) {
            cTBorderArr[i] = it3.next().getCTBorder();
            i++;
        }
        borders.setBorderArray(cTBorderArr);
        styleSheet.setBorders(borders);
        if (this.xfs.size() > 0) {
            CTCellXfs cellXfs = styleSheet.getCellXfs();
            if (cellXfs == null) {
                cellXfs = CTCellXfs.Factory.newInstance();
            }
            cellXfs.setCount(this.xfs.size());
            List<CTXf> list = this.xfs;
            cellXfs.setXfArray((CTXf[]) list.toArray(new CTXf[list.size()]));
            styleSheet.setCellXfs(cellXfs);
        }
        if (this.styleXfs.size() > 0) {
            CTCellStyleXfs cellStyleXfs = styleSheet.getCellStyleXfs();
            if (cellStyleXfs == null) {
                cellStyleXfs = CTCellStyleXfs.Factory.newInstance();
            }
            cellStyleXfs.setCount(this.styleXfs.size());
            List<CTXf> list2 = this.styleXfs;
            cellStyleXfs.setXfArray((CTXf[]) list2.toArray(new CTXf[list2.size()]));
            styleSheet.setCellStyleXfs(cellStyleXfs);
        }
        if (this.dxfs.size() > 0) {
            CTDxfs dxfs = styleSheet.getDxfs();
            if (dxfs == null) {
                dxfs = CTDxfs.Factory.newInstance();
            }
            dxfs.setCount(this.dxfs.size());
            List<CTDxf> list3 = this.dxfs;
            dxfs.setDxfArray((CTDxf[]) list3.toArray(new CTDxf[list3.size()]));
            styleSheet.setDxfs(dxfs);
        }
        this.doc.save(outputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        writeTo(outputStream);
        outputStream.close();
    }

    private void initialize() {
        this.fonts.add(createDefaultFont());
        CTFill[] cTFillArrCreateDefaultFills = createDefaultFills();
        this.fills.add(new XSSFCellFill(cTFillArrCreateDefaultFills[0], this.indexedColors));
        this.fills.add(new XSSFCellFill(cTFillArrCreateDefaultFills[1], this.indexedColors));
        this.borders.add(new XSSFCellBorder(createDefaultBorder()));
        this.styleXfs.add(createDefaultXf());
        CTXf cTXfCreateDefaultXf = createDefaultXf();
        cTXfCreateDefaultXf.setXfId(0L);
        this.xfs.add(cTXfCreateDefaultXf);
    }

    private static CTXf createDefaultXf() {
        CTXf cTXfNewInstance = CTXf.Factory.newInstance();
        cTXfNewInstance.setNumFmtId(0L);
        cTXfNewInstance.setFontId(0L);
        cTXfNewInstance.setFillId(0L);
        cTXfNewInstance.setBorderId(0L);
        return cTXfNewInstance;
    }

    private static CTBorder createDefaultBorder() {
        CTBorder cTBorderNewInstance = CTBorder.Factory.newInstance();
        cTBorderNewInstance.addNewBottom();
        cTBorderNewInstance.addNewTop();
        cTBorderNewInstance.addNewLeft();
        cTBorderNewInstance.addNewRight();
        cTBorderNewInstance.addNewDiagonal();
        return cTBorderNewInstance;
    }

    private static CTFill[] createDefaultFills() {
        CTFill[] cTFillArr = {CTFill.Factory.newInstance(), CTFill.Factory.newInstance()};
        cTFillArr[0].addNewPatternFill().setPatternType(STPatternType.NONE);
        cTFillArr[1].addNewPatternFill().setPatternType(STPatternType.DARK_GRAY);
        return cTFillArr;
    }

    private static XSSFFont createDefaultFont() {
        XSSFFont xSSFFont = new XSSFFont(CTFont.Factory.newInstance(), 0, null);
        xSSFFont.setFontHeightInPoints((short) 11);
        xSSFFont.setColor(XSSFFont.DEFAULT_FONT_COLOR);
        xSSFFont.setFontName(XSSFFont.DEFAULT_FONT_NAME);
        xSSFFont.setFamily(FontFamily.SWISS);
        xSSFFont.setScheme(FontScheme.MINOR);
        return xSSFFont;
    }

    @Internal
    public CTDxf getDxfAt(int i) {
        return this.dxfs.get(i);
    }

    @Internal
    public int putDxf(CTDxf cTDxf) {
        this.dxfs.add(cTDxf);
        return this.dxfs.size();
    }

    public TableStyle getExplicitTableStyle(String str) {
        return this.tableStyles.get(str);
    }

    public Set<String> getExplicitTableStyleNames() {
        return this.tableStyles.keySet();
    }

    public TableStyle getTableStyle(String str) {
        if (str == null) {
            return null;
        }
        try {
            return XSSFBuiltinTableStyle.valueOf(str).getStyle();
        } catch (IllegalArgumentException unused) {
            return getExplicitTableStyle(str);
        }
    }

    public XSSFCellStyle createCellStyle() {
        int numCellStyles = getNumCellStyles();
        int i = MAXIMUM_STYLE_ID;
        if (numCellStyles > i) {
            throw new IllegalStateException("The maximum number of Cell Styles was exceeded. You can define up to " + i + " style in a .xlsx Workbook");
        }
        int size = this.styleXfs.size();
        CTXf cTXfNewInstance = CTXf.Factory.newInstance();
        cTXfNewInstance.setNumFmtId(0L);
        cTXfNewInstance.setFontId(0L);
        cTXfNewInstance.setFillId(0L);
        cTXfNewInstance.setBorderId(0L);
        cTXfNewInstance.setXfId(0L);
        return new XSSFCellStyle(putCellXf(cTXfNewInstance) - 1, size - 1, this, this.theme);
    }

    public XSSFFont findFont(boolean z, short s, short s2, String str, boolean z2, boolean z3, short s3, byte b) {
        for (XSSFFont xSSFFont : this.fonts) {
            if (xSSFFont.getBold() == z && xSSFFont.getColor() == s && xSSFFont.getFontHeight() == s2 && xSSFFont.getFontName().equals(str) && xSSFFont.getItalic() == z2 && xSSFFont.getStrikeout() == z3 && xSSFFont.getTypeOffset() == s3 && xSSFFont.getUnderline() == b) {
                return xSSFFont;
            }
        }
        return null;
    }

    public IndexedColorMap getIndexedColors() {
        return this.indexedColors;
    }
}
