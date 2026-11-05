package org.apache.poi.xslf.usermodel;

import org.apache.poi.util.Removal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCell;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Removal(version = "3.18")
public class DrawingTableRow {
    private final CTTableRow row;

    public DrawingTableRow(CTTableRow cTTableRow) {
        this.row = cTTableRow;
    }

    public DrawingTableCell[] getCells() {
        CTTableCell[] tcArray = this.row.getTcArray();
        int length = tcArray.length;
        DrawingTableCell[] drawingTableCellArr = new DrawingTableCell[length];
        for (int i = 0; i < length; i++) {
            drawingTableCellArr[i] = new DrawingTableCell(tcArray[i]);
        }
        return drawingTableCellArr;
    }
}
