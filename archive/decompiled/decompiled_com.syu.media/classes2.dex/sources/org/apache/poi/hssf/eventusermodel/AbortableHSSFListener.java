package org.apache.poi.hssf.eventusermodel;

import org.apache.poi.hssf.record.Record;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class AbortableHSSFListener implements HSSFListener {
    public abstract short abortableProcessRecord(Record record) throws HSSFUserException;

    @Override // org.apache.poi.hssf.eventusermodel.HSSFListener
    public void processRecord(Record record) {
    }
}
