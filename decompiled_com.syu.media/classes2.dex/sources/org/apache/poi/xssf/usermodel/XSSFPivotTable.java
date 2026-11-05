package org.apache.poi.xssf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataConsolidateFunction;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTLocation;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotTableDefinition;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotTableStyle;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRowFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheetSource;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STAxis;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataConsolidateFunction;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STItemType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFPivotTable extends POIXMLDocumentPart {
    protected static final short CREATED_VERSION = 3;
    protected static final short MIN_REFRESHABLE_VERSION = 3;
    protected static final short UPDATED_VERSION = 3;
    private Sheet dataSheet;
    private Sheet parentSheet;
    private XSSFPivotCache pivotCache;
    private XSSFPivotCacheDefinition pivotCacheDefinition;
    private XSSFPivotCacheRecords pivotCacheRecords;
    private CTPivotTableDefinition pivotTableDefinition;

    protected interface PivotTableReferenceConfigurator {
        void configureReference(CTWorksheetSource cTWorksheetSource);
    }

    protected XSSFPivotTable() {
        this.pivotTableDefinition = CTPivotTableDefinition.Factory.newInstance();
        this.pivotCache = new XSSFPivotCache();
        this.pivotCacheDefinition = new XSSFPivotCacheDefinition();
        this.pivotCacheRecords = new XSSFPivotCacheRecords();
    }

    protected XSSFPivotTable(PackagePart packagePart) throws IOException {
        super(packagePart);
        readFrom(packagePart.getInputStream());
    }

    public void readFrom(InputStream inputStream) throws IOException {
        try {
            XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
            xmlOptions.setLoadReplaceDocumentElement(null);
            this.pivotTableDefinition = CTPivotTableDefinition.Factory.parse(inputStream, xmlOptions);
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public void setPivotCache(XSSFPivotCache xSSFPivotCache) {
        this.pivotCache = xSSFPivotCache;
    }

    public XSSFPivotCache getPivotCache() {
        return this.pivotCache;
    }

    public Sheet getParentSheet() {
        return this.parentSheet;
    }

    public void setParentSheet(XSSFSheet xSSFSheet) {
        this.parentSheet = xSSFSheet;
    }

    @Internal
    public CTPivotTableDefinition getCTPivotTableDefinition() {
        return this.pivotTableDefinition;
    }

    @Internal
    public void setCTPivotTableDefinition(CTPivotTableDefinition cTPivotTableDefinition) {
        this.pivotTableDefinition = cTPivotTableDefinition;
    }

    public XSSFPivotCacheDefinition getPivotCacheDefinition() {
        return this.pivotCacheDefinition;
    }

    public void setPivotCacheDefinition(XSSFPivotCacheDefinition xSSFPivotCacheDefinition) {
        this.pivotCacheDefinition = xSSFPivotCacheDefinition;
    }

    public XSSFPivotCacheRecords getPivotCacheRecords() {
        return this.pivotCacheRecords;
    }

    public void setPivotCacheRecords(XSSFPivotCacheRecords xSSFPivotCacheRecords) {
        this.pivotCacheRecords = xSSFPivotCacheRecords;
    }

    public Sheet getDataSheet() {
        return this.dataSheet;
    }

    private void setDataSheet(Sheet sheet) {
        this.dataSheet = sheet;
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTPivotTableDefinition.type.getName().getNamespaceURI(), "pivotTableDefinition"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        this.pivotTableDefinition.save(outputStream, xmlOptions);
        outputStream.close();
    }

    protected void setDefaultPivotTableDefinition() {
        this.pivotTableDefinition.setMultipleFieldFilters(false);
        this.pivotTableDefinition.setIndent(0L);
        this.pivotTableDefinition.setCreatedVersion((short) 3);
        this.pivotTableDefinition.setMinRefreshableVersion((short) 3);
        this.pivotTableDefinition.setUpdatedVersion((short) 3);
        this.pivotTableDefinition.setItemPrintTitles(true);
        this.pivotTableDefinition.setUseAutoFormatting(true);
        this.pivotTableDefinition.setApplyNumberFormats(false);
        this.pivotTableDefinition.setApplyWidthHeightFormats(true);
        this.pivotTableDefinition.setApplyAlignmentFormats(false);
        this.pivotTableDefinition.setApplyPatternFormats(false);
        this.pivotTableDefinition.setApplyFontFormats(false);
        this.pivotTableDefinition.setApplyBorderFormats(false);
        this.pivotTableDefinition.setCacheId(this.pivotCache.getCTPivotCache().getCacheId());
        this.pivotTableDefinition.setName("PivotTable" + this.pivotTableDefinition.getCacheId());
        this.pivotTableDefinition.setDataCaption("Values");
        CTPivotTableStyle cTPivotTableStyleAddNewPivotTableStyleInfo = this.pivotTableDefinition.addNewPivotTableStyleInfo();
        cTPivotTableStyleAddNewPivotTableStyleInfo.setName("PivotStyleLight16");
        cTPivotTableStyleAddNewPivotTableStyleInfo.setShowLastColumn(true);
        cTPivotTableStyleAddNewPivotTableStyleInfo.setShowColStripes(false);
        cTPivotTableStyleAddNewPivotTableStyleInfo.setShowRowStripes(false);
        cTPivotTableStyleAddNewPivotTableStyleInfo.setShowColHeaders(true);
        cTPivotTableStyleAddNewPivotTableStyleInfo.setShowRowHeaders(true);
    }

    protected AreaReference getPivotArea() {
        return getPivotCacheDefinition().getPivotArea(getDataSheet().getWorkbook());
    }

    private void checkColumnIndex(int i) throws IndexOutOfBoundsException {
        AreaReference pivotArea = getPivotArea();
        int col = (pivotArea.getLastCell().getCol() - pivotArea.getFirstCell().getCol()) + 1;
        if (i < 0 || i >= col) {
            throw new IndexOutOfBoundsException("Column Index: " + i + ", Size: " + col);
        }
    }

    public void addRowLabel(int i) {
        CTRowFields cTRowFieldsAddNewRowFields;
        checkColumnIndex(i);
        AreaReference pivotArea = getPivotArea();
        int row = pivotArea.getLastCell().getRow() - pivotArea.getFirstCell().getRow();
        CTPivotFields pivotFields = this.pivotTableDefinition.getPivotFields();
        CTPivotField cTPivotFieldNewInstance = CTPivotField.Factory.newInstance();
        CTItems cTItemsAddNewItems = cTPivotFieldNewInstance.addNewItems();
        cTPivotFieldNewInstance.setAxis(STAxis.AXIS_ROW);
        cTPivotFieldNewInstance.setShowAll(false);
        for (int i2 = 0; i2 <= row; i2++) {
            cTItemsAddNewItems.addNewItem().setT(STItemType.DEFAULT);
        }
        cTItemsAddNewItems.setCount(cTItemsAddNewItems.sizeOfItemArray());
        pivotFields.setPivotFieldArray(i, cTPivotFieldNewInstance);
        if (this.pivotTableDefinition.getRowFields() != null) {
            cTRowFieldsAddNewRowFields = this.pivotTableDefinition.getRowFields();
        } else {
            cTRowFieldsAddNewRowFields = this.pivotTableDefinition.addNewRowFields();
        }
        cTRowFieldsAddNewRowFields.addNewField().setX(i);
        cTRowFieldsAddNewRowFields.setCount(cTRowFieldsAddNewRowFields.sizeOfFieldArray());
    }

    public List<Integer> getRowLabelColumns() {
        if (this.pivotTableDefinition.getRowFields() != null) {
            ArrayList arrayList = new ArrayList();
            for (CTField cTField : this.pivotTableDefinition.getRowFields().getFieldArray()) {
                arrayList.add(Integer.valueOf(cTField.getX()));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public void addColumnLabel(DataConsolidateFunction dataConsolidateFunction, int i, String str) {
        CTColFields cTColFieldsAddNewColFields;
        checkColumnIndex(i);
        addDataColumn(i, true);
        addDataField(dataConsolidateFunction, i, str);
        if (this.pivotTableDefinition.getDataFields().getCount() == 2) {
            if (this.pivotTableDefinition.getColFields() != null) {
                cTColFieldsAddNewColFields = this.pivotTableDefinition.getColFields();
            } else {
                cTColFieldsAddNewColFields = this.pivotTableDefinition.addNewColFields();
            }
            cTColFieldsAddNewColFields.addNewField().setX(-2);
            cTColFieldsAddNewColFields.setCount(cTColFieldsAddNewColFields.sizeOfFieldArray());
        }
    }

    public void addColumnLabel(DataConsolidateFunction dataConsolidateFunction, int i) {
        addColumnLabel(dataConsolidateFunction, i, dataConsolidateFunction.getName());
    }

    private void addDataField(DataConsolidateFunction dataConsolidateFunction, int i, String str) {
        CTDataFields cTDataFieldsAddNewDataFields;
        checkColumnIndex(i);
        AreaReference pivotArea = getPivotArea();
        if (this.pivotTableDefinition.getDataFields() != null) {
            cTDataFieldsAddNewDataFields = this.pivotTableDefinition.getDataFields();
        } else {
            cTDataFieldsAddNewDataFields = this.pivotTableDefinition.addNewDataFields();
        }
        CTDataField cTDataFieldAddNewDataField = cTDataFieldsAddNewDataFields.addNewDataField();
        cTDataFieldAddNewDataField.setSubtotal(STDataConsolidateFunction.Enum.forInt(dataConsolidateFunction.getValue()));
        getDataSheet().getRow(pivotArea.getFirstCell().getRow()).getCell(pivotArea.getFirstCell().getCol() + i).setCellType(CellType.STRING);
        cTDataFieldAddNewDataField.setName(str);
        cTDataFieldAddNewDataField.setFld(i);
        cTDataFieldsAddNewDataFields.setCount(cTDataFieldsAddNewDataFields.sizeOfDataFieldArray());
    }

    public void addDataColumn(int i, boolean z) {
        checkColumnIndex(i);
        CTPivotFields pivotFields = this.pivotTableDefinition.getPivotFields();
        CTPivotField cTPivotFieldNewInstance = CTPivotField.Factory.newInstance();
        cTPivotFieldNewInstance.setDataField(z);
        cTPivotFieldNewInstance.setShowAll(false);
        pivotFields.setPivotFieldArray(i, cTPivotFieldNewInstance);
    }

    public void addReportFilter(int i) {
        CTPageFields cTPageFieldsAddNewPageFields;
        checkColumnIndex(i);
        AreaReference pivotArea = getPivotArea();
        int row = pivotArea.getLastCell().getRow() - pivotArea.getFirstCell().getRow();
        CTPivotFields pivotFields = this.pivotTableDefinition.getPivotFields();
        CTPivotField cTPivotFieldNewInstance = CTPivotField.Factory.newInstance();
        CTItems cTItemsAddNewItems = cTPivotFieldNewInstance.addNewItems();
        cTPivotFieldNewInstance.setAxis(STAxis.AXIS_PAGE);
        cTPivotFieldNewInstance.setShowAll(false);
        for (int i2 = 0; i2 <= row; i2++) {
            cTItemsAddNewItems.addNewItem().setT(STItemType.DEFAULT);
        }
        cTItemsAddNewItems.setCount(cTItemsAddNewItems.sizeOfItemArray());
        pivotFields.setPivotFieldArray(i, cTPivotFieldNewInstance);
        if (this.pivotTableDefinition.getPageFields() != null) {
            cTPageFieldsAddNewPageFields = this.pivotTableDefinition.getPageFields();
            this.pivotTableDefinition.setMultipleFieldFilters(true);
        } else {
            cTPageFieldsAddNewPageFields = this.pivotTableDefinition.addNewPageFields();
        }
        CTPageField cTPageFieldAddNewPageField = cTPageFieldsAddNewPageFields.addNewPageField();
        cTPageFieldAddNewPageField.setHier(-1);
        cTPageFieldAddNewPageField.setFld(i);
        cTPageFieldsAddNewPageFields.setCount(cTPageFieldsAddNewPageFields.sizeOfPageFieldArray());
        this.pivotTableDefinition.getLocation().setColPageCount(cTPageFieldsAddNewPageFields.getCount());
    }

    protected void createSourceReferences(CellReference cellReference, Sheet sheet, PivotTableReferenceConfigurator pivotTableReferenceConfigurator) {
        CTLocation location;
        AreaReference areaReference = new AreaReference(cellReference, new CellReference(cellReference.getRow() + 1, cellReference.getCol() + 1), SpreadsheetVersion.EXCEL2007);
        if (this.pivotTableDefinition.getLocation() == null) {
            location = this.pivotTableDefinition.addNewLocation();
            location.setFirstDataCol(1L);
            location.setFirstDataRow(1L);
            location.setFirstHeaderRow(1L);
        } else {
            location = this.pivotTableDefinition.getLocation();
        }
        location.setRef(areaReference.formatAsString());
        this.pivotTableDefinition.setLocation(location);
        CTCacheSource cTCacheSourceAddNewCacheSource = getPivotCacheDefinition().getCTPivotCacheDefinition().addNewCacheSource();
        cTCacheSourceAddNewCacheSource.setType(STSourceType.WORKSHEET);
        CTWorksheetSource cTWorksheetSourceAddNewWorksheetSource = cTCacheSourceAddNewCacheSource.addNewWorksheetSource();
        cTWorksheetSourceAddNewWorksheetSource.setSheet(sheet.getSheetName());
        setDataSheet(sheet);
        pivotTableReferenceConfigurator.configureReference(cTWorksheetSourceAddNewWorksheetSource);
        if (cTWorksheetSourceAddNewWorksheetSource.getName() == null && cTWorksheetSourceAddNewWorksheetSource.getRef() == null) {
            throw new IllegalArgumentException("Pivot table source area reference or name must be specified.");
        }
    }

    protected void createDefaultDataColumns() {
        CTPivotFields cTPivotFieldsAddNewPivotFields;
        if (this.pivotTableDefinition.getPivotFields() != null) {
            cTPivotFieldsAddNewPivotFields = this.pivotTableDefinition.getPivotFields();
        } else {
            cTPivotFieldsAddNewPivotFields = this.pivotTableDefinition.addNewPivotFields();
        }
        AreaReference pivotArea = getPivotArea();
        short col = pivotArea.getLastCell().getCol();
        for (int col2 = pivotArea.getFirstCell().getCol(); col2 <= col; col2++) {
            CTPivotField cTPivotFieldAddNewPivotField = cTPivotFieldsAddNewPivotFields.addNewPivotField();
            cTPivotFieldAddNewPivotField.setDataField(false);
            cTPivotFieldAddNewPivotField.setShowAll(false);
        }
        cTPivotFieldsAddNewPivotFields.setCount(cTPivotFieldsAddNewPivotFields.sizeOfPivotFieldArray());
    }
}
