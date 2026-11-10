package org.apache.poi.xslf.model;

import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class CharacterPropertyFetcher<T> extends ParagraphPropertyFetcher<T> {
    public abstract boolean fetch(CTTextCharacterProperties cTTextCharacterProperties);

    public CharacterPropertyFetcher(int i) {
        super(i);
    }

    @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
    public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
        if (cTTextParagraphProperties == null || !cTTextParagraphProperties.isSetDefRPr()) {
            return false;
        }
        return fetch(cTTextParagraphProperties.getDefRPr());
    }
}
