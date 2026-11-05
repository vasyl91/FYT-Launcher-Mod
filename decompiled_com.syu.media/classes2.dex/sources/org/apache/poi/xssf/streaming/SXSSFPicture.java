package org.apache.poi.xssf.streaming;

import java.awt.Dimension;
import java.io.IOException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Shape;
import org.apache.poi.ss.util.ImageUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.xssf.usermodel.XSSFAnchor;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFPictureData;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class SXSSFPicture implements Picture {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final XSSFPicture _picture;
    private final SXSSFWorkbook _wb;
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) SXSSFPicture.class);
    private static float DEFAULT_COLUMN_WIDTH = 9.140625f;

    SXSSFPicture(SXSSFWorkbook sXSSFWorkbook, XSSFPicture xSSFPicture) {
        this._wb = sXSSFWorkbook;
        this._picture = xSSFPicture;
    }

    @Internal
    public CTPicture getCTPicture() {
        return this._picture.getCTPicture();
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public void resize() {
        resize(1.0d);
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public void resize(double d) {
        XSSFClientAnchor clientAnchor = getClientAnchor();
        XSSFClientAnchor preferredSize = getPreferredSize(d);
        int row1 = clientAnchor.getRow1() + (preferredSize.getRow2() - preferredSize.getRow1());
        clientAnchor.setCol2(clientAnchor.getCol1() + (preferredSize.getCol2() - preferredSize.getCol1()));
        clientAnchor.setDx1(0);
        clientAnchor.setDx2(preferredSize.getDx2());
        clientAnchor.setRow2(row1);
        clientAnchor.setDy1(0);
        clientAnchor.setDy2(preferredSize.getDy2());
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public XSSFClientAnchor getPreferredSize() {
        return getPreferredSize(1.0d);
    }

    public XSSFClientAnchor getPreferredSize(double d) {
        double d2;
        XSSFClientAnchor clientAnchor = getClientAnchor();
        XSSFPictureData pictureData = getPictureData();
        Dimension imageDimension = getImageDimension(pictureData.getPackagePart(), pictureData.getPictureType());
        double width = imageDimension.getWidth() * d;
        double height = imageDimension.getHeight() * d;
        int col1 = clientAnchor.getCol1() - 1;
        float columnWidthInPixels = 0.0f;
        while (true) {
            d2 = columnWidthInPixels;
            if (d2 > width) {
                break;
            }
            col1++;
            columnWidthInPixels += getColumnWidthInPixels(col1);
        }
        int columnWidthInPixels2 = (int) ((((double) getColumnWidthInPixels(col1)) - (d2 - width)) * 9525.0d);
        clientAnchor.setCol2(col1);
        clientAnchor.setDx2(columnWidthInPixels2);
        int row1 = clientAnchor.getRow1() - 1;
        double rowHeightInPixels = 0.0d;
        while (rowHeightInPixels <= height) {
            row1++;
            rowHeightInPixels += (double) getRowHeightInPixels(row1);
        }
        int rowHeightInPixels2 = (int) ((((double) getRowHeightInPixels(row1)) - (rowHeightInPixels - height)) * 9525.0d);
        clientAnchor.setRow2(row1);
        clientAnchor.setDy2(rowHeightInPixels2);
        CTPositiveSize2D ext = getCTPicture().getSpPr().getXfrm().getExt();
        ext.setCx((long) (width * 9525.0d));
        ext.setCy((long) (height * 9525.0d));
        return clientAnchor;
    }

    private float getColumnWidthInPixels(int i) {
        CTCol column = getSheet().getColumnHelper().getColumn(i, false);
        return ((float) ((column == null || !column.isSetWidth()) ? DEFAULT_COLUMN_WIDTH : column.getWidth())) * 7.0017f;
    }

    private float getRowHeightInPixels(int i) {
        SXSSFSheet sXSSFSheet = this._wb.getSXSSFSheet(getSheet());
        SXSSFRow row = sXSSFSheet.getRow(i);
        return ((row != null ? row.getHeightInPoints() : sXSSFSheet.getDefaultRowHeightInPoints()) * 96.0f) / 72.0f;
    }

    protected static Dimension getImageDimension(PackagePart packagePart, int i) {
        try {
            return ImageUtils.getImageDimension(packagePart.getInputStream(), i);
        } catch (IOException e) {
            logger.log(5, e);
            return new Dimension();
        }
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public XSSFPictureData getPictureData() {
        return this._picture.getPictureData();
    }

    protected CTShapeProperties getShapeProperties() {
        return getCTPicture().getSpPr();
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public XSSFAnchor getAnchor() {
        return this._picture.getAnchor();
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public void resize(double d, double d2) {
        this._picture.resize(d, d2);
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public XSSFClientAnchor getPreferredSize(double d, double d2) {
        return this._picture.getPreferredSize(d, d2);
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public Dimension getImageDimension() {
        return this._picture.getImageDimension();
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public XSSFClientAnchor getClientAnchor() {
        XSSFAnchor anchor = getAnchor();
        if (anchor instanceof XSSFClientAnchor) {
            return (XSSFClientAnchor) anchor;
        }
        return null;
    }

    public XSSFDrawing getDrawing() {
        return this._picture.getDrawing();
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public XSSFSheet getSheet() {
        return this._picture.getSheet();
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public String getShapeName() {
        return this._picture.getShapeName();
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public Shape getParent() {
        return this._picture.getParent();
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public boolean isNoFill() {
        return this._picture.isNoFill();
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public void setNoFill(boolean z) {
        this._picture.setNoFill(z);
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public void setFillColor(int i, int i2, int i3) {
        this._picture.setFillColor(i, i2, i3);
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public void setLineStyleColor(int i, int i2, int i3) {
        this._picture.setLineStyleColor(i, i2, i3);
    }
}
