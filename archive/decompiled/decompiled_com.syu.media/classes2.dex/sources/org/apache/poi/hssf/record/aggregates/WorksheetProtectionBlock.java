package org.apache.poi.hssf.record.aggregates;

import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.ObjectProtectRecord;
import org.apache.poi.hssf.record.PasswordRecord;
import org.apache.poi.hssf.record.ProtectRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.ScenarioProtectRecord;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class WorksheetProtectionBlock extends RecordAggregate {
    private ObjectProtectRecord _objectProtectRecord;
    private PasswordRecord _passwordRecord;
    private ProtectRecord _protectRecord;
    private ScenarioProtectRecord _scenarioProtectRecord;

    public static boolean isComponentRecord(int i) {
        return i == 18 || i == 19 || i == 99 || i == 221;
    }

    private boolean readARecord(RecordStream recordStream) {
        int iPeekNextSid = recordStream.peekNextSid();
        if (iPeekNextSid == 18) {
            checkNotPresent(this._protectRecord);
            this._protectRecord = (ProtectRecord) recordStream.getNext();
            return true;
        }
        if (iPeekNextSid == 19) {
            checkNotPresent(this._passwordRecord);
            this._passwordRecord = (PasswordRecord) recordStream.getNext();
            return true;
        }
        if (iPeekNextSid == 99) {
            checkNotPresent(this._objectProtectRecord);
            this._objectProtectRecord = (ObjectProtectRecord) recordStream.getNext();
            return true;
        }
        if (iPeekNextSid != 221) {
            return false;
        }
        checkNotPresent(this._scenarioProtectRecord);
        this._scenarioProtectRecord = (ScenarioProtectRecord) recordStream.getNext();
        return true;
    }

    private void checkNotPresent(Record record) {
        if (record != null) {
            throw new RecordFormatException("Duplicate PageSettingsBlock record (sid=0x" + Integer.toHexString(record.getSid()) + ")");
        }
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor recordVisitor) {
        visitIfPresent(this._protectRecord, recordVisitor);
        visitIfPresent(this._objectProtectRecord, recordVisitor);
        visitIfPresent(this._scenarioProtectRecord, recordVisitor);
        visitIfPresent(this._passwordRecord, recordVisitor);
    }

    private static void visitIfPresent(Record record, RecordAggregate.RecordVisitor recordVisitor) {
        if (record != null) {
            recordVisitor.visitRecord(record);
        }
    }

    public PasswordRecord getPasswordRecord() {
        return this._passwordRecord;
    }

    public ScenarioProtectRecord getHCenter() {
        return this._scenarioProtectRecord;
    }

    public void addRecords(RecordStream recordStream) {
        while (readARecord(recordStream)) {
        }
    }

    private ProtectRecord getProtect() {
        if (this._protectRecord == null) {
            this._protectRecord = new ProtectRecord(false);
        }
        return this._protectRecord;
    }

    private PasswordRecord getPassword() {
        if (this._passwordRecord == null) {
            this._passwordRecord = createPassword();
        }
        return this._passwordRecord;
    }

    public void protectSheet(String str, boolean z, boolean z2) {
        if (str == null) {
            this._passwordRecord = null;
            this._protectRecord = null;
            this._objectProtectRecord = null;
            this._scenarioProtectRecord = null;
            return;
        }
        ProtectRecord protect = getProtect();
        PasswordRecord password = getPassword();
        protect.setProtect(true);
        password.setPassword((short) CryptoFunctions.createXorVerifier1(str));
        if (this._objectProtectRecord == null && z) {
            ObjectProtectRecord objectProtectRecordCreateObjectProtect = createObjectProtect();
            objectProtectRecordCreateObjectProtect.setProtect(true);
            this._objectProtectRecord = objectProtectRecordCreateObjectProtect;
        }
        if (this._scenarioProtectRecord == null && z2) {
            ScenarioProtectRecord scenarioProtectRecordCreateScenarioProtect = createScenarioProtect();
            scenarioProtectRecordCreateScenarioProtect.setProtect(true);
            this._scenarioProtectRecord = scenarioProtectRecordCreateScenarioProtect;
        }
    }

    public boolean isSheetProtected() {
        ProtectRecord protectRecord = this._protectRecord;
        return protectRecord != null && protectRecord.getProtect();
    }

    public boolean isObjectProtected() {
        ObjectProtectRecord objectProtectRecord = this._objectProtectRecord;
        return objectProtectRecord != null && objectProtectRecord.getProtect();
    }

    public boolean isScenarioProtected() {
        ScenarioProtectRecord scenarioProtectRecord = this._scenarioProtectRecord;
        return scenarioProtectRecord != null && scenarioProtectRecord.getProtect();
    }

    private static ObjectProtectRecord createObjectProtect() {
        ObjectProtectRecord objectProtectRecord = new ObjectProtectRecord();
        objectProtectRecord.setProtect(false);
        return objectProtectRecord;
    }

    private static ScenarioProtectRecord createScenarioProtect() {
        ScenarioProtectRecord scenarioProtectRecord = new ScenarioProtectRecord();
        scenarioProtectRecord.setProtect(false);
        return scenarioProtectRecord;
    }

    private static PasswordRecord createPassword() {
        return new PasswordRecord(0);
    }

    public int getPasswordHash() {
        PasswordRecord passwordRecord = this._passwordRecord;
        if (passwordRecord == null) {
            return 0;
        }
        return passwordRecord.getPassword();
    }
}
