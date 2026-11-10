package org.apache.poi.xwpf.usermodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XWPFSDTContent implements ISDTContent {
    private List<XWPFParagraph> paragraphs = new ArrayList();
    private List<XWPFTable> tables = new ArrayList();
    private List<XWPFRun> runs = new ArrayList();
    private List<XWPFSDT> contentControls = new ArrayList();
    private List<ISDTContents> bodyElements = new ArrayList();

    public XWPFSDTContent(CTSdtContentRun cTSdtContentRun, IBody iBody, IRunBody iRunBody) {
        for (CTR ctr : cTSdtContentRun.getRArray()) {
            XWPFRun xWPFRun = new XWPFRun(ctr, iRunBody);
            this.runs.add(xWPFRun);
            this.bodyElements.add(xWPFRun);
        }
    }

    public XWPFSDTContent(CTSdtContentBlock cTSdtContentBlock, IBody iBody, IRunBody iRunBody) {
        XmlCursor xmlCursorNewCursor = cTSdtContentBlock.newCursor();
        xmlCursorNewCursor.selectPath("./*");
        while (xmlCursorNewCursor.toNextSelection()) {
            CTR object = xmlCursorNewCursor.getObject();
            if (object instanceof CTP) {
                XWPFParagraph xWPFParagraph = new XWPFParagraph((CTP) object, iBody);
                this.bodyElements.add(xWPFParagraph);
                this.paragraphs.add(xWPFParagraph);
            } else if (object instanceof CTTbl) {
                XWPFTable xWPFTable = new XWPFTable((CTTbl) object, iBody);
                this.bodyElements.add(xWPFTable);
                this.tables.add(xWPFTable);
            } else if (object instanceof CTSdtBlock) {
                XWPFSDT xwpfsdt = new XWPFSDT((CTSdtBlock) object, iBody);
                this.bodyElements.add(xwpfsdt);
                this.contentControls.add(xwpfsdt);
            } else if (object instanceof CTR) {
                XWPFRun xWPFRun = new XWPFRun(object, iRunBody);
                this.runs.add(xWPFRun);
                this.bodyElements.add(xWPFRun);
            }
        }
        xmlCursorNewCursor.dispose();
    }

    @Override // org.apache.poi.xwpf.usermodel.ISDTContent
    public String getText() {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (int i = 0; i < this.bodyElements.size(); i++) {
            ISDTContents iSDTContents = this.bodyElements.get(i);
            if (iSDTContents instanceof XWPFParagraph) {
                appendParagraph((XWPFParagraph) iSDTContents, sb);
            } else if (iSDTContents instanceof XWPFTable) {
                appendTable((XWPFTable) iSDTContents, sb);
            } else {
                if (iSDTContents instanceof XWPFSDT) {
                    sb.append(((XWPFSDT) iSDTContents).getContent().getText());
                } else if (iSDTContents instanceof XWPFRun) {
                    sb.append((XWPFRun) iSDTContents);
                    z = false;
                }
                if (!z && i < this.bodyElements.size() - 1) {
                    sb.append("\n");
                }
            }
            z = true;
            if (!z) {
            }
        }
        return sb.toString();
    }

    private void appendTable(XWPFTable xWPFTable, StringBuilder sb) {
        Iterator<XWPFTableRow> it = xWPFTable.getRows().iterator();
        while (it.hasNext()) {
            List<ICell> tableICells = it.next().getTableICells();
            for (int i = 0; i < tableICells.size(); i++) {
                ICell iCell = tableICells.get(i);
                if (iCell instanceof XWPFTableCell) {
                    sb.append(((XWPFTableCell) iCell).getTextRecursively());
                } else if (iCell instanceof XWPFSDTCell) {
                    sb.append(((XWPFSDTCell) iCell).getContent().getText());
                }
                if (i < tableICells.size() - 1) {
                    sb.append("\t");
                }
            }
            sb.append('\n');
        }
    }

    private void appendParagraph(XWPFParagraph xWPFParagraph, StringBuilder sb) {
        Iterator<XWPFRun> it = xWPFParagraph.getRuns().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
    }

    @Override // org.apache.poi.xwpf.usermodel.ISDTContent
    public String toString() {
        return getText();
    }
}
