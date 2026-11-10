package org.apache.poi.hssf.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.record.CRNCountRecord;
import org.apache.poi.hssf.record.CRNRecord;
import org.apache.poi.hssf.record.ExternSheetRecord;
import org.apache.poi.hssf.record.ExternalNameRecord;
import org.apache.poi.hssf.record.NameCommentRecord;
import org.apache.poi.hssf.record.NameRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.SupBookRecord;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.ss.formula.ptg.ErrPtg;
import org.apache.poi.ss.formula.ptg.NameXPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.Workbook;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class LinkTable {
    private final List<NameRecord> _definedNames;
    private final ExternSheetRecord _externSheetRecord;
    private ExternalBookBlock[] _externalBookBlocks;
    private final int _recordCount;
    private final WorkbookRecordList _workbookRecordList;

    private static final class CRNBlock {
        private final CRNCountRecord _countRecord;
        private final CRNRecord[] _crns;

        public CRNBlock(RecordStream recordStream) {
            CRNCountRecord cRNCountRecord = (CRNCountRecord) recordStream.getNext();
            this._countRecord = cRNCountRecord;
            int numberOfCRNs = cRNCountRecord.getNumberOfCRNs();
            CRNRecord[] cRNRecordArr = new CRNRecord[numberOfCRNs];
            for (int i = 0; i < numberOfCRNs; i++) {
                cRNRecordArr[i] = (CRNRecord) recordStream.getNext();
            }
            this._crns = cRNRecordArr;
        }

        public CRNRecord[] getCrns() {
            return (CRNRecord[]) this._crns.clone();
        }
    }

    private static final class ExternalBookBlock {
        private final CRNBlock[] _crnBlocks;
        private final SupBookRecord _externalBookRecord;
        private ExternalNameRecord[] _externalNameRecords;

        public ExternalBookBlock(RecordStream recordStream) {
            this._externalBookRecord = (SupBookRecord) recordStream.getNext();
            ArrayList arrayList = new ArrayList();
            while (recordStream.peekNextClass() == ExternalNameRecord.class) {
                arrayList.add(recordStream.getNext());
            }
            ExternalNameRecord[] externalNameRecordArr = new ExternalNameRecord[arrayList.size()];
            this._externalNameRecords = externalNameRecordArr;
            arrayList.toArray(externalNameRecordArr);
            arrayList.clear();
            while (recordStream.peekNextClass() == CRNCountRecord.class) {
                arrayList.add(new CRNBlock(recordStream));
            }
            CRNBlock[] cRNBlockArr = new CRNBlock[arrayList.size()];
            this._crnBlocks = cRNBlockArr;
            arrayList.toArray(cRNBlockArr);
        }

        public ExternalBookBlock(String str, String[] strArr) {
            this._externalBookRecord = SupBookRecord.createExternalReferences(str, strArr);
            this._crnBlocks = new CRNBlock[0];
        }

        public ExternalBookBlock(int i) {
            this._externalBookRecord = SupBookRecord.createInternalReferences((short) i);
            this._externalNameRecords = new ExternalNameRecord[0];
            this._crnBlocks = new CRNBlock[0];
        }

        public ExternalBookBlock() {
            this._externalBookRecord = SupBookRecord.createAddInFunctions();
            this._externalNameRecords = new ExternalNameRecord[0];
            this._crnBlocks = new CRNBlock[0];
        }

        public SupBookRecord getExternalBookRecord() {
            return this._externalBookRecord;
        }

        public String getNameText(int i) {
            return this._externalNameRecords[i].getText();
        }

        public int getNameIx(int i) {
            return this._externalNameRecords[i].getIx();
        }

        public int getIndexOfName(String str) {
            int i = 0;
            while (true) {
                ExternalNameRecord[] externalNameRecordArr = this._externalNameRecords;
                if (i >= externalNameRecordArr.length) {
                    return -1;
                }
                if (externalNameRecordArr[i].getText().equalsIgnoreCase(str)) {
                    return i;
                }
                i++;
            }
        }

        public int getNumberOfNames() {
            return this._externalNameRecords.length;
        }

        public int addExternalName(ExternalNameRecord externalNameRecord) {
            ExternalNameRecord[] externalNameRecordArr = this._externalNameRecords;
            int length = externalNameRecordArr.length + 1;
            ExternalNameRecord[] externalNameRecordArr2 = new ExternalNameRecord[length];
            System.arraycopy(externalNameRecordArr, 0, externalNameRecordArr2, 0, externalNameRecordArr.length);
            externalNameRecordArr2[length - 1] = externalNameRecord;
            this._externalNameRecords = externalNameRecordArr2;
            return externalNameRecordArr2.length - 1;
        }
    }

    public LinkTable(List<Record> list, int i, WorkbookRecordList workbookRecordList, Map<String, NameCommentRecord> map) {
        this._workbookRecordList = workbookRecordList;
        RecordStream recordStream = new RecordStream(list, i);
        ArrayList arrayList = new ArrayList();
        while (recordStream.peekNextClass() == SupBookRecord.class) {
            arrayList.add(new ExternalBookBlock(recordStream));
        }
        ExternalBookBlock[] externalBookBlockArr = new ExternalBookBlock[arrayList.size()];
        this._externalBookBlocks = externalBookBlockArr;
        arrayList.toArray(externalBookBlockArr);
        arrayList.clear();
        if (this._externalBookBlocks.length <= 0 || recordStream.peekNextClass() != ExternSheetRecord.class) {
            this._externSheetRecord = null;
        } else {
            this._externSheetRecord = readExtSheetRecord(recordStream);
        }
        this._definedNames = new ArrayList();
        while (true) {
            Class<? extends Record> clsPeekNextClass = recordStream.peekNextClass();
            if (clsPeekNextClass == NameRecord.class) {
                this._definedNames.add((NameRecord) recordStream.getNext());
            } else if (clsPeekNextClass == NameCommentRecord.class) {
                NameCommentRecord nameCommentRecord = (NameCommentRecord) recordStream.getNext();
                map.put(nameCommentRecord.getNameText(), nameCommentRecord);
            } else {
                int countRead = recordStream.getCountRead();
                this._recordCount = countRead;
                this._workbookRecordList.getRecords().addAll(list.subList(i, countRead + i));
                return;
            }
        }
    }

    private static ExternSheetRecord readExtSheetRecord(RecordStream recordStream) {
        ArrayList arrayList = new ArrayList(2);
        while (recordStream.peekNextClass() == ExternSheetRecord.class) {
            arrayList.add((ExternSheetRecord) recordStream.getNext());
        }
        int size = arrayList.size();
        if (size < 1) {
            throw new RuntimeException("Expected an EXTERNSHEET record but got (" + recordStream.peekNextClass().getName() + ")");
        }
        if (size == 1) {
            return (ExternSheetRecord) arrayList.get(0);
        }
        ExternSheetRecord[] externSheetRecordArr = new ExternSheetRecord[size];
        arrayList.toArray(externSheetRecordArr);
        return ExternSheetRecord.combine(externSheetRecordArr);
    }

    public LinkTable(int i, WorkbookRecordList workbookRecordList) {
        this._workbookRecordList = workbookRecordList;
        this._definedNames = new ArrayList();
        this._externalBookBlocks = new ExternalBookBlock[]{new ExternalBookBlock(i)};
        ExternSheetRecord externSheetRecord = new ExternSheetRecord();
        this._externSheetRecord = externSheetRecord;
        this._recordCount = 2;
        Record externalBookRecord = this._externalBookBlocks[0].getExternalBookRecord();
        int iFindFirstRecordLocBySid = findFirstRecordLocBySid((short) 140);
        if (iFindFirstRecordLocBySid < 0) {
            throw new RuntimeException("CountryRecord not found");
        }
        int i2 = iFindFirstRecordLocBySid + 1;
        workbookRecordList.add(i2, externSheetRecord);
        workbookRecordList.add(i2, externalBookRecord);
    }

    public int getRecordCount() {
        return this._recordCount;
    }

    public NameRecord getSpecificBuiltinRecord(byte b, int i) {
        for (NameRecord nameRecord : this._definedNames) {
            if (nameRecord.getBuiltInName() == b && nameRecord.getSheetNumber() == i) {
                return nameRecord;
            }
        }
        return null;
    }

    public void removeBuiltinRecord(byte b, int i) {
        NameRecord specificBuiltinRecord = getSpecificBuiltinRecord(b, i);
        if (specificBuiltinRecord != null) {
            this._definedNames.remove(specificBuiltinRecord);
        }
    }

    public int getNumNames() {
        return this._definedNames.size();
    }

    public NameRecord getNameRecord(int i) {
        return this._definedNames.get(i);
    }

    public void addName(NameRecord nameRecord) {
        this._definedNames.add(nameRecord);
        int iFindFirstRecordLocBySid = findFirstRecordLocBySid((short) 23);
        if (iFindFirstRecordLocBySid == -1) {
            iFindFirstRecordLocBySid = findFirstRecordLocBySid(SupBookRecord.sid);
        }
        if (iFindFirstRecordLocBySid == -1) {
            iFindFirstRecordLocBySid = findFirstRecordLocBySid((short) 140);
        }
        this._workbookRecordList.add(iFindFirstRecordLocBySid + this._definedNames.size(), nameRecord);
    }

    public void removeName(int i) {
        this._definedNames.remove(i);
    }

    public boolean nameAlreadyExists(NameRecord nameRecord) {
        for (int numNames = getNumNames() - 1; numNames >= 0; numNames--) {
            NameRecord nameRecord2 = getNameRecord(numNames);
            if (nameRecord2 != nameRecord && isDuplicatedNames(nameRecord, nameRecord2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDuplicatedNames(NameRecord nameRecord, NameRecord nameRecord2) {
        return nameRecord2.getNameText().equalsIgnoreCase(nameRecord.getNameText()) && isSameSheetNames(nameRecord, nameRecord2);
    }

    private static boolean isSameSheetNames(NameRecord nameRecord, NameRecord nameRecord2) {
        return nameRecord2.getSheetNumber() == nameRecord.getSheetNumber();
    }

    public String[] getExternalBookAndSheetName(int i) {
        SupBookRecord externalBookRecord = this._externalBookBlocks[this._externSheetRecord.getExtbookIndexFromRefIndex(i)].getExternalBookRecord();
        if (!externalBookRecord.isExternalReferences()) {
            return null;
        }
        int firstSheetIndexFromRefIndex = this._externSheetRecord.getFirstSheetIndexFromRefIndex(i);
        int lastSheetIndexFromRefIndex = this._externSheetRecord.getLastSheetIndexFromRefIndex(i);
        String str = firstSheetIndexFromRefIndex >= 0 ? externalBookRecord.getSheetNames()[firstSheetIndexFromRefIndex] : null;
        return firstSheetIndexFromRefIndex == lastSheetIndexFromRefIndex ? new String[]{externalBookRecord.getURL(), str} : new String[]{externalBookRecord.getURL(), str, lastSheetIndexFromRefIndex >= 0 ? externalBookRecord.getSheetNames()[lastSheetIndexFromRefIndex] : null};
    }

    private int getExternalWorkbookIndex(String str) {
        int i = 0;
        while (true) {
            ExternalBookBlock[] externalBookBlockArr = this._externalBookBlocks;
            if (i >= externalBookBlockArr.length) {
                return -1;
            }
            SupBookRecord externalBookRecord = externalBookBlockArr[i].getExternalBookRecord();
            if (externalBookRecord.isExternalReferences() && str.equals(externalBookRecord.getURL())) {
                return i;
            }
            i++;
        }
    }

    public int linkExternalWorkbook(String str, Workbook workbook) {
        int externalWorkbookIndex = getExternalWorkbookIndex(str);
        if (externalWorkbookIndex != -1) {
            return externalWorkbookIndex;
        }
        int numberOfSheets = workbook.getNumberOfSheets();
        String[] strArr = new String[numberOfSheets];
        for (int i = 0; i < numberOfSheets; i++) {
            strArr[i] = workbook.getSheetName(i);
        }
        ExternalBookBlock externalBookBlock = new ExternalBookBlock("\u0000" + str, strArr);
        int iExtendExternalBookBlocks = extendExternalBookBlocks(externalBookBlock);
        int iFindFirstRecordLocBySid = findFirstRecordLocBySid((short) 23);
        if (iFindFirstRecordLocBySid == -1) {
            iFindFirstRecordLocBySid = this._workbookRecordList.size();
        }
        this._workbookRecordList.add(iFindFirstRecordLocBySid, externalBookBlock.getExternalBookRecord());
        for (int i2 = 0; i2 < numberOfSheets; i2++) {
            this._externSheetRecord.addRef(iExtendExternalBookBlocks, i2, i2);
        }
        return iExtendExternalBookBlocks;
    }

    public int getExternalSheetIndex(String str, String str2, String str3) {
        int externalWorkbookIndex = getExternalWorkbookIndex(str);
        if (externalWorkbookIndex == -1) {
            throw new RuntimeException("No external workbook with name '" + str + "'");
        }
        SupBookRecord externalBookRecord = this._externalBookBlocks[externalWorkbookIndex].getExternalBookRecord();
        int sheetIndex = getSheetIndex(externalBookRecord.getSheetNames(), str2);
        int sheetIndex2 = getSheetIndex(externalBookRecord.getSheetNames(), str3);
        int refIxForSheet = this._externSheetRecord.getRefIxForSheet(externalWorkbookIndex, sheetIndex, sheetIndex2);
        return refIxForSheet < 0 ? this._externSheetRecord.addRef(externalWorkbookIndex, sheetIndex, sheetIndex2) : refIxForSheet;
    }

    private static int getSheetIndex(String[] strArr, String str) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(str)) {
                return i;
            }
        }
        throw new RuntimeException("External workbook does not contain sheet '" + str + "'");
    }

    public int getFirstInternalSheetIndexForExtIndex(int i) {
        if (i >= this._externSheetRecord.getNumOfRefs() || i < 0) {
            return -1;
        }
        return this._externSheetRecord.getFirstSheetIndexFromRefIndex(i);
    }

    public int getLastInternalSheetIndexForExtIndex(int i) {
        if (i >= this._externSheetRecord.getNumOfRefs() || i < 0) {
            return -1;
        }
        return this._externSheetRecord.getLastSheetIndexFromRefIndex(i);
    }

    public void removeSheet(int i) {
        this._externSheetRecord.removeSheet(i);
    }

    public int checkExternSheet(int i) {
        return checkExternSheet(i, i);
    }

    public int checkExternSheet(int i, int i2) {
        int i3 = 0;
        while (true) {
            ExternalBookBlock[] externalBookBlockArr = this._externalBookBlocks;
            if (i3 >= externalBookBlockArr.length) {
                i3 = -1;
                break;
            }
            if (externalBookBlockArr[i3].getExternalBookRecord().isInternalReferences()) {
                break;
            }
            i3++;
        }
        if (i3 < 0) {
            throw new RuntimeException("Could not find 'internal references' EXTERNALBOOK");
        }
        int refIxForSheet = this._externSheetRecord.getRefIxForSheet(i3, i, i2);
        return refIxForSheet >= 0 ? refIxForSheet : this._externSheetRecord.addRef(i3, i, i2);
    }

    private int findFirstRecordLocBySid(short s) {
        Iterator<Record> it = this._workbookRecordList.getRecords().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getSid() == s) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public String resolveNameXText(int i, int i2, InternalWorkbook internalWorkbook) {
        int extbookIndexFromRefIndex = this._externSheetRecord.getExtbookIndexFromRefIndex(i);
        int firstSheetIndexFromRefIndex = this._externSheetRecord.getFirstSheetIndexFromRefIndex(i);
        if (firstSheetIndexFromRefIndex != -1) {
            if (this._externalBookBlocks[extbookIndexFromRefIndex]._externalNameRecords.length > i2) {
                return this._externalBookBlocks[extbookIndexFromRefIndex].getNameText(i2);
            }
            if (firstSheetIndexFromRefIndex == -2) {
                NameRecord nameRecord = getNameRecord(i2);
                int sheetNumber = nameRecord.getSheetNumber();
                StringBuffer stringBuffer = new StringBuffer();
                if (sheetNumber > 0) {
                    SheetNameFormatter.appendFormat(stringBuffer, internalWorkbook.getSheetName(sheetNumber - 1));
                    stringBuffer.append("!");
                }
                stringBuffer.append(nameRecord.getNameText());
                return stringBuffer.toString();
            }
            throw new ArrayIndexOutOfBoundsException("Ext Book Index relative but beyond the supported length, was " + extbookIndexFromRefIndex + " but maximum is " + this._externalBookBlocks.length);
        }
        throw new RuntimeException("Referenced sheet could not be found");
    }

    public int resolveNameXIx(int i, int i2) {
        return this._externalBookBlocks[this._externSheetRecord.getExtbookIndexFromRefIndex(i)].getNameIx(i2);
    }

    public NameXPtg getNameXPtg(String str, int i) {
        int iFindRefIndexFromExtBookIndex;
        int i2 = 0;
        while (true) {
            ExternalBookBlock[] externalBookBlockArr = this._externalBookBlocks;
            if (i2 >= externalBookBlockArr.length) {
                return null;
            }
            int indexOfName = externalBookBlockArr[i2].getIndexOfName(str);
            if (indexOfName >= 0 && (iFindRefIndexFromExtBookIndex = findRefIndexFromExtBookIndex(i2)) >= 0 && (i == -1 || iFindRefIndexFromExtBookIndex == i)) {
                return new NameXPtg(iFindRefIndexFromExtBookIndex, indexOfName);
            }
            i2++;
        }
    }

    public NameXPtg addNameXPtg(String str) {
        ExternalBookBlock externalBookBlock;
        int i = 0;
        int iExtendExternalBookBlocks = 0;
        while (true) {
            ExternalBookBlock[] externalBookBlockArr = this._externalBookBlocks;
            if (iExtendExternalBookBlocks >= externalBookBlockArr.length) {
                iExtendExternalBookBlocks = -1;
                externalBookBlock = null;
                break;
            }
            if (externalBookBlockArr[iExtendExternalBookBlocks].getExternalBookRecord().isAddInFunctions()) {
                externalBookBlock = this._externalBookBlocks[iExtendExternalBookBlocks];
                break;
            }
            iExtendExternalBookBlocks++;
        }
        if (externalBookBlock == null) {
            externalBookBlock = new ExternalBookBlock();
            iExtendExternalBookBlocks = extendExternalBookBlocks(externalBookBlock);
            this._workbookRecordList.add(findFirstRecordLocBySid((short) 23), externalBookBlock.getExternalBookRecord());
            this._externSheetRecord.addRef(this._externalBookBlocks.length - 1, -2, -2);
        }
        ExternalNameRecord externalNameRecord = new ExternalNameRecord();
        externalNameRecord.setText(str);
        externalNameRecord.setParsedExpression(new Ptg[]{ErrPtg.REF_INVALID});
        int iAddExternalName = externalBookBlock.addExternalName(externalNameRecord);
        for (Record record : this._workbookRecordList.getRecords()) {
            if ((record instanceof SupBookRecord) && ((SupBookRecord) record).isAddInFunctions()) {
                break;
            }
            i++;
        }
        this._workbookRecordList.add(i + externalBookBlock.getNumberOfNames(), externalNameRecord);
        return new NameXPtg(this._externSheetRecord.getRefIxForSheet(iExtendExternalBookBlocks, -2, -2), iAddExternalName);
    }

    private int extendExternalBookBlocks(ExternalBookBlock externalBookBlock) {
        ExternalBookBlock[] externalBookBlockArr = this._externalBookBlocks;
        int length = externalBookBlockArr.length + 1;
        ExternalBookBlock[] externalBookBlockArr2 = new ExternalBookBlock[length];
        System.arraycopy(externalBookBlockArr, 0, externalBookBlockArr2, 0, externalBookBlockArr.length);
        externalBookBlockArr2[length - 1] = externalBookBlock;
        this._externalBookBlocks = externalBookBlockArr2;
        return externalBookBlockArr2.length - 1;
    }

    private int findRefIndexFromExtBookIndex(int i) {
        return this._externSheetRecord.findRefIndexFromExtBookIndex(i);
    }

    public boolean changeExternalReference(String str, String str2) {
        for (ExternalBookBlock externalBookBlock : this._externalBookBlocks) {
            SupBookRecord externalBookRecord = externalBookBlock.getExternalBookRecord();
            if (externalBookRecord.isExternalReferences() && externalBookRecord.getURL().equals(str)) {
                externalBookRecord.setURL(str2);
                return true;
            }
        }
        return false;
    }
}
