package org.apache.poi.xwpf.usermodel;

import org.apache.poi.POIXMLDocumentPart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class AbstractXWPFSDT implements ISDTContents {
    private final IBody part;
    private final String tag;
    private final String title;

    public IBody getBody() {
        return null;
    }

    public abstract ISDTContent getContent();

    public AbstractXWPFSDT(CTSdtPr cTSdtPr, IBody iBody) {
        if (cTSdtPr == null) {
            this.title = "";
            this.tag = "";
        } else {
            CTString[] aliasArray = cTSdtPr.getAliasArray();
            if (aliasArray != null && aliasArray.length > 0) {
                this.title = aliasArray[0].getVal();
            } else {
                this.title = "";
            }
            CTString[] tagArray = cTSdtPr.getTagArray();
            if (tagArray != null && tagArray.length > 0) {
                this.tag = tagArray[0].getVal();
            } else {
                this.tag = "";
            }
        }
        this.part = iBody;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTag() {
        return this.tag;
    }

    public POIXMLDocumentPart getPart() {
        return this.part.getPart();
    }

    public BodyType getPartType() {
        return BodyType.CONTENTCONTROL;
    }

    public BodyElementType getElementType() {
        return BodyElementType.CONTENTCONTROL;
    }

    public XWPFDocument getDocument() {
        return this.part.getXWPFDocument();
    }
}
