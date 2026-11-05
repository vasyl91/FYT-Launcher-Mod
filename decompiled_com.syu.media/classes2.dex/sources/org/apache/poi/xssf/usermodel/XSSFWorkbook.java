package org.apache.poi.xssf.usermodel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;
import javax.xml.namespace.QName;
import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.hpsf.ClassID;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.Ole10Native;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.ss.formula.udf.AggregatingUDFFinder;
import org.apache.poi.ss.formula.udf.IndexedUDFFinder;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetVisibility;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.NotImplemented;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.PackageHelper;
import org.apache.poi.util.Removal;
import org.apache.poi.xssf.XLSBUnsupportedException;
import org.apache.poi.xssf.model.CalculationChain;
import org.apache.poi.xssf.model.ExternalLinksTable;
import org.apache.poi.xssf.model.MapInfo;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.model.ThemesTable;
import org.apache.poi.xssf.usermodel.helpers.XSSFFormulaUtils;
import org.apache.poi.xssf.usermodel.helpers.XSSFPasswordHelper;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReference;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCache;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCalcMode;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSheetState;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorkbookDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFWorkbook extends POIXMLDocument implements Workbook {

    @Removal(version = "3.19")
    public static final float DEFAULT_CHARACTER_WIDTH = 7.0017f;
    private static final int MAX_SENSITIVE_SHEET_NAME_LEN = 31;
    public static final int PICTURE_TYPE_BMP = 11;
    public static final int PICTURE_TYPE_EPS = 10;
    public static final int PICTURE_TYPE_GIF = 8;
    public static final int PICTURE_TYPE_TIFF = 9;
    public static final int PICTURE_TYPE_WPG = 12;
    private XSSFCreationHelper _creationHelper;
    private Row.MissingCellPolicy _missingCellPolicy;
    private IndexedUDFFinder _udfFinder;
    private CalculationChain calcChain;
    private List<ExternalLinksTable> externalLinks;
    private XSSFDataFormat formatter;
    private MapInfo mapInfo;
    private List<XSSFName> namedRanges;
    private ListValuedMap<String, XSSFName> namedRangesByName;
    private List<XSSFPictureData> pictures;
    private List<CTPivotCache> pivotCaches;
    private List<XSSFPivotTable> pivotTables;
    private SharedStringsTable sharedStringSource;
    private List<XSSFSheet> sheets;
    private StylesTable stylesSource;
    private CTWorkbook workbook;
    private static final Pattern COMMA_PATTERN = Pattern.compile(",");
    private static POILogger logger = POILogFactory.getLogger((Class<?>) XSSFWorkbook.class);

    public XSSFWorkbook() {
        this(XSSFWorkbookType.XLSX);
    }

    public XSSFWorkbook(XSSFWorkbookType xSSFWorkbookType) {
        super(newPackage(xSSFWorkbookType));
        this._udfFinder = new IndexedUDFFinder(AggregatingUDFFinder.DEFAULT);
        this._missingCellPolicy = Row.MissingCellPolicy.RETURN_NULL_AND_BLANK;
        onWorkbookCreate();
    }

    public XSSFWorkbook(OPCPackage oPCPackage) throws IOException {
        super(oPCPackage);
        this._udfFinder = new IndexedUDFFinder(AggregatingUDFFinder.DEFAULT);
        this._missingCellPolicy = Row.MissingCellPolicy.RETURN_NULL_AND_BLANK;
        beforeDocumentRead();
        load(XSSFFactory.getInstance());
        if (this.workbook.isSetBookViews()) {
            return;
        }
        this.workbook.addNewBookViews().addNewWorkbookView().setActiveTab(0L);
    }

    public XSSFWorkbook(InputStream inputStream) throws IOException {
        super(PackageHelper.open(inputStream));
        this._udfFinder = new IndexedUDFFinder(AggregatingUDFFinder.DEFAULT);
        this._missingCellPolicy = Row.MissingCellPolicy.RETURN_NULL_AND_BLANK;
        beforeDocumentRead();
        load(XSSFFactory.getInstance());
        if (this.workbook.isSetBookViews()) {
            return;
        }
        this.workbook.addNewBookViews().addNewWorkbookView().setActiveTab(0L);
    }

    public XSSFWorkbook(File file) throws InvalidFormatException, IOException {
        this(OPCPackage.open(file));
    }

    public XSSFWorkbook(String str) throws IOException {
        this(openPackage(str));
    }

    protected void beforeDocumentRead() {
        if (getCorePart().getContentType().equals(XSSFRelation.XLSB_BINARY_WORKBOOK.getContentType())) {
            throw new XLSBUnsupportedException();
        }
        this.pivotTables = new ArrayList();
        this.pivotCaches = new ArrayList();
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void onDocumentRead() throws IOException {
        try {
            this.workbook = WorkbookDocument.Factory.parse(getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getWorkbook();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            ThemesTable themesTable = null;
            for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
                POIXMLDocumentPart documentPart = relationPart.getDocumentPart();
                if (documentPart instanceof SharedStringsTable) {
                    this.sharedStringSource = (SharedStringsTable) documentPart;
                } else if (documentPart instanceof StylesTable) {
                    this.stylesSource = (StylesTable) documentPart;
                } else if (documentPart instanceof ThemesTable) {
                    themesTable = (ThemesTable) documentPart;
                } else if (documentPart instanceof CalculationChain) {
                    this.calcChain = (CalculationChain) documentPart;
                } else if (documentPart instanceof MapInfo) {
                    this.mapInfo = (MapInfo) documentPart;
                } else if (documentPart instanceof XSSFSheet) {
                    map.put(relationPart.getRelationship().getId(), (XSSFSheet) documentPart);
                } else if (documentPart instanceof ExternalLinksTable) {
                    map2.put(relationPart.getRelationship().getId(), (ExternalLinksTable) documentPart);
                }
            }
            boolean z = getPackage().getPackageAccess() == PackageAccess.READ;
            if (this.stylesSource == null) {
                if (z) {
                    this.stylesSource = new StylesTable();
                } else {
                    this.stylesSource = (StylesTable) createRelationship(XSSFRelation.STYLES, XSSFFactory.getInstance());
                }
            }
            this.stylesSource.setWorkbook(this);
            this.stylesSource.setTheme(themesTable);
            if (this.sharedStringSource == null) {
                if (z) {
                    this.sharedStringSource = new SharedStringsTable();
                } else {
                    this.sharedStringSource = (SharedStringsTable) createRelationship(XSSFRelation.SHARED_STRINGS, XSSFFactory.getInstance());
                }
            }
            this.sheets = new ArrayList(map.size());
            for (CTSheet cTSheet : this.workbook.getSheets().getSheetArray()) {
                parseSheet(map, cTSheet);
            }
            this.externalLinks = new ArrayList(map2.size());
            if (this.workbook.isSetExternalReferences()) {
                for (CTExternalReference cTExternalReference : this.workbook.getExternalReferences().getExternalReferenceArray()) {
                    ExternalLinksTable externalLinksTable = (ExternalLinksTable) map2.get(cTExternalReference.getId());
                    if (externalLinksTable == null) {
                        logger.log(5, "ExternalLinksTable with r:id " + cTExternalReference.getId() + " was defined, but didn't exist in package, skipping");
                    } else {
                        this.externalLinks.add(externalLinksTable);
                    }
                }
            }
            reprocessNamedRanges();
        } catch (XmlException e) {
            throw new POIXMLException(e);
        }
    }

    public void parseSheet(Map<String, XSSFSheet> map, CTSheet cTSheet) {
        XSSFSheet xSSFSheet = map.get(cTSheet.getId());
        if (xSSFSheet == null) {
            logger.log(5, "Sheet with name " + cTSheet.getName() + " and r:id " + cTSheet.getId() + " was defined, but didn't exist in package, skipping");
            return;
        }
        xSSFSheet.sheet = cTSheet;
        xSSFSheet.onDocumentRead();
        this.sheets.add(xSSFSheet);
    }

    private void onWorkbookCreate() {
        CTWorkbook cTWorkbookNewInstance = CTWorkbook.Factory.newInstance();
        this.workbook = cTWorkbookNewInstance;
        cTWorkbookNewInstance.addNewWorkbookPr().setDate1904(false);
        this.workbook.addNewBookViews().addNewWorkbookView().setActiveTab(0L);
        this.workbook.addNewSheets();
        getProperties().getExtendedProperties().getUnderlyingProperties().setApplication(POIXMLDocument.DOCUMENT_CREATOR);
        this.sharedStringSource = (SharedStringsTable) createRelationship(XSSFRelation.SHARED_STRINGS, XSSFFactory.getInstance());
        StylesTable stylesTable = (StylesTable) createRelationship(XSSFRelation.STYLES, XSSFFactory.getInstance());
        this.stylesSource = stylesTable;
        stylesTable.setWorkbook(this);
        this.namedRanges = new ArrayList();
        this.namedRangesByName = new ArrayListValuedHashMap();
        this.sheets = new ArrayList();
        this.pivotTables = new ArrayList();
    }

    protected static OPCPackage newPackage(XSSFWorkbookType xSSFWorkbookType) {
        try {
            OPCPackage oPCPackageCreate = OPCPackage.create(new ByteArrayOutputStream());
            PackagePartName packagePartNameCreatePartName = PackagingURIHelper.createPartName(XSSFRelation.WORKBOOK.getDefaultFileName());
            oPCPackageCreate.addRelationship(packagePartNameCreatePartName, TargetMode.INTERNAL, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument");
            oPCPackageCreate.createPart(packagePartNameCreatePartName, xSSFWorkbookType.getContentType());
            oPCPackageCreate.getPackageProperties().setCreatorProperty(POIXMLDocument.DOCUMENT_CREATOR);
            return oPCPackageCreate;
        } catch (Exception e) {
            throw new POIXMLException(e);
        }
    }

    @Internal
    public CTWorkbook getCTWorkbook() {
        return this.workbook;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int addPicture(byte[] bArr, int i) {
        int size = getAllPictures().size() + 1;
        XSSFPictureData xSSFPictureData = (XSSFPictureData) createRelationship(XSSFPictureData.RELATIONS[i], XSSFFactory.getInstance(), size, true).getDocumentPart();
        try {
            OutputStream outputStream = xSSFPictureData.getPackagePart().getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
            this.pictures.add(xSSFPictureData);
            return size - 1;
        } catch (IOException e) {
            throw new POIXMLException(e);
        }
    }

    public int addPicture(InputStream inputStream, int i) throws IOException {
        int size = getAllPictures().size() + 1;
        XSSFPictureData xSSFPictureData = (XSSFPictureData) createRelationship(XSSFPictureData.RELATIONS[i], XSSFFactory.getInstance(), size, true).getDocumentPart();
        OutputStream outputStream = xSSFPictureData.getPackagePart().getOutputStream();
        IOUtils.copy(inputStream, outputStream);
        outputStream.close();
        this.pictures.add(xSSFPictureData);
        return size - 1;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFSheet cloneSheet(int i) {
        return cloneSheet(i, null);
    }

    public XSSFSheet cloneSheet(int i, String str) {
        validateSheetIndex(i);
        XSSFSheet xSSFSheet = this.sheets.get(i);
        if (str == null) {
            str = getUniqueSheetName(xSSFSheet.getSheetName());
        } else {
            validateSheetName(str);
        }
        XSSFSheet xSSFSheetCreateSheet = createSheet(str);
        XSSFDrawing xSSFDrawing = null;
        for (POIXMLDocumentPart.RelationPart relationPart : xSSFSheet.getRelationParts()) {
            POIXMLDocumentPart documentPart = relationPart.getDocumentPart();
            if (documentPart instanceof XSSFDrawing) {
                xSSFDrawing = (XSSFDrawing) documentPart;
            } else {
                addRelation(relationPart, xSSFSheetCreateSheet);
            }
        }
        try {
            for (PackageRelationship packageRelationship : xSSFSheet.getPackagePart().getRelationships()) {
                if (packageRelationship.getTargetMode() == TargetMode.EXTERNAL) {
                    xSSFSheetCreateSheet.getPackagePart().addExternalRelationship(packageRelationship.getTargetURI().toASCIIString(), packageRelationship.getRelationshipType(), packageRelationship.getId());
                }
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                xSSFSheet.write(byteArrayOutputStream);
                xSSFSheetCreateSheet.read(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                CTWorksheet cTWorksheet = xSSFSheetCreateSheet.getCTWorksheet();
                if (cTWorksheet.isSetLegacyDrawing()) {
                    logger.log(5, "Cloning sheets with comments is not yet supported.");
                    cTWorksheet.unsetLegacyDrawing();
                }
                if (cTWorksheet.isSetPageSetup()) {
                    logger.log(5, "Cloning sheets with page setup is not yet supported.");
                    cTWorksheet.unsetPageSetup();
                }
                xSSFSheetCreateSheet.setSelected(false);
                if (xSSFDrawing != null) {
                    if (cTWorksheet.isSetDrawing()) {
                        cTWorksheet.unsetDrawing();
                    }
                    xSSFSheetCreateSheet.createDrawingPatriarch().getCTDrawing().set(xSSFDrawing.getCTDrawing());
                    XSSFDrawing xSSFDrawingCreateDrawingPatriarch = xSSFSheetCreateSheet.createDrawingPatriarch();
                    Iterator<POIXMLDocumentPart.RelationPart> it = xSSFSheet.createDrawingPatriarch().getRelationParts().iterator();
                    while (it.hasNext()) {
                        addRelation(it.next(), xSSFDrawingCreateDrawingPatriarch);
                    }
                }
                return xSSFSheetCreateSheet;
            } catch (IOException e) {
                throw new POIXMLException("Failed to clone sheet", e);
            }
        } catch (InvalidFormatException e2) {
            throw new POIXMLException("Failed to clone sheet", e2);
        }
    }

    private static void addRelation(POIXMLDocumentPart.RelationPart relationPart, POIXMLDocumentPart pOIXMLDocumentPart) {
        PackageRelationship relationship = relationPart.getRelationship();
        if (relationship.getTargetMode() == TargetMode.EXTERNAL) {
            pOIXMLDocumentPart.getPackagePart().addRelationship(relationship.getTargetURI(), relationship.getTargetMode(), relationship.getRelationshipType(), relationship.getId());
            return;
        }
        XSSFRelation xSSFRelation = XSSFRelation.getInstance(relationship.getRelationshipType());
        if (xSSFRelation == null) {
            throw new POIXMLException("Can't clone sheet - unknown relation type found: " + relationship.getRelationshipType());
        }
        pOIXMLDocumentPart.addRelation(relationship.getId(), xSSFRelation, relationPart.getDocumentPart());
    }

    private String getUniqueSheetName(String str) {
        int i;
        String str2;
        int iLastIndexOf = str.lastIndexOf(40);
        if (iLastIndexOf <= 0 || !str.endsWith(")")) {
            i = 2;
        } else {
            try {
                i = Integer.parseInt(str.substring(iLastIndexOf + 1, str.length() - 1).trim()) + 1;
                try {
                    str = str.substring(0, iLastIndexOf).trim();
                } catch (NumberFormatException unused) {
                }
            } catch (NumberFormatException unused2) {
                i = 2;
            }
        }
        while (true) {
            int i2 = i + 1;
            String string = Integer.toString(i);
            if (str.length() + string.length() + 2 < 31) {
                str2 = str + " (" + string + ")";
            } else {
                str2 = str.substring(0, (31 - string.length()) - 2) + "(" + string + ")";
            }
            if (getSheetIndex(str2) == -1) {
                return str2;
            }
            i = i2;
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFCellStyle createCellStyle() {
        return this.stylesSource.createCellStyle();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFDataFormat createDataFormat() {
        if (this.formatter == null) {
            this.formatter = new XSSFDataFormat(this.stylesSource);
        }
        return this.formatter;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFFont createFont() {
        XSSFFont xSSFFont = new XSSFFont();
        xSSFFont.registerTo(this.stylesSource);
        return xSSFFont;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFName createName() {
        CTDefinedName cTDefinedNameNewInstance = CTDefinedName.Factory.newInstance();
        cTDefinedNameNewInstance.setName("");
        return createAndStoreName(cTDefinedNameNewInstance);
    }

    private XSSFName createAndStoreName(CTDefinedName cTDefinedName) {
        XSSFName xSSFName = new XSSFName(cTDefinedName, this);
        this.namedRanges.add(xSSFName);
        this.namedRangesByName.put(cTDefinedName.getName().toLowerCase(Locale.ENGLISH), xSSFName);
        return xSSFName;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFSheet createSheet() {
        String str = "Sheet" + this.sheets.size();
        int i = 0;
        while (getSheet(str) != null) {
            str = "Sheet" + i;
            i++;
        }
        return createSheet(str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFSheet createSheet(String str) {
        if (str == null) {
            throw new IllegalArgumentException("sheetName must not be null");
        }
        validateSheetName(str);
        if (str.length() > 31) {
            str = str.substring(0, 31);
        }
        WorkbookUtil.validateSheetName(str);
        CTSheet cTSheetAddSheet = addSheet(str);
        int iMax = 1;
        loop0: while (true) {
            Iterator<XSSFSheet> it = this.sheets.iterator();
            while (it.hasNext()) {
                iMax = (int) Math.max(it.next().sheet.getSheetId() + 1, iMax);
            }
            String fileName = XSSFRelation.WORKSHEET.getFileName(iMax);
            Iterator<POIXMLDocumentPart> it2 = getRelations().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break loop0;
                }
                POIXMLDocumentPart next = it2.next();
                if (next.getPackagePart() == null || !fileName.equals(next.getPackagePart().getPartName().getName())) {
                }
            }
            iMax++;
        }
        POIXMLDocumentPart.RelationPart relationPartCreateRelationship = createRelationship(XSSFRelation.WORKSHEET, XSSFFactory.getInstance(), iMax, false);
        XSSFSheet xSSFSheet = (XSSFSheet) relationPartCreateRelationship.getDocumentPart();
        xSSFSheet.sheet = cTSheetAddSheet;
        cTSheetAddSheet.setId(relationPartCreateRelationship.getRelationship().getId());
        cTSheetAddSheet.setSheetId(iMax);
        if (this.sheets.isEmpty()) {
            xSSFSheet.setSelected(true);
        }
        this.sheets.add(xSSFSheet);
        return xSSFSheet;
    }

    private void validateSheetName(String str) throws IllegalArgumentException {
        if (containsSheet(str, this.sheets.size())) {
            throw new IllegalArgumentException("The workbook already contains a sheet named '" + str + "'");
        }
    }

    protected XSSFDialogsheet createDialogsheet(String str, CTDialogsheet cTDialogsheet) {
        return new XSSFDialogsheet(createSheet(str));
    }

    private CTSheet addSheet(String str) {
        CTSheet cTSheetAddNewSheet = this.workbook.getSheets().addNewSheet();
        cTSheetAddNewSheet.setName(str);
        return cTSheetAddNewSheet;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFFont findFont(boolean z, short s, short s2, String str, boolean z2, boolean z3, short s3, byte b) {
        return this.stylesSource.findFont(z, s, s2, str, z2, z3, s3, b);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getActiveSheetIndex() {
        return (int) this.workbook.getBookViews().getWorkbookViewArray(0).getActiveTab();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public List<XSSFPictureData> getAllPictures() {
        if (this.pictures == null) {
            List<PackagePart> partsByName = getPackage().getPartsByName(Pattern.compile("/xl/media/.*?"));
            this.pictures = new ArrayList(partsByName.size());
            Iterator<PackagePart> it = partsByName.iterator();
            while (it.hasNext()) {
                this.pictures.add(new XSSFPictureData(it.next()));
            }
        }
        return this.pictures;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFCellStyle getCellStyleAt(int i) {
        return this.stylesSource.getStyleAt(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFFont getFontAt(short s) {
        return this.stylesSource.getFontAt(s);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFName getName(String str) {
        List<XSSFName> names = getNames(str);
        if (names.isEmpty()) {
            return null;
        }
        return names.iterator().next();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public List<XSSFName> getNames(String str) {
        return Collections.unmodifiableList(this.namedRangesByName.get(str.toLowerCase(Locale.ENGLISH)));
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @Deprecated
    public XSSFName getNameAt(int i) {
        int size = this.namedRanges.size();
        if (size < 1) {
            throw new IllegalStateException("There are no defined names in this workbook");
        }
        if (i < 0 || i > size) {
            throw new IllegalArgumentException("Specified name index " + i + " is outside the allowable range (0.." + (size - 1) + ").");
        }
        return this.namedRanges.get(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public List<XSSFName> getAllNames() {
        return Collections.unmodifiableList(this.namedRanges);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @Deprecated
    public int getNameIndex(String str) {
        XSSFName name = getName(str);
        if (name != null) {
            return this.namedRanges.indexOf(name);
        }
        return -1;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumCellStyles() {
        return this.stylesSource.getNumCellStyles();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public short getNumberOfFonts() {
        return (short) this.stylesSource.getFonts().size();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumberOfNames() {
        return this.namedRanges.size();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumberOfSheets() {
        return this.sheets.size();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public String getPrintArea(int i) {
        XSSFName builtInName = getBuiltInName(XSSFName.BUILTIN_PRINT_AREA, i);
        if (builtInName == null) {
            return null;
        }
        return builtInName.getRefersToFormula();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFSheet getSheet(String str) {
        for (XSSFSheet xSSFSheet : this.sheets) {
            if (str.equalsIgnoreCase(xSSFSheet.getSheetName())) {
                return xSSFSheet;
            }
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFSheet getSheetAt(int i) {
        validateSheetIndex(i);
        return this.sheets.get(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getSheetIndex(String str) {
        Iterator<XSSFSheet> it = this.sheets.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(it.next().getSheetName())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getSheetIndex(Sheet sheet) {
        Iterator<XSSFSheet> it = this.sheets.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next() == sheet) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public String getSheetName(int i) {
        validateSheetIndex(i);
        return this.sheets.get(i).getSheetName();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Iterator<Sheet> sheetIterator() {
        return new SheetIterator();
    }

    @Override // java.lang.Iterable
    public Iterator<Sheet> iterator() {
        return sheetIterator();
    }

    private final class SheetIterator<T extends Sheet> implements Iterator<T> {
        private final Iterator<T> it;

        public SheetIterator() {
            this.it = XSSFWorkbook.this.sheets.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.it.hasNext();
        }

        @Override // java.util.Iterator
        public T next() throws NoSuchElementException {
            return this.it.next();
        }

        @Override // java.util.Iterator
        public void remove() throws IllegalStateException {
            throw new UnsupportedOperationException("remove method not supported on XSSFWorkbook.iterator(). Use Sheet.removeSheetAt(int) instead.");
        }
    }

    public boolean isMacroEnabled() {
        return getPackagePart().getContentType().equals(XSSFRelation.MACROS_WORKBOOK.getContentType());
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @Deprecated
    public void removeName(int i) {
        removeName(getNameAt(i));
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @Deprecated
    public void removeName(String str) {
        List<XSSFName> list = this.namedRangesByName.get(str.toLowerCase(Locale.ENGLISH));
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Named range was not found: " + str);
        }
        removeName(list.get(0));
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removeName(Name name) {
        if (!this.namedRangesByName.removeMapping(name.getNameName().toLowerCase(Locale.ENGLISH), name) || !this.namedRanges.remove(name)) {
            throw new IllegalArgumentException("Name was not found: " + name);
        }
    }

    void updateName(XSSFName xSSFName, String str) {
        if (!this.namedRangesByName.removeMapping(str.toLowerCase(Locale.ENGLISH), xSSFName)) {
            throw new IllegalArgumentException("Name was not found: " + xSSFName);
        }
        this.namedRangesByName.put(xSSFName.getNameName().toLowerCase(Locale.ENGLISH), xSSFName);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removePrintArea(int i) {
        XSSFName builtInName = getBuiltInName(XSSFName.BUILTIN_PRINT_AREA, i);
        if (builtInName != null) {
            removeName(builtInName);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removeSheetAt(int i) {
        validateSheetIndex(i);
        onSheetDelete(i);
        removeRelation(getSheetAt(i));
        this.sheets.remove(i);
        if (this.sheets.size() == 0) {
            return;
        }
        int size = i >= this.sheets.size() ? this.sheets.size() - 1 : i;
        int activeSheetIndex = getActiveSheetIndex();
        if (activeSheetIndex == i) {
            setActiveSheet(size);
        } else if (activeSheetIndex > i) {
            setActiveSheet(activeSheetIndex - 1);
        }
    }

    private void onSheetDelete(int i) {
        getSheetAt(i).onSheetDelete();
        this.workbook.getSheets().removeSheet(i);
        CalculationChain calculationChain = this.calcChain;
        if (calculationChain != null) {
            removeRelation(calculationChain);
            this.calcChain = null;
        }
        ArrayList arrayList = new ArrayList();
        for (XSSFName xSSFName : this.namedRanges) {
            CTDefinedName cTName = xSSFName.getCTName();
            if (cTName.isSetLocalSheetId()) {
                long j = i;
                if (cTName.getLocalSheetId() == j) {
                    arrayList.add(xSSFName);
                } else if (cTName.getLocalSheetId() > j) {
                    cTName.setLocalSheetId(cTName.getLocalSheetId() - 1);
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            removeName((XSSFName) it.next());
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Row.MissingCellPolicy getMissingCellPolicy() {
        return this._missingCellPolicy;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setMissingCellPolicy(Row.MissingCellPolicy missingCellPolicy) {
        this._missingCellPolicy = missingCellPolicy;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setActiveSheet(int i) {
        validateSheetIndex(i);
        for (CTBookView cTBookView : this.workbook.getBookViews().getWorkbookViewArray()) {
            cTBookView.setActiveTab(i);
        }
    }

    private void validateSheetIndex(int i) {
        int size = this.sheets.size() - 1;
        if (i < 0 || i > size) {
            String str = "(0.." + size + ")";
            if (size == -1) {
                str = "(no sheets)";
            }
            throw new IllegalArgumentException("Sheet index (" + i + ") is out of range " + str);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getFirstVisibleTab() {
        return (short) this.workbook.getBookViews().getWorkbookViewArray(0).getFirstSheet();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setFirstVisibleTab(int i) {
        this.workbook.getBookViews().getWorkbookViewArray(0).setFirstSheet(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setPrintArea(int i, String str) {
        XSSFName builtInName = getBuiltInName(XSSFName.BUILTIN_PRINT_AREA, i);
        if (builtInName == null) {
            builtInName = createBuiltInName(XSSFName.BUILTIN_PRINT_AREA, i);
        }
        String[] strArrSplit = COMMA_PATTERN.split(str);
        StringBuffer stringBuffer = new StringBuffer(32);
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(",");
            }
            SheetNameFormatter.appendFormat(stringBuffer, getSheetName(i));
            stringBuffer.append("!");
            stringBuffer.append(strArrSplit[i2]);
        }
        builtInName.setRefersToFormula(stringBuffer.toString());
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setPrintArea(int i, int i2, int i3, int i4, int i5) {
        setPrintArea(i, getReferencePrintArea(getSheetName(i), i2, i3, i4, i5));
    }

    private static String getReferencePrintArea(String str, int i, int i2, int i3, int i4) {
        CellReference cellReference = new CellReference(str, i3, i, true, true);
        CellReference cellReference2 = new CellReference(str, i4, i2, true, true);
        return "$" + cellReference.getCellRefParts()[2] + "$" + cellReference.getCellRefParts()[1] + ":$" + cellReference2.getCellRefParts()[2] + "$" + cellReference2.getCellRefParts()[1];
    }

    XSSFName getBuiltInName(String str, int i) {
        for (XSSFName xSSFName : this.namedRangesByName.get(str.toLowerCase(Locale.ENGLISH))) {
            if (xSSFName.getSheetIndex() == i) {
                return xSSFName;
            }
        }
        return null;
    }

    XSSFName createBuiltInName(String str, int i) {
        validateSheetIndex(i);
        CTDefinedName cTDefinedNameAddNewDefinedName = (this.workbook.getDefinedNames() == null ? this.workbook.addNewDefinedNames() : this.workbook.getDefinedNames()).addNewDefinedName();
        cTDefinedNameAddNewDefinedName.setName(str);
        cTDefinedNameAddNewDefinedName.setLocalSheetId(i);
        if (getBuiltInName(str, i) != null) {
            throw new POIXMLException("Builtin (" + str + ") already exists for sheet (" + i + ")");
        }
        return createAndStoreName(cTDefinedNameAddNewDefinedName);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSelectedTab(int i) {
        Iterator<XSSFSheet> it = this.sheets.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            it.next().setSelected(i2 == i);
            i2++;
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetName(int i, String str) {
        if (str == null) {
            throw new IllegalArgumentException("sheetName must not be null");
        }
        validateSheetIndex(i);
        String sheetName = getSheetName(i);
        if (str.length() > 31) {
            str = str.substring(0, 31);
        }
        WorkbookUtil.validateSheetName(str);
        if (str.equals(sheetName)) {
            return;
        }
        if (containsSheet(str, i)) {
            throw new IllegalArgumentException("The workbook already contains a sheet of this name");
        }
        new XSSFFormulaUtils(this).updateSheetName(i, sheetName, str);
        this.workbook.getSheets().getSheetArray(i).setName(str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetOrder(String str, int i) {
        int sheetIndex = getSheetIndex(str);
        List<XSSFSheet> list = this.sheets;
        list.add(i, list.remove(sheetIndex));
        CTSheets sheets = this.workbook.getSheets();
        XmlObject xmlObjectCopy = sheets.getSheetArray(sheetIndex).copy();
        this.workbook.getSheets().removeSheet(sheetIndex);
        sheets.insertNewSheet(i).set(xmlObjectCopy);
        CTSheet[] sheetArray = sheets.getSheetArray();
        for (int i2 = 0; i2 < sheetArray.length; i2++) {
            this.sheets.get(i2).sheet = sheetArray[i2];
        }
        updateNamedRangesAfterSheetReorder(sheetIndex, i);
        updateActiveSheetAfterSheetReorder(sheetIndex, i);
    }

    private void updateNamedRangesAfterSheetReorder(int i, int i2) {
        for (XSSFName xSSFName : this.namedRanges) {
            int sheetIndex = xSSFName.getSheetIndex();
            if (sheetIndex != -1) {
                if (sheetIndex == i) {
                    xSSFName.setSheetIndex(i2);
                } else if (i2 <= sheetIndex && sheetIndex < i) {
                    xSSFName.setSheetIndex(sheetIndex + 1);
                } else if (i < sheetIndex && sheetIndex <= i2) {
                    xSSFName.setSheetIndex(sheetIndex - 1);
                }
            }
        }
    }

    private void updateActiveSheetAfterSheetReorder(int i, int i2) {
        int activeSheetIndex = getActiveSheetIndex();
        if (activeSheetIndex == i) {
            setActiveSheet(i2);
            return;
        }
        if (activeSheetIndex >= i || activeSheetIndex >= i2) {
            if (activeSheetIndex <= i || activeSheetIndex <= i2) {
                if (i2 > i) {
                    setActiveSheet(activeSheetIndex - 1);
                } else {
                    setActiveSheet(activeSheetIndex + 1);
                }
            }
        }
    }

    private void saveNamedRanges() {
        if (this.namedRanges.size() > 0) {
            CTDefinedNames cTDefinedNamesNewInstance = CTDefinedNames.Factory.newInstance();
            CTDefinedName[] cTDefinedNameArr = new CTDefinedName[this.namedRanges.size()];
            Iterator<XSSFName> it = this.namedRanges.iterator();
            int i = 0;
            while (it.hasNext()) {
                cTDefinedNameArr[i] = it.next().getCTName();
                i++;
            }
            cTDefinedNamesNewInstance.setDefinedNameArray(cTDefinedNameArr);
            if (this.workbook.isSetDefinedNames()) {
                this.workbook.unsetDefinedNames();
            }
            this.workbook.setDefinedNames(cTDefinedNamesNewInstance);
            reprocessNamedRanges();
            return;
        }
        if (this.workbook.isSetDefinedNames()) {
            this.workbook.unsetDefinedNames();
        }
    }

    private void reprocessNamedRanges() {
        this.namedRangesByName = new ArrayListValuedHashMap();
        this.namedRanges = new ArrayList();
        if (this.workbook.isSetDefinedNames()) {
            for (CTDefinedName cTDefinedName : this.workbook.getDefinedNames().getDefinedNameArray()) {
                createAndStoreName(cTDefinedName);
            }
        }
    }

    private void saveCalculationChain() {
        CalculationChain calculationChain = this.calcChain;
        if (calculationChain == null || calculationChain.getCTCalcChain().sizeOfCArray() != 0) {
            return;
        }
        removeRelation(this.calcChain);
        this.calcChain = null;
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        saveNamedRanges();
        saveCalculationChain();
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTWorkbook.type.getName().getNamespaceURI(), "workbook"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        this.workbook.save(outputStream, xmlOptions);
        outputStream.close();
    }

    @Internal
    public SharedStringsTable getSharedStringSource() {
        return this.sharedStringSource;
    }

    public StylesTable getStylesSource() {
        return this.stylesSource;
    }

    public ThemesTable getTheme() {
        StylesTable stylesTable = this.stylesSource;
        if (stylesTable == null) {
            return null;
        }
        return stylesTable.getTheme();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFCreationHelper getCreationHelper() {
        if (this._creationHelper == null) {
            this._creationHelper = new XSSFCreationHelper(this);
        }
        return this._creationHelper;
    }

    private boolean containsSheet(String str, int i) {
        CTSheet[] sheetArray = this.workbook.getSheets().getSheetArray();
        if (str.length() > 31) {
            str = str.substring(0, 31);
        }
        for (int i2 = 0; i2 < sheetArray.length; i2++) {
            String name = sheetArray[i2].getName();
            if (name.length() > 31) {
                name = name.substring(0, 31);
            }
            if (i != i2 && str.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    @Internal
    public boolean isDate1904() {
        CTWorkbookPr workbookPr = this.workbook.getWorkbookPr();
        return workbookPr != null && workbookPr.getDate1904();
    }

    @Override // org.apache.poi.POIXMLDocument
    public List<PackagePart> getAllEmbedds() throws OpenXML4JException {
        LinkedList linkedList = new LinkedList();
        for (XSSFSheet xSSFSheet : this.sheets) {
            Iterator<PackageRelationship> it = xSSFSheet.getPackagePart().getRelationshipsByType(XSSFRelation.OLEEMBEDDINGS.getRelation()).iterator();
            while (it.hasNext()) {
                linkedList.add(xSSFSheet.getPackagePart().getRelatedPart(it.next()));
            }
            Iterator<PackageRelationship> it2 = xSSFSheet.getPackagePart().getRelationshipsByType(XSSFRelation.PACKEMBEDDINGS.getRelation()).iterator();
            while (it2.hasNext()) {
                linkedList.add(xSSFSheet.getPackagePart().getRelatedPart(it2.next()));
            }
        }
        return linkedList;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @NotImplemented
    public boolean isHidden() {
        throw new RuntimeException("Not implemented yet");
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @NotImplemented
    public void setHidden(boolean z) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean isSheetHidden(int i) {
        validateSheetIndex(i);
        return this.sheets.get(i).sheet.getState() == STSheetState.HIDDEN;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean isSheetVeryHidden(int i) {
        validateSheetIndex(i);
        return this.sheets.get(i).sheet.getState() == STSheetState.VERY_HIDDEN;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public SheetVisibility getSheetVisibility(int i) {
        validateSheetIndex(i);
        STSheetState.Enum state = this.sheets.get(i).sheet.getState();
        if (state == STSheetState.VISIBLE) {
            return SheetVisibility.VISIBLE;
        }
        if (state == STSheetState.HIDDEN) {
            return SheetVisibility.HIDDEN;
        }
        if (state == STSheetState.VERY_HIDDEN) {
            return SheetVisibility.VERY_HIDDEN;
        }
        throw new IllegalArgumentException("This should never happen");
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetHidden(int i, boolean z) {
        setSheetVisibility(i, z ? SheetVisibility.HIDDEN : SheetVisibility.VISIBLE);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @Removal(version = "3.18")
    @Deprecated
    public void setSheetHidden(int i, int i2) {
        WorkbookUtil.validateSheetState(i2);
        setSheetVisibility(i, SheetVisibility.values()[i2]);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetVisibility(int i, SheetVisibility sheetVisibility) {
        validateSheetIndex(i);
        CTSheet cTSheet = this.sheets.get(i).sheet;
        int i2 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$SheetVisibility[sheetVisibility.ordinal()];
        if (i2 == 1) {
            cTSheet.setState(STSheetState.VISIBLE);
        } else if (i2 == 2) {
            cTSheet.setState(STSheetState.HIDDEN);
        } else {
            if (i2 == 3) {
                cTSheet.setState(STSheetState.VERY_HIDDEN);
                return;
            }
            throw new IllegalArgumentException("This should never happen");
        }
    }

    /* JADX INFO: renamed from: org.apache.poi.xssf.usermodel.XSSFWorkbook$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$SheetVisibility;

        static {
            int[] iArr = new int[SheetVisibility.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$SheetVisibility = iArr;
            try {
                iArr[SheetVisibility.VISIBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$SheetVisibility[SheetVisibility.HIDDEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$SheetVisibility[SheetVisibility.VERY_HIDDEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    protected void onDeleteFormula(XSSFCell xSSFCell) {
        if (this.calcChain != null) {
            this.calcChain.removeItem((int) xSSFCell.getSheet().sheet.getSheetId(), xSSFCell.getReference());
        }
    }

    @Internal
    public CalculationChain getCalculationChain() {
        return this.calcChain;
    }

    @Internal
    public List<ExternalLinksTable> getExternalLinksTable() {
        return this.externalLinks;
    }

    public Collection<XSSFMap> getCustomXMLMappings() {
        MapInfo mapInfo = this.mapInfo;
        return mapInfo == null ? new ArrayList() : mapInfo.getAllXSSFMaps();
    }

    @Internal
    public MapInfo getMapInfo() {
        return this.mapInfo;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @NotImplemented
    public int linkExternalWorkbook(String str, Workbook workbook) {
        throw new RuntimeException("Not Implemented - see bug #57184");
    }

    public boolean isStructureLocked() {
        return workbookProtectionPresent() && this.workbook.getWorkbookProtection().getLockStructure();
    }

    public boolean isWindowsLocked() {
        return workbookProtectionPresent() && this.workbook.getWorkbookProtection().getLockWindows();
    }

    public boolean isRevisionLocked() {
        return workbookProtectionPresent() && this.workbook.getWorkbookProtection().getLockRevision();
    }

    public void lockStructure() {
        safeGetWorkbookProtection().setLockStructure(true);
    }

    public void unLockStructure() {
        safeGetWorkbookProtection().setLockStructure(false);
    }

    public void lockWindows() {
        safeGetWorkbookProtection().setLockWindows(true);
    }

    public void unLockWindows() {
        safeGetWorkbookProtection().setLockWindows(false);
    }

    public void lockRevision() {
        safeGetWorkbookProtection().setLockRevision(true);
    }

    public void unLockRevision() {
        safeGetWorkbookProtection().setLockRevision(false);
    }

    public void setWorkbookPassword(String str, HashAlgorithm hashAlgorithm) {
        if (str != null || workbookProtectionPresent()) {
            XSSFPasswordHelper.setPassword(safeGetWorkbookProtection(), str, hashAlgorithm, "workbook");
        }
    }

    public boolean validateWorkbookPassword(String str) {
        if (workbookProtectionPresent()) {
            return XSSFPasswordHelper.validatePassword(safeGetWorkbookProtection(), str, "workbook");
        }
        return str == null;
    }

    public void setRevisionsPassword(String str, HashAlgorithm hashAlgorithm) {
        if (str != null || workbookProtectionPresent()) {
            XSSFPasswordHelper.setPassword(safeGetWorkbookProtection(), str, hashAlgorithm, "revisions");
        }
    }

    public boolean validateRevisionsPassword(String str) {
        if (workbookProtectionPresent()) {
            return XSSFPasswordHelper.validatePassword(safeGetWorkbookProtection(), str, "revisions");
        }
        return str == null;
    }

    public void unLock() {
        if (workbookProtectionPresent()) {
            this.workbook.unsetWorkbookProtection();
        }
    }

    private boolean workbookProtectionPresent() {
        return this.workbook.isSetWorkbookProtection();
    }

    private CTWorkbookProtection safeGetWorkbookProtection() {
        if (!workbookProtectionPresent()) {
            return this.workbook.addNewWorkbookProtection();
        }
        return this.workbook.getWorkbookProtection();
    }

    UDFFinder getUDFFinder() {
        return this._udfFinder;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void addToolPack(UDFFinder uDFFinder) {
        this._udfFinder.add(uDFFinder);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setForceFormulaRecalculation(boolean z) {
        CTWorkbook cTWorkbook = getCTWorkbook();
        CTCalcPr calcPr = cTWorkbook.isSetCalcPr() ? cTWorkbook.getCalcPr() : cTWorkbook.addNewCalcPr();
        calcPr.setCalcId(0L);
        if (z && calcPr.getCalcMode() == STCalcMode.MANUAL) {
            calcPr.setCalcMode(STCalcMode.AUTO);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean getForceFormulaRecalculation() {
        CTCalcPr calcPr = getCTWorkbook().getCalcPr();
        return (calcPr == null || calcPr.getCalcId() == 0) ? false : true;
    }

    protected CTPivotCache addPivotCache(String str) {
        CTPivotCaches cTPivotCachesAddNewPivotCaches;
        CTWorkbook cTWorkbook = getCTWorkbook();
        if (cTWorkbook.isSetPivotCaches()) {
            cTPivotCachesAddNewPivotCaches = cTWorkbook.getPivotCaches();
        } else {
            cTPivotCachesAddNewPivotCaches = cTWorkbook.addNewPivotCaches();
        }
        CTPivotCache cTPivotCacheAddNewPivotCache = cTPivotCachesAddNewPivotCaches.addNewPivotCache();
        cTPivotCacheAddNewPivotCache.setCacheId(getPivotTables().size() + 1);
        cTPivotCacheAddNewPivotCache.setId(str);
        if (this.pivotCaches == null) {
            this.pivotCaches = new ArrayList();
        }
        this.pivotCaches.add(cTPivotCacheAddNewPivotCache);
        return cTPivotCacheAddNewPivotCache;
    }

    public List<XSSFPivotTable> getPivotTables() {
        return this.pivotTables;
    }

    protected void setPivotTables(List<XSSFPivotTable> list) {
        this.pivotTables = list;
    }

    public XSSFWorkbookType getWorkbookType() {
        return isMacroEnabled() ? XSSFWorkbookType.XLSM : XSSFWorkbookType.XLSX;
    }

    public void setWorkbookType(XSSFWorkbookType xSSFWorkbookType) {
        try {
            getPackagePart().setContentType(xSSFWorkbookType.getContentType());
        } catch (InvalidFormatException e) {
            throw new POIXMLException(e);
        }
    }

    public void setVBAProject(InputStream inputStream) throws IOException {
        OutputStream outputStream;
        if (!isMacroEnabled()) {
            setWorkbookType(XSSFWorkbookType.XLSM);
        }
        try {
            PackagePartName packagePartNameCreatePartName = PackagingURIHelper.createPartName(XSSFRelation.VBA_MACROS.getDefaultFileName());
            OPCPackage oPCPackage = getPackage();
            if (!oPCPackage.containPart(packagePartNameCreatePartName)) {
                outputStream = createRelationship(XSSFRelation.VBA_MACROS, XSSFFactory.getInstance()).getPackagePart().getOutputStream();
            } else {
                outputStream = oPCPackage.getPart(packagePartNameCreatePartName).getOutputStream();
            }
            try {
                IOUtils.copy(inputStream, outputStream);
            } finally {
                IOUtils.closeQuietly(outputStream);
            }
        } catch (InvalidFormatException e) {
            throw new POIXMLException(e);
        }
    }

    public void setVBAProject(XSSFWorkbook xSSFWorkbook) throws InvalidFormatException, IOException {
        InputStream contents;
        if (xSSFWorkbook.isMacroEnabled() && (contents = XSSFRelation.VBA_MACROS.getContents(xSSFWorkbook.getCorePart())) != null) {
            setVBAProject(contents);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public SpreadsheetVersion getSpreadsheetVersion() {
        return SpreadsheetVersion.EXCEL2007;
    }

    public XSSFTable getTable(String str) {
        List<XSSFSheet> list;
        if (str == null || (list = this.sheets) == null) {
            return null;
        }
        Iterator<XSSFSheet> it = list.iterator();
        while (it.hasNext()) {
            for (XSSFTable xSSFTable : it.next().getTables()) {
                if (str.equalsIgnoreCase(xSSFTable.getName())) {
                    return xSSFTable;
                }
            }
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int addOlePackage(byte[] bArr, String str, String str2, String str3) throws IOException {
        PackagePartName packagePartNameCreatePartName;
        OPCPackage oPCPackage = getPackage();
        int i = 0;
        do {
            try {
                i++;
                packagePartNameCreatePartName = PackagingURIHelper.createPartName("/xl/embeddings/oleObject" + i + ".bin");
            } catch (InvalidFormatException e) {
                throw new IOException("ole object name not recognized", e);
            }
        } while (oPCPackage.containPart(packagePartNameCreatePartName));
        PackagePart packagePartCreatePart = oPCPackage.createPart(packagePartNameCreatePartName, "application/vnd.openxmlformats-officedocument.oleObject");
        Ole10Native ole10Native = new Ole10Native(str, str2, str3, bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length + 500);
        ole10Native.writeOut(byteArrayOutputStream);
        POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem();
        DirectoryNode root = pOIFSFileSystem.getRoot();
        root.createDocument(Ole10Native.OLE10_NATIVE, new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        root.setStorageClsid(ClassID.OLE10_PACKAGE);
        OutputStream outputStream = packagePartCreatePart.getOutputStream();
        pOIFSFileSystem.writeFilesystem(outputStream);
        outputStream.close();
        pOIFSFileSystem.close();
        return i;
    }
}
