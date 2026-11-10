package org.apache.poi.hssf.usermodel;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import module.canbus.FinalCanbus;
import org.apache.poi.ddf.EscherClientDataRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
import org.apache.poi.hssf.record.EmbeddedObjectRefSubRecord;
import org.apache.poi.hssf.record.EscherAggregate;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.SubRecord;
import org.apache.poi.hssf.record.TextObjectRecord;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HSSFShapeFactory {
    public static void createShapeTree(EscherContainerRecord escherContainerRecord, EscherAggregate escherAggregate, HSSFShapeContainer hSSFShapeContainer, DirectoryNode directoryNode) {
        HSSFShape hSSFSimpleShape;
        EscherOptRecord escherOptRecord;
        ObjRecord objRecord = null;
        if (escherContainerRecord.getRecordId() == -4093) {
            EscherClientDataRecord escherClientDataRecord = (EscherClientDataRecord) ((EscherContainerRecord) escherContainerRecord.getChild(0)).getChildById(EscherClientDataRecord.RECORD_ID);
            HSSFShapeGroup hSSFShapeGroup = new HSSFShapeGroup(escherContainerRecord, escherClientDataRecord != null ? (ObjRecord) escherAggregate.getShapeToObjMapping().get(escherClientDataRecord) : null);
            List<EscherContainerRecord> childContainers = escherContainerRecord.getChildContainers();
            for (int i = 0; i < childContainers.size(); i++) {
                EscherContainerRecord escherContainerRecord2 = childContainers.get(i);
                if (i != 0) {
                    createShapeTree(escherContainerRecord2, escherAggregate, hSSFShapeGroup, directoryNode);
                }
            }
            hSSFShapeContainer.addShape(hSSFShapeGroup);
            return;
        }
        if (escherContainerRecord.getRecordId() == -4092) {
            Map<EscherRecord, Record> shapeToObjMapping = escherAggregate.getShapeToObjMapping();
            TextObjectRecord textObjectRecord = null;
            for (EscherRecord escherRecord : escherContainerRecord) {
                short recordId = escherRecord.getRecordId();
                if (recordId == -4083) {
                    textObjectRecord = (TextObjectRecord) shapeToObjMapping.get(escherRecord);
                } else if (recordId == -4079) {
                    objRecord = (ObjRecord) shapeToObjMapping.get(escherRecord);
                }
            }
            if (objRecord == null) {
                throw new RecordFormatException("EscherClientDataRecord can't be found.");
            }
            if (isEmbeddedObject(objRecord)) {
                hSSFShapeContainer.addShape(new HSSFObjectData(escherContainerRecord, objRecord, directoryNode));
                return;
            }
            short objectType = ((CommonObjectDataSubRecord) objRecord.getSubRecords().get(0)).getObjectType();
            if (objectType == 1) {
                hSSFSimpleShape = new HSSFSimpleShape(escherContainerRecord, objRecord);
            } else if (objectType == 2) {
                hSSFSimpleShape = new HSSFSimpleShape(escherContainerRecord, objRecord, textObjectRecord);
            } else if (objectType == 6) {
                hSSFSimpleShape = new HSSFTextbox(escherContainerRecord, objRecord, textObjectRecord);
            } else if (objectType == 8) {
                hSSFSimpleShape = new HSSFPicture(escherContainerRecord, objRecord);
            } else if (objectType == 20) {
                hSSFSimpleShape = new HSSFCombobox(escherContainerRecord, objRecord);
            } else if (objectType != 25) {
                if (objectType == 30 && (escherOptRecord = (EscherOptRecord) escherContainerRecord.getChildById(EscherOptRecord.RECORD_ID)) != null && escherOptRecord.lookup(FinalCanbus.CAR_DJ_WC1_MZD_CX5) != null) {
                    hSSFSimpleShape = new HSSFPolygon(escherContainerRecord, objRecord, textObjectRecord);
                } else {
                    hSSFSimpleShape = new HSSFSimpleShape(escherContainerRecord, objRecord, textObjectRecord);
                }
            } else {
                hSSFSimpleShape = new HSSFComment(escherContainerRecord, objRecord, textObjectRecord, escherAggregate.getNoteRecordByObj(objRecord));
            }
            hSSFShapeContainer.addShape(hSSFSimpleShape);
        }
    }

    private static boolean isEmbeddedObject(ObjRecord objRecord) {
        Iterator<SubRecord> it = objRecord.getSubRecords().iterator();
        while (it.hasNext()) {
            if (it.next() instanceof EmbeddedObjectRefSubRecord) {
                return true;
            }
        }
        return false;
    }
}
