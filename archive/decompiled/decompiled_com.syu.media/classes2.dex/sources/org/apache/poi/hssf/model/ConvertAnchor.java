package org.apache.poi.hssf.model;

import org.apache.poi.ddf.EscherChildAnchorRecord;
import org.apache.poi.ddf.EscherClientAnchorRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.hssf.usermodel.HSSFAnchor;
import org.apache.poi.hssf.usermodel.HSSFChildAnchor;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ConvertAnchor {
    public static EscherRecord createAnchor(HSSFAnchor hSSFAnchor) {
        if (hSSFAnchor instanceof HSSFClientAnchor) {
            HSSFClientAnchor hSSFClientAnchor = (HSSFClientAnchor) hSSFAnchor;
            EscherClientAnchorRecord escherClientAnchorRecord = new EscherClientAnchorRecord();
            escherClientAnchorRecord.setRecordId(EscherClientAnchorRecord.RECORD_ID);
            escherClientAnchorRecord.setOptions((short) 0);
            escherClientAnchorRecord.setFlag(hSSFClientAnchor.getAnchorType().value);
            escherClientAnchorRecord.setCol1((short) Math.min((int) hSSFClientAnchor.getCol1(), (int) hSSFClientAnchor.getCol2()));
            escherClientAnchorRecord.setDx1((short) hSSFClientAnchor.getDx1());
            escherClientAnchorRecord.setRow1((short) Math.min(hSSFClientAnchor.getRow1(), hSSFClientAnchor.getRow2()));
            escherClientAnchorRecord.setDy1((short) hSSFClientAnchor.getDy1());
            escherClientAnchorRecord.setCol2((short) Math.max((int) hSSFClientAnchor.getCol1(), (int) hSSFClientAnchor.getCol2()));
            escherClientAnchorRecord.setDx2((short) hSSFClientAnchor.getDx2());
            escherClientAnchorRecord.setRow2((short) Math.max(hSSFClientAnchor.getRow1(), hSSFClientAnchor.getRow2()));
            escherClientAnchorRecord.setDy2((short) hSSFClientAnchor.getDy2());
            return escherClientAnchorRecord;
        }
        HSSFChildAnchor hSSFChildAnchor = (HSSFChildAnchor) hSSFAnchor;
        EscherChildAnchorRecord escherChildAnchorRecord = new EscherChildAnchorRecord();
        escherChildAnchorRecord.setRecordId(EscherChildAnchorRecord.RECORD_ID);
        escherChildAnchorRecord.setOptions((short) 0);
        escherChildAnchorRecord.setDx1((short) Math.min(hSSFChildAnchor.getDx1(), hSSFChildAnchor.getDx2()));
        escherChildAnchorRecord.setDy1((short) Math.min(hSSFChildAnchor.getDy1(), hSSFChildAnchor.getDy2()));
        escherChildAnchorRecord.setDx2((short) Math.max(hSSFChildAnchor.getDx2(), hSSFChildAnchor.getDx1()));
        escherChildAnchorRecord.setDy2((short) Math.max(hSSFChildAnchor.getDy2(), hSSFChildAnchor.getDy1()));
        return escherChildAnchorRecord;
    }
}
