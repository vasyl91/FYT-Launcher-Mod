package org.apache.poi.xwpf.usermodel;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XWPFSDTContentCell implements ISDTContent {
    private String text;

    public XWPFSDTContentCell(CTSdtContentCell cTSdtContentCell, XWPFTableRow xWPFTableRow, IBody iBody) {
        this.text = "";
        if (cTSdtContentCell == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        XmlCursor xmlCursorNewCursor = cTSdtContentCell.newCursor();
        int i = 1;
        int i2 = 0;
        int i3 = 0;
        while (xmlCursorNewCursor.hasNextToken() && i > 0) {
            if (xmlCursorNewCursor.toNextToken().isText()) {
                sb.append(xmlCursorNewCursor.getTextValue());
            } else if (isStartToken(xmlCursorNewCursor, "tr")) {
                i2 = 0;
                i3 = 0;
            } else if (isStartToken(xmlCursorNewCursor, "tc")) {
                int i4 = i2 + 1;
                if (i2 > 0) {
                    sb.append("\t");
                }
                i2 = i4;
                i3 = 0;
            } else if (isStartToken(xmlCursorNewCursor, "p") || isStartToken(xmlCursorNewCursor, "tbl") || isStartToken(xmlCursorNewCursor, "sdt")) {
                if (i3 > 0) {
                    sb.append("\n");
                }
                i3++;
            }
            if (xmlCursorNewCursor.isStart()) {
                i++;
            } else if (xmlCursorNewCursor.isEnd()) {
                i--;
            }
        }
        this.text = sb.toString();
        xmlCursorNewCursor.dispose();
    }

    private boolean isStartToken(XmlCursor xmlCursor, String str) {
        QName name;
        return xmlCursor.isStart() && (name = xmlCursor.getName()) != null && name.getLocalPart() != null && name.getLocalPart().equals(str);
    }

    @Override // org.apache.poi.xwpf.usermodel.ISDTContent
    public String getText() {
        return this.text;
    }

    @Override // org.apache.poi.xwpf.usermodel.ISDTContent
    public String toString() {
        return getText();
    }
}
