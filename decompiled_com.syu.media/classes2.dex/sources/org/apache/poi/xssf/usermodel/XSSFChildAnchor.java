package org.apache.poi.xssf.usermodel;

import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class XSSFChildAnchor extends XSSFAnchor {
    private CTTransform2D t2d;

    public XSSFChildAnchor(int i, int i2, int i3, int i4) {
        CTTransform2D cTTransform2DNewInstance = CTTransform2D.Factory.newInstance();
        this.t2d = cTTransform2DNewInstance;
        CTPoint2D cTPoint2DAddNewOff = cTTransform2DNewInstance.addNewOff();
        CTPositiveSize2D cTPositiveSize2DAddNewExt = this.t2d.addNewExt();
        cTPoint2DAddNewOff.setX(i);
        cTPoint2DAddNewOff.setY(i2);
        cTPositiveSize2DAddNewExt.setCx(Math.abs(i3 - i));
        cTPositiveSize2DAddNewExt.setCy(Math.abs(i4 - i2));
        if (i > i3) {
            this.t2d.setFlipH(true);
        }
        if (i2 > i4) {
            this.t2d.setFlipV(true);
        }
    }

    public XSSFChildAnchor(CTTransform2D cTTransform2D) {
        this.t2d = cTTransform2D;
    }

    @Internal
    public CTTransform2D getCTTransform2D() {
        return this.t2d;
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public int getDx1() {
        return (int) this.t2d.getOff().getX();
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public void setDx1(int i) {
        this.t2d.getOff().setX(i);
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public int getDy1() {
        return (int) this.t2d.getOff().getY();
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public void setDy1(int i) {
        this.t2d.getOff().setY(i);
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public int getDy2() {
        return (int) (((long) getDy1()) + this.t2d.getExt().getCy());
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public void setDy2(int i) {
        this.t2d.getExt().setCy(i - getDy1());
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public int getDx2() {
        return (int) (((long) getDx1()) + this.t2d.getExt().getCx());
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public void setDx2(int i) {
        this.t2d.getExt().setCx(i - getDx1());
    }
}
