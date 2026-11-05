package org.apache.poi.hssf.record;

import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class RecordFactoryInputStream {
    private int _bofDepth;
    private DrawingRecord _lastDrawingRecord = new DrawingRecord();
    private Record _lastRecord;
    private boolean _lastRecordWasEOFLevelZero;
    private final RecordInputStream _recStream;
    private final boolean _shouldIncludeContinueRecords;
    private Record[] _unreadRecordBuffer;
    private int _unreadRecordIndex;

    private static final class StreamEncryptionInfo {
        private final FilePassRecord _filePassRec;
        private final boolean _hasBOFRecord;
        private final int _initialRecordsSize;
        private final Record _lastRecord;

        public StreamEncryptionInfo(RecordInputStream recordInputStream, List<Record> list) {
            recordInputStream.nextRecord();
            int iRemaining = recordInputStream.remaining() + 4;
            Record recordCreateSingleRecord = RecordFactory.createSingleRecord(recordInputStream);
            list.add(recordCreateSingleRecord);
            FilePassRecord filePassRecord = null;
            if (recordCreateSingleRecord instanceof BOFRecord) {
                this._hasBOFRecord = true;
                if (recordInputStream.hasNextRecord()) {
                    recordInputStream.nextRecord();
                    recordCreateSingleRecord = RecordFactory.createSingleRecord(recordInputStream);
                    iRemaining += recordCreateSingleRecord.getRecordSize();
                    list.add(recordCreateSingleRecord);
                    if ((recordCreateSingleRecord instanceof WriteProtectRecord) && recordInputStream.hasNextRecord()) {
                        recordInputStream.nextRecord();
                        Record recordCreateSingleRecord2 = RecordFactory.createSingleRecord(recordInputStream);
                        iRemaining += recordCreateSingleRecord2.getRecordSize();
                        list.add(recordCreateSingleRecord2);
                        recordCreateSingleRecord = recordCreateSingleRecord2;
                    }
                    filePassRecord = recordCreateSingleRecord instanceof FilePassRecord ? (FilePassRecord) recordCreateSingleRecord : null;
                    if (recordCreateSingleRecord instanceof EOFRecord) {
                        throw new IllegalStateException("Nothing between BOF and EOF");
                    }
                }
            } else {
                this._hasBOFRecord = false;
            }
            this._initialRecordsSize = iRemaining;
            this._filePassRec = filePassRecord;
            this._lastRecord = recordCreateSingleRecord;
        }

        public RecordInputStream createDecryptingStream(InputStream inputStream) {
            FilePassRecord filePassRecord = this._filePassRec;
            String currentUserPassword = Biff8EncryptionKey.getCurrentUserPassword();
            if (currentUserPassword == null) {
                currentUserPassword = Decryptor.DEFAULT_PASSWORD;
            }
            EncryptionInfo encryptionInfo = filePassRecord.getEncryptionInfo();
            try {
                if (!encryptionInfo.getDecryptor().verifyPassword(currentUserPassword)) {
                    throw new EncryptedDocumentException((Decryptor.DEFAULT_PASSWORD.equals(currentUserPassword) ? "Default" : "Supplied") + " password is invalid for salt/verifier/verifierHash");
                }
                return new RecordInputStream(inputStream, encryptionInfo, this._initialRecordsSize);
            } catch (GeneralSecurityException e) {
                throw new EncryptedDocumentException(e);
            }
        }

        public boolean hasEncryption() {
            return this._filePassRec != null;
        }

        public Record getLastRecord() {
            return this._lastRecord;
        }

        public boolean hasBOFRecord() {
            return this._hasBOFRecord;
        }
    }

    public RecordFactoryInputStream(InputStream inputStream, boolean z) {
        this._unreadRecordIndex = -1;
        this._lastRecord = null;
        RecordInputStream recordInputStream = new RecordInputStream(inputStream);
        ArrayList arrayList = new ArrayList();
        StreamEncryptionInfo streamEncryptionInfo = new StreamEncryptionInfo(recordInputStream, arrayList);
        recordInputStream = streamEncryptionInfo.hasEncryption() ? streamEncryptionInfo.createDecryptingStream(inputStream) : recordInputStream;
        if (!arrayList.isEmpty()) {
            Record[] recordArr = new Record[arrayList.size()];
            this._unreadRecordBuffer = recordArr;
            arrayList.toArray(recordArr);
            this._unreadRecordIndex = 0;
        }
        this._recStream = recordInputStream;
        this._shouldIncludeContinueRecords = z;
        this._lastRecord = streamEncryptionInfo.getLastRecord();
        this._bofDepth = streamEncryptionInfo.hasBOFRecord() ? 1 : 0;
        this._lastRecordWasEOFLevelZero = false;
    }

    public Record nextRecord() {
        Record nextUnreadRecord = getNextUnreadRecord();
        if (nextUnreadRecord != null) {
            return nextUnreadRecord;
        }
        while (this._recStream.hasNextRecord()) {
            if (this._lastRecordWasEOFLevelZero && this._recStream.getNextSid() != 2057) {
                return null;
            }
            this._recStream.nextRecord();
            Record nextRecord = readNextRecord();
            if (nextRecord != null) {
                return nextRecord;
            }
        }
        return null;
    }

    private Record getNextUnreadRecord() {
        Record[] recordArr = this._unreadRecordBuffer;
        if (recordArr != null) {
            int i = this._unreadRecordIndex;
            if (i < recordArr.length) {
                Record record = recordArr[i];
                this._unreadRecordIndex = i + 1;
                return record;
            }
            this._unreadRecordIndex = -1;
            this._unreadRecordBuffer = null;
        }
        return null;
    }

    private Record readNextRecord() {
        Record recordCreateSingleRecord = RecordFactory.createSingleRecord(this._recStream);
        this._lastRecordWasEOFLevelZero = false;
        if (recordCreateSingleRecord instanceof BOFRecord) {
            this._bofDepth++;
            return recordCreateSingleRecord;
        }
        if (recordCreateSingleRecord instanceof EOFRecord) {
            int i = this._bofDepth - 1;
            this._bofDepth = i;
            if (i < 1) {
                this._lastRecordWasEOFLevelZero = true;
            }
            return recordCreateSingleRecord;
        }
        if (recordCreateSingleRecord instanceof DBCellRecord) {
            return null;
        }
        if (recordCreateSingleRecord instanceof RKRecord) {
            return RecordFactory.convertToNumberRecord((RKRecord) recordCreateSingleRecord);
        }
        if (recordCreateSingleRecord instanceof MulRKRecord) {
            NumberRecord[] numberRecordArrConvertRKRecords = RecordFactory.convertRKRecords((MulRKRecord) recordCreateSingleRecord);
            this._unreadRecordBuffer = numberRecordArrConvertRKRecords;
            this._unreadRecordIndex = 1;
            return numberRecordArrConvertRKRecords[0];
        }
        if (recordCreateSingleRecord.getSid() == 235) {
            Record record = this._lastRecord;
            if (record instanceof DrawingGroupRecord) {
                ((DrawingGroupRecord) record).join((AbstractEscherHolderRecord) recordCreateSingleRecord);
                return null;
            }
        }
        if (recordCreateSingleRecord.getSid() == 60) {
            ContinueRecord continueRecord = (ContinueRecord) recordCreateSingleRecord;
            Record record2 = this._lastRecord;
            if ((record2 instanceof ObjRecord) || (record2 instanceof TextObjectRecord)) {
                this._lastDrawingRecord.processContinueRecord(continueRecord.getData());
                if (this._shouldIncludeContinueRecords) {
                    return recordCreateSingleRecord;
                }
                return null;
            }
            if (record2 instanceof DrawingGroupRecord) {
                ((DrawingGroupRecord) record2).processContinueRecord(continueRecord.getData());
                return null;
            }
            if (record2 instanceof DrawingRecord) {
                return continueRecord;
            }
            if ((record2 instanceof UnknownRecord) || (record2 instanceof EOFRecord)) {
                return recordCreateSingleRecord;
            }
            throw new RecordFormatException("Unhandled Continue Record followining " + this._lastRecord.getClass());
        }
        this._lastRecord = recordCreateSingleRecord;
        if (recordCreateSingleRecord instanceof DrawingRecord) {
            this._lastDrawingRecord = (DrawingRecord) recordCreateSingleRecord;
        }
        return recordCreateSingleRecord;
    }
}
