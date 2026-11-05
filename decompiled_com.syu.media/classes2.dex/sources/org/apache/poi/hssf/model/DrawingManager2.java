package org.apache.poi.hssf.model;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ddf.EscherDgRecord;
import org.apache.poi.ddf.EscherDggRecord;
import org.apache.poi.util.Removal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DrawingManager2 {
    private final EscherDggRecord dgg;
    private final List<EscherDgRecord> drawingGroups = new ArrayList();

    public DrawingManager2(EscherDggRecord escherDggRecord) {
        this.dgg = escherDggRecord;
    }

    public void clearDrawingGroups() {
        this.drawingGroups.clear();
    }

    public EscherDgRecord createDgRecord() {
        EscherDgRecord escherDgRecord = new EscherDgRecord();
        escherDgRecord.setRecordId(EscherDgRecord.RECORD_ID);
        short sFindNewDrawingGroupId = findNewDrawingGroupId();
        escherDgRecord.setOptions((short) (sFindNewDrawingGroupId << 4));
        escherDgRecord.setNumShapes(0);
        escherDgRecord.setLastMSOSPID(-1);
        this.drawingGroups.add(escherDgRecord);
        this.dgg.addCluster(sFindNewDrawingGroupId, 0);
        EscherDggRecord escherDggRecord = this.dgg;
        escherDggRecord.setDrawingsSaved(escherDggRecord.getDrawingsSaved() + 1);
        return escherDgRecord;
    }

    @Removal(version = "4.0")
    @Deprecated
    public int allocateShapeId(short s) {
        for (EscherDgRecord escherDgRecord : this.drawingGroups) {
            if (escherDgRecord.getDrawingGroupId() == s) {
                return allocateShapeId(escherDgRecord);
            }
        }
        throw new IllegalStateException("Drawing group id " + ((int) s) + " doesn't exist.");
    }

    @Removal(version = "4.0")
    @Deprecated
    public int allocateShapeId(short s, EscherDgRecord escherDgRecord) {
        return allocateShapeId(escherDgRecord);
    }

    public int allocateShapeId(EscherDgRecord escherDgRecord) {
        return this.dgg.allocateShapeId(escherDgRecord, true);
    }

    public short findNewDrawingGroupId() {
        return this.dgg.findNewDrawingGroupId();
    }

    public EscherDggRecord getDgg() {
        return this.dgg;
    }

    public void incrementDrawingsSaved() {
        EscherDggRecord escherDggRecord = this.dgg;
        escherDggRecord.setDrawingsSaved(escherDggRecord.getDrawingsSaved() + 1);
    }
}
