package org.apache.poi.xslf.usermodel;

import org.apache.poi.util.Removal;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Removal(version = "3.18")
public class DrawingParagraph {
    private final CTTextParagraph p;

    public DrawingParagraph(CTTextParagraph cTTextParagraph) {
        this.p = cTTextParagraph;
    }

    public CharSequence getText() {
        StringBuilder sb = new StringBuilder();
        XmlCursor xmlCursorNewCursor = this.p.newCursor();
        xmlCursorNewCursor.selectPath("./*");
        while (xmlCursorNewCursor.toNextSelection()) {
            CTRegularTextRun object = xmlCursorNewCursor.getObject();
            if (object instanceof CTRegularTextRun) {
                sb.append(object.getT());
            } else if (object instanceof CTTextLineBreak) {
                sb.append('\n');
            }
        }
        xmlCursorNewCursor.dispose();
        return sb;
    }
}
