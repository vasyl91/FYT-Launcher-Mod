package org.apache.poi.xslf.usermodel;

import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.sl.usermodel.ShapeContainer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface XSLFShapeContainer extends ShapeContainer<XSLFShape, XSLFTextParagraph> {
    void clear();

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    XSLFAutoShape createAutoShape();

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    XSLFConnectorShape createConnector();

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    XSLFFreeformShape createFreeform();

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    XSLFGroupShape createGroup();

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    XSLFPictureShape createPicture(PictureData pictureData);

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    XSLFTextBox createTextBox();
}
