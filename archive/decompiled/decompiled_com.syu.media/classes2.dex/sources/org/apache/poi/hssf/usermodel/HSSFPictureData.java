package org.apache.poi.hssf.usermodel;

import org.apache.poi.ddf.EscherBlipRecord;
import org.apache.poi.openxml4j.opc.ContentTypes;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.util.PngUtils;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HSSFPictureData implements PictureData {
    public static final short FORMAT_MASK = -16;
    public static final short MSOBI_DIB = 31360;
    public static final short MSOBI_EMF = 15680;
    public static final short MSOBI_JPEG = 18080;
    public static final short MSOBI_PICT = 21536;
    public static final short MSOBI_PNG = 28160;
    public static final short MSOBI_WMF = 8544;
    private EscherBlipRecord blip;

    public HSSFPictureData(EscherBlipRecord escherBlipRecord) {
        this.blip = escherBlipRecord;
    }

    @Override // org.apache.poi.ss.usermodel.PictureData
    public byte[] getData() {
        byte[] picturedata = this.blip.getPicturedata();
        if (!PngUtils.matchesPngHeader(picturedata, 16)) {
            return picturedata;
        }
        int length = picturedata.length - 16;
        byte[] bArr = new byte[length];
        System.arraycopy(picturedata, 16, bArr, 0, length);
        return bArr;
    }

    public int getFormat() {
        return this.blip.getRecordId() + 4072;
    }

    @Override // org.apache.poi.ss.usermodel.PictureData
    public String suggestFileExtension() {
        switch (this.blip.getRecordId()) {
            case -4070:
                return "emf";
            case -4069:
                return "wmf";
            case -4068:
                return "pict";
            case -4067:
                return ContentTypes.EXTENSION_JPG_2;
            case -4066:
                return ContentTypes.EXTENSION_PNG;
            case -4065:
                return "dib";
            default:
                return "";
        }
    }

    @Override // org.apache.poi.ss.usermodel.PictureData
    public String getMimeType() {
        switch (this.blip.getRecordId()) {
            case -4070:
                return "image/x-emf";
            case -4069:
                return "image/x-wmf";
            case -4068:
                return "image/x-pict";
            case -4067:
                return ContentTypes.IMAGE_JPEG;
            case -4066:
                return ContentTypes.IMAGE_PNG;
            case -4065:
                return "image/bmp";
            default:
                return "image/unknown";
        }
    }

    @Override // org.apache.poi.ss.usermodel.PictureData
    public int getPictureType() {
        switch (this.blip.getRecordId()) {
            case -4070:
                return 2;
            case -4069:
                return 3;
            case -4068:
                return 4;
            case -4067:
                return 5;
            case -4066:
                return 6;
            case -4065:
                return 7;
            default:
                return -1;
        }
    }
}
