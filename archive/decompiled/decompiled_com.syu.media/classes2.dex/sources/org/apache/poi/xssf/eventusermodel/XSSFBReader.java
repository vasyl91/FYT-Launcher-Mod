package org.apache.poi.xssf.eventusermodel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.xssf.binary.XSSFBCommentsTable;
import org.apache.poi.xssf.binary.XSSFBParseException;
import org.apache.poi.xssf.binary.XSSFBParser;
import org.apache.poi.xssf.binary.XSSFBRecordType;
import org.apache.poi.xssf.binary.XSSFBRelation;
import org.apache.poi.xssf.binary.XSSFBStylesTable;
import org.apache.poi.xssf.binary.XSSFBUtils;
import org.apache.poi.xssf.model.CommentsTable;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFBReader extends XSSFReader {
    private static final POILogger log = POILogFactory.getLogger((Class<?>) XSSFBReader.class);
    private static final Set<String> WORKSHEET_RELS = Collections.unmodifiableSet(new HashSet(Arrays.asList(XSSFRelation.WORKSHEET.getRelation(), XSSFRelation.CHARTSHEET.getRelation(), XSSFRelation.MACRO_SHEET_BIN.getRelation(), XSSFRelation.INTL_MACRO_SHEET_BIN.getRelation(), XSSFRelation.DIALOG_SHEET_BIN.getRelation())));

    public XSSFBReader(OPCPackage oPCPackage) throws OpenXML4JException, IOException {
        super(oPCPackage);
    }

    public String getAbsPathMetadata() throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = this.workbookPart.getInputStream();
            PathExtractor pathExtractor = new PathExtractor(this.workbookPart.getInputStream());
            pathExtractor.parse();
            return pathExtractor.getPath();
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    @Override // org.apache.poi.xssf.eventusermodel.XSSFReader
    public Iterator<InputStream> getSheetsData() throws InvalidFormatException, IOException {
        return new SheetIterator(this.workbookPart);
    }

    public XSSFBStylesTable getXSSFBStylesTable() throws IOException {
        ArrayList<PackagePart> partsByContentType = this.pkg.getPartsByContentType(XSSFBRelation.STYLES_BINARY.getContentType());
        if (partsByContentType.size() == 0) {
            return null;
        }
        return new XSSFBStylesTable(partsByContentType.get(0).getInputStream());
    }

    public static class SheetIterator extends XSSFReader.SheetIterator {
        private SheetIterator(PackagePart packagePart) throws IOException {
            super(packagePart);
        }

        @Override // org.apache.poi.xssf.eventusermodel.XSSFReader.SheetIterator
        Set<String> getSheetRelationships() {
            return XSSFBReader.WORKSHEET_RELS;
        }

        @Override // org.apache.poi.xssf.eventusermodel.XSSFReader.SheetIterator
        Iterator<XSSFReader.XSSFSheetRef> createSheetIteratorFromWB(PackagePart packagePart) throws IOException {
            SheetRefLoader sheetRefLoader = new SheetRefLoader(packagePart.getInputStream());
            sheetRefLoader.parse();
            return sheetRefLoader.getSheets().iterator();
        }

        @Override // org.apache.poi.xssf.eventusermodel.XSSFReader.SheetIterator
        public CommentsTable getSheetComments() {
            throw new IllegalArgumentException("Please use getXSSFBSheetComments");
        }

        public XSSFBCommentsTable getXSSFBSheetComments() {
            PackageRelationship relationship;
            PackagePart sheetPart = getSheetPart();
            try {
                PackageRelationshipCollection relationshipsByType = sheetPart.getRelationshipsByType(XSSFRelation.SHEET_COMMENTS.getRelation());
                if (relationshipsByType.size() > 0 && (relationship = relationshipsByType.getRelationship(0)) != null && relationship.getTargetURI() != null) {
                    return new XSSFBCommentsTable(sheetPart.getPackage().getPart(PackagingURIHelper.createPartName(relationship.getTargetURI())).getInputStream());
                }
            } catch (IOException | InvalidFormatException unused) {
            }
            return null;
        }
    }

    private static class PathExtractor extends XSSFBParser {
        private static BitSet RECORDS;
        private String path;

        static {
            BitSet bitSet = new BitSet();
            RECORDS = bitSet;
            bitSet.set(XSSFBRecordType.BrtAbsPath15.getId());
        }

        public PathExtractor(InputStream inputStream) {
            super(inputStream, RECORDS);
            this.path = null;
        }

        @Override // org.apache.poi.xssf.binary.XSSFBParser
        public void handleRecord(int i, byte[] bArr) throws XSSFBParseException {
            if (i != XSSFBRecordType.BrtAbsPath15.getId()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            XSSFBUtils.readXLWideString(bArr, 0, sb);
            this.path = sb.toString();
        }

        String getPath() {
            return this.path;
        }
    }

    private static class SheetRefLoader extends XSSFBParser {
        List<XSSFReader.XSSFSheetRef> sheets;

        private SheetRefLoader(InputStream inputStream) {
            super(inputStream);
            this.sheets = new LinkedList();
        }

        @Override // org.apache.poi.xssf.binary.XSSFBParser
        public void handleRecord(int i, byte[] bArr) throws XSSFBParseException {
            if (i == XSSFBRecordType.BrtBundleSh.getId()) {
                addWorksheet(bArr);
            }
        }

        private void addWorksheet(byte[] bArr) {
            try {
                tryToAddWorksheet(bArr);
            } catch (XSSFBParseException e) {
                if (tryOldFormat(bArr)) {
                    XSSFBReader.log.log(5, "This file was written with a beta version of Excel. POI will try to parse the file as a regular xlsb.");
                    return;
                }
                throw e;
            }
        }

        private void tryToAddWorksheet(byte[] bArr) throws XSSFBParseException {
            LittleEndian.getUInt(bArr, 0);
            long uInt = LittleEndian.getUInt(bArr, 4);
            if (uInt < 1 || uInt > 65535) {
                throw new XSSFBParseException("table id out of range: " + uInt);
            }
            StringBuilder sb = new StringBuilder();
            int xLWideString = 8 + XSSFBUtils.readXLWideString(bArr, 8, sb);
            String string = sb.toString();
            sb.setLength(0);
            XSSFBUtils.readXLWideString(bArr, xLWideString, sb);
            String string2 = sb.toString();
            if (string == null || string.trim().length() <= 0) {
                return;
            }
            this.sheets.add(new XSSFReader.XSSFSheetRef(string, string2));
        }

        private boolean tryOldFormat(byte[] bArr) throws XSSFBParseException {
            long uInt = LittleEndian.getUInt(bArr, 8);
            if (uInt < 1 || uInt > 65535) {
                throw new XSSFBParseException("table id out of range: " + uInt);
            }
            StringBuilder sb = new StringBuilder();
            int xLWideString = 12 + XSSFBUtils.readXLWideString(bArr, 12, sb);
            String string = sb.toString();
            sb.setLength(0);
            int xLWideString2 = xLWideString + XSSFBUtils.readXLWideString(bArr, xLWideString, sb);
            String string2 = sb.toString();
            if (string != null && string.trim().length() > 0) {
                this.sheets.add(new XSSFReader.XSSFSheetRef(string, string2));
            }
            return xLWideString2 == bArr.length;
        }

        List<XSSFReader.XSSFSheetRef> getSheets() {
            return this.sheets;
        }
    }
}
