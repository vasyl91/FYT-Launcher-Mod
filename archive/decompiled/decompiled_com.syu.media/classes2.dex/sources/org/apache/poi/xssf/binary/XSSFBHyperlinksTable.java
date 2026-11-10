package org.apache.poi.xssf.binary;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeUtil;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public class XSSFBHyperlinksTable {
    private static final BitSet RECORDS;
    private final List<XSSFHyperlinkRecord> hyperlinkRecords = new ArrayList();
    private Map<String, String> relIdToHyperlink = new HashMap();

    static {
        BitSet bitSet = new BitSet();
        RECORDS = bitSet;
        bitSet.set(XSSFBRecordType.BrtHLink.getId());
    }

    public XSSFBHyperlinksTable(PackagePart packagePart) throws IOException {
        loadUrlsFromSheetRels(packagePart);
        new HyperlinkSheetScraper(packagePart.getInputStream()).parse();
    }

    public Map<CellAddress, List<XSSFHyperlinkRecord>> getHyperLinks() {
        TreeMap treeMap = new TreeMap(new TopLeftCellAddressComparator());
        for (XSSFHyperlinkRecord xSSFHyperlinkRecord : this.hyperlinkRecords) {
            CellAddress cellAddress = new CellAddress(xSSFHyperlinkRecord.getCellRangeAddress().getFirstRow(), xSSFHyperlinkRecord.getCellRangeAddress().getFirstColumn());
            List arrayList = (List) treeMap.get(cellAddress);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(xSSFHyperlinkRecord);
            treeMap.put(cellAddress, arrayList);
        }
        return treeMap;
    }

    public List<XSSFHyperlinkRecord> findHyperlinkRecord(CellAddress cellAddress) {
        CellRangeAddress cellRangeAddress = new CellRangeAddress(cellAddress.getRow(), cellAddress.getRow(), cellAddress.getColumn(), cellAddress.getColumn());
        ArrayList arrayList = null;
        for (XSSFHyperlinkRecord xSSFHyperlinkRecord : this.hyperlinkRecords) {
            if (CellRangeUtil.intersect(cellRangeAddress, xSSFHyperlinkRecord.getCellRangeAddress()) != 1) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(xSSFHyperlinkRecord);
            }
        }
        return arrayList;
    }

    private void loadUrlsFromSheetRels(PackagePart packagePart) {
        try {
            for (PackageRelationship packageRelationship : packagePart.getRelationshipsByType(XSSFRelation.SHEET_HYPERLINKS.getRelation())) {
                this.relIdToHyperlink.put(packageRelationship.getId(), packageRelationship.getTargetURI().toString());
            }
        } catch (InvalidFormatException unused) {
        }
    }

    private class HyperlinkSheetScraper extends XSSFBParser {
        private XSSFBCellRange hyperlinkCellRange;
        private final StringBuilder xlWideStringBuffer;

        HyperlinkSheetScraper(InputStream inputStream) {
            super(inputStream, XSSFBHyperlinksTable.RECORDS);
            this.hyperlinkCellRange = new XSSFBCellRange();
            this.xlWideStringBuffer = new StringBuilder();
        }

        @Override // org.apache.poi.xssf.binary.XSSFBParser
        public void handleRecord(int i, byte[] bArr) throws XSSFBParseException {
            if (i != XSSFBRecordType.BrtHLink.getId()) {
                return;
            }
            this.hyperlinkCellRange = XSSFBCellRange.parse(bArr, 0, this.hyperlinkCellRange);
            this.xlWideStringBuffer.setLength(0);
            int xLNullableWideString = 16 + XSSFBUtils.readXLNullableWideString(bArr, 16, this.xlWideStringBuffer);
            String string = this.xlWideStringBuffer.toString();
            this.xlWideStringBuffer.setLength(0);
            int xLWideString = xLNullableWideString + XSSFBUtils.readXLWideString(bArr, xLNullableWideString, this.xlWideStringBuffer);
            String string2 = this.xlWideStringBuffer.toString();
            this.xlWideStringBuffer.setLength(0);
            int xLWideString2 = xLWideString + XSSFBUtils.readXLWideString(bArr, xLWideString, this.xlWideStringBuffer);
            String string3 = this.xlWideStringBuffer.toString();
            this.xlWideStringBuffer.setLength(0);
            XSSFBUtils.readXLWideString(bArr, xLWideString2, this.xlWideStringBuffer);
            XSSFBHyperlinksTable.this.hyperlinkRecords.add(new XSSFHyperlinkRecord(new CellRangeAddress(this.hyperlinkCellRange.firstRow, this.hyperlinkCellRange.lastRow, this.hyperlinkCellRange.firstCol, this.hyperlinkCellRange.lastCol), string, (string2 == null || string2.length() == 0) ? (String) XSSFBHyperlinksTable.this.relIdToHyperlink.get(string) : string2, string3, this.xlWideStringBuffer.toString()));
        }
    }

    private static class TopLeftCellAddressComparator implements Comparator<CellAddress>, Serializable {
        private static final long serialVersionUID = 1;

        private TopLeftCellAddressComparator() {
        }

        @Override // java.util.Comparator
        public int compare(CellAddress cellAddress, CellAddress cellAddress2) {
            if (cellAddress.getRow() < cellAddress2.getRow()) {
                return -1;
            }
            if (cellAddress.getRow() > cellAddress2.getRow()) {
                return 1;
            }
            if (cellAddress.getColumn() < cellAddress2.getColumn()) {
                return -1;
            }
            return cellAddress.getColumn() > cellAddress2.getColumn() ? 1 : 0;
        }
    }
}
