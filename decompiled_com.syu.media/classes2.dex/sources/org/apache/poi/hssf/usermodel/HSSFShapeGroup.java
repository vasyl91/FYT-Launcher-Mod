package org.apache.poi.hssf.usermodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import module.canbus.FinalCanbus;
import org.apache.poi.ddf.DefaultEscherRecordFactory;
import org.apache.poi.ddf.EscherBoolProperty;
import org.apache.poi.ddf.EscherChildAnchorRecord;
import org.apache.poi.ddf.EscherClientAnchorRecord;
import org.apache.poi.ddf.EscherClientDataRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherSpRecord;
import org.apache.poi.ddf.EscherSpgrRecord;
import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
import org.apache.poi.hssf.record.EndSubRecord;
import org.apache.poi.hssf.record.GroupMarkerSubRecord;
import org.apache.poi.hssf.record.ObjRecord;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HSSFShapeGroup extends HSSFShape implements HSSFShapeContainer {
    private EscherSpgrRecord _spgrRecord;
    private final List<HSSFShape> shapes;

    public HSSFShapeGroup(EscherContainerRecord escherContainerRecord, ObjRecord objRecord) {
        super(escherContainerRecord, objRecord);
        this.shapes = new ArrayList();
        EscherContainerRecord escherContainerRecord2 = escherContainerRecord.getChildContainers().get(0);
        this._spgrRecord = (EscherSpgrRecord) escherContainerRecord2.getChild(0);
        for (EscherRecord escherRecord : escherContainerRecord2.getChildRecords()) {
            short recordId = escherRecord.getRecordId();
            if (recordId == -4081) {
                this.anchor = new HSSFChildAnchor((EscherChildAnchorRecord) escherRecord);
            } else if (recordId == -4080) {
                this.anchor = new HSSFClientAnchor((EscherClientAnchorRecord) escherRecord);
            }
        }
    }

    public HSSFShapeGroup(HSSFShape hSSFShape, HSSFAnchor hSSFAnchor) {
        super(hSSFShape, hSSFAnchor);
        this.shapes = new ArrayList();
        this._spgrRecord = (EscherSpgrRecord) ((EscherContainerRecord) getEscherContainer().getChild(0)).getChildById(EscherSpgrRecord.RECORD_ID);
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShape
    protected EscherContainerRecord createSpContainer() {
        EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
        EscherContainerRecord escherContainerRecord2 = new EscherContainerRecord();
        EscherSpgrRecord escherSpgrRecord = new EscherSpgrRecord();
        EscherSpRecord escherSpRecord = new EscherSpRecord();
        EscherOptRecord escherOptRecord = new EscherOptRecord();
        EscherClientDataRecord escherClientDataRecord = new EscherClientDataRecord();
        escherContainerRecord.setRecordId(EscherContainerRecord.SPGR_CONTAINER);
        escherContainerRecord.setOptions((short) 15);
        escherContainerRecord2.setRecordId(EscherContainerRecord.SP_CONTAINER);
        escherContainerRecord2.setOptions((short) 15);
        escherSpgrRecord.setRecordId(EscherSpgrRecord.RECORD_ID);
        escherSpgrRecord.setOptions((short) 1);
        escherSpgrRecord.setRectX1(0);
        escherSpgrRecord.setRectY1(0);
        escherSpgrRecord.setRectX2(1023);
        escherSpgrRecord.setRectY2(255);
        escherSpRecord.setRecordId(EscherSpRecord.RECORD_ID);
        escherSpRecord.setOptions((short) 2);
        if (getAnchor() instanceof HSSFClientAnchor) {
            escherSpRecord.setFlags(FinalCanbus.U_CAR_DRIVENABLE_MILEAGE);
        } else {
            escherSpRecord.setFlags(FinalCanbus.U_CAR_SEAT_BELT_RIGHT);
        }
        escherOptRecord.setRecordId(EscherOptRecord.RECORD_ID);
        escherOptRecord.setOptions((short) 35);
        escherOptRecord.addEscherProperty(new EscherBoolProperty((short) 127, 262148));
        escherOptRecord.addEscherProperty(new EscherBoolProperty((short) 959, 524288));
        EscherRecord escherAnchor = getAnchor().getEscherAnchor();
        escherClientDataRecord.setRecordId(EscherClientDataRecord.RECORD_ID);
        escherClientDataRecord.setOptions((short) 0);
        escherContainerRecord.addChildRecord(escherContainerRecord2);
        escherContainerRecord2.addChildRecord(escherSpgrRecord);
        escherContainerRecord2.addChildRecord(escherSpRecord);
        escherContainerRecord2.addChildRecord(escherOptRecord);
        escherContainerRecord2.addChildRecord(escherAnchor);
        escherContainerRecord2.addChildRecord(escherClientDataRecord);
        return escherContainerRecord;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShape
    protected ObjRecord createObjRecord() {
        ObjRecord objRecord = new ObjRecord();
        CommonObjectDataSubRecord commonObjectDataSubRecord = new CommonObjectDataSubRecord();
        commonObjectDataSubRecord.setObjectType((short) 0);
        commonObjectDataSubRecord.setLocked(true);
        commonObjectDataSubRecord.setPrintable(true);
        commonObjectDataSubRecord.setAutofill(true);
        commonObjectDataSubRecord.setAutoline(true);
        GroupMarkerSubRecord groupMarkerSubRecord = new GroupMarkerSubRecord();
        EndSubRecord endSubRecord = new EndSubRecord();
        objRecord.addSubRecord(commonObjectDataSubRecord);
        objRecord.addSubRecord(groupMarkerSubRecord);
        objRecord.addSubRecord(endSubRecord);
        return objRecord;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShape
    protected void afterRemove(HSSFPatriarch hSSFPatriarch) {
        hSSFPatriarch.getBoundAggregate().removeShapeToObjRecord(getEscherContainer().getChildContainers().get(0).getChildById(EscherClientDataRecord.RECORD_ID));
        for (int i = 0; i < this.shapes.size(); i++) {
            HSSFShape hSSFShape = this.shapes.get(i);
            removeShape(hSSFShape);
            hSSFShape.afterRemove(getPatriarch());
        }
        this.shapes.clear();
    }

    private void onCreate(HSSFShape hSSFShape) {
        EscherSpRecord escherSpRecord;
        if (getPatriarch() != null) {
            EscherContainerRecord escherContainer = hSSFShape.getEscherContainer();
            hSSFShape.setShapeId(getPatriarch().newShapeId());
            getEscherContainer().addChildRecord(escherContainer);
            hSSFShape.afterInsert(getPatriarch());
            if (hSSFShape instanceof HSSFShapeGroup) {
                escherSpRecord = (EscherSpRecord) hSSFShape.getEscherContainer().getChildContainers().get(0).getChildById(EscherSpRecord.RECORD_ID);
            } else {
                escherSpRecord = (EscherSpRecord) hSSFShape.getEscherContainer().getChildById(EscherSpRecord.RECORD_ID);
            }
            escherSpRecord.setFlags(escherSpRecord.getFlags() | 2);
        }
    }

    public HSSFShapeGroup createGroup(HSSFChildAnchor hSSFChildAnchor) {
        HSSFShapeGroup hSSFShapeGroup = new HSSFShapeGroup(this, hSSFChildAnchor);
        hSSFShapeGroup.setParent(this);
        hSSFShapeGroup.setAnchor(hSSFChildAnchor);
        this.shapes.add(hSSFShapeGroup);
        onCreate(hSSFShapeGroup);
        return hSSFShapeGroup;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShapeContainer
    public void addShape(HSSFShape hSSFShape) {
        hSSFShape.setPatriarch(getPatriarch());
        hSSFShape.setParent(this);
        this.shapes.add(hSSFShape);
    }

    public HSSFSimpleShape createShape(HSSFChildAnchor hSSFChildAnchor) {
        HSSFSimpleShape hSSFSimpleShape = new HSSFSimpleShape(this, hSSFChildAnchor);
        hSSFSimpleShape.setParent(this);
        hSSFSimpleShape.setAnchor(hSSFChildAnchor);
        this.shapes.add(hSSFSimpleShape);
        onCreate(hSSFSimpleShape);
        EscherSpRecord escherSpRecord = (EscherSpRecord) hSSFSimpleShape.getEscherContainer().getChildById(EscherSpRecord.RECORD_ID);
        if (hSSFSimpleShape.getAnchor().isHorizontallyFlipped()) {
            escherSpRecord.setFlags(escherSpRecord.getFlags() | 64);
        }
        if (hSSFSimpleShape.getAnchor().isVerticallyFlipped()) {
            escherSpRecord.setFlags(escherSpRecord.getFlags() | 128);
        }
        return hSSFSimpleShape;
    }

    public HSSFTextbox createTextbox(HSSFChildAnchor hSSFChildAnchor) {
        HSSFTextbox hSSFTextbox = new HSSFTextbox(this, hSSFChildAnchor);
        hSSFTextbox.setParent(this);
        hSSFTextbox.setAnchor(hSSFChildAnchor);
        this.shapes.add(hSSFTextbox);
        onCreate(hSSFTextbox);
        return hSSFTextbox;
    }

    public HSSFPolygon createPolygon(HSSFChildAnchor hSSFChildAnchor) {
        HSSFPolygon hSSFPolygon = new HSSFPolygon(this, hSSFChildAnchor);
        hSSFPolygon.setParent(this);
        hSSFPolygon.setAnchor(hSSFChildAnchor);
        this.shapes.add(hSSFPolygon);
        onCreate(hSSFPolygon);
        return hSSFPolygon;
    }

    public HSSFPicture createPicture(HSSFChildAnchor hSSFChildAnchor, int i) {
        HSSFPicture hSSFPicture = new HSSFPicture(this, hSSFChildAnchor);
        hSSFPicture.setParent(this);
        hSSFPicture.setAnchor(hSSFChildAnchor);
        hSSFPicture.setPictureIndex(i);
        this.shapes.add(hSSFPicture);
        onCreate(hSSFPicture);
        EscherSpRecord escherSpRecord = (EscherSpRecord) hSSFPicture.getEscherContainer().getChildById(EscherSpRecord.RECORD_ID);
        if (hSSFPicture.getAnchor().isHorizontallyFlipped()) {
            escherSpRecord.setFlags(escherSpRecord.getFlags() | 64);
        }
        if (hSSFPicture.getAnchor().isVerticallyFlipped()) {
            escherSpRecord.setFlags(escherSpRecord.getFlags() | 128);
        }
        return hSSFPicture;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShapeContainer
    public List<HSSFShape> getChildren() {
        return Collections.unmodifiableList(this.shapes);
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShapeContainer
    public void setCoordinates(int i, int i2, int i3, int i4) {
        this._spgrRecord.setRectX1(i);
        this._spgrRecord.setRectX2(i3);
        this._spgrRecord.setRectY1(i2);
        this._spgrRecord.setRectY2(i4);
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShapeContainer
    public void clear() {
        Iterator it = new ArrayList(this.shapes).iterator();
        while (it.hasNext()) {
            removeShape((HSSFShape) it.next());
        }
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShapeContainer
    public int getX1() {
        return this._spgrRecord.getRectX1();
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShapeContainer
    public int getY1() {
        return this._spgrRecord.getRectY1();
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShapeContainer
    public int getX2() {
        return this._spgrRecord.getRectX2();
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShapeContainer
    public int getY2() {
        return this._spgrRecord.getRectY2();
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShape
    public int countOfAllChildren() {
        int size = this.shapes.size();
        Iterator<HSSFShape> it = this.shapes.iterator();
        while (it.hasNext()) {
            size += it.next().countOfAllChildren();
        }
        return size;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShape
    void afterInsert(HSSFPatriarch hSSFPatriarch) {
        hSSFPatriarch.getBoundAggregate().associateShapeToObjRecord(((EscherContainerRecord) getEscherContainer().getChildById(EscherContainerRecord.SP_CONTAINER)).getChildById(EscherClientDataRecord.RECORD_ID), getObjRecord());
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShape
    void setShapeId(int i) {
        ((EscherSpRecord) ((EscherContainerRecord) getEscherContainer().getChildById(EscherContainerRecord.SP_CONTAINER)).getChildById(EscherSpRecord.RECORD_ID)).setShapeId(i);
        ((CommonObjectDataSubRecord) getObjRecord().getSubRecords().get(0)).setObjectId((short) (i % 1024));
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShape
    int getShapeId() {
        return ((EscherSpRecord) ((EscherContainerRecord) getEscherContainer().getChildById(EscherContainerRecord.SP_CONTAINER)).getChildById(EscherSpRecord.RECORD_ID)).getShapeId();
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShape
    protected HSSFShape cloneShape() {
        throw new IllegalStateException("Use method cloneShape(HSSFPatriarch patriarch)");
    }

    protected HSSFShape cloneShape(HSSFPatriarch hSSFPatriarch) {
        HSSFShape hSSFShapeCloneShape;
        EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
        escherContainerRecord.setRecordId(EscherContainerRecord.SPGR_CONTAINER);
        escherContainerRecord.setOptions((short) 15);
        EscherContainerRecord escherContainerRecord2 = new EscherContainerRecord();
        escherContainerRecord2.fillFields(((EscherContainerRecord) getEscherContainer().getChildById(EscherContainerRecord.SP_CONTAINER)).serialize(), 0, new DefaultEscherRecordFactory());
        escherContainerRecord.addChildRecord(escherContainerRecord2);
        HSSFShapeGroup hSSFShapeGroup = new HSSFShapeGroup(escherContainerRecord, getObjRecord() != null ? (ObjRecord) getObjRecord().cloneViaReserialise() : null);
        hSSFShapeGroup.setPatriarch(hSSFPatriarch);
        for (HSSFShape hSSFShape : getChildren()) {
            if (hSSFShape instanceof HSSFShapeGroup) {
                hSSFShapeCloneShape = ((HSSFShapeGroup) hSSFShape).cloneShape(hSSFPatriarch);
            } else {
                hSSFShapeCloneShape = hSSFShape.cloneShape();
            }
            hSSFShapeGroup.addShape(hSSFShapeCloneShape);
            hSSFShapeGroup.onCreate(hSSFShapeCloneShape);
        }
        return hSSFShapeGroup;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShapeContainer
    public boolean removeShape(HSSFShape hSSFShape) {
        boolean zRemoveChildRecord = getEscherContainer().removeChildRecord(hSSFShape.getEscherContainer());
        if (zRemoveChildRecord) {
            hSSFShape.afterRemove(getPatriarch());
            this.shapes.remove(hSSFShape);
        }
        return zRemoveChildRecord;
    }

    @Override // java.lang.Iterable
    public Iterator<HSSFShape> iterator() {
        return this.shapes.iterator();
    }
}
