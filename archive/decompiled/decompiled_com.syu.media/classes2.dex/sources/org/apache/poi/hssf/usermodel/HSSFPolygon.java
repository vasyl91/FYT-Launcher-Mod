package org.apache.poi.hssf.usermodel;

import kotlin.jvm.internal.ByteCompanionObject;
import module.canbus.FinalCanbus;
import org.apache.poi.ddf.EscherArrayProperty;
import org.apache.poi.ddf.EscherBoolProperty;
import org.apache.poi.ddf.EscherClientDataRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherProperties;
import org.apache.poi.ddf.EscherRGBProperty;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherShapePathProperty;
import org.apache.poi.ddf.EscherSimpleProperty;
import org.apache.poi.ddf.EscherSpRecord;
import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
import org.apache.poi.hssf.record.EndSubRecord;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.hssf.record.TextObjectRecord;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HSSFPolygon extends HSSFSimpleShape {
    public static final short OBJECT_TYPE_MICROSOFT_OFFICE_DRAWING = 30;
    private static POILogger logger = POILogFactory.getLogger((Class<?>) HSSFPolygon.class);

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape
    protected TextObjectRecord createTextObjRecord() {
        return null;
    }

    public HSSFPolygon(EscherContainerRecord escherContainerRecord, ObjRecord objRecord, TextObjectRecord textObjectRecord) {
        super(escherContainerRecord, objRecord, textObjectRecord);
    }

    public HSSFPolygon(EscherContainerRecord escherContainerRecord, ObjRecord objRecord) {
        super(escherContainerRecord, objRecord);
    }

    HSSFPolygon(HSSFShape hSSFShape, HSSFAnchor hSSFAnchor) {
        super(hSSFShape, hSSFAnchor);
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape, org.apache.poi.hssf.usermodel.HSSFShape
    protected EscherContainerRecord createSpContainer() {
        EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
        EscherSpRecord escherSpRecord = new EscherSpRecord();
        EscherOptRecord escherOptRecord = new EscherOptRecord();
        EscherClientDataRecord escherClientDataRecord = new EscherClientDataRecord();
        escherContainerRecord.setRecordId(EscherContainerRecord.SP_CONTAINER);
        escherContainerRecord.setOptions((short) 15);
        escherSpRecord.setRecordId(EscherSpRecord.RECORD_ID);
        escherSpRecord.setOptions((short) 2);
        if (getParent() == null) {
            escherSpRecord.setFlags(2560);
        } else {
            escherSpRecord.setFlags(2562);
        }
        escherOptRecord.setRecordId(EscherOptRecord.RECORD_ID);
        escherOptRecord.setEscherProperty(new EscherSimpleProperty((short) 4, false, false, 0));
        escherOptRecord.setEscherProperty(new EscherSimpleProperty(EscherProperties.GEOMETRY__RIGHT, false, false, 100));
        escherOptRecord.setEscherProperty(new EscherSimpleProperty(EscherProperties.GEOMETRY__BOTTOM, false, false, 100));
        escherOptRecord.setEscherProperty(new EscherShapePathProperty(EscherProperties.GEOMETRY__SHAPEPATH, 4));
        escherOptRecord.setEscherProperty(new EscherSimpleProperty(EscherProperties.GEOMETRY__FILLOK, false, false, 65537));
        escherOptRecord.setEscherProperty(new EscherSimpleProperty(EscherProperties.LINESTYLE__LINESTARTARROWHEAD, false, false, 0));
        escherOptRecord.setEscherProperty(new EscherSimpleProperty(EscherProperties.LINESTYLE__LINEENDARROWHEAD, false, false, 0));
        escherOptRecord.setEscherProperty(new EscherSimpleProperty(EscherProperties.LINESTYLE__LINEENDCAPSTYLE, false, false, 0));
        escherOptRecord.setEscherProperty(new EscherSimpleProperty(EscherProperties.LINESTYLE__LINEDASHING, 0));
        escherOptRecord.setEscherProperty(new EscherBoolProperty(EscherProperties.LINESTYLE__NOLINEDRAWDASH, 524296));
        escherOptRecord.setEscherProperty(new EscherSimpleProperty(EscherProperties.LINESTYLE__LINEWIDTH, 9525));
        escherOptRecord.setEscherProperty(new EscherRGBProperty(EscherProperties.FILL__FILLCOLOR, HSSFShape.FILL__FILLCOLOR_DEFAULT));
        escherOptRecord.setEscherProperty(new EscherRGBProperty(EscherProperties.LINESTYLE__COLOR, HSSFShape.LINESTYLE__COLOR_DEFAULT));
        escherOptRecord.setEscherProperty(new EscherBoolProperty(EscherProperties.FILL__NOFILLHITTEST, 1));
        escherOptRecord.setEscherProperty(new EscherBoolProperty((short) 959, 524288));
        EscherRecord escherAnchor = getAnchor().getEscherAnchor();
        escherClientDataRecord.setRecordId(EscherClientDataRecord.RECORD_ID);
        escherClientDataRecord.setOptions((short) 0);
        escherContainerRecord.addChildRecord(escherSpRecord);
        escherContainerRecord.addChildRecord(escherOptRecord);
        escherContainerRecord.addChildRecord(escherAnchor);
        escherContainerRecord.addChildRecord(escherClientDataRecord);
        return escherContainerRecord;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape, org.apache.poi.hssf.usermodel.HSSFShape
    protected ObjRecord createObjRecord() {
        ObjRecord objRecord = new ObjRecord();
        CommonObjectDataSubRecord commonObjectDataSubRecord = new CommonObjectDataSubRecord();
        commonObjectDataSubRecord.setObjectType((short) 30);
        commonObjectDataSubRecord.setLocked(true);
        commonObjectDataSubRecord.setPrintable(true);
        commonObjectDataSubRecord.setAutofill(true);
        commonObjectDataSubRecord.setAutoline(true);
        EndSubRecord endSubRecord = new EndSubRecord();
        objRecord.addSubRecord(commonObjectDataSubRecord);
        objRecord.addSubRecord(endSubRecord);
        return objRecord;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape, org.apache.poi.hssf.usermodel.HSSFShape
    protected void afterRemove(HSSFPatriarch hSSFPatriarch) {
        hSSFPatriarch.getBoundAggregate().removeShapeToObjRecord(getEscherContainer().getChildById(EscherClientDataRecord.RECORD_ID));
    }

    public int[] getXPoints() {
        EscherArrayProperty escherArrayProperty = (EscherArrayProperty) getOptRecord().lookup(FinalCanbus.CAR_DJ_WC1_MZD_CX5);
        if (escherArrayProperty == null) {
            return new int[0];
        }
        int[] iArr = new int[escherArrayProperty.getNumberOfElementsInArray() - 1];
        for (int i = 0; i < escherArrayProperty.getNumberOfElementsInArray() - 1; i++) {
            iArr[i] = LittleEndian.getShort(escherArrayProperty.getElement(i), 0);
        }
        return iArr;
    }

    public int[] getYPoints() {
        EscherArrayProperty escherArrayProperty = (EscherArrayProperty) getOptRecord().lookup(FinalCanbus.CAR_DJ_WC1_MZD_CX5);
        if (escherArrayProperty == null) {
            return new int[0];
        }
        int[] iArr = new int[escherArrayProperty.getNumberOfElementsInArray() - 1];
        for (int i = 0; i < escherArrayProperty.getNumberOfElementsInArray() - 1; i++) {
            iArr[i] = LittleEndian.getShort(escherArrayProperty.getElement(i), 2);
        }
        return iArr;
    }

    public void setPoints(int[] iArr, int[] iArr2) {
        if (iArr.length != iArr2.length) {
            logger.log(7, "xPoint.length must be equal to yPoints.length");
            return;
        }
        if (iArr.length == 0) {
            logger.log(7, "HSSFPolygon must have at least one point");
        }
        EscherArrayProperty escherArrayProperty = new EscherArrayProperty(EscherProperties.GEOMETRY__VERTICES, false, new byte[0]);
        escherArrayProperty.setNumberOfElementsInArray(iArr.length + 1);
        escherArrayProperty.setNumberOfElementsInMemory(iArr.length + 1);
        escherArrayProperty.setSizeOfElements(65520);
        for (int i = 0; i < iArr.length; i++) {
            byte[] bArr = new byte[4];
            LittleEndian.putShort(bArr, 0, (short) iArr[i]);
            LittleEndian.putShort(bArr, 2, (short) iArr2[i]);
            escherArrayProperty.setElement(i, bArr);
        }
        int length = iArr.length;
        byte[] bArr2 = new byte[4];
        LittleEndian.putShort(bArr2, 0, (short) iArr[0]);
        LittleEndian.putShort(bArr2, 2, (short) iArr2[0]);
        escherArrayProperty.setElement(length, bArr2);
        setPropertyValue(escherArrayProperty);
        EscherArrayProperty escherArrayProperty2 = new EscherArrayProperty(EscherProperties.GEOMETRY__SEGMENTINFO, false, null);
        escherArrayProperty2.setSizeOfElements(2);
        escherArrayProperty2.setNumberOfElementsInArray((iArr.length * 2) + 4);
        escherArrayProperty2.setNumberOfElementsInMemory((iArr.length * 2) + 4);
        escherArrayProperty2.setElement(0, new byte[]{0, Ptg.CLASS_ARRAY});
        escherArrayProperty2.setElement(1, new byte[]{0, -84});
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = i2 * 2;
            escherArrayProperty2.setElement(i3 + 2, new byte[]{1, 0});
            escherArrayProperty2.setElement(i3 + 3, new byte[]{0, -84});
        }
        escherArrayProperty2.setElement(escherArrayProperty2.getNumberOfElementsInArray() - 2, new byte[]{1, 96});
        escherArrayProperty2.setElement(escherArrayProperty2.getNumberOfElementsInArray() - 1, new byte[]{0, ByteCompanionObject.MIN_VALUE});
        setPropertyValue(escherArrayProperty2);
    }

    public void setPolygonDrawArea(int i, int i2) {
        setPropertyValue(new EscherSimpleProperty(EscherProperties.GEOMETRY__RIGHT, i));
        setPropertyValue(new EscherSimpleProperty(EscherProperties.GEOMETRY__BOTTOM, i2));
    }

    public int getDrawAreaWidth() {
        EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty) getOptRecord().lookup(FinalCanbus.CAR_WC1_NISSAN_LouLan);
        if (escherSimpleProperty == null) {
            return 100;
        }
        return escherSimpleProperty.getPropertyValue();
    }

    public int getDrawAreaHeight() {
        EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty) getOptRecord().lookup(FinalCanbus.CAR_HC_XP1_PorscheCayenne);
        if (escherSimpleProperty == null) {
            return 100;
        }
        return escherSimpleProperty.getPropertyValue();
    }
}
