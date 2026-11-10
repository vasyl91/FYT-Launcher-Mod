package org.apache.poi.xwpf.extractor;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.model.XWPFCommentsDecorator;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.ICell;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHyperlink;
import org.apache.poi.xwpf.usermodel.XWPFHyperlinkRun;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRelation;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFSDT;
import org.apache.poi.xwpf.usermodel.XWPFSDTCell;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XWPFWordExtractor extends POIXMLTextExtractor {
    public static final XWPFRelation[] SUPPORTED_TYPES = {XWPFRelation.DOCUMENT, XWPFRelation.TEMPLATE, XWPFRelation.MACRO_DOCUMENT, XWPFRelation.MACRO_TEMPLATE_DOCUMENT};
    private boolean concatenatePhoneticRuns;
    private XWPFDocument document;
    private boolean fetchHyperlinks;

    public XWPFWordExtractor(OPCPackage oPCPackage) throws XmlException, OpenXML4JException, IOException {
        this(new XWPFDocument(oPCPackage));
    }

    public XWPFWordExtractor(XWPFDocument xWPFDocument) {
        super(xWPFDocument);
        this.fetchHyperlinks = false;
        this.concatenatePhoneticRuns = true;
        this.document = xWPFDocument;
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length < 1) {
            System.err.println("Use:");
            System.err.println("  XWPFWordExtractor <filename.docx>");
            System.exit(1);
        }
        XWPFWordExtractor xWPFWordExtractor = new XWPFWordExtractor(POIXMLDocument.openPackage(strArr[0]));
        System.out.println(xWPFWordExtractor.getText());
        xWPFWordExtractor.close();
    }

    public void setFetchHyperlinks(boolean z) {
        this.fetchHyperlinks = z;
    }

    public void setConcatenatePhoneticRuns(boolean z) {
        this.concatenatePhoneticRuns = z;
    }

    @Override // org.apache.poi.POITextExtractor
    public String getText() {
        StringBuffer stringBuffer = new StringBuffer();
        XWPFHeaderFooterPolicy headerFooterPolicy = this.document.getHeaderFooterPolicy();
        extractHeaders(stringBuffer, headerFooterPolicy);
        Iterator<IBodyElement> it = this.document.getBodyElements().iterator();
        while (it.hasNext()) {
            appendBodyElementText(stringBuffer, it.next());
            stringBuffer.append('\n');
        }
        extractFooters(stringBuffer, headerFooterPolicy);
        return stringBuffer.toString();
    }

    public void appendBodyElementText(StringBuffer stringBuffer, IBodyElement iBodyElement) {
        if (iBodyElement instanceof XWPFParagraph) {
            appendParagraphText(stringBuffer, (XWPFParagraph) iBodyElement);
        } else if (iBodyElement instanceof XWPFTable) {
            appendTableText(stringBuffer, (XWPFTable) iBodyElement);
        } else if (iBodyElement instanceof XWPFSDT) {
            stringBuffer.append(((XWPFSDT) iBodyElement).getContent().getText());
        }
    }

    public void appendParagraphText(StringBuffer stringBuffer, XWPFParagraph xWPFParagraph) {
        XWPFHeaderFooterPolicy xWPFHeaderFooterPolicy;
        XWPFHyperlink hyperlink;
        CTSectPr sectPr = xWPFParagraph.getCTP().getPPr() != null ? xWPFParagraph.getCTP().getPPr().getSectPr() : null;
        if (sectPr != null) {
            xWPFHeaderFooterPolicy = new XWPFHeaderFooterPolicy(this.document, sectPr);
            extractHeaders(stringBuffer, xWPFHeaderFooterPolicy);
        } else {
            xWPFHeaderFooterPolicy = null;
        }
        for (XWPFRun xWPFRun : xWPFParagraph.getRuns()) {
            if (this.concatenatePhoneticRuns || !(xWPFRun instanceof XWPFRun)) {
                stringBuffer.append(xWPFRun);
            } else {
                stringBuffer.append(xWPFRun.text());
            }
            if ((xWPFRun instanceof XWPFHyperlinkRun) && this.fetchHyperlinks && (hyperlink = ((XWPFHyperlinkRun) xWPFRun).getHyperlink(this.document)) != null) {
                stringBuffer.append(" <").append(hyperlink.getURL()).append(">");
            }
        }
        String commentText = new XWPFCommentsDecorator(xWPFParagraph, null).getCommentText();
        if (commentText.length() > 0) {
            stringBuffer.append(commentText).append('\n');
        }
        String footnoteText = xWPFParagraph.getFootnoteText();
        if (footnoteText != null && footnoteText.length() > 0) {
            stringBuffer.append(footnoteText).append('\n');
        }
        if (sectPr != null) {
            extractFooters(stringBuffer, xWPFHeaderFooterPolicy);
        }
    }

    private void appendTableText(StringBuffer stringBuffer, XWPFTable xWPFTable) {
        Iterator<XWPFTableRow> it = xWPFTable.getRows().iterator();
        while (it.hasNext()) {
            List<ICell> tableICells = it.next().getTableICells();
            for (int i = 0; i < tableICells.size(); i++) {
                ICell iCell = tableICells.get(i);
                if (iCell instanceof XWPFTableCell) {
                    stringBuffer.append(((XWPFTableCell) iCell).getTextRecursively());
                } else if (iCell instanceof XWPFSDTCell) {
                    stringBuffer.append(((XWPFSDTCell) iCell).getContent().getText());
                }
                if (i < tableICells.size() - 1) {
                    stringBuffer.append("\t");
                }
            }
            stringBuffer.append('\n');
        }
    }

    private void extractFooters(StringBuffer stringBuffer, XWPFHeaderFooterPolicy xWPFHeaderFooterPolicy) {
        if (xWPFHeaderFooterPolicy == null) {
            return;
        }
        if (xWPFHeaderFooterPolicy.getFirstPageFooter() != null) {
            stringBuffer.append(xWPFHeaderFooterPolicy.getFirstPageFooter().getText());
        }
        if (xWPFHeaderFooterPolicy.getEvenPageFooter() != null) {
            stringBuffer.append(xWPFHeaderFooterPolicy.getEvenPageFooter().getText());
        }
        if (xWPFHeaderFooterPolicy.getDefaultFooter() != null) {
            stringBuffer.append(xWPFHeaderFooterPolicy.getDefaultFooter().getText());
        }
    }

    private void extractHeaders(StringBuffer stringBuffer, XWPFHeaderFooterPolicy xWPFHeaderFooterPolicy) {
        if (xWPFHeaderFooterPolicy == null) {
            return;
        }
        if (xWPFHeaderFooterPolicy.getFirstPageHeader() != null) {
            stringBuffer.append(xWPFHeaderFooterPolicy.getFirstPageHeader().getText());
        }
        if (xWPFHeaderFooterPolicy.getEvenPageHeader() != null) {
            stringBuffer.append(xWPFHeaderFooterPolicy.getEvenPageHeader().getText());
        }
        if (xWPFHeaderFooterPolicy.getDefaultHeader() != null) {
            stringBuffer.append(xWPFHeaderFooterPolicy.getDefaultHeader().getText());
        }
    }
}
