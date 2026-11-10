package org.apache.poi.hssf.usermodel;

import java.awt.Dimension;
import java.io.ByteArrayInputStream;
import module.canbus.FinalCanbus;
import org.apache.poi.ddf.DefaultEscherRecordFactory;
import org.apache.poi.ddf.EscherBSERecord;
import org.apache.poi.ddf.EscherClientDataRecord;
import org.apache.poi.ddf.EscherComplexProperty;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherProperties;
import org.apache.poi.ddf.EscherSimpleProperty;
import org.apache.poi.ddf.EscherTextboxRecord;
import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.util.ImageUtils;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HSSFPicture extends HSSFSimpleShape implements Picture {
    public static final int PICTURE_TYPE_DIB = 7;
    public static final int PICTURE_TYPE_EMF = 2;
    public static final int PICTURE_TYPE_JPEG = 5;
    public static final int PICTURE_TYPE_PICT = 4;
    public static final int PICTURE_TYPE_PNG = 6;
    public static final int PICTURE_TYPE_WMF = 3;
    private static POILogger logger = POILogFactory.getLogger((Class<?>) HSSFPicture.class);

    public HSSFPicture(EscherContainerRecord escherContainerRecord, ObjRecord objRecord) {
        super(escherContainerRecord, objRecord);
    }

    public HSSFPicture(HSSFShape hSSFShape, HSSFAnchor hSSFAnchor) {
        super(hSSFShape, hSSFAnchor);
        super.setShapeType(75);
        ((CommonObjectDataSubRecord) getObjRecord().getSubRecords().get(0)).setObjectType((short) 8);
    }

    public int getPictureIndex() {
        EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty) getOptRecord().lookup(FinalCanbus.CAR_WC2_ChuanQiGA6);
        if (escherSimpleProperty == null) {
            return -1;
        }
        return escherSimpleProperty.getPropertyValue();
    }

    public void setPictureIndex(int i) {
        setPropertyValue(new EscherSimpleProperty(EscherProperties.BLIP__BLIPTODISPLAY, false, true, i));
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape, org.apache.poi.hssf.usermodel.HSSFShape
    protected EscherContainerRecord createSpContainer() {
        EscherContainerRecord escherContainerRecordCreateSpContainer = super.createSpContainer();
        EscherOptRecord escherOptRecord = (EscherOptRecord) escherContainerRecordCreateSpContainer.getChildById(EscherOptRecord.RECORD_ID);
        escherOptRecord.removeEscherProperty(462);
        escherOptRecord.removeEscherProperty(FinalCanbus.U_CAR_AVG_SPEED);
        escherContainerRecordCreateSpContainer.removeChildRecord(escherContainerRecordCreateSpContainer.getChildById(EscherTextboxRecord.RECORD_ID));
        return escherContainerRecordCreateSpContainer;
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public void resize() {
        resize(Double.MAX_VALUE);
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public void resize(double d) {
        resize(d, d);
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public void resize(double d, double d2) {
        HSSFClientAnchor clientAnchor = getClientAnchor();
        clientAnchor.setAnchorType(ClientAnchor.AnchorType.MOVE_DONT_RESIZE);
        HSSFClientAnchor preferredSize = getPreferredSize(d, d2);
        int row1 = clientAnchor.getRow1() + (preferredSize.getRow2() - preferredSize.getRow1());
        clientAnchor.setCol2((short) (clientAnchor.getCol1() + (preferredSize.getCol2() - preferredSize.getCol1())));
        clientAnchor.setDx2(preferredSize.getDx2());
        clientAnchor.setRow2(row1);
        clientAnchor.setDy2(preferredSize.getDy2());
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public HSSFClientAnchor getPreferredSize() {
        return getPreferredSize(1.0d);
    }

    public HSSFClientAnchor getPreferredSize(double d) {
        return getPreferredSize(d, d);
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public HSSFClientAnchor getPreferredSize(double d, double d2) {
        ImageUtils.setPreferredSize(this, d, d2);
        return getClientAnchor();
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public Dimension getImageDimension() {
        EscherBSERecord bSERecord = getPatriarch().getSheet().getWorkbook().getWorkbook().getBSERecord(getPictureIndex());
        byte[] picturedata = bSERecord.getBlipRecord().getPicturedata();
        return ImageUtils.getImageDimension(new ByteArrayInputStream(picturedata), bSERecord.getBlipTypeWin32());
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public HSSFPictureData getPictureData() {
        int pictureIndex = getPictureIndex();
        if (pictureIndex == -1) {
            return null;
        }
        HSSFPatriarch patriarch = getPatriarch();
        for (HSSFShape parent = getParent(); patriarch == null && parent != null; parent = parent.getParent()) {
            patriarch = parent.getPatriarch();
        }
        if (patriarch == null) {
            throw new IllegalStateException("Could not find a patriarch for a HSSPicture");
        }
        return new HSSFPictureData(patriarch.getSheet().getWorkbook().getWorkbook().getBSERecord(pictureIndex).getBlipRecord());
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape, org.apache.poi.hssf.usermodel.HSSFShape
    void afterInsert(HSSFPatriarch hSSFPatriarch) {
        hSSFPatriarch.getBoundAggregate().associateShapeToObjRecord(getEscherContainer().getChildById(EscherClientDataRecord.RECORD_ID), getObjRecord());
        if (getPictureIndex() != -1) {
            EscherBSERecord bSERecord = hSSFPatriarch.getSheet().getWorkbook().getWorkbook().getBSERecord(getPictureIndex());
            bSERecord.setRef(bSERecord.getRef() + 1);
        }
    }

    public String getFileName() {
        EscherComplexProperty escherComplexProperty = (EscherComplexProperty) getOptRecord().lookup(FinalCanbus.CAR_KANGSHENG_XP1_FuRuiSi);
        return escherComplexProperty == null ? "" : StringUtil.getFromUnicodeLE(escherComplexProperty.getComplexData()).trim();
    }

    public void setFileName(String str) {
        setPropertyValue(new EscherComplexProperty(EscherProperties.BLIP__BLIPFILENAME, true, StringUtil.getToUnicodeLE(str)));
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape
    public void setShapeType(int i) {
        throw new IllegalStateException("Shape type can not be changed in " + getClass().getSimpleName());
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape, org.apache.poi.hssf.usermodel.HSSFShape
    protected HSSFShape cloneShape() {
        EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
        escherContainerRecord.fillFields(getEscherContainer().serialize(), 0, new DefaultEscherRecordFactory());
        return new HSSFPicture(escherContainerRecord, (ObjRecord) getObjRecord().cloneViaReserialise());
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public HSSFClientAnchor getClientAnchor() {
        HSSFAnchor anchor = getAnchor();
        if (anchor instanceof HSSFClientAnchor) {
            return (HSSFClientAnchor) anchor;
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public HSSFSheet getSheet() {
        return getPatriarch().getSheet();
    }
}
