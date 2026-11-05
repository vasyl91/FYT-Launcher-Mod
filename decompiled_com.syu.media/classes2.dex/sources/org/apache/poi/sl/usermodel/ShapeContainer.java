package org.apache.poi.sl.usermodel;

import java.util.List;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.TextParagraph;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface ShapeContainer<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends Iterable<S> {
    void addShape(S s);

    AutoShape<S, P> createAutoShape();

    ConnectorShape<S, P> createConnector();

    FreeformShape<S, P> createFreeform();

    GroupShape<S, P> createGroup();

    PictureShape<S, P> createPicture(PictureData pictureData);

    TableShape<S, P> createTable(int i, int i2);

    TextBox<S, P> createTextBox();

    List<S> getShapes();

    boolean removeShape(S s);
}
