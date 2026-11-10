package org.apache.poi.xwpf.model;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class XWPFParagraphDecorator {
    protected XWPFParagraphDecorator nextDecorator;
    protected XWPFParagraph paragraph;

    public XWPFParagraphDecorator(XWPFParagraph xWPFParagraph) {
        this(xWPFParagraph, null);
    }

    public XWPFParagraphDecorator(XWPFParagraph xWPFParagraph, XWPFParagraphDecorator xWPFParagraphDecorator) {
        this.paragraph = xWPFParagraph;
        this.nextDecorator = xWPFParagraphDecorator;
    }

    public String getText() {
        XWPFParagraphDecorator xWPFParagraphDecorator = this.nextDecorator;
        if (xWPFParagraphDecorator != null) {
            return xWPFParagraphDecorator.getText();
        }
        return this.paragraph.getText();
    }
}
