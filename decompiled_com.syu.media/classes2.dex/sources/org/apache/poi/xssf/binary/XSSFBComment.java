package org.apache.poi.xssf.binary;

import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.XSSFComment;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
class XSSFBComment extends XSSFComment {
    private final String author;
    private final CellAddress cellAddress;
    private final XSSFBRichTextString comment;
    private boolean visible;

    @Override // org.apache.poi.xssf.usermodel.XSSFComment, org.apache.poi.ss.usermodel.Comment
    public ClientAnchor getClientAnchor() {
        return null;
    }

    XSSFBComment(CellAddress cellAddress, String str, String str2) {
        super(null, null, null);
        this.visible = true;
        this.cellAddress = cellAddress;
        this.author = str;
        this.comment = new XSSFBRichTextString(str2);
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFComment, org.apache.poi.ss.usermodel.Comment
    public void setVisible(boolean z) {
        throw new IllegalArgumentException("XSSFBComment is read only.");
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFComment, org.apache.poi.ss.usermodel.Comment
    public boolean isVisible() {
        return this.visible;
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFComment, org.apache.poi.ss.usermodel.Comment
    public CellAddress getAddress() {
        return this.cellAddress;
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFComment, org.apache.poi.ss.usermodel.Comment
    public void setAddress(CellAddress cellAddress) {
        throw new IllegalArgumentException("XSSFBComment is read only");
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFComment, org.apache.poi.ss.usermodel.Comment
    public void setAddress(int i, int i2) {
        throw new IllegalArgumentException("XSSFBComment is read only");
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFComment, org.apache.poi.ss.usermodel.Comment
    public int getRow() {
        return this.cellAddress.getRow();
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFComment, org.apache.poi.ss.usermodel.Comment
    public void setRow(int i) {
        throw new IllegalArgumentException("XSSFBComment is read only");
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFComment, org.apache.poi.ss.usermodel.Comment
    public int getColumn() {
        return this.cellAddress.getColumn();
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFComment, org.apache.poi.ss.usermodel.Comment
    public void setColumn(int i) {
        throw new IllegalArgumentException("XSSFBComment is read only");
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFComment, org.apache.poi.ss.usermodel.Comment
    public String getAuthor() {
        return this.author;
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFComment, org.apache.poi.ss.usermodel.Comment
    public void setAuthor(String str) {
        throw new IllegalArgumentException("XSSFBComment is read only");
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFComment, org.apache.poi.ss.usermodel.Comment
    public XSSFBRichTextString getString() {
        return this.comment;
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFComment, org.apache.poi.ss.usermodel.Comment
    public void setString(RichTextString richTextString) {
        throw new IllegalArgumentException("XSSFBComment is read only");
    }
}
