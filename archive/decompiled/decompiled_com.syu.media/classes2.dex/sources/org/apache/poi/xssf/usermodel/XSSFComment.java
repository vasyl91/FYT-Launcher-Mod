package org.apache.poi.xssf.usermodel;

import com.microsoft.schemas.office.excel.CTClientData;
import com.microsoft.schemas.vml.CTShape;
import java.math.BigInteger;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.model.CommentsTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFComment implements Comment {
    private final CTComment _comment;
    private final CommentsTable _comments;
    private XSSFRichTextString _str;
    private final CTShape _vmlShape;

    public XSSFComment(CommentsTable commentsTable, CTComment cTComment, CTShape cTShape) {
        this._comment = cTComment;
        this._comments = commentsTable;
        this._vmlShape = cTShape;
        if (cTShape == null || cTShape.sizeOfClientDataArray() <= 0) {
            return;
        }
        CellReference cellReference = new CellReference(cTComment.getRef());
        CTClientData clientDataArray = cTShape.getClientDataArray(0);
        clientDataArray.setRowArray(0, new BigInteger(String.valueOf(cellReference.getRow())));
        clientDataArray.setColumnArray(0, new BigInteger(String.valueOf((int) cellReference.getCol())));
        avoidXmlbeansCorruptPointer(cTShape);
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public String getAuthor() {
        return this._comments.getAuthor((int) this._comment.getAuthorId());
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public void setAuthor(String str) {
        this._comment.setAuthorId(this._comments.findAuthor(str));
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public int getColumn() {
        return getAddress().getColumn();
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public int getRow() {
        return getAddress().getRow();
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public boolean isVisible() {
        String style;
        CTShape cTShape = this._vmlShape;
        return (cTShape == null || (style = cTShape.getStyle()) == null || !style.contains("visibility:visible")) ? false : true;
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public void setVisible(boolean z) {
        CTShape cTShape = this._vmlShape;
        if (cTShape != null) {
            cTShape.setStyle(z ? "position:absolute;visibility:visible" : "position:absolute;visibility:hidden");
        }
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public CellAddress getAddress() {
        return new CellAddress(this._comment.getRef());
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public void setAddress(int i, int i2) {
        setAddress(new CellAddress(i, i2));
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public void setAddress(CellAddress cellAddress) {
        CellAddress cellAddress2 = new CellAddress(this._comment.getRef());
        if (cellAddress.equals(cellAddress2)) {
            return;
        }
        this._comment.setRef(cellAddress.formatAsString());
        this._comments.referenceUpdated(cellAddress2, this._comment);
        CTShape cTShape = this._vmlShape;
        if (cTShape != null) {
            CTClientData clientDataArray = cTShape.getClientDataArray(0);
            clientDataArray.setRowArray(0, new BigInteger(String.valueOf(cellAddress.getRow())));
            clientDataArray.setColumnArray(0, new BigInteger(String.valueOf(cellAddress.getColumn())));
            avoidXmlbeansCorruptPointer(this._vmlShape);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public void setColumn(int i) {
        setAddress(getRow(), i);
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public void setRow(int i) {
        setAddress(i, getColumn());
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public XSSFRichTextString getString() {
        if (this._str == null && this._comment.getText() != null) {
            this._str = new XSSFRichTextString(this._comment.getText());
        }
        return this._str;
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public void setString(RichTextString richTextString) {
        if (!(richTextString instanceof XSSFRichTextString)) {
            throw new IllegalArgumentException("Only XSSFRichTextString argument is supported");
        }
        XSSFRichTextString xSSFRichTextString = (XSSFRichTextString) richTextString;
        this._str = xSSFRichTextString;
        this._comment.setText(xSSFRichTextString.getCTRst());
    }

    public void setString(String str) {
        setString(new XSSFRichTextString(str));
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public ClientAnchor getClientAnchor() {
        int[] iArr = new int[8];
        String[] strArrSplit = this._vmlShape.getClientDataArray(0).getAnchorArray(0).split(",");
        int length = strArrSplit.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            iArr[i2] = Integer.parseInt(strArrSplit[i].trim());
            i++;
            i2++;
        }
        return new XSSFClientAnchor(iArr[1] * 9525, iArr[3] * 9525, iArr[5] * 9525, iArr[7] * 9525, iArr[0], iArr[2], iArr[4], iArr[6]);
    }

    protected CTComment getCTComment() {
        return this._comment;
    }

    protected CTShape getCTShape() {
        return this._vmlShape;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof XSSFComment)) {
            return false;
        }
        XSSFComment xSSFComment = (XSSFComment) obj;
        return getCTComment() == xSSFComment.getCTComment() && getCTShape() == xSSFComment.getCTShape();
    }

    public int hashCode() {
        return ((getRow() * 17) + getColumn()) * 31;
    }

    private static void avoidXmlbeansCorruptPointer(CTShape cTShape) {
        cTShape.getClientDataList().toString();
    }
}
