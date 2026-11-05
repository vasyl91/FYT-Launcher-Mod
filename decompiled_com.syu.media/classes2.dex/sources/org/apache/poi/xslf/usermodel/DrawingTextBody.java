package org.apache.poi.xslf.usermodel;

import org.apache.poi.util.Removal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Removal(version = "3.18")
public class DrawingTextBody {
    private final CTTextBody textBody;

    public DrawingTextBody(CTTextBody cTTextBody) {
        this.textBody = cTTextBody;
    }

    public DrawingParagraph[] getParagraphs() {
        CTTextParagraph[] pArray = this.textBody.getPArray();
        int length = pArray.length;
        DrawingParagraph[] drawingParagraphArr = new DrawingParagraph[length];
        for (int i = 0; i < length; i++) {
            drawingParagraphArr[i] = new DrawingParagraph(pArray[i]);
        }
        return drawingParagraphArr;
    }
}
