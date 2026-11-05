package org.apache.poi.hssf.usermodel;

import org.apache.poi.ddf.DefaultEscherRecordFactory;
import org.apache.poi.ddf.EscherBoolProperty;
import org.apache.poi.ddf.EscherClientDataRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherProperties;
import org.apache.poi.ddf.EscherRGBProperty;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherSimpleProperty;
import org.apache.poi.ddf.EscherSpRecord;
import org.apache.poi.ddf.EscherTextboxRecord;
import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
import org.apache.poi.hssf.record.EndSubRecord;
import org.apache.poi.hssf.record.EscherAggregate;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.hssf.record.TextObjectRecord;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HSSFTextbox extends HSSFSimpleShape {
    public static final short HORIZONTAL_ALIGNMENT_CENTERED = 2;
    public static final short HORIZONTAL_ALIGNMENT_DISTRIBUTED = 7;
    public static final short HORIZONTAL_ALIGNMENT_JUSTIFIED = 4;
    public static final short HORIZONTAL_ALIGNMENT_LEFT = 1;
    public static final short HORIZONTAL_ALIGNMENT_RIGHT = 3;
    public static final short OBJECT_TYPE_TEXT = 6;
    public static final short VERTICAL_ALIGNMENT_BOTTOM = 3;
    public static final short VERTICAL_ALIGNMENT_CENTER = 2;
    public static final short VERTICAL_ALIGNMENT_DISTRIBUTED = 7;
    public static final short VERTICAL_ALIGNMENT_JUSTIFY = 4;
    public static final short VERTICAL_ALIGNMENT_TOP = 1;

    public HSSFTextbox(EscherContainerRecord escherContainerRecord, ObjRecord objRecord, TextObjectRecord textObjectRecord) {
        super(escherContainerRecord, objRecord, textObjectRecord);
    }

    public HSSFTextbox(HSSFShape hSSFShape, HSSFAnchor hSSFAnchor) {
        super(hSSFShape, hSSFAnchor);
        setHorizontalAlignment((short) 1);
        setVerticalAlignment((short) 1);
        setString(new HSSFRichTextString(""));
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape, org.apache.poi.hssf.usermodel.HSSFShape
    protected ObjRecord createObjRecord() {
        ObjRecord objRecord = new ObjRecord();
        CommonObjectDataSubRecord commonObjectDataSubRecord = new CommonObjectDataSubRecord();
        commonObjectDataSubRecord.setObjectType((short) 6);
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
    protected EscherContainerRecord createSpContainer() {
        EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
        EscherSpRecord escherSpRecord = new EscherSpRecord();
        EscherOptRecord escherOptRecord = new EscherOptRecord();
        EscherClientDataRecord escherClientDataRecord = new EscherClientDataRecord();
        EscherTextboxRecord escherTextboxRecord = new EscherTextboxRecord();
        escherContainerRecord.setRecordId(EscherContainerRecord.SP_CONTAINER);
        escherContainerRecord.setOptions((short) 15);
        escherSpRecord.setRecordId(EscherSpRecord.RECORD_ID);
        escherSpRecord.setOptions((short) 3234);
        escherSpRecord.setFlags(2560);
        escherOptRecord.setRecordId(EscherOptRecord.RECORD_ID);
        escherOptRecord.addEscherProperty(new EscherSimpleProperty((short) 128, 0));
        escherOptRecord.addEscherProperty(new EscherSimpleProperty((short) 133, 0));
        escherOptRecord.addEscherProperty(new EscherSimpleProperty((short) 135, 0));
        escherOptRecord.addEscherProperty(new EscherSimpleProperty((short) 959, 524288));
        escherOptRecord.addEscherProperty(new EscherSimpleProperty((short) 129, 0));
        escherOptRecord.addEscherProperty(new EscherSimpleProperty((short) 131, 0));
        escherOptRecord.addEscherProperty(new EscherSimpleProperty((short) 130, 0));
        escherOptRecord.addEscherProperty(new EscherSimpleProperty((short) 132, 0));
        escherOptRecord.setEscherProperty(new EscherSimpleProperty(EscherProperties.LINESTYLE__LINEDASHING, 0));
        escherOptRecord.setEscherProperty(new EscherBoolProperty(EscherProperties.LINESTYLE__NOLINEDRAWDASH, 524296));
        escherOptRecord.setEscherProperty(new EscherSimpleProperty(EscherProperties.LINESTYLE__LINEWIDTH, 9525));
        escherOptRecord.setEscherProperty(new EscherRGBProperty(EscherProperties.FILL__FILLCOLOR, HSSFShape.FILL__FILLCOLOR_DEFAULT));
        escherOptRecord.setEscherProperty(new EscherRGBProperty(EscherProperties.LINESTYLE__COLOR, HSSFShape.LINESTYLE__COLOR_DEFAULT));
        escherOptRecord.setEscherProperty(new EscherBoolProperty(EscherProperties.FILL__NOFILLHITTEST, 65536));
        escherOptRecord.setEscherProperty(new EscherBoolProperty((short) 959, 524288));
        EscherRecord escherAnchor = getAnchor().getEscherAnchor();
        escherClientDataRecord.setRecordId(EscherClientDataRecord.RECORD_ID);
        escherClientDataRecord.setOptions((short) 0);
        escherTextboxRecord.setRecordId(EscherTextboxRecord.RECORD_ID);
        escherTextboxRecord.setOptions((short) 0);
        escherContainerRecord.addChildRecord(escherSpRecord);
        escherContainerRecord.addChildRecord(escherOptRecord);
        escherContainerRecord.addChildRecord(escherAnchor);
        escherContainerRecord.addChildRecord(escherClientDataRecord);
        escherContainerRecord.addChildRecord(escherTextboxRecord);
        return escherContainerRecord;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape, org.apache.poi.hssf.usermodel.HSSFShape
    void afterInsert(HSSFPatriarch hSSFPatriarch) {
        EscherAggregate boundAggregate = hSSFPatriarch.getBoundAggregate();
        boundAggregate.associateShapeToObjRecord(getEscherContainer().getChildById(EscherClientDataRecord.RECORD_ID), getObjRecord());
        if (getTextObjectRecord() != null) {
            boundAggregate.associateShapeToObjRecord(getEscherContainer().getChildById(EscherTextboxRecord.RECORD_ID), getTextObjectRecord());
        }
    }

    public int getMarginLeft() {
        EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty) getOptRecord().lookup(129);
        if (escherSimpleProperty == null) {
            return 0;
        }
        return escherSimpleProperty.getPropertyValue();
    }

    public void setMarginLeft(int i) {
        setPropertyValue(new EscherSimpleProperty((short) 129, i));
    }

    public int getMarginRight() {
        EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty) getOptRecord().lookup(131);
        if (escherSimpleProperty == null) {
            return 0;
        }
        return escherSimpleProperty.getPropertyValue();
    }

    public void setMarginRight(int i) {
        setPropertyValue(new EscherSimpleProperty((short) 131, i));
    }

    public int getMarginTop() {
        EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty) getOptRecord().lookup(130);
        if (escherSimpleProperty == null) {
            return 0;
        }
        return escherSimpleProperty.getPropertyValue();
    }

    public void setMarginTop(int i) {
        setPropertyValue(new EscherSimpleProperty((short) 130, i));
    }

    public int getMarginBottom() {
        EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty) getOptRecord().lookup(132);
        if (escherSimpleProperty == null) {
            return 0;
        }
        return escherSimpleProperty.getPropertyValue();
    }

    public void setMarginBottom(int i) {
        setPropertyValue(new EscherSimpleProperty((short) 132, i));
    }

    public short getHorizontalAlignment() {
        return (short) getTextObjectRecord().getHorizontalTextAlignment();
    }

    public void setHorizontalAlignment(short s) {
        getTextObjectRecord().setHorizontalTextAlignment(s);
    }

    public short getVerticalAlignment() {
        return (short) getTextObjectRecord().getVerticalTextAlignment();
    }

    public void setVerticalAlignment(short s) {
        getTextObjectRecord().setVerticalTextAlignment(s);
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape
    public void setShapeType(int i) {
        throw new IllegalStateException("Shape type can not be changed in " + getClass().getSimpleName());
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape, org.apache.poi.hssf.usermodel.HSSFShape
    protected HSSFShape cloneShape() {
        TextObjectRecord textObjectRecord = getTextObjectRecord() == null ? null : (TextObjectRecord) getTextObjectRecord().cloneViaReserialise();
        EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
        escherContainerRecord.fillFields(getEscherContainer().serialize(), 0, new DefaultEscherRecordFactory());
        return new HSSFTextbox(escherContainerRecord, (ObjRecord) getObjRecord().cloneViaReserialise(), textObjectRecord);
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape, org.apache.poi.hssf.usermodel.HSSFShape
    protected void afterRemove(HSSFPatriarch hSSFPatriarch) {
        hSSFPatriarch.getBoundAggregate().removeShapeToObjRecord(getEscherContainer().getChildById(EscherClientDataRecord.RECORD_ID));
        hSSFPatriarch.getBoundAggregate().removeShapeToObjRecord(getEscherContainer().getChildById(EscherTextboxRecord.RECORD_ID));
    }
}
