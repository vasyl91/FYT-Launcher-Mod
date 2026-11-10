package org.apache.poi.xslf.usermodel;

import org.apache.poi.util.Removal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;
import org.openxmlformats.schemas.presentationml.x2006.main.STPlaceholderType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Removal(version = "3.18")
public class DrawingTextPlaceholder extends DrawingTextBody {
    private final CTPlaceholder placeholder;

    public DrawingTextPlaceholder(CTTextBody cTTextBody, CTPlaceholder cTPlaceholder) {
        super(cTTextBody);
        this.placeholder = cTPlaceholder;
    }

    public String getPlaceholderType() {
        return this.placeholder.getType().toString();
    }

    public STPlaceholderType.Enum getPlaceholderTypeEnum() {
        return this.placeholder.getType();
    }

    public boolean isPlaceholderCustom() {
        return this.placeholder.getHasCustomPrompt();
    }
}
