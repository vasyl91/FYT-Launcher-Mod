package org.apache.poi.xwpf.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class TextSegement {
    private PositionInParagraph beginPos;
    private PositionInParagraph endPos;

    public TextSegement() {
        this.beginPos = new PositionInParagraph();
        this.endPos = new PositionInParagraph();
    }

    public TextSegement(int i, int i2, int i3, int i4, int i5, int i6) {
        PositionInParagraph positionInParagraph = new PositionInParagraph(i, i3, i5);
        PositionInParagraph positionInParagraph2 = new PositionInParagraph(i2, i4, i6);
        this.beginPos = positionInParagraph;
        this.endPos = positionInParagraph2;
    }

    public TextSegement(PositionInParagraph positionInParagraph, PositionInParagraph positionInParagraph2) {
        this.beginPos = positionInParagraph;
        this.endPos = positionInParagraph2;
    }

    public PositionInParagraph getBeginPos() {
        return this.beginPos;
    }

    public PositionInParagraph getEndPos() {
        return this.endPos;
    }

    public int getBeginRun() {
        return this.beginPos.getRun();
    }

    public void setBeginRun(int i) {
        this.beginPos.setRun(i);
    }

    public int getBeginText() {
        return this.beginPos.getText();
    }

    public void setBeginText(int i) {
        this.beginPos.setText(i);
    }

    public int getBeginChar() {
        return this.beginPos.getChar();
    }

    public void setBeginChar(int i) {
        this.beginPos.setChar(i);
    }

    public int getEndRun() {
        return this.endPos.getRun();
    }

    public void setEndRun(int i) {
        this.endPos.setRun(i);
    }

    public int getEndText() {
        return this.endPos.getText();
    }

    public void setEndText(int i) {
        this.endPos.setText(i);
    }

    public int getEndChar() {
        return this.endPos.getChar();
    }

    public void setEndChar(int i) {
        this.endPos.setChar(i);
    }
}
