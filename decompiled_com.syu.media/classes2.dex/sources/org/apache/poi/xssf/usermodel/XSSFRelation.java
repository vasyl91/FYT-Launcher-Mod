package org.apache.poi.xssf.usermodel;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLRelation;
import org.apache.poi.openxml4j.opc.ContentTypes;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.xssf.model.CalculationChain;
import org.apache.poi.xssf.model.CommentsTable;
import org.apache.poi.xssf.model.ExternalLinksTable;
import org.apache.poi.xssf.model.MapInfo;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.SingleXmlCells;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.model.ThemesTable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class XSSFRelation extends POIXMLRelation {
    public static final String NS_CHART = "http://schemas.openxmlformats.org/drawingml/2006/chart";
    public static final String NS_DRAWINGML = "http://schemas.openxmlformats.org/drawingml/2006/main";
    public static final String NS_SPREADSHEETML = "http://schemas.openxmlformats.org/spreadsheetml/2006/main";
    private static final Map<String, XSSFRelation> _table = new HashMap();
    public static final XSSFRelation WORKBOOK = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/workbook", "/xl/workbook.xml", null);
    public static final XSSFRelation MACROS_WORKBOOK = new XSSFRelation("application/vnd.ms-excel.sheet.macroEnabled.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/xl/workbook.xml", null);
    public static final XSSFRelation TEMPLATE_WORKBOOK = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.template.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/xl/workbook.xml", null);
    public static final XSSFRelation MACRO_TEMPLATE_WORKBOOK = new XSSFRelation("application/vnd.ms-excel.template.macroEnabled.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/xl/workbook.xml", null);
    public static final XSSFRelation MACRO_ADDIN_WORKBOOK = new XSSFRelation("application/vnd.ms-excel.addin.macroEnabled.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/xl/workbook.xml", null);
    public static final XSSFRelation XLSB_BINARY_WORKBOOK = new XSSFRelation("application/vnd.ms-excel.sheet.binary.macroEnabled.main", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/xl/workbook.bin", null);
    public static final XSSFRelation WORKSHEET = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.worksheet+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/worksheet", "/xl/worksheets/sheet#.xml", XSSFSheet.class);
    public static final XSSFRelation CHARTSHEET = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.chartsheet+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/chartsheet", "/xl/chartsheets/sheet#.xml", XSSFChartSheet.class);
    public static final XSSFRelation SHARED_STRINGS = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.sharedStrings+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/sharedStrings", "/xl/sharedStrings.xml", SharedStringsTable.class);
    public static final XSSFRelation STYLES = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.styles+xml", PackageRelationshipTypes.STYLE_PART, "/xl/styles.xml", StylesTable.class);
    public static final XSSFRelation DRAWINGS = new XSSFRelation("application/vnd.openxmlformats-officedocument.drawing+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/drawing", "/xl/drawings/drawing#.xml", XSSFDrawing.class);
    public static final XSSFRelation VML_DRAWINGS = new XSSFRelation("application/vnd.openxmlformats-officedocument.vmlDrawing", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/vmlDrawing", "/xl/drawings/vmlDrawing#.vml", XSSFVMLDrawing.class);
    public static final XSSFRelation CHART = new XSSFRelation("application/vnd.openxmlformats-officedocument.drawingml.chart+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/chart", "/xl/charts/chart#.xml", XSSFChart.class);
    public static final XSSFRelation CUSTOM_XML_MAPPINGS = new XSSFRelation(ContentTypes.PLAIN_OLD_XML, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/xmlMaps", "/xl/xmlMaps.xml", MapInfo.class);
    public static final XSSFRelation SINGLE_XML_CELLS = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.tableSingleCells+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/tableSingleCells", "/xl/tables/tableSingleCells#.xml", SingleXmlCells.class);
    public static final XSSFRelation TABLE = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.table+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/table", "/xl/tables/table#.xml", XSSFTable.class);
    public static final XSSFRelation IMAGES = new XSSFRelation(null, PackageRelationshipTypes.IMAGE_PART, null, XSSFPictureData.class);
    public static final XSSFRelation IMAGE_EMF = new XSSFRelation("image/x-emf", PackageRelationshipTypes.IMAGE_PART, "/xl/media/image#.emf", XSSFPictureData.class);
    public static final XSSFRelation IMAGE_WMF = new XSSFRelation("image/x-wmf", PackageRelationshipTypes.IMAGE_PART, "/xl/media/image#.wmf", XSSFPictureData.class);
    public static final XSSFRelation IMAGE_PICT = new XSSFRelation(ContentTypes.IMAGE_PICT, PackageRelationshipTypes.IMAGE_PART, "/xl/media/image#.pict", XSSFPictureData.class);
    public static final XSSFRelation IMAGE_JPEG = new XSSFRelation(ContentTypes.IMAGE_JPEG, PackageRelationshipTypes.IMAGE_PART, "/xl/media/image#.jpeg", XSSFPictureData.class);
    public static final XSSFRelation IMAGE_PNG = new XSSFRelation(ContentTypes.IMAGE_PNG, PackageRelationshipTypes.IMAGE_PART, "/xl/media/image#.png", XSSFPictureData.class);
    public static final XSSFRelation IMAGE_DIB = new XSSFRelation("image/dib", PackageRelationshipTypes.IMAGE_PART, "/xl/media/image#.dib", XSSFPictureData.class);
    public static final XSSFRelation IMAGE_GIF = new XSSFRelation(ContentTypes.IMAGE_GIF, PackageRelationshipTypes.IMAGE_PART, "/xl/media/image#.gif", XSSFPictureData.class);
    public static final XSSFRelation IMAGE_TIFF = new XSSFRelation(ContentTypes.IMAGE_TIFF, PackageRelationshipTypes.IMAGE_PART, "/xl/media/image#.tiff", XSSFPictureData.class);
    public static final XSSFRelation IMAGE_EPS = new XSSFRelation("image/x-eps", PackageRelationshipTypes.IMAGE_PART, "/xl/media/image#.eps", XSSFPictureData.class);
    public static final XSSFRelation IMAGE_BMP = new XSSFRelation("image/x-ms-bmp", PackageRelationshipTypes.IMAGE_PART, "/xl/media/image#.bmp", XSSFPictureData.class);
    public static final XSSFRelation IMAGE_WPG = new XSSFRelation("image/x-wpg", PackageRelationshipTypes.IMAGE_PART, "/xl/media/image#.wpg", XSSFPictureData.class);
    public static final XSSFRelation SHEET_COMMENTS = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.comments+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/comments", "/xl/comments#.xml", CommentsTable.class);
    public static final XSSFRelation SHEET_HYPERLINKS = new XSSFRelation(null, PackageRelationshipTypes.HYPERLINK_PART, null, null);
    public static final XSSFRelation OLEEMBEDDINGS = new XSSFRelation(null, POIXMLDocument.OLE_OBJECT_REL_TYPE, null, null);
    public static final XSSFRelation PACKEMBEDDINGS = new XSSFRelation(null, POIXMLDocument.PACK_OBJECT_REL_TYPE, null, null);
    public static final XSSFRelation VBA_MACROS = new XSSFRelation("application/vnd.ms-office.vbaProject", "http://schemas.microsoft.com/office/2006/relationships/vbaProject", "/xl/vbaProject.bin", XSSFVBAPart.class);
    public static final XSSFRelation ACTIVEX_CONTROLS = new XSSFRelation("application/vnd.ms-office.activeX+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/control", "/xl/activeX/activeX#.xml", null);
    public static final XSSFRelation ACTIVEX_BINS = new XSSFRelation("application/vnd.ms-office.activeX", "http://schemas.microsoft.com/office/2006/relationships/activeXControlBinary", "/xl/activeX/activeX#.bin", null);
    public static final XSSFRelation MACRO_SHEET_BIN = new XSSFRelation(null, "http://schemas.microsoft.com/office/2006/relationships/xlMacrosheet", "/xl/macroSheets/sheet#.bin", null);
    public static final XSSFRelation INTL_MACRO_SHEET_BIN = new XSSFRelation(null, "http://schemas.microsoft.com/office/2006/relationships/xlIntlMacrosheet", "/xl/macroSheets/sheet#.bin", null);
    public static final XSSFRelation DIALOG_SHEET_BIN = new XSSFRelation(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/dialogsheet", "/xl/dialogSheets/sheet#.bin", null);
    public static final XSSFRelation THEME = new XSSFRelation("application/vnd.openxmlformats-officedocument.theme+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/theme", "/xl/theme/theme#.xml", ThemesTable.class);
    public static final XSSFRelation CALC_CHAIN = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.calcChain+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/calcChain", "/xl/calcChain.xml", CalculationChain.class);
    public static final XSSFRelation EXTERNAL_LINKS = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.externalLink+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/externalLink", "/xl/externalLinks/externalLink#.xmll", ExternalLinksTable.class);
    public static final XSSFRelation PRINTER_SETTINGS = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.printerSettings", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/printerSettings", "/xl/printerSettings/printerSettings#.bin", null);
    public static final XSSFRelation PIVOT_TABLE = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.pivotTable+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/pivotTable", "/xl/pivotTables/pivotTable#.xml", XSSFPivotTable.class);
    public static final XSSFRelation PIVOT_CACHE_DEFINITION = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.pivotCacheDefinition+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/pivotCacheDefinition", "/xl/pivotCache/pivotCacheDefinition#.xml", XSSFPivotCacheDefinition.class);
    public static final XSSFRelation PIVOT_CACHE_RECORDS = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.pivotCacheRecords+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/pivotCacheRecords", "/xl/pivotCache/pivotCacheRecords#.xml", XSSFPivotCacheRecords.class);
    public static final XSSFRelation CTRL_PROP_RECORDS = new XSSFRelation(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/ctrlProp", "/xl/ctrlProps/ctrlProp#.xml", null);
    public static final XSSFRelation CUSTOM_PROPERTIES = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.customProperty", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/customProperty", "/xl/customProperty#.bin", null);

    private XSSFRelation(String str, String str2, String str3, Class<? extends POIXMLDocumentPart> cls) {
        super(str, str2, str3, cls);
        _table.put(str2, this);
    }

    public static XSSFRelation getInstance(String str) {
        return _table.get(str);
    }
}
