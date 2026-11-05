package org.apache.poi.xwpf.model;

import org.apache.poi.xwpf.usermodel.XWPFComment;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XWPFCommentsDecorator extends XWPFParagraphDecorator {
    private StringBuffer commentText;

    public XWPFCommentsDecorator(XWPFParagraphDecorator xWPFParagraphDecorator) {
        this(xWPFParagraphDecorator.paragraph, xWPFParagraphDecorator);
    }

    public XWPFCommentsDecorator(XWPFParagraph xWPFParagraph, XWPFParagraphDecorator xWPFParagraphDecorator) {
        super(xWPFParagraph, xWPFParagraphDecorator);
        this.commentText = new StringBuffer();
        for (CTMarkupRange cTMarkupRange : xWPFParagraph.getCTP().getCommentRangeStartArray()) {
            XWPFComment commentByID = xWPFParagraph.getDocument().getCommentByID(cTMarkupRange.getId().toString());
            if (commentByID != null) {
                this.commentText.append("\tComment by " + commentByID.getAuthor() + ": " + commentByID.getText());
            }
        }
    }

    public String getCommentText() {
        return this.commentText.toString();
    }

    @Override // org.apache.poi.xwpf.model.XWPFParagraphDecorator
    public String getText() {
        return super.getText() + ((Object) this.commentText);
    }
}
