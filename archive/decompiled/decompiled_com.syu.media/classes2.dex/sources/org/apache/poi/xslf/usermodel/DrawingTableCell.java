package org.apache.poi.xslf.usermodel;

import org.apache.poi.util.Removal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCell;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Removal(version = "3.18")
public class DrawingTableCell {
    private final CTTableCell cell;
    private final DrawingTextBody drawingTextBody;

    public DrawingTableCell(CTTableCell cTTableCell) {
        this.cell = cTTableCell;
        this.drawingTextBody = new DrawingTextBody(cTTableCell.getTxBody());
    }

    public DrawingTextBody getTextBody() {
        return this.drawingTextBody;
    }
}
