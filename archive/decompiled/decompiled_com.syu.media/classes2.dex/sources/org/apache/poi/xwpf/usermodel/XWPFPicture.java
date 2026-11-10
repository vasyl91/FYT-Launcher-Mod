package org.apache.poi.xwpf.usermodel;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XWPFPicture {
    private CTPicture ctPic;
    private String description;
    private XWPFRun run;

    public XWPFPicture(CTPicture cTPicture, XWPFRun xWPFRun) {
        this.run = xWPFRun;
        this.ctPic = cTPicture;
        this.description = cTPicture.getNvPicPr().getCNvPr().getDescr();
    }

    public void setPictureReference(PackageRelationship packageRelationship) {
        this.ctPic.getBlipFill().getBlip().setEmbed(packageRelationship.getId());
    }

    public CTPicture getCTPicture() {
        return this.ctPic;
    }

    public XWPFPictureData getPictureData() {
        CTBlipFillProperties blipFill = this.ctPic.getBlipFill();
        if (blipFill != null && blipFill.isSetBlip()) {
            String embed = blipFill.getBlip().getEmbed();
            POIXMLDocumentPart part = this.run.getParent().getPart();
            if (part != null) {
                POIXMLDocumentPart relationById = part.getRelationById(embed);
                if (relationById instanceof XWPFPictureData) {
                    return (XWPFPictureData) relationById;
                }
            }
        }
        return null;
    }

    public String getDescription() {
        return this.description;
    }
}
