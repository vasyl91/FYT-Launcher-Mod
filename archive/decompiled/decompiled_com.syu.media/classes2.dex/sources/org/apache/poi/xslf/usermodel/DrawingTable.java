package org.apache.poi.xslf.usermodel;

import org.apache.poi.util.Removal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTable;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Removal(version = "3.18")
public class DrawingTable {
    private final CTTable table;

    public DrawingTable(CTTable cTTable) {
        this.table = cTTable;
    }

    public DrawingTableRow[] getRows() {
        CTTableRow[] trArray = this.table.getTrArray();
        int length = trArray.length;
        DrawingTableRow[] drawingTableRowArr = new DrawingTableRow[length];
        for (int i = 0; i < length; i++) {
            drawingTableRowArr[i] = new DrawingTableRow(trArray[i]);
        }
        return drawingTableRowArr;
    }
}
