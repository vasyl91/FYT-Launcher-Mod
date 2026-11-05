package org.apache.poi.xwpf.usermodel;

import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XWPFHyperlinkRun extends XWPFRun {
    private CTHyperlink hyperlink;

    public XWPFHyperlinkRun(CTHyperlink cTHyperlink, CTR ctr, IRunBody iRunBody) {
        super(ctr, iRunBody);
        this.hyperlink = cTHyperlink;
    }

    @Internal
    public CTHyperlink getCTHyperlink() {
        return this.hyperlink;
    }

    public String getAnchor() {
        return this.hyperlink.getAnchor();
    }

    public String getHyperlinkId() {
        return this.hyperlink.getId();
    }

    public void setHyperlinkId(String str) {
        this.hyperlink.setId(str);
    }

    public XWPFHyperlink getHyperlink(XWPFDocument xWPFDocument) {
        String hyperlinkId = getHyperlinkId();
        if (hyperlinkId == null) {
            return null;
        }
        return xWPFDocument.getHyperlinkByID(hyperlinkId);
    }
}
