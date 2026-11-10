package org.apache.poi.xwpf.usermodel;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XWPFSDTCell extends AbstractXWPFSDT implements ICell {
    private final XWPFSDTContentCell cellContent;

    public XWPFSDTCell(CTSdtCell cTSdtCell, XWPFTableRow xWPFTableRow, IBody iBody) {
        super(cTSdtCell.getSdtPr(), iBody);
        this.cellContent = new XWPFSDTContentCell(cTSdtCell.getSdtContent(), xWPFTableRow, iBody);
    }

    @Override // org.apache.poi.xwpf.usermodel.AbstractXWPFSDT
    public ISDTContent getContent() {
        return this.cellContent;
    }
}
