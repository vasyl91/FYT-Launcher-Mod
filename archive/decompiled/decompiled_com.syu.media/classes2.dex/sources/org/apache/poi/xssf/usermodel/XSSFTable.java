package org.apache.poi.xssf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Table;
import org.apache.poi.ss.usermodel.TableStyleInfo;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.Internal;
import org.apache.poi.util.StringUtil;
import org.apache.poi.xssf.usermodel.helpers.XSSFXmlColumnPr;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.TableDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFTable extends POIXMLDocumentPart implements Table {
    private transient HashMap<String, Integer> columnMap;
    private transient String commonXPath;
    private transient CTTableColumn[] ctColumns;
    private CTTable ctTable;
    private transient CellReference endCellReference;
    private transient String name;
    private transient CellReference startCellReference;
    private transient String styleName;
    private transient List<XSSFXmlColumnPr> xmlColumnPr;

    public XSSFTable() {
        this.ctTable = CTTable.Factory.newInstance();
    }

    public XSSFTable(PackagePart packagePart) throws IOException {
        super(packagePart);
        readFrom(packagePart.getInputStream());
    }

    public void readFrom(InputStream inputStream) throws IOException {
        try {
            this.ctTable = TableDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getTable();
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public XSSFSheet getXSSFSheet() {
        return (XSSFSheet) getParent();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        updateHeaders();
        TableDocument tableDocumentNewInstance = TableDocument.Factory.newInstance();
        tableDocumentNewInstance.setTable(this.ctTable);
        tableDocumentNewInstance.save(outputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        writeTo(outputStream);
        outputStream.close();
    }

    @Internal(since = "POI 3.15 beta 3")
    public CTTable getCTTable() {
        return this.ctTable;
    }

    public boolean mapsTo(long j) {
        Iterator<XSSFXmlColumnPr> it = getXmlColumnPrs().iterator();
        while (it.hasNext()) {
            if (it.next().getMapId() == j) {
                return true;
            }
        }
        return false;
    }

    private CTTableColumn[] getTableColumns() {
        if (this.ctColumns == null) {
            this.ctColumns = this.ctTable.getTableColumns().getTableColumnArray();
        }
        return this.ctColumns;
    }

    public String getCommonXpath() {
        if (this.commonXPath == null) {
            String[] strArr = new String[0];
            for (CTTableColumn cTTableColumn : getTableColumns()) {
                if (cTTableColumn.getXmlColumnPr() != null) {
                    String[] strArrSplit = cTTableColumn.getXmlColumnPr().getXpath().split("/");
                    if (strArr.length == 0) {
                        strArr = strArrSplit;
                    } else {
                        int iMin = Math.min(strArr.length, strArrSplit.length);
                        for (int i = 0; i < iMin; i++) {
                            if (!strArr[i].equals(strArrSplit[i])) {
                                strArr = (String[]) Arrays.asList(strArr).subList(0, i).toArray(new String[0]);
                                break;
                            }
                        }
                    }
                }
            }
            strArr[0] = "";
            this.commonXPath = StringUtil.join(strArr, "/");
        }
        return this.commonXPath;
    }

    public List<XSSFXmlColumnPr> getXmlColumnPrs() {
        if (this.xmlColumnPr == null) {
            this.xmlColumnPr = new ArrayList();
            for (CTTableColumn cTTableColumn : getTableColumns()) {
                if (cTTableColumn.getXmlColumnPr() != null) {
                    this.xmlColumnPr.add(new XSSFXmlColumnPr(this, cTTableColumn, cTTableColumn.getXmlColumnPr()));
                }
            }
        }
        return this.xmlColumnPr;
    }

    @Internal("Return type likely to change")
    public void addColumn() {
        CTTableColumns tableColumns = this.ctTable.getTableColumns();
        if (tableColumns == null) {
            tableColumns = this.ctTable.addNewTableColumns();
        }
        CTTableColumn cTTableColumnAddNewTableColumn = tableColumns.addNewTableColumn();
        long jSizeOfTableColumnArray = tableColumns.sizeOfTableColumnArray();
        tableColumns.setCount(jSizeOfTableColumnArray);
        cTTableColumnAddNewTableColumn.setId(jSizeOfTableColumnArray);
        updateHeaders();
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public String getName() {
        if (this.name == null) {
            setName(this.ctTable.getName());
        }
        return this.name;
    }

    public void setName(String str) {
        if (str == null) {
            this.ctTable.unsetName();
            this.name = null;
        } else {
            this.ctTable.setName(str);
            this.name = str;
        }
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public String getStyleName() {
        if (this.styleName == null && this.ctTable.isSetTableStyleInfo()) {
            setStyleName(this.ctTable.getTableStyleInfo().getName());
        }
        return this.styleName;
    }

    public void setStyleName(String str) {
        if (str == null) {
            if (this.ctTable.isSetTableStyleInfo()) {
                this.ctTable.getTableStyleInfo().unsetName();
            }
            this.styleName = null;
        } else {
            if (!this.ctTable.isSetTableStyleInfo()) {
                this.ctTable.addNewTableStyleInfo();
            }
            this.ctTable.getTableStyleInfo().setName(str);
            this.styleName = str;
        }
    }

    public String getDisplayName() {
        return this.ctTable.getDisplayName();
    }

    public void setDisplayName(String str) {
        this.ctTable.setDisplayName(str);
    }

    public long getNumberOfMappedColumns() {
        return this.ctTable.getTableColumns().getCount();
    }

    public long getNumerOfMappedColumns() {
        return getNumberOfMappedColumns();
    }

    public AreaReference getCellReferences() {
        return new AreaReference(getStartCellReference(), getEndCellReference(), SpreadsheetVersion.EXCEL2007);
    }

    public void setCellReferences(AreaReference areaReference) {
        String asString = areaReference.formatAsString();
        if (asString.indexOf(33) != -1) {
            asString = asString.substring(asString.indexOf(33) + 1);
        }
        this.ctTable.setRef(asString);
        if (this.ctTable.isSetAutoFilter()) {
            this.ctTable.getAutoFilter().setRef(asString);
        }
        updateReferences();
        updateHeaders();
    }

    public CellReference getStartCellReference() {
        if (this.startCellReference == null) {
            setCellReferences();
        }
        return this.startCellReference;
    }

    public CellReference getEndCellReference() {
        if (this.endCellReference == null) {
            setCellReferences();
        }
        return this.endCellReference;
    }

    private void setCellReferences() {
        String ref = this.ctTable.getRef();
        if (ref != null) {
            String[] strArrSplit = ref.split(":", 2);
            String str = strArrSplit[0];
            String str2 = strArrSplit[1];
            this.startCellReference = new CellReference(str);
            this.endCellReference = new CellReference(str2);
        }
    }

    public void updateReferences() {
        this.startCellReference = null;
        this.endCellReference = null;
    }

    public int getRowCount() {
        CellReference startCellReference = getStartCellReference();
        CellReference endCellReference = getEndCellReference();
        if (startCellReference == null || endCellReference == null) {
            return 0;
        }
        return (endCellReference.getRow() - startCellReference.getRow()) + 1;
    }

    public void updateHeaders() {
        XSSFSheet xSSFSheet = (XSSFSheet) getParent();
        CellReference startCellReference = getStartCellReference();
        if (startCellReference == null) {
            return;
        }
        int row = startCellReference.getRow();
        int col = startCellReference.getCol();
        XSSFRow row2 = xSSFSheet.getRow(row);
        DataFormatter dataFormatter = new DataFormatter();
        if (row2 == null || !row2.getCTRow().validate()) {
            return;
        }
        for (CTTableColumn cTTableColumn : getCTTable().getTableColumns().getTableColumnArray()) {
            XSSFCell cell = row2.getCell(col);
            if (cell != null) {
                cTTableColumn.setName(dataFormatter.formatCellValue(cell));
            }
            col++;
        }
        this.ctColumns = null;
        this.columnMap = null;
        this.xmlColumnPr = null;
        this.commonXPath = null;
    }

    private static String caseInsensitive(String str) {
        return str.toUpperCase(Locale.ROOT);
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public int findColumnIndex(String str) {
        if (str == null) {
            return -1;
        }
        if (this.columnMap == null) {
            this.columnMap = new HashMap<>((getTableColumns().length * 3) / 2);
            int i = 0;
            for (CTTableColumn cTTableColumn : getTableColumns()) {
                this.columnMap.put(caseInsensitive(cTTableColumn.getName()), Integer.valueOf(i));
                i++;
            }
        }
        Integer num = this.columnMap.get(caseInsensitive(str.replace("'", "")));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public String getSheetName() {
        return getXSSFSheet().getSheetName();
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public boolean isHasTotalsRow() {
        return this.ctTable.getTotalsRowShown();
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public int getTotalsRowCount() {
        return (int) this.ctTable.getTotalsRowCount();
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public int getHeaderRowCount() {
        return (int) this.ctTable.getHeaderRowCount();
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public int getStartColIndex() {
        return getStartCellReference().getCol();
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public int getStartRowIndex() {
        return getStartCellReference().getRow();
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public int getEndColIndex() {
        return getEndCellReference().getCol();
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public int getEndRowIndex() {
        return getEndCellReference().getRow();
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public TableStyleInfo getStyle() {
        if (this.ctTable.isSetTableStyleInfo()) {
            return new XSSFTableStyleInfo(((XSSFSheet) getParent()).getWorkbook().getStylesSource(), this.ctTable.getTableStyleInfo());
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public boolean contains(Cell cell) {
        return cell != null && getSheetName().equals(cell.getSheet().getSheetName()) && cell.getRowIndex() >= getStartRowIndex() && cell.getRowIndex() <= getEndRowIndex() && cell.getColumnIndex() >= getStartColIndex() && cell.getColumnIndex() <= getEndColIndex();
    }

    protected void onTableDelete() {
        Iterator<POIXMLDocumentPart.RelationPart> it = getRelationParts().iterator();
        while (it.hasNext()) {
            removeRelation(it.next().getDocumentPart(), true);
        }
    }
}
