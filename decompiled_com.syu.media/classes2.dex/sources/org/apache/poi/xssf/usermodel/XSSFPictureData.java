package org.apache.poi.xssf.usermodel;

import java.io.IOException;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLRelation;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.util.IOUtils;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFPictureData extends POIXMLDocumentPart implements PictureData {
    protected static final POIXMLRelation[] RELATIONS;

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void prepareForCommit() {
    }

    static {
        POIXMLRelation[] pOIXMLRelationArr = new POIXMLRelation[13];
        RELATIONS = pOIXMLRelationArr;
        pOIXMLRelationArr[2] = XSSFRelation.IMAGE_EMF;
        pOIXMLRelationArr[3] = XSSFRelation.IMAGE_WMF;
        pOIXMLRelationArr[4] = XSSFRelation.IMAGE_PICT;
        pOIXMLRelationArr[5] = XSSFRelation.IMAGE_JPEG;
        pOIXMLRelationArr[6] = XSSFRelation.IMAGE_PNG;
        pOIXMLRelationArr[7] = XSSFRelation.IMAGE_DIB;
        pOIXMLRelationArr[8] = XSSFRelation.IMAGE_GIF;
        pOIXMLRelationArr[9] = XSSFRelation.IMAGE_TIFF;
        pOIXMLRelationArr[10] = XSSFRelation.IMAGE_EPS;
        pOIXMLRelationArr[11] = XSSFRelation.IMAGE_BMP;
        pOIXMLRelationArr[12] = XSSFRelation.IMAGE_WPG;
    }

    protected XSSFPictureData() {
    }

    protected XSSFPictureData(PackagePart packagePart) {
        super(packagePart);
    }

    @Override // org.apache.poi.ss.usermodel.PictureData
    public byte[] getData() {
        try {
            return IOUtils.toByteArray(getPackagePart().getInputStream());
        } catch (IOException e) {
            throw new POIXMLException(e);
        }
    }

    @Override // org.apache.poi.ss.usermodel.PictureData
    public String suggestFileExtension() {
        return getPackagePart().getPartName().getExtension();
    }

    @Override // org.apache.poi.ss.usermodel.PictureData
    public int getPictureType() {
        String contentType = getPackagePart().getContentType();
        int i = 0;
        while (true) {
            POIXMLRelation[] pOIXMLRelationArr = RELATIONS;
            if (i >= pOIXMLRelationArr.length) {
                return 0;
            }
            POIXMLRelation pOIXMLRelation = pOIXMLRelationArr[i];
            if (pOIXMLRelation != null && pOIXMLRelation.getContentType().equals(contentType)) {
                return i;
            }
            i++;
        }
    }

    @Override // org.apache.poi.ss.usermodel.PictureData
    public String getMimeType() {
        return getPackagePart().getContentType();
    }
}
